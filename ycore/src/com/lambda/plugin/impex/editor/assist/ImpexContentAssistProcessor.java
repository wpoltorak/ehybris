package com.lambda.plugin.impex.editor.assist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.SearchRequestor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ContextInformationValidator;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.text.contentassist.IContextInformationValidator;
import org.eclipse.ui.texteditor.ITextEditor;

import com.lambda.impex.ast.ImpexLexer;
import com.lambda.impex.ast.TypeDescription;
import com.lambda.plugin.YCore;
import com.lambda.plugin.impex.antlr.JavaTypeFinder;
import com.lambda.plugin.impex.editor.ImpexDocument;
import com.lambda.plugin.impex.model.ILexerTokenRegion;

public class ImpexContentAssistProcessor implements IContentAssistProcessor {

	private final static String[] MODE_PROPOSALS = new String[] { "INSERT", "INSERT_UPDATE", "UPDATE", "REMOVE" };
	private final ImpexCompletionProposalFactory completionProposalFactory = new ImpexCompletionProposalFactory();
	private final ITextEditor editor;
	private IType type;
	private final JavaTypeFinder typeFinder = new JavaTypeFinder();

	public ImpexContentAssistProcessor(ITextEditor editor) {
		this.editor = editor;
	}

	@Override
	public ICompletionProposal[] computeCompletionProposals(final ITextViewer viewer, final int offset) {
		long millis = System.currentTimeMillis();
		final ImpexDocument document = (ImpexDocument) viewer.getDocument();
		List<Integer> skipped = Arrays.asList(ImpexLexer.Ws, ImpexLexer.LineSeparator, ImpexLexer.Comma, ImpexLexer.Dot,
				ImpexLexer.DoubleQuote);
		final List<ICompletionProposal> result = new ArrayList<ICompletionProposal>();
		try {
			Iterable<ILexerTokenRegion> lineTokens = document.getLineTokensOfOffset(offset, true);
			ActivationTokenInspector inspector = new ActivationTokenInspector(lineTokens, offset, skipped);
			// the beginning of the line - suggest mode
			if (inspector.getLastToken() == null) {
				System.out.println("mode");
				return computeModeProposals(document, offset);
			}

			// header content assist
			if (inspector.getFirstToken().getTokenType() == ImpexLexer.Mode) {
				switch (inspector.getLastToken().getTokenType()) {
				case ImpexLexer.Mode:
				case ImpexLexer.Type: {
					final String qualifier = getQualifier(document, offset);
					final SearchRequestor requestor = new SearchRequestor() {
						@Override
						public void acceptSearchMatch(SearchMatch match) throws CoreException {
							result.add(completionProposalFactory.newTypeProposal(qualifier, offset,
									(IType) match.getElement()));
						}
					};
					// TODO performance of the popup is slow. should it be
					// loaded in a background thread for the first
					// time
					// during plugin startup?
					typeFinder.searchType(qualifier, SearchPattern.R_PREFIX_MATCH | SearchPattern.R_CAMELCASE_MATCH,
							requestor, JavaTypeFinder.MODEL_SEARCH | JavaTypeFinder.ENUM_SEARCH);
					break;
				}
				
					
				case ImpexLexer.Separator: {
					final String qualifier = getQualifier(document, offset);
					final String typename = "User";
					TypeDescription type = typeFinder.findBySimpleName(typename);

					// TODO open type with ctrl + click on type in impex editor
					// - show menu to choose Type or Generated
					// type. provide option to save choice as default action
					if (type == null) {
						break;
					}

					for (String field : type.getFields()) {
						if (field.startsWith(qualifier)) {
							result.add(completionProposalFactory.newAttributeProposal(qualifier, offset, field));
						}
					}
					break;
				}
				}
			}
		} catch (BadLocationException e) {
			YCore.logError(e);
		}

		final ICompletionProposal[] cproposals = result.toArray(new ICompletionProposal[result.size()]);
		System.err.println("took: " + (System.currentTimeMillis() - millis));
		return cproposals;

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
				if (Character.isWhitespace(c) || c == ';') {
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

	/**
	 * Iterates to end of line in which token that contains <code>offset</code>
	 * is placed. Gathers information about previous and next non-restricted
	 * tokens.
	 * 
	 * 
	 */
	private class ActivationTokenInspector {
		private final Iterator<ILexerTokenRegion> delegate;
		private final int offset;
		private ILexerTokenRegion previousToken;
		private ILexerTokenRegion token;
		private ILexerTokenRegion nextToken;
		private ILexerTokenRegion firstToken;
		private final List<Integer> skipped;

		public ActivationTokenInspector(Iterable<ILexerTokenRegion> iterable, int offset, List<Integer> skipped) {
			this.offset = offset;
			this.skipped = skipped;
			this.delegate = iterable.iterator();
			checkTokens();
		}

		public ILexerTokenRegion getLastToken() {
			return previousToken;
		}

		public ILexerTokenRegion getFirstToken() {
			return firstToken;
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
					if (!skipped.contains(candidate.getTokenType())) {
						if (candidate.getOffset() + candidate.getLength() == offset) {
							previousToken = candidate;
						} else {
							token = candidate;
						}
					}
					seekNext = true;
					if (firstToken == null) {
						firstToken = candidate;
					}
				} else {
					if (!skipped.contains(candidate.getTokenType())) {
						if (seekNext) {
							nextToken = candidate;
							break;
						} else {
							previousToken = candidate;
							if (firstToken == null) {
								firstToken = candidate;
							}
						}
					}
				}
			}
		}
	}
}
