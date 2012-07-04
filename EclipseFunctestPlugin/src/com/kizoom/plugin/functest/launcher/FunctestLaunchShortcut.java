package com.kizoom.plugin.functest.launcher;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.debug.ui.IDebugModelPresentation;
import org.eclipse.debug.ui.ILaunchShortcut2;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.ISourceRange;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.junit.launcher.AssertionVMArg;
import org.eclipse.jdt.internal.junit.launcher.TestKindRegistry;
import org.eclipse.jdt.internal.ui.actions.SelectionConverter;
import org.eclipse.jdt.launching.IJavaLaunchConfigurationConstants;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import com.kizoom.plugin.ExceptionHandler;
import com.kizoom.plugin.KizoomPlugin;
import com.kizoom.plugin.functest.FunctestClasspathProvider;
import com.kizoom.plugin.functest.FunctestMessages;
import com.kizoom.plugin.functest.ui.FunctestDialog;
import com.kizoom.plugin.functest.ui.ServerBlock;

public class FunctestLaunchShortcut implements ILaunchShortcut2 {

	protected ILaunchConfigurationWorkingCopy createLaunchConfiguration(List<IJavaElement> elements, String server)
			throws CoreException {
		// String testKindId = TestKindRegistry.getContainerTestKindId(element);
		FunctestLaunchConfigurationElements lce = new FunctestLaunchConfigurationElements(elements);
		ILaunchConfigurationType configType = getLaunchManager().getLaunchConfigurationType(getLaunchConfigurationTypeId());
		ILaunchConfigurationWorkingCopy wc = configType.newInstance(null, getLaunchManager()
				.generateUniqueLaunchConfigurationNameFrom(FunctestLaunchConfigurationConstants.DEFAULT_LAUNCH_CONFIG_NAME));

		// TODO FunctestPlugin: consider getting jre from projects or add
		// property for specifying one in preferences

		String path = JavaRuntime.newDefaultJREContainerPath().toPortableString();
		wc.setAttribute(FunctestLaunchConfigurationConstants.ATTR_TEST_SERVER, server);
		wc.setAttribute(IJavaLaunchConfigurationConstants.ATTR_CLASSPATH_PROVIDER, FunctestClasspathProvider.PROVIDER_ID);
		wc.setAttribute(IJavaLaunchConfigurationConstants.ATTR_JRE_CONTAINER_PATH, path);
		wc.setAttribute(FunctestLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAMES, lce.getMainTypeQualifiedNames());
		wc.setAttribute(FunctestLaunchConfigurationConstants.ATTR_PROJECT_NAMES, lce.getProjectNames());
		wc.setAttribute(FunctestLaunchConfigurationConstants.ATTR_TEST_CONTAINERS, lce.getContainerHandles());
		wc.setAttribute(FunctestLaunchConfigurationConstants.ATTR_TEST_RUNNER_KIND, TestKindRegistry.JUNIT3_TEST_KIND_ID);
		AssertionVMArg.setArgDefault(wc);
		// if (!methodNames.isEmpty()) {
		wc.setAttribute(FunctestLaunchConfigurationConstants.ATTR_TEST_METHOD_NAMES, lce.getMethodNames());
		// }
		return wc;
	}

	protected String getLaunchConfigurationTypeId() {
		return FunctestLaunchConfigurationConstants.ID_FUNCTEST_APPLICATION;
	}

	public void launch(ISelection selection, String mode) {
		if (selection instanceof IStructuredSelection) {
			String server = getServer();
			if (server == null) {
				showNoServerDialog();
				return;
			}
			launch(((IStructuredSelection) selection).toArray(), mode, server);
		} else {
			showNoTestsFoundDialog();
		}
	}

	private String getServer() {
		FunctestDialog functestDialog = new FunctestDialog(getShell());
		functestDialog.open();
		if (functestDialog.getReturnCode() == Window.CANCEL)
			return null;
		return functestDialog.getServer();
	}

	public void launch(ISelection selection, String mode, String server) {
		if (selection instanceof IStructuredSelection) {
			if (server == null) {
				server = getServer();
				if (server == null) {
					return;
				}
			}
			launch(((IStructuredSelection) selection).toArray(), mode, server);
		} else {
			showNoTestsFoundDialog();
		}
	}

	private void launch(Object[] elements, String mode) {
		String server = getServer();
		if (server == null) {
			return;
		}
		launch(elements, mode, server);
	}

