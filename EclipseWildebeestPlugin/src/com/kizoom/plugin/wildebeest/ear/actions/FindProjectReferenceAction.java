package com.kizoom.plugin.wildebeest.ear.actions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultPage;
import org.eclipse.search.ui.ISearchResultViewPart;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.search.ui.text.AbstractTextSearchResult;
import org.eclipse.search.ui.text.Match;
import org.eclipse.team.internal.ccvs.core.CVSException;
import org.eclipse.team.internal.ccvs.core.CVSTag;
import org.eclipse.team.internal.ccvs.core.CVSTeamProvider;
import org.eclipse.team.internal.ccvs.core.ICVSFile;
import org.eclipse.team.internal.ccvs.core.ICVSFolder;
import org.eclipse.team.internal.ccvs.core.ICVSRemoteFolder;
import org.eclipse.team.internal.ccvs.core.ICVSRemoteResource;
import org.eclipse.team.internal.ccvs.core.ICVSRepositoryLocation;
import org.eclipse.team.internal.ccvs.core.resources.RemoteFile;

import com.kizoom.plugin.ExceptionHandler;
import com.kizoom.plugin.KizoomPlugin;
import com.kizoom.plugin.ui.SearchResult;
import com.kizoom.plugin.wildebeest.WildebeestPlugin;
import com.kizoom.plugin.wildebeest.preferences.PreferenceConstants;
import com.kizoom.plugin.wildebeest.team.JBossClasspathReader;
import com.kizoom.plugin.wildebeest.team.ProjectSetReader;

@SuppressWarnings("restriction")
public class FindProjectReferenceAction extends BaseCVSAction {

	public static final String ID = "com.kizoom.plugin.wildebeest.findProjectReference";

	public void run(IAction action) {
		if (getSelection() instanceof IStructuredSelection) {
			Object first = ((IStructuredSelection) getSelection())
					.getFirstElement();
			NewSearchUI.activateSearchResultView();
			ISearchResultViewPart view = NewSearchUI.getSearchResultView();
			ISearchResultPage activePage = view.getActivePage();
			if (activePage != null) {
				
				final IProject project = getProject(first);
				final CVSTeamProvider provider = getProjectProvider(first);
				if (provider == null) {
					MessageDialog.openInformation(getShell(),
							"CVS project references",
							"No CVS location has been found for selected project.");
					return;
				}
	
				ISearchQuery query = createQuery(provider, project);
				activePage.setInput(query.getSearchResult(), null);
				NewSearchUI.runQueryInBackground(query, view);
			}			
		}
	}
	
