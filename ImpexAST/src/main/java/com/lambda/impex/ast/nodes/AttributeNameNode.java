package com.lambda.impex.ast.nodes;

import org.antlr.runtime.CommonToken;

import com.lambda.impex.ast.ImpexVisitor;

public class AttributeNameNode extends ImpexASTNode {

    private final String name;
    private final int type;
    private final ImpexASTNode subName;

    public AttributeNameNode(final CommonToken name, final ImpexASTNode subName) {
        super(name.getStartIndex(), subName != null ? subName.getStopPosition() : name.getStopIndex());
        this.name = name.getText();
        this.type = name.getType();
        this.subName = subName;
    }

    @Override
    void doAccept(final ImpexVisitor visitor) {
        final boolean acceptChildren = visitor.visit(this);
        if (acceptChildren) {
            acceptChild(visitor, subName);
        }
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public ImpexASTNode getSubName() {
        return subName;
    }
}
