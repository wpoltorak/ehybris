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
	ROW;
	MACRO;
	HEADER;
	HEADER_PREFIX;
	HEADER_TYPE;
	IMPEX;
	IMPEX_BLOCKS;
	IMPEX_BLOCK;
	COMMENTS;
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
parse
  :  (t=.{System.out.printf("\%s: \%-7s \n", tokenNames[$t.type], $t.text);})* EOF
  ;
  	
impex	: 
//	  ( record 
	( 
	//record 
	//| 
	macro
	| Comment {System.out.printf("Comment    :: '\%s'\n", $Comment.text);}
//	| LineBreak {System.out.printf("LineBreak    :: '\%s'\n", $LineBreak.text);}
//	| header -> ^(HEADER header)
	)* EOF -> ^(IMPEX  ^(COMMENTS Comment*) ^(ASSIGNEMENTS macro*))
//	:	( macroAssignement | impexBlock)* EOF
	;

macro
	:
	Macrodef {System.out.printf("Macrodef    :: '\%s'\n", $Macrodef.text);}
	Equals {System.out.printf("Equals    :: '\%s'\n", $Equals.text);}
	macroVal {System.out.printf("macroVal    :: '\%s\n'", $macroVal.text);}
	LineBreak? {System.out.printf("LineBreak    :: '\%s'", $LineBreak.text);}
	//Char*
//	unquoted_field  //{System.out.printf("Macroval    :: '\%s'\n", $text.text);}
	-> ^(ASSIGNEMENT Macrodef macroVal?)//macroText*)
//	:	Macrodef Equals  -> ^(ASSIGNEMENT Macrodef )
	;			


record
    : (Semicolon (quoted_field | field))+  LineBreak?
    ;
    
quoted_field
	: DoubleQuote ( Char | Semicolon | DoubleQuote DoubleQuote | Macrodef | LineBreak)*  DoubleQuote
	;

field
//    	: (options {greedy=false;}:Char)*
	:(Char | Macrodef)*
   	;
   	
macroVal	
	:   (Char | Semicolon | DoubleQuote | Identifier)* 
	;
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
InsertUpdate	:'INSERT_UPDATE';
Update		:'UPDATE';
Remove		:'REMOVE';

BatchMode		:'batchmode';
CacheUnique	:'cacheUnique';
Processor		:'processor';

Alias		:'alias';
AllowNull		:'allownull';
CellDecorator	:'cellDecorator';
CollectionDelimiter 	:'collection-delimiter';
Dateformat		:'dateformat';
Default		:'default';
ForceWrite		:'forceWrite';
IgnoreKeyCase	:'ignoreKeyCase';
IgnoreNull		:'ignorenull';
KeyToValueDelimiter	:'key2value-delimiter';
Lang		:'lang';
MapDelimiter	:'map-delimiter';
Mode		:'mode';
Numberformat	:'numberformat';
PathDelimiter	:'path-delimiter';
Pos		:'pos';
Translator		:'translator';
Unique		:'unique';
Virtual		:'virtual';


//Dollar		:'$';
DoubleQuote		:'"';
Semicolon		:';';
RightBracket	:']';
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
	:	'#' ~('\u000d' | '\u000a')* LineBreak?//{Skip();}
//	:	'#'(options {greedy=false;}: .)* ('\r'? '\n' | '\r')

	;

LineBreak
	:	'\u000d'? '\u000a'	// \r\n (Windows) or only \n (Unix) 
	|	'\u000d' 	// \r (MacOS)
   	;
   	
Ws
//	:	'\u0020' | '\u0009' {skip(); }
	:	' ' | '\t'  {skip();} //{$channel=HIDDEN; }
	;

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


//fragment Letter
//	:	'a' .. 'z' | 'A' .. 'Z';

//fragment Digit   
//  	:  	'0'..'9'  
// 	;

//fragment MacroExpression
//	:	Char+
//	;

//Char
//    : '\u0000' .. '\u0009'
///   | '\u000b' .. '\u000c'
//    | '\u000e' .. '\u0021'
 //   | '\u0023' .. '\u002b'
//   | '\u002d' .. '\uffff'
//    ;
Char
	:	~('\r' | '\n' | '"' | ';')
	;
