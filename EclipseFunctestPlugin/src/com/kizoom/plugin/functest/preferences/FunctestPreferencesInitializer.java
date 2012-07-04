package com.kizoom.plugin.functest.preferences;

import java.util.List;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;

import com.kizoom.plugin.functest.FunctestPlugin;

public class FunctestPreferencesInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		List<String> active = FunctestPreferencesConstants.createDefaultStackFiltersList();
		String pref = FunctestPreferencesConstants.serializeList(active.toArray(new String[active.size()]));
		FunctestPlugin.getDefault().getPreferenceStore().setValue(FunctestPreferencesConstants.PREF_ACTIVE_STACK_FILTERS_LIST, pref);
	}
}
