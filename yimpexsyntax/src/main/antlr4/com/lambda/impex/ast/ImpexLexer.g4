lexer grammar ImpexLexer;

tokens {
    Mode,
    Type,
    Separator,
    ConfigMacroref,
    Macroref,
    Bracket,
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
import java.util.Map.Entry;
}
@members{
	private static final int FIELD_SKIPPED = 0;
	private static final int FIELD_DEFAULT = 1;
	private static final int FIELD_DOCUMENTID = 2;
	private static final int FIELD_DOCUMENTIDREF = 3;
	
	/* last type from non Token.HIDDEN_CHANNEL token */
    private int lastTokenType = 0;
    private boolean insideQuotedAttribute = false;
    private List<Integer> columnTypes = new ArrayList<>();
    private int columnIndex = -1;
    private int offset;
    private boolean isDocumentIdReference;

	private MacroDefinitions macroDefinitions = new MacroDefinitions();
    private boolean clearCachedDefinitions;
    
    private CommonToken cachedToken = null;
    private final Deque<Token> pendingTokens = new ArrayDeque<>();
    
    public void setup(String text, int offset, int length, int delta) {
    	setInputStream(new ANTLRInputStream(text));
    	setOffset(offset);
    	macroDefinitions.update(offset, length, delta);
    }
    
    private void setOffset(int offset) {
    	this.offset = offset;
    }
    private boolean isCached(Token token) {
    	return cachedToken != null && cachedToken == token;
    }
    
    @Override
    public Token nextToken() {
    	cachedToken = null;
        Token pending = pendingTokens.pollFirst();
        if (pending != null) {
            return pending;
        }
        Token next = null;
        do {
        	next = super.nextToken();
        } while (cachedToken != null && next == cachedToken);
        
        pending = pendingTokens.pollFirst();
        if (pending != null) {
	    	// if cached it will be added in emit()
	    	if (!isCached(next)){
	        	pendingTokens.addLast(next);
	        }
            return pending;
        }

        return next;
    }
	    
    @Override
    public Token emit() {
    	if (cachedToken != null && getType() == cachedToken.getType()) {
    		cachedToken.setText(cachedToken.getText() + getText());
    		cachedToken.setStopIndex(getCharIndex() - 1);
			emit(cachedToken);
	    	return cachedToken;
    	}
    	return super.emit();
    }
	    
	    
    @Override
	public void emit(Token token) {
    	super.emit(token);
    	
    	if ( LexerATNSimulator.debug ) System.out.println(token.getStartIndex() + ":" + token.getStopIndex() + ", " + readChannel(token) + ", " + readType(token) + " '" + token.getText() + "'");

		if (cachedToken != null && cachedToken != token) {
			pendingTokens.addLast(cachedToken);
			cachedToken = null;
			macroDefinitions.nextToken();
		}
	
		switch (token.getType()) {
			case Lb:
				if (clearCachedDefinitions){
					macroDefinitions.clear();
					clearCachedDefinitions = false;
				}
			break;
		}
	
	    if (token.getChannel() == Token.HIDDEN_CHANNEL) {
	        return;
	    }
    
	    lastTokenType = token.getType();
	    
	    switch (token.getType()) {
	    	case Macroval:
	    	case Field:
	    	case Modifierval:
	    		cachedToken = (CommonToken)token;
	    		break;
			case Macroref:{
			//TODO more performance improvement with startswith getter for map view macroDefinitions 
		    	if (macroDefinitions.isReferenced(token)){
		    		//clear cached token to break nextToken loop.
		    		cachedToken = null;
		    	} else {
					cachedToken = (CommonToken)token;
				}
		    	break;
	    	} case Macrodef:{
	    		macroDefinitions.macrodef(token);
	    		clearCachedDefinitions = true; // clear when next line break occurs
	    		break;
	    	} case DoubleQuote:
	    		if (_mode == attribute){
			        insideQuotedAttribute = !insideQuotedAttribute;
			        if ( LexerATNSimulator.debug ) System.out.println((insideQuotedAttribute ? "BEGIN" : "END") + " inside quoted attribute");
	    		}
	    		break;
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
        		columnTypes.add(FIELD_SKIPPED); // empty attribute
        		if ( LexerATNSimulator.debug ) System.out.println("empty attribute");
        	} else if (lastTokenType == DocumentID){
        		columnTypes.add(FIELD_DOCUMENTID); // docid
        		if ( LexerATNSimulator.debug ) System.out.println("docid def attribute");
        	} else if (isDocumentIdReference) {
        		columnTypes.add(FIELD_DOCUMENTIDREF); // docid ref
        		if ( LexerATNSimulator.debug ) System.out.println("docid ref attribute");
        	} else {
        		columnTypes.add(FIELD_DEFAULT); // default
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
			case FIELD_SKIPPED: 
				if ( LexerATNSimulator.debug ) System.out.println("handle field - skipped");
				setType(SkippedField); 
				break; 
			case FIELD_DOCUMENTID: 
				if ( LexerATNSimulator.debug ) System.out.println("handle field - docid");
				setType(DocumentIdField); 
				break;
			case FIELD_DOCUMENTIDREF:
				if ( LexerATNSimulator.debug ) System.out.println("handle field - docid ref");
				setType(DocumentIdRefField); 
				break;
			default: 
				if ( LexerATNSimulator.debug ) System.out.println("handle field - default");
				setType(Field);
		}
    }
    
    private boolean isDocumentIdDefinition() {
    	return columnIndex < columnTypes.size() && columnTypes.get(columnIndex) == FIELD_DOCUMENTID;
    }

    private boolean isDocumentIdReference() {
    	return columnIndex < columnTypes.size() && columnTypes.get(columnIndex) == FIELD_DOCUMENTIDREF;
    }

    private boolean isMacroReference() {
    	return cachedToken != null && cachedToken.getType() == Macroref;
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
            case ImpexLexer.DocumentIdField:               return "DocumentIdField              ";
            case ImpexLexer.SkippedField:                  return "SkippedField                 ";
            case ImpexLexer.Type:                          return "Type                         ";
            case ImpexLexer.Mode:                          return "Mode                         ";
            case ImpexLexer.Separator:                     return "Separator                    ";
            case ImpexLexer.Macroref:                      return "Macroref                     ";
            case ImpexLexer.ConfigMacroref:                return "ConfigMacroref               ";
            case ImpexLexer.BooleanAttributeModifier:      return "BooleanAttributeModifier     ";
            case ImpexLexer.IntAttributeModifier:          return "IntAttributeModifier         ";
            case ImpexLexer.DateFormatAttributeModifier:   return "DateFormatAttributeModifier  ";
            case ImpexLexer.NumberFormatAttributeModifier: return "NumberFormatAttributeModifier";
            case ImpexLexer.ClassAttributeModifier:        return "ClassAttributeModifier       ";
            case ImpexLexer.TextAttributeModifier:         return "TextAttributeModifier        ";
            case ImpexLexer.BooleanHeaderModifier:         return "BooleanHeaderModifier        ";
            case ImpexLexer.ClassHeaderModifier:           return "ClassHeaderModifier          ";
            case ImpexLexer.TextHeaderModifier:            return "TextHeaderModifier           ";
            case ImpexLexer.Comma:                         return "Comma                        ";
            case ImpexLexer.Dot:                           return "Dot                          ";
            case ImpexLexer.DoubleQuote:                   return "DoubleQuote                  ";
            case ImpexLexer.Quote:                         return "Quote                        ";
            case ImpexLexer.LParenthesis:                  return "LParenthesis                 ";
            case ImpexLexer.RParenthesis:                  return "RParenthesis                 ";
            case ImpexLexer.Equals:                        return "Equals                       ";
            case ImpexLexer.Or:                            return "Or                           ";
            case ImpexLexer.LineSeparator:                 return "LineSeparator                ";
            case ImpexLexer.DocumentID:                    return "DocumentID                   ";
            case ImpexLexer.SpecialAttribute:              return "SpecialAttribute             ";
            case ImpexLexer.Identifier:                    return "Identifier                   ";
            case ImpexLexer.Macrodef:                      return "Macrodef                     ";
            case ImpexLexer.UserRights:                    return "UserRights                   ";
            case ImpexLexer.BeanShell:                     return "BeanShell                    ";
            case ImpexLexer.Comment:                       return "Comment                      ";
            case ImpexLexer.Lb:                            return "Lb                           ";
            case ImpexLexer.Ws:                            return "Ws                           ";
            case ImpexLexer.Error:                         return "Error                        ";
            case ImpexLexer.FieldQuoted:                   return "FieldQuoted                  ";
            case ImpexLexer.Field:                         return "Field                        ";
            case ImpexLexer.Macroval:                      return "Macroval                     ";
            case ImpexLexer.Bracket:                       return "Bracket                      ";
            case ImpexLexer.UnknownModifier:               return "UnknownModifier              ";
            case ImpexLexer.Modifierval:                   return "Modifierval                  ";
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

fragment MacrorefPrefix : '$' ~[ \t\r\n];
fragment DocumentIDQualifier : [a-zA-Z0-9_\\-\\.](LineSeparator* [a-zA-Z0-9_\\-\\.])*;
DocumentID          : '&' LineSeparator* Identifier;
SpecialAttribute    : '@' LineSeparator* Identifier;
Identifier          : [a-zA-Z_](LineSeparator* [a-zA-Z0-9_])*;
Macrodef            : '$' (LineSeparator* ~[ \t=])* -> pushMode(macro); 
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
RecordError               : Error -> type(Error);

mode field;
FieldLineSeparator      : LineSeparator -> type(LineSeparator), channel(HIDDEN);
FieldSeparator          : Ws* Separator Ws* -> type(Separator), popMode, pushMode(field);
FieldQuoted             : '"' (~'"'|'"''"')* '"';
FieldConfigMacroref     : '$' C O N F I G (LineSeparator* [a-zA-Z0-9_\\-])+ -> type(ConfigMacroref);
FieldMacrorefPrefix     : MacrorefPrefix -> type(Macroref);
FieldMacroref           : ~[ \t\r\n;$] {isMacroReference()}? -> type(Macroref);
FieldLb                 : Lb {handleFieldLb();};
DocumentIdField         : DocumentIDQualifier {isDocumentIdDefinition()}?; 
DocumentIdRefField      : DocumentIDQualifier {isDocumentIdReference()}?;
FieldCommaSkipped       : Ws* Comma Ws* {isDocumentIdReference()}? -> channel(HIDDEN);
Field                   : ~[\r\n";] { handleField();};
//FieldEOF                : Ws* EOF -> type(EOF), popMode;
//todo field z bialymi znakami tuz przed eof -> handling jak u modifierval?
FieldError              : Error -> type(Error);

mode macro;
MacroEquals             : Ws* '=' Ws* -> pushMode(macroval), type(Equals);
MacroWs                 : Ws+ -> type(Ws), channel(HIDDEN);
MacroSeparator          : LineSeparator -> type(LineSeparator), channel(HIDDEN);
//ErrorMacroval           : ~[= \t]~[\r\n]* -> type(Macroval); //to match in case of errors
MacroError              : Error -> type(Error);

mode macroval;
MacrovalLineSeparator	: LineSeparator+ -> type(LineSeparator), channel(HIDDEN);
MacrovalConfigMacroref  : '$' C O N F I G (LineSeparator* ~[ \t\r\n])+ -> type(ConfigMacroref);
MacrovalMacrorefPrefix	: MacrorefPrefix -> type(Macroref);
MacrovalMacroref        : ~[ \t\r\n$] {isMacroReference()}? -> type(Macroref);
MacrovalLb				: Ws* Lb -> type(Lb), popMode, popMode, channel(HIDDEN);
MacrovalEOF				: Ws* EOF -> type(EOF), popMode, popMode;
Macroval				: ~[\r\n];
MacrovalError           : Error -> type(Error);

mode type;
TSeparator          : Separator -> type(Separator), popMode, pushMode(attribute);
TDoubleQuote        : DoubleQuote -> type(DoubleQuote);
TQuote              : Quote -> type(Quote);
TBracket            : '[' -> type(Bracket), pushMode(modifier), channel(HIDDEN);
TLb                 : Lb -> type(Lb), popMode, pushMode(record);
TLineSeparator      : LineSeparator -> type(LineSeparator), channel(HIDDEN);
TIdentifier         : Identifier {cachedToken == null}? -> type(Type);
TConfigMacroref     : '$' C O N F I G (LineSeparator* [a-zA-Z0-9_\\-])+ -> type(ConfigMacroref);
TMacrorefPrefix     : MacrorefPrefix -> type(Macroref);
TMacroref           : ~[ \t\r\n\[;$] {isMacroReference()}? -> type(Macroref);
TWs                 : Ws -> type(Ws), channel(HIDDEN);
TError              : Error -> type(Error);

mode attribute;
AComma              : Comma -> type(Comma);
ASeparator          : Separator -> type(Separator), popMode, pushMode(attribute);
ADot                : Dot -> type(Dot);
ADoubleQuote        : DoubleQuote -> type(DoubleQuote);
AQuote              : Quote -> type(Quote);
ABracket            : '[' -> type(Bracket), pushMode(modifier), channel(HIDDEN);
ALParenthesis       : LParenthesis -> type(LParenthesis);
ARParenthesis       : RParenthesis -> type(RParenthesis);
AEquals             : Equals -> type(Equals);
AOr                 : Or -> type(Or);
AHiddenLb           : Lb {insideQuotedAttribute}? -> type(Lb), channel(HIDDEN); //if inside quoted attribute line breaks are not relevant
ALb                 : Lb -> type(Lb), popMode, pushMode(record);
ALineSeparator      : LineSeparator -> type(LineSeparator), channel(HIDDEN);
AIdentifier         : Identifier {cachedToken == null}? -> type(Identifier);
ASpecialAttribute   : SpecialAttribute -> type(SpecialAttribute);
ADocumentID         : DocumentID {handleDocumentId();};
AConfigMacroref     : '$' C O N F I G (LineSeparator* [a-zA-Z0-9_\\-])+ -> type(ConfigMacroref);
AMacrorefPrefix     : MacrorefPrefix -> type(Macroref);
AMacroref           : ~[ \t\r\n\[;$] {isMacroReference()}? -> type(Macroref);
AWs                 : Ws -> type(Ws), channel(HIDDEN);
AError              : Error -> type(Error);

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

ModifierBracket         : ']' -> type(Bracket), popMode, channel(HIDDEN);
ModifierLb				: Lb+ {insideQuotedAttribute}? -> type(Lb), channel(HIDDEN); //if inside quoted attribute line breaks are not relevant
ModifierEquals          : '=' -> pushMode(modifierval), type(Equals);
ModifierComma			: Comma -> type(Comma), channel(HIDDEN);
ModifierLineSeparator   : LineSeparator -> type(LineSeparator), channel(HIDDEN);
ModifierWs              : Ws -> type(Ws), channel(HIDDEN);
ModifierUnknown			: ~[\r\n\[\],;=] -> type(UnknownModifier);
//ErrorModifierval    : ~[= \t]~[,\r\n\]] -> type(Modifierval);
//ModifierComma       : Ws* Comma Ws* (LineSeparator Ws*)* -> type(Comma), channel(HIDDEN);
ModifierError           : Error -> type(Error);

mode modifierval;
ModifiervalLb				: Lb+ {insideQuotedAttribute && (lastTokenType == Equals || _input.LA(1) == ']' || (_input.LA(1) == ',' && _input.LA(2) != ']'))}? -> type(Lb), channel(HIDDEN); //if inside quoted attribute line breaks are not relevant
ModifiervalWs				: Ws+ {lastTokenType == Equals || _input.LA(1) == ']' || (_input.LA(1) == ',' && _input.LA(2) != ']')}? -> type(Ws), channel(HIDDEN);
//ModifiervalWs				: Ws+ {lastTokenType == Equals || _input.LA(1) == ',' || _input.LA(1) == ']' }? -> type(Ws), channel(HIDDEN);
ModifiervalBracket			: ']' -> type(Bracket), popMode, popMode, channel(HIDDEN);
ModifiervalSingleComma		: Comma {_input.LA(1) == ']'}? -> type(Modifierval);
//ModifiervalSingleComma	: Comma {lastTokenType == Equals && (_input.LA(1) == ',' || _input.LA(1) == ']' )}? -> type(Modifierval);
ModifiervalComma			: Comma -> type(Comma), popMode, channel(HIDDEN);
ModifiervalConfigMacroref   : '$' C O N F I G (LineSeparator* [a-zA-Z0-9_\\-])+ -> type(ConfigMacroref);
ModifiervalMacrorefPrefix	: MacrorefPrefix -> type(Macroref);
ModifiervalMacroref         : ~[ \t\r\n\],$] {isMacroReference()}? -> type(Macroref);
ModifiervalSeparator		: LineSeparator -> type(LineSeparator), channel(HIDDEN);
ModifiervalDQuotes			: {insideQuotedAttribute}? DoubleQuote DoubleQuote -> type(Modifierval);
ModifiervalDQuote			: {!insideQuotedAttribute}? DoubleQuote -> type(Modifierval);
ModifiervalQuoted			: '\''(~[\r\n\'] |'\'' '\'')* '\'' -> type(Modifierval);
Modifierval					: ~[\r\n\[\],;\'];
ModifiervalError            : Error -> type(Error);

/*
/work/projects/yeclipse/ImpexAST/src/main/java/com/lambda/impex/ast
*/
