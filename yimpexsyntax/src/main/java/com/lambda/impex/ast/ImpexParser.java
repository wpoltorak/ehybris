// Generated from com/lambda/impex/ast/ImpexParser.g4 by ANTLR 4.5.1
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
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Mode=1, Type=2, Separator=3, Macroref=4, SkippedField=5, BooleanAttributeModifier=6, 
		IntAttributeModifier=7, DateFormatAttributeModifier=8, NumberFormatAttributeModifier=9, 
		ClassAttributeModifier=10, TextAttributeModifier=11, BooleanHeaderModifier=12, 
		ClassHeaderModifier=13, TextHeaderModifier=14, UnknownModifier=15, Comma=16, 
		Dot=17, DoubleQuote=18, Quote=19, LParenthesis=20, RParenthesis=21, Equals=22, 
		Or=23, LineSeparator=24, DocumentID=25, SpecialAttribute=26, Identifier=27, 
		Macrodef=28, UserRights=29, BeanShell=30, Comment=31, Lb=32, Ws=33, Error=34, 
		FieldQuoted=35, FieldLb=36, DocumentIdField=37, DocumentIdRefField=38, 
		FieldCommaSkipped=39, FieldMulti=40, Field=41, Macroval=42, LBracket=43, 
		ABracket=44, ADocumentID=45, ModifierBracket=46, ModifiervalBracket=47, 
		Modifierval=48;
	public static final int
		RULE_impex = 0, RULE_block = 1, RULE_header = 2, RULE_quote = 3, RULE_headerModifierAssignment = 4, 
		RULE_headerModifier = 5, RULE_record = 6, RULE_field = 7, RULE_documentIdField = 8, 
		RULE_documentIdRefField = 9, RULE_attribute = 10, RULE_documentIdDefinition = 11, 
		RULE_documentIdReference = 12, RULE_macrorefAttribute = 13, RULE_emptyAttribute = 14, 
		RULE_specialAttribute = 15, RULE_simpleAttribute = 16, RULE_simpleAttributeName = 17, 
		RULE_subtypeAttribute = 18, RULE_subtypeAttributeName = 19, RULE_attributeModifierAssignment = 20, 
		RULE_attributeModifier = 21, RULE_unknownModifier = 22, RULE_modifierValue = 23, 
		RULE_headerTypeName = 24, RULE_macro = 25, RULE_macroValue = 26, RULE_macroref = 27;
	public static final String[] ruleNames = {
		"impex", "block", "header", "quote", "headerModifierAssignment", "headerModifier", 
		"record", "field", "documentIdField", "documentIdRefField", "attribute", 
		"documentIdDefinition", "documentIdReference", "macrorefAttribute", "emptyAttribute", 
		"specialAttribute", "simpleAttribute", "simpleAttributeName", "subtypeAttribute", 
		"subtypeAttributeName", "attributeModifierAssignment", "attributeModifier", 
		"unknownModifier", "modifierValue", "headerTypeName", "macro", "macroValue", 
		"macroref"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, "';'", null, null, null, null, null, null, null, null, 
		null, null, null, null, "','", "'.'", "'\"'", "'''", "'('", "')'", "'='", 
		"'|'", null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "']'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Mode", "Type", "Separator", "Macroref", "SkippedField", "BooleanAttributeModifier", 
		"IntAttributeModifier", "DateFormatAttributeModifier", "NumberFormatAttributeModifier", 
		"ClassAttributeModifier", "TextAttributeModifier", "BooleanHeaderModifier", 
		"ClassHeaderModifier", "TextHeaderModifier", "UnknownModifier", "Comma", 
		"Dot", "DoubleQuote", "Quote", "LParenthesis", "RParenthesis", "Equals", 
		"Or", "LineSeparator", "DocumentID", "SpecialAttribute", "Identifier", 
		"Macrodef", "UserRights", "BeanShell", "Comment", "Lb", "Ws", "Error", 
		"FieldQuoted", "FieldLb", "DocumentIdField", "DocumentIdRefField", "FieldCommaSkipped", 
		"FieldMulti", "Field", "Macroval", "LBracket", "ABracket", "ADocumentID", 
		"ModifierBracket", "ModifiervalBracket", "Modifierval"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "ImpexParser.g4"; }

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
		public List<TerminalNode> UserRights() { return getTokens(ImpexParser.UserRights); }
		public TerminalNode UserRights(int i) {
			return getToken(ImpexParser.UserRights, i);
		}
		public List<TerminalNode> BeanShell() { return getTokens(ImpexParser.BeanShell); }
		public TerminalNode BeanShell(int i) {
			return getToken(ImpexParser.BeanShell, i);
		}
		public List<TerminalNode> Comment() { return getTokens(ImpexParser.Comment); }
		public TerminalNode Comment(int i) {
			return getToken(ImpexParser.Comment, i);
		}
		public List<MacroContext> macro() {
			return getRuleContexts(MacroContext.class);
		}
		public MacroContext macro(int i) {
			return getRuleContext(MacroContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
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
			setState(62);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(60);
					switch (_input.LA(1)) {
					case UserRights:
						{
						setState(56);
						match(UserRights);
						}
						break;
					case BeanShell:
						{
						setState(57);
						match(BeanShell);
						}
						break;
					case Comment:
						{
						setState(58);
						match(Comment);
						}
						break;
					case Macrodef:
						{
						setState(59);
						macro();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(64);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Mode || _la==UserRights) {
				{
				setState(67);
				switch (_input.LA(1)) {
				case Mode:
					{
					setState(65);
					block();
					}
					break;
				case UserRights:
					{
					setState(66);
					match(UserRights);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72);
			match(EOF);
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
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public List<TerminalNode> BeanShell() { return getTokens(ImpexParser.BeanShell); }
		public TerminalNode BeanShell(int i) {
			return getToken(ImpexParser.BeanShell, i);
		}
		public List<TerminalNode> Comment() { return getTokens(ImpexParser.Comment); }
		public TerminalNode Comment(int i) {
			return getToken(ImpexParser.Comment, i);
		}
		public List<MacroContext> macro() {
			return getRuleContexts(MacroContext.class);
		}
		public MacroContext macro(int i) {
			return getRuleContext(MacroContext.class,i);
		}
		public List<RecordContext> record() {
			return getRuleContexts(RecordContext.class);
		}
		public RecordContext record(int i) {
			return getRuleContext(RecordContext.class,i);
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
			setState(74);
			header();
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Type) | (1L << Separator) | (1L << Macrodef) | (1L << BeanShell) | (1L << Comment))) != 0)) {
				{
				setState(79);
				switch (_input.LA(1)) {
				case BeanShell:
					{
					setState(75);
					match(BeanShell);
					}
					break;
				case Comment:
					{
					setState(76);
					match(Comment);
					}
					break;
				case Macrodef:
					{
					setState(77);
					macro();
					}
					break;
				case Type:
				case Separator:
					{
					setState(78);
					record();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(83);
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
		public TerminalNode Mode() { return getToken(ImpexParser.Mode, 0); }
		public HeaderTypeNameContext headerTypeName() {
			return getRuleContext(HeaderTypeNameContext.class,0);
		}
		public List<HeaderModifierAssignmentContext> headerModifierAssignment() {
			return getRuleContexts(HeaderModifierAssignmentContext.class);
		}
		public HeaderModifierAssignmentContext headerModifierAssignment(int i) {
			return getRuleContext(HeaderModifierAssignmentContext.class,i);
		}
		public List<TerminalNode> Separator() { return getTokens(ImpexParser.Separator); }
		public TerminalNode Separator(int i) {
			return getToken(ImpexParser.Separator, i);
		}
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public TerminalNode Lb() { return getToken(ImpexParser.Lb, 0); }
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
			setState(84);
			match(Mode);
			setState(85);
			headerTypeName();
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BooleanHeaderModifier) | (1L << ClassHeaderModifier) | (1L << TextHeaderModifier))) != 0)) {
				{
				{
				setState(86);
				headerModifierAssignment();
				}
				}
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(96);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(92);
					match(Separator);
					setState(93);
					attribute();
					}
					} 
				}
				setState(98);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(100);
			_la = _input.LA(1);
			if (_la==Lb) {
				{
				setState(99);
				match(Lb);
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
		public TerminalNode DoubleQuote() { return getToken(ImpexParser.DoubleQuote, 0); }
		public TerminalNode Quote() { return getToken(ImpexParser.Quote, 0); }
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
			setState(102);
			_la = _input.LA(1);
			if ( !(_la==DoubleQuote || _la==Quote) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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

	public static class HeaderModifierAssignmentContext extends ParserRuleContext {
		public HeaderModifierContext headerModifier() {
			return getRuleContext(HeaderModifierContext.class,0);
		}
		public TerminalNode Equals() { return getToken(ImpexParser.Equals, 0); }
		public ModifierValueContext modifierValue() {
			return getRuleContext(ModifierValueContext.class,0);
		}
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
			setState(104);
			headerModifier();
			setState(105);
			match(Equals);
			setState(106);
			modifierValue();
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
			setState(108);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BooleanHeaderModifier) | (1L << ClassHeaderModifier) | (1L << TextHeaderModifier))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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

	public static class RecordContext extends ParserRuleContext {
		public TerminalNode Type() { return getToken(ImpexParser.Type, 0); }
		public List<TerminalNode> Separator() { return getTokens(ImpexParser.Separator); }
		public TerminalNode Separator(int i) {
			return getToken(ImpexParser.Separator, i);
		}
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public TerminalNode Lb() { return getToken(ImpexParser.Lb, 0); }
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
			setState(111);
			_la = _input.LA(1);
			if (_la==Type) {
				{
				setState(110);
				match(Type);
				}
			}

			setState(115); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(113);
					match(Separator);
					setState(114);
					field();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(117); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(120);
			_la = _input.LA(1);
			if (_la==Lb) {
				{
				setState(119);
				match(Lb);
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
		public List<TerminalNode> FieldQuoted() { return getTokens(ImpexParser.FieldQuoted); }
		public TerminalNode FieldQuoted(int i) {
			return getToken(ImpexParser.FieldQuoted, i);
		}
		public List<TerminalNode> Field() { return getTokens(ImpexParser.Field); }
		public TerminalNode Field(int i) {
			return getToken(ImpexParser.Field, i);
		}
		public List<MacrorefContext> macroref() {
			return getRuleContexts(MacrorefContext.class);
		}
		public MacrorefContext macroref(int i) {
			return getRuleContext(MacrorefContext.class,i);
		}
		public List<TerminalNode> SkippedField() { return getTokens(ImpexParser.SkippedField); }
		public TerminalNode SkippedField(int i) {
			return getToken(ImpexParser.SkippedField, i);
		}
		public List<DocumentIdRefFieldContext> documentIdRefField() {
			return getRuleContexts(DocumentIdRefFieldContext.class);
		}
		public DocumentIdRefFieldContext documentIdRefField(int i) {
			return getRuleContext(DocumentIdRefFieldContext.class,i);
		}
		public DocumentIdFieldContext documentIdField() {
			return getRuleContext(DocumentIdFieldContext.class,0);
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
			setState(133);
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
				setState(129);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Macroref) | (1L << SkippedField) | (1L << FieldQuoted) | (1L << DocumentIdRefField) | (1L << Field))) != 0)) {
					{
					setState(127);
					switch (_input.LA(1)) {
					case FieldQuoted:
						{
						setState(122);
						match(FieldQuoted);
						}
						break;
					case Field:
						{
						setState(123);
						match(Field);
						}
						break;
					case Macroref:
						{
						setState(124);
						macroref();
						}
						break;
					case SkippedField:
						{
						setState(125);
						match(SkippedField);
						}
						break;
					case DocumentIdRefField:
						{
						setState(126);
						documentIdRefField();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(131);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case DocumentIdField:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				documentIdField();
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
			setState(135);
			match(DocumentIdField);
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
			setState(137);
			match(DocumentIdRefField);
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
		public MacrorefAttributeContext macrorefAttribute() {
			return getRuleContext(MacrorefAttributeContext.class,0);
		}
		public EmptyAttributeContext emptyAttribute() {
			return getRuleContext(EmptyAttributeContext.class,0);
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
			setState(145);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(139);
				documentIdReference();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				documentIdDefinition();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(141);
				simpleAttribute();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(142);
				specialAttribute();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(143);
				macrorefAttribute();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(144);
				emptyAttribute();
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
		enterRule(_localctx, 22, RULE_documentIdDefinition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(DocumentID);
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
		public SimpleAttributeNameContext simpleAttributeName() {
			return getRuleContext(SimpleAttributeNameContext.class,0);
		}
		public TerminalNode LParenthesis() { return getToken(ImpexParser.LParenthesis, 0); }
		public TerminalNode DocumentID() { return getToken(ImpexParser.DocumentID, 0); }
		public TerminalNode RParenthesis() { return getToken(ImpexParser.RParenthesis, 0); }
		public List<AttributeModifierAssignmentContext> attributeModifierAssignment() {
			return getRuleContexts(AttributeModifierAssignmentContext.class);
		}
		public AttributeModifierAssignmentContext attributeModifierAssignment(int i) {
			return getRuleContext(AttributeModifierAssignmentContext.class,i);
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
		enterRule(_localctx, 24, RULE_documentIdReference);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			simpleAttributeName();
			setState(150);
			match(LParenthesis);
			setState(151);
			match(DocumentID);
			setState(152);
			match(RParenthesis);
			setState(156);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Macroref) | (1L << BooleanAttributeModifier) | (1L << IntAttributeModifier) | (1L << DateFormatAttributeModifier) | (1L << NumberFormatAttributeModifier) | (1L << ClassAttributeModifier) | (1L << TextAttributeModifier) | (1L << UnknownModifier))) != 0)) {
				{
				{
				setState(153);
				attributeModifierAssignment();
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

	public static class MacrorefAttributeContext extends ParserRuleContext {
		public MacrorefContext macroref() {
			return getRuleContext(MacrorefContext.class,0);
		}
		public List<AttributeModifierAssignmentContext> attributeModifierAssignment() {
			return getRuleContexts(AttributeModifierAssignmentContext.class);
		}
		public AttributeModifierAssignmentContext attributeModifierAssignment(int i) {
			return getRuleContext(AttributeModifierAssignmentContext.class,i);
		}
		public MacrorefAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_macrorefAttribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).enterMacrorefAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpexParserListener ) ((ImpexParserListener)listener).exitMacrorefAttribute(this);
		}
	}

	public final MacrorefAttributeContext macrorefAttribute() throws RecognitionException {
		MacrorefAttributeContext _localctx = new MacrorefAttributeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_macrorefAttribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			macroref();
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Macroref) | (1L << BooleanAttributeModifier) | (1L << IntAttributeModifier) | (1L << DateFormatAttributeModifier) | (1L << NumberFormatAttributeModifier) | (1L << ClassAttributeModifier) | (1L << TextAttributeModifier) | (1L << UnknownModifier))) != 0)) {
				{
				{
				setState(160);
				attributeModifierAssignment();
				}
				}
				setState(165);
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
		enterRule(_localctx, 28, RULE_emptyAttribute);
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
		public TerminalNode SpecialAttribute() { return getToken(ImpexParser.SpecialAttribute, 0); }
		public List<AttributeModifierAssignmentContext> attributeModifierAssignment() {
			return getRuleContexts(AttributeModifierAssignmentContext.class);
		}
		public AttributeModifierAssignmentContext attributeModifierAssignment(int i) {
			return getRuleContext(AttributeModifierAssignmentContext.class,i);
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
		enterRule(_localctx, 30, RULE_specialAttribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(SpecialAttribute);
			setState(170); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(169);
				attributeModifierAssignment();
				}
				}
				setState(172); 
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

	public static class SimpleAttributeContext extends ParserRuleContext {
		public SimpleAttributeNameContext simpleAttributeName() {
			return getRuleContext(SimpleAttributeNameContext.class,0);
		}
		public TerminalNode LParenthesis() { return getToken(ImpexParser.LParenthesis, 0); }
		public List<SubtypeAttributeContext> subtypeAttribute() {
			return getRuleContexts(SubtypeAttributeContext.class);
		}
		public SubtypeAttributeContext subtypeAttribute(int i) {
			return getRuleContext(SubtypeAttributeContext.class,i);
		}
		public TerminalNode RParenthesis() { return getToken(ImpexParser.RParenthesis, 0); }
		public List<AttributeModifierAssignmentContext> attributeModifierAssignment() {
			return getRuleContexts(AttributeModifierAssignmentContext.class);
		}
		public AttributeModifierAssignmentContext attributeModifierAssignment(int i) {
			return getRuleContext(AttributeModifierAssignmentContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(ImpexParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(ImpexParser.Comma, i);
		}
		public List<TerminalNode> Or() { return getTokens(ImpexParser.Or); }
		public TerminalNode Or(int i) {
			return getToken(ImpexParser.Or, i);
		}
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
			setState(174);
			simpleAttributeName();
			setState(186);
			_la = _input.LA(1);
			if (_la==LParenthesis) {
				{
				setState(175);
				match(LParenthesis);
				setState(176);
				subtypeAttribute();
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma || _la==Or) {
					{
					{
					setState(177);
					_la = _input.LA(1);
					if ( !(_la==Comma || _la==Or) ) {
					_errHandler.recoverInline(this);
					} else {
						consume();
					}
					setState(178);
					subtypeAttribute();
					}
					}
					setState(183);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(184);
				match(RParenthesis);
				}
			}

			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Macroref) | (1L << BooleanAttributeModifier) | (1L << IntAttributeModifier) | (1L << DateFormatAttributeModifier) | (1L << NumberFormatAttributeModifier) | (1L << ClassAttributeModifier) | (1L << TextAttributeModifier) | (1L << UnknownModifier))) != 0)) {
				{
				{
				setState(188);
				attributeModifierAssignment();
				}
				}
				setState(193);
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

	public static class SimpleAttributeNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(ImpexParser.Identifier, 0); }
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
		enterRule(_localctx, 34, RULE_simpleAttributeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(Identifier);
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
		public MacrorefContext macroref() {
			return getRuleContext(MacrorefContext.class,0);
		}
		public List<AttributeModifierAssignmentContext> attributeModifierAssignment() {
			return getRuleContexts(AttributeModifierAssignmentContext.class);
		}
		public AttributeModifierAssignmentContext attributeModifierAssignment(int i) {
			return getRuleContext(AttributeModifierAssignmentContext.class,i);
		}
		public SubtypeAttributeNameContext subtypeAttributeName() {
			return getRuleContext(SubtypeAttributeNameContext.class,0);
		}
		public TerminalNode LParenthesis() { return getToken(ImpexParser.LParenthesis, 0); }
		public List<SubtypeAttributeContext> subtypeAttribute() {
			return getRuleContexts(SubtypeAttributeContext.class);
		}
		public SubtypeAttributeContext subtypeAttribute(int i) {
			return getRuleContext(SubtypeAttributeContext.class,i);
		}
		public TerminalNode RParenthesis() { return getToken(ImpexParser.RParenthesis, 0); }
		public List<TerminalNode> Comma() { return getTokens(ImpexParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(ImpexParser.Comma, i);
		}
		public List<TerminalNode> Or() { return getTokens(ImpexParser.Or); }
		public TerminalNode Or(int i) {
			return getToken(ImpexParser.Or, i);
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
		enterRule(_localctx, 36, RULE_subtypeAttribute);
		int _la;
		try {
			setState(223);
			switch (_input.LA(1)) {
			case Macroref:
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				macroref();
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Macroref) | (1L << BooleanAttributeModifier) | (1L << IntAttributeModifier) | (1L << DateFormatAttributeModifier) | (1L << NumberFormatAttributeModifier) | (1L << ClassAttributeModifier) | (1L << TextAttributeModifier) | (1L << UnknownModifier))) != 0)) {
					{
					{
					setState(197);
					attributeModifierAssignment();
					}
					}
					setState(202);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(203);
				subtypeAttributeName();
				setState(215);
				_la = _input.LA(1);
				if (_la==LParenthesis) {
					{
					setState(204);
					match(LParenthesis);
					setState(205);
					subtypeAttribute();
					setState(210);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma || _la==Or) {
						{
						{
						setState(206);
						_la = _input.LA(1);
						if ( !(_la==Comma || _la==Or) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						setState(207);
						subtypeAttribute();
						}
						}
						setState(212);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(213);
					match(RParenthesis);
					}
				}

				setState(220);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Macroref) | (1L << BooleanAttributeModifier) | (1L << IntAttributeModifier) | (1L << DateFormatAttributeModifier) | (1L << NumberFormatAttributeModifier) | (1L << ClassAttributeModifier) | (1L << TextAttributeModifier) | (1L << UnknownModifier))) != 0)) {
					{
					{
					setState(217);
					attributeModifierAssignment();
					}
					}
					setState(222);
					_errHandler.sync(this);
					_la = _input.LA(1);
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

	public static class SubtypeAttributeNameContext extends ParserRuleContext {
		public Token type;
		public Token name;
		public List<TerminalNode> Identifier() { return getTokens(ImpexParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(ImpexParser.Identifier, i);
		}
		public TerminalNode Dot() { return getToken(ImpexParser.Dot, 0); }
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
		enterRule(_localctx, 38, RULE_subtypeAttributeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(225);
				((SubtypeAttributeNameContext)_localctx).type = match(Identifier);
				setState(226);
				match(Dot);
				}
				break;
			}
			setState(229);
			((SubtypeAttributeNameContext)_localctx).name = match(Identifier);
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
		public TerminalNode Equals() { return getToken(ImpexParser.Equals, 0); }
		public ModifierValueContext modifierValue() {
			return getRuleContext(ModifierValueContext.class,0);
		}
		public UnknownModifierContext unknownModifier() {
			return getRuleContext(UnknownModifierContext.class,0);
		}
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
		enterRule(_localctx, 40, RULE_attributeModifierAssignment);
		int _la;
		try {
			setState(243);
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
				setState(231);
				attributeModifier();
				setState(232);
				match(Equals);
				setState(234);
				switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
				case 1:
					{
					setState(233);
					modifierValue();
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
				setState(236);
				unknownModifier();
				setState(238);
				_la = _input.LA(1);
				if (_la==Equals) {
					{
					setState(237);
					match(Equals);
					}
				}

				setState(241);
				switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
				case 1:
					{
					setState(240);
					modifierValue();
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
		public TerminalNode BooleanAttributeModifier() { return getToken(ImpexParser.BooleanAttributeModifier, 0); }
		public TerminalNode IntAttributeModifier() { return getToken(ImpexParser.IntAttributeModifier, 0); }
		public TerminalNode DateFormatAttributeModifier() { return getToken(ImpexParser.DateFormatAttributeModifier, 0); }
		public TerminalNode NumberFormatAttributeModifier() { return getToken(ImpexParser.NumberFormatAttributeModifier, 0); }
		public TerminalNode ClassAttributeModifier() { return getToken(ImpexParser.ClassAttributeModifier, 0); }
		public TerminalNode TextAttributeModifier() { return getToken(ImpexParser.TextAttributeModifier, 0); }
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
		enterRule(_localctx, 42, RULE_attributeModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BooleanAttributeModifier) | (1L << IntAttributeModifier) | (1L << DateFormatAttributeModifier) | (1L << NumberFormatAttributeModifier) | (1L << ClassAttributeModifier) | (1L << TextAttributeModifier))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
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

	public static class UnknownModifierContext extends ParserRuleContext {
		public List<TerminalNode> UnknownModifier() { return getTokens(ImpexParser.UnknownModifier); }
		public TerminalNode UnknownModifier(int i) {
			return getToken(ImpexParser.UnknownModifier, i);
		}
		public List<MacrorefContext> macroref() {
			return getRuleContexts(MacrorefContext.class);
		}
		public MacrorefContext macroref(int i) {
			return getRuleContext(MacrorefContext.class,i);
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
		enterRule(_localctx, 44, RULE_unknownModifier);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(249); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(249);
					switch (_input.LA(1)) {
					case UnknownModifier:
						{
						setState(247);
						match(UnknownModifier);
						}
						break;
					case Macroref:
						{
						setState(248);
						macroref();
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
				setState(251); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
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
		public List<TerminalNode> Modifierval() { return getTokens(ImpexParser.Modifierval); }
		public TerminalNode Modifierval(int i) {
			return getToken(ImpexParser.Modifierval, i);
		}
		public List<MacrorefContext> macroref() {
			return getRuleContexts(MacrorefContext.class);
		}
		public MacrorefContext macroref(int i) {
			return getRuleContext(MacrorefContext.class,i);
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
		enterRule(_localctx, 46, RULE_modifierValue);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(255); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(255);
					switch (_input.LA(1)) {
					case Modifierval:
						{
						setState(253);
						match(Modifierval);
						}
						break;
					case Macroref:
						{
						setState(254);
						macroref();
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
				setState(257); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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
		public TerminalNode Type() { return getToken(ImpexParser.Type, 0); }
		public MacrorefContext macroref() {
			return getRuleContext(MacrorefContext.class,0);
		}
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
		enterRule(_localctx, 48, RULE_headerTypeName);
		try {
			setState(261);
			switch (_input.LA(1)) {
			case Type:
				enterOuterAlt(_localctx, 1);
				{
				setState(259);
				match(Type);
				}
				break;
			case Macroref:
				enterOuterAlt(_localctx, 2);
				{
				setState(260);
				macroref();
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
		public TerminalNode Equals() { return getToken(ImpexParser.Equals, 0); }
		public MacroValueContext macroValue() {
			return getRuleContext(MacroValueContext.class,0);
		}
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
		enterRule(_localctx, 50, RULE_macro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(Macrodef);
			setState(264);
			match(Equals);
			setState(265);
			macroValue();
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
		public List<TerminalNode> Macroval() { return getTokens(ImpexParser.Macroval); }
		public TerminalNode Macroval(int i) {
			return getToken(ImpexParser.Macroval, i);
		}
		public List<MacrorefContext> macroref() {
			return getRuleContexts(MacrorefContext.class);
		}
		public MacrorefContext macroref(int i) {
			return getRuleContext(MacrorefContext.class,i);
		}
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
		enterRule(_localctx, 52, RULE_macroValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Macroref || _la==Macroval) {
				{
				setState(269);
				switch (_input.LA(1)) {
				case Macroval:
					{
					setState(267);
					match(Macroval);
					}
					break;
				case Macroref:
					{
					setState(268);
					macroref();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(273);
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
		enterRule(_localctx, 54, RULE_macroref);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(Macroref);
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\62\u0117\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\3\2\7\2?\n\2\f\2"+
		"\16\2B\13\2\3\2\3\2\7\2F\n\2\f\2\16\2I\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\7\3R\n\3\f\3\16\3U\13\3\3\4\3\4\3\4\7\4Z\n\4\f\4\16\4]\13\4\3\4\3\4"+
		"\7\4a\n\4\f\4\16\4d\13\4\3\4\5\4g\n\4\3\5\3\5\3\6\3\6\3\6\3\6\3\7\3\7"+
		"\3\b\5\br\n\b\3\b\3\b\6\bv\n\b\r\b\16\bw\3\b\5\b{\n\b\3\t\3\t\3\t\3\t"+
		"\3\t\7\t\u0082\n\t\f\t\16\t\u0085\13\t\3\t\5\t\u0088\n\t\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u0094\n\f\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\7\16\u009d\n\16\f\16\16\16\u00a0\13\16\3\17\3\17\7\17\u00a4\n\17"+
		"\f\17\16\17\u00a7\13\17\3\20\3\20\3\21\3\21\6\21\u00ad\n\21\r\21\16\21"+
		"\u00ae\3\22\3\22\3\22\3\22\3\22\7\22\u00b6\n\22\f\22\16\22\u00b9\13\22"+
		"\3\22\3\22\5\22\u00bd\n\22\3\22\7\22\u00c0\n\22\f\22\16\22\u00c3\13\22"+
		"\3\23\3\23\3\24\3\24\7\24\u00c9\n\24\f\24\16\24\u00cc\13\24\3\24\3\24"+
		"\3\24\3\24\3\24\7\24\u00d3\n\24\f\24\16\24\u00d6\13\24\3\24\3\24\5\24"+
		"\u00da\n\24\3\24\7\24\u00dd\n\24\f\24\16\24\u00e0\13\24\5\24\u00e2\n\24"+
		"\3\25\3\25\5\25\u00e6\n\25\3\25\3\25\3\26\3\26\3\26\5\26\u00ed\n\26\3"+
		"\26\3\26\5\26\u00f1\n\26\3\26\5\26\u00f4\n\26\5\26\u00f6\n\26\3\27\3\27"+
		"\3\30\3\30\6\30\u00fc\n\30\r\30\16\30\u00fd\3\31\3\31\6\31\u0102\n\31"+
		"\r\31\16\31\u0103\3\32\3\32\5\32\u0108\n\32\3\33\3\33\3\33\3\33\3\34\3"+
		"\34\7\34\u0110\n\34\f\34\16\34\u0113\13\34\3\35\3\35\3\35\2\2\36\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668\2\6\3\2\24\25"+
		"\3\2\16\20\4\2\22\22\31\31\3\2\b\r\u012c\2@\3\2\2\2\4L\3\2\2\2\6V\3\2"+
		"\2\2\bh\3\2\2\2\nj\3\2\2\2\fn\3\2\2\2\16q\3\2\2\2\20\u0087\3\2\2\2\22"+
		"\u0089\3\2\2\2\24\u008b\3\2\2\2\26\u0093\3\2\2\2\30\u0095\3\2\2\2\32\u0097"+
		"\3\2\2\2\34\u00a1\3\2\2\2\36\u00a8\3\2\2\2 \u00aa\3\2\2\2\"\u00b0\3\2"+
		"\2\2$\u00c4\3\2\2\2&\u00e1\3\2\2\2(\u00e5\3\2\2\2*\u00f5\3\2\2\2,\u00f7"+
		"\3\2\2\2.\u00fb\3\2\2\2\60\u0101\3\2\2\2\62\u0107\3\2\2\2\64\u0109\3\2"+
		"\2\2\66\u0111\3\2\2\28\u0114\3\2\2\2:?\7\37\2\2;?\7 \2\2<?\7!\2\2=?\5"+
		"\64\33\2>:\3\2\2\2>;\3\2\2\2><\3\2\2\2>=\3\2\2\2?B\3\2\2\2@>\3\2\2\2@"+
		"A\3\2\2\2AG\3\2\2\2B@\3\2\2\2CF\5\4\3\2DF\7\37\2\2EC\3\2\2\2ED\3\2\2\2"+
		"FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HJ\3\2\2\2IG\3\2\2\2JK\7\2\2\3K\3\3\2\2"+
		"\2LS\5\6\4\2MR\7 \2\2NR\7!\2\2OR\5\64\33\2PR\5\16\b\2QM\3\2\2\2QN\3\2"+
		"\2\2QO\3\2\2\2QP\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T\5\3\2\2\2US\3"+
		"\2\2\2VW\7\3\2\2W[\5\62\32\2XZ\5\n\6\2YX\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2["+
		"\\\3\2\2\2\\b\3\2\2\2][\3\2\2\2^_\7\5\2\2_a\5\26\f\2`^\3\2\2\2ad\3\2\2"+
		"\2b`\3\2\2\2bc\3\2\2\2cf\3\2\2\2db\3\2\2\2eg\7\"\2\2fe\3\2\2\2fg\3\2\2"+
		"\2g\7\3\2\2\2hi\t\2\2\2i\t\3\2\2\2jk\5\f\7\2kl\7\30\2\2lm\5\60\31\2m\13"+
		"\3\2\2\2no\t\3\2\2o\r\3\2\2\2pr\7\4\2\2qp\3\2\2\2qr\3\2\2\2ru\3\2\2\2"+
		"st\7\5\2\2tv\5\20\t\2us\3\2\2\2vw\3\2\2\2wu\3\2\2\2wx\3\2\2\2xz\3\2\2"+
		"\2y{\7\"\2\2zy\3\2\2\2z{\3\2\2\2{\17\3\2\2\2|\u0082\7%\2\2}\u0082\7+\2"+
		"\2~\u0082\58\35\2\177\u0082\7\7\2\2\u0080\u0082\5\24\13\2\u0081|\3\2\2"+
		"\2\u0081}\3\2\2\2\u0081~\3\2\2\2\u0081\177\3\2\2\2\u0081\u0080\3\2\2\2"+
		"\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0088"+
		"\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u0088\5\22\n\2\u0087\u0083\3\2\2\2"+
		"\u0087\u0086\3\2\2\2\u0088\21\3\2\2\2\u0089\u008a\7\'\2\2\u008a\23\3\2"+
		"\2\2\u008b\u008c\7(\2\2\u008c\25\3\2\2\2\u008d\u0094\5\32\16\2\u008e\u0094"+
		"\5\30\r\2\u008f\u0094\5\"\22\2\u0090\u0094\5 \21\2\u0091\u0094\5\34\17"+
		"\2\u0092\u0094\5\36\20\2\u0093\u008d\3\2\2\2\u0093\u008e\3\2\2\2\u0093"+
		"\u008f\3\2\2\2\u0093\u0090\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0092\3\2"+
		"\2\2\u0094\27\3\2\2\2\u0095\u0096\7\33\2\2\u0096\31\3\2\2\2\u0097\u0098"+
		"\5$\23\2\u0098\u0099\7\26\2\2\u0099\u009a\7\33\2\2\u009a\u009e\7\27\2"+
		"\2\u009b\u009d\5*\26\2\u009c\u009b\3\2\2\2\u009d\u00a0\3\2\2\2\u009e\u009c"+
		"\3\2\2\2\u009e\u009f\3\2\2\2\u009f\33\3\2\2\2\u00a0\u009e\3\2\2\2\u00a1"+
		"\u00a5\58\35\2\u00a2\u00a4\5*\26\2\u00a3\u00a2\3\2\2\2\u00a4\u00a7\3\2"+
		"\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\35\3\2\2\2\u00a7\u00a5"+
		"\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\37\3\2\2\2\u00aa\u00ac\7\34\2\2\u00ab"+
		"\u00ad\5*\26\2\u00ac\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00ac\3\2"+
		"\2\2\u00ae\u00af\3\2\2\2\u00af!\3\2\2\2\u00b0\u00bc\5$\23\2\u00b1\u00b2"+
		"\7\26\2\2\u00b2\u00b7\5&\24\2\u00b3\u00b4\t\4\2\2\u00b4\u00b6\5&\24\2"+
		"\u00b5\u00b3\3\2\2\2\u00b6\u00b9\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8"+
		"\3\2\2\2\u00b8\u00ba\3\2\2\2\u00b9\u00b7\3\2\2\2\u00ba\u00bb\7\27\2\2"+
		"\u00bb\u00bd\3\2\2\2\u00bc\u00b1\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00c1"+
		"\3\2\2\2\u00be\u00c0\5*\26\2\u00bf\u00be\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1"+
		"\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2#\3\2\2\2\u00c3\u00c1\3\2\2\2"+
		"\u00c4\u00c5\7\35\2\2\u00c5%\3\2\2\2\u00c6\u00ca\58\35\2\u00c7\u00c9\5"+
		"*\26\2\u00c8\u00c7\3\2\2\2\u00c9\u00cc\3\2\2\2\u00ca\u00c8\3\2\2\2\u00ca"+
		"\u00cb\3\2\2\2\u00cb\u00e2\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00d9\5("+
		"\25\2\u00ce\u00cf\7\26\2\2\u00cf\u00d4\5&\24\2\u00d0\u00d1\t\4\2\2\u00d1"+
		"\u00d3\5&\24\2\u00d2\u00d0\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2"+
		"\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d7\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7"+
		"\u00d8\7\27\2\2\u00d8\u00da\3\2\2\2\u00d9\u00ce\3\2\2\2\u00d9\u00da\3"+
		"\2\2\2\u00da\u00de\3\2\2\2\u00db\u00dd\5*\26\2\u00dc\u00db\3\2\2\2\u00dd"+
		"\u00e0\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00e2\3\2"+
		"\2\2\u00e0\u00de\3\2\2\2\u00e1\u00c6\3\2\2\2\u00e1\u00cd\3\2\2\2\u00e2"+
		"\'\3\2\2\2\u00e3\u00e4\7\35\2\2\u00e4\u00e6\7\23\2\2\u00e5\u00e3\3\2\2"+
		"\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\7\35\2\2\u00e8"+
		")\3\2\2\2\u00e9\u00ea\5,\27\2\u00ea\u00ec\7\30\2\2\u00eb\u00ed\5\60\31"+
		"\2\u00ec\u00eb\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00f6\3\2\2\2\u00ee\u00f0"+
		"\5.\30\2\u00ef\u00f1\7\30\2\2\u00f0\u00ef\3\2\2\2\u00f0\u00f1\3\2\2\2"+
		"\u00f1\u00f3\3\2\2\2\u00f2\u00f4\5\60\31\2\u00f3\u00f2\3\2\2\2\u00f3\u00f4"+
		"\3\2\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00e9\3\2\2\2\u00f5\u00ee\3\2\2\2\u00f6"+
		"+\3\2\2\2\u00f7\u00f8\t\5\2\2\u00f8-\3\2\2\2\u00f9\u00fc\7\21\2\2\u00fa"+
		"\u00fc\58\35\2\u00fb\u00f9\3\2\2\2\u00fb\u00fa\3\2\2\2\u00fc\u00fd\3\2"+
		"\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe/\3\2\2\2\u00ff\u0102"+
		"\7\62\2\2\u0100\u0102\58\35\2\u0101\u00ff\3\2\2\2\u0101\u0100\3\2\2\2"+
		"\u0102\u0103\3\2\2\2\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\61"+
		"\3\2\2\2\u0105\u0108\7\4\2\2\u0106\u0108\58\35\2\u0107\u0105\3\2\2\2\u0107"+
		"\u0106\3\2\2\2\u0108\63\3\2\2\2\u0109\u010a\7\36\2\2\u010a\u010b\7\30"+
		"\2\2\u010b\u010c\5\66\34\2\u010c\65\3\2\2\2\u010d\u0110\7,\2\2\u010e\u0110"+
		"\58\35\2\u010f\u010d\3\2\2\2\u010f\u010e\3\2\2\2\u0110\u0113\3\2\2\2\u0111"+
		"\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\67\3\2\2\2\u0113\u0111\3\2\2"+
		"\2\u0114\u0115\7\6\2\2\u01159\3\2\2\2)>@EGQS[bfqwz\u0081\u0083\u0087\u0093"+
		"\u009e\u00a5\u00ae\u00b7\u00bc\u00c1\u00ca\u00d4\u00d9\u00de\u00e1\u00e5"+
		"\u00ec\u00f0\u00f3\u00f5\u00fb\u00fd\u0101\u0103\u0107\u010f\u0111";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}