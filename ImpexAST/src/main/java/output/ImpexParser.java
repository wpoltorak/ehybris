// $ANTLR 3.4 /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g 2012-10-28 21:29:10

  package output;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class ImpexParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGNEMENT", "ASSIGNEMENTS", "ATTRIBUTES", "Alias", "AllowNull", "BatchMode", "Bool", "COMMENTS", "COMPLEX_ATTRIBUTE", "CacheUnique", "CellDecorator", "Char", "CollectionDelimiter", "Comma", "Comment", "Dateformat", "Default", "DoubleQuote", "Equals", "ForceWrite", "HEADER", "HEADER_PREFIX", "HEADER_TYPE", "IMPEX", "IMPEX_BLOCK", "IMPEX_BLOCKS", "Identifier", "IgnoreKeyCase", "IgnoreNull", "Insert", "InsertUpdate", "KeyToValueDelimiter", "Lang", "Lb", "LeftBracket", "LeftParenthesis", "LineContinuation", "Macrodef", "Macroval", "MapDelimiter", "Mode", "Numberformat", "PathDelimiter", "Pos", "Processor", "ROW", "ROWS", "Remove", "RightBracket", "RightParenthesis", "SIMPLE_ATTRIBUTE", "Semicolon", "Translator", "Unique", "Update", "Virtual", "Ws"
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
    public static final int Lb=37;
    public static final int LeftBracket=38;
    public static final int LeftParenthesis=39;
    public static final int LineContinuation=40;
    public static final int Macrodef=41;
    public static final int Macroval=42;
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:71:1: parse : (t= . )* EOF ;
    public final ImpexParser.parse_return parse() throws RecognitionException {
        ImpexParser.parse_return retval = new ImpexParser.parse_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token t=null;
        Token EOF1=null;

        CommonTree t_tree=null;
        CommonTree EOF1_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:72:3: ( (t= . )* EOF )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:72:6: (t= . )* EOF
            {
            root_0 = (CommonTree)adaptor.nil();


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:72:6: (t= . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= ASSIGNEMENT && LA1_0 <= Ws)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:72:7: t= .
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:75:1: impex : ( record | macro | Comment )* EOF -> ^( IMPEX ^( COMMENTS ( Comment )* ) ^( ASSIGNEMENTS ( macro )* ) ) ;
    public final ImpexParser.impex_return impex() throws RecognitionException {
        ImpexParser.impex_return retval = new ImpexParser.impex_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Comment4=null;
        Token EOF5=null;
        ImpexParser.record_return record2 =null;

        ImpexParser.macro_return macro3 =null;


        CommonTree Comment4_tree=null;
        CommonTree EOF5_tree=null;
        RewriteRuleTokenStream stream_Comment=new RewriteRuleTokenStream(adaptor,"token Comment");
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_record=new RewriteRuleSubtreeStream(adaptor,"rule record");
        RewriteRuleSubtreeStream stream_macro=new RewriteRuleSubtreeStream(adaptor,"rule macro");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:75:7: ( ( record | macro | Comment )* EOF -> ^( IMPEX ^( COMMENTS ( Comment )* ) ^( ASSIGNEMENTS ( macro )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:75:9: ( record | macro | Comment )* EOF
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:75:9: ( record | macro | Comment )*
            loop2:
            do {
                int alt2=4;
                switch ( input.LA(1) ) {
                case Char:
                case DoubleQuote:
                case Lb:
                case LineContinuation:
                case Semicolon:
                    {
                    alt2=1;
                    }
                    break;
                case Macrodef:
                    {
                    alt2=2;
                    }
                    break;
                case Comment:
                    {
                    alt2=3;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:76:2: record
            	    {
            	    pushFollow(FOLLOW_record_in_impex175);
            	    record2=record();

            	    state._fsp--;

            	    stream_record.add(record2.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:78:2: macro
            	    {
            	    pushFollow(FOLLOW_macro_in_impex183);
            	    macro3=macro();

            	    state._fsp--;

            	    stream_macro.add(macro3.getTree());

            	    System.out.printf("macro    :: '%s'\n", (macro3!=null?input.toString(macro3.start,macro3.stop):null));

            	    }
            	    break;
            	case 3 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:81:2: Comment
            	    {
            	    Comment4=(Token)match(input,Comment,FOLLOW_Comment_in_impex193);  
            	    stream_Comment.add(Comment4);


            	    System.out.printf("Comment    :: '%s'\n", (Comment4!=null?Comment4.getText():null));

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            EOF5=(Token)match(input,EOF,FOLLOW_EOF_in_impex203);  
            stream_EOF.add(EOF5);


            // AST REWRITE
            // elements: macro, Comment
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 85:3: -> ^( IMPEX ^( COMMENTS ( Comment )* ) ^( ASSIGNEMENTS ( macro )* ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:85:6: ^( IMPEX ^( COMMENTS ( Comment )* ) ^( ASSIGNEMENTS ( macro )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IMPEX, "IMPEX")
                , root_1);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:85:15: ^( COMMENTS ( Comment )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(COMMENTS, "COMMENTS")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:85:26: ( Comment )*
                while ( stream_Comment.hasNext() ) {
                    adaptor.addChild(root_2, 
                    stream_Comment.nextNode()
                    );

                }
                stream_Comment.reset();

                adaptor.addChild(root_1, root_2);
                }

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:85:36: ^( ASSIGNEMENTS ( macro )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ASSIGNEMENTS, "ASSIGNEMENTS")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:85:51: ( macro )*
                while ( stream_macro.hasNext() ) {
                    adaptor.addChild(root_2, stream_macro.nextTree());

                }
                stream_macro.reset();

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


    public static class record_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "record"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:88:1: record : ( quoted_field | field ) ( Semicolon ( quoted_field | field ) )* ( Lb | ( LineContinuation record ) ) -> ^( ROW ( quoted_field )* ( field )* ) ;
    public final ImpexParser.record_return record() throws RecognitionException {
        ImpexParser.record_return retval = new ImpexParser.record_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Semicolon8=null;
        Token Lb11=null;
        Token LineContinuation12=null;
        ImpexParser.quoted_field_return quoted_field6 =null;

        ImpexParser.field_return field7 =null;

        ImpexParser.quoted_field_return quoted_field9 =null;

        ImpexParser.field_return field10 =null;

        ImpexParser.record_return record13 =null;


        CommonTree Semicolon8_tree=null;
        CommonTree Lb11_tree=null;
        CommonTree LineContinuation12_tree=null;
        RewriteRuleTokenStream stream_LineContinuation=new RewriteRuleTokenStream(adaptor,"token LineContinuation");
        RewriteRuleTokenStream stream_Semicolon=new RewriteRuleTokenStream(adaptor,"token Semicolon");
        RewriteRuleTokenStream stream_Lb=new RewriteRuleTokenStream(adaptor,"token Lb");
        RewriteRuleSubtreeStream stream_field=new RewriteRuleSubtreeStream(adaptor,"rule field");
        RewriteRuleSubtreeStream stream_record=new RewriteRuleSubtreeStream(adaptor,"rule record");
        RewriteRuleSubtreeStream stream_quoted_field=new RewriteRuleSubtreeStream(adaptor,"rule quoted_field");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:89:5: ( ( quoted_field | field ) ( Semicolon ( quoted_field | field ) )* ( Lb | ( LineContinuation record ) ) -> ^( ROW ( quoted_field )* ( field )* ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:89:6: ( quoted_field | field ) ( Semicolon ( quoted_field | field ) )* ( Lb | ( LineContinuation record ) )
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:89:6: ( quoted_field | field )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==DoubleQuote) ) {
                alt3=1;
            }
            else if ( (LA3_0==Char||LA3_0==Lb||LA3_0==LineContinuation||LA3_0==Semicolon) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:89:7: quoted_field
                    {
                    pushFollow(FOLLOW_quoted_field_in_record241);
                    quoted_field6=quoted_field();

                    state._fsp--;

                    stream_quoted_field.add(quoted_field6.getTree());

                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:89:22: field
                    {
                    pushFollow(FOLLOW_field_in_record245);
                    field7=field();

                    state._fsp--;

                    stream_field.add(field7.getTree());

                    }
                    break;

            }


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:89:29: ( Semicolon ( quoted_field | field ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==Semicolon) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:89:30: Semicolon ( quoted_field | field )
            	    {
            	    Semicolon8=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_record249);  
            	    stream_Semicolon.add(Semicolon8);


            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:89:40: ( quoted_field | field )
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0==DoubleQuote) ) {
            	        alt4=1;
            	    }
            	    else if ( (LA4_0==Char||LA4_0==Lb||LA4_0==LineContinuation||LA4_0==Semicolon) ) {
            	        alt4=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 4, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:89:41: quoted_field
            	            {
            	            pushFollow(FOLLOW_quoted_field_in_record252);
            	            quoted_field9=quoted_field();

            	            state._fsp--;

            	            stream_quoted_field.add(quoted_field9.getTree());

            	            }
            	            break;
            	        case 2 :
            	            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:89:56: field
            	            {
            	            pushFollow(FOLLOW_field_in_record256);
            	            field10=field();

            	            state._fsp--;

            	            stream_field.add(field10.getTree());

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:89:65: ( Lb | ( LineContinuation record ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==Lb) ) {
                alt6=1;
            }
            else if ( (LA6_0==LineContinuation) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:89:67: Lb
                    {
                    Lb11=(Token)match(input,Lb,FOLLOW_Lb_in_record263);  
                    stream_Lb.add(Lb11);


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:89:72: ( LineContinuation record )
                    {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:89:72: ( LineContinuation record )
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:89:73: LineContinuation record
                    {
                    LineContinuation12=(Token)match(input,LineContinuation,FOLLOW_LineContinuation_in_record268);  
                    stream_LineContinuation.add(LineContinuation12);


                    newLine();

                    pushFollow(FOLLOW_record_in_record272);
                    record13=record();

                    state._fsp--;

                    stream_record.add(record13.getTree());

                    }


                    }
                    break;

            }


            // AST REWRITE
            // elements: quoted_field, field
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 91:6: -> ^( ROW ( quoted_field )* ( field )* )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:91:9: ^( ROW ( quoted_field )* ( field )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ROW, "ROW")
                , root_1);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:91:15: ( quoted_field )*
                while ( stream_quoted_field.hasNext() ) {
                    adaptor.addChild(root_1, stream_quoted_field.nextTree());

                }
                stream_quoted_field.reset();

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:91:29: ( field )*
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
    // $ANTLR end "record"


    public static class macro_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "macro"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:93:1: macro : Macrodef Macroval -> ^( ASSIGNEMENT Macrodef Macroval ) ;
    public final ImpexParser.macro_return macro() throws RecognitionException {
        ImpexParser.macro_return retval = new ImpexParser.macro_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Macrodef14=null;
        Token Macroval15=null;

        CommonTree Macrodef14_tree=null;
        CommonTree Macroval15_tree=null;
        RewriteRuleTokenStream stream_Macroval=new RewriteRuleTokenStream(adaptor,"token Macroval");
        RewriteRuleTokenStream stream_Macrodef=new RewriteRuleTokenStream(adaptor,"token Macrodef");

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:94:2: ( Macrodef Macroval -> ^( ASSIGNEMENT Macrodef Macroval ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:94:3: Macrodef Macroval
            {
            Macrodef14=(Token)match(input,Macrodef,FOLLOW_Macrodef_in_macro300);  
            stream_Macrodef.add(Macrodef14);


            Macroval15=(Token)match(input,Macroval,FOLLOW_Macroval_in_macro302);  
            stream_Macroval.add(Macroval15);


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
            // 95:2: -> ^( ASSIGNEMENT Macrodef Macroval )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:95:5: ^( ASSIGNEMENT Macrodef Macroval )
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


    public static class quoted_field_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "quoted_field"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:97:1: quoted_field : DoubleQuote ( Char | DoubleQuote DoubleQuote | Semicolon )* DoubleQuote ;
    public final ImpexParser.quoted_field_return quoted_field() throws RecognitionException {
        ImpexParser.quoted_field_return retval = new ImpexParser.quoted_field_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token DoubleQuote16=null;
        Token Char17=null;
        Token DoubleQuote18=null;
        Token DoubleQuote19=null;
        Token Semicolon20=null;
        Token DoubleQuote21=null;

        CommonTree DoubleQuote16_tree=null;
        CommonTree Char17_tree=null;
        CommonTree DoubleQuote18_tree=null;
        CommonTree DoubleQuote19_tree=null;
        CommonTree Semicolon20_tree=null;
        CommonTree DoubleQuote21_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:98:2: ( DoubleQuote ( Char | DoubleQuote DoubleQuote | Semicolon )* DoubleQuote )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:98:3: DoubleQuote ( Char | DoubleQuote DoubleQuote | Semicolon )* DoubleQuote
            {
            root_0 = (CommonTree)adaptor.nil();


            DoubleQuote16=(Token)match(input,DoubleQuote,FOLLOW_DoubleQuote_in_quoted_field323); 
            DoubleQuote16_tree = 
            (CommonTree)adaptor.create(DoubleQuote16)
            ;
            adaptor.addChild(root_0, DoubleQuote16_tree);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:98:15: ( Char | DoubleQuote DoubleQuote | Semicolon )*
            loop7:
            do {
                int alt7=4;
                switch ( input.LA(1) ) {
                case DoubleQuote:
                    {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1==DoubleQuote) ) {
                        alt7=2;
                    }


                    }
                    break;
                case Char:
                    {
                    alt7=1;
                    }
                    break;
                case Semicolon:
                    {
                    alt7=3;
                    }
                    break;

                }

                switch (alt7) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:98:16: Char
            	    {
            	    Char17=(Token)match(input,Char,FOLLOW_Char_in_quoted_field326); 
            	    Char17_tree = 
            	    (CommonTree)adaptor.create(Char17)
            	    ;
            	    adaptor.addChild(root_0, Char17_tree);


            	    }
            	    break;
            	case 2 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:98:23: DoubleQuote DoubleQuote
            	    {
            	    DoubleQuote18=(Token)match(input,DoubleQuote,FOLLOW_DoubleQuote_in_quoted_field330); 
            	    DoubleQuote18_tree = 
            	    (CommonTree)adaptor.create(DoubleQuote18)
            	    ;
            	    adaptor.addChild(root_0, DoubleQuote18_tree);


            	    DoubleQuote19=(Token)match(input,DoubleQuote,FOLLOW_DoubleQuote_in_quoted_field332); 
            	    DoubleQuote19_tree = 
            	    (CommonTree)adaptor.create(DoubleQuote19)
            	    ;
            	    adaptor.addChild(root_0, DoubleQuote19_tree);


            	    }
            	    break;
            	case 3 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:98:49: Semicolon
            	    {
            	    Semicolon20=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_quoted_field336); 
            	    Semicolon20_tree = 
            	    (CommonTree)adaptor.create(Semicolon20)
            	    ;
            	    adaptor.addChild(root_0, Semicolon20_tree);


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);


            DoubleQuote21=(Token)match(input,DoubleQuote,FOLLOW_DoubleQuote_in_quoted_field341); 
            DoubleQuote21_tree = 
            (CommonTree)adaptor.create(DoubleQuote21)
            ;
            adaptor.addChild(root_0, DoubleQuote21_tree);


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
    // $ANTLR end "quoted_field"


    public static class field_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:100:1: field : ( Char )* ;
    public final ImpexParser.field_return field() throws RecognitionException {
        ImpexParser.field_return retval = new ImpexParser.field_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Char22=null;

        CommonTree Char22_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:101:2: ( ( Char )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:101:3: ( Char )*
            {
            root_0 = (CommonTree)adaptor.nil();


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:101:3: ( Char )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==Char) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:101:3: Char
            	    {
            	    Char22=(Token)match(input,Char,FOLLOW_Char_in_field351); 
            	    Char22_tree = 
            	    (CommonTree)adaptor.create(Char22)
            	    ;
            	    adaptor.addChild(root_0, Char22_tree);


            	    }
            	    break;

            	default :
            	    break loop8;
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


    public static class header_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "header"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:112:1: header : ( Insert | InsertUpdate | Update | Remove ) Identifier ( LeftBracket ( BatchMode | CacheUnique | Processor ) RightBracket )? Semicolon ;
    public final ImpexParser.header_return header() throws RecognitionException {
        ImpexParser.header_return retval = new ImpexParser.header_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set23=null;
        Token Identifier24=null;
        Token LeftBracket25=null;
        Token set26=null;
        Token RightBracket27=null;
        Token Semicolon28=null;

        CommonTree set23_tree=null;
        CommonTree Identifier24_tree=null;
        CommonTree LeftBracket25_tree=null;
        CommonTree set26_tree=null;
        CommonTree RightBracket27_tree=null;
        CommonTree Semicolon28_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:113:2: ( ( Insert | InsertUpdate | Update | Remove ) Identifier ( LeftBracket ( BatchMode | CacheUnique | Processor ) RightBracket )? Semicolon )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:113:4: ( Insert | InsertUpdate | Update | Remove ) Identifier ( LeftBracket ( BatchMode | CacheUnique | Processor ) RightBracket )? Semicolon
            {
            root_0 = (CommonTree)adaptor.nil();


            set23=(Token)input.LT(1);

            if ( (input.LA(1) >= Insert && input.LA(1) <= InsertUpdate)||input.LA(1)==Remove||input.LA(1)==Update ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set23)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            Identifier24=(Token)match(input,Identifier,FOLLOW_Identifier_in_header388); 
            Identifier24_tree = 
            (CommonTree)adaptor.create(Identifier24)
            ;
            adaptor.addChild(root_0, Identifier24_tree);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:113:58: ( LeftBracket ( BatchMode | CacheUnique | Processor ) RightBracket )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==LeftBracket) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:113:59: LeftBracket ( BatchMode | CacheUnique | Processor ) RightBracket
                    {
                    LeftBracket25=(Token)match(input,LeftBracket,FOLLOW_LeftBracket_in_header391); 
                    LeftBracket25_tree = 
                    (CommonTree)adaptor.create(LeftBracket25)
                    ;
                    adaptor.addChild(root_0, LeftBracket25_tree);


                    set26=(Token)input.LT(1);

                    if ( input.LA(1)==BatchMode||input.LA(1)==CacheUnique||input.LA(1)==Processor ) {
                        input.consume();
                        adaptor.addChild(root_0, 
                        (CommonTree)adaptor.create(set26)
                        );
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }


                    RightBracket27=(Token)match(input,RightBracket,FOLLOW_RightBracket_in_header405); 
                    RightBracket27_tree = 
                    (CommonTree)adaptor.create(RightBracket27)
                    ;
                    adaptor.addChild(root_0, RightBracket27_tree);


                    }
                    break;

            }


            Semicolon28=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_header409); 
            Semicolon28_tree = 
            (CommonTree)adaptor.create(Semicolon28)
            ;
            adaptor.addChild(root_0, Semicolon28_tree);


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

    // Delegated rules


 

    public static final BitSet FOLLOW_EOF_in_parse157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_record_in_impex175 = new BitSet(new long[]{0x0080032000248000L});
    public static final BitSet FOLLOW_macro_in_impex183 = new BitSet(new long[]{0x0080032000248000L});
    public static final BitSet FOLLOW_Comment_in_impex193 = new BitSet(new long[]{0x0080032000248000L});
    public static final BitSet FOLLOW_EOF_in_impex203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_quoted_field_in_record241 = new BitSet(new long[]{0x0080012000000000L});
    public static final BitSet FOLLOW_field_in_record245 = new BitSet(new long[]{0x0080012000000000L});
    public static final BitSet FOLLOW_Semicolon_in_record249 = new BitSet(new long[]{0x0080012000208000L});
    public static final BitSet FOLLOW_quoted_field_in_record252 = new BitSet(new long[]{0x0080012000000000L});
    public static final BitSet FOLLOW_field_in_record256 = new BitSet(new long[]{0x0080012000000000L});
    public static final BitSet FOLLOW_Lb_in_record263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LineContinuation_in_record268 = new BitSet(new long[]{0x0080012000208000L});
    public static final BitSet FOLLOW_record_in_record272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Macrodef_in_macro300 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_Macroval_in_macro302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DoubleQuote_in_quoted_field323 = new BitSet(new long[]{0x0080000000208000L});
    public static final BitSet FOLLOW_Char_in_quoted_field326 = new BitSet(new long[]{0x0080000000208000L});
    public static final BitSet FOLLOW_DoubleQuote_in_quoted_field330 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_DoubleQuote_in_quoted_field332 = new BitSet(new long[]{0x0080000000208000L});
    public static final BitSet FOLLOW_Semicolon_in_quoted_field336 = new BitSet(new long[]{0x0080000000208000L});
    public static final BitSet FOLLOW_DoubleQuote_in_quoted_field341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Char_in_field351 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_set_in_header371 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_Identifier_in_header388 = new BitSet(new long[]{0x0080004000000000L});
    public static final BitSet FOLLOW_LeftBracket_in_header391 = new BitSet(new long[]{0x0001000000002200L});
    public static final BitSet FOLLOW_set_in_header393 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_RightBracket_in_header405 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_Semicolon_in_header409 = new BitSet(new long[]{0x0000000000000002L});

}