package com.lambda.plugin.impex.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.ICodeAssist;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.corext.util.CollectionsUtil;
import org.eclipse.jdt.ui.actions.SelectionDispatchAction;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.hyperlink.AbstractHyperlinkDetector;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;

import com.lambda.plugin.impex.editor.ImpexDocument;
import com.lambda.plugin.impex.editor.ImpexEditor;

public class JavaElementHyperlinkDetector extends AbstractHyperlinkDetector {

    /* cache for the last result from codeSelect(..) */
    private static ITypeRoot fLastInput;
    private static long fLastModStamp;
    private static IRegion fLastWordRegion;
    private static IJavaElement[] fLastElements;

    @Override
    public IHyperlink[] detectHyperlinks(ITextViewer textViewer, IRegion region, boolean canShowMultipleHyperlinks) {
        ITextEditor textEditor = (ITextEditor) getAdapter(ITextEditor.class);
        if (region == null || !(textEditor instanceof ImpexEditor))
            return null;

        IAction openAction = textEditor.getAction("OpenEditor"); //$NON-NLS-1$
        if (!(openAction instanceof SelectionDispatchAction))
            return null;

        int offset = region.getOffset();

        try {
            IDocumentProvider documentProvider = textEditor.getDocumentProvider();
            IEditorInput editorInput = textEditor.getEditorInput();
            ImpexDocument document = (ImpexDocument) documentProvider.getDocument(editorInput);
            IRegion wordRegion = document.getToken(offset);
            if (wordRegion == null || wordRegion.getLength() == 0)
                return null;

            IJavaElement[] elements;
            long modStamp = documentProvider.getModificationStamp(editorInput);
            if (editorInput.equals(fLastInput) && modStamp == fLastModStamp && wordRegion.equals(fLastWordRegion)) {
                elements = fLastElements;
            } else {
                elements = document.getModel().get((ICodeAssist) input)
                        .codeSelect(wordRegion.getOffset(), wordRegion.getLength());
                elements = selectOpenableElements(elements);
                fLastInput = input;
                fLastModStamp = modStamp;
                fLastWordRegion = wordRegion;
                fLastElements = elements;
            }
            if (elements.length == 0)
                return null;

            ArrayList<IHyperlink> links = new ArrayList<IHyperlink>(elements.length);
            for (int i = 0; i < elements.length; i++) {
                addHyperlinks(links, wordRegion, (SelectionDispatchAction) openAction, elements[i]);
            }
            if (links.size() == 0)
                return null;

            return CollectionsUtil.toArray(links, IHyperlink.class);

        } catch (JavaModelException | BadLocationException e) {
            return null;
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        fLastElements = null;
        fLastInput = null;
        fLastWordRegion = null;
    }

    protected void addHyperlinks(List<IHyperlink> hyperlinksCollector, IRegion wordRegion,
            SelectionDispatchAction openAction, IJavaElement element) {
        hyperlinksCollector.add(new JavaElementHyperlink(wordRegion, openAction, element));
    }

    private IJavaElement[] selectOpenableElements(IJavaElement[] elements) {
        List<IJavaElement> result = new ArrayList<IJavaElement>(elements.length);
        for (int i = 0; i < elements.length; i++) {
            IJavaElement element = elements[i];
            switch (element.getElementType()) {
            case IJavaElement.PACKAGE_DECLARATION:
            case IJavaElement.PACKAGE_FRAGMENT:
            case IJavaElement.PACKAGE_FRAGMENT_ROOT:
            case IJavaElement.JAVA_PROJECT:
            case IJavaElement.JAVA_MODEL:
                break;
            default:
                result.add(element);
                break;
            }
        }
        return result.toArray(new IJavaElement[result.size()]);
    }
}
