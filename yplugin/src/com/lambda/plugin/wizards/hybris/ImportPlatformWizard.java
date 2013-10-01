package com.lambda.plugin.wizards.hybris;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

public class ImportPlatformWizard extends Wizard implements IExecutableExtension, IImportWizard {

    private IConfigurationElement config;
    private ImportPlatformWizardPage page;

    public void init(IWorkbench workbench, IStructuredSelection selection) {

    }

    public void setInitializationData(IConfigurationElement config, String propertyName, Object data)
            throws CoreException {
        this.config = config;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.wizard.Wizard#addPages()
     */
    @Override
    public void addPages() {
        page = new ImportPlatformWizardPage();
        addPage(page);
    }

    @Override
    public boolean performFinish() {
        return false;
    }

}
