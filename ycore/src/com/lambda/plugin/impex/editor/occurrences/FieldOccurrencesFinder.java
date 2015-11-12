package com.lambda.plugin.impex.editor.occurrences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.jface.text.Position;

import com.lambda.impex.ast.ImpexParser.AttributeContext;
import com.lambda.impex.ast.ImpexParser.BlockContext;
import com.lambda.impex.ast.ImpexParser.FieldContext;
import com.lambda.impex.ast.ImpexParser.ImpexContext;
import com.lambda.impex.ast.ImpexParser.RecordContext;

public class FieldOccurrencesFinder extends AbstractOccurrencesFinderAdapter {

	private static final String FIELD_OCCURRENCES_ANNOTATION = "com.lambda.plugin.impex.fieldOccurrences";
	private static final int NOT_STARTED = 0;
	private static final int PROCESSING = 1;
	private static final int FINISHED = 2;
	private int status = NOT_STARTED;
	private int pos;
	protected int index;
	protected Map<Integer, List<Position>> columns;

	public FieldOccurrencesFinder(int offset) {
		super(offset);
	}

	@Override
	public String getAnnotationId() {
		return FIELD_OCCURRENCES_ANNOTATION;
	}

	@Override
	public String getWriteAnnotationId() {
		return FIELD_OCCURRENCES_ANNOTATION;
	}

	@Override
	protected List<Position> getOccurrences() {
		if (columns == null) {
			return Collections.<Position> emptyList();
		}
		List<Position> list = columns.get(index);
		return list == null ? Collections.<Position> emptyList() : list;
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
		if (status != PROCESSING) {
			return;
		}
		pos++;
		handleAttribute(ctx);
		if (status == PROCESSING && offset >= startIndex(ctx) && offset < stopIndex(ctx)) {
			index = pos;
		}
	}

	protected void handleAttribute(AttributeContext ctx) {
		List<Position> column = new ArrayList<>();
		column.add(position(ctx));
		columns.put(pos, column);
	}

	@Override
	public void enterRecord(RecordContext ctx) {
		if (status != PROCESSING) {
			return;
		}
		pos = -1;
	}

	@Override
	public void enterField(FieldContext ctx) {
		if (status != PROCESSING) {
			return;
		}
		pos++;
		handleField(ctx);
		if (status == PROCESSING && offset >= startIndex(ctx) && offset < stopIndex(ctx)) {
			index = pos;
		}
	}

	protected void handleField(ParserRuleContext ctx) {
		List<Position> column = columns.get(pos);
		if (column == null) {
			column = new ArrayList<>();
			columns.put(pos, column);
		}
		column.add(position(ctx));
	}

	protected int getPosition() {
		return pos;
	}
}