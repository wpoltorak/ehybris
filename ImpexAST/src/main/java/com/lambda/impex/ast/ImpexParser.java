// Generated from com/lambda/impex/ast/ImpexParser.g4 by ANTLR 4.3
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
	static { RuntimeMetaData.checkVersion("4.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FieldQuoted=33, Field=34, IntAttributeModifier=5, UserRights=27, UnknownModifier=13, 
		Ws=31, ClassHeaderModifier=11, ModifierBracket=38, BooleanAttributeModifier=4, 
		NumberFormatAttributeModifier=7, Quote=17, LParenthesis=18, Lb=30, Identifier=25, 
		LineSeparator=22, Separator=2, RParenthesis=19, TextAttributeModifier=9, 
		DocumentID=23, ModifiervalBracket=39, BooleanHeaderModifier=10, TextHeaderModifier=12, 
		Macroref=3, SpecialAttribute=24, Comment=29, ClassAttributeModifier=8, 
		Macrodef=26, Mode=1, DoubleQuote=16, Error=32, Dot=15, Modifierval=40, 
		ABracket=37, DateFormatAttributeModifier=6, Macroval=35, LBracket=36, 
		Or=21, BeanShell=28, Comma=14, Equals=20;
	public static final String[] tokenNames = {
		"<INVALID>", "Mode", "';'", "Macroref", "BooleanAttributeModifier", "IntAttributeModifier", 
		"DateFormatAttributeModifier", "NumberFormatAttributeModifier", "ClassAttributeModifier", 
		"TextAttributeModifier", "BooleanHeaderModifier", "ClassHeaderModifier", 
		"TextHeaderModifier", "UnknownModifier", "','", "'.'", "'\"'", "'''", 
		"'('", "')'", "'='", "'|'", "LineSeparator", "DocumentID", "SpecialAttribute", 
		"Identifier", "Macrodef", "UserRights", "BeanShell", "Comment", "Lb", 
		"Ws", "Error", "FieldQuoted", "Field", "Macroval", "LBracket", "ABracket", 
		"']'", "ModifiervalBracket", "Modifierval"
	};
	public static final int
		RULE_impex = 0, RULE_block = 1, RULE_header = 2, RULE_quote = 3, RULE_headerModifierAssignment = 4, 
		RULE_headerModifier = 5, RULE_record = 6, RULE_field = 7, RULE_attribute = 8, 
		RULE_attributeName = 9, RULE_attributeValue = 10, RULE_attributeModifierAssignment = 11, 
		RULE_attributeModifier = 12, RULE_unknownModifier = 13, RULE_modifierValue = 14, 
		RULE_headerTypeName = 15, RULE_macro = 16, RULE_macroValue = 17;
	public static final String[] ruleNames = {
		"impex", "block", "header", "quote", "headerModifierAssignment", "headerModifier", 
		"record", "field", "attribute", "attributeName", "attributeValue", "attributeModifierAssignment", 
		"attributeModifier", "unknownModifier", "modifierValue", "headerTypeName", 
		"macro", "macroValue"
	};

	@Override
	public String getGrammarFileName() { return "ImpexParser.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ImpexParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ImpexContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ImpexParser.EOF, 0); }
		public TerminalNode UserRights(int i) {
			return getToken(ImpexParser.UserRights, i);
		}
		public TerminalNode Comment(int i) {
			return getToken(ImpexParser.Comment, i);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public List<MacroContext> macro() {
			return getRuleContexts(MacroContext.class);
		}
		public TerminalNode BeanShell(int i) {
			return getToken(ImpexParser.BeanShell, i);
		}
		public List<TerminalNode> Comment() { return getTokens(ImpexParser.Comment); }
		public List<TerminalNode> BeanShell() { return getTokens(ImpexParser.BeanShell); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public List<TerminalNode> UserRights() { return getTokens(ImpexParser.UserRights); }
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(40);
					switch (_input.LA(1)) {
					case UserRights:
						{
						setState(36); match(UserRights);
						}
						break;
					case BeanShell:
						{
						setState(37); match(BeanShell);
						}
						break;
					case Comment:
						{
						setState(38); match(Comment);
						}
						break;
					case Macrodef:
						{
						setState(39); macro();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(44);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Mode || _la==UserRights) {
				{
				setState(47);
				switch (_input.LA(1)) {
				case Mode:
					{
					setState(45); block();
					}
					break;
				case UserRights:
					{
					setState(46); match(UserRights);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52); match(EOF);
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
		public TerminalNode Comment(int i) {
			return getToken(ImpexParser.Comment, i);
		}
		public List<MacroContext> macro() {
			return getRuleContexts(MacroContext.class);
		}
		public TerminalNode BeanShell(int i) {
			return getToken(ImpexParser.BeanShell, i);
		}
		public List<TerminalNode> Comment() { return getTokens(ImpexParser.Comment); }
		public List<TerminalNode> BeanShell() { return getTokens(ImpexParser.BeanShell); }
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
			setState(54); header();
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Separator) | (1L << Identifier) | (1L << Macrodef) | (1L << BeanShell) | (1L << Comment))) != 0)) {
				{
				setState(59);
				switch (_input.LA(1)) {
				case BeanShell:
					{
					setState(55); match(BeanShell);
					}
					break;
				case Comment:
					{
					setState(56); match(Comment);
					}
					break;
				case Macrodef:
					{
					setState(57); macro();
					}
					break;
				case Separator:
				case Identifier:
					{
					setState(58); record();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(63);
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
		public List<HeaderModifierAssignmentContext> headerModifierAssignment() {
			return getRuleContexts(HeaderModifierAssignmentContext.class);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public List<TerminalNode> Separator() { return getTokens(ImpexParser.Separator); }
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
		public TerminalNode Separator(int i) {
			return getToken(ImpexParser.Separator, i);
		}
		public TerminalNode Mode() { return getToken(ImpexParser.Mode, 0); }
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
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(64); match(Mode);
			setState(65); headerTypeName();
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BooleanHeaderModifier) | (1L << ClassHeaderModifier) | (1L << TextHeaderModifier))) != 0)) {
				{
				{
				setState(66); headerModifierAssignment();
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(76);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(72); match(Separator);
					setState(73); attribute();
					}
					} 
				}
				setState(78);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		public ModifierValueContext modifierValue() {
			return getRuleContext(ModifierValueContext.class,0);
		}
		public TerminalNode Equals() { return getToken(ImpexParser.Equals, 0); }
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
			setState(85); match(Equals);
			setState(86); modifierValue();
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
		public TerminalNode BooleanHeaderModifier() { return getToken(ImpexParser.BooleanHeaderModifier, 0); }
		public TerminalNode ClassHeaderModifier() { return getToken(ImpexParser.ClassHeaderModifier, 0); }
		public TerminalNode TextHeaderModifier() { return getToken(ImpexParser.TextHeaderModifier, 0); }
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
			setState(88);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BooleanHeaderModifier) | (1L << ClassHeaderModifier) | (1L << TextHeaderModifier))) != 0)) ) {
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
		public List<TerminalNode> Separator() { return getTokens(ImpexParser.Separator); }
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public TerminalNode Lb() { return getToken(ImpexParser.Lb, 0); }
		public TerminalNode Identifier() { return getToken(ImpexParser.Identifier, 0); }
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public TerminalNode Separator(int i) {
			return getToken(ImpexParser.Separator, i);
		}
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
			setState(91);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(90); match(Identifier);
				}
			}

			setState(95); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(93); match(Separator);
					setState(94); field();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(97); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(100);
			_la = _input.LA(1);
			if (_la==Lb) {
				{
				setState(99); match(Lb);
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

	public static class FieldContext extends ParserRuleContext {
		public TerminalNode Macroref(int i) {
			return getToken(ImpexParser.Macroref, i);
		}
		public List<TerminalNode> Macroref() { return getTokens(ImpexParser.Macroref); }
		public List<TerminalNode> FieldQuoted() { return getTokens(ImpexParser.FieldQuoted); }
		public TerminalNode Field(int i) {
			return getToken(ImpexParser.Field, i);
		}
		public List<TerminalNode> Field() { return getTokens(ImpexParser.Field); }
		public TerminalNode FieldQuoted(int i) {
			return getToken(ImpexParser.FieldQuoted, i);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitField(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Macroref) | (1L << FieldQuoted) | (1L << Field))) != 0)) {
				{
				{
				setState(102);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Macroref) | (1L << FieldQuoted) | (1L << Field))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(107);
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
		enterRule(_localctx, 16, RULE_attribute);
		try {
			setState(113);
			switch (_input.LA(1)) {
			case EOF:
			case Mode:
			case Separator:
			case DocumentID:
			case SpecialAttribute:
			case Identifier:
			case Macrodef:
			case UserRights:
			case BeanShell:
			case Comment:
			case Lb:
				enterOuterAlt(_localctx, 1);
				{
				setState(108); attributeValue();
				}
				break;
			case DoubleQuote:
			case Quote:
				enterOuterAlt(_localctx, 2);
				{
				setState(109); quote();
				setState(110); attributeValue();
				setState(111); quote();
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
		enterRule(_localctx, 18, RULE_attributeName);
		int _la;
		try {
			setState(122);
			switch (_input.LA(1)) {
			case Macrodef:
				enterOuterAlt(_localctx, 1);
				{
				setState(115); match(Macrodef);
				}
				break;
			case SpecialAttribute:
				enterOuterAlt(_localctx, 2);
				{
				setState(116); match(SpecialAttribute);
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 3);
				{
				{
				setState(117); match(Identifier);
				setState(120);
				_la = _input.LA(1);
				if (_la==Dot) {
					{
					setState(118); match(Dot);
					setState(119); attributeName();
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
		public AttributeModifierAssignmentContext attributeModifierAssignment(int i) {
			return getRuleContext(AttributeModifierAssignmentContext.class,i);
		}
		public List<AttributeModifierAssignmentContext> attributeModifierAssignment() {
			return getRuleContexts(AttributeModifierAssignmentContext.class);
		}
		public TerminalNode Comma(int i) {
			return getToken(ImpexParser.Comma, i);
		}
		public TerminalNode DocumentID() { return getToken(ImpexParser.DocumentID, 0); }
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
		enterRule(_localctx, 20, RULE_attributeValue);
		int _la;
		try {
			setState(148);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(145);
				switch (_input.LA(1)) {
				case DocumentID:
					{
					setState(124); match(DocumentID);
					}
					break;
				case SpecialAttribute:
				case Identifier:
				case Macrodef:
					{
					setState(125); attributeName();
					setState(137);
					_la = _input.LA(1);
					if (_la==LParenthesis) {
						{
						setState(126); match(LParenthesis);
						setState(127); attributeValue();
						setState(132);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==Comma) {
							{
							{
							setState(128); match(Comma);
							setState(129); attributeValue();
							}
							}
							setState(134);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(135); match(RParenthesis);
						}
					}

					setState(142);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Macroref) | (1L << BooleanAttributeModifier) | (1L << IntAttributeModifier) | (1L << DateFormatAttributeModifier) | (1L << NumberFormatAttributeModifier) | (1L << ClassAttributeModifier) | (1L << TextAttributeModifier) | (1L << UnknownModifier))) != 0)) {
						{
						{
						setState(139); attributeModifierAssignment();
						}
						}
						setState(144);
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

	public static class AttributeModifierAssignmentContext extends ParserRuleContext {
		public AttributeModifierContext attributeModifier() {
			return getRuleContext(AttributeModifierContext.class,0);
		}
		public ModifierValueContext modifierValue() {
			return getRuleContext(ModifierValueContext.class,0);
		}
		public UnknownModifierContext unknownModifier() {
			return getRuleContext(UnknownModifierContext.class,0);
		}
		public TerminalNode Equals() { return getToken(ImpexParser.Equals, 0); }
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
		int _la;
		try {
			setState(162);
			switch (_input.LA(1)) {
			case BooleanAttributeModifier:
			case IntAttributeModifier:
			case DateFormatAttributeModifier:
			case NumberFormatAttributeModifier:
			case ClassAttributeModifier:
			case TextAttributeModifier:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(150); attributeModifier();
				setState(151); match(Equals);
				setState(153);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(152); modifierValue();
					}
					break;
				}
				}
				}
				break;
			case Macroref:
			case UnknownModifier:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(155); unknownModifier();
				setState(157);
				_la = _input.LA(1);
				if (_la==Equals) {
					{
					setState(156); match(Equals);
					}
				}

				setState(160);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(159); modifierValue();
					}
					break;
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
			setState(164);
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

	public static class UnknownModifierContext extends ParserRuleContext {
		public TerminalNode UnknownModifier(int i) {
			return getToken(ImpexParser.UnknownModifier, i);
		}
		public TerminalNode Macroref(int i) {
			return getToken(ImpexParser.Macroref, i);
		}
		public List<TerminalNode> UnknownModifier() { return getTokens(ImpexParser.UnknownModifier); }
		public List<TerminalNode> Macroref() { return getTokens(ImpexParser.Macroref); }
		public UnknownModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unknownModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterUnknownModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitUnknownModifier(this);
		}
	}

	public final UnknownModifierContext unknownModifier() throws RecognitionException {
		UnknownModifierContext _localctx = new UnknownModifierContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_unknownModifier);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(167); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(166);
					_la = _input.LA(1);
					if ( !(_la==Macroref || _la==UnknownModifier) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(169); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class ModifierValueContext extends ParserRuleContext {
		public TerminalNode Modifierval(int i) {
			return getToken(ImpexParser.Modifierval, i);
		}
		public TerminalNode Macroref(int i) {
			return getToken(ImpexParser.Macroref, i);
		}
		public List<TerminalNode> Macroref() { return getTokens(ImpexParser.Macroref); }
		public List<TerminalNode> Modifierval() { return getTokens(ImpexParser.Modifierval); }
		public ModifierValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifierValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterModifierValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitModifierValue(this);
		}
	}

	public final ModifierValueContext modifierValue() throws RecognitionException {
		ModifierValueContext _localctx = new ModifierValueContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_modifierValue);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(172); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(171);
					_la = _input.LA(1);
					if ( !(_la==Macroref || _la==Modifierval) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(174); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		public TerminalNode Macroref() { return getToken(ImpexParser.Macroref, 0); }
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
		enterRule(_localctx, 30, RULE_headerTypeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			_la = _input.LA(1);
			if ( !(_la==Macroref || _la==Identifier) ) {
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

	public static class MacroContext extends ParserRuleContext {
		public MacroValueContext macroValue() {
			return getRuleContext(MacroValueContext.class,0);
		}
		public TerminalNode Macrodef() { return getToken(ImpexParser.Macrodef, 0); }
		public TerminalNode Equals() { return getToken(ImpexParser.Equals, 0); }
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
		enterRule(_localctx, 32, RULE_macro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178); match(Macrodef);
			setState(179); match(Equals);
			setState(180); macroValue();
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

	public static class MacroValueContext extends ParserRuleContext {
		public TerminalNode Macroref(int i) {
			return getToken(ImpexParser.Macroref, i);
		}
		public List<TerminalNode> Macroref() { return getTokens(ImpexParser.Macroref); }
		public TerminalNode Macroval(int i) {
			return getToken(ImpexParser.Macroval, i);
		}
		public List<TerminalNode> Macroval() { return getTokens(ImpexParser.Macroval); }
		public MacroValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macroValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterMacroValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitMacroValue(this);
		}
	}

	public final MacroValueContext macroValue() throws RecognitionException {
		MacroValueContext _localctx = new MacroValueContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_macroValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Macroref || _la==Macroval) {
				{
				{
				setState(182);
				_la = _input.LA(1);
				if ( !(_la==Macroref || _la==Macroval) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(187);
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

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3*\u00bf\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\7\2+\n\2\f\2\16\2.\13\2\3\2\3\2\7\2\62\n\2"+
		"\f\2\16\2\65\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\7\3>\n\3\f\3\16\3A\13\3"+
		"\3\4\3\4\3\4\7\4F\n\4\f\4\16\4I\13\4\3\4\3\4\7\4M\n\4\f\4\16\4P\13\4\3"+
		"\4\5\4S\n\4\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\5\b^\n\b\3\b\3\b\6\bb"+
		"\n\b\r\b\16\bc\3\b\5\bg\n\b\3\t\7\tj\n\t\f\t\16\tm\13\t\3\n\3\n\3\n\3"+
		"\n\3\n\5\nt\n\n\3\13\3\13\3\13\3\13\3\13\5\13{\n\13\5\13}\n\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\7\f\u0085\n\f\f\f\16\f\u0088\13\f\3\f\3\f\5\f\u008c\n"+
		"\f\3\f\7\f\u008f\n\f\f\f\16\f\u0092\13\f\5\f\u0094\n\f\3\f\5\f\u0097\n"+
		"\f\3\r\3\r\3\r\5\r\u009c\n\r\3\r\3\r\5\r\u00a0\n\r\3\r\5\r\u00a3\n\r\5"+
		"\r\u00a5\n\r\3\16\3\16\3\17\6\17\u00aa\n\17\r\17\16\17\u00ab\3\20\6\20"+
		"\u00af\n\20\r\20\16\20\u00b0\3\21\3\21\3\22\3\22\3\22\3\22\3\23\7\23\u00ba"+
		"\n\23\f\23\16\23\u00bd\13\23\3\23\2\2\24\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$\2\n\3\2\22\23\3\2\f\16\4\2\5\5#$\3\2\6\13\4\2\5\5\17\17"+
		"\4\2\5\5**\4\2\5\5\33\33\4\2\5\5%%\u00cd\2,\3\2\2\2\48\3\2\2\2\6B\3\2"+
		"\2\2\bT\3\2\2\2\nV\3\2\2\2\fZ\3\2\2\2\16]\3\2\2\2\20k\3\2\2\2\22s\3\2"+
		"\2\2\24|\3\2\2\2\26\u0096\3\2\2\2\30\u00a4\3\2\2\2\32\u00a6\3\2\2\2\34"+
		"\u00a9\3\2\2\2\36\u00ae\3\2\2\2 \u00b2\3\2\2\2\"\u00b4\3\2\2\2$\u00bb"+
		"\3\2\2\2&+\7\35\2\2\'+\7\36\2\2(+\7\37\2\2)+\5\"\22\2*&\3\2\2\2*\'\3\2"+
		"\2\2*(\3\2\2\2*)\3\2\2\2+.\3\2\2\2,*\3\2\2\2,-\3\2\2\2-\63\3\2\2\2.,\3"+
		"\2\2\2/\62\5\4\3\2\60\62\7\35\2\2\61/\3\2\2\2\61\60\3\2\2\2\62\65\3\2"+
		"\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64\66\3\2\2\2\65\63\3\2\2\2\66\67\7\2"+
		"\2\3\67\3\3\2\2\28?\5\6\4\29>\7\36\2\2:>\7\37\2\2;>\5\"\22\2<>\5\16\b"+
		"\2=9\3\2\2\2=:\3\2\2\2=;\3\2\2\2=<\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2"+
		"\2@\5\3\2\2\2A?\3\2\2\2BC\7\3\2\2CG\5 \21\2DF\5\n\6\2ED\3\2\2\2FI\3\2"+
		"\2\2GE\3\2\2\2GH\3\2\2\2HN\3\2\2\2IG\3\2\2\2JK\7\4\2\2KM\5\22\n\2LJ\3"+
		"\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2OR\3\2\2\2PN\3\2\2\2QS\7 \2\2RQ\3"+
		"\2\2\2RS\3\2\2\2S\7\3\2\2\2TU\t\2\2\2U\t\3\2\2\2VW\5\f\7\2WX\7\26\2\2"+
		"XY\5\36\20\2Y\13\3\2\2\2Z[\t\3\2\2[\r\3\2\2\2\\^\7\33\2\2]\\\3\2\2\2]"+
		"^\3\2\2\2^a\3\2\2\2_`\7\4\2\2`b\5\20\t\2a_\3\2\2\2bc\3\2\2\2ca\3\2\2\2"+
		"cd\3\2\2\2df\3\2\2\2eg\7 \2\2fe\3\2\2\2fg\3\2\2\2g\17\3\2\2\2hj\t\4\2"+
		"\2ih\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2l\21\3\2\2\2mk\3\2\2\2nt\5\26"+
		"\f\2op\5\b\5\2pq\5\26\f\2qr\5\b\5\2rt\3\2\2\2sn\3\2\2\2so\3\2\2\2t\23"+
		"\3\2\2\2u}\7\34\2\2v}\7\32\2\2wz\7\33\2\2xy\7\21\2\2y{\5\24\13\2zx\3\2"+
		"\2\2z{\3\2\2\2{}\3\2\2\2|u\3\2\2\2|v\3\2\2\2|w\3\2\2\2}\25\3\2\2\2~\u0094"+
		"\7\31\2\2\177\u008b\5\24\13\2\u0080\u0081\7\24\2\2\u0081\u0086\5\26\f"+
		"\2\u0082\u0083\7\20\2\2\u0083\u0085\5\26\f\2\u0084\u0082\3\2\2\2\u0085"+
		"\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0089\3\2"+
		"\2\2\u0088\u0086\3\2\2\2\u0089\u008a\7\25\2\2\u008a\u008c\3\2\2\2\u008b"+
		"\u0080\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u0090\3\2\2\2\u008d\u008f\5\30"+
		"\r\2\u008e\u008d\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090"+
		"\u0091\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0093~\3\2\2\2"+
		"\u0093\177\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0097\3\2\2\2\u0096\u0093"+
		"\3\2\2\2\u0096\u0095\3\2\2\2\u0097\27\3\2\2\2\u0098\u0099\5\32\16\2\u0099"+
		"\u009b\7\26\2\2\u009a\u009c\5\36\20\2\u009b\u009a\3\2\2\2\u009b\u009c"+
		"\3\2\2\2\u009c\u00a5\3\2\2\2\u009d\u009f\5\34\17\2\u009e\u00a0\7\26\2"+
		"\2\u009f\u009e\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a2\3\2\2\2\u00a1\u00a3"+
		"\5\36\20\2\u00a2\u00a1\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a5\3\2\2\2"+
		"\u00a4\u0098\3\2\2\2\u00a4\u009d\3\2\2\2\u00a5\31\3\2\2\2\u00a6\u00a7"+
		"\t\5\2\2\u00a7\33\3\2\2\2\u00a8\u00aa\t\6\2\2\u00a9\u00a8\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\35\3\2\2"+
		"\2\u00ad\u00af\t\7\2\2\u00ae\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00ae"+
		"\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\37\3\2\2\2\u00b2\u00b3\t\b\2\2\u00b3"+
		"!\3\2\2\2\u00b4\u00b5\7\34\2\2\u00b5\u00b6\7\26\2\2\u00b6\u00b7\5$\23"+
		"\2\u00b7#\3\2\2\2\u00b8\u00ba\t\t\2\2\u00b9\u00b8\3\2\2\2\u00ba\u00bd"+
		"\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc%\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\36*,\61\63=?GNR]cfksz|\u0086\u008b\u0090\u0093\u0096\u009b"+
		"\u009f\u00a2\u00a4\u00ab\u00b0\u00bb";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}