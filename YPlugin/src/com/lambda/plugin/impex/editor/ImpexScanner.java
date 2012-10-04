package com.lambda.plugin.impex.editor;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;

public class ImpexScanner extends RuleBasedScanner {
    public final static String IMPEX_COMMENT = "__xml_comment";

    public ImpexScanner(final ColorManager manager) {
        final IToken impexComment = new Token(new TextAttribute(manager.getColor(ImpexColorConstants.IMPEX_COMMENT)));

        final IRule[] rules = new IRule[2];
        //Add rule for processing instructions
        rules[0] = new EndOfLineRule("#", impexComment);

        // Add generic whitespace rule.
        rules[1] = new WhitespaceRule(new ImpexWhitespaceDetector());
        setRules(rules);
    }
}
