package com.lambda.plugin.impex.editor.occurrences;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.Token;

import com.lambda.impex.ast.ImpexParser.HeaderTypeNameContext;
import com.lambda.plugin.impex.editor.ImpexDocument;

public class TypeOccurrencesFinder extends AbstractOccurrencesFinderAdapter implements OccurrencesFinder {

    public TypeOccurrencesFinder(ImpexDocument document, int offset) {
        super(document, offset);
    }

    private final Map<String, List<Token>> name2Tokens = new HashMap<>();
    private final Map<Integer, String> offset2Name = new HashMap<>();

    @Override
    public void enterHeaderTypeName(HeaderTypeNameContext ctx) {
        if (ctx.Type() != null) {
            Token token = ctx.Type().getSymbol();
            String name = token.getText().toLowerCase();
            offset2Name.put(token.getStartIndex(), name);
            addListValue(name2Tokens, name, token);
        }
    }

    @Override
    public List<Token> getOccurrences(int offset) {
        final String name = offset2Name.get(offset);
        final List<Token> result = name2Tokens.get(name);
        if (result != null) {
            return result;
        }
        return Collections.emptyList();
    }
}
