package com.lambda.plugin.core;

import org.eclipse.core.runtime.Path;

public class PlatformExtension {

    private final Path path;

    public PlatformExtension(Path path) {
        this.path = path;
    }

    public Path getPath() {
        return path;
    }
}
