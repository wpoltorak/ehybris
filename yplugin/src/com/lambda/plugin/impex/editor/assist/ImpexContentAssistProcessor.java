package com.lambda.plugin.impex.editor.assist;

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
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.TypeNameMatch;
import org.eclipse.jdt.core.search.TypeNameMatchRequestor;
import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ContextInformationValidator;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension6;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.ui.texteditor.ITextEditor;

import com.lambda.impex.ast.ImpexLexer;
import com.lambda.plugin.YPlugin;
import com.lambda.plugin.impex.editor.ImpexDocument;
import com.lambda.plugin.impex.model.ILexerTokenRegion;

public class ImpexContentAssistProcessor implements IContentAssistProcessor {

    private final static String[] MODE_PROPOSALS = new String[] { "INSERT", "INSERT_UPDATE", "UPDATE", "REMOVE" };
    private final JavaElementLabelProvider javaElementLabelProvider = new JavaElementLabelProvider(
            JavaElementLabelProvider.SHOW_DEFAULT);
    private final ITextEditor editor;
    private IType type;
    private IJavaSearchScope scope;

    public ImpexContentAssistProcessor(ITextEditor editor) {
        this.editor = editor;
    }

    @Override
    public ICompletionProposal[] computeCompletionProposals(final ITextViewer viewer, final int offset) {
        long millis = System.currentTimeMillis();
        final ImpexDocument document = (ImpexDocument) viewer.getDocument();
        List<Integer> skipped = Arrays.asList(ImpexLexer.Separator, ImpexLexer.Ws, ImpexLexer.Comma, ImpexLexer.Dot,
                ImpexLexer.DoubleQuote);
        ActivationTokenInspector inspector = new ActivationTokenInspector(document.getTokens(), offset, skipped);
        // the beginning of the line - suggest mode
        if (inspector.getLastToken() == null) {
            return computeModeProposals(document, offset);
        }

        final List<ICompletionProposal> result = new ArrayList<ICompletionProposal>();
        switch (inspector.getLastToken().getTokenType()) {
        case ImpexLexer.Mode:
            // JavaTypeCompletionProposalComputer javaTypeCompletionProposalComputer = new
            // JavaTypeCompletionProposalComputer();
            // JavaContentAssistInvocationContext context = new JavaContentAssistInvocationContext(viewer, offset,
            // editor);
            // javaTypeCompletionProposalComputer.computeCompletionProposals(context, new NullProgressMonitor());
            final String qualifier = getQualifier(document, offset);
            final TypeNameMatchRequestor nameMatchRequestor = new TypeNameMatchRequestor() {
                @Override
                public void acceptTypeNameMatch(final TypeNameMatch match) {
                    if (!match.getSimpleTypeName().startsWith("Generated")) {
                        result.add(new TypeCompletionProposal(qualifier, match.getType(), offset));
                    }
                }
            };
            SearchEngine engine = new SearchEngine();
            try {
                // TODO performance of the popup is slow. should it be loaded in a background thread for the first time
                // during plugin startup?
                IJavaSearchScope scope = extensibleItemHierarchyScope();
                if (scope != null) {
                    engine.searchAllTypeNames("de.hybris.platform*.jalo*".toCharArray(), SearchPattern.R_PATTERN_MATCH,
                            qualifier.toCharArray(), SearchPattern.R_PREFIX_MATCH | SearchPattern.R_CAMELCASE_MATCH,
                            IJavaSearchConstants.CLASS, scope, nameMatchRequestor,
                            IJavaSearchConstants.WAIT_UNTIL_READY_TO_SEARCH, new NullProgressMonitor());
                }
            } catch (JavaModelException e) {
                YPlugin.logError(e);
            }
            final ICompletionProposal[] cproposals = result.toArray(new ICompletionProposal[result.size()]);
            System.err.println("took: " + (System.currentTimeMillis() - millis));
            return cproposals;
        }
        return new ICompletionProposal[0];
    }

    private IJavaSearchScope extensibleItemHierarchyScope() throws JavaModelException {
        if (scope == null) {
            String name = YPlugin.getDefault().getDefaultPlatform().getPlatformLocation().lastSegment().toString();
            IJavaProject project = JavaCore.create(ResourcesPlugin.getWorkspace().getRoot()).getJavaProject(name);
            IType type = project.findType("de.hybris.platform.jalo.ExtensibleItem");
            scope = SearchEngine.createHierarchyScope(type);
        }
        return scope;
    }

