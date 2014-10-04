package com.lambda.plugin.impex.editor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.Token;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ISelectionValidator;
import org.eclipse.jface.text.ISynchronizable;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.link.LinkedModeModel;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.CompositeRuler;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelExtension;
import org.eclipse.jface.text.source.IOverviewRuler;
import org.eclipse.jface.text.source.ISharedTextColors;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.IVerticalRuler;
import org.eclipse.jface.text.source.projection.ProjectionAnnotation;
import org.eclipse.jface.text.source.projection.ProjectionAnnotationModel;
import org.eclipse.jface.text.source.projection.ProjectionSupport;
import org.eclipse.jface.text.source.projection.ProjectionViewer;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.IPostSelectionProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.editors.text.ForwardingDocumentProvider;
import org.eclipse.ui.editors.text.ITextEditorHelpContextIds;
import org.eclipse.ui.editors.text.TextEditor;
import org.eclipse.ui.texteditor.IDocumentProvider;

import com.lambda.plugin.YPlugin;
import com.lambda.plugin.impex.editor.ImpexDocumentParticipant.ImpexPartitioner;
import com.lambda.plugin.impex.editor.syntaxcoloring.SyntaxColoringPropertyChangeListener;
import com.lambda.plugin.impex.model.IImpexModel;
import com.lambda.plugin.impex.model.ILexerTokenRegion;
import com.lambda.plugin.impex.model.ImpexModel;
import com.lambda.plugin.impex.preferences.PreferenceConstants;

public class ImpexEditor extends TextEditor {

    public static final String ID = "com.lambda.plugin.impex.editor.ImpexEditor";

    private boolean markingOccurrences;
    private ProjectionSupport projectionSupport;
    private ProjectionAnnotationModel annotationModel;
    private Annotation[] oldAnnotations;
    /**
     * Holds the current occurrence annotations.
     * 
     * @since 3.1
     */
    private Annotation[] fOccurrenceAnnotations = null;

    private IImpexModel impexModel;
    private SyntaxColoringPropertyChangeListener syntaxColoringPropertyChangeListener;

    private OccurenceFinderSelectionChangeListener occurrenceFinderSelectionChangeListener;

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

        setPreferenceStore(YPlugin.getDefault().getCombinedPreferenceStore());
        markingOccurrences = getPreferenceStore().getBoolean(PreferenceConstants.IMPEX_EDITOR_MARK_OCCURRENCES);
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

        occurrenceFinderSelectionChangeListener = new OccurenceFinderSelectionChangeListener();
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

    private Object getLockObject(ImpexDocument document) {
        if (document.getDelegate() instanceof ISynchronizable) {
            return ((ISynchronizable) document.getDelegate()).getLockObject();
        }
        return null;
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
        if (event.getProperty().equals(PreferenceConstants.IMPEX_EDITOR_MARK_OCCURRENCES)) {
            markingOccurrences = Boolean.TRUE.equals(event.getNewValue());
            updateOccurenceAnnotations(markingOccurrences);
        }
        super.handlePreferenceStoreChanged(event);
    }

    private void updateOccurenceAnnotations(boolean markingOccurrences) {
        occurrenceFinderSelectionChangeListener.updateOccurrenceAnnotations((ITextSelection) getSelectionProvider()
                .getSelection(), getImpexModel(), true);
    }

    public boolean isMarkingOccurrences() {
        return markingOccurrences;
    }

    @Override
    protected void setKeyBindingScopes(String[] scopes) {
        super.setKeyBindingScopes(scopes);
    }

    /**
     * Finds occurrences
     */
    class OccurrencesFinder {
        private final ImpexDocument document;
        private final int offset;

        public OccurrencesFinder(ISelectionChangedListener iSelectionChangedListener, IImpexModel model,
                ImpexDocument document, int offset) {
            this.document = document;
            this.offset = offset;
        }

        public List<Position> perform() {
            try {
                ILexerTokenRegion token = document.getToken(offset);
                List<Token> tokens = document.getModel().getOccurrenceTokens(token.getTokenType(), token.getOffset());
                List<Position> positions = new ArrayList<>(tokens.size());
                for (Token occurrence : tokens) {
                    positions.add(new Position(occurrence.getStartIndex(), occurrence.getStopIndex()
                            - occurrence.getStartIndex() + 1));
                }
                return positions;
            } catch (BadLocationException e) {
                YPlugin.logError(e);
            }
            return Collections.emptyList();
        }
    }

