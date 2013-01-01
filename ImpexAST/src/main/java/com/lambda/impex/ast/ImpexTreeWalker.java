// $ANTLR 3.4 com/lambda/impex/ast/ImpexTreeWalker.g 2013-01-01 08:32:46

package com.lambda.impex.ast;

import java.util.ArrayList;
import java.util.AbstractMap.SimpleImmutableEntry;  
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.lambda.impex.ast.nodes.AttributeNameNode;
import com.lambda.impex.ast.nodes.AttributeNode;
import com.lambda.impex.ast.nodes.BlockNode;
import com.lambda.impex.ast.nodes.HeaderNode;
import com.lambda.impex.ast.nodes.IImpexNode;
import com.lambda.impex.ast.nodes.ImpexNode;
import com.lambda.impex.ast.nodes.ModifierNode;
import com.lambda.impex.ast.nodes.RecordNode;
import com.lambda.impex.ast.nodes.RefNode;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class ImpexTreeWalker extends TreeParser {
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
    public String getGrammarFileName() { return "com/lambda/impex/ast/ImpexTreeWalker.g"; }



    // $ANTLR start "walk"
    // com/lambda/impex/ast/ImpexTreeWalker.g:29:1: walk returns [IImpexNode impex] : impex ;
    public final IImpexNode walk() throws RecognitionException {
        IImpexNode impex = null;


        ImpexNode impex1 =null;


        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:30:2: ( impex )
            // com/lambda/impex/ast/ImpexTreeWalker.g:30:3: impex
            {
            pushFollow(FOLLOW_impex_in_walk45);
            impex1=impex();

            state._fsp--;


            impex = impex1;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }

        finally {
        	// do for sure before leaving
        }
        return impex;
    }
    // $ANTLR end "walk"



    // $ANTLR start "impex"
    // com/lambda/impex/ast/ImpexTreeWalker.g:32:1: impex returns [ImpexNode node] : ^( IMPEX ^( BLOCKS ( block )* ) ) ;
    public final ImpexNode impex() throws RecognitionException {
        ImpexNode node = null;


        IImpexNode block2 =null;



        		ImpexNode in = new ImpexNode();
        		node = in;
        	
        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:37:2: ( ^( IMPEX ^( BLOCKS ( block )* ) ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:37:3: ^( IMPEX ^( BLOCKS ( block )* ) )
            {
            match(input,IMPEX,FOLLOW_IMPEX_in_impex65); 

            match(input, Token.DOWN, null); 
            match(input,BLOCKS,FOLLOW_BLOCKS_in_impex69); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // com/lambda/impex/ast/ImpexTreeWalker.g:37:21: ( block )*
                loop1:
                do {
                    int alt1=2;
                    switch ( input.LA(1) ) {
                    case BLOCK:
                        {
                        alt1=1;
                        }
                        break;

                    }

                    switch (alt1) {
                	case 1 :
                	    // com/lambda/impex/ast/ImpexTreeWalker.g:37:22: block
                	    {
                	    pushFollow(FOLLOW_block_in_impex72);
                	    block2=block();

                	    state._fsp--;


                	    in.addBlock(block2);

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
        return node;
    }
    // $ANTLR end "impex"



    // $ANTLR start "block"
    // com/lambda/impex/ast/ImpexTreeWalker.g:39:1: block returns [IImpexNode node] : ^( BLOCK ( header ) ^( RECORDS ( record )+ ) ) ;
    public final IImpexNode block() throws RecognitionException {
        IImpexNode node = null;


        IImpexNode header3 =null;

        IImpexNode record4 =null;


         
         		 BlockNode bn = new BlockNode(); 
         		 node = bn; 
        	
        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:44:2: ( ^( BLOCK ( header ) ^( RECORDS ( record )+ ) ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:44:3: ^( BLOCK ( header ) ^( RECORDS ( record )+ ) )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_block99); 

            match(input, Token.DOWN, null); 
            // com/lambda/impex/ast/ImpexTreeWalker.g:44:11: ( header )
            // com/lambda/impex/ast/ImpexTreeWalker.g:44:12: header
            {
            pushFollow(FOLLOW_header_in_block102);
            header3=header();

            state._fsp--;


            bn.setHeader(header3);

            }


            match(input,RECORDS,FOLLOW_RECORDS_in_block109); 

            match(input, Token.DOWN, null); 
            // com/lambda/impex/ast/ImpexTreeWalker.g:45:12: ( record )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                switch ( input.LA(1) ) {
                case RECORD:
                    {
                    alt2=1;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // com/lambda/impex/ast/ImpexTreeWalker.g:45:13: record
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
    // com/lambda/impex/ast/ImpexTreeWalker.g:48:1: header returns [IImpexNode node] : ^( HEADER ( headerMode ) ^( TYPE headerTypeName ) ^( MODIFIERS ( headerModifierAssignment )* ) ^( DOCUMENTID ( DocumentID )? ) ^( ATTRIBUTES ( attribute )* ) ) ;
    public final IImpexNode header() throws RecognitionException {
        IImpexNode node = null;


        CommonTree DocumentID8=null;
        Tree headerMode5 =null;

        String headerTypeName6 =null;

        IImpexNode headerModifierAssignment7 =null;

        IImpexNode attribute9 =null;



        		HeaderNode hn = new HeaderNode();
        		node = hn;
        	
        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:53:2: ( ^( HEADER ( headerMode ) ^( TYPE headerTypeName ) ^( MODIFIERS ( headerModifierAssignment )* ) ^( DOCUMENTID ( DocumentID )? ) ^( ATTRIBUTES ( attribute )* ) ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:53:3: ^( HEADER ( headerMode ) ^( TYPE headerTypeName ) ^( MODIFIERS ( headerModifierAssignment )* ) ^( DOCUMENTID ( DocumentID )? ) ^( ATTRIBUTES ( attribute )* ) )
            {
            match(input,HEADER,FOLLOW_HEADER_in_header138); 

            match(input, Token.DOWN, null); 
            // com/lambda/impex/ast/ImpexTreeWalker.g:53:12: ( headerMode )
            // com/lambda/impex/ast/ImpexTreeWalker.g:53:13: headerMode
            {
            pushFollow(FOLLOW_headerMode_in_header141);
            headerMode5=headerMode();

            state._fsp--;


            hn.setMode(headerMode5.getType());

            }


            match(input,TYPE,FOLLOW_TYPE_in_header148); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_headerTypeName_in_header150);
            headerTypeName6=headerTypeName();

            state._fsp--;


            hn.setType(headerTypeName6);

            match(input, Token.UP, null); 


            match(input,MODIFIERS,FOLLOW_MODIFIERS_in_header158); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // com/lambda/impex/ast/ImpexTreeWalker.g:55:14: ( headerModifierAssignment )*
                loop3:
                do {
                    int alt3=2;
                    switch ( input.LA(1) ) {
                    case MODIFIER:
                        {
                        alt3=1;
                        }
                        break;

                    }

                    switch (alt3) {
                	case 1 :
                	    // com/lambda/impex/ast/ImpexTreeWalker.g:55:15: headerModifierAssignment
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
                // com/lambda/impex/ast/ImpexTreeWalker.g:56:14: ( DocumentID )?
                int alt4=2;
                switch ( input.LA(1) ) {
                    case DocumentID:
                        {
                        alt4=1;
                        }
                        break;
                }

                switch (alt4) {
                    case 1 :
                        // com/lambda/impex/ast/ImpexTreeWalker.g:56:15: DocumentID
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
                // com/lambda/impex/ast/ImpexTreeWalker.g:57:15: ( attribute )*
                loop5:
                do {
                    int alt5=2;
                    switch ( input.LA(1) ) {
                    case ATTRIBUTE:
                        {
                        alt5=1;
                        }
                        break;

                    }

                    switch (alt5) {
                	case 1 :
                	    // com/lambda/impex/ast/ImpexTreeWalker.g:57:16: attribute
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
    // com/lambda/impex/ast/ImpexTreeWalker.g:60:1: headerModifierAssignment returns [IImpexNode node] : ^( MODIFIER headerModifier boolOrClassname ) ;
    public final IImpexNode headerModifierAssignment() throws RecognitionException {
        IImpexNode node = null;


        Tree headerModifier10 =null;

        String boolOrClassname11 =null;


        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:61:3: ( ^( MODIFIER headerModifier boolOrClassname ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:61:5: ^( MODIFIER headerModifier boolOrClassname )
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


            node = new ModifierNode(headerModifier10.getType(), boolOrClassname11);

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
    // com/lambda/impex/ast/ImpexTreeWalker.g:63:1: boolOrClassname returns [String text] : v= ( Bool | Classname ) ;
    public final String boolOrClassname() throws RecognitionException {
        String text = null;


        CommonTree v=null;

        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:64:2: (v= ( Bool | Classname ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:64:3: v= ( Bool | Classname )
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
    // com/lambda/impex/ast/ImpexTreeWalker.g:66:1: headerModifier returns [Tree modifier] : v= ( BatchMode | CacheUnique | Processor ) ;
    public final Tree headerModifier() throws RecognitionException {
        Tree modifier = null;


        CommonTree v=null;

        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:67:2: (v= ( BatchMode | CacheUnique | Processor ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:67:3: v= ( BatchMode | CacheUnique | Processor )
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


            modifier = v;

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
    // com/lambda/impex/ast/ImpexTreeWalker.g:69:1: record returns [IImpexNode node] : ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) ) ;
    public final IImpexNode record() throws RecognitionException {
        IImpexNode node = null;


        CommonTree Identifier12=null;
        String field13 =null;



        	    RecordNode rn = new RecordNode(); 
         	    node = rn; 
        	
        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:74:5: ( ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:74:7: ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) )
            {
            match(input,RECORD,FOLLOW_RECORD_in_record286); 

            match(input, Token.DOWN, null); 
            match(input,SUBTYPE,FOLLOW_SUBTYPE_in_record294); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // com/lambda/impex/ast/ImpexTreeWalker.g:75:15: ( Identifier )?
                int alt6=2;
                switch ( input.LA(1) ) {
                    case Identifier:
                        {
                        alt6=1;
                        }
                        break;
                }

                switch (alt6) {
                    case 1 :
                        // com/lambda/impex/ast/ImpexTreeWalker.g:75:16: Identifier
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
            // com/lambda/impex/ast/ImpexTreeWalker.g:76:14: ( field )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                switch ( input.LA(1) ) {
                case Field:
                case QuotedField:
                    {
                    alt7=1;
                    }
                    break;

                }

                switch (alt7) {
            	case 1 :
            	    // com/lambda/impex/ast/ImpexTreeWalker.g:76:15: field
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
    // com/lambda/impex/ast/ImpexTreeWalker.g:79:1: field returns [String text] : v= ( QuotedField | Field ) ;
    public final String field() throws RecognitionException {
        String text = null;


        CommonTree v=null;

        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:80:2: (v= ( QuotedField | Field ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:80:3: v= ( QuotedField | Field )
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
    // com/lambda/impex/ast/ImpexTreeWalker.g:83:1: attributeName returns [IImpexNode node] : ^( ATTRIBUTE_NAME ( Macrodef )? ( SpecialAttribute )? ( Identifier (attrName= attributeName )? )? ) ;
    public final IImpexNode attributeName() throws RecognitionException {
        IImpexNode node = null;


        CommonTree Macrodef14=null;
        CommonTree SpecialAttribute15=null;
        CommonTree Identifier16=null;
        IImpexNode attrName =null;



        	    AttributeNameNode ann = new AttributeNameNode(); 
         	    node = ann; 
        	
        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:88:2: ( ^( ATTRIBUTE_NAME ( Macrodef )? ( SpecialAttribute )? ( Identifier (attrName= attributeName )? )? ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:88:3: ^( ATTRIBUTE_NAME ( Macrodef )? ( SpecialAttribute )? ( Identifier (attrName= attributeName )? )? )
            {
            match(input,ATTRIBUTE_NAME,FOLLOW_ATTRIBUTE_NAME_in_attributeName370); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // com/lambda/impex/ast/ImpexTreeWalker.g:89:2: ( Macrodef )?
                int alt8=2;
                switch ( input.LA(1) ) {
                    case Macrodef:
                        {
                        alt8=1;
                        }
                        break;
                }

                switch (alt8) {
                    case 1 :
                        // com/lambda/impex/ast/ImpexTreeWalker.g:89:3: Macrodef
                        {
                        Macrodef14=(CommonTree)match(input,Macrodef,FOLLOW_Macrodef_in_attributeName376); 

                        ann.init((Macrodef14!=null?Macrodef14.getText():null), (Macrodef14!=null?Macrodef14.getType():0));

                        }
                        break;

                }


                // com/lambda/impex/ast/ImpexTreeWalker.g:90:2: ( SpecialAttribute )?
                int alt9=2;
                switch ( input.LA(1) ) {
                    case SpecialAttribute:
                        {
                        alt9=1;
                        }
                        break;
                }

                switch (alt9) {
                    case 1 :
                        // com/lambda/impex/ast/ImpexTreeWalker.g:90:3: SpecialAttribute
                        {
                        SpecialAttribute15=(CommonTree)match(input,SpecialAttribute,FOLLOW_SpecialAttribute_in_attributeName385); 

                        ann.init((SpecialAttribute15!=null?SpecialAttribute15.getText():null), (SpecialAttribute15!=null?SpecialAttribute15.getType():0));

                        }
                        break;

                }


                // com/lambda/impex/ast/ImpexTreeWalker.g:91:2: ( Identifier (attrName= attributeName )? )?
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
                        // com/lambda/impex/ast/ImpexTreeWalker.g:91:3: Identifier (attrName= attributeName )?
                        {
                        Identifier16=(CommonTree)match(input,Identifier,FOLLOW_Identifier_in_attributeName394); 

                        ann.init((Identifier16!=null?Identifier16.getText():null), (Identifier16!=null?Identifier16.getType():0));

                        // com/lambda/impex/ast/ImpexTreeWalker.g:91:62: (attrName= attributeName )?
                        int alt10=2;
                        switch ( input.LA(1) ) {
                            case ATTRIBUTE_NAME:
                                {
                                alt10=1;
                                }
                                break;
                        }

                        switch (alt10) {
                            case 1 :
                                // com/lambda/impex/ast/ImpexTreeWalker.g:91:63: attrName= attributeName
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
    // com/lambda/impex/ast/ImpexTreeWalker.g:93:1: attribute returns [IImpexNode node] : ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION (attr= attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifierAssignment )* ) ) ;
    public final IImpexNode attribute() throws RecognitionException {
        IImpexNode node = null;


        CommonTree DocumentID18=null;
        IImpexNode attr =null;

        IImpexNode attributeName17 =null;

        IImpexNode attributeModifierAssignment19 =null;



        	    AttributeNode an = new AttributeNode(); 
         	    node = an; 
        	
        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:99:2: ( ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION (attr= attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifierAssignment )* ) ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:99:3: ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION (attr= attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifierAssignment )* ) )
            {
            match(input,ATTRIBUTE,FOLLOW_ATTRIBUTE_in_attribute431); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_attributeName_in_attribute433);
            attributeName17=attributeName();

            state._fsp--;


            an.setName(attributeName17);

            match(input,ITEM_EXPRESSION,FOLLOW_ITEM_EXPRESSION_in_attribute440); 

            match(input, Token.DOWN, null); 
            // com/lambda/impex/ast/ImpexTreeWalker.g:100:21: (attr= attribute )*
            loop12:
            do {
                int alt12=2;
                switch ( input.LA(1) ) {
                case ATTRIBUTE:
                    {
                    alt12=1;
                    }
                    break;

                }

                switch (alt12) {
            	case 1 :
            	    // com/lambda/impex/ast/ImpexTreeWalker.g:100:22: attr= attribute
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
                // com/lambda/impex/ast/ImpexTreeWalker.g:101:20: ( DocumentID )*
                loop13:
                do {
                    int alt13=2;
                    switch ( input.LA(1) ) {
                    case DocumentID:
                        {
                        alt13=1;
                        }
                        break;

                    }

                    switch (alt13) {
                	case 1 :
                	    // com/lambda/impex/ast/ImpexTreeWalker.g:101:21: DocumentID
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
                // com/lambda/impex/ast/ImpexTreeWalker.g:104:14: ( attributeModifierAssignment )*
                loop14:
                do {
                    int alt14=2;
                    switch ( input.LA(1) ) {
                    case MODIFIER:
                        {
                        alt14=1;
                        }
                        break;

                    }

                    switch (alt14) {
                	case 1 :
                	    // com/lambda/impex/ast/ImpexTreeWalker.g:104:15: attributeModifierAssignment
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
    // com/lambda/impex/ast/ImpexTreeWalker.g:107:1: attributeModifierAssignment returns [IImpexNode node] : ^( MODIFIER attributeModifier ValueAssignment ) ;
    public final IImpexNode attributeModifierAssignment() throws RecognitionException {
        IImpexNode node = null;


        CommonTree ValueAssignment21=null;
        Tree attributeModifier20 =null;


        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:108:2: ( ^( MODIFIER attributeModifier ValueAssignment ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:108:4: ^( MODIFIER attributeModifier ValueAssignment )
            {
            match(input,MODIFIER,FOLLOW_MODIFIER_in_attributeModifierAssignment503); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_attributeModifier_in_attributeModifierAssignment505);
            attributeModifier20=attributeModifier();

            state._fsp--;


            ValueAssignment21=(CommonTree)match(input,ValueAssignment,FOLLOW_ValueAssignment_in_attributeModifierAssignment507); 

            match(input, Token.UP, null); 


            node = new ModifierNode(attributeModifier20.getType(), (ValueAssignment21!=null?ValueAssignment21.getText():null));

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
    // com/lambda/impex/ast/ImpexTreeWalker.g:110:1: attributeModifier returns [Tree modifier] : v= ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual ) ;
    public final Tree attributeModifier() throws RecognitionException {
        Tree modifier = null;


        CommonTree v=null;

        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:111:2: (v= ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:111:4: v= ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual )
            {
            v=(CommonTree)input.LT(1);

            if ( (input.LA(1) >= Alias && input.LA(1) <= AllowNull)||input.LA(1)==CellDecorator||input.LA(1)==CollectionDelimiter||(input.LA(1) >= Dateformat && input.LA(1) <= Default)||input.LA(1)==ForceWrite||(input.LA(1) >= IgnoreKeyCase && input.LA(1) <= IgnoreNull)||input.LA(1)==KeyToValueDelimiter||input.LA(1)==Lang||(input.LA(1) >= MapDelimiter && input.LA(1) <= NumberFormat)||(input.LA(1) >= PathDelimiter && input.LA(1) <= Pos)||(input.LA(1) >= Translator && input.LA(1) <= Unique)||input.LA(1)==Virtual ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            modifier = v;

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
    // com/lambda/impex/ast/ImpexTreeWalker.g:114:1: headerMode returns [Tree mode] : v= ( Insert | InsertUpdate | Update | Remove ) ;
    public final Tree headerMode() throws RecognitionException {
        Tree mode = null;


        CommonTree v=null;

        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:115:2: (v= ( Insert | InsertUpdate | Update | Remove ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:115:3: v= ( Insert | InsertUpdate | Update | Remove )
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


            mode = v;

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



    // $ANTLR start "headerTypeName"
    // com/lambda/impex/ast/ImpexTreeWalker.g:117:1: headerTypeName returns [String text] : ( Identifier | headerMode | attributeModifier | headerModifier );
    public final String headerTypeName() throws RecognitionException {
        String text = null;


        CommonTree Identifier22=null;
        Tree headerMode23 =null;

        Tree attributeModifier24 =null;

        Tree headerModifier25 =null;


        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:118:2: ( Identifier | headerMode | attributeModifier | headerModifier )
            int alt15=4;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                alt15=1;
                }
                break;
            case Insert:
            case InsertUpdate:
            case Remove:
            case Update:
                {
                alt15=2;
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
                alt15=3;
                }
                break;
            case BatchMode:
            case CacheUnique:
            case Processor:
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
                    // com/lambda/impex/ast/ImpexTreeWalker.g:118:4: Identifier
                    {
                    Identifier22=(CommonTree)match(input,Identifier,FOLLOW_Identifier_in_headerTypeName643); 

                    text = (Identifier22!=null?Identifier22.getText():null);

                    }
                    break;
                case 2 :
                    // com/lambda/impex/ast/ImpexTreeWalker.g:119:3: headerMode
                    {
                    pushFollow(FOLLOW_headerMode_in_headerTypeName649);
                    headerMode23=headerMode();

                    state._fsp--;


                    text = headerMode23.getText();

                    }
                    break;
                case 3 :
                    // com/lambda/impex/ast/ImpexTreeWalker.g:120:3: attributeModifier
                    {
                    pushFollow(FOLLOW_attributeModifier_in_headerTypeName655);
                    attributeModifier24=attributeModifier();

                    state._fsp--;


                    text = attributeModifier24.getText();

                    }
                    break;
                case 4 :
                    // com/lambda/impex/ast/ImpexTreeWalker.g:121:3: headerModifier
                    {
                    pushFollow(FOLLOW_headerModifier_in_headerTypeName661);
                    headerModifier25=headerModifier();

                    state._fsp--;


                    text = headerModifier25.getText();

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
        return text;
    }
    // $ANTLR end "headerTypeName"

    // Delegated rules


 

    public static final BitSet FOLLOW_impex_in_walk45 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPEX_in_impex65 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BLOCKS_in_impex69 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_impex72 = new BitSet(new long[]{0x0000000000000208L});
    public static final BitSet FOLLOW_BLOCK_in_block99 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_header_in_block102 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_RECORDS_in_block109 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_record_in_block112 = new BitSet(new long[]{0x0400000000000008L});
    public static final BitSet FOLLOW_HEADER_in_header138 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_headerMode_in_header141 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_TYPE_in_header148 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_headerTypeName_in_header150 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MODIFIERS_in_header158 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_headerModifierAssignment_in_header161 = new BitSet(new long[]{0x0000400000000008L});
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
    public static final BitSet FOLLOW_field_in_record313 = new BitSet(new long[]{0x0100000040000008L});
    public static final BitSet FOLLOW_set_in_field339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ATTRIBUTE_NAME_in_attributeName370 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Macrodef_in_attributeName376 = new BitSet(new long[]{0x0000000800000008L,0x0000000000000002L});
    public static final BitSet FOLLOW_SpecialAttribute_in_attributeName385 = new BitSet(new long[]{0x0000000800000008L});
    public static final BitSet FOLLOW_Identifier_in_attributeName394 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_attributeName_in_attributeName403 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ATTRIBUTE_in_attribute431 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attributeName_in_attribute433 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_ITEM_EXPRESSION_in_attribute440 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attribute_in_attribute447 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_DOCUMENTID_REF_in_attribute457 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DocumentID_in_attribute460 = new BitSet(new long[]{0x0000000002000008L});
    public static final BitSet FOLLOW_MODIFIERS_in_attribute476 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attributeModifierAssignment_in_attribute479 = new BitSet(new long[]{0x0000400000000008L});
    public static final BitSet FOLLOW_MODIFIER_in_attributeModifierAssignment503 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attributeModifier_in_attributeModifierAssignment505 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_ValueAssignment_in_attributeModifierAssignment507 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_attributeModifier525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_headerMode614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_headerTypeName643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_headerMode_in_headerTypeName649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeModifier_in_headerTypeName655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_headerModifier_in_headerTypeName661 = new BitSet(new long[]{0x0000000000000002L});

}