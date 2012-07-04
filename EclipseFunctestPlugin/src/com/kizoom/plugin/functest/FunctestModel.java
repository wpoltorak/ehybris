package com.kizoom.plugin.functest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchListener;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.internal.junit.BasicElementLabels;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.kizoom.plugin.KizoomPlugin;
import com.kizoom.plugin.functest.launcher.FunctestLaunchConfigurationConstants;
import com.kizoom.plugin.functest.launcher.FunctestLaunchConfigurationUtils;
import com.kizoom.plugin.functest.preferences.FunctestPreferencesConstants;
import com.kizoom.plugin.functest.view.FunctestView;

/**
 * Central registry for JUnit test runs.
 */
public class FunctestModel {

	private final class JUnitLaunchListener implements ILaunchListener {

		/**
		 * Used to track new launches. We need to do this so that we only attach a
		 * TestRunner once to a launch. Once a test runner is connected, it is
		 * removed from the set.
		 */
		private HashSet fTrackedLaunches = new HashSet(20);

		/*
		 * @see ILaunchListener#launchAdded(ILaunch)
		 */
		public void launchAdded(ILaunch launch) {
			fTrackedLaunches.add(launch);
		}

		/*
		 * @see ILaunchListener#launchRemoved(ILaunch)
		 */
		public void launchRemoved(final ILaunch launch) {
			fTrackedLaunches.remove(launch);
			// TODO: story for removing old test runs?
			// getDisplay().asyncExec(new Runnable() {
			// public void run() {
			// TestRunnerViewPart testRunnerViewPart=
			// findTestRunnerViewPartInActivePage();
			// if (testRunnerViewPart != null && testRunnerViewPart.isCreated() &&
			// launch.equals(testRunnerViewPart.getLastLaunch()))
			// testRunnerViewPart.reset();
			// }
			// });
		}

		/*
		 * @see ILaunchListener#launchChanged(ILaunch)
		 */
		public void launchChanged(final ILaunch launch) {
			if (!fTrackedLaunches.contains(launch))
				return;

			ILaunchConfiguration config = launch.getLaunchConfiguration();
			if (config == null)
				return;

			String server = null;
			try {
				server = config.getAttribute(FunctestLaunchConfigurationConstants.ATTR_TEST_SERVER, (String) null);
			} catch (CoreException e1) {
				return;
			}
			if (server == null)
				return;

			final Map<String, IJavaProject> javaProjects;
			try {
				javaProjects = FunctestLaunchConfigurationUtils.getJavaProjects(config);
				if (javaProjects.isEmpty())
					return;

			} catch (CoreException e1) {
				return;
			}

			// test whether the launch defines the JUnit attributes
			String portStr = launch.getAttribute(FunctestLaunchConfigurationConstants.ATTR_PORT);
			if (portStr == null)
				return;
			try {
				final int port = Integer.parseInt(portStr);
				fTrackedLaunches.remove(launch);
				getDisplay().asyncExec(new Runnable() {
					public void run() {
						connectTestRunner(launch, javaProjects, port);
					}
				});
			} catch (NumberFormatException e) {
				return;
			}
		}

		private void connectTestRunner(ILaunch launch, Map<String, IJavaProject> javaProjects, int port) {
			showTestRunnerViewPartInActivePage(findTestRunnerViewPartInActivePage());

			// TODO: Do notifications have to be sent in UI thread?
			// Check concurrent access to fFunctestRunSessions (no problem inside
			// asyncExec())
			int maxCount = FunctestPlugin.getDefault().getPreferenceStore().getInt(FunctestPreferencesConstants.MAX_TEST_RUNS);
			int toDelete = fFunctestRunSessions.size() - maxCount;
			while (toDelete > 0) {
				toDelete--;
				FunctestRunSession session = fFunctestRunSessions.removeLast();
				notifyFunctestRunSessionRemoved(session);
			}

			FunctestRunSession testRunSession = new FunctestRunSession(launch, new ArrayList<IJavaProject>(javaProjects.values()), port);
			addFunctestRunSession(testRunSession);
		}

		private FunctestView showTestRunnerViewPartInActivePage(FunctestView testRunner) {
			IWorkbenchPart activePart = null;
			IWorkbenchPage page = null;
			try {
				// TODO: have to force the creation of view part contents
				// otherwise the UI will not be updated
				if (testRunner != null && testRunner.isCreated())
					return testRunner;
				page = KizoomPlugin.getActivePage();
				if (page == null)
					return null;
				activePart = page.getActivePart();
				// show the result view if it isn't shown yet
				return (FunctestView) page.showView(FunctestView.NAME);
			} catch (PartInitException pie) {
				KizoomPlugin.logError(pie);
				return null;
			} finally {
				// restore focus stolen by the creation of the result view
				if (page != null && activePart != null)
					page.activate(activePart);
			}
		}

