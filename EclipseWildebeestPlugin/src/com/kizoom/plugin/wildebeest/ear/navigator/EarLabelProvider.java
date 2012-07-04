package com.kizoom.plugin.wildebeest.ear.navigator;

import org.eclipse.jdt.internal.ui.navigator.JavaNavigatorLabelProvider;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.swt.graphics.Image;

import com.kizoom.plugin.wildebeest.WildebeestPlugin;
import com.kizoom.plugin.wildebeest.ear.IEar;
import com.kizoom.plugin.wildebeest.image.WildebeestPluginImages;

//TODO KizoomPlugin: Implement decorated image providers for ear
//TODO kizoomPlugin: Discouraged access 
@SuppressWarnings("restriction")
public class EarLabelProvider extends JavaNavigatorLabelProvider {

	public EarLabelProvider() {
		super();
	}

	// @Override
	// public String getText(Object obj) {
	// return obj.toString();
	// }
	//
	// @Override
	// public Image getImage(Object obj) {
	// String imageKey = ISharedImages.IMG_OBJ_ELEMENT;
	// return PlatformUI.getWorkbench().getSharedImages().getImage(imageKey);
	// }

	@Override
	public String getDescription(Object element) {

		return super.getDescription(element);
	}

	@Override
	public StyledString getStyledText(Object element) {
		if (element instanceof IEar)
			return new StyledString(((IEar) element).getName());
		return super.getStyledText(element);
	}

	@Override
	public String getText(Object element) {
		if (element instanceof IEar)
			return ((IEar) element).getName();
		return super.getText(element);
	}

	@Override
	public Image getImage(Object element) {
		// TODO KizoomPlugin: Implement better way of image providing
		if (element instanceof IEar) {
////			IEar ear = (IEar) element;
			return WildebeestPlugin.getDefault().getImageDescriptorRegistry().get(WildebeestPluginImages.DESC_EAR_PRJ);
//
		}
		return super.getImage(element);
	}
}
