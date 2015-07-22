package com.lambda.plugin.core;

import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.lambda.plugin.utils.StringUtils;

public class PropertiesSubstitution {

    private static final Pattern PATTERN = Pattern.compile("\\$\\{([a-zA-Z0-9\\._]+)\\}");

    /**
     * Evaluates all property values from the given <code>properties</code>. Replaces all strings surrounded by
     * <code>${}</code> with appropriate values from given <code>properties</code> as long as their keys match
     * surrounded strings
     * 
     * @param properties
     */
    public static void evaluate(Properties properties) {
        Set<Entry<Object, Object>> entrySet = properties.entrySet();
        for (Entry<Object, Object> entry : entrySet) {
            evaluate(properties, entry);
        }
    }

    private static void evaluate(Properties properties, Entry<Object, Object> entry) {
        String value = (String) entry.getValue();
        String evaluated = evaluate(properties, value);
        if (StringUtils.isNotEmpty(evaluated)) {
            entry.setValue(evaluated);
            evaluate(properties, entry);
        }
    }

    /**
     * Evaluates given <code>value</code>. Replaces all strings surrounded by <code>${}</code> with appropriate values
     * from given <code>properties</code> as long as their keys match surrounded strings
     * 
     * @param properties
     * @param value
     * @return
     */
    public static String evaluate(Properties properties, String value) {
        if (value == null) {
            return value;
        }
        Matcher m = PATTERN.matcher(value);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            String propertyRef = m.group(1);
            String property = properties.getProperty(propertyRef);
            if (StringUtils.isNotEmpty(property)) {
                m.appendReplacement(sb, property);
            }
        }
        if (sb.length() > 0) {
            m.appendTail(sb);
        }
        return sb.toString();
    }
}
