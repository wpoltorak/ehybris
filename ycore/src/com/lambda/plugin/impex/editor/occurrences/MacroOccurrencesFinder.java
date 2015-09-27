package com.lambda.plugin.impex.editor.occurrences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.eclipse.jface.text.Position;

import com.lambda.impex.ast.ImpexParser.MacroContext;
import com.lambda.impex.ast.ImpexParser.MacrorefContext;

public class MacroOccurrencesFinder extends AbstractOccurrencesFinderAdapter implements OccurrencesFinder {

    public MacroOccurrencesFinder(int offset) {
        super(offset);
    }

    private final Map<Token, List<Position>> macrodef2Positions = new HashMap<>();
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
        if (ctx.Macroref() == null) {
            return;
        }
        final Token macrorefToken = ctx.Macroref().getSymbol();
        final Token macrodefToken = name2Macrodef.get(macrorefToken.getText());

        offset2Macrodef.put(macrorefToken.getStartIndex(), macrodefToken);
        addListValue(macrodef2Positions, macrodefToken, position(macrorefToken));
    }

    @Override
    public List<Position> getOccurrences() {
        final Token macrodef = offset2Macrodef.get(offset);
        if (macrodef == null) {
            return Collections.emptyList();
        }

        final List<Position> refs = macrodef2Positions.get(macrodef);
        if (refs != null) {
            refs.add(0, position(macrodef));
            return refs;
        }

        final List<Position> result = new ArrayList<>();
        result.add(position(macrodef));
        return result;
    }
}
