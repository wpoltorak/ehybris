package com.lambda.plugin.impex.editor;

import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;

/**
 * PartitionScanner allows documents to be partitioned into separate content types. These partitions allow the editor to
 * behave differently, depending on the various content types. For example, code completion, keyword highlighting and
 * formatting can behave differently for each partition type.
 * 
 * @author Wojciech Poltorak
 * 
 */
public class ImpexPartitionScanner extends RuleBasedPartitionScanner {
    final static String COMMENT = "__comment";
    final static String BEANSHELL = "__beanshell";
    final static String MACRO = "__macro";
    static final String[] CONTENT_TYPES = new String[] { COMMENT, BEANSHELL, MACRO };

    public ImpexPartitionScanner() {
        final IPredicateRule[] rules = new IPredicateRule[3];
        Token beanshell = new Token(BEANSHELL);
        Token comment = new Token(COMMENT);
        rules[0] = new BeanshellRule(beanshell);
        rules[1] = new EndOfLineRule("#%", beanshell);
        rules[2] = new EndOfLineRule("#", comment);
        // rules[3] = new WordPRule(detector);
        // rules[3] = new SingleLineRule("\"", "\"", string, '"');
        // rules[4] = new SingleLineRule("'", "'", string, '\'');

        // rules[0] = new ImpexHeaderRule(ImpexHeaderRule.INSERT, tag);
        // rules[1] = new ImpexHeaderRule(ImpexHeaderRule.INSERT_UPDATE, tag);
        // rules[2] = new ImpexHeaderRule(ImpexHeaderRule.UPDATE, tag);
        // rules[3] = new ImpexHeaderRule(ImpexHeaderRule.REMOVE, tag);
        // rules[4] = new EndOfLineRule("$", new Token(IMPEX_MACRO));
        setPredicateRules(rules);
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