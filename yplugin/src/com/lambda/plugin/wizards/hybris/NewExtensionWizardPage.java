package com.lambda.plugin.wizards.hybris;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaConventions;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.corext.util.JavaConventionsUtil;
import org.eclipse.jdt.internal.corext.util.Messages;
import org.eclipse.jdt.internal.ui.IJavaHelpContextIds;
import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.dialogs.StatusInfo;
import org.eclipse.jdt.internal.ui.packageview.PackageExplorerPart;
import org.eclipse.jdt.internal.ui.preferences.CompliancePreferencePage;
import org.eclipse.jdt.internal.ui.preferences.NewJavaProjectPreferencePage;
import org.eclipse.jdt.internal.ui.preferences.PropertyAndPreferencePage;
import org.eclipse.jdt.internal.ui.refactoring.contentassist.JavaPackageCompletionProcessor;
import org.eclipse.jdt.internal.ui.util.CoreUtility;
import org.eclipse.jdt.internal.ui.util.ExceptionHandler;
import org.eclipse.jdt.internal.ui.viewsupport.BasicElementLabels;
import org.eclipse.jdt.internal.ui.wizards.NewWizardMessages;
import org.eclipse.jdt.internal.ui.wizards.buildpaths.BuildPathSupport;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.DialogField;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.IDialogFieldListener;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.IStringButtonAdapter;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.LayoutUtil;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.SelectionButtonDialogField;
import org.eclipse.jdt.internal.ui.wizards.dialogfields.StringButtonDialogField;
import org.eclipse.jdt.internal.ui.workingsets.IWorkingSetIDs;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jdt.ui.PreferenceConstants;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyDelegatingOperation;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.dialogs.WorkingSetConfigurationBlock;

import com.lambda.plugin.YMessages;
import com.lambda.plugin.utils.StringUtils;

public class NewExtensionWizardPage extends WizardPage {

    private static final String FILENAME_PROJECT = ".project"; //$NON-NLS-1$
    private static final String FILENAME_CLASSPATH = ".classpath"; //$NON-NLS-1$

    /**
     * Request a project name and default package. Fires an event whenever the text field is changed, regardless of its
     * content.
     */
    private final class NamePackageGroup extends Observable {

        private Label fLabel;
        private Label fPackageLabel;
        private final String fLabelText = YMessages.NewExtensionPage_NamePackageGroup_label_text;
        private final String fPackageLabelText = YMessages.NewExtensionPage_NamePackageGroup_package_label;
        private Text fTextControl;
        private Text fPackageTextControl;
        private final ModifyListener fModifyListener;
        private String fText;
        private String fPackageText;

        public NamePackageGroup() {
            fText = "";
            fPackageText = "";
            fModifyListener = new ModifyListener() {
                public void modifyText(ModifyEvent e) {
                    if (e.getSource() == fTextControl) {
                        fText = fTextControl.getText();
                    }
                    if (e.getSource() == fPackageTextControl) {
                        fPackageText = fPackageTextControl.getText();
                    }

                    if (isOkToUse((Control) e.getSource())) {
                        fireEvent();
                    }
                }
            };
        }

        public Control createControl(Composite composite) {
            int columns = 2;
            Composite nameComposite = new Composite(composite, SWT.NONE);
            nameComposite.setFont(composite.getFont());
            nameComposite.setLayout(new GridLayout(columns, false));

            Label label = getNameLabelControl(nameComposite);
            label.setLayoutData(gridDataForLabel(1));
            Text text = getNameTextControl(nameComposite);
            text.setLayoutData(gridDataForText(columns - 1));

            label = getPackageLabelControl(nameComposite);
            label.setLayoutData(gridDataForLabel(1));
            text = getPackageTextControl(nameComposite);
            text.setLayoutData(gridDataForText(columns - 1));

            return nameComposite;
        }

        public Label getNameLabelControl(Composite parent) {
            if (fLabel == null) {
                fLabel = new Label(parent, SWT.LEFT | SWT.WRAP);
                fLabel.setFont(parent.getFont());
                fLabel.setEnabled(true);
                if (StringUtils.isNotEmpty(fLabelText)) {
                    fLabel.setText(fLabelText);
                }
            }
            return fLabel;
        }

        public Label getPackageLabelControl(Composite parent) {
            if (fPackageLabel == null) {
                fPackageLabel = new Label(parent, SWT.LEFT | SWT.WRAP);
                fPackageLabel.setFont(parent.getFont());
                fPackageLabel.setEnabled(true);
                if (StringUtils.isNotEmpty(fPackageLabelText)) {
                    fPackageLabel.setText(fPackageLabelText);
                }
            }
            return fPackageLabel;
        }

        public Text getNameTextControl(Composite parent) {
            if (fTextControl == null) {
                fTextControl = new Text(parent, SWT.SINGLE | SWT.BORDER);
                fTextControl.setText(fText);
                fTextControl.setFont(parent.getFont());
                fTextControl.addModifyListener(fModifyListener);
                fTextControl.setEnabled(true);
            }
            return fTextControl;
        }

        public Text getPackageTextControl(Composite parent) {
            if (fPackageTextControl == null) {
                fPackageTextControl = new Text(parent, SWT.SINGLE | SWT.BORDER);
                fPackageTextControl.setText(fPackageText);
                fPackageTextControl.setFont(parent.getFont());
                fPackageTextControl.addModifyListener(fModifyListener);
                fPackageTextControl.setEnabled(true);
            }
            return fPackageTextControl;
        }