	private void launch(Object[] elements, String mode, String server) {
		try {
			List<IJavaElement> elementsToLaunch = FunctestLaunchConfigurationUtils.filterElementsToLaunch(elements);
			if (elementsToLaunch.isEmpty()) {
				return;
			}
			performLaunch(elementsToLaunch, server, mode);
		} catch (InterruptedException e) {
			// OK, silently move on
		} catch (CoreException e) {
			ExceptionHandler.handle(e, getShell(), "Functest Launch",
					"Launching of functional tests unexpectedly failed. Check log for details.");
		} catch (InvocationTargetException e) {
			ExceptionHandler.handle(e, getShell(), "Functest Launch",
					"Launching of functional tests unexpectedly failed. Check log for details.");
		}
	}

	private void performLaunch(List<IJavaElement> elements, String server, String mode) throws InterruptedException,
			CoreException {
		ILaunchConfigurationWorkingCopy temparary = createLaunchConfiguration(elements, server);
		ILaunchConfiguration config = findExistingLaunchConfiguration(temparary);
		if (config == null) {
			// no existing found: create a new one
			config = temparary.doSave();
		}
		DebugUITools.launch(config, mode);
	}

	private ILaunchConfiguration findExistingLaunchConfiguration(ILaunchConfigurationWorkingCopy temporary)
			throws InterruptedException, CoreException {
		ILaunchConfiguration[] candidateConfigs = findExistingLaunchConfigurations(temporary);
		int candidateCount = candidateConfigs.length;
		if (candidateCount == 0) {
			return null;
		} else if (candidateCount == 1) {
			return candidateConfigs[0];
		} else {
			ILaunchConfiguration config = chooseConfiguration(candidateConfigs);
			if (config != null) {
				return config;
			}
		}
		return null;
	}

	private ILaunchConfiguration chooseConfiguration(ILaunchConfiguration[] configList) throws InterruptedException {
		IDebugModelPresentation labelProvider = DebugUITools.newDebugModelPresentation();
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(getShell(), labelProvider);
		dialog.setElements(configList);
		dialog.setTitle(FunctestMessages.FunctestLaunchShortcut_message_selectConfiguration);
		dialog.setMessage(FunctestMessages.FunctestLaunchShortcut_message_selectConfiguration);
		dialog.setMultipleSelection(false);
		int result = dialog.open();
		if (result == Window.OK) {
			return (ILaunchConfiguration) dialog.getFirstResult();
		}
		throw new InterruptedException(); // cancelled by user
	}

	private ILaunchConfiguration[] findExistingLaunchConfigurations(ILaunchConfigurationWorkingCopy temporary)
			throws CoreException {
		ILaunchConfigurationType configType = temporary.getType();

		ILaunchConfiguration[] configs = getLaunchManager().getLaunchConfigurations(configType);
		String[] attributeToCompare = getAttributeNamesToCompare();

		List<ILaunchConfiguration> candidateConfigs = new ArrayList<ILaunchConfiguration>(configs.length);
		for (int i = 0; i < configs.length; i++) {
			ILaunchConfiguration config = configs[i];
			if (hasSameAttributes(config, temporary, attributeToCompare)) {
				candidateConfigs.add(config);
			}
		}
		return candidateConfigs.toArray(new ILaunchConfiguration[candidateConfigs.size()]);
	}

	private ILaunchConfiguration[] findExistingLaunchConfigurations(Object candidate) {
		if (!(candidate instanceof IJavaElement) && candidate instanceof IAdaptable) {
			candidate = ((IAdaptable) candidate).getAdapter(IJavaElement.class);
		}
		try {
			if (candidate instanceof IJavaElement) {
				List<IJavaElement> elementsToLaunch;
				elementsToLaunch = FunctestLaunchConfigurationUtils.filterElementsToLaunch(new Object[] { candidate });
				ILaunchConfigurationWorkingCopy workingCopy = createLaunchConfiguration(elementsToLaunch,
						ServerBlock.TYPE_LOCAL);// hack
				return findExistingLaunchConfigurations(workingCopy);
			}
		} catch (Exception e) {
		}
		return null;
	}

	protected String[] getAttributeNamesToCompare() {
		return new String[] { FunctestLaunchConfigurationConstants.ATTR_TEST_SERVER,
				FunctestLaunchConfigurationConstants.ATTR_TEST_CONTAINERS,
				FunctestLaunchConfigurationConstants.ATTR_PROJECT_NAMES,
				FunctestLaunchConfigurationConstants.ATTR_MAIN_TYPE_NAMES,
				FunctestLaunchConfigurationConstants.ATTR_TEST_METHOD_NAMES };
	}

