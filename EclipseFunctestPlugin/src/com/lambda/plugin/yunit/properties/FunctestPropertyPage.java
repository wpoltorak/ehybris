package com.lambda.plugin.yunit.properties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.internal.junit.util.LayoutUtil;
import org.eclipse.jdt.internal.ui.util.SWTUtil;
import org.eclipse.jdt.internal.ui.util.TableLayoutComposite;
import org.eclipse.jdt.ui.IJavaElementSearchConstants;
import org.eclipse.jdt.ui.ISharedImages;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ContentViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.TextProcessor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.PropertyPage;
import org.eclipse.ui.dialogs.SelectionDialog;
import org.eclipse.ui.progress.IProgressService;

import com.kizoom.plugin.ExceptionHandler;
import com.lambda.plugin.yunit.FunctestMessages;
import com.lambda.plugin.yunit.FunctestPlugin;

@SuppressWarnings("restriction")
public class FunctestPropertyPage extends PropertyPage {

	private static final String DEFAULT_NEW_FILTER_TEXT = ""; //$NON-NLS-1$
	private static final Image IMG_CUNIT = JavaUI.getSharedImages().getImage(ISharedImages.IMG_OBJS_CLASS);
	private static final Image IMG_PKG = JavaUI.getSharedImages().getImage(ISharedImages.IMG_OBJS_PACKAGE);

	// Step filter widgets
	private Label fFilterViewerLabel;
	private CheckboxTableViewer fFilterViewer;
	private Table fFilterTable;

	private Button fAddPackageButton;
	private Button fAddTypeButton;
	private Button fRemoveFilterButton;
	private Button fAddFilterButton;

	private Button fEnableAllButton;
	private Button fDisableAllButton;

	private Text fEditorText;
	private String fInvalidEditorText = null;
	private TableEditor fTableEditor;
	private TableItem fNewTableItem;
	private Filter fNewStackFilter;

	private TestFilterContentProvider fTestFilterContentProvider;

	/**
	 * Model object that represents a single entry in the filter table.
	 */
	private static class Filter {

		private String fName;
		private boolean fChecked;

		public Filter(String name, boolean checked) {
			setName(name);
			setChecked(checked);
		}

		public String getName() {
			return fName;
		}

		public void setName(String name) {
			fName = name;
		}

		public boolean isChecked() {
			return fChecked;
		}

		public void setChecked(boolean checked) {
			fChecked = checked;
		}

		@Override
		public boolean equals(Object o) {
			if (!(o instanceof Filter))
				return false;

			Filter other = (Filter) o;
			return (getName().equals(other.getName()));
		}

		@Override
		public int hashCode() {
			return fName.hashCode();
		}
	}

	/**
	 * Sorter for the filter table; sorts alphabetically ascending.
	 */
	private static class FilterViewerSorter extends ViewerComparator {
		@SuppressWarnings("unchecked")
		@Override
		public int compare(Viewer viewer, Object e1, Object e2) {
			ILabelProvider lprov = (ILabelProvider) ((ContentViewer) viewer).getLabelProvider();
			String name1 = lprov.getText(e1);
			String name2 = lprov.getText(e2);
			if (name1 == null)
				name1 = ""; //$NON-NLS-1$

			if (name2 == null)
				name2 = ""; //$NON-NLS-1$

			if (name1.length() > 0 && name2.length() > 0) {
				boolean isPackage1 = name1.indexOf('*') != -1;
				boolean isPackage2 = name2.indexOf('*') != -1;
				if (isPackage1 && !isPackage2)
					return -1;

				if (isPackage2 && !isPackage1)
					return 1;
			}
			return getComparator().compare(name1, name2);
		}
	}

	/**
	 * Label provider for Filter model objects
	 */
	private static class FilterLabelProvider extends LabelProvider implements ITableLabelProvider {

		public String getColumnText(Object object, int column) {
			return (column == 0) ? getText(object) : ""; //$NON-NLS-1$
		}

		@Override
		public String getText(Object element) {
			return TextProcessor.process(((Filter) element).getName());
		}

