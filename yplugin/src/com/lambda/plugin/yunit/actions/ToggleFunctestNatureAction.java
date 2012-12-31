package com.lambda.plugin.yunit.actions;

import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import com.lambda.plugin.YPlugin;
import com.lambda.plugin.yunit.IYUnitManager;

public class ToggleFunctestNatureAction implements IObjectActionDelegate {

    public static final String ID = "com.lambda.plugin.toggle.ear.nature.action";
    private ISelection selection;
    private final IYUnitManager functestManager;

    public ToggleFunctestNatureAction() {
        functestManager = YPlugin.getDefault().getFunctestManager();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
     */
    public void run(final IAction action) {
        if (selection instanceof IStructuredSelection) {
            for (final Iterator<?> it = ((IStructuredSelection) selection).iterator(); it.hasNext();) {
                final Object element = it.next();
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

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IActionDelegate#selectionChanged(org.eclipse.jface.action .IAction, org.eclipse.jface.viewers.ISelection)
     */
    public void selectionChanged(final IAction action, final ISelection selection) {
        this.selection = selection;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IObjectActionDelegate#setActivePart(org.eclipse.jface.action .IAction, org.eclipse.ui.IWorkbenchPart)
     */
    public void setActivePart(final IAction action, final IWorkbenchPart targetPart) {
    }

    private void toggleNature(final IProject project) {
        try {
            if (functestManager.hasFunctestNature(project)) {
                functestManager.removeFunctestNature(project, null);
            } else {
                functestManager.addFunctestNature(project, null);
            }
        } catch (final CoreException e) {
        }
    }

}
