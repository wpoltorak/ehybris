package com.lambda.impex.ast;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

import com.lambda.impex.ast.ImpexProblem.Type;
import com.lambda.impex.ast.nodes.ImpexASTNode;

public class ImpexCompiler {

    private ImpexContext context;
    private ImpexVisitor visitor;
    private CommonTree ast;
    private ImpexASTNode impexASTNode;

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
        if (visitor == null) {
            throw new IllegalStateException("Impex visitor has not been set");
        }

        context = new ImpexContext();
        //        final ImpexLexer lexer = new ImpexLexer(context, new ANTLRStringStream(source, source.length));
        //        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        //        final ImpexParser parser = new ImpexParser(context, tokens);
        //
        //        ast = (CommonTree) parser.impex().getTree();
        //        visitor.prepare(context);
        //        if (parser.getNumberOfSyntaxErrors() <= 0) {
        //            final ImpexTreeWalker walker = new ImpexTreeWalker(context, ast);
        //            impexASTNode = walker.walk();
        //            impexASTNode.accept(visitor);
        //        }
    }

    public ImpexContext getContext() {
        return context;
    }

    public CommonTree getAST() {
        return ast;
    }

    public ImpexASTNode getImpexASTNode() {
        return impexASTNode;
    }

    public void setVisitor(final ImpexVisitor visitor) {
        this.visitor = visitor;
    }
}
