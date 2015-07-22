package com.lambda.plugin.ui;

import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;

public class SwtUtil {

    private SwtUtil() {
    }

    /**
     * Tests is the control is not <code>null</code> and not disposed.
     * 
     * @param control the Control
     * @return <code>true</code> if the control is not <code>null</code> and not disposed.
     */
    public static final boolean isOkToUse(Control control) {
        return (control != null) && (Display.getCurrent() != null) && !control.isDisposed();
    }
}
