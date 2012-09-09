package com.lambda.plugin.impex.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.editors.text.TextFileDocumentProvider;
import org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel;

import com.lambda.plugin.impex.model.IImpexModel;
import com.lambda.plugin.impex.model.ImpexModel;

public class ImpexDocumentProvider extends TextFileDocumentProvider {

    private ImpexModel impexModel;

    public ImpexDocumentProvider() {
        setParentDocumentProvider(new TextFileDocumentProvider(new ImpexStorageDocumentProvider()));
    }

    @Override
    protected FileInfo createFileInfo(final Object element) throws CoreException {
        final FileInfo fileInfo = super.createFileInfo(element);
        if (!(fileInfo instanceof ImpexFileInfo)) {
            return null;
        }
        final IDocument document = fileInfo.fTextFileBuffer.getDocument();
        impexModel = new ImpexModel(document);
        return fileInfo;
    }

    @Override
    protected FileInfo createEmptyFileInfo() {
        return new ImpexFileInfo();
    }

    @Override
    protected IAnnotationModel createAnnotationModel(final IFile file) {
        return new ResourceMarkerAnnotationModel(file);
    }

    public class ImpexFileInfo extends FileInfo {
        public IImpexModel model;
    }
}