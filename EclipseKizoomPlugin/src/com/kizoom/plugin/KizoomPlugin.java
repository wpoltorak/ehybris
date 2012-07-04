package com.kizoom.plugin;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.internal.ui.viewsupport.ImageDescriptorRegistry;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.packageadmin.PackageAdmin;

import com.kizoom.plugin.template.ITemplateManager;
import com.kizoom.plugin.template.TemplateManager;

/**
 * The activator class controls the plug-in life cycle
 */
@SuppressWarnings("restriction")
public class KizoomPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.kizoom.plugin";

	public static final String LOGGER_NAME = "kizoom";

	// The shared instance
	private static KizoomPlugin plugin;

	private ImageDescriptorRegistry imageDescriptorRegistry;

	private TemplateManager templateManager;

	private BundleContext fBundleContext;

	/**
	 * The constructor
	 */
	public KizoomPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		fBundleContext = context;
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		super.stop(context);
		fBundleContext = null;
		plugin = null;
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static KizoomPlugin getDefault() {
		return plugin;
	}

	public static IWorkbenchPage getActivePage() {
		return getDefault().internalGetActivePage();
	}

	private IWorkbenchPage internalGetActivePage() {
		IWorkbenchWindow window = getWorkbench().getActiveWorkbenchWindow();
		if (window == null)
			return null;
		return window.getActivePage();
	}

	public static void log(IStatus status) {
		getDefault().getLog().log(status);
	}

	public static void logError(String message, Throwable e) {
		log(new Status(IStatus.ERROR, PLUGIN_ID, message, e));
	}

	public static void logWarning(String message, Throwable e) {
		log(new Status(IStatus.WARNING, PLUGIN_ID, message, e));
	}

	public static void logInfo(String message, Throwable e) {
		log(new Status(IStatus.INFO, PLUGIN_ID, message, e));
	}

	public static void logError(Throwable e) {
		log(new Status(IStatus.ERROR, PLUGIN_ID, "Internal Error", e));
	}

	public static IWorkbenchWindow getActiveWorkbenchWindow() {
		return getDefault().getWorkbench().getActiveWorkbenchWindow();
	}

	public static Shell getActiveWorkbenchShell() {
		IWorkbenchWindow window = getActiveWorkbenchWindow();
		if (window != null) {
			return window.getShell();
		}
		return null;
	}

	public ImageDescriptorRegistry getImageDescriptorRegistry() {
		if (imageDescriptorRegistry == null)
			imageDescriptorRegistry = new ImageDescriptorRegistry();
		return imageDescriptorRegistry;
	}

	/**
	 * Returns an Image for the file at the given relative path.
	 */
	public static Image getImage(String path) {
		ImageRegistry registry = getDefault().getImageRegistry();
		Image image = registry.get(path);
		if (image == null) {
			registry.put(path, getImageDescriptor(path));
			image = registry.get(path);
		}
		return image;
	}

	public static ImageDescriptor getImageDescriptor(String imageFilePath) {
		ImageDescriptor imageDescriptor = imageDescriptorFromPlugin(PLUGIN_ID, imageFilePath);

		return imageDescriptor;
	}

	public ITemplateManager getTemplateManager() {
		if (templateManager == null)
			templateManager = new TemplateManager();
		return templateManager;
	}

	public Bundle getBundle(String bundleName) {
		Bundle[] bundles = getBundles(bundleName, null);
		if (bundles != null && bundles.length > 0)
			return bundles[0];
		return null;
	}

	public Bundle[] getBundles(String bundleName, String version) {
		Bundle[] bundles = Platform.getBundles(bundleName, version);
		if (bundles != null)
			return bundles;

		// Accessing unresolved bundle
		ServiceReference serviceRef = fBundleContext.getServiceReference(PackageAdmin.class.getName());
		PackageAdmin admin = (PackageAdmin) fBundleContext.getService(serviceRef);
		bundles = admin.getBundles(bundleName, version);
		if (bundles != null && bundles.length > 0)
			return bundles;
		return null;
	}

}
