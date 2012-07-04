package com.kizoom.plugin.actions;

import org.eclipse.jface.action.IMenuManager;

public class DefaultProjectMenuCreator extends AbstractActionMenuCreator {

	@Override
	public void createProjectMenu(IMenuManager mgr) {
		int selectionType = SelectionUtil.getSelectionType(selection);
		if (selectionType == SelectionUtil.UNSUPPORTED) {
			return;
		}
	
		//add here common menu items
	}
}