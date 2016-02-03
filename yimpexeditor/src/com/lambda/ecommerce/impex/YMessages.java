package com.lambda.ecommerce.impex;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import org.eclipse.osgi.util.NLS;

public final class YMessages extends NLS {

    private static final String BUNDLE_NAME = "com.lambda.ecommerce.impex.YMessages";//$NON-NLS-1$
    private static final String IMPEX_EDITOR_ACTIONS_BUNDLE_NAME = "com.lambda.ecommerce.impex.editor.actions.ImpexActionMessages";

    private static ResourceBundle impexEditorActionsBundle = ResourceBundle.getBundle(IMPEX_EDITOR_ACTIONS_BUNDLE_NAME);

    static {
        NLS.initializeMessages(BUNDLE_NAME, YMessages.class);
    }

    private YMessages() {
        // Do not instantiate
    }

    public static ResourceBundle getImpexEditorActionsBundle() {
        return impexEditorActionsBundle;
    }

    public static final ResourceBundle getBundle() {
        return ResourceBundle.getBundle(BUNDLE_NAME);
    }

    public static String format(final String message, final Object object) {
        return MessageFormat.format(message, new Object[] { object });
    }

    public static String format(final String message, final Object[] objects) {
        return MessageFormat.format(message, objects);
    }

    public static String ImpexEditorPreferencePage_description;
    public static String ImpexEditorPreferencePage_general;
    public static String ImpexEditorPreferencePage_0;
    public static String ImpexEditorPreferencePage_1;
    public static String ImpexEditorPreferencePage_3;
    public static String ImpexEditorPreferencePage_foreground;
    public static String ImpexEditorPreferencePage_color;
    public static String ImpexEditorPreferencePage_preview;
    public static String ImpexEditorPreferencePage_bold;
    public static String ImpexEditorPreferencePage_italic;
    public static String ImpexEditorPreferencePage_underline;
    public static String ImpexEditorPreferencePage_strikethrough;
    public static String ImpexEditorPreferencePage_Impex_editor_text_1;
    public static String ImpexEditorPreferencePage_Impex_editor_processing_instuctions_2;
    public static String ImpexEditorPreferencePage_Impex_editor_constant_strings_3;
    public static String ImpexEditorPreferencePage_Impex_editor_tags_4;
    public static String ImpexEditorPreferencePage_Impex_editor_comments_5;
    public static String ImpexEditorPreferencePage_problems;
    public static String ImpexEditorPreferencePage_selectLevel;
    public static String ImpexEditorPreferencePage_error;
    public static String ImpexEditorPreferencePage_warning;
    public static String ImpexEditorPreferencePage_ignore;
    public static String ImpexEditorPreferencePage_problem_emptyMacro;
    public static String ImpexEditorPreferencePage_problem_undefinedMacro;
    public static String ImpexEditorPreferencePage_problem_customModifier;
    public static String ImpexEditorPreferencePage_problem_fieldWithoutHeaderAttribute;
    // public static String ImpexEditorPreferencePage_problem_invalidType;
    // public static String ImpexEditorPreferencePage_problem_invalidSubtype;
    // public static String ImpexEditorPreferencePage_problem_missingSubtype;

    // eCommerce Impex Editor preference page
    public static String ImpexEditorPreferencePage_singleLineComment;
    public static String ImpexEditorPreferencePage_macros;
    public static String ImpexEditorPreferencePage_keywords;
    public static String ImpexEditorPreferencePage_beanshell;
    public static String ImpexEditorPreferencePage_userrights;
    public static String ImpexEditorPreferencePage_brackets;
    public static String ImpexEditorPreferencePage_strings;
    public static String ImpexEditorPreferencePage_others;
    public static String ImpexEditorPreferencePage_modes;
    public static String ImpexEditorPreferencePage_types;
    public static String ImpexEditorPreferencePage_typeModifiers;
    public static String ImpexEditorPreferencePage_attributes;
    public static String ImpexEditorPreferencePage_specialAttributes;
    public static String ImpexEditorPreferencePage_attributeModifiers;
    public static String ImpexEditorPreferencePage_documentIDs;
    public static String ImpexEditorPreferencePage_documentIdFields;
    public static String ImpexEditorPreferencePage_skippedFields;

    // Impex problems
    public static String Impex_problem_unknownMacro;
    public static String Impex_problem_unknownConfigMacro;
    public static String Impex_problem_blankMacro;
    public static String Impex_problem_invalidType;
    public static String Impex_problem_invalidSubtype;
    public static String Impex_problem_noSubtype;
    public static String Impex_problem_invalidAttribute;
    public static String Impex_problem_invalidAttributeModifier;
    public static String Impex_problem_invalidHeaderModifier;
    public static String Impex_problem_customModifier;
    public static String Impex_problem_fieldWithoutHeaderAttribute;
    public static String Impex_problem_duplicateDocumentId;
    public static String Impex_problem_invalidDocumentId;
    public static String Impex_problem_invalidDocumentIdTypeHierarchy;
    public static String Impex_problem_invalidBoolean;
    public static String Impex_problem_invalidMode;
    public static String Impex_problem_invalidClassname;
    public static String Impex_problem_invalidPosition;
    public static String Impex_problem_invalidDateformat;
    public static String Impex_problem_invalidNumberformat;
    public static String Impex_problem_invalidLanguage;

    // Impex others
    public static String ImpexToggleComment_progress;
    public static String ImpexTypeHyperlink_hyperlinkText;
    public static String ImpexEditorPreferencePage_markOccurrences_link;
    public static String ImpexEditorPreferencePage_markOccurrences;
    public static String ImpexEditorPreferencePage_markOccurrences_types;
    public static String ImpexEditorPreferencePage_markOccurrences_macros;
    public static String ImpexEditorPreferencePage_markOccurrences_documentIDQualifiers;
    public static String ImpexEditorPreferencePage_markOccurrences_stickyOccurrences;
}
