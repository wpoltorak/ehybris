package com.lambda.plugin.wizards.ecommerce;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.layout.GridLayout;

public abstract class AbstractWizardPage extends WizardPage {

    protected AbstractWizardPage(String pageName) {
        super(pageName);
    }

    protected GridLayout initGridLayout(GridLayout layout, boolean margins) {
        layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);
        layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
        if (margins) {
            layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
            layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
        } else {
            layout.marginWidth = 0;
            layout.marginHeight = 0;
        }
        return layout;
    }

}
