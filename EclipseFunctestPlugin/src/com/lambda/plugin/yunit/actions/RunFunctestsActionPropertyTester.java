package com.lambda.plugin.yunit.actions;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.jface.viewers.ISelection;

import com.lambda.plugin.yunit.FunctestPlugin;

public class RunFunctestsActionPropertyTester extends PropertyTester {

	public static final String PROPERTY_FUNCTEST_EXIST_IN_WORKSPACE = "functestExist"; //$NON-NLS-1$

	public boolean test(Object receiver, String property, Object[] args,
			Object expectedValue) {
		if (receiver instanceof ISelection){
			if (PROPERTY_FUNCTEST_EXIST_IN_WORKSPACE.equals(property)) {
				return functestProjectsExistsInWorkspace();
			}
		}
		return false;
	}

	private boolean functestProjectsExistsInWorkspace() {
		try {
			boolean noFunctest = FunctestPlugin.getDefault()
					.getFunctestProjects().isEmpty();
			return !noFunctest;
		} catch (Exception e) {
			return false;
		}
	}

}
