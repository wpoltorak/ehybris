package com.lambda.plugin.impex.editor;

import java.util.Collection;
import java.util.List;
import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;

import com.lambda.impex.ast.DefaultImpexModel;
import com.lambda.impex.ast.ImpexLexer;
import com.lambda.impex.ast.ImpexModel;
import com.lambda.impex.ast.ImpexParser;
import com.lambda.impex.ast.ImpexParserDefaultErrorListener;
import com.lambda.impex.ast.ImpexParserDefaultListener;
import com.lambda.impex.ast.ImpexProblem;
import com.lambda.plugin.impex.antlr.JavaTypeFinder;
import com.lambda.plugin.impex.antlr.TokenSourceProvider;
import com.lambda.plugin.impex.model.ILexerTokenRegion;
import com.lambda.plugin.impex.model.LexerTokenRegion;

public class ImpexDocument extends DocumentWrapper implements IDocumentListener {

    private NavigableMap<Integer, ILexerTokenRegion> tokens = null;
    private NavigableMap<Integer, IRegion> blocks = null;
    private ImpexModel impexModel;
    private final Lexer lexer;
    private ParseTree parseTree;

    public ImpexDocument(IDocument delegate, TokenSourceProvider tokenSource) {
        super(delegate);
        String text = this.get();
        this.lexer = createLexer(tokenSource, text);
        this.blocks = new TreeMap<>();
        setTokens(createTokens(text, blocks));
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

    private void setTokens(NavigableMap<Integer, ILexerTokenRegion> tokens) {
        // printRegions("Tokens: ", tokens.values());
        this.tokens = tokens;
    }

    private void setBlocks(NavigableMap<Integer, IRegion> blocks) {
        // printRegions("Blocks: ", blocks.values());
        this.blocks = blocks;
    }

    private void printRegions(String info, Collection<? extends IRegion> collection) {
        System.out.println(info);
        for (IRegion region : collection) {
            System.out.println("next: " + (region.getOffset() + region.getLength()) + ", " + region);
        }

    }

    public Iterable<ILexerTokenRegion> getTokens() {
        return tokens.values();
    }

    public IRegion getLineInformationOfOffset(int offset, boolean includeSeparatedLines) throws BadLocationException {
        int lineOffset = 0;
        int lineLength = 0;
        int first = offset;
        // rewind to first line of all the 'line separated' lines and calculate offset & line lengths
        do {
            IRegion line = getLineInformationOfOffset(first);
            lineOffset = line.getOffset();
            lineLength += line.getLength() + 1;
            first = lineOffset - 1;
        } while (includeSeparatedLines && first > 0 && getToken(first).getTokenType() != ImpexLexer.Lb);
        // select last token of current line
        ILexerTokenRegion last = getToken(lineOffset + lineLength - 1);
        // forward to all the next 'line separated' lines and calculate their lengths
        while (includeSeparatedLines && (last.getTokenType() != ImpexLexer.Lb && last.getTokenType() != ImpexLexer.EOF)) {
            IRegion line = getLineInformationOfOffset(lineOffset + lineLength + 1);
            lineLength += line.getLength() + 1;
            last = getToken(lineOffset + lineLength - 1);
        }
        return new Region(lineOffset, lineLength);
    }

    /**
     * Returns all the line tokens. <br>
     * Takes into account LineSeparator
     * 
     * @param offset
     * @return
     * @throws BadLocationException
     */
    public Iterable<ILexerTokenRegion> getLineTokensOfOffset(int offset, boolean includeSeparatedLines)
            throws BadLocationException {
        IRegion line = getLineInformationOfOffset(offset, true);
        return tokens.subMap(tokens.floorKey(line.getOffset()), tokens.floorKey(line.getLength() + line.getLength()))
                .values();
    }

    public Iterable<ILexerTokenRegion> getLineTokens(int line, boolean includeSeparatedLines)
            throws BadLocationException {
        IRegion lineinfo = getLineInformation(line);
        if (includeSeparatedLines) {
            lineinfo = getLineInformationOfOffset(lineinfo.getOffset(), includeSeparatedLines);
        }
        return tokens.subMap(tokens.floorKey(lineinfo.getOffset()),
                tokens.floorKey(lineinfo.getOffset() + lineinfo.getLength())).values();
    }

    public ILexerTokenRegion getToken(int offset) throws BadLocationException {
        if ((0 > offset) || (offset > getLength())) {
            throw new BadLocationException();
        }
        return tokens.get(tokens.floorKey(offset));
    }

    public List<ImpexProblem> validate() {
        long nanoTime = System.nanoTime();
        try {
            System.err.println("===> VALIDATE BEGIN");
            char[] source = get().toCharArray();
            final ImpexLexer lexer = new ImpexLexer(new ANTLRInputStream(source, source.length));
            ImpexParser parser = new ImpexParser(new CommonTokenStream(lexer));
            parseTree = parser.impex();

            final ParseTreeWalker walker = new ParseTreeWalker();
            ImpexModel impexModel = new DefaultImpexModel();
            ImpexParserDefaultListener listener = new ImpexParserDefaultListener(impexModel);
            listener.setTypeFinder(new JavaTypeFinder());
            walker.walk(listener, parseTree);
            this.impexModel = impexModel;
            return impexModel.getProblems();
        } finally {
            System.err.println("===> VALIDATE END: took "
                    + TimeUnit.SECONDS.convert(System.nanoTime() - nanoTime, TimeUnit.NANOSECONDS) + " seconds");
        }
    }

    public ImpexModel getModel() {
        return impexModel;
    }

    public ParseTree getParseTree() {
        return parseTree;
    }

    protected IRegion computeDamageRegion(final DocumentEvent e) {
        // empty document -> no dirty region
        if (e.getDocument().getLength() == 0) {
            setBlocks(new TreeMap<Integer, IRegion>());
            setTokens(createTokens(e.fDocument.get(), blocks));
            return new Region(0, 0);
        }

        // previously empty -> full document dirty
        if (tokens.isEmpty()) {
            setBlocks(new TreeMap<Integer, IRegion>());
            setTokens(createTokens(e.fDocument.get(), blocks));
            return new Region(0, e.getDocument().getLength());
        }

        try {
            int lengthDelta = e.getText().length() - e.getLength();
            IRegion changeRegion = computeDamageRegion(e, lengthDelta);
            NavigableMap<Integer, IRegion> blocks = getUnchangedBlocks(changeRegion);
            String text = get(changeRegion.getOffset(), changeRegion.getLength());
            // System.out.println("Text: '" + text + "'");
            NavigableMap<Integer, ILexerTokenRegion> tempTokens = getUnchangedTokens(changeRegion);
            SortedMap<Integer, ILexerTokenRegion> tempTokens2 = tokens.subMap(
                    tokens.floorKey(changeRegion.getOffset() + changeRegion.getLength() - lengthDelta), true,
                    tokens.lastKey(), true);
            tempTokens.putAll(createTokens(text, blocks, changeRegion.getOffset(), tempTokens2.isEmpty()));

            int blockOffset = -1;
            for (ILexerTokenRegion token : tempTokens2.values()) {
                LexerTokenRegion newToken = createTokenInfo(token, lengthDelta);
                if (newToken.isBlockStart() || newToken.isEndOfFile()) {
                    if (blockOffset > -1) {
                        blocks.put(blockOffset, new Region(blockOffset, newToken.getOffset() - blockOffset));
                    }
                    blockOffset = newToken.getOffset();
                }
                tempTokens.put(newToken.getOffset(), newToken);
            }

            // verifyTokens(tempTokens);
            setTokens(tempTokens);
            setBlocks(blocks);
            return changeRegion;
        } catch (BadLocationException ex) {
            setBlocks(new TreeMap<Integer, IRegion>());
            setTokens(createTokens(e.fDocument.get(), blocks));
            return new Region(0, e.getDocument().getLength());
        }
    }

    @SuppressWarnings("unused")
    private void verifyTokens(NavigableMap<Integer, ILexerTokenRegion> tempTokens) {
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

    private NavigableMap<Integer, ILexerTokenRegion> getUnchangedTokens(IRegion changeRegion) {
        Integer last = changeRegion.getOffset() == 0 ? null : tokens.floorKey(changeRegion.getOffset() - 1);
        if (last == null) {
            return new TreeMap<>();
        }

        return new TreeMap<>(tokens.subMap(tokens.firstKey(), true, last, true));
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
        NavigableMap<Integer, IRegion> unchangedBlocks = new TreeMap<>(blocks.subMap(blocks.firstKey(), true, last,
                true));
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

    private TreeMap<Integer, ILexerTokenRegion> createTokens(String text, SortedMap<Integer, IRegion> blocks) {
        return createTokens(text, blocks, 0, true);
    }

    private TreeMap<Integer, ILexerTokenRegion> createTokens(String text, SortedMap<Integer, IRegion> blocks,
            int shift, boolean includeEOF) {
        TreeMap<Integer, ILexerTokenRegion> tokens = new TreeMap<>();
        lexer.setInputStream(new ANTLRInputStream(text));
        LexerTokenRegion tokenInfo = null;
        int blockOffset = -1;
        do {
            tokenInfo = createTokenInfo(lexer.nextToken(), shift);
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
            if (!tokenInfo.isEndOfFile() || includeEOF) {
                tokens.put(tokenInfo.getOffset(), tokenInfo);
            }
        } while (tokenInfo.getTokenType() != Token.EOF);
        // printRegions("Blocks: ", blocks.values());
        return tokens;
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
        return blocks.get(key);
    }

    private LexerTokenRegion createTokenInfo(Token token, int shift) {
        return new LexerTokenRegion(token.getStartIndex() + shift, token.getStopIndex() - token.getStartIndex() + 1,
                token.getType());
    }

    private LexerTokenRegion createTokenInfo(ILexerTokenRegion token, int shift) {
        return new LexerTokenRegion(token.getOffset() + shift, token.getLength(), token.getTokenType());
    }

    protected Lexer createLexer(TokenSourceProvider tokenSource, String text) {
        Lexer source = tokenSource.get();
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
