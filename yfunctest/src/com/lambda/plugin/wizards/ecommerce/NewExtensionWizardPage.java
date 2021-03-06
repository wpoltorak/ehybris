package com.lambda.plugin.wizards.ecommerce;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.text.MessageFormat;
import java.util.Observable;
import java.util.Observer;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.tools.ant.Project;
import org.eclipse.core.filesystem.URIUtil;
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
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaConventions;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.ui.IJavaHelpContextIds;
import org.eclipse.jdt.internal.ui.workingsets.IWorkingSetIDs;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.ui.PreferenceConstants;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.PixelConverter;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyDelegatingOperation;
import org.eclipse.ui.dialogs.WorkingSetGroup;

import com.lambda.plugin.ExceptionHandler;
import com.lambda.plugin.YMessages;
import com.lambda.plugin.YNature;
import com.lambda.plugin.YPlugin;
import com.lambda.plugin.core.IPlatformInstallation;
import com.lambda.plugin.ui.SwtUtil;
import com.lambda.plugin.ui.YUIStatus;
import com.lambda.plugin.utils.StringUtils;

public class NewExtensionWizardPage extends AbstractWizardPage {

    private static final String EXTGEN_TEMPLATE_PATH = "extgen.template.path.";

    private static final String PAGE_NAME = "NewExtensionWizardPage"; //$NON-NLS-1$

    private final NamePackageGroup fNamePackageGroup;
    private final LocationGroup fLocationGroup;
    private final TemplateGroup fTemplateGroup;
    private final Validator fValidator;
    private WorkingSetGroup fWorkingSetGroup;
    private final Properties fProperties;
    private IJavaProject fCurrProject;

    private final IPlatformInstallation platform;

    /**
     * Creates a new {@link NewExtensionWizardPage}.
     */
    public NewExtensionWizardPage() {
        super(PAGE_NAME);
        setPageComplete(false);
        setTitle(YMessages.NewExtensionPage_title);
        setDescription(YMessages.NewExtensionPage_description);
        platform = YPlugin.getDefault().getDefaultPlatform();
        fProperties = platform == null ? null : YPlugin.getDefault().getPlatformContainer()
                .loadExtgenProjectProperties(platform);
        fNamePackageGroup = new NamePackageGroup();
        fLocationGroup = new LocationGroup();
        fTemplateGroup = new TemplateGroup(fProperties);

        // establish connections
        fNamePackageGroup.addObserver(fLocationGroup);

        // initialize all elements
        fNamePackageGroup.notifyObservers();

        // create and connect validator
        fValidator = new Validator();
        fNamePackageGroup.addObserver(fValidator);
        fLocationGroup.addObserver(fValidator);
        fTemplateGroup.addObserver(fValidator);

        // initialize defaults
        setProjectName(""); //$NON-NLS-1$
        fLocationGroup.setLocation(null);

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
        Control nameControl = fNamePackageGroup.createControl(composite);
        nameControl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        Control locationControl = fLocationGroup.createControl(composite);
        locationControl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        Control templateControl = fTemplateGroup.createControl(composite);
        templateControl.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        fWorkingSetGroup = new WorkingSetGroup(composite, null, new String[] { IWorkingSetIDs.JAVA,
                IWorkingSetIDs.RESOURCE });
        setControl(composite);
    }

    @Override
    protected void setControl(Control newControl) {
        Dialog.applyDialogFont(newControl);
        // TODO help for new extension
        PlatformUI.getWorkbench().getHelpSystem().setHelp(newControl, IJavaHelpContextIds.NEW_JAVAPROJECT_WIZARD_PAGE);

        super.setControl(newControl);
    }

    /**
     * Gets a package name for the new extension.
     * 
     * @return the new project resource handle
     */
    public String getPackageName() {
        return fNamePackageGroup.getPackageName();
    }

