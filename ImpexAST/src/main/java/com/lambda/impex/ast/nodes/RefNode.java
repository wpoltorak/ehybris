package com.lambda.impex.ast.nodes;

import org.antlr.runtime.CommonToken;

import com.lambda.impex.ast.ImpexVisitor;

public class RefNode extends ImpexASTNode {

    private final String name;
    private final int type;

    public RefNode(final CommonToken token) {
        super(token.getStartIndex(), token.getStopIndex());
        this.name = token.getText();
        this.type = token.getType();
    }

    @Override
    void doAccept(final ImpexVisitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

}
