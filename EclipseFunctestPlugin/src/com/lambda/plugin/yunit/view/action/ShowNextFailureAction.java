package com.lambda.plugin.yunit.view.action;

import org.eclipse.jdt.internal.junit.ui.JUnitPlugin;
import org.eclipse.jface.action.Action;

import com.lambda.plugin.yunit.FunctestMessages;
import com.lambda.plugin.yunit.view.FunctestView;

public class ShowNextFailureAction extends Action {

	private FunctestView fPart;

	public ShowNextFailureAction(FunctestView part) {
		super(FunctestMessages.ShowNextFailureAction_label);
		setDisabledImageDescriptor(JUnitPlugin.getImageDescriptor("dlcl16/select_next.gif")); //$NON-NLS-1$
		setHoverImageDescriptor(JUnitPlugin.getImageDescriptor("elcl16/select_next.gif")); //$NON-NLS-1$
		setImageDescriptor(JUnitPlugin.getImageDescriptor("elcl16/select_next.gif")); //$NON-NLS-1$
		setToolTipText(FunctestMessages.ShowNextFailureAction_tooltip);
		fPart = part;
	}

	@Override
	public void run() {
		fPart.selectNextFailure();
	}
}
