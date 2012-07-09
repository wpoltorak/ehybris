package com.lambda.plugin.yunit.view.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;

import com.lambda.plugin.yunit.YUnitMessages;
import com.lambda.plugin.yunit.view.YUnitView;

public class ShowTimeAction extends Action {

	private final YUnitView view;

	public ShowTimeAction(YUnitView view) {
		super(YUnitMessages.FunctestView_show_execution_time, IAction.AS_CHECK_BOX);
		this.view = view;
	}

	@Override
	public void run() {
		setChecked(isChecked());
		view.setShowExecutionTime(isChecked());
	}
}