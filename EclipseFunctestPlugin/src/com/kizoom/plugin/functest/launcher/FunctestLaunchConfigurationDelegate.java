package com.kizoom.plugin.functest.launcher;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.core.variables.VariablesPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.internal.junit.launcher.ITestKind;
import org.eclipse.jdt.internal.junit.launcher.JUnitRuntimeClasspathEntry;
import org.eclipse.jdt.internal.junit.launcher.TestKindRegistry;
import org.eclipse.jdt.launching.AbstractJavaLaunchConfigurationDelegate;
import org.eclipse.jdt.launching.ExecutionArguments;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jdt.launching.IVMRunner;
import org.eclipse.jdt.launching.SocketUtil;
import org.eclipse.jdt.launching.VMRunnerConfiguration;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.osgi.framework.Bundle;

import com.kizoom.plugin.ExceptionHandler;
import com.kizoom.plugin.KizoomPlugin;
import com.kizoom.plugin.functest.FunctestMessages;
import com.kizoom.plugin.functest.FunctestPlugin;
import com.kizoom.plugin.functest.properties.FunctestPropertyConstants;

@SuppressWarnings("restriction")
public class FunctestLaunchConfigurationDelegate extends AbstractJavaLaunchConfigurationDelegate {

	private int fPort;
	private IMember[] fTestElements;

	protected void preLaunchCheck(ILaunchConfiguration configuration, ILaunch launch, IProgressMonitor monitor)
			throws CoreException {
		
	}

	@Override
	public boolean preLaunchCheck(ILaunchConfiguration configuration, String mode, IProgressMonitor monitor)
			throws CoreException {
		return true;
	}

	protected IMember[] filterTests(IMember[] members) throws CoreException {
		List<IMember> filtered = new ArrayList<IMember>(members.length);

		for (IMember member : members) {
			String persistentProperty = member.getJavaProject().getProject().getPersistentProperty(new QualifiedName("", FunctestPropertyConstants.PREF_ACTIVE_TEST_FILTERS_LIST));
			String[] patterns = parseList(persistentProperty == null ? "" : persistentProperty);
			String memberStr = FunctestLaunchConfigurationUtils.toString(member);
			if (!filterLine(patterns, memberStr)){
				filtered.add(member);
			}
		}
		return filtered.toArray(new IMember[filtered.size()]);
	}
	
	private boolean filterLine(String[] patterns, String line) {
		String pattern;
		int len;
		for (int i = (patterns.length - 1); i >= 0; --i) {
			pattern = patterns[i];
			len = pattern.length() - 1;
			if (pattern.charAt(len) == '*') {
				// strip trailing * from a package filter
				pattern = pattern.substring(0, len - 1);
			} 
			if (line.startsWith(pattern))
				return true;
		}
		return false;
	}
	
	private static String[] parseList(String listString) {
		List<String> list = new ArrayList<String>(10);
		StringTokenizer tokenizer = new StringTokenizer(listString, ","); //$NON-NLS-1$
		while (tokenizer.hasMoreTokens())
			list.add(tokenizer.nextToken());
		return list.toArray(new String[list.size()]);
	}
	
	protected IMember[] evaluateTests(ILaunchConfiguration configuration, IProgressMonitor monitor) throws CoreException {
		Map<String, IJavaProject> javaProjects = FunctestLaunchConfigurationUtils.getJavaProjects(configuration);
		Set<IMember> result = new HashSet<IMember>();
		List<? extends IJavaElement> testTargets = getTestTargets(configuration);
		ITestKind testKind = getTestRunnerKind(configuration);
		for (IJavaElement testTarget : testTargets) {
			Set<IMember> res = new HashSet<IMember>();
			testKind.getFinder().findTestsInContainer(testTarget, res, monitor);
			result.addAll(res);
		}
		
		//TODO FunctestPlugin: This is similar to FunctestLaunchConfigUtils retrieve...
		String testMethodNames = configuration
				.getAttribute(FunctestLaunchConfigurationConstants.ATTR_TEST_METHOD_NAMES, ""); //$NON-NLS-1$
		if (testMethodNames.length() > 0) {
			String[] methodNames = testMethodNames.split(",");
			for (String methodName : methodNames) {
				String[] projectTypeAndMethod = FunctestLaunchConfigurationUtils.split(methodName);
				if (projectTypeAndMethod.length == 3) {
					String testTypeName = performStringSubstitution(projectTypeAndMethod[1]);
					IType type = javaProjects.get(projectTypeAndMethod[0]).findType(testTypeName);
					String testMethodName = projectTypeAndMethod[2];
					if (type != null && !result.contains(type) && type.exists()) {
						IMember member = type.getMethod(testMethodName, new String[0]);
						if (member != null)
							result.add(member);
					}
				}
			}
		}

		if (result.isEmpty()) {
			informAndAbort("No tests found with test runner '" + testKind.getDisplayName() + "'.", null,
					IJavaLaunchConfigurationConstants.ERR_UNSPECIFIED_MAIN_TYPE);
		}
		return result.toArray(new IMember[result.size()]);
	}

