// $ANTLR 3.4 /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g 2012-12-02 21:54:46

 package output;
  

//import java.util.AbstractMap.SimpleImmutableEntry;  
import java.util.HashMap;
import java.util.Map;
//import java.util.regex.Pattern;
//import java.util.regex.Matcher;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class ImpexParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTRIBUTE", "ATTRIBUTES", "ATTRIBUTE_NAME", "Alias", "AllowNull", "AttributeModifier", "BLOCK", "BLOCKS", "BatchMode", "Bool", "CacheUnique", "CellDecorator", "Char", "Classname", "CollectionDelimiter", "Comma", "Comment", "DOCUMENTID", "DOCUMENTID_REF", "Dateformat", "Default", "DocumentID", "Dot", "DoubleQuote", "Equals", "FIELDS", "Field", "ForceWrite", "HEADER", "HeaderMode", "HeaderModifier", "IMPEX", "ITEM_EXPRESSION", "Identifier", "IgnoreKeyCase", "IgnoreNull", "Insert", "InsertUpdate", "KeyToValueDelimiter", "LBracket", "LParenthesis", "Lang", "Lb", "MACRO", "MACROS", "MACRO_REF", "MODIFIER", "MODIFIERS", "Macrodef", "MapDelimiter", "Mode", "NextRow", "NumberFormat", "Or", "PathDelimiter", "Pos", "Processor", "QuotedField", "RBracket", "RECORD", "RECORDS", "RParenthesis", "Remove", "SUBTYPE", "Semicolon", "SpecialAttribute", "TYPE", "Translator", "Unique", "Update", "ValueAssignement", "Virtual", "Ws"
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
    public static final int MACRO=47;
    public static final int MACROS=48;
    public static final int MACRO_REF=49;
    public static final int MODIFIER=50;
    public static final int MODIFIERS=51;
    public static final int Macrodef=52;
    public static final int MapDelimiter=53;
    public static final int Mode=54;
    public static final int NextRow=55;
    public static final int NumberFormat=56;
    public static final int Or=57;
    public static final int PathDelimiter=58;
    public static final int Pos=59;
    public static final int Processor=60;
    public static final int QuotedField=61;
    public static final int RBracket=62;
    public static final int RECORD=63;
    public static final int RECORDS=64;
    public static final int RParenthesis=65;
    public static final int Remove=66;
    public static final int SUBTYPE=67;
    public static final int Semicolon=68;
    public static final int SpecialAttribute=69;
    public static final int TYPE=70;
    public static final int Translator=71;
    public static final int Unique=72;
    public static final int Update=73;
    public static final int ValueAssignement=74;
    public static final int Virtual=75;
    public static final int Ws=76;

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


    private final Map<String, Map<Integer, String>> macros = new HashMap<String, Map<Integer, String>>();
    //private final Pattern macroPattern = Pattern.compile("$[a-zA-Z_][a-zA-Z_0-9]*");
    //Matcher m = macroPattern.matcher(val);
     //       while(m.find()) {        }
     
     
    private void registerMacro(final Token def, final String val){
        final String macrodef = def.getText();
        Map<Integer, String> macroval = macros.get(macrodef);
        if (macroval == null) {
            macroval = new HashMap<Integer, String>();
            macros.put(macrodef, macroval);
        }
        macroval.put(def.getLine(), val);
    }


    public static class parse_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "parse"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:175:1: parse : (t= . )* EOF ;
    public final ImpexParser.parse_return parse() throws RecognitionException {
        ImpexParser.parse_return retval = new ImpexParser.parse_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token t=null;
        Token EOF1=null;

        CommonTree t_tree=null;
        CommonTree EOF1_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:176:3: ( (t= . )* EOF )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:176:6: (t= . )* EOF
            {
            root_0 = (CommonTree)adaptor.nil();


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:176:6: (t= . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= ATTRIBUTE && LA1_0 <= Ws)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:176:7: t= .
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


            EOF1=(Token)match(input,EOF,FOLLOW_EOF_in_parse186); 
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:178:1: impex : ( Lb | block | macro )* EOF -> ^( IMPEX ^( MACROS ( macro )* ) ^( BLOCKS ( block )* ) ) ;
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:178:7: ( ( Lb | block | macro )* EOF -> ^( IMPEX ^( MACROS ( macro )* ) ^( BLOCKS ( block )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:178:9: ( Lb | block | macro )* EOF
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:178:9: ( Lb | block | macro )*
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
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:178:10: Lb
            	    {
            	    Lb2=(Token)match(input,Lb,FOLLOW_Lb_in_impex198);  
            	    stream_Lb.add(Lb2);


            	    }
            	    break;
            	case 2 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:178:16: block
            	    {
            	    pushFollow(FOLLOW_block_in_impex203);
            	    block3=block();

            	    state._fsp--;

            	    stream_block.add(block3.getTree());

            	    }
            	    break;
            	case 3 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:178:24: macro
            	    {
            	    pushFollow(FOLLOW_macro_in_impex207);
            	    macro4=macro();

            	    state._fsp--;

            	    stream_macro.add(macro4.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            EOF5=(Token)match(input,EOF,FOLLOW_EOF_in_impex211);  
            stream_EOF.add(EOF5);


            // AST REWRITE
            // elements: macro, block
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 179:3: -> ^( IMPEX ^( MACROS ( macro )* ) ^( BLOCKS ( block )* ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:179:6: ^( IMPEX ^( MACROS ( macro )* ) ^( BLOCKS ( block )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IMPEX, "IMPEX")
                , root_1);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:179:14: ^( MACROS ( macro )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(MACROS, "MACROS")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:179:23: ( macro )*
                while ( stream_macro.hasNext() ) {
                    adaptor.addChild(root_2, stream_macro.nextTree());

                }
                stream_macro.reset();

                adaptor.addChild(root_1, root_2);
                }

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:179:32: ^( BLOCKS ( block )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCKS, "BLOCKS")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:179:41: ( block )*
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:181:1: block : header ( ( Lb )+ ( macro )? record )+ -> ^( BLOCK header ^( RECORDS ( record )+ ) ) ;
    public final ImpexParser.block_return block() throws RecognitionException {
        ImpexParser.block_return retval = new ImpexParser.block_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Lb7=null;
        ImpexParser.header_return header6 =null;

        ImpexParser.macro_return macro8 =null;

        ImpexParser.record_return record9 =null;


        CommonTree Lb7_tree=null;
        RewriteRuleTokenStream stream_Lb=new RewriteRuleTokenStream(adaptor,"token Lb");
        RewriteRuleSubtreeStream stream_record=new RewriteRuleSubtreeStream(adaptor,"rule record");
        RewriteRuleSubtreeStream stream_macro=new RewriteRuleSubtreeStream(adaptor,"rule macro");
        RewriteRuleSubtreeStream stream_header=new RewriteRuleSubtreeStream(adaptor,"rule header");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:181:7: ( header ( ( Lb )+ ( macro )? record )+ -> ^( BLOCK header ^( RECORDS ( record )+ ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:181:9: header ( ( Lb )+ ( macro )? record )+
            {
            pushFollow(FOLLOW_header_in_block242);
            header6=header();

            state._fsp--;

            stream_header.add(header6.getTree());

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:181:16: ( ( Lb )+ ( macro )? record )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                alt5 = dfa5.predict(input);
                switch (alt5) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:181:17: ( Lb )+ ( macro )? record
            	    {
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:181:17: ( Lb )+
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
            	    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:181:17: Lb
            	    	    {
            	    	    Lb7=(Token)match(input,Lb,FOLLOW_Lb_in_block245);  
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


            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:181:21: ( macro )?
            	    int alt4=2;
            	    int LA4_0 = input.LA(1);

            	    if ( (LA4_0==Macrodef) ) {
            	        alt4=1;
            	    }
            	    switch (alt4) {
            	        case 1 :
            	            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:181:21: macro
            	            {
            	            pushFollow(FOLLOW_macro_in_block248);
            	            macro8=macro();

            	            state._fsp--;

            	            stream_macro.add(macro8.getTree());

            	            }
            	            break;

            	    }


            	    pushFollow(FOLLOW_record_in_block252);
            	    record9=record();

            	    state._fsp--;

            	    stream_record.add(record9.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


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
            // 182:2: -> ^( BLOCK header ^( RECORDS ( record )+ ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:182:5: ^( BLOCK header ^( RECORDS ( record )+ ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCK, "BLOCK")
                , root_1);

                adaptor.addChild(root_1, stream_header.nextTree());

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:182:20: ^( RECORDS ( record )+ )
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:184:1: header : headerMode Identifier ( headerModifiers )? ( Semicolon ( attribute )? )* ( Semicolon DocumentID ( Semicolon ( attribute )? )* )? -> ^( HEADER headerMode ^( TYPE Identifier ) ( ^( MODIFIERS headerModifiers ) )? ( ^( DOCUMENTID DocumentID ) )? ^( ATTRIBUTES ( attribute )* ) ) ;
    public final ImpexParser.header_return header() throws RecognitionException {
        ImpexParser.header_return retval = new ImpexParser.header_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Identifier11=null;
        Token Semicolon13=null;
        Token Semicolon15=null;
        Token DocumentID16=null;
        Token Semicolon17=null;
        ImpexParser.headerMode_return headerMode10 =null;

        ImpexParser.headerModifiers_return headerModifiers12 =null;

        ImpexParser.attribute_return attribute14 =null;

        ImpexParser.attribute_return attribute18 =null;


        CommonTree Identifier11_tree=null;
        CommonTree Semicolon13_tree=null;
        CommonTree Semicolon15_tree=null;
        CommonTree DocumentID16_tree=null;
        CommonTree Semicolon17_tree=null;
        RewriteRuleTokenStream stream_DocumentID=new RewriteRuleTokenStream(adaptor,"token DocumentID");
        RewriteRuleTokenStream stream_Semicolon=new RewriteRuleTokenStream(adaptor,"token Semicolon");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_headerMode=new RewriteRuleSubtreeStream(adaptor,"rule headerMode");
        RewriteRuleSubtreeStream stream_attribute=new RewriteRuleSubtreeStream(adaptor,"rule attribute");
        RewriteRuleSubtreeStream stream_headerModifiers=new RewriteRuleSubtreeStream(adaptor,"rule headerModifiers");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:185:2: ( headerMode Identifier ( headerModifiers )? ( Semicolon ( attribute )? )* ( Semicolon DocumentID ( Semicolon ( attribute )? )* )? -> ^( HEADER headerMode ^( TYPE Identifier ) ( ^( MODIFIERS headerModifiers ) )? ( ^( DOCUMENTID DocumentID ) )? ^( ATTRIBUTES ( attribute )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:185:4: headerMode Identifier ( headerModifiers )? ( Semicolon ( attribute )? )* ( Semicolon DocumentID ( Semicolon ( attribute )? )* )?
            {
            pushFollow(FOLLOW_headerMode_in_header279);
            headerMode10=headerMode();

            state._fsp--;

            stream_headerMode.add(headerMode10.getTree());

            Identifier11=(Token)match(input,Identifier,FOLLOW_Identifier_in_header282);  
            stream_Identifier.add(Identifier11);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:185:27: ( headerModifiers )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==LBracket) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:185:27: headerModifiers
                    {
                    pushFollow(FOLLOW_headerModifiers_in_header284);
                    headerModifiers12=headerModifiers();

                    state._fsp--;

                    stream_headerModifiers.add(headerModifiers12.getTree());

                    }
                    break;

            }


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:185:45: ( Semicolon ( attribute )? )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==Semicolon) ) {
                    int LA8_1 = input.LA(2);

                    if ( (LA8_1==Identifier||LA8_1==Lb||LA8_1==Macrodef||(LA8_1 >= Semicolon && LA8_1 <= SpecialAttribute)) ) {
                        alt8=1;
                    }


                }


                switch (alt8) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:185:46: Semicolon ( attribute )?
            	    {
            	    Semicolon13=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_header289);  
            	    stream_Semicolon.add(Semicolon13);


            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:185:56: ( attribute )?
            	    int alt7=2;
            	    int LA7_0 = input.LA(1);

            	    if ( (LA7_0==Identifier||LA7_0==Macrodef||LA7_0==SpecialAttribute) ) {
            	        alt7=1;
            	    }
            	    switch (alt7) {
            	        case 1 :
            	            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:185:56: attribute
            	            {
            	            pushFollow(FOLLOW_attribute_in_header291);
            	            attribute14=attribute();

            	            state._fsp--;

            	            stream_attribute.add(attribute14.getTree());

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:185:69: ( Semicolon DocumentID ( Semicolon ( attribute )? )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==Semicolon) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:185:70: Semicolon DocumentID ( Semicolon ( attribute )? )*
                    {
                    Semicolon15=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_header297);  
                    stream_Semicolon.add(Semicolon15);


                    DocumentID16=(Token)match(input,DocumentID,FOLLOW_DocumentID_in_header299);  
                    stream_DocumentID.add(DocumentID16);


                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:185:90: ( Semicolon ( attribute )? )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==Semicolon) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:185:91: Semicolon ( attribute )?
                    	    {
                    	    Semicolon17=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_header301);  
                    	    stream_Semicolon.add(Semicolon17);


                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:185:101: ( attribute )?
                    	    int alt9=2;
                    	    int LA9_0 = input.LA(1);

                    	    if ( (LA9_0==Identifier||LA9_0==Macrodef||LA9_0==SpecialAttribute) ) {
                    	        alt9=1;
                    	    }
                    	    switch (alt9) {
                    	        case 1 :
                    	            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:185:101: attribute
                    	            {
                    	            pushFollow(FOLLOW_attribute_in_header303);
                    	            attribute18=attribute();

                    	            state._fsp--;

                    	            stream_attribute.add(attribute18.getTree());

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;

            }


            // AST REWRITE
            // elements: Identifier, headerMode, headerModifiers, attribute, DocumentID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 186:2: -> ^( HEADER headerMode ^( TYPE Identifier ) ( ^( MODIFIERS headerModifiers ) )? ( ^( DOCUMENTID DocumentID ) )? ^( ATTRIBUTES ( attribute )* ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:186:5: ^( HEADER headerMode ^( TYPE Identifier ) ( ^( MODIFIERS headerModifiers ) )? ( ^( DOCUMENTID DocumentID ) )? ^( ATTRIBUTES ( attribute )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(HEADER, "HEADER")
                , root_1);

                adaptor.addChild(root_1, stream_headerMode.nextTree());

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:186:25: ^( TYPE Identifier )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(TYPE, "TYPE")
                , root_2);

                adaptor.addChild(root_2, 
                stream_Identifier.nextNode()
                );

                adaptor.addChild(root_1, root_2);
                }

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:186:44: ( ^( MODIFIERS headerModifiers ) )?
                if ( stream_headerModifiers.hasNext() ) {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:186:44: ^( MODIFIERS headerModifiers )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(MODIFIERS, "MODIFIERS")
                    , root_2);

                    adaptor.addChild(root_2, stream_headerModifiers.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_headerModifiers.reset();

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:186:74: ( ^( DOCUMENTID DocumentID ) )?
                if ( stream_DocumentID.hasNext() ) {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:186:74: ^( DOCUMENTID DocumentID )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(DOCUMENTID, "DOCUMENTID")
                    , root_2);

                    adaptor.addChild(root_2, 
                    stream_DocumentID.nextNode()
                    );

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_DocumentID.reset();

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:186:100: ^( ATTRIBUTES ( attribute )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ATTRIBUTES, "ATTRIBUTES")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:186:113: ( attribute )*
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


    public static class headerModifiers_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "headerModifiers"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:188:1: headerModifiers : ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )+ -> ^( MODIFIERS ( headerModifierAssignment )+ ) ;
    public final ImpexParser.headerModifiers_return headerModifiers() throws RecognitionException {
        ImpexParser.headerModifiers_return retval = new ImpexParser.headerModifiers_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token LBracket19=null;
        Token Comma21=null;
        Token RBracket23=null;
        ImpexParser.headerModifierAssignment_return headerModifierAssignment20 =null;

        ImpexParser.headerModifierAssignment_return headerModifierAssignment22 =null;


        CommonTree LBracket19_tree=null;
        CommonTree Comma21_tree=null;
        CommonTree RBracket23_tree=null;
        RewriteRuleTokenStream stream_RBracket=new RewriteRuleTokenStream(adaptor,"token RBracket");
        RewriteRuleTokenStream stream_LBracket=new RewriteRuleTokenStream(adaptor,"token LBracket");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleSubtreeStream stream_headerModifierAssignment=new RewriteRuleSubtreeStream(adaptor,"rule headerModifierAssignment");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:189:2: ( ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )+ -> ^( MODIFIERS ( headerModifierAssignment )+ ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:189:4: ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )+
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:189:4: ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==LBracket) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:189:5: LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket
            	    {
            	    LBracket19=(Token)match(input,LBracket,FOLLOW_LBracket_in_headerModifiers357);  
            	    stream_LBracket.add(LBracket19);


            	    pushFollow(FOLLOW_headerModifierAssignment_in_headerModifiers359);
            	    headerModifierAssignment20=headerModifierAssignment();

            	    state._fsp--;

            	    stream_headerModifierAssignment.add(headerModifierAssignment20.getTree());

            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:189:39: ( Comma headerModifierAssignment )*
            	    loop12:
            	    do {
            	        int alt12=2;
            	        int LA12_0 = input.LA(1);

            	        if ( (LA12_0==Comma) ) {
            	            alt12=1;
            	        }


            	        switch (alt12) {
            	    	case 1 :
            	    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:189:40: Comma headerModifierAssignment
            	    	    {
            	    	    Comma21=(Token)match(input,Comma,FOLLOW_Comma_in_headerModifiers362);  
            	    	    stream_Comma.add(Comma21);


            	    	    pushFollow(FOLLOW_headerModifierAssignment_in_headerModifiers365);
            	    	    headerModifierAssignment22=headerModifierAssignment();

            	    	    state._fsp--;

            	    	    stream_headerModifierAssignment.add(headerModifierAssignment22.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop12;
            	        }
            	    } while (true);


            	    RBracket23=(Token)match(input,RBracket,FOLLOW_RBracket_in_headerModifiers369);  
            	    stream_RBracket.add(RBracket23);


            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);


            // AST REWRITE
            // elements: headerModifierAssignment
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 190:2: -> ^( MODIFIERS ( headerModifierAssignment )+ )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:190:5: ^( MODIFIERS ( headerModifierAssignment )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(MODIFIERS, "MODIFIERS")
                , root_1);

                if ( !(stream_headerModifierAssignment.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_headerModifierAssignment.hasNext() ) {
                    adaptor.addChild(root_1, stream_headerModifierAssignment.nextTree());

                }
                stream_headerModifierAssignment.reset();

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
    // $ANTLR end "headerModifiers"


    public static class headerModifierAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "headerModifierAssignment"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:192:1: headerModifierAssignment : headerModifier Equals boolOrClassname -> ^( MODIFIER headerModifier boolOrClassname ) ;
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
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:192:25: ( headerModifier Equals boolOrClassname -> ^( MODIFIER headerModifier boolOrClassname ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:192:27: headerModifier Equals boolOrClassname
            {
            pushFollow(FOLLOW_headerModifier_in_headerModifierAssignment388);
            headerModifier24=headerModifier();

            state._fsp--;

            stream_headerModifier.add(headerModifier24.getTree());

            Equals25=(Token)match(input,Equals,FOLLOW_Equals_in_headerModifierAssignment390);  
            stream_Equals.add(Equals25);


            pushFollow(FOLLOW_boolOrClassname_in_headerModifierAssignment392);
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
            // 193:2: -> ^( MODIFIER headerModifier boolOrClassname )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:193:5: ^( MODIFIER headerModifier boolOrClassname )
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:195:1: boolOrClassname : ( Bool | Classname );
    public final ImpexParser.boolOrClassname_return boolOrClassname() throws RecognitionException {
        ImpexParser.boolOrClassname_return retval = new ImpexParser.boolOrClassname_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set27=null;

        CommonTree set27_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:196:2: ( Bool | Classname )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:198:1: headerModifier : ( BatchMode | CacheUnique | Processor );
    public final ImpexParser.headerModifier_return headerModifier() throws RecognitionException {
        ImpexParser.headerModifier_return retval = new ImpexParser.headerModifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set28=null;

        CommonTree set28_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:199:2: ( BatchMode | CacheUnique | Processor )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:202:1: record : ( Identifier )? ( QuotedField | Field )+ -> ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( QuotedField )* ( Field )* ) ) ;
    public final ImpexParser.record_return record() throws RecognitionException {
        ImpexParser.record_return retval = new ImpexParser.record_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Identifier29=null;
        Token QuotedField30=null;
        Token Field31=null;

        CommonTree Identifier29_tree=null;
        CommonTree QuotedField30_tree=null;
        CommonTree Field31_tree=null;
        RewriteRuleTokenStream stream_Field=new RewriteRuleTokenStream(adaptor,"token Field");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_QuotedField=new RewriteRuleTokenStream(adaptor,"token QuotedField");

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:203:5: ( ( Identifier )? ( QuotedField | Field )+ -> ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( QuotedField )* ( Field )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:203:7: ( Identifier )? ( QuotedField | Field )+
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:203:7: ( Identifier )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==Identifier) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:203:7: Identifier
                    {
                    Identifier29=(Token)match(input,Identifier,FOLLOW_Identifier_in_record445);  
                    stream_Identifier.add(Identifier29);


                    }
                    break;

            }


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:203:19: ( QuotedField | Field )+
            int cnt15=0;
            loop15:
            do {
                int alt15=3;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==QuotedField) ) {
                    alt15=1;
                }
                else if ( (LA15_0==Field) ) {
                    alt15=2;
                }


                switch (alt15) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:203:20: QuotedField
            	    {
            	    QuotedField30=(Token)match(input,QuotedField,FOLLOW_QuotedField_in_record449);  
            	    stream_QuotedField.add(QuotedField30);


            	    }
            	    break;
            	case 2 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:203:34: Field
            	    {
            	    Field31=(Token)match(input,Field,FOLLOW_Field_in_record453);  
            	    stream_Field.add(Field31);


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
            // elements: QuotedField, Identifier, Field
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 204:6: -> ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( QuotedField )* ( Field )* ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:204:9: ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( QuotedField )* ( Field )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(RECORD, "RECORD")
                , root_1);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:204:18: ^( SUBTYPE ( Identifier )? )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(SUBTYPE, "SUBTYPE")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:204:28: ( Identifier )?
                if ( stream_Identifier.hasNext() ) {
                    adaptor.addChild(root_2, 
                    stream_Identifier.nextNode()
                    );

                }
                stream_Identifier.reset();

                adaptor.addChild(root_1, root_2);
                }

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:204:41: ^( FIELDS ( QuotedField )* ( Field )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(FIELDS, "FIELDS")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:204:50: ( QuotedField )*
                while ( stream_QuotedField.hasNext() ) {
                    adaptor.addChild(root_2, 
                    stream_QuotedField.nextNode()
                    );

                }
                stream_QuotedField.reset();

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:204:63: ( Field )*
                while ( stream_Field.hasNext() ) {
                    adaptor.addChild(root_2, 
                    stream_Field.nextNode()
                    );

                }
                stream_Field.reset();

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


    public static class attributeModifiers_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "attributeModifiers"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:225:1: attributeModifiers : ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket ) -> ^( MODIFIERS ( attributeModifierAssignment )+ ) ;
    public final ImpexParser.attributeModifiers_return attributeModifiers() throws RecognitionException {
        ImpexParser.attributeModifiers_return retval = new ImpexParser.attributeModifiers_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token LBracket32=null;
        Token Comma34=null;
        Token RBracket36=null;
        ImpexParser.attributeModifierAssignment_return attributeModifierAssignment33 =null;

        ImpexParser.attributeModifierAssignment_return attributeModifierAssignment35 =null;


        CommonTree LBracket32_tree=null;
        CommonTree Comma34_tree=null;
        CommonTree RBracket36_tree=null;
        RewriteRuleTokenStream stream_RBracket=new RewriteRuleTokenStream(adaptor,"token RBracket");
        RewriteRuleTokenStream stream_LBracket=new RewriteRuleTokenStream(adaptor,"token LBracket");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleSubtreeStream stream_attributeModifierAssignment=new RewriteRuleSubtreeStream(adaptor,"rule attributeModifierAssignment");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:226:2: ( ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket ) -> ^( MODIFIERS ( attributeModifierAssignment )+ ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:226:4: ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket )
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:226:4: ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:226:5: LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket
            {
            LBracket32=(Token)match(input,LBracket,FOLLOW_LBracket_in_attributeModifiers516);  
            stream_LBracket.add(LBracket32);


            pushFollow(FOLLOW_attributeModifierAssignment_in_attributeModifiers518);
            attributeModifierAssignment33=attributeModifierAssignment();

            state._fsp--;

            stream_attributeModifierAssignment.add(attributeModifierAssignment33.getTree());

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:226:42: ( Comma attributeModifierAssignment )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==Comma) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:226:43: Comma attributeModifierAssignment
            	    {
            	    Comma34=(Token)match(input,Comma,FOLLOW_Comma_in_attributeModifiers521);  
            	    stream_Comma.add(Comma34);


            	    pushFollow(FOLLOW_attributeModifierAssignment_in_attributeModifiers524);
            	    attributeModifierAssignment35=attributeModifierAssignment();

            	    state._fsp--;

            	    stream_attributeModifierAssignment.add(attributeModifierAssignment35.getTree());

            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            RBracket36=(Token)match(input,RBracket,FOLLOW_RBracket_in_attributeModifiers528);  
            stream_RBracket.add(RBracket36);


            }


            // AST REWRITE
            // elements: attributeModifierAssignment
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 227:2: -> ^( MODIFIERS ( attributeModifierAssignment )+ )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:227:5: ^( MODIFIERS ( attributeModifierAssignment )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(MODIFIERS, "MODIFIERS")
                , root_1);

                if ( !(stream_attributeModifierAssignment.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_attributeModifierAssignment.hasNext() ) {
                    adaptor.addChild(root_1, stream_attributeModifierAssignment.nextTree());

                }
                stream_attributeModifierAssignment.reset();

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
    // $ANTLR end "attributeModifiers"


    public static class attributeModifierAssignment_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "attributeModifierAssignment"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:229:1: attributeModifierAssignment : attributeModifier ValueAssignement -> ^( MODIFIER attributeModifier ValueAssignement ) ;
    public final ImpexParser.attributeModifierAssignment_return attributeModifierAssignment() throws RecognitionException {
        ImpexParser.attributeModifierAssignment_return retval = new ImpexParser.attributeModifierAssignment_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ValueAssignement38=null;
        ImpexParser.attributeModifier_return attributeModifier37 =null;


        CommonTree ValueAssignement38_tree=null;
        RewriteRuleTokenStream stream_ValueAssignement=new RewriteRuleTokenStream(adaptor,"token ValueAssignement");
        RewriteRuleSubtreeStream stream_attributeModifier=new RewriteRuleSubtreeStream(adaptor,"rule attributeModifier");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:230:2: ( attributeModifier ValueAssignement -> ^( MODIFIER attributeModifier ValueAssignement ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:230:4: attributeModifier ValueAssignement
            {
            pushFollow(FOLLOW_attributeModifier_in_attributeModifierAssignment548);
            attributeModifier37=attributeModifier();

            state._fsp--;

            stream_attributeModifier.add(attributeModifier37.getTree());

            ValueAssignement38=(Token)match(input,ValueAssignement,FOLLOW_ValueAssignement_in_attributeModifierAssignment550);  
            stream_ValueAssignement.add(ValueAssignement38);


            // AST REWRITE
            // elements: attributeModifier, ValueAssignement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 231:2: -> ^( MODIFIER attributeModifier ValueAssignement )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:231:5: ^( MODIFIER attributeModifier ValueAssignement )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(MODIFIER, "MODIFIER")
                , root_1);

                adaptor.addChild(root_1, stream_attributeModifier.nextTree());

                adaptor.addChild(root_1, 
                stream_ValueAssignement.nextNode()
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


    public static class attributeName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "attributeName"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:237:1: attributeName : ( Macrodef -> ^( MACRO_REF Macrodef ) | SpecialAttribute -> ^( ATTRIBUTE_NAME SpecialAttribute ) | ( Identifier ( Dot attributeName )? ) -> ^( ATTRIBUTE_NAME Identifier ( attributeName )? ) );
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:238:2: ( Macrodef -> ^( MACRO_REF Macrodef ) | SpecialAttribute -> ^( ATTRIBUTE_NAME SpecialAttribute ) | ( Identifier ( Dot attributeName )? ) -> ^( ATTRIBUTE_NAME Identifier ( attributeName )? ) )
            int alt18=3;
            switch ( input.LA(1) ) {
            case Macrodef:
                {
                alt18=1;
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
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;

            }

            switch (alt18) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:238:3: Macrodef
                    {
                    Macrodef39=(Token)match(input,Macrodef,FOLLOW_Macrodef_in_attributeName575);  
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
                    // 238:12: -> ^( MACRO_REF Macrodef )
                    {
                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:238:15: ^( MACRO_REF Macrodef )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(MACRO_REF, "MACRO_REF")
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
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:239:4: SpecialAttribute
                    {
                    SpecialAttribute40=(Token)match(input,SpecialAttribute,FOLLOW_SpecialAttribute_in_attributeName589);  
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
                    // 239:21: -> ^( ATTRIBUTE_NAME SpecialAttribute )
                    {
                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:239:24: ^( ATTRIBUTE_NAME SpecialAttribute )
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
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:240:3: ( Identifier ( Dot attributeName )? )
                    {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:240:3: ( Identifier ( Dot attributeName )? )
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:240:4: Identifier ( Dot attributeName )?
                    {
                    Identifier41=(Token)match(input,Identifier,FOLLOW_Identifier_in_attributeName602);  
                    stream_Identifier.add(Identifier41);


                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:240:15: ( Dot attributeName )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==Dot) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:240:16: Dot attributeName
                            {
                            Dot42=(Token)match(input,Dot,FOLLOW_Dot_in_attributeName605);  
                            stream_Dot.add(Dot42);


                            pushFollow(FOLLOW_attributeName_in_attributeName607);
                            attributeName43=attributeName();

                            state._fsp--;

                            stream_attributeName.add(attributeName43.getTree());

                            }
                            break;

                    }


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
                    // 240:37: -> ^( ATTRIBUTE_NAME Identifier ( attributeName )? )
                    {
                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:240:40: ^( ATTRIBUTE_NAME Identifier ( attributeName )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(ATTRIBUTE_NAME, "ATTRIBUTE_NAME")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_Identifier.nextNode()
                        );

                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:240:68: ( attributeName )?
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:242:1: attribute : attributeName ( LParenthesis ( DocumentID | attribute ) ( Comma ( DocumentID | attribute ) )* RParenthesis )? ( attributeModifiers )* -> ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifiers )* ) ) ;
    public final ImpexParser.attribute_return attribute() throws RecognitionException {
        ImpexParser.attribute_return retval = new ImpexParser.attribute_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token LParenthesis45=null;
        Token DocumentID46=null;
        Token Comma48=null;
        Token DocumentID49=null;
        Token RParenthesis51=null;
        ImpexParser.attributeName_return attributeName44 =null;

        ImpexParser.attribute_return attribute47 =null;

        ImpexParser.attribute_return attribute50 =null;

        ImpexParser.attributeModifiers_return attributeModifiers52 =null;


        CommonTree LParenthesis45_tree=null;
        CommonTree DocumentID46_tree=null;
        CommonTree Comma48_tree=null;
        CommonTree DocumentID49_tree=null;
        CommonTree RParenthesis51_tree=null;
        RewriteRuleTokenStream stream_DocumentID=new RewriteRuleTokenStream(adaptor,"token DocumentID");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleTokenStream stream_LParenthesis=new RewriteRuleTokenStream(adaptor,"token LParenthesis");
        RewriteRuleTokenStream stream_RParenthesis=new RewriteRuleTokenStream(adaptor,"token RParenthesis");
        RewriteRuleSubtreeStream stream_attributeName=new RewriteRuleSubtreeStream(adaptor,"rule attributeName");
        RewriteRuleSubtreeStream stream_attribute=new RewriteRuleSubtreeStream(adaptor,"rule attribute");
        RewriteRuleSubtreeStream stream_attributeModifiers=new RewriteRuleSubtreeStream(adaptor,"rule attributeModifiers");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:243:2: ( attributeName ( LParenthesis ( DocumentID | attribute ) ( Comma ( DocumentID | attribute ) )* RParenthesis )? ( attributeModifiers )* -> ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifiers )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:243:3: attributeName ( LParenthesis ( DocumentID | attribute ) ( Comma ( DocumentID | attribute ) )* RParenthesis )? ( attributeModifiers )*
            {
            pushFollow(FOLLOW_attributeName_in_attribute631);
            attributeName44=attributeName();

            state._fsp--;

            stream_attributeName.add(attributeName44.getTree());

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:243:17: ( LParenthesis ( DocumentID | attribute ) ( Comma ( DocumentID | attribute ) )* RParenthesis )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==LParenthesis) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:243:18: LParenthesis ( DocumentID | attribute ) ( Comma ( DocumentID | attribute ) )* RParenthesis
                    {
                    LParenthesis45=(Token)match(input,LParenthesis,FOLLOW_LParenthesis_in_attribute634);  
                    stream_LParenthesis.add(LParenthesis45);


                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:243:32: ( DocumentID | attribute )
                    int alt19=2;
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

                        throw nvae;

                    }
                    switch (alt19) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:243:33: DocumentID
                            {
                            DocumentID46=(Token)match(input,DocumentID,FOLLOW_DocumentID_in_attribute638);  
                            stream_DocumentID.add(DocumentID46);


                            }
                            break;
                        case 2 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:243:46: attribute
                            {
                            pushFollow(FOLLOW_attribute_in_attribute642);
                            attribute47=attribute();

                            state._fsp--;

                            stream_attribute.add(attribute47.getTree());

                            }
                            break;

                    }


                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:243:56: ( Comma ( DocumentID | attribute ) )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==Comma) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:243:57: Comma ( DocumentID | attribute )
                    	    {
                    	    Comma48=(Token)match(input,Comma,FOLLOW_Comma_in_attribute645);  
                    	    stream_Comma.add(Comma48);


                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:243:63: ( DocumentID | attribute )
                    	    int alt20=2;
                    	    int LA20_0 = input.LA(1);

                    	    if ( (LA20_0==DocumentID) ) {
                    	        alt20=1;
                    	    }
                    	    else if ( (LA20_0==Identifier||LA20_0==Macrodef||LA20_0==SpecialAttribute) ) {
                    	        alt20=2;
                    	    }
                    	    else {
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 20, 0, input);

                    	        throw nvae;

                    	    }
                    	    switch (alt20) {
                    	        case 1 :
                    	            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:243:64: DocumentID
                    	            {
                    	            DocumentID49=(Token)match(input,DocumentID,FOLLOW_DocumentID_in_attribute648);  
                    	            stream_DocumentID.add(DocumentID49);


                    	            }
                    	            break;
                    	        case 2 :
                    	            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:243:77: attribute
                    	            {
                    	            pushFollow(FOLLOW_attribute_in_attribute652);
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


                    RParenthesis51=(Token)match(input,RParenthesis,FOLLOW_RParenthesis_in_attribute657);  
                    stream_RParenthesis.add(RParenthesis51);


                    }
                    break;

            }


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:244:4: ( attributeModifiers )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==LBracket) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:244:4: attributeModifiers
            	    {
            	    pushFollow(FOLLOW_attributeModifiers_in_attribute665);
            	    attributeModifiers52=attributeModifiers();

            	    state._fsp--;

            	    stream_attributeModifiers.add(attributeModifiers52.getTree());

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            // AST REWRITE
            // elements: DocumentID, attributeModifiers, attribute, attributeName
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 245:2: -> ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifiers )* ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:245:5: ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifiers )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ATTRIBUTE, "ATTRIBUTE")
                , root_1);

                adaptor.addChild(root_1, stream_attributeName.nextTree());

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:245:31: ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ITEM_EXPRESSION, "ITEM_EXPRESSION")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:245:49: ( attribute )*
                while ( stream_attribute.hasNext() ) {
                    adaptor.addChild(root_2, stream_attribute.nextTree());

                }
                stream_attribute.reset();

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:245:60: ^( DOCUMENTID_REF ( DocumentID )* )
                {
                CommonTree root_3 = (CommonTree)adaptor.nil();
                root_3 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(DOCUMENTID_REF, "DOCUMENTID_REF")
                , root_3);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:245:77: ( DocumentID )*
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

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:245:91: ^( MODIFIERS ( attributeModifiers )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(MODIFIERS, "MODIFIERS")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:245:103: ( attributeModifiers )*
                while ( stream_attributeModifiers.hasNext() ) {
                    adaptor.addChild(root_2, stream_attributeModifiers.nextTree());

                }
                stream_attributeModifiers.reset();

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


    public static class macro_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "macro"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:253:1: macro : Macrodef ValueAssignement ;
    public final ImpexParser.macro_return macro() throws RecognitionException {
        ImpexParser.macro_return retval = new ImpexParser.macro_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Macrodef53=null;
        Token ValueAssignement54=null;

        CommonTree Macrodef53_tree=null;
        CommonTree ValueAssignement54_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:254:2: ( Macrodef ValueAssignement )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:254:3: Macrodef ValueAssignement
            {
            root_0 = (CommonTree)adaptor.nil();


            Macrodef53=(Token)match(input,Macrodef,FOLLOW_Macrodef_in_macro713); 
            Macrodef53_tree = 
            (CommonTree)adaptor.create(Macrodef53)
            ;
            adaptor.addChild(root_0, Macrodef53_tree);


            ValueAssignement54=(Token)match(input,ValueAssignement,FOLLOW_ValueAssignement_in_macro715); 
            ValueAssignement54_tree = 
            (CommonTree)adaptor.create(ValueAssignement54)
            ;
            adaptor.addChild(root_0, ValueAssignement54_tree);


            registerMacro(Macrodef53, (ValueAssignement54!=null?ValueAssignement54.getText():null));

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


    public static class attributeModifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "attributeModifier"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:258:1: attributeModifier : ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual );
    public final ImpexParser.attributeModifier_return attributeModifier() throws RecognitionException {
        ImpexParser.attributeModifier_return retval = new ImpexParser.attributeModifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set55=null;

        CommonTree set55_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:259:2: ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:262:1: headerMode : ( Insert | InsertUpdate | Update | Remove );
    public final ImpexParser.headerMode_return headerMode() throws RecognitionException {
        ImpexParser.headerMode_return retval = new ImpexParser.headerMode_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set56=null;

        CommonTree set56_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:263:2: ( Insert | InsertUpdate | Update | Remove )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


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

    // Delegated rules


    protected DFA5 dfa5 = new DFA5(this);
    static final String DFA5_eotS =
        "\6\uffff";
    static final String DFA5_eofS =
        "\1\1\1\uffff\1\1\2\uffff\1\1";
    static final String DFA5_minS =
        "\1\50\1\uffff\1\36\1\112\1\uffff\1\36";
    static final String DFA5_maxS =
        "\1\111\1\uffff\1\111\1\112\1\uffff\1\111";
    static final String DFA5_acceptS =
        "\1\uffff\1\2\2\uffff\1\1\1\uffff";
    static final String DFA5_specialS =
        "\6\uffff}>";
    static final String[] DFA5_transitionS = {
            "\2\1\4\uffff\1\2\5\uffff\1\1\15\uffff\1\1\6\uffff\1\1",
            "",
            "\1\4\6\uffff\1\4\2\uffff\2\1\4\uffff\1\2\5\uffff\1\3\10\uffff"+
            "\1\4\4\uffff\1\1\6\uffff\1\1",
            "\1\5",
            "",
            "\1\4\6\uffff\1\4\2\uffff\2\1\4\uffff\1\1\5\uffff\1\1\10\uffff"+
            "\1\4\4\uffff\1\1\6\uffff\1\1"
    };

    static final short[] DFA5_eot = DFA.unpackEncodedString(DFA5_eotS);
    static final short[] DFA5_eof = DFA.unpackEncodedString(DFA5_eofS);
    static final char[] DFA5_min = DFA.unpackEncodedStringToUnsignedChars(DFA5_minS);
    static final char[] DFA5_max = DFA.unpackEncodedStringToUnsignedChars(DFA5_maxS);
    static final short[] DFA5_accept = DFA.unpackEncodedString(DFA5_acceptS);
    static final short[] DFA5_special = DFA.unpackEncodedString(DFA5_specialS);
    static final short[][] DFA5_transition;

    static {
        int numStates = DFA5_transitionS.length;
        DFA5_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA5_transition[i] = DFA.unpackEncodedString(DFA5_transitionS[i]);
        }
    }

    class DFA5 extends DFA {

        public DFA5(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 5;
            this.eot = DFA5_eot;
            this.eof = DFA5_eof;
            this.min = DFA5_min;
            this.max = DFA5_max;
            this.accept = DFA5_accept;
            this.special = DFA5_special;
            this.transition = DFA5_transition;
        }
        public String getDescription() {
            return "()+ loopback of 181:16: ( ( Lb )+ ( macro )? record )+";
        }
    }
 

    public static final BitSet FOLLOW_EOF_in_parse186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Lb_in_impex198 = new BitSet(new long[]{0x0010430000000000L,0x0000000000000204L});
    public static final BitSet FOLLOW_block_in_impex203 = new BitSet(new long[]{0x0010430000000000L,0x0000000000000204L});
    public static final BitSet FOLLOW_macro_in_impex207 = new BitSet(new long[]{0x0010430000000000L,0x0000000000000204L});
    public static final BitSet FOLLOW_EOF_in_impex211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_header_in_block242 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_Lb_in_block245 = new BitSet(new long[]{0x2010402040000000L});
    public static final BitSet FOLLOW_macro_in_block248 = new BitSet(new long[]{0x2000002040000000L});
    public static final BitSet FOLLOW_record_in_block252 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_headerMode_in_header279 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_Identifier_in_header282 = new BitSet(new long[]{0x0000080000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_headerModifiers_in_header284 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_Semicolon_in_header289 = new BitSet(new long[]{0x0010002000000002L,0x0000000000000030L});
    public static final BitSet FOLLOW_attribute_in_header291 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_Semicolon_in_header297 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_DocumentID_in_header299 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_Semicolon_in_header301 = new BitSet(new long[]{0x0010002000000002L,0x0000000000000030L});
    public static final BitSet FOLLOW_attribute_in_header303 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_LBracket_in_headerModifiers357 = new BitSet(new long[]{0x1000000000005000L});
    public static final BitSet FOLLOW_headerModifierAssignment_in_headerModifiers359 = new BitSet(new long[]{0x4000000000080000L});
    public static final BitSet FOLLOW_Comma_in_headerModifiers362 = new BitSet(new long[]{0x1000000000005000L});
    public static final BitSet FOLLOW_headerModifierAssignment_in_headerModifiers365 = new BitSet(new long[]{0x4000000000080000L});
    public static final BitSet FOLLOW_RBracket_in_headerModifiers369 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_headerModifier_in_headerModifierAssignment388 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_Equals_in_headerModifierAssignment390 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_boolOrClassname_in_headerModifierAssignment392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_record445 = new BitSet(new long[]{0x2000000040000000L});
    public static final BitSet FOLLOW_QuotedField_in_record449 = new BitSet(new long[]{0x2000000040000002L});
    public static final BitSet FOLLOW_Field_in_record453 = new BitSet(new long[]{0x2000000040000002L});
    public static final BitSet FOLLOW_LBracket_in_attributeModifiers516 = new BitSet(new long[]{0x0D6024C081848180L,0x0000000000000980L});
    public static final BitSet FOLLOW_attributeModifierAssignment_in_attributeModifiers518 = new BitSet(new long[]{0x4000000000080000L});
    public static final BitSet FOLLOW_Comma_in_attributeModifiers521 = new BitSet(new long[]{0x0D6024C081848180L,0x0000000000000980L});
    public static final BitSet FOLLOW_attributeModifierAssignment_in_attributeModifiers524 = new BitSet(new long[]{0x4000000000080000L});
    public static final BitSet FOLLOW_RBracket_in_attributeModifiers528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeModifier_in_attributeModifierAssignment548 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_ValueAssignement_in_attributeModifierAssignment550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Macrodef_in_attributeName575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SpecialAttribute_in_attributeName589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_attributeName602 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_Dot_in_attributeName605 = new BitSet(new long[]{0x0010002000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_attributeName_in_attributeName607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeName_in_attribute631 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_LParenthesis_in_attribute634 = new BitSet(new long[]{0x0010002002000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_DocumentID_in_attribute638 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000002L});
    public static final BitSet FOLLOW_attribute_in_attribute642 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000002L});
    public static final BitSet FOLLOW_Comma_in_attribute645 = new BitSet(new long[]{0x0010002002000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_DocumentID_in_attribute648 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000002L});
    public static final BitSet FOLLOW_attribute_in_attribute652 = new BitSet(new long[]{0x0000000000080000L,0x0000000000000002L});
    public static final BitSet FOLLOW_RParenthesis_in_attribute657 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_attributeModifiers_in_attribute665 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_Macrodef_in_macro713 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_ValueAssignement_in_macro715 = new BitSet(new long[]{0x0000000000000002L});

}