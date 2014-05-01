package com.lambda.plugin.impex.preferences;

import org.eclipse.core.resources.IMarker;

import com.lambda.plugin.YPlugin;

public class PreferenceConstants {

    private static final String PREFIX = YPlugin.PLUGIN_ID + ".";
    // Impex Editor Preferences

    // public static final String DEFAULT_COLOR = IPreferenceStore.STRING_DEFAULT_DEFAULT;
    /**
     * Common prefix for syntax coloring related preferences
     */
    public static final String IMPEX_SYNTAX_COLORING_PREFIX = "impex_";

    /**
     * Preference key for color of keyword in impex editor
     */
    public static final String COLOR_KEYWORD = IMPEX_SYNTAX_COLORING_PREFIX + "keyword";

    /**
     * Preference key for color of mode in impex editor
     */
    public static final String COLOR_MODE = IMPEX_SYNTAX_COLORING_PREFIX + "mode";

    /**
     * Preference key for color of type in impex editor
     */
    public static final String COLOR_TYPE = IMPEX_SYNTAX_COLORING_PREFIX + "type";

    /**
     * Preference key for color of type modifier in impex editor
     */
    public static final String COLOR_HEADER_MODIFIER = IMPEX_SYNTAX_COLORING_PREFIX + "type_modifier";

    /**
     * Preference key for color of attribute in impex editor
     */
    public static final String COLOR_ATTRIBUTE = IMPEX_SYNTAX_COLORING_PREFIX + "attribute";

    /**
     * Preference key for color of attribute modifier in impex editor
     */
    public static final String COLOR_ATTRIBUTE_MODIFIER = IMPEX_SYNTAX_COLORING_PREFIX + "attribute_modifier";

    /**
     * Preference key for color of brackets in impex editor
     */
    public static final String COLOR_BRACKETS = IMPEX_SYNTAX_COLORING_PREFIX + "brackets";

    /**
     * Preference key for color of comment in impex editor
     */
    public static final String COLOR_COMMENT = IMPEX_SYNTAX_COLORING_PREFIX + "comment";// ImpexLexer.tokenNames[ImpexLexer.Comment];

    /**
     * Preference key for color of beanshell in impex editor
     */
    public static final String COLOR_BEANSHELL = IMPEX_SYNTAX_COLORING_PREFIX + "beanshell";// ImpexLexer.tokenNames[ImpexLexer.Beanshell];

    /**
     * Preference key for color of userrights section in impex editor
     */
    public static final String COLOR_USERRIGHTS = IMPEX_SYNTAX_COLORING_PREFIX + "userrights";// ImpexLexer.tokenNames[ImpexLexer.Beanshell];

    /**
     * Preference key for color of quoted string in impex editor
     */
    public static final String COLOR_STRING = IMPEX_SYNTAX_COLORING_PREFIX + "string";

    /**
     * Preference key for color of macro definition in impex editor
     */
    public static final String COLOR_MACRO = IMPEX_SYNTAX_COLORING_PREFIX + "macro_def";

    /**
     * Preference key for color of documentID definition in impex editor
     */
    public static final String COLOR_DOCUMENTID = IMPEX_SYNTAX_COLORING_PREFIX + "documentid";

    /**
     * Preference key for generic color to use in impex editor
     */
    public static final String COLOR_OTHERS = IMPEX_SYNTAX_COLORING_PREFIX + "others";

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

    /**
     * Severity levels for Impex Editor problems
     */
    public static final int IMPEX_ERROR = IMarker.SEVERITY_ERROR; //$NON-NLS-1$
    public static final int IMPEX_WARNING = IMarker.SEVERITY_WARNING; //$NON-NLS-1$
    public static final int IMPEX_IGNORE = -1; //$NON-NLS-1$

    /**
     * Empty macro assignment problem.<br/>
     * Example: $macro =
     */
    public static final String PROBLEM_MACRO_EMPTY = "problem_empty_macro";

}
