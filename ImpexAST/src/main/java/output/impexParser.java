// $ANTLR 3.4 /work/projects/yeclipse/ImpexAST/src/main/java/impex.g 2012-10-04 22:18:54

  package output;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class impexParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGNEMENT", "ASSIGNEMENTS", "ATTRIBUTES", "Alias", "AllowNull", "BatchMode", "COMMENTS", "COMPLEX_ATTRIBUTE", "CacheUnique", "Char", "Comma", "Comment", "Digit", "Dollar", "Equals", "ForceWrite", "HEADER", "HEADER_PREFIX", "HEADER_TYPE", "Hash", "IMPEX", "IMPEX_BLOCK", "IMPEX_BLOCKS", "IgnoreKeyCase", "IgnoreNull", "Insert", "InsertUpdate", "LeftBracket", "LeftParenthesis", "Letter", "LineBreak", "LineContinuation", "MACRO", "MacroDefinition", "MacroExpression", "MacroIdentifier", "Pos", "Processor", "ROW", "ROWS", "Remove", "RightBracket", "RightParenthesis", "SIMPLE_ATTRIBUTE", "Semicolon", "Underscore", "Unique", "Update", "Virtual", "Ws"
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
    public static final int Char=13;
    public static final int Comma=14;
    public static final int Comment=15;
    public static final int Digit=16;
    public static final int Dollar=17;
    public static final int Equals=18;
    public static final int ForceWrite=19;
    public static final int HEADER=20;
    public static final int HEADER_PREFIX=21;
    public static final int HEADER_TYPE=22;
    public static final int Hash=23;
    public static final int IMPEX=24;
    public static final int IMPEX_BLOCK=25;
    public static final int IMPEX_BLOCKS=26;
    public static final int IgnoreKeyCase=27;
    public static final int IgnoreNull=28;
    public static final int Insert=29;
    public static final int InsertUpdate=30;
    public static final int LeftBracket=31;
    public static final int LeftParenthesis=32;
    public static final int Letter=33;
    public static final int LineBreak=34;
    public static final int LineContinuation=35;
    public static final int MACRO=36;
    public static final int MacroDefinition=37;
    public static final int MacroExpression=38;
    public static final int MacroIdentifier=39;
    public static final int Pos=40;
    public static final int Processor=41;
    public static final int ROW=42;
    public static final int ROWS=43;
    public static final int Remove=44;
    public static final int RightBracket=45;
    public static final int RightParenthesis=46;
    public static final int SIMPLE_ATTRIBUTE=47;
    public static final int Semicolon=48;
    public static final int Underscore=49;
    public static final int Unique=50;
    public static final int Update=51;
    public static final int Virtual=52;
    public static final int Ws=53;

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
    // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:42:1: impex : ( ( Ws | Comment ) ( LineBreak )? )* EOF -> ^( IMPEX ^( COMMENTS ( Comment )* ) ) ;
    public final impexParser.impex_return impex() throws RecognitionException {
        impexParser.impex_return retval = new impexParser.impex_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Ws1=null;
        Token Comment2=null;
        Token LineBreak3=null;
        Token EOF4=null;

        CommonTree Ws1_tree=null;
        CommonTree Comment2_tree=null;
        CommonTree LineBreak3_tree=null;
        CommonTree EOF4_tree=null;
        RewriteRuleTokenStream stream_LineBreak=new RewriteRuleTokenStream(adaptor,"token LineBreak");
        RewriteRuleTokenStream stream_Ws=new RewriteRuleTokenStream(adaptor,"token Ws");
        RewriteRuleTokenStream stream_Comment=new RewriteRuleTokenStream(adaptor,"token Comment");
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:43:2: ( ( ( Ws | Comment ) ( LineBreak )? )* EOF -> ^( IMPEX ^( COMMENTS ( Comment )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:43:4: ( ( Ws | Comment ) ( LineBreak )? )* EOF
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:43:4: ( ( Ws | Comment ) ( LineBreak )? )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==Comment||LA3_0==Ws) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:43:5: ( Ws | Comment ) ( LineBreak )?
            	    {
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:43:5: ( Ws | Comment )
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==Ws) ) {
            	        alt1=1;
            	    }
            	    else if ( (LA1_0==Comment) ) {
            	        alt1=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 1, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:43:6: Ws
            	            {
            	            Ws1=(Token)match(input,Ws,FOLLOW_Ws_in_impex141);  
            	            stream_Ws.add(Ws1);


            	            }
            	            break;
            	        case 2 :
            	            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:43:11: Comment
            	            {
            	            Comment2=(Token)match(input,Comment,FOLLOW_Comment_in_impex145);  
            	            stream_Comment.add(Comment2);


            	            }
            	            break;

            	    }


            	    // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:43:21: ( LineBreak )?
            	    int alt2=2;
            	    int LA2_0 = input.LA(1);

            	    if ( (LA2_0==LineBreak) ) {
            	        alt2=1;
            	    }
            	    switch (alt2) {
            	        case 1 :
            	            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:43:21: LineBreak
            	            {
            	            LineBreak3=(Token)match(input,LineBreak,FOLLOW_LineBreak_in_impex149);  
            	            stream_LineBreak.add(LineBreak3);


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
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
            // 43:38: -> ^( IMPEX ^( COMMENTS ( Comment )* ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:43:41: ^( IMPEX ^( COMMENTS ( Comment )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IMPEX, "IMPEX")
                , root_1);

                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:43:50: ^( COMMENTS ( Comment )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(COMMENTS, "COMMENTS")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:43:61: ( Comment )*
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:47:1: macroAssignement : MacroDefinition Equals MacroExpression -> ^( ASSIGNEMENT MacroDefinition MacroExpression ) ;
    public final impexParser.macroAssignement_return macroAssignement() throws RecognitionException {
        impexParser.macroAssignement_return retval = new impexParser.macroAssignement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token MacroDefinition5=null;
        Token Equals6=null;
        Token MacroExpression7=null;

        CommonTree MacroDefinition5_tree=null;
        CommonTree Equals6_tree=null;
        CommonTree MacroExpression7_tree=null;
        RewriteRuleTokenStream stream_MacroDefinition=new RewriteRuleTokenStream(adaptor,"token MacroDefinition");
        RewriteRuleTokenStream stream_Equals=new RewriteRuleTokenStream(adaptor,"token Equals");
        RewriteRuleTokenStream stream_MacroExpression=new RewriteRuleTokenStream(adaptor,"token MacroExpression");

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:48:2: ( MacroDefinition Equals MacroExpression -> ^( ASSIGNEMENT MacroDefinition MacroExpression ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:48:4: MacroDefinition Equals MacroExpression
            {
            MacroDefinition5=(Token)match(input,MacroDefinition,FOLLOW_MacroDefinition_in_macroAssignement180);  
            stream_MacroDefinition.add(MacroDefinition5);


            Equals6=(Token)match(input,Equals,FOLLOW_Equals_in_macroAssignement182);  
            stream_Equals.add(Equals6);


            MacroExpression7=(Token)match(input,MacroExpression,FOLLOW_MacroExpression_in_macroAssignement184);  
            stream_MacroExpression.add(MacroExpression7);


            // AST REWRITE
            // elements: MacroExpression, MacroDefinition
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 48:44: -> ^( ASSIGNEMENT MacroDefinition MacroExpression )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:48:47: ^( ASSIGNEMENT MacroDefinition MacroExpression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ASSIGNEMENT, "ASSIGNEMENT")
                , root_1);

                adaptor.addChild(root_1, 
                stream_MacroDefinition.nextNode()
                );

                adaptor.addChild(root_1, 
                stream_MacroExpression.nextNode()
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


 

    public static final BitSet FOLLOW_Ws_in_impex141 = new BitSet(new long[]{0x0020000400008000L});
    public static final BitSet FOLLOW_Comment_in_impex145 = new BitSet(new long[]{0x0020000400008000L});
    public static final BitSet FOLLOW_LineBreak_in_impex149 = new BitSet(new long[]{0x0020000000008000L});
    public static final BitSet FOLLOW_EOF_in_impex154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MacroDefinition_in_macroAssignement180 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_Equals_in_macroAssignement182 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_MacroExpression_in_macroAssignement184 = new BitSet(new long[]{0x0000000000000002L});

}