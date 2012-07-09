package com.lambda.plugin;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.internal.core.JavaModel;
import org.eclipse.jdt.internal.core.JavaModelManager;
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

import com.lambda.plugin.template.ITemplateManager;
import com.lambda.plugin.template.TemplateManager;
import com.lambda.plugin.yunit.FunctestManager;
import com.lambda.plugin.yunit.FunctestModel;
import com.lambda.plugin.yunit.IFunctestManager;

/**
 * The activator class controls the plug-in life cycle
 */
public class YPlugin extends AbstractUIPlugin {

    private static final String HISTORY_DIR_NAME = "history";
    // The plug-in ID
    public static final String PLUGIN_ID = "com.lambda.yplugin";

    public static final String LOGGER_NAME = "lambda";

    private FunctestManager functestManager;

    private final FunctestModel functestModel = new FunctestModel();

    // The shared instance
    private static YPlugin plugin;

    private ImageDescriptorRegistry imageDescriptorRegistry;

    private TemplateManager templateManager;

    private BundleContext fBundleContext;

    /**
     * The constructor
     */
    public YPlugin() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext )
     */
    @Override
    public void start(final BundleContext context) throws Exception {
        super.start(context);
        plugin = this;
        ((FunctestManager) getFunctestManager()).initialize();
        functestModel.start();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext )
     */
    @Override
    public void stop(final BundleContext context) throws Exception {
        try {
            functestModel.stop();
            ((FunctestManager) getFunctestManager()).dispose();
            plugin = null;
        } finally {
            super.stop(context);
        }
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static YPlugin getDefault() {
        return plugin;
    }

    public static IWorkbenchPage getActivePage() {
        return getDefault().internalGetActivePage();
    }

    private IWorkbenchPage internalGetActivePage() {
        final IWorkbenchWindow window = getWorkbench().getActiveWorkbenchWindow();
        if (window == null) {
            return null;
        }
        return window.getActivePage();
    }

    public static FunctestModel getModel() {
        return getDefault().functestModel;
    }

    public IFunctestManager getFunctestManager() {
        if (functestManager == null) {
            functestManager = new FunctestManager();
        }
        return functestManager;
    }

    public static File getHistoryDirectory() throws IllegalStateException {
        final File historyDir = getDefault().getStateLocation().append(HISTORY_DIR_NAME).toFile();
        if (!historyDir.isDirectory()) {
            historyDir.mkdir();
        }
        return historyDir;
    }

    /**
     * 
     * @return functional test existing in workspace
     * @throws CoreException
     * @throws InvocationTargetException
     * @throws InterruptedException
     */
    public List<IJavaProject> getFunctestProjects() throws CoreException, InvocationTargetException, InterruptedException {
        final JavaModel javaModel = JavaModelManager.getJavaModelManager().getJavaModel();
        final List<IJavaProject> functestProjects = new ArrayList<IJavaProject>();
        for (final IJavaProject project : javaModel.getJavaProjects()) {
            if (project.getProject().isOpen() && project.getProject().hasNature(YNature.NATURE_ID)) {
                functestProjects.add(project);
            }
        }
        return functestProjects;
    }

    public static void log(final IStatus status) {
        getDefault().getLog().log(status);
    }

    public static void logError(final String message, final Throwable e) {
        log(new Status(IStatus.ERROR, PLUGIN_ID, message, e));
    }

    public static void logWarning(final String message, final Throwable e) {
        log(new Status(IStatus.WARNING, PLUGIN_ID, message, e));
    }

    public static void logInfo(final String message, final Throwable e) {
        log(new Status(IStatus.INFO, PLUGIN_ID, message, e));
    }

    public static void logError(final Throwable e) {
        log(new Status(IStatus.ERROR, PLUGIN_ID, "Internal Error", e));
    }

    public static IWorkbenchWindow getActiveWorkbenchWindow() {
        return getDefault().getWorkbench().getActiveWorkbenchWindow();
    }

    public static Shell getActiveWorkbenchShell() {
        final IWorkbenchWindow window = getActiveWorkbenchWindow();
        if (window != null) {
            return window.getShell();
        }
        return null;
    }

    public ImageDescriptorRegistry getImageDescriptorRegistry() {
        if (imageDescriptorRegistry == null) {
            imageDescriptorRegistry = new ImageDescriptorRegistry();
        }
        return imageDescriptorRegistry;
    }

    /**
     * Returns an Image for the file at the given relative path.
     */
    public static Image getImage(final String path) {
        final ImageRegistry registry = getDefault().getImageRegistry();
        Image image = registry.get(path);
        if (image == null) {
            registry.put(path, getImageDescriptor(path));
            image = registry.get(path);
        }
        return image;
    }

    public static ImageDescriptor getImageDescriptor(final String imageFilePath) {
        final ImageDescriptor imageDescriptor = imageDescriptorFromPlugin(PLUGIN_ID, imageFilePath);

        return imageDescriptor;
    }

    public ITemplateManager getTemplateManager() {
        if (templateManager == null) {
            templateManager = new TemplateManager();
        }
        return templateManager;
    }

    public Bundle getBundle(final String bundleName) {
        final Bundle[] bundles = getBundles(bundleName, null);
        if (bundles != null && bundles.length > 0) {
            return bundles[0];
        }
        return null;
    }

    public Bundle[] getBundles(final String bundleName, final String version) {
        Bundle[] bundles = Platform.getBundles(bundleName, version);
        if (bundles != null) {
            return bundles;
        }

        // Accessing unresolved bundle
        final ServiceReference serviceRef = fBundleContext.getServiceReference(PackageAdmin.class.getName());
        final PackageAdmin admin = (PackageAdmin) fBundleContext.getService(serviceRef);
        bundles = admin.getBundles(bundleName, version);
        if (bundles != null && bundles.length > 0) {
            return bundles;
        }
        return null;
    }

}
