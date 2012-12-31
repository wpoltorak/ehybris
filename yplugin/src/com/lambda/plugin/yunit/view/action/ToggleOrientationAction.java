package com.lambda.plugin.yunit.view.action;

import org.eclipse.jdt.internal.junit.ui.IJUnitHelpContextIds;
import org.eclipse.jdt.internal.junit.ui.JUnitPlugin;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.PlatformUI;

import com.lambda.plugin.YMessages;
import com.lambda.plugin.yunit.view.YUnitView;

public class ToggleOrientationAction extends Action {

	private final int fActionOrientation;
	private final YUnitView view;

	public ToggleOrientationAction(YUnitView view, int orientation) {
		super("", AS_RADIO_BUTTON); //$NON-NLS-1$
		this.view = view;
		if (orientation == YUnitView.VIEW_ORIENTATION_HORIZONTAL) {
			setText(YMessages.FunctestView_toggle_horizontal_label);
			setImageDescriptor(JUnitPlugin.getImageDescriptor("elcl16/th_horizontal.gif")); //$NON-NLS-1$				
		} else if (orientation == YUnitView.VIEW_ORIENTATION_VERTICAL) {
			setText(YMessages.FunctestView_toggle_vertical_label);
			setImageDescriptor(JUnitPlugin.getImageDescriptor("elcl16/th_vertical.gif")); //$NON-NLS-1$				
		} else if (orientation == YUnitView.VIEW_ORIENTATION_AUTOMATIC) {
			setText(YMessages.FunctestView_toggle_automatic_label);
			setImageDescriptor(JUnitPlugin.getImageDescriptor("elcl16/th_automatic.gif")); //$NON-NLS-1$				
		}
		fActionOrientation = orientation;
		PlatformUI.getWorkbench().getHelpSystem()
				.setHelp(this, IJUnitHelpContextIds.RESULTS_VIEW_TOGGLE_ORIENTATION_ACTION);
	}

	public int getOrientation() {
		return fActionOrientation;
	}

	@Override
	public void run() {
		if (isChecked()) {
			view.computeOrientation(fActionOrientation);
		}
	}
}
