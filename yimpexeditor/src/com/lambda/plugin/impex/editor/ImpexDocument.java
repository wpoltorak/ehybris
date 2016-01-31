package com.lambda.plugin.impex.editor;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;

import com.lambda.impex.ast.DefaultImpexModel;
import com.lambda.impex.ast.ImpexLexer;
import com.lambda.impex.ast.ImpexModel;
import com.lambda.impex.ast.ImpexParserDefaultErrorListener;
import com.lambda.impex.ast.ImpexProblem;
import com.lambda.plugin.impex.antlr.JavaTypeFinder;
import com.lambda.plugin.impex.antlr.TokenSourceProvider;
import com.lambda.plugin.impex.model.ILexerTokenRegion;
import com.lambda.plugin.impex.model.LexerTokenRegion;

public class ImpexDocument extends DocumentWrapper implements IDocumentListener {

	private static final Object lock = new Object();
	private static JavaTypeFinder typeFinder = new JavaTypeFinder();
	private NavigableMap<Integer, LexerTokenRegion> tokens = new TreeMap<>();
	private NavigableMap<Integer, IRegion> blocks = null;
	private ImpexModel impexModel;
	private final ImpexLexer lexer;
	private ParseTree parseTree;

	public ImpexDocument(IDocument delegate, TokenSourceProvider tokenSource) {
		super(delegate);
		String text = this.get();
		this.lexer = createLexer(tokenSource, text);
		this.blocks = new TreeMap<>();
		createTokens(text, blocks);
		delegate.addPrenotifiedDocumentListener(new IDocumentListener() {

			@Override
			public void documentChanged(DocumentEvent event) {
				ensureCorrectDocument(event);

			}

			@Override
			public void documentAboutToBeChanged(DocumentEvent event) {
				ensureCorrectDocument(event);

			}
		});
		delegate.addDocumentListener(this);
	}

	private void setBlocks(NavigableMap<Integer, IRegion> blocks) {
		// printRegions("Blocks: ", blocks.values());
		this.blocks = blocks;
	}

	private void printRegions(String info, Collection<? extends IRegion> collection) {
		System.out.println(info);
		IRegion last = null;
		for (IRegion elem : collection) {
			if (last != null) {
				if (last.getOffset() + last.getLength() != elem.getOffset()) {
					System.err.println("next: " + (elem.getOffset() + elem.getLength()) + ", " + elem);
				} else {
					System.out.println("next: " + (elem.getOffset() + elem.getLength()) + ", " + elem);
				}
			} else {
				System.out.println("next: " + (elem.getOffset() + elem.getLength()) + ", " + elem);
			}
			last = elem;
		}

	}

	public Iterable<? extends ILexerTokenRegion> getTokens() {
		return tokens.values();
	}

	private IRegion getLineInformationOfOffset(int offset, boolean includeSeparatedLines) throws BadLocationException {
		int lineBeginOffset = 0;
		int lineEndOffset = tokens.lastKey(); // last EOF token has 0 length
		NavigableMap<Integer, LexerTokenRegion> descendingTokens = tokens.subMap(0, true, tokens.floorKey(offset), false).descendingMap();
		for (ILexerTokenRegion region : descendingTokens.values()) {
			if (region.getType() == ImpexLexer.Lb) {
				lineBeginOffset = region.getOffset() + region.getLength();
				break;
			}
		}
		NavigableMap<Integer, LexerTokenRegion> ascendingTokens = tokens.subMap(tokens.floorKey(offset), true, tokens.lastKey(), false);
		for (ILexerTokenRegion region : ascendingTokens.values()) {
			if (region.getType() == ImpexLexer.Lb) {
				lineEndOffset = region.getOffset() + region.getLength();
				break;
			}
		}
		return new Region(lineBeginOffset, lineEndOffset - lineBeginOffset);
	}

