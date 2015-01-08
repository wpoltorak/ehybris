package com.lambda.plugin.impex.preferences;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.dialogs.PreferencesUtil;

import com.lambda.plugin.YMessages;
import com.lambda.plugin.YPlugin;

public class ImpexPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

    @Override
    protected Control createContents(final Composite parent) {
        final Link link = new Link(parent, SWT.NONE);
        link.setText(YMessages.ImpexEditorPreferencePage_0);
        link.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(final SelectionEvent e) {
                if ("org.eclipse.ui.preferencePages.GeneralTextEditor".equals(e.text)) {
                    PreferencesUtil.createPreferenceDialogOn(link.getShell(), e.text, null, null);
                } else if ("org.eclipse.ui.preferencePages.ColorsAndFonts".equals(e.text)) {
                    PreferencesUtil.createPreferenceDialogOn(link.getShell(), e.text, null, "selectFont:org.eclipse.jface.textfont"); //$NON-NLS-1$
                }
            }
        });
        final String linktooltip = YMessages.ImpexEditorPreferencePage_3;
        link.setToolTipText(linktooltip);
        return parent;
    }

    @Override
    protected IPreferenceStore doGetPreferenceStore() {
        return YPlugin.getDefault().getPreferenceStore();
    }

    public void init(final IWorkbench workbench) {
        noDefaultAndApplyButton();
    }
}