    /**
     * Gets a project name for the new extension.
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
        IPath srcPath = new Path(PreferenceConstants.getPreferenceStore().getString(PreferenceConstants.SRCBIN_SRCNAME));
        if (srcPath.segmentCount() > 0) {
            sourceFolderPath = sourceFolderPath.append(srcPath);
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
        IPath binPath = new Path(PreferenceConstants.getPreferenceStore().getString(PreferenceConstants.SRCBIN_BINNAME));
        if (binPath.segmentCount() > 0) {
            outputLocationPath = outputLocationPath.append(binPath);
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

    public void performFinish(IProgressMonitor monitor) throws CoreException, InterruptedException {
        try {
            if (fCurrProject == null) {
                updateProject(monitor);
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
            final String title = YMessages.NewExtensionPage_error_remove_title;
            final String message = YMessages.NewExtensionPage_error_remove_message;
            ExceptionHandler.handle(e, getShell(), title, message);
        } catch (InterruptedException e) {
            // cancel pressed
        }
    }

    private final void doRemoveProject(IProgressMonitor monitor) throws InvocationTargetException {
        if (monitor == null) {
            monitor = new NullProgressMonitor();
        }
        monitor.beginTask(YMessages.NewExtensionPage_operation_remove, 3);
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
        IStatus result = YUIStatus.OK_STATUS;
        if (monitor == null) {
            monitor = new NullProgressMonitor();
        }
        try {
            monitor.beginTask(YMessages.NewExtensionPage_operation_create, IProgressMonitor.UNKNOWN);
            if (monitor.isCanceled()) {
                throw new OperationCanceledException();
            }
            String projectName = getProjectName();
            String packageName = getPackageName();
            String templateName = fTemplateGroup.getTemplate();
            URI location = URIUtil.toURI(fLocationGroup.getLocation());
            setupExtensionData(platform, projectName, packageName, templateName, new SubProgressMonitor(monitor,
                    IProgressMonitor.UNKNOWN, SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK));
            fCurrProject = createJavaProject(platform, projectName, packageName, location, new SubProgressMonitor(
                    monitor, IProgressMonitor.UNKNOWN, SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK));

            if (monitor.isCanceled()) {
                throw new OperationCanceledException();
            }
            fCurrProject.getProject().touch(new NullProgressMonitor());
        } finally {
            monitor.done();
        }
        return result;
    }

    private IJavaProject createJavaProject(IPlatformInstallation defaultPlatform, String projectName,
            String packageName, URI locationURI, IProgressMonitor monitor) throws CoreException {
        try {
            monitor.subTask(YMessages.NewExtensionPage_operation_createproject);
            IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
            IProject project = root.getProject(projectName);
            if (!project.exists()) {
                IProjectDescription desc = project.getWorkspace().newProjectDescription(project.getName());
                if (locationURI != null
                        && ResourcesPlugin.getWorkspace().getRoot().getLocationURI().equals(locationURI)) {
                    locationURI = null;
                }
                desc.setLocationURI(locationURI);
                project.create(desc, monitor);
            } else {
                project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
            }

            if (!project.isOpen()) {
                project.open(monitor);
            }

            YPlugin.getDefault().getNatureManager().addNature(JavaCore.NATURE_ID, project, monitor);
            YPlugin.getDefault().getNatureManager().addNature(YNature.NATURE_ID, project, monitor);

            IJavaProject jproject = JavaCore.create(project);
            return jproject;
        } finally {
            monitor.done();
        }
    }

    private void setupExtensionData(IPlatformInstallation platform, String projectName, String packageName,
            String templateName, IProgressMonitor monitor) {
        try {
            monitor.subTask(YMessages.NewExtensionPage_operation_copytemplate);
            String templatePathKey = EXTGEN_TEMPLATE_PATH + templateName;
            String templatePath = fProperties.getProperty(templatePathKey);

            Project antProject = YPlugin.getDefault().getPlatformContainer().loadExtgenProject(platform);

            if (monitor.isCanceled()) {
                throw new OperationCanceledException();
            }

            antProject.setProperty("extgen.extension.name", projectName);
            antProject.setProperty("extgen.package", packageName);
            antProject.setProperty("extgen.package.directory", packageName.replaceAll("\\.", "/"));
            antProject.setProperty("extgen.directory.source", templatePath);

            // TODO provide input in front end
            // default if not specified in second page
            String classprefix = StringUtils.capitalize(projectName);
            antProject.setProperty("extension.classprefix", classprefix);
            antProject.setProperty("extension.managername", classprefix + "Manager");
            String managersuperclass = "de.hybris.platform.jalo.extension.Extension";
            antProject.setProperty("extension.managersuperclass", managersuperclass);
            Matcher m = Pattern.compile("^.*\\.([^\\.]*)$").matcher(managersuperclass);
            if (m.find()) {
                String managersuperclassname = m.group(1);
                antProject.setProperty("extension.managersuperclassname", managersuperclassname);
                antProject.setProperty("extension.managersuperclassimpl", managersuperclass + "."
                        + managersuperclassname + "Impl");
            }

            m = Pattern.compile("^(.*\\.)jalo(\\..*)$$").matcher(managersuperclass);
            if (m.find()) {
                String prefix = m.group(1);
                String suffix = m.group(2);
                antProject.setProperty("extension.managersuperclassejbimpl", prefix + "jaloimpl" + suffix + "EJBImpl");
                antProject.setProperty("extension.managersuperclassejb", prefix + "session" + suffix + "EJB");
                antProject.setProperty("extension.managersuperclasshome", prefix + "session" + suffix + "Home");
                antProject.setProperty("extension.managersuperclassremote", prefix + "session" + suffix + "Remote");
            }

            antProject.setProperty("extgen.directory.tmp", platform.getTempLocation().append("hybris").append("extgen")
                    .toOSString());
            antProject.setProperty("extension.directory.target", fLocationGroup.getLocation().toOSString());
            //
            // <!-- in generated extension, disable jspcompile as default value -->
            // <replaceregexp file="${extgen.directory.tmp}/extensioninfo.xml"
            // match='jspcompile="true"'
            // replace='jspcompile="false"'
            // byline="true"/>
            antProject.createTask("clean_extgen_temp").perform();
            antProject.createTask("prepare_extgen_temp").perform();
            antProject.createTask("filter_extgen_files").perform();
            antProject.createTask("extgen_copy_extension").perform();
        } finally {
            monitor.done();
        }
    }

    IJavaProject getJavaProject() {
        return fCurrProject;
    }

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

                    if (SwtUtil.isOkToUse((Control) e.getSource())) {
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
            label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
            Text text = getNameTextControl(nameComposite);
            text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

            label = getPackageLabelControl(nameComposite);
            label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
            text = getPackageTextControl(nameComposite);
            text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

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
                        if (SwtUtil.isOkToUse(fTextControl)) {
                            fTextControl.setFocus();
                            fTextControl.setSelection(0, fTextControl.getText().length());
                        }
                    }
                });
            }

        }

        public void setName(String name) {
            if (SwtUtil.isOkToUse(fTextControl)) {
                fText = name;
                fTextControl.setText(name);
            }
        }
    }

    /**
     * Request a location. Fires an event whenever the checkbox or the location field is changed, regardless of whether
     * the change originates from the user or has been invoked programmatically.
     */
    private final class LocationGroup extends Observable implements Observer {

