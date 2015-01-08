package com.lambda.impex.ast;

import static org.junit.Assert.assertEquals;

import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

public class BlockModelTest extends ModelTest {

    @Test
    public void noRecordsInBlock() throws Exception {
        final ParseTree tree = init("/block/block-no-records.impex");
        assertEquals(2, getChildrenWithType(tree, ImpexParser.RULE_block).size());
        assertEquals(0, getChildrenWithType(block(tree, 0), ImpexParser.RULE_record).size());
        assertEquals(0, getChildrenWithType(block(tree, 1), ImpexParser.RULE_record).size());
    }
}
