package com.lambda.plugin.editors;

import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;

public class ImpexPartitionScanner extends RuleBasedPartitionScanner {
    public final static String XML_TAG = "__xml_tag";

    public ImpexPartitionScanner() {

        final IToken tag = new Token(XML_TAG);

        final IPredicateRule[] predicateRules = new IPredicateRule[1];

        predicateRules[0] = new TagRule(tag);

        setPredicateRules(predicateRules);
    }
}