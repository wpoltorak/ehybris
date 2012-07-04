package com.kizoom.plugin.actions;

import java.util.Collections;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;

import com.kizoom.plugin.KizoomPlugin;

public abstract class AbstractActionMenuCreator {

	public static final String NEW = "new";
	public static final String OPEN = "open";
	public static final String UPDATE = "update";
	public static final String NATURE = "nature";
	public static final String IMPORT = "import";
	public static final String UTIL = "util";

	protected IStructuredSelection selection;

	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			this.selection = (IStructuredSelection) selection;
		}
	}

	/**
	 * Creates menu items in given project menu manager.
	 */
	public abstract void createProjectMenu(IMenuManager mgr);

	/**
	 * Creates menu items in given eclipse main menu manager.
	 */
	public List<IContributionItem> getMainMenuItemsToFill() {
		return Collections.<IContributionItem> emptyList();
	}

	/**
	 * Creates menu items in given toolbar menu manager.
	 */
	public List<IContributionItem> getToolbarItems() {
		return Collections.<IContributionItem> emptyList();
	}

	protected CommandContributionItemParameter createParameter(String id) {
		return new CommandContributionItemParameter(PlatformUI.getWorkbench(), id + "Item", id,
				CommandContributionItem.STYLE_PUSH);
	}

	/**
	 * A helper method to create IAction instance from given IActionDelegate.
	 */
	protected IAction getAction(IActionDelegate delegate, String id, String text) {
		return getAction(delegate, id, text, (ImageDescriptor) null);
	}

	/**
	 * A helper method to create IAction instance from given IActionDelegate.
	 */
	protected IAction getAction(IActionDelegate delegate, String id, String text, String image) {
		return getAction(delegate, id, text, KizoomPlugin.getImageDescriptor(image));
	}

	protected IAction getAction(IActionDelegate delegate, String id, String text, ImageDescriptor image) {
		ActionProxy action = new ActionProxy(id, text, delegate);
		if (image != null) {
			action.setImageDescriptor(image);
		}
		return action;
	}

	class ActionProxy extends Action {
		private IActionDelegate action;

		public ActionProxy(String id, String text, IActionDelegate action) {
			super(text);
			this.action = action;
			setId(id);
		}

		public ActionProxy(String id, String text, IActionDelegate action, int style) {
			super(text, style);
			this.action = action;
			setId(id);
		}

		@Override
		public void run() {
			action.selectionChanged(this, selection);
			action.run(this);
		}
	}

}
