package com.kizoom.plugin.wildebeest.wizard;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.team.internal.ccvs.core.CVSException;
import org.eclipse.team.internal.ccvs.core.CVSTag;
import org.eclipse.team.internal.ccvs.core.ICVSRemoteFolder;
import org.eclipse.team.internal.ccvs.core.ICVSRepositoryLocation;
import org.eclipse.team.internal.ccvs.ui.model.RemoteContentProvider;
import org.eclipse.team.internal.ccvs.ui.repo.RepositoryComparator;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import com.kizoom.plugin.ExceptionHandler;
import com.kizoom.plugin.wildebeest.WildebeestPlugin;

@SuppressWarnings("restriction")
public class EarSelectionPage extends WizardPage {
	TreeViewer moduleList;
	String moduleName;

	private ICVSRepositoryLocation location;
	private boolean badLocation = false;
	private boolean supportsMultiSelection;

	private boolean isFetchingModules = false;
	private Object fetchingModulesLock = new Object();
	private Button importProjectSet;

	public EarSelectionPage(String pageName, String title, ImageDescriptor titleImage) {
		super(pageName, title, titleImage);
	}

	public void createControl(Composite parent) {
		final Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

		moduleList = createModuleTree(composite, 2);

		importProjectSet = new Button(composite, SWT.CHECK);
		importProjectSet.setText("Import project set");
		importProjectSet.setSelection(true);

		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		importProjectSet.setLayoutData(gd);

		setControl(composite);
		Dialog.applyDialogFont(parent);

		updateErrors();
	}

	private void updateErrors() {
		if (WildebeestPlugin.getDefault().getEarManager().getActiveEar() != null) {
			updateStatus("There is already Ear defined in current workspace");
			return;
		}
		updateStatus(internalGetSelectedModule() != null ? null : "Select Ear project");
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		if (visible) {
			moduleList.getControl().setFocus();
		}
	}

	protected void updateEnablements(boolean updateModulesList) {
		if (!badLocation) {
			moduleList.getControl().setEnabled(true);
			moduleName = null;
			if (moduleList.getInput() == null || updateModulesList) {
				boolean fetchModules = false;
				// The input is set after the page is shown to avoid
				// fetching if the user wants to specify the name manually
				try {
					// This can be called from different events in the event loop.
					// Ensure that we only fetch the input once
					synchronized (fetchingModulesLock) {
						if (!isFetchingModules) {
							// This the first thread in so fetch the modules
							fetchModules = true;
							isFetchingModules = true;
						}
					}
					if (fetchModules) {
						// Validate the location first since the module fecthing is
						// done in a deferred fashion
						getContainer().run(true, true, new IRunnableWithProgress() {
							public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
								try {
									validateLocation(monitor);
								} catch (CVSException e) {
									throw new InvocationTargetException(e);
								}
							}
						});
						setModuleListInput();
					}
				} catch (InvocationTargetException e) {
					if (!badLocation) {
						badLocation = true;
						ExceptionHandler.handle(e, getShell(), "Error", e.getMessage());
						// This will null the module list input
						setModuleListInput();
					}
				} catch (InterruptedException e) {
					// Canceled by the user
				} finally {
					synchronized (fetchingModulesLock) {
						if (fetchModules) {
							isFetchingModules = false;
						}
					}
				}
			}
			updateErrors();
		}
	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	ICVSRemoteFolder internalGetSelectedModule() {
		if (moduleList != null && moduleList.getControl().isEnabled()) {
			ISelection selection = moduleList.getSelection();
			if (!selection.isEmpty() && selection instanceof IStructuredSelection) {
				IStructuredSelection ss = (IStructuredSelection) selection;
				return (ICVSRemoteFolder) ss.getFirstElement();
			}
		}
		return null;
	}

	public ICVSRemoteFolder getSelectedModule() {
		final ICVSRemoteFolder[] folder = new ICVSRemoteFolder[] { null };
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				folder[0] = internalGetSelectedModule();
			}
		});
		return folder[0];
	}

	private TreeViewer createModuleTree(Composite composite, int horizontalSpan) {
		Tree tree = new Tree(composite, (supportsMultiSelection ? SWT.MULTI : SWT.SINGLE) | SWT.BORDER);
		GridData data = new GridData(GridData.FILL_BOTH);

		// see bug 158380
		data.heightHint = Math.max(composite.getParent().getSize().y, 100);

		data.horizontalSpan = horizontalSpan;
		tree.setLayoutData(data);
		TreeViewer result = new TreeViewer(tree) {
			@Override
			public boolean isExpandable(Object element) {
				return false;
			}
		};
		result.setContentProvider(new RemoteContentProvider());
		result.setLabelProvider(new WorkbenchLabelProvider());
		result.addFilter(new ViewerFilter() {
			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				return element instanceof ICVSRemoteFolder && parentElement instanceof ICVSRemoteFolder
						&& ((ICVSRemoteFolder) parentElement).getParent() == null
						&& ((ICVSRemoteFolder) element).getName().endsWith("EAR");
			}
		});
		result.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				updateErrors();
			}
		});
		result.getTree().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				if (getSelectedModule() != null) {
					gotoNextPage();
				}
			}
		});
		result.setComparator(new RepositoryComparator());
		return result;
	}

	private void setModuleListInput() {
		ICVSRepositoryLocation location = getLocation();
		if (location == null || badLocation)
			return;
		moduleList.setInput(location.getRemoteFolder(ICVSRemoteFolder.REPOSITORY_ROOT_FOLDER_NAME, CVSTag.DEFAULT));
	}

	private ICVSRepositoryLocation getLocation() {
		return location;
	}

	public void setLocation(ICVSRepositoryLocation location) {
		boolean refresh = location != null && !location.equals(this.location);
		this.location = location;
		badLocation = false;
		if (moduleList != null) {
			updateEnablements(refresh);
		}
	}

	public void setSupportsMultiSelection(boolean supportsMultiSelection) {
		this.supportsMultiSelection = supportsMultiSelection;
	}

	void gotoNextPage() {
		getContainer().showPage(getNextPage());
	}

	void validateLocation(IProgressMonitor monitor) throws CVSException {
		location.validateConnection(monitor);
	}

	boolean importProjectSet() {
		return importProjectSet.getSelection();
	}
}
