package com.lambda.plugin.impex.editor;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;

public class ImpexScanner extends RuleBasedScanner {
    public final static String IMPEX_COMMENT = "__xml_comment";

    public ImpexScanner(final ColorManager manager) {
        final IToken procInstr = new Token(new TextAttribute(manager.getColor(ImpexColorConstants.PROC_INSTR)));
        final IToken impexComment = new Token(new TextAttribute(manager.getColor(ImpexColorConstants.IMPEX_COMMENT)));

        final IRule[] rules = new IRule[3];
        //Add rule for processing instructions
        rules[0] = new SingleLineRule("<?", "?>", procInstr);
        rules[1] = new EndOfLineRule("#", impexComment);

        // Add generic whitespace rule.
        rules[2] = new WhitespaceRule(new ImpexWhitespaceDetector());
        setRules(rules);
    }
}
