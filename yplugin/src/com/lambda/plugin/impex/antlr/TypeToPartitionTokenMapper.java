package com.lambda.plugin.impex.antlr;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

public class TypeToPartitionTokenMapper {

    private final Map<Integer, IToken> tokenMap = new HashMap<Integer, IToken>();

    public IToken getToken(int antlrTokenType, Object tokenData) {
        IToken token = tokenMap.get(antlrTokenType);
        if (token == null) {
            token = new Token(tokenData);
            tokenMap.put(antlrTokenType, token);
        }
        return token;
    }
}
