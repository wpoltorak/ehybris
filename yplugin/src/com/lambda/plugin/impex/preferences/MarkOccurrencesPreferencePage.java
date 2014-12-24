package com.lambda.plugin.impex.preferences;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.texteditor.AnnotationPreference;

import com.lambda.plugin.YMessages;

public class MarkOccurrencesPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

    private final Map<Button, String> fCheckBoxes = new HashMap<Button, String>();
    private final SelectionListener fCheckBoxListener = new SelectionListener() {
        @Override
        public void widgetDefaultSelected(SelectionEvent e) {
        }

        @Override
        public void widgetSelected(SelectionEvent e) {
            Button button = (Button) e.widget;
            // fStore.setValue(fCheckBoxes.get(button), button.getSelection());
        }
    };

    @Override
    protected Control createContents(final Composite parent) {
        createComponents(parent);
        initialize();
        applyDialogFont(parent);
        return parent;
    }

    private void createComponents(final Composite parent) {

        Composite composite = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 1;
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        composite.setLayout(layout);

        Link link = new Link(composite, SWT.NONE);
        link.setText(YMessages.ImpexEditorPreferencePage_markOccurrences_link);
        link.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                String data = null;
                AnnotationPreference preference = EditorsUI.getAnnotationPreferenceLookup().getAnnotationPreference(
                        "org.eclipse.jdt.ui.occurrences"); //$NON-NLS-1$
                if (preference != null)
                    data = preference.getPreferenceLabel();
                PreferencesUtil.createPreferenceDialogOn(parent.getShell(), e.text, null, data);
            }
        });

        addFiller(composite);

        String label;

        label = YMessages.ImpexEditorPreferencePage_markOccurrences;
        Button master = addCheckBox(composite, label, PreferenceConstants.IMPEX_EDITOR_MARK_OCCURRENCES, 0);

        addFiller(composite);

        label = YMessages.ImpexEditorPreferencePage_markOccurrences_types;
        Button slave = addCheckBox(composite, label, PreferenceConstants.IMPEX_EDITOR_MARK_TABLE_OCCURRENCES, 10);

        label = YMessages.ImpexEditorPreferencePage_markOccurrences_macros;
        slave = addCheckBox(composite, label, PreferenceConstants.IMPEX_EDITOR_MARK_MACRO_OCCURRENCES, 10);

        label = YMessages.ImpexEditorPreferencePage_markOccurrences_documentIDQualifiers;
        slave = addCheckBox(composite, label, PreferenceConstants.IMPEX_EDITOR_MARK_DOCID_QUALIFIER_OCCURRENCES, 10);

        addFiller(composite);

        label = YMessages.ImpexEditorPreferencePage_markOccurrences_stickyOccurrences;
        slave = addCheckBox(composite, label, PreferenceConstants.IMPEX_EDITOR_STICKY_OCCURRENCES, 0);
    }

    private void addFiller(Composite composite) {
        PixelConverter pixelConverter = new PixelConverter(composite);

        Label filler = new Label(composite, SWT.LEFT);
        GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
        gd.horizontalSpan = 2;
        gd.heightHint = pixelConverter.convertHeightInCharsToPixels(1) / 2;
        filler.setLayoutData(gd);
    }

    private Button addCheckBox(Composite parent, String label, String key, int indentation) {
        Button checkBox = new Button(parent, SWT.CHECK);
        checkBox.setText(label);

        GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
        gd.horizontalIndent = indentation;
        gd.horizontalSpan = 2;
        checkBox.setLayoutData(gd);
        checkBox.addSelectionListener(fCheckBoxListener);

        fCheckBoxes.put(checkBox, key);

        return checkBox;
    }

    private void initialize() {
    }

    @Override
    public void init(final IWorkbench workbench) {
    }

}