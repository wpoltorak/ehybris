// $ANTLR 3.4 /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/impex.g 2012-09-27 07:46:26

  package output;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class impexParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGNEMENT", "ASSIGNEMENTS", "ATTRIBUTES", "Alias", "AllowNull", "BatchMode", "BlankLine", "COMMENTS", "COMPLEX_ATTRIBUTE", "CacheUnique", "Comma", "Comment", "Dollar", "Equals", "ForceWrite", "HEADER", "HEADER_PREFIX", "HEADER_TYPE", "Hash", "IMPEX", "IMPEX_BLOCK", "IMPEX_BLOCKS", "IgnoreKeyCase", "IgnoreNull", "Insert", "InsertUpdate", "LeftBracket", "LeftParenthesis", "LineBreak", "LineContinuation", "MACRO", "Pos", "Processor", "ROW", "ROWS", "Remove", "RightBracket", "RightParenthesis", "SIMPLE_ATTRIBUTE", "Semicolon", "Underscore", "Unique", "Update", "Virtual", "Ws"
    };

    public static final int EOF=-1;
    public static final int ASSIGNEMENT=4;
    public static final int ASSIGNEMENTS=5;
    public static final int ATTRIBUTES=6;
    public static final int Alias=7;
    public static final int AllowNull=8;
    public static final int BatchMode=9;
    public static final int BlankLine=10;
    public static final int COMMENTS=11;
    public static final int COMPLEX_ATTRIBUTE=12;
    public static final int CacheUnique=13;
    public static final int Comma=14;
    public static final int Comment=15;
    public static final int Dollar=16;
    public static final int Equals=17;
    public static final int ForceWrite=18;
    public static final int HEADER=19;
    public static final int HEADER_PREFIX=20;
    public static final int HEADER_TYPE=21;
    public static final int Hash=22;
    public static final int IMPEX=23;
    public static final int IMPEX_BLOCK=24;
    public static final int IMPEX_BLOCKS=25;
    public static final int IgnoreKeyCase=26;
    public static final int IgnoreNull=27;
    public static final int Insert=28;
    public static final int InsertUpdate=29;
    public static final int LeftBracket=30;
    public static final int LeftParenthesis=31;
    public static final int LineBreak=32;
    public static final int LineContinuation=33;
    public static final int MACRO=34;
    public static final int Pos=35;
    public static final int Processor=36;
    public static final int ROW=37;
    public static final int ROWS=38;
    public static final int Remove=39;
    public static final int RightBracket=40;
    public static final int RightParenthesis=41;
    public static final int SIMPLE_ATTRIBUTE=42;
    public static final int Semicolon=43;
    public static final int Underscore=44;
    public static final int Unique=45;
    public static final int Update=46;
    public static final int Virtual=47;
    public static final int Ws=48;

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
    public String getGrammarFileName() { return "/home/wojtuch/projects/ehybris/ImpexAST/src/main/java/impex.g"; }


    public static class impex_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "impex"
    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/impex.g:43:1: impex : ( ( Comment ( LineBreak )? ) | BlankLine )* EOF -> ^( IMPEX ^( COMMENTS ( Comment )* ) ) ;
    public final impexParser.impex_return impex() throws RecognitionException {
        impexParser.impex_return retval = new impexParser.impex_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Comment1=null;
        Token LineBreak2=null;
        Token BlankLine3=null;
        Token EOF4=null;

        CommonTree Comment1_tree=null;
        CommonTree LineBreak2_tree=null;
        CommonTree BlankLine3_tree=null;
        CommonTree EOF4_tree=null;
        RewriteRuleTokenStream stream_LineBreak=new RewriteRuleTokenStream(adaptor,"token LineBreak");
        RewriteRuleTokenStream stream_Comment=new RewriteRuleTokenStream(adaptor,"token Comment");
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleTokenStream stream_BlankLine=new RewriteRuleTokenStream(adaptor,"token BlankLine");

        try {
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/impex.g:44:2: ( ( ( Comment ( LineBreak )? ) | BlankLine )* EOF -> ^( IMPEX ^( COMMENTS ( Comment )* ) ) )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/impex.g:44:4: ( ( Comment ( LineBreak )? ) | BlankLine )* EOF
            {
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/impex.g:44:4: ( ( Comment ( LineBreak )? ) | BlankLine )*
            loop2:
            do {
                int alt2=3;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Comment) ) {
                    alt2=1;
                }
                else if ( (LA2_0==BlankLine) ) {
                    alt2=2;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/impex.g:44:5: ( Comment ( LineBreak )? )
            	    {
            	    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/impex.g:44:5: ( Comment ( LineBreak )? )
            	    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/impex.g:44:6: Comment ( LineBreak )?
            	    {
            	    Comment1=(Token)match(input,Comment,FOLLOW_Comment_in_impex142);  
            	    stream_Comment.add(Comment1);


            	    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/impex.g:44:14: ( LineBreak )?
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==LineBreak) ) {
            	        alt1=1;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/impex.g:44:14: LineBreak
            	            {
            	            LineBreak2=(Token)match(input,LineBreak,FOLLOW_LineBreak_in_impex144);  
            	            stream_LineBreak.add(LineBreak2);


            	            }
            	            break;

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/impex.g:44:28: BlankLine
            	    {
            	    BlankLine3=(Token)match(input,BlankLine,FOLLOW_BlankLine_in_impex150);  
            	    stream_BlankLine.add(BlankLine3);


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            EOF4=(Token)match(input,EOF,FOLLOW_EOF_in_impex154);  
            stream_EOF.add(EOF4);


            // AST REWRITE
            // elements: Comment
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 44:44: -> ^( IMPEX ^( COMMENTS ( Comment )* ) )
            {
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/impex.g:44:47: ^( IMPEX ^( COMMENTS ( Comment )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IMPEX, "IMPEX")
                , root_1);

                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/impex.g:44:56: ^( COMMENTS ( Comment )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(COMMENTS, "COMMENTS")
                , root_2);

                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/impex.g:44:67: ( Comment )*
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

    // Delegated rules


 

    public static final BitSet FOLLOW_Comment_in_impex142 = new BitSet(new long[]{0x0000000100008400L});
    public static final BitSet FOLLOW_LineBreak_in_impex144 = new BitSet(new long[]{0x0000000000008400L});
    public static final BitSet FOLLOW_BlankLine_in_impex150 = new BitSet(new long[]{0x0000000000008400L});
    public static final BitSet FOLLOW_EOF_in_impex154 = new BitSet(new long[]{0x0000000000000002L});

}