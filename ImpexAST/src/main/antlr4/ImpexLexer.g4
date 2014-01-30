lexer grammar ImpexLexer;

tokens {
    BooleanAttributeModifier,
    IntAttributeModifier,
    DateFormatAttributeModifier,
    NumberFormatAttributeModifier,
    ClassAttributeModifier,
    TextAttributeModifier
}

fragment A :[Aa]Separator*;
fragment B :[Bb]Separator*;
fragment C :[Cc]Separator*;
fragment D :[Dd]Separator*;
fragment E :[Ee]Separator*;
fragment F :[Ff]Separator*;
fragment G :[Gg]Separator*;
fragment H :[Hh]Separator*;
fragment I :[Ii]Separator*;
fragment J :[Jj]Separator*;
fragment K :[Kk]Separator*;
fragment L :[Ll]Separator*;
fragment M :[Mm]Separator*;
fragment N :[Nn]Separator*;
fragment O :[Oo]Separator*;
fragment P :[Pp]Separator*;
fragment Q :[Qq]Separator*;
fragment R :[Rr]Separator*;
fragment S :[Ss]Separator*;
fragment T :[Tt]Separator*;
fragment U :[Uu]Separator*;
fragment V :[Vv]Separator*;
fragment W :[Ww]Separator*;
fragment X :[Xx]Separator*;
fragment Y :[Yy]Separator*;
fragment Z :[Zz]Separator*;
fragment DASH : [-]Separator*;
fragment UNDERSCORE : [_]Separator*;
fragment TWO : [2]Separator*;
//Types
Insert
    : I N S E R [Tt] -> pushMode(header);
InsertUpdate	
    : I N S E R T UNDERSCORE U P D A T [Ee] -> pushMode(header);
Update		
    : U P D A T [Ee] -> pushMode(header);
Remove
    : R E M O V [Ee] -> pushMode(header);

Semicolon
    :';';
Comma
    :',';
Dot
    :'.';
DoubleQuote
    :'"';
Quote
    :'\'';
RBracket
    :']';
LBracket
    :'[';
LParenthesis
    :'(';
RParenthesis
    :')';
Equals
    : '=';
Or
    :'|';


Separator
    : '\\' Ws* Lb -> skip;

fragment FieldSeparator : Ws* Separator Ws*;

DocumentID
    : '&' Separator* Identifier;
	
SpecialAttribute
    : '@' Separator* Identifier;

Identifier
    :[a-zA-Z_](Separator* [a-zA-Z0-9_])*;

Macrodef
    : '$' Separator* Identifier -> pushMode(macro); 

           
Comment
    : '#' .*? (Lb | EOF) -> skip;
/*      
      { 
       setText(getText().substring(1, getText().length())); 
       skip();
      };
*/

QuotedField
    : ';' FieldSeparator* '"' (~'"'|'"''"')* '"' -> pushMode(record), type(Field);
/*
      {
        String text = getText();
       	text = text.substring(1, text.length()).trim();  //remove leading semicolon and trim to remove any spaces
	text = text.substring(1, text.length() - 1).trim();      // remove surrounding doublequotes and again trim to remove any spaces
	setText(text);
        setType(Field);
      };
*/

