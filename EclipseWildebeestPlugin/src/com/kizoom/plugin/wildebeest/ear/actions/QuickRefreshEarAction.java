package com.kizoom.plugin.wildebeest.ear.actions;

import org.apache.tools.ant.taskdefs.Touch;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IFile;

public class QuickRefreshEarAction extends JobSchedulingWildebeestAction {

	@Override
	protected String description() {
		return "Quick refreshing ear...";
	}

	@Override
	protected void doExecute(ExecutionEvent event) throws Exception {
		// file.touch(new NullProgressMonitor());
		Touch touch = new Touch();
		touch.setFile(getApplicationXmlFile().getLocation().toFile());
		touch.execute();
	}

	private IFile getApplicationXmlFile() {
		return getEarBuildFolder().getFile("/META-INF/application.xml");
	}

	@Override
	public boolean isEnabled() {
		return super.isEnabled() && getApplicationXmlFile().exists();
	}
}
