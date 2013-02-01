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

import com.lambda.plugin.impex.editor.ImpexDocumentParticipant.ImpexPartitioner;

public class ImpexEditorConfiguration extends SourceViewerConfiguration {

    private static final String[] CONTENT_TYPES = contentTypes();
    private ImpexDoubleClickStrategy doubleClickStrategy;
    private ImpexHeaderScanner headerScanner;
    private ImpexMacroScanner macroAssignementScanner;
    private ImpexScanner scanner;
    private final ColorManager colorManager;
    private final ImpexEditor editor;
    private BeanshellScanner beanshellScanner;
    private CommentScanner commentScanner;

    public ImpexEditorConfiguration(final ImpexEditor editor, final ColorManager colorManager) {
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
        // assistant.setContentAssistProcessor(processor, ImpexPartitionScanner.IMPEX_HEADER);
        // assistant.setContentAssistProcessor(processor, XMLPartitionScanner.XML_DEFAULT);
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
                // return new DefaultInformationControl(parent, presenter);
            }
        };
    }

    @Override
    public String getConfiguredDocumentPartitioning(ISourceViewer sourceViewer) {
        return ImpexDocumentParticipant.ImpexPartitioner.IMPEX_PARTITIONING;
    }

    @Override
    public String[] getConfiguredContentTypes(final ISourceViewer sourceViewer) {
        return CONTENT_TYPES;
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
        }
        return scanner;
    }

    protected ImpexHeaderScanner getHeaderScanner() {
        if (headerScanner == null) {
            headerScanner = new ImpexHeaderScanner(colorManager);
            headerScanner.setDefaultReturnToken(new Token(new TextAttribute(colorManager
                    .getColor(ImpexColorConstants.IMPEX_HEADER_DEFAULT))));
        }
        return headerScanner;
    }

    protected BeanshellScanner getBeanshellScanner() {
        if (beanshellScanner == null) {
            beanshellScanner = new BeanshellScanner(colorManager);
        }
        return beanshellScanner;
    }

    protected CommentScanner getCommentScanner() {
        if (commentScanner == null) {
            commentScanner = new CommentScanner(colorManager);
        }
        return commentScanner;
    }

    protected ImpexMacroScanner getMacroAssignementScanner() {
        if (macroAssignementScanner == null) {
            macroAssignementScanner = new ImpexMacroScanner(colorManager);
        }
        return macroAssignementScanner;
    }

    @Override
    public IPresentationReconciler getPresentationReconciler(final ISourceViewer sourceViewer) {
        final PresentationReconciler reconciler = new PresentationReconciler();
        reconciler.setDocumentPartitioning(ImpexPartitioner.IMPEX_PARTITIONING);
        DefaultDamagerRepairer dr = new DefaultDamagerRepairer(getBeanshellScanner());
        reconciler.setDamager(dr, ImpexPartitionScanner.BEANSHELL);
        reconciler.setRepairer(dr, ImpexPartitionScanner.BEANSHELL);

        // dr = new DefaultDamagerRepairer(getImpexScanner());
        // reconciler.setDamager(dr, ImpexPartitionScanner.COMMENT);
        // reconciler.setRepairer(dr, ImpexPartitionScanner.COMMENT);

        // dr = new DefaultDamagerRepairer(getImpexScanner());
        // reconciler.setDamager(dr, ImpexPartitionScanner.STRING);
        // reconciler.setRepairer(dr, ImpexPartitionScanner.STRING);

        // dr = new NonRuleBasedDamagerRepairer(new
        // TextAttribute(colorManager.getColor(ImpexColorConstants.IMPEX_COMMENT)));
        // dr = new DefaultDamagerRepairer(getImpexScanner());
        // reconciler.setDamager(dr, ImpexScanner.IMPEX_COMMENT);
        // reconciler.setRepairer(dr, ImpexScanner.IMPEX_COMMENT);
        dr = new DefaultDamagerRepairer(getCommentScanner());
        reconciler.setDamager(dr, ImpexPartitionScanner.COMMENT);
        reconciler.setRepairer(dr, ImpexPartitionScanner.COMMENT);

        dr = new DefaultDamagerRepairer(getImpexScanner());
        reconciler.setDamager(dr, IDocument.DEFAULT_CONTENT_TYPE);
        reconciler.setRepairer(dr, IDocument.DEFAULT_CONTENT_TYPE);

        return reconciler;
    }

    @Override
    public IReconciler getReconciler(final ISourceViewer sourceViewer) {
        final MonoReconciler reconciler = new MonoReconciler(new ImpexReconcilingStrategy(editor), false);
        reconciler.setDelay(ImpexReconcilingStrategy.DELAY);
        // reconciler.addReconcilingParticipant(editor);
        return reconciler;
    }

    // private static final DefaultInformationControl.IInformationPresenter presenter = new
    // DefaultInformationControl.IInformationPresenter() {
    // public String updatePresentation(final Display display, final String infoText, final TextPresentation
    // presentation,
    // final int maxWidth, final int maxHeight) {
    // int start = -1;
    //
    // // Loop over all characters of information text
    // for (int i = 0; i < infoText.length(); i++) {
    // switch (infoText.charAt(i)) {
    // case '<':
    //
    // // Remember start of tag
    // start = i;
    // break;
    // case '>':
    // if (start >= 0) {
    //
    // // We have found a tag and create a new style range
    // final StyleRange range = new StyleRange(start, i - start + 1, null, null, SWT.BOLD);
    //
    // // Add this style range to the presentation
    // presentation.addStyleRange(range);
    //
    // // Reset tag start indicator
    // start = -1;
    // }
    // break;
    // }
    // }
    //
    // // Return the information text
    //
    // return infoText;
    // }
    // };

    /**
     * Return an array of content types from {@link ImpexPartitionScanner#CONTENT_TYPES} extended with
     * {@link IDocument#DEFAULT_CONTENT_TYPE}
     * 
     * @return array of content types
     */
    private static String[] contentTypes() {
        String[] contentTypes = new String[ImpexPartitionScanner.CONTENT_TYPES.length + 1];
        System.arraycopy(ImpexPartitionScanner.CONTENT_TYPES, 0, contentTypes, 1,
                ImpexPartitionScanner.CONTENT_TYPES.length);
        contentTypes[0] = IDocument.DEFAULT_CONTENT_TYPE;
        return contentTypes;
    }
}