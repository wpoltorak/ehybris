// $ANTLR 3.4 com/lambda/impex/ast/Impex.g 2013-01-17 12:30:37

 package com.lambda.impex.ast;
  

import java.util.ArrayList;
import java.util.AbstractMap.SimpleImmutableEntry;  
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class ImpexParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTRIBUTE", "ATTRIBUTES", "ATTRIBUTE_NAME", "Alias", "AllowNull", "BLOCK", "BLOCKS", "BatchMode", "BeanShell", "Bool", "CacheUnique", "CellDecorator", "Char", "Classname", "CollectionDelimiter", "Comma", "Comment", "DOCUMENTID", "DOCUMENTID_REF", "Dateformat", "Default", "DocumentID", "Dot", "DoubleQuote", "Equals", "FIELDS", "Field", "ForceWrite", "HEADER", "IMPEX", "ITEM_EXPRESSION", "Identifier", "IgnoreKeyCase", "IgnoreNull", "Insert", "InsertUpdate", "KeyToValueDelimiter", "LBracket", "LParenthesis", "Lang", "Lb", "MACRO_REF", "MODIFIER", "MODIFIERS", "Macrodef", "MapDelimiter", "Mode", "NumberFormat", "Or", "PathDelimiter", "Pos", "Processor", "Quote", "QuotedField", "RBracket", "RECORD", "RECORDS", "RParenthesis", "Remove", "SUBTYPE", "Semicolon", "Separator", "SpecialAttribute", "TYPE", "Translator", "Unique", "Update", "UserRights", "ValueAssignment", "Virtual", "Ws"
    };

    public static final int EOF=-1;
    public static final int ATTRIBUTE=4;
    public static final int ATTRIBUTES=5;
    public static final int ATTRIBUTE_NAME=6;
    public static final int Alias=7;
    public static final int AllowNull=8;
    public static final int BLOCK=9;
    public static final int BLOCKS=10;
    public static final int BatchMode=11;
    public static final int BeanShell=12;
    public static final int Bool=13;
    public static final int CacheUnique=14;
    public static final int CellDecorator=15;
    public static final int Char=16;
    public static final int Classname=17;
    public static final int CollectionDelimiter=18;
    public static final int Comma=19;
    public static final int Comment=20;
    public static final int DOCUMENTID=21;
    public static final int DOCUMENTID_REF=22;
    public static final int Dateformat=23;
    public static final int Default=24;
    public static final int DocumentID=25;
    public static final int Dot=26;
    public static final int DoubleQuote=27;
    public static final int Equals=28;
    public static final int FIELDS=29;
    public static final int Field=30;
    public static final int ForceWrite=31;
    public static final int HEADER=32;
    public static final int IMPEX=33;
    public static final int ITEM_EXPRESSION=34;
    public static final int Identifier=35;
    public static final int IgnoreKeyCase=36;
    public static final int IgnoreNull=37;
    public static final int Insert=38;
    public static final int InsertUpdate=39;
    public static final int KeyToValueDelimiter=40;
    public static final int LBracket=41;
    public static final int LParenthesis=42;
    public static final int Lang=43;
    public static final int Lb=44;
    public static final int MACRO_REF=45;
    public static final int MODIFIER=46;
    public static final int MODIFIERS=47;
    public static final int Macrodef=48;
    public static final int MapDelimiter=49;
    public static final int Mode=50;
    public static final int NumberFormat=51;
    public static final int Or=52;
    public static final int PathDelimiter=53;
    public static final int Pos=54;
    public static final int Processor=55;
    public static final int Quote=56;
    public static final int QuotedField=57;
    public static final int RBracket=58;
    public static final int RECORD=59;
    public static final int RECORDS=60;
    public static final int RParenthesis=61;
    public static final int Remove=62;
    public static final int SUBTYPE=63;
    public static final int Semicolon=64;
    public static final int Separator=65;
    public static final int SpecialAttribute=66;
    public static final int TYPE=67;
    public static final int Translator=68;
    public static final int Unique=69;
    public static final int Update=70;
    public static final int UserRights=71;
    public static final int ValueAssignment=72;
    public static final int Virtual=73;
    public static final int Ws=74;

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
    public String getGrammarFileName() { return "com/lambda/impex/ast/Impex.g"; }



    private ImpexContext context = new ImpexContext();

    // comment out this constructor if you need to debug in ANTLRWorks
    public ImpexParser(final ImpexContext context, final TokenStream input) {
       this(input);
       this.context = context;
    }

    @Override
    public void reportError(final RecognitionException e) {
        if ( state.errorRecovery ) {
            return;
        }
        context.registerError( (CommonToken)e.token);
        super.reportError(e);
    }

        /**
         * Use the current stacked followset to work out the valid tokens that can follow on from the current point in the parse, then recover
         * by eating tokens that are not a member of the follow set we compute.
         * 
         * This method is used whenever we wish to force a sync, even though the parser has not yet checked LA(1) for alt selection. This is
         * useful in situations where only a subset of tokens can begin a new construct (such as the start of a new statement in a block) and we
         * want to proactively detect garbage so that the current rule does not exit on on an exception.
         * 
         * We could override recover() to make this the default behavior but that is too much like using a sledge hammer to crack a nut. We want
         * finer grained control of the recovery and error mechanisms.
         * 
         * @author Jim Idle
         * @see http://www.antlr.org/wiki/display/ANTLR3/Custom+Syntax+Error+Recovery
         * 
         * @param follow set of tokens to recover to
         */
        private void syncToSet() {
            // Compute the followset that is in context wherever we are in the
            // rule chain/stack
            BitSet follow = state.following[state._fsp]; //computeContextSensitiveRuleFOLLOW();
            syncToSet(follow);
        }

        /**
         * This method synchronizes input with the given token set.<br/>
         * Used when due to an error antlr cannot loop back to correct position in the stream.<br/>
         * 
         * @author Jim Idle
         * @see http://www.antlr.org/wiki/display/ANTLR3/Custom+Syntax+Error+Recovery
         * 
         * @param follow set of tokens to recover to
         */
        protected void syncToSet(final BitSet follow) {
            int mark = -1;
            try {
                mark = input.mark();
                // Consume all tokens in the stream until we find a member of the follow
                // set, which means the next production should be guaranteed to be happy.
                //
                while (!follow.member(input.LA(1))) {
                    if (input.LA(1) == Token.EOF) {
                        // Looks like we didn't find anything at all that can help us here
                        // so we need to rewind to where we were and let normal error handling
                        // bail out.
                        //
                        input.rewind();
                        mark = -1;
                        return;
                    }
                    final CommonToken token = (CommonToken) input.LT(1);
                    //register error only if token is not blank
                    if (token.getText() != null && token.getText().trim().length() != 0) {
                        context.registerError(token);
                    }

                    input.consume();
                    // Now here, because you are consuming some tokens, yu will probably want
                    // to raise an error message such as "Spurious elements after the class member were discarded"
                    // using whatever your override of displayRecognitionError() routine does to record
                    // error messages. The exact error my depend on context etc.
                }
            } catch (final Exception e) {
                // Just ignore any errors here, we will just let the recognizer
                // try to resync as normal - something must be very screwed.
                //
            } finally {
                // Always release the mark we took
                //
                if (mark != -1) {
                    input.release(mark);
                }
            }
        }


    public static class parse_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parse"
    // com/lambda/impex/ast/Impex.g:251:1: parse : (t= . )* EOF ;
    public final ImpexParser.parse_return parse() throws RecognitionException {
        ImpexParser.parse_return retval = new ImpexParser.parse_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token t=null;
        Token EOF1=null;

        CommonTree t_tree=null;
        CommonTree EOF1_tree=null;

        try {
            // com/lambda/impex/ast/Impex.g:252:3: ( (t= . )* EOF )
            // com/lambda/impex/ast/Impex.g:252:6: (t= . )* EOF
            {
            root_0 = (CommonTree)adaptor.nil();


            // com/lambda/impex/ast/Impex.g:252:6: (t= . )*
            loop1:
            do {
                int alt1=2;
                switch ( input.LA(1) ) {
                case ATTRIBUTE:
                case ATTRIBUTES:
                case ATTRIBUTE_NAME:
                case Alias:
                case AllowNull:
                case BLOCK:
                case BLOCKS:
                case BatchMode:
                case BeanShell:
                case Bool:
                case CacheUnique:
                case CellDecorator:
                case Char:
                case Classname:
                case CollectionDelimiter:
                case Comma:
                case Comment:
                case DOCUMENTID:
                case DOCUMENTID_REF:
                case Dateformat:
                case Default:
                case DocumentID:
                case Dot:
                case DoubleQuote:
                case Equals:
                case FIELDS:
                case Field:
                case ForceWrite:
                case HEADER:
                case IMPEX:
                case ITEM_EXPRESSION:
                case Identifier:
                case IgnoreKeyCase:
                case IgnoreNull:
                case Insert:
                case InsertUpdate:
                case KeyToValueDelimiter:
                case LBracket:
                case LParenthesis:
                case Lang:
                case Lb:
                case MACRO_REF:
                case MODIFIER:
                case MODIFIERS:
                case Macrodef:
                case MapDelimiter:
                case Mode:
                case NumberFormat:
                case Or:
                case PathDelimiter:
                case Pos:
                case Processor:
                case Quote:
                case QuotedField:
                case RBracket:
                case RECORD:
                case RECORDS:
                case RParenthesis:
                case Remove:
                case SUBTYPE:
                case Semicolon:
                case Separator:
                case SpecialAttribute:
                case TYPE:
                case Translator:
                case Unique:
                case Update:
                case UserRights:
                case ValueAssignment:
                case Virtual:
                case Ws:
                    {
                    alt1=1;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // com/lambda/impex/ast/Impex.g:252:7: t= .
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


            EOF1=(Token)match(input,EOF,FOLLOW_EOF_in_parse178); 
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


    public static class sync_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "sync"
    // com/lambda/impex/ast/Impex.g:254:1: sync :;
    public final ImpexParser.sync_return sync() throws RecognitionException {
        ImpexParser.sync_return retval = new ImpexParser.sync_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;


        	    syncToSet();
        	
        try {
            // com/lambda/impex/ast/Impex.g:257:3: ()
            // com/lambda/impex/ast/Impex.g:257:17: 
            {
            root_0 = (CommonTree)adaptor.nil();


            }

            retval.stop = input.LT(-1);


            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

        }
        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "sync"


    public static class impex_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "impex"
    // com/lambda/impex/ast/Impex.g:259:1: impex : sync ( ( Lb | block | macro ) sync )* EOF -> ^( IMPEX ^( BLOCKS ( block )* ) ) ;
    public final ImpexParser.impex_return impex() throws RecognitionException {
        ImpexParser.impex_return retval = new ImpexParser.impex_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Lb3=null;
        Token EOF7=null;
        ImpexParser.sync_return sync2 =null;

        ImpexParser.block_return block4 =null;

        ImpexParser.macro_return macro5 =null;

        ImpexParser.sync_return sync6 =null;


        CommonTree Lb3_tree=null;
        CommonTree EOF7_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleTokenStream stream_Lb=new RewriteRuleTokenStream(adaptor,"token Lb");
        RewriteRuleSubtreeStream stream_macro=new RewriteRuleSubtreeStream(adaptor,"rule macro");
        RewriteRuleSubtreeStream stream_sync=new RewriteRuleSubtreeStream(adaptor,"rule sync");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // com/lambda/impex/ast/Impex.g:259:7: ( sync ( ( Lb | block | macro ) sync )* EOF -> ^( IMPEX ^( BLOCKS ( block )* ) ) )
            // com/lambda/impex/ast/Impex.g:259:9: sync ( ( Lb | block | macro ) sync )* EOF
            {
            pushFollow(FOLLOW_sync_in_impex197);
            sync2=sync();

            state._fsp--;

            stream_sync.add(sync2.getTree());

            // com/lambda/impex/ast/Impex.g:259:14: ( ( Lb | block | macro ) sync )*
            loop3:
            do {
                int alt3=2;
                switch ( input.LA(1) ) {
                case Insert:
                case InsertUpdate:
                case Lb:
                case Macrodef:
                case Remove:
                case Update:
                    {
                    alt3=1;
                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // com/lambda/impex/ast/Impex.g:259:15: ( Lb | block | macro ) sync
            	    {
            	    // com/lambda/impex/ast/Impex.g:259:15: ( Lb | block | macro )
            	    int alt2=3;
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
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 2, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt2) {
            	        case 1 :
            	            // com/lambda/impex/ast/Impex.g:259:16: Lb
            	            {
            	            Lb3=(Token)match(input,Lb,FOLLOW_Lb_in_impex201);  
            	            stream_Lb.add(Lb3);


            	            }
            	            break;
            	        case 2 :
            	            // com/lambda/impex/ast/Impex.g:259:22: block
            	            {
            	            pushFollow(FOLLOW_block_in_impex206);
            	            block4=block();

            	            state._fsp--;

            	            stream_block.add(block4.getTree());

            	            }
            	            break;
            	        case 3 :
            	            // com/lambda/impex/ast/Impex.g:259:30: macro
            	            {
            	            pushFollow(FOLLOW_macro_in_impex210);
            	            macro5=macro();

            	            state._fsp--;

            	            stream_macro.add(macro5.getTree());

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_sync_in_impex214);
            	    sync6=sync();

            	    state._fsp--;

            	    stream_sync.add(sync6.getTree());

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            EOF7=(Token)match(input,EOF,FOLLOW_EOF_in_impex218);  
            stream_EOF.add(EOF7);


            // AST REWRITE
            // elements: block
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 260:3: -> ^( IMPEX ^( BLOCKS ( block )* ) )
            {
                // com/lambda/impex/ast/Impex.g:260:6: ^( IMPEX ^( BLOCKS ( block )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IMPEX, "IMPEX")
                , root_1);

                // com/lambda/impex/ast/Impex.g:260:14: ^( BLOCKS ( block )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCKS, "BLOCKS")
                , root_2);

                // com/lambda/impex/ast/Impex.g:260:23: ( block )*
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
        catch (RecognitionException ex) {

                reportError(ex);
                consumeUntil(input, new BitSet(new long[] { Insert, InsertUpdate, Update, Remove, Macrodef }));

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
    // com/lambda/impex/ast/Impex.g:266:1: block : header ( ( ( Lb )+ ( macro ( Lb )* )* record ) )* -> ^( BLOCK header ^( RECORDS ( record )* ) ) ;
    public final ImpexParser.block_return block() throws RecognitionException {
        ImpexParser.block_return retval = new ImpexParser.block_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Lb9=null;
        Token Lb11=null;
        ImpexParser.header_return header8 =null;

        ImpexParser.macro_return macro10 =null;

        ImpexParser.record_return record12 =null;


        CommonTree Lb9_tree=null;
        CommonTree Lb11_tree=null;
        RewriteRuleTokenStream stream_Lb=new RewriteRuleTokenStream(adaptor,"token Lb");
        RewriteRuleSubtreeStream stream_record=new RewriteRuleSubtreeStream(adaptor,"rule record");
        RewriteRuleSubtreeStream stream_macro=new RewriteRuleSubtreeStream(adaptor,"rule macro");
        RewriteRuleSubtreeStream stream_header=new RewriteRuleSubtreeStream(adaptor,"rule header");
        try {
            // com/lambda/impex/ast/Impex.g:266:7: ( header ( ( ( Lb )+ ( macro ( Lb )* )* record ) )* -> ^( BLOCK header ^( RECORDS ( record )* ) ) )
            // com/lambda/impex/ast/Impex.g:266:9: header ( ( ( Lb )+ ( macro ( Lb )* )* record ) )*
            {
            pushFollow(FOLLOW_header_in_block249);
            header8=header();

            state._fsp--;

            stream_header.add(header8.getTree());

            // com/lambda/impex/ast/Impex.g:266:17: ( ( ( Lb )+ ( macro ( Lb )* )* record ) )*
            loop7:
            do {
                int alt7=2;
                alt7 = dfa7.predict(input);
                switch (alt7) {
            	case 1 :
            	    // com/lambda/impex/ast/Impex.g:266:18: ( ( Lb )+ ( macro ( Lb )* )* record )
            	    {
            	    // com/lambda/impex/ast/Impex.g:266:18: ( ( Lb )+ ( macro ( Lb )* )* record )
            	    // com/lambda/impex/ast/Impex.g:266:19: ( Lb )+ ( macro ( Lb )* )* record
            	    {
            	    // com/lambda/impex/ast/Impex.g:266:19: ( Lb )+
            	    int cnt4=0;
            	    loop4:
            	    do {
            	        int alt4=2;
            	        switch ( input.LA(1) ) {
            	        case Lb:
            	            {
            	            alt4=1;
            	            }
            	            break;

            	        }

            	        switch (alt4) {
            	    	case 1 :
            	    	    // com/lambda/impex/ast/Impex.g:266:20: Lb
            	    	    {
            	    	    Lb9=(Token)match(input,Lb,FOLLOW_Lb_in_block255);  
            	    	    stream_Lb.add(Lb9);


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


            	    // com/lambda/impex/ast/Impex.g:266:26: ( macro ( Lb )* )*
            	    loop6:
            	    do {
            	        int alt6=2;
            	        switch ( input.LA(1) ) {
            	        case Macrodef:
            	            {
            	            alt6=1;
            	            }
            	            break;

            	        }

            	        switch (alt6) {
            	    	case 1 :
            	    	    // com/lambda/impex/ast/Impex.g:266:27: macro ( Lb )*
            	    	    {
            	    	    pushFollow(FOLLOW_macro_in_block261);
            	    	    macro10=macro();

            	    	    state._fsp--;

            	    	    stream_macro.add(macro10.getTree());

            	    	    // com/lambda/impex/ast/Impex.g:266:34: ( Lb )*
            	    	    loop5:
            	    	    do {
            	    	        int alt5=2;
            	    	        switch ( input.LA(1) ) {
            	    	        case Lb:
            	    	            {
            	    	            alt5=1;
            	    	            }
            	    	            break;

            	    	        }

            	    	        switch (alt5) {
            	    	    	case 1 :
            	    	    	    // com/lambda/impex/ast/Impex.g:266:35: Lb
            	    	    	    {
            	    	    	    Lb11=(Token)match(input,Lb,FOLLOW_Lb_in_block265);  
            	    	    	    stream_Lb.add(Lb11);


            	    	    	    }
            	    	    	    break;

            	    	    	default :
            	    	    	    break loop5;
            	    	        }
            	    	    } while (true);


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop6;
            	        }
            	    } while (true);


            	    pushFollow(FOLLOW_record_in_block272);
            	    record12=record();

            	    state._fsp--;

            	    stream_record.add(record12.getTree());

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
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
            // 267:2: -> ^( BLOCK header ^( RECORDS ( record )* ) )
            {
                // com/lambda/impex/ast/Impex.g:267:5: ^( BLOCK header ^( RECORDS ( record )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCK, "BLOCK")
                , root_1);

                adaptor.addChild(root_1, stream_header.nextTree());

                // com/lambda/impex/ast/Impex.g:267:20: ^( RECORDS ( record )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(RECORDS, "RECORDS")
                , root_2);

                // com/lambda/impex/ast/Impex.g:267:30: ( record )*
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
    // com/lambda/impex/ast/Impex.g:269:1: header : headerMode headerTypeName ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )* ( Semicolon ( attribute | quote attribute quote ) )* ( Semicolon DocumentID ( Semicolon ( attribute | quote attribute quote ) )* )? -> ^( HEADER headerMode ^( TYPE headerTypeName ) ^( MODIFIERS ( headerModifierAssignment )* ) ^( DOCUMENTID ( DocumentID )? ) ^( ATTRIBUTES ( attribute )* ) ) ;
    public final ImpexParser.header_return header() throws RecognitionException {
        ImpexParser.header_return retval = new ImpexParser.header_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token LBracket15=null;
        Token Comma17=null;
        Token RBracket19=null;
        Token Semicolon20=null;
        Token Semicolon25=null;
        Token DocumentID26=null;
        Token Semicolon27=null;
        ImpexParser.headerMode_return headerMode13 =null;

        ImpexParser.headerTypeName_return headerTypeName14 =null;

        ImpexParser.headerModifierAssignment_return headerModifierAssignment16 =null;

        ImpexParser.headerModifierAssignment_return headerModifierAssignment18 =null;

        ImpexParser.attribute_return attribute21 =null;

        ImpexParser.quote_return quote22 =null;

        ImpexParser.attribute_return attribute23 =null;

        ImpexParser.quote_return quote24 =null;

        ImpexParser.attribute_return attribute28 =null;

        ImpexParser.quote_return quote29 =null;

        ImpexParser.attribute_return attribute30 =null;

        ImpexParser.quote_return quote31 =null;


        CommonTree LBracket15_tree=null;
        CommonTree Comma17_tree=null;
        CommonTree RBracket19_tree=null;
        CommonTree Semicolon20_tree=null;
        CommonTree Semicolon25_tree=null;
        CommonTree DocumentID26_tree=null;
        CommonTree Semicolon27_tree=null;
        RewriteRuleTokenStream stream_DocumentID=new RewriteRuleTokenStream(adaptor,"token DocumentID");
        RewriteRuleTokenStream stream_RBracket=new RewriteRuleTokenStream(adaptor,"token RBracket");
        RewriteRuleTokenStream stream_LBracket=new RewriteRuleTokenStream(adaptor,"token LBracket");
        RewriteRuleTokenStream stream_Semicolon=new RewriteRuleTokenStream(adaptor,"token Semicolon");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleSubtreeStream stream_headerMode=new RewriteRuleSubtreeStream(adaptor,"rule headerMode");
        RewriteRuleSubtreeStream stream_headerModifierAssignment=new RewriteRuleSubtreeStream(adaptor,"rule headerModifierAssignment");
        RewriteRuleSubtreeStream stream_headerTypeName=new RewriteRuleSubtreeStream(adaptor,"rule headerTypeName");
        RewriteRuleSubtreeStream stream_quote=new RewriteRuleSubtreeStream(adaptor,"rule quote");
        RewriteRuleSubtreeStream stream_attribute=new RewriteRuleSubtreeStream(adaptor,"rule attribute");
        try {
            // com/lambda/impex/ast/Impex.g:270:2: ( headerMode headerTypeName ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )* ( Semicolon ( attribute | quote attribute quote ) )* ( Semicolon DocumentID ( Semicolon ( attribute | quote attribute quote ) )* )? -> ^( HEADER headerMode ^( TYPE headerTypeName ) ^( MODIFIERS ( headerModifierAssignment )* ) ^( DOCUMENTID ( DocumentID )? ) ^( ATTRIBUTES ( attribute )* ) ) )
            // com/lambda/impex/ast/Impex.g:270:4: headerMode headerTypeName ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )* ( Semicolon ( attribute | quote attribute quote ) )* ( Semicolon DocumentID ( Semicolon ( attribute | quote attribute quote ) )* )?
            {
            pushFollow(FOLLOW_headerMode_in_header301);
            headerMode13=headerMode();

            state._fsp--;

            stream_headerMode.add(headerMode13.getTree());

            pushFollow(FOLLOW_headerTypeName_in_header304);
            headerTypeName14=headerTypeName();

            state._fsp--;

            stream_headerTypeName.add(headerTypeName14.getTree());

            // com/lambda/impex/ast/Impex.g:270:31: ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )*
            loop9:
            do {
                int alt9=2;
                switch ( input.LA(1) ) {
                case LBracket:
                    {
                    alt9=1;
                    }
                    break;

                }

                switch (alt9) {
            	case 1 :
            	    // com/lambda/impex/ast/Impex.g:270:32: LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket
            	    {
            	    LBracket15=(Token)match(input,LBracket,FOLLOW_LBracket_in_header307);  
            	    stream_LBracket.add(LBracket15);


            	    pushFollow(FOLLOW_headerModifierAssignment_in_header309);
            	    headerModifierAssignment16=headerModifierAssignment();

            	    state._fsp--;

            	    stream_headerModifierAssignment.add(headerModifierAssignment16.getTree());

            	    // com/lambda/impex/ast/Impex.g:270:66: ( Comma headerModifierAssignment )*
            	    loop8:
            	    do {
            	        int alt8=2;
            	        switch ( input.LA(1) ) {
            	        case Comma:
            	            {
            	            alt8=1;
            	            }
            	            break;

            	        }

            	        switch (alt8) {
            	    	case 1 :
            	    	    // com/lambda/impex/ast/Impex.g:270:67: Comma headerModifierAssignment
            	    	    {
            	    	    Comma17=(Token)match(input,Comma,FOLLOW_Comma_in_header312);  
            	    	    stream_Comma.add(Comma17);


            	    	    pushFollow(FOLLOW_headerModifierAssignment_in_header315);
            	    	    headerModifierAssignment18=headerModifierAssignment();

            	    	    state._fsp--;

            	    	    stream_headerModifierAssignment.add(headerModifierAssignment18.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop8;
            	        }
            	    } while (true);


            	    RBracket19=(Token)match(input,RBracket,FOLLOW_RBracket_in_header319);  
            	    stream_RBracket.add(RBracket19);


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            // com/lambda/impex/ast/Impex.g:270:113: ( Semicolon ( attribute | quote attribute quote ) )*
            loop11:
            do {
                int alt11=2;
                switch ( input.LA(1) ) {
                case Semicolon:
                    {
                    switch ( input.LA(2) ) {
                    case EOF:
                    case DoubleQuote:
                    case Identifier:
                    case Insert:
                    case InsertUpdate:
                    case LBracket:
                    case LParenthesis:
                    case Lb:
                    case Macrodef:
                    case Quote:
                    case Remove:
                    case Semicolon:
                    case SpecialAttribute:
                    case Update:
                        {
                        alt11=1;
                        }
                        break;

                    }

                    }
                    break;

                }

                switch (alt11) {
            	case 1 :
            	    // com/lambda/impex/ast/Impex.g:270:114: Semicolon ( attribute | quote attribute quote )
            	    {
            	    Semicolon20=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_header325);  
            	    stream_Semicolon.add(Semicolon20);


            	    // com/lambda/impex/ast/Impex.g:270:124: ( attribute | quote attribute quote )
            	    int alt10=2;
            	    switch ( input.LA(1) ) {
            	    case EOF:
            	    case Identifier:
            	    case Insert:
            	    case InsertUpdate:
            	    case LBracket:
            	    case LParenthesis:
            	    case Lb:
            	    case Macrodef:
            	    case Remove:
            	    case Semicolon:
            	    case SpecialAttribute:
            	    case Update:
            	        {
            	        alt10=1;
            	        }
            	        break;
            	    case DoubleQuote:
            	    case Quote:
            	        {
            	        alt10=2;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 10, 0, input);

            	        throw nvae;

            	    }

            	    switch (alt10) {
            	        case 1 :
            	            // com/lambda/impex/ast/Impex.g:270:125: attribute
            	            {
            	            pushFollow(FOLLOW_attribute_in_header328);
            	            attribute21=attribute();

            	            state._fsp--;

            	            stream_attribute.add(attribute21.getTree());

            	            }
            	            break;
            	        case 2 :
            	            // com/lambda/impex/ast/Impex.g:270:137: quote attribute quote
            	            {
            	            pushFollow(FOLLOW_quote_in_header332);
            	            quote22=quote();

            	            state._fsp--;

            	            stream_quote.add(quote22.getTree());

            	            pushFollow(FOLLOW_attribute_in_header334);
            	            attribute23=attribute();

            	            state._fsp--;

            	            stream_attribute.add(attribute23.getTree());

            	            pushFollow(FOLLOW_quote_in_header336);
            	            quote24=quote();

            	            state._fsp--;

            	            stream_quote.add(quote24.getTree());

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            // com/lambda/impex/ast/Impex.g:270:162: ( Semicolon DocumentID ( Semicolon ( attribute | quote attribute quote ) )* )?
            int alt14=2;
            switch ( input.LA(1) ) {
                case Semicolon:
                    {
                    alt14=1;
                    }
                    break;
            }

            switch (alt14) {
                case 1 :
                    // com/lambda/impex/ast/Impex.g:270:163: Semicolon DocumentID ( Semicolon ( attribute | quote attribute quote ) )*
                    {
                    Semicolon25=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_header342);  
                    stream_Semicolon.add(Semicolon25);


                    DocumentID26=(Token)match(input,DocumentID,FOLLOW_DocumentID_in_header344);  
                    stream_DocumentID.add(DocumentID26);


                    context.registerDocumentID((CommonToken)DocumentID26);

                    // com/lambda/impex/ast/Impex.g:270:239: ( Semicolon ( attribute | quote attribute quote ) )*
                    loop13:
                    do {
                        int alt13=2;
                        switch ( input.LA(1) ) {
                        case Semicolon:
                            {
                            alt13=1;
                            }
                            break;

                        }

                        switch (alt13) {
                    	case 1 :
                    	    // com/lambda/impex/ast/Impex.g:270:240: Semicolon ( attribute | quote attribute quote )
                    	    {
                    	    Semicolon27=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_header348);  
                    	    stream_Semicolon.add(Semicolon27);


                    	    // com/lambda/impex/ast/Impex.g:270:250: ( attribute | quote attribute quote )
                    	    int alt12=2;
                    	    switch ( input.LA(1) ) {
                    	    case EOF:
                    	    case Identifier:
                    	    case Insert:
                    	    case InsertUpdate:
                    	    case LBracket:
                    	    case LParenthesis:
                    	    case Lb:
                    	    case Macrodef:
                    	    case Remove:
                    	    case Semicolon:
                    	    case SpecialAttribute:
                    	    case Update:
                    	        {
                    	        alt12=1;
                    	        }
                    	        break;
                    	    case DoubleQuote:
                    	    case Quote:
                    	        {
                    	        alt12=2;
                    	        }
                    	        break;
                    	    default:
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 12, 0, input);

                    	        throw nvae;

                    	    }

                    	    switch (alt12) {
                    	        case 1 :
                    	            // com/lambda/impex/ast/Impex.g:270:251: attribute
                    	            {
                    	            pushFollow(FOLLOW_attribute_in_header351);
                    	            attribute28=attribute();

                    	            state._fsp--;

                    	            stream_attribute.add(attribute28.getTree());

                    	            }
                    	            break;
                    	        case 2 :
                    	            // com/lambda/impex/ast/Impex.g:270:263: quote attribute quote
                    	            {
                    	            pushFollow(FOLLOW_quote_in_header355);
                    	            quote29=quote();

                    	            state._fsp--;

                    	            stream_quote.add(quote29.getTree());

                    	            pushFollow(FOLLOW_attribute_in_header357);
                    	            attribute30=attribute();

                    	            state._fsp--;

                    	            stream_attribute.add(attribute30.getTree());

                    	            pushFollow(FOLLOW_quote_in_header359);
                    	            quote31=quote();

                    	            state._fsp--;

                    	            stream_quote.add(quote31.getTree());

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }


            // AST REWRITE
            // elements: headerMode, attribute, headerTypeName, headerModifierAssignment, DocumentID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 271:2: -> ^( HEADER headerMode ^( TYPE headerTypeName ) ^( MODIFIERS ( headerModifierAssignment )* ) ^( DOCUMENTID ( DocumentID )? ) ^( ATTRIBUTES ( attribute )* ) )
            {
                // com/lambda/impex/ast/Impex.g:271:5: ^( HEADER headerMode ^( TYPE headerTypeName ) ^( MODIFIERS ( headerModifierAssignment )* ) ^( DOCUMENTID ( DocumentID )? ) ^( ATTRIBUTES ( attribute )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(HEADER, "HEADER")
                , root_1);

                adaptor.addChild(root_1, stream_headerMode.nextTree());

                // com/lambda/impex/ast/Impex.g:271:25: ^( TYPE headerTypeName )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(TYPE, "TYPE")
                , root_2);

                adaptor.addChild(root_2, stream_headerTypeName.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                // com/lambda/impex/ast/Impex.g:271:48: ^( MODIFIERS ( headerModifierAssignment )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(MODIFIERS, "MODIFIERS")
                , root_2);

                // com/lambda/impex/ast/Impex.g:271:60: ( headerModifierAssignment )*
                while ( stream_headerModifierAssignment.hasNext() ) {
                    adaptor.addChild(root_2, stream_headerModifierAssignment.nextTree());

                }
                stream_headerModifierAssignment.reset();

                adaptor.addChild(root_1, root_2);
                }

                // com/lambda/impex/ast/Impex.g:271:87: ^( DOCUMENTID ( DocumentID )? )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(DOCUMENTID, "DOCUMENTID")
                , root_2);

                // com/lambda/impex/ast/Impex.g:271:100: ( DocumentID )?
                if ( stream_DocumentID.hasNext() ) {
                    adaptor.addChild(root_2, 
                    stream_DocumentID.nextNode()
                    );

                }
                stream_DocumentID.reset();

                adaptor.addChild(root_1, root_2);
                }

                // com/lambda/impex/ast/Impex.g:271:113: ^( ATTRIBUTES ( attribute )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ATTRIBUTES, "ATTRIBUTES")
                , root_2);

                // com/lambda/impex/ast/Impex.g:271:126: ( attribute )*
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


    public static class quote_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "quote"
    // com/lambda/impex/ast/Impex.g:273:1: quote : ( DoubleQuote | Quote );
    public final ImpexParser.quote_return quote() throws RecognitionException {
        ImpexParser.quote_return retval = new ImpexParser.quote_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set32=null;

        CommonTree set32_tree=null;

        try {
            // com/lambda/impex/ast/Impex.g:273:7: ( DoubleQuote | Quote )
            // com/lambda/impex/ast/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set32=(Token)input.LT(1);

            if ( input.LA(1)==DoubleQuote||input.LA(1)==Quote ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set32)
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
    // $ANTLR end "quote"


    public static class headerModifierAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "headerModifierAssignment"
    // com/lambda/impex/ast/Impex.g:275:1: headerModifierAssignment : headerModifier ValueAssignment -> ^( MODIFIER headerModifier ValueAssignment ) ;
    public final ImpexParser.headerModifierAssignment_return headerModifierAssignment() throws RecognitionException {
        ImpexParser.headerModifierAssignment_return retval = new ImpexParser.headerModifierAssignment_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ValueAssignment34=null;
        ImpexParser.headerModifier_return headerModifier33 =null;


        CommonTree ValueAssignment34_tree=null;
        RewriteRuleTokenStream stream_ValueAssignment=new RewriteRuleTokenStream(adaptor,"token ValueAssignment");
        RewriteRuleSubtreeStream stream_headerModifier=new RewriteRuleSubtreeStream(adaptor,"rule headerModifier");
        try {
            // com/lambda/impex/ast/Impex.g:275:25: ( headerModifier ValueAssignment -> ^( MODIFIER headerModifier ValueAssignment ) )
            // com/lambda/impex/ast/Impex.g:275:27: headerModifier ValueAssignment
            {
            pushFollow(FOLLOW_headerModifier_in_headerModifierAssignment420);
            headerModifier33=headerModifier();

            state._fsp--;

            stream_headerModifier.add(headerModifier33.getTree());

            ValueAssignment34=(Token)match(input,ValueAssignment,FOLLOW_ValueAssignment_in_headerModifierAssignment422);  
            stream_ValueAssignment.add(ValueAssignment34);


            // AST REWRITE
            // elements: ValueAssignment, headerModifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 276:2: -> ^( MODIFIER headerModifier ValueAssignment )
            {
                // com/lambda/impex/ast/Impex.g:276:5: ^( MODIFIER headerModifier ValueAssignment )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(MODIFIER, "MODIFIER")
                , root_1);

                adaptor.addChild(root_1, stream_headerModifier.nextTree());

                adaptor.addChild(root_1, 
                stream_ValueAssignment.nextNode()
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
    // $ANTLR end "headerModifierAssignment"


    public static class headerModifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "headerModifier"
    // com/lambda/impex/ast/Impex.g:278:1: headerModifier : ( BatchMode | CacheUnique | Processor );
    public final ImpexParser.headerModifier_return headerModifier() throws RecognitionException {
        ImpexParser.headerModifier_return retval = new ImpexParser.headerModifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set35=null;

        CommonTree set35_tree=null;

        try {
            // com/lambda/impex/ast/Impex.g:279:2: ( BatchMode | CacheUnique | Processor )
            // com/lambda/impex/ast/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set35=(Token)input.LT(1);

            if ( input.LA(1)==BatchMode||input.LA(1)==CacheUnique||input.LA(1)==Processor ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set35)
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
    // com/lambda/impex/ast/Impex.g:282:1: record : ( Identifier )? ( field )+ -> ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) ) ;
    public final ImpexParser.record_return record() throws RecognitionException {
        ImpexParser.record_return retval = new ImpexParser.record_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Identifier36=null;
        ImpexParser.field_return field37 =null;


        CommonTree Identifier36_tree=null;
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_field=new RewriteRuleSubtreeStream(adaptor,"rule field");
        try {
            // com/lambda/impex/ast/Impex.g:283:5: ( ( Identifier )? ( field )+ -> ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) ) )
            // com/lambda/impex/ast/Impex.g:283:7: ( Identifier )? ( field )+
            {
            // com/lambda/impex/ast/Impex.g:283:7: ( Identifier )?
            int alt15=2;
            switch ( input.LA(1) ) {
                case Identifier:
                    {
                    alt15=1;
                    }
                    break;
            }

            switch (alt15) {
                case 1 :
                    // com/lambda/impex/ast/Impex.g:283:7: Identifier
                    {
                    Identifier36=(Token)match(input,Identifier,FOLLOW_Identifier_in_record462);  
                    stream_Identifier.add(Identifier36);


                    }
                    break;

            }


            // com/lambda/impex/ast/Impex.g:283:19: ( field )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                switch ( input.LA(1) ) {
                case Field:
                case QuotedField:
                    {
                    alt16=1;
                    }
                    break;

                }

                switch (alt16) {
            	case 1 :
            	    // com/lambda/impex/ast/Impex.g:283:20: field
            	    {
            	    pushFollow(FOLLOW_field_in_record466);
            	    field37=field();

            	    state._fsp--;

            	    stream_field.add(field37.getTree());

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


            // AST REWRITE
            // elements: field, Identifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 284:6: -> ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) )
            {
                // com/lambda/impex/ast/Impex.g:284:9: ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(RECORD, "RECORD")
                , root_1);

                // com/lambda/impex/ast/Impex.g:284:18: ^( SUBTYPE ( Identifier )? )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(SUBTYPE, "SUBTYPE")
                , root_2);

                // com/lambda/impex/ast/Impex.g:284:28: ( Identifier )?
                if ( stream_Identifier.hasNext() ) {
                    adaptor.addChild(root_2, 
                    stream_Identifier.nextNode()
                    );

                }
                stream_Identifier.reset();

                adaptor.addChild(root_1, root_2);
                }

                // com/lambda/impex/ast/Impex.g:284:41: ^( FIELDS ( field )+ )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(FIELDS, "FIELDS")
                , root_2);

                if ( !(stream_field.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_field.hasNext() ) {
                    adaptor.addChild(root_2, stream_field.nextTree());

                }
                stream_field.reset();

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
        catch (RecognitionException ex) {

                reportError(ex);
                consumeUntil(input, new BitSet(new long[] { Lb }));

        }

        finally {
        	// do for sure before leaving
        }
        return retval;
    }
    // $ANTLR end "record"


    public static class field_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field"
    // com/lambda/impex/ast/Impex.g:290:1: field : ( QuotedField | Field );
    public final ImpexParser.field_return field() throws RecognitionException {
        ImpexParser.field_return retval = new ImpexParser.field_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set38=null;

        CommonTree set38_tree=null;

        try {
            // com/lambda/impex/ast/Impex.g:290:7: ( QuotedField | Field )
            // com/lambda/impex/ast/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set38=(Token)input.LT(1);

            if ( input.LA(1)==Field||input.LA(1)==QuotedField ) {
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
    // $ANTLR end "field"


    public static class attributeName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "attributeName"
    // com/lambda/impex/ast/Impex.g:315:1: attributeName : ( Macrodef -> ^( ATTRIBUTE_NAME Macrodef ) | SpecialAttribute -> ^( ATTRIBUTE_NAME SpecialAttribute ) | ( Identifier ( Dot attributeName )? ) -> ^( ATTRIBUTE_NAME Identifier ( attributeName )? ) | -> ^( ATTRIBUTE_NAME ) );
    public final ImpexParser.attributeName_return attributeName() throws RecognitionException {
        ImpexParser.attributeName_return retval = new ImpexParser.attributeName_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Macrodef39=null;
        Token SpecialAttribute40=null;
        Token Identifier41=null;
        Token Dot42=null;
        ImpexParser.attributeName_return attributeName43 =null;


        CommonTree Macrodef39_tree=null;
        CommonTree SpecialAttribute40_tree=null;
        CommonTree Identifier41_tree=null;
        CommonTree Dot42_tree=null;
        RewriteRuleTokenStream stream_Dot=new RewriteRuleTokenStream(adaptor,"token Dot");
        RewriteRuleTokenStream stream_SpecialAttribute=new RewriteRuleTokenStream(adaptor,"token SpecialAttribute");
        RewriteRuleTokenStream stream_Macrodef=new RewriteRuleTokenStream(adaptor,"token Macrodef");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_attributeName=new RewriteRuleSubtreeStream(adaptor,"rule attributeName");
        try {
            // com/lambda/impex/ast/Impex.g:316:2: ( Macrodef -> ^( ATTRIBUTE_NAME Macrodef ) | SpecialAttribute -> ^( ATTRIBUTE_NAME SpecialAttribute ) | ( Identifier ( Dot attributeName )? ) -> ^( ATTRIBUTE_NAME Identifier ( attributeName )? ) | -> ^( ATTRIBUTE_NAME ) )
            int alt18=4;
            switch ( input.LA(1) ) {
            case Macrodef:
                {
                switch ( input.LA(2) ) {
                case EOF:
                case Comma:
                case DoubleQuote:
                case Insert:
                case InsertUpdate:
                case LBracket:
                case LParenthesis:
                case Lb:
                case Macrodef:
                case Quote:
                case RParenthesis:
                case Remove:
                case Semicolon:
                case Update:
                    {
                    alt18=1;
                    }
                    break;
                case Equals:
                case ValueAssignment:
                    {
                    alt18=4;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 18, 1, input);

                    throw nvae;

                }

                }
                break;
            case SpecialAttribute:
                {
                alt18=2;
                }
                break;
            case Identifier:
                {
                alt18=3;
                }
                break;
            case EOF:
            case Comma:
            case DoubleQuote:
            case Insert:
            case InsertUpdate:
            case LBracket:
            case LParenthesis:
            case Lb:
            case Quote:
            case RParenthesis:
            case Remove:
            case Semicolon:
            case Update:
                {
                alt18=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;

            }

            switch (alt18) {
                case 1 :
                    // com/lambda/impex/ast/Impex.g:316:3: Macrodef
                    {
                    Macrodef39=(Token)match(input,Macrodef,FOLLOW_Macrodef_in_attributeName545);  
                    stream_Macrodef.add(Macrodef39);


                    // AST REWRITE
                    // elements: Macrodef
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 316:12: -> ^( ATTRIBUTE_NAME Macrodef )
                    {
                        // com/lambda/impex/ast/Impex.g:316:15: ^( ATTRIBUTE_NAME Macrodef )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(ATTRIBUTE_NAME, "ATTRIBUTE_NAME")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_Macrodef.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // com/lambda/impex/ast/Impex.g:317:4: SpecialAttribute
                    {
                    SpecialAttribute40=(Token)match(input,SpecialAttribute,FOLLOW_SpecialAttribute_in_attributeName559);  
                    stream_SpecialAttribute.add(SpecialAttribute40);


                    // AST REWRITE
                    // elements: SpecialAttribute
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 317:21: -> ^( ATTRIBUTE_NAME SpecialAttribute )
                    {
                        // com/lambda/impex/ast/Impex.g:317:24: ^( ATTRIBUTE_NAME SpecialAttribute )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(ATTRIBUTE_NAME, "ATTRIBUTE_NAME")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_SpecialAttribute.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 3 :
                    // com/lambda/impex/ast/Impex.g:318:3: ( Identifier ( Dot attributeName )? )
                    {
                    // com/lambda/impex/ast/Impex.g:318:3: ( Identifier ( Dot attributeName )? )
                    // com/lambda/impex/ast/Impex.g:318:4: Identifier ( Dot attributeName )?
                    {
                    Identifier41=(Token)match(input,Identifier,FOLLOW_Identifier_in_attributeName572);  
                    stream_Identifier.add(Identifier41);


                    // com/lambda/impex/ast/Impex.g:318:15: ( Dot attributeName )?
                    int alt17=2;
                    switch ( input.LA(1) ) {
                        case Dot:
                            {
                            alt17=1;
                            }
                            break;
                    }

                    switch (alt17) {
                        case 1 :
                            // com/lambda/impex/ast/Impex.g:318:16: Dot attributeName
                            {
                            Dot42=(Token)match(input,Dot,FOLLOW_Dot_in_attributeName575);  
                            stream_Dot.add(Dot42);


                            pushFollow(FOLLOW_attributeName_in_attributeName577);
                            attributeName43=attributeName();

                            state._fsp--;

                            stream_attributeName.add(attributeName43.getTree());

                            }
                            break;

                    }


                    }


                    // AST REWRITE
                    // elements: attributeName, Identifier
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 318:37: -> ^( ATTRIBUTE_NAME Identifier ( attributeName )? )
                    {
                        // com/lambda/impex/ast/Impex.g:318:40: ^( ATTRIBUTE_NAME Identifier ( attributeName )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(ATTRIBUTE_NAME, "ATTRIBUTE_NAME")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_Identifier.nextNode()
                        );

                        // com/lambda/impex/ast/Impex.g:318:68: ( attributeName )?
                        if ( stream_attributeName.hasNext() ) {
                            adaptor.addChild(root_1, stream_attributeName.nextTree());

                        }
                        stream_attributeName.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 4 :
                    // com/lambda/impex/ast/Impex.g:319:18: 
                    {
                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 319:18: -> ^( ATTRIBUTE_NAME )
                    {
                        // com/lambda/impex/ast/Impex.g:319:20: ^( ATTRIBUTE_NAME )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(ATTRIBUTE_NAME, "ATTRIBUTE_NAME")
                        , root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

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
    // $ANTLR end "attributeName"


    public static class attribute_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "attribute"
    // com/lambda/impex/ast/Impex.g:321:1: attribute : attributeName ( LParenthesis ( DocumentID | attribute ) ( Comma ( DocumentID | attribute ) )* RParenthesis )? ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket )* -> ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifierAssignment )* ) ) ;
    public final ImpexParser.attribute_return attribute() throws RecognitionException {
        ImpexParser.attribute_return retval = new ImpexParser.attribute_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token LParenthesis45=null;
        Token DocumentID46=null;
        Token Comma48=null;
        Token DocumentID49=null;
        Token RParenthesis51=null;
        Token LBracket52=null;
        Token Comma54=null;
        Token RBracket56=null;
        ImpexParser.attributeName_return attributeName44 =null;

        ImpexParser.attribute_return attribute47 =null;

        ImpexParser.attribute_return attribute50 =null;

        ImpexParser.attributeModifierAssignment_return attributeModifierAssignment53 =null;

        ImpexParser.attributeModifierAssignment_return attributeModifierAssignment55 =null;


        CommonTree LParenthesis45_tree=null;
        CommonTree DocumentID46_tree=null;
        CommonTree Comma48_tree=null;
        CommonTree DocumentID49_tree=null;
        CommonTree RParenthesis51_tree=null;
        CommonTree LBracket52_tree=null;
        CommonTree Comma54_tree=null;
        CommonTree RBracket56_tree=null;
        RewriteRuleTokenStream stream_DocumentID=new RewriteRuleTokenStream(adaptor,"token DocumentID");
        RewriteRuleTokenStream stream_RBracket=new RewriteRuleTokenStream(adaptor,"token RBracket");
        RewriteRuleTokenStream stream_LBracket=new RewriteRuleTokenStream(adaptor,"token LBracket");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_LParenthesis=new RewriteRuleTokenStream(adaptor,"token LParenthesis");
        RewriteRuleTokenStream stream_RParenthesis=new RewriteRuleTokenStream(adaptor,"token RParenthesis");
        RewriteRuleSubtreeStream stream_attributeName=new RewriteRuleSubtreeStream(adaptor,"rule attributeName");
        RewriteRuleSubtreeStream stream_attribute=new RewriteRuleSubtreeStream(adaptor,"rule attribute");
        RewriteRuleSubtreeStream stream_attributeModifierAssignment=new RewriteRuleSubtreeStream(adaptor,"rule attributeModifierAssignment");
        try {
            // com/lambda/impex/ast/Impex.g:322:2: ( attributeName ( LParenthesis ( DocumentID | attribute ) ( Comma ( DocumentID | attribute ) )* RParenthesis )? ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket )* -> ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifierAssignment )* ) ) )
            // com/lambda/impex/ast/Impex.g:322:3: attributeName ( LParenthesis ( DocumentID | attribute ) ( Comma ( DocumentID | attribute ) )* RParenthesis )? ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket )*
            {
            pushFollow(FOLLOW_attributeName_in_attribute612);
            attributeName44=attributeName();

            state._fsp--;

            stream_attributeName.add(attributeName44.getTree());

            // com/lambda/impex/ast/Impex.g:322:17: ( LParenthesis ( DocumentID | attribute ) ( Comma ( DocumentID | attribute ) )* RParenthesis )?
            int alt22=2;
            switch ( input.LA(1) ) {
                case LParenthesis:
                    {
                    alt22=1;
                    }
                    break;
            }

            switch (alt22) {
                case 1 :
                    // com/lambda/impex/ast/Impex.g:322:18: LParenthesis ( DocumentID | attribute ) ( Comma ( DocumentID | attribute ) )* RParenthesis
                    {
                    LParenthesis45=(Token)match(input,LParenthesis,FOLLOW_LParenthesis_in_attribute615);  
                    stream_LParenthesis.add(LParenthesis45);


                    // com/lambda/impex/ast/Impex.g:322:32: ( DocumentID | attribute )
                    int alt19=2;
                    switch ( input.LA(1) ) {
                    case DocumentID:
                        {
                        alt19=1;
                        }
                        break;
                    case EOF:
                    case Comma:
                    case DoubleQuote:
                    case Identifier:
                    case Insert:
                    case InsertUpdate:
                    case LBracket:
                    case LParenthesis:
                    case Lb:
                    case Macrodef:
                    case Quote:
                    case RParenthesis:
                    case Remove:
                    case Semicolon:
                    case SpecialAttribute:
                    case Update:
                        {
                        alt19=2;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 0, input);

                        throw nvae;

                    }

                    switch (alt19) {
                        case 1 :
                            // com/lambda/impex/ast/Impex.g:322:33: DocumentID
                            {
                            DocumentID46=(Token)match(input,DocumentID,FOLLOW_DocumentID_in_attribute619);  
                            stream_DocumentID.add(DocumentID46);


                            }
                            break;
                        case 2 :
                            // com/lambda/impex/ast/Impex.g:322:46: attribute
                            {
                            pushFollow(FOLLOW_attribute_in_attribute623);
                            attribute47=attribute();

                            state._fsp--;

                            stream_attribute.add(attribute47.getTree());

                            }
                            break;

                    }


                    // com/lambda/impex/ast/Impex.g:322:56: ( Comma ( DocumentID | attribute ) )*
                    loop21:
                    do {
                        int alt21=2;
                        switch ( input.LA(1) ) {
                        case Comma:
                            {
                            alt21=1;
                            }
                            break;

                        }

                        switch (alt21) {
                    	case 1 :
                    	    // com/lambda/impex/ast/Impex.g:322:57: Comma ( DocumentID | attribute )
                    	    {
                    	    Comma48=(Token)match(input,Comma,FOLLOW_Comma_in_attribute626);  
                    	    stream_Comma.add(Comma48);


                    	    // com/lambda/impex/ast/Impex.g:322:63: ( DocumentID | attribute )
                    	    int alt20=2;
                    	    switch ( input.LA(1) ) {
                    	    case DocumentID:
                    	        {
                    	        alt20=1;
                    	        }
                    	        break;
                    	    case EOF:
                    	    case Comma:
                    	    case DoubleQuote:
                    	    case Identifier:
                    	    case Insert:
                    	    case InsertUpdate:
                    	    case LBracket:
                    	    case LParenthesis:
                    	    case Lb:
                    	    case Macrodef:
                    	    case Quote:
                    	    case RParenthesis:
                    	    case Remove:
                    	    case Semicolon:
                    	    case SpecialAttribute:
                    	    case Update:
                    	        {
                    	        alt20=2;
                    	        }
                    	        break;
                    	    default:
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 20, 0, input);

                    	        throw nvae;

                    	    }

                    	    switch (alt20) {
                    	        case 1 :
                    	            // com/lambda/impex/ast/Impex.g:322:64: DocumentID
                    	            {
                    	            DocumentID49=(Token)match(input,DocumentID,FOLLOW_DocumentID_in_attribute629);  
                    	            stream_DocumentID.add(DocumentID49);


                    	            }
                    	            break;
                    	        case 2 :
                    	            // com/lambda/impex/ast/Impex.g:322:77: attribute
                    	            {
                    	            pushFollow(FOLLOW_attribute_in_attribute633);
                    	            attribute50=attribute();

                    	            state._fsp--;

                    	            stream_attribute.add(attribute50.getTree());

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);


                    RParenthesis51=(Token)match(input,RParenthesis,FOLLOW_RParenthesis_in_attribute638);  
                    stream_RParenthesis.add(RParenthesis51);


                    }
                    break;

            }


            // com/lambda/impex/ast/Impex.g:322:106: ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket )*
            loop24:
            do {
                int alt24=2;
                switch ( input.LA(1) ) {
                case LBracket:
                    {
                    alt24=1;
                    }
                    break;

                }

                switch (alt24) {
            	case 1 :
            	    // com/lambda/impex/ast/Impex.g:322:107: LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket
            	    {
            	    LBracket52=(Token)match(input,LBracket,FOLLOW_LBracket_in_attribute644);  
            	    stream_LBracket.add(LBracket52);


            	    pushFollow(FOLLOW_attributeModifierAssignment_in_attribute646);
            	    attributeModifierAssignment53=attributeModifierAssignment();

            	    state._fsp--;

            	    stream_attributeModifierAssignment.add(attributeModifierAssignment53.getTree());

            	    // com/lambda/impex/ast/Impex.g:322:144: ( Comma attributeModifierAssignment )*
            	    loop23:
            	    do {
            	        int alt23=2;
            	        switch ( input.LA(1) ) {
            	        case Comma:
            	            {
            	            alt23=1;
            	            }
            	            break;

            	        }

            	        switch (alt23) {
            	    	case 1 :
            	    	    // com/lambda/impex/ast/Impex.g:322:145: Comma attributeModifierAssignment
            	    	    {
            	    	    Comma54=(Token)match(input,Comma,FOLLOW_Comma_in_attribute649);  
            	    	    stream_Comma.add(Comma54);


            	    	    pushFollow(FOLLOW_attributeModifierAssignment_in_attribute652);
            	    	    attributeModifierAssignment55=attributeModifierAssignment();

            	    	    state._fsp--;

            	    	    stream_attributeModifierAssignment.add(attributeModifierAssignment55.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop23;
            	        }
            	    } while (true);


            	    RBracket56=(Token)match(input,RBracket,FOLLOW_RBracket_in_attribute656);  
            	    stream_RBracket.add(RBracket56);


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            // AST REWRITE
            // elements: attributeName, DocumentID, attribute, attributeModifierAssignment
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 323:2: -> ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifierAssignment )* ) )
            {
                // com/lambda/impex/ast/Impex.g:323:5: ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifierAssignment )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ATTRIBUTE, "ATTRIBUTE")
                , root_1);

                adaptor.addChild(root_1, stream_attributeName.nextTree());

                // com/lambda/impex/ast/Impex.g:323:31: ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ITEM_EXPRESSION, "ITEM_EXPRESSION")
                , root_2);

                // com/lambda/impex/ast/Impex.g:323:49: ( attribute )*
                while ( stream_attribute.hasNext() ) {
                    adaptor.addChild(root_2, stream_attribute.nextTree());

                }
                stream_attribute.reset();

                // com/lambda/impex/ast/Impex.g:323:60: ^( DOCUMENTID_REF ( DocumentID )* )
                {
                CommonTree root_3 = (CommonTree)adaptor.nil();
                root_3 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(DOCUMENTID_REF, "DOCUMENTID_REF")
                , root_3);

                // com/lambda/impex/ast/Impex.g:323:77: ( DocumentID )*
                while ( stream_DocumentID.hasNext() ) {
                    adaptor.addChild(root_3, 
                    stream_DocumentID.nextNode()
                    );

                }
                stream_DocumentID.reset();

                adaptor.addChild(root_2, root_3);
                }

                adaptor.addChild(root_1, root_2);
                }

                // com/lambda/impex/ast/Impex.g:323:91: ^( MODIFIERS ( attributeModifierAssignment )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(MODIFIERS, "MODIFIERS")
                , root_2);

                // com/lambda/impex/ast/Impex.g:323:103: ( attributeModifierAssignment )*
                while ( stream_attributeModifierAssignment.hasNext() ) {
                    adaptor.addChild(root_2, stream_attributeModifierAssignment.nextTree());

                }
                stream_attributeModifierAssignment.reset();

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
    // $ANTLR end "attribute"


    public static class attributeModifierAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "attributeModifierAssignment"
    // com/lambda/impex/ast/Impex.g:325:1: attributeModifierAssignment : attributeModifier ValueAssignment -> ^( MODIFIER attributeModifier ValueAssignment ) ;
    public final ImpexParser.attributeModifierAssignment_return attributeModifierAssignment() throws RecognitionException {
        ImpexParser.attributeModifierAssignment_return retval = new ImpexParser.attributeModifierAssignment_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ValueAssignment58=null;
        ImpexParser.attributeModifier_return attributeModifier57 =null;


        CommonTree ValueAssignment58_tree=null;
        RewriteRuleTokenStream stream_ValueAssignment=new RewriteRuleTokenStream(adaptor,"token ValueAssignment");
        RewriteRuleSubtreeStream stream_attributeModifier=new RewriteRuleSubtreeStream(adaptor,"rule attributeModifier");
        try {
            // com/lambda/impex/ast/Impex.g:326:2: ( attributeModifier ValueAssignment -> ^( MODIFIER attributeModifier ValueAssignment ) )
            // com/lambda/impex/ast/Impex.g:326:4: attributeModifier ValueAssignment
            {
            pushFollow(FOLLOW_attributeModifier_in_attributeModifierAssignment697);
            attributeModifier57=attributeModifier();

            state._fsp--;

            stream_attributeModifier.add(attributeModifier57.getTree());

            ValueAssignment58=(Token)match(input,ValueAssignment,FOLLOW_ValueAssignment_in_attributeModifierAssignment699);  
            stream_ValueAssignment.add(ValueAssignment58);


            // AST REWRITE
            // elements: ValueAssignment, attributeModifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 327:2: -> ^( MODIFIER attributeModifier ValueAssignment )
            {
                // com/lambda/impex/ast/Impex.g:327:5: ^( MODIFIER attributeModifier ValueAssignment )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(MODIFIER, "MODIFIER")
                , root_1);

                adaptor.addChild(root_1, stream_attributeModifier.nextTree());

                adaptor.addChild(root_1, 
                stream_ValueAssignment.nextNode()
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
    // $ANTLR end "attributeModifierAssignment"


    public static class attributeModifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "attributeModifier"
    // com/lambda/impex/ast/Impex.g:332:1: attributeModifier : ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual );
    public final ImpexParser.attributeModifier_return attributeModifier() throws RecognitionException {
        ImpexParser.attributeModifier_return retval = new ImpexParser.attributeModifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set59=null;

        CommonTree set59_tree=null;

        try {
            // com/lambda/impex/ast/Impex.g:333:2: ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual )
            // com/lambda/impex/ast/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set59=(Token)input.LT(1);

            if ( (input.LA(1) >= Alias && input.LA(1) <= AllowNull)||input.LA(1)==CellDecorator||input.LA(1)==CollectionDelimiter||(input.LA(1) >= Dateformat && input.LA(1) <= Default)||input.LA(1)==ForceWrite||(input.LA(1) >= IgnoreKeyCase && input.LA(1) <= IgnoreNull)||input.LA(1)==KeyToValueDelimiter||input.LA(1)==Lang||(input.LA(1) >= MapDelimiter && input.LA(1) <= NumberFormat)||(input.LA(1) >= PathDelimiter && input.LA(1) <= Pos)||(input.LA(1) >= Translator && input.LA(1) <= Unique)||input.LA(1)==Virtual ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set59)
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
    // com/lambda/impex/ast/Impex.g:336:1: headerMode : ( Insert | InsertUpdate | Update | Remove );
    public final ImpexParser.headerMode_return headerMode() throws RecognitionException {
        ImpexParser.headerMode_return retval = new ImpexParser.headerMode_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set60=null;

        CommonTree set60_tree=null;

        try {
            // com/lambda/impex/ast/Impex.g:337:2: ( Insert | InsertUpdate | Update | Remove )
            // com/lambda/impex/ast/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set60=(Token)input.LT(1);

            if ( (input.LA(1) >= Insert && input.LA(1) <= InsertUpdate)||input.LA(1)==Remove||input.LA(1)==Update ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set60)
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


    public static class headerTypeName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "headerTypeName"
    // com/lambda/impex/ast/Impex.g:339:1: headerTypeName : ( Identifier | headerMode | attributeModifier | headerModifier );
    public final ImpexParser.headerTypeName_return headerTypeName() throws RecognitionException {
        ImpexParser.headerTypeName_return retval = new ImpexParser.headerTypeName_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Identifier61=null;
        ImpexParser.headerMode_return headerMode62 =null;

        ImpexParser.attributeModifier_return attributeModifier63 =null;

        ImpexParser.headerModifier_return headerModifier64 =null;


        CommonTree Identifier61_tree=null;

        try {
            // com/lambda/impex/ast/Impex.g:340:2: ( Identifier | headerMode | attributeModifier | headerModifier )
            int alt25=4;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                alt25=1;
                }
                break;
            case Insert:
            case InsertUpdate:
            case Remove:
            case Update:
                {
                alt25=2;
                }
                break;
            case Alias:
            case AllowNull:
            case CellDecorator:
            case CollectionDelimiter:
            case Dateformat:
            case Default:
            case ForceWrite:
            case IgnoreKeyCase:
            case IgnoreNull:
            case KeyToValueDelimiter:
            case Lang:
            case MapDelimiter:
            case Mode:
            case NumberFormat:
            case PathDelimiter:
            case Pos:
            case Translator:
            case Unique:
            case Virtual:
                {
                alt25=3;
                }
                break;
            case BatchMode:
            case CacheUnique:
            case Processor:
                {
                alt25=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;

            }

            switch (alt25) {
                case 1 :
                    // com/lambda/impex/ast/Impex.g:340:3: Identifier
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    Identifier61=(Token)match(input,Identifier,FOLLOW_Identifier_in_headerTypeName824); 
                    Identifier61_tree = 
                    (CommonTree)adaptor.create(Identifier61)
                    ;
                    adaptor.addChild(root_0, Identifier61_tree);


                    }
                    break;
                case 2 :
                    // com/lambda/impex/ast/Impex.g:340:16: headerMode
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_headerMode_in_headerTypeName828);
                    headerMode62=headerMode();

                    state._fsp--;

                    adaptor.addChild(root_0, headerMode62.getTree());

                    }
                    break;
                case 3 :
                    // com/lambda/impex/ast/Impex.g:340:29: attributeModifier
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_attributeModifier_in_headerTypeName832);
                    attributeModifier63=attributeModifier();

                    state._fsp--;

                    adaptor.addChild(root_0, attributeModifier63.getTree());

                    }
                    break;
                case 4 :
                    // com/lambda/impex/ast/Impex.g:340:49: headerModifier
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_headerModifier_in_headerTypeName836);
                    headerModifier64=headerModifier();

                    state._fsp--;

                    adaptor.addChild(root_0, headerModifier64.getTree());

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
    // $ANTLR end "headerTypeName"


    public static class macro_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "macro"
    // com/lambda/impex/ast/Impex.g:352:1: macro : Macrodef ( ValueAssignment | Equals ) ;
    public final ImpexParser.macro_return macro() throws RecognitionException {
        ImpexParser.macro_return retval = new ImpexParser.macro_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Macrodef65=null;
        Token ValueAssignment66=null;
        Token Equals67=null;

        CommonTree Macrodef65_tree=null;
        CommonTree ValueAssignment66_tree=null;
        CommonTree Equals67_tree=null;

        try {
            // com/lambda/impex/ast/Impex.g:353:2: ( Macrodef ( ValueAssignment | Equals ) )
            // com/lambda/impex/ast/Impex.g:353:3: Macrodef ( ValueAssignment | Equals )
            {
            root_0 = (CommonTree)adaptor.nil();


            Macrodef65=(Token)match(input,Macrodef,FOLLOW_Macrodef_in_macro854); 
            Macrodef65_tree = 
            (CommonTree)adaptor.create(Macrodef65)
            ;
            adaptor.addChild(root_0, Macrodef65_tree);


            // com/lambda/impex/ast/Impex.g:354:2: ( ValueAssignment | Equals )
            int alt26=2;
            switch ( input.LA(1) ) {
            case ValueAssignment:
                {
                alt26=1;
                }
                break;
            case Equals:
                {
                alt26=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;

            }

            switch (alt26) {
                case 1 :
                    // com/lambda/impex/ast/Impex.g:354:3: ValueAssignment
                    {
                    ValueAssignment66=(Token)match(input,ValueAssignment,FOLLOW_ValueAssignment_in_macro859); 
                    ValueAssignment66_tree = 
                    (CommonTree)adaptor.create(ValueAssignment66)
                    ;
                    adaptor.addChild(root_0, ValueAssignment66_tree);


                    context.registerMacro(Macrodef65, (ValueAssignment66!=null?ValueAssignment66.getText():null));

                    }
                    break;
                case 2 :
                    // com/lambda/impex/ast/Impex.g:355:3: Equals
                    {
                    Equals67=(Token)match(input,Equals,FOLLOW_Equals_in_macro866); 
                    Equals67_tree = 
                    (CommonTree)adaptor.create(Equals67)
                    ;
                    adaptor.addChild(root_0, Equals67_tree);


                    context.registerMacro(Macrodef65, "");

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

    // Delegated rules


    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA7_eotS =
        "\10\uffff";
    static final String DFA7_eofS =
        "\1\1\1\uffff\1\1\2\uffff\3\1";
    static final String DFA7_minS =
        "\1\46\1\uffff\1\36\1\34\1\uffff\3\36";
    static final String DFA7_maxS =
        "\1\106\1\uffff\1\106\1\110\1\uffff\3\106";
    static final String DFA7_acceptS =
        "\1\uffff\1\2\2\uffff\1\1\3\uffff";
    static final String DFA7_specialS =
        "\10\uffff}>";
    static final String[] DFA7_transitionS = {
            "\2\1\4\uffff\1\2\3\uffff\1\1\15\uffff\1\1\7\uffff\1\1",
            "",
            "\1\4\4\uffff\1\4\2\uffff\2\1\4\uffff\1\2\3\uffff\1\3\10\uffff"+
            "\1\4\4\uffff\1\1\7\uffff\1\1",
            "\1\6\53\uffff\1\5",
            "",
            "\1\4\4\uffff\1\4\2\uffff\2\1\4\uffff\1\7\3\uffff\1\3\10\uffff"+
            "\1\4\4\uffff\1\1\7\uffff\1\1",
            "\1\4\4\uffff\1\4\2\uffff\2\1\4\uffff\1\7\3\uffff\1\3\10\uffff"+
            "\1\4\4\uffff\1\1\7\uffff\1\1",
            "\1\4\4\uffff\1\4\2\uffff\2\1\4\uffff\1\7\3\uffff\1\3\10\uffff"+
            "\1\4\4\uffff\1\1\7\uffff\1\1"
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "()* loopback of 266:17: ( ( ( Lb )+ ( macro ( Lb )* )* record ) )*";
        }
    }
 

    public static final BitSet FOLLOW_EOF_in_parse178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sync_in_impex197 = new BitSet(new long[]{0x400110C000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_Lb_in_impex201 = new BitSet(new long[]{0x400110C000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_block_in_impex206 = new BitSet(new long[]{0x400110C000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_macro_in_impex210 = new BitSet(new long[]{0x400110C000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_sync_in_impex214 = new BitSet(new long[]{0x400110C000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_EOF_in_impex218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_header_in_block249 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_Lb_in_block255 = new BitSet(new long[]{0x0201100840000000L});
    public static final BitSet FOLLOW_macro_in_block261 = new BitSet(new long[]{0x0201100840000000L});
    public static final BitSet FOLLOW_Lb_in_block265 = new BitSet(new long[]{0x0201100840000000L});
    public static final BitSet FOLLOW_record_in_block272 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_headerMode_in_header301 = new BitSet(new long[]{0x40EE09F88184C980L,0x0000000000000270L});
    public static final BitSet FOLLOW_headerTypeName_in_header304 = new BitSet(new long[]{0x0000020000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_LBracket_in_header307 = new BitSet(new long[]{0x0080000000004800L});
    public static final BitSet FOLLOW_headerModifierAssignment_in_header309 = new BitSet(new long[]{0x0400000000080000L});
    public static final BitSet FOLLOW_Comma_in_header312 = new BitSet(new long[]{0x0080000000004800L});
    public static final BitSet FOLLOW_headerModifierAssignment_in_header315 = new BitSet(new long[]{0x0400000000080000L});
    public static final BitSet FOLLOW_RBracket_in_header319 = new BitSet(new long[]{0x0000020000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_Semicolon_in_header325 = new BitSet(new long[]{0x0101060808000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_attribute_in_header328 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_quote_in_header332 = new BitSet(new long[]{0x0001060800000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_attribute_in_header334 = new BitSet(new long[]{0x0100000008000000L});
    public static final BitSet FOLLOW_quote_in_header336 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_Semicolon_in_header342 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_DocumentID_in_header344 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_Semicolon_in_header348 = new BitSet(new long[]{0x0101060808000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_attribute_in_header351 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_quote_in_header355 = new BitSet(new long[]{0x0001060800000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_attribute_in_header357 = new BitSet(new long[]{0x0100000008000000L});
    public static final BitSet FOLLOW_quote_in_header359 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_headerModifier_in_headerModifierAssignment420 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ValueAssignment_in_headerModifierAssignment422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_record462 = new BitSet(new long[]{0x0200000040000000L});
    public static final BitSet FOLLOW_field_in_record466 = new BitSet(new long[]{0x0200000040000002L});
    public static final BitSet FOLLOW_Macrodef_in_attributeName545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SpecialAttribute_in_attributeName559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_attributeName572 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_Dot_in_attributeName575 = new BitSet(new long[]{0x0001000800000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_attributeName_in_attributeName577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeName_in_attribute612 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_LParenthesis_in_attribute615 = new BitSet(new long[]{0x0001060802000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_DocumentID_in_attribute619 = new BitSet(new long[]{0x2000000000080000L});
    public static final BitSet FOLLOW_attribute_in_attribute623 = new BitSet(new long[]{0x2000000000080000L});
    public static final BitSet FOLLOW_Comma_in_attribute626 = new BitSet(new long[]{0x0001060802000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_DocumentID_in_attribute629 = new BitSet(new long[]{0x2000000000080000L});
    public static final BitSet FOLLOW_attribute_in_attribute633 = new BitSet(new long[]{0x2000000000080000L});
    public static final BitSet FOLLOW_RParenthesis_in_attribute638 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_LBracket_in_attribute644 = new BitSet(new long[]{0x006E093081848180L,0x0000000000000230L});
    public static final BitSet FOLLOW_attributeModifierAssignment_in_attribute646 = new BitSet(new long[]{0x0400000000080000L});
    public static final BitSet FOLLOW_Comma_in_attribute649 = new BitSet(new long[]{0x006E093081848180L,0x0000000000000230L});
    public static final BitSet FOLLOW_attributeModifierAssignment_in_attribute652 = new BitSet(new long[]{0x0400000000080000L});
    public static final BitSet FOLLOW_RBracket_in_attribute656 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_attributeModifier_in_attributeModifierAssignment697 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ValueAssignment_in_attributeModifierAssignment699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_headerTypeName824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_headerMode_in_headerTypeName828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeModifier_in_headerTypeName832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_headerModifier_in_headerTypeName836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Macrodef_in_macro854 = new BitSet(new long[]{0x0000000010000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ValueAssignment_in_macro859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Equals_in_macro866 = new BitSet(new long[]{0x0000000000000002L});

}