package com.lambda.plugin.impex.editor;

import org.eclipse.ui.editors.text.TextEditor;

public class ImpexEditor extends TextEditor {

    private final ColorManager colorManager;

    public ImpexEditor() {
        super();
        colorManager = new ColorManager();
        setSourceViewerConfiguration(new ImpexConfiguration(colorManager));
        setDocumentProvider(new ImpexDocumentProvider());
    }

    @Override
    public void dispose() {
        colorManager.dispose();
        super.dispose();
    }

    public boolean isMarkingOccurrences() {
        // TODO Auto-generated method stub
        return false;
    }

}
