package com.kizoom.plugin.functest.view.action;

import java.util.Iterator;
import java.util.List;

import org.eclipse.jface.action.Action;

import com.kizoom.plugin.functest.FunctestMessages;
import com.kizoom.plugin.functest.FunctestPlugin;
import com.kizoom.plugin.functest.FunctestRunSession;
import com.kizoom.plugin.functest.view.RunnerViewHistory;

public class ClearAction extends Action {
	private final RunnerViewHistory history;

	public ClearAction(RunnerViewHistory history) {
		this.history = history;
		setText(FunctestMessages.FunctestView_clear_history_label);

		boolean enabled = false;
		List<FunctestRunSession> testRunSessions = FunctestPlugin.getModel().getFunctestRunSessions();
		for (Iterator<FunctestRunSession> iter = testRunSessions.iterator(); iter.hasNext();) {
			FunctestRunSession testRunSession = iter.next();
			if (!testRunSession.isRunning() && !testRunSession.isStarting()) {
				enabled = true;
				break;
			}
		}
		setEnabled(enabled);
	}

	@Override
	public void run() {
		List<FunctestRunSession> testRunSessions = getRunningSessions();
		Object first = testRunSessions.isEmpty() ? null : testRunSessions.get(0);
		history.setHistoryEntries(testRunSessions, first);
	}

	private List<FunctestRunSession> getRunningSessions() {
		List<FunctestRunSession> testRunSessions = FunctestPlugin.getModel().getFunctestRunSessions();
		for (Iterator<FunctestRunSession> iter = testRunSessions.iterator(); iter.hasNext();) {
			FunctestRunSession testRunSession = iter.next();
			if (!testRunSession.isRunning() && !testRunSession.isStarting()) {
				iter.remove();
			}
		}
		return testRunSessions;
	}
}