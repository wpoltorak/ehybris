package com.lambda.plugin.impex.model;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.CommonTokenStream;
import org.eclipse.jface.text.IDocument;

public class ImpexModel implements IImpexModel {

    private final IDocument document;

    public ImpexModel(final IDocument document) {
        this.document = document;
    }

    public void reconcile() {
        final String source = document.get();
        // create an instance of the lexer
        final impexLexer lexer = new impexLexer(new ANTLRStringStream(source));
        // wrap a token-stream around the lexer
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();
        // traverse the tokens and print them to see if the correct tokens are created
        System.out.println("Tokenizing " + (lexer.failed() ? "failed" : "succeeded"));
        System.out.println("Tokens:");
        int n = 1;
        for (final Object o : tokens.getTokens()) {
            final CommonToken token = (CommonToken) o;
            System.out.println("token(" + n++ + ") = " + token.getText().replace("\n", "\\n"));
        }
    }
}
