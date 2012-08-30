package com.lambda.plugin.impex.editor.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

import com.lambda.plugin.YPlugin;
import com.lambda.plugin.preferences.PreferenceConstants;

public class ToggleMarkOccurrencesAction extends AbstractHandler implements IEditorActionDelegate {

    private IPreferenceStore fStore;

    public void run(final IAction action) {
        throw new UnsupportedOperationException("toggle run(action)");
    }

    public void selectionChanged(final IAction action, final ISelection selection) {
        throw new UnsupportedOperationException("toggle selection changed(action, selection)");

    }

    public Object execute(final ExecutionEvent event) throws ExecutionException {
        final Command command = event.getCommand();
        final boolean oldValue = HandlerUtil.toggleCommandState(command);
        fStore.setValue(PreferenceConstants.IMPEX_EDITOR_MARK_OCCURRENCES, !oldValue);
        return null;
    }

    public void setActiveEditor(final IAction action, final IEditorPart editor) {
        if (editor != null) {

            if (fStore == null) {
                fStore = YPlugin.getDefault().getPreferenceStore();
                //                fStore.addPropertyChangeListener();
            }

        } else if (fStore != null) {
            //            fStore.removePropertyChangeListener(this);
            fStore = null;
        }
    }
}