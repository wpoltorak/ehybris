package com.lambda.plugin.yunit.view.action;

import java.util.List;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.action.Action;

import com.lambda.plugin.yunit.view.YUnitView;

public class RerunAction extends Action {

	private YUnitView fTestRunner;
	private String fLaunchMode;
	private List<IJavaElement> elements;

	public RerunAction(String actionName,
			YUnitView runner, List<IJavaElement> elems, String launchMode) {
		super(actionName);
		this.fTestRunner = runner;
		this.elements = elems;
		this.fLaunchMode = launchMode;
	}

	/*
	 * @see IAction#run()
	 */
	@Override
	public void run() {
		fTestRunner.rerunTests(elements, fLaunchMode);
	}
}
