package com.lambda.impex.ast;

public class ImpexProblem {
    public static final String SEPARATOR = "<%>";

    public enum Type {
        InvalidAttributeModifier, InvalidHeaderModifier, InvalidBoolean, InvalidDate, InvalidClassname, InvalidPosition, InvalidMode,
        InvalidLang, InvalidNumberFormat, InvalidDateFormat, General, GeneralSyntaxError, EmptyMacroValue, SyntaxError,
        /** Referenced macro hasn't been defined in the document */
        UnknownMacro,
        /** Evaluated macro reference is invalid - this problem assumes that the origin problem is reported as well */
        InvalidMacroEvaluation,
        /** There is already the same pair for: documentId definition attribute & qualifier */
        DuplicateDocumentID,
        /** There is no such pair of documentId definition attribute & qualifier for the documentId reference attribute & qualifier */
        InvalidDocumentID,
        /** DocumentId definition and DocumentId reference have types that are not in the same type hierarchy */
        InvalidDocumentIDTypeHierarchy,
        /** Subtype is not specified at the beginning of record for the abstract type defined at the beginning of the header */
        SubtypeRequired,
        /** Subtype is not in type hierarchy of the header type or column type */
        InvalidSubtype,
        /** Type does not exist */
        InvalidType,
        /** Attribute does not exist as a field in the type specified at the beginning of the header */
        InvalidTypedAttribute,
        /** Attribute does not exist as a field in the type specified at the beginning of the header or */
        InvalidAttribute,
        /** type of the attribute does not exist */
        InvalidAttributeType,
        /** Field has no header attribute */
        FieldWithoutHeaderAttribute, ;
    }

    private int lineNumber;
    private int startPositionInRow;
    private int stopPositionInRow;
    private int startIndex;
    private int stopIndex;
    private Type type;
    private int length;
    private String text;
    private String messageCode;

    public ImpexProblem(final Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(final Type type) {
        this.type = type;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(final int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public int getStartPositionInRow() {
        return startPositionInRow;
    }

    public void setStartPositionInRow(final int startPositionInRow) {
        this.startPositionInRow = startPositionInRow;
    }

    public int getStopPositionInRow() {
        return stopPositionInRow;
    }

    public void setStopPositionInRow(final int stopPositionInRow) {
        this.stopPositionInRow = stopPositionInRow;
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

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return type.toString();
    }
}
