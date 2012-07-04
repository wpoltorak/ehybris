package com.kizoom.plugin.functest.runner;

import org.eclipse.jdt.internal.junit.runner.ITestIdentifier;
import org.eclipse.jdt.internal.junit.runner.MessageIds;
import org.eclipse.jdt.internal.junit.runner.MessageSender;
import org.eclipse.jdt.internal.junit.runner.RemoteTestRunner;
import org.eclipse.jdt.internal.junit.runner.TestIdMap;
import org.eclipse.jdt.internal.junit.runner.TestReferenceFailure;

@SuppressWarnings("restriction")
public class RerunTestExecutionListener extends FirstRunTestExecutionListener {

	public RerunTestExecutionListener(MessageSender sender, TestIdMap ids) {
		super(sender, ids);
	}

	private String fStatus = RemoteTestRunner.RERAN_OK;

	@Override
	public void notifyTestFailed(TestReferenceFailure failure) {
		sendFailure(failure, MessageIds.RTRACE_START, MessageIds.RTRACE_END);

		String status = failure.getStatus();
		if (status.equals(MessageIds.TEST_FAILED))
			fStatus = RemoteTestRunner.RERAN_FAILURE;
		else if (status.equals(MessageIds.TEST_ERROR))
			fStatus = RemoteTestRunner.RERAN_ERROR;
		else
			throw new IllegalArgumentException(status);
	}

	@Override
	public void notifyTestStarted(ITestIdentifier test) {
		// do nothing
	}

	@Override
	public void notifyTestEnded(ITestIdentifier test) {
		// do nothing
	}

	public String getStatus() {
		return fStatus;
	}

}
