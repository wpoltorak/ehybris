package com.kizoom.plugin.wildebeest.ui;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.IStructuredSelection;

import com.kizoom.plugin.wildebeest.ear.Ear;
import com.kizoom.plugin.wildebeest.webapp.WebappNature;

class SelectionUtil {

	public static final int UNSUPPORTED = 0;
	public static final int PROJECT_WITHOUT_NATURES = 1;
	public static final int PROJECT_WITH_EAR_NATURE = 2;
	public static final int PROJECT_WITH_WEBAPP_NATURE = 4;
	public static final int PROJECT_WITH_JAVA_NATURE = 8;

	public static int getSelectionType(IStructuredSelection selection) {
		int type = UNSUPPORTED;
		if (selection != null && selection.size() == 1) {
			return getElementType(selection.getFirstElement());
		}
		return type;
	}

	/** Checks which type the given element belongs to. */
	public static int getElementType(Object element) {
		IProject project = getType(element, IProject.class);
		if (project != null) {
			try {
				if (project.isOpen()) {
					if (project.hasNature(Ear.NATURE_ID)) {
						return PROJECT_WITH_EAR_NATURE;
					} else if (project.hasNature(WebappNature.NATURE_ID)) {
						return PROJECT_WITH_WEBAPP_NATURE;
					} else if (project.hasNature("org.eclipse.jdt.core.javanature")) {
						return PROJECT_WITH_JAVA_NATURE;
					}
				}
				return PROJECT_WITHOUT_NATURES;
			} catch (CoreException e) {
				// ignored
			}
		}
		return UNSUPPORTED;
	}

	/**
	 * Checks if the object belongs to a given type and returns it or a suitable
	 * adapter.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getType(Object element, Class<T> type) {
		if (type.isInstance(element)) {
			return (T) element;
		}
		if (element instanceof IAdaptable) {
			T adapter = (T) ((IAdaptable) element).getAdapter(type);
			if (adapter != null) {
				return adapter;
			}
		}
		return element == null ? null : (T) Platform.getAdapterManager().getAdapter(element, type);
	}
}
