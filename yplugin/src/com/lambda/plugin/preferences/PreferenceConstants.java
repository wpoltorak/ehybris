package com.lambda.plugin.preferences;

import com.lambda.plugin.YPlugin;

/**
 * Constant definitions for plug-in preferences
 */
public class PreferenceConstants {

    private static final String PREFIX = YPlugin.PLUGIN_ID + ".";

    // Platform preferences
    public static final String PLATFORMS_PREFERENCE_PAGE = PREFIX + "platforms_preference_page_context"; //$NON-NLS-1$
    public static final String PLATFORMS_XML = PREFIX + "platforms_xml";

    private PreferenceConstants() {
        // no instance
    }
}
