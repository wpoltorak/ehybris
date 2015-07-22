package com.lambda.plugin.ui;

import org.eclipse.core.resources.IProject;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ILightweightLabelDecorator;

import com.lambda.plugin.YImages;
import com.lambda.plugin.YCore;
import com.lambda.plugin.core.IPlatformInstallation;

public class ProjectLabelDecorator implements ILightweightLabelDecorator {

    @Override
    public void addListener(ILabelProviderListener listener) {

    }

    @Override
    public void dispose() {
    }

    @Override
    public boolean isLabelProperty(Object element, String property) {
        return false;
    }

    @Override
    public void removeListener(ILabelProviderListener listener) {
    }

    @Override
    public void decorate(Object element, IDecoration decoration) {
        IProject project = (IProject) element;
        decoration.addOverlay(YImages.DESC_YPROJECT_DEC, IDecoration.TOP_RIGHT);
        IPlatformInstallation platform = YCore.getDefault().getDefaultPlatform();
        // TODO get rid of constatnt
        if (platform != null && project.getName().equals("platform")) {
            decoration.addSuffix(" - " + platform.getVendor() + " " + platform.getVersion());
        }
    }
}
