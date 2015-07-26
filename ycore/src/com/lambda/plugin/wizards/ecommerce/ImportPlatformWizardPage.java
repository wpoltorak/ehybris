package com.lambda.plugin.wizards.ecommerce;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import org.eclipse.core.filesystem.URIUtil;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.internal.ui.workingsets.IWorkingSetIDs;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IWorkingSet;
import org.eclipse.ui.dialogs.WorkingSetGroup;

import com.lambda.plugin.YCore;
import com.lambda.plugin.YMessages;
import com.lambda.plugin.YNature;
import com.lambda.plugin.core.IPlatformInstallation;
import com.lambda.plugin.core.jaxb.extensions.ExtensionsConf;
import com.lambda.plugin.utils.FileUtils;
import com.lambda.plugin.utils.StringUtils;

public class ImportPlatformWizardPage extends AbstractWizardPage {

    private static final String PAGE_NAME = "ImportPlatformWizardPage";//$NON-NLS-1$

    private Combo rootDirectoryCombo;
    private WorkingSetGroup fWorkingSetGroup;
    private CheckboxTreeViewer projectTreeViewer;

    protected ImportPlatformWizardPage() {
        super(PAGE_NAME);
        setTitle(YMessages.ImportPlatformPage_title);
        setDescription(YMessages.ImportPlatformPage_description);
        setPageComplete(false);
    }

