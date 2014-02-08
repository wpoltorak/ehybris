lexer grammar ImpexLexer;

tokens {
    //Mode,
    BooleanAttributeModifier,
    IntAttributeModifier,
    DateFormatAttributeModifier,
    NumberFormatAttributeModifier,
    ClassAttributeModifier,
    TextAttributeModifier,
    BooleanHeaderModifier,
    ClassHeaderModifier,
    TextHeaderModifier
}

fragment A          : [Aa]Separator*;
fragment B          : [Bb]Separator*;
fragment C          : [Cc]Separator*;
fragment D          : [Dd]Separator*;
fragment E          : [Ee]Separator*;
fragment F          : [Ff]Separator*;
fragment G          : [Gg]Separator*;
fragment H          : [Hh]Separator*;
fragment I          : [Ii]Separator*;
fragment J          : [Jj]Separator*;
fragment K          : [Kk]Separator*;
fragment L          : [Ll]Separator*;
fragment M          : [Mm]Separator*;
fragment N          : [Nn]Separator*;
fragment O          : [Oo]Separator*;
fragment P          : [Pp]Separator*;
fragment Q          : [Qq]Separator*;
fragment R          : [Rr]Separator*;
fragment S          : [Ss]Separator*;
fragment T          : [Tt]Separator*;
fragment U          : [Uu]Separator*;
fragment V          : [Vv]Separator*;
fragment W          : [Ww]Separator*;
fragment X          : [Xx]Separator*;
fragment Y          : [Yy]Separator*;
fragment Z          : [Zz]Separator*;
fragment DASH       : [-]Separator*;
fragment UNDERSCORE : [_]Separator*;
fragment TWO        : [2]Separator*;

//Modes
Insert              : I N S E R T -> pushMode(header);//, type(Mode);
InsertUpdate        : I N S E R T UNDERSCORE U P D A T E -> pushMode(header);//, type(Mode);
Update              : U P D A T E -> pushMode(header);//, type(Mode);
Remove              : R E M O V E -> pushMode(header);//, type(Mode);

Comma               : ',';
Dot                 : '.';
DoubleQuote         : '"';
Quote               : '\'';
LParenthesis        : '(';
RParenthesis        : ')';
Equals              : '=';
Or                  : '|';
Separator           : '\\' Ws* Lb -> skip;

fragment 
    FieldSeparator  : Ws* Separator Ws*;

DocumentID          : '&' Separator* Identifier;
SpecialAttribute    : '@' Separator* Identifier;
Identifier          : [a-zA-Z_](Separator* [a-zA-Z0-9_])*;
Macrodef            : '$' Separator* Identifier -> pushMode(macro); 
UserRights          :'$START_USERRIGHTS' .*? '$END_USERRIGHTS' (Semicolon | Ws)* -> skip;

BeanShell           : ('#%' .*? (Lb | EOF) 
                    | '"#%' (~'"'|'"''"')* '"') Ws* (Lb | EOF) -> skip;
Comment             : '#' .*? (Lb | EOF) -> skip;
/*      
      { 
       setText(getText().substring(1, getText().length())); 
       skip();
      };
*/

//QuotedField         : ';' FieldSeparator* '"' (~'"'|'"''"')* '"' -> pushMode(record), type(Field);
/*
      {
        String text = getText();
       	text = text.substring(1, text.length()).trim();  //remove leading semicolon and trim to remove any spaces
	text = text.substring(1, text.length() - 1).trim();      // remove surrounding doublequotes and again trim to remove any spaces
	setText(text);
        setType(Field);
      };
*/

