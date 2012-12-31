package com.lambda.plugin.yunit.launcher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.internal.junit.launcher.ITestKind;
import org.eclipse.jdt.internal.junit.launcher.TestKindRegistry;
import org.eclipse.jdt.internal.junit.util.JUnitStubUtility;
import org.eclipse.jdt.launching.AbstractVMInstall;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import com.lambda.plugin.YMessages;
import com.lambda.plugin.YImages;
import com.lambda.plugin.yunit.YUnitClasspathProvider;
import com.lambda.plugin.yunit.ui.JUnitBlock;
import com.lambda.plugin.yunit.ui.SWTFactory;
import com.lambda.plugin.yunit.ui.SelectionBlock;
import com.lambda.plugin.yunit.ui.ServerBlock;

@SuppressWarnings("restriction")
public class YUnitLaunchConfigurationTab extends AbstractLaunchConfigurationTab {

    // TODO FunctestPlugin: warn user when tries to run classes with same package
    // name but from different projects

    private final Image fTestIcon = YImages.DESC_FUNCTEST.createImage();

    private ServerBlock serverBlock;
    private SelectionBlock selectionBlock;
    private JUnitBlock junitBlock;
    private ILaunchConfiguration fLaunchConfiguration;
    private final IPropertyChangeListener fListener = new IPropertyChangeListener() {

        public void propertyChange(final PropertyChangeEvent event) {
            validatePage();
            updateLaunchConfigurationDialog();
        }

    };

    public YUnitLaunchConfigurationTab() {
    }

    public void createControl(final Composite parent) {
        final Composite comp = new Composite(parent, SWT.NONE);
        setControl(comp);

        final GridLayout topLayout = new GridLayout(1, true);
        comp.setLayout(topLayout);

        createServerTypeSection(comp);

        createTestSection(comp);
        Dialog.applyDialogFont(comp);
        validatePage();
    }

    private void createServerTypeSection(final Composite comp) {
        final Group group = SWTFactory.createGroup(comp, YMessages.FunctestLaunchConfigurationTab_server_group, 3, 1,
                GridData.FILL_HORIZONTAL);
        serverBlock = new ServerBlock();
        serverBlock.addPropertyChangeListener(fListener);
        serverBlock.createControl(group);
    }

    private void createTestSection(final Composite comp) {
        final Group group = SWTFactory
                .createGroup(comp, YMessages.FunctestLaunchConfigurationTab_junit_group, 3, 1, GridData.FILL_BOTH);
        createTestSelectionGroup(group);
        SWTFactory.createSpacer(group);
        createJUnitGroup(comp);

    }

    private void createJUnitGroup(final Composite parent) {
        final Composite comp = new Composite(parent, SWT.NONE);
        final GridLayout topLayout = new GridLayout(3, false);
        comp.setLayout(topLayout);
        junitBlock = new JUnitBlock();
        junitBlock.addPropertyChangeListener(fListener);
        junitBlock.createControl(comp);
    }

    private void createTestSelectionGroup(final Composite comp) {
        selectionBlock = new SelectionBlock();
        selectionBlock.addPropertyChangeListener(fListener);
        selectionBlock.createControl(comp);
    }

    public void initializeFrom(final ILaunchConfiguration config) {
        fLaunchConfiguration = config;
        updateServerFromConfig(config);
        updateTestSelectionsFromConfig(config);
        updateTestLoaderFromConfig(config);
        validatePage();
    }

    private void updateTestSelectionsFromConfig(final ILaunchConfiguration config) {
        selectionBlock.setInput(config);
    }

    private void updateServerFromConfig(final ILaunchConfiguration config) {
        try {
            final String server = config.getAttribute(YUnitLaunchConfigurationConstants.ATTR_TEST_SERVER, (String) null);
            serverBlock.setServerType(server);
        } catch (final CoreException e) {
            serverBlock.setDefaultServerType();
        }
    }

    private void updateTestLoaderFromConfig(final ILaunchConfiguration config) {
        ITestKind testKind = YUnitLaunchConfigurationConstants.getTestRunnerKind(config);
        if (testKind.isNull()) {
            testKind = TestKindRegistry.getDefault().getKind(TestKindRegistry.JUNIT3_TEST_KIND_ID);
        }
        junitBlock.setTestKind(testKind);
    }

