package com.lambda.plugin.impex.antlr;

import org.antlr.v4.runtime.Lexer;

import com.lambda.impex.ast.ImpexLexer;

public class TokenSourceProvider {

    public Lexer get() {
        ImpexLexer lexer = new ImpexLexer(null);
        // lexer.removeErrorListeners();
        // lexer.addErrorListener(new ImpexParserDefaultErrorListener(context));
        return lexer;

    }
}
