package com.kizoom.plugin.wildebeest.ear.navigator;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.internal.ui.packageview.PackageExplorerContentProvider;

import com.kizoom.plugin.wildebeest.ear.IEar;

@SuppressWarnings("restriction")
// TODO kizoomPlugin: Discouraged access
public class EarContentProvider extends PackageExplorerContentProvider {

	public EarContentProvider() {
		super(true);
	}

	@Override
	public Object[] getChildren(Object element) {
		// TODO KizoomPlugin: check possible existance constraint
		if (!exists(element))
			return NO_CHILDREN;
		// try {
		if (element instanceof IEarRoot) {
			return ((IEarRoot) element).getEars();
		}

		if (element instanceof IEar)
			return ((IEar) element).getProjects();
		return super.getChildren(element);
		// } catch (CoreException e) {
		// return NO_CHILDREN;
		// }
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof IEarRoot) {
			return ((IEarRoot) element).isEmpty();
		}
		if (element instanceof IEar) {
			IEar ear = (IEar) element;
			return !ear.isEmpty();
		}
		return super.hasChildren(element);
	}

	@Override
	protected Object internalGetParent(Object element) {
		if (element instanceof IEarRoot)
			return null;
		if (element instanceof IEar)
			return ((IEar) element).getParent();
		if (element instanceof IJavaProject) {
			return getJavaProjectParent((IJavaProject) element);
		}
		return super.internalGetParent(element);
	}

	private IEar getJavaProjectParent(IJavaProject element) {
		// TODO KizoomPlugin: JavaProject resturns null parent rather than proper
		// ear
		// java project
		return null;// KizoomPlugin.getDefault().getEarManager().getRoot().getEar(
		// "aaa");
	}
}