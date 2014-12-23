package com.lambda.impex.ast;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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

    private final Map<Token, List<Token>> macrodef2Macrorefs = new HashMap<>();
    private final Map<Integer, Token> offset2Macrodef = new HashMap<>();

    private final Map<String, List<Token>> typename2Tokens = new HashMap<>();
    private final Map<Integer, TypeDescription> offset2Type = new HashMap<>();

    private final Map<DocumentIDDescription, List<Token>> documentIDReferences = new HashMap<>();
    private final Map<Integer, DocumentIDDescription> offset2DocumentID = new HashMap<>();

    private final Map<DocumentIDDescription, Map<Token, TypeDescription>> docIDRef2Type = new HashMap<>();
    private final Map<DocumentIDDescription, TypeDescription> docIDDef2Type = new HashMap<>();

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

    @Override
    public void addMacroReference(final Token macroDefiniton, final Token macroReference) {
        offset2Macrodef.put(macroReference.getStartIndex(), macroDefiniton);
        addListValue(macrodef2Macrorefs, macroDefiniton, macroReference);
        List<Token> list = macrodef2Macrorefs.get(macroDefiniton);
        if (list == null) {
            list = new ArrayList<>();
            macrodef2Macrorefs.put(macroDefiniton, list);
        }
        list.add(macroReference);
    }

    @Override
    public void addMacroValue(final String macrodefText, final Token macroDefiniton, final MacroValueContext macroValue) {
        offset2Macrodef.put(macroDefiniton.getStartIndex(), macroDefiniton);
        addListValue(macros, macrodefText, macroValue);
    }

    @Override
    public void addDocumentIDDefinitionQualifier(final DocumentIDDescription documentIDDescription, final TypeDescription type,
            final Token symbol) {
        final TypeDescription existing = docIDDef2Type.get(documentIDDescription);
        if (existing != null) {
            addProblem(symbol, Type.DuplicateDocumentID);
            return;
        }
        addListValue(documentIDReferences, documentIDDescription, symbol);
        offset2DocumentID.put(symbol.getStartIndex(), documentIDDescription);

        docIDDef2Type.put(documentIDDescription, type);
    }

    @Override
    public void addDocumentIDReferenceQualifier(final DocumentIDDescription documentIDDescription, final TypeDescription type,
            final Token symbol) {
        addListValue(documentIDReferences, documentIDDescription, symbol);
        offset2DocumentID.put(symbol.getStartIndex(), documentIDDescription);

        addMapValue(docIDRef2Type, documentIDDescription, symbol, type);
    }

    public void checkDocumentIDs() {
        for (final Entry<DocumentIDDescription, Map<Token, TypeDescription>> entry : docIDRef2Type.entrySet()) {
            final DocumentIDDescription docid = entry.getKey();
            final TypeDescription type = docIDDef2Type.get(docid);

            for (final Entry<Token, TypeDescription> reftype : entry.getValue().entrySet()) {
                if (type == null) {
                    addProblem(reftype.getKey(), Type.InvalidDocumentID);
                } else if (!type.equals(reftype.getValue()) && !reftype.getValue().isParentOf(type.getName())) {
                    addProblem(reftype.getKey(), Type.InvalidDocumentIDTypeHierarchy);
                }
            }
        }
    }

    private <Key, Value> void addListValue(final Map<Key, List<Value>> map, final Key key, final Value value) {
        List<Value> values = map.get(key);
        if (values == null) {
            values = new ArrayList<>();
            map.put(key, values);
        }
        values.add(value);
    }

    private <Key, ValueKey, Value> void addMapValue(final Map<Key, Map<ValueKey, Value>> map, final Key key, final ValueKey valueKey,
            final Value value) {
        Map<ValueKey, Value> values = map.get(key);
        if (values == null) {
            values = new HashMap<>();
            map.put(key, values);
        }
        values.put(valueKey, value);
    }

    @Override
    public void addType(final TypeDescription type, final Token token) {
        offset2Type.put(token.getStartIndex(), type);
        addListValue(typename2Tokens, type.getName(), token);
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
        final TypeDescription type = offset2Type.get(offset);
        final List<Token> result = typename2Tokens.get(type.getName());
        if (result != null) {
            return result;
        }
        return Collections.emptyList();
    }

    private List<Token> getMacroOccurrenceTokens(final int tokenType, final int offset) {
        final Token macrodef = offset2Macrodef.get(offset);
        if (macrodef == null) {
            return Collections.emptyList();
        }

        final List<Token> result = new ArrayList<>();
        result.add(macrodef);
        final List<Token> refs = macrodef2Macrorefs.get(macrodef);
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
                final TypeDescription type = offset2Type.get(offset);
                return type.getTarget();
            default:
                return null;
        }
    }
}
