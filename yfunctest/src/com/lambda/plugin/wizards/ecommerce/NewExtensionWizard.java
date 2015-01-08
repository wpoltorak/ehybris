package com.lambda.plugin.wizards.ecommerce;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.ui.IPackagesViewPart;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
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

import com.lambda.plugin.YImages;
import com.lambda.plugin.YMessages;
import com.lambda.plugin.YPlugin;

public class NewExtensionWizard extends AbstractWizard implements IExecutableExtension, INewWizard {

    private final NewExtensionWizardPage wizardPage;

    private IConfigurationElement fConfigElement;
    private IWorkbench fWorkbench;
    private IStructuredSelection fSelection;

    public NewExtensionWizard() {
        setDefaultPageImageDescriptor(YImages.DESC_NEW_FUNCTEST_PRJ_WIZ);
        setDialogSettings(YPlugin.getDefault().getDialogSettings());
        setWindowTitle(YMessages.NewExtensionProject_title);
        setNeedsProgressMonitor(true);

        wizardPage = new NewExtensionWizardPage();
    }

    protected void openResource(final IFile resource) {
        final IWorkbenchPage activePage = YPlugin.getActivePage();
        if (activePage != null) {
            final Display display = getShell().getDisplay();
            if (display != null) {
                display.asyncExec(new Runnable() {
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

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.wizard.Wizard#addPages()
     */
    @Override
    public void addPages() {
        addPage(wizardPage);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jdt.internal.ui.wizards.NewElementWizard#finishPage(org.eclipse .core.runtime.IProgressMonitor)
     */
    @Override
    protected void finishPage(final IProgressMonitor monitor) throws InterruptedException, CoreException {
        wizardPage.performFinish(monitor); // use the full progress monitor
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

            final IWorkingSet[] workingSets = wizardPage.getWorkingSets();
            if (workingSets.length > 0) {
                PlatformUI.getWorkbench().getWorkingSetManager().addToWorkingSets(newElement, workingSets);
            }

            BasicNewProjectResourceWizard.updatePerspective(fConfigElement);
            selectAndReveal(wizardPage.getJavaProject().getProject());

            Display.getDefault().asyncExec(new Runnable() {
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

    /*
     * Stores the configuration element for the wizard. The config element will be used in <code>performFinish</code> to
     * set the result perspective.
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
        wizardPage.performCancel();
        return super.performCancel();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jdt.internal.ui.wizards.NewElementWizard#getCreatedElement()
     */
    public IJavaProject getCreatedElement() {
        return wizardPage.getJavaProject();
    }

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
