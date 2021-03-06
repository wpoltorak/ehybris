package com.lambda.plugin.impex.ui;

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.ui.actions.OpenAction;
import org.eclipse.jdt.ui.actions.SelectionDispatchAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.hyperlink.AbstractHyperlinkDetector;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;

import com.lambda.impex.ast.ImpexModel;
import com.lambda.plugin.YPlugin;
import com.lambda.plugin.impex.editor.ImpexDocument;
import com.lambda.plugin.impex.editor.ImpexEditor;
import com.lambda.plugin.impex.model.ILexerTokenRegion;

public class JavaElementHyperlinkDetector extends AbstractHyperlinkDetector {

    /* cache for the last result from codeSelect(..) */
    private static ImpexModel lastModel;
    private static long lastModStamp;
    private static IRegion lastWordRegion;
    private static IJavaElement lastElement;

    @Override
    public IHyperlink[] detectHyperlinks(ITextViewer textViewer, IRegion region, boolean canShowMultipleHyperlinks) {
        ImpexEditor textEditor = (ImpexEditor) getAdapter(ImpexEditor.class);
        if (region == null) {
            return null;
        }

        IAction openAction = new OpenAction(YPlugin.getActivePart().getSite());
        if (!(openAction instanceof SelectionDispatchAction))
            return null;

        int offset = region.getOffset();

        try {
            IDocumentProvider documentProvider = textEditor.getDocumentProvider();
            IEditorInput editorInput = textEditor.getEditorInput();
            ImpexDocument document = (ImpexDocument) documentProvider.getDocument(editorInput);
            ILexerTokenRegion token = document.getToken(offset);
            if (token == null || token.getLength() == 0) {
                return null;
            }
            IJavaElement element;
            ImpexModel model = document.getModel();
            long modStamp = documentProvider.getModificationStamp(editorInput);
            if (model.equals(lastModel) && modStamp == lastModStamp && token.equals(lastWordRegion)) {
                element = lastElement;
            } else {
                element = element(model, token);
                lastModel = model;
                lastModStamp = modStamp;
                lastWordRegion = token;
                lastElement = element;
            }
            if (element == null) {
                return null;
            }

            return new IHyperlink[] { new JavaElementHyperlink(token, (SelectionDispatchAction) openAction, element) };

        } catch (BadLocationException e) {
            return null;
        }
    }

    private IJavaElement element(ImpexModel model, ILexerTokenRegion token) {
        Object hyperlinkElement = model.getHyperlinkElement(token.getTokenType(), token.getOffset());
        if (hyperlinkElement instanceof IType) {
            return (IType) hyperlinkElement;
        }
        return null;
    }

    @Override
    public void dispose() {
        super.dispose();
        lastElement = null;
        lastModel = null;
        lastWordRegion = null;
    }
}
