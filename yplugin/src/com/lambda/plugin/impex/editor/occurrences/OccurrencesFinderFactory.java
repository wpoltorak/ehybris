package com.lambda.plugin.impex.editor.occurrences;

import org.eclipse.jface.text.BadLocationException;

import com.lambda.impex.ast.ImpexLexer;
import com.lambda.plugin.YPlugin;
import com.lambda.plugin.impex.editor.ImpexDocument;
import com.lambda.plugin.impex.model.ILexerTokenRegion;

public class OccurrencesFinderFactory {
    private final ImpexDocument document;
    private final int offset;

    public OccurrencesFinderFactory(ImpexDocument document, int offset) {
        this.document = document;
        this.offset = offset;
    }

    AbstractOccurrencesFinderAdapter createOccurrencesFinder() {
        try {
            ILexerTokenRegion token = document.getToken(offset);
            switch (token.getTokenType()) {
            case ImpexLexer.Type:
                return new TypeOccurrencesFinder(document, token.getOffset());
            case ImpexLexer.Macrodef:
            case ImpexLexer.Macroref:
                return new MacroOccurrencesFinder(document, token.getOffset());
            case ImpexLexer.DocumentIdField:
            case ImpexLexer.DocumentIdRefField:
                return new DocumentIdQualifierOccurrencesFinder(document, token.getOffset());
            }
        } catch (BadLocationException e) {
            YPlugin.logError(e);
        }

        return null;
    }
}
