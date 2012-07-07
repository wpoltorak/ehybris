package com.lambda.plugin.template;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.osgi.framework.Bundle;

public interface ITemplateManager {

	void createTemplateFiles(Bundle bundle, String templateId, IProject project, IProgressMonitor monitor) throws CoreException;

}
