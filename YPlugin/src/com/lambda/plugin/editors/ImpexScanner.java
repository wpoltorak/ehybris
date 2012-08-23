package com.lambda.plugin.editors;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.RuleBasedScanner;
import org.eclipse.jface.text.rules.SingleLineRule;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

public class ImpexScanner extends RuleBasedScanner {
    public final static String IMPEX_COMMENT = "__xml_comment";
    public final static String MACRO_ASSIGNMENT = "__macro_assignement";

    public ImpexScanner(final ColorManager manager) {
        final IToken procInstr = new Token(new TextAttribute(manager.getColor(ImpexColorConstants.PROC_INSTR)));
        final IToken impexComment = new Token(IMPEX_COMMENT);
        final IToken macroAssignment = new Token(MACRO_ASSIGNMENT);

        final IRule[] rules = new IRule[5];
        //Add rule for processing instructions
        rules[0] = new SingleLineRule("<?", "?>", procInstr);
        rules[1] = new EndOfLineRule("#", impexComment);
        rules[2] = new EndOfLineRule("$", macroAssignment);

        // Add generic whitespace rule.
        rules[3] = new WhitespaceRule(new ImpexWhitespaceDetector());
        final IToken token = new Token(
                new TextAttribute(new Color(Display.getCurrent(), ImpexColorConstants.IMPEX_COMMENT), null, SWT.BOLD));
        final WordRule wordRule = new WordRule(new KeywordDetector(), Token.UNDEFINED, true);
        wordRule.addWord("insert", token);
        wordRule.addWord("insert_update", token);
        wordRule.addWord("update", token);
        rules[4] = wordRule;
        setRules(rules);
    }

    class KeywordDetector implements IWordDetector {
        public boolean isWordStart(final char c) {
            return Character.isJavaIdentifierStart(c);
        }

        public boolean isWordPart(final char c) {
            return c != ':' && c != '=' && !Character.isSpaceChar(c);
        }
    }

}
