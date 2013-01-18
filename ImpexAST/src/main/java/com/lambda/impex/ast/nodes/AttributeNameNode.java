package com.lambda.impex.ast.nodes;

import org.antlr.runtime.CommonToken;

import com.lambda.impex.ast.ImpexContext;
import com.lambda.impex.ast.ImpexVisitor;

public class AttributeNameNode extends ImpexASTNode {

    private String name;
    private int type;
    private ImpexASTNode subName;

    public AttributeNameNode() {
    }

    @Override
    void doAccept(final ImpexVisitor visitor) {
        final boolean acceptChildren = visitor.visit(this);
        if (acceptChildren) {
            acceptChild(visitor, subName);
        }
    }

    public void init(final CommonToken token) {
        this.name = token.getText();
        this.type = token.getType();
    }

    public void setSubName(final ImpexASTNode subName) {
        this.subName = subName;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(final int type) {
        this.type = type;
    }

    public ImpexASTNode getSubName() {
        return subName;
    }

    public void evaluate(final ImpexContext context) {
        // TODO Auto-generated method stub

    }
}
