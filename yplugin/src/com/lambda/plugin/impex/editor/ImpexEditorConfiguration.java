package com.lambda.plugin.impex.editor;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.DefaultInformationControl;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IInformationControl;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.ITextDoubleClickStrategy;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposalSorter;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContentAssistant;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.PresentationReconciler;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.reconciler.MonoReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.editors.text.TextSourceViewerConfiguration;

import com.lambda.plugin.impex.antlr.AntlrTypeToPartitionTokenMapper;
import com.lambda.plugin.impex.antlr.AntlrTypeToStyleTokenMapper;
import com.lambda.plugin.impex.editor.assist.ImpexContentAssistProcessor;

public class ImpexEditorConfiguration extends TextSourceViewerConfiguration {

    private static final String[] CONTENT_TYPES = contentTypes();
    private ImpexDoubleClickStrategy doubleClickStrategy;
    private ImpexTokenScanner scanner;
    private final ImpexEditor editor;
    private final AntlrTypeToStyleTokenMapper styleTokenMapper;

    public ImpexEditorConfiguration(IPreferenceStore preferenceStore) {
        this(preferenceStore, null);
    }

    public ImpexEditorConfiguration(IPreferenceStore preferenceStore, final ImpexEditor editor) {
        super(preferenceStore);
        this.editor = editor;
        this.styleTokenMapper = new AntlrTypeToStyleTokenMapper(preferenceStore);
    }

    @Override
    public IContentAssistant getContentAssistant(final ISourceViewer sourceViewer) {

        // Create content assistant
        final ContentAssistant assistant = new ContentAssistant();
        assistant.enableColoredLabels(true);
        assistant.setSorter(new ICompletionProposalSorter() {
            @Override
            public int compare(ICompletionProposal p1, ICompletionProposal p2) {
                return p1.getDisplayString().compareTo(p2.getDisplayString());
            }
        });
        // Create content assistant processor
        final IContentAssistProcessor processor = new ImpexContentAssistProcessor(editor);
        // Set this processor for each supported content type
        // assistant.setContentAssistProcessor(processor, ImpexPartitionScanner.IMPEX_HEADER);
        // assistant.setContentAssistProcessor(processor, XMLPartitionScanner.XML_DEFAULT);
        assistant.setContentAssistProcessor(processor, IDocument.DEFAULT_CONTENT_TYPE);
        assistant.setInformationControlCreator(getInformationControlCreator(sourceViewer));

        // Return the content assistant
        return assistant;
    }

    // @Override
    // public IQuickAssistAssistant getQuickAssistAssistant(ISourceViewer sourceViewer) {
    // QuickAssistAssistant assistant = new QuickAssistAssistant();
    // assistant.setQuickAssistProcessor(new ImpexQuickAssistProcessor());
    // return assistant;
    // }

    @Override
    public IInformationControlCreator getInformationControlCreator(final ISourceViewer sourceViewer) {

        return new IInformationControlCreator() {
            @Override
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

    protected ImpexTokenScanner getImpexScanner() {
        if (scanner == null) {
            scanner = new ImpexTokenScanner(styleTokenMapper);
        }
        return scanner;
    }

    @Override
    public IPresentationReconciler getPresentationReconciler(final ISourceViewer sourceViewer) {
        final PresentationReconciler reconciler = new PresentationReconciler();
        reconciler.setDocumentPartitioning(getConfiguredDocumentPartitioning(sourceViewer));
        DefaultDamagerRepairer dr = new DefaultDamagerRepairer(getImpexScanner());
        String[] configuredContentTypes = getConfiguredContentTypes(sourceViewer);
        for (String contentType : configuredContentTypes) {
            reconciler.setDamager(dr, contentType);
            reconciler.setRepairer(dr, contentType);
        }
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

    @Override
    public String[] getDefaultPrefixes(ISourceViewer sourceViewer, String contentType) {
        return AntlrTypeToPartitionTokenMapper.defaultPrefixes(contentType);
    }
}