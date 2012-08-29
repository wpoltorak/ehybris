package com.lambda.plugin.impex.editor;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.ui.editors.text.FileDocumentProvider;

public class ImpexDocumentProvider extends FileDocumentProvider {

    @Override
    protected IDocument createDocument(final Object element) throws CoreException {
        final IDocument document = super.createDocument(element);
        if (document != null) {
            final IDocumentPartitioner partitioner = new FastPartitioner(new ImpexPartitionScanner(), new String[] {
                    ImpexPartitionScanner.IMPEX_HEADER, ImpexPartitionScanner.IMPEX_MACRO });
            partitioner.connect(document);
            document.setDocumentPartitioner(partitioner);
        }
        return document;
    }
}