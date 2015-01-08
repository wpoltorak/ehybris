package com.lambda.plugin.yunit.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;

public class SWTFactory {

	public static Button createPushButton(Composite parent, String label, Image image) {
		return org.eclipse.debug.internal.ui.SWTFactory.createPushButton(parent, label, image);
	}

	public static Group createGroup(Composite parent, String text, int columns, int hspan, int fill) {
		return org.eclipse.debug.internal.ui.SWTFactory.createGroup(parent, text, columns, hspan, fill);
	}

	public static Composite createComposite(Composite parent, Font font, int columns, int hspan, int fill,
			int marginwidth, int marginheight) {
		return org.eclipse.debug.internal.ui.SWTFactory.createComposite(parent, font, columns, hspan, fill,
				marginwidth, marginheight);
	}

	public static void createSpacer(Composite comp) {
		Label label = new Label(comp, SWT.NONE);
		GridData gd = new GridData();
		gd.horizontalSpan = 3;
		label.setLayoutData(gd);
	}
}
