package com.lambda.impex.ast;

import java.util.Set;

public interface TypeDescription {

    boolean isAbstract();

    boolean isDataModel();

    boolean isCollection();

    boolean isEnum();

    boolean exists();

    boolean isChildOf(String supertype);

    Set<String> getFields();

    boolean containsField(String fieldName);

    boolean sameAs(String name);

    String getReturnType(String fieldName);

    String getName();

    Object getTarget();
}
