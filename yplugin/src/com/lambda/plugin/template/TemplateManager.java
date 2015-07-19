package com.lambda.plugin.template;

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

import com.lambda.plugin.YCore;

public class TemplateManager implements ITemplateManager {

    private static final IPath TEMPLATES_BASEDIR = new Path("/templates");
    private static final String BASEDIR_PLACEHOLDER = "\\$\\{com.lambda.plugin.placeholder.basedir\\}";

    private final Map<String, Template> templates = new HashMap<String, Template>();

    public TemplateManager() {

    }

    public void createTemplateFiles(final Bundle b, final String templateId, final IProject project, final IProgressMonitor monitor)
            throws CoreException {
        final IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        final Template template = getTemplate(b, templateId);
        if (template != null) {
            final Map<String, File> templateFiles = template.getFiles();

            for (final Entry<String, File> entry : templateFiles.entrySet()) {
                final IFile file = root.getFile(project.getFullPath().append(entry.getKey()));
                createParentFolder(project, file.getParent(), monitor);
                if (!file.exists()) {
                    final String content = replacePlaceholders(getContents(entry.getValue()), project);
                    final ByteArrayInputStream in = new ByteArrayInputStream(content.getBytes());
                    file.create(in, IResource.FORCE, monitor);
                }
            }
        }
    }

    private String replacePlaceholders(String contents, final IProject project) {
        contents = contents.replaceAll(BASEDIR_PLACEHOLDER, project.getName());
        return contents;
    }

    static public String getContents(final File aFile) throws CoreException {
        final StringBuilder contents = new StringBuilder();
        try {
            final BufferedReader input = new BufferedReader(new FileReader(aFile));
            try {
                String line = null;
                while ((line = input.readLine()) != null) {
                    contents.append(line);
                    contents.append(System.getProperty("line.separator"));
                }
            } finally {
                input.close();
            }
        } catch (final IOException ex) {
            throw new CoreException(new Status(IStatus.WARNING, YCore.PLUGIN_ID, "'" + aFile + "' file content couldn't be retrieved."));
        }

        return contents.toString();
    }

    private void createParentFolder(final IProject project, final IResource resource, final IProgressMonitor monitor) throws CoreException {
        if (resource == null || resource == project) {
            return;
        }

        if (resource.getType() == IResource.FOLDER) {
            if (!resource.getParent().exists()) {
                createParentFolder(project, resource.getParent(), monitor);
            }
            if (!resource.exists()) {
                ((IFolder) resource).create(IResource.FORCE, true, monitor);
            }
        }
    }

    private Template getTemplate(final Bundle b, final String templateName) throws CoreException {
        Template template = templates.get(templateName);
        if (template == null) {
            template = loadTemplate(b, templateName);
            if (template != null) {
                templates.put(templateName, template);
            }
        }
        return template;
    }

    private Template loadTemplate(final Bundle b, final String templateName) throws CoreException {
        final IPath templatePath = TEMPLATES_BASEDIR.append(templateName);
        final URL url = b.getEntry(templatePath.toString());
        try {
            final String foundPath = FileLocator.toFileURL(url).getPath();
            final String path = new Path(foundPath).toOSString();
            return new Template(path);
        } catch (final IOException e) {
            YCore.logWarning("Template for url ' " + url + "' not found.", e);
            return null;
        }
    }
}
