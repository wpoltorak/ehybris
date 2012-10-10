// $ANTLR 3.4 /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g 2012-10-09 22:23:50

  package output;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class ImpexParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGNEMENT", "ASSIGNEMENTS", "ATTRIBUTES", "Alias", "AllowNull", "BatchMode", "Bool", "COMMENTS", "COMPLEX_ATTRIBUTE", "CacheUnique", "CellDecorator", "Char", "CollectionDelimiter", "Comma", "Comment", "Dateformat", "Default", "DoubleQuote", "Equals", "ForceWrite", "HEADER", "HEADER_PREFIX", "HEADER_TYPE", "IMPEX", "IMPEX_BLOCK", "IMPEX_BLOCKS", "Identifier", "IgnoreKeyCase", "IgnoreNull", "Insert", "InsertUpdate", "KeyToValueDelimiter", "Lang", "LeftBracket", "LeftParenthesis", "LineBreak", "LineContinuation", "MACRO", "Macrodef", "MapDelimiter", "Mode", "Numberformat", "PathDelimiter", "Pos", "Processor", "ROW", "ROWS", "Remove", "RightBracket", "RightParenthesis", "SIMPLE_ATTRIBUTE", "Semicolon", "Translator", "Unique", "Update", "Virtual", "Ws"
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
    public static final int Char=15;
    public static final int CollectionDelimiter=16;
    public static final int Comma=17;
    public static final int Comment=18;
    public static final int Dateformat=19;
    public static final int Default=20;
    public static final int DoubleQuote=21;
    public static final int Equals=22;
    public static final int ForceWrite=23;
    public static final int HEADER=24;
    public static final int HEADER_PREFIX=25;
    public static final int HEADER_TYPE=26;
    public static final int IMPEX=27;
    public static final int IMPEX_BLOCK=28;
    public static final int IMPEX_BLOCKS=29;
    public static final int Identifier=30;
    public static final int IgnoreKeyCase=31;
    public static final int IgnoreNull=32;
    public static final int Insert=33;
    public static final int InsertUpdate=34;
    public static final int KeyToValueDelimiter=35;
    public static final int Lang=36;
    public static final int LeftBracket=37;
    public static final int LeftParenthesis=38;
    public static final int LineBreak=39;
    public static final int LineContinuation=40;
    public static final int MACRO=41;
    public static final int Macrodef=42;
    public static final int MapDelimiter=43;
    public static final int Mode=44;
    public static final int Numberformat=45;
    public static final int PathDelimiter=46;
    public static final int Pos=47;
    public static final int Processor=48;
    public static final int ROW=49;
    public static final int ROWS=50;
    public static final int Remove=51;
    public static final int RightBracket=52;
    public static final int RightParenthesis=53;
    public static final int SIMPLE_ATTRIBUTE=54;
    public static final int Semicolon=55;
    public static final int Translator=56;
    public static final int Unique=57;
    public static final int Update=58;
    public static final int Virtual=59;
    public static final int Ws=60;

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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:49:1: parse : (t= . )* EOF ;
    public final ImpexParser.parse_return parse() throws RecognitionException {
        ImpexParser.parse_return retval = new ImpexParser.parse_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token t=null;
        Token EOF1=null;

        CommonTree t_tree=null;
        CommonTree EOF1_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:50:3: ( (t= . )* EOF )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:50:6: (t= . )* EOF
            {
            root_0 = (CommonTree)adaptor.nil();


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:50:6: (t= . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= ASSIGNEMENT && LA1_0 <= Ws)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:50:7: t= .
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:53:1: impex : ( macro | Comment | Ws | LineBreak )* EOF -> ^( IMPEX ^( COMMENTS ( Comment )* ) ) ;
    public final ImpexParser.impex_return impex() throws RecognitionException {
        ImpexParser.impex_return retval = new ImpexParser.impex_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Comment3=null;
        Token Ws4=null;
        Token LineBreak5=null;
        Token EOF6=null;
        ImpexParser.macro_return macro2 =null;


        CommonTree Comment3_tree=null;
        CommonTree Ws4_tree=null;
        CommonTree LineBreak5_tree=null;
        CommonTree EOF6_tree=null;
        RewriteRuleTokenStream stream_LineBreak=new RewriteRuleTokenStream(adaptor,"token LineBreak");
        RewriteRuleTokenStream stream_Ws=new RewriteRuleTokenStream(adaptor,"token Ws");
        RewriteRuleTokenStream stream_Comment=new RewriteRuleTokenStream(adaptor,"token Comment");
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_macro=new RewriteRuleSubtreeStream(adaptor,"rule macro");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:53:7: ( ( macro | Comment | Ws | LineBreak )* EOF -> ^( IMPEX ^( COMMENTS ( Comment )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:55:2: ( macro | Comment | Ws | LineBreak )* EOF
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:55:2: ( macro | Comment | Ws | LineBreak )*
            loop2:
            do {
                int alt2=5;
                switch ( input.LA(1) ) {
                case Macrodef:
                    {
                    alt2=1;
                    }
                    break;
                case Comment:
                    {
                    alt2=2;
                    }
                    break;
                case Ws:
                    {
                    alt2=3;
                    }
                    break;
                case LineBreak:
                    {
                    alt2=4;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:55:4: macro
            	    {
            	    pushFollow(FOLLOW_macro_in_impex174);
            	    macro2=macro();

            	    state._fsp--;

            	    stream_macro.add(macro2.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:56:4: Comment
            	    {
            	    Comment3=(Token)match(input,Comment,FOLLOW_Comment_in_impex179);  
            	    stream_Comment.add(Comment3);


            	    System.out.printf("Comment    :: '%s'\n", (Comment3!=null?Comment3.getText():null));

            	    }
            	    break;
            	case 3 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:57:4: Ws
            	    {
            	    Ws4=(Token)match(input,Ws,FOLLOW_Ws_in_impex186);  
            	    stream_Ws.add(Ws4);


            	    System.out.printf("Ws    :: '%s'\n", (Ws4!=null?Ws4.getText():null));

            	    }
            	    break;
            	case 4 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:58:4: LineBreak
            	    {
            	    LineBreak5=(Token)match(input,LineBreak,FOLLOW_LineBreak_in_impex193);  
            	    stream_LineBreak.add(LineBreak5);


            	    System.out.printf("LineBreak    :: '%s'\n", (LineBreak5!=null?LineBreak5.getText():null));

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            EOF6=(Token)match(input,EOF,FOLLOW_EOF_in_impex202);  
            stream_EOF.add(EOF6);


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
            // 60:9: -> ^( IMPEX ^( COMMENTS ( Comment )* ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:60:12: ^( IMPEX ^( COMMENTS ( Comment )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IMPEX, "IMPEX")
                , root_1);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:60:21: ^( COMMENTS ( Comment )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(COMMENTS, "COMMENTS")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:60:32: ( Comment )*
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


    public static class macro_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "macro"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:64:1: macro : Macrodef Equals ( field | Identifier ) ;
    public final ImpexParser.macro_return macro() throws RecognitionException {
        ImpexParser.macro_return retval = new ImpexParser.macro_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Macrodef7=null;
        Token Equals8=null;
        Token Identifier10=null;
        ImpexParser.field_return field9 =null;


        CommonTree Macrodef7_tree=null;
        CommonTree Equals8_tree=null;
        CommonTree Identifier10_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:65:2: ( Macrodef Equals ( field | Identifier ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:66:2: Macrodef Equals ( field | Identifier )
            {
            root_0 = (CommonTree)adaptor.nil();


            Macrodef7=(Token)match(input,Macrodef,FOLLOW_Macrodef_in_macro230); 
            Macrodef7_tree = 
            (CommonTree)adaptor.create(Macrodef7)
            ;
            adaptor.addChild(root_0, Macrodef7_tree);


            Equals8=(Token)match(input,Equals,FOLLOW_Equals_in_macro234); 
            Equals8_tree = 
            (CommonTree)adaptor.create(Equals8)
            ;
            adaptor.addChild(root_0, Equals8_tree);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:68:2: ( field | Identifier )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==EOF||LA3_0==Char||LA3_0==Comment||LA3_0==LineBreak||LA3_0==Macrodef||LA3_0==Ws) ) {
                alt3=1;
            }
            else if ( (LA3_0==Identifier) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:68:3: field
                    {
                    pushFollow(FOLLOW_field_in_macro238);
                    field9=field();

                    state._fsp--;

                    adaptor.addChild(root_0, field9.getTree());

                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:68:11: Identifier
                    {
                    Identifier10=(Token)match(input,Identifier,FOLLOW_Identifier_in_macro242); 
                    Identifier10_tree = 
                    (CommonTree)adaptor.create(Identifier10)
                    ;
                    adaptor.addChild(root_0, Identifier10_tree);


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
    // $ANTLR end "macro"


    public static class field_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:89:1: field : ( Char )* ;
    public final ImpexParser.field_return field() throws RecognitionException {
        ImpexParser.field_return retval = new ImpexParser.field_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Char11=null;

        CommonTree Char11_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:91:2: ( ( Char )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:91:3: ( Char )*
            {
            root_0 = (CommonTree)adaptor.nil();


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:91:3: ( Char )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==Char) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:91:3: Char
            	    {
            	    Char11=(Token)match(input,Char,FOLLOW_Char_in_field283); 
            	    Char11_tree = 
            	    (CommonTree)adaptor.create(Char11)
            	    ;
            	    adaptor.addChild(root_0, Char11_tree);


            	    }
            	    break;

            	default :
            	    break loop4;
                }
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
    // $ANTLR end "field"

    // Delegated rules


 

    public static final BitSet FOLLOW_EOF_in_parse155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_macro_in_impex174 = new BitSet(new long[]{0x1000048000040000L});
    public static final BitSet FOLLOW_Comment_in_impex179 = new BitSet(new long[]{0x1000048000040000L});
    public static final BitSet FOLLOW_Ws_in_impex186 = new BitSet(new long[]{0x1000048000040000L});
    public static final BitSet FOLLOW_LineBreak_in_impex193 = new BitSet(new long[]{0x1000048000040000L});
    public static final BitSet FOLLOW_EOF_in_impex202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Macrodef_in_macro230 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_Equals_in_macro234 = new BitSet(new long[]{0x0000000040008000L});
    public static final BitSet FOLLOW_field_in_macro238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_macro242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Char_in_field283 = new BitSet(new long[]{0x0000000000008002L});

}