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
	:	 (( macroAssignement| impexBlock | Comment))+ EOF -> ^(IMPEX ^(ASSIGNEMENTS macroAssignement*) ^(IMPEX_BLOCKS impexBlock*) ^(COMMENTS Comment*))
//	:	( macroAssignement | impexBlock)* EOF
	;

macroAssignement
	:	MacroDefinition Equals macroExpression  LineBreak? -> ^(ASSIGNEMENT MacroDefinition macroExpression)
	;		

macroExpression
	:	(MacroDefinition
	| 	Char
		)+
	;

MacroDefinition
	:	Dollar MacroIdentifier
	;
	

//header + rows or comments
impexBlock
	:	header  (row)*  -> ^(IMPEX_BLOCK header ^(ROWS row*))
	;

header	
	:	headerModeType  (Semicolon  Ws* (simpleAttribute |  complexAttribute))*  (LineBreak | EOF)  -> ^(headerModeType ^(ATTRIBUTES simpleAttribute* complexAttribute*))
	;

row	
	:	(Ws* Semicolon (Ws*  field)?  )* (LineBreak | EOF)  -> ^(ROW field*)
	;

//row	
//	:	(Semicolon (Ws*  field)?)* ( LineContinuation Ws* LineBreak row)*  -> ^(ROW field*  row*)
//	;

headerModeType	
	:	Ws* headerMode Ws+ Word  (Ws* headerModifier)? -> ^(HEADER_PREFIX headerMode ^(HEADER_TYPE Word headerModifier?))
	;

simpleAttribute
	:	Word attributeModifier? -> ^(SIMPLE_ATTRIBUTE Word attributeModifier?)	
	;

complexAttribute
	:	complexAttributeRef (Ws* attributeModifier)? -> ^(COMPLEX_ATTRIBUTE complexAttributeRef attributeModifier?)
	;


complexAttributeRef
	:	Word Ws* LeftParenthesis Ws* Word (('.' Word)? | (complexAttributeRef (Ws* Comma Ws* (Word | complexAttributeRef))?)) Ws* RightParenthesis 
	;

headerMode 
	:	Insert | InsertUpdate | Update | Remove;

headerModifier	
	:	LeftBracket 
		(BoolHeaderModifier Ws* Equals  Ws* Bool -> ^(Equals BoolHeaderModifier Bool)
		| WordHeaderModifier Ws* Equals  Ws* Word -> ^(Equals WordHeaderModifier Word)
		) Ws*  RightBracket
	;

attributeModifier
	:	LeftBracket 
		(BoolAttribModifier Ws* Equals Ws* Bool -> ^(Equals BoolAttribModifier Bool)
		| IntAttribModifier Ws* Equals Ws* Int  -> ^(Equals IntAttribModifier Int)
		| WordAttribModifier Ws* Equals Ws* Word -> ^(Equals WordAttribModifier Word)
		) Ws*  RightBracket
		
	;

field	
	:	(DoubleQuote (Char | Comma | DoubleQuote DoubleQuote)* DoubleQuote) | (Char | MacroDefinition)+
	;

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
RightBracket		:']';
LeftBracket		:'[';
LeftParenthesis 	:'(';
RightParenthesis	:')';
Equals		:'=';
Comma		: ',';
Underscore		:'_';
Hash		:'#';

LineContinuation
	:	 '\u2216' '\u2216' 	//\\ 
	;

Bool	
	:	'true' | 'false'
	;

Comment	
	:	Hash ~('\u000d' | '\u000a')* LineBreak?
	;
	
fragment Ws
	:	'\u0020' | '\u0009'
	;

 LineBreak
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

Int  
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
	