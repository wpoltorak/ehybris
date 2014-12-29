package com.lambda.plugin.impex.editor.occurrences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.Token;

import com.lambda.impex.ast.DocumentIDDescription;
import com.lambda.impex.ast.ImpexParser.AttributeContext;
import com.lambda.impex.ast.ImpexParser.DocumentIdDefinitionContext;
import com.lambda.impex.ast.ImpexParser.DocumentIdFieldContext;
import com.lambda.impex.ast.ImpexParser.DocumentIdRefFieldContext;
import com.lambda.impex.ast.ImpexParser.DocumentIdReferenceContext;
import com.lambda.impex.ast.ImpexParser.FieldContext;
import com.lambda.impex.ast.ImpexParser.HeaderContext;
import com.lambda.impex.ast.ImpexParser.RecordContext;
import com.lambda.impex.ast.TypeDescription;
import com.lambda.plugin.impex.editor.ImpexDocument;

public class DocumentIdQualifierOccurrencesFinder extends AbstractOccurrencesFinderAdapter implements OccurrencesFinder {

    private final List<String> definitions = new ArrayList<>();
    private int columnIndex;
    private String definition;

    private final Map<DocumentIDDescription, List<Token>> documentIDReferences = new HashMap<>();
    private final Map<Integer, DocumentIDDescription> offset2DocumentID = new HashMap<>();
    private final Map<DocumentIDDescription, TypeDescription> docIDDef2Type = new HashMap<>();

    public DocumentIdQualifierOccurrencesFinder(ImpexDocument document, int offset) {
        super(document, offset);
    }

    @Override
    public void enterHeader(final HeaderContext ctx) {
        definitions.clear();
    }

    @Override
    public void exitAttribute(final AttributeContext ctx) {
        definitions.add(definition);
        definition = null;
    }

    @Override
    public void enterDocumentIdReference(final DocumentIdReferenceContext ctx) {
        definition = ctx.DocumentID().getText();
    }

    @Override
    public void enterDocumentIdDefinition(final DocumentIdDefinitionContext ctx) {
        definition = ctx.DocumentID().getText();
    }

    @Override
    public void enterRecord(final RecordContext ctx) {
        columnIndex = -1;
    }

    @Override
    public void enterField(final FieldContext ctx) {
        columnIndex++;
    }

    @Override
    public void enterDocumentIdField(final DocumentIdFieldContext ctx) {
        if (columnIndex >= definitions.size()) {
            return;
        }
        final String definition = definitions.get(columnIndex);
        Token token = ctx.DocumentIdField().getSymbol();

        DocumentIDDescription documentIDDescription = new DocumentIDDescription(definition, token.getText());
        final TypeDescription existing = docIDDef2Type.get(documentIDDescription);
        if (existing != null) {
            return;
        }
        addListValue(documentIDReferences, documentIDDescription, token, 0);
        offset2DocumentID.put(token.getStartIndex(), documentIDDescription);
    }

    @Override
    public void enterDocumentIdRefField(final DocumentIdRefFieldContext ctx) {
        if (columnIndex >= definitions.size()) {
            return;
        }
        final String definition = definitions.get(columnIndex);
        Token token = ctx.DocumentIdRefField().getSymbol();

        DocumentIDDescription documentIDDescription = new DocumentIDDescription(definition, token.getText());

        addListValue(documentIDReferences, documentIDDescription, token);
        offset2DocumentID.put(token.getStartIndex(), documentIDDescription);
    }

    @Override
    protected List<Token> getOccurrences(int offset) {
        final DocumentIDDescription documentID = offset2DocumentID.get(offset);
        if (documentID == null) {
            return Collections.emptyList();
        }
        final List<Token> result = documentIDReferences.get(documentID);
        if (result == null) {
            Collections.emptyList();
        }
        return result;
    }
}
