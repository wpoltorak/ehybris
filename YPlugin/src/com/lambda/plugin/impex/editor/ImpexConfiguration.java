package com.lambda.plugin.impex.editor;

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
    private ImpexHeaderScanner headerScanner;
    private ImpexMacroScanner macroAssignementScanner;
    private ImpexScanner scanner;
    private final ColorManager colorManager;

    public ImpexConfiguration(final ColorManager colorManager) {
        this.colorManager = colorManager;
    }

    @Override
    public String[] getConfiguredContentTypes(final ISourceViewer sourceViewer) {
        return new String[] { IDocument.DEFAULT_CONTENT_TYPE, ImpexScanner.IMPEX_COMMENT, ImpexPartitionScanner.IMPEX_MACRO,
                ImpexPartitionScanner.IMPEX_HEADER };
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

    protected ImpexHeaderScanner getHeaderScanner() {
        if (headerScanner == null) {
            headerScanner = new ImpexHeaderScanner(colorManager);
            headerScanner.setDefaultReturnToken(new Token(
                    new TextAttribute(colorManager.getColor(ImpexColorConstants.IMPEX_HEADER_DEFAULT))));
        }
        return headerScanner;
    }

    protected ImpexMacroScanner getMacroAssignementScanner() {
        if (macroAssignementScanner == null) {
            macroAssignementScanner = new ImpexMacroScanner(colorManager);
            macroAssignementScanner.setDefaultReturnToken(new Token(new TextAttribute(colorManager
                    .getColor(ImpexColorConstants.IMPEX_MACRO))));
        }
        return macroAssignementScanner;
    }

    @Override
    public IPresentationReconciler getPresentationReconciler(final ISourceViewer sourceViewer) {
        final PresentationReconciler reconciler = new PresentationReconciler();

        DefaultDamagerRepairer dr = new DefaultDamagerRepairer(getHeaderScanner());
        reconciler.setDamager(dr, ImpexPartitionScanner.IMPEX_HEADER);
        reconciler.setRepairer(dr, ImpexPartitionScanner.IMPEX_HEADER);

        dr = new DefaultDamagerRepairer(getImpexScanner());
        reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
        reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

        dr = new DefaultDamagerRepairer(getMacroAssignementScanner());
        reconciler.setDamager(dr, ImpexPartitionScanner.IMPEX_MACRO);
        reconciler.setRepairer(dr, ImpexPartitionScanner.IMPEX_MACRO);

        final NonRuleBasedDamagerRepairer ndr = new NonRuleBasedDamagerRepairer(new TextAttribute(
                colorManager.getColor(ImpexColorConstants.IMPEX_COMMENT)));
        reconciler.setDamager(ndr, ImpexScanner.IMPEX_COMMENT);
        reconciler.setRepairer(ndr, ImpexScanner.IMPEX_COMMENT);

        return reconciler;
    }

}