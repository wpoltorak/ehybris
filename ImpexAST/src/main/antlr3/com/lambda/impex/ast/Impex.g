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
	ATTRIBUTES;
	ATTRIBUTE;
	ATTRIBUTE_NAME;
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
	DOCUMENTID_REF;
	MACRO_REF;
	ITEM_EXPRESSION;
}


@lexer::header {
 package com.lambda.impex.ast;  

import java.util.regex.Pattern;
import java.util.regex.Matcher;

}
 
@parser::header {
 package com.lambda.impex.ast;
  

import java.util.ArrayList;
import java.util.AbstractMap.SimpleImmutableEntry;  
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
}

@parser::members {

private ImpexContext context = new ImpexContext();

// comment out this constructor if you need to debug in ANTLRWorks
public ImpexParser(final ImpexContext context, final TokenStream input) {
   this(input);
   this.context = context;
}

@Override
public void reportError(final RecognitionException e) {
    if ( state.errorRecovery ) {
        return;
    }
    context.registerError( (CommonToken)e.token);
    super.reportError(e);
}

    /**
     * Use the current stacked followset to work out the valid tokens that can follow on from the current point in the parse, then recover
     * by eating tokens that are not a member of the follow set we compute.
     * 
     * This method is used whenever we wish to force a sync, even though the parser has not yet checked LA(1) for alt selection. This is
     * useful in situations where only a subset of tokens can begin a new construct (such as the start of a new statement in a block) and we
     * want to proactively detect garbage so that the current rule does not exit on on an exception.
     * 
     * We could override recover() to make this the default behavior but that is too much like using a sledge hammer to crack a nut. We want
     * finer grained control of the recovery and error mechanisms.
     * 
     * @author Jim Idle
     * @see http://www.antlr.org/wiki/display/ANTLR3/Custom+Syntax+Error+Recovery
     * 
     * @param follow set of tokens to recover to
     */
    private void syncToSet() {
        // Compute the followset that is in context wherever we are in the
        // rule chain/stack
        BitSet follow = state.following[state._fsp]; //computeContextSensitiveRuleFOLLOW();
        syncToSet(follow);
    }

    /**
     * This method synchronizes input with the given token set.<br/>
     * Used when due to an error antlr cannot loop back to correct position in the stream.<br/>
     * 
     * @author Jim Idle
     * @see http://www.antlr.org/wiki/display/ANTLR3/Custom+Syntax+Error+Recovery
     * 
     * @param follow set of tokens to recover to
     */
    protected void syncToSet(final BitSet follow) {
        int mark = -1;
        try {
            mark = input.mark();
            // Consume all tokens in the stream until we find a member of the follow
            // set, which means the next production should be guaranteed to be happy.
            //
            while (!follow.member(input.LA(1))) {
                if (input.LA(1) == Token.EOF) {
                    // Looks like we didn't find anything at all that can help us here
                    // so we need to rewind to where we were and let normal error handling
                    // bail out.
                    //
                    input.rewind();
                    mark = -1;
                    return;
                }
                final CommonToken token = (CommonToken) input.LT(1);
                //register error only if token is not blank
                if (token.getText() != null && token.getText().trim().length() != 0) {
                    context.registerError(token);
                }

                input.consume();
                // Now here, because you are consuming some tokens, yu will probably want
                // to raise an error message such as "Spurious elements after the class member were discarded"
                // using whatever your override of displayRecognitionError() routine does to record
                // error messages. The exact error my depend on context etc.
            }
        } catch (final Exception e) {
            // Just ignore any errors here, we will just let the recognizer
            // try to resync as normal - something must be very screwed.
            //
        } finally {
            // Always release the mark we took
            //
            if (mark != -1) {
                input.release(mark);
            }
        }
    }
}

