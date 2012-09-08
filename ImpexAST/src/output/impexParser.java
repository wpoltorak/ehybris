// $ANTLR 3.4 /work/projects/yeclipse/ImpexAST/src/impex.g 2012-09-08 16:57:53

  package output;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class impexParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGNEMENT", "ASSIGNEMENTS", "ATTRIBUTES", "Alias", "AllowNull", "BatchMode", "Bool", "BoolAttribModifier", "BoolHeaderModifier", "COMMENTS", "COMPLEX_ATTRIBUTE", "CacheUnique", "Char", "Comma", "Comment", "Digit", "Dollar", "DoubleQuote", "Equals", "ForceWrite", "HEADER", "HEADER_PREFIX", "HEADER_TYPE", "Hash", "IMPEX", "IMPEX_BLOCK", "IMPEX_BLOCKS", "IgnoreKeyCase", "IgnoreNull", "Insert", "InsertUpdate", "Int", "IntAttribModifier", "LeftBracket", "LeftParenthesis", "Letter", "LineBreak", "LineContinuation", "MACRO", "MacroDefinition", "MacroIdentifier", "Pos", "Processor", "ROW", "ROWS", "Remove", "RightBracket", "RightParenthesis", "SIMPLE_ATTRIBUTE", "Semicolon", "Underscore", "Unique", "Update", "Virtual", "Word", "WordAttribModifier", "WordHeaderModifier", "Ws", "'.'"
    };

    public static final int EOF=-1;
    public static final int T__62=62;
    public static final int ASSIGNEMENT=4;
    public static final int ASSIGNEMENTS=5;
    public static final int ATTRIBUTES=6;
    public static final int Alias=7;
    public static final int AllowNull=8;
    public static final int BatchMode=9;
    public static final int Bool=10;
    public static final int BoolAttribModifier=11;
    public static final int BoolHeaderModifier=12;
    public static final int COMMENTS=13;
    public static final int COMPLEX_ATTRIBUTE=14;
    public static final int CacheUnique=15;
    public static final int Char=16;
    public static final int Comma=17;
    public static final int Comment=18;
    public static final int Digit=19;
    public static final int Dollar=20;
    public static final int DoubleQuote=21;
    public static final int Equals=22;
    public static final int ForceWrite=23;
    public static final int HEADER=24;
    public static final int HEADER_PREFIX=25;
    public static final int HEADER_TYPE=26;
    public static final int Hash=27;
    public static final int IMPEX=28;
    public static final int IMPEX_BLOCK=29;
    public static final int IMPEX_BLOCKS=30;
    public static final int IgnoreKeyCase=31;
    public static final int IgnoreNull=32;
    public static final int Insert=33;
    public static final int InsertUpdate=34;
    public static final int Int=35;
    public static final int IntAttribModifier=36;
    public static final int LeftBracket=37;
    public static final int LeftParenthesis=38;
    public static final int Letter=39;
    public static final int LineBreak=40;
    public static final int LineContinuation=41;
    public static final int MACRO=42;
    public static final int MacroDefinition=43;
    public static final int MacroIdentifier=44;
    public static final int Pos=45;
    public static final int Processor=46;
    public static final int ROW=47;
    public static final int ROWS=48;
    public static final int Remove=49;
    public static final int RightBracket=50;
    public static final int RightParenthesis=51;
    public static final int SIMPLE_ATTRIBUTE=52;
    public static final int Semicolon=53;
    public static final int Underscore=54;
    public static final int Unique=55;
    public static final int Update=56;
    public static final int Virtual=57;
    public static final int Word=58;
    public static final int WordAttribModifier=59;
    public static final int WordHeaderModifier=60;
    public static final int Ws=61;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public impexParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public impexParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return impexParser.tokenNames; }
    public String getGrammarFileName() { return "/work/projects/yeclipse/ImpexAST/src/impex.g"; }


    public static class impex_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "impex"
    // /work/projects/yeclipse/ImpexAST/src/impex.g:43:1: impex : ( ( macroAssignement | impexBlock | Comment ) )+ EOF -> ^( IMPEX ^( ASSIGNEMENTS ( macroAssignement )* ) ^( IMPEX_BLOCKS ( impexBlock )* ) ^( COMMENTS ( Comment )* ) ) ;
    public final impexParser.impex_return impex() throws RecognitionException {
        impexParser.impex_return retval = new impexParser.impex_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Comment3=null;
        Token EOF4=null;
        impexParser.macroAssignement_return macroAssignement1 =null;

        impexParser.impexBlock_return impexBlock2 =null;


        CommonTree Comment3_tree=null;
        CommonTree EOF4_tree=null;
        RewriteRuleTokenStream stream_Comment=new RewriteRuleTokenStream(adaptor,"token Comment");
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_macroAssignement=new RewriteRuleSubtreeStream(adaptor,"rule macroAssignement");
        RewriteRuleSubtreeStream stream_impexBlock=new RewriteRuleSubtreeStream(adaptor,"rule impexBlock");
        try {
            // /work/projects/yeclipse/ImpexAST/src/impex.g:44:2: ( ( ( macroAssignement | impexBlock | Comment ) )+ EOF -> ^( IMPEX ^( ASSIGNEMENTS ( macroAssignement )* ) ^( IMPEX_BLOCKS ( impexBlock )* ) ^( COMMENTS ( Comment )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:44:5: ( ( macroAssignement | impexBlock | Comment ) )+ EOF
            {
            // /work/projects/yeclipse/ImpexAST/src/impex.g:44:5: ( ( macroAssignement | impexBlock | Comment ) )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Comment||(LA2_0 >= Insert && LA2_0 <= InsertUpdate)||LA2_0==MacroDefinition||LA2_0==Remove||LA2_0==Update||LA2_0==Ws) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/impex.g:44:6: ( macroAssignement | impexBlock | Comment )
            	    {
            	    // /work/projects/yeclipse/ImpexAST/src/impex.g:44:6: ( macroAssignement | impexBlock | Comment )
            	    int alt1=3;
            	    switch ( input.LA(1) ) {
            	    case MacroDefinition:
            	        {
            	        alt1=1;
            	        }
            	        break;
            	    case Insert:
            	    case InsertUpdate:
            	    case Remove:
            	    case Update:
            	    case Ws:
            	        {
            	        alt1=2;
            	        }
            	        break;
            	    case Comment:
            	        {
            	        alt1=3;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 1, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt1) {
            	        case 1 :
            	            // /work/projects/yeclipse/ImpexAST/src/impex.g:44:8: macroAssignement
            	            {
            	            pushFollow(FOLLOW_macroAssignement_in_impex144);
            	            macroAssignement1=macroAssignement();

            	            state._fsp--;

            	            stream_macroAssignement.add(macroAssignement1.getTree());

            	            }
            	            break;
            	        case 2 :
            	            // /work/projects/yeclipse/ImpexAST/src/impex.g:44:26: impexBlock
            	            {
            	            pushFollow(FOLLOW_impexBlock_in_impex147);
            	            impexBlock2=impexBlock();

            	            state._fsp--;

            	            stream_impexBlock.add(impexBlock2.getTree());

            	            }
            	            break;
            	        case 3 :
            	            // /work/projects/yeclipse/ImpexAST/src/impex.g:44:39: Comment
            	            {
            	            Comment3=(Token)match(input,Comment,FOLLOW_Comment_in_impex151);  
            	            stream_Comment.add(Comment3);


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            EOF4=(Token)match(input,EOF,FOLLOW_EOF_in_impex156);  
            stream_EOF.add(EOF4);


            // AST REWRITE
            // elements: impexBlock, macroAssignement, Comment
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 44:54: -> ^( IMPEX ^( ASSIGNEMENTS ( macroAssignement )* ) ^( IMPEX_BLOCKS ( impexBlock )* ) ^( COMMENTS ( Comment )* ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/impex.g:44:57: ^( IMPEX ^( ASSIGNEMENTS ( macroAssignement )* ) ^( IMPEX_BLOCKS ( impexBlock )* ) ^( COMMENTS ( Comment )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IMPEX, "IMPEX")
                , root_1);

                // /work/projects/yeclipse/ImpexAST/src/impex.g:44:65: ^( ASSIGNEMENTS ( macroAssignement )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ASSIGNEMENTS, "ASSIGNEMENTS")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/impex.g:44:80: ( macroAssignement )*
                while ( stream_macroAssignement.hasNext() ) {
                    adaptor.addChild(root_2, stream_macroAssignement.nextTree());

                }
                stream_macroAssignement.reset();

                adaptor.addChild(root_1, root_2);
                }

                // /work/projects/yeclipse/ImpexAST/src/impex.g:44:99: ^( IMPEX_BLOCKS ( impexBlock )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IMPEX_BLOCKS, "IMPEX_BLOCKS")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/impex.g:44:114: ( impexBlock )*
                while ( stream_impexBlock.hasNext() ) {
                    adaptor.addChild(root_2, stream_impexBlock.nextTree());

                }
                stream_impexBlock.reset();

                adaptor.addChild(root_1, root_2);
                }

                // /work/projects/yeclipse/ImpexAST/src/impex.g:44:127: ^( COMMENTS ( Comment )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(COMMENTS, "COMMENTS")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/impex.g:44:138: ( Comment )*
                while ( stream_Comment.hasNext() ) {
                    adaptor.addChild(root_2, 
                    stream_Comment.nextNode()
                    );

                }
                stream_Comment.reset();

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


    public static class macroAssignement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "macroAssignement"
    // /work/projects/yeclipse/ImpexAST/src/impex.g:48:1: macroAssignement : MacroDefinition Equals macroExpression ( LineBreak )? -> ^( ASSIGNEMENT MacroDefinition macroExpression ) ;
    public final impexParser.macroAssignement_return macroAssignement() throws RecognitionException {
        impexParser.macroAssignement_return retval = new impexParser.macroAssignement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token MacroDefinition5=null;
        Token Equals6=null;
        Token LineBreak8=null;
        impexParser.macroExpression_return macroExpression7 =null;


        CommonTree MacroDefinition5_tree=null;
        CommonTree Equals6_tree=null;
        CommonTree LineBreak8_tree=null;
        RewriteRuleTokenStream stream_LineBreak=new RewriteRuleTokenStream(adaptor,"token LineBreak");
        RewriteRuleTokenStream stream_MacroDefinition=new RewriteRuleTokenStream(adaptor,"token MacroDefinition");
        RewriteRuleTokenStream stream_Equals=new RewriteRuleTokenStream(adaptor,"token Equals");
        RewriteRuleSubtreeStream stream_macroExpression=new RewriteRuleSubtreeStream(adaptor,"rule macroExpression");
        try {
            // /work/projects/yeclipse/ImpexAST/src/impex.g:49:2: ( MacroDefinition Equals macroExpression ( LineBreak )? -> ^( ASSIGNEMENT MacroDefinition macroExpression ) )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:49:4: MacroDefinition Equals macroExpression ( LineBreak )?
            {
            MacroDefinition5=(Token)match(input,MacroDefinition,FOLLOW_MacroDefinition_in_macroAssignement195);  
            stream_MacroDefinition.add(MacroDefinition5);


            Equals6=(Token)match(input,Equals,FOLLOW_Equals_in_macroAssignement197);  
            stream_Equals.add(Equals6);


            pushFollow(FOLLOW_macroExpression_in_macroAssignement199);
            macroExpression7=macroExpression();

            state._fsp--;

            stream_macroExpression.add(macroExpression7.getTree());

            // /work/projects/yeclipse/ImpexAST/src/impex.g:49:44: ( LineBreak )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==LineBreak) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:49:44: LineBreak
                    {
                    LineBreak8=(Token)match(input,LineBreak,FOLLOW_LineBreak_in_macroAssignement202);  
                    stream_LineBreak.add(LineBreak8);


                    }
                    break;

            }


            // AST REWRITE
            // elements: macroExpression, MacroDefinition
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 49:55: -> ^( ASSIGNEMENT MacroDefinition macroExpression )
            {
                // /work/projects/yeclipse/ImpexAST/src/impex.g:49:58: ^( ASSIGNEMENT MacroDefinition macroExpression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ASSIGNEMENT, "ASSIGNEMENT")
                , root_1);

                adaptor.addChild(root_1, 
                stream_MacroDefinition.nextNode()
                );

                adaptor.addChild(root_1, stream_macroExpression.nextTree());

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
    // $ANTLR end "macroAssignement"


    public static class macroExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "macroExpression"
    // /work/projects/yeclipse/ImpexAST/src/impex.g:52:1: macroExpression : ( MacroDefinition | Char )+ ;
    public final impexParser.macroExpression_return macroExpression() throws RecognitionException {
        impexParser.macroExpression_return retval = new impexParser.macroExpression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set9=null;

        CommonTree set9_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/impex.g:53:2: ( ( MacroDefinition | Char )+ )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:53:4: ( MacroDefinition | Char )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /work/projects/yeclipse/ImpexAST/src/impex.g:53:4: ( MacroDefinition | Char )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==MacroDefinition) ) {
                    int LA4_2 = input.LA(2);

                    if ( (LA4_2==EOF||LA4_2==Char||LA4_2==Comment||(LA4_2 >= Insert && LA4_2 <= InsertUpdate)||LA4_2==LineBreak||LA4_2==MacroDefinition||LA4_2==Remove||LA4_2==Update||LA4_2==Ws) ) {
                        alt4=1;
                    }


                }
                else if ( (LA4_0==Char) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/impex.g:
            	    {
            	    set9=(Token)input.LT(1);

            	    if ( input.LA(1)==Char||input.LA(1)==MacroDefinition ) {
            	        input.consume();
            	        adaptor.addChild(root_0, 
            	        (CommonTree)adaptor.create(set9)
            	        );
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


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
    // $ANTLR end "macroExpression"


    public static class impexBlock_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "impexBlock"
    // /work/projects/yeclipse/ImpexAST/src/impex.g:64:1: impexBlock : header ( row )* -> ^( IMPEX_BLOCK header ^( ROWS ( row )* ) ) ;
    public final impexParser.impexBlock_return impexBlock() throws RecognitionException {
        impexParser.impexBlock_return retval = new impexParser.impexBlock_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        impexParser.header_return header10 =null;

        impexParser.row_return row11 =null;


        RewriteRuleSubtreeStream stream_header=new RewriteRuleSubtreeStream(adaptor,"rule header");
        RewriteRuleSubtreeStream stream_row=new RewriteRuleSubtreeStream(adaptor,"rule row");
        try {
            // /work/projects/yeclipse/ImpexAST/src/impex.g:65:2: ( header ( row )* -> ^( IMPEX_BLOCK header ^( ROWS ( row )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:65:4: header ( row )*
            {
            pushFollow(FOLLOW_header_in_impexBlock265);
            header10=header();

            state._fsp--;

            stream_header.add(header10.getTree());

            // /work/projects/yeclipse/ImpexAST/src/impex.g:65:12: ( row )*
            loop5:
            do {
                int alt5=2;
                alt5 = dfa5.predict(input);
                switch (alt5) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/impex.g:65:13: row
            	    {
            	    pushFollow(FOLLOW_row_in_impexBlock269);
            	    row11=row();

            	    state._fsp--;

            	    stream_row.add(row11.getTree());

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            // AST REWRITE
            // elements: header, row
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 65:20: -> ^( IMPEX_BLOCK header ^( ROWS ( row )* ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/impex.g:65:23: ^( IMPEX_BLOCK header ^( ROWS ( row )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IMPEX_BLOCK, "IMPEX_BLOCK")
                , root_1);

                adaptor.addChild(root_1, stream_header.nextTree());

                // /work/projects/yeclipse/ImpexAST/src/impex.g:65:44: ^( ROWS ( row )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ROWS, "ROWS")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/impex.g:65:51: ( row )*
                while ( stream_row.hasNext() ) {
                    adaptor.addChild(root_2, stream_row.nextTree());

                }
                stream_row.reset();

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
    // $ANTLR end "impexBlock"


    public static class header_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "header"
    // /work/projects/yeclipse/ImpexAST/src/impex.g:68:1: header : headerModeType ( Semicolon ( Ws )* ( simpleAttribute | complexAttribute ) )* ( LineBreak | EOF ) -> ^( headerModeType ^( ATTRIBUTES ( simpleAttribute )* ( complexAttribute )* ) ) ;
    public final impexParser.header_return header() throws RecognitionException {
        impexParser.header_return retval = new impexParser.header_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Semicolon13=null;
        Token Ws14=null;
        Token LineBreak17=null;
        Token EOF18=null;
        impexParser.headerModeType_return headerModeType12 =null;

        impexParser.simpleAttribute_return simpleAttribute15 =null;

        impexParser.complexAttribute_return complexAttribute16 =null;


        CommonTree Semicolon13_tree=null;
        CommonTree Ws14_tree=null;
        CommonTree LineBreak17_tree=null;
        CommonTree EOF18_tree=null;
        RewriteRuleTokenStream stream_LineBreak=new RewriteRuleTokenStream(adaptor,"token LineBreak");
        RewriteRuleTokenStream stream_Ws=new RewriteRuleTokenStream(adaptor,"token Ws");
        RewriteRuleTokenStream stream_Semicolon=new RewriteRuleTokenStream(adaptor,"token Semicolon");
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_complexAttribute=new RewriteRuleSubtreeStream(adaptor,"rule complexAttribute");
        RewriteRuleSubtreeStream stream_headerModeType=new RewriteRuleSubtreeStream(adaptor,"rule headerModeType");
        RewriteRuleSubtreeStream stream_simpleAttribute=new RewriteRuleSubtreeStream(adaptor,"rule simpleAttribute");
        try {
            // /work/projects/yeclipse/ImpexAST/src/impex.g:69:2: ( headerModeType ( Semicolon ( Ws )* ( simpleAttribute | complexAttribute ) )* ( LineBreak | EOF ) -> ^( headerModeType ^( ATTRIBUTES ( simpleAttribute )* ( complexAttribute )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:69:4: headerModeType ( Semicolon ( Ws )* ( simpleAttribute | complexAttribute ) )* ( LineBreak | EOF )
            {
            pushFollow(FOLLOW_headerModeType_in_header299);
            headerModeType12=headerModeType();

            state._fsp--;

            stream_headerModeType.add(headerModeType12.getTree());

            // /work/projects/yeclipse/ImpexAST/src/impex.g:69:20: ( Semicolon ( Ws )* ( simpleAttribute | complexAttribute ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==Semicolon) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/impex.g:69:21: Semicolon ( Ws )* ( simpleAttribute | complexAttribute )
            	    {
            	    Semicolon13=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_header303);  
            	    stream_Semicolon.add(Semicolon13);


            	    // /work/projects/yeclipse/ImpexAST/src/impex.g:69:32: ( Ws )*
            	    loop6:
            	    do {
            	        int alt6=2;
            	        int LA6_0 = input.LA(1);

            	        if ( (LA6_0==Ws) ) {
            	            alt6=1;
            	        }


            	        switch (alt6) {
            	    	case 1 :
            	    	    // /work/projects/yeclipse/ImpexAST/src/impex.g:69:32: Ws
            	    	    {
            	    	    Ws14=(Token)match(input,Ws,FOLLOW_Ws_in_header306);  
            	    	    stream_Ws.add(Ws14);


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop6;
            	        }
            	    } while (true);


            	    // /work/projects/yeclipse/ImpexAST/src/impex.g:69:36: ( simpleAttribute | complexAttribute )
            	    int alt7=2;
            	    int LA7_0 = input.LA(1);

            	    if ( (LA7_0==Word) ) {
            	        int LA7_1 = input.LA(2);

            	        if ( (LA7_1==EOF||LA7_1==LeftBracket||LA7_1==LineBreak||LA7_1==Semicolon) ) {
            	            alt7=1;
            	        }
            	        else if ( (LA7_1==LeftParenthesis||LA7_1==Ws) ) {
            	            alt7=2;
            	        }
            	        else {
            	            NoViableAltException nvae =
            	                new NoViableAltException("", 7, 1, input);

            	            throw nvae;

            	        }
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 7, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt7) {
            	        case 1 :
            	            // /work/projects/yeclipse/ImpexAST/src/impex.g:69:37: simpleAttribute
            	            {
            	            pushFollow(FOLLOW_simpleAttribute_in_header310);
            	            simpleAttribute15=simpleAttribute();

            	            state._fsp--;

            	            stream_simpleAttribute.add(simpleAttribute15.getTree());

            	            }
            	            break;
            	        case 2 :
            	            // /work/projects/yeclipse/ImpexAST/src/impex.g:69:56: complexAttribute
            	            {
            	            pushFollow(FOLLOW_complexAttribute_in_header315);
            	            complexAttribute16=complexAttribute();

            	            state._fsp--;

            	            stream_complexAttribute.add(complexAttribute16.getTree());

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            // /work/projects/yeclipse/ImpexAST/src/impex.g:69:77: ( LineBreak | EOF )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==LineBreak) ) {
                alt9=1;
            }
            else if ( (LA9_0==EOF) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:69:78: LineBreak
                    {
                    LineBreak17=(Token)match(input,LineBreak,FOLLOW_LineBreak_in_header322);  
                    stream_LineBreak.add(LineBreak17);


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:69:90: EOF
                    {
                    EOF18=(Token)match(input,EOF,FOLLOW_EOF_in_header326);  
                    stream_EOF.add(EOF18);


                    }
                    break;

            }


            // AST REWRITE
            // elements: headerModeType, complexAttribute, simpleAttribute
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 69:96: -> ^( headerModeType ^( ATTRIBUTES ( simpleAttribute )* ( complexAttribute )* ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/impex.g:69:99: ^( headerModeType ^( ATTRIBUTES ( simpleAttribute )* ( complexAttribute )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(stream_headerModeType.nextNode(), root_1);

                // /work/projects/yeclipse/ImpexAST/src/impex.g:69:116: ^( ATTRIBUTES ( simpleAttribute )* ( complexAttribute )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ATTRIBUTES, "ATTRIBUTES")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/impex.g:69:129: ( simpleAttribute )*
                while ( stream_simpleAttribute.hasNext() ) {
                    adaptor.addChild(root_2, stream_simpleAttribute.nextTree());

                }
                stream_simpleAttribute.reset();

                // /work/projects/yeclipse/ImpexAST/src/impex.g:69:146: ( complexAttribute )*
                while ( stream_complexAttribute.hasNext() ) {
                    adaptor.addChild(root_2, stream_complexAttribute.nextTree());

                }
                stream_complexAttribute.reset();

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


    public static class row_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "row"
    // /work/projects/yeclipse/ImpexAST/src/impex.g:72:1: row : ( ( Ws )* Semicolon ( ( Ws )* field )? )* ( LineBreak | EOF ) -> ^( ROW ( field )* ) ;
    public final impexParser.row_return row() throws RecognitionException {
        impexParser.row_return retval = new impexParser.row_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Ws19=null;
        Token Semicolon20=null;
        Token Ws21=null;
        Token LineBreak23=null;
        Token EOF24=null;
        impexParser.field_return field22 =null;


        CommonTree Ws19_tree=null;
        CommonTree Semicolon20_tree=null;
        CommonTree Ws21_tree=null;
        CommonTree LineBreak23_tree=null;
        CommonTree EOF24_tree=null;
        RewriteRuleTokenStream stream_LineBreak=new RewriteRuleTokenStream(adaptor,"token LineBreak");
        RewriteRuleTokenStream stream_Ws=new RewriteRuleTokenStream(adaptor,"token Ws");
        RewriteRuleTokenStream stream_Semicolon=new RewriteRuleTokenStream(adaptor,"token Semicolon");
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_field=new RewriteRuleSubtreeStream(adaptor,"rule field");
        try {
            // /work/projects/yeclipse/ImpexAST/src/impex.g:73:2: ( ( ( Ws )* Semicolon ( ( Ws )* field )? )* ( LineBreak | EOF ) -> ^( ROW ( field )* ) )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:73:4: ( ( Ws )* Semicolon ( ( Ws )* field )? )* ( LineBreak | EOF )
            {
            // /work/projects/yeclipse/ImpexAST/src/impex.g:73:4: ( ( Ws )* Semicolon ( ( Ws )* field )? )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==Semicolon||LA13_0==Ws) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/impex.g:73:5: ( Ws )* Semicolon ( ( Ws )* field )?
            	    {
            	    // /work/projects/yeclipse/ImpexAST/src/impex.g:73:5: ( Ws )*
            	    loop10:
            	    do {
            	        int alt10=2;
            	        int LA10_0 = input.LA(1);

            	        if ( (LA10_0==Ws) ) {
            	            alt10=1;
            	        }


            	        switch (alt10) {
            	    	case 1 :
            	    	    // /work/projects/yeclipse/ImpexAST/src/impex.g:73:5: Ws
            	    	    {
            	    	    Ws19=(Token)match(input,Ws,FOLLOW_Ws_in_row357);  
            	    	    stream_Ws.add(Ws19);


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop10;
            	        }
            	    } while (true);


            	    Semicolon20=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_row360);  
            	    stream_Semicolon.add(Semicolon20);


            	    // /work/projects/yeclipse/ImpexAST/src/impex.g:73:19: ( ( Ws )* field )?
            	    int alt12=2;
            	    alt12 = dfa12.predict(input);
            	    switch (alt12) {
            	        case 1 :
            	            // /work/projects/yeclipse/ImpexAST/src/impex.g:73:20: ( Ws )* field
            	            {
            	            // /work/projects/yeclipse/ImpexAST/src/impex.g:73:20: ( Ws )*
            	            loop11:
            	            do {
            	                int alt11=2;
            	                int LA11_0 = input.LA(1);

            	                if ( (LA11_0==Ws) ) {
            	                    alt11=1;
            	                }


            	                switch (alt11) {
            	            	case 1 :
            	            	    // /work/projects/yeclipse/ImpexAST/src/impex.g:73:20: Ws
            	            	    {
            	            	    Ws21=(Token)match(input,Ws,FOLLOW_Ws_in_row363);  
            	            	    stream_Ws.add(Ws21);


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop11;
            	                }
            	            } while (true);


            	            pushFollow(FOLLOW_field_in_row367);
            	            field22=field();

            	            state._fsp--;

            	            stream_field.add(field22.getTree());

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            // /work/projects/yeclipse/ImpexAST/src/impex.g:73:37: ( LineBreak | EOF )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==LineBreak) ) {
                alt14=1;
            }
            else if ( (LA14_0==EOF) ) {
                alt14=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }
            switch (alt14) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:73:38: LineBreak
                    {
                    LineBreak23=(Token)match(input,LineBreak,FOLLOW_LineBreak_in_row376);  
                    stream_LineBreak.add(LineBreak23);


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:73:50: EOF
                    {
                    EOF24=(Token)match(input,EOF,FOLLOW_EOF_in_row380);  
                    stream_EOF.add(EOF24);


                    }
                    break;

            }


            // AST REWRITE
            // elements: field
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 73:56: -> ^( ROW ( field )* )
            {
                // /work/projects/yeclipse/ImpexAST/src/impex.g:73:59: ^( ROW ( field )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ROW, "ROW")
                , root_1);

                // /work/projects/yeclipse/ImpexAST/src/impex.g:73:65: ( field )*
                while ( stream_field.hasNext() ) {
                    adaptor.addChild(root_1, stream_field.nextTree());

                }
                stream_field.reset();

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
    // $ANTLR end "row"


    public static class headerModeType_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "headerModeType"
    // /work/projects/yeclipse/ImpexAST/src/impex.g:80:1: headerModeType : ( Ws )* headerMode ( Ws )+ Word ( ( Ws )* headerModifier )? -> ^( HEADER_PREFIX headerMode ^( HEADER_TYPE Word ( headerModifier )? ) ) ;
    public final impexParser.headerModeType_return headerModeType() throws RecognitionException {
        impexParser.headerModeType_return retval = new impexParser.headerModeType_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Ws25=null;
        Token Ws27=null;
        Token Word28=null;
        Token Ws29=null;
        impexParser.headerMode_return headerMode26 =null;

        impexParser.headerModifier_return headerModifier30 =null;


        CommonTree Ws25_tree=null;
        CommonTree Ws27_tree=null;
        CommonTree Word28_tree=null;
        CommonTree Ws29_tree=null;
        RewriteRuleTokenStream stream_Word=new RewriteRuleTokenStream(adaptor,"token Word");
        RewriteRuleTokenStream stream_Ws=new RewriteRuleTokenStream(adaptor,"token Ws");
        RewriteRuleSubtreeStream stream_headerMode=new RewriteRuleSubtreeStream(adaptor,"rule headerMode");
        RewriteRuleSubtreeStream stream_headerModifier=new RewriteRuleSubtreeStream(adaptor,"rule headerModifier");
        try {
            // /work/projects/yeclipse/ImpexAST/src/impex.g:81:2: ( ( Ws )* headerMode ( Ws )+ Word ( ( Ws )* headerModifier )? -> ^( HEADER_PREFIX headerMode ^( HEADER_TYPE Word ( headerModifier )? ) ) )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:81:4: ( Ws )* headerMode ( Ws )+ Word ( ( Ws )* headerModifier )?
            {
            // /work/projects/yeclipse/ImpexAST/src/impex.g:81:4: ( Ws )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==Ws) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/impex.g:81:4: Ws
            	    {
            	    Ws25=(Token)match(input,Ws,FOLLOW_Ws_in_headerModeType407);  
            	    stream_Ws.add(Ws25);


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            pushFollow(FOLLOW_headerMode_in_headerModeType410);
            headerMode26=headerMode();

            state._fsp--;

            stream_headerMode.add(headerMode26.getTree());

            // /work/projects/yeclipse/ImpexAST/src/impex.g:81:19: ( Ws )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==Ws) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/impex.g:81:19: Ws
            	    {
            	    Ws27=(Token)match(input,Ws,FOLLOW_Ws_in_headerModeType412);  
            	    stream_Ws.add(Ws27);


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            Word28=(Token)match(input,Word,FOLLOW_Word_in_headerModeType415);  
            stream_Word.add(Word28);


            // /work/projects/yeclipse/ImpexAST/src/impex.g:81:29: ( ( Ws )* headerModifier )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==LeftBracket||LA18_0==Ws) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:81:30: ( Ws )* headerModifier
                    {
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:81:30: ( Ws )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==Ws) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/impex.g:81:30: Ws
                    	    {
                    	    Ws29=(Token)match(input,Ws,FOLLOW_Ws_in_headerModeType419);  
                    	    stream_Ws.add(Ws29);


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);


                    pushFollow(FOLLOW_headerModifier_in_headerModeType422);
                    headerModifier30=headerModifier();

                    state._fsp--;

                    stream_headerModifier.add(headerModifier30.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: headerMode, headerModifier, Word
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 81:51: -> ^( HEADER_PREFIX headerMode ^( HEADER_TYPE Word ( headerModifier )? ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/impex.g:81:54: ^( HEADER_PREFIX headerMode ^( HEADER_TYPE Word ( headerModifier )? ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(HEADER_PREFIX, "HEADER_PREFIX")
                , root_1);

                adaptor.addChild(root_1, stream_headerMode.nextTree());

                // /work/projects/yeclipse/ImpexAST/src/impex.g:81:81: ^( HEADER_TYPE Word ( headerModifier )? )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(HEADER_TYPE, "HEADER_TYPE")
                , root_2);

                adaptor.addChild(root_2, 
                stream_Word.nextNode()
                );

                // /work/projects/yeclipse/ImpexAST/src/impex.g:81:100: ( headerModifier )?
                if ( stream_headerModifier.hasNext() ) {
                    adaptor.addChild(root_2, stream_headerModifier.nextTree());

                }
                stream_headerModifier.reset();

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
    // $ANTLR end "headerModeType"


    public static class simpleAttribute_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "simpleAttribute"
    // /work/projects/yeclipse/ImpexAST/src/impex.g:84:1: simpleAttribute : Word ( attributeModifier )? -> ^( SIMPLE_ATTRIBUTE Word ( attributeModifier )? ) ;
    public final impexParser.simpleAttribute_return simpleAttribute() throws RecognitionException {
        impexParser.simpleAttribute_return retval = new impexParser.simpleAttribute_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Word31=null;
        impexParser.attributeModifier_return attributeModifier32 =null;


        CommonTree Word31_tree=null;
        RewriteRuleTokenStream stream_Word=new RewriteRuleTokenStream(adaptor,"token Word");
        RewriteRuleSubtreeStream stream_attributeModifier=new RewriteRuleSubtreeStream(adaptor,"rule attributeModifier");
        try {
            // /work/projects/yeclipse/ImpexAST/src/impex.g:85:2: ( Word ( attributeModifier )? -> ^( SIMPLE_ATTRIBUTE Word ( attributeModifier )? ) )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:85:4: Word ( attributeModifier )?
            {
            Word31=(Token)match(input,Word,FOLLOW_Word_in_simpleAttribute452);  
            stream_Word.add(Word31);


            // /work/projects/yeclipse/ImpexAST/src/impex.g:85:9: ( attributeModifier )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==LeftBracket) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:85:9: attributeModifier
                    {
                    pushFollow(FOLLOW_attributeModifier_in_simpleAttribute454);
                    attributeModifier32=attributeModifier();

                    state._fsp--;

                    stream_attributeModifier.add(attributeModifier32.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: attributeModifier, Word
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 85:28: -> ^( SIMPLE_ATTRIBUTE Word ( attributeModifier )? )
            {
                // /work/projects/yeclipse/ImpexAST/src/impex.g:85:31: ^( SIMPLE_ATTRIBUTE Word ( attributeModifier )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(SIMPLE_ATTRIBUTE, "SIMPLE_ATTRIBUTE")
                , root_1);

                adaptor.addChild(root_1, 
                stream_Word.nextNode()
                );

                // /work/projects/yeclipse/ImpexAST/src/impex.g:85:55: ( attributeModifier )?
                if ( stream_attributeModifier.hasNext() ) {
                    adaptor.addChild(root_1, stream_attributeModifier.nextTree());

                }
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
    // $ANTLR end "simpleAttribute"


    public static class complexAttribute_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "complexAttribute"
    // /work/projects/yeclipse/ImpexAST/src/impex.g:88:1: complexAttribute : complexAttributeRef ( ( Ws )* attributeModifier )? -> ^( COMPLEX_ATTRIBUTE complexAttributeRef ( attributeModifier )? ) ;
    public final impexParser.complexAttribute_return complexAttribute() throws RecognitionException {
        impexParser.complexAttribute_return retval = new impexParser.complexAttribute_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Ws34=null;
        impexParser.complexAttributeRef_return complexAttributeRef33 =null;

        impexParser.attributeModifier_return attributeModifier35 =null;


        CommonTree Ws34_tree=null;
        RewriteRuleTokenStream stream_Ws=new RewriteRuleTokenStream(adaptor,"token Ws");
        RewriteRuleSubtreeStream stream_attributeModifier=new RewriteRuleSubtreeStream(adaptor,"rule attributeModifier");
        RewriteRuleSubtreeStream stream_complexAttributeRef=new RewriteRuleSubtreeStream(adaptor,"rule complexAttributeRef");
        try {
            // /work/projects/yeclipse/ImpexAST/src/impex.g:89:2: ( complexAttributeRef ( ( Ws )* attributeModifier )? -> ^( COMPLEX_ATTRIBUTE complexAttributeRef ( attributeModifier )? ) )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:89:4: complexAttributeRef ( ( Ws )* attributeModifier )?
            {
            pushFollow(FOLLOW_complexAttributeRef_in_complexAttribute478);
            complexAttributeRef33=complexAttributeRef();

            state._fsp--;

            stream_complexAttributeRef.add(complexAttributeRef33.getTree());

            // /work/projects/yeclipse/ImpexAST/src/impex.g:89:24: ( ( Ws )* attributeModifier )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==LeftBracket||LA21_0==Ws) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:89:25: ( Ws )* attributeModifier
                    {
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:89:25: ( Ws )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==Ws) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/impex.g:89:25: Ws
                    	    {
                    	    Ws34=(Token)match(input,Ws,FOLLOW_Ws_in_complexAttribute481);  
                    	    stream_Ws.add(Ws34);


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    pushFollow(FOLLOW_attributeModifier_in_complexAttribute484);
                    attributeModifier35=attributeModifier();

                    state._fsp--;

                    stream_attributeModifier.add(attributeModifier35.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: attributeModifier, complexAttributeRef
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 89:49: -> ^( COMPLEX_ATTRIBUTE complexAttributeRef ( attributeModifier )? )
            {
                // /work/projects/yeclipse/ImpexAST/src/impex.g:89:52: ^( COMPLEX_ATTRIBUTE complexAttributeRef ( attributeModifier )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(COMPLEX_ATTRIBUTE, "COMPLEX_ATTRIBUTE")
                , root_1);

                adaptor.addChild(root_1, stream_complexAttributeRef.nextTree());

                // /work/projects/yeclipse/ImpexAST/src/impex.g:89:92: ( attributeModifier )?
                if ( stream_attributeModifier.hasNext() ) {
                    adaptor.addChild(root_1, stream_attributeModifier.nextTree());

                }
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
    // $ANTLR end "complexAttribute"


    public static class complexAttributeRef_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "complexAttributeRef"
    // /work/projects/yeclipse/ImpexAST/src/impex.g:93:1: complexAttributeRef : Word ( Ws )* LeftParenthesis ( Ws )* Word ( ( '.' Word )? | ( complexAttributeRef ( ( Ws )* Comma ( Ws )* ( Word | complexAttributeRef ) )? ) ) ( Ws )* RightParenthesis ;
    public final impexParser.complexAttributeRef_return complexAttributeRef() throws RecognitionException {
        impexParser.complexAttributeRef_return retval = new impexParser.complexAttributeRef_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Word36=null;
        Token Ws37=null;
        Token LeftParenthesis38=null;
        Token Ws39=null;
        Token Word40=null;
        Token char_literal41=null;
        Token Word42=null;
        Token Ws44=null;
        Token Comma45=null;
        Token Ws46=null;
        Token Word47=null;
        Token Ws49=null;
        Token RightParenthesis50=null;
        impexParser.complexAttributeRef_return complexAttributeRef43 =null;

        impexParser.complexAttributeRef_return complexAttributeRef48 =null;


        CommonTree Word36_tree=null;
        CommonTree Ws37_tree=null;
        CommonTree LeftParenthesis38_tree=null;
        CommonTree Ws39_tree=null;
        CommonTree Word40_tree=null;
        CommonTree char_literal41_tree=null;
        CommonTree Word42_tree=null;
        CommonTree Ws44_tree=null;
        CommonTree Comma45_tree=null;
        CommonTree Ws46_tree=null;
        CommonTree Word47_tree=null;
        CommonTree Ws49_tree=null;
        CommonTree RightParenthesis50_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/impex.g:94:2: ( Word ( Ws )* LeftParenthesis ( Ws )* Word ( ( '.' Word )? | ( complexAttributeRef ( ( Ws )* Comma ( Ws )* ( Word | complexAttributeRef ) )? ) ) ( Ws )* RightParenthesis )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:94:4: Word ( Ws )* LeftParenthesis ( Ws )* Word ( ( '.' Word )? | ( complexAttributeRef ( ( Ws )* Comma ( Ws )* ( Word | complexAttributeRef ) )? ) ) ( Ws )* RightParenthesis
            {
            root_0 = (CommonTree)adaptor.nil();


            Word36=(Token)match(input,Word,FOLLOW_Word_in_complexAttributeRef509); 
            Word36_tree = 
            (CommonTree)adaptor.create(Word36)
            ;
            adaptor.addChild(root_0, Word36_tree);


            // /work/projects/yeclipse/ImpexAST/src/impex.g:94:9: ( Ws )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==Ws) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/impex.g:94:9: Ws
            	    {
            	    Ws37=(Token)match(input,Ws,FOLLOW_Ws_in_complexAttributeRef511); 
            	    Ws37_tree = 
            	    (CommonTree)adaptor.create(Ws37)
            	    ;
            	    adaptor.addChild(root_0, Ws37_tree);


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);


            LeftParenthesis38=(Token)match(input,LeftParenthesis,FOLLOW_LeftParenthesis_in_complexAttributeRef514); 
            LeftParenthesis38_tree = 
            (CommonTree)adaptor.create(LeftParenthesis38)
            ;
            adaptor.addChild(root_0, LeftParenthesis38_tree);


            // /work/projects/yeclipse/ImpexAST/src/impex.g:94:29: ( Ws )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==Ws) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/impex.g:94:29: Ws
            	    {
            	    Ws39=(Token)match(input,Ws,FOLLOW_Ws_in_complexAttributeRef516); 
            	    Ws39_tree = 
            	    (CommonTree)adaptor.create(Ws39)
            	    ;
            	    adaptor.addChild(root_0, Ws39_tree);


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            Word40=(Token)match(input,Word,FOLLOW_Word_in_complexAttributeRef519); 
            Word40_tree = 
            (CommonTree)adaptor.create(Word40)
            ;
            adaptor.addChild(root_0, Word40_tree);


            // /work/projects/yeclipse/ImpexAST/src/impex.g:94:38: ( ( '.' Word )? | ( complexAttributeRef ( ( Ws )* Comma ( Ws )* ( Word | complexAttributeRef ) )? ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RightParenthesis||(LA29_0 >= Ws && LA29_0 <= 62)) ) {
                alt29=1;
            }
            else if ( (LA29_0==Word) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;

            }
            switch (alt29) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:94:39: ( '.' Word )?
                    {
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:94:39: ( '.' Word )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( (LA24_0==62) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/impex.g:94:40: '.' Word
                            {
                            char_literal41=(Token)match(input,62,FOLLOW_62_in_complexAttributeRef523); 
                            char_literal41_tree = 
                            (CommonTree)adaptor.create(char_literal41)
                            ;
                            adaptor.addChild(root_0, char_literal41_tree);


                            Word42=(Token)match(input,Word,FOLLOW_Word_in_complexAttributeRef525); 
                            Word42_tree = 
                            (CommonTree)adaptor.create(Word42)
                            ;
                            adaptor.addChild(root_0, Word42_tree);


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:94:53: ( complexAttributeRef ( ( Ws )* Comma ( Ws )* ( Word | complexAttributeRef ) )? )
                    {
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:94:53: ( complexAttributeRef ( ( Ws )* Comma ( Ws )* ( Word | complexAttributeRef ) )? )
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:94:54: complexAttributeRef ( ( Ws )* Comma ( Ws )* ( Word | complexAttributeRef ) )?
                    {
                    pushFollow(FOLLOW_complexAttributeRef_in_complexAttributeRef532);
                    complexAttributeRef43=complexAttributeRef();

                    state._fsp--;

                    adaptor.addChild(root_0, complexAttributeRef43.getTree());

                    // /work/projects/yeclipse/ImpexAST/src/impex.g:94:74: ( ( Ws )* Comma ( Ws )* ( Word | complexAttributeRef ) )?
                    int alt28=2;
                    alt28 = dfa28.predict(input);
                    switch (alt28) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/impex.g:94:75: ( Ws )* Comma ( Ws )* ( Word | complexAttributeRef )
                            {
                            // /work/projects/yeclipse/ImpexAST/src/impex.g:94:75: ( Ws )*
                            loop25:
                            do {
                                int alt25=2;
                                int LA25_0 = input.LA(1);

                                if ( (LA25_0==Ws) ) {
                                    alt25=1;
                                }


                                switch (alt25) {
                            	case 1 :
                            	    // /work/projects/yeclipse/ImpexAST/src/impex.g:94:75: Ws
                            	    {
                            	    Ws44=(Token)match(input,Ws,FOLLOW_Ws_in_complexAttributeRef535); 
                            	    Ws44_tree = 
                            	    (CommonTree)adaptor.create(Ws44)
                            	    ;
                            	    adaptor.addChild(root_0, Ws44_tree);


                            	    }
                            	    break;

                            	default :
                            	    break loop25;
                                }
                            } while (true);


                            Comma45=(Token)match(input,Comma,FOLLOW_Comma_in_complexAttributeRef538); 
                            Comma45_tree = 
                            (CommonTree)adaptor.create(Comma45)
                            ;
                            adaptor.addChild(root_0, Comma45_tree);


                            // /work/projects/yeclipse/ImpexAST/src/impex.g:94:85: ( Ws )*
                            loop26:
                            do {
                                int alt26=2;
                                int LA26_0 = input.LA(1);

                                if ( (LA26_0==Ws) ) {
                                    alt26=1;
                                }


                                switch (alt26) {
                            	case 1 :
                            	    // /work/projects/yeclipse/ImpexAST/src/impex.g:94:85: Ws
                            	    {
                            	    Ws46=(Token)match(input,Ws,FOLLOW_Ws_in_complexAttributeRef540); 
                            	    Ws46_tree = 
                            	    (CommonTree)adaptor.create(Ws46)
                            	    ;
                            	    adaptor.addChild(root_0, Ws46_tree);


                            	    }
                            	    break;

                            	default :
                            	    break loop26;
                                }
                            } while (true);


                            // /work/projects/yeclipse/ImpexAST/src/impex.g:94:89: ( Word | complexAttributeRef )
                            int alt27=2;
                            alt27 = dfa27.predict(input);
                            switch (alt27) {
                                case 1 :
                                    // /work/projects/yeclipse/ImpexAST/src/impex.g:94:90: Word
                                    {
                                    Word47=(Token)match(input,Word,FOLLOW_Word_in_complexAttributeRef544); 
                                    Word47_tree = 
                                    (CommonTree)adaptor.create(Word47)
                                    ;
                                    adaptor.addChild(root_0, Word47_tree);


                                    }
                                    break;
                                case 2 :
                                    // /work/projects/yeclipse/ImpexAST/src/impex.g:94:97: complexAttributeRef
                                    {
                                    pushFollow(FOLLOW_complexAttributeRef_in_complexAttributeRef548);
                                    complexAttributeRef48=complexAttributeRef();

                                    state._fsp--;

                                    adaptor.addChild(root_0, complexAttributeRef48.getTree());

                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            // /work/projects/yeclipse/ImpexAST/src/impex.g:94:122: ( Ws )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==Ws) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/impex.g:94:122: Ws
            	    {
            	    Ws49=(Token)match(input,Ws,FOLLOW_Ws_in_complexAttributeRef555); 
            	    Ws49_tree = 
            	    (CommonTree)adaptor.create(Ws49)
            	    ;
            	    adaptor.addChild(root_0, Ws49_tree);


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            RightParenthesis50=(Token)match(input,RightParenthesis,FOLLOW_RightParenthesis_in_complexAttributeRef558); 
            RightParenthesis50_tree = 
            (CommonTree)adaptor.create(RightParenthesis50)
            ;
            adaptor.addChild(root_0, RightParenthesis50_tree);


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
    // $ANTLR end "complexAttributeRef"


    public static class headerMode_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "headerMode"
    // /work/projects/yeclipse/ImpexAST/src/impex.g:97:1: headerMode : ( Insert | InsertUpdate | Update | Remove );
    public final impexParser.headerMode_return headerMode() throws RecognitionException {
        impexParser.headerMode_return retval = new impexParser.headerMode_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set51=null;

        CommonTree set51_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/impex.g:98:2: ( Insert | InsertUpdate | Update | Remove )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set51=(Token)input.LT(1);

            if ( (input.LA(1) >= Insert && input.LA(1) <= InsertUpdate)||input.LA(1)==Remove||input.LA(1)==Update ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set51)
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
    // /work/projects/yeclipse/ImpexAST/src/impex.g:100:1: headerModifier : LeftBracket ( BoolHeaderModifier ( Ws )* Equals ( Ws )* Bool -> ^( Equals BoolHeaderModifier Bool ) | WordHeaderModifier ( Ws )* Equals ( Ws )* Word -> ^( Equals WordHeaderModifier Word ) ) ( Ws )* RightBracket ;
    public final impexParser.headerModifier_return headerModifier() throws RecognitionException {
        impexParser.headerModifier_return retval = new impexParser.headerModifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token LeftBracket52=null;
        Token BoolHeaderModifier53=null;
        Token Ws54=null;
        Token Equals55=null;
        Token Ws56=null;
        Token Bool57=null;
        Token WordHeaderModifier58=null;
        Token Ws59=null;
        Token Equals60=null;
        Token Ws61=null;
        Token Word62=null;
        Token Ws63=null;
        Token RightBracket64=null;

        CommonTree LeftBracket52_tree=null;
        CommonTree BoolHeaderModifier53_tree=null;
        CommonTree Ws54_tree=null;
        CommonTree Equals55_tree=null;
        CommonTree Ws56_tree=null;
        CommonTree Bool57_tree=null;
        CommonTree WordHeaderModifier58_tree=null;
        CommonTree Ws59_tree=null;
        CommonTree Equals60_tree=null;
        CommonTree Ws61_tree=null;
        CommonTree Word62_tree=null;
        CommonTree Ws63_tree=null;
        CommonTree RightBracket64_tree=null;
        RewriteRuleTokenStream stream_LeftBracket=new RewriteRuleTokenStream(adaptor,"token LeftBracket");
        RewriteRuleTokenStream stream_Bool=new RewriteRuleTokenStream(adaptor,"token Bool");
        RewriteRuleTokenStream stream_Word=new RewriteRuleTokenStream(adaptor,"token Word");
        RewriteRuleTokenStream stream_Ws=new RewriteRuleTokenStream(adaptor,"token Ws");
        RewriteRuleTokenStream stream_RightBracket=new RewriteRuleTokenStream(adaptor,"token RightBracket");
        RewriteRuleTokenStream stream_Equals=new RewriteRuleTokenStream(adaptor,"token Equals");
        RewriteRuleTokenStream stream_BoolHeaderModifier=new RewriteRuleTokenStream(adaptor,"token BoolHeaderModifier");
        RewriteRuleTokenStream stream_WordHeaderModifier=new RewriteRuleTokenStream(adaptor,"token WordHeaderModifier");

        try {
            // /work/projects/yeclipse/ImpexAST/src/impex.g:101:2: ( LeftBracket ( BoolHeaderModifier ( Ws )* Equals ( Ws )* Bool -> ^( Equals BoolHeaderModifier Bool ) | WordHeaderModifier ( Ws )* Equals ( Ws )* Word -> ^( Equals WordHeaderModifier Word ) ) ( Ws )* RightBracket )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:101:4: LeftBracket ( BoolHeaderModifier ( Ws )* Equals ( Ws )* Bool -> ^( Equals BoolHeaderModifier Bool ) | WordHeaderModifier ( Ws )* Equals ( Ws )* Word -> ^( Equals WordHeaderModifier Word ) ) ( Ws )* RightBracket
            {
            LeftBracket52=(Token)match(input,LeftBracket,FOLLOW_LeftBracket_in_headerModifier593);  
            stream_LeftBracket.add(LeftBracket52);


            // /work/projects/yeclipse/ImpexAST/src/impex.g:102:3: ( BoolHeaderModifier ( Ws )* Equals ( Ws )* Bool -> ^( Equals BoolHeaderModifier Bool ) | WordHeaderModifier ( Ws )* Equals ( Ws )* Word -> ^( Equals WordHeaderModifier Word ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==BoolHeaderModifier) ) {
                alt35=1;
            }
            else if ( (LA35_0==WordHeaderModifier) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;

            }
            switch (alt35) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:102:4: BoolHeaderModifier ( Ws )* Equals ( Ws )* Bool
                    {
                    BoolHeaderModifier53=(Token)match(input,BoolHeaderModifier,FOLLOW_BoolHeaderModifier_in_headerModifier599);  
                    stream_BoolHeaderModifier.add(BoolHeaderModifier53);


                    // /work/projects/yeclipse/ImpexAST/src/impex.g:102:23: ( Ws )*
                    loop31:
                    do {
                        int alt31=2;
                        int LA31_0 = input.LA(1);

                        if ( (LA31_0==Ws) ) {
                            alt31=1;
                        }


                        switch (alt31) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/impex.g:102:23: Ws
                    	    {
                    	    Ws54=(Token)match(input,Ws,FOLLOW_Ws_in_headerModifier601);  
                    	    stream_Ws.add(Ws54);


                    	    }
                    	    break;

                    	default :
                    	    break loop31;
                        }
                    } while (true);


                    Equals55=(Token)match(input,Equals,FOLLOW_Equals_in_headerModifier604);  
                    stream_Equals.add(Equals55);


                    // /work/projects/yeclipse/ImpexAST/src/impex.g:102:35: ( Ws )*
                    loop32:
                    do {
                        int alt32=2;
                        int LA32_0 = input.LA(1);

                        if ( (LA32_0==Ws) ) {
                            alt32=1;
                        }


                        switch (alt32) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/impex.g:102:35: Ws
                    	    {
                    	    Ws56=(Token)match(input,Ws,FOLLOW_Ws_in_headerModifier607);  
                    	    stream_Ws.add(Ws56);


                    	    }
                    	    break;

                    	default :
                    	    break loop32;
                        }
                    } while (true);


                    Bool57=(Token)match(input,Bool,FOLLOW_Bool_in_headerModifier610);  
                    stream_Bool.add(Bool57);


                    // AST REWRITE
                    // elements: Equals, Bool, BoolHeaderModifier
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 102:44: -> ^( Equals BoolHeaderModifier Bool )
                    {
                        // /work/projects/yeclipse/ImpexAST/src/impex.g:102:47: ^( Equals BoolHeaderModifier Bool )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        stream_Equals.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_BoolHeaderModifier.nextNode()
                        );

                        adaptor.addChild(root_1, 
                        stream_Bool.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:103:5: WordHeaderModifier ( Ws )* Equals ( Ws )* Word
                    {
                    WordHeaderModifier58=(Token)match(input,WordHeaderModifier,FOLLOW_WordHeaderModifier_in_headerModifier626);  
                    stream_WordHeaderModifier.add(WordHeaderModifier58);


                    // /work/projects/yeclipse/ImpexAST/src/impex.g:103:24: ( Ws )*
                    loop33:
                    do {
                        int alt33=2;
                        int LA33_0 = input.LA(1);

                        if ( (LA33_0==Ws) ) {
                            alt33=1;
                        }


                        switch (alt33) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/impex.g:103:24: Ws
                    	    {
                    	    Ws59=(Token)match(input,Ws,FOLLOW_Ws_in_headerModifier628);  
                    	    stream_Ws.add(Ws59);


                    	    }
                    	    break;

                    	default :
                    	    break loop33;
                        }
                    } while (true);


                    Equals60=(Token)match(input,Equals,FOLLOW_Equals_in_headerModifier631);  
                    stream_Equals.add(Equals60);


                    // /work/projects/yeclipse/ImpexAST/src/impex.g:103:36: ( Ws )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==Ws) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/impex.g:103:36: Ws
                    	    {
                    	    Ws61=(Token)match(input,Ws,FOLLOW_Ws_in_headerModifier634);  
                    	    stream_Ws.add(Ws61);


                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);


                    Word62=(Token)match(input,Word,FOLLOW_Word_in_headerModifier637);  
                    stream_Word.add(Word62);


                    // AST REWRITE
                    // elements: Equals, WordHeaderModifier, Word
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 103:45: -> ^( Equals WordHeaderModifier Word )
                    {
                        // /work/projects/yeclipse/ImpexAST/src/impex.g:103:48: ^( Equals WordHeaderModifier Word )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        stream_Equals.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_WordHeaderModifier.nextNode()
                        );

                        adaptor.addChild(root_1, 
                        stream_Word.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }


            // /work/projects/yeclipse/ImpexAST/src/impex.g:104:5: ( Ws )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==Ws) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/impex.g:104:5: Ws
            	    {
            	    Ws63=(Token)match(input,Ws,FOLLOW_Ws_in_headerModifier653);  
            	    stream_Ws.add(Ws63);


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            RightBracket64=(Token)match(input,RightBracket,FOLLOW_RightBracket_in_headerModifier657);  
            stream_RightBracket.add(RightBracket64);


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
    // /work/projects/yeclipse/ImpexAST/src/impex.g:107:1: attributeModifier : LeftBracket ( BoolAttribModifier ( Ws )* Equals ( Ws )* Bool -> ^( Equals BoolAttribModifier Bool ) | IntAttribModifier ( Ws )* Equals ( Ws )* Int -> ^( Equals IntAttribModifier Int ) | WordAttribModifier ( Ws )* Equals ( Ws )* Word -> ^( Equals WordAttribModifier Word ) ) ( Ws )* RightBracket ;
    public final impexParser.attributeModifier_return attributeModifier() throws RecognitionException {
        impexParser.attributeModifier_return retval = new impexParser.attributeModifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token LeftBracket65=null;
        Token BoolAttribModifier66=null;
        Token Ws67=null;
        Token Equals68=null;
        Token Ws69=null;
        Token Bool70=null;
        Token IntAttribModifier71=null;
        Token Ws72=null;
        Token Equals73=null;
        Token Ws74=null;
        Token Int75=null;
        Token WordAttribModifier76=null;
        Token Ws77=null;
        Token Equals78=null;
        Token Ws79=null;
        Token Word80=null;
        Token Ws81=null;
        Token RightBracket82=null;

        CommonTree LeftBracket65_tree=null;
        CommonTree BoolAttribModifier66_tree=null;
        CommonTree Ws67_tree=null;
        CommonTree Equals68_tree=null;
        CommonTree Ws69_tree=null;
        CommonTree Bool70_tree=null;
        CommonTree IntAttribModifier71_tree=null;
        CommonTree Ws72_tree=null;
        CommonTree Equals73_tree=null;
        CommonTree Ws74_tree=null;
        CommonTree Int75_tree=null;
        CommonTree WordAttribModifier76_tree=null;
        CommonTree Ws77_tree=null;
        CommonTree Equals78_tree=null;
        CommonTree Ws79_tree=null;
        CommonTree Word80_tree=null;
        CommonTree Ws81_tree=null;
        CommonTree RightBracket82_tree=null;
        RewriteRuleTokenStream stream_LeftBracket=new RewriteRuleTokenStream(adaptor,"token LeftBracket");
        RewriteRuleTokenStream stream_Bool=new RewriteRuleTokenStream(adaptor,"token Bool");
        RewriteRuleTokenStream stream_Word=new RewriteRuleTokenStream(adaptor,"token Word");
        RewriteRuleTokenStream stream_BoolAttribModifier=new RewriteRuleTokenStream(adaptor,"token BoolAttribModifier");
        RewriteRuleTokenStream stream_Ws=new RewriteRuleTokenStream(adaptor,"token Ws");
        RewriteRuleTokenStream stream_RightBracket=new RewriteRuleTokenStream(adaptor,"token RightBracket");
        RewriteRuleTokenStream stream_IntAttribModifier=new RewriteRuleTokenStream(adaptor,"token IntAttribModifier");
        RewriteRuleTokenStream stream_Equals=new RewriteRuleTokenStream(adaptor,"token Equals");
        RewriteRuleTokenStream stream_Int=new RewriteRuleTokenStream(adaptor,"token Int");
        RewriteRuleTokenStream stream_WordAttribModifier=new RewriteRuleTokenStream(adaptor,"token WordAttribModifier");

        try {
            // /work/projects/yeclipse/ImpexAST/src/impex.g:108:2: ( LeftBracket ( BoolAttribModifier ( Ws )* Equals ( Ws )* Bool -> ^( Equals BoolAttribModifier Bool ) | IntAttribModifier ( Ws )* Equals ( Ws )* Int -> ^( Equals IntAttribModifier Int ) | WordAttribModifier ( Ws )* Equals ( Ws )* Word -> ^( Equals WordAttribModifier Word ) ) ( Ws )* RightBracket )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:108:4: LeftBracket ( BoolAttribModifier ( Ws )* Equals ( Ws )* Bool -> ^( Equals BoolAttribModifier Bool ) | IntAttribModifier ( Ws )* Equals ( Ws )* Int -> ^( Equals IntAttribModifier Int ) | WordAttribModifier ( Ws )* Equals ( Ws )* Word -> ^( Equals WordAttribModifier Word ) ) ( Ws )* RightBracket
            {
            LeftBracket65=(Token)match(input,LeftBracket,FOLLOW_LeftBracket_in_attributeModifier668);  
            stream_LeftBracket.add(LeftBracket65);


            // /work/projects/yeclipse/ImpexAST/src/impex.g:109:3: ( BoolAttribModifier ( Ws )* Equals ( Ws )* Bool -> ^( Equals BoolAttribModifier Bool ) | IntAttribModifier ( Ws )* Equals ( Ws )* Int -> ^( Equals IntAttribModifier Int ) | WordAttribModifier ( Ws )* Equals ( Ws )* Word -> ^( Equals WordAttribModifier Word ) )
            int alt43=3;
            switch ( input.LA(1) ) {
            case BoolAttribModifier:
                {
                alt43=1;
                }
                break;
            case IntAttribModifier:
                {
                alt43=2;
                }
                break;
            case WordAttribModifier:
                {
                alt43=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;

            }

            switch (alt43) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:109:4: BoolAttribModifier ( Ws )* Equals ( Ws )* Bool
                    {
                    BoolAttribModifier66=(Token)match(input,BoolAttribModifier,FOLLOW_BoolAttribModifier_in_attributeModifier674);  
                    stream_BoolAttribModifier.add(BoolAttribModifier66);


                    // /work/projects/yeclipse/ImpexAST/src/impex.g:109:23: ( Ws )*
                    loop37:
                    do {
                        int alt37=2;
                        int LA37_0 = input.LA(1);

                        if ( (LA37_0==Ws) ) {
                            alt37=1;
                        }


                        switch (alt37) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/impex.g:109:23: Ws
                    	    {
                    	    Ws67=(Token)match(input,Ws,FOLLOW_Ws_in_attributeModifier676);  
                    	    stream_Ws.add(Ws67);


                    	    }
                    	    break;

                    	default :
                    	    break loop37;
                        }
                    } while (true);


                    Equals68=(Token)match(input,Equals,FOLLOW_Equals_in_attributeModifier679);  
                    stream_Equals.add(Equals68);


                    // /work/projects/yeclipse/ImpexAST/src/impex.g:109:34: ( Ws )*
                    loop38:
                    do {
                        int alt38=2;
                        int LA38_0 = input.LA(1);

                        if ( (LA38_0==Ws) ) {
                            alt38=1;
                        }


                        switch (alt38) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/impex.g:109:34: Ws
                    	    {
                    	    Ws69=(Token)match(input,Ws,FOLLOW_Ws_in_attributeModifier681);  
                    	    stream_Ws.add(Ws69);


                    	    }
                    	    break;

                    	default :
                    	    break loop38;
                        }
                    } while (true);


                    Bool70=(Token)match(input,Bool,FOLLOW_Bool_in_attributeModifier684);  
                    stream_Bool.add(Bool70);


                    // AST REWRITE
                    // elements: BoolAttribModifier, Equals, Bool
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 109:43: -> ^( Equals BoolAttribModifier Bool )
                    {
                        // /work/projects/yeclipse/ImpexAST/src/impex.g:109:46: ^( Equals BoolAttribModifier Bool )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        stream_Equals.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_BoolAttribModifier.nextNode()
                        );

                        adaptor.addChild(root_1, 
                        stream_Bool.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:110:5: IntAttribModifier ( Ws )* Equals ( Ws )* Int
                    {
                    IntAttribModifier71=(Token)match(input,IntAttribModifier,FOLLOW_IntAttribModifier_in_attributeModifier700);  
                    stream_IntAttribModifier.add(IntAttribModifier71);


                    // /work/projects/yeclipse/ImpexAST/src/impex.g:110:23: ( Ws )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==Ws) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/impex.g:110:23: Ws
                    	    {
                    	    Ws72=(Token)match(input,Ws,FOLLOW_Ws_in_attributeModifier702);  
                    	    stream_Ws.add(Ws72);


                    	    }
                    	    break;

                    	default :
                    	    break loop39;
                        }
                    } while (true);


                    Equals73=(Token)match(input,Equals,FOLLOW_Equals_in_attributeModifier705);  
                    stream_Equals.add(Equals73);


                    // /work/projects/yeclipse/ImpexAST/src/impex.g:110:34: ( Ws )*
                    loop40:
                    do {
                        int alt40=2;
                        int LA40_0 = input.LA(1);

                        if ( (LA40_0==Ws) ) {
                            alt40=1;
                        }


                        switch (alt40) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/impex.g:110:34: Ws
                    	    {
                    	    Ws74=(Token)match(input,Ws,FOLLOW_Ws_in_attributeModifier707);  
                    	    stream_Ws.add(Ws74);


                    	    }
                    	    break;

                    	default :
                    	    break loop40;
                        }
                    } while (true);


                    Int75=(Token)match(input,Int,FOLLOW_Int_in_attributeModifier710);  
                    stream_Int.add(Int75);


                    // AST REWRITE
                    // elements: Int, Equals, IntAttribModifier
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 110:43: -> ^( Equals IntAttribModifier Int )
                    {
                        // /work/projects/yeclipse/ImpexAST/src/impex.g:110:46: ^( Equals IntAttribModifier Int )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        stream_Equals.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_IntAttribModifier.nextNode()
                        );

                        adaptor.addChild(root_1, 
                        stream_Int.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 3 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:111:5: WordAttribModifier ( Ws )* Equals ( Ws )* Word
                    {
                    WordAttribModifier76=(Token)match(input,WordAttribModifier,FOLLOW_WordAttribModifier_in_attributeModifier727);  
                    stream_WordAttribModifier.add(WordAttribModifier76);


                    // /work/projects/yeclipse/ImpexAST/src/impex.g:111:24: ( Ws )*
                    loop41:
                    do {
                        int alt41=2;
                        int LA41_0 = input.LA(1);

                        if ( (LA41_0==Ws) ) {
                            alt41=1;
                        }


                        switch (alt41) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/impex.g:111:24: Ws
                    	    {
                    	    Ws77=(Token)match(input,Ws,FOLLOW_Ws_in_attributeModifier729);  
                    	    stream_Ws.add(Ws77);


                    	    }
                    	    break;

                    	default :
                    	    break loop41;
                        }
                    } while (true);


                    Equals78=(Token)match(input,Equals,FOLLOW_Equals_in_attributeModifier732);  
                    stream_Equals.add(Equals78);


                    // /work/projects/yeclipse/ImpexAST/src/impex.g:111:35: ( Ws )*
                    loop42:
                    do {
                        int alt42=2;
                        int LA42_0 = input.LA(1);

                        if ( (LA42_0==Ws) ) {
                            alt42=1;
                        }


                        switch (alt42) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/impex.g:111:35: Ws
                    	    {
                    	    Ws79=(Token)match(input,Ws,FOLLOW_Ws_in_attributeModifier734);  
                    	    stream_Ws.add(Ws79);


                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);


                    Word80=(Token)match(input,Word,FOLLOW_Word_in_attributeModifier737);  
                    stream_Word.add(Word80);


                    // AST REWRITE
                    // elements: WordAttribModifier, Equals, Word
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 111:44: -> ^( Equals WordAttribModifier Word )
                    {
                        // /work/projects/yeclipse/ImpexAST/src/impex.g:111:47: ^( Equals WordAttribModifier Word )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        stream_Equals.nextNode()
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_WordAttribModifier.nextNode()
                        );

                        adaptor.addChild(root_1, 
                        stream_Word.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;

            }


            // /work/projects/yeclipse/ImpexAST/src/impex.g:112:5: ( Ws )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==Ws) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/impex.g:112:5: Ws
            	    {
            	    Ws81=(Token)match(input,Ws,FOLLOW_Ws_in_attributeModifier753);  
            	    stream_Ws.add(Ws81);


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);


            RightBracket82=(Token)match(input,RightBracket,FOLLOW_RightBracket_in_attributeModifier757);  
            stream_RightBracket.add(RightBracket82);


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


    public static class field_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field"
    // /work/projects/yeclipse/ImpexAST/src/impex.g:116:1: field : ( ( DoubleQuote ( Char | Comma | DoubleQuote DoubleQuote )* DoubleQuote ) | ( Char | MacroDefinition )+ );
    public final impexParser.field_return field() throws RecognitionException {
        impexParser.field_return retval = new impexParser.field_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token DoubleQuote83=null;
        Token Char84=null;
        Token Comma85=null;
        Token DoubleQuote86=null;
        Token DoubleQuote87=null;
        Token DoubleQuote88=null;
        Token set89=null;

        CommonTree DoubleQuote83_tree=null;
        CommonTree Char84_tree=null;
        CommonTree Comma85_tree=null;
        CommonTree DoubleQuote86_tree=null;
        CommonTree DoubleQuote87_tree=null;
        CommonTree DoubleQuote88_tree=null;
        CommonTree set89_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/impex.g:117:2: ( ( DoubleQuote ( Char | Comma | DoubleQuote DoubleQuote )* DoubleQuote ) | ( Char | MacroDefinition )+ )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==DoubleQuote) ) {
                alt47=1;
            }
            else if ( (LA47_0==Char||LA47_0==MacroDefinition) ) {
                alt47=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;

            }
            switch (alt47) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:117:4: ( DoubleQuote ( Char | Comma | DoubleQuote DoubleQuote )* DoubleQuote )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /work/projects/yeclipse/ImpexAST/src/impex.g:117:4: ( DoubleQuote ( Char | Comma | DoubleQuote DoubleQuote )* DoubleQuote )
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:117:5: DoubleQuote ( Char | Comma | DoubleQuote DoubleQuote )* DoubleQuote
                    {
                    DoubleQuote83=(Token)match(input,DoubleQuote,FOLLOW_DoubleQuote_in_field773); 
                    DoubleQuote83_tree = 
                    (CommonTree)adaptor.create(DoubleQuote83)
                    ;
                    adaptor.addChild(root_0, DoubleQuote83_tree);


                    // /work/projects/yeclipse/ImpexAST/src/impex.g:117:17: ( Char | Comma | DoubleQuote DoubleQuote )*
                    loop45:
                    do {
                        int alt45=4;
                        switch ( input.LA(1) ) {
                        case DoubleQuote:
                            {
                            int LA45_1 = input.LA(2);

                            if ( (LA45_1==DoubleQuote) ) {
                                alt45=3;
                            }


                            }
                            break;
                        case Char:
                            {
                            alt45=1;
                            }
                            break;
                        case Comma:
                            {
                            alt45=2;
                            }
                            break;

                        }

                        switch (alt45) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/impex.g:117:18: Char
                    	    {
                    	    Char84=(Token)match(input,Char,FOLLOW_Char_in_field776); 
                    	    Char84_tree = 
                    	    (CommonTree)adaptor.create(Char84)
                    	    ;
                    	    adaptor.addChild(root_0, Char84_tree);


                    	    }
                    	    break;
                    	case 2 :
                    	    // /work/projects/yeclipse/ImpexAST/src/impex.g:117:25: Comma
                    	    {
                    	    Comma85=(Token)match(input,Comma,FOLLOW_Comma_in_field780); 
                    	    Comma85_tree = 
                    	    (CommonTree)adaptor.create(Comma85)
                    	    ;
                    	    adaptor.addChild(root_0, Comma85_tree);


                    	    }
                    	    break;
                    	case 3 :
                    	    // /work/projects/yeclipse/ImpexAST/src/impex.g:117:33: DoubleQuote DoubleQuote
                    	    {
                    	    DoubleQuote86=(Token)match(input,DoubleQuote,FOLLOW_DoubleQuote_in_field784); 
                    	    DoubleQuote86_tree = 
                    	    (CommonTree)adaptor.create(DoubleQuote86)
                    	    ;
                    	    adaptor.addChild(root_0, DoubleQuote86_tree);


                    	    DoubleQuote87=(Token)match(input,DoubleQuote,FOLLOW_DoubleQuote_in_field786); 
                    	    DoubleQuote87_tree = 
                    	    (CommonTree)adaptor.create(DoubleQuote87)
                    	    ;
                    	    adaptor.addChild(root_0, DoubleQuote87_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop45;
                        }
                    } while (true);


                    DoubleQuote88=(Token)match(input,DoubleQuote,FOLLOW_DoubleQuote_in_field790); 
                    DoubleQuote88_tree = 
                    (CommonTree)adaptor.create(DoubleQuote88)
                    ;
                    adaptor.addChild(root_0, DoubleQuote88_tree);


                    }


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:117:74: ( Char | MacroDefinition )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /work/projects/yeclipse/ImpexAST/src/impex.g:117:74: ( Char | MacroDefinition )+
                    int cnt46=0;
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==Char||LA46_0==MacroDefinition) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/impex.g:
                    	    {
                    	    set89=(Token)input.LT(1);

                    	    if ( input.LA(1)==Char||input.LA(1)==MacroDefinition ) {
                    	        input.consume();
                    	        adaptor.addChild(root_0, 
                    	        (CommonTree)adaptor.create(set89)
                    	        );
                    	        state.errorRecovery=false;
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt46 >= 1 ) break loop46;
                                EarlyExitException eee =
                                    new EarlyExitException(46, input);
                                throw eee;
                        }
                        cnt46++;
                    } while (true);


                    }
                    break;

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
    // $ANTLR end "field"

    // Delegated rules


    protected DFA5 dfa5 = new DFA5(this);
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA28 dfa28 = new DFA28(this);
    protected DFA27 dfa27 = new DFA27(this);
    static final String DFA5_eotS =
        "\6\uffff";
    static final String DFA5_eofS =
        "\1\1\1\5\3\uffff\1\4";
    static final String DFA5_minS =
        "\2\22\1\uffff\1\41\1\uffff\1\22";
    static final String DFA5_maxS =
        "\2\75\1\uffff\1\75\1\uffff\1\75";
    static final String DFA5_acceptS =
        "\2\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String DFA5_specialS =
        "\6\uffff}>";
    static final String[] DFA5_transitionS = {
            "\1\2\16\uffff\2\2\5\uffff\1\4\2\uffff\1\2\5\uffff\1\2\3\uffff"+
            "\1\4\2\uffff\1\2\4\uffff\1\3",
            "\1\4\16\uffff\2\4\5\uffff\1\4\2\uffff\1\4\5\uffff\1\4\3\uffff"+
            "\1\4\2\uffff\1\4\4\uffff\1\4",
            "",
            "\2\2\16\uffff\1\2\3\uffff\1\4\2\uffff\1\2\4\uffff\1\3",
            "",
            "\1\4\16\uffff\2\4\5\uffff\1\4\2\uffff\1\4\5\uffff\1\4\3\uffff"+
            "\1\4\2\uffff\1\4\4\uffff\1\4"
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "()* loopback of 65:12: ( row )*";
        }
    }
    static final String DFA12_eotS =
        "\4\uffff";
    static final String DFA12_eofS =
        "\1\3\3\uffff";
    static final String DFA12_minS =
        "\2\20\2\uffff";
    static final String DFA12_maxS =
        "\2\75\2\uffff";
    static final String DFA12_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA12_specialS =
        "\4\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\2\4\uffff\1\2\22\uffff\1\3\2\uffff\1\2\11\uffff\1\3\7\uffff"+
            "\1\1",
            "\1\2\4\uffff\1\2\25\uffff\1\2\11\uffff\1\3\7\uffff\1\1",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "73:19: ( ( Ws )* field )?";
        }
    }
    static final String DFA28_eotS =
        "\4\uffff";
    static final String DFA28_eofS =
        "\4\uffff";
    static final String DFA28_minS =
        "\2\21\2\uffff";
    static final String DFA28_maxS =
        "\2\75\2\uffff";
    static final String DFA28_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA28_specialS =
        "\4\uffff}>";
    static final String[] DFA28_transitionS = {
            "\1\2\41\uffff\1\3\11\uffff\1\1",
            "\1\2\41\uffff\1\3\11\uffff\1\1",
            "",
            ""
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "94:74: ( ( Ws )* Comma ( Ws )* ( Word | complexAttributeRef ) )?";
        }
    }
    static final String DFA27_eotS =
        "\5\uffff";
    static final String DFA27_eofS =
        "\5\uffff";
    static final String DFA27_minS =
        "\1\72\2\46\2\uffff";
    static final String DFA27_maxS =
        "\1\72\2\75\2\uffff";
    static final String DFA27_acceptS =
        "\3\uffff\1\1\1\2";
    static final String DFA27_specialS =
        "\5\uffff}>";
    static final String[] DFA27_transitionS = {
            "\1\1",
            "\1\4\14\uffff\1\3\11\uffff\1\2",
            "\1\4\14\uffff\1\3\11\uffff\1\2",
            "",
            ""
    };

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "94:89: ( Word | complexAttributeRef )";
        }
    }
 

    public static final BitSet FOLLOW_macroAssignement_in_impex144 = new BitSet(new long[]{0x2102080600040000L});
    public static final BitSet FOLLOW_impexBlock_in_impex147 = new BitSet(new long[]{0x2102080600040000L});
    public static final BitSet FOLLOW_Comment_in_impex151 = new BitSet(new long[]{0x2102080600040000L});
    public static final BitSet FOLLOW_EOF_in_impex156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MacroDefinition_in_macroAssignement195 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_Equals_in_macroAssignement197 = new BitSet(new long[]{0x0000080000010000L});
    public static final BitSet FOLLOW_macroExpression_in_macroAssignement199 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_LineBreak_in_macroAssignement202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_header_in_impexBlock265 = new BitSet(new long[]{0x2020010000000002L});
    public static final BitSet FOLLOW_row_in_impexBlock269 = new BitSet(new long[]{0x2020010000000002L});
    public static final BitSet FOLLOW_headerModeType_in_header299 = new BitSet(new long[]{0x0020010000000000L});
    public static final BitSet FOLLOW_Semicolon_in_header303 = new BitSet(new long[]{0x2400000000000000L});
    public static final BitSet FOLLOW_Ws_in_header306 = new BitSet(new long[]{0x2400000000000000L});
    public static final BitSet FOLLOW_simpleAttribute_in_header310 = new BitSet(new long[]{0x0020010000000000L});
    public static final BitSet FOLLOW_complexAttribute_in_header315 = new BitSet(new long[]{0x0020010000000000L});
    public static final BitSet FOLLOW_LineBreak_in_header322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EOF_in_header326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ws_in_row357 = new BitSet(new long[]{0x2020000000000000L});
    public static final BitSet FOLLOW_Semicolon_in_row360 = new BitSet(new long[]{0x2020090000210000L});
    public static final BitSet FOLLOW_Ws_in_row363 = new BitSet(new long[]{0x2000080000210000L});
    public static final BitSet FOLLOW_field_in_row367 = new BitSet(new long[]{0x2020010000000000L});
    public static final BitSet FOLLOW_LineBreak_in_row376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EOF_in_row380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ws_in_headerModeType407 = new BitSet(new long[]{0x2102000600000000L});
    public static final BitSet FOLLOW_headerMode_in_headerModeType410 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_Ws_in_headerModeType412 = new BitSet(new long[]{0x2400000000000000L});
    public static final BitSet FOLLOW_Word_in_headerModeType415 = new BitSet(new long[]{0x2000002000000002L});
    public static final BitSet FOLLOW_Ws_in_headerModeType419 = new BitSet(new long[]{0x2000002000000000L});
    public static final BitSet FOLLOW_headerModifier_in_headerModeType422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Word_in_simpleAttribute452 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_attributeModifier_in_simpleAttribute454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_complexAttributeRef_in_complexAttribute478 = new BitSet(new long[]{0x2000002000000002L});
    public static final BitSet FOLLOW_Ws_in_complexAttribute481 = new BitSet(new long[]{0x2000002000000000L});
    public static final BitSet FOLLOW_attributeModifier_in_complexAttribute484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Word_in_complexAttributeRef509 = new BitSet(new long[]{0x2000004000000000L});
    public static final BitSet FOLLOW_Ws_in_complexAttributeRef511 = new BitSet(new long[]{0x2000004000000000L});
    public static final BitSet FOLLOW_LeftParenthesis_in_complexAttributeRef514 = new BitSet(new long[]{0x2400000000000000L});
    public static final BitSet FOLLOW_Ws_in_complexAttributeRef516 = new BitSet(new long[]{0x2400000000000000L});
    public static final BitSet FOLLOW_Word_in_complexAttributeRef519 = new BitSet(new long[]{0x6408000000000000L});
    public static final BitSet FOLLOW_62_in_complexAttributeRef523 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_Word_in_complexAttributeRef525 = new BitSet(new long[]{0x2008000000000000L});
    public static final BitSet FOLLOW_complexAttributeRef_in_complexAttributeRef532 = new BitSet(new long[]{0x2008000000020000L});
    public static final BitSet FOLLOW_Ws_in_complexAttributeRef535 = new BitSet(new long[]{0x2000000000020000L});
    public static final BitSet FOLLOW_Comma_in_complexAttributeRef538 = new BitSet(new long[]{0x2400000000000000L});
    public static final BitSet FOLLOW_Ws_in_complexAttributeRef540 = new BitSet(new long[]{0x2400000000000000L});
    public static final BitSet FOLLOW_Word_in_complexAttributeRef544 = new BitSet(new long[]{0x2008000000000000L});
    public static final BitSet FOLLOW_complexAttributeRef_in_complexAttributeRef548 = new BitSet(new long[]{0x2008000000000000L});
    public static final BitSet FOLLOW_Ws_in_complexAttributeRef555 = new BitSet(new long[]{0x2008000000000000L});
    public static final BitSet FOLLOW_RightParenthesis_in_complexAttributeRef558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftBracket_in_headerModifier593 = new BitSet(new long[]{0x1000000000001000L});
    public static final BitSet FOLLOW_BoolHeaderModifier_in_headerModifier599 = new BitSet(new long[]{0x2000000000400000L});
    public static final BitSet FOLLOW_Ws_in_headerModifier601 = new BitSet(new long[]{0x2000000000400000L});
    public static final BitSet FOLLOW_Equals_in_headerModifier604 = new BitSet(new long[]{0x2000000000000400L});
    public static final BitSet FOLLOW_Ws_in_headerModifier607 = new BitSet(new long[]{0x2000000000000400L});
    public static final BitSet FOLLOW_Bool_in_headerModifier610 = new BitSet(new long[]{0x2004000000000000L});
    public static final BitSet FOLLOW_WordHeaderModifier_in_headerModifier626 = new BitSet(new long[]{0x2000000000400000L});
    public static final BitSet FOLLOW_Ws_in_headerModifier628 = new BitSet(new long[]{0x2000000000400000L});
    public static final BitSet FOLLOW_Equals_in_headerModifier631 = new BitSet(new long[]{0x2400000000000000L});
    public static final BitSet FOLLOW_Ws_in_headerModifier634 = new BitSet(new long[]{0x2400000000000000L});
    public static final BitSet FOLLOW_Word_in_headerModifier637 = new BitSet(new long[]{0x2004000000000000L});
    public static final BitSet FOLLOW_Ws_in_headerModifier653 = new BitSet(new long[]{0x2004000000000000L});
    public static final BitSet FOLLOW_RightBracket_in_headerModifier657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftBracket_in_attributeModifier668 = new BitSet(new long[]{0x0800001000000800L});
    public static final BitSet FOLLOW_BoolAttribModifier_in_attributeModifier674 = new BitSet(new long[]{0x2000000000400000L});
    public static final BitSet FOLLOW_Ws_in_attributeModifier676 = new BitSet(new long[]{0x2000000000400000L});
    public static final BitSet FOLLOW_Equals_in_attributeModifier679 = new BitSet(new long[]{0x2000000000000400L});
    public static final BitSet FOLLOW_Ws_in_attributeModifier681 = new BitSet(new long[]{0x2000000000000400L});
    public static final BitSet FOLLOW_Bool_in_attributeModifier684 = new BitSet(new long[]{0x2004000000000000L});
    public static final BitSet FOLLOW_IntAttribModifier_in_attributeModifier700 = new BitSet(new long[]{0x2000000000400000L});
    public static final BitSet FOLLOW_Ws_in_attributeModifier702 = new BitSet(new long[]{0x2000000000400000L});
    public static final BitSet FOLLOW_Equals_in_attributeModifier705 = new BitSet(new long[]{0x2000000800000000L});
    public static final BitSet FOLLOW_Ws_in_attributeModifier707 = new BitSet(new long[]{0x2000000800000000L});
    public static final BitSet FOLLOW_Int_in_attributeModifier710 = new BitSet(new long[]{0x2004000000000000L});
    public static final BitSet FOLLOW_WordAttribModifier_in_attributeModifier727 = new BitSet(new long[]{0x2000000000400000L});
    public static final BitSet FOLLOW_Ws_in_attributeModifier729 = new BitSet(new long[]{0x2000000000400000L});
    public static final BitSet FOLLOW_Equals_in_attributeModifier732 = new BitSet(new long[]{0x2400000000000000L});
    public static final BitSet FOLLOW_Ws_in_attributeModifier734 = new BitSet(new long[]{0x2400000000000000L});
    public static final BitSet FOLLOW_Word_in_attributeModifier737 = new BitSet(new long[]{0x2004000000000000L});
    public static final BitSet FOLLOW_Ws_in_attributeModifier753 = new BitSet(new long[]{0x2004000000000000L});
    public static final BitSet FOLLOW_RightBracket_in_attributeModifier757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DoubleQuote_in_field773 = new BitSet(new long[]{0x0000000000230000L});
    public static final BitSet FOLLOW_Char_in_field776 = new BitSet(new long[]{0x0000000000230000L});
    public static final BitSet FOLLOW_Comma_in_field780 = new BitSet(new long[]{0x0000000000230000L});
    public static final BitSet FOLLOW_DoubleQuote_in_field784 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_DoubleQuote_in_field786 = new BitSet(new long[]{0x0000000000230000L});
    public static final BitSet FOLLOW_DoubleQuote_in_field790 = new BitSet(new long[]{0x0000000000000002L});

}