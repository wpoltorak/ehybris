package com.lambda.plugin.yunit.view.action;

import org.eclipse.jdt.internal.junit.ui.JUnitPlugin;
import org.eclipse.jface.action.Action;

import com.lambda.plugin.yunit.YUnitMessages;
import com.lambda.plugin.yunit.view.YUnitView;

public class StopAction extends Action {
	private final YUnitView view;

	public StopAction(YUnitView view) {
		this.view = view;
		setText(YUnitMessages.FunctestView_stopaction_text);
		setToolTipText(YUnitMessages.FunctestView_stopaction_tooltip);
		JUnitPlugin.setLocalImageDescriptors(this, "stop.gif"); //$NON-NLS-1$
	}

	@Override
	public void run() {
		view.stopTest();
		setEnabled(false);
	}
}