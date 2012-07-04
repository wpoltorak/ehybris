package com.kizoom.plugin.nature;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

public interface IKizoomNatureManager {

	public void addNature(String natureId, IProject project, IProgressMonitor monitor) throws CoreException;

	public void removeNature(String natureId, IProject project, IProgressMonitor monitor) throws CoreException;

	public boolean hasNature(String natureId, IProject project);

}