	@Override
	public String[] getClasspath(ILaunchConfiguration configuration) throws CoreException {
		String[] cp = super.getClasspath(configuration);

		ITestKind kind = getTestRunnerKind(configuration);
		List<?> junitEntries = new ClasspathLocalizer(Platform.inDevelopmentMode()).localizeClasspath(kind);

		String[] classPath = new String[cp.length + junitEntries.size()];
		Object[] jea = junitEntries.toArray();
		System.arraycopy(cp, 0, classPath, 0, cp.length);
		System.arraycopy(jea, 0, classPath, cp.length, jea.length);
		return classPath;
	}

	private final List<? extends IJavaElement> getTestTargets(ILaunchConfiguration configuration) throws CoreException {

		List<IJavaElement> elements = new ArrayList<IJavaElement>();
		FunctestLaunchConfigurationUtils.retrieveTestContainers(elements, configuration);
		FunctestLaunchConfigurationUtils.retrieveMainTypeNames(elements, configuration);
		return elements;
	}

	private final String performStringSubstitution(String testTypeName) throws CoreException {
		return VariablesPlugin.getDefault().getStringVariableManager().performStringSubstitution(testTypeName);
	}

	private ITestKind getTestRunnerKind(ILaunchConfiguration configuration) {
		ITestKind testKind = FunctestLaunchConfigurationConstants.getTestRunnerKind(configuration);
		if (testKind.isNull()) {
			testKind = TestKindRegistry.getDefault().getKind(TestKindRegistry.JUNIT3_TEST_KIND_ID); // backward
			// compatible for
			// launch
			// configurations
			// with no runner
		}
		return testKind;
	}

	private int evaluatePort() throws CoreException {
		int port = SocketUtil.findFreePort();
		if (port == -1) {
			informAndAbort(FunctestMessages.FunctestLaunchConfigurationDelegate_error_no_socket, null,
					IJavaLaunchConfigurationConstants.ERR_NO_SOCKET_AVAILABLE);
		}
		return port;
	}

	private boolean showStatusMessage(final IStatus status) {
		final boolean[] success = new boolean[] { false };
		getDisplay().syncExec(new Runnable() {
			public void run() {
				Shell shell = KizoomPlugin.getActiveWorkbenchShell();
				if (shell == null)
					shell = getDisplay().getActiveShell();
				if (shell != null) {
					MessageDialog.openInformation(shell, "Problems Launching Functional Tests", status.getMessage());
					success[0] = true;
				}
			}
		});
		return success[0];
	}

	private Display getDisplay() {
		Display display;
		display = Display.getCurrent();
		if (display == null)
			display = Display.getDefault();
		return display;
	}

	private void informAndAbort(String message, Throwable exception, int code) throws CoreException {
		IStatus status = new Status(IStatus.INFO, KizoomPlugin.PLUGIN_ID, code, message, exception);
		if (showStatusMessage(status)) {
			// Status message successfully shown
			// -> Abort with INFO exception
			// -> Worker.run() will not write to log
			throw new CoreException(status);
		} else {
			// Status message could not be shown
			// -> Abort with original exception
			// -> Will write WARNINGs and ERRORs to log
			abort(message, exception, code);
		}
	}