	private static boolean hasSameAttributes(ILaunchConfiguration config1, ILaunchConfiguration config2,
			String[] attributeToCompare) {
		try {
			for (int i = 0; i < attributeToCompare.length; i++) {
				String val1 = config1.getAttribute(attributeToCompare[i], "");
				String val2 = config2.getAttribute(attributeToCompare[i], "");
				if (!val1.equals(val2)) {
					return false;
				}
			}
			return true;
		} catch (CoreException e) {
			// ignore access problems here, return false
		}
		return false;
	}

	private void showNoTestsFoundDialog() {
		MessageDialog.openInformation(getShell(), "Functest Launch", "No functional tests found.");
		KizoomPlugin.logWarning("No functional tests found.", null);
	}

	private void showNoServerDialog() {
		MessageDialog.openInformation(getShell(), "Functest Launch", "No environment has been selected for functest run.");
		KizoomPlugin.logWarning("No environment has been selected for functest run.", null);
	}

	private Shell getShell() {
		return KizoomPlugin.getActiveWorkbenchShell();
	}

	private ILaunchManager getLaunchManager() {
		return DebugPlugin.getDefault().getLaunchManager();
	}

	public ILaunchConfiguration[] getLaunchConfigurations(ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection ss = (IStructuredSelection) selection;
			if (ss.size() == 1) {
				return findExistingLaunchConfigurations(ss.getFirstElement());
			}
		}
		return null;
	}

	public ILaunchConfiguration[] getLaunchConfigurations(final IEditorPart editorpart) {
		final ITypeRoot element = JavaUI.getEditorInputTypeRoot(editorpart.getEditorInput());
		if (element != null) {
			IMethod selectedMethod = null;
			if (Display.getCurrent() == null) {
				final IMethod[] temp = new IMethod[1];
				Runnable runnable = new Runnable() {
					public void run() {
						temp[0] = resolveSelectedMethodName(editorpart, element);
					}
				};
				Display.getDefault().syncExec(runnable);
				selectedMethod = temp[0];
			} else {
				selectedMethod = resolveSelectedMethodName(editorpart, element);
			}
			Object candidate = element;
			if (selectedMethod != null) {
				candidate = selectedMethod;
			}
			return findExistingLaunchConfigurations(candidate);
		}
		return null;
	}

	public IResource getLaunchableResource(ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection ss = (IStructuredSelection) selection;
			if (ss.size() == 1) {
				Object selected = ss.getFirstElement();
				if (!(selected instanceof IJavaElement) && selected instanceof IAdaptable) {
					selected = ((IAdaptable) selected).getAdapter(IJavaElement.class);
				}
				if (selected instanceof IJavaElement) {
					return ((IJavaElement) selected).getResource();
				}
			}
		}
		return null;
	}

	public IResource getLaunchableResource(IEditorPart editorpart) {
		ITypeRoot element = JavaUI.getEditorInputTypeRoot(editorpart.getEditorInput());
		if (element != null) {
			try {
				return element.getCorrespondingResource();
			} catch (JavaModelException e) {
			}
		}
		return null;
	}

	public void launch(IEditorPart editor, String mode) {
		ITypeRoot element = JavaUI.getEditorInputTypeRoot(editor.getEditorInput());
		if (element != null) {
			IMethod selectedMethod = resolveSelectedMethodName(editor, element);
			if (selectedMethod != null) {
				launch(new Object[] { selectedMethod }, mode);
			} else {
				launch(new Object[] { element }, mode);
			}
		} else {
			showNoTestsFoundDialog();
		}
	}

	private IMethod resolveSelectedMethodName(IEditorPart editor, ITypeRoot element) {
		try {
			ISelectionProvider selectionProvider = editor.getSite().getSelectionProvider();
			if (selectionProvider == null)
				return null;

			ISelection selection = selectionProvider.getSelection();
			if (!(selection instanceof ITextSelection))
				return null;

			ITextSelection textSelection = (ITextSelection) selection;

			IJavaElement elementAtOffset = SelectionConverter.getElementAtOffset(element, textSelection);
			if (!(elementAtOffset instanceof IMethod))
				return null;

			IMethod method = (IMethod) elementAtOffset;

			ISourceRange nameRange = method.getNameRange();
			if (nameRange.getOffset() <= textSelection.getOffset()
					&& textSelection.getOffset() + textSelection.getLength() <= nameRange.getOffset() + nameRange.getLength())
				return method;
		} catch (JavaModelException e) {
			// ignore
		}
		return null;
	}
}
