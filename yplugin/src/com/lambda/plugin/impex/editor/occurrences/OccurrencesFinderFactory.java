package com.lambda.plugin.impex.editor.occurrences;

import java.util.Collections;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Position;

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

    OccurrencesFinder createOccurrencesFinder() {
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

        return new OccurrencesFinder() {

            @Override
            public List<Position> findOccurrences() {
                return Collections.emptyList();
            }
        };
    }
}
