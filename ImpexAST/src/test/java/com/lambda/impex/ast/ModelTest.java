package com.lambda.impex.ast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.io.FileUtils;

import com.lambda.impex.ast.ImpexParser.ImpexContext;

public abstract class ModelTest {

    protected ImpexParser parser;
    protected com.lambda.impex.ast.ImpexContext context;

    protected ImpexContext init(final String name) throws Exception {
        final File file = new File(getClass().getResource(name).getFile());
        final String impex = FileUtils.readFileToString(file);
        final ImpexLexer lexer = new ImpexLexer(new ANTLRInputStream(impex));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        parser = new ImpexParser(tokens);
        final ParseTreeWalker walker = new ParseTreeWalker();
        final ImpexParserDefaultListener listener = new ImpexParserDefaultListener();
        final ImpexContext parseTree = parser.impex();
        walker.walk(listener, parseTree);
        context = listener.getContext();
        return parseTree;
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

    protected ParseTree attribute(final ParseTree tree, final int blockNo, final int attributeNo) {
        return getNthChildWithType(header(tree, blockNo), attributeNo, ImpexParser.RULE_attribute);
    }

    protected ParseTree type(final ParseTree tree, final int blockNo) {
        return getFirstChildWithType(header(tree, blockNo), ImpexParser.RULE_headerTypeName);
    }

    protected ParseTree modifiers(final ParseTree tree, final int blockNo) {
        return getFirstChildWithType(header(tree, blockNo), ImpexParser.RULE_attributeModifierAssignment);
    }

    protected ParseTree modifiers(final ParseTree tree, final int blockNo, final int attributeNo) {
        return getFirstChildWithType(attribute(tree, blockNo, attributeNo), ImpexParser.RULE_attributeModifierAssignment);
    }

    protected ParseTree modifier(final ParseTree tree, final int blockNo, final int modifierNo) {
        return modifiers(tree, blockNo).getChild(modifierNo);
    }

    protected ParseTree modifier(final ParseTree tree, final int blockNo, final int attributeNo, final int modifierNo) {
        return modifiers(tree, blockNo, attributeNo).getChild(modifierNo);
    }

    protected ParseTree record(final ParseTree tree, final int blockNo, final int recordNo) {
        return getNthChildWithType(block(tree, blockNo), recordNo, ImpexParser.RULE_record);
    }

    protected ParseTree fields(final ParseTree tree, final int recordNo) {
        return getFirstChildWithType(tree.getChild(recordNo), ImpexParser.Field);
    }

    protected ParseTree fields(final ParseTree tree, final int blockNo, final int recordNo) {
        return getFirstChildWithType(record(tree, blockNo, recordNo), ImpexParser.Field);
    }

}
