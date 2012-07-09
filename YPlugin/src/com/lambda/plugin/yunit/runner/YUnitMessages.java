package com.lambda.plugin.yunit.runner;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class YUnitMessages {
	private static final String BUNDLE_NAME = "com.lambda.plugin.yunit.runner.YUnitMessages"; //$NON-NLS-1$

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	private YUnitMessages() {
	}

	public static String getFormattedString(String key, Object arg) {
		return MessageFormat.format(getString(key), new Object[] { arg });
	}

	public static String getFormattedString(String key, Object[] args) {
		return MessageFormat.format(getString(key), args);
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
