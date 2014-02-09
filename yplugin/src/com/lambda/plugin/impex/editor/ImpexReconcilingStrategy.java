package com.lambda.plugin.impex.editor;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension;
import org.eclipse.swt.widgets.Display;

import com.lambda.impex.ast.ImpexParseContext;
import com.lambda.impex.ast.ImpexValidator;
import com.lambda.plugin.YPlugin;
import com.lambda.plugin.impex.model.IImpexModel;

public class ImpexReconcilingStrategy implements IReconcilingStrategy, IReconcilingStrategyExtension {

    public static final int DELAY = 500;

    private final ImpexEditor editor;

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
        final long start = System.currentTimeMillis();
        try {
            System.out.println("===> RECONCILE " + editor.getEditorInput().getName()
                    + "##################################");
            IDocument document = editor.getDocumentProvider().getDocument(editor.getEditorInput());
            final char[] source = document.get().toCharArray();

            final ImpexValidator validator = new ImpexValidator();
            validator.compile(source);

            ImpexParseContext context = validator.getContext();
            ParseTree tree = validator.getParseTree();

            List<ParseTree> blocks = validator.blocks();
            final List<Position> positions = new ArrayList<Position>();

            for (ParseTree block : blocks) {
                // TODO reconcilng strategy
                // Position position = new Position(block.getStartIndex(), block.getStopIndex() -
                // token.getStartIndex());
                // positions.add(position);
            }

            // createProblemAnnotations(context.getProblems());
            final IImpexModel model = editor.getImpexModel();
            model.updateMarkers(context.getProblems());
            Display.getDefault().asyncExec(new Runnable() {
                public void run() {
                    editor.updateFoldingStructure(positions);
                }
            });

        } finally {
            System.out.println("===> TOOK " + (System.currentTimeMillis() - start) / 1000);

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
     * @see
     * org.eclipse.jface.text.reconciler.IReconcilingStrategy#reconcile(org.eclipse.jface.text.reconciler.DirtyRegion,
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
     * @see org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension#setProgressMonitor(org.eclipse.core.runtime.
     * IProgressMonitor)
     */
    public void setProgressMonitor(final IProgressMonitor monitor) {
    }
}