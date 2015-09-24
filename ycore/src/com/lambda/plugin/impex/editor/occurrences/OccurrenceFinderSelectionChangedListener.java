package com.lambda.plugin.impex.editor.occurrences;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ISelectionValidator;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.link.LinkedModeModel;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelExtension;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.viewers.IPostSelectionProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.ui.texteditor.IDocumentProvider;

import com.lambda.plugin.impex.editor.ImpexDocument;
import com.lambda.plugin.impex.editor.ImpexEditor;
import com.lambda.plugin.impex.model.IImpexModel;

public class OccurrenceFinderSelectionChangedListener implements ISelectionChangedListener {
    private enum OccType {
        Occurrence, Highlight
    }

    private OccurrencesFinderJob fOccurrencesFinderJob;
    private OccurrencesFinderJob fHighlightingJob;
    private final ImpexEditor editor;

    private final Map<OccType, Annotation[]> fOccurrenceAnnotations = new HashMap<>();

    public OccurrenceFinderSelectionChangedListener(ImpexEditor editor) {
        this.editor = editor;
    }

    /**
     * Installs this selection changed listener with the given selection provider. If the selection provider is a post
     * selection provider, post selection changed events are the preferred choice, otherwise normal selection changed
     * events are requested.
     * 
     * @param selectionProvider
     */
    public void install(ISelectionProvider selectionProvider) {
        if (selectionProvider == null || editor.getImpexModel() == null) {
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
        if (selectionProvider == null || editor.getImpexModel() == null) {
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
            IImpexModel model = editor.getImpexModel();
            updateOccurrenceAnnotations(textSelection, model);
            updateHighlighting(textSelection, model);
        }
    }

    protected void updateOccurrenceAnnotations(ITextSelection selection, IImpexModel model) {
        updateOccurrenceAnnotations(selection, model, false);
    }

    protected void updateHighlighting(ITextSelection selection, IImpexModel model) {
        updateHighlighting(selection, model, false);
    }

    /**
     * Updates the occurrences annotations based on the current selection.
     * 
     * @param selection the text selection
     * @param model the model for the impex file
     * @param force flag to indicate force mode, e.g. when turning on <i>Mark Occurrences</i> button
     * @since 3.1
     */
    public void updateOccurrenceAnnotations(ITextSelection selection, IImpexModel model, boolean force) {

        if (fOccurrencesFinderJob != null) {
            fOccurrencesFinderJob.cancel();
        }

        if (!editor.isMarkingOccurrences()) {
            removeOccurrenceAnnotations(OccType.Occurrence);
            return;
        }

        ISourceViewer sourceViewer = (ISourceViewer) editor.getAdapter(ISourceViewer.class);
        if (selection == null || model == null || sourceViewer == null) {
            return;
        }

        ImpexDocument document = (ImpexDocument) sourceViewer.getDocument();
        OccurrencesFinder finder = new OccurrencesFinderFactory(document, selection.getOffset())
                .createOccurrencesFinder();

        if (finder == null) {
            return;
        }

        fOccurrencesFinderJob = new OccurrencesFinderJob(OccType.Occurrence, document, selection, finder, force);
        fOccurrencesFinderJob.run(new NullProgressMonitor());
    }

    public void updateHighlighting(ITextSelection selection, IImpexModel model, boolean force) {

        if (fHighlightingJob != null) {
            fHighlightingJob.cancel();
        }

        // if (!editor.isMarkingOccurrences()) {
        // removeOccurrenceAnnotations();
        // return;
        // }

        ISourceViewer sourceViewer = (ISourceViewer) editor.getAdapter(ISourceViewer.class);
        if (selection == null || model == null || sourceViewer == null) {
            return;
        }

        ImpexDocument document = (ImpexDocument) sourceViewer.getDocument();

        FieldOccurrencesFinder finder = new FieldOccurrencesFinder(selection.getOffset());
        fHighlightingJob = new OccurrencesFinderJob(OccType.Highlight, document, selection, finder, force);
        fHighlightingJob.run(new NullProgressMonitor());
    }

    private void removeOccurrenceAnnotations(OccType type) {
        IDocumentProvider documentProvider = editor.getDocumentProvider();
        if (documentProvider == null) {
            return;
        }

        IAnnotationModel annotationModel = documentProvider.getAnnotationModel(editor.getEditorInput());
        if (annotationModel == null || fOccurrenceAnnotations.get(type) == null) {
            return;
        }

        IDocument document = documentProvider.getDocument(editor.getEditorInput());
        Object lock = editor.getLockObject((ImpexDocument) document);
        if (lock == null) {
            updateAnnotationModelForRemoves(annotationModel, type);
        } else {
            synchronized (lock) {
                updateAnnotationModelForRemoves(annotationModel, type);
            }
        }
    }

    private void updateAnnotationModelForRemoves(IAnnotationModel annotationModel, OccType type) {
        Annotation[] annotations = fOccurrenceAnnotations.remove(type);
        if (annotationModel instanceof IAnnotationModelExtension) {
            ((IAnnotationModelExtension) annotationModel).replaceAnnotations(annotations, null);
        } else {
            for (int i = 0, length = annotations.length; i < length; i++) {
                annotationModel.removeAnnotation(annotations[i]);
            }
        }
    }

    private void updateAnnotations(IAnnotationModel annotationModel, Map<Annotation, Position> annotationMap,
            OccType type) {
        Annotation[] annotations = fOccurrenceAnnotations.remove(type);
        if (annotationModel instanceof IAnnotationModelExtension) {
            ((IAnnotationModelExtension) annotationModel).replaceAnnotations(annotations, annotationMap);
        } else {
            replaceOccurrenceAnnotations(annotationModel, annotationMap, annotations);
        }
        fOccurrenceAnnotations.put(type, annotationMap.keySet().toArray(new Annotation[annotationMap.keySet().size()]));
    }

    private void replaceOccurrenceAnnotations(IAnnotationModel annotationModel, Map<Annotation, Position> annotationMap,
            Annotation[] currentAnnotations) {
        for (Annotation annotation : currentAnnotations) {
            annotationModel.removeAnnotation(annotation);
        }

        Iterator<Map.Entry<Annotation, Position>> iter = annotationMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Annotation, Position> mapEntry = iter.next();
            annotationModel.addAnnotation(mapEntry.getKey(), mapEntry.getValue());
        }
    }

