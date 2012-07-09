package com.lambda.plugin.yunit.view.action;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.action.Action;

import com.lambda.plugin.YPlugin;
import com.lambda.plugin.yunit.YUnitMessages;
import com.lambda.plugin.yunit.YUnitRunSession;
import com.lambda.plugin.yunit.view.RunnerViewHistory;

public class ClearAction extends Action {
	private final RunnerViewHistory history;

	public ClearAction(RunnerViewHistory history) {
		this.history = history;
		setText(YUnitMessages.FunctestView_clear_history_label);

		boolean enabled = false;
		List<YUnitRunSession> testRunSessions = YPlugin.getModel().getFunctestRunSessions();
		for (Iterator<YUnitRunSession> iter = testRunSessions.iterator(); iter.hasNext();) {
			YUnitRunSession testRunSession = iter.next();
			if (!testRunSession.isRunning() && !testRunSession.isStarting()) {
				enabled = true;
				break;
			}
		}
		setEnabled(enabled);
	}

	@Override
	public void run() {
		List<YUnitRunSession> testRunSessions = getRunningSessions();
		Object first = testRunSessions.isEmpty() ? null : testRunSessions.get(0);
		history.setHistoryEntries(testRunSessions, first);
	}

	private List<YUnitRunSession> getRunningSessions() {
		List<YUnitRunSession> testRunSessions = YPlugin.getModel().getFunctestRunSessions();
		for (Iterator<YUnitRunSession> iter = testRunSessions.iterator(); iter.hasNext();) {
			YUnitRunSession testRunSession = iter.next();
			if (!testRunSession.isRunning() && !testRunSession.isStarting()) {
				iter.remove();
			}
		}
		return testRunSessions;
	}
}