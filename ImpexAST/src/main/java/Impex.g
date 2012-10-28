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
	ATTRIBUTE;
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

@lexer::members {

private final output.TokenList tokens = new output.TokenList(1);

public void emit(Token token) {
    if(token.getChannel() == Token.DEFAULT_CHANNEL) {
        tokens.add(token);
    }
    super.emit(token);
}

private boolean isMacroAssignement() {
 //   final Token equalsToken = getToken(0);
//    if(equalsToken != null && equalsToken.getType() != Equals){
//    final Token macrodef = getToken(1);
        final Token macrodef = getToken(0);
        return macrodef != null && macrodef.getType() == Macrodef;
//    }
//    return false;
}

private Token getToken(int num) {
    return tokens.get(num);
}
}


//impex 	:
//	.* EOF	
//
parse
  :  (t=.{System.out.printf("\%s: \%-7s \n", tokenNames[$t.type], $t.text);})* EOF
  ;
  	
impex	: ( 
	record 
	| 
	macro {System.out.printf("macro    :: '\%s'\n", $macro.text);}
	|
	//| record {System.out.printf("record    :: '\%s'\n", $record.text);}
	Comment {System.out.printf("Comment    :: '\%s'\n", $Comment.text);}
//	| header -> ^(HEADER header)
	)*
	EOF
	 -> ^(IMPEX  ^(COMMENTS Comment*) ^(ASSIGNEMENTS macro*) )//^(ROWS record*))
	;
//if(input.LA(1) != ']') return true;

header
	: HeaderMode  Identifier (LeftBracket HeaderModifier Equals (Bool | Identifier) RightBracket)? Semicolon
	-> ^(HEADER Identifier ^(ATTRIBUTE HeaderModifier Bool? Identifier?) );//^(ARGUMENTS)) ;
	
	
record
   	:(quoted_field | field) (Semicolon (quoted_field | field))* ( Lb | (LineContinuation {newLine();} record))
//   	:(quoted_field | field) (Semicolon (quoted_field | field))* 
    	-> ^(ROW quoted_field* field*);
//(quoted_field | field) (Semicolon (quoted_field | field))* 	    	
macro
	:Macrodef Macroval
	-> ^(ASSIGNEMENT Macrodef Macroval);

quoted_field 	
	:DoubleQuote (Char | DoubleQuote DoubleQuote | Semicolon)*  DoubleQuote;

field 	
	:Char*;

//block
//	: header  (
//	            options {
//	                greedy=false;
//	            } :   '\r' ('\n')? {newline();}
//	               |   '\n'         {newline();}
//	             )*
//	;
	
	

//row
//	:value*
//	;
	
//value
//	:
//	';'.*';'
//	;	

fragment Insert		:'INSERT';
fragment InsertUpdate		:'INSERT_UPDATE';
fragment Update		:'UPDATE';
fragment Remove		:'REMOVE';
//Mode		:'INSERT' | 'INSERT_UPDATE' | 'UPDATE' | 'REMOVE';
HeaderMode		:Insert | InsertUpdate | Update | Remove;

fragment BatchMode		:'batchmode';
fragment CacheUnique		:'cacheUnique';
fragment Processor		:'processor';
//HeaerdModifier		:'batchmode' | 'cacheUnique' | 'processor';
HeaderModifier		:BatchMode | CacheUnique | Processor;
		

fragment Alias		:'alias';
fragment AllowNull		:'allownull';
fragment CellDecorator		:'cellDecorator';
fragment CollectionDelimiter 	:'collection-delimiter';
fragment Dateformat		:'dateformat';
fragment Default		:'default';
fragment ForceWrite		:'forceWrite';
fragment IgnoreKeyCase	:'ignoreKeyCase';
fragment IgnoreNull		:'ignorenull';
fragment KeyToValueDelimiter	:'key2value-delimiter';
fragment Lang		:'lang';
fragment MapDelimiter		:'map-delimiter';
fragment Mode		:'mode';
fragment NumberFormat	:'numberformat';
fragment PathDelimiter		:'path-delimiter';
fragment Pos		:'pos';
fragment Translator		:'translator';
fragment Unique		:'unique';
fragment Virtual		:'virtual';

//AttribModifier	: 'alias' | 'allownull' | 'cellDecorator' | 'collection-delimiter' | 'dateformat' | 'default' | 'forceWrite' | 'ignoreKeyCase' | 'ignorenull' 
//		| 'key2value-delimiter' | 'lang' | 'map-delimiter' | 'mode' | 'numberformat' | 'path-delimiter' | 'pos' | 'translator' | 'unique' | 'virtual';
AttribModifier	: Alias |AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull
		| KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual;



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
	:'$' ('a' .. 'z' | 'A' .. 'Z' | '_') ('a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_')*;


Macroval
	@after {setText(getText().substring(1, getText().length()).trim());}
	:{isMacroAssignement()}?=> '='~('\r' | '\n')* ;
	
Identifier
	:('a' .. 'z' | 'A' .. 'Z' | '_') ('a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_')*;

//Classname
//	:(('a' .. 'z' | 'A' .. 'Z' | '$') ('0' .. '9' | '_' | '.' | '$')?)*  ('a' .. 'z' | 'A' .. 'Z' | '$') '0' .. '9' | '_' | '$')*;

Comment	
	@after { setText(getText().substring(1, getText().length())); }
	:'#' ~('\r' | '\n')* ;

//BeanShell	
//	:'#$' ~('\r' | '\n')* ;

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

// Ws	:(' ' | '\t' | '\r'? '\n' | '\r' ) {$channel=HIDDEN;};
 Ws	:(' ' | '\t') {$channel=HIDDEN;};
  Lb	:('\r'? '\n' | '\r' ){$channel=HIDDEN;};  //{skip();} 
Char	: ~('\r' | '\n' | '"' | ';') ;