	public synchronized void launch(ILaunchConfiguration configuration, String mode, ILaunch launch,
			IProgressMonitor monitor) throws CoreException {
		if (monitor == null) {
			monitor = new NullProgressMonitor();
		}

		monitor.beginTask(MessageFormat.format("{0}...", new String[] { configuration.getName() }), 5); //$NON-NLS-1$
		// check for cancellation
		if (monitor.isCanceled()) {
			return;
		}

		try {
			if (mode.equals(FunctestLaunchConfigurationConstants.MODE_RUN_QUIETLY_MODE)) {
				launch.setAttribute(FunctestLaunchConfigurationConstants.ATTR_NO_DISPLAY, "true"); //$NON-NLS-1$
				mode = ILaunchManager.RUN_MODE;
			}

			monitor.subTask(FunctestMessages.FunctestLaunchConfigurationDelegate_verifying_attriburtes_description);

			try {
				preLaunchCheck(configuration, launch, new SubProgressMonitor(monitor, 2));
			} catch (CoreException e) {
				if (e.getStatus().getSeverity() == IStatus.CANCEL) {
					monitor.setCanceled(true);
					return;
				}
				throw e;
			}
			// check for cancellation
			if (monitor.isCanceled()) {
				return;
			}

			fPort = evaluatePort();
			launch.setAttribute(FunctestLaunchConfigurationConstants.ATTR_PORT, String.valueOf(fPort));

			IMember[] filteredTests = filterTests(evaluateTests(configuration, new SubProgressMonitor(monitor, 1)));
			if (filteredTests.length == 0){
				return;
			}
			
			fTestElements = filteredTests;

			String mainTypeName = verifyMainTypeName(configuration);
			IVMRunner runner = getVMRunner(configuration, mode);

			File workingDir = verifyWorkingDirectory(configuration);
			String workingDirName = null;
			if (workingDir != null) {
				workingDirName = workingDir.getAbsolutePath();
			}

			// Environment variables
			String[] envp = getEnvironment(configuration);

			List<String> vmArguments = new ArrayList<String>();
			List<String> programArguments = new ArrayList<String>();
			collectExecutionArguments(configuration, vmArguments, programArguments);

			// VM-specific attributes
			Map<String, Object> vmAttributesMap = getVMSpecificAttributesMap(configuration);

			// Classpath
			String[] classpath = getClasspath(configuration);

			// Create VM config
			VMRunnerConfiguration runConfig = new VMRunnerConfiguration(mainTypeName, classpath);
			runConfig.setVMArguments(vmArguments.toArray(new String[vmArguments.size()]));
			runConfig.setProgramArguments(programArguments.toArray(new String[programArguments.size()]));
			runConfig.setEnvironment(envp);
			runConfig.setWorkingDirectory(workingDirName);
			runConfig.setVMSpecificAttributesMap(vmAttributesMap);

			// Bootpath
			runConfig.setBootClassPath(getBootpath(configuration));

			// check for cancellation
			if (monitor.isCanceled()) {
				return;
			}

			// done the verification phase
			monitor.worked(1);

			monitor.subTask(FunctestMessages.FunctestLaunchConfigurationDelegate_create_source_locator_description);
			// set the default source locator if required
			setDefaultSourceLocator(launch, configuration);
			monitor.worked(1);

			// Launch the configuration - 1 unit of work
			runner.run(runConfig, launch, monitor);

			// check for cancellation
			if (monitor.isCanceled()) {
				return;
			}
		} finally {
			fTestElements = null;
			monitor.done();
		}
	}

	protected void collectExecutionArguments(ILaunchConfiguration configuration, List<String> vmArguments,
			List<String> programArguments) throws CoreException {

		// add program & VM arguments provided by getProgramArguments and
		// getVMArguments
		String pgmArgs = getProgramArguments(configuration);
		String vmArgs = getVMArguments(configuration);
		ExecutionArguments execArgs = new ExecutionArguments(vmArgs, pgmArgs);
		vmArguments.addAll(Arrays.asList(execArgs.getVMArgumentsArray()));
		programArguments.addAll(Arrays.asList(execArgs.getProgramArgumentsArray()));

		String testFailureNames = configuration.getAttribute(FunctestLaunchConfigurationConstants.ATTR_FAILURES_NAMES, ""); //$NON-NLS-1$
		String testServer = configuration
				.getAttribute(FunctestLaunchConfigurationConstants.ATTR_TEST_SERVER, (String) null);

		programArguments.add("-version"); //$NON-NLS-1$
		programArguments.add("3"); //$NON-NLS-1$

		programArguments.add("-port"); //$NON-NLS-1$
		programArguments.add(String.valueOf(fPort));

		ITestKind testRunnerKind = getTestRunnerKind(configuration);

		programArguments.add("-junitversion"); //$NON-NLS-1$
		// TODO KizoomPlugin handle this differently
		programArguments.add(testRunnerKind.getId().substring(testRunnerKind.getId().length() - 1));

		IMember[] testElements = fTestElements;

		if (testElements.length > 0) {
			String fileName = createTestNamesFile(testElements);
			programArguments.add("-testNameFile"); //$NON-NLS-1$
			programArguments.add(fileName);
		}
		if (testFailureNames.length() > 0) {
			programArguments.add("-testfailures"); //$NON-NLS-1$
			programArguments.add(testFailureNames);
		}

		if (testServer != null) {
			programArguments.add("-testserver");
			programArguments.add(testServer);
		}
//		programArguments.add("-debug");
	}

