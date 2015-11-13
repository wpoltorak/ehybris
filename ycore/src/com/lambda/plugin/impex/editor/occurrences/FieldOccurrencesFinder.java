package com.lambda.plugin.impex.editor.occurrences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.jface.text.Position;

import com.lambda.impex.ast.ImpexParser.BlockContext;
import com.lambda.impex.ast.ImpexParser.HeaderContext;
import com.lambda.impex.ast.ImpexParser.ImpexContext;
import com.lambda.impex.ast.ImpexParser.RecordContext;

public class FieldOccurrencesFinder extends AbstractOccurrencesFinderAdapter {

	private static final String FIELD_OCCURRENCES_ANNOTATION = "com.lambda.plugin.impex.fieldOccurrences";
	private static final int NOT_STARTED = 0;
	private static final int PROCESSING = 1;
	private static final int FINISHED = 2;
	private int status = NOT_STARTED;
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
	public void enterHeader(HeaderContext ctx) {
		if (status != PROCESSING) {
			return;
		}

		List<TerminalNode> separators = ctx.Separator();
		if (separators.isEmpty()) {
			return;
		}

		for (int i = 1; i < separators.size(); i++) {
			Token stop = separators.get(i).getSymbol();
			Token start = separators.get(i - 1).getSymbol();
			ArrayList<Position> positions = new ArrayList<Position>();
			positions.add(new Position(start.getStopIndex(), stop.getStartIndex() - start.getStopIndex() + 1));
			columns.put(i - 1, positions);
			if (offset >= start.getStopIndex() && offset < stop.getStartIndex()) {
				index = i - 1;
			}
		}
	}

	@Override
	public void enterRecord(RecordContext ctx) {
		if (status != PROCESSING) {
			return;
		}
		List<TerminalNode> separators = ctx.Separator();
		for (int i = 1; i < separators.size(); i++) {
			Token stop = separators.get(i).getSymbol();
			Token start = separators.get(i - 1).getSymbol();
			List<Position> positions = columns.get(i-1); 
			if (positions != null) {
				positions.add(new Position(start.getStopIndex(), stop.getStartIndex() - start.getStopIndex() + 1));
			}
			if (offset >= start.getStopIndex() && offset < stop.getStartIndex()) {
				index = i - 1;
			}
		}
	}
}