		public Image getColumnImage(Object object, int column) {
			String name = ((Filter) object).getName();
			if (name.indexOf(".*") != -1 || name.equals(FunctestMessages.JUnitMainTab_label_defaultpackage)) { //$NON-NLS-1$
				// package
				return IMG_PKG;
			} else if ("".equals(name)) { //$NON-NLS-1$
				// needed for the in-place editor
				return null;
			} else if ((Character.isUpperCase(name.charAt(0))) && (name.indexOf('.') < 0)) {
				// class in default package
				return IMG_CUNIT;
			} else {
				// fully-qualified class or other filter
				final int lastDotIndex = name.lastIndexOf('.');
				if ((-1 != lastDotIndex) && ((name.length() - 1) != lastDotIndex)
						&& Character.isUpperCase(name.charAt(lastDotIndex + 1)))
					return IMG_CUNIT;
			}
			// other filter
			return null;
		}
	}

	/**
	 * Content provider for the filter table. Content consists of instances of
	 * Filter.
	 */
	private class TestFilterContentProvider implements IStructuredContentProvider {

		private List<Filter> fFilters;

		public TestFilterContentProvider() {
			List<String> active = createActiveTestFiltersList();
			List<String> inactive = createInactiveTestFiltersList();
			populateFilters(active, inactive);
		}

		public void setDefaults() {
			fFilterViewer.remove(fFilters.toArray());
			List<String> active = FunctestPropertyConstants.createDefaultTestFiltersList();
			List<String> inactive = new ArrayList<String>();
			populateFilters(active, inactive);
		}

		protected void populateFilters(List<String> activeList, List<String> inactiveList) {
			fFilters = new ArrayList<Filter>(activeList.size() + inactiveList.size());
			populateList(activeList, true);
			if (inactiveList.size() != 0)
				populateList(inactiveList, false);
		}

		protected void populateList(List<String> list, boolean checked) {
			Iterator<String> iterator = list.iterator();

			while (iterator.hasNext()) {
				String name = iterator.next();
				addFilter(name, checked);
			}
		}

		public Filter addFilter(String name, boolean checked) {
			Filter filter = new Filter(name, checked);
			if (!fFilters.contains(filter)) {
				fFilters.add(filter);
				fFilterViewer.add(filter);
				fFilterViewer.setChecked(filter, checked);
			}
			updateActions();
			return filter;
		}

		public void saveFilters() {
			List<String> active = new ArrayList<String>(fFilters.size());
			List<String> inactive = new ArrayList<String>(fFilters.size());
			Iterator<Filter> iterator = fFilters.iterator();
			while (iterator.hasNext()) {
				Filter filter = iterator.next();
				String name = filter.getName();
				if (filter.isChecked())
					active.add(name);
				else
					inactive.add(name);
			}
			try {
				String pref = FunctestPropertyConstants.serializeList(active.toArray(new String[active.size()]));
				((IResource)getElement().getAdapter(IResource.class)).setPersistentProperty(new QualifiedName("", FunctestPropertyConstants.PREF_ACTIVE_TEST_FILTERS_LIST), pref);
				pref = FunctestPropertyConstants.serializeList(inactive.toArray(new String[inactive.size()]));
				((IResource)getElement().getAdapter(IResource.class)).setPersistentProperty(new QualifiedName("", FunctestPropertyConstants.PREF_INACTIVE_TEST_FILTERS_LIST), pref);

			} catch (CoreException e) {
				setErrorMessage("There were problems during storing preoperties");
			}
		}

		public void removeFilters(Object[] filters) {
			for (int i = (filters.length - 1); i >= 0; --i) {
				Filter filter = (Filter) filters[i];
				fFilters.remove(filter);
			}
			fFilterViewer.remove(filters);
			updateActions();
		}

		public void toggleFilter(Filter filter) {
			boolean newState = !filter.isChecked();
			filter.setChecked(newState);
			fFilterViewer.setChecked(filter, newState);
		}

		public Object[] getElements(Object inputElement) {
			return fFilters.toArray();
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		}

		public void dispose() {
		}

	}

