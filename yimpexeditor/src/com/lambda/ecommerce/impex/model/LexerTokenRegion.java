package com.lambda.ecommerce.impex.model;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenSource;
import org.eclipse.jface.text.Region;

import com.lambda.impex.ast.ImpexLexer;

public class LexerTokenRegion extends Region implements ILexerTokenRegion {

	private Token token;

    public LexerTokenRegion(Token token) {
        super(token.getStartIndex(), token.getStopIndex() - token.getStartIndex() + 1);
        this.token = token;
    }

    @Override
	public int getChannel() {
		return token.getChannel();
	}

	@Override
	public int getCharPositionInLine() {
		return token.getCharPositionInLine();
	}

	@Override
	public CharStream getInputStream() {
		return token.getInputStream();
	}

	@Override
	public int getLine() {
		return token.getLine();
	}

	@Override
	public int getStartIndex() {
		return token.getStartIndex();
	}

	@Override
	public int getStopIndex() {
		return token.getStopIndex();
	}

	@Override
	public String getText() {
		return token.getText();
	}

	@Override
	public int getTokenIndex() {
		return token.getTokenIndex();
	}

	@Override
	public TokenSource getTokenSource() {
		return token.getTokenSource();
	}

	@Override
	public int getType() {
		return token.getType();
	}

    @Override
    public Token getToken() {
    	return token;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof ILexerTokenRegion) {
            ILexerTokenRegion r = (ILexerTokenRegion) o;
            return r.getType() == getType() && super.equals(o);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() | (getType() << 8);
    }

    @Override
    public String toString() {
        return super.toString() + ", type: " + readType(getType()); //$NON-NLS-2$;
    }

    public boolean isBlockStart() {
        return getType() == ImpexLexer.Mode;
    }

    public boolean isEndOfFile() {
        return getType() == Token.EOF;
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
        case ImpexLexer.Bracket:
            return "Bracket                      ";
        case ImpexLexer.UnknownModifier:
            return "UnknownModifier              ";
        case ImpexLexer.Modifierval:
            return "Modifierval                  ";
        case ImpexLexer.EOF:
            return "EOF                          ";
        }
        return "?                            ";
    }
}
