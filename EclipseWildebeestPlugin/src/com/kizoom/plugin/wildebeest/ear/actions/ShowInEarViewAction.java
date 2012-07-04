package com.kizoom.plugin.wildebeest.ear.actions;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.ui.actions.SelectionDispatchAction;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchSite;

import com.kizoom.plugin.wildebeest.ear.IEar;

public class ShowInEarViewAction extends SelectionDispatchAction {

	// private JavaEditor fEditor;

	public ShowInEarViewAction(IWorkbenchSite site) {
		super(site);
		setText(ActionMessages.ShowInEarViewAction_label);
		setDescription(ActionMessages.ShowInEarViewAction_description);
		setToolTipText(ActionMessages.ShowInEarViewAction_tooltip);
		
		// PlatformUI.getWorkbench().getHelpSystem().setHelp(this,
		// IJavaHelpContextIds.SHOW_IN_PACKAGEVIEW_ACTION);
	}

	// public ShowInEarViewAction(JavaEditor editor) {
	// this(editor.getEditorSite());
	// fEditor = editor;
	// setEnabled(SelectionConverter.canOperateOn(fEditor));
	// }

	/*
	 * (non-Javadoc) Method declared on SelectionDispatchAction.
	 */
	@Override
	public void selectionChanged(ITextSelection selection) {
	}

	/*
	 * (non-Javadoc) Method declared on SelectionDispatchAction.
	 */
	@Override
	public void selectionChanged(IStructuredSelection selection) {
		setEnabled(checkEnabled(selection));
	}

	private boolean checkEnabled(IStructuredSelection selection) {
		if (selection.size() != 1)
			return false;
		return selection.getFirstElement() instanceof IJavaElement;
	}

	/**
	 * Tries to reveal the given Java element
	 * 
	 * @param element
	 *          the element to reveal
	 */
	public void run(IEar ear) {
		if (ear == null)
			return;

		//EarNavigator view = EarNavigator.openInActivePerspective();
		 //view.tryToReveal(ear);
	}

	private static String getDialogTitle() {
		return ActionMessages.ShowInEarViewAction_dialog_title;
	}
}
