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

@lexer::header {
  package com.lambda.plugin.impex.editor.model.lexer;
}
 
@parser::header {
  package com.lambda.plugin.impex.editor.model.parser;
}

	
DOLLAR
	:	'\u0024'		//$
	;

COMMENT	
	:	'\u0023' ('\u0000' .. '\uffff')*
	;

CHAR
	:	'\u0000' .. '\u0009'	//without \r \n " ; $
	|	'\u000b' .. '\u000c'
	|	'\u000e' .. '\u0021'
	|	'\u0023'
	|	'\u0025' .. '\u003a'	
	|	'\u003c' .. '\uffff'
	;

LINE_CONTINUATION
	:	WS* '\u2216 \u2216' WS*	//\\ 
	;

//WS
//	:	'\u0020', 		//space
//	|	'\u00a0'		//non brekable space
//	|	'\u0009'		//tab
//	;
fragment WS
	:	'\u0020' | '\u0009'
	;

NEW_LINE
	:	'\u000d'? '\u000a'	// \r\n (Windows) or only \n (Unix)
	|	'\u000d'		// \r (MacOS)
   	;

SEPARATOR
	:	WS* '\u003b' WS*
	;

COMMA	:	WS* '\u002c' WS*
	;
	
EQUALS	:	WS* '\u003d' WS*
	;

HEADER_MODE
	:	'INSERT' | 'INSERT_UPDATE' | 'UPDATE' | 'REMOVE' 
	;

HEADER_MODIFIER
	:	'batchmode' | 'cacheUnique' | 'processor'
	;

ATTRIB_MODIFIER
	:	'alias' | 'allownull' | 'cellDecorator' | 'collection-delimiter'
	;
	
WORD	
	:	('\u0041' .. '\u005a' | '\u0061' .. '\u007a')+
	;

LEFT_BRACKET
	:	WS* '[' WS*
	;

RIGHT_BRACKET
	:	WS* ']' WS*
	;

LEFT_PARENTHESIS
	:	WS* '(' WS*
	;

RIGHT_PARENTHESIS
	:	WS* ')' WS*
	;

DQUOTE	
	:	'\u0022'
	;

MAKRO_ID	
	:	('\u0041' .. '\u005a' | '\u0061' .. '\u007a' | '\u0030' .. '\u0039' | '\u005f')+
	;
	
macro_definition
	:	DOLLAR MAKRO_ID
	;

quoted_field	
	:	DQUOTE (CHAR | COMMA | DQUOTE DQUOTE | NEW_LINE | macro_definition)* DQUOTE
	;

unquoted_field
	:	(CHAR | macro_definition)*
	;


header_mode_type	
	:	WS* HEADER_MODE WS+ WORD WS* (LEFT_BRACKET HEADER_MODIFIER EQUALS WORD RIGHT_BRACKET)?
	;
	
argument_modifier
	:	LEFT_BRACKET ATTRIB_MODIFIER EQUALS WORD RIGHT_BRACKET
	;
	
simple_argument
	:	(WORD argument_modifier?)?
	;
	
complex_argument_ref
	:	WORD LEFT_PARENTHESIS WORD (('.' WORD)? | (complex_argument_ref (COMMA (WORD | complex_argument_ref))?)) RIGHT_PARENTHESIS
	;
	
complex_argument
	:	complex_argument_ref argument_modifier?
	;
header	
	:	header_mode_type SEPARATOR WORD (SEPARATOR simple_argument | complex_argument)*
	;

row	
	:	(SEPARATOR (quoted_field | unquoted_field))* LINE_CONTINUATION? 
	;

//header + rows or comments
impex_block
	:	header (NEW_LINE (row | COMMENT))+
	;

macro_assignement
	:	macro_definition  EQUALS (macro_definition | CHAR)+
	;		
	
file	
//	:	(COMMENT | macro_assignement | impex_block) (NEW_LINE (COMMENT | macro_assignement | impex_block))* EOF
	:	(macro_assignement | impex_block)* EOF
	;
