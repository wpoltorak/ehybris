package output;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.Iterator;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.DOTTreeGenerator;
import org.antlr.stringtemplate.StringTemplate;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

public class GrammarTest {
    public static final String S = System.getProperty("line.separator");

    @Test
    public void macros() throws Exception {
        final File dir = new File(getClass().getResource("/macro").getFile());
        assertTrue(dir.isDirectory());
        checkGrammar(dir);
    }

    @Test
    public void commons() throws Exception {
        final File dir = new File(getClass().getResource("/common").getFile());
        assertTrue(dir.isDirectory());
        checkGrammar(dir);
    }

    @Test
    public void comments() throws Exception {
        final File dir = new File(getClass().getResource("/comment").getFile());
        assertTrue(dir.isDirectory());
        checkGrammar(dir);
    }

    @Test
    public void blocks() throws Exception {
        final File dir = new File(getClass().getResource("/block").getFile());
        assertTrue(dir.isDirectory());
        checkGrammar(dir);
    }

    //    @Test
    //    public void commentNodeContainsNoHashPrefix() throws Exception {
    //        final String impex = IOUtils.toString(getClass().getResourceAsStream("/comment/comment-singleline.impex"));
    //        final ImpexLexer lexer = new ImpexLexer(new ANTLRStringStream(impex));
    //        final CommonTokenStream tokens = new CommonTokenStream(lexer);
    //        final ImpexParser parser = new ImpexParser(tokens);
    //        final CommonTree tree = (CommonTree) parser.impex().getTree();
    //        final Tree comments = tree.getFirstChildWithType(ImpexParser.COMMENTS);
    //        assertEquals(1, comments.getChildCount());
    //        assertFalse(comments.getChild(0).getText().startsWith("#"));
    //    }

    //    @Test
    //    public void commentNodeContainsWhitespaceCharacters() throws Exception {
    //        final String impex = IOUtils.toString(getClass().getResourceAsStream("/comment/comment-singleline.impex"));
    //        final ImpexLexer lexer = new ImpexLexer(new ANTLRStringStream(impex));
    //        final CommonTokenStream tokens = new CommonTokenStream(lexer);
    //        final ImpexParser parser = new ImpexParser(tokens);
    //        final CommonTree tree = (CommonTree) parser.impex().getTree();
    //        final Tree comments = tree.getFirstChildWithType(ImpexParser.COMMENTS);
    //        assertEquals(1, comments.getChildCount());
    //        assertTrue(comments.getChild(0).getText().contains(" "));
    //        assertTrue(comments.getChild(0).getText().contains("\t"));
    //    }

    @Test
    public void xx() throws Exception {
        final char[] impex = IOUtils.toCharArray(getClass().getResourceAsStream("/user-groups.impex"));
        final ImpexLexer lexer = new ImpexLexer(new ImpexANTLRStringStream(impex, impex.length));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        printTokens(tokens);
        System.out.println("__________________________");
        //        new ImpexParser(tokens).parse().getTree();
        //        System.out.println("__________________________");
        final CommonTree tree = (CommonTree) new ImpexParser(tokens).impex().getTree();
        final DOTTreeGenerator gen = new DOTTreeGenerator();
        final StringTemplate st = gen.toDOT(tree);
        System.out.println(st);
        //
        // final Tree comments = tree.getFirstChildWithType(ImpexParser.COMMENTS);
        // assertEquals(1, comments.getChildCount());
        // assertTrue(comments.getChild(0).getText().contains(" "));
        // assertTrue(comments.getChild(0).getText().contains("\t"));
    }

    @Test
    public void yy() throws Exception {
        final String impex = IOUtils.toString(getClass().getResourceAsStream("/user-groups.impex"));
        final ImpexLexer lexer = new ImpexLexer(new ImpexANTLRStringStream(impex));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        //printTokens(tokens);
        System.out.println("__________________________");
        final ImpexParser parser = new ImpexParser(tokens);
        parser.parse().getTree();
    }

    private void checkGrammar(final File directory) {
        String errors = "";
        for (final Iterator<File> it = FileUtils.iterateFiles(directory, new String[] { "impex" }, true); it.hasNext();) {
            final File file = it.next();
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
                printTokens(tokens);

                final ImpexParser parser = new ImpexParser(tokens) {
                    @Override
                    public void emitErrorMessage(final String msg) {
                        super.emitErrorMessage(msg);
                        throw new IllegalStateException("Error parsing '" + file.getName() + "': " + msg);
                    }
                };
                parser.impex().getTree();
            } catch (final Exception e) {
                errors += "Error parsing '" + file.getName() + "': " + e.getMessage() == null ? e.toString() : e.getMessage() + "\n";
            }

        }

        if (!errors.isEmpty()) {
            System.err.println(errors);
            fail(errors);
        }
        // create the parser
        // final impexParser parser = new impexParser(tokens);
        // final CommonTree tree = (CommonTree) parser.impex().getTree();
        // final DOTTreeGenerator gen = new DOTTreeGenerator();
        // final StringTemplate st = gen.toDOT(tree);
        // System.out.println(st);

        //
        // // invoke the entry point of our grammar
        // final ImpexParser.impex_return data = parser.impex();
        //
        // // display the contents of the CSV source
        // for (int r = 0; r < data.size(); r++) {
        // final List<String> row = data.get(r);
        // for (int c = 0; c < row.size(); c++) {
        // System.out.println("(row=" + (r + 1) + ",col=" + (c + 1) + ") = " + row.get(c));
        // }
        // }
    }

    private void printTokens(final CommonTokenStream tokens) {
        int n = 1;
        for (final Object o : tokens.getTokens()) {
            final CommonToken token = (CommonToken) o;
            System.out.println("token(" + n + ") = " + token.getText().replace("\r", "\\r").replace("\n", "\\n"));
            n++;
        }
    }
}
