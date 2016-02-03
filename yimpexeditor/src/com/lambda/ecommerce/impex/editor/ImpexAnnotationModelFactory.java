package com.lambda.ecommerce.impex.editor;

import org.eclipse.core.filebuffers.FileBuffers;
import org.eclipse.core.filebuffers.IAnnotationModelFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.text.source.IAnnotationModel;

public class ImpexAnnotationModelFactory implements IAnnotationModelFactory {

    public IAnnotationModel createAnnotationModel(final IPath location) {
        final IFile file = FileBuffers.getWorkspaceFileAtLocation(location);
        return new ImpexAnnotationModel(file);
    }
}