        /**
         * Tests is the control is not <code>null</code> and not disposed.
         * 
         * @param control the Control
         * @return <code>true</code> if the control is not <code>null</code> and not disposed.
         */
        protected final boolean isOkToUse(Control control) {
            return (control != null) && (Display.getCurrent() != null) && !control.isDisposed();
        }

        private GridData gridDataForLabel(int span) {
            GridData gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
            gd.horizontalSpan = span;
            return gd;
        }

        private GridData gridDataForText(int span) {
            GridData gd = new GridData();
            gd.horizontalAlignment = GridData.FILL;
            gd.grabExcessHorizontalSpace = false;
            gd.grabExcessHorizontalSpace = true;
            gd.horizontalSpan = span;
            return gd;
        }

        protected void fireEvent() {
            setChanged();
            notifyObservers();
        }

        public String getName() {
            return fText;
        }

        public String getPackageName() {
            return fPackageText;
        }

        public void postSetFocus() {
            Display display = getShell().getDisplay();
            if (display != null) {
                display.asyncExec(new Runnable() {
                    public void run() {
                        if (isOkToUse(fTextControl)) {
                            fTextControl.setFocus();
                            fTextControl.setSelection(0, fTextControl.getText().length());
                        }
                    }
                });
            }

        }

        public void setName(String name) {
            if (isOkToUse(fTextControl)) {
                fText = name;
                fTextControl.setText(name);
            }
        }
    }

    private final class WorkingSetGroup {

        private final WorkingSetConfigurationBlock fWorkingSetBlock;

        public WorkingSetGroup() {
            String[] workingSetIds = new String[] { IWorkingSetIDs.JAVA, IWorkingSetIDs.RESOURCE };
            fWorkingSetBlock = new WorkingSetConfigurationBlock(workingSetIds, JavaPlugin.getDefault()
                    .getDialogSettings());
            // fWorkingSetBlock.setDialogMessage(NewWizardMessages.NewJavaProjectWizardPageOne_WorkingSetSelection_message);
        }

        public Control createControl(Composite composite) {
            Group workingSetGroup = new Group(composite, SWT.NONE);
            workingSetGroup.setFont(composite.getFont());
            workingSetGroup.setText(YMessages.NewExtensionPage_WorkingSets_group);
            workingSetGroup.setLayout(new GridLayout(1, false));

            fWorkingSetBlock.createContent(workingSetGroup);

            return workingSetGroup;
        }

        public void setWorkingSets(IWorkingSet[] workingSets) {
            fWorkingSetBlock.setWorkingSets(workingSets);
        }

        public IWorkingSet[] getSelectedWorkingSets() {
            return fWorkingSetBlock.getSelectedWorkingSets();
        }
    }

