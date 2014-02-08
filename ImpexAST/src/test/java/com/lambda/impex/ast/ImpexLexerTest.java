package com.lambda.impex.ast;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.Stack;

import org.antlr.v4.runtime.Token;
import org.junit.Test;

public class ImpexLexerTest extends AbstractLexerTest {

    /**
     * Comments, new lines, spaces are skipped so in all cases there should be no tokens passed from lexer.
     * 
     * @throws Exception
     */
    @Test
    public void testComments() throws Exception {
        List<Token> tokens = null;

        tokens = init("/comment/comment-LF-CR.impex");
        assertThat(tokens.size(), is(0));

        tokens = init("/comment/comment-multiline.impex");
        assertThat(tokens.size(), is(0));

        tokens = init("/comment/comment-multilinewithblanks.impex");
        assertThat(tokens.size(), is(0));

        tokens = init("/comment/comment-singleline.impex");
        assertThat(tokens.size(), is(0));

        tokens = init("/comment/comment-with-macro.impex");
        assertThat(tokens.size(), is(0));
    }

    /**
     * New lines and spaces are skipped so in all cases there should be no tokens passed from lexer.
     * 
     * @throws Exception
     */
    @Test
    public void testCommon() throws Exception {
        List<Token> tokens = null;

        tokens = init("/common/blank-multiline.impex");
        assertThat(tokens.size(), is(0));

        tokens = init("/common/blank-singleline.impex");
        assertThat(tokens.size(), is(0));

        tokens = init("/common/empty-multiline.impex");
        assertThat(tokens.size(), is(0));

        tokens = init("/common/empty-singleline.impex");
        assertThat(tokens.size(), is(0));
    }

    @Test
    public void testLineContinuation() throws Exception {
        List<Token> tokens = null;
        tokens = init("/common/blank-multiline.impex");

    }

    @Test
    public void testMacroDuplicate() throws Exception {
        final List<Token> tokens = init("/macro/macro-duplicate.impex");
        assertThat(tokens.size(), is(12));
        assertMacro(tokens, 0, "$macro_def", "This is a macro $macro_def=$macro_def");
        assertMacro(tokens, 3, "$another", "true $and_one_more=xxx");
        assertMacro(tokens, 6, "$macro_def", "sss");
        assertMacro(tokens, 9, "$macro_def", "$macro_def$macro_def");
    }

    @Test
    public void testMacroFirstInBlock() throws Exception {
        final List<Token> tokens = init("/macro/macro-first-in-block.impex");
        final Stack<String> macroPairs = new Stack<String>();
        macroPairs.push("This is a macro");
        macroPairs.push("$macro_def");
        assertMacros(tokens, macroPairs);
    }

    @Test
    public void testMacroInsideBlock() throws Exception {
        final List<Token> tokens = init("/macro/macro-inside-block.impex");
        final Stack<String> macroPairs = new Stack<String>();
        macroPairs.push("This is a macro2");
        macroPairs.push("$macro_def1");
        macroPairs.push("This is a macro1");
        macroPairs.push("$macro_def1");
        macroPairs.push("This is a macro");
        macroPairs.push("$macro_def");
        assertMacros(tokens, macroPairs);
    }

    @Test
    public void testMacroLastInBlock() throws Exception {
        final List<Token> tokens = init("/macro/macro-last-in-block.impex");
        final Stack<String> macroPairs = new Stack<String>();
        macroPairs.push("This is a $macro_def");
        macroPairs.push("$macro_def");
        macroPairs.push("This is a macro");
        macroPairs.push("$macro_def");
        assertMacros(tokens, macroPairs);
    }

    @Test
    public void testMacroInsideComment() throws Exception {
        final List<Token> tokens = init("/macro/macro-inside-comment.impex");
        assertThat(tokens.size(), is(0));
    }

    @Test
    public void testMacroMultiple() throws Exception {
        final List<Token> tokens = init("/macro/macro-multiple.impex");
        assertThat(tokens.size(), is(12));
        assertMacro(tokens, 0, "$macro_def", "This is a macro");
        assertMacro(tokens, 3, "$another", "true $and_one_more=xxx");
        assertMacro(tokens, 6, "$onemore_12", "sss");
        assertMacro(tokens, 9, "$_onemore_10", "sss!@#$%^&*()");
    }

    @Test
    public void testMacroSingleLineEmpty() throws Exception {
        final List<Token> tokens = init("/macro/macro-single-empty.impex");
        assertThat(tokens.size(), is(2));
        assertMacro(tokens, 0, "$macro_def");
    }

    @Test
    public void testMacroSingleLineNospace() throws Exception {
        final List<Token> tokens = init("/macro/macro-single-nospaces.impex");
        assertThat(tokens.size(), is(3));
        assertMacro(tokens, 0, "$macro_def", "Thisisamacro");
    }

    @Test
    public void testMacroSingleLine() throws Exception {
        final List<Token> tokens = init("/macro/macro-single.impex");
        assertThat(tokens.size(), is(3));
        assertMacro(tokens, 0, "$macro_def", "This is a macro");
    }

