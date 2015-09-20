package com.lambda.plugin.impex.editor.occurrences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.jface.text.Position;

import com.lambda.impex.ast.ImpexParser.AttributeContext;
import com.lambda.impex.ast.ImpexParser.BlockContext;
import com.lambda.impex.ast.ImpexParser.DocumentIdFieldContext;
import com.lambda.impex.ast.ImpexParser.DocumentIdRefFieldContext;
import com.lambda.impex.ast.ImpexParser.FieldContext;
import com.lambda.impex.ast.ImpexParser.ImpexContext;
import com.lambda.impex.ast.ImpexParser.RecordContext;

public class FieldOccurrencesFinder extends AbstractOccurrencesFinderAdapter {

    private static final int NOT_STARTED = 0;
    private static final int PROCESSING = 1;
    private static final int FINISHED = 2;
    private int status = NOT_STARTED;
    private int pos;
    private int index;
    private Map<Integer, List<Position>> columns;

    public FieldOccurrencesFinder(int offset) {
        super(offset);
    }

    @Override
    protected List<Position> getOccurrences() {
        return columns.get(index);
    }

    @Override
    public void enterImpex(ImpexContext ctx) {
        status = NOT_STARTED;
    }

    @Override
    public void enterBlock(BlockContext ctx) {
        if (status == NOT_STARTED && offset >= startIndex(ctx) && offset < stopIndex(ctx)) {
            status = PROCESSING;
            pos = -1;
            index = -1;
            columns = new HashMap<>();
        }
    }

    @Override
    public void exitBlock(BlockContext ctx) {
        if (status == PROCESSING) {
            status = FINISHED;
        }
    }

    @Override
    public void enterAttribute(AttributeContext ctx) {
        pos++;
        List<Position> column = new ArrayList<>();
        column.add(position(ctx));
        columns.put(pos, column);
        if (status == PROCESSING && offset >= startIndex(ctx) && offset < stopIndex(ctx)) {
            index = pos;
        }
    }

    @Override
    public void enterRecord(RecordContext ctx) {
        pos = -1;
    }

    @Override
    public void enterDocumentIdField(DocumentIdFieldContext ctx) {
        handleField(ctx);
    }

    @Override
    public void enterDocumentIdRefField(DocumentIdRefFieldContext ctx) {
        handleField(ctx);
    }

    @Override
    public void enterField(FieldContext ctx) {
        handleField(ctx);
    }

    private void handleField(ParserRuleContext ctx) {
        pos++;

        List<Position> column = columns.get(pos);
        if (column == null) {
            column = new ArrayList<>();
            columns.put(pos, column);
        }
        column.add(position(ctx));

        if (status == PROCESSING && offset >= startIndex(ctx) && offset < stopIndex(ctx)) {
            index = pos;
        }
    }
}