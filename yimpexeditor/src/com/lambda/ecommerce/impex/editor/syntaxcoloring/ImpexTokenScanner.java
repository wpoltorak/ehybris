package com.lambda.ecommerce.impex.editor.syntaxcoloring;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextUtilities;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.rules.Token;

import com.lambda.ecommerce.impex.antlr.AntlrTypeToStyleTokenMapper;
import com.lambda.ecommerce.impex.editor.ImpexDocument;
import com.lambda.ecommerce.impex.model.ILexerTokenRegion;

//TODO improve token scanner  - do not iterate always from the beginning of the tokens
public class ImpexTokenScanner implements ITokenScanner {

    private ILexerTokenRegion nextToken;
    private Iterator<ILexerTokenRegion> tokenIterator;
    private final AntlrTypeToStyleTokenMapper tokenMapper;

    public ImpexTokenScanner(AntlrTypeToStyleTokenMapper tokenMapper) {
        this.tokenMapper = tokenMapper;
    }

    @Override
    public void setRange(IDocument document, int offset, int length) {
        ImpexDocument impexDocument = (ImpexDocument) document;
        nextToken = null;
        this.tokenIterator = new RangedIterator(impexDocument.getTokens(), new Region(offset, length));
    }

    @Override
    public IToken nextToken() {
        if (!tokenIterator.hasNext()) {
            return Token.EOF;
        }
        nextToken = tokenIterator.next();

        return tokenMapper.getToken(nextToken.getType());
    }

    @Override
    public int getTokenOffset() {
        return nextToken.getOffset();
    }

    @Override
    public int getTokenLength() {
        return nextToken.getLength();
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