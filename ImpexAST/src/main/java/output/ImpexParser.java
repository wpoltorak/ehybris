// $ANTLR 3.4 /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g 2012-11-03 21:17:18

  package output;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class ImpexParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGNEMENT", "ASSIGNEMENTS", "ATTRIBUTE", "ATTRIBUTES", "Alias", "AllowNull", "BLOCK", "BLOCKS", "BatchMode", "Bool", "CacheUnique", "CellDecorator", "Char", "Classname", "CollectionDelimiter", "Comment", "Dateformat", "Default", "DoubleQuote", "Equals", "FIELDS", "Field", "ForceWrite", "HEADER", "IMPEX", "Identifier", "IgnoreKeyCase", "IgnoreNull", "Insert", "InsertUpdate", "KeyToValueDelimiter", "Lang", "Lb", "LeftBracket", "LeftParenthesis", "LineContinuation", "MODIFIER", "MODIFIERS", "Macrodef", "Macroval", "MapDelimiter", "Mode", "NumberFormat", "PathDelimiter", "Pos", "Processor", "QuotedField", "RECORD", "RECORDS", "Remove", "RightBracket", "RightParenthesis", "SUBTYPE", "Semicolon", "TYPE", "Translator", "Unique", "Update", "Virtual", "Ws", "','", "'.'"
    };

    public static final int EOF=-1;
    public static final int T__64=64;
    public static final int T__65=65;
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
    public static final int Classname=17;
    public static final int CollectionDelimiter=18;
    public static final int Comment=19;
    public static final int Dateformat=20;
    public static final int Default=21;
    public static final int DoubleQuote=22;
    public static final int Equals=23;
    public static final int FIELDS=24;
    public static final int Field=25;
    public static final int ForceWrite=26;
    public static final int HEADER=27;
    public static final int IMPEX=28;
    public static final int Identifier=29;
    public static final int IgnoreKeyCase=30;
    public static final int IgnoreNull=31;
    public static final int Insert=32;
    public static final int InsertUpdate=33;
    public static final int KeyToValueDelimiter=34;
    public static final int Lang=35;
    public static final int Lb=36;
    public static final int LeftBracket=37;
    public static final int LeftParenthesis=38;
    public static final int LineContinuation=39;
    public static final int MODIFIER=40;
    public static final int MODIFIERS=41;
    public static final int Macrodef=42;
    public static final int Macroval=43;
    public static final int MapDelimiter=44;
    public static final int Mode=45;
    public static final int NumberFormat=46;
    public static final int PathDelimiter=47;
    public static final int Pos=48;
    public static final int Processor=49;
    public static final int QuotedField=50;
    public static final int RECORD=51;
    public static final int RECORDS=52;
    public static final int Remove=53;
    public static final int RightBracket=54;
    public static final int RightParenthesis=55;
    public static final int SUBTYPE=56;
    public static final int Semicolon=57;
    public static final int TYPE=58;
    public static final int Translator=59;
    public static final int Unique=60;
    public static final int Update=61;
    public static final int Virtual=62;
    public static final int Ws=63;

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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:105:1: parse : (t= . )* EOF ;
    public final ImpexParser.parse_return parse() throws RecognitionException {
        ImpexParser.parse_return retval = new ImpexParser.parse_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token t=null;
        Token EOF1=null;

        CommonTree t_tree=null;
        CommonTree EOF1_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:106:3: ( (t= . )* EOF )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:106:6: (t= . )* EOF
            {
            root_0 = (CommonTree)adaptor.nil();


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:106:6: (t= . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= ASSIGNEMENT && LA1_0 <= 65)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:106:7: t= .
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


            EOF1=(Token)match(input,EOF,FOLLOW_EOF_in_parse157); 
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:108:1: impex : ( Lb | block | macro )* EOF -> ^( IMPEX ( ^( ASSIGNEMENTS macro ) )* ( ^( BLOCKS block ) )* ) ;
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:108:7: ( ( Lb | block | macro )* EOF -> ^( IMPEX ( ^( ASSIGNEMENTS macro ) )* ( ^( BLOCKS block ) )* ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:108:9: ( Lb | block | macro )* EOF
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:108:9: ( Lb | block | macro )*
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
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:108:10: Lb
            	    {
            	    Lb2=(Token)match(input,Lb,FOLLOW_Lb_in_impex169);  
            	    stream_Lb.add(Lb2);


            	    }
            	    break;
            	case 2 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:108:16: block
            	    {
            	    pushFollow(FOLLOW_block_in_impex174);
            	    block3=block();

            	    state._fsp--;

            	    stream_block.add(block3.getTree());

            	    }
            	    break;
            	case 3 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:108:24: macro
            	    {
            	    pushFollow(FOLLOW_macro_in_impex178);
            	    macro4=macro();

            	    state._fsp--;

            	    stream_macro.add(macro4.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            EOF5=(Token)match(input,EOF,FOLLOW_EOF_in_impex182);  
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
            // 109:3: -> ^( IMPEX ( ^( ASSIGNEMENTS macro ) )* ( ^( BLOCKS block ) )* )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:109:6: ^( IMPEX ( ^( ASSIGNEMENTS macro ) )* ( ^( BLOCKS block ) )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IMPEX, "IMPEX")
                , root_1);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:111:3: ( ^( ASSIGNEMENTS macro ) )*
                while ( stream_macro.hasNext() ) {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:111:3: ^( ASSIGNEMENTS macro )
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

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:111:27: ( ^( BLOCKS block ) )*
                while ( stream_block.hasNext() ) {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:111:27: ^( BLOCKS block )
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:114:1: block : header ( ( Lb )+ record )+ -> ^( BLOCK header ^( RECORDS ( record )+ ) ) ;
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:114:7: ( header ( ( Lb )+ record )+ -> ^( BLOCK header ^( RECORDS ( record )+ ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:114:9: header ( ( Lb )+ record )+
            {
            pushFollow(FOLLOW_header_in_block220);
            header6=header();

            state._fsp--;

            stream_header.add(header6.getTree());

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:114:16: ( ( Lb )+ record )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                alt4 = dfa4.predict(input);
                switch (alt4) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:114:17: ( Lb )+ record
            	    {
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:114:17: ( Lb )+
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
            	    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:114:17: Lb
            	    	    {
            	    	    Lb7=(Token)match(input,Lb,FOLLOW_Lb_in_block223);  
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


            	    pushFollow(FOLLOW_record_in_block227);
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
            // elements: record, header
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 115:2: -> ^( BLOCK header ^( RECORDS ( record )+ ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:115:5: ^( BLOCK header ^( RECORDS ( record )+ ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCK, "BLOCK")
                , root_1);

                adaptor.addChild(root_1, stream_header.nextTree());

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:115:20: ^( RECORDS ( record )+ )
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:117:1: header : headerMode Identifier ( headerModifiers )? ( ';' attribute )* -> ^( HEADER headerMode ^( TYPE Identifier ) ( ^( MODIFIERS headerModifiers ) )? ( ^( ATTRIBUTES attribute ) )* ) ;
    public final ImpexParser.header_return header() throws RecognitionException {
        ImpexParser.header_return retval = new ImpexParser.header_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Identifier10=null;
        Token char_literal12=null;
        ImpexParser.headerMode_return headerMode9 =null;

        ImpexParser.headerModifiers_return headerModifiers11 =null;

        ImpexParser.attribute_return attribute13 =null;


        CommonTree Identifier10_tree=null;
        CommonTree char_literal12_tree=null;
        RewriteRuleTokenStream stream_Semicolon=new RewriteRuleTokenStream(adaptor,"token Semicolon");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_headerMode=new RewriteRuleSubtreeStream(adaptor,"rule headerMode");
        RewriteRuleSubtreeStream stream_attribute=new RewriteRuleSubtreeStream(adaptor,"rule attribute");
        RewriteRuleSubtreeStream stream_headerModifiers=new RewriteRuleSubtreeStream(adaptor,"rule headerModifiers");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:118:2: ( headerMode Identifier ( headerModifiers )? ( ';' attribute )* -> ^( HEADER headerMode ^( TYPE Identifier ) ( ^( MODIFIERS headerModifiers ) )? ( ^( ATTRIBUTES attribute ) )* ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:118:4: headerMode Identifier ( headerModifiers )? ( ';' attribute )*
            {
            pushFollow(FOLLOW_headerMode_in_header254);
            headerMode9=headerMode();

            state._fsp--;

            stream_headerMode.add(headerMode9.getTree());

            Identifier10=(Token)match(input,Identifier,FOLLOW_Identifier_in_header257);  
            stream_Identifier.add(Identifier10);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:118:27: ( headerModifiers )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==LeftBracket) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:118:27: headerModifiers
                    {
                    pushFollow(FOLLOW_headerModifiers_in_header259);
                    headerModifiers11=headerModifiers();

                    state._fsp--;

                    stream_headerModifiers.add(headerModifiers11.getTree());

                    }
                    break;

            }


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:118:45: ( ';' attribute )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==Semicolon) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:118:46: ';' attribute
            	    {
            	    char_literal12=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_header264);  
            	    stream_Semicolon.add(char_literal12);


            	    pushFollow(FOLLOW_attribute_in_header266);
            	    attribute13=attribute();

            	    state._fsp--;

            	    stream_attribute.add(attribute13.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            // AST REWRITE
            // elements: headerMode, Identifier, headerModifiers, attribute
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 119:2: -> ^( HEADER headerMode ^( TYPE Identifier ) ( ^( MODIFIERS headerModifiers ) )? ( ^( ATTRIBUTES attribute ) )* )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:119:5: ^( HEADER headerMode ^( TYPE Identifier ) ( ^( MODIFIERS headerModifiers ) )? ( ^( ATTRIBUTES attribute ) )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(HEADER, "HEADER")
                , root_1);

                adaptor.addChild(root_1, stream_headerMode.nextTree());

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:119:25: ^( TYPE Identifier )
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

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:119:44: ( ^( MODIFIERS headerModifiers ) )?
                if ( stream_headerModifiers.hasNext() ) {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:119:44: ^( MODIFIERS headerModifiers )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(MODIFIERS, "MODIFIERS")
                    , root_2);

                    adaptor.addChild(root_2, stream_headerModifiers.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_headerModifiers.reset();

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:119:74: ( ^( ATTRIBUTES attribute ) )*
                while ( stream_attribute.hasNext() ) {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:119:74: ^( ATTRIBUTES attribute )
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


    public static class headerModifiers_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "headerModifiers"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:121:1: headerModifiers : ( '[' headerModifierAssignment ( ',' headerModifierAssignment )* ']' )+ -> ( ^( MODIFIER headerModifierAssignment ) )+ ;
    public final ImpexParser.headerModifiers_return headerModifiers() throws RecognitionException {
        ImpexParser.headerModifiers_return retval = new ImpexParser.headerModifiers_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal14=null;
        Token char_literal16=null;
        Token char_literal18=null;
        ImpexParser.headerModifierAssignment_return headerModifierAssignment15 =null;

        ImpexParser.headerModifierAssignment_return headerModifierAssignment17 =null;


        CommonTree char_literal14_tree=null;
        CommonTree char_literal16_tree=null;
        CommonTree char_literal18_tree=null;
        RewriteRuleTokenStream stream_LeftBracket=new RewriteRuleTokenStream(adaptor,"token LeftBracket");
        RewriteRuleTokenStream stream_RightBracket=new RewriteRuleTokenStream(adaptor,"token RightBracket");
        RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
        RewriteRuleSubtreeStream stream_headerModifierAssignment=new RewriteRuleSubtreeStream(adaptor,"rule headerModifierAssignment");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:122:2: ( ( '[' headerModifierAssignment ( ',' headerModifierAssignment )* ']' )+ -> ( ^( MODIFIER headerModifierAssignment ) )+ )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:122:4: ( '[' headerModifierAssignment ( ',' headerModifierAssignment )* ']' )+
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:122:4: ( '[' headerModifierAssignment ( ',' headerModifierAssignment )* ']' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==LeftBracket) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:122:5: '[' headerModifierAssignment ( ',' headerModifierAssignment )* ']'
            	    {
            	    char_literal14=(Token)match(input,LeftBracket,FOLLOW_LeftBracket_in_headerModifiers309);  
            	    stream_LeftBracket.add(char_literal14);


            	    pushFollow(FOLLOW_headerModifierAssignment_in_headerModifiers311);
            	    headerModifierAssignment15=headerModifierAssignment();

            	    state._fsp--;

            	    stream_headerModifierAssignment.add(headerModifierAssignment15.getTree());

            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:122:34: ( ',' headerModifierAssignment )*
            	    loop7:
            	    do {
            	        int alt7=2;
            	        int LA7_0 = input.LA(1);

            	        if ( (LA7_0==64) ) {
            	            alt7=1;
            	        }


            	        switch (alt7) {
            	    	case 1 :
            	    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:122:35: ',' headerModifierAssignment
            	    	    {
            	    	    char_literal16=(Token)match(input,64,FOLLOW_64_in_headerModifiers314);  
            	    	    stream_64.add(char_literal16);


            	    	    pushFollow(FOLLOW_headerModifierAssignment_in_headerModifiers317);
            	    	    headerModifierAssignment17=headerModifierAssignment();

            	    	    state._fsp--;

            	    	    stream_headerModifierAssignment.add(headerModifierAssignment17.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop7;
            	        }
            	    } while (true);


            	    char_literal18=(Token)match(input,RightBracket,FOLLOW_RightBracket_in_headerModifiers320);  
            	    stream_RightBracket.add(char_literal18);


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
            // elements: headerModifierAssignment
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 123:2: -> ( ^( MODIFIER headerModifierAssignment ) )+
            {
                if ( !(stream_headerModifierAssignment.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_headerModifierAssignment.hasNext() ) {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:123:5: ^( MODIFIER headerModifierAssignment )
                    {
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    root_1 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(MODIFIER, "MODIFIER")
                    , root_1);

                    adaptor.addChild(root_1, stream_headerModifierAssignment.nextTree());

                    adaptor.addChild(root_0, root_1);
                    }

                }
                stream_headerModifierAssignment.reset();

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
    // $ANTLR end "headerModifiers"


    public static class headerModifierAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "headerModifierAssignment"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:125:1: headerModifierAssignment : headerModifier '=' (hmValue= Bool |hmValue= Classname ) -> headerModifier $hmValue;
    public final ImpexParser.headerModifierAssignment_return headerModifierAssignment() throws RecognitionException {
        ImpexParser.headerModifierAssignment_return retval = new ImpexParser.headerModifierAssignment_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token hmValue=null;
        Token char_literal20=null;
        ImpexParser.headerModifier_return headerModifier19 =null;


        CommonTree hmValue_tree=null;
        CommonTree char_literal20_tree=null;
        RewriteRuleTokenStream stream_Bool=new RewriteRuleTokenStream(adaptor,"token Bool");
        RewriteRuleTokenStream stream_Equals=new RewriteRuleTokenStream(adaptor,"token Equals");
        RewriteRuleTokenStream stream_Classname=new RewriteRuleTokenStream(adaptor,"token Classname");
        RewriteRuleSubtreeStream stream_headerModifier=new RewriteRuleSubtreeStream(adaptor,"rule headerModifier");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:125:25: ( headerModifier '=' (hmValue= Bool |hmValue= Classname ) -> headerModifier $hmValue)
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:125:27: headerModifier '=' (hmValue= Bool |hmValue= Classname )
            {
            pushFollow(FOLLOW_headerModifier_in_headerModifierAssignment339);
            headerModifier19=headerModifier();

            state._fsp--;

            stream_headerModifier.add(headerModifier19.getTree());

            char_literal20=(Token)match(input,Equals,FOLLOW_Equals_in_headerModifierAssignment341);  
            stream_Equals.add(char_literal20);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:125:46: (hmValue= Bool |hmValue= Classname )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==Bool) ) {
                alt9=1;
            }
            else if ( (LA9_0==Classname) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:125:47: hmValue= Bool
                    {
                    hmValue=(Token)match(input,Bool,FOLLOW_Bool_in_headerModifierAssignment346);  
                    stream_Bool.add(hmValue);


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:125:62: hmValue= Classname
                    {
                    hmValue=(Token)match(input,Classname,FOLLOW_Classname_in_headerModifierAssignment352);  
                    stream_Classname.add(hmValue);


                    }
                    break;

            }


            // AST REWRITE
            // elements: headerModifier, hmValue
            // token labels: hmValue
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_hmValue=new RewriteRuleTokenStream(adaptor,"token hmValue",hmValue);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 126:2: -> headerModifier $hmValue
            {
                adaptor.addChild(root_0, stream_headerModifier.nextTree());

                adaptor.addChild(root_0, stream_hmValue.nextNode());

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
    // $ANTLR end "headerModifierAssignment"


    public static class headerModifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "headerModifier"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:128:1: headerModifier : ( BatchMode | CacheUnique | Processor );
    public final ImpexParser.headerModifier_return headerModifier() throws RecognitionException {
        ImpexParser.headerModifier_return retval = new ImpexParser.headerModifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set21=null;

        CommonTree set21_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:128:16: ( BatchMode | CacheUnique | Processor )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set21=(Token)input.LT(1);

            if ( input.LA(1)==BatchMode||input.LA(1)==CacheUnique||input.LA(1)==Processor ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set21)
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


    public static class record_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "record"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:130:1: record : ( Identifier )? ( QuotedField | Field )+ -> ^( RECORD ( ^( SUBTYPE Identifier ) )? ^( FIELDS ( QuotedField )* ( Field )* ) ) ;
    public final ImpexParser.record_return record() throws RecognitionException {
        ImpexParser.record_return retval = new ImpexParser.record_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Identifier22=null;
        Token QuotedField23=null;
        Token Field24=null;

        CommonTree Identifier22_tree=null;
        CommonTree QuotedField23_tree=null;
        CommonTree Field24_tree=null;
        RewriteRuleTokenStream stream_Field=new RewriteRuleTokenStream(adaptor,"token Field");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_QuotedField=new RewriteRuleTokenStream(adaptor,"token QuotedField");

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:131:5: ( ( Identifier )? ( QuotedField | Field )+ -> ^( RECORD ( ^( SUBTYPE Identifier ) )? ^( FIELDS ( QuotedField )* ( Field )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:131:7: ( Identifier )? ( QuotedField | Field )+
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:131:7: ( Identifier )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==Identifier) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:131:7: Identifier
                    {
                    Identifier22=(Token)match(input,Identifier,FOLLOW_Identifier_in_record388);  
                    stream_Identifier.add(Identifier22);


                    }
                    break;

            }


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:131:19: ( QuotedField | Field )+
            int cnt11=0;
            loop11:
            do {
                int alt11=3;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==QuotedField) ) {
                    alt11=1;
                }
                else if ( (LA11_0==Field) ) {
                    alt11=2;
                }


                switch (alt11) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:131:20: QuotedField
            	    {
            	    QuotedField23=(Token)match(input,QuotedField,FOLLOW_QuotedField_in_record392);  
            	    stream_QuotedField.add(QuotedField23);


            	    }
            	    break;
            	case 2 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:131:34: Field
            	    {
            	    Field24=(Token)match(input,Field,FOLLOW_Field_in_record396);  
            	    stream_Field.add(Field24);


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            // AST REWRITE
            // elements: Field, QuotedField, Identifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 132:6: -> ^( RECORD ( ^( SUBTYPE Identifier ) )? ^( FIELDS ( QuotedField )* ( Field )* ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:132:9: ^( RECORD ( ^( SUBTYPE Identifier ) )? ^( FIELDS ( QuotedField )* ( Field )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(RECORD, "RECORD")
                , root_1);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:132:18: ( ^( SUBTYPE Identifier ) )?
                if ( stream_Identifier.hasNext() ) {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:132:18: ^( SUBTYPE Identifier )
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

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:132:41: ^( FIELDS ( QuotedField )* ( Field )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(FIELDS, "FIELDS")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:132:50: ( QuotedField )*
                while ( stream_QuotedField.hasNext() ) {
                    adaptor.addChild(root_2, 
                    stream_QuotedField.nextNode()
                    );

                }
                stream_QuotedField.reset();

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:132:63: ( Field )*
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:134:1: attribute : identifier ( attributeModifiers )? -> ^( ATTRIBUTE identifier ( ^( MODIFIERS attributeModifiers ) )? ) ;
    public final ImpexParser.attribute_return attribute() throws RecognitionException {
        ImpexParser.attribute_return retval = new ImpexParser.attribute_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        ImpexParser.identifier_return identifier25 =null;

        ImpexParser.attributeModifiers_return attributeModifiers26 =null;


        RewriteRuleSubtreeStream stream_attributeModifiers=new RewriteRuleSubtreeStream(adaptor,"rule attributeModifiers");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:134:11: ( identifier ( attributeModifiers )? -> ^( ATTRIBUTE identifier ( ^( MODIFIERS attributeModifiers ) )? ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:134:13: identifier ( attributeModifiers )?
            {
            pushFollow(FOLLOW_identifier_in_attribute440);
            identifier25=identifier();

            state._fsp--;

            stream_identifier.add(identifier25.getTree());

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:134:25: ( attributeModifiers )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==LeftBracket) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:134:25: attributeModifiers
                    {
                    pushFollow(FOLLOW_attributeModifiers_in_attribute443);
                    attributeModifiers26=attributeModifiers();

                    state._fsp--;

                    stream_attributeModifiers.add(attributeModifiers26.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: attributeModifiers, identifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 135:2: -> ^( ATTRIBUTE identifier ( ^( MODIFIERS attributeModifiers ) )? )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:135:5: ^( ATTRIBUTE identifier ( ^( MODIFIERS attributeModifiers ) )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ATTRIBUTE, "ATTRIBUTE")
                , root_1);

                adaptor.addChild(root_1, stream_identifier.nextTree());

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:135:28: ( ^( MODIFIERS attributeModifiers ) )?
                if ( stream_attributeModifiers.hasNext() ) {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:135:28: ^( MODIFIERS attributeModifiers )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(MODIFIERS, "MODIFIERS")
                    , root_2);

                    adaptor.addChild(root_2, stream_attributeModifiers.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_attributeModifiers.reset();

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


    public static class attributeModifiers_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "attributeModifiers"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:137:1: attributeModifiers : ( '[' attributeModifierAssignment ( ',' attributeModifierAssignment )* ']' )+ -> ( ^( MODIFIER attributeModifierAssignment ) )+ ;
    public final ImpexParser.attributeModifiers_return attributeModifiers() throws RecognitionException {
        ImpexParser.attributeModifiers_return retval = new ImpexParser.attributeModifiers_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token char_literal27=null;
        Token char_literal29=null;
        Token char_literal31=null;
        ImpexParser.attributeModifierAssignment_return attributeModifierAssignment28 =null;

        ImpexParser.attributeModifierAssignment_return attributeModifierAssignment30 =null;


        CommonTree char_literal27_tree=null;
        CommonTree char_literal29_tree=null;
        CommonTree char_literal31_tree=null;
        RewriteRuleTokenStream stream_LeftBracket=new RewriteRuleTokenStream(adaptor,"token LeftBracket");
        RewriteRuleTokenStream stream_RightBracket=new RewriteRuleTokenStream(adaptor,"token RightBracket");
        RewriteRuleTokenStream stream_64=new RewriteRuleTokenStream(adaptor,"token 64");
        RewriteRuleSubtreeStream stream_attributeModifierAssignment=new RewriteRuleSubtreeStream(adaptor,"rule attributeModifierAssignment");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:138:2: ( ( '[' attributeModifierAssignment ( ',' attributeModifierAssignment )* ']' )+ -> ( ^( MODIFIER attributeModifierAssignment ) )+ )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:138:4: ( '[' attributeModifierAssignment ( ',' attributeModifierAssignment )* ']' )+
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:138:4: ( '[' attributeModifierAssignment ( ',' attributeModifierAssignment )* ']' )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==LeftBracket) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:138:5: '[' attributeModifierAssignment ( ',' attributeModifierAssignment )* ']'
            	    {
            	    char_literal27=(Token)match(input,LeftBracket,FOLLOW_LeftBracket_in_attributeModifiers470);  
            	    stream_LeftBracket.add(char_literal27);


            	    pushFollow(FOLLOW_attributeModifierAssignment_in_attributeModifiers472);
            	    attributeModifierAssignment28=attributeModifierAssignment();

            	    state._fsp--;

            	    stream_attributeModifierAssignment.add(attributeModifierAssignment28.getTree());

            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:138:37: ( ',' attributeModifierAssignment )*
            	    loop13:
            	    do {
            	        int alt13=2;
            	        int LA13_0 = input.LA(1);

            	        if ( (LA13_0==64) ) {
            	            alt13=1;
            	        }


            	        switch (alt13) {
            	    	case 1 :
            	    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:138:38: ',' attributeModifierAssignment
            	    	    {
            	    	    char_literal29=(Token)match(input,64,FOLLOW_64_in_attributeModifiers475);  
            	    	    stream_64.add(char_literal29);


            	    	    pushFollow(FOLLOW_attributeModifierAssignment_in_attributeModifiers478);
            	    	    attributeModifierAssignment30=attributeModifierAssignment();

            	    	    state._fsp--;

            	    	    stream_attributeModifierAssignment.add(attributeModifierAssignment30.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop13;
            	        }
            	    } while (true);


            	    char_literal31=(Token)match(input,RightBracket,FOLLOW_RightBracket_in_attributeModifiers481);  
            	    stream_RightBracket.add(char_literal31);


            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            // AST REWRITE
            // elements: attributeModifierAssignment
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 139:2: -> ( ^( MODIFIER attributeModifierAssignment ) )+
            {
                if ( !(stream_attributeModifierAssignment.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_attributeModifierAssignment.hasNext() ) {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:139:5: ^( MODIFIER attributeModifierAssignment )
                    {
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    root_1 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(MODIFIER, "MODIFIER")
                    , root_1);

                    adaptor.addChild(root_1, stream_attributeModifierAssignment.nextTree());

                    adaptor.addChild(root_0, root_1);
                    }

                }
                stream_attributeModifierAssignment.reset();

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
    // $ANTLR end "attributeModifiers"


    public static class attributeModifierAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "attributeModifierAssignment"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:141:1: attributeModifierAssignment : attributeModifier '=' (hmValue= Bool |hmValue= Identifier |hmValue= Classname ) ;
    public final ImpexParser.attributeModifierAssignment_return attributeModifierAssignment() throws RecognitionException {
        ImpexParser.attributeModifierAssignment_return retval = new ImpexParser.attributeModifierAssignment_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token hmValue=null;
        Token char_literal33=null;
        ImpexParser.attributeModifier_return attributeModifier32 =null;


        CommonTree hmValue_tree=null;
        CommonTree char_literal33_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:142:2: ( attributeModifier '=' (hmValue= Bool |hmValue= Identifier |hmValue= Classname ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:142:4: attributeModifier '=' (hmValue= Bool |hmValue= Identifier |hmValue= Classname )
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_attributeModifier_in_attributeModifierAssignment502);
            attributeModifier32=attributeModifier();

            state._fsp--;

            adaptor.addChild(root_0, attributeModifier32.getTree());

            char_literal33=(Token)match(input,Equals,FOLLOW_Equals_in_attributeModifierAssignment504); 
            char_literal33_tree = 
            (CommonTree)adaptor.create(char_literal33)
            ;
            adaptor.addChild(root_0, char_literal33_tree);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:142:26: (hmValue= Bool |hmValue= Identifier |hmValue= Classname )
            int alt15=3;
            switch ( input.LA(1) ) {
            case Bool:
                {
                alt15=1;
                }
                break;
            case Identifier:
                {
                alt15=2;
                }
                break;
            case Classname:
                {
                alt15=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }

            switch (alt15) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:142:27: hmValue= Bool
                    {
                    hmValue=(Token)match(input,Bool,FOLLOW_Bool_in_attributeModifierAssignment509); 
                    hmValue_tree = 
                    (CommonTree)adaptor.create(hmValue)
                    ;
                    adaptor.addChild(root_0, hmValue_tree);


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:142:42: hmValue= Identifier
                    {
                    hmValue=(Token)match(input,Identifier,FOLLOW_Identifier_in_attributeModifierAssignment515); 
                    hmValue_tree = 
                    (CommonTree)adaptor.create(hmValue)
                    ;
                    adaptor.addChild(root_0, hmValue_tree);


                    }
                    break;
                case 3 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:142:64: hmValue= Classname
                    {
                    hmValue=(Token)match(input,Classname,FOLLOW_Classname_in_attributeModifierAssignment522); 
                    hmValue_tree = 
                    (CommonTree)adaptor.create(hmValue)
                    ;
                    adaptor.addChild(root_0, hmValue_tree);


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
    // $ANTLR end "attributeModifierAssignment"


    public static class identifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "identifier"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:144:1: identifier : Identifier ( '.' Identifier | ( '(' identifier ( ',' identifier )* ')' ) )? ;
    public final ImpexParser.identifier_return identifier() throws RecognitionException {
        ImpexParser.identifier_return retval = new ImpexParser.identifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Identifier34=null;
        Token char_literal35=null;
        Token Identifier36=null;
        Token char_literal37=null;
        Token char_literal39=null;
        Token char_literal41=null;
        ImpexParser.identifier_return identifier38 =null;

        ImpexParser.identifier_return identifier40 =null;


        CommonTree Identifier34_tree=null;
        CommonTree char_literal35_tree=null;
        CommonTree Identifier36_tree=null;
        CommonTree char_literal37_tree=null;
        CommonTree char_literal39_tree=null;
        CommonTree char_literal41_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:144:12: ( Identifier ( '.' Identifier | ( '(' identifier ( ',' identifier )* ')' ) )? )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:144:13: Identifier ( '.' Identifier | ( '(' identifier ( ',' identifier )* ')' ) )?
            {
            root_0 = (CommonTree)adaptor.nil();


            Identifier34=(Token)match(input,Identifier,FOLLOW_Identifier_in_identifier531); 
            Identifier34_tree = 
            (CommonTree)adaptor.create(Identifier34)
            ;
            adaptor.addChild(root_0, Identifier34_tree);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:144:24: ( '.' Identifier | ( '(' identifier ( ',' identifier )* ')' ) )?
            int alt17=3;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==65) ) {
                alt17=1;
            }
            else if ( (LA17_0==LeftParenthesis) ) {
                alt17=2;
            }
            switch (alt17) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:144:25: '.' Identifier
                    {
                    char_literal35=(Token)match(input,65,FOLLOW_65_in_identifier534); 
                    char_literal35_tree = 
                    (CommonTree)adaptor.create(char_literal35)
                    ;
                    adaptor.addChild(root_0, char_literal35_tree);


                    Identifier36=(Token)match(input,Identifier,FOLLOW_Identifier_in_identifier536); 
                    Identifier36_tree = 
                    (CommonTree)adaptor.create(Identifier36)
                    ;
                    adaptor.addChild(root_0, Identifier36_tree);


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:144:43: ( '(' identifier ( ',' identifier )* ')' )
                    {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:144:43: ( '(' identifier ( ',' identifier )* ')' )
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:144:44: '(' identifier ( ',' identifier )* ')'
                    {
                    char_literal37=(Token)match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_identifier542); 
                    char_literal37_tree = 
                    (CommonTree)adaptor.create(char_literal37)
                    ;
                    adaptor.addChild(root_0, char_literal37_tree);


                    pushFollow(FOLLOW_identifier_in_identifier544);
                    identifier38=identifier();

                    state._fsp--;

                    adaptor.addChild(root_0, identifier38.getTree());

                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:144:59: ( ',' identifier )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==64) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:144:60: ',' identifier
                    	    {
                    	    char_literal39=(Token)match(input,64,FOLLOW_64_in_identifier547); 
                    	    char_literal39_tree = 
                    	    (CommonTree)adaptor.create(char_literal39)
                    	    ;
                    	    adaptor.addChild(root_0, char_literal39_tree);


                    	    pushFollow(FOLLOW_identifier_in_identifier549);
                    	    identifier40=identifier();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, identifier40.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);


                    char_literal41=(Token)match(input,RightParenthesis,FOLLOW_RightParenthesis_in_identifier553); 
                    char_literal41_tree = 
                    (CommonTree)adaptor.create(char_literal41)
                    ;
                    adaptor.addChild(root_0, char_literal41_tree);


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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:146:1: macro : Macrodef Macroval -> ^( ASSIGNEMENT Macrodef Macroval ) ;
    public final ImpexParser.macro_return macro() throws RecognitionException {
        ImpexParser.macro_return retval = new ImpexParser.macro_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Macrodef42=null;
        Token Macroval43=null;

        CommonTree Macrodef42_tree=null;
        CommonTree Macroval43_tree=null;
        RewriteRuleTokenStream stream_Macroval=new RewriteRuleTokenStream(adaptor,"token Macroval");
        RewriteRuleTokenStream stream_Macrodef=new RewriteRuleTokenStream(adaptor,"token Macrodef");

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:147:2: ( Macrodef Macroval -> ^( ASSIGNEMENT Macrodef Macroval ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:147:3: Macrodef Macroval
            {
            Macrodef42=(Token)match(input,Macrodef,FOLLOW_Macrodef_in_macro564);  
            stream_Macrodef.add(Macrodef42);


            Macroval43=(Token)match(input,Macroval,FOLLOW_Macroval_in_macro566);  
            stream_Macroval.add(Macroval43);


            // AST REWRITE
            // elements: Macrodef, Macroval
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 148:2: -> ^( ASSIGNEMENT Macrodef Macroval )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:148:5: ^( ASSIGNEMENT Macrodef Macroval )
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:150:1: attributeModifier : ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual );
    public final ImpexParser.attributeModifier_return attributeModifier() throws RecognitionException {
        ImpexParser.attributeModifier_return retval = new ImpexParser.attributeModifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set44=null;

        CommonTree set44_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:150:19: ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set44=(Token)input.LT(1);

            if ( (input.LA(1) >= Alias && input.LA(1) <= AllowNull)||input.LA(1)==CellDecorator||input.LA(1)==CollectionDelimiter||(input.LA(1) >= Dateformat && input.LA(1) <= Default)||input.LA(1)==ForceWrite||(input.LA(1) >= IgnoreKeyCase && input.LA(1) <= IgnoreNull)||(input.LA(1) >= KeyToValueDelimiter && input.LA(1) <= Lang)||(input.LA(1) >= MapDelimiter && input.LA(1) <= Pos)||(input.LA(1) >= Translator && input.LA(1) <= Unique)||input.LA(1)==Virtual ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set44)
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


    public static class headerMode_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "headerMode"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:154:1: headerMode : ( Insert | InsertUpdate | Update | Remove );
    public final ImpexParser.headerMode_return headerMode() throws RecognitionException {
        ImpexParser.headerMode_return retval = new ImpexParser.headerMode_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set45=null;

        CommonTree set45_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:154:13: ( Insert | InsertUpdate | Update | Remove )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set45=(Token)input.LT(1);

            if ( (input.LA(1) >= Insert && input.LA(1) <= InsertUpdate)||input.LA(1)==Remove||input.LA(1)==Update ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set45)
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
        "\1\40\1\uffff\1\31\1\uffff";
    static final String DFA4_maxS =
        "\1\75\1\uffff\1\75\1\uffff";
    static final String DFA4_acceptS =
        "\1\uffff\1\2\1\uffff\1\1";
    static final String DFA4_specialS =
        "\4\uffff}>";
    static final String[] DFA4_transitionS = {
            "\2\1\2\uffff\1\2\5\uffff\1\1\12\uffff\1\1\7\uffff\1\1",
            "",
            "\1\3\3\uffff\1\3\2\uffff\2\1\2\uffff\1\2\5\uffff\1\1\7\uffff"+
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
            return "()+ loopback of 114:16: ( ( Lb )+ record )+";
        }
    }
 

    public static final BitSet FOLLOW_EOF_in_parse157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Lb_in_impex169 = new BitSet(new long[]{0x2020041300000000L});
    public static final BitSet FOLLOW_block_in_impex174 = new BitSet(new long[]{0x2020041300000000L});
    public static final BitSet FOLLOW_macro_in_impex178 = new BitSet(new long[]{0x2020041300000000L});
    public static final BitSet FOLLOW_EOF_in_impex182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_header_in_block220 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_Lb_in_block223 = new BitSet(new long[]{0x0004001022000000L});
    public static final BitSet FOLLOW_record_in_block227 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_headerMode_in_header254 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_Identifier_in_header257 = new BitSet(new long[]{0x0200002000000002L});
    public static final BitSet FOLLOW_headerModifiers_in_header259 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_Semicolon_in_header264 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_attribute_in_header266 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_LeftBracket_in_headerModifiers309 = new BitSet(new long[]{0x0002000000005000L});
    public static final BitSet FOLLOW_headerModifierAssignment_in_headerModifiers311 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_headerModifiers314 = new BitSet(new long[]{0x0002000000005000L});
    public static final BitSet FOLLOW_headerModifierAssignment_in_headerModifiers317 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_RightBracket_in_headerModifiers320 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_headerModifier_in_headerModifierAssignment339 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_Equals_in_headerModifierAssignment341 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_Bool_in_headerModifierAssignment346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Classname_in_headerModifierAssignment352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_record388 = new BitSet(new long[]{0x0004000002000000L});
    public static final BitSet FOLLOW_QuotedField_in_record392 = new BitSet(new long[]{0x0004000002000002L});
    public static final BitSet FOLLOW_Field_in_record396 = new BitSet(new long[]{0x0004000002000002L});
    public static final BitSet FOLLOW_identifier_in_attribute440 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_attributeModifiers_in_attribute443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftBracket_in_attributeModifiers470 = new BitSet(new long[]{0x5801F00CC4348300L});
    public static final BitSet FOLLOW_attributeModifierAssignment_in_attributeModifiers472 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_attributeModifiers475 = new BitSet(new long[]{0x5801F00CC4348300L});
    public static final BitSet FOLLOW_attributeModifierAssignment_in_attributeModifiers478 = new BitSet(new long[]{0x0040000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_RightBracket_in_attributeModifiers481 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_attributeModifier_in_attributeModifierAssignment502 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_Equals_in_attributeModifierAssignment504 = new BitSet(new long[]{0x0000000020022000L});
    public static final BitSet FOLLOW_Bool_in_attributeModifierAssignment509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_attributeModifierAssignment515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Classname_in_attributeModifierAssignment522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_identifier531 = new BitSet(new long[]{0x0000004000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_identifier534 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_Identifier_in_identifier536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftParenthesis_in_identifier542 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_identifier_in_identifier544 = new BitSet(new long[]{0x0080000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_identifier547 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_identifier_in_identifier549 = new BitSet(new long[]{0x0080000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_RightParenthesis_in_identifier553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Macrodef_in_macro564 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_Macroval_in_macro566 = new BitSet(new long[]{0x0000000000000002L});

}