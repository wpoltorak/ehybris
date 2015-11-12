package com.lambda.impex.ast;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.antlr.v4.runtime.CommonToken;
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
        assertThat(tokens.size(), is(6));

        tokens = init("/comment/comment-multiline.impex");
        assertThat(tokens.size(), is(5));

        tokens = init("/comment/comment-multilinewithblanks.impex");
        assertThat(tokens.size(), is(11));

        tokens = init("/comment/comment-singleline.impex");
        assertThat(tokens.size(), is(2));

        tokens = init("/comment/comment-with-macro.impex");
        assertThat(tokens.size(), is(6));
    }

    /**
     * New lines and spaces are skipped so in all cases there should be only one token passed from lexer - EOF.
     * 
     * @throws Exception
     */
    @Test
    public void testCommon() throws Exception {
        List<Token> tokens = null;

        tokens = init("/common/blank-multiline.impex");
        assertThat(tokens.size(), is(1));

        tokens = init("/common/blank-singleline.impex");
        assertThat(tokens.size(), is(1));

        tokens = init("/common/empty-multiline.impex");
        assertThat(tokens.size(), is(1));

        tokens = init("/common/empty-singleline.impex");
        assertThat(tokens.size(), is(1));
    }

    @Test
    public void testLineContinuation() throws Exception {
        List<Token> tokens = null;
        tokens = init("/common/blank-multiline.impex");

    }
    
    @Test
    public void testMacroDynamic() throws Exception {
        final List<Token> tokens = init("/macro/macro-dynamic.impex");
        System.out.println(tokens);
//        MacroDefinitions map = new MacroDefinitions();
//        map.macrodef(token(1, "$catalogVersion"));
//        map.macrodef(token(15, "$catalog"));
//        map.macrodef(token(12, "$matalog"));
//        map.macrodef(token(24, "$macro"));
//        
//        boolean referenced = map.isReferenced(token(56, "$12345"));
//        System.out.println(referenced);
;    }


    private Token token(int i, String string) {
    	CommonToken token = new CommonToken (0, string);
    	token.setStartIndex(i);
		return token;
	}

	@Test
    public void testMacroDuplicate() throws Exception {
        final List<Token> tokens = init("/macro/macro-duplicate.impex");
        int index = -1;
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$macro_def", "This is a macro $macro_def=$macro_def");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$another", "true $and_one_more=xxx");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$macro_def", "sss");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$macro_def", "$macro_def$macro_def");
    }

    @Test
    public void testMacroFirstInBlock() throws Exception {
        final List<Token> tokens = init("/macro/macro-first-in-block.impex");
        int index = -1;
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$macro_def", "This is a macro");

    }

    @Test
    public void testMacroInsideBlock() throws Exception {
        final List<Token> tokens = init("/macro/macro-inside-block.impex");
        int index = -1;
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$macro_def", "This is a macro");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$macro_def1", "This is a macro1");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$macro_def1", "This is a macro2");
    }

    @Test
    public void testMacroLastInBlock() throws Exception {
        final List<Token> tokens = init("/macro/macro-last-in-block.impex");
        int index = -1;
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$macro_def", "This is a macro");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$macro_def", "This is a $macro_def");
    }

    @Test
    public void testMacroInsideComment() throws Exception {
        final List<Token> tokens = init("/macro/macro-inside-comment.impex");
        assertThat(tokens.size(), is(2));
    }

    @Test
    public void testMacroMultiple() throws Exception {
        final List<Token> tokens = init("/macro/macro-multiple.impex");
        int index = -1;
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$macro_def", "This is a macro");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$another", "true $and_one_more=xxx");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$onemore_12", "sss");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$_onemore_10", "sss!@#$%^&*()");
    }

    @Test
    public void testMacroSingleLineEmpty() throws Exception {
        final List<Token> tokens = init("/macro/macro-single-empty.impex");
        final int index = -1;
        assertMacro(tokens, nextMacroIndex(tokens, index), "$macro_def");
    }

    @Test
    public void testMacroSingleLineNospace() throws Exception {
        final List<Token> tokens = init("/macro/macro-single-nospaces.impex");
        final int index = -1;
        assertMacro(tokens, nextMacroIndex(tokens, index), "$macro_def", "Thisisamacro");
    }

    @Test
    public void testMacroSingleLine() throws Exception {
        final List<Token> tokens = init("/macro/macro-single.impex");
        final int index = -1;
        assertMacro(tokens, nextMacroIndex(tokens, index), "$macro_def", "This is a macro");
    }

    @Test
    public void testMacroWithComment() throws Exception {
        final List<Token> tokens = init("/macro/macro-with-comment.impex");
        int index = -1;
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$macro_def", "This is a macro");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$another", "true $and_one_more=#xxx");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$onemore_12", "sss");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$_onemore_10", "sss!@#$%^&*()");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$last", "#comment");
    }

    @Test
    public void testMacroWithKeyword() throws Exception {
        final List<Token> tokens = init("/macro/macro-with-keyword.impex");
        int index = -1;
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$macro_def", "This is a macro with default alias");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$another", "true $and_one_more=xxx unique another");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$onemore", "This macro is with false \\ separator");
    }

    @Test
    public void testMacroWithQuotedValue() throws Exception {
        final List<Token> tokens = init("/macro/macro-with-quoted-value.impex");
        final int index = -1;
        //TODO verify double quotes in macro assignment and also \
        assertMacro(tokens, nextMacroIndex(tokens, index), "$macro", "\"  This is a macro    and much more  \"");
    }

    @Test
    public void testMacroWithSeparator() throws Exception {
        final List<Token> tokens = init("/macro/macro-with-separator.impex");
        int index = -1;
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$macro1", "Macro with \tseparator+more");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$macro2", "Macro with\tseparator");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$macro3", "Macro withseparator");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$macro4", "Macro withseparator");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$macro5", "Macro withseparator");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$macro6", "Macro with\tseparator");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$macro7", "Macro withseparator");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$macro8", "Macro with\t\tseparator");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$macro9", "Macro with\t\tseparator");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$macro10", "$macro11=");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$macro12", "\\");
    }

    @Test
    public void testMacroWithWhitespace() throws Exception {
        final List<Token> tokens = init("/macro/macro-with-whitespace.impex");
        int index = -1;
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$macro");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$macro1", "This is a \tmacro");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$macro2", "\\t \\r\\n \\\\ntest \\r\\t");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$macro3");
    }

    @Test
    public void testHeaderAttributeModifiers() throws Exception {
        final List<Token> tokens = init("/header/header-attributemodifiers.impex");
        Attribute[] attribs = new Attribute[] { attribute(expression("uid"), modifiers(modifier("unique", "true"))),
                attribute(expression("groups", expression("uid")), modifiers(modifier("mode", "append"))) };

        Header header = header(ImpexLexer.Mode/* InsertUpdate */, "Usergroup", attribs);
        int index = nextHeaderIndex(tokens, 0);
        index = header.assertTokens(tokens, index);

        // skip row: index is on first field. Skip next from row: field field linebreak to next token
        index = nextHeaderIndex(tokens, index);
        attribs = new Attribute[] {
                attribute(expression("uid"), modifiers(modifier("unique", "true"))),
                attribute(expression("groups", expression("uid")),
                        modifiers(modifier("mode", "append"), modifier("collection-delimiter", "\",\""))) };
        header = header(ImpexLexer.Mode/* InsertUpdate */, "Usergroup", attribs);
        index = header.assertTokens(tokens, index);

        index = nextHeaderIndex(tokens, index);
        attribs = new Attribute[] {
                attribute(expression("uid"), modifiers(modifier("unique", "true"))),
                attribute(expression("groups", expression("uid")), modifiers(modifier("collection-delimiter", "\",\"")),
                        modifiers(modifier("mode", "append"), modifier("default", "customerGroup"))) };
        header = header(ImpexLexer.Mode/* InsertUpdate */, "Usergroup", attribs);
        index = header.assertTokens(tokens, index);

        index = nextHeaderIndex(tokens, index);
        attribs = new Attribute[] {
                attribute(
                        expression("uid"),
                        modifiers(modifier("unique", "true")),
                        modifiers(modifier("cellDecorator",
                                "de.hybris.platform.catalog.jalo.classification.eclass.EClassSuperCategoryDecorator"))),
                attribute(expression("groups", expression("uid")), modifiers(modifier("mode", "append"))) };
        header = header(ImpexLexer.Mode/* InsertUpdate */, "Usergroup", attribs);
        index = header.assertTokens(tokens, index);

        index = nextHeaderIndex(tokens, index);
        attribs = new Attribute[] {
                attribute(expression("uid"), modifiers(modifier("unique", "true"), modifier("forceWrite", "true"))),
                attribute(expression("groups", expression("uid")), modifiers(modifier("ignoreKeyCase", "true"), modifier("mode", "append"))) };
        header = header(ImpexLexer.Mode/* InsertUpdate */, "Usergroup", attribs);
        index = header.assertTokens(tokens, index);

        index = nextHeaderIndex(tokens, index);
        attribs = new Attribute[] {
                attribute(expression("uid"), modifiers(modifier("unique", "true")),
                        modifiers(modifier("ignorenull", "true"), modifier("lang", "en")), modifiers(modifier("virtual", "false")),
                        modifiers(modifier("ignorenull", "true"))),
                attribute(expression("groups", expression("uid")), modifiers(modifier("mode", "append"))) };
        header = header(ImpexLexer.Mode/* InsertUpdate */, "Usergroup", attribs);
        index = header.assertTokens(tokens, index);
    }

    @Test
    public void testHeaderEmptyAttribute() throws Exception {
        final List<Token> tokens = init("/header/header-blank-attribute.impex");
        final Attribute[] attribs = new Attribute[] { attribute(expression("uid"), modifiers(modifier("unique", "true"))), null,
                attribute(expression("groups", expression("uid")), modifiers(modifier("mode", "append"))) };

        final Header header = header(ImpexLexer.Mode/* Insert */, "Usergroup", attribs);
        int index = nextHeaderIndex(tokens, 0);
        index = header.assertTokens(tokens, index);
        index = nextHeaderIndex(tokens, index);
        header.assertTokens(tokens, index);
    }

    @Test
    public void testHeaderEmptyModifier() throws Exception {
        final List<Token> tokens = init("/header/header-emptymodifier.impex");
        final Attribute[] attribs = new Attribute[] { attribute(expression("uid"), modifiers(modifier("unique", "true"))),
                attribute(expression("groups"), modifiers(modifier("ignorenull", "false"), modifier("default", null))) };

        final Header header = header(ImpexLexer.Mode/* InsertUpdate */, "Customer", attribs);
        int index = nextHeaderIndex(tokens, 0);
        index = header.assertTokens(tokens, index);
    }

    @Test
    public void testHeaderModesCaseInsensitivity() throws Exception {
        final List<Token> tokens = init("/header/header-modes-case-insensitive.impex");
        final Attribute[] attribs = new Attribute[] { attribute(expression("uid"), modifiers(modifier("unique", "true"))),
                attribute(expression("groups", expression("uid")), modifiers(modifier("mode", "append"))) };
        Header header = header(ImpexLexer.Mode/* InsertUpdate */, "Usergroup", attribs);

        int index = nextHeaderIndex(tokens, 0);
        index = header.assertTokens(tokens, index);
        index = nextHeaderIndex(tokens, index);
        index = header.assertTokens(tokens, index);

        index = nextHeaderIndex(tokens, index);
        header = header(ImpexLexer.Mode/* Update */, "Usergroup", attribs);
        index = header.assertTokens(tokens, index);

        index = nextHeaderIndex(tokens, index);
        index = header.assertTokens(tokens, index);

        index = nextHeaderIndex(tokens, index);
        header = header(ImpexLexer.Mode/* Insert */, "Usergroup", attribs);
        index = header.assertTokens(tokens, index);

        index = nextHeaderIndex(tokens, index);
        index = header.assertTokens(tokens, index);

        index = nextHeaderIndex(tokens, index);
        header = header(ImpexLexer.Mode/* Remove */, "Usergroup", attribs);
        index = header.assertTokens(tokens, index);

        index = nextHeaderIndex(tokens, index);
        index = header.assertTokens(tokens, index);
    }

    @Test
    public void testHeaderModifiersWithMacro() throws Exception {
        final List<Token> tokens = init("/header/header-modifiers-with-macro.impex");
        Attribute[] attribs = new Attribute[] { attribute(expression("uid"), modifiers(modifier("unique", "$unique"))),
                attribute(expression("groups", expression("uid")), modifiers(modifier("mode", "append"))) };
        Modifiers[] modifiers = new Modifiers[] { modifiers(modifier("cacheUnique", "$unique")) };
        Header header = header(ImpexLexer.Mode/* InsertUpdate */, "Usergroup", attribs, modifiers);

        int index = nextHeaderIndex(tokens, 0);
        index = header.assertTokens(tokens, index);

        attribs = new Attribute[] { attribute(expression("uid"), modifiers(modifier("unique", "true"))),
                attribute(expression("groups", expression("uid")), modifiers(modifier("mode", "append"))) };
        modifiers = new Modifiers[] { modifiers(modifier("processor", "$processor")) };
        header = header(ImpexLexer.Mode/* InsertUpdate */, "Usergroup", attribs, modifiers);

        index = nextHeaderIndex(tokens, index);
        index = header.assertTokens(tokens, index);

        attribs = new Attribute[] { attribute(expression("uid"), modifiers(modifier("unique", "true"))),
                attribute(expression("groups", expression("uid")), modifiers(modifier("mode", "append"))) };
        modifiers = new Modifiers[] { modifiers(modifier("processor", "de.hybris.platform.impex.jalo.imp.$processor")) };
        header = header(ImpexLexer.Mode/* InsertUpdate */, "Usergroup", attribs, modifiers);

        index = nextHeaderIndex(tokens, index);
        index = header.assertTokens(tokens, index);
    }

    //TODO test macroref as an attribute
}
