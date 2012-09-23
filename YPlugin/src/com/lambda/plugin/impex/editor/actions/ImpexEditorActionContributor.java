package com.lambda.plugin.impex.editor.actions;

import java.util.ResourceBundle;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.editors.text.TextEditorActionContributor;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.ITextEditorActionConstants;
import org.eclipse.ui.texteditor.RetargetTextEditorAction;

import com.lambda.plugin.YImages;
import com.lambda.plugin.YMessages;
import com.lambda.plugin.impex.editor.ImpexEditor;

/**
 * Contributes Impex Editor actions to the Edit menu and the toolbar.
 */
public class ImpexEditorActionContributor extends TextEditorActionContributor {

    private final static String TOGGLE_MARK_OCCURRENCES_ID = "com.lambda.plugin.impex.editor.actions.toggleMarkOccurrences"; //$NON-NLS-1$
    //    protected RetargetTextEditorAction fContentAssistProposal;
    //    protected RetargetTextEditorAction fContentFormat;
    private final ToggleMarkOccurrencesAction toggleMarkOccurrencesAction;
    private final RetargetTextEditorAction showWhitespaceCharactersAction;

    //    private final ToggleAutoReconcileAction fToggleAutoReconcileAction;

    public ImpexEditorActionContributor() {
        final ResourceBundle bundle = YMessages.getImpexEditorActionsBundle();
        toggleMarkOccurrencesAction = new ToggleMarkOccurrencesAction(YMessages.getImpexEditorActionsBundle(),
                "ToggleMarkOccurrencesAction.", null, IAction.AS_CHECK_BOX); //$NON-NLS-1$
        YImages.setLocalImageDescriptors(toggleMarkOccurrencesAction, "mark_occurrences.gif");

        showWhitespaceCharactersAction = new RetargetTextEditorAction(bundle, null, "ShowWhitespaceCharactersAction.", IAction.AS_CHECK_BOX);
        showWhitespaceCharactersAction.setChecked(EditorsUI.getPreferenceStore().getBoolean(
                AbstractTextEditor.PREFERENCE_SHOW_WHITESPACE_CHARACTERS));
        YImages.setLocalImageDescriptors(showWhitespaceCharactersAction, "show_whitespace_chars.gif");

        //        showWhitespaceCharactersAction.setActionDefinitionId(ITextEditorActionDefinitionIds.SHOW_WHITESPACE_CHARACTERS);
        //        fContentAssistProposal = new RetargetTextEditorAction(bundle, "ContentAssistProposal."); //$NON-NLS-1$
        //        fContentAssistProposal.setActionDefinitionId(ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS);
        //        fContentFormat = new RetargetTextEditorAction(bundle, "ContentFormat."); //$NON-NLS-1$
        //        fContentFormat.setActionDefinitionId(IJavaEditorActionDefinitionIds.FORMAT);

        //        fToggleAutoReconcileAction = new ToggleAutoReconcileAction();

    }

    private void doSetActiveEditor(final IEditorPart part) {
        super.setActiveEditor(part);

        ITextEditor editor = null;
        if (part instanceof ITextEditor) {
            editor = (ITextEditor) part;
        }

        //        fContentAssistProposal.setAction(getAction(editor, ITextEditorActionConstants.CONTENT_ASSIST));
        //        fContentFormat.setAction(getAction(editor, "ContentFormat")); //$NON-NLS-1$

        if (editor instanceof ImpexEditor) {
            final ImpexEditor impexEditor = (ImpexEditor) part;
            contributeToMenu(getActionBars().getMenuManager());

            //            final FoldingActionGroup foldingActions = impexEditor.getFoldingActionGroup();
            //            if (foldingActions != null) {
            //                foldingActions.updateActionBars();
            //            }
        }

        toggleMarkOccurrencesAction.setEditor(editor);
        showWhitespaceCharactersAction.setAction(getAction(editor, ITextEditorActionConstants.SHOW_WHITESPACE_CHARACTERS));

        //        toggleMarkOccurrencesAction.setEnabled(editor != null && editor.isEditable());
        //        if (fToggleAutoReconcileAction != null) {
        //            fToggleAutoReconcileAction.setEditor(editor);
        //        }
    }

    //    private void updateActionsEnablement(final ITextEditor editor, final IAction... actions) {
    //        final boolean enabled = editor != null && editor.isEditable();
    //        for (final IAction action : actions) {
    //            action.setEnabled(enabled);
    //        }
    //    }

    @Override
    public void contributeToToolBar(final IToolBarManager toolBarManager) {
        super.contributeToToolBar(toolBarManager);
        toolBarManager.add(toggleMarkOccurrencesAction);
        toolBarManager.add(showWhitespaceCharactersAction);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.part.EditorActionBarContributor#contributeToMenu(org.eclipse.jface.action.IMenuManager)
     */
    @Override
    public void contributeToMenu(final IMenuManager menu) {
        super.contributeToMenu(menu);

        //        final IMenuManager navigateMenu = menu.findMenuUsingPath(IWorkbenchActionConstants.M_NAVIGATE);
        //        if (navigateMenu != null) {
        //            navigateMenu.appendToGroup(IWorkbenchActionConstants.OPEN_EXT, fOpenDeclarationAction);
        //            navigateMenu.appendToGroup(IWorkbenchActionConstants.OPEN_EXT, fOpenExternalDocAction);
        //            navigateMenu.setVisible(true);
        //        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.part.EditorActionBarContributor#init(org.eclipse.ui.IActionBars)
     */
    @Override
    public void init(final IActionBars bars) {
        super.init(bars);

        final IMenuManager menuManager = bars.getMenuManager();
        final IMenuManager editMenu = menuManager.findMenuUsingPath(IWorkbenchActionConstants.M_EDIT);
        if (editMenu != null) {
            editMenu.add(new Separator());
            //            editMenu.add(fContentAssistProposal);
            //            editMenu.add(fContentFormat);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IEditorActionBarContributor#setActiveEditor(org.eclipse.ui.IEditorPart)
     */
    @Override
    public void setActiveEditor(final IEditorPart part) {
        doSetActiveEditor(part);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IEditorActionBarContributor#dispose()
     */
    @Override
    public void dispose() {
        doSetActiveEditor(null);
        super.dispose();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IEditorActionBarContributor#init(org.eclipse.ui.IActionBars, org.eclipse.ui.IWorkbenchPage)
     */
    @Override
    public void init(final IActionBars bars, final IWorkbenchPage page) {
        super.init(bars, page);
        bars.setGlobalActionHandler(TOGGLE_MARK_OCCURRENCES_ID, toggleMarkOccurrencesAction);
        //        bars.setGlobalActionHandler("org.eclipse.ant.ui.toggleAutoReconcile", fToggleAutoReconcileAction); //$NON-NLS-1$
    }
}
