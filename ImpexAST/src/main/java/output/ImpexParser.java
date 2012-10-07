// $ANTLR 3.4 /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g 2012-10-07 22:55:01

  package output;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class ImpexParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGNEMENT", "ASSIGNEMENTS", "ATTRIBUTES", "Alias", "AllowNull", "BatchMode", "COMMENTS", "COMPLEX_ATTRIBUTE", "CacheUnique", "Comma", "Comment", "Equals", "ForceWrite", "HEADER", "HEADER_PREFIX", "HEADER_TYPE", "IMPEX", "IMPEX_BLOCK", "IMPEX_BLOCKS", "IgnoreKeyCase", "IgnoreNull", "Insert", "InsertUpdate", "LeftBracket", "LeftParenthesis", "LineBreak", "LineContinuation", "MACRO", "Macrodef", "Macroval", "Pos", "Processor", "ROW", "ROWS", "Remove", "RightBracket", "RightParenthesis", "SIMPLE_ATTRIBUTE", "Semicolon", "Unique", "Update", "Virtual", "Ws"
    };

    public static final int EOF=-1;
    public static final int ASSIGNEMENT=4;
    public static final int ASSIGNEMENTS=5;
    public static final int ATTRIBUTES=6;
    public static final int Alias=7;
    public static final int AllowNull=8;
    public static final int BatchMode=9;
    public static final int COMMENTS=10;
    public static final int COMPLEX_ATTRIBUTE=11;
    public static final int CacheUnique=12;
    public static final int Comma=13;
    public static final int Comment=14;
    public static final int Equals=15;
    public static final int ForceWrite=16;
    public static final int HEADER=17;
    public static final int HEADER_PREFIX=18;
    public static final int HEADER_TYPE=19;
    public static final int IMPEX=20;
    public static final int IMPEX_BLOCK=21;
    public static final int IMPEX_BLOCKS=22;
    public static final int IgnoreKeyCase=23;
    public static final int IgnoreNull=24;
    public static final int Insert=25;
    public static final int InsertUpdate=26;
    public static final int LeftBracket=27;
    public static final int LeftParenthesis=28;
    public static final int LineBreak=29;
    public static final int LineContinuation=30;
    public static final int MACRO=31;
    public static final int Macrodef=32;
    public static final int Macroval=33;
    public static final int Pos=34;
    public static final int Processor=35;
    public static final int ROW=36;
    public static final int ROWS=37;
    public static final int Remove=38;
    public static final int RightBracket=39;
    public static final int RightParenthesis=40;
    public static final int SIMPLE_ATTRIBUTE=41;
    public static final int Semicolon=42;
    public static final int Unique=43;
    public static final int Update=44;
    public static final int Virtual=45;
    public static final int Ws=46;

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


    public static class impex_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "impex"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:42:1: impex : ( Comment | Ws | LineBreak | macroAssignement )* EOF -> ^( IMPEX ^( COMMENTS ( Comment )* ) ^( ASSIGNEMENTS ( macroAssignement )* ) ) ;
    public final ImpexParser.impex_return impex() throws RecognitionException {
        ImpexParser.impex_return retval = new ImpexParser.impex_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Comment1=null;
        Token Ws2=null;
        Token LineBreak3=null;
        Token EOF5=null;
        ImpexParser.macroAssignement_return macroAssignement4 =null;


        CommonTree Comment1_tree=null;
        CommonTree Ws2_tree=null;
        CommonTree LineBreak3_tree=null;
        CommonTree EOF5_tree=null;
        RewriteRuleTokenStream stream_LineBreak=new RewriteRuleTokenStream(adaptor,"token LineBreak");
        RewriteRuleTokenStream stream_Ws=new RewriteRuleTokenStream(adaptor,"token Ws");
        RewriteRuleTokenStream stream_Comment=new RewriteRuleTokenStream(adaptor,"token Comment");
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_macroAssignement=new RewriteRuleSubtreeStream(adaptor,"rule macroAssignement");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:43:2: ( ( Comment | Ws | LineBreak | macroAssignement )* EOF -> ^( IMPEX ^( COMMENTS ( Comment )* ) ^( ASSIGNEMENTS ( macroAssignement )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:43:4: ( Comment | Ws | LineBreak | macroAssignement )* EOF
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:43:4: ( Comment | Ws | LineBreak | macroAssignement )*
            loop1:
            do {
                int alt1=5;
                switch ( input.LA(1) ) {
                case Comment:
                    {
                    alt1=1;
                    }
                    break;
                case Ws:
                    {
                    alt1=2;
                    }
                    break;
                case LineBreak:
                    {
                    alt1=3;
                    }
                    break;
                case Macrodef:
                    {
                    alt1=4;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:43:5: Comment
            	    {
            	    Comment1=(Token)match(input,Comment,FOLLOW_Comment_in_impex140);  
            	    stream_Comment.add(Comment1);


            	    }
            	    break;
            	case 2 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:43:15: Ws
            	    {
            	    Ws2=(Token)match(input,Ws,FOLLOW_Ws_in_impex144);  
            	    stream_Ws.add(Ws2);


            	    }
            	    break;
            	case 3 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:43:20: LineBreak
            	    {
            	    LineBreak3=(Token)match(input,LineBreak,FOLLOW_LineBreak_in_impex148);  
            	    stream_LineBreak.add(LineBreak3);


            	    }
            	    break;
            	case 4 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:43:32: macroAssignement
            	    {
            	    pushFollow(FOLLOW_macroAssignement_in_impex152);
            	    macroAssignement4=macroAssignement();

            	    state._fsp--;

            	    stream_macroAssignement.add(macroAssignement4.getTree());

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            EOF5=(Token)match(input,EOF,FOLLOW_EOF_in_impex156);  
            stream_EOF.add(EOF5);


            // AST REWRITE
            // elements: macroAssignement, Comment
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 43:55: -> ^( IMPEX ^( COMMENTS ( Comment )* ) ^( ASSIGNEMENTS ( macroAssignement )* ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:43:58: ^( IMPEX ^( COMMENTS ( Comment )* ) ^( ASSIGNEMENTS ( macroAssignement )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IMPEX, "IMPEX")
                , root_1);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:43:67: ^( COMMENTS ( Comment )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(COMMENTS, "COMMENTS")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:43:78: ( Comment )*
                while ( stream_Comment.hasNext() ) {
                    adaptor.addChild(root_2, 
                    stream_Comment.nextNode()
                    );

                }
                stream_Comment.reset();

                adaptor.addChild(root_1, root_2);
                }

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:43:88: ^( ASSIGNEMENTS ( macroAssignement )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ASSIGNEMENTS, "ASSIGNEMENTS")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:43:103: ( macroAssignement )*
                while ( stream_macroAssignement.hasNext() ) {
                    adaptor.addChild(root_2, stream_macroAssignement.nextTree());

                }
                stream_macroAssignement.reset();

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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:47:1: macroAssignement : Macrodef Equals Macroval -> ^( ASSIGNEMENT Macrodef Macroval ) ;
    public final ImpexParser.macroAssignement_return macroAssignement() throws RecognitionException {
        ImpexParser.macroAssignement_return retval = new ImpexParser.macroAssignement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Macrodef6=null;
        Token Equals7=null;
        Token Macroval8=null;

        CommonTree Macrodef6_tree=null;
        CommonTree Equals7_tree=null;
        CommonTree Macroval8_tree=null;
        RewriteRuleTokenStream stream_Macroval=new RewriteRuleTokenStream(adaptor,"token Macroval");
        RewriteRuleTokenStream stream_Macrodef=new RewriteRuleTokenStream(adaptor,"token Macrodef");
        RewriteRuleTokenStream stream_Equals=new RewriteRuleTokenStream(adaptor,"token Equals");

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:48:2: ( Macrodef Equals Macroval -> ^( ASSIGNEMENT Macrodef Macroval ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:48:4: Macrodef Equals Macroval
            {
            Macrodef6=(Token)match(input,Macrodef,FOLLOW_Macrodef_in_macroAssignement189);  
            stream_Macrodef.add(Macrodef6);


            Equals7=(Token)match(input,Equals,FOLLOW_Equals_in_macroAssignement191);  
            stream_Equals.add(Equals7);


            Macroval8=(Token)match(input,Macroval,FOLLOW_Macroval_in_macroAssignement193);  
            stream_Macroval.add(Macroval8);


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
            // 48:29: -> ^( ASSIGNEMENT Macrodef Macroval )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:48:32: ^( ASSIGNEMENT Macrodef Macroval )
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
    // $ANTLR end "macroAssignement"

    // Delegated rules


 

    public static final BitSet FOLLOW_Comment_in_impex140 = new BitSet(new long[]{0x0000400120004000L});
    public static final BitSet FOLLOW_Ws_in_impex144 = new BitSet(new long[]{0x0000400120004000L});
    public static final BitSet FOLLOW_LineBreak_in_impex148 = new BitSet(new long[]{0x0000400120004000L});
    public static final BitSet FOLLOW_macroAssignement_in_impex152 = new BitSet(new long[]{0x0000400120004000L});
    public static final BitSet FOLLOW_EOF_in_impex156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Macrodef_in_macroAssignement189 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_Equals_in_macroAssignement191 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_Macroval_in_macroAssignement193 = new BitSet(new long[]{0x0000000000000002L});

}