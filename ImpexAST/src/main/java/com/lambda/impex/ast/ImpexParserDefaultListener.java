// Generated from /work/projects/yeclipse/ImpexAST/src/main/antlr4/ImpexParser.g4 by ANTLR 4.1

package com.lambda.impex.ast;

import java.util.regex.Matcher;
//import com.lambda.impex.ast.tree.*;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * This class provides an empty implementation of {@link ImpexParserListener}, which can be extended to create a listener which only needs
 * to handle a subset of the available methods.
 */
public class ImpexParserDefaultListener extends ImpexParserBaseListener {

    private final Pattern separatorWithWhitespacePattern = Pattern.compile("([ \t]*)\\\\[ \t]*\r?[\n\r]([ \t]*)");
    private final Pattern separatorPattern = Pattern.compile("\\\\[ \t]*\r?[\n\r]");
    private ImpexContext context = new ImpexContext();

    /**
     * {@inheritDoc}
     * <p/>
     * The default implementation does nothing.
     */
    @Override
    public void enterMacro(@NotNull final ImpexParser.MacroContext ctx) {
        final String macrodef = removeSeparators(ctx.Macrodef().getText()); //remove possible separators from the middle of text

        String macroval = ctx.Macroval().getText();
        macroval = macroval.substring(1, macroval.length()).trim(); //remove leading equals character and trim to remove any surrounding spaces
        macroval = removeSeparatorsAndWhitespaces(macroval); //remove possible separators from the middle of text

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
        context = new ImpexContext();
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

    public ImpexContext getContext() {
        return context;
    }
}