	/**
	 * Returns all the line tokens. <br>
	 * Takes into account LineSeparator
	 * 
	 * @param offset
	 * @return
	 * @throws BadLocationException
	 */
	public Iterable<? extends ILexerTokenRegion> getLineTokensOfOffset(int offset, boolean includeSeparatedLines) throws BadLocationException {
		IRegion line = getLineInformationOfOffset(offset, true);
		return tokens.subMap(tokens.floorKey(line.getOffset()), tokens.floorKey(line.getOffset() + line.getLength())).values();
	}

	public Iterable<? extends LexerTokenRegion> getLineTokens(int line, boolean includeSeparatedLines) throws BadLocationException {
		IRegion lineinfo = getLineInformation(line);
		if (includeSeparatedLines) {
			lineinfo = getLineInformationOfOffset(lineinfo.getOffset(), includeSeparatedLines);
		}
		return tokens.subMap(tokens.floorKey(lineinfo.getOffset()), tokens.floorKey(lineinfo.getOffset() + lineinfo.getLength())).values();
	}

	public ILexerTokenRegion getToken(int offset) throws BadLocationException {
		if (0 > offset) {
			throw new BadLocationException();
		}
		return tokens.get(tokens.floorKey(offset));
	}

	public List<ImpexProblem> validate(ImpexModel impexModel) {
		long nanoTime = System.nanoTime();
		try {
			System.err.println("===> VALIDATE BEGIN");
//			char[] source = get().toCharArray();
//			final ImpexLexer lexer = new ImpexLexer(new ANTLRInputStream(source, source.length));
//			synchronized (lock) {
//				new ListTokenSource(new ArrayList<>(tokens.values()));
//
//			}
//			ImpexParser parser = new ImpexParser(new CommonTokenStream(lexer));
//			parseTree = parser.impex();
//
//			final ParseTreeWalker walker = new ParseTreeWalker();
//			ImpexParserDefaultListener listener = new ImpexParserDefaultListener(impexModel);
//			listener.setTypeFinder(typeFinder);
//			walker.walk(listener, parseTree);
//			this.impexModel = impexModel;
//			return impexModel.getProblems();
			 return Collections.EMPTY_LIST;
		} finally {
			System.err.println("===> VALIDATE END: took " + TimeUnit.SECONDS.convert(System.nanoTime() - nanoTime, TimeUnit.NANOSECONDS) + " seconds");
		}
		// return Collections.EMPTY_LIST;
	}

	public ImpexModel getModel() {
		return impexModel;
	}

	public ParseTree getParseTree() {
		return parseTree;
	}

	protected IRegion computeDamageRegion(final DocumentEvent e) {
		synchronized (lock) {
			// empty document -> no dirty region
			// previously empty -> full document dirty
			if (tokens.isEmpty() || e.getDocument().getLength() == 0) {
				setBlocks(new TreeMap<Integer, IRegion>());
				tokens.clear();
				createTokens(e.fDocument.get(), blocks);
				return new Region(0, e.getDocument().getLength());
			}

			try {
				int lengthDelta = e.getText().length() - e.getLength();
				IRegion changeRegion = computeDamageRegion(e, lengthDelta);
				NavigableMap<Integer, IRegion> blocks = getUnchangedBlocks(changeRegion);
				String text = get(changeRegion.getOffset(), changeRegion.getLength());
				printRegions("Tokens: ", tokens.values());
				System.out.println("Text: '" + text + "'");

				// remove existing tokens within the change region - they will be regenerated
				removeTokens(changeRegion, lengthDelta);
				// printRegions("Tokens after clean: ", tokens.values());
				// update positions of tokens that are after change region
				shiftTokens(changeRegion, lengthDelta, blocks);
				// regenerate tokens within change region to reflect changes in text
				createTokens(changeRegion, lengthDelta, blocks, text);
				printRegions("Tokens after create: ", tokens.values());
				System.out.println("unchanged + newly created + shifted");
				verifyTokens(tokens);
				setBlocks(blocks);
				return changeRegion;
			} catch (BadLocationException ex) {
				setBlocks(new TreeMap<Integer, IRegion>());
				tokens.clear();
				createTokens(e.fDocument.get(), blocks);
				return new Region(0, e.getDocument().getLength());
			}
		}
	}