	private String createTestNamesFile(IMember[] testElements) throws CoreException {
		try {
			File file = File.createTempFile("testNames", ".txt"); //$NON-NLS-1$ //$NON-NLS-2$
			file.deleteOnExit();
			BufferedWriter bw = null;
			try {
				bw = new BufferedWriter(new FileWriter(file));
				for (int i = 0; i < testElements.length; i++) {
					String entry = FunctestLaunchConfigurationUtils.toString(testElements[i], '$');
					if (entry != null) {
						bw.write(entry);
						bw.newLine();
					} else {
						informAndAbort(FunctestMessages.FunctestLaunchConfigurationDelegate_error_wrong_input, null,
								IJavaLaunchConfigurationConstants.ERR_UNSPECIFIED_MAIN_TYPE);
					}
				}
			} finally {
				if (bw != null) {
					bw.close();
				}
			}
			return file.getAbsolutePath();
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR, KizoomPlugin.PLUGIN_ID, IStatus.ERROR, "", e)); //$NON-NLS-1$
		}
	}

	private static class ClasspathLocalizer {

		private boolean fInDevelopmentMode;

		protected ClasspathLocalizer() {
			this(false);
		}

		public ClasspathLocalizer(boolean inDevelopmentMode) {
			fInDevelopmentMode = inDevelopmentMode;
		}

		public List<String> localizeClasspath(ITestKind kind) {
			JUnitRuntimeClasspathEntry[] entries = kind.getClasspathEntries();
			List<String> junitEntries = new ArrayList<String>();

			for (int i = 0; i < entries.length; i++) {
				try {
					addEntry(junitEntries, entries[i]);
				} catch (IOException e) {
					Assert.isTrue(false, entries[i].getPluginId() + " is available (required JAR)"); //$NON-NLS-1$
				}
			}
			try {
				addEntry(junitEntries, new JUnitRuntimeClasspathEntry(FunctestPlugin.PLUGIN_ID, null));
			} catch (MalformedURLException e) {
				ExceptionHandler.log(e, "Problem during rynning functests");
			} catch (IOException e) {
				Assert.isTrue(false, FunctestPlugin.PLUGIN_ID + " is available (required JAR)"); //$NON-NLS-1$
			}
			return junitEntries;
		}

		private void addEntry(List<String> junitEntries, final JUnitRuntimeClasspathEntry entry) throws IOException,
				MalformedURLException {
			String entryString = entryString(entry);
			if (entryString != null)
				junitEntries.add(entryString);
		}

		private String entryString(final JUnitRuntimeClasspathEntry entry) throws IOException, MalformedURLException {
			if (inDevelopmentMode()) {
				try {
					return localURL(entry.developmentModeEntry());
				} catch (IOException e3) {
					// fall through and try default
				}
			}
			return localURL(entry);
		}

		private boolean inDevelopmentMode() {
			return fInDevelopmentMode;
		}

		private String localURL(JUnitRuntimeClasspathEntry jar) throws IOException, MalformedURLException {
			Bundle bundle = KizoomPlugin.getDefault().getBundle(jar.getPluginId());
			URL url;
			if (jar.getPluginRelativePath() == null)
				url = bundle.getEntry("/"); //$NON-NLS-1$
			else
				url = bundle.getEntry(jar.getPluginRelativePath());
			if (url == null)
				throw new IOException();
			return FileLocator.toFileURL(url).getFile();
		}
	}

	@Override
	public String verifyMainTypeName(ILaunchConfiguration configuration) throws CoreException {
		return "com.kizoom.plugin.functest.runner.RemoteFunctestRunner"; //$NON-NLS-1$
	}
}
