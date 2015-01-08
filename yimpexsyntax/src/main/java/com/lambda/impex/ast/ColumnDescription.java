package com.lambda.impex.ast;

import java.util.List;

public interface ColumnDescription {

    boolean isEmpty();

    List<ColumnDescription> getChildren();

    TypeDescription getOwner();

    TypeDescription getType();

    //    TypeDescription getType();

    void addChild(ColumnDescription columnDescription);

    void setDocumentIDDefinition(boolean docuemntIDDefinition);

    void setDocumentIDReference(boolean docuemntIDReference);

    void setDocumentID(String text);

    boolean hasParent();

    ColumnDescription getParent();

    boolean isDocumentIDDefinition();

    boolean isDocumentIDReferrence();

    String getDocumentID();

    void setType(TypeDescription returnType);

}
