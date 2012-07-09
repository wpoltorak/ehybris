package com.lambda.plugin.yunit.view;

import java.text.NumberFormat;

import org.eclipse.jdt.internal.junit.BasicElementLabels;
import org.eclipse.jdt.internal.junit.model.TestCaseElement;
import org.eclipse.jdt.internal.junit.model.TestSuiteElement;
import org.eclipse.jdt.internal.junit.model.TestElement.Status;
import org.eclipse.jdt.internal.ui.viewsupport.ColoringLabelProvider;
import org.eclipse.jdt.junit.model.ITestCaseElement;
import org.eclipse.jdt.junit.model.ITestElement;
import org.eclipse.jdt.junit.model.ITestRunSession;
import org.eclipse.jdt.junit.model.ITestSuiteElement;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.LabelProviderChangedEvent;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider.IStyledLabelProvider;
import org.eclipse.swt.graphics.Image;

import com.lambda.plugin.yunit.YUnitMessages;

public class TestSessionLabelProvider extends LabelProvider implements IStyledLabelProvider {

	private final YUnitView fTestRunnerPart;
	private final int fLayoutMode;
	private final NumberFormat timeFormat;

	private boolean fShowTime;

	public TestSessionLabelProvider(YUnitView view, int layoutMode) {
		fTestRunnerPart = view;
		fLayoutMode = layoutMode;
		fShowTime = true;

		timeFormat = NumberFormat.getNumberInstance();
		timeFormat.setGroupingUsed(true);
		timeFormat.setMinimumFractionDigits(3);
		timeFormat.setMaximumFractionDigits(3);
		timeFormat.setMinimumIntegerDigits(1);
	}

	public StyledString getStyledText(Object element) {
		String label = getSimpleLabel(element);
		if (label == null) {
			return new StyledString(element.toString());
		}
		StyledString text = new StyledString(label);

		ITestElement testElement = (ITestElement) element;
		if (fLayoutMode == YUnitView.LAYOUT_HIERARCHICAL) {
			if (testElement.getParentContainer() instanceof ITestRunSession) {
				String testKindDisplayName = fTestRunnerPart.getTestKindDisplayName();
				if (testKindDisplayName != null) {
					String decorated = YUnitMessages.format(YUnitMessages.TestSessionLabelProvider_testName_JUnitVersion,
							new Object[] { label, testKindDisplayName });
					text = ColoringLabelProvider.styleDecoratedString(decorated, StyledString.QUALIFIER_STYLER, text);
				}
			}

		} else {
			if (element instanceof ITestCaseElement) {
				String className = BasicElementLabels.getJavaElementName(((ITestCaseElement) element).getTestClassName());
				String decorated = YUnitMessages.format(YUnitMessages.TestSessionLabelProvider_testMethodName_className,
						new Object[] { label, className });
				text = ColoringLabelProvider.styleDecoratedString(decorated, StyledString.QUALIFIER_STYLER, text);
			}
		}
		return addElapsedTime(text, testElement.getElapsedTimeInSeconds());
	}

	private StyledString addElapsedTime(StyledString styledString, double time) {
		String string = styledString.getString();
		String decorated = addElapsedTime(string, time);
		return ColoringLabelProvider.styleDecoratedString(decorated, StyledString.COUNTER_STYLER, styledString);
	}

	private String addElapsedTime(String string, double time) {
		if (!fShowTime || Double.isNaN(time)) {
			return string;
		}
		String formattedTime = timeFormat.format(time);
		return YUnitMessages.format(YUnitMessages.TestSessionLabelProvider_testName_elapsedTimeInSeconds,
				new String[] { string, formattedTime });
	}

	private String getSimpleLabel(Object element) {
		if (element instanceof ITestCaseElement) {
			return BasicElementLabels.getJavaElementName(((ITestCaseElement) element).getTestMethodName());
		} else if (element instanceof ITestSuiteElement) {
			return BasicElementLabels.getJavaElementName(((ITestSuiteElement) element).getSuiteTypeName());
		}
		return null;
	}

	@Override
	public String getText(Object element) {
		String label = getSimpleLabel(element);
		if (label == null) {
			return element.toString();
		}
		ITestElement testElement = (ITestElement) element;
		if (fLayoutMode == YUnitView.LAYOUT_HIERARCHICAL) {
			if (testElement.getParentContainer() instanceof ITestRunSession) {
				String testKindDisplayName = fTestRunnerPart.getTestKindDisplayName();
				if (testKindDisplayName != null) {
					label = YUnitMessages.format(YUnitMessages.TestSessionLabelProvider_testName_JUnitVersion,
							new Object[] { label, testKindDisplayName });
				}
			}
		} else {
			if (element instanceof ITestCaseElement) {
				String className = BasicElementLabels.getJavaElementName(((ITestCaseElement) element).getTestClassName());
				label = YUnitMessages.format(YUnitMessages.TestSessionLabelProvider_testMethodName_className,
						new Object[] { label, className });
			}
		}
		return addElapsedTime(label, testElement.getElapsedTimeInSeconds());
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof TestCaseElement) {
			TestCaseElement testCaseElement = ((TestCaseElement) element);
			if (testCaseElement.isIgnored())
				return YUnitViewImages.fTestIgnoredIcon;

			Status status = testCaseElement.getStatus();
			if (status.isNotRun())
				return YUnitViewImages.fTestIcon;
			else if (status.isRunning())
				return YUnitViewImages.fTestRunningIcon;
			else if (status.isError())
				return YUnitViewImages.fTestErrorIcon;
			else if (status.isFailure())
				return YUnitViewImages.fTestFailIcon;
			else if (status.isOK())
				return YUnitViewImages.fTestOkIcon;
			else
				throw new IllegalStateException(element.toString());

		} else if (element instanceof TestSuiteElement) {
			Status status = ((TestSuiteElement) element).getStatus();
			if (status.isNotRun())
				return YUnitViewImages.fSuiteIcon;
			else if (status.isRunning())
				return YUnitViewImages.fSuiteRunningIcon;
			else if (status.isError())
				return YUnitViewImages.fSuiteErrorIcon;
			else if (status.isFailure())
				return YUnitViewImages.fSuiteFailIcon;
			else if (status.isOK())
				return YUnitViewImages.fSuiteOkIcon;
			else
				throw new IllegalStateException(element.toString());

		} else {
			throw new IllegalArgumentException(String.valueOf(element));
		}
	}

	public void setShowTime(boolean showTime) {
		fShowTime = showTime;
		fireLabelProviderChanged(new LabelProviderChangedEvent(this));
	}

}