package com.kizoom.plugin.wildebeest.webapp.actions;

import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.kizoom.plugin.nature.KizoomNatureManager;
import com.kizoom.plugin.wildebeest.webapp.WebappNature;

public class ToggleWebappNatureAction implements IObjectActionDelegate {
	public static final String ID = "com.kizoom.plugin.toggle.webapp.nature.action";
	private ISelection selection;
	private final KizoomNatureManager manager;
	public ToggleWebappNatureAction() {
		manager = new KizoomNatureManager();
	}

	public void run(IAction action) {
		if (selection instanceof IStructuredSelection) {
			for (Iterator<?> it = ((IStructuredSelection) selection).iterator(); it.hasNext();) {
				Object element = it.next();
				IProject project = null;
				if (element instanceof IProject) {
					project = (IProject) element;
				} else if (element instanceof IAdaptable) {
					project = (IProject) ((IAdaptable) element).getAdapter(IProject.class);
				}
				if (project != null) {
					toggleNature(project);
				}
			}
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
	}

	private void toggleNature(IProject project) {
		try {
			if (manager.hasNature(WebappNature.NATURE_ID, project))
				manager.removeNature(WebappNature.NATURE_ID, project, new NullProgressMonitor());
			else
				manager.addNature(WebappNature.NATURE_ID, project, new NullProgressMonitor());
		} catch (CoreException e) {
		}
	}
}
