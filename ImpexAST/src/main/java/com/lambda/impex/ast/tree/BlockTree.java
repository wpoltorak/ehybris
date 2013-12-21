package com.lambda.impex.ast.tree;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;

public class BlockTree extends CommonTree {

    public BlockTree(final int type) {
        super(new CommonToken(type));
    }

}
