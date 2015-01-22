package com.lambda.impex.ast;

import java.util.List;

public interface ColumnDescription {

    boolean isEmpty();

    List<ColumnDescription> getChildren();

    TypeDescription getOwner();

    TypeDescription getType();

    void addChild(ColumnDescription columnDescription);

    void setDocumentID(String text);

    boolean hasParent();

    ColumnDescription getParent();

    String getDocumentID();

    void setType(TypeDescription returnType);

}
