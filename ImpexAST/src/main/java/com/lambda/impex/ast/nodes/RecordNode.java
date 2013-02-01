package com.lambda.impex.ast.nodes;

import java.util.List;

import org.antlr.runtime.CommonToken;

import com.lambda.impex.ast.ImpexVisitor;

public class RecordNode extends ImpexASTNode {

    private final String subtype;
    private final List<ImpexASTNode> fields;

    public RecordNode(final CommonToken subType, final List<ImpexASTNode> fields) {
        super(startIndex(subType, fields), stopIndex(fields));
        this.subtype = subType == null ? null : subType.getText();
        this.fields = fields;
    }

    private static int stopIndex(final List<ImpexASTNode> fields) {
        return fields.get(fields.size() - 1).getStopPosition();
    }

    private static int startIndex(final CommonToken subType, final List<ImpexASTNode> fields) {
        return subType != null ? subType.getStartIndex() : fields.get(0).getStartPosition();
    }

    @Override
    void doAccept(final ImpexVisitor visitor) {
        final boolean acceptChildren = visitor.visit(this);
        if (acceptChildren) {
            acceptChildren(visitor, fields);
        }
    }

    public String getSubtype() {
        return subtype;
    }

    public List<ImpexASTNode> getFields() {
        return fields;
    }
}
