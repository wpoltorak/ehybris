package com.lambda.plugin.core.jaxb.extensions;

import java.io.File;

public class Extension {

    private final String name;
    private final File path;
    private final String[] dependencies;
    private final boolean custom;
    private final boolean template;

    public Extension(String name, File path, String[] dependencies, boolean template, boolean custom) {
        this.name = name;
        this.path = path;
        this.dependencies = dependencies;
        this.template = template;
        this.custom = custom;
    }

    public String getName() {
        return name;
    }

    public File getPath() {
        return path;
    }

    public String[] getDependencies() {
        return dependencies;
    }

    public boolean isCustom() {
        return custom;
    }

    public boolean isTemplate() {
        return template;
    }
}
