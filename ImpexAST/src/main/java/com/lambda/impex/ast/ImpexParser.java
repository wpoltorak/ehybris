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
		FieldQuoted=37, Field=40, IntAttributeModifier=9, DocumentIdField=6, UserRights=31, 
		UnknownModifier=17, Ws=35, Type=2, ADocumentID=44, ClassHeaderModifier=15, 
		ModifierBracket=45, BooleanAttributeModifier=8, NumberFormatAttributeModifier=11, 
		Quote=21, LParenthesis=22, Lb=34, Identifier=29, LineSeparator=26, Separator=3, 
		RParenthesis=23, DocumentID=27, TextAttributeModifier=13, ModifiervalBracket=46, 
		BooleanHeaderModifier=14, Macroref=4, TextHeaderModifier=16, SpecialAttribute=28, 
		Comment=33, ClassAttributeModifier=12, Macrodef=30, Mode=1, DoubleQuote=20, 
		Error=36, Dot=19, Modifierval=47, ABracket=43, DateFormatAttributeModifier=10, 
		FieldMulti=39, DocumentIdRefField=7, Macroval=41, LBracket=42, Or=25, 
		BeanShell=32, Comma=18, Equals=24, FieldLb=38, SkippedField=5;
	public static final String[] tokenNames = {
		"<INVALID>", "Mode", "Type", "';'", "Macroref", "SkippedField", "DocumentIdField", 
		"DocumentIdRefField", "BooleanAttributeModifier", "IntAttributeModifier", 
		"DateFormatAttributeModifier", "NumberFormatAttributeModifier", "ClassAttributeModifier", 
		"TextAttributeModifier", "BooleanHeaderModifier", "ClassHeaderModifier", 
		"TextHeaderModifier", "UnknownModifier", "','", "'.'", "'\"'", "'''", 
		"'('", "')'", "'='", "'|'", "LineSeparator", "DocumentID", "SpecialAttribute", 
		"Identifier", "Macrodef", "UserRights", "BeanShell", "Comment", "Lb", 
		"Ws", "Error", "FieldQuoted", "FieldLb", "FieldMulti", "Field", "Macroval", 
		"LBracket", "ABracket", "ADocumentID", "']'", "ModifiervalBracket", "Modifierval"
	};
	public static final int
		RULE_impex = 0, RULE_block = 1, RULE_header = 2, RULE_quote = 3, RULE_headerModifierAssignment = 4, 
		RULE_headerModifier = 5, RULE_record = 6, RULE_field = 7, RULE_attribute = 8, 
		RULE_documentIdReference = 9, RULE_documentIdDefinition = 10, RULE_emptyAttribute = 11, 
		RULE_specialAttribute = 12, RULE_attributeSubtype = 13, RULE_subtypeAttributeName = 14, 
		RULE_attributeName = 15, RULE_simpleAttributeName = 16, RULE_subtypeAttribute = 17, 
		RULE_simpleAttribute = 18, RULE_attributeModifierAssignment = 19, RULE_attributeModifier = 20, 
		RULE_unknownModifier = 21, RULE_modifierValue = 22, RULE_headerTypeName = 23, 
		RULE_macro = 24, RULE_macroValue = 25;
	public static final String[] ruleNames = {
		"impex", "block", "header", "quote", "headerModifierAssignment", "headerModifier", 
		"record", "field", "attribute", "documentIdReference", "documentIdDefinition", 
		"emptyAttribute", "specialAttribute", "attributeSubtype", "subtypeAttributeName", 
		"attributeName", "simpleAttributeName", "subtypeAttribute", "simpleAttribute", 
		"attributeModifierAssignment", "attributeModifier", "unknownModifier", 
		"modifierValue", "headerTypeName", "macro", "macroValue"
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
			setState(58);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(56);
					switch (_input.LA(1)) {
					case UserRights:
						{
						setState(52); match(UserRights);
						}
						break;
					case BeanShell:
						{
						setState(53); match(BeanShell);
						}
						break;
					case Comment:
						{
						setState(54); match(Comment);
						}
						break;
					case Macrodef:
						{
						setState(55); macro();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(60);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(65);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Mode || _la==UserRights) {
				{
				setState(63);
				switch (_input.LA(1)) {
				case Mode:
					{
					setState(61); block();
					}
					break;
				case UserRights:
					{
					setState(62); match(UserRights);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(68); match(EOF);
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
			setState(70); header();
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Type) | (1L << Separator) | (1L << Macrodef) | (1L << BeanShell) | (1L << Comment))) != 0)) {
				{
				setState(75);
				switch (_input.LA(1)) {
				case BeanShell:
					{
					setState(71); match(BeanShell);
					}
					break;
				case Comment:
					{
					setState(72); match(Comment);
					}
					break;
				case Macrodef:
					{
					setState(73); macro();
					}
					break;
				case Type:
				case Separator:
					{
					setState(74); record();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(79);
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
			setState(80); match(Mode);
			setState(81); headerTypeName();
			setState(85);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BooleanHeaderModifier) | (1L << ClassHeaderModifier) | (1L << TextHeaderModifier))) != 0)) {
				{
				{
				setState(82); headerModifierAssignment();
				}
				}
				setState(87);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(92);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(88); match(Separator);
					setState(89); attribute();
					}
					} 
				}
				setState(94);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(96);
			_la = _input.LA(1);
			if (_la==Lb) {
				{
				setState(95); match(Lb);
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
			setState(98);
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
			setState(100); headerModifier();
			setState(101); match(Equals);
			setState(102); modifierValue();
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
			setState(104);
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
			setState(107);
			_la = _input.LA(1);
			if (_la==Type) {
				{
				setState(106); match(Type);
				}
			}

			setState(111); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(109); match(Separator);
					setState(110); field();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(113); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(116);
			_la = _input.LA(1);
			if (_la==Lb) {
				{
				setState(115); match(Lb);
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
		public TerminalNode DocumentIdRefField() { return getToken(ImpexParser.DocumentIdRefField, 0); }
		public TerminalNode SkippedField(int i) {
			return getToken(ImpexParser.SkippedField, i);
		}
		public TerminalNode Macroref(int i) {
			return getToken(ImpexParser.Macroref, i);
		}
		public List<TerminalNode> Macroref() { return getTokens(ImpexParser.Macroref); }
		public List<TerminalNode> FieldQuoted() { return getTokens(ImpexParser.FieldQuoted); }
		public TerminalNode Field(int i) {
			return getToken(ImpexParser.Field, i);
		}
		public List<TerminalNode> Field() { return getTokens(ImpexParser.Field); }
		public List<TerminalNode> SkippedField() { return getTokens(ImpexParser.SkippedField); }
		public TerminalNode FieldQuoted(int i) {
			return getToken(ImpexParser.FieldQuoted, i);
		}
		public TerminalNode DocumentIdField() { return getToken(ImpexParser.DocumentIdField, 0); }
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
			setState(126);
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
			case Field:
				{
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Macroref) | (1L << SkippedField) | (1L << FieldQuoted) | (1L << Field))) != 0)) {
					{
					{
					setState(118);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Macroref) | (1L << SkippedField) | (1L << FieldQuoted) | (1L << Field))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					}
					setState(123);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case DocumentIdField:
				{
				setState(124); match(DocumentIdField);
				}
				break;
			case DocumentIdRefField:
				{
				setState(125); match(DocumentIdRefField);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		enterRule(_localctx, 16, RULE_attribute);
		try {
			setState(134);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(128); specialAttribute();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(129); subtypeAttribute();
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(130); documentIdReference();
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(131); documentIdDefinition();
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(132); simpleAttribute();
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(133); emptyAttribute();
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
		enterRule(_localctx, 18, RULE_documentIdReference);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136); simpleAttributeName();
			setState(137); match(LParenthesis);
			setState(138); match(DocumentID);
			setState(139); match(RParenthesis);
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Macroref) | (1L << BooleanAttributeModifier) | (1L << IntAttributeModifier) | (1L << DateFormatAttributeModifier) | (1L << NumberFormatAttributeModifier) | (1L << ClassAttributeModifier) | (1L << TextAttributeModifier) | (1L << UnknownModifier))) != 0)) {
				{
				{
				setState(140); attributeModifierAssignment();
				}
				}
				setState(145);
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
		enterRule(_localctx, 20, RULE_documentIdDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146); match(DocumentID);
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
		enterRule(_localctx, 22, RULE_emptyAttribute);
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
		enterRule(_localctx, 24, RULE_specialAttribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150); match(SpecialAttribute);
			setState(152); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(151); attributeModifierAssignment();
				}
				}
				setState(154); 
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
		enterRule(_localctx, 26, RULE_attributeSubtype);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156); attributeName();
			setState(157); match(Dot);
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
		enterRule(_localctx, 28, RULE_subtypeAttributeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159); attributeSubtype();
			setState(160); attributeName();
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Or) {
				{
				{
				setState(161); match(Or);
				setState(162); attributeSubtype();
				setState(163); attributeName();
				}
				}
				setState(169);
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
		enterRule(_localctx, 30, RULE_attributeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
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
		enterRule(_localctx, 32, RULE_simpleAttributeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172); attributeName();
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
		enterRule(_localctx, 34, RULE_subtypeAttribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174); simpleAttributeName();
			setState(175); match(LParenthesis);
			setState(176); subtypeAttributeName();
			setState(177); match(RParenthesis);
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Macroref) | (1L << BooleanAttributeModifier) | (1L << IntAttributeModifier) | (1L << DateFormatAttributeModifier) | (1L << NumberFormatAttributeModifier) | (1L << ClassAttributeModifier) | (1L << TextAttributeModifier) | (1L << UnknownModifier))) != 0)) {
				{
				{
				setState(178); attributeModifierAssignment();
				}
				}
				setState(183);
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
		enterRule(_localctx, 36, RULE_simpleAttribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184); simpleAttributeName();
			setState(196);
			_la = _input.LA(1);
			if (_la==LParenthesis) {
				{
				setState(185); match(LParenthesis);
				setState(186); simpleAttribute();
				setState(191);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(187); match(Comma);
					setState(188); simpleAttribute();
					}
					}
					setState(193);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(194); match(RParenthesis);
				}
			}

			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Macroref) | (1L << BooleanAttributeModifier) | (1L << IntAttributeModifier) | (1L << DateFormatAttributeModifier) | (1L << NumberFormatAttributeModifier) | (1L << ClassAttributeModifier) | (1L << TextAttributeModifier) | (1L << UnknownModifier))) != 0)) {
				{
				{
				setState(198); attributeModifierAssignment();
				}
				}
				setState(203);
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
		enterRule(_localctx, 38, RULE_attributeModifierAssignment);
		int _la;
		try {
			setState(216);
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
				setState(204); attributeModifier();
				setState(205); match(Equals);
				setState(207);
				switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
				case 1:
					{
					setState(206); modifierValue();
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
				setState(209); unknownModifier();
				setState(211);
				_la = _input.LA(1);
				if (_la==Equals) {
					{
					setState(210); match(Equals);
					}
				}

				setState(214);
				switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
				case 1:
					{
					setState(213); modifierValue();
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
		enterRule(_localctx, 40, RULE_attributeModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
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
		enterRule(_localctx, 42, RULE_unknownModifier);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(221); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(220);
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
				setState(223); 
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
		enterRule(_localctx, 44, RULE_modifierValue);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(226); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(225);
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
				setState(228); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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
		enterRule(_localctx, 46, RULE_headerTypeName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
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
		enterRule(_localctx, 48, RULE_macro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232); match(Macrodef);
			setState(233); match(Equals);
			setState(234); macroValue();
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
		enterRule(_localctx, 50, RULE_macroValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Macroref || _la==Macroval) {
				{
				{
				setState(236);
				_la = _input.LA(1);
				if ( !(_la==Macroref || _la==Macroval) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(241);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\61\u00f5\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\2\7\2;\n\2\f\2\16\2>\13\2\3\2\3\2\7"+
		"\2B\n\2\f\2\16\2E\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\7\3N\n\3\f\3\16\3Q"+
		"\13\3\3\4\3\4\3\4\7\4V\n\4\f\4\16\4Y\13\4\3\4\3\4\7\4]\n\4\f\4\16\4`\13"+
		"\4\3\4\5\4c\n\4\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\5\bn\n\b\3\b\3\b\6"+
		"\br\n\b\r\b\16\bs\3\b\5\bw\n\b\3\t\7\tz\n\t\f\t\16\t}\13\t\3\t\3\t\5\t"+
		"\u0081\n\t\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u0089\n\n\3\13\3\13\3\13\3\13\3"+
		"\13\7\13\u0090\n\13\f\13\16\13\u0093\13\13\3\f\3\f\3\r\3\r\3\16\3\16\6"+
		"\16\u009b\n\16\r\16\16\16\u009c\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\7\20\u00a8\n\20\f\20\16\20\u00ab\13\20\3\21\3\21\3\22\3\22\3\23"+
		"\3\23\3\23\3\23\3\23\7\23\u00b6\n\23\f\23\16\23\u00b9\13\23\3\24\3\24"+
		"\3\24\3\24\3\24\7\24\u00c0\n\24\f\24\16\24\u00c3\13\24\3\24\3\24\5\24"+
		"\u00c7\n\24\3\24\7\24\u00ca\n\24\f\24\16\24\u00cd\13\24\3\25\3\25\3\25"+
		"\5\25\u00d2\n\25\3\25\3\25\5\25\u00d6\n\25\3\25\5\25\u00d9\n\25\5\25\u00db"+
		"\n\25\3\26\3\26\3\27\6\27\u00e0\n\27\r\27\16\27\u00e1\3\30\6\30\u00e5"+
		"\n\30\r\30\16\30\u00e6\3\31\3\31\3\32\3\32\3\32\3\32\3\33\7\33\u00f0\n"+
		"\33\f\33\16\33\u00f3\13\33\3\33\2\2\34\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"$&(*,.\60\62\64\2\13\3\2\26\27\3\2\20\22\5\2\6\7\'\'**\4\2\6"+
		"\6\37\37\3\2\n\17\4\2\6\6\23\23\4\2\6\6\61\61\4\2\4\4\6\6\4\2\6\6++\u0100"+
		"\2<\3\2\2\2\4H\3\2\2\2\6R\3\2\2\2\bd\3\2\2\2\nf\3\2\2\2\fj\3\2\2\2\16"+
		"m\3\2\2\2\20\u0080\3\2\2\2\22\u0088\3\2\2\2\24\u008a\3\2\2\2\26\u0094"+
		"\3\2\2\2\30\u0096\3\2\2\2\32\u0098\3\2\2\2\34\u009e\3\2\2\2\36\u00a1\3"+
		"\2\2\2 \u00ac\3\2\2\2\"\u00ae\3\2\2\2$\u00b0\3\2\2\2&\u00ba\3\2\2\2(\u00da"+
		"\3\2\2\2*\u00dc\3\2\2\2,\u00df\3\2\2\2.\u00e4\3\2\2\2\60\u00e8\3\2\2\2"+
		"\62\u00ea\3\2\2\2\64\u00f1\3\2\2\2\66;\7!\2\2\67;\7\"\2\28;\7#\2\29;\5"+
		"\62\32\2:\66\3\2\2\2:\67\3\2\2\2:8\3\2\2\2:9\3\2\2\2;>\3\2\2\2<:\3\2\2"+
		"\2<=\3\2\2\2=C\3\2\2\2><\3\2\2\2?B\5\4\3\2@B\7!\2\2A?\3\2\2\2A@\3\2\2"+
		"\2BE\3\2\2\2CA\3\2\2\2CD\3\2\2\2DF\3\2\2\2EC\3\2\2\2FG\7\2\2\3G\3\3\2"+
		"\2\2HO\5\6\4\2IN\7\"\2\2JN\7#\2\2KN\5\62\32\2LN\5\16\b\2MI\3\2\2\2MJ\3"+
		"\2\2\2MK\3\2\2\2ML\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2P\5\3\2\2\2QO"+
		"\3\2\2\2RS\7\3\2\2SW\5\60\31\2TV\5\n\6\2UT\3\2\2\2VY\3\2\2\2WU\3\2\2\2"+
		"WX\3\2\2\2X^\3\2\2\2YW\3\2\2\2Z[\7\5\2\2[]\5\22\n\2\\Z\3\2\2\2]`\3\2\2"+
		"\2^\\\3\2\2\2^_\3\2\2\2_b\3\2\2\2`^\3\2\2\2ac\7$\2\2ba\3\2\2\2bc\3\2\2"+
		"\2c\7\3\2\2\2de\t\2\2\2e\t\3\2\2\2fg\5\f\7\2gh\7\32\2\2hi\5.\30\2i\13"+
		"\3\2\2\2jk\t\3\2\2k\r\3\2\2\2ln\7\4\2\2ml\3\2\2\2mn\3\2\2\2nq\3\2\2\2"+
		"op\7\5\2\2pr\5\20\t\2qo\3\2\2\2rs\3\2\2\2sq\3\2\2\2st\3\2\2\2tv\3\2\2"+
		"\2uw\7$\2\2vu\3\2\2\2vw\3\2\2\2w\17\3\2\2\2xz\t\4\2\2yx\3\2\2\2z}\3\2"+
		"\2\2{y\3\2\2\2{|\3\2\2\2|\u0081\3\2\2\2}{\3\2\2\2~\u0081\7\b\2\2\177\u0081"+
		"\7\t\2\2\u0080{\3\2\2\2\u0080~\3\2\2\2\u0080\177\3\2\2\2\u0081\21\3\2"+
		"\2\2\u0082\u0089\5\32\16\2\u0083\u0089\5$\23\2\u0084\u0089\5\24\13\2\u0085"+
		"\u0089\5\26\f\2\u0086\u0089\5&\24\2\u0087\u0089\5\30\r\2\u0088\u0082\3"+
		"\2\2\2\u0088\u0083\3\2\2\2\u0088\u0084\3\2\2\2\u0088\u0085\3\2\2\2\u0088"+
		"\u0086\3\2\2\2\u0088\u0087\3\2\2\2\u0089\23\3\2\2\2\u008a\u008b\5\"\22"+
		"\2\u008b\u008c\7\30\2\2\u008c\u008d\7\35\2\2\u008d\u0091\7\31\2\2\u008e"+
		"\u0090\5(\25\2\u008f\u008e\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2"+
		"\2\2\u0091\u0092\3\2\2\2\u0092\25\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0095"+
		"\7\35\2\2\u0095\27\3\2\2\2\u0096\u0097\3\2\2\2\u0097\31\3\2\2\2\u0098"+
		"\u009a\7\36\2\2\u0099\u009b\5(\25\2\u009a\u0099\3\2\2\2\u009b\u009c\3"+
		"\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\33\3\2\2\2\u009e"+
		"\u009f\5 \21\2\u009f\u00a0\7\25\2\2\u00a0\35\3\2\2\2\u00a1\u00a2\5\34"+
		"\17\2\u00a2\u00a9\5 \21\2\u00a3\u00a4\7\33\2\2\u00a4\u00a5\5\34\17\2\u00a5"+
		"\u00a6\5 \21\2\u00a6\u00a8\3\2\2\2\u00a7\u00a3\3\2\2\2\u00a8\u00ab\3\2"+
		"\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\37\3\2\2\2\u00ab\u00a9"+
		"\3\2\2\2\u00ac\u00ad\t\5\2\2\u00ad!\3\2\2\2\u00ae\u00af\5 \21\2\u00af"+
		"#\3\2\2\2\u00b0\u00b1\5\"\22\2\u00b1\u00b2\7\30\2\2\u00b2\u00b3\5\36\20"+
		"\2\u00b3\u00b7\7\31\2\2\u00b4\u00b6\5(\25\2\u00b5\u00b4\3\2\2\2\u00b6"+
		"\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8%\3\2\2\2"+
		"\u00b9\u00b7\3\2\2\2\u00ba\u00c6\5\"\22\2\u00bb\u00bc\7\30\2\2\u00bc\u00c1"+
		"\5&\24\2\u00bd\u00be\7\24\2\2\u00be\u00c0\5&\24\2\u00bf\u00bd\3\2\2\2"+
		"\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c4"+
		"\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00c5\7\31\2\2\u00c5\u00c7\3\2\2\2"+
		"\u00c6\u00bb\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00cb\3\2\2\2\u00c8\u00ca"+
		"\5(\25\2\u00c9\u00c8\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb"+
		"\u00cc\3\2\2\2\u00cc\'\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00cf\5*\26\2"+
		"\u00cf\u00d1\7\32\2\2\u00d0\u00d2\5.\30\2\u00d1\u00d0\3\2\2\2\u00d1\u00d2"+
		"\3\2\2\2\u00d2\u00db\3\2\2\2\u00d3\u00d5\5,\27\2\u00d4\u00d6\7\32\2\2"+
		"\u00d5\u00d4\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d8\3\2\2\2\u00d7\u00d9"+
		"\5.\30\2\u00d8\u00d7\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00db\3\2\2\2\u00da"+
		"\u00ce\3\2\2\2\u00da\u00d3\3\2\2\2\u00db)\3\2\2\2\u00dc\u00dd\t\6\2\2"+
		"\u00dd+\3\2\2\2\u00de\u00e0\t\7\2\2\u00df\u00de\3\2\2\2\u00e0\u00e1\3"+
		"\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2-\3\2\2\2\u00e3\u00e5"+
		"\t\b\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e4\3\2\2\2\u00e6"+
		"\u00e7\3\2\2\2\u00e7/\3\2\2\2\u00e8\u00e9\t\t\2\2\u00e9\61\3\2\2\2\u00ea"+
		"\u00eb\7 \2\2\u00eb\u00ec\7\32\2\2\u00ec\u00ed\5\64\33\2\u00ed\63\3\2"+
		"\2\2\u00ee\u00f0\t\n\2\2\u00ef\u00ee\3\2\2\2\u00f0\u00f3\3\2\2\2\u00f1"+
		"\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2\65\3\2\2\2\u00f3\u00f1\3\2\2"+
		"\2\37:<ACMOW^bmsv{\u0080\u0088\u0091\u009c\u00a9\u00b7\u00c1\u00c6\u00cb"+
		"\u00d1\u00d5\u00d8\u00da\u00e1\u00e6\u00f1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}