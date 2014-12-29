package com.lambda.plugin.impex.editor.occurrences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.lambda.impex.ast.ImpexParser.MacroContext;
import com.lambda.impex.ast.ImpexParser.MacrorefContext;
import com.lambda.plugin.impex.editor.ImpexDocument;

public class MacroOccurrencesFinder extends AbstractOccurrencesFinderAdapter implements OccurrencesFinder {

    public MacroOccurrencesFinder(ImpexDocument document, int offset) {
        super(document, offset);
    }

    private final Map<Token, List<Token>> macrodef2Macrorefs = new HashMap<>();
    private final Map<Integer, Token> offset2Macrodef = new HashMap<>();
    private final Map<String, Token> name2Macrodef = new HashMap<>();

    @Override
    public void exitMacro(MacroContext ctx) {
        TerminalNode macrodef = ctx.Macrodef();
        Token token = macrodef.getSymbol();
        String name = token.getText();
        name2Macrodef.put(name, token);
        offset2Macrodef.put(token.getStartIndex(), token);
    }

    @Override
    public void enterMacroref(MacrorefContext ctx) {
        final Token macrorefToken = ctx.Macroref().getSymbol();
        final Token macrodefToken = name2Macrodef.get(macrorefToken.getText());

        offset2Macrodef.put(macrorefToken.getStartIndex(), macrodefToken);
        addListValue(macrodef2Macrorefs, macrodefToken, macrorefToken);
    }

    @Override
    public List<Token> getOccurrences(int offset) {
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
}