    @Test
    public void testMacroWithComment() throws Exception {
        final List<Token> tokens = init("/macro/macro-with-comment.impex");
        assertThat(tokens.size(), is(15));
        assertMacro(tokens, 0, "$macro_def", "This is a macro");
        assertMacro(tokens, 3, "$another", "true $and_one_more=#xxx");
        assertMacro(tokens, 6, "$onemore_12", "sss");
        assertMacro(tokens, 9, "$_onemore_10", "sss!@#$%^&*()");
        assertMacro(tokens, 12, "$last", "#comment");
    }

    @Test
    public void testMacroWithKeyword() throws Exception {
        final List<Token> tokens = init("/macro/macro-with-keyword.impex");
        assertThat(tokens.size(), is(9));
        assertMacro(tokens, 0, "$macro_def", "This is a macro with default alias");
        assertMacro(tokens, 3, "$another", "true $and_one_more=xxx unique another");
        assertMacro(tokens, 6, "$onemore", "This macro is with false \\ separator");
    }

    @Test
    public void testMacroWithQuotedValue() throws Exception {
        final List<Token> tokens = init("/macro/macro-with-quoted-value.impex");
        assertThat(tokens.size(), is(3));
        //TODO verify double quotes in macro assignment and also \
        assertMacro(tokens, 0, "$macro", "\"  This is a macro\\    \n    and much more  \"");
    }

    @Test
    public void testMacroWithSeparator() throws Exception {
        final List<Token> tokens = init("/macro/macro-with-separator.impex");
        assertThat(tokens.size(), is(33));
        assertMacro(tokens, 0, "$macro1", "Macro with \\ \n\tseparator\\\n+more");
        assertMacro(tokens, 3, "$macro2", "Macro with\t\\\nseparator");
        assertMacro(tokens, 6, "$macro3", "Macro with\\\nseparator");
        assertMacro(tokens, 9, "$macro4", "Macro with\\\n\\\n\\\n\\\t\n\\\nseparator");
        assertMacro(tokens, 12, "$macro5", "Macro with\\\n\\\n\\\n\\\nseparator");
        assertMacro(tokens, 15, "$macro6", "Macro with\\\n\\\n\t\\\n\\\nseparator");
        assertMacro(tokens, 18, "$macro7", "Macro with\\\t\t\nseparator");
        assertMacro(tokens, 21, "$macro8", "Macro with\\\n\t\tseparator");
        assertMacro(tokens, 24, "$macro9", "Macro with\t\tseparator");
        assertMacro(tokens, 27, "$macro10", "$macro11=");
        assertMacro(tokens, 30, "$macro12", "\\");
    }

    @Test
    public void testMacroWithWhitespace() throws Exception {
        final List<Token> tokens = init("/macro/macro-with-whitespace.impex");
        assertThat(tokens.size(), is(10));
        assertMacro(tokens, 0, "$macro");
        assertMacro(tokens, 2, "$macro1", "This is a \tmacro");
        assertMacro(tokens, 5, "$macro2", "\\t \\r\\n \\\\ntest \\r\\t");
        assertMacro(tokens, 8, "$macro3");
    }

    @Test
    public void testHeaderAttributeModifiers() throws Exception {
        final List<Token> tokens = init("/header/header-attributemodifiers.impex");
        Attribute[] attribs = new Attribute[] { attribute(expression("uid"), modifiers(modifier("unique", "true"))),
                attribute(expression("groups", expression("uid")), modifiers(modifier("mode", "append"))) };

        Header header = header(ImpexLexer.InsertUpdate, "Usergroup", attribs);
        int index = 6;
        index = header.assertTokens(tokens, index);

        // skip row: index is on first field. Skip next from row: field field linebreak to next token
        index += 4;
        attribs = new Attribute[] {
                attribute(expression("uid"), modifiers(modifier("unique", "true"))),
                attribute(expression("groups", expression("uid")),
                        modifiers(modifier("mode", "append"), modifier("collection-delimiter", "\",\""))) };
        header = header(ImpexLexer.InsertUpdate, "Usergroup", attribs);
        index = header.assertTokens(tokens, index);

        index += 4;
        attribs = new Attribute[] {
                attribute(expression("uid"), modifiers(modifier("unique", "true"))),
                attribute(expression("groups", expression("uid")), modifiers(modifier("collection-delimiter", "\",\"")),
                        modifiers(modifier("mode", "append"), modifier("default", "customerGroup"))) };
        header = header(ImpexLexer.InsertUpdate, "Usergroup", attribs);
        index = header.assertTokens(tokens, index);

        index += 4;
        attribs = new Attribute[] {
                attribute(
                        expression("uid"),
                        modifiers(modifier("unique", "true")),
                        modifiers(modifier("cellDecorator",
                                "de.hybris.platform.catalog.jalo.classification.eclass.EClassSuperCategoryDecorator"))),
                attribute(expression("groups", expression("uid")), modifiers(modifier("mode", "append"))) };
        header = header(ImpexLexer.InsertUpdate, "Usergroup", attribs);
        index = header.assertTokens(tokens, index);

        index += 4;
        attribs = new Attribute[] {
                attribute(expression("uid"), modifiers(modifier("unique", "true"), modifier("forceWrite", "true"))),
                attribute(expression("groups", expression("uid")), modifiers(modifier("ignoreKeyCase", "true"), modifier("mode", "append"))) };
        header = header(ImpexLexer.InsertUpdate, "Usergroup", attribs);
        index = header.assertTokens(tokens, index);

        index += 4;
        attribs = new Attribute[] {
                attribute(expression("uid"), modifiers(modifier("unique", "true")),
                        modifiers(modifier("ignorenull", "true"), modifier("lang", "en")), modifiers(modifier("virtual", "false")),
                        modifiers(modifier("ignorenull", "true"))),
                attribute(expression("groups", expression("uid")), modifiers(modifier("mode", "append"))) };
        header = header(ImpexLexer.InsertUpdate, "Usergroup", attribs);
        index = header.assertTokens(tokens, index);
    }

