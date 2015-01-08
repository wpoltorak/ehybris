package com.lambda.plugin.yunit.launcher;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.jdt.core.IClassFile;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.junit.launcher.ITestKind;
import org.eclipse.jdt.internal.junit.launcher.TestKindRegistry;
import org.eclipse.jdt.internal.junit.model.TestCaseElement;
import org.eclipse.jdt.internal.junit.model.TestElement;
import org.eclipse.jdt.internal.junit.model.TestSuiteElement;
import org.eclipse.jdt.internal.junit.util.TestSearchEngine;

import com.lambda.plugin.YPlugin;

public class YUnitLaunchConfigurationUtils {

    private static final String PROJECT_SEPARATOR = "@";
    private static final String METHOD_SEPARATOR = ":";

    private YUnitLaunchConfigurationUtils() {
    }

    public static String toString(final IJavaElement element) {
        return toString(element, '.');
    }

    public static String toString(final IJavaElement element, final char enclosingTypeSeparator) {
        switch (element.getElementType()) {
            case IJavaElement.JAVA_PROJECT:
            case IJavaElement.PACKAGE_FRAGMENT_ROOT:
            case IJavaElement.PACKAGE_FRAGMENT:
                return element.getHandleIdentifier();
            case IJavaElement.TYPE:
                return ((IType) element).getFullyQualifiedName(enclosingTypeSeparator) + atProject(element);
            case IJavaElement.METHOD:
                return ((IMethod) element).getDeclaringType().getFullyQualifiedName(enclosingTypeSeparator) + withMethod(element)
                        + atProject(element);
            default:
                return null;
        }
    }

    public static String toString(final TestElement element, final char enclosingTypeSeparator) {
        if (element instanceof TestCaseElement) {
            final TestCaseElement testCase = (TestCaseElement) element;
            return testCase.getTestClassName() + withMethod(testCase.getTestMethodName());
        } else if (element instanceof TestSuiteElement) {
            final TestSuiteElement suite = (TestSuiteElement) element;
            return suite.getClassName();
        }
        return null;
    }

    public static String toString(final TestElement element, final IJavaProject project, final char enclosingTypeSeparator) {
        if (element instanceof TestCaseElement) {
            final TestCaseElement testCase = (TestCaseElement) element;
            return testCase.getTestClassName() + withMethod(testCase.getTestMethodName()) + atProject(project);
        } else if (element instanceof TestSuiteElement) {
            final TestSuiteElement suite = (TestSuiteElement) element;
            return suite.getClassName() + atProject(project);
        }
        return null;
    }

    public static void retrieveTestContainers(final List<IJavaElement> elements, final ILaunchConfiguration configuration)
            throws CoreException {
        final String containerHandles = configuration.getAttribute(YUnitLaunchConfigurationConstants.ATTR_TEST_CONTAINERS, ""); //$NON-NLS-1$
        if (containerHandles.length() != 0) {
            final String[] handles = containerHandles.split(",");
            for (final String containerHandle : handles) {
                final IJavaElement element = JavaCore.create(containerHandle);
                if (element != null && element.exists()) {
                    elements.add(element);
                }
            }
        }
    }

    public static void retrieveMainTypeNames(final List<IJavaElement> elements, final ILaunchConfiguration configuration)
            throws CoreException {
        final String testTypeNames = configuration.getAttribute(YUnitLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAMES, ""); //$NON-NLS-1$

        if (testTypeNames.length() != 0) {
            final Map<String, IJavaProject> javaProjects = getJavaProjects(configuration);

            final String[] typeNames = testTypeNames.split(",");
            for (final String typeAndProjectString : typeNames) {
                final String[] projectAndType = YUnitLaunchConfigurationUtils.split(typeAndProjectString);
                if (projectAndType.length == 2) {
                    final String testTypeName = projectAndType[1];
                    final IType type = javaProjects.get(projectAndType[0]).findType(testTypeName);
                    if (type != null && type.exists()) {
                        elements.add(type);
                    }
                }
            }
        }
    }

