// $ANTLR 3.4 /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g 2012-12-30 20:02:02

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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTRIBUTE", "ATTRIBUTES", "ATTRIBUTE_NAME", "Alias", "AllowNull", "BLOCK", "BLOCKS", "BatchMode", "BeanShell", "Bool", "CacheUnique", "CellDecorator", "Char", "Classname", "CollectionDelimiter", "Comma", "Comment", "DOCUMENTID", "DOCUMENTID_REF", "Dateformat", "Default", "DocumentID", "Dot", "DoubleQuote", "Equals", "FIELDS", "Field", "ForceWrite", "HEADER", "IMPEX", "ITEM_EXPRESSION", "Identifier", "IgnoreKeyCase", "IgnoreNull", "Insert", "InsertUpdate", "KeyToValueDelimiter", "LBracket", "LParenthesis", "Lang", "Lb", "MACRO_REF", "MODIFIER", "MODIFIERS", "Macrodef", "MapDelimiter", "Mode", "NumberFormat", "Or", "PathDelimiter", "Pos", "Processor", "QuotedField", "RBracket", "RECORD", "RECORDS", "RParenthesis", "Remove", "SUBTYPE", "Semicolon", "Separator", "SpecialAttribute", "TYPE", "Translator", "Unique", "Update", "UserRights", "ValueAssignment", "Virtual", "Ws"
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
    public static final int QuotedField=56;
    public static final int RBracket=57;
    public static final int RECORD=58;
    public static final int RECORDS=59;
    public static final int RParenthesis=60;
    public static final int Remove=61;
    public static final int SUBTYPE=62;
    public static final int Semicolon=63;
    public static final int Separator=64;
    public static final int SpecialAttribute=65;
    public static final int TYPE=66;
    public static final int Translator=67;
    public static final int Unique=68;
    public static final int Update=69;
    public static final int UserRights=70;
    public static final int ValueAssignment=71;
    public static final int Virtual=72;
    public static final int Ws=73;

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




        private final Map<String, List<SimpleImmutableEntry<Integer, String>>> macros = new HashMap<String, List<SimpleImmutableEntry<Integer, String>>>();
        private final Set<String> documentIDs = new HashSet<String>();
        private final Pattern macroPattern = Pattern.compile("$[a-zA-Z_][a-zA-Z_0-9]*");

        private void registerMacro(final Token def, final String val) {
            final String macrodef = def.getText();
            List<SimpleImmutableEntry<Integer, String>> macroval = macros.get(macrodef);
            if (macroval == null) {
                macroval = new ArrayList<SimpleImmutableEntry<Integer, String>>();
                macros.put(macrodef, macroval);
            }
            macroval.add(new SimpleImmutableEntry<Integer, String>(def.getLine(), val == null? "" : val));
        }

        private void registerDocumentID(String documentID){
        	if (documentIDs.contains(documentID)){
        		//TODO issue an error indicating that there is duplicated documentID definition
        		
        	}
        	documentIDs.add(documentID);
        }

        Map<String, List<SimpleImmutableEntry<Integer, String>>> getMacros(){
            return macros;
        }
        
        Set<String> getDocumentIDs(){
        	return documentIDs;
        }
        
        private boolean hasDocumentID(String documentID){
        	return documentIDs.contains(documentID);
        }
        
        private String getMacroVal(final String macroDef, final int refLine) {
            final List<SimpleImmutableEntry<Integer, String>> list = macros.get(macroDef);
            if (list == null) {
                // TODO in case there is no such macro definition treat it as normal text and issue an error 
                return macroDef;
            }

            for (int i = list.size() - 1; i >= 0; --i) {
                final SimpleImmutableEntry<Integer, String> entry = list.get(i);
                if (entry.getKey().intValue() < refLine) {
                    String val = entry.getValue();
                    final Matcher m = macroPattern.matcher(val);
                    while (m.find()) {
                        final String nestedMacroDef = m.group();
                        final String nestedVal = getMacroVal(nestedMacroDef, entry.getKey());
                        val = m.replaceFirst(nestedVal);
                    }
                    return val;
                }
            }
            return macroDef;
        }


    public static class parse_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parse"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:233:1: parse : (t= . )* EOF ;
    public final ImpexParser.parse_return parse() throws RecognitionException {
        ImpexParser.parse_return retval = new ImpexParser.parse_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token t=null;
        Token EOF1=null;

        CommonTree t_tree=null;
        CommonTree EOF1_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:234:3: ( (t= . )* EOF )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:234:6: (t= . )* EOF
            {
            root_0 = (CommonTree)adaptor.nil();


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:234:6: (t= . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= ATTRIBUTE && LA1_0 <= Ws)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:234:7: t= .
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


    public static class impex_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "impex"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:237:1: impex : ( Lb | block | macro )* EOF -> ^( IMPEX ^( BLOCKS ( block )* ) ) ;
    public final ImpexParser.impex_return impex() throws RecognitionException {
        ImpexParser.impex_return retval = new ImpexParser.impex_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Lb2=null;
        Token EOF5=null;
        ImpexParser.block_return block3 =null;

        ImpexParser.macro_return macro4 =null;


        CommonTree Lb2_tree=null;
        CommonTree EOF5_tree=null;
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleTokenStream stream_Lb=new RewriteRuleTokenStream(adaptor,"token Lb");
        RewriteRuleSubtreeStream stream_macro=new RewriteRuleSubtreeStream(adaptor,"rule macro");
        RewriteRuleSubtreeStream stream_block=new RewriteRuleSubtreeStream(adaptor,"rule block");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:237:7: ( ( Lb | block | macro )* EOF -> ^( IMPEX ^( BLOCKS ( block )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:237:9: ( Lb | block | macro )* EOF
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:237:9: ( Lb | block | macro )*
            loop2:
            do {
                int alt2=4;
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

                }

                switch (alt2) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:237:10: Lb
            	    {
            	    Lb2=(Token)match(input,Lb,FOLLOW_Lb_in_impex188);  
            	    stream_Lb.add(Lb2);


            	    }
            	    break;
            	case 2 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:237:16: block
            	    {
            	    pushFollow(FOLLOW_block_in_impex193);
            	    block3=block();

            	    state._fsp--;

            	    stream_block.add(block3.getTree());

            	    }
            	    break;
            	case 3 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:237:24: macro
            	    {
            	    pushFollow(FOLLOW_macro_in_impex197);
            	    macro4=macro();

            	    state._fsp--;

            	    stream_macro.add(macro4.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            EOF5=(Token)match(input,EOF,FOLLOW_EOF_in_impex201);  
            stream_EOF.add(EOF5);


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
            // 238:3: -> ^( IMPEX ^( BLOCKS ( block )* ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:238:6: ^( IMPEX ^( BLOCKS ( block )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IMPEX, "IMPEX")
                , root_1);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:238:14: ^( BLOCKS ( block )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCKS, "BLOCKS")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:238:23: ( block )*
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:241:1: block : header ( ( Lb )+ ( macro ( Lb )* )* record )+ -> ^( BLOCK header ^( RECORDS ( record )+ ) ) ;
    public final ImpexParser.block_return block() throws RecognitionException {
        ImpexParser.block_return retval = new ImpexParser.block_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Lb7=null;
        Token Lb9=null;
        ImpexParser.header_return header6 =null;

        ImpexParser.macro_return macro8 =null;

        ImpexParser.record_return record10 =null;


        CommonTree Lb7_tree=null;
        CommonTree Lb9_tree=null;
        RewriteRuleTokenStream stream_Lb=new RewriteRuleTokenStream(adaptor,"token Lb");
        RewriteRuleSubtreeStream stream_record=new RewriteRuleSubtreeStream(adaptor,"rule record");
        RewriteRuleSubtreeStream stream_macro=new RewriteRuleSubtreeStream(adaptor,"rule macro");
        RewriteRuleSubtreeStream stream_header=new RewriteRuleSubtreeStream(adaptor,"rule header");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:241:7: ( header ( ( Lb )+ ( macro ( Lb )* )* record )+ -> ^( BLOCK header ^( RECORDS ( record )+ ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:241:9: header ( ( Lb )+ ( macro ( Lb )* )* record )+
            {
            pushFollow(FOLLOW_header_in_block225);
            header6=header();

            state._fsp--;

            stream_header.add(header6.getTree());

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:241:16: ( ( Lb )+ ( macro ( Lb )* )* record )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                alt6 = dfa6.predict(input);
                switch (alt6) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:241:17: ( Lb )+ ( macro ( Lb )* )* record
            	    {
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:241:17: ( Lb )+
            	    int cnt3=0;
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( (LA3_0==Lb) ) {
            	            alt3=1;
            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:241:17: Lb
            	    	    {
            	    	    Lb7=(Token)match(input,Lb,FOLLOW_Lb_in_block228);  
            	    	    stream_Lb.add(Lb7);


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt3 >= 1 ) break loop3;
            	                EarlyExitException eee =
            	                    new EarlyExitException(3, input);
            	                throw eee;
            	        }
            	        cnt3++;
            	    } while (true);


            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:241:21: ( macro ( Lb )* )*
            	    loop5:
            	    do {
            	        int alt5=2;
            	        int LA5_0 = input.LA(1);

            	        if ( (LA5_0==Macrodef) ) {
            	            alt5=1;
            	        }


            	        switch (alt5) {
            	    	case 1 :
            	    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:241:22: macro ( Lb )*
            	    	    {
            	    	    pushFollow(FOLLOW_macro_in_block232);
            	    	    macro8=macro();

            	    	    state._fsp--;

            	    	    stream_macro.add(macro8.getTree());

            	    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:241:28: ( Lb )*
            	    	    loop4:
            	    	    do {
            	    	        int alt4=2;
            	    	        int LA4_0 = input.LA(1);

            	    	        if ( (LA4_0==Lb) ) {
            	    	            alt4=1;
            	    	        }


            	    	        switch (alt4) {
            	    	    	case 1 :
            	    	    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:241:28: Lb
            	    	    	    {
            	    	    	    Lb9=(Token)match(input,Lb,FOLLOW_Lb_in_block234);  
            	    	    	    stream_Lb.add(Lb9);


            	    	    	    }
            	    	    	    break;

            	    	    	default :
            	    	    	    break loop4;
            	    	        }
            	    	    } while (true);


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop5;
            	        }
            	    } while (true);


            	    pushFollow(FOLLOW_record_in_block239);
            	    record10=record();

            	    state._fsp--;

            	    stream_record.add(record10.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
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
            // 242:2: -> ^( BLOCK header ^( RECORDS ( record )+ ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:242:5: ^( BLOCK header ^( RECORDS ( record )+ ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCK, "BLOCK")
                , root_1);

                adaptor.addChild(root_1, stream_header.nextTree());

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:242:20: ^( RECORDS ( record )+ )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(RECORDS, "RECORDS")
                , root_2);

                if ( !(stream_record.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:244:1: header : headerMode headerTypeName ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )* ( Semicolon ( attribute | DoubleQuote attribute DoubleQuote ) )* ( Semicolon DocumentID ( Semicolon ( attribute | DoubleQuote attribute DoubleQuote ) )* )? -> ^( HEADER headerMode ^( TYPE headerTypeName ) ^( MODIFIERS ( headerModifierAssignment )* ) ^( DOCUMENTID ( DocumentID )? ) ^( ATTRIBUTES ( attribute )* ) ) ;
    public final ImpexParser.header_return header() throws RecognitionException {
        ImpexParser.header_return retval = new ImpexParser.header_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token LBracket13=null;
        Token Comma15=null;
        Token RBracket17=null;
        Token Semicolon18=null;
        Token DoubleQuote20=null;
        Token DoubleQuote22=null;
        Token Semicolon23=null;
        Token DocumentID24=null;
        Token Semicolon25=null;
        Token DoubleQuote27=null;
        Token DoubleQuote29=null;
        ImpexParser.headerMode_return headerMode11 =null;

        ImpexParser.headerTypeName_return headerTypeName12 =null;

        ImpexParser.headerModifierAssignment_return headerModifierAssignment14 =null;

        ImpexParser.headerModifierAssignment_return headerModifierAssignment16 =null;

        ImpexParser.attribute_return attribute19 =null;

        ImpexParser.attribute_return attribute21 =null;

        ImpexParser.attribute_return attribute26 =null;

        ImpexParser.attribute_return attribute28 =null;


        CommonTree LBracket13_tree=null;
        CommonTree Comma15_tree=null;
        CommonTree RBracket17_tree=null;
        CommonTree Semicolon18_tree=null;
        CommonTree DoubleQuote20_tree=null;
        CommonTree DoubleQuote22_tree=null;
        CommonTree Semicolon23_tree=null;
        CommonTree DocumentID24_tree=null;
        CommonTree Semicolon25_tree=null;
        CommonTree DoubleQuote27_tree=null;
        CommonTree DoubleQuote29_tree=null;
        RewriteRuleTokenStream stream_DocumentID=new RewriteRuleTokenStream(adaptor,"token DocumentID");
        RewriteRuleTokenStream stream_RBracket=new RewriteRuleTokenStream(adaptor,"token RBracket");
        RewriteRuleTokenStream stream_LBracket=new RewriteRuleTokenStream(adaptor,"token LBracket");
        RewriteRuleTokenStream stream_Semicolon=new RewriteRuleTokenStream(adaptor,"token Semicolon");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_DoubleQuote=new RewriteRuleTokenStream(adaptor,"token DoubleQuote");
        RewriteRuleSubtreeStream stream_headerMode=new RewriteRuleSubtreeStream(adaptor,"rule headerMode");
        RewriteRuleSubtreeStream stream_headerModifierAssignment=new RewriteRuleSubtreeStream(adaptor,"rule headerModifierAssignment");
        RewriteRuleSubtreeStream stream_headerTypeName=new RewriteRuleSubtreeStream(adaptor,"rule headerTypeName");
        RewriteRuleSubtreeStream stream_attribute=new RewriteRuleSubtreeStream(adaptor,"rule attribute");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:245:2: ( headerMode headerTypeName ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )* ( Semicolon ( attribute | DoubleQuote attribute DoubleQuote ) )* ( Semicolon DocumentID ( Semicolon ( attribute | DoubleQuote attribute DoubleQuote ) )* )? -> ^( HEADER headerMode ^( TYPE headerTypeName ) ^( MODIFIERS ( headerModifierAssignment )* ) ^( DOCUMENTID ( DocumentID )? ) ^( ATTRIBUTES ( attribute )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:245:4: headerMode headerTypeName ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )* ( Semicolon ( attribute | DoubleQuote attribute DoubleQuote ) )* ( Semicolon DocumentID ( Semicolon ( attribute | DoubleQuote attribute DoubleQuote ) )* )?
            {
            pushFollow(FOLLOW_headerMode_in_header266);
            headerMode11=headerMode();

            state._fsp--;

            stream_headerMode.add(headerMode11.getTree());

            pushFollow(FOLLOW_headerTypeName_in_header269);
            headerTypeName12=headerTypeName();

            state._fsp--;

            stream_headerTypeName.add(headerTypeName12.getTree());

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:245:31: ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==LBracket) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:245:32: LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket
            	    {
            	    LBracket13=(Token)match(input,LBracket,FOLLOW_LBracket_in_header272);  
            	    stream_LBracket.add(LBracket13);


            	    pushFollow(FOLLOW_headerModifierAssignment_in_header274);
            	    headerModifierAssignment14=headerModifierAssignment();

            	    state._fsp--;

            	    stream_headerModifierAssignment.add(headerModifierAssignment14.getTree());

            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:245:66: ( Comma headerModifierAssignment )*
            	    loop7:
            	    do {
            	        int alt7=2;
            	        int LA7_0 = input.LA(1);

            	        if ( (LA7_0==Comma) ) {
            	            alt7=1;
            	        }


            	        switch (alt7) {
            	    	case 1 :
            	    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:245:67: Comma headerModifierAssignment
            	    	    {
            	    	    Comma15=(Token)match(input,Comma,FOLLOW_Comma_in_header277);  
            	    	    stream_Comma.add(Comma15);


            	    	    pushFollow(FOLLOW_headerModifierAssignment_in_header280);
            	    	    headerModifierAssignment16=headerModifierAssignment();

            	    	    state._fsp--;

            	    	    stream_headerModifierAssignment.add(headerModifierAssignment16.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop7;
            	        }
            	    } while (true);


            	    RBracket17=(Token)match(input,RBracket,FOLLOW_RBracket_in_header284);  
            	    stream_RBracket.add(RBracket17);


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:245:113: ( Semicolon ( attribute | DoubleQuote attribute DoubleQuote ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==Semicolon) ) {
                    int LA10_1 = input.LA(2);

                    if ( (LA10_1==DoubleQuote||LA10_1==Identifier||(LA10_1 >= LBracket && LA10_1 <= LParenthesis)||LA10_1==Lb||LA10_1==Macrodef||LA10_1==Semicolon||LA10_1==SpecialAttribute) ) {
                        alt10=1;
                    }


                }


                switch (alt10) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:245:114: Semicolon ( attribute | DoubleQuote attribute DoubleQuote )
            	    {
            	    Semicolon18=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_header290);  
            	    stream_Semicolon.add(Semicolon18);


            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:245:124: ( attribute | DoubleQuote attribute DoubleQuote )
            	    int alt9=2;
            	    int LA9_0 = input.LA(1);

            	    if ( (LA9_0==Identifier||(LA9_0 >= LBracket && LA9_0 <= LParenthesis)||LA9_0==Lb||LA9_0==Macrodef||LA9_0==Semicolon||LA9_0==SpecialAttribute) ) {
            	        alt9=1;
            	    }
            	    else if ( (LA9_0==DoubleQuote) ) {
            	        alt9=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 9, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt9) {
            	        case 1 :
            	            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:245:125: attribute
            	            {
            	            pushFollow(FOLLOW_attribute_in_header293);
            	            attribute19=attribute();

            	            state._fsp--;

            	            stream_attribute.add(attribute19.getTree());

            	            }
            	            break;
            	        case 2 :
            	            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:245:137: DoubleQuote attribute DoubleQuote
            	            {
            	            DoubleQuote20=(Token)match(input,DoubleQuote,FOLLOW_DoubleQuote_in_header297);  
            	            stream_DoubleQuote.add(DoubleQuote20);


            	            pushFollow(FOLLOW_attribute_in_header299);
            	            attribute21=attribute();

            	            state._fsp--;

            	            stream_attribute.add(attribute21.getTree());

            	            DoubleQuote22=(Token)match(input,DoubleQuote,FOLLOW_DoubleQuote_in_header301);  
            	            stream_DoubleQuote.add(DoubleQuote22);


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:245:174: ( Semicolon DocumentID ( Semicolon ( attribute | DoubleQuote attribute DoubleQuote ) )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==Semicolon) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:245:175: Semicolon DocumentID ( Semicolon ( attribute | DoubleQuote attribute DoubleQuote ) )*
                    {
                    Semicolon23=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_header307);  
                    stream_Semicolon.add(Semicolon23);


                    DocumentID24=(Token)match(input,DocumentID,FOLLOW_DocumentID_in_header309);  
                    stream_DocumentID.add(DocumentID24);


                    registerDocumentID((DocumentID24!=null?DocumentID24.getText():null));

                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:245:236: ( Semicolon ( attribute | DoubleQuote attribute DoubleQuote ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==Semicolon) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:245:237: Semicolon ( attribute | DoubleQuote attribute DoubleQuote )
                    	    {
                    	    Semicolon25=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_header314);  
                    	    stream_Semicolon.add(Semicolon25);


                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:245:247: ( attribute | DoubleQuote attribute DoubleQuote )
                    	    int alt11=2;
                    	    int LA11_0 = input.LA(1);

                    	    if ( (LA11_0==Identifier||(LA11_0 >= LBracket && LA11_0 <= LParenthesis)||LA11_0==Lb||LA11_0==Macrodef||LA11_0==Semicolon||LA11_0==SpecialAttribute) ) {
                    	        alt11=1;
                    	    }
                    	    else if ( (LA11_0==DoubleQuote) ) {
                    	        alt11=2;
                    	    }
                    	    else {
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 11, 0, input);

                    	        throw nvae;

                    	    }
                    	    switch (alt11) {
                    	        case 1 :
                    	            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:245:248: attribute
                    	            {
                    	            pushFollow(FOLLOW_attribute_in_header317);
                    	            attribute26=attribute();

                    	            state._fsp--;

                    	            stream_attribute.add(attribute26.getTree());

                    	            }
                    	            break;
                    	        case 2 :
                    	            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:245:260: DoubleQuote attribute DoubleQuote
                    	            {
                    	            DoubleQuote27=(Token)match(input,DoubleQuote,FOLLOW_DoubleQuote_in_header321);  
                    	            stream_DoubleQuote.add(DoubleQuote27);


                    	            pushFollow(FOLLOW_attribute_in_header323);
                    	            attribute28=attribute();

                    	            state._fsp--;

                    	            stream_attribute.add(attribute28.getTree());

                    	            DoubleQuote29=(Token)match(input,DoubleQuote,FOLLOW_DoubleQuote_in_header325);  
                    	            stream_DoubleQuote.add(DoubleQuote29);


                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;

            }


            // AST REWRITE
            // elements: DocumentID, headerTypeName, attribute, headerModifierAssignment, headerMode
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 246:2: -> ^( HEADER headerMode ^( TYPE headerTypeName ) ^( MODIFIERS ( headerModifierAssignment )* ) ^( DOCUMENTID ( DocumentID )? ) ^( ATTRIBUTES ( attribute )* ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:246:5: ^( HEADER headerMode ^( TYPE headerTypeName ) ^( MODIFIERS ( headerModifierAssignment )* ) ^( DOCUMENTID ( DocumentID )? ) ^( ATTRIBUTES ( attribute )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(HEADER, "HEADER")
                , root_1);

                adaptor.addChild(root_1, stream_headerMode.nextTree());

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:246:25: ^( TYPE headerTypeName )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(TYPE, "TYPE")
                , root_2);

                adaptor.addChild(root_2, stream_headerTypeName.nextTree());

                adaptor.addChild(root_1, root_2);
                }

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:246:48: ^( MODIFIERS ( headerModifierAssignment )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(MODIFIERS, "MODIFIERS")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:246:60: ( headerModifierAssignment )*
                while ( stream_headerModifierAssignment.hasNext() ) {
                    adaptor.addChild(root_2, stream_headerModifierAssignment.nextTree());

                }
                stream_headerModifierAssignment.reset();

                adaptor.addChild(root_1, root_2);
                }

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:246:87: ^( DOCUMENTID ( DocumentID )? )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(DOCUMENTID, "DOCUMENTID")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:246:100: ( DocumentID )?
                if ( stream_DocumentID.hasNext() ) {
                    adaptor.addChild(root_2, 
                    stream_DocumentID.nextNode()
                    );

                }
                stream_DocumentID.reset();

                adaptor.addChild(root_1, root_2);
                }

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:246:113: ^( ATTRIBUTES ( attribute )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ATTRIBUTES, "ATTRIBUTES")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:246:126: ( attribute )*
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


    public static class headerModifierAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "headerModifierAssignment"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:248:1: headerModifierAssignment : headerModifier Equals boolOrClassname -> ^( MODIFIER headerModifier boolOrClassname ) ;
    public final ImpexParser.headerModifierAssignment_return headerModifierAssignment() throws RecognitionException {
        ImpexParser.headerModifierAssignment_return retval = new ImpexParser.headerModifierAssignment_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Equals31=null;
        ImpexParser.headerModifier_return headerModifier30 =null;

        ImpexParser.boolOrClassname_return boolOrClassname32 =null;


        CommonTree Equals31_tree=null;
        RewriteRuleTokenStream stream_Equals=new RewriteRuleTokenStream(adaptor,"token Equals");
        RewriteRuleSubtreeStream stream_headerModifier=new RewriteRuleSubtreeStream(adaptor,"rule headerModifier");
        RewriteRuleSubtreeStream stream_boolOrClassname=new RewriteRuleSubtreeStream(adaptor,"rule boolOrClassname");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:248:25: ( headerModifier Equals boolOrClassname -> ^( MODIFIER headerModifier boolOrClassname ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:248:27: headerModifier Equals boolOrClassname
            {
            pushFollow(FOLLOW_headerModifier_in_headerModifierAssignment375);
            headerModifier30=headerModifier();

            state._fsp--;

            stream_headerModifier.add(headerModifier30.getTree());

            Equals31=(Token)match(input,Equals,FOLLOW_Equals_in_headerModifierAssignment377);  
            stream_Equals.add(Equals31);


            pushFollow(FOLLOW_boolOrClassname_in_headerModifierAssignment379);
            boolOrClassname32=boolOrClassname();

            state._fsp--;

            stream_boolOrClassname.add(boolOrClassname32.getTree());

            // AST REWRITE
            // elements: headerModifier, boolOrClassname
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 249:2: -> ^( MODIFIER headerModifier boolOrClassname )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:249:5: ^( MODIFIER headerModifier boolOrClassname )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(MODIFIER, "MODIFIER")
                , root_1);

                adaptor.addChild(root_1, stream_headerModifier.nextTree());

                adaptor.addChild(root_1, stream_boolOrClassname.nextTree());

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


    public static class boolOrClassname_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "boolOrClassname"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:251:1: boolOrClassname : ( Bool | Classname );
    public final ImpexParser.boolOrClassname_return boolOrClassname() throws RecognitionException {
        ImpexParser.boolOrClassname_return retval = new ImpexParser.boolOrClassname_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set33=null;

        CommonTree set33_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:252:2: ( Bool | Classname )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set33=(Token)input.LT(1);

            if ( input.LA(1)==Bool||input.LA(1)==Classname ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set33)
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
    // $ANTLR end "boolOrClassname"


    public static class headerModifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "headerModifier"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:254:1: headerModifier : ( BatchMode | CacheUnique | Processor );
    public final ImpexParser.headerModifier_return headerModifier() throws RecognitionException {
        ImpexParser.headerModifier_return retval = new ImpexParser.headerModifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set34=null;

        CommonTree set34_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:255:2: ( BatchMode | CacheUnique | Processor )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set34=(Token)input.LT(1);

            if ( input.LA(1)==BatchMode||input.LA(1)==CacheUnique||input.LA(1)==Processor ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set34)
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:258:1: record : ( Identifier )? ( field )+ -> ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) ) ;
    public final ImpexParser.record_return record() throws RecognitionException {
        ImpexParser.record_return retval = new ImpexParser.record_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Identifier35=null;
        ImpexParser.field_return field36 =null;


        CommonTree Identifier35_tree=null;
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_field=new RewriteRuleSubtreeStream(adaptor,"rule field");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:259:5: ( ( Identifier )? ( field )+ -> ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:259:7: ( Identifier )? ( field )+
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:259:7: ( Identifier )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==Identifier) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:259:7: Identifier
                    {
                    Identifier35=(Token)match(input,Identifier,FOLLOW_Identifier_in_record432);  
                    stream_Identifier.add(Identifier35);


                    }
                    break;

            }


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:259:19: ( field )+
            int cnt15=0;
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==Field||LA15_0==QuotedField) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:259:19: field
            	    {
            	    pushFollow(FOLLOW_field_in_record435);
            	    field36=field();

            	    state._fsp--;

            	    stream_field.add(field36.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        throw eee;
                }
                cnt15++;
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
            // 260:6: -> ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:260:9: ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(RECORD, "RECORD")
                , root_1);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:260:18: ^( SUBTYPE ( Identifier )? )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(SUBTYPE, "SUBTYPE")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:260:28: ( Identifier )?
                if ( stream_Identifier.hasNext() ) {
                    adaptor.addChild(root_2, 
                    stream_Identifier.nextNode()
                    );

                }
                stream_Identifier.reset();

                adaptor.addChild(root_1, root_2);
                }

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:260:41: ^( FIELDS ( field )+ )
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:262:1: field : ( QuotedField | Field );
    public final ImpexParser.field_return field() throws RecognitionException {
        ImpexParser.field_return retval = new ImpexParser.field_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set37=null;

        CommonTree set37_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:262:7: ( QuotedField | Field )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set37=(Token)input.LT(1);

            if ( input.LA(1)==Field||input.LA(1)==QuotedField ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set37)
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:287:1: attributeName : ( Macrodef -> ^( ATTRIBUTE_NAME Macrodef ) | SpecialAttribute -> ^( ATTRIBUTE_NAME SpecialAttribute ) | ( Identifier ( Dot attributeName )? ) -> ^( ATTRIBUTE_NAME Identifier ( attributeName )? ) | -> ^( ATTRIBUTE_NAME ) );
    public final ImpexParser.attributeName_return attributeName() throws RecognitionException {
        ImpexParser.attributeName_return retval = new ImpexParser.attributeName_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Macrodef38=null;
        Token SpecialAttribute39=null;
        Token Identifier40=null;
        Token Dot41=null;
        ImpexParser.attributeName_return attributeName42 =null;


        CommonTree Macrodef38_tree=null;
        CommonTree SpecialAttribute39_tree=null;
        CommonTree Identifier40_tree=null;
        CommonTree Dot41_tree=null;
        RewriteRuleTokenStream stream_Dot=new RewriteRuleTokenStream(adaptor,"token Dot");
        RewriteRuleTokenStream stream_SpecialAttribute=new RewriteRuleTokenStream(adaptor,"token SpecialAttribute");
        RewriteRuleTokenStream stream_Macrodef=new RewriteRuleTokenStream(adaptor,"token Macrodef");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_attributeName=new RewriteRuleSubtreeStream(adaptor,"rule attributeName");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:288:2: ( Macrodef -> ^( ATTRIBUTE_NAME Macrodef ) | SpecialAttribute -> ^( ATTRIBUTE_NAME SpecialAttribute ) | ( Identifier ( Dot attributeName )? ) -> ^( ATTRIBUTE_NAME Identifier ( attributeName )? ) | -> ^( ATTRIBUTE_NAME ) )
            int alt17=4;
            switch ( input.LA(1) ) {
            case Macrodef:
                {
                alt17=1;
                }
                break;
            case SpecialAttribute:
                {
                alt17=2;
                }
                break;
            case Identifier:
                {
                alt17=3;
                }
                break;
            case Comma:
            case DoubleQuote:
            case LBracket:
            case LParenthesis:
            case Lb:
            case RParenthesis:
            case Semicolon:
                {
                alt17=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }

            switch (alt17) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:288:3: Macrodef
                    {
                    Macrodef38=(Token)match(input,Macrodef,FOLLOW_Macrodef_in_attributeName510);  
                    stream_Macrodef.add(Macrodef38);


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
                    // 288:12: -> ^( ATTRIBUTE_NAME Macrodef )
                    {
                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:288:15: ^( ATTRIBUTE_NAME Macrodef )
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
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:289:4: SpecialAttribute
                    {
                    SpecialAttribute39=(Token)match(input,SpecialAttribute,FOLLOW_SpecialAttribute_in_attributeName524);  
                    stream_SpecialAttribute.add(SpecialAttribute39);


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
                    // 289:21: -> ^( ATTRIBUTE_NAME SpecialAttribute )
                    {
                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:289:24: ^( ATTRIBUTE_NAME SpecialAttribute )
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
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:290:3: ( Identifier ( Dot attributeName )? )
                    {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:290:3: ( Identifier ( Dot attributeName )? )
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:290:4: Identifier ( Dot attributeName )?
                    {
                    Identifier40=(Token)match(input,Identifier,FOLLOW_Identifier_in_attributeName537);  
                    stream_Identifier.add(Identifier40);


                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:290:15: ( Dot attributeName )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==Dot) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:290:16: Dot attributeName
                            {
                            Dot41=(Token)match(input,Dot,FOLLOW_Dot_in_attributeName540);  
                            stream_Dot.add(Dot41);


                            pushFollow(FOLLOW_attributeName_in_attributeName542);
                            attributeName42=attributeName();

                            state._fsp--;

                            stream_attributeName.add(attributeName42.getTree());

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
                    // 290:37: -> ^( ATTRIBUTE_NAME Identifier ( attributeName )? )
                    {
                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:290:40: ^( ATTRIBUTE_NAME Identifier ( attributeName )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(ATTRIBUTE_NAME, "ATTRIBUTE_NAME")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_Identifier.nextNode()
                        );

                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:290:68: ( attributeName )?
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
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:291:4: 
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
                    // 291:4: -> ^( ATTRIBUTE_NAME )
                    {
                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:291:6: ^( ATTRIBUTE_NAME )
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:293:1: attribute : attributeName ( LParenthesis ( DocumentID | attribute ) ( Comma ( DocumentID | attribute ) )* RParenthesis )? ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket )* -> ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifierAssignment )* ) ) ;
    public final ImpexParser.attribute_return attribute() throws RecognitionException {
        ImpexParser.attribute_return retval = new ImpexParser.attribute_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token LParenthesis44=null;
        Token DocumentID45=null;
        Token Comma47=null;
        Token DocumentID48=null;
        Token RParenthesis50=null;
        Token LBracket51=null;
        Token Comma53=null;
        Token RBracket55=null;
        ImpexParser.attributeName_return attributeName43 =null;

        ImpexParser.attribute_return attribute46 =null;

        ImpexParser.attribute_return attribute49 =null;

        ImpexParser.attributeModifierAssignment_return attributeModifierAssignment52 =null;

        ImpexParser.attributeModifierAssignment_return attributeModifierAssignment54 =null;


        CommonTree LParenthesis44_tree=null;
        CommonTree DocumentID45_tree=null;
        CommonTree Comma47_tree=null;
        CommonTree DocumentID48_tree=null;
        CommonTree RParenthesis50_tree=null;
        CommonTree LBracket51_tree=null;
        CommonTree Comma53_tree=null;
        CommonTree RBracket55_tree=null;
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:294:2: ( attributeName ( LParenthesis ( DocumentID | attribute ) ( Comma ( DocumentID | attribute ) )* RParenthesis )? ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket )* -> ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifierAssignment )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:294:3: attributeName ( LParenthesis ( DocumentID | attribute ) ( Comma ( DocumentID | attribute ) )* RParenthesis )? ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket )*
            {
            pushFollow(FOLLOW_attributeName_in_attribute575);
            attributeName43=attributeName();

            state._fsp--;

            stream_attributeName.add(attributeName43.getTree());

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:294:17: ( LParenthesis ( DocumentID | attribute ) ( Comma ( DocumentID | attribute ) )* RParenthesis )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==LParenthesis) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:294:18: LParenthesis ( DocumentID | attribute ) ( Comma ( DocumentID | attribute ) )* RParenthesis
                    {
                    LParenthesis44=(Token)match(input,LParenthesis,FOLLOW_LParenthesis_in_attribute578);  
                    stream_LParenthesis.add(LParenthesis44);


                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:294:32: ( DocumentID | attribute )
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==DocumentID) ) {
                        alt18=1;
                    }
                    else if ( (LA18_0==Comma||LA18_0==DoubleQuote||LA18_0==Identifier||(LA18_0 >= LBracket && LA18_0 <= LParenthesis)||LA18_0==Lb||LA18_0==Macrodef||LA18_0==RParenthesis||LA18_0==Semicolon||LA18_0==SpecialAttribute) ) {
                        alt18=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 0, input);

                        throw nvae;

                    }
                    switch (alt18) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:294:33: DocumentID
                            {
                            DocumentID45=(Token)match(input,DocumentID,FOLLOW_DocumentID_in_attribute582);  
                            stream_DocumentID.add(DocumentID45);


                            }
                            break;
                        case 2 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:294:46: attribute
                            {
                            pushFollow(FOLLOW_attribute_in_attribute586);
                            attribute46=attribute();

                            state._fsp--;

                            stream_attribute.add(attribute46.getTree());

                            }
                            break;

                    }


                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:294:56: ( Comma ( DocumentID | attribute ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==Comma) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:294:57: Comma ( DocumentID | attribute )
                    	    {
                    	    Comma47=(Token)match(input,Comma,FOLLOW_Comma_in_attribute589);  
                    	    stream_Comma.add(Comma47);


                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:294:63: ( DocumentID | attribute )
                    	    int alt19=2;
                    	    int LA19_0 = input.LA(1);

                    	    if ( (LA19_0==DocumentID) ) {
                    	        alt19=1;
                    	    }
                    	    else if ( (LA19_0==Comma||LA19_0==DoubleQuote||LA19_0==Identifier||(LA19_0 >= LBracket && LA19_0 <= LParenthesis)||LA19_0==Lb||LA19_0==Macrodef||LA19_0==RParenthesis||LA19_0==Semicolon||LA19_0==SpecialAttribute) ) {
                    	        alt19=2;
                    	    }
                    	    else {
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 19, 0, input);

                    	        throw nvae;

                    	    }
                    	    switch (alt19) {
                    	        case 1 :
                    	            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:294:64: DocumentID
                    	            {
                    	            DocumentID48=(Token)match(input,DocumentID,FOLLOW_DocumentID_in_attribute592);  
                    	            stream_DocumentID.add(DocumentID48);


                    	            }
                    	            break;
                    	        case 2 :
                    	            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:294:77: attribute
                    	            {
                    	            pushFollow(FOLLOW_attribute_in_attribute596);
                    	            attribute49=attribute();

                    	            state._fsp--;

                    	            stream_attribute.add(attribute49.getTree());

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    RParenthesis50=(Token)match(input,RParenthesis,FOLLOW_RParenthesis_in_attribute601);  
                    stream_RParenthesis.add(RParenthesis50);


                    }
                    break;

            }


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:294:106: ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==LBracket) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:294:107: LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket
            	    {
            	    LBracket51=(Token)match(input,LBracket,FOLLOW_LBracket_in_attribute607);  
            	    stream_LBracket.add(LBracket51);


            	    pushFollow(FOLLOW_attributeModifierAssignment_in_attribute609);
            	    attributeModifierAssignment52=attributeModifierAssignment();

            	    state._fsp--;

            	    stream_attributeModifierAssignment.add(attributeModifierAssignment52.getTree());

            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:294:144: ( Comma attributeModifierAssignment )*
            	    loop22:
            	    do {
            	        int alt22=2;
            	        int LA22_0 = input.LA(1);

            	        if ( (LA22_0==Comma) ) {
            	            alt22=1;
            	        }


            	        switch (alt22) {
            	    	case 1 :
            	    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:294:145: Comma attributeModifierAssignment
            	    	    {
            	    	    Comma53=(Token)match(input,Comma,FOLLOW_Comma_in_attribute612);  
            	    	    stream_Comma.add(Comma53);


            	    	    pushFollow(FOLLOW_attributeModifierAssignment_in_attribute615);
            	    	    attributeModifierAssignment54=attributeModifierAssignment();

            	    	    state._fsp--;

            	    	    stream_attributeModifierAssignment.add(attributeModifierAssignment54.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop22;
            	        }
            	    } while (true);


            	    RBracket55=(Token)match(input,RBracket,FOLLOW_RBracket_in_attribute619);  
            	    stream_RBracket.add(RBracket55);


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            // AST REWRITE
            // elements: attributeName, attribute, attributeModifierAssignment, DocumentID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 295:2: -> ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifierAssignment )* ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:295:5: ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifierAssignment )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ATTRIBUTE, "ATTRIBUTE")
                , root_1);

                adaptor.addChild(root_1, stream_attributeName.nextTree());

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:295:31: ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ITEM_EXPRESSION, "ITEM_EXPRESSION")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:295:49: ( attribute )*
                while ( stream_attribute.hasNext() ) {
                    adaptor.addChild(root_2, stream_attribute.nextTree());

                }
                stream_attribute.reset();

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:295:60: ^( DOCUMENTID_REF ( DocumentID )* )
                {
                CommonTree root_3 = (CommonTree)adaptor.nil();
                root_3 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(DOCUMENTID_REF, "DOCUMENTID_REF")
                , root_3);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:295:77: ( DocumentID )*
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

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:295:91: ^( MODIFIERS ( attributeModifierAssignment )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(MODIFIERS, "MODIFIERS")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:295:103: ( attributeModifierAssignment )*
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:297:1: attributeModifierAssignment : attributeModifier ValueAssignment -> ^( MODIFIER attributeModifier ValueAssignment ) ;
    public final ImpexParser.attributeModifierAssignment_return attributeModifierAssignment() throws RecognitionException {
        ImpexParser.attributeModifierAssignment_return retval = new ImpexParser.attributeModifierAssignment_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ValueAssignment57=null;
        ImpexParser.attributeModifier_return attributeModifier56 =null;


        CommonTree ValueAssignment57_tree=null;
        RewriteRuleTokenStream stream_ValueAssignment=new RewriteRuleTokenStream(adaptor,"token ValueAssignment");
        RewriteRuleSubtreeStream stream_attributeModifier=new RewriteRuleSubtreeStream(adaptor,"rule attributeModifier");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:298:2: ( attributeModifier ValueAssignment -> ^( MODIFIER attributeModifier ValueAssignment ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:298:4: attributeModifier ValueAssignment
            {
            pushFollow(FOLLOW_attributeModifier_in_attributeModifierAssignment660);
            attributeModifier56=attributeModifier();

            state._fsp--;

            stream_attributeModifier.add(attributeModifier56.getTree());

            ValueAssignment57=(Token)match(input,ValueAssignment,FOLLOW_ValueAssignment_in_attributeModifierAssignment662);  
            stream_ValueAssignment.add(ValueAssignment57);


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
            // 299:2: -> ^( MODIFIER attributeModifier ValueAssignment )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:299:5: ^( MODIFIER attributeModifier ValueAssignment )
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:304:1: attributeModifier : ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual );
    public final ImpexParser.attributeModifier_return attributeModifier() throws RecognitionException {
        ImpexParser.attributeModifier_return retval = new ImpexParser.attributeModifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set58=null;

        CommonTree set58_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:305:2: ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set58=(Token)input.LT(1);

            if ( (input.LA(1) >= Alias && input.LA(1) <= AllowNull)||input.LA(1)==CellDecorator||input.LA(1)==CollectionDelimiter||(input.LA(1) >= Dateformat && input.LA(1) <= Default)||input.LA(1)==ForceWrite||(input.LA(1) >= IgnoreKeyCase && input.LA(1) <= IgnoreNull)||input.LA(1)==KeyToValueDelimiter||input.LA(1)==Lang||(input.LA(1) >= MapDelimiter && input.LA(1) <= NumberFormat)||(input.LA(1) >= PathDelimiter && input.LA(1) <= Pos)||(input.LA(1) >= Translator && input.LA(1) <= Unique)||input.LA(1)==Virtual ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set58)
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:308:1: headerMode : ( Insert | InsertUpdate | Update | Remove );
    public final ImpexParser.headerMode_return headerMode() throws RecognitionException {
        ImpexParser.headerMode_return retval = new ImpexParser.headerMode_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set59=null;

        CommonTree set59_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:309:2: ( Insert | InsertUpdate | Update | Remove )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set59=(Token)input.LT(1);

            if ( (input.LA(1) >= Insert && input.LA(1) <= InsertUpdate)||input.LA(1)==Remove||input.LA(1)==Update ) {
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
    // $ANTLR end "headerMode"


    public static class headerTypeName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "headerTypeName"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:311:1: headerTypeName : ( Identifier | headerMode | attributeModifier | headerModifier );
    public final ImpexParser.headerTypeName_return headerTypeName() throws RecognitionException {
        ImpexParser.headerTypeName_return retval = new ImpexParser.headerTypeName_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Identifier60=null;
        ImpexParser.headerMode_return headerMode61 =null;

        ImpexParser.attributeModifier_return attributeModifier62 =null;

        ImpexParser.headerModifier_return headerModifier63 =null;


        CommonTree Identifier60_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:312:2: ( Identifier | headerMode | attributeModifier | headerModifier )
            int alt24=4;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                alt24=1;
                }
                break;
            case Insert:
            case InsertUpdate:
            case Remove:
            case Update:
                {
                alt24=2;
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
                alt24=3;
                }
                break;
            case BatchMode:
            case CacheUnique:
            case Processor:
                {
                alt24=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;

            }

            switch (alt24) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:312:3: Identifier
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    Identifier60=(Token)match(input,Identifier,FOLLOW_Identifier_in_headerTypeName787); 
                    Identifier60_tree = 
                    (CommonTree)adaptor.create(Identifier60)
                    ;
                    adaptor.addChild(root_0, Identifier60_tree);


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:312:16: headerMode
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_headerMode_in_headerTypeName791);
                    headerMode61=headerMode();

                    state._fsp--;

                    adaptor.addChild(root_0, headerMode61.getTree());

                    }
                    break;
                case 3 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:312:29: attributeModifier
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_attributeModifier_in_headerTypeName795);
                    attributeModifier62=attributeModifier();

                    state._fsp--;

                    adaptor.addChild(root_0, attributeModifier62.getTree());

                    }
                    break;
                case 4 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:312:49: headerModifier
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    pushFollow(FOLLOW_headerModifier_in_headerTypeName799);
                    headerModifier63=headerModifier();

                    state._fsp--;

                    adaptor.addChild(root_0, headerModifier63.getTree());

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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:324:1: macro : Macrodef ( ValueAssignment | Equals ) ;
    public final ImpexParser.macro_return macro() throws RecognitionException {
        ImpexParser.macro_return retval = new ImpexParser.macro_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Macrodef64=null;
        Token ValueAssignment65=null;
        Token Equals66=null;

        CommonTree Macrodef64_tree=null;
        CommonTree ValueAssignment65_tree=null;
        CommonTree Equals66_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:325:2: ( Macrodef ( ValueAssignment | Equals ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:325:3: Macrodef ( ValueAssignment | Equals )
            {
            root_0 = (CommonTree)adaptor.nil();


            Macrodef64=(Token)match(input,Macrodef,FOLLOW_Macrodef_in_macro817); 
            Macrodef64_tree = 
            (CommonTree)adaptor.create(Macrodef64)
            ;
            adaptor.addChild(root_0, Macrodef64_tree);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:326:2: ( ValueAssignment | Equals )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==ValueAssignment) ) {
                alt25=1;
            }
            else if ( (LA25_0==Equals) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;

            }
            switch (alt25) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:326:3: ValueAssignment
                    {
                    ValueAssignment65=(Token)match(input,ValueAssignment,FOLLOW_ValueAssignment_in_macro822); 
                    ValueAssignment65_tree = 
                    (CommonTree)adaptor.create(ValueAssignment65)
                    ;
                    adaptor.addChild(root_0, ValueAssignment65_tree);


                    registerMacro(Macrodef64, (ValueAssignment65!=null?ValueAssignment65.getText():null));

                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:327:3: Equals
                    {
                    Equals66=(Token)match(input,Equals,FOLLOW_Equals_in_macro829); 
                    Equals66_tree = 
                    (CommonTree)adaptor.create(Equals66)
                    ;
                    adaptor.addChild(root_0, Equals66_tree);


                    registerMacro(Macrodef64, "");

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


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\10\uffff";
    static final String DFA6_eofS =
        "\1\1\1\uffff\1\1\2\uffff\3\1";
    static final String DFA6_minS =
        "\1\46\1\uffff\1\36\1\34\1\uffff\3\36";
    static final String DFA6_maxS =
        "\1\105\1\uffff\1\105\1\107\1\uffff\3\105";
    static final String DFA6_acceptS =
        "\1\uffff\1\2\2\uffff\1\1\3\uffff";
    static final String DFA6_specialS =
        "\10\uffff}>";
    static final String[] DFA6_transitionS = {
            "\2\1\4\uffff\1\2\3\uffff\1\1\14\uffff\1\1\7\uffff\1\1",
            "",
            "\1\4\4\uffff\1\4\2\uffff\2\1\4\uffff\1\2\3\uffff\1\3\7\uffff"+
            "\1\4\4\uffff\1\1\7\uffff\1\1",
            "\1\6\52\uffff\1\5",
            "",
            "\1\4\4\uffff\1\4\2\uffff\2\1\4\uffff\1\7\3\uffff\1\3\7\uffff"+
            "\1\4\4\uffff\1\1\7\uffff\1\1",
            "\1\4\4\uffff\1\4\2\uffff\2\1\4\uffff\1\7\3\uffff\1\3\7\uffff"+
            "\1\4\4\uffff\1\1\7\uffff\1\1",
            "\1\4\4\uffff\1\4\2\uffff\2\1\4\uffff\1\7\3\uffff\1\3\7\uffff"+
            "\1\4\4\uffff\1\1\7\uffff\1\1"
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "()+ loopback of 241:16: ( ( Lb )+ ( macro ( Lb )* )* record )+";
        }
    }
 

    public static final BitSet FOLLOW_EOF_in_parse178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Lb_in_impex188 = new BitSet(new long[]{0x200110C000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_block_in_impex193 = new BitSet(new long[]{0x200110C000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_macro_in_impex197 = new BitSet(new long[]{0x200110C000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_EOF_in_impex201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_header_in_block225 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_Lb_in_block228 = new BitSet(new long[]{0x0101100840000000L});
    public static final BitSet FOLLOW_macro_in_block232 = new BitSet(new long[]{0x0101100840000000L});
    public static final BitSet FOLLOW_Lb_in_block234 = new BitSet(new long[]{0x0101100840000000L});
    public static final BitSet FOLLOW_record_in_block239 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_headerMode_in_header266 = new BitSet(new long[]{0x20EE09F88184C980L,0x0000000000000138L});
    public static final BitSet FOLLOW_headerTypeName_in_header269 = new BitSet(new long[]{0x8000020000000002L});
    public static final BitSet FOLLOW_LBracket_in_header272 = new BitSet(new long[]{0x0080000000004800L});
    public static final BitSet FOLLOW_headerModifierAssignment_in_header274 = new BitSet(new long[]{0x0200000000080000L});
    public static final BitSet FOLLOW_Comma_in_header277 = new BitSet(new long[]{0x0080000000004800L});
    public static final BitSet FOLLOW_headerModifierAssignment_in_header280 = new BitSet(new long[]{0x0200000000080000L});
    public static final BitSet FOLLOW_RBracket_in_header284 = new BitSet(new long[]{0x8000020000000002L});
    public static final BitSet FOLLOW_Semicolon_in_header290 = new BitSet(new long[]{0x0001060808000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_attribute_in_header293 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_DoubleQuote_in_header297 = new BitSet(new long[]{0x0001060800000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_attribute_in_header299 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_DoubleQuote_in_header301 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_Semicolon_in_header307 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_DocumentID_in_header309 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_Semicolon_in_header314 = new BitSet(new long[]{0x0001060808000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_attribute_in_header317 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_DoubleQuote_in_header321 = new BitSet(new long[]{0x0001060800000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_attribute_in_header323 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_DoubleQuote_in_header325 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_headerModifier_in_headerModifierAssignment375 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_Equals_in_headerModifierAssignment377 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_boolOrClassname_in_headerModifierAssignment379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_record432 = new BitSet(new long[]{0x0100000040000000L});
    public static final BitSet FOLLOW_field_in_record435 = new BitSet(new long[]{0x0100000040000002L});
    public static final BitSet FOLLOW_Macrodef_in_attributeName510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SpecialAttribute_in_attributeName524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_attributeName537 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_Dot_in_attributeName540 = new BitSet(new long[]{0x0001000800000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_attributeName_in_attributeName542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeName_in_attribute575 = new BitSet(new long[]{0x0000060000000002L});
    public static final BitSet FOLLOW_LParenthesis_in_attribute578 = new BitSet(new long[]{0x0001060802000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_DocumentID_in_attribute582 = new BitSet(new long[]{0x1000000000080000L});
    public static final BitSet FOLLOW_attribute_in_attribute586 = new BitSet(new long[]{0x1000000000080000L});
    public static final BitSet FOLLOW_Comma_in_attribute589 = new BitSet(new long[]{0x0001060802000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_DocumentID_in_attribute592 = new BitSet(new long[]{0x1000000000080000L});
    public static final BitSet FOLLOW_attribute_in_attribute596 = new BitSet(new long[]{0x1000000000080000L});
    public static final BitSet FOLLOW_RParenthesis_in_attribute601 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_LBracket_in_attribute607 = new BitSet(new long[]{0x006E093081848180L,0x0000000000000118L});
    public static final BitSet FOLLOW_attributeModifierAssignment_in_attribute609 = new BitSet(new long[]{0x0200000000080000L});
    public static final BitSet FOLLOW_Comma_in_attribute612 = new BitSet(new long[]{0x006E093081848180L,0x0000000000000118L});
    public static final BitSet FOLLOW_attributeModifierAssignment_in_attribute615 = new BitSet(new long[]{0x0200000000080000L});
    public static final BitSet FOLLOW_RBracket_in_attribute619 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_attributeModifier_in_attributeModifierAssignment660 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_ValueAssignment_in_attributeModifierAssignment662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_headerTypeName787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_headerMode_in_headerTypeName791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeModifier_in_headerTypeName795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_headerModifier_in_headerTypeName799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Macrodef_in_macro817 = new BitSet(new long[]{0x0000000010000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_ValueAssignment_in_macro822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Equals_in_macro829 = new BitSet(new long[]{0x0000000000000002L});

}