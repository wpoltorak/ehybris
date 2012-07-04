package com.kizoom.plugin.functest;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.internal.core.JavaModel;
import org.eclipse.jdt.internal.core.JavaModelManager;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class FunctestPlugin extends AbstractUIPlugin {

	private static final String HISTORY_DIR_NAME = "history";
	// The plug-in ID
	public static final String PLUGIN_ID = "com.kizoom.plugin.functest";

	private FunctestManager functestManager;

	private FunctestModel functestModel = new FunctestModel();

	// The shared instance
	private static FunctestPlugin plugin;

	/**
	 * The constructor
	 */
	public FunctestPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		((FunctestManager) getFunctestManager()).initialize();
		functestModel.start();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	public void stop(BundleContext context) throws Exception {
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
	public static FunctestPlugin getDefault() {
		return plugin;
	}

	public static FunctestModel getModel() {
		return getDefault().functestModel;
	}

	public IFunctestManager getFunctestManager() {
		if (functestManager == null)
			functestManager = new FunctestManager();
		return functestManager;
	}

	public static File getHistoryDirectory() throws IllegalStateException {
		File historyDir = getDefault().getStateLocation().append(
				HISTORY_DIR_NAME).toFile();
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
	public List<IJavaProject> getFunctestProjects() throws CoreException,
			InvocationTargetException, InterruptedException {
		JavaModel javaModel = JavaModelManager.getJavaModelManager()
				.getJavaModel();
		List<IJavaProject> functestProjects = new ArrayList<IJavaProject>();
		for (IJavaProject project : javaModel.getJavaProjects()) {
			if (project.getProject().isOpen()
					&& project.getProject().hasNature(FunctestNature.NATURE_ID)) {
				functestProjects.add(project);
			}
		}
		return functestProjects;
	}

}
