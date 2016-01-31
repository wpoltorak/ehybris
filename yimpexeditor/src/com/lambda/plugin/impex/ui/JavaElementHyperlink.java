package com.lambda.plugin.impex.ui;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.ui.actions.OpenAction;
import org.eclipse.jdt.ui.actions.SelectionDispatchAction;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.TextSelection;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.jface.viewers.StructuredSelection;

import com.lambda.plugin.impex.YMessages;

public class JavaElementHyperlink implements IHyperlink {

    private final IRegion fRegion;
    private final SelectionDispatchAction fOpenAction;
    private final IJavaElement fElement;

    /**
     * Creates a new Java element hyperlink.
     * 
     * @param region the region of the link
     * @param openAction the action to use to open the java elements
     * @param element the java element to open or <code>null</code> if {@link OpenAction} should be invoked at the given
     *            region
     * @param qualify <code>true</code> if the hyperlink text should show a qualified name for element
     */
    public JavaElementHyperlink(IRegion region, SelectionDispatchAction openAction, IJavaElement element) {
        Assert.isNotNull(openAction);
        Assert.isNotNull(region);

        fRegion = region;
        fOpenAction = openAction;
        fElement = element;
    }

    @Override
    public IRegion getHyperlinkRegion() {
        return fRegion;
    }

    @Override
    public void open() {
        if (fElement != null)
            fOpenAction.run(new StructuredSelection(fElement));
        else
            fOpenAction.run(new TextSelection(fRegion.getOffset(), fRegion.getLength()));
    }

    @Override
    public String getTypeLabel() {
        return null;
    }

    @Override
    public String getHyperlinkText() {
        return YMessages.ImpexTypeHyperlink_hyperlinkText;
    }
}