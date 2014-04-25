package com.lambda.plugin.impex.editor;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.graphics.RGB;

public interface ImpexColorConstants {
    RGB BEANSHELL = new RGB(153, 153, 153);
    RGB STRING = new RGB(0, 128, 0);
    RGB DEFAULT = new RGB(0, 0, 0);

    String DEFAULT_COLOR = IPreferenceStore.STRING_DEFAULT_DEFAULT;
    String KEYWORD_COLOR = "impex_keyword";
    String BRACKETS_COLOR = "impex_brackets";
    String COMMENT_COLOR = "impex_comment";// ImpexLexer.tokenNames[ImpexLexer.Comment];
    String STRING_COLOR = "impex_string";
    String MACRO_COLOR = "impex_macro_def";
    String OTHERS_COLOR = "impex_others";
}
