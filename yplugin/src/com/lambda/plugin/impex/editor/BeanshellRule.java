package com.lambda.plugin.impex.editor;

import org.eclipse.jface.text.rules.ICharacterScanner;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;

public class BeanshellRule extends MultiLineRule {

    private int numberOfConsecutiveEndQuotes = 0;

    public BeanshellRule(final IToken token) {
        super("\"#%", "\"", token);
    }

    @Override
    protected boolean sequenceDetected(ICharacterScanner scanner, char[] sequence, boolean eofAllowed) {
        if (sequence.length == 1 && sequence[0] == '"') {
            try {
                int ch = scanner.read();
                if (ch != '"') {
                    boolean detected = numberOfConsecutiveEndQuotes % 2 == 0;
                    numberOfConsecutiveEndQuotes = 0;
                    return detected;
                }
                numberOfConsecutiveEndQuotes++;
                return false;
            } finally {
                scanner.unread();
            }
        }

        return super.sequenceDetected(scanner, sequence, eofAllowed);
    }
}
