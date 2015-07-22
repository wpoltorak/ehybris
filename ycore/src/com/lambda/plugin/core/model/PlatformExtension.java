package com.lambda.plugin.core.model;

import org.eclipse.core.runtime.Path;

/**
 * Represents platform or extension project
 * 
 */
public class PlatformExtension {

    private final Path path;
    private final PlatformExtension parent;
    private boolean linked;

    public PlatformExtension(Path path, PlatformExtension parent) {
        this.path = path;
        this.parent = parent;
    }

    public Path getPath() {
        return path;
    }

    public PlatformExtension getParent() {
        return parent;
    }

    public boolean isLinked() {
        return linked;
    }

    public void setLinked(boolean linked) {
        this.linked = linked;
    }
}
