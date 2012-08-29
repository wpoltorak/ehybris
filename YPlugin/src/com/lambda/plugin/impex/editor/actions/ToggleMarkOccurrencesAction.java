package com.lambda.plugin.impex.editor.actions;

import org.eclipse.ant.internal.ui.editor.AntEditor;
import org.eclipse.ant.internal.ui.editor.actions.AntEditorActionMessages;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.TextEditorAction;

import com.lambda.plugin.YImages;
import com.lambda.plugin.YMessages;
import com.lambda.plugin.YPlugin;
import com.lambda.plugin.impex.editor.ImpexEditor;
import com.lambda.plugin.preferences.PreferenceConstants;

public class ToggleMarkOccurrencesAction extends TextEditorAction implements IPropertyChangeListener {

    private IPreferenceStore fStore;

    public ToggleMarkOccurrencesAction() {
        super(YMessages.getBundle(), "ToggleMarkOccurrencesAction.", null, IAction.AS_CHECK_BOX); //$NON-NLS-1$
        setImageDescriptor(YImages.DESC_MARK_OCCURRENCES);
        setToolTipText(AntEditorActionMessages.getString("ToggleMarkOccurrencesAction.tooltip")); //$NON-NLS-1$
        update();
    }

    /*
     * @see IAction#actionPerformed
     */
    @Override
    public void run() {
        fStore.setValue(PreferenceConstants.IMPEX_EDITOR_MARK_OCCURRENCES, isChecked());
    }

    /*
     * @see TextEditorAction#update
     */
    @Override
    public void update() {
        ITextEditor editor = getTextEditor();

        boolean checked = false;
        boolean enabled = false;
        if (editor instanceof ImpexEditor) {
            checked = ((ImpexEditor) editor).isMarkingOccurrences();
            enabled = ((AntEditor) editor).getAntModel() != null;
        }

        setChecked(checked);
        setEnabled(enabled);
    }

    /*
     * @see TextEditorAction#setEditor(ITextEditor)
     */
    @Override
    public void setEditor(ITextEditor editor) {

        super.setEditor(editor);

        if (editor != null) {

            if (fStore == null) {
                fStore = YPlugin.getDefault().getPreferenceStore();
                fStore.addPropertyChangeListener(this);
            }

        } else if (fStore != null) {
            fStore.removePropertyChangeListener(this);
            fStore = null;
        }
        update();
    }

    /*
     * @see IPropertyChangeListener#propertyChange(PropertyChangeEvent)
     */
    public void propertyChange(PropertyChangeEvent event) {
        if (event.getProperty().equals(PreferenceConstants.IMPEX_EDITOR_MARK_OCCURRENCES))
            setChecked(Boolean.valueOf(event.getNewValue().toString()).booleanValue());
    }
}