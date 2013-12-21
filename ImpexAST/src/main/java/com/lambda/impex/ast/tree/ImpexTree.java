package com.lambda.impex.ast.tree;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;

public class ImpexTree extends CommonTree {

    public ImpexTree(final int type) {
        super(new CommonToken(type));
    }
}
