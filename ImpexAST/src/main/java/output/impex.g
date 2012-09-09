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
	:	  (Comment LineBreak?)+ EOF -> ^(IMPEX  ^(COMMENTS Comment*))
//	:	( macroAssignement | impexBlock)* EOF
	;

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

Dollar		:'$';
Semicolon		:';';
RightBracket		:']';
LeftBracket		:'[';
LeftParenthesis 	:'(';
RightParenthesis	:')';
Equals		:'=';
Comma		: ',';
Underscore		:'_';
Hash		:'#';
LineContinuation	:'\\\\';

Comment	
	:	Hash ~('\u000d' | '\u000a')*
	;

fragment  LineBreak
	:	'\u000d'? '\u000a'	// \r\n (Windows) or only \n (Unix)
	|	'\u000d'		// \r (MacOS)
   	;

fragment Ws
	:	'\u0020' | '\u0009'
	;
