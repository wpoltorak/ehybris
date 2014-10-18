parser grammar ImpexParser;

options {
    tokenVocab=ImpexLexer;
}

impex	: (UserRights | BeanShell | Comment | macro)* (block | UserRights)* EOF
        ;

block	:  header (BeanShell | Comment | macro | record)*
        ;
header
	: Mode headerTypeName headerModifierAssignment*  (Separator attribute)* Lb?
        ;

quote	: DoubleQuote | Quote
        ;

headerModifierAssignment
        : headerModifier Equals modifierValue
        ;

headerModifier
	: BooleanHeaderModifier | ClassHeaderModifier | TextHeaderModifier;

// handles record line: optional identifier (subtype) and semicolon separated list of fields and quoted fields
record
   	: Type? (Separator field)+ Lb?
        ;

field   : (FieldQuoted | Field | Macroref)*
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
	: (attributeModifier Equals modifierValue?) | (unknownModifier Equals? modifierValue?)
        ;

attributeModifier
        :     BooleanAttributeModifier | IntAttributeModifier | DateFormatAttributeModifier | NumberFormatAttributeModifier 
        | ClassAttributeModifier | TextAttributeModifier;
//        : Alias |AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull
//	| KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual;

unknownModifier
	: (UnknownModifier | Macroref)+
	;
//headerMode
//        : Insert | InsertUpdate | Update | Remove
//        ;

modifierValue
    :   (Modifierval | Macroref)+
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

/*
/work/projects/yeclipse/ImpexAST/src/main/java/com/lambda/impex/ast
*/