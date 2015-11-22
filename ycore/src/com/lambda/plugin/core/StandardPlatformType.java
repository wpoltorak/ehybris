package com.lambda.plugin.core;

import java.io.File;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.ProjectHelper;
import org.apache.tools.ant.taskdefs.MacroInstance;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;

import com.lambda.plugin.core.jaxb.extensions.Extension;
import com.lambda.plugin.core.jaxb.extensions.ExtensionsConf;
import com.lambda.plugin.utils.StringUtils;

public class StandardPlatformType implements IPlatformInstallation {

	private static final String EXTGEN_TEMPLATE_PATH = "extgen.template.path.";

	private final long id;
	private final String name;
	private final String vendor;
	private final IPath rootLocation;
	private final IPath tempLocation;
	private final IPath configLocation;
	private final IPath dataLocation;
	private final IPath customExtensionLocation;
	private final IPath platformLocation;

	private final String description;
	private final Version version;
	private final Properties antEnvProperties;
	private final IPath binLocation;
	private Properties extgenProjectProperties;
	private final Properties properties;
	private final IJavaProject project;

	public StandardPlatformType(String name, long id, String description, String vendor, Version version,
			IPath rootPath) {
		this.name = name;
		this.description = description;
		this.vendor = vendor;
		this.version = version;
		this.id = id;
		this.rootLocation = rootPath;
		this.platformLocation = rootPath.append("bin").append("platform");
		this.binLocation = rootPath.append("bin");
		this.customExtensionLocation = rootPath.append("bin").append("custom");
		this.tempLocation = rootPath.append("temp");
		this.configLocation = rootPath.append("config");
		this.dataLocation = rootPath.append("data");
		this.antEnvProperties = loadAntEnvProperties();
		this.properties = loadProperties();
		this.project = JavaCore.create(ResourcesPlugin.getWorkspace().getRoot()).getJavaProject("platform");
	}

    @Override
	public IJavaProject getProject() {
        return project;
    }

	private Properties loadAntEnvProperties() {
		// TODO set up properties page
		Properties properties = new Properties();
		properties.setProperty("platformhome", platformLocation.toOSString());
		return new PropertiesLoader().loadProperties(properties, platformLocation.append("env.properties"));
	}

	private Properties loadProperties() {
		// TODO set up properties page
		Properties properties = new Properties();
		return new PropertiesLoader().loadProperties(properties, configLocation.append("local.properties"));
	}

	@Override
	public Properties loadProjectProperties(IProject project) {
		return new PropertiesLoader().loadProperties(properties, project.getLocation().append("project.properties"));
	}

	@Override
	public Project newExtension(String templateName, String projectName, String packageName, IPath location,
			IProgressMonitor monitor) {

		String templatePathKey = EXTGEN_TEMPLATE_PATH + templateName;
		String templatePath = getExtgenProjectProperties().getProperty(templatePathKey);

		Project antProject = getAntProject(platformLocation.append("extgen").append("build.xml"));

		if (monitor.isCanceled()) {
			throw new OperationCanceledException();
		}

		antProject.setProperty("extgen.extension.name", projectName);
		antProject.setProperty("extgen.package", packageName);
		antProject.setProperty("extgen.package.directory", packageName.replaceAll("\\.", "/"));
		antProject.setProperty("extgen.directory.source", templatePath);

		// TODO provide input in front end
		// default if not specified in second page
		String classprefix = StringUtils.capitalize(projectName);
		antProject.setProperty("extension.classprefix", classprefix);
		antProject.setProperty("extension.managername", classprefix + "Manager");
		String managersuperclass = "de.hybris.platform.jalo.extension.Extension";
		antProject.setProperty("extension.managersuperclass", managersuperclass);
		Matcher m = Pattern.compile("^.*\\.([^\\.]*)$").matcher(managersuperclass);
		if (m.find()) {
			String managersuperclassname = m.group(1);
			antProject.setProperty("extension.managersuperclassname", managersuperclassname);
			antProject.setProperty("extension.managersuperclassimpl",
					managersuperclass + "." + managersuperclassname + "Impl");
		}

		m = Pattern.compile("^(.*\\.)jalo(\\..*)$$").matcher(managersuperclass);
		if (m.find()) {
			String prefix = m.group(1);
			String suffix = m.group(2);
			antProject.setProperty("extension.managersuperclassejbimpl", prefix + "jaloimpl" + suffix + "EJBImpl");
			antProject.setProperty("extension.managersuperclassejb", prefix + "session" + suffix + "EJB");
			antProject.setProperty("extension.managersuperclasshome", prefix + "session" + suffix + "Home");
			antProject.setProperty("extension.managersuperclassremote", prefix + "session" + suffix + "Remote");
		}

		antProject.setProperty("extgen.directory.tmp",
				getTempLocation().append("hybris").append("extgen").toOSString());
		antProject.setProperty("extension.directory.target", location.toOSString());
		//
		// <!-- in generated extension, disable jspcompile as default value -->
		// <replaceregexp file="${extgen.directory.tmp}/extensioninfo.xml"
		// match='jspcompile="true"'
		// replace='jspcompile="false"'
		// byline="true"/>
		antProject.createTask("clean_extgen_temp").perform();
		antProject.createTask("prepare_extgen_temp").perform();
		antProject.createTask("filter_extgen_files").perform();
		antProject.createTask("extgen_copy_extension").perform();

		return null;
	}

