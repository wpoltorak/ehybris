package com.kizoom.plugin;

import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

/**
 * Copy of {@link org.eclipse.jdt.internal.ui.ExceptionHandler}
 * 
 */
public class ExceptionHandler {

	private static ExceptionHandler fgInstance = new ExceptionHandler();

	public static void log(Throwable t, String message) {
		KizoomPlugin.logError(message, t);
	}

	public static void handle(CoreException e, String title, String message) {
		handle(e, KizoomPlugin.getActiveWorkbenchShell(), title, message);
	}

	public static void handle(CoreException e, Shell parent, String title, String message) {
		fgInstance.perform(e, parent, title, message);
	}

	public static void handle(Exception e, Shell parent, String title, String message) {
		fgInstance.perform(e, parent, title, message);
	}

	public static void handle(InvocationTargetException e, String title, String message) {
		handle(e, KizoomPlugin.getActiveWorkbenchShell(), title, message);
	}

	public static void handle(InvocationTargetException e, Shell parent, String title, String message) {
		fgInstance.perform(e, parent, title, message);
	}

	protected void perform(CoreException e, Shell shell, String title, String message) {
		KizoomPlugin.logError(e);
		IStatus status = e.getStatus();
		if (status != null) {
			ErrorDialog.openError(shell, title, message, status);
		} else {
			displayMessageDialog(e.getMessage(), shell, title, message);
		}
	}
	
	protected void perform(Exception e, Shell shell, String title, String message) {
		KizoomPlugin.logError(e);
		displayMessageDialog(e.getMessage(), shell, title, message);
	}

	protected void perform(InvocationTargetException e, Shell shell, String title, String message) {
		Throwable target = e.getTargetException();
		if (target instanceof CoreException) {
			perform((CoreException) target, shell, title, message);
		} else {
			KizoomPlugin.logError(e);
			if (e.getMessage() != null && e.getMessage().length() > 0) {
				displayMessageDialog(e.getMessage(), shell, title, message);
			} else {
				displayMessageDialog(target.getMessage(), shell, title, message);
			}
		}
	}

	private void displayMessageDialog(String exceptionMessage, Shell shell, String title, String message) {
		StringWriter msg = new StringWriter();
		if (message != null) {
			msg.write(message);
			msg.write("\n\n"); //$NON-NLS-1$
		}
		if (exceptionMessage == null || exceptionMessage.length() == 0)
			msg.write("See error log for more details.");
		else
			msg.write(exceptionMessage);
		MessageDialog.openError(shell, title, msg.toString());
	}

}
