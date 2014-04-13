package com.lambda.plugin.impex.editor;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

import com.lambda.impex.ast.ImpexLexer;
import com.lambda.plugin.impex.antlr.TypeToPartitionTokenMapper;
import com.lambda.plugin.impex.model.ILexerTokenRegion;

/**
 * PartitionScanner allows documents to be partitioned into separate content types. These partitions allow the editor to
 * behave differently, depending on the various content types. For example, code completion, keyword highlighting and
 * formatting can behave differently for each partition type.
 * 
 * @author Wojciech Poltorak
 * 
 */
public class ImpexPartitionScanner implements IPartitionTokenScanner {

    private static final String MODE = "__block_partition_content_type";
    private static final String MACRO = "__macro_partition_content_type";
    // private static final String FIELD = "__field_partition_content_type";
    private static final String COMMENT = "__comment_partition_content_type";

    private int currentPartitionOffset;
    private int currentPartitionLength;
    private ILexerTokenRegion nextToken;
    private final TypeToPartitionTokenMapper tokenMapper;
    private Iterator<ILexerTokenRegion> tokenIterator;
    private static final Map<Integer, String> map = new LinkedHashMap<Integer, String>();
    static {
        map.put(ImpexLexer.Insert, MODE);
        map.put(ImpexLexer.InsertUpdate, MODE);
        map.put(ImpexLexer.Update, MODE);
        map.put(ImpexLexer.Remove, MODE);
        map.put(ImpexLexer.Macrodef, MACRO);
        // map.put(ImpexLexer.Field, FIELD);
        map.put(ImpexLexer.Comment, COMMENT);
        map.put(null, IDocument.DEFAULT_CONTENT_TYPE);
    }

    static final String[] CONTENT_TYPES = map.values().toArray(new String[map.size()]);

    public ImpexPartitionScanner(TypeToPartitionTokenMapper tokenMapper) {
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
        String partitionType = partitionType(nextToken.getTokenType());

        while (tokenIterator.hasNext()) {
            nextToken = tokenIterator.next();
            String nextPartitionType = partitionType(nextToken.getTokenType());
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

    private String partitionType(int tokenType) {
        String partitionType = map.containsKey(tokenType) ? map.get(tokenType) : IDocument.DEFAULT_CONTENT_TYPE;
        return partitionType;
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

        private final Iterator<ILexerTokenRegion> delegate;
        private final Region overlapRegion;
        private ILexerTokenRegion next;
        private int status = INIT;

        public RangedIterator(Iterable<ILexerTokenRegion> iterable, Region overlapRegion) {
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