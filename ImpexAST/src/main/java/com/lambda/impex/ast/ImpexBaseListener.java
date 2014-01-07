// Generated from /work/projects/yeclipse/ImpexAST/src/main/antlr4/Impex.g4 by ANTLR 4.1

 package com.lambda.impex.ast;
V

import java.util.ArrayList;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
//import com.lambda.impex.ast.tree.*;


import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * This class provides an empty implementation of {@link ImpexListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class ImpexBaseListener implements ImpexListener {
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation does nothing.
	 */
	@Override public void enterMacro(@NotNull ImpexParser.MacroContext ctx) { }
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation does nothing.
	 */
	@Override public void exitMacro(@NotNull ImpexParser.MacroContext ctx) { }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation does nothing.
	 */
	@Override public void enterImpex(@NotNull ImpexParser.ImpexContext ctx) { }
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation does nothing.
	 */
	@Override public void exitImpex(@NotNull ImpexParser.ImpexContext ctx) { }

	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation does nothing.
	 */
	@Override public void enterEveryRule(@NotNull ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation does nothing.
	 */
	@Override public void exitEveryRule(@NotNull ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation does nothing.
	 */
	@Override public void visitTerminal(@NotNull TerminalNode node) { }
	/**
	 * {@inheritDoc}
	 * <p/>
	 * The default implementation does nothing.
	 */
	@Override public void visitErrorNode(@NotNull ErrorNode node) { }
}