package com.lambda.plugin.utils;

public class StringUtils {

    private StringUtils() {
    }

    public static boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static boolean isNotEmpty(String string) {
        return string != null && !string.isEmpty();
    }

}
