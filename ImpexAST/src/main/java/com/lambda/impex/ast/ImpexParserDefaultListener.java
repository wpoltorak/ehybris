// Generated from /work/projects/yeclipse/ImpexAST/src/main/antlr4/ImpexParser.g4 by ANTLR 4.1

package com.lambda.impex.ast;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
//import com.lambda.impex.ast.tree.*;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.lambda.impex.ast.ImpexParser.AttributeModifierAssignmentContext;
import com.lambda.impex.ast.ImpexParser.AttributeModifierContext;
import com.lambda.impex.ast.ImpexParser.HeaderModifierAssignmentContext;
import com.lambda.impex.ast.ImpexParser.MacroValueContext;
import com.lambda.impex.ast.ImpexParser.ModifierValueContext;
import com.lambda.impex.ast.ImpexParser.UnknownModifierContext;
import com.lambda.impex.ast.ImpexProblem.Type;

/**
 * This class provides an empty implementation of {@link ImpexParserListener}, which can be extended to create a listener which only needs
 * to handle a subset of the available methods.
 */
public class ImpexParserDefaultListener extends ImpexParserBaseListener {

    private static final Pattern separatorWithWhitespacePattern = Pattern.compile("([ \t]*)\\\\[ \t]*\r?[\n\r]([ \t]*)");
    private static final Pattern separatorPattern = Pattern.compile("\\\\[ \t]*\r?[\n\r]");
    private static final Pattern javaClassNamePattern = Pattern.compile("[A-Za-z_]+[a-zA-Z0-9_]*");
    private static final Set<String> javaKeywords = new HashSet<String>(Arrays.asList("abstract", "assert", "boolean", "break", "byte",
            "case", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "false", "final",
            "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new",
            "null", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch",
            "synchronized", "this", "throw", "throws", "transient", "true", "try", "void", "volatile", "while"));
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
        final MacroValueContext macroValue = ctx.macroValue();
        if (macroValue.getText().isEmpty()) {
            final ImpexProblem problem = new ImpexProblem(Type.InvalidMacroValue);
            problem.setLineNumber(ctx.getStart().getLine());
            problem.setLength(ctx.Macrodef().getSymbol().getStopIndex() - ctx.Macrodef().getSymbol().getStartIndex() + 1);
            problem.setText(macrodef);
            context.addProblem(problem);
        }

