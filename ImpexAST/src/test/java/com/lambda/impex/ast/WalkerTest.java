package com.lambda.impex.ast;

import static org.junit.Assert.fail;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.lambda.impex.ast.nodes.IImpexNode;

public class WalkerTest {

    @Test
    public void walkerDoesNotReportException() throws Exception {
        try {
            final char[] impexData = IOUtils.toCharArray(getClass().getResourceAsStream("/walker/user-groups.impex"));
            final ImpexContext context = new ImpexContext();
            final ImpexLexer lexer = new ImpexLexer(context, new ANTLRStringStream(impexData, impexData.length));
            final CommonTokenStream tokens = new CommonTokenStream(lexer);
            final ImpexParser parser = new ImpexParser(context, tokens);
            final CommonTree tree = (CommonTree) parser.impex().getTree();
            final CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
            final ImpexTreeWalker walker = new ImpexTreeWalker(nodes);
            final IImpexNode impex = walker.walk();
            impex.evaluate(context);
        } catch (final RecognitionException e) {
            fail(e.getMessage());
        }
    }
}
