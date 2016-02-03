package com.lambda.ecommerce.impex.editor.actions;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextOperationTarget;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.texteditor.ITextEditor;

import com.lambda.ecommerce.impex.YImpex;
import com.lambda.ecommerce.impex.YMessages;
import com.lambda.ecommerce.impex.editor.ImpexDocument;
import com.lambda.ecommerce.impex.editor.ImpexEditor;
import com.lambda.ecommerce.impex.model.ILexerTokenRegion;
import com.lambda.impex.ast.ImpexLexer;

public class ToggleLineCommentAction extends AbstractHandler {

    private ITextOperationTarget operationTarget;

    @Override
    public Object execute(final ExecutionEvent event) throws ExecutionException {
        final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
        if (activeEditor instanceof ImpexEditor) {
            final ImpexEditor impexEditor = (ImpexEditor) activeEditor;
            final ImpexDocument document = (ImpexDocument) impexEditor.getDocumentProvider().getDocument(
                    impexEditor.getEditorInput());
            if (document != null) {
                operationTarget = (ITextOperationTarget)activeEditor.getAdapter(ITextOperationTarget.class);
                if (operationTarget != null && operationTarget.canDoOperation(ITextOperationTarget.PREFIX)
                        && operationTarget.canDoOperation(ITextOperationTarget.STRIP_PREFIX)) {
                    toggleComment(impexEditor, document);
                }
            }
        }
        return null;
    }

    private void toggleComment(final ImpexEditor editor, final ImpexDocument document) {
        final ITextSelection textSelection = getCurrentSelection(editor);
        if (!textSelection.isEmpty()) {
            try {
                // toggle comments in a sepatrate thread
                new ToggleLinesRunnable(editor, document, textSelection).run(new NullProgressMonitor());
                // } catch (final InvocationTargetException | InterruptedException e) {
                // YPlugin.logError(e);
            } finally {
            }
        }
    }

    private static ITextSelection getCurrentSelection(final ITextEditor textEditor) {
        final ISelectionProvider provider = textEditor.getSelectionProvider();
        if (provider != null) {
            final ISelection selection = provider.getSelection();
            if (selection instanceof ITextSelection) {
                return (ITextSelection) selection;
            }
        }
        return TextSelection.emptySelection();
    }

    public static Display getDisplay() {
        Display display = Display.getCurrent();
        // may be null if outside the UI thread
        if (display == null) {
            display = Display.getDefault();
        }
        return display;
    }

    /**
     * <p>
     * The actual line toggling takes place in a runnable so it can be run as part of a progress dialog if there are
     * many lines to toggle and thus the operation will take a noticeable amount of time the user should be aware of,
     * this also allows for the operation to be canceled by the user
     * </p>
     * 
     */
    private static class ToggleLinesRunnable { // implements IRunnableWithProgress {
        private final List<Integer> skipped = Arrays.asList(ImpexLexer.Ws);

        /** the document that the lines will be toggled on */
        private final ImpexDocument document;

        /** the first line in the document to toggle */
        private final int selectionStartLine;

        /** the last line in the document to toggle */
        private final int selectionEndLine;

        /** the display, so that it can be updated during a long operation */
        @SuppressWarnings("unused")
        private final Display display;

        private final ImpexEditor editor;

        /**
         * @param editor
         * @param model {@link IStructuredModel} that the lines will be toggled on
         * @param document {@link IDocument} that the lines will be toggled on
         * @param selectionStartLine first line in the document to toggle
         * @param selectionEndLine last line in the document to toggle
         * @param display {@link Display}, so that it can be updated during a long operation
         */
        protected ToggleLinesRunnable(ImpexEditor editor, final ImpexDocument document,
                final ITextSelection textSelection) {
            this.editor = editor;
            this.document = document;
            this.selectionStartLine = textSelection.getStartLine();
            this.selectionEndLine = textSelection.getEndLine();
            this.display = getDisplay();
        }

        /**
         * @see org.eclipse.jface.operation.IRunnableWithProgress#run(org.eclipse.core.runtime.IProgressMonitor)
         */
        // @Override
        public void run(final IProgressMonitor monitor) {
            // start work
            monitor.beginTask(YMessages.ImpexToggleComment_progress, this.selectionEndLine - this.selectionStartLine);
            try {
                Iterable<? extends ILexerTokenRegion>[] lines = getLines(document);
                ITextOperationTarget textOperationTarget = (ITextOperationTarget)editor
                        .getAdapter(ITextOperationTarget.class);
                // gather information about positions of existing comments in each line
                LineInformation[] li = new LineInformation[selectionEndLine - selectionStartLine + 1];
                boolean doComment = checkExistingComments(lines, li);
                int operationCode = doComment ? ITextOperationTarget.PREFIX : ITextOperationTarget.STRIP_PREFIX;

                if (textOperationTarget != null) {
                    textOperationTarget.doOperation(operationCode);
                }
            } catch (final BadLocationException e) {
                YImpex.logError("Bad location while toggling comments.", e); //$NON-NLS-1$
            }
            // done work
            monitor.done();
        }

        private Iterable<? extends ILexerTokenRegion>[] getLines(final ImpexDocument document) throws BadLocationException {
            @SuppressWarnings("unchecked")
            Iterable<? extends ILexerTokenRegion>[] lines = new Iterable[selectionEndLine - selectionStartLine + 1];
            for (int i = selectionStartLine, j = 0; i <= selectionEndLine; i++, j++) {
                lines[j] = document.getLineTokens(i, false);
            }
            return lines;
        }

        private boolean checkExistingComments(Iterable<? extends ILexerTokenRegion>[] lines, LineInformation[] lineInformation)
                throws BadLocationException {
            boolean comment = false;
            for (int i = 0; i < lines.length; i++) {
                Iterator<? extends ILexerTokenRegion> lineTokens = lines[i].iterator();
                LineInformation li = new LineInformation();
                lineInformation[i] = li;
                comment |= checkExistingCommentInLine(skipped, li, i, lineTokens);
            }
            return comment;
        }

        private boolean checkExistingCommentInLine(List<Integer> skipped, LineInformation li, int line,
                Iterator<? extends ILexerTokenRegion> lineTokens) {
            while (lineTokens.hasNext()) {
                ILexerTokenRegion token = lineTokens.next();
                // store first token offset- this is the beginning of the line
                if (li.lineOffset == -1) {
                    li.lineOffset = token.getOffset();
                }

                if (!skipped.contains(token.getType())) {
                    if (ImpexLexer.Comment == token.getType()) {
                        // store comment offset if such exists
                        li.prefixOffset = token.getOffset();
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }
    }

    private static class LineInformation {
        int lineOffset = -1;
        int prefixOffset = -1;
    }
}
