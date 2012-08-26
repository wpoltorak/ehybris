package com.lambda.plugin.yunit.view;

import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ILock;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.jdt.core.ElementChangedEvent;
import org.eclipse.jdt.core.IElementChangedListener;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaElementDelta;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.junit.BasicElementLabels;
import org.eclipse.jdt.internal.junit.launcher.ITestKind;
import org.eclipse.jdt.internal.junit.launcher.TestKindRegistry;
import org.eclipse.jdt.internal.junit.model.ITestSessionListener;
import org.eclipse.jdt.internal.junit.model.TestCaseElement;
import org.eclipse.jdt.internal.junit.model.TestElement;
import org.eclipse.jdt.internal.junit.ui.IJUnitHelpContextIds;
import org.eclipse.jdt.internal.junit.ui.JUnitPlugin;
import org.eclipse.jdt.internal.junit.ui.JUnitProgressBar;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorActionBarContributor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.part.EditorActionBarContributor;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.progress.IWorkbenchSiteProgressService;
import org.eclipse.ui.progress.UIJob;

import com.lambda.plugin.YPlugin;
import com.lambda.plugin.YMessages;
import com.lambda.plugin.yunit.IYUnitRunSessionListener;
import com.lambda.plugin.yunit.YUnitRunSession;
import com.lambda.plugin.yunit.preferences.YUnitPreferencesConstants;
import com.lambda.plugin.yunit.view.action.ActivateOnErrorAction;
import com.lambda.plugin.yunit.view.action.RerunLastAction;
import com.lambda.plugin.yunit.view.action.RerunLastFailedOnlyAction;
import com.lambda.plugin.yunit.view.action.ScrollLockAction;
import com.lambda.plugin.yunit.view.action.ShowNextFailureAction;
import com.lambda.plugin.yunit.view.action.ShowPreviousFailureAction;
import com.lambda.plugin.yunit.view.action.ShowTimeAction;
import com.lambda.plugin.yunit.view.action.StopAction;
import com.lambda.plugin.yunit.view.action.ToggleOrientationAction;
import com.lambda.plugin.yunit.view.action.YUnitCopyAction;

@SuppressWarnings("restriction")
public class YUnitView extends ViewPart {
    public static final String NAME = "com.lambda.plugin.yunit.view"; //$NON-NLS-1$

    static final int REFRESH_INTERVAL = 200;

    static final int LAYOUT_FLAT = 0;
    static final int LAYOUT_HIERARCHICAL = 1;

    /**
     * Whether the output scrolls and reveals tests as they are executed.
     */
    protected boolean fAutoScroll = true;
    /**
     * The current orientation; either <code>VIEW_ORIENTATION_HORIZONTAL</code> <code>VIEW_ORIENTATION_VERTICAL</code>, or
     * <code>VIEW_ORIENTATION_AUTOMATIC</code>.
     */
    private int fOrientation = VIEW_ORIENTATION_AUTOMATIC;
    /**
     * The current orientation; either <code>VIEW_ORIENTATION_HORIZONTAL</code> <code>VIEW_ORIENTATION_VERTICAL</code>.
     */
    private int fCurrentOrientation;
    /**
     * The current layout mode (LAYOUT_FLAT or LAYOUT_HIERARCHICAL).
     */
    private int fLayout = LAYOUT_HIERARCHICAL;

    // private boolean fTestIsRunning= false;

    protected JUnitProgressBar fProgressBar;
    protected Image fViewImage;
    protected CounterPanel fCounterPanel;
    protected boolean fShowOnErrorOnly = false;
    protected Clipboard fClipboard;
    protected volatile String fInfoMessage;

    private FailureTrace fFailureTrace;

    private TestViewer fTestViewer;
    /**
     * Is the UI disposed?
     */
    private boolean fIsDisposed = false;

    /**
     * Actions
     */
    private Action fNextAction;
    private Action fPreviousAction;

    private StopAction fStopAction;
    private YUnitCopyAction fCopyAction;

    private RerunLastAction fRerunLastTestAction;
    private RerunLastFailedOnlyAction fRerunFailedAction;

    private Action fFailuresOnlyFilterAction;
    private ScrollLockAction fScrollLockAction;
    private ToggleOrientationAction[] fToggleOrientationActions;
    private ShowTestHierarchyAction fShowTestHierarchyAction;
    private ShowTimeAction fShowTimeAction;
    private ActivateOnErrorAction fActivateOnErrorAction;
    private IMenuListener fViewMenuListener;

    private YUnitRunSession fTestRunSession;
    private TestSessionListener fTestSessionListener;

    private RunnerViewHistory fViewHistory;
    private TestRunSessionListener fTestRunSessionListener;

    // Persistence tags.
    static final String TAG_PAGE = "page"; //$NON-NLS-1$
    static final String TAG_RATIO = "ratio"; //$NON-NLS-1$
    static final String TAG_TRACEFILTER = "tracefilter"; //$NON-NLS-1$ 
    static final String TAG_ORIENTATION = "orientation"; //$NON-NLS-1$
    static final String TAG_SCROLL = "scroll"; //$NON-NLS-1$
    /**
     * @since 3.2
     */
    static final String TAG_LAYOUT = "layout"; //$NON-NLS-1$
    /**
     * @since 3.2
     */
    static final String TAG_FAILURES_ONLY = "failuresOnly"; //$NON-NLS-1$
    /**
     * @since 3.4
     */
    static final String TAG_SHOW_TIME = "time"; //$NON-NLS-1$	

    // orientations
    public static final int VIEW_ORIENTATION_VERTICAL = 0;
    public static final int VIEW_ORIENTATION_HORIZONTAL = 1;
    public static final int VIEW_ORIENTATION_AUTOMATIC = 2;

