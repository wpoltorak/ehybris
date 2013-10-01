package com.lambda.plugin.core;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.IOUtils;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.osgi.util.NLS;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.lambda.plugin.YMessages;
import com.lambda.plugin.YPlugin;
import com.lambda.plugin.preferences.PreferenceConstants;
import com.lambda.plugin.utils.StringUtils;

public class PlatformContainer {

    private static final String ATTRIB_DESCRIPTION = "description";
    private static final String ATTRIB_VERSION = "version";
    private static final String ATTRIB_NAME = "name";
    private static final String ATTRIB_PATH = "path";
    private static final String ATTRIB_ID = "id";
    private static final String ATTRIB_DIR = "dir";
    private static final String TAG_PLATFORM = "platform";
    private static final String TAG_PLATFORM_SETTINGS = "platformSettings";
    private static final String TAG_EXTENSIONS_CONFIG = "hybrisconfig";
    private static final String TAG_EXTENSIONS = "extensions";
    private static final String TAG_EXTENSION = "extension";

    private List<IPlatformInstallation> platforms;
    private IPlatformInstallation defaultPlatform;
    private PropertiesLoader propertiesLoader;

    public PlatformContainer() {
        setPropertiesLoader(new PropertiesLoader());
    }

    public List<IPlatformInstallation> getPlatforms() {
        return platforms;
    }

    public IPlatformInstallation getDefaultPlatform() {
        return defaultPlatform;
    }

    public void setDefaultPlatform(IPlatformInstallation defaultPlatform) {
        this.defaultPlatform = defaultPlatform;
    }

    public void initializePlatforms() {
        if (platforms == null) {
            platforms = new ArrayList<IPlatformInstallation>();
            try {
                Element config = readPlatforms();
                parsePlatforms(config);
            } catch (Exception e) {
                YPlugin.logError(e);
            }
        }
    }

    private void parsePlatforms(Element config) throws IOException {
        if (!config.getNodeName().equalsIgnoreCase(TAG_PLATFORM_SETTINGS)) { //$NON-NLS-1$
            throw new IOException("Invalid format");
        }
        long defaultPlatformId = readDefaultConfigId(config);
        NodeList list = config.getChildNodes();
        int length = list.getLength();
        for (int i = 0; i < length; ++i) {
            Node node = list.item(i);
            short type = node.getNodeType();
            if (type == Node.ELEMENT_NODE) {
                Element platformElement = (Element) node;
                if (platformElement.getNodeName().equalsIgnoreCase(TAG_PLATFORM)) { //$NON-NLS-1$
                    String id = platformElement.getAttribute(ATTRIB_ID); //$NON-NLS-1$
                    String installPath = platformElement.getAttribute(ATTRIB_PATH); //$NON-NLS-1$
                    String name = platformElement.getAttribute(ATTRIB_NAME); //$NON-NLS-1$
                    String version = platformElement.getAttribute(ATTRIB_VERSION); //$NON-NLS-1$
                    String description = platformElement.getAttribute(ATTRIB_DESCRIPTION); //$NON-NLS-1$
                    if (id != null) {
                        if (name == null) {
                            if (installPath == null) {
                                YPlugin.log(new Status(IStatus.ERROR, YPlugin.PLUGIN_ID,
                                        YMessages.PlatformDefinitions_invalid_nameAndPath));
                                continue;
                            }
                            YPlugin.log(new Status(IStatus.ERROR, YPlugin.PLUGIN_ID, NLS.bind(
                                    YMessages.PlatformDefinitions_invalid_name, new String[] { installPath })));
                            continue;
                        }
                        if (installPath == null) {
                            YPlugin.log(new Status(IStatus.ERROR, YPlugin.PLUGIN_ID, NLS.bind(
                                    YMessages.PlatformDefinitions_invalid_path, new String[] { name })));
                            continue;
                        }
                        long longid = 0;
                        try {
                            longid = Long.parseLong(id);
                        } catch (NumberFormatException e) {
                            YPlugin.log(new Status(IStatus.ERROR, YPlugin.PLUGIN_ID, NLS.bind(
                                    YMessages.PlatformDefinitions_invalid_id, new String[] { name })));
                            continue;
                        }

                        IPlatformInstallation platform = createPlatform(name, longid, description, version, installPath);
                        // Create a VMStandin for the node and set its 'name' & 'installLocation' attributes
                        platforms.add(platform);

                        if (longid == defaultPlatformId) {
                            this.defaultPlatform = platform;
                        }
                    } else {
                        if (name != null) {
                            YPlugin.log(new Status(IStatus.ERROR, YPlugin.PLUGIN_ID, NLS.bind(
                                    YMessages.PlatformDefinitions_invalid_id, new String[] { name })));
                        } else if (installPath != null) {
                            YPlugin.log(new Status(IStatus.ERROR, YPlugin.PLUGIN_ID, NLS.bind(
                                    YMessages.PlatformDefinitions_invalid_id, new String[] { installPath })));
                        } else {
                            YPlugin.log(new Status(IStatus.ERROR, YPlugin.PLUGIN_ID,
                                    YMessages.PlatformDefinitions_invalid_idNameAndPath));
                        }
                    }
                }
            }
        }

        // set first one as default of no default was previously selected
        if (this.defaultPlatform == null && !platforms.isEmpty()) {
            this.defaultPlatform = platforms.get(0);
        }
    }

