package com.lambda.plugin;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

public class YImages {

    public interface Icons {
        // ImpEx Editor actions
        public static final String TOGGLE_MARK_OCCURENCES = "mark_occurences.gif";
    }

    public static final IPath ICONS_PATH = new Path("$nl$/icons");

    private static final String T_OBJ = "obj16"; //$NON-NLS-1$
    private static final String T_WIZBAN = "wizban"; //$NON-NLS-1$
    private static final String T_OVR = "ovr16"; //$NON-NLS-1$

    private static final String T_ECL = "elcl16"; //$NON-NLS-1$
    private static final String T_DCL = "dlcl16"; //$NON-NLS-1$
    private static final String T_ETOOL = "etool16"; //$NON-NLS-1$
    private static final String T_EVIEW = "eview16"; //$NON-NLS-1$
    private static final String T_DEC = "dec8"; //$NON-NLS-1$

    public static final String Y_IMAGE = "y_dec.png";

    // /////////// FUNCTEST ICONS ///////////////////////

    public static final String FUNCTEST_WIZARD_IMAGE = "newfunctestprj_wiz.png";
    public static final String FUNCTEST_PROJECT_IMAGE = "functestprj_obj.png";
    private static final String FUNCTEST_IMAGE = "functest.png";

    public static final ImageDescriptor DESC_YPROJECT_DEC = createImageDescriptor(T_DEC, Y_IMAGE);

    public static final ImageDescriptor DESC_NEW_FUNCTEST_PRJ_WIZ = createImageDescriptor(T_WIZBAN,
            FUNCTEST_WIZARD_IMAGE);
    public static final ImageDescriptor DESC_FUNCTEST_PRJ = createImageDescriptor(T_OBJ, FUNCTEST_PROJECT_IMAGE);
    public static final ImageDescriptor DESC_FUNCTEST = createImageDescriptor(T_ETOOL, FUNCTEST_IMAGE);

    /**
     * Sets the three image descriptors for enabled, disabled, and hovered to an action. The actions are retrieved from
     * the *lcl16 folders.
     * 
     * @param action the action
     * @param iconName the icon name
     */
    public static void setLocalImageDescriptors(final IAction action, final String iconName) {
        setImageDescriptors(action, "lcl16", iconName); //$NON-NLS-1$
    }

    private static void setImageDescriptors(final IAction action, final String type, final String relPath) {
        final ImageDescriptor id = createImageDescriptor("d" + type, relPath, false); //$NON-NLS-1$
        if (id != null) {
            action.setDisabledImageDescriptor(id);
        }
        final ImageDescriptor descriptor = createImageDescriptor("e" + type, relPath, true); //$NON-NLS-1$
        action.setHoverImageDescriptor(descriptor);
        action.setImageDescriptor(descriptor);
    }

    public static ImageDescriptor createImageDescriptor(final String prefix, final String name) {
        return createImageDescriptor(prefix, name, true);
    }

    public static ImageDescriptor createImageDescriptor(final String prefix, final String name, final boolean useMissing) {
        final IPath path = ICONS_PATH.append(prefix).append(name);
        final Bundle bundle = YCore.getDefault().getBundle();
        final URL url = FileLocator.find(bundle, path, null);
        if (url != null) {
            return ImageDescriptor.createFromURL(url);
        }
        return useMissing ? ImageDescriptor.getMissingImageDescriptor() : null;
    }

    public static Image createImage(final String prefix, final String name) {
        final IPath path = ICONS_PATH.append(prefix).append(name);
        final Bundle bundle = YCore.getDefault().getBundle();
        final URL url = FileLocator.find(bundle, path, null);
        if (url != null) {
            return ImageDescriptor.createFromURL(url).createImage();
        }
        return ImageDescriptor.getMissingImageDescriptor().createImage();
    }
}
