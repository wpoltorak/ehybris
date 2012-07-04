package com.kizoom.plugin.functest.runner;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.jdt.internal.junit.runner.ITestReference;
import org.eclipse.jdt.internal.junit.runner.junit3.JUnit3TestReference;
import org.eclipse.jdt.internal.junit4.runner.JUnit4TestClassReference;
import org.eclipse.jdt.internal.junit4.runner.JUnit4TestMethodReference;

@SuppressWarnings("restriction")
public class FunctestLoader implements IFunctestLoader {
	// JUNIT3
	private static final String SUITE_METHODNAME = "suite"; //$NON-NLS-1$
	private static final String SET_UP_TEST_METHOD_NAME = "setUpTest"; //$NON-NLS-1$

	protected ClassLoader fClassLoader = getClass().getClassLoader();
	private final int junitVersion;

	public FunctestLoader(int junitVersion) {
		System.out.println(fClassLoader.getClass().getName());
		this.junitVersion = junitVersion;
	}

	//TODO FunctestPlugin: 'selected tests' msg in test result (should be class name + selected tests)
	//TODO FunctestPlugin: run history is not working
	public List<ITestReference> loadTests(Map<String, Map<String, List<String>>> projectClassMethodNames,
			Map<String, Map<String, List<String>>> failureNames, RemoteFunctestRunner listener) {
		Collection<Map<String, List<String>>> classNames = projectClassMethodNames.values();
		Collection<Map<String, List<String>>> failureNames1 = failureNames.values();
		if (junitVersion == 3) {
			return loadJunit3Tests(classNames, failureNames1, listener);
		} else if (junitVersion == 4) {
			return loadJunit4Tests(classNames, failureNames1);
		}
		return null;
	}

	public List<ITestReference> loadJunit3Tests(Collection<Map<String, List<String>>> classNames, Collection<Map<String, List<String>>> failureNames, 
			RemoteFunctestRunner listener) {
		// instantiate all tests
		// TODO FunctestPlugin: dodaj do preferencji ktorego junita uzywac
		if (!failureNames.isEmpty()){
			return loadTests(failureNames, listener);
		}
		return loadTests(classNames, listener);
	}

	private List<ITestReference> loadTests(Collection<Map<String, List<String>>> classNames,
			RemoteFunctestRunner listener) {
		List<ITestReference> suites = new ArrayList<ITestReference>(classNames.size());
		for (Map<String, List<String>> map : classNames) {
			for (Entry<String, List<String>> entry : map.entrySet()) {
				String className = entry.getKey();
				try {
					Class<?> testClass = fClassLoader.loadClass(className);
					List<String> methods = entry.getValue();
					Test test = null;
					if (methods != null)
//						if (methods.size() != 1)
							test = getJunit3Test(testClass, methods, listener);
//						else
//							test = setupTest(testClass, createTest(methods.get(0), testClass));
					else
						test = getJunit3Test(testClass, listener);
					suites.add(new JUnit3TestReference(test));
				} catch (ClassNotFoundException e) {
					warning("Could not create test \'" + className + "\' ");
				}
			}
		}
		return suites;
	}

	private Test createTest(String testName, Class<?> testClass) {
		Class<?>[] classArgs = { String.class };
		Test test;
		Constructor<?> constructor = null;
		try {
			try {
				constructor = testClass.getConstructor(classArgs);
				test = (Test) constructor.newInstance(new Object[] { testName });
			} catch (NoSuchMethodException e) {
				// try the no arg constructor supported in 3.8.1
				constructor = testClass.getConstructor(new Class[0]);
				test = (Test) constructor.newInstance(new Object[0]);
				if (test instanceof TestCase)
					((TestCase) test).setName(testName);
			}
			if (test != null)
				return test;
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		} catch (InvocationTargetException e) {
		} catch (NoSuchMethodException e) {
		} catch (ClassCastException e) {
		}
		return warning("Could not create test \'" + testName + "\' "); //$NON-NLS-1$ //$NON-NLS-2$
	}

