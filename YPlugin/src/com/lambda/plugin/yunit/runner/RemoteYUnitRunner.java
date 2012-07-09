package com.lambda.plugin.yunit.runner;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.eclipse.jdt.internal.junit.runner.DefaultClassifier;
import org.eclipse.jdt.internal.junit.runner.IClassifiesThrowables;
import org.eclipse.jdt.internal.junit.runner.ITestIdentifier;
import org.eclipse.jdt.internal.junit.runner.ITestReference;
import org.eclipse.jdt.internal.junit.runner.IVisitsTestTrees;
import org.eclipse.jdt.internal.junit.runner.MessageIds;
import org.eclipse.jdt.internal.junit.runner.MessageSender;
import org.eclipse.jdt.internal.junit.runner.TestExecution;
import org.eclipse.jdt.internal.junit.runner.TestIdMap;

public class RemoteYUnitRunner implements MessageSender, IVisitsTestTrees {

	public static final String RERAN_FAILURE = "FAILURE"; //$NON-NLS-1$

	public static final String RERAN_ERROR = "ERROR"; //$NON-NLS-1$

	public static final String RERAN_OK = "OK"; //$NON-NLS-1$

	private Map<String, Map<String, List<String>>> projectClassMethodNames = new HashMap<String, Map<String, List<String>>>();
	/**
	 * The current test result
	 */
	private TestExecution fExecution;

	/**
	 * The version expected by the client
	 */
	private String fVersion = ""; //$NON-NLS-1$

	/**
	 * The client socket.
	 */
	private Socket fClientSocket;
	/**
	 * Print writer for sending messages
	 */
	private PrintWriter fWriter;
	/**
	 * Reader for incoming messages
	 */
	private BufferedReader fReader;
	/**
	 * Host to connect to, default is the localhost
	 */
	private String fHost = ""; //$NON-NLS-1$
	/**
	 * Port to connect to.
	 */
	private int fPort = -1;
	/**
	 * Is the debug mode enabled?
	 */
	private boolean fDebugMode = false;

	/**
	 * Has the server been stopped
	 */
	private boolean fStopped = false;
	/**
	 * Queue of rerun requests.
	 */
	private Vector<RerunRequest> fRerunRequests = new Vector<RerunRequest>(10);
	/**
	 * Thread reading from the socket
	 */
	private ReaderThread fReaderThread;

	private final TestIdMap fIds = new TestIdMap();

	private Map<String, Map<String, List<String>>> fFailureNames = new HashMap<String, Map<String, List<String>>>();

	private IYUnitLoader fLoader;

	private MessageSender fSender;

	private boolean fConsoleMode = false;

	public RemoteYUnitRunner() {
		setMessageSender(this);
	}

	public void setMessageSender(MessageSender sender) {
		fSender = sender;
	}

	/**
	 * Parse command line arguments. Hook for subclasses to process additional
	 * arguments.
	 */

