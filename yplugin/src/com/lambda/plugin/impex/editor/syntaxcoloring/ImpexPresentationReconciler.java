package com.lambda.plugin.impex.editor.syntaxcoloring;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.jface.text.TypedRegion;
import org.eclipse.jface.text.presentation.IPresentationDamager;
import org.eclipse.jface.text.presentation.IPresentationRepairer;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.swt.custom.StyleRange;

public class ImpexPresentationReconciler extends PresentationReconciler {

    private IPresentationDamager damager;
    private IPresentationRepairer repairer;

    @Override
    protected TextPresentation createPresentation(IRegion damage, IDocument document) {
        // try {
        if (repairer == null) {
            TextPresentation presentation = new TextPresentation(damage, 100);
            presentation.setDefaultStyleRange(new StyleRange(damage.getOffset(), damage.getLength(), null, null));
            return presentation;
        }

        TextPresentation presentation = new TextPresentation(damage, 1000);

        repairer.createPresentation(presentation, new TypedRegion(damage.getOffset(), damage.getLength(), null));
        // ITypedRegion[] partitioning = TextUtilities.computePartitioning(document, getDocumentPartitioning(),
        // damage.getOffset(), damage.getLength(), false);
        // for (int i = 0; i < partitioning.length; i++) {
        // ITypedRegion r = partitioning[i];
        // IPresentationRepairer repairer = getRepairer(r.getType());
        // if (repairer != null)
        // repairer.createPresentation(presentation, r);
        // }

        return presentation;

        // } catch (BadLocationException x) {
        // return null;
        // }
    }

    @Override
    protected void setDocumentToRepairers(IDocument document) {
        if (repairer != null) {
            repairer.setDocument(document);
        }
    }

    @Override
    protected void setDocumentToDamagers(IDocument document) {
        if (damager != null) {
            damager.setDocument(document);
        }
    }

    public void setDamager(IPresentationDamager damager) {
        this.damager = damager;
    }

    public void setRepairer(IPresentationRepairer repairer) {
        this.repairer = repairer;
    }

    @Override
    public void setRepairer(IPresentationRepairer repairer, String contentType) {
        throw new UnsupportedOperationException("Please use setRepairer(repairer) instead");
    }

    @Override
    public void setDamager(IPresentationDamager damager, String contentType) {
        throw new UnsupportedOperationException("Please use setDamager(damager) instead");
    }

    @Override
    public IPresentationRepairer getRepairer(String contentType) {
        throw new UnsupportedOperationException("Please use getRepirer() instead");
    }

    @Override
    public IPresentationDamager getDamager(String contentType) {
        throw new UnsupportedOperationException("Please use getDdamager() instead");
    }
}
