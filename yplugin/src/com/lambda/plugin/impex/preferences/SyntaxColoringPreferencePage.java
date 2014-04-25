package com.lambda.plugin.impex.preferences;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.SourceViewer;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.RGB;
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
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.model.WorkbenchViewerComparator;
import org.eclipse.ui.texteditor.ChainedPreferenceStore;

import com.lambda.plugin.YMessages;
import com.lambda.plugin.YPlugin;
import com.lambda.plugin.impex.antlr.TokenSourceProvider;
import com.lambda.plugin.impex.editor.ImpexColorConstants;
import com.lambda.plugin.impex.editor.ImpexDocument;
import com.lambda.plugin.impex.editor.ImpexDocumentParticipant;
import com.lambda.plugin.impex.editor.ImpexEditorConfiguration;

public class SyntaxColoringPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {

    private final String[][] syntaxColorListModel = new String[][] {
            { YMessages.ImpexEditorPreferencePage_singleLineComment, PreferenceConstants.COLOR_COMMENT },
            { YMessages.ImpexEditorPreferencePage_macros, PreferenceConstants.COLOR_MACRO },
            { YMessages.ImpexEditorPreferencePage_types, PreferenceConstants.COLOR_TYPE },
            { YMessages.ImpexEditorPreferencePage_attributes, PreferenceConstants.COLOR_TYPE },
            { YMessages.ImpexEditorPreferencePage_typeModifiers, PreferenceConstants.COLOR_KEYWORD },
            { YMessages.ImpexEditorPreferencePage_attributeModifiers, PreferenceConstants.COLOR_KEYWORD },
            { YMessages.ImpexEditorPreferencePage_strings, PreferenceConstants.COLOR_STRING },
            { YMessages.ImpexEditorPreferencePage_brackets, ImpexColorConstants.BRACKETS_COLOR },
            { YMessages.ImpexEditorPreferencePage_others, ImpexColorConstants.OTHERS_COLOR }, };

    private ColorFieldEditor syntaxForegroundColorEditor;
    private TableViewer colorListViewer;
    private final List<ColorListItem> highlightingColorList = new ArrayList<ColorListItem>(5);

    private SourceViewer previewViewer;

    public SyntaxColoringPreferencePage() {
        setPreferenceStore(YPlugin.getDefault().getPreferenceStore());
    }

    @Override
    protected Control createContents(final Composite parent) {
        createComponents(parent);
        initialize();
        applyDialogFont(parent);
        return parent;
    }

