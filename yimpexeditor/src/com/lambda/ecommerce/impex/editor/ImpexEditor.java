package com.lambda.ecommerce.impex.editor;

import java.util.HashMap;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.ISynchronizable;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.ISharedTextColors;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.projection.ProjectionAnnotation;
import org.eclipse.jface.text.source.projection.ProjectionAnnotationModel;
import org.eclipse.jface.text.source.projection.ProjectionSupport;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.editors.text.ForwardingDocumentProvider;
import org.eclipse.ui.editors.text.ITextEditorHelpContextIds;
import org.eclipse.ui.editors.text.TextEditor;

import com.lambda.ecommerce.impex.YImpex;
import com.lambda.ecommerce.impex.editor.ImpexDocumentParticipant.ImpexPartitioner;
import com.lambda.ecommerce.impex.editor.occurrences.OccurrenceFinderSelectionChangedListener;
import com.lambda.ecommerce.impex.editor.syntaxcoloring.SyntaxColoringPropertyChangeListener;
import com.lambda.ecommerce.impex.model.IImpexModel;
import com.lambda.ecommerce.impex.model.ImpexModel;
import com.lambda.ecommerce.impex.preferences.PreferenceConstants;

public class ImpexEditor extends TextEditor {

    public static final String ID = "com.lambda.ecommerce.impex.editor.ImpexEditor";

    private boolean markingOccurrences;
    private boolean stickyOccurrences;
    private ProjectionSupport projectionSupport;
    private ProjectionAnnotationModel annotationModel;
    private Annotation[] oldAnnotations;
    private IImpexModel impexModel;
    private SyntaxColoringPropertyChangeListener syntaxColoringPropertyChangeListener;

    private OccurrenceFinderSelectionChangedListener occurrenceFinderSelectionChangeListener;

    public ImpexEditor() {
    }

    @Override
    protected void initializeEditor() {
        syntaxColoringPropertyChangeListener = new SyntaxColoringPropertyChangeListener();
        setEditorContextMenuId("#TextEditorContext"); //$NON-NLS-1$
        setRulerContextMenuId("#TextRulerContext"); //$NON-NLS-1$
        setHelpContextId(ITextEditorHelpContextIds.TEXT_EDITOR);
        configureInsertMode(SMART_INSERT, false);
        setInsertMode(INSERT);
        setDocumentProvider(new ForwardingDocumentProvider(ImpexPartitioner.IMPEX_PARTITIONING,
                new ImpexDocumentParticipant(), new ImpexDocumentProvider()));
        // getVerticalRuler().getModel().addAnnotation(annotation, position);

        setPreferenceStore(YImpex.getDefault().getCombinedPreferenceStore());
        markingOccurrences = getPreferenceStore().getBoolean(PreferenceConstants.IMPEX_EDITOR_MARK_OCCURRENCES);
        stickyOccurrences = getPreferenceStore().getBoolean(PreferenceConstants.IMPEX_EDITOR_STICKY_OCCURRENCES);
        setSourceViewerConfiguration(new ImpexEditorConfiguration(getPreferenceStore(), this));
    }

    @Override
    protected void setPreferenceStore(IPreferenceStore store) {
        if (getPreferenceStore() != null) {
            getPreferenceStore().removePropertyChangeListener(syntaxColoringPropertyChangeListener);
        }
        super.setPreferenceStore(store);
        getPreferenceStore().addPropertyChangeListener(syntaxColoringPropertyChangeListener);
    }

    @Override
    public void createPartControl(final Composite parent) {
        super.createPartControl(parent);
        syntaxColoringPropertyChangeListener.setSourceViewer(getSourceViewer());

        final ProjectionViewer viewer = (ProjectionViewer) getSourceViewer();
        projectionSupport = new ProjectionSupport(viewer, getAnnotationAccess(), getSharedColors());
        // projectionSupport.setHoverControlCreator(new IInformationControlCreator() {
        // public IInformationControl createInformationControl(Shell shell) {
        // return new CustomSourceInformationControl(shell, IDocument.DEFAULT_CONTENT_TYPE);
        // }
        // });
        projectionSupport.install();

        // turn projection mode on
        viewer.doOperation(ProjectionViewer.TOGGLE);

        annotationModel = viewer.getProjectionAnnotationModel();

        occurrenceFinderSelectionChangeListener = new OccurrenceFinderSelectionChangedListener(this);
        occurrenceFinderSelectionChangeListener.install(getSelectionProvider());

    }

