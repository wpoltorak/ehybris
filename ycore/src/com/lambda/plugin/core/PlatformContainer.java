package com.lambda.plugin.core;

import java.io.File;
import java.util.Properties;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

public class PlatformContainer {

    private static final String ATTRIB_DESCRIPTION = "description";
    private static final String ATTRIB_VERSION = "version";
    private static final String ATTRIB_NAME = "name";
    private static final String ATTRIB_VENDOR = "vendor";

    private IPlatformInstallation defaultPlatform;

    public PlatformContainer() {
    }

    public IPlatformInstallation getDefaultPlatform() {
        return defaultPlatform;
    }

    public void setDefaultPlatform(IPlatformInstallation defaultPlatform) {
        this.defaultPlatform = defaultPlatform;
    }

    public IPlatformInstallation initializePlatform() {
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        IProject project = root.getProject("platform");
        IPlatformInstallation platform = verifyPlatformLocation(project.getLocation().toFile());
        if (platform != null) {
            setDefaultPlatform(platform);
        }
        return platform;
    }

    StandardPlatformType createPlatform(String name, long longid, String description, String vendor, Version version,
            String installPath) {
        StandardPlatformType platform = new StandardPlatformType(name, longid, description, vendor, version,
                new Path(installPath).removeLastSegments(2));
        return platform;
    }

    public IPlatformInstallation verifyPlatformLocation(File installLocation) {
        if (!installLocation.isDirectory()) {
            return null;
        }
        IPath platformLocation = new Path(installLocation.getAbsolutePath());

        // TODO wojtek walidacja zawartości foldera bin/platform i/lub load nowego projektu do worklspacea
        Properties properties = loadBuildNumber(platformLocation);
        if (properties == null) {
            return null;
        }

        Version version = new Version(properties.getProperty(ATTRIB_VERSION));
        String description = properties.getProperty(ATTRIB_DESCRIPTION);
        String name = properties.getProperty(ATTRIB_NAME);
        String vendor = properties.getProperty(ATTRIB_VENDOR);

        StandardPlatformType platform = createPlatform(name, System.currentTimeMillis(), description, vendor, version,
                installLocation.getAbsolutePath());
        return platform;
    }

    private Properties loadBuildNumber(IPath platformLocation) {
        IPath location = platformLocation.append("build.number");
        return new PropertiesLoader().loadProperties(null, location);
    }

    public Properties loadExtgenProperties(IPlatformInstallation platform) {
        IPath location = platform.getPlatformLocation().append("extgen").append("templates").append("yempty")
                .append("extgen.properties");
        return new PropertiesLoader().loadProperties(platform.getProperties(), location);
    }

    public void dispose() {
    }
}
