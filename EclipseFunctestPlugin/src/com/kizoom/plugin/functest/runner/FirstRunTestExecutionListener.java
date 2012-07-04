package com.kizoom.plugin.functest.runner;

import org.eclipse.jdt.internal.junit.runner.FailedComparison;
import org.eclipse.jdt.internal.junit.runner.IListensToTestExecutions;
import org.eclipse.jdt.internal.junit.runner.ITestIdentifier;
import org.eclipse.jdt.internal.junit.runner.MessageIds;
import org.eclipse.jdt.internal.junit.runner.MessageSender;
import org.eclipse.jdt.internal.junit.runner.TestIdMap;
import org.eclipse.jdt.internal.junit.runner.TestReferenceFailure;

@SuppressWarnings("restriction")
public class FirstRunTestExecutionListener implements IListensToTestExecutions {
	protected MessageSender fSender;

	private TestIdMap fIds;

	FirstRunTestExecutionListener(MessageSender sender, TestIdMap ids) {
		fSender = sender;
		if (ids == null)
			throw new NullPointerException();
		fIds = ids;
	}

	public void notifyTestEnded(ITestIdentifier test) {
		sendMessage(test, MessageIds.TEST_END);
	}

	public void notifyTestFailed(TestReferenceFailure failure) {
		sendMessage(failure.getTest(), failure.getStatus());
		sendFailure(failure, MessageIds.TRACE_START, MessageIds.TRACE_END);
	}

	public void notifyTestStarted(ITestIdentifier test) {
		sendMessage(test, MessageIds.TEST_START);
		fSender.flush();
	}

	private String getTestId(ITestIdentifier test) {
		return fIds.getTestId(test);
	}

	protected void sendFailure(TestReferenceFailure failure, String startTrace, String endTrace) {
		FailedComparison comparison = failure.getComparison();
		if (comparison != null) {
			fSender.sendMessage(MessageIds.EXPECTED_START);
			fSender.sendMessage(comparison.getExpected());
			fSender.sendMessage(MessageIds.EXPECTED_END);

			fSender.sendMessage(MessageIds.ACTUAL_START);
			fSender.sendMessage(comparison.getActual());
			fSender.sendMessage(MessageIds.ACTUAL_END);

		}
		fSender.sendMessage(startTrace);
		fSender.sendMessage(failure.getTrace());
		fSender.sendMessage(endTrace);
		fSender.flush();
	}

	private void sendMessage(ITestIdentifier test, String status) {
		fSender.sendMessage(status + getTestId(test) + ',' + test.getName());
	}

}
