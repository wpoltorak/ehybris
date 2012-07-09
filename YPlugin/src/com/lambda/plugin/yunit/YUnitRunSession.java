package com.lambda.plugin.yunit;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.core.ILaunchesListener2;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.internal.junit.launcher.ITestKind;
import org.eclipse.jdt.internal.junit.model.ITestRunListener2;
import org.eclipse.jdt.internal.junit.model.ITestSessionListener;
import org.eclipse.jdt.internal.junit.model.RemoteTestRunnerClient;
import org.eclipse.jdt.internal.junit.model.TestCaseElement;
import org.eclipse.jdt.internal.junit.model.TestElement;
import org.eclipse.jdt.internal.junit.model.TestElement.Status;
import org.eclipse.jdt.internal.junit.model.TestRoot;
import org.eclipse.jdt.internal.junit.model.TestSuiteElement;
import org.eclipse.jdt.internal.junit.runner.MessageIds;
import org.eclipse.jdt.junit.model.ITestElement;
import org.eclipse.jdt.junit.model.ITestElementContainer;
import org.eclipse.jdt.junit.model.ITestRunSession;

import com.lambda.plugin.YPlugin;
import com.lambda.plugin.yunit.launcher.YUnitLaunchConfigurationConstants;
import com.lambda.plugin.yunit.launcher.YUnitLaunchConfigurationElements;

public class YUnitRunSession implements ITestRunSession {

    /**
     * The launch, or <code>null</code> iff this session was run externally.
     */
    private final ILaunch fLaunch;
    private final String fTestRunName;
    /**
     * Java project, or <code>null</code>.
     */
    private final List<IJavaProject> fProjects;

    private final ITestKind fTestRunnerKind;

    /**
     * Test runner client or <code>null</code>.
     */
    private RemoteTestRunnerClient fTestRunnerClient;

    private final ListenerList/* <ITestSessionListener> */fSessionListeners;

    /**
     * The model root, or <code>null</code> if swapped to disk.
     */
    private TestRoot fTestRoot;

    /**
     * The test run session's cached result, or <code>null</code> if <code>fTestRoot != null</code>.
     */
    private Result fTestResult;

    /**
     * Map from testId to testElement.
     */
    private HashMap/* <String, TestElement> */fIdToTest;

    /**
     * The TestSuites for which additional children are expected.
     */
    private List/* <IncompleteTestSuite> */fIncompleteTestSuites;

    /**
     * Suite for unrooted test case elements, or <code>null</code>.
     */
    private TestSuiteElement fUnrootedSuite;

    /**
     * Number of tests started during this test run.
     */
    volatile int fStartedCount;
    /**
     * Number of tests ignored during this test run.
     */
    volatile int fIgnoredCount;
    /**
     * Number of errors during this test run.
     */
    volatile int fErrorCount;
    /**
     * Number of failures during this test run.
     */
    volatile int fFailureCount;
    /**
     * Total number of tests to run.
     */
    volatile int fTotalCount;
    /**
     * Start time in millis.
     */
    volatile long fStartTime;
    volatile boolean fIsRunning;

    volatile boolean fIsStopped;
    private String fTestServer = "unknown";

    /**
     * @param testRunName
     * @param project may be <code>null</code>
     */
    public YUnitRunSession(final String testRunName, final List<IJavaProject> projects) {
        // TODO: check assumptions about non-null fields

        fLaunch = null;
        fProjects = projects;

        Assert.isNotNull(testRunName);
        fTestRunName = testRunName;
        fTestRunnerKind = ITestKind.NULL; // TODO

        fTestRoot = new TestRoot(this);
        fIdToTest = new HashMap();

        fTestRunnerClient = null;

        fSessionListeners = new ListenerList();
    }

