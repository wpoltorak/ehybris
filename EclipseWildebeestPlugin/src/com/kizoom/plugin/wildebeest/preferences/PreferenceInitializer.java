package com.kizoom.plugin.wildebeest.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.kizoom.plugin.wildebeest.WildebeestPlugin;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = WildebeestPlugin.getDefault().getPreferenceStore();
		store.setDefault(PreferenceConstants.P_MARK_PROJECTS_LISTED_IN_EAR, true);
		store.setDefault(PreferenceConstants.P_CVS_EAR_TEMPLATE_PROJECT, "TestEAR");
		store.setDefault(PreferenceConstants.P_PUTTY_EXE_LOCATION, "D:/apps/putty/PUTTY.EXE");
		store.setDefault(PreferenceConstants.P_PUTTY_CMD_LINE_ARGS, "-ssh -2 -A -L 873:localhost:873");
		store.setDefault(PreferenceConstants.P_DEPLOYMENT_LOCATION, "ops@punda");
		store.setDefault(PreferenceConstants.P_DISABLE_VHOST_GENERATION, false);
		store.setDefault(PreferenceConstants.P_DEPLOYMENT_DIST_DIR, "D:/temp/dist");
		store.setDefault(PreferenceConstants.P_SHOW_UNREFERENCED_EAR_PROJECT, false);
		store.setDefault(PreferenceConstants.P_SHOW_UNREFERENCED_WEBAPP_PROJECTS, false);
		store.setDefault(PreferenceConstants.P_USE_ALL_EARS_PSF_FILE, true);
	}

}