	public FunctestPropertyPage() {
		super();
		setDescription(FunctestMessages.JUnitPropertyPage_description);
		setPreferenceStore(FunctestPlugin.getDefault().getPreferenceStore());
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		composite.setLayout(layout);
		GridData data = new GridData();
		data.verticalAlignment = GridData.FILL;
		data.horizontalAlignment = GridData.FILL;
		composite.setLayoutData(data);

		createTestFilterProperties(composite);
		Dialog.applyDialogFont(composite);
		return composite;
	}

	/*
	 * Create a group to contain the step filter related widgets
	 */
	private void createTestFilterProperties(Composite composite) {
		fFilterViewerLabel = new Label(composite, SWT.SINGLE | SWT.LEFT);
		fFilterViewerLabel.setText(FunctestMessages.JUnitPropertyPage_filter_label);

		Composite container = new Composite(composite, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		layout.marginHeight = 0;
		layout.marginWidth = 0;
		container.setLayout(layout);
		GridData gd = new GridData(GridData.FILL_BOTH);
		container.setLayoutData(gd);

		createFilterTable(container);
		createStepFilterButtons(container);
	}

	private void createFilterTable(Composite container) {
		TableLayoutComposite layouter = new TableLayoutComposite(container, SWT.NONE);
		layouter.addColumnData(new ColumnWeightData(100));
		layouter.setLayoutData(new GridData(GridData.FILL_BOTH));

		fFilterTable = new Table(layouter, SWT.CHECK | SWT.BORDER | SWT.MULTI | SWT.FULL_SELECTION);

		new TableColumn(fFilterTable, SWT.NONE);
		fFilterViewer = new CheckboxTableViewer(fFilterTable);
		fTableEditor = new TableEditor(fFilterTable);
		fFilterViewer.setLabelProvider(new FilterLabelProvider());
		fFilterViewer.setComparator(new FilterViewerSorter());
		fTestFilterContentProvider = new TestFilterContentProvider();
		fFilterViewer.setContentProvider(fTestFilterContentProvider);
		// input just needs to be non-null
		fFilterViewer.setInput(this);
		fFilterViewer.addCheckStateListener(new ICheckStateListener() {
			public void checkStateChanged(CheckStateChangedEvent event) {
				Filter filter = (Filter) event.getElement();
				fTestFilterContentProvider.toggleFilter(filter);
			}
		});
		fFilterViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				ISelection selection = event.getSelection();
				fRemoveFilterButton.setEnabled(!selection.isEmpty());
			}
		});
	}

	private void createStepFilterButtons(Composite container) {
		Composite buttonContainer = new Composite(container, SWT.NONE);
		GridData gd = new GridData(GridData.FILL_VERTICAL);
		buttonContainer.setLayoutData(gd);
		GridLayout buttonLayout = new GridLayout();
		buttonLayout.numColumns = 1;
		buttonLayout.marginHeight = 0;
		buttonLayout.marginWidth = 0;
		buttonContainer.setLayout(buttonLayout);

		fAddFilterButton = new Button(buttonContainer, SWT.PUSH);
		fAddFilterButton.setText(FunctestMessages.JUnitPropertyPage_addfilterbutton_label);
		fAddFilterButton.setToolTipText(FunctestMessages.JUnitPropertyPage_addfilterbutton_tooltip);
		gd = new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_BEGINNING);
		fAddFilterButton.setLayoutData(gd);
		LayoutUtil.setButtonDimensionHint(fAddFilterButton);
		fAddFilterButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				editFilter();
			}
		});

		fAddTypeButton = new Button(buttonContainer, SWT.PUSH);
		fAddTypeButton.setText(FunctestMessages.JUnitPropertyPage_addtypebutton_label);
		fAddTypeButton.setToolTipText(FunctestMessages.JUnitPropertyPage_addtypebutton_tooltip);
		gd = getButtonGridData(fAddTypeButton);
		fAddTypeButton.setLayoutData(gd);
		LayoutUtil.setButtonDimensionHint(fAddTypeButton);
		fAddTypeButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				addType();
			}
		});

		fAddPackageButton = new Button(buttonContainer, SWT.PUSH);
		fAddPackageButton.setText(FunctestMessages.JUnitPropertyPage_addpackagebutton_label);
		fAddPackageButton.setToolTipText(FunctestMessages.JUnitPropertyPage_addpackagebutton_tooltip);
		gd = getButtonGridData(fAddPackageButton);
		fAddPackageButton.setLayoutData(gd);
		SWTUtil.setButtonDimensionHint(fAddPackageButton);
		fAddPackageButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				addPackage();
			}
		});

		fRemoveFilterButton = new Button(buttonContainer, SWT.PUSH);
		fRemoveFilterButton.setText(FunctestMessages.JUnitPropertyPage_removefilterbutton_label);
		fRemoveFilterButton.setToolTipText(FunctestMessages.JUnitPropertyPage_removefilterbutton_tooltip);
		gd = getButtonGridData(fRemoveFilterButton);
		fRemoveFilterButton.setLayoutData(gd);
		SWTUtil.setButtonDimensionHint(fRemoveFilterButton);
		fRemoveFilterButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				removeFilters();
			}
		});
		fRemoveFilterButton.setEnabled(false);

		fEnableAllButton = new Button(buttonContainer, SWT.PUSH);
		fEnableAllButton.setText(FunctestMessages.JUnitPropertyPage_enableallbutton_label);
		fEnableAllButton.setToolTipText(FunctestMessages.JUnitPropertyPage_enableallbutton_tooltip);
		gd = getButtonGridData(fEnableAllButton);
		fEnableAllButton.setLayoutData(gd);
		SWTUtil.setButtonDimensionHint(fEnableAllButton);
		fEnableAllButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				checkAllFilters(true);
			}
		});

		fDisableAllButton = new Button(buttonContainer, SWT.PUSH);
		fDisableAllButton.setText(FunctestMessages.JUnitPropertyPage_disableallbutton_label);
		fDisableAllButton.setToolTipText(FunctestMessages.JUnitPropertyPage_disableallbutton_tooltip);
		gd = getButtonGridData(fDisableAllButton);
		fDisableAllButton.setLayoutData(gd);
		SWTUtil.setButtonDimensionHint(fDisableAllButton);
		fDisableAllButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event e) {
				checkAllFilters(false);
			}
		});

	}

	private GridData getButtonGridData(Button button) {
		GridData gd = new GridData(GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_BEGINNING);
		int widthHint = convertHorizontalDLUsToPixels(IDialogConstants.BUTTON_WIDTH);
		gd.widthHint = Math.max(widthHint, button.computeSize(SWT.DEFAULT, SWT.DEFAULT, true).x);
		return gd;
	}

	public void init(IWorkbench workbench) {
	}

	/**
	 * Create a new filter in the table (with the default 'new filter' value),
	 * then open up an in-place editor on it.
	 */
	private void editFilter() {
		// if a previous edit is still in progress, finish it
		if (fEditorText != null)
			validateChangeAndCleanup();

		fNewStackFilter = fTestFilterContentProvider.addFilter(DEFAULT_NEW_FILTER_TEXT, true);
		fNewTableItem = fFilterTable.getItem(0);
		int textStyles = SWT.SINGLE | SWT.LEFT;

		/*
		 * Workaround for https://bugs.eclipse.org/bugs/show_bug.cgi?id=218193 which
		 * won't get fixed (advice is to not use border). We still use a border on
		 * platforms where it looks OK and nicer with a border.
		 */
		String platform = SWT.getPlatform();
		if ("win32".equals(platform) || "gtk".equals(platform)) //$NON-NLS-1$ //$NON-NLS-2$
			textStyles |= SWT.BORDER;

		fEditorText = new Text(fFilterTable, textStyles);
		fEditorText.setFont(JFaceResources.getDialogFont());
		GridData gd = new GridData(GridData.FILL_BOTH);
		fEditorText.setLayoutData(gd);

		// set the editor
		fTableEditor.horizontalAlignment = SWT.LEFT;
		fTableEditor.grabHorizontal = true;
		fTableEditor.setEditor(fEditorText, fNewTableItem, 0);

		// get the editor ready to use
		fEditorText.setText(fNewStackFilter.getName());
		fEditorText.selectAll();
		setEditorListeners(fEditorText);
		fEditorText.setFocus();
	}

	private void setEditorListeners(Text text) {
		// CR means commit the changes, ESC means abort and don't commit
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent event) {
				if (event.character == SWT.CR) {
					if (fInvalidEditorText != null) {
						fEditorText.setText(fInvalidEditorText);
						fInvalidEditorText = null;
					} else
						validateChangeAndCleanup();
				} else if (event.character == SWT.ESC) {
					removeNewFilter();
					cleanupEditor();
				}
			}
		});
		// Consider loss of focus on the editor to mean the same as CR
		text.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent event) {
				if (fInvalidEditorText != null) {
					fEditorText.setText(fInvalidEditorText);
					fInvalidEditorText = null;
				} else
					validateChangeAndCleanup();
			}
		});
		// Consume traversal events from the text widget so that CR doesn't
		// traverse away to dialog's default button. Without this, hitting
		// CR in the text field closes the entire dialog.
		text.addListener(SWT.Traverse, new Listener() {
			public void handleEvent(Event event) {
				event.doit = false;
			}
		});
	}

	private void validateChangeAndCleanup() {
		String trimmedValue = fEditorText.getText().trim();
		// if the new value is blank, remove the filter
		if (trimmedValue.length() < 1)
			removeNewFilter();

		// if it's invalid, beep and leave sitting in the editor
		else if (!validateEditorInput(trimmedValue)) {
			fInvalidEditorText = trimmedValue;
			fEditorText.setText(FunctestMessages.JUnitPropertyPage_invalidstepfilterreturnescape);
			getShell().getDisplay().beep();
			return;
			// otherwise, commit the new value if not a duplicate
		} else {
			Object[] filters = fTestFilterContentProvider.getElements(null);
			for (int i = 0; i < filters.length; i++) {
				Filter filter = (Filter) filters[i];
				if (filter.getName().equals(trimmedValue)) {
					removeNewFilter();
					cleanupEditor();
					return;
				}
			}
			fNewTableItem.setText(trimmedValue);
			fNewStackFilter.setName(trimmedValue);
			fFilterViewer.refresh();
		}
		cleanupEditor();
	}

	/*
	 * Cleanup all widgets & resources used by the in-place editing
	 */
	private void cleanupEditor() {
		if (fEditorText == null)
			return;

		fNewStackFilter = null;
		fNewTableItem = null;
		fTableEditor.setEditor(null, null, 0);
		fEditorText.dispose();
		fEditorText = null;
	}

	private void removeNewFilter() {
		fTestFilterContentProvider.removeFilters(new Object[] { fNewStackFilter });
	}

	/*
	 * A valid step filter is simply one that is a valid Java identifier. and, as
	 * defined in the JDI spec, the regular expressions used for step filtering
	 * must be limited to exact matches or patterns that begin with '*' or end
	 * with '*'. Beyond this, a string cannot be validated as corresponding to an
	 * existing type or package (and this is probably not even desirable).
	 */
	private boolean validateEditorInput(String trimmedValue) {
		char firstChar = trimmedValue.charAt(0);
		if ((!(Character.isJavaIdentifierStart(firstChar)) || (firstChar == '*')))
			return false;

		int length = trimmedValue.length();
		for (int i = 1; i < length; i++) {
			char c = trimmedValue.charAt(i);
			if (!Character.isJavaIdentifierPart(c)) {
				if (c == '.' && i != (length - 1))
					continue;
				if (c == '*' && i == (length - 1))
					continue;

				return false;
			}
		}
		return true;
	}

	private void addType() {
		Shell shell = getShell();
		SelectionDialog dialog = null;
		try {
			dialog = JavaUI.createTypeDialog(shell, PlatformUI.getWorkbench().getProgressService(), SearchEngine
					.createWorkspaceScope(), IJavaElementSearchConstants.CONSIDER_CLASSES, false);
		} catch (JavaModelException jme) {
			String title = FunctestMessages.JUnitPropertyPage_addtypedialog_title;
			String message = FunctestMessages.JUnitPropertyPage_addtypedialog_error_message;
			ExceptionHandler.handle(jme, shell, title, message);
			return;
		}

		dialog.setTitle(FunctestMessages.JUnitPropertyPage_addtypedialog_title);
		dialog.setMessage(FunctestMessages.JUnitPropertyPage_addtypedialog_message);
		if (dialog.open() == IDialogConstants.CANCEL_ID)
			return;

		Object[] types = dialog.getResult();
		if (types != null && types.length > 0) {
			IType type = (IType) types[0];
			fTestFilterContentProvider.addFilter(type.getFullyQualifiedName('.'), true);
		}
	}

	private void addPackage() {
		Shell shell = getShell();
		IProgressService context = PlatformUI.getWorkbench().getProgressService();
		IJavaSearchScope createWorkspaceScope = SearchEngine.createWorkspaceScope();
		SelectionDialog dialog = JavaUI.createPackageDialog(shell, context, createWorkspaceScope, true, true, ""); //$NON-NLS-1$
		dialog.setTitle(FunctestMessages.JUnitPropertyPage_addpackagedialog_title);
		dialog.setMessage(FunctestMessages.JUnitPropertyPage_addpackagedialog_message);
		if (dialog.open() != Window.OK)
			return;

		Object[] packages = dialog.getResult();
		if (packages == null)
			return;

		for (int i = 0; i < packages.length; i++) {
			IJavaElement pkg = (IJavaElement) packages[i];

			String filter = pkg.getElementName();
			if (filter.length() < 1)
				filter = FunctestMessages.JUnitMainTab_label_defaultpackage;
			else
				filter += ".*"; //$NON-NLS-1$

			fTestFilterContentProvider.addFilter(filter, true);
		}
	}

	private void removeFilters() {
		IStructuredSelection selection = (IStructuredSelection) fFilterViewer.getSelection();
		fTestFilterContentProvider.removeFilters(selection.toArray());
	}

	private void checkAllFilters(boolean check) {
		Object[] filters = fTestFilterContentProvider.getElements(null);
		for (int i = (filters.length - 1); i >= 0; --i)
			((Filter) filters[i]).setChecked(check);

		fFilterViewer.setAllChecked(check);
	}

	@Override
	public boolean performOk() {
		fTestFilterContentProvider.saveFilters();
		return true;
	}

	@Override
	protected void performDefaults() {
		setDefaultValues();
		super.performDefaults();
	}

	private void setDefaultValues() {
		fTestFilterContentProvider.setDefaults();
	}

	/**
	 * Returns a list of active test filters.
	 * 
	 * @return list
	 */
	protected List<String> createActiveTestFiltersList() {
		try {
			return Arrays.asList(getFilterPatterns());
		} catch (CoreException e) {
			return Collections.<String>emptyList();
		}
	}

	/**
	 * Returns a list of active test filters.
	 * 
	 * @return list
	 */
	protected List<String> createInactiveTestFiltersList() {
		
		try {
			String persistentProperty = ((IResource) getElement().getAdapter(IResource.class)).getPersistentProperty(new QualifiedName("", FunctestPropertyConstants.PREF_INACTIVE_TEST_FILTERS_LIST));
			String[] strings = FunctestPropertyPage.parseList(persistentProperty == null ? "" : persistentProperty);
			return Arrays.asList(strings);
		} catch (CoreException e) {
			return Collections.<String>emptyList();
		}
	}

	protected void updateActions() {
		if (fEnableAllButton == null)
			return;

		boolean enabled = fFilterViewer.getTable().getItemCount() > 0;
		fEnableAllButton.setEnabled(enabled);
		fDisableAllButton.setEnabled(enabled);
	}

	public String[] getFilterPatterns() throws CoreException {
		String persistentProperty = ((IResource) getElement().getAdapter(IResource.class)).getPersistentProperty(new QualifiedName("", FunctestPropertyConstants.PREF_ACTIVE_TEST_FILTERS_LIST));
		return FunctestPropertyPage.parseList(persistentProperty == null ? "" : persistentProperty);
	}

	/*
	 * Parses the comma separated string into an array of strings
	 */
	private static String[] parseList(String listString) {
		List<String> list = new ArrayList<String>(10);
		StringTokenizer tokenizer = new StringTokenizer(listString, ","); //$NON-NLS-1$
		while (tokenizer.hasMoreTokens())
			list.add(tokenizer.nextToken());
		return list.toArray(new String[list.size()]);
	}

}