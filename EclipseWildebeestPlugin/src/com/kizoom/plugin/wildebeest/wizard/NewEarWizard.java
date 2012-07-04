package com.kizoom.plugin.wildebeest.wizard;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.team.internal.ccvs.core.CVSException;
import org.eclipse.team.internal.ccvs.core.CVSTag;
import org.eclipse.team.internal.ccvs.core.ICVSFile;
import org.eclipse.team.internal.ccvs.core.ICVSFolder;
import org.eclipse.team.internal.ccvs.core.ICVSRemoteFolder;
import org.eclipse.team.internal.ccvs.core.ICVSRepositoryLocation;
import org.eclipse.team.internal.ccvs.core.ICVSResourceVisitor;
import org.eclipse.team.internal.ccvs.core.resources.CVSWorkspaceRoot;
import org.eclipse.team.internal.ccvs.core.resources.RemoteFile;
import org.eclipse.team.internal.ui.wizards.ImportProjectSetOperation;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;

import com.kizoom.plugin.KizoomPlugin;
import com.kizoom.plugin.wildebeest.WildebeestPlugin;
import com.kizoom.plugin.wildebeest.ear.Ear;
import com.kizoom.plugin.wildebeest.ear.IEar;
import com.kizoom.plugin.wildebeest.ear.IEarManager;
import com.kizoom.plugin.wildebeest.ear.navigator.IEarRoot;
import com.kizoom.plugin.wildebeest.image.WildebeestPluginImages;

@SuppressWarnings("restriction")
public class NewEarWizard extends Wizard implements INewWizard {

	private NewEarWizardPage page;
	private IProject project;
	private IEarManager earManager;

	public NewEarWizard() {
		super();
		setNeedsProgressMonitor(true);
		setDefaultPageImageDescriptor(WildebeestPluginImages.DESC_NEW_EAR_WIZ);
		earManager = WildebeestPlugin.getDefault().getEarManager();
	}

	@Override
	public void addPages() {
		page = new NewEarWizardPage();
		addPage(page);
	}

	@Override
	public boolean canFinish() {
		return earManager.getActiveEar() == null;
	}