	private synchronized Properties getExtgenProjectProperties() {
		if (extgenProjectProperties == null) {
			extgenProjectProperties = loadExtgenProjectProperties();
		}
		return extgenProjectProperties;
	}

	@Override
	public String[] getTemplates() {
		if (Version.VERSION_5_1.compareTo(version) <= 0) {
			Project antProject = getAntProject(platformLocation.append("extgen").append("build.xml"));
			MacroInstance macro = ((MacroInstance) antProject.createTask("getextensionsformeta"));
			macro.setDynamicAttribute("metakey", "extgen-template-extension");
			macro.setDynamicAttribute("metavalue", "true");
			macro.setDynamicAttribute("resultproperty", "default.templates");
			macro.perform();
			return antProject.getProperty("default.templates").split(",");
			// Set<String> templates = new TreeSet<>();
			// ExtensionsConf extensions = ExtensionsConf.loadExtensions(this,
			// binLocation.append("ext-template"),
			// customExtensionLocation);
			// for (Extension extension :
			// extensions.getLoadedExtensions().values()) {
			// if (extension.isTemplate()) {
			// templates.add(extension.getName());
			// }
			// }
			// return templates.toArray(new String[templates.size()]);
		}
		return getExtgenProjectProperties().getProperty("extgen.template.list", "").split(",");
	}

	@Override
	public String getDefaultTemplate() {
		return getExtgenProjectProperties().getProperty("extgen.template.default", null);
	}

	@Override
	public File getTemplatePath(String template) {
		return new File(getExtgenProjectProperties().getProperty(EXTGEN_TEMPLATE_PATH + template));
	}

	private Properties loadExtgenProjectProperties() {
		Properties projectProperties = new PropertiesLoader().loadProperties(antEnvProperties,
				platformLocation.append("extgen").append("project.properties"));

		if (Version.VERSION_5_1.compareTo(version) >= 0) {
			Set<String> templates = new TreeSet<>();
			ExtensionsConf extensions = ExtensionsConf.loadAllExtensions(this);
			for (Extension extension : extensions.getLoadedExtensions().values()) {
				if (extension.isTemplate()) {
					projectProperties.put("ext." + extension.getName() + ".path",
							extension.getPath().getAbsolutePath());
				}
			}
		}
		return projectProperties;
	}

	private Project getAntProject(IPath buildFile) {
		// AntRunner runer = new AntRunner();
		// runer.setBuildFileLocation(buildFile.toOSString());
		// runer.set
		Project project = new Project();
		project.init();
		ProjectHelper.configureProject(project, buildFile.toFile());
		return project;
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getVendor() {
		return vendor;
	}

	@Override
	public IPath getRootLocation() {
		return rootLocation;
	}

	@Override
	public IPath getPlatformLocation() {
		return platformLocation;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public Version getVersion() {
		return version;
	}

	@Override
	public IPath getCustomExtensionLocation() {
		return customExtensionLocation;
	}

	@Override
	public Properties getProperties() {
		return antEnvProperties;
	}

	@Override
	public IPath getTempLocation() {
		return tempLocation;
	}

	@Override
	public IPath getDataLocation() {
		return dataLocation;
	}

	@Override
	public IPath getConfigLocation() {
		return configLocation;
	}

	@Override
	public IPath getBinLocation() {
		return binLocation;
	}

	@Override
	public IStatus validateInstallLocation(File installLocation) {
		return null;
	}
}
