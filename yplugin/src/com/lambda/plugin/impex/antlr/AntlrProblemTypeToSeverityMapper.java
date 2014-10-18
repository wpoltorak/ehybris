package com.lambda.plugin.impex.antlr;

import java.text.MessageFormat;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.preference.IPreferenceStore;

import com.lambda.impex.ast.ImpexProblem;
import com.lambda.plugin.YMessages;
import com.lambda.plugin.impex.preferences.PreferenceConstants;

public class AntlrProblemTypeToSeverityMapper {

    public static int getSeverity(IPreferenceStore store, ImpexProblem.Type type) {
        switch (type) {
        case EmptyMacroValue:
            return getSeverity(store, PreferenceConstants.PROBLEM_MACRO_EMPTY);
        case UnknownMacro:
            return getSeverity(store, PreferenceConstants.PROBLEM_MACRO_UNDEFINED);
        case InvalidType:
            return getSeverity(store, PreferenceConstants.PROBLEM_TYPE_INVALID);
        case InvalidSubtype:
            return getSeverity(store, PreferenceConstants.PROBLEM_SUBTYPE_INVALID);
        case SubtypeRequired:
            return getSeverity(store, PreferenceConstants.PROBLEM_SUBTYPE_MISSING);
        default:
            return IMarker.SEVERITY_ERROR;
        }
    }

    private static int getSeverity(IPreferenceStore store, String key) {
        int severity = store.getInt(key);
        return severity == 0 ? IMarker.SEVERITY_ERROR : severity;
    }

    public static String getMessage(String text, ImpexProblem.Type type) {
        switch (type) {
        case EmptyMacroValue:
            return YMessages.Impex_problem_blankMacro;
        case UnknownMacro:
            return MessageFormat.format(YMessages.Impex_problem_unknownMacro, text);
        case InvalidType:
            return YMessages.Impex_problem_invalidType;
        case InvalidSubtype:
            return YMessages.Impex_problem_invalidSubtype;
        case SubtypeRequired:
            return YMessages.Impex_problem_noSubtype;
        default:
            return text;
        }
    }
}
