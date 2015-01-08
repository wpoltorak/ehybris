package com.lambda.plugin.preferences;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.internal.ui.SWTFactory;
import org.eclipse.jdt.core.IJavaModel;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.debug.ui.IJavaDebugUIConstants;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PlatformUI;

import com.lambda.plugin.YMessages;
import com.lambda.plugin.YPlugin;
import com.lambda.plugin.core.IPlatformInstallation;

@Deprecated
public class PlatformPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

    public static final String ID = "com.lambda.plugin.preferences.PlatformPreferencePage"; //$NON-NLS-1$

    private PlatformBlock platformBlock;

    /**
     * Constructor
     */
    public PlatformPreferencePage() {
        super(YMessages.PlatformPreferencePage_Title);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
     */
    @Override
    public void init(IWorkbench workbench) {
    }

    /**
     * Find & verify the default platform
     */
    private void initDefaultPlatform() {
        verifyDefaultPlatform(YPlugin.getDefault().getDefaultPlatform());
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.preference.PreferencePage#createContents(org.eclipse.swt.widgets.Composite)
     */
    @Override
    protected Control createContents(Composite ancestor) {
        initializeDialogUnits(ancestor);

        noDefaultAndApplyButton();

        GridLayout layout = new GridLayout();
        layout.numColumns = 1;
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        ancestor.setLayout(layout);

        SWTFactory.createWrapLabel(ancestor, YMessages.PlatformPreferencePage_Description, 1, 300);
        SWTFactory.createVerticalSpacer(ancestor, 1);

        platformBlock = new PlatformBlock();
        platformBlock.createControl(ancestor);
        Control control = platformBlock.getControl();
        GridData data = new GridData(GridData.FILL_BOTH);
        data.horizontalSpan = 1;
        control.setLayoutData(data);

        platformBlock.restoreColumnSettings(YPlugin.getDefault().getDialogSettings(),
                PreferenceConstants.PLATFORMS_PREFERENCE_PAGE);

        PlatformUI.getWorkbench().getHelpSystem().setHelp(ancestor, PreferenceConstants.PLATFORMS_PREFERENCE_PAGE);
        initDefaultPlatform();
        platformBlock.addSelectionChangedListener(new ISelectionChangedListener() {
            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                IPlatformInstallation install = getCurrentDefaultPlatform();
                if (install == null) {
                    setValid(false);
                    setErrorMessage(YMessages.PlatformPreferencePage_ErrorNoDefaultPlatform);
                } else {
                    // if we change the VM make sure the compliance level supports
                    // generated class files
                    setValid(true);
                    setMessage(null);
                    setErrorMessage(null);
                }
            }
        });
        applyDialogFont(ancestor);
        return ancestor;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.preference.IPreferencePage#performOk()
     */
    @Override
    public boolean performOk() {
        final boolean[] canceled = new boolean[] { false };
        BusyIndicator.showWhile(null, new Runnable() {
            @Override
            public void run() {
                IPlatformInstallation defaultPlatform = getCurrentDefaultPlatform();
                IPlatformInstallation[] platforms = platformBlock.getPlatforms();
                if (!YPlugin.getDefault().getPlatformContainer()
                        .updatePlatformConfiguration(defaultPlatform, platforms)) {
                    canceled[0] = true;
                }
            }
        });

        if (canceled[0]) {
            return false;
        }

        // save column widths
        IDialogSettings settings = YPlugin.getDefault().getDialogSettings();
        platformBlock.saveColumnSettings(settings, PreferenceConstants.PLATFORMS_PREFERENCE_PAGE);

        return super.performOk();
    }

    protected IJavaModel getJavaModel() {
        return JavaCore.create(ResourcesPlugin.getWorkspace().getRoot());
    }

    /**
     * Verify that the specified VM can be a valid default VM. This amounts to verifying that all of the VM's library
     * locations exist on the file system. If this fails, remove the VM from the table and try to set another default.
     */
    private void verifyDefaultPlatform(IPlatformInstallation platform) {
        if (platform != null) {
            // Verify that all of the specified platform's library/properties locations actually exist
            boolean ok = YPlugin.getDefault().getPlatformContainer().verifyPlatform(platform);

            // If all library locations exist, check the corresponding entry in the list,
            // otherwise remove the platform
            if (ok) {
                platformBlock.setCheckedPlatform(platform);
            } else {
                platformBlock.removePlatforms(new IPlatformInstallation[] { platform });
                platformBlock.setCheckedPlatform(null);
                ErrorDialog.openError(getControl().getShell(), YMessages.PlatformPreferencePage_Title,
                        YMessages.PlatformPreferencePage_ErrorPlatformNotExists, new Status(IStatus.ERROR,
                                YPlugin.PLUGIN_ID, IJavaDebugUIConstants.INTERNAL_ERROR, "Platform removed", null)); //   //$NON-NLS-1$
                return;
            }
        } else {
            platformBlock.setCheckedPlatform(null);
        }
    }

    private IPlatformInstallation getCurrentDefaultPlatform() {
        return platformBlock.getCheckedPlatform();
    }

}