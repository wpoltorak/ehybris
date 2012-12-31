package com.lambda.plugin.yunit.launcher;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jdt.internal.junit.launcher.ITestKind;
import org.eclipse.jdt.internal.junit.launcher.TestKindRegistry;

import com.lambda.plugin.YPlugin;

@SuppressWarnings("restriction")
public class YUnitLaunchConfigurationConstants {

    public static final String DEFAULT_LAUNCH_CONFIG_NAME = "yunit"; //$NON-NLS-1$
    public static final String MODE_RUN_QUIETLY_MODE = "runQuietly"; //$NON-NLS-1$
    public static final String ID_FUNCTEST_APPLICATION = "com.lambda.plugin.yunit.launchconfig"; //$NON-NLS-1$

    public static final String ATTR_NO_DISPLAY = YPlugin.PLUGIN_ID + ".NO_DISPLAY"; //$NON-NLS-1$

    public static final String ATTR_PORT = YPlugin.PLUGIN_ID + ".PORT"; //$NON-NLS-1$

    public static final String ATTR_PROJECT_NAMES = YPlugin.PLUGIN_ID + ".PROJECTS_ATTR"; //$NON-NLS-1$

    public static final String ATTR_MAIN_TYPE_NAMES = YPlugin.PLUGIN_ID + ".MAINTYPES_ATTR"; //$NON-NLS-1$

    public static final String ATTR_TEST_METHOD_NAMES = YPlugin.PLUGIN_ID + ".TESTNAME"; //$NON-NLS-1$

    public static final String ATTR_TEST_CONTAINERS = YPlugin.PLUGIN_ID + ".CONTAINER"; //$NON-NLS-1$

    public static final String ATTR_FAILURES_NAMES = YPlugin.PLUGIN_ID + ".FAILURENAMES"; //$NON-NLS-1$
    public static final String ATTR_TEST_RUNNER_KIND = YPlugin.PLUGIN_ID + ".TEST_KIND"; //$NON-NLS-1$
    public static final String ATTR_TEST_SERVER = YPlugin.PLUGIN_ID + ".SERVER";//$NON-NLS-1$
    ////////////////

    public static final String ATTR_TAG_PROJECTS = "projects";

    public static ITestKind getTestRunnerKind(final ILaunchConfiguration launchConfiguration) {
        try {
            final String loaderId = launchConfiguration
                    .getAttribute(YUnitLaunchConfigurationConstants.ATTR_TEST_RUNNER_KIND, (String) null);
            if (loaderId != null) {
                return TestKindRegistry.getDefault().getKind(loaderId);
            }
        } catch (final CoreException e) {
        }
        return ITestKind.NULL;
    }
}