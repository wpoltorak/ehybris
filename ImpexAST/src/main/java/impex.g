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

impex	
	:	((Ws | Comment)  LineBreak?)* EOF -> ^(IMPEX  ^(COMMENTS Comment*))
//	:	( macroAssignement | impexBlock)* EOF
	;

//macroAssignement
//	:	MacroDefinition Equals MacroExpression  -> ^(ASSIGNEMENT MacroDefinition MacroExpression)
//	;			

Insert		:'INSERT';
InsertUpdate		:'INSERT_UPDATE';
Update		:'UPDATE';
Remove		:'REMOVE';

BatchMode		:'batchmode';
CacheUnique		:'cacheUnique';
Processor		:'processor';

Alias		:'alias';
AllowNull		:'allownull';
ForceWrite		:'forceWrite';
IgnoreKeyCase	:'ignoreKeyCase';
IgnoreNull		:'ignorenull';
Unique		:'unique';
Virtual		:'virtual';
Pos		:'pos';

//Dollar		:'$';
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

Macrodef
	:	'$' ('a' .. 'z' | 'A' .. 'Z' | '_') ('a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_')*
	;

//fragment MacroIdentifier
//	:	(Letter | Underscore)(Digit | Letter | Underscore)*
//	;	

Comment	
	@after {
  		setText(getText().substring(1, getText().length()));
	}
	:	'#' ~('\u000d' | '\u000a')*
	;

LineBreak
	:	'\u000d'? '\u000a'	// \r\n (Windows) or only \n (Unix) 
	|	'\u000d' 	// \r (MacOS)
   	;
   	
Ws
	:	'\u0020' | '\u0009' {skip();}
	;

Macroval
	:	~('\u0020' | '\u0009' | '\u000d' | '\u000a') ~('\u000d' | '\u000a')*
	;
	


//fragment Letter
//	:	'a' .. 'z' | 'A' .. 'Z';

//fragment Digit   
//  	:  	'0'..'9'  
// 	;

//fragment MacroExpression
//	:	Char+
//	;

//fragment Char
//	:	'\u0000' .. '\u0009'	//without \r \n " ; $
//	|	'\u000b' .. '\u000c'
//	|	'\u000e' .. '\u0021'
//	|	'\u0023'
//	|	'\u0025' .. '\u003a'	
//	|	'\u003c' .. '\uffff'
//	;
