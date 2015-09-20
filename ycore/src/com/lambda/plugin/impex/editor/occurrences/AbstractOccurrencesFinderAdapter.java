package com.lambda.plugin.impex.editor.occurrences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.eclipse.jface.text.Position;

import com.lambda.impex.ast.ImpexParserBaseListener;

/**
 * Finds occurrences
 */
abstract class AbstractOccurrencesFinderAdapter extends ImpexParserBaseListener implements OccurrencesFinder {
    protected final int offset;

    public AbstractOccurrencesFinderAdapter(int offset) {
        this.offset = offset;
    }

    protected abstract List<Position> getOccurrences();

    @Override
    public List<Position> findOccurrences(ParseTree parseTree) {
        final ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(this, parseTree);
        return getOccurrences();
    }

    protected Position position(Token token) {
        int startIndex = token.getStartIndex();
        int stopIndex = token.getStopIndex();
        return new Position(startIndex, stopIndex - startIndex + 1);
    }

    protected Position position(ParserRuleContext ctx) {
        int startIndex = startIndex(ctx);
        int stopIndex = stopIndex(ctx);
        return new Position(startIndex, stopIndex - startIndex + 1);
    }

    protected int stopIndex(final ParserRuleContext ctx) {
        return ctx.getStop() != null ? ctx.getStop().getStopIndex() : ctx.getStart().getStopIndex();
    }

    protected int startIndex(final ParserRuleContext ctx) {
        return ctx.getStart().getStartIndex();
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
