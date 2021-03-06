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

    public static String JUnitLaunchConfigurationTab_label_browse;
    public static String JUnitLaunchConfigurationTab_label_search;
    public static String JUnitLaunchConfigurationTab_label_containerTest;
    public static String JUnitLaunchConfigurationTab_label_keeprunning;
    public static String JUnitLaunchConfigurationTab_label_method;
    public static String JUnitLaunchConfigurationTab_testdialog_title;
    public static String JUnitLaunchConfigurationTab_testdialog_message;
    public static String JUnitLaunchConfigurationTab_projectdialog_title;
    public static String JUnitLaunchConfigurationTab_projectdialog_message;
    public static String JUnitLaunchConfigurationTab_error_noContainer;
    public static String JUnitLaunchConfigurationTab_error_projectnotdefined;
    public static String JUnitLaunchConfigurationTab_error_invalidProjectName;
    public static String JUnitLaunchConfigurationTab_error_projectnotexists;
    public static String JUnitLaunchConfigurationTab_error_notJavaProject;
    public static String JUnitLaunchConfigurationTab_error_JDK15_required;
    public static String JUnitLaunchConfigurationTab_error_testcasenotonpath;
    public static String JUnitLaunchConfigurationTab_error_testannotationnotonpath;
    public static String JUnitLaunchConfigurationTab_error_test_class_not_found;
    public static String JUnitLaunchConfigurationTab_error_testnotdefined;
    public static String JUnitLaunchConfigurationTab_tab_label;
    public static String FunctestLaunchConfigurationTab_folderdialog_title;
    public static String FunctestLaunchConfigurationTab_folderdialog_message;
    public static String ExpandAllAction_text;
    public static String ExpandAllAction_tooltip;
    public static String FunctestModel_could_not_read;
    public static String FunctestModel_could_not_write;
    public static String FunctestLaunchConfigurationTab_label_test;
    public static String FunctestLaunchConfigurationTab_Test_Loader;
    public static String FunctestLaunchConfigurationTab_label_oneTest;
    public static String FunctestLaunchConfigurationTab_server_group;
    public static String FunctestLaunchConfigurationTab_label_development;
    public static String FunctestLaunchConfigurationTab_label_staging;
    public static String FunctestLaunchConfigurationTab_label_production;
    public static String FunctestLaunchConfigurationTab_label_remote;
    public static String FunctestLaunchConfigurationTab_junit_group;
    public static String FunctestLaunchConfigurationTab_label_project;
    public static String FunctestLaunchConfigurationTab_error_noRemoteServer;

    public static String CopyFailureList_action_label;
    public static String CopyFailureList_problem;
    public static String CopyFailureList_clipboard_busy;

    public static String CounterPanel_label_server;
    public static String CounterPanel_label_runs;
    public static String CounterPanel_label_errors;
    public static String CounterPanel_label_failures;
    public static String CounterPanel_runcount;
    public static String CounterPanel_runcount_ignored;

    // FunctestCopyAction
    public static String CopyTrace_action_label;
    public static String CopyTraceAction_problem;
    public static String CopyTraceAction_clipboard_busy;

    public static String OpenEditorAction_action_label;
    public static String OpenEditorAction_error_cannotopen_message;
    public static String OpenEditorAction_error_cannotopen_title;
    public static String OpenEditorAction_error_dialog_message;
    public static String OpenEditorAction_error_dialog_title;
    public static String OpenEditorAction_message_cannotopen;
    public static String OpenTestAction_error_title;
    public static String OpenTestAction_error_methodNoFound;
    public static String RerunAction_label_rerun;
    public static String RerunAction_label_run;
    public static String RerunAction_label_debug;
    public static String ScrollLockAction_action_label;
    public static String ScrollLockAction_action_tooltip;
    public static String ShowNextFailureAction_label;
    public static String ShowNextFailureAction_tooltip;
    public static String ShowPreviousFailureAction_label;
    public static String ShowPreviousFailureAction_tooltip;

    public static String EnableStackFilterAction_action_label;
    public static String EnableStackFilterAction_action_description;
    public static String EnableStackFilterAction_action_tooltip;

    public static String FunctestView_jobName;
    public static String FunctestView_history;
    public static String FunctestView_wrapperJobName;
    public static String FunctestView_stopaction_text;
    public static String FunctestView_select_test_run;
    public static String FunctestView_stopaction_tooltip;
    public static String FunctestView_show_execution_time;
    public static String FunctestView_show_failures_only;
    public static String FunctestView_rerunaction_label;
    public static String FunctestView_rerunaction_tooltip;
    public static String FunctestView_hierarchical_layout;
    public static String FunctestView_rerunfailuresaction_label;
    public static String FunctestView_rerunfailuresaction_tooltip;
    public static String FunctestView_rerunFailedFirstLaunchConfigName;
    public static String FunctestView_rerunfailuresonlyaction_label;
    public static String FunctestView_rerunfailuresonlyaction_tooltip;
    public static String FunctestView_rerunFailedLaunchConfigName;

    public static String FunctestView_ImportTestRunSessionAction_name;
    public static String FunctestView_ImportTestRunSessionAction_title;
    public static String FunctestView_ImportTestRunSessionAction_error_title;
    public static String FunctestView_ExportTestRunSessionAction_name;
    public static String FunctestView_ExportTestRunSessionAction_title;
    public static String FunctestView_ExportTestRunSessionAction_error_title;
    public static String FunctestView_error_cannotrerun;
    public static String FunctestView_message_terminated;
    public static String FunctestView_cannotrerun_title;
    public static String FunctestView_cannotrerurn_message;
    public static String FunctestView_clear_history_label;
    public static String FunctestView_label_failure;
    public static String FunctestView_message_finish;
    public static String FunctestView_max_remembered;
    public static String FunctestView_message_stopped;
    public static String FunctestView_message_stopping;
    public static String FunctestView_message_started;
    public static String FunctestView_configName;
    public static String FunctestView_layout_menu;
    public static String FunctestView_Launching;
    public static String FunctestView_test_runs;
    public static String TestRunSession_unrootedTests;
    public static String FunctestView_toggle_vertical_label;
    public static String FunctestView_toggle_horizontal_label;
    public static String FunctestView_activate_on_failure_only;
    public static String FunctestView_toggle_automatic_label;
    public static String FunctestView_terminate_title;
    public static String FunctestView_terminate_message;
    public static String FunctestView_test_run_history;
    public static String FunctestView_testName_startTime;
    public static String FunctestView_titleToolTip;
    public static String FunctestLaunchShortcut_message_selectTestToDebug;
    public static String FunctestLaunchShortcut_message_selectConfiguration;
    public static String FunctestLaunchConfigurationDelegate_error_no_socket;
    public static String FunctestLaunchConfigurationDelegate_dialog_title;
    public static String FunctestLaunchConfigurationDelegate_error_invalidproject;
    public static String FunctestLaunchConfigurationDelegate_error_input_element_deosn_not_exist;
    public static String FunctestLaunchConfigurationDelegate_error_wrong_input;
    public static String FunctestLaunchConfigurationDelegate_verifying_attriburtes_description;
    public static String FunctestLaunchConfigurationDelegate_create_source_locator_description;
    public static String FunctestLaunchConfigurationDelegate_input_type_does_not_exist;
    public static String TestSessionLabelProvider_testName_elapsedTimeInSeconds;
    public static String TestSessionLabelProvider_testName_JUnitVersion;
    public static String TestSessionLabelProvider_testMethodName_className;

    public static String JUnitMainTab_label_defaultpackage;

    // Preference Pages
    public static String JUnitPreferencePage_description;
    public static String JUnitPreferencePage_enableassertionscheckbox_label;
    public static String JUnitPreferencePage_enableassertionscheckbox_tooltip;
    public static String JUnitPreferencePage_filter_label;
    public static String JUnitPreferencePage_addfilterbutton_label;
    public static String JUnitPreferencePage_addfilterbutton_tooltip;
    public static String JUnitPreferencePage_addtypebutton_label;
    public static String JUnitPreferencePage_addtypebutton_tooltip;
    public static String JUnitPreferencePage_addpackagebutton_label;
    public static String JUnitPreferencePage_addpackagebutton_tooltip;
    public static String JUnitPreferencePage_removefilterbutton_label;
    public static String JUnitPreferencePage_removefilterbutton_tooltip;
    public static String JUnitPreferencePage_enableallbutton_label;
    public static String JUnitPreferencePage_enableallbutton_tooltip;
    public static String JUnitPreferencePage_disableallbutton_label;
    public static String JUnitPreferencePage_disableallbutton_tooltip;
    public static String JUnitPreferencePage_invalidstepfilterreturnescape;
    public static String JUnitPreferencePage_addtypedialog_title;
    public static String JUnitPreferencePage_addtypedialog_error_message;
    public static String JUnitPreferencePage_addtypedialog_message;
    public static String JUnitPreferencePage_addpackagedialog_title;
    public static String JUnitPreferencePage_addpackagedialog_message;

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

    public static String JUnitPropertyPage_description;
    public static String JUnitPropertyPage_filter_label;
    public static String JUnitPropertyPage_addfilterbutton_label;
    public static String JUnitPropertyPage_addfilterbutton_tooltip;
    public static String JUnitPropertyPage_addtypebutton_label;
    public static String JUnitPropertyPage_addtypebutton_tooltip;
    public static String JUnitPropertyPage_addpackagebutton_label;
    public static String JUnitPropertyPage_addpackagebutton_tooltip;
    public static String JUnitPropertyPage_removefilterbutton_label;
    public static String JUnitPropertyPage_removefilterbutton_tooltip;
    public static String JUnitPropertyPage_enableallbutton_label;
    public static String JUnitPropertyPage_enableallbutton_tooltip;
    public static String JUnitPropertyPage_disableallbutton_label;
    public static String JUnitPropertyPage_disableallbutton_tooltip;
    public static String JUnitPropertyPage_invalidstepfilterreturnescape;
    public static String JUnitPropertyPage_addtypedialog_title;
    public static String JUnitPropertyPage_addtypedialog_error_message;
    public static String JUnitPropertyPage_addtypedialog_message;
    public static String JUnitPropertyPage_addpackagedialog_title;
    public static String JUnitPropertyPage_addpackagedialog_message;

    public static String CompareResultsAction_label;
    public static String CompareResultsAction_description;
    public static String CompareResultsAction_tooltip;

    public static String TestSelectionElementsLabelProvider_testElementName_projectName;
    public static String TestSearchEngine_message_searching;
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
    public static String ImportPlatformProject_title;

    // new eCommerce Extension wizard
    public static String NewExtensionProject_title;
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
    public static String NewModulePage_title;
    public static String NewModulePage_description;
    public static String NewModuleProject_title;

    // eCommerce Platform preference page
    public static String PlatformPreferencePage_Title;
    public static String PlatformPreferencePage_Description;
    public static String PlatformPreferencePage_ErrorNoDefaultPlatform;
    public static String PlatformPreferencePage_ErrorPlatformNotExists;
    public static String PlatformPreferencePage_ErrorInvalidPlatformDirectory;
    public static String PlatformPreferencePage_Column_Location;
    public static String PlatformPreferencePage_Column_Name;
    public static String PlatformPreferencePage_Column_Description;
    public static String PlatformPreferencePage_Column_Version;
    public static String PlatformPreferencePage_Button_Add;
    public static String PlatformPreferencePage_Button_Edit;
    public static String PlatformPreferencePage_Button_Remove;

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

    // Platform definitions
    public static String PlatformDefinitions_invalid_nameAndPath;
    public static String PlatformDefinitions_invalid_name;
    public static String PlatformDefinitions_invalid_path;
    public static String PlatformDefinitions_invalid_id;
    public static String PlatformDefinitions_invalid_idNameAndPath;

    // Impex problems
    public static String Impex_problem_unknownMacro;
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
