package com.lambda.plugin.impex.antlr;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.jface.text.IDocument;

import com.lambda.impex.ast.ImpexLexer;

public class AntlrTypeToPartitionTokenMapper {

    private static final String MODE = "__block_partition_content_type";
    private static final String MACRO = "__macro_partition_content_type";
    // private static final String FIELD = "__field_partition_content_type";
    private static final String COMMENT = "__comment_partition_content_type";
    private static final String BEANSHELL = "__beanshell_partition_content_type";

    // private final Map<Integer, IToken> tokenMap = new HashMap<Integer, IToken>();

    private static final Map<Integer, String> map = new LinkedHashMap<>();
    private static final Map<String, String[]> defaultPrefixesMap = new HashMap<>();
    static {
        defaultPrefixesMap.put(COMMENT, new String[] { "#" });
        defaultPrefixesMap.put(IDocument.DEFAULT_CONTENT_TYPE, new String[] { "#" });
        defaultPrefixesMap.put(BEANSHELL, new String[] { "#" });
        defaultPrefixesMap.put(MACRO, new String[] { "#" });
        // defaultPrefixMap.put(IDocument.DEFAULT_CONTENT_TYPE, "#");
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

    public static String[] defaultPrefixes(String partitionType) {
        return defaultPrefixesMap.get(partitionType);
    }
}
