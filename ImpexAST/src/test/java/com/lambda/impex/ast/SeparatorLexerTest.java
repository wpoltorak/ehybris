package com.lambda.impex.ast;

import java.util.List;

import org.antlr.v4.runtime.Token;
import org.junit.Test;

/**
 * Multi-line separator symbol (soft line break) is '\'. It can be used anywhere in the impex file.<br/>
 * This test checks if Lexer takes separator character into account during parsing input stream.
 * <ul>
 * Rules to check
 * <li>All whitespace characters before '\' or after '\' followed by new line character will be replaced by single space character</li>
 * <li>All whitespace characters after '\' but before new line character will be ignored</li>
 * <li>Inside macro value '\' is always treated as separator, even if text is surrounded by single or double quotes. That because quotes
 * surrounding macro value are actually part of this value and are not erased from resulting string.</li>
 * <li>In double quoted fields line separator is treated as normal text</li>
 * <li>Between attributes, fields, etc (between tokens) separator is removed from resulting token stream - is skipped</li>
 * <li>Within tokens separator is left as is but will be removed in future by parser token listener</li>
 * <ul>
 * 
 * @author Wojciech Poltorak
 * 
 */
public class SeparatorLexerTest extends AbstractLexerTest {

    @Test
    public void testInsideInsertUpdateMode() throws Exception {
        final List<Token> tokens = init("/separator/separator-inside-insert_update-mode.impex");
        final Attribute[] attribs = new Attribute[] { attribute(expression("uid"), modifiers(modifier("unique", "true"))),
                attribute(expression("Name")) };
        int index = 0;
        index = header(ImpexLexer.Mode/* InsertUpdate */, "InSeRt_UpDaTe", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* InsertUpdate */, "I\\\nNSERT_UPDATE", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* InsertUpdate */, "IN\\\t\nSERT_UPDATE", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* InsertUpdate */, "INS\\ \nERT_UPDATE", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* InsertUpdate */, "INSE\\ \t\nRT_UPDATE", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* InsertUpdate */, "INSER\\\nT_UPDATE", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* InsertUpdate */, "INSERT\\\n_update", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* InsertUpdate */, "INSERT_\\\nUPDATE", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* InsertUpdate */, "INSERT_U\\\nPDATE", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* InsertUpdate */, "INSERT_up\\\nDATE", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* InsertUpdate */, "INseRT_UPD\\\nATE", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* InsertUpdate */, "INSERT_UPDA\\\nTE", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* InsertUpdate */, "INSERT_UPDAT\\\n\\\nE", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* InsertUpdate */, "insert_update\\\n", "Customer", attribs).assertTokens(tokens, index);
    }

    @Test
    public void testInsideInsertMode() throws Exception {
        final List<Token> tokens = init("/separator/separator-inside-insert-mode.impex");
        final Attribute[] attribs = new Attribute[] { attribute(expression("uid"), modifiers(modifier("unique", "true"))),
                attribute(expression("Name")) };
        int index = 0;
        index = header(ImpexLexer.Mode/* Insert */, "InSeRt", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* Insert */, "I\\\nNSERT", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* Insert */, "IN\\\t\nSERT", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* Insert */, "INS\\ \nERT", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* Insert */, "INSE\\ \t\nRT", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* Insert */, "INSER\\\nT", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* Insert */, "INSERT\\\n", "Customer", attribs).assertTokens(tokens, index);
    }

    @Test
    public void testInsideUpdateMode() throws Exception {
        final List<Token> tokens = init("/separator/separator-inside-update-mode.impex");
        final Attribute[] attribs = new Attribute[] { attribute(expression("uid"), modifiers(modifier("unique", "true"))),
                attribute(expression("Name")) };
        int index = 0;
        index = header(ImpexLexer.Mode/* Update */, "UpDaTe", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* Update */, "U\\\nPDATE", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* Update */, "UP\\\t\nDATE", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* Update */, "UPD\\ \nate", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* Update */, "UPDA\\ \t\nte", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* Update */, "UPDAT\\\nE", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* Update */, "update\\\n", "Customer", attribs).assertTokens(tokens, index);
    }