	private int getLine(int offset) {
		LexerTokenRegion lastTokenBeforeChange = offset == 0 ? null : tokens.get(tokens.floorKey(offset - 1));
		return lastTokenBeforeChange == null ? 0 : lastTokenBeforeChange.getLine() + 1;
	}

	private void removeTokens(IRegion changeRegion, int lengthDelta) {
		NavigableMap<Integer, LexerTokenRegion> subMap = tokens.subMap(changeRegion.getOffset(), true,
				tokens.floorKey(changeRegion.getOffset() + changeRegion.getLength() - lengthDelta), false);
		subMap.clear();
	}

	private void shiftTokens(IRegion changeRegion, int lengthDelta, NavigableMap<Integer, IRegion> blocks) {
		int blockOffset = -1;
		Map<Integer, LexerTokenRegion> shiftedTokens = new HashMap<>();
		Integer firstTokenToShift = tokens.floorKey(changeRegion.getOffset() + changeRegion.getLength() - lengthDelta);
		NavigableMap<Integer, LexerTokenRegion> tailToShift = tokens.subMap(firstTokenToShift, true, tokens.lastKey(), true);
		for (Iterator<Entry<Integer, LexerTokenRegion>> it = tailToShift.entrySet().iterator(); it.hasNext();) {
			Entry<Integer, LexerTokenRegion> entry = it.next();
			LexerTokenRegion token = entry.getValue();
			it.remove();
			LexerTokenRegion newToken = createTokenInfo(token, lengthDelta);
			if (newToken.isBlockStart() || newToken.isEndOfFile()) {
				if (blockOffset > -1) {
					blocks.put(blockOffset, new Region(blockOffset, newToken.getOffset() - blockOffset));
				}
				blockOffset = newToken.getOffset();
			}
			shiftedTokens.put(newToken.getOffset(), newToken);
		}
		tokens.putAll(shiftedTokens);
	}

	private void verifyTokens(NavigableMap<Integer, LexerTokenRegion> tempTokens) {
		ILexerTokenRegion last = null;
		for (ILexerTokenRegion elem : tempTokens.values()) {
			if (last != null) {
				if (last.getOffset() + last.getLength() != elem.getOffset()) {
					System.err.println("#################");
					System.err.println(last);
					System.err.println(elem);
					System.err.println("#################");
				}
			}
			last = elem;
		}
	}

	/**
	 * Return blocks that occur before changed region - they won't change so can be copied into new blocks list
	 * 
	 * @param changeRegion
	 * @return
	 */
	private NavigableMap<Integer, IRegion> getUnchangedBlocks(IRegion changeRegion) {
		if (blocks.isEmpty()) {
			return new TreeMap<>();
		}

		Integer last = changeRegion.getOffset() == 0 ? null : blocks.floorKey(changeRegion.getOffset() - 1);
		if (last == null) {
			return new TreeMap<>();
		}
		NavigableMap<Integer, IRegion> unchangedBlocks = new TreeMap<>(blocks.subMap(blocks.firstKey(), true, last, true));
		printRegions("Unchanged blocks: ", unchangedBlocks.values());
		return unchangedBlocks;
	}

	private IRegion computeDamageRegion(DocumentEvent e, int lengthDelta) throws BadLocationException {
		IRegion beginBlock = getBlockOrLine(e.getOffset() == 0 ? 0 : e.getOffset() - 1);
		IRegion endBlock = getBlockOrLine(e.getOffset() + e.getLength());
		int offset = beginBlock.getOffset();
		int length = endBlock.getOffset() - offset + endBlock.getLength() + lengthDelta;
		return new Region(offset, length);
	}

