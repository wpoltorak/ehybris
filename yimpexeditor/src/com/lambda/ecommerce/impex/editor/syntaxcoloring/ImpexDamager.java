package com.lambda.ecommerce.impex.editor.syntaxcoloring;

import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.presentation.IPresentationDamager;

import com.lambda.ecommerce.impex.editor.ImpexDocument;

public class ImpexDamager implements IPresentationDamager {

    private ImpexDocument document;

    @Override
    public void setDocument(IDocument document) {
        if (document instanceof ImpexDocument) {
            this.document = (ImpexDocument) document;
        }
    }

    @Override
    public IRegion getDamageRegion(ITypedRegion partition, DocumentEvent e, boolean documentPartitioningChanged) {
        if (document == null) {
            return new Region(0, 0);
        }
        return document.getDamageRegion(e);
        // if (!(e.getDocument() instanceof ImpexDocument)) {
        // return new Region(0, 0);
        // }
        // ImpexDocument document = (ImpexDocument) e.getDocument();
        // IRegion lastDamage = document.getLastDamage();
        // // check whether this is just a presentation invalidation not based on a real document change
        // if (lastDamage == null || !isEventMatchingLastDamage(e, lastDamage)) {
        // IRegion result = computeInterSection(partition, e, document);
        // return result;
        // }
        //
        // if (!TextUtilities.overlaps(partition, lastDamage) && lastDamage.getOffset() < e.getDocument().getLength()) {
        // if (documentPartitioningChanged)
        // return partition;
        // return lastDamage;
        // }
        //
        // int offset = Math.max(lastDamage.getOffset(), partition.getOffset());
        // int endOffset = Math.min(lastDamage.getOffset() + lastDamage.getLength(),
        // partition.getOffset() + partition.getLength());
        //
        // IRegion result = new Region(offset, endOffset - offset);
    }

    /**
     * @return the common region of the given partition and the changed region in the DocumentEvent based on the
     *         underlying tokens.
     */
    protected IRegion computeInterSection(ITypedRegion partition, DocumentEvent e, ImpexDocument document) {
        // Iterable<ILexerTokenRegion> tokensInPartition = Iterables.filter(document.getTokens(),
        // Regions.overlaps(partition.getOffset(), partition.getLength()));
        // Iterator<ILexerTokenRegion> tokens = Iterables.filter(tokensInPartition,
        // Regions.overlaps(e.getOffset(), e.getLength())).iterator();
        // if (tokens.hasNext()) {
        // ILexerTokenRegion first = tokens.next();
        // ILexerTokenRegion last = first;
        // while (tokens.hasNext())
        // last = tokens.next();
        // return new Region(first.getOffset(), last.getOffset() + last.getLength() - first.getOffset());
        // }
        // this shouldn't happen, but just in case return the whole partition
        return partition;
    }

    /**
     * @return <code>true</code> only if the lastDamage is encloses the affected text of the given DocumentEvent.
     */
    protected boolean isEventMatchingLastDamage(DocumentEvent e, IRegion lastDamage) {
        int eventStart = e.getOffset();
        int eventEnd = eventStart + e.getText().length();
        int damageStart = lastDamage.getOffset();
        int damageEnd = damageStart + lastDamage.getLength();
        boolean result = damageStart <= eventStart && damageEnd >= eventEnd;
        return result;
    }
}