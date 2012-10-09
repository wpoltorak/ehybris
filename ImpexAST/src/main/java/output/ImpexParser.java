// $ANTLR 3.4 /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g 2012-10-09 11:41:03

  package output;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class ImpexParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGNEMENT", "ASSIGNEMENTS", "ATTRIBUTES", "Alias", "AllowNull", "BatchMode", "Bool", "COMMENTS", "COMPLEX_ATTRIBUTE", "CacheUnique", "CellDecorator", "CollectionDelimiter", "Comma", "Comment", "Dateformat", "Default", "Equals", "ForceWrite", "HEADER", "HEADER_PREFIX", "HEADER_TYPE", "IMPEX", "IMPEX_BLOCK", "IMPEX_BLOCKS", "Identifier", "IgnoreKeyCase", "IgnoreNull", "Insert", "InsertUpdate", "KeyToValueDelimiter", "Lang", "LeftBracket", "LeftParenthesis", "LineBreak", "LineContinuation", "MACRO", "Macrodef", "MapDelimiter", "Mode", "Numberformat", "PathDelimiter", "Pos", "Processor", "ROW", "ROWS", "Remove", "RightBracket", "RightParenthesis", "SIMPLE_ATTRIBUTE", "Semicolon", "Text", "Translator", "Unique", "Update", "Virtual", "Ws"
    };

    public static final int EOF=-1;
    public static final int ASSIGNEMENT=4;
    public static final int ASSIGNEMENTS=5;
    public static final int ATTRIBUTES=6;
    public static final int Alias=7;
    public static final int AllowNull=8;
    public static final int BatchMode=9;
    public static final int Bool=10;
    public static final int COMMENTS=11;
    public static final int COMPLEX_ATTRIBUTE=12;
    public static final int CacheUnique=13;
    public static final int CellDecorator=14;
    public static final int CollectionDelimiter=15;
    public static final int Comma=16;
    public static final int Comment=17;
    public static final int Dateformat=18;
    public static final int Default=19;
    public static final int Equals=20;
    public static final int ForceWrite=21;
    public static final int HEADER=22;
    public static final int HEADER_PREFIX=23;
    public static final int HEADER_TYPE=24;
    public static final int IMPEX=25;
    public static final int IMPEX_BLOCK=26;
    public static final int IMPEX_BLOCKS=27;
    public static final int Identifier=28;
    public static final int IgnoreKeyCase=29;
    public static final int IgnoreNull=30;
    public static final int Insert=31;
    public static final int InsertUpdate=32;
    public static final int KeyToValueDelimiter=33;
    public static final int Lang=34;
    public static final int LeftBracket=35;
    public static final int LeftParenthesis=36;
    public static final int LineBreak=37;
    public static final int LineContinuation=38;
    public static final int MACRO=39;
    public static final int Macrodef=40;
    public static final int MapDelimiter=41;
    public static final int Mode=42;
    public static final int Numberformat=43;
    public static final int PathDelimiter=44;
    public static final int Pos=45;
    public static final int Processor=46;
    public static final int ROW=47;
    public static final int ROWS=48;
    public static final int Remove=49;
    public static final int RightBracket=50;
    public static final int RightParenthesis=51;
    public static final int SIMPLE_ATTRIBUTE=52;
    public static final int Semicolon=53;
    public static final int Text=54;
    public static final int Translator=55;
    public static final int Unique=56;
    public static final int Update=57;
    public static final int Virtual=58;
    public static final int Ws=59;

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
    public String getGrammarFileName() { return "/home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g"; }


    public static class parse_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parse"
    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:49:1: parse : (t= . )* EOF ;
    public final ImpexParser.parse_return parse() throws RecognitionException {
        ImpexParser.parse_return retval = new ImpexParser.parse_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token t=null;
        Token EOF1=null;

        CommonTree t_tree=null;
        CommonTree EOF1_tree=null;

        try {
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:50:3: ( (t= . )* EOF )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:50:6: (t= . )* EOF
            {
            root_0 = (CommonTree)adaptor.nil();


            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:50:6: (t= . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= ASSIGNEMENT && LA1_0 <= Ws)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:50:7: t= .
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


            EOF1=(Token)match(input,EOF,FOLLOW_EOF_in_parse155); 
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
    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:53:1: impex : ( Comment | Ws | LineBreak | macroAssignement )* EOF -> ^( IMPEX ^( COMMENTS ( Comment )* ) ^( ASSIGNEMENTS ( macroAssignement )* ) ) ;
    public final ImpexParser.impex_return impex() throws RecognitionException {
        ImpexParser.impex_return retval = new ImpexParser.impex_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Comment2=null;
        Token Ws3=null;
        Token LineBreak4=null;
        Token EOF6=null;
        ImpexParser.macroAssignement_return macroAssignement5 =null;


        CommonTree Comment2_tree=null;
        CommonTree Ws3_tree=null;
        CommonTree LineBreak4_tree=null;
        CommonTree EOF6_tree=null;
        RewriteRuleTokenStream stream_LineBreak=new RewriteRuleTokenStream(adaptor,"token LineBreak");
        RewriteRuleTokenStream stream_Ws=new RewriteRuleTokenStream(adaptor,"token Ws");
        RewriteRuleTokenStream stream_Comment=new RewriteRuleTokenStream(adaptor,"token Comment");
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_macroAssignement=new RewriteRuleSubtreeStream(adaptor,"rule macroAssignement");
        try {
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:54:2: ( ( Comment | Ws | LineBreak | macroAssignement )* EOF -> ^( IMPEX ^( COMMENTS ( Comment )* ) ^( ASSIGNEMENTS ( macroAssignement )* ) ) )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:54:4: ( Comment | Ws | LineBreak | macroAssignement )* EOF
            {
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:54:4: ( Comment | Ws | LineBreak | macroAssignement )*
            loop2:
            do {
                int alt2=5;
                switch ( input.LA(1) ) {
                case Comment:
                    {
                    alt2=1;
                    }
                    break;
                case Ws:
                    {
                    alt2=2;
                    }
                    break;
                case LineBreak:
                    {
                    alt2=3;
                    }
                    break;
                case Macrodef:
                    {
                    alt2=4;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:54:5: Comment
            	    {
            	    Comment2=(Token)match(input,Comment,FOLLOW_Comment_in_impex172);  
            	    stream_Comment.add(Comment2);


            	    System.out.printf("Comment    :: '%s'\n", (Comment2!=null?Comment2.getText():null));

            	    }
            	    break;
            	case 2 :
            	    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:55:4: Ws
            	    {
            	    Ws3=(Token)match(input,Ws,FOLLOW_Ws_in_impex179);  
            	    stream_Ws.add(Ws3);


            	    System.out.printf("Ws    :: '%s'\n", (Ws3!=null?Ws3.getText():null));

            	    }
            	    break;
            	case 3 :
            	    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:56:4: LineBreak
            	    {
            	    LineBreak4=(Token)match(input,LineBreak,FOLLOW_LineBreak_in_impex186);  
            	    stream_LineBreak.add(LineBreak4);


            	    System.out.printf("LineBreak    :: '%s'\n", (LineBreak4!=null?LineBreak4.getText():null));

            	    }
            	    break;
            	case 4 :
            	    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:57:4: macroAssignement
            	    {
            	    pushFollow(FOLLOW_macroAssignement_in_impex193);
            	    macroAssignement5=macroAssignement();

            	    state._fsp--;

            	    stream_macroAssignement.add(macroAssignement5.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            EOF6=(Token)match(input,EOF,FOLLOW_EOF_in_impex200);  
            stream_EOF.add(EOF6);


            // AST REWRITE
            // elements: Comment, macroAssignement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 59:9: -> ^( IMPEX ^( COMMENTS ( Comment )* ) ^( ASSIGNEMENTS ( macroAssignement )* ) )
            {
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:59:12: ^( IMPEX ^( COMMENTS ( Comment )* ) ^( ASSIGNEMENTS ( macroAssignement )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IMPEX, "IMPEX")
                , root_1);

                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:59:21: ^( COMMENTS ( Comment )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(COMMENTS, "COMMENTS")
                , root_2);

                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:59:32: ( Comment )*
                while ( stream_Comment.hasNext() ) {
                    adaptor.addChild(root_2, 
                    stream_Comment.nextNode()
                    );

                }
                stream_Comment.reset();

                adaptor.addChild(root_1, root_2);
                }

                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:59:42: ^( ASSIGNEMENTS ( macroAssignement )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ASSIGNEMENTS, "ASSIGNEMENTS")
                , root_2);

                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:59:57: ( macroAssignement )*
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
    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:63:1: macroAssignement : Macrodef ( Ws )* Text -> ^( ASSIGNEMENT Macrodef Text ) ;
    public final ImpexParser.macroAssignement_return macroAssignement() throws RecognitionException {
        ImpexParser.macroAssignement_return retval = new ImpexParser.macroAssignement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Macrodef7=null;
        Token Ws8=null;
        Token Text9=null;

        CommonTree Macrodef7_tree=null;
        CommonTree Ws8_tree=null;
        CommonTree Text9_tree=null;
        RewriteRuleTokenStream stream_Text=new RewriteRuleTokenStream(adaptor,"token Text");
        RewriteRuleTokenStream stream_Ws=new RewriteRuleTokenStream(adaptor,"token Ws");
        RewriteRuleTokenStream stream_Macrodef=new RewriteRuleTokenStream(adaptor,"token Macrodef");

        try {
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:64:2: ( Macrodef ( Ws )* Text -> ^( ASSIGNEMENT Macrodef Text ) )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:65:2: Macrodef ( Ws )* Text
            {
            Macrodef7=(Token)match(input,Macrodef,FOLLOW_Macrodef_in_macroAssignement234);  
            stream_Macrodef.add(Macrodef7);


            System.out.printf("Macrodef    :: '%s'\n", (Macrodef7!=null?Macrodef7.getText():null));

            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:66:2: ( Ws )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==Ws) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:66:2: Ws
            	    {
            	    Ws8=(Token)match(input,Ws,FOLLOW_Ws_in_macroAssignement239);  
            	    stream_Ws.add(Ws8);


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            Text9=(Token)match(input,Text,FOLLOW_Text_in_macroAssignement243);  
            stream_Text.add(Text9);


            System.out.printf("Macroval    :: '%s'\n", (Text9!=null?Text9.getText():null));

            // AST REWRITE
            // elements: Text, Macrodef
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 68:2: -> ^( ASSIGNEMENT Macrodef Text )
            {
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:68:5: ^( ASSIGNEMENT Macrodef Text )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ASSIGNEMENT, "ASSIGNEMENT")
                , root_1);

                adaptor.addChild(root_1, 
                stream_Macrodef.nextNode()
                );

                adaptor.addChild(root_1, 
                stream_Text.nextNode()
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


 

    public static final BitSet FOLLOW_EOF_in_parse155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Comment_in_impex172 = new BitSet(new long[]{0x0800012000020000L});
    public static final BitSet FOLLOW_Ws_in_impex179 = new BitSet(new long[]{0x0800012000020000L});
    public static final BitSet FOLLOW_LineBreak_in_impex186 = new BitSet(new long[]{0x0800012000020000L});
    public static final BitSet FOLLOW_macroAssignement_in_impex193 = new BitSet(new long[]{0x0800012000020000L});
    public static final BitSet FOLLOW_EOF_in_impex200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Macrodef_in_macroAssignement234 = new BitSet(new long[]{0x0840000000000000L});
    public static final BitSet FOLLOW_Ws_in_macroAssignement239 = new BitSet(new long[]{0x0840000000000000L});
    public static final BitSet FOLLOW_Text_in_macroAssignement243 = new BitSet(new long[]{0x0000000000000002L});

}