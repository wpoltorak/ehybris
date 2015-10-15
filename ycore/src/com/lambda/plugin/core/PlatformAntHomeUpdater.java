package com.lambda.plugin.core;

import java.io.File;
import java.io.FileFilter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.ant.core.AntCorePlugin;
import org.eclipse.ant.core.AntCorePreferences;
import org.eclipse.ant.core.IAntClasspathEntry;
import org.eclipse.ant.internal.core.AntClasspathEntry;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;

import com.lambda.plugin.YCore;

public class PlatformAntHomeUpdater implements IResourceChangeListener {

	public void register() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		workspace.addResourceChangeListener(this, IResourceChangeEvent.PRE_CLOSE | IResourceChangeEvent.PRE_DELETE | IResourceChangeEvent.POST_CHANGE);
	}

	public void unregister() {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		workspace.removeResourceChangeListener(this);
	}

	@Override
	public void resourceChanged(IResourceChangeEvent event) {
		final IPlatformInstallation platform = YCore.getDefault().getDefaultPlatform();
		final IResource res = event.getResource();
		
		switch (event.getType()) {
		case IResourceChangeEvent.PRE_CLOSE:
		case IResourceChangeEvent.PRE_DELETE:
			if (platform == null || !res.equals(platform.getProject())){
				return;
			}
			setDefaultAntHome();
			break;
		case IResourceChangeEvent.POST_CHANGE:
			try {
				event.getDelta().accept(new IResourceDeltaVisitor() {
				    public boolean visit(IResourceDelta delta) throws CoreException {
				        if (delta.getKind() == IResourceDelta.OPEN){
				            final IResource resource = delta.getResource();
							if (platform == null || !res.equals(platform.getProject())){
								return false;
							}
							//TODO zronic open
//		    			res.isC
							
				           //do your stuff and check the project is opened or closed
				        }
				        return false;
				    }
				});
			} catch (CoreException e) {
				YCore.logError(e);
			}
		}
	}

	public void setDefaultAntHome() {
		AntCorePreferences prefs = AntCorePlugin.getPlugin().getPreferences();
		prefs.setAntHome(prefs.getDefaultAntHome());
		prefs.setAntHomeClasspathEntries(prefs.getDefaultAntHomeEntries());
		prefs.updatePluginPreferences();
	}

	public void setPlatformAntHome(IPath platformLocation) {
		File antHome = findAntHome(platformLocation);
		if (antHome == null) {
			return;
		}

		List<IAntClasspathEntry> entries = findAntHomeEntries(new File(antHome,
				"lib"));
		AntCorePreferences prefs = AntCorePlugin.getPlugin().getPreferences();
		prefs.setAntHome(antHome.getAbsolutePath());
		prefs.setAntHomeClasspathEntries(entries
				.toArray(new IAntClasspathEntry[entries.size()]));
		prefs.updatePluginPreferences();
	}

	private List<IAntClasspathEntry> findAntHomeEntries(File root) {
		String[] names = root.list();
		List<IAntClasspathEntry> entries = new ArrayList<>();
		if (names != null) {
			Arrays.sort(names);
			for (int i = 0; i < names.length; i++) {
				File file = new File(root, names[i]);
				if (file.isFile() && file.getPath().endsWith(".jar")) { //$NON-NLS-1$
					try {
						URL url = new URL("file:" + file.getAbsolutePath()); //$NON-NLS-1$
						entries.add(new AntClasspathEntry(url));
					} catch (MalformedURLException e) {
					}
				}
			}
		}
		return entries;
	}

	private File findAntHome(IPath platformLocation) {
		File[] antHomes = platformLocation.toFile().listFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
				return pathname.isDirectory()
						&& pathname.getName().startsWith("apache-ant-");
			}
		});

		if (antHomes.length == 0) {
			return null;
		}

		return antHomes[0];
	}
}
