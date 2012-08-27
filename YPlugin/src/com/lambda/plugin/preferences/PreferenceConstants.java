package com.lambda.plugin.preferences;

import java.util.Arrays;
import java.util.List;

import com.lambda.plugin.YPlugin;

/**
 * Constant definitions for plug-in preferences
 */
public class PreferenceConstants {

    /**
     * Preference key suffix for bold text style preference keys.
     * 
     */
    public static final String IMPEX_EDITOR_BOLD_SUFFIX = "_bold"; //$NON-NLS-1$

    /**
     * Preference key suffix for italic text style preference keys.
     */
    public static final String IMPEX_EDITOR_ITALIC_SUFFIX = "_italic"; //$NON-NLS-1$

    public static final String YUNIT_PERSIST_FUNCTEST_RESULTS = "persistFunctestResults";

    public static final String YUNIT_DEFAULT_JUNIT_VERSION = YPlugin.PLUGIN_ID + ".default_junit_version"; //$NON-NLS-1$ 
    /**
     * Boolean preference controlling whether the failure stack should be filtered.
     */
    public static final String YUNIT_DO_FILTER_STACK = YPlugin.PLUGIN_ID + ".do_filter_stack"; //$NON-NLS-1$

    /**
     * Boolean preference controlling whether the YUnit view should be shown on errors only.
     */
    public static final String YUNIT_SHOW_ON_ERROR_ONLY = YPlugin.PLUGIN_ID + ".show_on_error"; //$NON-NLS-1$

    /**
     * Boolean preference controlling whether the YUnit should have assertions enabled.
     */
    public static final String YUNIT_ENABLE_ASSERTIONS = YPlugin.PLUGIN_ID + ".enable_assertions"; //$NON-NLS-1$

    /**
     * List of active stack filters. A String containing a comma separated list of fully qualified type names/patterns.
     */
    public static final String YUNIT_PREF_ACTIVE_STACK_FILTERS_LIST = YPlugin.PLUGIN_ID + ".active_stack_filters"; //$NON-NLS-1$

    /**
     * List of inactive stack filters. A String containing a comma separated list of fully qualified type
     * names/patterns.
     */
    public static final String YUNIT_PREF_INACTIVE_STACK_FILTERS_LIST = YPlugin.PLUGIN_ID + ".inactive_stack_filters"; //$NON-NLS-1$  

    /**
     * Maximum number of remembered test runs.
     */
    public static final String YUNIT_MAX_TEST_RUNS = YPlugin.PLUGIN_ID + ".max_test_runs"; //$NON-NLS-1$

    /**
     * Javadoc location for JUnit 3
     */
    public static final String YUNIT_JUNIT3_JAVADOC = YPlugin.PLUGIN_ID + ".junit3.javadoclocation"; //$NON-NLS-1$

    /**
     * Javadoc location for JUnit 4
     */
    public static final String YUNIT_JUNIT4_JAVADOC = YPlugin.PLUGIN_ID + ".junit4.javadoclocation"; //$NON-NLS-1$

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

    private PreferenceConstants() {
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
     * @param list array of strings
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
