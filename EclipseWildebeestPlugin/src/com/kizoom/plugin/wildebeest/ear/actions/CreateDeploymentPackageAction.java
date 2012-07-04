package com.kizoom.plugin.wildebeest.ear.actions;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.preference.IPreferenceStore;

import com.kizoom.plugin.wildebeest.WildebeestPlugin;
import com.kizoom.plugin.wildebeest.preferences.PreferenceConstants;

public class CreateDeploymentPackageAction extends JobSchedulingWildebeestAction {

	public static final String ID = "com.kizoom.plugin.wildebeest.CreateDeploymentPackage";
	
	@Override
	protected String description() {
		return "Creating deployment package...";
	}
	
	@Override
	protected void doExecute(ExecutionEvent event) throws ExecutionException {
		IPreferenceStore preferenceStore = WildebeestPlugin.getDefault().getPreferenceStore();
		
		String dir = preferenceStore.getString(PreferenceConstants.P_DEPLOYMENT_DIST_DIR);
		
		
		
		//KizoomPlugin.logInfo(message, e)(status)
		
//		<target name="init-deployment-package">
//	    <property file="${ear.dir}/classpath/application-version.properties"/>
//	    <echo>Build number is ${build.version} - Database version is ${database.version}</echo>
//
//	    <mkdir dir="${deployment.dist.dir}"/>
//	    <property name="deployment.package.dir" value="${deployment.dist.dir}/${build.version}"/>
//	  </target>
//
//	  <target name="init-deployment-classpath" depends="compile-buildscripts">
//	    <path id="deployment-classpath">
//	      <pathelement location="${wildebeest.ear.template.dir}/build/classes"/>
//	      <pathelement location="${jboss.home}/client/jbossall-client.jar"/>
//	    </path>
//	  </target>
		
//		<target name="create-deployment-package" depends="clean, create-exploded-ear, init-deployment-package, generate-apache-config">
//	    <echo>Assembling deployment package ${build.version}</echo>
//	    <delete dir="${deployment.dist.dir}"/>
//	    <mkdir dir="${deployment.package.dir}" />
//	    
//	    <echo>Assembling exploded EAR</echo>
//	    <mkdir dir="${deployment.package.dir}/${ear.prefix}.ear"/>
//	    <copy todir="${deployment.package.dir}/${ear.prefix}.ear">
//	      <fileset dir="build/jboss/${ear.prefix}.ear" />
//	    </copy>
//	  	
//		<!-- Determine if we have a custom modjk worker name -->
//	    <antcontrib:if>
//	      <isset property="wildebeest.target.server" />
//	      <then>
//	      	<property name="apache.modjk.worker.name" value="${wildebeest.target.server}"/>
//	      	<property name="deployment.staging.deploymentTarget" value="${wildebeest.target.server}-s1"/>
//	      	<property name="deployment.production.deploymentTarget" value="${wildebeest.target.server}-p1"/>
//	      </then>
//	      <else>
//	      	<property name="apache.modjk.worker.name" value="${apache.modjk.default.worker.name}"/>
//	      	<property name="deployment.staging.deploymentTarget" value="${deployment.staging.default.deploymentTarget}"/>
//	      	<property name="deployment.production.deploymentTarget" value="${deployment.production.default.deploymentTarget}"/>
//	      </else>
//	    </antcontrib:if>
//
//	    <echo>Assembling Apache config</echo>
//	    <copy todir="${deployment.package.dir}/apache">
//	      <fileset dir="build/apache"/>
//	      <filterset>
//	        <filter token="worker.name" value="${apache.modjk.worker.name}"/>
//	      </filterset>
//	    </copy>
//
//	    <echo>Assembling shell scripts</echo>
//	    <copy todir="${deployment.package.dir}/bin">
//	      <fileset dir="${deploy.scripts.dir}"/>
//	      <filterset>
//	        <filter token="deployment.package.name" value="${build.version}"/>
//	        <filter token="database.version" value="${database.version}"/>
//	        <filter token="staging.deployment.target" value="${deployment.staging.deploymentTarget}"/>
//	        <filter token="production.deployment.target" value="${deployment.production.deploymentTarget}"/>
//	     	<filter token="database.version.check" value="${database.version.check}"/>
//	     	<filter token="oracle.user" value="${oracle.user}"/>
//	      </filterset>
//	      <filterset refid="ear.filters"/>
//	    </copy>
//	    
//	    <echo>Collecting necessary libraries from ivy</echo>
//	    <ivy:resolve file="${wildebeest.ear.template.dir}/ivy.xml" conf="deployscripts" />
//	    <ivy:retrieve conf="deployscripts" pattern="${deployment.package.dir}/bin/lib/[artifact]-[revision].[ext]" />
//	    
//	    <!-- Build a JAR file containing the com.kizoom.wildebeest.deploy classes -->
//	    <jar destfile="${deployment.package.dir}/bin/lib/wildebeest-deploy.jar"
//	    	 basedir="${wildebeest.ear.template.dir}/build/classes"
//	    	 includes="com/kizoom/wildebeest/deploy/**/*"
//	    />
//	    
//	    <fixcrlf srcdir="${deployment.package.dir}" eol="lf" eof="remove" includes="**/*.sh"/>
//
//	    <delete dir="build/dist/tmp" />
//	    
//	    <echo>Finished assembling deployment package ${build.version}</echo>
//	  </target>		
		
	}

}
