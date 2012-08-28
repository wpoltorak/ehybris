package com.lambda.plugin.impex.preferences;

import java.util.ArrayList;
import java.util.List;


import org.eclipse.ant.internal.ui.preferences.AntEditorPreferenceConstants;
import org.eclipse.ant.internal.ui.preferences.AntPreferencesMessages;
import org.eclipse.ant.internal.ui.preferences.ColorEditor;
import org.eclipse.ant.internal.ui.preferences.TabFolderLayout;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
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
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.dialogs.PreferencesUtil;
import org.eclipse.ui.model.WorkbenchViewerComparator;

import com.lambda.plugin.YMessages;
import com.lambda.plugin.YPlugin;

public class ImpexPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

    private Button fBoldCheck;
    private Button fItalicCheck;

    private TableViewer fHighlightingColorListViewer;
    private final List<HighlightingColorListItem> fHighlightingColorList = new ArrayList<HighlightingColorListItem>(5);

    @Override
    protected Control createContents(final Composite parent) {
        createComponents(parent);
        initialize();
        applyDialogFont(parent);
        return parent;
    }

    private void createComponents(Composite parent) {
        createHeader(parent);
        createSyntaxPage(parent);
    }

    private void initialize() {

        // initializeFields();

        // for (int i = 0, n = fSyntaxColorListModel.length; i < n; i++) {
        // fHighlightingColorList.add(new HighlightingColorListItem(fSyntaxColorListModel[i][0],
        // fSyntaxColorListModel[i][1], fSyntaxColorListModel[i][1]
        // + PreferenceConstants.IMPEX_EDITOR_BOLD_SUFFIX, fSyntaxColorListModel[i][1]
        // + PreferenceConstants.IMPEX_EDITOR_ITALIC_SUFFIX, null));
        // }
        // fHighlightingColorListViewer.setInput(fHighlightingColorList);
        // fHighlightingColorListViewer
        // .setSelection(new StructuredSelection(fHighlightingColorListViewer.getElementAt(0)));
    }

    private void createHeader(final Composite contents) {
        final Link link = new Link(contents, SWT.NONE);
        link.setText(YMessages.ImpexEditorPreferencePage_0);
        link.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(final SelectionEvent e) {
                if ("org.eclipse.ui.preferencePages.GeneralTextEditor".equals(e.text)) {
                    PreferencesUtil.createPreferenceDialogOn(link.getShell(), e.text, null, null);
                } else if ("org.eclipse.ui.preferencePages.ColorsAndFonts".equals(e.text)) {
                    PreferencesUtil.createPreferenceDialogOn(link.getShell(), e.text, null,
                            "selectFont:org.eclipse.jface.textfont"); //$NON-NLS-1$
                }
            }
        });
        final String linktooltip = YMessages.ImpexEditorPreferencePage_3;
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

        private HighlightingColorListItem(final String displayName, final String colorKey, final String boldKey,
                final String italicKey, final Color itemColor) {
            fDisplayName = displayName;
            fColorKey = colorKey;
            fBoldKey = boldKey;
            fItalicKey = italicKey;
            fItemColor = itemColor;
        }

        public String getBoldKey() {
            return fBoldKey;
        }

        public String getItalicKey() {
            return fItalicKey;
        }

        public String getColorKey() {
            return fColorKey;
        }

        public String getDisplayName() {
            return fDisplayName;
        }

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
         * @see org.eclipse.jface.viewers.IColorProvider#getForeground(java.lang. Object)
         */
        public Color getForeground(final Object element) {
            return ((HighlightingColorListItem) element).getItemColor();
        }

        /*
         * @see org.eclipse.jface.viewers.IColorProvider#getBackground(java.lang. Object)
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
         * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements( java.lang.Object)
         */
        @SuppressWarnings("rawtypes")
        public Object[] getElements(final Object inputElement) {
            return ((List) inputElement).toArray();
        }

        /*
         * @see org.eclipse.jface.viewers.IContentProvider#dispose()
         */
        public void dispose() {
        }

        /*
         * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse .jface.viewers.Viewer,
         * java.lang.Object, java.lang.Object)
         */
        public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
        }
    }

    private Control createSyntaxPage(final Composite parent) {

        final Composite colorComposite = new Composite(parent, SWT.NONE);
        colorComposite.setLayout(new GridLayout());

        Label label = new Label(colorComposite, SWT.LEFT);
        label.setText(YMessages.ImpexEditorPreferencePage_5);
        label.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        final Composite editorComposite = new Composite(colorComposite, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        editorComposite.setLayout(layout);
        GridData gd = new GridData(GridData.FILL_BOTH);
        editorComposite.setLayoutData(gd);

        fHighlightingColorListViewer = new TableViewer(editorComposite, SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER
                | SWT.FULL_SELECTION);
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
        label.setText(YMessages.ImpexEditorPreferencePage_6);
        gd = new GridData();
        gd.horizontalAlignment = GridData.BEGINNING;
        label.setLayoutData(gd);

        // fSyntaxForegroundColorEditor = new ColorEditor(stylesComposite);
        // final Button foregroundColorButton = fSyntaxForegroundColorEditor.getButton();
        // gd = new GridData(GridData.FILL_HORIZONTAL);
        // gd.horizontalAlignment = GridData.BEGINNING;
        // foregroundColorButton.setLayoutData(gd);

        fBoldCheck = new Button(stylesComposite, SWT.CHECK);
        fBoldCheck.setText(YMessages.ImpexEditorPreferencePage_7);
        fBoldCheck.setEnabled(false);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalAlignment = GridData.BEGINNING;
        gd.horizontalSpan = 2;
        fBoldCheck.setLayoutData(gd);

        fItalicCheck = new Button(stylesComposite, SWT.CHECK);
        fItalicCheck.setText(YMessages.ImpexEditorPreferencePage_8);
        fItalicCheck.setEnabled(false);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalAlignment = GridData.BEGINNING;
        gd.horizontalSpan = 2;
        fItalicCheck.setLayoutData(gd);

        label = new Label(colorComposite, SWT.LEFT);
        label.setText(YMessages.ImpexEditorPreferencePage_9);
        label.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        // final Control previewer = createPreviewer(colorComposite);
        // gd = new GridData(GridData.FILL_BOTH);
        // gd.widthHint = convertWidthInCharsToPixels(20);
        // gd.heightHint = convertHeightInCharsToPixels(5);
        // previewer.setLayoutData(gd);

        fHighlightingColorListViewer.addSelectionChangedListener(new ISelectionChangedListener() {
            public void selectionChanged(final SelectionChangedEvent event) {
                // handleSyntaxColorListSelection();
            }
        });

        // foregroundColorButton.addSelectionListener(new SelectionListener() {
        // public void widgetDefaultSelected(final SelectionEvent e) {
        // // do nothing
        // }
        //
        // public void widgetSelected(final SelectionEvent e) {
        // final HighlightingColorListItem item = getHighlightingColorListItem();
        // // PreferenceConverter.setValue(getOverlayStore(), item.getColorKey(),
        // // fSyntaxForegroundColorEditor.getColorValue());
        // }
        // });

        fBoldCheck.addSelectionListener(new SelectionListener() {
            public void widgetDefaultSelected(final SelectionEvent e) {
                // do nothing
            }

            public void widgetSelected(final SelectionEvent e) {
                final HighlightingColorListItem item = getHighlightingColorListItem();
                // getOverlayStore().setValue(item.getBoldKey(), fBoldCheckBox.getSelection());
            }
        });

        fItalicCheck.addSelectionListener(new SelectionListener() {
            public void widgetDefaultSelected(final SelectionEvent e) {
                // do nothing
            }

            public void widgetSelected(final SelectionEvent e) {
                final HighlightingColorListItem item = getHighlightingColorListItem();
                // getOverlayStore().setValue(item.getItalicKey(), fItalicCheckBox.getSelection());
            }
        });

        return colorComposite;
    }

    private HighlightingColorListItem getHighlightingColorListItem() {
        final IStructuredSelection selection = (IStructuredSelection) fHighlightingColorListViewer.getSelection();
        return (HighlightingColorListItem) selection.getFirstElement();
    }
}