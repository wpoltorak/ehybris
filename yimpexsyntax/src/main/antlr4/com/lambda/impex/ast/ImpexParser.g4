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
        : (FieldQuoted | Field | macroref | SkippedField | documentIdRefField)* | documentIdField
        ;

documentIdField
        : DocumentIdField
        ;
     
documentIdRefField
        : DocumentIdRefField
        ;
        
////////////////////// ATTRIBUTES ////////////////////////////////

attribute
        : documentIdReference 
        | documentIdDefinition 
        | simpleAttribute 
        | specialAttribute 
        | macrorefAttribute 
        | emptyAttribute
        ;

documentIdDefinition
        : DocumentID
        ;
        
documentIdReference
        : simpleAttributeName LParenthesis DocumentID RParenthesis attributeModifierAssignment*
        ;

macrorefAttribute
        : macroref attributeModifierAssignment*
        ;
        
emptyAttribute
		:;

specialAttribute
        : SpecialAttribute attributeModifierAssignment+
        ;

simpleAttribute
        : simpleAttributeName (LParenthesis  subtypeAttribute ((Comma | Or) subtypeAttribute)* RParenthesis )? attributeModifierAssignment*
        ;

simpleAttributeName
        : Identifier
        ;

subtypeAttribute
        : macroref attributeModifierAssignment*
        | subtypeAttributeName (LParenthesis  subtypeAttribute ((Comma | Or) subtypeAttribute)* RParenthesis )? attributeModifierAssignment*
        ;

subtypeAttributeName
        : (type=Identifier Dot)? name=Identifier
        ;

attributeModifierAssignment
        : (attributeModifier Equals modifierValue?)
        | (unknownModifier Equals? modifierValue?)
        ;

attributeModifier
        : BooleanAttributeModifier 
        | IntAttributeModifier 
        | DateFormatAttributeModifier 
        | NumberFormatAttributeModifier 
        | ClassAttributeModifier 
        | TextAttributeModifier;

unknownModifier
        : (UnknownModifier | macroref)+
        ;

modifierValue
        : (Modifierval | macroref)+
        ;

headerTypeName
        : Type 
        | macroref
        ;

macro
        : Macrodef Equals macroValue
        ;

macroValue
        :(Macroval | macroref)*
        ;

	//(ValueAssignment {context.registerMacro($Macrodef, $ValueAssignment.text);} 
	//|Equals {context.registerMacro($Macrodef, "");}); //if after equals there is no other value except EOF  Lexer produces Equals token rather than ValueAssignment
	
macroref
        : Macroref | ConfigMacroref
        ;		