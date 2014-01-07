package com.lambda.impex.ast;

import java.io.File;
import java.util.BitSet;
import java.util.List;

import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.apache.commons.io.FileUtils;

public abstract class AbstractLexerTest {

    private ImpexContext context;

    protected List<Token> init(final String name) throws Exception {
        final File file = new File(getClass().getResource(name).getFile());
        if (!file.exists()) {
            throw new IllegalArgumentException("Unknown file name: " + name);
        }
        final String impex = FileUtils.readFileToString(file);
        context = new com.lambda.impex.ast.ImpexContext();
        final ImpexLexer lexer = new ImpexLexer(context, new ANTLRInputStream(impex));
        lexer.addErrorListener(new ANTLRErrorListener() {

            @Override
            public void syntaxError(final Recognizer<?, ?> recognizer, final Object offendingSymbol, final int line,
                    final int charPositionInLine, final String msg, final RecognitionException e) {
                throw new IllegalStateException(msg, e);
            }

            @Override
            public void reportContextSensitivity(final Parser recognizer, final DFA dfa, final int startIndex, final int stopIndex,
                    final int prediction, final ATNConfigSet configs) {
                throw new IllegalStateException("Context sensitivity error between " + startIndex + " and " + stopIndex + ". Prediction "
                        + prediction);
            }

            @Override
            public void reportAttemptingFullContext(final Parser recognizer, final DFA dfa, final int startIndex, final int stopIndex,
                    final BitSet conflictingAlts, final ATNConfigSet configs) {
                throw new IllegalStateException("Attempting full context error between " + startIndex + " and " + stopIndex);
            }

            @Override
            public void reportAmbiguity(final Parser recognizer, final DFA dfa, final int startIndex, final int stopIndex,
                    final boolean exact, final BitSet ambigAlts, final ATNConfigSet configs) {
                throw new IllegalStateException("Ambiguity error between " + startIndex + " and " + stopIndex);
            }
        });
        final CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        final List<Token> tokens = tokenStream.get(0, tokenStream.getNumberOfOnChannelTokens());
        return tokens;
    }
}
