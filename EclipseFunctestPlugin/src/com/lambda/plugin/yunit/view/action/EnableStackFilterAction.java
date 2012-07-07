package com.lambda.plugin.yunit.view.action;

import org.eclipse.jdt.internal.junit.ui.JUnitPlugin;
import org.eclipse.jface.action.Action;

import com.lambda.plugin.yunit.FunctestMessages;
import com.lambda.plugin.yunit.preferences.FunctestPreferencePage;
import com.lambda.plugin.yunit.view.FailureTrace;

public class EnableStackFilterAction extends Action {

	private final FailureTrace fView;

	public EnableStackFilterAction(FailureTrace view) {
		super(FunctestMessages.EnableStackFilterAction_action_label);
		setDescription(FunctestMessages.EnableStackFilterAction_action_description);
		setToolTipText(FunctestMessages.EnableStackFilterAction_action_tooltip);

		setDisabledImageDescriptor(JUnitPlugin.getImageDescriptor("dlcl16/cfilter.gif")); //$NON-NLS-1$
		setHoverImageDescriptor(JUnitPlugin.getImageDescriptor("elcl16/cfilter.gif")); //$NON-NLS-1$
		setImageDescriptor(JUnitPlugin.getImageDescriptor("elcl16/cfilter.gif")); //$NON-NLS-1$

		fView = view;
		setChecked(FunctestPreferencePage.getFilterStack());
	}

	@Override
	public void run() {
		FunctestPreferencePage.setFilterStack(isChecked());
		fView.refresh();
	}
}
