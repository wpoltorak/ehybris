package com.lambda.plugin.impex.editor;

import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.reconciler.MonoReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.jface.text.source.SourceViewerConfiguration;
import org.eclipse.swt.widgets.Shell;

public class ImpexConfiguration extends SourceViewerConfiguration {
    private ImpexDoubleClickStrategy doubleClickStrategy;
    private ImpexHeaderScanner headerScanner;
    private ImpexMacroScanner macroAssignementScanner;
    private ImpexScanner scanner;
    private final ColorManager colorManager;
    private final ImpexEditor editor;

    public ImpexConfiguration(final ImpexEditor editor, final ColorManager colorManager) {
        this.editor = editor;
        this.colorManager = colorManager;
    }

    @Override
    public IContentAssistant getContentAssistant(final ISourceViewer sourceViewer) {
        // Create content assistant
        final ContentAssistant assistant = new ContentAssistant();

        // Create content assistant processor
        final IContentAssistProcessor processor = new ImpexContentAssistProcessor();

        // Set this processor for each supported content type
        //        assistant.setContentAssistProcessor(processor, ImpexPartitionScanner.IMPEX_HEADER);
        //        assistant.setContentAssistProcessor(processor, XMLPartitionScanner.XML_DEFAULT);
        assistant.setContentAssistProcessor(processor, IDocument.DEFAULT_CONTENT_TYPE);
        assistant.setInformationControlCreator(getInformationControlCreator(sourceViewer));
        // Return the content assistant   
        return assistant;
    }

    @Override
    public IInformationControlCreator getInformationControlCreator(final ISourceViewer sourceViewer) {

        return new IInformationControlCreator() {
            public IInformationControl createInformationControl(final Shell parent) {
                return new DefaultInformationControl(parent);
                //                return new DefaultInformationControl(parent, presenter);
            }
        };
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

    @Override
    public IReconciler getReconciler(final ISourceViewer sourceViewer) {
        final MonoReconciler reconciler = new MonoReconciler(new ImpexReconcilingStrategy(editor), false);
        reconciler.setDelay(ImpexReconcilingStrategy.DELAY);
        //        reconciler.addReconcilingParticipant(editor);
        return reconciler;
    }

    //    private static final DefaultInformationControl.IInformationPresenter presenter = new DefaultInformationControl.IInformationPresenter() {
    //        public String updatePresentation(final Display display, final String infoText, final TextPresentation presentation,
    //                final int maxWidth, final int maxHeight) {
    //            int start = -1;
    //
    //            // Loop over all characters of information text
    //            for (int i = 0; i < infoText.length(); i++) {
    //                switch (infoText.charAt(i)) {
    //                    case '<':
    //
    //                        // Remember start of tag
    //                        start = i;
    //                        break;
    //                    case '>':
    //                        if (start >= 0) {
    //
    //                            // We have found a tag and create a new style range
    //                            final StyleRange range = new StyleRange(start, i - start + 1, null, null, SWT.BOLD);
    //
    //                            // Add this style range to the presentation
    //                            presentation.addStyleRange(range);
    //
    //                            // Reset tag start indicator
    //                            start = -1;
    //                        }
    //                        break;
    //                }
    //            }
    //
    //            // Return the information text
    //
    //            return infoText;
    //        }
    //    };

}