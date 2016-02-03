package com.lambda.ecommerce.impex.editor.occurrences;

import org.eclipse.jface.text.BadLocationException;

import com.lambda.ecommerce.impex.YImpex;
import com.lambda.ecommerce.impex.editor.ImpexDocument;
import com.lambda.ecommerce.impex.model.ILexerTokenRegion;
import com.lambda.impex.ast.ImpexLexer;

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
            switch (token.getType()) {
            case ImpexLexer.Type:
                return new TypeOccurrencesFinder(token.getOffset());
            case ImpexLexer.Macrodef:
            case ImpexLexer.Macroref:
                return new MacroOccurrencesFinder(token.getOffset());
            case ImpexLexer.DocumentIdField:
            case ImpexLexer.DocumentIdRefField:
                return new DocumentIdQualifierOccurrencesFinder(token.getOffset());
            }
        } catch (BadLocationException e) {
            YImpex.logError(e);
        }

        return null;
    }
}
