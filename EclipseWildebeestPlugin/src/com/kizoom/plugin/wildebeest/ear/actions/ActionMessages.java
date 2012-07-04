package com.kizoom.plugin.wildebeest.ear.actions;

import org.eclipse.osgi.util.NLS;

public final class ActionMessages extends NLS {

	private static final String BUNDLE_NAME = "com.kizoom.plugin.actions.ActionMessages";//$NON-NLS-1$

	private ActionMessages() {
		// Do not instantiate
	}

	public static String ShowInEarViewAction_label;
	public static String ShowInEarViewAction_description;
	public static String ShowInEarViewAction_tooltip;
	public static String ShowInEarViewAction_dialog_title;
	public static String ShowInEarViewAction_error_message;

	static {
		NLS.initializeMessages(BUNDLE_NAME, ActionMessages.class);
	}
}