	private void createTokens(IRegion changeRegion, int lengthDelta, SortedMap<Integer, IRegion> blocks, String text) {
		createTokens(text, blocks, changeRegion.getOffset(), changeRegion.getLength(), lengthDelta);
	}

	private void createTokens(String text, SortedMap<Integer, IRegion> blocks) {
		createTokens(text, blocks, 0, 0, 0);
	}

	private void createTokens(String text, SortedMap<Integer, IRegion> blocks, int offset, int length, int delta) {
		int lineOffset = getLine(offset);
		lexer.setup(text, offset, lineOffset, length, delta);
		LexerTokenRegion tokenInfo = null;
		int blockOffset = -1;
		do {
			Token nextToken = lexer.nextToken();
			tokenInfo = createTokenInfo(nextToken, offset);
			// System.out.println(tokenInfo);
			if (tokenInfo.isBlockStart() || tokenInfo.isEndOfFile()) {
				if (blockOffset > -1) {
					Region block = new Region(blockOffset, tokenInfo.getOffset() - blockOffset);
					try {
						blocks.put(blockOffset, block);
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					}
				}
				blockOffset = tokenInfo.getOffset();
			}
			if (!tokenInfo.isEndOfFile() || tokens.higherKey(tokenInfo.getOffset()) == null) {
				tokens.put(tokenInfo.getOffset(), tokenInfo);
			}
		} while (tokenInfo.getType() != Token.EOF);
		// printRegions("Blocks: ", blocks.values());
	}

	public IRegion getBlockOrLine(int offset) throws BadLocationException {
		IRegion region = getBlock(offset);
		if (region == null) {
			return getLineInformationOfOffset(offset, true);
		}
		return region;
	}

	public IRegion getBlock(int offset) {
		Integer key = blocks.floorKey(offset);
		if (key == null) {
			return null;
		}
		IRegion block = blocks.get(key);
		// not a last block
		if (offset > block.getOffset() + block.getLength()) {
			return null;
		}
		return block;
	}

	private LexerTokenRegion createTokenInfo(Token token, int offset) {
		CommonToken ct = new CommonToken(token);
		ct.setStartIndex(offset + ct.getStartIndex());
		ct.setStopIndex(offset + ct.getStopIndex());
		return new LexerTokenRegion(ct);
	}

	private LexerTokenRegion createTokenInfo(ILexerTokenRegion token, int offset) {
		CommonToken ct = new CommonToken(token.getToken());
		ct.setStartIndex(offset + ct.getStartIndex());
		ct.setStopIndex(offset + ct.getStopIndex());
		return new LexerTokenRegion(ct);
	}

	protected ImpexLexer createLexer(TokenSourceProvider tokenSource, String text) {
		ImpexLexer source = tokenSource.get();
		source.removeErrorListeners();
		impexModel = new DefaultImpexModel();
		source.addErrorListener(new ImpexParserDefaultErrorListener(impexModel));
		source.setInputStream(new ANTLRInputStream(text));
		return source;
	}

	@Override
	public void documentAboutToBeChanged(DocumentEvent event) {
	}

	@Override
	public void documentChanged(DocumentEvent event) {
		updateStructure(event);
	}

	void ensureCorrectDocument(DocumentEvent e) {
		if (e.fDocument == getDelegate()) {
			e.fDocument = this;
		}
	}

	private DocumentEvent previousEvent;
	private IRegion previousRegion;

	public IRegion updateStructure(final DocumentEvent e) {
		try {
			if (previousEvent == e && previousRegion != null) {
				return previousRegion;
			}
			previousRegion = computeDamageRegion(e);
			return previousRegion;
		} finally {
			previousEvent = e;
		}
	}

	public IRegion getDamageRegion(final DocumentEvent e) {
		try {
			if (previousEvent == e && previousRegion != null) {
				return previousRegion;
			}
			return computeDamageRegion(e, e.getText().length() - e.getLength());
		} catch (BadLocationException e1) {
			return new Region(0, 0);
		}
	}
}
