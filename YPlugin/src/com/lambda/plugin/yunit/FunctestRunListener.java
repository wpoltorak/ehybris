package com.lambda.plugin.yunit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.jdt.junit.TestRunListener;
import org.eclipse.jdt.junit.model.ITestCaseElement;
import org.eclipse.jdt.junit.model.ITestElement;
import org.eclipse.jdt.junit.model.ITestRunSession;
import org.eclipse.jdt.junit.model.ITestElement.Result;

public class FunctestRunListener extends TestRunListener {

	private Map<String, List<String>> failedTests = new TreeMap<String, List<String>>();

	public Map<String, List<String>> getFailedTests() {
		return failedTests;
	}

	@Override
	public void testCaseFinished(final ITestCaseElement testCaseElement) {
		Result result = testCaseElement.getTestResult(false);
		if (result == ITestElement.Result.ERROR || result == ITestElement.Result.FAILURE) {
			String testClassName = testCaseElement.getTestClassName();
			List<String> methods = failedTests.get(testClassName);
			if (methods == null) {
				methods = new ArrayList<String>();
				failedTests.put(testClassName, methods);
			}
			methods.add(testCaseElement.getTestMethodName());
		}
	}

	@Override
	public void testCaseStarted(ITestCaseElement testCaseElement) {
	}

	@Override
	public void sessionFinished(ITestRunSession session) {
	}

	@Override
	public void sessionStarted(ITestRunSession session) {
		failedTests.clear();
	}
}
