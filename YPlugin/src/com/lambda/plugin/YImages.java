package com.lambda.plugin;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

public class YImages {

    public static final IPath ICONS_PATH = new Path("$nl$/icons/full");

    private static final String T_OBJ = "obj16"; //$NON-NLS-1$
    private static final String T_WIZBAN = "wizban"; //$NON-NLS-1$
    private static final String T_OVR = "ovr16"; //$NON-NLS-1$

    private static final String T_ECL = "ecl16"; //$NON-NLS-1$
    private static final String T_DCL = "dcl16"; //$NON-NLS-1$
    private static final String T_ETOOL = "etool16"; //$NON-NLS-1$
    private static final String T_EVIEW = "eview16"; //$NON-NLS-1$
    private static final String T_DEC = "dec8"; //$NON-NLS-1$

    // /////////// FUNCTEST ICONS ///////////////////////

    public static final String FUNCTEST_WIZARD_IMAGE = "newfunctestprj_wiz.png";
    public static final String FUNCTEST_PROJECT_IMAGE = "functestprj_obj.png";
    private static final String FUNCTEST_IMAGE = "functest.png";

    // IMPEX
    private static final String MARK_OCCURENCES = "mark_occurences.gif";

    public static final ImageDescriptor DESC_NEW_FUNCTEST_PRJ_WIZ = createImageDescriptor(T_WIZBAN,
            FUNCTEST_WIZARD_IMAGE);
    public static final ImageDescriptor DESC_FUNCTEST_PRJ = createImageDescriptor(T_OBJ, FUNCTEST_PROJECT_IMAGE);
    public static final ImageDescriptor DESC_FUNCTEST = createImageDescriptor(T_ETOOL, FUNCTEST_IMAGE);
    public static final ImageDescriptor DESC_MARK_OCCURRENCES = createImageDescriptor(T_ETOOL, MARK_OCCURENCES);

    public static ImageDescriptor createImageDescriptor(final String prefix, final String name) {
        final IPath path = ICONS_PATH.append(prefix).append(name);
        final Bundle bundle = YPlugin.getDefault().getBundle();
        final URL url = FileLocator.find(bundle, path, null);
        if (url != null) {
            return ImageDescriptor.createFromURL(url);
        }
        return ImageDescriptor.getMissingImageDescriptor();
    }

    public static Image createImage(final String prefix, final String name) {
        final IPath path = ICONS_PATH.append(prefix).append(name);
        final Bundle bundle = YPlugin.getDefault().getBundle();
        final URL url = FileLocator.find(bundle, path, null);
        if (url != null) {
            return ImageDescriptor.createFromURL(url).createImage();
        }
        return ImageDescriptor.getMissingImageDescriptor().createImage();
    }
}
