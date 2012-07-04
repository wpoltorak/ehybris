package com.kizoom.plugin.wildebeest.ear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.PlatformObject;

import com.kizoom.plugin.KizoomPlugin;
import com.kizoom.plugin.wildebeest.ear.navigator.IEarRoot;

public class Ear extends PlatformObject implements IEar, IProjectNature {

	public static final String NATURE_ID = "com.kizoom.plugin.ear.nature";
	private Map<String, IProject> projects;
	private final IEarRoot parent;
	private IProject project;
	private IFile projectSet;

	/**
	 * Constructor needed for <code>IProject.getNature()</code> and
	 * <code>IProject.addNature()</code>.
	 * 
	 * @see #setProject(IProject)
	 */
	public Ear() {
		this.parent = null;
	}

	public Ear(IProject project, IEarRoot parent) {
		this.project = project;
		this.parent = parent;
		IFile file = project.getFile("projectSet.psf");
		if (file.exists())
			this.projectSet = file;
		else
			KizoomPlugin.logWarning("No projectSet file in ear: " + project.getName(), null);
		this.projects = new HashMap<String, IProject>();
		updateProjects();
	}

	public String getName() {
		return project.getName();
	}
	
	public String getPrefix() {
		String name = getName();
		if (name.endsWith("EAR")) {
			return name.substring(0, name.length() - 3);
		}
		return name;
	}

	public void addProject(IProject project) {
		projects.put(project.getName(), project);

	}

	public IProject getProject(String name) {
		return projects.get(name);
	}

	public IProject[] getProjects() {
		return projects.values().toArray(new IProject[projects.size()]);
	}

	public boolean hasProject(String name) {
		return projects.containsKey(name);
	}

	public IProject removeProject(String name) {
		return projects.remove(name);
	}

	public boolean isEmpty() {
		return projects.isEmpty();
	}

	public IEarRoot getParent() {
		return parent;
	}

	public IProject getProject() {
		return project;
	}

	public IFile getProjectSet() {
		return projectSet;
	}

	public void configure() throws CoreException {
		// TODO KizoomPlugin configure and deconfigure in EAR
		IProjectDescription desc = project.getDescription();
		ICommand[] commands = desc.getBuildSpec();

		for (int i = 0; i < commands.length; ++i) {
			if (commands[i].getBuilderName().equals(EarBuilder.BUILDER_ID)) {
				return;
			}
		}

		ICommand[] newCommands = new ICommand[commands.length + 1];
		System.arraycopy(commands, 0, newCommands, 0, commands.length);
		ICommand command = desc.newCommand();
		command.setBuilderName(EarBuilder.BUILDER_ID);
		newCommands[newCommands.length - 1] = command;
		desc.setBuildSpec(newCommands);
		project.setDescription(desc, null);
	}

	public void deconfigure() throws CoreException {
		IProjectDescription description = getProject().getDescription();
		ICommand[] commands = description.getBuildSpec();
		for (int i = 0; i < commands.length; ++i) {
			if (commands[i].getBuilderName().equals(EarBuilder.BUILDER_ID)) {
				ICommand[] newCommands = new ICommand[commands.length - 1];
				System.arraycopy(commands, 0, newCommands, 0, i);
				System.arraycopy(commands, i + 1, newCommands, i, commands.length - i - 1);
				description.setBuildSpec(newCommands);
				return;
			}
		}
	}

	public void setProject(IProject project) {
		this.project = project;
	}

	public boolean isOpen() {
		return getProject().isOpen();
	}

	public boolean earMember(IProject project) {
		String name = project.getName();
		return name.equals(this.project.getName()) || checkReference(name);
	}

	// TODO WildebeestPlugin: nullpointer when right click on clsed project
	// TODO WildebeestPlugin: react on projectset file changes

	private boolean checkReference(String projectName) {
		if (projectSet == null)
			return false;
		InputStream in = null;
		try {
			in = projectSet.getContents();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (line.matches(".*<project.*reference=\".*," + projectName + ","+ projectName + ".*>.*")) {
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			KizoomPlugin.logError(e);
			return false;
		} finally {
			if (in != null)
				try {
					in.close();
				} catch (IOException e) {
				}
		}
	}

	public void updateProjects() {
		projects.clear();

		IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();

		for (IProject project : projects) {
			if (checkReference(project.getName()))
				addProject(project);
		}

	}

}
