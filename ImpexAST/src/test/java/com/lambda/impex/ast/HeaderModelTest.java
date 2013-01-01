package com.lambda.impex.ast;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Set;

import org.antlr.runtime.tree.Tree;
import org.junit.Test;

import com.lambda.impex.ast.ImpexLexer;
import com.lambda.impex.ast.ImpexParser;

public class HeaderModelTest extends ModelTest {

    @Test
    public void attributesNodeIsSingle() throws Exception {
        Tree tree = init("/header/header-blank-attribute.impex");
        tree = header(tree, 0);
        final List<Tree> attributesNodes = getChildrenWithType(tree, ImpexParser.ATTRIBUTES);
        assertEquals(1, attributesNodes.size());
    }

    @Test
    public void headerNodeIsSingle() throws Exception {
        Tree tree = init("/header/header-blank-attribute.impex");
        tree = block(tree, 0);
        final List<Tree> attributesNodes = getChildrenWithType(tree, ImpexParser.HEADER);
        assertEquals(1, attributesNodes.size());
    }

    @Test
    public void emptyAttributeExistsInTree() throws Exception {
        final Tree tree = init("/header/header-blank-attribute.impex");

        Tree attributes = attributes(tree, 0);
        List<Tree> attributeNodes = getChildrenWithType(attributes, ImpexParser.ATTRIBUTE);
        assertEquals(3, attributeNodes.size());
        assertEmptyAttribute(attributeNodes.get(1));

        attributes = attributes(tree, 1);
        attributeNodes = getChildrenWithType(attributes, ImpexParser.ATTRIBUTE);
        assertEquals(3, attributeNodes.size());
        assertEmptyAttribute(attributeNodes.get(1));

    }

    private void assertEmptyAttribute(final Tree attribute) {
        assertEquals(3, attribute.getChildCount());
        assertEquals(0, getChildWithType(attribute, ImpexParser.ATTRIBUTE_NAME).getChildCount());
        assertEquals(0, getChildWithType(attribute, ImpexParser.MODIFIERS).getChildCount());
        final Tree itemExpr = getChildWithType(attribute, ImpexParser.ITEM_EXPRESSION);
        assertEquals(1, itemExpr.getChildCount());
        assertEquals(ImpexParser.DOCUMENTID_REF, itemExpr.getChild(0).getType());
        assertEquals(0, itemExpr.getChild(0).getChildCount());
    }

    @Test
    public void attributeModifiersIsSingleNode() throws Exception {
        final Tree tree = init("/header/header-attributemodifiers.impex");
        assertEquals(1, getChildrenWithType(attribute(tree, 1, 1), ImpexParser.MODIFIERS).size());
        assertEquals(1, getChildrenWithType(attribute(tree, 2, 1), ImpexParser.MODIFIERS).size());
        assertEquals(1, getChildrenWithType(attribute(tree, 3, 0), ImpexParser.MODIFIERS).size());
    }

    @Test
    public void attributeModifiers() throws Exception {
        final Tree tree = init("/header/header-attributemodifiers.impex");
        assertModifiers(modifiers(tree, 0, 0), a(ImpexParser.Unique), a("true"));
        assertModifiers(modifiers(tree, 0, 1), a(ImpexParser.Mode), a("append"));

        assertModifiers(modifiers(tree, 1, 0), a(ImpexParser.Unique), a("true"));
        assertModifiers(modifiers(tree, 1, 1), a(ImpexParser.Mode, ImpexParser.CollectionDelimiter), a("append", ","));

        assertModifiers(modifiers(tree, 2, 0), a(ImpexParser.Unique), a("true"));
        assertModifiers(modifiers(tree, 2, 1), a(ImpexParser.CollectionDelimiter, ImpexParser.Mode, ImpexParser.Default),
                a(",", "append", "customerGroup"));

        assertModifiers(modifiers(tree, 3, 0), a(ImpexParser.Unique, ImpexParser.CellDecorator),
                a("true", "de.hybris.platform.catalog.jalo.classification.eclass.EClassSuperCategoryDecorator"));
        assertModifiers(modifiers(tree, 3, 1), a(ImpexParser.Mode), a("append"));

        assertModifiers(modifiers(tree, 4, 0), a(ImpexParser.Unique, ImpexParser.ForceWrite), a("true", "true"));
        assertModifiers(modifiers(tree, 4, 1), a(ImpexParser.IgnoreKeyCase, ImpexParser.Mode), a("true", "append"));

        assertModifiers(modifiers(tree, 5, 0),
                a(ImpexParser.Unique, ImpexParser.IgnoreNull, ImpexParser.Lang, ImpexParser.Virtual, ImpexParser.IgnoreNull),
                a("true", "true", "en", "false", "true"));
        assertModifiers(modifiers(tree, 5, 1), a(ImpexParser.Mode), a("append"));
    }

