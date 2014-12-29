package com.lambda.plugin.impex.editor.occurrences;

import java.util.List;

import org.eclipse.jface.text.Position;

interface OccurrencesFinder {

    List<Position> findOccurrences();
}
