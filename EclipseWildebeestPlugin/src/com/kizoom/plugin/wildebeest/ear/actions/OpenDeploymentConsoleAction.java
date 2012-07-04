package com.kizoom.plugin.wildebeest.ear.actions;

import java.io.File;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.ExecTask;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.preference.IPreferenceStore;

import com.kizoom.plugin.wildebeest.WildebeestPlugin;
import com.kizoom.plugin.wildebeest.preferences.PreferenceConstants;

public class OpenDeploymentConsoleAction extends JobSchedulingWildebeestAction {

	public static final String ID = "com.kizoom.plugin.wildebeest.OpenDeploymentConsole";

	@Override
	protected String description() {
		return "Opening deployment console...";
	}

	@Override
	protected int priority() {
		return Job.SHORT;
	}
	
	@Override
	protected void doExecute(ExecutionEvent event) throws ExecutionException {
		IPreferenceStore preferenceStore = WildebeestPlugin.getDefault().getPreferenceStore();
		String deploymentLocation = preferenceStore.getString(PreferenceConstants.P_DEPLOYMENT_LOCATION);
		String puttyExeLocation = preferenceStore.getString(PreferenceConstants.P_PUTTY_EXE_LOCATION);
		String cmdLineArgs = preferenceStore.getString(PreferenceConstants.P_PUTTY_CMD_LINE_ARGS);

		if (deploymentLocation == null || puttyExeLocation == null
				|| cmdLineArgs == null) {
			showErrorDialog(
					"Wildebeest error",
					"Cannot open deployment console.\n Setup wildebeest preferences in Window -> Preferences -> Kizoom -> Wildebeest first.",
					null);
			return;
		}

		IProject prj = getActiveEarProject();

		if (prj == null) {
			showErrorDialog("Wildebeest error",
					"No active ear project in workspace.", null);
			return;
		}
		File baseDir = prj.getLocation().toFile();
		
		ExecTask task = new ExecTask();
		
		Project project = new Project();
		project.setBaseDir(baseDir);
		
		task.setProject(project);
		task.setDir(baseDir);
		task.setSpawn(true);
		
		task.setExecutable(puttyExeLocation);
		task.createArg().setLine(cmdLineArgs);
		task.createArg().setValue(deploymentLocation);

		task.execute();
		

	}
}
