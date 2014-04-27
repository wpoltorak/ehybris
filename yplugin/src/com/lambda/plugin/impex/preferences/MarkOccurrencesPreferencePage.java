package com.lambda.plugin.impex.preferences;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class MarkOccurrencesPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

    @Override
    protected Control createContents(final Composite parent) {
        createComponents(parent);
        initialize();
        applyDialogFont(parent);
        return parent;
    }

    private void createComponents(final Composite parent) {

    }

    private void initialize() {
    }

    @Override
    public void init(final IWorkbench workbench) {
    }

}