lexer grammar ImpexLexer;

tokens {
    Mode,
    Type,
    Separator,
    Macroref,
    SkippedField,
    BooleanAttributeModifier,
    IntAttributeModifier,
    DateFormatAttributeModifier,
    NumberFormatAttributeModifier,
    ClassAttributeModifier,
    TextAttributeModifier,
    BooleanHeaderModifier,
    ClassHeaderModifier,
    TextHeaderModifier,
    UnknownModifier
}
@header{
import java.util.*;
}
@members{
	/* last type from non Token.HIDDEN_CHANNEL token */
    private int lastTokenType = 0;
    private boolean insideQuotedAttribute = false;
    private List<Integer> columnTypes = new ArrayList<>();
    private int columnIndex = -1;
    private boolean isDocumentIdReference;
    
    public void emit(Token token) {
    	super.emit(token);
    
    	if ( LexerATNSimulator.debug ) System.out.println(token.getStartIndex() + ":" + token.getStopIndex() + ", " + readChannel(token) + ", " + readType(token) + " '" + token.getText() + "'");
    
	    if (token.getChannel() == Token.HIDDEN_CHANNEL) {
	        return;
	    }
    
	    lastTokenType = token.getType();
	    
	    if (_mode == attribute && lastTokenType == DoubleQuote) {
	        insideQuotedAttribute = !insideQuotedAttribute;
	        if ( LexerATNSimulator.debug ) System.out.println((insideQuotedAttribute ? "BEGIN" : "END") + " inside quoted attribute");
	    }
    }
  
      @Override
    public void mode(final int m) {
        super.mode(m);
        if ( LexerATNSimulator.debug ) System.out.println("Enter mode: " + getModeNames()[m]);
    }
    
    @Override
    public void pushMode(int m) {
        if (m == type) {
        	columnTypes.clear();
        } else if (m == record){
    		columnIndex = -1;
    	} else if (m == field){
    		columnIndex++;
    	} else if (m == attribute) {
    		isDocumentIdReference = false;
    	}
    	super.pushMode(m);
    }

    @Override
    public int popMode() {
        if (_mode == attribute) {
        	if (lastTokenType == Separator){
        		columnTypes.add(0); // empty attribute
        		if ( LexerATNSimulator.debug ) System.out.println("empty attribute");
        	} else if (lastTokenType == DocumentID){
        		columnTypes.add(1); // docid
        		if ( LexerATNSimulator.debug ) System.out.println("docid def attribute");
        	} else if (isDocumentIdReference) {
        		columnTypes.add(2); // docid ref
        		if ( LexerATNSimulator.debug ) System.out.println("docid ref attribute");
        	} else {
        		columnTypes.add(3); // default
        		if ( LexerATNSimulator.debug ) System.out.println("default attribute");
        	}
        }
    	if ( LexerATNSimulator.debug ) System.out.println("attribute pop mode");
        return super.popMode();
    }
    
    private void handleField() {
   		if (columnIndex >= columnTypes.size()) {
   			if ( LexerATNSimulator.debug ) System.out.println("handle field - index too large: " + columnIndex + " >= " + columnTypes.size());
			setType(SkippedField);
			return;
		}
		switch (columnTypes.get(columnIndex)) { 
			case 0: 
				if ( LexerATNSimulator.debug ) System.out.println("handle field - skipped");
				setType(SkippedField); 
				break; 
//			case 1: 
//				if ( LexerATNSimulator.debug ) System.out.println("handle field - docid");
//				setType(DocumentIdField); 
//				break;
//			case 2:
//				if ( LexerATNSimulator.debug ) System.out.println("handle field - docid ref");
//				setType(DocumentIdRefField); 
//				break;
			default: 
				if ( LexerATNSimulator.debug ) System.out.println("handle field - default");
				setType(Field);
		}
    }
    
    private void handleDocumentId() {
    	setType(DocumentID);
    	isDocumentIdReference = lastTokenType == LParenthesis;
    }
    
    private void handleFieldLb() {
    	setType(Lb);
    	popMode();
    	columnIndex = -1;
    }
    
    public static String readType(final Token token) {
        switch (token.getType()) {
            case ImpexLexer.DocumentIdField:
                return "DocumentIdField              ";
            case ImpexLexer.SkippedField:
                return "SkippedField                 ";
            case ImpexLexer.Type:
                return "Type                         ";
            case ImpexLexer.Mode:
                return "Mode                         ";
            case ImpexLexer.Separator:
                return "Separator                    ";
            case ImpexLexer.Macroref:
                return "Macroref                     ";
            case ImpexLexer.BooleanAttributeModifier:
                return "BooleanAttributeModifier     ";
            case ImpexLexer.IntAttributeModifier:
                return "IntAttributeModifier         ";
            case ImpexLexer.DateFormatAttributeModifier:
                return "DateFormatAttributeModifier  ";
            case ImpexLexer.NumberFormatAttributeModifier:
                return "NumberFormatAttributeModifier";
            case ImpexLexer.ClassAttributeModifier:
                return "ClassAttributeModifier       ";
            case ImpexLexer.TextAttributeModifier:
                return "TextAttributeModifier        ";
            case ImpexLexer.BooleanHeaderModifier:
                return "BooleanHeaderModifier        ";
            case ImpexLexer.ClassHeaderModifier:
                return "ClassHeaderModifier          ";
            case ImpexLexer.TextHeaderModifier:
                return "TextHeaderModifier           ";
            case ImpexLexer.Comma:
                return "Comma                        ";
            case ImpexLexer.Dot:
                return "Dot                          ";
            case ImpexLexer.DoubleQuote:
                return "DoubleQuote                  ";
            case ImpexLexer.Quote:
                return "Quote                        ";
            case ImpexLexer.LParenthesis:
                return "LParenthesis                 ";
            case ImpexLexer.RParenthesis:
                return "RParenthesis                 ";
            case ImpexLexer.Equals:
                return "Equals                       ";
            case ImpexLexer.Or:
                return "Or                           ";
            case ImpexLexer.LineSeparator:
                return "LineSeparator                ";
            case ImpexLexer.DocumentID:
                return "DocumentID                   ";
            case ImpexLexer.SpecialAttribute:
                return "SpecialAttribute             ";
            case ImpexLexer.Identifier:
                return "Identifier                   ";
            case ImpexLexer.Macrodef:
                return "Macrodef                     ";
            case ImpexLexer.UserRights:
                return "UserRights                   ";
            case ImpexLexer.BeanShell:
                return "BeanShell                    ";
            case ImpexLexer.Comment:
                return "Comment                      ";
            case ImpexLexer.Lb:
                return "Lb                           ";
            case ImpexLexer.Ws:
                return "Ws                           ";
            case ImpexLexer.Error:
                return "Error                        ";
            case ImpexLexer.FieldQuoted:
                return "FieldQuoted                  ";
            case ImpexLexer.Field:
                return "Field                        ";
            case ImpexLexer.Macroval:
                return "Macroval                     ";
            case ImpexLexer.LBracket:
                return "LBracket                     ";
            case ImpexLexer.ABracket:
                return "ABracket                     ";
            case ImpexLexer.ModifierBracket:
                return "ModifierBracket              ";
            case ImpexLexer.UnknownModifier:
                return "UnknownModifier              ";
            case ImpexLexer.ModifiervalBracket:
                return "ModifiervalBracket           ";
            case ImpexLexer.Modifierval:
                return "Modifierval                  ";

        }
        return "?                            ";
    }
    
    private static String readChannel(final Token token) {
        switch (token.getChannel()) {
            case ImpexLexer.HIDDEN:
                return "HIDDEN ";
            case ImpexLexer.DEFAULT_TOKEN_CHANNEL:
                return "DEFAULT";
            default:
                return "???????";
        }
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
Insert              : I N S E R T -> pushMode(type), type(Mode);
InsertUpdate        : I N S E R T UNDERSCORE U P D A T E -> pushMode(type), type(Mode);
Update              : U P D A T E -> pushMode(type), type(Mode);
Remove              : R E M O V E -> pushMode(type), type(Mode);

Comma               : ',';
Dot                 : '.';
DoubleQuote         : '"';
Quote               : '\'';
LParenthesis        : '(';
RParenthesis        : ')';
Equals              : '=';
Or                  : '|';
LineSeparator       : '\\' Ws* Lb -> channel(HIDDEN);

Separator           : ';';

fragment DocumentIDQualifier : [a-zA-Z0-9_\\-\\.](LineSeparator* [a-zA-Z0-9_\\-\\.])*;
DocumentID          : '&' LineSeparator* Identifier;
SpecialAttribute    : '@' LineSeparator* Identifier;
Identifier          : [a-zA-Z_](LineSeparator* [a-zA-Z0-9_])*;
Macrodef            : '$' LineSeparator* Identifier -> pushMode(macro); 
UserRights          :'$START_USERRIGHTS' .*? '$END_USERRIGHTS' (Separator | Ws)*;
BeanShell           : '#%' ~[\r\n]* 
                    | '"#%' (~'"'|'"''"')* '"';
Comment             : '#' ~[\r\n]*;
Lb                  : ('\r'?'\n'|'\r') -> channel(HIDDEN);
Ws                  : [ \t] -> channel(HIDDEN);
Error               : .;

mode record;
RecordComment             : Comment -> type(Comment);
RecordInsert              : Insert -> popMode, pushMode(type), type(Mode);
RecordInsertUpdate        : InsertUpdate -> popMode, pushMode(type), type(Mode);
RecordUpdate              : Update -> popMode, pushMode(type), type(Mode);
RecordRemove              : Remove -> popMode, pushMode(type), type(Mode);
RecordIdentifier          : Identifier -> type(Type);
RecordBeanShell           : BeanShell -> type(BeanShell);
RecordUserRights          : UserRights -> type(UserRights);
RecordSeparator           : Ws* Separator Ws* -> type(Separator), pushMode(field);
RecordMacrodef            : Macrodef -> type(Macrodef), pushMode(macro); 
RecordLineSeparator       : LineSeparator -> type(LineSeparator), channel(HIDDEN);
RecordLb                  : Lb -> type(Lb), channel(HIDDEN);
RecordWs                  : Ws -> type(Ws), channel(HIDDEN);

mode field;
FieldLineSeparator      : LineSeparator -> type(LineSeparator), channel(HIDDEN);
FieldSeparator          : Ws* Separator Ws* -> type(Separator), popMode, pushMode(field);
FieldQuoted             : '"' (~'"'|'"''"')* '"';
FieldMacroref           : Macrodef -> type(Macroref);
FieldLb                 : Lb {handleFieldLb();};
DocumentIdField         : DocumentIDQualifier {columnIndex < columnTypes.size() && columnTypes.get(columnIndex) == 1}?; 
DocumentIdRefField      : DocumentIDQualifier {columnIndex < columnTypes.size() && columnTypes.get(columnIndex) == 2}?;
FieldCommaSkipped       : Ws* Comma Ws* {columnIndex < columnTypes.size() && columnTypes.get(columnIndex) == 2}? -> channel(HIDDEN);
FieldMulti              : ~[\r\n";\t\\ $&] ~[\r\n";$&]* ~[\r\n";\t\\ $&] {columnIndex < columnTypes.size() && columnTypes.get(columnIndex) < 1}? { handleField();};
Field                   : ~[\r\n";] { handleField();};
//FieldEOF                : Ws* EOF -> type(EOF), popMode;
//todo field z bialymi znakami tuz przed eof -> handling jak u modifierval?

mode macro;
MacroEquals             : '=' -> pushMode(macroval), type(Equals);
MacroWs                 : Ws+ -> type(Ws), channel(HIDDEN);
MacroSeparator          : LineSeparator -> type(LineSeparator), channel(HIDDEN);
//ErrorMacroval           : ~[= \t]~[\r\n]* -> type(Macroval); //to match in case of errors


mode macroval;
MacrovalWs				: Ws+ {lastTokenType == Equals || _input.LA(1) == '\r' || _input.LA(1) == '\n'}? -> type(Ws), channel(HIDDEN);
MacrovalSeparator		: LineSeparator+ -> type(LineSeparator), channel(HIDDEN);
MacrovalMacroref		: Macrodef -> type(Macroref);
MacrovalLb				: Lb -> type(Lb), popMode, popMode, channel(HIDDEN);
MacrovalEOF				: Ws* EOF -> type(EOF), popMode, popMode;
MacrovalMulti			: ~[\r\n\t\\ $] ~[\r\n$]* ~[\r\n\t\\ $] -> type(Macroval);
Macroval				: ~[\r\n];



mode type;
TSeparator          : Separator -> type(Separator), popMode, pushMode(attribute);
TDoubleQuote        : DoubleQuote -> type(DoubleQuote);
TQuote              : Quote -> type(Quote);
LBracket            : '[' -> pushMode(modifier), channel(HIDDEN);
TLb                 : Lb -> type(Lb), popMode, pushMode(record);
TLineSeparator      : LineSeparator -> type(LineSeparator), channel(HIDDEN);
TIdentifier         : Identifier -> type(Type);
TMacroref           : Macrodef -> type(Macroref);
TWs                 : Ws -> type(Ws), channel(HIDDEN);

mode attribute;
AComma              : Comma -> type(Comma);
ASeparator          : Separator -> type(Separator), popMode, pushMode(attribute);
ADot                : Dot -> type(Dot);
ADoubleQuote        : DoubleQuote -> type(DoubleQuote);
AQuote              : Quote -> type(Quote);
ABracket            : '[' -> pushMode(modifier), channel(HIDDEN);
ALParenthesis       : LParenthesis -> type(LParenthesis);
ARParenthesis       : RParenthesis -> type(RParenthesis);
AEquals             : Equals -> type(Equals);
AOr                 : Or -> type(Or);
AHiddenLb           : Lb {insideQuotedAttribute}? -> type(Lb), channel(HIDDEN); //if inside quoted attribute line breaks are not relevant
ALb                 : Lb -> type(Lb), popMode, pushMode(record);
ALineSeparator      : LineSeparator -> type(LineSeparator), channel(HIDDEN);
AIdentifier         : Identifier -> type(Identifier);
ASpecialAttribute   : SpecialAttribute -> type(SpecialAttribute);
ADocumentID         : DocumentID {handleDocumentId();};
AMacroref           : Macrodef -> type(Macroref);
AWs                 : Ws -> type(Ws), channel(HIDDEN);


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

ModifierBracket    : ']' -> popMode, channel(HIDDEN);
ModifierLb				: Lb+ {insideQuotedAttribute}? -> type(Lb), channel(HIDDEN); //if inside quoted attribute line breaks are not relevant
ModifierEquals          : '=' -> pushMode(modifierval), type(Equals);
ModifierComma			: Comma -> type(Comma), channel(HIDDEN);
ModifierLineSeparator   : LineSeparator -> type(LineSeparator), channel(HIDDEN);
ModifierWs              : Ws -> type(Ws), channel(HIDDEN);
ModifierUnknown			: ~[\r\n\[\],;=] -> type(UnknownModifier);

//ErrorModifierval    : ~[= \t]~[,\r\n\]] -> type(Modifierval);
//ModifierComma       : Ws* Comma Ws* (LineSeparator Ws*)* -> type(Comma), channel(HIDDEN);

mode modifierval;
ModifiervalLb				: Lb+ {insideQuotedAttribute && (lastTokenType == Equals || _input.LA(1) == ']' || (_input.LA(1) == ',' && _input.LA(2) != ']'))}? -> type(Lb), channel(HIDDEN); //if inside quoted attribute line breaks are not relevant
ModifiervalWs				: Ws+ {lastTokenType == Equals || _input.LA(1) == ']' || (_input.LA(1) == ',' && _input.LA(2) != ']')}? -> type(Ws), channel(HIDDEN);
//ModifiervalWs				: Ws+ {lastTokenType == Equals || _input.LA(1) == ',' || _input.LA(1) == ']' }? -> type(Ws), channel(HIDDEN);
ModifiervalBracket			: ']' -> popMode, popMode, channel(HIDDEN);
ModifiervalSingleComma		: Comma {_input.LA(1) == ']'}? -> type(Modifierval);
//ModifiervalSingleComma	: Comma {lastTokenType == Equals && (_input.LA(1) == ',' || _input.LA(1) == ']' )}? -> type(Modifierval);
ModifiervalComma			: Comma -> type(Comma), popMode, channel(HIDDEN);
ModifiervalMacroref			: Macrodef -> type(Macroref);
ModifiervalSeparator		: LineSeparator -> type(LineSeparator), channel(HIDDEN);
ModifiervalDQuotes			: {insideQuotedAttribute}? DoubleQuote DoubleQuote -> type(Modifierval);
ModifiervalDQuote			: {!insideQuotedAttribute}? DoubleQuote -> type(Modifierval);
ModifiervalQuoted			: '\''(~[\r\n\'] |'\'' '\'')* '\'' -> type(Modifierval);
ModifiervalMulti			: ~[\r\n\[\],;\'\t\\ $] ~[\r\n\[\],;\'$]* ~[\r\n\[\],;\'\t\\ $] -> type(Modifierval);
Modifierval					: ~[\r\n\[\],;\'];

/*
/work/projects/yeclipse/ImpexAST/src/main/java/com/lambda/impex/ast
*/
