package com.lambda.plugin.yunit.launcher;

import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.EnvironmentTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.debug.ui.sourcelookup.SourceLookupTab;
import org.eclipse.jdt.debug.ui.launchConfigurations.JavaArgumentsTab;
import org.eclipse.jdt.debug.ui.launchConfigurations.JavaClasspathTab;
import org.eclipse.jdt.debug.ui.launchConfigurations.JavaJRETab;

public class FunctestLaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup {

	
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		ILaunchConfigurationTab[] tabs= new ILaunchConfigurationTab[] {
				new FunctestLaunchConfigurationTab(),
				new JavaArgumentsTab(),
				new JavaClasspathTab(),
				new JavaJRETab(),
				new SourceLookupTab(),
				new EnvironmentTab(),
				new CommonTab()
			};
			setTabs(tabs);
	}

	public void setDefaults(ILaunchConfigurationWorkingCopy config) {
		super.setDefaults(config); 
	}
}
