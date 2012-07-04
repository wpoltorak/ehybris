package com.kizoom.plugin.functest.runner;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Vector;

import junit.extensions.TestDecorator;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.eclipse.jdt.internal.junit.runner.ITestPrioritizer;

public class FailuresOnlyPrioritizer implements ITestPrioritizer {

	private HashSet fPriorities;

	public FailuresOnlyPrioritizer(String[] priorities) {
		fPriorities = new HashSet(Arrays.asList(priorities));
	}

	public Test prioritize(Test suite) {
		doPrioritize(suite, new ArrayList());
		return suite;
	}

	private void doPrioritize(Test suite, List path) {
		if (suite instanceof TestCase) {
			TestCase testCase = (TestCase) suite;
			if (!hasPriority(testCase))
				remove(testCase, path);
		} else if (suite instanceof TestSuite) {
			TestSuite aSuite = (TestSuite) suite;
			path.add(suite);
			loopTests(path, aSuite);
			path.remove(path.size() - 1);
		} else if (suite instanceof TestDecorator) {
			TestDecorator aDecorator = (TestDecorator) suite;
			path.add(aDecorator);
			doPrioritize(aDecorator.getTest(), path);
			path.remove(path.size() - 1);
		}
	}

	private void loopTests(List path, TestSuite aSuite) {
		for (Enumeration e = aSuite.tests(); e.hasMoreElements();) {
			doPrioritize((Test) e.nextElement(), path);
		}
	}

	private void remove(Test test, List path) {
		doRemove(test, path, path.size() - 1);
	}

	private void doRemove(Test test, List path, int top) {
		if (top < 0)
			return;
		Test topTest = (Test) path.get(top);
		// only reorder TestSuites
		if (topTest instanceof TestSuite) {
			TestSuite suite = (TestSuite) topTest;
			removeTest(suite, test);
		}
		doRemove(topTest, path, top - 1);
	}

	void removeTest(TestSuite suite, Test test) {
		Vector tests = (Vector) getField(suite, "fTests"); //$NON-NLS-1$
		for (int i = 0; i < tests.size(); i++) {
			if (tests.get(i) == test) {
				tests.remove(i);
				break;
			}
		}
	}

	private boolean hasPriority(TestCase testCase) {
		return fPriorities.contains(testCase.toString());
	}

	public static Object getField(Object object, String fieldName) {
		return getFieldInClass(object, fieldName, object.getClass());
	}

	private static Object getFieldInClass(Object object, String fieldName, Class clazz) {
		Field field = null;
		if (clazz == null)
			return null;
		try {
			field = clazz.getDeclaredField(fieldName);
			field.setAccessible(true);
			return field.get(object);
		} catch (Exception e) {
			// fall through
		}
		return getFieldInClass(object, fieldName, clazz.getSuperclass());
	}
}
