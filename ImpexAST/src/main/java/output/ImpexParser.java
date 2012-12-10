// $ANTLR 3.4 /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g 2012-12-09 08:24:15

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

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class ImpexParser extends Parser {
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




        private final Map<String, List<SimpleImmutableEntry>> macros = new HashMap<String, List<SimpleImmutableEntry>>();
        private final Pattern macroPattern = Pattern.compile("$[a-zA-Z_][a-zA-Z_0-9]*");

        private void registerMacro(final Token def, final String val) {
            final String macrodef = def.getText();
            List<SimpleImmutableEntry> macroval = macros.get(macrodef);
            if (macroval == null) {
                macroval = new ArrayList<SimpleImmutableEntry>();
                macros.put(macrodef, macroval);
            }
            macroval.add(new SimpleImmutableEntry<Integer, String>(def.getLine(), val));
        }

        private String getMacroVal(final String macroDef, final int refLine) {
            final List<SimpleImmutableEntry> list = macros.get(macroDef);
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:195:1: parse : (t= . )* EOF ;
    public final ImpexParser.parse_return parse() throws RecognitionException {
        ImpexParser.parse_return retval = new ImpexParser.parse_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token t=null;
        Token EOF1=null;

        CommonTree t_tree=null;
        CommonTree EOF1_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:196:3: ( (t= . )* EOF )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:196:6: (t= . )* EOF
            {
            root_0 = (CommonTree)adaptor.nil();


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:196:6: (t= . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= ATTRIBUTE && LA1_0 <= Ws)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:196:7: t= .
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:198:1: impex : ( Lb | block | macro )* EOF -> ^( IMPEX ^( BLOCKS ( block )* ) ) ;
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:198:7: ( ( Lb | block | macro )* EOF -> ^( IMPEX ^( BLOCKS ( block )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:198:9: ( Lb | block | macro )* EOF
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:198:9: ( Lb | block | macro )*
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
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:198:10: Lb
            	    {
            	    Lb2=(Token)match(input,Lb,FOLLOW_Lb_in_impex190);  
            	    stream_Lb.add(Lb2);


            	    }
            	    break;
            	case 2 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:198:16: block
            	    {
            	    pushFollow(FOLLOW_block_in_impex195);
            	    block3=block();

            	    state._fsp--;

            	    stream_block.add(block3.getTree());

            	    }
            	    break;
            	case 3 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:198:24: macro
            	    {
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
            // 199:3: -> ^( IMPEX ^( BLOCKS ( block )* ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:199:6: ^( IMPEX ^( BLOCKS ( block )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IMPEX, "IMPEX")
                , root_1);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:199:14: ^( BLOCKS ( block )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCKS, "BLOCKS")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:199:23: ( block )*
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:201:1: block : header ( ( Lb )+ ( macro ( Lb )? )* record )+ -> ^( BLOCK header ^( RECORDS ( record )+ ) ) ;
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:201:7: ( header ( ( Lb )+ ( macro ( Lb )? )* record )+ -> ^( BLOCK header ^( RECORDS ( record )+ ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:201:9: header ( ( Lb )+ ( macro ( Lb )? )* record )+
            {
            pushFollow(FOLLOW_header_in_block226);
            header6=header();

            state._fsp--;

            stream_header.add(header6.getTree());

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:201:16: ( ( Lb )+ ( macro ( Lb )? )* record )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                alt6 = dfa6.predict(input);
                switch (alt6) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:201:17: ( Lb )+ ( macro ( Lb )? )* record
            	    {
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:201:17: ( Lb )+
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
            	    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:201:17: Lb
            	    	    {
            	    	    Lb7=(Token)match(input,Lb,FOLLOW_Lb_in_block229);  
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


            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:201:21: ( macro ( Lb )? )*
            	    loop5:
            	    do {
            	        int alt5=2;
            	        int LA5_0 = input.LA(1);

            	        if ( (LA5_0==Macrodef) ) {
            	            alt5=1;
            	        }


            	        switch (alt5) {
            	    	case 1 :
            	    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:201:22: macro ( Lb )?
            	    	    {
            	    	    pushFollow(FOLLOW_macro_in_block233);
            	    	    macro8=macro();

            	    	    state._fsp--;

            	    	    stream_macro.add(macro8.getTree());

            	    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:201:28: ( Lb )?
            	    	    int alt4=2;
            	    	    int LA4_0 = input.LA(1);

            	    	    if ( (LA4_0==Lb) ) {
            	    	        alt4=1;
            	    	    }
            	    	    switch (alt4) {
            	    	        case 1 :
            	    	            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:201:28: Lb
            	    	            {
            	    	            Lb9=(Token)match(input,Lb,FOLLOW_Lb_in_block235);  
            	    	            stream_Lb.add(Lb9);


            	    	            }
            	    	            break;

            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop5;
            	        }
            	    } while (true);


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
                        throw eee;
                }
                cnt6++;
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
            // 202:2: -> ^( BLOCK header ^( RECORDS ( record )+ ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:202:5: ^( BLOCK header ^( RECORDS ( record )+ ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCK, "BLOCK")
                , root_1);

                adaptor.addChild(root_1, stream_header.nextTree());

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:202:20: ^( RECORDS ( record )+ )
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:204:1: header : headerMode Identifier ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )* ( Semicolon ( attribute )? )* ( Semicolon DocumentID ( Semicolon ( attribute )? )* )? -> ^( HEADER headerMode ^( TYPE Identifier ) ^( MODIFIERS ( headerModifierAssignment )* ) ( ^( DOCUMENTID DocumentID ) )? ^( ATTRIBUTES ( attribute )* ) ) ;
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
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:2: ( headerMode Identifier ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )* ( Semicolon ( attribute )? )* ( Semicolon DocumentID ( Semicolon ( attribute )? )* )? -> ^( HEADER headerMode ^( TYPE Identifier ) ^( MODIFIERS ( headerModifierAssignment )* ) ( ^( DOCUMENTID DocumentID ) )? ^( ATTRIBUTES ( attribute )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:4: headerMode Identifier ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )* ( Semicolon ( attribute )? )* ( Semicolon DocumentID ( Semicolon ( attribute )? )* )?
            {
            pushFollow(FOLLOW_headerMode_in_header267);
            headerMode11=headerMode();

            state._fsp--;

            stream_headerMode.add(headerMode11.getTree());

            Identifier12=(Token)match(input,Identifier,FOLLOW_Identifier_in_header270);  
            stream_Identifier.add(Identifier12);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:27: ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==LBracket) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:28: LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket
            	    {
            	    LBracket13=(Token)match(input,LBracket,FOLLOW_LBracket_in_header273);  
            	    stream_LBracket.add(LBracket13);


            	    pushFollow(FOLLOW_headerModifierAssignment_in_header275);
            	    headerModifierAssignment14=headerModifierAssignment();

            	    state._fsp--;

            	    stream_headerModifierAssignment.add(headerModifierAssignment14.getTree());

            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:62: ( Comma headerModifierAssignment )*
            	    loop7:
            	    do {
            	        int alt7=2;
            	        int LA7_0 = input.LA(1);

            	        if ( (LA7_0==Comma) ) {
            	            alt7=1;
            	        }


            	        switch (alt7) {
            	    	case 1 :
            	    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:63: Comma headerModifierAssignment
            	    	    {
            	    	    Comma15=(Token)match(input,Comma,FOLLOW_Comma_in_header278);  
            	    	    stream_Comma.add(Comma15);


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


            	    RBracket17=(Token)match(input,RBracket,FOLLOW_RBracket_in_header285);  
            	    stream_RBracket.add(RBracket17);


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:109: ( Semicolon ( attribute )? )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==Semicolon) ) {
                    int LA10_1 = input.LA(2);

                    if ( (LA10_1==Identifier||LA10_1==Lb||LA10_1==Macrodef||(LA10_1 >= Semicolon && LA10_1 <= SpecialAttribute)) ) {
                        alt10=1;
                    }


                }


                switch (alt10) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:110: Semicolon ( attribute )?
            	    {
            	    Semicolon18=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_header291);  
            	    stream_Semicolon.add(Semicolon18);


            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:120: ( attribute )?
            	    int alt9=2;
            	    int LA9_0 = input.LA(1);

            	    if ( (LA9_0==Identifier||LA9_0==Macrodef||LA9_0==SpecialAttribute) ) {
            	        alt9=1;
            	    }
            	    switch (alt9) {
            	        case 1 :
            	            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:120: attribute
            	            {
            	            pushFollow(FOLLOW_attribute_in_header293);
            	            attribute19=attribute();

            	            state._fsp--;

            	            stream_attribute.add(attribute19.getTree());

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:133: ( Semicolon DocumentID ( Semicolon ( attribute )? )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==Semicolon) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:134: Semicolon DocumentID ( Semicolon ( attribute )? )*
                    {
                    Semicolon20=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_header299);  
                    stream_Semicolon.add(Semicolon20);


                    DocumentID21=(Token)match(input,DocumentID,FOLLOW_DocumentID_in_header301);  
                    stream_DocumentID.add(DocumentID21);


                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:154: ( Semicolon ( attribute )? )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==Semicolon) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:155: Semicolon ( attribute )?
                    	    {
                    	    Semicolon22=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_header303);  
                    	    stream_Semicolon.add(Semicolon22);


                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:165: ( attribute )?
                    	    int alt11=2;
                    	    int LA11_0 = input.LA(1);

                    	    if ( (LA11_0==Identifier||LA11_0==Macrodef||LA11_0==SpecialAttribute) ) {
                    	        alt11=1;
                    	    }
                    	    switch (alt11) {
                    	        case 1 :
                    	            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:165: attribute
                    	            {
                    	            pushFollow(FOLLOW_attribute_in_header305);
                    	            attribute23=attribute();

                    	            state._fsp--;

                    	            stream_attribute.add(attribute23.getTree());

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
            // elements: DocumentID, headerMode, Identifier, attribute, headerModifierAssignment
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 206:2: -> ^( HEADER headerMode ^( TYPE Identifier ) ^( MODIFIERS ( headerModifierAssignment )* ) ( ^( DOCUMENTID DocumentID ) )? ^( ATTRIBUTES ( attribute )* ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:206:5: ^( HEADER headerMode ^( TYPE Identifier ) ^( MODIFIERS ( headerModifierAssignment )* ) ( ^( DOCUMENTID DocumentID ) )? ^( ATTRIBUTES ( attribute )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(HEADER, "HEADER")
                , root_1);

                adaptor.addChild(root_1, stream_headerMode.nextTree());

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:206:25: ^( TYPE Identifier )
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

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:206:44: ^( MODIFIERS ( headerModifierAssignment )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(MODIFIERS, "MODIFIERS")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:206:56: ( headerModifierAssignment )*
                while ( stream_headerModifierAssignment.hasNext() ) {
                    adaptor.addChild(root_2, stream_headerModifierAssignment.nextTree());

                }
                stream_headerModifierAssignment.reset();

                adaptor.addChild(root_1, root_2);
                }

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:206:83: ( ^( DOCUMENTID DocumentID ) )?
                if ( stream_DocumentID.hasNext() ) {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:206:83: ^( DOCUMENTID DocumentID )
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

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:206:109: ^( ATTRIBUTES ( attribute )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ATTRIBUTES, "ATTRIBUTES")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:206:122: ( attribute )*
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:208:1: headerModifierAssignment : headerModifier Equals boolOrClassname -> ^( MODIFIER headerModifier boolOrClassname ) ;
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:208:25: ( headerModifier Equals boolOrClassname -> ^( MODIFIER headerModifier boolOrClassname ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:208:27: headerModifier Equals boolOrClassname
            {
            pushFollow(FOLLOW_headerModifier_in_headerModifierAssignment355);
            headerModifier24=headerModifier();

            state._fsp--;

            stream_headerModifier.add(headerModifier24.getTree());

            Equals25=(Token)match(input,Equals,FOLLOW_Equals_in_headerModifierAssignment357);  
            stream_Equals.add(Equals25);


            pushFollow(FOLLOW_boolOrClassname_in_headerModifierAssignment359);
            boolOrClassname26=boolOrClassname();

            state._fsp--;

            stream_boolOrClassname.add(boolOrClassname26.getTree());

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
            // 209:2: -> ^( MODIFIER headerModifier boolOrClassname )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:209:5: ^( MODIFIER headerModifier boolOrClassname )
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:211:1: boolOrClassname : ( Bool | Classname );
    public final ImpexParser.boolOrClassname_return boolOrClassname() throws RecognitionException {
        ImpexParser.boolOrClassname_return retval = new ImpexParser.boolOrClassname_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set27=null;

        CommonTree set27_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:212:2: ( Bool | Classname )
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:214:1: headerModifier : ( BatchMode | CacheUnique | Processor );
    public final ImpexParser.headerModifier_return headerModifier() throws RecognitionException {
        ImpexParser.headerModifier_return retval = new ImpexParser.headerModifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set28=null;

        CommonTree set28_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:215:2: ( BatchMode | CacheUnique | Processor )
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:218:1: record : ( Identifier )? ( field )+ -> ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) ) ;
    public final ImpexParser.record_return record() throws RecognitionException {
        ImpexParser.record_return retval = new ImpexParser.record_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Identifier29=null;
        ImpexParser.field_return field30 =null;


        CommonTree Identifier29_tree=null;
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_field=new RewriteRuleSubtreeStream(adaptor,"rule field");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:219:5: ( ( Identifier )? ( field )+ -> ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:219:7: ( Identifier )? ( field )+
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:219:7: ( Identifier )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==Identifier) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:219:7: Identifier
                    {
                    Identifier29=(Token)match(input,Identifier,FOLLOW_Identifier_in_record412);  
                    stream_Identifier.add(Identifier29);


                    }
                    break;

            }


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:219:19: ( field )+
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
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:219:19: field
            	    {
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
            // 220:6: -> ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:220:9: ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(RECORD, "RECORD")
                , root_1);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:220:18: ^( SUBTYPE ( Identifier )? )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(SUBTYPE, "SUBTYPE")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:220:28: ( Identifier )?
                if ( stream_Identifier.hasNext() ) {
                    adaptor.addChild(root_2, 
                    stream_Identifier.nextNode()
                    );

                }
                stream_Identifier.reset();

                adaptor.addChild(root_1, root_2);
                }

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:220:41: ^( FIELDS ( field )+ )
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:222:1: field : ( QuotedField | Field );
    public final ImpexParser.field_return field() throws RecognitionException {
        ImpexParser.field_return retval = new ImpexParser.field_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set31=null;

        CommonTree set31_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:222:7: ( QuotedField | Field )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:246:1: attributeName : ( Macrodef -> ^( MACRO_REF Macrodef ) | SpecialAttribute -> ^( ATTRIBUTE_NAME SpecialAttribute ) | ( Identifier ( Dot attributeName )? ) -> ^( ATTRIBUTE_NAME Identifier ( attributeName )? ) );
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
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:247:2: ( Macrodef -> ^( MACRO_REF Macrodef ) | SpecialAttribute -> ^( ATTRIBUTE_NAME SpecialAttribute ) | ( Identifier ( Dot attributeName )? ) -> ^( ATTRIBUTE_NAME Identifier ( attributeName )? ) )
            int alt17=3;
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

                throw nvae;

            }

            switch (alt17) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:247:3: Macrodef
                    {
                    Macrodef32=(Token)match(input,Macrodef,FOLLOW_Macrodef_in_attributeName485);  
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
                    // 247:12: -> ^( MACRO_REF Macrodef )
                    {
                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:247:15: ^( MACRO_REF Macrodef )
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
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:248:4: SpecialAttribute
                    {
                    SpecialAttribute33=(Token)match(input,SpecialAttribute,FOLLOW_SpecialAttribute_in_attributeName499);  
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
                    // 248:21: -> ^( ATTRIBUTE_NAME SpecialAttribute )
                    {
                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:248:24: ^( ATTRIBUTE_NAME SpecialAttribute )
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
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:249:3: ( Identifier ( Dot attributeName )? )
                    {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:249:3: ( Identifier ( Dot attributeName )? )
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:249:4: Identifier ( Dot attributeName )?
                    {
                    Identifier34=(Token)match(input,Identifier,FOLLOW_Identifier_in_attributeName512);  
                    stream_Identifier.add(Identifier34);


                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:249:15: ( Dot attributeName )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==Dot) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:249:16: Dot attributeName
                            {
                            Dot35=(Token)match(input,Dot,FOLLOW_Dot_in_attributeName515);  
                            stream_Dot.add(Dot35);


                            pushFollow(FOLLOW_attributeName_in_attributeName517);
                            attributeName36=attributeName();

                            state._fsp--;

                            stream_attributeName.add(attributeName36.getTree());

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
                    // 249:37: -> ^( ATTRIBUTE_NAME Identifier ( attributeName )? )
                    {
                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:249:40: ^( ATTRIBUTE_NAME Identifier ( attributeName )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot(
                        (CommonTree)adaptor.create(ATTRIBUTE_NAME, "ATTRIBUTE_NAME")
                        , root_1);

                        adaptor.addChild(root_1, 
                        stream_Identifier.nextNode()
                        );

                        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:249:68: ( attributeName )?
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:251:1: attribute : attributeName ( LParenthesis ( DocumentID | attribute ) ( Comma ( DocumentID | attribute ) )* RParenthesis )? ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket )* -> ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifierAssignment )* ) ) ;
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
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:252:2: ( attributeName ( LParenthesis ( DocumentID | attribute ) ( Comma ( DocumentID | attribute ) )* RParenthesis )? ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket )* -> ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifierAssignment )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:252:3: attributeName ( LParenthesis ( DocumentID | attribute ) ( Comma ( DocumentID | attribute ) )* RParenthesis )? ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket )*
            {
            pushFollow(FOLLOW_attributeName_in_attribute541);
            attributeName37=attributeName();

            state._fsp--;

            stream_attributeName.add(attributeName37.getTree());

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:252:17: ( LParenthesis ( DocumentID | attribute ) ( Comma ( DocumentID | attribute ) )* RParenthesis )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==LParenthesis) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:252:18: LParenthesis ( DocumentID | attribute ) ( Comma ( DocumentID | attribute ) )* RParenthesis
                    {
                    LParenthesis38=(Token)match(input,LParenthesis,FOLLOW_LParenthesis_in_attribute544);  
                    stream_LParenthesis.add(LParenthesis38);


                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:252:32: ( DocumentID | attribute )
                    int alt18=2;
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

                        throw nvae;

                    }
                    switch (alt18) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:252:33: DocumentID
                            {
                            DocumentID39=(Token)match(input,DocumentID,FOLLOW_DocumentID_in_attribute548);  
                            stream_DocumentID.add(DocumentID39);


                            }
                            break;
                        case 2 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:252:46: attribute
                            {
                            pushFollow(FOLLOW_attribute_in_attribute552);
                            attribute40=attribute();

                            state._fsp--;

                            stream_attribute.add(attribute40.getTree());

                            }
                            break;

                    }


                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:252:56: ( Comma ( DocumentID | attribute ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==Comma) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:252:57: Comma ( DocumentID | attribute )
                    	    {
                    	    Comma41=(Token)match(input,Comma,FOLLOW_Comma_in_attribute555);  
                    	    stream_Comma.add(Comma41);


                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:252:63: ( DocumentID | attribute )
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
                    	            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:252:64: DocumentID
                    	            {
                    	            DocumentID42=(Token)match(input,DocumentID,FOLLOW_DocumentID_in_attribute558);  
                    	            stream_DocumentID.add(DocumentID42);


                    	            }
                    	            break;
                    	        case 2 :
                    	            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:252:77: attribute
                    	            {
                    	            pushFollow(FOLLOW_attribute_in_attribute562);
                    	            attribute43=attribute();

                    	            state._fsp--;

                    	            stream_attribute.add(attribute43.getTree());

                    	            }
                    	            break;

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    RParenthesis44=(Token)match(input,RParenthesis,FOLLOW_RParenthesis_in_attribute567);  
                    stream_RParenthesis.add(RParenthesis44);


                    }
                    break;

            }


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:252:106: ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==LBracket) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:252:107: LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket
            	    {
            	    LBracket45=(Token)match(input,LBracket,FOLLOW_LBracket_in_attribute573);  
            	    stream_LBracket.add(LBracket45);


            	    pushFollow(FOLLOW_attributeModifierAssignment_in_attribute575);
            	    attributeModifierAssignment46=attributeModifierAssignment();

            	    state._fsp--;

            	    stream_attributeModifierAssignment.add(attributeModifierAssignment46.getTree());

            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:252:144: ( Comma attributeModifierAssignment )*
            	    loop22:
            	    do {
            	        int alt22=2;
            	        int LA22_0 = input.LA(1);

            	        if ( (LA22_0==Comma) ) {
            	            alt22=1;
            	        }


            	        switch (alt22) {
            	    	case 1 :
            	    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:252:145: Comma attributeModifierAssignment
            	    	    {
            	    	    Comma47=(Token)match(input,Comma,FOLLOW_Comma_in_attribute578);  
            	    	    stream_Comma.add(Comma47);


            	    	    pushFollow(FOLLOW_attributeModifierAssignment_in_attribute581);
            	    	    attributeModifierAssignment48=attributeModifierAssignment();

            	    	    state._fsp--;

            	    	    stream_attributeModifierAssignment.add(attributeModifierAssignment48.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop22;
            	        }
            	    } while (true);


            	    RBracket49=(Token)match(input,RBracket,FOLLOW_RBracket_in_attribute585);  
            	    stream_RBracket.add(RBracket49);


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            // AST REWRITE
            // elements: attributeName, attributeModifierAssignment, attribute, DocumentID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 253:2: -> ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifierAssignment )* ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:253:5: ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifierAssignment )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ATTRIBUTE, "ATTRIBUTE")
                , root_1);

                adaptor.addChild(root_1, stream_attributeName.nextTree());

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:253:31: ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ITEM_EXPRESSION, "ITEM_EXPRESSION")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:253:49: ( attribute )*
                while ( stream_attribute.hasNext() ) {
                    adaptor.addChild(root_2, stream_attribute.nextTree());

                }
                stream_attribute.reset();

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:253:60: ^( DOCUMENTID_REF ( DocumentID )* )
                {
                CommonTree root_3 = (CommonTree)adaptor.nil();
                root_3 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(DOCUMENTID_REF, "DOCUMENTID_REF")
                , root_3);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:253:77: ( DocumentID )*
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

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:253:91: ^( MODIFIERS ( attributeModifierAssignment )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(MODIFIERS, "MODIFIERS")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:253:103: ( attributeModifierAssignment )*
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:255:1: attributeModifierAssignment : attributeModifier ValueAssignment -> ^( MODIFIER attributeModifier ValueAssignment ) ;
    public final ImpexParser.attributeModifierAssignment_return attributeModifierAssignment() throws RecognitionException {
        ImpexParser.attributeModifierAssignment_return retval = new ImpexParser.attributeModifierAssignment_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ValueAssignment51=null;
        ImpexParser.attributeModifier_return attributeModifier50 =null;


        CommonTree ValueAssignment51_tree=null;
        RewriteRuleTokenStream stream_ValueAssignment=new RewriteRuleTokenStream(adaptor,"token ValueAssignment");
        RewriteRuleSubtreeStream stream_attributeModifier=new RewriteRuleSubtreeStream(adaptor,"rule attributeModifier");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:256:2: ( attributeModifier ValueAssignment -> ^( MODIFIER attributeModifier ValueAssignment ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:256:4: attributeModifier ValueAssignment
            {
            pushFollow(FOLLOW_attributeModifier_in_attributeModifierAssignment626);
            attributeModifier50=attributeModifier();

            state._fsp--;

            stream_attributeModifier.add(attributeModifier50.getTree());

            ValueAssignment51=(Token)match(input,ValueAssignment,FOLLOW_ValueAssignment_in_attributeModifierAssignment628);  
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
            // 257:2: -> ^( MODIFIER attributeModifier ValueAssignment )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:257:5: ^( MODIFIER attributeModifier ValueAssignment )
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


    public static class macro_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "macro"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:263:1: macro : Macrodef ValueAssignment ;
    public final ImpexParser.macro_return macro() throws RecognitionException {
        ImpexParser.macro_return retval = new ImpexParser.macro_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Macrodef52=null;
        Token ValueAssignment53=null;

        CommonTree Macrodef52_tree=null;
        CommonTree ValueAssignment53_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:264:2: ( Macrodef ValueAssignment )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:264:3: Macrodef ValueAssignment
            {
            root_0 = (CommonTree)adaptor.nil();


            Macrodef52=(Token)match(input,Macrodef,FOLLOW_Macrodef_in_macro655); 
            Macrodef52_tree = 
            (CommonTree)adaptor.create(Macrodef52)
            ;
            adaptor.addChild(root_0, Macrodef52_tree);


            ValueAssignment53=(Token)match(input,ValueAssignment,FOLLOW_ValueAssignment_in_macro657); 
            ValueAssignment53_tree = 
            (CommonTree)adaptor.create(ValueAssignment53)
            ;
            adaptor.addChild(root_0, ValueAssignment53_tree);


            registerMacro(Macrodef52, (ValueAssignment53!=null?ValueAssignment53.getText():null));

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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:268:1: attributeModifier : ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual );
    public final ImpexParser.attributeModifier_return attributeModifier() throws RecognitionException {
        ImpexParser.attributeModifier_return retval = new ImpexParser.attributeModifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set54=null;

        CommonTree set54_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:269:2: ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set54=(Token)input.LT(1);

            if ( (input.LA(1) >= Alias && input.LA(1) <= AllowNull)||input.LA(1)==CellDecorator||input.LA(1)==CollectionDelimiter||(input.LA(1) >= Dateformat && input.LA(1) <= Default)||input.LA(1)==ForceWrite||(input.LA(1) >= IgnoreKeyCase && input.LA(1) <= IgnoreNull)||input.LA(1)==KeyToValueDelimiter||input.LA(1)==Lang||(input.LA(1) >= MapDelimiter && input.LA(1) <= Mode)||input.LA(1)==NumberFormat||(input.LA(1) >= PathDelimiter && input.LA(1) <= Pos)||(input.LA(1) >= Translator && input.LA(1) <= Unique)||input.LA(1)==Virtual ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set54)
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:272:1: headerMode : ( Insert | InsertUpdate | Update | Remove );
    public final ImpexParser.headerMode_return headerMode() throws RecognitionException {
        ImpexParser.headerMode_return retval = new ImpexParser.headerMode_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set55=null;

        CommonTree set55_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:273:2: ( Insert | InsertUpdate | Update | Remove )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set55=(Token)input.LT(1);

            if ( (input.LA(1) >= Insert && input.LA(1) <= InsertUpdate)||input.LA(1)==Remove||input.LA(1)==Update ) {
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
    // $ANTLR end "headerMode"

    // Delegated rules


    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA6_eotS =
        "\7\uffff";
    static final String DFA6_eofS =
        "\1\1\1\uffff\1\1\2\uffff\2\1";
    static final String DFA6_minS =
        "\1\50\1\uffff\1\36\1\110\1\uffff\2\36";
    static final String DFA6_maxS =
        "\1\107\1\uffff\1\107\1\110\1\uffff\2\107";
    static final String DFA6_acceptS =
        "\1\uffff\1\2\2\uffff\1\1\2\uffff";
    static final String DFA6_specialS =
        "\7\uffff}>";
    static final String[] DFA6_transitionS = {
            "\2\1\4\uffff\1\2\3\uffff\1\1\15\uffff\1\1\6\uffff\1\1",
            "",
            "\1\4\6\uffff\1\4\2\uffff\2\1\4\uffff\1\2\3\uffff\1\3\10\uffff"+
            "\1\4\4\uffff\1\1\6\uffff\1\1",
            "\1\5",
            "",
            "\1\4\6\uffff\1\4\2\uffff\2\1\4\uffff\1\6\3\uffff\1\3\10\uffff"+
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
            return "()+ loopback of 201:16: ( ( Lb )+ ( macro ( Lb )? )* record )+";
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
    public static final BitSet FOLLOW_Macrodef_in_attributeName485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SpecialAttribute_in_attributeName499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_attributeName512 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_Dot_in_attributeName515 = new BitSet(new long[]{0x0004002000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_attributeName_in_attributeName517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeName_in_attribute541 = new BitSet(new long[]{0x0000180000000002L});
    public static final BitSet FOLLOW_LParenthesis_in_attribute544 = new BitSet(new long[]{0x0004002002000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_DocumentID_in_attribute548 = new BitSet(new long[]{0x8000000000080000L});
    public static final BitSet FOLLOW_attribute_in_attribute552 = new BitSet(new long[]{0x8000000000080000L});
    public static final BitSet FOLLOW_Comma_in_attribute555 = new BitSet(new long[]{0x0004002002000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_DocumentID_in_attribute558 = new BitSet(new long[]{0x8000000000080000L});
    public static final BitSet FOLLOW_attribute_in_attribute562 = new BitSet(new long[]{0x8000000000080000L});
    public static final BitSet FOLLOW_RParenthesis_in_attribute567 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_LBracket_in_attribute573 = new BitSet(new long[]{0x035824C081848180L,0x0000000000000260L});
    public static final BitSet FOLLOW_attributeModifierAssignment_in_attribute575 = new BitSet(new long[]{0x1000000000080000L});
    public static final BitSet FOLLOW_Comma_in_attribute578 = new BitSet(new long[]{0x035824C081848180L,0x0000000000000260L});
    public static final BitSet FOLLOW_attributeModifierAssignment_in_attribute581 = new BitSet(new long[]{0x1000000000080000L});
    public static final BitSet FOLLOW_RBracket_in_attribute585 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_attributeModifier_in_attributeModifierAssignment626 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ValueAssignment_in_attributeModifierAssignment628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Macrodef_in_macro655 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ValueAssignment_in_macro657 = new BitSet(new long[]{0x0000000000000002L});

}