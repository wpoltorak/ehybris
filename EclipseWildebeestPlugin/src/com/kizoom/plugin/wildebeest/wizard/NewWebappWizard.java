package com.kizoom.plugin.wildebeest.wizard;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWizard;

import com.kizoom.plugin.KizoomPlugin;
import com.kizoom.plugin.wildebeest.WildebeestPlugin;
import com.kizoom.plugin.wildebeest.ear.IEarManager;
import com.kizoom.plugin.wildebeest.image.WildebeestPluginImages;

public class NewWebappWizard extends Wizard implements INewWizard {

	private static final String EAR_TEMPLATE_NAME = "ear";
	private NewEarWizardPage page;
	@SuppressWarnings("unused")
	private IWorkbench workbench;
	@SuppressWarnings("unused")
	private ISelection selection;
	private IProject project;
	private IEarManager earManager;

	/**
	 * Constructor for NewEarWizard.
	 */
	public NewWebappWizard() {
		super();
		setNeedsProgressMonitor(true);
		setDefaultPageImageDescriptor(WildebeestPluginImages.DESC_NEW_WAPP_WIZ);
		earManager = WildebeestPlugin.getDefault().getEarManager();
	}

	/**
	 * Adding the page to the wizard.
	 */

	@Override
	public void addPages() {
		page = new NewEarWizardPage();
		addPage(page);
	}

	/**
	 * This method is called when 'Finish' button is pressed in the wizard. We
	 * will create an operation and run it using wizard as execution context.
	 */
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
		// create a sample file
		monitor.beginTask("Creating " + earName, 2);
		project = ResourcesPlugin.getWorkspace().getRoot().getProject(earName);
		// project = createNewProject(earName);

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

		// final IEar ear = earManager.createEar(project);
		monitor.worked(1);
		// TODO KizoomPlugin: show ear either in pkgepl ore earexpl
		// Display.getDefault().asyncExec(new Runnable() {
		// public void run() {
		// IWorkbenchPart activePart = getActivePart();
		// if (activePart instanceof EarNavigator) {
		// (new ShowInEarViewAction(activePart.getSite())).run(ear);
		// }
		// }
		// });

		// monitor.setTaskName("Opening file for editing...");
		// getShell().getDisplay().asyncExec(new Runnable() {
		// public void run() {
		// IWorkbenchPage page =
		// PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		// try {
		// IDE.openEditor(page, file, true);
		// } catch (PartInitException e) {
		// }
		// }
		// });
		// monitor.worked(1);
	}

	// private IProject createNewProject(String earName) {
	// if (project != null) {
	// return project;
	// }
	//
	// // get a project handle
	// final IProject newProjectHandle =
	// ResourcesPlugin.getWorkspace().getRoot().getProject(earName);
	//
	// IWorkspace workspace = ResourcesPlugin.getWorkspace();
	// final IProjectDescription description =
	// workspace.newProjectDescription(newProjectHandle.getName());
	//
	// // create the new project operation
	// IRunnableWithProgress op = new IRunnableWithProgress() {
	// public void run(IProgressMonitor monitor) throws
	// InvocationTargetException
	// {
	// CreateProjectOperation op = new CreateProjectOperation(description,
	// ResourceMessages.NewProject_windowTitle);
	// try {
	// PlatformUI.getWorkbench().getOperationSupport().getOperationHistory().execute
	// (op, monitor,
	// WorkspaceUndoUtil.getUIInfoAdapter(getShell()));
	// } catch (ExecutionException e) {
	// throw new InvocationTargetException(e);
	// }
	// }
	// };
	//
	// // run the new project creation operation
	// try {
	// getContainer().run(true, true, op);
	// } catch (InterruptedException e) {
	// return null;
	// } catch (InvocationTargetException e) {
	// Throwable t = e.getTargetException();
	// if (t instanceof ExecutionException && t.getCause() instanceof
	// CoreException) {
	// CoreException cause = (CoreException) t.getCause();
	// StatusAdapter status;
	// if (cause.getStatus().getCode() == IResourceStatus.CASE_VARIANT_EXISTS) {
	// status = new StatusAdapter(StatusUtil.newStatus(IStatus.WARNING,
	// NLS.bind(
	// ResourceMessages.NewProject_caseVariantExistsError,
	// newProjectHandle.getName()), cause));
	// } else {
	// status = new
	// StatusAdapter(StatusUtil.newStatus(cause.getStatus().getSeverity(),
	// ResourceMessages.NewProject_errorMessage, cause));
	// }
	// status.setProperty(StatusAdapter.TITLE_PROPERTY,
	// ResourceMessages.NewProject_errorMessage);
	// StatusManager.getManager().handle(status, StatusManager.BLOCK);
	// } else {
	// StatusAdapter status = new StatusAdapter(new Status(IStatus.WARNING,
	// IDEWorkbenchPlugin.IDE_WORKBENCH, 0, NLS
	// .bind(ResourceMessages.NewProject_internalError, t.getMessage()), t));
	// status.setProperty(StatusAdapter.TITLE_PROPERTY,
	// ResourceMessages.NewProject_errorMessage);
	// StatusManager.getManager().handle(status, StatusManager.LOG |
	// StatusManager.BLOCK);
	// }
	// return null;
	// }
	//
	// project = newProjectHandle;
	//
	// return project;
	// }

	private void configure(IProject project, IProgressMonitor monitor) throws CoreException {
		addTemplateResources(project, monitor);

		addEarNature(project, monitor);
	}

	private void addTemplateResources(IProject project, IProgressMonitor monitor) throws CoreException {
		KizoomPlugin.getDefault().getTemplateManager().createTemplateFiles(WildebeestPlugin.getDefault().getBundle(),
				EAR_TEMPLATE_NAME, project, monitor);
	}

	private void addEarNature(IProject project, IProgressMonitor monitor) throws CoreException {
		if (monitor != null && monitor.isCanceled()) {
			throw new OperationCanceledException();
		}

		if (!earManager.hasEarNature(project))
			earManager.addEarNature(project, monitor);
	}

	/**
	 * We will accept the selection in the workbench to see if we can initialize
	 * from it.
	 * 
	 * @see IWorkbenchWizard#init(IWorkbench, IStructuredSelection)
	 */
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		this.selection = selection;
		this.workbench = workbench;
	}
}
