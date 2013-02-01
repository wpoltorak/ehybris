package com.lambda.impex.ast;

import static org.junit.Assert.fail;

import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Test;


public class WalkerTest {

    @Test
    public void walkerDoesNotReportException() throws Exception {
        final char[] impexData = IOUtils.toCharArray(getClass().getResourceAsStream("/walker/user-groups.impex"));
        final ImpexCompiler compiler = new ImpexCompiler();
        compiler.setVisitor(new TestImpexVisitor());
        compiler.compile(impexData);
        assertHasNoGeneralSyntaxError(compiler.getContext().getProblems());
    }

    private void assertHasNoGeneralSyntaxError(final List<ImpexProblem> errors) {
        for (final ImpexProblem error : errors) {
            if (error.getType() == ImpexProblem.Type.GeneralSyntaxError) {
                fail(error.getText());
            }
        }
    }

    private class TestImpexVisitor extends ImpexVisitor {

    }
}
