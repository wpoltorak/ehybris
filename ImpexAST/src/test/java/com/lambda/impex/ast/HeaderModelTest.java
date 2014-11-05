package com.lambda.impex.ast;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

public class HeaderModelTest extends ModelTest {

    @Test
    public void headerNodeIsSingle() throws Exception {
        ParseTree tree = init("/header/header-blank-attribute.impex");
        tree = block(tree, 0);
        final List<ParseTree> attributesNodes = getChildrenWithType(tree, ImpexParser.RULE_header);
        assertEquals(1, attributesNodes.size());
    }

    @Test
    public void emptyAttributeExistsInTree() throws Exception {
        final ParseTree tree = init("/header/header-blank-attribute.impex");
        List<ParseTree> attributeNodes = getChildrenWithType(header(tree, 0), ImpexParser.RULE_attribute);
        assertEquals(3, attributeNodes.size());
        assertNull(((ParserRuleContext) attributeNodes.get(0)).exception);
        assertNull(((ParserRuleContext) attributeNodes.get(1)).exception);
        assertNull(((ParserRuleContext) attributeNodes.get(2)).exception);
        assertEmptyAttribute(attributeNodes.get(1));

        attributeNodes = getChildrenWithType(header(tree, 1), ImpexParser.RULE_attribute);
        assertEquals(3, attributeNodes.size());
        assertNull(((ParserRuleContext) attributeNodes.get(0)).exception);
        assertNull(((ParserRuleContext) attributeNodes.get(1)).exception);
        assertNull(((ParserRuleContext) attributeNodes.get(2)).exception);
        assertEmptyAttribute(attributeNodes.get(1));

    }

    private void assertEmptyAttribute(final ParseTree attribute) {
        assertEquals(1, attribute.getChildCount());
        final ParseTree value = getFirstChildWithType(attribute, ImpexParser.RULE_simpleAttribute);
        assertEquals(0, value.getChildCount());
    }

    @Test
    public void attributeModifiers() throws Exception {
        final ParseTree tree = init("/header/header-attributemodifiers.impex");
        assertModifiers(modifiers(tree, 0, 0), a(ImpexParser.BooleanAttributeModifier), a("true"));
        assertModifiers(modifiers(tree, 0, 1), a(ImpexParser.TextAttributeModifier), a("append"));

        assertModifiers(modifiers(tree, 1, 0), a(ImpexParser.BooleanAttributeModifier), a("true"));
        assertModifiers(modifiers(tree, 1, 1), a(ImpexParser.TextAttributeModifier, ImpexParser.TextAttributeModifier),
                a("append", "\",\""));

        assertModifiers(modifiers(tree, 2, 0), a(ImpexParser.BooleanAttributeModifier), a("true"));
        assertModifiers(modifiers(tree, 2, 1),
                a(ImpexParser.TextAttributeModifier, ImpexParser.TextAttributeModifier, ImpexParser.TextAttributeModifier),
                a("\",\"", "append", "customerGroup"));

        assertModifiers(modifiers(tree, 3, 0), a(ImpexParser.BooleanAttributeModifier, ImpexParser.ClassAttributeModifier),
                a("true", "de.hybris.platform.catalog.jalo.classification.eclass.EClassSuperCategoryDecorator"));
        assertModifiers(modifiers(tree, 3, 1), a(ImpexParser.TextAttributeModifier), a("append"));

        assertModifiers(modifiers(tree, 4, 0), a(ImpexParser.BooleanAttributeModifier, ImpexParser.BooleanAttributeModifier),
                a("true", "true"));
        assertModifiers(modifiers(tree, 4, 1), a(ImpexParser.BooleanAttributeModifier, ImpexParser.TextAttributeModifier),
                a("true", "append"));

        assertModifiers(
                modifiers(tree, 5, 0),
                a(ImpexParser.BooleanAttributeModifier, ImpexParser.BooleanAttributeModifier, ImpexParser.TextAttributeModifier,
                        ImpexParser.BooleanAttributeModifier, ImpexParser.BooleanAttributeModifier),
                a("true", "true", "en", "false", "true"));
        assertModifiers(modifiers(tree, 5, 1), a(ImpexParser.TextAttributeModifier), a("append"));
    }

    @Test
    public void typeModifiers() throws Exception {
        final ParseTree tree = init("/header/header-typemodifiers.impex");
        assertModifiers(modifiers(tree, 0), a(ImpexParser.BooleanHeaderModifier), a("true"));
        assertModifiers(modifiers(tree, 1), a(ImpexParser.BooleanHeaderModifier), a("true"));
        assertModifiers(modifiers(tree, 2), a(ImpexParser.BooleanHeaderModifier, ImpexParser.BooleanHeaderModifier), a("true", "false"));
        assertModifiers(modifiers(tree, 3),
                a(ImpexParser.ClassHeaderModifier, ImpexParser.BooleanHeaderModifier, ImpexParser.BooleanHeaderModifier),
                a("de.hybris.platform.impex.jalo.imp.DefaultImportProcessor", "true", "false"));
        assertModifiers(modifiers(tree, 4),
                a(ImpexParser.BooleanHeaderModifier, ImpexParser.BooleanHeaderModifier, ImpexParser.ClassHeaderModifier),
                a("true", "false", "de.hybris.platform.impex.jalo.imp.DefaultImportProcessor"));
        assertModifiers(modifiers(tree, 5),
                a(ImpexParser.BooleanHeaderModifier, ImpexParser.BooleanHeaderModifier, ImpexParser.ClassHeaderModifier),
                a("false", "true", "de.hybris.platform.impex.jalo.imp.DefaultImportProcessor"));
        assertModifiers(modifiers(tree, 6), a(ImpexParser.BooleanHeaderModifier, ImpexParser.BooleanHeaderModifier), a("false", "true"));
    }

