package com.lambda.plugin.yunit.ui;

import java.util.List;

import org.eclipse.jdt.internal.junit.launcher.ITestKind;
import org.eclipse.jdt.internal.junit.launcher.TestKind;
import org.eclipse.jdt.internal.junit.launcher.TestKindRegistry;
import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.lambda.plugin.YMessages;
@SuppressWarnings("restriction")
public class JUnitBlock extends YUnitBlock {

	public static final String PROPERTY_JUNIT_LOADER = "PROPERTY_JUNIT_LOADER"; //$NON-NLS-1$
	public static final String PROPERTY_KEEP_RUNNING = "PROPERTY_KEEP_RUNNING"; //$NON-NLS-1$
	private final ILabelProvider fJavaElementLabelProvider = new JavaElementLabelProvider();
	private ComboViewer fTestLoaderViewer;

	@Override
	public void createControl(Composite comp) {
		super.createControl(comp);
		createTestLoaderGroup(comp);
	}

	private void createTestLoaderGroup(Composite comp) {
		Label loaderLabel = new Label(comp, SWT.NONE);
		loaderLabel.setText(YMessages.FunctestLaunchConfigurationTab_Test_Loader);
		GridData gd = new GridData();
		gd.horizontalIndent = 0;
		loaderLabel.setLayoutData(gd);

		fTestLoaderViewer = new ComboViewer(comp, SWT.DROP_DOWN | SWT.READ_ONLY);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;
		fTestLoaderViewer.getCombo().setLayoutData(gd);
		

		List<?>/* <TestKind> */items = TestKindRegistry.getDefault().getAllKinds();
		fTestLoaderViewer.setContentProvider(new ArrayContentProvider());
		fTestLoaderViewer.setLabelProvider(new LabelProvider() {
			@Override
			public String getText(Object element) {
				return ((TestKind) element).getDisplayName();
			}
		});
		fTestLoaderViewer.setInput(items);
		fTestLoaderViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				setStatus(OK_STATUS);
				ITestKind kind = getSelectedTestKind();
				if (kind == null)
					setError("No test runner kind specified.");
				firePropertyChange(PROPERTY_JUNIT_LOADER, null);
			}
		});
	}

	public ITestKind getSelectedTestKind() {
		IStructuredSelection selection = (IStructuredSelection) fTestLoaderViewer.getSelection();
		if (!selection.isEmpty())
			return (ITestKind) selection.getFirstElement();
		return null;
	}

	public void setTestKind(ITestKind kind) {
		if (kind != null)
			fTestLoaderViewer.setSelection(new StructuredSelection(kind));
	}

	@Override
	public void dispose() {
		fJavaElementLabelProvider.dispose();
	}
}
