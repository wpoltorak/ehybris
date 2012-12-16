package output;

import static org.junit.Assert.fail;

import java.io.File;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import output.tree.IImpexNode;

public class WalkerTest {

    @Test
    public void testName() throws Exception {
        walk();
    }

    private void walk(final File file) {
        try {
            final ImpexLexer lexer = new ImpexLexer(new ImpexANTLRStringStream(FileUtils.readFileToString(file))) {

                @Override
                public void reportError(final RecognitionException e) {
                    super.reportError(e);
                    throw new IllegalStateException("Error parsing '" + file.getName() + "': " + e);
                }
            };
            final CommonTokenStream tokens = new CommonTokenStream(lexer);

            final ImpexParser parser = new ImpexParser(tokens) {
                @Override
                public void emitErrorMessage(final String msg) {
                    super.emitErrorMessage(msg);
                    throw new IllegalStateException("Error parsing '" + file.getName() + "': " + msg);
                }
            };
            final CommonTree tree = (CommonTree) parser.impex().getTree();
            final CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
            final ImpexContext context = new ImpexContext(parser.getMacros(), parser.getDocumentIDs());
            final ImpexTreeWalker walker = new ImpexTreeWalker(nodes);
            final IImpexNode impex = walker.walk();
            impex.evaluate(context);

        } catch (final Exception e) {
            fail("Error parsing '" + file.getName() + "': " + e.getMessage() == null ? e.toString() : e.getMessage());
        }
    }

    private void walk() throws Exception {
        final char[] impexData = IOUtils.toCharArray(getClass().getResourceAsStream("/user-groups.impex"));
        final ImpexLexer lexer = new ImpexLexer(new ImpexANTLRStringStream(impexData, impexData.length));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final ImpexParser parser = new ImpexParser(tokens);
        final CommonTree tree = (CommonTree) parser.impex().getTree();
        final CommonTreeNodeStream nodes = new CommonTreeNodeStream(tree);
        final ImpexContext context = new ImpexContext(parser.getMacros(), parser.getDocumentIDs());
        final ImpexTreeWalker walker = new ImpexTreeWalker(nodes);
        final IImpexNode impex = walker.walk();
        impex.evaluate(context);
    }
}