    /**
     * Returns the Impex model for the current editor input of this editor.
     * 
     * @return the Impex model for this editor or <code>null</code>
     */
    public IImpexModel getImpexModel() {
        if (impexModel == null) {
            if (getEditorInput() instanceof IFileEditorInput) {
                impexModel = new ImpexModel((IFileEditorInput) getEditorInput());
            }
        }
        return impexModel;
    }

    public Object getLockObject(ImpexDocument document) {
        if (document.getDelegate() instanceof ISynchronizable) {
            return ((ISynchronizable) document.getDelegate()).getLockObject();
        }
        return null;
    }

    @Override
    public Object getAdapter(Class adapter) {
        if (ISourceViewer.class.equals(adapter)) {
            return getSourceViewer();
        }
        return super.getAdapter(adapter);
    }

    @Override
    protected ISourceViewer createSourceViewer(final Composite parent, final IVerticalRuler ruler, final int styles) {
        final ISourceViewer viewer = new ProjectionViewer(parent, ruler, getOverviewRuler(), isOverviewRulerVisible(),
                styles);
        // ensure decoration support has been created and configured.
        getSourceViewerDecorationSupport(viewer);
        return viewer;
    }

    @Override
    protected CompositeRuler createCompositeRuler() {
        final CompositeRuler ruler = new CompositeRuler();
        // ruler.addDecorator(0, new AnnotationRulerColumn(VERTICAL_RULER_WIDTH));
        // if (isLineNumberRulerVisible()) {
        // ruler.addDecorator(1, createLineNumberRulerColumn());
        // }
        return ruler;
    }

    @Override
    protected IOverviewRuler createOverviewRuler(final ISharedTextColors sharedColors) {
        return super.createOverviewRuler(sharedColors);
    }

    public void updateFoldingStructure(final List<Position> positions) {
        final Annotation[] annotations = new Annotation[positions.size()];
        // this will hold the new annotations along with their corresponding positions
        final HashMap<Annotation, Position> newAnnotations = new HashMap<Annotation, Position>();
        for (int i = 0; i < positions.size(); i++) {
            final ProjectionAnnotation annotation = new ProjectionAnnotation();
            newAnnotations.put(annotation, positions.get(i));
            annotations[i] = annotation;
        }
        annotationModel.modifyAnnotations(oldAnnotations, newAnnotations, null);
        oldAnnotations = annotations;
    }

    @Override
    public void doSave(final IProgressMonitor monitor) {
        super.doSave(monitor);
        // final IImpexModel model = getImpexModel();
        // model.reconcile();
        // TODO need to update editor image
        // updateEditorImage(model);
    }

    @Override
    public void dispose() {
        if (occurrenceFinderSelectionChangeListener != null) {
            occurrenceFinderSelectionChangeListener.uninstall(getSelectionProvider());
            occurrenceFinderSelectionChangeListener = null;
        }
        getPreferenceStore().removePropertyChangeListener(syntaxColoringPropertyChangeListener);
        super.dispose();
    }

    @Override
    protected void handlePreferenceStoreChanged(final PropertyChangeEvent event) {
        switch (event.getProperty()) {
        case PreferenceConstants.IMPEX_EDITOR_MARK_OCCURRENCES:
            markingOccurrences = Boolean.TRUE.equals(event.getNewValue());
            occurrenceFinderSelectionChangeListener.updateOccurrenceAnnotations((ITextSelection) getSelectionProvider()
                    .getSelection(), getImpexModel(), true);
            break;
        case PreferenceConstants.IMPEX_EDITOR_STICKY_OCCURRENCES:
            stickyOccurrences = Boolean.TRUE.equals(event.getNewValue());
            break;
        }
        super.handlePreferenceStoreChanged(event);
    }

    public boolean isMarkingOccurrences() {
        return markingOccurrences;
    }

    public boolean isStickyOccurrences() {
        return stickyOccurrences;
    }

    @Override
    protected void setKeyBindingScopes(String[] scopes) {
        super.setKeyBindingScopes(scopes);
    }
}
