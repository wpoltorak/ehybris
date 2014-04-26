package com.lambda.plugin.impex.preferences;

import static com.lambda.plugin.impex.preferences.PreferenceConstants.COLOR_ATTRIBUTE;
import static com.lambda.plugin.impex.preferences.PreferenceConstants.COLOR_ATTRIBUTE_MODIFIER;
import static com.lambda.plugin.impex.preferences.PreferenceConstants.COLOR_BEANSHELL;
import static com.lambda.plugin.impex.preferences.PreferenceConstants.COLOR_BRACKETS;
import static com.lambda.plugin.impex.preferences.PreferenceConstants.COLOR_COMMENT;
import static com.lambda.plugin.impex.preferences.PreferenceConstants.COLOR_MACRO;
import static com.lambda.plugin.impex.preferences.PreferenceConstants.COLOR_MODE;
import static com.lambda.plugin.impex.preferences.PreferenceConstants.COLOR_OTHERS;
import static com.lambda.plugin.impex.preferences.PreferenceConstants.COLOR_STRING;
import static com.lambda.plugin.impex.preferences.PreferenceConstants.COLOR_TYPE;
import static com.lambda.plugin.impex.preferences.PreferenceConstants.COLOR_TYPE_MODIFIER;
import static com.lambda.plugin.impex.preferences.PreferenceConstants.IMPEX_EDITOR_STYLE_SUFFIX;
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
        saveDefaultTokenStyle(store, COLOR_TYPE, new RGB(0, 0, 0), NONE);
        saveDefaultTokenStyle(store, COLOR_MODE, new RGB(0, 0, 255), NONE);
        saveDefaultTokenStyle(store, COLOR_ATTRIBUTE, new RGB(0, 0, 255), NONE);
        saveDefaultTokenStyle(store, COLOR_TYPE_MODIFIER, new RGB(0, 0, 155), NONE);
        saveDefaultTokenStyle(store, COLOR_ATTRIBUTE_MODIFIER, new RGB(0, 0, 155), NONE);
        saveDefaultTokenStyle(store, COLOR_STRING, new RGB(0, 255, 0), NONE);
        saveDefaultTokenStyle(store, COLOR_BRACKETS, new RGB(0, 0, 0), NONE);
        saveDefaultTokenStyle(store, COLOR_OTHERS, new RGB(0, 0, 0), NONE);
    }

    private void saveDefaultTokenStyle(final IPreferenceStore store, String name, RGB color, int styles) {
        PreferenceConverter.setDefault(store, name, color);
        store.setDefault(name + IMPEX_EDITOR_STYLE_SUFFIX, styles);
    }
}
