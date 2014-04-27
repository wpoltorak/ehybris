package com.lambda.plugin.impex.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.SWT;
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
        initializeDefaultSyntaxColoringPreferences(store);
        initializeDefaultProblemsPreferences(store);
    }

    public void initializeDefaultProblemsPreferences(IPreferenceStore store) {
        store.setDefault(PreferenceConstants.PROBLEM_MACRO_EMPTY, PreferenceConstants.IMPEX_WARNING);
    }

    public void initializeDefaultSyntaxColoringPreferences(final IPreferenceStore store) {
        saveDefaultTokenStyle(store, PreferenceConstants.COLOR_COMMENT, new RGB(63, 127, 95), SWT.NONE);
        saveDefaultTokenStyle(store, PreferenceConstants.COLOR_BEANSHELL, new RGB(100, 100, 100), SWT.NONE);
        saveDefaultTokenStyle(store, PreferenceConstants.COLOR_USERRIGHTS, new RGB(100, 100, 100), SWT.NONE);
        saveDefaultTokenStyle(store, PreferenceConstants.COLOR_MACRO, new RGB(0, 0, 192), SWT.NONE);
        saveDefaultTokenStyle(store, PreferenceConstants.COLOR_TYPE, new RGB(0, 0, 0), SWT.NONE);
        saveDefaultTokenStyle(store, PreferenceConstants.COLOR_MODE, new RGB(127, 0, 85), SWT.BOLD);
        saveDefaultTokenStyle(store, PreferenceConstants.COLOR_ATTRIBUTE, new RGB(0, 0, 255), SWT.NONE);
        saveDefaultTokenStyle(store, PreferenceConstants.COLOR_HEADER_MODIFIER, new RGB(0, 0, 155), SWT.NONE);
        saveDefaultTokenStyle(store, PreferenceConstants.COLOR_ATTRIBUTE_MODIFIER, new RGB(0, 0, 155), SWT.NONE);
        saveDefaultTokenStyle(store, PreferenceConstants.COLOR_STRING, new RGB(42, 0, 255), SWT.NONE);
        saveDefaultTokenStyle(store, PreferenceConstants.COLOR_BRACKETS, new RGB(0, 0, 0), SWT.NONE);
        saveDefaultTokenStyle(store, PreferenceConstants.COLOR_OTHERS, new RGB(0, 0, 0), SWT.NONE);
        saveDefaultTokenStyle(store, PreferenceConstants.COLOR_BEANSHELL, new RGB(0, 0, 0), SWT.NONE);
        saveDefaultTokenStyle(store, PreferenceConstants.COLOR_DOCUMENTID, new RGB(0, 0, 0), SWT.NONE);
        // store.setDefault(EDITOR_WHITESPACE_CHARACTER_ALPHA_VALUE, 80);
    }

    private void saveDefaultTokenStyle(final IPreferenceStore store, String name, RGB color, int styles) {
        PreferenceConverter.setDefault(store, name, color);
        store.setDefault(name + PreferenceConstants.IMPEX_EDITOR_STYLE_SUFFIX, styles);
    }
}
