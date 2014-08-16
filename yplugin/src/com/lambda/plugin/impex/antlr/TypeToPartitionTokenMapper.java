package com.lambda.plugin.impex.antlr;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.jface.text.IDocument;

import com.lambda.impex.ast.ImpexLexer;

public class TypeToPartitionTokenMapper {

    private static final String MODE = "__block_partition_content_type";
    private static final String MACRO = "__macro_partition_content_type";
    // private static final String FIELD = "__field_partition_content_type";
    private static final String COMMENT = "__comment_partition_content_type";
    private static final String BEANSHELL = "__beanshell_partition_content_type";

    // private final Map<Integer, IToken> tokenMap = new HashMap<Integer, IToken>();

    private static final Map<Integer, String> map = new LinkedHashMap<Integer, String>();
    static {
        // map.put(ImpexLexer.Insert, MODE);
        // map.put(ImpexLexer.InsertUpdate, MODE);
        // map.put(ImpexLexer.Update, MODE);
        // map.put(ImpexLexer.Remove, MODE);
        map.put(ImpexLexer.Mode, MODE);
        map.put(ImpexLexer.Macrodef, MACRO);
        map.put(ImpexLexer.Macroref, MACRO);
        // map.put(ImpexLexer.Field, FIELD);
        map.put(ImpexLexer.Comment, COMMENT);
        map.put(ImpexLexer.BeanShell, BEANSHELL);
        map.put(null, IDocument.DEFAULT_CONTENT_TYPE);
    }

    public static String[] getContentTypes() {
        return map.values().toArray(new String[map.size()]);
    }

    public static String partitionType(int tokenType) {
        String partitionType = map.containsKey(tokenType) ? map.get(tokenType) : IDocument.DEFAULT_CONTENT_TYPE;
        return partitionType;
    }

    // public IToken getToken(int antlrTokenType, Object tokenData) {
    // IToken token = tokenMap.get(antlrTokenType);
    // if (token == null) {
    // token = new Token(tokenData);
    // tokenMap.put(antlrTokenType, token);
    // }
    // return token;
    // }
}
