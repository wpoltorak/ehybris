package com.lambda.ecommerce.impex.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.ui.texteditor.MarkerAnnotation;
import org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel;

public class ImpexAnnotationModel extends ResourceMarkerAnnotationModel {

    private final List generatedAnnotations = new ArrayList();
    private final List collectedProblems = new ArrayList();

    public ImpexAnnotationModel(final IFile file) {
        super(file);
    }

    @Override
    protected MarkerAnnotation createMarkerAnnotation(final IMarker marker) {
        // TODO Auto-generated method stub
        return super.createMarkerAnnotation(marker);
    }

    @Override
    protected void addAnnotation(final Annotation annotation, final Position position, final boolean fireModelChanged)
            throws BadLocationException {
        // TODO Auto-generated method stub
        super.addAnnotation(annotation, position, fireModelChanged);
    }

    @Override
    public void connect(IDocument document) {
        super.connect(((ImpexDocument) document).getDelegate());
    }

    @Override
    public void disconnect(IDocument document) {
        super.connect(((ImpexDocument) document).getDelegate());
    }

    @Override
    public void updateMarkers(IDocument document) throws CoreException {
        super.updateMarkers(document);
    }

    public void start() {
        collectedProblems.clear();
        generatedAnnotations.clear();
    }

    public void stop() {
    }

    public void report() {
    }
}
