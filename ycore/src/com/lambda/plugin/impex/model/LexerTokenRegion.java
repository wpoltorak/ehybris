package com.lambda.plugin.impex.model;

import org.antlr.v4.runtime.Token;
import org.eclipse.jface.text.Region;

import com.lambda.impex.ast.ImpexLexer;

public class LexerTokenRegion extends Region implements ILexerTokenRegion {

    private final int tokenType;

    public LexerTokenRegion(int offset, int length, int tokenType) {
        super(offset, length);
        this.tokenType = tokenType;
    }

    @Override
    public int getTokenType() {
        return tokenType;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof ILexerTokenRegion) {
            ILexerTokenRegion r = (ILexerTokenRegion) o;
            return r.getTokenType() == tokenType && super.equals(o);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() | (tokenType << 8);
    }

    @Override
    public String toString() {
        return super.toString() + ", type: " + readType(tokenType); //$NON-NLS-2$;
    }

    public boolean isBlockStart() {
        return tokenType == ImpexLexer.Mode;
    }

    public boolean isEndOfFile() {
        return tokenType == Token.EOF;
    }

    // TODO remove at some point
    private static String readType(final int type) {
        switch (type) {
        case ImpexLexer.Mode:
            return "Mode                         ";
        case ImpexLexer.Type:
            return "Type                         ";
        case ImpexLexer.Separator:
            return "Separator                    ";
        case ImpexLexer.Macroref:
            return "Macroref                     ";
        case ImpexLexer.BooleanAttributeModifier:
            return "BooleanAttributeModifier     ";
        case ImpexLexer.IntAttributeModifier:
            return "IntAttributeModifier         ";
        case ImpexLexer.DateFormatAttributeModifier:
            return "DateFormatAttributeModifier  ";
        case ImpexLexer.NumberFormatAttributeModifier:
            return "NumberFormatAttributeModifier";
        case ImpexLexer.ClassAttributeModifier:
            return "ClassAttributeModifier       ";
        case ImpexLexer.TextAttributeModifier:
            return "TextAttributeModifier        ";
        case ImpexLexer.BooleanHeaderModifier:
            return "BooleanHeaderModifier        ";
        case ImpexLexer.ClassHeaderModifier:
            return "ClassHeaderModifier          ";
        case ImpexLexer.TextHeaderModifier:
            return "TextHeaderModifier           ";
        case ImpexLexer.Comma:
            return "Comma                        ";
        case ImpexLexer.Dot:
            return "Dot                          ";
        case ImpexLexer.DoubleQuote:
            return "DoubleQuote                  ";
        case ImpexLexer.Quote:
            return "Quote                        ";
        case ImpexLexer.LParenthesis:
            return "LParenthesis                 ";
        case ImpexLexer.RParenthesis:
            return "RParenthesis                 ";
        case ImpexLexer.Equals:
            return "Equals                       ";
        case ImpexLexer.Or:
            return "Or                           ";
        case ImpexLexer.LineSeparator:
            return "LineSeparator                ";
        case ImpexLexer.DocumentID:
            return "DocumentID                   ";
        case ImpexLexer.SpecialAttribute:
            return "SpecialAttribute             ";
        case ImpexLexer.Identifier:
            return "Identifier                   ";
        case ImpexLexer.Macrodef:
            return "Macrodef                     ";
        case ImpexLexer.UserRights:
            return "UserRights                   ";
        case ImpexLexer.BeanShell:
            return "BeanShell                    ";
        case ImpexLexer.Comment:
            return "Comment                      ";
        case ImpexLexer.Lb:
            return "Lb                           ";
        case ImpexLexer.Ws:
            return "Ws                           ";
        case ImpexLexer.Error:
            return "Error                        ";
        case ImpexLexer.FieldQuoted:
            return "FieldQuoted                  ";
        case ImpexLexer.Field:
            return "Field                        ";
        case ImpexLexer.FieldCommaSkipped:
            return "FieldCommaSkipped            ";
        case ImpexLexer.SkippedField:
            return "SkippedField                 ";
        case ImpexLexer.DocumentIdField:
            return "DocumentIdField              ";
        case ImpexLexer.DocumentIdRefField:
            return "DocumentIdRefField           ";
        case ImpexLexer.Macroval:
            return "Macroval                     ";
        case ImpexLexer.LBracket:
            return "LBracket                     ";
        case ImpexLexer.ABracket:
            return "ABracket                     ";
        case ImpexLexer.ModifierBracket:
            return "ModifierBracket              ";
        case ImpexLexer.UnknownModifier:
            return "UnknownModifier              ";
        case ImpexLexer.ModifiervalBracket:
            return "ModifiervalBracket           ";
        case ImpexLexer.Modifierval:
            return "Modifierval                  ";
        case ImpexLexer.EOF:
            return "EOF                          ";
        }
        return "?                            ";
    }
}