    public YUnitRunSession(final ILaunch launch, final List<IJavaProject> projects, final int port) {
        Assert.isNotNull(launch);

        fLaunch = launch;
        fProjects = projects;

        final ILaunchConfiguration launchConfiguration = launch.getLaunchConfiguration();
        if (launchConfiguration != null) {
            fTestRunName = launchConfiguration.getName();
            fTestRunnerKind = YUnitLaunchConfigurationConstants.getTestRunnerKind(launchConfiguration);
        } else {
            fTestRunName = projects.get(0).getElementName();
            fTestRunnerKind = ITestKind.NULL;
        }

        try {
            fTestServer = launchConfiguration.getAttribute(YUnitLaunchConfigurationConstants.ATTR_TEST_SERVER, "unknown");
        } catch (final CoreException e) {
        }

        fTestRoot = new TestRoot(this);
        fIdToTest = new HashMap();

        fTestRunnerClient = new RemoteTestRunnerClient();
        fTestRunnerClient.startListening(new ITestRunListener2[] { new TestSessionNotifier() }, port);

        final ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
        launchManager.addLaunchListener(new ILaunchesListener2() {
            public void launchesTerminated(final ILaunch[] launches) {
                if (Arrays.asList(launches).contains(fLaunch)) {
                    if (fTestRunnerClient != null) {
                        fTestRunnerClient.stopWaiting();
                    }
                    launchManager.removeLaunchListener(this);
                }
            }

            public void launchesRemoved(final ILaunch[] launches) {
                if (Arrays.asList(launches).contains(fLaunch)) {
                    if (fTestRunnerClient != null) {
                        fTestRunnerClient.stopWaiting();
                    }
                    launchManager.removeLaunchListener(this);
                }
            }

            public void launchesChanged(final ILaunch[] launches) {
            }

            public void launchesAdded(final ILaunch[] launches) {
            }
        });

        fSessionListeners = new ListenerList();
        addTestSessionListener(new YUnitRunListenerAdapter(this));
    }

