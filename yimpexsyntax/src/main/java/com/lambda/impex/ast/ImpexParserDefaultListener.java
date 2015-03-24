// Generated from /work/projects/yeclipse/ImpexAST/src/main/antlr4/ImpexParser.g4 by ANTLR 4.1

package com.lambda.impex.ast;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
//import com.lambda.impex.ast.tree.*;
import java.util.regex.Pattern;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;

import com.lambda.impex.ast.ImpexParser.AttributeContext;
import com.lambda.impex.ast.ImpexParser.AttributeModifierAssignmentContext;
import com.lambda.impex.ast.ImpexParser.AttributeModifierContext;
import com.lambda.impex.ast.ImpexParser.BlockContext;
import com.lambda.impex.ast.ImpexParser.DocumentIdDefinitionContext;
import com.lambda.impex.ast.ImpexParser.DocumentIdFieldContext;
import com.lambda.impex.ast.ImpexParser.DocumentIdRefFieldContext;
import com.lambda.impex.ast.ImpexParser.DocumentIdReferenceContext;
import com.lambda.impex.ast.ImpexParser.EmptyAttributeContext;
import com.lambda.impex.ast.ImpexParser.FieldContext;
import com.lambda.impex.ast.ImpexParser.HeaderContext;
import com.lambda.impex.ast.ImpexParser.HeaderModifierAssignmentContext;
import com.lambda.impex.ast.ImpexParser.HeaderTypeNameContext;
import com.lambda.impex.ast.ImpexParser.MacroValueContext;
import com.lambda.impex.ast.ImpexParser.MacrorefAttributeContext;
import com.lambda.impex.ast.ImpexParser.MacrorefContext;
import com.lambda.impex.ast.ImpexParser.ModifierValueContext;
import com.lambda.impex.ast.ImpexParser.RecordContext;
import com.lambda.impex.ast.ImpexParser.SimpleAttributeContext;
import com.lambda.impex.ast.ImpexParser.SimpleAttributeNameContext;
import com.lambda.impex.ast.ImpexParser.SpecialAttributeContext;
import com.lambda.impex.ast.ImpexParser.SubtypeAttributeContext;
import com.lambda.impex.ast.ImpexParser.SubtypeAttributeNameContext;
import com.lambda.impex.ast.ImpexParser.UnknownModifierContext;
import com.lambda.impex.ast.ImpexProblem.Type;

/**
 * This class provides an empty implementation of {@link ImpexParserListener}, which can be extended to create a listener which only needs
 * to handle a subset of the available methods.
 */
public class ImpexParserDefaultListener extends ImpexParserBaseListener {

    private static final Pattern javaClassNamePattern = Pattern.compile("[A-Za-z_]+[a-zA-Z0-9_]*");

    private static final Set<String> javaKeywords = new HashSet<String>(Arrays.asList("abstract", "assert", "boolean", "break", "byte",
            "case", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "false", "final",
            "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new",
            "null", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch",
            "synchronized", "this", "throw", "throws", "transient", "true", "try", "void", "volatile", "while"));

    private final HashMap<String, String> currentMacros = new HashMap<>();

    private final List<String> supportedModes = Arrays.asList("append", "remove");
    private TypeFinder typeFinder;
    private TypeDescription typeDescription;
    private final List<ColumnDescription> columnDescriptions = new ArrayList<>();
    private final ImpexModel context;
    private int columnIndex;
    private ColumnDescription currentColumnDescription;
    private int level = 0;

    public ImpexParserDefaultListener(final ImpexModel context) {
        this.context = context;
    }

    public void setTypeFinder(final TypeFinder typeFinder) {
        this.typeFinder = typeFinder;
    }

    /**
     * Returns last processed column description
     *
     * @return
     */
    ColumnDescription getColumnDescription() {
        return columnDescriptions.isEmpty() ? null : columnDescriptions.get(columnDescriptions.size() - 1);
    }

    /**
     * {@inheritDoc}
     * <p/>
     * The default implementation does nothing.
     */
    @Override
    public void enterMacro(@NotNull final ImpexParser.MacroContext ctx) {
        final MacroValueContext macroValue = ctx.macroValue();

        final TerminalNode macrodef = ctx.Macrodef();
        if (macroValue.getText().isEmpty()) {
            context.addProblem(problem(macrodef.getSymbol(), Type.EmptyMacroValue));
            final String macrodefText = macrodef.getText();
            currentMacros.put(macrodefText, "");
            return;
        }
        final String macrodefText = macrodef.getText();
        final String macrovalue = getText(macroValue);
        currentMacros.put(macrodefText, macrovalue);
        context.addMacroValue(macrodefText, macrodef.getSymbol(), macroValue);
    }

