package com.kizoom.plugin.wildebeest.wizard;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.resource.ImageDescriptor;
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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.team.internal.ccvs.core.ICVSRepositoryLocation;
import org.eclipse.team.internal.ccvs.ui.CVSUIPlugin;
import org.eclipse.team.internal.ccvs.ui.repo.RepositoryComparator;
import org.eclipse.ui.model.AdaptableList;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import com.kizoom.plugin.wildebeest.WildebeestPlugin;

@SuppressWarnings("restriction")
public class RepositorySelectionPage extends WizardPage {

	private class DecoratingRepoLabelProvider extends WorkbenchLabelProvider {
		@Override
		protected String decorateText(String input, Object element) {
			// Used to process RTL locales only
			return TextProcessor.process(input, ":@/"); //$NON-NLS-1$
		}
	}

	private TableViewer table;

	private ICVSRepositoryLocation result;

	public RepositorySelectionPage(String pageName, String title, ImageDescriptor titleImage) {
		super(pageName, title, titleImage);
	}

	protected TableViewer createTable(Composite parent, int span) {
		Table table = new Table(parent, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER | SWT.SINGLE | SWT.FULL_SELECTION);
		GridData data = new GridData(GridData.FILL_BOTH | GridData.GRAB_HORIZONTAL);
		data.horizontalSpan = span;
		data.widthHint = 200;
		table.setLayoutData(data);
		TableLayout layout = new TableLayout();
		layout.addColumnData(new ColumnWeightData(100, true));
		table.setLayout(layout);
		TableColumn col = new TableColumn(table, SWT.NONE);
		col.setResizable(true);

		return new TableViewer(table);
	}

	public void createControl(Composite parent) {
		final Composite composite = new Composite(parent, SWT.NULL);
		composite.setLayout(new GridLayout(2, false));
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false));

		table = createTable(composite, 1);
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

		setControl(composite);

		initializeValues();
		Dialog.applyDialogFont(parent);

		table.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				result = (ICVSRepositoryLocation) ((IStructuredSelection) table.getSelection()).getFirstElement();
				updateErrors();
			}
		});
	}

	private void updateStatus(String message) {
		setErrorMessage(message);
		setPageComplete(message == null);
	}

	private void initializeValues() {
		ICVSRepositoryLocation[] locations = CVSUIPlugin.getPlugin().getRepositoryManager().getKnownRepositoryLocations();
		AdaptableList input = new AdaptableList(locations);
		table.setInput(input);
		if (locations.length == 0 || WildebeestPlugin.getDefault().getEarManager().getActiveEar() != null) {
			table.getTable().setEnabled(false);
		} else {
			table.getTable().setEnabled(true);
			result = locations[0];
			table.setSelection(new StructuredSelection(result));
		}

		updateErrors();
	}

	private void updateErrors() {
		if (WildebeestPlugin.getDefault().getEarManager().getActiveEar() != null) {
			updateStatus("There is already Ear defined in current workspace");
			return;
		}

		updateStatus(null);
	}

	public ICVSRepositoryLocation getLocation() {
		return result;
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
}
