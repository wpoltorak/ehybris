package com.lambda.plugin.impex.model;

import com.lambda.plugin.YPlugin;

public interface IImpexModel {
    public static final String IMPEXFILE_PROBLEM_MARKER = YPlugin.PLUGIN_ID + ".impexFileProblem"; //$NON-NLS-1$

    public void reconcile();
}