	@Override
	public boolean performFinish() {
		final String earName = page.getEarName();
		IRunnableWithProgress op = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) throws InvocationTargetException {
				try {
					doFinish(earName, monitor);
				} catch (CoreException e) {
					throw new InvocationTargetException(e);
				} finally {
					monitor.done();
				}
			}
		};
		try {
			getContainer().run(true, false, op);
		} catch (InterruptedException e) {
			return false;
		} catch (InvocationTargetException e) {
			Throwable realException = e.getTargetException();
			MessageDialog.openError(getShell(), "Error", realException.getMessage());
			return false;
		}
		return true;
	}

	/**
	 * The worker method. It will find the container, create the file if missing
	 * or just replace its contents, and open the editor on the newly created
	 * file.
	 */

	private void doFinish(String earName, IProgressMonitor monitor) throws CoreException {
		monitor.beginTask("Creating " + earName, 2);
		project = ResourcesPlugin.getWorkspace().getRoot().getProject(earName);

		if (project.exists())
			throw new IllegalStateException("Something is fucked up");

		if (!project.exists()) {
			IProjectDescription desc = project.getWorkspace().newProjectDescription(project.getName());
			desc.setLocationURI(project.getLocationURI());
			project.create(desc, monitor);
		}

		if (!project.isOpen()) {
			project.open(monitor);
		}
		configure(project, new SubProgressMonitor(monitor, 1));
	}

	private void copyTemplateResources(final IProject project, IProgressMonitor monitor) {
		final ICVSRepositoryLocation location = page.getLocation();
		String projectName = page.getTemplateName();
		if (location != null && projectName != null) {
			try {
				ICVSRemoteFolder remoteResource = location.getRemoteFolder(projectName, CVSTag.DEFAULT);
				ICVSResourceVisitor visitor = new CVSReferencesResourceVisitor(remoteResource, project);
				if (remoteResource != null && remoteResource.exists()) {
					remoteResource.accept(visitor, true);
				}
			} catch (Exception e) {
				MessageDialog.openInformation(getShell(), "New Ear project",
						"There were problems during copying template files.");
				KizoomPlugin.logError(e);
			}
		}
	}

	private void checkoutProjects(IProject project, IProgressMonitor monitor) throws InvocationTargetException,
			InterruptedException {
		IFile psFile = project.getFile("projectSet.psf");

		if (psFile.exists() && page.importProjectSet()) {
			ImportProjectSetOperation op = new ImportProjectSetOperation(null, psFile.getLocation().toOSString(), null);
			op.run();
		}
	}

	private class CVSReferencesResourceVisitor implements ICVSResourceVisitor {
		private final IProject project;
		private IEar ear;
		private EarTemplate earTemplate;

		public CVSReferencesResourceVisitor(ICVSFolder cvsProject, IProject project) {
			this.project = project;
			this.ear = WildebeestPlugin.getDefault().getEarManager().getActiveEar();
			this.earTemplate = new EarTemplate(cvsProject);
		}

		public void visitFolder(ICVSFolder folder) throws CVSException {
			folder.fetchChildren(null);

			if (folder.getParent() != null) {
				String path = folder.getRelativePath(earTemplate.getCvsProject());
				IFolder f = project.getFolder(path);
				if (!f.exists()) {
					try {
						f.create(true, true, null);
					} catch (CoreException e) {
						throw new CVSException(e);
					}
				}
			}
		}

		public void visitFile(ICVSFile file) throws CVSException {
			String path = file.getRelativePath(earTemplate.getCvsProject());
			IFile f = project.getFile(path);
			if (!f.exists()) {
				String content;
				try {
					content = replacePlaceholders(getContents(file), project);
					ByteArrayInputStream in = new ByteArrayInputStream(content.getBytes());
					f.create(in, IResource.FORCE, null);
				} catch (CoreException e) {
					throw new CVSException(e);
				}
			}
		}

		private String replacePlaceholders(String contents, IProject project) {
			contents = contents.replaceAll(earTemplate.getName(), ear.getName());
			contents = contents.replaceAll(earTemplate.getPrefix() + " EAR", ear.getPrefix() + " EAR");
			contents = contents.replaceAll(earTemplate.getPrefix(), ear.getPrefix());
			return contents;
		}

		private String getContents(ICVSFile file) throws CoreException {
			StringBuilder contents = new StringBuilder();
			try {
				RemoteFile rFile = (RemoteFile) CVSWorkspaceRoot.getRemoteResourceFor(file);
				BufferedReader input = new BufferedReader(new InputStreamReader(rFile.getContents(new NullProgressMonitor())));
				try {
					String line = null;
					while ((line = input.readLine()) != null) {
						contents.append(line);
						contents.append(System.getProperty("line.separator"));
					}
				} finally {
					input.close();
				}
			} catch (IOException ex) {
				throw new CoreException(new Status(IStatus.WARNING, KizoomPlugin.PLUGIN_ID, "'" + file.getName()
						+ "' file content couldn't be retrieved."));
			}
			return contents.toString();
		}
	}

	private void configure(final IProject project, final IProgressMonitor monitor) throws CoreException {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				try {
					addEarNature(project, monitor);
					copyTemplateResources(project, monitor);
					checkoutProjects(project, monitor);
				} catch (Exception e) {
					KizoomPlugin.logError(e);
				} finally {
					monitor.worked(1);
				}
			}
		});
	}

	private void addEarNature(IProject project, IProgressMonitor monitor) throws CoreException {
		if (monitor != null && monitor.isCanceled()) {
			throw new OperationCanceledException();
		}

		if (!earManager.hasEarNature(project)) {
			earManager.addEarNature(project, monitor);
		}
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
	}

	private class EarTemplate extends Ear {

		private final ICVSFolder cvsProject;

		public EarTemplate(ICVSFolder cvsProject) {
			this.cvsProject = cvsProject;
		}

		ICVSFolder getCvsProject() {
			return cvsProject;
		}

		@Override
		public String getName() {
			return cvsProject.getName();
		}

		@Override
		public void addProject(IProject project) {
			throw new UnsupportedOperationException("not implemented");
		}

		@Override
		public IEarRoot getParent() {
			throw new UnsupportedOperationException("not implemented");
		}

		@Override
		public IProject getProject(String name) {
			throw new UnsupportedOperationException("not implemented");
		}

		@Override
		public IFile getProjectSet() {
			throw new UnsupportedOperationException("not implemented");
		}

		@Override
		public IProject[] getProjects() {
			throw new UnsupportedOperationException("not implemented");
		}

		@Override
		public boolean hasProject(String name) {
			throw new UnsupportedOperationException("not implemented");
		}

		@Override
		public boolean isEmpty() {
			throw new UnsupportedOperationException("not implemented");
		}

		@Override
		public boolean isOpen() {
			throw new UnsupportedOperationException("not implemented");
		}

		@Override
		public IProject removeProject(String name) {
			throw new UnsupportedOperationException("not implemented");
		}

		@Override
		public void updateProjects() {
			throw new UnsupportedOperationException("not implemented");

		}

		@SuppressWarnings("unchecked")
		@Override
		public Object getAdapter(Class adapter) {
			throw new UnsupportedOperationException("not implemented");
		}
	}
}