// $ANTLR 3.4 /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g 2012-12-13 12:04:51

 package output;
  

import java.util.AbstractMap.SimpleImmutableEntry;  
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.debug.*;
import java.io.IOException;
import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class ImpexParser extends DebugParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTRIBUTE", "ATTRIBUTES", "ATTRIBUTE_NAME", "Alias", "AllowNull", "AttributeModifier", "BLOCK", "BLOCKS", "BatchMode", "Bool", "CacheUnique", "CellDecorator", "Char", "Classname", "CollectionDelimiter", "Comma", "Comment", "DOCUMENTID", "DOCUMENTID_REF", "Dateformat", "Default", "DocumentID", "Dot", "DoubleQuote", "Equals", "FIELDS", "Field", "ForceWrite", "HEADER", "HeaderMode", "HeaderModifier", "IMPEX", "ITEM_EXPRESSION", "Identifier", "IgnoreKeyCase", "IgnoreNull", "Insert", "InsertUpdate", "KeyToValueDelimiter", "LBracket", "LParenthesis", "Lang", "Lb", "MACRO_REF", "MODIFIER", "MODIFIERS", "Macrodef", "MapDelimiter", "Mode", "NextRow", "NumberFormat", "Or", "PathDelimiter", "Pos", "Processor", "QuotedField", "RBracket", "RECORD", "RECORDS", "RParenthesis", "Remove", "SUBTYPE", "Semicolon", "SpecialAttribute", "TYPE", "Translator", "Unique", "Update", "ValueAssignment", "Virtual", "Ws"
    };

    public static final int EOF=-1;
    public static final int ATTRIBUTE=4;
    public static final int ATTRIBUTES=5;
    public static final int ATTRIBUTE_NAME=6;
    public static final int Alias=7;
    public static final int AllowNull=8;
    public static final int AttributeModifier=9;
    public static final int BLOCK=10;
    public static final int BLOCKS=11;
    public static final int BatchMode=12;
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
    public static final int HeaderMode=33;
    public static final int HeaderModifier=34;
    public static final int IMPEX=35;
    public static final int ITEM_EXPRESSION=36;
    public static final int Identifier=37;
    public static final int IgnoreKeyCase=38;
    public static final int IgnoreNull=39;
    public static final int Insert=40;
    public static final int InsertUpdate=41;
    public static final int KeyToValueDelimiter=42;
    public static final int LBracket=43;
    public static final int LParenthesis=44;
    public static final int Lang=45;
    public static final int Lb=46;
    public static final int MACRO_REF=47;
    public static final int MODIFIER=48;
    public static final int MODIFIERS=49;
    public static final int Macrodef=50;
    public static final int MapDelimiter=51;
    public static final int Mode=52;
    public static final int NextRow=53;
    public static final int NumberFormat=54;
    public static final int Or=55;
    public static final int PathDelimiter=56;
    public static final int Pos=57;
    public static final int Processor=58;
    public static final int QuotedField=59;
    public static final int RBracket=60;
    public static final int RECORD=61;
    public static final int RECORDS=62;
    public static final int RParenthesis=63;
    public static final int Remove=64;
    public static final int SUBTYPE=65;
    public static final int Semicolon=66;
    public static final int SpecialAttribute=67;
    public static final int TYPE=68;
    public static final int Translator=69;
    public static final int Unique=70;
    public static final int Update=71;
    public static final int ValueAssignment=72;
    public static final int Virtual=73;
    public static final int Ws=74;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


public static final String[] ruleNames = new String[] {
    "invalidRule", "macro", "headerMode", "impex", "attributeModifierAssignment", 
    "record", "block", "boolOrClassname", "header", "headerModifierAssignment", 
    "headerModifier", "field", "parse", "attributeName", "attribute", "attributeModifier"
};

public static final boolean[] decisionCanBacktrack = new boolean[] {
    false, // invalid decision
    false, false, false, false, false, false, false, false, false, false, 
        false, false, false, false, false, false, false, false, false, false, 
        false, false, false, false
};

 
    public int ruleLevel = 0;
    public int getRuleLevel() { return ruleLevel; }
    public void incRuleLevel() { ruleLevel++; }
    public void decRuleLevel() { ruleLevel--; }
    public ImpexParser(TokenStream input) {
        this(input, DebugEventSocketProxy.DEFAULT_DEBUGGER_PORT, new RecognizerSharedState());
    }
    public ImpexParser(TokenStream input, int port, RecognizerSharedState state) {
        super(input, state);
        DebugEventSocketProxy proxy =
            new DebugEventSocketProxy(this,port,adaptor);
        setDebugListener(proxy);
        setTokenStream(new DebugTokenStream(input,proxy));
        try {
            proxy.handshake();
        }
        catch (IOException ioe) {
            reportError(ioe);
        }
        TreeAdaptor adap = new CommonTreeAdaptor();
        setTreeAdaptor(adap);
        proxy.setTreeAdaptor(adap);
    }

public ImpexParser(TokenStream input, DebugEventListener dbg) {
    super(input, dbg);
     
    TreeAdaptor adap = new CommonTreeAdaptor();
    setTreeAdaptor(adap);


}

protected boolean evalPredicate(boolean result, String predicate) {
    dbg.semanticPredicate(result, predicate);
    return result;
}

