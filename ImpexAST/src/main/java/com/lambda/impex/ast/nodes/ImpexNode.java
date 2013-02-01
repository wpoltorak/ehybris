package com.lambda.impex.ast.nodes;

import java.util.ArrayList;
import java.util.List;

import com.lambda.impex.ast.ImpexVisitor;

public class ImpexNode extends ImpexASTNode {

    private final List<ImpexASTNode> blocks = new ArrayList<ImpexASTNode>();

    public ImpexNode() {

    }

    @Override
    void doAccept(final ImpexVisitor visitor) {
        final boolean visitChildren = visitor.visit(this);
        if (visitChildren) {
            for (final ImpexASTNode node : blocks) {
                node.doAccept(visitor);
            }
        }
    }

    public void addBlock(final ImpexASTNode node) {
        blocks.add(node);
    }
}
