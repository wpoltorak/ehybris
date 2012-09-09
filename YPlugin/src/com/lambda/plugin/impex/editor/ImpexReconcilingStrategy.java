package com.lambda.plugin.impex.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension;

import com.lambda.plugin.YPlugin;
import com.lambda.plugin.impex.model.IImpexModel;
import com.lambda.plugin.impex.model.ImpexModel;

public class ImpexReconcilingStrategy implements IReconcilingStrategy, IReconcilingStrategyExtension {

    public static final int DELAY = 500;

    private final ImpexEditor editor;

    public ImpexReconcilingStrategy(final ImpexEditor editor) {
        this.editor = editor;
    }

    private void internalReconcile() {
        try {
            final IImpexModel model = editor.getImpexModel();
            if (model instanceof ImpexModel) {
                ((ImpexModel) model).reconcile();
            }
        } catch (final Exception e) {
            YPlugin.logError(e);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.text.reconciler.IReconcilingStrategy#reconcile(org.eclipse.jface.text.IRegion)
     */
    public void reconcile(final IRegion partition) {
        internalReconcile();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.text.reconciler.IReconcilingStrategy#reconcile(org.eclipse.jface.text.reconciler.DirtyRegion,
     * org.eclipse.jface.text.IRegion)
     */
    public void reconcile(final DirtyRegion dirtyRegion, final IRegion subRegion) {
        internalReconcile();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension#initialReconcile()
     */
    public void initialReconcile() {
        internalReconcile();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.text.reconciler.IReconcilingStrategy#setDocument(org.eclipse.jface.text.IDocument)
     */
    public void setDocument(final IDocument document) {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension#setProgressMonitor(org.eclipse.core.runtime.IProgressMonitor)
     */
    public void setProgressMonitor(final IProgressMonitor monitor) {
    }
}