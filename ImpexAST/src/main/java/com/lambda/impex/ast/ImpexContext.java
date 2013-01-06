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
import org.antlr.runtime.Token;

import com.lambda.impex.ast.ImpexError.Type;

public class ImpexContext {
    private final Map<String, List<SimpleImmutableEntry<Integer, String>>> macros = new HashMap<String, List<SimpleImmutableEntry<Integer, String>>>();
    private final Set<String> documentIDs = new HashSet<String>();
    private final Pattern macroPattern = Pattern.compile("$[a-zA-Z_][a-zA-Z_0-9]*");
    private final List<ImpexError> errors = new ArrayList<ImpexError>();

    public ImpexContext() {
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public List<ImpexError> getErrors() {
        return errors;
    }

    public void addError(final ImpexError error) {
        errors.add(error);
    }

    Map<String, List<SimpleImmutableEntry<Integer, String>>> getMacros() {
        return macros;
    }

    Set<String> getDocumentIDs() {
        return documentIDs;
    }

    public boolean hasDocumentID(final String documentID) {
        return documentIDs.contains(documentID);
    }

    public String getMacroVal(final String macroDef, final int refLine) {
        final List<SimpleImmutableEntry<Integer, String>> list = macros.get(macroDef);
        if (list == null) {
            final ImpexError error = new ImpexError(Type.UnknownMacro);
            error.setLineNumber(refLine);
            error.setLength(macroDef.length());
            errors.add(error);
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

    void registerError(final RecognitionException e) {
        final ImpexError error = new ImpexError(ImpexError.Type.LexerSyntaxError);
        error.setLineNumber(e.line);
        error.setPositionInRow(e.charPositionInLine);
        error.setLength(1);
        error.setStartIndex(e.index);
        error.setStopIndex(e.index + 1);
        addError(error);
    }

    void registerError(final CommonToken token) {
        final ImpexError error = new ImpexError(ImpexError.Type.ParserSyntaxError);
        error.setLineNumber(token.getLine());
        error.setPositionInRow(token.getCharPositionInLine());
        error.setLength(token.getText().length());
        error.setStartIndex(token.getStartIndex());
        error.setStopIndex(token.getStopIndex());
        addError(error);
    }

    void registerMacro(final Token def, final String val) {
        final String macrodef = def.getText();
        List<SimpleImmutableEntry<Integer, String>> macroval = macros.get(macrodef);
        if (macroval == null) {
            macroval = new ArrayList<SimpleImmutableEntry<Integer, String>>();
            macros.put(macrodef, macroval);
        }
        macroval.add(new SimpleImmutableEntry<Integer, String>(def.getLine(), val == null ? "" : val));
    }

    void registerDocumentID(final CommonToken documentID) {
        final String text = documentID.getText();
        if (documentIDs.contains(text)) {
            final ImpexError error = new ImpexError(ImpexError.Type.DuplicateDocumentID);
            error.setLineNumber(documentID.getLine());
            error.setLength(text.length());
            error.setPositionInRow(documentID.getCharPositionInLine());
            error.setStartIndex(documentID.getStartIndex());
            error.setStopIndex(documentID.getStopIndex());
            errors.add(error);
            return;
        }
        documentIDs.add(text);
    }
}
