package com.lambda.plugin.yunit.view.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.preference.IPreferenceStore;

import com.lambda.plugin.yunit.FunctestMessages;
import com.lambda.plugin.yunit.FunctestPlugin;
import com.lambda.plugin.yunit.preferences.FunctestPreferencesConstants;
import com.lambda.plugin.yunit.view.FunctestView;

public class ActivateOnErrorAction extends Action {

	private final FunctestView view;

	public ActivateOnErrorAction(FunctestView view) {
		super(FunctestMessages.FunctestView_activate_on_failure_only, IAction.AS_CHECK_BOX);
		this.view = view;
		//setImageDescriptor(JUnitPlugin.getImageDescriptor("obj16/failures.gif")); //$NON-NLS-1$
		update();
	}

	public void update() {
		IPreferenceStore store = FunctestPlugin.getDefault().getPreferenceStore();
		setChecked(store.getBoolean(FunctestPreferencesConstants.SHOW_ON_ERROR_ONLY));
	}

	@Override
	public void run() {
		boolean checked = isChecked();
		view.setShowOnErrorOnly(checked);
		IPreferenceStore store = FunctestPlugin.getDefault().getPreferenceStore();
		store.setValue(FunctestPreferencesConstants.SHOW_ON_ERROR_ONLY, checked);
	}
}