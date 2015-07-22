package com.lambda.plugin.ui;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.lambda.plugin.YCore;

public class YUIStatus extends Status {

    private YUIStatus(int severity, int code, String message, Throwable throwable) {
        super(severity, YCore.PLUGIN_ID, code, message, throwable);
    }

    public static IStatus createWarning(int code, String message, Throwable throwable) {
        return new YUIStatus(IStatus.WARNING, code, message, throwable);
    }

    public static IStatus createInfo(int code, String message, Throwable throwable) {
        return new YUIStatus(IStatus.INFO, code, message, throwable);
    }

    public static IStatus createError(int code, String message, Throwable throwable) {
        return new YUIStatus(IStatus.ERROR, code, message, throwable);
    }

    public static IStatus createError(int code, Throwable throwable) {
        String message = throwable.getMessage();
        if (message == null) {
            message = throwable.getClass().getName();
        }
        return new YUIStatus(IStatus.ERROR, code, message, throwable);
    }
}