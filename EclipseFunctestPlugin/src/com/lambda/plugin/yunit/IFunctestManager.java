package com.lambda.plugin.yunit;

import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

public interface IFunctestManager {

	void addFunctestNature(IProject project, IProgressMonitor object) throws CoreException;

	void removeFunctestNature(IProject project, IProgressMonitor object) throws CoreException;

	boolean hasFunctestNature(IProject project);

	Map<String, List<String>> getFailedTests();

	Object[] getFunctestRunListeners();
}