        private Button fBrowseButton;
        private String fText;
        private Label fLabel;
        private String fPreviousExternalLocation;
        private Text fTextControl;
        private final ModifyListener fModifyListener;
        private Button fButton;
        private boolean fSelection;

        private static final String DIALOGSTORE_LAST_EXTERNAL_LOC = YPlugin.PLUGIN_ID + ".last.external.extension"; //$NON-NLS-1$

        public LocationGroup() {
            fText = "";
            fPreviousExternalLocation = ""; //$NON-NLS-1$
            fModifyListener = new ModifyListener() {
                public void modifyText(ModifyEvent e) {
                    if (e.getSource() == fTextControl) {
                        fText = fTextControl.getText();
                    }

                    if (SwtUtil.isOkToUse((Control) e.getSource())) {
                        fireEvent();
                    }
                }
            };
        }

        public Control createControl(Composite composite) {
            final Composite locationComposite = new Composite(composite, SWT.NONE);
            locationComposite.setLayout(new GridLayout(4, false));

            Button button = getSelectionButton(locationComposite);
            GridData gd = new GridData();
            gd.horizontalSpan = 4;
            gd.horizontalAlignment = GridData.FILL;
            button.setLayoutData(gd);

            Label label = getLabelControl(locationComposite);
            gd = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
            gd.horizontalSpan = 1;
            label.setLayoutData(gd);

            Text text = getTextControl(locationComposite);
            gd = new GridData();
            gd.horizontalAlignment = GridData.FILL;
            gd.grabExcessHorizontalSpace = true;
            gd.horizontalSpan = 2;
            text.setLayoutData(gd);

            Button changebutton = getChangeControl(locationComposite);
            gd = new GridData();
            gd.horizontalAlignment = GridData.FILL;
            gd.grabExcessHorizontalSpace = false;
            gd.horizontalSpan = 1;
            changebutton.setFont(JFaceResources.getDialogFont());
            PixelConverter converter = new PixelConverter(changebutton);
            int widthHint = converter.convertHorizontalDLUsToPixels(IDialogConstants.BUTTON_WIDTH);
            gd.widthHint = Math.max(widthHint, changebutton.computeSize(SWT.DEFAULT, SWT.DEFAULT, true).x);
            changebutton.setLayoutData(gd);

            return locationComposite;
        }

