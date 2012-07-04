package com.kizoom.plugin.functest.actions;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.internal.junit.launcher.ITestKind;
import org.eclipse.jdt.internal.junit.launcher.TestKindRegistry;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.IWorkbenchWindowActionDelegate;

import com.kizoom.plugin.ExceptionHandler;
import com.kizoom.plugin.functest.FunctestPlugin;
import com.kizoom.plugin.functest.launcher.FunctestLaunchShortcut;
import com.kizoom.plugin.functest.ui.ServerBlock;

public class RunFunctestsAction extends AbstractHandler implements IWorkbenchWindowActionDelegate {

	public static final String LOCAL = "com.kizoom.plugin.functest.RunFunctestLocal";
	public static final String STAGING = "com.kizoom.plugin.functest.RunFunctestStaging";
	public static final String PRODUCTION = "com.kizoom.plugin.functest.RunFunctestProduction";

	private IWorkbenchWindow window;
	private ISelection selection;
	private FunctestLaunchShortcut delegate;

	public RunFunctestsAction() {
		delegate = new FunctestLaunchShortcut();
		try {
			setBaseEnabled(FunctestPlugin.getDefault().getFunctestProjects().size() > 0);
		} catch (Exception e1) {
			setBaseEnabled(false);
		}
	}

	public void run(IAction action) {
		runFunctests(action.getId());
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		runFunctests(event.getCommand().getId());
		return null;
	}

	private void runFunctests(String id) {
		try {
			ITestKind kind = TestKindRegistry.getDefault().getKind(TestKindRegistry.JUNIT3_TEST_KIND_ID);
			String serverType = getServerType(id);
			delegate.launch(new StructuredSelection(FunctestPlugin.getDefault().getFunctestProjects()), "run", serverType);
		} catch (CoreException e) {
			ExceptionHandler.handle(e, getWindow().getShell(), "Error", "Error occured. See details for more information.");
		} catch (InvocationTargetException e) {
			ExceptionHandler.handle(e, getWindow().getShell(), "Error", "Error occured. See details for more information.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private String getServerType(String id) {
		if (LOCAL.equals(id))
			return ServerBlock.TYPE_LOCAL;
		else if (STAGING.equals(id))
			return ServerBlock.TYPE_TEST;
		else if (PRODUCTION.equals(id))
			return ServerBlock.TYPE_PROD;
		return null;
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	@Override
	public void dispose() {
	}

	public void init(IWorkbenchWindow window) {
		this.window = window;
	}

	protected IWorkbenchWindow getWindow() {
		return window;
	}

	protected ISelection getSelection() {
		return selection;
	}

	protected FunctestLaunchShortcut getDelegate() {
		return delegate;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	// @Override
	// public void setEnabled(Object evaluationContext) {
	// boolean enabled = false;
	// if (evaluationContext instanceof EvaluationContext) {
	// Object defaultVariable = ((EvaluationContext)
	// evaluationContext).getDefaultVariable();
	// if (defaultVariable instanceof Boolean) {
	// enabled = ((Boolean) defaultVariable).booleanValue();
	// setBaseEnabled(enabled);
	// }
	// }
	// }
}
