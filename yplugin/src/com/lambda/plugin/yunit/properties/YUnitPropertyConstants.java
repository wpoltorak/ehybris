package com.lambda.plugin.yunit.properties;

import java.util.Collections;
import java.util.List;

import com.lambda.plugin.YPlugin;

public class YUnitPropertyConstants {

	private YUnitPropertyConstants() {
	}

	/**
	 * List of active test filters. A String containing a comma separated list of
	 * fully qualified type names/patterns.
	 */
	public static final String PREF_ACTIVE_TEST_FILTERS_LIST = YPlugin.PLUGIN_ID + ".active_test_filters"; //$NON-NLS-1$

	/**
	 * List of inactive test filters. A String containing a comma separated list
	 * of fully qualified type names/patterns.
	 */
	public static final String PREF_INACTIVE_TEST_FILTERS_LIST = YPlugin.PLUGIN_ID + ".inactive_test_filters"; //$NON-NLS-1$	

	
	public static List<String> createDefaultTestFiltersList() {
		return Collections.<String>emptyList();
	}
	
	/**
	 * Serializes the array of strings into one comma separated string.
	 * 
	 * @param list
	 *          array of strings
	 * @return a single string composed of the given list
	 */
	public static String serializeList(String[] list) {
		if (list == null)
			return ""; //$NON-NLS-1$

		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < list.length; i++) {
			if (i > 0)
				buffer.append(',');

			buffer.append(list[i]);
		}
		return buffer.toString();
	}
}
