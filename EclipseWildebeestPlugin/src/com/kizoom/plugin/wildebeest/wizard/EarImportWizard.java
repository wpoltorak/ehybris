/*******************************************************************************
 * Copyright (c) 2006 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package com.kizoom.plugin.wildebeest.wizard;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.team.core.TeamException;
import org.eclipse.team.internal.ccvs.core.ICVSRemoteFolder;
import org.eclipse.team.internal.ccvs.core.ICVSRepositoryLocation;
import org.eclipse.team.internal.ccvs.ui.CVSUIPlugin;
import org.eclipse.team.internal.ccvs.ui.operations.CheckoutSingleProjectOperation;
import org.eclipse.team.internal.ccvs.ui.operations.ProjectMetaFileOperation;
import org.eclipse.team.internal.ccvs.ui.wizards.ICVSWizard;
import org.eclipse.team.internal.ui.wizards.ImportProjectSetOperation;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkingSet;

import com.kizoom.plugin.ExceptionHandler;
import com.kizoom.plugin.KizoomPlugin;
import com.kizoom.plugin.wildebeest.image.WildebeestPluginImages;

@SuppressWarnings("restriction")
public class EarImportWizard extends Wizard implements ICVSWizard, INewWizard {

	private RepositorySelectionPage locationPage;
	private EarSelectionPage modulePage;
	private ICVSRepositoryLocation location;

	public EarImportWizard() {
		setWindowTitle("Checkout Ear project from CVS repository");
	}

	@Override
	public void addPages() {
		setNeedsProgressMonitor(true);

		ImageDescriptor substImage = getBannerImageDescriptor();

		ICVSRepositoryLocation[] locations = CVSUIPlugin.getPlugin().getRepositoryManager().getKnownRepositoryLocations();
		if (locations.length > 0) {
			locationPage = new RepositorySelectionPage(
					"locationSelection", "Checkout Ear project from CVS repository", substImage); //$NON-NLS-1$ 
			locationPage.setDescription("Select an existing repository location.");
			addPage(locationPage);
		}

		modulePage = new EarSelectionPage("earSelection", "Select Ear", substImage); //$NON-NLS-1$ 
		modulePage.setDescription("Select the Ear to be checked out from CVS");
		modulePage.setSupportsMultiSelection(false);
		addPage(modulePage);

	}

	protected ImageDescriptor getBannerImageDescriptor() {
		return WildebeestPluginImages.DESC_IMPORT_EAR_WIZ;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#canFinish()
	 */
	@Override
	public boolean canFinish() {
		return getSelectedModule() != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.IWizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		try {
			final ICVSRemoteFolder module = getSelectedModule();
			final boolean importProjectSet = modulePage.importProjectSet();
			CheckoutSingleProjectOperation checkoutOperation = new CheckoutSingleProjectOperation(getPart(), module, null, null, true){
				@Override
				public void done(IJobChangeEvent event) {
					super.done(event);
					IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(module.getName());

					if (importProjectSet){
						IFile psFile = project.getFile("projectSet.psf");
						if (psFile.exists()) {
							ImportProjectSetOperation op = new ImportProjectSetOperation(null, psFile.getLocation().toOSString(), new IWorkingSet[0]);
							try {
								op.run();
							} catch (Exception e) {
								ExceptionHandler.handle(e, getShell(), "Error", e.getMessage());
							}
						}
					}
				}
			};
			checkoutOperation.run();
			
			return true;
		} catch (Exception e) {
			ExceptionHandler.handle(e, getShell(), "Error", e.getMessage());
		} 
		return false;
	}

	private IWorkbenchPart getPart() {
		// This wizard doesn't have a part
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.jface.wizard.Wizard#performCancel()
	 */
	@Override
	public boolean performCancel() {
		return true;
	}

	@Override
	public IWizardPage getNextPage(IWizardPage page) {
		// Assume the page is about to be shown when this method is
		// invoked
		return getNextPage(page, true);
	}

	public IWizardPage getNextPage(IWizardPage page, boolean aboutToShow) {
		if (page == locationPage) {
			if (aboutToShow) {
				try {
					modulePage.setLocation(getLocation());
				} catch (TeamException e1) {
					KizoomPlugin.logError(e1);
				}
			}
			return modulePage;
		}
		if (page == modulePage) {
			ICVSRemoteFolder module = getSelectedModule();

			if (module == null || module.isDefinedModule()) {
				return null;
			}

			if (aboutToShow) {
				try {
					boolean hasMetafile = true;
					// Only allow configuration if one module is selected
					final ICVSRemoteFolder[] folders = new ICVSRemoteFolder[] { module };
					final boolean withName = CVSUIPlugin.getPlugin().isUseProjectNameOnCheckout();

					// attempt to retrieve the project description depending on
					// preferences
					// this is a bit convoluted to batch the meta-file check and
					// retrieval in one operation
					final ICVSRemoteFolder[] folderResult = new ICVSRemoteFolder[1];
					final boolean[] booleanResult = new boolean[] { true };

					getContainer().run(true, true, new IRunnableWithProgress() {
						public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
							ProjectMetaFileOperation op = new ProjectMetaFileOperation(getPart(),
									new ICVSRemoteFolder[] { folders[0] }, withName);
							op.run(monitor);
							folderResult[0] = op.getUpdatedFolders()[0];
							booleanResult[0] = op.metaFileExists();
						}
					});
					hasMetafile = booleanResult[0];
					if (withName && hasMetafile)
						module = folderResult[0];
				} catch (InvocationTargetException e) {
					// Show the error and fall through to return null as the next page
					ExceptionHandler.handle(e, getShell(), "Error", e.getMessage());
				} catch (InterruptedException e) {
					// Canceled by user. Fall through and return null
				}
				return null;
			}
		}
		return null;
	}

	private ICVSRemoteFolder getSelectedModule() {
		if (modulePage == null)
			return null;
		return modulePage.getSelectedModule();
	}

	/**
	 * Return an ICVSRepositoryLocation
	 */
	private ICVSRepositoryLocation getLocation() throws TeamException {
		// If the location page has a location, use it.
		ICVSRepositoryLocation newLocation = locationPage.getLocation();
		return recordLocation(newLocation);
	}

	private ICVSRepositoryLocation recordLocation(ICVSRepositoryLocation newLocation) {
		if (location == null || !newLocation.equals(location)) {
			location = newLocation;
		}
		return location;
	}

	public void init(IWorkbench workbench, IStructuredSelection selection) {
	}
}
