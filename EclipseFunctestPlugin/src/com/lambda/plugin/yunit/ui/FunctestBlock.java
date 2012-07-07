package com.lambda.plugin.yunit.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.ListenerList;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.debug.ui.IJavaDebugUIConstants;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.lambda.plugin.YPlugin;

public abstract class FunctestBlock {

	protected static IStatus OK_STATUS = new Status(IStatus.OK, YPlugin.PLUGIN_ID, 0, "", null); //$NON-NLS-1$
	private ListenerList fListeners = new ListenerList();
	private IStatus fStatus = OK_STATUS;

	private Control control;

	public Control getControl() {
		return control;
	}

	public void setControl(Control control) {
		this.control = control;
	}

	public void createControl(Composite comp) {
		this.control = comp;
	}

	protected void setError(String message) {
		setStatus(new Status(IStatus.ERROR, YPlugin.PLUGIN_ID, IJavaDebugUIConstants.INTERNAL_ERROR, message, null));
	}

	public IStatus getStatus() {
		return fStatus;
	}

	protected void firePropertyChange(String name, String value) {
		PropertyChangeEvent event = new PropertyChangeEvent(this, name, null, value);
		Object[] listeners = fListeners.getListeners();
		for (int i = 0; i < listeners.length; i++) {
			IPropertyChangeListener listener = (IPropertyChangeListener) listeners[i];
			listener.propertyChange(event);
		}
	}

	public void addPropertyChangeListener(IPropertyChangeListener listener) {
		fListeners.add(listener);
	}

	public void removePropertyChangeListener(IPropertyChangeListener listener) {
		fListeners.remove(listener);
	}

	protected void setStatus(IStatus status) {
		fStatus = status;
	}

	protected Shell getShell() {
		Control control = getControl();
		if (control != null) {
			return control.getShell();
		}
		return null;
	}

	public void dispose() {

	}
}
