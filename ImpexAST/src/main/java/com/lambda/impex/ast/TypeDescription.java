package com.lambda.impex.ast;

public interface TypeDescription {

    boolean isAbstract();

    boolean exists();

    boolean contains(String subtype);
}