	private Test setupTest(Class<?> reloadedTestClass, Test reloadedTest) {
		if (reloadedTestClass == null)
			return reloadedTest;

		Method setup = null;
		try {
			setup = reloadedTestClass.getMethod(SET_UP_TEST_METHOD_NAME, new Class[] { Test.class });
		} catch (SecurityException e1) {
			return reloadedTest;
		} catch (NoSuchMethodException e) {
			return reloadedTest;
		}
		if (setup.getReturnType() != Test.class)
			return warning(FunctestMessages.getString("RemoteFunctestRunner_error_notestreturn")); //$NON-NLS-1$
		if (!Modifier.isPublic(setup.getModifiers()))
			return warning(FunctestMessages.getString("RemoteFunctestRunner_error_shouldbepublic")); //$NON-NLS-1$
		if (!Modifier.isStatic(setup.getModifiers()))
			return warning(FunctestMessages.getString("RemoteFunctestRunner_error_shouldbestatic")); //$NON-NLS-1$
		try {
			Test test = (Test) setup.invoke(null, new Object[] { reloadedTest });
			if (test == null)
				return warning(FunctestMessages.getString("RemoteFunctestRunner_error_nullreturn")); //$NON-NLS-1$
			return test;
		} catch (IllegalArgumentException e) {
			return warning(FunctestMessages.getFormattedString("RemoteFunctestRunner_error_couldnotinvoke", e)); //$NON-NLS-1$
		} catch (IllegalAccessException e) {
			return warning(FunctestMessages.getFormattedString("RemoteTestRunner_error_couldnotinvoke", e)); //$NON-NLS-1$
		} catch (InvocationTargetException e) {
			return warning(FunctestMessages.getFormattedString(
					"RemoteTestRunner_error_invocationexception", e.getTargetException())); //$NON-NLS-1$
		}
	}

	public Test getJunit3Test(Class<?> testClass, RemoteFunctestRunner failureListener) {
		Method suiteMethod = null;
		try {
			suiteMethod = testClass.getMethod(FunctestLoader.SUITE_METHODNAME, new Class[0]);
		} catch (Exception e) {
			// try to extract a test suite automatically
			return new TestSuite(testClass);
		}
		if (!Modifier.isStatic(suiteMethod.getModifiers())) {
			return warning(FunctestMessages.getString("RemoteTestRunner_error_suite_notstatic"));//$NON-NLS-1$
		}
		try {
			Test test = (Test) suiteMethod.invoke(null, new Class[0]); // static
			if (test != null) {
				return test;
			}
			return warning(FunctestMessages.getString("RemoteTestRunner_error_suite_nullreturn")); //$NON-NLS-1$
		} catch (InvocationTargetException e) {
			String message = FunctestMessages.getFormattedString(
					"RemoteTestRunner_error_invoke", e.getTargetException().toString()); //$NON-NLS-1$
			failureListener.runFailed(message, e);
			return new TestSuite(testClass);
		} catch (IllegalAccessException e) {
			String message = FunctestMessages.getFormattedString("RemoteTestRunner_error_invoke", e.toString()); //$NON-NLS-1$
			failureListener.runFailed(message, e);
			return new TestSuite(testClass);
		}
	}

	public Test getJunit3Test(Class<?> testClass, List<String> testMethods, RemoteFunctestRunner failureListener) {
//		if (testMethods.size() <= 1)
//			throw new IllegalStateException("I expect more than one test method to run");
		TestSuite testSuite = new TestSuite(testClass.getCanonicalName() + " (selected tests)");
		for (String testMethod : testMethods)
			testSuite.addTest(TestSuite.createTest(testClass, testMethod));
		return testSuite;
	}

	/**
	 * Returns a test which will fail and log a warning message.
	 */
	private Test warning(final String message) {
		return new TestCase("warning") { //$NON-NLS-1$
			@Override
			protected void runTest() {
				fail(message);
			}
		};
	}

	// JUNIT4
	public List<ITestReference> loadJunit4Tests(Collection<Map<String, List<String>>> classNames, Collection<Map<String, List<String>>> failureNames) {
		List<ITestReference> refs = new ArrayList<ITestReference>(classNames.size());
		for (Map<String, List<String>> map : classNames) {
			for (Entry<String, List<String>> entry : map.entrySet()) {
				String className = entry.getKey();
				try {
					Class<?> testClass = fClassLoader.loadClass(className);
					ITestReference ref = createJunit4Test(testClass, entry.getValue());
					refs.add(ref);
				} catch (ClassNotFoundException e) {
					warning("Could not create test \'" + className + "\' "); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
		}
		return refs;
	}

	private ITestReference createJunit4Test(Class<?> clazz, List<String> testNames) {
		if (clazz == null)
			return null;
		if (testNames == null)
			return new JUnit4TestClassReference(clazz);
		// TODO: tylko jeden test z listy odpala sie w junit4
		else if (testNames.size() == 1)
			return new JUnit4TestMethodReference(clazz, testNames.get(0));
		else
			return new JUnit4SelectedTestMethodsReference(clazz, testNames);
	}

	public void setClassLoader(ClassLoader classLoader) {
		fClassLoader = classLoader;
	}

}
