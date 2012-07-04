package com.kizoom.plugin.wildebeest;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.ui.viewsupport.ImageDescriptorRegistry;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

import com.kizoom.plugin.wildebeest.ear.EarManager;
import com.kizoom.plugin.wildebeest.ear.IEarManager;

/**
 * The activator class controls the plug-in life cycle
 */
@SuppressWarnings("restriction")
public class WildebeestPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "EclipseWildebeestPlugin";

	// The shared instance
	private static WildebeestPlugin plugin;
	private ImageDescriptorRegistry imageDescriptorRegistry;	
	private EarManager earManager;
	
	/**
	 * The constructor
	 */
	public WildebeestPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
//		setJBossPathVariable();
		((EarManager) getEarManager()).initialize();
		if (PlatformUI.isWorkbenchRunning()) {
			// new InitializeAfterLoadJob().schedule(); // last call in start, see bug
			// 191193
		}
	}

	public IPath getJBossPathVariable(){
		return JavaCore.getClasspathVariable("JBOSSALL_CLIENT");
	}
	
//	public void setJBossPathVariable() {
//		try {
//			IPath classpathVariable = getJBossPathVariable();
//			if (classpathVariable == null){
//				String jbossLocation = getPreferenceStore().getString(PreferenceConstants.P_JBOSS_LOCATION);
//				IPath path = Path.fromOSString(jbossLocation).append("/client/jbossall-client.jar");
//				JavaCore.setClasspathVariable("JBOSSALL_CLIENT", path, new NullProgressMonitor());
//			}
//		}catch(Exception e){
//			KizoomPlugin.logError(e);
//		}
//	}

//	public void removeJBossPathVariable() {
//		try {
//			JavaCore.removeClasspathVariable("JBOSSALL_CLIENT", new NullProgressMonitor());
//		}catch(Exception e){
//			KizoomPlugin.logError(e);
//		}
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		try {
			((EarManager) getEarManager()).dispose();
		} finally {
			super.stop(context);
		}
		plugin = null;
	}
	
	public IEarManager getEarManager() {
		if (earManager == null)
			earManager = new EarManager();
		return earManager;
	}


	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static WildebeestPlugin getDefault() {
		return plugin;
	}

	public ImageDescriptorRegistry getImageDescriptorRegistry() {
		if (imageDescriptorRegistry == null)
			imageDescriptorRegistry = new ImageDescriptorRegistry();
		return imageDescriptorRegistry;
	}
}
