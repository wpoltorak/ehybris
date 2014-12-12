package com.lambda.plugin.impex.editor.occurrences;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

    private OccurrencesFinderJob fOccurrencesFinderJob;
    private final ImpexEditor editor;
    /**
     * Holds the current occurrence annotations.
     * 
     * @since 3.1
     */
    private Annotation[] fOccurrenceAnnotations = null;

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
            updateOccurrenceAnnotations(textSelection, editor.getImpexModel());
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
    public void updateOccurrenceAnnotations(ITextSelection selection, IImpexModel model, boolean force) {

        if (fOccurrencesFinderJob != null) {
            fOccurrencesFinderJob.cancel();
        }

        if (!editor.isMarkingOccurrences()) {
            removeOccurrenceAnnotations();
            return;
        }

        if (selection == null || model == null) {
            return;
        }

        ISourceViewer sourceViewer = (ISourceViewer) editor.getAdapter(ISourceViewer.class);
        if (sourceViewer == null) {
            return;
        }
        ImpexDocument document = (ImpexDocument) sourceViewer.getDocument();

        List<Position> positions = null;

        OccurrencesFinder finder = new OccurrencesFinder(model, document, selection.getOffset());
        positions = finder.perform();

        if (positions.isEmpty()) {
            removeOccurrenceAnnotations();
            return;
        }

        fOccurrencesFinderJob = new OccurrencesFinderJob(document, positions, selection, force);
        fOccurrencesFinderJob.run(new NullProgressMonitor());
    }

    private void removeOccurrenceAnnotations() {
        IDocumentProvider documentProvider = editor.getDocumentProvider();
        if (documentProvider == null) {
            return;
        }

        IAnnotationModel annotationModel = documentProvider.getAnnotationModel(editor.getEditorInput());
        if (annotationModel == null || fOccurrenceAnnotations == null) {
            return;
        }

        IDocument document = documentProvider.getDocument(editor.getEditorInput());
        Object lock = editor.getLockObject((ImpexDocument) document);
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

            ISourceViewer sourceViewer = (ISourceViewer) editor.getAdapter(ISourceViewer.class);
            if (sourceViewer == null) {
                return Status.CANCEL_STATUS;
            }

            IDocument document = sourceViewer.getDocument();
            if (!(document instanceof ImpexDocument)) {
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

            Object lock = editor.getLockObject((ImpexDocument) document);
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