	protected void init(String[] args) {
		for (int i = 0; i < args.length; i++) {
			if (args[i].toLowerCase().equals("-testnamefile")) { //$NON-NLS-1$
				String testNameFile = args[i + 1];
				try {
					readTestNames(projectClassMethodNames, testNameFile);
				} catch (IOException e) {
					throw new IllegalArgumentException(
							"Cannot read testname file."); //$NON-NLS-1$
				}
				i++;
			} else if (args[i].toLowerCase().equals("-testfailures")) { //$NON-NLS-1$
				String testFailuresFile = args[i + 1];
				try {
					readTestNames(fFailureNames, testFailuresFile);
				} catch (IOException e) {
					throw new IllegalArgumentException(
							"Cannot read testfailures file."); //$NON-NLS-1$
				}
				i++;

			} else if (args[i].toLowerCase().equals("-port")) { //$NON-NLS-1$
				fPort = Integer.parseInt(args[i + 1]);
				i++;
			} else if (args[i].toLowerCase().equals("-host")) { //$NON-NLS-1$
				fHost = args[i + 1];
				i++;
			} else if (args[i].toLowerCase().equals("-testserver")) {
				setServerName(args[i + 1]);
				i++;
			} else if (args[i].toLowerCase().equals("-debugging") || args[i].toLowerCase().equals("-debug")) { //$NON-NLS-1$ //$NON-NLS-2$
				fDebugMode = true;
			} else if (args[i].toLowerCase().equals("-version")) { //$NON-NLS-1$
				fVersion = args[i + 1];
				i++;
			} else if (args[i].toLowerCase().equals("-junitconsole")) { //$NON-NLS-1$
				fConsoleMode = true;
			} else if (args[i].toLowerCase().equals("-junitversion")) { //$NON-NLS-1$
				createLoader(Integer.parseInt(args[i + 1]));
				i++;
			}
		}

		if (getTestLoader() == null)
			initDefaultLoader();

		if (projectClassMethodNames.keySet().isEmpty())
			throw new IllegalArgumentException(YUnitMessages
					.getString("RemoteFunctestRunner_error_classnamemissing"));

		if (fPort == -1)
			throw new IllegalArgumentException(YUnitMessages
					.getString("RemoteFunctestRunner_error_portmissing"));
	}

	private void setServerName(String name) {
		if ("local".equals(name))
			System.setProperty("com.kizoom.common.environment", "local");
		else if ("test".equals(name))
			System.setProperty("com.kizoom.common.environment", "test");
		else if ("prod".equals(name))
			System.setProperty("com.kizoom.common.environment", "production");
		else
			System.setProperty("com.kizoom.functest.Services.targetServer",
					name);
	}

	/**
	 * The class loader to be used for loading tests. Subclasses may override to
	 * use another class loader.
	 */

	protected ClassLoader getTestClassLoader() {
		return getClass().getClassLoader();
	}

	public void initDefaultLoader() {
		createLoader(3);
	}

	public void createLoader(int junitVersion) {
		setLoader(createRawTestLoader(junitVersion));
	}

	protected IYUnitLoader createRawTestLoader(int junitVersion) {
		// try {
		return new YUnitLoader(junitVersion);
		// } catch (Exception e) {
		// StringWriter trace = new StringWriter();
		// e.printStackTrace(new PrintWriter(trace));
		// String message = FunctestMessages.format(FunctestMessages.
		// RemoteFunctestRunner_error_invalidloader, new Object[] {
		// className, trace.toString() });
		// throw new IllegalArgumentException(message);
		// }
	}

	protected Class<?> loadTestLoaderClass(String className)
			throws ClassNotFoundException {
		return Class.forName(className);
	}

	public void setLoader(IYUnitLoader newInstance) {
		fLoader = newInstance;
	}

