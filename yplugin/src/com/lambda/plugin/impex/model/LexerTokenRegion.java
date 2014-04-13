package com.lambda.plugin.impex.model;

import org.eclipse.jface.text.Region;

public class LexerTokenRegion extends Region implements ILexerTokenRegion {

    private final int tokenType;

    public LexerTokenRegion(int offset, int length, int tokenType) {
        super(offset, length);
        this.tokenType = tokenType;
    }

    @Override
    public int getTokenType() {
        return tokenType;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ILexerTokenRegion) {
            ILexerTokenRegion r = (ILexerTokenRegion) o;
            return r.getTokenType() == tokenType && super.equals(o);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() | (tokenType << 8);
    }

    @Override
    public String toString() {
        return super.toString() + ", type: " + tokenType; //$NON-NLS-2$;
    }

}
