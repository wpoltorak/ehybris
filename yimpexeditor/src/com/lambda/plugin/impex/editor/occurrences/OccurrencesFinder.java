package com.lambda.plugin.impex.editor.occurrences;

import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;
import org.eclipse.jface.text.Position;

interface OccurrencesFinder {

    String OCCURRENCES_ANNOTATION = "org.eclipse.jdt.ui.occurrences";
    String OCCURRENCES_WRITE_ANNOTATION = "org.eclipse.jdt.ui.occurrences.write";

    List<Position> findOccurrences(ParseTree parseTree);

    String getAnnotationId();

    String getWriteAnnotationId();
}
