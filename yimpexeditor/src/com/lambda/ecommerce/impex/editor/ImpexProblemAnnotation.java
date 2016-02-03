package com.lambda.ecommerce.impex.editor;

import org.eclipse.jface.text.source.Annotation;

import com.lambda.ecommerce.impex.model.IProblem;

/**
 * Annotation representing an <code>IProblem</code>.
 */
public class ImpexProblemAnnotation extends Annotation {

    public static final String ERROR_ANNOTATION_TYPE = "org.eclipse.ui.workbench.texteditor.error"; //$NON-NLS-1$
    public static final String WARNING_ANNOTATION_TYPE = "org.eclipse.ui.workbench.texteditor.warning"; //$NON-NLS-1$
    public static final String INFO_ANNOTATION_TYPE = "org.eclipse.ui.workbench.texteditor.info"; //$NON-NLS-1$

    private final IProblem fProblem;

    public ImpexProblemAnnotation(final IProblem problem) {

        fProblem = problem;

        if (fProblem.isError()) {
            setType(ERROR_ANNOTATION_TYPE);
        } else if (fProblem.isWarning()) {
            setType(WARNING_ANNOTATION_TYPE);
        } else {
            setType(INFO_ANNOTATION_TYPE);
        }

        setText(fProblem.getMessage());
    }
}
