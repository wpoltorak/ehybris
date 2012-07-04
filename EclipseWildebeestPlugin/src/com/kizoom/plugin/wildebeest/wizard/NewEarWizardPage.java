package com.kizoom.plugin.wildebeest.wizard;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.dialogs.IDialogPage;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.osgi.util.TextProcessor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.team.internal.ccvs.core.CVSException;
import org.eclipse.team.internal.ccvs.core.CVSTag;
import org.eclipse.team.internal.ccvs.core.ICVSRemoteFolder;
import org.eclipse.team.internal.ccvs.core.ICVSRepositoryLocation;
import org.eclipse.team.internal.ccvs.ui.CVSUIPlugin;
import org.eclipse.team.internal.ccvs.ui.repo.RepositoryComparator;
import org.eclipse.ui.model.AdaptableList;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import com.kizoom.plugin.wildebeest.WildebeestPlugin;
import com.kizoom.plugin.wildebeest.preferences.PreferenceConstants;

@SuppressWarnings("restriction")
public class NewEarWizardPage extends WizardPage {

	private Text earName;
	private Text templateName;
	private Label earNameWithSuffix;
	private Button copyEarTemplate;
	private TableViewer table;
	private ICVSRepositoryLocation result;
	private Button importProjectSet;

	private class DecoratingRepoLabelProvider extends WorkbenchLabelProvider {
		@Override
		protected String decorateText(String input, Object element) {
			// Used to process RTL locales only
			return TextProcessor.process(input, ":@/"); //$NON-NLS-1$
		}
	}

	/**
	 * Constructor for SampleNewWizardPage.
	 * 
	 * @param pageName
	 */
	public NewEarWizardPage() {
		super("newEarWizardPage");
		setTitle("New Kizoom Ear Project");
		setDescription("This wizard creates a new Kizoom Ear project.");
	}

	protected TableViewer createTable(Composite parent, int span) {
		Table table = new Table(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.SINGLE | SWT.FULL_SELECTION);
		GridData data = new GridData(GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL);
		data.horizontalSpan = span;
		data.widthHint = 200;
		data.horizontalIndent = 20;
		table.setLayoutData(data);
		TableLayout layout = new TableLayout();
		layout.addColumnData(new ColumnWeightData(100, true));
		table.setLayout(layout);
		TableColumn col = new TableColumn(table, SWT.NONE);
		col.setResizable(true);

		return new TableViewer(table);
	}