    private void createComponents(final Composite parent) {
        final Composite colorComposite = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.grabExcessHorizontalSpace = true;
        gd.grabExcessVerticalSpace = true;
        colorComposite.setLayout(layout);
        colorComposite.setLayoutData(gd);

        Link link = new Link(colorComposite, SWT.NONE);
        link.setText(YMessages.ImpexEditorPreferencePage_0);
        link.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                if ("org.eclipse.ui.preferencePages.GeneralTextEditor".equals(e.text)) //$NON-NLS-1$
                    PreferencesUtil.createPreferenceDialogOn(parent.getShell(), e.text, null, null);
                else if ("org.eclipse.ui.preferencePages.ColorsAndFonts".equals(e.text)) //$NON-NLS-1$
                    PreferencesUtil.createPreferenceDialogOn(parent.getShell(), e.text, null,
                            "selectFont:org.eclipse.jdt.ui.editors.textfont"); //$NON-NLS-1$
            }
        });

        GridData gridData = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
        gridData.widthHint = 150; // only expand further if anyone else requires it
        gridData.horizontalSpan = 2;
        link.setLayoutData(gridData);

        final Composite editorComposite = new Composite(colorComposite, SWT.NONE);
        layout = new GridLayout(2, false);
        layout.marginHeight = 0;
        layout.marginWidth = 0;
        layout.marginHeight = 10;
        editorComposite.setLayout(layout);
        gd = new GridData(GridData.FILL_BOTH);
        gd.grabExcessVerticalSpace = false;
        editorComposite.setLayoutData(gd);

        Label label = new Label(editorComposite, SWT.LEFT);
        label.setText(YMessages.ImpexEditorPreferencePage_foreground);
        gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalSpan = 2;
        label.setLayoutData(gd);

        colorListViewer = new TableViewer(editorComposite, SWT.SINGLE | SWT.V_SCROLL | SWT.BORDER | SWT.FULL_SELECTION);
        colorListViewer.setLabelProvider(new ColorListLabelProvider());
        colorListViewer.setContentProvider(new ColorListContentProvider());
        colorListViewer.setComparator(new WorkbenchViewerComparator());
        gd = new GridData(GridData.FILL_BOTH);
        gd.heightHint = convertHeightInCharsToPixels(5);
        gd.minimumWidth = 200;

        colorListViewer.getControl().setLayoutData(gd);
        colorListViewer.addSelectionChangedListener(new ISelectionChangedListener() {
            @Override
            public void selectionChanged(final SelectionChangedEvent event) {
                ColorListItem item = getSelectedColorListItem(colorListViewer);
                RGB rgb = PreferenceConverter.getColor(getPreferenceStore(), item.colorKey);
                syntaxForegroundColorEditor.getColorSelector().setColorValue(rgb);
            }
        });

        final Composite stylesComposite = new Composite(editorComposite, SWT.NONE);
        layout = new GridLayout(2, false);
        layout.marginHeight = 0;
        layout.marginWidth = 0;

        stylesComposite.setLayout(layout);
        stylesComposite.setLayoutData(new GridData(GridData.FILL_BOTH));

        syntaxForegroundColorEditor = new ColorFieldEditor("Color", YMessages.ImpexEditorPreferencePage_color,
                stylesComposite);

        createCheck(stylesComposite, colorListViewer, YMessages.ImpexEditorPreferencePage_bold,
                PreferenceConstants.IMPEX_EDITOR_BOLD_SUFFIX);
        createCheck(stylesComposite, colorListViewer, YMessages.ImpexEditorPreferencePage_italic,
                PreferenceConstants.IMPEX_EDITOR_ITALIC_SUFFIX);
        createCheck(stylesComposite, colorListViewer, YMessages.ImpexEditorPreferencePage_underline,
                PreferenceConstants.IMPEX_EDITOR_UNDERLINE_SUFFIX);
        createCheck(stylesComposite, colorListViewer, YMessages.ImpexEditorPreferencePage_strikethrough,
                PreferenceConstants.IMPEX_EDITOR_STRIKETHROUGH_SUFFIX);

        label = new Label(colorComposite, SWT.LEFT);
        label.setText(YMessages.ImpexEditorPreferencePage_preview);
        label.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

        createPreview(colorComposite);
    }

    private Button createCheck(final Composite parent, final ISelectionProvider selectable, final String displayName,
            final String propertySuffix) {
        final Button check = new Button(parent, SWT.CHECK);
        check.setText(displayName);
        check.setEnabled(false);
        GridData gd = new GridData(GridData.FILL_HORIZONTAL);
        gd.horizontalAlignment = GridData.BEGINNING;
        gd.horizontalIndent = 15;
        gd.horizontalSpan = 2;
        check.setLayoutData(gd);
        // update check state based on newly selected row in item table
        selectable.addSelectionChangedListener(new ISelectionChangedListener() {
            @Override
            public void selectionChanged(final SelectionChangedEvent event) {
                ColorListItem item = getSelectedColorListItem(selectable);
                check.setSelection(getPreferenceStore().getBoolean(item.colorKey + propertySuffix));
                check.setEnabled(true);
            }
        });
        // store new value of the check into preference store
        check.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(final SelectionEvent e) {
                final ColorListItem item = getSelectedColorListItem(selectable);
                getPreferenceStore().setValue(item.colorKey + propertySuffix, check.getSelection());
            }
        });
        return check;
    }

    private Control createPreview(Composite parent) {
        final IPreferenceStore store = new ChainedPreferenceStore(new IPreferenceStore[] { getPreferenceStore(),
                EditorsUI.getPreferenceStore() });
        previewViewer = new SourceViewer(parent, null, null, false, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
        final ImpexEditorConfiguration configuration = new ImpexEditorConfiguration(store);
        previewViewer.configure(configuration);
        previewViewer.setEditable(false);
        previewViewer.getTextWidget().setFont(JFaceResources.getFont(JFaceResources.TEXT_FONT));
        final IPropertyChangeListener fontChangeListener = new IPropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent event) {
                if (org.eclipse.jdt.ui.PreferenceConstants.EDITOR_TEXT_FONT.equals(event.getProperty())) {
                    Font font = JFaceResources.getFont(org.eclipse.jdt.ui.PreferenceConstants.EDITOR_TEXT_FONT);
                    previewViewer.getTextWidget().setFont(font);
                }
            }
        };
        final IPropertyChangeListener propertyChangeListener = new IPropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent event) {
                if (event.getProperty().startsWith("impex_")) {
                    // configuration.handlePropertyChangeEvent(event);
                    previewViewer.invalidateTextPresentation();
                }
            }
        };

        previewViewer.getTextWidget().addDisposeListener(new DisposeListener() {
            @Override
            public void widgetDisposed(DisposeEvent e) {
                store.removePropertyChangeListener(propertyChangeListener);
                JFaceResources.getFontRegistry().removeListener(fontChangeListener);
            }
        });
        JFaceResources.getFontRegistry().addListener(fontChangeListener);
        store.addPropertyChangeListener(propertyChangeListener);
        // fPreviewerUpdater = new AntPreviewerUpdater(fPreviewViewer, configuration, store);

        String content = readExampleFile();

        IDocument document = new ImpexDocument(new Document(content), new TokenSourceProvider());
        new ImpexDocumentParticipant().setup(document);
        previewViewer.setDocument(document);
        GridData gd = new GridData(GridData.FILL_BOTH);
        gd.widthHint = convertWidthInCharsToPixels(20);
        gd.heightHint = convertHeightInCharsToPixels(5);
        Control control = previewViewer.getControl();
        control.setLayoutData(gd);
        return control;
    }

    private String readExampleFile() {
        String content = "";
        try {
            // FIXME change to real file from bundle
            content = FileUtils.readFileToString(new File(
                    "/work/projects/yeclipse/ImpexAST/src/test/resources/btg.impex"));//$NON-NLS-1$
        } catch (IOException e) {
            YPlugin.logError(e);
        }
        return content;
    }

    private void initialize() {
        for (int i = 0, n = syntaxColorListModel.length; i < n; i++) {
            String displayName = syntaxColorListModel[i][0];
            String colorKey = syntaxColorListModel[i][1];
            Color itemColor = null;// IPreferenceStore.STRING_DEFAULT_DEFAULT;
            highlightingColorList.add(new ColorListItem(displayName, colorKey, itemColor));
        }
        colorListViewer.setInput(highlightingColorList);
        colorListViewer.setSelection(new StructuredSelection(colorListViewer.getElementAt(0)));
    }

    @Override
    public void init(final IWorkbench workbench) {
    }

    protected String loadPreviewContentFromFile(String filename) {
        String line;
        String separator = System.getProperty("line.separator"); //$NON-NLS-1$
        StringBuffer buffer = new StringBuffer(512);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(filename)));
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
                buffer.append(separator);
            }
        } catch (IOException io) {
            YPlugin.logError(io);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
        }
        return buffer.toString();
    }

    /**
     * Item in the color list.
     */
    private class ColorListItem {
        private final String displayName;
        private final String colorKey;
        private final Color itemColor;

        private ColorListItem(final String displayName, final String colorKey, final Color itemColor) {
            this.displayName = displayName;
            this.colorKey = colorKey;
            this.itemColor = itemColor;
        }
    }

    /**
     * Color list label provider.
     */
    private class ColorListLabelProvider extends LabelProvider implements IColorProvider {

        /*
         * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
         */
        @Override
        public String getText(final Object element) {
            return ((ColorListItem) element).displayName;
        }

        /*
         * @see org.eclipse.jface.viewers.IColorProvider#getForeground(java.lang. Object)
         */
        @Override
        public Color getForeground(final Object element) {
            return ((ColorListItem) element).itemColor;
        }

        /*
         * @see org.eclipse.jface.viewers.IColorProvider#getBackground(java.lang. Object)
         */
        @Override
        public Color getBackground(final Object element) {
            return null;
        }
    }

    /**
     * Color list content provider.
     */
    private class ColorListContentProvider implements IStructuredContentProvider {

        /*
         * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements( java.lang.Object)
         */
        @Override
        @SuppressWarnings("rawtypes")
        public Object[] getElements(final Object inputElement) {
            return ((List) inputElement).toArray();
        }

        /*
         * @see org.eclipse.jface.viewers.IContentProvider#dispose()
         */
        @Override
        public void dispose() {
        }

        /*
         * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse .jface.viewers.Viewer,
         * java.lang.Object, java.lang.Object)
         */
        @Override
        public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
        }
    }

    private static ColorListItem getSelectedColorListItem(ISelectionProvider selectionProvider) {
        final IStructuredSelection selection = (IStructuredSelection) selectionProvider.getSelection();
        return (ColorListItem) selection.getFirstElement();
    }
}