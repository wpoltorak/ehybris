// $ANTLR 3.4 /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g 2012-11-01 19:53:50

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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:107:1: impex : ( Lb | block | macro )* EOF -> ^( IMPEX ( ^( ASSIGNEMENTS macro ) )* ( ^( BLOCKS block ) )* ) ;
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:107:7: ( ( Lb | block | macro )* EOF -> ^( IMPEX ( ^( ASSIGNEMENTS macro ) )* ( ^( BLOCKS block ) )* ) )
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
            // elements: macro, block
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 108:3: -> ^( IMPEX ( ^( ASSIGNEMENTS macro ) )* ( ^( BLOCKS block ) )* )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:108:6: ^( IMPEX ( ^( ASSIGNEMENTS macro ) )* ( ^( BLOCKS block ) )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IMPEX, "IMPEX")
                , root_1);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:110:3: ( ^( ASSIGNEMENTS macro ) )*
                while ( stream_macro.hasNext() ) {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:110:3: ^( ASSIGNEMENTS macro )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(ASSIGNEMENTS, "ASSIGNEMENTS")
                    , root_2);

                    adaptor.addChild(root_2, stream_macro.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_macro.reset();

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:110:27: ( ^( BLOCKS block ) )*
                while ( stream_block.hasNext() ) {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:110:27: ^( BLOCKS block )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(BLOCKS, "BLOCKS")
                    , root_2);

                    adaptor.addChild(root_2, stream_block.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_block.reset();

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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:113:1: block : header ( ( Lb )+ record )+ -> ^( BLOCK header ^( RECORDS ( record )+ ) ) ;
    public final ImpexParser.block_return block() throws RecognitionException {
        ImpexParser.block_return retval = new ImpexParser.block_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Lb7=null;
        ImpexParser.header_return header6 =null;

        ImpexParser.record_return record8 =null;


        CommonTree Lb7_tree=null;
        RewriteRuleTokenStream stream_Lb=new RewriteRuleTokenStream(adaptor,"token Lb");
        RewriteRuleSubtreeStream stream_record=new RewriteRuleSubtreeStream(adaptor,"rule record");
        RewriteRuleSubtreeStream stream_header=new RewriteRuleSubtreeStream(adaptor,"rule header");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:113:7: ( header ( ( Lb )+ record )+ -> ^( BLOCK header ^( RECORDS ( record )+ ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:113:9: header ( ( Lb )+ record )+
            {
            pushFollow(FOLLOW_header_in_block216);
            header6=header();

            state._fsp--;

            stream_header.add(header6.getTree());

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:113:16: ( ( Lb )+ record )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                alt4 = dfa4.predict(input);
                switch (alt4) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:113:17: ( Lb )+ record
            	    {
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:113:17: ( Lb )+
            	    int cnt3=0;
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( (LA3_0==Lb) ) {
            	            alt3=1;
            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:113:17: Lb
            	    	    {
            	    	    Lb7=(Token)match(input,Lb,FOLLOW_Lb_in_block219);  
            	    	    stream_Lb.add(Lb7);


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


            	    pushFollow(FOLLOW_record_in_block223);
            	    record8=record();

            	    state._fsp--;

            	    stream_record.add(record8.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);


            // AST REWRITE
            // elements: header, record
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:116:1: header : headerMode Identifier ( '[' headerModifier '=' (hmValue= Bool |hmValue= Identifier ) ']' )? ( ';' attribute )* -> ^( HEADER headerMode ^( TYPE Identifier ) ( ^( MODIFIER headerModifier $hmValue) )? ( ^( ATTRIBUTES attribute ) )* ) ;
    public final ImpexParser.header_return header() throws RecognitionException {
        ImpexParser.header_return retval = new ImpexParser.header_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token hmValue=null;
        Token Identifier10=null;
        Token char_literal11=null;
        Token char_literal13=null;
        Token char_literal14=null;
        Token char_literal15=null;
        ImpexParser.headerMode_return headerMode9 =null;

        ImpexParser.headerModifier_return headerModifier12 =null;

        ImpexParser.attribute_return attribute16 =null;


        CommonTree hmValue_tree=null;
        CommonTree Identifier10_tree=null;
        CommonTree char_literal11_tree=null;
        CommonTree char_literal13_tree=null;
        CommonTree char_literal14_tree=null;
        CommonTree char_literal15_tree=null;
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:117:2: ( headerMode Identifier ( '[' headerModifier '=' (hmValue= Bool |hmValue= Identifier ) ']' )? ( ';' attribute )* -> ^( HEADER headerMode ^( TYPE Identifier ) ( ^( MODIFIER headerModifier $hmValue) )? ( ^( ATTRIBUTES attribute ) )* ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:117:4: headerMode Identifier ( '[' headerModifier '=' (hmValue= Bool |hmValue= Identifier ) ']' )? ( ';' attribute )*
            {
            pushFollow(FOLLOW_headerMode_in_header250);
            headerMode9=headerMode();

            state._fsp--;

            stream_headerMode.add(headerMode9.getTree());

            Identifier10=(Token)match(input,Identifier,FOLLOW_Identifier_in_header253);  
            stream_Identifier.add(Identifier10);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:117:27: ( '[' headerModifier '=' (hmValue= Bool |hmValue= Identifier ) ']' )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==LeftBracket) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:117:28: '[' headerModifier '=' (hmValue= Bool |hmValue= Identifier ) ']'
                    {
                    char_literal11=(Token)match(input,LeftBracket,FOLLOW_LeftBracket_in_header256);  
                    stream_LeftBracket.add(char_literal11);


                    pushFollow(FOLLOW_headerModifier_in_header258);
                    headerModifier12=headerModifier();

                    state._fsp--;

                    stream_headerModifier.add(headerModifier12.getTree());

                    char_literal13=(Token)match(input,Equals,FOLLOW_Equals_in_header260);  
                    stream_Equals.add(char_literal13);


                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:117:51: (hmValue= Bool |hmValue= Identifier )
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==Bool) ) {
                        alt5=1;
                    }
                    else if ( (LA5_0==Identifier) ) {
                        alt5=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 5, 0, input);

                        throw nvae;

                    }
                    switch (alt5) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:117:52: hmValue= Bool
                            {
                            hmValue=(Token)match(input,Bool,FOLLOW_Bool_in_header265);  
                            stream_Bool.add(hmValue);


                            }
                            break;
                        case 2 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:117:67: hmValue= Identifier
                            {
                            hmValue=(Token)match(input,Identifier,FOLLOW_Identifier_in_header271);  
                            stream_Identifier.add(hmValue);


                            }
                            break;

                    }


                    char_literal14=(Token)match(input,RightBracket,FOLLOW_RightBracket_in_header274);  
                    stream_RightBracket.add(char_literal14);


                    }
                    break;

            }


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:117:94: ( ';' attribute )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==Semicolon) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:117:95: ';' attribute
            	    {
            	    char_literal15=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_header280);  
            	    stream_Semicolon.add(char_literal15);


            	    pushFollow(FOLLOW_attribute_in_header282);
            	    attribute16=attribute();

            	    state._fsp--;

            	    stream_attribute.add(attribute16.getTree());

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            // AST REWRITE
            // elements: headerModifier, attribute, Identifier, hmValue, headerMode
            // token labels: hmValue
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_hmValue=new RewriteRuleTokenStream(adaptor,"token hmValue",hmValue);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 118:2: -> ^( HEADER headerMode ^( TYPE Identifier ) ( ^( MODIFIER headerModifier $hmValue) )? ( ^( ATTRIBUTES attribute ) )* )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:118:5: ^( HEADER headerMode ^( TYPE Identifier ) ( ^( MODIFIER headerModifier $hmValue) )? ( ^( ATTRIBUTES attribute ) )* )
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

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:118:81: ( ^( ATTRIBUTES attribute ) )*
                while ( stream_attribute.hasNext() ) {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:118:81: ^( ATTRIBUTES attribute )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(ATTRIBUTES, "ATTRIBUTES")
                    , root_2);

                    adaptor.addChild(root_2, stream_attribute.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_attribute.reset();

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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:120:1: record : ( Identifier )? ( QuotedField | Field )+ -> ^( RECORD ( ^( SUBTYPE Identifier ) )? ^( FIELDS ( QuotedField )* ( Field )* ) ) ;
    public final ImpexParser.record_return record() throws RecognitionException {
        ImpexParser.record_return retval = new ImpexParser.record_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Identifier17=null;
        Token QuotedField18=null;
        Token Field19=null;

        CommonTree Identifier17_tree=null;
        CommonTree QuotedField18_tree=null;
        CommonTree Field19_tree=null;
        RewriteRuleTokenStream stream_Field=new RewriteRuleTokenStream(adaptor,"token Field");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_QuotedField=new RewriteRuleTokenStream(adaptor,"token QuotedField");

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:121:5: ( ( Identifier )? ( QuotedField | Field )+ -> ^( RECORD ( ^( SUBTYPE Identifier ) )? ^( FIELDS ( QuotedField )* ( Field )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:121:7: ( Identifier )? ( QuotedField | Field )+
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:121:7: ( Identifier )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==Identifier) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:121:7: Identifier
                    {
                    Identifier17=(Token)match(input,Identifier,FOLLOW_Identifier_in_record329);  
                    stream_Identifier.add(Identifier17);


                    }
                    break;

            }


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:121:19: ( QuotedField | Field )+
            int cnt9=0;
            loop9:
            do {
                int alt9=3;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==QuotedField) ) {
                    alt9=1;
                }
                else if ( (LA9_0==Field) ) {
                    alt9=2;
                }


                switch (alt9) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:121:20: QuotedField
            	    {
            	    QuotedField18=(Token)match(input,QuotedField,FOLLOW_QuotedField_in_record333);  
            	    stream_QuotedField.add(QuotedField18);


            	    }
            	    break;
            	case 2 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:121:34: Field
            	    {
            	    Field19=(Token)match(input,Field,FOLLOW_Field_in_record337);  
            	    stream_Field.add(Field19);


            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            // AST REWRITE
            // elements: QuotedField, Identifier, Field
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 122:6: -> ^( RECORD ( ^( SUBTYPE Identifier ) )? ^( FIELDS ( QuotedField )* ( Field )* ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:122:9: ^( RECORD ( ^( SUBTYPE Identifier ) )? ^( FIELDS ( QuotedField )* ( Field )* ) )
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

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:122:41: ^( FIELDS ( QuotedField )* ( Field )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(FIELDS, "FIELDS")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:122:50: ( QuotedField )*
                while ( stream_QuotedField.hasNext() ) {
                    adaptor.addChild(root_2, 
                    stream_QuotedField.nextNode()
                    );

                }
                stream_QuotedField.reset();

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:122:63: ( Field )*
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
        Token char_literal21=null;
        Token char_literal23=null;
        Token char_literal24=null;
        ImpexParser.identifier_return identifier20 =null;

        ImpexParser.attributeModifier_return attributeModifier22 =null;


        CommonTree amValue_tree=null;
        CommonTree char_literal21_tree=null;
        CommonTree char_literal23_tree=null;
        CommonTree char_literal24_tree=null;
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
            pushFollow(FOLLOW_identifier_in_attribute381);
            identifier20=identifier();

            state._fsp--;

            stream_identifier.add(identifier20.getTree());

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:124:24: ( '[' attributeModifier '=' (amValue= Bool |amValue= Identifier ) ']' )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==LeftBracket) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:124:25: '[' attributeModifier '=' (amValue= Bool |amValue= Identifier ) ']'
                    {
                    char_literal21=(Token)match(input,LeftBracket,FOLLOW_LeftBracket_in_attribute384);  
                    stream_LeftBracket.add(char_literal21);


                    pushFollow(FOLLOW_attributeModifier_in_attribute386);
                    attributeModifier22=attributeModifier();

                    state._fsp--;

                    stream_attributeModifier.add(attributeModifier22.getTree());

                    char_literal23=(Token)match(input,Equals,FOLLOW_Equals_in_attribute388);  
                    stream_Equals.add(char_literal23);


                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:124:51: (amValue= Bool |amValue= Identifier )
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==Bool) ) {
                        alt10=1;
                    }
                    else if ( (LA10_0==Identifier) ) {
                        alt10=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 0, input);

                        throw nvae;

                    }
                    switch (alt10) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:124:52: amValue= Bool
                            {
                            amValue=(Token)match(input,Bool,FOLLOW_Bool_in_attribute393);  
                            stream_Bool.add(amValue);


                            }
                            break;
                        case 2 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:124:66: amValue= Identifier
                            {
                            amValue=(Token)match(input,Identifier,FOLLOW_Identifier_in_attribute398);  
                            stream_Identifier.add(amValue);


                            }
                            break;

                    }


                    char_literal24=(Token)match(input,RightBracket,FOLLOW_RightBracket_in_attribute401);  
                    stream_RightBracket.add(char_literal24);


                    }
                    break;

            }


            // AST REWRITE
            // elements: attributeModifier, amValue, identifier
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
                if ( stream_attributeModifier.hasNext()||stream_amValue.hasNext() ) {
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
                stream_attributeModifier.reset();
                stream_amValue.reset();

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

        Token Identifier25=null;
        Token char_literal26=null;
        Token Identifier27=null;
        Token char_literal28=null;
        Token char_literal30=null;
        Token char_literal32=null;
        ImpexParser.identifier_return identifier29 =null;

        ImpexParser.identifier_return identifier31 =null;


        CommonTree Identifier25_tree=null;
        CommonTree char_literal26_tree=null;
        CommonTree Identifier27_tree=null;
        CommonTree char_literal28_tree=null;
        CommonTree char_literal30_tree=null;
        CommonTree char_literal32_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:127:12: ( Identifier ( '.' Identifier | ( '(' identifier ( ',' identifier )* ')' ) )? )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:127:13: Identifier ( '.' Identifier | ( '(' identifier ( ',' identifier )* ')' ) )?
            {
            root_0 = (CommonTree)adaptor.nil();


            Identifier25=(Token)match(input,Identifier,FOLLOW_Identifier_in_identifier429); 
            Identifier25_tree = 
            (CommonTree)adaptor.create(Identifier25)
            ;
            adaptor.addChild(root_0, Identifier25_tree);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:127:24: ( '.' Identifier | ( '(' identifier ( ',' identifier )* ')' ) )?
            int alt13=3;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==63) ) {
                alt13=1;
            }
            else if ( (LA13_0==LeftParenthesis) ) {
                alt13=2;
            }
            switch (alt13) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:127:25: '.' Identifier
                    {
                    char_literal26=(Token)match(input,63,FOLLOW_63_in_identifier432); 
                    char_literal26_tree = 
                    (CommonTree)adaptor.create(char_literal26)
                    ;
                    adaptor.addChild(root_0, char_literal26_tree);


                    Identifier27=(Token)match(input,Identifier,FOLLOW_Identifier_in_identifier434); 
                    Identifier27_tree = 
                    (CommonTree)adaptor.create(Identifier27)
                    ;
                    adaptor.addChild(root_0, Identifier27_tree);


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:127:43: ( '(' identifier ( ',' identifier )* ')' )
                    {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:127:43: ( '(' identifier ( ',' identifier )* ')' )
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:127:44: '(' identifier ( ',' identifier )* ')'
                    {
                    char_literal28=(Token)match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_identifier440); 
                    char_literal28_tree = 
                    (CommonTree)adaptor.create(char_literal28)
                    ;
                    adaptor.addChild(root_0, char_literal28_tree);


                    pushFollow(FOLLOW_identifier_in_identifier442);
                    identifier29=identifier();

                    state._fsp--;

                    adaptor.addChild(root_0, identifier29.getTree());

                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:127:59: ( ',' identifier )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==62) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:127:60: ',' identifier
                    	    {
                    	    char_literal30=(Token)match(input,62,FOLLOW_62_in_identifier445); 
                    	    char_literal30_tree = 
                    	    (CommonTree)adaptor.create(char_literal30)
                    	    ;
                    	    adaptor.addChild(root_0, char_literal30_tree);


                    	    pushFollow(FOLLOW_identifier_in_identifier447);
                    	    identifier31=identifier();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, identifier31.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    char_literal32=(Token)match(input,RightParenthesis,FOLLOW_RightParenthesis_in_identifier451); 
                    char_literal32_tree = 
                    (CommonTree)adaptor.create(char_literal32)
                    ;
                    adaptor.addChild(root_0, char_literal32_tree);


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

        Token Macrodef33=null;
        Token Macroval34=null;

        CommonTree Macrodef33_tree=null;
        CommonTree Macroval34_tree=null;
        RewriteRuleTokenStream stream_Macroval=new RewriteRuleTokenStream(adaptor,"token Macroval");
        RewriteRuleTokenStream stream_Macrodef=new RewriteRuleTokenStream(adaptor,"token Macrodef");

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:130:2: ( Macrodef Macroval -> ^( ASSIGNEMENT Macrodef Macroval ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:130:3: Macrodef Macroval
            {
            Macrodef33=(Token)match(input,Macrodef,FOLLOW_Macrodef_in_macro462);  
            stream_Macrodef.add(Macrodef33);


            Macroval34=(Token)match(input,Macroval,FOLLOW_Macroval_in_macro464);  
            stream_Macroval.add(Macroval34);


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

        Token set35=null;

        CommonTree set35_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:133:19: ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set35=(Token)input.LT(1);

            if ( (input.LA(1) >= Alias && input.LA(1) <= AllowNull)||input.LA(1)==CellDecorator||input.LA(1)==CollectionDelimiter||(input.LA(1) >= Dateformat && input.LA(1) <= Default)||input.LA(1)==ForceWrite||(input.LA(1) >= IgnoreKeyCase && input.LA(1) <= IgnoreNull)||(input.LA(1) >= KeyToValueDelimiter && input.LA(1) <= Lang)||(input.LA(1) >= MapDelimiter && input.LA(1) <= Pos)||(input.LA(1) >= Translator && input.LA(1) <= Unique)||input.LA(1)==Virtual ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set35)
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

        Token set36=null;

        CommonTree set36_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:136:16: ( BatchMode | CacheUnique | Processor )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set36=(Token)input.LT(1);

            if ( input.LA(1)==BatchMode||input.LA(1)==CacheUnique||input.LA(1)==Processor ) {
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

        Token set37=null;

        CommonTree set37_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:138:13: ( Insert | InsertUpdate | Update | Remove )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set37=(Token)input.LT(1);

            if ( (input.LA(1) >= Insert && input.LA(1) <= InsertUpdate)||input.LA(1)==Remove||input.LA(1)==Update ) {
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
    // $ANTLR end "headerMode"

    // Delegated rules


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\4\uffff";
    static final String DFA4_eofS =
        "\1\1\1\uffff\1\1\1\uffff";
    static final String DFA4_minS =
        "\1\37\1\uffff\1\30\1\uffff";
    static final String DFA4_maxS =
        "\1\73\1\uffff\1\73\1\uffff";
    static final String DFA4_acceptS =
        "\1\uffff\1\2\1\uffff\1\1";
    static final String DFA4_specialS =
        "\4\uffff}>";
    static final String[] DFA4_transitionS = {
            "\2\1\2\uffff\1\2\4\uffff\1\1\12\uffff\1\1\7\uffff\1\1",
            "",
            "\1\3\3\uffff\1\3\2\uffff\2\1\2\uffff\1\2\4\uffff\1\1\7\uffff"+
            "\1\3\2\uffff\1\1\7\uffff\1\1",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "()+ loopback of 113:16: ( ( Lb )+ record )+";
        }
    }
 

    public static final BitSet FOLLOW_EOF_in_parse153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Lb_in_impex165 = new BitSet(new long[]{0x0808010980000000L});
    public static final BitSet FOLLOW_block_in_impex170 = new BitSet(new long[]{0x0808010980000000L});
    public static final BitSet FOLLOW_macro_in_impex174 = new BitSet(new long[]{0x0808010980000000L});
    public static final BitSet FOLLOW_EOF_in_impex178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_header_in_block216 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_Lb_in_block219 = new BitSet(new long[]{0x0001000811000000L});
    public static final BitSet FOLLOW_record_in_block223 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_headerMode_in_header250 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_Identifier_in_header253 = new BitSet(new long[]{0x0080001000000002L});
    public static final BitSet FOLLOW_LeftBracket_in_header256 = new BitSet(new long[]{0x0000800000005000L});
    public static final BitSet FOLLOW_headerModifier_in_header258 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_Equals_in_header260 = new BitSet(new long[]{0x0000000010002000L});
    public static final BitSet FOLLOW_Bool_in_header265 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_Identifier_in_header271 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RightBracket_in_header274 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_Semicolon_in_header280 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_attribute_in_header282 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_Identifier_in_record329 = new BitSet(new long[]{0x0001000001000000L});
    public static final BitSet FOLLOW_QuotedField_in_record333 = new BitSet(new long[]{0x0001000001000002L});
    public static final BitSet FOLLOW_Field_in_record337 = new BitSet(new long[]{0x0001000001000002L});
    public static final BitSet FOLLOW_identifier_in_attribute381 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_LeftBracket_in_attribute384 = new BitSet(new long[]{0x16007C06621A8300L});
    public static final BitSet FOLLOW_attributeModifier_in_attribute386 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_Equals_in_attribute388 = new BitSet(new long[]{0x0000000010002000L});
    public static final BitSet FOLLOW_Bool_in_attribute393 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_Identifier_in_attribute398 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RightBracket_in_attribute401 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_identifier429 = new BitSet(new long[]{0x8000002000000002L});
    public static final BitSet FOLLOW_63_in_identifier432 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_Identifier_in_identifier434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftParenthesis_in_identifier440 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_identifier_in_identifier442 = new BitSet(new long[]{0x4020000000000000L});
    public static final BitSet FOLLOW_62_in_identifier445 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_identifier_in_identifier447 = new BitSet(new long[]{0x4020000000000000L});
    public static final BitSet FOLLOW_RightParenthesis_in_identifier451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Macrodef_in_macro462 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_Macroval_in_macro464 = new BitSet(new long[]{0x0000000000000002L});

}