package com.lambda.impex.ast.nodes;

import java.util.ArrayList;
import java.util.List;

import com.lambda.impex.ast.ImpexVisitor;

public class AttributeNode extends ImpexASTNode {

    private final List<ImpexASTNode> expression = new ArrayList<ImpexASTNode>();
    private final List<ImpexASTNode> modifiers = new ArrayList<ImpexASTNode>();
    private ImpexASTNode name;

    public AttributeNode() {
    }

    public AttributeNode(final ImpexASTNode name) {
        this.name = name;
    }

    @Override
    void doAccept(final ImpexVisitor visitor) {
        final boolean acceptChildren = visitor.visit(this);
        if (acceptChildren) {
            acceptChild(visitor, name);
            acceptChildren(visitor, expression);
            acceptChildren(visitor, modifiers);
        }
    }

    public void setName(final ImpexASTNode name) {
        this.name = name;
    }

    public void addAttribute(final ImpexASTNode attribute) {
        this.expression.add(attribute);
    }

    public void addModifier(final ImpexASTNode modifier) {
        modifiers.add(modifier);
    }

}
