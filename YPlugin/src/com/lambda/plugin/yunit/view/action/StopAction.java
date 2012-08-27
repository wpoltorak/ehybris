package com.lambda.plugin.yunit.view.action;

import org.eclipse.jdt.internal.junit.ui.JUnitPlugin;
import org.eclipse.jface.action.Action;

import com.lambda.plugin.YMessages;
import com.lambda.plugin.yunit.view.YUnitView;

public class StopAction extends Action {
	private final YUnitView view;

	public StopAction(YUnitView view) {
		this.view = view;
		setText(YMessages.FunctestView_stopaction_text);
		setToolTipText(YMessages.FunctestView_stopaction_tooltip);
		JUnitPlugin.setLocalImageDescriptors(this, "stop.gif"); //$NON-NLS-1$
	}

	@Override
	public void run() {
		view.stopTest();
		setEnabled(false);
	}
}