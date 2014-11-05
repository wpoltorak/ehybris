package com.lambda.impex.ast;

public interface TypeDescription {

    boolean isAbstract();

    boolean exists();

    boolean isParentOf(String subtype);

    boolean containsField(String fieldName);

    TypeDescription getReturnType(String fieldName);

}
