package com.lambda.plugin.yunit.view.action;

import org.eclipse.jdt.internal.junit.ui.JUnitPlugin;
import org.eclipse.jface.action.Action;

import com.lambda.plugin.YMessages;
import com.lambda.plugin.yunit.view.YUnitView;

public class ShowNextFailureAction extends Action {

	private YUnitView fPart;

	public ShowNextFailureAction(YUnitView part) {
		super(YMessages.ShowNextFailureAction_label);
		setDisabledImageDescriptor(JUnitPlugin.getImageDescriptor("dlcl16/select_next.gif")); //$NON-NLS-1$
		setHoverImageDescriptor(JUnitPlugin.getImageDescriptor("elcl16/select_next.gif")); //$NON-NLS-1$
		setImageDescriptor(JUnitPlugin.getImageDescriptor("elcl16/select_next.gif")); //$NON-NLS-1$
		setToolTipText(YMessages.ShowNextFailureAction_tooltip);
		fPart = part;
	}

	@Override
	public void run() {
		fPart.selectNextFailure();
	}
}
