parser grammar ImpexParser;

options {
    tokenVocab=ImpexLexer;
}

impex	: macro* block* EOF
        ;

block	:  header (macro | record)*
        ;
header
	: headerMode headerTypeName headerModifierAssignment*  (Semicolon attribute)* Lb?
        ;

quote	: DoubleQuote | Quote
        ;

headerModifierAssignment
        : headerModifier Modifierval
        ;

headerModifier
	: BooleanHeaderModifier | ClassHeaderModifier | TextHeaderModifier
        ;

// handles record line: optional identifier (subtype) and semicolon separated list of fields and quoted fields
record
   	: Identifier? Field+ Lb?
        ;

attribute
        : attributeValue | quote attributeValue quote
        ;

attributeName 
	: Macrodef | SpecialAttribute | (Identifier (Dot attributeName)?)
        ;
	
attributeValue
	: (DocumentID | attributeName (LParenthesis  attributeValue (Comma attributeValue)* RParenthesis )? attributeModifierAssignment*) |
        ;

attributeModifierAssignment
	: attributeModifier Equals Modifierval?
        ;

attributeModifier
        :     BooleanAttributeModifier | IntAttributeModifier | DateFormatAttributeModifier | NumberFormatAttributeModifier 
        | ClassAttributeModifier | TextAttributeModifier;
//        : Alias |AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull
//	| KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual;

headerMode
        : Insert | InsertUpdate | Update | Remove
        ;
	
headerTypeName
	: headerMode | attributeModifier | headerModifier | Identifier
        ;

macro
	: Macrodef Equals Macroval? 
        ;
	//(ValueAssignment {context.registerMacro($Macrodef, $ValueAssignment.text);} 
	//|Equals {context.registerMacro($Macrodef, "");}); //if after equals there is no other value except EOF  Lexer produces Equals token rather than ValueAssignment

/*
/work/projects/yeclipse/ImpexAST/src/main/java/com/lambda/impex/ast
*/