    @Override
    @SuppressWarnings("restriction")
    public void createControl(Composite parent) {
        final Composite composite = new Composite(parent, SWT.NULL);
        composite.setFont(parent.getFont());
        composite.setLayout(initGridLayout(new GridLayout(1, false), true));
        composite.setLayoutData(new GridData(GridData.HORIZONTAL_ALIGN_FILL));
        setControl(composite);

        Composite platformComposite = new Composite(composite, SWT.NONE);
        platformComposite.setFont(composite.getFont());
        platformComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        platformComposite.setLayout(new GridLayout(3, false));

        final Label selectRootDirectoryLabel = new Label(platformComposite, SWT.NONE);
        selectRootDirectoryLabel.setText(YMessages.ImportPlatformPage_platformRootFolder);
        selectRootDirectoryLabel.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

        rootDirectoryCombo = new Combo(platformComposite, SWT.NONE);
        rootDirectoryCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
        rootDirectoryCombo.setFocus();

        final Button browseButton = new Button(platformComposite, SWT.NONE);
        browseButton.setText(YMessages.ImportPlatformPage_browse);
        browseButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
        browseButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                DirectoryDialog dialog = new DirectoryDialog(getShell(), SWT.NONE);
                dialog.setText(YMessages.ImportPlatformPage_selectPlatformRootFolder);
                String path = rootDirectoryCombo.getText();
                if (path.length() == 0) {
                    path = ResourcesPlugin.getWorkspace().getRoot().getLocation().toPortableString();
                }
                dialog.setFilterPath(path);

                String result = dialog.open();
                if (result != null) {
                    rootDirectoryCombo.setText(result);
                    scanProjects();
                }
            }
        });

        final Label projectsLabel = new Label(platformComposite, SWT.NONE);
        projectsLabel.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
        projectsLabel.setText(YMessages.ImportPlatformPage_projects);

        projectTreeViewer = new CheckboxTreeViewer(platformComposite, SWT.BORDER);

        projectTreeViewer.addCheckStateListener(new ICheckStateListener() {
            @Override
            public void checkStateChanged(CheckStateChangedEvent event) {
                updateCheckedState();
                setPageComplete();
            }
        });

        projectTreeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                IStructuredSelection selection = (IStructuredSelection) event.getSelection();
                if (selection.getFirstElement() != null) {
                    String errorMsg = validateExtension((PlatformExtension) selection.getFirstElement());
                    setMessage(errorMsg, IMessageProvider.WARNING);
                } else {
                    // TODO if on current selection, shall show any existing general errors if existing..
                    // setMessage(loadingErrorMessage, IMessageProvider.WARNING);
                }
            }
        });

        projectTreeViewer.setContentProvider(new ITreeContentProvider() {

            @Override
            public Object[] getElements(Object element) {
                if (element instanceof List) {
                    @SuppressWarnings("unchecked")
                    List<PlatformExtension> projects = (List<PlatformExtension>) element;
                    return projects.toArray(new PlatformExtension[projects.size()]);
                } else if (element instanceof PlatformExtension) {
                    return new PlatformExtension[] { (PlatformExtension) element };
                }
                return new Object[0];
            }

            @Override
            public Object[] getChildren(Object parentElement) {
                if (parentElement instanceof List) {
                    @SuppressWarnings("unchecked")
                    List<PlatformExtension> projects = (List<PlatformExtension>) parentElement;
                    return projects.toArray(new PlatformExtension[projects.size()]);
                } else if (parentElement instanceof PlatformExtension) {
                    PlatformExtension ext = (PlatformExtension) parentElement;
                    return ext.children.toArray(new PlatformExtension[ext.children.size()]);
                }
                return new Object[0];
            }

            @Override
            public Object getParent(Object element) {
                return ((PlatformExtension) element).parent;
            }

            @Override
            public boolean hasChildren(Object parentElement) {
                if (parentElement instanceof List) {
                    List<?> projects = (List<?>) parentElement;
                    return !projects.isEmpty();
                } else if (parentElement instanceof PlatformExtension) {
                    PlatformExtension ext = (PlatformExtension) parentElement;
                    return !ext.children.isEmpty();
                }
                return false;
            }

            @Override
            public void dispose() {
            }

            @Override
            public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
            }
        });

        projectTreeViewer.setLabelProvider(new DelegatingStyledCellLabelProvider(new ExtensionLabelProvider()));

        final Tree projectTree = projectTreeViewer.getTree();
        GridData projectTreeData = new GridData(SWT.FILL, SWT.FILL, true, true, 2, 3);
        projectTreeData.heightHint = 250;
        projectTreeData.widthHint = 500;
        projectTree.setLayoutData(projectTreeData);

        final Button selectAllButton = new Button(platformComposite, SWT.NONE);
        selectAllButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
        selectAllButton.setText(YMessages.ImportPlatformPage_selectAll);
        selectAllButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                projectTreeViewer.expandAll();
                setAllChecked(true);
                setPageComplete();
            }
        });

        final Button deselectAllButton = new Button(platformComposite, SWT.NONE);
        deselectAllButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, false));
        deselectAllButton.setText(YMessages.ImportPlatformPage_deselectAll);
        deselectAllButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                setAllChecked(false);
                setPageComplete(false);
            }

        });

        final Button refreshButton = new Button(platformComposite, SWT.NONE);
        refreshButton.setLayoutData(new GridData(SWT.FILL, SWT.TOP, false, true));
        refreshButton.setText(YMessages.ImportPlatformPage_refresh);
        refreshButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                scanProjects();
            }
        });

        fWorkingSetGroup = new WorkingSetGroup(composite, null,
                new String[] { IWorkingSetIDs.JAVA, IWorkingSetIDs.RESOURCE });
    }

    /**
     * Returns the working sets to which the new project should be added.
     * 
     * @return the selected working sets to which the new project should be added
     */
    public IWorkingSet[] getWorkingSets() {
        return fWorkingSetGroup.getSelectedWorkingSets();
    }

    private String validateExtension(PlatformExtension ext) {
        if (ext.projectName == null) {
            return YMessages.ImportPlatformPage_error_ExtensionNotExistsInFS;
        }

        IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(ext.projectName);
        if (project.exists()) {
            if (project.getFullPath().equals(ext.path)) {
                if (ext instanceof PlatformRoot) {
                    return YMessages.ImportPlatformPage_error_PlatformAlreadyImported;
                } else if (ext instanceof PlatformConfig) {
                    return YMessages.ImportPlatformPage_error_PlatformConfigAlreadyImported;
                }
                return YMessages.ImportPlatformPage_error_ExtensionAlreadyImported;
            } else {
                IPlatformInstallation existingPlatform = YCore.getDefault().getPlatformContainer().getDefaultPlatform();

                if (existingPlatform != null && project.getFullPath().equals(existingPlatform.getPlatformLocation())) {
                    return YMessages.ImportPlatformPage_error_PlatformAlreadyImported;
                }
                return YMessages.ImportPlatformPage_error_ProjectAlreadyExistsInWorkspace;
            }
        }
        return null;
    }

    private String getProjectName(IPath project) {
        try {
            IProjectDescription description = ResourcesPlugin.getWorkspace().loadProjectDescription(project);
            if (description != null) {
                return description.getName();
            }
        } catch (CoreException e) {
            YCore.logError(e);
        }
        return null;
    }

    private void scanProjects() {
        projectTreeViewer.setInput(null);

        final String text = rootDirectoryCombo.getText();
        if (StringUtils.isEmpty(text)) {
            setPageComplete(false);
            setErrorMessage(YMessages.ImportPlatformPage_error_InvalidPlatformDirectory);
            return;
        }
        final IPlatformInstallation platform = YCore.getDefault().getPlatformContainer()
                .verifyPlatformLocation(lookupPlatform(text));

        if (platform == null) {
            setPageComplete(false);
            setErrorMessage(YMessages.ImportPlatformPage_error_InvalidPlatformDirectory);
            return;
        }
        String platformProjectName = getProjectName(platform.getPlatformLocation().append(".project"));
        final PlatformExtension root = new PlatformRoot(platform, platformProjectName);

        // TODO sprawdzic czy nazwa configa jest taka sama jak nazwa project eclipsowego configa
        String configProjectName = getProjectName(platform.getConfigLocation().append(".project"));
        if (configProjectName == null) {
            setPageComplete(false);
            setErrorMessage(YMessages.ImportPlatformPage_error_MissingPlatformConfig);
            return;
        }

        root.addExtension(new PlatformConfig(platform.getConfigLocation(), configProjectName, configProjectName));

        IRunnableWithProgress runnable = new IRunnableWithProgress() {
            @Override
            public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
                try {
                    monitor.beginTask("Searching for extensions", IProgressMonitor.UNKNOWN);
                    ExtensionsConf config = ExtensionsConf.loadExtensions(platform);
                    List<String> visitedFolders = new ArrayList<String>();
                    scanDirectory(monitor, config, visitedFolders, platform.getBinLocation(), platform);

                } finally {
                    monitor.done();
                }
            }

            private void scanDirectory(IProgressMonitor monitor, ExtensionsConf config, List<String> visitedFolders,
                    IPath path, IPlatformInstallation platform) throws InterruptedException {
                try {
                    if (monitor.isCanceled()) {
                        throw new InterruptedException("User cancelled extension scanning");
                    }
                    String canonicalPath = path.toFile().getCanonicalPath();
                    monitor.subTask(canonicalPath);
                    if (!visitedFolders.add(canonicalPath)) {
                        return;
                    }
                    IPath projectDescriptionPath = path.append(".project");
                    File extInfo = path.append("extensioninfo.xml").toFile();
                    if (projectDescriptionPath.toFile().exists() && extInfo.exists()) {
                        String extName = path.lastSegment().toString();
                        String projectName = getProjectName(projectDescriptionPath);
                        root.addExtension(
                                new PlatformExtension(path, extName, projectName, config.isReferenced(extName)));
                    } else if (!platform.getPlatformLocation().equals(path)) {
                        File[] folders = FileUtils.listFolders(path.toFile());
                        for (File folder : folders) {
                            scanDirectory(monitor, config, visitedFolders, new Path(folder.getAbsolutePath()),
                                    platform);
                        }
                    }
                } catch (IOException e) {
                    // TODO error handling + testing
                    YCore.logError(e);
                } finally {
                    monitor.worked(1);
                }

            }
        };

        try {
            getContainer().run(true, true, runnable);
        } catch (Exception e) {
            YCore.logError(e);
        }

        projectTreeViewer.setInput(Collections.singletonList(root));
        projectTreeViewer.expandAll();

        checkPlatformAndReferencedExtensions();
        setPageComplete();
        setErrorMessage(null);
        setMessage(null);
    }

    private File lookupPlatform(String pathString) {
        File file = new File(pathString);
        if (file.isFile()) {
            file = file.getParentFile();
        }
        if (!file.isDirectory()) {
            return null;
        }

        IPath path = Path.fromOSString(file.getAbsolutePath()).removeTrailingSeparator();

        return lookupPlatform(path);
    }

    private File lookupPlatform(IPath path) {
        switch (path.lastSegment()) {
        case "platform":
            return path.toFile();
        case "bin":
            return lookupPlatform(path.append("platform"));
        case "hybris":
            return lookupPlatform(path.append("bin").append("platform"));
        default:
            if (path.append("hybris").toFile().exists()) {
                return lookupPlatform(path.append("hybris").append("bin").append("platform"));
            }
        }
        return null;
    }

    private void setPageComplete() {
        Object[] elements = projectTreeViewer.getCheckedElements();
        for (Object element : elements) {
            if (element instanceof PlatformRoot) {
                setPageComplete(true);
                return;
            }
        }
        setPageComplete(false);
    }

    private void setAllChecked(boolean checked) {
        @SuppressWarnings("unchecked")
        List<PlatformRoot> input = (List<PlatformRoot>) projectTreeViewer.getInput();
        if (input != null) {
            for (PlatformRoot root : input) {
                projectTreeViewer.setChecked(root, checked);
                for (PlatformExtension ext : root.children) {
                    projectTreeViewer.setChecked(ext, checked);
                }
                updateCheckedState();
            }
            updateCheckedState();
        }
    }

    @SuppressWarnings("unchecked")
    private void checkPlatformAndReferencedExtensions() {
        // TODO inaczej sprawdzenie, instanceof?
        List<PlatformRoot> input = (List<PlatformRoot>) projectTreeViewer.getInput();
        if (input != null) {
            for (PlatformRoot root : input) {
                projectTreeViewer.setChecked(root, true);
                for (PlatformExtension ext : root.children) {
                    projectTreeViewer.setChecked(ext, ext.referenced);
                }
            }
            updateCheckedState();
        }
    }

    private void updateCheckedState() {

        Object[] elements = projectTreeViewer.getCheckedElements();
        for (int i = 0; i < elements.length; i++) {
            Object element = elements[i];
            if (element instanceof PlatformExtension) {
                PlatformExtension ext = (PlatformExtension) element;
                if (parentUnchecked(ext) || validateExtension(ext) != null) {
                    projectTreeViewer.setChecked(ext, false);
                }
            }
        }
        projectTreeViewer.refresh();
    }

    private boolean parentUnchecked(PlatformExtension ext) {
        return ext.parent != null && projectTreeViewer.getChecked(ext.parent) == false;
    }

    boolean createExtensions(IProgressMonitor monitor) throws CoreException {
        if (monitor == null) {
            monitor = new NullProgressMonitor();
        }
        final List<PlatformExtension> extensions = new ArrayList<PlatformExtension>();
        Display.getDefault().syncExec(new Runnable() {
            @Override
            public void run() {
                Object[] elements = projectTreeViewer.getCheckedElements();
                for (int i = 0; i < elements.length; i++) {
                    Object element = elements[i];
                    if (element instanceof PlatformExtension) {
                        extensions.add((PlatformExtension) element);
                    }
                }
            }
        });

        try {
            monitor.beginTask("Importing eCommerce platform...", extensions.size());
            IWorkspaceRoot root = ResourcesPlugin.getWorkspace().getRoot();
            for (PlatformExtension extension : extensions) {
                SubProgressMonitor submonitor = new SubProgressMonitor(monitor, 1,
                        SubProgressMonitor.PREPEND_MAIN_LABEL_TO_SUBTASK);
                try {
                    submonitor.subTask("importing " + extension.projectName);
                    if (extension instanceof PlatformConfig) {
                        createConfig(root, (PlatformConfig) extension, submonitor);
                    } else if (extension instanceof PlatformRoot) {
                        createPlatform(root, (PlatformRoot) extension, submonitor);
                    } else {
                        createExtension(root, extension, submonitor);
                    }
                } finally {
                    submonitor.done();
                }
            }
            return true;
        } finally {
            monitor.done();
        }
    }

    private void createPlatform(IWorkspaceRoot root, PlatformRoot ext, IProgressMonitor monitor) throws CoreException {
        doCreateExtension(root, ext, monitor);
        IPlatformInstallation platform = YCore.getDefault().getPlatformContainer()
                .verifyPlatformLocation(ext.path.toFile());
        if (platform != null) {
            YCore.getDefault().getPlatformContainer().setDefaultPlatform(platform);
        }
    }

    private void createExtension(IWorkspaceRoot root, PlatformExtension ext, IProgressMonitor monitor)
            throws CoreException {
        doCreateExtension(root, ext, monitor);
    }

    private void createConfig(IWorkspaceRoot root, PlatformConfig ext, IProgressMonitor monitor) throws CoreException {
        IProject project = createProject(root, ext, monitor);
        YCore.getDefault().getNatureManager().addNature(JavaCore.NATURE_ID, project, monitor);
        JavaCore.create(project);
    }

    private void doCreateExtension(IWorkspaceRoot root, PlatformExtension ext, IProgressMonitor monitor)
            throws CoreException {
        IProject project = createProject(root, ext, monitor);
        YCore.getDefault().getNatureManager().addNature(JavaCore.NATURE_ID, project, monitor);
        YCore.getDefault().getNatureManager().addNature(YNature.NATURE_ID, project, monitor);
        JavaCore.create(project);
    }

    private IProject createProject(IWorkspaceRoot root, PlatformExtension ext, IProgressMonitor monitor)
            throws CoreException {
        IProject project = root.getProject(ext.projectName);
        if (!project.exists()) {
            IProjectDescription desc = project.getWorkspace().newProjectDescription(project.getName());
            URI locationURI = URIUtil.toURI(ext.path);
            if (locationURI != null && ResourcesPlugin.getWorkspace().getRoot().getLocationURI().equals(locationURI)) {
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
        return project;
    }

    private class PlatformRoot extends PlatformExtension {

        private final String vendor;
        private final String version;

        public PlatformRoot(IPlatformInstallation platform, String projectName) {
            super(platform.getPlatformLocation(),
                    StringUtils.isEmpty(platform.getName()) ? projectName : platform.getName(), projectName, true);
            vendor = platform.getVendor();
            version = platform.getVersion().get();
        }

        @Override
        protected StyledString styledText() {
            StyledString ss = new StyledString();
            ss.append(name);
            ss.append(" - "); //$NON-NLS-1$
            ss.append(vendor + " " + version, StyledString.DECORATIONS_STYLER); // $NON-NLS-2$ //$NON-NLS-3$
            return ss;
        }
    }

    private class PlatformConfig extends PlatformExtension {

        private PlatformConfig(IPath path, String name, String projectName) {
            super(path, name, projectName, true);
        }

        @Override
        protected StyledString styledText() {
            StyledString ss = new StyledString();
            ss.append(name);
            ss.append(path.makeRelativeTo(parent.path.removeLastSegments(1)).toString(), StyledString.COUNTER_STYLER); // $NON-NLS-1$
            return ss;
        }
    }

    private class PlatformExtension {
        protected final IPath path;
        protected final String name;
        protected final String projectName;
        protected final boolean referenced;
        protected final TreeSet<PlatformExtension> children = new TreeSet<PlatformExtension>(
                new Comparator<PlatformExtension>() {
                    @Override
                    public int compare(PlatformExtension o1, PlatformExtension o2) {
                        if (o1.parent == null) {
                            return 1;
                        }
                        if (o1 instanceof PlatformConfig) {
                            return 1;
                        }
                        return o1.name.compareTo(o2.name);
                    }
                });
        protected PlatformExtension parent;

        private PlatformExtension(IPath path, String name, String projectName, boolean referenced) {
            this.path = path;
            this.name = name;
            this.projectName = projectName;
            this.referenced = referenced;
        }

        private void addExtension(PlatformExtension extension) {
            extension.parent = this;
            children.add(extension);
        }

        protected StyledString styledText() {
            StyledString ss = new StyledString();
            ss.append(name);
            ss.append(" - "); //$NON-NLS-1$
            ss.append(path.makeRelativeTo(parent.path.removeLastSegments(1)).toString(), StyledString.QUALIFIER_STYLER);
            return ss;
        }
    }

    private class ExtensionLabelProvider extends LabelProvider
            implements IColorProvider, DelegatingStyledCellLabelProvider.IStyledLabelProvider {

        @Override
        public String getText(Object element) {
            if (element instanceof PlatformExtension) {
                PlatformExtension info = (PlatformExtension) element;
                return info.name;
            }
            return super.getText(element);
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.IColorProvider#getBackground(java.lang.Object)
         */
        @Override
        public Color getForeground(Object element) {
            if (element instanceof PlatformExtension) {
                PlatformExtension ext = (PlatformExtension) element;
                // if (isWorkspaceFolder(ext)) {
                // return Display.getDefault().getSystemColor(SWT.COLOR_RED);
                // } else
                if (parentUnchecked(ext) || validateExtension(ext) != null) {
                    return Display.getDefault().getSystemColor(SWT.COLOR_GRAY);
                }
            }
            return null;
        }

        /*
         * (non-Javadoc)
         * 
         * @see org.eclipse.jface.viewers.IColorProvider#getForeground(java.lang.Object)
         */
        @Override
        public Color getBackground(Object element) {
            return null;
        }

        /*
         * (non-Javadoc)
         * 
         * @see
         * org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider#getStyledText(java.lang.
         * Object)
         */
        @Override
        public StyledString getStyledText(Object element) {
            if (element instanceof PlatformExtension) {
                return ((PlatformExtension) element).styledText();
            }
            return null;
        }
    }
}
