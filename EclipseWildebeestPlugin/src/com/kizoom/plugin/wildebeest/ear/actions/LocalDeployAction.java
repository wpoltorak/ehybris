package com.kizoom.plugin.wildebeest.ear.actions;

import java.io.File;
import java.net.URL;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.JavaCore;

import com.kizoom.plugin.KizoomPlugin;
import com.kizoom.plugin.wildebeest.WildebeestPlugin;

public class LocalDeployAction extends JobSchedulingWildebeestAction {

	private MBeanServerConnector connector = new MBeanServerConnector();
	
	@Override
	protected String description() {
		return "Deploying to local JBoss server...";
	}

	@Override
	protected void doExecute(ExecutionEvent event) throws Exception,
			CoreException {
		
		JavaCore.run(new IWorkspaceRunnable(){
			public void run(IProgressMonitor monitor) throws CoreException {
				try {
					File buildFolder = getJBossBuildFolder().getLocation().toFile();
					addURL(buildFolder.toURL());
				} catch (Exception e) {
					throw new CoreException(new Status(IStatus.ERROR, WildebeestPlugin.PLUGIN_ID, e.getMessage()));
				}
			}
		}, new NullProgressMonitor());
	}

	void addURL(URL url) throws Exception {
		KizoomPlugin.logInfo("Deploying " + url.toExternalForm()
				+ " to local JBoss server", null);
		MBeanServerConnection server = connector.getConnection();
		ObjectName deploymentScannerName = new ObjectName(
				"jboss.deployment:type=DeploymentScanner,flavor=URL");
		server.invoke(deploymentScannerName, "addURL", new Object[] { url },
				new String[] { "java.net.URL" });
		KizoomPlugin.logInfo("deployment scanner directories: "
				+ server.getAttribute(new ObjectName(
						"jboss.deployment:type=DeploymentScanner,flavor=URL"),
						"URLList"), null);
	}

	@Override
	public boolean isEnabled() {
		return super.isEnabled() && getJBossBuildFolder().exists() && getPlugin().getJBossPathVariable() != null;
	}
}
