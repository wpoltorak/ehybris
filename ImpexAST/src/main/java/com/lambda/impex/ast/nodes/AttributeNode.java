package com.lambda.impex.ast.nodes;

import java.util.List;

import com.lambda.impex.ast.ImpexVisitor;

public class AttributeNode extends ImpexASTNode {

    private final List<ImpexASTNode> expression;
    private final List<ImpexASTNode> modifiers;
    private final ImpexASTNode name;

    public AttributeNode(final ImpexASTNode name, final List<ImpexASTNode> expression, final List<ImpexASTNode> modifiers) {
        super(name.getStartPosition(), stopIndex(name, expression, modifiers));
        this.name = name;
        this.expression = expression;
        this.modifiers = modifiers;
    }

    private static int stopIndex(final ImpexASTNode name, final List<ImpexASTNode> expression, final List<ImpexASTNode> modifiers) {
        if (modifiers.isEmpty()) {
            return expression.isEmpty() ? name.getStopPosition() : expression.get(expression.size() - 1).getStopPosition();
        }
        return modifiers.get(modifiers.size() - 1).getStopPosition();
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

    public ImpexASTNode getName() {
        return name;
    }

    public List<ImpexASTNode> getExpression() {
        return expression;
    }

    public List<ImpexASTNode> getModifiers() {
        return modifiers;
    }
}
