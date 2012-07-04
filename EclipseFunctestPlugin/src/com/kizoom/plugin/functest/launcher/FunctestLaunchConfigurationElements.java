package com.kizoom.plugin.functest.launcher;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.jdt.core.IJavaElement;

public class FunctestLaunchConfigurationElements {

	private Set<String> projectNames = new TreeSet<String>();
	private Set<String> containerHandles = new TreeSet<String>();
	private Set<String> mainTypeQualifiedNames = new TreeSet<String>();
	private Set<String> methodNames = new TreeSet<String>();

	public FunctestLaunchConfigurationElements(List<? extends IJavaElement> elements) {
		init(elements);
	}

	private void init(List<? extends IJavaElement> elements) {

		for (IJavaElement element : elements) {
			projectNames.add(element.getJavaProject().getElementName());
			switch (element.getElementType()) {
				case IJavaElement.JAVA_PROJECT:
				case IJavaElement.PACKAGE_FRAGMENT_ROOT:
				case IJavaElement.PACKAGE_FRAGMENT:
					containerHandles.add(FunctestLaunchConfigurationUtils.toString(element));
					break;
				case IJavaElement.TYPE:
					mainTypeQualifiedNames.add(FunctestLaunchConfigurationUtils.toString(element));
					// don't replace, fix for binary inner types
					break;
				case IJavaElement.METHOD:
					methodNames.add(FunctestLaunchConfigurationUtils.toString(element));
					break;
				default:
					throw new IllegalArgumentException(
							"Invalid element type to create a launch configuration: " + element.getClass().getName()); //$NON-NLS-1$
			}
		}
	}

	private static String toString(Collection<String> elements) {
		StringBuffer buf = new StringBuffer();
		for (String string : elements) {
			buf.append(string).append(",");
		}
		if (buf.length() > 0)
			buf.deleteCharAt(buf.length() - 1);
		return buf.toString();
	}

	public String getProjectNames() {
		return toString(projectNames);
	}

	public String getContainerHandles() {
		return toString(containerHandles);
	}

	public String getMainTypeQualifiedNames() {
		return toString(mainTypeQualifiedNames);
	}

	public String getMethodNames() {
		return toString(methodNames);
	}
}
