package com.lambda.plugin.yunit.view.action;

import org.eclipse.jdt.internal.junit.ui.JUnitPlugin;
import org.eclipse.jface.action.Action;

import com.lambda.plugin.yunit.FunctestMessages;
import com.lambda.plugin.yunit.view.FunctestView;

public class StopAction extends Action {
	private final FunctestView view;

	public StopAction(FunctestView view) {
		this.view = view;
		setText(FunctestMessages.FunctestView_stopaction_text);
		setToolTipText(FunctestMessages.FunctestView_stopaction_tooltip);
		JUnitPlugin.setLocalImageDescriptors(this, "stop.gif"); //$NON-NLS-1$
	}

	@Override
	public void run() {
		view.stopTest();
		setEnabled(false);
	}
}