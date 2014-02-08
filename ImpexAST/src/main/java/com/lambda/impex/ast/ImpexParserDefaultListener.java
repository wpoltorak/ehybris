// Generated from /work/projects/yeclipse/ImpexAST/src/main/antlr4/ImpexParser.g4 by ANTLR 4.1

package com.lambda.impex.ast;

import java.util.regex.Matcher;
//import com.lambda.impex.ast.tree.*;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.lambda.impex.ast.ImpexProblem.Type;

/**
 * This class provides an empty implementation of {@link ImpexParserListener}, which can be extended to create a listener which only needs
 * to handle a subset of the available methods.
 */
public class ImpexParserDefaultListener extends ImpexParserBaseListener {

    private final Pattern separatorWithWhitespacePattern = Pattern.compile("([ \t]*)\\\\[ \t]*\r?[\n\r]([ \t]*)");
    private final Pattern separatorPattern = Pattern.compile("\\\\[ \t]*\r?[\n\r]");
    private final ImpexParseContext context;

    public ImpexParserDefaultListener(final ImpexParseContext context) {
        this.context = context;
    }

    /**
     * {@inheritDoc}
     * <p/>
     * The default implementation does nothing.
     */
    @Override
    public void enterMacro(@NotNull final ImpexParser.MacroContext ctx) {
        final String macrodef = removeSeparators(ctx.Macrodef().getText()); //remove possible separators from the middle of text
        String macroval;
        if (ctx.Macroval() == null) {
            final ImpexProblem problem = new ImpexProblem(Type.BlankMacro);
            problem.setLineNumber(ctx.Macrodef().getSymbol().getLine());
            problem.setLength(ctx.Macrodef().getSymbol().getStopIndex() - ctx.Macrodef().getSymbol().getStartIndex());
            problem.setText(macrodef);
            context.addProblem(problem);
            macroval = null;
        } else {
            macroval = removeSeparatorsAndWhitespaces(ctx.Macroval().getText()); //remove possible separators from the middle of text
        }
        context.registerMacro(macrodef, macroval, ctx.Macrodef().getSymbol().getLine());
    }

    /**
     * {@inheritDoc}
     * <p/>
     * The default implementation does nothing.
     */
    @Override
    public void exitMacro(@NotNull final ImpexParser.MacroContext ctx) {
    }

    /**
     * {@inheritDoc}
     * <p/>
     * The default implementation does nothing.
     */
    @Override
    public void enterImpex(@NotNull final ImpexParser.ImpexContext ctx) {
    }

    /**
     * {@inheritDoc}
     * <p/>
     * The default implementation does nothing.
     */
    @Override
    public void exitImpex(@NotNull final ImpexParser.ImpexContext ctx) {
    }

    /**
     * {@inheritDoc}
     * <p/>
     * The default implementation does nothing.
     */
    @Override
    public void enterEveryRule(@NotNull final ParserRuleContext ctx) {
    }

    /**
     * {@inheritDoc}
     * <p/>
     * The default implementation does nothing.
     */
    @Override
    public void exitEveryRule(@NotNull final ParserRuleContext ctx) {
    }

    /**
     * {@inheritDoc}
     * <p/>
     * The default implementation does nothing.
     */
    @Override
    public void visitTerminal(@NotNull final TerminalNode node) {
    }

    /**
     * {@inheritDoc}
     * <p/>
     * The default implementation does nothing.
     */
    @Override
    public void visitErrorNode(@NotNull final ErrorNode node) {
    }

    private String removeSeparators(final String text) {
        final Matcher m = separatorPattern.matcher(text);
        final StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, "");
        }
        m.appendTail(sb);
        return sb.toString();
    }

    private String removeSeparatorsAndWhitespaces(final String text) {
        final Matcher m = separatorWithWhitespacePattern.matcher(text);
        final StringBuffer sb = new StringBuffer();
        while (m.find()) {
            final boolean noWhitespaceCaptured = m.group(1).isEmpty() && m.group(2).isEmpty();
            m.appendReplacement(sb, noWhitespaceCaptured ? "" : " ");
        }
        m.appendTail(sb);
        return sb.toString();
    }
}