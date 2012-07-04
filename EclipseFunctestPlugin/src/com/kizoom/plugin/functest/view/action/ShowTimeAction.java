package com.kizoom.plugin.functest.view.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;

import com.kizoom.plugin.functest.FunctestMessages;
import com.kizoom.plugin.functest.view.FunctestView;

public class ShowTimeAction extends Action {

	private final FunctestView view;

	public ShowTimeAction(FunctestView view) {
		super(FunctestMessages.FunctestView_show_execution_time, IAction.AS_CHECK_BOX);
		this.view = view;
	}

	@Override
	public void run() {
		setChecked(isChecked());
		view.setShowExecutionTime(isChecked());
	}
}