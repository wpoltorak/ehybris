package com.lambda.impex.ast;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
        final ParseTree value = getChildWithType(attribute, ImpexParser.RULE_attributeValue);
        assertEquals(0, value.getChildCount());
    }

    @Test
    public void attributeModifiers() throws Exception {
        final ParseTree tree = init("/header/header-attributemodifiers.impex");
        assertModifiers(modifiers(tree, 0, 0), a(ImpexParser.BooleanAttributeModifier), a("true"));
        assertModifiers(modifiers(tree, 0, 1), a(ImpexParser.TextAttributeModifier), a("append"));

        assertModifiers(modifiers(tree, 1, 0), a(ImpexParser.BooleanAttributeModifier), a("true"));
        assertModifiers(modifiers(tree, 1, 1), a(ImpexParser.TextAttributeModifier, ImpexParser.TextAttributeModifier), a("append", ","));

        assertModifiers(modifiers(tree, 2, 0), a(ImpexParser.BooleanAttributeModifier), a("true"));
        assertModifiers(modifiers(tree, 2, 1),
                a(ImpexParser.TextAttributeModifier, ImpexParser.BooleanAttributeModifier, ImpexParser.TextAttributeModifier),
                a(",", "append", "customerGroup"));

        assertModifiers(modifiers(tree, 3, 0), a(ImpexParser.BooleanAttributeModifier, ImpexParser.ClassAttributeModifier),
                a("true", "de.hybris.platform.catalog.jalo.classification.eclass.EClassSuperCategoryDecorator"));
        assertModifiers(modifiers(tree, 3, 1), a(ImpexParser.BooleanAttributeModifier), a("append"));

        assertModifiers(modifiers(tree, 4, 0), a(ImpexParser.BooleanAttributeModifier, ImpexParser.BooleanAttributeModifier),
                a("true", "true"));
        assertModifiers(modifiers(tree, 4, 1), a(ImpexParser.BooleanAttributeModifier, ImpexParser.TextAttributeModifier),
                a("true", "append"));

        assertModifiers(
                modifiers(tree, 5, 0),
                a(ImpexParser.BooleanAttributeModifier, ImpexParser.BooleanAttributeModifier, ImpexParser.TextAttributeModifier,
                        ImpexParser.BooleanAttributeModifier, ImpexParser.BooleanAttributeModifier),
                a("true", "true", "en", "false", "true"));
        assertModifiers(modifiers(tree, 5, 1), a(ImpexParser.BooleanAttributeModifier), a("append"));
    }

    @Test
    public void typeModifiers() throws Exception {
        final ParseTree tree = init("/header/header-typemodifier.impex");
        assertModifiers(modifiers(tree, 0), a(ImpexParser.CacheUnique), a("true"));
        assertModifiers(modifiers(tree, 1), a(ImpexParser.CacheUnique), a("true"));
        assertModifiers(modifiers(tree, 2), a(ImpexParser.CacheUnique, ImpexParser.BatchMode), a("true", "false"));
        assertModifiers(modifiers(tree, 3), a(ImpexParser.Processor, ImpexParser.CacheUnique, ImpexParser.BatchMode),
                a("de.hybris.platform.impex.jalo.imp.DefaultImportProcessor", "true", "false"));
        assertModifiers(modifiers(tree, 4), a(ImpexParser.CacheUnique, ImpexParser.BatchMode, ImpexParser.Processor),
                a("true", "false", "de.hybris.platform.impex.jalo.imp.DefaultImportProcessor"));
        assertModifiers(modifiers(tree, 5), a(ImpexParser.BatchMode, ImpexParser.CacheUnique, ImpexParser.Processor),
                a("false", "true", "de.hybris.platform.impex.jalo.imp.DefaultImportProcessor"));
        assertModifiers(modifiers(tree, 6), a(ImpexParser.BatchMode, ImpexParser.BatchMode), a("false", "true"));
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
        assertModifier(modifier(tree, 0, 1, 1), ImpexParser.TextAttributeModifier, "");
    }

    /**
     * Check that for each block single header mode exist in a tree structure
     */
    @Test
    public void headerModes() throws Exception {
        final ParseTree tree = init("/header/header-modes.impex");
        assertHeaderMode(header(tree, 0), ImpexLexer.InsertUpdate, ImpexLexer.Update, ImpexLexer.Insert, ImpexLexer.Remove);
        assertHeaderMode(header(tree, 1), ImpexLexer.Update, ImpexLexer.InsertUpdate, ImpexLexer.Insert, ImpexLexer.Remove);
        assertHeaderMode(header(tree, 2), ImpexLexer.Insert, ImpexLexer.Update, ImpexLexer.InsertUpdate, ImpexLexer.Remove);
        assertHeaderMode(header(tree, 3), ImpexLexer.Remove, ImpexLexer.Update, ImpexLexer.InsertUpdate, ImpexLexer.Insert);
    }

    @Test
    public void headerModesCaseInsensitive() throws Exception {
        final ParseTree tree = init("/header/header-modes-case-insensitive.impex");
        assertHeaderMode(header(tree, 0), ImpexLexer.InsertUpdate);
        assertHeaderMode(header(tree, 1), ImpexLexer.InsertUpdate);
        assertHeaderMode(header(tree, 2), ImpexLexer.Update);
        assertHeaderMode(header(tree, 3), ImpexLexer.Update);
        assertHeaderMode(header(tree, 4), ImpexLexer.Insert);
        assertHeaderMode(header(tree, 5), ImpexLexer.Insert);
        assertHeaderMode(header(tree, 6), ImpexLexer.Remove);
        assertHeaderMode(header(tree, 7), ImpexLexer.Remove);
    }

    @Test
    public void headerTypeNames() throws Exception {
        final ParseTree tree = init("/header/header-typename.impex");
        assertHeaderType(header(tree, 0), "UserGroup");
        assertHeaderType(header(tree, 1), "Usergroup_123");
        assertHeaderType(header(tree, 2), "Insert");
        assertHeaderType(header(tree, 3), "insert");
        assertHeaderType(header(tree, 4), "cacheUnique");
        assertHeaderType(header(tree, 5), "mode");
    }

    @Test
    public void documentIDs() throws Exception {
        final ParseTree tree = init("/header/header-documentid.impex");
        //        final Set<String> documentIDs = context.getDocumentIDs();
        //        assertEquals(2, documentIDs.size());
        //        assertTrue(documentIDs.contains("&addrID"));
        //        assertTrue(documentIDs.contains("&addrID2"));

        ParseTree attribute = attribute(tree, 0, 2);
        //        final ParseTree itemExpr = getChildWithType(attribute, ImpexParser.ITEM_EXPRESSION);
        //        final ParseTree documentIDRef = getChildWithType(itemExpr, ImpexParser.ATTRIBUTE);
        //        assertEquals(1, documentIDRef.getChildCount());
        //        assertEquals("&addrID", documentIDRef.getChild(0).getText());

        attribute = attribute(tree, 1, 0);
        assertEquals(1, attribute.getChildCount());
        assertEquals("&addrID", attribute.getChild(0).getText());

        attribute = attribute(tree, 2, 1);
        assertEquals(1, attribute.getChildCount());
        assertEquals("&addrID2", attribute.getChild(0).getText());

    }

    private void assertModifiers(final List<ParseTree> modifiers, final int[] types, final String[] values) {
        assertEquals(types.length, modifiers.size());
        for (int i = 0; i < values.length; i++) {
            assertModifier(modifiers.get(i), types[i], values[i]);
        }
    }

    private void assertModifier(final ParseTree tree, final int type, final String value) {
        assertEquals(2, tree.getChildCount());
        final ParseTree modifier = tree.getChild(0);
        assertEquals(1, modifier.getChildCount());

        assertTrue(matchesType(modifier.getChild(0), type));
        assertEquals(value, tree.getChild(1).getText());
    }

    private void assertHeaderMode(final ParseTree header, final int mode, final int... invalidModes) {
        assertNotNull(getChildWithType(header, mode));
        for (final int invalidMode : invalidModes) {
            assertNull(getChildWithType(header, invalidMode));
        }
    }

    private void assertHeaderType(final ParseTree header, final String name) {
        assertEquals(name, header.getChild(1).getChild(0).getText());
    }

    private String[] a(final String... a) {
        return a;
    }

    private int[] a(final int... a) {
        return a;
    }
}
