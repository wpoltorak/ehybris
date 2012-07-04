package com.kizoom.plugin.wildebeest.ear;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;

import com.kizoom.plugin.wildebeest.WildebeestPlugin;
import com.kizoom.plugin.wildebeest.image.WildebeestPluginImages;
import com.kizoom.plugin.wildebeest.preferences.PreferenceConstants;

public class EarMemberDecorator implements ILightweightLabelDecorator {

	public static final String ID = "com.kizoom.plugin.wildebeest.ear.EarMemberDecorator";

	public void decorate(Object element, IDecoration decoration) {
		if (WildebeestPlugin.getDefault().getPreferenceStore()
				.getBoolean(PreferenceConstants.P_MARK_PROJECTS_LISTED_IN_EAR)
				&& isInActiveEar(element)) {
			decoration.addOverlay(WildebeestPluginImages.DESC_EAR_MEMBER_OVR, IDecoration.UNDERLAY);
		}
	}

	public void addListener(ILabelProviderListener listener) {
	}

	public void dispose() {

	}

	public boolean isLabelProperty(Object element, String property) {
		return false;
	}

	public void removeListener(ILabelProviderListener listener) {
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

	private boolean isInActiveEar(Object element) {
		IProject javaElement = getProject(element);
		if (javaElement == null)
			return false;

		IEar activeEar = WildebeestPlugin.getDefault().getEarManager().getActiveEar();
		String name = javaElement.getName();
		return activeEar != null && activeEar.hasProject(name);
	}
}
