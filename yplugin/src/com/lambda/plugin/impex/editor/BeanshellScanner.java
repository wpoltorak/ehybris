package com.lambda.plugin.impex.editor;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;

public class BeanshellScanner extends RuleBasedScanner {

    public BeanshellScanner(final ColorManager manager) {
        final IToken beanshell = new Token(new TextAttribute(manager.getColor(ImpexColorConstants.PROC_INSTR)));
        final IRule[] rules = new IRule[3];
        // Add rule for multiple line beanshell script
        rules[0] = new BeanshellRule(beanshell);
        // Add rule for single line beanshell script
        rules[1] = new EndOfLineRule("#%", beanshell);
        // Add generic whitespace rule.
        rules[2] = new WhitespaceRule(new ImpexWhitespaceDetector());

        setRules(rules);
    }
}
