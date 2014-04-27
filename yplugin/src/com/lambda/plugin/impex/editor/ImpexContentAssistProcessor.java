package com.lambda.plugin.impex.editor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ContextInformationValidator;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;

import com.lambda.impex.ast.ImpexLexer;
import com.lambda.plugin.YPlugin;
import com.lambda.plugin.impex.model.ILexerTokenRegion;

public class ImpexContentAssistProcessor implements IContentAssistProcessor {

    // TODO translations
    private final static String[] MODE_PROPOSALS = new String[] { "INSERT", "INSERT_UPDATE", "UPDATE", "REMOVE" };

    @Override
    public ICompletionProposal[] computeCompletionProposals(final ITextViewer viewer, final int offset) {
        final ImpexDocument doc = (ImpexDocument) viewer.getDocument();
        List<Integer> restrictedTypes = Arrays.asList(ImpexLexer.Lb, ImpexLexer.Separator, ImpexLexer.Ws,
                ImpexLexer.Comma, ImpexLexer.Dot, ImpexLexer.DoubleQuote);
        SingleLineMeaningfulTokenInspector inspector = new SingleLineMeaningfulTokenInspector(doc.getTokens(), offset,
                restrictedTypes);
        if (inspector.getLastToken() != null) {
            switch (inspector.getLastToken().getTokenType()) {
            case ImpexLexer.Insert:
            case ImpexLexer.InsertUpdate:
            case ImpexLexer.Update:
            case ImpexLexer.Remove:
                SearchEngine engine = new SearchEngine();
                // de.hybris.platform.jalo.GenericItem;

                // SearchEngine.createHierarchyScope(new SourceType)
                // engine.search(pattern, participants, scope, requestor, monitor);
                // System.out.println();
                break;
            }
            return new ICompletionProposal[0];
            // new line - suggest mode
        } else {
            final String qualifier = getQualifier(doc, offset);
            return computeModeProposals(qualifier, offset);
        }
        // token.
    }

    private ILexerTokenRegion getToken(final int offset, final ImpexDocument doc) {
        try {
            return doc.getToken(offset);
        } catch (BadLocationException e) {
            YPlugin.logError(e);
        }
        return null;
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

    @Override
    public IContextInformation[] computeContextInformation(final ITextViewer viewer, final int offset) {
        return null;
    }

    @Override
    public char[] getCompletionProposalAutoActivationCharacters() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public char[] getContextInformationAutoActivationCharacters() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getErrorMessage() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IContextInformationValidator getContextInformationValidator() {
        return new ContextInformationValidator(this);
    }

    private ICompletionProposal[] computeModeProposals(final String qualifier, final int documentOffset) {
        final List<ICompletionProposal> propList = new ArrayList<ICompletionProposal>();
        final int qlen = qualifier.length();
        for (int i = 0; i < MODE_PROPOSALS.length; i++) {
            final String proposal = MODE_PROPOSALS[i];

            if (proposal.startsWith(qualifier.toUpperCase())) {
                final int cursor = proposal.length();
                propList.add(new CompletionProposal(proposal, documentOffset - qlen, qlen, cursor));
            }
        }
        final ICompletionProposal[] proposals = new ICompletionProposal[propList.size()];
        propList.toArray(proposals);
        return proposals;
    }

    /**
     * Iterates to end of line in which token that contains <code>offset</code> is placed. Gathers information about
     * previous and next non-restricted tokens.
     * 
     * 
     */
    private class SingleLineMeaningfulTokenInspector {
        private final Iterator<ILexerTokenRegion> delegate;
        private final int offset;
        private ILexerTokenRegion lastToken;
        private ILexerTokenRegion token;
        private ILexerTokenRegion nextToken;
        private final List<Integer> restrictedTypes;

        public SingleLineMeaningfulTokenInspector(Iterable<ILexerTokenRegion> iterable, int offset,
                List<Integer> restrictedTypes) {
            this.offset = offset;
            this.restrictedTypes = restrictedTypes;
            this.delegate = iterable.iterator();
            checkTokens();
        }

        public ILexerTokenRegion getLastToken() {
            return lastToken;
        }

        public ILexerTokenRegion getNextToken() {
            return nextToken;
        }

        public ILexerTokenRegion getToken() {
            return nextToken;
        }

        private void checkTokens() {
            boolean seekNext = false;
            while (delegate.hasNext()) {
                ILexerTokenRegion candidate = delegate.next();
                if (isMeaningful(candidate)) {
                    if (seekNext) {
                        nextToken = candidate;
                    } else {
                        lastToken = candidate;
                    }
                }
                // reset when new line char
                if (candidate.getTokenType() == ImpexLexer.Lb) {
                    if (seekNext) {
                        break;
                    } else {
                        lastToken = null;
                    }
                }

                if (candidate.getOffset() <= offset && candidate.getOffset() + candidate.getLength() >= offset) {
                    token = candidate;
                    seekNext = true;
                }
            }
        }

        private boolean isMeaningful(ILexerTokenRegion candidate) {
            return !restrictedTypes.contains(candidate.getTokenType());
        }
    }
}
