package com.kizoom.plugin.wildebeest.ear;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jdt.core.IJavaElement;

import com.kizoom.plugin.wildebeest.WildebeestPlugin;

public class EarMemberPropertyTester extends PropertyTester {

	public static final String PROPERTY_IS_IN_EAR = "isEarMember"; //$NON-NLS-1$

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {

		if (!(receiver instanceof IAdaptable)) {
			throw new IllegalArgumentException(
					"Element must be of type 'IAdaptable', is " + receiver == null ? "null" : receiver.getClass().getName()); //$NON-NLS-1$ //$NON-NLS-2$
		}

		IProject element = getProject(receiver);
		if (element == null)
			return false;

		if (PROPERTY_IS_IN_EAR.equals(property)) {
			return isEarMember(element);
		}
		return false;
	}

	private boolean isEarMember(IProject element) {
		IEar activeEar = WildebeestPlugin.getDefault().getEarManager().getActiveEar();
		return activeEar != null && activeEar.hasProject(element.getName());
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
}
