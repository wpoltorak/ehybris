package com.lambda.plugin.yunit.view.action;

import org.eclipse.jdt.internal.junit.ui.JUnitPlugin;
import org.eclipse.jface.action.Action;

import com.lambda.plugin.yunit.FunctestMessages;
import com.lambda.plugin.yunit.view.FunctestView;

public class ScrollLockAction extends Action {

	private FunctestView fRunnerViewPart;

	public ScrollLockAction(FunctestView viewer) {
		super(FunctestMessages.ScrollLockAction_action_label);
		fRunnerViewPart = viewer;
		setToolTipText(FunctestMessages.ScrollLockAction_action_tooltip);
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