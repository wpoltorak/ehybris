package com.kizoom.plugin.functest.view.action;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.ui.texteditor.ITextEditor;

import com.kizoom.plugin.functest.view.FunctestView;

public class OpenEditorAtLineAction extends OpenEditorAction {

	private int fLineNumber;

	public OpenEditorAtLineAction(FunctestView testRunner, String className, int line) {
		super(testRunner, className);
		fLineNumber = line;
	}

	@Override
	protected void reveal(ITextEditor textEditor) {
		if (fLineNumber >= 0) {
			try {
				IDocument document = textEditor.getDocumentProvider().getDocument(textEditor.getEditorInput());
				textEditor.selectAndReveal(document.getLineOffset(fLineNumber - 1), document.getLineLength(fLineNumber - 1));
			} catch (BadLocationException x) {
				// marker refers to invalid text position -> do nothing
			}
		}
	}

	@Override
	protected IJavaElement findElement(List<IJavaProject> projects, String className) throws CoreException {
		return findType(projects, className);
	}

}
