// Generated from /work/projects/yeclipse/ImpexAST/src/main/antlr4/ImpexParser.g4 by ANTLR 4.1
package com.lambda.impex.ast;
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
		Field=28, Insert=7, IntAttributeModifier=2, Ws=30, Update=9, BooleanAttributeModifier=1, 
		NumberFormatAttributeModifier=4, RBracket=16, Quote=15, Semicolon=11, 
		Remove=10, LParenthesis=18, CacheUnique=33, Lb=29, Identifier=25, RParenthesis=19, 
		Separator=22, Processor=34, TextAttributeModifier=6, DocumentID=23, BatchMode=32, 
		SpecialAttribute=24, Comment=27, ClassAttributeModifier=5, Macrodef=26, 
		DoubleQuote=14, Dot=13, Modifierval=35, DateFormatAttributeModifier=3, 
		InsertUpdate=8, Macroval=31, LBracket=17, Or=21, Comma=12, Equals=20;
	public static final String[] tokenNames = {
		"<INVALID>", "BooleanAttributeModifier", "IntAttributeModifier", "DateFormatAttributeModifier", 
		"NumberFormatAttributeModifier", "ClassAttributeModifier", "TextAttributeModifier", 
		"Insert", "InsertUpdate", "Update", "Remove", "';'", "','", "'.'", "'\"'", 
		"'''", "']'", "'['", "'('", "')'", "'='", "'|'", "Separator", "DocumentID", 
		"SpecialAttribute", "Identifier", "Macrodef", "Comment", "Field", "Lb", 
		"Ws", "Macroval", "BatchMode", "CacheUnique", "Processor", "Modifierval"
	};
	public static final int
		RULE_impex = 0, RULE_block = 1, RULE_header = 2, RULE_quote = 3, RULE_headerModifierAssignment = 4, 
		RULE_headerModifier = 5, RULE_record = 6, RULE_attribute = 7, RULE_attributeName = 8, 
		RULE_attributeValue = 9, RULE_attributeModifierAssignments = 10, RULE_attributeModifierAssignment = 11, 
		RULE_attributeModifier = 12, RULE_headerMode = 13, RULE_headerTypeName = 14, 
		RULE_macro = 15;
	public static final String[] ruleNames = {
		"impex", "block", "header", "quote", "headerModifierAssignment", "headerModifier", 
		"record", "attribute", "attributeName", "attributeValue", "attributeModifierAssignments", 
		"attributeModifierAssignment", "attributeModifier", "headerMode", "headerTypeName", 
		"macro"
	};

	@Override
	public String getGrammarFileName() { return "ImpexParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public ImpexParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ImpexContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ImpexParser.EOF, 0); }
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<MacroContext> macro() {
			return getRuleContexts(MacroContext.class);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
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
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterImpex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitImpex(this);
		}
	}

	public final ImpexContext impex() throws RecognitionException {
		ImpexContext _localctx = new ImpexContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_impex);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Macrodef) {
				{
				{
				setState(32); macro();
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Insert) | (1L << InsertUpdate) | (1L << Update) | (1L << Remove))) != 0)) {
				{
				{
				setState(38); block();
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(44); match(EOF);
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

	public static class BlockContext extends ParserRuleContext {
		public List<MacroContext> macro() {
			return getRuleContexts(MacroContext.class);
		}
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public List<RecordContext> record() {
			return getRuleContexts(RecordContext.class);
		}
		public RecordContext record(int i) {
			return getRuleContext(RecordContext.class,i);
		}
		public MacroContext macro(int i) {
			return getRuleContext(MacroContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(46); header();
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Identifier) | (1L << Macrodef) | (1L << Field))) != 0)) {
				{
				setState(49);
				switch (_input.LA(1)) {
				case Macrodef:
					{
					setState(47); macro();
					}
					break;
				case Identifier:
				case Field:
					{
					setState(48); record();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(53);
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

	public static class HeaderContext extends ParserRuleContext {
		public HeaderModeContext headerMode() {
			return getRuleContext(HeaderModeContext.class,0);
		}
		public List<TerminalNode> Semicolon() { return getTokens(ImpexParser.Semicolon); }
		public TerminalNode RBracket(int i) {
			return getToken(ImpexParser.RBracket, i);
		}
		public List<TerminalNode> RBracket() { return getTokens(ImpexParser.RBracket); }
		public List<HeaderModifierAssignmentContext> headerModifierAssignment() {
			return getRuleContexts(HeaderModifierAssignmentContext.class);
		}
		public TerminalNode LBracket(int i) {
			return getToken(ImpexParser.LBracket, i);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public HeaderModifierAssignmentContext headerModifierAssignment(int i) {
			return getRuleContext(HeaderModifierAssignmentContext.class,i);
		}
		public HeaderTypeNameContext headerTypeName() {
			return getRuleContext(HeaderTypeNameContext.class,0);
		}
		public TerminalNode Lb() { return getToken(ImpexParser.Lb, 0); }
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public List<TerminalNode> LBracket() { return getTokens(ImpexParser.LBracket); }
		public TerminalNode Comma(int i) {
			return getToken(ImpexParser.Comma, i);
		}
		public TerminalNode Semicolon(int i) {
			return getToken(ImpexParser.Semicolon, i);
		}
		public List<TerminalNode> Comma() { return getTokens(ImpexParser.Comma); }
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitHeader(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_header);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54); headerMode();
			setState(55); headerTypeName();
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBracket) {
				{
				{
				setState(56); match(LBracket);
				setState(57); headerModifierAssignment();
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(58); match(Comma);
					setState(59); headerModifierAssignment();
					}
					}
					setState(64);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(65); match(RBracket);
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Semicolon) {
				{
				{
				setState(72); match(Semicolon);
				setState(73); attribute();
				}
				}
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80);
			_la = _input.LA(1);
			if (_la==Lb) {
				{
				setState(79); match(Lb);
				}
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

	public static class QuoteContext extends ParserRuleContext {
		public TerminalNode Quote() { return getToken(ImpexParser.Quote, 0); }
		public TerminalNode DoubleQuote() { return getToken(ImpexParser.DoubleQuote, 0); }
		public QuoteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quote; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterQuote(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitQuote(this);
		}
	}

	public final QuoteContext quote() throws RecognitionException {
		QuoteContext _localctx = new QuoteContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_quote);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			_la = _input.LA(1);
			if ( !(_la==DoubleQuote || _la==Quote) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class HeaderModifierAssignmentContext extends ParserRuleContext {
		public HeaderModifierContext headerModifier() {
			return getRuleContext(HeaderModifierContext.class,0);
		}
		public TerminalNode Modifierval() { return getToken(ImpexParser.Modifierval, 0); }
		public HeaderModifierAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_headerModifierAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterHeaderModifierAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitHeaderModifierAssignment(this);
		}
	}

	public final HeaderModifierAssignmentContext headerModifierAssignment() throws RecognitionException {
		HeaderModifierAssignmentContext _localctx = new HeaderModifierAssignmentContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_headerModifierAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84); headerModifier();
			setState(85); match(Modifierval);
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

	public static class HeaderModifierContext extends ParserRuleContext {
		public TerminalNode Processor() { return getToken(ImpexParser.Processor, 0); }
		public TerminalNode CacheUnique() { return getToken(ImpexParser.CacheUnique, 0); }
		public TerminalNode BatchMode() { return getToken(ImpexParser.BatchMode, 0); }
		public HeaderModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_headerModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterHeaderModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitHeaderModifier(this);
		}
	}

	public final HeaderModifierContext headerModifier() throws RecognitionException {
		HeaderModifierContext _localctx = new HeaderModifierContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_headerModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BatchMode) | (1L << CacheUnique) | (1L << Processor))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class RecordContext extends ParserRuleContext {
		public TerminalNode Lb() { return getToken(ImpexParser.Lb, 0); }
		public TerminalNode Identifier() { return getToken(ImpexParser.Identifier, 0); }
		public TerminalNode Field(int i) {
			return getToken(ImpexParser.Field, i);
		}
		public List<TerminalNode> Field() { return getTokens(ImpexParser.Field); }
		public RecordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_record; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterRecord(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitRecord(this);
		}
	}

	public final RecordContext record() throws RecognitionException {
		RecordContext _localctx = new RecordContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_record);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(89); match(Identifier);
				}
			}

			setState(93); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(92); match(Field);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(95); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			setState(98);
			_la = _input.LA(1);
			if (_la==Lb) {
				{
				setState(97); match(Lb);
				}
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

	public static class AttributeContext extends ParserRuleContext {
		public List<QuoteContext> quote() {
			return getRuleContexts(QuoteContext.class);
		}
		public AttributeValueContext attributeValue() {
			return getRuleContext(AttributeValueContext.class,0);
		}
		public QuoteContext quote(int i) {
			return getRuleContext(QuoteContext.class,i);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitAttribute(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_attribute);
		try {
			setState(105);
			switch (_input.LA(1)) {
			case EOF:
			case Insert:
			case InsertUpdate:
			case Update:
			case Remove:
			case Semicolon:
			case DocumentID:
			case SpecialAttribute:
			case Identifier:
			case Macrodef:
			case Field:
			case Lb:
				enterOuterAlt(_localctx, 1);
				{
				setState(100); attributeValue();
				}
				break;
			case DoubleQuote:
			case Quote:
				enterOuterAlt(_localctx, 2);
				{
				setState(101); quote();
				setState(102); attributeValue();
				setState(103); quote();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class AttributeNameContext extends ParserRuleContext {
		public AttributeNameContext attributeName() {
			return getRuleContext(AttributeNameContext.class,0);
		}
		public TerminalNode Dot() { return getToken(ImpexParser.Dot, 0); }
		public TerminalNode Identifier() { return getToken(ImpexParser.Identifier, 0); }
		public TerminalNode SpecialAttribute() { return getToken(ImpexParser.SpecialAttribute, 0); }
		public TerminalNode Macrodef() { return getToken(ImpexParser.Macrodef, 0); }
		public AttributeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterAttributeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitAttributeName(this);
		}
	}

	public final AttributeNameContext attributeName() throws RecognitionException {
		AttributeNameContext _localctx = new AttributeNameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_attributeName);
		int _la;
		try {
			setState(114);
			switch (_input.LA(1)) {
			case Macrodef:
				enterOuterAlt(_localctx, 1);
				{
				setState(107); match(Macrodef);
				}
				break;
			case SpecialAttribute:
				enterOuterAlt(_localctx, 2);
				{
				setState(108); match(SpecialAttribute);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(109); match(Identifier);
				setState(112);
				_la = _input.LA(1);
				if (_la==Dot) {
					{
					setState(110); match(Dot);
					setState(111); attributeName();
					}
				}

				}
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class AttributeValueContext extends ParserRuleContext {
		public AttributeModifierAssignmentsContext attributeModifierAssignments(int i) {
			return getRuleContext(AttributeModifierAssignmentsContext.class,i);
		}
		public AttributeValueContext attributeValue(int i) {
			return getRuleContext(AttributeValueContext.class,i);
		}
		public TerminalNode LParenthesis() { return getToken(ImpexParser.LParenthesis, 0); }
		public List<AttributeValueContext> attributeValue() {
			return getRuleContexts(AttributeValueContext.class);
		}
		public AttributeNameContext attributeName() {
			return getRuleContext(AttributeNameContext.class,0);
		}
		public TerminalNode RParenthesis() { return getToken(ImpexParser.RParenthesis, 0); }
		public TerminalNode Comma(int i) {
			return getToken(ImpexParser.Comma, i);
		}
		public TerminalNode DocumentID() { return getToken(ImpexParser.DocumentID, 0); }
		public List<AttributeModifierAssignmentsContext> attributeModifierAssignments() {
			return getRuleContexts(AttributeModifierAssignmentsContext.class);
		}
		public List<TerminalNode> Comma() { return getTokens(ImpexParser.Comma); }
		public AttributeValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterAttributeValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitAttributeValue(this);
		}
	}

	public final AttributeValueContext attributeValue() throws RecognitionException {
		AttributeValueContext _localctx = new AttributeValueContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_attributeValue);
		int _la;
		try {
			setState(140);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				switch (_input.LA(1)) {
				case DocumentID:
					{
					setState(116); match(DocumentID);
					}
					break;
				case SpecialAttribute:
				case Identifier:
				case Macrodef:
					{
					setState(117); attributeName();
					setState(129);
					_la = _input.LA(1);
					if (_la==LParenthesis) {
						{
						setState(118); match(LParenthesis);
						setState(119); attributeValue();
						setState(124);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==Comma) {
							{
							{
							setState(120); match(Comma);
							setState(121); attributeValue();
							}
							}
							setState(126);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(127); match(RParenthesis);
						}
					}

					setState(134);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==LBracket) {
						{
						{
						setState(131); attributeModifierAssignments();
						}
						}
						setState(136);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
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

	public static class AttributeModifierAssignmentsContext extends ParserRuleContext {
		public TerminalNode RBracket() { return getToken(ImpexParser.RBracket, 0); }
		public AttributeModifierAssignmentContext attributeModifierAssignment(int i) {
			return getRuleContext(AttributeModifierAssignmentContext.class,i);
		}
		public List<AttributeModifierAssignmentContext> attributeModifierAssignment() {
			return getRuleContexts(AttributeModifierAssignmentContext.class);
		}
		public TerminalNode LBracket() { return getToken(ImpexParser.LBracket, 0); }
		public TerminalNode Comma(int i) {
			return getToken(ImpexParser.Comma, i);
		}
		public List<TerminalNode> Comma() { return getTokens(ImpexParser.Comma); }
		public AttributeModifierAssignmentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeModifierAssignments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterAttributeModifierAssignments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitAttributeModifierAssignments(this);
		}
	}

	public final AttributeModifierAssignmentsContext attributeModifierAssignments() throws RecognitionException {
		AttributeModifierAssignmentsContext _localctx = new AttributeModifierAssignmentsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_attributeModifierAssignments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142); match(LBracket);
			setState(143); attributeModifierAssignment();
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(144); match(Comma);
				setState(145); attributeModifierAssignment();
				}
				}
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(151); match(RBracket);
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

	public static class AttributeModifierAssignmentContext extends ParserRuleContext {
		public AttributeModifierContext attributeModifier() {
			return getRuleContext(AttributeModifierContext.class,0);
		}
		public TerminalNode Modifierval() { return getToken(ImpexParser.Modifierval, 0); }
		public AttributeModifierAssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeModifierAssignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterAttributeModifierAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitAttributeModifierAssignment(this);
		}
	}

	public final AttributeModifierAssignmentContext attributeModifierAssignment() throws RecognitionException {
		AttributeModifierAssignmentContext _localctx = new AttributeModifierAssignmentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_attributeModifierAssignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153); attributeModifier();
			setState(154); match(Modifierval);
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

	public static class AttributeModifierContext extends ParserRuleContext {
		public TerminalNode TextAttributeModifier() { return getToken(ImpexParser.TextAttributeModifier, 0); }
		public TerminalNode ClassAttributeModifier() { return getToken(ImpexParser.ClassAttributeModifier, 0); }
		public TerminalNode BooleanAttributeModifier() { return getToken(ImpexParser.BooleanAttributeModifier, 0); }
		public TerminalNode DateFormatAttributeModifier() { return getToken(ImpexParser.DateFormatAttributeModifier, 0); }
		public TerminalNode NumberFormatAttributeModifier() { return getToken(ImpexParser.NumberFormatAttributeModifier, 0); }
		public TerminalNode IntAttributeModifier() { return getToken(ImpexParser.IntAttributeModifier, 0); }
		public AttributeModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterAttributeModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitAttributeModifier(this);
		}
	}

	public final AttributeModifierContext attributeModifier() throws RecognitionException {
		AttributeModifierContext _localctx = new AttributeModifierContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_attributeModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BooleanAttributeModifier) | (1L << IntAttributeModifier) | (1L << DateFormatAttributeModifier) | (1L << NumberFormatAttributeModifier) | (1L << ClassAttributeModifier) | (1L << TextAttributeModifier))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class HeaderModeContext extends ParserRuleContext {
		public TerminalNode Remove() { return getToken(ImpexParser.Remove, 0); }
		public TerminalNode InsertUpdate() { return getToken(ImpexParser.InsertUpdate, 0); }
		public TerminalNode Insert() { return getToken(ImpexParser.Insert, 0); }
		public TerminalNode Update() { return getToken(ImpexParser.Update, 0); }
		public HeaderModeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_headerMode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterHeaderMode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitHeaderMode(this);
		}
	}

	public final HeaderModeContext headerMode() throws RecognitionException {
		HeaderModeContext _localctx = new HeaderModeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_headerMode);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Insert) | (1L << InsertUpdate) | (1L << Update) | (1L << Remove))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
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

	public static class HeaderTypeNameContext extends ParserRuleContext {
		public AttributeModifierContext attributeModifier() {
			return getRuleContext(AttributeModifierContext.class,0);
		}
		public HeaderModeContext headerMode() {
			return getRuleContext(HeaderModeContext.class,0);
		}
		public HeaderModifierContext headerModifier() {
			return getRuleContext(HeaderModifierContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(ImpexParser.Identifier, 0); }
		public HeaderTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_headerTypeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterHeaderTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitHeaderTypeName(this);
		}
	}

	public final HeaderTypeNameContext headerTypeName() throws RecognitionException {
		HeaderTypeNameContext _localctx = new HeaderTypeNameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_headerTypeName);
		try {
			setState(164);
			switch (_input.LA(1)) {
			case Insert:
			case InsertUpdate:
			case Update:
			case Remove:
				enterOuterAlt(_localctx, 1);
				{
				setState(160); headerMode();
				}
				break;
			case BooleanAttributeModifier:
			case IntAttributeModifier:
			case DateFormatAttributeModifier:
			case NumberFormatAttributeModifier:
			case ClassAttributeModifier:
			case TextAttributeModifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(161); attributeModifier();
				}
				break;
			case BatchMode:
			case CacheUnique:
			case Processor:
				enterOuterAlt(_localctx, 3);
				{
				setState(162); headerModifier();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 4);
				{
				setState(163); match(Identifier);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		public TerminalNode Macroval() { return getToken(ImpexParser.Macroval, 0); }
		public MacroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterMacro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitMacro(this);
		}
	}

	public final MacroContext macro() throws RecognitionException {
		MacroContext _localctx = new MacroContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_macro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166); match(Macrodef);
			setState(167); match(Macroval);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3%\u00ac\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\7\2$\n"+
		"\2\f\2\16\2\'\13\2\3\2\7\2*\n\2\f\2\16\2-\13\2\3\2\3\2\3\3\3\3\3\3\7\3"+
		"\64\n\3\f\3\16\3\67\13\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4?\n\4\f\4\16\4B\13"+
		"\4\3\4\3\4\7\4F\n\4\f\4\16\4I\13\4\3\4\3\4\7\4M\n\4\f\4\16\4P\13\4\3\4"+
		"\5\4S\n\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\b\5\b]\n\b\3\b\6\b`\n\b\r\b\16"+
		"\ba\3\b\5\be\n\b\3\t\3\t\3\t\3\t\3\t\5\tl\n\t\3\n\3\n\3\n\3\n\3\n\5\n"+
		"s\n\n\5\nu\n\n\3\13\3\13\3\13\3\13\3\13\3\13\7\13}\n\13\f\13\16\13\u0080"+
		"\13\13\3\13\3\13\5\13\u0084\n\13\3\13\7\13\u0087\n\13\f\13\16\13\u008a"+
		"\13\13\5\13\u008c\n\13\3\13\5\13\u008f\n\13\3\f\3\f\3\f\3\f\7\f\u0095"+
		"\n\f\f\f\16\f\u0098\13\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\5\20\u00a7\n\20\3\21\3\21\3\21\3\21\2\22\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \2\6\3\2\20\21\3\2\"$\3\2\3\b\3\2\t\f\u00b3\2"+
		"%\3\2\2\2\4\60\3\2\2\2\68\3\2\2\2\bT\3\2\2\2\nV\3\2\2\2\fY\3\2\2\2\16"+
		"\\\3\2\2\2\20k\3\2\2\2\22t\3\2\2\2\24\u008e\3\2\2\2\26\u0090\3\2\2\2\30"+
		"\u009b\3\2\2\2\32\u009e\3\2\2\2\34\u00a0\3\2\2\2\36\u00a6\3\2\2\2 \u00a8"+
		"\3\2\2\2\"$\5 \21\2#\"\3\2\2\2$\'\3\2\2\2%#\3\2\2\2%&\3\2\2\2&+\3\2\2"+
		"\2\'%\3\2\2\2(*\5\4\3\2)(\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2\2\2,.\3\2"+
		"\2\2-+\3\2\2\2./\7\2\2\3/\3\3\2\2\2\60\65\5\6\4\2\61\64\5 \21\2\62\64"+
		"\5\16\b\2\63\61\3\2\2\2\63\62\3\2\2\2\64\67\3\2\2\2\65\63\3\2\2\2\65\66"+
		"\3\2\2\2\66\5\3\2\2\2\67\65\3\2\2\289\5\34\17\29G\5\36\20\2:;\7\23\2\2"+
		";@\5\n\6\2<=\7\16\2\2=?\5\n\6\2><\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2"+
		"\2AC\3\2\2\2B@\3\2\2\2CD\7\22\2\2DF\3\2\2\2E:\3\2\2\2FI\3\2\2\2GE\3\2"+
		"\2\2GH\3\2\2\2HN\3\2\2\2IG\3\2\2\2JK\7\r\2\2KM\5\20\t\2LJ\3\2\2\2MP\3"+
		"\2\2\2NL\3\2\2\2NO\3\2\2\2OR\3\2\2\2PN\3\2\2\2QS\7\37\2\2RQ\3\2\2\2RS"+
		"\3\2\2\2S\7\3\2\2\2TU\t\2\2\2U\t\3\2\2\2VW\5\f\7\2WX\7%\2\2X\13\3\2\2"+
		"\2YZ\t\3\2\2Z\r\3\2\2\2[]\7\33\2\2\\[\3\2\2\2\\]\3\2\2\2]_\3\2\2\2^`\7"+
		"\36\2\2_^\3\2\2\2`a\3\2\2\2a_\3\2\2\2ab\3\2\2\2bd\3\2\2\2ce\7\37\2\2d"+
		"c\3\2\2\2de\3\2\2\2e\17\3\2\2\2fl\5\24\13\2gh\5\b\5\2hi\5\24\13\2ij\5"+
		"\b\5\2jl\3\2\2\2kf\3\2\2\2kg\3\2\2\2l\21\3\2\2\2mu\7\34\2\2nu\7\32\2\2"+
		"or\7\33\2\2pq\7\17\2\2qs\5\22\n\2rp\3\2\2\2rs\3\2\2\2su\3\2\2\2tm\3\2"+
		"\2\2tn\3\2\2\2to\3\2\2\2u\23\3\2\2\2v\u008c\7\31\2\2w\u0083\5\22\n\2x"+
		"y\7\24\2\2y~\5\24\13\2z{\7\16\2\2{}\5\24\13\2|z\3\2\2\2}\u0080\3\2\2\2"+
		"~|\3\2\2\2~\177\3\2\2\2\177\u0081\3\2\2\2\u0080~\3\2\2\2\u0081\u0082\7"+
		"\25\2\2\u0082\u0084\3\2\2\2\u0083x\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0088"+
		"\3\2\2\2\u0085\u0087\5\26\f\2\u0086\u0085\3\2\2\2\u0087\u008a\3\2\2\2"+
		"\u0088\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088"+
		"\3\2\2\2\u008bv\3\2\2\2\u008bw\3\2\2\2\u008c\u008f\3\2\2\2\u008d\u008f"+
		"\3\2\2\2\u008e\u008b\3\2\2\2\u008e\u008d\3\2\2\2\u008f\25\3\2\2\2\u0090"+
		"\u0091\7\23\2\2\u0091\u0096\5\30\r\2\u0092\u0093\7\16\2\2\u0093\u0095"+
		"\5\30\r\2\u0094\u0092\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2\2\2"+
		"\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009a"+
		"\7\22\2\2\u009a\27\3\2\2\2\u009b\u009c\5\32\16\2\u009c\u009d\7%\2\2\u009d"+
		"\31\3\2\2\2\u009e\u009f\t\4\2\2\u009f\33\3\2\2\2\u00a0\u00a1\t\5\2\2\u00a1"+
		"\35\3\2\2\2\u00a2\u00a7\5\34\17\2\u00a3\u00a7\5\32\16\2\u00a4\u00a7\5"+
		"\f\7\2\u00a5\u00a7\7\33\2\2\u00a6\u00a2\3\2\2\2\u00a6\u00a3\3\2\2\2\u00a6"+
		"\u00a4\3\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\37\3\2\2\2\u00a8\u00a9\7\34\2"+
		"\2\u00a9\u00aa\7!\2\2\u00aa!\3\2\2\2\27%+\63\65@GNR\\adkrt~\u0083\u0088"+
		"\u008b\u008e\u0096\u00a6";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}