package com.kizoom.plugin.wildebeest.ear.actions;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

public class RsyncToDeploymentServerAction extends JobSchedulingWildebeestAction {

	public static final String ID = "com.kizoom.plugin.wildebeest.RsyncToDeploymentServer";
	
	@Override
	protected String description() {
		return "Synchronizing with deployment server...";
	}

	@Override
	protected void doExecute(ExecutionEvent event) throws ExecutionException {
//		<target name="rsync-to-deployment-server" depends="init-deployment-package" description="I upload a deployment package to the deployment server">
//
//	    <echo>Rsyncing deployment package ${build.version} to deployment server</echo>
//	    <exec executable="${rsync.exe}" dir="${deployment.package.dir}" failonerror="true">
//	      <arg line="-avz --delete"/>
//	      <arg value="./" />
//	      <arg value="localhost::wildebeestDeployments/${ear.prefix}-latest" />
//	    </exec>
//
//	    <antcall target="execute-on-deployment-server">
//	      <param name="command" value="chmod -R a+rx ~/wildebeestDeployments/${ear.prefix}-latest/*"/>
//	    </antcall>
//
//	    <antcall target="execute-on-deployment-server">
//	      <param name="command" value="~/wildebeestDeployments/${ear.prefix}-latest/bin/copy-delete-link.sh ${ear.prefix} ${build.version}"/>
//	    </antcall>
//	    
//	  </target>
		
//		<target name="execute-on-deployment-server">
//	    <echo>Executing on staging server: ${command}</echo>
//	    <exec executable="${ssh.exe}" failonerror="true">
//	      <arg line="-2"/>
//	      <arg value="ops@${deploy.deployment.server}"/>
//	      <arg value="${command}"/>
//	    </exec>
//	  </target>
	}
}
