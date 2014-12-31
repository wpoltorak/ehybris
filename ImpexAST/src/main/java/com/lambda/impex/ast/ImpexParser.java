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
		FieldCommaSkipped=39, FieldQuoted=35, Field=41, DocumentIdField=37, IntAttributeModifier=7, 
		UserRights=29, UnknownModifier=15, Ws=33, Type=2, ADocumentID=45, ClassHeaderModifier=13, 
		ModifierBracket=46, BooleanAttributeModifier=6, NumberFormatAttributeModifier=9, 
		Quote=19, LParenthesis=20, Lb=32, Identifier=27, LineSeparator=24, Separator=3, 
		RParenthesis=21, DocumentID=25, TextAttributeModifier=11, ModifiervalBracket=47, 
		BooleanHeaderModifier=12, Macroref=4, TextHeaderModifier=14, SpecialAttribute=26, 
		Comment=31, ClassAttributeModifier=10, Macrodef=28, Mode=1, DoubleQuote=18, 
		Error=34, Dot=17, Modifierval=48, ABracket=44, DateFormatAttributeModifier=8, 
		FieldMulti=40, DocumentIdRefField=38, Macroval=42, LBracket=43, Or=23, 
		BeanShell=30, Comma=16, Equals=22, FieldLb=36, SkippedField=5;
	public static final String[] tokenNames = {
		"<INVALID>", "Mode", "Type", "';'", "Macroref", "SkippedField", "BooleanAttributeModifier", 
		"IntAttributeModifier", "DateFormatAttributeModifier", "NumberFormatAttributeModifier", 
		"ClassAttributeModifier", "TextAttributeModifier", "BooleanHeaderModifier", 
		"ClassHeaderModifier", "TextHeaderModifier", "UnknownModifier", "','", 
		"'.'", "'\"'", "'''", "'('", "')'", "'='", "'|'", "LineSeparator", "DocumentID", 
		"SpecialAttribute", "Identifier", "Macrodef", "UserRights", "BeanShell", 
		"Comment", "Lb", "Ws", "Error", "FieldQuoted", "FieldLb", "DocumentIdField", 
		"DocumentIdRefField", "FieldCommaSkipped", "FieldMulti", "Field", "Macroval", 
		"LBracket", "ABracket", "ADocumentID", "']'", "ModifiervalBracket", "Modifierval"
	};
	public static final int
		RULE_impex = 0, RULE_block = 1, RULE_header = 2, RULE_quote = 3, RULE_headerModifierAssignment = 4, 
		RULE_headerModifier = 5, RULE_record = 6, RULE_field = 7, RULE_documentIdField = 8, 
		RULE_documentIdRefField = 9, RULE_attribute = 10, RULE_documentIdReference = 11, 
		RULE_documentIdDefinition = 12, RULE_emptyAttribute = 13, RULE_specialAttribute = 14, 
		RULE_attributeSubtype = 15, RULE_subtypeAttributeName = 16, RULE_attributeName = 17, 
		RULE_simpleAttributeName = 18, RULE_subtypeAttribute = 19, RULE_simpleAttribute = 20, 
		RULE_attributeModifierAssignment = 21, RULE_attributeModifier = 22, RULE_unknownModifier = 23, 
		RULE_modifierValue = 24, RULE_headerTypeName = 25, RULE_macro = 26, RULE_macroValue = 27, 
		RULE_macroref = 28;
	public static final String[] ruleNames = {
		"impex", "block", "header", "quote", "headerModifierAssignment", "headerModifier", 
		"record", "field", "documentIdField", "documentIdRefField", "attribute", 
		"documentIdReference", "documentIdDefinition", "emptyAttribute", "specialAttribute", 
		"attributeSubtype", "subtypeAttributeName", "attributeName", "simpleAttributeName", 
		"subtypeAttribute", "simpleAttribute", "attributeModifierAssignment", 
		"attributeModifier", "unknownModifier", "modifierValue", "headerTypeName", 
		"macro", "macroValue", "macroref"
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
			setState(64);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(62);
					switch (_input.LA(1)) {
					case UserRights:
						{
						setState(58); match(UserRights);
						}
						break;
					case BeanShell:
						{
						setState(59); match(BeanShell);
						}
						break;
					case Comment:
						{
						setState(60); match(Comment);
						}
						break;
					case Macrodef:
						{
						setState(61); macro();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(66);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Mode || _la==UserRights) {
				{
				setState(69);
				switch (_input.LA(1)) {
				case Mode:
					{
					setState(67); block();
					}
					break;
				case UserRights:
					{
					setState(68); match(UserRights);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74); match(EOF);
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
			setState(76); header();
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Type) | (1L << Separator) | (1L << Macrodef) | (1L << BeanShell) | (1L << Comment))) != 0)) {
				{
				setState(81);
				switch (_input.LA(1)) {
				case BeanShell:
					{
					setState(77); match(BeanShell);
					}
					break;
				case Comment:
					{
					setState(78); match(Comment);
					}
					break;
				case Macrodef:
					{
					setState(79); macro();
					}
					break;
				case Type:
				case Separator:
					{
					setState(80); record();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(85);
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
			setState(86); match(Mode);
			setState(87); headerTypeName();
			setState(91);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BooleanHeaderModifier) | (1L << ClassHeaderModifier) | (1L << TextHeaderModifier))) != 0)) {
				{
				{
				setState(88); headerModifierAssignment();
				}
				}
				setState(93);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(98);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(94); match(Separator);
					setState(95); attribute();
					}
					} 
				}
				setState(100);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(102);
			_la = _input.LA(1);
			if (_la==Lb) {
				{
				setState(101); match(Lb);
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
			setState(104);
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
			setState(106); headerModifier();
			setState(107); match(Equals);
			setState(108); modifierValue();
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
			setState(110);
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
			setState(113);
			_la = _input.LA(1);
			if (_la==Type) {
				{
				setState(112); match(Type);
				}
			}

			setState(117); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(115); match(Separator);
					setState(116); field();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(119); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(122);
			_la = _input.LA(1);
			if (_la==Lb) {
				{
				setState(121); match(Lb);
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
		public DocumentIdRefFieldContext documentIdRefField(int i) {
			return getRuleContext(DocumentIdRefFieldContext.class,i);
		}
		public MacrorefContext macroref(int i) {
			return getRuleContext(MacrorefContext.class,i);
		}
		public List<TerminalNode> FieldQuoted() { return getTokens(ImpexParser.FieldQuoted); }
		public TerminalNode Field(int i) {
			return getToken(ImpexParser.Field, i);
		}
		public DocumentIdFieldContext documentIdField() {
			return getRuleContext(DocumentIdFieldContext.class,0);
		}
		public List<DocumentIdRefFieldContext> documentIdRefField() {
			return getRuleContexts(DocumentIdRefFieldContext.class);
		}
		public List<MacrorefContext> macroref() {
			return getRuleContexts(MacrorefContext.class);
		}
		public List<TerminalNode> Field() { return getTokens(ImpexParser.Field); }
		public List<TerminalNode> SkippedField() { return getTokens(ImpexParser.SkippedField); }
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
			setState(135);
			switch (_input.LA(1)) {
			case EOF:
			case Mode:
			case Type:
			case Separator:
			case Macroref:
			case SkippedField:
			case Macrodef:
			case UserRights:
			case BeanShell:
			case Comment:
			case Lb:
			case FieldQuoted:
			case DocumentIdRefField:
			case Field:
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Macroref) | (1L << SkippedField) | (1L << FieldQuoted) | (1L << DocumentIdRefField) | (1L << Field))) != 0)) {
					{
					setState(129);
					switch (_input.LA(1)) {
					case FieldQuoted:
						{
						setState(124); match(FieldQuoted);
						}
						break;
					case Field:
						{
						setState(125); match(Field);
						}
						break;
					case Macroref:
						{
						setState(126); macroref();
						}
						break;
					case SkippedField:
						{
						setState(127); match(SkippedField);
						}
						break;
					case DocumentIdRefField:
						{
						setState(128); documentIdRefField();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(133);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case DocumentIdField:
				enterOuterAlt(_localctx, 2);
				{
				setState(134); documentIdField();
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

	public static class DocumentIdFieldContext extends ParserRuleContext {
		public TerminalNode DocumentIdField() { return getToken(ImpexParser.DocumentIdField, 0); }
		public DocumentIdFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_documentIdField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterDocumentIdField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitDocumentIdField(this);
		}
	}

	public final DocumentIdFieldContext documentIdField() throws RecognitionException {
		DocumentIdFieldContext _localctx = new DocumentIdFieldContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_documentIdField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137); match(DocumentIdField);
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

	public static class DocumentIdRefFieldContext extends ParserRuleContext {
		public TerminalNode DocumentIdRefField() { return getToken(ImpexParser.DocumentIdRefField, 0); }
		public DocumentIdRefFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_documentIdRefField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterDocumentIdRefField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitDocumentIdRefField(this);
		}
	}

	public final DocumentIdRefFieldContext documentIdRefField() throws RecognitionException {
		DocumentIdRefFieldContext _localctx = new DocumentIdRefFieldContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_documentIdRefField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139); match(DocumentIdRefField);
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
		public DocumentIdReferenceContext documentIdReference() {
			return getRuleContext(DocumentIdReferenceContext.class,0);
		}
		public DocumentIdDefinitionContext documentIdDefinition() {
			return getRuleContext(DocumentIdDefinitionContext.class,0);
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
		enterRule(_localctx, 20, RULE_attribute);
		try {
			setState(147);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(141); specialAttribute();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(142); subtypeAttribute();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(143); documentIdReference();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(144); documentIdDefinition();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(145); simpleAttribute();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(146); emptyAttribute();
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

	public static class DocumentIdReferenceContext extends ParserRuleContext {
		public TerminalNode LParenthesis() { return getToken(ImpexParser.LParenthesis, 0); }
		public TerminalNode RParenthesis() { return getToken(ImpexParser.RParenthesis, 0); }
		public AttributeModifierAssignmentContext attributeModifierAssignment(int i) {
			return getRuleContext(AttributeModifierAssignmentContext.class,i);
		}
		public List<AttributeModifierAssignmentContext> attributeModifierAssignment() {
			return getRuleContexts(AttributeModifierAssignmentContext.class);
		}
		public TerminalNode DocumentID() { return getToken(ImpexParser.DocumentID, 0); }
		public SimpleAttributeNameContext simpleAttributeName() {
			return getRuleContext(SimpleAttributeNameContext.class,0);
		}
		public DocumentIdReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_documentIdReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterDocumentIdReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitDocumentIdReference(this);
		}
	}

	public final DocumentIdReferenceContext documentIdReference() throws RecognitionException {
		DocumentIdReferenceContext _localctx = new DocumentIdReferenceContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_documentIdReference);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149); simpleAttributeName();
			setState(150); match(LParenthesis);
			setState(151); match(DocumentID);
			setState(152); match(RParenthesis);
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Macroref) | (1L << BooleanAttributeModifier) | (1L << IntAttributeModifier) | (1L << DateFormatAttributeModifier) | (1L << NumberFormatAttributeModifier) | (1L << ClassAttributeModifier) | (1L << TextAttributeModifier) | (1L << UnknownModifier))) != 0)) {
				{
				{
				setState(153); attributeModifierAssignment();
				}
				}
				setState(158);
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

	public static class DocumentIdDefinitionContext extends ParserRuleContext {
		public TerminalNode DocumentID() { return getToken(ImpexParser.DocumentID, 0); }
		public DocumentIdDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_documentIdDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterDocumentIdDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitDocumentIdDefinition(this);
		}
	}

	public final DocumentIdDefinitionContext documentIdDefinition() throws RecognitionException {
		DocumentIdDefinitionContext _localctx = new DocumentIdDefinitionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_documentIdDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159); match(DocumentID);
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
		enterRule(_localctx, 26, RULE_emptyAttribute);
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
		enterRule(_localctx, 28, RULE_specialAttribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163); match(SpecialAttribute);
			setState(165); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(164); attributeModifierAssignment();
				}
				}
				setState(167); 
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
		enterRule(_localctx, 30, RULE_attributeSubtype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169); attributeName();
			setState(170); match(Dot);
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
		enterRule(_localctx, 32, RULE_subtypeAttributeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172); attributeSubtype();
			setState(173); attributeName();
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Or) {
				{
				{
				setState(174); match(Or);
				setState(175); attributeSubtype();
				setState(176); attributeName();
				}
				}
				setState(182);
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
		public TerminalNode Identifier() { return getToken(ImpexParser.Identifier, 0); }
		public MacrorefContext macroref() {
			return getRuleContext(MacrorefContext.class,0);
		}
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
		enterRule(_localctx, 34, RULE_attributeName);
		try {
			setState(185);
			switch (_input.LA(1)) {
			case Macroref:
				enterOuterAlt(_localctx, 1);
				{
				setState(183); macroref();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(184); match(Identifier);
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
		enterRule(_localctx, 36, RULE_simpleAttributeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187); attributeName();
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
		enterRule(_localctx, 38, RULE_subtypeAttribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189); simpleAttributeName();
			setState(190); match(LParenthesis);
			setState(191); subtypeAttributeName();
			setState(192); match(RParenthesis);
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Macroref) | (1L << BooleanAttributeModifier) | (1L << IntAttributeModifier) | (1L << DateFormatAttributeModifier) | (1L << NumberFormatAttributeModifier) | (1L << ClassAttributeModifier) | (1L << TextAttributeModifier) | (1L << UnknownModifier))) != 0)) {
				{
				{
				setState(193); attributeModifierAssignment();
				}
				}
				setState(198);
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
		enterRule(_localctx, 40, RULE_simpleAttribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199); simpleAttributeName();
			setState(211);
			_la = _input.LA(1);
			if (_la==LParenthesis) {
				{
				setState(200); match(LParenthesis);
				setState(201); simpleAttribute();
				setState(206);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(202); match(Comma);
					setState(203); simpleAttribute();
					}
					}
					setState(208);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(209); match(RParenthesis);
				}
			}

			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Macroref) | (1L << BooleanAttributeModifier) | (1L << IntAttributeModifier) | (1L << DateFormatAttributeModifier) | (1L << NumberFormatAttributeModifier) | (1L << ClassAttributeModifier) | (1L << TextAttributeModifier) | (1L << UnknownModifier))) != 0)) {
				{
				{
				setState(213); attributeModifierAssignment();
				}
				}
				setState(218);
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
		enterRule(_localctx, 42, RULE_attributeModifierAssignment);
		int _la;
		try {
			setState(231);
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
				setState(219); attributeModifier();
				setState(220); match(Equals);
				setState(222);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(221); modifierValue();
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
				setState(224); unknownModifier();
				setState(226);
				_la = _input.LA(1);
				if (_la==Equals) {
					{
					setState(225); match(Equals);
					}
				}

				setState(229);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(228); modifierValue();
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
		enterRule(_localctx, 44, RULE_attributeModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
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
		public List<TerminalNode> UnknownModifier() { return getTokens(ImpexParser.UnknownModifier); }
		public MacrorefContext macroref(int i) {
			return getRuleContext(MacrorefContext.class,i);
		}
		public List<MacrorefContext> macroref() {
			return getRuleContexts(MacrorefContext.class);
		}
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
		enterRule(_localctx, 46, RULE_unknownModifier);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(237); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(237);
					switch (_input.LA(1)) {
					case UnknownModifier:
						{
						setState(235); match(UnknownModifier);
						}
						break;
					case Macroref:
						{
						setState(236); macroref();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(239); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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
		public MacrorefContext macroref(int i) {
			return getRuleContext(MacrorefContext.class,i);
		}
		public List<TerminalNode> Modifierval() { return getTokens(ImpexParser.Modifierval); }
		public List<MacrorefContext> macroref() {
			return getRuleContexts(MacrorefContext.class);
		}
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
		enterRule(_localctx, 48, RULE_modifierValue);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(243); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(243);
					switch (_input.LA(1)) {
					case Modifierval:
						{
						setState(241); match(Modifierval);
						}
						break;
					case Macroref:
						{
						setState(242); macroref();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(245); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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
		public MacrorefContext macroref() {
			return getRuleContext(MacrorefContext.class,0);
		}
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
		enterRule(_localctx, 50, RULE_headerTypeName);
		try {
			setState(249);
			switch (_input.LA(1)) {
			case Type:
				enterOuterAlt(_localctx, 1);
				{
				setState(247); match(Type);
				}
				break;
			case Macroref:
				enterOuterAlt(_localctx, 2);
				{
				setState(248); macroref();
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
		enterRule(_localctx, 52, RULE_macro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(251); match(Macrodef);
			setState(252); match(Equals);
			setState(253); macroValue();
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
		public MacrorefContext macroref(int i) {
			return getRuleContext(MacrorefContext.class,i);
		}
		public List<MacrorefContext> macroref() {
			return getRuleContexts(MacrorefContext.class);
		}
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
		enterRule(_localctx, 54, RULE_macroValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Macroref || _la==Macroval) {
				{
				setState(257);
				switch (_input.LA(1)) {
				case Macroval:
					{
					setState(255); match(Macroval);
					}
					break;
				case Macroref:
					{
					setState(256); macroref();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(261);
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

	public static class MacrorefContext extends ParserRuleContext {
		public TerminalNode Macroref() { return getToken(ImpexParser.Macroref, 0); }
		public MacrorefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macroref; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterMacroref(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitMacroref(this);
		}
	}

	public final MacrorefContext macroref() throws RecognitionException {
		MacrorefContext _localctx = new MacrorefContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_macroref);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(262); match(Macroref);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\62\u010b\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\2\3\2\7\2"+
		"A\n\2\f\2\16\2D\13\2\3\2\3\2\7\2H\n\2\f\2\16\2K\13\2\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\3\3\7\3T\n\3\f\3\16\3W\13\3\3\4\3\4\3\4\7\4\\\n\4\f\4\16\4_\13"+
		"\4\3\4\3\4\7\4c\n\4\f\4\16\4f\13\4\3\4\5\4i\n\4\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\b\5\bt\n\b\3\b\3\b\6\bx\n\b\r\b\16\by\3\b\5\b}\n\b\3\t\3"+
		"\t\3\t\3\t\3\t\7\t\u0084\n\t\f\t\16\t\u0087\13\t\3\t\5\t\u008a\n\t\3\n"+
		"\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0096\n\f\3\r\3\r\3\r\3\r\3"+
		"\r\7\r\u009d\n\r\f\r\16\r\u00a0\13\r\3\16\3\16\3\17\3\17\3\20\3\20\6\20"+
		"\u00a8\n\20\r\20\16\20\u00a9\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\7\22\u00b5\n\22\f\22\16\22\u00b8\13\22\3\23\3\23\5\23\u00bc\n\23\3"+
		"\24\3\24\3\25\3\25\3\25\3\25\3\25\7\25\u00c5\n\25\f\25\16\25\u00c8\13"+
		"\25\3\26\3\26\3\26\3\26\3\26\7\26\u00cf\n\26\f\26\16\26\u00d2\13\26\3"+
		"\26\3\26\5\26\u00d6\n\26\3\26\7\26\u00d9\n\26\f\26\16\26\u00dc\13\26\3"+
		"\27\3\27\3\27\5\27\u00e1\n\27\3\27\3\27\5\27\u00e5\n\27\3\27\5\27\u00e8"+
		"\n\27\5\27\u00ea\n\27\3\30\3\30\3\31\3\31\6\31\u00f0\n\31\r\31\16\31\u00f1"+
		"\3\32\3\32\6\32\u00f6\n\32\r\32\16\32\u00f7\3\33\3\33\5\33\u00fc\n\33"+
		"\3\34\3\34\3\34\3\34\3\35\3\35\7\35\u0104\n\35\f\35\16\35\u0107\13\35"+
		"\3\36\3\36\3\36\2\2\37\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,"+
		".\60\62\64\668:\2\5\3\2\24\25\3\2\16\20\3\2\b\r\u011b\2B\3\2\2\2\4N\3"+
		"\2\2\2\6X\3\2\2\2\bj\3\2\2\2\nl\3\2\2\2\fp\3\2\2\2\16s\3\2\2\2\20\u0089"+
		"\3\2\2\2\22\u008b\3\2\2\2\24\u008d\3\2\2\2\26\u0095\3\2\2\2\30\u0097\3"+
		"\2\2\2\32\u00a1\3\2\2\2\34\u00a3\3\2\2\2\36\u00a5\3\2\2\2 \u00ab\3\2\2"+
		"\2\"\u00ae\3\2\2\2$\u00bb\3\2\2\2&\u00bd\3\2\2\2(\u00bf\3\2\2\2*\u00c9"+
		"\3\2\2\2,\u00e9\3\2\2\2.\u00eb\3\2\2\2\60\u00ef\3\2\2\2\62\u00f5\3\2\2"+
		"\2\64\u00fb\3\2\2\2\66\u00fd\3\2\2\28\u0105\3\2\2\2:\u0108\3\2\2\2<A\7"+
		"\37\2\2=A\7 \2\2>A\7!\2\2?A\5\66\34\2@<\3\2\2\2@=\3\2\2\2@>\3\2\2\2@?"+
		"\3\2\2\2AD\3\2\2\2B@\3\2\2\2BC\3\2\2\2CI\3\2\2\2DB\3\2\2\2EH\5\4\3\2F"+
		"H\7\37\2\2GE\3\2\2\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JL\3\2\2\2"+
		"KI\3\2\2\2LM\7\2\2\3M\3\3\2\2\2NU\5\6\4\2OT\7 \2\2PT\7!\2\2QT\5\66\34"+
		"\2RT\5\16\b\2SO\3\2\2\2SP\3\2\2\2SQ\3\2\2\2SR\3\2\2\2TW\3\2\2\2US\3\2"+
		"\2\2UV\3\2\2\2V\5\3\2\2\2WU\3\2\2\2XY\7\3\2\2Y]\5\64\33\2Z\\\5\n\6\2["+
		"Z\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^d\3\2\2\2_]\3\2\2\2`a\7\5\2\2"+
		"ac\5\26\f\2b`\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2\2\2eh\3\2\2\2fd\3\2\2"+
		"\2gi\7\"\2\2hg\3\2\2\2hi\3\2\2\2i\7\3\2\2\2jk\t\2\2\2k\t\3\2\2\2lm\5\f"+
		"\7\2mn\7\30\2\2no\5\62\32\2o\13\3\2\2\2pq\t\3\2\2q\r\3\2\2\2rt\7\4\2\2"+
		"sr\3\2\2\2st\3\2\2\2tw\3\2\2\2uv\7\5\2\2vx\5\20\t\2wu\3\2\2\2xy\3\2\2"+
		"\2yw\3\2\2\2yz\3\2\2\2z|\3\2\2\2{}\7\"\2\2|{\3\2\2\2|}\3\2\2\2}\17\3\2"+
		"\2\2~\u0084\7%\2\2\177\u0084\7+\2\2\u0080\u0084\5:\36\2\u0081\u0084\7"+
		"\7\2\2\u0082\u0084\5\24\13\2\u0083~\3\2\2\2\u0083\177\3\2\2\2\u0083\u0080"+
		"\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0082\3\2\2\2\u0084\u0087\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u008a\3\2\2\2\u0087\u0085\3\2"+
		"\2\2\u0088\u008a\5\22\n\2\u0089\u0085\3\2\2\2\u0089\u0088\3\2\2\2\u008a"+
		"\21\3\2\2\2\u008b\u008c\7\'\2\2\u008c\23\3\2\2\2\u008d\u008e\7(\2\2\u008e"+
		"\25\3\2\2\2\u008f\u0096\5\36\20\2\u0090\u0096\5(\25\2\u0091\u0096\5\30"+
		"\r\2\u0092\u0096\5\32\16\2\u0093\u0096\5*\26\2\u0094\u0096\5\34\17\2\u0095"+
		"\u008f\3\2\2\2\u0095\u0090\3\2\2\2\u0095\u0091\3\2\2\2\u0095\u0092\3\2"+
		"\2\2\u0095\u0093\3\2\2\2\u0095\u0094\3\2\2\2\u0096\27\3\2\2\2\u0097\u0098"+
		"\5&\24\2\u0098\u0099\7\26\2\2\u0099\u009a\7\33\2\2\u009a\u009e\7\27\2"+
		"\2\u009b\u009d\5,\27\2\u009c\u009b\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c"+
		"\3\2\2\2\u009e\u009f\3\2\2\2\u009f\31\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1"+
		"\u00a2\7\33\2\2\u00a2\33\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\35\3\2\2\2"+
		"\u00a5\u00a7\7\34\2\2\u00a6\u00a8\5,\27\2\u00a7\u00a6\3\2\2\2\u00a8\u00a9"+
		"\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\37\3\2\2\2\u00ab"+
		"\u00ac\5$\23\2\u00ac\u00ad\7\23\2\2\u00ad!\3\2\2\2\u00ae\u00af\5 \21\2"+
		"\u00af\u00b6\5$\23\2\u00b0\u00b1\7\31\2\2\u00b1\u00b2\5 \21\2\u00b2\u00b3"+
		"\5$\23\2\u00b3\u00b5\3\2\2\2\u00b4\u00b0\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6"+
		"\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7#\3\2\2\2\u00b8\u00b6\3\2\2\2"+
		"\u00b9\u00bc\5:\36\2\u00ba\u00bc\7\35\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00ba"+
		"\3\2\2\2\u00bc%\3\2\2\2\u00bd\u00be\5$\23\2\u00be\'\3\2\2\2\u00bf\u00c0"+
		"\5&\24\2\u00c0\u00c1\7\26\2\2\u00c1\u00c2\5\"\22\2\u00c2\u00c6\7\27\2"+
		"\2\u00c3\u00c5\5,\27\2\u00c4\u00c3\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4"+
		"\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7)\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9"+
		"\u00d5\5&\24\2\u00ca\u00cb\7\26\2\2\u00cb\u00d0\5*\26\2\u00cc\u00cd\7"+
		"\22\2\2\u00cd\u00cf\5*\26\2\u00ce\u00cc\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0"+
		"\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1\u00d3\3\2\2\2\u00d2\u00d0\3\2"+
		"\2\2\u00d3\u00d4\7\27\2\2\u00d4\u00d6\3\2\2\2\u00d5\u00ca\3\2\2\2\u00d5"+
		"\u00d6\3\2\2\2\u00d6\u00da\3\2\2\2\u00d7\u00d9\5,\27\2\u00d8\u00d7\3\2"+
		"\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db"+
		"+\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00de\5.\30\2\u00de\u00e0\7\30\2\2"+
		"\u00df\u00e1\5\62\32\2\u00e0\u00df\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00ea"+
		"\3\2\2\2\u00e2\u00e4\5\60\31\2\u00e3\u00e5\7\30\2\2\u00e4\u00e3\3\2\2"+
		"\2\u00e4\u00e5\3\2\2\2\u00e5\u00e7\3\2\2\2\u00e6\u00e8\5\62\32\2\u00e7"+
		"\u00e6\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00ea\3\2\2\2\u00e9\u00dd\3\2"+
		"\2\2\u00e9\u00e2\3\2\2\2\u00ea-\3\2\2\2\u00eb\u00ec\t\4\2\2\u00ec/\3\2"+
		"\2\2\u00ed\u00f0\7\21\2\2\u00ee\u00f0\5:\36\2\u00ef\u00ed\3\2\2\2\u00ef"+
		"\u00ee\3\2\2\2\u00f0\u00f1\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2"+
		"\2\2\u00f2\61\3\2\2\2\u00f3\u00f6\7\62\2\2\u00f4\u00f6\5:\36\2\u00f5\u00f3"+
		"\3\2\2\2\u00f5\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f7"+
		"\u00f8\3\2\2\2\u00f8\63\3\2\2\2\u00f9\u00fc\7\4\2\2\u00fa\u00fc\5:\36"+
		"\2\u00fb\u00f9\3\2\2\2\u00fb\u00fa\3\2\2\2\u00fc\65\3\2\2\2\u00fd\u00fe"+
		"\7\36\2\2\u00fe\u00ff\7\30\2\2\u00ff\u0100\58\35\2\u0100\67\3\2\2\2\u0101"+
		"\u0104\7,\2\2\u0102\u0104\5:\36\2\u0103\u0101\3\2\2\2\u0103\u0102\3\2"+
		"\2\2\u0104\u0107\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106"+
		"9\3\2\2\2\u0107\u0105\3\2\2\2\u0108\u0109\7\6\2\2\u0109;\3\2\2\2%@BGI"+
		"SU]dhsy|\u0083\u0085\u0089\u0095\u009e\u00a9\u00b6\u00bb\u00c6\u00d0\u00d5"+
		"\u00da\u00e0\u00e4\u00e7\u00e9\u00ef\u00f1\u00f5\u00f7\u00fb\u0103\u0105";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}