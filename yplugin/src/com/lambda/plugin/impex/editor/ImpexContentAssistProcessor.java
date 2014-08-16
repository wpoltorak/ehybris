package com.lambda.plugin.impex.editor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.TypeNameMatch;
import org.eclipse.jdt.core.search.TypeNameMatchRequestor;
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
            final List<ICompletionProposal> result = new ArrayList<ICompletionProposal>();
            switch (inspector.getLastToken().getTokenType()) {
            // case ImpexLexer.Insert:
            // case ImpexLexer.InsertUpdate:
            // case ImpexLexer.Update:
            // case ImpexLexer.Remove:
            case ImpexLexer.Mode:
                final String qualifier = getQualifier(doc, offset);
                final int qlen = qualifier.length();
                final TypeNameMatchRequestor nameMatchRequestor = new TypeNameMatchRequestor() {
                    @Override
                    public void acceptTypeNameMatch(final TypeNameMatch match) {
                        String name = match.getType().getElementName();
                        result.add(new CompletionProposal(name, offset - qlen, qlen, name.length()));
                    }
                };
                SearchEngine engine = new SearchEngine();
                String name = YPlugin.getDefault().getDefaultPlatform().getPlatformLocation().lastSegment().toString();
                IJavaProject project = JavaCore.create(ResourcesPlugin.getWorkspace().getRoot()).getJavaProject(name);
                try {
                    IType type = project.findType("de.hybris.platform.jalo.GenericItem");
                    if (type != null) {
                        engine.searchAllTypeNames(null, SearchPattern.R_EXACT_MATCH, qualifier.toCharArray(),
                                SearchPattern.R_PREFIX_MATCH, IJavaSearchConstants.CLASS,
                                SearchEngine.createHierarchyScope(type), nameMatchRequestor,
                                IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH, new NullProgressMonitor());
                    }
                } catch (JavaModelException e) {
                    YPlugin.logError(e);
                }
                final ICompletionProposal[] cproposals = result.toArray(new ICompletionProposal[result.size()]);
                return cproposals;
            }
            return new ICompletionProposal[0];
            // new line - suggest mode
        } else {
            final String qualifier = getQualifier(doc, offset);
            return computeModeProposals(qualifier, MODE_PROPOSALS, offset);
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

    private ICompletionProposal[] computeModeProposals(final String qualifier, String[] proposals,
            final int documentOffset) {
        final List<ICompletionProposal> propList = new ArrayList<ICompletionProposal>();
        final int qlen = qualifier.length();
        for (int i = 0; i < proposals.length; i++) {
            final String proposal = proposals[i];

            if (proposal.startsWith(qualifier.toUpperCase())) {
                final int cursor = proposal.length();
                propList.add(new CompletionProposal(proposal, documentOffset - qlen, qlen, cursor));
            }
        }
        final ICompletionProposal[] cproposals = propList.toArray(new ICompletionProposal[propList.size()]);
        return cproposals;
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
            return token;
        }

        private void checkTokens() {
            boolean seekNext = false;
            while (delegate.hasNext()) {
                ILexerTokenRegion candidate = delegate.next();
                if (candidate.getOffset() <= offset && candidate.getOffset() + candidate.getLength() >= offset) {
                    token = candidate;
                    seekNext = true;
                } else {
                    if (isMeaningful(candidate)) {
                        if (seekNext) {
                            nextToken = candidate;
                            break;
                        } else {
                            lastToken = candidate;
                        }
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
            }
        }

        private boolean isMeaningful(ILexerTokenRegion candidate) {
            return !restrictedTypes.contains(candidate.getTokenType());
        }
    }
}
