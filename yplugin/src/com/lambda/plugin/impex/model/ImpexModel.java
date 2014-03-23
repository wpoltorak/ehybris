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
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.texteditor.MarkerUtilities;

import com.lambda.impex.ast.ImpexProblem;
import com.lambda.plugin.YPlugin;
import com.lambda.plugin.impex.editor.ImpexProblemAnnotation;

public class ImpexModel implements IImpexModel {

    private final IFileEditorInput editorInput;

    public ImpexModel(final IFileEditorInput editorInput) {
        this.editorInput = editorInput;
    }

    private void createProblemAnnotations(List<ImpexProblem> problems) {
        for (ImpexProblem problem : problems) {
            ImpexProblemAnnotation impexProblemAnnotation = new ImpexProblemAnnotation(new ImpexModelProblem(problem,
                    IMarker.SEVERITY_ERROR));

        }
    }

    @Override
    public void updateMarkers(List<ImpexProblem> problems) {
        removeMarkers();
        createMarkers(problems);
    }

    private void removeMarkers() {
        try {
            editorInput.getFile().deleteMarkers(IMPEXFILE_PROBLEM_MARKER, true, 0);
        } catch (final CoreException e) {
            YPlugin.logError(e);
        }
    }

    private void createMarkers(final List<ImpexProblem> problems) {
        final IWorkspaceRunnable wr = new IWorkspaceRunnable() {
            @Override
            public void run(final IProgressMonitor monitor) throws CoreException {
                for (final ImpexProblem problem : problems) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    MarkerUtilities.setLineNumber(map, problem.getLineNumber());
                    MarkerUtilities.setMessage(map, problem.getText());
                    MarkerUtilities.setCharStart(map, problem.getStartIndex());
                    MarkerUtilities.setCharEnd(map, problem.getStartIndex() + problem.getLength());
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
