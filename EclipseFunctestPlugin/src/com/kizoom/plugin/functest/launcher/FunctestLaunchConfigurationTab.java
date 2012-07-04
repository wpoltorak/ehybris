package com.kizoom.plugin.functest.launcher;

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

import com.kizoom.plugin.functest.FunctestClasspathProvider;
import com.kizoom.plugin.functest.FunctestMessages;
import com.kizoom.plugin.functest.image.FunctestPluginImages;
import com.kizoom.plugin.functest.ui.JUnitBlock;
import com.kizoom.plugin.functest.ui.SWTFactory;
import com.kizoom.plugin.functest.ui.SelectionBlock;
import com.kizoom.plugin.functest.ui.ServerBlock;

@SuppressWarnings("restriction")
public class FunctestLaunchConfigurationTab extends AbstractLaunchConfigurationTab {

	// TODO FunctestPlugin: warn user when tries to run classes with same package
	// name but from different projects

	private final Image fTestIcon = FunctestPluginImages.DESC_FUNCTEST.createImage();

	private ServerBlock serverBlock;
	private SelectionBlock selectionBlock;
	private JUnitBlock junitBlock;
	private ILaunchConfiguration fLaunchConfiguration;
	private IPropertyChangeListener fListener = new IPropertyChangeListener() {

		public void propertyChange(PropertyChangeEvent event) {
			validatePage();
			updateLaunchConfigurationDialog();
		}

	};

	public FunctestLaunchConfigurationTab() {
	}

	public void createControl(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		setControl(comp);

		GridLayout topLayout = new GridLayout(1, true);
		comp.setLayout(topLayout);

		createServerTypeSection(comp);

		createTestSection(comp);
		Dialog.applyDialogFont(comp);
		validatePage();
	}

	private void createServerTypeSection(Composite comp) {
		Group group = SWTFactory.createGroup(comp, FunctestMessages.FunctestLaunchConfigurationTab_server_group, 3, 1,
				GridData.FILL_HORIZONTAL);
		serverBlock = new ServerBlock();
		serverBlock.addPropertyChangeListener(fListener);
		serverBlock.createControl(group);
	}

	private void createTestSection(Composite comp) {
		Group group = SWTFactory.createGroup(comp, FunctestMessages.FunctestLaunchConfigurationTab_junit_group, 3, 1,
				GridData.FILL_BOTH);
		createTestSelectionGroup(group);
		SWTFactory.createSpacer(group);
		createJUnitGroup(comp);

	}

	private void createJUnitGroup(Composite parent) {
		Composite comp = new Composite(parent, SWT.NONE);
		GridLayout topLayout = new GridLayout(3, false);
		comp.setLayout(topLayout);
		junitBlock = new JUnitBlock();
		junitBlock.addPropertyChangeListener(fListener);
		junitBlock.createControl(comp);
	}

	private void createTestSelectionGroup(Composite comp) {
		selectionBlock = new SelectionBlock();
		selectionBlock.addPropertyChangeListener(fListener);
		selectionBlock.createControl(comp);
	}

	public void initializeFrom(ILaunchConfiguration config) {
		fLaunchConfiguration = config;
		updateServerFromConfig(config);
		updateTestSelectionsFromConfig(config);
		updateTestLoaderFromConfig(config);
		validatePage();
	}

	private void updateTestSelectionsFromConfig(ILaunchConfiguration config) {
		selectionBlock.setInput(config);
	}

	private void updateServerFromConfig(ILaunchConfiguration config) {
		try {
			String server = config.getAttribute(FunctestLaunchConfigurationConstants.ATTR_TEST_SERVER, (String) null);
			serverBlock.setServerType(server);
		} catch (CoreException e) {
			serverBlock.setDefaultServerType();
		}
	}

	private void updateTestLoaderFromConfig(ILaunchConfiguration config) {
		ITestKind testKind = FunctestLaunchConfigurationConstants.getTestRunnerKind(config);
		if (testKind.isNull()){
			testKind = TestKindRegistry.getDefault().getKind(TestKindRegistry.JUNIT3_TEST_KIND_ID);
		}
		junitBlock.setTestKind(testKind);
	}

