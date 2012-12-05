// $ANTLR 3.4 /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g 2012-12-05 22:25:27

package output;

import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;

@SuppressWarnings({ "all", "warnings", "unchecked" })
public class ImpexParser extends Parser {
    public static final String[] tokenNames = new String[] { "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTRIBUTE", "ATTRIBUTES",
            "ATTRIBUTE_NAME", "Alias", "AllowNull", "AttributeModifier", "BLOCK", "BLOCKS", "BatchMode", "Bool", "CacheUnique",
            "CellDecorator", "Char", "Classname", "CollectionDelimiter", "Comma", "Comment", "DOCUMENTID", "DOCUMENTID_REF", "Dateformat",
            "Default", "DocumentID", "Dot", "DoubleQuote", "Equals", "FIELDS", "Field", "ForceWrite", "HEADER", "HeaderMode",
            "HeaderModifier", "IMPEX", "ITEM_EXPRESSION", "Identifier", "IgnoreKeyCase", "IgnoreNull", "Insert", "InsertUpdate",
            "KeyToValueDelimiter", "LBracket", "LParenthesis", "Lang", "Lb", "MACRO_REF", "MODIFIER", "MODIFIERS", "Macrodef",
            "MapDelimiter", "Mode", "NextRow", "NumberFormat", "Or", "PathDelimiter", "Pos", "Processor", "QuotedField", "RBracket",
            "RECORD", "RECORDS", "RParenthesis", "Remove", "SUBTYPE", "Semicolon", "SpecialAttribute", "TYPE", "Translator", "Unique",
            "Update", "ValueAssignement", "Virtual", "Ws" };

    public static final int EOF = -1;
    public static final int ATTRIBUTE = 4;
    public static final int ATTRIBUTES = 5;
    public static final int ATTRIBUTE_NAME = 6;
    public static final int Alias = 7;
    public static final int AllowNull = 8;
    public static final int AttributeModifier = 9;
    public static final int BLOCK = 10;
    public static final int BLOCKS = 11;
    public static final int BatchMode = 12;
    public static final int Bool = 13;
    public static final int CacheUnique = 14;
    public static final int CellDecorator = 15;
    public static final int Char = 16;
    public static final int Classname = 17;
    public static final int CollectionDelimiter = 18;
    public static final int Comma = 19;
    public static final int Comment = 20;
    public static final int DOCUMENTID = 21;
    public static final int DOCUMENTID_REF = 22;
    public static final int Dateformat = 23;
    public static final int Default = 24;
    public static final int DocumentID = 25;
    public static final int Dot = 26;
    public static final int DoubleQuote = 27;
    public static final int Equals = 28;
    public static final int FIELDS = 29;
    public static final int Field = 30;
    public static final int ForceWrite = 31;
    public static final int HEADER = 32;
    public static final int HeaderMode = 33;
    public static final int HeaderModifier = 34;
    public static final int IMPEX = 35;
    public static final int ITEM_EXPRESSION = 36;
    public static final int Identifier = 37;
    public static final int IgnoreKeyCase = 38;
    public static final int IgnoreNull = 39;
    public static final int Insert = 40;
    public static final int InsertUpdate = 41;
    public static final int KeyToValueDelimiter = 42;
    public static final int LBracket = 43;
    public static final int LParenthesis = 44;
    public static final int Lang = 45;
    public static final int Lb = 46;
    public static final int MACRO_REF = 47;
    public static final int MODIFIER = 48;
    public static final int MODIFIERS = 49;
    public static final int Macrodef = 50;
    public static final int MapDelimiter = 51;
    public static final int Mode = 52;
    public static final int NextRow = 53;
    public static final int NumberFormat = 54;
    public static final int Or = 55;
    public static final int PathDelimiter = 56;
    public static final int Pos = 57;
    public static final int Processor = 58;
    public static final int QuotedField = 59;
    public static final int RBracket = 60;
    public static final int RECORD = 61;
    public static final int RECORDS = 62;
    public static final int RParenthesis = 63;
    public static final int Remove = 64;
    public static final int SUBTYPE = 65;
    public static final int Semicolon = 66;
    public static final int SpecialAttribute = 67;
    public static final int TYPE = 68;
    public static final int Translator = 69;
    public static final int Unique = 70;
    public static final int Update = 71;
    public static final int ValueAssignement = 72;
    public static final int Virtual = 73;
    public static final int Ws = 74;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators

    public ImpexParser(final TokenStream input) {
        this(input, new RecognizerSharedState());
    }

    public ImpexParser(final TokenStream input, final RecognizerSharedState state) {
        super(input, state);
    }

    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(final TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }

    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() {
        return ImpexParser.tokenNames;
    }

    public String getGrammarFileName() {
        return "/work/projects/yeclipse/ImpexAST/src/main/java/Impex.g";
    }

    private final Map<String, List<SimpleImmutableEntry>> macros = new HashMap<String, List<SimpleImmutableEntry>>();
    private final Pattern macroPattern = Pattern.compile("$[a-zA-Z_][a-zA-Z_0-9]*");

    private void registerMacro(final Token def, final String val) {
        final String macrodef = def.getText();
        List<SimpleImmutableEntry> macroval = macros.get(macrodef);
        if (macroval == null) {
            macroval = new ArrayList<SimpleImmutableEntry>();
            macros.put(macrodef, macroval);
        }
        macroval.add(new SimpleImmutableEntry<Integer, String>(def.getLine(), val));
    }

    private String getMacroVal(final String macroDef, final int refLine) {
        final List<SimpleImmutableEntry> list = macros.get(macroDef);
        if (list == null) {
            // in case there is no such macro definition treat it as normal text and issue an error 
            return macroDef;
        }

        for (int i = list.size() - 1; i >= 0; --i) {
            final SimpleImmutableEntry<Integer, String> entry = list.get(i);
            if (entry.getKey().intValue() < refLine) {
                String val = entry.getValue();
                final Matcher m = macroPattern.matcher(val);
                while (m.find()) {
                    final String nestedMacroDef = m.group();
                    final String nestedVal = getMacroVal(nestedMacroDef, entry.getKey());
                    val = m.replaceFirst(nestedVal);
                }
                return val;
            }
        }
        return macroDef;
    }