    @Test
    public void testInsideRemoveMode() throws Exception {
        final List<Token> tokens = init("/separator/separator-inside-remove-mode.impex");
        final Attribute[] attribs = new Attribute[] { attribute(expression("uid"), modifiers(modifier("unique", "true"))),
                attribute(expression("Name")) };
        int index = 0;
        index = header(ImpexLexer.Mode/* Remove */, "ReMoVe", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* Remove */, "R\\\nEMOVE", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* Remove */, "RE\\\t\nMOVE", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* Remove */, "REM\\ \nove", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* Remove */, "REMO\\ \t\nve", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* Remove */, "REMOV\\\nE", "Customer", attribs).assertTokens(tokens, index);
        index = header(ImpexLexer.Mode/* Remove */, "remove\\\n", "Customer", attribs).assertTokens(tokens, index);
    }

    @Test
    public void testBetweenAttributes() throws Exception {
        final List<Token> tokens = init("/separator/separator-between-header-attribs.impex");
        final Attribute[] attribs = new Attribute[] { attribute(expression("uid"), modifiers(modifier("unique", "true"))),
                attribute(expression("Name")) };
        final Header header = header(ImpexLexer.Mode/* InsertUpdate */, "Customer", attribs);
        int index = 0;
        index = header.assertTokens(tokens, index);
        index = header.assertTokens(tokens, index);
        index = nextHeaderIndex(tokens, index);
        index = header.assertTokens(tokens, index);
        index = nextHeaderIndex(tokens, index);
        index = header.assertTokens(tokens, index);
    }

    @Test
    public void testInsideAttributes() throws Exception {
        final List<Token> tokens = init("/separator/separator-inside-attribute.impex");
        Attribute[] attribs = new Attribute[] { attribute(expression("uid"), modifiers(modifier("unique", "true"))),
                attribute(expression("Name")) };
        Header header = header(ImpexLexer.Mode/* InsertUpdate */, "Customer", attribs);
        int index = 0;
        index = header.assertTokens(tokens, index);
        attribs = new Attribute[] { attribute(expression("uid"), modifiers(modifier("unique", "true\t\t"))), attribute(expression("Name")) };
        header = header(ImpexLexer.Mode/* InsertUpdate */, "Customer", attribs);
        index = header.assertTokens(tokens, index);

        attribs = new Attribute[] { attribute(expression("uid"), modifiers(modifier("unique\\\n\\\n", "true"))),
                attribute(expression("Name")) };
        header = header(ImpexLexer.Mode/* InsertUpdate */, "Customer", attribs);
        index = nextHeaderIndex(tokens, index);
        index = header.assertTokens(tokens, index);

        attribs = new Attribute[] {
                attribute(expression("uid"), modifiers(modifier("unique", "true")), modifiers(modifier("mode", "append"))),
                attribute(expression("Name")) };
        header = header(ImpexLexer.Mode/* InsertUpdate */, "Customer", attribs);
        index = header.assertTokens(tokens, index);

        attribs = new Attribute[] { attribute(expression("uid"), modifiers(modifier("unique", "true"), modifier("mode", "append"))),
                attribute(expression("Name")) };
        header = header(ImpexLexer.Mode/* InsertUpdate */, "Customer", attribs);
        index = header.assertTokens(tokens, index);
    }

    @Test
    public void testInsideMacroAssignments() throws Exception {
        final List<Token> tokens = init("/separator/separator-inside-macroassignment.impex");
        int index = -1;
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$na\\\nme", "Andy         Warhol 7");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$na\\\t\nme", "'Andy         Warhol 8'");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$\\ \nna\\\n\\\n_me", "\"\tAndy\t\tWarhol \t\"    9");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$MACRO", "Value");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$MACRO2", "Value");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$MACRO_3", " Value");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$MACRO_4", "  Value");
        assertMacro(tokens, index = nextMacroIndex(tokens, index), "$\\\n\\\n\\\n\\\n\\\n\\\nmac\\\n\\\n\\\nro5", "20");
    }
}
