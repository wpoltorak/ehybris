package com.lambda.plugin.utils;

public class NumberUtils {

    public static int defaultIfNull(Integer value, int defaultValue) {
        return value == null ? defaultValue : value.intValue();
    }
}
