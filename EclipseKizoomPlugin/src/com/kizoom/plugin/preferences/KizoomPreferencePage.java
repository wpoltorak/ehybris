package com.kizoom.plugin.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.kizoom.plugin.KizoomPlugin;

public class KizoomPreferencePage extends PreferencePage
	implements IWorkbenchPreferencePage {

	@Override
	public String getDescription() {
		return "Expand the tree to edit preferences for a specific feature.";
	}
	
    protected Control createContents(Composite parent) {
        return new Composite(parent, SWT.NULL);
    }

    protected IPreferenceStore doGetPreferenceStore() {
        return KizoomPlugin.getDefault().getPreferenceStore();
    }

    public void init(IWorkbench workbench) {
    }

}