    void reset() {
        fStartedCount = 0;
        fFailureCount = 0;
        fErrorCount = 0;
        fIgnoredCount = 0;
        fTotalCount = 0;

        fTestRoot = new TestRoot(this);
        fTestResult = null;
        fIdToTest = new HashMap();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jdt.junit.ITestRunSession#getProgressState()
     */

    public ProgressState getProgressState() {
        if (isRunning()) {
            return ProgressState.RUNNING;
        }
        if (isStopped()) {
            return ProgressState.STOPPED;
        }
        return ProgressState.COMPLETED;
    }

    public IJavaProject getLaunchedProject() {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jdt.junit.model.ITestElement#getTestResult(boolean)
     */

    public Result getTestResult(final boolean includeChildren) {
        if (fTestRoot != null) {
            return fTestRoot.getTestResult(true);
        } else {
            return fTestResult;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jdt.junit.model.ITestElementContainer#getChildren()
     */

    public ITestElement[] getChildren() {
        return getTestRoot().getChildren();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jdt.junit.model.ITestElement#getFailureTrace()
     */

    public FailureTrace getFailureTrace() {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jdt.junit.model.ITestElement#getParentContainer()
     */

    public ITestElementContainer getParentContainer() {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jdt.junit.model.ITestElement#getTestRunSession()
     */

    public ITestRunSession getTestRunSession() {
        return this;
    }

    public TestRoot getTestRoot() {
        swapIn(); // TODO: TestRoot should stay (e.g. for getTestRoot().getStatus())
        return fTestRoot;
    }

    public List<IJavaProject> getLaunchedProjects() {
        return fProjects;
    }

    public ITestKind getTestRunnerKind() {
        return fTestRunnerKind;
    }

    public String getTestServer() {
        return fTestServer;
    }

    /**
     * @return the launch, or <code>null</code> iff this session was run externally
     */
    public ILaunch getLaunch() {
        return fLaunch;
    }

    public String getTestRunName() {
        return fTestRunName;
    }

    public int getErrorCount() {
        return fErrorCount;
    }

    public int getFailureCount() {
        return fFailureCount;
    }

    public int getStartedCount() {
        return fStartedCount;
    }

    public int getIgnoredCount() {
        return fIgnoredCount;
    }

    public int getTotalCount() {
        return fTotalCount;
    }

    public long getStartTime() {
        return fStartTime;
    }

    /**
     * @return <code>true</code> iff the session has been stopped or terminated
     */

    public boolean isStopped() {
        return fIsStopped;
    }

    public void addTestSessionListener(final ITestSessionListener listener) {
        swapIn();
        fSessionListeners.add(listener);
    }

    public void removeTestSessionListener(final ITestSessionListener listener) {
        fSessionListeners.remove(listener);
    }

    public void swapOut() {
        if (fTestRoot == null) {
            return;
        }
        if (isRunning() || isStarting()) {
            return;
        }

        final Object[] listeners = fSessionListeners.getListeners();
        for (int i = 0; i < listeners.length; ++i) {
            final ITestSessionListener registered = (ITestSessionListener) listeners[i];
            if (!registered.acceptsSwapToDisk()) {
                return;
            }
        }

        try {
            final File swapFile = getSwapFile();

            YUnitModel.exportFunctestRunSession(this, swapFile);
            fTestResult = fTestRoot.getTestResult(true);
            fTestRoot = null;
            fTestRunnerClient = null;
            fIdToTest = new HashMap();
            fIncompleteTestSuites = null;
            fUnrootedSuite = null;

        } catch (final IllegalStateException e) {
            YPlugin.logError(e);
        } catch (final CoreException e) {
            YPlugin.logError(e);
        }
    }

    public boolean isStarting() {
        return getStartTime() == 0 && fLaunch != null && !fLaunch.isTerminated();
    }

    public void removeSwapFile() {
        final File swapFile = getSwapFile();
        if (swapFile.exists()) {
            swapFile.delete();
        }
    }

    private File getSwapFile() throws IllegalStateException {
        final File historyDir = YPlugin.getHistoryDirectory();
        final String isoTime = new SimpleDateFormat("yyyyMMdd-HHmmss.SSS").format(new Date(getStartTime())); //$NON-NLS-1$
        final String swapFileName = isoTime + ".xml"; //$NON-NLS-1$
        return new File(historyDir, swapFileName);
    }

    public void swapIn() {
        if (fTestRoot != null) {
            return;
        }

        try {
            YUnitModel.importIntoFunctestRunSession(getSwapFile(), this);
        } catch (final IllegalStateException e) {
            YPlugin.logError(e);
            fTestRoot = new TestRoot(this);
            fTestResult = null;
        } catch (final CoreException e) {
            YPlugin.logError(e);
            fTestRoot = new TestRoot(this);
            fTestResult = null;
        }
    }

    public void stopTestRun() {
        if (isRunning()) {
            fIsStopped = true;
        }
        if (fTestRunnerClient != null) {
            fTestRunnerClient.stopTest();
        }
    }

    /**
     * @return <code>true</code> iff this session has been started, but not ended nor stopped nor terminated
     */

    public boolean isRunning() {
        return fIsRunning;
    }

    /**
     * @param testId
     * @param className
     * @param testName
     * @param launchMode
     * @return <code>false</code> iff the rerun could not be started
     * @throws CoreException
     */

    public boolean rerunTest(final String testId, final String className, final String testName, final String launchMode)
            throws CoreException {
        if (fLaunch != null) {
            // run the selected test using the previous launch configuration
            final ILaunchConfiguration launchConfiguration = fLaunch.getLaunchConfiguration();
            if (launchConfiguration != null) {

                String name = className;
                if (testName != null) {
                    name += "." + testName; //$NON-NLS-1$
                }
                final String configName = YUnitMessages.format(YUnitMessages.FunctestView_configName, name);
                final ILaunchConfigurationWorkingCopy tmp = launchConfiguration.copy(configName);
                // reset the container
                tmp.setAttribute(YUnitLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAMES, ""); //$NON-NLS-1$
                tmp.setAttribute(YUnitLaunchConfigurationConstants.ATTR_TEST_CONTAINERS, ""); //$NON-NLS-1$
                if (testName != null) {
                    tmp.setAttribute(YUnitLaunchConfigurationConstants.ATTR_TEST_METHOD_NAMES, testName);
                }
                tmp.launch(launchMode, null);
                return true;
            }
        }

        return false;
    }

    public boolean rerunTests(final List<IJavaElement> elements, final String launchMode) throws CoreException {
        if (fLaunch != null) {
            // run the selected test using the previous launch configuration
            final ILaunchConfiguration launchConfiguration = fLaunch.getLaunchConfiguration();
            final YUnitLaunchConfigurationElements elems = new YUnitLaunchConfigurationElements(elements);

            if (launchConfiguration != null) {
                final String configName = YUnitMessages.format(YUnitMessages.FunctestView_configName, launchConfiguration.getName());

                final ILaunchConfigurationWorkingCopy tmp = launchConfiguration.copy(configName);
                // reset the container
                tmp.setAttribute(YUnitLaunchConfigurationConstants.ATTR_PROJECT_NAMES, elems.getProjectNames());
                tmp.setAttribute(YUnitLaunchConfigurationConstants.ATTR_TEST_METHOD_NAMES, elems.getMethodNames());
                tmp.setAttribute(YUnitLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAMES, elems.getMainTypeQualifiedNames());
                tmp.setAttribute(YUnitLaunchConfigurationConstants.ATTR_TEST_CONTAINERS, elems.getContainerHandles());
                tmp.launch(launchMode, null);
                return true;
            }
        }

        return false;
    }

    public TestElement getTestElement(final String id) {
        return (TestElement) fIdToTest.get(id);
    }

    private TestElement addTreeEntry(final String treeEntry) {
        // format: testId","testName","isSuite","testcount
        final int index0 = treeEntry.indexOf(',');
        final String id = treeEntry.substring(0, index0);

        final StringBuffer testNameBuffer = new StringBuffer(100);
        final int index1 = scanTestName(treeEntry, index0 + 1, testNameBuffer);
        final String testName = testNameBuffer.toString().trim();

        final int index2 = treeEntry.indexOf(',', index1 + 1);
        final boolean isSuite = treeEntry.substring(index1 + 1, index2).equals("true"); //$NON-NLS-1$

        final int testCount = Integer.parseInt(treeEntry.substring(index2 + 1));

        if (fIncompleteTestSuites.isEmpty()) {
            return createTestElement(fTestRoot, id, testName, isSuite, testCount);
        } else {
            final int suiteIndex = fIncompleteTestSuites.size() - 1;
            final IncompleteTestSuite openSuite = (IncompleteTestSuite) fIncompleteTestSuites.get(suiteIndex);
            openSuite.fOutstandingChildren--;
            if (openSuite.fOutstandingChildren <= 0) {
                fIncompleteTestSuites.remove(suiteIndex);
            }
            return createTestElement(openSuite.fTestSuiteElement, id, testName, isSuite, testCount);
        }
    }

    public TestElement createTestElement(final TestSuiteElement parent, final String id, final String testName, final boolean isSuite,
            final int testCount) {
        TestElement testElement;
        if (isSuite) {
            final TestSuiteElement testSuiteElement = new TestSuiteElement(parent, id, testName, testCount);
            testElement = testSuiteElement;
            if (testCount > 0) {
                fIncompleteTestSuites.add(new IncompleteTestSuite(testSuiteElement, testCount));
            }
        } else {
            testElement = new TestCaseElement(parent, id, testName);
        }
        fIdToTest.put(id, testElement);
        return testElement;
    }

    public TestElement createFunctestSuite(final TestSuiteElement parent, final String id, final String testName, final int testCount) {
        final TestSuiteElement testSuiteElement = new TestSuiteElement(parent, id, testName, testCount);
        if (testCount > 0) {
            fIncompleteTestSuites.add(new IncompleteTestSuite(testSuiteElement, testCount));
        }
        fIdToTest.put(id, testSuiteElement);
        return testSuiteElement;
    }

    /**
     * Append the test name from <code>s</code> to <code>testName</code>.
     * 
     * @param s the string to scan
     * @param start the offset of the first character in <code>s</code>
     * @param testName the result
     * 
     * @return the index of the next ','
     */
    private int scanTestName(final String s, final int start, final StringBuffer testName) {
        boolean inQuote = false;
        int i = start;
        for (; i < s.length(); i++) {
            final char c = s.charAt(i);
            if (c == '\\' && !inQuote) {
                inQuote = true;
                continue;
            } else if (inQuote) {
                inQuote = false;
                testName.append(c);
            } else if (c == ',') {
                break;
            } else {
                testName.append(c);
            }
        }
        return i;
    }

    /**
     * An {@link ITestRunListener2} that listens to events from the {@link RemoteTestRunnerClient} and translates them into high-level model
     * events (broadcasted to {@link ITestSessionListener}s).
     */
    private class TestSessionNotifier implements ITestRunListener2 {

        public void testRunStarted(final int testCount) {
            fIncompleteTestSuites = new ArrayList();

            fStartedCount = 0;
            fIgnoredCount = 0;
            fFailureCount = 0;
            fErrorCount = 0;
            fTotalCount = testCount;

            fStartTime = System.currentTimeMillis();
            fIsRunning = true;

            final Object[] listeners = fSessionListeners.getListeners();
            for (int i = 0; i < listeners.length; ++i) {
                ((ITestSessionListener) listeners[i]).sessionStarted();
            }
        }

        public void testRunEnded(final long elapsedTime) {
            fIsRunning = false;

            final Object[] listeners = fSessionListeners.getListeners();
            for (int i = 0; i < listeners.length; ++i) {
                ((ITestSessionListener) listeners[i]).sessionEnded(elapsedTime);
            }
        }

        public void testRunStopped(final long elapsedTime) {
            fIsRunning = false;
            fIsStopped = true;

            final Object[] listeners = fSessionListeners.getListeners();
            for (int i = 0; i < listeners.length; ++i) {
                ((ITestSessionListener) listeners[i]).sessionStopped(elapsedTime);
            }
        }

        public void testRunTerminated() {
            fIsRunning = false;
            fIsStopped = true;

            final Object[] listeners = fSessionListeners.getListeners();
            for (int i = 0; i < listeners.length; ++i) {
                ((ITestSessionListener) listeners[i]).sessionTerminated();
            }
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jdt.internal.junit.model.ITestRunListener2#testTreeEntry( java.lang.String)
         */
        public void testTreeEntry(final String description) {
            final TestElement testElement = addTreeEntry(description);

            final Object[] listeners = fSessionListeners.getListeners();
            for (int i = 0; i < listeners.length; ++i) {
                ((ITestSessionListener) listeners[i]).testAdded(testElement);
            }
        }

        private TestElement createUnrootedTestElement(final String testId, final String testName) {
            final TestSuiteElement unrootedSuite = getUnrootedSuite();
            final TestElement testElement = createTestElement(unrootedSuite, testId, testName, false, 1);

            final Object[] listeners = fSessionListeners.getListeners();
            for (int i = 0; i < listeners.length; ++i) {
                ((ITestSessionListener) listeners[i]).testAdded(testElement);
            }

            return testElement;
        }

        private TestSuiteElement getUnrootedSuite() {
            if (fUnrootedSuite == null) {
                fUnrootedSuite = (TestSuiteElement) createFunctestSuite(fTestRoot, "-2", YUnitMessages.TestRunSession_unrootedTests, 0); //$NON-NLS-1$
            }
            return fUnrootedSuite;
        }

        public void testStarted(final String testId, final String testName) {
            if (fStartedCount == 0) {
                final Object[] listeners = fSessionListeners.getListeners();
                for (int i = 0; i < listeners.length; ++i) {
                    ((ITestSessionListener) listeners[i]).runningBegins();
                }
            }
            TestElement testElement = getTestElement(testId);
            if (testElement == null) {
                testElement = createUnrootedTestElement(testId, testName);
            } else if (!(testElement instanceof TestCaseElement)) {
                logUnexpectedTest(testId, testElement);
                return;
            }
            final TestCaseElement testCaseElement = (TestCaseElement) testElement;
            setStatus(testCaseElement, Status.RUNNING);

            fStartedCount++;

            final Object[] listeners = fSessionListeners.getListeners();
            for (int i = 0; i < listeners.length; ++i) {
                ((ITestSessionListener) listeners[i]).testStarted(testCaseElement);
            }
        }

        public void testEnded(final String testId, final String testName) {
            TestElement testElement = getTestElement(testId);
            if (testElement == null) {
                testElement = createUnrootedTestElement(testId, testName);
            } else if (!(testElement instanceof TestCaseElement)) {
                logUnexpectedTest(testId, testElement);
                return;
            }
            final TestCaseElement testCaseElement = (TestCaseElement) testElement;
            if (testName.startsWith(MessageIds.IGNORED_TEST_PREFIX)) {
                testCaseElement.setIgnored(true);
                fIgnoredCount++;
            }

            if (testCaseElement.getStatus() == Status.RUNNING) {
                setStatus(testCaseElement, Status.OK);
            }

            final Object[] listeners = fSessionListeners.getListeners();
            for (int i = 0; i < listeners.length; ++i) {
                ((ITestSessionListener) listeners[i]).testEnded(testCaseElement);
            }
        }

        public void testFailed(final int status, final String testId, final String testName, final String trace) {
            testFailed(status, testId, testName, trace, null, null);
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jdt.internal.junit.model.ITestRunListener2#testFailed(int, java.lang.String, java.lang.String, java.lang.String,
         * java.lang.String, java.lang.String)
         */
        public void testFailed(final int statusCode, final String testId, final String testName, final String trace, final String expected,
                final String actual) {
            TestElement testElement = getTestElement(testId);
            if (testElement == null) {
                testElement = createUnrootedTestElement(testId, testName);
                return;
            }

            final Status status = Status.convert(statusCode);
            registerTestFailureStatus(testElement, status, trace, nullifyEmpty(expected), nullifyEmpty(actual));

            final Object[] listeners = fSessionListeners.getListeners();
            for (int i = 0; i < listeners.length; ++i) {
                ((ITestSessionListener) listeners[i]).testFailed(testElement, status, trace, expected, actual);
            }
        }

        private String nullifyEmpty(final String string) {
            final int length = string.length();
            if (length == 0) {
                return null;
            } else if (string.charAt(length - 1) == '\n') {
                return string.substring(0, length - 1);
            } else {
                return string;
            }
        }

        public void testReran(final String testId, final String testClass, final String testName, final int status, final String trace) {
            testReran(testId, testClass, testName, status, trace, "", ""); //$NON-NLS-1$ //$NON-NLS-2$
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jdt.internal.junit.model.ITestRunListener2#testReran(java .lang.String, java.lang.String, java.lang.String, int,
         * java.lang.String, java.lang.String, java.lang.String)
         */
        public void testReran(final String testId, final String className, final String testName, final int statusCode, final String trace,
                final String expectedResult, final String actualResult) {
            TestElement testElement = getTestElement(testId);
            if (testElement == null) {
                testElement = createUnrootedTestElement(testId, testName);
            } else if (!(testElement instanceof TestCaseElement)) {
                logUnexpectedTest(testId, testElement);
                return;
            }
            final TestCaseElement testCaseElement = (TestCaseElement) testElement;

            final Status status = Status.convert(statusCode);
            registerTestFailureStatus(testElement, status, trace, nullifyEmpty(expectedResult), nullifyEmpty(actualResult));

            final Object[] listeners = fSessionListeners.getListeners();
            for (int i = 0; i < listeners.length; ++i) {
                // TODO: post old & new status?
                ((ITestSessionListener) listeners[i]).testReran(testCaseElement, status, trace, expectedResult, actualResult);
            }
        }

        private void logUnexpectedTest(final String testId, final TestElement testElement) {
            YPlugin.logError(new Exception("Unexpected TestElement type for testId '" + testId + "': " + testElement)); //$NON-NLS-1$ //$NON-NLS-2$
        }
    }

    private static class IncompleteTestSuite {
        public TestSuiteElement fTestSuiteElement;
        public int fOutstandingChildren;

        public IncompleteTestSuite(final TestSuiteElement testSuiteElement, final int outstandingChildren) {
            fTestSuiteElement = testSuiteElement;
            fOutstandingChildren = outstandingChildren;
        }
    }

    public void registerTestFailureStatus(final TestElement testElement, final Status status, final String trace, final String expected,
            final String actual) {
        testElement.setStatus(status, trace, expected, actual);
        if (status.isError()) {
            fErrorCount++;
        } else if (status.isFailure()) {
            fFailureCount++;
        }
    }

    public void registerTestEnded(final TestElement testElement, final boolean completed) {
        if (testElement instanceof TestCaseElement) {
            fTotalCount++;
            if (!completed) {
                return;
            }
            fStartedCount++;
            if (((TestCaseElement) testElement).isIgnored()) {
                fIgnoredCount++;
            }
            if (!testElement.getStatus().isErrorOrFailure()) {
                setStatus(testElement, Status.OK);
            }
        }
    }

    private void setStatus(final TestElement testElement, final Status status) {
        testElement.setStatus(status);
    }

    public TestElement[] getAllFailedTestElements() {
        final ArrayList failures = new ArrayList();
        addFailures(failures, getTestRoot());
        return (TestElement[]) failures.toArray(new TestElement[failures.size()]);
    }

    private void addFailures(final ArrayList failures, final ITestElement testElement) {
        final Result testResult = testElement.getTestResult(true);
        if (testResult == Result.ERROR || testResult == Result.FAILURE) {
            failures.add(testElement);
        }
        if (testElement instanceof TestSuiteElement) {
            final TestSuiteElement testSuiteElement = (TestSuiteElement) testElement;
            final ITestElement[] children = testSuiteElement.getChildren();
            for (int i = 0; i < children.length; i++) {
                addFailures(failures, children[i]);
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jdt.junit.model.ITestElement#getElapsedTimeInSeconds()
     */

    public double getElapsedTimeInSeconds() {
        if (fTestRoot == null) {
            return Double.NaN;
        }

        return fTestRoot.getElapsedTimeInSeconds();
    }
}
