package com.lambda.ecommerce.impex;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.texteditor.ChainedPreferenceStore;
import org.osgi.framework.BundleContext;

import com.lambda.ecommerce.impex.editor.ColorManager;
import com.lambda.ecommerce.impex.editor.problems.ProblemsPropertyChangeListener;

/**
 * The activator class controls the plug-in life cycle
 */
public class YImpex extends AbstractUIPlugin {

    private static final String HISTORY_DIR_NAME = "history";
    // The plug-in ID
    public static final String ID = "com.lambda.yimpexeditor";

    public static final String LOGGER_NAME = "lambda";

    // The shared instance
    private static YImpex instance;
    private IPreferenceStore fCombinedPreferenceStore;
    private ProblemsPropertyChangeListener problemsPropertyChangeListener;

    /**
     * The constructor
     */
    public YImpex() {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext )
     */
    @Override
    public void start(final BundleContext context) throws Exception {
        super.start(context);
        instance = this;
        problemsPropertyChangeListener = new ProblemsPropertyChangeListener(getPreferenceStore());
        getPreferenceStore().addPropertyChangeListener(problemsPropertyChangeListener);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext )
     */
    @Override
    public void stop(final BundleContext context) throws Exception {
        try {
            ColorManager.getDefault().dispose();
            getPreferenceStore().removePropertyChangeListener(problemsPropertyChangeListener);
            instance = null;
        } finally {
            super.stop(context);
        }
    }

    /**
     * Returns the shared instance
     * 
     * @return the shared instance
     */
    public static YImpex getDefault() {
        return instance;
    }

    public static IWorkbenchPage getActivePage() {
        final IWorkbenchWindow window = getDefault().getWorkbench().getActiveWorkbenchWindow();
        if (window == null) {
            return null;
        }
        return window.getActivePage();
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
    public List<IProject> getProjects(String natureId)
            throws CoreException, InvocationTargetException, InterruptedException {
        final List<IProject> projects = new ArrayList<IProject>();
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        for (IProject project : root.getProjects()) {
            if (project.getProject().isOpen() && project.getProject().hasNature(natureId)) {
                projects.add(project);
            }
        }
        return projects;
    }

    public static void log(final IStatus status) {
        getDefault().getLog().log(status);
    }

    public static void logError(final String message, final Throwable e) {
        log(new Status(IStatus.ERROR, ID, message, e));
    }

    public static void logWarning(final String message, final Throwable e) {
        log(new Status(IStatus.WARNING, ID, message, e));
    }

    public static void logInfo(final String message, final Throwable e) {
        log(new Status(IStatus.INFO, ID, message, e));
    }

    public static void logError(final Throwable e) {
        log(new Status(IStatus.ERROR, ID, "Internal Error", e));
    }

    public static IWorkbenchWindow getActiveWorkbenchWindow() {
        return getDefault().getWorkbench().getActiveWorkbenchWindow();
    }

    public static IWorkbenchPart getActivePart() {
        final IWorkbenchWindow activeWindow = YImpex.getActiveWorkbenchWindow();
        if (activeWindow != null) {
            final IWorkbenchPage activePage = activeWindow.getActivePage();
            if (activePage != null) {
                return activePage.getActivePart();
            }
        }
        return null;
    }

    public static Shell getActiveWorkbenchShell() {
        final IWorkbenchWindow window = getActiveWorkbenchWindow();
        if (window != null) {
            return window.getShell();
        }
        return null;
    }

    // public ImageDescriptorRegistry getImageDescriptorRegistry() {
    // if (imageDescriptorRegistry == null) {
    // imageDescriptorRegistry = new ImageDescriptorRegistry();
    // }
    // return imageDescriptorRegistry;
    // }

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
        final ImageDescriptor imageDescriptor = imageDescriptorFromPlugin(ID, imageFilePath);

        return imageDescriptor;
    }

    /**
     * Returns a combined preference store.<br/>
     * The store is read only
     * 
     * 
     * @return combined preference store
     */
    public IPreferenceStore getCombinedPreferenceStore() {
        if (fCombinedPreferenceStore == null) {
            final IPreferenceStore generalTextStore = EditorsUI.getPreferenceStore();
            fCombinedPreferenceStore = new ChainedPreferenceStore(
                    new IPreferenceStore[] { getPreferenceStore(), generalTextStore });
        }
        return fCombinedPreferenceStore;
    }

    @Override
    public IPreferenceStore getPreferenceStore() {
        return super.getPreferenceStore();
    }
}
