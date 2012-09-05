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
/*
tokens{
	TRUE='true';
	FALSE='false';
	INSERT;
	INSERT_UPDATE;
	UPDATE;
	REMOVE;
	BATCH_MODE= 'batchmode';
	CACHE_UNIQUE='cacheUnique';
	PROCESSOR='processor';
}
*/


TRUE		:'true';
FALSE		:'false';
INSERT		:'INSERT';
INSERT_UPDATE	:'INSERT_UPDATE';
UPDATE		:'UPDATE';
REMOVE		:'REMOVE';

BATCH_MODE	:'batchmode';
CACHE_UNIQUE	:'cacheUnique';
PROCESSOR		:'processor';

ALIAS		:'alias';
ALLOW_NULL		:'allownull';
FORCE_WRITE	:'forceWrite';
IGNORE_KEY_CASE	:'ignoreKeyCase';
IGNORE_NULL	:'ignorenull';
UNIQUE		:'unique';
VIRTUAL		:'virtual';
POS		:'pos';

DOLLAR		:'$';
SEMICOLON		:';';
RIGHT_BRACKET	:']';
LEFT_BRACKET	:'[';
LEFT_PARENTHESIS 	:'(';
RIGHT_PARENTHESIS	:')';
EQUALS		:'=';
COMMA		: ',';
UNDERSCORE	:'_';
HASH		:'#';

LINE_CONTINUATION
	:	WS* '\u2216 \u2216' WS*	//\\ 
	;

fragment BOOL	
	:	TRUE | FALSE
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

WORD	
	:	LETTER+
	;

fragment LETTER
	:	'a' .. 'z' | 'A' .. 'Z';
	
fragment DQUOTE	
	:	'"'
	;

fragment INT  
  	:  	'1'..'9' DIGIT*  
 	|  	'0'  
  	;  
    
fragment DIGIT   
  	:  	'0'..'9'  
 	;
 	
CHAR
	:	'\u0000' .. '\u0009'	//without \r \n " ; $
	|	'\u000b' .. '\u000c'
	|	'\u000e' .. '\u0021'
	|	'\u0023'
	|	'\u0025' .. '\u003a'	
	|	'\u003c' .. '\uffff'
	;

fragment COMPLEX_ARGUMENT_REF
	:	WORD WS* LEFT_PARENTHESIS WS* WORD (('.' WORD)? | (COMPLEX_ARGUMENT_REF (WS* COMMA WS* (WORD | COMPLEX_ARGUMENT_REF))?)) WS* RIGHT_PARENTHESIS WS*
	;

fragment BOOL_HEADER_MODIFIER
	:	BATCH_MODE | CACHE_UNIQUE
	;

fragment WORD_HEADER_MODIFIER
	:	PROCESSOR
	;
fragment BOOL_ATTRIB_MODIFIER
	:	ALLOW_NULL | FORCE_WRITE | IGNORE_KEY_CASE | IGNORE_NULL | UNIQUE | VIRTUAL
	;
	
fragment WORD_ATTRIB_MODIFIER
	:	ALIAS |  'cellDecorator' | 'collection-delimiter' | 'dateformat' | 'default' |  'key2value-delimiter' | 'lang' 
	|	'map-delimiter' | 'mode' | 'numberformat' | 'path-delimiter' | 'translator' 
	;

fragment INT_ATTRIB_MODIFIER
	:	POS
	;
	
comment	
	:	HASH .*
	;

macro_identifier	
	:	(LETTER | UNDERSCORE)(DIGIT | LETTER | UNDERSCORE)*
	;
	
macro_definition
	:	DOLLAR macro_identifier
	;

field	
	:	(DQUOTE (CHAR | COMMA | DQUOTE DQUOTE | NEW_LINE | macro_definition)* DQUOTE) | (CHAR | macro_definition)+
	;
	
header_mode 
	:	INSERT | INSERT_UPDATE | UPDATE | REMOVE;

header_mode_type	
	:	WS* header_mode WS+ WORD  (WS* header_modifier)?
	;

header_modifier	
	:	LEFT_BRACKET (BOOL_HEADER_MODIFIER WS* EQUALS  WS* BOOL | WORD_HEADER_MODIFIER WS* EQUALS  WS* WORD) WS*  RIGHT_BRACKET
	;
		
argument_modifier
	:	LEFT_BRACKET (BOOL_ATTRIB_MODIFIER WS* EQUALS WS* BOOL | INT_ATTRIB_MODIFIER WS* EQUALS WS* INT | WORD_ATTRIB_MODIFIER WS* EQUALS WS* WORD) WS*  RIGHT_BRACKET
	;
	
simple_attribute
	:	WORD argument_modifier?
	;

complex_attribute
	:	COMPLEX_ARGUMENT_REF (WS* argument_modifier)?
	;
header	
	:	header_mode_type WS* SEMICOLON  (WS* SEMICOLON  (WS* (simple_attribute |  complex_attribute))?)+
	;

row	
	:	(WS* SEMICOLON (WS*  field)?)* LINE_CONTINUATION? 
	;

//header + rows or comments
impex_block
	:	header (NEW_LINE (row | comment))+
	;

macro_assignement
	:	macro_definition  EQUALS (macro_definition | CHAR)+
	;		
	
file	
//	:	(COMMENT | macro_assignement | impex_block) (NEW_LINE (COMMENT | macro_assignement | impex_block))* EOF
	:	(macro_assignement | impex_block)* EOF
	;