	public void performApply(ILaunchConfigurationWorkingCopy config) {
		config.setAttribute(FunctestLaunchConfigurationConstants.ATTR_TEST_SERVER, serverBlock.getServerType());
		config.setAttribute(IJavaLaunchConfigurationConstants.ATTR_CLASSPATH_PROVIDER,
				FunctestClasspathProvider.PROVIDER_ID);
		FunctestLaunchConfigurationElements elements = new FunctestLaunchConfigurationElements(selectionBlock
				.getSelectedElements());

		config.setAttribute(FunctestLaunchConfigurationConstants.ATTR_TEST_CONTAINERS, elements.getContainerHandles());
		config.setAttribute(FunctestLaunchConfigurationConstants.ATTR_PROJECT_NAMES, elements.getProjectNames());
		config
				.setAttribute(FunctestLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAMES, elements.getMainTypeQualifiedNames());
		config.setAttribute(FunctestLaunchConfigurationConstants.ATTR_TEST_METHOD_NAMES, elements.getMethodNames());
		ITestKind testKind = junitBlock.getSelectedTestKind();
		if (testKind != null) {
			config.setAttribute(FunctestLaunchConfigurationConstants.ATTR_TEST_RUNNER_KIND, testKind.getId());
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
	public boolean isValid(ILaunchConfiguration config) {
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
		if (fLaunchConfiguration == null)
			return;

		ITestKind testKind = junitBlock.getSelectedTestKind();
		if (testKind == null || TestKindRegistry.JUNIT3_TEST_KIND_ID.equals(testKind.getId()))
			return;
		try {
			String path = fLaunchConfiguration.getAttribute(IJavaLaunchConfigurationConstants.ATTR_JRE_CONTAINER_PATH,
					(String) null);
			if (path != null) {
				IVMInstall vm = JavaRuntime.getVMInstall(Path.fromPortableString(path));
				if (vm instanceof AbstractVMInstall) {
					String compilance = ((AbstractVMInstall) vm).getJavaVersion();
					if (compilance != null && !JUnitStubUtility.is50OrHigher(compilance)) {
						setErrorMessage(FunctestMessages.JUnitLaunchConfigurationTab_error_JDK15_required);
					}
				}
			}
		} catch (CoreException e) {
		}
	}

	public void setDefaults(ILaunchConfigurationWorkingCopy config) {
		List<IJavaElement> javaElements = getContext();
		if (!javaElements.isEmpty()) {
			FunctestLaunchConfigurationElements elems = new FunctestLaunchConfigurationElements(javaElements);
			config.setAttribute(FunctestLaunchConfigurationConstants.ATTR_PROJECT_NAMES, elems.getProjectNames()); 
			config.setAttribute(FunctestLaunchConfigurationConstants.ATTR_TEST_CONTAINERS, elems.getContainerHandles());
			config.setAttribute(FunctestLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAMES, elems.getMainTypeQualifiedNames());
			config.setAttribute(FunctestLaunchConfigurationConstants.ATTR_TEST_METHOD_NAMES, elems.getMethodNames());
		} else {
			config.setAttribute(FunctestLaunchConfigurationConstants.ATTR_PROJECT_NAMES, ""); //$NON-NLS-1$
			config.setAttribute(FunctestLaunchConfigurationConstants.ATTR_TEST_CONTAINERS, ""); //$NON-NLS-1$
			config.setAttribute(FunctestLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAMES, ""); //$NON-NLS-1$
			config.setAttribute(FunctestLaunchConfigurationConstants.ATTR_TEST_METHOD_NAMES, ""); //$NON-NLS-1$
		}
		config.setAttribute(FunctestLaunchConfigurationConstants.ATTR_TEST_SERVER, (String)null);
		
		String name = getLaunchConfigurationDialog().generateName(FunctestLaunchConfigurationConstants.DEFAULT_LAUNCH_CONFIG_NAME);
		config.rename(name);
	}


	
	public String getName() {
		return FunctestMessages.JUnitLaunchConfigurationTab_tab_label;
	}

	private List<IJavaElement> getContext() {
		List<IJavaElement> elems = new ArrayList<IJavaElement>();
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		if (activeWorkbenchWindow == null) {
			return elems;
		}
		IWorkbenchPage page = activeWorkbenchWindow.getActivePage();
		if (page != null) {
			ISelection selection = page.getSelection();
			if (selection instanceof IStructuredSelection) {
				IStructuredSelection ss = (IStructuredSelection) selection;
				if (!ss.isEmpty()) {
					for (Iterator<?> it = ss.iterator(); it.hasNext();){
						Object obj = it.next();
						if (obj instanceof IJavaElement) {
							elems.add((IJavaElement)obj);
						}
					}
					return elems;
				}
			}
			IEditorPart part = page.getActiveEditor();
			if (part != null) {
				IEditorInput input = part.getEditorInput();
				final IJavaElement adapter = (IJavaElement) input.getAdapter(IJavaElement.class);
				if (adapter != null)
					elems.add(adapter);
					return elems;
			}
		}
		return elems;
	}

	@Override
	public String getId() {
		return "com.kizoom.plugin.functest.launcher.FunctestLaunchConfigurationTab"; //$NON-NLS-1$
	}

}
