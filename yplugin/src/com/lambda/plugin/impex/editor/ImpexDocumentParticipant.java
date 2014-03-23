package com.lambda.plugin.impex.editor;

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

import com.lambda.plugin.YPlugin;

public class ImpexDocumentParticipant implements IDocumentSetupParticipant {

    private final AntlrTokenToTokenMapper tokenMapper;

    public ImpexDocumentParticipant(AntlrTokenToTokenMapper tokenMapper) {
        this.tokenMapper = tokenMapper;
    }

    @Override
    public void setup(IDocument document) {
        YPlugin.logInfo("ImpexDocumentParticipant setup called", null);
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
            YPlugin.logInfo("ImpexPartitioner created", null);
        }

        @Override
        public void connect(final IDocument document, final boolean delayInitialization) {
            super.connect(document, delayInitialization);
            YPlugin.logInfo("ImpexPartitionar connecting document", null);
            printPartitions(document);
        }

        @Override
        public IRegion documentChanged2(DocumentEvent e) {
            IRegion region = super.documentChanged2(e);
            printPartitions(fDocument);
            return region;
        }

        public void printPartitions(final IDocument document) {
            final StringBuffer buffer = new StringBuffer();

            final ITypedRegion[] partitions = computePartitioning(0, document.getLength());
            for (int i = 0; i < partitions.length; i++) {
                try {
                    buffer.append("Partition type: " + partitions[i].getType() + ", offset: "
                            + partitions[i].getOffset() + ", length: " + partitions[i].getLength());
                    buffer.append("\n");
                    buffer.append("Text:\n");
                    buffer.append(document.get(partitions[i].getOffset(), partitions[i].getLength()));
                    buffer.append("\n---------------------------\n\n\n");
                } catch (final BadLocationException e) {
                    e.printStackTrace();
                }
            }
            System.out.print(buffer);
        }
    }

}
