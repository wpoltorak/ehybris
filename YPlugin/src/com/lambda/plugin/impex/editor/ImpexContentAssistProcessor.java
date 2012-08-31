package com.lambda.plugin.impex.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ContextInformationValidator;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

public class ImpexContentAssistProcessor implements IContentAssistProcessor {

    private final static String[] PROPOSALS = new String[] { ImpexHeaderRule.INSERT, ImpexHeaderRule.INSERT_UPDATE, ImpexHeaderRule.UPDATE,
            ImpexHeaderRule.REMOVE };

    public ICompletionProposal[] computeCompletionProposals(final ITextViewer viewer, final int offset) {
        final IDocument doc = viewer.getDocument();
        final String qualifier = getQualifier(doc, offset);
        return computeStructureProposals(qualifier, offset);
    }

    private String getQualifier(final IDocument doc, int documentOffset) {

        // Use string buffer to collect characters
        final StringBuffer buf = new StringBuffer();
        while (true) {
            try {

                // Read character backwards
                final char c = doc.getChar(--documentOffset);

                // Start of tag. Return qualifier
                if (Character.isWhitespace(c)) {
                    return buf.reverse().toString();
                }

                // Collect character
                buf.append(c);

            } catch (final BadLocationException e) {
                // Document start reached, no tag found
                return "";
            }
        }
    }

    public IContextInformation[] computeContextInformation(final ITextViewer viewer, final int offset) {
        return null;
    }

    public char[] getCompletionProposalAutoActivationCharacters() {
        // TODO Auto-generated method stub
        return null;
    }

    public char[] getContextInformationAutoActivationCharacters() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getErrorMessage() {
        // TODO Auto-generated method stub
        return null;
    }

    public IContextInformationValidator getContextInformationValidator() {
        return new ContextInformationValidator(this);
    }

    private ICompletionProposal[] computeStructureProposals(final String qualifier, final int documentOffset) {
        final List<ICompletionProposal> propList = new ArrayList<ICompletionProposal>();
        final int qlen = qualifier.length();
        for (int i = 0; i < PROPOSALS.length; i++) {
            final String proposal = PROPOSALS[i];

            if (proposal.startsWith(qualifier.toUpperCase())) {
                final int cursor = proposal.length();
                propList.add(new CompletionProposal(proposal, documentOffset - qlen, qlen, cursor));
            }
        }
        final ICompletionProposal[] proposals = new ICompletionProposal[propList.size()];
        propList.toArray(proposals);
        return proposals;
    }
}