    public static void retrieveTestMethods(final List<IJavaElement> elements, final ILaunchConfiguration configuration)
            throws CoreException {

        final String testMethodNames = configuration.getAttribute(YUnitLaunchConfigurationConstants.ATTR_TEST_METHOD_NAMES, ""); //$NON-NLS-1$
        if (testMethodNames.length() > 0) {
            final Map<String, IJavaProject> javaProjects = getJavaProjects(configuration);

            final String[] methodNames = testMethodNames.split(",");
            for (final String methodName : methodNames) {
                final String[] projectTypeAndMethod = YUnitLaunchConfigurationUtils.split(methodName);
                if (projectTypeAndMethod.length == 3) {
                    final String testTypeName = projectTypeAndMethod[1];
                    final IType type = javaProjects.get(projectTypeAndMethod[0]).findType(testTypeName);
                    final String testMethodName = projectTypeAndMethod[2];
                    if (type != null && type.exists()) {
                        final IMember member = type.getMethod(testMethodName, new String[0]);
                        if (member != null) {
                            elements.add(member);
                        }
                    }
                }
            }
        }
    }

    public static Map<String, IJavaProject> getJavaProjects(final ILaunchConfiguration configuration) throws CoreException {
        String projectNames = configuration.getAttribute(YUnitLaunchConfigurationConstants.ATTR_PROJECT_NAMES, (String) null);
        final Map<String, IJavaProject> javaProjects = new HashMap<String, IJavaProject>();
        if (projectNames != null) {
            projectNames = projectNames.trim();
            if (projectNames.length() > 0) {
                final String[] names = projectNames.split(",");
                for (final String name : names) {
                    final IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(name);
                    final IJavaProject javaProject = JavaCore.create(project);
                    if (javaProject != null && javaProject.exists()) {
                        javaProjects.put(name, javaProject);
                    }
                }
            }
        }
        return javaProjects;
    }

    public static List<IJavaElement> retrieveJavaElements(final ILaunchConfiguration configuration) throws CoreException {
        final List<IJavaElement> elements = new ArrayList<IJavaElement>();
        retrieveTestContainers(elements, configuration);
        retrieveMainTypeNames(elements, configuration);
        retrieveTestMethods(elements, configuration);
        return elements;
    }

    private static String atProject(final IJavaElement element) {
        if (element != null) {
            return PROJECT_SEPARATOR + element.getJavaProject().getProject().getName();
        }
        return PROJECT_SEPARATOR + "unknownProject";
    }

    private static String withMethod(final IJavaElement element) {
        if (element != null) {
            return withMethod(element.getElementName());
        }
        return withMethod("unkownMethod");
    }

    private static String withMethod(final String name) {
        return METHOD_SEPARATOR + name;
    }

    /**
     * returns [project, class, method] or [project, class]
     * 
     * @param elementString
     * @return
     */
    public static String[] split(final String elementString) {
        int index = -1;
        if (elementString == null || (index = elementString.indexOf(PROJECT_SEPARATOR)) < 0) {
            return new String[] { elementString }; // compilation unit
        }
        final String element = elementString.substring(0, index);
        final String project = elementString.substring(index + 1);
        final String[] packageAndMethod = element.split(METHOD_SEPARATOR);
        if (packageAndMethod.length == 1) {
            // type, project
            return new String[] { project, element };
        }
        // type, method, project
        return new String[] { project, packageAndMethod[0], packageAndMethod[1] };
    }

    public static List<IJavaElement> filterElementsToLaunch(final Object[] elements) throws InterruptedException, InvocationTargetException {
        final List<IJavaElement> elementsToLaunch = new ArrayList<IJavaElement>();
        if (elements == null) {
            return elementsToLaunch;
        }
        for (Object selected : elements) {
            if (!(selected instanceof IJavaElement) && selected instanceof IAdaptable) {
                selected = ((IAdaptable) selected).getAdapter(IJavaElement.class);
            }
            if (selected instanceof IJavaElement) {
                final IJavaElement element = (IJavaElement) selected;
                switch (element.getElementType()) {
                    case IJavaElement.JAVA_PROJECT:
                    case IJavaElement.PACKAGE_FRAGMENT_ROOT:
                    case IJavaElement.PACKAGE_FRAGMENT:
                    case IJavaElement.TYPE:
                    case IJavaElement.METHOD:
                        elementsToLaunch.add(element);
                        break;
                    case IJavaElement.CLASS_FILE:
                        elementsToLaunch.add(((IClassFile) element).getType());
                        break;
                    case IJavaElement.COMPILATION_UNIT:
                        elementsToLaunch.addAll(findTypesToLaunch((ICompilationUnit) element));
                        break;
                }
            }
        }
        return elementsToLaunch;
    }

    private static List<IType> findTypesToLaunch(final ICompilationUnit cu) throws InterruptedException, InvocationTargetException {
        final ITestKind testKind = TestKindRegistry.getContainerTestKind(cu);
        return Arrays.asList(TestSearchEngine.findTests(YPlugin.getActiveWorkbenchWindow(), cu, testKind));
    }
}
