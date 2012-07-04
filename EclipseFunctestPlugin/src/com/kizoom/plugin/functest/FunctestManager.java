package com.kizoom.plugin.functest;

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

import com.kizoom.plugin.functest.actions.RunFunctestsAction;
import com.kizoom.plugin.functest.preferences.PreferenceConstants;
import com.kizoom.plugin.nature.KizoomNatureManager;

public class FunctestManager extends KizoomNatureManager implements IFunctestManager {

	public final static String TEST_SUPERCLASS_NAME = "junit.framework.TestCase"; //$NON-NLS-1$
	public final static String TEST_INTERFACE_NAME = "junit.framework.Test"; //$NON-NLS-1$

	public final static String JUNIT4_ANNOTATION_NAME = "org.junit.Test"; //$NON-NLS-1$
	public static final String SIMPLE_TEST_INTERFACE_NAME = "Test"; //$NON-NLS-1$

	private FunctestRunListener listener = new FunctestRunListener();
	private ListenerList fFunctestRunListeners;

	public FunctestManager() {
		fFunctestRunListeners = new ListenerList();
	}

	public void addFunctestNature(IProject project, IProgressMonitor monitor) throws CoreException {
		addNature(FunctestNature.NATURE_ID, project, monitor);
		fireNotify();
	}

	public boolean hasFunctestNature(IProject project) {
		return hasNature(FunctestNature.NATURE_ID, project);
	}

	public void removeFunctestNature(IProject project, IProgressMonitor monitor) throws CoreException {
		removeNature(FunctestNature.NATURE_ID, project, monitor);
		fireNotify();
	}
	
	private void fireNotify(){
		boolean enabled = false;
		try {
			enabled = FunctestPlugin.getDefault().getFunctestProjects().size() > 0;
		} catch (Exception e1) {
		}
		fireNotify(new EvaluationContext(null, new Boolean(enabled)));
	}

	private void fireNotify(IEvaluationContext context){
		ICommandService service= (ICommandService)PlatformUI.getWorkbench().getAdapter(ICommandService.class);
		service.getCommand(RunFunctestsAction.LOCAL).setEnabled(context);
		service.getCommand(RunFunctestsAction.PRODUCTION).setEnabled(context);
		service.getCommand(RunFunctestsAction.STAGING).setEnabled(context);
	}
	
	public void initialize() {
		fFunctestRunListeners.add(listener);
		boolean persistResults = persistFunctestRunResults();
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
		boolean persistResults = persistFunctestRunResults();
		if (persistResults) {

		}

		// IWorkspace workspace = ResourcesPlugin.getWorkspace();
		// workspace.removeResourceChangeListener(earListener);
		// root.clear();
		// earListener = null;
	}

	private boolean persistFunctestRunResults() {
		IPreferenceStore store = FunctestPlugin.getDefault().getPreferenceStore();
		boolean persistResults = store.getBoolean(PreferenceConstants.P_PERSIST_FUNCTEST_RESULTS);
		return persistResults;
	}

	public Map<String, List<String>> getFailedTests() {
		return listener.getFailedTests();

	}

	public Object[] getFunctestRunListeners() {
		return fFunctestRunListeners.getListeners();
	}
}
