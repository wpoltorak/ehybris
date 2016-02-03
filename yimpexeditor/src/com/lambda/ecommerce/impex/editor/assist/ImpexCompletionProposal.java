package com.lambda.ecommerce.impex.editor.assist;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposalExtension6;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;

import com.lambda.ecommerce.impex.YImpex;

public class ImpexCompletionProposal implements ICompletionProposal, ICompletionProposalExtension6 {

    private final String value;
    private final int cursorPosition;
    private final int replacementOffset;
    private final StyledString display;
    private final Image image;

    public ImpexCompletionProposal(String value, StyledString display, int replacementOffset, int offset, Image image) {
        this.value = value;
        this.display = display;
        this.cursorPosition = offset;
        this.replacementOffset = replacementOffset;
        this.image = image;
    }

    @Override
    public void apply(IDocument document) {
        try {
            document.replace(replacementOffset, cursorPosition - replacementOffset, value);
        } catch (BadLocationException e) {
            YImpex.logError(e);
        }
    }

    @Override
    public Point getSelection(IDocument document) {
        return new Point(replacementOffset + cursorPosition, 0);
    }

    @Override
    public String getAdditionalProposalInfo() {
        return null;
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public String getDisplayString() {
        return display.toString();
    }

    @Override
    public StyledString getStyledDisplayString() {
        return display;
    }

    @Override
    public IContextInformation getContextInformation() {
        return null;
    }

}
