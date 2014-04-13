package com.lambda.plugin.impex.antlr;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

import com.lambda.impex.ast.ImpexLexer;
import com.lambda.plugin.impex.editor.ColorManager;
import com.lambda.plugin.impex.editor.ImpexColorConstants;

public class TypeToStyleTokenMapper {

    private final Map<Integer, IToken> tokenMap = new HashMap<Integer, IToken>();
    private final ColorManager colorManager;

    private void initializeMap(ColorManager colorManager) {
        tokenMap.put(ImpexLexer.Insert,
                new Token(new TextAttribute(colorManager.getColor(ImpexColorConstants.IMPEX_HEADER_ARG))));
        tokenMap.put(ImpexLexer.InsertUpdate,
                new Token(new TextAttribute(colorManager.getColor(ImpexColorConstants.IMPEX_HEADER_ARG))));
        tokenMap.put(ImpexLexer.Update,
                new Token(new TextAttribute(colorManager.getColor(ImpexColorConstants.IMPEX_HEADER_ARG))));
        tokenMap.put(ImpexLexer.Remove,
                new Token(new TextAttribute(colorManager.getColor(ImpexColorConstants.IMPEX_MACRO))));
        tokenMap.put(ImpexLexer.Macrodef,
                new Token(new TextAttribute(colorManager.getColor(ImpexColorConstants.IMPEX_MACRO))));
        tokenMap.put(ImpexLexer.Field, new Token(new TextAttribute(colorManager.getColor(ImpexColorConstants.DEFAULT))));
        tokenMap.put(ImpexLexer.Comment, new Token(
                new TextAttribute(colorManager.getColor(ImpexColorConstants.COMMENT))));
        tokenMap.put(ImpexLexer.EOF, Token.EOF);
        tokenMap.put(ImpexLexer.Ws, Token.WHITESPACE);
        tokenMap.put(ImpexLexer.Lb, Token.WHITESPACE);
    }

    public TypeToStyleTokenMapper(ColorManager colorManager) {
        this.colorManager = colorManager;
        initializeMap(colorManager);
    }

    public IToken getToken(int antlrTokenType) {
        IToken token = tokenMap.get(antlrTokenType);
        if (token == null) {
            token = new Token(new TextAttribute(colorManager.getColor(ImpexColorConstants.DEFAULT)));
            tokenMap.put(antlrTokenType, token);
        }
        return token;
    }
}
