package com.lambda.plugin.yunit.runner;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.internal.junit.runner.ITestReference;

@SuppressWarnings("restriction")
public interface IYUnitLoader {

	List<ITestReference> loadTests(
			Map<String, Map<String, List<String>>> projectClassMethodNames,
			Map<String, Map<String, List<String>>> failureNames, RemoteYUnitRunner listener);
}
