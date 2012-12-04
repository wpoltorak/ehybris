tree grammar ImpexTreeWalker;

options {
    tokenVocab=Impex;
    ASTLabelType=CommonTree;
}

@header {
package output;

import output.tree.ImpexNode;
import output.tree.MacroNode;
}

walk	returns [ImpexNode node]
	:impex;

impex	returns [ImpexNode node]
	:^(IMPEX ^(MACROS macro*)  ^(BLOCKS block*));

block	returns [ImpexNode node]
	:^(BLOCK header ^(RECORDS record+));

header	returns [ImpexNode node]
	:^(HEADER headerMode ^(TYPE Identifier) ^(MODIFIERS headerModifiers?) ^(DOCUMENTID DocumentID?) ^(ATTRIBUTES attribute*)) ;

headerModifiers	 returns [ImpexNode node]
	: ^(MODIFIERS headerModifierAssignment+);

headerModifierAssignment	 returns [ImpexNode node]
		: ^(MODIFIER headerModifier boolOrClassname);

boolOrClassname
	:Bool | Classname;
	
headerModifier
	:BatchMode | CacheUnique | Processor;

// handles record line: optional identifier (subtype) and semicolon separated list of fields and quoted fields
record	 returns [ImpexNode node]
   	: ^(RECORD ^(SUBTYPE Identifier?) ^(FIELDS QuotedField* Field*));

//handles special attributes (e..g ;@media[...]), normal attributes (e.g. ;uid[unique=true]) or skipped attributes (;;)
//attribute	: (specialAttribute | normalAttribute)?
//	-> ^(ATTRIBUTE specialAttribute? normalAttribute?);


//handles normal attributes (e.g. ;uid[unique=true])
//normalAttribute
//	: attributeName attributeModifiers?
//	-> attributeName ^(MODIFIERS attributeModifiers)?;

//attribute
//	: attributeName attributeModifiers?
//	-> attributeName ^(MODIFIERS attributeModifiers)?;

//handles special attributes (e..g ;@media[...])
//specialAttribute
//	:SpecialAttribute LBracket attributeModifierAssignment RBracket
//	-> SpecialAttribute ^(MODIFIERS ^(MODIFIER attributeModifierAssignment));
			
attributeModifiers	 returns [ImpexNode node]
	: ^(MODIFIERS attributeModifierAssignment+);

attributeModifierAssignment	 returns [ImpexNode node]
	: ^(MODIFIER attributeModifier ValueAssignement);	

//attributeName
//	:Macrodef | (Identifier (Dot attributeName |  (LParenthesis  (DocumentID |  attributeName (Comma attributeName)*) RParenthesis ))?);


attributeName 	 returns [ImpexNode node]
	:^(MACRO_REF  Macrodef)
	| ^(ATTRIBUTE_NAME SpecialAttribute)
	|^(ATTRIBUTE_NAME Identifier attributeName?); //^(DOCUMENTID_REF DocumentID)?
	
attribute	 returns [ImpexNode node]
	:^(ATTRIBUTE attributeName ^(ITEM_EXPRESSION attribute* ^(DOCUMENTID_REF DocumentID*)) ^(MODIFIERS attributeModifiers*));



//attributeSubType	:	;
		
//attributeComposedType	:	;	
	
macro	 returns [ImpexNode node]
	:^(MACRO def=Macrodef val=ValueAssignement){node = new MacroNode($def.text, $val.text);};

attributeModifier
	: Alias |AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull
	| KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual;

headerMode
	:Insert | InsertUpdate | Update | Remove;