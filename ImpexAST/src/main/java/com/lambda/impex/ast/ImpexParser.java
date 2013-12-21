// $ANTLR 3.4 com/lambda/impex/ast/Impex.g 2013-02-04 22:08:36

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
//import com.lambda.impex.ast.tree.*;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class ImpexParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTRIBUTE", "ATTRIBUTES", "ATTRIBUTE_NAME", "Alias", "AllowNull", "BLOCK", "BLOCKS", "BatchMode", "BeanShell", "CacheUnique", "CellDecorator", "Char", "CollectionDelimiter", "Comma", "Comment", "Dateformat", "Default", "DocumentID", "Dot", "DoubleQuote", "Equals", "FIELDS", "Field", "ForceWrite", "HEADER", "IMPEX", "ITEM_EXPRESSION", "Identifier", "IgnoreKeyCase", "IgnoreNull", "Insert", "InsertUpdate", "KeyToValueDelimiter", "LBracket", "LParenthesis", "Lang", "Lb", "MACRO_REF", "MODIFIER", "MODIFIERS", "Macrodef", "MapDelimiter", "Mode", "NumberFormat", "Or", "PathDelimiter", "Pos", "Processor", "Quote", "QuotedField", "RBracket", "RECORD", "RECORDS", "RParenthesis", "Remove", "SUBTYPE", "Semicolon", "Separator", "SpecialAttribute", "TYPE", "Translator", "Unique", "Update", "UserRights", "ValueAssignment", "Virtual", "Ws"
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
    public static final int CacheUnique=13;
    public static final int CellDecorator=14;
    public static final int Char=15;
    public static final int CollectionDelimiter=16;
    public static final int Comma=17;
    public static final int Comment=18;
    public static final int Dateformat=19;
    public static final int Default=20;
    public static final int DocumentID=21;
    public static final int Dot=22;
    public static final int DoubleQuote=23;
    public static final int Equals=24;
    public static final int FIELDS=25;
    public static final int Field=26;
    public static final int ForceWrite=27;
    public static final int HEADER=28;
    public static final int IMPEX=29;
    public static final int ITEM_EXPRESSION=30;
    public static final int Identifier=31;
    public static final int IgnoreKeyCase=32;
    public static final int IgnoreNull=33;
    public static final int Insert=34;
    public static final int InsertUpdate=35;
    public static final int KeyToValueDelimiter=36;
    public static final int LBracket=37;
    public static final int LParenthesis=38;
    public static final int Lang=39;
    public static final int Lb=40;
    public static final int MACRO_REF=41;
    public static final int MODIFIER=42;
    public static final int MODIFIERS=43;
    public static final int Macrodef=44;
    public static final int MapDelimiter=45;
    public static final int Mode=46;
    public static final int NumberFormat=47;
    public static final int Or=48;
    public static final int PathDelimiter=49;
    public static final int Pos=50;
    public static final int Processor=51;
    public static final int Quote=52;
    public static final int QuotedField=53;
    public static final int RBracket=54;
    public static final int RECORD=55;
    public static final int RECORDS=56;
    public static final int RParenthesis=57;
    public static final int Remove=58;
    public static final int SUBTYPE=59;
    public static final int Semicolon=60;
    public static final int Separator=61;
    public static final int SpecialAttribute=62;
    public static final int TYPE=63;
    public static final int Translator=64;
    public static final int Unique=65;
    public static final int Update=66;
    public static final int UserRights=67;
    public static final int ValueAssignment=68;
    public static final int Virtual=69;
    public static final int Ws=70;

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

    public ImpexParser(final ImpexContext context, final TokenStream input) {
       this(input);
       this.context = context;
    }

    @Override
    public void reportError(final RecognitionException e) {
        if ( state.errorRecovery ) {
            return;
        }
        context.registerProblem( (CommonToken)e.token);
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
                        context.registerProblem(token);
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
    // com/lambda/impex/ast/Impex.g:245:1: parse : (t= . )* EOF ;
    public final ImpexParser.parse_return parse() throws RecognitionException {
        ImpexParser.parse_return retval = new ImpexParser.parse_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token t=null;
        Token EOF1=null;

        CommonTree t_tree=null;
        CommonTree EOF1_tree=null;

        try {
            // com/lambda/impex/ast/Impex.g:246:3: ( (t= . )* EOF )
            // com/lambda/impex/ast/Impex.g:246:6: (t= . )* EOF
            {
            root_0 = (CommonTree)adaptor.nil();


            // com/lambda/impex/ast/Impex.g:246:6: (t= . )*
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
                case CacheUnique:
                case CellDecorator:
                case Char:
                case CollectionDelimiter:
                case Comma:
                case Comment:
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
            	    // com/lambda/impex/ast/Impex.g:246:7: t= .
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


            EOF1=(Token)match(input,EOF,FOLLOW_EOF_in_parse166); 
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
    // com/lambda/impex/ast/Impex.g:254:1: impex : ( ( Lb | macro |v+= block ) )* EOF -> ^( IMPEX ^( BLOCKS ( block )* ) ) ;
    public final ImpexParser.impex_return impex() throws RecognitionException {
        ImpexParser.impex_return retval = new ImpexParser.impex_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Lb2=null;
        Token EOF4=null;
        List list_v=null;
        ImpexParser.macro_return macro3 =null;

        RuleReturnScope v = null;
        CommonTree Lb2_tree=null;
        CommonTree EOF4_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleTokenStream stream_Lb=new RewriteRuleTokenStream(adaptor,"token Lb");
        RewriteRuleSubtreeStream stream_macro=new RewriteRuleSubtreeStream(adaptor,"rule macro");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // com/lambda/impex/ast/Impex.g:254:7: ( ( ( Lb | macro |v+= block ) )* EOF -> ^( IMPEX ^( BLOCKS ( block )* ) ) )
            // com/lambda/impex/ast/Impex.g:254:18: ( ( Lb | macro |v+= block ) )* EOF
            {
            // com/lambda/impex/ast/Impex.g:254:18: ( ( Lb | macro |v+= block ) )*
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
            	    // com/lambda/impex/ast/Impex.g:254:19: ( Lb | macro |v+= block )
            	    {
            	    // com/lambda/impex/ast/Impex.g:254:19: ( Lb | macro |v+= block )
            	    int alt2=3;
            	    switch ( input.LA(1) ) {
            	    case Lb:
            	        {
            	        alt2=1;
            	        }
            	        break;
            	    case Macrodef:
            	        {
            	        alt2=2;
            	        }
            	        break;
            	    case Insert:
            	    case InsertUpdate:
            	    case Remove:
            	    case Update:
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
            	            // com/lambda/impex/ast/Impex.g:254:21: Lb
            	            {
            	            Lb2=(Token)match(input,Lb,FOLLOW_Lb_in_impex185);  
            	            stream_Lb.add(Lb2);


            	            }
            	            break;
            	        case 2 :
            	            // com/lambda/impex/ast/Impex.g:254:26: macro
            	            {
            	            pushFollow(FOLLOW_macro_in_impex189);
            	            macro3=macro();

            	            state._fsp--;

            	            stream_macro.add(macro3.getTree());

            	            }
            	            break;
            	        case 3 :
            	            // com/lambda/impex/ast/Impex.g:254:35: v+= block
            	            {
            	            pushFollow(FOLLOW_block_in_impex196);
            	            v=block();

            	            state._fsp--;

            	            stream_block.add(v.getTree());
            	            if (list_v==null) list_v=new ArrayList();
            	            list_v.add(v.getTree());


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            EOF4=(Token)match(input,EOF,FOLLOW_EOF_in_impex204);  
            stream_EOF.add(EOF4);


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
            // 255:3: -> ^( IMPEX ^( BLOCKS ( block )* ) )
            {
                // com/lambda/impex/ast/Impex.g:255:6: ^( IMPEX ^( BLOCKS ( block )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IMPEX, "IMPEX")
                , root_1);

                // com/lambda/impex/ast/Impex.g:255:29: ^( BLOCKS ( block )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCKS, "BLOCKS")
                , root_2);

                // com/lambda/impex/ast/Impex.g:255:38: ( block )*
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
    // com/lambda/impex/ast/Impex.g:262:1: block : header ( ( ( Lb )+ ( macro ( Lb )* )* record ) )* -> ^( BLOCK header ^( RECORDS ( record )* ) ) ;
    public final ImpexParser.block_return block() throws RecognitionException {
        ImpexParser.block_return retval = new ImpexParser.block_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Lb6=null;
        Token Lb8=null;
        ImpexParser.header_return header5 =null;

        ImpexParser.macro_return macro7 =null;

        ImpexParser.record_return record9 =null;


        CommonTree Lb6_tree=null;
        CommonTree Lb8_tree=null;
        RewriteRuleTokenStream stream_Lb=new RewriteRuleTokenStream(adaptor,"token Lb");
        RewriteRuleSubtreeStream stream_record=new RewriteRuleSubtreeStream(adaptor,"rule record");
        RewriteRuleSubtreeStream stream_macro=new RewriteRuleSubtreeStream(adaptor,"rule macro");
        RewriteRuleSubtreeStream stream_header=new RewriteRuleSubtreeStream(adaptor,"rule header");
        try {
            // com/lambda/impex/ast/Impex.g:262:7: ( header ( ( ( Lb )+ ( macro ( Lb )* )* record ) )* -> ^( BLOCK header ^( RECORDS ( record )* ) ) )
            // com/lambda/impex/ast/Impex.g:262:10: header ( ( ( Lb )+ ( macro ( Lb )* )* record ) )*
            {
            pushFollow(FOLLOW_header_in_block236);
            header5=header();

            state._fsp--;

            stream_header.add(header5.getTree());

            // com/lambda/impex/ast/Impex.g:262:18: ( ( ( Lb )+ ( macro ( Lb )* )* record ) )*
            loop7:
            do {
                int alt7=2;
                alt7 = dfa7.predict(input);
                switch (alt7) {
            	case 1 :
            	    // com/lambda/impex/ast/Impex.g:262:19: ( ( Lb )+ ( macro ( Lb )* )* record )
            	    {
            	    // com/lambda/impex/ast/Impex.g:262:19: ( ( Lb )+ ( macro ( Lb )* )* record )
            	    // com/lambda/impex/ast/Impex.g:262:20: ( Lb )+ ( macro ( Lb )* )* record
            	    {
            	    // com/lambda/impex/ast/Impex.g:262:20: ( Lb )+
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
            	    	    // com/lambda/impex/ast/Impex.g:262:20: Lb
            	    	    {
            	    	    Lb6=(Token)match(input,Lb,FOLLOW_Lb_in_block241);  
            	    	    stream_Lb.add(Lb6);


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


            	    // com/lambda/impex/ast/Impex.g:262:24: ( macro ( Lb )* )*
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
            	    	    // com/lambda/impex/ast/Impex.g:262:25: macro ( Lb )*
            	    	    {
            	    	    pushFollow(FOLLOW_macro_in_block245);
            	    	    macro7=macro();

            	    	    state._fsp--;

            	    	    stream_macro.add(macro7.getTree());

            	    	    // com/lambda/impex/ast/Impex.g:262:32: ( Lb )*
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
            	    	    	    // com/lambda/impex/ast/Impex.g:262:32: Lb
            	    	    	    {
            	    	    	    Lb8=(Token)match(input,Lb,FOLLOW_Lb_in_block248);  
            	    	    	    stream_Lb.add(Lb8);


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


            	    pushFollow(FOLLOW_record_in_block253);
            	    record9=record();

            	    state._fsp--;

            	    stream_record.add(record9.getTree());

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
            // 269:2: -> ^( BLOCK header ^( RECORDS ( record )* ) )
            {
                // com/lambda/impex/ast/Impex.g:269:5: ^( BLOCK header ^( RECORDS ( record )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCK, "BLOCK")
                , root_1);

                adaptor.addChild(root_1, stream_header.nextTree());

                // com/lambda/impex/ast/Impex.g:269:35: ^( RECORDS ( record )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(RECORDS, "RECORDS")
                , root_2);

                // com/lambda/impex/ast/Impex.g:269:61: ( record )*
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
    // com/lambda/impex/ast/Impex.g:271:1: header : headerMode headerTypeName ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )* ( Semicolon attribute )* -> ^( HEADER headerMode ^( TYPE headerTypeName ) ^( MODIFIERS ( headerModifierAssignment )* ) ^( ATTRIBUTES ( attribute )* ) ) ;
    public final ImpexParser.header_return header() throws RecognitionException {
        ImpexParser.header_return retval = new ImpexParser.header_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token LBracket12=null;
        Token Comma14=null;
        Token RBracket16=null;
        Token Semicolon17=null;
        ImpexParser.headerMode_return headerMode10 =null;

        ImpexParser.headerTypeName_return headerTypeName11 =null;

        ImpexParser.headerModifierAssignment_return headerModifierAssignment13 =null;

        ImpexParser.headerModifierAssignment_return headerModifierAssignment15 =null;

        ImpexParser.attribute_return attribute18 =null;


        CommonTree LBracket12_tree=null;
        CommonTree Comma14_tree=null;
        CommonTree RBracket16_tree=null;
        CommonTree Semicolon17_tree=null;
        RewriteRuleTokenStream stream_RBracket=new RewriteRuleTokenStream(adaptor,"token RBracket");
        RewriteRuleTokenStream stream_LBracket=new RewriteRuleTokenStream(adaptor,"token LBracket");
        RewriteRuleTokenStream stream_Semicolon=new RewriteRuleTokenStream(adaptor,"token Semicolon");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleSubtreeStream stream_headerMode=new RewriteRuleSubtreeStream(adaptor,"rule headerMode");
        RewriteRuleSubtreeStream stream_headerModifierAssignment=new RewriteRuleSubtreeStream(adaptor,"rule headerModifierAssignment");
        RewriteRuleSubtreeStream stream_headerTypeName=new RewriteRuleSubtreeStream(adaptor,"rule headerTypeName");
        RewriteRuleSubtreeStream stream_attribute=new RewriteRuleSubtreeStream(adaptor,"rule attribute");
        try {
            // com/lambda/impex/ast/Impex.g:272:2: ( headerMode headerTypeName ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )* ( Semicolon attribute )* -> ^( HEADER headerMode ^( TYPE headerTypeName ) ^( MODIFIERS ( headerModifierAssignment )* ) ^( ATTRIBUTES ( attribute )* ) ) )
            // com/lambda/impex/ast/Impex.g:272:4: headerMode headerTypeName ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )* ( Semicolon attribute )*
            {
            pushFollow(FOLLOW_headerMode_in_header290);
            headerMode10=headerMode();

            state._fsp--;

            stream_headerMode.add(headerMode10.getTree());

            pushFollow(FOLLOW_headerTypeName_in_header293);
            headerTypeName11=headerTypeName();

            state._fsp--;

            stream_headerTypeName.add(headerTypeName11.getTree());

            // com/lambda/impex/ast/Impex.g:272:31: ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )*
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
            	    // com/lambda/impex/ast/Impex.g:272:32: LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket
            	    {
            	    LBracket12=(Token)match(input,LBracket,FOLLOW_LBracket_in_header296);  
            	    stream_LBracket.add(LBracket12);


            	    pushFollow(FOLLOW_headerModifierAssignment_in_header298);
            	    headerModifierAssignment13=headerModifierAssignment();

            	    state._fsp--;

            	    stream_headerModifierAssignment.add(headerModifierAssignment13.getTree());

            	    // com/lambda/impex/ast/Impex.g:272:66: ( Comma headerModifierAssignment )*
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
            	    	    // com/lambda/impex/ast/Impex.g:272:67: Comma headerModifierAssignment
            	    	    {
            	    	    Comma14=(Token)match(input,Comma,FOLLOW_Comma_in_header301);  
            	    	    stream_Comma.add(Comma14);


            	    	    pushFollow(FOLLOW_headerModifierAssignment_in_header304);
            	    	    headerModifierAssignment15=headerModifierAssignment();

            	    	    state._fsp--;

            	    	    stream_headerModifierAssignment.add(headerModifierAssignment15.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop8;
            	        }
            	    } while (true);


            	    RBracket16=(Token)match(input,RBracket,FOLLOW_RBracket_in_header308);  
            	    stream_RBracket.add(RBracket16);


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            // com/lambda/impex/ast/Impex.g:272:113: ( Semicolon attribute )*
            loop10:
            do {
                int alt10=2;
                switch ( input.LA(1) ) {
                case Semicolon:
                    {
                    alt10=1;
                    }
                    break;

                }

                switch (alt10) {
            	case 1 :
            	    // com/lambda/impex/ast/Impex.g:272:114: Semicolon attribute
            	    {
            	    Semicolon17=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_header314);  
            	    stream_Semicolon.add(Semicolon17);


            	    pushFollow(FOLLOW_attribute_in_header316);
            	    attribute18=attribute();

            	    state._fsp--;

            	    stream_attribute.add(attribute18.getTree());

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            // AST REWRITE
            // elements: headerModifierAssignment, attribute, headerTypeName, headerMode
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 273:2: -> ^( HEADER headerMode ^( TYPE headerTypeName ) ^( MODIFIERS ( headerModifierAssignment )* ) ^( ATTRIBUTES ( attribute )* ) )
            {
                // com/lambda/impex/ast/Impex.g:273:5: ^( HEADER headerMode ^( TYPE headerTypeName ) ^( MODIFIERS ( headerModifierAssignment )* ) ^( ATTRIBUTES ( attribute )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(HEADER, "HEADER")
                , root_1);

                adaptor.addChild(root_1, stream_headerMode.nextTree());

                // com/lambda/impex/ast/Impex.g:273:25: ^( TYPE headerTypeName )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(TYPE, "TYPE")
                , root_2);

                adaptor.addChild(root_2, stream_headerTypeName.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                // com/lambda/impex/ast/Impex.g:273:48: ^( MODIFIERS ( headerModifierAssignment )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(MODIFIERS, "MODIFIERS")
                , root_2);

                // com/lambda/impex/ast/Impex.g:273:60: ( headerModifierAssignment )*
                while ( stream_headerModifierAssignment.hasNext() ) {
                    adaptor.addChild(root_2, stream_headerModifierAssignment.nextTree());

                }
                stream_headerModifierAssignment.reset();

                adaptor.addChild(root_1, root_2);
                }

                // com/lambda/impex/ast/Impex.g:273:87: ^( ATTRIBUTES ( attribute )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ATTRIBUTES, "ATTRIBUTES")
                , root_2);

                // com/lambda/impex/ast/Impex.g:273:100: ( attribute )*
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
    // com/lambda/impex/ast/Impex.g:275:1: quote : ( DoubleQuote | Quote );
    public final ImpexParser.quote_return quote() throws RecognitionException {
        ImpexParser.quote_return retval = new ImpexParser.quote_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set19=null;

        CommonTree set19_tree=null;

        try {
            // com/lambda/impex/ast/Impex.g:275:7: ( DoubleQuote | Quote )
            // com/lambda/impex/ast/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set19=(Token)input.LT(1);

            if ( input.LA(1)==DoubleQuote||input.LA(1)==Quote ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set19)
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
    // com/lambda/impex/ast/Impex.g:277:1: headerModifierAssignment : headerModifier ValueAssignment -> ^( MODIFIER headerModifier ValueAssignment ) ;
    public final ImpexParser.headerModifierAssignment_return headerModifierAssignment() throws RecognitionException {
        ImpexParser.headerModifierAssignment_return retval = new ImpexParser.headerModifierAssignment_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ValueAssignment21=null;
        ImpexParser.headerModifier_return headerModifier20 =null;


        CommonTree ValueAssignment21_tree=null;
        RewriteRuleTokenStream stream_ValueAssignment=new RewriteRuleTokenStream(adaptor,"token ValueAssignment");
        RewriteRuleSubtreeStream stream_headerModifier=new RewriteRuleSubtreeStream(adaptor,"rule headerModifier");
        try {
            // com/lambda/impex/ast/Impex.g:277:25: ( headerModifier ValueAssignment -> ^( MODIFIER headerModifier ValueAssignment ) )
            // com/lambda/impex/ast/Impex.g:277:27: headerModifier ValueAssignment
            {
            pushFollow(FOLLOW_headerModifier_in_headerModifierAssignment367);
            headerModifier20=headerModifier();

            state._fsp--;

            stream_headerModifier.add(headerModifier20.getTree());

            ValueAssignment21=(Token)match(input,ValueAssignment,FOLLOW_ValueAssignment_in_headerModifierAssignment369);  
            stream_ValueAssignment.add(ValueAssignment21);


            // AST REWRITE
            // elements: headerModifier, ValueAssignment
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 278:2: -> ^( MODIFIER headerModifier ValueAssignment )
            {
                // com/lambda/impex/ast/Impex.g:278:5: ^( MODIFIER headerModifier ValueAssignment )
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
    // com/lambda/impex/ast/Impex.g:280:1: headerModifier : ( BatchMode | CacheUnique | Processor );
    public final ImpexParser.headerModifier_return headerModifier() throws RecognitionException {
        ImpexParser.headerModifier_return retval = new ImpexParser.headerModifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set22=null;

        CommonTree set22_tree=null;

        try {
            // com/lambda/impex/ast/Impex.g:281:2: ( BatchMode | CacheUnique | Processor )
            // com/lambda/impex/ast/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set22=(Token)input.LT(1);

            if ( input.LA(1)==BatchMode||input.LA(1)==CacheUnique||input.LA(1)==Processor ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set22)
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
    // com/lambda/impex/ast/Impex.g:284:1: record : ( Identifier )? ( field )+ -> ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) ) ;
    public final ImpexParser.record_return record() throws RecognitionException {
        ImpexParser.record_return retval = new ImpexParser.record_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Identifier23=null;
        ImpexParser.field_return field24 =null;


        CommonTree Identifier23_tree=null;
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_field=new RewriteRuleSubtreeStream(adaptor,"rule field");
        try {
            // com/lambda/impex/ast/Impex.g:285:5: ( ( Identifier )? ( field )+ -> ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) ) )
            // com/lambda/impex/ast/Impex.g:285:16: ( Identifier )? ( field )+
            {
            // com/lambda/impex/ast/Impex.g:285:16: ( Identifier )?
            int alt11=2;
            switch ( input.LA(1) ) {
                case Identifier:
                    {
                    alt11=1;
                    }
                    break;
            }

            switch (alt11) {
                case 1 :
                    // com/lambda/impex/ast/Impex.g:285:17: Identifier
                    {
                    Identifier23=(Token)match(input,Identifier,FOLLOW_Identifier_in_record412);  
                    stream_Identifier.add(Identifier23);


                    }
                    break;

            }


            // com/lambda/impex/ast/Impex.g:285:39: ( field )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                switch ( input.LA(1) ) {
                case Field:
                case QuotedField:
                    {
                    alt12=1;
                    }
                    break;

                }

                switch (alt12) {
            	case 1 :
            	    // com/lambda/impex/ast/Impex.g:285:40: field
            	    {
            	    pushFollow(FOLLOW_field_in_record419);
            	    field24=field();

            	    state._fsp--;

            	    stream_field.add(field24.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            // AST REWRITE
            // elements: Identifier, field
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 286:6: -> ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) )
            {
                // com/lambda/impex/ast/Impex.g:286:9: ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(RECORD, "RECORD")
                , root_1);

                // com/lambda/impex/ast/Impex.g:286:18: ^( SUBTYPE ( Identifier )? )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(SUBTYPE, "SUBTYPE")
                , root_2);

                // com/lambda/impex/ast/Impex.g:286:28: ( Identifier )?
                if ( stream_Identifier.hasNext() ) {
                    adaptor.addChild(root_2, 
                    stream_Identifier.nextNode()
                    );

                }
                stream_Identifier.reset();

                adaptor.addChild(root_1, root_2);
                }

                // com/lambda/impex/ast/Impex.g:286:41: ^( FIELDS ( field )+ )
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


    public static class field_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field"
    // com/lambda/impex/ast/Impex.g:292:1: field : ( QuotedField | Field );
    public final ImpexParser.field_return field() throws RecognitionException {
        ImpexParser.field_return retval = new ImpexParser.field_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set25=null;

        CommonTree set25_tree=null;

        try {
            // com/lambda/impex/ast/Impex.g:292:7: ( QuotedField | Field )
            // com/lambda/impex/ast/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set25=(Token)input.LT(1);

            if ( input.LA(1)==Field||input.LA(1)==QuotedField ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set25)
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


    public static class attribute_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "attribute"
    // com/lambda/impex/ast/Impex.g:294:1: attribute : ( attributeValue | quote attributeValue quote -> attributeValue );
    public final ImpexParser.attribute_return attribute() throws RecognitionException {
        ImpexParser.attribute_return retval = new ImpexParser.attribute_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        ImpexParser.attributeValue_return attributeValue26 =null;

        ImpexParser.quote_return quote27 =null;

        ImpexParser.attributeValue_return attributeValue28 =null;

        ImpexParser.quote_return quote29 =null;


        RewriteRuleSubtreeStream stream_attributeValue=new RewriteRuleSubtreeStream(adaptor,"rule attributeValue");
        RewriteRuleSubtreeStream stream_quote=new RewriteRuleSubtreeStream(adaptor,"rule quote");
        try {
            // com/lambda/impex/ast/Impex.g:294:11: ( attributeValue | quote attributeValue quote -> attributeValue )
            int alt13=2;
            switch ( input.LA(1) ) {
            case EOF:
            case DocumentID:
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
                alt13=1;
                }
                break;
            case DoubleQuote:
            case Quote:
                {
                alt13=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }

            switch (alt13) {
                case 1 :
                    // com/lambda/impex/ast/Impex.g:294:12: attributeValue
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_attributeValue_in_attribute471);
                    attributeValue26=attributeValue();

                    state._fsp--;

                    adaptor.addChild(root_0, attributeValue26.getTree());

                    }
                    break;
                case 2 :
                    // com/lambda/impex/ast/Impex.g:294:29: quote attributeValue quote
                    {
                    pushFollow(FOLLOW_quote_in_attribute475);
                    quote27=quote();

                    state._fsp--;

                    stream_quote.add(quote27.getTree());

                    pushFollow(FOLLOW_attributeValue_in_attribute477);
                    attributeValue28=attributeValue();

                    state._fsp--;

                    stream_attributeValue.add(attributeValue28.getTree());

                    pushFollow(FOLLOW_quote_in_attribute479);
                    quote29=quote();

                    state._fsp--;

                    stream_quote.add(quote29.getTree());

                    // AST REWRITE
                    // elements: attributeValue
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 295:2: -> attributeValue
                    {
                        adaptor.addChild(root_0, stream_attributeValue.nextTree());

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
    // $ANTLR end "attribute"


    public static class attributeName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "attributeName"
    // com/lambda/impex/ast/Impex.g:297:1: attributeName : ( Macrodef -> ^( ATTRIBUTE_NAME Macrodef ) | SpecialAttribute -> ^( ATTRIBUTE_NAME SpecialAttribute ) | ( Identifier ( Dot attributeName )? ) -> ^( ATTRIBUTE_NAME Identifier ( attributeName )? ) | -> ^( ATTRIBUTE_NAME ) );
    public final ImpexParser.attributeName_return attributeName() throws RecognitionException {
        ImpexParser.attributeName_return retval = new ImpexParser.attributeName_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Macrodef30=null;
        Token SpecialAttribute31=null;
        Token Identifier32=null;
        Token Dot33=null;
        ImpexParser.attributeName_return attributeName34 =null;


        CommonTree Macrodef30_tree=null;
        CommonTree SpecialAttribute31_tree=null;
        CommonTree Identifier32_tree=null;
        CommonTree Dot33_tree=null;
        RewriteRuleTokenStream stream_Dot=new RewriteRuleTokenStream(adaptor,"token Dot");
        RewriteRuleTokenStream stream_SpecialAttribute=new RewriteRuleTokenStream(adaptor,"token SpecialAttribute");
        RewriteRuleTokenStream stream_Macrodef=new RewriteRuleTokenStream(adaptor,"token Macrodef");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_attributeName=new RewriteRuleSubtreeStream(adaptor,"rule attributeName");
        try {
            // com/lambda/impex/ast/Impex.g:298:2: ( Macrodef -> ^( ATTRIBUTE_NAME Macrodef ) | SpecialAttribute -> ^( ATTRIBUTE_NAME SpecialAttribute ) | ( Identifier ( Dot attributeName )? ) -> ^( ATTRIBUTE_NAME Identifier ( attributeName )? ) | -> ^( ATTRIBUTE_NAME ) )
            int alt15=4;
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
                    alt15=1;
                    }
                    break;
                case Equals:
                case ValueAssignment:
                    {
                    alt15=4;
                    }
                    break;
                default:
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;

                }

                }
                break;
            case SpecialAttribute:
                {
                alt15=2;
                }
                break;
            case Identifier:
                {
                alt15=3;
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
                alt15=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;

            }

            switch (alt15) {
                case 1 :
                    // com/lambda/impex/ast/Impex.g:298:3: Macrodef
                    {
                    Macrodef30=(Token)match(input,Macrodef,FOLLOW_Macrodef_in_attributeName493);  
                    stream_Macrodef.add(Macrodef30);


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
                    // 298:12: -> ^( ATTRIBUTE_NAME Macrodef )
                    {
                        // com/lambda/impex/ast/Impex.g:298:15: ^( ATTRIBUTE_NAME Macrodef )
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
                    // com/lambda/impex/ast/Impex.g:299:4: SpecialAttribute
                    {
                    SpecialAttribute31=(Token)match(input,SpecialAttribute,FOLLOW_SpecialAttribute_in_attributeName507);  
                    stream_SpecialAttribute.add(SpecialAttribute31);


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
                    // 299:21: -> ^( ATTRIBUTE_NAME SpecialAttribute )
                    {
                        // com/lambda/impex/ast/Impex.g:299:24: ^( ATTRIBUTE_NAME SpecialAttribute )
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
                    // com/lambda/impex/ast/Impex.g:300:3: ( Identifier ( Dot attributeName )? )
                    {
                    // com/lambda/impex/ast/Impex.g:300:3: ( Identifier ( Dot attributeName )? )
                    // com/lambda/impex/ast/Impex.g:300:4: Identifier ( Dot attributeName )?
                    {
                    Identifier32=(Token)match(input,Identifier,FOLLOW_Identifier_in_attributeName520);  
                    stream_Identifier.add(Identifier32);


                    // com/lambda/impex/ast/Impex.g:300:15: ( Dot attributeName )?
                    int alt14=2;
                    switch ( input.LA(1) ) {
                        case Dot:
                            {
                            alt14=1;
                            }
                            break;
                    }

                    switch (alt14) {
                        case 1 :
                            // com/lambda/impex/ast/Impex.g:300:16: Dot attributeName
                            {
                            Dot33=(Token)match(input,Dot,FOLLOW_Dot_in_attributeName523);  
                            stream_Dot.add(Dot33);


                            pushFollow(FOLLOW_attributeName_in_attributeName525);
                            attributeName34=attributeName();

                            state._fsp--;

                            stream_attributeName.add(attributeName34.getTree());

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
                    // 300:37: -> ^( ATTRIBUTE_NAME Identifier ( attributeName )? )
                    {
                        // com/lambda/impex/ast/Impex.g:300:40: ^( ATTRIBUTE_NAME Identifier ( attributeName )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(ATTRIBUTE_NAME, "ATTRIBUTE_NAME")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_Identifier.nextNode()
                        );

                        // com/lambda/impex/ast/Impex.g:300:68: ( attributeName )?
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
                    // com/lambda/impex/ast/Impex.g:301:18: 
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
                    // 301:18: -> ^( ATTRIBUTE_NAME )
                    {
                        // com/lambda/impex/ast/Impex.g:301:20: ^( ATTRIBUTE_NAME )
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


    public static class attributeValue_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "attributeValue"
    // com/lambda/impex/ast/Impex.g:303:1: attributeValue : ( DocumentID -> ^( ATTRIBUTE DocumentID ) | attributeName ( LParenthesis attributeValue ( Comma attributeValue )* RParenthesis )? ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket )* -> ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attributeValue )* ) ^( MODIFIERS ( attributeModifierAssignment )* ) ) );
    public final ImpexParser.attributeValue_return attributeValue() throws RecognitionException {
        ImpexParser.attributeValue_return retval = new ImpexParser.attributeValue_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token DocumentID35=null;
        Token LParenthesis37=null;
        Token Comma39=null;
        Token RParenthesis41=null;
        Token LBracket42=null;
        Token Comma44=null;
        Token RBracket46=null;
        ImpexParser.attributeName_return attributeName36 =null;

        ImpexParser.attributeValue_return attributeValue38 =null;

        ImpexParser.attributeValue_return attributeValue40 =null;

        ImpexParser.attributeModifierAssignment_return attributeModifierAssignment43 =null;

        ImpexParser.attributeModifierAssignment_return attributeModifierAssignment45 =null;


        CommonTree DocumentID35_tree=null;
        CommonTree LParenthesis37_tree=null;
        CommonTree Comma39_tree=null;
        CommonTree RParenthesis41_tree=null;
        CommonTree LBracket42_tree=null;
        CommonTree Comma44_tree=null;
        CommonTree RBracket46_tree=null;
        RewriteRuleTokenStream stream_DocumentID=new RewriteRuleTokenStream(adaptor,"token DocumentID");
        RewriteRuleTokenStream stream_RBracket=new RewriteRuleTokenStream(adaptor,"token RBracket");
        RewriteRuleTokenStream stream_LBracket=new RewriteRuleTokenStream(adaptor,"token LBracket");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_LParenthesis=new RewriteRuleTokenStream(adaptor,"token LParenthesis");
        RewriteRuleTokenStream stream_RParenthesis=new RewriteRuleTokenStream(adaptor,"token RParenthesis");
        RewriteRuleSubtreeStream stream_attributeName=new RewriteRuleSubtreeStream(adaptor,"rule attributeName");
        RewriteRuleSubtreeStream stream_attributeValue=new RewriteRuleSubtreeStream(adaptor,"rule attributeValue");
        RewriteRuleSubtreeStream stream_attributeModifierAssignment=new RewriteRuleSubtreeStream(adaptor,"rule attributeModifierAssignment");
        try {
            // com/lambda/impex/ast/Impex.g:304:2: ( DocumentID -> ^( ATTRIBUTE DocumentID ) | attributeName ( LParenthesis attributeValue ( Comma attributeValue )* RParenthesis )? ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket )* -> ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attributeValue )* ) ^( MODIFIERS ( attributeModifierAssignment )* ) ) )
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
                    // com/lambda/impex/ast/Impex.g:304:3: DocumentID
                    {
                    DocumentID35=(Token)match(input,DocumentID,FOLLOW_DocumentID_in_attributeValue560);  
                    stream_DocumentID.add(DocumentID35);


                    // AST REWRITE
                    // elements: DocumentID
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 304:13: -> ^( ATTRIBUTE DocumentID )
                    {
                        // com/lambda/impex/ast/Impex.g:304:16: ^( ATTRIBUTE DocumentID )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(ATTRIBUTE, "ATTRIBUTE")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_DocumentID.nextNode()
                        );

                        adaptor.addChild(root_0, root_1);
                        }

                    }


                    retval.tree = root_0;

                    }
                    break;
                case 2 :
                    // com/lambda/impex/ast/Impex.g:305:4: attributeName ( LParenthesis attributeValue ( Comma attributeValue )* RParenthesis )? ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket )*
                    {
                    pushFollow(FOLLOW_attributeName_in_attributeValue572);
                    attributeName36=attributeName();

                    state._fsp--;

                    stream_attributeName.add(attributeName36.getTree());

                    // com/lambda/impex/ast/Impex.g:305:18: ( LParenthesis attributeValue ( Comma attributeValue )* RParenthesis )?
                    int alt17=2;
                    switch ( input.LA(1) ) {
                        case LParenthesis:
                            {
                            alt17=1;
                            }
                            break;
                    }

                    switch (alt17) {
                        case 1 :
                            // com/lambda/impex/ast/Impex.g:305:19: LParenthesis attributeValue ( Comma attributeValue )* RParenthesis
                            {
                            LParenthesis37=(Token)match(input,LParenthesis,FOLLOW_LParenthesis_in_attributeValue575);  
                            stream_LParenthesis.add(LParenthesis37);


                            pushFollow(FOLLOW_attributeValue_in_attributeValue578);
                            attributeValue38=attributeValue();

                            state._fsp--;

                            stream_attributeValue.add(attributeValue38.getTree());

                            // com/lambda/impex/ast/Impex.g:305:48: ( Comma attributeValue )*
                            loop16:
                            do {
                                int alt16=2;
                                switch ( input.LA(1) ) {
                                case Comma:
                                    {
                                    alt16=1;
                                    }
                                    break;

                                }

                                switch (alt16) {
                            	case 1 :
                            	    // com/lambda/impex/ast/Impex.g:305:49: Comma attributeValue
                            	    {
                            	    Comma39=(Token)match(input,Comma,FOLLOW_Comma_in_attributeValue581);  
                            	    stream_Comma.add(Comma39);


                            	    pushFollow(FOLLOW_attributeValue_in_attributeValue583);
                            	    attributeValue40=attributeValue();

                            	    state._fsp--;

                            	    stream_attributeValue.add(attributeValue40.getTree());

                            	    }
                            	    break;

                            	default :
                            	    break loop16;
                                }
                            } while (true);


                            RParenthesis41=(Token)match(input,RParenthesis,FOLLOW_RParenthesis_in_attributeValue587);  
                            stream_RParenthesis.add(RParenthesis41);


                            }
                            break;

                    }


                    // com/lambda/impex/ast/Impex.g:305:88: ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket )*
                    loop19:
                    do {
                        int alt19=2;
                        switch ( input.LA(1) ) {
                        case LBracket:
                            {
                            alt19=1;
                            }
                            break;

                        }

                        switch (alt19) {
                    	case 1 :
                    	    // com/lambda/impex/ast/Impex.g:305:89: LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket
                    	    {
                    	    LBracket42=(Token)match(input,LBracket,FOLLOW_LBracket_in_attributeValue593);  
                    	    stream_LBracket.add(LBracket42);


                    	    pushFollow(FOLLOW_attributeModifierAssignment_in_attributeValue595);
                    	    attributeModifierAssignment43=attributeModifierAssignment();

                    	    state._fsp--;

                    	    stream_attributeModifierAssignment.add(attributeModifierAssignment43.getTree());

                    	    // com/lambda/impex/ast/Impex.g:305:126: ( Comma attributeModifierAssignment )*
                    	    loop18:
                    	    do {
                    	        int alt18=2;
                    	        switch ( input.LA(1) ) {
                    	        case Comma:
                    	            {
                    	            alt18=1;
                    	            }
                    	            break;

                    	        }

                    	        switch (alt18) {
                    	    	case 1 :
                    	    	    // com/lambda/impex/ast/Impex.g:305:127: Comma attributeModifierAssignment
                    	    	    {
                    	    	    Comma44=(Token)match(input,Comma,FOLLOW_Comma_in_attributeValue598);  
                    	    	    stream_Comma.add(Comma44);


                    	    	    pushFollow(FOLLOW_attributeModifierAssignment_in_attributeValue601);
                    	    	    attributeModifierAssignment45=attributeModifierAssignment();

                    	    	    state._fsp--;

                    	    	    stream_attributeModifierAssignment.add(attributeModifierAssignment45.getTree());

                    	    	    }
                    	    	    break;

                    	    	default :
                    	    	    break loop18;
                    	        }
                    	    } while (true);


                    	    RBracket46=(Token)match(input,RBracket,FOLLOW_RBracket_in_attributeValue605);  
                    	    stream_RBracket.add(RBracket46);


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);


                    // AST REWRITE
                    // elements: attributeName, attributeModifierAssignment, attributeValue
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 306:2: -> ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attributeValue )* ) ^( MODIFIERS ( attributeModifierAssignment )* ) )
                    {
                        // com/lambda/impex/ast/Impex.g:306:5: ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attributeValue )* ) ^( MODIFIERS ( attributeModifierAssignment )* ) )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(ATTRIBUTE, "ATTRIBUTE")
                        , root_1);

                        adaptor.addChild(root_1, stream_attributeName.nextTree());

                        // com/lambda/impex/ast/Impex.g:306:31: ^( ITEM_EXPRESSION ( attributeValue )* )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(ITEM_EXPRESSION, "ITEM_EXPRESSION")
                        , root_2);

                        // com/lambda/impex/ast/Impex.g:306:49: ( attributeValue )*
                        while ( stream_attributeValue.hasNext() ) {
                            adaptor.addChild(root_2, stream_attributeValue.nextTree());

                        }
                        stream_attributeValue.reset();

                        adaptor.addChild(root_1, root_2);
                        }

                        // com/lambda/impex/ast/Impex.g:306:66: ^( MODIFIERS ( attributeModifierAssignment )* )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(MODIFIERS, "MODIFIERS")
                        , root_2);

                        // com/lambda/impex/ast/Impex.g:306:78: ( attributeModifierAssignment )*
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
    // $ANTLR end "attributeValue"


    public static class attributeModifierAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "attributeModifierAssignment"
    // com/lambda/impex/ast/Impex.g:308:1: attributeModifierAssignment : attributeModifier ValueAssignment -> ^( MODIFIER attributeModifier ValueAssignment ) ;
    public final ImpexParser.attributeModifierAssignment_return attributeModifierAssignment() throws RecognitionException {
        ImpexParser.attributeModifierAssignment_return retval = new ImpexParser.attributeModifierAssignment_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ValueAssignment48=null;
        ImpexParser.attributeModifier_return attributeModifier47 =null;


        CommonTree ValueAssignment48_tree=null;
        RewriteRuleTokenStream stream_ValueAssignment=new RewriteRuleTokenStream(adaptor,"token ValueAssignment");
        RewriteRuleSubtreeStream stream_attributeModifier=new RewriteRuleSubtreeStream(adaptor,"rule attributeModifier");
        try {
            // com/lambda/impex/ast/Impex.g:309:2: ( attributeModifier ValueAssignment -> ^( MODIFIER attributeModifier ValueAssignment ) )
            // com/lambda/impex/ast/Impex.g:309:4: attributeModifier ValueAssignment
            {
            pushFollow(FOLLOW_attributeModifier_in_attributeModifierAssignment639);
            attributeModifier47=attributeModifier();

            state._fsp--;

            stream_attributeModifier.add(attributeModifier47.getTree());

            ValueAssignment48=(Token)match(input,ValueAssignment,FOLLOW_ValueAssignment_in_attributeModifierAssignment641);  
            stream_ValueAssignment.add(ValueAssignment48);


            // AST REWRITE
            // elements: attributeModifier, ValueAssignment
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 310:2: -> ^( MODIFIER attributeModifier ValueAssignment )
            {
                // com/lambda/impex/ast/Impex.g:310:5: ^( MODIFIER attributeModifier ValueAssignment )
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
    // com/lambda/impex/ast/Impex.g:312:1: attributeModifier : ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual );
    public final ImpexParser.attributeModifier_return attributeModifier() throws RecognitionException {
        ImpexParser.attributeModifier_return retval = new ImpexParser.attributeModifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set49=null;

        CommonTree set49_tree=null;

        try {
            // com/lambda/impex/ast/Impex.g:313:2: ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual )
            // com/lambda/impex/ast/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set49=(Token)input.LT(1);

            if ( (input.LA(1) >= Alias && input.LA(1) <= AllowNull)||input.LA(1)==CellDecorator||input.LA(1)==CollectionDelimiter||(input.LA(1) >= Dateformat && input.LA(1) <= Default)||input.LA(1)==ForceWrite||(input.LA(1) >= IgnoreKeyCase && input.LA(1) <= IgnoreNull)||input.LA(1)==KeyToValueDelimiter||input.LA(1)==Lang||(input.LA(1) >= MapDelimiter && input.LA(1) <= NumberFormat)||(input.LA(1) >= PathDelimiter && input.LA(1) <= Pos)||(input.LA(1) >= Translator && input.LA(1) <= Unique)||input.LA(1)==Virtual ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set49)
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
    // com/lambda/impex/ast/Impex.g:316:1: headerMode : ( Insert | InsertUpdate | Update | Remove );
    public final ImpexParser.headerMode_return headerMode() throws RecognitionException {
        ImpexParser.headerMode_return retval = new ImpexParser.headerMode_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set50=null;

        CommonTree set50_tree=null;

        try {
            // com/lambda/impex/ast/Impex.g:317:2: ( Insert | InsertUpdate | Update | Remove )
            // com/lambda/impex/ast/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set50=(Token)input.LT(1);

            if ( (input.LA(1) >= Insert && input.LA(1) <= InsertUpdate)||input.LA(1)==Remove||input.LA(1)==Update ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set50)
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
    // com/lambda/impex/ast/Impex.g:319:1: headerTypeName : ( Identifier | headerMode | attributeModifier | headerModifier );
    public final ImpexParser.headerTypeName_return headerTypeName() throws RecognitionException {
        ImpexParser.headerTypeName_return retval = new ImpexParser.headerTypeName_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Identifier51=null;
        ImpexParser.headerMode_return headerMode52 =null;

        ImpexParser.attributeModifier_return attributeModifier53 =null;

        ImpexParser.headerModifier_return headerModifier54 =null;


        CommonTree Identifier51_tree=null;

        try {
            // com/lambda/impex/ast/Impex.g:320:2: ( Identifier | headerMode | attributeModifier | headerModifier )
            int alt21=4;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                alt21=1;
                }
                break;
            case Insert:
            case InsertUpdate:
            case Remove:
            case Update:
                {
                alt21=2;
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
                alt21=3;
                }
                break;
            case BatchMode:
            case CacheUnique:
            case Processor:
                {
                alt21=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;

            }

            switch (alt21) {
                case 1 :
                    // com/lambda/impex/ast/Impex.g:320:3: Identifier
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    Identifier51=(Token)match(input,Identifier,FOLLOW_Identifier_in_headerTypeName763); 
                    Identifier51_tree = 
                    (CommonTree)adaptor.create(Identifier51)
                    ;
                    adaptor.addChild(root_0, Identifier51_tree);


                    }
                    break;
                case 2 :
                    // com/lambda/impex/ast/Impex.g:320:16: headerMode
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_headerMode_in_headerTypeName767);
                    headerMode52=headerMode();

                    state._fsp--;

                    adaptor.addChild(root_0, headerMode52.getTree());

                    }
                    break;
                case 3 :
                    // com/lambda/impex/ast/Impex.g:320:29: attributeModifier
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_attributeModifier_in_headerTypeName771);
                    attributeModifier53=attributeModifier();

                    state._fsp--;

                    adaptor.addChild(root_0, attributeModifier53.getTree());

                    }
                    break;
                case 4 :
                    // com/lambda/impex/ast/Impex.g:320:49: headerModifier
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_headerModifier_in_headerTypeName775);
                    headerModifier54=headerModifier();

                    state._fsp--;

                    adaptor.addChild(root_0, headerModifier54.getTree());

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
    // com/lambda/impex/ast/Impex.g:321:1: macro : Macrodef ( ValueAssignment | Equals ) ;
    public final ImpexParser.macro_return macro() throws RecognitionException {
        ImpexParser.macro_return retval = new ImpexParser.macro_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Macrodef55=null;
        Token ValueAssignment56=null;
        Token Equals57=null;

        CommonTree Macrodef55_tree=null;
        CommonTree ValueAssignment56_tree=null;
        CommonTree Equals57_tree=null;

        try {
            // com/lambda/impex/ast/Impex.g:322:2: ( Macrodef ( ValueAssignment | Equals ) )
            // com/lambda/impex/ast/Impex.g:322:3: Macrodef ( ValueAssignment | Equals )
            {
            root_0 = (CommonTree)adaptor.nil();


            Macrodef55=(Token)match(input,Macrodef,FOLLOW_Macrodef_in_macro782); 
            Macrodef55_tree = 
            (CommonTree)adaptor.create(Macrodef55)
            ;
            adaptor.addChild(root_0, Macrodef55_tree);


            // com/lambda/impex/ast/Impex.g:323:2: ( ValueAssignment | Equals )
            int alt22=2;
            switch ( input.LA(1) ) {
            case ValueAssignment:
                {
                alt22=1;
                }
                break;
            case Equals:
                {
                alt22=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }

            switch (alt22) {
                case 1 :
                    // com/lambda/impex/ast/Impex.g:323:3: ValueAssignment
                    {
                    ValueAssignment56=(Token)match(input,ValueAssignment,FOLLOW_ValueAssignment_in_macro787); 
                    ValueAssignment56_tree = 
                    (CommonTree)adaptor.create(ValueAssignment56)
                    ;
                    adaptor.addChild(root_0, ValueAssignment56_tree);


                    context.registerMacro(Macrodef55, (ValueAssignment56!=null?ValueAssignment56.getText():null));

                    }
                    break;
                case 2 :
                    // com/lambda/impex/ast/Impex.g:324:3: Equals
                    {
                    Equals57=(Token)match(input,Equals,FOLLOW_Equals_in_macro794); 
                    Equals57_tree = 
                    (CommonTree)adaptor.create(Equals57)
                    ;
                    adaptor.addChild(root_0, Equals57_tree);


                    context.registerMacro(Macrodef55, "");

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
        "\1\42\1\uffff\1\32\1\30\1\uffff\3\32";
    static final String DFA7_maxS =
        "\1\102\1\uffff\1\102\1\104\1\uffff\3\102";
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
            return "()* loopback of 262:18: ( ( ( Lb )+ ( macro ( Lb )* )* record ) )*";
        }
    }
 

    public static final BitSet FOLLOW_EOF_in_parse166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Lb_in_impex185 = new BitSet(new long[]{0x0400110C00000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_macro_in_impex189 = new BitSet(new long[]{0x0400110C00000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_impex196 = new BitSet(new long[]{0x0400110C00000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_EOF_in_impex204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_header_in_block236 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_Lb_in_block241 = new BitSet(new long[]{0x0020110084000000L});
    public static final BitSet FOLLOW_macro_in_block245 = new BitSet(new long[]{0x0020110084000000L});
    public static final BitSet FOLLOW_Lb_in_block248 = new BitSet(new long[]{0x0020110084000000L});
    public static final BitSet FOLLOW_record_in_block253 = new BitSet(new long[]{0x0000010000000002L});
    public static final BitSet FOLLOW_headerMode_in_header290 = new BitSet(new long[]{0x040EE09F88196980L,0x0000000000000027L});
    public static final BitSet FOLLOW_headerTypeName_in_header293 = new BitSet(new long[]{0x1000002000000002L});
    public static final BitSet FOLLOW_LBracket_in_header296 = new BitSet(new long[]{0x0008000000002800L});
    public static final BitSet FOLLOW_headerModifierAssignment_in_header298 = new BitSet(new long[]{0x0040000000020000L});
    public static final BitSet FOLLOW_Comma_in_header301 = new BitSet(new long[]{0x0008000000002800L});
    public static final BitSet FOLLOW_headerModifierAssignment_in_header304 = new BitSet(new long[]{0x0040000000020000L});
    public static final BitSet FOLLOW_RBracket_in_header308 = new BitSet(new long[]{0x1000002000000002L});
    public static final BitSet FOLLOW_Semicolon_in_header314 = new BitSet(new long[]{0x4010106080A00000L});
    public static final BitSet FOLLOW_attribute_in_header316 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_headerModifier_in_headerModifierAssignment367 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ValueAssignment_in_headerModifierAssignment369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_record412 = new BitSet(new long[]{0x0020000004000000L});
    public static final BitSet FOLLOW_field_in_record419 = new BitSet(new long[]{0x0020000004000002L});
    public static final BitSet FOLLOW_attributeValue_in_attribute471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_quote_in_attribute475 = new BitSet(new long[]{0x4000106080200000L});
    public static final BitSet FOLLOW_attributeValue_in_attribute477 = new BitSet(new long[]{0x0010000000800000L});
    public static final BitSet FOLLOW_quote_in_attribute479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Macrodef_in_attributeName493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SpecialAttribute_in_attributeName507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_attributeName520 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_Dot_in_attributeName523 = new BitSet(new long[]{0x4000100080000000L});
    public static final BitSet FOLLOW_attributeName_in_attributeName525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DocumentID_in_attributeValue560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeName_in_attributeValue572 = new BitSet(new long[]{0x0000006000000002L});
    public static final BitSet FOLLOW_LParenthesis_in_attributeValue575 = new BitSet(new long[]{0x4000106080200000L});
    public static final BitSet FOLLOW_attributeValue_in_attributeValue578 = new BitSet(new long[]{0x0200000000020000L});
    public static final BitSet FOLLOW_Comma_in_attributeValue581 = new BitSet(new long[]{0x4000106080200000L});
    public static final BitSet FOLLOW_attributeValue_in_attributeValue583 = new BitSet(new long[]{0x0200000000020000L});
    public static final BitSet FOLLOW_RParenthesis_in_attributeValue587 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_LBracket_in_attributeValue593 = new BitSet(new long[]{0x0006E09308194180L,0x0000000000000023L});
    public static final BitSet FOLLOW_attributeModifierAssignment_in_attributeValue595 = new BitSet(new long[]{0x0040000000020000L});
    public static final BitSet FOLLOW_Comma_in_attributeValue598 = new BitSet(new long[]{0x0006E09308194180L,0x0000000000000023L});
    public static final BitSet FOLLOW_attributeModifierAssignment_in_attributeValue601 = new BitSet(new long[]{0x0040000000020000L});
    public static final BitSet FOLLOW_RBracket_in_attributeValue605 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_attributeModifier_in_attributeModifierAssignment639 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ValueAssignment_in_attributeModifierAssignment641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_headerTypeName763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_headerMode_in_headerTypeName767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeModifier_in_headerTypeName771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_headerModifier_in_headerTypeName775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Macrodef_in_macro782 = new BitSet(new long[]{0x0000000001000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ValueAssignment_in_macro787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Equals_in_macro794 = new BitSet(new long[]{0x0000000000000002L});

}