package com.lambda.plugin.impex.editor.syntaxcoloring;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Token;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.ITokenScanner;

import com.lambda.plugin.YPlugin;

public class AntlrTokenScanner implements ITokenScanner {

    private final Lexer scanner;
    private Token current;
    private int dirtyRegionOffset;
    private final TokenFactory tokenFactory;

    public AntlrTokenScanner(Lexer scanner, TokenFactory tokenFactory) {
        this.scanner = scanner;
        this.tokenFactory = tokenFactory;
    }

    @Override
    public void setRange(IDocument document, int offset, int length) {
        String dirtyRegion;
        try {
            dirtyRegion = document.get(offset, length);
            dirtyRegionOffset = offset;
            scanner.setInputStream(new ANTLRInputStream(dirtyRegion));
        } catch (BadLocationException e) {
            YPlugin.logError(e);
        }
    }

    @Override
    public IToken nextToken() {
        current = scanner.nextToken();
        return tokenFactory.createToken(current);
    }

    @Override
    public int getTokenOffset() {
        return dirtyRegionOffset + current.getStartIndex();
    }

    @Override
    public int getTokenLength() {
        return current.getStopIndex() - current.getStartIndex() + 1;
    }

}
