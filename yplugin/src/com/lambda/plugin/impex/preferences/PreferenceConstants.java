package com.lambda.plugin.impex.preferences;

import com.lambda.plugin.YPlugin;

public class PreferenceConstants {

    private static final String PREFIX = YPlugin.PLUGIN_ID + ".";
    // Impex Editor Preferences

    // public static final String DEFAULT_COLOR = IPreferenceStore.STRING_DEFAULT_DEFAULT;
    /**
     * Preference key for color of keyword in impex editor
     */
    public static final String COLOR_KEYWORD = "impex_keyword";

    /**
     * Preference key for color of mode in impex editor
     */
    public static final String COLOR_MODE = "impex_mode";

    /**
     * Preference key for color of type in impex editor
     */
    public static final String COLOR_TYPE = "impex_type";

    /**
     * Preference key for color of type modifier in impex editor
     */
    public static final String COLOR_TYPE_MODIFIER = "impex_type_modifier";

    /**
     * Preference key for color of attribute in impex editor
     */
    public static final String COLOR_ATTRIBUTE = "impex_attribute";

    /**
     * Preference key for color of attribute modifier in impex editor
     */
    public static final String COLOR_ATTRIBUTE_MODIFIER = "impex_attribute_modifier";

    /**
     * Preference key for color of brackets in impex editor
     */
    public static final String COLOR_BRACKETS = "impex_brackets";

    /**
     * Preference key for color of comment in impex editor
     */
    public static final String COLOR_COMMENT = "impex_comment";// ImpexLexer.tokenNames[ImpexLexer.Comment];

    /**
     * Preference key for color of beanshell in impex editor
     */
    public static final String COLOR_BEANSHELL = "impex_beanshell";// ImpexLexer.tokenNames[ImpexLexer.Beanshell];

    /**
     * Preference key for color of quoted string in impex editor
     */
    public static final String COLOR_STRING = "impex_string";

    /**
     * Preference key for color of macro definition color in impex editor
     */
    public static final String COLOR_MACRO = "impex_macro_def";

    /**
     * Preference key for generic color to use in impex editor
     */
    public static final String COLOR_OTHERS = "impex_others";

    /**
     * Preference key suffix for text style preference keys.
     */
    public static final String IMPEX_EDITOR_STYLE_SUFFIX = "_style"; //$NON-NLS-1$

    /**
     * Mark occurrences in Impex Editor
     */
    public static final String IMPEX_EDITOR_MARK_OCCURRENCES = PREFIX + "impex_mark_occurrences";

    /**
     * Mark macro occurrences in Impex Editor
     */
    public static final String IMPEX_EDITOR_MARK_MACRO_OCCURRENCES = PREFIX + ".impex_mark_macro_occurrences";

    /**
     * Mark table name occurrences in Impex Editor
     */
    public static final String IMPEX_EDITOR_MARK_TABLE_OCCURRENCES = PREFIX + ".impex_mark_table_occurrences";

    /**
     * Mark column name occurrences in Impex Editor
     */
    public static final String IMPEX_EDITOR_MARK_COLUMN_OCCURRENCES = PREFIX + ".impex_mark_column_occurrences";

    /**
     * Mark column name occurrences in Impex Editor
     */
    public static final String IMPEX_EDITOR_MARK_VALUE_OCCURRENCES = PREFIX + ".impex_mark_value_occurrences";

    //

}
