package com.kizoom.plugin.functest.runner;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.junit.runner.IStopListener;
import org.eclipse.jdt.internal.junit.runner.ITestIdentifier;
import org.eclipse.jdt.internal.junit.runner.ITestReference;
import org.eclipse.jdt.internal.junit.runner.IVisitsTestTrees;
import org.eclipse.jdt.internal.junit.runner.TestExecution;
import org.eclipse.jdt.internal.junit4.runner.JUnit4Identifier;
import org.eclipse.jdt.internal.junit4.runner.JUnit4TestListener;
import org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference;
import org.junit.runner.Description;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;
import org.junit.runner.notification.StoppedByUserException;

@SuppressWarnings("restriction")
public class JUnit4SelectedTestMethodsReference implements ITestReference {

	private final Description fDescription;
	private Runner fRunner;

	public JUnit4SelectedTestMethodsReference(Class<?> clazz, List<String> methodNames) {
		if (methodNames.size() <= 1)
			throw new IllegalArgumentException("I expect more than one test method to run");

		fDescription = Description.createSuiteDescription(clazz.getCanonicalName() + " (selected tests)");
		for (String testMethod : methodNames) 
			fDescription.addChild(Description.createTestDescription(clazz, testMethod));
		
		fRunner = methodNames == null ? Request.aClass(clazz).getRunner() : Request.aClass(clazz).filterWith(fDescription)
				.getRunner();

		// fRunner = methodNames == null ? Request.aClass(clazz).getRunner() :
		// Request.aClass(clazz).filterWith(
		// new MethodFilter(clazz, methodNames)).getRunner();
	}

	public int countTestCases() {
		return 1;
	}

	public void sendTree(IVisitsTestTrees notified) {
		notified.visitTreeEntry(getIdentifier(), false, 1);
	}

	public String getName() {
		return fDescription.getDisplayName();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof JUnit4SelectedTestMethodsReference))
			return false;

		JUnit4SelectedTestMethodsReference ref = (JUnit4SelectedTestMethodsReference) obj;
		return (ref.getName().equals(getName()));
	}

	@Override
	public int hashCode() {
		return getName().hashCode();
	}

	@Override
	public String toString() {
		return getName().toString();
	}

	public ITestIdentifier getIdentifier() {
		return new JUnit4Identifier(fDescription);
	}
	
	public void run(TestExecution execution) {
		final RunNotifier notifier= new RunNotifier();
		notifier.addListener(new JUnit4TestListener(execution.getListener()));
		execution.addStopListener(new IStopListener() {
			public void stop() {
				notifier.pleaseStop();
			}
		});

		Result result= new Result();
		RunListener listener= result.createListener();
		notifier.addListener(listener);
		try {
			notifier.fireTestRunStarted(fRunner.getDescription());
			fRunner.run(notifier);
			notifier.fireTestRunFinished(result);
		} catch (StoppedByUserException e) {
			// not interesting, see https://bugs.eclipse.org/329498
		} finally {
			notifier.removeListener(listener);
		}
	}


	class MethodFilter extends Filter {
		private final List<Description> methods;
		private Class<?> clazz;

		public MethodFilter(Class<?> clazz, List<String> methods) {
			this.methods = new ArrayList<Description>(methods.size());
			this.clazz = clazz;
			for (String method : methods)
				this.methods.add(Description.createTestDescription(clazz, method));
		}

		@Override
		public boolean shouldRun(Description description) {
			return description.isTest() && methods.contains(description);
		}

		@Override
		public String describe() {
			return clazz.getCanonicalName() + " (selected tests)";
		}
	}
}
