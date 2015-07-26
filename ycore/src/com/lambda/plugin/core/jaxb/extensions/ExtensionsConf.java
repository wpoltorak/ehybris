package com.lambda.plugin.core.jaxb.extensions;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBIntrospector;
import javax.xml.bind.Unmarshaller;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import com.lambda.plugin.YCore;
import com.lambda.plugin.core.IPlatformInstallation;
import com.lambda.plugin.core.PropertiesSubstitution;
import com.lambda.plugin.core.Version;
import com.lambda.plugin.core.jaxb.extensioninfo.ExtensionInfo;
import com.lambda.plugin.core.jaxb.extensions.v1.Hybrisconfig;
import com.lambda.plugin.core.jaxb.extensions.v2.ExtensionsType;
import com.lambda.plugin.core.jaxb.extensions.v2.ScanType;
import com.lambda.plugin.utils.FileUtils;
import com.lambda.plugin.utils.NumberUtils;
import com.lambda.plugin.utils.StringUtils;

public class ExtensionsConf {

    private static final String EXTENSIONS_XML = "extensions.xml";
    private static final String LOCALEXTENSIONS_XML = "localextensions.xml";

    private final Map<String, Extension> loadedExtensions = new HashMap<>();
    private final Map<String, File> lazyLoadedExtensions = new HashMap<>();

    public void lazyLoadExtensions(IPlatformInstallation platform, boolean customOnly) {
        Collection<Extension> loadedExtensions = new ArrayList<>(this.loadedExtensions.values());
        for (Extension extension : loadedExtensions) {
            if (!customOnly || (customOnly && extension.isCustom())) {
                lazyLoadExtensions(platform, customOnly, true, extension.getDependencies());
            }
        }
    }

    private void lazyLoadExtensions(IPlatformInstallation platform, boolean customOnly,
            boolean referencedByCustomExtension, String... extensions) {
        for (String extension : extensions) {
            if (loadedExtensions.containsKey(extension)) {
                continue;
            }
            if (lazyLoadedExtensions.containsKey(extension)) {
                File folder = lazyLoadedExtensions.get(extension);
                if (!customOnly || (customOnly && isCustom(platform, folder))) {
                    ExtensionInfo info = loadExtension(platform, folder);
                    lazyLoadExtensions(platform, customOnly, true, info.getDependencies());
                } else if (referencedByCustomExtension) {
                    loadExtension(platform, folder);
                }
            }
        }
    }

    private void loadExtensions(IPlatformInstallation platform, File folder, int depth) {
        if (depth < 0) {
            return;
        }

        File[] folders = FileUtils.listFolders(folder);
        for (File subfolder : folders) {
            if (loadExtension(platform, subfolder) == null) {
                loadExtensions(platform, subfolder, depth--);
            }
        }
    }

    public ExtensionInfo loadExtension(IPlatformInstallation platform, File folder) {
        ExtensionInfo info = ExtensionInfo.loadExtensionInfo(folder, platform);
        if (info != null) {
            loadedExtensions.put(info.getName(),
                    new Extension(info.getName(), info.getDependencies(), isCustom(platform, folder)));
            return info;
        }
        return null;
    }

    private static boolean isCustom(IPlatformInstallation platform, File folder) {
        return platform.getCustomExtensionLocation().isPrefixOf(Path.fromOSString(folder.getAbsolutePath()));
    }

    public void lookupExtensions(IPlatformInstallation platform, File folder, int depth) {
        if (depth < 0) {
            return;
        }
        File[] folders = FileUtils.listFolders(folder);
        for (File subfolder : folders) {
            if (!lookupExtension(platform, subfolder)) {
                lookupExtensions(platform, subfolder, depth--);
            }
        }
    }

    private boolean lookupExtension(IPlatformInstallation platform, File folder) {

        boolean extInfoExists = ExtensionInfo.isExtensionInfoFolder(folder);
        if (extInfoExists) {
            lazyLoadedExtensions.put(folder.getName(), folder);
            return true;
        }
        return false;
    }

