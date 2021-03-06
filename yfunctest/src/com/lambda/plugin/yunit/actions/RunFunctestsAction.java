package com.lambda.plugin.yunit.actions;

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

import com.lambda.plugin.ExceptionHandler;
import com.lambda.plugin.YPlugin;
import com.lambda.plugin.yunit.launcher.YUnitLaunchShortcut;
import com.lambda.plugin.yunit.ui.ServerBlock;

public class RunFunctestsAction extends AbstractHandler implements IWorkbenchWindowActionDelegate {

    public static final String LOCAL = "com.lambda.plugin.yunit.RunFunctestLocal";
    public static final String STAGING = "com.lambda.plugin.yunit.RunFunctestStaging";
    public static final String PRODUCTION = "com.lambda.plugin.yunit.RunFunctestProduction";

    private IWorkbenchWindow window;
    private ISelection selection;
    private final YUnitLaunchShortcut delegate;

    public RunFunctestsAction() {
        delegate = new YUnitLaunchShortcut();
        try {
            setBaseEnabled(YPlugin.getDefault().getFunctestProjects().size() > 0);
        } catch (final Exception e1) {
            setBaseEnabled(false);
        }
    }

    public void run(final IAction action) {
        runFunctests(action.getId());
    }

    public Object execute(final ExecutionEvent event) throws ExecutionException {
        runFunctests(event.getCommand().getId());
        return null;
    }

    private void runFunctests(final String id) {
        try {
            final ITestKind kind = TestKindRegistry.getDefault().getKind(TestKindRegistry.JUNIT3_TEST_KIND_ID);
            final String serverType = getServerType(id);
            delegate.launch(new StructuredSelection(YPlugin.getDefault().getFunctestProjects()), "run", serverType);
        } catch (final CoreException e) {
            ExceptionHandler.handle(e, getWindow().getShell(), "Error", "Error occured. See details for more information.");
        } catch (final InvocationTargetException e) {
            ExceptionHandler.handle(e, getWindow().getShell(), "Error", "Error occured. See details for more information.");
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getServerType(final String id) {
        if (LOCAL.equals(id)) {
            return ServerBlock.TYPE_LOCAL;
        } else if (STAGING.equals(id)) {
            return ServerBlock.TYPE_TEST;
        } else if (PRODUCTION.equals(id)) {
            return ServerBlock.TYPE_PROD;
        }
        return null;
    }

    public void selectionChanged(final IAction action, final ISelection selection) {
        this.selection = selection;
    }

    @Override
    public void dispose() {
    }

    public void init(final IWorkbenchWindow window) {
        this.window = window;
    }

    protected IWorkbenchWindow getWindow() {
        return window;
    }

    protected ISelection getSelection() {
        return selection;
    }

    protected YUnitLaunchShortcut getDelegate() {
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
