package com.kizoom.plugin.wildebeest.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.StringFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.kizoom.plugin.wildebeest.WildebeestPlugin;
import com.kizoom.plugin.wildebeest.ear.IEarManager;

public class WildebeestPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage {

	public WildebeestPreferencePage() {
		super(GRID);
		setPreferenceStore(WildebeestPlugin.getDefault().getPreferenceStore());
		setDescription("Wildebeest preferences");
	}

	@Override
	public void createFieldEditors() {
		addField(new BooleanFieldEditor(
				PreferenceConstants.P_MARK_PROJECTS_LISTED_IN_EAR,
				"&Mark projects listed in Ears Project Set file",
				getFieldEditorParent()));

		addField(new StringFieldEditor(
				PreferenceConstants.P_CVS_EAR_TEMPLATE_PROJECT,
				"&Cvs Ear Template Project:", 30, getFieldEditorParent()));
		addField(new BooleanFieldEditor(
				PreferenceConstants.P_USE_ALL_EARS_PSF_FILE,
				"&Use AllEars.psf to search for CVS projects references", getFieldEditorParent()));

		addField(new StringFieldEditor(
				PreferenceConstants.P_PUTTY_EXE_LOCATION, "&Putty location:",
				30, getFieldEditorParent()));
		addField(new StringFieldEditor(
				PreferenceConstants.P_PUTTY_CMD_LINE_ARGS,
				"Putty command &line args:", 30, getFieldEditorParent()));
		addField(new StringFieldEditor(
				PreferenceConstants.P_DEPLOYMENT_LOCATION,
				"Deployment &location:", 30, getFieldEditorParent()));
		addField(new StringFieldEditor(
				PreferenceConstants.P_DEPLOYMENT_DIST_DIR,
				"&Deployment distribution directory:", 30,
				getFieldEditorParent()));

//		addField(new BooleanFieldEditor(
//				PreferenceConstants.P_DISABLE_VHOST_GENERATION,
//				"&Disable vhosts generation", getFieldEditorParent()));

		addField(new BooleanFieldEditor(
				PreferenceConstants.P_SHOW_UNREFERENCED_EAR_PROJECT,
				"&Display Ear project in unreferenced projects search results",
				getFieldEditorParent()));

		addField(new BooleanFieldEditor(
				PreferenceConstants.P_SHOW_UNREFERENCED_WEBAPP_PROJECTS,
				"&Display Webapp projects in unreferenced projects search results",
				getFieldEditorParent()));

		adjustGridLayout();
	}

	public void init(IWorkbench workbench) {

	}

	@Override
	public boolean performOk() {
		boolean result = super.performOk();
		if (result) {
			IEarManager earManager = WildebeestPlugin.getDefault()
					.getEarManager();
			earManager.updateEar(earManager.getActiveEar());
		}
		return result;
	}
}
