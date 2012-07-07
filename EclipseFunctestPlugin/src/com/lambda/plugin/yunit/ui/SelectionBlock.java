package com.lambda.plugin.yunit.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jdt.core.IClassFile;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaModel;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.ui.wizards.TypedElementSelectionValidator;
import org.eclipse.jdt.internal.ui.wizards.TypedViewerFilter;
import org.eclipse.jdt.ui.JavaElementComparator;
import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.jdt.ui.StandardJavaElementContentProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.actions.SelectionListenerAction;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.internal.WorkbenchPlugin;

import com.kizoom.plugin.KizoomPlugin;
import com.lambda.plugin.yunit.FunctestMessages;
import com.lambda.plugin.yunit.FunctestPropertyTester;
import com.lambda.plugin.yunit.launcher.FunctestLaunchConfigurationUtils;

public class SelectionBlock extends FunctestBlock {

	public static final String PROPERTY_TEST_SELECTION = "PROPERTY_TEST_SELECTION"; //$NON-NLS-1$

	private final ViewerComparator fJavaElementComparator = new JavaElementComparator();
	private TableViewer selectionTable;
	private AddAction fAddAction;
	private RemoveAction fRemoveAction;

	@Override
	public void createControl(Composite comp) {
		super.createControl(comp);
		
		selectionTable = new TestSelectionViewer(comp);

		Composite pathButtonComp = SWTFactory.createComposite(comp, comp.getFont(), 1, 1, GridData.VERTICAL_ALIGN_BEGINNING
				| GridData.HORIZONTAL_ALIGN_FILL, 0, 0);
		fAddAction = new AddAction(pathButtonComp);
		fRemoveAction = new RemoveAction(pathButtonComp);
		fRemoveAction.setEnabled(false);

		fAddAction.setViewer(selectionTable);
		fRemoveAction.setViewer(selectionTable);

	}

	// TODO FunctestPlugin: setUpMethod is being displayed
	private Object[] chooseFunctests() {
		Class<?>[] acceptedClasses = new Class[] { IJavaModel.class, IJavaProject.class, IPackageFragmentRoot.class,
				IPackageFragment.class, ICompilationUnit.class, IClassFile.class, IType.class, IMethod.class };

		TypedElementSelectionValidator validator = new TypedElementSelectionValidator(acceptedClasses, true) {
			@Override
			public boolean isSelectedValid(Object element) {
				return true;
			}
		};

		acceptedClasses = new Class[] { IJavaModel.class, IJavaProject.class, IPackageFragmentRoot.class,
				IPackageFragment.class, ICompilationUnit.class, IClassFile.class, IType.class, IMethod.class };
		ViewerFilter filter = new TypedViewerFilter(acceptedClasses) {
			FunctestPropertyTester tester = new FunctestPropertyTester();

			@Override
			public boolean select(Viewer viewer, Object parent, Object element) {
				if (element instanceof IPackageFragmentRoot && ((IPackageFragmentRoot) element).isArchive())
					return false;
				try {
					if (element instanceof IPackageFragment && !((IPackageFragment) element).hasChildren()) {
						return false;
					}
				} catch (JavaModelException e) {
					return false;
				}
				boolean functest = tester.test(element, FunctestPropertyTester.PROPERTY_CAN_LAUNCH_AS_FUNCTEST, null, null);
				if (!functest)
					return false;
				return super.select(viewer, parent, element);
			}
		};

		StandardJavaElementContentProvider provider = new StandardJavaElementContentProvider(true);
		ILabelProvider labelProvider = new DecoratingLabelProvider(new JavaElementLabelProvider(
				JavaElementLabelProvider.SHOW_DEFAULT), WorkbenchPlugin.getDefault().getDecoratorManager());

		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(getShell(), labelProvider, provider);
		dialog.setValidator(validator);
		dialog.setComparator(new JavaElementComparator());
		dialog.setHelpAvailable(false);
		dialog.setTitle(FunctestMessages.FunctestLaunchConfigurationTab_folderdialog_title);
		dialog.setMessage(FunctestMessages.FunctestLaunchConfigurationTab_folderdialog_message);
		dialog.addFilter(filter);
		dialog.setInput(JavaCore.create(getWorkspaceRoot()));
		// dialog.setInitialSelection(initElement);
		dialog.setAllowMultiple(true);

		if (dialog.open() == Window.OK) {
			return dialog.getResult();
		}
		return null;
	}

	private IWorkspaceRoot getWorkspaceRoot() {
		return ResourcesPlugin.getWorkspace().getRoot();
	}

	public void setInput(Object o) {
		selectionTable.setInput(o);
	}

	private class FunctestSelectionAction extends SelectionListenerAction {

		protected TableViewer fViewer;
		protected Button fButton;

