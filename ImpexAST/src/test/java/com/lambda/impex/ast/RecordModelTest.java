package com.lambda.impex.ast;

import static org.junit.Assert.assertEquals;

import org.antlr.runtime.tree.Tree;
import org.junit.Test;

import com.lambda.impex.ast.ImpexParser;

public class RecordModelTest extends ModelTest {

    @Test
    public void fieldsWithSeparators() throws Exception {
        final Tree tree = init("/record/record-line-separator-between-fields.impex");
        assertFields(fields(tree, 0, 0), "ahertz", "Anja Hertz", "K2006-C0005", "");
    }

    @Test
    public void quotedFieldWithSeparator() throws Exception {
        final Tree tree = init("/record/record-line-separator-inside-quoted-field.impex");
        assertFields(fields(tree, 0, 0), "testgroup", "test\\   group", "");
    }

    @Test
    public void unquotedFieldWithSeparator() throws Exception {
        final Tree tree = init("/record/record-line-separator-inside-unquoted-field.impex");
        assertFields(fields(tree, 0, 0), "testgroup", "test group", "");
        assertFields(fields(tree, 1, 0), "testgroup", "test group", "");
        assertFields(fields(tree, 2, 0), "testgroup", "test group", "");
        assertFields(fields(tree, 3, 0), "testgroup", "test group", "");
        assertFields(fields(tree, 4, 0), "testgroup", "testgroup", "");
    }

    @Test
    public void ignoredField() throws Exception {
        final Tree tree = init("/record/record-ignored-field.impex");
        assertFields(fields(tree, 0, 0), "ahertz", "<ignore>", "K2006-C0005", "");
    }

    @Test
    public void emptyField() throws Exception {
        final Tree tree = init("/record/record-empty-field.impex");
        assertFields(fields(tree, 0, 0), "ahertz", "", "K2006-C0005", "");
    }

    @Test
    public void blankField() throws Exception {
        final Tree tree = init("/record/record-blank-field.impex");
        assertFields(fields(tree, 0, 0), "ahertz", "", "K2006-C0005", "");
    }

    @Test
    public void fieldWithMacro() throws Exception {
        final Tree tree = init("/record/record-field-with-macro.impex");
        assertFields(fields(tree, 0, 0), "ahertz", "Ann $surname", "K2006-C0005", "");
    }

    @Test
    public void multipleRecords() throws Exception {
        final Tree tree = init("/record/record-multiple.impex");
        final Tree records = records(tree, 0);
        assertEquals(3, records.getChildCount());

        assertFields(fields(records, 0), "ahertz", "Anja Hertz", "K2006-C0005", "");
        assertFields(fields(records, 1), "jsmith", "John Smith", "L4506-D2005", "");
        assertFields(fields(records, 2), "owan", "Obi Wan", "L4536-D2005", "");
    }

    @Test
    public void recordWithNoSemicolonAtTheEnd() throws Exception {
        final Tree tree = init("/record/record-no-semicolon-at-the-end.impex");
        final Tree records = records(tree, 0);
        assertEquals(2, records.getChildCount());

        assertFields(fields(records, 0), "ahertz", "Ann Hertz", "K2006-C0005", "");
        assertFields(fields(records, 1), "owan", "Obi Wan", "Z2023-D0923");
    }

    @Test
    public void quotedFields() throws Exception {
        final Tree tree = init("/record/record-quoted-fields.impex");
        assertFields(fields(tree, 0, 0), "ahertz", "Anja Hertz", "K2006-C0005", "");
        assertFields(fields(tree, 0, 1), "jsmith", "John \"\"Texas\"\" Smith", "L4506-D2005", "");
        assertFields(fields(tree, 0, 2), "owan", "Obi;Wan", "L4536-D2005", "");
        assertFields(fields(tree, 0, 3), "owan", "Obi	 	Wan", "L4536-D2005", "");
    }

    @Test
    public void typeSpecificationDifferentSuptypes() throws Exception {
        final Tree tree = init("/record/record-type-specification.impex");
        assertTypeSpecification(record(tree, 0, 0), "Customer");
        assertTypeSpecification(record(tree, 0, 1), "Employee");
    }

    @Test
    public void typeSpecificationNoSubtype() throws Exception {
        final Tree tree = init("/record/record-type-specification-not-all-records.impex");
        assertTypeSpecification(record(tree, 0, 0), "Customer");
        assertTypeSpecification(record(tree, 0, 1), null);
    }

    private void assertTypeSpecification(final Tree record, final String text) {
        final Tree subtype = getFirstChildWithType(record, ImpexParser.SUBTYPE);
        if (text != null) {
            assertEquals(1, subtype.getChildCount());
            assertEquals(ImpexParser.Identifier, subtype.getChild(0).getType());
            assertEquals(text, subtype.getChild(0).getText());
        } else {
            //no subtype specification defined
            assertEquals(0, subtype.getChildCount());
        }
    }

    private void assertFields(final Tree fields, final String... values) {
        assertEquals(values.length, fields.getChildCount());
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], fields.getChild(i).getText());

        }
    }
}
