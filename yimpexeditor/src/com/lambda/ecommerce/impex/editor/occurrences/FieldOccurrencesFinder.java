package com.lambda.ecommerce.impex.editor.occurrences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.jface.text.Position;

import com.lambda.impex.ast.ImpexLexer;
import com.lambda.impex.ast.ImpexParser.BlockContext;
import com.lambda.impex.ast.ImpexParser.HeaderContext;
import com.lambda.impex.ast.ImpexParser.ImpexContext;
import com.lambda.impex.ast.ImpexParser.RecordContext;

public class FieldOccurrencesFinder extends AbstractOccurrencesFinderAdapter {

	private static final String FIELD_OCCURRENCES_ANNOTATION = "com.lambda.ecommerce.impex.fieldOccurrences";
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
		
		handleSeparators(ctx, ctx.Separator());
	}

	@Override
	public void enterRecord(RecordContext ctx) {
		if (status != PROCESSING) {
			return;
		}

		handleSeparators(ctx, ctx.Separator());
	}

	private void handleSeparators(ParserRuleContext ctx, List<TerminalNode> separators) {
		for (int i = 0; i < separators.size(); i++) {
			Token start = separators.get(i).getSymbol();
			Token stop = (i+1 >= separators.size()) ? ctx.getStop() : separators.get(i + 1).getSymbol();
			int startIndex = startIndex(start);
			int stopIndex = stopIndex(stop);
			List<Position> positions = columns.get(i);
			if (positions == null) {
				positions = new ArrayList<Position>();
				columns.put(i, positions);
			} 
			positions.add(new Position(startIndex, stopIndex - startIndex + 1));
			if (offset > startIndex && offset <= stopIndex) {
				index = i;
			}
		}
	}

	private int startIndex(Token token) {
		return token.getStopIndex();
	}
	
	private int stopIndex(Token token) {
		switch(token.getType()){
		case ImpexLexer.Separator:
		case ImpexLexer.Lb:
			return token.getStartIndex();
			
		}
		//if last line then EOF - last token in this case is an attribute - need stop index
		return token.getStopIndex();
	}

}