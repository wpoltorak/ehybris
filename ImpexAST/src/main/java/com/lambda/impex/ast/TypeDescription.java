package com.lambda.impex.ast;

public interface TypeDescription {

    boolean isAbstract();

    boolean iseCommerce();

    boolean isCollection();

    boolean exists();

    boolean isParentOf(String subtype);

    boolean containsField(String fieldName);

    boolean sameAs(String name);

    String getReturnType(String fieldName);

    String getName();
}
