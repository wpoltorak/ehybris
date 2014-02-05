package com.lambda.impex.ast;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class ParserErrorsTest extends ModelTest {

    @Test
    public void testWrongLinesWithChars() throws Exception {
        init("/errors/parser-lines-with-chars.impex");
        final List<ImpexProblem> errors = context.getProblems();
        assertEquals(2, errors.size());
        assertEquals("xxx", errors.get(0).getText());
        //      assertEquals("yyy", errors.get(1).getText());

        //        final Tree fields = fields(tree, 0, 1);
        //        assertEquals("othergroup", fields.getChild(0));
        //        assertEquals("lastgroup", fields.getChild(0));
    }

    @Test
    public void testInvalidSubtype() throws Exception {
        init("/errors/parser-invalid-subtype.impex");
        final List<ImpexProblem> errors = context.getProblems();
        assertEquals(1, errors.size());
        assertEquals("-1", errors.get(0).getText());
        //      assertEquals("yyy", errors.get(1).getText());

        //        final Tree fields = fields(tree, 0, 1);
        //        assertEquals("othergroup", fields.getChild(0));
        //        assertEquals("lastgroup", fields.getChild(0));
    }
}