    public void performApply(final ILaunchConfigurationWorkingCopy config) {
        config.setAttribute(YUnitLaunchConfigurationConstants.ATTR_TEST_SERVER, serverBlock.getServerType());
        config.setAttribute(IJavaLaunchConfigurationConstants.ATTR_CLASSPATH_PROVIDER, YUnitClasspathProvider.PROVIDER_ID);
        final YUnitLaunchConfigurationElements elements = new YUnitLaunchConfigurationElements(selectionBlock.getSelectedElements());

        config.setAttribute(YUnitLaunchConfigurationConstants.ATTR_TEST_CONTAINERS, elements.getContainerHandles());
        config.setAttribute(YUnitLaunchConfigurationConstants.ATTR_PROJECT_NAMES, elements.getProjectNames());
        config.setAttribute(YUnitLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAMES, elements.getMainTypeQualifiedNames());
        config.setAttribute(YUnitLaunchConfigurationConstants.ATTR_TEST_METHOD_NAMES, elements.getMethodNames());
        final ITestKind testKind = junitBlock.getSelectedTestKind();
        if (testKind != null) {
            config.setAttribute(YUnitLaunchConfigurationConstants.ATTR_TEST_RUNNER_KIND, testKind.getId());
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        fTestIcon.dispose();
        if (selectionBlock != null) {
            selectionBlock.removePropertyChangeListener(fListener);
            selectionBlock.dispose();
        }
        if (junitBlock != null) {
            junitBlock.removePropertyChangeListener(fListener);
            junitBlock.dispose();
        }
        if (serverBlock != null) {
            serverBlock.removePropertyChangeListener(fListener);
            serverBlock.dispose();
        }
    }

    @Override
    public Image getImage() {
        return fTestIcon;
    }

    @Override
    public boolean isValid(final ILaunchConfiguration config) {
        validatePage();
        return getErrorMessage() == null;
    }

    private void validatePage() {

        setErrorMessage(null);
        setMessage(null);
        IStatus status = null;
        status = serverBlock.getStatus();
        if (!status.isOK()) {
            setErrorMessage(status.getMessage());
            return;
        }

        status = selectionBlock.getStatus();
        if (!status.isOK()) {
            setErrorMessage(status.getMessage());
            return;
        }

        status = junitBlock.getStatus();
        if (!status.isOK()) {
            setErrorMessage(status.getMessage());
            return;
        }

        validateTestLoaderJVM();
    }

    private void validateTestLoaderJVM() {
        if (fLaunchConfiguration == null) {
            return;
        }

        final ITestKind testKind = junitBlock.getSelectedTestKind();
        if (testKind == null || TestKindRegistry.JUNIT3_TEST_KIND_ID.equals(testKind.getId())) {
            return;
        }
        try {
            final String path = fLaunchConfiguration.getAttribute(IJavaLaunchConfigurationConstants.ATTR_JRE_CONTAINER_PATH, (String) null);
            if (path != null) {
                final IVMInstall vm = JavaRuntime.getVMInstall(Path.fromPortableString(path));
                if (vm instanceof AbstractVMInstall) {
                    final String compilance = ((AbstractVMInstall) vm).getJavaVersion();
                    if (compilance != null && !JUnitStubUtility.is50OrHigher(compilance)) {
                        setErrorMessage(YMessages.JUnitLaunchConfigurationTab_error_JDK15_required);
                    }
                }
            }
        } catch (final CoreException e) {
        }
    }

    public void setDefaults(final ILaunchConfigurationWorkingCopy config) {
        final List<IJavaElement> javaElements = getContext();
        if (!javaElements.isEmpty()) {
            final YUnitLaunchConfigurationElements elems = new YUnitLaunchConfigurationElements(javaElements);
            config.setAttribute(YUnitLaunchConfigurationConstants.ATTR_PROJECT_NAMES, elems.getProjectNames());
            config.setAttribute(YUnitLaunchConfigurationConstants.ATTR_TEST_CONTAINERS, elems.getContainerHandles());
            config.setAttribute(YUnitLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAMES, elems.getMainTypeQualifiedNames());
            config.setAttribute(YUnitLaunchConfigurationConstants.ATTR_TEST_METHOD_NAMES, elems.getMethodNames());
        } else {
            config.setAttribute(YUnitLaunchConfigurationConstants.ATTR_PROJECT_NAMES, ""); //$NON-NLS-1$
            config.setAttribute(YUnitLaunchConfigurationConstants.ATTR_TEST_CONTAINERS, ""); //$NON-NLS-1$
            config.setAttribute(YUnitLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAMES, ""); //$NON-NLS-1$
            config.setAttribute(YUnitLaunchConfigurationConstants.ATTR_TEST_METHOD_NAMES, ""); //$NON-NLS-1$
        }
        config.setAttribute(YUnitLaunchConfigurationConstants.ATTR_TEST_SERVER, (String) null);

        final String name = getLaunchConfigurationDialog().generateName(YUnitLaunchConfigurationConstants.DEFAULT_LAUNCH_CONFIG_NAME);
        config.rename(name);
    }

    public String getName() {
        return YMessages.JUnitLaunchConfigurationTab_tab_label;
    }

    private List<IJavaElement> getContext() {
        final List<IJavaElement> elems = new ArrayList<IJavaElement>();
        final IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        if (activeWorkbenchWindow == null) {
            return elems;
        }
        final IWorkbenchPage page = activeWorkbenchWindow.getActivePage();
        if (page != null) {
            final ISelection selection = page.getSelection();
            if (selection instanceof IStructuredSelection) {
                final IStructuredSelection ss = (IStructuredSelection) selection;
                if (!ss.isEmpty()) {
                    for (final Iterator<?> it = ss.iterator(); it.hasNext();) {
                        final Object obj = it.next();
                        if (obj instanceof IJavaElement) {
                            elems.add((IJavaElement) obj);
                        }
                    }
                    return elems;
                }
            }
            final IEditorPart part = page.getActiveEditor();
            if (part != null) {
                final IEditorInput input = part.getEditorInput();
                final IJavaElement adapter = (IJavaElement) input.getAdapter(IJavaElement.class);
                if (adapter != null) {
                    elems.add(adapter);
                }
                return elems;
            }
        }
        return elems;
    }

    @Override
    public String getId() {
        return "com.lambda.plugin.yunit.launcher.YUnitLaunchConfigurationTab"; //$NON-NLS-1$
    }

}
