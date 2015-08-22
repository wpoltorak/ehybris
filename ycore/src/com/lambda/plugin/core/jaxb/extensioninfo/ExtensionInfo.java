package com.lambda.plugin.core.jaxb.extensioninfo;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Unmarshaller;

import org.eclipse.core.runtime.Path;

import com.lambda.plugin.YCore;
import com.lambda.plugin.core.IPlatformInstallation;
import com.lambda.plugin.core.Version;
import com.lambda.plugin.core.jaxb.extensioninfo.v1.Extensioninfo;
import com.lambda.plugin.core.jaxb.extensioninfo.v3.MetaType;

public class ExtensionInfo {

    public static final String EXTENSIONINFO_XML = "extensioninfo.xml";

    private String name;
    private final File path;
    private boolean template;
    private String[] dependencies;

    public ExtensionInfo(File path) {
        this.path = path;
    }

    public static boolean isExtensionInfoFolder(File folder) {
        return appendExtensionInfo(folder).exists();
    }

    public static ExtensionInfo loadExtensionInfo(File folder, IPlatformInstallation platform) {

        try {
            File extInfo = appendExtensionInfo(folder);
            if (!extInfo.exists()) {
                return null;
            }
            if (Version.VERSION_5_5.compareTo(platform.getVersion()) <= 0) {
                Unmarshaller unmarshaller = JAXBContext
                        .newInstance(com.lambda.plugin.core.jaxb.extensioninfo.v3.Extensioninfo.class)
                        .createUnmarshaller();
                com.lambda.plugin.core.jaxb.extensioninfo.v3.Extensioninfo extensioninfo = (com.lambda.plugin.core.jaxb.extensioninfo.v3.Extensioninfo) JAXBIntrospector
                        .getValue(unmarshaller.unmarshal(extInfo));
                return ExtensionInfo.fromExtensionInfo(extensioninfo, folder);
            } else if (Version.VERSION_5.compareTo(platform.getVersion()) <= 0) {
                Unmarshaller unmarshaller = JAXBContext
                        .newInstance(com.lambda.plugin.core.jaxb.extensioninfo.v2.Extensioninfo.class)
                        .createUnmarshaller();
                return ExtensionInfo
                        .fromExtensionInfo((com.lambda.plugin.core.jaxb.extensioninfo.v2.Extensioninfo) JAXBIntrospector
                                .getValue(unmarshaller.unmarshal(extInfo)), folder);
            } else {
                Unmarshaller unmarshaller = JAXBContext.newInstance(Extensioninfo.class).createUnmarshaller();
                return ExtensionInfo
                        .fromExtensionInfo((com.lambda.plugin.core.jaxb.extensioninfo.v1.Extensioninfo) JAXBIntrospector
                                .getValue(unmarshaller.unmarshal(extInfo)), folder);
            }
        } catch (Exception e) {
            YCore.logError(e);
            return null;
        }
    }

    private static File appendExtensionInfo(File folder) {
        return Path.fromOSString(folder.getAbsolutePath()).append(EXTENSIONINFO_XML).toFile();
    }

    private static ExtensionInfo fromExtensionInfo(
            com.lambda.plugin.core.jaxb.extensioninfo.v3.Extensioninfo extensioninfo, File path) {
        ExtensionInfo info = new ExtensionInfo(path);
        com.lambda.plugin.core.jaxb.extensioninfo.v3.ExtensionType extension = extensioninfo.getExtension();
        info.name = extension.getName();
        List<com.lambda.plugin.core.jaxb.extensioninfo.v3.RequiresExtensionType> requiresExtension = extension
                .getRequiresExtension();
        List<MetaType> metas = extension.getMeta();
        for (MetaType meta : metas) {
            if ("extgen-template-extension".equals(meta.getKey())) {
                info.template = Boolean.parseBoolean(meta.getValue());
                break;
            }
        }
        info.dependencies = new String[requiresExtension.size()];
        for (int i = 0; i < requiresExtension.size(); i++) {
            info.dependencies[i] = requiresExtension.get(i).getName();
        }
        return info;
    }

    private static ExtensionInfo fromExtensionInfo(
            com.lambda.plugin.core.jaxb.extensioninfo.v2.Extensioninfo extensioninfo, File path) {
        ExtensionInfo info = new ExtensionInfo(path);
        com.lambda.plugin.core.jaxb.extensioninfo.v2.ExtensionType extension = extensioninfo.getExtension();
        info.name = extension.getName();
        List<com.lambda.plugin.core.jaxb.extensioninfo.v2.RequiresExtensionType> requiresExtension = extension
                .getRequiresExtension();
        info.dependencies = new String[requiresExtension.size()];
        for (int i = 0; i < requiresExtension.size(); i++) {
            info.dependencies[i] = requiresExtension.get(i).getName();
        }
        return info;
    }

    private static ExtensionInfo fromExtensionInfo(
            com.lambda.plugin.core.jaxb.extensioninfo.v1.Extensioninfo extensioninfo, File path) {
        ExtensionInfo info = new ExtensionInfo(path);
        com.lambda.plugin.core.jaxb.extensioninfo.v1.ExtensionType extension = extensioninfo.getExtension();
        info.name = extension.getName();
        List<com.lambda.plugin.core.jaxb.extensioninfo.v1.RequiresExtensionType> requiresExtension = extension
                .getRequiresExtension();
        info.dependencies = new String[requiresExtension.size()];
        for (int i = 0; i < requiresExtension.size(); i++) {
            info.dependencies[i] = requiresExtension.get(i).getName();
        }
        return info;
    }

    public String getName() {
        return name;
    }

    public String[] getDependencies() {
        return dependencies;
    }

    public boolean isTemplate() {
        return template;
    }

    public File getPath() {
        return path;
    }
}
