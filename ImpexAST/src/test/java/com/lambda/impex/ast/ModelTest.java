package com.lambda.impex.ast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.tree.CommonTree;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.Tree;
import org.apache.commons.io.FileUtils;

public abstract class ModelTest {

    protected ImpexParser parser;
    protected com.lambda.impex.ast.ImpexContext context;

    protected CommonTree init(final String name) throws Exception {
        final File file = new File(getClass().getResource(name).getFile());
        final String impex = FileUtils.readFileToString(file);
        context = new com.lambda.impex.ast.ImpexContext();
        final ImpexLexer lexer = new ImpexLexer(context, new ANTLRInputStream(impex));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        parser = new ImpexParser(context, tokens);
        return (CommonTree) parser.impex().getTree();
    }

    protected List<Tree> getChildrenWithType(final Tree tree, final int type) {
        final List<Tree> list = new ArrayList<Tree>();
        for (int i = 0; i < tree.getChildCount(); i++) {
            final Tree child = tree.getChild(i);
            if (type == child.getType()) {
                list.add(child);
            }
        }
        return list;
    }

    protected Tree getChildWithType(final Tree tree, final int type) {
        for (int i = 0; i < tree.getChildCount(); i++) {
            final Tree child = tree.getChild(i);
            if (type == child.getType()) {
                return child;
            }
        }
        return null;
    }

    protected Tree getFirstChildWithType(final Tree tree, final int type) {
        for (int i = 0; i < tree.getChildCount(); i++) {
            final Tree child = tree.getChild(i);
            if (type == child.getType()) {
                return child;
            }
        }
        return null;
    }

    protected Tree blocks(final Tree tree) {
        return getFirstChildWithType(tree, ImpexParser.BLOCKS);
    }

    protected Tree block(final Tree tree, final int blockNo) {
        return blocks(tree).getChild(blockNo);
    }

    protected Tree header(final Tree tree, final int blockNo) {
        return getFirstChildWithType(block(tree, blockNo), ImpexParser.HEADER);
    }

    protected Tree attributes(final Tree tree, final int blockNo) {
        return getFirstChildWithType(header(tree, blockNo), ImpexParser.ATTRIBUTES);
    }

    protected Tree type(final Tree tree, final int blockNo) {
        return getFirstChildWithType(header(tree, blockNo), ImpexParser.TYPE);
    }

    protected Tree modifiers(final Tree tree, final int blockNo) {
        return getFirstChildWithType(header(tree, blockNo), ImpexParser.MODIFIERS);
    }

    protected Tree modifiers(final Tree tree, final int blockNo, final int attributeNo) {
        return getFirstChildWithType(attribute(tree, blockNo, attributeNo), ImpexParser.MODIFIERS);
    }

    protected Tree modifier(final Tree tree, final int blockNo, final int modifierNo) {
        return modifiers(tree, blockNo).getChild(modifierNo);
    }

    protected Tree modifier(final Tree tree, final int blockNo, final int attributeNo, final int modifierNo) {
        return modifiers(tree, blockNo, attributeNo).getChild(modifierNo);
    }

    protected Tree attribute(final Tree tree, final int blockNo, final int attributeNo) {
        return attributes(tree, blockNo).getChild(attributeNo);
    }

    protected Tree records(final Tree tree, final int blockNo) {
        return getFirstChildWithType(block(tree, blockNo), ImpexParser.RECORDS);
    }

    protected Tree record(final Tree tree, final int blockNo, final int recordNo) {
        return records(tree, blockNo).getChild(recordNo);
    }

    protected Tree fields(final Tree records, final int recordNo) {
        return getFirstChildWithType(records.getChild(recordNo), ImpexParser.FIELDS);
    }

    protected Tree fields(final Tree tree, final int blockNo, final int recordNo) {
        return getFirstChildWithType(record(tree, blockNo, recordNo), ImpexParser.FIELDS);
    }

}
