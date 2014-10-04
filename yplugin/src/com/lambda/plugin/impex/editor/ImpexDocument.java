package com.lambda.plugin.impex.editor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenSource;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPartitioningException;
import org.eclipse.jface.text.BadPositionCategoryException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.DocumentRewriteSession;
import org.eclipse.jface.text.DocumentRewriteSessionType;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension;
import org.eclipse.jface.text.IDocumentExtension2;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IDocumentExtension4;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.IDocumentPartitioningListener;
import org.eclipse.jface.text.IDocumentRewriteSessionListener;
import org.eclipse.jface.text.IPositionUpdater;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;

import com.lambda.impex.ast.DefaultImpexModel;
import com.lambda.impex.ast.ImpexModel;
import com.lambda.impex.ast.ImpexParser;
import com.lambda.impex.ast.ImpexParserDefaultErrorListener;
import com.lambda.impex.ast.ImpexParserDefaultListener;
import com.lambda.plugin.impex.antlr.TokenSourceProvider;
import com.lambda.plugin.impex.model.ILexerTokenRegion;
import com.lambda.plugin.impex.model.LexerTokenRegion;

public class ImpexDocument implements IDocument, IDocumentExtension, IDocumentExtension2, IDocumentExtension3,
        IDocumentExtension4 {

    private List<ILexerTokenRegion> tokens = Collections.emptyList();
    private final IDocument delegate;
    private final TokenSourceProvider tokenSource;
    private ImpexModel impexModel;

    public ImpexDocument(IDocument delegate, TokenSourceProvider tokenSource) {
        this.delegate = delegate;
        this.tokenSource = tokenSource;
        setTokens(createTokens(this.get()));
    }

    private void setTokens(List<ILexerTokenRegion> tokens) {
        this.tokens = tokens;
    }

    public Iterable<ILexerTokenRegion> getTokens() {
        return tokens;
    }

    public ILexerTokenRegion getToken(int offset) throws BadLocationException {
        if ((0 > offset) || (offset > getLength())) {
            throw new BadLocationException();
        }
        for (ILexerTokenRegion region : tokens) {
            if (region.getOffset() <= offset && region.getOffset() + region.getLength() >= offset) {
                return region;
            }
        }
        return null;
    }

    public void validate() {
        TokenSourceProvider tokenSource = new TokenSourceProvider();
        Lexer lexer = tokenSource.get();
        lexer.removeErrorListeners();
        impexModel = new DefaultImpexModel();
        lexer.addErrorListener(new ImpexParserDefaultErrorListener(impexModel));
        lexer.setInputStream(new ANTLRInputStream(this.get()));
        ImpexParser parser = new ImpexParser(new CommonTokenStream(lexer));

        final ParseTree impex = parser.impex();

        final ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(new ImpexParserDefaultListener(impexModel), impex);

    }

    public ImpexModel getModel() {
        return impexModel;
    }

    protected IRegion computeDamageRegion(final DocumentEvent e) {
        // empty document -> no dirty region
        if (e.getDocument().getLength() == 0) {
            setTokens(createTokens(e.fDocument.get()));
            return new Region(0, 0);
        }

        // previously empty -> full document dirty
        // if (tokens.isEmpty()) {
        setTokens(createTokens(e.fDocument.get()));
        return new Region(0, e.getDocument().getLength());
        // }
        // TODO handle case for partitions - rewind to last block start and parse until end of the file
        // List<ILexerTokenRegion> tempTokens = new ArrayList<ILexerTokenRegion>(tokens);
        // try {
        // int tokenStartsAt = 0;
        // int tokenInfoIdx = 0;
        // for (tokenInfoIdx = 0; tokenInfoIdx < tempTokens.size(); ++tokenInfoIdx) {
        // ILexerTokenRegion oldToken = tempTokens.get(tokenInfoIdx);
        // if (tokenStartsAt <= e.getOffset() && tokenStartsAt + oldToken.getLength() >= e.getOffset())
        // break;
        // tokenStartsAt += oldToken.getLength();
        // }
        // final TokenSource delegate = createTokenSource(e.fDocument.get(tokenStartsAt, e.fDocument.getLength()
        // - tokenStartsAt));
        // final int offset = tokenStartsAt;
        // TokenSource source = new TokenSource() {
        // @Override
        // public Token nextToken() {
        // CommonToken commonToken = (CommonToken) delegate.nextToken();
        // commonToken.setText(commonToken.getText());
        // commonToken.setStartIndex(commonToken.getStartIndex() + offset);
        // commonToken.setStopIndex(commonToken.getStopIndex() + offset);
        // return commonToken;
        // }
        //
        // @Override
        // public String getSourceName() {
        // return delegate.getSourceName();
        // }
        //
        // @Override
        // public int getCharPositionInLine() {
        // return delegate.getCharPositionInLine();
        // }
        //
        // @Override
        // public CharStream getInputStream() {
        // return delegate.getInputStream();
        // }
        //
        // @Override
        // public int getLine() {
        // return delegate.getLine();
        // }
        //
        // @Override
        // public TokenFactory<?> getTokenFactory() {
        // return delegate.getTokenFactory();
        // }
        //
        // @Override
        // public void setTokenFactory(TokenFactory<?> arg0) {
        // delegate.setTokenFactory(arg0);
        //
        // }
        // };
        // CommonToken token = (CommonToken) source.nextToken();
        //
        // if (token.getType() == Token.EOF)
        // tempTokens.subList(tokenInfoIdx, tempTokens.size()).clear();
        // int regionOffset = offset;
        // int regionLength = e.fDocument.getLength() - offset;
        //
        // int lengthDiff = e.fText.length() - e.fLength;
        // // compute region length
        // while (true) {
        // if (token.getType() == Token.EOF || tokenInfoIdx >= tempTokens.size()) {
        // break;
        // }
        // while (true) {
        // if (tokenInfoIdx >= tempTokens.size()) {
        // break;
        // }
        // ILexerTokenRegion tokenInfo = tempTokens.get(tokenInfoIdx);
        // if (token.getStartIndex() >= e.fOffset + e.fText.length()) {
        // if (tokenStartsAt + lengthDiff == token.getStartIndex()
        // && tokenInfo.getTokenType() == token.getType()
        // && token.getStopIndex() - token.getStartIndex() + 1 == tokenInfo.getLength()) {
        // return new Region(regionOffset, token.getStartIndex() - regionOffset);
        // }
        // }
        // if (tokenStartsAt + lengthDiff + tokenInfo.getLength() > token.getStopIndex() + 1) {
        // break;
        // }
        // tempTokens.remove(tokenInfoIdx);
        // tokenStartsAt += tokenInfo.getLength();
        // if (tokenStartsAt + lengthDiff > token.getStartIndex())
        // break;
        // }
        // tempTokens.add(tokenInfoIdx++, createTokenInfo(token));
        // token = (CommonToken) source.nextToken();
        // }
        // tempTokens.subList(tokenInfoIdx, tempTokens.size()).clear();
        // // add subsequent tokens
        // if (tokenInfoIdx >= tempTokens.size()) {
        // while (token.getType() != Token.EOF) {
        // tempTokens.add(createTokenInfo(token));
        // token = (CommonToken) source.nextToken();
        // }
        // }
        // return new Region(regionOffset, regionLength);
        // } catch (Exception exc) {
        // YPlugin.logError("Error computing damaged region", exc);
        // tempTokens = createTokens(e.fDocument.get());
        // return new Region(0, e.fDocument.getLength());
        // } finally {
        // setTokens(tempTokens);
        // }
    }

    private List<ILexerTokenRegion> createTokens(String text) {
        List<ILexerTokenRegion> tokens = new ArrayList<ILexerTokenRegion>();
        TokenSource source = createTokenSource(text);
        Token token = null;
        do {
            token = source.nextToken();
            tokens.add(createTokenInfo(token));
        } while (token.getType() != Token.EOF);

        return tokens;
    }

    private LexerTokenRegion createTokenInfo(Token token) {
        return new LexerTokenRegion(token.getStartIndex(), token.getStopIndex() - token.getStartIndex() + 1,
                token.getType());
    }

    protected TokenSource createTokenSource(String text) {
        Lexer source = tokenSource.get();
        source.removeErrorListeners();
        source.setInputStream(new ANTLRInputStream(text));
        return source;
    }

    public IDocument getDelegate() {
        return delegate;
    }

    @Override
    public char getChar(int offset) throws BadLocationException {
        return delegate.getChar(offset);
    }

    @Override
    public int getLength() {
        return delegate.getLength();
    }

    @Override
    public String get() {
        return delegate.get();
    }

    @Override
    public String get(int offset, int length) throws BadLocationException {
        return delegate.get(offset, length);
    }

    @Override
    public void set(String text) {
        delegate.set(text);
    }

    @Override
    public void replace(int offset, int length, String text) throws BadLocationException {
        delegate.replace(offset, length, text);
    }

    @Override
    public void addDocumentListener(IDocumentListener listener) {
        delegate.addDocumentListener(listener);
    }

    @Override
    public void removeDocumentListener(IDocumentListener listener) {
        delegate.removeDocumentListener(listener);
    }

    @Override
    public void addPrenotifiedDocumentListener(IDocumentListener documentAdapter) {
        delegate.addPrenotifiedDocumentListener(documentAdapter);
    }

    @Override
    public void removePrenotifiedDocumentListener(IDocumentListener documentAdapter) {
        delegate.removePrenotifiedDocumentListener(documentAdapter);
    }

    @Override
    public void addPositionCategory(String category) {
        delegate.addPositionCategory(category);
    }

    @Override
    public void removePositionCategory(String category) throws BadPositionCategoryException {
        delegate.removePositionCategory(category);
    }

    @Override
    public String[] getPositionCategories() {
        return delegate.getPositionCategories();
    }

    @Override
    public boolean containsPositionCategory(String category) {
        return delegate.containsPositionCategory(category);
    }

    @Override
    public void addPosition(Position position) throws BadLocationException {
        delegate.addPosition(position);
    }

    @Override
    public void removePosition(Position position) {
        delegate.removePosition(position);
    }

    @Override
    public void addPosition(String category, Position position) throws BadLocationException,
            BadPositionCategoryException {
        delegate.addPosition(category, position);
    }

    @Override
    public void removePosition(String category, Position position) throws BadPositionCategoryException {
        delegate.removePosition(category, position);
    }

    @Override
    public Position[] getPositions(String category) throws BadPositionCategoryException {
        return delegate.getPositions(category);
    }

    @Override
    public boolean containsPosition(String category, int offset, int length) {
        return delegate.containsPosition(category, offset, length);
    }

    @Override
    public int computeIndexInCategory(String category, int offset) throws BadLocationException,
            BadPositionCategoryException {
        return delegate.computeIndexInCategory(category, offset);
    }

    @Override
    public void addPositionUpdater(IPositionUpdater updater) {
        delegate.addPositionUpdater(updater);
    }

    @Override
    public void removePositionUpdater(IPositionUpdater updater) {
        delegate.removePositionUpdater(updater);
    }

    @Override
    public void insertPositionUpdater(IPositionUpdater updater, int index) {
        delegate.insertPositionUpdater(updater, index);
    }

    @Override
    public IPositionUpdater[] getPositionUpdaters() {
        return delegate.getPositionUpdaters();
    }

    @Override
    public String[] getLegalContentTypes() {
        return delegate.getLegalContentTypes();
    }

    @Override
    public String getContentType(int offset) throws BadLocationException {
        return delegate.getContentType(offset);
    }

    @Override
    public ITypedRegion getPartition(int offset) throws BadLocationException {
        return delegate.getPartition(offset);
    }

    @Override
    public ITypedRegion[] computePartitioning(int offset, int length) throws BadLocationException {
        return delegate.computePartitioning(offset, length);
    }

    @Override
    public void addDocumentPartitioningListener(IDocumentPartitioningListener listener) {
        delegate.addDocumentPartitioningListener(listener);
    }

    @Override
    public void removeDocumentPartitioningListener(IDocumentPartitioningListener listener) {
        delegate.removeDocumentPartitioningListener(listener);
    }

    @Override
    public void setDocumentPartitioner(IDocumentPartitioner partitioner) {
        delegate.setDocumentPartitioner(partitioner);
    }

    @Override
    public IDocumentPartitioner getDocumentPartitioner() {
        return delegate.getDocumentPartitioner();
    }

    @Override
    public int getLineLength(int line) throws BadLocationException {
        return delegate.getLineLength(line);
    }

    @Override
    public int getLineOfOffset(int offset) throws BadLocationException {
        return delegate.getLineOfOffset(offset);
    }

    @Override
    public int getLineOffset(int line) throws BadLocationException {
        return delegate.getLineOffset(line);
    }

    @Override
    public IRegion getLineInformation(int line) throws BadLocationException {
        return delegate.getLineInformation(line);
    }

    @Override
    public IRegion getLineInformationOfOffset(int offset) throws BadLocationException {
        return delegate.getLineInformationOfOffset(offset);
    }

    @Override
    public int getNumberOfLines() {
        return delegate.getNumberOfLines();
    }

    @Override
    public int getNumberOfLines(int offset, int length) throws BadLocationException {
        return delegate.getNumberOfLines(offset, length);
    }

    @Override
    public int computeNumberOfLines(String text) {
        return delegate.computeNumberOfLines(text);
    }

    @Override
    public String[] getLegalLineDelimiters() {
        return delegate.getLegalLineDelimiters();
    }

    @Override
    public String getLineDelimiter(int line) throws BadLocationException {
        return delegate.getLineDelimiter(line);
    }

    @SuppressWarnings("deprecation")
    @Override
    public int search(int startOffset, String findString, boolean forwardSearch, boolean caseSensitive,
            boolean wholeWord) throws BadLocationException {
        return delegate.search(startOffset, findString, forwardSearch, caseSensitive, wholeWord);
    }

    @Override
    public void registerPostNotificationReplace(IDocumentListener owner, IReplace replace)
            throws UnsupportedOperationException {
        if (delegate instanceof IDocumentExtension) {
            ((IDocumentExtension) delegate).registerPostNotificationReplace(owner, replace);
        }
    }

    @Override
    public void stopPostNotificationProcessing() {
        if (delegate instanceof IDocumentExtension) {
            ((IDocumentExtension) delegate).stopPostNotificationProcessing();
        }
    }

    @Override
    public void resumePostNotificationProcessing() {
        if (delegate instanceof IDocumentExtension) {
            ((IDocumentExtension) delegate).resumePostNotificationProcessing();
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void startSequentialRewrite(boolean normalize) {
        if (delegate instanceof IDocumentExtension) {
            ((IDocumentExtension) delegate).startSequentialRewrite(normalize);
        }
    }

    @SuppressWarnings("deprecation")
    @Override
    public void stopSequentialRewrite() {
        if (delegate instanceof IDocumentExtension) {
            ((IDocumentExtension) delegate).stopSequentialRewrite();
        }
    }

    @Override
    public void ignorePostNotificationReplaces() {
        if (delegate instanceof IDocumentExtension2) {
            ((IDocumentExtension2) delegate).ignorePostNotificationReplaces();
        }
    }

    @Override
    public void acceptPostNotificationReplaces() {
        if (delegate instanceof IDocumentExtension2) {
            ((IDocumentExtension2) delegate).acceptPostNotificationReplaces();
        }
    }

    @Override
    public void stopListenerNotification() {
        if (delegate instanceof IDocumentExtension2) {
            ((IDocumentExtension2) delegate).stopListenerNotification();
        }
    }

    @Override
    public void resumeListenerNotification() {
        if (delegate instanceof IDocumentExtension2) {
            ((IDocumentExtension2) delegate).resumeListenerNotification();
        }
    }

    @Override
    public String[] getPartitionings() {
        if (delegate instanceof IDocumentExtension3) {
            return ((IDocumentExtension3) delegate).getPartitionings();
        }
        return null;
    }

    @Override
    public String[] getLegalContentTypes(String partitioning) throws BadPartitioningException {
        if (delegate instanceof IDocumentExtension3) {
            return ((IDocumentExtension3) delegate).getLegalContentTypes(partitioning);
        }
        return null;
    }

    @Override
    public String getContentType(String partitioning, int offset, boolean preferOpenPartitions)
            throws BadLocationException, BadPartitioningException {
        if (delegate instanceof IDocumentExtension3) {
            return ((IDocumentExtension3) delegate).getContentType(partitioning, offset, preferOpenPartitions);
        }
        return null;
    }

    @Override
    public ITypedRegion getPartition(String partitioning, int offset, boolean preferOpenPartitions)
            throws BadLocationException, BadPartitioningException {
        if (delegate instanceof IDocumentExtension3) {
            return ((IDocumentExtension3) delegate).getPartition(partitioning, offset, preferOpenPartitions);
        }
        return null;
    }

    @Override
    public ITypedRegion[] computePartitioning(String partitioning, int offset, int length,
            boolean includeZeroLengthPartitions) throws BadLocationException, BadPartitioningException {
        if (delegate instanceof IDocumentExtension3) {
            return ((IDocumentExtension3) delegate).computePartitioning(partitioning, offset, length,
                    includeZeroLengthPartitions);
        }
        return null;
    }

    @Override
    public void setDocumentPartitioner(String partitioning, IDocumentPartitioner partitioner) {
        if (delegate instanceof IDocumentExtension3) {
            ((IDocumentExtension3) delegate).setDocumentPartitioner(partitioning, partitioner);
        }
    }

    @Override
    public IDocumentPartitioner getDocumentPartitioner(String partitioning) {
        if (delegate instanceof IDocumentExtension3) {
            return ((IDocumentExtension3) delegate).getDocumentPartitioner(partitioning);
        }
        return null;
    }

    @Override
    public DocumentRewriteSession startRewriteSession(DocumentRewriteSessionType sessionType)
            throws IllegalStateException {
        if (delegate instanceof IDocumentExtension4) {
            return ((IDocumentExtension4) delegate).startRewriteSession(sessionType);
        }
        return null;
    }

    @Override
    public void stopRewriteSession(DocumentRewriteSession session) {
        if (delegate instanceof IDocumentExtension4) {
            ((IDocumentExtension4) delegate).stopRewriteSession(session);
        }
    }

    @Override
    public DocumentRewriteSession getActiveRewriteSession() {
        if (delegate instanceof IDocumentExtension4) {
            return ((IDocumentExtension4) delegate).getActiveRewriteSession();
        }
        return null;
    }

    @Override
    public void addDocumentRewriteSessionListener(IDocumentRewriteSessionListener listener) {
        if (delegate instanceof IDocumentExtension4) {
            ((IDocumentExtension4) delegate).addDocumentRewriteSessionListener(listener);
        }
    }

    @Override
    public void removeDocumentRewriteSessionListener(IDocumentRewriteSessionListener listener) {
        if (delegate instanceof IDocumentExtension4) {
            ((IDocumentExtension4) delegate).removeDocumentRewriteSessionListener(listener);
        }
    }

    @Override
    public void replace(int offset, int length, String text, long modificationStamp) throws BadLocationException {
        if (delegate instanceof IDocumentExtension4) {
            ((IDocumentExtension4) delegate).replace(offset, length, text, modificationStamp);
        }
    }

    @Override
    public void set(String text, long modificationStamp) {
        if (delegate instanceof IDocumentExtension4) {
            ((IDocumentExtension4) delegate).set(text, modificationStamp);
        }
    }

    @Override
    public long getModificationStamp() {
        if (delegate instanceof IDocumentExtension4) {
            return ((IDocumentExtension4) delegate).getModificationStamp();
        }
        return 0;
    }

    @Override
    public String getDefaultLineDelimiter() {
        if (delegate instanceof IDocumentExtension4) {
            return ((IDocumentExtension4) delegate).getDefaultLineDelimiter();
        }
        return null;
    }

    @Override
    public void setInitialLineDelimiter(String lineDelimiter) {
        if (delegate instanceof IDocumentExtension4) {
            ((IDocumentExtension4) delegate).setInitialLineDelimiter(lineDelimiter);
        }
    }

    protected static class RepairEntryData {
        final int offset;
        final int index;
        final CommonToken newToken;
        final TokenSource tokenSource;

        public RepairEntryData(int offset, int index, CommonToken newToken, TokenSource lexer) {
            super();
            this.offset = offset;
            this.index = index;
            this.newToken = newToken;
            this.tokenSource = lexer;
        }
    }

}
