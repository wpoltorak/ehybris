package com.lambda.plugin.impex.preferences;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
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

    private final String[] problems = new String[] { PreferenceConstants.PROBLEM_MACRO_EMPTY };

    private final String[] errorWarningIgnoreLabels = new String[] { YMessages.ImpexEditorPreferencePage_error,
            YMessages.ImpexEditorPreferencePage_warning, YMessages.ImpexEditorPreferencePage_ignore };
    private final List<String> errorWarningIgnore = new ArrayList<String>();
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
        // PreferenceStore store = new PreferenceStore();
        // IPreferenceStore target = YPlugin.getDefault().getPreferenceStore();
        // new PreferenceInitializer().initializeDefaultProblemsPreferences(store);
        // for (String key : problems) {
        // store.setValue(key, target.getString(key));
        // }
        //
        setPreferenceStore(YPlugin.getDefault().getPreferenceStore());
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

        addComboBox(baseComposite, YMessages.ImpexEditorPreferencePage_problem_emptyMacro,
                PreferenceConstants.PROBLEM_MACRO_EMPTY);
    }

    private void initialize() {
    }

    @Override
    public void init(final IWorkbench workbench) {
    }

    // private void initializeWorkingValues() {
    // fWorkingValues = new HashMap(fProblemPreferenceKeys.length);
    // for (int i = 0; i < fProblemPreferenceKeys.length; i++) {
    // String key = fProblemPreferenceKeys[i];
    // fWorkingValues.put(key, getPreferenceStore().getString(key));
    // }
    // }
    //
    // private void restoreWorkingValuesToDefaults() {
    // fWorkingValues = new HashMap(fProblemPreferenceKeys.length);
    // for (int i = 0; i < fProblemPreferenceKeys.length; i++) {
    // String key = fProblemPreferenceKeys[i];
    // fWorkingValues.put(key, getPreferenceStore().getDefaultString(key));
    // }
    // updateControls();
    // }

    protected Combo addComboBox(Composite parent, String label, String key) {
        SimpleEntry<String, List<String>> data = new SimpleEntry<String, List<String>>(key, errorWarningIgnore);
        Label labelControl = new Label(parent, SWT.LEFT);
        labelControl.setText(label);
        labelControl.setLayoutData(new GridData());

        final Combo comboBox = new Combo(parent, SWT.READ_ONLY);
        comboBox.setItems(errorWarningIgnoreLabels);
        comboBox.setData(errorWarningIgnore);
        comboBox.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, true, false, 1, 1));

        Label placeHolder = new Label(parent, SWT.NONE);
        placeHolder.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
        getPreferenceStore().getString(key);
        comboBox.select(errorWarningIgnore.indexOf(getPreferenceStore().getString(key)));

        return comboBox;
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        super.dispose();
    }
}