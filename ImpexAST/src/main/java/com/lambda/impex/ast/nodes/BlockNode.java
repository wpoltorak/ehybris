package com.lambda.impex.ast.nodes;

import java.util.ArrayList;
import java.util.List;

import com.lambda.impex.ast.ImpexContext;


public class BlockNode implements IImpexNode {

    private IImpexNode header;
    private final List<IImpexNode> records = new ArrayList<IImpexNode>();

    public BlockNode() {
    }

    public void evaluate(final ImpexContext context) {
        header.evaluate(context);
        for (final IImpexNode record : records) {
            record.evaluate(context);
        }
        //        context.
    }

    public void setHeader(final IImpexNode header) {
        this.header = header;
    }

    public void addRecord(final IImpexNode record) {
        records.add(record);
    }

}