	private ISearchQuery createQuery(final CVSTeamProvider provider, final IProject project) {
		final boolean useAllEarsFile = WildebeestPlugin.getDefault().getPreferenceStore().getBoolean(PreferenceConstants.P_USE_ALL_EARS_PSF_FILE);
		final String templateEar = WildebeestPlugin.getDefault().getPreferenceStore().getString(PreferenceConstants.P_CVS_EAR_TEMPLATE_PROJECT);
		return new ISearchQuery() {
			private AbstractTextSearchResult searchResult = new SearchResult(this, "Projects that depend on '"+ project.getName() + "' project"){
				@Override
				public Object[] getElements() {
					Object[] elements = super.getElements();
					
					Arrays.sort(elements, new Comparator<Object>(){
						public int compare(Object o1, Object o2) {
							if (o1 instanceof ICVSFolder && o2 instanceof ICVSFolder) {
								return ((ICVSFolder)o1).getName().compareTo(((ICVSFolder)o2).getName());
							}
							return 0;
						}
					});
					return elements;
				}
			};
			
			public IStatus run(IProgressMonitor monitor) throws OperationCanceledException {
				ICVSRepositoryLocation loc = null;
				try {
					loc = provider.getCVSWorkspaceRoot().getRemoteLocation();
					if (useAllEarsFile){
						monitor.beginTask(getLabel(), 100);

						ICVSRemoteFolder remoteTemplateEar = loc.getRemoteFolder(templateEar, CVSTag.DEFAULT);
						if (remoteTemplateEar != null && remoteTemplateEar.exists()){
							remoteTemplateEar.fetchChildren(null);
							ICVSFile file = remoteTemplateEar.getFile("AllEars.psf");
							if (file instanceof RemoteFile && file.exists()){
								monitor.subTask("Analysing projectSet.psf files...");
								Set<String> projectNames = getProjectNames(project, 
										(RemoteFile)file, loc, new SubProgressMonitor(monitor, 40, SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK));
								if (projectNames == null){
									return Status.CANCEL_STATUS;
								}
								IProgressMonitor subMonitor = new SubProgressMonitor(monitor, 60, SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK);
								try {
									monitor.subTask("Analysing jboss.classpath files...");
									subMonitor.beginTask(getLabel(), projectNames.size());
									for (String name : projectNames) {
										if (subMonitor.isCanceled()) {
											return Status.CANCEL_STATUS;
										}
										ICVSRemoteFolder remoteProject = loc.getRemoteFolder(name, CVSTag.DEFAULT);
										if (remoteProject != null && remoteProject.exists()){
											checkReference(remoteProject, project.getName());	
										}
										subMonitor.worked(1);
									}
								} finally {
									subMonitor.done();
								}
							}
						}
					}else {
						ICVSRemoteResource[] members = loc.members(CVSTag.DEFAULT, false, null);
						
						monitor.beginTask(getLabel(), members.length);
						String projectName = project.getName();
					
						for (ICVSRemoteResource remoteResource : members) {
							if (monitor.isCanceled()) {
								return Status.CANCEL_STATUS;
							}
							if (remoteResource.exists() && remoteResource.isFolder() && 
									!projectName.equals(remoteResource.getName())) {
								checkReference((ICVSRemoteFolder)remoteResource, projectName);
							}
							monitor.worked(1);
						}
					}
					return Status.OK_STATUS;
				} catch (Exception e) {
					ExceptionHandler.handle(e, getShell(), "Project references in CVS", "There were problems during finding cvs references.");
					return new Status(IStatus.ERROR, WildebeestPlugin.PLUGIN_ID, e
							.getMessage());
				} finally {
					monitor.done();
				}
			}

			private void checkReference(ICVSRemoteFolder remoteProject,
					String projectName) {
				try {
					remoteProject.fetchChildren(null);
					ICVSFile jbossClasspathFile = remoteProject.getFile("jboss.classpath");
					if (jbossClasspathFile instanceof RemoteFile && jbossClasspathFile.exists()){
					SortedSet<String> projectEntries = new JBossClasspathReader(((RemoteFile)jbossClasspathFile).getContents(new NullProgressMonitor())).getProjectEntries();
					if (projectEntries.contains(projectName)) {
						searchResult.addMatch(new Match(jbossClasspathFile.getParent(), 0, jbossClasspathFile.getParent().getName().length()));
					}
					}
				}catch(Exception e) {
					//do nothing
				}
			}

			private Set<String> getProjectNames(final IProject project, RemoteFile file, ICVSRepositoryLocation loc, IProgressMonitor monitor) throws CVSException, Exception {
				try {
					SortedSet<String> projectNames = new TreeSet<String>();
					SortedSet<String> earNames = new ProjectSetReader(file.getContents(new NullProgressMonitor())).getProjectNames();
					monitor.beginTask("", earNames.size());
					for (String name : earNames) {
						try {
							if (monitor.isCanceled()){
								return null;
							}
							ICVSRemoteFolder earProject = loc.getRemoteFolder(name, CVSTag.DEFAULT);
							if (earProject != null && earProject.exists()){
								earProject.fetchChildren(null);
								ICVSFile psfFile = earProject.getFile("projectSet.psf");
								if (psfFile instanceof RemoteFile && psfFile.exists()){
									SortedSet<String> prjNames = new ProjectSetReader(((RemoteFile)psfFile).getContents(new NullProgressMonitor())).getProjectNames();
									if (prjNames.contains(project.getName())){
										projectNames.addAll(prjNames);
									}
								}
							}
						}catch(Exception e) {
							KizoomPlugin.logError(e);
						}
						monitor.worked(1);
					}
					projectNames.remove(project.getName());
					return projectNames;
				}finally {
					monitor.done();
				}
			}

			public ISearchResult getSearchResult() {
				return searchResult;
			}

			public String getLabel() {
				return "Searching for project references in CVS...";
			}

			public boolean canRerun() {
				return true;
			}

			public boolean canRunInBackground() {
				return true;
			}
		};
	}
}
