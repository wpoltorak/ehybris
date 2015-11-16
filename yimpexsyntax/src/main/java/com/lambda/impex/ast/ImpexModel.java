package com.lambda.impex.ast;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;

import com.lambda.impex.ast.ImpexParser.MacroValueContext;

public interface ImpexModel {

    /**
     * Registers new generic problem
     */
    void addProblem(final RecognitionException e);

    void addProblem(final ImpexProblem problem);

    void syntaxProblem(final int line, final Token token, final String msg, final RecognitionException e);

    void syntaxProblem(final int line, final int startIndex, final String msg, final RecognitionException e);

    boolean hasProblems();

    void addMacroValue(final String macrodefText, final Token macroDefiniton, final MacroValueContext macroValue);

    void addDocumentIDDefinitionQualifier(final DocumentIDDescription documentIDDescription, TypeDescription type, final Token symbol);

    void addDocumentIDReferenceQualifier(final DocumentIDDescription documentIDDescription, TypeDescription type, final Token symbol);

    void addType(int offset, final Object type);

    List<ImpexProblem> getProblems();

    Map<String, List<SimpleImmutableEntry<Integer, String>>> getMacros();

    Object getHyperlinkElement(final int tokenType, final int offset);

    void checkDocumentIDs();

    void reset();

    String getMacroValue(String name, int index);

	boolean containsProperty(String text);
}
