package com.lambda.plugin.yunit.view.action;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.jdt.internal.junit.ui.JUnitPlugin;
import org.eclipse.jface.action.Action;
import org.eclipse.ui.handlers.IHandlerActivation;
import org.eclipse.ui.handlers.IHandlerService;

import com.lambda.plugin.YMessages;
import com.lambda.plugin.yunit.launcher.YUnitLaunchConfigurationConstants;
import com.lambda.plugin.yunit.view.YUnitView;

public class RerunLastAction extends Action {
    public static final String RERUN_LAST_COMMAND = "com.lambda.plugin.yunit.launch.shortcut.rerunLast"; //$NON-NLS-1$
    private final YUnitView view;
    private final IHandlerActivation activation;

    public RerunLastAction(final YUnitView view) {
        this.view = view;
        setText(YMessages.FunctestView_rerunaction_label);
        setToolTipText(YMessages.FunctestView_rerunaction_tooltip);
        JUnitPlugin.setLocalImageDescriptors(this, "relaunch.gif"); //$NON-NLS-1$
        setEnabled(false);
        setActionDefinitionId(RERUN_LAST_COMMAND);
        activation = createActivation();
    }

    private IHandlerActivation createActivation() {
        final IHandlerService handlerService = (IHandlerService) view.getSite().getWorkbenchWindow().getService(IHandlerService.class);
        final IHandler handler = new AbstractHandler() {
            public Object execute(final ExecutionEvent event) throws ExecutionException {
                run();
                return null;
            }

            @Override
            public boolean isEnabled() {
                return RerunLastAction.this.isEnabled();
            }
        };
        return handlerService.activateHandler(RerunLastAction.RERUN_LAST_COMMAND, handler);

    }

    @Override
    public void run() {
        rerunTestRun();
    }

    /**
     * Stops the currently running test and shuts down the RemoteTestRunner
     */
    public void rerunTestRun() {
        final ILaunch launch = getLaunch();
        if (launch == null) {
            return;
        }
        final ILaunchConfiguration launchConfiguration = launch.getLaunchConfiguration();
        if (launchConfiguration == null) {
            return;
        }

        final ILaunchConfiguration configuration = prepareLaunchConfigForRelaunch(launchConfiguration);
        DebugUITools.launch(configuration, launch.getLaunchMode());
    }

    private ILaunchConfiguration prepareLaunchConfigForRelaunch(final ILaunchConfiguration configuration) {
        try {
            final String attribute = configuration.getAttribute(YUnitLaunchConfigurationConstants.ATTR_FAILURES_NAMES, ""); //$NON-NLS-1$
            if (attribute.length() != 0) {
                final String configName = YMessages.format(YMessages.FunctestView_configName, configuration.getName());
                final ILaunchConfigurationWorkingCopy tmp = configuration.copy(configName);
                tmp.setAttribute(YUnitLaunchConfigurationConstants.ATTR_FAILURES_NAMES, ""); //$NON-NLS-1$
                return tmp;
            }
        } catch (final CoreException e) {
            // fall through
        }
        return configuration;
    }

    public IHandlerActivation getActivation() {
        return activation;
    }

    public ILaunch getLaunch() {
        if (view.getTestRunSession() == null) {
            return null;
        }
        return view.getTestRunSession().getLaunch();
    }

}