package com.lambda.plugin.impex.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.texteditor.MarkerUtilities;

import com.lambda.impex.ast.ImpexCompiler;
import com.lambda.impex.ast.ImpexContext;
import com.lambda.impex.ast.ImpexError;
import com.lambda.plugin.YPlugin;

public class ImpexModel implements IImpexModel {

    private final IDocument document;
    private final IFileEditorInput editorInput;

    public ImpexModel(final IDocument document, final IFileEditorInput editorInput) {
        this.document = document;
        this.editorInput = editorInput;
    }

    public void reconcile() {
        final long start = System.currentTimeMillis();
        try {
            System.out.println("===> RECONCILE " + editorInput.getName() + "##################################");
            removeMarkers();
            final char[] source = document.get().toCharArray();

            final ImpexCompiler compiler = new ImpexCompiler();
            DefaultImpexVisitor visitor = new DefaultImpexVisitor();
            compiler.setVisitor(visitor);
            compiler.compile(source);

            ImpexContext context = compiler.getContext();
            createMarkers(context.getErrors());
        } finally {
            System.out.println("===> TOOK " + (System.currentTimeMillis() - start) / 1000);

        }
    }

    private void removeMarkers() {
        try {
            editorInput.getFile().deleteMarkers(IMPEXFILE_PROBLEM_MARKER, true, 0);
        } catch (final CoreException e) {
            YPlugin.logError(e);
        }
    }

    private void createMarkers(final List<ImpexError> errors) {
        final IWorkspaceRunnable wr = new IWorkspaceRunnable() {
            public void run(final IProgressMonitor monitor) throws CoreException {
                for (final ImpexError error : errors) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    MarkerUtilities.setLineNumber(map, error.getLineNumber());
                    MarkerUtilities.setMessage(map, error.getType().toString());
                    MarkerUtilities.setCharStart(map, error.getStartIndex());
                    MarkerUtilities.setCharEnd(map, error.getStartIndex() + error.getLength());
                    map.put(IMarker.SEVERITY, new Integer(IMarker.SEVERITY_ERROR));

                    final IFile file = editorInput.getFile();
                    final IMarker marker = file.createMarker(IMPEXFILE_PROBLEM_MARKER);
                    marker.setAttributes(map);
                }
            }
        };
        try {
            wr.run(new NullProgressMonitor());
        } catch (final CoreException e) {
            YPlugin.logError(e);
        }
    }
}
