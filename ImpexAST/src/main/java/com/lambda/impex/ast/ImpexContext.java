package com.lambda.impex.ast;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.RecognitionException;

import com.lambda.impex.ast.ImpexProblem.Type;

public class ImpexContext {
    private final Map<String, List<SimpleImmutableEntry<Integer, String>>> macros = new HashMap<String, List<SimpleImmutableEntry<Integer, String>>>();
    private final Map<String, CommonToken> documentIDs = new HashMap<String, CommonToken>();
    private final Set<String> duplicateDocumentIDs = new HashSet<String>();
    private final Pattern macroPattern = Pattern.compile("$\\[ \t]*\r?[\r\n][a-zA-Z_](?:(?:\\[ \t]*\r?[\r\n])[a-zA-Z_0-9])*");
    private final List<ImpexProblem> problems = new ArrayList<ImpexProblem>();
    private int[] lineEndNumbers;

    public ImpexContext() {
    }

    public boolean hasProblems() {
        return !problems.isEmpty();
    }

    public List<ImpexProblem> getProblems() {
        return problems;
    }

    public void addProblem(final ImpexProblem problem) {
        problems.add(problem);
    }

    Map<String, List<SimpleImmutableEntry<Integer, String>>> getMacros() {
        return macros;
    }

    Set<String> getDocumentIDs() {
        return documentIDs.keySet();
    }

    public boolean hasDocumentID(final String documentID) {
        return documentIDs.containsKey(documentID);
    }

    public String getMacroVal(final String macroDef, final int refLine) {
        final List<SimpleImmutableEntry<Integer, String>> list = macros.get(macroDef);
        if (list == null) {
            final ImpexProblem error = new ImpexProblem(Type.UnknownMacro);
            error.setLineNumber(refLine);
            error.setLength(macroDef.length());
            problems.add(error);
            return macroDef;
        }

        for (int i = list.size() - 1; i >= 0; --i) {
            final SimpleImmutableEntry<Integer, String> entry = list.get(i);
            if (entry.getKey().intValue() < refLine) {
                String val = entry.getValue();
                final Matcher m = macroPattern.matcher(val);
                while (m.find()) {
                    final String nestedMacroDef = m.group();
                    final String nestedVal = getMacroVal(nestedMacroDef, entry.getKey());
                    val = m.replaceFirst(nestedVal);
                }
                return val;
            }
        }
        return macroDef;
    }

    void registerProblem(final RecognitionException e) {
        final ImpexProblem problem = new ImpexProblem(ImpexProblem.Type.LexerSyntaxError);
        problem.setLineNumber(e.line);
        problem.setPositionInRow(e.charPositionInLine);
        problem.setLength(1);
        problem.setStartIndex(e.index);
        problem.setStopIndex(e.index + 1);

        addProblem(problem);
    }

    void registerProblem(final CommonToken token) {
        registerProblem(token, ImpexProblem.Type.ParserSyntaxError);
    }

    void registerProblem(final CommonToken token, final ImpexProblem.Type type) {
        final ImpexProblem problem = new ImpexProblem(type);
        problem.setLineNumber(token.getLine());
        problem.setPositionInRow(token.getCharPositionInLine());
        problem.setLength(token.getText().length());
        problem.setStartIndex(token.getStartIndex());
        problem.setStopIndex(token.getStopIndex());
        problem.setText(token.getText());
        addProblem(problem);
    }

    void registerMacro(final String def, final String val, final int line) {
        List<SimpleImmutableEntry<Integer, String>> macroval = macros.get(def);
        if (macroval == null) {
            macroval = new ArrayList<SimpleImmutableEntry<Integer, String>>();
            macros.put(def, macroval);
        }
        macroval.add(new SimpleImmutableEntry<Integer, String>(line, val == null ? "" : val));
    }

    void registerDocumentID(final CommonToken documentID) {
        final String text = documentID.getText();
        if (documentIDs.containsKey(text)) {
            registerProblem(documentID, ImpexProblem.Type.DuplicateDocumentID);

            //if it is the first duplicate report error for original documentID as well 
            if (!duplicateDocumentIDs.contains(text)) {
                registerProblem(documentIDs.get(text), ImpexProblem.Type.DuplicateDocumentID);
                duplicateDocumentIDs.add(text);
            }
            return;
        }
        documentIDs.put(text, documentID);
    }
}
