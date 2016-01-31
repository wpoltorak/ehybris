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
    public static String ImportPlatformPage_setSourcesReadOnly;
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
}
