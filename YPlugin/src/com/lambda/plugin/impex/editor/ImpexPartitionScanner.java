package com.lambda.plugin.impex.editor;

import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;

public class ImpexPartitionScanner extends RuleBasedPartitionScanner {
    public final static String IMPEX_HEADER = "__impex_header";
    public final static String IMPEX_MACRO = "__impex_macro";

    public ImpexPartitionScanner() {

        final IToken tag = new Token(IMPEX_HEADER);

        final IPredicateRule[] predicateRules = new IPredicateRule[5];

        predicateRules[0] = new ImpexHeaderRule(ImpexHeaderRule.INSERT, tag);
        predicateRules[1] = new ImpexHeaderRule(ImpexHeaderRule.INSERT_UPDATE, tag);
        predicateRules[2] = new ImpexHeaderRule(ImpexHeaderRule.UPDATE, tag);
        predicateRules[3] = new ImpexHeaderRule(ImpexHeaderRule.REMOVE, tag);
        predicateRules[4] = new EndOfLineRule("$", new Token(IMPEX_MACRO));
        setPredicateRules(predicateRules);
    }
}