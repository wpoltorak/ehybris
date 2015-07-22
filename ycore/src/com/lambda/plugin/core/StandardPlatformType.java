package com.lambda.plugin.core;

import java.io.File;
import java.util.Properties;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;

public class StandardPlatformType implements IPlatformInstallation {

    private final long id;
    private String name;
    private String vendor;
    private IPath rootLocation;
    private IPath tempLocation;
    private IPath configLocation;
    private IPath dataLocation;
    private IPath customExtensionLocation;
    private IPath platformLocation;

    private String description;
    private Version version;
    private Properties properties;
    private IPath binLocation;

    public StandardPlatformType(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Override
    public String getVendor() {
        return vendor;
    }

    @Override
    public IPath getRootLocation() {
        return rootLocation;
    }

    public void setRootLocation(IPath rootLocation) {
        this.rootLocation = rootLocation;
    }

    @Override
    public IPath getPlatformLocation() {
        return platformLocation;
    }

    public void setPlatformLocation(IPath platformLocation) {
        this.platformLocation = platformLocation;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Version getVersion() {
        return version;
    }

    @Override
    public void setVersion(Version version) {
        this.version = version;
    }

    @Override
    public IPath getCustomExtensionLocation() {
        return customExtensionLocation;
    }

    public void setCustomExtensionLocation(IPath customExtensionLocation) {
        this.customExtensionLocation = customExtensionLocation;
    }

    @Override
    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
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

    public void setBinLocation(IPath binLocation) {
        this.binLocation = binLocation;
    }

    @Override
    public IPath getTempLocation() {
        return tempLocation;
    }

    @Override
    public IPath getDataLocation() {
        return dataLocation;
    }

    @Override
    public IPath getConfigLocation() {
        return configLocation;
    }

    @Override
    public IPath getBinLocation() {
        return binLocation;
    }

    public IStatus validateInstallLocation(IPath installLocation) {
        return null;
    }
}
