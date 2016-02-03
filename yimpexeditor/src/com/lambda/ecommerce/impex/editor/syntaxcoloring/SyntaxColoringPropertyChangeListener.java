package com.lambda.ecommerce.impex.editor.syntaxcoloring;

import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;

import com.lambda.ecommerce.impex.preferences.PreferenceConstants;

public class SyntaxColoringPropertyChangeListener implements IPropertyChangeListener {

    private ISourceViewer sourceViewer;

    public SyntaxColoringPropertyChangeListener() {
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (event.getProperty().equals(PreferenceConstants.IMPEX_SYNTAX_COLORING) && sourceViewer != null) {
            sourceViewer.invalidateTextPresentation();
        }
    }

    public void setSourceViewer(ISourceViewer sourceViewer) {
        this.sourceViewer = sourceViewer;
    }
}
