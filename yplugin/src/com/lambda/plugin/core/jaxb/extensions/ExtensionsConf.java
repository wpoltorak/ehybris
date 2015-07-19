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

import com.lambda.plugin.YPlugin;
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

    private final Map<String, String[]> loadedExtensions = new HashMap<>();
    private final Map<String, File> lazyLoadedExtensions = new HashMap<>();

    public void lazyLoadExtensions(IPlatformInstallation platform) {
        Collection<String[]> loadedExtensions = new ArrayList<>(this.loadedExtensions.values());
        for (String[] dependencies : loadedExtensions) {
            lazyLoadExtensions(platform, dependencies);
        }
    }

    private void lazyLoadExtensions(IPlatformInstallation platform, String... extensions) {
        for (String extension : extensions) {
            if (loadedExtensions.containsKey(extension)) {
                continue;
            }
            if (lazyLoadedExtensions.containsKey(extension)) {
                File folder = lazyLoadedExtensions.get(extension);
                ExtensionInfo info = loadExtension(platform, folder);
                lazyLoadExtensions(platform, info.getDependencies());
            }
        }
    }

    public void loadExtensions(IPlatformInstallation platform, File folder, int depth) {
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
            loadedExtensions.put(info.getName(), info.getDependencies());
            return info;
        }
        return null;
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
                        String dir = PropertiesSubstitution.evaluate(platform.getProperties(), extensionType.getDir());
                        conf.loadExtension(platform, new File(dir));
                    }
                }
            } else {
                Unmarshaller unmarshaller = JAXBContext.newInstance(
                        com.lambda.plugin.core.jaxb.extensions.v2.Hybrisconfig.class).createUnmarshaller();
                com.lambda.plugin.core.jaxb.extensions.v2.Hybrisconfig config = (com.lambda.plugin.core.jaxb.extensions.v2.Hybrisconfig) JAXBIntrospector
                        .getValue(unmarshaller.unmarshal(extensions));
                ExtensionsType extensionsType = config.getExtensions();
                if (extensionsType.isAutoload()) {
                    IPath path = platform.getPlatformLocation().append("ext");
                    conf.loadExtensions(platform, path.toFile(), Integer.MAX_VALUE);
                }

                for (ScanType scanType : extensionsType.getPath()) {
                    String dir = PropertiesSubstitution.evaluate(platform.getProperties(), scanType.getDir());
                    int depth = NumberUtils.defaultIfNull(scanType.getDepth(), Integer.MAX_VALUE);
                    if (scanType.isAutoload()) {
                        conf.loadExtensions(platform, new File(dir), depth);
                    } else {
                        conf.lookupExtensions(platform, new File(dir), depth);
                    }
                }

                for (com.lambda.plugin.core.jaxb.extensions.v2.ExtensionType extension : extensionsType.getExtension()) {
                    if (StringUtils.isNotEmpty(extension.getDir())) {
                        String dir = PropertiesSubstitution.evaluate(platform.getProperties(), extension.getDir());
                        conf.loadExtension(platform, new File(dir));
                    } else if (StringUtils.isNotEmpty(extension.getName())) {
                        conf.lazyLoadExtensions(platform, extension.getName());
                    }
                }
                conf.lazyLoadExtensions(platform);
            }
            return conf;
        } catch (Exception e) {
            YPlugin.logError(e);
            return null;
        }
    }

    public boolean isReferenced(String extension) {
        return loadedExtensions.containsKey(extension);
    }
}
