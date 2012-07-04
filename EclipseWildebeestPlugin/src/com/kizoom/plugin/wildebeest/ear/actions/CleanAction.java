package com.kizoom.plugin.wildebeest.ear.actions;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;

public class CleanAction extends JobSchedulingWildebeestAction {
	
	@Override
	protected void doExecute(ExecutionEvent event) throws ExecutionException, CoreException {
		getJBossBuildFolder().delete(true, new NullProgressMonitor());
	}

	@Override
	protected int priority() {
		return Job.SHORT;
	}

	@Override
	protected String description() {
		return "Cleaning build folder...";
	}
	
	@Override
	public boolean isEnabled() {
		return super.isEnabled() && getJBossBuildFolder().exists();
	}
}

