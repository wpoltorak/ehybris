package com.lambda.ecommerce.impex.model;

public interface IProblem {

    int getLineNumber();

    int getLength();

    int getOffset();

    int getSeverity();

    String getMessage();

    boolean isError();

    boolean isWarning();

}
