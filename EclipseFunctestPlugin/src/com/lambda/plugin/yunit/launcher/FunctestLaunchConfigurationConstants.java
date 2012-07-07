package com.lambda.plugin.yunit.launcher;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jdt.internal.junit.launcher.ITestKind;
import org.eclipse.jdt.internal.junit.launcher.TestKindRegistry;

import com.lambda.plugin.yunit.FunctestPlugin;

@SuppressWarnings("restriction")
public class FunctestLaunchConfigurationConstants {

	public static final String DEFAULT_LAUNCH_CONFIG_NAME = "Functional_Tests"; //$NON-NLS-1$
	public static final String MODE_RUN_QUIETLY_MODE = "runQuietly"; //$NON-NLS-1$
	public static final String ID_FUNCTEST_APPLICATION = "com.kizoom.plugin.functest.launchconfig"; //$NON-NLS-1$

	public static final String ATTR_NO_DISPLAY = FunctestPlugin.PLUGIN_ID + ".NO_DISPLAY"; //$NON-NLS-1$

	public static final String ATTR_PORT = FunctestPlugin.PLUGIN_ID + ".PORT"; //$NON-NLS-1$

	public static final String ATTR_PROJECT_NAMES = FunctestPlugin.PLUGIN_ID + ".PROJECTS_ATTR"; //$NON-NLS-1$

	public static final String ATTR_MAIN_TYPE_NAMES = FunctestPlugin.PLUGIN_ID + ".MAINTYPES_ATTR"; //$NON-NLS-1$

	public static final String ATTR_TEST_METHOD_NAMES = FunctestPlugin.PLUGIN_ID + ".TESTNAME"; //$NON-NLS-1$

	public static final String ATTR_TEST_CONTAINERS = FunctestPlugin.PLUGIN_ID + ".CONTAINER"; //$NON-NLS-1$

	public static final String ATTR_FAILURES_NAMES = FunctestPlugin.PLUGIN_ID + ".FAILURENAMES"; //$NON-NLS-1$
	public static final String ATTR_TEST_RUNNER_KIND = FunctestPlugin.PLUGIN_ID + ".TEST_KIND"; //$NON-NLS-1$
	public static final String ATTR_TEST_SERVER = FunctestPlugin.PLUGIN_ID + ".SERVER";//$NON-NLS-1$
////////////////
	
	public static final String ATTR_TAG_PROJECTS = "projects";
	
	public static ITestKind getTestRunnerKind(ILaunchConfiguration launchConfiguration) {
		try {
			String loaderId = launchConfiguration.getAttribute(FunctestLaunchConfigurationConstants.ATTR_TEST_RUNNER_KIND,
					(String) null);
			if (loaderId != null) {
				return TestKindRegistry.getDefault().getKind(loaderId);
			}
		} catch (CoreException e) {
		}
		return ITestKind.NULL;
	}
}