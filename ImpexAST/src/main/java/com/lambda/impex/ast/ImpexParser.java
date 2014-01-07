// Generated from /work/projects/yeclipse/ImpexAST/src/main/antlr4/Impex.g4 by ANTLR 4.1

 package com.lambda.impex.ast;
V

import java.util.ArrayList;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
//import com.lambda.impex.ast.tree.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ImpexParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Insert=1, InsertUpdate=2, Update=3, Remove=4, BatchMode=5, CacheUnique=6, 
		Processor=7, Alias=8, AllowNull=9, CellDecorator=10, CollectionDelimiter=11, 
		Dateformat=12, Default=13, ForceWrite=14, IgnoreKeyCase=15, IgnoreNull=16, 
		KeyToValueDelimiter=17, Lang=18, MapDelimiter=19, Mode=20, NumberFormat=21, 
		PathDelimiter=22, Pos=23, Translator=24, Unique=25, Virtual=26, Comma=27, 
		Dot=28, DoubleQuote=29, Quote=30, Semicolon=31, RBracket=32, LBracket=33, 
		LParenthesis=34, RParenthesis=35, Equals=36, Or=37, Separator=38, SpecialAttribute=39, 
		Macrodef=40, Macroval=41, Modifierquotedval=42, Modifierval=43, DocumentID=44, 
		Identifier=45, Comment=46, QuotedField=47, Field=48, IgnoredLb=49, Lb=50, 
		Ws=51, ATTRIBUTES=52, ATTRIBUTE=53, ATTRIBUTE_NAME=54, HEADER=55, IMPEX=56, 
		BLOCK=57, BLOCKS=58, MODIFIERS=59, MODIFIER=60, RECORD=61, RECORDS=62, 
		TYPE=63, SUBTYPE=64, FIELDS=65, MACRO_REF=66, ITEM_EXPRESSION=67;
	public static final String[] tokenNames = {
		"<INVALID>", "Insert", "InsertUpdate", "Update", "Remove", "BatchMode", 
		"CacheUnique", "Processor", "Alias", "AllowNull", "CellDecorator", "CollectionDelimiter", 
		"Dateformat", "Default", "ForceWrite", "IgnoreKeyCase", "IgnoreNull", 
		"KeyToValueDelimiter", "Lang", "MapDelimiter", "Mode", "NumberFormat", 
		"PathDelimiter", "Pos", "Translator", "Unique", "Virtual", "','", "'.'", 
		"'\"'", "'''", "';'", "']'", "'['", "'('", "')'", "'='", "'|'", "Separator", 
		"SpecialAttribute", "Macrodef", "Macroval", "Modifierquotedval", "Modifierval", 
		"DocumentID", "Identifier", "Comment", "QuotedField", "Field", "IgnoredLb", 
		"Lb", "Ws", "ATTRIBUTES", "ATTRIBUTE", "ATTRIBUTE_NAME", "HEADER", "IMPEX", 
		"BLOCK", "BLOCKS", "MODIFIERS", "MODIFIER", "RECORD", "RECORDS", "TYPE", 
		"SUBTYPE", "FIELDS", "MACRO_REF", "ITEM_EXPRESSION"
	};
	public static final int
		RULE_impex = 0, RULE_macro = 1;
	public static final String[] ruleNames = {
		"impex", "macro"
	};

	@Override
	public String getGrammarFileName() { return "Impex.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }



	private com.lambda.impex.ast.ImpexContext context = new com.lambda.impex.ast.ImpexContext();

	public ImpexParser(final com.lambda.impex.ast.ImpexContext context, final TokenStream input) {
	   this(input);
	   this.context = context;
	}

	public ImpexParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ImpexContext extends ParserRuleContext {
		public List<MacroContext> macro() {
			return getRuleContexts(MacroContext.class);
		}
		public MacroContext macro(int i) {
			return getRuleContext(MacroContext.class,i);
		}
		public ImpexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_impex; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexListener ) ((ImpexListener)listener).enterImpex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexListener ) ((ImpexListener)listener).exitImpex(this);
		}
	}

	public final ImpexContext impex() throws RecognitionException {
		ImpexContext _localctx = new ImpexContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_impex);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(7);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Macrodef) {
				{
				{
				setState(4); macro();
				}
				}
				setState(9);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MacroContext extends ParserRuleContext {
		public TerminalNode Macrodef() { return getToken(ImpexParser.Macrodef, 0); }
		public TerminalNode Equals() { return getToken(ImpexParser.Equals, 0); }
		public TerminalNode Macroval() { return getToken(ImpexParser.Macroval, 0); }
		public MacroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexListener ) ((ImpexListener)listener).enterMacro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexListener ) ((ImpexListener)listener).exitMacro(this);
		}
	}

	public final MacroContext macro() throws RecognitionException {
		MacroContext _localctx = new MacroContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_macro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10); match(Macrodef);
			setState(11); match(Equals);
			setState(12); match(Macroval);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3E\21\4\2\t\2\4\3\t"+
		"\3\3\2\7\2\b\n\2\f\2\16\2\13\13\2\3\3\3\3\3\3\3\3\3\3\2\4\2\4\2\2\17\2"+
		"\t\3\2\2\2\4\f\3\2\2\2\6\b\5\4\3\2\7\6\3\2\2\2\b\13\3\2\2\2\t\7\3\2\2"+
		"\2\t\n\3\2\2\2\n\3\3\2\2\2\13\t\3\2\2\2\f\r\7*\2\2\r\16\7&\2\2\16\17\7"+
		"+\2\2\17\5\3\2\2\2\3\t";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}