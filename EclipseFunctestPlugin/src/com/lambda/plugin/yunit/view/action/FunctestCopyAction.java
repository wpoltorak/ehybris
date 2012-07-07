package com.lambda.plugin.yunit.view.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jdt.internal.junit.model.TestElement;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWTError;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.ui.actions.SelectionListenerAction;

import com.lambda.plugin.yunit.FunctestMessages;
import com.lambda.plugin.yunit.view.FailureTrace;

public class FunctestCopyAction extends SelectionListenerAction {

	private FailureTrace fView;

	private final Clipboard fClipboard;

	private TestElement fTestElement;

	/**
	 * Constructor for CopyTraceAction.
	 * 
	 * @param view
	 * @param clipboard
	 */
	public FunctestCopyAction(FailureTrace view, Clipboard clipboard) {
		super(FunctestMessages.CopyTrace_action_label);
		Assert.isNotNull(clipboard);
		fView = view;
		fClipboard = clipboard;
	}

	/*
	 * @see IAction#run()
	 */
	@Override
	public void run() {
		String trace = fView.getTrace();
		String source = null;
		if (trace != null) {
			source = convertLineTerminators(trace);
		} else if (fTestElement != null) {
			source = fTestElement.getTestName();
		}
		if (source == null || source.length() == 0)
			return;

		TextTransfer plainTextTransfer = TextTransfer.getInstance();
		try {
			fClipboard.setContents(new String[] { convertLineTerminators(source) }, new Transfer[] { plainTextTransfer });
		} catch (SWTError e) {
			if (e.code != DND.ERROR_CANNOT_SET_CLIPBOARD)
				throw e;
			if (MessageDialog.openQuestion(fView.getComposite().getShell(), FunctestMessages.CopyTraceAction_problem,
					FunctestMessages.CopyTraceAction_clipboard_busy))
				run();
		}
	}

	public void handleTestSelected(TestElement test) {
		fTestElement = test;
	}

	private String convertLineTerminators(String in) {
		StringWriter stringWriter = new StringWriter();
		PrintWriter printWriter = new PrintWriter(stringWriter);
		StringReader stringReader = new StringReader(in);
		BufferedReader bufferedReader = new BufferedReader(stringReader);
		String line;
		try {
			while ((line = bufferedReader.readLine()) != null) {
				printWriter.println(line);
			}
		} catch (IOException e) {
			return in; // return the trace unfiltered
		}
		return stringWriter.toString();
	}
}
