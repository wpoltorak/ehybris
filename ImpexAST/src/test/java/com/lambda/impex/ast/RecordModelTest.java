package com.lambda.impex.ast;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

public class RecordModelTest extends ModelTest {

    @Test
    public void fieldsWithSeparators() throws Exception {
        final ParseTree tree = init("/record/record-line-separator-between-fields.impex");
        assertFields(fields(tree, 0, 0), "ahertz", "Anja Hertz", "K2006-C0005", "");
        assertFields(fields(tree, 1, 0), "ahertz\\", "\\ Anja Hertz", "\\", "");
        assertFields(fields(tree, 2, 0), "ahertz\\", "\\   Anja Hertz", "\\", "");
        assertFields(fields(tree, 3, 0), "\\\\", "\\ \\", "\\", "");
    }

    @Test
    public void quotedFieldWithSeparator() throws Exception {
        final ParseTree tree = init("/record/record-line-separator-inside-quoted-field.impex");
        assertFields(fields(tree, 0, 0), "testgroup", "\"test\\   \ngroup\"", "");
    }

    @Test
    public void unquotedFieldWithSeparator() throws Exception {
        final ParseTree tree = init("/record/record-line-separator-inside-unquoted-field.impex");
        assertFields(fields(tree, 0, 0), "testgroup", "test group", "");
        assertFields(fields(tree, 1, 0), "testgroup", "test group", "");
        assertFields(fields(tree, 2, 0), "testgroup", "test\tgroup", "");
        assertFields(fields(tree, 3, 0), "testgroup", "test\t\t  group", "");
        assertFields(fields(tree, 4, 0), "testgroup", "testgroup", "");
    }

    @Test
    public void ignoredField() throws Exception {
        final ParseTree tree = init("/record/record-ignored-field.impex");
        assertFields(fields(tree, 0, 0), "ahertz", "<ignore>", "K2006-C0005", "");
    }

    @Test
    public void emptyField() throws Exception {
        final ParseTree tree = init("/record/record-empty-field.impex");
        assertFields(fields(tree, 0, 0), "ahertz", "", "K2006-C0005", "");
    }

    @Test
    public void blankField() throws Exception {
        final ParseTree tree = init("/record/record-blank-field.impex");
        assertFields(fields(tree, 0, 0), "ahertz", "", "K2006-C0005", "");
    }

    @Test
    public void fieldWithMacro() throws Exception {
        final ParseTree tree = init("/record/record-field-with-macro.impex");
        assertFields(fields(tree, 0, 0), "ahertz", "Ann $surname", "K2006-C0005", "");
    }

    @Test
    public void multipleRecords() throws Exception {
        final ParseTree tree = init("/record/record-multiple.impex");
        final List<ParseTree> records = records(tree, 0);
        assertEquals(3, records.size());

        assertFields(fields(records.get(0)), "ahertz", "Anja Hertz", "K2006-C0005", "");
        assertFields(fields(records.get(1)), "jsmith", "John Smith", "L4506-D2005", "");
        assertFields(fields(records.get(2)), "owan", "Obi Wan", "L4536-D2005", "");
    }

    @Test
    public void recordWithNoSemicolonAtTheEnd() throws Exception {
        final ParseTree tree = init("/record/record-no-semicolon-at-the-end.impex");
        final List<ParseTree> records = records(tree, 0);
        assertEquals(2, records.size());

        assertFields(fields(records.get(0)), "ahertz", "Ann Hertz", "K2006-C0005", "");
        assertFields(fields(records.get(1)), "owan", "Obi Wan", "Z2023-D0923");
    }

    @Test
    public void quotedFields() throws Exception {
        final ParseTree tree = init("/record/record-quoted-fields.impex");
        assertFields(fields(tree, 0, 0), "\"ahertz \"", "\"\tAnja Hertz\"", "\"K2006-C0005\t\"", "");
        assertFields(fields(tree, 0, 1), "\"jsmith\"", "\"John \"\"Texas\"\" Smith\"", "\"L4506-D2005\"", "");
        assertFields(fields(tree, 0, 2), "\"owan\"", "\"Obi;Wan\"", "\"L4536-D2005\"", "");
        assertFields(fields(tree, 0, 3), "\"owan\"", "\"Obi	\n 	Wan\"", "\"L4536-D2005\"", "");
    }

    @Test
    public void typeSpecificationDifferentSuptypes() throws Exception {
        final ParseTree tree = init("/record/record-type-specification.impex");
        assertTypeSpecification(record(tree, 0, 0), "Customer");
        assertTypeSpecification(record(tree, 0, 1), "Employee");
    }

    @Test
    public void typeSpecificationNoSubtype() throws Exception {
        final ParseTree tree = init("/record/record-type-specification-not-all-records.impex");
        assertTypeSpecification(record(tree, 0, 0), "Customer");
        assertTypeSpecification(record(tree, 0, 1), null);
    }

    private void assertTypeSpecification(final ParseTree record, final String text) {
        final ParseTree subtype = getFirstChildWithType(record, ImpexParser.Identifier);
        if (text != null) {
            assertTrue(matchesType(subtype, ImpexParser.Identifier));
            assertEquals(text, subtype.getText());
        } else {
            //no subtype specification defined
            assertNull(subtype);
        }
    }

    private void assertFields(final List<ParseTree> tree, final String... values) {
        assertEquals(values.length, tree.size());
        for (int i = 0; i < values.length; i++) {
            final ParseTree field = tree.get(i);
            assertEquals(values[i], field.getText());
        }
    }
}
