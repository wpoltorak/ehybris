package com.kizoom.plugin.wildebeest.ear;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.widgets.Display;

import com.kizoom.plugin.nature.KizoomNatureManager;
import com.kizoom.plugin.wildebeest.WildebeestPlugin;
import com.kizoom.plugin.wildebeest.ear.navigator.EarRoot;
import com.kizoom.plugin.wildebeest.ear.navigator.IEarRoot;

public class EarManager extends KizoomNatureManager implements IEarManager {

	private final EarRoot root;
	private EarChangeListener earListener;
	private IResourceChangeListener projectSetListener;


	public EarManager() {
		this.root = new EarRoot();
	}

	public IEarRoot getRoot() {
		return root;
	}

	public void addEarNature(IProject project, IProgressMonitor monitor)
			throws CoreException {
		addNature(Ear.NATURE_ID, project, monitor);
	}

	public void removeEarNature(IProject project, IProgressMonitor monitor)
			throws CoreException {
		removeNature(Ear.NATURE_ID, project, monitor);
	}

	public boolean hasEarNature(IProject project) {
		return hasNature(Ear.NATURE_ID, project);
	}

	public IEar createEar(IProject project) {
		IEar ear = root.createEar(project);
		updateView();
		return ear;
	}

	public void deleteEar(IProject project) {
		root.deleteEar(project);
		updateView();
	}

	public void updateEar(IEar ear) {
		if (ear != null) {
			ear.updateProjects();
			updateView();
		}
	}

	public boolean containsEar(IProject project) {
		return root.containsEar(project);
	}

	public boolean isEar(IResource resource) {
		return resource.getType() == IResource.PROJECT
				&& hasEarNature((IProject) resource);
	}

	public void initialize() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		for (IProject project : workspace.getRoot().getProjects()) {
			if (project.isOpen() && hasEarNature(project)
					&& !containsEar(project))
				createEar(project);
		}
		earListener = new EarChangeListener();
		workspace.addResourceChangeListener(earListener);
		projectSetListener = new ProjectSetChangeListener();
		workspace.addResourceChangeListener(projectSetListener);
	}

	public void dispose() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		workspace.removeResourceChangeListener(earListener);
		workspace.removeResourceChangeListener(projectSetListener);
		workspace.removeSaveParticipant(WildebeestPlugin.getDefault());

		root.clear();
		earListener = null;
		projectSetListener = null;
	}

	public IEar getActiveEar() {
		IEar[] ears = root.getEars();
		if (ears.length > 0)
			return ears[0];
		return null;
	}

	private void updateView() {
		Runnable updateRunnable = new Runnable() {
			public void run() {
				WildebeestPlugin.getDefault().getWorkbench()
						.getDecoratorManager().update(EarDecorator.ID);
				WildebeestPlugin.getDefault().getWorkbench()
						.getDecoratorManager().update(EarMemberDecorator.ID);
			}
		};
		getDisplay().syncExec(updateRunnable);
	}
	
	private Display getDisplay() {
		Display display = Display.getCurrent();
		if (display == null) 
			display = Display.getDefault();
		return display;
	}


	private class EarChangeListener implements IResourceChangeListener {

		public void resourceChanged(IResourceChangeEvent event) {

			if (event.getType() == IResourceChangeEvent.PRE_DELETE
					|| event.getType() == IResourceChangeEvent.PRE_CLOSE) {
				IResource resource = event.getResource();
				if (resource.getType() == IResource.PROJECT) {
					IProject project = (IProject) resource;
					if (containsEar(project)) {
						deleteEar(project);
					}
				}
			}

			IResourceDelta delta = event.getDelta();
			if (delta == null)
				return;

			IResourceDelta[] projDeltas = delta.getAffectedChildren();
			for (int i = 0; i < projDeltas.length; i++) {
				IResourceDelta pDelta = projDeltas[i];
				IResource resource = pDelta.getResource();
				if (resource.getType() == IResource.PROJECT) {
					IProject project = (IProject) resource;

					if (pDelta.getKind() == IResourceDelta.ADDED) {
						if (hasEarNature(project) && !containsEar(project)) {
							createEar(project);
						}
					} else if (pDelta.getKind() == IResourceDelta.CHANGED
							&& (pDelta.getFlags() & IResourceDelta.DESCRIPTION) != 0) {
						boolean hasEarNature = hasEarNature(project);
						boolean containsEar = containsEar(project);
						if (hasEarNature && !containsEar) {
							createEar(project);

						} else if (!hasEarNature && containsEar) {
							deleteEar(project);
						}
					}
				}
			}
		}
	}

	private class ProjectSetChangeListener implements IResourceChangeListener {

		public void resourceChanged(IResourceChangeEvent event) {
			IResource resource = event.getResource();
			if (resource != null) {
				IEar ear = getRoot().getEar(resource.getProject());
				if (ear != null && resource.equals(ear.getProjectSet())) {
					updateEar(ear);
				}
			} else {
				IResourceDelta delta = event.getDelta();
				if (delta == null)
					return;

				IResourceDelta[] projDeltas = delta.getAffectedChildren();
				for (int i = 0; i < projDeltas.length; i++) {
					IResourceDelta pDelta = projDeltas[i];
					IResource res = pDelta.getResource();
					IEar ear = getRoot().getEar(res.getProject());
					if (ear != null){
						for (IResourceDelta rDelta : pDelta.getAffectedChildren()) {
							if (ear.getProjectSet().equals(rDelta.getResource())) {
								updateEar(ear);
								break;
							}
						}
					}
				}
			}
		}
	}
}
