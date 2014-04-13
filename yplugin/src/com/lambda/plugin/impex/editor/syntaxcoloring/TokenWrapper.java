package com.lambda.plugin.impex.editor.syntaxcoloring;

import org.antlr.v4.runtime.Token;
import org.eclipse.jface.text.rules.IToken;

import com.lambda.impex.ast.ImpexLexer;

public class TokenWrapper implements IToken {

    private final int length;
    private final int offset;
    private final Token token;
    private Object data;

    public TokenWrapper(Token token, Object data) {
        this.token = token;
        this.length = token.getStopIndex() - token.getStartIndex() + 1;
        this.offset = token.getStartIndex();
    }

    @Override
    public boolean isUndefined() {
        return false;
    }

    @Override
    public boolean isWhitespace() {
        return token.getType() == ImpexLexer.Ws || token.getType() == ImpexLexer.Lb;
    }

    @Override
    public boolean isEOF() {
        return token.getType() == ImpexLexer.EOF;
    }

    @Override
    public boolean isOther() {
        return !isWhitespace() && !isUndefined() && !isEOF();
    }

    @Override
    public Object getData() {
        return data;
    }

    public int getLength() {
        return length;
    }

    public int getOffset() {
        return offset;
    }
}
