package com.lambda.plugin.wizards.hybris;

import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Tree;

import com.lambda.plugin.YMessages;
import com.lambda.plugin.core.PlatformExtension;

public class ImportPlatformWizardPage extends WizardPage {

    private static final String PAGE_NAME = "ImportPlatformWizardPage";//$NON-NLS-1$
    private Combo rootDirectoryCombo;
    private CheckboxTreeViewer projectTreeViewer;
    private Button btnSelectTree;
    private Button btnDeselectTree;

    protected ImportPlatformWizardPage() {
        super(PAGE_NAME);
        setTitle(YMessages.ImportPlatformPage_title);
        setDescription(YMessages.ImportPlatformPage_description);
        setPageComplete(false);
    }

    public void createControl(Composite parent) {
        Composite composite = new Composite(parent, SWT.NONE);
        composite.setLayout(new org.eclipse.swt.layout.GridLayout(3, false));
        setControl(composite);

        final Label selectRootDirectoryLabel = new Label(composite, SWT.NONE);
        selectRootDirectoryLabel.setLayoutData(new GridData());
        selectRootDirectoryLabel.setText(YMessages.ImportPlatformPage_selectPlatformRoot);

        rootDirectoryCombo = new Combo(composite, SWT.NONE);
        rootDirectoryCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        rootDirectoryCombo.setFocus();
        //addFieldWithHistory("rootDirectory", rootDirectoryCombo); //$NON-NLS-1$

        final Button browseButton = new Button(composite, SWT.NONE);
        browseButton.setText(YMessages.ImportPlatformPage_browse);
        browseButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
        browseButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                DirectoryDialog dialog = new DirectoryDialog(getShell(), SWT.NONE);
                dialog.setText(YMessages.ImportPlatformPage_selectPlatformRootFolder);
                String path = rootDirectoryCombo.getText();
                if (path.length() == 0) {
                    path = ResourcesPlugin.getWorkspace().getRoot().getLocation().toPortableString();
                }
                dialog.setFilterPath(path);

                String result = dialog.open();
                if (result != null) {
                    rootDirectoryCombo.setText(result);
                    if (rootDirectoryChanged()) {
                        scanProjects();
                    }
                }
            }
        });

        rootDirectoryCombo.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                // if (rootDirectoryChanged()) {
                // scanProjects();
                // }
            }
        });
        rootDirectoryCombo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                if (rootDirectoryChanged()) {
                    scanProjects();
                }
            }
        });
        rootDirectoryCombo.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                if (rootDirectoryChanged()) {
                    scanProjects();
                }
            }

            @Override
            public void widgetSelected(SelectionEvent e) {
                if (rootDirectoryChanged()) {
                    // in runnable to have the combo popup collapse before disabling controls.
                    Display.getDefault().asyncExec(new Runnable() {
                        public void run() {
                            scanProjects();
                        }

                    });
                }
            }

        });

        final Label projectsLabel = new Label(composite, SWT.NONE);
        projectsLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
        projectsLabel.setText(YMessages.ImportPlatformPage_projects);

        projectTreeViewer = new CheckboxTreeViewer(composite, SWT.BORDER);

        projectTreeViewer.addCheckStateListener(new ICheckStateListener() {
            public void checkStateChanged(CheckStateChangedEvent event) {
                // updateCheckedState();
                // setPageComplete();
            }
        });

        projectTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            public void selectionChanged(SelectionChangedEvent event) {
                IStructuredSelection selection = (IStructuredSelection) event.getSelection();
                btnSelectTree.setEnabled(!selection.isEmpty());
                btnDeselectTree.setEnabled(!selection.isEmpty());
                if (selection.getFirstElement() != null) {
                    String errorMsg = validateExtension((PlatformExtension) selection.getFirstElement());
                    if (errorMsg != null) {
                        setMessage(errorMsg, IMessageProvider.WARNING);
                    } else {
                        // TODO if no error on current, shall show any existing general errors if found..
                        // setMessage(loadingErrorMessage, IMessageProvider.WARNING);
                    }
                } else {
                    // TODO if on current selection, shall show any existing general errors if existing..
                    // setMessage(loadingErrorMessage, IMessageProvider.WARNING);
                }
            }

            private String validateExtension(PlatformExtension firstElement) {
                return null;
            }
        });

        projectTreeViewer.setContentProvider(new ITreeContentProvider() {

            public Object[] getElements(Object element) {
                if (element instanceof List) {
                    @SuppressWarnings("unchecked")
                    List<PlatformExtension> projects = (List<PlatformExtension>) element;
                    return projects.toArray(new PlatformExtension[projects.size()]);
                }
                return new Object[0];
            }

            public Object[] getChildren(Object parentElement) {
                if (parentElement instanceof List) {
                    @SuppressWarnings("unchecked")
                    List<PlatformExtension> projects = (List<PlatformExtension>) parentElement;
                    return projects.toArray(new PlatformExtension[projects.size()]);
                } else if (parentElement instanceof PlatformExtension) {
                    PlatformExtension mavenProjectInfo = (PlatformExtension) parentElement;
                    // Collection<PlatformExtension> projects = mavenProjectInfo.getProjects();
                    // return projects.toArray(new PlatformExtension[projects.size()]);
                }
                return new Object[0];
            }

            public Object getParent(Object element) {
                return null;
            }

            public boolean hasChildren(Object parentElement) {
                if (parentElement instanceof List) {
                    List<?> projects = (List<?>) parentElement;
                    return !projects.isEmpty();
                } else if (parentElement instanceof PlatformExtension) {
                    PlatformExtension mavenProjectInfo = (PlatformExtension) parentElement;
                    return false;// !mavenProjectInfo.getProjects().isEmpty();
                }
                return false;
            }

            public void dispose() {
            }

            public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
            }
        });

        // projectTreeViewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new ProjectLabelProvider()));

        final Tree projectTree = projectTreeViewer.getTree();
        GridData projectTreeData = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 5);
        projectTreeData.heightHint = 250;
        projectTreeData.widthHint = 500;
        projectTree.setLayoutData(projectTreeData);

        Menu menu = new Menu(projectTree);
        projectTree.setMenu(menu);

        MenuItem mntmSelectTree = new MenuItem(menu, SWT.NONE);
        mntmSelectTree.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                // setProjectSubtreeChecked(true);
            }
        });
        mntmSelectTree.setText("Select tree");

        MenuItem mntmDeselectTree = new MenuItem(menu, SWT.NONE);
        mntmDeselectTree.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                // setProjectSubtreeChecked(false);
            }
        });
        mntmDeselectTree.setText("DeselectTree");

        final Button selectAllButton = new Button(composite, SWT.NONE);
        selectAllButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
        selectAllButton.setText(YMessages.ImportPlatformPage_selectAll);
        selectAllButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                projectTreeViewer.expandAll();
                // setAllChecked(true);
                // validate();
            }
        });

        final Button deselectAllButton = new Button(composite, SWT.NONE);
        deselectAllButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
        deselectAllButton.setText(YMessages.ImportPlatformPage_deselectAll);
        deselectAllButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                // setAllChecked(false);
                setPageComplete(false);
            }
        });

        final Button refreshButton = new Button(composite, SWT.NONE);
        refreshButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, true));
        refreshButton.setText(YMessages.ImportPlatformPage_refresh);
        refreshButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                // scanProjects();
            }
        });
    }

    private void scanProjects() {
        // TODO Auto-generated method stub

    }

    private boolean rootDirectoryChanged() {
        // TODO Auto-generated method stub
        return false;
    }

}
