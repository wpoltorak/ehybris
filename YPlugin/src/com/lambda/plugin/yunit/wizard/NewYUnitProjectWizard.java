package com.lambda.plugin.yunit.wizard;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.internal.ui.wizards.NewElementWizard;
import org.eclipse.jdt.ui.IPackagesViewPart;
import org.eclipse.jdt.ui.actions.ShowInPackageViewAction;
import org.eclipse.jdt.ui.wizards.NewJavaProjectWizardPageOne;
import org.eclipse.jdt.ui.wizards.NewJavaProjectWizardPageTwo;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.wizards.newresource.BasicNewProjectResourceWizard;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;

import com.lambda.plugin.ExceptionHandler;
import com.lambda.plugin.YPlugin;
import com.lambda.plugin.images.YPluginImages;

@SuppressWarnings("restriction")
public class NewYUnitProjectWizard extends NewElementWizard implements IExecutableExtension {

    private static final String FUNCTEST_TEMPLATE_NAME = "functest";
    private NewJavaProjectWizardPageOne fFirstPage;
    private NewJavaProjectWizardPageTwo fSecondPage;

    private IConfigurationElement fConfigElement;
    private IWorkbench fWorkbench;
    private IStructuredSelection fSelection;

    public NewYUnitProjectWizard() {
        this(null, null);
    }

    public NewYUnitProjectWizard(final NewJavaProjectWizardPageOne pageOne, final NewJavaProjectWizardPageTwo pageTwo) {
        setDefaultPageImageDescriptor(YPluginImages.DESC_NEW_FUNCTEST_PRJ_WIZ);
        setDialogSettings(YPlugin.getDefault().getDialogSettings());
        setWindowTitle("New Functest Project");

        fFirstPage = pageOne;
        fSecondPage = pageTwo;
    }

    private IWorkbenchPage getActivePage() {
        final IWorkbenchWindow window = fWorkbench.getActiveWorkbenchWindow();
        if (window == null) {
            return null;
        }
        return window.getActivePage();
    }

    /**
     * Returns the scheduling rule for creating the element.
     * 
     * @return returns the scheduling rule
     */
    @Override
    protected ISchedulingRule getSchedulingRule() {
        return ResourcesPlugin.getWorkspace().getRoot(); // look all by default
    }

    @Override
    protected void openResource(final IFile resource) {
        final IWorkbenchPage activePage = getActivePage();
        if (activePage != null) {
            final Display display = getShell().getDisplay();
            if (display != null) {
                display.asyncExec(new Runnable() {
                    public void run() {
                        try {
                            IDE.openEditor(activePage, resource, true);
                        } catch (final PartInitException e) {
                            YPlugin.logError(e);
                        }
                    }
                });
            }
        }
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
            fFirstPage.setTitle("Create a Functest Project");
            fFirstPage.setDescription("Create a Functest project in the workspace or in an external location.");
        }
        addPage(fFirstPage);

        if (fSecondPage == null) {
            fSecondPage = new NewJavaProjectWizardPageTwo(fFirstPage);
        }
        addPage(fSecondPage);

        fFirstPage.init(getSelection(), getActivePart());
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jdt.internal.ui.wizards.NewElementWizard#finishPage(org.eclipse .core.runtime.IProgressMonitor)
     */
    @Override
    protected void finishPage(final IProgressMonitor monitor) throws InterruptedException, CoreException {
        fSecondPage.performFinish(monitor); // use the full progress monitor

        try {
            final IJavaProject javaProject = getCreatedElement();
            if (javaProject != null) {
                final IProject project = javaProject.getProject();
                YPlugin.getDefault().getTemplateManager()
                        .createTemplateFiles(YPlugin.getDefault().getBundle(), FUNCTEST_TEMPLATE_NAME, project, monitor);
                YPlugin.getDefault().getFunctestManager().addFunctestNature(project, monitor);
            }
        } catch (final CoreException e) {
            ExceptionHandler.handle(e, getShell(), "Error", "Couldn't set Functest Nature");
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.wizard.IWizard#performFinish()
     */
    @Override
    public boolean performFinish() {
        final boolean res = super.performFinish();
        if (res) {
            final IJavaProject newElement = getCreatedElement();

            final IWorkingSet[] workingSets = fFirstPage.getWorkingSets();
            if (workingSets.length > 0) {
                PlatformUI.getWorkbench().getWorkingSetManager().addToWorkingSets(newElement, workingSets);
            }

            BasicNewProjectResourceWizard.updatePerspective(fConfigElement);
            selectAndReveal(fSecondPage.getJavaProject().getProject());

            Display.getDefault().asyncExec(new Runnable() {
                public void run() {
                    final IWorkbenchPart activePart = getActivePart();
                    if (activePart instanceof IPackagesViewPart) {
                        (new ShowInPackageViewAction(activePart.getSite())).run(newElement);
                    }
                }
            });
        }
        return res;
    }

    private IWorkbenchPart getActivePart() {
        final IWorkbenchWindow activeWindow = YPlugin.getActiveWorkbenchWindow();
        if (activeWindow != null) {
            final IWorkbenchPage activePage = activeWindow.getActivePage();
            if (activePage != null) {
                return activePage.getActivePart();
            }
        }
        return null;
    }

    @Override
    protected void handleFinishException(final Shell shell, final InvocationTargetException e) {
        final String title = "Error Creating Functest Project";
        final String message = "An error occurred while creating the Functest project";
        com.lambda.plugin.ExceptionHandler.handle(e, getShell(), title, message);
    }

    /*
     * Stores the configuration element for the wizard. The config element will be used in <code>performFinish</code> to set the result
     * perspective.
     */
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
    @Override
    public IJavaProject getCreatedElement() {
        return fSecondPage.getJavaProject();
    }

    @Override
    public void init(final IWorkbench workbench, final IStructuredSelection currentSelection) {
        fWorkbench = workbench;
        fSelection = currentSelection;
    }

    @Override
    public IStructuredSelection getSelection() {
        return fSelection;
    }

    @Override
    protected void selectAndReveal(final IResource newResource) {
        BasicNewResourceWizard.selectAndReveal(newResource, fWorkbench.getActiveWorkbenchWindow());
    }
}