    public static class parse_return extends ParserRuleReturnScope {
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "parse"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:195:1: parse : (t= . )* EOF ;
    public final ImpexParser.parse_return parse() throws RecognitionException {
        final ImpexParser.parse_return retval = new ImpexParser.parse_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token t = null;
        Token EOF1 = null;

        CommonTree t_tree = null;
        CommonTree EOF1_tree = null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:196:3: ( (t= . )* EOF )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:196:6: (t= . )* EOF
            {
                root_0 = (CommonTree) adaptor.nil();

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:196:6: (t= . )*
                loop1: do {
                    int alt1 = 2;
                    final int LA1_0 = input.LA(1);

                    if (((LA1_0 >= ATTRIBUTE && LA1_0 <= Ws))) {
                        alt1 = 1;
                    }

                    switch (alt1) {
                        case 1:
                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:196:7: t= .
                        {
                            t = (Token) input.LT(1);

                            matchAny(input);
                            t_tree = (CommonTree) adaptor.create(t);
                            adaptor.addChild(root_0, t_tree);

                            System.out.printf("%s: %-7s \n", tokenNames[(t != null ? t.getType() : 0)], (t != null ? t.getText() : null));

                        }
                            break;

                        default:
                            break loop1;
                    }
                } while (true);

                EOF1 = (Token) match(input, EOF, FOLLOW_EOF_in_parse178);
                EOF1_tree = (CommonTree) adaptor.create(EOF1);
                adaptor.addChild(root_0, EOF1_tree);

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (final RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
            // do for sure before leaving
        }
        return retval;
    }

    // $ANTLR end "parse"

    public static class impex_return extends ParserRuleReturnScope {
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "impex"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:198:1: impex : ( Lb | block | macro )* EOF -> ^( IMPEX ^( BLOCKS ( block )* ) ) ;
    public final ImpexParser.impex_return impex() throws RecognitionException {
        final ImpexParser.impex_return retval = new ImpexParser.impex_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Lb2 = null;
        Token EOF5 = null;
        ImpexParser.block_return block3 = null;

        ImpexParser.macro_return macro4 = null;

        final CommonTree Lb2_tree = null;
        final CommonTree EOF5_tree = null;
        final RewriteRuleTokenStream stream_EOF = new RewriteRuleTokenStream(adaptor, "token EOF");
        final RewriteRuleTokenStream stream_Lb = new RewriteRuleTokenStream(adaptor, "token Lb");
        final RewriteRuleSubtreeStream stream_macro = new RewriteRuleSubtreeStream(adaptor, "rule macro");
        final RewriteRuleSubtreeStream stream_block = new RewriteRuleSubtreeStream(adaptor, "rule block");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:198:7: ( ( Lb | block | macro )* EOF -> ^( IMPEX ^( BLOCKS ( block )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:198:9: ( Lb | block | macro )* EOF
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:198:9: ( Lb | block | macro )*
                loop2: do {
                    int alt2 = 4;
                    switch (input.LA(1)) {
                        case Lb: {
                            alt2 = 1;
                        }
                            break;
                        case Insert:
                        case InsertUpdate:
                        case Remove:
                        case Update: {
                            alt2 = 2;
                        }
                            break;
                        case Macrodef: {
                            alt2 = 3;
                        }
                            break;

                    }

                    switch (alt2) {
                        case 1:
                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:198:10: Lb
                        {
                            Lb2 = (Token) match(input, Lb, FOLLOW_Lb_in_impex190);
                            stream_Lb.add(Lb2);

                        }
                            break;
                        case 2:
                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:198:16: block
                        {
                            pushFollow(FOLLOW_block_in_impex195);
                            block3 = block();

                            state._fsp--;

                            stream_block.add(block3.getTree());

                        }
                            break;
                        case 3:
                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:198:24: macro
                        {
                            pushFollow(FOLLOW_macro_in_impex199);
                            macro4 = macro();

                            state._fsp--;

                            stream_macro.add(macro4.getTree());

                        }
                            break;

                        default:
                            break loop2;
                    }
                } while (true);

                EOF5 = (Token) match(input, EOF, FOLLOW_EOF_in_impex203);
                stream_EOF.add(EOF5);

                // AST REWRITE
                // elements: block
                // token labels: 
                // rule labels: retval
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                retval.tree = root_0;
                final RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
                        retval != null ? retval.tree : null);

                root_0 = (CommonTree) adaptor.nil();
                // 199:3: -> ^( IMPEX ^( BLOCKS ( block )* ) )
                {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:199:6: ^( IMPEX ^( BLOCKS ( block )* ) )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(IMPEX, "IMPEX"), root_1);

                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:199:14: ^( BLOCKS ( block )* )
                        {
                            CommonTree root_2 = (CommonTree) adaptor.nil();
                            root_2 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(BLOCKS, "BLOCKS"), root_2);

                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:199:23: ( block )*
                            while (stream_block.hasNext()) {
                                adaptor.addChild(root_2, stream_block.nextTree());

                            }
                            stream_block.reset();

                            adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                    }

                }

                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (final RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
            // do for sure before leaving
        }
        return retval;
    }

    // $ANTLR end "impex"

    public static class block_return extends ParserRuleReturnScope {
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "block"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:201:1: block : header ( ( Lb )+ ( macro ( Lb )? )* record )+ -> ^( BLOCK header ^( RECORDS ( record )+ ) ) ;
    public final ImpexParser.block_return block() throws RecognitionException {
        final ImpexParser.block_return retval = new ImpexParser.block_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Lb7 = null;
        Token Lb9 = null;
        ImpexParser.header_return header6 = null;

        ImpexParser.macro_return macro8 = null;

        ImpexParser.record_return record10 = null;

        final CommonTree Lb7_tree = null;
        final CommonTree Lb9_tree = null;
        final RewriteRuleTokenStream stream_Lb = new RewriteRuleTokenStream(adaptor, "token Lb");
        final RewriteRuleSubtreeStream stream_record = new RewriteRuleSubtreeStream(adaptor, "rule record");
        final RewriteRuleSubtreeStream stream_macro = new RewriteRuleSubtreeStream(adaptor, "rule macro");
        final RewriteRuleSubtreeStream stream_header = new RewriteRuleSubtreeStream(adaptor, "rule header");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:201:7: ( header ( ( Lb )+ ( macro ( Lb )? )* record )+ -> ^( BLOCK header ^( RECORDS ( record )+ ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:201:9: header ( ( Lb )+ ( macro ( Lb )? )* record )+
            {
                pushFollow(FOLLOW_header_in_block226);
                header6 = header();

                state._fsp--;

                stream_header.add(header6.getTree());

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:201:16: ( ( Lb )+ ( macro ( Lb )? )* record )+
                int cnt6 = 0;
                loop6: do {
                    int alt6 = 2;
                    alt6 = dfa6.predict(input);
                    switch (alt6) {
                        case 1:
                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:201:17: ( Lb )+ ( macro ( Lb )? )* record
                        {
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:201:17: ( Lb )+
                            int cnt3 = 0;
                            loop3: do {
                                int alt3 = 2;
                                final int LA3_0 = input.LA(1);

                                if ((LA3_0 == Lb)) {
                                    alt3 = 1;
                                }

                                switch (alt3) {
                                    case 1:
                                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:201:17: Lb
                                    {
                                        Lb7 = (Token) match(input, Lb, FOLLOW_Lb_in_block229);
                                        stream_Lb.add(Lb7);

                                    }
                                        break;

                                    default:
                                        if (cnt3 >= 1) {
                                            break loop3;
                                        }
                                        final EarlyExitException eee = new EarlyExitException(3, input);
                                        throw eee;
                                }
                                cnt3++;
                            } while (true);

                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:201:21: ( macro ( Lb )? )*
                            loop5: do {
                                int alt5 = 2;
                                final int LA5_0 = input.LA(1);

                                if ((LA5_0 == Macrodef)) {
                                    alt5 = 1;
                                }

                                switch (alt5) {
                                    case 1:
                                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:201:22: macro ( Lb )?
                                    {
                                        pushFollow(FOLLOW_macro_in_block233);
                                        macro8 = macro();

                                        state._fsp--;

                                        stream_macro.add(macro8.getTree());

                                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:201:28: ( Lb )?
                                        int alt4 = 2;
                                        final int LA4_0 = input.LA(1);

                                        if ((LA4_0 == Lb)) {
                                            alt4 = 1;
                                        }
                                        switch (alt4) {
                                            case 1:
                                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:201:28: Lb
                                            {
                                                Lb9 = (Token) match(input, Lb, FOLLOW_Lb_in_block235);
                                                stream_Lb.add(Lb9);

                                            }
                                                break;

                                        }

                                    }
                                        break;

                                    default:
                                        break loop5;
                                }
                            } while (true);

                            pushFollow(FOLLOW_record_in_block240);
                            record10 = record();

                            state._fsp--;

                            stream_record.add(record10.getTree());

                        }
                            break;

                        default:
                            if (cnt6 >= 1) {
                                break loop6;
                            }
                            final EarlyExitException eee = new EarlyExitException(6, input);
                            throw eee;
                    }
                    cnt6++;
                } while (true);

                // AST REWRITE
                // elements: record, header
                // token labels: 
                // rule labels: retval
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                retval.tree = root_0;
                final RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
                        retval != null ? retval.tree : null);

                root_0 = (CommonTree) adaptor.nil();
                // 202:2: -> ^( BLOCK header ^( RECORDS ( record )+ ) )
                {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:202:5: ^( BLOCK header ^( RECORDS ( record )+ ) )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(BLOCK, "BLOCK"), root_1);

                        adaptor.addChild(root_1, stream_header.nextTree());

                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:202:20: ^( RECORDS ( record )+ )
                        {
                            CommonTree root_2 = (CommonTree) adaptor.nil();
                            root_2 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(RECORDS, "RECORDS"), root_2);

                            if (!(stream_record.hasNext())) {
                                throw new RewriteEarlyExitException();
                            }
                            while (stream_record.hasNext()) {
                                adaptor.addChild(root_2, stream_record.nextTree());

                            }
                            stream_record.reset();

                            adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                    }

                }

                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (final RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
            // do for sure before leaving
        }
        return retval;
    }

    // $ANTLR end "block"

    public static class header_return extends ParserRuleReturnScope {
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "header"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:204:1: header : headerMode Identifier ( headerModifiers )? ( Semicolon ( attribute )? )* ( Semicolon DocumentID ( Semicolon ( attribute )? )* )? -> ^( HEADER headerMode ^( TYPE Identifier ) ( ^( MODIFIERS headerModifiers ) )? ( ^( DOCUMENTID DocumentID ) )? ^( ATTRIBUTES ( attribute )* ) ) ;
    public final ImpexParser.header_return header() throws RecognitionException {
        final ImpexParser.header_return retval = new ImpexParser.header_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier12 = null;
        Token Semicolon14 = null;
        Token Semicolon16 = null;
        Token DocumentID17 = null;
        Token Semicolon18 = null;
        ImpexParser.headerMode_return headerMode11 = null;

        ImpexParser.headerModifiers_return headerModifiers13 = null;

        ImpexParser.attribute_return attribute15 = null;

        ImpexParser.attribute_return attribute19 = null;

        final CommonTree Identifier12_tree = null;
        final CommonTree Semicolon14_tree = null;
        final CommonTree Semicolon16_tree = null;
        final CommonTree DocumentID17_tree = null;
        final CommonTree Semicolon18_tree = null;
        final RewriteRuleTokenStream stream_DocumentID = new RewriteRuleTokenStream(adaptor, "token DocumentID");
        final RewriteRuleTokenStream stream_Semicolon = new RewriteRuleTokenStream(adaptor, "token Semicolon");
        final RewriteRuleTokenStream stream_Identifier = new RewriteRuleTokenStream(adaptor, "token Identifier");
        final RewriteRuleSubtreeStream stream_headerMode = new RewriteRuleSubtreeStream(adaptor, "rule headerMode");
        final RewriteRuleSubtreeStream stream_attribute = new RewriteRuleSubtreeStream(adaptor, "rule attribute");
        final RewriteRuleSubtreeStream stream_headerModifiers = new RewriteRuleSubtreeStream(adaptor, "rule headerModifiers");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:2: ( headerMode Identifier ( headerModifiers )? ( Semicolon ( attribute )? )* ( Semicolon DocumentID ( Semicolon ( attribute )? )* )? -> ^( HEADER headerMode ^( TYPE Identifier ) ( ^( MODIFIERS headerModifiers ) )? ( ^( DOCUMENTID DocumentID ) )? ^( ATTRIBUTES ( attribute )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:4: headerMode Identifier ( headerModifiers )? ( Semicolon ( attribute )? )* ( Semicolon DocumentID ( Semicolon ( attribute )? )* )?
            {
                pushFollow(FOLLOW_headerMode_in_header267);
                headerMode11 = headerMode();

                state._fsp--;

                stream_headerMode.add(headerMode11.getTree());

                Identifier12 = (Token) match(input, Identifier, FOLLOW_Identifier_in_header270);
                stream_Identifier.add(Identifier12);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:27: ( headerModifiers )?
                int alt7 = 2;
                final int LA7_0 = input.LA(1);

                if ((LA7_0 == LBracket)) {
                    alt7 = 1;
                }
                switch (alt7) {
                    case 1:
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:27: headerModifiers
                    {
                        pushFollow(FOLLOW_headerModifiers_in_header272);
                        headerModifiers13 = headerModifiers();

                        state._fsp--;

                        stream_headerModifiers.add(headerModifiers13.getTree());

                    }
                        break;

                }

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:45: ( Semicolon ( attribute )? )*
                loop9: do {
                    int alt9 = 2;
                    final int LA9_0 = input.LA(1);

                    if ((LA9_0 == Semicolon)) {
                        final int LA9_1 = input.LA(2);

                        if ((LA9_1 == Identifier || LA9_1 == Lb || LA9_1 == Macrodef || (LA9_1 >= Semicolon && LA9_1 <= SpecialAttribute))) {
                            alt9 = 1;
                        }

                    }

                    switch (alt9) {
                        case 1:
                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:46: Semicolon ( attribute )?
                        {
                            Semicolon14 = (Token) match(input, Semicolon, FOLLOW_Semicolon_in_header277);
                            stream_Semicolon.add(Semicolon14);

                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:56: ( attribute )?
                            int alt8 = 2;
                            final int LA8_0 = input.LA(1);

                            if ((LA8_0 == Identifier || LA8_0 == Macrodef || LA8_0 == SpecialAttribute)) {
                                alt8 = 1;
                            }
                            switch (alt8) {
                                case 1:
                                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:56: attribute
                                {
                                    pushFollow(FOLLOW_attribute_in_header279);
                                    attribute15 = attribute();

                                    state._fsp--;

                                    stream_attribute.add(attribute15.getTree());

                                }
                                    break;

                            }

                        }
                            break;

                        default:
                            break loop9;
                    }
                } while (true);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:69: ( Semicolon DocumentID ( Semicolon ( attribute )? )* )?
                int alt12 = 2;
                final int LA12_0 = input.LA(1);

                if ((LA12_0 == Semicolon)) {
                    alt12 = 1;
                }
                switch (alt12) {
                    case 1:
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:70: Semicolon DocumentID ( Semicolon ( attribute )? )*
                    {
                        Semicolon16 = (Token) match(input, Semicolon, FOLLOW_Semicolon_in_header285);
                        stream_Semicolon.add(Semicolon16);

                        DocumentID17 = (Token) match(input, DocumentID, FOLLOW_DocumentID_in_header287);
                        stream_DocumentID.add(DocumentID17);

                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:90: ( Semicolon ( attribute )? )*
                        loop11: do {
                            int alt11 = 2;
                            final int LA11_0 = input.LA(1);

                            if ((LA11_0 == Semicolon)) {
                                alt11 = 1;
                            }

                            switch (alt11) {
                                case 1:
                                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:91: Semicolon ( attribute )?
                                {
                                    Semicolon18 = (Token) match(input, Semicolon, FOLLOW_Semicolon_in_header289);
                                    stream_Semicolon.add(Semicolon18);

                                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:101: ( attribute )?
                                    int alt10 = 2;
                                    final int LA10_0 = input.LA(1);

                                    if ((LA10_0 == Identifier || LA10_0 == Macrodef || LA10_0 == SpecialAttribute)) {
                                        alt10 = 1;
                                    }
                                    switch (alt10) {
                                        case 1:
                                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:101: attribute
                                        {
                                            pushFollow(FOLLOW_attribute_in_header291);
                                            attribute19 = attribute();

                                            state._fsp--;

                                            stream_attribute.add(attribute19.getTree());

                                        }
                                            break;

                                    }

                                }
                                    break;

                                default:
                                    break loop11;
                            }
                        } while (true);

                    }
                        break;

                }

                // AST REWRITE
                // elements: DocumentID, Identifier, headerModifiers, headerMode, attribute
                // token labels: 
                // rule labels: retval
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                retval.tree = root_0;
                final RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
                        retval != null ? retval.tree : null);

                root_0 = (CommonTree) adaptor.nil();
                // 206:2: -> ^( HEADER headerMode ^( TYPE Identifier ) ( ^( MODIFIERS headerModifiers ) )? ( ^( DOCUMENTID DocumentID ) )? ^( ATTRIBUTES ( attribute )* ) )
                {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:206:5: ^( HEADER headerMode ^( TYPE Identifier ) ( ^( MODIFIERS headerModifiers ) )? ( ^( DOCUMENTID DocumentID ) )? ^( ATTRIBUTES ( attribute )* ) )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(HEADER, "HEADER"), root_1);

                        adaptor.addChild(root_1, stream_headerMode.nextTree());

                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:206:25: ^( TYPE Identifier )
                        {
                            CommonTree root_2 = (CommonTree) adaptor.nil();
                            root_2 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(TYPE, "TYPE"), root_2);

                            adaptor.addChild(root_2, stream_Identifier.nextNode());

                            adaptor.addChild(root_1, root_2);
                        }

                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:206:44: ( ^( MODIFIERS headerModifiers ) )?
                        if (stream_headerModifiers.hasNext()) {
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:206:44: ^( MODIFIERS headerModifiers )
                            {
                                CommonTree root_2 = (CommonTree) adaptor.nil();
                                root_2 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(MODIFIERS, "MODIFIERS"), root_2);

                                adaptor.addChild(root_2, stream_headerModifiers.nextTree());

                                adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_headerModifiers.reset();

                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:206:74: ( ^( DOCUMENTID DocumentID ) )?
                        if (stream_DocumentID.hasNext()) {
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:206:74: ^( DOCUMENTID DocumentID )
                            {
                                CommonTree root_2 = (CommonTree) adaptor.nil();
                                root_2 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(DOCUMENTID, "DOCUMENTID"), root_2);

                                adaptor.addChild(root_2, stream_DocumentID.nextNode());

                                adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_DocumentID.reset();

                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:206:100: ^( ATTRIBUTES ( attribute )* )
                        {
                            CommonTree root_2 = (CommonTree) adaptor.nil();
                            root_2 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(ATTRIBUTES, "ATTRIBUTES"), root_2);

                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:206:113: ( attribute )*
                            while (stream_attribute.hasNext()) {
                                adaptor.addChild(root_2, stream_attribute.nextTree());

                            }
                            stream_attribute.reset();

                            adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                    }

                }

                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (final RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
            // do for sure before leaving
        }
        return retval;
    }

    // $ANTLR end "header"

    public static class headerModifiers_return extends ParserRuleReturnScope {
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "headerModifiers"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:208:1: headerModifiers : ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )+ -> ^( MODIFIERS ( headerModifierAssignment )+ ) ;
    public final ImpexParser.headerModifiers_return headerModifiers() throws RecognitionException {
        final ImpexParser.headerModifiers_return retval = new ImpexParser.headerModifiers_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBracket20 = null;
        Token Comma22 = null;
        Token RBracket24 = null;
        ImpexParser.headerModifierAssignment_return headerModifierAssignment21 = null;

        ImpexParser.headerModifierAssignment_return headerModifierAssignment23 = null;

        final CommonTree LBracket20_tree = null;
        final CommonTree Comma22_tree = null;
        final CommonTree RBracket24_tree = null;
        final RewriteRuleTokenStream stream_RBracket = new RewriteRuleTokenStream(adaptor, "token RBracket");
        final RewriteRuleTokenStream stream_LBracket = new RewriteRuleTokenStream(adaptor, "token LBracket");
        final RewriteRuleTokenStream stream_Comma = new RewriteRuleTokenStream(adaptor, "token Comma");
        final RewriteRuleSubtreeStream stream_headerModifierAssignment = new RewriteRuleSubtreeStream(adaptor,
                "rule headerModifierAssignment");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:209:2: ( ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )+ -> ^( MODIFIERS ( headerModifierAssignment )+ ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:209:4: ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )+
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:209:4: ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )+
                int cnt14 = 0;
                loop14: do {
                    int alt14 = 2;
                    final int LA14_0 = input.LA(1);

                    if ((LA14_0 == LBracket)) {
                        alt14 = 1;
                    }

                    switch (alt14) {
                        case 1:
                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:209:5: LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket
                        {
                            LBracket20 = (Token) match(input, LBracket, FOLLOW_LBracket_in_headerModifiers345);
                            stream_LBracket.add(LBracket20);

                            pushFollow(FOLLOW_headerModifierAssignment_in_headerModifiers347);
                            headerModifierAssignment21 = headerModifierAssignment();

                            state._fsp--;

                            stream_headerModifierAssignment.add(headerModifierAssignment21.getTree());

                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:209:39: ( Comma headerModifierAssignment )*
                            loop13: do {
                                int alt13 = 2;
                                final int LA13_0 = input.LA(1);

                                if ((LA13_0 == Comma)) {
                                    alt13 = 1;
                                }

                                switch (alt13) {
                                    case 1:
                                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:209:40: Comma headerModifierAssignment
                                    {
                                        Comma22 = (Token) match(input, Comma, FOLLOW_Comma_in_headerModifiers350);
                                        stream_Comma.add(Comma22);

                                        pushFollow(FOLLOW_headerModifierAssignment_in_headerModifiers353);
                                        headerModifierAssignment23 = headerModifierAssignment();

                                        state._fsp--;

                                        stream_headerModifierAssignment.add(headerModifierAssignment23.getTree());

                                    }
                                        break;

                                    default:
                                        break loop13;
                                }
                            } while (true);

                            RBracket24 = (Token) match(input, RBracket, FOLLOW_RBracket_in_headerModifiers357);
                            stream_RBracket.add(RBracket24);

                        }
                            break;

                        default:
                            if (cnt14 >= 1) {
                                break loop14;
                            }
                            final EarlyExitException eee = new EarlyExitException(14, input);
                            throw eee;
                    }
                    cnt14++;
                } while (true);

                // AST REWRITE
                // elements: headerModifierAssignment
                // token labels: 
                // rule labels: retval
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                retval.tree = root_0;
                final RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
                        retval != null ? retval.tree : null);

                root_0 = (CommonTree) adaptor.nil();
                // 210:2: -> ^( MODIFIERS ( headerModifierAssignment )+ )
                {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:210:5: ^( MODIFIERS ( headerModifierAssignment )+ )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(MODIFIERS, "MODIFIERS"), root_1);

                        if (!(stream_headerModifierAssignment.hasNext())) {
                            throw new RewriteEarlyExitException();
                        }
                        while (stream_headerModifierAssignment.hasNext()) {
                            adaptor.addChild(root_1, stream_headerModifierAssignment.nextTree());

                        }
                        stream_headerModifierAssignment.reset();

                        adaptor.addChild(root_0, root_1);
                    }

                }

                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (final RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
            // do for sure before leaving
        }
        return retval;
    }

    // $ANTLR end "headerModifiers"

    public static class headerModifierAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "headerModifierAssignment"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:212:1: headerModifierAssignment : headerModifier Equals boolOrClassname -> ^( MODIFIER headerModifier boolOrClassname ) ;
    public final ImpexParser.headerModifierAssignment_return headerModifierAssignment() throws RecognitionException {
        final ImpexParser.headerModifierAssignment_return retval = new ImpexParser.headerModifierAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Equals26 = null;
        ImpexParser.headerModifier_return headerModifier25 = null;

        ImpexParser.boolOrClassname_return boolOrClassname27 = null;

        final CommonTree Equals26_tree = null;
        final RewriteRuleTokenStream stream_Equals = new RewriteRuleTokenStream(adaptor, "token Equals");
        final RewriteRuleSubtreeStream stream_headerModifier = new RewriteRuleSubtreeStream(adaptor, "rule headerModifier");
        final RewriteRuleSubtreeStream stream_boolOrClassname = new RewriteRuleSubtreeStream(adaptor, "rule boolOrClassname");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:212:25: ( headerModifier Equals boolOrClassname -> ^( MODIFIER headerModifier boolOrClassname ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:212:27: headerModifier Equals boolOrClassname
            {
                pushFollow(FOLLOW_headerModifier_in_headerModifierAssignment376);
                headerModifier25 = headerModifier();

                state._fsp--;

                stream_headerModifier.add(headerModifier25.getTree());

                Equals26 = (Token) match(input, Equals, FOLLOW_Equals_in_headerModifierAssignment378);
                stream_Equals.add(Equals26);

                pushFollow(FOLLOW_boolOrClassname_in_headerModifierAssignment380);
                boolOrClassname27 = boolOrClassname();

                state._fsp--;

                stream_boolOrClassname.add(boolOrClassname27.getTree());

                // AST REWRITE
                // elements: headerModifier, boolOrClassname
                // token labels: 
                // rule labels: retval
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                retval.tree = root_0;
                final RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
                        retval != null ? retval.tree : null);

                root_0 = (CommonTree) adaptor.nil();
                // 213:2: -> ^( MODIFIER headerModifier boolOrClassname )
                {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:213:5: ^( MODIFIER headerModifier boolOrClassname )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(MODIFIER, "MODIFIER"), root_1);

                        adaptor.addChild(root_1, stream_headerModifier.nextTree());

                        adaptor.addChild(root_1, stream_boolOrClassname.nextTree());

                        adaptor.addChild(root_0, root_1);
                    }

                }

                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (final RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
            // do for sure before leaving
        }
        return retval;
    }

    // $ANTLR end "headerModifierAssignment"

    public static class boolOrClassname_return extends ParserRuleReturnScope {
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "boolOrClassname"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:215:1: boolOrClassname : ( Bool | Classname );
    public final ImpexParser.boolOrClassname_return boolOrClassname() throws RecognitionException {
        final ImpexParser.boolOrClassname_return retval = new ImpexParser.boolOrClassname_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set28 = null;

        final CommonTree set28_tree = null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:216:2: ( Bool | Classname )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
                root_0 = (CommonTree) adaptor.nil();

                set28 = (Token) input.LT(1);

                if (input.LA(1) == Bool || input.LA(1) == Classname) {
                    input.consume();
                    adaptor.addChild(root_0, (CommonTree) adaptor.create(set28));
                    state.errorRecovery = false;
                } else {
                    final MismatchedSetException mse = new MismatchedSetException(null, input);
                    throw mse;
                }

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (final RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
            // do for sure before leaving
        }
        return retval;
    }

    // $ANTLR end "boolOrClassname"

    public static class headerModifier_return extends ParserRuleReturnScope {
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "headerModifier"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:218:1: headerModifier : ( BatchMode | CacheUnique | Processor );
    public final ImpexParser.headerModifier_return headerModifier() throws RecognitionException {
        final ImpexParser.headerModifier_return retval = new ImpexParser.headerModifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set29 = null;

        final CommonTree set29_tree = null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:219:2: ( BatchMode | CacheUnique | Processor )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
                root_0 = (CommonTree) adaptor.nil();

                set29 = (Token) input.LT(1);

                if (input.LA(1) == BatchMode || input.LA(1) == CacheUnique || input.LA(1) == Processor) {
                    input.consume();
                    adaptor.addChild(root_0, (CommonTree) adaptor.create(set29));
                    state.errorRecovery = false;
                } else {
                    final MismatchedSetException mse = new MismatchedSetException(null, input);
                    throw mse;
                }

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (final RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
            // do for sure before leaving
        }
        return retval;
    }

    // $ANTLR end "headerModifier"

    public static class record_return extends ParserRuleReturnScope {
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "record"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:222:1: record : ( Identifier )? ( QuotedField | Field )+ -> ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( QuotedField )* ( Field )* ) ) ;
    public final ImpexParser.record_return record() throws RecognitionException {
        final ImpexParser.record_return retval = new ImpexParser.record_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier30 = null;
        Token QuotedField31 = null;
        Token Field32 = null;

        final CommonTree Identifier30_tree = null;
        final CommonTree QuotedField31_tree = null;
        final CommonTree Field32_tree = null;
        final RewriteRuleTokenStream stream_Field = new RewriteRuleTokenStream(adaptor, "token Field");
        final RewriteRuleTokenStream stream_Identifier = new RewriteRuleTokenStream(adaptor, "token Identifier");
        final RewriteRuleTokenStream stream_QuotedField = new RewriteRuleTokenStream(adaptor, "token QuotedField");

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:223:5: ( ( Identifier )? ( QuotedField | Field )+ -> ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( QuotedField )* ( Field )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:223:7: ( Identifier )? ( QuotedField | Field )+
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:223:7: ( Identifier )?
                int alt15 = 2;
                final int LA15_0 = input.LA(1);

                if ((LA15_0 == Identifier)) {
                    alt15 = 1;
                }
                switch (alt15) {
                    case 1:
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:223:7: Identifier
                    {
                        Identifier30 = (Token) match(input, Identifier, FOLLOW_Identifier_in_record433);
                        stream_Identifier.add(Identifier30);

                    }
                        break;

                }

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:223:19: ( QuotedField | Field )+
                int cnt16 = 0;
                loop16: do {
                    int alt16 = 3;
                    final int LA16_0 = input.LA(1);

                    if ((LA16_0 == QuotedField)) {
                        alt16 = 1;
                    } else if ((LA16_0 == Field)) {
                        alt16 = 2;
                    }

                    switch (alt16) {
                        case 1:
                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:223:20: QuotedField
                        {
                            QuotedField31 = (Token) match(input, QuotedField, FOLLOW_QuotedField_in_record437);
                            stream_QuotedField.add(QuotedField31);

                        }
                            break;
                        case 2:
                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:223:34: Field
                        {
                            Field32 = (Token) match(input, Field, FOLLOW_Field_in_record441);
                            stream_Field.add(Field32);

                        }
                            break;

                        default:
                            if (cnt16 >= 1) {
                                break loop16;
                            }
                            final EarlyExitException eee = new EarlyExitException(16, input);
                            throw eee;
                    }
                    cnt16++;
                } while (true);

                // AST REWRITE
                // elements: Field, QuotedField, Identifier
                // token labels: 
                // rule labels: retval
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                retval.tree = root_0;
                final RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
                        retval != null ? retval.tree : null);

                root_0 = (CommonTree) adaptor.nil();
                // 224:6: -> ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( QuotedField )* ( Field )* ) )
                {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:224:9: ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( QuotedField )* ( Field )* ) )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(RECORD, "RECORD"), root_1);

                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:224:18: ^( SUBTYPE ( Identifier )? )
                        {
                            CommonTree root_2 = (CommonTree) adaptor.nil();
                            root_2 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(SUBTYPE, "SUBTYPE"), root_2);

                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:224:28: ( Identifier )?
                            if (stream_Identifier.hasNext()) {
                                adaptor.addChild(root_2, stream_Identifier.nextNode());

                            }
                            stream_Identifier.reset();

                            adaptor.addChild(root_1, root_2);
                        }

                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:224:41: ^( FIELDS ( QuotedField )* ( Field )* )
                        {
                            CommonTree root_2 = (CommonTree) adaptor.nil();
                            root_2 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(FIELDS, "FIELDS"), root_2);

                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:224:50: ( QuotedField )*
                            while (stream_QuotedField.hasNext()) {
                                adaptor.addChild(root_2, stream_QuotedField.nextNode());

                            }
                            stream_QuotedField.reset();

                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:224:63: ( Field )*
                            while (stream_Field.hasNext()) {
                                adaptor.addChild(root_2, stream_Field.nextNode());

                            }
                            stream_Field.reset();

                            adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                    }

                }

                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (final RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
            // do for sure before leaving
        }
        return retval;
    }

