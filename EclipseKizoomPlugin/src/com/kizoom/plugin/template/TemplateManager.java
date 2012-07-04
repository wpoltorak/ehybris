package com.kizoom.plugin.template;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;

import com.kizoom.plugin.KizoomPlugin;

public class TemplateManager implements ITemplateManager {

	private static final IPath TEMPLATES_BASEDIR = new Path("/templates");
	private static final String BASEDIR_PLACEHOLDER = "\\$\\{com.kizoom.plugin.placeholder.basedir\\}";

	private Map<String, Template> templates = new HashMap<String, Template>();

	public TemplateManager() {

	}

	public void createTemplateFiles(Bundle b, String templateId, IProject project, IProgressMonitor monitor) throws CoreException {
		IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
		Template template = getTemplate(b, templateId);
		if (template != null) {
			Map<String, File> templateFiles = template.getFiles();

			for (Entry<String, File> entry : templateFiles.entrySet()) {
				IFile file = root.getFile(project.getFullPath().append(entry.getKey()));
				createParentFolder(project, file.getParent(), monitor);
				if (!file.exists()) {
					String content = replacePlaceholders(getContents(entry.getValue()), project);
					ByteArrayInputStream in = new ByteArrayInputStream(content.getBytes());
					file.create(in, IResource.FORCE, monitor);
				}
			}
		}
	}

	private String replacePlaceholders(String contents, IProject project) {
		contents = contents.replaceAll(BASEDIR_PLACEHOLDER, project.getName());
		return contents;
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

	private void createParentFolder(IProject project, IResource resource, IProgressMonitor monitor) throws CoreException {
		if (resource == null || resource == project)
			return;

		if (resource.getType() == IResource.FOLDER) {
			if (!resource.getParent().exists())
				createParentFolder(project, resource.getParent(), monitor);
			if (!resource.exists()) {
				((IFolder) resource).create(IResource.FORCE, true, monitor);
			}
		}
	}

	private Template getTemplate(Bundle b, String templateName) throws CoreException {
		Template template = templates.get(templateName);
		if (template == null) {
			template = loadTemplate(b, templateName);
			if (template != null)
				templates.put(templateName, template);
		}
		return template;
	}

	private Template loadTemplate(Bundle b, String templateName) throws CoreException {
		IPath templatePath = TEMPLATES_BASEDIR.append(templateName);
		URL url = b.getEntry(templatePath.toString());
		try {
			String foundPath = FileLocator.toFileURL(url).getPath();
			String path = new Path(foundPath).toOSString();
			return new Template(path);
		} catch (IOException e) {
			KizoomPlugin.logWarning("Template for url ' " + url + "' not found.", e);
			return null;
		}
	}
}
