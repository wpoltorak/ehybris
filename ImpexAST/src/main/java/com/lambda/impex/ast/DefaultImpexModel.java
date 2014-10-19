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

    private final List<ImpexProblem> problems = new ArrayList<>();
    private final Map<Token, List<Token>> macroReferences = new HashMap<>();
    private final Map<Token, MacroValueContext> macrosValues = new HashMap<>();
    /* Macro reference index to macro definition token */
    private final Map<Integer, Token> macroReferenceOffsetToDefinition = new HashMap<>();
    private final Map<Integer, Token> macroDefinitionOffsetToDefinition = new HashMap<>();

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
        macroReferenceOffsetToDefinition.put(macroReference.getStartIndex(), macroDefiniton);
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
        List<MacroValueContext> values = macros.get(macrodefText);
        if (values == null) {
            values = new ArrayList<>();
            macros.put(macrodefText, values);
        }
        values.add(macroValue);
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
}
