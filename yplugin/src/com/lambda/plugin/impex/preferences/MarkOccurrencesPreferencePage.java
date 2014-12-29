package com.lambda.plugin.impex.preferences;

import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
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
import com.lambda.plugin.YPlugin;

public class MarkOccurrencesPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

    private final String[][] occurrences = new String[][] {
            { YMessages.ImpexEditorPreferencePage_markOccurrences_types,
                    PreferenceConstants.IMPEX_EDITOR_MARK_TYPE_OCCURRENCES },
            { YMessages.ImpexEditorPreferencePage_markOccurrences_macros,
                    PreferenceConstants.IMPEX_EDITOR_MARK_MACRO_OCCURRENCES },
            { YMessages.ImpexEditorPreferencePage_markOccurrences_documentIDQualifiers,
                    PreferenceConstants.IMPEX_EDITOR_MARK_DOCID_QUALIFIER_OCCURRENCES }, };

    private IPreferenceStore store;

    public MarkOccurrencesPreferencePage() {
        super();
        initPreferenceStore();
    }

    private void initPreferenceStore() {
        store = new PreferenceStore();
        IPreferenceStore target = YPlugin.getDefault().getPreferenceStore();
        new PreferenceInitializer().initializeDefaultMarkOccurrencesPreferences(store);

        store.setValue(PreferenceConstants.IMPEX_EDITOR_MARK_OCCURRENCES,
                target.getBoolean(PreferenceConstants.IMPEX_EDITOR_MARK_OCCURRENCES));
        for (String[] occurrence : occurrences) {
            store.setValue(occurrence[1], target.getBoolean(occurrence[1]));
        }

        store.setValue(PreferenceConstants.IMPEX_EDITOR_STICKY_OCCURRENCES,
                target.getBoolean(PreferenceConstants.IMPEX_EDITOR_STICKY_OCCURRENCES));
        setPreferenceStore(target);
    }

    @Override
    protected Control createContents(final Composite parent) {
        createComponents(parent);
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

        Button master = addCheckBox(composite, YMessages.ImpexEditorPreferencePage_markOccurrences,
                PreferenceConstants.IMPEX_EDITOR_MARK_OCCURRENCES, true, 0);

        addFiller(composite);

        for (int i = 0; i < occurrences.length; i++) {
            addCheckBox(composite, occurrences[i][0], occurrences[i][1], master);
        }

        addFiller(composite);

        addCheckBox(composite, YMessages.ImpexEditorPreferencePage_markOccurrences_stickyOccurrences,
                PreferenceConstants.IMPEX_EDITOR_STICKY_OCCURRENCES, master);
    }

    private void addFiller(Composite composite) {
        PixelConverter pixelConverter = new PixelConverter(composite);

        Label filler = new Label(composite, SWT.LEFT);
        GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
        gd.horizontalSpan = 2;
        gd.heightHint = pixelConverter.convertHeightInCharsToPixels(1) / 2;
        filler.setLayoutData(gd);
    }

    private void addCheckBox(final Composite composite, final String label, final String key, final Button master) {
        final Button checkBox = addCheckBox(composite, label, key, master.getSelection(), 25);
        master.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                checkBox.setEnabled(master.getSelection());
            }
        });
    }

    private Button addCheckBox(final Composite parent, final String label, final String key, final boolean enabled,
            final int indentation) {
        final Button check = new Button(parent, SWT.CHECK);
        check.setText(label);

        GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_BEGINNING);
        gd.horizontalIndent = indentation;
        gd.horizontalSpan = 2;
        check.setLayoutData(gd);
        check.setEnabled(enabled);
        check.setSelection(store.getBoolean(key));
        check.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                store.setValue(key, check.getSelection());
            }
        });

        final IPropertyChangeListener listener = new IPropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent event) {
                if (key.equals(event.getProperty())) {
                    check.setSelection(Boolean.valueOf(event.getNewValue().toString()));
                }
                String markOccurrencesKey = PreferenceConstants.IMPEX_EDITOR_MARK_OCCURRENCES;
                if (!key.equals(markOccurrencesKey) && markOccurrencesKey.equals(event.getProperty())) {
                    check.setEnabled(Boolean.valueOf(event.getNewValue().toString()));
                }
            }
        };
        store.addPropertyChangeListener(listener);
        check.addDisposeListener(new DisposeListener() {
            @Override
            public void widgetDisposed(DisposeEvent e) {
                store.removePropertyChangeListener(listener);
            }
        });

        return check;
    }

    @Override
    public void init(final IWorkbench workbench) {
    }

    @Override
    public boolean performOk() {
        IPreferenceStore target = getPreferenceStore();

        target.setValue(PreferenceConstants.IMPEX_EDITOR_MARK_OCCURRENCES,
                store.getBoolean(PreferenceConstants.IMPEX_EDITOR_MARK_OCCURRENCES));

        for (String[] occurrence : occurrences) {
            target.setValue(occurrence[1], store.getBoolean(occurrence[1]));
        }

        target.setValue(PreferenceConstants.IMPEX_EDITOR_STICKY_OCCURRENCES,
                store.getBoolean(PreferenceConstants.IMPEX_EDITOR_STICKY_OCCURRENCES));
        return super.performOk();
    }

    @Override
    protected void performDefaults() {
        store.setToDefault(PreferenceConstants.IMPEX_EDITOR_MARK_OCCURRENCES);

        for (String[] occurrence : occurrences) {
            store.setToDefault(occurrence[1]);
        }

        store.setToDefault(PreferenceConstants.IMPEX_EDITOR_STICKY_OCCURRENCES);
        super.performDefaults();
    }

}