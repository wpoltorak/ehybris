// Generated from /work/projects/yeclipse/ImpexAST/src/main/antlr4/ImpexParser.g4 by ANTLR 4.1
package com.lambda.impex.ast;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ImpexParser}.
 */
public interface ImpexParserListener extends ParseTreeListener {
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
	 * Enter a parse tree produced by {@link ImpexParser#headerMode}.
	 * @param ctx the parse tree
	 */
	void enterHeaderMode(@NotNull ImpexParser.HeaderModeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#headerMode}.
	 * @param ctx the parse tree
	 */
	void exitHeaderMode(@NotNull ImpexParser.HeaderModeContext ctx);

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
	 * Enter a parse tree produced by {@link ImpexParser#attributeValue}.
	 * @param ctx the parse tree
	 */
	void enterAttributeValue(@NotNull ImpexParser.AttributeValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#attributeValue}.
	 * @param ctx the parse tree
	 */
	void exitAttributeValue(@NotNull ImpexParser.AttributeValueContext ctx);

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
	 * Enter a parse tree produced by {@link ImpexParser#impex}.
	 * @param ctx the parse tree
	 */
	void enterImpex(@NotNull ImpexParser.ImpexContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#impex}.
	 * @param ctx the parse tree
	 */
	void exitImpex(@NotNull ImpexParser.ImpexContext ctx);
}