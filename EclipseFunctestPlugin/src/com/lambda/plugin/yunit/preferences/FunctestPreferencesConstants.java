package com.lambda.plugin.yunit.preferences;

import java.util.Arrays;
import java.util.List;

import com.lambda.plugin.yunit.FunctestPlugin;

/**
 * Defines constants which are used to refer to values in the plugin's
 * preference store.
 */
public class FunctestPreferencesConstants {
	
	public static final String DEFAULT_JUNIT_VERSION = FunctestPlugin.PLUGIN_ID + ".default_junit_version"; //$NON-NLS-1$ 
	/**
	 * Boolean preference controlling whether the failure stack should be
	 * filtered.
	 */
	public static final String DO_FILTER_STACK = FunctestPlugin.PLUGIN_ID + ".do_filter_stack"; //$NON-NLS-1$

	/**
	 * Boolean preference controlling whether the JUnit view should be shown on
	 * errors only.
	 */
	public static final String SHOW_ON_ERROR_ONLY = FunctestPlugin.PLUGIN_ID + ".show_on_error"; //$NON-NLS-1$

	/**
	 * Boolean preference controlling whether the JUnit view should be shown on
	 * errors only.
	 */
	public static final String ENABLE_ASSERTIONS = FunctestPlugin.PLUGIN_ID + ".enable_assertions"; //$NON-NLS-1$

	/**
	 * List of active stack filters. A String containing a comma separated list of
	 * fully qualified type names/patterns.
	 */
	public static final String PREF_ACTIVE_STACK_FILTERS_LIST = FunctestPlugin.PLUGIN_ID + ".active_stack_filters"; //$NON-NLS-1$

	/**
	 * List of inactive stack filters. A String containing a comma separated list
	 * of fully qualified type names/patterns.
	 */
	public static final String PREF_INACTIVE_STACK_FILTERS_LIST = FunctestPlugin.PLUGIN_ID + ".inactive_stack_filters"; //$NON-NLS-1$	
	
	/**
	 * Maximum number of remembered test runs.
	 */
	public static final String MAX_TEST_RUNS = FunctestPlugin.PLUGIN_ID + ".max_test_runs"; //$NON-NLS-1$

	/**
	 * Javadoc location for JUnit 3
	 */
	public static final String JUNIT3_JAVADOC = FunctestPlugin.PLUGIN_ID + ".junit3.javadoclocation"; //$NON-NLS-1$

	/**
	 * Javadoc location for JUnit 4
	 */
	public static final String JUNIT4_JAVADOC = FunctestPlugin.PLUGIN_ID + ".junit4.javadoclocation"; //$NON-NLS-1$

	private static final String[] fgDefaultFilterPatterns = new String[] { "com.kizoom.functest.avantgo.*", //$NON-NLS-1$
			"com.kizoom.functest.chtml.*", //$NON-NLS-1$
			"com.kizoom.functest.defaultwebapp.*", //$NON-NLS-1$
			"com.kizoom.functest.dlr.*", //$NON-NLS-1$
			"com.kizoom.functest.general.*", //$NON-NLS-1$
			"com.kizoom.functest.kizoom.portal.*", //$NON-NLS-1$
			"com.kizoom.functest.nexus.*", //$NON-NLS-1$
			"com.kizoom.functest.nre.*", //$NON-NLS-1$
			"com.kizoom.functest.o2.*", //$NON-NLS-1$
			"com.kizoom.functest.oldintegratedrail.*", //$NON-NLS-1$
			"com.kizoom.functest.oldmytrains.*", //$NON-NLS-1$
			"com.kizoom.functest.orange.*", //$NON-NLS-1$
			"com.kizoom.functest.payments.*", //$NON-NLS-1$
			"com.kizoom.functest.railtrack.*", //$NON-NLS-1$
			"com.kizoom.functest.realtime.*", //$NON-NLS-1$
			"com.kizoom.functest.sms_simulator.*", //$NON-NLS-1$
			"com.kizoom.functest.selta.kiosk.*", //$NON-NLS-1$
			"com.kizoom.functest.textme.*", //$NON-NLS-1$
			"com.kizoom.functest.tflalerts.*", //$NON-NLS-1$
			"com.kizoom.functest.tfl.journeyplanner.*", //$NON-NLS-1$
			"com.kizoom.functest.tfl.journeyplanner.kiosk.*", //$NON-NLS-1$
			"com.kizoom.functest.tfl.mobile.*", //$NON-NLS-1$
			"com.kizoom.functest.tmobile.*", //$NON-NLS-1$
			"com.kizoom.functest.vodafonelive.*", //$NON-NLS-1$
			"com.kizoom.functest.style.vodafone.*", //$NON-NLS-1$
			"com.kizoom.functest.wml.compiler.test.*", //$NON-NLS-1$
			"com.kizoom.functest.wml.compiler.*", //$NON-NLS-1$
			"com.kizoom.plugin.functest.runner.*", //$NON-NLS-1$
			"org.eclipse.jdt.internal.junit.runner.*", //$NON-NLS-1$
			"org.eclipse.jdt.internal.junit4.runner.*", //$NON-NLS-1$
			"org.eclipse.jdt.internal.junit.ui.*", //$NON-NLS-1$
			"junit.framework.TestCase", //$NON-NLS-1$
			"junit.framework.TestResult", //$NON-NLS-1$
			"junit.framework.TestResult$1", //$NON-NLS-1$
			"junit.framework.TestSuite", //$NON-NLS-1$
			"junit.framework.Assert", //$NON-NLS-1$
			"org.junit.*", //$NON-NLS-1$ //TODO: filter all these?
			"java.lang.reflect.Method.invoke", //$NON-NLS-1$
			"sun.reflect.*", //$NON-NLS-1$
	};

	private FunctestPreferencesConstants() {
		// no instance
	}

	/**
	 * Returns the default list of active stack filters.
	 * 
	 * @return list
	 */
	public static List<String> createDefaultStackFiltersList() {
		return Arrays.asList(fgDefaultFilterPatterns);
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
