package com.lambda.impex.ast;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;

import com.lambda.impex.ast.ImpexError.Type;
import com.lambda.impex.ast.nodes.IImpexNode;

public class ImpexCompiler {

    private ImpexContext context;

    public ImpexCompiler() {
    }

    public void compile(final char[] source) {
        context = new ImpexContext();
        final ImpexLexer lexer = new ImpexLexer(context, new ANTLRStringStream(source, source.length));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final ImpexParser parser = new ImpexParser(context, tokens);
        try {
            final CommonTree tree = (CommonTree) parser.impex().getTree();
            final CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
            final ImpexTreeWalker walker = new ImpexTreeWalker(nodes);
            final IImpexNode impex = walker.walk();
            impex.evaluate(context);
        } catch (final RecognitionException e) {
            context.addError(new ImpexError(Type.ParserSyntaxError));
        }
    }

    public ImpexContext getContext() {
        return context;
    }

}
