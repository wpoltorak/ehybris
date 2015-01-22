package com.lambda.plugin;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.IJavaModel;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
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

import com.lambda.plugin.core.IPlatformInstallation;
import com.lambda.plugin.core.PlatformContainer;
import com.lambda.plugin.impex.editor.ColorManager;
import com.lambda.plugin.impex.editor.problems.ProblemsPropertyChangeListener;
import com.lambda.plugin.nature.IYNatureManager;
import com.lambda.plugin.nature.YNatureManager;
import com.lambda.plugin.template.ITemplateManager;
import com.lambda.plugin.template.TemplateManager;

/**
 * The activator class controls the plug-in life cycle
 */
public class YPlugin extends AbstractUIPlugin {

    private static final String HISTORY_DIR_NAME = "history";
    // The plug-in ID
    public static final String PLUGIN_ID = "com.lambda.yplugin";

    public static final String LOGGER_NAME = "lambda";

    // The shared instance
    private static YPlugin plugin;
    private static Object fPlatformTypeLock = new Object();

    // private ImageDescriptorRegistry imageDescriptorRegistry;

    private TemplateManager templateManager;

    private IPreferenceStore fCombinedPreferenceStore;

    private IYNatureManager natureManager;
    private PlatformContainer platformContainer;
    private ProblemsPropertyChangeListener problemsPropertyChangeListener;

    private IJavaSearchScope scope;

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
            getPlatformContainer().dispose();
            ColorManager.getDefault().dispose();
            getPreferenceStore().removePropertyChangeListener(problemsPropertyChangeListener);
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
        final IWorkbenchWindow window = getDefault().getWorkbench().getActiveWorkbenchWindow();
        if (window == null) {
            return null;
        }
        return window.getActivePage();
    }

    public IYNatureManager getNatureManager() {
        if (natureManager == null) {
            natureManager = new YNatureManager();
        }
        return natureManager;
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
    public List<IProject> getProjects(String natureId) throws CoreException, InvocationTargetException,
            InterruptedException {
        final List<IProject> projects = new ArrayList<IProject>();
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        for (IProject project : root.getProjects()) {
            if (project.getProject().isOpen() && project.getProject().hasNature(natureId)) {
                projects.add(project);
            }
        }
        return projects;
    }

    /**
     * 
     * @return functional test existing in workspace
     * @throws CoreException
     * @throws InvocationTargetException
     * @throws InterruptedException
     */
    public List<IJavaProject> getFunctestProjects() throws CoreException, InvocationTargetException,
            InterruptedException {
        final IJavaModel javaModel = JavaCore.create(ResourcesPlugin.getWorkspace().getRoot());
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

    public static IWorkbenchPart getActivePart() {
        final IWorkbenchWindow activeWindow = YPlugin.getActiveWorkbenchWindow();
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
        final ImageDescriptor imageDescriptor = imageDescriptorFromPlugin(PLUGIN_ID, imageFilePath);

        return imageDescriptor;
    }

    public ITemplateManager getTemplateManager() {
        if (templateManager == null) {
            templateManager = new TemplateManager();
        }
        return templateManager;
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
            fCombinedPreferenceStore = new ChainedPreferenceStore(new IPreferenceStore[] { getPreferenceStore(),
                    generalTextStore });
        }
        return fCombinedPreferenceStore;
    }

    @Override
    public IPreferenceStore getPreferenceStore() {
        return super.getPreferenceStore();
    }

    @Deprecated
    public IPlatformInstallation[] getPlatformInstallations() {
        initplatformInstallation();
        // List<IPlatformInstallation> platformInstallatons = getPlatformContainer().getPlatforms();
        // return platformInstallatons.toArray(new IPlatformInstallation[platformInstallatons.size()]);
        return new IPlatformInstallation[0];
    }

    private void initplatformInstallation() {
        synchronized (fPlatformTypeLock) {
            getPlatformContainer().initializePlatform();
        }
    }

    public IPlatformInstallation getDefaultPlatform() {
        initplatformInstallation();
        return getPlatformContainer().getDefaultPlatform();
    }

    public PlatformContainer getPlatformContainer() {
        if (platformContainer == null) {
            platformContainer = new PlatformContainer();
        }
        return platformContainer;
    }

    public IJavaSearchScope extensibleItemHierarchyScope() throws JavaModelException {
        if (scope == null) {
            long millis = System.currentTimeMillis();
            System.err.println("entered extensibleItemHierarchyScope");
            try {
                String name = YPlugin.getDefault().getDefaultPlatform().getPlatformLocation().lastSegment().toString();
                IJavaProject project = JavaCore.create(ResourcesPlugin.getWorkspace().getRoot()).getJavaProject(name);
                IType type = project.findType("de.hybris.platform.core.model.ItemModel");
                scope = SearchEngine.createStrictHierarchyScope(project, type, true, true, null);
            } finally {
                millis = System.currentTimeMillis() - millis;
                // int seconds = (int) (millis / 1000) % 60 ;
                // int minutes = (int) ((millis / (1000*60)) % 60);
                // millis = millis % 60;
                // System.err.println("Took " + " millis (" + + ")");
                System.err.println(String.format(
                        "Took %d:%d:%d",
                        TimeUnit.MILLISECONDS.toMinutes(millis),
                        TimeUnit.MILLISECONDS.toSeconds(millis)
                                - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)),
                        TimeUnit.MILLISECONDS.toMillis(millis)
                                - TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(millis))));
            }
            // type.newTypeHierarchy(new NullProgressMonitor()).getAllSubtypes(type);
        }
        return scope;
    }

}
