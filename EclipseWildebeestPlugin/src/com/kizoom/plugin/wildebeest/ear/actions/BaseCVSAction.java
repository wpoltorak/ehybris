package com.kizoom.plugin.wildebeest.ear.actions;

import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.team.core.RepositoryProvider;
import org.eclipse.team.internal.ccvs.core.CVSProviderPlugin;
import org.eclipse.team.internal.ccvs.core.CVSTeamProvider;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.kizoom.plugin.KizoomPlugin;

@SuppressWarnings("restriction")
public abstract class BaseCVSAction implements IObjectActionDelegate {

	private ISelection selection;

	protected CVSTeamProvider getProjectProvider(Object element) {
		IProject project = getProject(element);
		if (project != null)
			return (CVSTeamProvider) RepositoryProvider.getProvider(project, CVSProviderPlugin.getTypeId());
		return null;
	}

	protected IProject getProject(Object selection) {
		if (selection instanceof IJavaElement) {
			return ((IJavaElement) selection).getJavaProject().getProject();
		} else if (selection instanceof IProject) {
			return (IProject) selection;
		}
		return null;
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	protected Shell getShell() {
		return KizoomPlugin.getActiveWorkbenchShell();
	}

	protected Display getDisplay() {
		Shell shell = getShell();
		if (shell != null)
			return shell.getDisplay();
		return null;
	}

	protected ISelection getSelection() {
		return selection;
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {

	}

}
