package com.lambda.impex.ast;

public class DocumentIDQualifier {

    private final String qualifier;
    private final String documentID;

    public DocumentIDQualifier(final String qualifier, final String documentID) {
        this.qualifier = qualifier;
        this.documentID = documentID;
    }

    public String getQualifier() {
        return qualifier;
    }

    public String getDocumentID() {
        return documentID;
    }
}
