package com.kizoom.plugin.wildebeest.ear;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;

import com.kizoom.plugin.wildebeest.WildebeestPlugin;
import com.kizoom.plugin.wildebeest.image.WildebeestPluginImages;

public class EarDecorator implements ILightweightLabelDecorator {

	public static final String ID = "com.kizoom.plugin.wildebeest.ear.EarDecorator"; 
	
	private List<ILabelProviderListener> listeners = new ArrayList<ILabelProviderListener>();
	
	public void decorate(Object element, IDecoration decoration) {
		IProject javaElement = getProject(element);
		if (javaElement == null)
			return;

		if (isActiveEar(javaElement)){
			decoration.addOverlay(WildebeestPluginImages.DESC_EAR_PRJ_DEC, IDecoration.TOP_RIGHT);
		}
	}

	public void addListener(ILabelProviderListener listener) {
		this.listeners.add(listener);
	}

	public void dispose() {
		listeners.clear();
		listeners = null;
	}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
		this.listeners.remove(listener);
	}

	private IProject getProject(Object receiver) {
		if (receiver instanceof IProject)
			return (IProject) receiver;
		if (receiver instanceof IJavaElement) {
			return ((IJavaElement) receiver).getJavaProject().getProject();
		} else if (receiver instanceof IResource) {
			return ((IResource) receiver).getProject();
		} else { // is IAdaptable
			IResource resource = (IResource) ((IAdaptable) receiver).getAdapter(IResource.class);
			return resource == null ? null : resource.getProject();
		}
	}

	private boolean isActiveEar(IProject element) {
		return WildebeestPlugin.getDefault().getEarManager().getRoot().containsEar(element);
	}

}
