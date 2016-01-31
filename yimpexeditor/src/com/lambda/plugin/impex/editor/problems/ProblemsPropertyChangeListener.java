package com.lambda.plugin.impex.editor.problems;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;

import com.lambda.impex.ast.ImpexProblem.Type;
import com.lambda.plugin.impex.YImpex;
import com.lambda.plugin.impex.antlr.AntlrProblemTypeToSeverityMapper;
import com.lambda.plugin.impex.model.ImpexModel;
import com.lambda.plugin.impex.preferences.PreferenceConstants;

public class ProblemsPropertyChangeListener implements IPropertyChangeListener {

    private final IPreferenceStore store;

    public ProblemsPropertyChangeListener(IPreferenceStore store) {
        this.store = store;
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        if (event.getProperty().equals(PreferenceConstants.IMPEX_PROBLEM)) {
            try {
                // TODO provide sufficient update in case of ignore <-> error/warning
                IMarker[] markers = ResourcesPlugin.getWorkspace().getRoot()
                        .findMarkers(ImpexModel.IMPEXFILE_PROBLEM_MARKER, false, IResource.DEPTH_INFINITE);
                for (IMarker marker : markers) {
                    int curSeverity = ((Integer) marker.getAttribute(IMarker.SEVERITY)).intValue();
                    Type type = Type.valueOf((String) marker.getAttribute(IMarker.SOURCE_ID));
                    int newSeverity = AntlrProblemTypeToSeverityMapper.getSeverity(store, type);
                    if (curSeverity != newSeverity) {
                        marker.setAttribute(IMarker.SEVERITY, newSeverity);
                    }
                }
            } catch (CoreException e) {
                YImpex.logError(e);
            }
        }
    }
}