    /**
     * Request a location. Fires an event whenever the checkbox or the location field is changed, regardless of whether
     * the change originates from the user or has been invoked programmatically.
     */
    private final class LocationGroup extends Observable implements Observer, IStringButtonAdapter,
            IDialogFieldListener {

        protected final SelectionButtonDialogField fUseDefaults;
        protected final StringButtonDialogField fLocation;

        private String fPreviousExternalLocation;

        private static final String DIALOGSTORE_LAST_EXTERNAL_LOC = JavaUI.ID_PLUGIN + ".last.external.project"; //$NON-NLS-1$

        public LocationGroup() {
            fUseDefaults = new SelectionButtonDialogField(SWT.CHECK);
            fUseDefaults.setDialogFieldListener(this);
            fUseDefaults.setLabelText(YMessages.NewExtensionPage_LocationGroup_location_desc);

            fLocation = new StringButtonDialogField(this);
            fLocation.setDialogFieldListener(this);
            fLocation.setLabelText(YMessages.NewExtensionPage_LocationGroup_locationLabel_desc);
            fLocation.setButtonLabel(YMessages.NewExtensionPage_LocationGroup_browseButton_desc);

            fUseDefaults.setSelection(true);

            fPreviousExternalLocation = ""; //$NON-NLS-1$
        }

        public Control createControl(Composite composite) {
            final int numColumns = 4;

            final Composite locationComposite = new Composite(composite, SWT.NONE);
            locationComposite.setLayout(new GridLayout(numColumns, false));

            fUseDefaults.doFillIntoGrid(locationComposite, numColumns);
            fLocation.doFillIntoGrid(locationComposite, numColumns);
            LayoutUtil.setHorizontalGrabbing(fLocation.getTextControl(null));

            return locationComposite;
        }

        protected void fireEvent() {
            setChanged();
            notifyObservers();
        }

        protected String getDefaultPath(String name) {
            final IPath path = Platform.getLocation().append(name);
            return path.toOSString();
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
         */
        public void update(Observable o, Object arg) {
            if (isUseDefaultSelected()) {
                fLocation.setText(getDefaultPath(fNamePackageGroup.getName()));
            }
            fireEvent();
        }

        public IPath getLocation() {
            if (isUseDefaultSelected()) {
                return Platform.getLocation();
            }
            return Path.fromOSString(fLocation.getText().trim());
        }

        public boolean isUseDefaultSelected() {
            return fUseDefaults.isSelected();
        }

        public void setLocation(IPath path) {
            fUseDefaults.setSelection(path == null);
            if (path != null) {
                fLocation.setText(path.toOSString());
            } else {
                fLocation.setText(getDefaultPath(fNamePackageGroup.getName()));
            }
            fireEvent();
        }

        /*
         * (non-Javadoc)
         * 
         * @see
         * org.eclipse.jdt.internal.ui.wizards.dialogfields.IStringButtonAdapter#changeControlPressed(org.eclipse.jdt
         * .internal.ui.wizards.dialogfields.DialogField)
         */
        public void changeControlPressed(DialogField field) {
            final DirectoryDialog dialog = new DirectoryDialog(getShell());
            dialog.setMessage(NewWizardMessages.NewJavaProjectWizardPageOne_directory_message);
            String directoryName = fLocation.getText().trim();
            if (directoryName.length() == 0) {
                String prevLocation = JavaPlugin.getDefault().getDialogSettings().get(DIALOGSTORE_LAST_EXTERNAL_LOC);
                if (prevLocation != null) {
                    directoryName = prevLocation;
                }
            }

            if (directoryName.length() > 0) {
                final File path = new File(directoryName);
                if (path.exists())
                    dialog.setFilterPath(directoryName);
            }
            final String selectedDirectory = dialog.open();
            if (selectedDirectory != null) {
                String oldDirectory = new Path(fLocation.getText().trim()).lastSegment();
                fLocation.setText(selectedDirectory);
                String lastSegment = new Path(selectedDirectory).lastSegment();
                if (lastSegment != null
                        && (fNamePackageGroup.getName().length() == 0 || fNamePackageGroup.getName().equals(
                                oldDirectory))) {
                    fNamePackageGroup.setName(lastSegment);
                }
                JavaPlugin.getDefault().getDialogSettings().put(DIALOGSTORE_LAST_EXTERNAL_LOC, selectedDirectory);
            }
        }

        /*
         * (non-Javadoc)
         * 
         * @see
         * org.eclipse.jdt.internal.ui.wizards.dialogfields.IDialogFieldListener#dialogFieldChanged(org.eclipse.jdt.
         * internal.ui.wizards.dialogfields.DialogField)
         */
        public void dialogFieldChanged(DialogField field) {
            if (field == fUseDefaults) {
                final boolean checked = fUseDefaults.isSelected();
                if (checked) {
                    fPreviousExternalLocation = fLocation.getText();
                    fLocation.setText(getDefaultPath(fNamePackageGroup.getName()));
                    fLocation.setEnabled(false);
                } else {
                    fLocation.setText(fPreviousExternalLocation);
                    fLocation.setEnabled(true);
                }
            }
            fireEvent();
        }
    }

    /**
     * Request a project layout.
     */
    private final class LayoutGroup implements Observer, SelectionListener {

        private final SelectionButtonDialogField fStdRadio, fSrcBinRadio;
        private Group fGroup;
        private Link fPreferenceLink;

        public LayoutGroup() {
            fStdRadio = new SelectionButtonDialogField(SWT.RADIO);
            fStdRadio.setLabelText(NewWizardMessages.NewJavaProjectWizardPageOne_LayoutGroup_option_oneFolder);

            fSrcBinRadio = new SelectionButtonDialogField(SWT.RADIO);
            fSrcBinRadio.setLabelText(NewWizardMessages.NewJavaProjectWizardPageOne_LayoutGroup_option_separateFolders);

            boolean useSrcBin = PreferenceConstants.getPreferenceStore().getBoolean(
                    PreferenceConstants.SRCBIN_FOLDERS_IN_NEWPROJ);
            fSrcBinRadio.setSelection(useSrcBin);
            fStdRadio.setSelection(!useSrcBin);
        }

        public Control createContent(Composite composite) {
            fGroup = new Group(composite, SWT.NONE);
            fGroup.setFont(composite.getFont());
            fGroup.setLayout(initGridLayout(new GridLayout(3, false), true));
            fGroup.setText(NewWizardMessages.NewJavaProjectWizardPageOne_LayoutGroup_title);

            fStdRadio.doFillIntoGrid(fGroup, 3);
            LayoutUtil.setHorizontalGrabbing(fStdRadio.getSelectionButton(null));

            fSrcBinRadio.doFillIntoGrid(fGroup, 2);

            fPreferenceLink = new Link(fGroup, SWT.NONE);
            fPreferenceLink.setText(NewWizardMessages.NewJavaProjectWizardPageOne_LayoutGroup_link_description);
            fPreferenceLink.setLayoutData(new GridData(GridData.END, GridData.END, false, false));
            fPreferenceLink.addSelectionListener(this);

            updateEnableState();
            return fGroup;
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
         */
        public void update(Observable o, Object arg) {
            updateEnableState();
        }

        private void updateEnableState() {
            if (fDetectGroup == null)
                return;

            final boolean detect = fDetectGroup.mustDetect();
            fStdRadio.setEnabled(!detect);
            fSrcBinRadio.setEnabled(!detect);
            if (fPreferenceLink != null) {
                fPreferenceLink.setEnabled(!detect);
            }
            if (fGroup != null) {
                fGroup.setEnabled(!detect);
            }
        }

        /**
         * Return <code>true</code> if the user specified to create 'source' and 'bin' folders.
         * 
         * @return returns <code>true</code> if the user specified to create 'source' and 'bin' folders.
         */
        public boolean isSrcBin() {
            return fSrcBinRadio.isSelected();
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
         */
        public void widgetSelected(SelectionEvent e) {
            widgetDefaultSelected(e);
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
         */
        public void widgetDefaultSelected(SelectionEvent e) {
            String id = NewJavaProjectPreferencePage.ID;
            PreferencesUtil.createPreferenceDialogOn(getShell(), id, new String[] { id }, null).open();
            fDetectGroup.handlePossibleJVMChange();
        }
    }

    /**
     * Show a warning when the project location contains files.
     */
    private final class DetectGroup extends Observable implements Observer, SelectionListener {

        private Link fHintText;
        private Label fIcon;
        private boolean fDetect;

        public DetectGroup() {
            fDetect = false;
        }

        public Control createControl(Composite parent) {

            Composite composite = new Composite(parent, SWT.NONE);
            composite.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
            GridLayout layout = new GridLayout(2, false);
            layout.horizontalSpacing = 10;
            composite.setLayout(layout);

            fIcon = new Label(composite, SWT.LEFT);
            fIcon.setImage(Dialog.getImage(Dialog.DLG_IMG_MESSAGE_WARNING));
            GridData gridData = new GridData(SWT.LEFT, SWT.TOP, false, false);
            fIcon.setLayoutData(gridData);

            fHintText = new Link(composite, SWT.WRAP);
            fHintText.setFont(composite.getFont());
            fHintText.addSelectionListener(this);
            gridData = new GridData(GridData.FILL, SWT.FILL, true, true);
            gridData.widthHint = convertWidthInCharsToPixels(50);
            gridData.heightHint = convertHeightInCharsToPixels(3);
            fHintText.setLayoutData(gridData);

            handlePossibleJVMChange();
            return composite;
        }

        public void handlePossibleJVMChange() {
            if (JavaRuntime.getDefaultVMInstall() == null) {
                fHintText.setText(NewWizardMessages.NewJavaProjectWizardPageOne_NoJREFound_link);
                fHintText.setVisible(true);
                fIcon.setImage(Dialog.getImage(Dialog.DLG_IMG_MESSAGE_WARNING));
                fIcon.setVisible(true);
                return;
            }
        }

        private boolean computeDetectState() {
            if (fLocationGroup.isUseDefaultSelected()) {
                String name = fNamePackageGroup.getName();
                if (name.length() == 0 || JavaPlugin.getWorkspace().getRoot().findMember(name) != null) {
                    return false;
                } else {
                    final File directory = fLocationGroup.getLocation().append(name).toFile();
                    return directory.isDirectory();
                }
            } else {
                final File directory = fLocationGroup.getLocation().toFile();
                return directory.isDirectory();
            }
        }

        public void update(Observable o, Object arg) {
            if (o instanceof LocationGroup) {
                boolean oldDetectState = fDetect;
                fDetect = computeDetectState();

                if (oldDetectState != fDetect) {
                    setChanged();
                    notifyObservers();

                    if (fDetect) {
                        fHintText.setVisible(true);
                        fHintText.setText(NewWizardMessages.NewJavaProjectWizardPageOne_DetectGroup_message);
                        fIcon.setImage(Dialog.getImage(Dialog.DLG_IMG_MESSAGE_INFO));
                        fIcon.setVisible(true);
                    } else {
                        handlePossibleJVMChange();
                    }
                }
            }
        }

        public boolean mustDetect() {
            return fDetect;
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.swt.events.SelectionListener#widgetSelected(org.eclipse.swt.events.SelectionEvent)
         */
        public void widgetSelected(SelectionEvent e) {
            widgetDefaultSelected(e);
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.swt.events.SelectionListener#widgetDefaultSelected(org.eclipse.swt.events.SelectionEvent)
         */
        public void widgetDefaultSelected(SelectionEvent e) {
            String jreID = BuildPathSupport.JRE_PREF_PAGE_ID;
            String eeID = BuildPathSupport.EE_PREF_PAGE_ID;
            String complianceId = CompliancePreferencePage.PREF_ID;
            Map<String, Boolean> data = new HashMap<String, Boolean>();
            data.put(PropertyAndPreferencePage.DATA_NO_LINK, Boolean.TRUE);
            String id = "JRE".equals(e.text) ? jreID : complianceId; //$NON-NLS-1$
            PreferencesUtil.createPreferenceDialogOn(getShell(), id, new String[] { jreID, complianceId, eeID }, data)
                    .open();
            handlePossibleJVMChange();
        }
    }

    /**
     * Validate this page and show appropriate warnings and error YMessages.
     */
    private final class Validator implements Observer {

        public void update(Observable o, Object arg) {
            validatePackageAndExtensionName();
        }

        private IStatus validatePackageName(String packName) {
            IJavaProject project = getJavaProject();
            if (project == null || !project.exists()) {
                return JavaConventions.validatePackageName(packName, JavaCore.VERSION_1_3, JavaCore.VERSION_1_3);
            }
            return JavaConventionsUtil.validatePackageName(packName, project);
        }

        private void validatePackageAndExtensionName() {
            final IWorkspace workspace = JavaPlugin.getWorkspace();

            final String name = fNamePackageGroup.getName();

            // check whether the project name field is empty
            if (name.length() == 0) {
                setErrorMessage(null);
                setMessage(NewWizardMessages.NewJavaProjectWizardPageOne_Message_enterProjectName);
                setPageComplete(false);
                return;
            }

            // check whether the project name is valid
            final IStatus nameStatus = workspace.validateName(name, IResource.PROJECT);
            if (!nameStatus.isOK()) {
                setErrorMessage(nameStatus.getMessage());
                setPageComplete(false);
                return;
            }

            // check whether project already exists
            final IProject handle = workspace.getRoot().getProject(name);
            if (handle.exists()) {
                setErrorMessage(NewWizardMessages.NewJavaProjectWizardPageOne_Message_projectAlreadyExists);
                setPageComplete(false);
                return;
            }

            IPath projectLocation = ResourcesPlugin.getWorkspace().getRoot().getLocation().append(name);
            if (projectLocation.toFile().exists()) {
                try {
                    // correct casing
                    String canonicalPath = projectLocation.toFile().getCanonicalPath();
                    projectLocation = new Path(canonicalPath);
                } catch (IOException e) {
                    JavaPlugin.log(e);
                }

                String existingName = projectLocation.lastSegment();
                if (!existingName.equals(fNamePackageGroup.getName())) {
                    setErrorMessage(Messages.format(
                            NewWizardMessages.NewJavaProjectWizardPageOne_Message_invalidProjectNameForWorkspaceRoot,
                            BasicElementLabels.getResourceName(existingName)));
                    setPageComplete(false);
                    return;
                }

            }

            final String location = fLocationGroup.getLocation().toOSString();

            // check whether location is empty
            if (location.length() == 0) {
                setErrorMessage(null);
                setMessage(NewWizardMessages.NewJavaProjectWizardPageOne_Message_enterLocation);
                setPageComplete(false);
                return;
            }

            // check whether the location is a syntactically correct path
            if (!Path.EMPTY.isValidPath(location)) {
                setErrorMessage(NewWizardMessages.NewJavaProjectWizardPageOne_Message_invalidDirectory);
                setPageComplete(false);
                return;
            }

            IPath projectPath = null;
            if (!fLocationGroup.isUseDefaultSelected()) {
                projectPath = Path.fromOSString(location);
                if (!projectPath.toFile().exists()) {
                    // check non-existing external location
                    if (!canCreate(projectPath.toFile())) {
                        setErrorMessage(NewWizardMessages.NewJavaProjectWizardPageOne_Message_cannotCreateAtExternalLocation);
                        setPageComplete(false);
                        return;
                    }
                }
            }

            // validate the location
            final IStatus locationStatus = workspace.validateProjectLocation(handle, projectPath);
            if (!locationStatus.isOK()) {
                setErrorMessage(locationStatus.getMessage());
                setPageComplete(false);
                return;
            }

            String packName = fNamePackageGroup.getPackageName();
            if (packName.length() > 0) {
                IStatus val = validatePackageName(packName);
                if (val.getSeverity() == IStatus.ERROR) {
                    setErrorMessage(Messages.format(NewWizardMessages.NewPackageWizardPage_error_InvalidPackageName,
                            val.getMessage()));
                    setPageComplete(false);
                    return;
                } else if (val.getSeverity() == IStatus.WARNING) {
                    setErrorMessage(null);
                    setMessage(Messages.format(NewWizardMessages.NewPackageWizardPage_warning_DiscouragedPackageName,
                            val.getMessage()));
                    setPageComplete(true);
                    return;
                }
            } else {
                setMessage(NewWizardMessages.NewPackageWizardPage_error_EnterName);
                setErrorMessage(null);
                setPageComplete(false);
                return;
            }

            setPageComplete(true);
            setErrorMessage(null);
            setMessage(null);
        }

        private boolean canCreate(File file) {
            while (!file.exists()) {
                file = file.getParentFile();
                if (file == null)
                    return false;
            }

            return file.canWrite();
        }
    }

    private static final String PAGE_NAME = "NewJavaProjectWizardPageOne"; //$NON-NLS-1$

    private final NamePackageGroup fNamePackageGroup;
    private final LocationGroup fLocationGroup;
    private final LayoutGroup fLayoutGroup;
    private final DetectGroup fDetectGroup;
    private final Validator fValidator;
    private final WorkingSetGroup fWorkingSetGroup;
    private final JavaPackageCompletionProcessor fCurrPackageCompletionProcessor;

    private IJavaProject fCurrProject;

    /**
     * Creates a new {@link NewExtensionWizardPage}.
     */
    public NewExtensionWizardPage() {
        super(PAGE_NAME);
        setPageComplete(false);
        setTitle(NewWizardMessages.NewJavaProjectWizardPageOne_page_title);
        setDescription(NewWizardMessages.NewJavaProjectWizardPageOne_page_description);

        // fPackageDialogField.setDialogFieldListener(new IDialogFieldListener() {
        //
        // public void dialogFieldChanged(DialogField field) {
        // // TODO handle event
        // System.out.println("dialogFieldChanged(DialogField field) E V E N T ###################");
        // }
        // });
        //
        fNamePackageGroup = new NamePackageGroup();
        fLocationGroup = new LocationGroup();
        fLayoutGroup = new LayoutGroup();
        fWorkingSetGroup = new WorkingSetGroup();
        fDetectGroup = new DetectGroup();
        fCurrPackageCompletionProcessor = new JavaPackageCompletionProcessor();

        // establish connections
        fNamePackageGroup.addObserver(fLocationGroup);
        fDetectGroup.addObserver(fLayoutGroup);
        fLocationGroup.addObserver(fDetectGroup);

        // initialize all elements
        fNamePackageGroup.notifyObservers();

        // create and connect validator
        fValidator = new Validator();
        fNamePackageGroup.addObserver(fValidator);
        fLocationGroup.addObserver(fValidator);

        // initialize defaults
        setProjectName(""); //$NON-NLS-1$
        fLocationGroup.setLocation(null);
        setWorkingSets(new IWorkingSet[0]);

        initializeDefaultVM();
    }

    /**
     * The wizard owning this page can call this method to initialize the fields from the current selection and active
     * part.
     * 
     * @param selection used to initialize the fields
     * @param activePart the (typically active) part to initialize the fields or <code>null</code>
     */
    public void init(IStructuredSelection selection, IWorkbenchPart activePart) {
        setWorkingSets(getSelectedWorkingSet(selection, activePart));
    }

    private void initializeDefaultVM() {
        JavaRuntime.getDefaultVMInstall();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.dialogs.IDialogPage#createControl(org.eclipse.swt.widgets.Composite)
     */
    public void createControl(Composite parent) {
        initializeDialogUnits(parent);

        final Composite composite = new Composite(parent, SWT.NULL);
        composite.setFont(parent.getFont());
        composite.setLayout(initGridLayout(new GridLayout(1, false), true));
        composite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));

        // create UI elements
        Control nameControl = createNameControl(composite);
        nameControl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        Control locationControl = createLocationControl(composite);
        locationControl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        Control layoutControl = createProjectLayoutControl(composite);
        layoutControl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        Control workingSetControl = createWorkingSetControl(composite);
        workingSetControl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        Control infoControl = createInfoControl(composite);
        infoControl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        setControl(composite);
    }

    @Override
    protected void setControl(Control newControl) {
        Dialog.applyDialogFont(newControl);

        PlatformUI.getWorkbench().getHelpSystem().setHelp(newControl, IJavaHelpContextIds.NEW_JAVAPROJECT_WIZARD_PAGE);

        super.setControl(newControl);
    }

    /**
     * Creates the controls for the name field.
     * 
     * @param composite the parent composite
     * @return the created control
     */
    protected Control createNameControl(Composite composite) {
        return fNamePackageGroup.createControl(composite);
    }

    /**
     * Creates the controls for the location field.
     * 
     * @param composite the parent composite
     * @return the created control
     */
    protected Control createLocationControl(Composite composite) {
        return fLocationGroup.createControl(composite);
    }

    /**
     * Creates the controls for the project layout selection.
     * 
     * @param composite the parent composite
     * @return the created control
     */
    protected Control createProjectLayoutControl(Composite composite) {
        return fLayoutGroup.createContent(composite);
    }

    /**
     * Creates the controls for the working set selection.
     * 
     * @param composite the parent composite
     * @return the created control
     */
    protected Control createWorkingSetControl(Composite composite) {
        return fWorkingSetGroup.createControl(composite);
    }

    /**
     * Creates the controls for the info section.
     * 
     * @param composite the parent composite
     * @return the created control
     */
    protected Control createInfoControl(Composite composite) {
        return fDetectGroup.createControl(composite);
    }

    /**
     * Gets a project name for the new project.
     * 
     * @return the new project resource handle
     */
    public String getProjectName() {
        return fNamePackageGroup.getName();
    }

    /**
     * Sets the name of the new project
     * 
     * @param name the new name
     */
    public void setProjectName(String name) {
        if (name == null)
            throw new IllegalArgumentException();

        fNamePackageGroup.setName(name);
    }

    /**
     * Returns the source class path entries to be added on new projects. The underlying resources may not exist. All
     * entries that are returned must be of kind {@link IClasspathEntry#CPE_SOURCE}.
     * 
     * @return returns the source class path entries for the new project
     */
    public IClasspathEntry[] getSourceClasspathEntries() {
        IPath sourceFolderPath = new Path(getProjectName()).makeAbsolute();

        if (fLayoutGroup.isSrcBin()) {
            IPath srcPath = new Path(PreferenceConstants.getPreferenceStore().getString(
                    PreferenceConstants.SRCBIN_SRCNAME));
            if (srcPath.segmentCount() > 0) {
                sourceFolderPath = sourceFolderPath.append(srcPath);
            }
        }
        return new IClasspathEntry[] { JavaCore.newSourceEntry(sourceFolderPath) };
    }

    /**
     * Returns the source class path entries to be added on new projects. The underlying resource may not exist.
     * 
     * @return returns the default class path entries
     */
    public IPath getOutputLocation() {
        IPath outputLocationPath = new Path(getProjectName()).makeAbsolute();
        if (fLayoutGroup.isSrcBin()) {
            IPath binPath = new Path(PreferenceConstants.getPreferenceStore().getString(
                    PreferenceConstants.SRCBIN_BINNAME));
            if (binPath.segmentCount() > 0) {
                outputLocationPath = outputLocationPath.append(binPath);
            }
        }
        return outputLocationPath;
    }

    /**
     * Returns the working sets to which the new project should be added.
     * 
     * @return the selected working sets to which the new project should be added
     */
    public IWorkingSet[] getWorkingSets() {
        return fWorkingSetGroup.getSelectedWorkingSets();
    }

    /**
     * Sets the working sets to which the new project should be added.
     * 
     * @param workingSets the initial selected working sets
     */
    public void setWorkingSets(IWorkingSet[] workingSets) {
        if (workingSets == null) {
            throw new IllegalArgumentException();
        }
        fWorkingSetGroup.setWorkingSets(workingSets);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.dialogs.DialogPage#setVisible(boolean)
     */
    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        if (visible) {
            fNamePackageGroup.postSetFocus();
        }
    }

    private GridLayout initGridLayout(GridLayout layout, boolean margins) {
        layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
        layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
        if (margins) {
            layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
            layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
        } else {
            layout.marginWidth = 0;
            layout.marginHeight = 0;
        }
        return layout;
    }

    private static final IWorkingSet[] EMPTY_WORKING_SET_ARRAY = new IWorkingSet[0];

    private IWorkingSet[] getSelectedWorkingSet(IStructuredSelection selection, IWorkbenchPart activePart) {
        IWorkingSet[] selected = getSelectedWorkingSet(selection);
        if (selected != null && selected.length > 0) {
            for (int i = 0; i < selected.length; i++) {
                if (!isValidWorkingSet(selected[i]))
                    return EMPTY_WORKING_SET_ARRAY;
            }
            return selected;
        }

        if (!(activePart instanceof PackageExplorerPart))
            return EMPTY_WORKING_SET_ARRAY;

        PackageExplorerPart explorerPart = (PackageExplorerPart) activePart;
        if (explorerPart.getRootMode() == PackageExplorerPart.PROJECTS_AS_ROOTS) {
            // Get active filter
            IWorkingSet filterWorkingSet = explorerPart.getFilterWorkingSet();
            if (filterWorkingSet == null)
                return EMPTY_WORKING_SET_ARRAY;

            if (!isValidWorkingSet(filterWorkingSet))
                return EMPTY_WORKING_SET_ARRAY;

            return new IWorkingSet[] { filterWorkingSet };
        } else {
            // If we have been gone into a working set return the working set
            Object input = explorerPart.getViewPartInput();
            if (!(input instanceof IWorkingSet))
                return EMPTY_WORKING_SET_ARRAY;

            IWorkingSet workingSet = (IWorkingSet) input;
            if (!isValidWorkingSet(workingSet))
                return EMPTY_WORKING_SET_ARRAY;

            return new IWorkingSet[] { workingSet };
        }
    }

    private IWorkingSet[] getSelectedWorkingSet(IStructuredSelection selection) {
        if (!(selection instanceof ITreeSelection))
            return EMPTY_WORKING_SET_ARRAY;

        ITreeSelection treeSelection = (ITreeSelection) selection;
        if (treeSelection.isEmpty())
            return EMPTY_WORKING_SET_ARRAY;

        List<?> elements = treeSelection.toList();
        if (elements.size() == 1) {
            Object element = elements.get(0);
            TreePath[] paths = treeSelection.getPathsFor(element);
            if (paths.length != 1)
                return EMPTY_WORKING_SET_ARRAY;

            TreePath path = paths[0];
            if (path.getSegmentCount() == 0)
                return EMPTY_WORKING_SET_ARRAY;

            Object candidate = path.getSegment(0);
            if (!(candidate instanceof IWorkingSet))
                return EMPTY_WORKING_SET_ARRAY;

            IWorkingSet workingSetCandidate = (IWorkingSet) candidate;
            if (isValidWorkingSet(workingSetCandidate))
                return new IWorkingSet[] { workingSetCandidate };

            return EMPTY_WORKING_SET_ARRAY;
        }

        ArrayList<IWorkingSet> result = new ArrayList<IWorkingSet>();
        for (Iterator<?> iterator = elements.iterator(); iterator.hasNext();) {
            Object element = iterator.next();
            if (element instanceof IWorkingSet && isValidWorkingSet((IWorkingSet) element)) {
                result.add((IWorkingSet) element);
            }
        }
        return result.toArray(new IWorkingSet[result.size()]);
    }

    @SuppressWarnings("restriction")
    private static boolean isValidWorkingSet(IWorkingSet workingSet) {
        String id = workingSet.getId();
        if (!IWorkingSetIDs.JAVA.equals(id) && !IWorkingSetIDs.RESOURCE.equals(id))
            return false;

        if (workingSet.isAggregateWorkingSet())
            return false;

        return true;
    }

    public void performFinish(IProgressMonitor monitor) throws CoreException, InterruptedException {
        try {
            monitor.beginTask(NewWizardMessages.NewJavaProjectWizardPageTwo_operation_create, 3);
            if (fCurrProject == null) {
                updateProject(new SubProgressMonitor(monitor, 1));
            }
        } finally {
            monitor.done();
        }
    }

    /**
     * Called from the wizard on cancel.
     */
    public void performCancel() {
        if (fCurrProject != null) {
            removeProvisonalProject();
        }
    }

    /**
     * Removes the provisional project. The provisional project is typically removed when the user cancels the wizard or
     * goes back to the first page.
     */
    protected void removeProvisonalProject() {
        if (!fCurrProject.getProject().exists()) {
            fCurrProject = null;
            return;
        }

        IRunnableWithProgress op = new IRunnableWithProgress() {
            public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
                doRemoveProject(monitor);
            }
        };

        try {
            getContainer().run(true, true, new WorkspaceModifyDelegatingOperation(op));
        } catch (InvocationTargetException e) {
            final String title = NewWizardMessages.NewJavaProjectWizardPageTwo_error_remove_title;
            final String message = NewWizardMessages.NewJavaProjectWizardPageTwo_error_remove_message;
            ExceptionHandler.handle(e, getShell(), title, message);
        } catch (InterruptedException e) {
            // cancel pressed
        }
    }

    private final void doRemoveProject(IProgressMonitor monitor) throws InvocationTargetException {
        final boolean noProgressMonitor = true; // inside workspace
        if (monitor == null || noProgressMonitor) {
            monitor = new NullProgressMonitor();
        }
        monitor.beginTask(NewWizardMessages.NewJavaProjectWizardPageTwo_operation_remove, 3);
        try {
            try {
                fCurrProject.getProject().delete(true, false, new SubProgressMonitor(monitor, 2));
            } finally {
            }
        } catch (CoreException e) {
            throw new InvocationTargetException(e);
        } finally {
            monitor.done();
            fCurrProject = null;
        }
    }

    private final IStatus updateProject(IProgressMonitor monitor) throws CoreException, InterruptedException {
        IStatus result = StatusInfo.OK_STATUS;
        if (monitor == null) {
            monitor = new NullProgressMonitor();
        }
        try {
            monitor.beginTask(NewWizardMessages.NewJavaProjectWizardPageTwo_operation_initialize, 7);
            if (monitor.isCanceled()) {
                throw new OperationCanceledException();
            }

            String projectName = getProjectName();
            fCurrProject = createJavaProject(projectName, new SubProgressMonitor(monitor, 2));

            if (monitor.isCanceled()) {
                throw new OperationCanceledException();
            }

            initializeBuildPath(fCurrProject, new SubProgressMonitor(monitor, 2));
        } finally {
            monitor.done();
        }
        return result;
    }

    private IJavaProject createJavaProject(String projectName, IProgressMonitor monitor) throws CoreException {
        IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
        IProject project = root.getProject(projectName);
        if (!project.exists()) {
            project.create(monitor);
        } else {
            project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
        }

        if (!project.isOpen()) {
            project.open(monitor);
        }

        if (!project.hasNature(JavaCore.NATURE_ID)) {
            addNatureToProject(project, JavaCore.NATURE_ID, monitor);
        }

        IJavaProject jproject = JavaCore.create(project);

        return jproject;
    }

    private void addNatureToProject(IProject proj, String natureId, IProgressMonitor monitor) throws CoreException {
        IProjectDescription description = proj.getDescription();
        String[] prevNatures = description.getNatureIds();
        String[] newNatures = new String[prevNatures.length + 1];
        System.arraycopy(prevNatures, 0, newNatures, 0, prevNatures.length);
        newNatures[prevNatures.length] = natureId;
        description.setNatureIds(newNatures);
        proj.setDescription(description, monitor);
    }

    /**
     * Evaluates the new build path and output folder according to the settings on the first page. The resulting build
     * path is set by calling {@link #init(IJavaProject, IPath, IClasspathEntry[], boolean)}. Clients can override this
     * method.
     * 
     * @param javaProject the new project which is already created when this method is called.
     * @param monitor the progress monitor
     * @throws CoreException thrown when initializing the build path failed
     */
    protected void initializeBuildPath(IJavaProject javaProject, IProgressMonitor monitor) throws CoreException {
        if (monitor == null) {
            monitor = new NullProgressMonitor();
        }
        monitor.beginTask(NewWizardMessages.NewJavaProjectWizardPageTwo_monitor_init_build_path, 2);

        try {
            IClasspathEntry[] entries = null;
            IProject project = javaProject.getProject();

            List<IClasspathEntry> cpEntries = new ArrayList<IClasspathEntry>();
            IWorkspaceRoot root = project.getWorkspace().getRoot();

            IClasspathEntry[] sourceClasspathEntries = getSourceClasspathEntries();
            for (int i = 0; i < sourceClasspathEntries.length; i++) {
                IPath path = sourceClasspathEntries[i].getPath();
                if (path.segmentCount() > 1) {
                    IFolder folder = root.getFolder(path);
                    CoreUtility.createFolder(folder, true, true, new SubProgressMonitor(monitor, 1));
                }
                cpEntries.add(sourceClasspathEntries[i]);
            }

            // TODO use JRE container from platform
            cpEntries.addAll(Arrays.asList(PreferenceConstants.getDefaultJRELibrary()));

            entries = cpEntries.toArray(new IClasspathEntry[cpEntries.size()]);

            IPath outputLocation = getOutputLocation();
            if (outputLocation.segmentCount() > 1) {
                IFolder folder = root.getFolder(outputLocation);
                CoreUtility.createDerivedFolder(folder, true, true, new SubProgressMonitor(monitor, 1));
            }
            if (monitor.isCanceled()) {
                throw new OperationCanceledException();
            }

            // TODO sprawdz init()
            // init(javaProject, outputLocation, entries, false);
            javaProject.setRawClasspath(cpEntries.toArray(new IClasspathEntry[cpEntries.size()]), outputLocation,
                    monitor);
        } finally {
            monitor.done();
        }
    }

    private void deleteProjectFile(URI projectLocation) throws CoreException {
        IFileStore file = EFS.getStore(projectLocation);
        if (file.fetchInfo().exists()) {
            IFileStore projectFile = file.getChild(FILENAME_PROJECT);
            if (projectFile.fetchInfo().exists()) {
                projectFile.delete(EFS.NONE, null);
            }
        }
    }

    IJavaProject getJavaProject() {
        return fCurrProject;
    }
}