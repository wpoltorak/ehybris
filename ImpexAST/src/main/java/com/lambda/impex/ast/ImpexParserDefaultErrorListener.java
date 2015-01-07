package com.lambda.impex.ast;

import java.util.BitSet;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

public class ImpexParserDefaultErrorListener extends BaseErrorListener {

    private final ImpexModel context;
    private final boolean throwExceptions;

    public ImpexParserDefaultErrorListener(final ImpexModel context) {
        this(context, false);
    }

    public ImpexParserDefaultErrorListener(final ImpexModel context, final boolean throwExceptions) {
        this.context = context;
        this.throwExceptions = throwExceptions;
    }

    @Override
    public void reportAmbiguity(final Parser recognizer, final DFA dfa, final int startIndex, final int stopIndex, final boolean exact,
            final BitSet ambigAlts, final ATNConfigSet configs) {
        System.out.println();
    }

    @Override
    public void reportAttemptingFullContext(final Parser recognizer, final DFA dfa, final int startIndex, final int stopIndex,
            final BitSet conflictingAlts, final ATNConfigSet configs) {
        System.out.println();
    }

    @Override
    public void reportContextSensitivity(final Parser recognizer, final DFA dfa, final int startIndex, final int stopIndex,
            final int prediction, final ATNConfigSet configs) {
        System.out.println();
    }

    @Override
    public void syntaxError(final Recognizer<?, ?> recognizer, final Object offendingSymbol, final int line, final int charPositionInLine,
            final String msg, final RecognitionException e) {
        //Lexer
        if (recognizer instanceof Lexer) {
            final int startIndex = ((Lexer) recognizer).getCharIndex();
            context.syntaxProblem(line, startIndex, msg, e);
            //Parser
        } else if (offendingSymbol instanceof Token) {
            context.syntaxProblem(line, (Token) offendingSymbol, msg, e);
        }
        if (throwExceptions) {
            if (e == null) {
                throw new IllegalStateException("Syntax error. " + msg);
            }
            throw new IllegalStateException("Syntax error: " + msg, e);
        }
    }
}
