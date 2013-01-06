package com.lambda.impex.ast.nodes;

import java.util.ArrayList;
import java.util.List;

import com.lambda.impex.ast.ImpexContext;


public class ImpexNode implements IImpexNode {

    private final List<IImpexNode> blocks = new ArrayList<IImpexNode>();

    public ImpexNode() {
    }

    public void evaluate(final ImpexContext context) {
        for (final IImpexNode block : blocks) {
            block.evaluate(context);
        }
    }

    public void addBlock(final IImpexNode node) {
        blocks.add(node);
    }
}