package output;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.Iterator;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.DOTTreeGenerator;
import org.antlr.runtime.tree.Tree;
import org.antlr.stringtemplate.StringTemplate;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

public class GrammarTest {
    public static final String S = System.getProperty("line.separator");

    @Test
    public void macros() throws Exception {
        final File commentDir = new File(getClass().getResource("/macro").getFile());
        assertTrue(commentDir.isDirectory());
        checkGrammar(commentDir);
    }

    @Test
    public void commons() throws Exception {
        final File commentDir = new File(getClass().getResource("/common").getFile());
        assertTrue(commentDir.isDirectory());
        checkGrammar(commentDir);
    }

    @Test
    public void comments() throws Exception {
        final File commentDir = new File(getClass().getResource("/comment").getFile());
        assertTrue(commentDir.isDirectory());
        checkGrammar(commentDir);
    }

    @Test
    public void commentNodeContainsNoHashPrefix() throws Exception {
        final String impex = IOUtils.toString(getClass().getResourceAsStream("/comment/comment-singleline.impex"));
        final ImpexLexer lexer = new ImpexLexer(new ANTLRStringStream(impex));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final ImpexParser parser = new ImpexParser(tokens);
        final CommonTree tree = (CommonTree) parser.impex().getTree();
        final Tree comments = tree.getFirstChildWithType(ImpexParser.COMMENTS);
        assertEquals(1, comments.getChildCount());
        assertFalse(comments.getChild(0).getText().startsWith("#"));
    }

    @Test
    public void commentNodeContainsWhitespaceCharacters() throws Exception {
        final String impex = IOUtils.toString(getClass().getResourceAsStream("/comment/comment-singleline.impex"));
        final ImpexLexer lexer = new ImpexLexer(new ANTLRStringStream(impex));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final ImpexParser parser = new ImpexParser(tokens);
        final CommonTree tree = (CommonTree) parser.impex().getTree();
        final Tree comments = tree.getFirstChildWithType(ImpexParser.COMMENTS);
        assertEquals(1, comments.getChildCount());
        assertTrue(comments.getChild(0).getText().contains(" "));
        assertTrue(comments.getChild(0).getText().contains("\t"));
    }

    @Test
    public void xx() throws Exception {
        final String impex = IOUtils.toString(getClass().getResourceAsStream("/user-groups.impex"));
        final ImpexLexer lexer = new ImpexLexer(new ANTLRStringStream(impex));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        tokens.fill();
        int n = 1;
        for (final Object o : tokens.getTokens()) {
            final CommonToken token = (CommonToken) o;
            System.out.println("token(" + n + ") = " + token.getText().replace("\r", "\\r").replace("\n", "\\n"));
            n++;
        }
        System.out.println("__________________________");
        final ImpexParser parser = new ImpexParser(tokens);
        //        parser.parse().getTree();
        final CommonTree tree = (CommonTree) parser.impex().getTree();
        final DOTTreeGenerator gen = new DOTTreeGenerator();
        final StringTemplate st = gen.toDOT(tree);
        System.out.println("__________________________");
        System.out.println(st);
        //        
        //        final Tree comments = tree.getFirstChildWithType(ImpexParser.COMMENTS);
        //        assertEquals(1, comments.getChildCount());
        //        assertTrue(comments.getChild(0).getText().contains(" "));
        //        assertTrue(comments.getChild(0).getText().contains("\t"));
    }

    private void checkGrammar(final File directory) {
        try {
            for (final Iterator<File> it = FileUtils.iterateFiles(directory, new String[] { "impex" }, true); it.hasNext();) {
                final String impex = FileUtils.readFileToString(it.next());
                final ImpexLexer lexer = new ImpexLexer(new ANTLRStringStream(impex)) {

                    @Override
                    public void reportError(final RecognitionException e) {
                        super.reportError(e);
                        throw new IllegalStateException(e);
                    }
                };
                final CommonTokenStream tokens = new CommonTokenStream(lexer);
                final ImpexParser parser = new ImpexParser(tokens) {
                    @Override
                    public void emitErrorMessage(final String msg) {
                        super.emitErrorMessage(msg);
                        throw new IllegalStateException(msg);
                    }
                };
                parser.impex().getTree();
            }
        } catch (final Exception e) {
            fail(e.getMessage());
        }
        //             create the parser  
        //            final impexParser parser = new impexParser(tokens);
        //            final CommonTree tree = (CommonTree) parser.impex().getTree();
        //            final DOTTreeGenerator gen = new DOTTreeGenerator();
        //            final StringTemplate st = gen.toDOT(tree);
        //            System.out.println(st);

        //
        //        // invoke the entry point of our grammar  
        //        final ImpexParser.impex_return data = parser.impex();
        //
        //        // display the contents of the CSV source  
        //        for (int r = 0; r < data.size(); r++) {
        //            final List<String> row = data.get(r);
        //            for (int c = 0; c < row.size(); c++) {
        //                System.out.println("(row=" + (r + 1) + ",col=" + (c + 1) + ") = " + row.get(c));
        //            }
        //        }
    }
}
