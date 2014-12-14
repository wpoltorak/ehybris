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
		FieldQuoted=36, Field=39, IntAttributeModifier=8, DocumentIdField=6, UserRights=30, 
		UnknownModifier=16, Ws=34, Type=2, ClassHeaderModifier=14, ModifierBracket=43, 
		BooleanAttributeModifier=7, NumberFormatAttributeModifier=10, Quote=20, 
		LParenthesis=21, Lb=33, Identifier=28, LineSeparator=25, Separator=3, 
		RParenthesis=22, DocumentID=26, TextAttributeModifier=12, ModifiervalBracket=44, 
		BooleanHeaderModifier=13, Macroref=4, TextHeaderModifier=15, SpecialAttribute=27, 
		Comment=32, ClassAttributeModifier=11, Macrodef=29, Mode=1, DoubleQuote=19, 
		Error=35, Dot=18, Modifierval=45, ABracket=42, DateFormatAttributeModifier=9, 
		FieldMulti=38, Macroval=40, LBracket=41, Or=24, BeanShell=31, Comma=17, 
		Equals=23, FieldLb=37, SkippedField=5;
	public static final String[] tokenNames = {
		"<INVALID>", "Mode", "Type", "';'", "Macroref", "SkippedField", "DocumentIdField", 
		"BooleanAttributeModifier", "IntAttributeModifier", "DateFormatAttributeModifier", 
		"NumberFormatAttributeModifier", "ClassAttributeModifier", "TextAttributeModifier", 
		"BooleanHeaderModifier", "ClassHeaderModifier", "TextHeaderModifier", 
		"UnknownModifier", "','", "'.'", "'\"'", "'''", "'('", "')'", "'='", "'|'", 
		"LineSeparator", "DocumentID", "SpecialAttribute", "Identifier", "Macrodef", 
		"UserRights", "BeanShell", "Comment", "Lb", "Ws", "Error", "FieldQuoted", 
		"FieldLb", "FieldMulti", "Field", "Macroval", "LBracket", "ABracket", 
		"']'", "ModifiervalBracket", "Modifierval"
	};
	public static final int
		RULE_impex = 0, RULE_block = 1, RULE_header = 2, RULE_quote = 3, RULE_headerModifierAssignment = 4, 
		RULE_headerModifier = 5, RULE_record = 6, RULE_field = 7, RULE_attribute = 8, 
		RULE_emptyAttribute = 9, RULE_specialAttribute = 10, RULE_attributeSubtype = 11, 
		RULE_subtypeAttributeName = 12, RULE_attributeName = 13, RULE_simpleAttributeName = 14, 
		RULE_subtypeAttribute = 15, RULE_simpleAttribute = 16, RULE_attributeModifierAssignment = 17, 
		RULE_attributeModifier = 18, RULE_unknownModifier = 19, RULE_modifierValue = 20, 
		RULE_headerTypeName = 21, RULE_macro = 22, RULE_macroValue = 23;
	public static final String[] ruleNames = {
		"impex", "block", "header", "quote", "headerModifierAssignment", "headerModifier", 
		"record", "field", "attribute", "emptyAttribute", "specialAttribute", 
		"attributeSubtype", "subtypeAttributeName", "attributeName", "simpleAttributeName", 
		"subtypeAttribute", "simpleAttribute", "attributeModifierAssignment", 
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
			setState(54);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(52);
					switch (_input.LA(1)) {
					case UserRights:
						{
						setState(48); match(UserRights);
						}
						break;
					case BeanShell:
						{
						setState(49); match(BeanShell);
						}
						break;
					case Comment:
						{
						setState(50); match(Comment);
						}
						break;
					case Macrodef:
						{
						setState(51); macro();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(56);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(61);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Mode || _la==UserRights) {
				{
				setState(59);
				switch (_input.LA(1)) {
				case Mode:
					{
					setState(57); block();
					}
					break;
				case UserRights:
					{
					setState(58); match(UserRights);
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
			setState(64); match(EOF);
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
			setState(66); header();
			setState(73);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Type) | (1L << Separator) | (1L << Macrodef) | (1L << BeanShell) | (1L << Comment))) != 0)) {
				{
				setState(71);
				switch (_input.LA(1)) {
				case BeanShell:
					{
					setState(67); match(BeanShell);
					}
					break;
				case Comment:
					{
					setState(68); match(Comment);
					}
					break;
				case Macrodef:
					{
					setState(69); macro();
					}
					break;
				case Type:
				case Separator:
					{
					setState(70); record();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(75);
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
			setState(76); match(Mode);
			setState(77); headerTypeName();
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BooleanHeaderModifier) | (1L << ClassHeaderModifier) | (1L << TextHeaderModifier))) != 0)) {
				{
				{
				setState(78); headerModifierAssignment();
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(88);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(84); match(Separator);
					setState(85); attribute();
					}
					} 
				}
				setState(90);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(92);
			_la = _input.LA(1);
			if (_la==Lb) {
				{
				setState(91); match(Lb);
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
			setState(94);
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
			setState(96); headerModifier();
			setState(97); match(Equals);
			setState(98); modifierValue();
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
			setState(100);
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
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public TerminalNode Separator(int i) {
			return getToken(ImpexParser.Separator, i);
		}
		public TerminalNode Type() { return getToken(ImpexParser.Type, 0); }
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
			setState(103);
			_la = _input.LA(1);
			if (_la==Type) {
				{
				setState(102); match(Type);
				}
			}

			setState(107); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(105); match(Separator);
					setState(106); field();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(109); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(112);
			_la = _input.LA(1);
			if (_la==Lb) {
				{
				setState(111); match(Lb);
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
		public TerminalNode SkippedField(int i) {
			return getToken(ImpexParser.SkippedField, i);
		}
		public TerminalNode Macroref(int i) {
			return getToken(ImpexParser.Macroref, i);
		}
		public TerminalNode DocumentIdField(int i) {
			return getToken(ImpexParser.DocumentIdField, i);
		}
		public List<TerminalNode> Macroref() { return getTokens(ImpexParser.Macroref); }
		public List<TerminalNode> FieldQuoted() { return getTokens(ImpexParser.FieldQuoted); }
		public TerminalNode Field(int i) {
			return getToken(ImpexParser.Field, i);
		}
		public List<TerminalNode> Field() { return getTokens(ImpexParser.Field); }
		public List<TerminalNode> SkippedField() { return getTokens(ImpexParser.SkippedField); }
		public List<TerminalNode> DocumentIdField() { return getTokens(ImpexParser.DocumentIdField); }
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
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Macroref) | (1L << SkippedField) | (1L << DocumentIdField) | (1L << FieldQuoted) | (1L << Field))) != 0)) {
				{
				{
				setState(114);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Macroref) | (1L << SkippedField) | (1L << DocumentIdField) | (1L << FieldQuoted) | (1L << Field))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(119);
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
		public EmptyAttributeContext emptyAttribute() {
			return getRuleContext(EmptyAttributeContext.class,0);
		}
		public SubtypeAttributeContext subtypeAttribute() {
			return getRuleContext(SubtypeAttributeContext.class,0);
		}
		public SimpleAttributeContext simpleAttribute() {
			return getRuleContext(SimpleAttributeContext.class,0);
		}
		public SpecialAttributeContext specialAttribute() {
			return getRuleContext(SpecialAttributeContext.class,0);
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
			setState(124);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(120); specialAttribute();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(121); subtypeAttribute();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(122); simpleAttribute();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(123); emptyAttribute();
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

	public static class EmptyAttributeContext extends ParserRuleContext {
		public EmptyAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyAttribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterEmptyAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitEmptyAttribute(this);
		}
	}

	public final EmptyAttributeContext emptyAttribute() throws RecognitionException {
		EmptyAttributeContext _localctx = new EmptyAttributeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_emptyAttribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
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

	public static class SpecialAttributeContext extends ParserRuleContext {
		public AttributeModifierAssignmentContext attributeModifierAssignment(int i) {
			return getRuleContext(AttributeModifierAssignmentContext.class,i);
		}
		public TerminalNode SpecialAttribute() { return getToken(ImpexParser.SpecialAttribute, 0); }
		public List<AttributeModifierAssignmentContext> attributeModifierAssignment() {
			return getRuleContexts(AttributeModifierAssignmentContext.class);
		}
		public SpecialAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_specialAttribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterSpecialAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitSpecialAttribute(this);
		}
	}

	public final SpecialAttributeContext specialAttribute() throws RecognitionException {
		SpecialAttributeContext _localctx = new SpecialAttributeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_specialAttribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128); match(SpecialAttribute);
			setState(130); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(129); attributeModifierAssignment();
				}
				}
				setState(132); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Macroref) | (1L << BooleanAttributeModifier) | (1L << IntAttributeModifier) | (1L << DateFormatAttributeModifier) | (1L << NumberFormatAttributeModifier) | (1L << ClassAttributeModifier) | (1L << TextAttributeModifier) | (1L << UnknownModifier))) != 0) );
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

	public static class AttributeSubtypeContext extends ParserRuleContext {
		public AttributeNameContext attributeName() {
			return getRuleContext(AttributeNameContext.class,0);
		}
		public TerminalNode Dot() { return getToken(ImpexParser.Dot, 0); }
		public AttributeSubtypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeSubtype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterAttributeSubtype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitAttributeSubtype(this);
		}
	}

	public final AttributeSubtypeContext attributeSubtype() throws RecognitionException {
		AttributeSubtypeContext _localctx = new AttributeSubtypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_attributeSubtype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134); attributeName();
			setState(135); match(Dot);
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

	public static class SubtypeAttributeNameContext extends ParserRuleContext {
		public TerminalNode Or(int i) {
			return getToken(ImpexParser.Or, i);
		}
		public AttributeNameContext attributeName(int i) {
			return getRuleContext(AttributeNameContext.class,i);
		}
		public AttributeSubtypeContext attributeSubtype(int i) {
			return getRuleContext(AttributeSubtypeContext.class,i);
		}
		public List<AttributeNameContext> attributeName() {
			return getRuleContexts(AttributeNameContext.class);
		}
		public List<TerminalNode> Or() { return getTokens(ImpexParser.Or); }
		public List<AttributeSubtypeContext> attributeSubtype() {
			return getRuleContexts(AttributeSubtypeContext.class);
		}
		public SubtypeAttributeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subtypeAttributeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterSubtypeAttributeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitSubtypeAttributeName(this);
		}
	}

	public final SubtypeAttributeNameContext subtypeAttributeName() throws RecognitionException {
		SubtypeAttributeNameContext _localctx = new SubtypeAttributeNameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_subtypeAttributeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137); attributeSubtype();
			setState(138); attributeName();
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Or) {
				{
				{
				setState(139); match(Or);
				setState(140); attributeSubtype();
				setState(141); attributeName();
				}
				}
				setState(147);
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

	public static class AttributeNameContext extends ParserRuleContext {
		public TerminalNode Macroref() { return getToken(ImpexParser.Macroref, 0); }
		public TerminalNode Identifier() { return getToken(ImpexParser.Identifier, 0); }
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
		enterRule(_localctx, 26, RULE_attributeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
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

	public static class SimpleAttributeNameContext extends ParserRuleContext {
		public AttributeNameContext attributeName() {
			return getRuleContext(AttributeNameContext.class,0);
		}
		public SimpleAttributeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleAttributeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterSimpleAttributeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitSimpleAttributeName(this);
		}
	}

	public final SimpleAttributeNameContext simpleAttributeName() throws RecognitionException {
		SimpleAttributeNameContext _localctx = new SimpleAttributeNameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_simpleAttributeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150); attributeName();
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

	public static class SubtypeAttributeContext extends ParserRuleContext {
		public TerminalNode LParenthesis() { return getToken(ImpexParser.LParenthesis, 0); }
		public TerminalNode RParenthesis() { return getToken(ImpexParser.RParenthesis, 0); }
		public AttributeModifierAssignmentContext attributeModifierAssignment(int i) {
			return getRuleContext(AttributeModifierAssignmentContext.class,i);
		}
		public SubtypeAttributeNameContext subtypeAttributeName() {
			return getRuleContext(SubtypeAttributeNameContext.class,0);
		}
		public List<AttributeModifierAssignmentContext> attributeModifierAssignment() {
			return getRuleContexts(AttributeModifierAssignmentContext.class);
		}
		public SimpleAttributeNameContext simpleAttributeName() {
			return getRuleContext(SimpleAttributeNameContext.class,0);
		}
		public SubtypeAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subtypeAttribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterSubtypeAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitSubtypeAttribute(this);
		}
	}

	public final SubtypeAttributeContext subtypeAttribute() throws RecognitionException {
		SubtypeAttributeContext _localctx = new SubtypeAttributeContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_subtypeAttribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152); simpleAttributeName();
			setState(153); match(LParenthesis);
			setState(154); subtypeAttributeName();
			setState(155); match(RParenthesis);
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Macroref) | (1L << BooleanAttributeModifier) | (1L << IntAttributeModifier) | (1L << DateFormatAttributeModifier) | (1L << NumberFormatAttributeModifier) | (1L << ClassAttributeModifier) | (1L << TextAttributeModifier) | (1L << UnknownModifier))) != 0)) {
				{
				{
				setState(156); attributeModifierAssignment();
				}
				}
				setState(161);
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

	public static class SimpleAttributeContext extends ParserRuleContext {
		public TerminalNode LParenthesis() { return getToken(ImpexParser.LParenthesis, 0); }
		public TerminalNode RParenthesis() { return getToken(ImpexParser.RParenthesis, 0); }
		public AttributeModifierAssignmentContext attributeModifierAssignment(int i) {
			return getRuleContext(AttributeModifierAssignmentContext.class,i);
		}
		public List<SimpleAttributeContext> simpleAttribute() {
			return getRuleContexts(SimpleAttributeContext.class);
		}
		public List<AttributeModifierAssignmentContext> attributeModifierAssignment() {
			return getRuleContexts(AttributeModifierAssignmentContext.class);
		}
		public TerminalNode Comma(int i) {
			return getToken(ImpexParser.Comma, i);
		}
		public SimpleAttributeContext simpleAttribute(int i) {
			return getRuleContext(SimpleAttributeContext.class,i);
		}
		public SimpleAttributeNameContext simpleAttributeName() {
			return getRuleContext(SimpleAttributeNameContext.class,0);
		}
		public TerminalNode DocumentID() { return getToken(ImpexParser.DocumentID, 0); }
		public List<TerminalNode> Comma() { return getTokens(ImpexParser.Comma); }
		public SimpleAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleAttribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterSimpleAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitSimpleAttribute(this);
		}
	}

	public final SimpleAttributeContext simpleAttribute() throws RecognitionException {
		SimpleAttributeContext _localctx = new SimpleAttributeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_simpleAttribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			switch (_input.LA(1)) {
			case DocumentID:
				{
				setState(162); match(DocumentID);
				}
				break;
			case Macroref:
			case Identifier:
				{
				setState(163); simpleAttributeName();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(177);
			_la = _input.LA(1);
			if (_la==LParenthesis) {
				{
				setState(166); match(LParenthesis);
				setState(167); simpleAttribute();
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(168); match(Comma);
					setState(169); simpleAttribute();
					}
					}
					setState(174);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(175); match(RParenthesis);
				}
			}

			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Macroref) | (1L << BooleanAttributeModifier) | (1L << IntAttributeModifier) | (1L << DateFormatAttributeModifier) | (1L << NumberFormatAttributeModifier) | (1L << ClassAttributeModifier) | (1L << TextAttributeModifier) | (1L << UnknownModifier))) != 0)) {
				{
				{
				setState(179); attributeModifierAssignment();
				}
				}
				setState(184);
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
		enterRule(_localctx, 34, RULE_attributeModifierAssignment);
		int _la;
		try {
			setState(197);
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
				setState(185); attributeModifier();
				setState(186); match(Equals);
				setState(188);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(187); modifierValue();
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
				setState(190); unknownModifier();
				setState(192);
				_la = _input.LA(1);
				if (_la==Equals) {
					{
					setState(191); match(Equals);
					}
				}

				setState(195);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					setState(194); modifierValue();
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
		enterRule(_localctx, 36, RULE_attributeModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
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
		enterRule(_localctx, 38, RULE_unknownModifier);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(202); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(201);
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
				setState(204); 
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
		enterRule(_localctx, 40, RULE_modifierValue);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(207); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(206);
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
				setState(209); 
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
		public TerminalNode Type() { return getToken(ImpexParser.Type, 0); }
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
		enterRule(_localctx, 42, RULE_headerTypeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			_la = _input.LA(1);
			if ( !(_la==Type || _la==Macroref) ) {
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
		enterRule(_localctx, 44, RULE_macro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213); match(Macrodef);
			setState(214); match(Equals);
			setState(215); macroValue();
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
		enterRule(_localctx, 46, RULE_macroValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Macroref || _la==Macroval) {
				{
				{
				setState(217);
				_la = _input.LA(1);
				if ( !(_la==Macroref || _la==Macroval) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(222);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3/\u00e2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\3\2\3\2\3\2\3\2\7\2\67\n\2\f\2\16\2:\13\2\3\2\3\2\7\2>\n\2\f\2\16\2A"+
		"\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\7\3J\n\3\f\3\16\3M\13\3\3\4\3\4\3\4"+
		"\7\4R\n\4\f\4\16\4U\13\4\3\4\3\4\7\4Y\n\4\f\4\16\4\\\13\4\3\4\5\4_\n\4"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\5\bj\n\b\3\b\3\b\6\bn\n\b\r\b\16"+
		"\bo\3\b\5\bs\n\b\3\t\7\tv\n\t\f\t\16\ty\13\t\3\n\3\n\3\n\3\n\5\n\177\n"+
		"\n\3\13\3\13\3\f\3\f\6\f\u0085\n\f\r\f\16\f\u0086\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\7\16\u0092\n\16\f\16\16\16\u0095\13\16\3\17\3\17"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\7\21\u00a0\n\21\f\21\16\21\u00a3\13"+
		"\21\3\22\3\22\5\22\u00a7\n\22\3\22\3\22\3\22\3\22\7\22\u00ad\n\22\f\22"+
		"\16\22\u00b0\13\22\3\22\3\22\5\22\u00b4\n\22\3\22\7\22\u00b7\n\22\f\22"+
		"\16\22\u00ba\13\22\3\23\3\23\3\23\5\23\u00bf\n\23\3\23\3\23\5\23\u00c3"+
		"\n\23\3\23\5\23\u00c6\n\23\5\23\u00c8\n\23\3\24\3\24\3\25\6\25\u00cd\n"+
		"\25\r\25\16\25\u00ce\3\26\6\26\u00d2\n\26\r\26\16\26\u00d3\3\27\3\27\3"+
		"\30\3\30\3\30\3\30\3\31\7\31\u00dd\n\31\f\31\16\31\u00e0\13\31\3\31\2"+
		"\2\32\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\2\13\3\2\25\26"+
		"\3\2\17\21\5\2\6\b&&))\4\2\6\6\36\36\3\2\t\16\4\2\6\6\22\22\4\2\6\6//"+
		"\4\2\4\4\6\6\4\2\6\6**\u00eb\28\3\2\2\2\4D\3\2\2\2\6N\3\2\2\2\b`\3\2\2"+
		"\2\nb\3\2\2\2\ff\3\2\2\2\16i\3\2\2\2\20w\3\2\2\2\22~\3\2\2\2\24\u0080"+
		"\3\2\2\2\26\u0082\3\2\2\2\30\u0088\3\2\2\2\32\u008b\3\2\2\2\34\u0096\3"+
		"\2\2\2\36\u0098\3\2\2\2 \u009a\3\2\2\2\"\u00a6\3\2\2\2$\u00c7\3\2\2\2"+
		"&\u00c9\3\2\2\2(\u00cc\3\2\2\2*\u00d1\3\2\2\2,\u00d5\3\2\2\2.\u00d7\3"+
		"\2\2\2\60\u00de\3\2\2\2\62\67\7 \2\2\63\67\7!\2\2\64\67\7\"\2\2\65\67"+
		"\5.\30\2\66\62\3\2\2\2\66\63\3\2\2\2\66\64\3\2\2\2\66\65\3\2\2\2\67:\3"+
		"\2\2\28\66\3\2\2\289\3\2\2\29?\3\2\2\2:8\3\2\2\2;>\5\4\3\2<>\7 \2\2=;"+
		"\3\2\2\2=<\3\2\2\2>A\3\2\2\2?=\3\2\2\2?@\3\2\2\2@B\3\2\2\2A?\3\2\2\2B"+
		"C\7\2\2\3C\3\3\2\2\2DK\5\6\4\2EJ\7!\2\2FJ\7\"\2\2GJ\5.\30\2HJ\5\16\b\2"+
		"IE\3\2\2\2IF\3\2\2\2IG\3\2\2\2IH\3\2\2\2JM\3\2\2\2KI\3\2\2\2KL\3\2\2\2"+
		"L\5\3\2\2\2MK\3\2\2\2NO\7\3\2\2OS\5,\27\2PR\5\n\6\2QP\3\2\2\2RU\3\2\2"+
		"\2SQ\3\2\2\2ST\3\2\2\2TZ\3\2\2\2US\3\2\2\2VW\7\5\2\2WY\5\22\n\2XV\3\2"+
		"\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[^\3\2\2\2\\Z\3\2\2\2]_\7#\2\2^]\3"+
		"\2\2\2^_\3\2\2\2_\7\3\2\2\2`a\t\2\2\2a\t\3\2\2\2bc\5\f\7\2cd\7\31\2\2"+
		"de\5*\26\2e\13\3\2\2\2fg\t\3\2\2g\r\3\2\2\2hj\7\4\2\2ih\3\2\2\2ij\3\2"+
		"\2\2jm\3\2\2\2kl\7\5\2\2ln\5\20\t\2mk\3\2\2\2no\3\2\2\2om\3\2\2\2op\3"+
		"\2\2\2pr\3\2\2\2qs\7#\2\2rq\3\2\2\2rs\3\2\2\2s\17\3\2\2\2tv\t\4\2\2ut"+
		"\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\21\3\2\2\2yw\3\2\2\2z\177\5\26"+
		"\f\2{\177\5 \21\2|\177\5\"\22\2}\177\5\24\13\2~z\3\2\2\2~{\3\2\2\2~|\3"+
		"\2\2\2~}\3\2\2\2\177\23\3\2\2\2\u0080\u0081\3\2\2\2\u0081\25\3\2\2\2\u0082"+
		"\u0084\7\35\2\2\u0083\u0085\5$\23\2\u0084\u0083\3\2\2\2\u0085\u0086\3"+
		"\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\27\3\2\2\2\u0088"+
		"\u0089\5\34\17\2\u0089\u008a\7\24\2\2\u008a\31\3\2\2\2\u008b\u008c\5\30"+
		"\r\2\u008c\u0093\5\34\17\2\u008d\u008e\7\32\2\2\u008e\u008f\5\30\r\2\u008f"+
		"\u0090\5\34\17\2\u0090\u0092\3\2\2\2\u0091\u008d\3\2\2\2\u0092\u0095\3"+
		"\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\33\3\2\2\2\u0095"+
		"\u0093\3\2\2\2\u0096\u0097\t\5\2\2\u0097\35\3\2\2\2\u0098\u0099\5\34\17"+
		"\2\u0099\37\3\2\2\2\u009a\u009b\5\36\20\2\u009b\u009c\7\27\2\2\u009c\u009d"+
		"\5\32\16\2\u009d\u00a1\7\30\2\2\u009e\u00a0\5$\23\2\u009f\u009e\3\2\2"+
		"\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2!"+
		"\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a7\7\34\2\2\u00a5\u00a7\5\36\20"+
		"\2\u00a6\u00a4\3\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00b3\3\2\2\2\u00a8\u00a9"+
		"\7\27\2\2\u00a9\u00ae\5\"\22\2\u00aa\u00ab\7\23\2\2\u00ab\u00ad\5\"\22"+
		"\2\u00ac\u00aa\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af"+
		"\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b2\7\30\2\2"+
		"\u00b2\u00b4\3\2\2\2\u00b3\u00a8\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b8"+
		"\3\2\2\2\u00b5\u00b7\5$\23\2\u00b6\u00b5\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8"+
		"\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9#\3\2\2\2\u00ba\u00b8\3\2\2\2"+
		"\u00bb\u00bc\5&\24\2\u00bc\u00be\7\31\2\2\u00bd\u00bf\5*\26\2\u00be\u00bd"+
		"\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c8\3\2\2\2\u00c0\u00c2\5(\25\2\u00c1"+
		"\u00c3\7\31\2\2\u00c2\u00c1\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c5\3"+
		"\2\2\2\u00c4\u00c6\5*\26\2\u00c5\u00c4\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6"+
		"\u00c8\3\2\2\2\u00c7\u00bb\3\2\2\2\u00c7\u00c0\3\2\2\2\u00c8%\3\2\2\2"+
		"\u00c9\u00ca\t\6\2\2\u00ca\'\3\2\2\2\u00cb\u00cd\t\7\2\2\u00cc\u00cb\3"+
		"\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf"+
		")\3\2\2\2\u00d0\u00d2\t\b\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2"+
		"\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4+\3\2\2\2\u00d5\u00d6\t"+
		"\t\2\2\u00d6-\3\2\2\2\u00d7\u00d8\7\37\2\2\u00d8\u00d9\7\31\2\2\u00d9"+
		"\u00da\5\60\31\2\u00da/\3\2\2\2\u00db\u00dd\t\n\2\2\u00dc\u00db\3\2\2"+
		"\2\u00dd\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\61"+
		"\3\2\2\2\u00e0\u00de\3\2\2\2\36\668=?IKSZ^iorw~\u0086\u0093\u00a1\u00a6"+
		"\u00ae\u00b3\u00b8\u00be\u00c2\u00c5\u00c7\u00ce\u00d3\u00de";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}