	private void readTestNames(Map<String, Map<String, List<String>>> projectClassMethodNames, String testNameFile) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(
				testNameFile)));
		try {
			String line;
			while ((line = br.readLine()) != null) {
				String[] projectTypeMethod = split(line);
				if (projectTypeMethod.length == 2) {
					Map<String, List<String>> classMethodNames = projectClassMethodNames
							.get(projectTypeMethod[0]);
					if (classMethodNames == null) {
						classMethodNames = new HashMap<String, List<String>>();
						projectClassMethodNames.put(projectTypeMethod[0],
								classMethodNames);
					}
					classMethodNames.put(projectTypeMethod[1], null);
				} else if (projectTypeMethod.length == 3) {
					Map<String, List<String>> classMethodNames = projectClassMethodNames
							.get(projectTypeMethod[0]);
					if (classMethodNames == null) {
						classMethodNames = new HashMap<String, List<String>>();
						projectClassMethodNames.put(projectTypeMethod[0],
								classMethodNames);
					}
					List<String> methods = classMethodNames
							.get(projectTypeMethod[1]);
					if (methods == null) {
						methods = new ArrayList<String>();
						classMethodNames.put(projectTypeMethod[1], methods);
					}
					methods.add(projectTypeMethod[2]);
				}
			}
		} finally {
			br.close();
		}
	}

	/**
	 * returns [project, class, method] or [project, class]
	 * 
	 * @param elementString
	 * @return
	 */
	public static String[] split(String elementString) {
		int index = -1;
		if (elementString == null || (index = elementString.indexOf('@')) < 0)
			return new String[] { elementString }; // compilation unit
		String element = elementString.substring(0, index);
		String project = elementString.substring(index + 1);
		String[] packageAndMethod = element.split(":");
		if (packageAndMethod.length == 1)
			// type, project
			return new String[] { project, element };
		// type, method, project
		return new String[] { project, packageAndMethod[0], packageAndMethod[1] };
	}

	/**
	 * Connects to the remote ports and runs the tests.
	 */
	protected void run() {
		if (!connect())
			return;
		FirstRunTestExecutionListener listener = firstRunTestExecutionListener();
		fExecution = new TestExecution(listener, getClassifier());
		runTests(fExecution);
		shutDown();
	}

	public FirstRunTestExecutionListener firstRunTestExecutionListener() {
		return new FirstRunTestExecutionListener(fSender, fIds);
	}

	public void runFailed(String message, Exception exception) {
		// TODO: remove System.err.println?
		System.err.println(message);
		if (exception != null)
			exception.printStackTrace(System.err);
	}

	protected Class<?>[] loadClasses(String[] testClassNames) {
		Vector<Class<?>> classes = new Vector<Class<?>>();
		for (int i = 0; i < testClassNames.length; i++) {
			String name = testClassNames[i];
			Class<?> clazz = loadClass(name, this);
			if (clazz != null) {
				classes.add(clazz);
			}
		}
		return classes.toArray(new Class[classes.size()]);
	}

	protected void notifyListenersOfTestEnd(TestExecution execution,
			long testStartTime) {
		if (execution == null || execution.shouldStop())
			notifyTestRunStopped(System.currentTimeMillis() - testStartTime);
		else
			notifyTestRunEnded(System.currentTimeMillis() - testStartTime);
	}

	/**
	 * Runs a set of tests.
	 */

	public void runTests(
			Map<String, Map<String, List<String>>> projectClassMethodNames,
			TestExecution execution) {
		List<ITestReference> suites = fLoader.loadTests(
				projectClassMethodNames, fFailureNames, this);

		// count all testMethods and inform ITestRunListeners
		int count = countTests(suites);
		System.out.println(count);
		notifyTestRunStarted(count);

		if (count == 0) {
			notifyTestRunEnded(0);
			return;
		}

		sendTrees(suites);

		long testStartTime = System.currentTimeMillis();
		execution.run(suites.toArray(new ITestReference[suites.size()]));
		notifyListenersOfTestEnd(execution, testStartTime);
	}

	private void sendTrees(List<ITestReference> suites) {
		long startTime = System.currentTimeMillis();
		if (fDebugMode)
			System.out.print("start send tree..."); //$NON-NLS-1$
		for (ITestReference test : suites) {
			test.sendTree(this);
		}
		if (fDebugMode)
			System.out
					.println("done send tree - time(ms): " + (System.currentTimeMillis() - startTime)); //$NON-NLS-1$
	}

	private int countTests(List<ITestReference> tests) {
		int count = 0;
		for (ITestReference test : tests) {
			if (test != null)
				count = count + test.countTestCases();
		}
		return count;
	}

	public RerunTestExecutionListener rerunExecutionListener() {
		return new RerunTestExecutionListener(fSender, fIds);
	}

	protected IClassifiesThrowables getClassifier() {
		return new DefaultClassifier(fVersion);
	}

	public void visitTreeEntry(ITestIdentifier id, boolean b, int i) {
		notifyTestTreeEntry(getTestId(id) + ',' + escapeComma(id.getName())
				+ ',' + b + ',' + i);
	}

	private String escapeComma(String s) {
		if ((s.indexOf(',') < 0) && (s.indexOf('\\') < 0))
			return s;
		StringBuffer sb = new StringBuffer(s.length() + 10);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ',')
				sb.append("\\,"); //$NON-NLS-1$
			else if (c == '\\')
				sb.append("\\\\"); //$NON-NLS-1$
			else
				sb.append(c);
		}
		return sb.toString();
	}

	// WANT: work in bug fixes since RC2?
	private String getTestId(ITestIdentifier id) {
		return fIds.getTestId(id);
	}

	/**
	 * Stop the current test run.
	 */

	protected void stop() {
		if (fExecution != null) {
			fExecution.stop();
		}
	}

	/**
	 * Connect to the remote test listener.
	 */

	protected boolean connect() {
		if (fConsoleMode) {
			fClientSocket = null;
			fWriter = new PrintWriter(System.out);
			fReader = new BufferedReader(new InputStreamReader(System.in));
			fReaderThread = new ReaderThread();
			fReaderThread.start();
			return true;
		}
		if (fDebugMode)
			System.out
					.println("RemoteTestRunner: trying to connect" + fHost + ":" + fPort); //$NON-NLS-1$ //$NON-NLS-2$
		Exception exception = null;
		for (int i = 1; i < 20; i++) {
			try {
				fClientSocket = new Socket(fHost, fPort);
				try {
					fWriter = new PrintWriter(new BufferedWriter(
							new OutputStreamWriter(fClientSocket
									.getOutputStream(), "UTF-8")), false/* true */); //$NON-NLS-1$
				} catch (UnsupportedEncodingException e1) {
					fWriter = new PrintWriter(new BufferedWriter(
							new OutputStreamWriter(fClientSocket
									.getOutputStream())), false/* true */);
				}
				try {
					fReader = new BufferedReader(new InputStreamReader(
							fClientSocket.getInputStream(), "UTF-8")); //$NON-NLS-1$
				} catch (UnsupportedEncodingException e1) {
					fReader = new BufferedReader(new InputStreamReader(
							fClientSocket.getInputStream()));
				}
				fReaderThread = new ReaderThread();
				fReaderThread.start();
				return true;
			} catch (IOException e) {
				exception = e;
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
		}
		runFailed(YUnitMessages.getFormattedString(
				"RemoteFunctestRunner_error_connect", new String[] { fHost,
						Integer.toString(fPort) }), exception);
		return false;
	}

	/**
	 * Shutsdown the connection to the remote test listener.
	 */
	private void shutDown() {
		if (fWriter != null) {
			fWriter.close();
			fWriter = null;
		}
		try {
			if (fReaderThread != null) {
				// interrupt reader thread so that we don't block on close
				// on a lock held by the BufferedReader
				// fix for bug: 38955
				fReaderThread.interrupt();
			}
			if (fReader != null) {
				fReader.close();
				fReader = null;
			}
		} catch (IOException e) {
			if (fDebugMode)
				e.printStackTrace();
		}

		try {
			if (fClientSocket != null) {
				fClientSocket.close();
				fClientSocket = null;
			}
		} catch (IOException e) {
			if (fDebugMode)
				e.printStackTrace();
		}
	}

	/*
	 * @see
	 * org.eclipse.jdt.internal.junit.runner.MessageSender#sendMessage(java.lang
	 * .String)
	 */

	public void sendMessage(String msg) {
		if (fWriter == null)
			return;
		fWriter.println(msg);
		// if (!fConsoleMode)
		// System.out.println(msg);
	}

	protected void notifyTestRunStarted(int testCount) {
		fSender.sendMessage(MessageIds.TEST_RUN_START + testCount + " " + "v2"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	private void notifyTestRunEnded(long elapsedTime) {
		fSender.sendMessage(MessageIds.TEST_RUN_END + elapsedTime);
		fSender.flush();
		// shutDown();
	}

	protected void notifyTestRunStopped(long elapsedTime) {
		fSender.sendMessage(MessageIds.TEST_STOPPED + elapsedTime);
		fSender.flush();
		// shutDown();
	}

	protected void notifyTestTreeEntry(String treeEntry) {
		fSender.sendMessage(MessageIds.TEST_TREE + treeEntry);
	}

	/*
	 * @seeorg.eclipse.jdt.internal.junit.runner.RerunCompletionListener#
	 * notifyRerunComplete(org.eclipse.jdt.internal.junit.runner.RerunRequest,
	 * java.lang.String)
	 */
	public void notifyRerunComplete(RerunRequest r, String status) {
		if (fPort != -1) {
			fSender
					.sendMessage(MessageIds.TEST_RERAN
							+ r.fRerunTestId
							+ " " + r.fRerunClassName + " " + r.fRerunTestName + " " + status); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
			fSender.flush();
		}
	}

	public void flush() {
		fWriter.flush();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.jdt.internal.junit.runner.TestRunner#runTests(org.eclipse.jdt
	 * .internal.junit.runner.RemoteTestRunner.TestExecution)
	 */

	public void runTests(TestExecution execution) {
		runTests(projectClassMethodNames, execution);
	}

	public IYUnitLoader getTestLoader() {
		return fLoader;
	}

	public Class loadClass(String className, RemoteYUnitRunner listener) {
		Class clazz = null;
		try {
			clazz = getTestClassLoader().loadClass(className);
		} catch (ClassNotFoundException e) {
			listener.runFailed(YUnitMessages.getFormattedString(
					"RemoteFunctestRunner_error_classnotfound", className), e);
		}
		return clazz;
	}

	public static void main(String[] args) {
		try {
			System.out.println("Main method");
			RemoteYUnitRunner testRunServer = new RemoteYUnitRunner();
			testRunServer.init(args);
			testRunServer.run();
		} catch (Throwable e) {
			e.printStackTrace(); // don't allow System.exit(0) to swallow
									// exceptions
		} finally {
			// fix for 14434
			System.exit(0);
		}
	}

	/**
	 * Holder for information for a rerun request
	 */
	private static class RerunRequest {
		String fRerunClassName;
		String fRerunTestName;
		int fRerunTestId;

		public RerunRequest(int testId, String className, String testName) {
			fRerunTestId = testId;
			fRerunClassName = className;
			fRerunTestName = testName;
		}

	}

	/**
	 * Reader thread that processes messages from the client.
	 */
	private class ReaderThread extends Thread {
		public ReaderThread() {
			super("ReaderThread"); //$NON-NLS-1$
		}

		@Override
		public void run() {
			try {
				String message = null;
				while (true) {
					if ((message = fReader.readLine()) != null) {

						if (message.startsWith(MessageIds.TEST_STOP)) {
							fStopped = true;
							RemoteYUnitRunner.this.stop();
							synchronized (RemoteYUnitRunner.this) {
								RemoteYUnitRunner.this.notifyAll();
							}
							break;
						}

						else if (message.startsWith(MessageIds.TEST_RERUN)) {
							String arg = message
									.substring(MessageIds.MSG_HEADER_LENGTH);
							// format: testId className testName
							int c0 = arg.indexOf(' ');
							int c1 = arg.indexOf(' ', c0 + 1);
							String s = arg.substring(0, c0);
							int testId = Integer.parseInt(s);
							String className = arg.substring(c0 + 1, c1);
							String testName = arg.substring(c1 + 1, arg
									.length());
							synchronized (RemoteYUnitRunner.this) {
								fRerunRequests.add(new RerunRequest(testId,
										className, testName));
								RemoteYUnitRunner.this.notifyAll();
							}
						}
					}
				}
			} catch (Exception e) {
				RemoteYUnitRunner.this.stop();
			}
		}
	}
}
