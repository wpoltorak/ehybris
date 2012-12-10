// $ANTLR 3.4 /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g 2012-12-10 21:22:24

package output;

import output.tree.AttributeNode;
import output.tree.BlockNode;
import output.tree.HeaderNode;
import output.tree.ImpexNode;
import output.tree.ModifierNode;
import output.tree.RecordNode;
import output.tree.RefNode;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class ImpexTreeWalker extends TreeParser {
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
    public TreeParser[] getDelegates() {
        return new TreeParser[] {};
    }

    // delegators


    public ImpexTreeWalker(TreeNodeStream input) {
        this(input, new RecognizerSharedState());
    }
    public ImpexTreeWalker(TreeNodeStream input, RecognizerSharedState state) {
        super(input, state);
    }

    public String[] getTokenNames() { return ImpexTreeWalker.tokenNames; }
    public String getGrammarFileName() { return "/work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g"; }



    // $ANTLR start "walk"
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:20:1: walk returns [List<ImpexNode> blocks] : impex ;
    public final List<ImpexNode> walk() throws RecognitionException {
        List<ImpexNode> blocks = null;


        List<ImpexNode> impex1 =null;


        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:21:2: ( impex )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:21:3: impex
            {
            pushFollow(FOLLOW_impex_in_walk45);
            impex1=impex();

            state._fsp--;


            blocks = impex1;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return blocks;
    }
    // $ANTLR end "walk"



    // $ANTLR start "impex"
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:23:1: impex returns [List<ImpexNode> blocks] : ^( IMPEX ^( BLOCKS ( block )* ) ) ;
    public final List<ImpexNode> impex() throws RecognitionException {
        List<ImpexNode> blocks = null;


        ImpexNode block2 =null;



        		blocks = new ArrayList<ImpexNode>();
        	
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:27:2: ( ^( IMPEX ^( BLOCKS ( block )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:27:3: ^( IMPEX ^( BLOCKS ( block )* ) )
            {
            match(input,IMPEX,FOLLOW_IMPEX_in_impex65); 

            match(input, Token.DOWN, null); 
            match(input,BLOCKS,FOLLOW_BLOCKS_in_impex69); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:27:21: ( block )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==BLOCK) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:27:22: block
                	    {
                	    pushFollow(FOLLOW_block_in_impex72);
                	    block2=block();

                	    state._fsp--;


                	    blocks.add(block2);

                	    }
                	    break;

                	default :
                	    break loop1;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return blocks;
    }
    // $ANTLR end "impex"



    // $ANTLR start "block"
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:29:1: block returns [ImpexNode node] : ^( BLOCK ( header ) ^( RECORDS ( record )+ ) ) ;
    public final ImpexNode block() throws RecognitionException {
        ImpexNode node = null;


        ImpexNode header3 =null;

        ImpexNode record4 =null;


         
         		 BlockNode bn = new BlockNode(); 
         		 node = bn; 
        	
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:34:2: ( ^( BLOCK ( header ) ^( RECORDS ( record )+ ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:34:3: ^( BLOCK ( header ) ^( RECORDS ( record )+ ) )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_block99); 

            match(input, Token.DOWN, null); 
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:34:11: ( header )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:34:12: header
            {
            pushFollow(FOLLOW_header_in_block102);
            header3=header();

            state._fsp--;


            bn.setHeader(header3);

            }


            match(input,RECORDS,FOLLOW_RECORDS_in_block109); 

            match(input, Token.DOWN, null); 
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:35:12: ( record )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==RECORD) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:35:13: record
            	    {
            	    pushFollow(FOLLOW_record_in_block112);
            	    record4=record();

            	    state._fsp--;


            	    bn.addRecord(record4);

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            match(input, Token.UP, null); 


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return node;
    }
    // $ANTLR end "block"



    // $ANTLR start "header"
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:38:1: header returns [ImpexNode node] : ^( HEADER ( headerMode ) ^( TYPE Identifier ) ^( MODIFIERS ( headerModifierAssignment )* ) ^( DOCUMENTID ( DocumentID )? ) ^( ATTRIBUTES ( attribute )* ) ) ;
    public final ImpexNode header() throws RecognitionException {
        ImpexNode node = null;


        CommonTree Identifier6=null;
        CommonTree DocumentID8=null;
        int headerMode5 =0;

        ImpexNode headerModifierAssignment7 =null;

        ImpexNode attribute9 =null;



        		HeaderNode hn = new HeaderNode();
        		node = hn;
        	
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:43:2: ( ^( HEADER ( headerMode ) ^( TYPE Identifier ) ^( MODIFIERS ( headerModifierAssignment )* ) ^( DOCUMENTID ( DocumentID )? ) ^( ATTRIBUTES ( attribute )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:43:3: ^( HEADER ( headerMode ) ^( TYPE Identifier ) ^( MODIFIERS ( headerModifierAssignment )* ) ^( DOCUMENTID ( DocumentID )? ) ^( ATTRIBUTES ( attribute )* ) )
            {
            match(input,HEADER,FOLLOW_HEADER_in_header138); 

            match(input, Token.DOWN, null); 
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:43:12: ( headerMode )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:43:13: headerMode
            {
            pushFollow(FOLLOW_headerMode_in_header141);
            headerMode5=headerMode();

            state._fsp--;


            hn.setMode(headerMode5);

            }


            match(input,TYPE,FOLLOW_TYPE_in_header148); 

            match(input, Token.DOWN, null); 
            Identifier6=(CommonTree)match(input,Identifier,FOLLOW_Identifier_in_header150); 

            hn.setType((Identifier6!=null?Identifier6.getText():null));

            match(input, Token.UP, null); 


            match(input,MODIFIERS,FOLLOW_MODIFIERS_in_header158); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:45:14: ( headerModifierAssignment )*
                loop3:
                do {
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==MODIFIER) ) {
                        alt3=1;
                    }


                    switch (alt3) {
                	case 1 :
                	    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:45:15: headerModifierAssignment
                	    {
                	    pushFollow(FOLLOW_headerModifierAssignment_in_header161);
                	    headerModifierAssignment7=headerModifierAssignment();

                	    state._fsp--;


                	    hn.addModifier(headerModifierAssignment7);

                	    }
                	    break;

                	default :
                	    break loop3;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }


            match(input,DOCUMENTID,FOLLOW_DOCUMENTID_in_header171); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:46:14: ( DocumentID )?
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==DocumentID) ) {
                    alt4=1;
                }
                switch (alt4) {
                    case 1 :
                        // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:46:15: DocumentID
                        {
                        DocumentID8=(CommonTree)match(input,DocumentID,FOLLOW_DocumentID_in_header173); 

                        hn.setDocumentID((DocumentID8!=null?DocumentID8.getText():null));

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }


            match(input,ATTRIBUTES,FOLLOW_ATTRIBUTES_in_header182); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:47:15: ( attribute )*
                loop5:
                do {
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==ATTRIBUTE) ) {
                        alt5=1;
                    }


                    switch (alt5) {
                	case 1 :
                	    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:47:16: attribute
                	    {
                	    pushFollow(FOLLOW_attribute_in_header185);
                	    attribute9=attribute();

                	    state._fsp--;


                	    hn.addAttribute(attribute9);

                	    }
                	    break;

                	default :
                	    break loop5;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return node;
    }
    // $ANTLR end "header"



    // $ANTLR start "headerModifierAssignment"
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:50:1: headerModifierAssignment returns [ImpexNode node] : ^( MODIFIER headerModifier boolOrClassname ) ;
    public final ImpexNode headerModifierAssignment() throws RecognitionException {
        ImpexNode node = null;


        int headerModifier10 =0;

        String boolOrClassname11 =null;


        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:51:3: ( ^( MODIFIER headerModifier boolOrClassname ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:51:5: ^( MODIFIER headerModifier boolOrClassname )
            {
            match(input,MODIFIER,FOLLOW_MODIFIER_in_headerModifierAssignment209); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_headerModifier_in_headerModifierAssignment211);
            headerModifier10=headerModifier();

            state._fsp--;


            pushFollow(FOLLOW_boolOrClassname_in_headerModifierAssignment213);
            boolOrClassname11=boolOrClassname();

            state._fsp--;


            match(input, Token.UP, null); 


            node = new ModifierNode(headerModifier10, boolOrClassname11);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return node;
    }
    // $ANTLR end "headerModifierAssignment"



    // $ANTLR start "boolOrClassname"
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:53:1: boolOrClassname returns [String text] : v= ( Bool | Classname ) ;
    public final String boolOrClassname() throws RecognitionException {
        String text = null;


        CommonTree v=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:54:2: (v= ( Bool | Classname ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:54:3: v= ( Bool | Classname )
            {
            v=(CommonTree)input.LT(1);

            if ( input.LA(1)==Bool||input.LA(1)==Classname ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            text = (v!=null?v.getText():null);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return text;
    }
    // $ANTLR end "boolOrClassname"



    // $ANTLR start "headerModifier"
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:56:1: headerModifier returns [int modifier] : v= ( BatchMode | CacheUnique | Processor ) ;
    public final int headerModifier() throws RecognitionException {
        int modifier = 0;


        CommonTree v=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:57:2: (v= ( BatchMode | CacheUnique | Processor ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:57:3: v= ( BatchMode | CacheUnique | Processor )
            {
            v=(CommonTree)input.LT(1);

            if ( input.LA(1)==BatchMode||input.LA(1)==CacheUnique||input.LA(1)==Processor ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            modifier = (v!=null?v.getType():0);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return modifier;
    }
    // $ANTLR end "headerModifier"



    // $ANTLR start "record"
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:59:1: record returns [ImpexNode node] : ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) ) ;
    public final ImpexNode record() throws RecognitionException {
        ImpexNode node = null;


        CommonTree Identifier12=null;
        String field13 =null;



        	    RecordNode rn = new RecordNode(); 
         	    node = rn; 
        	
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:64:5: ( ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:64:7: ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) )
            {
            match(input,RECORD,FOLLOW_RECORD_in_record286); 

            match(input, Token.DOWN, null); 
            match(input,SUBTYPE,FOLLOW_SUBTYPE_in_record294); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:65:15: ( Identifier )?
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==Identifier) ) {
                    alt6=1;
                }
                switch (alt6) {
                    case 1 :
                        // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:65:16: Identifier
                        {
                        Identifier12=(CommonTree)match(input,Identifier,FOLLOW_Identifier_in_record297); 

                        rn.setSubType((Identifier12!=null?Identifier12.getText():null));

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }


            match(input,FIELDS,FOLLOW_FIELDS_in_record310); 

            match(input, Token.DOWN, null); 
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:66:14: ( field )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==Field||LA7_0==QuotedField) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:66:15: field
            	    {
            	    pushFollow(FOLLOW_field_in_record313);
            	    field13=field();

            	    state._fsp--;


            	    rn.addField(field13);

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


            match(input, Token.UP, null); 


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return node;
    }
    // $ANTLR end "record"



    // $ANTLR start "field"
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:69:1: field returns [String text] : v= ( QuotedField | Field ) ;
    public final String field() throws RecognitionException {
        String text = null;


        CommonTree v=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:70:2: (v= ( QuotedField | Field ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:70:3: v= ( QuotedField | Field )
            {
            v=(CommonTree)input.LT(1);

            if ( input.LA(1)==Field||input.LA(1)==QuotedField ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            text = (v!=null?v.getText():null);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return text;
    }
    // $ANTLR end "field"



    // $ANTLR start "attributeName"
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:73:1: attributeName returns [ImpexNode node] : ( ^( MACRO_REF Macrodef ) | ^( ATTRIBUTE_NAME SpecialAttribute ) | ^( ATTRIBUTE_NAME Identifier ( attributeName )? ) );
    public final ImpexNode attributeName() throws RecognitionException {
        ImpexNode node = null;


        CommonTree Macrodef14=null;
        CommonTree SpecialAttribute15=null;
        CommonTree Identifier16=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:74:2: ( ^( MACRO_REF Macrodef ) | ^( ATTRIBUTE_NAME SpecialAttribute ) | ^( ATTRIBUTE_NAME Identifier ( attributeName )? ) )
            int alt9=3;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==MACRO_REF) ) {
                alt9=1;
            }
            else if ( (LA9_0==ATTRIBUTE_NAME) ) {
                int LA9_2 = input.LA(2);

                if ( (LA9_2==DOWN) ) {
                    int LA9_3 = input.LA(3);

                    if ( (LA9_3==SpecialAttribute) ) {
                        alt9=2;
                    }
                    else if ( (LA9_3==Identifier) ) {
                        alt9=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 3, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 2, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:74:3: ^( MACRO_REF Macrodef )
                    {
                    match(input,MACRO_REF,FOLLOW_MACRO_REF_in_attributeName365); 

                    match(input, Token.DOWN, null); 
                    Macrodef14=(CommonTree)match(input,Macrodef,FOLLOW_Macrodef_in_attributeName368); 

                    match(input, Token.UP, null); 


                    node = new RefNode((Macrodef14!=null?Macrodef14.getText():null), (Macrodef14!=null?Macrodef14.getType():0));

                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:75:4: ^( ATTRIBUTE_NAME SpecialAttribute )
                    {
                    match(input,ATTRIBUTE_NAME,FOLLOW_ATTRIBUTE_NAME_in_attributeName376); 

                    match(input, Token.DOWN, null); 
                    SpecialAttribute15=(CommonTree)match(input,SpecialAttribute,FOLLOW_SpecialAttribute_in_attributeName378); 

                    match(input, Token.UP, null); 


                    node = new RefNode((SpecialAttribute15!=null?SpecialAttribute15.getText():null), (SpecialAttribute15!=null?SpecialAttribute15.getType():0));

                    }
                    break;
                case 3 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:76:3: ^( ATTRIBUTE_NAME Identifier ( attributeName )? )
                    {
                    match(input,ATTRIBUTE_NAME,FOLLOW_ATTRIBUTE_NAME_in_attributeName385); 

                    match(input, Token.DOWN, null); 
                    Identifier16=(CommonTree)match(input,Identifier,FOLLOW_Identifier_in_attributeName387); 

                    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:76:31: ( attributeName )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==ATTRIBUTE_NAME||LA8_0==MACRO_REF) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:76:31: attributeName
                            {
                            pushFollow(FOLLOW_attributeName_in_attributeName389);
                            attributeName();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 


                    node = new RefNode((Identifier16!=null?Identifier16.getText():null), (Identifier16!=null?Identifier16.getType():0));

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return node;
    }
    // $ANTLR end "attributeName"



    // $ANTLR start "attribute"
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:78:1: attribute returns [ImpexNode node] : ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION (attr= attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifierAssignment )* ) ) ;
    public final ImpexNode attribute() throws RecognitionException {
        ImpexNode node = null;


        CommonTree DocumentID18=null;
        ImpexNode attr =null;

        ImpexNode attributeName17 =null;

        ImpexNode attributeModifierAssignment19 =null;



        	    AttributeNode an = new AttributeNode(); 
         	    node = an; 
        	
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:84:2: ( ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION (attr= attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifierAssignment )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:84:3: ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION (attr= attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifierAssignment )* ) )
            {
            match(input,ATTRIBUTE,FOLLOW_ATTRIBUTE_in_attribute413); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_attributeName_in_attribute415);
            attributeName17=attributeName();

            state._fsp--;


            an.setName(attributeName17);

            match(input,ITEM_EXPRESSION,FOLLOW_ITEM_EXPRESSION_in_attribute422); 

            match(input, Token.DOWN, null); 
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:85:21: (attr= attribute )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==ATTRIBUTE) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:85:22: attr= attribute
            	    {
            	    pushFollow(FOLLOW_attribute_in_attribute429);
            	    attr=attribute();

            	    state._fsp--;


            	    an.addAttribute(attr);

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            match(input,DOCUMENTID_REF,FOLLOW_DOCUMENTID_REF_in_attribute439); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:86:20: ( DocumentID )*
                loop11:
                do {
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==DocumentID) ) {
                        alt11=1;
                    }


                    switch (alt11) {
                	case 1 :
                	    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:86:21: DocumentID
                	    {
                	    DocumentID18=(CommonTree)match(input,DocumentID,FOLLOW_DocumentID_in_attribute442); 

                	    an.addAttribute(new RefNode((DocumentID18!=null?DocumentID18.getText():null), (DocumentID18!=null?DocumentID18.getType():0)));

                	    }
                	    break;

                	default :
                	    break loop11;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }


            match(input, Token.UP, null); 


            match(input,MODIFIERS,FOLLOW_MODIFIERS_in_attribute458); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:89:14: ( attributeModifierAssignment )*
                loop12:
                do {
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==MODIFIER) ) {
                        alt12=1;
                    }


                    switch (alt12) {
                	case 1 :
                	    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:89:15: attributeModifierAssignment
                	    {
                	    pushFollow(FOLLOW_attributeModifierAssignment_in_attribute461);
                	    attributeModifierAssignment19=attributeModifierAssignment();

                	    state._fsp--;


                	    an.addModifier(attributeModifierAssignment19);

                	    }
                	    break;

                	default :
                	    break loop12;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }


            match(input, Token.UP, null); 


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return node;
    }
    // $ANTLR end "attribute"



    // $ANTLR start "attributeModifierAssignment"
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:92:1: attributeModifierAssignment returns [ImpexNode node] : ^( MODIFIER attributeModifier ValueAssignment ) ;
    public final ImpexNode attributeModifierAssignment() throws RecognitionException {
        ImpexNode node = null;


        CommonTree ValueAssignment21=null;
        int attributeModifier20 =0;


        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:93:2: ( ^( MODIFIER attributeModifier ValueAssignment ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:93:4: ^( MODIFIER attributeModifier ValueAssignment )
            {
            match(input,MODIFIER,FOLLOW_MODIFIER_in_attributeModifierAssignment485); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_attributeModifier_in_attributeModifierAssignment487);
            attributeModifier20=attributeModifier();

            state._fsp--;


            ValueAssignment21=(CommonTree)match(input,ValueAssignment,FOLLOW_ValueAssignment_in_attributeModifierAssignment489); 

            match(input, Token.UP, null); 


            node = new ModifierNode(attributeModifier20, (ValueAssignment21!=null?ValueAssignment21.getText():null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return node;
    }
    // $ANTLR end "attributeModifierAssignment"



    // $ANTLR start "attributeModifier"
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:95:1: attributeModifier returns [int modifier] : v= ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual ) ;
    public final int attributeModifier() throws RecognitionException {
        int modifier = 0;


        CommonTree v=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:96:2: (v= ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:96:4: v= ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual )
            {
            v=(CommonTree)input.LT(1);

            if ( (input.LA(1) >= Alias && input.LA(1) <= AllowNull)||input.LA(1)==CellDecorator||input.LA(1)==CollectionDelimiter||(input.LA(1) >= Dateformat && input.LA(1) <= Default)||input.LA(1)==ForceWrite||(input.LA(1) >= IgnoreKeyCase && input.LA(1) <= IgnoreNull)||input.LA(1)==KeyToValueDelimiter||input.LA(1)==Lang||(input.LA(1) >= MapDelimiter && input.LA(1) <= Mode)||input.LA(1)==NumberFormat||(input.LA(1) >= PathDelimiter && input.LA(1) <= Pos)||(input.LA(1) >= Translator && input.LA(1) <= Unique)||input.LA(1)==Virtual ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            modifier = (v!=null?v.getType():0);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return modifier;
    }
    // $ANTLR end "attributeModifier"



    // $ANTLR start "headerMode"
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:99:1: headerMode returns [int mode] : v= ( Insert | InsertUpdate | Update | Remove ) ;
    public final int headerMode() throws RecognitionException {
        int mode = 0;


        CommonTree v=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:100:2: (v= ( Insert | InsertUpdate | Update | Remove ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:100:3: v= ( Insert | InsertUpdate | Update | Remove )
            {
            v=(CommonTree)input.LT(1);

            if ( (input.LA(1) >= Insert && input.LA(1) <= InsertUpdate)||input.LA(1)==Remove||input.LA(1)==Update ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            mode = (v!=null?v.getType():0);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return mode;
    }
    // $ANTLR end "headerMode"

    // Delegated rules


 

    public static final BitSet FOLLOW_impex_in_walk45 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPEX_in_impex65 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BLOCKS_in_impex69 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_impex72 = new BitSet(new long[]{0x0000000000000408L});
    public static final BitSet FOLLOW_BLOCK_in_block99 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_header_in_block102 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_RECORDS_in_block109 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_record_in_block112 = new BitSet(new long[]{0x2000000000000008L});
    public static final BitSet FOLLOW_HEADER_in_header138 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_headerMode_in_header141 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_TYPE_in_header148 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_header150 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MODIFIERS_in_header158 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_headerModifierAssignment_in_header161 = new BitSet(new long[]{0x0001000000000008L});
    public static final BitSet FOLLOW_DOCUMENTID_in_header171 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DocumentID_in_header173 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ATTRIBUTES_in_header182 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attribute_in_header185 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_MODIFIER_in_headerModifierAssignment209 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_headerModifier_in_headerModifierAssignment211 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_boolOrClassname_in_headerModifierAssignment213 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_boolOrClassname229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_headerModifier251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RECORD_in_record286 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SUBTYPE_in_record294 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_record297 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELDS_in_record310 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_in_record313 = new BitSet(new long[]{0x0800000040000008L});
    public static final BitSet FOLLOW_set_in_field339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MACRO_REF_in_attributeName365 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Macrodef_in_attributeName368 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ATTRIBUTE_NAME_in_attributeName376 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SpecialAttribute_in_attributeName378 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ATTRIBUTE_NAME_in_attributeName385 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_attributeName387 = new BitSet(new long[]{0x0000800000000048L});
    public static final BitSet FOLLOW_attributeName_in_attributeName389 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ATTRIBUTE_in_attribute413 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attributeName_in_attribute415 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_ITEM_EXPRESSION_in_attribute422 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attribute_in_attribute429 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_DOCUMENTID_REF_in_attribute439 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DocumentID_in_attribute442 = new BitSet(new long[]{0x0000000002000008L});
    public static final BitSet FOLLOW_MODIFIERS_in_attribute458 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attributeModifierAssignment_in_attribute461 = new BitSet(new long[]{0x0001000000000008L});
    public static final BitSet FOLLOW_MODIFIER_in_attributeModifierAssignment485 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attributeModifier_in_attributeModifierAssignment487 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ValueAssignment_in_attributeModifierAssignment489 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_attributeModifier507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_headerMode596 = new BitSet(new long[]{0x0000000000000002L});

}