package com.lambda.plugin.impex.model;

import org.eclipse.jface.text.IRegion;

public interface ILexerTokenRegion extends IRegion {

    /**
     * Return ANTLR token type
     * 
     * @return
     */
    int getTokenType();
}
