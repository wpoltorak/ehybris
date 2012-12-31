package com.lambda.plugin.impex.editor.actions;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.texteditor.ITextEditor;

import com.lambda.plugin.YPlugin;
import com.lambda.plugin.impex.editor.ImpexEditor;

public class ToggleLineCommentAction extends AbstractHandler {

    public Object execute(final ExecutionEvent event) throws ExecutionException {
        final IEditorPart activeEditor = HandlerUtil.getActiveEditor(event);
        if (activeEditor instanceof ImpexEditor) {
            final ImpexEditor impexEditor = (ImpexEditor) activeEditor;
            final IDocument document = impexEditor.getDocumentProvider().getDocument(impexEditor.getEditorInput());
            if (document != null) {
                //            if (document != null && document instanceof IStructuredDocument) {
                // get current text selection
                final ITextSelection textSelection = getCurrentSelection(impexEditor);
                if (!textSelection.isEmpty()) {
                    try {
                        YPlugin.logError("Start line: " + textSelection.getStartLine(), null);
                        YPlugin.logError("End line: " + textSelection.getEndLine(), null);
                        YPlugin.logError("Offset: " + textSelection.getOffset(), null);
                        YPlugin.logError("End Line Offset: " + document.getLineOffset(textSelection.getEndLine()), null);
                        YPlugin.logError("Length: " + textSelection.getLength(), null);
                        YPlugin.logError("Text: " + textSelection.getText(), null);
                        //call the implementers code to deal with the event
                        //                    processAction(impexEditor, (IStructuredDocument) document, textSelection);
                    } catch (final BadLocationException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        return null;
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

    //    protected void processAction(final ITextEditor textEditor, final IStructuredDocument document, final ITextSelection textSelection) {
    //
    //        IStructuredModel model = null;
    //        DocumentRewriteSession session = null;
    //        boolean changed = false;
    //
    //        try {
    //            // get text selection lines info
    //            final int selectionStartLine = textSelection.getStartLine();
    //            int selectionEndLine = textSelection.getEndLine();
    //
    //            final int selectionEndLineOffset = document.getLineOffset(selectionEndLine);
    //            final int selectionEndOffset = textSelection.getOffset() + textSelection.getLength();
    //
    //            // adjust selection end line
    //            if ((selectionEndLine > selectionStartLine) && (selectionEndLineOffset == selectionEndOffset)) {
    //                selectionEndLine--;
    //            }
    //
    //            // save the selection position since it will be changing
    //            final Position selectionPosition = new Position(textSelection.getOffset(), textSelection.getLength());
    //            document.addPosition(selectionPosition);
    //
    //            model = StructuredModelManager.getModelManager().getModelForEdit(document);
    //            if (model != null) {
    //                //makes it so one undo will undo all the edits to the document
    //                model.beginRecording(this, SSEUIMessages.ToggleComment_label, SSEUIMessages.ToggleComment_description);
    //
    //                //keeps listeners from doing anything until updates are all done
    //                model.aboutToChangeModel();
    //                if (document instanceof IDocumentExtension4) {
    //                    session = ((IDocumentExtension4) document).startRewriteSession(DocumentRewriteSessionType.UNRESTRICTED);
    //                }
    //                changed = true;
    //
    //                //get the display for the editor if we can
    //                Display display = null;
    //                if (textEditor instanceof StructuredTextEditor) {
    //                    final StructuredTextViewer viewer = ((StructuredTextEditor) textEditor).getTextViewer();
    //                    if (viewer != null) {
    //                        display = viewer.getControl().getDisplay();
    //                    }
    //                }
    //
    //                //create the toggling operation
    //                final IRunnableWithProgress toggleCommentsRunnable = new ToggleLinesRunnable(model.getContentTypeIdentifier(), document,
    //                        selectionStartLine, selectionEndLine, display);
    //
    //                //if toggling lots of lines then use progress monitor else just run the operation
    //                if ((selectionEndLine - selectionStartLine) > TOGGLE_LINES_MAX_NO_BUSY_INDICATOR && display != null) {
    //                    final ProgressMonitorDialog dialog = new ProgressMonitorDialog(display.getActiveShell());
    //                    dialog.run(false, true, toggleCommentsRunnable);
    //                } else {
    //                    toggleCommentsRunnable.run(new NullProgressMonitor());
    //                }
    //            }
    //        } catch (final InvocationTargetException e) {
    //            YPlugin.logError("Problem running toggle comment progess dialog.", e); //$NON-NLS-1$
    //        } catch (final InterruptedException e) {
    //            YPlugin.logError("Problem running toggle comment progess dialog.", e); //$NON-NLS-1$
    //        } catch (final BadLocationException e) {
    //            YPlugin.logError("The given selection " + textSelection + " must be invalid", e); //$NON-NLS-1$ //$NON-NLS-2$
    //        } finally {
    //            //clean everything up
    //            if (session != null && document instanceof IDocumentExtension4) {
    //                ((IDocumentExtension4) document).stopRewriteSession(session);
    //            }
    //
    //            if (model != null) {
    //                model.endRecording(this);
    //                if (changed) {
    //                    model.changedModel();
    //                }
    //                model.releaseFromEdit();
    //            }
    //        }
    //    }
    //
    //    /**
    //     * <p>
    //     * The actual line toggling takes place in a runnable so it can be run as part of a progress dialog if there are many lines to toggle
    //     * and thus the operation will take a noticeable amount of time the user should be aware of, this also allows for the operation to be
    //     * canceled by the user
    //     * </p>
    //     * 
    //     */
    //    private static class ToggleLinesRunnable implements IRunnableWithProgress {
    //        /** the content type for the document being commented */
    //        private final String fContentType;
    //
    //        /** the document that the lines will be toggled on */
    //        private final IStructuredDocument fDocument;
    //
    //        /** the first line in the document to toggle */
    //        private final int fSelectionStartLine;
    //
    //        /** the last line in the document to toggle */
    //        private final int fSelectionEndLine;
    //
    //        /** the display, so that it can be updated during a long operation */
    //        private final Display fDisplay;
    //
    //        /**
    //         * @param model {@link IStructuredModel} that the lines will be toggled on
    //         * @param document {@link IDocument} that the lines will be toggled on
    //         * @param selectionStartLine first line in the document to toggle
    //         * @param selectionEndLine last line in the document to toggle
    //         * @param display {@link Display}, so that it can be updated during a long operation
    //         */
    //        protected ToggleLinesRunnable(final String contentTypeIdentifier, final IStructuredDocument document, final int selectionStartLine,
    //                final int selectionEndLine, final Display display) {
    //
    //            this.fContentType = contentTypeIdentifier;
    //            this.fDocument = document;
    //            this.fSelectionStartLine = selectionStartLine;
    //            this.fSelectionEndLine = selectionEndLine;
    //            this.fDisplay = display;
    //        }
    //
    //        /**
    //         * @see org.eclipse.jface.operation.IRunnableWithProgress#run(org.eclipse.core.runtime.IProgressMonitor)
    //         */
    //        public void run(final IProgressMonitor monitor) {
    //            //start work
    //            monitor.beginTask(SSEUIMessages.ToggleComment_progress, this.fSelectionEndLine - this.fSelectionStartLine);
    //            try {
    //                //toggle each line so long as task not canceled
    //                for (int line = this.fSelectionStartLine; line <= this.fSelectionEndLine && !monitor.isCanceled(); ++line) {
    //
    //                    //allows the user to be able to click the cancel button
    //                    readAndDispatch(this.fDisplay);
    //
    //                    //get the line region
    //                    final IRegion lineRegion = this.fDocument.getLineInformation(line);
    //
    //                    //don't toggle empty lines
    //                    final String content = this.fDocument.get(lineRegion.getOffset(), lineRegion.getLength());
    //                    if (content.trim().length() > 0) {
    //                        //try to get a line comment type
    //                        final ITypedRegion[] lineTypedRegions = this.fDocument.computePartitioning(lineRegion.getOffset(),
    //                                lineRegion.getLength());
    //                        CommentingStrategy commentType = CommentingStrategyRegistry.getDefault().getLineCommentingStrategy(
    //                                this.fContentType, lineTypedRegions);
    //
    //                        //could not find line comment type so find block comment type to use on line
    //                        if (commentType == null) {
    //                            commentType = CommentingStrategyRegistry.getDefault().getBlockCommentingStrategy(this.fContentType,
    //                                    lineTypedRegions);
    //                        }
    //
    //                        //toggle the comment on the line
    //                        if (commentType != null) {
    //                            if (commentType.alreadyCommenting(this.fDocument, lineTypedRegions)) {
    //                                commentType.remove(this.fDocument, lineRegion.getOffset(), lineRegion.getLength(), true);
    //                            } else {
    //                                commentType.apply(this.fDocument, lineRegion.getOffset(), lineRegion.getLength());
    //                            }
    //                        }
    //                    }
    //                    monitor.worked(1);
    //                }
    //            } catch (final BadLocationException e) {
    //                YPlugin.logError("Bad location while toggling comments.", e); //$NON-NLS-1$
    //            }
    //            //done work
    //            monitor.done();
    //        }
    //
    //        private void readAndDispatch(final Display display) {
    //            try {
    //                display.readAndDispatch();
    //            } catch (final Exception e) {
    //                YPlugin.logWarning("Exception caused by readAndDispatch, not caused by or fatal to caller", e);
    //            } catch (final LinkageError e) {
    //                YPlugin.logWarning("LinkageError caused by readAndDispatch, not caused by or fatal to caller", e);
    //            } catch (final VirtualMachineError e) {
    //                // re-throw these
    //                throw e;
    //            } catch (final ThreadDeath e) {
    //                // re-throw these
    //                throw e;
    //            } catch (final Error e) {
    //                // catch every error, except for a few that we don't want to handle
    //                YPlugin.logWarning("Error caused by readAndDispatch, not caused by or fatal to caller", e);
    //            }
    //        }
    //    }
}
