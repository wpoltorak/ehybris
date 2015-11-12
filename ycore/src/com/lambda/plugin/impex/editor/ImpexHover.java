package com.lambda.plugin.impex.editor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextHover;
import org.eclipse.jface.text.ITextHoverExtension;
import org.eclipse.jface.text.ITextHoverExtension2;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Region;

import com.lambda.impex.ast.ImpexLexer;
import com.lambda.impex.ast.ImpexParser.AttributeContext;
import com.lambda.impex.ast.ImpexParser.BlockContext;
import com.lambda.impex.ast.ImpexParser.FieldContext;
import com.lambda.impex.ast.ImpexParser.HeaderContext;
import com.lambda.impex.ast.ImpexParser.ImpexContext;
import com.lambda.impex.ast.ImpexParser.RecordContext;
import com.lambda.impex.ast.ImpexParserBaseListener;
import com.lambda.plugin.YCore;
import com.lambda.plugin.impex.model.ILexerTokenRegion;
import com.lambda.plugin.utils.StringUtils;

public class ImpexHover implements ITextHover, ITextHoverExtension, ITextHoverExtension2 {

	@Override
	public Object getHoverInfo2(ITextViewer textViewer, IRegion hoverRegion) {
		if (hoverRegion instanceof ILexerTokenRegion) {
			ILexerTokenRegion region = (ILexerTokenRegion) hoverRegion;

			switch (region.getTokenType()) {
			case ImpexLexer.Field:
			case ImpexLexer.SkippedField:
			case ImpexLexer.DocumentIdField:
			case ImpexLexer.DocumentIdRefField:
				ImpexDocument document = (ImpexDocument) textViewer.getDocument();
				ParseTree parseTree = document.getParseTree();
				if (parseTree != null) {
					final ParseTreeWalker walker = new ParseTreeWalker();
					AttributeFinder finder = new AttributeFinder(region.getOffset());
					walker.walk(finder, parseTree);
					IRegion textRegion = finder.getTextRegion();
					try {
						if (textRegion == null) {
							break;
						}
						String tooltip = document.get(textRegion.getOffset(), textRegion.getLength());
						return trimSeparator(tooltip);
					} catch (BadLocationException e) {
						YCore.logError(e);
					}
				}
				break;
			default:
				break;
			}
		}
		return null;
	}

	private String trimSeparator(String tooltip) {
		if (tooltip == null) {
			return null;
		}
		tooltip = tooltip.trim();
		
		if (StringUtils.isEmpty(tooltip)){
			return "<empty attribute>";
		}
		
		if (tooltip.charAt(tooltip.length() - 1) == ';'){
			tooltip = tooltip.substring(0, tooltip.length() - 1).trim();
		}
		return tooltip;
	}

	@Override
	public IInformationControlCreator getHoverControlCreator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHoverInfo(ITextViewer textViewer, IRegion hoverRegion) {
		return null;
	}

	@Override
	public IRegion getHoverRegion(ITextViewer textViewer, int offset) {
		ImpexDocument document = (ImpexDocument) textViewer.getDocument();
		try {
			return document.getToken(offset);
		} catch (BadLocationException e) {
			YCore.logError(e);
		}
		return null;
	}

	private class AttributeFinder extends ImpexParserBaseListener {

		private static final int NOT_STARTED = 0;
		private static final int PROCESSING = 1;
		private static final int FINISHED = 2;
		private int status = NOT_STARTED;
		private int pos;
		protected int index;
		protected Map<Integer, Region> columns;
		private int offset;

		public AttributeFinder(int offset) {
			this.offset = offset;
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
		public void exitHeader(HeaderContext ctx) {
			if (status != PROCESSING) {
				return;
			}

			List<TerminalNode> separators = ctx.Separator();
			if (separators.isEmpty()) {
				return;
			}
			for (int i = 1; i < separators.size(); i++) {
				TerminalNode node = separators.get(i);
				IRegion region = columns.get(i - 1);
				if (region != null) {
					columns.put(i - 1,
							new Region(region.getOffset(), node.getSymbol().getStartIndex() - region.getOffset() + 1));
				}
			}
			for (TerminalNode separator : separators) {

			}
		}

		@Override
		public void enterAttribute(AttributeContext ctx) {
			if (status != PROCESSING) {
				return;
			}
			pos++;
			int start = startIndex(ctx);
			int stop = stopIndex(ctx);
			columns.put(pos, new Region(start, stop - start + 2));
			checkIndex(ctx);
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
			checkIndex(ctx);
		}

		private void checkIndex(ParserRuleContext ctx) {
			if (status == PROCESSING && offset >= startIndex(ctx) && offset < stopIndex(ctx)) {
				index = pos;
			}
		}

		public IRegion getTextRegion() {
			return columns.get(index);
		}
	}

	protected int stopIndex(final ParserRuleContext ctx) {
		return ctx.getStop() != null ? ctx.getStop().getStopIndex() : ctx.getStart().getStopIndex();
	}

	protected int startIndex(final ParserRuleContext ctx) {
		return ctx.getStart().getStartIndex();
	}
}
