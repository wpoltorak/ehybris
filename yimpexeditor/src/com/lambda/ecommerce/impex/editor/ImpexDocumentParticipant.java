package com.lambda.ecommerce.impex.editor;

import org.eclipse.core.filebuffers.IDocumentSetupParticipant;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.rules.FastPartitioner;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;

import com.lambda.ecommerce.impex.YImpex;
import com.lambda.ecommerce.impex.antlr.AntlrTypeToPartitionTokenMapper;

public class ImpexDocumentParticipant implements IDocumentSetupParticipant {

    private final AntlrTypeToPartitionTokenMapper tokenMapper;

    public ImpexDocumentParticipant() {
        this.tokenMapper = new AntlrTypeToPartitionTokenMapper();
    }

    @Override
    public void setup(IDocument document) {
        YImpex.logInfo("ImpexDocumentParticipant setup called", null);
        final IDocumentPartitioner partitioner = new ImpexPartitioner(new ImpexPartitionScanner(tokenMapper),
                ImpexPartitionScanner.CONTENT_TYPES);
        if (document instanceof IDocumentExtension3) {
            ((IDocumentExtension3) document).setDocumentPartitioner(ImpexPartitioner.IMPEX_PARTITIONING, partitioner);
        } else {
            document.setDocumentPartitioner(partitioner);
        }
        partitioner.connect(document);
    }

    public class ImpexPartitioner extends FastPartitioner {

        public static final String IMPEX_PARTITIONING = "___impex_partitioning";

        public ImpexPartitioner(final IPartitionTokenScanner scanner, final String[] legalContentTypes) {
            super(scanner, legalContentTypes);
            YImpex.logInfo("ImpexPartitioner created", null);
        }

        @Override
        public void connect(final IDocument document, final boolean delayInitialization) {
            super.connect(document, delayInitialization);
            YImpex.logInfo("ImpexPartitionar connecting document", null);
            // printPartitions(document, 0, document.getLength());
        }

        /**
         * There is no way to create event with proper {@link ImpexDocument} that is why it is being modified here.
         */
        @Override
        public void documentAboutToBeChanged(DocumentEvent e) {
            ((ImpexDocument) fDocument).ensureCorrectDocument(e);
            super.documentAboutToBeChanged(e);
        }

        /**
         * There is no way to create event with proper {@link ImpexDocument} that is why it is being modified here.
         */
        @Override
        public IRegion documentChanged2(DocumentEvent e) {
            ((ImpexDocument) fDocument).ensureCorrectDocument(e);
            System.out.println("ImpexPartitioner documentChanged2 - reparse tokens");
            IRegion region = super.documentChanged2(e);
            // printPartitions(fDocument, e.getOffset(), e.getLength());
            // printPartitions(fDocument, 0, fDocument.getLength());
            return region;
        }

        private void printPartitions(final IDocument document, int offset, int length) {
            final StringBuffer buffer = new StringBuffer();

            final ITypedRegion[] partitions = computePartitioning(offset, length);
            for (int i = 0; i < partitions.length; i++) {
                try {
                    buffer.append("Partition " + i + " type: " + partitions[i].getType() + ", offset: "
                            + partitions[i].getOffset() + ", length: " + partitions[i].getLength());
                    buffer.append("\nText: ");
                    buffer.append(document.get(partitions[i].getOffset(), partitions[i].getLength()));
                    buffer.append("\n---------------------------\n");
                } catch (final BadLocationException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(buffer);
        }
    }

}
