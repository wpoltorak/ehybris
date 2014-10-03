package com.lambda.plugin.impex.model;

import java.util.List;

import com.lambda.impex.ast.ImpexProblem;

public interface IImpexModel {

    void updateMarkers(List<ImpexProblem> problems);
}
