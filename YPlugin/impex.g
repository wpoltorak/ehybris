grammar impex;

options {
// antlr will generate java lexer and parser
    language=Java;
    // generated parser should create abstract syntax tree
    output=AST;
    ASTLabelType=CommonTree;
}

//@members{
//}


tokens{
	ASSIGNEMENT;
}


@lexer::header {
  package com.lambda.plugin.impex.editor.model.lexer;
}
 
@parser::header {
  package com.lambda.plugin.impex.editor.model.parser;
}

Insert		:'INSERT';
InsertUpdate	:'INSERT_UPDATE';
Update		:'UPDATE';
Remove		:'REMOVE';

BatchMode		:'batchmode';
CacheUnique	:'cacheUnique';
Processor		:'processor';

Alias		:'alias';
AllowNull		:'allownull';
ForceWrite		:'forceWrite';
IgnoreKeyCase	:'ignoreKeyCase';
IgnoreNull		:'ignorenull';
Unique		:'unique';
Virtual		:'virtual';
Pos		:'pos';

Dollar		:'$';
Semicolon		:';';
RightBracket	:']';
LeftBracket		:'[';
LeftParenthesis 	:'(';
RightParenthesis	:')';
Equals		:'=';
Comma		: ',';
Underscore		:'_';
Hash		:'#';

LineContinuation
	:	Ws* '\u2216 \u2216' Ws*	//\\ 
	;

Bool	
	:	'true' | 'false'
	;

Comment	
	:	Hash ('\u0000' .. '\uffff')*
	;
	
//WS
//	:	'\u0020', 		//space
//	|	'\u00a0'		//non brekable space
//	|	'\u0009'		//tab
//	;
fragment Ws
	:	'\u0020' | '\u0009'
	;

fragment NewLine
	:	'\u000d'? '\u000a'	// \r\n (Windows) or only \n (Unix)
	|	'\u000d'		// \r (MacOS)
   	;

Word	
	:	Letter+
	;

fragment Letter
	:	'a' .. 'z' | 'A' .. 'Z';
	
fragment DoubleQuote	
	:	'"'
	;

fragment Int  
  	:  	'1'..'9' Digit*  
 	|  	'0'  
  	;  
    
fragment Digit   
  	:  	'0'..'9'  
 	;
 	
Char
	:	'\u0000' .. '\u0009'	//without \r \n " ; $
	|	'\u000b' .. '\u000c'
	|	'\u000e' .. '\u0021'
	|	'\u0023'
	|	'\u0025' .. '\u003a'	
	|	'\u003c' .. '\uffff'
	;

fragment ComplexArgumentRef
	:	Word Ws* LeftParenthesis Ws* Word (('.' Word)? | (ComplexArgumentRef (Ws* Comma Ws* (Word | ComplexArgumentRef))?)) Ws* RightParenthesis Ws*
	;

fragment BoolHeaderModifier
	:	BatchMode | CacheUnique
	;

fragment WordHeaderModifier
	:	Processor
	;
fragment BoolAttribModifier
	:	AllowNull | ForceWrite | IgnoreKeyCase | IgnoreNull | Unique | Virtual
	;
	
fragment WordAttribModifier
	:	Alias |  'cellDecorator' | 'collection-delimiter' | 'dateformat' | 'default' |  'key2value-delimiter' | 'lang' 
	|	'map-delimiter' | 'mode' | 'numberformat' | 'path-delimiter' | 'translator' 
	;

fragment IntAttribModifier
	:	Pos
	;
	
MacroIdentifier
	:	(Letter | Underscore)(Digit | Letter | Underscore)*
	;
	
MacroDefinition
	:	Dollar MacroIdentifier
	;

field	
	:	(DoubleQuote (Char | Comma | DoubleQuote DoubleQuote | NewLine | MacroDefinition)* DoubleQuote) | (Char | MacroDefinition)+
	;
	
header_mode 
	:	Insert | InsertUpdate | Update | Remove;

header_mode_type	
	:	Ws* header_mode Ws+ Word  (Ws* header_modifier)?
	;

header_modifier	
	:	LeftBracket (BoolHeaderModifier Ws* Equals  Ws* Bool | WordHeaderModifier Ws* Equals  Ws* Word) Ws*  RightBracket
	;
		
argument_modifier
	:	LeftBracket (BoolAttribModifier Ws* Equals Ws* Bool | IntAttribModifier Ws* Equals Ws* Int | WordAttribModifier Ws* Equals Ws* Word) Ws*  RightBracket
	;
	
simple_attribute
	:	Word argument_modifier?
	;

complex_attribute
	:	ComplexArgumentRef (Ws* argument_modifier)?
	;
header	
	:	header_mode_type Ws* Semicolon  (Ws* Semicolon  (Ws* (simple_attribute |  complex_attribute))?)+
	;

row	
	:	(Ws* Semicolon (Ws*  field)?)* LineContinuation? 
	;

//header + rows or comments
impex_block
	:	header (NewLine (row | Comment))+
	;

macroExpression
	:	(MacroDefinition | Char)+
	;
	
macroAssignement
	:	MacroDefinition Equals macroExpression
		-> ^(ASSIGNEMENT MacroDefinition macroExpression)
	;		
	
impex	
//	:	(COMMENT | macro_assignement | impex_block) (NEW_LINE (COMMENT | macro_assignement | impex_block))* EOF
	:	(macroAssignement | impex_block)* EOF
	;