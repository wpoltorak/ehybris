package com.lambda.plugin;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import org.eclipse.osgi.util.NLS;

public final class YMessages extends NLS {

    private static final String BUNDLE_NAME = "com.lambda.plugin.YMessages";//$NON-NLS-1$
    private static final String IMPEX_EDITOR_ACTIONS_BUNDLE_NAME = "com.lambda.plugin.impex.editor.actions.ImpexActionMessages";

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
    public static String ImpexEditorPreferencePage_problem_fieldWithoutHeaderAttribute;
    // public static String ImpexEditorPreferencePage_problem_invalidType;
    // public static String ImpexEditorPreferencePage_problem_invalidSubtype;
    // public static String ImpexEditorPreferencePage_problem_missingSubtype;

    // import eCommerce Platform wizard
    public static String ImportPlatformPage_title;
    public static String ImportPlatformPage_description;
    public static String ImportPlatformPage_refresh;
    public static String ImportPlatformPage_selectAll;
    public static String ImportPlatformPage_deselectAll;
    public static String ImportPlatformPage_projects;
    public static String ImportPlatformPage_platformRootFolder;
    public static String ImportPlatformPage_browse;
    public static String ImportPlatformPage_selectPlatformRootFolder;
    public static String ImportPlatformPage_error_ExtensionAlreadyImported;
    public static String ImportPlatformPage_error_ProjectAlreadyExistsInWorkspace;
    public static String ImportPlatformPage_error_ExtensionNotExistsInFS;
    public static String ImportPlatformPage_error_PlatformAlreadyImported;
    public static String ImportPlatformPage_error_PlatformConfigAlreadyImported;
    public static String ImportPlatformPage_error_InvalidPlatformDirectory;
    public static String ImportPlatformPage_error_MissingPlatformConfig;

    // new eCommerce Extension wizard
	public static String AbstractWizard_errorMessage;
	public static String ImportPlatformWizard_title;

	public static String NewExtensionWizard_title;
    public static String NewExtensionPage_LocationGroup_location_desc;
    public static String NewExtensionPage_LocationGroup_locationLabel_desc;
    public static String NewExtensionPage_LocationGroup_browseButton_desc;
    public static String NewExtensionPage_TemplateGroup_title;
    public static String NewExtensionPage_TemplateGroup_template_desc;
    public static String NewExtensionPage_TemplateGroup_templateLabel_desc;
    public static String NewExtensionPage_NamePackageGroup_label_text;
    public static String NewExtensionPage_NamePackageGroup_package_label;
    public static String NewExtensionPage_title;
    public static String NewExtensionPage_description;
    public static String NewExtensionPage_NoPlatform_link;
    public static String NewExtensionPage_operation_create;
    public static String NewExtensionPage_operation_copytemplate;
    public static String NewExtensionPage_operation_createproject;
    public static String NewExtensionPage_error_remove_title;
    public static String NewExtensionPage_error_remove_message;
    public static String NewExtensionPage_operation_remove;
    public static String NewExtensionPage_error_EnterPackageName;
    public static String NewExtensionPage_error_InvalidPackageName;
    public static String NewExtensionPage_error_IsOutputFolder;
    public static String NewExtensionPage_error_PackageExists;
    public static String NewExtensionPage_error_PackageExistsDifferentCase;
    public static String NewExtensionPage_error_EnterName;
    public static String NewExtensionPage_error_PackageNotShown;
    public static String NewExtensionPage_error_PackageNameFiltered;
    public static String NewExtensionPage_error_TemplateFolderDoesNotExist;
    public static String NewExtensionPage_error_PlatformDoesNotExist;
    public static String NewExtensionPage_error_TemplateNotChosen;
    public static String NewExtensionPage_warning_DiscouragedPackageName;
    public static String NewExtensionPage_Message_enterProjectName;
    public static String NewExtensionPage_Message_projectAlreadyExists;
    public static String NewExtensionPage_Message_enterLocation;
    public static String NewExtensionPage_Message_invalidDirectory;
    public static String NewExtensionPage_Message_cannotCreateAtExternalLocation;
    public static String NewExtensionPage_Message_defaultTemplateDoesNotExist;
    public static String NewExtensionPage_Message_noTemplates;

    public static String NewExtensionPage_directory_message;

    // eCommerce Module wizard
    public static String NewModuleWizard_title;
    public static String NewModulePage_title;
    public static String NewModulePage_description;

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