    private Element readPlatforms() throws UnsupportedEncodingException, ParserConfigurationException, SAXException,
            IOException {
        String xml = InstanceScope.INSTANCE.getNode(YPlugin.PLUGIN_ID).get(PreferenceConstants.PLATFORMS_XML, "");//$NON-NLS-1$
        if (xml.length() == 0) {
            throw new ParserConfigurationException("No platforms xml configuration");
        }
        ByteArrayInputStream inputStream = null;
        InputStream stream = null;
        Element config;
        try {
            inputStream = new ByteArrayInputStream(xml.getBytes("UTF8")); //$NON-NLS-1$
            // Wrapper the stream for efficient parsing
            stream = new BufferedInputStream(inputStream);
            DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            parser.setErrorHandler(new DefaultHandler());
            config = parser.parse(new InputSource(stream)).getDocumentElement();
        } finally {
            IOUtils.closeQuietly(stream);
            IOUtils.closeQuietly(inputStream);
        }
        return config;
    }

    private Map<IPath, PlatformExtension> parseExtensionsConfig(IPlatformInstallation platform, Element config)
            throws IOException {
        if (!config.getNodeName().equalsIgnoreCase(TAG_EXTENSIONS_CONFIG)) { //$NON-NLS-1$
            throw new IOException("Invalid format");
        }
        Map<IPath, PlatformExtension> extensions = new HashMap<IPath, PlatformExtension>();
        NodeList list = config.getChildNodes();
        int length = list.getLength();
        for (int i = 0; i < length; ++i) {
            Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element platformElement = (Element) node;
                if (platformElement.getNodeName().equalsIgnoreCase(TAG_EXTENSIONS)) {
                    parseExtensions(platform, platformElement, extensions);
                }
            }
        }
        return extensions;
    }

    private void parseExtensions(IPlatformInstallation platform, Element element,
            Map<IPath, PlatformExtension> extensions) {
        NodeList list = element.getChildNodes();
        int length = list.getLength();
        for (int i = 0; i < length; ++i) {
            Node node = list.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element extElement = (Element) node;
                if (extElement.getNodeName().equalsIgnoreCase(TAG_EXTENSION)) {
                    parseExtension(platform, extElement, extensions);
                }
            }
        }
    }

    private void parseExtension(IPlatformInstallation platform, Element element,
            Map<IPath, PlatformExtension> extensions) {
        String dir = element.getAttribute(ATTRIB_DIR);
        String evaluated = PropertiesSubstitution.evaluate(platform.getProperties(), dir);
        if (evaluated.isEmpty()) {
            return;
        }
        Path path = new Path(evaluated);
        if (path.toFile().isDirectory()) {
            extensions.put(path, new PlatformExtension(path));
        }
    }

    private Element readExtensions(IPlatformInstallation platform) throws UnsupportedEncodingException,
            ParserConfigurationException, SAXException, IOException {
        if (platform == null) {
            return null;
        }
        FileInputStream inputStream = null;
        InputStream stream = null;
        Element extensions;
        try {
            inputStream = new FileInputStream(platform.getPlatformLocation().append("extensions.xml").toFile()); //$NON-NLS-1$
            // Wrapper the stream for efficient parsing
            stream = new BufferedInputStream(inputStream);
            DocumentBuilder parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            parser.setErrorHandler(new DefaultHandler());
            extensions = parser.parse(new InputSource(stream)).getDocumentElement();
        } finally {
            IOUtils.closeQuietly(stream);
            IOUtils.closeQuietly(inputStream);
        }
        return extensions;
    }

    StandardPlatformType createPlatform(String name, long longid, String description, String version, String installPath) {
        StandardPlatformType platform = new StandardPlatformType(longid);
        platform.setName(name);
        platform.setDescription(description);
        platform.setVersion(version);
        Path root = new Path(installPath);
        platform.setRootLocation(root);
        platform.setCustomExtensionLocation(customExtensionLocation(root));
        IPath platformLocation = platformLocation(root);
        platform.setPlatformLocation(platformLocation);
        platform.setTempLocation(tempLocation(root));
        platform.setDataLocation(dataLocation(root));
        platform.setConfigLocation(configLocation(root));

        // TODO set up properties page
        Properties properties = new Properties();
        properties.setProperty("platformhome", platformLocation.toOSString());
        platform.setProperties(loadEnvProperties(properties, platformLocation));
        return platform;
    }

    private IPath platformLocation(IPath root) {
        return root.append("bin").append("platform");
    }

    private IPath customExtensionLocation(IPath root) {
        return root.append("bin").append("custom");
    }

    private IPath tempLocation(IPath root) {
        return root.append("temp");
    }

    private IPath configLocation(IPath root) {
        return root.append("config");
    }

    private IPath dataLocation(IPath root) {
        return root.append("data");
    }

    private void storePlatforms() {
        try {
            Document doc = createDocument();
            storePlatforms(doc);
        } catch (ParserConfigurationException e) {
            YPlugin.logError("Failed to store platforms xml preference: " + PreferenceConstants.PLATFORMS_XML, e);
        }
    }

    private Document createDocument() throws ParserConfigurationException {
        DocumentBuilderFactory dfactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = dfactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();
        Element config = doc.createElement(TAG_PLATFORM_SETTINGS); //$NON-NLS-1$
        doc.appendChild(config);

        if (getDefaultPlatform() != null) {
            config.setAttribute(ATTRIB_ID, "" + getDefaultPlatform().getId()); //$NON-NLS-1$
        }

        List<IPlatformInstallation> platforms = getPlatforms();
        for (IPlatformInstallation platform : platforms) {
            Element platformTag = doc.createElement(TAG_PLATFORM);
            platformTag.setAttribute(ATTRIB_ID, "" + platform.getId()); //$NON-NLS-1$
            platformTag.setAttribute(ATTRIB_NAME, platform.getName());
            platformTag.setAttribute(ATTRIB_VERSION, platform.getVersion());
            platformTag.setAttribute(ATTRIB_PATH, platform.getRootLocation().toOSString());
            platformTag.setAttribute(ATTRIB_DESCRIPTION, platform.getDescription());
            config.appendChild(platformTag);
        }
        return doc;
    }

    private void storePlatforms(Document doc) {
        try {
            ByteArrayOutputStream s = null;
            String xml = null;
            try {
                s = new ByteArrayOutputStream();
                TransformerFactory factory = TransformerFactory.newInstance();
                Transformer transformer = factory.newTransformer();
                transformer.setOutputProperty(OutputKeys.METHOD, "xml"); //$NON-NLS-1$
                transformer.setOutputProperty(OutputKeys.INDENT, "yes"); //$NON-NLS-1$
                DOMSource source = new DOMSource(doc);
                StreamResult outputTarget = new StreamResult(s);
                transformer.transform(source, outputTarget);
                xml = s.toString("UTF8"); //$NON-NLS-1$
                IEclipsePreferences node = InstanceScope.INSTANCE.getNode(YPlugin.PLUGIN_ID);
                node.put(PreferenceConstants.PLATFORMS_XML, xml);//$NON-NLS-1$
                node.flush();
            } finally {
                if (s != null) {
                    s.close();
                }
            }
        } catch (Exception e) {
            YPlugin.logError("Failed to store platforms xml preference: " + PreferenceConstants.PLATFORMS_XML, e);
        }
    }

    private long readDefaultConfigId(Element config) {
        try {
            return Long.parseLong(config.getAttribute("defaultPlatformId"));
        } catch (Exception e) {
            return 0;
        }
    }

    public IPlatformInstallation verifyPlatformLocation(File installLocation) {
        if (!installLocation.isDirectory()) {
            return null;
        }

        // TODO wojtek walidacja zawartości foldera bin/platform i/lub load nowego projektu do worklspacea
        Properties properties = loadBuildNumber(platformLocation(new Path(installLocation.getAbsolutePath())));
        if (properties == null) {
            return null;
        }

        String version = properties.getProperty(ATTRIB_VERSION);
        String description = properties.getProperty(ATTRIB_DESCRIPTION);
        String name = properties.getProperty(ATTRIB_NAME);
        if (StringUtils.isEmpty(version) || StringUtils.isEmpty(description) || StringUtils.isEmpty(name)) {
            return null;
        }

        StandardPlatformType platform = createPlatform(name, System.currentTimeMillis(), description, version,
                installLocation.getAbsolutePath());
        return platform;
    }

    private Properties loadBuildNumber(IPath platformLocation) {
        IPath location = platformLocation.append("build.number");
        return propertiesLoader.loadProperties(null, location);
    }

    public Properties loadExtgenProjectProperties(IPlatformInstallation platform) {
        IPath platformLocation = platform.getPlatformLocation();
        IPath extgenDir = platformLocation.append("extgen");
        // Project project = getAntProject(extgenDir.append("build.xml"));
        // Properties buildFileProperties = loadPropertiesFromBuildFile(project);
        Properties projectProperties = propertiesLoader.loadProperties(platform.getProperties(),
                extgenDir.append("project.properties"));
        // Object p2 = projectProperties.get("extgen.template.path.yempty");
        return projectProperties;
    }

    // private Properties loadPropertiesFromBuildFile(Project project) {
    // Properties properties = new Properties();
    // Object p1 = PropertyHelper.getProperty(project, "extgen.template.path.yempty");
    // Object p2 = project.getProperty("extgen.template.path.yempty");
    // properties.putAll(project.getProperties());
    // return properties;
    // }

    public Project loadExtgenProject(IPlatformInstallation platform) {
        return getAntProject(platform.getPlatformLocation().append("extgen").append("build.xml"));
    }

    public Properties loadExtgenProperties(IPlatformInstallation platform) {
        IPath location = platform.getPlatformLocation().append("extgen").append("templates").append("yempty")
                .append("extgen.properties");
        return propertiesLoader.loadProperties(platform.getProperties(), location);
    }

    private Properties loadEnvProperties(Properties properties, IPath platformLocation) {
        IPath location = platformLocation.append("env.properties");
        return propertiesLoader.loadProperties(properties, location);
    }

    private Project getAntProject(IPath buildFile) {
        Project project = new Project();
        project.init();
        ProjectHelper.configureProject(project, buildFile.toFile());
        return project;
    }

    public boolean verifyPlatform(IPlatformInstallation platform) {
        return platform != null && verifyPlatformLocation(platform.getRootLocation().toFile()) != null;
    }

    public boolean updatePlatformConfiguration(IPlatformInstallation defaultPlatform, IPlatformInstallation[] platforms) {
        if (!verifyPlatform(defaultPlatform)) {
            return false;
        }

        Map<IPath, PlatformExtension> extensions = loadExtensions(getDefaultPlatform());
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        for (IProject project : root.getProjects()) {
            if (extensions.containsKey(project.getFullPath())) {
                // TODO remove project from workspace
            }
        }

        setDefaultPlatform(defaultPlatform);

        this.platforms.clear();
        this.platforms.addAll(Arrays.asList(platforms));
        return true;
    }

    private Map<IPath, PlatformExtension> loadExtensions(IPlatformInstallation platform) {
        try {
            Element extensions = readExtensions(platform);
            return parseExtensionsConfig(platform, extensions);
        } catch (Exception e) {
            YPlugin.logError(e);
            return Collections.<IPath, PlatformExtension> emptyMap();
        }
    }

    public void dispose() {
        storePlatforms();
    }

    void setPropertiesLoader(PropertiesLoader propertiesLoader) {
        this.propertiesLoader = propertiesLoader;
    }
}