    private IMemento fMemento;

    Image fOriginalViewImage;
    IElementChangedListener fDirtyListener;

    // private CTabFolder fTabFolder;
    private SashForm fSashForm;

    private Composite fCounterComposite;
    private Composite fParent;

    /**
     * A Job that periodically updates view description, counters, and progress bar.
     */
    private UpdateUIJob fUpdateJob;

    /**
     * A Job that runs as long as a test run is running. It is used to show busyness for running jobs in the view (title in italics).
     */
    private FunctestIsRunningJob fFunctestIsRunningJob;
    private ILock fFunctestIsRunningLock;
    public static final Object FAMILY_JUNIT_RUN = new Object();

    private final IPartListener2 fPartListener = new IPartListener2() {
        public void partActivated(final IWorkbenchPartReference ref) {
        }

        public void partBroughtToTop(final IWorkbenchPartReference ref) {
        }

        public void partInputChanged(final IWorkbenchPartReference ref) {
        }

        public void partClosed(final IWorkbenchPartReference ref) {
        }

        public void partDeactivated(final IWorkbenchPartReference ref) {
        }

        public void partOpened(final IWorkbenchPartReference ref) {
        }

        public void partVisible(final IWorkbenchPartReference ref) {
            if (getSite().getId().equals(ref.getId())) {
                fPartIsVisible = true;
            }
        }

        public void partHidden(final IWorkbenchPartReference ref) {
            if (getSite().getId().equals(ref.getId())) {
                fPartIsVisible = false;
            }
        }
    };

    protected boolean fPartIsVisible = false;

    private class TestRunSessionListener implements IYUnitRunSessionListener {
        public void sessionAdded(final YUnitRunSession testRunSession) {
            if (getSite().getWorkbenchWindow() == YPlugin.getActiveWorkbenchWindow()) {
                final YUnitRunSession deactivatedSession = setActiveTestRunSession(testRunSession);
                if (deactivatedSession != null) {
                    deactivatedSession.swapOut();
                }
                final String testRunLabel = BasicElementLabels.getJavaElementName(fTestRunSession.getTestRunName());
                String msg;
                if (testRunSession.getLaunch() != null) {
                    msg = YMessages.format(YMessages.FunctestView_Launching, new Object[] { testRunLabel });
                } else {
                    msg = testRunLabel;
                }
                setContentDescription(msg);
            }
        }

        public void sessionRemoved(final YUnitRunSession testRunSession) {
            if (testRunSession.equals(fTestRunSession)) {
                final List<YUnitRunSession> testRunSessions = YPlugin.getModel().getFunctestRunSessions();
                YUnitRunSession deactivatedSession;
                if (!testRunSessions.isEmpty()) {
                    deactivatedSession = setActiveTestRunSession(testRunSessions.get(0));
                } else {
                    deactivatedSession = setActiveTestRunSession(null);
                }
                if (deactivatedSession != null) {
                    deactivatedSession.swapOut();
                }
            }
        }
    }

    private class TestSessionListener implements ITestSessionListener {
        public void sessionStarted() {
            fTestViewer.registerViewersRefresh();
            fShowOnErrorOnly = getShowOnErrorOnly();

            startUpdateJobs();

            fStopAction.setEnabled(true);
            fRerunLastTestAction.setEnabled(true);
        }

        public void sessionEnded(final long elapsedTime) {
            fTestViewer.registerAutoScrollTarget(null);

            final String[] keys = { elapsedTimeAsString(elapsedTime) };
            final String msg = YMessages.format(YMessages.FunctestView_message_finish, keys);
            registerInfoMessage(msg);

            postSyncRunnable(new Runnable() {
                public void run() {
                    if (isDisposed()) {
                        return;
                    }
                    fStopAction.setEnabled(false);
                    updateRerunActions();
                    processChangesInUI();
                    if (hasErrorsOrFailures()) {
                        selectFirstFailure();
                    }
                    if (fDirtyListener == null) {
                        fDirtyListener = new DirtyListener();
                        JavaCore.addElementChangedListener(fDirtyListener);
                    }
                    warnOfContentChange();
                }
            });
            stopUpdateJobs();
        }

        public void sessionStopped(final long elapsedTime) {
            fTestViewer.registerAutoScrollTarget(null);

            registerInfoMessage(YMessages.FunctestView_message_stopped);
            handleStopped();
        }

        public void sessionTerminated() {
            fTestViewer.registerAutoScrollTarget(null);

            registerInfoMessage(YMessages.FunctestView_message_terminated);
            handleStopped();
        }

        public void runningBegins() {
            if (!fShowOnErrorOnly) {
                postShowTestResultsView();
            }
        }

        public void testStarted(final TestCaseElement testCaseElement) {
            fTestViewer.registerAutoScrollTarget(testCaseElement);
            fTestViewer.registerViewerUpdate(testCaseElement);

            final String className = BasicElementLabels.getJavaElementName(testCaseElement.getClassName());
            final String method = BasicElementLabels.getJavaElementName(testCaseElement.getTestMethodName());
            final String status = YMessages.format(YMessages.FunctestView_message_started, new String[] { className, method });
            registerInfoMessage(status);
        }

        public void testFailed(final TestElement testElement, final TestElement.Status status, final String trace, final String expected,
                final String actual) {
            if (isAutoScroll()) {
                fTestViewer.registerFailedForAutoScroll(testElement);
            }
            fTestViewer.registerViewerUpdate(testElement);

            // show the view on the first error only
            if (fShowOnErrorOnly && (getErrorsPlusFailures() == 1)) {
                postShowTestResultsView();
            }

            // TODO:
            // [Bug 35590] JUnit window doesn't report errors from
            // junit.extensions.TestSetup [JUnit]
            // when a failure occurs in test setup then no test is running
            // to update the views we artificially signal the end of a test run
            // if (!fTestIsRunning) {
            // fTestIsRunning= false;
            // testEnded(testCaseElement);
            // }
        }

