package com.kizoom.plugin.wildebeest.ear.actions;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.team.core.TeamException;
import org.eclipse.team.internal.ccvs.core.CVSTeamProvider;
import org.eclipse.team.internal.ccvs.core.ICVSRepositoryLocation;
import org.eclipse.team.internal.ccvs.core.Policy;
import org.eclipse.team.internal.ccvs.core.resources.CVSWorkspaceRoot;
import org.eclipse.team.internal.ccvs.ui.CVSUIMessages;

import com.kizoom.plugin.KizoomPlugin;
import com.kizoom.plugin.wildebeest.team.CVSUtils;
import com.kizoom.plugin.wildebeest.team.RepositorySelectionDialog;

@SuppressWarnings("restriction")
public class ChangeSharingAction extends BaseCVSAction {

	public static final String ID = "com.kizoom.plugin.utils.team.changeSharing";

	public void run(IAction action) {
		if (getSelection() instanceof IStructuredSelection) {
			Map<CVSTeamProvider, ICVSRepositoryLocation> oldLocations = new HashMap<CVSTeamProvider, ICVSRepositoryLocation>();
			for (Iterator<?> it = ((IStructuredSelection) getSelection()).iterator(); it.hasNext();) {
				Object next = it.next();
				CVSTeamProvider provider = getProjectProvider(next);
				if (provider == null)
					continue;
				CVSWorkspaceRoot cvsRoot = provider.getCVSWorkspaceRoot();
				try {
					ICVSRepositoryLocation loc = cvsRoot.getRemoteLocation();

					oldLocations.put(provider, loc);
					// fetch = provider.getFetchAbsentDirectories();
					// watchEdit = provider.isWatchEditEnabled();
				} catch (TeamException e) {
					KizoomPlugin.logError(e);
				}
			}

			if (oldLocations.isEmpty()) {
				MessageDialog.openInformation(getShell(), "Change project sharing",
						"No CVS locations have been found for selected projects.");
				return;
			}

			HashSet<ICVSRepositoryLocation> oldLocationValues = new HashSet<ICVSRepositoryLocation>(oldLocations.values());
			RepositorySelectionDialog dialog = new RepositorySelectionDialog(getShell(), oldLocationValues);
			dialog.open();
			if (dialog.getReturnCode() == Dialog.CANCEL)
				return;

			final ICVSRepositoryLocation location = dialog.getLocation();
			if (location == null) {
				MessageDialog.openInformation(getShell(), "Change project sharing", "No CVS location has been specified.");
				return;
			}

			if (checkIncompatible(location, oldLocationValues)) {
				if (!MessageDialog.openQuestion(getShell(), CVSUIMessages.CVSProjectPropertiesPage_32,
						CVSUIMessages.CVSProjectPropertiesPage_33)) { // 
					return;
				}
			}
			for (final CVSTeamProvider provider : oldLocations.keySet()) {
				try {
					new ProgressMonitorDialog(getShell()).run(true, true, new IRunnableWithProgress() {
						public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
							try {
								monitor.beginTask(CVSUIMessages.CVSProjectPropertiesPage_progressTaskName, ((location == null) ? 0
										: 100));
								provider.setRemoteRoot(location, Policy.subMonitorFor(monitor, 100));
							} catch (TeamException e) {
								throw new InvocationTargetException(e);
							}
						}
					});
				} catch (InvocationTargetException e) {
					KizoomPlugin.logError(e);
				} catch (InterruptedException e) {
					KizoomPlugin.logError(e);
				}
			}
		}
	}

	private boolean checkIncompatible(ICVSRepositoryLocation repositoryLocation, Set<ICVSRepositoryLocation> oldLocations) {
		for (ICVSRepositoryLocation location : oldLocations) {
			if (!CVSUtils.isCompatible(repositoryLocation, location))
				return true;
		}
		return false;
	}

}