		protected FunctestSelectionAction(Button button, String text) {
			super(text);
			this.fButton = button;
			this.fButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent evt) {
					run();
					selectionTable.refresh();
					updateSelection(getStructuredSelection());
				}
			});
		}

		@Override
		public void setEnabled(boolean enabled) {
			super.setEnabled(enabled);
			fButton.setEnabled(enabled);
		}

		public void setViewer(TableViewer viewer) {
			if (fViewer != null) {
				fViewer.removeSelectionChangedListener(this);
			}
			fViewer = viewer;
			if (fViewer != null) {
				fViewer.addSelectionChangedListener(this);
				selectionChanged((IStructuredSelection) fViewer.getSelection());
			}
		}
	}

	// TODO FunctestPlugin: dodaj prawidlowa serializacje testow (who cares?)
	// TODO FunctestPlugin: dodaj prawidlowa walidacje pliku xml launcha
	private class AddAction extends FunctestSelectionAction {

		protected AddAction(Composite comp) {
			super(SWTFactory.createPushButton(comp, "Add", null), "Add");
		}

		@Override
		public void run() {
			try {
				List<IJavaElement> elements = FunctestLaunchConfigurationUtils.filterElementsToLaunch(chooseFunctests());
				if (elements != null) {
					selectionTable.remove(elements.toArray(new IJavaElement[elements.size()]));
					selectionTable.add(elements.toArray(new IJavaElement[elements.size()]));

					if (selectionTable.getTable().getItems().length > 0) {
						setStatus(OK_STATUS);
					}
					SelectionBlock.this.firePropertyChange(PROPERTY_TEST_SELECTION, null);
				}
			} catch (Exception e) {
				MessageDialog.openInformation(getShell(), "Functest Launch",
						"There were problems during selecting elemants for functest run. See log for details.");
				KizoomPlugin.logError("There were problems during selecting elemants for functest run.", e);
			}
		}
	}

	private class RemoveAction extends FunctestSelectionAction {

		protected RemoveAction(Composite comp) {
			super(SWTFactory.createPushButton(comp, "Remove", null), "Remove");
		}

		@Override
		public void run() {
			setStatus(OK_STATUS);
			selectionTable.remove(getStructuredSelection().toArray());
			if (selectionTable.getTable().getItems().length == 0) {
				setError("Provide functest elements to run");
			}
			SelectionBlock.this.firePropertyChange(PROPERTY_TEST_SELECTION, null);
		}

		@Override
		protected boolean updateSelection(IStructuredSelection selection) {
			return !selection.isEmpty();
		}

	}

	@Override
	public void dispose() {
	}

	private class FunctestElementsLabelProvider extends LabelProvider implements ITableLabelProvider {

		private final ILabelProvider fJavaElementLabelProvider = new JavaElementLabelProvider();

		@Override
		public String getText(Object element) {

			if (element instanceof IJavaElement) {
				IJavaElement javaElement = (IJavaElement) element;
				switch (javaElement.getElementType()) {
					case IJavaElement.PACKAGE_FRAGMENT_ROOT:
					case IJavaElement.PACKAGE_FRAGMENT:
						return FunctestMessages.format(
								FunctestMessages.TestSelectionElementsLabelProvider_testElementName_projectName, new Object[] {
										fJavaElementLabelProvider.getText(element), javaElement.getJavaProject().getProject().getName() });
					case IJavaElement.TYPE:
						return FunctestMessages.format(
								FunctestMessages.TestSelectionElementsLabelProvider_testElementName_projectName, new Object[] {
										((IType) element).getFullyQualifiedName(), javaElement.getJavaProject().getProject().getName() });
					case IJavaElement.METHOD:
						IMethod method = (IMethod) element;
						return FunctestMessages.format(
								FunctestMessages.TestSelectionElementsLabelProvider_testElementName_projectName, new Object[] {
										method.getDeclaringType().getFullyQualifiedName() + "." + method.getElementName(),
										javaElement.getJavaProject().getProject().getName() });
				}
			}
			return fJavaElementLabelProvider.getText(element);
		}

		public String getColumnText(Object element, int columnIndex) {
			return getText(element);
		}

		@Override
		public Image getImage(Object element) {
			return fJavaElementLabelProvider.getImage(element);
		}

		public Image getColumnImage(Object element, int columnIndex) {
			return getImage(element);
		}

		@Override
		public void dispose() {
			fJavaElementLabelProvider.dispose();
		}
	}

	private class FunctestElementsContentProvider implements IStructuredContentProvider {

		public Object[] getElements(Object inputElement) {
			List<IJavaElement> elements = null;
			ILaunchConfiguration config = (ILaunchConfiguration) inputElement;

			try {
				elements = FunctestLaunchConfigurationUtils.retrieveJavaElements(config);
			} catch (CoreException e) {
				setError("Error reading configuration");
				KizoomPlugin.logError("Error reading configuration", e); //$NON-NLS-1$
				return new IJavaElement[0];
			}
			if (elements.isEmpty())
				setError("Provide functest elements to run");
			return elements.toArray(new IJavaElement[elements.size()]);
		}

		public void dispose() {
		}

		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			if (newInput == null)
				return;
			if (viewer instanceof TableViewer) {
				TableViewer tableViewer = (TableViewer) viewer;
				if (tableViewer.getTable().isDisposed())
					return;
				tableViewer.setComparator(fJavaElementComparator);
				selectionTable.refresh();
			}
		}
	}

	public List<IJavaElement> getSelectedElements() {
		TableItem[] items = selectionTable.getTable().getItems();
		List<IJavaElement> elements = new ArrayList<IJavaElement>(items.length);
		for (TableItem tableItem : items) {
			elements.add((IJavaElement) tableItem.getData());
		}
		return elements;
	}
	
	private class TestSelectionViewer extends TableViewer {
		
		public TestSelectionViewer(Composite comp) {
			super(comp, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL | SWT.MULTI | SWT.FULL_SELECTION);

			Table table = getTable();

			table.setLayout(new GridLayout());
			table.setLayoutData(new GridData(GridData.FILL_BOTH));
			table.setFont(comp.getFont());
			
			setContentProvider(new FunctestElementsContentProvider());
			setLabelProvider(new FunctestElementsLabelProvider());
			setColumnProperties(new String[] { "selection" });
			TableColumn tc = new TableColumn(table, SWT.LEFT, 0);
			tc.setMoveable(false);
			tc.setResizable(false);
		}

		protected void internalRefresh(Object element, boolean updateLabels) {
			super.internalRefresh(element, updateLabels);
			pack();
		}
		
		private Table pack() {
			Table table = getTable();
			for (int i = 0, n = table.getColumnCount(); i < n; i++) {
				table.getColumn(i).pack();
			}
			return table;
		}
	}
}