    // $ANTLR end "record"

    public static class attributeModifiers_return extends ParserRuleReturnScope {
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "attributeModifiers"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:245:1: attributeModifiers : ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket ) -> ^( MODIFIERS ( attributeModifierAssignment )+ ) ;
    public final ImpexParser.attributeModifiers_return attributeModifiers() throws RecognitionException {
        final ImpexParser.attributeModifiers_return retval = new ImpexParser.attributeModifiers_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LBracket33 = null;
        Token Comma35 = null;
        Token RBracket37 = null;
        ImpexParser.attributeModifierAssignment_return attributeModifierAssignment34 = null;

        ImpexParser.attributeModifierAssignment_return attributeModifierAssignment36 = null;

        final CommonTree LBracket33_tree = null;
        final CommonTree Comma35_tree = null;
        final CommonTree RBracket37_tree = null;
        final RewriteRuleTokenStream stream_RBracket = new RewriteRuleTokenStream(adaptor, "token RBracket");
        final RewriteRuleTokenStream stream_LBracket = new RewriteRuleTokenStream(adaptor, "token LBracket");
        final RewriteRuleTokenStream stream_Comma = new RewriteRuleTokenStream(adaptor, "token Comma");
        final RewriteRuleSubtreeStream stream_attributeModifierAssignment = new RewriteRuleSubtreeStream(adaptor,
                "rule attributeModifierAssignment");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:246:2: ( ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket ) -> ^( MODIFIERS ( attributeModifierAssignment )+ ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:246:4: ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:246:4: ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket )
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:246:5: LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket
                {
                    LBracket33 = (Token) match(input, LBracket, FOLLOW_LBracket_in_attributeModifiers504);
                    stream_LBracket.add(LBracket33);

                    pushFollow(FOLLOW_attributeModifierAssignment_in_attributeModifiers506);
                    attributeModifierAssignment34 = attributeModifierAssignment();

                    state._fsp--;

                    stream_attributeModifierAssignment.add(attributeModifierAssignment34.getTree());

                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:246:42: ( Comma attributeModifierAssignment )*
                    loop17: do {
                        int alt17 = 2;
                        final int LA17_0 = input.LA(1);

                        if ((LA17_0 == Comma)) {
                            alt17 = 1;
                        }

                        switch (alt17) {
                            case 1:
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:246:43: Comma attributeModifierAssignment
                            {
                                Comma35 = (Token) match(input, Comma, FOLLOW_Comma_in_attributeModifiers509);
                                stream_Comma.add(Comma35);

                                pushFollow(FOLLOW_attributeModifierAssignment_in_attributeModifiers512);
                                attributeModifierAssignment36 = attributeModifierAssignment();

                                state._fsp--;

                                stream_attributeModifierAssignment.add(attributeModifierAssignment36.getTree());

                            }
                                break;

                            default:
                                break loop17;
                        }
                    } while (true);

                    RBracket37 = (Token) match(input, RBracket, FOLLOW_RBracket_in_attributeModifiers516);
                    stream_RBracket.add(RBracket37);

                }

                // AST REWRITE
                // elements: attributeModifierAssignment
                // token labels: 
                // rule labels: retval
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                retval.tree = root_0;
                final RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
                        retval != null ? retval.tree : null);

