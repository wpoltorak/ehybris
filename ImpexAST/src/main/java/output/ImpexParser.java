// $ANTLR 3.4 /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g 2012-11-06 22:45:30

  package output;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class ImpexParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGNEMENT", "ASSIGNEMENTS", "ATTRIBUTE", "ATTRIBUTES", "Alias", "AllowNull", "ArgumentModifier", "ArgumentModifierval", "BLOCK", "BLOCKS", "BatchMode", "Bool", "CacheUnique", "CellDecorator", "Char", "Classname", "CollectionDelimiter", "Comma", "Comment", "DOCUMENTID", "Dateformat", "Default", "DocumentID", "Dot", "DoubleQuote", "Equals", "FIELDS", "Field", "ForceWrite", "HEADER", "HeaderMode", "HeaderModifier", "IMPEX", "Identifier", "IgnoreKeyCase", "IgnoreNull", "Insert", "InsertUpdate", "KeyToValueDelimiter", "LBracket", "LParenthesis", "Lang", "Lb", "MODIFIER", "MODIFIERS", "Macrodef", "Macroval", "MapDelimiter", "Mode", "NextRow", "NumberFormat", "PathDelimiter", "Pos", "Processor", "QuotedField", "RBracket", "RECORD", "RECORDS", "RParenthesis", "Remove", "SUBTYPE", "Semicolon", "SpecialAttribute", "TYPE", "Translator", "Unique", "Update", "Virtual", "Ws"
    };

    public static final int EOF=-1;
    public static final int ASSIGNEMENT=4;
    public static final int ASSIGNEMENTS=5;
    public static final int ATTRIBUTE=6;
    public static final int ATTRIBUTES=7;
    public static final int Alias=8;
    public static final int AllowNull=9;
    public static final int ArgumentModifier=10;
    public static final int ArgumentModifierval=11;
    public static final int BLOCK=12;
    public static final int BLOCKS=13;
    public static final int BatchMode=14;
    public static final int Bool=15;
    public static final int CacheUnique=16;
    public static final int CellDecorator=17;
    public static final int Char=18;
    public static final int Classname=19;
    public static final int CollectionDelimiter=20;
    public static final int Comma=21;
    public static final int Comment=22;
    public static final int DOCUMENTID=23;
    public static final int Dateformat=24;
    public static final int Default=25;
    public static final int DocumentID=26;
    public static final int Dot=27;
    public static final int DoubleQuote=28;
    public static final int Equals=29;
    public static final int FIELDS=30;
    public static final int Field=31;
    public static final int ForceWrite=32;
    public static final int HEADER=33;
    public static final int HeaderMode=34;
    public static final int HeaderModifier=35;
    public static final int IMPEX=36;
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
    public static final int MODIFIER=47;
    public static final int MODIFIERS=48;
    public static final int Macrodef=49;
    public static final int Macroval=50;
    public static final int MapDelimiter=51;
    public static final int Mode=52;
    public static final int NextRow=53;
    public static final int NumberFormat=54;
    public static final int PathDelimiter=55;
    public static final int Pos=56;
    public static final int Processor=57;
    public static final int QuotedField=58;
    public static final int RBracket=59;
    public static final int RECORD=60;
    public static final int RECORDS=61;
    public static final int RParenthesis=62;
    public static final int Remove=63;
    public static final int SUBTYPE=64;
    public static final int Semicolon=65;
    public static final int SpecialAttribute=66;
    public static final int TYPE=67;
    public static final int Translator=68;
    public static final int Unique=69;
    public static final int Update=70;
    public static final int Virtual=71;
    public static final int Ws=72;

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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:135:1: parse : (t= . )* EOF ;
    public final ImpexParser.parse_return parse() throws RecognitionException {
        ImpexParser.parse_return retval = new ImpexParser.parse_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token t=null;
        Token EOF1=null;

        CommonTree t_tree=null;
        CommonTree EOF1_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:136:3: ( (t= . )* EOF )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:136:6: (t= . )* EOF
            {
            root_0 = (CommonTree)adaptor.nil();


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:136:6: (t= . )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= ASSIGNEMENT && LA1_0 <= Ws)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:136:7: t= .
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


            EOF1=(Token)match(input,EOF,FOLLOW_EOF_in_parse161); 
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:138:1: impex : ( Lb | block | macro )* EOF -> ^( IMPEX ( ^( ASSIGNEMENTS macro ) )* ^( BLOCKS ( block )* ) ) ;
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:138:7: ( ( Lb | block | macro )* EOF -> ^( IMPEX ( ^( ASSIGNEMENTS macro ) )* ^( BLOCKS ( block )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:138:9: ( Lb | block | macro )* EOF
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:138:9: ( Lb | block | macro )*
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
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:138:10: Lb
            	    {
            	    Lb2=(Token)match(input,Lb,FOLLOW_Lb_in_impex173);  
            	    stream_Lb.add(Lb2);


            	    }
            	    break;
            	case 2 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:138:16: block
            	    {
            	    pushFollow(FOLLOW_block_in_impex178);
            	    block3=block();

            	    state._fsp--;

            	    stream_block.add(block3.getTree());

            	    }
            	    break;
            	case 3 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:138:24: macro
            	    {
            	    pushFollow(FOLLOW_macro_in_impex182);
            	    macro4=macro();

            	    state._fsp--;

            	    stream_macro.add(macro4.getTree());

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            EOF5=(Token)match(input,EOF,FOLLOW_EOF_in_impex186);  
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
            // 139:3: -> ^( IMPEX ( ^( ASSIGNEMENTS macro ) )* ^( BLOCKS ( block )* ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:139:6: ^( IMPEX ( ^( ASSIGNEMENTS macro ) )* ^( BLOCKS ( block )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(IMPEX, "IMPEX")
                , root_1);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:141:3: ( ^( ASSIGNEMENTS macro ) )*
                while ( stream_macro.hasNext() ) {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:141:3: ^( ASSIGNEMENTS macro )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(ASSIGNEMENTS, "ASSIGNEMENTS")
                    , root_2);

                    adaptor.addChild(root_2, stream_macro.nextTree());

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_macro.reset();

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:141:27: ^( BLOCKS ( block )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCKS, "BLOCKS")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:141:36: ( block )*
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:144:1: block : header ( ( Lb )+ record )+ -> ^( BLOCK header ^( RECORDS ( record )+ ) ) ;
    public final ImpexParser.block_return block() throws RecognitionException {
        ImpexParser.block_return retval = new ImpexParser.block_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Lb7=null;
        ImpexParser.header_return header6 =null;

        ImpexParser.record_return record8 =null;


        CommonTree Lb7_tree=null;
        RewriteRuleTokenStream stream_Lb=new RewriteRuleTokenStream(adaptor,"token Lb");
        RewriteRuleSubtreeStream stream_record=new RewriteRuleSubtreeStream(adaptor,"rule record");
        RewriteRuleSubtreeStream stream_header=new RewriteRuleSubtreeStream(adaptor,"rule header");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:144:7: ( header ( ( Lb )+ record )+ -> ^( BLOCK header ^( RECORDS ( record )+ ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:144:9: header ( ( Lb )+ record )+
            {
            pushFollow(FOLLOW_header_in_block224);
            header6=header();

            state._fsp--;

            stream_header.add(header6.getTree());

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:144:16: ( ( Lb )+ record )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                alt4 = dfa4.predict(input);
                switch (alt4) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:144:17: ( Lb )+ record
            	    {
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:144:17: ( Lb )+
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
            	    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:144:17: Lb
            	    	    {
            	    	    Lb7=(Token)match(input,Lb,FOLLOW_Lb_in_block227);  
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


            	    pushFollow(FOLLOW_record_in_block231);
            	    record8=record();

            	    state._fsp--;

            	    stream_record.add(record8.getTree());

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
            // 145:2: -> ^( BLOCK header ^( RECORDS ( record )+ ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:145:5: ^( BLOCK header ^( RECORDS ( record )+ ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(BLOCK, "BLOCK")
                , root_1);

                adaptor.addChild(root_1, stream_header.nextTree());

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:145:20: ^( RECORDS ( record )+ )
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:147:1: header : headerMode Identifier ( headerModifiers )? ( Semicolon DocumentID )? ( Semicolon attribute )+ -> ^( HEADER headerMode ^( TYPE Identifier ) ( ^( MODIFIERS headerModifiers ) )? ( ^( DOCUMENTID DocumentID ) )? ^( ATTRIBUTES ( attribute )+ ) ) ;
    public final ImpexParser.header_return header() throws RecognitionException {
        ImpexParser.header_return retval = new ImpexParser.header_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Identifier10=null;
        Token Semicolon12=null;
        Token DocumentID13=null;
        Token Semicolon14=null;
        ImpexParser.headerMode_return headerMode9 =null;

        ImpexParser.headerModifiers_return headerModifiers11 =null;

        ImpexParser.attribute_return attribute15 =null;


        CommonTree Identifier10_tree=null;
        CommonTree Semicolon12_tree=null;
        CommonTree DocumentID13_tree=null;
        CommonTree Semicolon14_tree=null;
        RewriteRuleTokenStream stream_DocumentID=new RewriteRuleTokenStream(adaptor,"token DocumentID");
        RewriteRuleTokenStream stream_Semicolon=new RewriteRuleTokenStream(adaptor,"token Semicolon");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_headerMode=new RewriteRuleSubtreeStream(adaptor,"rule headerMode");
        RewriteRuleSubtreeStream stream_attribute=new RewriteRuleSubtreeStream(adaptor,"rule attribute");
        RewriteRuleSubtreeStream stream_headerModifiers=new RewriteRuleSubtreeStream(adaptor,"rule headerModifiers");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:148:2: ( headerMode Identifier ( headerModifiers )? ( Semicolon DocumentID )? ( Semicolon attribute )+ -> ^( HEADER headerMode ^( TYPE Identifier ) ( ^( MODIFIERS headerModifiers ) )? ( ^( DOCUMENTID DocumentID ) )? ^( ATTRIBUTES ( attribute )+ ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:148:4: headerMode Identifier ( headerModifiers )? ( Semicolon DocumentID )? ( Semicolon attribute )+
            {
            pushFollow(FOLLOW_headerMode_in_header258);
            headerMode9=headerMode();

            state._fsp--;

            stream_headerMode.add(headerMode9.getTree());

            Identifier10=(Token)match(input,Identifier,FOLLOW_Identifier_in_header261);  
            stream_Identifier.add(Identifier10);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:148:27: ( headerModifiers )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==LBracket) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:148:27: headerModifiers
                    {
                    pushFollow(FOLLOW_headerModifiers_in_header263);
                    headerModifiers11=headerModifiers();

                    state._fsp--;

                    stream_headerModifiers.add(headerModifiers11.getTree());

                    }
                    break;

            }


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:148:45: ( Semicolon DocumentID )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==Semicolon) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==DocumentID) ) {
                    alt6=1;
                }
            }
            switch (alt6) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:148:46: Semicolon DocumentID
                    {
                    Semicolon12=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_header268);  
                    stream_Semicolon.add(Semicolon12);


                    DocumentID13=(Token)match(input,DocumentID,FOLLOW_DocumentID_in_header270);  
                    stream_DocumentID.add(DocumentID13);


                    }
                    break;

            }


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:148:69: ( Semicolon attribute )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==Semicolon) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:148:70: Semicolon attribute
            	    {
            	    Semicolon14=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_header275);  
            	    stream_Semicolon.add(Semicolon14);


            	    pushFollow(FOLLOW_attribute_in_header277);
            	    attribute15=attribute();

            	    state._fsp--;

            	    stream_attribute.add(attribute15.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);


            // AST REWRITE
            // elements: attribute, headerModifiers, Identifier, headerMode, DocumentID
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 149:2: -> ^( HEADER headerMode ^( TYPE Identifier ) ( ^( MODIFIERS headerModifiers ) )? ( ^( DOCUMENTID DocumentID ) )? ^( ATTRIBUTES ( attribute )+ ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:149:5: ^( HEADER headerMode ^( TYPE Identifier ) ( ^( MODIFIERS headerModifiers ) )? ( ^( DOCUMENTID DocumentID ) )? ^( ATTRIBUTES ( attribute )+ ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(HEADER, "HEADER")
                , root_1);

                adaptor.addChild(root_1, stream_headerMode.nextTree());

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:149:25: ^( TYPE Identifier )
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

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:149:44: ( ^( MODIFIERS headerModifiers ) )?
                if ( stream_headerModifiers.hasNext() ) {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:149:44: ^( MODIFIERS headerModifiers )
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

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:149:74: ( ^( DOCUMENTID DocumentID ) )?
                if ( stream_DocumentID.hasNext() ) {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:149:74: ^( DOCUMENTID DocumentID )
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

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:149:100: ^( ATTRIBUTES ( attribute )+ )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ATTRIBUTES, "ATTRIBUTES")
                , root_2);

                if ( !(stream_attribute.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:151:1: headerModifiers : ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )+ -> ( ^( MODIFIER headerModifierAssignment ) )+ ;
    public final ImpexParser.headerModifiers_return headerModifiers() throws RecognitionException {
        ImpexParser.headerModifiers_return retval = new ImpexParser.headerModifiers_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token LBracket16=null;
        Token Comma18=null;
        Token RBracket20=null;
        ImpexParser.headerModifierAssignment_return headerModifierAssignment17 =null;

        ImpexParser.headerModifierAssignment_return headerModifierAssignment19 =null;


        CommonTree LBracket16_tree=null;
        CommonTree Comma18_tree=null;
        CommonTree RBracket20_tree=null;
        RewriteRuleTokenStream stream_RBracket=new RewriteRuleTokenStream(adaptor,"token RBracket");
        RewriteRuleTokenStream stream_LBracket=new RewriteRuleTokenStream(adaptor,"token LBracket");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleSubtreeStream stream_headerModifierAssignment=new RewriteRuleSubtreeStream(adaptor,"rule headerModifierAssignment");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:152:2: ( ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )+ -> ( ^( MODIFIER headerModifierAssignment ) )+ )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:152:4: ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )+
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:152:4: ( LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==LBracket) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:152:5: LBracket headerModifierAssignment ( Comma headerModifierAssignment )* RBracket
            	    {
            	    LBracket16=(Token)match(input,LBracket,FOLLOW_LBracket_in_headerModifiers327);  
            	    stream_LBracket.add(LBracket16);


            	    pushFollow(FOLLOW_headerModifierAssignment_in_headerModifiers329);
            	    headerModifierAssignment17=headerModifierAssignment();

            	    state._fsp--;

            	    stream_headerModifierAssignment.add(headerModifierAssignment17.getTree());

            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:152:39: ( Comma headerModifierAssignment )*
            	    loop8:
            	    do {
            	        int alt8=2;
            	        int LA8_0 = input.LA(1);

            	        if ( (LA8_0==Comma) ) {
            	            alt8=1;
            	        }


            	        switch (alt8) {
            	    	case 1 :
            	    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:152:40: Comma headerModifierAssignment
            	    	    {
            	    	    Comma18=(Token)match(input,Comma,FOLLOW_Comma_in_headerModifiers332);  
            	    	    stream_Comma.add(Comma18);


            	    	    pushFollow(FOLLOW_headerModifierAssignment_in_headerModifiers335);
            	    	    headerModifierAssignment19=headerModifierAssignment();

            	    	    state._fsp--;

            	    	    stream_headerModifierAssignment.add(headerModifierAssignment19.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop8;
            	        }
            	    } while (true);


            	    RBracket20=(Token)match(input,RBracket,FOLLOW_RBracket_in_headerModifiers339);  
            	    stream_RBracket.add(RBracket20);


            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
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
            // 153:2: -> ( ^( MODIFIER headerModifierAssignment ) )+
            {
                if ( !(stream_headerModifierAssignment.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_headerModifierAssignment.hasNext() ) {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:153:5: ^( MODIFIER headerModifierAssignment )
                    {
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    root_1 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(MODIFIER, "MODIFIER")
                    , root_1);

                    adaptor.addChild(root_1, stream_headerModifierAssignment.nextTree());

                    adaptor.addChild(root_0, root_1);
                    }

                }
                stream_headerModifierAssignment.reset();

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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:155:1: headerModifierAssignment : headerModifier Equals (hmValue= Bool |hmValue= Classname ) -> headerModifier $hmValue;
    public final ImpexParser.headerModifierAssignment_return headerModifierAssignment() throws RecognitionException {
        ImpexParser.headerModifierAssignment_return retval = new ImpexParser.headerModifierAssignment_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token hmValue=null;
        Token Equals22=null;
        ImpexParser.headerModifier_return headerModifier21 =null;


        CommonTree hmValue_tree=null;
        CommonTree Equals22_tree=null;
        RewriteRuleTokenStream stream_Bool=new RewriteRuleTokenStream(adaptor,"token Bool");
        RewriteRuleTokenStream stream_Equals=new RewriteRuleTokenStream(adaptor,"token Equals");
        RewriteRuleTokenStream stream_Classname=new RewriteRuleTokenStream(adaptor,"token Classname");
        RewriteRuleSubtreeStream stream_headerModifier=new RewriteRuleSubtreeStream(adaptor,"rule headerModifier");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:155:25: ( headerModifier Equals (hmValue= Bool |hmValue= Classname ) -> headerModifier $hmValue)
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:155:27: headerModifier Equals (hmValue= Bool |hmValue= Classname )
            {
            pushFollow(FOLLOW_headerModifier_in_headerModifierAssignment358);
            headerModifier21=headerModifier();

            state._fsp--;

            stream_headerModifier.add(headerModifier21.getTree());

            Equals22=(Token)match(input,Equals,FOLLOW_Equals_in_headerModifierAssignment360);  
            stream_Equals.add(Equals22);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:155:49: (hmValue= Bool |hmValue= Classname )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==Bool) ) {
                alt10=1;
            }
            else if ( (LA10_0==Classname) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }
            switch (alt10) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:155:50: hmValue= Bool
                    {
                    hmValue=(Token)match(input,Bool,FOLLOW_Bool_in_headerModifierAssignment365);  
                    stream_Bool.add(hmValue);


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:155:65: hmValue= Classname
                    {
                    hmValue=(Token)match(input,Classname,FOLLOW_Classname_in_headerModifierAssignment371);  
                    stream_Classname.add(hmValue);


                    }
                    break;

            }


            // AST REWRITE
            // elements: headerModifier, hmValue
            // token labels: hmValue
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleTokenStream stream_hmValue=new RewriteRuleTokenStream(adaptor,"token hmValue",hmValue);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 156:2: -> headerModifier $hmValue
            {
                adaptor.addChild(root_0, stream_headerModifier.nextTree());

                adaptor.addChild(root_0, stream_hmValue.nextNode());

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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:158:1: headerModifier : ( BatchMode | CacheUnique | Processor );
    public final ImpexParser.headerModifier_return headerModifier() throws RecognitionException {
        ImpexParser.headerModifier_return retval = new ImpexParser.headerModifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set23=null;

        CommonTree set23_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:159:2: ( BatchMode | CacheUnique | Processor )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set23=(Token)input.LT(1);

            if ( input.LA(1)==BatchMode||input.LA(1)==CacheUnique||input.LA(1)==Processor ) {
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:162:1: record : ( Identifier )? ( QuotedField | Field )+ -> ^( RECORD ( ^( SUBTYPE Identifier ) )? ^( FIELDS ( QuotedField )* ( Field )* ) ) ;
    public final ImpexParser.record_return record() throws RecognitionException {
        ImpexParser.record_return retval = new ImpexParser.record_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Identifier24=null;
        Token QuotedField25=null;
        Token Field26=null;

        CommonTree Identifier24_tree=null;
        CommonTree QuotedField25_tree=null;
        CommonTree Field26_tree=null;
        RewriteRuleTokenStream stream_Field=new RewriteRuleTokenStream(adaptor,"token Field");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_QuotedField=new RewriteRuleTokenStream(adaptor,"token QuotedField");

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:163:5: ( ( Identifier )? ( QuotedField | Field )+ -> ^( RECORD ( ^( SUBTYPE Identifier ) )? ^( FIELDS ( QuotedField )* ( Field )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:163:7: ( Identifier )? ( QuotedField | Field )+
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:163:7: ( Identifier )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==Identifier) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:163:7: Identifier
                    {
                    Identifier24=(Token)match(input,Identifier,FOLLOW_Identifier_in_record409);  
                    stream_Identifier.add(Identifier24);


                    }
                    break;

            }


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:163:19: ( QuotedField | Field )+
            int cnt12=0;
            loop12:
            do {
                int alt12=3;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==QuotedField) ) {
                    alt12=1;
                }
                else if ( (LA12_0==Field) ) {
                    alt12=2;
                }


                switch (alt12) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:163:20: QuotedField
            	    {
            	    QuotedField25=(Token)match(input,QuotedField,FOLLOW_QuotedField_in_record413);  
            	    stream_QuotedField.add(QuotedField25);


            	    }
            	    break;
            	case 2 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:163:34: Field
            	    {
            	    Field26=(Token)match(input,Field,FOLLOW_Field_in_record417);  
            	    stream_Field.add(Field26);


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
            // elements: Field, QuotedField, Identifier
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 164:6: -> ^( RECORD ( ^( SUBTYPE Identifier ) )? ^( FIELDS ( QuotedField )* ( Field )* ) )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:164:9: ^( RECORD ( ^( SUBTYPE Identifier ) )? ^( FIELDS ( QuotedField )* ( Field )* ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(RECORD, "RECORD")
                , root_1);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:164:18: ( ^( SUBTYPE Identifier ) )?
                if ( stream_Identifier.hasNext() ) {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:164:18: ^( SUBTYPE Identifier )
                    {
                    CommonTree root_2 = (CommonTree)adaptor.nil();
                    root_2 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(SUBTYPE, "SUBTYPE")
                    , root_2);

                    adaptor.addChild(root_2, 
                    stream_Identifier.nextNode()
                    );

                    adaptor.addChild(root_1, root_2);
                    }

                }
                stream_Identifier.reset();

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:164:41: ^( FIELDS ( QuotedField )* ( Field )* )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(FIELDS, "FIELDS")
                , root_2);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:164:50: ( QuotedField )*
                while ( stream_QuotedField.hasNext() ) {
                    adaptor.addChild(root_2, 
                    stream_QuotedField.nextNode()
                    );

                }
                stream_QuotedField.reset();

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:164:63: ( Field )*
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


    public static class attribute_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "attribute"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:167:1: attribute : ( specialAttribute | normalAttribute )? -> ^( ATTRIBUTE ( specialAttribute )? ( normalAttribute )? ) ;
    public final ImpexParser.attribute_return attribute() throws RecognitionException {
        ImpexParser.attribute_return retval = new ImpexParser.attribute_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        ImpexParser.specialAttribute_return specialAttribute27 =null;

        ImpexParser.normalAttribute_return normalAttribute28 =null;


        RewriteRuleSubtreeStream stream_normalAttribute=new RewriteRuleSubtreeStream(adaptor,"rule normalAttribute");
        RewriteRuleSubtreeStream stream_specialAttribute=new RewriteRuleSubtreeStream(adaptor,"rule specialAttribute");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:167:11: ( ( specialAttribute | normalAttribute )? -> ^( ATTRIBUTE ( specialAttribute )? ( normalAttribute )? ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:167:13: ( specialAttribute | normalAttribute )?
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:167:13: ( specialAttribute | normalAttribute )?
            int alt13=3;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==SpecialAttribute) ) {
                alt13=1;
            }
            else if ( (LA13_0==Identifier||LA13_0==Macrodef) ) {
                alt13=2;
            }
            switch (alt13) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:167:14: specialAttribute
                    {
                    pushFollow(FOLLOW_specialAttribute_in_attribute458);
                    specialAttribute27=specialAttribute();

                    state._fsp--;

                    stream_specialAttribute.add(specialAttribute27.getTree());

                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:167:33: normalAttribute
                    {
                    pushFollow(FOLLOW_normalAttribute_in_attribute462);
                    normalAttribute28=normalAttribute();

                    state._fsp--;

                    stream_normalAttribute.add(normalAttribute28.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: normalAttribute, specialAttribute
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 168:2: -> ^( ATTRIBUTE ( specialAttribute )? ( normalAttribute )? )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:168:5: ^( ATTRIBUTE ( specialAttribute )? ( normalAttribute )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ATTRIBUTE, "ATTRIBUTE")
                , root_1);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:168:17: ( specialAttribute )?
                if ( stream_specialAttribute.hasNext() ) {
                    adaptor.addChild(root_1, stream_specialAttribute.nextTree());

                }
                stream_specialAttribute.reset();

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:168:35: ( normalAttribute )?
                if ( stream_normalAttribute.hasNext() ) {
                    adaptor.addChild(root_1, stream_normalAttribute.nextTree());

                }
                stream_normalAttribute.reset();

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


    public static class normalAttribute_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "normalAttribute"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:171:1: normalAttribute : attributeName ( attributeModifiers )? -> attributeName ( ^( MODIFIERS attributeModifiers ) )? ;
    public final ImpexParser.normalAttribute_return normalAttribute() throws RecognitionException {
        ImpexParser.normalAttribute_return retval = new ImpexParser.normalAttribute_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        ImpexParser.attributeName_return attributeName29 =null;

        ImpexParser.attributeModifiers_return attributeModifiers30 =null;


        RewriteRuleSubtreeStream stream_attributeName=new RewriteRuleSubtreeStream(adaptor,"rule attributeName");
        RewriteRuleSubtreeStream stream_attributeModifiers=new RewriteRuleSubtreeStream(adaptor,"rule attributeModifiers");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:172:2: ( attributeName ( attributeModifiers )? -> attributeName ( ^( MODIFIERS attributeModifiers ) )? )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:172:4: attributeName ( attributeModifiers )?
            {
            pushFollow(FOLLOW_attributeName_in_normalAttribute487);
            attributeName29=attributeName();

            state._fsp--;

            stream_attributeName.add(attributeName29.getTree());

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:172:18: ( attributeModifiers )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==LBracket) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:172:18: attributeModifiers
                    {
                    pushFollow(FOLLOW_attributeModifiers_in_normalAttribute489);
                    attributeModifiers30=attributeModifiers();

                    state._fsp--;

                    stream_attributeModifiers.add(attributeModifiers30.getTree());

                    }
                    break;

            }


            // AST REWRITE
            // elements: attributeName, attributeModifiers
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 173:2: -> attributeName ( ^( MODIFIERS attributeModifiers ) )?
            {
                adaptor.addChild(root_0, stream_attributeName.nextTree());

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:173:19: ( ^( MODIFIERS attributeModifiers ) )?
                if ( stream_attributeModifiers.hasNext() ) {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:173:19: ^( MODIFIERS attributeModifiers )
                    {
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    root_1 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(MODIFIERS, "MODIFIERS")
                    , root_1);

                    adaptor.addChild(root_1, stream_attributeModifiers.nextTree());

                    adaptor.addChild(root_0, root_1);
                    }

                }
                stream_attributeModifiers.reset();

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
    // $ANTLR end "normalAttribute"


    public static class specialAttribute_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "specialAttribute"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:176:1: specialAttribute : SpecialAttribute LBracket attributeModifierAssignment RBracket -> SpecialAttribute ^( MODIFIERS ^( MODIFIER attributeModifierAssignment ) ) ;
    public final ImpexParser.specialAttribute_return specialAttribute() throws RecognitionException {
        ImpexParser.specialAttribute_return retval = new ImpexParser.specialAttribute_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token SpecialAttribute31=null;
        Token LBracket32=null;
        Token RBracket34=null;
        ImpexParser.attributeModifierAssignment_return attributeModifierAssignment33 =null;


        CommonTree SpecialAttribute31_tree=null;
        CommonTree LBracket32_tree=null;
        CommonTree RBracket34_tree=null;
        RewriteRuleTokenStream stream_RBracket=new RewriteRuleTokenStream(adaptor,"token RBracket");
        RewriteRuleTokenStream stream_SpecialAttribute=new RewriteRuleTokenStream(adaptor,"token SpecialAttribute");
        RewriteRuleTokenStream stream_LBracket=new RewriteRuleTokenStream(adaptor,"token LBracket");
        RewriteRuleSubtreeStream stream_attributeModifierAssignment=new RewriteRuleSubtreeStream(adaptor,"rule attributeModifierAssignment");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:177:2: ( SpecialAttribute LBracket attributeModifierAssignment RBracket -> SpecialAttribute ^( MODIFIERS ^( MODIFIER attributeModifierAssignment ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:177:3: SpecialAttribute LBracket attributeModifierAssignment RBracket
            {
            SpecialAttribute31=(Token)match(input,SpecialAttribute,FOLLOW_SpecialAttribute_in_specialAttribute511);  
            stream_SpecialAttribute.add(SpecialAttribute31);


            LBracket32=(Token)match(input,LBracket,FOLLOW_LBracket_in_specialAttribute513);  
            stream_LBracket.add(LBracket32);


            pushFollow(FOLLOW_attributeModifierAssignment_in_specialAttribute515);
            attributeModifierAssignment33=attributeModifierAssignment();

            state._fsp--;

            stream_attributeModifierAssignment.add(attributeModifierAssignment33.getTree());

            RBracket34=(Token)match(input,RBracket,FOLLOW_RBracket_in_specialAttribute517);  
            stream_RBracket.add(RBracket34);


            // AST REWRITE
            // elements: attributeModifierAssignment, SpecialAttribute
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 178:2: -> SpecialAttribute ^( MODIFIERS ^( MODIFIER attributeModifierAssignment ) )
            {
                adaptor.addChild(root_0, 
                stream_SpecialAttribute.nextNode()
                );

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:178:22: ^( MODIFIERS ^( MODIFIER attributeModifierAssignment ) )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(MODIFIERS, "MODIFIERS")
                , root_1);

                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:178:34: ^( MODIFIER attributeModifierAssignment )
                {
                CommonTree root_2 = (CommonTree)adaptor.nil();
                root_2 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(MODIFIER, "MODIFIER")
                , root_2);

                adaptor.addChild(root_2, stream_attributeModifierAssignment.nextTree());

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
    // $ANTLR end "specialAttribute"


    public static class attributeModifiers_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "attributeModifiers"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:180:1: attributeModifiers : ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket )+ -> ( ^( MODIFIER attributeModifierAssignment ) )+ ;
    public final ImpexParser.attributeModifiers_return attributeModifiers() throws RecognitionException {
        ImpexParser.attributeModifiers_return retval = new ImpexParser.attributeModifiers_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token LBracket35=null;
        Token Comma37=null;
        Token RBracket39=null;
        ImpexParser.attributeModifierAssignment_return attributeModifierAssignment36 =null;

        ImpexParser.attributeModifierAssignment_return attributeModifierAssignment38 =null;


        CommonTree LBracket35_tree=null;
        CommonTree Comma37_tree=null;
        CommonTree RBracket39_tree=null;
        RewriteRuleTokenStream stream_RBracket=new RewriteRuleTokenStream(adaptor,"token RBracket");
        RewriteRuleTokenStream stream_LBracket=new RewriteRuleTokenStream(adaptor,"token LBracket");
        RewriteRuleTokenStream stream_Comma=new RewriteRuleTokenStream(adaptor,"token Comma");
        RewriteRuleSubtreeStream stream_attributeModifierAssignment=new RewriteRuleSubtreeStream(adaptor,"rule attributeModifierAssignment");
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:181:2: ( ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket )+ -> ( ^( MODIFIER attributeModifierAssignment ) )+ )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:181:4: ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket )+
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:181:4: ( LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==LBracket) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:181:5: LBracket attributeModifierAssignment ( Comma attributeModifierAssignment )* RBracket
            	    {
            	    LBracket35=(Token)match(input,LBracket,FOLLOW_LBracket_in_attributeModifiers545);  
            	    stream_LBracket.add(LBracket35);


            	    pushFollow(FOLLOW_attributeModifierAssignment_in_attributeModifiers547);
            	    attributeModifierAssignment36=attributeModifierAssignment();

            	    state._fsp--;

            	    stream_attributeModifierAssignment.add(attributeModifierAssignment36.getTree());

            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:181:42: ( Comma attributeModifierAssignment )*
            	    loop15:
            	    do {
            	        int alt15=2;
            	        int LA15_0 = input.LA(1);

            	        if ( (LA15_0==Comma) ) {
            	            alt15=1;
            	        }


            	        switch (alt15) {
            	    	case 1 :
            	    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:181:43: Comma attributeModifierAssignment
            	    	    {
            	    	    Comma37=(Token)match(input,Comma,FOLLOW_Comma_in_attributeModifiers550);  
            	    	    stream_Comma.add(Comma37);


            	    	    pushFollow(FOLLOW_attributeModifierAssignment_in_attributeModifiers553);
            	    	    attributeModifierAssignment38=attributeModifierAssignment();

            	    	    state._fsp--;

            	    	    stream_attributeModifierAssignment.add(attributeModifierAssignment38.getTree());

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop15;
            	        }
            	    } while (true);


            	    RBracket39=(Token)match(input,RBracket,FOLLOW_RBracket_in_attributeModifiers557);  
            	    stream_RBracket.add(RBracket39);


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
            // elements: attributeModifierAssignment
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 182:2: -> ( ^( MODIFIER attributeModifierAssignment ) )+
            {
                if ( !(stream_attributeModifierAssignment.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_attributeModifierAssignment.hasNext() ) {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:182:5: ^( MODIFIER attributeModifierAssignment )
                    {
                    CommonTree root_1 = (CommonTree)adaptor.nil();
                    root_1 = (CommonTree)adaptor.becomeRoot(
                    (CommonTree)adaptor.create(MODIFIER, "MODIFIER")
                    , root_1);

                    adaptor.addChild(root_1, stream_attributeModifierAssignment.nextTree());

                    adaptor.addChild(root_0, root_1);
                    }

                }
                stream_attributeModifierAssignment.reset();

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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:184:1: attributeModifierAssignment : attributeModifier ArgumentModifierval ;
    public final ImpexParser.attributeModifierAssignment_return attributeModifierAssignment() throws RecognitionException {
        ImpexParser.attributeModifierAssignment_return retval = new ImpexParser.attributeModifierAssignment_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ArgumentModifierval41=null;
        ImpexParser.attributeModifier_return attributeModifier40 =null;


        CommonTree ArgumentModifierval41_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:185:2: ( attributeModifier ArgumentModifierval )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:185:4: attributeModifier ArgumentModifierval
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_attributeModifier_in_attributeModifierAssignment578);
            attributeModifier40=attributeModifier();

            state._fsp--;

            adaptor.addChild(root_0, attributeModifier40.getTree());

            ArgumentModifierval41=(Token)match(input,ArgumentModifierval,FOLLOW_ArgumentModifierval_in_attributeModifierAssignment580); 
            ArgumentModifierval41_tree = 
            (CommonTree)adaptor.create(ArgumentModifierval41)
            ;
            adaptor.addChild(root_0, ArgumentModifierval41_tree);


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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:187:1: attributeName : ( Macrodef | ( Identifier ( Dot Identifier | ( LParenthesis ( DocumentID | attributeName ( Comma attributeName )* ) RParenthesis ) )? ) );
    public final ImpexParser.attributeName_return attributeName() throws RecognitionException {
        ImpexParser.attributeName_return retval = new ImpexParser.attributeName_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Macrodef42=null;
        Token Identifier43=null;
        Token Dot44=null;
        Token Identifier45=null;
        Token LParenthesis46=null;
        Token DocumentID47=null;
        Token Comma49=null;
        Token RParenthesis51=null;
        ImpexParser.attributeName_return attributeName48 =null;

        ImpexParser.attributeName_return attributeName50 =null;


        CommonTree Macrodef42_tree=null;
        CommonTree Identifier43_tree=null;
        CommonTree Dot44_tree=null;
        CommonTree Identifier45_tree=null;
        CommonTree LParenthesis46_tree=null;
        CommonTree DocumentID47_tree=null;
        CommonTree Comma49_tree=null;
        CommonTree RParenthesis51_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:188:2: ( Macrodef | ( Identifier ( Dot Identifier | ( LParenthesis ( DocumentID | attributeName ( Comma attributeName )* ) RParenthesis ) )? ) )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==Macrodef) ) {
                alt20=1;
            }
            else if ( (LA20_0==Identifier) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;

            }
            switch (alt20) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:188:3: Macrodef
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    Macrodef42=(Token)match(input,Macrodef,FOLLOW_Macrodef_in_attributeName591); 
                    Macrodef42_tree = 
                    (CommonTree)adaptor.create(Macrodef42)
                    ;
                    adaptor.addChild(root_0, Macrodef42_tree);


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:188:14: ( Identifier ( Dot Identifier | ( LParenthesis ( DocumentID | attributeName ( Comma attributeName )* ) RParenthesis ) )? )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:188:14: ( Identifier ( Dot Identifier | ( LParenthesis ( DocumentID | attributeName ( Comma attributeName )* ) RParenthesis ) )? )
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:188:15: Identifier ( Dot Identifier | ( LParenthesis ( DocumentID | attributeName ( Comma attributeName )* ) RParenthesis ) )?
                    {
                    Identifier43=(Token)match(input,Identifier,FOLLOW_Identifier_in_attributeName596); 
                    Identifier43_tree = 
                    (CommonTree)adaptor.create(Identifier43)
                    ;
                    adaptor.addChild(root_0, Identifier43_tree);


                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:188:26: ( Dot Identifier | ( LParenthesis ( DocumentID | attributeName ( Comma attributeName )* ) RParenthesis ) )?
                    int alt19=3;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==Dot) ) {
                        alt19=1;
                    }
                    else if ( (LA19_0==LParenthesis) ) {
                        alt19=2;
                    }
                    switch (alt19) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:188:27: Dot Identifier
                            {
                            Dot44=(Token)match(input,Dot,FOLLOW_Dot_in_attributeName599); 
                            Dot44_tree = 
                            (CommonTree)adaptor.create(Dot44)
                            ;
                            adaptor.addChild(root_0, Dot44_tree);


                            Identifier45=(Token)match(input,Identifier,FOLLOW_Identifier_in_attributeName601); 
                            Identifier45_tree = 
                            (CommonTree)adaptor.create(Identifier45)
                            ;
                            adaptor.addChild(root_0, Identifier45_tree);


                            }
                            break;
                        case 2 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:188:45: ( LParenthesis ( DocumentID | attributeName ( Comma attributeName )* ) RParenthesis )
                            {
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:188:45: ( LParenthesis ( DocumentID | attributeName ( Comma attributeName )* ) RParenthesis )
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:188:46: LParenthesis ( DocumentID | attributeName ( Comma attributeName )* ) RParenthesis
                            {
                            LParenthesis46=(Token)match(input,LParenthesis,FOLLOW_LParenthesis_in_attributeName607); 
                            LParenthesis46_tree = 
                            (CommonTree)adaptor.create(LParenthesis46)
                            ;
                            adaptor.addChild(root_0, LParenthesis46_tree);


                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:188:60: ( DocumentID | attributeName ( Comma attributeName )* )
                            int alt18=2;
                            int LA18_0 = input.LA(1);

                            if ( (LA18_0==DocumentID) ) {
                                alt18=1;
                            }
                            else if ( (LA18_0==Identifier||LA18_0==Macrodef) ) {
                                alt18=2;
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 18, 0, input);

                                throw nvae;

                            }
                            switch (alt18) {
                                case 1 :
                                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:188:61: DocumentID
                                    {
                                    DocumentID47=(Token)match(input,DocumentID,FOLLOW_DocumentID_in_attributeName611); 
                                    DocumentID47_tree = 
                                    (CommonTree)adaptor.create(DocumentID47)
                                    ;
                                    adaptor.addChild(root_0, DocumentID47_tree);


                                    }
                                    break;
                                case 2 :
                                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:188:75: attributeName ( Comma attributeName )*
                                    {
                                    pushFollow(FOLLOW_attributeName_in_attributeName616);
                                    attributeName48=attributeName();

                                    state._fsp--;

                                    adaptor.addChild(root_0, attributeName48.getTree());

                                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:188:89: ( Comma attributeName )*
                                    loop17:
                                    do {
                                        int alt17=2;
                                        int LA17_0 = input.LA(1);

                                        if ( (LA17_0==Comma) ) {
                                            alt17=1;
                                        }


                                        switch (alt17) {
                                    	case 1 :
                                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:188:90: Comma attributeName
                                    	    {
                                    	    Comma49=(Token)match(input,Comma,FOLLOW_Comma_in_attributeName619); 
                                    	    Comma49_tree = 
                                    	    (CommonTree)adaptor.create(Comma49)
                                    	    ;
                                    	    adaptor.addChild(root_0, Comma49_tree);


                                    	    pushFollow(FOLLOW_attributeName_in_attributeName621);
                                    	    attributeName50=attributeName();

                                    	    state._fsp--;

                                    	    adaptor.addChild(root_0, attributeName50.getTree());

                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop17;
                                        }
                                    } while (true);


                                    }
                                    break;

                            }


                            RParenthesis51=(Token)match(input,RParenthesis,FOLLOW_RParenthesis_in_attributeName626); 
                            RParenthesis51_tree = 
                            (CommonTree)adaptor.create(RParenthesis51)
                            ;
                            adaptor.addChild(root_0, RParenthesis51_tree);


                            }


                            }
                            break;

                    }


                    }


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


    public static class macro_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "macro"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:190:1: macro : Macrodef Macroval -> ^( ASSIGNEMENT Macrodef Macroval ) ;
    public final ImpexParser.macro_return macro() throws RecognitionException {
        ImpexParser.macro_return retval = new ImpexParser.macro_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Macrodef52=null;
        Token Macroval53=null;

        CommonTree Macrodef52_tree=null;
        CommonTree Macroval53_tree=null;
        RewriteRuleTokenStream stream_Macroval=new RewriteRuleTokenStream(adaptor,"token Macroval");
        RewriteRuleTokenStream stream_Macrodef=new RewriteRuleTokenStream(adaptor,"token Macrodef");

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:191:2: ( Macrodef Macroval -> ^( ASSIGNEMENT Macrodef Macroval ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:191:3: Macrodef Macroval
            {
            Macrodef52=(Token)match(input,Macrodef,FOLLOW_Macrodef_in_macro639);  
            stream_Macrodef.add(Macrodef52);


            Macroval53=(Token)match(input,Macroval,FOLLOW_Macroval_in_macro641);  
            stream_Macroval.add(Macroval53);


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
            // 192:2: -> ^( ASSIGNEMENT Macrodef Macroval )
            {
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:192:5: ^( ASSIGNEMENT Macrodef Macroval )
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


    public static class attributeModifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "attributeModifier"
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:194:1: attributeModifier : ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual );
    public final ImpexParser.attributeModifier_return attributeModifier() throws RecognitionException {
        ImpexParser.attributeModifier_return retval = new ImpexParser.attributeModifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set54=null;

        CommonTree set54_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:195:2: ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set54=(Token)input.LT(1);

            if ( (input.LA(1) >= Alias && input.LA(1) <= AllowNull)||input.LA(1)==CellDecorator||input.LA(1)==CollectionDelimiter||(input.LA(1) >= Dateformat && input.LA(1) <= Default)||input.LA(1)==ForceWrite||(input.LA(1) >= IgnoreKeyCase && input.LA(1) <= IgnoreNull)||input.LA(1)==KeyToValueDelimiter||input.LA(1)==Lang||(input.LA(1) >= MapDelimiter && input.LA(1) <= Mode)||(input.LA(1) >= NumberFormat && input.LA(1) <= Pos)||(input.LA(1) >= Translator && input.LA(1) <= Unique)||input.LA(1)==Virtual ) {
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:198:1: headerMode : ( Insert | InsertUpdate | Update | Remove );
    public final ImpexParser.headerMode_return headerMode() throws RecognitionException {
        ImpexParser.headerMode_return retval = new ImpexParser.headerMode_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set55=null;

        CommonTree set55_tree=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:199:2: ( Insert | InsertUpdate | Update | Remove )
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


    protected DFA4 dfa4 = new DFA4(this);
    static final String DFA4_eotS =
        "\4\uffff";
    static final String DFA4_eofS =
        "\1\1\1\uffff\1\1\1\uffff";
    static final String DFA4_minS =
        "\1\50\1\uffff\1\37\1\uffff";
    static final String DFA4_maxS =
        "\1\106\1\uffff\1\106\1\uffff";
    static final String DFA4_acceptS =
        "\1\uffff\1\2\1\uffff\1\1";
    static final String DFA4_specialS =
        "\4\uffff}>";
    static final String[] DFA4_transitionS = {
            "\2\1\4\uffff\1\2\2\uffff\1\1\15\uffff\1\1\6\uffff\1\1",
            "",
            "\1\3\5\uffff\1\3\2\uffff\2\1\4\uffff\1\2\2\uffff\1\1\10\uffff"+
            "\1\3\4\uffff\1\1\6\uffff\1\1",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "()+ loopback of 144:16: ( ( Lb )+ record )+";
        }
    }
 

    public static final BitSet FOLLOW_EOF_in_parse161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Lb_in_impex173 = new BitSet(new long[]{0x8002430000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_block_in_impex178 = new BitSet(new long[]{0x8002430000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_macro_in_impex182 = new BitSet(new long[]{0x8002430000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_EOF_in_impex186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_header_in_block224 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_Lb_in_block227 = new BitSet(new long[]{0x0400402080000000L});
    public static final BitSet FOLLOW_record_in_block231 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_headerMode_in_header258 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_Identifier_in_header261 = new BitSet(new long[]{0x0000080000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_headerModifiers_in_header263 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_Semicolon_in_header268 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_DocumentID_in_header270 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_Semicolon_in_header275 = new BitSet(new long[]{0x0002002000000000L,0x0000000000000006L});
    public static final BitSet FOLLOW_attribute_in_header277 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_LBracket_in_headerModifiers327 = new BitSet(new long[]{0x0200000000014000L});
    public static final BitSet FOLLOW_headerModifierAssignment_in_headerModifiers329 = new BitSet(new long[]{0x0800000000200000L});
    public static final BitSet FOLLOW_Comma_in_headerModifiers332 = new BitSet(new long[]{0x0200000000014000L});
    public static final BitSet FOLLOW_headerModifierAssignment_in_headerModifiers335 = new BitSet(new long[]{0x0800000000200000L});
    public static final BitSet FOLLOW_RBracket_in_headerModifiers339 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_headerModifier_in_headerModifierAssignment358 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_Equals_in_headerModifierAssignment360 = new BitSet(new long[]{0x0000000000088000L});
    public static final BitSet FOLLOW_Bool_in_headerModifierAssignment365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Classname_in_headerModifierAssignment371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_record409 = new BitSet(new long[]{0x0400000080000000L});
    public static final BitSet FOLLOW_QuotedField_in_record413 = new BitSet(new long[]{0x0400000080000002L});
    public static final BitSet FOLLOW_Field_in_record417 = new BitSet(new long[]{0x0400000080000002L});
    public static final BitSet FOLLOW_specialAttribute_in_attribute458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_normalAttribute_in_attribute462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeName_in_normalAttribute487 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_attributeModifiers_in_normalAttribute489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SpecialAttribute_in_specialAttribute511 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_LBracket_in_specialAttribute513 = new BitSet(new long[]{0x01D824C103120300L,0x00000000000000B0L});
    public static final BitSet FOLLOW_attributeModifierAssignment_in_specialAttribute515 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_RBracket_in_specialAttribute517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LBracket_in_attributeModifiers545 = new BitSet(new long[]{0x01D824C103120300L,0x00000000000000B0L});
    public static final BitSet FOLLOW_attributeModifierAssignment_in_attributeModifiers547 = new BitSet(new long[]{0x0800000000200000L});
    public static final BitSet FOLLOW_Comma_in_attributeModifiers550 = new BitSet(new long[]{0x01D824C103120300L,0x00000000000000B0L});
    public static final BitSet FOLLOW_attributeModifierAssignment_in_attributeModifiers553 = new BitSet(new long[]{0x0800000000200000L});
    public static final BitSet FOLLOW_RBracket_in_attributeModifiers557 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_attributeModifier_in_attributeModifierAssignment578 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_ArgumentModifierval_in_attributeModifierAssignment580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Macrodef_in_attributeName591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_attributeName596 = new BitSet(new long[]{0x0000100008000002L});
    public static final BitSet FOLLOW_Dot_in_attributeName599 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_Identifier_in_attributeName601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LParenthesis_in_attributeName607 = new BitSet(new long[]{0x0002002004000000L});
    public static final BitSet FOLLOW_DocumentID_in_attributeName611 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_attributeName_in_attributeName616 = new BitSet(new long[]{0x4000000000200000L});
    public static final BitSet FOLLOW_Comma_in_attributeName619 = new BitSet(new long[]{0x0002002000000000L});
    public static final BitSet FOLLOW_attributeName_in_attributeName621 = new BitSet(new long[]{0x4000000000200000L});
    public static final BitSet FOLLOW_RParenthesis_in_attributeName626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Macrodef_in_macro639 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_Macroval_in_macro641 = new BitSet(new long[]{0x0000000000000002L});

}