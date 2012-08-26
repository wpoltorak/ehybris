package com.lambda.plugin.impex.editors;

import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

public class ImpexHeaderRule extends EndOfLineRule {

    static final String INSERT = "INSERT";
    static final String INSERT_UPDATE = "INSERT_UPDATE";
    static final String UPDATE = "UPDATE";
    static final String REMOVE = "REMOVE";

    public ImpexHeaderRule(final String impexMode, final IToken token) {
        super(impexMode, token);
    }

    /*
     * @see IPredicateRule#evaluate(ICharacterScanner, boolean)
     * 
     * @since 2.0
     */
    @Override
    public IToken evaluate(final ICharacterScanner scanner, final boolean resume) {
        if (fColumn == UNDEFINED) {
            return doEvaluate(scanner, resume);
        }

        final int c = scanner.read();
        scanner.unread();
        if (Character.toUpperCase(c) == fStartSequence[0]) {
            return (fColumn == scanner.getColumn() ? doEvaluate(scanner, resume) : Token.UNDEFINED);
        }
        return Token.UNDEFINED;
    }

    @Override
    protected IToken doEvaluate(final ICharacterScanner scanner, final boolean resume) {

        if (resume) {

            if (endSequenceDetected(scanner)) {
                return fToken;
            }

        } else {

            final int c = scanner.read();
            if (Character.toUpperCase(c) == fStartSequence[0]) {
                if (sequenceDetected(scanner, fStartSequence, fBreaksOnEOF)) {
                    if (endSequenceDetected(scanner)) {
                        return fToken;
                    }
                }
            }
        }

        scanner.unread();
        return Token.UNDEFINED;
    }

    @Override
    protected boolean sequenceDetected(final ICharacterScanner scanner, final char[] sequence, final boolean eofAllowed) {
        for (int i = 1; i < sequence.length; i++) {
            final int c = scanner.read();
            if (c == ICharacterScanner.EOF && eofAllowed) {
                return true;
            } else if (Character.toUpperCase(c) != sequence[i]) {
                // Non-matching character detected, rewind the scanner back to the start.
                // Do not unread the first character.
                scanner.unread();
                for (int j = i - 1; j > 0; j--) {
                    scanner.unread();
                }
                return false;
            }
        }

        return true;
    }

}
