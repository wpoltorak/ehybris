// Generated from /work/projects/yeclipse/ImpexAST/src/main/antlr4/ImpexLexer.g4 by ANTLR 4.1

 package com.lambda.impex.ast;

import java.util.regex.Pattern;
import java.util.regex.Matcher;


import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ImpexLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ATTRIBUTES=1, ATTRIBUTE=2, ATTRIBUTE_NAME=3, HEADER=4, IMPEX=5, BLOCK=6, 
		BLOCKS=7, MODIFIERS=8, MODIFIER=9, RECORD=10, RECORDS=11, TYPE=12, SUBTYPE=13, 
		FIELDS=14, MACRO_REF=15, ITEM_EXPRESSION=16, Insert=17, InsertUpdate=18, 
		Update=19, Remove=20, BatchMode=21, CacheUnique=22, Processor=23, Alias=24, 
		AllowNull=25, CellDecorator=26, CollectionDelimiter=27, Dateformat=28, 
		Default=29, ForceWrite=30, IgnoreKeyCase=31, IgnoreNull=32, KeyToValueDelimiter=33, 
		Lang=34, MapDelimiter=35, Mode=36, NumberFormat=37, PathDelimiter=38, 
		Pos=39, Translator=40, Unique=41, Virtual=42, Comma=43, Dot=44, DoubleQuote=45, 
		Quote=46, Semicolon=47, RBracket=48, LBracket=49, LParenthesis=50, RParenthesis=51, 
		Equals=52, Or=53, Separator=54, SpecialAttribute=55, Macrodef=56, Macroval=57, 
		Modifierquotedval=58, Modifierval=59, DocumentID=60, Identifier=61, Comment=62, 
		QuotedField=63, Field=64, IgnoredLb=65, Lb=66, Ws=67;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"ATTRIBUTES", "ATTRIBUTE", "ATTRIBUTE_NAME", "HEADER", "IMPEX", "BLOCK", 
		"BLOCKS", "MODIFIERS", "MODIFIER", "RECORD", "RECORDS", "TYPE", "SUBTYPE", 
		"FIELDS", "MACRO_REF", "ITEM_EXPRESSION", "Insert", "InsertUpdate", "Update", 
		"Remove", "BatchMode", "CacheUnique", "Processor", "Alias", "AllowNull", 
		"CellDecorator", "CollectionDelimiter", "Dateformat", "Default", "ForceWrite", 
		"IgnoreKeyCase", "IgnoreNull", "KeyToValueDelimiter", "Lang", "MapDelimiter", 
		"Mode", "NumberFormat", "PathDelimiter", "Pos", "Translator", "Unique", 
		"Virtual", "','", "'.'", "'\"'", "'''", "';'", "']'", "'['", "'('", "')'", 
		"'='", "'|'", "Separator", "SpecialAttribute", "Macrodef", "Macroval", 
		"Modifierquotedval", "Modifierval", "DocumentID", "Identifier", "Comment", 
		"QuotedField", "Field", "IgnoredLb", "Lb", "Ws"
	};
	public static final String[] ruleNames = {
		"Insert", "InsertUpdate", "Update", "Remove", "BatchMode", "CacheUnique", 
		"Processor", "Alias", "AllowNull", "CellDecorator", "CollectionDelimiter", 
		"Dateformat", "Default", "ForceWrite", "IgnoreKeyCase", "IgnoreNull", 
		"KeyToValueDelimiter", "Lang", "MapDelimiter", "Mode", "NumberFormat", 
		"PathDelimiter", "Pos", "Translator", "Unique", "Virtual", "Comma", "Dot", 
		"DoubleQuote", "Quote", "Semicolon", "RBracket", "LBracket", "LParenthesis", 
		"RParenthesis", "Equals", "Or", "Separator", "SpecialAttribute", "Macrodef", 
		"Macroval", "Modifierquotedval", "Modifierval", "DocumentID", "Identifier", 
		"Comment", "QuotedField", "Field", "IgnoredLb", "Lb", "Ws"
	};



	private Token lastToken;
	private boolean isHeader = false;
	private com.lambda.impex.ast.ImpexContext context;
	private final Pattern lineSeparatorPattern = Pattern.compile("([ \t]*)\\\\([ \t]*)(\r?\n|\r)([ \t]*)");


	public ImpexLexer(com.lambda.impex.ast.ImpexContext context, CharStream input) {
	    this(input);
	    this.context = context;
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
	 
	private boolean isHeader(){
	    return isHeader;
	}

	private boolean isMacroAssignment() {
	    return lastToken != null && lastToken.getType() == Macrodef;
	}

	private boolean isModifierAssignment() {
	    if (lastToken == null){
	       return false;
	    }
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



	public ImpexLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ImpexLexer.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 37: Separator_action((RuleContext)_localctx, actionIndex); break;

		case 40: Macroval_action((RuleContext)_localctx, actionIndex); break;

		case 41: Modifierquotedval_action((RuleContext)_localctx, actionIndex); break;

		case 42: Modifierval_action((RuleContext)_localctx, actionIndex); break;

		case 45: Comment_action((RuleContext)_localctx, actionIndex); break;

		case 46: QuotedField_action((RuleContext)_localctx, actionIndex); break;

		case 47: Field_action((RuleContext)_localctx, actionIndex); break;

		case 48: IgnoredLb_action((RuleContext)_localctx, actionIndex); break;

		case 50: Ws_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void IgnoredLb_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 7: skip();  break;
		}
	}
	private void Modifierval_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2: 
		      String text = getText();     
		      setText(text.substring(1, text.length()).trim());//remove leading equals character and trim to remove any spaces
		      setType(Modifierval);
		     break;
		}
	}
	private void Field_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5: 
		        String text = removeSeparators(getText());
		        setText(text.substring(1, text.length()).trim()); //remove leading semicolon and trim to remove any spaces
		        setType(Field);
		       break;
		}
	}
	private void Ws_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 8: skip();  break;
		}
	}
	private void Macroval_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: 
		     
		      String text = removeSeparators(getText()); //remove possible separators from the middle of text
		      setText(text.substring(1, text.length()).trim()); //remove leading equals character and trim to remove any spaces
		     break;
		}
	}
	private void Comment_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:  
		       setText(getText().substring(1, getText().length())); 
		       skip();
		       break;
		}
	}
	private void Modifierquotedval_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1: 
		      String text = getText();  
		      text = text.substring(1, text.length()).trim();  //remove leading equals character and trim to remove any spaces
		      setText(text.substring(1, text.length() - 1)); //remove surrounding doublequotes 
		      setType(Modifierval);
		     break;
		}
	}
	private void QuotedField_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4: 
		        String text = getText();
		       	text = text.substring(1, text.length()).trim();  //remove leading semicolon and trim to remove any spaces
			text = text.substring(1, text.length() - 1).trim();      // remove surrounding doublequotes and again trim to remove any spaces
			setText(text);
		        setType(Field);
		       break;
		}
	}
	private void Separator_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6: skip();  break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 35: return Equals_sempred((RuleContext)_localctx, predIndex);

		case 40: return Macroval_sempred((RuleContext)_localctx, predIndex);

		case 41: return Modifierquotedval_sempred((RuleContext)_localctx, predIndex);

		case 42: return Modifierval_sempred((RuleContext)_localctx, predIndex);

		case 46: return QuotedField_sempred((RuleContext)_localctx, predIndex);

		case 47: return Field_sempred((RuleContext)_localctx, predIndex);

		case 48: return IgnoredLb_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean IgnoredLb_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6: return isHeader() == false;
		}
		return true;
	}
	private boolean Modifierval_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3: return isModifierAssignment();
		}
		return true;
	}
	private boolean Field_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5: return isHeader() == false;
		}
		return true;
	}
	private boolean Macroval_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return isMacroAssignment();
		}
		return true;
	}
	private boolean Equals_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return isMacroAssignment() == false;
		}
		return true;
	}
	private boolean Modifierquotedval_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return isModifierAssignment();
		}
		return true;
	}
	private boolean QuotedField_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4: return isHeader() == false;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2E\u0219\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3"+
		"#\3$\3$\3%\3%\3%\3&\3&\3\'\3\'\7\'\u0196\n\'\f\'\16\'\u0199\13\'\3\'\3"+
		"\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3*\7*\u01a8\n*\f*\16*\u01ab\13*\3*"+
		"\3*\3*\3+\3+\7+\u01b2\n+\f+\16+\u01b5\13+\3+\3+\3+\3+\7+\u01bb\n+\f+\16"+
		"+\u01be\13+\3+\3+\3+\3+\3,\3,\7,\u01c6\n,\f,\16,\u01c9\13,\3,\3,\3,\3"+
		"-\3-\3-\3.\3.\7.\u01d3\n.\f.\16.\u01d6\13.\3/\3/\7/\u01da\n/\f/\16/\u01dd"+
		"\13/\3/\3/\5/\u01e1\n/\3/\3/\3\60\3\60\7\60\u01e7\n\60\f\60\16\60\u01ea"+
		"\13\60\3\60\3\60\3\60\3\60\7\60\u01f0\n\60\f\60\16\60\u01f3\13\60\3\60"+
		"\3\60\3\60\3\60\3\61\3\61\3\61\7\61\u01fc\n\61\f\61\16\61\u01ff\13\61"+
		"\3\61\3\61\3\61\3\62\5\62\u0205\n\62\3\62\3\62\5\62\u0209\n\62\3\62\3"+
		"\62\3\62\3\62\3\63\5\63\u0210\n\63\3\63\3\63\5\63\u0214\n\63\3\64\3\64"+
		"\3\64\3\64\3\u01db\65\3\23\1\5\24\1\7\25\1\t\26\1\13\27\1\r\30\1\17\31"+
		"\1\21\32\1\23\33\1\25\34\1\27\35\1\31\36\1\33\37\1\35 \1\37!\1!\"\1##"+
		"\1%$\1\'%\1)&\1+\'\1-(\1/)\1\61*\1\63+\1\65,\1\67-\19.\1;/\1=\60\1?\61"+
		"\1A\62\1C\63\1E\64\1G\65\1I\66\1K\67\1M8\bO9\1Q:\1S;\2U<\3W=\4Y>\1[?\1"+
		"]@\5_A\6aB\7cC\teD\1gE\n\3\2$\4\2KKkk\4\2PPpp\4\2UUuu\4\2GGgg\4\2TTtt"+
		"\4\2VVvv\3\2aa\4\2WWww\4\2RRrr\4\2FFff\4\2CCcc\4\2OOoo\4\2QQqq\4\2XXx"+
		"x\4\2DDdd\4\2EEee\4\2JJjj\4\2SSss\4\2NNnn\4\2YYyy\3\2//\4\2HHhh\4\2II"+
		"ii\4\2MMmm\4\2[[{{\3\2\64\64\4\2\f\f\17\17\5\2\f\f\17\17$$\b\2\f\f\17"+
		"\17$$..==]_\5\2C\\aac|\6\2\62;C\\aac|\3\2$$\6\2\f\f\17\17$$==\4\2\13\13"+
		"\"\"\u022b\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2"+
		"\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\3i\3\2\2\2\5p\3\2\2\2"+
		"\7~\3\2\2\2\t\u0085\3\2\2\2\13\u008c\3\2\2\2\r\u0096\3\2\2\2\17\u00a2"+
		"\3\2\2\2\21\u00ac\3\2\2\2\23\u00b2\3\2\2\2\25\u00bc\3\2\2\2\27\u00ca\3"+
		"\2\2\2\31\u00df\3\2\2\2\33\u00ea\3\2\2\2\35\u00f2\3\2\2\2\37\u00fd\3\2"+
		"\2\2!\u010b\3\2\2\2#\u0116\3\2\2\2%\u012a\3\2\2\2\'\u012f\3\2\2\2)\u013d"+
		"\3\2\2\2+\u0142\3\2\2\2-\u014f\3\2\2\2/\u015e\3\2\2\2\61\u0162\3\2\2\2"+
		"\63\u016d\3\2\2\2\65\u0174\3\2\2\2\67\u017c\3\2\2\29\u017e\3\2\2\2;\u0180"+
		"\3\2\2\2=\u0182\3\2\2\2?\u0184\3\2\2\2A\u0186\3\2\2\2C\u0188\3\2\2\2E"+
		"\u018a\3\2\2\2G\u018c\3\2\2\2I\u018e\3\2\2\2K\u0191\3\2\2\2M\u0193\3\2"+
		"\2\2O\u019e\3\2\2\2Q\u01a1\3\2\2\2S\u01a4\3\2\2\2U\u01af\3\2\2\2W\u01c3"+
		"\3\2\2\2Y\u01cd\3\2\2\2[\u01d0\3\2\2\2]\u01d7\3\2\2\2_\u01e4\3\2\2\2a"+
		"\u01f8\3\2\2\2c\u0208\3\2\2\2e\u0213\3\2\2\2g\u0215\3\2\2\2ij\t\2\2\2"+
		"jk\t\3\2\2kl\t\4\2\2lm\t\5\2\2mn\t\6\2\2no\t\7\2\2o\4\3\2\2\2pq\t\2\2"+
		"\2qr\t\3\2\2rs\t\4\2\2st\t\5\2\2tu\t\6\2\2uv\t\7\2\2vw\t\b\2\2wx\t\t\2"+
		"\2xy\t\n\2\2yz\t\13\2\2z{\t\f\2\2{|\t\7\2\2|}\t\5\2\2}\6\3\2\2\2~\177"+
		"\t\t\2\2\177\u0080\t\n\2\2\u0080\u0081\t\13\2\2\u0081\u0082\t\f\2\2\u0082"+
		"\u0083\t\7\2\2\u0083\u0084\t\5\2\2\u0084\b\3\2\2\2\u0085\u0086\t\6\2\2"+
		"\u0086\u0087\t\5\2\2\u0087\u0088\t\r\2\2\u0088\u0089\t\16\2\2\u0089\u008a"+
		"\t\17\2\2\u008a\u008b\t\5\2\2\u008b\n\3\2\2\2\u008c\u008d\t\20\2\2\u008d"+
		"\u008e\t\f\2\2\u008e\u008f\t\7\2\2\u008f\u0090\t\21\2\2\u0090\u0091\t"+
		"\22\2\2\u0091\u0092\t\r\2\2\u0092\u0093\t\16\2\2\u0093\u0094\t\13\2\2"+
		"\u0094\u0095\t\5\2\2\u0095\f\3\2\2\2\u0096\u0097\t\21\2\2\u0097\u0098"+
		"\t\f\2\2\u0098\u0099\t\21\2\2\u0099\u009a\t\22\2\2\u009a\u009b\t\5\2\2"+
		"\u009b\u009c\t\t\2\2\u009c\u009d\t\3\2\2\u009d\u009e\t\2\2\2\u009e\u009f"+
		"\t\23\2\2\u009f\u00a0\t\t\2\2\u00a0\u00a1\t\5\2\2\u00a1\16\3\2\2\2\u00a2"+
		"\u00a3\t\n\2\2\u00a3\u00a4\t\6\2\2\u00a4\u00a5\t\16\2\2\u00a5\u00a6\t"+
		"\21\2\2\u00a6\u00a7\t\5\2\2\u00a7\u00a8\t\4\2\2\u00a8\u00a9\t\4\2\2\u00a9"+
		"\u00aa\t\16\2\2\u00aa\u00ab\t\6\2\2\u00ab\20\3\2\2\2\u00ac\u00ad\t\f\2"+
		"\2\u00ad\u00ae\t\24\2\2\u00ae\u00af\t\2\2\2\u00af\u00b0\t\f\2\2\u00b0"+
		"\u00b1\t\4\2\2\u00b1\22\3\2\2\2\u00b2\u00b3\t\f\2\2\u00b3\u00b4\t\24\2"+
		"\2\u00b4\u00b5\t\24\2\2\u00b5\u00b6\t\16\2\2\u00b6\u00b7\t\25\2\2\u00b7"+
		"\u00b8\t\3\2\2\u00b8\u00b9\t\t\2\2\u00b9\u00ba\t\24\2\2\u00ba\u00bb\t"+
		"\24\2\2\u00bb\24\3\2\2\2\u00bc\u00bd\t\21\2\2\u00bd\u00be\t\5\2\2\u00be"+
		"\u00bf\t\24\2\2\u00bf\u00c0\t\24\2\2\u00c0\u00c1\t\13\2\2\u00c1\u00c2"+
		"\t\5\2\2\u00c2\u00c3\t\21\2\2\u00c3\u00c4\t\16\2\2\u00c4\u00c5\t\6\2\2"+
		"\u00c5\u00c6\t\f\2\2\u00c6\u00c7\t\7\2\2\u00c7\u00c8\t\16\2\2\u00c8\u00c9"+
		"\t\6\2\2\u00c9\26\3\2\2\2\u00ca\u00cb\t\21\2\2\u00cb\u00cc\t\16\2\2\u00cc"+
		"\u00cd\t\24\2\2\u00cd\u00ce\t\24\2\2\u00ce\u00cf\t\5\2\2\u00cf\u00d0\t"+
		"\21\2\2\u00d0\u00d1\t\7\2\2\u00d1\u00d2\t\2\2\2\u00d2\u00d3\t\16\2\2\u00d3"+
		"\u00d4\t\3\2\2\u00d4\u00d5\t\26\2\2\u00d5\u00d6\t\13\2\2\u00d6\u00d7\t"+
		"\5\2\2\u00d7\u00d8\t\24\2\2\u00d8\u00d9\t\2\2\2\u00d9\u00da\t\r\2\2\u00da"+
		"\u00db\t\2\2\2\u00db\u00dc\t\7\2\2\u00dc\u00dd\t\5\2\2\u00dd\u00de\t\6"+
		"\2\2\u00de\30\3\2\2\2\u00df\u00e0\t\13\2\2\u00e0\u00e1\t\f\2\2\u00e1\u00e2"+
		"\t\7\2\2\u00e2\u00e3\t\5\2\2\u00e3\u00e4\t\27\2\2\u00e4\u00e5\t\16\2\2"+
		"\u00e5\u00e6\t\6\2\2\u00e6\u00e7\t\r\2\2\u00e7\u00e8\t\f\2\2\u00e8\u00e9"+
		"\t\7\2\2\u00e9\32\3\2\2\2\u00ea\u00eb\t\13\2\2\u00eb\u00ec\t\5\2\2\u00ec"+
		"\u00ed\t\27\2\2\u00ed\u00ee\t\f\2\2\u00ee\u00ef\t\t\2\2\u00ef\u00f0\t"+
		"\24\2\2\u00f0\u00f1\t\7\2\2\u00f1\34\3\2\2\2\u00f2\u00f3\t\27\2\2\u00f3"+
		"\u00f4\t\16\2\2\u00f4\u00f5\t\6\2\2\u00f5\u00f6\t\21\2\2\u00f6\u00f7\t"+
		"\5\2\2\u00f7\u00f8\t\25\2\2\u00f8\u00f9\t\6\2\2\u00f9\u00fa\t\2\2\2\u00fa"+
		"\u00fb\t\7\2\2\u00fb\u00fc\t\5\2\2\u00fc\36\3\2\2\2\u00fd\u00fe\t\2\2"+
		"\2\u00fe\u00ff\t\30\2\2\u00ff\u0100\t\3\2\2\u0100\u0101\t\16\2\2\u0101"+
		"\u0102\t\6\2\2\u0102\u0103\t\5\2\2\u0103\u0104\t\31\2\2\u0104\u0105\t"+
		"\5\2\2\u0105\u0106\t\32\2\2\u0106\u0107\t\21\2\2\u0107\u0108\t\f\2\2\u0108"+
		"\u0109\t\4\2\2\u0109\u010a\t\5\2\2\u010a \3\2\2\2\u010b\u010c\t\2\2\2"+
		"\u010c\u010d\t\30\2\2\u010d\u010e\t\3\2\2\u010e\u010f\t\16\2\2\u010f\u0110"+
		"\t\6\2\2\u0110\u0111\t\5\2\2\u0111\u0112\t\3\2\2\u0112\u0113\t\t\2\2\u0113"+
		"\u0114\t\24\2\2\u0114\u0115\t\24\2\2\u0115\"\3\2\2\2\u0116\u0117\t\31"+
		"\2\2\u0117\u0118\t\5\2\2\u0118\u0119\t\32\2\2\u0119\u011a\t\33\2\2\u011a"+
		"\u011b\t\17\2\2\u011b\u011c\t\f\2\2\u011c\u011d\t\24\2\2\u011d\u011e\t"+
		"\t\2\2\u011e\u011f\t\5\2\2\u011f\u0120\t\26\2\2\u0120\u0121\t\13\2\2\u0121"+
		"\u0122\t\5\2\2\u0122\u0123\t\24\2\2\u0123\u0124\t\2\2\2\u0124\u0125\t"+
		"\r\2\2\u0125\u0126\t\2\2\2\u0126\u0127\t\7\2\2\u0127\u0128\t\5\2\2\u0128"+
		"\u0129\t\6\2\2\u0129$\3\2\2\2\u012a\u012b\t\24\2\2\u012b\u012c\t\f\2\2"+
		"\u012c\u012d\t\3\2\2\u012d\u012e\t\30\2\2\u012e&\3\2\2\2\u012f\u0130\t"+
		"\r\2\2\u0130\u0131\t\f\2\2\u0131\u0132\t\n\2\2\u0132\u0133\t\26\2\2\u0133"+
		"\u0134\t\13\2\2\u0134\u0135\t\5\2\2\u0135\u0136\t\24\2\2\u0136\u0137\t"+
		"\2\2\2\u0137\u0138\t\r\2\2\u0138\u0139\t\2\2\2\u0139\u013a\t\7\2\2\u013a"+
		"\u013b\t\5\2\2\u013b\u013c\t\6\2\2\u013c(\3\2\2\2\u013d\u013e\t\r\2\2"+
		"\u013e\u013f\t\16\2\2\u013f\u0140\t\13\2\2\u0140\u0141\t\5\2\2\u0141*"+
		"\3\2\2\2\u0142\u0143\t\3\2\2\u0143\u0144\t\t\2\2\u0144\u0145\t\r\2\2\u0145"+
		"\u0146\t\20\2\2\u0146\u0147\t\5\2\2\u0147\u0148\t\6\2\2\u0148\u0149\t"+
		"\27\2\2\u0149\u014a\t\16\2\2\u014a\u014b\t\6\2\2\u014b\u014c\t\r\2\2\u014c"+
		"\u014d\t\f\2\2\u014d\u014e\t\7\2\2\u014e,\3\2\2\2\u014f\u0150\t\n\2\2"+
		"\u0150\u0151\t\f\2\2\u0151\u0152\t\7\2\2\u0152\u0153\t\22\2\2\u0153\u0154"+
		"\t\26\2\2\u0154\u0155\t\13\2\2\u0155\u0156\t\5\2\2\u0156\u0157\t\24\2"+
		"\2\u0157\u0158\t\2\2\2\u0158\u0159\t\r\2\2\u0159\u015a\t\2\2\2\u015a\u015b"+
		"\t\7\2\2\u015b\u015c\t\5\2\2\u015c\u015d\t\6\2\2\u015d.\3\2\2\2\u015e"+
		"\u015f\t\n\2\2\u015f\u0160\t\16\2\2\u0160\u0161\t\4\2\2\u0161\60\3\2\2"+
		"\2\u0162\u0163\t\7\2\2\u0163\u0164\t\6\2\2\u0164\u0165\t\f\2\2\u0165\u0166"+
		"\t\3\2\2\u0166\u0167\t\4\2\2\u0167\u0168\t\24\2\2\u0168\u0169\t\f\2\2"+
		"\u0169\u016a\t\7\2\2\u016a\u016b\t\16\2\2\u016b\u016c\t\6\2\2\u016c\62"+
		"\3\2\2\2\u016d\u016e\t\t\2\2\u016e\u016f\t\3\2\2\u016f\u0170\t\2\2\2\u0170"+
		"\u0171\t\23\2\2\u0171\u0172\t\t\2\2\u0172\u0173\t\5\2\2\u0173\64\3\2\2"+
		"\2\u0174\u0175\t\17\2\2\u0175\u0176\t\2\2\2\u0176\u0177\t\6\2\2\u0177"+
		"\u0178\t\7\2\2\u0178\u0179\t\t\2\2\u0179\u017a\t\f\2\2\u017a\u017b\t\24"+
		"\2\2\u017b\66\3\2\2\2\u017c\u017d\7.\2\2\u017d8\3\2\2\2\u017e\u017f\7"+
		"\60\2\2\u017f:\3\2\2\2\u0180\u0181\7$\2\2\u0181<\3\2\2\2\u0182\u0183\7"+
		")\2\2\u0183>\3\2\2\2\u0184\u0185\7=\2\2\u0185@\3\2\2\2\u0186\u0187\7_"+
		"\2\2\u0187B\3\2\2\2\u0188\u0189\7]\2\2\u0189D\3\2\2\2\u018a\u018b\7*\2"+
		"\2\u018bF\3\2\2\2\u018c\u018d\7+\2\2\u018dH\3\2\2\2\u018e\u018f\7?\2\2"+
		"\u018f\u0190\6%\2\2\u0190J\3\2\2\2\u0191\u0192\7~\2\2\u0192L\3\2\2\2\u0193"+
		"\u0197\7^\2\2\u0194\u0196\5g\64\2\u0195\u0194\3\2\2\2\u0196\u0199\3\2"+
		"\2\2\u0197\u0195\3\2\2\2\u0197\u0198\3\2\2\2\u0198\u019a\3\2\2\2\u0199"+
		"\u0197\3\2\2\2\u019a\u019b\5e\63\2\u019b\u019c\3\2\2\2\u019c\u019d\b\'"+
		"\b\2\u019dN\3\2\2\2\u019e\u019f\7B\2\2\u019f\u01a0\5[.\2\u01a0P\3\2\2"+
		"\2\u01a1\u01a2\7&\2\2\u01a2\u01a3\5[.\2\u01a3R\3\2\2\2\u01a4\u01a9\7?"+
		"\2\2\u01a5\u01a8\n\34\2\2\u01a6\u01a8\5M\'\2\u01a7\u01a5\3\2\2\2\u01a7"+
		"\u01a6\3\2\2\2\u01a8\u01ab\3\2\2\2\u01a9\u01a7\3\2\2\2\u01a9\u01aa\3\2"+
		"\2\2\u01aa\u01ac\3\2\2\2\u01ab\u01a9\3\2\2\2\u01ac\u01ad\6*\3\2\u01ad"+
		"\u01ae\b*\2\2\u01aeT\3\2\2\2\u01af\u01b3\7?\2\2\u01b0\u01b2\5g\64\2\u01b1"+
		"\u01b0\3\2\2\2\u01b2\u01b5\3\2\2\2\u01b3\u01b1\3\2\2\2\u01b3\u01b4\3\2"+
		"\2\2\u01b4\u01b6\3\2\2\2\u01b5\u01b3\3\2\2\2\u01b6\u01bc\7$\2\2\u01b7"+
		"\u01bb\n\35\2\2\u01b8\u01b9\7$\2\2\u01b9\u01bb\7$\2\2\u01ba\u01b7\3\2"+
		"\2\2\u01ba\u01b8\3\2\2\2\u01bb\u01be\3\2\2\2\u01bc\u01ba\3\2\2\2\u01bc"+
		"\u01bd\3\2\2\2\u01bd\u01bf\3\2\2\2\u01be\u01bc\3\2\2\2\u01bf\u01c0\7$"+
		"\2\2\u01c0\u01c1\6+\4\2\u01c1\u01c2\b+\3\2\u01c2V\3\2\2\2\u01c3\u01c7"+
		"\7?\2\2\u01c4\u01c6\n\36\2\2\u01c5\u01c4\3\2\2\2\u01c6\u01c9\3\2\2\2\u01c7"+
		"\u01c5\3\2\2\2\u01c7\u01c8\3\2\2\2\u01c8\u01ca\3\2\2\2\u01c9\u01c7\3\2"+
		"\2\2\u01ca\u01cb\6,\5\2\u01cb\u01cc\b,\4\2\u01ccX\3\2\2\2\u01cd\u01ce"+
		"\7(\2\2\u01ce\u01cf\5[.\2\u01cfZ\3\2\2\2\u01d0\u01d4\t\37\2\2\u01d1\u01d3"+
		"\t \2\2\u01d2\u01d1\3\2\2\2\u01d3\u01d6\3\2\2\2\u01d4\u01d2\3\2\2\2\u01d4"+
		"\u01d5\3\2\2\2\u01d5\\\3\2\2\2\u01d6\u01d4\3\2\2\2\u01d7\u01db\7%\2\2"+
		"\u01d8\u01da\13\2\2\2\u01d9\u01d8\3\2\2\2\u01da\u01dd\3\2\2\2\u01db\u01dc"+
		"\3\2\2\2\u01db\u01d9\3\2\2\2\u01dc\u01e0\3\2\2\2\u01dd\u01db\3\2\2\2\u01de"+
		"\u01e1\5e\63\2\u01df\u01e1\7\2\2\3\u01e0\u01de\3\2\2\2\u01e0\u01df\3\2"+
		"\2\2\u01e1\u01e2\3\2\2\2\u01e2\u01e3\b/\5\2\u01e3^\3\2\2\2\u01e4\u01e8"+
		"\7=\2\2\u01e5\u01e7\5g\64\2\u01e6\u01e5\3\2\2\2\u01e7\u01ea\3\2\2\2\u01e8"+
		"\u01e6\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01eb\3\2\2\2\u01ea\u01e8\3\2"+
		"\2\2\u01eb\u01f1\7$\2\2\u01ec\u01f0\n!\2\2\u01ed\u01ee\7$\2\2\u01ee\u01f0"+
		"\7$\2\2\u01ef\u01ec\3\2\2\2\u01ef\u01ed\3\2\2\2\u01f0\u01f3\3\2\2\2\u01f1"+
		"\u01ef\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2\u01f4\3\2\2\2\u01f3\u01f1\3\2"+
		"\2\2\u01f4\u01f5\7$\2\2\u01f5\u01f6\6\60\6\2\u01f6\u01f7\b\60\6\2\u01f7"+
		"`\3\2\2\2\u01f8\u01fd\7=\2\2\u01f9\u01fc\n\"\2\2\u01fa\u01fc\5M\'\2\u01fb"+
		"\u01f9\3\2\2\2\u01fb\u01fa\3\2\2\2\u01fc\u01ff\3\2\2\2\u01fd\u01fb\3\2"+
		"\2\2\u01fd\u01fe\3\2\2\2\u01fe\u0200\3\2\2\2\u01ff\u01fd\3\2\2\2\u0200"+
		"\u0201\6\61\7\2\u0201\u0202\b\61\7\2\u0202b\3\2\2\2\u0203\u0205\7\17\2"+
		"\2\u0204\u0203\3\2\2\2\u0204\u0205\3\2\2\2\u0205\u0206\3\2\2\2\u0206\u0209"+
		"\7\f\2\2\u0207\u0209\7\17\2\2\u0208\u0204\3\2\2\2\u0208\u0207\3\2\2\2"+
		"\u0209\u020a\3\2\2\2\u020a\u020b\6\62\b\2\u020b\u020c\3\2\2\2\u020c\u020d"+
		"\b\62\t\2\u020dd\3\2\2\2\u020e\u0210\7\17\2\2\u020f\u020e\3\2\2\2\u020f"+
		"\u0210\3\2\2\2\u0210\u0211\3\2\2\2\u0211\u0214\7\f\2\2\u0212\u0214\7\17"+
		"\2\2\u0213\u020f\3\2\2\2\u0213\u0212\3\2\2\2\u0214f\3\2\2\2\u0215\u0216"+
		"\t#\2\2\u0216\u0217\3\2\2\2\u0217\u0218\b\64\n\2\u0218h\3\2\2\2\26\2\u0197"+
		"\u01a7\u01a9\u01b3\u01ba\u01bc\u01c7\u01d4\u01db\u01e0\u01e8\u01ef\u01f1"+
		"\u01fb\u01fd\u0204\u0208\u020f\u0213";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}