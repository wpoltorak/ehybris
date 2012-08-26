package com.lambda.plugin.impex.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.lambda.plugin.YPlugin;

/**
 * Class used to initialize default preference values.
 */
public class ImpexPreferenceInitializer extends AbstractPreferenceInitializer {

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#initializeDefaultPreferences()
     */
    @Override
    public void initializeDefaultPreferences() {
        final IPreferenceStore store = YPlugin.getDefault().getPreferenceStore();
        //        store.setDefault(PreferenceConstants.P_BOOLEAN, true);
        //        store.setDefault(PreferenceConstants.P_CHOICE, "choice2");
        //        store.setDefault(PreferenceConstants.P_STRING, "Default value");

    }

}
