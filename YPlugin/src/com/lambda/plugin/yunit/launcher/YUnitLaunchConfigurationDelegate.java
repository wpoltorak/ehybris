package com.lambda.plugin.yunit.launcher;

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

import com.lambda.plugin.ExceptionHandler;
import com.lambda.plugin.YPlugin;
import com.lambda.plugin.YMessages;
import com.lambda.plugin.yunit.properties.YUnitPropertyConstants;

@SuppressWarnings("restriction")
public class YUnitLaunchConfigurationDelegate extends AbstractJavaLaunchConfigurationDelegate {

    private int fPort;
    private IMember[] fTestElements;

    protected void preLaunchCheck(final ILaunchConfiguration configuration, final ILaunch launch, final IProgressMonitor monitor)
            throws CoreException {

    }

    @Override
    public boolean preLaunchCheck(final ILaunchConfiguration configuration, final String mode, final IProgressMonitor monitor)
            throws CoreException {
        return true;
    }

    protected IMember[] filterTests(final IMember[] members) throws CoreException {
        final List<IMember> filtered = new ArrayList<IMember>(members.length);

        for (final IMember member : members) {
            final String persistentProperty = member.getJavaProject().getProject()
                    .getPersistentProperty(new QualifiedName("", YUnitPropertyConstants.PREF_ACTIVE_TEST_FILTERS_LIST));
            final String[] patterns = parseList(persistentProperty == null ? "" : persistentProperty);
            final String memberStr = YUnitLaunchConfigurationUtils.toString(member);
            if (!filterLine(patterns, memberStr)) {
                filtered.add(member);
            }
        }
        return filtered.toArray(new IMember[filtered.size()]);
    }

    private boolean filterLine(final String[] patterns, final String line) {
        String pattern;
        int len;
        for (int i = (patterns.length - 1); i >= 0; --i) {
            pattern = patterns[i];
            len = pattern.length() - 1;
            if (pattern.charAt(len) == '*') {
                // strip trailing * from a package filter
                pattern = pattern.substring(0, len - 1);
            }
            if (line.startsWith(pattern)) {
                return true;
            }
        }
        return false;
    }

    private static String[] parseList(final String listString) {
        final List<String> list = new ArrayList<String>(10);
        final StringTokenizer tokenizer = new StringTokenizer(listString, ","); //$NON-NLS-1$
        while (tokenizer.hasMoreTokens()) {
            list.add(tokenizer.nextToken());
        }
        return list.toArray(new String[list.size()]);
    }

