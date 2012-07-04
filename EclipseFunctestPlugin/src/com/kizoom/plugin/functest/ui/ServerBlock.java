package com.kizoom.plugin.functest.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import com.kizoom.plugin.functest.FunctestMessages;

public class ServerBlock extends FunctestBlock {

	public static final String PROPERTY_SERVER = "PROPERTY_SERVER"; //$NON-NLS-1$
	public static final String TYPE_LOCAL = "local";
	public static final String TYPE_TEST = "test";
	public static final String TYPE_PROD = "prod";
	private Button fDevRadioButton;
	private Button fTstRadioButton;
	private Button fPrdRadioButton;
	private Button fRmtRadioButton;
	private Text fServerTextField;

	@Override
	public void createControl(Composite comp) {
		super.createControl(comp);
		// fControl = createComposite(comp, 1, 1, GridData.FILL_BOTH);

		fDevRadioButton = new Button(comp, SWT.RADIO);
		fDevRadioButton.setText(FunctestMessages.FunctestLaunchConfigurationTab_label_development);
		GridData gd = new GridData();
		gd.horizontalSpan = 3;
		fDevRadioButton.setLayoutData(gd);
		fDevRadioButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (fDevRadioButton.getSelection()) {
					setStatus(OK_STATUS);
					firePropertyChange();
				}
			}
		});

		fTstRadioButton = new Button(comp, SWT.RADIO);
		fTstRadioButton.setText(FunctestMessages.FunctestLaunchConfigurationTab_label_staging);
		gd = new GridData();
		gd.horizontalSpan = 3;
		fTstRadioButton.setLayoutData(gd);
		fTstRadioButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (fTstRadioButton.getSelection()) {
					setStatus(OK_STATUS);
					firePropertyChange();
				}
			}
		});

		fPrdRadioButton = new Button(comp, SWT.RADIO);
		fPrdRadioButton.setText(FunctestMessages.FunctestLaunchConfigurationTab_label_production);
		gd = new GridData();
		gd.horizontalSpan = 3;
		fPrdRadioButton.setLayoutData(gd);
		fPrdRadioButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (fPrdRadioButton.getSelection()) {
					setStatus(OK_STATUS);
					firePropertyChange();
				}
			}
		});

		fRmtRadioButton = new Button(comp, SWT.RADIO);
		fRmtRadioButton.setText(FunctestMessages.FunctestLaunchConfigurationTab_label_remote);
		gd = new GridData();
		gd.horizontalSpan = 3;
		fRmtRadioButton.setLayoutData(gd);
		fRmtRadioButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				fServerTextField.setEnabled(fRmtRadioButton.getSelection());
				if (fRmtRadioButton.getSelection()) {
					setStatus(OK_STATUS);
					firePropertyChange();
				}
			}
		});

		fServerTextField = new Text(comp, SWT.SINGLE | SWT.BORDER);
		fServerTextField.setEnabled(false);
		fServerTextField.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent evt) {
				setStatus(OK_STATUS);
				if (fRmtRadioButton.getSelection()) {
					String serverName = fServerTextField.getText().trim();
					if (serverName.length() == 0) {
						setError(FunctestMessages.FunctestLaunchConfigurationTab_error_noRemoteServer);
					}
				}
				firePropertyChange();
			}

		});
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalIndent = 25;
		gd.horizontalSpan = 2;
		fServerTextField.setLayoutData(gd);

		setDefaultServerType();
	}

	private void firePropertyChange() {
		firePropertyChange(PROPERTY_SERVER, getServerType());

	}

	public String getServerType() {
		if (fDevRadioButton.getSelection())
			return TYPE_LOCAL;
		if (fTstRadioButton.getSelection())
			return TYPE_TEST;
		if (fPrdRadioButton.getSelection())
			return TYPE_PROD;

		return fServerTextField.getText().trim();
	}

	public void setDefaultServerType() {
		setDevelopmentServer();
	}

	public void setServerType(String server) {
		if (server == null) {
			setDefaultServerType();
			return;
		}

		if (TYPE_LOCAL.equals(server)) {
			setDevelopmentServer();
		} else if (TYPE_TEST.equals(server)) {
			setStagingServer();
		} else if (TYPE_PROD.equals(server)) {
			setProductionServer();
		} else {
			setRemoteServer(server);
		}
	}

	private void setDevelopmentServer() {
		fDevRadioButton.setSelection(true);
		fTstRadioButton.setSelection(false);
		fPrdRadioButton.setSelection(false);
		fRmtRadioButton.setSelection(false);
		fServerTextField.setEnabled(false);
	}

	private void setStagingServer() {
		fDevRadioButton.setSelection(false);
		fTstRadioButton.setSelection(true);
		fPrdRadioButton.setSelection(false);
		fRmtRadioButton.setSelection(false);
		fServerTextField.setEnabled(false);
	}

	private void setProductionServer() {
		fDevRadioButton.setSelection(false);
		fTstRadioButton.setSelection(false);
		fPrdRadioButton.setSelection(true);
		fRmtRadioButton.setSelection(false);
		fServerTextField.setEnabled(false);
	}

	private void setRemoteServer(String server) {
		fDevRadioButton.setSelection(false);
		fTstRadioButton.setSelection(false);
		fPrdRadioButton.setSelection(false);
		fRmtRadioButton.setSelection(true);
		fServerTextField.setEnabled(true);
		fServerTextField.setText(server);
	}
}
