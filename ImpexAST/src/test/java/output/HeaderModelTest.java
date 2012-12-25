package output;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.Tree;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

public class HeaderModelTest {

    /**
     * I check if empty attribute exists in a tree
     * 
     * @throws Exception
     */
    @Test
    public void testEmptyAttribute() throws Exception {
        final char[] impex = IOUtils.toCharArray(getClass().getResourceAsStream("/block/block-header-blank-attribute.impex"));
        final ImpexLexer lexer = new ImpexLexer(new ImpexANTLRStringStream(impex, impex.length));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        Tree tree = (Tree) new ImpexParser(tokens).impex().getTree();

        tree = getChildWithType(tree, ImpexParser.BLOCKS);
        tree = getChildWithType(tree, ImpexParser.BLOCK);
        tree = getChildWithType(tree, ImpexParser.HEADER);
        final List<Tree> attributesNodes = getChildrenWithType(tree, ImpexParser.ATTRIBUTES);
        assertEquals(1, attributesNodes.size());

        tree = attributesNodes.get(0);
        final List<Tree> attributeNodes = getChildrenWithType(tree, ImpexParser.ATTRIBUTE);
        assertEquals(3, attributeNodes.size());
        final Tree attribute = attributeNodes.get(1);
        assertEquals(0, attribute.getChildCount());
    }

    /**
     * I check if empty attribute exists in a tree
     * 
     * @throws Exception
     */
    @Test
    public void testEmptyField() throws Exception {
        final char[] impex = IOUtils.toCharArray(getClass().getResourceAsStream("/block/block-header-blank-attribute.impex"));
        final ImpexLexer lexer = new ImpexLexer(new ImpexANTLRStringStream(impex, impex.length));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        Tree tree = (Tree) new ImpexParser(tokens).impex().getTree();

        tree = getChildWithType(tree, ImpexParser.BLOCKS);
        tree = getChildWithType(tree, ImpexParser.BLOCK);
        tree = getChildWithType(tree, ImpexParser.HEADER);
        final List<Tree> attributesNodes = getChildrenWithType(tree, ImpexParser.ATTRIBUTES);
        assertEquals(1, attributesNodes.size());

        tree = attributesNodes.get(0);
        final List<Tree> attributeNodes = getChildrenWithType(tree, ImpexParser.ATTRIBUTE);
        assertEquals(3, attributeNodes.size());
        final Tree attribute = attributeNodes.get(1);
        assertEquals(0, attribute.getChildCount());
    }

    /**
     * I check that for each block single header mode exist in a tree structure
     * 
     * @throws Exception
     */
    @Test
    public void testHeaderModes() throws Exception {
        final char[] impex = IOUtils.toCharArray(getClass().getResourceAsStream("/block/block-header-modes.impex"));
        final ImpexLexer lexer = new ImpexLexer(new ImpexANTLRStringStream(impex, impex.length));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        Tree tree = (Tree) new ImpexParser(tokens).impex().getTree();
        assertEquals(1, tree.getChildCount());

        tree = getChildWithType(tree, ImpexParser.BLOCKS);
        final List<Tree> blockNodes = getChildrenWithType(tree, ImpexParser.BLOCK);
        assertHeaderMode(blockNodes.get(0), ImpexLexer.InsertUpdate, ImpexLexer.Update, ImpexLexer.Insert, ImpexLexer.Remove);
        assertHeaderMode(blockNodes.get(1), ImpexLexer.Update, ImpexLexer.InsertUpdate, ImpexLexer.Insert, ImpexLexer.Remove);
        assertHeaderMode(blockNodes.get(2), ImpexLexer.Insert, ImpexLexer.Update, ImpexLexer.InsertUpdate, ImpexLexer.Remove);
        assertHeaderMode(blockNodes.get(3), ImpexLexer.Remove, ImpexLexer.Update, ImpexLexer.InsertUpdate, ImpexLexer.Insert);
    }

    private void assertHeaderMode(final Tree block, final int mode, final int... invalidModes) {
        final List<Tree> headerNodes = getChildrenWithType(block, ImpexLexer.HEADER);
        assertEquals(1, headerNodes.size());
        assertNotNull(getChildWithType(headerNodes.get(0), mode));
        for (final int invalidMode : invalidModes) {
            assertNull(getChildWithType(headerNodes.get(0), invalidMode));
        }
    }

    private List<Tree> getChildrenWithType(final Tree tree, final int type) {
        final List<Tree> list = new ArrayList<Tree>();
        for (int i = 0; i < tree.getChildCount(); i++) {
            final Tree child = tree.getChild(i);
            if (type == child.getType()) {
                list.add(child);
            }
        }
        return list;
    }

    private Tree getChildWithType(final Tree tree, final int type) {
        for (int i = 0; i < tree.getChildCount(); i++) {
            final Tree child = tree.getChild(i);
            if (type == child.getType()) {
                return child;
            }
        }
        return null;
    }
}
