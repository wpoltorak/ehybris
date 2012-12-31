package com.lambda.plugin.preferences;

import java.util.List;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.lambda.plugin.YPlugin;

/**
 * Class used to initialize default preference values.
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
        // store.setDefault(PreferenceConstants.P_BOOLEAN, true);
        // store.setDefault(PreferenceConstants.P_CHOICE, "choice2");
        // store.setDefault(PreferenceConstants.P_STRING, "Default value");
        initializeYUnitPreferences(store);
    }

    private void initializeYUnitPreferences(IPreferenceStore store) {
        List<String> active = PreferenceConstants.createDefaultStackFiltersList();
        String pref = PreferenceConstants.serializeList(active.toArray(new String[active.size()]));
        store.setValue(PreferenceConstants.YUNIT_PREF_ACTIVE_STACK_FILTERS_LIST, pref);
    }
}
