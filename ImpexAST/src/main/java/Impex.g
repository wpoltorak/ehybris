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
	DOCUMENTID;
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

private boolean isMacroAssignment() {
        final Token token = getToken(0);
        return token != null && token.getType() == Macrodef;
//            return input.LA(-1) == Macrodef;
}


    private boolean isArgumentModifierAssignment() {
        final Token token = getToken(0);

        switch (token.getType()) {
            case Alias:
            case AllowNull:
            case CellDecorator:
            case CollectionDelimiter:
            case Dateformat:
            case Default:
            case ForceWrite:
            case IgnoreKeyCase:
            case IgnoreNull:
            case KeyToValueDelimiter:
            case Lang:
            case MapDelimiter:
            case Mode:
            case NumberFormat:
            case PathDelimiter:
            case Pos:
            case Translator:
            case Unique:
            case Virtual:
                return true;
        }
        return false;
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
	 ^(ASSIGNEMENTS macro)*  ^(BLOCKS block*));
//if(input.LA(1) != ']') return true;

block	: header (Lb+  record)+
	-> ^(BLOCK header ^(RECORDS record+));

header
	: headerMode  Identifier headerModifiers?  (Semicolon DocumentID)? (Semicolon attribute)+
	-> ^(HEADER headerMode ^(TYPE Identifier) ^(MODIFIERS headerModifiers)? ^(DOCUMENTID DocumentID)? ^(ATTRIBUTES attribute+)) ;

headerModifiers 
	: (LBracket headerModifierAssignment (Comma  headerModifierAssignment)* RBracket)+
	-> ^(MODIFIER headerModifierAssignment)+;

headerModifierAssignment: headerModifier Equals (hmValue=Bool | hmValue=Classname)
	-> headerModifier $hmValue;

headerModifier
	:BatchMode | CacheUnique | Processor;

// handles record line: optional identifier (subtype) and semicolon separated list of fields and quoted fields
record
   	: Identifier? (QuotedField | Field)+ // ( Lb | (LineContinuation {newline();} record))
    	-> ^(RECORD ^(SUBTYPE Identifier)? ^(FIELDS QuotedField* Field*));

//handles special attributes (e..g ;@media[...]), normal attributes (e.g. ;uid[unique=true]) or skipped attributes (;;)
attribute	: (specialAttribute | normalAttribute)?
	-> ^(ATTRIBUTE specialAttribute? normalAttribute?);

//handles normal attributes (e.g. ;uid[unique=true])
normalAttribute
	: attributeName attributeModifiers?
	-> attributeName ^(MODIFIERS attributeModifiers)?;

//handles special attributes (e..g ;@media[...])
specialAttribute
	:SpecialAttribute LBracket attributeModifierAssignment RBracket
	-> SpecialAttribute ^(MODIFIERS ^(MODIFIER attributeModifierAssignment));
			
attributeModifiers
	: (LBracket attributeModifierAssignment (Comma  attributeModifierAssignment)* RBracket)+
	-> ^(MODIFIER attributeModifierAssignment)+;

attributeModifierAssignment
	: attributeModifier ArgumentModifierval;	
	
attributeName	
	:Macrodef | (Identifier (Dot Identifier |  (LParenthesis  (DocumentID |  attributeName (Comma attributeName)*) RParenthesis ))?);

macro
	:Macrodef Macroval
	-> ^(ASSIGNEMENT Macrodef Macroval);

attributeModifier
	: Alias |AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull
	| KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual;

headerMode
	:Insert | InsertUpdate | Update | Remove;
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

 BatchMode	:'batchmode';
 CacheUnique	:'cacheUnique';
 Processor	:'processor';

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

//Ignore	:'<ignore>';
Comma 	:',';
Dot	:'.';
DoubleQuote	:'"';
Semicolon	:';';
RBracket	:']';
LBracket	:'[';
LParenthesis 	:'(';
RParenthesis	:')';
Equals	:'=';

Bool	:'true' | 'false';

fragment HeaderMode	
	: Insert | InsertUpdate | Update | Remove;

fragment HeaderModifier	
	:BatchMode | CacheUnique | Processor;

fragment ArgumentModifier 	
	:Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull
	| KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual;

Macrodef
	:'$' ('a' .. 'z' | 'A' .. 'Z' | '_') ('a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_')*;


Macroval
	@after {setText(getText().substring(1, getText().length()).trim());}
	:{isMacroAssignment()}?=> ('='~('\r' | '\n')*) | 
	 ;
	
ArgumentModifierval
	@after {
 	  String text = getText().substring(1, getText().length()).trim();
	  if (text.endsWith(",")){
	    text = text.substring(0, text.length() - 1);
	  }
	  setText(text);
	}
		:{isArgumentModifierAssignment()}?=> '='~('\r' | '\n' | ';' | '[' | ']' | ',')*;

SpecialAttribute
	:'@' ('a' .. 'z' | 'A' .. 'Z' | '_') ('a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_')*;

DocumentID
	:'&' ('a' .. 'z' | 'A' .. 'Z' | '_') ('a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_')*;
	
Identifier
	:('a' .. 'z' | 'A' .. 'Z' | '_') ('a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_')*;

Classname
	:(('a' .. 'z')+ '.')+ 'A' .. 'Z' ('A' .. 'Z' | 'a' .. 'z')+;

Comment	
	@after { setText(getText().substring(1, getText().length())); }
	:'#' ~('\r' | '\n')* Lb? {$channel=HIDDEN;};

//IgnoredField
//	:';' Ignore;
	
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
Char	: ~('\r' | '\n' | '"' | ';' ) ;
// \\ next line
NextRow	:'\\\\' Ws* Lb{$channel=HIDDEN;};
