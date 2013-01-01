package com.lambda.impex.ast;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.RecognitionException;

import com.lambda.impex.ast.ImpexLexer;

public class TestImpexLexer extends ImpexLexer {

    public TestImpexLexer(final CharStream antlrStringStream) {
        super(antlrStringStream);
    }

    @Override
    public void reportError(final RecognitionException e) {
        super.reportError(e);
        throw new IllegalStateException(e);
    }
}
