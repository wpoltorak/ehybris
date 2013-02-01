package com.lambda.impex.ast;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.antlr.runtime.tree.CommonTree;
import org.junit.Test;

public class ParserErrorsTest extends ModelTest {

    @Test
    public void yy() throws Exception {
        final CommonTree tree = init("/errors/parser-lines-with-chars.impex");
        final List<ImpexProblem> errors = context.getProblems();
        assertEquals(2, errors.size());
        assertEquals("xxx", errors.get(0).getText());
        //      assertEquals("yyy", errors.get(1).getText());

        //        final Tree fields = fields(tree, 0, 1);
        //        assertEquals("othergroup", fields.getChild(0));
        //        assertEquals("lastgroup", fields.getChild(0));
    }
}
