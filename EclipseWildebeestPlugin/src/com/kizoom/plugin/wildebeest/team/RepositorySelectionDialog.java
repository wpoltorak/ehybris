package com.kizoom.plugin.wildebeest.team;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.team.internal.ccvs.core.ICVSRepositoryLocation;
import org.eclipse.team.internal.ccvs.ui.CVSUIMessages;
import org.eclipse.team.internal.ccvs.ui.CVSUIPlugin;
import org.eclipse.team.internal.ccvs.ui.repo.RepositoryComparator;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

@SuppressWarnings("restriction")
public class RepositorySelectionDialog extends Dialog {

	private static final int TABLE_HEIGHT_HINT = 150;

	ICVSRepositoryLocation[] allLocations;
	ICVSRepositoryLocation[] compatibleLocatons;
	ICVSRepositoryLocation selectedLocation;

	TableViewer viewer;
	Button okButton;
	boolean showCompatible = true;

	public RepositorySelectionDialog(Shell shell, Collection<ICVSRepositoryLocation> oldLocations) {
		super(shell);
		initialize(oldLocations);
	}

	private void initialize(Collection<ICVSRepositoryLocation> oldLocations) {
		allLocations = CVSUIPlugin.getPlugin().getRepositoryManager().getKnownRepositoryLocations();
		List<ICVSRepositoryLocation> locations = new ArrayList<ICVSRepositoryLocation>();
		for (int i = 0; i < allLocations.length; i++) {
			ICVSRepositoryLocation location = allLocations[i];
			for (ICVSRepositoryLocation oldLocation : oldLocations) {
				if (CVSUtils.isCompatible(location, oldLocation)) {
					locations.add(location);
					break;
				}
			}
		}
		compatibleLocatons = (ICVSRepositoryLocation[]) locations.toArray(new ICVSRepositoryLocation[locations.size()]);
	}

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		// create OK and Cancel buttons by default
		okButton = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		okButton.setEnabled(false);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		parent.getShell().setText(CVSUIMessages.CVSProjectPropertiesPage_Select_a_Repository_1);
		Composite composite = (Composite) super.createDialogArea(parent);

		createLabel(composite,
				CVSUIMessages.CVSProjectPropertiesPage_Select_a_CVS_repository_location_to_share_the_project_with__2, 1);
		Table table = new Table(composite, SWT.SINGLE | SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		data.heightHint = TABLE_HEIGHT_HINT;
		table.setLayoutData(data);
		viewer = new TableViewer(table);
		viewer.setLabelProvider(new WorkbenchLabelProvider());
		viewer.setComparator(new RepositoryComparator());
		viewer.setContentProvider(new WorkbenchContentProvider() {
			@Override
			public Object[] getElements(Object inputElement) {
				if (showCompatible) {
					return compatibleLocatons;
				} else {
					return allLocations;
				}
			}
		});
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				if (selection.isEmpty()) {
					selectedLocation = null;
					okButton.setEnabled(false);
				} else {
					selectedLocation = (ICVSRepositoryLocation) selection.getFirstElement();
					okButton.setEnabled(true);
				}
			}
		});
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				okPressed();
			}
		});
		viewer.setInput(compatibleLocatons);

		final Button compatibleButton = createCheckBox(composite, CVSUIMessages.CVSProjectPropertiesPage_31);
		compatibleButton.setSelection(showCompatible);
		compatibleButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				showCompatible = compatibleButton.getSelection();
				viewer.refresh();
			}
		});

		Dialog.applyDialogFont(parent);

		return composite;
	}

	protected Label createLabel(Composite parent, String text, int span) {
		Label label = new Label(parent, SWT.LEFT);
		label.setText(text);
		GridData data = new GridData();
		data.horizontalSpan = span;
		data.horizontalAlignment = GridData.FILL;
		label.setLayoutData(data);
		return label;
	}

	protected Button createCheckBox(Composite group, String label) {
		Button button = new Button(group, SWT.CHECK | SWT.LEFT);
		button.setText(label);
		GridData data = new GridData();
		data.horizontalSpan = 2;
		button.setLayoutData(data);
		return button;
	}

	@Override
	protected void cancelPressed() {
		selectedLocation = null;
		super.cancelPressed();
	}

	public ICVSRepositoryLocation getLocation() {
		return selectedLocation;
	}
}