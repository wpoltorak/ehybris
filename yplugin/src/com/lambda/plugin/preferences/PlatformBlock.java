package com.lambda.plugin.preferences;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.ListenerList;
import org.eclipse.debug.internal.ui.SWTFactory;
import org.eclipse.jdt.internal.debug.ui.jres.JREMessages;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.ui.ISharedImages;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

import com.lambda.plugin.YMessages;
import com.lambda.plugin.YPlugin;
import com.lambda.plugin.core.IPlatformInstallation;

/**
 * Displays installed Platforms in a table. Platforms can be added, removed or edited.
 * <p>
 * This block implements ISelectionProvider - it sends selection change events when the checked Platform in the table
 * changes, or when the "use default" button check state changes.
 * </p>
 */
public class PlatformBlock implements ISelectionProvider {

    /**
     * This block's control
     */
    private Composite control;

    /**
     * Platforms being displayed
     */
    private final List<Object> platforms = new ArrayList<Object>();

    /**
     * The main list control
     */
    private CheckboxTableViewer platformList;

    // Action buttons
    private Button addButton;
    private Button removeButton;
    private Button editButton;

    // index of column used for sorting
    private int sortColumn = 0;

    /**
     * Selection listeners (checked JRE changes)
     */
    private final ListenerList selectionListeners = new ListenerList();

    /**
     * Previous selection
     */
    private ISelection previousSelection = new StructuredSelection();

    private Table table;

    /**
     * Content provider to show a list of JREs
     */
    class PlatformContentProvider implements IStructuredContentProvider {
        public Object[] getElements(Object input) {
            return platforms.toArray();
        }

        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        }

