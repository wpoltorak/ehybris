package com.kizoom.plugin.wildebeest.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.menus.CommandContributionItem;

import com.kizoom.plugin.actions.AbstractActionMenuCreator;
import com.kizoom.plugin.wildebeest.WildebeestPlugin;
import com.kizoom.plugin.wildebeest.ear.actions.ChangeSharingAction;
import com.kizoom.plugin.wildebeest.ear.actions.FindProjectReferenceAction;
import com.kizoom.plugin.wildebeest.ear.actions.FindUnreferencedProjectsAction;
import com.kizoom.plugin.wildebeest.ear.actions.OpenDeploymentConsoleAction;
import com.kizoom.plugin.wildebeest.ear.actions.ToggleEarNatureAction;
import com.kizoom.plugin.wildebeest.webapp.actions.ToggleWebappNatureAction;

public class WildebeestProjectMenuCreator extends AbstractActionMenuCreator {

	@Override
	public void createProjectMenu(IMenuManager mgr) {
		int selectionType = SelectionUtil.getSelectionType(selection);
		if (selectionType == SelectionUtil.UNSUPPORTED) {
			return;
		}

		if (selectionType == SelectionUtil.PROJECT_WITH_EAR_NATURE) {
			mgr.appendToGroup(NATURE, getAction(new ToggleEarNatureAction(), //
					ToggleEarNatureAction.ID, "Remove Ear nature"));
		} else 	if (selectionType == SelectionUtil.PROJECT_WITH_WEBAPP_NATURE) {
			mgr.appendToGroup(NATURE, getAction(new ToggleWebappNatureAction(), //
					ToggleEarNatureAction.ID, "Remove Webapp nature"));
		}


		boolean exist = WildebeestPlugin.getDefault().getEarManager().getRoot()
				.getEars().length > 0;
		if (selectionType == SelectionUtil.PROJECT_WITHOUT_NATURES && !exist) {
			mgr.appendToGroup(NATURE, getAction(new ToggleEarNatureAction(), //
					ToggleEarNatureAction.ID, "Add Ear nature"));
		}
		if (selectionType == SelectionUtil.PROJECT_WITH_JAVA_NATURE){
			mgr.appendToGroup(NATURE, getAction(new ToggleWebappNatureAction(), //
					ToggleEarNatureAction.ID, "Add Webapp nature"));
		}

		mgr.appendToGroup(UTIL, getAction(new ChangeSharingAction(), //
				ChangeSharingAction.ID, "Change project sharing"));

		if (selection.size() == 1){
			mgr.appendToGroup(UTIL, getAction(new FindProjectReferenceAction(), //
					FindProjectReferenceAction.ID, "CVS project references"));
		}

		mgr.appendToGroup(UTIL, getAction(new FindUnreferencedProjectsAction(), //
				FindUnreferencedProjectsAction.ID, "Find unreferenced projects in Ear"));
	}
	
	@SuppressWarnings("serial")
	@Override
	public List<IContributionItem> getMainMenuItemsToFill() {
		return new ArrayList<IContributionItem>(){{
			add(new CommandContributionItem(createParameter(OpenDeploymentConsoleAction.ID)));
		}};
	}

}
