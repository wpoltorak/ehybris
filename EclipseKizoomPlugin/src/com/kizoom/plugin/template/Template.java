package com.kizoom.plugin.template;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Template {

	private final Map<String, File> files;
	private final String baseDir;
	public static final String WEBAPP = "webapp";
	
	public Template(String baseDir) {
		this.files = new HashMap<String, File>();
		this.baseDir = baseDir;
		File file = new File(baseDir);

		retrieveFiles(files, file.getPath(), file.list());
	}

	private void retrieveFiles(Map<String, File> templateFiles, String path, String[] list) {
		if (list == null)
			return;
		for (String string : list) {
			File f = new File(path + File.separator + string);
			if (f.isFile()) {
				templateFiles.put(createProjectRelativePath(f), f);
			} else if (f.isDirectory()) {
				retrieveFiles(templateFiles, f.getPath(), f.list());
			}
		}
	}

	private String createProjectRelativePath(File f) {
		return f.getPath().substring(baseDir.length());
	}

	Map<String, File> getFiles() {
		return files;
	}
}
