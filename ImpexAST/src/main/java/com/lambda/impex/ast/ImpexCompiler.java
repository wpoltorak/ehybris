package com.lambda.impex.ast;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;

import com.lambda.impex.ast.ImpexError.Type;
import com.lambda.impex.ast.nodes.ImpexASTNode;

public class ImpexCompiler {

    private ImpexContext context;
    private ImpexVisitor visitor;

    public ImpexCompiler() {
    }

    public void compile(final char[] source) {
        try {
            internalCompile(source);
        } catch (final RecognitionException e) {
            final ImpexError error = new ImpexError(Type.GeneralSyntaxError);
            error.setText(e.getMessage());
            context.addError(error);
            e.printStackTrace();
        }
    }

    protected void internalCompile(final char[] source) throws RecognitionException {
        if (visitor == null) {
            throw new IllegalStateException("Impex visitor has not been set");
        }

        context = new ImpexContext();
        final ImpexLexer lexer = new ImpexLexer(context, new ANTLRStringStream(source, source.length));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final ImpexParser parser = new ImpexParser(context, tokens);

        final CommonTree tree = (CommonTree) parser.impex().getTree();
        visitor.prepare(context);
        if (parser.getNumberOfSyntaxErrors() <= 0) {
            final CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
            final ImpexTreeWalker walker = new ImpexTreeWalker(nodes);
            final ImpexASTNode impex = walker.walk(context);
            impex.accept(visitor);
        }
    }

    public ImpexContext getContext() {
        return context;
    }

    public void setVisitor(final ImpexVisitor visitor) {
        this.visitor = visitor;
    }
}
