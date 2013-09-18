package com.lambda.plugin.core;

import java.io.File;

import org.eclipse.core.runtime.IStatus;

public class StandardPlatformType implements IPlatformInstallation {

    private final long id;
    private String name;
    private File installedLocation;
    private String description;
    private String version;

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

    public File getInstallLocation() {
        return installedLocation;
    }

    public void setInstallLocation(File installLocation) {
        installedLocation = installLocation;
    }

    public IStatus validateInstallLocation(File installLocation) {
        return null;
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
}