		private FunctestView findTestRunnerViewPartInActivePage() {
			IWorkbenchPage page = KizoomPlugin.getActivePage();
			if (page == null)
				return null;
			return (FunctestView) page.findView(FunctestView.NAME);
		}

		private Display getDisplay() {
			// Shell shell= getActiveWorkbenchShell();
			// if (shell != null) {
			// return shell.getDisplay();
			// }
			Display display = Display.getCurrent();
			if (display == null) {
				display = Display.getDefault();
			}
			return display;
		}
	}

	private final ListenerList fFunctestRunSessionListeners = new ListenerList();
	/**
	 * Active test run sessions, youngest first.
	 */
	private final LinkedList<FunctestRunSession> fFunctestRunSessions = new LinkedList<FunctestRunSession>();
	private final ILaunchListener fLaunchListener = new JUnitLaunchListener();

	/**
	 * Starts the model (called by the {@link FunctestPlugin} on startup).
	 */
	public void start() {
		ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
		launchManager.addLaunchListener(fLaunchListener);

		/*
		 * TODO: restore on restart: - only import headers! - only import last n
		 * sessions; remove all other files in historyDirectory
		 */
		// File historyDirectory= JUnitPlugin.getHistoryDirectory();
		// File[] swapFiles= historyDirectory.listFiles();
		// if (swapFiles != null) {
		// Arrays.sort(swapFiles, new Comparator() {
		// public int compare(Object o1, Object o2) {
		// String name1= ((File) o1).getName();
		// String name2= ((File) o2).getName();
		// return name1.compareTo(name2);
		// }
		// });
		// for (int i= 0; i < swapFiles.length; i++) {
		// final File file= swapFiles[i];
		// SafeRunner.run(new ISafeRunnable() {
		// public void run() throws Exception {
		// importFunctestRunSession(file );
		// }
		// public void handleException(Throwable exception) {
		// JUnitPlugin.log(exception);
		// }
		// });
		// }
		// }
	}

	/**
	 * Stops the model (called by the {@link KizoomPlugin} on shutdown).
	 */
	public void stop() {
		ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
		launchManager.removeLaunchListener(fLaunchListener);

		File historyDirectory = FunctestPlugin.getHistoryDirectory();
		File[] swapFiles = historyDirectory.listFiles();
		if (swapFiles != null) {
			for (int i = 0; i < swapFiles.length; i++) {
				swapFiles[i].delete();
			}
		}

		// for (Iterator iter= fFunctestRunSessions.iterator(); iter.hasNext();) {
		// final FunctestRunSession session= (FunctestRunSession) iter.next();
		// SafeRunner.run(new ISafeRunnable() {
		// public void run() throws Exception {
		// session.swapOut();
		// }
		// public void handleException(Throwable exception) {
		// JUnitPlugin.log(exception);
		// }
		// });
		// }
	}

	public void addFunctestRunSessionListener(IFunctestRunSessionListener listener) {
		fFunctestRunSessionListeners.add(listener);
	}

	public void removeFunctestRunSessionListener(IFunctestRunSessionListener listener) {
		fFunctestRunSessionListeners.remove(listener);
	}

	/**
	 * @return a list of active {@link FunctestRunSession}s. The list is a copy of
	 *         the internal data structure and modifications do not affect the
	 *         global list of active sessions. The list is sorted by age, youngest
	 *         first.
	 */
	public List<FunctestRunSession> getFunctestRunSessions() {
		return new ArrayList<FunctestRunSession>(fFunctestRunSessions);
	}

	/**
	 * Adds the given {@link FunctestRunSession} and notifies all registered
	 * {@link IFunctestRunSessionListener}s.
	 * <p>
	 * <b>To be called in the UI thread only!</b>
	 * </p>
	 * 
	 * @param testRunSession
	 *          the session to add
	 */
	public void addFunctestRunSession(FunctestRunSession testRunSession) {
		Assert.isNotNull(testRunSession);
		Assert.isLegal(!fFunctestRunSessions.contains(testRunSession));
		fFunctestRunSessions.addFirst(testRunSession);
		notifyFunctestRunSessionAdded(testRunSession);
	}

	/**
	 * Imports a test run session from the given file.
	 * 
	 * @param file
	 *          a file containing a test run session transcript
	 * @return the imported test run session
	 * @throws CoreException
	 *           if the import failed
	 */
	public static FunctestRunSession importFunctestRunSession(File file) throws CoreException {
		try {
			SAXParserFactory parserFactory = SAXParserFactory.newInstance();
			// parserFactory.setValidating(true); // TODO: add DTD and debug flag
			SAXParser parser = parserFactory.newSAXParser();
			FunctestRunHandler handler = new FunctestRunHandler();
			parser.parse(file, handler);
			FunctestRunSession session = handler.getTestRunSession();
			FunctestPlugin.getModel().addFunctestRunSession(session);
			return session;
		} catch (ParserConfigurationException e) {
			throwImportError(file, e);
		} catch (SAXException e) {
			throwImportError(file, e);
		} catch (IOException e) {
			throwImportError(file, e);
		}
		return null; // does not happen
	}

