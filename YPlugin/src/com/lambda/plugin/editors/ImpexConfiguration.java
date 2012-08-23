package com.lambda.plugin.editors;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;

public class ImpexConfiguration extends SourceViewerConfiguration {
    private ImpexDoubleClickStrategy doubleClickStrategy;
    private XMLTagScanner tagScanner;
    private ImpexScanner scanner;
    private final ColorManager colorManager;

    public ImpexConfiguration(final ColorManager colorManager) {
        this.colorManager = colorManager;
    }

    @Override
    public String[] getConfiguredContentTypes(final ISourceViewer sourceViewer) {
        return new String[] { IDocument.DEFAULT_CONTENT_TYPE, ImpexScanner.IMPEX_COMMENT, ImpexScanner.MACRO_ASSIGNMENT,
                ImpexPartitionScanner.XML_TAG };
    }

    @Override
    public ITextDoubleClickStrategy getDoubleClickStrategy(final ISourceViewer sourceViewer, final String contentType) {
        if (doubleClickStrategy == null) {
            doubleClickStrategy = new ImpexDoubleClickStrategy();
        }
        return doubleClickStrategy;
    }

    protected ImpexScanner getImpexScanner() {
        if (scanner == null) {
            scanner = new ImpexScanner(colorManager);
            scanner.setDefaultReturnToken(new Token(new TextAttribute(colorManager.getColor(ImpexColorConstants.DEFAULT))));
        }
        return scanner;
    }

    protected XMLTagScanner getXMLTagScanner() {
        if (tagScanner == null) {
            tagScanner = new XMLTagScanner(colorManager);
            tagScanner.setDefaultReturnToken(new Token(new TextAttribute(colorManager.getColor(ImpexColorConstants.TAG))));
        }
        return tagScanner;
    }

    @Override
    public IPresentationReconciler getPresentationReconciler(final ISourceViewer sourceViewer) {
        final PresentationReconciler reconciler = new PresentationReconciler();

        DefaultDamagerRepairer dr = new DefaultDamagerRepairer(getXMLTagScanner());
        reconciler.setDamager(dr, ImpexPartitionScanner.XML_TAG);
        reconciler.setRepairer(dr, ImpexPartitionScanner.XML_TAG);

        dr = new DefaultDamagerRepairer(getImpexScanner());
        reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
        reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

        dr = new DefaultDamagerRepairer(getImpexScanner());
        reconciler.setDamager(dr, ImpexScanner.MACRO_ASSIGNMENT);
        reconciler.setRepairer(dr, ImpexScanner.MACRO_ASSIGNMENT);

        final NonRuleBasedDamagerRepairer ndr = new NonRuleBasedDamagerRepairer(new TextAttribute(
                colorManager.getColor(ImpexColorConstants.IMPEX_COMMENT)));
        reconciler.setDamager(ndr, ImpexScanner.IMPEX_COMMENT);
        reconciler.setRepairer(ndr, ImpexScanner.IMPEX_COMMENT);

        return reconciler;
    }

}