package com.lambda.plugin.wizards.ecommerce;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.swt.widgets.Shell;

import com.lambda.plugin.YCore;
import com.lambda.plugin.YMessages;
import com.lambda.plugin.ui.WorkbenchRunnableAdapter;

public abstract class AbstractWizard extends Wizard {

	public AbstractWizard() {
		IDialogSettings workbenchSettings = YCore.getDefault().getDialogSettings();

		IDialogSettings wizardSettings = workbenchSettings.getSection(getSettingsSection());
		if (wizardSettings == null) {
			wizardSettings = workbenchSettings.addNewSection(getSettingsSection());
		}
		setDialogSettings(wizardSettings);
	}
    protected abstract String getSettingsSection();
	protected abstract void finishPage(IProgressMonitor monitor) throws InterruptedException, CoreException;

    public boolean doPerformFinish() {
        final IWorkspaceRunnable op = new IWorkspaceRunnable() {
            public void run(IProgressMonitor monitor) throws CoreException, OperationCanceledException {
                try {
                    finishPage(monitor);
                } catch (InterruptedException e) {
                    throw new OperationCanceledException(e.getMessage());
                }
            }
        };
        final ISchedulingRule rule = getCurrentSchedulingRule();

        try {
            IRunnableWithProgress runnable = null;
            if (rule != null) {
                runnable = new WorkbenchRunnableAdapter(op, rule, true);
            } else {
                runnable = new WorkbenchRunnableAdapter(op, getSchedulingRule());
            }

            getContainer().run(true, true, runnable);
        } catch (InvocationTargetException e) {
            handleFinishException(getShell(), e);
            return false;
        } catch (InterruptedException e) {
            return false;
        }
        return true;
    }

    private ISchedulingRule getCurrentSchedulingRule() {
        ISchedulingRule rule = null;
        Job job = Job.getJobManager().currentJob();
        if (job != null) {
            rule = job.getRule();
        }
        return rule;
    }

    /**
     * Returns the scheduling rule for creating the element.
     * 
     * @return returns the scheduling rule
     */
    protected ISchedulingRule getSchedulingRule() {
        return ResourcesPlugin.getWorkspace().getRoot(); // look all by default
    }

    protected void handleFinishException(final Shell shell, final InvocationTargetException e) {
        com.lambda.plugin.ExceptionHandler.handle(e, getShell(), getWindowTitle(), YMessages.AbstractWizard_errorMessage);
    }
}