    @Test
    public void typeModifiers() throws Exception {
        final Tree tree = init("/header/header-typemodifiers.impex");
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
        final Tree tree = init("/header/header-special-attribute.impex");
        final Tree attribute = attribute(tree, 0, 1);

        assertEquals("@media", attribute.getChild(0).getChild(0).getText());
        assertModifiers(modifiers(tree, 0, 1), a(ImpexParser.Mode), a("append"));
    }

    @Test
    public void quotedAttribute() throws Exception {
        final Tree tree = init("/header/header-quoted-attribute.impex");
        final Tree attribute = attribute(tree, 0, 0);

        assertEquals("uid", attribute.getChild(0).getChild(0).getText());
        assertModifiers(modifiers(tree, 0, 0), a(ImpexParser.Unique), a("true"));
    }

    @Test
    public void emptyAttributeModifier() throws Exception {
        final Tree tree = init("/header/header-emptymodifier.impex");
        assertModifier(modifier(tree, 0, 1, 1), ImpexParser.Default, "");
    }

    /**
     * Check that for each block single header mode exist in a tree structure
     */
    @Test
    public void headerModes() throws Exception {
        final Tree tree = init("/header/header-modes.impex");
        assertHeaderMode(header(tree, 0), ImpexLexer.InsertUpdate, ImpexLexer.Update, ImpexLexer.Insert, ImpexLexer.Remove);
        assertHeaderMode(header(tree, 1), ImpexLexer.Update, ImpexLexer.InsertUpdate, ImpexLexer.Insert, ImpexLexer.Remove);
        assertHeaderMode(header(tree, 2), ImpexLexer.Insert, ImpexLexer.Update, ImpexLexer.InsertUpdate, ImpexLexer.Remove);
        assertHeaderMode(header(tree, 3), ImpexLexer.Remove, ImpexLexer.Update, ImpexLexer.InsertUpdate, ImpexLexer.Insert);
    }

    @Test
    public void headerModesCaseInsensitive() throws Exception {
        final Tree tree = init("/header/header-modes-case-insensitive.impex");
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
        final Tree tree = init("/header/header-typename.impex");
        assertHeaderType(header(tree, 0), "UserGroup");
        assertHeaderType(header(tree, 1), "Usergroup_123");
        assertHeaderType(header(tree, 2), "Insert");
        assertHeaderType(header(tree, 3), "insert");
        assertHeaderType(header(tree, 4), "cacheUnique");
        assertHeaderType(header(tree, 5), "mode");
    }

    @Test
    public void documentIDs() throws Exception {
        final Tree tree = init("/header/header-documentid.impex");
        final Set<String> documentIDs = parser.getDocumentIDs();
        assertEquals(2, documentIDs.size());
        assertTrue(documentIDs.contains("&addrID"));
        assertTrue(documentIDs.contains("&addrID2"));

        final Tree attribute = attribute(tree, 0, 2);
        final Tree itemExpr = getChildWithType(attribute, ImpexParser.ITEM_EXPRESSION);
        final Tree documentIDRef = getChildWithType(itemExpr, ImpexParser.DOCUMENTID_REF);
        assertEquals(1, documentIDRef.getChildCount());
        assertEquals("&addrID", documentIDRef.getChild(0).getText());
    }

    private void assertModifiers(final Tree modifiers, final int[] types, final String[] values) {
        assertEquals(types.length, modifiers.getChildCount());
        for (int i = 0; i < values.length; i++) {
            assertModifier(modifiers.getChild(i), types[i], values[i]);
        }
    }

    private void assertModifier(final Tree modifier, final int type, final String value) {
        assertEquals(2, modifier.getChildCount());
        assertEquals(type, modifier.getChild(0).getType());
        assertEquals(value, modifier.getChild(1).getText());
    }

    private void assertHeaderMode(final Tree header, final int mode, final int... invalidModes) {
        assertNotNull(getChildWithType(header, mode));
        for (final int invalidMode : invalidModes) {
            assertNull(getChildWithType(header, invalidMode));
        }
    }

    private void assertHeaderType(final Tree header, final String name) {
        assertEquals(name, header.getChild(1).getChild(0).getText());
    }

    private String[] a(final String... a) {
        return a;
    }

    private int[] a(final int... a) {
        return a;
    }
}
