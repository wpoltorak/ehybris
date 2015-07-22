// Generated from com/lambda/impex/ast/ImpexParser.g4 by ANTLR 4.5.1
package com.lambda.impex.ast;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ImpexParser}.
 */
public interface ImpexParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ImpexParser#impex}.
	 * @param ctx the parse tree
	 */
	void enterImpex(ImpexParser.ImpexContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#impex}.
	 * @param ctx the parse tree
	 */
	void exitImpex(ImpexParser.ImpexContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImpexParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(ImpexParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(ImpexParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImpexParser#header}.
	 * @param ctx the parse tree
	 */
	void enterHeader(ImpexParser.HeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#header}.
	 * @param ctx the parse tree
	 */
	void exitHeader(ImpexParser.HeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImpexParser#quote}.
	 * @param ctx the parse tree
	 */
	void enterQuote(ImpexParser.QuoteContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#quote}.
	 * @param ctx the parse tree
	 */
	void exitQuote(ImpexParser.QuoteContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImpexParser#headerModifierAssignment}.
	 * @param ctx the parse tree
	 */
	void enterHeaderModifierAssignment(ImpexParser.HeaderModifierAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#headerModifierAssignment}.
	 * @param ctx the parse tree
	 */
	void exitHeaderModifierAssignment(ImpexParser.HeaderModifierAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImpexParser#headerModifier}.
	 * @param ctx the parse tree
	 */
	void enterHeaderModifier(ImpexParser.HeaderModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#headerModifier}.
	 * @param ctx the parse tree
	 */
	void exitHeaderModifier(ImpexParser.HeaderModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImpexParser#record}.
	 * @param ctx the parse tree
	 */
	void enterRecord(ImpexParser.RecordContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#record}.
	 * @param ctx the parse tree
	 */
	void exitRecord(ImpexParser.RecordContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImpexParser#field}.
	 * @param ctx the parse tree
	 */
	void enterField(ImpexParser.FieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#field}.
	 * @param ctx the parse tree
	 */
	void exitField(ImpexParser.FieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImpexParser#documentIdField}.
	 * @param ctx the parse tree
	 */
	void enterDocumentIdField(ImpexParser.DocumentIdFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#documentIdField}.
	 * @param ctx the parse tree
	 */
	void exitDocumentIdField(ImpexParser.DocumentIdFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImpexParser#documentIdRefField}.
	 * @param ctx the parse tree
	 */
	void enterDocumentIdRefField(ImpexParser.DocumentIdRefFieldContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#documentIdRefField}.
	 * @param ctx the parse tree
	 */
	void exitDocumentIdRefField(ImpexParser.DocumentIdRefFieldContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImpexParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(ImpexParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(ImpexParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImpexParser#documentIdDefinition}.
	 * @param ctx the parse tree
	 */
	void enterDocumentIdDefinition(ImpexParser.DocumentIdDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#documentIdDefinition}.
	 * @param ctx the parse tree
	 */
	void exitDocumentIdDefinition(ImpexParser.DocumentIdDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImpexParser#documentIdReference}.
	 * @param ctx the parse tree
	 */
	void enterDocumentIdReference(ImpexParser.DocumentIdReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#documentIdReference}.
	 * @param ctx the parse tree
	 */
	void exitDocumentIdReference(ImpexParser.DocumentIdReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImpexParser#macrorefAttribute}.
	 * @param ctx the parse tree
	 */
	void enterMacrorefAttribute(ImpexParser.MacrorefAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#macrorefAttribute}.
	 * @param ctx the parse tree
	 */
	void exitMacrorefAttribute(ImpexParser.MacrorefAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImpexParser#emptyAttribute}.
	 * @param ctx the parse tree
	 */
	void enterEmptyAttribute(ImpexParser.EmptyAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#emptyAttribute}.
	 * @param ctx the parse tree
	 */
	void exitEmptyAttribute(ImpexParser.EmptyAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImpexParser#specialAttribute}.
	 * @param ctx the parse tree
	 */
	void enterSpecialAttribute(ImpexParser.SpecialAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#specialAttribute}.
	 * @param ctx the parse tree
	 */
	void exitSpecialAttribute(ImpexParser.SpecialAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImpexParser#simpleAttribute}.
	 * @param ctx the parse tree
	 */
	void enterSimpleAttribute(ImpexParser.SimpleAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#simpleAttribute}.
	 * @param ctx the parse tree
	 */
	void exitSimpleAttribute(ImpexParser.SimpleAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImpexParser#simpleAttributeName}.
	 * @param ctx the parse tree
	 */
	void enterSimpleAttributeName(ImpexParser.SimpleAttributeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#simpleAttributeName}.
	 * @param ctx the parse tree
	 */
	void exitSimpleAttributeName(ImpexParser.SimpleAttributeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImpexParser#subtypeAttribute}.
	 * @param ctx the parse tree
	 */
	void enterSubtypeAttribute(ImpexParser.SubtypeAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#subtypeAttribute}.
	 * @param ctx the parse tree
	 */
	void exitSubtypeAttribute(ImpexParser.SubtypeAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImpexParser#subtypeAttributeName}.
	 * @param ctx the parse tree
	 */
	void enterSubtypeAttributeName(ImpexParser.SubtypeAttributeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#subtypeAttributeName}.
	 * @param ctx the parse tree
	 */
	void exitSubtypeAttributeName(ImpexParser.SubtypeAttributeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImpexParser#attributeModifierAssignment}.
	 * @param ctx the parse tree
	 */
	void enterAttributeModifierAssignment(ImpexParser.AttributeModifierAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#attributeModifierAssignment}.
	 * @param ctx the parse tree
	 */
	void exitAttributeModifierAssignment(ImpexParser.AttributeModifierAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImpexParser#attributeModifier}.
	 * @param ctx the parse tree
	 */
	void enterAttributeModifier(ImpexParser.AttributeModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#attributeModifier}.
	 * @param ctx the parse tree
	 */
	void exitAttributeModifier(ImpexParser.AttributeModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImpexParser#unknownModifier}.
	 * @param ctx the parse tree
	 */
	void enterUnknownModifier(ImpexParser.UnknownModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#unknownModifier}.
	 * @param ctx the parse tree
	 */
	void exitUnknownModifier(ImpexParser.UnknownModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImpexParser#modifierValue}.
	 * @param ctx the parse tree
	 */
	void enterModifierValue(ImpexParser.ModifierValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#modifierValue}.
	 * @param ctx the parse tree
	 */
	void exitModifierValue(ImpexParser.ModifierValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImpexParser#headerTypeName}.
	 * @param ctx the parse tree
	 */
	void enterHeaderTypeName(ImpexParser.HeaderTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#headerTypeName}.
	 * @param ctx the parse tree
	 */
	void exitHeaderTypeName(ImpexParser.HeaderTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImpexParser#macro}.
	 * @param ctx the parse tree
	 */
	void enterMacro(ImpexParser.MacroContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#macro}.
	 * @param ctx the parse tree
	 */
	void exitMacro(ImpexParser.MacroContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImpexParser#macroValue}.
	 * @param ctx the parse tree
	 */
	void enterMacroValue(ImpexParser.MacroValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#macroValue}.
	 * @param ctx the parse tree
	 */
	void exitMacroValue(ImpexParser.MacroValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImpexParser#macroref}.
	 * @param ctx the parse tree
	 */
	void enterMacroref(ImpexParser.MacrorefContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpexParser#macroref}.
	 * @param ctx the parse tree
	 */
	void exitMacroref(ImpexParser.MacrorefContext ctx);
}