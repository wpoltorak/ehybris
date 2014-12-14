parser grammar ImpexParser;

options {
    tokenVocab=ImpexLexer;
}

impex
        : (UserRights | BeanShell | Comment | macro)* (block | UserRights)* EOF
        ;

block
        :  header (BeanShell | Comment | macro | record)*
        ;
        
header
        : Mode headerTypeName headerModifierAssignment*  (Separator attribute)* Lb?
        ;

quote
        : DoubleQuote | Quote
        ;

headerModifierAssignment
        : headerModifier Equals modifierValue
        ;

headerModifier
        : BooleanHeaderModifier | ClassHeaderModifier | TextHeaderModifier
        ;

// handles record line: optional identifier (subtype) and semicolon separated list of fields and quoted fields
record
        : Type? (Separator field)+ Lb?
        ;

field
        : (FieldQuoted | Field | Macroref | DocumentIdField | DocumentIdRefField | SkippedField)*
        ;
        
////////////////////// ATTRIBUTES ////////////////////////////////

attribute
        : specialAttribute | subtypeAttribute | simpleAttribute | emptyAttribute
        ;

emptyAttribute
		:;

specialAttribute
        : SpecialAttribute attributeModifierAssignment+
        ;

attributeSubtype
        : attributeName Dot
        ;

subtypeAttributeName
        : attributeSubtype attributeName (Or attributeSubtype attributeName)*
        ;

attributeName
        : Macroref | Identifier
        ;

simpleAttributeName
        : attributeName
        ;

subtypeAttribute
        : simpleAttributeName LParenthesis subtypeAttributeName RParenthesis attributeModifierAssignment*
        ;

simpleAttribute
        : (DocumentID | simpleAttributeName) (LParenthesis  simpleAttribute (Comma simpleAttribute)* RParenthesis )? attributeModifierAssignment*
        ;

attributeModifierAssignment
        : (attributeModifier Equals modifierValue?) | (unknownModifier Equals? modifierValue?)
        ;

attributeModifier
        : BooleanAttributeModifier | IntAttributeModifier | DateFormatAttributeModifier | NumberFormatAttributeModifier 
        | ClassAttributeModifier | TextAttributeModifier;

unknownModifier
        : (UnknownModifier | Macroref)+
        ;

modifierValue
        : (Modifierval | Macroref)+
        ;

headerTypeName
        : Type | Macroref
        ;

macro
        : Macrodef Equals macroValue
        ;

macroValue: (Macroval | Macroref)*;
	//(ValueAssignment {context.registerMacro($Macrodef, $ValueAssignment.text);} 
	//|Equals {context.registerMacro($Macrodef, "");}); //if after equals there is no other value except EOF  Lexer produces Equals token rather than ValueAssignment
	