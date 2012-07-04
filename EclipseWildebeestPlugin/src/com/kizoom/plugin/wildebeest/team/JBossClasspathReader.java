package com.kizoom.plugin.wildebeest.team;

import java.io.InputStream;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.jdom.Element;
import org.jdom.input.SAXBuilder;

public class JBossClasspathReader {

	private final SortedSet<String> projectEntries = new TreeSet<String>();
	private final SortedSet<String> ivyEntries = new TreeSet<String>();
	

	@SuppressWarnings("unchecked")
	public JBossClasspathReader(InputStream jbossClasspathFile) throws Exception {
		try  {
			Element classpathElement = new SAXBuilder().build(jbossClasspathFile).getRootElement();
			
			List<Element> projectElements = classpathElement.getChildren("classpathentry");
			for (Element entry : projectElements) {
				String kind = entry.getAttributeValue("kind");
				if (kind == null) {
					throw new IllegalStateException("No kind attribute found in classpathentry element");
				}
				
				
				if ("ivy".equals(kind)) {
					String name = entry.getAttributeValue("name");
					if (name == null) {
						throw new IllegalStateException("No name attribute found in classpathentry element");
					}
					ivyEntries.add(name);
				} else if ("src".equals(kind)){
					String path = entry.getAttributeValue("path");
					if (path == null) {
						throw new IllegalStateException("No path attribute found in classpathentry element");
					}
					if (!"src/java".equals(path) 
							&& !"src/war".equals(path)
							&& !"src/test".equals(path)){
						projectEntries.add(removeSlash(path));
					}
				}
			}
		} finally {
			if (jbossClasspathFile != null) {
				jbossClasspathFile.close();
			}
		}
	}
	
	private String removeSlash(String path) {
		return path.startsWith("/") ? path.substring(1) : path;
	}

	public SortedSet<String> getProjectEntries() {
		return projectEntries;	
	}
	
	public SortedSet<String> getIvyEntries() {
		return ivyEntries;	
	}
}
