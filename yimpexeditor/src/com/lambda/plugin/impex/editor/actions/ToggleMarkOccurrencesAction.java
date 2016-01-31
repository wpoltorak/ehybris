package com.lambda.plugin.impex.editor.actions;

import java.util.ResourceBundle;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.ui.texteditor.TextEditorAction;

import com.lambda.plugin.impex.YImpex;
import com.lambda.plugin.impex.editor.ImpexEditor;
import com.lambda.plugin.impex.preferences.PreferenceConstants;

public class ToggleMarkOccurrencesAction extends TextEditorAction implements IPropertyChangeListener {

    private IPreferenceStore fStore;

    /**
     * Constructs and updates the action.
     */
    public ToggleMarkOccurrencesAction(final ResourceBundle bundle, final String prefix, final ITextEditor editor,
            final int style) {
        super(bundle, prefix, editor, style);
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
        final ITextEditor editor = getTextEditor();

        boolean checked = false;
        boolean enabled = false;
        if (editor instanceof ImpexEditor) {
            checked = ((ImpexEditor) editor).isMarkingOccurrences();
            enabled = ((ImpexEditor) editor).getImpexModel() != null;
        }

        setChecked(checked);
        setEnabled(enabled);
    }

    /*
     * @see TextEditorAction#setEditor(ITextEditor)
     */
    @Override
    public void setEditor(final ITextEditor editor) {

        super.setEditor(editor);

        if (editor != null) {

            if (fStore == null) {
                fStore = YImpex.getDefault().getPreferenceStore();
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
    @Override
    public void propertyChange(final PropertyChangeEvent event) {
        if (event.getProperty().equals(PreferenceConstants.IMPEX_EDITOR_MARK_OCCURRENCES)) {
            setChecked(Boolean.valueOf(event.getNewValue().toString()).booleanValue());
        }
    }
}