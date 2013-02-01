package com.lambda.plugin.impex.editor;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.swt.graphics.Color;

public class CommentScanner extends RuleBasedScanner {

    public CommentScanner(final ColorManager colorManager) {
        Color defaultColor = colorManager.getColor(ImpexColorConstants.COMMENT);
        Token defaultToken = new Token(new TextAttribute(defaultColor));
        setDefaultReturnToken(defaultToken);

        final IRule[] rules = new IRule[1];
        // Add rule for multiple line beanshell script
        // rules[0] = new BeanshellRule(beanshell);
        // // Add rule for single line beanshell script
        // rules[1] = new EndOfLineRule("#%", beanshell);
        // Add generic whitespace rule.
        rules[0] = new WhitespaceRule(new ImpexWhitespaceDetector(), defaultToken);

        setRules(rules);
    }
}
