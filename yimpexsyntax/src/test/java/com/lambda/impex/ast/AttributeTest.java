package com.lambda.impex.ast;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.lambda.impex.ast.ImpexProblem.Type;

public class AttributeTest {

    /**
     * Error if attribute couldn't be found
     * 
     * @throws Exception
     */
    @Test
    public void errorIfAttributeDoesNotExist() throws Exception {
        final TypeFinder finder = mock(TypeFinder.class);
        final TypeDescription townOwner = mock(TypeDescription.class);
        final TypeDescription townType = mock(TypeDescription.class);

        when(finder.findType("Address")).thenReturn(townOwner);
        when(finder.findType("TownType")).thenReturn(townType);
        when(townOwner.exists()).thenReturn(Boolean.TRUE);
        when(townOwner.containsField("Town")).thenReturn(Boolean.FALSE);
        when(townOwner.containsField("Town")).thenReturn(Boolean.FALSE);
        when(townOwner.getReturnType("Town")).thenReturn("TownType");
        when(townType.exists()).thenReturn(Boolean.TRUE);

        final DefaultImpexModel model = init("/attribute/AttributeTest1.impex", finder);

        assertEquals(1, model.getProblems().size());
        assertEquals(model.getProblems().get(0).getType(), Type.InvalidAttribute);
    }

    @Test
    public void noAttributeErrorsIfTypeDoesNotExist() throws Exception {
        final TypeFinder finder = mock(TypeFinder.class);
        final TypeDescription desc = mock(TypeDescription.class);

        when(finder.findType("Address")).thenReturn(desc);
        when(desc.exists()).thenReturn(Boolean.FALSE);
        when(desc.containsField("Town")).thenReturn(Boolean.FALSE);

        when(desc.sameAs(anyString())).thenReturn(true);

        final DefaultImpexModel model = init("/attribute/AttributeTest1.impex", finder);

        assertEquals(1, model.getProblems().size());
        assertEquals(model.getProblems().get(0).getType(), Type.InvalidType);
    }

    @Test
    public void noErrorsIfAttributeExists() throws Exception {
        final TypeFinder finder = mock(TypeFinder.class);
        final TypeDescription townOwner = mock(TypeDescription.class);
        final TypeDescription townType = mock(TypeDescription.class);

        when(finder.findType("Address")).thenReturn(townOwner);
        when(finder.findType("TownType")).thenReturn(townType);
        when(townOwner.exists()).thenReturn(Boolean.TRUE);
        when(townOwner.containsField("Town")).thenReturn(Boolean.TRUE);
        when(townOwner.getReturnType("Town")).thenReturn("TownType");
        when(townType.exists()).thenReturn(Boolean.TRUE);
        final DefaultImpexModel model = init("/attribute/AttributeTest1.impex", finder);

        assertFalse(model.hasProblems());
    }

    @Test
    public void errorIfAttributesTypeDoesNotExist() throws Exception {
        final TypeFinder finder = mock(TypeFinder.class);
        final TypeDescription addressType = mock(TypeDescription.class);
        final TypeDescription towndesc = mock(TypeDescription.class);

        when(finder.findType("Address")).thenReturn(addressType);
        when(finder.findType("Towndesc")).thenReturn(towndesc);
        when(addressType.exists()).thenReturn(Boolean.TRUE);
        when(addressType.containsField("Town")).thenReturn(Boolean.TRUE);
        when(addressType.getReturnType("Town")).thenReturn("Towndesc");

        when(towndesc.exists()).thenReturn(false);

        final DefaultImpexModel model = init("/attribute/AttributeTest1.impex", finder);

        assertEquals(1, model.getProblems().size());
        assertEquals(model.getProblems().get(0).getType(), Type.InvalidAttributeType);
    }

    @Test
    public void errorIfSubtypeDoesNotExist() throws Exception {
        final TypeFinder finder = mock(TypeFinder.class);
        final TypeDescription townOwner = mock(TypeDescription.class);
        final TypeDescription townType = mock(TypeDescription.class);
        final TypeDescription ownerType = mock(TypeDescription.class);
        final TypeDescription principalType = mock(TypeDescription.class);
        final TypeDescription abstractOrderType = mock(TypeDescription.class);
        final TypeDescription codeType = mock(TypeDescription.class);

        when(finder.findType("Address")).thenReturn(townOwner);
        when(finder.findType("Principal")).thenReturn(principalType);
        when(finder.findType("AbstractOrder")).thenReturn(abstractOrderType);
        when(townOwner.exists()).thenReturn(Boolean.TRUE);
        when(townOwner.containsField("Town")).thenReturn(Boolean.TRUE);
        when(townOwner.getReturnType("Town")).thenReturn("TownType");
        when(townOwner.containsField("owner")).thenReturn(Boolean.TRUE);
        when(townOwner.getReturnType("owner")).thenReturn("GenericType");
        when(ownerType.containsField("uid")).thenReturn(Boolean.TRUE);
        when(principalType.getReturnType("uid")).thenReturn("GnericType");
        //        when(abstractOrderType.getReturnType("code")).thenReturn(codeType);

        when(abstractOrderType.containsField("code")).thenReturn(false);

        when(ownerType.sameAs("Principal")).thenReturn(true);
        when(ownerType.sameAs("AbstractOrder")).thenReturn(false);
        when(townType.exists()).thenReturn(true);
        when(ownerType.exists()).thenReturn(true);
        when(codeType.exists()).thenReturn(true);
        when(abstractOrderType.exists()).thenReturn(true);
        when(ownerType.isParentOf("AbstractOrder")).thenReturn(true);

        final DefaultImpexModel model = init("/attribute/AttributeTest2.impex", finder);

        assertEquals(1, model.getProblems().size());
        assertEquals(Type.InvalidAttribute, model.getProblems().get(0).getType());
    }

    protected DefaultImpexModel init(final String name, final TypeFinder finder) throws Exception {
        final char[] source = IOUtils.toCharArray(getClass().getResourceAsStream(name));
        final DefaultImpexModel context = new DefaultImpexModel();
        final ImpexParserDefaultListener impexListener = new ImpexParserDefaultListener(context);
        impexListener.setTypeFinder(finder);
        final ImpexParserDefaultErrorListener errorListener = new ImpexParserDefaultErrorListener(context, true);

        final ImpexLexer lexer = new ImpexLexer(new ANTLRInputStream(source, source.length));
        lexer.removeErrorListeners();
        lexer.addErrorListener(errorListener);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final ImpexParser parser = new ImpexParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);
        final ParseTree impex = parser.impex();

        if (!context.hasProblems()) {
            final ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(impexListener, impex);
        }
        return context;
    }
}