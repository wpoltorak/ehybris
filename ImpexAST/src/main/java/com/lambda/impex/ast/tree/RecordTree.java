package com.lambda.impex.ast.tree;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

public class RecordTree extends CommonTree {

    public RecordTree(final int type) {
        super(new CommonToken(type));
    }

    @Override
    public void addChild(final Tree t) {
        super.addChild(t);
    }
}
