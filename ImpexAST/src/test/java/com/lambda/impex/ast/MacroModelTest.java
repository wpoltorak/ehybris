package com.lambda.impex.ast;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Ignore;
import org.junit.Test;

public class MacroModelTest extends ModelTest {

    public void setup() {
        final ImpexModel model = new DefaultImpexModel();
    }

    /**
     * Test if separator & surrounding whitespace characters are correctly removed from macro value.
     * <ul>
     * Algorithm should work as follows:
     * <li>Separator and line break characters are ignored</li>
     * <li>Any whitespace characters after separator and before line break are ignored</li>
     * <li>Any whitespace characters before separator and after line break are converted into single space character</li>
     * <ul>
     * 
     * @throws Exception
     */
    @Test
    @Ignore
    public void macroWithSeparator() throws Exception {
        init("/macro/macro-with-separator.impex");

        final Map<String, List<SimpleImmutableEntry<Integer, String>>> macros = context.getMacros();
        assertEquals(11, macros.size());

        assertSingleEntry(macros.get("$macro1"), 2, "Macro with \tseparator+more");
        assertSingleEntry(macros.get("$macro2"), 6, "Macro with\tseparator");
        assertSingleEntry(macros.get("$macro3"), 8, "Macro withseparator");
        assertSingleEntry(macros.get("$macro4"), 10, "Macro withseparator");
        assertSingleEntry(macros.get("$macro5"), 17, "Macro withseparator");
        assertSingleEntry(macros.get("$macro6"), 23, "Macro with\tseparator");
        assertSingleEntry(macros.get("$macro7"), 29, "Macro withseparator");
        assertSingleEntry(macros.get("$macro8"), 31, "Macro with\t\tseparator");
        assertSingleEntry(macros.get("$macro9"), 33, "Macro with\t\tseparator");
        assertSingleEntry(macros.get("$macro10"), 35, "$macro11=");
        assertSingleEntry(macros.get("$macro12"), 37, "\\");
    }

    @Test
    @Ignore
    public void macroSingleCharacter() throws Exception {
        init("/macro/macro-single-character.impex");

        final Map<String, List<SimpleImmutableEntry<Integer, String>>> macros = context.getMacros();
        assertEquals(1, macros.size());
        assertSingleEntry(macros.get("$macro_def"), 1, "4");
    }

    @Test
    @Ignore
    public void macroSingleEmpty() throws Exception {
        init("/macro/macro-single-empty.impex");

        final Map<String, List<SimpleImmutableEntry<Integer, String>>> macros = context.getMacros();
        assertEquals(1, macros.size());
        assertSingleEntry(macros.get("$macro_def"), 1, "");
    }

    @Test
    @Ignore
    public void macroSingleNospaces() throws Exception {
        init("/macro/macro-single-nospaces.impex");

        final Map<String, List<SimpleImmutableEntry<Integer, String>>> macros = context.getMacros();
        assertEquals(1, macros.size());
        assertSingleEntry(macros.get("$macro_def"), 1, "Thisisamacro");
    }

    @Test
    @Ignore
    public void macroSingle() throws Exception {
        init("/macro/macro-single.impex");

        final Map<String, List<SimpleImmutableEntry<Integer, String>>> macros = context.getMacros();
        assertEquals(1, macros.size());
        assertSingleEntry(macros.get("$macro_def"), 1, "This is a macro");
    }

    @Test
    @Ignore
    public void macroWithQuotedValue() throws Exception {
        init("/macro/macro-with-quoted-value.impex");

        final Map<String, List<SimpleImmutableEntry<Integer, String>>> macros = context.getMacros();
        assertEquals(1, macros.size());
        assertSingleEntry(macros.get("$macro"), 1, "\"  This is a macro    and much more  \"");
    }

    @Test
    @Ignore
    public void macroWithKeyword() throws Exception {
        init("/macro/macro-with-keyword.impex");

        final Map<String, List<SimpleImmutableEntry<Integer, String>>> macros = context.getMacros();
        assertEquals(3, macros.size());

        assertSingleEntry(macros.get("$macro_def"), 2, "This is a macro with default alias");
        assertSingleEntry(macros.get("$another"), 4, "true $and_one_more=xxx unique another");
        assertSingleEntry(macros.get("$onemore"), 6, "This macro is with false \\ separator");

    }

