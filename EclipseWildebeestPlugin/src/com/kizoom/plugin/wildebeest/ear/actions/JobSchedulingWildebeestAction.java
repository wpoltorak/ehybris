package com.kizoom.plugin.wildebeest.ear.actions;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.jface.dialogs.MessageDialog;

import com.kizoom.plugin.KizoomPlugin;
import com.kizoom.plugin.wildebeest.WildebeestPlugin;

public abstract class JobSchedulingWildebeestAction extends BaseWildebeestAction {

	public final Object execute(final ExecutionEvent event) throws ExecutionException {
		Job job = new Job(description()) {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					doExecute(event);
					return Status.OK_STATUS; 
				} catch (Exception exc) {
					KizoomPlugin.logError(exc);
					return new Status(IStatus.ERROR, WildebeestPlugin.PLUGIN_ID, exc.getMessage());
				}
			}
		};
		job.addJobChangeListener(new JobChangeAdapter() {
			@Override
			public void done(IJobChangeEvent event) {
				if (!event.getResult().isOK())
					MessageDialog.openError(getShell(),
							"CVS project references",
							"Error occured. See log for details");
			}
		});
		
		job.setPriority(priority());
		job.setUser(user());
		job.schedule(); // start as soon as possible
		return null;
	}

	protected boolean user(){
		return true;
	}
	
	protected int priority(){
		return Job.LONG;
	}
	
	protected abstract String description();
}
