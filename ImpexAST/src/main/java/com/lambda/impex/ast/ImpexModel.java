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
    void addProblem(RecognitionException e);

    void addProblem(ImpexProblem problem);

    void addProblem(Token token, Type type);

    void syntaxProblem(Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e);

    boolean hasProblems();

    void addMacroReference(Token macroDefiniton, Token macroReference);

    void addMacroValue(String macrodefText, Token macroDefiniton, MacroValueContext macroValue);

    List<ImpexProblem> getProblems();

    Map<String, List<SimpleImmutableEntry<Integer, String>>> getMacros();

    List<Token> getOccurrenceTokens(int tokenType, int offset);
}
