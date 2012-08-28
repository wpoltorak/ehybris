package com.lambda.plugin.yunit.view.action;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.preference.IPreferenceStore;

import com.lambda.plugin.YMessages;
import com.lambda.plugin.YPlugin;
<<<<<<< HEAD
import com.lambda.plugin.preferences.PreferenceConstants;
=======
import com.lambda.plugin.YMessages;
import com.lambda.plugin.yunit.preferences.YUnitPreferencesConstants;
>>>>>>> branch 'master' of git@bitbucket.org:wojciech.poltorak/ehybris.git
import com.lambda.plugin.yunit.view.YUnitView;

public class ActivateOnErrorAction extends Action {

    private final YUnitView view;

<<<<<<< HEAD
    public ActivateOnErrorAction(YUnitView view) {
        super(YMessages.FunctestView_activate_on_failure_only, IAction.AS_CHECK_BOX);
        this.view = view;
        //setImageDescriptor(JUnitPlugin.getImageDescriptor("obj16/failures.gif")); //$NON-NLS-1$
        update();
    }
=======
	public ActivateOnErrorAction(YUnitView view) {
		super(YMessages.FunctestView_activate_on_failure_only, IAction.AS_CHECK_BOX);
		this.view = view;
		//setImageDescriptor(JUnitPlugin.getImageDescriptor("obj16/failures.gif")); //$NON-NLS-1$
		update();
	}
>>>>>>> branch 'master' of git@bitbucket.org:wojciech.poltorak/ehybris.git

    public void update() {
        IPreferenceStore store = YPlugin.getDefault().getPreferenceStore();
        setChecked(store.getBoolean(PreferenceConstants.YUNIT_SHOW_ON_ERROR_ONLY));
    }

    @Override
    public void run() {
        boolean checked = isChecked();
        view.setShowOnErrorOnly(checked);
        IPreferenceStore store = YPlugin.getDefault().getPreferenceStore();
        store.setValue(PreferenceConstants.YUNIT_SHOW_ON_ERROR_ONLY, checked);
    }
}
