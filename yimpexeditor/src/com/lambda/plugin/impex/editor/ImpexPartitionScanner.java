package com.lambda.plugin.impex.editor;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

import com.lambda.plugin.impex.antlr.AntlrTypeToPartitionTokenMapper;
import com.lambda.plugin.impex.model.ILexerTokenRegion;

/**
 * PartitionScanner allows documents to be partitioned into separate content types. These partitions allow the editor to
 * behave differently, depending on the various content types. For example, code completion, keyword highlighting and
 * formatting can behave differently for each partition type. Inspired by XText project.
 * 
 * @author Wojciech Poltorak
 * 
 */
public class ImpexPartitionScanner implements IPartitionTokenScanner {

    private int currentPartitionOffset;
    private int currentPartitionLength;
    private ILexerTokenRegion nextToken;
    private final AntlrTypeToPartitionTokenMapper tokenMapper;
    private Iterator<ILexerTokenRegion> tokenIterator;

    static final String[] CONTENT_TYPES = AntlrTypeToPartitionTokenMapper.getContentTypes();

    public ImpexPartitionScanner(AntlrTypeToPartitionTokenMapper tokenMapper) {
        this.tokenMapper = tokenMapper;
    }

    @Override
    public void setRange(IDocument document, int offset, int length) {
        setPartialRange(document, offset, length, null, 0);
    }

    @Override
    public void setPartialRange(IDocument document, int offset, int length, String contentType, int partitionOffset) {
        ImpexDocument impexDocument = (ImpexDocument) document;
        int overlapOffset = partitionOffset;
        int overlapLength = offset + length - partitionOffset;
        this.tokenIterator = new RangedIterator(impexDocument.getTokens(), new Region(overlapOffset, overlapLength));
        this.currentPartitionOffset = overlapOffset;
        this.currentPartitionLength = 0;
        this.nextToken = tokenIterator.hasNext() ? tokenIterator.next() : null;
    }

    @Override
    public IToken nextToken() {
        if (nextToken == null) {
            return Token.EOF;
        }

        this.currentPartitionOffset = nextToken.getOffset();
        this.currentPartitionLength = nextToken.getLength();
        String partitionType = AntlrTypeToPartitionTokenMapper.partitionType(nextToken.getType());

        while (tokenIterator.hasNext()) {
            nextToken = tokenIterator.next();
            String nextPartitionType = AntlrTypeToPartitionTokenMapper.partitionType(nextToken.getType());
            currentPartitionLength = nextToken.getOffset() - currentPartitionOffset;
            if (!partitionType.equals(nextPartitionType) || !IDocument.DEFAULT_CONTENT_TYPE.equals(partitionType)) {
                return new Token(partitionType);
            }
        }
        if (nextToken != null) {
            currentPartitionLength = nextToken.getOffset() + nextToken.getLength() - currentPartitionOffset;

        }
        nextToken = null;
        return new Token(partitionType);
    }

    @Override
    public int getTokenOffset() {
        return currentPartitionOffset;
    }

    @Override
    public int getTokenLength() {
        return currentPartitionLength;
    }

    private class RangedIterator implements Iterator<ILexerTokenRegion> {

        private static final int INIT = 0;
        private static final int OK = 1;
        private static final int END = 2;

        private final Iterator<? extends ILexerTokenRegion> delegate;
        private final Region overlapRegion;
        private ILexerTokenRegion next;
        private int status = INIT;

        public RangedIterator(Iterable<? extends ILexerTokenRegion> iterable, Region overlapRegion) {
            this.delegate = iterable.iterator();
            this.overlapRegion = overlapRegion;
        }

        @Override
        public boolean hasNext() {
            switch (status) {
            case END:
                return false;
            case OK:
                return true;
            }
            next = computeNextToken();
            if (status != END) {
                status = OK;
                return true;
            }
            return false;
        }

        @Override
        public ILexerTokenRegion next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            status = INIT;
            return next;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private ILexerTokenRegion computeNextToken() {
            while (delegate.hasNext()) {
                ILexerTokenRegion candidate = delegate.next();
                if (overlapRegion.getOffset() + overlapRegion.getLength() < candidate.getOffset()) {
                    status = END;
                    return null;
                }
                if (TextUtilities.overlaps(overlapRegion, candidate)) {
                    return candidate;
                }
            }
            status = END;
            return null;
        }
    }
}