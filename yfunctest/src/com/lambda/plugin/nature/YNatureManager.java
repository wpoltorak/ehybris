package com.lambda.plugin.nature;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

public class YNatureManager implements IYNatureManager {

    public void addNature(String natureId, IProject project, IProgressMonitor monitor) throws CoreException {
        if (!hasNature(natureId, project)) {
            IProjectDescription description = project.getDescription();
            String[] natures = description.getNatureIds();

            String[] newNatures = new String[natures.length + 1];
            System.arraycopy(natures, 0, newNatures, 0, natures.length);
            newNatures[natures.length] = natureId;
            description.setNatureIds(newNatures);

            project.setDescription(description, monitor);
            project.touch(monitor);
        }
    }

    public void removeNature(String natureId, IProject project, IProgressMonitor monitor) throws CoreException {
        IProjectDescription description = project.getDescription();
        if (hasNature(natureId, project)) {
            // deleteEar(project);

            String[] natures = description.getNatureIds();

            for (int i = 0; i < natures.length; ++i) {
                if (natureId.equals(natures[i])) {

                    String[] newNatures = new String[natures.length - 1];
                    System.arraycopy(natures, 0, newNatures, 0, i);
                    System.arraycopy(natures, i + 1, newNatures, i, natures.length - i - 1);
                    description.setNatureIds(newNatures);
                    project.setDescription(description, monitor);
                    project.touch(monitor);
                    break;
                }
            }
        }
    }

    public boolean hasNature(String natureId, IProject project) {
        try {
            return project.isOpen() && project.hasNature(natureId);
        } catch (CoreException e) {
            return false;
        }
    }
}
