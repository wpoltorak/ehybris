package com.lambda.plugin.impex.model;

import java.util.HashMap;
import java.util.Map;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.texteditor.MarkerUtilities;

import output.impexLexer;

import com.lambda.plugin.YPlugin;

public class ImpexModel implements IImpexModel {

    private final IDocument document;
    private final IFileEditorInput editorInput;

    public ImpexModel(final IDocument document, final IFileEditorInput editorInput) {
        this.document = document;
        this.editorInput = editorInput;
    }

    public void reconcile() {
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
    }

    private void removeMarkers() {
        try {
            editorInput.getFile().deleteMarkers(IMPEXFILE_PROBLEM_MARKER, true, 0);
        } catch (final CoreException e) {
            YPlugin.logError(e);
        }
    }

    private class ImpexLexer extends impexLexer {

        public ImpexLexer(final CharStream input) {
            super(input);
        }

        @Override
        public void reportError(final RecognitionException e) {
            final int lineNumber = getLine();
            final int columnNumber = getCharPositionInLine();

            final Map<String, Object> map = new HashMap<String, Object>();
            MarkerUtilities.setLineNumber(map, lineNumber);
            MarkerUtilities.setMessage(map, e.getMessage());

            MarkerUtilities.setMessage(map, e.getMessage());
            final IFile file = editorInput.getFile();
            //            map.put(IMarker.LOCATION, file.getFullPath().toString());

            final Integer charStart = getCharStart(lineNumber, columnNumber);
            if (charStart != null) {
                MarkerUtilities.setCharStart(map, charStart);
            }

            final Integer charEnd = getCharEnd(lineNumber, columnNumber);
            if (charEnd != null) {
                MarkerUtilities.setCharEnd(map, charEnd);
            }

            map.put(IMarker.SEVERITY, new Integer(IMarker.SEVERITY_ERROR));

            try {
                MarkerUtilities.createMarker(file, map, IMPEXFILE_PROBLEM_MARKER);
            } catch (final CoreException ee) {
                ee.printStackTrace();
            }
            super.reportError(e);
        }

        private int getCharEnd(final int lineNumber, final int columnNumber) {
            return columnNumber;
        }

        private int getCharStart(final int lineNumber, final int columnNumber) {
            return columnNumber;
        }
    }
}
