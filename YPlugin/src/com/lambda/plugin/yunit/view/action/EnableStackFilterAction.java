package com.lambda.plugin.yunit.view.action;

import org.eclipse.jdt.internal.junit.ui.JUnitPlugin;
import org.eclipse.jface.action.Action;

import com.lambda.plugin.YMessages;
import com.lambda.plugin.yunit.preferences.YUnitPreferencePage;
import com.lambda.plugin.yunit.view.FailureTrace;

public class EnableStackFilterAction extends Action {

	private final FailureTrace fView;

	public EnableStackFilterAction(FailureTrace view) {
		super(YMessages.EnableStackFilterAction_action_label);
		setDescription(YMessages.EnableStackFilterAction_action_description);
		setToolTipText(YMessages.EnableStackFilterAction_action_tooltip);

		setDisabledImageDescriptor(JUnitPlugin.getImageDescriptor("dlcl16/cfilter.gif")); //$NON-NLS-1$
		setHoverImageDescriptor(JUnitPlugin.getImageDescriptor("elcl16/cfilter.gif")); //$NON-NLS-1$
		setImageDescriptor(JUnitPlugin.getImageDescriptor("elcl16/cfilter.gif")); //$NON-NLS-1$

		fView = view;
		setChecked(YUnitPreferencePage.getFilterStack());
	}

	@Override
	public void run() {
		YUnitPreferencePage.setFilterStack(isChecked());
		fView.refresh();
	}
}
