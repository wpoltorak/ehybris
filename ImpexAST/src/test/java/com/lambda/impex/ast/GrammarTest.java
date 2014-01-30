package com.lambda.impex.ast;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.io.File;
import java.util.BitSet;
import java.util.Iterator;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.DiagnosticErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class GrammarTest {
    public static final String S = System.getProperty("line.separator");

    @Test
    public void macros() throws Exception {
        checkGrammar(new File(getClass().getResource("/macro").getFile()));
    }

    @Test
    public void commons() throws Exception {
        checkGrammar(new File(getClass().getResource("/common").getFile()));
    }

    @Test
    public void comments() throws Exception {
        checkGrammar(new File(getClass().getResource("/comment").getFile()));
    }

    @Test
    public void beanshell() throws Exception {
        checkGrammar(new File(getClass().getResource("/beanshell").getFile()));
    }

    @Test
    public void blocks() throws Exception {
        checkGrammar(new File(getClass().getResource("/block").getFile()));
    }

    @Test
    public void headers() throws Exception {
        checkGrammar(new File(getClass().getResource("/header").getFile()));
    }

    @Test
    public void records() throws Exception {
        checkGrammar(new File(getClass().getResource("/record").getFile()));
    }

    @Test
    public void userRights() throws Exception {
        checkGrammar(new File(getClass().getResource("/userrights").getFile()));
    }

    private void checkGrammar(final File directory) {
        String errors = S;
        for (final Iterator<File> it = FileUtils.iterateFiles(directory, new String[] { "impex" }, true); it.hasNext();) {
            final File file = it.next();
            try {
                final String fileName = FileUtils.readFileToString(file);
                final ImpexLexer lexer = new ImpexLexer(new ANTLRInputStream(fileName));
                final CommonTokenStream tokenStream = new CommonTokenStream(lexer);
                final ImpexParser parser = new ImpexParser(tokenStream);
                parser.addErrorListener(new DiagnosticErrorListener() {

                    @Override
                    public void syntaxError(final Recognizer<?, ?> recognizer, final Object offendingSymbol, final int line,
                            final int charPositionInLine, final String msg, final RecognitionException e) {
                        super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);
                        throw new IllegalStateException(file.getName() + ": " + msg, e);
                    }

                    @Override
                    public void reportContextSensitivity(final Parser recognizer, final DFA dfa, final int startIndex, final int stopIndex,
                            final int prediction, final ATNConfigSet configs) {
                        super.reportContextSensitivity(recognizer, dfa, startIndex, stopIndex, prediction, configs);
                        throw new IllegalStateException(file.getName() + ": Context sensitivity error between " + startIndex + " and "
                                + stopIndex + ". Prediction " + prediction);
                    }

                    @Override
                    public void reportAttemptingFullContext(final Parser recognizer, final DFA dfa, final int startIndex,
                            final int stopIndex, final BitSet conflictingAlts, final ATNConfigSet configs) {
                        super.reportAttemptingFullContext(recognizer, dfa, startIndex, stopIndex, conflictingAlts, configs);
                        //                        throw new IllegalStateException(file.getName() + ": Attempting full context error between " + startIndex + " and "
                        //                                + stopIndex);

                    }

                    @Override
                    public void reportAmbiguity(final Parser recognizer, final DFA dfa, final int startIndex, final int stopIndex,
                            final boolean exact, final BitSet ambigAlts, final ATNConfigSet configs) {
                        throw new IllegalStateException(file.getName() + ": Ambiguity error between " + startIndex + " and " + stopIndex);
                    }
                });
                checkSyntaxErrors(parser.impex());
            } catch (final Exception e) {
                errors += "Error parsing '" + file.getName() + "': " + e.getMessage() == null ? e.toString() : e.getMessage() + S;
            }

        }

        if (!errors.trim().isEmpty()) {
            System.err.println(errors);
            fail(errors);
        }
    }

    private void checkSyntaxErrors(final ParseTree tree) {
        for (int i = 0; i < tree.getChildCount(); i++) {
            final ParseTree child = tree.getChild(i);
            assertFalse(child instanceof ErrorNode);
            checkSyntaxErrors(child);
        }
    }
}
