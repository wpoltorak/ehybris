package com.lambda.plugin.core;

import java.io.File;
import java.util.Properties;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;

public class StandardPlatformType implements IPlatformInstallation {

    private final long id;
    private String name;
    private IPath rootLocation;
    private IPath tempLocation;
    private IPath configLocation;
    private IPath dataLocation;
    private IPath customExtensionLocation;
    private IPath platformLocation;

    private String description;
    private String version;
    private Properties properties;

    public StandardPlatformType(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IPath getRootLocation() {
        return rootLocation;
    }

    public void setRootLocation(IPath rootLocation) {
        this.rootLocation = rootLocation;
    }

    public IPath getPlatformLocation() {
        return platformLocation;
    }

    public void setPlatformLocation(IPath platformLocation) {
        this.platformLocation = platformLocation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public IPath getCustomExtensionLocation() {
        return customExtensionLocation;
    }

    public void setCustomExtensionLocation(IPath customExtensionLocation) {
        this.customExtensionLocation = customExtensionLocation;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public IStatus validateInstallLocation(File installLocation) {
        return null;
    }

    public void setTempLocation(IPath tempLocation) {
        this.tempLocation = tempLocation;
    }

    public void setDataLocation(IPath dataLocation) {
        this.dataLocation = dataLocation;
    }

    public void setConfigLocation(IPath configLocation) {
        this.configLocation = configLocation;
    }

    public IPath getTempLocation() {
        return tempLocation;
    }

    public IPath getDataLocation() {
        return dataLocation;
    }

    public IPath getConfigLocation() {
        return configLocation;
    }

    public IStatus validateInstallLocation(IPath installLocation) {
        return null;
    }
}
