package com.kizoom.plugin;

import java.text.MessageFormat;

import org.eclipse.osgi.util.NLS;

public final class KizoomMessages extends NLS {

	private static final String BUNDLE_NAME= "com.kizoom.plugin.KizoomMessages";//$NON-NLS-1$
	
	static {
		NLS.initializeMessages(BUNDLE_NAME, KizoomMessages.class);
	}

	public static String format(String message, Object object) {
		return MessageFormat.format(message, new Object[] { object});
	}

	public static String format(String message, Object[] objects) {
		return MessageFormat.format(message, objects);
	}
	private KizoomMessages() {
		// Do not instantiate
	}
}
