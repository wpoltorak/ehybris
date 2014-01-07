package com.lambda.impex.ast;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Iterator;
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
    public void testDuplicateMarcos() throws Exception {
        final List<Token> tokens = init("/macro/macro-duplicate.impex");
        assertThat(tokens.size(), is(8));
        assertMacro(tokens, 0, "$macro_def", "This is a macro $macro_def=$macro_def");
        assertMacro(tokens, 2, "$another", "true $and_one_more=xxx");
        assertMacro(tokens, 4, "$macro_def", "sss");
        assertMacro(tokens, 6, "$macro_def", "$macro_def$macro_def");
    }

    @Test
    public void testFirstInBlockMacro() throws Exception {
        final List<Token> tokens = init("/macro/macro-first-in-block.impex");
        final Stack<String> macroPairs = new Stack<String>();
        macroPairs.push("This is a macro");
        macroPairs.push("$macro_def");
        assertMacros(tokens, macroPairs);
    }

    @Test
    public void testInsideBlockMacro() throws Exception {
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
    public void testLastInBlockMacro() throws Exception {
        final List<Token> tokens = init("/macro/macro-last-in-block.impex");
        final Stack<String> macroPairs = new Stack<String>();
        macroPairs.push("This is a $macro_def");
        macroPairs.push("$macro_def");
        macroPairs.push("This is a macro");
        macroPairs.push("$macro_def");
        assertMacros(tokens, macroPairs);
    }

    @Test
    public void testInsideCommentMacro() throws Exception {
        final List<Token> tokens = init("/macro/macro-inside-comment.impex");
        assertThat(tokens.size(), is(0));
    }

    @Test
    public void testMultipleMacros() throws Exception {
        final List<Token> tokens = init("/macro/macro-multiple.impex");
        assertThat(tokens.size(), is(8));
        assertMacro(tokens, 0, "$macro_def", "This is a macro");
        assertMacro(tokens, 2, "$another", "true $and_one_more=xxx");
        assertMacro(tokens, 4, "$onemore_12", "sss");
        assertMacro(tokens, 6, "$_onemore_10", "sss!@#$%^&*()");
    }

    @Test
    public void testSingleLineEmptyMacro() throws Exception {
        final List<Token> tokens = init("/macro/macro-single-empty.impex");
        assertThat(tokens.size(), is(2));
        assertMacro(tokens, 0, "$macro_def", "");
    }

    @Test
    public void testSingleLineNospaceMacro() throws Exception {
        final List<Token> tokens = init("/macro/macro-single-nospaces.impex");
        assertThat(tokens.size(), is(2));
        assertMacro(tokens, 0, "$macro_def", "Thisisamacro");
    }

    @Test
    public void testSingleLineMacro() throws Exception {
        final List<Token> tokens = init("/macro/macro-single.impex");
        assertThat(tokens.size(), is(2));
        assertMacro(tokens, 0, "$macro_def", "This is a macro");
    }

    @Test
    public void testMacroWithComment() throws Exception {
        final List<Token> tokens = init("/macro/macro-with-comment.impex");
        assertThat(tokens.size(), is(10));
        assertMacro(tokens, 0, "$macro_def", "This is a macro");
        assertMacro(tokens, 2, "$another", "true $and_one_more=#xxx");
        assertMacro(tokens, 4, "$onemore_12", "sss");
        assertMacro(tokens, 6, "$_onemore_10", "sss!@#$%^&*()");
        assertMacro(tokens, 8, "$last", "#comment");
    }

    @Test
    public void testMacroWithKeyword() throws Exception {
        final List<Token> tokens = init("/macro/macro-with-keyword.impex");
        assertThat(tokens.size(), is(6));
        assertMacro(tokens, 0, "$macro_def", "This is a macro with default alias");
        assertMacro(tokens, 2, "$another", "true $and_one_more=xxx unique another");
        assertMacro(tokens, 4, "$onemore", "This macro is with false \\ separator");
    }

    @Test
    public void testMacroWithQuotedValue() throws Exception {
        final List<Token> tokens = init("/macro/macro-with-quoted-value.impex");
        assertThat(tokens.size(), is(2));
        assertMacro(tokens, 0, "$macro", "\"  This is a macro and much more  \"");
    }

    @Test
    public void testMacroWithSeparator() throws Exception {
        final List<Token> tokens = init("/macro/macro-with-separator.impex");
        assertThat(tokens.size(), is(22));
        assertMacro(tokens, 0, "$macro1", "Macro with separator+more");
        assertMacro(tokens, 2, "$macro2", "Macro with separator");
        assertMacro(tokens, 4, "$macro3", "Macro withseparator");
        assertMacro(tokens, 6, "$macro4", "Macro withseparator");
        assertMacro(tokens, 8, "$macro5", "Macro withseparator");
        assertMacro(tokens, 10, "$macro6", "Macro with separator");
        assertMacro(tokens, 12, "$macro7", "Macro withseparator");
        assertMacro(tokens, 14, "$macro8", "Macro with separator");
        assertMacro(tokens, 16, "$macro9", "Macro with\t\tseparator");
        assertMacro(tokens, 18, "$macro10", "$macro11=");
        assertMacro(tokens, 20, "$macro12", "\\");
    }

    @Test
    public void testMacroWithWhitespace() throws Exception {
        final List<Token> tokens = init("/macro/macro-with-whitespace.impex");
        assertThat(tokens.size(), is(8));
        assertMacro(tokens, 0, "$macro", "");
        assertMacro(tokens, 2, "$macro1", "This is a \tmacro");
        assertMacro(tokens, 4, "$macro2", "\\t \\r\\n \\\\ntest \\r\\t");
        assertMacro(tokens, 6, "$macro3", "");
    }

    @Test
    public void testHeaderAttributeModifiers() throws Exception {
        final List<Token> tokens = init("/header/header-attributemodifiers.impex");
        final Attribute[] attribs = new Attribute[] { attribute("uid", modifier("unique", "true")),
                attribute("groups(uid)", modifier("mode", "append")) };
        assertHeader(tokens, 4, header(ImpexLexer.InsertUpdate, "Usergroup", attribs));
    }

    //    $regulargroup=regulargroup
    //            $customergroup = customergroup
    //
    //            INSERT_UPDATE Usergroup;uid[unique=true];groups(uid)[mode=append]
    //            ;$regulargroup;$customergroup;
    //
    //            INSERT_UPDATE Usergroup;uid[    unique= true    ];groups(uid)[mode =    append, collection-delimiter = "," ]
    //            ;$regulargroup;$customergroup;
    //
    //            INSERT_UPDATE Usergroup;uid[unique=true];groups(uid)[collection-delimiter = "," ][mode=append,default=customerGroup]
    //            ;$regulargroup;$customergroup;
    //
    //            INSERT_UPDATE Usergroup;uid[unique=true][cellDecorator=de.hybris.platform.catalog.jalo.classification.eclass.EClassSuperCategoryDecorator];groups(uid)[mode=append]
    //            ;$regulargroup;$customergroup;
    //
    //            INSERT_UPDATE Usergroup;uid[unique=true,        forceWrite      =   true];groups(uid)[ignoreKeyCase =true,mode=append]
    //            ;$regulargroup;$customergroup;
    //
    //            INSERT_UPDATE Usergroup ;uid[unique=true][ignorenull =true,lang=en][virtual =false][ignorenull =true];groups(uid)[mode=append]
    //            ;$regulargroup;$customergroup;

    private void assertHeader(final List<Token> tokens, final int index, final Header header) {
        int pos = index;
        assertThat(tokens.get(pos).getType(), is(header.mode));
        assertThat(tokens.get(++pos).getText(), is(header.type));
        for (final Attribute attrib : header.attribs) {
            assertThat(tokens.get(++pos).getType(), is(ImpexLexer.Semicolon));//FIXME hardcoded semicolon  - should be retrieved from ant property
            pos += assertAttribue(tokens, ++pos, attrib);
        }
        assertThat(tokens.get(++pos).getText(), is(header.type));
    }

    private int assertAttribue(final List<Token> tokens, final int index, final Attribute attrib) {
        int pos = index;
        assertThat(tokens.get(pos).getText(), is(attrib.name));
        for (int i = 0; i < attrib.modifiers.length; ++i) {
            final Modifier modifier = attrib.modifiers[i];
            if (i > 0) {
                assertThat(tokens.get(++pos).getType(), is(ImpexLexer.Comma));
            }
            assertThat(tokens.get(++pos).getType(), is(ImpexLexer.LBracket));
            assertThat(tokens.get(++pos).getText(), is(modifier.name));
            assertThat(tokens.get(++pos).getText(), is(modifier.value));
            assertThat(tokens.get(++pos).getType(), is(ImpexLexer.RBracket));
        }
        return pos;
    }

    private Header header(final int mode, final String type, final Attribute[] attribs) {
        return new Header(mode, type, attribs);
    }

    private Modifier modifier(final String name, final String value) {
        return new Modifier(name, value);
    }

    private Attribute attribute(final String name, final Modifier... modifiers) {
        return new Attribute(name, modifiers);
    }

    private static void assertMacro(final List<Token> tokens, final int index, final String macrodef, final String macroval) {
        assertThat(tokens.get(index).getText(), is(macrodef));
        assertThat("Invalid value for " + macrodef, tokens.get(index + 1).getText(), is(macroval));
    }

    private static void assertMacros(final List<Token> tokens, final Stack<String> macroPairs) {
        for (final Iterator<Token> iterator = tokens.iterator(); iterator.hasNext();) {
            final Token token = iterator.next();
            if (token.getType() == ImpexLexer.Macrodef) {
                final String macrodef = macroPairs.pop();
                assertThat(token.getText(), is(macrodef));
                assertThat("Invalid value for " + macrodef, iterator.next().getText(), is(macroPairs.pop()));
            }
        }
    }

    private class Modifier {
        private final String name;
        private final String value;

        private Modifier(final String name, final String value) {
            this.name = name;
            this.value = value;
        }

        @Override
        public String toString() {
            return "[" + name + "=" + value + "]";
        }
    }

    private class Attribute {
        private final Modifier[] modifiers;
        private final String name;

        public Attribute(final String name, final Modifier[] modifiers) {
            this.name = name;
            this.modifiers = modifiers;
        }

        @Override
        public String toString() {
            return ";" + name + " " + modifiers;
        }

    }

    private class Header {
        private final int mode;
        private final String type;
        private final Attribute[] attribs;

        public Header(final int mode, final String type, final Attribute[] attribs) {
            this.mode = mode;
            this.type = type;
            this.attribs = attribs;
        }

        @Override
        public String toString() {
            return mode() + " " + type + " " + attribs;
        }

        private String mode() {
            switch (mode) {
                case ImpexLexer.InsertUpdate:
                    return "InsertUpdate";
                case ImpexLexer.Insert:
                    return "Insert";
                case ImpexLexer.Update:
                    return "Update";
                case ImpexLexer.Remove:
                    return "Remove";
            }
            throw new IllegalStateException("Unknown mode");
        }
    }
}
