package com.lambda.impex.ast;

public class DocumentIDDescription {

    private final String documentIDDefinition;
    private final String documentIDQualifier;

    public DocumentIDDescription(final String documentIDDefinition, final String documentIDQualifier) {
        this.documentIDDefinition = documentIDDefinition;
        this.documentIDQualifier = documentIDQualifier;
    }

    public String getDocumentIDDefinition() {
        return documentIDDefinition;
    }

    public String getDocumentIDQualifier() {
        return documentIDQualifier;
    }

    @Override
    public boolean equals(final Object obj) {
        if (!(obj instanceof DocumentIDDescription)) {
            return false;
        }

        final DocumentIDDescription did = (DocumentIDDescription) obj;
        return documentIDDefinition.equals(did.getDocumentIDDefinition()) && documentIDQualifier.equals(did.getDocumentIDQualifier());
    }

    @Override
    public int hashCode() {
        final int constant = 37;
        int total = 17;
        total = total * constant + documentIDDefinition.hashCode();
        total = total * constant + documentIDQualifier.hashCode();
        return total;

    }
}
