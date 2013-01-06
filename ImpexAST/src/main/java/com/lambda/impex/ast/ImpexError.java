package com.lambda.impex.ast;

public class ImpexError {
    public enum Type {
        InvalidBoolean, InvalidDate, InvalidClassname, InvalidPosition, InvalidMode, InvalidLang, InvalidNumberFormat, InvalidDateFormat,
        UnknownType, UnknownDocumentID, UnknownMacro, DuplicateDocumentID, ParserSyntaxError, LexerSyntaxError;
    }

    private int lineNumber;
    private int positionInRow;
    private int startIndex;
    private int stopIndex;
    private Type type;

    public ImpexError(final Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(final Type type) {
        this.type = type;
    }

    private String messageCode;
    private int length;

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(final int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public int getPositionInRow() {
        return positionInRow;
    }

    public void setPositionInRow(final int positionInRow) {
        this.positionInRow = positionInRow;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(final int startIndex) {
        this.startIndex = startIndex;
    }

    public int getStopIndex() {
        return stopIndex;
    }

    public void setStopIndex(final int stopIndex) {
        this.stopIndex = stopIndex;
    }

    public String getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(final String messageCode) {
        this.messageCode = messageCode;
    }

    public void setLength(final int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
