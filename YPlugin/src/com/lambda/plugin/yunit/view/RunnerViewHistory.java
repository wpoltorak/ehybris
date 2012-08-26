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

import com.lambda.plugin.YPlugin;
import com.lambda.plugin.YMessages;
import com.lambda.plugin.yunit.YUnitRunSession;
import com.lambda.plugin.yunit.preferences.YUnitPreferencesConstants;
import com.lambda.plugin.yunit.view.action.ClearAction;


@SuppressWarnings("restriction")
public class RunnerViewHistory extends ViewHistory {

	private final YUnitView view;
	private final YUnitRunSession session;

	public RunnerViewHistory(YUnitView view, YUnitRunSession session) {
		this.view = view;
		this.session = session;
		initPageSwitcher();
	}

	@Override
	public void configureHistoryListAction(IAction action) {
		action.setText(YMessages.FunctestView_history);
	}

	@Override
	public void configureHistoryDropDownAction(IAction action) {
		action.setToolTipText(YMessages.FunctestView_test_run_history);
		JUnitPlugin.setLocalImageDescriptors(action, "history_list.gif"); //$NON-NLS-1$
	}

	@Override
	public Action getClearAction() {
		return new ClearAction(this);
	}

	@Override
	public String getHistoryListDialogTitle() {
		return YMessages.FunctestView_test_runs;
	}

	@Override
	public String getHistoryListDialogMessage() {
		return YMessages.FunctestView_select_test_run;
	}

	@Override
	public Shell getShell() {
		return view.getParent().getShell();
	}

	@Override
	public List<YUnitRunSession> getHistoryEntries() {
		return YPlugin.getModel().getFunctestRunSessions();
	}

	@Override
	public Object getCurrentEntry() {
		return session;
	}

	@Override
	public void setActiveEntry(Object entry) {
		YUnitRunSession deactivatedSession = view.setActiveTestRunSession((YUnitRunSession) entry);
		if (deactivatedSession != null)
			deactivatedSession.swapOut();
	}

	@Override
	public void setHistoryEntries(List remainingEntries, Object activeEntry) {
		view.setActiveTestRunSession((YUnitRunSession) activeEntry);

		List<YUnitRunSession> testRunSessions = YPlugin.getModel().getFunctestRunSessions();
		testRunSessions.removeAll(remainingEntries);
		for (Iterator<YUnitRunSession> iter = testRunSessions.iterator(); iter.hasNext();) {
			YPlugin.getModel().removeFunctestRunSession(iter.next());
		}
		for (Iterator<YUnitRunSession> iter = remainingEntries.iterator(); iter.hasNext();) {
			YUnitRunSession remaining = iter.next();
			remaining.swapOut();
		}
	}

	@Override
	public ImageDescriptor getImageDescriptor(Object element) {
		YUnitRunSession session = (YUnitRunSession) element;
		if (session.isStopped())
			return YUnitViewImages.fSuiteIconDescriptor;

		if (session.isRunning())
			return YUnitViewImages.fSuiteRunningIconDescriptor;

		Result result = session.getTestResult(true);
		if (result == Result.OK)
			return YUnitViewImages.fSuiteOkIconDescriptor;
		else if (result == Result.ERROR)
			return YUnitViewImages.fSuiteErrorIconDescriptor;
		else if (result == Result.FAILURE)
			return YUnitViewImages.fSuiteFailIconDescriptor;
		else
			return YUnitViewImages.fSuiteIconDescriptor;
	}

	@Override
	public String getText(Object element) {
		YUnitRunSession session = (YUnitRunSession) element;
		String testRunLabel = BasicElementLabels.getJavaElementName(session.getTestRunName());
		if (session.getStartTime() == 0) {
			return testRunLabel;
		} else {
			String startTime = DateFormat.getDateTimeInstance().format(new Date(session.getStartTime()));
			return YMessages.format(YMessages.FunctestView_testName_startTime, new Object[] { testRunLabel,
					startTime });
		}
	}

	@Override
	public void addMenuEntries(MenuManager manager) {
	}

	@Override
	public String getMaxEntriesMessage() {
		return YMessages.FunctestView_max_remembered;
	}

	@Override
	public int getMaxEntries() {
		IPreferenceStore store = YPlugin.getDefault().getPreferenceStore();
		return store.getInt(YUnitPreferencesConstants.MAX_TEST_RUNS);
	}

	@Override
	public void setMaxEntries(int maxEntries) {
		IPreferenceStore store = YPlugin.getDefault().getPreferenceStore();
		store.setValue(YUnitPreferencesConstants.MAX_TEST_RUNS, maxEntries);
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
