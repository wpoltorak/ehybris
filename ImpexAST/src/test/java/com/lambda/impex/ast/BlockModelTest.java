package com.lambda.impex.ast;

import static org.junit.Assert.assertEquals;

import org.antlr.runtime.tree.Tree;
import org.junit.Test;

public class BlockModelTest extends ModelTest {

    @Test
    public void noRecordsInBlock() throws Exception {
        final Tree tree = init("/block/block-no-records.impex");
        assertEquals(2, blocks(tree).getChildCount());
        assertEquals(0, records(tree, 0).getChildCount());
        assertEquals(0, records(tree, 1).getChildCount());
    }
}
