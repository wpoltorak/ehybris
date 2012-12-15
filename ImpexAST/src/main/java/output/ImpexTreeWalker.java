// $ANTLR 3.4 /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g 2012-12-15 23:09:38

package output;

import output.tree.AttributeNameNode;
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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ATTRIBUTE", "ATTRIBUTES", "ATTRIBUTE_NAME", "Alias", "AllowNull", "AttributeModifier", "BLOCK", "BLOCKS", "BatchMode", "BeanShell", "Bool", "CacheUnique", "CellDecorator", "Char", "Classname", "CollectionDelimiter", "Comma", "Comment", "DOCUMENTID", "DOCUMENTID_REF", "Dateformat", "Default", "DocumentID", "Dot", "DoubleQuote", "Equals", "FIELDS", "Field", "ForceWrite", "HEADER", "HeaderMode", "HeaderModifier", "IMPEX", "ITEM_EXPRESSION", "Identifier", "IgnoreKeyCase", "IgnoreNull", "Insert", "InsertUpdate", "KeyToValueDelimiter", "LBracket", "LParenthesis", "Lang", "Lb", "MACRO_REF", "MODIFIER", "MODIFIERS", "Macrodef", "MapDelimiter", "Mode", "NextRow", "NumberFormat", "Or", "PathDelimiter", "Pos", "Processor", "QuotedField", "RBracket", "RECORD", "RECORDS", "RParenthesis", "Remove", "SUBTYPE", "Semicolon", "SpecialAttribute", "TYPE", "Translator", "Unique", "Update", "UserRights", "ValueAssignment", "Virtual", "Ws"
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
    public static final int BeanShell=13;
    public static final int Bool=14;
    public static final int CacheUnique=15;
    public static final int CellDecorator=16;
    public static final int Char=17;
    public static final int Classname=18;
    public static final int CollectionDelimiter=19;
    public static final int Comma=20;
    public static final int Comment=21;
    public static final int DOCUMENTID=22;
    public static final int DOCUMENTID_REF=23;
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
    public static final int ITEM_EXPRESSION=37;
    public static final int Identifier=38;
    public static final int IgnoreKeyCase=39;
    public static final int IgnoreNull=40;
    public static final int Insert=41;
    public static final int InsertUpdate=42;
    public static final int KeyToValueDelimiter=43;
    public static final int LBracket=44;
    public static final int LParenthesis=45;
    public static final int Lang=46;
    public static final int Lb=47;
    public static final int MACRO_REF=48;
    public static final int MODIFIER=49;
    public static final int MODIFIERS=50;
    public static final int Macrodef=51;
    public static final int MapDelimiter=52;
    public static final int Mode=53;
    public static final int NextRow=54;
    public static final int NumberFormat=55;
    public static final int Or=56;
    public static final int PathDelimiter=57;
    public static final int Pos=58;
    public static final int Processor=59;
    public static final int QuotedField=60;
    public static final int RBracket=61;
    public static final int RECORD=62;
    public static final int RECORDS=63;
    public static final int RParenthesis=64;
    public static final int Remove=65;
    public static final int SUBTYPE=66;
    public static final int Semicolon=67;
    public static final int SpecialAttribute=68;
    public static final int TYPE=69;
    public static final int Translator=70;
    public static final int Unique=71;
    public static final int Update=72;
    public static final int UserRights=73;
    public static final int ValueAssignment=74;
    public static final int Virtual=75;
    public static final int Ws=76;

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
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:21:1: walk returns [List<ImpexNode> blocks] : impex ;
    public final List<ImpexNode> walk() throws RecognitionException {
        List<ImpexNode> blocks = null;


        List<ImpexNode> impex1 =null;


        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:22:2: ( impex )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:22:3: impex
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:24:1: impex returns [List<ImpexNode> blocks] : ^( IMPEX ^( BLOCKS ( block )* ) ) ;
    public final List<ImpexNode> impex() throws RecognitionException {
        List<ImpexNode> blocks = null;


        ImpexNode block2 =null;



        		blocks = new ArrayList<ImpexNode>();
        	
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:28:2: ( ^( IMPEX ^( BLOCKS ( block )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:28:3: ^( IMPEX ^( BLOCKS ( block )* ) )
            {
            match(input,IMPEX,FOLLOW_IMPEX_in_impex65); 

            match(input, Token.DOWN, null); 
            match(input,BLOCKS,FOLLOW_BLOCKS_in_impex69); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:28:21: ( block )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==BLOCK) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:28:22: block
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:30:1: block returns [ImpexNode node] : ^( BLOCK ( header ) ^( RECORDS ( record )+ ) ) ;
    public final ImpexNode block() throws RecognitionException {
        ImpexNode node = null;


        ImpexNode header3 =null;

        ImpexNode record4 =null;


         
         		 BlockNode bn = new BlockNode(); 
         		 node = bn; 
        	
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:35:2: ( ^( BLOCK ( header ) ^( RECORDS ( record )+ ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:35:3: ^( BLOCK ( header ) ^( RECORDS ( record )+ ) )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_block99); 

            match(input, Token.DOWN, null); 
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:35:11: ( header )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:35:12: header
            {
            pushFollow(FOLLOW_header_in_block102);
            header3=header();

            state._fsp--;


            bn.setHeader(header3);

            }


            match(input,RECORDS,FOLLOW_RECORDS_in_block109); 

            match(input, Token.DOWN, null); 
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:36:12: ( record )+
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
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:36:13: record
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:39:1: header returns [ImpexNode node] : ^( HEADER ( headerMode ) ^( TYPE Identifier ) ^( MODIFIERS ( headerModifierAssignment )* ) ^( DOCUMENTID ( DocumentID )? ) ^( ATTRIBUTES ( attribute )* ) ) ;
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:44:2: ( ^( HEADER ( headerMode ) ^( TYPE Identifier ) ^( MODIFIERS ( headerModifierAssignment )* ) ^( DOCUMENTID ( DocumentID )? ) ^( ATTRIBUTES ( attribute )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:44:3: ^( HEADER ( headerMode ) ^( TYPE Identifier ) ^( MODIFIERS ( headerModifierAssignment )* ) ^( DOCUMENTID ( DocumentID )? ) ^( ATTRIBUTES ( attribute )* ) )
            {
            match(input,HEADER,FOLLOW_HEADER_in_header138); 

            match(input, Token.DOWN, null); 
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:44:12: ( headerMode )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:44:13: headerMode
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
                // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:46:14: ( headerModifierAssignment )*
                loop3:
                do {
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==MODIFIER) ) {
                        alt3=1;
                    }


                    switch (alt3) {
                	case 1 :
                	    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:46:15: headerModifierAssignment
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
                // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:47:14: ( DocumentID )?
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==DocumentID) ) {
                    alt4=1;
                }
                switch (alt4) {
                    case 1 :
                        // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:47:15: DocumentID
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
                // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:48:15: ( attribute )*
                loop5:
                do {
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==ATTRIBUTE) ) {
                        alt5=1;
                    }


                    switch (alt5) {
                	case 1 :
                	    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:48:16: attribute
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:51:1: headerModifierAssignment returns [ImpexNode node] : ^( MODIFIER headerModifier boolOrClassname ) ;
    public final ImpexNode headerModifierAssignment() throws RecognitionException {
        ImpexNode node = null;


        int headerModifier10 =0;

        String boolOrClassname11 =null;


        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:52:3: ( ^( MODIFIER headerModifier boolOrClassname ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:52:5: ^( MODIFIER headerModifier boolOrClassname )
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:54:1: boolOrClassname returns [String text] : v= ( Bool | Classname ) ;
    public final String boolOrClassname() throws RecognitionException {
        String text = null;


        CommonTree v=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:55:2: (v= ( Bool | Classname ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:55:3: v= ( Bool | Classname )
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:57:1: headerModifier returns [int modifier] : v= ( BatchMode | CacheUnique | Processor ) ;
    public final int headerModifier() throws RecognitionException {
        int modifier = 0;


        CommonTree v=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:58:2: (v= ( BatchMode | CacheUnique | Processor ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:58:3: v= ( BatchMode | CacheUnique | Processor )
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:60:1: record returns [ImpexNode node] : ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) ) ;
    public final ImpexNode record() throws RecognitionException {
        ImpexNode node = null;


        CommonTree Identifier12=null;
        String field13 =null;



        	    RecordNode rn = new RecordNode(); 
         	    node = rn; 
        	
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:65:5: ( ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:65:7: ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) )
            {
            match(input,RECORD,FOLLOW_RECORD_in_record286); 

            match(input, Token.DOWN, null); 
            match(input,SUBTYPE,FOLLOW_SUBTYPE_in_record294); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:66:15: ( Identifier )?
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==Identifier) ) {
                    alt6=1;
                }
                switch (alt6) {
                    case 1 :
                        // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:66:16: Identifier
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:67:14: ( field )+
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
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:67:15: field
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:70:1: field returns [String text] : v= ( QuotedField | Field ) ;
    public final String field() throws RecognitionException {
        String text = null;


        CommonTree v=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:71:2: (v= ( QuotedField | Field ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:71:3: v= ( QuotedField | Field )
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:74:1: attributeName returns [ImpexNode node] : ^( ATTRIBUTE_NAME ( Macrodef )? ( SpecialAttribute )? ( Identifier (attrName= attributeName )? )? ) ;
    public final ImpexNode attributeName() throws RecognitionException {
        ImpexNode node = null;


        CommonTree Macrodef14=null;
        CommonTree SpecialAttribute15=null;
        CommonTree Identifier16=null;
        ImpexNode attrName =null;



        	    AttributeNameNode ann = new AttributeNameNode(); 
         	    node = ann; 
        	
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:79:2: ( ^( ATTRIBUTE_NAME ( Macrodef )? ( SpecialAttribute )? ( Identifier (attrName= attributeName )? )? ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:79:3: ^( ATTRIBUTE_NAME ( Macrodef )? ( SpecialAttribute )? ( Identifier (attrName= attributeName )? )? )
            {
            match(input,ATTRIBUTE_NAME,FOLLOW_ATTRIBUTE_NAME_in_attributeName370); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:80:2: ( Macrodef )?
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==Macrodef) ) {
                    alt8=1;
                }
                switch (alt8) {
                    case 1 :
                        // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:80:3: Macrodef
                        {
                        Macrodef14=(CommonTree)match(input,Macrodef,FOLLOW_Macrodef_in_attributeName376); 

                        ann.init((Macrodef14!=null?Macrodef14.getText():null), (Macrodef14!=null?Macrodef14.getType():0));

                        }
                        break;

                }


                // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:81:2: ( SpecialAttribute )?
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==SpecialAttribute) ) {
                    alt9=1;
                }
                switch (alt9) {
                    case 1 :
                        // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:81:3: SpecialAttribute
                        {
                        SpecialAttribute15=(CommonTree)match(input,SpecialAttribute,FOLLOW_SpecialAttribute_in_attributeName385); 

                        ann.init((SpecialAttribute15!=null?SpecialAttribute15.getText():null), (SpecialAttribute15!=null?SpecialAttribute15.getType():0));

                        }
                        break;

                }


                // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:82:2: ( Identifier (attrName= attributeName )? )?
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==Identifier) ) {
                    alt11=1;
                }
                switch (alt11) {
                    case 1 :
                        // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:82:3: Identifier (attrName= attributeName )?
                        {
                        Identifier16=(CommonTree)match(input,Identifier,FOLLOW_Identifier_in_attributeName394); 

                        ann.init((Identifier16!=null?Identifier16.getText():null), (Identifier16!=null?Identifier16.getType():0));

                        // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:82:62: (attrName= attributeName )?
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==ATTRIBUTE_NAME) ) {
                            alt10=1;
                        }
                        switch (alt10) {
                            case 1 :
                                // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:82:63: attrName= attributeName
                                {
                                pushFollow(FOLLOW_attributeName_in_attributeName403);
                                attrName=attributeName();

                                state._fsp--;


                                ann.setSubName(attrName);

                                }
                                break;

                        }


                        }
                        break;

                }


                match(input, Token.UP, null); 
            }


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
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:84:1: attribute returns [ImpexNode node] : ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION (attr= attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifierAssignment )* ) ) ;
    public final ImpexNode attribute() throws RecognitionException {
        ImpexNode node = null;


        CommonTree DocumentID18=null;
        ImpexNode attr =null;

        ImpexNode attributeName17 =null;

        ImpexNode attributeModifierAssignment19 =null;



        	    AttributeNode an = new AttributeNode(); 
         	    node = an; 
        	
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:90:2: ( ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION (attr= attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifierAssignment )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:90:3: ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION (attr= attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifierAssignment )* ) )
            {
            match(input,ATTRIBUTE,FOLLOW_ATTRIBUTE_in_attribute431); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_attributeName_in_attribute433);
            attributeName17=attributeName();

            state._fsp--;


            an.setName(attributeName17);

            match(input,ITEM_EXPRESSION,FOLLOW_ITEM_EXPRESSION_in_attribute440); 

            match(input, Token.DOWN, null); 
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:91:21: (attr= attribute )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==ATTRIBUTE) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:91:22: attr= attribute
            	    {
            	    pushFollow(FOLLOW_attribute_in_attribute447);
            	    attr=attribute();

            	    state._fsp--;


            	    an.addAttribute(attr);

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            match(input,DOCUMENTID_REF,FOLLOW_DOCUMENTID_REF_in_attribute457); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:92:20: ( DocumentID )*
                loop13:
                do {
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==DocumentID) ) {
                        alt13=1;
                    }


                    switch (alt13) {
                	case 1 :
                	    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:92:21: DocumentID
                	    {
                	    DocumentID18=(CommonTree)match(input,DocumentID,FOLLOW_DocumentID_in_attribute460); 

                	    an.addAttribute(new RefNode((DocumentID18!=null?DocumentID18.getText():null), (DocumentID18!=null?DocumentID18.getType():0)));

                	    }
                	    break;

                	default :
                	    break loop13;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }


            match(input, Token.UP, null); 


            match(input,MODIFIERS,FOLLOW_MODIFIERS_in_attribute476); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:95:14: ( attributeModifierAssignment )*
                loop14:
                do {
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==MODIFIER) ) {
                        alt14=1;
                    }


                    switch (alt14) {
                	case 1 :
                	    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:95:15: attributeModifierAssignment
                	    {
                	    pushFollow(FOLLOW_attributeModifierAssignment_in_attribute479);
                	    attributeModifierAssignment19=attributeModifierAssignment();

                	    state._fsp--;


                	    an.addModifier(attributeModifierAssignment19);

                	    }
                	    break;

                	default :
                	    break loop14;
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:98:1: attributeModifierAssignment returns [ImpexNode node] : ^( MODIFIER attributeModifier ValueAssignment ) ;
    public final ImpexNode attributeModifierAssignment() throws RecognitionException {
        ImpexNode node = null;


        CommonTree ValueAssignment21=null;
        int attributeModifier20 =0;


        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:99:2: ( ^( MODIFIER attributeModifier ValueAssignment ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:99:4: ^( MODIFIER attributeModifier ValueAssignment )
            {
            match(input,MODIFIER,FOLLOW_MODIFIER_in_attributeModifierAssignment503); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_attributeModifier_in_attributeModifierAssignment505);
            attributeModifier20=attributeModifier();

            state._fsp--;


            ValueAssignment21=(CommonTree)match(input,ValueAssignment,FOLLOW_ValueAssignment_in_attributeModifierAssignment507); 

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
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:101:1: attributeModifier returns [int modifier] : v= ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual ) ;
    public final int attributeModifier() throws RecognitionException {
        int modifier = 0;


        CommonTree v=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:102:2: (v= ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:102:4: v= ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual )
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:105:1: headerMode returns [int mode] : v= ( Insert | InsertUpdate | Update | Remove ) ;
    public final int headerMode() throws RecognitionException {
        int mode = 0;


        CommonTree v=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:106:2: (v= ( Insert | InsertUpdate | Update | Remove ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:106:3: v= ( Insert | InsertUpdate | Update | Remove )
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
    public static final BitSet FOLLOW_header_in_block102 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_RECORDS_in_block109 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_record_in_block112 = new BitSet(new long[]{0x4000000000000008L});
    public static final BitSet FOLLOW_HEADER_in_header138 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_headerMode_in_header141 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_TYPE_in_header148 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_header150 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MODIFIERS_in_header158 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_headerModifierAssignment_in_header161 = new BitSet(new long[]{0x0002000000000008L});
    public static final BitSet FOLLOW_DOCUMENTID_in_header171 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DocumentID_in_header173 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ATTRIBUTES_in_header182 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attribute_in_header185 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_MODIFIER_in_headerModifierAssignment209 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_headerModifier_in_headerModifierAssignment211 = new BitSet(new long[]{0x0000000000044000L});
    public static final BitSet FOLLOW_boolOrClassname_in_headerModifierAssignment213 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_boolOrClassname229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_headerModifier251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RECORD_in_record286 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SUBTYPE_in_record294 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_record297 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELDS_in_record310 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_in_record313 = new BitSet(new long[]{0x1000000080000008L});
    public static final BitSet FOLLOW_set_in_field339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ATTRIBUTE_NAME_in_attributeName370 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Macrodef_in_attributeName376 = new BitSet(new long[]{0x0000004000000008L,0x0000000000000010L});
    public static final BitSet FOLLOW_SpecialAttribute_in_attributeName385 = new BitSet(new long[]{0x0000004000000008L});
    public static final BitSet FOLLOW_Identifier_in_attributeName394 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_attributeName_in_attributeName403 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ATTRIBUTE_in_attribute431 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attributeName_in_attribute433 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_ITEM_EXPRESSION_in_attribute440 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attribute_in_attribute447 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_DOCUMENTID_REF_in_attribute457 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DocumentID_in_attribute460 = new BitSet(new long[]{0x0000000004000008L});
    public static final BitSet FOLLOW_MODIFIERS_in_attribute476 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attributeModifierAssignment_in_attribute479 = new BitSet(new long[]{0x0002000000000008L});
    public static final BitSet FOLLOW_MODIFIER_in_attributeModifierAssignment503 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attributeModifier_in_attributeModifierAssignment505 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_ValueAssignment_in_attributeModifierAssignment507 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_attributeModifier525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_headerMode614 = new BitSet(new long[]{0x0000000000000002L});

}