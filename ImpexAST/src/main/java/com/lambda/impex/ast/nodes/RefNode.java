package com.lambda.impex.ast.nodes;

import org.antlr.runtime.CommonToken;

import com.lambda.impex.ast.ImpexContext;
import com.lambda.impex.ast.ImpexError;
import com.lambda.impex.ast.ImpexVisitor;
import com.lambda.impex.ast.ImpexError.Type;
import com.lambda.impex.ast.ImpexParser;

public class RefNode extends ImpexASTNode {

    private final String name;
    private final int type;

    public RefNode(final CommonToken token) {
        this.name = token.getText();
        this.type = token.getType();
    }

    @Override
    void doAccept(final ImpexVisitor visitor) {
        visitor.visit(this);
    }

    public void evaluate(final ImpexContext context) {
        switch (type) {
            case ImpexParser.DOCUMENTID_REF:
                if (!context.hasDocumentID(name)) {
                    context.addError(new ImpexError(Type.UnknownDocumentID));
                }
                break;
            default:
                break;
        }

    }
}
