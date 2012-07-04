package com.kizoom.plugin.wildebeest.ear;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

import com.kizoom.plugin.wildebeest.ear.navigator.IEarRoot;

public interface IEarManager {

	IEarRoot getRoot();

	public boolean isEar(IResource resource);

	boolean hasEarNature(IProject project);

	void removeEarNature(IProject project, IProgressMonitor monitor)
			throws CoreException;

	void addEarNature(IProject project, IProgressMonitor monitor)
			throws CoreException;

	IEar getActiveEar();

	void updateEar(IEar ear);
}
