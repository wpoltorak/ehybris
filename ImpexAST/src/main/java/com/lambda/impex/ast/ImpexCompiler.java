package com.lambda.impex.ast;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.lambda.impex.ast.ImpexParser.ImpexContext;
import com.lambda.impex.ast.ImpexProblem.Type;

public class ImpexCompiler {

    private ImpexParseContext context;
    private ImpexContext impex;

    public ImpexCompiler() {
    }

    public void compile(final char[] source) {
        try {
            internalCompile(source);
        } catch (final RecognitionException e) {
            final ImpexProblem error = new ImpexProblem(Type.GeneralSyntaxError);
            error.setText(e.getMessage());
            context.addProblem(error);
            e.printStackTrace();
        }
    }

    protected void internalCompile(final char[] source) throws RecognitionException {
        context = new ImpexParseContext();
        final ImpexLexer lexer = new ImpexLexer(new ANTLRInputStream(source, source.length));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final ImpexParser parser = new ImpexParser(tokens);
        final ImpexParserDefaultListener impexListener = new ImpexParserDefaultListener(context);
        final ImpexParserDefaultErrorListener errorListener = new ImpexParserDefaultErrorListener(context);
        parser.addErrorListener(errorListener);
        impex = parser.impex();

        if (!context.isSyntaxInvalid()) {
            final ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(impexListener, impex);
        }
    }

    public ImpexParseContext getContext() {
        return context;
    }

    public ParseTree getParseTree() {
        return impex;
    }
}
