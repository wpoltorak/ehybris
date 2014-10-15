package com.lambda.plugin.impex.editor.occurrences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.Token;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.Position;

import com.lambda.plugin.YPlugin;
import com.lambda.plugin.impex.editor.ImpexDocument;
import com.lambda.plugin.impex.model.IImpexModel;
import com.lambda.plugin.impex.model.ILexerTokenRegion;

/**
 * Finds occurrences
 */
class OccurrencesFinder {
    private final ImpexDocument document;
    private final int offset;

    public OccurrencesFinder(IImpexModel model, ImpexDocument document, int offset) {
        this.document = document;
        this.offset = offset;
    }

    public List<Position> perform() {
        try {
            ILexerTokenRegion token = document.getToken(offset);
            List<Token> tokens = document.getModel().getOccurrenceTokens(token.getTokenType(), token.getOffset());
            List<Position> positions = new ArrayList<>(tokens.size());
            for (Token occurrence : tokens) {
                positions.add(new Position(occurrence.getStartIndex(), occurrence.getStopIndex()
                        - occurrence.getStartIndex() + 1));
            }
            return positions;
        } catch (BadLocationException e) {
            YPlugin.logError(e);
        }
        return Collections.emptyList();
    }
}
