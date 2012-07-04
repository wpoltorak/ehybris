package com.kizoom.plugin.wildebeest.image;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;

import com.kizoom.plugin.wildebeest.WildebeestPlugin;

public class WildebeestPluginImages {

	public static final IPath ICONS_PATH = new Path("$nl$/icons/full");
	// private static final String NAME_PREFIX = "com.kizoom.plugin.ui.";
	// private static final int NAME_PREFIX_LENGTH = NAME_PREFIX.length();

	private static final String T_OBJ = "obj16"; //$NON-NLS-1$
	private static final String T_WIZBAN = "wizban"; //$NON-NLS-1$
	private static final String T_OVR = "ovr16"; //$NON-NLS-1$

	private static final String T_ELCL = "elcl16"; //$NON-NLS-1$
	private static final String T_DLCL = "dlcl16"; //$NON-NLS-1$
	private static final String T_ETOOL = "etool16"; //$NON-NLS-1$
	private static final String T_EVIEW = "eview16"; //$NON-NLS-1$
	private static final String T_DEC = "dec8"; //$NON-NLS-1$

	public static final String EAR_WIZARD_IMAGE = "newearprj_wiz.png";
	public static final String EAR_PROJECT_IMAGE = "earprj_obj.png";
	public static final String EAR_MEMBER_IMAGE_OVR = "ear_member.gif";
	public static final String EAR_IMAGE_DEC = "earprj_dec.png";
	private static final String EAR_IMPORT_WIZARD_IMAGE = "importear_wiz.png";
	private static final String IMPORT_EAR_IMAGE = "importear_obj.gif";

	public static final String WAPP_WIZARD_IMAGE = "newwapp_wiz.png";
	public static final String WAPP_PROJECT_IMAGE = "wapp_obj.png";
	public static final String WAPP_IMAGE_DEC = "wapp_dec.png";

	public static final ImageDescriptor DESC_NEW_EAR_WIZ = createImageDescriptor(T_WIZBAN, EAR_WIZARD_IMAGE);
	public static final ImageDescriptor DESC_IMPORT_EAR_WIZ = createImageDescriptor(T_WIZBAN, EAR_IMPORT_WIZARD_IMAGE);
	public static final ImageDescriptor DESC_EAR_PRJ = createImageDescriptor(T_OBJ, EAR_PROJECT_IMAGE);

	public static final ImageDescriptor DESC_IMPORT_EAR = createImageDescriptor(T_OBJ, IMPORT_EAR_IMAGE);
	public static final ImageDescriptor DESC_EAR_MEMBER_OVR = createImageDescriptor(T_OVR, EAR_MEMBER_IMAGE_OVR);
	public static final ImageDescriptor DESC_EAR_PRJ_DEC = createImageDescriptor(T_DEC, EAR_IMAGE_DEC);

	public static final ImageDescriptor DESC_NEW_WAPP_WIZ = createImageDescriptor(T_WIZBAN, WAPP_WIZARD_IMAGE);
	public static final ImageDescriptor DESC_WAPP_PRJ = createImageDescriptor(T_OBJ, WAPP_PROJECT_IMAGE);
	public static final ImageDescriptor DESC_WAPP_PRJ_DEC = createImageDescriptor(T_DEC, WAPP_IMAGE_DEC);

	public static ImageDescriptor createImageDescriptor(String prefix, String name) {
		IPath path = ICONS_PATH.append(prefix).append(name);
		Bundle bundle = WildebeestPlugin.getDefault().getBundle();
		URL url = FileLocator.find(bundle, path, null);
		if (url != null) {
			return ImageDescriptor.createFromURL(url);
		}
		return ImageDescriptor.getMissingImageDescriptor();
	}

	public static Image createImage(String prefix, String name) {
		IPath path = ICONS_PATH.append(prefix).append(name);
		Bundle bundle = WildebeestPlugin.getDefault().getBundle();
		URL url = FileLocator.find(bundle, path, null);
		if (url != null) {
			return ImageDescriptor.createFromURL(url).createImage();
		}
		return ImageDescriptor.getMissingImageDescriptor().createImage();
	}
}
