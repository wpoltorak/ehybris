package com.lambda.plugin.impex.editor;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

public class ImpexHeaderScanner extends RuleBasedScanner {

    public ImpexHeaderScanner(final ColorManager manager) {
        final IRule[] rules = new IRule[3];

        // Add rule for double quotes
        final IToken token = new Token(new TextAttribute(new Color(Display.getCurrent(), ImpexColorConstants.IMPEX_HEADER_DEFAULT), null,
                SWT.BOLD));
        final WordRule wordRule = new WordRule(new KeywordDetector(), Token.UNDEFINED, true);
        wordRule.addWord(ImpexHeaderRule.INSERT, token);
        wordRule.addWord(ImpexHeaderRule.INSERT_UPDATE, token);
        wordRule.addWord(ImpexHeaderRule.UPDATE, token);
        wordRule.addWord(ImpexHeaderRule.REMOVE, token);
        //Add header keyword rule
        rules[0] = wordRule;
        //Add header arguments rule
        rules[1] = new EndOfLineRule(";", new Token(new TextAttribute(
                new Color(Display.getCurrent(), ImpexColorConstants.IMPEX_HEADER_ARG), null, SWT.NONE)));
        // Add generic whitespace rule.
        rules[2] = new WhitespaceRule(new ImpexWhitespaceDetector());

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
