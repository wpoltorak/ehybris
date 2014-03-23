package com.lambda.impex.ast;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class ParserErrorsTest extends ModelTest {

    @Test
    public void testMacroAssWithoutEquals() throws Exception {
        init("/errors/macro/macro-no-equals.impex");
        final List<ImpexProblem> problems = context.getProblems();
        assertEquals(1, problems.size());
        assertEquals(ImpexProblem.Type.SyntaxError, problems.get(0).getType());
    }

    @Test
    public void testMacroAssBlankValue() throws Exception {
        init("/errors/macro/macro-blank.impex");
        final List<ImpexProblem> problems = context.getProblems();
        assertEquals(1, problems.size());
        assertEquals(ImpexProblem.Type.InvalidMacroValue, problems.get(0).getType());
    }

    @Test
    public void testMacroAssWithoutEqualsAndValue() throws Exception {
        init("/errors/macro/macro-blank-no-equals.impex");
        final List<ImpexProblem> problems = context.getProblems();
        assertEquals(1, problems.size());
        assertEquals(ImpexProblem.Type.SyntaxError, problems.get(0).getType());
    }

    @Test
    public void testWrongLinesWithChars() throws Exception {
        init("/errors/parser-lines-with-chars.impex");
        final List<ImpexProblem> errors = context.getProblems();
        assertEquals(1, errors.size());
        assertEquals(ImpexProblem.Type.SyntaxError, errors.get(0).getType());
    }

    @Test
    public void testInvalidSubtype() throws Exception {
        init("/errors/parser-invalid-subtype.impex");
        final List<ImpexProblem> errors = context.getProblems();
        assertEquals(1, errors.size());
        assertEquals(ImpexProblem.Type.SyntaxError, errors.get(0).getType());
        //      assertEquals("yyy", errors.get(1).getText());

        //        final Tree fields = fields(tree, 0, 1);
        //        assertEquals("othergroup", fields.getChild(0));
        //        assertEquals("lastgroup", fields.getChild(0));
    }
}
