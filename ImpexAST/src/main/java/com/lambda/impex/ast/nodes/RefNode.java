package com.lambda.impex.ast.nodes;

import com.lambda.impex.ast.ImpexContext;
import com.lambda.impex.ast.ImpexError;
import com.lambda.impex.ast.ImpexError.Type;
import com.lambda.impex.ast.ImpexParser;

public class RefNode implements IImpexNode {

    private final String name;
    private final int type;

    public RefNode(final String name, final int type) {
        this.name = name;
        this.type = type;
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