        /**
         * Returns the selection button widget. When called the first time, the widget will be created.
         * 
         * @param group The parent composite when called the first time, or <code>null</code> after.
         */
        public Button getSelectionButton(Composite group) {
            if (fButton == null) {
                fButton = new Button(group, SWT.CHECK);
                fButton.setFont(group.getFont());
                fButton.setText(YMessages.NewExtensionPage_LocationGroup_location_desc);
                fButton.setEnabled(true);
                fButton.setSelection(true);
                fButton.addSelectionListener(new SelectionListener() {
                    public void widgetDefaultSelected(SelectionEvent e) {
                        doWidgetSelected(e);
                    }

                    public void widgetSelected(SelectionEvent e) {
                        doWidgetSelected(e);
                    }

                    private void doWidgetSelected(SelectionEvent e) {
                        if (SwtUtil.isOkToUse(fButton)) {
                            changeValue(fButton.getSelection());
                        }
                    }
                });
            }
            return fButton;
        }

        private void changeValue(final boolean checked) {
            if (fSelection != checked) {
                fSelection = checked;
                if (checked) {
                    fPreviousExternalLocation = fText;
                    setLocationText(getDefaultPath(fNamePackageGroup.getName()));
                    setEnabled(false);
                } else {
                    setLocationText(fPreviousExternalLocation);
                    setEnabled(true);
                }

                fireEvent();
            }
        }

        public Label getLabelControl(Composite parent) {
            if (fLabel == null) {
                fLabel = new Label(parent, SWT.LEFT | SWT.WRAP);
                fLabel.setFont(parent.getFont());
                fLabel.setEnabled(false);
                fLabel.setText(YMessages.NewExtensionPage_LocationGroup_locationLabel_desc);
            }
            return fLabel;
        }

        public Text getTextControl(Composite parent) {
            if (fTextControl == null) {
                fTextControl = new Text(parent, SWT.SINGLE | SWT.BORDER);
                fTextControl.setText(fText);
                fTextControl.setFont(parent.getFont());
                fTextControl.addModifyListener(fModifyListener);
                fTextControl.setEnabled(false);
            }
            return fTextControl;
        }

        /**
         * Creates or returns the created buttom widget.
         * 
         * @param parent The parent composite or <code>null</code> if the widget has already been created.
         */
        public Button getChangeControl(Composite parent) {
            if (fBrowseButton == null) {
                fBrowseButton = new Button(parent, SWT.PUSH);
                fBrowseButton.setFont(parent.getFont());
                fBrowseButton.setText(YMessages.NewExtensionPage_LocationGroup_browseButton_desc);
                fBrowseButton.setEnabled(false);
                fBrowseButton.addSelectionListener(new SelectionListener() {
                    public void widgetDefaultSelected(SelectionEvent e) {
                        changeControlPressed();
                    }

                    public void widgetSelected(SelectionEvent e) {
                        changeControlPressed();
                    }
                });

            }
            return fBrowseButton;
        }

        protected void fireEvent() {
            setChanged();
            notifyObservers();
        }

        protected String getDefaultPath(String name) {
            return getCustomExtensionFolder(name).toOSString();
        }

        private IPath getCustomExtensionFolder(String name) {
            if (platform != null) {
                IPath location = platform.getCustomExtensionLocation();
                if (StringUtils.isEmpty(name)) {
                    return location;
                }
                return location.append(name);
            }
            return new Path(name);
        }

        /*
         * (non-Javadoc)
         * 
         * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
         */
        public void update(Observable o, Object arg) {
            if (isUseDefaultSelected()) {
                if (SwtUtil.isOkToUse(fTextControl)) {
                    fTextControl.setText(getDefaultPath(fNamePackageGroup.getName()));
                }
            }
            fireEvent();
        }

        public IPath getLocation() {
            if (isUseDefaultSelected()) {
                return getCustomExtensionFolder(fNamePackageGroup.getName());
            }
            return Path.fromOSString(fText.trim());
        }