Field
    : ';' FieldSeparator* (~[\r\n";] Separator*)* -> pushMode(record);

/*      
      {
        String text = removeSeparators(getText());
        setText(text.substring(1, text.length()).trim()); //remove leading semicolon and trim to remove any spaces
      }Field+;;
*/

Lb
    :('\r'?'\n'|'\r') -> skip;

Ws
    : [ \t] -> skip;

mode record;

RecordSeparator : Separator -> type(Separator), skip;

RecordQuotedField
    : QuotedField -> type(Field)
    ;

/*
      {
        String text = getText();
       	text = text.substring(1, text.length()).trim();  //remove leading semicolon and trim to remove any spaces
	text = text.substring(1, text.length() - 1).trim();      // remove surrounding doublequotes and again trim to remove any spaces
	setText(text);
        setType(Field);
      };
*/

RecordField
    : Field -> type(Field)
    ;

RecordLb
    :Lb -> type(Lb), popMode
    ;

RecordWs
    : Ws -> type(Ws)
    ;

/*
/work/projects/yeclipse/ImpexAST/src/main/java/com/lambda/impex/ast
*/

mode macro;

Macroval
    : '=' (Separator* ~[\r\n])*
      -> popMode;
/*
    {
      String text = removeSeparators(getText()); //remove possible separators from the middle of text
      setText(text.substring(1, text.length()).trim()); //remove leading equals character and trim to remove any spaces
      popMode();
    };
*/
MacroWs : Ws -> type(Ws), skip;

MacroSeparator : Separator -> type(Separator), skip;

mode header;

//Type attributes
BatchMode
    : B A T C H M O D [Ee] -> pushMode(modifier);
CacheUnique	
    : C A C H E U N I Q U [Ee] -> pushMode(modifier);
Processor	
    : P R O C E S S O [Rr] -> pushMode(modifier);
//Argument attributes
Alias		
    : A L I A [Ss] -> pushMode(modifier), type(TextAttributeModifier);
AllowNull	
    : A L L O W N U L [Ll] -> pushMode(modifier), type(BooleanAttributeModifier);
CellDecorator	
    : C E L L D E C O R A T O [Rr] -> pushMode(modifier), type(TextAttributeModifier);
CollectionDelimiter 	
    : C O L L E C T I O N DASH D E L I M I T E [Rr] -> pushMode(modifier), type(TextAttributeModifier);
Dateformat		
    : D A T E F O R M A [Tt] -> pushMode(modifier), type(DateFormatAttributeModifier);
Default		
    : D E F A U L [Tt] -> pushMode(modifier), type(TextAttributeModifier);
ForceWrite		
    : F O R C E W R I T [Ee] -> pushMode(modifier), type(BooleanAttributeModifier);
IgnoreKeyCase	
    : I G N O R E K E Y C A S [Ee] -> pushMode(modifier), type(BooleanAttributeModifier);
IgnoreNull		
    : I G N O R E N U L [Ll] -> pushMode(modifier), type(BooleanAttributeModifier);
KeyToValueDelimiter	
    : K E Y TWO V A L U E DASH D E L I M I T E [Rr] -> pushMode(modifier), type(TextAttributeModifier);
Lang		
    : L A N [Gg] -> pushMode(modifier), type(TextAttributeModifier);
MapDelimiter	
    : M A P DASH D E L I M I T E [Rr] -> pushMode(modifier), type(TextAttributeModifier);
Mode		
    : M O D [Ee] -> pushMode(modifier), type(TextAttributeModifier);
NumberFormat	
    : N U M B E R F O R M A [Tt] -> pushMode(modifier), type(NumberFormatAttributeModifier);
PathDelimiter	
    : P A T H DASH D E L I M I T E [Rr] -> pushMode(modifier), type(TextAttributeModifier);
Pos		
    : P O [Ss] -> pushMode(modifier), type(IntAttributeModifier);
Translator
    : T R A N S L A T O [Rr] -> pushMode(modifier), type(ClassAttributeModifier);
Unique		
    : U N I Q U [Ee] -> pushMode(modifier), type(BooleanAttributeModifier);
Virtual		
    : V I R T U A [Ll] -> pushMode(modifier), type(BooleanAttributeModifier);

HComma : Comma -> type(Comma);
HSemicolon : Semicolon -> type(Semicolon);
HDot : Dot -> type(Dot);
HDoubleQuote : DoubleQuote -> type(DoubleQuote);
HQuote : Quote -> type(Quote);
HRBracket : RBracket -> type(RBracket);
HLBracket : LBracket -> type(LBracket);
HLParenthesis : LParenthesis -> type(LParenthesis);
HRParenthesis : RParenthesis -> type(RParenthesis);
HEquals : Equals -> type(Equals);
HOr : Or -> type(Or);
HLb : Lb -> type(Lb), popMode;
HSeparator : Separator -> type(Separator), skip;
HIdentifier : Identifier -> type(Identifier);
HSpecialAttribute : SpecialAttribute -> type(SpecialAttribute);
HDocumentID : DocumentID -> type(DocumentID);
HWs : Ws -> type(Ws), skip;

mode modifier;
Modifierquotedval 
    : '=' Ws* ('"'(~[\r\n"] |'"' '"')* '"')
      -> type(Modifierval), popMode;
/*
    {
      String text = getText();  
      text = text.substring(1, text.length()).trim();  //remove leading equals character and trim to remove any spaces
      setText(text.substring(1, text.length() - 1)); //remove surrounding doublequotes 
      setType(Modifierval);
      popMode();
    };
*/
Modifierval 
    : '=' (Separator* ~[\r\n\[\],;"])* 
      -> popMode;

ModifierSeparator 
    : Separator 
      -> type(Separator), skip;
/*
    {
      String text = getText();     
      setText(text.substring(1, text.length()).trim());//remove leading equals character and trim to remove any spaces
      popMode();
    };
*/
ModifierWs 
    : Ws 
      -> type(Ws), skip;