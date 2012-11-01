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
	ATTRIBUTES;
	ATTRIBUTE;
	HEADER;
	IMPEX;
	BLOCK;
	BLOCKS;
	MODIFIER;
	ROW;
	ROWS;
}


@lexer::header {
 package output;
}
 
@parser::header {
  package output;
}

@parser::members{
    private boolean lineBreakNotFound() {
        int index = ((CommonTokenStream)input).LT(-1).getTokenIndex();
        int current  = ((CommonTokenStream)input).index();
        for (int i = index + 1; i < current; i++){
            if (input.get(i).getType() == Lb){
                return false;
            }
        }
     return true; 	
    }

}

@lexer::members {


public class TokenList {

    private final ArrayList<Token> array;
    private final int capacity;

    public TokenList(final int capacity) {
        this.capacity = capacity;
        array = new ArrayList<Token>(capacity + 1);
    }

    public void add(final Token token) {
        if (array.size() == capacity) {
            array.remove(0);
        }
        array.add(token);
    }

    public Token get(final int num) {
        if (num > capacity - 1) {
            throw new IllegalArgumentException("Greater than list size");
        }

        return array.get(capacity - 1 - num);
    }

}
private final TokenList tokens = new TokenList(1);
private boolean isHeader = false;

public void emit(Token token) {
    if(token.getChannel() == Token.DEFAULT_CHANNEL) {
        tokens.add(token);
    }
    int t = token.getType();
    if (t == Insert || t == InsertUpdate || t  == Update || t ==Remove){
     isHeader = true;	
    }
    
     
     if (t == Lb){
     isHeader = false;	
    }
    super.emit(token);
}

private boolean isMacroAssignement() {
        final Token macrodef = getToken(0);
        return macrodef != null && macrodef.getType() == Macrodef;
//            return input.LA(-1) == Macrodef;
}

private boolean isHeader(){

 return isHeader;
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
	 block// {System.out.printf("macro    :: '\%s'\n", $macro.text);}
	| macro //{System.out.printf("macro    :: '\%s'\n", $macro.text);}
	//| Comment {System.out.printf("Comment    :: '\%s'\n", $Comment.text);}
	)*
	EOF
	 -> ^(IMPEX  
	// ^(COMMENTS Comment*) 
	 ^(ASSIGNEMENTS macro*) 
	 ^(BLOCKS block*)  
	 //^(HEADERS header*)
	 )//^(ROWS record*))
	;
//if(input.LA(1) != ']') return true;

block	: header Lb (record)+
	-> ^(BLOCK header ^(ROWS record+));

header
	: headerMode  Identifier ('[' headerModifier '=' (hmValue=Bool | hmValue=Identifier) ']')?  (';' attribute)*
	-> ^(HEADER headerMode Identifier ^(MODIFIER headerModifier $hmValue)? ^(ATTRIBUTES attribute*)) ;

record
   	:(QuotedField | Field)+ ((('\r'? '\n' | '\r' )) | EOF)// ( Lb | (LineContinuation {newline();} record))
//   	:(quoted_field | field) (Semicolon (quoted_field | field))* 
    	-> ^(ROW QuotedField+ Field+);
    	
//attributes	:{lineBreakNotFound() }?=> (';' attribute)*
//	-> attribute*;	
	
attribute	: identifier ('[' attributeModifier '=' (amValue=Bool |amValue=Identifier) ']')?
	-> ^(ATTRIBUTE identifier ^(MODIFIER attributeModifier $amValue)?);//^(ARGUMENTS)) ;

identifier	:Identifier ('.' Identifier |  ('(' identifier (',' identifier)* ')'))?;

    	
//(quoted_field | field) (Semicolon (quoted_field | field))* 	    	
macro
	:Macrodef Macroval
	-> ^(ASSIGNEMENT Macrodef Macroval);


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

 Insert		:'INSERT';
 InsertUpdate		:'INSERT_UPDATE';
 Update		:'UPDATE';
 Remove		:'REMOVE';
//Mode		:'INSERT' | 'INSERT_UPDATE' | 'UPDATE' | 'REMOVE';
headerMode		:Insert | InsertUpdate | Update | Remove;

 BatchMode		:'batchmode';
 CacheUnique		:'cacheUnique';
 Processor		:'processor';
//HeaerdModifier		:'batchmode' | 'cacheUnique' | 'processor';
headerModifier		:BatchMode | CacheUnique | Processor;
		

 Alias			:'alias';
 AllowNull		:'allownull';
 CellDecorator		:'cellDecorator';
 CollectionDelimiter 	:'collection-delimiter';
 Dateformat		:'dateformat';
 Default		:'default';
 ForceWrite		:'forceWrite';
 IgnoreKeyCase		:'ignoreKeyCase';
 IgnoreNull		:'ignorenull';
 KeyToValueDelimiter	:'key2value-delimiter';
 Lang			:'lang';
 MapDelimiter		:'map-delimiter';
 Mode		:'mode';
 NumberFormat		:'numberformat';
 PathDelimiter		:'path-delimiter';
 Pos			:'pos';
 Translator		:'translator';
 Unique		:'unique';
 Virtual		:'virtual';

//AttribModifier	: 'alias' | 'allownull' | 'cellDecorator' | 'collection-delimiter' | 'dateformat' | 'default' | 'forceWrite' | 'ignoreKeyCase' | 'ignorenull' 
//		| 'key2value-delimiter' | 'lang' | 'map-delimiter' | 'mode' | 'numberformat' | 'path-delimiter' | 'pos' | 'translator' | 'unique' | 'virtual';
attributeModifier	: Alias |AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull
		| KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual;



//Dollar		:'$';
DoubleQuote		:'"';
Semicolon		:';';
RightBracket		:']';
LeftBracket		:'[';
LeftParenthesis 	:'(';
RightParenthesis	:')';
Equals		:'=';
//Comma		:',';
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
	://{isHeader()}?=>
	 ('a' .. 'z' | 'A' .. 'Z' | '_') ('a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_')*;

//Classname
//	:(('a' .. 'z' | 'A' .. 'Z' | '$') ('0' .. '9' | '_' | '.' | '$')?)*  ('a' .. 'z' | 'A' .. 'Z' | '$') '0' .. '9' | '_' | '$')*;

Comment	
	@after { setText(getText().substring(1, getText().length())); }
	:'#' ~('\r' | '\n')* {$channel=HIDDEN;};

QuotedField 	
	@after { setText(getText().substring(1, getText().length())); }
	:';' '"' (Char | '"' '"' | ';')*  '"';

Field 	
	@after { setText(getText().substring(1, getText().length())); }
	:{isHeader() == false}?=> ';' Char*;

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
//Id_or_field 
//	:	{isHeader()}?=>Identifier
//		| Field;
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