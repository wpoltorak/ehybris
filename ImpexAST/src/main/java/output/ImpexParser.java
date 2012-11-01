// $ANTLR 3.4 /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g 2012-11-01 07:59:36

  package output;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class ImpexParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGNEMENT", "ASSIGNEMENTS", "ATTRIBUTE", "ATTRIBUTES", "Alias", "AllowNull", "BLOCK", "BLOCKS", "BatchMode", "Bool", "CacheUnique", "CellDecorator", "Char", "CollectionDelimiter", "Comment", "Dateformat", "Default", "DoubleQuote", "Equals", "Field", "ForceWrite", "HEADER", "IMPEX", "Identifier", "IgnoreKeyCase", "IgnoreNull", "Insert", "InsertUpdate", "KeyToValueDelimiter", "Lang", "Lb", "LeftBracket", "LeftParenthesis", "LineContinuation", "MODIFIER", "Macrodef", "Macroval", "MapDelimiter", "Mode", "NumberFormat", "PathDelimiter", "Pos", "Processor", "QuotedField", "ROW", "ROWS", "Remove", "RightBracket", "RightParenthesis", "Semicolon", "Translator", "Unique", "Update", "Virtual", "Ws", "','", "'.'", "'\\n'", "'\\r'"
    };

    public static final int EOF=-1;
    public static final int T__59=59;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int T__62=62;
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
    public static final int Field=23;
    public static final int ForceWrite=24;
    public static final int HEADER=25;
    public static final int IMPEX=26;
    public static final int Identifier=27;
    public static final int IgnoreKeyCase=28;
    public static final int IgnoreNull=29;
    public static final int Insert=30;
    public static final int InsertUpdate=31;
    public static final int KeyToValueDelimiter=32;
    public static final int Lang=33;
    public static final int Lb=34;
    public static final int LeftBracket=35;
    public static final int LeftParenthesis=36;
    public static final int LineContinuation=37;
    public static final int MODIFIER=38;
    public static final int Macrodef=39;
    public static final int Macroval=40;
    public static final int MapDelimiter=41;
    public static final int Mode=42;
    public static final int NumberFormat=43;
    public static final int PathDelimiter=44;
    public static final int Pos=45;
    public static final int Processor=46;
    public static final int QuotedField=47;
    public static final int ROW=48;
    public static final int ROWS=49;
    public static final int Remove=50;
    public static final int RightBracket=51;
    public static final int RightParenthesis=52;
    public static final int Semicolon=53;
    public static final int Translator=54;
    public static final int Unique=55;
    public static final int Update=56;
    public static final int Virtual=57;
    public static final int Ws=58;

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


        private boolean lineBreakNotFound() {
            int index = ((CommonTokenStream)input).LT(-1).getTokenIndex();
            int current  = ((CommonTokenStream)input).index();
            for (int i = index + 1; i < current; i++){
                if (input.get(i).getType() == Lb){
                    return false;
                }
            }
         return true; 	
        }



    public static class parse_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parse"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:119:1: parse : (t= . )* EOF ;
    public final ImpexParser.parse_return parse() throws RecognitionException {
        ImpexParser.parse_return retval = new ImpexParser.parse_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token t=null;
        Token EOF1=null;

        CommonTree t_tree=null;
        CommonTree EOF1_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:120:3: ( (t= . )* EOF )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:120:6: (t= . )* EOF
            {
            root_0 = (CommonTree)adaptor.nil();


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:120:6: (t= . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= ASSIGNEMENT && LA1_0 <= 62)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:120:7: t= .
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:123:1: impex : ( block | macro )* EOF -> ^( IMPEX ^( ASSIGNEMENTS ( macro )* ) ^( BLOCKS ( block )* ) ) ;
    public final ImpexParser.impex_return impex() throws RecognitionException {
        ImpexParser.impex_return retval = new ImpexParser.impex_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token EOF4=null;
        ImpexParser.block_return block2 =null;

        ImpexParser.macro_return macro3 =null;


        CommonTree EOF4_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_macro=new RewriteRuleSubtreeStream(adaptor,"rule macro");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:123:7: ( ( block | macro )* EOF -> ^( IMPEX ^( ASSIGNEMENTS ( macro )* ) ^( BLOCKS ( block )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:123:9: ( block | macro )* EOF
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:123:9: ( block | macro )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= Insert && LA2_0 <= InsertUpdate)||LA2_0==Remove||LA2_0==Update) ) {
                    alt2=1;
                }
                else if ( (LA2_0==Macrodef) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:124:3: block
            	    {
            	    pushFollow(FOLLOW_block_in_impex172);
            	    block2=block();

            	    state._fsp--;

            	    stream_block.add(block2.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:125:4: macro
            	    {
            	    pushFollow(FOLLOW_macro_in_impex177);
            	    macro3=macro();

            	    state._fsp--;

            	    stream_macro.add(macro3.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            EOF4=(Token)match(input,EOF,FOLLOW_EOF_in_impex187);  
            stream_EOF.add(EOF4);


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
            // 129:3: -> ^( IMPEX ^( ASSIGNEMENTS ( macro )* ) ^( BLOCKS ( block )* ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:129:6: ^( IMPEX ^( ASSIGNEMENTS ( macro )* ) ^( BLOCKS ( block )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IMPEX, "IMPEX")
                , root_1);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:131:3: ^( ASSIGNEMENTS ( macro )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ASSIGNEMENTS, "ASSIGNEMENTS")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:131:18: ( macro )*
                while ( stream_macro.hasNext() ) {
                    adaptor.addChild(root_2, stream_macro.nextTree());

                }
                stream_macro.reset();

                adaptor.addChild(root_1, root_2);
                }

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:132:3: ^( BLOCKS ( block )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCKS, "BLOCKS")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:132:12: ( block )*
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:138:1: block : header Lb ( record )+ -> ^( BLOCK header ^( ROWS ( record )+ ) ) ;
    public final ImpexParser.block_return block() throws RecognitionException {
        ImpexParser.block_return retval = new ImpexParser.block_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Lb6=null;
        ImpexParser.header_return header5 =null;

        ImpexParser.record_return record7 =null;


        CommonTree Lb6_tree=null;
        RewriteRuleTokenStream stream_Lb=new RewriteRuleTokenStream(adaptor,"token Lb");
        RewriteRuleSubtreeStream stream_record=new RewriteRuleSubtreeStream(adaptor,"rule record");
        RewriteRuleSubtreeStream stream_header=new RewriteRuleSubtreeStream(adaptor,"rule header");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:138:7: ( header Lb ( record )+ -> ^( BLOCK header ^( ROWS ( record )+ ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:138:9: header Lb ( record )+
            {
            pushFollow(FOLLOW_header_in_block237);
            header5=header();

            state._fsp--;

            stream_header.add(header5.getTree());

            Lb6=(Token)match(input,Lb,FOLLOW_Lb_in_block239);  
            stream_Lb.add(Lb6);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:138:19: ( record )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==Field||LA3_0==QuotedField) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:138:20: record
            	    {
            	    pushFollow(FOLLOW_record_in_block242);
            	    record7=record();

            	    state._fsp--;

            	    stream_record.add(record7.getTree());

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
            // elements: header, record
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 139:2: -> ^( BLOCK header ^( ROWS ( record )+ ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:139:5: ^( BLOCK header ^( ROWS ( record )+ ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCK, "BLOCK")
                , root_1);

                adaptor.addChild(root_1, stream_header.nextTree());

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:139:20: ^( ROWS ( record )+ )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ROWS, "ROWS")
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:141:1: header : headerMode Identifier ( '[' headerModifier '=' (hmValue= Bool |hmValue= Identifier ) ']' )? ( ';' attribute )* -> ^( HEADER headerMode Identifier ( ^( MODIFIER headerModifier $hmValue) )? ^( ATTRIBUTES ( attribute )* ) ) ;
    public final ImpexParser.header_return header() throws RecognitionException {
        ImpexParser.header_return retval = new ImpexParser.header_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token hmValue=null;
        Token Identifier9=null;
        Token char_literal10=null;
        Token char_literal12=null;
        Token char_literal13=null;
        Token char_literal14=null;
        ImpexParser.headerMode_return headerMode8 =null;

        ImpexParser.headerModifier_return headerModifier11 =null;

        ImpexParser.attribute_return attribute15 =null;


        CommonTree hmValue_tree=null;
        CommonTree Identifier9_tree=null;
        CommonTree char_literal10_tree=null;
        CommonTree char_literal12_tree=null;
        CommonTree char_literal13_tree=null;
        CommonTree char_literal14_tree=null;
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:142:2: ( headerMode Identifier ( '[' headerModifier '=' (hmValue= Bool |hmValue= Identifier ) ']' )? ( ';' attribute )* -> ^( HEADER headerMode Identifier ( ^( MODIFIER headerModifier $hmValue) )? ^( ATTRIBUTES ( attribute )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:142:4: headerMode Identifier ( '[' headerModifier '=' (hmValue= Bool |hmValue= Identifier ) ']' )? ( ';' attribute )*
            {
            pushFollow(FOLLOW_headerMode_in_header269);
            headerMode8=headerMode();

            state._fsp--;

            stream_headerMode.add(headerMode8.getTree());

            Identifier9=(Token)match(input,Identifier,FOLLOW_Identifier_in_header272);  
            stream_Identifier.add(Identifier9);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:142:27: ( '[' headerModifier '=' (hmValue= Bool |hmValue= Identifier ) ']' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==LeftBracket) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:142:28: '[' headerModifier '=' (hmValue= Bool |hmValue= Identifier ) ']'
                    {
                    char_literal10=(Token)match(input,LeftBracket,FOLLOW_LeftBracket_in_header275);  
                    stream_LeftBracket.add(char_literal10);


                    pushFollow(FOLLOW_headerModifier_in_header277);
                    headerModifier11=headerModifier();

                    state._fsp--;

                    stream_headerModifier.add(headerModifier11.getTree());

                    char_literal12=(Token)match(input,Equals,FOLLOW_Equals_in_header279);  
                    stream_Equals.add(char_literal12);


                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:142:51: (hmValue= Bool |hmValue= Identifier )
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
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:142:52: hmValue= Bool
                            {
                            hmValue=(Token)match(input,Bool,FOLLOW_Bool_in_header284);  
                            stream_Bool.add(hmValue);


                            }
                            break;
                        case 2 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:142:67: hmValue= Identifier
                            {
                            hmValue=(Token)match(input,Identifier,FOLLOW_Identifier_in_header290);  
                            stream_Identifier.add(hmValue);


                            }
                            break;

                    }


                    char_literal13=(Token)match(input,RightBracket,FOLLOW_RightBracket_in_header293);  
                    stream_RightBracket.add(char_literal13);


                    }
                    break;

            }


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:142:94: ( ';' attribute )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==Semicolon) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:142:95: ';' attribute
            	    {
            	    char_literal14=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_header299);  
            	    stream_Semicolon.add(char_literal14);


            	    pushFollow(FOLLOW_attribute_in_header301);
            	    attribute15=attribute();

            	    state._fsp--;

            	    stream_attribute.add(attribute15.getTree());

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            // AST REWRITE
            // elements: Identifier, headerModifier, headerMode, hmValue, attribute
            // token labels: hmValue
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_hmValue=new RewriteRuleTokenStream(adaptor,"token hmValue",hmValue);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 143:2: -> ^( HEADER headerMode Identifier ( ^( MODIFIER headerModifier $hmValue) )? ^( ATTRIBUTES ( attribute )* ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:143:5: ^( HEADER headerMode Identifier ( ^( MODIFIER headerModifier $hmValue) )? ^( ATTRIBUTES ( attribute )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(HEADER, "HEADER")
                , root_1);

                adaptor.addChild(root_1, stream_headerMode.nextTree());

                adaptor.addChild(root_1, 
                stream_Identifier.nextNode()
                );

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:143:36: ( ^( MODIFIER headerModifier $hmValue) )?
                if ( stream_headerModifier.hasNext()||stream_hmValue.hasNext() ) {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:143:36: ^( MODIFIER headerModifier $hmValue)
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

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:143:73: ^( ATTRIBUTES ( attribute )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ATTRIBUTES, "ATTRIBUTES")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:143:86: ( attribute )*
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:145:1: record : ( QuotedField | Field )+ ( ( ( ( '\\r' )? '\\n' | '\\r' ) ) | EOF ) -> ^( ROW ( QuotedField )+ ( Field )+ ) ;
    public final ImpexParser.record_return record() throws RecognitionException {
        ImpexParser.record_return retval = new ImpexParser.record_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token QuotedField16=null;
        Token Field17=null;
        Token char_literal18=null;
        Token char_literal19=null;
        Token char_literal20=null;
        Token EOF21=null;

        CommonTree QuotedField16_tree=null;
        CommonTree Field17_tree=null;
        CommonTree char_literal18_tree=null;
        CommonTree char_literal19_tree=null;
        CommonTree char_literal20_tree=null;
        CommonTree EOF21_tree=null;
        RewriteRuleTokenStream stream_Field=new RewriteRuleTokenStream(adaptor,"token Field");
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleTokenStream stream_62=new RewriteRuleTokenStream(adaptor,"token 62");
        RewriteRuleTokenStream stream_61=new RewriteRuleTokenStream(adaptor,"token 61");
        RewriteRuleTokenStream stream_QuotedField=new RewriteRuleTokenStream(adaptor,"token QuotedField");

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:146:5: ( ( QuotedField | Field )+ ( ( ( ( '\\r' )? '\\n' | '\\r' ) ) | EOF ) -> ^( ROW ( QuotedField )+ ( Field )+ ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:146:6: ( QuotedField | Field )+ ( ( ( ( '\\r' )? '\\n' | '\\r' ) ) | EOF )
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:146:6: ( QuotedField | Field )+
            int cnt7=0;
            loop7:
            do {
                int alt7=3;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==QuotedField) ) {
                    alt7=1;
                }
                else if ( (LA7_0==Field) ) {
                    alt7=2;
                }


                switch (alt7) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:146:7: QuotedField
            	    {
            	    QuotedField16=(Token)match(input,QuotedField,FOLLOW_QuotedField_in_record344);  
            	    stream_QuotedField.add(QuotedField16);


            	    }
            	    break;
            	case 2 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:146:21: Field
            	    {
            	    Field17=(Token)match(input,Field,FOLLOW_Field_in_record348);  
            	    stream_Field.add(Field17);


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:146:29: ( ( ( ( '\\r' )? '\\n' | '\\r' ) ) | EOF )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0 >= 61 && LA10_0 <= 62)) ) {
                alt10=1;
            }
            else if ( (LA10_0==EOF) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }
            switch (alt10) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:146:30: ( ( ( '\\r' )? '\\n' | '\\r' ) )
                    {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:146:30: ( ( ( '\\r' )? '\\n' | '\\r' ) )
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:146:31: ( ( '\\r' )? '\\n' | '\\r' )
                    {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:146:31: ( ( '\\r' )? '\\n' | '\\r' )
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==62) ) {
                        int LA9_1 = input.LA(2);

                        if ( (LA9_1==61) ) {
                            alt9=1;
                        }
                        else if ( (LA9_1==EOF||LA9_1==Field||(LA9_1 >= Insert && LA9_1 <= InsertUpdate)||LA9_1==Macrodef||LA9_1==QuotedField||LA9_1==Remove||LA9_1==Update) ) {
                            alt9=2;
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 9, 1, input);

                            throw nvae;

                        }
                    }
                    else if ( (LA9_0==61) ) {
                        alt9=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 0, input);

                        throw nvae;

                    }
                    switch (alt9) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:146:32: ( '\\r' )? '\\n'
                            {
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:146:32: ( '\\r' )?
                            int alt8=2;
                            int LA8_0 = input.LA(1);

                            if ( (LA8_0==62) ) {
                                alt8=1;
                            }
                            switch (alt8) {
                                case 1 :
                                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:146:32: '\\r'
                                    {
                                    char_literal18=(Token)match(input,62,FOLLOW_62_in_record355);  
                                    stream_62.add(char_literal18);


                                    }
                                    break;

                            }


                            char_literal19=(Token)match(input,61,FOLLOW_61_in_record358);  
                            stream_61.add(char_literal19);


                            }
                            break;
                        case 2 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:146:45: '\\r'
                            {
                            char_literal20=(Token)match(input,62,FOLLOW_62_in_record362);  
                            stream_62.add(char_literal20);


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:146:55: EOF
                    {
                    EOF21=(Token)match(input,EOF,FOLLOW_EOF_in_record369);  
                    stream_EOF.add(EOF21);


                    }
                    break;

            }


            // AST REWRITE
            // elements: QuotedField, Field
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 148:6: -> ^( ROW ( QuotedField )+ ( Field )+ )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:148:9: ^( ROW ( QuotedField )+ ( Field )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ROW, "ROW")
                , root_1);

                if ( !(stream_QuotedField.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_QuotedField.hasNext() ) {
                    adaptor.addChild(root_1, 
                    stream_QuotedField.nextNode()
                    );

                }
                stream_QuotedField.reset();

                if ( !(stream_Field.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_Field.hasNext() ) {
                    adaptor.addChild(root_1, 
                    stream_Field.nextNode()
                    );

                }
                stream_Field.reset();

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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:153:1: attribute : identifier ( '[' attributeModifier '=' (amValue= Bool |amValue= Identifier ) ']' )? -> ^( ATTRIBUTE identifier ( ^( MODIFIER attributeModifier $amValue) )? ) ;
    public final ImpexParser.attribute_return attribute() throws RecognitionException {
        ImpexParser.attribute_return retval = new ImpexParser.attribute_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token amValue=null;
        Token char_literal23=null;
        Token char_literal25=null;
        Token char_literal26=null;
        ImpexParser.identifier_return identifier22 =null;

        ImpexParser.attributeModifier_return attributeModifier24 =null;


        CommonTree amValue_tree=null;
        CommonTree char_literal23_tree=null;
        CommonTree char_literal25_tree=null;
        CommonTree char_literal26_tree=null;
        RewriteRuleTokenStream stream_LeftBracket=new RewriteRuleTokenStream(adaptor,"token LeftBracket");
        RewriteRuleTokenStream stream_Bool=new RewriteRuleTokenStream(adaptor,"token Bool");
        RewriteRuleTokenStream stream_RightBracket=new RewriteRuleTokenStream(adaptor,"token RightBracket");
        RewriteRuleTokenStream stream_Equals=new RewriteRuleTokenStream(adaptor,"token Equals");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_attributeModifier=new RewriteRuleSubtreeStream(adaptor,"rule attributeModifier");
        RewriteRuleSubtreeStream stream_identifier=new RewriteRuleSubtreeStream(adaptor,"rule identifier");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:153:11: ( identifier ( '[' attributeModifier '=' (amValue= Bool |amValue= Identifier ) ']' )? -> ^( ATTRIBUTE identifier ( ^( MODIFIER attributeModifier $amValue) )? ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:153:13: identifier ( '[' attributeModifier '=' (amValue= Bool |amValue= Identifier ) ']' )?
            {
            pushFollow(FOLLOW_identifier_in_attribute405);
            identifier22=identifier();

            state._fsp--;

            stream_identifier.add(identifier22.getTree());

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:153:24: ( '[' attributeModifier '=' (amValue= Bool |amValue= Identifier ) ']' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==LeftBracket) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:153:25: '[' attributeModifier '=' (amValue= Bool |amValue= Identifier ) ']'
                    {
                    char_literal23=(Token)match(input,LeftBracket,FOLLOW_LeftBracket_in_attribute408);  
                    stream_LeftBracket.add(char_literal23);


                    pushFollow(FOLLOW_attributeModifier_in_attribute410);
                    attributeModifier24=attributeModifier();

                    state._fsp--;

                    stream_attributeModifier.add(attributeModifier24.getTree());

                    char_literal25=(Token)match(input,Equals,FOLLOW_Equals_in_attribute412);  
                    stream_Equals.add(char_literal25);


                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:153:51: (amValue= Bool |amValue= Identifier )
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==Bool) ) {
                        alt11=1;
                    }
                    else if ( (LA11_0==Identifier) ) {
                        alt11=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 0, input);

                        throw nvae;

                    }
                    switch (alt11) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:153:52: amValue= Bool
                            {
                            amValue=(Token)match(input,Bool,FOLLOW_Bool_in_attribute417);  
                            stream_Bool.add(amValue);


                            }
                            break;
                        case 2 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:153:66: amValue= Identifier
                            {
                            amValue=(Token)match(input,Identifier,FOLLOW_Identifier_in_attribute422);  
                            stream_Identifier.add(amValue);


                            }
                            break;

                    }


                    char_literal26=(Token)match(input,RightBracket,FOLLOW_RightBracket_in_attribute425);  
                    stream_RightBracket.add(char_literal26);


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
            // 154:2: -> ^( ATTRIBUTE identifier ( ^( MODIFIER attributeModifier $amValue) )? )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:154:5: ^( ATTRIBUTE identifier ( ^( MODIFIER attributeModifier $amValue) )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ATTRIBUTE, "ATTRIBUTE")
                , root_1);

                adaptor.addChild(root_1, stream_identifier.nextTree());

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:154:28: ( ^( MODIFIER attributeModifier $amValue) )?
                if ( stream_amValue.hasNext()||stream_attributeModifier.hasNext() ) {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:154:28: ^( MODIFIER attributeModifier $amValue)
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:156:1: identifier : Identifier ( '.' Identifier | ( '(' identifier ( ',' identifier )* ')' ) )? ;
    public final ImpexParser.identifier_return identifier() throws RecognitionException {
        ImpexParser.identifier_return retval = new ImpexParser.identifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Identifier27=null;
        Token char_literal28=null;
        Token Identifier29=null;
        Token char_literal30=null;
        Token char_literal32=null;
        Token char_literal34=null;
        ImpexParser.identifier_return identifier31 =null;

        ImpexParser.identifier_return identifier33 =null;


        CommonTree Identifier27_tree=null;
        CommonTree char_literal28_tree=null;
        CommonTree Identifier29_tree=null;
        CommonTree char_literal30_tree=null;
        CommonTree char_literal32_tree=null;
        CommonTree char_literal34_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:156:12: ( Identifier ( '.' Identifier | ( '(' identifier ( ',' identifier )* ')' ) )? )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:156:13: Identifier ( '.' Identifier | ( '(' identifier ( ',' identifier )* ')' ) )?
            {
            root_0 = (CommonTree)adaptor.nil();


            Identifier27=(Token)match(input,Identifier,FOLLOW_Identifier_in_identifier453); 
            Identifier27_tree = 
            (CommonTree)adaptor.create(Identifier27)
            ;
            adaptor.addChild(root_0, Identifier27_tree);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:156:24: ( '.' Identifier | ( '(' identifier ( ',' identifier )* ')' ) )?
            int alt14=3;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==60) ) {
                alt14=1;
            }
            else if ( (LA14_0==LeftParenthesis) ) {
                alt14=2;
            }
            switch (alt14) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:156:25: '.' Identifier
                    {
                    char_literal28=(Token)match(input,60,FOLLOW_60_in_identifier456); 
                    char_literal28_tree = 
                    (CommonTree)adaptor.create(char_literal28)
                    ;
                    adaptor.addChild(root_0, char_literal28_tree);


                    Identifier29=(Token)match(input,Identifier,FOLLOW_Identifier_in_identifier458); 
                    Identifier29_tree = 
                    (CommonTree)adaptor.create(Identifier29)
                    ;
                    adaptor.addChild(root_0, Identifier29_tree);


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:156:43: ( '(' identifier ( ',' identifier )* ')' )
                    {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:156:43: ( '(' identifier ( ',' identifier )* ')' )
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:156:44: '(' identifier ( ',' identifier )* ')'
                    {
                    char_literal30=(Token)match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_identifier464); 
                    char_literal30_tree = 
                    (CommonTree)adaptor.create(char_literal30)
                    ;
                    adaptor.addChild(root_0, char_literal30_tree);


                    pushFollow(FOLLOW_identifier_in_identifier466);
                    identifier31=identifier();

                    state._fsp--;

                    adaptor.addChild(root_0, identifier31.getTree());

                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:156:59: ( ',' identifier )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==59) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:156:60: ',' identifier
                    	    {
                    	    char_literal32=(Token)match(input,59,FOLLOW_59_in_identifier469); 
                    	    char_literal32_tree = 
                    	    (CommonTree)adaptor.create(char_literal32)
                    	    ;
                    	    adaptor.addChild(root_0, char_literal32_tree);


                    	    pushFollow(FOLLOW_identifier_in_identifier471);
                    	    identifier33=identifier();

                    	    state._fsp--;

                    	    adaptor.addChild(root_0, identifier33.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    char_literal34=(Token)match(input,RightParenthesis,FOLLOW_RightParenthesis_in_identifier475); 
                    char_literal34_tree = 
                    (CommonTree)adaptor.create(char_literal34)
                    ;
                    adaptor.addChild(root_0, char_literal34_tree);


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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:160:1: macro : Macrodef Macroval -> ^( ASSIGNEMENT Macrodef Macroval ) ;
    public final ImpexParser.macro_return macro() throws RecognitionException {
        ImpexParser.macro_return retval = new ImpexParser.macro_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Macrodef35=null;
        Token Macroval36=null;

        CommonTree Macrodef35_tree=null;
        CommonTree Macroval36_tree=null;
        RewriteRuleTokenStream stream_Macroval=new RewriteRuleTokenStream(adaptor,"token Macroval");
        RewriteRuleTokenStream stream_Macrodef=new RewriteRuleTokenStream(adaptor,"token Macrodef");

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:161:2: ( Macrodef Macroval -> ^( ASSIGNEMENT Macrodef Macroval ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:161:3: Macrodef Macroval
            {
            Macrodef35=(Token)match(input,Macrodef,FOLLOW_Macrodef_in_macro493);  
            stream_Macrodef.add(Macrodef35);


            Macroval36=(Token)match(input,Macroval,FOLLOW_Macroval_in_macro495);  
            stream_Macroval.add(Macroval36);


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
            // 162:2: -> ^( ASSIGNEMENT Macrodef Macroval )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:162:5: ^( ASSIGNEMENT Macrodef Macroval )
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


    public static class headerMode_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "headerMode"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:190:1: headerMode : ( Insert | InsertUpdate | Update | Remove );
    public final ImpexParser.headerMode_return headerMode() throws RecognitionException {
        ImpexParser.headerMode_return retval = new ImpexParser.headerMode_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set37=null;

        CommonTree set37_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:190:13: ( Insert | InsertUpdate | Update | Remove )
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


    public static class headerModifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "headerModifier"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:196:1: headerModifier : ( BatchMode | CacheUnique | Processor );
    public final ImpexParser.headerModifier_return headerModifier() throws RecognitionException {
        ImpexParser.headerModifier_return retval = new ImpexParser.headerModifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set38=null;

        CommonTree set38_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:196:17: ( BatchMode | CacheUnique | Processor )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set38=(Token)input.LT(1);

            if ( input.LA(1)==BatchMode||input.LA(1)==CacheUnique||input.LA(1)==Processor ) {
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
    // $ANTLR end "headerModifier"


    public static class attributeModifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "attributeModifier"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:221:1: attributeModifier : ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual );
    public final ImpexParser.attributeModifier_return attributeModifier() throws RecognitionException {
        ImpexParser.attributeModifier_return retval = new ImpexParser.attributeModifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set39=null;

        CommonTree set39_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:221:19: ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set39=(Token)input.LT(1);

            if ( (input.LA(1) >= Alias && input.LA(1) <= AllowNull)||input.LA(1)==CellDecorator||input.LA(1)==CollectionDelimiter||(input.LA(1) >= Dateformat && input.LA(1) <= Default)||input.LA(1)==ForceWrite||(input.LA(1) >= IgnoreKeyCase && input.LA(1) <= IgnoreNull)||(input.LA(1) >= KeyToValueDelimiter && input.LA(1) <= Lang)||(input.LA(1) >= MapDelimiter && input.LA(1) <= Pos)||(input.LA(1) >= Translator && input.LA(1) <= Unique)||input.LA(1)==Virtual ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set39)
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

    // Delegated rules


 

    public static final BitSet FOLLOW_EOF_in_parse153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_block_in_impex172 = new BitSet(new long[]{0x01040080C0000000L});
    public static final BitSet FOLLOW_macro_in_impex177 = new BitSet(new long[]{0x01040080C0000000L});
    public static final BitSet FOLLOW_EOF_in_impex187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_header_in_block237 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_Lb_in_block239 = new BitSet(new long[]{0x0000800000800000L});
    public static final BitSet FOLLOW_record_in_block242 = new BitSet(new long[]{0x0000800000800002L});
    public static final BitSet FOLLOW_headerMode_in_header269 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_Identifier_in_header272 = new BitSet(new long[]{0x0020000800000002L});
    public static final BitSet FOLLOW_LeftBracket_in_header275 = new BitSet(new long[]{0x0000400000005000L});
    public static final BitSet FOLLOW_headerModifier_in_header277 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_Equals_in_header279 = new BitSet(new long[]{0x0000000008002000L});
    public static final BitSet FOLLOW_Bool_in_header284 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_Identifier_in_header290 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_RightBracket_in_header293 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_Semicolon_in_header299 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_attribute_in_header301 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_QuotedField_in_record344 = new BitSet(new long[]{0x6000800000800000L});
    public static final BitSet FOLLOW_Field_in_record348 = new BitSet(new long[]{0x6000800000800000L});
    public static final BitSet FOLLOW_62_in_record355 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_record358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_record362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EOF_in_record369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_identifier_in_attribute405 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_LeftBracket_in_attribute408 = new BitSet(new long[]{0x02C03E03311A8300L});
    public static final BitSet FOLLOW_attributeModifier_in_attribute410 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_Equals_in_attribute412 = new BitSet(new long[]{0x0000000008002000L});
    public static final BitSet FOLLOW_Bool_in_attribute417 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_Identifier_in_attribute422 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_RightBracket_in_attribute425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_identifier453 = new BitSet(new long[]{0x1000001000000002L});
    public static final BitSet FOLLOW_60_in_identifier456 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_Identifier_in_identifier458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftParenthesis_in_identifier464 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_identifier_in_identifier466 = new BitSet(new long[]{0x0810000000000000L});
    public static final BitSet FOLLOW_59_in_identifier469 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_identifier_in_identifier471 = new BitSet(new long[]{0x0810000000000000L});
    public static final BitSet FOLLOW_RightParenthesis_in_identifier475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Macrodef_in_macro493 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_Macroval_in_macro495 = new BitSet(new long[]{0x0000000000000002L});

}