package com.lambda.plugin.core;

import java.io.File;
import java.util.List;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Unmarshaller;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.lambda.plugin.YPlugin;
import com.lambda.plugin.core.model.extensioninfo.Extensioninfo;
import com.lambda.plugin.core.model.extensions.ExtensionType;
import com.lambda.plugin.core.model.extensions.Hybrisconfig;
import com.lambda.plugin.utils.StringUtils;

public class PlatformContainer {

    private static final String ATTRIB_DESCRIPTION = "description";
    private static final String ATTRIB_VERSION = "version";
    private static final String ATTRIB_NAME = "name";
    private static final String ATTRIB_VENDOR = "vendor";

    private IPlatformInstallation defaultPlatform;
    private PropertiesLoader propertiesLoader;

    public PlatformContainer() {
        setPropertiesLoader(new PropertiesLoader());
    }

    public IPlatformInstallation getDefaultPlatform() {
        return defaultPlatform;
    }

    public void setDefaultPlatform(IPlatformInstallation defaultPlatform) {
        this.defaultPlatform = defaultPlatform;
    }

    public void initializePlatform() {
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        for (IProject project : root.getProjects()) {
            if (project.getProject().isOpen()) {
                IPlatformInstallation platform = verifyPlatformLocation(project.getLocation().toFile());
                if (platform != null) {
                    setDefaultPlatform(platform);
                }
            }
        }
    }

    StandardPlatformType createPlatform(String name, long longid, String description, String vendor, String version,
            String installPath) {
        StandardPlatformType platform = new StandardPlatformType(longid);
        platform.setVendor(vendor);
        platform.setName(name);
        platform.setDescription(description);
        platform.setVersion(version);
        Path root = new Path(installPath);
        platform.setRootLocation(root);
        platform.setCustomExtensionLocation(customExtensionLocation(root));
        platform.setBinLocation(binLocation(root));
        IPath platformLocation = platformLocation(root);
        platform.setPlatformLocation(platformLocation);
        platform.setTempLocation(tempLocation(root));
        platform.setDataLocation(dataLocation(root));
        platform.setConfigLocation(configLocation(root));

        // TODO set up properties page
        Properties properties = new Properties();
        properties.setProperty("platformhome", platformLocation.toOSString());
        platform.setProperties(loadEnvProperties(properties, platformLocation));
        return platform;
    }

    private IPath binLocation(IPath root) {
        return root.append("bin");
    }

    private IPath platformLocation(IPath root) {
        return root.append("bin").append("platform");
    }

    private IPath customExtensionLocation(IPath root) {
        return root.append("bin").append("custom");
    }

    private IPath tempLocation(IPath root) {
        return root.append("temp");
    }

    private IPath configLocation(IPath root) {
        return root.append("config");
    }

    private IPath dataLocation(IPath root) {
        return root.append("data");
    }

    public IPlatformInstallation verifyPlatformLocation(File installLocation) {
        if (!installLocation.isDirectory()) {
            return null;
        }
        IPath location = new Path(installLocation.getAbsolutePath());
        IPath platformLocation = platformLocation((IPath) location.clone());
        // if passed platform root location
        if (platformLocation.toFile().exists()) {
            location = platformLocation;
        }

        // TODO wojtek walidacja zawartości foldera bin/platform i/lub load nowego projektu do worklspacea
        Properties properties = loadBuildNumber(location);
        if (properties == null) {
            return null;
        }

        String version = properties.getProperty(ATTRIB_VERSION);
        String description = properties.getProperty(ATTRIB_DESCRIPTION);
        String name = properties.getProperty(ATTRIB_NAME);
        String vendor = properties.getProperty(ATTRIB_VENDOR);
        if (StringUtils.isEmpty(version)) {
            return null;
        }

        StandardPlatformType platform = createPlatform(name, System.currentTimeMillis(), description, vendor, version,
                installLocation.getAbsolutePath());
        return platform;
    }

    private Properties loadBuildNumber(IPath platformLocation) {
        IPath location = platformLocation.append("build.number");
        return propertiesLoader.loadProperties(null, location);
    }

    public Properties loadExtgenProjectProperties(IPlatformInstallation platform) {
        IPath platformLocation = platform.getPlatformLocation();
        IPath extgenDir = platformLocation.append("extgen");
        Properties projectProperties = propertiesLoader.loadProperties(platform.getProperties(),
                extgenDir.append("project.properties"));
        return projectProperties;
    }

    public Project loadExtgenProject(IPlatformInstallation platform) {
        return getAntProject(platform.getPlatformLocation().append("extgen").append("build.xml"));
    }

    public Properties loadExtgenProperties(IPlatformInstallation platform) {
        IPath location = platform.getPlatformLocation().append("extgen").append("templates").append("yempty")
                .append("extgen.properties");
        return propertiesLoader.loadProperties(platform.getProperties(), location);
    }

    private Properties loadEnvProperties(Properties properties, IPath platformLocation) {
        IPath location = platformLocation.append("env.properties");
        return propertiesLoader.loadProperties(properties, location);
    }

    private Project getAntProject(IPath buildFile) {
        Project project = new Project();
        project.init();
        ProjectHelper.configureProject(project, buildFile.toFile());
        return project;
    }

    public boolean verifyPlatform(IPlatformInstallation platform) {
        return platform != null && verifyPlatformLocation(platform.getPlatformLocation().toFile()) != null;
    }

    public boolean updatePlatformConfiguration(IPlatformInstallation defaultPlatform, IPlatformInstallation[] platforms) {
        if (!verifyPlatform(defaultPlatform)) {
            return false;
        }

        setDefaultPlatform(defaultPlatform);
        return true;
    }

    public Hybrisconfig loadExtensions(IPlatformInstallation platform) {
        if (platform == null) {
            return null;
        }
        try {
            File extensions = platform.getConfigLocation().append("localextensions.xml").toFile();
            if (!extensions.exists()) {
                extensions = platform.getPlatformLocation().append("extensions.xml").toFile();
            }

            JAXBContext jc = JAXBContext.newInstance(Hybrisconfig.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            Hybrisconfig config = (Hybrisconfig) JAXBIntrospector.getValue(unmarshaller.unmarshal(extensions));
            List<ExtensionType> extension = config.getExtensions().getExtension();
            for (ExtensionType extensionType : extension) {
                extensionType.setDir(PropertiesSubstitution.evaluate(platform.getProperties(), extensionType.getDir()));
            }
            return config;
        } catch (Exception e) {
            YPlugin.logError(e);
            return null;
        }
    }

    public void dispose() {
    }

    void setPropertiesLoader(PropertiesLoader propertiesLoader) {
        this.propertiesLoader = propertiesLoader;
    }

    public Extensioninfo loadExtensionInfo(File extInfo) {
        try {
            JAXBContext jc = JAXBContext.newInstance(Extensioninfo.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            return (Extensioninfo) JAXBIntrospector.getValue(unmarshaller.unmarshal(extInfo));
        } catch (Exception e) {
            YPlugin.logError(e);
            return null;
        }
    }
}