        public void testEnded(final TestCaseElement testCaseElement) {
            fTestViewer.registerViewerUpdate(testCaseElement);
        }

        public void testReran(final TestCaseElement testCaseElement, final TestElement.Status status, final String trace,
                final String expectedResult, final String actualResult) {
            fTestViewer.registerViewerUpdate(testCaseElement); // TODO: autoExpand?
            postSyncProcessChanges();
            showFailure(testCaseElement);
        }

        public void testAdded(final TestElement testElement) {
            fTestViewer.registerTestAdded(testElement);
        }

        public boolean acceptsSwapToDisk() {
            return false;
        }
    }

    public void setShowOnErrorOnly(final boolean showOnErrorOnly) {
        fShowOnErrorOnly = showOnErrorOnly;
    }

    private class UpdateUIJob extends UIJob {
        private boolean fRunning = true;

        public UpdateUIJob(final String name) {
            super(name);
            setSystem(true);
        }

        @Override
        public IStatus runInUIThread(final IProgressMonitor monitor) {
            if (!isDisposed()) {
                processChangesInUI();
            }
            schedule(REFRESH_INTERVAL);
            return Status.OK_STATUS;
        }

        public void stop() {
            fRunning = false;
        }

        @Override
        public boolean shouldSchedule() {
            return fRunning;
        }
    }

    private class FunctestIsRunningJob extends Job {
        public FunctestIsRunningJob(final String name) {
            super(name);
            setSystem(true);
        }

        @Override
        public IStatus run(final IProgressMonitor monitor) {
            // wait until the test run terminates
            fFunctestIsRunningLock.acquire();
            return Status.OK_STATUS;
        }

        @Override
        public boolean belongsTo(final Object family) {
            return family == YUnitView.FAMILY_JUNIT_RUN;
        }
    }

    /**
     * Listen for for modifications to Java elements
     */
    private class DirtyListener implements IElementChangedListener {
        public void elementChanged(final ElementChangedEvent event) {
            processDelta(event.getDelta());
        }

        private boolean processDelta(final IJavaElementDelta delta) {
            final int kind = delta.getKind();
            final int details = delta.getFlags();
            final int type = delta.getElement().getElementType();

            switch (type) {
            // Consider containers for class files.
                case IJavaElement.JAVA_MODEL:
                case IJavaElement.JAVA_PROJECT:
                case IJavaElement.PACKAGE_FRAGMENT_ROOT:
                case IJavaElement.PACKAGE_FRAGMENT:
                    // If we did something different than changing a child we flush the
                    // undo / redo stack.
                    if (kind != IJavaElementDelta.CHANGED || details != IJavaElementDelta.F_CHILDREN) {
                        codeHasChanged();
                        return false;
                    }
                    break;
                case IJavaElement.COMPILATION_UNIT:
                    // if we have changed a primary working copy (e.g created, removed,
                    // ...)
                    // then we do nothing.
                    if ((details & IJavaElementDelta.F_PRIMARY_WORKING_COPY) != 0) {
                        return true;
                    }
                    codeHasChanged();
                    return false;

                case IJavaElement.CLASS_FILE:
                    // Don't examine children of a class file but keep on examining
                    // siblings.
                    return true;
                default:
                    codeHasChanged();
                    return false;
            }

            final IJavaElementDelta[] affectedChildren = delta.getAffectedChildren();
            if (affectedChildren == null) {
                return true;
            }

            for (int i = 0; i < affectedChildren.length; i++) {
                if (!processDelta(affectedChildren[i])) {
                    return false;
                }
            }
            return true;
        }
    }

    private class FailuresOnlyFilterAction extends Action {
        public FailuresOnlyFilterAction() {
            super(YMessages.FunctestView_show_failures_only, AS_CHECK_BOX);
            setToolTipText(YMessages.FunctestView_show_failures_only);
            setImageDescriptor(JUnitPlugin.getImageDescriptor("obj16/failures.gif")); //$NON-NLS-1$
        }

        @Override
        public void run() {
            setShowFailuresOnly(isChecked());
        }
    }

    private class ShowTestHierarchyAction extends Action {

        public ShowTestHierarchyAction() {
            super(YMessages.FunctestView_hierarchical_layout, IAction.AS_CHECK_BOX);
            setImageDescriptor(JUnitPlugin.getImageDescriptor("elcl16/hierarchicalLayout.gif")); //$NON-NLS-1$
        }

        @Override
        public void run() {
            final int mode = isChecked() ? LAYOUT_HIERARCHICAL : LAYOUT_FLAT;
            setLayoutMode(mode);
        }
    }

    @Override
    public void init(final IViewSite site, final IMemento memento) throws PartInitException {
        super.init(site, memento);
        fMemento = memento;
        final IWorkbenchSiteProgressService progressService = getProgressService();
        if (progressService != null) {
            progressService.showBusyForFamily(YUnitView.FAMILY_JUNIT_RUN);
        }
    }

    private IWorkbenchSiteProgressService getProgressService() {
        final Object siteService = getSite().getAdapter(IWorkbenchSiteProgressService.class);
        if (siteService != null) {
            return (IWorkbenchSiteProgressService) siteService;
        }
        return null;
    }