    @Test
    public void testHeaderEmptyAttribute() throws Exception {
        final List<Token> tokens = init("/header/header-blank-attribute.impex");
        final Attribute[] attribs = new Attribute[] { attribute(expression("uid"), modifiers(modifier("unique", "true"))), null,
                attribute(expression("groups", expression("uid")), modifiers(modifier("mode", "append"))) };

        final Header header = header(ImpexLexer.Insert, "Usergroup", attribs);
        int index = 0;
        index = header.assertTokens(tokens, index);
        index += 5; // row
        header.assertTokens(tokens, index);
    }

    @Test
    public void testHeaderEmptyModifier() throws Exception {
        final List<Token> tokens = init("/header/header-emptymodifier.impex");
        final Attribute[] attribs = new Attribute[] { attribute(expression("uid"), modifiers(modifier("unique", "true"))),
                attribute(expression("groups"), modifiers(modifier("ignorenull", "false"), modifier("default", null))) };

        final Header header = header(ImpexLexer.InsertUpdate, "Customer", attribs);
        int index = 0;
        index = header.assertTokens(tokens, index);
    }

    @Test
    public void testHeaderModesCaseInsensitivity() throws Exception {
        final List<Token> tokens = init("/header/header-modes-case-insensitive.impex");
        final Attribute[] attribs = new Attribute[] { attribute(expression("uid"), modifiers(modifier("unique", "true"))),
                attribute(expression("groups", expression("uid")), modifiers(modifier("mode", "append"))) };
        Header header = header(ImpexLexer.InsertUpdate, "Usergroup", attribs);

        int index = 0;
        index = header.assertTokens(tokens, index);
        index += 4;
        index = header.assertTokens(tokens, index);

        index += 4;
        header = header(ImpexLexer.Update, "Usergroup", attribs);
        index = header.assertTokens(tokens, index);

        index += 4;
        index = header.assertTokens(tokens, index);

        index += 4;
        header = header(ImpexLexer.Insert, "Usergroup", attribs);
        index = header.assertTokens(tokens, index);

        index += 3;
        index = header.assertTokens(tokens, index);

        index += 3;
        header = header(ImpexLexer.Remove, "Usergroup", attribs);
        index = header.assertTokens(tokens, index);

        index += 3;
        index = header.assertTokens(tokens, index);
    }

    @Test
    public void testHeaderModifiersWithMacro() throws Exception {
        final List<Token> tokens = init("/header/header-modifiers-with-macro.impex");
        Attribute[] attribs = new Attribute[] { attribute(expression("uid"), modifiers(modifier("unique", "$unique"))),
                attribute(expression("groups", expression("uid")), modifiers(modifier("mode", "append"))) };
        Modifiers[] modifiers = new Modifiers[] { modifiers(modifier("cacheUnique", "$unique")) };
        Header header = header(ImpexLexer.InsertUpdate, "Usergroup", attribs, modifiers);

        int index = 9;
        index = header.assertTokens(tokens, index);

        attribs = new Attribute[] { attribute(expression("uid"), modifiers(modifier("unique", "true"))),
                attribute(expression("groups", expression("uid")), modifiers(modifier("mode", "append"))) };
        modifiers = new Modifiers[] { modifiers(modifier("processor", "$processor")) };
        header = header(ImpexLexer.InsertUpdate, "Usergroup", attribs, modifiers);

        index += 4;
        index = header.assertTokens(tokens, index);

        attribs = new Attribute[] { attribute(expression("uid"), modifiers(modifier("unique", "true"))),
                attribute(expression("groups", expression("uid")), modifiers(modifier("mode", "append"))) };
        modifiers = new Modifiers[] { modifiers(modifier("processor", "de.hybris.platform.impex.jalo.imp.$processor")) };
        header = header(ImpexLexer.InsertUpdate, "Usergroup", attribs, modifiers);

        index += 7;
        index = header.assertTokens(tokens, index);
    }
}
