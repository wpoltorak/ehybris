package com.lambda.plugin.impex.editor;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.Token;

import com.lambda.impex.ast.ImpexLexer;
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

    private static final String BLOCK = "__block_partition_content_type";
    private static final String MACRO = "__macro_partition_content_type";
    private static final String FIELD = "__field_partition_content_type";
    private static final String COMMENT = "__comment_partition_content_type";

    private int currentPartitionOffset;
    private int currentPartitionLength;
    private Region overlapRegion;
    private ILexerTokenRegion nextToken;
    private Iterator<ILexerTokenRegion> tokenIterator;
    private final AntlrTokenToTokenMapper tokenMapper;
    private static final Map<Integer, String> map = new LinkedHashMap<Integer, String>();
    static {
        map.put(ImpexLexer.Insert, BLOCK);
        map.put(ImpexLexer.InsertUpdate, BLOCK);
        map.put(ImpexLexer.Update, BLOCK);
        map.put(ImpexLexer.Remove, BLOCK);
        map.put(ImpexLexer.Macrodef, MACRO);
        map.put(ImpexLexer.Field, FIELD);
        map.put(ImpexLexer.Comment, COMMENT);
        map.put(null, IDocument.DEFAULT_CONTENT_TYPE);
    }

    static final String[] CONTENT_TYPES = map.values().toArray(new String[map.size()]);

    public ImpexPartitionScanner(AntlrTokenToTokenMapper tokenMapper) {
        this.tokenMapper = tokenMapper;
    }

    class KeywordDetector implements IWordDetector {
        @Override
        public boolean isWordStart(final char c) {
            return Character.isLetter(c);
        }

        @Override
        public boolean isWordPart(final char c) {
            return c == '_' || Character.isLetter(c);
        }
    }

    @Override
    public void setRange(IDocument document, int offset, int length) {
        setPartialRange(document, offset, length, null, 0);
    }

    @Override
    public void setPartialRange(IDocument document, int offset, int length, String contentType, int partitionOffset) {
        ImpexDocument impexDocument = (ImpexDocument) document;
        this.tokenIterator = impexDocument.getTokens().iterator();
        int overlapOffset = partitionOffset;
        int overlapLength = offset + length - partitionOffset;
        this.overlapRegion = new Region(overlapOffset, overlapLength);
        this.currentPartitionOffset = overlapOffset;
        this.currentPartitionLength = 0;
        this.nextToken = computeNextToken();
    }

    @Override
    public IToken nextToken() {
        if (nextToken == null) {
            return Token.EOF;
        }

        this.currentPartitionOffset = nextToken.getOffset();
        this.currentPartitionLength = nextToken.getLength();
        String partitionType = map.containsKey(nextToken.getTokenType()) ? map.get(nextToken.getTokenType())
                : IDocument.DEFAULT_CONTENT_TYPE;

        IToken token = tokenMapper.getToken(nextToken.getTokenType(), partitionType);

        nextToken = computeNextToken();
        return token;
    }

    private ILexerTokenRegion computeNextToken() {
        while (tokenIterator.hasNext()) {
            ILexerTokenRegion candidate = tokenIterator.next();
            if (overlapRegion.getOffset() + overlapRegion.getLength() < candidate.getOffset())
                return null;
            if (TextUtilities.overlaps(overlapRegion, candidate)) {
                return candidate;
            }
        }
        return null;
    }

    @Override
    public int getTokenOffset() {
        return currentPartitionOffset;
    }

    @Override
    public int getTokenLength() {
        return currentPartitionLength;
    }

}