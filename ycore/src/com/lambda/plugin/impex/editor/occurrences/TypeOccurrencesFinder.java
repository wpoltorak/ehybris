package com.lambda.plugin.impex.editor.occurrences;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.Token;
import org.eclipse.jface.text.Position;

import com.lambda.impex.ast.ImpexParser.HeaderTypeNameContext;

public class TypeOccurrencesFinder extends AbstractOccurrencesFinderAdapter implements OccurrencesFinder {

    public TypeOccurrencesFinder(int offset) {
        super(offset);
    }

    private final Map<String, List<Position>> name2Positions = new HashMap<>();
    private final Map<Integer, String> offset2Name = new HashMap<>();

    @Override
    public void enterHeaderTypeName(HeaderTypeNameContext ctx) {
        if (ctx.Type() != null) {
            Token token = ctx.Type().getSymbol();
            String name = token.getText().toLowerCase();
            offset2Name.put(token.getStartIndex(), name);
            addListValue(name2Positions, name, position(token));
        }
    }

    @Override
    public List<Position> getOccurrences() {
        final String name = offset2Name.get(offset);
        final List<Position> result = name2Positions.get(name);
        if (result != null) {
            return result;
        }
        return Collections.emptyList();
    }
}
