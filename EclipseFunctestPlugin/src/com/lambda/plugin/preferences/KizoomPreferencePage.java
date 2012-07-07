package com.lambda.plugin.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.lambda.plugin.YPlugin;

public class KizoomPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

    @Override
    public String getDescription() {
        return "Expand the tree to edit preferences for a specific feature.";
    }

    @Override
    protected Control createContents(final Composite parent) {
        return new Composite(parent, SWT.NULL);
    }

    @Override
    protected IPreferenceStore doGetPreferenceStore() {
        return YPlugin.getDefault().getPreferenceStore();
    }

    public void init(final IWorkbench workbench) {
    }

}