    @Override
    public void enterHeaderTypeName(final HeaderTypeNameContext ctx) {
        final String typename = getText(ctx);
        typeDescription = typeFinder.findBySimpleName(typename);
        if (ctx.Type() != null) {
            context.addType(typeDescription, ctx.Type().getSymbol());
        }
        if (!typeDescription.exists()) {
            context.addProblem(problem(ctx, Type.InvalidType));
        }
    }

    @Override
    public void enterHeader(final HeaderContext ctx) {
        columnIndex = -1;
        columnDescriptions.clear();
    }

    @Override
    public void enterAttribute(final AttributeContext ctx) {
        columnIndex++;
        //        if (ctx.macroref() != null) {
        //            final String text = resolveMacroreferences(ctx.children);
        //            final ImpexLexer lexer = new ImpexLexer(new ANTLRInputStream(text));
        //            lexer.removeErrorListeners();
        //            lexer._mode = ImpexLexer.attribute;
        //            final CommonTokenStream tokens = new CommonTokenStream(lexer);
        //            final ImpexParser parser = new ImpexParser(tokens);
        //            parser.removeErrorListeners();
        //            final AttributeContext attribute = parser.attribute();
        //            final DefaultImpexModel model = new DefaultImpexModel();
        //            final ImpexParserDefaultListener listener = new ImpexParserDefaultListener(model);
        //            final ParseTreeWalker walker = new ParseTreeWalker();
        //            walker.walk(listener, attribute);
        //            if (model.hasProblems()) {
        //                System.out.println();
        //            }
        //        }
    }

    @Override
    public void exitAttribute(final AttributeContext ctx) {
        columnDescriptions.add(currentColumnDescription);
        currentColumnDescription = null;
    }

    @Override
    public void enterMacrorefAttribute(final MacrorefAttributeContext ctx) {
        final String text = resolveMacroreference(ctx.macroref());
        final ImpexLexer lexer = new ImpexLexer(new ANTLRInputStream(text));
        lexer.removeErrorListeners();
        lexer.pushMode(ImpexLexer.attribute);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);

        final ImpexParser parser = new ImpexParser(tokens);
        parser.removeErrorListeners();
        final AttributeContext attribute = parser.attribute();
        final DefaultImpexModel model = new DefaultImpexModel();
        final ImpexParserDefaultListener listener = new ImpexParserDefaultListener(model);
        listener.typeDescription = typeDescription;
        listener.typeFinder = typeFinder;

