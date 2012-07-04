package com.kizoom.plugin.actions;

import java.util.Iterator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.viewers.IStructuredSelection;

class SelectionUtil {

	public static final int UNSUPPORTED = 0;
	public static final int PROJECT_WITHOUT_NATURES = 1;
	public static final int PROJECT_WITH_JAVA_NATURE = 2;

	public static int getSelectionType(IStructuredSelection selection) {
		int type = UNSUPPORTED;
		if (selection != null) {
			for (Iterator<?> it = selection.iterator(); it.hasNext();) {
				int elementType = getElementType(it.next());
				if (elementType == UNSUPPORTED) {
					return UNSUPPORTED;
				}
				type |= elementType;
			}
		}
		return type;
	}

	/** Checks which type the given element belongs to. */
	public static int getElementType(Object element) {
		IProject project = getType(element, IProject.class);
		if (project != null) {
			try {
				if (project.isOpen()) {
					if (project.hasNature("org.eclipse.jdt.core.javanature")) {
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
