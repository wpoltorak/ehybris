package com.lambda.plugin.impex.preferences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.ant.internal.ui.preferences.AntEditorPreferenceConstants;
import org.eclipse.ant.internal.ui.preferences.AntPreferencesMessages;
import org.eclipse.ant.internal.ui.preferences.ColorEditor;
import org.eclipse.ant.internal.ui.preferences.TabFolderLayout;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.model.WorkbenchViewerComparator;

import com.lambda.plugin.YPlugin;

public class ImpexPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

    private String[][] fSyntaxColorListModel;
    private ColorEditor fSyntaxForegroundColorEditor;
    private Button fBoldCheckBox;
    private Button fItalicCheckBox;

    private TableViewer fHighlightingColorListViewer;
    private final java.util.List fHighlightingColorList = new ArrayList(5);

    @Override
    public String getDescription() {
        return "Expand the tree to edit preferences for a specific feature.";
    }

    @Override
    protected Control createContents(final Composite parent) {
        getOverlayStore().load();
        getOverlayStore().start();

        createHeader(parent);

        final TabFolder folder = new TabFolder(parent, SWT.NONE);
        folder.setLayout(new TabFolderLayout());
        folder.setLayoutData(new GridData(GridData.FILL_BOTH));

        final TabItem item = new TabItem(folder, SWT.NONE);
        item.setText(AntPreferencesMessages.AntEditorPreferencePage_1);
        item.setControl(createSyntaxPage(folder));

        initialize();

        applyDialogFont(parent);
        return folder;
    }

    private void initialize() {

        initializeFields();

        for (int i = 0, n = fSyntaxColorListModel.length; i < n; i++) {
            fHighlightingColorList.add(new HighlightingColorListItem(fSyntaxColorListModel[i][0], fSyntaxColorListModel[i][1],
                    fSyntaxColorListModel[i][1] + AntEditorPreferenceConstants.EDITOR_BOLD_SUFFIX, fSyntaxColorListModel[i][1]
                            + AntEditorPreferenceConstants.EDITOR_ITALIC_SUFFIX, null));
        }
        fHighlightingColorListViewer.setInput(fHighlightingColorList);
        fHighlightingColorListViewer.setSelection(new StructuredSelection(fHighlightingColorListViewer.getElementAt(0)));
    }

    protected void initializeFields() {
        final Map checkBoxes = getCheckBoxes();
        final Map textFields = getTextFields();
        Iterator e = checkBoxes.keySet().iterator();
        while (e.hasNext()) {
            final Button b = (Button) e.next();
            final String key = (String) checkBoxes.get(b);
            b.setSelection(getOverlayStore().getBoolean(key));
        }

        e = textFields.keySet().iterator();
        while (e.hasNext()) {
            final Text t = (Text) e.next();
            final String key = (String) textFields.get(t);
            t.setText(getOverlayStore().getString(key));
        }
        fInitialized = true;
    }

    private void createHeader(final Composite contents) {
        final Link link = new Link(contents, SWT.NONE);
        link.setText(AntPreferencesMessages.AntEditorPreferencePage_0);
        link.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(final SelectionEvent e) {
                if ("org.eclipse.ui.preferencePages.GeneralTextEditor".equals(e.text)) {
                    PreferencesUtil.createPreferenceDialogOn(link.getShell(), e.text, null, null);
                } else if ("org.eclipse.ui.preferencePages.ColorsAndFonts".equals(e.text)) {
                    PreferencesUtil.createPreferenceDialogOn(link.getShell(), e.text, null, "selectFont:org.eclipse.jface.textfont"); //$NON-NLS-1$
                }
            }
        });
        final String linktooltip = AntPreferencesMessages.AntEditorPreferencePage_3;
        link.setToolTipText(linktooltip);
    }

    @Override
    protected IPreferenceStore doGetPreferenceStore() {
        return YPlugin.getDefault().getPreferenceStore();
    }

    public void init(final IWorkbench workbench) {
    }

    /**
     * Item in the highlighting color list.
     * 
     * @since 3.0
     */
    private class HighlightingColorListItem {
        /** Display name */
        private final String fDisplayName;
        /** Color preference key */
        private final String fColorKey;
        /** Bold preference key */
        private final String fBoldKey;
        /** Italic preference key */
        private final String fItalicKey;
        /** Item color */
        private final Color fItemColor;

        /**
         * Initialize the item with the given values.
         * 
         * @param displayName the display name
         * @param colorKey the color preference key
         * @param boldKey the bold preference key
         * @param italicKey the italic preference key
         * @param itemColor the item color
         */
        public HighlightingColorListItem(final String displayName, final String colorKey, final String boldKey, final String italicKey,
                final Color itemColor) {
            fDisplayName = displayName;
            fColorKey = colorKey;
            fBoldKey = boldKey;
            fItalicKey = italicKey;
            fItemColor = itemColor;
        }

        /**
         * @return the bold preference key
         */
        public String getBoldKey() {
            return fBoldKey;
        }

        /**
         * @return the bold preference key
         */
        public String getItalicKey() {
            return fItalicKey;
        }

        /**
         * @return the color preference key
         */
        public String getColorKey() {
            return fColorKey;
        }

        /**
         * @return the display name
         */
        public String getDisplayName() {
            return fDisplayName;
        }

        /**
         * @return the item color
         */
        public Color getItemColor() {
            return fItemColor;
        }
    }

    /**
     * Color list label provider.
     * 
     * @since 3.0
     */
    private class ColorListLabelProvider extends LabelProvider implements IColorProvider {

        /*
         * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
         */
        @Override
        public String getText(final Object element) {
            return ((HighlightingColorListItem) element).getDisplayName();
        }

        /*
         * @see org.eclipse.jface.viewers.IColorProvider#getForeground(java.lang.Object)
         */
        public Color getForeground(final Object element) {
            return ((HighlightingColorListItem) element).getItemColor();
        }

        /*
         * @see org.eclipse.jface.viewers.IColorProvider#getBackground(java.lang.Object)
         */
        public Color getBackground(final Object element) {
            return null;
        }
    }

    /**
     * Color list content provider.
     * 
     * @since 3.0
     */
    private class ColorListContentProvider implements IStructuredContentProvider {

        /*
         * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
         */
        public Object[] getElements(final Object inputElement) {
            return ((java.util.List) inputElement).toArray();
        }

        /*
         * @see org.eclipse.jface.viewers.IContentProvider#dispose()
         */
        public void dispose() {
        }

        /*
         * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object,
         * java.lang.Object)
         */
        public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
        }
    }

    private Control createSyntaxPage(final Composite parent) {

        final Composite colorComposite = new Composite(parent, SWT.NONE);
        colorComposite.setLayout(new GridLayout());

        Label label = new Label(colorComposite, SWT.LEFT);
        label.setText(AntPreferencesMessages.AntEditorPreferencePage_5);
        label.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        final Composite editorComposite = new Composite(colorComposite, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        editorComposite.setLayout(layout);
        GridData gd = new GridData(GridData.FILL_BOTH);
        editorComposite.setLayoutData(gd);

        fHighlightingColorListViewer = new TableViewer(editorComposite, SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION);
        fHighlightingColorListViewer.setLabelProvider(new ColorListLabelProvider());
        fHighlightingColorListViewer.setContentProvider(new ColorListContentProvider());
        fHighlightingColorListViewer.setComparator(new WorkbenchViewerComparator());
        gd = new GridData(GridData.FILL_BOTH);
        gd.heightHint = convertHeightInCharsToPixels(5);
        fHighlightingColorListViewer.getControl().setLayoutData(gd);

        final Composite stylesComposite = new Composite(editorComposite, SWT.NONE);
        layout = new GridLayout();
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        layout.numColumns = 2;
        stylesComposite.setLayout(layout);
        stylesComposite.setLayoutData(new GridData(GridData.FILL_BOTH));

        label = new Label(stylesComposite, SWT.LEFT);
        label.setText(AntPreferencesMessages.AntEditorPreferencePage_6);
        gd = new GridData();
        gd.horizontalAlignment = GridData.BEGINNING;
        label.setLayoutData(gd);

        fSyntaxForegroundColorEditor = new ColorEditor(stylesComposite);
        final Button foregroundColorButton = fSyntaxForegroundColorEditor.getButton();
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalAlignment = GridData.BEGINNING;
        foregroundColorButton.setLayoutData(gd);

        fBoldCheckBox = new Button(stylesComposite, SWT.CHECK);
        fBoldCheckBox.setText(AntPreferencesMessages.AntEditorPreferencePage_7);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalAlignment = GridData.BEGINNING;
        gd.horizontalSpan = 2;
        fBoldCheckBox.setLayoutData(gd);

        fItalicCheckBox = new Button(stylesComposite, SWT.CHECK);
        fItalicCheckBox.setText(AntPreferencesMessages.AntEditorPreferencePage_8);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalAlignment = GridData.BEGINNING;
        gd.horizontalSpan = 2;
        fItalicCheckBox.setLayoutData(gd);

        label = new Label(colorComposite, SWT.LEFT);
        label.setText(AntPreferencesMessages.AntEditorPreferencePage_9);
        label.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        final Control previewer = createPreviewer(colorComposite);
        gd = new GridData(GridData.FILL_BOTH);
        gd.widthHint = convertWidthInCharsToPixels(20);
        gd.heightHint = convertHeightInCharsToPixels(5);
        previewer.setLayoutData(gd);

        fHighlightingColorListViewer.addSelectionChangedListener(new ISelectionChangedListener() {
            public void selectionChanged(final SelectionChangedEvent event) {
                handleSyntaxColorListSelection();
            }
        });

        foregroundColorButton.addSelectionListener(new SelectionListener() {
            public void widgetDefaultSelected(final SelectionEvent e) {
                // do nothing
            }

            public void widgetSelected(final SelectionEvent e) {
                final HighlightingColorListItem item = getHighlightingColorListItem();
                PreferenceConverter.setValue(getOverlayStore(), item.getColorKey(), fSyntaxForegroundColorEditor.getColorValue());
            }
        });

        fBoldCheckBox.addSelectionListener(new SelectionListener() {
            public void widgetDefaultSelected(final SelectionEvent e) {
                // do nothing
            }

            public void widgetSelected(final SelectionEvent e) {
                final HighlightingColorListItem item = getHighlightingColorListItem();
                getOverlayStore().setValue(item.getBoldKey(), fBoldCheckBox.getSelection());
            }
        });

        fItalicCheckBox.addSelectionListener(new SelectionListener() {
            public void widgetDefaultSelected(final SelectionEvent e) {
                // do nothing
            }

            public void widgetSelected(final SelectionEvent e) {
                final HighlightingColorListItem item = getHighlightingColorListItem();
                getOverlayStore().setValue(item.getItalicKey(), fItalicCheckBox.getSelection());
            }
        });

        return colorComposite;
    }

    private HighlightingColorListItem getHighlightingColorListItem() {
        final IStructuredSelection selection = (IStructuredSelection) fHighlightingColorListViewer.getSelection();
        return (HighlightingColorListItem) selection.getFirstElement();
    }
}