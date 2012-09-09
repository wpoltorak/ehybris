// $ANTLR 3.4 /work/projects/yeclipse/ImpexAST/src/main/java/impex.g 2012-09-09 13:19:43

  package output;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class impexParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGNEMENT", "ASSIGNEMENTS", "ATTRIBUTES", "Alias", "AllowNull", "BatchMode", "COMMENTS", "COMPLEX_ATTRIBUTE", "CacheUnique", "Comma", "Comment", "Dollar", "Equals", "ForceWrite", "HEADER", "HEADER_PREFIX", "HEADER_TYPE", "Hash", "IMPEX", "IMPEX_BLOCK", "IMPEX_BLOCKS", "IgnoreKeyCase", "IgnoreNull", "Insert", "InsertUpdate", "LeftBracket", "LeftParenthesis", "LineBreak", "LineContinuation", "MACRO", "Pos", "Processor", "ROW", "ROWS", "Remove", "RightBracket", "RightParenthesis", "SIMPLE_ATTRIBUTE", "Semicolon", "Underscore", "Unique", "Update", "Virtual", "Ws"
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
    public static final int Dollar=15;
    public static final int Equals=16;
    public static final int ForceWrite=17;
    public static final int HEADER=18;
    public static final int HEADER_PREFIX=19;
    public static final int HEADER_TYPE=20;
    public static final int Hash=21;
    public static final int IMPEX=22;
    public static final int IMPEX_BLOCK=23;
    public static final int IMPEX_BLOCKS=24;
    public static final int IgnoreKeyCase=25;
    public static final int IgnoreNull=26;
    public static final int Insert=27;
    public static final int InsertUpdate=28;
    public static final int LeftBracket=29;
    public static final int LeftParenthesis=30;
    public static final int LineBreak=31;
    public static final int LineContinuation=32;
    public static final int MACRO=33;
    public static final int Pos=34;
    public static final int Processor=35;
    public static final int ROW=36;
    public static final int ROWS=37;
    public static final int Remove=38;
    public static final int RightBracket=39;
    public static final int RightParenthesis=40;
    public static final int SIMPLE_ATTRIBUTE=41;
    public static final int Semicolon=42;
    public static final int Underscore=43;
    public static final int Unique=44;
    public static final int Update=45;
    public static final int Virtual=46;
    public static final int Ws=47;

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
    public String getGrammarFileName() { return "/work/projects/yeclipse/ImpexAST/src/main/java/impex.g"; }


    public static class impex_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "impex"
    // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:43:1: impex : ( Comment ( LineBreak )? )+ EOF -> ^( IMPEX ^( COMMENTS ( Comment )* ) ) ;
    public final impexParser.impex_return impex() throws RecognitionException {
        impexParser.impex_return retval = new impexParser.impex_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Comment1=null;
        Token LineBreak2=null;
        Token EOF3=null;

        CommonTree Comment1_tree=null;
        CommonTree LineBreak2_tree=null;
        CommonTree EOF3_tree=null;
        RewriteRuleTokenStream stream_LineBreak=new RewriteRuleTokenStream(adaptor,"token LineBreak");
        RewriteRuleTokenStream stream_Comment=new RewriteRuleTokenStream(adaptor,"token Comment");
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:44:2: ( ( Comment ( LineBreak )? )+ EOF -> ^( IMPEX ^( COMMENTS ( Comment )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:44:6: ( Comment ( LineBreak )? )+ EOF
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:44:6: ( Comment ( LineBreak )? )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==Comment) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:44:7: Comment ( LineBreak )?
            	    {
            	    Comment1=(Token)match(input,Comment,FOLLOW_Comment_in_impex143);  
            	    stream_Comment.add(Comment1);


            	    // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:44:15: ( LineBreak )?
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==LineBreak) ) {
            	        alt1=1;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:44:15: LineBreak
            	            {
            	            LineBreak2=(Token)match(input,LineBreak,FOLLOW_LineBreak_in_impex145);  
            	            stream_LineBreak.add(LineBreak2);


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


            EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_impex150);  
            stream_EOF.add(EOF3);


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
            // 44:32: -> ^( IMPEX ^( COMMENTS ( Comment )* ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:44:35: ^( IMPEX ^( COMMENTS ( Comment )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IMPEX, "IMPEX")
                , root_1);

                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:44:44: ^( COMMENTS ( Comment )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(COMMENTS, "COMMENTS")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:44:55: ( Comment )*
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


 

    public static final BitSet FOLLOW_Comment_in_impex143 = new BitSet(new long[]{0x0000000080004000L});
    public static final BitSet FOLLOW_LineBreak_in_impex145 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_EOF_in_impex150 = new BitSet(new long[]{0x0000000000000002L});

}