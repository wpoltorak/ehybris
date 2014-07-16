lexer grammar ImpexLexer;

tokens {
    Mode,
    Separator,
    Macroref,
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

@members{
    int lastTokenType = 0;
         
    public void emit(Token token) {
        super.emit(token);
        lastTokenType = token.getType();
    }
}

fragment A          : [Aa]LineSeparator*;
fragment B          : [Bb]LineSeparator*;
fragment C          : [Cc]LineSeparator*;
fragment D          : [Dd]LineSeparator*;
fragment E          : [Ee]LineSeparator*;
fragment F          : [Ff]LineSeparator*;
fragment G          : [Gg]LineSeparator*;
fragment H          : [Hh]LineSeparator*;
fragment I          : [Ii]LineSeparator*;
fragment J          : [Jj]LineSeparator*;
fragment K          : [Kk]LineSeparator*;
fragment L          : [Ll]LineSeparator*;
fragment M          : [Mm]LineSeparator*;
fragment N          : [Nn]LineSeparator*;
fragment O          : [Oo]LineSeparator*;
fragment P          : [Pp]LineSeparator*;
fragment Q          : [Qq]LineSeparator*;
fragment R          : [Rr]LineSeparator*;
fragment S          : [Ss]LineSeparator*;
fragment T          : [Tt]LineSeparator*;
fragment U          : [Uu]LineSeparator*;
fragment V          : [Vv]LineSeparator*;
fragment W          : [Ww]LineSeparator*;
fragment X          : [Xx]LineSeparator*;
fragment Y          : [Yy]LineSeparator*;
fragment Z          : [Zz]LineSeparator*;
fragment DASH       : [-]LineSeparator*;
fragment UNDERSCORE : [_]LineSeparator*;
fragment TWO        : [2]LineSeparator*;

//Modes
Insert              : I N S E R T -> pushMode(header), type(Mode);
InsertUpdate        : I N S E R T UNDERSCORE U P D A T E -> pushMode(header), type(Mode);
Update              : U P D A T E -> pushMode(header), type(Mode);
Remove              : R E M O V E -> pushMode(header), type(Mode);

Comma               : ',';
Dot                 : '.';
DoubleQuote         : '"';
Quote               : '\'';
LParenthesis        : '(';
RParenthesis        : ')';
Equals              : '=';
Or                  : '|';
LineSeparator       : '\\' Ws* Lb -> channel(HIDDEN);

fragment 
    NonLineSeparator: ('\\' Ws* LineSeparator*) Ws* ~[\r\n];

Separator           : ';';

DocumentID          : '&' LineSeparator* Identifier;
SpecialAttribute    : '@' LineSeparator* Identifier;
Identifier          : [a-zA-Z_](LineSeparator* [a-zA-Z0-9_])*;
Macrodef            : '$' LineSeparator* Identifier -> pushMode(macro); 
fragment
    NonMacrodef     : '$' LineSeparator* ~[a-zA-Z_];

UserRights          :'$START_USERRIGHTS' .*? '$END_USERRIGHTS' (Separator | Ws)*;

BeanShell           : '#%' ~[\r\n]* 
                    | '"#%' (~'"'|'"''"')* '"';
Comment             : '#' ~[\r\n]*;

Lb                  : ('\r'?'\n'|'\r') -> channel(HIDDEN);
Ws                  : [ \t] -> channel(HIDDEN);
Error               : .;

mode record;
RecordComment             : Comment -> type(Comment);
RecordInsert              : Insert -> popMode, pushMode(header), type(Mode);
RecordInsertUpdate        : InsertUpdate -> popMode, pushMode(header), type(Mode);
RecordUpdate              : Update -> popMode, pushMode(header), type(Mode);
RecordRemove              : Remove -> popMode, pushMode(header), type(Mode);
RecordIdentifier          : Identifier -> type(Identifier);
RecordBeanShell           : BeanShell -> type(BeanShell);
RecordUserRights          : UserRights -> type(UserRights);
RecordSeparator           : Ws* Separator Ws* -> type(Separator), pushMode(field);
RecordMacrodef            : Macrodef -> type(Macrodef), pushMode(macro); 
RecordLineSeparator       : LineSeparator -> type(LineSeparator), channel(HIDDEN);
RecordLb                  : Lb -> type(Lb), channel(HIDDEN);
RecordWs                  : Ws -> type(Ws), channel(HIDDEN);

mode field;
FieldLineSeparator      : LineSeparator -> type(LineSeparator), channel(HIDDEN);
FieldSeparator          : Ws* Separator Ws* -> type(Separator);
FieldQuoted             : '"' (~'"'|'"''"')* '"';
FieldMacroref           : Macrodef -> type(Macroref);
Field                   :  ~[\r\n";];
FieldLb                 : Lb -> type(Lb), popMode;
//FieldEOF                : Ws* EOF -> type(EOF), popMode;
//todo field z bialymi znakami tuz przed eof -> handling jak u modifierval?

mode macro;
MacroEquals             : '=' -> pushMode(macroval), type(Equals);
MacroWs                 : Ws -> type(Ws), channel(HIDDEN);
MacroSeparator          : LineSeparator -> type(LineSeparator), channel(HIDDEN);
//MacroLb                 : Ws* Lb -> type(Lb), popMode, channel(HIDDEN);
ErrorMacroval           : ~[= \t]~[\r\n]* -> type(Macroval); //to match in case of errors


mode macroval;
MacrovalWs                 : Ws+ {lastTokenType == Equals}? -> type(Ws), channel(HIDDEN);
MacrovalSeparator          : LineSeparator -> type(LineSeparator), channel(HIDDEN);
MacrovalMacroref           : Macrodef -> type(Macroref);
MacrovalLb                 : Ws* Lb -> type(Lb), popMode, popMode, channel(HIDDEN);
MacrovalEOF                : Ws* EOF -> type(EOF), popMode, popMode;
Macroval                   : ~[\r\n];


mode header;
HComma              : Comma -> type(Comma);
HSeparator          : Separator -> type(Separator);
HDot                : Dot -> type(Dot);
HDoubleQuote        : DoubleQuote -> type(DoubleQuote);
HQuote              : Quote -> type(Quote);
LBracket            : '[' -> pushMode(modifier), channel(HIDDEN);
HLParenthesis       : LParenthesis -> type(LParenthesis);
HRParenthesis       : RParenthesis -> type(RParenthesis);
HEquals             : Equals -> type(Equals);
HOr                 : Or -> type(Or);
HLb                 : Lb -> type(Lb), popMode, pushMode(record);
HLineSeparator      : LineSeparator -> type(LineSeparator), channel(HIDDEN);
HIdentifier         : Identifier -> type(Identifier);
HSpecialAttribute   : SpecialAttribute -> type(SpecialAttribute);
HDocumentID         : DocumentID -> type(DocumentID);
HMacroref           : Macrodef -> type(Macroref);
HWs                 : Ws -> type(Ws), channel(HIDDEN);


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

//ModifierRBracket    : ']' -> popMode, channel(HIDDEN);
ModifierEquals          : '=' -> pushMode(modifierval), type(Equals);
ModifierLineSeparator   : LineSeparator -> type(LineSeparator), channel(HIDDEN);
ModifierWs              : Ws -> type(Ws), channel(HIDDEN);

//ErrorModifierval    : ~[= \t]~[,\r\n\]] -> type(Modifierval);
//ModifierComma       : Ws* Comma Ws* (LineSeparator Ws*)* -> type(Comma), channel(HIDDEN);

mode modifierval;
ModifiervalWs           : Ws+ {lastTokenType == Equals}? -> type(Ws), channel(HIDDEN);
ModifiervalBracket      : Ws* ']' Ws* -> popMode, popMode, channel(HIDDEN);
ModifiervalSingleComma  : Ws* Comma {lastTokenType == Equals && (_input.LA(1) == ',' || _input.LA(1) == ']' )}? -> type(Modifierval);
ModifiervalComma        : Ws* Comma -> type(Comma), popMode, channel(HIDDEN);
ModifiervalMacroref     : Macrodef -> type(Macroref);
ModifiervalSeparator    : LineSeparator -> type(LineSeparator), channel(HIDDEN);
ModifiervalQuoted       : '"'(~[\r\n"] |'"' '"')* '"' -> type(Modifierval);
Modifierval             : ~[\r\n\[\],;"];

/*
/work/projects/yeclipse/ImpexAST/src/main/java/com/lambda/impex/ast
*/
