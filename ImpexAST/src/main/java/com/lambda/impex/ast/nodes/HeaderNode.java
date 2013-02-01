package com.lambda.impex.ast.nodes;

import java.util.List;

import org.antlr.runtime.CommonToken;

import com.lambda.impex.ast.ImpexVisitor;

public class HeaderNode extends ImpexASTNode {

    private final List<ImpexASTNode> modifiers;
    private final List<ImpexASTNode> attributes;
    private final int mode;
    private final String type;

    public HeaderNode(final CommonToken mode, final CommonToken type, final List<ImpexASTNode> modifiers,
            final List<ImpexASTNode> attributes) {
        super(mode.getStartIndex(), getStopPosition(mode, type, modifiers, attributes));
        this.type = type.getText();
        this.mode = mode.getType();
        this.modifiers = modifiers;
        this.attributes = attributes;
    }

    private static int getStopPosition(final CommonToken mode, final CommonToken type, final List<ImpexASTNode> modifiers,
            final List<ImpexASTNode> attributes) {
        final int attribStop = attributes.isEmpty() ? 0 : attributes.get(attributes.size() - 1).getStopPosition();
        final int modifiersStop = modifiers.isEmpty() ? 0 : modifiers.get(modifiers.size() - 1).getStopPosition();
        final int typeStop = type.getStopIndex();
        return Math.max(attribStop, Math.max(modifiersStop, typeStop));
    }

    @Override
    void doAccept(final ImpexVisitor visitor) {
        final boolean acceptChildren = visitor.visit(this);
        if (acceptChildren) {
            acceptChildren(visitor, modifiers);
            acceptChildren(visitor, attributes);
        }
    }

    public List<ImpexASTNode> getModifiers() {
        return modifiers;
    }

    public int getMode() {
        return mode;
    }

    public String getType() {
        return type;
    }

    public List<ImpexASTNode> getAttributes() {
        return attributes;
    }
}
