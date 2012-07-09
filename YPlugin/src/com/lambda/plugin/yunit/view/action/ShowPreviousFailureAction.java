package com.lambda.plugin.yunit.view.action;

import org.eclipse.jdt.internal.junit.ui.JUnitPlugin;
import org.eclipse.jface.action.Action;

import com.lambda.plugin.yunit.YUnitMessages;
import com.lambda.plugin.yunit.view.YUnitView;

public class ShowPreviousFailureAction extends Action {

	private YUnitView fPart;

	public ShowPreviousFailureAction(YUnitView part) {
		super(YUnitMessages.ShowPreviousFailureAction_label);
		setDisabledImageDescriptor(JUnitPlugin.getImageDescriptor("dlcl16/select_prev.gif")); //$NON-NLS-1$
		setHoverImageDescriptor(JUnitPlugin.getImageDescriptor("elcl16/select_prev.gif")); //$NON-NLS-1$
		setImageDescriptor(JUnitPlugin.getImageDescriptor("elcl16/select_prev.gif")); //$NON-NLS-1$
		setToolTipText(YUnitMessages.ShowPreviousFailureAction_tooltip);
		fPart = part;
	}

	@Override
	public void run() {
		fPart.selectPreviousFailure();
	}
}