    protected IMember[] evaluateTests(final ILaunchConfiguration configuration, final IProgressMonitor monitor) throws CoreException {
        final Map<String, IJavaProject> javaProjects = YUnitLaunchConfigurationUtils.getJavaProjects(configuration);
        final Set<IMember> result = new HashSet<IMember>();
        final List<? extends IJavaElement> testTargets = getTestTargets(configuration);
        final ITestKind testKind = getTestRunnerKind(configuration);
        for (final IJavaElement testTarget : testTargets) {
            final Set<IMember> res = new HashSet<IMember>();
            testKind.getFinder().findTestsInContainer(testTarget, res, monitor);
            result.addAll(res);
        }

        //TODO FunctestPlugin: This is similar to FunctestLaunchConfigUtils retrieve...
        final String testMethodNames = configuration.getAttribute(YUnitLaunchConfigurationConstants.ATTR_TEST_METHOD_NAMES, ""); //$NON-NLS-1$
        if (testMethodNames.length() > 0) {
            final String[] methodNames = testMethodNames.split(",");
            for (final String methodName : methodNames) {
                final String[] projectTypeAndMethod = YUnitLaunchConfigurationUtils.split(methodName);
                if (projectTypeAndMethod.length == 3) {
                    final String testTypeName = performStringSubstitution(projectTypeAndMethod[1]);
                    final IType type = javaProjects.get(projectTypeAndMethod[0]).findType(testTypeName);
                    final String testMethodName = projectTypeAndMethod[2];
                    if (type != null && !result.contains(type) && type.exists()) {
                        final IMember member = type.getMethod(testMethodName, new String[0]);
                        if (member != null) {
                            result.add(member);
                        }
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
    public String[] getClasspath(final ILaunchConfiguration configuration) throws CoreException {
        final String[] cp = super.getClasspath(configuration);

        final ITestKind kind = getTestRunnerKind(configuration);
        final List<?> junitEntries = new ClasspathLocalizer(Platform.inDevelopmentMode()).localizeClasspath(kind);

        final String[] classPath = new String[cp.length + junitEntries.size()];
        final Object[] jea = junitEntries.toArray();
        System.arraycopy(cp, 0, classPath, 0, cp.length);
        System.arraycopy(jea, 0, classPath, cp.length, jea.length);
        return classPath;
    }

    private final List<? extends IJavaElement> getTestTargets(final ILaunchConfiguration configuration) throws CoreException {

        final List<IJavaElement> elements = new ArrayList<IJavaElement>();
        YUnitLaunchConfigurationUtils.retrieveTestContainers(elements, configuration);
        YUnitLaunchConfigurationUtils.retrieveMainTypeNames(elements, configuration);
        return elements;
    }

    private final String performStringSubstitution(final String testTypeName) throws CoreException {
        return VariablesPlugin.getDefault().getStringVariableManager().performStringSubstitution(testTypeName);
    }

    private ITestKind getTestRunnerKind(final ILaunchConfiguration configuration) {
        ITestKind testKind = YUnitLaunchConfigurationConstants.getTestRunnerKind(configuration);
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
        final int port = SocketUtil.findFreePort();
        if (port == -1) {
            informAndAbort(YMessages.FunctestLaunchConfigurationDelegate_error_no_socket, null,
                    IJavaLaunchConfigurationConstants.ERR_NO_SOCKET_AVAILABLE);
        }
        return port;
    }

    private boolean showStatusMessage(final IStatus status) {
        final boolean[] success = new boolean[] { false };
        getDisplay().syncExec(new Runnable() {
            public void run() {
                Shell shell = YPlugin.getActiveWorkbenchShell();
                if (shell == null) {
                    shell = getDisplay().getActiveShell();
                }
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
        if (display == null) {
            display = Display.getDefault();
        }
        return display;
    }

    private void informAndAbort(final String message, final Throwable exception, final int code) throws CoreException {
        final IStatus status = new Status(IStatus.INFO, YPlugin.PLUGIN_ID, code, message, exception);
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

    public synchronized void launch(final ILaunchConfiguration configuration, String mode, final ILaunch launch, IProgressMonitor monitor)
            throws CoreException {
        if (monitor == null) {
            monitor = new NullProgressMonitor();
        }

        monitor.beginTask(MessageFormat.format("{0}...", new String[] { configuration.getName() }), 5); //$NON-NLS-1$
        // check for cancellation
        if (monitor.isCanceled()) {
            return;
        }

        try {
            if (mode.equals(YUnitLaunchConfigurationConstants.MODE_RUN_QUIETLY_MODE)) {
                launch.setAttribute(YUnitLaunchConfigurationConstants.ATTR_NO_DISPLAY, "true"); //$NON-NLS-1$
                mode = ILaunchManager.RUN_MODE;
            }

            monitor.subTask(YMessages.FunctestLaunchConfigurationDelegate_verifying_attriburtes_description);

            try {
                preLaunchCheck(configuration, launch, new SubProgressMonitor(monitor, 2));
            } catch (final CoreException e) {
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
            launch.setAttribute(YUnitLaunchConfigurationConstants.ATTR_PORT, String.valueOf(fPort));

            final IMember[] filteredTests = filterTests(evaluateTests(configuration, new SubProgressMonitor(monitor, 1)));
            if (filteredTests.length == 0) {
                return;
            }

            fTestElements = filteredTests;

            final String mainTypeName = verifyMainTypeName(configuration);
            final IVMRunner runner = getVMRunner(configuration, mode);

            final File workingDir = verifyWorkingDirectory(configuration);
            String workingDirName = null;
            if (workingDir != null) {
                workingDirName = workingDir.getAbsolutePath();
            }

            // Environment variables
            final String[] envp = getEnvironment(configuration);

            final List<String> vmArguments = new ArrayList<String>();
            final List<String> programArguments = new ArrayList<String>();
            collectExecutionArguments(configuration, vmArguments, programArguments);

            // VM-specific attributes
            final Map<String, Object> vmAttributesMap = getVMSpecificAttributesMap(configuration);

            // Classpath
            final String[] classpath = getClasspath(configuration);

            // Create VM config
            final VMRunnerConfiguration runConfig = new VMRunnerConfiguration(mainTypeName, classpath);
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

            monitor.subTask(YMessages.FunctestLaunchConfigurationDelegate_create_source_locator_description);
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

    protected void collectExecutionArguments(final ILaunchConfiguration configuration, final List<String> vmArguments,
            final List<String> programArguments) throws CoreException {

        // add program & VM arguments provided by getProgramArguments and
        // getVMArguments
        final String pgmArgs = getProgramArguments(configuration);
        final String vmArgs = getVMArguments(configuration);
        final ExecutionArguments execArgs = new ExecutionArguments(vmArgs, pgmArgs);
        vmArguments.addAll(Arrays.asList(execArgs.getVMArgumentsArray()));
        programArguments.addAll(Arrays.asList(execArgs.getProgramArgumentsArray()));

        final String testFailureNames = configuration.getAttribute(YUnitLaunchConfigurationConstants.ATTR_FAILURES_NAMES, ""); //$NON-NLS-1$
        final String testServer = configuration.getAttribute(YUnitLaunchConfigurationConstants.ATTR_TEST_SERVER, (String) null);

        programArguments.add("-version"); //$NON-NLS-1$
        programArguments.add("3"); //$NON-NLS-1$

        programArguments.add("-port"); //$NON-NLS-1$
        programArguments.add(String.valueOf(fPort));

        final ITestKind testRunnerKind = getTestRunnerKind(configuration);

        programArguments.add("-junitversion"); //$NON-NLS-1$
        // TODO YPlugin handle this differently
        programArguments.add(testRunnerKind.getId().substring(testRunnerKind.getId().length() - 1));

        final IMember[] testElements = fTestElements;

        if (testElements.length > 0) {
            final String fileName = createTestNamesFile(testElements);
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

    private String createTestNamesFile(final IMember[] testElements) throws CoreException {
        try {
            final File file = File.createTempFile("testNames", ".txt"); //$NON-NLS-1$ //$NON-NLS-2$
            file.deleteOnExit();
            BufferedWriter bw = null;
            try {
                bw = new BufferedWriter(new FileWriter(file));
                for (int i = 0; i < testElements.length; i++) {
                    final String entry = YUnitLaunchConfigurationUtils.toString(testElements[i], '$');
                    if (entry != null) {
                        bw.write(entry);
                        bw.newLine();
                    } else {
                        informAndAbort(YMessages.FunctestLaunchConfigurationDelegate_error_wrong_input, null,
                                IJavaLaunchConfigurationConstants.ERR_UNSPECIFIED_MAIN_TYPE);
                    }
                }
            } finally {
                if (bw != null) {
                    bw.close();
                }
            }
            return file.getAbsolutePath();
        } catch (final IOException e) {
            throw new CoreException(new Status(IStatus.ERROR, YPlugin.PLUGIN_ID, IStatus.ERROR, "", e)); //$NON-NLS-1$
        }
    }

    private static class ClasspathLocalizer {

        private final boolean fInDevelopmentMode;

        protected ClasspathLocalizer() {
            this(false);
        }

        public ClasspathLocalizer(final boolean inDevelopmentMode) {
            fInDevelopmentMode = inDevelopmentMode;
        }

        public List<String> localizeClasspath(final ITestKind kind) {
            final JUnitRuntimeClasspathEntry[] entries = kind.getClasspathEntries();
            final List<String> junitEntries = new ArrayList<String>();

            for (int i = 0; i < entries.length; i++) {
                try {
                    addEntry(junitEntries, entries[i]);
                } catch (final IOException e) {
                    Assert.isTrue(false, entries[i].getPluginId() + " is available (required JAR)"); //$NON-NLS-1$
                }
            }
            try {
                addEntry(junitEntries, new JUnitRuntimeClasspathEntry(YPlugin.PLUGIN_ID, null));
            } catch (final MalformedURLException e) {
                ExceptionHandler.log(e, "Problem during rynning functests");
            } catch (final IOException e) {
                Assert.isTrue(false, YPlugin.PLUGIN_ID + " is available (required JAR)"); //$NON-NLS-1$
            }
            return junitEntries;
        }

        private void addEntry(final List<String> junitEntries, final JUnitRuntimeClasspathEntry entry) throws IOException,
                MalformedURLException {
            final String entryString = entryString(entry);
            if (entryString != null) {
                junitEntries.add(entryString);
            }
        }

        private String entryString(final JUnitRuntimeClasspathEntry entry) throws IOException, MalformedURLException {
            if (inDevelopmentMode()) {
                try {
                    return localURL(entry.developmentModeEntry());
                } catch (final IOException e3) {
                    // fall through and try default
                }
            }
            return localURL(entry);
        }

        private boolean inDevelopmentMode() {
            return fInDevelopmentMode;
        }

        private String localURL(final JUnitRuntimeClasspathEntry jar) throws IOException, MalformedURLException {
            final Bundle bundle = YPlugin.getDefault().getBundle(jar.getPluginId());
            URL url;
            if (jar.getPluginRelativePath() == null) {
                url = bundle.getEntry("/"); //$NON-NLS-1$
            } else {
                url = bundle.getEntry(jar.getPluginRelativePath());
            }
            if (url == null) {
                throw new IOException();
            }
            return FileLocator.toFileURL(url).getFile();
        }
    }

    @Override
    public String verifyMainTypeName(final ILaunchConfiguration configuration) throws CoreException {
        return "com.lambda.plugin.yunit.runner.RemoteYUnitRunner"; //$NON-NLS-1$
    }
}
