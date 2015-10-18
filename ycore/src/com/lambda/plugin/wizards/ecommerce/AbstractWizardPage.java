package com.lambda.plugin.wizards.ecommerce;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.ui.dialogs.WizardDataTransferPage;

public abstract class AbstractWizardPage extends WizardDataTransferPage {

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

	protected void saveInHistory(IDialogSettings settings, String key, String value) {
		String[] sourceNames = settings.getArray(key);
		if (sourceNames == null) {
			sourceNames = new String[0];
		}
		sourceNames = addToHistory(sourceNames, value);
		settings.put(key, sourceNames);
	}
	
	protected void restoreFromHistory(IDialogSettings settings, String key, Combo combo) {
		String[] sourceNames = settings.getArray(key);
		if (sourceNames == null) {
			return;
		}

		for (String sourceName : sourceNames) {
			combo.add(sourceName);
		}
	}


}
