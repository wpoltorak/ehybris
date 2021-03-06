package com.lambda.plugin.impex.editor;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension;

import com.lambda.impex.ast.ImpexProblem;
import com.lambda.plugin.YPlugin;
import com.lambda.plugin.impex.model.IImpexModel;

public class ImpexReconcilingStrategy implements IReconcilingStrategy, IReconcilingStrategyExtension {

    public static final int DELAY = 500;

    private ImpexEditor editor;

    private IDocument document;

    public ImpexReconcilingStrategy() {
    }

    public ImpexReconcilingStrategy(final ImpexEditor editor) {
        this.editor = editor;
    }

    private void internalReconcile() {
        try {
            reconcile();

        } catch (final Exception e) {
            YPlugin.logError(e);
        }
    }

    private void reconcile() {
        final long start = System.nanoTime();

        if (editor == null) {
            return;
        }

        try {
            System.err.println("===> RECONCILE " + editor == null ? "" : editor.getEditorInput().getName()
                    + "##################");
            ImpexDocument impexDocument = (ImpexDocument) document;
            impexDocument.validate();
            List<ImpexProblem> problems = impexDocument.getModel().getProblems();
            final IImpexModel model = editor.getImpexModel();
            model.updateMarkers(problems);
            // final char[] source = document.get().toCharArray();
            // final ImpexValidator validator = new ImpexValidator();
            // validator.compile(source);
            //
            // ImpexParseContext context = validator.getContext();
            // ParseTree tree = validator.getParseTree();
            //
            // List<ParseTree> blocks = validator.blocks();
            // final List<Position> positions = new ArrayList<Position>();
            //
            // for (ParseTree block : blocks) {
            // // TODO reconcilng strategy
            // // Position position = new Position(block.getStartIndex(), block.getStopIndex() -
            // // token.getStartIndex());
            // // positions.add(position);
            // }

            // createProblemAnnotations(context.getProblems());
            // final IImpexModel model = editor.getImpexModel();
            // model.updateMarkers(context.getProblems());
            // Display.getDefault().asyncExec(new Runnable() {
            // @Override
            // public void run() {
            // editor.updateFoldingStructure(positions);
            // }
            // });

        } finally {
            System.err.println("===> TOOK " + TimeUnit.SECONDS.convert(System.nanoTime() - start, TimeUnit.NANOSECONDS)
                    + " seconds");

        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.text.reconciler.IReconcilingStrategy#reconcile(org.eclipse.jface.text.IRegion)
     */
    @Override
    public void reconcile(final IRegion partition) {
        internalReconcile();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.jface.text.reconciler.IReconcilingStrategy#reconcile(org.eclipse.jface.text.reconciler.DirtyRegion,
     * org.eclipse.jface.text.IRegion)
     */
    @Override
    public void reconcile(final DirtyRegion dirtyRegion, final IRegion subRegion) {
        internalReconcile();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension#initialReconcile()
     */
    @Override
    public void initialReconcile() {
        internalReconcile();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.text.reconciler.IReconcilingStrategy#setDocument(org.eclipse.jface.text.IDocument)
     */
    @Override
    public void setDocument(final IDocument document) {
        this.document = document;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension#setProgressMonitor(org.eclipse.core.runtime.
     * IProgressMonitor)
     */
    @Override
    public void setProgressMonitor(final IProgressMonitor monitor) {
    }
}