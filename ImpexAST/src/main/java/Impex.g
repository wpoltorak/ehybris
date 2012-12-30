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
 package output;  

import java.util.regex.Pattern;
import java.util.regex.Matcher;

}
 
@parser::header {
 package output;
  

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


    private final Map<String, List<SimpleImmutableEntry<Integer, String>>> macros = new HashMap<String, List<SimpleImmutableEntry<Integer, String>>>();
    private final Set<String> documentIDs = new HashSet<String>();
    private final Pattern macroPattern = Pattern.compile("$[a-zA-Z_][a-zA-Z_0-9]*");

    private void registerMacro(final Token def, final String val) {
        final String macrodef = def.getText();
        List<SimpleImmutableEntry<Integer, String>> macroval = macros.get(macrodef);
        if (macroval == null) {
            macroval = new ArrayList<SimpleImmutableEntry<Integer, String>>();
            macros.put(macrodef, macroval);
        }
        macroval.add(new SimpleImmutableEntry<Integer, String>(def.getLine(), val == null? "" : val));
    }

    private void registerDocumentID(String documentID){
    	if (documentIDs.contains(documentID)){
    		//TODO issue an error indicating that there is duplicated documentID definition
    		
    	}
    	documentIDs.add(documentID);
    }

    Map<String, List<SimpleImmutableEntry<Integer, String>>> getMacros(){
        return macros;
    }
    
    Set<String> getDocumentIDs(){
    	return documentIDs;
    }
    
    private boolean hasDocumentID(String documentID){
    	return documentIDs.contains(documentID);
    }
    
    private String getMacroVal(final String macroDef, final int refLine) {
        final List<SimpleImmutableEntry<Integer, String>> list = macros.get(macroDef);
        if (list == null) {
            // TODO in case there is no such macro definition treat it as normal text and issue an error 
            return macroDef;
        }

        for (int i = list.size() - 1; i >= 0; --i) {
            final SimpleImmutableEntry<Integer, String> entry = list.get(i);
            if (entry.getKey().intValue() < refLine) {
                String val = entry.getValue();
                final Matcher m = macroPattern.matcher(val);
                while (m.find()) {
                    final String nestedMacroDef = m.group();
                    final String nestedVal = getMacroVal(nestedMacroDef, entry.getKey());
                    val = m.replaceFirst(nestedVal);
                }
                return val;
            }
        }
        return macroDef;
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

  private void emit(String text, int type) {
    Token token = new CommonToken(type, text);
    token.setType(type);
    emit(token);
  }

 @Override
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

    private String removeSeparators(final String text) {
        final Pattern p = Pattern.compile("([ \t]*)\\\\([ \t]*)(\r?\n|\r)([ \t]*)");
        final Matcher m = p.matcher(text);
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

//default channel  	
impex	: (Lb |  block | macro)* EOF
	 -> ^(IMPEX ^(BLOCKS block*));


block	: header (Lb+ (macro Lb*)* record)+
	-> ^(BLOCK header ^(RECORDS record+));

header
	: headerMode  headerTypeName (LBracket headerModifierAssignment (Comma  headerModifierAssignment)* RBracket)*  (Semicolon (attribute | DoubleQuote attribute DoubleQuote))* (Semicolon DocumentID{registerDocumentID($DocumentID.text);} 	(Semicolon (attribute | DoubleQuote attribute DoubleQuote))*)? 
	-> ^(HEADER headerMode ^(TYPE headerTypeName) ^(MODIFIERS headerModifierAssignment*) ^(DOCUMENTID DocumentID?) ^(ATTRIBUTES attribute*)) ;

headerModifierAssignment: headerModifier Equals boolOrClassname
	-> ^(MODIFIER headerModifier boolOrClassname);

boolOrClassname
	:Bool | Classname;
	
headerModifier
	:BatchMode | CacheUnique | Processor;

// handles record line: optional identifier (subtype) and semicolon separated list of fields and quoted fields
record
   	: Identifier? field+
    	-> ^(RECORD ^(SUBTYPE Identifier?) ^(FIELDS field+));
    	
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
	| ->^(ATTRIBUTE_NAME);  //In case there is an empty attribute
	
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
	(ValueAssignment {registerMacro($Macrodef, $ValueAssignment.text);} 
	|Equals {registerMacro($Macrodef, "");}); //if after equals there is no other value except EOF  Lexer produces Equals token rather than ValueAssignment

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
	|{isArgumentModifierAssignment()}?	=> '=' ((' ' | '\t')* '"'(~('\r' | '\n' | '"') |  '"' '"')* '"' {String text = getText().substring(1, getText().length()).trim(); setText(text.substring(1, text.length() - 1));} | ~('\r' | '\n' | ';' | '"' |'[' | ']' | ',')* 	{setText(getText().substring(1, getText().length()).trim());} )
	|;

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
// \\ next line
UserRights
	:'$START_USERRIGHTS' .* '$END_USERRIGHTS' {$channel=HIDDEN;};
	
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
	:{isHeader() == false}?=> ';' Ws* '"' (~'"' | '"' '"')*  '"' |;

Field 	
	@after {
	    String text = removeSeparators(getText()); 
	    setText(text.substring(1, text.length()).trim()); //remove leading semicolon and trim to remove any spaces
	}
	:{isHeader() == false}?=> (';' (Char| Separator)*) |;

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
	