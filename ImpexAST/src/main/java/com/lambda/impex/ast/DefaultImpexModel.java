package com.lambda.impex.ast;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
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
    private final List<ImpexProblem> problems = new ArrayList<>();

    private final Map<Integer, TypeDescription> offset2Type = new HashMap<>();

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
    public void addMacroValue(final String macrodefText, final Token macroDefiniton, final MacroValueContext macroValue) {
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
        docIDDef2Type.put(documentIDDescription, type);
    }

    @Override
    public void addDocumentIDReferenceQualifier(final DocumentIDDescription documentIDDescription, final TypeDescription type,
            final Token symbol) {
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