protected DebugTreeAdaptor adaptor;
public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = new DebugTreeAdaptor(dbg,adaptor);


}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}

    public String[] getTokenNames() { return ImpexParser.tokenNames; }
    public String getGrammarFileName() { return "/work/projects/yeclipse/ImpexAST/src/main/java/Impex.g"; }




        private final Map<String, List<SimpleImmutableEntry<Integer, String>>> macros = new HashMap<String, List<SimpleImmutableEntry<Integer, String>>>();
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

        Map<String, List<SimpleImmutableEntry<Integer, String>>> getMacros(){
            return macros;
        }
        
        private String getMacroVal(final String macroDef, final int refLine) {
            final List<SimpleImmutableEntry<Integer, String>> list = macros.get(macroDef);
            if (list == null) {
                // in case there is no such macro definition treat it as normal text and issue an error 
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:199:1: parse : (t= . )* EOF ;
    public final ImpexParser.parse_return parse() throws RecognitionException {
        ImpexParser.parse_return retval = new ImpexParser.parse_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token t=null;
        Token EOF1=null;

        CommonTree t_tree=null;
        CommonTree EOF1_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "parse");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(199, 0);

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:200:3: ( (t= . )* EOF )
            dbg.enterAlt(1);

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:200:6: (t= . )* EOF
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(200,6);
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:200:6: (t= . )*
            try { dbg.enterSubRule(1);

            loop1:
            do {
                int alt1=2;
                try { dbg.enterDecision(1, decisionCanBacktrack[1]);

                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= ATTRIBUTE && LA1_0 <= Ws)) ) {
                    alt1=1;
                }


                } finally {dbg.exitDecision(1);}

                switch (alt1) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:200:7: t= .
            	    {
            	    dbg.location(200,8);
            	    t=(Token)input.LT(1);

            	    matchAny(input); 
            	    t_tree = (CommonTree)adaptor.create(t);
            	    adaptor.addChild(root_0, t_tree);

            	    dbg.location(200,10);
            	    System.out.printf("%s: %-7s \n", tokenNames[(t!=null?t.getType():0)], (t!=null?t.getText():null));

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);
            } finally {dbg.exitSubRule(1);}

            dbg.location(200,80);
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
        dbg.location(200, 82);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "parse");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "parse"


    public static class impex_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "impex"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:202:1: impex : ( Lb | block | macro )* EOF -> ^( IMPEX ^( BLOCKS ( block )* ) ) ;
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
        try { dbg.enterRule(getGrammarFileName(), "impex");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(202, 0);

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:202:7: ( ( Lb | block | macro )* EOF -> ^( IMPEX ^( BLOCKS ( block )* ) ) )
            dbg.enterAlt(1);

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:202:9: ( Lb | block | macro )* EOF
            {
            dbg.location(202,9);
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:202:9: ( Lb | block | macro )*
            try { dbg.enterSubRule(2);

            loop2:
            do {
                int alt2=4;
                try { dbg.enterDecision(2, decisionCanBacktrack[2]);

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

                } finally {dbg.exitDecision(2);}

                switch (alt2) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:202:10: Lb
            	    {
            	    dbg.location(202,10);
            	    Lb2=(Token)match(input,Lb,FOLLOW_Lb_in_impex190);  
            	    stream_Lb.add(Lb2);


            	    }
            	    break;
            	case 2 :
            	    dbg.enterAlt(2);

            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:202:16: block
            	    {
            	    dbg.location(202,16);
            	    pushFollow(FOLLOW_block_in_impex195);
            	    block3=block();

            	    state._fsp--;

            	    stream_block.add(block3.getTree());

            	    }
            	    break;
            	case 3 :
            	    dbg.enterAlt(3);

            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:202:24: macro
            	    {
            	    dbg.location(202,24);
            	    pushFollow(FOLLOW_macro_in_impex199);
            	    macro4=macro();

            	    state._fsp--;

            	    stream_macro.add(macro4.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);
            } finally {dbg.exitSubRule(2);}

            dbg.location(202,32);
            EOF5=(Token)match(input,EOF,FOLLOW_EOF_in_impex203);  
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
            // 203:3: -> ^( IMPEX ^( BLOCKS ( block )* ) )
            {
                dbg.location(203,6);
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:203:6: ^( IMPEX ^( BLOCKS ( block )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(203,8);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IMPEX, "IMPEX")
                , root_1);

                dbg.location(203,14);
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:203:14: ^( BLOCKS ( block )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(203,16);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCKS, "BLOCKS")
                , root_2);

                dbg.location(203,23);
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:203:23: ( block )*
                while ( stream_block.hasNext() ) {
                    dbg.location(203,23);
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
        dbg.location(203, 30);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "impex");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "impex"


    public static class block_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "block"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:1: block : header ( ( Lb )+ ( macro ( Lb )? )* record )+ -> ^( BLOCK header ^( RECORDS ( record )+ ) ) ;
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
        try { dbg.enterRule(getGrammarFileName(), "block");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(205, 0);

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:7: ( header ( ( Lb )+ ( macro ( Lb )? )* record )+ -> ^( BLOCK header ^( RECORDS ( record )+ ) ) )
            dbg.enterAlt(1);

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:9: header ( ( Lb )+ ( macro ( Lb )? )* record )+
            {
            dbg.location(205,9);
            pushFollow(FOLLOW_header_in_block226);
            header6=header();

            state._fsp--;

            stream_header.add(header6.getTree());
            dbg.location(205,16);
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:16: ( ( Lb )+ ( macro ( Lb )? )* record )+
            int cnt6=0;
            try { dbg.enterSubRule(6);

            loop6:
            do {
                int alt6=2;
                try { dbg.enterDecision(6, decisionCanBacktrack[6]);

                try {
                    isCyclicDecision = true;
                    alt6 = dfa6.predict(input);
                }
                catch (NoViableAltException nvae) {
                    dbg.recognitionException(nvae);
                    throw nvae;
                }
                } finally {dbg.exitDecision(6);}

                switch (alt6) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:17: ( Lb )+ ( macro ( Lb )? )* record
            	    {
            	    dbg.location(205,17);
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:17: ( Lb )+
            	    int cnt3=0;
            	    try { dbg.enterSubRule(3);

            	    loop3:
            	    do {
            	        int alt3=2;
            	        try { dbg.enterDecision(3, decisionCanBacktrack[3]);

            	        int LA3_0 = input.LA(1);

            	        if ( (LA3_0==Lb) ) {
            	            alt3=1;
            	        }


            	        } finally {dbg.exitDecision(3);}

            	        switch (alt3) {
            	    	case 1 :
            	    	    dbg.enterAlt(1);

            	    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:17: Lb
            	    	    {
            	    	    dbg.location(205,17);
            	    	    Lb7=(Token)match(input,Lb,FOLLOW_Lb_in_block229);  
            	    	    stream_Lb.add(Lb7);


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt3 >= 1 ) break loop3;
            	                EarlyExitException eee =
            	                    new EarlyExitException(3, input);
            	                dbg.recognitionException(eee);

            	                throw eee;
            	        }
            	        cnt3++;
            	    } while (true);
            	    } finally {dbg.exitSubRule(3);}

            	    dbg.location(205,21);
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:21: ( macro ( Lb )? )*
            	    try { dbg.enterSubRule(5);

            	    loop5:
            	    do {
            	        int alt5=2;
            	        try { dbg.enterDecision(5, decisionCanBacktrack[5]);

            	        int LA5_0 = input.LA(1);

            	        if ( (LA5_0==Macrodef) ) {
            	            alt5=1;
            	        }


            	        } finally {dbg.exitDecision(5);}

            	        switch (alt5) {
            	    	case 1 :
            	    	    dbg.enterAlt(1);

            	    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:22: macro ( Lb )?
            	    	    {
            	    	    dbg.location(205,22);
            	    	    pushFollow(FOLLOW_macro_in_block233);
            	    	    macro8=macro();

            	    	    state._fsp--;

            	    	    stream_macro.add(macro8.getTree());
            	    	    dbg.location(205,28);
            	    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:28: ( Lb )?
            	    	    int alt4=2;
            	    	    try { dbg.enterSubRule(4);
            	    	    try { dbg.enterDecision(4, decisionCanBacktrack[4]);

            	    	    int LA4_0 = input.LA(1);

            	    	    if ( (LA4_0==Lb) ) {
            	    	        alt4=1;
            	    	    }
            	    	    } finally {dbg.exitDecision(4);}

            	    	    switch (alt4) {
            	    	        case 1 :
            	    	            dbg.enterAlt(1);

            	    	            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:28: Lb
            	    	            {
            	    	            dbg.location(205,28);
            	    	            Lb9=(Token)match(input,Lb,FOLLOW_Lb_in_block235);  
            	    	            stream_Lb.add(Lb9);


            	    	            }
            	    	            break;

            	    	    }
            	    	    } finally {dbg.exitSubRule(4);}


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop5;
            	        }
            	    } while (true);
            	    } finally {dbg.exitSubRule(5);}

            	    dbg.location(205,34);
            	    pushFollow(FOLLOW_record_in_block240);
            	    record10=record();

            	    state._fsp--;

            	    stream_record.add(record10.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt6++;
            } while (true);
            } finally {dbg.exitSubRule(6);}


            // AST REWRITE
            // elements: record, header
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 206:2: -> ^( BLOCK header ^( RECORDS ( record )+ ) )
            {
                dbg.location(206,5);
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:206:5: ^( BLOCK header ^( RECORDS ( record )+ ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(206,7);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCK, "BLOCK")
                , root_1);

                dbg.location(206,13);
                adaptor.addChild(root_1, stream_header.nextTree());
                dbg.location(206,20);
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:206:20: ^( RECORDS ( record )+ )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(206,22);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(RECORDS, "RECORDS")
                , root_2);

                dbg.location(206,30);
                if ( !(stream_record.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_record.hasNext() ) {
                    dbg.location(206,30);
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
        dbg.location(206, 38);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "block");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "block"


    public static class header_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "header"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:208:1: header : headerMode Identifier ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )* ( Semicolon ( attribute )? )* ( Semicolon DocumentID ( Semicolon ( attribute )? )* )? -> ^( HEADER headerMode ^( TYPE Identifier ) ^( MODIFIERS ( headerModifierAssignment )* ) ( ^( DOCUMENTID DocumentID ) )? ^( ATTRIBUTES ( attribute )* ) ) ;
    public final ImpexParser.header_return header() throws RecognitionException {
        ImpexParser.header_return retval = new ImpexParser.header_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Identifier12=null;
        Token LBracket13=null;
        Token Comma15=null;
        Token RBracket17=null;
        Token Semicolon18=null;
        Token Semicolon20=null;
        Token DocumentID21=null;
        Token Semicolon22=null;
        ImpexParser.headerMode_return headerMode11 =null;

        ImpexParser.headerModifierAssignment_return headerModifierAssignment14 =null;

        ImpexParser.headerModifierAssignment_return headerModifierAssignment16 =null;

        ImpexParser.attribute_return attribute19 =null;

        ImpexParser.attribute_return attribute23 =null;


        CommonTree Identifier12_tree=null;
        CommonTree LBracket13_tree=null;
        CommonTree Comma15_tree=null;
        CommonTree RBracket17_tree=null;
        CommonTree Semicolon18_tree=null;
        CommonTree Semicolon20_tree=null;
        CommonTree DocumentID21_tree=null;
        CommonTree Semicolon22_tree=null;
        RewriteRuleTokenStream stream_DocumentID=new RewriteRuleTokenStream(adaptor,"token DocumentID");
        RewriteRuleTokenStream stream_RBracket=new RewriteRuleTokenStream(adaptor,"token RBracket");
        RewriteRuleTokenStream stream_LBracket=new RewriteRuleTokenStream(adaptor,"token LBracket");
        RewriteRuleTokenStream stream_Semicolon=new RewriteRuleTokenStream(adaptor,"token Semicolon");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_headerMode=new RewriteRuleSubtreeStream(adaptor,"rule headerMode");
        RewriteRuleSubtreeStream stream_headerModifierAssignment=new RewriteRuleSubtreeStream(adaptor,"rule headerModifierAssignment");
        RewriteRuleSubtreeStream stream_attribute=new RewriteRuleSubtreeStream(adaptor,"rule attribute");
        try { dbg.enterRule(getGrammarFileName(), "header");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(208, 0);

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:209:2: ( headerMode Identifier ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )* ( Semicolon ( attribute )? )* ( Semicolon DocumentID ( Semicolon ( attribute )? )* )? -> ^( HEADER headerMode ^( TYPE Identifier ) ^( MODIFIERS ( headerModifierAssignment )* ) ( ^( DOCUMENTID DocumentID ) )? ^( ATTRIBUTES ( attribute )* ) ) )
            dbg.enterAlt(1);

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:209:4: headerMode Identifier ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )* ( Semicolon ( attribute )? )* ( Semicolon DocumentID ( Semicolon ( attribute )? )* )?
            {
            dbg.location(209,4);
            pushFollow(FOLLOW_headerMode_in_header267);
            headerMode11=headerMode();

            state._fsp--;

            stream_headerMode.add(headerMode11.getTree());
            dbg.location(209,16);
            Identifier12=(Token)match(input,Identifier,FOLLOW_Identifier_in_header270);  
            stream_Identifier.add(Identifier12);

            dbg.location(209,27);
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:209:27: ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )*
            try { dbg.enterSubRule(8);

            loop8:
            do {
                int alt8=2;
                try { dbg.enterDecision(8, decisionCanBacktrack[8]);

                int LA8_0 = input.LA(1);

                if ( (LA8_0==LBracket) ) {
                    alt8=1;
                }


                } finally {dbg.exitDecision(8);}

                switch (alt8) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:209:28: LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket
            	    {
            	    dbg.location(209,28);
            	    LBracket13=(Token)match(input,LBracket,FOLLOW_LBracket_in_header273);  
            	    stream_LBracket.add(LBracket13);

            	    dbg.location(209,37);
            	    pushFollow(FOLLOW_headerModifierAssignment_in_header275);
            	    headerModifierAssignment14=headerModifierAssignment();

            	    state._fsp--;

            	    stream_headerModifierAssignment.add(headerModifierAssignment14.getTree());
            	    dbg.location(209,62);
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:209:62: ( Comma headerModifierAssignment )*
            	    try { dbg.enterSubRule(7);

            	    loop7:
            	    do {
            	        int alt7=2;
            	        try { dbg.enterDecision(7, decisionCanBacktrack[7]);

            	        int LA7_0 = input.LA(1);

            	        if ( (LA7_0==Comma) ) {
            	            alt7=1;
            	        }


            	        } finally {dbg.exitDecision(7);}

            	        switch (alt7) {
            	    	case 1 :
            	    	    dbg.enterAlt(1);

            	    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:209:63: Comma headerModifierAssignment
            	    	    {
            	    	    dbg.location(209,63);
            	    	    Comma15=(Token)match(input,Comma,FOLLOW_Comma_in_header278);  
            	    	    stream_Comma.add(Comma15);

            	    	    dbg.location(209,70);
            	    	    pushFollow(FOLLOW_headerModifierAssignment_in_header281);
            	    	    headerModifierAssignment16=headerModifierAssignment();

            	    	    state._fsp--;

            	    	    stream_headerModifierAssignment.add(headerModifierAssignment16.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop7;
            	        }
            	    } while (true);
            	    } finally {dbg.exitSubRule(7);}

            	    dbg.location(209,97);
            	    RBracket17=(Token)match(input,RBracket,FOLLOW_RBracket_in_header285);  
            	    stream_RBracket.add(RBracket17);


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);
            } finally {dbg.exitSubRule(8);}

            dbg.location(209,109);
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:209:109: ( Semicolon ( attribute )? )*
            try { dbg.enterSubRule(10);

            loop10:
            do {
                int alt10=2;
                try { dbg.enterDecision(10, decisionCanBacktrack[10]);

                int LA10_0 = input.LA(1);

                if ( (LA10_0==Semicolon) ) {
                    int LA10_1 = input.LA(2);

                    if ( (LA10_1==Identifier||LA10_1==Lb||LA10_1==Macrodef||(LA10_1 >= Semicolon && LA10_1 <= SpecialAttribute)) ) {
                        alt10=1;
                    }


                }


                } finally {dbg.exitDecision(10);}

                switch (alt10) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:209:110: Semicolon ( attribute )?
            	    {
            	    dbg.location(209,110);
            	    Semicolon18=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_header291);  
            	    stream_Semicolon.add(Semicolon18);

            	    dbg.location(209,120);
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:209:120: ( attribute )?
            	    int alt9=2;
            	    try { dbg.enterSubRule(9);
            	    try { dbg.enterDecision(9, decisionCanBacktrack[9]);

            	    int LA9_0 = input.LA(1);

            	    if ( (LA9_0==Identifier||LA9_0==Macrodef||LA9_0==SpecialAttribute) ) {
            	        alt9=1;
            	    }
            	    } finally {dbg.exitDecision(9);}

            	    switch (alt9) {
            	        case 1 :
            	            dbg.enterAlt(1);

            	            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:209:120: attribute
            	            {
            	            dbg.location(209,120);
            	            pushFollow(FOLLOW_attribute_in_header293);
            	            attribute19=attribute();

            	            state._fsp--;

            	            stream_attribute.add(attribute19.getTree());

            	            }
            	            break;

            	    }
            	    } finally {dbg.exitSubRule(9);}


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);
            } finally {dbg.exitSubRule(10);}

            dbg.location(209,133);
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:209:133: ( Semicolon DocumentID ( Semicolon ( attribute )? )* )?
            int alt13=2;
            try { dbg.enterSubRule(13);
            try { dbg.enterDecision(13, decisionCanBacktrack[13]);

            int LA13_0 = input.LA(1);

            if ( (LA13_0==Semicolon) ) {
                alt13=1;
            }
            } finally {dbg.exitDecision(13);}

            switch (alt13) {
                case 1 :
                    dbg.enterAlt(1);

                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:209:134: Semicolon DocumentID ( Semicolon ( attribute )? )*
                    {
                    dbg.location(209,134);
                    Semicolon20=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_header299);  
                    stream_Semicolon.add(Semicolon20);

                    dbg.location(209,144);
                    DocumentID21=(Token)match(input,DocumentID,FOLLOW_DocumentID_in_header301);  
                    stream_DocumentID.add(DocumentID21);

                    dbg.location(209,154);
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:209:154: ( Semicolon ( attribute )? )*
                    try { dbg.enterSubRule(12);

                    loop12:
                    do {
                        int alt12=2;
                        try { dbg.enterDecision(12, decisionCanBacktrack[12]);

                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==Semicolon) ) {
                            alt12=1;
                        }


                        } finally {dbg.exitDecision(12);}

                        switch (alt12) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:209:155: Semicolon ( attribute )?
                    	    {
                    	    dbg.location(209,155);
                    	    Semicolon22=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_header303);  
                    	    stream_Semicolon.add(Semicolon22);

                    	    dbg.location(209,165);
                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:209:165: ( attribute )?
                    	    int alt11=2;
                    	    try { dbg.enterSubRule(11);
                    	    try { dbg.enterDecision(11, decisionCanBacktrack[11]);

                    	    int LA11_0 = input.LA(1);

                    	    if ( (LA11_0==Identifier||LA11_0==Macrodef||LA11_0==SpecialAttribute) ) {
                    	        alt11=1;
                    	    }
                    	    } finally {dbg.exitDecision(11);}

                    	    switch (alt11) {
                    	        case 1 :
                    	            dbg.enterAlt(1);

                    	            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:209:165: attribute
                    	            {
                    	            dbg.location(209,165);
                    	            pushFollow(FOLLOW_attribute_in_header305);
                    	            attribute23=attribute();

                    	            state._fsp--;

                    	            stream_attribute.add(attribute23.getTree());

                    	            }
                    	            break;

                    	    }
                    	    } finally {dbg.exitSubRule(11);}


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(12);}


                    }
                    break;

            }
            } finally {dbg.exitSubRule(13);}


            // AST REWRITE
            // elements: Identifier, attribute, headerModifierAssignment, DocumentID, headerMode
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 210:2: -> ^( HEADER headerMode ^( TYPE Identifier ) ^( MODIFIERS ( headerModifierAssignment )* ) ( ^( DOCUMENTID DocumentID ) )? ^( ATTRIBUTES ( attribute )* ) )
            {
                dbg.location(210,5);
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:210:5: ^( HEADER headerMode ^( TYPE Identifier ) ^( MODIFIERS ( headerModifierAssignment )* ) ( ^( DOCUMENTID DocumentID ) )? ^( ATTRIBUTES ( attribute )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(210,7);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(HEADER, "HEADER")
                , root_1);

                dbg.location(210,14);
                adaptor.addChild(root_1, stream_headerMode.nextTree());
                dbg.location(210,25);
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:210:25: ^( TYPE Identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(210,27);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(TYPE, "TYPE")
                , root_2);

                dbg.location(210,32);
                adaptor.addChild(root_2, 
                stream_Identifier.nextNode()
                );

                adaptor.addChild(root_1, root_2);
                }
                dbg.location(210,44);
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:210:44: ^( MODIFIERS ( headerModifierAssignment )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(210,46);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(MODIFIERS, "MODIFIERS")
                , root_2);

                dbg.location(210,56);
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:210:56: ( headerModifierAssignment )*
                while ( stream_headerModifierAssignment.hasNext() ) {
                    dbg.location(210,56);
                    adaptor.addChild(root_2, stream_headerModifierAssignment.nextTree());

                }
                stream_headerModifierAssignment.reset();

                adaptor.addChild(root_1, root_2);
                }
                dbg.location(210,83);
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:210:83: ( ^( DOCUMENTID DocumentID ) )?
                if ( stream_DocumentID.hasNext() ) {
                    dbg.location(210,83);
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:210:83: ^( DOCUMENTID DocumentID )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    dbg.location(210,85);
                    root_2 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(DOCUMENTID, "DOCUMENTID")
                    , root_2);

                    dbg.location(210,96);
                    adaptor.addChild(root_2, 
                    stream_DocumentID.nextNode()
                    );

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_DocumentID.reset();
                dbg.location(210,109);
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:210:109: ^( ATTRIBUTES ( attribute )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(210,111);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ATTRIBUTES, "ATTRIBUTES")
                , root_2);

                dbg.location(210,122);
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:210:122: ( attribute )*
                while ( stream_attribute.hasNext() ) {
                    dbg.location(210,122);
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
        dbg.location(210, 134);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "header");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "header"


    public static class headerModifierAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "headerModifierAssignment"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:212:1: headerModifierAssignment : headerModifier Equals boolOrClassname -> ^( MODIFIER headerModifier boolOrClassname ) ;
    public final ImpexParser.headerModifierAssignment_return headerModifierAssignment() throws RecognitionException {
        ImpexParser.headerModifierAssignment_return retval = new ImpexParser.headerModifierAssignment_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Equals25=null;
        ImpexParser.headerModifier_return headerModifier24 =null;

        ImpexParser.boolOrClassname_return boolOrClassname26 =null;


        CommonTree Equals25_tree=null;
        RewriteRuleTokenStream stream_Equals=new RewriteRuleTokenStream(adaptor,"token Equals");
        RewriteRuleSubtreeStream stream_headerModifier=new RewriteRuleSubtreeStream(adaptor,"rule headerModifier");
        RewriteRuleSubtreeStream stream_boolOrClassname=new RewriteRuleSubtreeStream(adaptor,"rule boolOrClassname");
        try { dbg.enterRule(getGrammarFileName(), "headerModifierAssignment");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(212, 0);

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:212:25: ( headerModifier Equals boolOrClassname -> ^( MODIFIER headerModifier boolOrClassname ) )
            dbg.enterAlt(1);

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:212:27: headerModifier Equals boolOrClassname
            {
            dbg.location(212,27);
            pushFollow(FOLLOW_headerModifier_in_headerModifierAssignment355);
            headerModifier24=headerModifier();

            state._fsp--;

            stream_headerModifier.add(headerModifier24.getTree());
            dbg.location(212,42);
            Equals25=(Token)match(input,Equals,FOLLOW_Equals_in_headerModifierAssignment357);  
            stream_Equals.add(Equals25);

            dbg.location(212,49);
            pushFollow(FOLLOW_boolOrClassname_in_headerModifierAssignment359);
            boolOrClassname26=boolOrClassname();

            state._fsp--;

            stream_boolOrClassname.add(boolOrClassname26.getTree());

            // AST REWRITE
            // elements: boolOrClassname, headerModifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 213:2: -> ^( MODIFIER headerModifier boolOrClassname )
            {
                dbg.location(213,5);
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:213:5: ^( MODIFIER headerModifier boolOrClassname )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(213,7);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(MODIFIER, "MODIFIER")
                , root_1);

                dbg.location(213,16);
                adaptor.addChild(root_1, stream_headerModifier.nextTree());
                dbg.location(213,31);
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
        dbg.location(213, 46);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "headerModifierAssignment");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "headerModifierAssignment"


    public static class boolOrClassname_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "boolOrClassname"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:215:1: boolOrClassname : ( Bool | Classname );
    public final ImpexParser.boolOrClassname_return boolOrClassname() throws RecognitionException {
        ImpexParser.boolOrClassname_return retval = new ImpexParser.boolOrClassname_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set27=null;

        CommonTree set27_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "boolOrClassname");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(215, 0);

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:216:2: ( Bool | Classname )
            dbg.enterAlt(1);

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(216,2);
            set27=(Token)input.LT(1);

            if ( input.LA(1)==Bool||input.LA(1)==Classname ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set27)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
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
        dbg.location(216, 18);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "boolOrClassname");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "boolOrClassname"


    public static class headerModifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "headerModifier"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:218:1: headerModifier : ( BatchMode | CacheUnique | Processor );
    public final ImpexParser.headerModifier_return headerModifier() throws RecognitionException {
        ImpexParser.headerModifier_return retval = new ImpexParser.headerModifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set28=null;

        CommonTree set28_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "headerModifier");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(218, 0);

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:219:2: ( BatchMode | CacheUnique | Processor )
            dbg.enterAlt(1);

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(219,2);
            set28=(Token)input.LT(1);

            if ( input.LA(1)==BatchMode||input.LA(1)==CacheUnique||input.LA(1)==Processor ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set28)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
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
        dbg.location(219, 37);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "headerModifier");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "headerModifier"


    public static class record_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "record"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:222:1: record : ( Identifier )? ( field )+ -> ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) ) ;
    public final ImpexParser.record_return record() throws RecognitionException {
        ImpexParser.record_return retval = new ImpexParser.record_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Identifier29=null;
        ImpexParser.field_return field30 =null;


        CommonTree Identifier29_tree=null;
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_field=new RewriteRuleSubtreeStream(adaptor,"rule field");
        try { dbg.enterRule(getGrammarFileName(), "record");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(222, 0);

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:223:5: ( ( Identifier )? ( field )+ -> ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) ) )
            dbg.enterAlt(1);

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:223:7: ( Identifier )? ( field )+
            {
            dbg.location(223,7);
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:223:7: ( Identifier )?
            int alt14=2;
            try { dbg.enterSubRule(14);
            try { dbg.enterDecision(14, decisionCanBacktrack[14]);

            int LA14_0 = input.LA(1);

            if ( (LA14_0==Identifier) ) {
                alt14=1;
            }
            } finally {dbg.exitDecision(14);}

            switch (alt14) {
                case 1 :
                    dbg.enterAlt(1);

                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:223:7: Identifier
                    {
                    dbg.location(223,7);
                    Identifier29=(Token)match(input,Identifier,FOLLOW_Identifier_in_record412);  
                    stream_Identifier.add(Identifier29);


                    }
                    break;

            }
            } finally {dbg.exitSubRule(14);}

            dbg.location(223,19);
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:223:19: ( field )+
            int cnt15=0;
            try { dbg.enterSubRule(15);

            loop15:
            do {
                int alt15=2;
                try { dbg.enterDecision(15, decisionCanBacktrack[15]);

                int LA15_0 = input.LA(1);

                if ( (LA15_0==Field||LA15_0==QuotedField) ) {
                    alt15=1;
                }


                } finally {dbg.exitDecision(15);}

                switch (alt15) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:223:19: field
            	    {
            	    dbg.location(223,19);
            	    pushFollow(FOLLOW_field_in_record415);
            	    field30=field();

            	    state._fsp--;

            	    stream_field.add(field30.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt15 >= 1 ) break loop15;
                        EarlyExitException eee =
                            new EarlyExitException(15, input);
                        dbg.recognitionException(eee);

                        throw eee;
                }
                cnt15++;
            } while (true);
            } finally {dbg.exitSubRule(15);}


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
            // 224:6: -> ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) )
            {
                dbg.location(224,9);
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:224:9: ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(224,11);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(RECORD, "RECORD")
                , root_1);

                dbg.location(224,18);
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:224:18: ^( SUBTYPE ( Identifier )? )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(224,20);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(SUBTYPE, "SUBTYPE")
                , root_2);

                dbg.location(224,28);
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:224:28: ( Identifier )?
                if ( stream_Identifier.hasNext() ) {
                    dbg.location(224,28);
                    adaptor.addChild(root_2, 
                    stream_Identifier.nextNode()
                    );

                }
                stream_Identifier.reset();

                adaptor.addChild(root_1, root_2);
                }
                dbg.location(224,41);
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:224:41: ^( FIELDS ( field )+ )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(224,43);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(FIELDS, "FIELDS")
                , root_2);

                dbg.location(224,50);
                if ( !(stream_field.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_field.hasNext() ) {
                    dbg.location(224,50);
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
        dbg.location(224, 57);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "record");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "record"


    public static class field_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:226:1: field : ( QuotedField | Field );
    public final ImpexParser.field_return field() throws RecognitionException {
        ImpexParser.field_return retval = new ImpexParser.field_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set31=null;

        CommonTree set31_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "field");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(226, 0);

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:226:7: ( QuotedField | Field )
            dbg.enterAlt(1);

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(226,7);
            set31=(Token)input.LT(1);

            if ( input.LA(1)==Field||input.LA(1)==QuotedField ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set31)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
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
        dbg.location(226, 26);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "field");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "field"


    public static class attributeName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "attributeName"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:250:1: attributeName : ( Macrodef -> ^( MACRO_REF Macrodef ) | SpecialAttribute -> ^( ATTRIBUTE_NAME SpecialAttribute ) | ( Identifier ( Dot attributeName )? ) -> ^( ATTRIBUTE_NAME Identifier ( attributeName )? ) );
    public final ImpexParser.attributeName_return attributeName() throws RecognitionException {
        ImpexParser.attributeName_return retval = new ImpexParser.attributeName_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Macrodef32=null;
        Token SpecialAttribute33=null;
        Token Identifier34=null;
        Token Dot35=null;
        ImpexParser.attributeName_return attributeName36 =null;


        CommonTree Macrodef32_tree=null;
        CommonTree SpecialAttribute33_tree=null;
        CommonTree Identifier34_tree=null;
        CommonTree Dot35_tree=null;
        RewriteRuleTokenStream stream_Dot=new RewriteRuleTokenStream(adaptor,"token Dot");
        RewriteRuleTokenStream stream_SpecialAttribute=new RewriteRuleTokenStream(adaptor,"token SpecialAttribute");
        RewriteRuleTokenStream stream_Macrodef=new RewriteRuleTokenStream(adaptor,"token Macrodef");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_attributeName=new RewriteRuleSubtreeStream(adaptor,"rule attributeName");
        try { dbg.enterRule(getGrammarFileName(), "attributeName");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(250, 0);

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:251:2: ( Macrodef -> ^( MACRO_REF Macrodef ) | SpecialAttribute -> ^( ATTRIBUTE_NAME SpecialAttribute ) | ( Identifier ( Dot attributeName )? ) -> ^( ATTRIBUTE_NAME Identifier ( attributeName )? ) )
            int alt17=3;
            try { dbg.enterDecision(17, decisionCanBacktrack[17]);

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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }

            } finally {dbg.exitDecision(17);}

            switch (alt17) {
                case 1 :
                    dbg.enterAlt(1);

                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:251:3: Macrodef
                    {
                    dbg.location(251,3);
                    Macrodef32=(Token)match(input,Macrodef,FOLLOW_Macrodef_in_attributeName484);  
                    stream_Macrodef.add(Macrodef32);


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
                    // 251:12: -> ^( MACRO_REF Macrodef )
                    {
                        dbg.location(251,15);
                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:251:15: ^( MACRO_REF Macrodef )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        dbg.location(251,17);
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(MACRO_REF, "MACRO_REF")
                        , root_1);

                        dbg.location(251,28);
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
                    dbg.enterAlt(2);

                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:252:4: SpecialAttribute
                    {
                    dbg.location(252,4);
                    SpecialAttribute33=(Token)match(input,SpecialAttribute,FOLLOW_SpecialAttribute_in_attributeName498);  
                    stream_SpecialAttribute.add(SpecialAttribute33);


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
                    // 252:21: -> ^( ATTRIBUTE_NAME SpecialAttribute )
                    {
                        dbg.location(252,24);
                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:252:24: ^( ATTRIBUTE_NAME SpecialAttribute )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        dbg.location(252,26);
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(ATTRIBUTE_NAME, "ATTRIBUTE_NAME")
                        , root_1);

                        dbg.location(252,41);
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
                    dbg.enterAlt(3);

                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:253:3: ( Identifier ( Dot attributeName )? )
                    {
                    dbg.location(253,3);
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:253:3: ( Identifier ( Dot attributeName )? )
                    dbg.enterAlt(1);

                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:253:4: Identifier ( Dot attributeName )?
                    {
                    dbg.location(253,4);
                    Identifier34=(Token)match(input,Identifier,FOLLOW_Identifier_in_attributeName511);  
                    stream_Identifier.add(Identifier34);

                    dbg.location(253,15);
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:253:15: ( Dot attributeName )?
                    int alt16=2;
                    try { dbg.enterSubRule(16);
                    try { dbg.enterDecision(16, decisionCanBacktrack[16]);

                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==Dot) ) {
                        alt16=1;
                    }
                    } finally {dbg.exitDecision(16);}

                    switch (alt16) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:253:16: Dot attributeName
                            {
                            dbg.location(253,16);
                            Dot35=(Token)match(input,Dot,FOLLOW_Dot_in_attributeName514);  
                            stream_Dot.add(Dot35);

                            dbg.location(253,20);
                            pushFollow(FOLLOW_attributeName_in_attributeName516);
                            attributeName36=attributeName();

                            state._fsp--;

                            stream_attributeName.add(attributeName36.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(16);}


                    }


                    // AST REWRITE
                    // elements: Identifier, attributeName
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 253:37: -> ^( ATTRIBUTE_NAME Identifier ( attributeName )? )
                    {
                        dbg.location(253,40);
                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:253:40: ^( ATTRIBUTE_NAME Identifier ( attributeName )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        dbg.location(253,42);
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(ATTRIBUTE_NAME, "ATTRIBUTE_NAME")
                        , root_1);

                        dbg.location(253,57);
                        adaptor.addChild(root_1, 
                        stream_Identifier.nextNode()
                        );
                        dbg.location(253,68);
                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:253:68: ( attributeName )?
                        if ( stream_attributeName.hasNext() ) {
                            dbg.location(253,68);
                            adaptor.addChild(root_1, stream_attributeName.nextTree());

                        }
                        stream_attributeName.reset();

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
        dbg.location(253, 82);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "attributeName");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "attributeName"


    public static class attribute_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "attribute"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:255:1: attribute : attributeName ( LParenthesis ( DocumentID | attribute ) ( Comma ( DocumentID | attribute ) )* RParenthesis )? ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket )* -> ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifierAssignment )* ) ) ;
    public final ImpexParser.attribute_return attribute() throws RecognitionException {
        ImpexParser.attribute_return retval = new ImpexParser.attribute_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token LParenthesis38=null;
        Token DocumentID39=null;
        Token Comma41=null;
        Token DocumentID42=null;
        Token RParenthesis44=null;
        Token LBracket45=null;
        Token Comma47=null;
        Token RBracket49=null;
        ImpexParser.attributeName_return attributeName37 =null;

        ImpexParser.attribute_return attribute40 =null;

        ImpexParser.attribute_return attribute43 =null;

        ImpexParser.attributeModifierAssignment_return attributeModifierAssignment46 =null;

        ImpexParser.attributeModifierAssignment_return attributeModifierAssignment48 =null;


        CommonTree LParenthesis38_tree=null;
        CommonTree DocumentID39_tree=null;
        CommonTree Comma41_tree=null;
        CommonTree DocumentID42_tree=null;
        CommonTree RParenthesis44_tree=null;
        CommonTree LBracket45_tree=null;
        CommonTree Comma47_tree=null;
        CommonTree RBracket49_tree=null;
        RewriteRuleTokenStream stream_DocumentID=new RewriteRuleTokenStream(adaptor,"token DocumentID");
        RewriteRuleTokenStream stream_RBracket=new RewriteRuleTokenStream(adaptor,"token RBracket");
        RewriteRuleTokenStream stream_LBracket=new RewriteRuleTokenStream(adaptor,"token LBracket");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_LParenthesis=new RewriteRuleTokenStream(adaptor,"token LParenthesis");
        RewriteRuleTokenStream stream_RParenthesis=new RewriteRuleTokenStream(adaptor,"token RParenthesis");
        RewriteRuleSubtreeStream stream_attributeName=new RewriteRuleSubtreeStream(adaptor,"rule attributeName");
        RewriteRuleSubtreeStream stream_attribute=new RewriteRuleSubtreeStream(adaptor,"rule attribute");
        RewriteRuleSubtreeStream stream_attributeModifierAssignment=new RewriteRuleSubtreeStream(adaptor,"rule attributeModifierAssignment");
        try { dbg.enterRule(getGrammarFileName(), "attribute");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(255, 0);

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:256:2: ( attributeName ( LParenthesis ( DocumentID | attribute ) ( Comma ( DocumentID | attribute ) )* RParenthesis )? ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket )* -> ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifierAssignment )* ) ) )
            dbg.enterAlt(1);

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:256:3: attributeName ( LParenthesis ( DocumentID | attribute ) ( Comma ( DocumentID | attribute ) )* RParenthesis )? ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket )*
            {
            dbg.location(256,3);
            pushFollow(FOLLOW_attributeName_in_attribute540);
            attributeName37=attributeName();

            state._fsp--;

            stream_attributeName.add(attributeName37.getTree());
            dbg.location(256,17);
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:256:17: ( LParenthesis ( DocumentID | attribute ) ( Comma ( DocumentID | attribute ) )* RParenthesis )?
            int alt21=2;
            try { dbg.enterSubRule(21);
            try { dbg.enterDecision(21, decisionCanBacktrack[21]);

            int LA21_0 = input.LA(1);

            if ( (LA21_0==LParenthesis) ) {
                alt21=1;
            }
            } finally {dbg.exitDecision(21);}

            switch (alt21) {
                case 1 :
                    dbg.enterAlt(1);

                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:256:18: LParenthesis ( DocumentID | attribute ) ( Comma ( DocumentID | attribute ) )* RParenthesis
                    {
                    dbg.location(256,18);
                    LParenthesis38=(Token)match(input,LParenthesis,FOLLOW_LParenthesis_in_attribute543);  
                    stream_LParenthesis.add(LParenthesis38);

                    dbg.location(256,32);
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:256:32: ( DocumentID | attribute )
                    int alt18=2;
                    try { dbg.enterSubRule(18);
                    try { dbg.enterDecision(18, decisionCanBacktrack[18]);

                    int LA18_0 = input.LA(1);

                    if ( (LA18_0==DocumentID) ) {
                        alt18=1;
                    }
                    else if ( (LA18_0==Identifier||LA18_0==Macrodef||LA18_0==SpecialAttribute) ) {
                        alt18=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 18, 0, input);

                        dbg.recognitionException(nvae);
                        throw nvae;

                    }
                    } finally {dbg.exitDecision(18);}

                    switch (alt18) {
                        case 1 :
                            dbg.enterAlt(1);

                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:256:33: DocumentID
                            {
                            dbg.location(256,33);
                            DocumentID39=(Token)match(input,DocumentID,FOLLOW_DocumentID_in_attribute547);  
                            stream_DocumentID.add(DocumentID39);


                            }
                            break;
                        case 2 :
                            dbg.enterAlt(2);

                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:256:46: attribute
                            {
                            dbg.location(256,46);
                            pushFollow(FOLLOW_attribute_in_attribute551);
                            attribute40=attribute();

                            state._fsp--;

                            stream_attribute.add(attribute40.getTree());

                            }
                            break;

                    }
                    } finally {dbg.exitSubRule(18);}

                    dbg.location(256,56);
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:256:56: ( Comma ( DocumentID | attribute ) )*
                    try { dbg.enterSubRule(20);

                    loop20:
                    do {
                        int alt20=2;
                        try { dbg.enterDecision(20, decisionCanBacktrack[20]);

                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==Comma) ) {
                            alt20=1;
                        }


                        } finally {dbg.exitDecision(20);}

                        switch (alt20) {
                    	case 1 :
                    	    dbg.enterAlt(1);

                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:256:57: Comma ( DocumentID | attribute )
                    	    {
                    	    dbg.location(256,57);
                    	    Comma41=(Token)match(input,Comma,FOLLOW_Comma_in_attribute554);  
                    	    stream_Comma.add(Comma41);

                    	    dbg.location(256,63);
                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:256:63: ( DocumentID | attribute )
                    	    int alt19=2;
                    	    try { dbg.enterSubRule(19);
                    	    try { dbg.enterDecision(19, decisionCanBacktrack[19]);

                    	    int LA19_0 = input.LA(1);

                    	    if ( (LA19_0==DocumentID) ) {
                    	        alt19=1;
                    	    }
                    	    else if ( (LA19_0==Identifier||LA19_0==Macrodef||LA19_0==SpecialAttribute) ) {
                    	        alt19=2;
                    	    }
                    	    else {
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 19, 0, input);

                    	        dbg.recognitionException(nvae);
                    	        throw nvae;

                    	    }
                    	    } finally {dbg.exitDecision(19);}

                    	    switch (alt19) {
                    	        case 1 :
                    	            dbg.enterAlt(1);

                    	            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:256:64: DocumentID
                    	            {
                    	            dbg.location(256,64);
                    	            DocumentID42=(Token)match(input,DocumentID,FOLLOW_DocumentID_in_attribute557);  
                    	            stream_DocumentID.add(DocumentID42);


                    	            }
                    	            break;
                    	        case 2 :
                    	            dbg.enterAlt(2);

                    	            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:256:77: attribute
                    	            {
                    	            dbg.location(256,77);
                    	            pushFollow(FOLLOW_attribute_in_attribute561);
                    	            attribute43=attribute();

                    	            state._fsp--;

                    	            stream_attribute.add(attribute43.getTree());

                    	            }
                    	            break;

                    	    }
                    	    } finally {dbg.exitSubRule(19);}


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);
                    } finally {dbg.exitSubRule(20);}

                    dbg.location(256,90);
                    RParenthesis44=(Token)match(input,RParenthesis,FOLLOW_RParenthesis_in_attribute566);  
                    stream_RParenthesis.add(RParenthesis44);


                    }
                    break;

            }
            } finally {dbg.exitSubRule(21);}

            dbg.location(256,106);
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:256:106: ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket )*
            try { dbg.enterSubRule(23);

            loop23:
            do {
                int alt23=2;
                try { dbg.enterDecision(23, decisionCanBacktrack[23]);

                int LA23_0 = input.LA(1);

                if ( (LA23_0==LBracket) ) {
                    alt23=1;
                }


                } finally {dbg.exitDecision(23);}

                switch (alt23) {
            	case 1 :
            	    dbg.enterAlt(1);

            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:256:107: LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket
            	    {
            	    dbg.location(256,107);
            	    LBracket45=(Token)match(input,LBracket,FOLLOW_LBracket_in_attribute572);  
            	    stream_LBracket.add(LBracket45);

            	    dbg.location(256,116);
            	    pushFollow(FOLLOW_attributeModifierAssignment_in_attribute574);
            	    attributeModifierAssignment46=attributeModifierAssignment();

            	    state._fsp--;

            	    stream_attributeModifierAssignment.add(attributeModifierAssignment46.getTree());
            	    dbg.location(256,144);
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:256:144: ( Comma attributeModifierAssignment )*
            	    try { dbg.enterSubRule(22);

            	    loop22:
            	    do {
            	        int alt22=2;
            	        try { dbg.enterDecision(22, decisionCanBacktrack[22]);

            	        int LA22_0 = input.LA(1);

            	        if ( (LA22_0==Comma) ) {
            	            alt22=1;
            	        }


            	        } finally {dbg.exitDecision(22);}

            	        switch (alt22) {
            	    	case 1 :
            	    	    dbg.enterAlt(1);

            	    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:256:145: Comma attributeModifierAssignment
            	    	    {
            	    	    dbg.location(256,145);
            	    	    Comma47=(Token)match(input,Comma,FOLLOW_Comma_in_attribute577);  
            	    	    stream_Comma.add(Comma47);

            	    	    dbg.location(256,152);
            	    	    pushFollow(FOLLOW_attributeModifierAssignment_in_attribute580);
            	    	    attributeModifierAssignment48=attributeModifierAssignment();

            	    	    state._fsp--;

            	    	    stream_attributeModifierAssignment.add(attributeModifierAssignment48.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop22;
            	        }
            	    } while (true);
            	    } finally {dbg.exitSubRule(22);}

            	    dbg.location(256,182);
            	    RBracket49=(Token)match(input,RBracket,FOLLOW_RBracket_in_attribute584);  
            	    stream_RBracket.add(RBracket49);


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);
            } finally {dbg.exitSubRule(23);}


            // AST REWRITE
            // elements: attribute, DocumentID, attributeName, attributeModifierAssignment
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 257:2: -> ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifierAssignment )* ) )
            {
                dbg.location(257,5);
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:257:5: ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifierAssignment )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(257,7);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ATTRIBUTE, "ATTRIBUTE")
                , root_1);

                dbg.location(257,17);
                adaptor.addChild(root_1, stream_attributeName.nextTree());
                dbg.location(257,31);
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:257:31: ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(257,33);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ITEM_EXPRESSION, "ITEM_EXPRESSION")
                , root_2);

                dbg.location(257,49);
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:257:49: ( attribute )*
                while ( stream_attribute.hasNext() ) {
                    dbg.location(257,49);
                    adaptor.addChild(root_2, stream_attribute.nextTree());

                }
                stream_attribute.reset();
                dbg.location(257,60);
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:257:60: ^( DOCUMENTID_REF ( DocumentID )* )
                {
                CommonTree root_3 = (CommonTree)adaptor.nil();
                dbg.location(257,62);
                root_3 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(DOCUMENTID_REF, "DOCUMENTID_REF")
                , root_3);

                dbg.location(257,77);
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:257:77: ( DocumentID )*
                while ( stream_DocumentID.hasNext() ) {
                    dbg.location(257,77);
                    adaptor.addChild(root_3, 
                    stream_DocumentID.nextNode()
                    );

                }
                stream_DocumentID.reset();

                adaptor.addChild(root_2, root_3);
                }

                adaptor.addChild(root_1, root_2);
                }
                dbg.location(257,91);
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:257:91: ^( MODIFIERS ( attributeModifierAssignment )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                dbg.location(257,93);
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(MODIFIERS, "MODIFIERS")
                , root_2);

                dbg.location(257,103);
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:257:103: ( attributeModifierAssignment )*
                while ( stream_attributeModifierAssignment.hasNext() ) {
                    dbg.location(257,103);
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
        dbg.location(257, 132);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "attribute");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "attribute"


    public static class attributeModifierAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "attributeModifierAssignment"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:259:1: attributeModifierAssignment : attributeModifier ValueAssignment -> ^( MODIFIER attributeModifier ValueAssignment ) ;
    public final ImpexParser.attributeModifierAssignment_return attributeModifierAssignment() throws RecognitionException {
        ImpexParser.attributeModifierAssignment_return retval = new ImpexParser.attributeModifierAssignment_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ValueAssignment51=null;
        ImpexParser.attributeModifier_return attributeModifier50 =null;


        CommonTree ValueAssignment51_tree=null;
        RewriteRuleTokenStream stream_ValueAssignment=new RewriteRuleTokenStream(adaptor,"token ValueAssignment");
        RewriteRuleSubtreeStream stream_attributeModifier=new RewriteRuleSubtreeStream(adaptor,"rule attributeModifier");
        try { dbg.enterRule(getGrammarFileName(), "attributeModifierAssignment");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(259, 0);

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:260:2: ( attributeModifier ValueAssignment -> ^( MODIFIER attributeModifier ValueAssignment ) )
            dbg.enterAlt(1);

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:260:4: attributeModifier ValueAssignment
            {
            dbg.location(260,4);
            pushFollow(FOLLOW_attributeModifier_in_attributeModifierAssignment625);
            attributeModifier50=attributeModifier();

            state._fsp--;

            stream_attributeModifier.add(attributeModifier50.getTree());
            dbg.location(260,22);
            ValueAssignment51=(Token)match(input,ValueAssignment,FOLLOW_ValueAssignment_in_attributeModifierAssignment627);  
            stream_ValueAssignment.add(ValueAssignment51);


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
            // 261:2: -> ^( MODIFIER attributeModifier ValueAssignment )
            {
                dbg.location(261,5);
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:261:5: ^( MODIFIER attributeModifier ValueAssignment )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                dbg.location(261,7);
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(MODIFIER, "MODIFIER")
                , root_1);

                dbg.location(261,16);
                adaptor.addChild(root_1, stream_attributeModifier.nextTree());
                dbg.location(261,34);
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
        dbg.location(261, 49);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "attributeModifierAssignment");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "attributeModifierAssignment"


    public static class macro_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "macro"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:267:1: macro : Macrodef ( ValueAssignment | Equals ) ;
    public final ImpexParser.macro_return macro() throws RecognitionException {
        ImpexParser.macro_return retval = new ImpexParser.macro_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Macrodef52=null;
        Token ValueAssignment53=null;
        Token Equals54=null;

        CommonTree Macrodef52_tree=null;
        CommonTree ValueAssignment53_tree=null;
        CommonTree Equals54_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "macro");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(267, 0);

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:268:2: ( Macrodef ( ValueAssignment | Equals ) )
            dbg.enterAlt(1);

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:268:3: Macrodef ( ValueAssignment | Equals )
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(268,3);
            Macrodef52=(Token)match(input,Macrodef,FOLLOW_Macrodef_in_macro651); 
            Macrodef52_tree = 
            (CommonTree)adaptor.create(Macrodef52)
            ;
            adaptor.addChild(root_0, Macrodef52_tree);

            dbg.location(269,2);
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:269:2: ( ValueAssignment | Equals )
            int alt24=2;
            try { dbg.enterSubRule(24);
            try { dbg.enterDecision(24, decisionCanBacktrack[24]);

            int LA24_0 = input.LA(1);

            if ( (LA24_0==ValueAssignment) ) {
                alt24=1;
            }
            else if ( (LA24_0==Equals) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                dbg.recognitionException(nvae);
                throw nvae;

            }
            } finally {dbg.exitDecision(24);}

            switch (alt24) {
                case 1 :
                    dbg.enterAlt(1);

                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:269:3: ValueAssignment
                    {
                    dbg.location(269,3);
                    ValueAssignment53=(Token)match(input,ValueAssignment,FOLLOW_ValueAssignment_in_macro656); 
                    ValueAssignment53_tree = 
                    (CommonTree)adaptor.create(ValueAssignment53)
                    ;
                    adaptor.addChild(root_0, ValueAssignment53_tree);

                    dbg.location(269,19);
                    registerMacro(Macrodef52, (ValueAssignment53!=null?ValueAssignment53.getText():null));

                    }
                    break;
                case 2 :
                    dbg.enterAlt(2);

                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:270:3: Equals
                    {
                    dbg.location(270,3);
                    Equals54=(Token)match(input,Equals,FOLLOW_Equals_in_macro663); 
                    Equals54_tree = 
                    (CommonTree)adaptor.create(Equals54)
                    ;
                    adaptor.addChild(root_0, Equals54_tree);

                    dbg.location(270,10);
                    registerMacro(Macrodef52, "");

                    }
                    break;

            }
            } finally {dbg.exitSubRule(24);}


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
        dbg.location(270, 41);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "macro");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "macro"


    public static class attributeModifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "attributeModifier"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:272:1: attributeModifier : ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual );
    public final ImpexParser.attributeModifier_return attributeModifier() throws RecognitionException {
        ImpexParser.attributeModifier_return retval = new ImpexParser.attributeModifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set55=null;

        CommonTree set55_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "attributeModifier");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(272, 0);

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:273:2: ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual )
            dbg.enterAlt(1);

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(273,2);
            set55=(Token)input.LT(1);

            if ( (input.LA(1) >= Alias && input.LA(1) <= AllowNull)||input.LA(1)==CellDecorator||input.LA(1)==CollectionDelimiter||(input.LA(1) >= Dateformat && input.LA(1) <= Default)||input.LA(1)==ForceWrite||(input.LA(1) >= IgnoreKeyCase && input.LA(1) <= IgnoreNull)||input.LA(1)==KeyToValueDelimiter||input.LA(1)==Lang||(input.LA(1) >= MapDelimiter && input.LA(1) <= Mode)||input.LA(1)==NumberFormat||(input.LA(1) >= PathDelimiter && input.LA(1) <= Pos)||(input.LA(1) >= Translator && input.LA(1) <= Unique)||input.LA(1)==Virtual ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set55)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
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
        dbg.location(274, 120);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "attributeModifier");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "attributeModifier"


    public static class headerMode_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "headerMode"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:276:1: headerMode : ( Insert | InsertUpdate | Update | Remove );
    public final ImpexParser.headerMode_return headerMode() throws RecognitionException {
        ImpexParser.headerMode_return retval = new ImpexParser.headerMode_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set56=null;

        CommonTree set56_tree=null;

        try { dbg.enterRule(getGrammarFileName(), "headerMode");
        if ( getRuleLevel()==0 ) {dbg.commence();}
        incRuleLevel();
        dbg.location(276, 0);

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:277:2: ( Insert | InsertUpdate | Update | Remove )
            dbg.enterAlt(1);

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            dbg.location(277,2);
            set56=(Token)input.LT(1);

            if ( (input.LA(1) >= Insert && input.LA(1) <= InsertUpdate)||input.LA(1)==Remove||input.LA(1)==Update ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set56)
                );
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                dbg.recognitionException(mse);
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
        dbg.location(277, 41);

        }
        finally {
            dbg.exitRule(getGrammarFileName(), "headerMode");
            decRuleLevel();
            if ( getRuleLevel()==0 ) {dbg.terminate();}
        }

        return retval;
    }
    // $ANTLR end "headerMode"

    // Delegated rules


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\10\uffff";
    static final String DFA6_eofS =
        "\1\1\1\uffff\1\1\2\uffff\3\1";
    static final String DFA6_minS =
        "\1\50\1\uffff\1\36\1\34\1\uffff\3\36";
    static final String DFA6_maxS =
        "\1\107\1\uffff\1\107\1\110\1\uffff\3\107";
    static final String DFA6_acceptS =
        "\1\uffff\1\2\2\uffff\1\1\3\uffff";
    static final String DFA6_specialS =
        "\10\uffff}>";
    static final String[] DFA6_transitionS = {
            "\2\1\4\uffff\1\2\3\uffff\1\1\15\uffff\1\1\6\uffff\1\1",
            "",
            "\1\4\6\uffff\1\4\2\uffff\2\1\4\uffff\1\2\3\uffff\1\3\10\uffff"+
            "\1\4\4\uffff\1\1\6\uffff\1\1",
            "\1\6\53\uffff\1\5",
            "",
            "\1\4\6\uffff\1\4\2\uffff\2\1\4\uffff\1\7\3\uffff\1\3\10\uffff"+
            "\1\4\4\uffff\1\1\6\uffff\1\1",
            "\1\4\6\uffff\1\4\2\uffff\2\1\4\uffff\1\7\3\uffff\1\3\10\uffff"+
            "\1\4\4\uffff\1\1\6\uffff\1\1",
            "\1\4\6\uffff\1\4\2\uffff\2\1\4\uffff\1\1\3\uffff\1\3\10\uffff"+
            "\1\4\4\uffff\1\1\6\uffff\1\1"
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
            return "()+ loopback of 205:16: ( ( Lb )+ ( macro ( Lb )? )* record )+";
        }
        public void error(NoViableAltException nvae) {
            dbg.recognitionException(nvae);
        }
    }
 

    public static final BitSet FOLLOW_EOF_in_parse178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Lb_in_impex190 = new BitSet(new long[]{0x0004430000000000L,0x0000000000000081L});
    public static final BitSet FOLLOW_block_in_impex195 = new BitSet(new long[]{0x0004430000000000L,0x0000000000000081L});
    public static final BitSet FOLLOW_macro_in_impex199 = new BitSet(new long[]{0x0004430000000000L,0x0000000000000081L});
    public static final BitSet FOLLOW_EOF_in_impex203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_header_in_block226 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_Lb_in_block229 = new BitSet(new long[]{0x0804402040000000L});
    public static final BitSet FOLLOW_macro_in_block233 = new BitSet(new long[]{0x0804402040000000L});
    public static final BitSet FOLLOW_Lb_in_block235 = new BitSet(new long[]{0x0804002040000000L});
    public static final BitSet FOLLOW_record_in_block240 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_headerMode_in_header267 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_Identifier_in_header270 = new BitSet(new long[]{0x0000080000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_LBracket_in_header273 = new BitSet(new long[]{0x0400000000005000L});
    public static final BitSet FOLLOW_headerModifierAssignment_in_header275 = new BitSet(new long[]{0x1000000000080000L});
    public static final BitSet FOLLOW_Comma_in_header278 = new BitSet(new long[]{0x0400000000005000L});
    public static final BitSet FOLLOW_headerModifierAssignment_in_header281 = new BitSet(new long[]{0x1000000000080000L});
    public static final BitSet FOLLOW_RBracket_in_header285 = new BitSet(new long[]{0x0000080000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_Semicolon_in_header291 = new BitSet(new long[]{0x0004002000000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_attribute_in_header293 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_Semicolon_in_header299 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_DocumentID_in_header301 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_Semicolon_in_header303 = new BitSet(new long[]{0x0004002000000002L,0x000000000000000CL});
    public static final BitSet FOLLOW_attribute_in_header305 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_headerModifier_in_headerModifierAssignment355 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_Equals_in_headerModifierAssignment357 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_boolOrClassname_in_headerModifierAssignment359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_record412 = new BitSet(new long[]{0x0800000040000000L});
    public static final BitSet FOLLOW_field_in_record415 = new BitSet(new long[]{0x0800000040000002L});
    public static final BitSet FOLLOW_Macrodef_in_attributeName484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SpecialAttribute_in_attributeName498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_attributeName511 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_Dot_in_attributeName514 = new BitSet(new long[]{0x0004002000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_attributeName_in_attributeName516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeName_in_attribute540 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_LParenthesis_in_attribute543 = new BitSet(new long[]{0x0004002002000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_DocumentID_in_attribute547 = new BitSet(new long[]{0x8000000000080000L});
    public static final BitSet FOLLOW_attribute_in_attribute551 = new BitSet(new long[]{0x8000000000080000L});
    public static final BitSet FOLLOW_Comma_in_attribute554 = new BitSet(new long[]{0x0004002002000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_DocumentID_in_attribute557 = new BitSet(new long[]{0x8000000000080000L});
    public static final BitSet FOLLOW_attribute_in_attribute561 = new BitSet(new long[]{0x8000000000080000L});
    public static final BitSet FOLLOW_RParenthesis_in_attribute566 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_LBracket_in_attribute572 = new BitSet(new long[]{0x035824C081848180L,0x0000000000000260L});
    public static final BitSet FOLLOW_attributeModifierAssignment_in_attribute574 = new BitSet(new long[]{0x1000000000080000L});
    public static final BitSet FOLLOW_Comma_in_attribute577 = new BitSet(new long[]{0x035824C081848180L,0x0000000000000260L});
    public static final BitSet FOLLOW_attributeModifierAssignment_in_attribute580 = new BitSet(new long[]{0x1000000000080000L});
    public static final BitSet FOLLOW_RBracket_in_attribute584 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_attributeModifier_in_attributeModifierAssignment625 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ValueAssignment_in_attributeModifierAssignment627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Macrodef_in_macro651 = new BitSet(new long[]{0x0000000010000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ValueAssignment_in_macro656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Equals_in_macro663 = new BitSet(new long[]{0x0000000000000002L});

}