    /**
     * Finds and marks occurrence annotations.
     */
    class OccurrencesFinderJob extends Job {

        private ITextSelection fForcedMarkOccurrencesSelection = null;
        private final ImpexDocument fDocument;
        private final ITextSelection fSelection;
        private ISelectionValidator fPostSelectionValidator;
        private boolean fCanceled = false;
        private IProgressMonitor fProgressMonitor;
        private final OccurrencesFinder finder;
        private final OccType type;

        public OccurrencesFinderJob(OccType type, ImpexDocument document, ITextSelection selection,
                OccurrencesFinder finder, boolean forced) {
            super("Occurrences Marker"); //$NON-NLS-1$
            this.type = type;
            Assert.isNotNull(document);
            Assert.isNotNull(selection);
            Assert.isNotNull(finder);
            fDocument = document;
            fSelection = selection;
            this.finder = finder;

            if (editor.getSelectionProvider() instanceof ISelectionValidator) {
                fPostSelectionValidator = (ISelectionValidator) editor.getSelectionProvider();
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
            return fCanceled || fProgressMonitor.isCanceled()
                    || fPostSelectionValidator != null && !(fPostSelectionValidator.isValid(fSelection)
                            || fForcedMarkOccurrencesSelection == fSelection)
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

            IDocumentProvider documentProvider = editor.getDocumentProvider();
            if (documentProvider == null) {
                return Status.CANCEL_STATUS;
            }

            IAnnotationModel annotationModel = documentProvider.getAnnotationModel(editor.getEditorInput());
            if (annotationModel == null) {
                return Status.CANCEL_STATUS;
            }

            ParseTree parseTree = fDocument.getParseTree();
            if (parseTree == null) {
                return Status.CANCEL_STATUS;
            }

            List<Position> positions = finder.findOccurrences(parseTree);
            if (positions.isEmpty()) {
                if (!editor.isStickyOccurrences()) {
                    removeOccurrenceAnnotations(type);
                }
                return Status.CANCEL_STATUS;
            }

            // Add occurrence annotations
            int length = positions.size();
            Map<Annotation, Position> annotationMap = new HashMap<Annotation, Position>(length);
            for (int i = 0; i < length; i++) {

                if (isCanceled()) {
                    return Status.CANCEL_STATUS;
                }

                String message;
                Position position = positions.get(i);

                // Create & add annotation
                try {
                    message = fDocument.get(position.offset, position.length);
                } catch (BadLocationException ex) {
                    // Skip this match
                    continue;
                }
                String annotationType = i == 0 ? finder.getWriteAnnotationId() : finder.getAnnotationId();
                annotationMap.put(new Annotation(annotationType, false, message), // $NON-NLS-1$
                        position);
            }

            if (isCanceled()) {
                return Status.CANCEL_STATUS;
            }

            Object lock = editor.getLockObject(fDocument);
            if (lock == null) {
                updateAnnotations(annotationModel, annotationMap, type);
            } else {
                synchronized (lock) {
                    updateAnnotations(annotationModel, annotationMap, type);
                }
            }

            return Status.OK_STATUS;
        }
    }

}
