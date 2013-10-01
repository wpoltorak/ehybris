package com.lambda.plugin.core;

import java.io.File;
import java.util.Properties;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;

public interface IPlatformInstallation {

    /**
     * Returns the id for this Platform. Platform IDs are unique within the Platforms of a given Platform type. The
     * Platform id is not intended to be presented to users.
     * 
     * @return the Platform identifier. Must not return <code>null</code>.
     */
    long getId();

    /**
     * Returns the display name of this Platform. The Platform name is intended to be presented to users.
     * 
     * @return the display name of this Platform. May return <code>null</code>.
     */
    String getName();

    /**
     * Sets the display name of this Platform. The Platform name is intended to be presented to users.
     * 
     * @param name the display name of this Platform
     */
    void setName(String name);

    String getDescription();

    void setDescription(String description);

    String getVersion();

    void setVersion(String version);

    /**
     * Returns absolute path of the root directory of the install location of this Platform.
     * 
     * 
     * @return the root directory of this Platform installation.
     */
    IPath getRootLocation();

    IPath getTempLocation();

    IPath getDataLocation();

    IPath getConfigLocation();

    /**
     * Returns absolute path of the custom extensions directory of this Platform.
     * 
     * @return the custom extensions directory of this Platform.
     */
    IPath getCustomExtensionLocation();

    /**
     * Sets the root directory of the install location of this Platform.
     * 
     * @param installLocation the root directory of this Platform installation
     */
    void setRootLocation(IPath location);

    /**
     * Validates the given location of a Platform installation.
     * <p>
     * For example, an implementation might check whether the Platform executable is present.
     * </p>
     * 
     * @param installLocation the root directory of a potential installation for this type of Platform
     * @return a status object describing whether the install location is valid
     */
    IStatus validateInstallLocation(File installLocation);

    IPath getPlatformLocation();

    Properties getProperties();
}