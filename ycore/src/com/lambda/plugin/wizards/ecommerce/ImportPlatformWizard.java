package com.lambda.plugin.wizards.ecommerce;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExecutableExtension;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IImportWizard;
import org.eclipse.ui.IWorkbench;

import com.lambda.plugin.YMessages;

public class ImportPlatformWizard extends AbstractWizard implements IExecutableExtension, IImportWizard {

	private static final String ECOMMERCE_PLATFORM_PROJECT_SECTION = "EcommercePlatformProjectImportWizard";//$NON-NLS-1$

	@SuppressWarnings("unused")
	private IConfigurationElement config;
	private ImportPlatformWizardPage page;

	public ImportPlatformWizard() {
		setNeedsProgressMonitor(true);
		setWindowTitle(YMessages.ImportPlatformWizard_title);
	}

	@Override
	protected String getSettingsSection() {
		return ECOMMERCE_PLATFORM_PROJECT_SECTION;
	}
	
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
		if (!page.isPageComplete()) {
			return false;
		}
		page.saveWidgetValues();
		final boolean res = doPerformFinish();
		return res;
	}

	@Override
	protected void finishPage(IProgressMonitor monitor) throws InterruptedException, CoreException {
		page.createExtensions(monitor);
	}

}
