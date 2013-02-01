package com.lambda.plugin.impex.model;

import java.util.List;

import com.lambda.impex.ast.ImpexProblem;
import com.lambda.plugin.YPlugin;

public interface IImpexModel {
    String IMPEXFILE_PROBLEM_MARKER = YPlugin.PLUGIN_ID + ".impexFileProblem"; //$NON-NLS-1$

    void updateMarkers(List<ImpexProblem> problems);
}
