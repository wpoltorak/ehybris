package com.lambda.plugin.impex.editor;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;

public class ImpexScanner extends RuleBasedScanner {

    public ImpexScanner(final ColorManager colorManager) {
        Token defaultToken = new Token(new TextAttribute(colorManager.getColor(ImpexColorConstants.DEFAULT)));
        setDefaultReturnToken(defaultToken);

        final IToken string = new Token(new TextAttribute(colorManager.getColor(ImpexColorConstants.IMPEX_MACRO)));

        final IRule[] rules = new IRule[1];
        // Add rule for processing instructions
        // rules[0] = new EndOfLineRule("#", comment);
        // Add string
        // rules[1] = new SingleLineRule("\"", "\"", string, '"');
        // Add generic whitespace rule.
        rules[0] = new WhitespaceRule(new ImpexWhitespaceDetector());
        setRules(rules);
    }
}
