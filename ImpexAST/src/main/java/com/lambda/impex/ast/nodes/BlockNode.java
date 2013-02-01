package com.lambda.impex.ast.nodes;

import java.util.List;

import com.lambda.impex.ast.ImpexVisitor;

public class BlockNode extends ImpexASTNode {

    private final ImpexASTNode header;
    private final List<ImpexASTNode> records;

    public BlockNode(final ImpexASTNode header, final List<ImpexASTNode> records) {
        super(header.getStartPosition(), getStopPosition(header, records));
        this.header = header;
        this.records = records;
    }

    private static int getStopPosition(final ImpexASTNode header, final List<ImpexASTNode> records) {
        if (records.isEmpty()) {
            return header.getStopPosition();
        }
        return records.get(records.size() - 1).getStopPosition();
    }

    @Override
    void doAccept(final ImpexVisitor visitor) {
        final boolean acceptChildren = visitor.visit(this);
        if (acceptChildren) {
            acceptChild(visitor, header);
            acceptChildren(visitor, records);
        }
    }

    public ImpexASTNode getHeader() {
        return header;
    }

    public List<ImpexASTNode> getRecords() {
        return records;
    }
}