        public void dispose() {
        }
    }

    /**
     * Label provider for installed JREs table.
     */
    class PlatformLabelProvider extends LabelProvider implements ITableLabelProvider {

        /**
         * @see ITableLabelProvider#getColumnText(Object, int)
         */
        public String getColumnText(Object element, int columnIndex) {
            if (element instanceof IPlatformInstallation) {
                IPlatformInstallation vm = (IPlatformInstallation) element;
                switch (columnIndex) {
                case 0:
                    return vm.getName();
                case 1:
                    return vm.getVersion();
                case 2:
                    return vm.getInstallLocation().getAbsolutePath();
                case 3:
                    return vm.getDescription();

                }
            }
            return element.toString();
        }

        /**
         * @see ITableLabelProvider#getColumnImage(Object, int)
         */
        public Image getColumnImage(Object element, int columnIndex) {
            if (columnIndex == 0) {
                return JavaUI.getSharedImages().getImage(ISharedImages.IMG_OBJS_LIBRARY);
            }
            return null;
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.ISelectionProvider#addSelectionChangedListener(org.eclipse.jface.viewers.
     * ISelectionChangedListener)
     */
    public void addSelectionChangedListener(ISelectionChangedListener listener) {
        selectionListeners.add(listener);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.ISelectionProvider#getSelection()
     */
    public ISelection getSelection() {
        return new StructuredSelection(platformList.getCheckedElements());
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.ISelectionProvider#removeSelectionChangedListener(org.eclipse.jface.viewers.
     * ISelectionChangedListener)
     */
    public void removeSelectionChangedListener(ISelectionChangedListener listener) {
        selectionListeners.remove(listener);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.ISelectionProvider#setSelection(org.eclipse.jface.viewers.ISelection)
     */
    public void setSelection(ISelection selection) {
        if (selection instanceof IStructuredSelection) {
            if (!selection.equals(previousSelection)) {
                previousSelection = selection;
                Object jre = ((IStructuredSelection) selection).getFirstElement();
                if (jre == null) {
                    platformList.setCheckedElements(new Object[0]);
                } else {
                    platformList.setCheckedElements(new Object[] { jre });
                    platformList.reveal(jre);
                }
                fireSelectionChanged();
            }
        }
    }

    /**
     * Creates this block's control in the given control.
     * 
     * @param ancestor containing control
     * @param useManageButton whether to present a single 'manage...' button to the user that opens the installed JREs
     *            pref page for JRE management, or to provide 'add, remove, edit, and search' buttons.
     */
    public void createControl(Composite ancestor) {
        Font font = ancestor.getFont();
        Composite parent = SWTFactory.createComposite(ancestor, font, 2, 1, GridData.FILL_BOTH);
        control = parent;

        SWTFactory.createLabel(parent, JREMessages.InstalledJREsBlock_15, 2);

        table = new Table(parent, SWT.CHECK | SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION);
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.heightHint = 250;
        gd.widthHint = 350;
        table.setLayoutData(gd);
        table.setFont(font);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        TableColumn column = new TableColumn(table, SWT.NULL);
        column.setText(YMessages.PlatformPreferencePage_Column_Name);
        column.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                sortByName();
            }
        });
        int defaultwidth = 350 / 3 + 1;
        column.setWidth(defaultwidth);

        column = new TableColumn(table, SWT.NULL);
        column.setText(YMessages.PlatformPreferencePage_Column_Version);
        column.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                sortByVersion();
            }
        });
        column.setWidth(defaultwidth);

        column = new TableColumn(table, SWT.NULL);
        column.setText(YMessages.PlatformPreferencePage_Column_Location);
        column.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                sortByLocation();
            }
        });
        column.setWidth(defaultwidth);

        column = new TableColumn(table, SWT.NULL);
        column.setText(YMessages.PlatformPreferencePage_Column_Description);
        column.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                sortByDescription();
            }
        });
        column.setWidth(defaultwidth);

        platformList = new CheckboxTableViewer(table);
        platformList.setLabelProvider(new PlatformLabelProvider());
        platformList.setContentProvider(new PlatformContentProvider());
        // by default, sort by name
        sortByName();

        platformList.addSelectionChangedListener(new ISelectionChangedListener() {
            public void selectionChanged(SelectionChangedEvent evt) {
                enableButtons();
            }
        });

        platformList.addCheckStateListener(new ICheckStateListener() {
            public void checkStateChanged(CheckStateChangedEvent event) {
                if (event.getChecked()) {
                    setCheckedPlatform((IPlatformInstallation) event.getElement());
                } else {
                    setCheckedPlatform(null);
                }
            }
        });

        platformList.addDoubleClickListener(new IDoubleClickListener() {
            public void doubleClick(DoubleClickEvent e) {
                if (!platformList.getSelection().isEmpty()) {
                    editPlatform();
                }
            }
        });
        table.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                if (event.character == SWT.DEL && event.stateMask == 0) {
                    if (removeButton.isEnabled()) {
                        removePlatforms();
                    }
                }
            }
        });

        Composite buttons = SWTFactory.createComposite(parent, font, 1, 1, GridData.VERTICAL_ALIGN_BEGINNING, 0, 0);

        addButton = SWTFactory.createPushButton(buttons, YMessages.PlatformPreferencePage_Button_Add, null);
        addButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event evt) {
                addPlatform();
            }
        });

        editButton = SWTFactory.createPushButton(buttons, YMessages.PlatformPreferencePage_Button_Edit, null);
        editButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event evt) {
                editPlatform();
            }
        });

        removeButton = SWTFactory.createPushButton(buttons, YMessages.PlatformPreferencePage_Button_Remove, null);
        removeButton.addListener(SWT.Selection, new Listener() {
            public void handleEvent(Event evt) {
                removePlatforms();
            }
        });

        SWTFactory.createVerticalSpacer(parent, 1);

        fillWithWorkspacePlatforms();
        enableButtons();
        addButton.setEnabled(JavaRuntime.getVMInstallTypes().length > 0);
    }

    /**
     * Fire current selection
     */
    private void fireSelectionChanged() {
        SelectionChangedEvent event = new SelectionChangedEvent(this, getSelection());
        Object[] listeners = selectionListeners.getListeners();
        for (int i = 0; i < listeners.length; i++) {
            ISelectionChangedListener listener = (ISelectionChangedListener) listeners[i];
            listener.selectionChanged(event);
        }
    }

    /**
     * Sorts by platform name.
     */
    private void sortByName() {
        platformList.setComparator(new ViewerComparator() {
            @Override
            public int compare(Viewer viewer, Object e1, Object e2) {
                if ((e1 instanceof IPlatformInstallation) && (e2 instanceof IPlatformInstallation)) {
                    IPlatformInstallation left = (IPlatformInstallation) e1;
                    IPlatformInstallation right = (IPlatformInstallation) e2;
                    return left.getName().compareToIgnoreCase(right.getName());
                }
                return super.compare(viewer, e1, e2);
            }

            @Override
            public boolean isSorterProperty(Object element, String property) {
                return true;
            }
        });
        sortColumn = 1;
    }

    /**
     * Sorts by platform version.
     */
    private void sortByVersion() {
        platformList.setComparator(new ViewerComparator() {
            @Override
            public int compare(Viewer viewer, Object e1, Object e2) {
                if ((e1 instanceof IPlatformInstallation) && (e2 instanceof IPlatformInstallation)) {
                    IPlatformInstallation left = (IPlatformInstallation) e1;
                    IPlatformInstallation right = (IPlatformInstallation) e2;
                    return left.getVersion().compareToIgnoreCase(right.getVersion());
                }
                return super.compare(viewer, e1, e2);
            }

            @Override
            public boolean isSorterProperty(Object element, String property) {
                return true;
            }
        });
        sortColumn = 2;
    }

    /**
     * Sorts by platform location.
     */
    private void sortByLocation() {
        platformList.setComparator(new ViewerComparator() {
            @Override
            public int compare(Viewer viewer, Object e1, Object e2) {
                if ((e1 instanceof IPlatformInstallation) && (e2 instanceof IPlatformInstallation)) {
                    IPlatformInstallation left = (IPlatformInstallation) e1;
                    IPlatformInstallation right = (IPlatformInstallation) e2;
                    return left.getInstallLocation().getAbsolutePath()
                            .compareToIgnoreCase(right.getInstallLocation().getAbsolutePath());
                }
                return super.compare(viewer, e1, e2);
            }

            @Override
            public boolean isSorterProperty(Object element, String property) {
                return true;
            }
        });
        sortColumn = 3;
    }

    /**
     * Sorts by platform description.
     */
    private void sortByDescription() {
        platformList.setComparator(new ViewerComparator() {
            @Override
            public int compare(Viewer viewer, Object e1, Object e2) {
                if ((e1 instanceof IPlatformInstallation) && (e2 instanceof IPlatformInstallation)) {
                    IPlatformInstallation left = (IPlatformInstallation) e1;
                    IPlatformInstallation right = (IPlatformInstallation) e2;
                    return left.getDescription().compareToIgnoreCase(right.getDescription());
                }
                return super.compare(viewer, e1, e2);
            }

            @Override
            public boolean isSorterProperty(Object element, String property) {
                return true;
            }
        });
        sortColumn = 4;
    }

    /**
     * Enables the buttons based on selected items counts in the viewer
     */
    private void enableButtons() {
        IStructuredSelection selection = (IStructuredSelection) platformList.getSelection();
        int selectionCount = selection.size();
        editButton.setEnabled(selectionCount == 1);
        if (selectionCount > 0 && selectionCount < platformList.getTable().getItemCount()) {
            removeButton.setEnabled(true);
        } else {
            removeButton.setEnabled(false);
        }
    }

    /**
     * Returns this block's control
     * 
     * @return control
     */
    public Control getControl() {
        return control;
    }

    /**
     * Sets the JREs to be displayed in this block
     * 
     * @param platforms JREs to be displayed
     */
    protected void setPlatforms(IPlatformInstallation[] platforms) {
        this.platforms.clear();
        for (int i = 0; i < platforms.length; i++) {
            this.platforms.add(platforms[i]);
        }
        platformList.setInput(platforms);
        platformList.refresh();
    }

    /**
     * Returns the JREs currently being displayed in this block
     * 
     * @return JREs currently being displayed in this block
     */
    public IPlatformInstallation[] getPlatforms() {
        return platforms.toArray(new IPlatformInstallation[platforms.size()]);
    }

    /**
     * Bring up a wizard that lets the user create a new VM definition.
     */
    private void addPlatform() {
        DirectoryDialog dlg = new DirectoryDialog(editButton.getShell(), SWT.OPEN);
        dlg.setText("Open");

        String path = dlg.open();
        if (path == null) {
            return;
        }
        IPlatformInstallation platform = YPlugin.getPlatformContainer().verifyPlatformLocation(new File(path));

        if (platform == null) {
            MessageDialog.openError(control.getShell(), YMessages.PlatformPreferencePage_Title,
                    YMessages.PlatformPreferencePage_ErrorInvalidPlatformDirectory);
            return;
        }
        platforms.add(platform);
        platformList.refresh();
    }

    /**
     * Performs the edit VM action when the Edit... button is pressed
     */
    private void editPlatform() {
        IStructuredSelection selection = (IStructuredSelection) platformList.getSelection();
        IPlatformInstallation platform = (IPlatformInstallation) selection.getFirstElement();
        if (platform == null) {
            return;
        }

        DirectoryDialog dlg = new DirectoryDialog(editButton.getShell(), SWT.OPEN);
        dlg.setText("Open");
        String path = dlg.open();
        if (path == null) {
            return;
        }

        IPlatformInstallation newPlatform = YPlugin.getPlatformContainer().verifyPlatformLocation(new File(path));
        if (newPlatform == null) {
            MessageDialog.openError(control.getShell(), YMessages.PlatformPreferencePage_Title,
                    YMessages.PlatformPreferencePage_ErrorInvalidPlatformDirectory);
            return;
        }

        int index = platforms.indexOf(platform);
        platforms.remove(index);
        // TODO
        platforms.add(index, newPlatform);
        platformList.refresh();
        // fVMList.setSelection(new StructuredSelection(result));
    }

    /**
     * Performs the remove VM(s) action when the Remove... button is pressed
     */
    private void removePlatforms() {
        IStructuredSelection selection = (IStructuredSelection) platformList.getSelection();
        IPlatformInstallation[] platforms = new IPlatformInstallation[selection.size()];
        Iterator<IPlatformInstallation> iter = selection.iterator();
        int i = 0;
        while (iter.hasNext()) {
            platforms[i] = iter.next();
            i++;
        }
        removePlatforms(platforms);
    }

    /**
     * Removes the given VMs from the table.
     * 
     * @param platforms
     */
    public void removePlatforms(IPlatformInstallation[] platforms) {
        IStructuredSelection prev = (IStructuredSelection) getSelection();
        for (int i = 0; i < platforms.length; i++) {
            this.platforms.remove(platforms[i]);
        }
        platformList.refresh();
        IStructuredSelection curr = (IStructuredSelection) getSelection();
        if (!curr.equals(prev)) {
            IPlatformInstallation[] installs = getPlatforms();
            if (curr.size() == 0 && installs.length == 1) {
                // pick a default platform automatically
                setSelection(new StructuredSelection(installs[0]));
            } else {
                fireSelectionChanged();
            }
        }
    }

    protected Shell getShell() {
        return getControl().getShell();
    }

    /**
     * Sets the checked JRE, possible <code>null</code>
     * 
     * @param vm JRE or <code>null</code>
     */
    public void setCheckedPlatform(IPlatformInstallation platform) {
        if (platform == null) {
            setSelection(new StructuredSelection());
        } else {
            setSelection(new StructuredSelection(platform));
        }
    }

    /**
     * Returns the checked JRE or <code>null</code> if none.
     * 
     * @return the checked JRE or <code>null</code> if none
     */
    public IPlatformInstallation getCheckedPlatform() {
        Object[] objects = platformList.getCheckedElements();
        if (objects.length == 0) {
            return null;
        }
        return (IPlatformInstallation) objects[0];
    }

    /**
     * Persist table settings into the give dialog store, prefixed with the given key.
     * 
     * @param settings dialog store
     * @param qualifier key qualifier
     */
    public void saveColumnSettings(IDialogSettings settings, String qualifier) {
        int columnCount = table.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            settings.put(qualifier + ".columnWidth" + i, table.getColumn(i).getWidth()); //$NON-NLS-1$
        }
        settings.put(qualifier + ".sortColumn", sortColumn); //$NON-NLS-1$
    }

    /**
     * Restore table settings from the given dialog store using the given key.
     * 
     * @param settings dialog settings store
     * @param qualifier key to restore settings from
     */
    public void restoreColumnSettings(IDialogSettings settings, String qualifier) {
        platformList.getTable().layout(true);
        restoreColumnWidths(settings, qualifier);
        try {
            sortColumn = settings.getInt(qualifier + ".sortColumn"); //$NON-NLS-1$
        } catch (NumberFormatException e) {
            sortColumn = 1;
        }
        switch (sortColumn) {
        case 1:
            sortByName();
            break;
        case 2:
            sortByVersion();
            break;
        case 3:
            sortByLocation();
            break;
        case 4:
            sortByDescription();
            break;
        }

    }

    /**
     * Restores the column widths from dialog settings
     * 
     * @param settings
     * @param qualifier
     */
    private void restoreColumnWidths(IDialogSettings settings, String qualifier) {
        int columnCount = table.getColumnCount();
        for (int i = 0; i < columnCount; i++) {
            int width = -1;
            try {
                width = settings.getInt(qualifier + ".columnWidth" + i); //$NON-NLS-1$
            } catch (NumberFormatException e) {
            }

            if ((width <= 0) || (i == table.getColumnCount() - 1)) {
                table.getColumn(i).pack();
            } else {
                table.getColumn(i).setWidth(width);
            }
        }
    }

    /**
     * Populates the Platforms table with existing Platforms defined in the workspace.
     */
    protected void fillWithWorkspacePlatforms() {
        // fill with JREs
        setPlatforms(YPlugin.getPlatformInstallations());
    }

}
