package com.kizoom.plugin.wildebeest.ear.actions;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;

import com.kizoom.plugin.wildebeest.preferences.PreferenceConstants;

public class GenerateApacheConfigAction extends JobSchedulingWildebeestAction {

	public static final String ID = "com.kizoom.plugin.wildebeest.GenerateApacheConfig";

	@Override
	protected String description() {
		return "Generating apache config...";
	}

	@Override
	protected void doExecute(ExecutionEvent event) throws ExecutionException,
			CoreException {
		IFolder folder = getApacheBuildFolder(true);
		
		boolean disableVhostsGeneration = getPlugin().getPreferenceStore().getBoolean(PreferenceConstants.P_DISABLE_VHOST_GENERATION);
		if (!disableVhostsGeneration){
			//ResourcesPlugin.get
			//<ant dir="../ServiceModel" target="auto-generate-apache-config" inheritRefs=/>
		}
	}
	
//	  <target name="generate-apache-config" depends="resolve-libraries, define-filters">
//	    <delete dir="build/apache"/>
//	    
//	    <!-- Skip auto-generation of vhost configs if disable.vhost.generation is set to true -->
//	    <antcontrib:if>
//	      <isfalse value="${disable.vhost.generation}"/>
//	      <then>
//	        <ant dir="../ServiceModel" target="auto-generate-apache-config" inheritRefs="true"/>
//	      </then>
//	    </antcontrib:if>
//
//	    <copy todir="build/apache" verbose="true" failonerror="false">
//	      <fileset dir="apache"/>
//	      <filterset refid="ear.filters"/>
//	    </copy>
//
//	  </target>

}
