package com.lambda.plugin.impex.antlr;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.preference.IPreferenceStore;

import com.lambda.impex.ast.ImpexProblem;
import com.lambda.plugin.impex.preferences.PreferenceConstants;

public class AntlrProblemTypeToSeverityMapper {

    public static int getSeverity(IPreferenceStore store, ImpexProblem.Type type) {
        switch (type) {
        case InvalidMacroValue:
            return getSeverity(store, PreferenceConstants.PROBLEM_MACRO_EMPTY);
        default:
            return IMarker.SEVERITY_ERROR;
        }
    }

    private static int getSeverity(IPreferenceStore store, String key) {
        int severity = store.getInt(key);
        return severity == 0 ? IMarker.SEVERITY_ERROR : severity;
    }
}
