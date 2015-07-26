package com.lambda.plugin.core.jaxb.extensions;

public class Extension {

    private final String name;
    private final String[] dependencies;
    private final boolean custom;

    public Extension(String name, String[] dependencies, boolean custom) {
        this.name = name;
        this.dependencies = dependencies;
        this.custom = custom;
    }

    public String getName() {
        return name;
    }

    public String[] getDependencies() {
        return dependencies;
    }

    public boolean isCustom() {
        return custom;
    }
}
