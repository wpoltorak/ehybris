package com.lambda.impex.ast;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.List;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.apache.commons.io.FileUtils;

import com.lambda.impex.ast.ImpexANTLRStringStream;
import com.lambda.impex.ast.ImpexLexer;
import com.lambda.impex.ast.ImpexParser;

public class TreeModelTest {

    private ImpexParser parser;

    private void init(final String name) throws Exception {
        final File file = new File(getClass().getResource(name).getFile());
        final String impex = FileUtils.readFileToString(file);
        final ImpexLexer lexer = new ImpexLexer(new ImpexANTLRStringStream(impex));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        parser = new ImpexParser(tokens);
        parser.impex().getTree();
    }

    /**
     * Assert single entry list
     * 
     * @param list with single entry that represents new macro assignment in the document
     * @param line line number of macro assignment
     * @param value value assigned to macro
     */
    private void assertSingleEntry(final List<SimpleImmutableEntry<Integer, String>> list, final int line, final String value) {
        assertEquals(1, list.size());
        assertEntry(list.get(0), line, value);
    }

    /**
     * Assert entry list
     * 
     * @param list with entries that represents new macro assignments in the document
     * @param line line number of macro assignment
     * @param value value assigned to macro
     */
    private void assertEntries(final List<SimpleImmutableEntry<Integer, String>> list, final int[] lines, final String[] values) {
        assertEquals(lines.length, values.length);
        assertEquals(lines.length, list.size());
        for (int i = 0; i < lines.length; ++i) {
            assertEntry(list.get(i), lines[i], values[i]);
        }
    }

    /**
     * Assert entry
     * 
     * @param entry each entry represents new macro assignment in the document
     * @param line line number of macro assignment
     * @param value value assigned to macro
     */
    private void assertEntry(final SimpleImmutableEntry<Integer, String> entry, final int line, final String value) {
        assertEquals(line, entry.getKey().intValue());
        assertEquals(value, entry.getValue());
    }

    private CommonTree buildAST(final File file) throws Exception {
        final String impex = FileUtils.readFileToString(file);
        final ImpexLexer lexer = new ImpexLexer(new ImpexANTLRStringStream(impex));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final ImpexParser parser = new ImpexParser(tokens);
        return (CommonTree) parser.impex().getTree();
    }
}