	/**
	 * @see IDialogPage#createControl(Composite)
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		container.setLayout(layout);
		layout.numColumns = 2;
		layout.verticalSpacing = 9;

		Label label = new Label(container, SWT.NULL);
		label.setText("Ear name:");

		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		earNameWithSuffix = new Label(container, SWT.NULL);
		earNameWithSuffix.setLayoutData(gd);

		label = new Label(container, SWT.NULL);
		label.setText("&Ear name prefix:");

		earName = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		earName.setLayoutData(gd);
		earName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});

		copyEarTemplate = new Button(container, SWT.CHECK);
		copyEarTemplate.setText("Copy Ear template from CVS");

		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		copyEarTemplate.setLayoutData(gd);

		gd = new GridData();
		gd.horizontalIndent = 20;
		final Label tlabel = new Label(container, SWT.NULL);
		tlabel.setText("Ear &template:");
		tlabel.setLayoutData(gd);

		templateName = new Text(container, SWT.BORDER | SWT.SINGLE);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		templateName.setLayoutData(gd);
		templateName.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				dialogChanged();
			}
		});

		copyEarTemplate.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent arg0) {
				boolean selection = ((Button) arg0.getSource()).getSelection();
				templateName.setEnabled(selection);
				importProjectSet.setEnabled(selection);
				table.getTable().setEnabled(selection);
				tlabel.setEnabled(selection);
				dialogChanged();
			}

			public void widgetDefaultSelected(SelectionEvent arg0) {
			}
		});

		table = createTable(container, 2);
		table.setContentProvider(new WorkbenchContentProvider());
		table.setLabelProvider(new DecoratingRepoLabelProvider());
		table.setComparator(new RepositoryComparator());
		table.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				getContainer().showPage(getNextPage());
			}
		});
		table.getTable().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				traverseRepositories(e.character);
			}
		});

		setControl(container);

		importProjectSet = new Button(container, SWT.CHECK);
		importProjectSet.setText("Import project set");

		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		importProjectSet.setLayoutData(gd);

		initializeValues();
		table.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				result = (ICVSRepositoryLocation) ((IStructuredSelection) table.getSelection()).getFirstElement();
			}
		});

		earName.setFocus();
	}

	private void initializeValues() {

		ICVSRepositoryLocation[] locations = CVSUIPlugin.getPlugin().getRepositoryManager().getKnownRepositoryLocations();
		AdaptableList input = new AdaptableList(locations);
		table.setInput(input);

		templateName.setText(WildebeestPlugin.getDefault().getPreferenceStore().getString(
				PreferenceConstants.P_CVS_EAR_TEMPLATE_PROJECT));
		if (locations.length == 0) {
			copyEarTemplate.setSelection(false);
			importProjectSet.setSelection(false);
		} else {
			copyEarTemplate.setSelection(true);
			importProjectSet.setSelection(true);
			result = locations[0];
			table.setSelection(new StructuredSelection(result));
		}

		boolean earExists = WildebeestPlugin.getDefault().getEarManager().getActiveEar() != null;
		earName.setEditable(!earExists);
		updateStatus(earExists ? "There is already Ear defined in current workspace" : null);
	}

	public ICVSRepositoryLocation getLocation() {
		return copyEarTemplate.getSelection() ? result : null;
	}

	private void traverseRepositories(char c) {
		TableItem[] items = table.getTable().getItems();
		TableItem currentSelection = table.getTable().getSelection()[0];
		int currentSelectionIndex = 0;
		for (int i = 0; i < items.length; i++) {
			if (items[i].equals(currentSelection)) {
				currentSelectionIndex = i;
				break;
			}
		}
		for (int i = currentSelectionIndex + 1; i < items.length; i++) {
			if (c == items[i].getText().charAt(1)) {
				table.getTable().setSelection(i);
				return;
			}
		}
		for (int i = 0; i < currentSelectionIndex; i++) {
			if (c == items[i].getText().charAt(1)) {
				table.getTable().setSelection(i);
				return;
			}
		}
	}

	@Override
	public Image getImage() {
		return super.getImage();
	}

	/**
	 * Ensures that both text fields are set.
	 * 
	 * @throws CVSException
	 */
	private void dialogChanged() {
		String name = earName.getText();

		if (name.length() == 0) {
			updateStatus("Ear name must be specified");
			return;
		}

		if (name.replace('\\', '/').indexOf('/', 1) > 0) {
			updateStatus("Ear name must be valid");
			return;
		}

		final IProject handle = ResourcesPlugin.getWorkspace().getRoot().getProject(name);
		if (handle.exists()) {
			updateStatus("Project '" + name + "' elready exists in workspace");
			return;
		}

		if (copyEarTemplate.getSelection()) {

			ICVSRepositoryLocation location = getLocation();
			if (location == null) {
				updateStatus("Select CVS repository location");
				return;
			}

			String template = templateName.getText();
			if (template.length() == 0) {
				updateStatus("Template name must be specified");
				return;
			}

			ICVSRemoteFolder remoteFolder = location.getRemoteFolder(template, CVSTag.DEFAULT);
			try {
				if (remoteFolder == null || !remoteFolder.exists()) {
					updateStatus("Template folder doesn't exist");
					return;
				}
			} catch (CVSException e) {
			}

		}

		updateStatus(null);

	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		setEarName(message == null ? earName.getText() : null);
		setPageComplete(message == null);
	}

	private void setEarName(String name) {
		name = name != null && !"".equals(name) ? name + "EAR" : "";
		earNameWithSuffix.setText(name);
		earNameWithSuffix.redraw();
	}

	public String getEarName() {
		return earNameWithSuffix.getText();
	}

	public String getTemplateName() {
		return templateName.getText();
	}

	public boolean importProjectSet() {
		return importProjectSet.getSelection();
	}

}