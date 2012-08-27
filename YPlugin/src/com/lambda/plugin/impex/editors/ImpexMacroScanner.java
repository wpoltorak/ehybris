package com.lambda.plugin.impex.editors;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

public class ImpexMacroScanner extends RuleBasedScanner {

    public ImpexMacroScanner(final ColorManager manager) {
        final IRule[] rules = new IRule[2];

        //Add header arguments rule
        rules[0] = new SingleLineRule("$", "=", new Token(new TextAttribute(new Color(Display.getCurrent(),
                ImpexColorConstants.IMPEX_MACRO_ASS), null, SWT.NONE)));
        // Add generic whitespace rule.
        rules[1] = new WhitespaceRule(new ImpexWhitespaceDetector());

        setRules(rules);
    }

    class KeywordDetector implements IWordDetector {
        public boolean isWordStart(final char c) {
            return Character.isLetter(c);
        }

        public boolean isWordPart(final char c) {
            return c == '_' || Character.isLetter(c);
        }
    }

}
