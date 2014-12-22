package com.lambda.impex.ast;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;

import com.lambda.impex.ast.ImpexParser.MacroValueContext;
import com.lambda.impex.ast.ImpexProblem.Type;

public class DefaultImpexModel implements ImpexModel {
    private static final Pattern macroPattern = Pattern.compile("$\\[ \t]*\r?[\r\n][a-zA-Z_](?:(?:\\[ \t]*\r?[\r\n])[a-zA-Z_0-9])*");
    private final Map<String, List<MacroValueContext>> macros = new HashMap<>();

    /**
     * documentID definition
     * 
     */
    private final Map<DocumentIDQualifier, String> documentIDs = new HashMap<>();
    //    private final Map<DocumentIDQualifier, String> documentIDReferences = new HashMap<>();

    private final List<ImpexProblem> problems = new ArrayList<>();
    private final Map<Token, List<Token>> macroReferences = new HashMap<>();
    private final Map<String, List<Token>> typeName2Tokens = new HashMap<>();
    private final Map<Integer, TypeDescription> typeOffset2Text = new HashMap<>();
    private final Map<Token, MacroValueContext> macrosValues = new HashMap<>();
    /* Macro reference index to macro definition token */
    private final Map<Integer, Token> macroReferenceOffsetToDefinition = new HashMap<>();
    private final Map<Integer, Token> macroDefinitionOffsetToDefinition = new HashMap<>();

    //    private final Map<Integer, Token> offset2IDDescriptions = new HashMap<>();
    //    private final Map<Integer, Token> documentIDReferences = new HashMap<>();
    private final Map<DocumentIDDescription, List<Token>> documentIDReferences = new HashMap<>();
    private final Map<Integer, DocumentIDDescription> offset2DocumentID = new HashMap<>();

    @Override
    public void addProblem(final RecognitionException e) {
        final ImpexProblem error = new ImpexProblem(Type.GeneralSyntaxError);
        error.setText(e.getMessage());
        addProblem(error);
    }

    @Override
    public void syntaxProblem(final int line, final int startIndex, final String msg, final RecognitionException e) {
        if (!problems.isEmpty()) {
            final ImpexProblem last = problems.get(problems.size() - 1);
            if (last.getLineNumber() == line && last.getStopIndex() == startIndex && last.getType() == ImpexProblem.Type.SyntaxError) {
                last.setLength(last.getLength() + 1);
                last.setStopIndex(startIndex + 1);
                return;
            }
        }

        final ImpexProblem problem = new ImpexProblem(ImpexProblem.Type.SyntaxError);
        problem.setLineNumber(line);
        problem.setText(msg);
        problem.setStartIndex(startIndex);
        problem.setStopIndex(startIndex + 1);
        addProblem(problem);
    }

    @Override
    public void syntaxProblem(final int line, final Token token, final String msg, final RecognitionException e) {
        final ImpexProblem problem = new ImpexProblem(ImpexProblem.Type.SyntaxError);
        problem.setLineNumber(line);
        problem.setText(msg);
        problem.setLength(token.getStopIndex() - token.getStartIndex() + 1);
        problem.setStartIndex(token.getStartIndex());
        problem.setStopIndex(token.getStopIndex());
        addProblem(problem);
    }

    @Override
    public void addProblem(final ImpexProblem problem) {
        problems.add(problem);

    }

    @Override
    public void addProblem(final Token token, final Type type) {
        final ImpexProblem problem = new ImpexProblem(type);
        problem.setLineNumber(token.getLine());
        problem.setLength(token.getStopIndex() - token.getStartIndex() + 1);
        problem.setStartIndex(token.getStartIndex());
        problem.setStopIndex(token.getStopIndex());
        problem.setText(token.getText());
        addProblem(problem);
    }

    public void addDocumentIDQualifier(final String qualifier, final String documentID, final String type) {
        documentIDs.put(new DocumentIDQualifier(qualifier, documentID), type);
    }

    @Override
    public void addMacroReference(final Token macroDefiniton, final Token macroReference) {
        macroReferenceOffsetToDefinition.put(macroReference.getStartIndex(), macroDefiniton);
        addListValue(macroReferences, macroDefiniton, macroReference);
        List<Token> list = macroReferences.get(macroDefiniton);
        if (list == null) {
            list = new ArrayList<>();
            macroReferences.put(macroDefiniton, list);
        }
        list.add(macroReference);
    }

    @Override
    public void addMacroValue(final String macrodefText, final Token macroDefiniton, final MacroValueContext macroValue) {
        macrosValues.put(macroDefiniton, macroValue);
        macroDefinitionOffsetToDefinition.put(macroDefiniton.getStartIndex(), macroDefiniton);
        addListValue(macros, macrodefText, macroValue);
    }

