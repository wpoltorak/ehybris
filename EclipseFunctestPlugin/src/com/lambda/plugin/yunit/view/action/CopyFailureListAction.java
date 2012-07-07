package com.lambda.plugin.yunit.view.action;

import org.eclipse.jdt.internal.junit.model.TestElement;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;

import com.lambda.plugin.YPlugin;
import com.lambda.plugin.yunit.FunctestMessages;
import com.lambda.plugin.yunit.view.FunctestView;

public class CopyFailureListAction extends Action {

    private final Clipboard fClipboard;
    private final FunctestView fRunner;

    public CopyFailureListAction(final FunctestView runner, final Clipboard clipboard) {
        super(FunctestMessages.CopyFailureList_action_label);
        fRunner = runner;
        fClipboard = clipboard;
    }

    /*
     * @see IAction#run()
     */
    @Override
    public void run() {
        final TextTransfer plainTextTransfer = TextTransfer.getInstance();

        try {
            fClipboard.setContents(new String[] { getAllFailureTraces() }, new Transfer[] { plainTextTransfer });
        } catch (final SWTError e) {
            if (e.code != DND.ERROR_CANNOT_SET_CLIPBOARD) {
                throw e;
            }
            if (MessageDialog.openQuestion(YPlugin.getActiveWorkbenchShell(), FunctestMessages.CopyFailureList_problem,
                    FunctestMessages.CopyFailureList_clipboard_busy)) {
                run();
            }
        }
    }

    public String getAllFailureTraces() {
        final StringBuffer buf = new StringBuffer();
        final TestElement[] failures = fRunner.getAllFailures();

        final String lineDelim = System.getProperty("line.separator", "\n"); //$NON-NLS-1$//$NON-NLS-2$
        for (int i = 0; i < failures.length; i++) {
            final TestElement failure = failures[i];
            buf.append(failure.getTestName()).append(lineDelim);
            final String failureTrace = failure.getTrace();
            if (failureTrace != null) {
                int start = 0;
                while (start < failureTrace.length()) {
                    final int idx = failureTrace.indexOf('\n', start);
                    if (idx != -1) {
                        final String line = failureTrace.substring(start, idx);
                        buf.append(line).append(lineDelim);
                        start = idx + 1;
                    } else {
                        start = Integer.MAX_VALUE;
                    }
                }
            }
        }
        return buf.toString();
    }

}