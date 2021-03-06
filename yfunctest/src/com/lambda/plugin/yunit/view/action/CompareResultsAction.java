package com.lambda.plugin.yunit.view.action;

import org.eclipse.jdt.internal.junit.model.TestElement;
import org.eclipse.jdt.internal.junit.ui.CompareResultDialog;
import org.eclipse.jdt.internal.junit.ui.JUnitPlugin;
import org.eclipse.jface.action.Action;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;

import com.lambda.plugin.YMessages;
import com.lambda.plugin.yunit.view.FailureTrace;

public class CompareResultsAction extends Action {

	private final FailureTrace fView;
	private CompareResultDialog fOpenDialog;

	public CompareResultsAction(FailureTrace view) {
		super(YMessages.CompareResultsAction_label);
		setDescription(YMessages.CompareResultsAction_description);
		setToolTipText(YMessages.CompareResultsAction_tooltip);

		setDisabledImageDescriptor(JUnitPlugin.getImageDescriptor("dlcl16/compare.gif")); //$NON-NLS-1$
		setHoverImageDescriptor(JUnitPlugin.getImageDescriptor("elcl16/compare.gif")); //$NON-NLS-1$
		setImageDescriptor(JUnitPlugin.getImageDescriptor("elcl16/compare.gif")); //$NON-NLS-1$
		this.fView = view;

	}

	@Override
	public void run() {
		TestElement failedTest = fView.getFailedTest();
		if (fOpenDialog != null) {
			fOpenDialog.setInput(failedTest);
			fOpenDialog.getShell().setActive();

		} else {
			fOpenDialog = new CompareResultDialog(fView.getShell(), failedTest);
			fOpenDialog.create();
			fOpenDialog.getShell().addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent e) {
					fOpenDialog = null;
				}
			});
			fOpenDialog.setBlockOnOpen(false);
			fOpenDialog.open();
		}
	}

	public void updateOpenDialog(TestElement failedTest) {
		if (fOpenDialog != null) {
			fOpenDialog.setInput(failedTest);
		}
	}
}
