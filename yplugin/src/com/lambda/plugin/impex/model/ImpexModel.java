package com.lambda.plugin.impex.model;

import java.util.HashMap;
import java.util.Map;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.BitSet;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.texteditor.MarkerUtilities;

import com.lambda.plugin.YPlugin;

public class ImpexModel implements IImpexModel {

    private final IDocument document;
    private final IFileEditorInput editorInput;

    public ImpexModel(final IDocument document, final IFileEditorInput editorInput) {
        this.document = document;
        this.editorInput = editorInput;
    }

    public void reconcile() {
        final long start = System.currentTimeMillis();
        try {
            System.out.println("===> RECONCILE " + editorInput.getName() + "##################################");
            removeMarkers();
            final String source = document.get();
            // create an instance of the lexer
            final ImpexLexer lexer = new ImpexLexer(new ANTLRStringStream(source));
            // wrap a token-stream around the lexer
            final CommonTokenStream tokens = new CommonTokenStream(lexer);

            tokens.fill();
            // traverse the tokens and print them to see if the correct tokens are created
            System.out.println("Tokenizing " + (lexer.failed() ? "failed" : "succeeded"));
            System.out.println("Tokens:");
            int n = 1;
            for (final Object o : tokens.getTokens()) {
                final CommonToken token = (CommonToken) o;
                System.out.println("token(" + n++ + ") = " + token.getText().replace("\n", "\\n"));
            }
            lexer.createMarkers();
        } finally {
            System.out.println("===> TOOK " + (System.currentTimeMillis() - start) / 1000);

        }
    }

    private void removeMarkers() {
        try {
            editorInput.getFile().deleteMarkers(IMPEXFILE_PROBLEM_MARKER, true, 0);
        } catch (final CoreException e) {
            YPlugin.logError(e);
        }
    }

    private class ImpexLexer extends output.ImpexLexer {

        private final Map<Integer, Map<String, Object>> markerAttributes = new HashMap<Integer, Map<String, Object>>();

        public ImpexLexer(final CharStream input) {
            super(input);
        }

        public void createMarkers() {
            final IWorkspaceRunnable wr = new IWorkspaceRunnable() {
                public void run(final IProgressMonitor monitor) throws CoreException {
                    for (final Map<String, Object> attributes : markerAttributes.values()) {
                        final IFile file = editorInput.getFile();
                        final IMarker marker = file.createMarker(IMPEXFILE_PROBLEM_MARKER);
                        marker.setAttributes(attributes);
                    }
                }
            };
            try {
                wr.run(new NullProgressMonitor());
            } catch (final CoreException e) {
                YPlugin.logError(e);
            }
        }

        @Override
        public void recover(final IntStream input, final RecognitionException re) {
            // TODO Auto-generated method stub
            super.recover(input, re);
        }

        @Override
        public void recover(final RecognitionException re) {
            // TODO Auto-generated method stub
            super.recover(re);
        }

        @Override
        public Object recoverFromMismatchedSet(final IntStream input, final RecognitionException e, final BitSet follow)
                throws RecognitionException {
            // TODO Auto-generated method stub
            return super.recoverFromMismatchedSet(input, e, follow);
        }

        @Override
        protected Object recoverFromMismatchedToken(final IntStream arg0, final int arg1, final BitSet arg2) throws RecognitionException {
            // TODO Auto-generated method stub
            return super.recoverFromMismatchedToken(arg0, arg1, arg2);
        }

        @Override
        public void reportError(final RecognitionException e) {
            final int lineNumber = getLine();
            Map<String, Object> map = markerAttributes.get(lineNumber);
            final int charIndex = getCharIndex();
            if (map == null) {
                map = new HashMap<String, Object>();
                MarkerUtilities.setLineNumber(map, lineNumber);
                MarkerUtilities.setMessage(map, "Syntax error");
                MarkerUtilities.setCharStart(map, charIndex);
                MarkerUtilities.setCharEnd(map, charIndex + 1);
                map.put(IMarker.SEVERITY, new Integer(IMarker.SEVERITY_ERROR));
                markerAttributes.put(lineNumber, map);
            } else {
                MarkerUtilities.setCharEnd(map, charIndex + 1);
            }
            super.reportError(e);
        }

        private IProblem createProblem(final Exception exception, final int offset, final int length, final int lineNumber,
                final int severity) {
            return createProblem(exception.getMessage(), offset, length, lineNumber, severity);
        }

        private IProblem createProblem(final String message, final int offset, final int length, final int lineNumber, final int severity) {
            return new ImpexModelProblem(message, severity, offset, length, lineNumber);
        }

    }
}
