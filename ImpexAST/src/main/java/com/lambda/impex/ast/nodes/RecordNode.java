package com.lambda.impex.ast.nodes;

import java.util.ArrayList;
import java.util.List;

import com.lambda.impex.ast.ImpexContext;
import com.lambda.impex.ast.ImpexVisitor;

public class RecordNode extends ImpexASTNode {

    private String subtype;
    private final List<String> fields = new ArrayList<String>();

    public RecordNode() {
    }

    @Override
    void doAccept(final ImpexVisitor visitor) {
        final boolean acceptChildren = visitor.visit(this);
        if (acceptChildren) {
            //            for (final ImpexASTNode node : fields) {
            //                node.accept(visitor);
            //            }
        }

    }

    public void evaluate(final ImpexContext context) {

        //        for (final IImpexNode field : fields) {
        //            field.evaluate(context);
        //        }

    }

    public void setSubType(final String subtype) {
        this.subtype = subtype;
    }

    public void addField(final String field) {
        fields.add(field);
    }

}
