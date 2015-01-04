package com.lambda.impex.ast;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;

import com.lambda.impex.ast.ImpexParser.MacroValueContext;
import com.lambda.impex.ast.ImpexProblem.Type;

public interface ImpexModel {

    /**
     * Registers new generic problem
     *
     * @param e
     */
    void addProblem(final RecognitionException e);

    void addProblem(final ImpexProblem problem);

    void addProblem(final Token token, final Type type);

    void syntaxProblem(final int line, final Token token, final String msg, final RecognitionException e);

    void syntaxProblem(final int line, final int startIndex, final String msg, final RecognitionException e);

    boolean hasProblems();

    void addMacroValue(final String macrodefText, final Token macroDefiniton, final MacroValueContext macroValue);

    void addDocumentIDDefinitionQualifier(final DocumentIDDescription documentIDDescription, TypeDescription type, final Token symbol);

    void addDocumentIDReferenceQualifier(final DocumentIDDescription documentIDDescription, TypeDescription type, final Token symbol);

    void addType(final TypeDescription type, final Token token);

    List<ImpexProblem> getProblems();

    Map<String, List<SimpleImmutableEntry<Integer, String>>> getMacros();

    Object getHyperlinkElement(final int tokenType, final int offset);

    void checkDocumentIDs();

    void reset();
}
