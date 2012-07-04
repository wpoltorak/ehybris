package com.kizoom.plugin.functest.view.action;

import org.eclipse.jdt.internal.junit.ui.JUnitPlugin;
import org.eclipse.jface.action.Action;

import com.kizoom.plugin.functest.FunctestMessages;
import com.kizoom.plugin.functest.view.FunctestView;

public class ShowPreviousFailureAction extends Action {

	private FunctestView fPart;

	public ShowPreviousFailureAction(FunctestView part) {
		super(FunctestMessages.ShowPreviousFailureAction_label);
		setDisabledImageDescriptor(JUnitPlugin.getImageDescriptor("dlcl16/select_prev.gif")); //$NON-NLS-1$
		setHoverImageDescriptor(JUnitPlugin.getImageDescriptor("elcl16/select_prev.gif")); //$NON-NLS-1$
		setImageDescriptor(JUnitPlugin.getImageDescriptor("elcl16/select_prev.gif")); //$NON-NLS-1$
		setToolTipText(FunctestMessages.ShowPreviousFailureAction_tooltip);
		fPart = part;
	}

	@Override
	public void run() {
		fPart.selectPreviousFailure();
	}
}
