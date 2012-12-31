package com.lambda.plugin.yunit.actions;

import org.eclipse.jface.action.IMenuManager;

import com.lambda.plugin.actions.AbstractActionMenuCreator;

public class FunctestProjectMenuCreator extends AbstractActionMenuCreator {

	@Override
	public void createProjectMenu(IMenuManager mgr) {
		int selectionType = SelectionUtil.getSelectionType(selection);
		if (selectionType == SelectionUtil.UNSUPPORTED) {
			return;
		}
		
		if (selectionType == SelectionUtil.PROJECT_WITH_FUNCTEST_NATURE) {
			mgr.appendToGroup(NATURE, getAction(new ToggleFunctestNatureAction(), //
					ToggleFunctestNatureAction.ID, "Remove Functest nature"));
		}

		if (selectionType == SelectionUtil.PROJECT_WITH_JAVA_NATURE) {
			mgr.appendToGroup(NATURE, getAction(new ToggleFunctestNatureAction(), //
					ToggleFunctestNatureAction.ID, "Add Functest nature"));
		}
	}
}