@lexer::members {

private Token lastToken;
private boolean isHeader = false;
private final Pattern lineSeparatorPattern = Pattern.compile("([ \t]*)\\\\([ \t]*)(\r?\n|\r)([ \t]*)");
private ImpexContext context;

public ImpexLexer(ImpexContext context, CharStream input) {
    this(input, new RecognizerSharedState());
    this.context = context;
}

@Override
public void reportError(final RecognitionException e) {
    if ( state.errorRecovery ) {
        return;
    }
    context.registerError(e);
    super.reportError(e);
 }

  private void emit(String text, int type) {
    Token token = new CommonToken(type, text);
    token.setType(type);
    emit(token);
  }

 @Override
 public void emit(Token token) {
    if(token.getChannel() == Token.DEFAULT_CHANNEL) {
        lastToken = token;
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
        return lastToken != null && lastToken.getType() == Macrodef;
}


private boolean isModifierAssignment() {
    switch (lastToken.getType()) {
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
        case BatchMode:
        case CacheUnique:
        case Processor:
            return true;
    }
    return false;
}

private boolean isHeader(){
     return isHeader;
}

private String removeSeparators(final String text) {
    final Matcher m = lineSeparatorPattern.matcher(text);
    final StringBuffer sb = new StringBuffer();
    while (m.find()) {
        final boolean noWhitespaceCaptured = m.group(1).isEmpty() && m.group(4).isEmpty();
        m.appendReplacement(sb, noWhitespaceCaptured ? "" : " ");
    }
    m.appendTail(sb);
    return sb.toString();
}
    
private String removeLineBreaks(final String text){
    return text.replaceAll("(\r?\n|\r)", "");
}
}

parse
  :  (t=.{System.out.printf("\%s: \%-7s \n", tokenNames[$t.type], $t.text);})* EOF;

sync
	@init{
	    syncToSet();
	}:/* nothing */;

impex	: sync ((Lb |  block | macro)  sync)* EOF
	 -> ^(IMPEX ^(BLOCKS block*));
catch [RecognitionException ex] {
    reportError(ex);
    consumeUntil(input, new BitSet(new long[] { Insert, InsertUpdate, Update, Remove, Macrodef }));
}
	 
block	: header  (((Lb )+ (macro  (Lb )*)* record) )*
	-> ^(BLOCK header ^(RECORDS record*));

header
	: headerMode  headerTypeName (LBracket headerModifierAssignment (Comma  headerModifierAssignment)* RBracket)*  (Semicolon (attribute | quote attribute quote))* (Semicolon DocumentID{context.registerDocumentID((CommonToken)$DocumentID);} (Semicolon (attribute | quote attribute quote))*)? 
	-> ^(HEADER headerMode ^(TYPE headerTypeName) ^(MODIFIERS headerModifierAssignment*) ^(DOCUMENTID DocumentID?) ^(ATTRIBUTES attribute*)) ;

quote	:DoubleQuote | Quote;

headerModifierAssignment: headerModifier ValueAssignment
	-> ^(MODIFIER headerModifier ValueAssignment);

headerModifier
	:BatchMode | CacheUnique | Processor;

// handles record line: optional identifier (subtype) and semicolon separated list of fields and quoted fields
record
   	: Identifier? (field )+
    	-> ^(RECORD ^(SUBTYPE Identifier?) ^(FIELDS field+));
catch [RecognitionException ex] {
    reportError(ex);
    consumeUntil(input, new BitSet(new long[] { Lb }));
}
	
field	:QuotedField | Field ;

//handles special attributes (e..g ;@media[...]), normal attributes (e.g. ;uid[unique=true]) or skipped attributes (;;)
//attribute	: (specialAttribute | normalAttribute)?
//	-> ^(ATTRIBUTE specialAttribute? normalAttribute?);


//handles normal attributes (e.g. ;uid[unique=true])
//normalAttribute
//	: attributeName attributeModifiers?
//	-> attributeName ^(MODIFIERS attributeModifiers)?;

//attribute
//	: attributeName attributeModifiers?
//	-> attributeName ^(MODIFIERS attributeModifiers)?;

//handles special attributes (e..g ;@media[...])
//specialAttribute
//	:SpecialAttribute LBracket attributeModifierAssignment RBracket
//	-> SpecialAttribute ^(MODIFIERS ^(MODIFIER attributeModifierAssignment));

//attributeName
//	:Macrodef | (Identifier (Dot attributeName |  (LParenthesis  (DocumentID |  attributeName (Comma attributeName)*) RParenthesis ))?);


attributeName 
	:Macrodef -> ^(ATTRIBUTE_NAME  Macrodef)
	| SpecialAttribute -> ^(ATTRIBUTE_NAME SpecialAttribute)
	|(Identifier (Dot attributeName)?) -> ^(ATTRIBUTE_NAME Identifier attributeName?)
	| /* nothing */ ->^(ATTRIBUTE_NAME);  //In case there is an empty attribute
	
attribute
	:attributeName (LParenthesis  (DocumentID | attribute)(Comma (DocumentID | attribute))* RParenthesis )? (LBracket attributeModifierAssignment (Comma  attributeModifierAssignment)* RBracket)*
	-> ^(ATTRIBUTE attributeName ^(ITEM_EXPRESSION attribute* ^(DOCUMENTID_REF DocumentID*)) ^(MODIFIERS attributeModifierAssignment*));

attributeModifierAssignment
	: attributeModifier ValueAssignment
	-> ^(MODIFIER attributeModifier ValueAssignment);	

//attributeSubType	:	;
//attributeComposedType	:	;	

attributeModifier
	: Alias |AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull
	| KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual;

headerMode
	:Insert | InsertUpdate | Update | Remove;
	
headerTypeName
	:Identifier | headerMode | attributeModifier | headerModifier;
//block
//	: header  (
//	            options {
//	                greedy=false;
//	            } :   '\r' ('\n')? {newline();}
//	               |   '\n'         {newline();}
//	             )*
//	;



macro
	:Macrodef 
	(ValueAssignment {context.registerMacro($Macrodef, $ValueAssignment.text);} 
	|Equals {context.registerMacro($Macrodef, "");}); //if after equals there is no other value except EOF  Lexer produces Equals token rather than ValueAssignment

// Insert		
 		//@init { ((ImpexANTLRStringStream)input).caseInsensitive(); }
 		//@after { ((ImpexANTLRStringStream)input).caseSensitive(); }
 //		:'INSERT';
 //InsertUpdate		:'INSERT_UPDATE';
// Update		:'UPDATE';
// Remove		:'REMOVE';
	
 Insert		:('I' | 'i') ('N' | 'n') ('S' | 's') ('E' | 'e') ('R' | 'r' ) ('T' | 't');
InsertUpdate		:('I' | 'i') ('N' | 'n') ('S' | 's') ('E' | 'e') ('R' | 'r' ) ('T' | 't') '_' ('U' | 'u') ('P' | 'p') ('D' | 'd') ('A' | 'a') ('T' | 't') ('E' | 'e');
 Update		:('U' | 'u') ('P' | 'p') ('D' | 'd') ('A' | 'a') ('T' | 't') ('E' | 'e');
 Remove		:('R' | 'r' ) ('E' | 'e') ('M' | 'm') ('O' | 'o') ('V' | 'v') ('E' | 'e');

 BatchMode		:('B' | 'b') ('A' | 'a') ('T' | 't') ('C' | 'c') ('H' | 'h') ('M' | 'm') ('O' | 'o') ('D' | 'd') ('E' | 'e');
 CacheUnique		:('C' | 'c') ('A' | 'a') ('C' | 'c') ('H' | 'h') ('E' | 'e') ('U' | 'u') ('N' | 'n') ('I' | 'i') ('Q' | 'q') ('U' | 'u') ('E' | 'e');
 Processor		:('P' | 'p') ('R' | 'r') ('O' | 'o') ('C' | 'c') ('E' | 'e') ('S' | 's') ('S' | 's') ('O' | 'o') ('R' | 'r');
// BatchMode		:'batchmode';
 //CacheUnique	:'cacheUnique';
 //Processor		:'processor';


 Alias		:('A' | 'a') ('L' | 'l') ('I' | 'i') ('A' | 'a') ('S' | 's');
 AllowNull		:('A' | 'a') ('L' | 'l') ('L' | 'l') ('O' | 'o') ('W' | 'w') ('N' | 'n') ('U' | 'u') ('L' | 'l') ('L' | 'l');
 CellDecorator	:('C' | 'c') ('E' | 'e')('L' | 'l') ('L' | 'l') ('D' | 'd') ('E' | 'e') ('C' | 'c') ('O' | 'o') ('R' | 'r') ('A' | 'a') ('T' | 't') ('O' | 'o') ('R' | 'r');
 CollectionDelimiter 	:('C' | 'c') ('O' | 'o')('L' | 'l') ('L' | 'l') ('E' | 'e') ('C' | 'c') ('T' | 't') ('I' | 'i') ('O' | 'o') ('N' | 'n') '-' ('D' | 'd') ('E' | 'e') ('L' | 'l') ('I' | 'i') ('M' | 'm') ('I' | 'i') ('T' | 't') ('E' | 'e') ('R' | 'r');
 Dateformat		:('D' | 'd') ('A' | 'a') ('T' | 't') ('E' | 'e') ('F' | 'f')  ('O' | 'o') ('R' | 'r') ('M' | 'm') ('A' | 'a') ('T' | 't');
 Default		:('D' | 'd') ('E' | 'e') ('F' | 'f') ('A' | 'a') ('U' | 'u') ('L' | 'l') ('T' | 't');
 ForceWrite		:('F' | 'f')  ('O' | 'o') ('R' | 'r') ('C' | 'c') ('E' | 'e') ('W' | 'w') ('R' | 'r') ('I' | 'i') ('T' | 't') ('E' | 'e');
 IgnoreKeyCase	:('I' | 'i') ('G' | 'g') ('N' | 'n') ('O' | 'o') ('R' | 'r') ('E' | 'e') ('K' | 'k') ('E' | 'e') ('Y' | 'y') ('C' | 'c') ('A' | 'a') ('S' | 's') ('E' | 'e');
 IgnoreNull		:('I' | 'i') ('G' | 'g') ('N' | 'n') ('O' | 'o') ('R' | 'r') ('E' | 'e') ('N' | 'n') ('U' | 'u') ('L' | 'l') ('L' | 'l');
 KeyToValueDelimiter	:('K' | 'k') ('E' | 'e') ('Y' | 'y') '2' ('V' | 'v') ('A' | 'a') ('L' | 'l') ('U' | 'u') ('E' | 'e') '-' ('D' | 'd') ('E' | 'e') ('L' | 'l') ('I' | 'i') ('M' | 'm') ('I' | 'i') ('T' | 't') ('E' | 'e') ('R' | 'r');
 Lang		:('L' | 'l') ('A' | 'a') ('N' | 'n') ('G' | 'g');
 MapDelimiter	:('M' | 'm') ('A' | 'a') ('P' | 'p') '-' ('D' | 'd') ('E' | 'e') ('L' | 'l') ('I' | 'i') ('M' | 'm') ('I' | 'i') ('T' | 't') ('E' | 'e') ('R' | 'r');
 Mode		:('M' | 'm') ('O' | 'o') ('D' | 'd') ('E' | 'e');
 NumberFormat	:('N' | 'n') ('U' | 'u') ('M' | 'm') ('B' | 'b') ('E' | 'e') ('R' | 'r') ('F' | 'f')  ('O' | 'o') ('R' | 'r') ('M' | 'm') ('A' | 'a') ('T' | 't');
 PathDelimiter	:('P' | 'p') ('A' | 'a') ('T' | 't') ('H' | 'h') '-' ('D' | 'd') ('E' | 'e') ('L' | 'l') ('I' | 'i') ('M' | 'm') ('I' | 'i') ('T' | 't') ('E' | 'e') ('R' | 'r');
 Pos		:('P' | 'p') ('O' | 'o') ('S' | 's');
 Translator		:('T' | 't') ('R' | 'r') ('A' | 'a') ('N' | 'n') ('S' | 's') ('L' | 'l') ('A' | 'a') ('T' | 't') ('O' | 'o') ('R' | 'r');
 Unique		:('U' | 'u') ('N' | 'n') ('I' | 'i') ('Q' | 'q') ('U' | 'u') ('E' | 'e');
 Virtual		:('V' | 'v') ('I' | 'i') ('R' | 'r') ('T' | 't') ('U' | 'u') ('A' | 'a') ('L' | 'l');

 /*
 Alias		:'alias';
 AllowNull		:'allownull';
 CellDecorator	:'cellDecorator';
 CollectionDelimiter 	:'collection-delimiter';
 Dateformat		:'dateformat';
Default		:'default';
/ForceWrite		:'forceWrite';
 IgnoreKeyCase	:'ignoreKeyCase';
IgnoreNull		:'ignorenull';
KeyToValueDelimiter	:'key2value-delimiter';
Lang		:'lang';
MapDelimiter		:'map-delimiter';
 Mode		:'mode';
NumberFormat	:'numberformat';
PathDelimiter		:'path-delimiter';
Pos		:'pos';
Translator		:'translator';
Unique		:'unique';
Virtual		:'virtual';
*/
//Ignore	:'<ignore>';
Comma 	:',';
Dot	:'.';
DoubleQuote	:'"';
Quote	:'\'';
Semicolon	:';';
RBracket	:']';
LBracket	:'[';
LParenthesis 	:'(';
RParenthesis	:')';
Equals	:'=';
Or	:'|';

Bool	
	:'true' | 'false';

//fragment HeaderMode	
//	: Insert | InsertUpdate | Update | Remove;

//fragment HeaderModifier	
//	:BatchMode | CacheUnique | Processor;

//fragment AttributeModifier 	
//	:Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull
//	| KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual;

fragment Separator	
	:'\\' Ws* Lb;

//AttributeModifierAssignment
//	:Ws* AttributeModifier Ws* Equals Ws* ~('\r' | '\n' | ';' | '[' | ']')* Comma Ws* AttributeModifier;	
Macrodef
	:'$' ('a' .. 'z' | 'A' .. 'Z' | '_') ('a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_')*;

ValueAssignment
	:{isMacroAssignment()}?		=> '=' (~('\r' | '\n') | Separator)*		{String text = removeSeparators(getText()); setText(text.substring(1, text.length()).trim());}
	|{isModifierAssignment()}?	=> '=' ((' ' | '\t')* '"'(~('\r' | '\n' | '"') |  '"' '"')* '"' {String text = getText().substring(1, getText().length()).trim(); setText(text.substring(1, text.length() - 1));} | ~('\r' | '\n' | ';' | '"' |'[' | ']' | ',')* 	{setText(getText().substring(1, getText().length()).trim());} )
	| /* nothing */;

/*
Macroval
	@after {
		String text = getText();
		if (text.length() > 0){
			text = text.substring(1, text.length()).trim();
			if (text.startsWith("\"") && text.endsWith("\"")){
				text.substring(1, text.length() -1);
			}
			setText(text);
			
		}
	}
	:{isMacroAssignment()}?=> '='~('\r' | '\n')*|;


QuotedAttributeModifierval
	@after {
 	  String text = getText().substring(1, getText().length()).trim(); //remove leading equals and trim to remove any whitespace
 	  text = text.substring(1, text.length() - 1);		//remove surrounding doublequotes		
	  setText(text);
	}
	
	:{isArgumentModifierAssignment()}?=>'=' (' ' | '\t')* '"'~('\r' | '\n' )* '"'|;

fragment AttributeModifierval
	@after {
 	  String text = getText().substring(1, getText().length()).trim();
	  setText(text);
	}
	
	:{isArgumentModifierAssignment()}?=>'=' ~('\r' | '\n' | ';' | '"' |'[' | ']' | ',')*|;

*/	
/*	:{isArgumentModifierAssignment()}?=> (equals = '=' val+=Xxx* (comma=Comma Ws* modifier=AttributeModifier)?)
	{
	 
	   $equals.setType(Equals); emit($equals);
	  
	  if ($comma != null) {	
	    $comma.setType(Comma); emit($comma);
	   }
	   if (modifier != null){
	    $modifier.setType(Default); emit($modifier);
	   }
	   skip(); 
	} |;

*/
/*
	:{isArgumentModifierAssignment()}?=>( 
		(Equals Xxx* Comma Ws* AttributeModifier)=> equals = Equals val+=Xxx* comma=Comma Ws* modifier=AttributeModifier 
	{
	   $equals.setType(Equals); emit($equals);
	   $val.setType(AttributeModifierval); emit($val);
	    $comma.setType(Comma); emit($comma);
	    $modifier.setType(Default); emit($modifier);
	   skip(); 
	} 
	|(Equals Xxx* RBracket)=> equals=Equals val+=Xxx* bracket=RBracket
	{
	   $equals.setType(Equals); emit($equals);
	   $val.setType(AttributeModifierval); emit($val);
	    $bracket.setType(RBracket); emit($bracket);
	   skip(); 
	} 

	)|;
*/
//fragment Xxx :~('\r' | '\n' | ';' | '[' | ']');

// There can be meaningless ;;;;;;;; at the end of  user rights section
UserRights
	:'$START_USERRIGHTS' .* '$END_USERRIGHTS' (Semicolon | Ws)* {$channel=HIDDEN;};
	
BeanShell	
	:(('#%' ~('\r' | '\n')* | '"#%' (~('"') | '"' '"')* '"') Lb?) {$channel=HIDDEN;};
	
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
	@after { 
		String text = removeLineBreaks(getText());
		text = text.substring(1, text.length()).trim();  //remove leading semicolon and trim to remove any spaces
		text = text.substring(1, text.length() - 1).trim();      // remove surrounding doublequotes and again trim to remove any spaces
		setText(text);
		
		
	}
	:{isHeader() == false}?=> ';' Ws* '"' (~'"' | '"' '"')*  '"' | /* nothing */;

Field 	
	@after {
	    String text = removeSeparators(getText()); 
	    setText(text.substring(1, text.length()).trim()); //remove leading semicolon and trim to remove any spaces
	}
	:{isHeader() == false}?=> (';' (Char| Separator)*) | /* nothing */;

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

 Ws	
 	:(' ' | '\t') {$channel=HIDDEN;};
  Lb	
  	:('\r'? '\n' | '\r' );
Char	
	: ~('\r' | '\n' | '"' | ';' ) ;
	