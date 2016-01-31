package com.lambda.plugin.impex.model;

import org.antlr.v4.runtime.Token;
import org.eclipse.jface.text.IRegion;

public interface ILexerTokenRegion extends IRegion, Token {

    /**
     * Return ANTLR token
     * 
     * @return
     */
    Token getToken();
}
