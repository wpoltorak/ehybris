// Generated from com/lambda/impex/ast/ImpexParser.g4 by ANTLR 4.3
package com.lambda.impex.ast;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ImpexParser}.
 */
public interface ImpexParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ImpexParser#simpleAttributeName}.
	 * @param ctx the parse tree
	 */
	void enterSimpleAttributeName(@NotNull ImpexParser.SimpleAttributeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#simpleAttributeName}.
	 * @param ctx the parse tree
	 */
	void exitSimpleAttributeName(@NotNull ImpexParser.SimpleAttributeNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImpexParser#headerTypeName}.
	 * @param ctx the parse tree
	 */
	void enterHeaderTypeName(@NotNull ImpexParser.HeaderTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#headerTypeName}.
	 * @param ctx the parse tree
	 */
	void exitHeaderTypeName(@NotNull ImpexParser.HeaderTypeNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImpexParser#documentIdReference}.
	 * @param ctx the parse tree
	 */
	void enterDocumentIdReference(@NotNull ImpexParser.DocumentIdReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#documentIdReference}.
	 * @param ctx the parse tree
	 */
	void exitDocumentIdReference(@NotNull ImpexParser.DocumentIdReferenceContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImpexParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(@NotNull ImpexParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(@NotNull ImpexParser.AttributeContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImpexParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(@NotNull ImpexParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(@NotNull ImpexParser.BlockContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImpexParser#attributeModifierAssignment}.
	 * @param ctx the parse tree
	 */
	void enterAttributeModifierAssignment(@NotNull ImpexParser.AttributeModifierAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#attributeModifierAssignment}.
	 * @param ctx the parse tree
	 */
	void exitAttributeModifierAssignment(@NotNull ImpexParser.AttributeModifierAssignmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImpexParser#macroref}.
	 * @param ctx the parse tree
	 */
	void enterMacroref(@NotNull ImpexParser.MacrorefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#macroref}.
	 * @param ctx the parse tree
	 */
	void exitMacroref(@NotNull ImpexParser.MacrorefContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImpexParser#subtypeAttributeName}.
	 * @param ctx the parse tree
	 */
	void enterSubtypeAttributeName(@NotNull ImpexParser.SubtypeAttributeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#subtypeAttributeName}.
	 * @param ctx the parse tree
	 */
	void exitSubtypeAttributeName(@NotNull ImpexParser.SubtypeAttributeNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImpexParser#simpleAttribute}.
	 * @param ctx the parse tree
	 */
	void enterSimpleAttribute(@NotNull ImpexParser.SimpleAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#simpleAttribute}.
	 * @param ctx the parse tree
	 */
	void exitSimpleAttribute(@NotNull ImpexParser.SimpleAttributeContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImpexParser#headerModifierAssignment}.
	 * @param ctx the parse tree
	 */
	void enterHeaderModifierAssignment(@NotNull ImpexParser.HeaderModifierAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#headerModifierAssignment}.
	 * @param ctx the parse tree
	 */
	void exitHeaderModifierAssignment(@NotNull ImpexParser.HeaderModifierAssignmentContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImpexParser#emptyAttribute}.
	 * @param ctx the parse tree
	 */
	void enterEmptyAttribute(@NotNull ImpexParser.EmptyAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#emptyAttribute}.
	 * @param ctx the parse tree
	 */
	void exitEmptyAttribute(@NotNull ImpexParser.EmptyAttributeContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImpexParser#macro}.
	 * @param ctx the parse tree
	 */
	void enterMacro(@NotNull ImpexParser.MacroContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#macro}.
	 * @param ctx the parse tree
	 */
	void exitMacro(@NotNull ImpexParser.MacroContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImpexParser#quote}.
	 * @param ctx the parse tree
	 */
	void enterQuote(@NotNull ImpexParser.QuoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#quote}.
	 * @param ctx the parse tree
	 */
	void exitQuote(@NotNull ImpexParser.QuoteContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImpexParser#unknownModifier}.
	 * @param ctx the parse tree
	 */
	void enterUnknownModifier(@NotNull ImpexParser.UnknownModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#unknownModifier}.
	 * @param ctx the parse tree
	 */
	void exitUnknownModifier(@NotNull ImpexParser.UnknownModifierContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImpexParser#impex}.
	 * @param ctx the parse tree
	 */
	void enterImpex(@NotNull ImpexParser.ImpexContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#impex}.
	 * @param ctx the parse tree
	 */
	void exitImpex(@NotNull ImpexParser.ImpexContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImpexParser#documentIdDefinition}.
	 * @param ctx the parse tree
	 */
	void enterDocumentIdDefinition(@NotNull ImpexParser.DocumentIdDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#documentIdDefinition}.
	 * @param ctx the parse tree
	 */
	void exitDocumentIdDefinition(@NotNull ImpexParser.DocumentIdDefinitionContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImpexParser#attributeModifier}.
	 * @param ctx the parse tree
	 */
	void enterAttributeModifier(@NotNull ImpexParser.AttributeModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#attributeModifier}.
	 * @param ctx the parse tree
	 */
	void exitAttributeModifier(@NotNull ImpexParser.AttributeModifierContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImpexParser#headerModifier}.
	 * @param ctx the parse tree
	 */
	void enterHeaderModifier(@NotNull ImpexParser.HeaderModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#headerModifier}.
	 * @param ctx the parse tree
	 */
	void exitHeaderModifier(@NotNull ImpexParser.HeaderModifierContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImpexParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(@NotNull ImpexParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(@NotNull ImpexParser.HeaderContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImpexParser#modifierValue}.
	 * @param ctx the parse tree
	 */
	void enterModifierValue(@NotNull ImpexParser.ModifierValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#modifierValue}.
	 * @param ctx the parse tree
	 */
	void exitModifierValue(@NotNull ImpexParser.ModifierValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImpexParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(@NotNull ImpexParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(@NotNull ImpexParser.FieldContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImpexParser#attributeName}.
	 * @param ctx the parse tree
	 */
	void enterAttributeName(@NotNull ImpexParser.AttributeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#attributeName}.
	 * @param ctx the parse tree
	 */
	void exitAttributeName(@NotNull ImpexParser.AttributeNameContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImpexParser#record}.
	 * @param ctx the parse tree
	 */
	void enterRecord(@NotNull ImpexParser.RecordContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#record}.
	 * @param ctx the parse tree
	 */
	void exitRecord(@NotNull ImpexParser.RecordContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImpexParser#subtypeAttribute}.
	 * @param ctx the parse tree
	 */
	void enterSubtypeAttribute(@NotNull ImpexParser.SubtypeAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#subtypeAttribute}.
	 * @param ctx the parse tree
	 */
	void exitSubtypeAttribute(@NotNull ImpexParser.SubtypeAttributeContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImpexParser#macroValue}.
	 * @param ctx the parse tree
	 */
	void enterMacroValue(@NotNull ImpexParser.MacroValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#macroValue}.
	 * @param ctx the parse tree
	 */
	void exitMacroValue(@NotNull ImpexParser.MacroValueContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImpexParser#specialAttribute}.
	 * @param ctx the parse tree
	 */
	void enterSpecialAttribute(@NotNull ImpexParser.SpecialAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#specialAttribute}.
	 * @param ctx the parse tree
	 */
	void exitSpecialAttribute(@NotNull ImpexParser.SpecialAttributeContext ctx);

	/**
	 * Enter a parse tree produced by {@link ImpexParser#attributeSubtype}.
	 * @param ctx the parse tree
	 */
	void enterAttributeSubtype(@NotNull ImpexParser.AttributeSubtypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#attributeSubtype}.
	 * @param ctx the parse tree
	 */
	void exitAttributeSubtype(@NotNull ImpexParser.AttributeSubtypeContext ctx);
}