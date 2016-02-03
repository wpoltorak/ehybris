package com.lambda.ecommerce.impex.editor.syntaxcoloring;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.BadPositionCategoryException;
import org.eclipse.jface.text.DefaultPositionUpdater;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.DocumentPartitioningChangedEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.IDocumentPartitioningListener;
import org.eclipse.jface.text.IDocumentPartitioningListenerExtension;
import org.eclipse.jface.text.IDocumentPartitioningListenerExtension2;
import org.eclipse.jface.text.IPositionUpdater;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextInputListener;
import org.eclipse.jface.text.ITextListener;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.ITextViewerExtension5;
import org.eclipse.jface.text.Position;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.TextEvent;
import org.eclipse.jface.text.TextPresentation;
import org.eclipse.jface.text.TypedRegion;
import org.eclipse.jface.text.presentation.IPresentationDamager;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.presentation.IPresentationReconcilerExtension;
import org.eclipse.jface.text.presentation.IPresentationRepairer;
import org.eclipse.swt.custom.StyleRange;

import com.lambda.ecommerce.impex.editor.ImpexDocument;

//TODO zrozumieć pozostały kod z presentation reconciler, w szczególności kategorie i updater pozycji
public class ImpexPresentationReconciler implements IPresentationReconciler, IPresentationReconcilerExtension {

    private ITextViewer fViewer;
    /** The internal listener. */
    private final InternalListener fInternalListener = new InternalListener();
    /** The name of the position category to track damage regions. */
    private final String fPositionCategory;
    /** The position updated for the damage regions' position category. */
    private final IPositionUpdater fPositionUpdater;
    /** The positions representing the damage regions. */
    private Position fRememberedPosition;

    private IPresentationDamager damager;
    private IPresentationRepairer repairer;

    public ImpexPresentationReconciler() {
        fPartitioning = IDocumentExtension3.DEFAULT_PARTITIONING;
        fPositionCategory = TRACKED_PARTITION + hashCode();
        fPositionUpdater = new DefaultPositionUpdater(fPositionCategory);
    }

    protected TextPresentation createPresentation(IRegion damage, IDocument document) {
        // try {
        if (repairer == null) {
            TextPresentation presentation = new TextPresentation(damage, 100);
            presentation.setDefaultStyleRange(new StyleRange(damage.getOffset(), damage.getLength(), null, null));
            return presentation;
        }

        TextPresentation presentation = new TextPresentation(damage, 1000);
        repairer.createPresentation(presentation, new TypedRegion(damage.getOffset(), damage.getLength(), null));
        return presentation;
    }

    protected void setDocumentToRepairers(IDocument document) {
        if (repairer != null) {
            repairer.setDocument(document);
        }
    }

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

    /** Prefix of the name of the position category for tracking damage regions. */
    protected final static String TRACKED_PARTITION = "__reconciler_tracked_partition"; //$NON-NLS-1$

