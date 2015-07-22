package com.lambda.plugin.impex.editor.occurrences;

import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;
import org.eclipse.jface.text.Position;

interface OccurrencesFinder {

    List<Position> findOccurrences(ParseTree parseTree);
}
