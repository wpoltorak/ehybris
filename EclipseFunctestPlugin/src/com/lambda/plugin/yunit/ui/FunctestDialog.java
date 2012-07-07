package com.lambda.plugin.yunit.ui;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public class FunctestDialog extends MessageDialog {

	public static final int DEVELOPMENT = 1;
	public static final int STAGING = 2;
	public static final int PRODUCTION = 4;

	private String serverType;
	private ServerBlock serverBlock;
	private IPropertyChangeListener fListener = new IPropertyChangeListener() {

		public void propertyChange(PropertyChangeEvent event) {
			serverType = serverBlock.getServerType();
		}

	};

	public FunctestDialog(Shell parentShell) {
		super(parentShell, "Run Functests", null, "Choose environment:", 0, new String[] { "Ok", "Cancel" }, 0);
	}

	@Override
	protected Control createCustomArea(Composite parent) {
		Composite control = new Composite(parent, SWT.NULL);
		control.setLayout(new GridLayout());
		GridData gd = new GridData(GridData.FILL_BOTH);
		control.setLayoutData(gd);

		serverBlock = new ServerBlock();
		serverBlock.addPropertyChangeListener(fListener);
		serverBlock.createControl(control);
		serverType = serverBlock.getServerType();
		return control;
	}

	public String getServer() {
		return serverType;
	}
}