	public static void importIntoFunctestRunSession(File swapFile, FunctestRunSession testRunSession)
			throws CoreException {
		try {
			SAXParserFactory parserFactory = SAXParserFactory.newInstance();
			// parserFactory.setValidating(true); // TODO: add DTD and debug flag
			SAXParser parser = parserFactory.newSAXParser();
			FunctestRunHandler handler = new FunctestRunHandler(testRunSession);
			parser.parse(swapFile, handler);
		} catch (ParserConfigurationException e) {
			throwImportError(swapFile, e);
		} catch (SAXException e) {
			throwImportError(swapFile, e);
		} catch (IOException e) {
			throwImportError(swapFile, e);
		}
	}

	/**
	 * Exports the given test run session.
	 * 
	 * @param testRunSession
	 *          the test run session
	 * @param file
	 *          the destination
	 * @throws CoreException
	 */
	public static void exportFunctestRunSession(FunctestRunSession testRunSession, File file) throws CoreException {
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(file);
			exportFunctestRunSession(testRunSession, out);

		} catch (IOException e) {
			throwExportError(file, e);
		} catch (TransformerConfigurationException e) {
			throwExportError(file, e);
		} catch (TransformerException e) {
			throwExportError(file, e);
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e2) {
					KizoomPlugin.logError(e2);
				}
			}
		}
	}

	public static void exportFunctestRunSession(FunctestRunSession testRunSession, OutputStream out)
			throws TransformerFactoryConfigurationError, TransformerException {

		Transformer transformer = TransformerFactory.newInstance().newTransformer();
		InputSource inputSource = new InputSource();
		SAXSource source = new SAXSource(new FunctestRunSessionSerializer(testRunSession), inputSource);
		StreamResult result = new StreamResult(out);
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8"); //$NON-NLS-1$
		transformer.setOutputProperty(OutputKeys.INDENT, "yes"); //$NON-NLS-1$
		/*
		 * Bug in Xalan: Only indents if proprietary property
		 * org.apache.xalan.templates.OutputProperties.S_KEY_INDENT_AMOUNT is set.
		 * 
		 * Bug in Xalan as shipped with J2SE 5.0: Does not read the indent-amount
		 * property at all >:-(.
		 */
		try {
			transformer.setOutputProperty("{http://xml.apache.org/xalan}indent-amount", "2"); //$NON-NLS-1$ //$NON-NLS-2$
		} catch (IllegalArgumentException e) {
			// no indentation today...
		}
		transformer.transform(source, result);
	}

	private static void throwExportError(File file, Exception e) throws CoreException {
		throw new CoreException(new org.eclipse.core.runtime.Status(IStatus.ERROR, FunctestPlugin.PLUGIN_ID, FunctestMessages
				.format(FunctestMessages.FunctestModel_could_not_write, BasicElementLabels.getPathLabel(file)), e));
	}

	private static void throwImportError(File file, Exception e) throws CoreException {
		throw new CoreException(new org.eclipse.core.runtime.Status(IStatus.ERROR, FunctestPlugin.PLUGIN_ID, FunctestMessages
				.format(FunctestMessages.FunctestModel_could_not_read, BasicElementLabels.getPathLabel(file)), e));
	}

	/**
	 * Removes the given {@link FunctestRunSession} and notifies all registered
	 * {@link IFunctestRunSessionListener}s.
	 * <p>
	 * <b>To be called in the UI thread only!</b>
	 * </p>
	 * 
	 * @param testRunSession
	 *          the session to remove
	 */
	public void removeFunctestRunSession(FunctestRunSession testRunSession) {
		boolean existed = fFunctestRunSessions.remove(testRunSession);
		if (existed) {
			notifyFunctestRunSessionRemoved(testRunSession);
		}
		testRunSession.removeSwapFile();
	}

	private void notifyFunctestRunSessionRemoved(FunctestRunSession testRunSession) {
		testRunSession.stopTestRun();
		ILaunch launch = testRunSession.getLaunch();
		if (launch != null) {
			ILaunchManager launchManager = DebugPlugin.getDefault().getLaunchManager();
			launchManager.removeLaunch(launch);
		}

		Object[] listeners = fFunctestRunSessionListeners.getListeners();
		for (int i = 0; i < listeners.length; ++i) {
			((IFunctestRunSessionListener) listeners[i]).sessionRemoved(testRunSession);
		}
	}

	private void notifyFunctestRunSessionAdded(FunctestRunSession testRunSession) {
		Object[] listeners = fFunctestRunSessionListeners.getListeners();
		for (int i = 0; i < listeners.length; ++i) {
			((IFunctestRunSessionListener) listeners[i]).sessionAdded(testRunSession);
		}
	}

}
