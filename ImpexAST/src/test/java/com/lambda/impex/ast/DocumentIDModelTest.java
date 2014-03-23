package com.lambda.impex.ast;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Ignore;
import org.junit.Test;

//TODO fix failing doc id tests
public class DocumentIDModelTest extends ModelTest {

    @Test
    @Ignore
    public void documentIDs() throws Exception {
        final ParseTree tree = init("/header/header-documentid.impex");
        final Set<String> documentIDs = context.getDocumentIDs();
        assertEquals(2, documentIDs.size());
        assertTrue(documentIDs.contains("&addrID"));
        assertTrue(documentIDs.contains("&addrID2"));

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

}