    @Test
    public void specialAttribute() throws Exception {
        final ParseTree tree = init("/header/header-special-attribute.impex");
        final ParseTree attribute = attribute(tree, 0, 1);

        assertEquals("@media", attribute.getChild(0).getChild(0).getText());
        assertModifiers(modifiers(tree, 0, 1), a(ImpexParser.TextAttributeModifier), a("append"));
    }

    @Test
    public void quotedAttribute() throws Exception {
        final ParseTree tree = init("/header/header-quoted-attribute.impex");
        final ParseTree attribute = attribute(tree, 0, 0);

        assertEquals("uid", attribute.getChild(0).getChild(0).getText());
        assertModifiers(modifiers(tree, 0, 0), a(ImpexParser.BooleanAttributeModifier), a("true"));
    }

    @Test
    public void emptyAttributeModifier() throws Exception {
        final ParseTree tree = init("/header/header-emptymodifier.impex");
        assertModifier(modifier(tree, 0, 1, 1), ImpexParser.TextAttributeModifier);
    }

    /**
     * Check that for each block single header mode exist in a tree structure
     */
    @Test
    public void modes() throws Exception {
        final ParseTree tree = init("/header/header-modes.impex");
        assertHeaderMode(mode(tree, 0)/* , ImpexLexer.InsertUpdate, ImpexLexer.Update, ImpexLexer.Insert, ImpexLexer.Remove */);
        assertHeaderMode(mode(tree, 1)/* , ImpexLexer.Update, ImpexLexer.InsertUpdate, ImpexLexer.Insert, ImpexLexer.Remove */);
        assertHeaderMode(mode(tree, 2)/* , ImpexLexer.Insert, ImpexLexer.Update, ImpexLexer.InsertUpdate, ImpexLexer.Remove */);
        assertHeaderMode(mode(tree, 3)/* , ImpexLexer.Remove, ImpexLexer.Update, ImpexLexer.InsertUpdate, ImpexLexer.Insert */);
    }

    @Test
    public void modesCaseInsensitive() throws Exception {
        final ParseTree tree = init("/header/header-modes-case-insensitive.impex");
        assertHeaderMode(mode(tree, 0)/* , ImpexLexer.InsertUpdate */);
        assertHeaderMode(mode(tree, 1)/* , ImpexLexer.InsertUpdate */);
        assertHeaderMode(mode(tree, 2)/* , ImpexLexer.Update */);
        assertHeaderMode(mode(tree, 3)/* , ImpexLexer.Update */);
        assertHeaderMode(mode(tree, 4)/* , ImpexLexer.Insert */);
        assertHeaderMode(mode(tree, 5)/* , ImpexLexer.Insert */);
        assertHeaderMode(mode(tree, 6)/* , ImpexLexer.Remove */);
        assertHeaderMode(mode(tree, 7)/* , ImpexLexer.Remove */);
    }

    @Test
    public void headerTypeNames() throws Exception {
        final ParseTree tree = init("/header/header-typename.impex");
        assertHeaderType(type(tree, 0), "UserGroup");
        assertHeaderType(type(tree, 1), "Usergroup_123");
        assertHeaderType(type(tree, 2), "Insert");
        assertHeaderType(type(tree, 3), "insert");
        assertHeaderType(type(tree, 4), "cacheUnique");
        assertHeaderType(type(tree, 5), "mode");
    }

    private void assertModifiers(final List<ParseTree> modifiers, final int[] types, final String[] values) {
        assertEquals(types.length, modifiers.size());
        for (int i = 0; i < values.length; i++) {
            assertModifier(modifiers.get(i), types[i], values[i]);
        }
    }

    private void assertModifier(final ParseTree tree, final int type) {
        assertEquals(2, tree.getChildCount());
        final ParseTree modifier = tree.getChild(0);
        assertEquals(1, modifier.getChildCount());

        assertTrue(matchesType(modifier.getChild(0), type));
    }

    private void assertModifier(final ParseTree tree, final int type, final String value) {
        assertEquals(3, tree.getChildCount());
        final ParseTree modifier = tree.getChild(0);
        assertEquals(1, modifier.getChildCount());

        assertTrue(matchesType(modifier.getChild(0), type));
        assertEquals(value, tree.getChild(2).getText());
    }

    private void assertHeaderMode(final ParseTree tree) {
        assertTrue("Modes do not match", matchesType(tree, ImpexLexer.Mode));
    }

    //    private void assertHeaderMode(final ParseTree tree, final int mode, final int... invalidModes) {
    //        assertEquals(1, tree.getChildCount());
    //        final ParseTree header = tree.getChild(0);
    //        assertTrue("Modes do not match", matchesType(header, mode));
    //        for (final int invalidMode : invalidModes) {
    //            assertFalse("Modes do not match", matchesType(header, invalidMode));
    //        }
    //    }

    private void assertHeaderType(final ParseTree tree, final String name) {
        assertEquals(name, tree.getChild(0).getText());
    }

    private String[] a(final String... a) {
        return a;
    }

    private int[] a(final int... a) {
        return a;
    }
}