    class OccurenceFinderSelectionChangeListener implements ISelectionChangedListener {

        private OccurrencesFinderJob fOccurrencesFinderJob;

        /**
         * Installs this selection changed listener with the given selection provider. If the selection provider is a
         * post selection provider, post selection changed events are the preferred choice, otherwise normal selection
         * changed events are requested.
         * 
         * @param selectionProvider
         */
        public void install(ISelectionProvider selectionProvider) {
            if (selectionProvider == null || getImpexModel() == null) {
                return;
            }
            if (selectionProvider instanceof IPostSelectionProvider) {
                IPostSelectionProvider provider = (IPostSelectionProvider) selectionProvider;
                provider.addPostSelectionChangedListener(this);
            } else {
                selectionProvider.addSelectionChangedListener(this);
            }
        }

        /**
         * Removes this selection changed listener from the given selection provider.
         * 
         * @param selectionProvider
         */
        public void uninstall(ISelectionProvider selectionProvider) {
            if (selectionProvider == null || getImpexModel() == null) {
                return;
            }

            if (selectionProvider instanceof IPostSelectionProvider) {
                IPostSelectionProvider provider = (IPostSelectionProvider) selectionProvider;
                provider.removePostSelectionChangedListener(this);
            } else {
                selectionProvider.removeSelectionChangedListener(this);
            }
        }

        @Override
        public void selectionChanged(SelectionChangedEvent event) {
            ISelection selection = event.getSelection();
            if (selection instanceof ITextSelection) {
                ITextSelection textSelection = (ITextSelection) selection;
                updateOccurrenceAnnotations(textSelection, impexModel);
            }
        }

        protected void updateOccurrenceAnnotations(ITextSelection selection, IImpexModel model) {
            updateOccurrenceAnnotations(selection, model, false);
        }

        /**
         * Updates the occurrences annotations based on the current selection.
         * 
         * @param selection the text selection
         * @param model the model for the impex file
         * @param force flag to indicate force mode, e.g. when turning on <i>Mark Occurrences</i> button
         * @since 3.1
         */
        protected void updateOccurrenceAnnotations(ITextSelection selection, IImpexModel model, boolean force) {

            if (fOccurrencesFinderJob != null) {
                fOccurrencesFinderJob.cancel();
            }

            if (!markingOccurrences) {
                removeOccurrenceAnnotations();
                return;
            }

            if (selection == null || model == null) {
                return;
            }

            IDocument document = getSourceViewer().getDocument();
            if (!(document instanceof ImpexDocument)) {
                return;
            }

            List<Position> positions = null;

            OccurrencesFinder finder = new OccurrencesFinder(this, model, (ImpexDocument) document,
                    selection.getOffset());
            positions = finder.perform();

            if (positions.isEmpty()) {
                removeOccurrenceAnnotations();
                return;
            }

            fOccurrencesFinderJob = new OccurrencesFinderJob(document, positions, selection, force);
            fOccurrencesFinderJob.run(new NullProgressMonitor());
        }

        private void removeOccurrenceAnnotations() {
            IDocumentProvider documentProvider = getDocumentProvider();
            if (documentProvider == null) {
                return;
            }

            IAnnotationModel annotationModel = documentProvider.getAnnotationModel(getEditorInput());
            if (annotationModel == null || fOccurrenceAnnotations == null) {
                return;
            }

            IDocument document = documentProvider.getDocument(getEditorInput());
            Object lock = getLockObject((ImpexDocument) document);
            if (lock == null) {
                updateAnnotationModelForRemoves(annotationModel);
            } else {
                synchronized (lock) {
                    updateAnnotationModelForRemoves(annotationModel);
                }
            }
        }

        private void updateAnnotationModelForRemoves(IAnnotationModel annotationModel) {
            if (annotationModel instanceof IAnnotationModelExtension) {
                ((IAnnotationModelExtension) annotationModel).replaceAnnotations(fOccurrenceAnnotations, null);
            } else {
                for (int i = 0, length = fOccurrenceAnnotations.length; i < length; i++) {
                    annotationModel.removeAnnotation(fOccurrenceAnnotations[i]);
                }
            }
            fOccurrenceAnnotations = null;
        }

    }

    /**
     * Finds and marks occurrence annotations.
     */
    class OccurrencesFinderJob extends Job {

