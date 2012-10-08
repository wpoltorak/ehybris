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
impex	
	: (Comment {System.out.printf("Comment    :: '\%s'\n", $Comment.text);}
	| Ws {System.out.printf("Ws    :: '\%s'\n", $Ws.text);}
	| LineBreak {System.out.printf("LineBreak    :: '\%s'\n", $LineBreak.text);}
	| macroAssignement
//	| header -> ^(HEADER header)
	)* EOF -> ^(IMPEX  ^(COMMENTS Comment*) ^(ASSIGNEMENTS macroAssignement*))
//	:	( macroAssignement | impexBlock)* EOF
	;

macroAssignement
	:
	Macrodef {System.out.printf("Macrodef    :: '\%s'\n", $Macrodef.text);}
	Ws*
	Macroval {System.out.printf("Macroval    :: '\%s'\n", $Macroval.text);}
	-> ^(ASSIGNEMENT Macrodef Macroval)
//	:	Macrodef Equals  -> ^(ASSIGNEMENT Macrodef )
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
	:	'$' Identifier
	;

Identifier
	:	('a' .. 'z' | 'A' .. 'Z' | '_') ('a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_')*
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
	//:	'\u0020' | '\u0009' {$channel=HIDDEN; }
	:	'\u0020' | '\u0009' {$channel=HIDDEN; }
	;

Macroval
	@after {
//		int last = getText().length();
//		int lastn = getText().lastIndexOf('\n');
//		int lastr = getText().lastIndexOf('\r');
//		
//		last = lastn > 0 ? lastn : last;
//		last = lastr > 0 ? lastr : last;
		//to strip '=' prefix and LineBreak suffix
//  		setText(getText().substring(1, last));
  		setText(getText().substring(1, getText().length()).trim());
	}
	:	Equals (options {greedy=false;}: .)* LineBreak
	;

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

//fragment Char
//	:	'\u0000' .. '\u0009'	//without \r \n " ; $
//	|	'\u000b' .. '\u000c'
//	|	'\u000e' .. '\u0021'
//	|	'\u0023'
//	|	'\u0025' .. '\u003a'	
//	|	'\u003c' .. '\uffff'
//	;