    @Override
    public void addDocumentIDDefinitionQualifier(final DocumentIDDescription documentIDDescription, final Token symbol) {
        addListValue(documentIDReferences, documentIDDescription, symbol);
        offset2DocumentID.put(symbol.getStartIndex(), documentIDDescription);
    }

    @Override
    public void addDocumentIDReferenceQualifier(final DocumentIDDescription documentIDDescription, final Token symbol) {
        addListValue(documentIDReferences, documentIDDescription, symbol);
        offset2DocumentID.put(symbol.getStartIndex(), documentIDDescription);
    }

    private <T, R> void addListValue(final Map<R, List<T>> map, final R key, final T value) {
        List<T> values = map.get(key);
        if (values == null) {
            values = new ArrayList<>();
            map.put(key, values);
        }
        values.add(value);
    }

    @Override
    public void addType(final TypeDescription type, final Token token) {
        typeOffset2Text.put(token.getStartIndex(), type);
        addListValue(typeName2Tokens, type.getName(), token);
    }

    @Override
    public boolean hasProblems() {
        return !problems.isEmpty();
    }

    public List<ImpexProblem> getProblems() {
        return problems;
    }

    //    private String getMacroValue(final String macroDef, final int refLine) {
    //        final List<SimpleImmutableEntry<Integer, String>> list = macros.get(macroDef);
    //        if (list == null) {
    //            final ImpexProblem error = new ImpexProblem(Type.UnknownMacro);
    //            error.setLineNumber(refLine);
    //            error.setLength(macroDef.length());
    //            problems.add(error);
    //            return macroDef;
    //        }
    //
    //        for (int i = list.size() - 1; i >= 0; --i) {
    //            final SimpleImmutableEntry<Integer, String> entry = list.get(i);
    //            if (entry.getKey().intValue() < refLine) {
    //                String val = entry.getValue();
    //                final Matcher m = macroPattern.matcher(val);
    //                while (m.find()) {
    //                    final String nestedMacroDef = m.group();
    //                    final String nestedVal = getMacroValue(nestedMacroDef, entry.getKey());
    //                    val = m.replaceFirst(nestedVal);
    //                }
    //                return val;
    //            }
    //        }
    //        return macroDef;
    //    }

    public Map<String, List<SimpleImmutableEntry<Integer, String>>> getMacros() {
        //        return macros;
        return null;
    }

    @Override
    public List<Token> getOccurrenceTokens(final int tokenType, final int offset) {
        switch (tokenType) {
            case ImpexLexer.Macrodef:
            case ImpexLexer.Macroref:
                return getMacroOccurrenceTokens(tokenType, offset);
            case ImpexLexer.DocumentID:
                return getDocumentIDOccurrenceTokens(tokenType, offset);
            case ImpexLexer.DocumentIdField:
            case ImpexLexer.DocumentIdRefField:
                return getDocumentIDQualifierOccurrenceTokens(tokenType, offset);
            case ImpexLexer.Type:
                return getTypeOccurrenceTokens(offset);
        }
        return Collections.emptyList();
    }

    private List<Token> getTypeOccurrenceTokens(final int offset) {
        final TypeDescription type = typeOffset2Text.get(offset);
        final List<Token> result = typeName2Tokens.get(type.getName());
        if (result != null) {
            return result;
        }
        return Collections.emptyList();
    }

    private List<Token> getMacroOccurrenceTokens(final int tokenType, final int offset) {
        Token macrodef = null;
        if (tokenType == ImpexLexer.Macrodef) {
            macrodef = macroDefinitionOffsetToDefinition.get(offset);
        } else if (tokenType == ImpexLexer.Macroref) {
            macrodef = macroReferenceOffsetToDefinition.get(offset);
        }
        if (macrodef == null) {
            return Collections.emptyList();
        }

        final List<Token> result = new ArrayList<>();
        result.add(macrodef);
        final List<Token> refs = macroReferences.get(macrodef);
        if (refs != null) {
            result.addAll(refs);
        }
        return result;
    }

    private List<Token> getDocumentIDOccurrenceTokens(final int tokenType, final int offset) {
        final List<Token> result = new ArrayList<>();
        return result;
    }

    private List<Token> getDocumentIDQualifierOccurrenceTokens(final int tokenType, final int offset) {
        final DocumentIDDescription documentID = offset2DocumentID.get(offset);
        if (documentID == null) {
            return Collections.emptyList();
        }
        final List<Token> result = new ArrayList<>();
        final List<Token> list = documentIDReferences.get(documentID);
        if (list != null) {
            result.addAll(list);
        }
        return result;
    }

    @Override
    public Object getHyperlinkElement(final int tokenType, final int offset) {
        switch (tokenType) {
            case ImpexLexer.Type:
                final TypeDescription type = typeOffset2Text.get(offset);
                return type.getTarget();
            default:
                return null;
        }
    }
}
