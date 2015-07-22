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
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.texteditor.MarkerUtilities;

import com.lambda.impex.ast.ImpexProblem;
import com.lambda.impex.ast.ImpexProblem.Type;
import com.lambda.plugin.YCore;
import com.lambda.plugin.impex.antlr.AntlrProblemTypeToSeverityMapper;

public class ImpexModel implements IImpexModel {

    public static final String IMPEXFILE_PROBLEM_MARKER = YCore.PLUGIN_ID + ".impexFileProblem"; //$NON-NLS-1$

    private final IFileEditorInput editorInput;

    public ImpexModel(final IFileEditorInput editorInput) {
        this.editorInput = editorInput;
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
            YCore.logError(e);
        }
    }

    private void createMarkers(final List<ImpexProblem> problems) {
        final IPreferenceStore store = YCore.getDefault().getPreferenceStore();
        final IWorkspaceRunnable wr = new IWorkspaceRunnable() {
            @Override
            public void run(final IProgressMonitor monitor) throws CoreException {
                for (final ImpexProblem problem : problems) {
                    if (monitor.isCanceled()) {
                        return;
                    }
                    Map<String, Object> map = new HashMap<String, Object>();
                    Type type = problem.getType();
                    MarkerUtilities.setLineNumber(map, problem.getLineNumber());
                    MarkerUtilities.setMessage(map,
                            AntlrProblemTypeToSeverityMapper.getMessage(problem.getText(), type));
                    MarkerUtilities.setCharStart(map, problem.getStartIndex());
                    MarkerUtilities.setCharEnd(map, problem.getStartIndex() + problem.getLength());
                    map.put(IMarker.SEVERITY, AntlrProblemTypeToSeverityMapper.getSeverity(store, type));
                    map.put(IMarker.SOURCE_ID, type.toString());

                    final IFile file = editorInput.getFile();
                    final IMarker marker = file.createMarker(IMPEXFILE_PROBLEM_MARKER);
                    marker.setAttributes(map);
                }
            }
        };
        try {
            wr.run(new NullProgressMonitor());
        } catch (final CoreException e) {
            YCore.logError(e);
        }
    }
}
