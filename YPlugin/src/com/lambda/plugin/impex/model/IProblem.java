package com.lambda.plugin.impex.model;

public interface IProblem {

    int getLineNumber();

    int getLength();

    int getOffset();

    int getSeverity();

    String getMessage();

}
