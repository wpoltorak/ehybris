package com.lambda.plugin.impex.preferences;

import org.eclipse.core.resources.IMarker;

import com.lambda.plugin.YPlugin;

public class PreferenceConstants {

    private static final String PREFIX = YPlugin.PLUGIN_ID + ".";
    // Impex Editor Preferences

    // public static final String DEFAULT_COLOR = IPreferenceStore.STRING_DEFAULT_DEFAULT;
    /**
     * Common prefix for syntax coloring related preferences. This value is also used as single notification for editors
     * to invalidate text presentation after changes to syntax coloring related preferences were applied.
     */
    public static final String IMPEX_SYNTAX_COLORING = "impex_syntaxcoloring";

    /**
     * Preference key for color of keyword in impex editor
     */
    public static final String COLOR_KEYWORD = IMPEX_SYNTAX_COLORING + "_keyword";

    /**
     * Preference key for color of mode in impex editor
     */
    public static final String COLOR_MODE = IMPEX_SYNTAX_COLORING + "_mode";

    /**
     * Preference key for color of type in impex editor
     */
    public static final String COLOR_TYPE = IMPEX_SYNTAX_COLORING + "_type";

    /**
     * Preference key for color of type modifier in impex editor
     */
    public static final String COLOR_HEADER_MODIFIER = IMPEX_SYNTAX_COLORING + "_type_modifier";

    /**
     * Preference key for color of attribute in impex editor
     */
    public static final String COLOR_ATTRIBUTE = IMPEX_SYNTAX_COLORING + "_attribute";

    /**
     * Preference key for color of attribute modifier in impex editor
     */
    public static final String COLOR_ATTRIBUTE_MODIFIER = IMPEX_SYNTAX_COLORING + "_attribute_modifier";

    /**
     * Preference key for color of brackets in impex editor
     */
    public static final String COLOR_BRACKETS = IMPEX_SYNTAX_COLORING + "_brackets";

    /**
     * Preference key for color of comment in impex editor
     */
    public static final String COLOR_COMMENT = IMPEX_SYNTAX_COLORING + "_comment";// ImpexLexer.tokenNames[ImpexLexer.Comment];

    /**
     * Preference key for color of beanshell in impex editor
     */
    public static final String COLOR_BEANSHELL = IMPEX_SYNTAX_COLORING + "_beanshell";// ImpexLexer.tokenNames[ImpexLexer.Beanshell];

    /**
     * Preference key for color of beanshell in impex editor
     */
    public static final String COLOR_SPECIAL_ATTRIBUTE = IMPEX_SYNTAX_COLORING + "_specialattribute";// ImpexLexer.tokenNames[ImpexLexer.SpecialAttribute];

    /**
     * Preference key for color of userrights section in impex editor
     */
    public static final String COLOR_USERRIGHTS = IMPEX_SYNTAX_COLORING + "_userrights";// ImpexLexer.tokenNames[ImpexLexer.Usserrights];

    /**
     * Preference key for color of quoted string in impex editor
     */
    public static final String COLOR_STRING = IMPEX_SYNTAX_COLORING + "_string";

    /**
     * Preference key for color of macro definition in impex editor
     */
    public static final String COLOR_MACRO = IMPEX_SYNTAX_COLORING + "_macro_def";

    /**
     * Preference key for color of documentID definition in impex editor
     */
    public static final String COLOR_DOCUMENTID = IMPEX_SYNTAX_COLORING + "_documentid";

    /**
     * Preference key for generic color to use in impex editor
     */
    public static final String COLOR_OTHERS = IMPEX_SYNTAX_COLORING + "_others";

    /** Preference key for color of skipped field */
    public static final String COLOR_SKIPPED_FIELD = IMPEX_SYNTAX_COLORING + "_skipped_field";

    /** Preference key for color of document id field */
    public static final String COLOR_DOCUMENTID_FIELD = IMPEX_SYNTAX_COLORING + "_documentid_field";
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

    public static final String IMPEX_PROBLEM = "impex_problem";

    /**
     * Empty macro assignment problem<br/>
     * Example: $macro =
     */
    public static final String PROBLEM_MACRO_EMPTY = IMPEX_PROBLEM + "_empty_macro";

    /**
     * Undefined macro problem.<br/>
     * There is no macro definition for the given macro reference
     */
    public static final String PROBLEM_MACRO_UNDEFINED = IMPEX_PROBLEM + "_undefined_macro";

    /**
     * Invalid type problem<br/>
     * <ul>
     * <li>Type does not exist</li>
     * <li>Type is not a child of <code>de.hybris.platform.jalo.ExtensibleItem</li>
     * </ul>
     */
    public static final String PROBLEM_TYPE_INVALID = IMPEX_PROBLEM + "_invalid_type";

    /**
     * Invalid subtype problem<br/>
     * <ul>
     * <li>Subtype does not exist</li>
     * <li>Subtype is not a child of type
     * </ul>
     */
    public static final String PROBLEM_SUBTYPE_INVALID = IMPEX_PROBLEM + "_invalid_subtype";

    /**
     * Missing subtype problem<br/>
     * <ul>
     * <li>Subtype han't been defined</li>
     * </ul>
     */
    public static final String PROBLEM_SUBTYPE_MISSING = IMPEX_PROBLEM + "_missing_subtype";

    /**
     * Invalid attribute problem<br/>
     * <ul>
     * <li>Attribute doesn't exist in an owner type</li>
     * </ul>
     */
    public static final String PROBLEM_ATTRIBUTE_INVALID = IMPEX_PROBLEM + "_invalid_attribute";

    /**
     * Field without header attribute. When number of field exceeds number of attributes in the header.
     */
    public static final String PROBLEM_FIELD_WITHOUT_HEADER_ATTRIBUTE = IMPEX_PROBLEM
            + "_field_without_header_attribute";

}
