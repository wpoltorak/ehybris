package com.lambda.impex.ast;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class GrammarTest {
    public static final String S = System.getProperty("line.separator");

    @Test
    public void macros() throws Exception {
        checkGrammars(new File(getClass().getResource("/macro").getFile()));
    }

    @Test
    public void commons() throws Exception {
        checkGrammars(new File(getClass().getResource("/common").getFile()));
    }

    @Test
    public void comments() throws Exception {
        checkGrammars(new File(getClass().getResource("/comment").getFile()));
    }

    @Test
    public void beanshell() throws Exception {
        checkGrammars(new File(getClass().getResource("/beanshell").getFile()));
    }

    @Test
    public void blocks() throws Exception {
        checkGrammars(new File(getClass().getResource("/block").getFile()));
    }

    @Test
    public void headers() throws Exception {
        checkGrammars(new File(getClass().getResource("/header").getFile()));
    }

    @Test
    public void records() throws Exception {
        checkGrammars(new File(getClass().getResource("/record").getFile()));
    }

    @Test
    public void quotes() throws Exception {
        checkGrammars(new File(getClass().getResource("/quotes").getFile()));
    }

    @Test
    public void errorQuotes() throws Exception {
        checkErrorGrammars(new File(getClass().getResource("/errors/quotes").getFile()));
    }

    @Test
    public void errorMacros() throws Exception {
        checkErrorGrammars(new File(getClass().getResource("/errors/macro").getFile()));
    }

    @Test
    public void userRights() throws Exception {
        checkGrammars(new File(getClass().getResource("/userrights").getFile()));
    }

    private void checkGrammars(final File directory) {
        System.out.println("Entering " + directory.getName());
        String errors = S;
        for (final Iterator<File> it = FileUtils.iterateFiles(directory, new String[] { "impex" }, true); it.hasNext();) {
            final File file = it.next();
            try {
                final ImpexParser parser = readGrammarFile(file);
                checkNoSyntaxErrors(parser.impex(), file.getName());
            } catch (final Exception e) {
                errors += "Error parsing '" + file.getName() + "': " + (e.getMessage() == null ? e.toString() : e.getMessage()) + S;
            }
        }
        if (!errors.trim().isEmpty()) {
            System.err.println(errors);
            fail(errors);
        }
    }

    private void checkErrorGrammars(final File directory) {
        System.out.println("Entering " + directory.getName());
        for (final Iterator<File> it = FileUtils.iterateFiles(directory, new String[] { "impex" }, true); it.hasNext();) {
            final File file = it.next();
            try {
                final ImpexParser parser = readGrammarFile(file);
                assertTrue("Incorrect grammar '" + file.getName()
                        + "' was parsed correclty. Expected errors but none was found. Syntax apperas to be correct.",
                        checkSyntaxErrors(parser.impex(), file.getName()));
            } catch (final Exception e) {
                //good!
            }
        }
    }

    private ImpexParser readGrammarFile(final File file) throws IOException {
        System.out.println("Checking " + file.getName());
        final String text = FileUtils.readFileToString(file);
        final ImpexLexer lexer = new ImpexLexer(new ANTLRInputStream(text));
        final ImpexParseContext context = new ImpexParseContext();
        lexer.addErrorListener(new ImpexParserDefaultErrorListener(context, true));
        final CommonTokenStream tokenStream = new CommonTokenStream(lexer);

        //        final TokenStreamRewriter rewriter = new TokenStreamRewriter(tokenStream);
        //        final List<Token> same = new ArrayList<Token>();
        //        Token last = null;
        //        for (final Token token : tokenStream.getTokens()) {
        //            if (last == null) {
        //                last = token;
        //                continue;
        //            }
        //            if (token.getType() == last.getType()) {
        //                same.add(token);
        //            } else if (!same.isEmpty()) {
        //                same.get(0).getCharPositionInLine();
        //                rewriter.
        //            }
        //            last = token;
        //        }
        //AbstractLexerTest.printTokens(tokenStream);
        //        tokenStream.
        final ImpexParser parser = new ImpexParser(tokenStream);
        parser.removeErrorListeners(); // remove ConsoleErrorListener
        parser.addErrorListener(new ImpexParserDefaultErrorListener(context, true));
        return parser;
    }

    private boolean checkSyntaxErrors(final ParseTree tree, final String filename) {
        for (int i = 0; i < tree.getChildCount(); i++) {
            final ParseTree child = tree.getChild(i);
            if (child instanceof ErrorNode || checkSyntaxErrors(child, filename)) {
                return true;
            }
        }
        return false;
    }

    private void checkNoSyntaxErrors(final ParseTree tree, final String filename) {
        for (int i = 0; i < tree.getChildCount(); i++) {
            final ParseTree child = tree.getChild(i);
            assertFalse(filename + ": found Error node with text '" + child.getText() + "'", child instanceof ErrorNode);
            checkNoSyntaxErrors(child, filename);
        }
    }
}