    private static File getExtensions(IPlatformInstallation platform) {
        File extensions = platform.getConfigLocation().append(LOCALEXTENSIONS_XML).toFile();
        if (!extensions.exists()) {
            extensions = platform.getPlatformLocation().append(EXTENSIONS_XML).toFile();
        }
        return extensions;
    }

    public static ExtensionsConf loadExtensions(IPlatformInstallation platform) {
        return loadExtensions(platform, false);
    }

    public static ExtensionsConf loadExtensions(IPlatformInstallation platform, boolean customOnly) {
        if (platform == null) {
            return null;
        }
        try {
            ExtensionsConf conf = new ExtensionsConf();
            File extensions = getExtensions(platform);
            // if less than 5.0
            if (Version.VERSION_5.compareTo(platform.getVersion()) >= 0) {
                Unmarshaller unmarshaller = JAXBContext.newInstance(Hybrisconfig.class).createUnmarshaller();
                com.lambda.plugin.core.jaxb.extensions.v1.Hybrisconfig config = (com.lambda.plugin.core.jaxb.extensions.v1.Hybrisconfig) JAXBIntrospector
                        .getValue(unmarshaller.unmarshal(extensions));
                List<com.lambda.plugin.core.jaxb.extensions.v1.ExtensionType> extension = config.getExtensions()
                        .getExtension();
                for (com.lambda.plugin.core.jaxb.extensions.v1.ExtensionType extensionType : extension) {
                    if (StringUtils.isNotEmpty(extensionType.getDir())) {
                        String path = PropertiesSubstitution.evaluate(platform.getProperties(), extensionType.getDir());
                        File folder = new File(path);
                        if (customOnly && !isCustom(platform, folder)) {
                            continue;
                        }
                        conf.loadExtension(platform, folder);
                    }
                }
            } else {
                Unmarshaller unmarshaller = JAXBContext
                        .newInstance(com.lambda.plugin.core.jaxb.extensions.v2.Hybrisconfig.class).createUnmarshaller();
                com.lambda.plugin.core.jaxb.extensions.v2.Hybrisconfig config = (com.lambda.plugin.core.jaxb.extensions.v2.Hybrisconfig) JAXBIntrospector
                        .getValue(unmarshaller.unmarshal(extensions));
                ExtensionsType extensionsType = config.getExtensions();
                if (extensionsType.isAutoload() && !customOnly) {
                    IPath path = platform.getPlatformLocation().append("ext");
                    conf.loadExtensions(platform, path.toFile(), Integer.MAX_VALUE);
                }

                for (ScanType scanType : extensionsType.getPath()) {
                    String dir = PropertiesSubstitution.evaluate(platform.getProperties(), scanType.getDir());
                    int depth = NumberUtils.defaultIfNull(scanType.getDepth(), Integer.MAX_VALUE);
                    File folder = new File(dir);
                    if (scanType.isAutoload() && (!customOnly || isCustom(platform, folder))) {
                        conf.loadExtensions(platform, folder, depth);
                    } else {
                        conf.lookupExtensions(platform, folder, depth);
                    }
                }

                for (com.lambda.plugin.core.jaxb.extensions.v2.ExtensionType extension : extensionsType
                        .getExtension()) {
                    if (StringUtils.isNotEmpty(extension.getDir())) {
                        File folder = new File(
                                PropertiesSubstitution.evaluate(platform.getProperties(), extension.getDir()));
                        if (!customOnly || isCustom(platform, folder)) {
                            conf.loadExtension(platform, folder);
                        }
                    } else if (StringUtils.isNotEmpty(extension.getName())) {
                        conf.lazyLoadExtensions(platform, customOnly, false, extension.getName());
                    }
                }
                conf.lazyLoadExtensions(platform, customOnly);
            }
            return conf;
        } catch (Exception e) {
            YCore.logError(e);
            return null;
        }
    }

    public boolean isReferenced(String extension) {
        return loadedExtensions.containsKey(extension);
    }

    public Map<String, Extension> getLoadedExtensions() {
        return loadedExtensions;
    }
}
