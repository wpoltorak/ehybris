package com.lambda.plugin.impex.editor.syntaxcoloring;

import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;

import com.lambda.plugin.impex.preferences.PreferenceConstants;

public class SyntaxColoringPropertyChangeListener implements IPropertyChangeListener {

    private ISourceViewer sourceViewer;

    public SyntaxColoringPropertyChangeListener() {
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        // TODO introduce lock mechanism to prevent from multiple property notifications
        if (event.getProperty().startsWith(PreferenceConstants.IMPEX_SYNTAX_COLORING_PREFIX) && sourceViewer != null) {
            sourceViewer.invalidateTextPresentation();
        }
    }

    public void setSourceViewer(ISourceViewer sourceViewer) {
        this.sourceViewer = sourceViewer;
    }
}
