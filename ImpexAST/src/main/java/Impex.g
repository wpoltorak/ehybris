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
	MODIFIERS;
	MODIFIER;
	RECORD;
	RECORDS;
	TYPE;
	SUBTYPE;
	FIELDS;
}


@lexer::header {
 package output;  
}
 
@parser::header {
  package output;
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

parse
  :  (t=.{System.out.printf("\%s: \%-7s \n", tokenNames[$t.type], $t.text);})* EOF;
  	
impex	: (Lb |  block | macro)* EOF
	 -> ^(IMPEX  
	// ^(COMMENTS Comment*) 
	 ^(ASSIGNEMENTS macro)*  ^(BLOCKS block)*);
//if(input.LA(1) != ']') return true;

block	: header (Lb+  record)+
	-> ^(BLOCK header ^(RECORDS record+));

header
	: headerMode  Identifier headerModifiers?  (';' attribute)*
	-> ^(HEADER headerMode ^(TYPE Identifier) ^(MODIFIERS headerModifiers)? ^(ATTRIBUTES attribute)*) ;

headerModifiers 
	: ('[' headerModifierAssignment (','  headerModifierAssignment)*']')+
	-> ^(MODIFIER headerModifierAssignment)+;

headerModifierAssignment: headerModifier '=' (hmValue=Bool | hmValue=Classname)
	-> headerModifier $hmValue;

headerModifier	:BatchMode | CacheUnique | Processor;

record
   	: Identifier? (QuotedField | Field)+ // ( Lb | (LineContinuation {newline();} record))
    	-> ^(RECORD ^(SUBTYPE Identifier)? ^(FIELDS QuotedField* Field*));
    	
attribute	: identifier  attributeModifiers?
	-> ^(ATTRIBUTE identifier ^(MODIFIERS attributeModifiers)?);

attributeModifiers
	: ('[' attributeModifierAssignment (','  attributeModifierAssignment)*']')+
	-> ^(MODIFIER attributeModifierAssignment)+;

attributeModifierAssignment
	: attributeModifier '=' (hmValue=Bool | hmValue=Identifier |  hmValue=Classname);
	
identifier	:Identifier ('.' Identifier |  ('(' identifier (',' identifier)* ')'))?;

macro
	:Macrodef Macroval
	-> ^(ASSIGNEMENT Macrodef Macroval);

attributeModifier	: Alias |AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull
		| KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual;


headerMode		:Insert | InsertUpdate | Update | Remove;
//block
//	: header  (
//	            options {
//	                greedy=false;
//	            } :   '\r' ('\n')? {newline();}
//	               |   '\n'         {newline();}
//	             )*
//	;

 Insert		
 		//@init { ((ImpexANTLRStringStream)input).caseInsensitive(); }
 		//@after { ((ImpexANTLRStringStream)input).caseSensitive(); }
 		:'INSERT';
 InsertUpdate		:'INSERT_UPDATE';
 Update		:'UPDATE';
 Remove		:'REMOVE';
	
// Insert		:('I' | 'i') ('N' | 'n') ('S' | 's') ('E' | 'e') ('R' | 'r' ) ('T' | 't');
 //InsertUpdate		:('I' | 'i') ('N' | 'n') ('S' | 's') ('E' | 'e') ('R' | 'r' ) ('T' | 't') '_' ('U' | 'u') ('P' | 'p') ('D' | 'd') ('A' | 'a') ('T' | 't') ('E' | 'e');
// Update		:('U' | 'u') ('P' | 'p') ('D' | 'd') ('A' | 'a') ('T' | 't') ('E' | 'e');
/// Remove		:('R' | 'r' ) ('E' | 'e') ('M' | 'm') ('O' | 'o') ('V' | 'v') ('E' | 'e');

 BatchMode		:'batchmode';
 CacheUnique		:'cacheUnique';
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
 NumberFormat	:'numberformat';
 PathDelimiter	:'path-delimiter';
 Pos		:'pos';
 Translator		:'translator';
 Unique		:'unique';
 Virtual		:'virtual';

DoubleQuote		:'"';
Semicolon		:';';
RightBracket		:']';
LeftBracket		:'[';
LeftParenthesis 	:'(';
RightParenthesis	:')';
Equals		:'=';

LineContinuation	:'\\\\';
Bool		:'true' | 'false';

Macrodef
	:'$' ('a' .. 'z' | 'A' .. 'Z' | '_') ('a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_')*;


Macroval
	@after {setText(getText().substring(1, getText().length()).trim());}
	:{isMacroAssignement()}?=> '='~('\r' | '\n')* ;
	
Identifier
	:('a' .. 'z' | 'A' .. 'Z' | '_') ('a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_')*;

Classname
	:(('a' .. 'z')+ '.')+ 'A' .. 'Z' ('A' .. 'Z' | 'a' .. 'z')+;

Comment	
	@after { setText(getText().substring(1, getText().length())); }
	:'#' ~('\r' | '\n')* Lb? {$channel=HIDDEN;};

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

 Ws	:(' ' | '\t') {$channel=HIDDEN;};
  Lb	:('\r'? '\n' | '\r' );//{$channel=HIDDEN;};
Char	: ~('\r' | '\n' | '"' | ';') ;