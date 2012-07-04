package com.kizoom.plugin.wildebeest.team;

import java.io.InputStream;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.commons.lang.StringUtils;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class ProjectSetReader {
	
	private static final String SUPPORTED_PSF_VERSION = "2.0";
	
	private final SortedSet<String> projectNames = new TreeSet<String>();
	
	@SuppressWarnings("unchecked")
	public ProjectSetReader(InputStream projectSetFile) throws Exception {
		try {
			Element psfElement = new SAXBuilder().build(projectSetFile).getRootElement();
			String psfVersion = psfElement.getAttributeValue("version");
			
			if (!SUPPORTED_PSF_VERSION.equals(psfVersion)) {
				throw new IllegalArgumentException("Unsupported ProjectSet version: " + psfVersion);
			}
			
			Element providerElement = psfElement.getChild("provider");
			if (providerElement == null) {
				throw new IllegalStateException("No provider element found in projectset file");
			}
			
			List<Element> projectElements = providerElement.getChildren("project");
			for (Element projectElement : projectElements) {
				String reference = projectElement.getAttributeValue("reference");
				if (reference == null) {
					throw new IllegalStateException("No reference attribute found in project element");
				}
				String[] referenceValues = StringUtils.split(reference, ',');
				if (referenceValues.length < 4) {
					throw new IllegalStateException("Unexpected format of reference attribute: " + reference);
				}
				
				String projectName = referenceValues[3];
				
				projectNames.add(projectName);
			}
		}finally{
			if (projectSetFile != null) {
				projectSetFile.close();
			}
		}
	}
	
	public SortedSet<String> getProjectNames() {
		return projectNames;
	}
}