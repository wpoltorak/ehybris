package com.lambda.plugin.yunit.view.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.preference.IPreferenceStore;

import com.lambda.plugin.YPlugin;
import com.lambda.plugin.yunit.YUnitMessages;
import com.lambda.plugin.yunit.preferences.YUnitPreferencesConstants;
import com.lambda.plugin.yunit.view.YUnitView;

public class ActivateOnErrorAction extends Action {

	private final YUnitView view;

	public ActivateOnErrorAction(YUnitView view) {
		super(YUnitMessages.FunctestView_activate_on_failure_only, IAction.AS_CHECK_BOX);
		this.view = view;
		//setImageDescriptor(JUnitPlugin.getImageDescriptor("obj16/failures.gif")); //$NON-NLS-1$
		update();
	}

	public void update() {
		IPreferenceStore store = YPlugin.getDefault().getPreferenceStore();
		setChecked(store.getBoolean(YUnitPreferencesConstants.SHOW_ON_ERROR_ONLY));
	}

	@Override
	public void run() {
		boolean checked = isChecked();
		view.setShowOnErrorOnly(checked);
		IPreferenceStore store = YPlugin.getDefault().getPreferenceStore();
		store.setValue(YUnitPreferencesConstants.SHOW_ON_ERROR_ONLY, checked);
	}
}