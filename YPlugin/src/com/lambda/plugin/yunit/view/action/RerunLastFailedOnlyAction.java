package com.lambda.plugin.yunit.view.action;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.junit.model.TestCaseElement;
import org.eclipse.jdt.internal.junit.model.TestElement;
import org.eclipse.jdt.internal.junit.ui.JUnitPlugin;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;

import com.lambda.plugin.YPlugin;
import com.lambda.plugin.yunit.YUnitMessages;
import com.lambda.plugin.yunit.launcher.YUnitLaunchConfigurationConstants;
import com.lambda.plugin.yunit.launcher.YUnitLaunchConfigurationUtils;
import com.lambda.plugin.yunit.view.YUnitView;

public class RerunLastFailedOnlyAction extends Action {

	public static final String RERUN_FAILED_COMMAND = "com.kizoom.plugin.functest.launch.shortcut.rerunFailed"; //$NON-NLS-1$

	private IHandlerActivation activation;

	private final YUnitView view;

	public RerunLastFailedOnlyAction(YUnitView view) {
		this.view = view;
		setText(YUnitMessages.FunctestView_rerunfailuresonlyaction_label);
		setToolTipText(YUnitMessages.FunctestView_rerunfailuresonlyaction_tooltip);
		JUnitPlugin.setLocalImageDescriptors(this, "relaunchf.gif"); //$NON-NLS-1$
		setEnabled(false);
		setActionDefinitionId(RERUN_FAILED_COMMAND);
		activation = createActivation();
	}

	private IHandlerActivation createActivation() {
		IHandlerService handlerService = (IHandlerService) view.getSite().getWorkbenchWindow().getService(
				IHandlerService.class);

		IHandler handler = new AbstractHandler() {
			public Object execute(ExecutionEvent event) throws ExecutionException {
				run();
				return null;
			}

			@Override
			public boolean isEnabled() {
				return RerunLastFailedOnlyAction.this.isEnabled();
			}
		};
		return handlerService.activateHandler(RERUN_FAILED_COMMAND, handler);
	}

	@Override
	public void run() {
		rerunFailedTest();
	}

	public IHandlerActivation getActivation() {
		return activation;
	}

	private void rerunFailedTest() {
		ILaunch launch = getLaunch();
		if (launch != null && launch.getLaunchConfiguration() != null) {
			ILaunchConfiguration launchConfiguration = launch.getLaunchConfiguration();
			if (launchConfiguration != null) {
				try {
					String oldName = launchConfiguration.getName();
					String oldFailuresFilename = launchConfiguration.getAttribute(
							YUnitLaunchConfigurationConstants.ATTR_FAILURES_NAMES, (String) null);
					String configName;
					if (oldFailuresFilename != null) {
						configName = oldName;
					} else {
						configName = YUnitMessages.format(YUnitMessages.FunctestView_rerunFailedLaunchConfigName, oldName);
					}
					ILaunchConfigurationWorkingCopy tmp = launchConfiguration.copy(configName);
					tmp.setAttribute(YUnitLaunchConfigurationConstants.ATTR_FAILURES_NAMES, createFailureNamesFile());
					DebugUITools.launch(tmp, launch.getLaunchMode());
					return;
				} catch (CoreException e) {
					ErrorDialog.openError(view.getSite().getShell(), YUnitMessages.FunctestView_error_cannotrerun, e
							.getMessage(), e.getStatus());
				}
			}
			MessageDialog.openInformation(view.getSite().getShell(), YUnitMessages.FunctestView_cannotrerun_title,
					YUnitMessages.FunctestView_cannotrerurn_message);
		}
	}

	private String createFailureNamesFile() throws CoreException {
		try {
			File file = File.createTempFile("testFailures", ".txt"); //$NON-NLS-1$ //$NON-NLS-2$
			file.deleteOnExit();
			TestElement[] failures = view.getTestRunSession().getAllFailedTestElements();
			BufferedWriter bw = null;
			Map<String, IJavaProject> cache = new HashMap<String, IJavaProject>();

			try {
				bw = new BufferedWriter(new FileWriter(file));
				for (int i = 0; i < failures.length; i++) {
					if (failures[i] instanceof TestCaseElement) {
						TestCaseElement testElement = (TestCaseElement) failures[i];
						IJavaProject project = cache.get(testElement.getClassName());
						if (project == null) {
							project = findTestProject(testElement.getClassName());
							cache.put(testElement.getClassName(), project);
						}
						bw.write(YUnitLaunchConfigurationUtils.toString(testElement, project, '$'));
						bw.newLine();
					}
				}
			} finally {
				if (bw != null) {
					bw.close();
				}
			}
			return file.getAbsolutePath();
		} catch (IOException e) {
			throw new CoreException(new Status(IStatus.ERROR, YPlugin.PLUGIN_ID, IStatus.ERROR, "", e)); //$NON-NLS-1$
		}
	}

	private IJavaProject findTestProject(String className) {
		List<IJavaProject> projects = view.getLaunchedProjects();
		for (IJavaProject project : projects) {
			try {
				IType type = project.findType(className);
				if (type != null)
					return project;
			} catch (JavaModelException e) {
				// fall through
			}
		}
		return null;
	}

	public ILaunch getLaunch() {
		if (view.getTestRunSession() == null)
			return null;
		return view.getTestRunSession().getLaunch();
	}

}