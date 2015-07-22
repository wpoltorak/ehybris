package com.lambda.plugin.impex.antlr;

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
import com.lambda.plugin.impex.preferences.PreferenceConstants;

public class AntlrTypeToStyleTokenMapper {

    private static final Map<Integer, String> tokenTypeToColorPreferenceKeyMap = initTokenTypeToColorPreferenceKeyMap();
    private static final Map<Integer, IToken> tokenTypeToTokenMap = initTokenTypeToTokenMap();

    private final IPreferenceStore preferenceStore;

    public AntlrTypeToStyleTokenMapper(IPreferenceStore preferenceStore) {
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
        return preferenceStore.getInt(colorKey + PreferenceConstants.IMPEX_EDITOR_STYLE_SUFFIX);
    }

    private static Map<Integer, String> initTokenTypeToColorPreferenceKeyMap() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(ImpexLexer.Mode, PreferenceConstants.COLOR_MODE);
        map.put(ImpexLexer.Type, PreferenceConstants.COLOR_TYPE);
        map.put(ImpexLexer.SkippedField, PreferenceConstants.COLOR_SKIPPED_FIELD);
        map.put(ImpexLexer.Macrodef, PreferenceConstants.COLOR_MACRO);
        map.put(ImpexLexer.Macroref, PreferenceConstants.COLOR_MACRO);
        map.put(ImpexLexer.Comment, PreferenceConstants.COLOR_COMMENT);
        map.put(ImpexLexer.DocumentID, PreferenceConstants.COLOR_DOCUMENTID);
        map.put(ImpexLexer.DocumentIdField, PreferenceConstants.COLOR_DOCUMENTID_FIELD);
        map.put(ImpexLexer.DocumentIdRefField, PreferenceConstants.COLOR_DOCUMENTID_FIELD);
        map.put(ImpexLexer.SpecialAttribute, PreferenceConstants.COLOR_SPECIAL_ATTRIBUTE);
        map.put(ImpexLexer.BooleanAttributeModifier, PreferenceConstants.COLOR_ATTRIBUTE_MODIFIER);
        map.put(ImpexLexer.ClassAttributeModifier, PreferenceConstants.COLOR_ATTRIBUTE_MODIFIER);
        map.put(ImpexLexer.DateFormatAttributeModifier, PreferenceConstants.COLOR_ATTRIBUTE_MODIFIER);
        map.put(ImpexLexer.IntAttributeModifier, PreferenceConstants.COLOR_ATTRIBUTE_MODIFIER);
        map.put(ImpexLexer.NumberFormatAttributeModifier, PreferenceConstants.COLOR_ATTRIBUTE_MODIFIER);
        map.put(ImpexLexer.TextAttributeModifier, PreferenceConstants.COLOR_ATTRIBUTE_MODIFIER);
        map.put(ImpexLexer.TextHeaderModifier, PreferenceConstants.COLOR_HEADER_MODIFIER);
        map.put(ImpexLexer.BooleanHeaderModifier, PreferenceConstants.COLOR_HEADER_MODIFIER);
        map.put(ImpexLexer.ClassHeaderModifier, PreferenceConstants.COLOR_HEADER_MODIFIER);
        map.put(ImpexLexer.BeanShell, PreferenceConstants.COLOR_BEANSHELL);
        map.put(ImpexLexer.UserRights, PreferenceConstants.COLOR_USERRIGHTS);
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