        final ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, attribute);
        if (model.hasProblems()) {
            for (final ImpexProblem problem : model.getProblems()) {
                context.addProblem(problem(ctx.macroref(), ImpexProblem.Type.InvalidMacroEvaluation, getText(ctx.macroref())));
                System.out.println();
            }

        }
        currentColumnDescription = listener.getColumnDescription();
    }

    @Override
    public void enterDocumentIdReference(final DocumentIdReferenceContext ctx) {
        currentColumnDescription = new DefaultColumnDescription(typeDescription);
        currentColumnDescription.setDocumentID(getText(ctx.DocumentID()));
    }

    @Override
    public void enterDocumentIdDefinition(final DocumentIdDefinitionContext ctx) {
        currentColumnDescription = new DefaultColumnDescription(typeDescription);
        currentColumnDescription.setDocumentID(getText(ctx.DocumentID()));
    }

    @Override
    public void enterEmptyAttribute(final EmptyAttributeContext ctx) {
        currentColumnDescription = new DefaultColumnDescription();
    }

    @Override
    public void enterSpecialAttribute(final SpecialAttributeContext ctx) {
        currentColumnDescription = new DefaultColumnDescription(typeDescription);
    }

    @Override
    public void enterSimpleAttribute(final SimpleAttributeContext ctx) {
        currentColumnDescription = new DefaultColumnDescription(typeDescription);
    }

    @Override
    public void exitSimpleAttribute(final SimpleAttributeContext ctx) {
        if (currentColumnDescription.hasParent()) {
            currentColumnDescription = currentColumnDescription.getParent();
        }
    }

    @Override
    public void enterSubtypeAttribute(final SubtypeAttributeContext ctx) {
        level++;
        currentColumnDescription = new DefaultColumnDescription(currentColumnDescription);
    }

    @Override
    public void exitSubtypeAttribute(final SubtypeAttributeContext ctx) {
        level--;
        currentColumnDescription = currentColumnDescription.getParent();
        super.exitSubtypeAttribute(ctx);
    }

    @Override
    public void enterSimpleAttributeName(final SimpleAttributeNameContext ctx) {
        final String name = getText(ctx);
        final TypeDescription owner = currentColumnDescription.getOwner();
        if (owner == null) {
            // already reported InvalidAttribute error in enterSimpleAttributeName(method)
            return;
        }
        if (owner.exists() && !owner.containsField(name)) {
            context.addProblem(problem(ctx, Type.InvalidAttribute));
        } else {
            final TypeDescription returnType = typeFinder.findType(owner.getReturnType(name));
            currentColumnDescription.setType(returnType);
        }
    }

    @Override
    public void enterSubtypeAttributeName(final SubtypeAttributeNameContext ctx) {
        final Token subtypeNameCtx = ctx.type;
        final Token attributeNameCtx = ctx.name;
        final String subtypeName = getText(subtypeNameCtx);
        final String attributeName = attributeNameCtx.getText();

        final TypeDescription type = currentColumnDescription.getType();
        if (type == null) {
            // already reported InvalidAttribute error in enterSimpleAttributeName(method)
            return;
        }

        final boolean isSame = subtypeName == null || type.sameAs(subtypeName);
        if (isSame) {
            if (!type.containsField(attributeName)) {
                context.addProblem(problem(attributeNameCtx, Type.InvalidAttribute));
            }
            return;
        }

        final TypeDescription subtype = typeFinder.findBySimpleName(subtypeName);
        if (!subtype.exists()) {
            context.addProblem(problem(subtypeNameCtx, Type.InvalidType));
            //jesli typ attr(Typ.uid)
        } else if (!subtype.isChildOf(type.getName())) {
            context.addProblem(problem(subtypeNameCtx, Type.InvalidSubtype));
        } else if (!subtype.containsField(attributeName)) {
            context.addProblem(problem(attributeNameCtx, Type.InvalidAttribute));
        }
    }

    @Override
    public void enterAttributeModifierAssignment(final AttributeModifierAssignmentContext ctx) {
        final UnknownModifierContext unknownModifier = ctx.unknownModifier();
        if (unknownModifier != null) {
            context.addProblem(problem(unknownModifier, Type.InvalidAttributeModifier));
            return;
        }

        if (ctx.modifierValue() == null) {
            final AttributeModifierContext attributeModifier = ctx.attributeModifier();
            context.addProblem(problem(attributeModifier, Type.InvalidAttributeModifier));
            return;
        }

        final AttributeModifierContext attributeModifier = ctx.attributeModifier();
        final ModifierValueContext modifierval = ctx.modifierValue();
        final String text = getText(modifierval);
        switch (attributeModifier.getStart().getType()) {
            case ImpexLexer.BooleanHeaderModifier:
                if (!Boolean.TRUE.toString().equalsIgnoreCase(text) && !Boolean.FALSE.toString().equalsIgnoreCase(text)) {
                    context.addProblem(problem(modifierval, Type.InvalidBoolean));
                }
                break;
            case ImpexLexer.TextAttributeModifier:
                if ("mode".equalsIgnoreCase(text)) {
                    if (!supportedModes.contains(text.toLowerCase())) {
                        context.addProblem(problem(modifierval, Type.InvalidMode, join(supportedModes, ", ")));
                    }
                } else if ("lang".equalsIgnoreCase(attributeModifier.getText())) {
                    //TODO support error about restriction to localized attributes
                    try {
                        //parse long to verify if it's a number - a PK
                        Long.parseLong(text);
                    } catch (final NumberFormatException e) {
                        // is not a PK number so verify locale name
                        try {
                            toLocale(text);
                        } catch (final IllegalArgumentException ex) {
                            context.addProblem(problem(modifierval, Type.InvalidLang));
                        }
                    }
                }
                break;
            case ImpexLexer.ClassAttributeModifier:
                if (!isJavaClassName(text)) {
                    context.addProblem(problem(modifierval, Type.InvalidClassname));
                }
                break;
            case ImpexLexer.IntAttributeModifier:
                if ("pos".equalsIgnoreCase(attributeModifier.getText())) {
                    try {
                        final Integer pos = Integer.valueOf(text);
                        if (pos.intValue() < 0) {
                            context.addProblem(problem(modifierval, Type.InvalidPosition));
                        }
                    } catch (final NumberFormatException e) {
                        context.addProblem(problem(modifierval, Type.InvalidPosition));
                    }
                }
                break;
            case ImpexLexer.DateFormatAttributeModifier:
                try {
                    new SimpleDateFormat(text);
                } catch (final NullPointerException | IllegalArgumentException e) {
                    context.addProblem(problem(modifierval, Type.InvalidDateFormat));
                }
                break;
            case ImpexLexer.NumberFormatAttributeModifier:
                try {
                    new DecimalFormat(text);
                } catch (final NullPointerException | IllegalArgumentException e) {
                    context.addProblem(problem(modifierval, Type.InvalidNumberFormat));
                }
                break;
        }
    }

    private String join(final List<String> list, final String separator) {
        final Iterator<String> iterator = list.iterator();
        if (!iterator.hasNext()) {
            return "";
        }
        final StringBuilder builder = new StringBuilder(iterator.next());
        if (list.size() > 1) {
            while (iterator.hasNext()) {
                builder.append(separator);
                builder.append(iterator.next());
            }
        }
        return builder.toString();
    }

    @Override
    public void enterRecord(final RecordContext ctx) {
        // cleanup record data
        columnIndex = -1;
        // Subtype check

        if (!typeDescription.exists()) {
            return;
        }

        final TerminalNode subtypeNode = ctx.Type();
        final String subtypeName = nullIfEmpty(getText(subtypeNode));
        if (subtypeName == null && typeDescription.isAbstract()) {
            context.addProblem(problem(ctx.Separator(0).getSymbol(), Type.SubtypeRequired));
        } else if (subtypeName != null) {
            final TypeDescription subtype = typeFinder.findBySimpleName(subtypeName);
            if (!subtype.isChildOf(typeDescription.getName())) {
                context.addProblem(problem(subtypeNode.getSymbol(), Type.InvalidSubtype));
            }
        }
    }

    @Override
    public void enterField(final FieldContext ctx) {
        columnIndex++;
        final String text = getText(ctx);
        final boolean notBlank = !isBlank(text);
        if (columnIndex >= columnDescriptions.size()) {
            if (notBlank) {
                context.addProblem(problem(ctx, Type.FieldWithoutHeaderAttribute));
            }
            return;
        }
        final ColumnDescription column = columnDescriptions.get(columnIndex);
        if (notBlank && column.isEmpty()) {
            context.addProblem(problem(ctx, Type.FieldWithoutHeaderAttribute));
            return;
        }
    }

    @Override
    public void enterDocumentIdField(final DocumentIdFieldContext ctx) {
        final ColumnDescription column = columnDescriptions.get(columnIndex);
        final String text = getText(ctx);
        if (!typeDescription.exists()) {
            return;
        }
        context.addDocumentIDDefinitionQualifier(new DocumentIDDescription(column.getDocumentID(), text), typeDescription, ctx
                .DocumentIdField().getSymbol());
    }

    @Override
    public void enterDocumentIdRefField(final DocumentIdRefFieldContext ctx) {
        final ColumnDescription column = columnDescriptions.get(columnIndex);
        final String text = getText(ctx);

        final TypeDescription type = column.getType();
        if (type == null || !type.exists()) {
            return;
        }
        context.addDocumentIDReferenceQualifier(new DocumentIDDescription(column.getDocumentID(), text), type, ctx.DocumentIdRefField()
                .getSymbol());
    }

    @Override
    public void exitBlock(final BlockContext ctx) {
        typeDescription = null;
        super.exitBlock(ctx);
    }

    @Override
    public void enterHeaderModifierAssignment(final HeaderModifierAssignmentContext ctx) {
        //TODO test dla null: INSERT User[cacheUnique]
        //TODO test dla empty: INSERT User[cacheUnique = ]
        if (ctx.modifierValue() == null || ctx.modifierValue().getText().isEmpty()) {
            context.addProblem(problem(ctx.headerModifier(), Type.InvalidHeaderModifier));
            return;
        }
        final ModifierValueContext modifierval = ctx.modifierValue();
        final String text = getText(modifierval);
        switch (ctx.headerModifier().getStart().getType()) {
            case ImpexLexer.BooleanHeaderModifier:
                if (!Boolean.TRUE.toString().equalsIgnoreCase(text) && !Boolean.FALSE.toString().equalsIgnoreCase(text)) {
                    context.addProblem(problem(modifierval, Type.InvalidBoolean));
                }
                break;
            case ImpexLexer.TextHeaderModifier:
                break;
            case ImpexLexer.ClassHeaderModifier:
                if (!isJavaClassName(text)) {
                    context.addProblem(problem(modifierval, Type.InvalidClassname));
                }
                break;
        }
    }

    /**
     * {@inheritDoc}
     * <p/>
     * final ImpexProblem problem = new ImpexProblem( The default implementation does nothing.
     */
    @Override
    public void enterImpex(@NotNull final ImpexParser.ImpexContext ctx) {
        columnDescriptions.clear();
        currentMacros.clear();
        columnIndex = -1;
        currentColumnDescription = null;
        typeDescription = null;
    }

    /**
     * {@inheritDoc}
     * <p/>
     * The default implementation does nothing.
     */
    @Override
    public void exitImpex(@NotNull final ImpexParser.ImpexContext ctx) {
        context.checkDocumentIDs();
    }

    @Override
    public void enterMacroref(final MacrorefContext ctx) {
        checkMacroReferences(ctx.Macroref());
    }

    private static boolean isJavaClassName(final String text) {
        for (final String part : text.split("\\.")) {
            if (javaKeywords.contains(part) || !javaClassNamePattern.matcher(part).matches()) {
                return false;
            }
        }
        return text.length() > 0;
    }

    private void checkMacroReferences(final TerminalNode macroReference) {
        if (macroReference == null) {
            return;
        }
        final Token macroReferenceToken = macroReference.getSymbol();
        if (!currentMacros.containsKey(macroReferenceToken.getText())) {
            context.addProblem(problem(macroReferenceToken, Type.UnknownMacro));
            return;
        }
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

    private ImpexProblem problem(final ParserRuleContext context, final Type type, final String... arguments) {
        final ImpexProblem problem = new ImpexProblem(type);
        problem.setLineNumber(context.getStart().getLine());
        problem.setLength(stopIndex(context) - context.getStart().getStartIndex() + 1);
        problem.setStartIndex(context.getStart().getStartIndex());
        problem.setStopIndex(stopIndex(context));
        final StringBuilder builder = new StringBuilder(context.getText());
        for (final String arg : arguments) {
            builder.append(ImpexProblem.SEPARATOR);
            builder.append(arg);
        }
        problem.setText(builder.toString());
        return problem;
    }

    private ImpexProblem problem(final Token token, final Type type, final String... arguments) {
        final ImpexProblem problem = new ImpexProblem(type);
        problem.setLineNumber(token.getLine());
        problem.setLength(token.getStopIndex() - token.getStartIndex() + 1);
        problem.setStartIndex(token.getStartIndex());
        problem.setStopIndex(token.getStopIndex());
        final StringBuilder builder = new StringBuilder(token.getText());
        for (final String arg : arguments) {
            builder.append(ImpexProblem.SEPARATOR);
            builder.append(arg);
        }
        problem.setText(builder.toString());
        return problem;
    }

    private int stopIndex(final ParserRuleContext ctx) {
        return ctx.getStop() != null ? ctx.getStop().getStopIndex() : ctx.getStart().getStopIndex();
    }

    private String getText(final ParserRuleContext ctx) {
        if (ctx == null || ctx.children == null) {
            return null;
        }
        return resolveMacroreferences(ctx.children);
    }

    private String getText(final Token token) {
        if (token == null) {
            return null;
        }
        return token.getText();
    }

    private String getText(final TerminalNode node) {
        if (node == null) {
            return null;
        }
        return node.getText();
    }

    private static String nullIfEmpty(final String text) {
        if (text == null) {
            return null;
        }
        return text.isEmpty() ? null : text;
    }

    private static boolean isBlank(final String text) {
        return text == null || "".equals(text.trim());
    }

    private String resolveMacroreference(final MacrorefContext child) {
        final String text = child.getText();
        final String macrovalue = currentMacros.get(text);
        return macrovalue != null ? macrovalue : text;
    }

    private String resolveMacroreferences(final List<ParseTree> children) {
        final StringBuilder builder = new StringBuilder();
        for (final ParseTree child : children) {
            if (child instanceof MacrorefContext) {
                builder.append(resolveMacroreference((MacrorefContext) child));
            } else {
                builder.append(child.getText());
            }
        }
        return builder.toString();
    }
}