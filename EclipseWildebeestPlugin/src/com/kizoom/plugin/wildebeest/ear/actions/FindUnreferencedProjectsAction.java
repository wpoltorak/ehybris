package com.kizoom.plugin.wildebeest.ear.actions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.search.ui.ISearchQuery;
import org.eclipse.search.ui.ISearchResult;
import org.eclipse.search.ui.ISearchResultPage;
import org.eclipse.search.ui.ISearchResultViewPart;
import org.eclipse.search.ui.NewSearchUI;
import org.eclipse.search.ui.text.AbstractTextSearchResult;
import org.eclipse.search.ui.text.Match;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.kizoom.plugin.ui.SearchResult;
import com.kizoom.plugin.wildebeest.WildebeestPlugin;
import com.kizoom.plugin.wildebeest.ear.Ear;
import com.kizoom.plugin.wildebeest.preferences.PreferenceConstants;
import com.kizoom.plugin.wildebeest.team.JBossClasspathReader;
import com.kizoom.plugin.wildebeest.webapp.WebappNature;

public class FindUnreferencedProjectsAction extends BaseWildebeestAction implements IObjectActionDelegate {

	public static final String ID = "com.kizoom.plugin.wildebeest.FindUnreferencedProjects";

	@Override
	protected String description() {
		return "Finding unreferenced ear projects...";
	}

	@Override
	protected void doExecute(ExecutionEvent event) throws Exception {
		search();
	}

	public void run(IAction action) {
		search();
	}

	private void search() {
		NewSearchUI.activateSearchResultView();
		ISearchResultViewPart view = NewSearchUI.getSearchResultView();

		ISearchResultPage activePage = view.getActivePage();
		if (activePage != null) {
			ISearchQuery query = createQuery();
			activePage.setInput(query.getSearchResult(), null);
			NewSearchUI.runQueryInBackground(query, view);
		}
	}

	private ISearchQuery createQuery() {
		return new ISearchQuery() {
			private AbstractTextSearchResult searchResult = new SearchResult(this, "Unreferenced ear projects"){
				@Override
				public Object[] getElements() {
					Object[] elements = super.getElements();
					
					Arrays.sort(elements, new Comparator<Object>(){
						public int compare(Object o1, Object o2) {
							if (o1 instanceof IProject && o2 instanceof IProject) {
								return ((IProject)o1).getName().compareTo(((IProject)o2).getName());
							}
							return 0;
						}
					});
					
					return elements;
				}
			};

			public IStatus run(IProgressMonitor monitor) throws OperationCanceledException {
				try {
					IProject[] projects = getActiveEar().getProjects();
					List<IProject> earProjects = new ArrayList<IProject>(Arrays.asList(projects));
					boolean showEar = WildebeestPlugin.getDefault().getPluginPreferences().getBoolean(PreferenceConstants.P_SHOW_UNREFERENCED_EAR_PROJECT);
					boolean showWebapps = WildebeestPlugin.getDefault().getPluginPreferences().getBoolean(PreferenceConstants.P_SHOW_UNREFERENCED_WEBAPP_PROJECTS);
					monitor.beginTask(getLabel(), earProjects.size());
					for (int i = 0, size = earProjects.size(); i < size; ++i) {
						IProject project = earProjects.get(i);
						if (!project.isOpen()){
							monitor.worked(1);
							continue;
						}
						
						if (!showEar && project.hasNature(Ear.NATURE_ID)){
							monitor.worked(1);
							continue;
						}
						if (!showWebapps && project.hasNature(WebappNature.NATURE_ID)){
							monitor.worked(1);
							continue;
						}
						
						boolean referenced = false;
						for (IProject prj : projects) {
							if (!prj.isOpen()){
								continue;
							}
							IFile file = prj.getFile("jboss.classpath");
							if (file.exists()) {
								try {
									SortedSet<String> projectEntries = new JBossClasspathReader(file.getContents()).getProjectEntries();
									
									if (projectEntries.contains(project.getName())) {
										referenced = true;
										break;
									}
								} catch (Exception e) {
									//do nothing
									System.out.println();
								}
							}
						}
						if (!referenced) {
							searchResult.addMatch(new Match(project, 0, project.getName().length()));
						}
						monitor.worked(1);
					}
				} catch (Exception e) {
					monitor.done();
					return Status.CANCEL_STATUS;
				}
				monitor.done();
				return Status.OK_STATUS;
			}

			public ISearchResult getSearchResult() {
				return searchResult;
			}

			public String getLabel() {
				return "Searching for unreferenced ear projects...";
			}

			public boolean canRerun() {
				return true;
			}

			public boolean canRunInBackground() {
				return true;
			}
		};
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	public void selectionChanged(IAction action, ISelection selection) {

	}
}
