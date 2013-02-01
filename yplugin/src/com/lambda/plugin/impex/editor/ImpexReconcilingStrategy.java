package com.lambda.plugin.impex.editor;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.reconciler.DirtyRegion;
import org.eclipse.jface.text.reconciler.IReconcilingStrategy;
import org.eclipse.jface.text.reconciler.IReconcilingStrategyExtension;
import org.eclipse.swt.widgets.Display;

import com.lambda.impex.ast.ImpexCompiler;
import com.lambda.impex.ast.ImpexContext;
import com.lambda.impex.ast.ImpexParser;
import com.lambda.plugin.YPlugin;
import com.lambda.plugin.impex.model.DefaultImpexVisitor;
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

            final ImpexCompiler compiler = new ImpexCompiler();
            DefaultImpexVisitor visitor = new DefaultImpexVisitor();
            compiler.setVisitor(visitor);
            compiler.compile(source);

            ImpexContext context = compiler.getContext();
            CommonTree ast = compiler.getAST();

            Tree blocks = ast.getFirstChildWithType(ImpexParser.BLOCKS);
            final List<Position> positions = new ArrayList<Position>();
            for (int i = 0; i < blocks.getChildCount(); i++) {
                CommonTree child = (CommonTree) blocks.getChild(i);
                CommonToken token = (CommonToken) child.getToken();
                Position position = new Position(token.getStartIndex(), token.getStopIndex() - token.getStartIndex());
                positions.add(position);
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