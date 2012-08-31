package com.lambda.plugin.impex.editor;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ContextInformation;
import org.eclipse.jface.text.contentassist.ContextInformationValidator;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.swt.graphics.Point;

public class ImpexContentAssistProcessor implements IContentAssistProcessor {

    // Proposal part before cursor
    private final static String[] STRUCTTAGS1 = new String[] { "<P>", "<A SRC=\"", "<TABLE>", "<TR>", "<TD>" };

    // Proposal part after cursor
    private final static String[] STRUCTTAGS2 = new String[] { "", "\"></A>", "</TABLE>", "</TR>", "</TD>" };

    private final static String[] STYLETAGS = new String[] { "b", "i", "code", "strong" };
    private final static String[] STYLELABELS = new String[] { "bold", "italic", "code", "strong" };

    final List<ICompletionProposal> propList = new ArrayList<ICompletionProposal>();

    public ICompletionProposal[] computeCompletionProposals(final ITextViewer viewer, final int offset) {
        // Retrieve current document
        final IDocument doc = viewer.getDocument();
        // Retrieve current selection range
        final Point selectedRange = viewer.getSelectedRange();

        if (selectedRange.y > 0) {
            try {

                // Retrieve selected text
                final String text = doc.get(selectedRange.x, selectedRange.y);

                // Compute completion proposals
                computeStyleProposals(text, selectedRange, propList);

            } catch (final BadLocationException e) {

            }

        } else {

            // Retrieve qualifier
            final String qualifier = getQualifier(doc, offset);

            // Compute completion proposals
            computeStructureProposals(qualifier, offset, propList);
        }
        // Create completion proposal array
        final ICompletionProposal[] proposals = new ICompletionProposal[propList.size()];

        // and fill with list elements
        propList.toArray(proposals);

        // Return the proposals
        return proposals;
    }

    private String getQualifier(final IDocument doc, int documentOffset) {

        // Use string buffer to collect characters
        final StringBuffer buf = new StringBuffer();
        while (true) {
            try {

                // Read character backwards
                final char c = doc.getChar(--documentOffset);

                // This was not the start of a tag
                if (c == '>' || Character.isWhitespace(c)) {
                    return "";
                }

                // Collect character
                buf.append(c);

                // Start of tag. Return qualifier
                if (c == '<') {
                    return buf.reverse().toString();
                }

            } catch (final BadLocationException e) {

                // Document start reached, no tag found
                return "";
            }
        }
    }

    public IContextInformation[] computeContextInformation(final ITextViewer viewer, final int offset) {
        // Retrieve selected range
        final Point selectedRange = viewer.getSelectedRange();
        if (selectedRange.y > 0) {

            // Text is selected. Create a context information array.
            final ContextInformation[] contextInfos = new ContextInformation[STYLELABELS.length];

            // Create one context information item for each style
            for (int i = 0; i < STYLELABELS.length; i++) {
                contextInfos[i] = new ContextInformation(null, STYLELABELS[i] + " Style");
            }
            return contextInfos;
        }
        return new ContextInformation[0];
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

    private void computeStructureProposals(final String qualifier, final int documentOffset, final List propList) {
        final int qlen = qualifier.length();

        // Loop through all proposals
        for (int i = 0; i < STRUCTTAGS1.length; i++) {
            final String startTag = STRUCTTAGS1[i];

            // Check if proposal matches qualifier
            if (startTag.startsWith(qualifier)) {

                // Yes -- compute whole proposal text
                final String text = startTag + STRUCTTAGS2[i];

                // Derive cursor position
                final int cursor = startTag.length();

                // Construct proposal
                final CompletionProposal proposal = new CompletionProposal(text, documentOffset - qlen, qlen, cursor);

                // and add to result list
                propList.add(proposal);
            }
        }
    }

    private void computeStyleProposals(final String selectedText, final Point selectedRange, final List propList) {

        // Loop through all styles
        for (int i = 0; i < STYLETAGS.length; i++) {
            final String tag = STYLETAGS[i];

            // Compute replacement text
            final String replacement = "<" + tag + ">" + selectedText + "</" + tag + ">";

            // Derive cursor position
            final int cursor = tag.length() + 2;

            // Compute a suitable context information
            final IContextInformation contextInfo = new ContextInformation(null, STYLELABELS[i] + " Style");

            // Construct proposal
            final CompletionProposal proposal = new CompletionProposal(replacement, selectedRange.x, selectedRange.y, cursor, null,
                    STYLELABELS[i], contextInfo, replacement);

            // and add to result list
            propList.add(proposal);
        }
    }

}
