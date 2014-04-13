package com.lambda.plugin.impex.editor.syntaxcoloring;

import org.antlr.v4.runtime.Token;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.swt.SWT;

import com.lambda.impex.ast.ImpexLexer;
import com.lambda.plugin.impex.editor.ColorManager;
import com.lambda.plugin.impex.editor.ImpexColorConstants;

public class TokenFactory {

    private final ColorManager colorManager;

    public TokenFactory(final ColorManager colorManager) {
        this.colorManager = colorManager;
    }

    public IToken createToken(Token token) {
        if (token.getType() == org.antlr.v4.runtime.Token.EOF) {
            return org.eclipse.jface.text.rules.Token.EOF;
        }

        if (token.getType() == ImpexLexer.Macrodef) {
            return new TokenWrapper(token, new TextAttribute(colorManager.getColor(ImpexColorConstants.IMPEX_MACRO),
                    null, SWT.DEFAULT));
        }
        // new TextAttribute(color, oldAttr.getBackground(), oldAttr.getStyle());
        return new TokenWrapper(token, new TextAttribute(colorManager.getColor(ImpexColorConstants.DEFAULT), null,
                SWT.BOLD));
    }
}
