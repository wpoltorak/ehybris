package com.lambda.plugin.impex.editor;

import java.util.HashMap;
import java.util.Map;

import org.antlr.v4.runtime.Lexer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.editors.text.TextFileDocumentProvider;

import com.lambda.impex.ast.ImpexLexer;
import com.lambda.plugin.YPlugin;
import com.lambda.plugin.impex.model.IImpexModel;
import com.lambda.plugin.impex.model.ImpexModel;

public class ImpexDocumentProvider extends TextFileDocumentProvider {

    private final Map<Object, ImpexDocument> impexDocumentMap = new HashMap<Object, ImpexDocument>();
    private final Lexer tokenSource = new ImpexLexer(null);

    public ImpexDocumentProvider() {
        YPlugin.logInfo("ImpexDocumentProvider contructor called", null);
    }

    @Override
    protected FileInfo createFileInfo(final Object element) throws CoreException {
        final FileInfo fileInfo = super.createFileInfo(element);
        if (!(fileInfo instanceof ImpexFileInfo)) {
            return null;
        }
        final ImpexFileInfo impexFileInfo = (ImpexFileInfo) fileInfo;
        impexFileInfo.model = new ImpexModel(element instanceof IFileEditorInput ? (IFileEditorInput) element : null);
        return fileInfo;
    }

    @Override
    public IDocument getDocument(Object element) {
        ImpexDocument impexDocument = impexDocumentMap.get(element);
        if (impexDocument == null) {
            IDocument document = super.getDocument(element);
            impexDocument = new ImpexDocument(document, tokenSource);
            YPlugin.logInfo("ImpexDocument created", null);
            impexDocumentMap.put(element, impexDocument);
        }
        return impexDocument;
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