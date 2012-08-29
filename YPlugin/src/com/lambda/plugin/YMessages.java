package com.lambda.plugin;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import org.eclipse.osgi.util.NLS;

public final class YMessages extends NLS {

    private static final String BUNDLE_NAME = "com.lambda.plugin.YMessages";//$NON-NLS-1$

    static {
        NLS.initializeMessages(BUNDLE_NAME, YMessages.class);
    }

    private YMessages() {
        // Do not instantiate
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
    public static String ImpexEditorPreferencePage_5;
    public static String ImpexEditorPreferencePage_6;
    public static String ImpexEditorPreferencePage_7;
    public static String ImpexEditorPreferencePage_8;
    public static String ImpexEditorPreferencePage_9;
    public static String ImpexEditorPreferencePage_Impex_editor_text_1;
    public static String ImpexEditorPreferencePage_Impex_editor_processing_instuctions_2;
    public static String ImpexEditorPreferencePage_Impex_editor_constant_strings_3;
    public static String ImpexEditorPreferencePage_Impex_editor_tags_4;
    public static String ImpexEditorPreferencePage_Impex_editor_comments_5;

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
}
