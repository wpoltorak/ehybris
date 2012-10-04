package com.lambda.plugin.impex.model;

public class ImpexModelProblem implements IProblem {

    private final String message;
    private final int severity;
    private final int offset;
    private final int length;
    private final int lineNumber;

    public ImpexModelProblem(final String message, final int severity, final int offset, final int length, final int lineNumber) {
        this.message = message;
        this.severity = severity;
        this.offset = offset;
        this.length = length;
        this.lineNumber = lineNumber;
    }

    public String getMessage() {
        return message;
    }

    public int getSeverity() {
        return severity;
    }

    public int getOffset() {
        return offset;
    }

    public int getLength() {
        return length;
    }

    public int getLineNumber() {
        return lineNumber;
    }
}