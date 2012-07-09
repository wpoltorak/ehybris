package com.lambda.plugin.yunit.preferences;

import java.util.List;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;

import com.lambda.plugin.YPlugin;

public class YUnitPreferencesInitializer extends AbstractPreferenceInitializer {

	@Override
	public void initializeDefaultPreferences() {
		List<String> active = YUnitPreferencesConstants.createDefaultStackFiltersList();
		String pref = YUnitPreferencesConstants.serializeList(active.toArray(new String[active.size()]));
		YPlugin.getDefault().getPreferenceStore().setValue(YUnitPreferencesConstants.PREF_ACTIVE_STACK_FILTERS_LIST, pref);
	}
}
