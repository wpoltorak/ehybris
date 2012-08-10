package com.lambda.plugin.editors;

import org.eclipse.ui.editors.text.TextEditor;

public class ImpexEditor extends TextEditor {

	private ColorManager colorManager;

	public ImpexEditor() {
		super();
		colorManager = new ColorManager();
		setSourceViewerConfiguration(new XMLConfiguration(colorManager));
		setDocumentProvider(new XMLDocumentProvider());
	}
	public void dispose() {
		colorManager.dispose();
		super.dispose();
	}

}
