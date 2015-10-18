package com.lambda.plugin.utils;

public class StringUtils {

    private StringUtils() {
    }

    /**
     * Checks if a String is empty ("") or <code>null</code>.
     * 
     * @param str - string to check, can be <code>null</code>
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }
    /**
     * Checks if a String is not empty ("") and not <code>null</code>.
     * 
     * @param str - string to check, can be <code>null</code>
     * @return
     */
    public static boolean isNotEmpty(String str) {
        return str != null && !str.isEmpty();
    }

    /**
     * Capitalizes a String changing the first letter to title case as per {@link Character.toTitleCase(char)}. No other
     * letters are changed.
     * 
     * @param string - string to capitalize, can be <code>null</code>
     * @return the capitalized String, null if null String input
     */
    public static String capitalize(String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return str;
        }
        return new StringBuffer(strLen).append(Character.toTitleCase(str.charAt(0))).append(str.substring(1))
                .toString();
    }
}