    @Test
    @Ignore
    public void macroWithComment() throws Exception {
        init("/macro/macro-with-comment.impex");

        final Map<String, List<SimpleImmutableEntry<Integer, String>>> macros = context.getMacros();
        assertEquals(5, macros.size());

        assertSingleEntry(macros.get("$another"), 4, "true $and_one_more=#xxx");
        assertSingleEntry(macros.get("$_onemore_10"), 6, "sss!@#$%^&*()");
        assertSingleEntry(macros.get("$last"), 10, "#comment");

    }

    @Test
    @Ignore
    public void macroWithWhitespace() throws Exception {
        init("/macro/macro-with-whitespace.impex");

        final Map<String, List<SimpleImmutableEntry<Integer, String>>> macros = context.getMacros();
        assertEquals(4, macros.size());

        assertSingleEntry(macros.get("$macro"), 2, "");
        assertSingleEntry(macros.get("$macro1"), 4, "This is a 	macro");
        assertSingleEntry(macros.get("$macro2"), 6, "\\t \\r\\n \\\\ntest \\r\\t");
        assertSingleEntry(macros.get("$macro3"), 7, "");
    }

    @Test
    public void macroWithMultipleDefinitions() throws Exception {
        init("/macro/macro-duplicate.impex");

        final Map<String, List<SimpleImmutableEntry<Integer, String>>> macros = context.getMacros();
        assertEquals(2, macros.size());

        assertSingleEntry(macros.get("$another"), 4, "true $and_one_more=xxx");

        assertEntries(macros.get("$macro_def"), new int[] { 2, 5, 6 }, new String[] { "This is a macro $macro_def=$macro_def", "sss",
                "$macro_def$macro_def" });
    }

    @Test
    @Ignore
    public void macroInsideBlock() throws Exception {
        final ParseTree tree = init("/macro/macro-inside-block.impex");

        final Map<String, List<SimpleImmutableEntry<Integer, String>>> macros = context.getMacros();
        assertEquals(2, macros.size());

        assertSingleEntry(macros.get("$macro_def"), 3, "This is a macro");
        assertEntries(macros.get("$macro_def1"), new int[] { 6, 7 }, new String[] { "This is a macro1", "This is a macro2" });
        assertEquals(3, getChildrenWithType(block(tree, 0), ImpexParser.RULE_record).size());
    }

    @Test
    @Ignore
    public void macroFirstInBlock() throws Exception {
        final ParseTree tree = init("/macro/macro-first-in-block.impex");

        final Map<String, List<SimpleImmutableEntry<Integer, String>>> macros = context.getMacros();
        assertEquals(1, macros.size());

        assertSingleEntry(macros.get("$macro_def"), 2, "This is a macro");
        assertEquals(1, getChildrenWithType(block(tree, 0), ImpexParser.RULE_record).size());
    }

    @Test
    @Ignore
    public void macroLastInBlock() throws Exception {
        final ParseTree tree = init("/macro/macro-last-in-block.impex");

        final Map<String, List<SimpleImmutableEntry<Integer, String>>> macros = context.getMacros();
        assertEquals(1, macros.size());
        assertEntries(macros.get("$macro_def"), new int[] { 6, 10 }, new String[] { "This is a macro", "This is a $macro_def" });
        assertEquals(2, getChildrenWithType(tree, ImpexParser.RULE_block).size());
        assertEquals(3, getChildrenWithType(block(tree, 0), ImpexParser.RULE_record).size());
        assertEquals(1, getChildrenWithType(block(tree, 1), ImpexParser.RULE_record).size());
    }

    @Test
    @Ignore
    public void macroInsideComment() throws Exception {
        init("/macro/macro-inside-comment.impex");

        final Map<String, List<SimpleImmutableEntry<Integer, String>>> macros = context.getMacros();
        assertEquals(0, macros.size());
    }

    @Test
    @Ignore
    public void macroWithMacroInDefinition() throws Exception {
        init("/macro/macro-with-macro-in-definition.impex");
        final Map<String, List<SimpleImmutableEntry<Integer, String>>> macros = context.getMacros();
        assertTrue(macros.containsKey("$macro_def"));
        assertTrue(macros.containsKey("$macro$macro_def"));
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
}
