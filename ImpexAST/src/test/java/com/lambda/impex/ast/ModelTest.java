package com.lambda.impex.ast;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.io.IOUtils;

public abstract class ModelTest {

    protected com.lambda.impex.ast.ImpexParseContext context;

    protected ParseTree init(final String name) throws Exception {
        final char[] impex = IOUtils.toCharArray(getClass().getResourceAsStream(name));
        final ImpexCompiler compiler = new ImpexCompiler();
        compiler.compile(impex);
        context = compiler.getContext();
        return compiler.getParseTree();
    }

    protected ParseTree getNthChildWithType(final ParseTree tree, final int n, final int type) {
        int index = 0;
        for (int i = 0; i < tree.getChildCount(); i++) {
            final ParseTree child = tree.getChild(i);
            if (matchesType(child, type)) {
                if (index == n) {
                    return child;
                }
                index++;
            }
        }
        throw new IllegalStateException("No nth child found of type: " + type + ", n: " + n);
    }

    protected List<ParseTree> getChildrenWithType(final ParseTree tree, final int type) {
        final List<ParseTree> list = new ArrayList<ParseTree>();
        for (int i = 0; i < tree.getChildCount(); i++) {
            final ParseTree child = tree.getChild(i);
            if (matchesType(child, type)) {
                list.add(child);
            }
        }
        return list;
    }

    protected boolean matchesType(final ParseTree child, final int type) {
        if (child instanceof RuleNode) {
            final RuleNode rule = (RuleNode) child;
            return rule.getRuleContext().getRuleIndex() == type;
        } else if (child instanceof TerminalNode) {
            final TerminalNode terminal = (TerminalNode) child;
            return terminal.getSymbol().getType() == type;
        }
        return false;
    }

    protected ParseTree getChildWithType(final ParseTree tree, final int type) {
        for (int i = 0; i < tree.getChildCount(); i++) {
            final ParseTree child = tree.getChild(i);
            if (matchesType(child, type)) {
                return child;
            }
        }
        return null;
    }

    protected ParseTree getFirstChildWithType(final ParseTree tree, final int type) {
        for (int i = 0; i < tree.getChildCount(); i++) {
            final ParseTree child = tree.getChild(i);
            if (matchesType(child, type)) {
                return child;
            }
        }
        return null;
    }

    protected ParseTree block(final ParseTree tree, final int blockNo) {
        return getNthChildWithType(tree, blockNo, ImpexParser.RULE_block);
    }

    protected ParseTree header(final ParseTree tree, final int blockNo) {
        return getFirstChildWithType(block(tree, blockNo), ImpexParser.RULE_header);
    }

    protected ParseTree mode(final ParseTree tree, final int blockNo) {
        return getFirstChildWithType(header(tree, blockNo), ImpexParser.RULE_headerMode);
    }

    protected ParseTree attribute(final ParseTree tree, final int blockNo, final int attributeNo) {
        final ParseTree attribute = getNthChildWithType(header(tree, blockNo), attributeNo, ImpexParser.RULE_attribute);
        return getFirstChildWithType(attribute, ImpexParser.RULE_attributeValue);
    }

    protected ParseTree type(final ParseTree tree, final int blockNo) {
        return getFirstChildWithType(header(tree, blockNo), ImpexParser.RULE_headerTypeName);
    }

    /**
     * Return first header modifier
     * 
     * @param tree
     * @param blockNo
     * @return
     */
    protected List<ParseTree> modifiers(final ParseTree tree, final int blockNo) {
        return getChildrenWithType(header(tree, blockNo), ImpexParser.RULE_headerModifierAssignment);
    }

    /**
     * Return first header modifier
     * 
     * @param tree
     * @param blockNo
     * @return
     */
    protected ParseTree modifier(final ParseTree tree, final int blockNo) {
        return getFirstChildWithType(header(tree, blockNo), ImpexParser.RULE_headerModifierAssignment);
    }

    /**
     * Return all attribute modifiers
     * 
     * @param tree
     * @param blockNo
     * @param attributeNo
     * @return
     */
    protected List<ParseTree> modifiers(final ParseTree tree, final int blockNo, final int attributeNo) {
        return getChildrenWithType(attribute(tree, blockNo, attributeNo), ImpexParser.RULE_attributeModifierAssignment);
    }

    /**
     * Return first attribute modifier
     * 
     * @param tree
     * @param blockNo
     * @param attributeNo
     * @return
     */
    protected ParseTree modifier(final ParseTree tree, final int blockNo, final int attributeNo) {
        return getFirstChildWithType(attribute(tree, blockNo, attributeNo), ImpexParser.RULE_attributeModifierAssignment);
    }

    /**
     * Return nth attribute modifier
     * 
     * @param tree
     * @param blockNo
     * @param attributeNo
     * @param modifierNo
     * @return
     */
    protected ParseTree modifier(final ParseTree tree, final int blockNo, final int attributeNo, final int modifierNo) {
        return getNthChildWithType(attribute(tree, blockNo, attributeNo), modifierNo, ImpexParser.RULE_attributeModifierAssignment);
    }

    protected List<ParseTree> records(final ParseTree tree, final int blockNo) {
        return getChildrenWithType(block(tree, blockNo), ImpexParser.RULE_record);
    }

    protected ParseTree record(final ParseTree tree, final int blockNo, final int recordNo) {
        return getNthChildWithType(block(tree, blockNo), recordNo, ImpexParser.RULE_record);
    }

    protected ParseTree fields(final ParseTree tree, final int recordNo) {
        return getFirstChildWithType(tree.getChild(recordNo), ImpexParser.Field);
    }

    protected List<ParseTree> fields(final ParseTree tree, final int blockNo, final int recordNo) {
        return getChildrenWithType(record(tree, blockNo, recordNo), ImpexParser.Field);
    }

    protected List<ParseTree> fields(final ParseTree record) {
        return getChildrenWithType(record, ImpexParser.Field);
    }
}
