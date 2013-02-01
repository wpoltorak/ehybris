package com.lambda.impex.ast.nodes;

import org.antlr.runtime.CommonToken;

import com.lambda.impex.ast.ImpexVisitor;

public class ModifierNode extends ImpexASTNode {

    private final int type;
    private final String value;

    public ModifierNode(final CommonToken typeToken, final CommonToken valueToken) {
        super(typeToken.getStartIndex(), valueToken.getStopIndex());
        this.type = typeToken.getType();
        this.value = valueToken.getText();
    }

    @Override
    void doAccept(final ImpexVisitor visitor) {
        visitor.visit(this);
    }

    public String getValue() {
        return value;
    }

    public int getType() {
        return type;
    }
}
