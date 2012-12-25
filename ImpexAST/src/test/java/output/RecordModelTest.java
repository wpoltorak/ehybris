package output;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class RecordModelTest {

    private ImpexParser parser;

    private CommonTree init(final String name) throws Exception {
        final File file = new File(getClass().getResource(name).getFile());
        final String impex = FileUtils.readFileToString(file);
        final ImpexLexer lexer = new ImpexLexer(new ImpexANTLRStringStream(impex));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        parser = new ImpexParser(tokens);
        return (CommonTree) parser.impex().getTree();
    }

    @Test
    public void fieldsWithSeparators() throws Exception {
        final CommonTree tree = init("/record/record-line-separator-between-fields.impex");
        assertFields(fields(tree, 0, 0), "ahertz", "Anja Hertz", "K2006-C0005", "");
    }

    @Test
    public void quotedFieldWithSeparator() throws Exception {
        final CommonTree tree = init("/record/record-line-separator-inside-quoted-field.impex");
        assertFields(fields(tree, 0, 0), "testgroup", "test\\   group", "");
    }

    @Test
    public void unquotedFieldWithSeparator() throws Exception {
        final CommonTree tree = init("/record/record-line-separator-inside-unquoted-field.impex");
        assertFields(fields(tree, 0, 0), "testgroup", "test group", "");
        assertFields(fields(tree, 1, 0), "testgroup", "test group", "");
        assertFields(fields(tree, 2, 0), "testgroup", "test group", "");
        assertFields(fields(tree, 3, 0), "testgroup", "test group", "");
        assertFields(fields(tree, 4, 0), "testgroup", "testgroup", "");
    }

    @Test
    public void ignoredField() throws Exception {
        final CommonTree tree = init("/record/record-ignored-field.impex");
        assertFields(fields(tree, 0, 0), "ahertz", "<ignore>", "K2006-C0005", "");
    }

    @Test
    public void emptyField() throws Exception {
        final CommonTree tree = init("/record/record-empty-field.impex");
        assertFields(fields(tree, 0, 0), "ahertz", "", "K2006-C0005", "");
    }

    @Test
    public void blankField() throws Exception {
        final CommonTree tree = init("/record/record-blank-field.impex");
        assertFields(fields(tree, 0, 0), "ahertz", "", "K2006-C0005", "");
    }

    @Test
    public void multipleRecords() throws Exception {
        final CommonTree tree = init("/record/record-multiple.impex");
        final CommonTree blocks = (CommonTree) tree.getFirstChildWithType(ImpexParser.BLOCKS);
        final CommonTree block = (CommonTree) blocks.getFirstChildWithType(ImpexParser.BLOCK);
        final CommonTree records = (CommonTree) block.getFirstChildWithType(ImpexParser.RECORDS);
        assertEquals(3, records.getChildCount());

        assertFields(fields(records, 0), "ahertz", "Anja Hertz", "K2006-C0005", "");
        assertFields(fields(records, 1), "jsmith", "John Smith", "L4506-D2005", "");
        assertFields(fields(records, 2), "owan", "Obi Wan", "L4536-D2005", "");
    }

    @Test
    public void recordWithNoSemicolonAtTheEnd() throws Exception {
        final CommonTree tree = init("/record/record-no-semicolon-at-the-end.impex");
        final CommonTree blocks = (CommonTree) tree.getFirstChildWithType(ImpexParser.BLOCKS);
        final CommonTree block = (CommonTree) blocks.getFirstChildWithType(ImpexParser.BLOCK);
        final CommonTree records = (CommonTree) block.getFirstChildWithType(ImpexParser.RECORDS);
        assertEquals(2, records.getChildCount());

        assertFields(fields(records, 0), "ahertz", "Ann Hertz", "K2006-C0005", "");
        assertFields(fields(records, 1), "owan", "Obi Wan", "Z2023-D0923");
    }

    @Test
    public void quotedFields() throws Exception {
        final CommonTree tree = init("/record/record-quoted-fields.impex");
        assertFields(fields(tree, 0, 0), "ahertz", "Anja Hertz", "K2006-C0005", "");
        assertFields(fields(tree, 0, 1), "jsmith", "John \"\"Texas\"\" Smith", "L4506-D2005", "");
        assertFields(fields(tree, 0, 2), "owan", "Obi;Wan", "L4536-D2005", "");
        assertFields(fields(tree, 0, 3), "owan", "Obi	 	Wan", "L4536-D2005", "");
    }

    @Test
    public void typeSpecificationDifferentSuptypes() throws Exception {
        final CommonTree tree = init("/record/record-type-specification.impex");
        assertTypeSpecification(record(tree, 0, 0), "Customer");
        assertTypeSpecification(record(tree, 0, 1), "Employee");
    }

    @Test
    public void typeSpecificationNoSubtype() throws Exception {
        final CommonTree tree = init("/record/record-type-specification-not-all-records.impex");
        assertTypeSpecification(record(tree, 0, 0), "Customer");
        assertTypeSpecification(record(tree, 0, 1), null);
    }

    private CommonTree record(final CommonTree tree, final int blockNo, final int recordNo) {
        final CommonTree blocks = (CommonTree) tree.getFirstChildWithType(ImpexParser.BLOCKS);
        final CommonTree block = (CommonTree) blocks.getChild(blockNo);
        final CommonTree records = (CommonTree) block.getFirstChildWithType(ImpexParser.RECORDS);
        return (CommonTree) records.getChild(recordNo);
    }

    private CommonTree fields(final CommonTree records, final int recordNo) {
        return (CommonTree) ((CommonTree) records.getChild(recordNo)).getFirstChildWithType(ImpexParser.FIELDS);
    }

    private CommonTree fields(final CommonTree tree, final int blockNo, final int recordNo) {
        final CommonTree record = record(tree, blockNo, recordNo);
        return (CommonTree) record.getFirstChildWithType(ImpexParser.FIELDS);
    }

    private void assertTypeSpecification(final CommonTree record, final String text) {
        final CommonTree subtype = (CommonTree) record.getFirstChildWithType(ImpexParser.SUBTYPE);
        if (text != null) {
            assertEquals(1, subtype.getChildCount());
            assertEquals(ImpexParser.Identifier, subtype.getChild(0).getType());
            assertEquals(text, subtype.getChild(0).getText());
        } else {
            //no subtype specification defined
            assertEquals(0, subtype.getChildCount());
        }
    }

    private void assertFields(final CommonTree fields, final String... values) {
        assertEquals(values.length, fields.getChildCount());
        for (int i = 0; i < values.length; i++) {
            assertEquals(values[i], fields.getChild(i).getText());

        }
    }
}
