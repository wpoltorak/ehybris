package com.lambda.plugin.impex.editor;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;

public class ImpexMacroScanner extends RuleBasedScanner {

    public ImpexMacroScanner(final ColorManager colorManager) {
        setDefaultReturnToken(new Token(new TextAttribute(colorManager.getColor(ImpexColorConstants.IMPEX_MACRO))));

        final IRule[] rules = new IRule[1];
        // Add header arguments rule
        // rules[0] = new SingleLineRule("$", "=", new Token(new TextAttribute(
        // colorManager.getColor(ImpexColorConstants.IMPEX_MACRO_ASS), null, SWT.NONE)));
        // Add generic whitespace rule.
        rules[1] = new WhitespaceRule(new ImpexWhitespaceDetector());

        setRules(rules);
    }
}
