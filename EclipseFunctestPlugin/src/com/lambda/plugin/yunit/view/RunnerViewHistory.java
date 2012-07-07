package com.lambda.plugin.yunit.view;

import java.text.DateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.internal.junit.BasicElementLabels;
import org.eclipse.jdt.internal.junit.ui.JUnitPlugin;
import org.eclipse.jdt.internal.ui.viewsupport.ViewHistory;
import org.eclipse.jdt.junit.model.ITestElement.Result;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.part.PageSwitcher;

import com.lambda.plugin.yunit.FunctestMessages;
import com.lambda.plugin.yunit.FunctestPlugin;
import com.lambda.plugin.yunit.FunctestRunSession;
import com.lambda.plugin.yunit.preferences.FunctestPreferencesConstants;
import com.lambda.plugin.yunit.view.action.ClearAction;


@SuppressWarnings("restriction")
public class RunnerViewHistory extends ViewHistory {

	private final FunctestView view;
	private final FunctestRunSession session;

	public RunnerViewHistory(FunctestView view, FunctestRunSession session) {
		this.view = view;
		this.session = session;
		initPageSwitcher();
	}

	@Override
	public void configureHistoryListAction(IAction action) {
		action.setText(FunctestMessages.FunctestView_history);
	}

	@Override
	public void configureHistoryDropDownAction(IAction action) {
		action.setToolTipText(FunctestMessages.FunctestView_test_run_history);
		JUnitPlugin.setLocalImageDescriptors(action, "history_list.gif"); //$NON-NLS-1$
	}

	@Override
	public Action getClearAction() {
		return new ClearAction(this);
	}

	@Override
	public String getHistoryListDialogTitle() {
		return FunctestMessages.FunctestView_test_runs;
	}

	@Override
	public String getHistoryListDialogMessage() {
		return FunctestMessages.FunctestView_select_test_run;
	}

	@Override
	public Shell getShell() {
		return view.getParent().getShell();
	}

	@Override
	public List<FunctestRunSession> getHistoryEntries() {
		return FunctestPlugin.getModel().getFunctestRunSessions();
	}

	@Override
	public Object getCurrentEntry() {
		return session;
	}

	@Override
	public void setActiveEntry(Object entry) {
		FunctestRunSession deactivatedSession = view.setActiveTestRunSession((FunctestRunSession) entry);
		if (deactivatedSession != null)
			deactivatedSession.swapOut();
	}

	@Override
	public void setHistoryEntries(List remainingEntries, Object activeEntry) {
		view.setActiveTestRunSession((FunctestRunSession) activeEntry);

		List<FunctestRunSession> testRunSessions = FunctestPlugin.getModel().getFunctestRunSessions();
		testRunSessions.removeAll(remainingEntries);
		for (Iterator<FunctestRunSession> iter = testRunSessions.iterator(); iter.hasNext();) {
			FunctestPlugin.getModel().removeFunctestRunSession(iter.next());
		}
		for (Iterator<FunctestRunSession> iter = remainingEntries.iterator(); iter.hasNext();) {
			FunctestRunSession remaining = iter.next();
			remaining.swapOut();
		}
	}

	@Override
	public ImageDescriptor getImageDescriptor(Object element) {
		FunctestRunSession session = (FunctestRunSession) element;
		if (session.isStopped())
			return FunctestViewImages.fSuiteIconDescriptor;

		if (session.isRunning())
			return FunctestViewImages.fSuiteRunningIconDescriptor;

		Result result = session.getTestResult(true);
		if (result == Result.OK)
			return FunctestViewImages.fSuiteOkIconDescriptor;
		else if (result == Result.ERROR)
			return FunctestViewImages.fSuiteErrorIconDescriptor;
		else if (result == Result.FAILURE)
			return FunctestViewImages.fSuiteFailIconDescriptor;
		else
			return FunctestViewImages.fSuiteIconDescriptor;
	}

	@Override
	public String getText(Object element) {
		FunctestRunSession session = (FunctestRunSession) element;
		String testRunLabel = BasicElementLabels.getJavaElementName(session.getTestRunName());
		if (session.getStartTime() == 0) {
			return testRunLabel;
		} else {
			String startTime = DateFormat.getDateTimeInstance().format(new Date(session.getStartTime()));
			return FunctestMessages.format(FunctestMessages.FunctestView_testName_startTime, new Object[] { testRunLabel,
					startTime });
		}
	}

	@Override
	public void addMenuEntries(MenuManager manager) {
	}

	@Override
	public String getMaxEntriesMessage() {
		return FunctestMessages.FunctestView_max_remembered;
	}

	@Override
	public int getMaxEntries() {
		IPreferenceStore store = FunctestPlugin.getDefault().getPreferenceStore();
		return store.getInt(FunctestPreferencesConstants.MAX_TEST_RUNS);
	}

	@Override
	public void setMaxEntries(int maxEntries) {
		IPreferenceStore store = FunctestPlugin.getDefault().getPreferenceStore();
		store.setValue(FunctestPreferencesConstants.MAX_TEST_RUNS, maxEntries);
	}

	private void initPageSwitcher() {
		new PageSwitcher(view) {
			@Override
			public Object[] getPages() {
				return getHistoryEntries().toArray();
			}

			@Override
			public String getName(Object page) {
				return getText(page);
			}

			@Override
			public ImageDescriptor getImageDescriptor(Object page) {
				return getImageDescriptor(page);
			}

			@Override
			public void activatePage(Object page) {
				setActiveEntry(page);
			}

			@Override
			public int getCurrentPageIndex() {
				return getHistoryEntries().indexOf(getCurrentEntry());
			}
		};
	}

}
