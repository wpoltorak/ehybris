package com.lambda.impex.ast.nodes;

import java.util.List;

import org.antlr.runtime.CommonToken;

import com.lambda.impex.ast.ImpexVisitor;

public class HeaderNode extends ImpexASTNode {

    private final List<ImpexASTNode> modifiers;
    private final List<ImpexASTNode> attributes;
    private final int mode;
    private final String type;
    private final String documentID;

    public HeaderNode(final CommonToken mode, final CommonToken type, final CommonToken documentID, final List<ImpexASTNode> modifiers,
            final List<ImpexASTNode> attributes) {
        this.type = type.getText();
        this.mode = mode.getType();
        this.documentID = documentID != null ? documentID.getText() : null;
        this.modifiers = modifiers;
        this.attributes = attributes;
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

    public String getDocumentID() {
        return documentID;
    }

    public List<ImpexASTNode> getAttributes() {
        return attributes;
    }
}
