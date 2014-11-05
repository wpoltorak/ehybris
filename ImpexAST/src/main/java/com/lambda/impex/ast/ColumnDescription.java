package com.lambda.impex.ast;

import java.util.List;

public interface ColumnDescription {

    List<ColumnDescription> getChildren();

    TypeDescription getType();

    void addChild(ColumnDescription columnDescription);

    void setDocumentIDDefinition(boolean docuemntIDDefinitioon);

    void setDocumentIDReference(boolean docuemntIDReference);

    void setDocumentID(String text);

    boolean hasParent();

    ColumnDescription getParent();

    void addAttribute(String name);

    void addAttribute(TypeDescription type, String attributeName);

    boolean isDocumentIDDefinition();

    boolean isDocumentIDReferrence();

    String getDocumentID();

}
