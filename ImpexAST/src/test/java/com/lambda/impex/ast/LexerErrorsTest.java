package com.lambda.impex.ast;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonTokenStream;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

public class LexerErrorsTest {

    @Test
    public void yy() throws Exception {
        final String impex = IOUtils.toString(getClass().getResourceAsStream("/errors/lexer-lines-with-chars.impex"));
        final ImpexContext context = new ImpexContext();
        final ImpexLexer lexer = new ImpexLexer(context, new ANTLRStringStream(impex));

        final CommonTokenStream tokens = new CommonTokenStream(lexer);

        // printTokens(tokens);
        System.out.println("__________________________");
        final ImpexParser parser = new ImpexParser(context, tokens);
        parser.impex().getTree();
        final List<ImpexError> errors = context.getErrors();
        assertEquals(2, errors.size());
    }
}
