package com.kizoom.plugin.functest.actions;

import java.util.List;
import java.util.Map;

import org.eclipse.jface.action.IAction;

import com.kizoom.plugin.functest.FunctestPlugin;

public class RerunFailedFunctestsAction extends RunFunctestsAction {

	public RerunFailedFunctestsAction() {
		super();
	}

	public void run(IAction action) {
		Map<String, List<String>> failures = FunctestPlugin.getDefault().getFunctestManager().getFailedTests();
		if (failures.isEmpty())
			return;

		// String environment = functestDialog.getEnvironment();
		// if (environment == null) {
		// KizoomPlugin.logWarning(
		// "No environment has been selected for functest run.", null);
		// return;
		// }

		// saveEnvironment(selection);

//		try {
//			List<IJavaProject> projects = getFunctests();
//			getDelegate().launch(new StructuredSelection(projects), "run");

//		} catch (CoreException e) {
//			ExceptionHandler.handle(e, getWindow().getShell(), "Error", "Error occured. See details for more information.");
//		}

	}
}
