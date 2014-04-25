package com.lambda.plugin.impex.preferences;

import static com.lambda.plugin.impex.preferences.PreferenceConstants.COLOR_BEANSHELL;
import static com.lambda.plugin.impex.preferences.PreferenceConstants.COLOR_COMMENT;
import static com.lambda.plugin.impex.preferences.PreferenceConstants.COLOR_KEYWORD;
import static com.lambda.plugin.impex.preferences.PreferenceConstants.COLOR_MACRO;
import static com.lambda.plugin.impex.preferences.PreferenceConstants.COLOR_STRING;
import static com.lambda.plugin.impex.preferences.PreferenceConstants.COLOR_TYPE;
import static com.lambda.plugin.impex.preferences.PreferenceConstants.IMPEX_EDITOR_BOLD_SUFFIX;
import static com.lambda.plugin.impex.preferences.PreferenceConstants.IMPEX_EDITOR_ITALIC_SUFFIX;
import static com.lambda.plugin.impex.preferences.PreferenceConstants.IMPEX_EDITOR_STRIKETHROUGH_SUFFIX;
import static com.lambda.plugin.impex.preferences.PreferenceConstants.IMPEX_EDITOR_UNDERLINE_SUFFIX;
import static org.eclipse.jface.text.TextAttribute.STRIKETHROUGH;
import static org.eclipse.jface.text.TextAttribute.UNDERLINE;
import static org.eclipse.swt.SWT.BOLD;
import static org.eclipse.swt.SWT.ITALIC;
import static org.eclipse.swt.SWT.NONE;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.RGB;

import com.lambda.plugin.YPlugin;

/**
 * Initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
     */
    @Override
    public void initializeDefaultPreferences() {
        final IPreferenceStore store = YPlugin.getDefault().getPreferenceStore();
        initializeDefaultPreferences(store);
    }

    public void initializeDefaultPreferences(final IPreferenceStore store) {
        saveDefaultTokenStyle(store, COLOR_COMMENT, new RGB(249, 192, 255), NONE);
        saveDefaultTokenStyle(store, COLOR_BEANSHELL, new RGB(153, 153, 153), NONE);
        saveDefaultTokenStyle(store, COLOR_MACRO, new RGB(255, 0, 0), NONE);
        saveDefaultTokenStyle(store, COLOR_TYPE, new RGB(0, 0, 255), NONE);
        saveDefaultTokenStyle(store, COLOR_KEYWORD, new RGB(255, 125, 45), NONE);
        saveDefaultTokenStyle(store, COLOR_STRING, new RGB(0, 255, 0), NONE);
    }

    private void saveDefaultTokenStyle(final IPreferenceStore store, String name, RGB color, int styles) {
        PreferenceConverter.setValue(store, name, color);
        store.setDefault(name + IMPEX_EDITOR_BOLD_SUFFIX, (styles & BOLD) == BOLD);
        store.setDefault(name + IMPEX_EDITOR_ITALIC_SUFFIX, (styles & ITALIC) == ITALIC);
        store.setDefault(name + IMPEX_EDITOR_UNDERLINE_SUFFIX, (styles & UNDERLINE) == UNDERLINE);
        store.setDefault(name + IMPEX_EDITOR_STRIKETHROUGH_SUFFIX, (styles & STRIKETHROUGH) == STRIKETHROUGH);
    }
}
