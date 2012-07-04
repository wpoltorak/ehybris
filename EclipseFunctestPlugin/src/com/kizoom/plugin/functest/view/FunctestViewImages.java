package com.kizoom.plugin.functest.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.internal.junit.ui.JUnitPlugin;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;

import com.kizoom.plugin.functest.image.FunctestPluginImages;

public class FunctestViewImages {

	private static List<Image> fImagesToDispose = new ArrayList<Image>();

	// TODO FunctestPlugin: Ikonki Junitowe
	public static final ImageDescriptor fSuiteIconDescriptor = JUnitPlugin.getImageDescriptor("obj16/tsuite.gif"); //$NON-NLS-1$
	public static final ImageDescriptor fSuiteOkIconDescriptor = JUnitPlugin.getImageDescriptor("obj16/tsuiteok.gif"); //$NON-NLS-1$
	public static final ImageDescriptor fSuiteErrorIconDescriptor = JUnitPlugin
			.getImageDescriptor("obj16/tsuiteerror.gif"); //$NON-NLS-1$
	public static final ImageDescriptor fSuiteFailIconDescriptor = JUnitPlugin.getImageDescriptor("obj16/tsuitefail.gif"); //$NON-NLS-1$
	public static final ImageDescriptor fSuiteRunningIconDescriptor = JUnitPlugin
			.getImageDescriptor("obj16/tsuiterun.gif"); //$NON-NLS-1$

	public static final Image fSuiteIcon = createManagedImage(fSuiteIconDescriptor);
	public static Image fSuiteOkIcon = createManagedImage(fSuiteOkIconDescriptor);
	public static Image fSuiteErrorIcon = createManagedImage(fSuiteErrorIconDescriptor);
	public static Image fSuiteFailIcon = createManagedImage(fSuiteFailIconDescriptor);
	public static Image fSuiteRunningIcon = createManagedImage(fSuiteRunningIconDescriptor);

	public static Image fTestIcon = createManagedImage("obj16/test.gif"); //$NON-NLS-1$
	public static Image fTestOkIcon = createManagedImage("obj16/testok.gif"); //$NON-NLS-1$
	public static Image fTestErrorIcon = createManagedImage("obj16/testerr.gif"); //$NON-NLS-1$
	public static Image fTestFailIcon = createManagedImage("obj16/testfail.gif"); //$NON-NLS-1$
	public static Image fTestRunningIcon = createManagedImage("obj16/testrun.gif"); //$NON-NLS-1$
	public static Image fTestIgnoredIcon = createManagedImage("obj16/testignored.gif"); //$NON-NLS-1$

	public static Image fStackViewIcon = createFManagedImage("eview16", "stackframe.gif");//$NON-NLS-1$
	public static Image fTestRunOKIcon = createFManagedImage("eview16", "ftestsucc.gif"); //$NON-NLS-1$
	public static Image fTestRunFailIcon = createFManagedImage("eview16", "ftesterr.gif"); //$NON-NLS-1$
	public static Image fTestRunOKDirtyIcon = createFManagedImage("eview16", "ftestsuccq.gif"); //$NON-NLS-1$
	public static Image fTestRunFailDirtyIcon = createFManagedImage("eview16", "ftesterrq.gif"); //$NON-NLS-1$

	private static Image createFManagedImage(String path, String name) {
		return createManagedImage(FunctestPluginImages.createImageDescriptor(path, name));
	}

	private static Image createManagedImage(String path) {
		return createManagedImage(JUnitPlugin.getImageDescriptor(path));
	}

	private static Image createManagedImage(ImageDescriptor descriptor) {
		Image image = descriptor.createImage();
		if (image == null) {
			image = ImageDescriptor.getMissingImageDescriptor().createImage();
		}
		fImagesToDispose.add(image);
		return image;
	}

	public static void dispose() {
		for (int i = 0; i < fImagesToDispose.size(); i++)
			fImagesToDispose.get(i).dispose();
	}

}
