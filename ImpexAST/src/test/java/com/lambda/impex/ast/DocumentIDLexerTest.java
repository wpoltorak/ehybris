package com.lambda.impex.ast;

import java.util.List;

import org.antlr.v4.runtime.Token;
import org.junit.Ignore;
import org.junit.Test;

//TODO fix failing doc id tests
public class DocumentIDLexerTest extends AbstractLexerTest {

    @Test
    @Ignore
    public void testHeaderDocumentIDAttribute() throws Exception {
        final List<Token> tokens = init("/documentid/header-documentid.impex");
        Attribute[] attribs = new Attribute[] { attribute(expression("uid"), modifiers(modifier("unique", "=true"))), null,
                attribute(expression("defaultPaymentAddress", expression("&addrID"))) };

        Header header = header(ImpexLexer.Insert, "Customer", attribs);
        int index = 0;
        index = header.assertTokens(tokens, index);
        index += 5; // data row

        attribs = new Attribute[] { attribute(expression("&addrID")), attribute(expression("owner", expression("Customer", "uid"))), null };

        header = header(ImpexLexer.Insert, "Address", attribs);
        index = header.assertTokens(tokens, index);
        index += 3; // data row

        attribs = new Attribute[] { attribute(expression("owner", expression("Customer", "uid"))), attribute(expression("&addrID2")) };
        header = header(ImpexLexer.Insert, "Address", attribs);
        header.assertTokens(tokens, index);
    }

}
