package com.lambda.plugin.yunit;

import java.util.List;
import java.util.Map;

import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;

import com.lambda.plugin.YNature;
import com.lambda.plugin.YPlugin;
import com.lambda.plugin.nature.YNatureManager;
import com.lambda.plugin.yunit.actions.RunFunctestsAction;
import com.lambda.plugin.yunit.preferences.PreferenceConstants;

public class YUnitManager extends YNatureManager implements IYUnitManager {

    public final static String TEST_SUPERCLASS_NAME = "junit.framework.TestCase"; //$NON-NLS-1$
    public final static String TEST_INTERFACE_NAME = "junit.framework.Test"; //$NON-NLS-1$

    public final static String JUNIT4_ANNOTATION_NAME = "org.junit.Test"; //$NON-NLS-1$
    public static final String SIMPLE_TEST_INTERFACE_NAME = "Test"; //$NON-NLS-1$

    private final YUnitRunListener listener = new YUnitRunListener();
    private final ListenerList fFunctestRunListeners;

    public YUnitManager() {
        fFunctestRunListeners = new ListenerList();
    }

    public void addFunctestNature(final IProject project, final IProgressMonitor monitor) throws CoreException {
        addNature(YNature.NATURE_ID, project, monitor);
        fireNotify();
    }

    public boolean hasFunctestNature(final IProject project) {
        return hasNature(YNature.NATURE_ID, project);
    }

    public void removeFunctestNature(final IProject project, final IProgressMonitor monitor) throws CoreException {
        removeNature(YNature.NATURE_ID, project, monitor);
        fireNotify();
    }

    private void fireNotify() {
        boolean enabled = false;
        try {
            enabled = YPlugin.getDefault().getFunctestProjects().size() > 0;
        } catch (final Exception e1) {
        }
        fireNotify(new EvaluationContext(null, new Boolean(enabled)));
    }

    private void fireNotify(final IEvaluationContext context) {
        final ICommandService service = (ICommandService) PlatformUI.getWorkbench().getAdapter(ICommandService.class);
        service.getCommand(RunFunctestsAction.LOCAL).setEnabled(context);
        service.getCommand(RunFunctestsAction.PRODUCTION).setEnabled(context);
        service.getCommand(RunFunctestsAction.STAGING).setEnabled(context);
    }

    public void initialize() {
        fFunctestRunListeners.add(listener);
        final boolean persistResults = persistFunctestRunResults();
        if (persistResults) {

        }

        // IWorkspace workspace = ResourcesPlugin.getWorkspace();
        // for (IProject project : workspace.getRoot().getProjects()) {
        // if (project.isOpen() && hasEarNature(project) && !containsEar(project))
        // createEar(project);
        // }
        // earListener = new EarChangeListener();
        // workspace.addResourceChangeListener(earListener);
        fireNotify();
    }

    public void dispose() {
        fFunctestRunListeners.remove(listener);
        final boolean persistResults = persistFunctestRunResults();
        if (persistResults) {

        }

        // IWorkspace workspace = ResourcesPlugin.getWorkspace();
        // workspace.removeResourceChangeListener(earListener);
        // root.clear();
        // earListener = null;
    }

    private boolean persistFunctestRunResults() {
        final IPreferenceStore store = YPlugin.getDefault().getPreferenceStore();
        final boolean persistResults = store.getBoolean(PreferenceConstants.P_PERSIST_FUNCTEST_RESULTS);
        return persistResults;
    }

    public Map<String, List<String>> getFailedTests() {
        return listener.getFailedTests();

    }

    public Object[] getFunctestRunListeners() {
        return fFunctestRunListeners.getListeners();
    }
}
