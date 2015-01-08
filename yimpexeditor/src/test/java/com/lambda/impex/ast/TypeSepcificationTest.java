package com.lambda.impex.ast;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.lambda.impex.ast.ImpexProblem.Type;

public class TypeSepcificationTest {

    /**
     * Error if base type couldn't be found
     * 
     * @throws Exception
     */
    @Test
    public void baseTypeDoesNotExist() throws Exception {
        final TypeFinder finder = mock(TypeFinder.class);
        final TypeDescription desc = mock(TypeDescription.class);
        final TypeDescription childdesc = mock(TypeDescription.class);

        when(finder.findType("User")).thenReturn(desc);
        when(finder.findType("ChildType")).thenReturn(childdesc);
        when(desc.exists()).thenReturn(Boolean.FALSE);
        when(desc.containsField("uid")).thenReturn(Boolean.TRUE);
        when(desc.getReturnType("uid")).thenReturn("ChildType");

        final DefaultImpexModel model = init("/typespecification/TypeSpecificationTest1.impex", finder);

        assertEquals(1, model.getProblems().size());
        assertEquals(model.getProblems().get(0).getType(), Type.InvalidType);
    }

    /**
     * If type is not abstract there is no error reported for rows without type specification
     * 
     * @throws Exception
     */
    @Test
    public void typeSpecificationNoSubtype() throws Exception {
        final TypeFinder finder = mock(TypeFinder.class);
        final TypeDescription desc = mock(TypeDescription.class);
        final TypeDescription childdesc = mock(TypeDescription.class);

        when(finder.findType("User")).thenReturn(desc);
        when(finder.findType("ChildType")).thenReturn(childdesc);
        when(desc.exists()).thenReturn(Boolean.TRUE);
        when(desc.isAbstract()).thenReturn(Boolean.FALSE);
        when(desc.isParentOf("Customer")).thenReturn(Boolean.TRUE);
        when(desc.containsField("uid")).thenReturn(Boolean.TRUE);
        when(desc.getReturnType("uid")).thenReturn("ChildType");

        final DefaultImpexModel model = init("/typespecification/TypeSpecificationTest2.impex", finder);
        assertTrue(model.getProblems().isEmpty());
    }

    /**
     * If type is abstract there is an error reported for each row without type specification
     * 
     * @throws Exception
     */
    @Test
    public void abstractTypeSpecificationNoSubtype() throws Exception {
        final TypeFinder finder = mock(TypeFinder.class);
        final TypeDescription desc = mock(TypeDescription.class);
        final TypeDescription childdesc = mock(TypeDescription.class);

        when(finder.findType("User")).thenReturn(desc);
        when(finder.findType("ChildType")).thenReturn(childdesc);
        when(desc.exists()).thenReturn(Boolean.TRUE);
        when(desc.isAbstract()).thenReturn(Boolean.TRUE);
        when(desc.isParentOf("Customer")).thenReturn(Boolean.TRUE);
        when(desc.containsField("uid")).thenReturn(Boolean.TRUE);
        when(desc.getReturnType("uid")).thenReturn("ChildType");

        final DefaultImpexModel model = init("/typespecification/TypeSpecificationTest2.impex", finder);
        assertEquals(1, model.getProblems().size());
        assertEquals(model.getProblems().get(0).getType(), Type.SubtypeRequired);
    }

    /**
     * For each subtype that is not a child of the base type an error is reported
     * 
     * @throws Exception
     */
    @Test
    public void typeSpecificationSubtypeNotInHierarchy() throws Exception {
        final TypeFinder finder = mock(TypeFinder.class);
        final TypeDescription desc = mock(TypeDescription.class);
        final TypeDescription childdesc = mock(TypeDescription.class);

        when(finder.findType("User")).thenReturn(desc);
        when(finder.findType("ChildType")).thenReturn(childdesc);
        when(desc.exists()).thenReturn(Boolean.TRUE);
        when(desc.isAbstract()).thenReturn(Boolean.FALSE);
        when(desc.isParentOf("Customer")).thenReturn(Boolean.FALSE);
        when(desc.containsField("uid")).thenReturn(Boolean.TRUE);
        when(desc.getReturnType("uid")).thenReturn("ChildType");

        final DefaultImpexModel model = init("/typespecification/TypeSpecificationTest2.impex", finder);
        assertEquals(1, model.getProblems().size());
        assertEquals(model.getProblems().get(0).getType(), Type.InvalidSubtype);
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