    /**
     * Internal listener class.
     */
    class InternalListener implements ITextInputListener, IDocumentListener, ITextListener,
            IDocumentPartitioningListener, IDocumentPartitioningListenerExtension,
            IDocumentPartitioningListenerExtension2 {

        /** Set to <code>true</code> if between a document about to be changed and a changed event. */
        private boolean fDocumentChanging = false;
        /**
         * The cached redraw state of the text viewer.
         * 
         * @since 3.0
         */
        private boolean fCachedRedrawState = true;

        /*
         * @see ITextInputListener#inputDocumentAboutToBeChanged(IDocument, IDocument)
         */
        @Override
        public void inputDocumentAboutToBeChanged(IDocument oldDocument, IDocument newDocument) {
            if (oldDocument != null) {
                try {

                    fViewer.removeTextListener(this);
                    oldDocument.removeDocumentListener(this);
                    oldDocument.removeDocumentPartitioningListener(this);

                    oldDocument.removePositionUpdater(fPositionUpdater);
                    oldDocument.removePositionCategory(fPositionCategory);

                } catch (BadPositionCategoryException x) {
                    // should not happened for former input documents;
                }
            }
        }

        /*
         * @see ITextInputListener#inputDocumenChanged(IDocument, IDocument)
         */
        @Override
        public void inputDocumentChanged(IDocument oldDocument, IDocument newDocument) {

            fDocumentChanging = false;
            fCachedRedrawState = true;

            if (newDocument != null) {

                newDocument.addPositionCategory(fPositionCategory);
                newDocument.addPositionUpdater(fPositionUpdater);

                newDocument.addDocumentPartitioningListener(this);
                newDocument.addDocumentListener(this);
                fViewer.addTextListener(this);

                setDocumentToDamagers(newDocument);
                setDocumentToRepairers(newDocument);
                processDamage(new Region(0, newDocument.getLength()), newDocument);
            }
        }

        /*
         * @see IDocumentPartitioningListener#documentPartitioningChanged(IDocument)
         */
        @Override
        public void documentPartitioningChanged(IDocument document) {
            if (!fDocumentChanging && fCachedRedrawState) {
                processDamage(new Region(0, document.getLength()), document);
            }
        }

        /*
         * @see IDocumentPartitioningListenerExtension#documentPartitioningChanged(IDocument, IRegion)
         * 
         * @since 2.0
         */
        @Override
        public void documentPartitioningChanged(IDocument document, IRegion changedRegion) {
            if (!fDocumentChanging && fCachedRedrawState) {
                processDamage(new Region(changedRegion.getOffset(), changedRegion.getLength()), document);
            }
        }

        /*
         * @see
         * org.eclipse.jface.text.IDocumentPartitioningListenerExtension2#documentPartitioningChanged(org.eclipse.jface
         * .text.DocumentPartitioningChangedEvent)
         * 
         * @since 3.0
         */
        @Override
        public void documentPartitioningChanged(DocumentPartitioningChangedEvent event) {
            IRegion changedRegion = event.getChangedRegion(getDocumentPartitioning());
            if (changedRegion != null) {
                documentPartitioningChanged(event.getDocument(), changedRegion);
            }
        }

        /*
         * @see IDocumentListener#documentAboutToBeChanged(DocumentEvent)
         */
        @Override
        public void documentAboutToBeChanged(DocumentEvent e) {

            fDocumentChanging = true;
            if (fCachedRedrawState) {
                try {
                    int offset = e.getOffset() + e.getLength();
                    IRegion region = getBlockOrLine(e.getDocument(), offset);
                    fRememberedPosition = new Position(region.getOffset(), region.getLength());
                    e.getDocument().addPosition(fPositionCategory, fRememberedPosition);
                } catch (BadLocationException x) {
                    // can not happen
                } catch (BadPositionCategoryException x) {
                    // should not happen on input elements
                }
            }
        }

        /*
         * @see IDocumentListener#documentChanged(DocumentEvent)
         */
        @Override
        public void documentChanged(DocumentEvent e) {
            if (fCachedRedrawState) {
                try {
                    e.getDocument().removePosition(fPositionCategory, fRememberedPosition);
                } catch (BadPositionCategoryException x) {
                    // can not happen on input documents
                }
            }
            fDocumentChanging = false;
        }

        /*
         * @see ITextListener#textChanged(TextEvent)
         */
        @Override
        public void textChanged(TextEvent e) {

            fCachedRedrawState = e.getViewerRedrawState();
            if (!fCachedRedrawState) {
                return;
            }
            IRegion damage = null;
            IDocument document = null;

            if (e.getDocumentEvent() == null) {
                document = fViewer.getDocument();
                if (document != null) {
                    // redraw state change, damage the whole document
                    damage = new Region(0, document.getLength());
                }
            } else {
                DocumentEvent de = e.getDocumentEvent();
                document = de.getDocument();
                damage = ((ImpexDocument) document).getDamageRegion(de);
            }

            if (document != null) {
                processDamage(damage, document);
            }
        }

        /**
         * Translates the given text event into the corresponding range of the viewer's document.
         * 
         * @param e the text event
         * @return the widget region corresponding the region of the given event or <code>null</code> if none
         * @since 2.1
         */
        protected IRegion widgetRegion2ModelRegion(TextEvent e) {

            String text = e.getText();
            int length = text == null ? 0 : text.length();

            if (fViewer instanceof ITextViewerExtension5) {
                ITextViewerExtension5 extension = (ITextViewerExtension5) fViewer;
                return extension.widgetRange2ModelRange(new Region(e.getOffset(), length));
            }

            IRegion visible = fViewer.getVisibleRegion();
            IRegion region = new Region(e.getOffset() + visible.getOffset(), length);
            return region;
        }
    }

    /**
     * The partitioning used by this presentation reconciler.
     * 
     * @since 3.0
     */
    private String fPartitioning;

    /**
     * Sets the document partitioning for this presentation reconciler.
     *
     * @param partitioning the document partitioning for this presentation reconciler.
     * @since 3.0
     */
    public void setDocumentPartitioning(String partitioning) {
        Assert.isNotNull(partitioning);
        fPartitioning = partitioning;
    }

    /*
     * @see org.eclipse.jface.text.presentation.IPresentationReconcilerExtension#geDocumenttPartitioning()
     * 
     * @since 3.0
     */
    @Override
    public String getDocumentPartitioning() {
        return fPartitioning;
    }

    /*
     * @see IPresentationReconciler#install(ITextViewer)
     */
    @Override
    public void install(ITextViewer viewer) {
        Assert.isNotNull(viewer);

        fViewer = viewer;
        fViewer.addTextInputListener(fInternalListener);

        IDocument document = viewer.getDocument();
        if (document != null)
            fInternalListener.inputDocumentChanged(null, document);
    }

    /*
     * @see IPresentationReconciler#uninstall()
     */
    @Override
    public void uninstall() {
        fViewer.removeTextInputListener(fInternalListener);

        // Ensure we uninstall all listeners
        fInternalListener.inputDocumentAboutToBeChanged(fViewer.getDocument(), null);
    }

    /**
     * Processes the given damage.
     * 
     * @param damage the damage to be repaired
     * @param document the document whose presentation must be repaired
     */
    private void processDamage(IRegion damage, IDocument document) {
        if (damage != null && damage.getLength() > 0) {
            TextPresentation p = createPresentation(damage, document);
            if (p != null)
                applyTextRegionCollection(p);
        }
    }

    /**
     * Applies the given text presentation to the text viewer the presentation reconciler is installed on.
     *
     * @param presentation the text presentation to be applied to the text viewer
     */
    private void applyTextRegionCollection(TextPresentation presentation) {
        fViewer.changeTextPresentation(presentation, false);
    }

    /**
     * Returns the partition for the given offset in the given document.
     *
     * @param document the document
     * @param offset the offset
     * @return the partition
     * @throws BadLocationException if offset is invalid in the given document
     * @since 3.0
     */
    private IRegion getBlockOrLine(IDocument document, int offset) throws BadLocationException {
        return ((ImpexDocument) document).getBlockOrLine(offset);
    }

    public void setRepairer(IPresentationRepairer repairer, String contentType) {
        this.repairer = repairer;
    }

    public void setDamager(IPresentationDamager damager, String contentType) {
        this.damager = damager;
    }

    @Override
    public IPresentationRepairer getRepairer(String contentType) {
        return repairer;
    }

    @Override
    public IPresentationDamager getDamager(String contentType) {
        return damager;
    }
}
