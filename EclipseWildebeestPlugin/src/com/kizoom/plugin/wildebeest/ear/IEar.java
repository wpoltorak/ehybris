package com.kizoom.plugin.wildebeest.ear;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;

import com.kizoom.plugin.wildebeest.ear.navigator.IEarRoot;

public interface IEar extends IAdaptable {

	String getName();

	String getPrefix();
	
	IProject getProject();

	void addProject(IProject project);

	IProject removeProject(String name);

	IProject getProject(String name);

	boolean hasProject(String name);

	void updateProjects();

	IProject[] getProjects();

	boolean isEmpty();

	IEarRoot getParent();

	boolean isOpen();

	IFile getProjectSet();

}