    @Override
    public void saveState(final IMemento memento) {
        if (fSashForm == null) {
            // part has not been created
            if (fMemento != null) {
                memento.putMemento(fMemento);
            }
            return;
        }

        // int activePage= fTabFolder.getSelectionIndex();
        // memento.putInteger(TAG_PAGE, activePage);
        memento.putString(TAG_SCROLL, fScrollLockAction.isChecked() ? "true" : "false"); //$NON-NLS-1$ //$NON-NLS-2$
        final int weigths[] = fSashForm.getWeights();
        final int ratio = (weigths[0] * 1000) / (weigths[0] + weigths[1]);
        memento.putInteger(TAG_RATIO, ratio);
        memento.putInteger(TAG_ORIENTATION, fOrientation);

        memento.putString(TAG_FAILURES_ONLY, fFailuresOnlyFilterAction.isChecked() ? "true" : "false"); //$NON-NLS-1$ //$NON-NLS-2$
        memento.putInteger(TAG_LAYOUT, fLayout);
        memento.putString(TAG_SHOW_TIME, fShowTimeAction.isChecked() ? "true" : "false"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    private void restoreLayoutState(final IMemento memento) {
        // Integer page= memento.getInteger(TAG_PAGE);
        // if (page != null) {
        // int p= page.intValue();
        // if (p < fTestRunTabs.size()) { // tab count can decrease if a
        // contributing plug-in is removed
        // fTabFolder.setSelection(p);
        // fActiveRunTab= (TestRunTab)fTestRunTabs.get(p);
        // }
        // }
        final Integer ratio = memento.getInteger(TAG_RATIO);
        if (ratio != null) {
            fSashForm.setWeights(new int[] { ratio.intValue(), 1000 - ratio.intValue() });
        }
        final Integer orientation = memento.getInteger(TAG_ORIENTATION);
        if (orientation != null) {
            fOrientation = orientation.intValue();
        }
        computeOrientation(fOrientation);
        final String scrollLock = memento.getString(TAG_SCROLL);
        if (scrollLock != null) {
            fScrollLockAction.setChecked(scrollLock.equals("true")); //$NON-NLS-1$
            setAutoScroll(!fScrollLockAction.isChecked());
        }

        final Integer layout = memento.getInteger(TAG_LAYOUT);
        int layoutValue = LAYOUT_HIERARCHICAL;
        if (layout != null) {
            layoutValue = layout.intValue();
        }

        final String failuresOnly = memento.getString(TAG_FAILURES_ONLY);
        boolean showFailuresOnly = false;
        if (failuresOnly != null) {
            showFailuresOnly = failuresOnly.equals("true"); //$NON-NLS-1$
        }

        final String time = memento.getString(TAG_SHOW_TIME);
        boolean showTime = true;
        if (time != null) {
            showTime = time.equals("true"); //$NON-NLS-1$
        }

        setFilterAndLayout(showFailuresOnly, layoutValue);
        setShowExecutionTime(showTime);
    }

    /**
     * Stops the currently running test and shuts down the RemoteTestRunner
     */
    public void stopTest() {
        if (fTestRunSession != null) {
            if (fTestRunSession.isRunning()) {
                setContentDescription(YMessages.FunctestView_message_stopping);
            }
            fTestRunSession.stopTestRun();
        }
    }

    private void startUpdateJobs() {
        postSyncProcessChanges();

        if (fUpdateJob != null) {
            return;
        }
        fFunctestIsRunningJob = new FunctestIsRunningJob(YMessages.FunctestView_wrapperJobName);
        fFunctestIsRunningLock = Job.getJobManager().newLock();
        // acquire lock while a test run is running
        // the lock is released when the test run terminates
        // the wrapper job will wait on this lock.
        fFunctestIsRunningLock.acquire();
        getProgressService().schedule(fFunctestIsRunningJob);

        fUpdateJob = new UpdateUIJob(YMessages.FunctestView_jobName);
        fUpdateJob.schedule(REFRESH_INTERVAL);
    }

    private void stopUpdateJobs() {
        if (fUpdateJob != null) {
            fUpdateJob.stop();
            fUpdateJob = null;
        }
        if (fFunctestIsRunningJob != null && fFunctestIsRunningLock != null) {
            fFunctestIsRunningLock.release();
            fFunctestIsRunningJob = null;
        }
        postSyncProcessChanges();
    }

    private void processChangesInUI() {
        if (fSashForm.isDisposed()) {
            return;
        }

        doShowInfoMessage();
        refreshCounters();

        updateViewIcon();
        final boolean hasErrorsOrFailures = hasErrorsOrFailures();
        fNextAction.setEnabled(hasErrorsOrFailures);
        fPreviousAction.setEnabled(hasErrorsOrFailures);

        fTestViewer.processChangesInUI();
    }

    private void relaunch(final ILaunchConfiguration configuration, final String launchMode) {
        DebugUITools.launch(configuration, launchMode);
    }

    public void setAutoScroll(final boolean scroll) {
        fAutoScroll = scroll;
    }

    public boolean isAutoScroll() {
        return fAutoScroll;
    }

    public void selectNextFailure() {
        fTestViewer.selectFailure(true);
    }

    public void selectPreviousFailure() {
        fTestViewer.selectFailure(false);
    }

    protected void selectFirstFailure() {
        fTestViewer.selectFirstFailure();
    }

    private boolean hasErrorsOrFailures() {
        return getErrorsPlusFailures() > 0;
    }

    private int getErrorsPlusFailures() {
        if (fTestRunSession == null) {
            return 0;
        } else {
            return fTestRunSession.getErrorCount() + fTestRunSession.getFailureCount();
        }
    }

    private String elapsedTimeAsString(final long runTime) {
        return NumberFormat.getInstance().format((double) runTime / 1000);
    }

    private void handleStopped() {
        postSyncRunnable(new Runnable() {
            public void run() {
                if (isDisposed()) {
                    return;
                }
                resetViewIcon();
                fStopAction.setEnabled(false);
                updateRerunActions();
            }
        });
        stopUpdateJobs();
    }

    private void resetViewIcon() {
        fViewImage = fOriginalViewImage;
        firePropertyChange(IWorkbenchPart.PROP_TITLE);
    }

    private void updateViewIcon() {
        if (fTestRunSession == null || fTestRunSession.isStopped() || fTestRunSession.isRunning() || fTestRunSession.getStartedCount() == 0) {
            fViewImage = fOriginalViewImage;
        } else if (hasErrorsOrFailures()) {
            fViewImage = YUnitViewImages.fTestRunFailIcon;
        } else {
            fViewImage = YUnitViewImages.fTestRunOKIcon;
        }
        firePropertyChange(IWorkbenchPart.PROP_TITLE);
    }

    /**
     * @param testRunSession new active test run session
     * @return deactivated session, or <code>null</code> iff no session got deactivated
     */
    YUnitRunSession setActiveTestRunSession(final YUnitRunSession testRunSession) {
        /*
         * - State: fTestRunSession fTestSessionListener Jobs fTestViewer.processChangesInUI(); - UI: fCounterPanel fProgressBar
         * setContentDescription / fInfoMessage setTitleToolTip view icons statusLine fFailureTrace
         * 
         * action enablement
         */
        if (fTestRunSession == testRunSession) {
            return null;
        }

        if (fTestRunSession != null && fTestSessionListener != null) {
            fTestRunSession.removeTestSessionListener(fTestSessionListener);
            fTestSessionListener = null;
        }

        final YUnitRunSession deactivatedSession = fTestRunSession;

        fTestRunSession = testRunSession;
        fTestViewer.registerActiveSession(testRunSession);

        if (fSashForm.isDisposed()) {
            stopUpdateJobs();
            return deactivatedSession;
        }

        if (testRunSession == null) {
            setTitleToolTip(null);
            resetViewIcon();
            clearStatus();
            fFailureTrace.clear();

            registerInfoMessage(" "); //$NON-NLS-1$
            stopUpdateJobs();

            fStopAction.setEnabled(false);
            fRerunFailedAction.setEnabled(false);
            fRerunLastTestAction.setEnabled(false);

        } else {
            fTestSessionListener = new TestSessionListener();
            fTestRunSession.addTestSessionListener(fTestSessionListener);

            setTitleToolTip();

            clearStatus();
            fFailureTrace.clear();
            registerInfoMessage(BasicElementLabels.getJavaElementName(fTestRunSession.getTestRunName()));

            updateRerunActions();
            fRerunLastTestAction.setEnabled(fTestRunSession.getLaunch() != null);

            if (fTestRunSession.isRunning()) {
                startUpdateJobs();

                fStopAction.setEnabled(true);

            } else /* old or fresh session: don't want jobs at this stage */{
                stopUpdateJobs();
                fStopAction.setEnabled(false);
                fTestViewer.expandFirstLevel();
            }
        }
        return deactivatedSession;
    }

    private void updateRerunActions() {
        final boolean state = isJUnit3() && hasErrorsOrFailures() && fTestRunSession.getLaunch() != null;
        fRerunFailedAction.setEnabled(state);
    }

    private boolean isJUnit3() {
        if (fTestRunSession == null) {
            return true; // optimistic
        }

        return TestKindRegistry.JUNIT3_TEST_KIND_ID.equals(fTestRunSession.getTestRunnerKind().getId());
    }

    /**
     * @return the display name of the current test run sessions kind, or <code>null</code>
     */
    public String getTestKindDisplayName() {
        final ITestKind kind = fTestRunSession.getTestRunnerKind();
        if (!kind.isNull()) {
            return kind.getDisplayName();
        }
        return null;
    }

    private void setTitleToolTip() {
        final String testKindDisplayStr = getTestKindDisplayName();

        final String testRunLabel = BasicElementLabels.getJavaElementName(fTestRunSession.getTestRunName());
        if (testKindDisplayStr != null) {
            setTitleToolTip(MessageFormat
                    .format(YMessages.FunctestView_titleToolTip, new String[] { testRunLabel, testKindDisplayStr }));
        } else {
            setTitleToolTip(testRunLabel);
        }
    }

    @Override
    public synchronized void dispose() {
        fIsDisposed = true;
        if (fTestRunSessionListener != null) {
            YPlugin.getModel().removeFunctestRunSessionListener(fTestRunSessionListener);
        }

        final IHandlerService handlerService = (IHandlerService) getSite().getWorkbenchWindow().getService(IHandlerService.class);
        handlerService.deactivateHandler(fRerunLastTestAction.getActivation());
        handlerService.deactivateHandler(fRerunFailedAction.getActivation());
        setActiveTestRunSession(null);

        getViewSite().getPage().removePartListener(fPartListener);

        YUnitViewImages.dispose();

        if (fClipboard != null) {
            fClipboard.dispose();
        }
        if (fViewMenuListener != null) {
            getViewSite().getActionBars().getMenuManager().removeMenuListener(fViewMenuListener);
        }
        if (fDirtyListener != null) {
            JavaCore.removeElementChangedListener(fDirtyListener);
            fDirtyListener = null;
        }
    }

    private void postSyncRunnable(final Runnable r) {
        if (!isDisposed()) {
            getDisplay().syncExec(r);
        }
    }

    private void refreshCounters() {
        // TODO: Inefficient. Either
        // - keep a boolean fHasTestRun and update only on changes, or
        // - improve components to only redraw on changes (once!).

        int startedCount;
        int ignoredCount;
        int totalCount;
        int errorCount;
        int failureCount;
        boolean hasErrorsOrFailures;
        boolean stopped;
        String testServer;

        if (fTestRunSession != null) {
            startedCount = fTestRunSession.getStartedCount();
            ignoredCount = fTestRunSession.getIgnoredCount();
            totalCount = fTestRunSession.getTotalCount();
            errorCount = fTestRunSession.getErrorCount();
            failureCount = fTestRunSession.getFailureCount();
            hasErrorsOrFailures = errorCount + failureCount > 0;
            stopped = fTestRunSession.isStopped();
            testServer = fTestRunSession.getTestServer();
        } else {
            startedCount = 0;
            ignoredCount = 0;
            totalCount = 0;
            errorCount = 0;
            failureCount = 0;
            hasErrorsOrFailures = false;
            stopped = false;
            testServer = "unknown";
        }

        fCounterPanel.setServerValue(testServer);
        fCounterPanel.setTotal(totalCount);
        fCounterPanel.setRunValue(startedCount, ignoredCount);
        fCounterPanel.setErrorValue(errorCount);
        fCounterPanel.setFailureValue(failureCount);

        int ticksDone;
        if (startedCount == 0) {
            ticksDone = 0;
        } else if (startedCount == totalCount && !fTestRunSession.isRunning()) {
            ticksDone = totalCount;
        } else {
            ticksDone = startedCount - 1;
        }

        fProgressBar.reset(hasErrorsOrFailures, stopped, ticksDone, totalCount);
    }

    protected void postShowTestResultsView() {
        postSyncRunnable(new Runnable() {
            public void run() {
                if (isDisposed()) {
                    return;
                }
                showTestResultsView();
            }
        });
    }

    public void showTestResultsView() {
        final IWorkbenchWindow window = getSite().getWorkbenchWindow();
        final IWorkbenchPage page = window.getActivePage();
        YUnitView testRunner = null;
        if (page != null) {
            try { // show the result view
                testRunner = (YUnitView) page.findView(YUnitView.NAME);
                if (testRunner == null) {
                    final IWorkbenchPart activePart = page.getActivePart();
                    testRunner = (YUnitView) page.showView(YUnitView.NAME);
                    // restore focus
                    page.activate(activePart);
                } else {
                    page.bringToTop(testRunner);
                }
            } catch (final PartInitException pie) {
                YPlugin.logError(pie);
            }
        }
    }

    protected void doShowInfoMessage() {
        if (fInfoMessage != null) {
            setContentDescription(fInfoMessage);
            fInfoMessage = null;
        }
    }

    public void registerInfoMessage(final String message) {
        fInfoMessage = message;
    }

    private SashForm createSashForm(final Composite parent) {
        fSashForm = new SashForm(parent, SWT.VERTICAL);

        final ViewForm top = new ViewForm(fSashForm, SWT.NONE);

        final Composite empty = new Composite(top, SWT.NONE);
        empty.setLayout(new Layout() {
            @Override
            protected Point computeSize(final Composite composite, final int wHint, final int hHint, final boolean flushCache) {
                return new Point(1, 1); // (0, 0) does not work with super-intelligent
                // ViewForm
            }

            @Override
            protected void layout(final Composite composite, final boolean flushCache) {
            }
        });
        top.setTopLeft(empty); // makes ViewForm draw the horizontal separator line
        // ...
        fTestViewer = new TestViewer(top, fClipboard, this);
        top.setContent(fTestViewer.getTestViewerControl());

        final ViewForm bottom = new ViewForm(fSashForm, SWT.NONE);

        final CLabel label = new CLabel(bottom, SWT.NONE);
        label.setText(YMessages.FunctestView_label_failure);
        label.setImage(YUnitViewImages.fStackViewIcon);
        bottom.setTopLeft(label);
        final ToolBar failureToolBar = new ToolBar(bottom, SWT.FLAT | SWT.WRAP);
        bottom.setTopCenter(failureToolBar);
        fFailureTrace = new FailureTrace(bottom, fClipboard, this, failureToolBar);
        bottom.setContent(fFailureTrace.getComposite());

        fSashForm.setWeights(new int[] { 50, 50 });
        return fSashForm;
    }

    private void clearStatus() {
        getStatusLine().setMessage(null);
        getStatusLine().setErrorMessage(null);
    }

    @Override
    public void setFocus() {
        if (fTestViewer != null) {
            fTestViewer.getTestViewerControl().setFocus();
        }
    }

    @Override
    public void createPartControl(final Composite parent) {
        fParent = parent;
        addResizeListener(parent);
        fClipboard = new Clipboard(parent.getDisplay());

        final GridLayout gridLayout = new GridLayout();
        gridLayout.marginWidth = 0;
        gridLayout.marginHeight = 0;
        parent.setLayout(gridLayout);

        fViewHistory = new RunnerViewHistory(this, fTestRunSession);
        configureToolBar();

        fCounterComposite = createProgressCountPanel(parent);
        fCounterComposite.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
        final SashForm sashForm = createSashForm(parent);
        sashForm.setLayoutData(new GridData(GridData.FILL_BOTH));

        final IActionBars actionBars = getViewSite().getActionBars();
        fCopyAction = new YUnitCopyAction(fFailureTrace, fClipboard);
        actionBars.setGlobalActionHandler(ActionFactory.COPY.getId(), fCopyAction);

        fOriginalViewImage = getTitleImage();
        PlatformUI.getWorkbench().getHelpSystem().setHelp(parent, IJUnitHelpContextIds.RESULTS_VIEW);

        getViewSite().getPage().addPartListener(fPartListener);

        setFilterAndLayout(false, LAYOUT_HIERARCHICAL);
        setShowExecutionTime(true);
        if (fMemento != null) {
            restoreLayoutState(fMemento);
        }
        fMemento = null;

        fTestRunSessionListener = new TestRunSessionListener();
        YPlugin.getModel().addFunctestRunSessionListener(fTestRunSessionListener);
    }

    public Composite getParent() {
        return fParent;
    }

    private void addResizeListener(final Composite parent) {
        parent.addControlListener(new ControlListener() {
            public void controlMoved(final ControlEvent e) {
            }

            public void controlResized(final ControlEvent e) {
                computeOrientation(fOrientation);
            }
        });
    }

    public void computeOrientation(final int fOrientation) {
        if (fOrientation != VIEW_ORIENTATION_AUTOMATIC) {
            fCurrentOrientation = fOrientation;
            setOrientation(fCurrentOrientation);
        } else {
            final Point size = fParent.getSize();
            if (size.x != 0 && size.y != 0) {
                if (size.x > size.y) {
                    setOrientation(VIEW_ORIENTATION_HORIZONTAL);
                } else {
                    setOrientation(VIEW_ORIENTATION_VERTICAL);
                }
            }
        }
    }

    private void configureToolBar() {
        final IActionBars actionBars = getViewSite().getActionBars();
        final IToolBarManager toolBar = actionBars.getToolBarManager();
        final IMenuManager viewMenu = actionBars.getMenuManager();

        fNextAction = new ShowNextFailureAction(this);
        fNextAction.setEnabled(false);
        actionBars.setGlobalActionHandler(ActionFactory.NEXT.getId(), fNextAction);

        fPreviousAction = new ShowPreviousFailureAction(this);
        fPreviousAction.setEnabled(false);
        actionBars.setGlobalActionHandler(ActionFactory.PREVIOUS.getId(), fPreviousAction);

        fStopAction = new StopAction(this);
        fStopAction.setEnabled(false);
        fRerunLastTestAction = new RerunLastAction(this);
        fRerunFailedAction = new RerunLastFailedOnlyAction(this);
        fFailuresOnlyFilterAction = new FailuresOnlyFilterAction();
        fScrollLockAction = new ScrollLockAction(this);
        fScrollLockAction.setChecked(!fAutoScroll);
        fToggleOrientationActions = new ToggleOrientationAction[] { new ToggleOrientationAction(this, VIEW_ORIENTATION_VERTICAL),
                new ToggleOrientationAction(this, VIEW_ORIENTATION_HORIZONTAL),
                new ToggleOrientationAction(this, VIEW_ORIENTATION_AUTOMATIC) };
        fShowTestHierarchyAction = new ShowTestHierarchyAction();
        fShowTimeAction = new ShowTimeAction(this);

        toolBar.add(fNextAction);
        toolBar.add(fPreviousAction);
        toolBar.add(fFailuresOnlyFilterAction);
        toolBar.add(fScrollLockAction);
        toolBar.add(new Separator());
        toolBar.add(fRerunLastTestAction);
        toolBar.add(fRerunFailedAction);
        toolBar.add(fStopAction);
        toolBar.add(fViewHistory.createHistoryDropDownAction());

        viewMenu.add(fShowTestHierarchyAction);
        viewMenu.add(fShowTimeAction);
        viewMenu.add(new Separator());

        final MenuManager layoutSubMenu = new MenuManager(YMessages.FunctestView_layout_menu);
        for (int i = 0; i < fToggleOrientationActions.length; ++i) {
            layoutSubMenu.add(fToggleOrientationActions[i]);
        }
        viewMenu.add(layoutSubMenu);
        viewMenu.add(new Separator());

        viewMenu.add(fFailuresOnlyFilterAction);

        fActivateOnErrorAction = new ActivateOnErrorAction(this);
        viewMenu.add(fActivateOnErrorAction);
        fViewMenuListener = new IMenuListener() {
            public void menuAboutToShow(final IMenuManager manager) {
                fActivateOnErrorAction.update();
            }
        };

        viewMenu.addMenuListener(fViewMenuListener);

        actionBars.updateActionBars();
    }

    private IStatusLineManager getStatusLine() {
        // we want to show messages globally hence we
        // have to go through the active part
        final IViewSite site = getViewSite();
        final IWorkbenchPage page = site.getPage();
        final IWorkbenchPart activePart = page.getActivePart();

        if (activePart instanceof IViewPart) {
            final IViewPart activeViewPart = (IViewPart) activePart;
            final IViewSite activeViewSite = activeViewPart.getViewSite();
            return activeViewSite.getActionBars().getStatusLineManager();
        }

        if (activePart instanceof IEditorPart) {
            final IEditorPart activeEditorPart = (IEditorPart) activePart;
            final IEditorActionBarContributor contributor = activeEditorPart.getEditorSite().getActionBarContributor();
            if (contributor instanceof EditorActionBarContributor) {
                return ((EditorActionBarContributor) contributor).getActionBars().getStatusLineManager();
            }
        }
        // no active part
        return getViewSite().getActionBars().getStatusLineManager();
    }

    protected Composite createProgressCountPanel(final Composite parent) {
        final Composite composite = new Composite(parent, SWT.NONE);
        final GridLayout layout = new GridLayout();
        composite.setLayout(layout);
        setCounterColumns(layout);

        fCounterPanel = new CounterPanel(composite);
        fCounterPanel.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
        fProgressBar = new JUnitProgressBar(composite);
        fProgressBar.setLayoutData(new GridData(GridData.GRAB_HORIZONTAL | GridData.HORIZONTAL_ALIGN_FILL));
        return composite;
    }

    public void handleTestSelected(final TestElement test) {
        showFailure(test);
        fCopyAction.handleTestSelected(test);
    }

    private void showFailure(final TestElement test) {
        postSyncRunnable(new Runnable() {
            public void run() {
                if (!isDisposed()) {
                    fFailureTrace.showFailure(test);
                }
            }
        });
    }

    public List<IJavaProject> getLaunchedProjects() {
        return fTestRunSession == null ? null : fTestRunSession.getLaunchedProjects();
    }

    private boolean isDisposed() {
        return fIsDisposed || fCounterPanel.isDisposed();
    }

    private Display getDisplay() {
        return getViewSite().getShell().getDisplay();
    }

    /*
     * @see IWorkbenchPart#getTitleImage()
     */
    @Override
    public Image getTitleImage() {
        if (fOriginalViewImage == null) {
            fOriginalViewImage = super.getTitleImage();
        }

        if (fViewImage == null) {
            return super.getTitleImage();
        }
        return fViewImage;
    }

    void codeHasChanged() {
        if (fDirtyListener != null) {
            JavaCore.removeElementChangedListener(fDirtyListener);
            fDirtyListener = null;
        }
        if (fViewImage == YUnitViewImages.fTestRunOKIcon) {
            fViewImage = YUnitViewImages.fTestRunOKDirtyIcon;
        } else if (fViewImage == YUnitViewImages.fTestRunFailIcon) {
            fViewImage = YUnitViewImages.fTestRunFailDirtyIcon;
        }

        final Runnable r = new Runnable() {
            public void run() {
                if (isDisposed()) {
                    return;
                }
                firePropertyChange(IWorkbenchPart.PROP_TITLE);
            }
        };
        if (!isDisposed()) {
            getDisplay().asyncExec(r);
        }
    }

    public boolean isCreated() {
        return fCounterPanel != null;
    }

    public void rerunTest(final String testId, final String className, final String testName, final String launchMode) {
        DebugUITools.saveAndBuildBeforeLaunch();
        try {
            final boolean couldLaunch = fTestRunSession.rerunTest(testId, className, testName, launchMode);
            if (!couldLaunch) {
                MessageDialog.openInformation(getSite().getShell(), YMessages.FunctestView_cannotrerun_title,
                        YMessages.FunctestView_cannotrerurn_message);
            }
        } catch (final CoreException e) {
            ErrorDialog.openError(getSite().getShell(), YMessages.FunctestView_error_cannotrerun, e.getMessage(), e.getStatus());
        }
    }

    public void rerunTests(final List<IJavaElement> elements, final String launchMode) {
        DebugUITools.saveAndBuildBeforeLaunch();
        try {
            final boolean couldLaunch = fTestRunSession.rerunTests(elements, launchMode);
            if (!couldLaunch) {
                MessageDialog.openInformation(getSite().getShell(), YMessages.FunctestView_cannotrerun_title,
                        YMessages.FunctestView_cannotrerurn_message);
            }
        } catch (final CoreException e) {
            ErrorDialog.openError(getSite().getShell(), YMessages.FunctestView_error_cannotrerun, e.getMessage(), e.getStatus());
        }
    }

    private void postSyncProcessChanges() {
        postSyncRunnable(new Runnable() {
            public void run() {
                processChangesInUI();
            }
        });
    }

    public void warnOfContentChange() {
        final IWorkbenchSiteProgressService service = getProgressService();
        if (service != null) {
            service.warnOfContentChange();
        }
    }

    private void setOrientation(final int orientation) {
        if ((fSashForm == null) || fSashForm.isDisposed()) {
            return;
        }
        final boolean horizontal = orientation == VIEW_ORIENTATION_HORIZONTAL;
        fSashForm.setOrientation(horizontal ? SWT.HORIZONTAL : SWT.VERTICAL);
        for (int i = 0; i < fToggleOrientationActions.length; ++i) {
            fToggleOrientationActions[i].setChecked(fOrientation == fToggleOrientationActions[i].getOrientation());
        }
        fCurrentOrientation = orientation;
        final GridLayout layout = (GridLayout) fCounterComposite.getLayout();
        setCounterColumns(layout);
        fParent.layout();
    }

    private void setCounterColumns(final GridLayout layout) {
        if (fCurrentOrientation == VIEW_ORIENTATION_HORIZONTAL) {
            layout.numColumns = 2;
        } else {
            layout.numColumns = 1;
        }
    }

    private static boolean getShowOnErrorOnly() {
        final IPreferenceStore store = YPlugin.getDefault().getPreferenceStore();
        return store.getBoolean(YUnitPreferencesConstants.SHOW_ON_ERROR_ONLY);
    }

    public FailureTrace getFailureTrace() {
        return fFailureTrace;
    }

    void setShowFailuresOnly(final boolean failuresOnly) {
        setFilterAndLayout(failuresOnly, fLayout);
    }

    private void setLayoutMode(final int mode) {
        setFilterAndLayout(fFailuresOnlyFilterAction.isChecked(), mode);
    }

    private void setFilterAndLayout(final boolean failuresOnly, final int layoutMode) {
        fShowTestHierarchyAction.setChecked(layoutMode == LAYOUT_HIERARCHICAL);
        fLayout = layoutMode;
        fFailuresOnlyFilterAction.setChecked(failuresOnly);
        fTestViewer.setShowFailuresOnly(failuresOnly, layoutMode);
    }

    public void setShowExecutionTime(final boolean showTime) {
        fTestViewer.setShowTime(showTime);
    }

    public TestElement[] getAllFailures() {
        return fTestRunSession.getAllFailedTestElements();
    }

    public YUnitRunSession getTestRunSession() {
        return fTestRunSession;
    }

}
