package com.lambda.plugin.yunit.runner;

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

    private final HashSet<String> fPriorities;

    public FailuresOnlyPrioritizer(final String[] priorities) {
        fPriorities = new HashSet<String>(Arrays.asList(priorities));
    }

    public Test prioritize(final Test suite) {
        doPrioritize(suite, new ArrayList<Test>());
        return suite;
    }

    private void doPrioritize(final Test suite, final List<Test> path) {
        if (suite instanceof TestCase) {
            final TestCase testCase = (TestCase) suite;
            if (!hasPriority(testCase)) {
                remove(testCase, path);
            }
        } else if (suite instanceof TestSuite) {
            final TestSuite aSuite = (TestSuite) suite;
            path.add(suite);
            loopTests(path, aSuite);
            path.remove(path.size() - 1);
        } else if (suite instanceof TestDecorator) {
            final TestDecorator aDecorator = (TestDecorator) suite;
            path.add(aDecorator);
            doPrioritize(aDecorator.getTest(), path);
            path.remove(path.size() - 1);
        }
    }

    private void loopTests(final List<Test> path, final TestSuite aSuite) {
        for (final Enumeration<Test> e = aSuite.tests(); e.hasMoreElements();) {
            doPrioritize(e.nextElement(), path);
        }
    }

    private void remove(final Test test, final List<Test> path) {
        doRemove(test, path, path.size() - 1);
    }

    private void doRemove(final Test test, final List<Test> path, final int top) {
        if (top < 0) {
            return;
        }
        final Test topTest = path.get(top);
        // only reorder TestSuites
        if (topTest instanceof TestSuite) {
            final TestSuite suite = (TestSuite) topTest;
            removeTest(suite, test);
        }
        doRemove(topTest, path, top - 1);
    }

    void removeTest(final TestSuite suite, final Test test) {
        final Vector<Test> tests = (Vector) getField(suite, "fTests"); //$NON-NLS-1$
        for (int i = 0; i < tests.size(); i++) {
            if (tests.get(i) == test) {
                tests.remove(i);
                break;
            }
        }
    }

    private boolean hasPriority(final TestCase testCase) {
        return fPriorities.contains(testCase.toString());
    }

    public static Object getField(final Object object, final String fieldName) {
        return getFieldInClass(object, fieldName, object.getClass());
    }

    private static Object getFieldInClass(final Object object, final String fieldName, final Class<?> clazz) {
        Field field = null;
        if (clazz == null) {
            return null;
        }
        try {
            field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(object);
        } catch (final Exception e) {
            // fall through
        }
        return getFieldInClass(object, fieldName, clazz.getSuperclass());
    }
}
