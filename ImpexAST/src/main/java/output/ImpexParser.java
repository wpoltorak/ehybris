// $ANTLR 3.4 /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g 2012-11-01 17:02:56

  package output;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class ImpexParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGNEMENT", "ASSIGNEMENTS", "ATTRIBUTE", "ATTRIBUTES", "Alias", "AllowNull", "BLOCK", "BLOCKS", "BatchMode", "Bool", "CacheUnique", "CellDecorator", "Char", "CollectionDelimiter", "Comment", "Dateformat", "Default", "DoubleQuote", "Equals", "FIELDS", "Field", "ForceWrite", "HEADER", "IMPEX", "Identifier", "IgnoreKeyCase", "IgnoreNull", "Insert", "InsertUpdate", "KeyToValueDelimiter", "Lang", "Lb", "LeftBracket", "LeftParenthesis", "LineContinuation", "MODIFIER", "Macrodef", "Macroval", "MapDelimiter", "Mode", "NumberFormat", "PathDelimiter", "Pos", "Processor", "QuotedField", "RECORD", "RECORDS", "Remove", "RightBracket", "RightParenthesis", "SUBTYPE", "Semicolon", "TYPE", "Translator", "Unique", "Update", "Virtual", "Ws", "','", "'.'"
    };

    public static final int EOF=-1;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int ASSIGNEMENT=4;
    public static final int ASSIGNEMENTS=5;
    public static final int ATTRIBUTE=6;
    public static final int ATTRIBUTES=7;
    public static final int Alias=8;
    public static final int AllowNull=9;
    public static final int BLOCK=10;
    public static final int BLOCKS=11;
    public static final int BatchMode=12;
    public static final int Bool=13;
    public static final int CacheUnique=14;
    public static final int CellDecorator=15;
    public static final int Char=16;
    public static final int CollectionDelimiter=17;
    public static final int Comment=18;
    public static final int Dateformat=19;
    public static final int Default=20;
    public static final int DoubleQuote=21;
    public static final int Equals=22;
    public static final int FIELDS=23;
    public static final int Field=24;
    public static final int ForceWrite=25;
    public static final int HEADER=26;
    public static final int IMPEX=27;
    public static final int Identifier=28;
    public static final int IgnoreKeyCase=29;
    public static final int IgnoreNull=30;
    public static final int Insert=31;
    public static final int InsertUpdate=32;
    public static final int KeyToValueDelimiter=33;
    public static final int Lang=34;
    public static final int Lb=35;
    public static final int LeftBracket=36;
    public static final int LeftParenthesis=37;
    public static final int LineContinuation=38;
    public static final int MODIFIER=39;
    public static final int Macrodef=40;
    public static final int Macroval=41;
    public static final int MapDelimiter=42;
    public static final int Mode=43;
    public static final int NumberFormat=44;
    public static final int PathDelimiter=45;
    public static final int Pos=46;
    public static final int Processor=47;
    public static final int QuotedField=48;
    public static final int RECORD=49;
    public static final int RECORDS=50;
    public static final int Remove=51;
    public static final int RightBracket=52;
    public static final int RightParenthesis=53;
    public static final int SUBTYPE=54;
    public static final int Semicolon=55;
    public static final int TYPE=56;
    public static final int Translator=57;
    public static final int Unique=58;
    public static final int Update=59;
    public static final int Virtual=60;
    public static final int Ws=61;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public ImpexParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public ImpexParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return ImpexParser.tokenNames; }
    public String getGrammarFileName() { return "/work/projects/yeclipse/ImpexAST/src/main/java/Impex.g"; }


    public static class parse_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parse"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:104:1: parse : (t= . )* EOF ;
    public final ImpexParser.parse_return parse() throws RecognitionException {
        ImpexParser.parse_return retval = new ImpexParser.parse_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token t=null;
        Token EOF1=null;

        CommonTree t_tree=null;
        CommonTree EOF1_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:105:3: ( (t= . )* EOF )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:105:6: (t= . )* EOF
            {
            root_0 = (CommonTree)adaptor.nil();


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:105:6: (t= . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= ASSIGNEMENT && LA1_0 <= 63)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:105:7: t= .
            	    {
            	    t=(Token)input.LT(1);

            	    matchAny(input); 
            	    t_tree = (CommonTree)adaptor.create(t);
            	    adaptor.addChild(root_0, t_tree);


            	    System.out.printf("%s: %-7s \n", tokenNames[(t!=null?t.getType():0)], (t!=null?t.getText():null));

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            EOF1=(Token)match(input,EOF,FOLLOW_EOF_in_parse153); 
            EOF1_tree = 
            (CommonTree)adaptor.create(EOF1)
            ;
            adaptor.addChild(root_0, EOF1_tree);


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "parse"


    public static class impex_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "impex"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:107:1: impex : ( Lb | block | macro )* EOF -> ^( IMPEX ^( ASSIGNEMENTS ( macro )* ) ^( BLOCKS ( block )* ) ) ;
    public final ImpexParser.impex_return impex() throws RecognitionException {
        ImpexParser.impex_return retval = new ImpexParser.impex_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Lb2=null;
        Token EOF5=null;
        ImpexParser.block_return block3 =null;

        ImpexParser.macro_return macro4 =null;


        CommonTree Lb2_tree=null;
        CommonTree EOF5_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleTokenStream stream_Lb=new RewriteRuleTokenStream(adaptor,"token Lb");
        RewriteRuleSubtreeStream stream_macro=new RewriteRuleSubtreeStream(adaptor,"rule macro");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:107:7: ( ( Lb | block | macro )* EOF -> ^( IMPEX ^( ASSIGNEMENTS ( macro )* ) ^( BLOCKS ( block )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:107:9: ( Lb | block | macro )* EOF
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:107:9: ( Lb | block | macro )*
            loop2:
            do {
                int alt2=4;
                switch ( input.LA(1) ) {
                case Lb:
                    {
                    alt2=1;
                    }
                    break;
                case Insert:
                case InsertUpdate:
                case Remove:
                case Update:
                    {
                    alt2=2;
                    }
                    break;
                case Macrodef:
                    {
                    alt2=3;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:107:10: Lb
            	    {
            	    Lb2=(Token)match(input,Lb,FOLLOW_Lb_in_impex165);  
            	    stream_Lb.add(Lb2);


            	    }
            	    break;
            	case 2 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:107:16: block
            	    {
            	    pushFollow(FOLLOW_block_in_impex170);
            	    block3=block();

            	    state._fsp--;

            	    stream_block.add(block3.getTree());

            	    }
            	    break;
            	case 3 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:107:24: macro
            	    {
            	    pushFollow(FOLLOW_macro_in_impex174);
            	    macro4=macro();

            	    state._fsp--;

            	    stream_macro.add(macro4.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            EOF5=(Token)match(input,EOF,FOLLOW_EOF_in_impex178);  
            stream_EOF.add(EOF5);


            // AST REWRITE
            // elements: block, macro
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 108:3: -> ^( IMPEX ^( ASSIGNEMENTS ( macro )* ) ^( BLOCKS ( block )* ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:108:6: ^( IMPEX ^( ASSIGNEMENTS ( macro )* ) ^( BLOCKS ( block )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IMPEX, "IMPEX")
                , root_1);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:110:3: ^( ASSIGNEMENTS ( macro )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ASSIGNEMENTS, "ASSIGNEMENTS")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:110:18: ( macro )*
                while ( stream_macro.hasNext() ) {
                    adaptor.addChild(root_2, stream_macro.nextTree());

                }
                stream_macro.reset();

                adaptor.addChild(root_1, root_2);
                }

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:110:27: ^( BLOCKS ( block )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCKS, "BLOCKS")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:110:36: ( block )*
                while ( stream_block.hasNext() ) {
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


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "impex"


    public static class block_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "block"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:113:1: block : header ( Lb | Lb record )+ -> ^( BLOCK header ^( RECORDS ( record )+ ) ) ;
    public final ImpexParser.block_return block() throws RecognitionException {
        ImpexParser.block_return retval = new ImpexParser.block_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Lb7=null;
        Token Lb8=null;
        ImpexParser.header_return header6 =null;

        ImpexParser.record_return record9 =null;


        CommonTree Lb7_tree=null;
        CommonTree Lb8_tree=null;
        RewriteRuleTokenStream stream_Lb=new RewriteRuleTokenStream(adaptor,"token Lb");
        RewriteRuleSubtreeStream stream_record=new RewriteRuleSubtreeStream(adaptor,"rule record");
        RewriteRuleSubtreeStream stream_header=new RewriteRuleSubtreeStream(adaptor,"rule header");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:113:7: ( header ( Lb | Lb record )+ -> ^( BLOCK header ^( RECORDS ( record )+ ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:113:9: header ( Lb | Lb record )+
            {
            pushFollow(FOLLOW_header_in_block216);
            header6=header();

            state._fsp--;

            stream_header.add(header6.getTree());

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:113:16: ( Lb | Lb record )+
            int cnt3=0;
            loop3:
            do {
                int alt3=3;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==Lb) ) {
                    int LA3_2 = input.LA(2);

                    if ( (LA3_2==EOF||(LA3_2 >= Insert && LA3_2 <= InsertUpdate)||LA3_2==Lb||LA3_2==Macrodef||LA3_2==Remove||LA3_2==Update) ) {
                        alt3=1;
                    }
                    else if ( (LA3_2==Field||LA3_2==Identifier||LA3_2==QuotedField) ) {
                        alt3=2;
                    }


                }


                switch (alt3) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:113:17: Lb
            	    {
            	    Lb7=(Token)match(input,Lb,FOLLOW_Lb_in_block219);  
            	    stream_Lb.add(Lb7);


            	    }
            	    break;
            	case 2 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:113:22: Lb record
            	    {
            	    Lb8=(Token)match(input,Lb,FOLLOW_Lb_in_block223);  
            	    stream_Lb.add(Lb8);


            	    pushFollow(FOLLOW_record_in_block225);
            	    record9=record();

            	    state._fsp--;

            	    stream_record.add(record9.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            // AST REWRITE
            // elements: record, header
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 114:2: -> ^( BLOCK header ^( RECORDS ( record )+ ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:114:5: ^( BLOCK header ^( RECORDS ( record )+ ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCK, "BLOCK")
                , root_1);

                adaptor.addChild(root_1, stream_header.nextTree());

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:114:20: ^( RECORDS ( record )+ )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(RECORDS, "RECORDS")
                , root_2);

                if ( !(stream_record.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_record.hasNext() ) {
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


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "block"


    public static class header_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "header"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:116:1: header : headerMode Identifier ( '[' headerModifier '=' (hmValue= Bool |hmValue= Identifier ) ']' )? ( ';' attribute )* -> ^( HEADER headerMode ^( TYPE Identifier ) ( ^( MODIFIER headerModifier $hmValue) )? ^( ATTRIBUTES ( attribute )* ) ) ;
    public final ImpexParser.header_return header() throws RecognitionException {
        ImpexParser.header_return retval = new ImpexParser.header_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token hmValue=null;
        Token Identifier11=null;
        Token char_literal12=null;
        Token char_literal14=null;
        Token char_literal15=null;
        Token char_literal16=null;
        ImpexParser.headerMode_return headerMode10 =null;

        ImpexParser.headerModifier_return headerModifier13 =null;

        ImpexParser.attribute_return attribute17 =null;


        CommonTree hmValue_tree=null;
        CommonTree Identifier11_tree=null;
        CommonTree char_literal12_tree=null;
        CommonTree char_literal14_tree=null;
        CommonTree char_literal15_tree=null;
        CommonTree char_literal16_tree=null;
        RewriteRuleTokenStream stream_LeftBracket=new RewriteRuleTokenStream(adaptor,"token LeftBracket");
        RewriteRuleTokenStream stream_Bool=new RewriteRuleTokenStream(adaptor,"token Bool");
        RewriteRuleTokenStream stream_RightBracket=new RewriteRuleTokenStream(adaptor,"token RightBracket");
        RewriteRuleTokenStream stream_Semicolon=new RewriteRuleTokenStream(adaptor,"token Semicolon");
        RewriteRuleTokenStream stream_Equals=new RewriteRuleTokenStream(adaptor,"token Equals");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_headerMode=new RewriteRuleSubtreeStream(adaptor,"rule headerMode");
        RewriteRuleSubtreeStream stream_attribute=new RewriteRuleSubtreeStream(adaptor,"rule attribute");
        RewriteRuleSubtreeStream stream_headerModifier=new RewriteRuleSubtreeStream(adaptor,"rule headerModifier");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:117:2: ( headerMode Identifier ( '[' headerModifier '=' (hmValue= Bool |hmValue= Identifier ) ']' )? ( ';' attribute )* -> ^( HEADER headerMode ^( TYPE Identifier ) ( ^( MODIFIER headerModifier $hmValue) )? ^( ATTRIBUTES ( attribute )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:117:4: headerMode Identifier ( '[' headerModifier '=' (hmValue= Bool |hmValue= Identifier ) ']' )? ( ';' attribute )*
            {
            pushFollow(FOLLOW_headerMode_in_header252);
            headerMode10=headerMode();

            state._fsp--;

            stream_headerMode.add(headerMode10.getTree());

            Identifier11=(Token)match(input,Identifier,FOLLOW_Identifier_in_header255);  
            stream_Identifier.add(Identifier11);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:117:27: ( '[' headerModifier '=' (hmValue= Bool |hmValue= Identifier ) ']' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==LeftBracket) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:117:28: '[' headerModifier '=' (hmValue= Bool |hmValue= Identifier ) ']'
                    {
                    char_literal12=(Token)match(input,LeftBracket,FOLLOW_LeftBracket_in_header258);  
                    stream_LeftBracket.add(char_literal12);


                    pushFollow(FOLLOW_headerModifier_in_header260);
                    headerModifier13=headerModifier();

                    state._fsp--;

                    stream_headerModifier.add(headerModifier13.getTree());

                    char_literal14=(Token)match(input,Equals,FOLLOW_Equals_in_header262);  
                    stream_Equals.add(char_literal14);


                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:117:51: (hmValue= Bool |hmValue= Identifier )
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==Bool) ) {
                        alt4=1;
                    }
                    else if ( (LA4_0==Identifier) ) {
                        alt4=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 0, input);

                        throw nvae;

                    }
                    switch (alt4) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:117:52: hmValue= Bool
                            {
                            hmValue=(Token)match(input,Bool,FOLLOW_Bool_in_header267);  
                            stream_Bool.add(hmValue);


                            }
                            break;
                        case 2 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:117:67: hmValue= Identifier
                            {
                            hmValue=(Token)match(input,Identifier,FOLLOW_Identifier_in_header273);  
                            stream_Identifier.add(hmValue);


                            }
                            break;

                    }


                    char_literal15=(Token)match(input,RightBracket,FOLLOW_RightBracket_in_header276);  
                    stream_RightBracket.add(char_literal15);


                    }
                    break;

            }


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:117:94: ( ';' attribute )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==Semicolon) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:117:95: ';' attribute
            	    {
            	    char_literal16=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_header282);  
            	    stream_Semicolon.add(char_literal16);


            	    pushFollow(FOLLOW_attribute_in_header284);
            	    attribute17=attribute();

            	    state._fsp--;

            	    stream_attribute.add(attribute17.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            // AST REWRITE
            // elements: Identifier, attribute, headerModifier, headerMode, hmValue
            // token labels: hmValue
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_hmValue=new RewriteRuleTokenStream(adaptor,"token hmValue",hmValue);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 118:2: -> ^( HEADER headerMode ^( TYPE Identifier ) ( ^( MODIFIER headerModifier $hmValue) )? ^( ATTRIBUTES ( attribute )* ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:118:5: ^( HEADER headerMode ^( TYPE Identifier ) ( ^( MODIFIER headerModifier $hmValue) )? ^( ATTRIBUTES ( attribute )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(HEADER, "HEADER")
                , root_1);

                adaptor.addChild(root_1, stream_headerMode.nextTree());

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:118:25: ^( TYPE Identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(TYPE, "TYPE")
                , root_2);

                adaptor.addChild(root_2, 
                stream_Identifier.nextNode()
                );

                adaptor.addChild(root_1, root_2);
                }

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:118:44: ( ^( MODIFIER headerModifier $hmValue) )?
                if ( stream_headerModifier.hasNext()||stream_hmValue.hasNext() ) {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:118:44: ^( MODIFIER headerModifier $hmValue)
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(MODIFIER, "MODIFIER")
                    , root_2);

                    adaptor.addChild(root_2, stream_headerModifier.nextTree());

                    adaptor.addChild(root_2, stream_hmValue.nextNode());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_headerModifier.reset();
                stream_hmValue.reset();

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:118:81: ^( ATTRIBUTES ( attribute )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ATTRIBUTES, "ATTRIBUTES")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:118:94: ( attribute )*
                while ( stream_attribute.hasNext() ) {
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


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "header"


    public static class record_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "record"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:120:1: record : ( Identifier )? ( QuotedField | Field )+ -> ^( RECORD ( ^( SUBTYPE Identifier ) )? ^( FIELDS ( QuotedField )+ ( Field )+ ) ) ;
    public final ImpexParser.record_return record() throws RecognitionException {
        ImpexParser.record_return retval = new ImpexParser.record_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Identifier18=null;
        Token QuotedField19=null;
        Token Field20=null;

        CommonTree Identifier18_tree=null;
        CommonTree QuotedField19_tree=null;
        CommonTree Field20_tree=null;
        RewriteRuleTokenStream stream_Field=new RewriteRuleTokenStream(adaptor,"token Field");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_QuotedField=new RewriteRuleTokenStream(adaptor,"token QuotedField");

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:121:5: ( ( Identifier )? ( QuotedField | Field )+ -> ^( RECORD ( ^( SUBTYPE Identifier ) )? ^( FIELDS ( QuotedField )+ ( Field )+ ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:121:7: ( Identifier )? ( QuotedField | Field )+
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:121:7: ( Identifier )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==Identifier) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:121:7: Identifier
                    {
                    Identifier18=(Token)match(input,Identifier,FOLLOW_Identifier_in_record331);  
                    stream_Identifier.add(Identifier18);


                    }
                    break;

            }


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:121:19: ( QuotedField | Field )+
            int cnt8=0;
            loop8:
            do {
                int alt8=3;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==QuotedField) ) {
                    alt8=1;
                }
                else if ( (LA8_0==Field) ) {
                    alt8=2;
                }


                switch (alt8) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:121:20: QuotedField
            	    {
            	    QuotedField19=(Token)match(input,QuotedField,FOLLOW_QuotedField_in_record335);  
            	    stream_QuotedField.add(QuotedField19);


            	    }
            	    break;
            	case 2 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:121:34: Field
            	    {
            	    Field20=(Token)match(input,Field,FOLLOW_Field_in_record339);  
            	    stream_Field.add(Field20);


            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            // AST REWRITE
            // elements: Field, Identifier, QuotedField
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 122:6: -> ^( RECORD ( ^( SUBTYPE Identifier ) )? ^( FIELDS ( QuotedField )+ ( Field )+ ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:122:9: ^( RECORD ( ^( SUBTYPE Identifier ) )? ^( FIELDS ( QuotedField )+ ( Field )+ ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(RECORD, "RECORD")
                , root_1);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:122:18: ( ^( SUBTYPE Identifier ) )?
                if ( stream_Identifier.hasNext() ) {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:122:18: ^( SUBTYPE Identifier )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(SUBTYPE, "SUBTYPE")
                    , root_2);

                    adaptor.addChild(root_2, 
                    stream_Identifier.nextNode()
                    );

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_Identifier.reset();

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:122:41: ^( FIELDS ( QuotedField )+ ( Field )+ )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(FIELDS, "FIELDS")
                , root_2);

                if ( !(stream_QuotedField.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_QuotedField.hasNext() ) {
                    adaptor.addChild(root_2, 
                    stream_QuotedField.nextNode()
                    );

                }
                stream_QuotedField.reset();

                if ( !(stream_Field.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_Field.hasNext() ) {
                    adaptor.addChild(root_2, 
                    stream_Field.nextNode()
                    );

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


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "record"


    public static class attribute_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "attribute"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:124:1: attribute : identifier ( '[' attributeModifier '=' (amValue= Bool |amValue= Identifier ) ']' )? -> ^( ATTRIBUTE identifier ( ^( MODIFIER attributeModifier $amValue) )? ) ;
    public final ImpexParser.attribute_return attribute() throws RecognitionException {
        ImpexParser.attribute_return retval = new ImpexParser.attribute_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token amValue=null;
        Token char_literal22=null;
        Token char_literal24=null;
        Token char_literal25=null;
        ImpexParser.identifier_return identifier21 =null;

        ImpexParser.attributeModifier_return attributeModifier23 =null;


        CommonTree amValue_tree=null;
        CommonTree char_literal22_tree=null;
        CommonTree char_literal24_tree=null;
        CommonTree char_literal25_tree=null;
        RewriteRuleTokenStream stream_LeftBracket=new RewriteRuleTokenStream(adaptor,"token LeftBracket");
        RewriteRuleTokenStream stream_Bool=new RewriteRuleTokenStream(adaptor,"token Bool");
        RewriteRuleTokenStream stream_RightBracket=new RewriteRuleTokenStream(adaptor,"token RightBracket");
        RewriteRuleTokenStream stream_Equals=new RewriteRuleTokenStream(adaptor,"token Equals");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_attributeModifier=new RewriteRuleSubtreeStream(adaptor,"rule attributeModifier");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:124:11: ( identifier ( '[' attributeModifier '=' (amValue= Bool |amValue= Identifier ) ']' )? -> ^( ATTRIBUTE identifier ( ^( MODIFIER attributeModifier $amValue) )? ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:124:13: identifier ( '[' attributeModifier '=' (amValue= Bool |amValue= Identifier ) ']' )?
            {
            pushFollow(FOLLOW_identifier_in_attribute383);
            identifier21=identifier();

            state._fsp--;

            stream_identifier.add(identifier21.getTree());

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:124:24: ( '[' attributeModifier '=' (amValue= Bool |amValue= Identifier ) ']' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==LeftBracket) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:124:25: '[' attributeModifier '=' (amValue= Bool |amValue= Identifier ) ']'
                    {
                    char_literal22=(Token)match(input,LeftBracket,FOLLOW_LeftBracket_in_attribute386);  
                    stream_LeftBracket.add(char_literal22);


                    pushFollow(FOLLOW_attributeModifier_in_attribute388);
                    attributeModifier23=attributeModifier();

                    state._fsp--;

                    stream_attributeModifier.add(attributeModifier23.getTree());

                    char_literal24=(Token)match(input,Equals,FOLLOW_Equals_in_attribute390);  
                    stream_Equals.add(char_literal24);


                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:124:51: (amValue= Bool |amValue= Identifier )
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==Bool) ) {
                        alt9=1;
                    }
                    else if ( (LA9_0==Identifier) ) {
                        alt9=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 0, input);

                        throw nvae;

                    }
                    switch (alt9) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:124:52: amValue= Bool
                            {
                            amValue=(Token)match(input,Bool,FOLLOW_Bool_in_attribute395);  
                            stream_Bool.add(amValue);


                            }
                            break;
                        case 2 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:124:66: amValue= Identifier
                            {
                            amValue=(Token)match(input,Identifier,FOLLOW_Identifier_in_attribute400);  
                            stream_Identifier.add(amValue);


                            }
                            break;

                    }


                    char_literal25=(Token)match(input,RightBracket,FOLLOW_RightBracket_in_attribute403);  
                    stream_RightBracket.add(char_literal25);


                    }
                    break;

            }


            // AST REWRITE
            // elements: identifier, amValue, attributeModifier
            // token labels: amValue
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_amValue=new RewriteRuleTokenStream(adaptor,"token amValue",amValue);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 125:2: -> ^( ATTRIBUTE identifier ( ^( MODIFIER attributeModifier $amValue) )? )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:125:5: ^( ATTRIBUTE identifier ( ^( MODIFIER attributeModifier $amValue) )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ATTRIBUTE, "ATTRIBUTE")
                , root_1);

                adaptor.addChild(root_1, stream_identifier.nextTree());

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:125:28: ( ^( MODIFIER attributeModifier $amValue) )?
                if ( stream_amValue.hasNext()||stream_attributeModifier.hasNext() ) {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:125:28: ^( MODIFIER attributeModifier $amValue)
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(MODIFIER, "MODIFIER")
                    , root_2);

                    adaptor.addChild(root_2, stream_attributeModifier.nextTree());

                    adaptor.addChild(root_2, stream_amValue.nextNode());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_amValue.reset();
                stream_attributeModifier.reset();

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "attribute"


    public static class identifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "identifier"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:127:1: identifier : Identifier ( '.' Identifier | ( '(' identifier ( ',' identifier )* ')' ) )? ;
    public final ImpexParser.identifier_return identifier() throws RecognitionException {
        ImpexParser.identifier_return retval = new ImpexParser.identifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Identifier26=null;
        Token char_literal27=null;
        Token Identifier28=null;
        Token char_literal29=null;
        Token char_literal31=null;
        Token char_literal33=null;
        ImpexParser.identifier_return identifier30 =null;

        ImpexParser.identifier_return identifier32 =null;


        CommonTree Identifier26_tree=null;
        CommonTree char_literal27_tree=null;
        CommonTree Identifier28_tree=null;
        CommonTree char_literal29_tree=null;
        CommonTree char_literal31_tree=null;
        CommonTree char_literal33_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:127:12: ( Identifier ( '.' Identifier | ( '(' identifier ( ',' identifier )* ')' ) )? )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:127:13: Identifier ( '.' Identifier | ( '(' identifier ( ',' identifier )* ')' ) )?
            {
            root_0 = (CommonTree)adaptor.nil();


            Identifier26=(Token)match(input,Identifier,FOLLOW_Identifier_in_identifier431); 
            Identifier26_tree = 
            (CommonTree)adaptor.create(Identifier26)
            ;
            adaptor.addChild(root_0, Identifier26_tree);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:127:24: ( '.' Identifier | ( '(' identifier ( ',' identifier )* ')' ) )?
            int alt12=3;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==63) ) {
                alt12=1;
            }
            else if ( (LA12_0==LeftParenthesis) ) {
                alt12=2;
            }
            switch (alt12) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:127:25: '.' Identifier
                    {
                    char_literal27=(Token)match(input,63,FOLLOW_63_in_identifier434); 
                    char_literal27_tree = 
                    (CommonTree)adaptor.create(char_literal27)
                    ;
                    adaptor.addChild(root_0, char_literal27_tree);


                    Identifier28=(Token)match(input,Identifier,FOLLOW_Identifier_in_identifier436); 
                    Identifier28_tree = 
                    (CommonTree)adaptor.create(Identifier28)
                    ;
                    adaptor.addChild(root_0, Identifier28_tree);


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:127:43: ( '(' identifier ( ',' identifier )* ')' )
                    {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:127:43: ( '(' identifier ( ',' identifier )* ')' )
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:127:44: '(' identifier ( ',' identifier )* ')'
                    {
                    char_literal29=(Token)match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_identifier442); 
                    char_literal29_tree = 
                    (CommonTree)adaptor.create(char_literal29)
                    ;
                    adaptor.addChild(root_0, char_literal29_tree);


                    pushFollow(FOLLOW_identifier_in_identifier444);
                    identifier30=identifier();

                    state._fsp--;

                    adaptor.addChild(root_0, identifier30.getTree());

                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:127:59: ( ',' identifier )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==62) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:127:60: ',' identifier
                    	    {
                    	    char_literal31=(Token)match(input,62,FOLLOW_62_in_identifier447); 
                    	    char_literal31_tree = 
                    	    (CommonTree)adaptor.create(char_literal31)
                    	    ;
                    	    adaptor.addChild(root_0, char_literal31_tree);


                    	    pushFollow(FOLLOW_identifier_in_identifier449);
                    	    identifier32=identifier();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, identifier32.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    char_literal33=(Token)match(input,RightParenthesis,FOLLOW_RightParenthesis_in_identifier453); 
                    char_literal33_tree = 
                    (CommonTree)adaptor.create(char_literal33)
                    ;
                    adaptor.addChild(root_0, char_literal33_tree);


                    }


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "identifier"


    public static class macro_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "macro"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:129:1: macro : Macrodef Macroval -> ^( ASSIGNEMENT Macrodef Macroval ) ;
    public final ImpexParser.macro_return macro() throws RecognitionException {
        ImpexParser.macro_return retval = new ImpexParser.macro_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Macrodef34=null;
        Token Macroval35=null;

        CommonTree Macrodef34_tree=null;
        CommonTree Macroval35_tree=null;
        RewriteRuleTokenStream stream_Macroval=new RewriteRuleTokenStream(adaptor,"token Macroval");
        RewriteRuleTokenStream stream_Macrodef=new RewriteRuleTokenStream(adaptor,"token Macrodef");

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:130:2: ( Macrodef Macroval -> ^( ASSIGNEMENT Macrodef Macroval ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:130:3: Macrodef Macroval
            {
            Macrodef34=(Token)match(input,Macrodef,FOLLOW_Macrodef_in_macro464);  
            stream_Macrodef.add(Macrodef34);


            Macroval35=(Token)match(input,Macroval,FOLLOW_Macroval_in_macro466);  
            stream_Macroval.add(Macroval35);


            // AST REWRITE
            // elements: Macroval, Macrodef
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 131:2: -> ^( ASSIGNEMENT Macrodef Macroval )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:131:5: ^( ASSIGNEMENT Macrodef Macroval )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ASSIGNEMENT, "ASSIGNEMENT")
                , root_1);

                adaptor.addChild(root_1, 
                stream_Macrodef.nextNode()
                );

                adaptor.addChild(root_1, 
                stream_Macroval.nextNode()
                );

                adaptor.addChild(root_0, root_1);
                }

            }


            retval.tree = root_0;

            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "macro"


    public static class attributeModifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "attributeModifier"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:133:1: attributeModifier : ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual );
    public final ImpexParser.attributeModifier_return attributeModifier() throws RecognitionException {
        ImpexParser.attributeModifier_return retval = new ImpexParser.attributeModifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set36=null;

        CommonTree set36_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:133:19: ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set36=(Token)input.LT(1);

            if ( (input.LA(1) >= Alias && input.LA(1) <= AllowNull)||input.LA(1)==CellDecorator||input.LA(1)==CollectionDelimiter||(input.LA(1) >= Dateformat && input.LA(1) <= Default)||input.LA(1)==ForceWrite||(input.LA(1) >= IgnoreKeyCase && input.LA(1) <= IgnoreNull)||(input.LA(1) >= KeyToValueDelimiter && input.LA(1) <= Lang)||(input.LA(1) >= MapDelimiter && input.LA(1) <= Pos)||(input.LA(1) >= Translator && input.LA(1) <= Unique)||input.LA(1)==Virtual ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set36)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "attributeModifier"


    public static class headerModifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "headerModifier"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:136:1: headerModifier : ( BatchMode | CacheUnique | Processor );
    public final ImpexParser.headerModifier_return headerModifier() throws RecognitionException {
        ImpexParser.headerModifier_return retval = new ImpexParser.headerModifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set37=null;

        CommonTree set37_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:136:17: ( BatchMode | CacheUnique | Processor )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set37=(Token)input.LT(1);

            if ( input.LA(1)==BatchMode||input.LA(1)==CacheUnique||input.LA(1)==Processor ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set37)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "headerModifier"


    public static class headerMode_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "headerMode"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:138:1: headerMode : ( Insert | InsertUpdate | Update | Remove );
    public final ImpexParser.headerMode_return headerMode() throws RecognitionException {
        ImpexParser.headerMode_return retval = new ImpexParser.headerMode_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set38=null;

        CommonTree set38_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:138:13: ( Insert | InsertUpdate | Update | Remove )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set38=(Token)input.LT(1);

            if ( (input.LA(1) >= Insert && input.LA(1) <= InsertUpdate)||input.LA(1)==Remove||input.LA(1)==Update ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set38)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "headerMode"

    // Delegated rules


 

    public static final BitSet FOLLOW_EOF_in_parse153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Lb_in_impex165 = new BitSet(new long[]{0x0808010980000000L});
    public static final BitSet FOLLOW_block_in_impex170 = new BitSet(new long[]{0x0808010980000000L});
    public static final BitSet FOLLOW_macro_in_impex174 = new BitSet(new long[]{0x0808010980000000L});
    public static final BitSet FOLLOW_EOF_in_impex178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_header_in_block216 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_Lb_in_block219 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_Lb_in_block223 = new BitSet(new long[]{0x0001000011000000L});
    public static final BitSet FOLLOW_record_in_block225 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_headerMode_in_header252 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_Identifier_in_header255 = new BitSet(new long[]{0x0080001000000002L});
    public static final BitSet FOLLOW_LeftBracket_in_header258 = new BitSet(new long[]{0x0000800000005000L});
    public static final BitSet FOLLOW_headerModifier_in_header260 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_Equals_in_header262 = new BitSet(new long[]{0x0000000010002000L});
    public static final BitSet FOLLOW_Bool_in_header267 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_Identifier_in_header273 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RightBracket_in_header276 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_Semicolon_in_header282 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_attribute_in_header284 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_Identifier_in_record331 = new BitSet(new long[]{0x0001000001000000L});
    public static final BitSet FOLLOW_QuotedField_in_record335 = new BitSet(new long[]{0x0001000001000002L});
    public static final BitSet FOLLOW_Field_in_record339 = new BitSet(new long[]{0x0001000001000002L});
    public static final BitSet FOLLOW_identifier_in_attribute383 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_LeftBracket_in_attribute386 = new BitSet(new long[]{0x16007C06621A8300L});
    public static final BitSet FOLLOW_attributeModifier_in_attribute388 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_Equals_in_attribute390 = new BitSet(new long[]{0x0000000010002000L});
    public static final BitSet FOLLOW_Bool_in_attribute395 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_Identifier_in_attribute400 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RightBracket_in_attribute403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_identifier431 = new BitSet(new long[]{0x8000002000000002L});
    public static final BitSet FOLLOW_63_in_identifier434 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_Identifier_in_identifier436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftParenthesis_in_identifier442 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_identifier_in_identifier444 = new BitSet(new long[]{0x4020000000000000L});
    public static final BitSet FOLLOW_62_in_identifier447 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_identifier_in_identifier449 = new BitSet(new long[]{0x4020000000000000L});
    public static final BitSet FOLLOW_RightParenthesis_in_identifier453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Macrodef_in_macro464 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_Macroval_in_macro466 = new BitSet(new long[]{0x0000000000000002L});

}