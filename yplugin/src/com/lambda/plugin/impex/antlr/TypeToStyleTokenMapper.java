package com.lambda.plugin.impex.antlr;

import static com.lambda.plugin.impex.preferences.PreferenceConstants.COLOR_BEANSHELL;
import static com.lambda.plugin.impex.preferences.PreferenceConstants.COLOR_COMMENT;
import static com.lambda.plugin.impex.preferences.PreferenceConstants.COLOR_MACRO;
import static com.lambda.plugin.impex.preferences.PreferenceConstants.COLOR_TYPE;
import static com.lambda.plugin.impex.preferences.PreferenceConstants.IMPEX_EDITOR_STYLE_SUFFIX;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.graphics.RGB;

import com.lambda.impex.ast.ImpexLexer;
import com.lambda.plugin.impex.editor.ColorManager;

public class TypeToStyleTokenMapper {

    private static final Map<Integer, String> tokenTypeToColorPreferenceKeyMap = inittokenTypeToColorPreferenceKeyMap();
    private static final Map<Integer, IToken> tokenTypeToTokenMap = initTokenTypeToTokenMap();

    private final IPreferenceStore preferenceStore;

    public TypeToStyleTokenMapper(IPreferenceStore preferenceStore) {
        this.preferenceStore = preferenceStore;
    }

    private static String getColorKey(int antlrTokenType) {
        String color = tokenTypeToColorPreferenceKeyMap.get(antlrTokenType);
        if (color == null) {
            color = IPreferenceStore.STRING_DEFAULT_DEFAULT;
        }
        return color;
    }

    public IToken getToken(int antlrTokenType) {
        if (tokenTypeToTokenMap.containsKey(antlrTokenType)) {
            return tokenTypeToTokenMap.get(antlrTokenType);
        }

        TextAttribute attribute = getTokenAttribute(antlrTokenType);
        return new Token(attribute);
    }

    private TextAttribute getTokenAttribute(int antlrTokenType) {
        String colorKey = getColorKey(antlrTokenType);
        RGB color = PreferenceConverter.getColor(preferenceStore, colorKey);
        // TODO add caching of text attributes??
        return new TextAttribute(ColorManager.getDefault().getColor(color), null, getStyle(colorKey));
    }

    private int getStyle(String colorKey) {
        return preferenceStore.getInt(colorKey + IMPEX_EDITOR_STYLE_SUFFIX);
    }

    private static Map<Integer, String> inittokenTypeToColorPreferenceKeyMap() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(ImpexLexer.Insert, COLOR_TYPE);
        map.put(ImpexLexer.InsertUpdate, COLOR_TYPE);
        map.put(ImpexLexer.Update, COLOR_TYPE);
        map.put(ImpexLexer.Remove, COLOR_TYPE);
        map.put(ImpexLexer.Macrodef, COLOR_MACRO);
        map.put(ImpexLexer.Comment, COLOR_COMMENT);
        map.put(ImpexLexer.BeanShell, COLOR_BEANSHELL);
        return map;
    }

    private static Map<Integer, IToken> initTokenTypeToTokenMap() {
        Map<Integer, IToken> map = new HashMap<Integer, IToken>();
        map.put(ImpexLexer.EOF, Token.EOF);
        map.put(ImpexLexer.Ws, Token.WHITESPACE);
        map.put(ImpexLexer.Lb, Token.WHITESPACE);
        return map;
    }

}
