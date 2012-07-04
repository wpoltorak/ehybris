package com.kizoom.plugin.functest.view;

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

import com.kizoom.plugin.functest.FunctestMessages;

public class TestSessionLabelProvider extends LabelProvider implements IStyledLabelProvider {

	private final FunctestView fTestRunnerPart;
	private final int fLayoutMode;
	private final NumberFormat timeFormat;

	private boolean fShowTime;

	public TestSessionLabelProvider(FunctestView view, int layoutMode) {
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
		if (fLayoutMode == FunctestView.LAYOUT_HIERARCHICAL) {
			if (testElement.getParentContainer() instanceof ITestRunSession) {
				String testKindDisplayName = fTestRunnerPart.getTestKindDisplayName();
				if (testKindDisplayName != null) {
					String decorated = FunctestMessages.format(FunctestMessages.TestSessionLabelProvider_testName_JUnitVersion,
							new Object[] { label, testKindDisplayName });
					text = ColoringLabelProvider.styleDecoratedString(decorated, StyledString.QUALIFIER_STYLER, text);
				}
			}

		} else {
			if (element instanceof ITestCaseElement) {
				String className = BasicElementLabels.getJavaElementName(((ITestCaseElement) element).getTestClassName());
				String decorated = FunctestMessages.format(FunctestMessages.TestSessionLabelProvider_testMethodName_className,
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
		return FunctestMessages.format(FunctestMessages.TestSessionLabelProvider_testName_elapsedTimeInSeconds,
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
		if (fLayoutMode == FunctestView.LAYOUT_HIERARCHICAL) {
			if (testElement.getParentContainer() instanceof ITestRunSession) {
				String testKindDisplayName = fTestRunnerPart.getTestKindDisplayName();
				if (testKindDisplayName != null) {
					label = FunctestMessages.format(FunctestMessages.TestSessionLabelProvider_testName_JUnitVersion,
							new Object[] { label, testKindDisplayName });
				}
			}
		} else {
			if (element instanceof ITestCaseElement) {
				String className = BasicElementLabels.getJavaElementName(((ITestCaseElement) element).getTestClassName());
				label = FunctestMessages.format(FunctestMessages.TestSessionLabelProvider_testMethodName_className,
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
				return FunctestViewImages.fTestIgnoredIcon;

			Status status = testCaseElement.getStatus();
			if (status.isNotRun())
				return FunctestViewImages.fTestIcon;
			else if (status.isRunning())
				return FunctestViewImages.fTestRunningIcon;
			else if (status.isError())
				return FunctestViewImages.fTestErrorIcon;
			else if (status.isFailure())
				return FunctestViewImages.fTestFailIcon;
			else if (status.isOK())
				return FunctestViewImages.fTestOkIcon;
			else
				throw new IllegalStateException(element.toString());

		} else if (element instanceof TestSuiteElement) {
			Status status = ((TestSuiteElement) element).getStatus();
			if (status.isNotRun())
				return FunctestViewImages.fSuiteIcon;
			else if (status.isRunning())
				return FunctestViewImages.fSuiteRunningIcon;
			else if (status.isError())
				return FunctestViewImages.fSuiteErrorIcon;
			else if (status.isFailure())
				return FunctestViewImages.fSuiteFailIcon;
			else if (status.isOK())
				return FunctestViewImages.fSuiteOkIcon;
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