        private ISelection fForcedMarkOccurrencesSelection = null;
        private final IDocument fDocument;
        private final ISelection fSelection;
        private ISelectionValidator fPostSelectionValidator;
        private boolean fCanceled = false;
        private IProgressMonitor fProgressMonitor;
        private final List<Position> fPositions;

        public OccurrencesFinderJob(IDocument document, List<Position> positions, ISelection selection, boolean forced) {
            super("Occurrences Marker"); //$NON-NLS-1$
            fDocument = document;
            fSelection = selection;
            fPositions = positions;

            if (getSelectionProvider() instanceof ISelectionValidator) {
                fPostSelectionValidator = (ISelectionValidator) getSelectionProvider();
            }

            if (forced) {
                fForcedMarkOccurrencesSelection = selection;
            }
        }

        // cannot use cancel() because it is declared final
        void doCancel() {
            fCanceled = true;
            cancel();
        }

        private boolean isCanceled() {
            return fCanceled || fProgressMonitor.isCanceled() || fPostSelectionValidator != null
                    && !(fPostSelectionValidator.isValid(fSelection) || fForcedMarkOccurrencesSelection == fSelection)
                    || LinkedModeModel.hasInstalledModel(fDocument);
        }

        /*
         * @see Job#run(org.eclipse.core.runtime.IProgressMonitor)
         */
        @Override
        public IStatus run(IProgressMonitor progressMonitor) {

            fProgressMonitor = progressMonitor;

            if (isCanceled()) {
                return Status.CANCEL_STATUS;
            }

            ITextViewer textViewer = getSourceViewer();
            if (textViewer == null) {
                return Status.CANCEL_STATUS;
            }

            IDocument document = textViewer.getDocument();
            if (!(document instanceof ImpexDocument)) {
                return Status.CANCEL_STATUS;
            }

            IDocumentProvider documentProvider = getDocumentProvider();
            if (documentProvider == null) {
                return Status.CANCEL_STATUS;
            }

            IAnnotationModel annotationModel = documentProvider.getAnnotationModel(getEditorInput());
            if (annotationModel == null) {
                return Status.CANCEL_STATUS;
            }

            // Add occurrence annotations
            int length = fPositions.size();
            Map<Annotation, Position> annotationMap = new HashMap<Annotation, Position>(length);
            for (int i = 0; i < length; i++) {

                if (isCanceled()) {
                    return Status.CANCEL_STATUS;
                }

                String message;
                Position position = fPositions.get(i);

                // Create & add annotation
                try {
                    message = document.get(position.offset, position.length);
                } catch (BadLocationException ex) {
                    // Skip this match
                    continue;
                }
                String annotationType = i == 0 ? "org.eclipse.jdt.ui.occurrences.write"
                        : "org.eclipse.jdt.ui.occurrences";
                annotationMap.put(new Annotation(annotationType, false, message), //$NON-NLS-1$
                        position);
            }

            if (isCanceled()) {
                return Status.CANCEL_STATUS;
            }

            Object lock = getLockObject((ImpexDocument) document);
            if (lock == null) {
                updateAnnotations(annotationModel, annotationMap);
            } else {
                synchronized (lock) {
                    updateAnnotations(annotationModel, annotationMap);
                }
            }

            return Status.OK_STATUS;
        }

        private void updateAnnotations(IAnnotationModel annotationModel, Map<Annotation, Position> annotationMap) {
            if (annotationModel instanceof IAnnotationModelExtension) {
                ((IAnnotationModelExtension) annotationModel).replaceAnnotations(fOccurrenceAnnotations, annotationMap);
            } else {
                replaceOccurrenceAnnotations(annotationModel, annotationMap, fOccurrenceAnnotations);
            }
            fOccurrenceAnnotations = annotationMap.keySet().toArray(new Annotation[annotationMap.keySet().size()]);
        }

        private void replaceOccurrenceAnnotations(IAnnotationModel annotationModel,
                Map<Annotation, Position> annotationMap, Annotation[] currentAnnotations) {
            for (Annotation annotation : currentAnnotations) {
                annotationModel.removeAnnotation(annotation);
            }

            Iterator<Map.Entry<Annotation, Position>> iter = annotationMap.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry<Annotation, Position> mapEntry = iter.next();
                annotationModel.addAnnotation(mapEntry.getKey(), mapEntry.getValue());
            }
        }
    }
}
