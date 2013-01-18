package com.lambda.impex.ast;

import com.lambda.impex.ast.nodes.AttributeNameNode;
import com.lambda.impex.ast.nodes.AttributeNode;
import com.lambda.impex.ast.nodes.BlockNode;
import com.lambda.impex.ast.nodes.HeaderNode;
import com.lambda.impex.ast.nodes.ImpexASTNode;
import com.lambda.impex.ast.nodes.ModifierNode;
import com.lambda.impex.ast.nodes.RecordNode;
import com.lambda.impex.ast.nodes.RefNode;

public abstract class ImpexVisitor {

    protected ImpexContext context;

    public void prepare(final ImpexContext context) {
        this.context = context;
    }

    public boolean preVisit(final ImpexASTNode node) {
        return true;
    }

    public boolean postVisit(final ImpexASTNode node) {
        return true;
    }

    public boolean visit(final ImpexASTNode node) {
        return true;
    }

    public boolean visit(final AttributeNameNode node) {
        return true;
    }

    public boolean visit(final AttributeNode node) {
        return true;
    }

    public boolean visit(final BlockNode node) {
        return true;
    }

    public boolean visit(final HeaderNode node) {
        return true;
    }

    public boolean visit(final ModifierNode node) {
        return true;
    }

    public boolean visit(final RecordNode node) {
        return true;
    }

    public boolean visit(final RefNode node) {
        return true;
    }

}