    @Override
    public IContextInformation[] computeContextInformation(final ITextViewer viewer, final int offset) {
        return null;
    }

    @Override
    public char[] getCompletionProposalAutoActivationCharacters() {
        return null;
    }

    @Override
    public char[] getContextInformationAutoActivationCharacters() {
        return null;
    }

    @Override
    public String getErrorMessage() {
        return null;
    }

    @Override
    public IContextInformationValidator getContextInformationValidator() {
        return new ContextInformationValidator(this);
    }

    private ICompletionProposal[] computeModeProposals(IDocument doc, final int offset) {
        final String qualifier = getQualifier(doc, offset);
        final List<ICompletionProposal> propList = new ArrayList<ICompletionProposal>();
        final int qlen = qualifier.length();
        for (int i = 0; i < MODE_PROPOSALS.length; i++) {
            final String proposal = MODE_PROPOSALS[i];
            if (proposal.startsWith(qualifier.toUpperCase())) {
                final int cursor = proposal.length();
                propList.add(new CompletionProposal(proposal, offset - qlen, qlen, cursor));
            }
        }
        final ICompletionProposal[] cproposals = propList.toArray(new ICompletionProposal[propList.size()]);
        return cproposals;
    }

    private String getQualifier(final IDocument doc, int documentOffset) {
        final StringBuffer buf = new StringBuffer();
        while (true) {
            try {
                // Read character backwards
                final char c = doc.getChar(--documentOffset);
                // Whitespace. Return qualifier
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

    private class TypeCompletionProposal implements ICompletionProposal, ICompletionProposalExtension6 {

        final String qualifier;
        final IType type;
        final int cursorPosition;
        final int replacementOffset;
        final StyledString display;

        public TypeCompletionProposal(String qualifier, IType type, int offset) {
            this.qualifier = qualifier;
            this.type = type;
            this.cursorPosition = offset;
            this.replacementOffset = offset - qualifier.length();
            this.display = initDisplay(type);

        }

        private StyledString initDisplay(IType type) {
            StyledString display = new StyledString();
            display.append(type.getElementName());
            display.append(" - "); //$NON-NLS-1$
            display.append(type.getPackageFragment().getElementName(), StyledString.QUALIFIER_STYLER);
            return display;
        }

        @Override
        public void apply(IDocument document) {
            try {
                // result.add(new CompletionProposal(name, offset - qlen, qlen, name.length()));
                // public CompletionProposal(String replacementString, int replacementOffset, int replacementLength, int
                // cursorPosition) {
                // document.replace(fReplacementOffset, fReplacementLength, fReplacementString);
                int qlen = qualifier.length();

                document.replace(replacementOffset, qlen, type.getElementName());
            } catch (BadLocationException x) {
                // ignore
            }
        }

        @Override
        public Point getSelection(IDocument document) {
            return new Point(replacementOffset + cursorPosition, 0);
        }

        @Override
        public String getAdditionalProposalInfo() {
            return null;
        }

        @Override
        public Image getImage() {
            return javaElementLabelProvider.getImage(type);
        }

        @Override
        public String getDisplayString() {
            return display.toString();
        }

        @Override
        public StyledString getStyledDisplayString() {
            return display;
        }

        @Override
        public IContextInformation getContextInformation() {
            return null;
        }
    }

    /**
     * Iterates to end of line in which token that contains <code>offset</code> is placed. Gathers information about
     * previous and next non-restricted tokens.
     * 
     * 
     */
    private class ActivationTokenInspector {
        private final Iterator<ILexerTokenRegion> delegate;
        private final int offset;
        private ILexerTokenRegion lastToken;
        private ILexerTokenRegion token;
        private ILexerTokenRegion nextToken;
        private final List<Integer> skipped;

        public ActivationTokenInspector(Iterable<ILexerTokenRegion> iterable, int offset, List<Integer> skipped) {
            this.offset = offset;
            this.skipped = skipped;
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

                // when new line char appears reset last token or break the loop
                if (candidate.getTokenType() == ImpexLexer.Lb) {
                    if (seekNext) {
                        break;
                    } else {
                        lastToken = null;
                        continue;
                    }
                }

                if (candidate.getOffset() <= offset && candidate.getOffset() + candidate.getLength() >= offset) {
                    token = candidate;
                    seekNext = true;
                } else {
                    if (!skipped.contains(candidate.getTokenType())) {
                        if (seekNext) {
                            nextToken = candidate;
                            break;
                        } else {
                            lastToken = candidate;
                        }
                    }
                }
            }
        }
    }
}