        context.registerMacro(macrodef, macroValue.getText(), ctx.Macrodef().getSymbol().getLine());
    }

    @Override
    public void enterAttributeModifierAssignment(final AttributeModifierAssignmentContext ctx) {
        final UnknownModifierContext unknownModifier = ctx.unknownModifier();
        if (unknownModifier != null) {
            final ImpexProblem problem = new ImpexProblem(Type.InvalidAttributeModifier);
            problem.setLineNumber(unknownModifier.getStart().getLine());
            problem.setLength(unknownModifier.getStop().getStopIndex() - unknownModifier.getStart().getStartIndex() - 1);
            problem.setText(unknownModifier.getText());
            context.addProblem(problem);
            return;
        }

        if (ctx.modifierValue() == null) {
            final AttributeModifierContext attributeModifier = ctx.attributeModifier();
            final ImpexProblem problem = new ImpexProblem(Type.InvalidAttributeModifier);
            problem.setLineNumber(attributeModifier.getStart().getLine());
            problem.setLength(attributeModifier.getStop().getStopIndex() - attributeModifier.getStart().getStartIndex());
            problem.setText(attributeModifier.getText());
            context.addProblem(problem);
            return;
        }

        final AttributeModifierContext attributeModifier = ctx.attributeModifier();
        final ModifierValueContext modifierval = ctx.modifierValue();
        switch (attributeModifier.getStart().getType()) {
            case ImpexLexer.BooleanHeaderModifier:
                //TODO resolve macros
                if (!Boolean.TRUE.toString().equalsIgnoreCase(modifierval.getText())
                        && !Boolean.FALSE.toString().equalsIgnoreCase(modifierval.getText())) {
                    final ImpexProblem problem = new ImpexProblem(Type.InvalidBoolean);
                    problem.setLineNumber(modifierval.getStart().getLine());
                    problem.setLength(modifierval.getStop().getStopIndex() - modifierval.getStart().getStartIndex());
                    problem.setText(modifierval.getText());
                    context.addProblem(problem);
                }
                break;
            case ImpexLexer.TextAttributeModifier:
                if ("mode".equalsIgnoreCase(attributeModifier.getText())) {
                    if (!"append".equalsIgnoreCase(modifierval.getText()) && !"remove".equalsIgnoreCase(modifierval.getText())) {
                        context.addProblem(new ImpexProblem(Type.InvalidMode));
                    }
                } else if ("lang".equalsIgnoreCase(attributeModifier.getText())) {
                    try {
                        Long.parseLong(modifierval.getText());
                    } catch (final NumberFormatException e) {
                        // is not a PK number so verify locale name
                        try {
                            toLocale(modifierval.getText());
                        } catch (final IllegalArgumentException ex) {
                            context.addProblem(new ImpexProblem(Type.InvalidLang));
                        }
                    }
                }
                break;
            case ImpexLexer.ClassAttributeModifier:
                if (!isJavaClassName(modifierval.getText())) {
                    context.addProblem(new ImpexProblem(Type.InvalidClassname));
                }
                break;
            case ImpexLexer.IntAttributeModifier:
                if ("pos".equalsIgnoreCase(attributeModifier.getText())) {
                    try {
                        final Integer pos = Integer.valueOf(modifierval.getText());
                        if (pos.intValue() < 0) {
                            context.addProblem(new ImpexProblem(Type.InvalidPosition));
                        }
                    } catch (final NumberFormatException e) {
                        context.addProblem(new ImpexProblem(Type.InvalidPosition));
                    }
                }
                break;
            case ImpexLexer.DateFormatAttributeModifier:
                try {
                    new SimpleDateFormat(modifierval.getText());
                } catch (final NullPointerException e) {
                    context.addProblem(new ImpexProblem(Type.InvalidDateFormat));
                } catch (final IllegalArgumentException e) {
                    context.addProblem(new ImpexProblem(Type.InvalidDateFormat));
                }
                break;
            case ImpexLexer.NumberFormatAttributeModifier:
                try {
                    new DecimalFormat(modifierval.getText());
                } catch (final NullPointerException e) {
                    context.addProblem(new ImpexProblem(Type.InvalidNumberFormat));
                } catch (final IllegalArgumentException e) {
                    context.addProblem(new ImpexProblem(Type.InvalidNumberFormat));
                }
                break;
        }
    }

    @Override
    public void enterHeaderModifierAssignment(final HeaderModifierAssignmentContext ctx) {
        if (ctx.modifierValue().getText().isEmpty()) {
            final ImpexProblem problem = new ImpexProblem(Type.InvalidHeaderModifier);
            final Token token = ctx.headerModifier().getStop();
            problem.setLineNumber(token.getLine());
            problem.setLength(token.getStopIndex() - token.getStartIndex());
            problem.setText(token.getText());
            context.addProblem(problem);
            return;
        }
        final ModifierValueContext modifierval = ctx.modifierValue();
        switch (ctx.headerModifier().getStart().getType()) {
            case ImpexLexer.BooleanHeaderModifier:
                //TODO resolve macros
                if (!Boolean.TRUE.toString().equalsIgnoreCase(modifierval.getText())
                        && !Boolean.FALSE.toString().equalsIgnoreCase(modifierval.getText())) {
                    final ImpexProblem problem = new ImpexProblem(Type.InvalidBoolean);
                    problem.setLineNumber(modifierval.getStart().getLine());
                    problem.setLength(modifierval.getStop().getStopIndex() - modifierval.getStart().getStartIndex() + 1);
                    problem.setText(modifierval.getText());
                    context.addProblem(problem);
                }
                break;
            case ImpexLexer.TextHeaderModifier:
                break;
            case ImpexLexer.ClassHeaderModifier:
                if (!isJavaClassName(modifierval.getText())) {
                    context.addProblem(new ImpexProblem(Type.InvalidClassname));
                }
                break;
        }
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

    private static String removeSeparators(final String text) {
        final Matcher m = separatorPattern.matcher(text);
        final StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, "");
        }
        m.appendTail(sb);
        return sb.toString();
    }

    private static String removeSeparatorsAndWhitespaces(final String text) {
        final Matcher m = separatorWithWhitespacePattern.matcher(text);
        final StringBuffer sb = new StringBuffer();
        while (m.find()) {
            final boolean noWhitespaceCaptured = m.group(1).isEmpty() && m.group(2).isEmpty();
            m.appendReplacement(sb, noWhitespaceCaptured ? "" : " ");
        }
        m.appendTail(sb);
        return sb.toString();
    }

    private static boolean isJavaClassName(final String text) {
        for (final String part : text.split("\\.")) {
            if (javaKeywords.contains(part) || !javaClassNamePattern.matcher(part).matches()) {
                return false;
            }
        }
        return text.length() > 0;
    }

    private Locale toLocale(final String str) {
        if (str == null) {
            throw new IllegalArgumentException("Invalid locale format: " + String.valueOf(str));
        }
        final int len = str.length();
        if (len != 2 && len != 5 && len < 7) {
            throw new IllegalArgumentException("Invalid locale format: " + str);
        }
        final char ch0 = str.charAt(0);
        final char ch1 = str.charAt(1);
        if (!Character.isLetter(ch0) || !Character.isLetter(ch1)) {
            throw new IllegalArgumentException("Invalid locale format: " + str);
        }
        if (len == 2) {
            return new Locale(str, "");
        } else {
            if (str.charAt(2) != '_') {
                throw new IllegalArgumentException("Invalid locale format: " + str);
            }
            final char ch3 = str.charAt(3);
            if (ch3 == '_') {
                return new Locale(str.substring(0, 2), "", str.substring(4));
            }
            final char ch4 = str.charAt(4);
            if (!Character.isLetter(ch3) || !Character.isLetter(ch4)) {
                throw new IllegalArgumentException("Invalid locale format: " + str);
            }
            if (len == 5) {
                return new Locale(str.substring(0, 2), str.substring(3, 5));
            } else {
                if (str.charAt(5) != '_') {
                    throw new IllegalArgumentException("Invalid locale format: " + str);
                }
                return new Locale(str.substring(0, 2), str.substring(3, 5), str.substring(6));
            }
        }
    }

}