        public boolean isUseDefaultSelected() {
            return fSelection;
        }

        public void setLocation(IPath path) {
            boolean selected = path == null;
            changeValue(selected);
            if (SwtUtil.isOkToUse(fButton)) {
                fButton.setSelection(selected);
            }
            if (path != null) {
                setLocationText(path.toOSString());
            } else {
                setLocationText(getDefaultPath(fNamePackageGroup.getName()));
            }
        }

        public void setLocationText(String location) {
            fText = location;
            if (SwtUtil.isOkToUse(fTextControl)) {
                fTextControl.setText(location);
            }
        }

        /*
         * (non-Javadoc)
         * 
         * @see
         * org.eclipse.jdt.internal.ui.wizards.dialogfields.IStringButtonAdapter#changeControlPressed(org.eclipse.jdt
         * .internal.ui.wizards.dialogfields.DialogField)
         */
        public void changeControlPressed() {
            final DirectoryDialog dialog = new DirectoryDialog(getShell());
            dialog.setMessage(YMessages.NewExtensionPage_directory_message);
            String directoryName = fText.trim();
            if (directoryName.length() == 0) {
                String prevLocation = YPlugin.getDefault().getDialogSettings().get(DIALOGSTORE_LAST_EXTERNAL_LOC);
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
                String oldDirectory = new Path(fText.trim()).lastSegment();
                setLocationText(selectedDirectory);
                String lastSegment = new Path(selectedDirectory).lastSegment();
                if (lastSegment != null
                        && (fNamePackageGroup.getName().length() == 0 || fNamePackageGroup.getName().equals(
                                oldDirectory))) {
                    fNamePackageGroup.setName(lastSegment);
                }
                YPlugin.getDefault().getDialogSettings().put(DIALOGSTORE_LAST_EXTERNAL_LOC, selectedDirectory);
            }
        }

        private void setEnabled(boolean enabled) {
            if (SwtUtil.isOkToUse(fBrowseButton)) {
                fBrowseButton.setEnabled(enabled);
            }
            if (SwtUtil.isOkToUse(fTextControl)) {
                fTextControl.setEnabled(enabled);
            }
            if (fLabel != null) {
                fLabel.setEnabled(enabled);
            }
        }
    }

    private class TemplateGroup extends Observable {

        private String[] fOptions;
        private int fSelectedIndex;
        private final int fDefaultIndex;
        private int fPreviousSelectedIndex;
        private final String fDefaultOption;
        private Label fLabel;
        private Combo fComboControl;
        private Button fButton;
        private boolean fSelection;

        public TemplateGroup(Properties properties) {
            if (properties != null) {
                String[] options = properties.getProperty("extgen.template.list", "").split(",");
                fDefaultOption = properties.getProperty("extgen.template.default", null);
                fOptions = includeDefaultOption(options, fDefaultOption);
            } else {
                fOptions = new String[0];
                fDefaultOption = null;
            }
            fDefaultIndex = findDefaultIndex();
            fSelection = true;
        }

        /**
         * 
         * @param options
         * @param defaultOption
         * @return
         */
        private String[] includeDefaultOption(String[] options, String defaultOption) {
            if (defaultOption == null) {
                return options;
            }
            for (String option : options) {
                if (defaultOption.equals(option)) {
                    return options;
                }
            }
            String[] newOptions = new String[options.length + 1];
            System.arraycopy(options, 0, newOptions, 1, options.length);
            newOptions[0] = defaultOption;
            return newOptions;

        }

        private int findDefaultIndex() {
            if (fDefaultOption != null) {
                for (int i = 0; i < fOptions.length; i++) {
                    if (fDefaultOption.equals(fOptions[i])) {
                        return i;
                    }
                }
            }
            return 0;
        }

        public Control createControl(Composite composite) {
            Group templateGroup = new Group(composite, SWT.NONE);
            templateGroup.setFont(composite.getFont());
            templateGroup.setText(YMessages.NewExtensionPage_TemplateGroup_title);
            templateGroup.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));
            templateGroup.setLayout(new GridLayout(2, false));

            // final Composite templateComposite = new Composite(composite, SWT.NONE);
            // templateComposite.setLayout(new GridLayout(3, false));

            Button button = getSelectionButton(templateGroup);
            button.setLayoutData(new GridData(GridData.FILL, SWT.CENTER, false, false, 2, 1));

