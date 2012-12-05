package output;

import static org.junit.Assert.fail;

import java.io.File;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.apache.commons.io.FileUtils;

import output.tree.ImpexNode;

public class WalkerTest {

    private void walk(final File file) {
        try {
            final String impex = FileUtils.readFileToString(file);
            final ImpexLexer lexer = new ImpexLexer(new ImpexANTLRStringStream(impex)) {

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
            final ImpexTreeWalker walker = new ImpexTreeWalker(nodes);
            final ImpexNode node = walker.walk();

        } catch (final Exception e) {
            fail("Error parsing '" + file.getName() + "': " + e.getMessage() == null ? e.toString() : e.getMessage());
        }
    }
}
