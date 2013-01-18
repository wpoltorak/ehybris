package com.lambda.plugin.impex.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.editors.text.ForwardingDocumentProvider;
import org.eclipse.ui.editors.text.TextFileDocumentProvider;
import org.eclipse.ui.texteditor.IDocumentProvider;

import com.lambda.plugin.impex.editor.ImpexDocumentParticipant.ImpexPartitioner;
import com.lambda.plugin.impex.model.IImpexModel;
import com.lambda.plugin.impex.model.ImpexModel;

public class ImpexDocumentProvider extends TextFileDocumentProvider {

    public ImpexDocumentProvider() {
        IDocumentProvider provider = new TextFileDocumentProvider();
        provider = new ForwardingDocumentProvider(ImpexPartitioner.IMPEX_PARTITIONING, new ImpexDocumentParticipant(),
                provider);
        setParentDocumentProvider(provider);
    }

    @Override
    protected FileInfo createFileInfo(final Object element) throws CoreException {
        final FileInfo fileInfo = super.createFileInfo(element);
        if (!(fileInfo instanceof ImpexFileInfo)) {
            return null;
        }

        final ImpexFileInfo impexFileInfo = (ImpexFileInfo) fileInfo;
        final IDocument document = fileInfo.fTextFileBuffer.getDocument();
        impexFileInfo.model = new ImpexModel(document, element instanceof IFileEditorInput ? (IFileEditorInput) element
                : null);
        return fileInfo;
    }

    @Override
    protected FileInfo createEmptyFileInfo() {
        return new ImpexFileInfo();
    }

    @Override
    protected IAnnotationModel createAnnotationModel(final IFile file) {
        return new ImpexAnnotationModel(file);
    }

    public IImpexModel getImpexModel(final Object element) {
        final FileInfo info = getFileInfo(element);
        if (info instanceof ImpexFileInfo) {
            final ImpexFileInfo xmlInfo = (ImpexFileInfo) info;
            return xmlInfo.model;
        }
        return null;
    }

    public class ImpexFileInfo extends FileInfo {
        public IImpexModel model;
    }
}