                root_0 = (CommonTree) adaptor.nil();
                // 247:2: -> ^( MODIFIERS ( attributeModifierAssignment )+ )
                {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:247:5: ^( MODIFIERS ( attributeModifierAssignment )+ )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(MODIFIERS, "MODIFIERS"), root_1);

                        if (!(stream_attributeModifierAssignment.hasNext())) {
                            throw new RewriteEarlyExitException();
                        }
                        while (stream_attributeModifierAssignment.hasNext()) {
                            adaptor.addChild(root_1, stream_attributeModifierAssignment.nextTree());

                        }
                        stream_attributeModifierAssignment.reset();

                        adaptor.addChild(root_0, root_1);
                    }

                }

                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (final RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
            // do for sure before leaving
        }
        return retval;
    }

    // $ANTLR end "attributeModifiers"

    public static class attributeModifierAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "attributeModifierAssignment"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:249:1: attributeModifierAssignment : attributeModifier ValueAssignement -> ^( MODIFIER attributeModifier ValueAssignement ) ;
    public final ImpexParser.attributeModifierAssignment_return attributeModifierAssignment() throws RecognitionException {
        final ImpexParser.attributeModifierAssignment_return retval = new ImpexParser.attributeModifierAssignment_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ValueAssignement39 = null;
        ImpexParser.attributeModifier_return attributeModifier38 = null;

        final CommonTree ValueAssignement39_tree = null;
        final RewriteRuleTokenStream stream_ValueAssignement = new RewriteRuleTokenStream(adaptor, "token ValueAssignement");
        final RewriteRuleSubtreeStream stream_attributeModifier = new RewriteRuleSubtreeStream(adaptor, "rule attributeModifier");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:250:2: ( attributeModifier ValueAssignement -> ^( MODIFIER attributeModifier ValueAssignement ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:250:4: attributeModifier ValueAssignement
            {
                pushFollow(FOLLOW_attributeModifier_in_attributeModifierAssignment536);
                attributeModifier38 = attributeModifier();

                state._fsp--;

                stream_attributeModifier.add(attributeModifier38.getTree());

                ValueAssignement39 = (Token) match(input, ValueAssignement, FOLLOW_ValueAssignement_in_attributeModifierAssignment538);
                stream_ValueAssignement.add(ValueAssignement39);

                // AST REWRITE
                // elements: attributeModifier, ValueAssignement
                // token labels: 
                // rule labels: retval
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                retval.tree = root_0;
                final RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
                        retval != null ? retval.tree : null);

                root_0 = (CommonTree) adaptor.nil();
                // 251:2: -> ^( MODIFIER attributeModifier ValueAssignement )
                {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:251:5: ^( MODIFIER attributeModifier ValueAssignement )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(MODIFIER, "MODIFIER"), root_1);

                        adaptor.addChild(root_1, stream_attributeModifier.nextTree());

                        adaptor.addChild(root_1, stream_ValueAssignement.nextNode());

                        adaptor.addChild(root_0, root_1);
                    }

                }

                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (final RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
            // do for sure before leaving
        }
        return retval;
    }

    // $ANTLR end "attributeModifierAssignment"

    public static class attributeName_return extends ParserRuleReturnScope {
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "attributeName"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:257:1: attributeName : ( Macrodef -> ^( MACRO_REF Macrodef ) | SpecialAttribute -> ^( ATTRIBUTE_NAME SpecialAttribute ) | ( Identifier ( Dot attributeName )? ) -> ^( ATTRIBUTE_NAME Identifier ( attributeName )? ) );
    public final ImpexParser.attributeName_return attributeName() throws RecognitionException {
        final ImpexParser.attributeName_return retval = new ImpexParser.attributeName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Macrodef40 = null;
        Token SpecialAttribute41 = null;
        Token Identifier42 = null;
        Token Dot43 = null;
        ImpexParser.attributeName_return attributeName44 = null;

        final CommonTree Macrodef40_tree = null;
        final CommonTree SpecialAttribute41_tree = null;
        final CommonTree Identifier42_tree = null;
        final CommonTree Dot43_tree = null;
        final RewriteRuleTokenStream stream_Dot = new RewriteRuleTokenStream(adaptor, "token Dot");
        final RewriteRuleTokenStream stream_SpecialAttribute = new RewriteRuleTokenStream(adaptor, "token SpecialAttribute");
        final RewriteRuleTokenStream stream_Macrodef = new RewriteRuleTokenStream(adaptor, "token Macrodef");
        final RewriteRuleTokenStream stream_Identifier = new RewriteRuleTokenStream(adaptor, "token Identifier");
        final RewriteRuleSubtreeStream stream_attributeName = new RewriteRuleSubtreeStream(adaptor, "rule attributeName");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:258:2: ( Macrodef -> ^( MACRO_REF Macrodef ) | SpecialAttribute -> ^( ATTRIBUTE_NAME SpecialAttribute ) | ( Identifier ( Dot attributeName )? ) -> ^( ATTRIBUTE_NAME Identifier ( attributeName )? ) )
            int alt19 = 3;
            switch (input.LA(1)) {
                case Macrodef: {
                    alt19 = 1;
                }
                    break;
                case SpecialAttribute: {
                    alt19 = 2;
                }
                    break;
                case Identifier: {
                    alt19 = 3;
                }
                    break;
                default:
                    final NoViableAltException nvae = new NoViableAltException("", 19, 0, input);

                    throw nvae;

            }

            switch (alt19) {
                case 1:
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:258:3: Macrodef
                {
                    Macrodef40 = (Token) match(input, Macrodef, FOLLOW_Macrodef_in_attributeName563);
                    stream_Macrodef.add(Macrodef40);

                    // AST REWRITE
                    // elements: Macrodef
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    final RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
                            retval != null ? retval.tree : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 258:12: -> ^( MACRO_REF Macrodef )
                    {
                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:258:15: ^( MACRO_REF Macrodef )
                        {
                            CommonTree root_1 = (CommonTree) adaptor.nil();
                            root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(MACRO_REF, "MACRO_REF"), root_1);

                            adaptor.addChild(root_1, stream_Macrodef.nextNode());

                            adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;

                }
                    break;
                case 2:
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:259:4: SpecialAttribute
                {
                    SpecialAttribute41 = (Token) match(input, SpecialAttribute, FOLLOW_SpecialAttribute_in_attributeName577);
                    stream_SpecialAttribute.add(SpecialAttribute41);

                    // AST REWRITE
                    // elements: SpecialAttribute
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    final RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
                            retval != null ? retval.tree : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 259:21: -> ^( ATTRIBUTE_NAME SpecialAttribute )
                    {
                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:259:24: ^( ATTRIBUTE_NAME SpecialAttribute )
                        {
                            CommonTree root_1 = (CommonTree) adaptor.nil();
                            root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(ATTRIBUTE_NAME, "ATTRIBUTE_NAME"), root_1);

                            adaptor.addChild(root_1, stream_SpecialAttribute.nextNode());

                            adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;

                }
                    break;
                case 3:
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:260:3: ( Identifier ( Dot attributeName )? )
                {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:260:3: ( Identifier ( Dot attributeName )? )
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:260:4: Identifier ( Dot attributeName )?
                    {
                        Identifier42 = (Token) match(input, Identifier, FOLLOW_Identifier_in_attributeName590);
                        stream_Identifier.add(Identifier42);

                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:260:15: ( Dot attributeName )?
                        int alt18 = 2;
                        final int LA18_0 = input.LA(1);

                        if ((LA18_0 == Dot)) {
                            alt18 = 1;
                        }
                        switch (alt18) {
                            case 1:
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:260:16: Dot attributeName
                            {
                                Dot43 = (Token) match(input, Dot, FOLLOW_Dot_in_attributeName593);
                                stream_Dot.add(Dot43);

                                pushFollow(FOLLOW_attributeName_in_attributeName595);
                                attributeName44 = attributeName();

                                state._fsp--;

                                stream_attributeName.add(attributeName44.getTree());

                            }
                                break;

                        }

                    }

                    // AST REWRITE
                    // elements: attributeName, Identifier
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    final RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
                            retval != null ? retval.tree : null);

                    root_0 = (CommonTree) adaptor.nil();
                    // 260:37: -> ^( ATTRIBUTE_NAME Identifier ( attributeName )? )
                    {
                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:260:40: ^( ATTRIBUTE_NAME Identifier ( attributeName )? )
                        {
                            CommonTree root_1 = (CommonTree) adaptor.nil();
                            root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(ATTRIBUTE_NAME, "ATTRIBUTE_NAME"), root_1);

                            adaptor.addChild(root_1, stream_Identifier.nextNode());

                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:260:68: ( attributeName )?
                            if (stream_attributeName.hasNext()) {
                                adaptor.addChild(root_1, stream_attributeName.nextTree());

                            }
                            stream_attributeName.reset();

                            adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;

                }
                    break;

            }
            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (final RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
            // do for sure before leaving
        }
        return retval;
    }

    // $ANTLR end "attributeName"

    public static class attribute_return extends ParserRuleReturnScope {
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "attribute"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:262:1: attribute : attributeName ( LParenthesis ( DocumentID | attribute ) ( Comma ( DocumentID | attribute ) )* RParenthesis )? ( attributeModifiers )* -> ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifiers )* ) ) ;
    public final ImpexParser.attribute_return attribute() throws RecognitionException {
        final ImpexParser.attribute_return retval = new ImpexParser.attribute_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LParenthesis46 = null;
        Token DocumentID47 = null;
        Token Comma49 = null;
        Token DocumentID50 = null;
        Token RParenthesis52 = null;
        ImpexParser.attributeName_return attributeName45 = null;

        ImpexParser.attribute_return attribute48 = null;

        ImpexParser.attribute_return attribute51 = null;

        ImpexParser.attributeModifiers_return attributeModifiers53 = null;

        final CommonTree LParenthesis46_tree = null;
        final CommonTree DocumentID47_tree = null;
        final CommonTree Comma49_tree = null;
        final CommonTree DocumentID50_tree = null;
        final CommonTree RParenthesis52_tree = null;
        final RewriteRuleTokenStream stream_DocumentID = new RewriteRuleTokenStream(adaptor, "token DocumentID");
        final RewriteRuleTokenStream stream_Comma = new RewriteRuleTokenStream(adaptor, "token Comma");
        final RewriteRuleTokenStream stream_LParenthesis = new RewriteRuleTokenStream(adaptor, "token LParenthesis");
        final RewriteRuleTokenStream stream_RParenthesis = new RewriteRuleTokenStream(adaptor, "token RParenthesis");
        final RewriteRuleSubtreeStream stream_attributeName = new RewriteRuleSubtreeStream(adaptor, "rule attributeName");
        final RewriteRuleSubtreeStream stream_attribute = new RewriteRuleSubtreeStream(adaptor, "rule attribute");
        final RewriteRuleSubtreeStream stream_attributeModifiers = new RewriteRuleSubtreeStream(adaptor, "rule attributeModifiers");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:263:2: ( attributeName ( LParenthesis ( DocumentID | attribute ) ( Comma ( DocumentID | attribute ) )* RParenthesis )? ( attributeModifiers )* -> ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifiers )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:263:3: attributeName ( LParenthesis ( DocumentID | attribute ) ( Comma ( DocumentID | attribute ) )* RParenthesis )? ( attributeModifiers )*
            {
                pushFollow(FOLLOW_attributeName_in_attribute619);
                attributeName45 = attributeName();

                state._fsp--;

                stream_attributeName.add(attributeName45.getTree());

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:263:17: ( LParenthesis ( DocumentID | attribute ) ( Comma ( DocumentID | attribute ) )* RParenthesis )?
                int alt23 = 2;
                final int LA23_0 = input.LA(1);

                if ((LA23_0 == LParenthesis)) {
                    alt23 = 1;
                }
                switch (alt23) {
                    case 1:
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:263:18: LParenthesis ( DocumentID | attribute ) ( Comma ( DocumentID | attribute ) )* RParenthesis
                    {
                        LParenthesis46 = (Token) match(input, LParenthesis, FOLLOW_LParenthesis_in_attribute622);
                        stream_LParenthesis.add(LParenthesis46);

                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:263:32: ( DocumentID | attribute )
                        int alt20 = 2;
                        final int LA20_0 = input.LA(1);

                        if ((LA20_0 == DocumentID)) {
                            alt20 = 1;
                        } else if ((LA20_0 == Identifier || LA20_0 == Macrodef || LA20_0 == SpecialAttribute)) {
                            alt20 = 2;
                        } else {
                            final NoViableAltException nvae = new NoViableAltException("", 20, 0, input);

                            throw nvae;

                        }
                        switch (alt20) {
                            case 1:
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:263:33: DocumentID
                            {
                                DocumentID47 = (Token) match(input, DocumentID, FOLLOW_DocumentID_in_attribute626);
                                stream_DocumentID.add(DocumentID47);

                            }
                                break;
                            case 2:
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:263:46: attribute
                            {
                                pushFollow(FOLLOW_attribute_in_attribute630);
                                attribute48 = attribute();

                                state._fsp--;

                                stream_attribute.add(attribute48.getTree());

                            }
                                break;

                        }

                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:263:56: ( Comma ( DocumentID | attribute ) )*
                        loop22: do {
                            int alt22 = 2;
                            final int LA22_0 = input.LA(1);

                            if ((LA22_0 == Comma)) {
                                alt22 = 1;
                            }

                            switch (alt22) {
                                case 1:
                                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:263:57: Comma ( DocumentID | attribute )
                                {
                                    Comma49 = (Token) match(input, Comma, FOLLOW_Comma_in_attribute633);
                                    stream_Comma.add(Comma49);

                                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:263:63: ( DocumentID | attribute )
                                    int alt21 = 2;
                                    final int LA21_0 = input.LA(1);

                                    if ((LA21_0 == DocumentID)) {
                                        alt21 = 1;
                                    } else if ((LA21_0 == Identifier || LA21_0 == Macrodef || LA21_0 == SpecialAttribute)) {
                                        alt21 = 2;
                                    } else {
                                        final NoViableAltException nvae = new NoViableAltException("", 21, 0, input);

                                        throw nvae;

                                    }
                                    switch (alt21) {
                                        case 1:
                                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:263:64: DocumentID
                                        {
                                            DocumentID50 = (Token) match(input, DocumentID, FOLLOW_DocumentID_in_attribute636);
                                            stream_DocumentID.add(DocumentID50);

                                        }
                                            break;
                                        case 2:
                                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:263:77: attribute
                                        {
                                            pushFollow(FOLLOW_attribute_in_attribute640);
                                            attribute51 = attribute();

                                            state._fsp--;

                                            stream_attribute.add(attribute51.getTree());

                                        }
                                            break;

                                    }

                                }
                                    break;

                                default:
                                    break loop22;
                            }
                        } while (true);

                        RParenthesis52 = (Token) match(input, RParenthesis, FOLLOW_RParenthesis_in_attribute645);
                        stream_RParenthesis.add(RParenthesis52);

                    }
                        break;

                }

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:264:4: ( attributeModifiers )*
                loop24: do {
                    int alt24 = 2;
                    final int LA24_0 = input.LA(1);

                    if ((LA24_0 == LBracket)) {
                        alt24 = 1;
                    }

                    switch (alt24) {
                        case 1:
                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:264:4: attributeModifiers
                        {
                            pushFollow(FOLLOW_attributeModifiers_in_attribute653);
                            attributeModifiers53 = attributeModifiers();

                            state._fsp--;

                            stream_attributeModifiers.add(attributeModifiers53.getTree());

                        }
                            break;

                        default:
                            break loop24;
                    }
                } while (true);

                // AST REWRITE
                // elements: attributeModifiers, attribute, DocumentID, attributeName
                // token labels: 
                // rule labels: retval
                // token list labels: 
                // rule list labels: 
                // wildcard labels: 
                retval.tree = root_0;
                final RewriteRuleSubtreeStream stream_retval = new RewriteRuleSubtreeStream(adaptor, "rule retval",
                        retval != null ? retval.tree : null);

                root_0 = (CommonTree) adaptor.nil();
                // 265:2: -> ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifiers )* ) )
                {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:265:5: ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifiers )* ) )
                    {
                        CommonTree root_1 = (CommonTree) adaptor.nil();
                        root_1 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(ATTRIBUTE, "ATTRIBUTE"), root_1);

                        adaptor.addChild(root_1, stream_attributeName.nextTree());

                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:265:31: ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) )
                        {
                            CommonTree root_2 = (CommonTree) adaptor.nil();
                            root_2 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(ITEM_EXPRESSION, "ITEM_EXPRESSION"),
                                    root_2);

                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:265:49: ( attribute )*
                            while (stream_attribute.hasNext()) {
                                adaptor.addChild(root_2, stream_attribute.nextTree());

                            }
                            stream_attribute.reset();

                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:265:60: ^( DOCUMENTID_REF ( DocumentID )* )
                            {
                                CommonTree root_3 = (CommonTree) adaptor.nil();
                                root_3 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(DOCUMENTID_REF, "DOCUMENTID_REF"),
                                        root_3);

                                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:265:77: ( DocumentID )*
                                while (stream_DocumentID.hasNext()) {
                                    adaptor.addChild(root_3, stream_DocumentID.nextNode());

                                }
                                stream_DocumentID.reset();

                                adaptor.addChild(root_2, root_3);
                            }

                            adaptor.addChild(root_1, root_2);
                        }

                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:265:91: ^( MODIFIERS ( attributeModifiers )* )
                        {
                            CommonTree root_2 = (CommonTree) adaptor.nil();
                            root_2 = (CommonTree) adaptor.becomeRoot((CommonTree) adaptor.create(MODIFIERS, "MODIFIERS"), root_2);

                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:265:103: ( attributeModifiers )*
                            while (stream_attributeModifiers.hasNext()) {
                                adaptor.addChild(root_2, stream_attributeModifiers.nextTree());

                            }
                            stream_attributeModifiers.reset();

                            adaptor.addChild(root_1, root_2);
                        }

                        adaptor.addChild(root_0, root_1);
                    }

                }

                retval.tree = root_0;

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (final RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
            // do for sure before leaving
        }
        return retval;
    }

    // $ANTLR end "attribute"

    public static class macro_return extends ParserRuleReturnScope {
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "macro"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:273:1: macro : Macrodef ValueAssignement ;
    public final ImpexParser.macro_return macro() throws RecognitionException {
        final ImpexParser.macro_return retval = new ImpexParser.macro_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Macrodef54 = null;
        Token ValueAssignement55 = null;

        CommonTree Macrodef54_tree = null;
        CommonTree ValueAssignement55_tree = null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:274:2: ( Macrodef ValueAssignement )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:274:3: Macrodef ValueAssignement
            {
                root_0 = (CommonTree) adaptor.nil();

                Macrodef54 = (Token) match(input, Macrodef, FOLLOW_Macrodef_in_macro701);
                Macrodef54_tree = (CommonTree) adaptor.create(Macrodef54);
                adaptor.addChild(root_0, Macrodef54_tree);

                ValueAssignement55 = (Token) match(input, ValueAssignement, FOLLOW_ValueAssignement_in_macro703);
                ValueAssignement55_tree = (CommonTree) adaptor.create(ValueAssignement55);
                adaptor.addChild(root_0, ValueAssignement55_tree);

                registerMacro(Macrodef54, (ValueAssignement55 != null ? ValueAssignement55.getText() : null));

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (final RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
            // do for sure before leaving
        }
        return retval;
    }

    // $ANTLR end "macro"

    public static class attributeModifier_return extends ParserRuleReturnScope {
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "attributeModifier"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:278:1: attributeModifier : ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual );
    public final ImpexParser.attributeModifier_return attributeModifier() throws RecognitionException {
        final ImpexParser.attributeModifier_return retval = new ImpexParser.attributeModifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set56 = null;

        final CommonTree set56_tree = null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:279:2: ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
                root_0 = (CommonTree) adaptor.nil();

                set56 = (Token) input.LT(1);

                if ((input.LA(1) >= Alias && input.LA(1) <= AllowNull) || input.LA(1) == CellDecorator
                        || input.LA(1) == CollectionDelimiter || (input.LA(1) >= Dateformat && input.LA(1) <= Default)
                        || input.LA(1) == ForceWrite || (input.LA(1) >= IgnoreKeyCase && input.LA(1) <= IgnoreNull)
                        || input.LA(1) == KeyToValueDelimiter || input.LA(1) == Lang
                        || (input.LA(1) >= MapDelimiter && input.LA(1) <= Mode) || input.LA(1) == NumberFormat
                        || (input.LA(1) >= PathDelimiter && input.LA(1) <= Pos) || (input.LA(1) >= Translator && input.LA(1) <= Unique)
                        || input.LA(1) == Virtual) {
                    input.consume();
                    adaptor.addChild(root_0, (CommonTree) adaptor.create(set56));
                    state.errorRecovery = false;
                } else {
                    final MismatchedSetException mse = new MismatchedSetException(null, input);
                    throw mse;
                }

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (final RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
            // do for sure before leaving
        }
        return retval;
    }

    // $ANTLR end "attributeModifier"

    public static class headerMode_return extends ParserRuleReturnScope {
        CommonTree tree;

        public Object getTree() {
            return tree;
        }
    };

    // $ANTLR start "headerMode"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:282:1: headerMode : ( Insert | InsertUpdate | Update | Remove );
    public final ImpexParser.headerMode_return headerMode() throws RecognitionException {
        final ImpexParser.headerMode_return retval = new ImpexParser.headerMode_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set57 = null;

        final CommonTree set57_tree = null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:283:2: ( Insert | InsertUpdate | Update | Remove )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
                root_0 = (CommonTree) adaptor.nil();

                set57 = (Token) input.LT(1);

                if ((input.LA(1) >= Insert && input.LA(1) <= InsertUpdate) || input.LA(1) == Remove || input.LA(1) == Update) {
                    input.consume();
                    adaptor.addChild(root_0, (CommonTree) adaptor.create(set57));
                    state.errorRecovery = false;
                } else {
                    final MismatchedSetException mse = new MismatchedSetException(null, input);
                    throw mse;
                }

            }

            retval.stop = input.LT(-1);

            retval.tree = (CommonTree) adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        } catch (final RecognitionException re) {
            reportError(re);
            recover(input, re);
            retval.tree = (CommonTree) adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
            // do for sure before leaving
        }
        return retval;
    }

    // $ANTLR end "headerMode"

    // Delegated rules

    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS = "\7\uffff";
    static final String DFA6_eofS = "\1\1\1\uffff\1\1\2\uffff\2\1";
    static final String DFA6_minS = "\1\50\1\uffff\1\36\1\110\1\uffff\2\36";
    static final String DFA6_maxS = "\1\107\1\uffff\1\107\1\110\1\uffff\2\107";
    static final String DFA6_acceptS = "\1\uffff\1\2\2\uffff\1\1\2\uffff";
    static final String DFA6_specialS = "\7\uffff}>";
    static final String[] DFA6_transitionS = { "\2\1\4\uffff\1\2\3\uffff\1\1\15\uffff\1\1\6\uffff\1\1", "",
            "\1\4\6\uffff\1\4\2\uffff\2\1\4\uffff\1\2\3\uffff\1\3\10\uffff" + "\1\4\4\uffff\1\1\6\uffff\1\1", "\1\5", "",
            "\1\4\6\uffff\1\4\2\uffff\2\1\4\uffff\1\6\3\uffff\1\3\10\uffff" + "\1\4\4\uffff\1\1\6\uffff\1\1",
            "\1\4\6\uffff\1\4\2\uffff\2\1\4\uffff\1\1\3\uffff\1\3\10\uffff" + "\1\4\4\uffff\1\1\6\uffff\1\1" };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        final int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i = 0; i < numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(final BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }

        public String getDescription() {
            return "()+ loopback of 201:16: ( ( Lb )+ ( macro ( Lb )? )* record )+";
        }
    }

    public static final BitSet FOLLOW_EOF_in_parse178 = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_Lb_in_impex190 = new BitSet(new long[] { 0x0004430000000000L, 0x0000000000000081L });
    public static final BitSet FOLLOW_block_in_impex195 = new BitSet(new long[] { 0x0004430000000000L, 0x0000000000000081L });
    public static final BitSet FOLLOW_macro_in_impex199 = new BitSet(new long[] { 0x0004430000000000L, 0x0000000000000081L });
    public static final BitSet FOLLOW_EOF_in_impex203 = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_header_in_block226 = new BitSet(new long[] { 0x0000400000000000L });
    public static final BitSet FOLLOW_Lb_in_block229 = new BitSet(new long[] { 0x0804402040000000L });
    public static final BitSet FOLLOW_macro_in_block233 = new BitSet(new long[] { 0x0804402040000000L });
    public static final BitSet FOLLOW_Lb_in_block235 = new BitSet(new long[] { 0x0804002040000000L });
    public static final BitSet FOLLOW_record_in_block240 = new BitSet(new long[] { 0x0000400000000002L });
    public static final BitSet FOLLOW_headerMode_in_header267 = new BitSet(new long[] { 0x0000002000000000L });
    public static final BitSet FOLLOW_Identifier_in_header270 = new BitSet(new long[] { 0x0000080000000002L, 0x0000000000000004L });
    public static final BitSet FOLLOW_headerModifiers_in_header272 = new BitSet(new long[] { 0x0000000000000002L, 0x0000000000000004L });
    public static final BitSet FOLLOW_Semicolon_in_header277 = new BitSet(new long[] { 0x0004002000000002L, 0x000000000000000CL });
    public static final BitSet FOLLOW_attribute_in_header279 = new BitSet(new long[] { 0x0000000000000002L, 0x0000000000000004L });
    public static final BitSet FOLLOW_Semicolon_in_header285 = new BitSet(new long[] { 0x0000000002000000L });
    public static final BitSet FOLLOW_DocumentID_in_header287 = new BitSet(new long[] { 0x0000000000000002L, 0x0000000000000004L });
    public static final BitSet FOLLOW_Semicolon_in_header289 = new BitSet(new long[] { 0x0004002000000002L, 0x000000000000000CL });
    public static final BitSet FOLLOW_attribute_in_header291 = new BitSet(new long[] { 0x0000000000000002L, 0x0000000000000004L });
    public static final BitSet FOLLOW_LBracket_in_headerModifiers345 = new BitSet(new long[] { 0x0400000000005000L });
    public static final BitSet FOLLOW_headerModifierAssignment_in_headerModifiers347 = new BitSet(new long[] { 0x1000000000080000L });
    public static final BitSet FOLLOW_Comma_in_headerModifiers350 = new BitSet(new long[] { 0x0400000000005000L });
    public static final BitSet FOLLOW_headerModifierAssignment_in_headerModifiers353 = new BitSet(new long[] { 0x1000000000080000L });
    public static final BitSet FOLLOW_RBracket_in_headerModifiers357 = new BitSet(new long[] { 0x0000080000000002L });
    public static final BitSet FOLLOW_headerModifier_in_headerModifierAssignment376 = new BitSet(new long[] { 0x0000000010000000L });
    public static final BitSet FOLLOW_Equals_in_headerModifierAssignment378 = new BitSet(new long[] { 0x0000000000022000L });
    public static final BitSet FOLLOW_boolOrClassname_in_headerModifierAssignment380 = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_Identifier_in_record433 = new BitSet(new long[] { 0x0800000040000000L });
    public static final BitSet FOLLOW_QuotedField_in_record437 = new BitSet(new long[] { 0x0800000040000002L });
    public static final BitSet FOLLOW_Field_in_record441 = new BitSet(new long[] { 0x0800000040000002L });
    public static final BitSet FOLLOW_LBracket_in_attributeModifiers504 = new BitSet(
            new long[] { 0x035824C081848180L, 0x0000000000000260L });
    public static final BitSet FOLLOW_attributeModifierAssignment_in_attributeModifiers506 = new BitSet(new long[] { 0x1000000000080000L });
    public static final BitSet FOLLOW_Comma_in_attributeModifiers509 = new BitSet(new long[] { 0x035824C081848180L, 0x0000000000000260L });
    public static final BitSet FOLLOW_attributeModifierAssignment_in_attributeModifiers512 = new BitSet(new long[] { 0x1000000000080000L });
    public static final BitSet FOLLOW_RBracket_in_attributeModifiers516 = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_attributeModifier_in_attributeModifierAssignment536 = new BitSet(new long[] { 0x0000000000000000L,
            0x0000000000000100L });
    public static final BitSet FOLLOW_ValueAssignement_in_attributeModifierAssignment538 = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_Macrodef_in_attributeName563 = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_SpecialAttribute_in_attributeName577 = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_Identifier_in_attributeName590 = new BitSet(new long[] { 0x0000000004000002L });
    public static final BitSet FOLLOW_Dot_in_attributeName593 = new BitSet(new long[] { 0x0004002000000000L, 0x0000000000000008L });
    public static final BitSet FOLLOW_attributeName_in_attributeName595 = new BitSet(new long[] { 0x0000000000000002L });
    public static final BitSet FOLLOW_attributeName_in_attribute619 = new BitSet(new long[] { 0x0000180000000002L });
    public static final BitSet FOLLOW_LParenthesis_in_attribute622 = new BitSet(new long[] { 0x0004002002000000L, 0x0000000000000008L });
    public static final BitSet FOLLOW_DocumentID_in_attribute626 = new BitSet(new long[] { 0x8000000000080000L });
    public static final BitSet FOLLOW_attribute_in_attribute630 = new BitSet(new long[] { 0x8000000000080000L });
    public static final BitSet FOLLOW_Comma_in_attribute633 = new BitSet(new long[] { 0x0004002002000000L, 0x0000000000000008L });
    public static final BitSet FOLLOW_DocumentID_in_attribute636 = new BitSet(new long[] { 0x8000000000080000L });
    public static final BitSet FOLLOW_attribute_in_attribute640 = new BitSet(new long[] { 0x8000000000080000L });
    public static final BitSet FOLLOW_RParenthesis_in_attribute645 = new BitSet(new long[] { 0x0000080000000002L });
    public static final BitSet FOLLOW_attributeModifiers_in_attribute653 = new BitSet(new long[] { 0x0000080000000002L });
    public static final BitSet FOLLOW_Macrodef_in_macro701 = new BitSet(new long[] { 0x0000000000000000L, 0x0000000000000100L });
    public static final BitSet FOLLOW_ValueAssignement_in_macro703 = new BitSet(new long[] { 0x0000000000000002L });

}