            Label label = getLabelControl(templateGroup);
            label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

            Combo combo = getComboControl(templateGroup);
            combo.setLayoutData(new GridData(GridData.FILL, SWT.CENTER, true, false, 1, 1));

            return templateGroup;
        }

        /**
         * Returns the selection button widget. When called the first time, the widget will be created.
         * 
         * @param group The parent composite when called the first time, or <code>null</code> after.
         */
        public Button getSelectionButton(Composite group) {
            if (fButton == null) {
                fButton = new Button(group, SWT.CHECK);
                fButton.setFont(group.getFont());
                fButton.setText(YMessages.NewExtensionPage_TemplateGroup_template_desc);
                fButton.setEnabled(fOptions.length > 0);
                fButton.setSelection(true);
                fButton.addSelectionListener(new SelectionListener() {
                    public void widgetDefaultSelected(SelectionEvent e) {
                        doWidgetSelected(e);
                    }

                    public void widgetSelected(SelectionEvent e) {
                        doWidgetSelected(e);
                    }

                    private void doWidgetSelected(SelectionEvent e) {
                        if (SwtUtil.isOkToUse(fButton)) {
                            changeValue(fButton.getSelection());
                        }
                    }
                });
            }
            return fButton;
        }

        private void changeValue(final boolean checked) {
            if (fSelection != checked) {
                fSelection = checked;
                if (checked) {
                    fPreviousSelectedIndex = fSelectedIndex;
                    setDefaultIndex();
                    setEnabled(false);
                } else {
                    setSelectedIndex(fPreviousSelectedIndex);
                    setEnabled(true);
                }

                fireEvent();
            }
        }

        public Label getLabelControl(Composite parent) {
            if (fLabel == null) {
                fLabel = new Label(parent, SWT.LEFT | SWT.WRAP);
                fLabel.setFont(parent.getFont());
                fLabel.setEnabled(false);
                fLabel.setText(YMessages.NewExtensionPage_TemplateGroup_templateLabel_desc);
            }
            return fLabel;
        }

        public Combo getComboControl(Composite parent) {
            if (fComboControl == null) {
                fComboControl = new Combo(parent, SWT.SINGLE | SWT.BORDER | SWT.READ_ONLY);
                fComboControl.setFont(parent.getFont());
                fComboControl.setEnabled(false);
                fComboControl.setItems(fOptions);
                fComboControl.select(fDefaultIndex);
                fComboControl.addSelectionListener(new SelectionListener() {

                    public void widgetSelected(SelectionEvent e) {
                        updateIndexes();
                    }

                    public void widgetDefaultSelected(SelectionEvent e) {
                        updateIndexes();
                    }

                    private void updateIndexes() {
                        fPreviousSelectedIndex = fSelectedIndex;
                        fSelectedIndex = fComboControl.getSelectionIndex();
                    }
                });
            }
            return fComboControl;
        }

        protected void fireEvent() {
            setChanged();
            notifyObservers();
        }

        public String getTemplate() {
            int index = isUseDefaultSelected() ? fDefaultIndex : fSelectedIndex;
            return fOptions.length > index ? fOptions[index] : null;
        }

        public boolean isUseDefaultSelected() {
            return fSelection;
        }

        public void setDefaultIndex() {
            if (SwtUtil.isOkToUse(fComboControl)) {
                fComboControl.select(fDefaultIndex);
            }
        }

        public void setSelectedIndex(int index) {
            fSelectedIndex = index;
            if (SwtUtil.isOkToUse(fComboControl)) {
                fComboControl.select(index);
            }
        }

        private void setEnabled(boolean enabled) {
            if (SwtUtil.isOkToUse(fComboControl)) {
                fComboControl.setEnabled(enabled);
            }
            if (fLabel != null) {
                fLabel.setEnabled(enabled);
            }
        }
    }

    /**
     * Validate this page and show appropriate warnings and error YMessages.
     */
    private final class Validator implements Observer {

        public void update(Observable o, Object arg) {
            validateForm();
        }

        private IStatus validatePackageName(String packName) {
            IJavaProject project = getJavaProject();
            if (project == null || !project.exists()) {
                return JavaConventions.validatePackageName(packName, JavaCore.VERSION_1_3, JavaCore.VERSION_1_3);
            }
            return JavaConventions.validatePackageName(packName, project.getOption(JavaCore.COMPILER_SOURCE, true),
                    project.getOption(JavaCore.COMPILER_COMPLIANCE, true));
        }

        private void validateForm() {
            // check if there is eCommerce platform
            if (platform == null) {
                setErrorMessage(YMessages.NewExtensionPage_error_PlatformDoesNotExist);
                setPageComplete(false);
                return;
            }

            final IWorkspace workspace = ResourcesPlugin.getWorkspace();

            final String name = fNamePackageGroup.getName();

            // check whether the project name field is empty
            if (name.length() == 0) {
                setErrorMessage(null);
                setMessage(YMessages.NewExtensionPage_Message_enterProjectName);
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
                setErrorMessage(YMessages.NewExtensionPage_Message_projectAlreadyExists);
                setPageComplete(false);
                return;
            }

            final String location = fLocationGroup.getLocation().toOSString();

            // check whether location is empty
            if (location.length() == 0) {
                setErrorMessage(null);
                setMessage(YMessages.NewExtensionPage_Message_enterLocation);
                setPageComplete(false);
                return;
            }

            // check whether the location is a syntactically correct path
            if (!Path.EMPTY.isValidPath(location)) {
                setErrorMessage(YMessages.NewExtensionPage_Message_invalidDirectory);
                setPageComplete(false);
                return;
            }

            // check whether external location exists or cannot be created
            IPath projectPath = Path.fromOSString(location);
            if (projectPath.toFile().exists()) {
                setErrorMessage(YMessages.NewExtensionPage_Message_cannotCreateAtExternalLocation);
                setPageComplete(false);
                return;
            } else if (!canCreate(projectPath.toFile())) {
                setErrorMessage(YMessages.NewExtensionPage_Message_cannotCreateAtExternalLocation);
                setPageComplete(false);
                return;
            }

            // validate the location
            final IStatus locationStatus = workspace.validateProjectLocation(handle, projectPath);
            if (!locationStatus.isOK()) {
                setErrorMessage(locationStatus.getMessage());
                setPageComplete(false);
                return;
            }

            String packName = fNamePackageGroup.getPackageName();
            IStatus val = null;
            if (packName.length() > 0) {
                val = validatePackageName(packName);
                if (val.getSeverity() == IStatus.ERROR) {
                    setErrorMessage(MessageFormat.format(YMessages.NewExtensionPage_error_InvalidPackageName,
                            val.getMessage()));
                    setPageComplete(false);
                    return;
                }
            } else {
                setMessage(YMessages.NewExtensionPage_error_EnterPackageName);
                setErrorMessage(null);
                setPageComplete(false);
                return;
            }

            // check whether no templates defined
            if (fTemplateGroup.fOptions.length == 0) {
                setErrorMessage(YMessages.NewExtensionPage_Message_noTemplates);
                setPageComplete(false);
                return;
            }

            // check whether no template has been chosen
            if (StringUtils.isEmpty(fTemplateGroup.getTemplate())) {
                setErrorMessage(YMessages.NewExtensionPage_error_TemplateNotChosen);
                setPageComplete(false);
                return;
            }

            // check whether extension template folder exists
            File templatePath = new File(fProperties.getProperty(EXTGEN_TEMPLATE_PATH + fTemplateGroup.getTemplate()));
            if (!templatePath.exists()) {
                try {
                    setErrorMessage(MessageFormat.format(YMessages.NewExtensionPage_error_TemplateFolderDoesNotExist,
                            templatePath.getCanonicalPath()));
                } catch (IOException e) {
                    setErrorMessage(MessageFormat.format(YMessages.NewExtensionPage_error_TemplateFolderDoesNotExist,
                            templatePath.getPath()));
                }
                setPageComplete(false);
                return;
            }

            // WARNINGS go here
            if (val.getSeverity() == IStatus.WARNING) {
                setErrorMessage(null);
                setMessage(MessageFormat.format(YMessages.NewExtensionPage_warning_DiscouragedPackageName,
                        val.getMessage()));
                setPageComplete(true);
                return;
            }

            // check whether no template selected. display info only if there are no errors registered
            if (fTemplateGroup.isUseDefaultSelected() && fTemplateGroup.fDefaultOption == null) {
                if (StringUtils.isEmpty(getErrorMessage())) {
                    setErrorMessage(null);
                    setMessage(YMessages.NewExtensionPage_Message_defaultTemplateDoesNotExist);
                    setPageComplete(true);
                }
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

}