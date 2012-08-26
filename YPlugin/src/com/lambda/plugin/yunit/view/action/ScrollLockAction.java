package com.lambda.plugin.yunit.view.action;

import org.eclipse.jdt.internal.junit.ui.JUnitPlugin;
import org.eclipse.jface.action.Action;

import com.lambda.plugin.YMessages;
import com.lambda.plugin.yunit.view.YUnitView;

public class ScrollLockAction extends Action {

	private YUnitView fRunnerViewPart;

	public ScrollLockAction(YUnitView viewer) {
		super(YMessages.ScrollLockAction_action_label);
		fRunnerViewPart = viewer;
		setToolTipText(YMessages.ScrollLockAction_action_tooltip);
		setDisabledImageDescriptor(JUnitPlugin.getImageDescriptor("dlcl16/lock.gif")); //$NON-NLS-1$
		setHoverImageDescriptor(JUnitPlugin.getImageDescriptor("elcl16/lock.gif")); //$NON-NLS-1$
		setImageDescriptor(JUnitPlugin.getImageDescriptor("elcl16/lock.gif")); //$NON-NLS-1$
		setChecked(false);
	}

	/**
	 * @see org.eclipse.jface.action.IAction#run()
	 */
	@Override
	public void run() {
		fRunnerViewPart.setAutoScroll(!isChecked());
	}
}