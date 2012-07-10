package com.lambda.plugin.yunit;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.internal.core.JavaModelManager;
import org.eclipse.jdt.internal.launching.LaunchingMessages;
import org.eclipse.jdt.internal.launching.LaunchingPlugin;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jdt.launching.IRuntimeClasspathEntry;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.StandardClasspathProvider;

import com.lambda.plugin.yunit.launcher.YUnitLaunchConfigurationConstants;

public class YUnitClasspathProvider extends StandardClasspathProvider {

	public static final String PROVIDER_ID = "com.lambda.plugin.yunit.YUnitClasspathProvider";

	@Override
	public IRuntimeClasspathEntry[] computeUnresolvedClasspath(ILaunchConfiguration configuration) throws CoreException {
		boolean useDefault = configuration.getAttribute(IJavaLaunchConfigurationConstants.ATTR_DEFAULT_CLASSPATH, true);
		if (useDefault) {
			List<IJavaProject> projects = getFunctestProjects(configuration);
			Set<IRuntimeClasspathEntry> entrySet = new HashSet<IRuntimeClasspathEntry>();
			outer: for (IJavaProject proj : projects) {
				IRuntimeClasspathEntry jreEntry = JavaRuntime.computeJREEntry(configuration);
				if (proj == null) {
					// no project - use default libraries
					if (jreEntry == null) {
						return new IRuntimeClasspathEntry[0];
					}
					entrySet.add(jreEntry);
				}
				IRuntimeClasspathEntry[] entries = JavaRuntime.computeUnresolvedRuntimeClasspath(proj);
				// replace project JRE with config's JRE
				IRuntimeClasspathEntry projEntry = JavaRuntime.computeJREEntry(proj);
				if (jreEntry != null && projEntry != null) {
					if (!jreEntry.equals(projEntry)) {
						for (int i = 0; i < entries.length; i++) {
							IRuntimeClasspathEntry entry = entries[i];
							if (entry.equals(projEntry)) {
								entries[i] = jreEntry;
								entrySet.addAll(Arrays.asList(entries));
								continue outer;
							}
						}
					}
					entrySet.addAll(Arrays.asList(entries));
				}
			}
			return entrySet.toArray(new IRuntimeClasspathEntry[entrySet.size()]);
		}
		// recover persisted classpath
		return recoverRuntimePath(configuration, IJavaLaunchConfigurationConstants.ATTR_CLASSPATH);
	}

	private static List<IJavaProject> getFunctestProjects(ILaunchConfiguration configuration) throws CoreException {
		List<IJavaProject> projects = new ArrayList<IJavaProject>();
		String projectList = configuration.getAttribute(YUnitLaunchConfigurationConstants.ATTR_PROJECT_NAMES, "");
		if (!"".equals(projectList)){
			String[] projectNames = projectList
					.split(",");
			for (String projectName : projectNames) {
				IJavaProject project = getFunctestProject(configuration, projectName);
				if (project != null)
					projects.add(project);
			}
		}
		return projects;
	}

	private static IJavaProject getFunctestProject(ILaunchConfiguration configuration, String projectName)
			throws CoreException {
		IJavaProject javaProject = JavaModelManager.getJavaModelManager().getJavaModel().getJavaProject(projectName);
		if (javaProject != null && javaProject.getProject().exists() && !javaProject.getProject().isOpen()) {
			String message = MessageFormat.format(LaunchingMessages.JavaRuntime_28, new String[] { configuration.getName(),
					projectName });
			throw new CoreException(new Status(IStatus.ERROR, LaunchingPlugin.getUniqueIdentifier(),
					IJavaLaunchConfigurationConstants.ERR_PROJECT_CLOSED, message, null));
		}
		if ((javaProject == null) || !javaProject.exists()) {
			String message = MessageFormat.format(
					LaunchingMessages.JavaRuntime_Launch_configuration__0__references_non_existing_project__1___1, new String[] {
							configuration.getName(), projectName });
			throw new CoreException(new Status(IStatus.ERROR, LaunchingPlugin.getUniqueIdentifier(),
					IJavaLaunchConfigurationConstants.ERR_NOT_A_JAVA_PROJECT, message, null));

		}
		return javaProject;

	}
}
