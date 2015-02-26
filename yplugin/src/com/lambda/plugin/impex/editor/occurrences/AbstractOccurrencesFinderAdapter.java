package com.lambda.plugin.impex.editor.occurrences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.eclipse.jface.text.Position;

import com.lambda.impex.ast.ImpexParserBaseListener;

/**
 * Finds occurrences
 */
abstract class AbstractOccurrencesFinderAdapter extends ImpexParserBaseListener implements OccurrencesFinder {
    private final int offset;

    public AbstractOccurrencesFinderAdapter(int offset) {
        this.offset = offset;
    }

    protected abstract List<Token> getOccurrences(int offset);

    @Override
    public List<Position> findOccurrences(ParseTree parseTree) {
        final ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(this, parseTree);

        List<Token> tokens = getOccurrences(offset);
        List<Position> positions = new ArrayList<>(tokens.size());
        for (Token occurrence : tokens) {
            positions.add(new Position(occurrence.getStartIndex(), occurrence.getStopIndex()
                    - occurrence.getStartIndex() + 1));
        }
        return positions;
    }

    protected <Key, Value> void addListValue(final Map<Key, List<Value>> map, final Key key, final Value value) {
        List<Value> values = map.get(key);
        if (values == null) {
            values = new ArrayList<>();
            map.put(key, values);
        }
        values.add(value);
    }

    protected <Key, Value> void addListValue(final Map<Key, List<Value>> map, final Key key, final Value value,
            int index) {
        List<Value> values = map.get(key);
        if (values == null) {
            values = new ArrayList<>();
            map.put(key, values);
        }
        values.add(index, value);
    }

}
