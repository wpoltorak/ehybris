package com.lambda.impex.ast.tree;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;

public class HeaderTree extends CommonTree {

    public HeaderTree(final int type) {
        super(new CommonToken(type));
    }

}