Field               : ';' FieldSeparator* ('"' (~'"'|'"''"')* '"' | (~[\r\n";] Separator*)* /*| Separator* empty field*/) -> pushMode(record);

/*      
      {
        String text = removeSeparators(getText());
        setText(text.substring(1, text.length()).trim()); //remove leading semicolon and trim to remove any spaces
      }Field+;;
*/
Lb                  : ('\r'?'\n'|'\r') -> skip;
Ws                  : [ \t] -> skip;


mode record;

RecordSeparator     : Separator -> type(Separator), skip;
//RecordQuotedField   : QuotedField -> type(Field);

/*
      {
        String text = getText();
       	text = text.substring(1, text.length()).trim();  //remove leading semicolon and trim to remove any spaces
	text = text.substring(1, text.length() - 1).trim();      // remove surrounding doublequotes and again trim to remove any spaces
	setText(text);
        setType(Field);
      };
*/

RecordField         : Field -> type(Field);
RecordLb            : Lb -> type(Lb), popMode;
RecordWs            : Ws -> type(Ws), skip;


mode macro;
MacroEquals             : '=' Ws* MacroSeparator* -> pushMode(macroval)/*, skip;*/, type(Equals);
MacroWs                 : Ws -> type(Ws), skip;
MacroSeparator          : Separator Ws* -> type(Separator), skip;
MacroLb                 : Lb -> type(Lb), popMode, skip;
ErrorMacroval           : ~[= \t]~[\r\n]* -> type(Macroval); //to match in case of errors

mode macroval;
MacrovalWs                 : Ws -> type(Ws), skip;
MacrovalSeparator          : Separator -> type(Separator), skip;
Macroval                   : (~[\r\n] Separator*)* ~[ \t\r\n];
MacrovalLb                 : Lb -> type(Lb), popMode, popMode, skip;

mode header;
HComma              : Comma -> type(Comma);
Semicolon           : ';';
HDot                : Dot -> type(Dot);
HDoubleQuote        : DoubleQuote -> type(DoubleQuote);
HQuote              : Quote -> type(Quote);
LBracket            : '[' -> pushMode(modifier), skip;
HLParenthesis       : LParenthesis -> type(LParenthesis);
HRParenthesis       : RParenthesis -> type(RParenthesis);
HEquals             : Equals -> type(Equals);
HOr                 : Or -> type(Or);
HLb                 : Lb -> type(Lb), popMode;
HSeparator          : Separator -> type(Separator), skip;
HIdentifier         : Identifier -> type(Identifier);
HSpecialAttribute   : SpecialAttribute -> type(SpecialAttribute);
HDocumentID         : DocumentID -> type(DocumentID);
HWs                 : Ws -> type(Ws), skip;


mode modifier;
//Type modifiers
BatchMode           : B A T C H M O D E -> type(BooleanHeaderModifier);
CacheUnique         : C A C H E U N I Q U E -> type(BooleanHeaderModifier);
Processor           : P R O C E S S O R -> type(ClassHeaderModifier);
//Argument modifiers
Alias               : A L I A S -> type(TextAttributeModifier);
AllowNull           : A L L O W N U L L -> type(BooleanAttributeModifier);
CellDecorator       : C E L L D E C O R A T O R -> type(ClassAttributeModifier);
CollectionDelimiter : C O L L E C T I O N DASH D E L I M I T E R -> type(TextAttributeModifier);
Dateformat          : D A T E F O R M A T -> type(DateFormatAttributeModifier);
Default             : D E F A U L T -> type(TextAttributeModifier);
ForceWrite          : F O R C E W R I T E -> type(BooleanAttributeModifier);
IgnoreKeyCase       : I G N O R E K E Y C A S E -> type(BooleanAttributeModifier);
IgnoreNull          : I G N O R E N U L L -> type(BooleanAttributeModifier);
KeyToValueDelimiter : K E Y TWO V A L U E DASH D E L I M I T E R -> type(TextAttributeModifier);
Lang                : L A N G -> type(TextAttributeModifier);
MapDelimiter        : M A P DASH D E L I M I T E R -> type(TextAttributeModifier);
Mode                : M O D E -> type(TextAttributeModifier);
NumberFormat        : N U M B E R F O R M A T -> type(NumberFormatAttributeModifier);
PathDelimiter       : P A T H DASH D E L I M I T E R -> type(TextAttributeModifier);
Pos                 : P O S -> type(IntAttributeModifier);
Translator          : T R A N S L A T O R -> type(ClassAttributeModifier);
Unique              : U N I Q U E -> type(BooleanAttributeModifier);
Virtual             : V I R T U A L -> type(BooleanAttributeModifier);

//ModifierRBracket    : ']' -> popMode, skip;
ModifierEquals      : '=' Ws* ModifierSeparator* -> pushMode(modifierval)/*, skip;*/, type(Equals);
ModifierSeparator   : Separator Ws* -> type(Separator), skip;
ModifierWs          : Ws -> type(Ws), skip;
ErrorModifierval    : ~[= \t]~[,\r\n\]] -> type(Modifierval);
//ModifierComma       : Ws* Comma Ws* (Separator Ws*)* -> type(Comma), skip;

mode modifierval;
RBracket : Ws* ModifiervalSeparator* ']' Ws* ModifiervalSeparator*-> popMode, popMode, skip;
ModifiervalComma    : Ws* ModifiervalSeparator* Comma Ws* ModifiervalSeparator* -> popMode, type(Comma), skip;
ModifiervalSeparator: Separator Ws* -> type(Separator), skip;
ModifiervalQuoted   : '"'(~[\r\n"] |'"' '"')* '"' -> type(Modifierval);
/*
    {
      String text = getText();  
      text = text.substring(1, text.length()).trim();  //remove leading equals character and trim to remove any spaces
      setText(text.substring(1, text.length() - 1)); //remove surrounding doublequotes 
      setType(Modifierval);
      popMode();
    };
*/
Modifierval         : (~[\r\n\[\],;"] Separator*)* ~[ \t\r\n\[\],;"];

/*
    {
      String text = getText();     
      setText(text.substring(1, text.length()).trim());//remove leading equals character and trim to remove any spaces
      popMode();
    };
*/
/*
/work/projects/yeclipse/ImpexAST/src/main/java/com/lambda/impex/ast
*/
