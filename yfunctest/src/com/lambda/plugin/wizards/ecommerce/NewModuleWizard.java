package com.lambda.plugin.wizards.ecommerce;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.ui.IPackagesViewPart;
import org.eclipse.jdt.ui.wizards.NewJavaProjectWizardPageOne;
import org.eclipse.jdt.ui.wizards.NewJavaProjectWizardPageTwo;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

import com.lambda.plugin.ExceptionHandler;
import com.lambda.plugin.YImages;
import com.lambda.plugin.YMessages;
import com.lambda.plugin.YNature;
import com.lambda.plugin.YPlugin;
import com.lambda.plugin.ui.WorkbenchRunnableAdapter;

public class NewModuleWizard extends Wizard implements IExecutableExtension, INewWizard {

    private NewJavaProjectWizardPageOne fFirstPage;
    private NewJavaProjectWizardPageTwo fSecondPage;

    private IConfigurationElement fConfigElement;
    private IWorkbench fWorkbench;
    private IStructuredSelection fSelection;

    public NewModuleWizard() {
        this(null, null);
    }

    public NewModuleWizard(final NewJavaProjectWizardPageOne pageOne, final NewJavaProjectWizardPageTwo pageTwo) {
        setDefaultPageImageDescriptor(YImages.DESC_NEW_FUNCTEST_PRJ_WIZ);
        setDialogSettings(YPlugin.getDefault().getDialogSettings());
        setWindowTitle("New Functest Project");
        setNeedsProgressMonitor(true);

        fFirstPage = pageOne;
        fSecondPage = pageTwo;
    }

    protected void openResource(final IFile resource) {
        final IWorkbenchPage activePage = YPlugin.getActivePage();
        if (activePage != null) {
            final Display display = getShell().getDisplay();
            if (display != null) {
                display.asyncExec(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            IDE.openEditor(activePage, resource, true);
                        } catch (PartInitException e) {
                            YPlugin.logError(e);
                        }
                    }
                });
            }
        }
    }

    /**
     * Returns the scheduling rule for creating the element.
     * 
     * @return returns the scheduling rule
     */
    protected ISchedulingRule getSchedulingRule() {
        return ResourcesPlugin.getWorkspace().getRoot(); // look all by default
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.wizard.Wizard#addPages()
     */
    @Override
    public void addPages() {
        if (fFirstPage == null) {
            fFirstPage = new NewJavaProjectWizardPageOne();
            fFirstPage.setTitle(YMessages.NewModulePage_title);
            fFirstPage.setDescription(YMessages.NewModulePage_description);
        }
        addPage(fFirstPage);

        if (fSecondPage == null) {
            fSecondPage = new NewJavaProjectWizardPageTwo(fFirstPage);
        }
        addPage(fSecondPage);

        fFirstPage.init(getSelection(), YPlugin.getActivePart());
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jdt.internal.ui.wizards.NewElementWizard#finishPage(org.eclipse .core.runtime.IProgressMonitor)
     */
    protected void finishPage(final IProgressMonitor monitor) throws InterruptedException, CoreException {
        fSecondPage.performFinish(monitor); // use the full progress monitor

        try {
            final IJavaProject javaProject = getCreatedElement();
            if (javaProject != null) {
                final IProject project = javaProject.getProject();
                YPlugin.getDefault().getNatureManager().addNature(YNature.NATURE_ID, project, monitor);
            }
        } catch (final CoreException e) {
            ExceptionHandler.handle(e, getShell(), "Error", "Couldn't set eCommerce Module Nature");
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.wizard.IWizard#performFinish()
     */
    @Override
    public boolean performFinish() {
        final boolean res = doPerformFinish();
        if (res) {
            final IJavaProject newElement = getCreatedElement();

            final IWorkingSet[] workingSets = fFirstPage.getWorkingSets();
            if (workingSets.length > 0) {
                PlatformUI.getWorkbench().getWorkingSetManager().addToWorkingSets(newElement, workingSets);
            }

            BasicNewProjectResourceWizard.updatePerspective(fConfigElement);
            selectAndReveal(fSecondPage.getJavaProject().getProject());

            Display.getDefault().asyncExec(new Runnable() {
                @Override
                public void run() {
                    final IWorkbenchPart activePart = YPlugin.getActivePart();
                    if (activePart instanceof IPackagesViewPart) {
                        // (new ShowInPackageViewAction(activePart.getSite())).run(newElement);
                    }
                }
            });
        }
        return res;
    }

    public boolean doPerformFinish() {
        final IWorkspaceRunnable op = new IWorkspaceRunnable() {
            @Override
            public void run(IProgressMonitor monitor) throws CoreException, OperationCanceledException {
                try {
                    finishPage(monitor);
                } catch (InterruptedException e) {
                    throw new OperationCanceledException(e.getMessage());
                }
            }
        };
        final ISchedulingRule rule = getCurrentSchedulingRule();

        try {
            IRunnableWithProgress runnable = null;
            if (rule != null) {
                runnable = new WorkbenchRunnableAdapter(op, rule, true);
            } else {
                runnable = new WorkbenchRunnableAdapter(op, getSchedulingRule());
            }

            getContainer().run(true, true, runnable);
        } catch (InvocationTargetException e) {
            handleFinishException(getShell(), e);
            return false;
        } catch (InterruptedException e) {
            return false;
        }
        return true;
    }

    private ISchedulingRule getCurrentSchedulingRule() {
        ISchedulingRule rule = null;
        Job job = Job.getJobManager().currentJob();
        if (job != null) {
            rule = job.getRule();
        }
        return rule;
    }

    protected void handleFinishException(final Shell shell, final InvocationTargetException e) {
        final String title = "Error Creating Functest Project";
        final String message = "An error occurred while creating the Functest project";
        com.lambda.plugin.ExceptionHandler.handle(e, getShell(), title, message);
    }

    /*
     * Stores the configuration element for the wizard. The config element will be used in <code>performFinish</code> to
     * set the result perspective.
     */
    @Override
    public void setInitializationData(final IConfigurationElement cfig, final String propertyName, final Object data) {
        fConfigElement = cfig;
    }

    /*
     * (non-Javadoc)
     * 
     * @see IWizard#performCancel()
     */
    @Override
    public boolean performCancel() {
        fSecondPage.performCancel();
        return super.performCancel();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jdt.internal.ui.wizards.NewElementWizard#getCreatedElement()
     */
    public IJavaProject getCreatedElement() {
        return fSecondPage.getJavaProject();
    }

    @Override
    public void init(final IWorkbench workbench, final IStructuredSelection currentSelection) {
        fWorkbench = workbench;
        fSelection = currentSelection;
    }

    public IStructuredSelection getSelection() {
        return fSelection;
    }

    protected void selectAndReveal(final IResource newResource) {
        BasicNewResourceWizard.selectAndReveal(newResource, fWorkbench.getActiveWorkbenchWindow());
    }
}
