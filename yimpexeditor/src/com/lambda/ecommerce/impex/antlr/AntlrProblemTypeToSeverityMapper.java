package com.lambda.ecommerce.impex.antlr;

import java.text.MessageFormat;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.preference.IPreferenceStore;

import com.lambda.ecommerce.impex.YMessages;
import com.lambda.ecommerce.impex.preferences.PreferenceConstants;
import com.lambda.impex.ast.ImpexProblem;

public class AntlrProblemTypeToSeverityMapper {

    public static int getSeverity(IPreferenceStore store, ImpexProblem.Type type) {
        switch (type) {
        case EmptyMacroValue:
            return getSeverity(store, PreferenceConstants.PROBLEM_MACRO_EMPTY);
        case UnknownMacro:
        case UnknownConfigMacro:
            return getSeverity(store, PreferenceConstants.PROBLEM_MACRO_UNDEFINED);
        case InvalidType:
            return getSeverity(store, PreferenceConstants.PROBLEM_TYPE_INVALID);
        case InvalidSubtype:
            return getSeverity(store, PreferenceConstants.PROBLEM_SUBTYPE_INVALID);
        case SubtypeRequired:
            return getSeverity(store, PreferenceConstants.PROBLEM_SUBTYPE_MISSING);
        case InvalidAttribute:
            return getSeverity(store, PreferenceConstants.PROBLEM_ATTRIBUTE_INVALID);
        case FieldWithoutHeaderAttribute:
            return getSeverity(store, PreferenceConstants.PROBLEM_FIELD_WITHOUT_HEADER_ATTRIBUTE);
        case DuplicateDocumentID:
            return getSeverity(store, PreferenceConstants.PROBLEM_DOCUMENTID_DUPLICATE);
        case InvalidDocumentID:
            return getSeverity(store, PreferenceConstants.PROBLEM_DOCUMENTID_INVALID);
        case InvalidDocumentIDTypeHierarchy:
            return getSeverity(store, PreferenceConstants.PROBLEM_DOCUMENTID_INVALID_TYPE_HIERARCHY);
        case UnknownAttributeModifier:
        case UnknownHeaderModifier:
        	return getSeverity(store, PreferenceConstants.PROBLEM_MODIFIER_CUSTOM);
        default:
            return IMarker.SEVERITY_ERROR;
        }
    }

    public static String getMessage(String text, ImpexProblem.Type type) {
        Object[] params = text == null ? null : text.split(ImpexProblem.SEPARATOR);
        switch (type) {
        case EmptyMacroValue:
            return YMessages.Impex_problem_blankMacro;
        case UnknownMacro:
            return MessageFormat.format(YMessages.Impex_problem_unknownMacro, params);
        case UnknownConfigMacro:
            return MessageFormat.format(YMessages.Impex_problem_unknownConfigMacro, params);
        case InvalidType:
            return MessageFormat.format(YMessages.Impex_problem_invalidType, params);
        case InvalidSubtype:
            return MessageFormat.format(YMessages.Impex_problem_invalidSubtype, params);
        case SubtypeRequired:
            return YMessages.Impex_problem_noSubtype;
        case InvalidAttribute:
            return MessageFormat.format(YMessages.Impex_problem_invalidAttribute, params);
        case FieldWithoutHeaderAttribute:
            return YMessages.Impex_problem_fieldWithoutHeaderAttribute;
        case DuplicateDocumentID:
            return YMessages.Impex_problem_duplicateDocumentId;
        case InvalidDocumentID:
            return MessageFormat.format(YMessages.Impex_problem_invalidDocumentId, params);
        case InvalidDocumentIDTypeHierarchy:
            return MessageFormat.format(YMessages.Impex_problem_invalidDocumentIdTypeHierarchy, params);
        case InvalidAttributeModifier:
            return MessageFormat.format(YMessages.Impex_problem_invalidAttributeModifier, params);
        case InvalidHeaderModifier:
            return MessageFormat.format(YMessages.Impex_problem_invalidHeaderModifier, params);
        case UnknownAttributeModifier:
        case UnknownHeaderModifier:
        	return MessageFormat.format(YMessages.Impex_problem_customModifier, params);
        case InvalidBoolean:
            return YMessages.Impex_problem_invalidBoolean;
        case InvalidMode:
            return MessageFormat.format(YMessages.Impex_problem_invalidMode, params);
        case InvalidClassname:
            return MessageFormat.format(YMessages.Impex_problem_invalidClassname, params);
        case InvalidPosition:
            return YMessages.Impex_problem_invalidPosition;
        case InvalidDateFormat:
            return MessageFormat.format(YMessages.Impex_problem_invalidDateformat, params);
        case InvalidNumberFormat:
            return MessageFormat.format(YMessages.Impex_problem_invalidNumberformat, params);
        case InvalidLang:
            return MessageFormat.format(YMessages.Impex_problem_invalidLanguage, params);
        default:
            return text;
        }
    }

    private static int getSeverity(IPreferenceStore store, String key) {
        int severity = store.getInt(key);
        return severity == 0 ? IMarker.SEVERITY_ERROR : severity;
    }

}
