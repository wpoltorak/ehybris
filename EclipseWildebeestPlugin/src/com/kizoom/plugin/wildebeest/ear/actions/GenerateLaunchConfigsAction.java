package com.kizoom.plugin.wildebeest.ear.actions;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.JavaRuntime;

import com.kizoom.plugin.KizoomPlugin;
import com.kizoom.plugin.wildebeest.WildebeestPlugin;

public class GenerateLaunchConfigsAction extends JobSchedulingWildebeestAction {

	@Override
	protected String description() {
		return "Generating launch configs...";
	}
	
	@Override
	protected void doExecute(ExecutionEvent event) throws Exception {
		IProject wildebeestTemplate = ResourcesPlugin.getWorkspace().getRoot().getProject("WildebeestEARTemplate");
		IFolder launchConfigsSourceDir = wildebeestTemplate.getFolder("/eclipse/launch-configs");
		
		if (JavaRuntime.getDefaultVMInstall() == null){
			throw new CoreException(new Status(IStatus.ERROR, WildebeestPlugin.PLUGIN_ID, "Cannot fin default JRE in the workspace preferences."));
		}
		
		IFolder launchConfigsTargetDir = getEclipseBuildFolder(true);
		
		for (IResource member : launchConfigsSourceDir.members()) {
			if (member.getType() == IResource.FILE){
				if (member.getName().startsWith(".")){
					continue;
				}
				String content = replacePlaceholders(getContents(member.getLocation().toFile()));
				ByteArrayInputStream in = new ByteArrayInputStream(content.getBytes());
				String fileName = getActiveEar().getName() + " " + member.getFullPath().lastSegment() + ".launch";
				IFile file = launchConfigsTargetDir.getFile(fileName);
				file.create(in, IResource.FORCE, new NullProgressMonitor());
			}
		}
		launchConfigsTargetDir.refreshLocal(1, new NullProgressMonitor());
	}
	
	private String replacePlaceholders(String contents) {
		contents = replacePlaceholder(contents, "ear.prefix", getActiveEar().getPrefix());
		contents = replacePlaceholder(contents, "workspace.name", getActiveEar().getPrefix());
		contents = replacePlaceholder(contents, "application.name", getActiveEar().getName());

		IVMInstall vm = JavaRuntime.getDefaultVMInstall();
		contents = replacePlaceholder(contents, "eclipse.jre.type", vm.getVMInstallType().getId());
		contents = replacePlaceholder(contents, "eclipse.jre.name", vm.getName());
		return contents;
	}

	private String replacePlaceholder(String text, String placeholder, String replacement){
		return text.replace("@" + placeholder + "@", replacement);
	}
	
	static public String getContents(File aFile) throws CoreException {
		StringBuilder contents = new StringBuilder();
		try {
			BufferedReader input = new BufferedReader(new FileReader(aFile));
			try {
				String line = null;
				while ((line = input.readLine()) != null) {
					contents.append(line);
					contents.append(System.getProperty("line.separator"));
				}
			} finally {
				input.close();
			}
		} catch (IOException ex) {
			throw new CoreException(new Status(IStatus.WARNING, KizoomPlugin.PLUGIN_ID, "'" + aFile
					+ "' file content couldn't be retrieved."));
		}

		return contents.toString();
	}
}
