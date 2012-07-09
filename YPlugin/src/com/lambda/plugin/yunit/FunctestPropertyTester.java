package com.lambda.plugin.yunit;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jdt.core.IClassFile;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.junit.util.TestSearchEngine;

import com.lambda.plugin.YPlugin;

public class FunctestPropertyTester extends PropertyTester {

	public static final String PROPERTY_IS_TEST = "isFunctest"; //$NON-NLS-1$

	public static final String PROPERTY_CAN_LAUNCH_AS_FUNCTEST = "canLaunchAsFunctest"; //$NON-NLS-1$

	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if (!(receiver instanceof IAdaptable)) {
			throw new IllegalArgumentException(
					"Element must be of type 'IAdaptable', is " + receiver == null ? "null" : receiver.getClass().getName()); //$NON-NLS-1$ //$NON-NLS-2$
		}

		IJavaElement element = getJavaElement(receiver);
		if (element == null)
			return false;
		
		boolean hasFunctestNature = YPlugin.getDefault().getFunctestManager().hasFunctestNature(
				element.getJavaProject().getProject());
		if (!hasFunctestNature)
			return false;
		if (PROPERTY_IS_TEST.equals(property)) {
			return isTest(element);
		} else if (PROPERTY_CAN_LAUNCH_AS_FUNCTEST.equals(property)) {
			return canLaunchAsFunctest(element);
		}
		throw new IllegalArgumentException("Unknown test property '" + property + "'"); //$NON-NLS-1$ //$NON-NLS-2$
	}

	private boolean canLaunchAsFunctest(IJavaElement element) {
		try {
			switch (element.getElementType()) {
				case IJavaElement.JAVA_PROJECT:
				case IJavaElement.PACKAGE_FRAGMENT_ROOT:
					return true; // can run, let test runner detect if there are tests
				case IJavaElement.PACKAGE_FRAGMENT:
					return ((IPackageFragment) element).hasChildren();
				case IJavaElement.COMPILATION_UNIT:
				case IJavaElement.CLASS_FILE:
				case IJavaElement.TYPE:
				case IJavaElement.METHOD:
					return isTest(element);
				default:
					return false;
			}
		} catch (JavaModelException e) {
			return false;
		}
	}

	private boolean isTest(IJavaElement element) {
		try {
			// TODO FunctestPlugin: searchEngine finds only primary parent class! won't
			// find class from different project
			IType testType = null;
			if (element instanceof ICompilationUnit) {
				testType = (((ICompilationUnit) element)).findPrimaryType();
			} else if (element instanceof IClassFile) {
				testType = (((IClassFile) element)).getType();
			} else if (element instanceof IType) {
				testType = (IType) element;
			} else if (element instanceof IMember) {
				testType = ((IMember) element).getDeclaringType();
			}
			if (testType != null && testType.exists()) {

				return TestSearchEngine.isTestOrTestSuite(testType);
			}
		} catch (CoreException e) {
			// ignore, return false
		}
		return false;
	}
	
	private IJavaElement getJavaElement(Object receiver) {
		if (receiver instanceof IJavaElement) {
			return (IJavaElement) receiver;
		} else if (receiver instanceof IResource) {
			return JavaCore.create((IResource) receiver);
		} else { // is IAdaptable
			IJavaElement element = (IJavaElement) ((IAdaptable) receiver).getAdapter(IJavaElement.class);
			if (element == null) {
				IResource resource = (IResource) ((IAdaptable) receiver).getAdapter(IResource.class);
				element = JavaCore.create(resource);
			}
			return element;
		}
	}

}
