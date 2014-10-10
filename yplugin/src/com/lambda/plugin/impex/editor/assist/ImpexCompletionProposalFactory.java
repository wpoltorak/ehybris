package com.lambda.plugin.impex.editor.assist;

import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;

public class ImpexCompletionProposalFactory {

    private JavaElementLabelProvider javaElementLabelProvider;

    private JavaElementLabelProvider getJavaElementLabelProvider() {
        if (javaElementLabelProvider == null) {
            javaElementLabelProvider = new JavaElementLabelProvider(JavaElementLabelProvider.SHOW_DEFAULT);
        }
        return javaElementLabelProvider;
    }

    public ICompletionProposal newTypeProposal(String qualifier, int offset, IType elem) {
        Image image = getJavaElementLabelProvider().getImage(elem);
        StyledString display = display(elem);
        int replacementOffset = offset - qualifier.length();
        return new ImpexCompletionProposal(elem.getElementName(), display, offset, replacementOffset, image);
    }

    public ICompletionProposal newAttributeProposal(String qualifier, int offset, IField elem) {
        Image image = null;
        StyledString display = display(elem);
        int replacementOffset = offset - qualifier.length();
        return new ImpexCompletionProposal(elem.getElementName(), display, offset, replacementOffset, image);
    }

    private StyledString display(IField field) {
        StyledString display = new StyledString();
        display.append(field.getElementName());
        return display;
    }

    private StyledString display(IType type) {
        StyledString display = new StyledString();
        display.append(type.getElementName());
        display.append(" - "); //$NON-NLS-1$
        display.append(type.getPackageFragment().getElementName(), StyledString.QUALIFIER_STYLER);
        return display;
    }

}
