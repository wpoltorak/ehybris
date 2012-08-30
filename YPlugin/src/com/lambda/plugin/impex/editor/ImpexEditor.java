package com.lambda.plugin.impex.editor;

import org.eclipse.ui.editors.text.TextEditor;

import com.lambda.plugin.YPlugin;
import com.lambda.plugin.preferences.PreferenceConstants;

public class ImpexEditor extends TextEditor {

    private final ColorManager colorManager;
    private final boolean fMarkingOccurrences;

    public ImpexEditor() {
        colorManager = new ColorManager();
        setSourceViewerConfiguration(new ImpexConfiguration(colorManager));
        setDocumentProvider(new ImpexDocumentProvider());
        setPreferenceStore(YPlugin.getDefault().getPreferenceStore());
        fMarkingOccurrences = getPreferenceStore().getBoolean(PreferenceConstants.IMPEX_EDITOR_MARK_OCCURRENCES);
    }

    @Override
    public void dispose() {
        colorManager.dispose();
        super.dispose();
    }

    public boolean isMarkingOccurrences() {
        return fMarkingOccurrences;
    }

}
