package com.lambda.impex.ast.nodes;

import org.antlr.runtime.CommonToken;

import com.lambda.impex.ast.ImpexVisitor;

public class FieldNode extends ImpexASTNode {

    private final String field;

    public FieldNode(final CommonToken field) {
        super(field.getStartIndex(), field.getStopIndex());
        this.field = field.getText();
    }

    @Override
    void doAccept(final ImpexVisitor visitor) {
        visitor.visit(this);
    }

    public String getField() {
        return field;
    }
}
