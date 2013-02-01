package com.lambda.impex.ast.nodes;

import java.util.Collection;

import com.lambda.impex.ast.ImpexVisitor;

public abstract class ImpexASTNode {

    private int startPosition;
    private int stopPosition;
    private int length;

    public ImpexASTNode(final int startPosition, final int stopPosition) {
        this.startPosition = startPosition;
        this.stopPosition = stopPosition;
    }

    public ImpexASTNode() {
    }

    abstract void doAccept(ImpexVisitor visitor);

    public final void accept(final ImpexVisitor visitor) {
        if (visitor == null) {
            throw new IllegalArgumentException("Visitor is null");
        }
        try {
            if (visitor.preVisit(this)) {
                // dynamic dispatch to internal method for type-specific visit/endVisit
                doAccept(visitor);
            }
        } finally {
            // end with the generic post-visit
            visitor.postVisit(this);
        }
    }

    final void acceptChild(final ImpexVisitor visitor, final ImpexASTNode child) {
        if (child == null) {
            return;
        }
        child.accept(visitor);
    }

    final void acceptChildren(final ImpexVisitor visitor, final Collection<ImpexASTNode> children) {
        if (children == null || children.isEmpty()) {
            return;
        }

        for (final ImpexASTNode child : children) {
            child.accept(visitor);
        }
    }

    public final int getStartPosition() {
        return startPosition;
    }

    public final int getStopPosition() {
        return stopPosition;
    }

    public final int getLength() {
        return length;
    }
}