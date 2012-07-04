package com.kizoom.plugin.wildebeest.ear.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import com.kizoom.plugin.KizoomPlugin;
import com.kizoom.plugin.wildebeest.WildebeestPlugin;
import com.kizoom.plugin.wildebeest.ear.IEar;

public abstract class BaseWildebeestAction extends AbstractHandler {

	private final static String BUILD_LOCATION = "build";
	private final static String JBOSS_BUILD_LOCATION = BUILD_LOCATION + "/jboss";
	private final static String ECLIPSE_BUILD_LOCATION = BUILD_LOCATION + "/eclipse";
	private static final String APACHE_BUILD_LOCATION = BUILD_LOCATION + "/apache";
	
	protected abstract void doExecute(ExecutionEvent event) throws Exception;

	protected Shell getShell() {
		return KizoomPlugin.getActiveWorkbenchShell();
	}

	protected void showErrorDialog(String title, String msg, Throwable t) {
		MessageDialog.openError(getShell(), title, msg);
		KizoomPlugin.logWarning(msg, t);
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			doExecute(event);
		} catch (Exception exc) {
			KizoomPlugin.logError(exc);
			showErrorDialog("Wildebeest error", "Error occured during executing wildebeest action. See log for more details.",
					exc);
		}
		return null;
	}

	protected String description() {
		return "executing wildebeest action";
	}

	@Override
	public boolean isEnabled() {
		return getActiveEar() != null;
	}
	
	protected WildebeestPlugin getPlugin(){
		return WildebeestPlugin.getDefault();
	}
	
	protected IProject getActiveEarProject() {
		IEar activeEar = getActiveEar();
		return activeEar == null ? null : activeEar.getProject();
	}

	protected IEar getActiveEar() {
		return WildebeestPlugin.getDefault().getEarManager()
				.getActiveEar();
	}

	protected IFolder getBuildFolder() {
		return getActiveEarProject().getFolder(BUILD_LOCATION);
	}

	protected IFolder getApacheBuildFolder() {
		return getActiveEarProject().getFolder(APACHE_BUILD_LOCATION);
	}
	
	protected IFolder getApacheBuildFolder(boolean create) throws CoreException {
		IFolder folder = getApacheBuildFolder();
		if (!create) {
			return folder;
		}
		
		return createBuildSubFolder(folder);
	}

	protected IFolder getJBossBuildFolder() {
		return getActiveEarProject().getFolder(JBOSS_BUILD_LOCATION);
	}
	
	protected IFolder getJBossBuildFolder(boolean create) throws CoreException {
		IFolder folder = getJBossBuildFolder();
		if (!create){
			return folder;
		}
		return createBuildSubFolder(folder); 
	}

	private IFolder getEclipseBuildFolder() {
		return getActiveEarProject().getFolder(ECLIPSE_BUILD_LOCATION);
	}

	protected IFolder getEclipseBuildFolder(boolean create) throws CoreException {
		IFolder folder = getEclipseBuildFolder();
		if (!create){
			return folder;
		}

		return createBuildSubFolder(folder);
	}

	private IFolder createBuildSubFolder(IFolder folder) throws CoreException {
		if (folder.exists()){
			folder.delete(true, new NullProgressMonitor());
		}
		
		IFolder buildFolder = getBuildFolder();
		if (!buildFolder.exists()){
			buildFolder.create(true, true, new NullProgressMonitor());
		}
		
		folder.create(true, true, new NullProgressMonitor());
		
		return folder;
	}

	protected IFolder getEarBuildFolder() {
		return getJBossBuildFolder().getFolder(getActiveEar().getPrefix() + ".ear");
	}
}
