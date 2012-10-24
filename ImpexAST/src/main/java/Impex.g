grammar Impex;

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
	ASSIGNEMENTS;
	SIMPLE_ATTRIBUTE;
	COMPLEX_ATTRIBUTE;
	ATTRIBUTES;
	HEADER;
	HEADER_PREFIX;
	HEADER_TYPE;
	IMPEX;
	IMPEX_BLOCK;
	IMPEX_BLOCKS;
	COMMENTS;
	ROW;
	ROWS;
}


@lexer::header {
 package output;
}
 
@parser::header {
  package output;
}

//@parser::members {
//  private boolean flag = true;
//}

//impex 	:
//	.* EOF	
//
//parse
//  :  (t=.{System.out.printf("\%s: \%-7s \n", tokenNames[$t.type], $t.text);})* EOF
//  ;
  	
impex	: 
//	  ( record 
	( 
	//record 
	//| 
	macro {System.out.printf("macro    :: '\%s'\n", $macro.text);}
	//| record {System.out.printf("record    :: '\%s'\n", $record.text);}
	| Comment {System.out.printf("Comment    :: '\%s'\n", $Comment.text);}
//	| header -> ^(HEADER header)
	)*
	EOF
	 -> ^(IMPEX  ^(COMMENTS Comment*) ^(ASSIGNEMENTS macro*) )//^(ROWS record*))
//	:	( macroAssignement | impexBlock)* EOF
	;
	
//record
//    	:
 //   	(Semicolon (quoted_field | Field))+ 
 //   	-> ^(ROW quoted_field+ Field+)
 //   	;  
    	
macro
	:
	Macrodef
	Equals
	 (Semicolon | DoubleQuote | Identifier | Char | Ws)*
	
	//MacroVal {System.out.printf("macroVal    :: '\%s\n'", $MacroVal.text);}
	//LineBreak? {System.out.printf("LineBreak    :: '\%s'", $LineBreak.text);}
	//Char*
//	unquoted_field  //{System.out.printf("Macroval    :: '\%s'\n", $text.text);}
	-> ^(ASSIGNEMENT Macrodef Char*)//macroText*)
//	:	Macrodef Equals  -> ^(ASSIGNEMENT Macrodef )
	;			



    
//quoted_field
//	: DoubleQuote (Field  DoubleQuote DoubleQuote)*  DoubleQuote
///	;

//field
//    	: (options {greedy=false;}:Char)*
//	: ~('\r' | '\n' | '"' | ';')*
  //	;
 	
//block
//	: header  (
//	            options {
//	                greedy=false;
//	            } :   '\r' ('\n')? {newline();}
//	               |   '\n'         {newline();}
//	             )*
//	;
	
//header
//	:
//	(Insert | InsertUpdate | Update | Remove)! Ws* Identifier!
//	;
	

//row
//	:value*
//	;
	
//value
//	:
//	';'.*';'
//	;	

Insert		:'INSERT';
InsertUpdate		:'INSERT_UPDATE';
Update		:'UPDATE';
Remove		:'REMOVE';
//Oper		:'INSERT' | 'INSERT_UPDATE' | 'UPDATE' | 'REMOVE';

BatchMode		:'batchmode';
CacheUnique		:'cacheUnique';
Processor		:'processor';
//TypeModifier		:'batchmode' | 'cacheUnique' | 'processor';
		

Alias		:'alias';
AllowNull		:'allownull';
CellDecorator		:'cellDecorator';
CollectionDelimiter 	:'collection-delimiter';
Dateformat		:'dateformat';
Default		:'default';
ForceWrite		:'forceWrite';
IgnoreKeyCase	:'ignoreKeyCase';
IgnoreNull		:'ignorenull';
KeyToValueDelimiter	:'key2value-delimiter';
Lang		:'lang';
MapDelimiter		:'map-delimiter';
Mode		:'mode';
Numberformat	:'numberformat';
PathDelimiter		:'path-delimiter';
Pos		:'pos';
Translator		:'translator';
Unique		:'unique';
Virtual		:'virtual';

//AttribModifier	: 'alias' | 'allownull' | 'cellDecorator' | 'collection-delimiter' | 'dateformat' | 'default' | 'forceWrite' | 'ignoreKeyCase' | 'ignorenull' 
//		| 'key2value-delimiter' | 'lang' | 'map-delimiter' | 'mode' | 'numberformat' | 'path-delimiter' | 'pos' | 'translator' | 'unique' | 'virtual';



//Dollar		:'$';
DoubleQuote		:'"';
Semicolon		:';';
RightBracket		:']';
LeftBracket		:'[';
LeftParenthesis 	:'(';
RightParenthesis	:')';
Equals		:'=';
Comma		:',';
//Underscore		:'_';
//Hash		:'#';
LineContinuation	:'\\\\';
Bool		:'true' | 'false';

Macrodef
	:	'$' ('a' .. 'z' | 'A' .. 'Z' | '_') ('a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_')*
	;

	
Identifier
	:	('a' .. 'z' | 'A' .. 'Z' | '_') ('a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_')*
	;

Comment	
	@after {
  		setText(getText().substring(1, getText().length()));
	}
	:	'#' ~('\r' | '\n')* 
		//LineBreak?//{Skip();}
//	:	'#'(options {greedy=false;}: .)* ('\r'? '\n' | '\r')

	;

//BeanShell	
//	:	'#$' ~('\r' | '\n')* 
		//LineBreak?//{Skip();}
//	:	'#'(options {greedy=false;}: .)* ('\r'? '\n' | '\r')
//	;

//LineBreak
//	:	'\r'? '\n'	// \r\n (Windows) or only \n (Unix) 
//	|	'\r' 	// \r (MacOS)
//	{
//		$channel=HIDDEN;
//	}  //{skip();} 
// 	;
   	

//Macroval
//	@after {
// 		setText(getText().substring(1, getText().length()).trim());
//	}
//	:	'=' (options {greedy=false;}: .)* LineBreak
//	;

//Block
//CURLY_BLOCK_SCARF
//    :   '{'
//        (
//            options {
//                greedy=false;
//            }
//        :   '\r' ('\n')? {newline();}
//        |   '\n'         {newline();}
//        |   .
//        )*
//        '}'
//    ;	

//Char
//    : '\u0000' .. '\u0009'
///   | '\u000b' .. '\u000c'
//    | '\u000e' .. '\u0021'
 //   | '\u0023' .. '\u002b'
//   | '\u002d' .. '\uffff'
//    ;




Char
  //  	: (options {greedy=false;}:Char)*
	: ~('\r' | '\n' | '"' | ';' | ' ' | '\t')
  ;
 
 Ws
//	:	'\u0020' | '\u0009' {skip(); }
	:
	(	' ' | '\t'  
	| '\r'? '\n' 
	| '\r' )
	{
		//$channel=HIDDEN;
		skip();
	}  //{skip();} 
	;
//  Field	:Char*;	
