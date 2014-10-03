package com.lambda.plugin.impex.preferences;

import java.util.ArrayList;
import java.util.List;

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
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.lambda.plugin.YMessages;
import com.lambda.plugin.YPlugin;

public class ProblemsPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

    private final String[][] problems = new String[][] {
            { YMessages.ImpexEditorPreferencePage_problem_emptyMacro, PreferenceConstants.PROBLEM_MACRO_EMPTY },
            { YMessages.ImpexEditorPreferencePage_problem_undefinedMacro, PreferenceConstants.PROBLEM_MACRO_UNDEFINED }, };

    private final String[] errorWarningIgnoreLabels = new String[] { YMessages.ImpexEditorPreferencePage_error,
            YMessages.ImpexEditorPreferencePage_warning, YMessages.ImpexEditorPreferencePage_ignore };
    private final List<Integer> errorWarningIgnore = new ArrayList<Integer>();

    private PreferenceStore store;

    {
        errorWarningIgnore.add(PreferenceConstants.IMPEX_ERROR);
        errorWarningIgnore.add(PreferenceConstants.IMPEX_WARNING);
        errorWarningIgnore.add(PreferenceConstants.IMPEX_IGNORE);
    }

    public ProblemsPreferencePage() {
        super();
        initPreferenceStore();
    }

    private void initPreferenceStore() {
        store = new PreferenceStore();
        IPreferenceStore target = YPlugin.getDefault().getPreferenceStore();
        new PreferenceInitializer().initializeDefaultProblemsPreferences(store);
        for (String[] problem : problems) {
            store.setValue(problem[1], target.getInt(problem[1]));
        }

        setPreferenceStore(target);
    }

    @Override
    protected Control createContents(final Composite parent) {
        createComponents(parent);
        initialize();
        applyDialogFont(parent);
        return parent;
    }

    private void createComponents(final Composite parent) {
        // fProblemLabels = new ArrayList();
        // initializeWorkingValues();

        final Composite baseComposite = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout(2, false);
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.grabExcessHorizontalSpace = true;
        gd.grabExcessVerticalSpace = true;
        baseComposite.setLayout(layout);
        baseComposite.setLayoutData(gd);

        Label label = new Label(baseComposite, SWT.NONE);
        label.setText(YMessages.ImpexEditorPreferencePage_selectLevel);
        gd = new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL);
        gd.horizontalSpan = 2;
        label.setLayoutData(gd);

        for (int i = 0; i < problems.length; i++) {
            addComboBox(baseComposite, problems[i][0], problems[i][1]);
        }
    }

    private void initialize() {
    }

    @Override
    public void init(final IWorkbench workbench) {
    }

    protected Combo addComboBox(final Composite parent, final String label, final String key) {
        Label labelControl = new Label(parent, SWT.LEFT);
        labelControl.setText(label);
        labelControl.setLayoutData(new GridData());

        final Combo comboBox = new Combo(parent, SWT.READ_ONLY);
        comboBox.setItems(errorWarningIgnoreLabels);
        comboBox.setData(errorWarningIgnore);
        comboBox.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, true, false, 1, 1));
        comboBox.select(errorWarningIgnore.indexOf(store.getInt(key)));

        Label placeHolder = new Label(parent, SWT.NONE);
        placeHolder.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
        comboBox.addSelectionListener(new SelectionAdapter() {
            @SuppressWarnings("unchecked")
            @Override
            public void widgetSelected(SelectionEvent e) {
                int value = ((List<Integer>) comboBox.getData()).get(comboBox.getSelectionIndex());
                store.setValue(key, value);
            }
        });
        final IPropertyChangeListener listener = new IPropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent event) {
                if (key.equals(event.getProperty())) {
                    int index = errorWarningIgnore.indexOf(Integer.valueOf(event.getNewValue().toString()));
                    comboBox.select(index);
                }
            }
        };
        store.addPropertyChangeListener(listener);
        comboBox.addDisposeListener(new DisposeListener() {
            @Override
            public void widgetDisposed(DisposeEvent e) {
                store.removePropertyChangeListener(listener);
            }
        });
        return comboBox;
    }

    @Override
    public boolean performOk() {
        IPreferenceStore target = getPreferenceStore();
        for (String[] problem : problems) {
            target.setValue(problem[1], store.getInt(problem[1]));
        }
        if (target.needsSaving()) {
            target.putValue(PreferenceConstants.IMPEX_PROBLEM, "changed"); //$NON-NLS-1$
            target.setToDefault(PreferenceConstants.IMPEX_PROBLEM);
        }
        return super.performOk();
    }

    @Override
    protected void performDefaults() {
        for (String[] problem : problems) {
            store.setToDefault(problem[1]);
        }
        super.performDefaults();
    }

}