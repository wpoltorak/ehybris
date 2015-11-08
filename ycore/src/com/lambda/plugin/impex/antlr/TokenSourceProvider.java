package com.lambda.plugin.impex.antlr;

import com.lambda.impex.ast.ImpexLexer;

public class TokenSourceProvider {

    public ImpexLexer get() {
        ImpexLexer lexer = new ImpexLexer(null);
        // lexer.removeErrorListeners();
        // lexer.addErrorListener(new ImpexParserDefaultErrorListener(context));
        return lexer;

    }
}
