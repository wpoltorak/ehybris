// $ANTLR 3.4 com/lambda/impex/ast/ImpexTreeWalker.g 2013-01-17 17:55:47

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
import com.lambda.impex.ast.nodes.ImpexASTNode;
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
    // com/lambda/impex/ast/ImpexTreeWalker.g:29:1: walk[ImpexContext context] returns [ImpexASTNode impex] : impex[context] ;
    public final ImpexASTNode walk(ImpexContext context) throws RecognitionException {
        ImpexASTNode impex = null;


        ImpexNode impex1 =null;


        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:30:2: ( impex[context] )
            // com/lambda/impex/ast/ImpexTreeWalker.g:30:3: impex[context]
            {
            pushFollow(FOLLOW_impex_in_walk47);
            impex1=impex(context);

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
    // com/lambda/impex/ast/ImpexTreeWalker.g:32:1: impex[ImpexContext context] returns [ImpexNode node] : ^( IMPEX ^( BLOCKS ( block[context] )* ) ) ;
    public final ImpexNode impex(ImpexContext context) throws RecognitionException {
        ImpexNode node = null;


        ImpexASTNode block2 =null;



        		ImpexNode in = new ImpexNode();
        		node = in;
        	
        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:37:2: ( ^( IMPEX ^( BLOCKS ( block[context] )* ) ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:37:3: ^( IMPEX ^( BLOCKS ( block[context] )* ) )
            {
            match(input,IMPEX,FOLLOW_IMPEX_in_impex71); 

            match(input, Token.DOWN, null); 
            match(input,BLOCKS,FOLLOW_BLOCKS_in_impex75); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // com/lambda/impex/ast/ImpexTreeWalker.g:37:21: ( block[context] )*
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
                	    // com/lambda/impex/ast/ImpexTreeWalker.g:37:22: block[context]
                	    {
                	    pushFollow(FOLLOW_block_in_impex78);
                	    block2=block(context);

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
    // com/lambda/impex/ast/ImpexTreeWalker.g:39:1: block[ImpexContext context] returns [ImpexASTNode node] : ^( BLOCK ( header[context] ) ^( RECORDS ( record[context] )* ) ) ;
    public final ImpexASTNode block(ImpexContext context) throws RecognitionException {
        ImpexASTNode node = null;


        ImpexASTNode header3 =null;

        ImpexASTNode record4 =null;


         
        		ImpexASTNode header;
        		List<ImpexASTNode> records = new ArrayList<ImpexASTNode>();
        	
        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:48:2: ( ^( BLOCK ( header[context] ) ^( RECORDS ( record[context] )* ) ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:48:3: ^( BLOCK ( header[context] ) ^( RECORDS ( record[context] )* ) )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_block115); 

            match(input, Token.DOWN, null); 
            // com/lambda/impex/ast/ImpexTreeWalker.g:48:11: ( header[context] )
            // com/lambda/impex/ast/ImpexTreeWalker.g:48:12: header[context]
            {
            pushFollow(FOLLOW_header_in_block118);
            header3=header(context);

            state._fsp--;


            header = header3;

            }


            match(input,RECORDS,FOLLOW_RECORDS_in_block127); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // com/lambda/impex/ast/ImpexTreeWalker.g:49:12: ( record[context] )*
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
                	    // com/lambda/impex/ast/ImpexTreeWalker.g:49:13: record[context]
                	    {
                	    pushFollow(FOLLOW_record_in_block130);
                	    record4=record(context);

                	    state._fsp--;


                	    records.add(record4);

                	    }
                	    break;

                	default :
                	    break loop2;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }


            match(input, Token.UP, null); 


            }


             		 node = new BlockNode(header, records); 
            	
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
    // com/lambda/impex/ast/ImpexTreeWalker.g:52:1: header[ImpexContext context] returns [ImpexASTNode node] : ^( HEADER ( headerMode ) ^( TYPE headerTypeName ) ^( MODIFIERS ( headerModifierAssignment[context] )* ) ^( DOCUMENTID ( DocumentID )? ) ^( ATTRIBUTES ( attribute[context] )* ) ) ;
    public final ImpexASTNode header(ImpexContext context) throws RecognitionException {
        ImpexASTNode node = null;


        CommonTree DocumentID8=null;
        CommonTree headerMode5 =null;

        CommonToken headerTypeName6 =null;

        ImpexASTNode headerModifierAssignment7 =null;

        ImpexASTNode attribute9 =null;



        		CommonToken mode;
        		CommonToken type;
        		CommonToken documentID = null;
        		List<ImpexASTNode> modifiers = new ArrayList<ImpexASTNode>();
        		List<ImpexASTNode> attributes = new ArrayList<ImpexASTNode>();
        	
        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:63:2: ( ^( HEADER ( headerMode ) ^( TYPE headerTypeName ) ^( MODIFIERS ( headerModifierAssignment[context] )* ) ^( DOCUMENTID ( DocumentID )? ) ^( ATTRIBUTES ( attribute[context] )* ) ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:63:3: ^( HEADER ( headerMode ) ^( TYPE headerTypeName ) ^( MODIFIERS ( headerModifierAssignment[context] )* ) ^( DOCUMENTID ( DocumentID )? ) ^( ATTRIBUTES ( attribute[context] )* ) )
            {
            match(input,HEADER,FOLLOW_HEADER_in_header165); 

            match(input, Token.DOWN, null); 
            // com/lambda/impex/ast/ImpexTreeWalker.g:63:12: ( headerMode )
            // com/lambda/impex/ast/ImpexTreeWalker.g:63:13: headerMode
            {
            pushFollow(FOLLOW_headerMode_in_header168);
            headerMode5=headerMode();

            state._fsp--;


            mode = (CommonToken)headerMode5.getToken();

            }


            match(input,TYPE,FOLLOW_TYPE_in_header175); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_headerTypeName_in_header177);
            headerTypeName6=headerTypeName();

            state._fsp--;


            type = (CommonToken)headerTypeName6;

            match(input, Token.UP, null); 


            match(input,MODIFIERS,FOLLOW_MODIFIERS_in_header185); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // com/lambda/impex/ast/ImpexTreeWalker.g:65:14: ( headerModifierAssignment[context] )*
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
                	    // com/lambda/impex/ast/ImpexTreeWalker.g:65:15: headerModifierAssignment[context]
                	    {
                	    pushFollow(FOLLOW_headerModifierAssignment_in_header188);
                	    headerModifierAssignment7=headerModifierAssignment(context);

                	    state._fsp--;


                	    modifiers.add(headerModifierAssignment7);

                	    }
                	    break;

                	default :
                	    break loop3;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }


            match(input,DOCUMENTID,FOLLOW_DOCUMENTID_in_header200); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // com/lambda/impex/ast/ImpexTreeWalker.g:66:14: ( DocumentID )?
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
                        // com/lambda/impex/ast/ImpexTreeWalker.g:66:15: DocumentID
                        {
                        DocumentID8=(CommonTree)match(input,DocumentID,FOLLOW_DocumentID_in_header202); 

                        documentID = (CommonToken)DocumentID8.token;

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }


            match(input,ATTRIBUTES,FOLLOW_ATTRIBUTES_in_header211); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // com/lambda/impex/ast/ImpexTreeWalker.g:67:15: ( attribute[context] )*
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
                	    // com/lambda/impex/ast/ImpexTreeWalker.g:67:16: attribute[context]
                	    {
                	    pushFollow(FOLLOW_attribute_in_header214);
                	    attribute9=attribute(context);

                	    state._fsp--;


                	    attributes.add(attribute9);

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


            		node = new HeaderNode(mode, type, documentID, modifiers, attributes);
            	
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
    // com/lambda/impex/ast/ImpexTreeWalker.g:70:1: headerModifierAssignment[ImpexContext context] returns [ImpexASTNode node] : ^( MODIFIER headerModifier ValueAssignment ) ;
    public final ImpexASTNode headerModifierAssignment(ImpexContext context) throws RecognitionException {
        ImpexASTNode node = null;


        CommonTree ValueAssignment11=null;
        CommonTree headerModifier10 =null;


        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:71:3: ( ^( MODIFIER headerModifier ValueAssignment ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:71:5: ^( MODIFIER headerModifier ValueAssignment )
            {
            match(input,MODIFIER,FOLLOW_MODIFIER_in_headerModifierAssignment242); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_headerModifier_in_headerModifierAssignment244);
            headerModifier10=headerModifier();

            state._fsp--;


            ValueAssignment11=(CommonTree)match(input,ValueAssignment,FOLLOW_ValueAssignment_in_headerModifierAssignment246); 

            match(input, Token.UP, null); 


            node = new ModifierNode(headerModifier10.getType(), (CommonToken)ValueAssignment11.token);

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



    // $ANTLR start "headerModifier"
    // com/lambda/impex/ast/ImpexTreeWalker.g:73:1: headerModifier returns [CommonTree modifier] : v= ( BatchMode | CacheUnique | Processor ) ;
    public final CommonTree headerModifier() throws RecognitionException {
        CommonTree modifier = null;


        CommonTree v=null;

        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:74:2: (v= ( BatchMode | CacheUnique | Processor ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:74:3: v= ( BatchMode | CacheUnique | Processor )
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
    // com/lambda/impex/ast/ImpexTreeWalker.g:76:1: record[ImpexContext context] returns [ImpexASTNode node] : ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field[context] )+ ) ) ;
    public final ImpexASTNode record(ImpexContext context) throws RecognitionException {
        ImpexASTNode node = null;


        CommonTree Identifier12=null;
        String field13 =null;



        	    RecordNode rn = new RecordNode(); 
         	    node = rn; 
        	
        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:81:5: ( ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field[context] )+ ) ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:81:7: ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field[context] )+ ) )
            {
            match(input,RECORD,FOLLOW_RECORD_in_record299); 

            match(input, Token.DOWN, null); 
            match(input,SUBTYPE,FOLLOW_SUBTYPE_in_record307); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // com/lambda/impex/ast/ImpexTreeWalker.g:82:15: ( Identifier )?
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
                        // com/lambda/impex/ast/ImpexTreeWalker.g:82:16: Identifier
                        {
                        Identifier12=(CommonTree)match(input,Identifier,FOLLOW_Identifier_in_record310); 

                        rn.setSubType((Identifier12!=null?Identifier12.getText():null));

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }


            match(input,FIELDS,FOLLOW_FIELDS_in_record323); 

            match(input, Token.DOWN, null); 
            // com/lambda/impex/ast/ImpexTreeWalker.g:83:14: ( field[context] )+
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
            	    // com/lambda/impex/ast/ImpexTreeWalker.g:83:15: field[context]
            	    {
            	    pushFollow(FOLLOW_field_in_record326);
            	    field13=field(context);

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
    // com/lambda/impex/ast/ImpexTreeWalker.g:86:1: field[ImpexContext context] returns [String text] : v= ( QuotedField | Field ) ;
    public final String field(ImpexContext context) throws RecognitionException {
        String text = null;


        CommonTree v=null;

        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:87:2: (v= ( QuotedField | Field ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:87:3: v= ( QuotedField | Field )
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
    // com/lambda/impex/ast/ImpexTreeWalker.g:90:1: attributeName[ImpexContext context] returns [ImpexASTNode node] : ^( ATTRIBUTE_NAME ( Macrodef )? ( SpecialAttribute )? ( Identifier (attrName= attributeName[context] )? )? ) ;
    public final ImpexASTNode attributeName(ImpexContext context) throws RecognitionException {
        ImpexASTNode node = null;


        CommonTree Macrodef14=null;
        CommonTree SpecialAttribute15=null;
        CommonTree Identifier16=null;
        ImpexASTNode attrName =null;



        	    AttributeNameNode ann = new AttributeNameNode(); 
         	    node = ann; 
        	
        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:95:2: ( ^( ATTRIBUTE_NAME ( Macrodef )? ( SpecialAttribute )? ( Identifier (attrName= attributeName[context] )? )? ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:95:3: ^( ATTRIBUTE_NAME ( Macrodef )? ( SpecialAttribute )? ( Identifier (attrName= attributeName[context] )? )? )
            {
            match(input,ATTRIBUTE_NAME,FOLLOW_ATTRIBUTE_NAME_in_attributeName387); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // com/lambda/impex/ast/ImpexTreeWalker.g:96:2: ( Macrodef )?
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
                        // com/lambda/impex/ast/ImpexTreeWalker.g:96:3: Macrodef
                        {
                        Macrodef14=(CommonTree)match(input,Macrodef,FOLLOW_Macrodef_in_attributeName393); 

                        ann.init((CommonToken)Macrodef14.token);

                        }
                        break;

                }


                // com/lambda/impex/ast/ImpexTreeWalker.g:97:2: ( SpecialAttribute )?
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
                        // com/lambda/impex/ast/ImpexTreeWalker.g:97:3: SpecialAttribute
                        {
                        SpecialAttribute15=(CommonTree)match(input,SpecialAttribute,FOLLOW_SpecialAttribute_in_attributeName402); 

                        ann.init((CommonToken)SpecialAttribute15.token);

                        }
                        break;

                }


                // com/lambda/impex/ast/ImpexTreeWalker.g:98:2: ( Identifier (attrName= attributeName[context] )? )?
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
                        // com/lambda/impex/ast/ImpexTreeWalker.g:98:3: Identifier (attrName= attributeName[context] )?
                        {
                        Identifier16=(CommonTree)match(input,Identifier,FOLLOW_Identifier_in_attributeName411); 

                        ann.init((CommonToken)Identifier16.token);

                        // com/lambda/impex/ast/ImpexTreeWalker.g:98:58: (attrName= attributeName[context] )?
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
                                // com/lambda/impex/ast/ImpexTreeWalker.g:98:59: attrName= attributeName[context]
                                {
                                pushFollow(FOLLOW_attributeName_in_attributeName420);
                                attrName=attributeName(context);

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
    // com/lambda/impex/ast/ImpexTreeWalker.g:100:1: attribute[ImpexContext context] returns [ImpexASTNode node] : ^( ATTRIBUTE attributeName[context] ^( ITEM_EXPRESSION (attr= attribute[context] )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifierAssignment[context] )* ) ) ;
    public final ImpexASTNode attribute(ImpexContext context) throws RecognitionException {
        ImpexASTNode node = null;


        CommonTree DocumentID18=null;
        ImpexASTNode attr =null;

        ImpexASTNode attributeName17 =null;

        ImpexASTNode attributeModifierAssignment19 =null;



        	    AttributeNode an = new AttributeNode(); 
         	    node = an; 
        	
        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:106:2: ( ^( ATTRIBUTE attributeName[context] ^( ITEM_EXPRESSION (attr= attribute[context] )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifierAssignment[context] )* ) ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:106:3: ^( ATTRIBUTE attributeName[context] ^( ITEM_EXPRESSION (attr= attribute[context] )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifierAssignment[context] )* ) )
            {
            match(input,ATTRIBUTE,FOLLOW_ATTRIBUTE_in_attribute450); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_attributeName_in_attribute452);
            attributeName17=attributeName(context);

            state._fsp--;


            an.setName(attributeName17);

            match(input,ITEM_EXPRESSION,FOLLOW_ITEM_EXPRESSION_in_attribute461); 

            match(input, Token.DOWN, null); 
            // com/lambda/impex/ast/ImpexTreeWalker.g:107:21: (attr= attribute[context] )*
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
            	    // com/lambda/impex/ast/ImpexTreeWalker.g:107:22: attr= attribute[context]
            	    {
            	    pushFollow(FOLLOW_attribute_in_attribute468);
            	    attr=attribute(context);

            	    state._fsp--;


            	    an.addAttribute(attr);

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);


            match(input,DOCUMENTID_REF,FOLLOW_DOCUMENTID_REF_in_attribute479); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // com/lambda/impex/ast/ImpexTreeWalker.g:108:20: ( DocumentID )*
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
                	    // com/lambda/impex/ast/ImpexTreeWalker.g:108:21: DocumentID
                	    {
                	    DocumentID18=(CommonTree)match(input,DocumentID,FOLLOW_DocumentID_in_attribute482); 

                	    an.addAttribute(new RefNode((CommonToken)DocumentID18.token));

                	    }
                	    break;

                	default :
                	    break loop13;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }


            match(input, Token.UP, null); 


            match(input,MODIFIERS,FOLLOW_MODIFIERS_in_attribute498); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // com/lambda/impex/ast/ImpexTreeWalker.g:111:14: ( attributeModifierAssignment[context] )*
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
                	    // com/lambda/impex/ast/ImpexTreeWalker.g:111:15: attributeModifierAssignment[context]
                	    {
                	    pushFollow(FOLLOW_attributeModifierAssignment_in_attribute501);
                	    attributeModifierAssignment19=attributeModifierAssignment(context);

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
    // com/lambda/impex/ast/ImpexTreeWalker.g:114:1: attributeModifierAssignment[ImpexContext context] returns [ImpexASTNode node] : ^( MODIFIER attributeModifier ValueAssignment ) ;
    public final ImpexASTNode attributeModifierAssignment(ImpexContext context) throws RecognitionException {
        ImpexASTNode node = null;


        CommonTree ValueAssignment21=null;
        CommonTree attributeModifier20 =null;


        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:115:2: ( ^( MODIFIER attributeModifier ValueAssignment ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:115:4: ^( MODIFIER attributeModifier ValueAssignment )
            {
            match(input,MODIFIER,FOLLOW_MODIFIER_in_attributeModifierAssignment528); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_attributeModifier_in_attributeModifierAssignment530);
            attributeModifier20=attributeModifier();

            state._fsp--;


            ValueAssignment21=(CommonTree)match(input,ValueAssignment,FOLLOW_ValueAssignment_in_attributeModifierAssignment532); 

            match(input, Token.UP, null); 


            node = new ModifierNode(attributeModifier20.getType(), (CommonToken)ValueAssignment21.token);

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
    // com/lambda/impex/ast/ImpexTreeWalker.g:117:1: attributeModifier returns [CommonTree modifier] : v= ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual ) ;
    public final CommonTree attributeModifier() throws RecognitionException {
        CommonTree modifier = null;


        CommonTree v=null;

        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:118:2: (v= ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:118:4: v= ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual )
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
    // com/lambda/impex/ast/ImpexTreeWalker.g:121:1: headerMode returns [CommonTree mode] : v= ( Insert | InsertUpdate | Update | Remove ) ;
    public final CommonTree headerMode() throws RecognitionException {
        CommonTree mode = null;


        CommonTree v=null;

        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:122:2: (v= ( Insert | InsertUpdate | Update | Remove ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:122:3: v= ( Insert | InsertUpdate | Update | Remove )
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
    // com/lambda/impex/ast/ImpexTreeWalker.g:124:1: headerTypeName returns [CommonToken type] : ( Identifier | headerMode | attributeModifier | headerModifier );
    public final CommonToken headerTypeName() throws RecognitionException {
        CommonToken type = null;


        CommonTree Identifier22=null;
        CommonTree headerMode23 =null;

        CommonTree attributeModifier24 =null;

        CommonTree headerModifier25 =null;


        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:125:2: ( Identifier | headerMode | attributeModifier | headerModifier )
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
                    // com/lambda/impex/ast/ImpexTreeWalker.g:125:4: Identifier
                    {
                    Identifier22=(CommonTree)match(input,Identifier,FOLLOW_Identifier_in_headerTypeName671); 

                    type = (CommonToken)Identifier22.token;

                    }
                    break;
                case 2 :
                    // com/lambda/impex/ast/ImpexTreeWalker.g:126:3: headerMode
                    {
                    pushFollow(FOLLOW_headerMode_in_headerTypeName677);
                    headerMode23=headerMode();

                    state._fsp--;


                    type = (CommonToken)headerMode23.getToken();

                    }
                    break;
                case 3 :
                    // com/lambda/impex/ast/ImpexTreeWalker.g:127:3: attributeModifier
                    {
                    pushFollow(FOLLOW_attributeModifier_in_headerTypeName683);
                    attributeModifier24=attributeModifier();

                    state._fsp--;


                    type = (CommonToken)attributeModifier24.getToken();

                    }
                    break;
                case 4 :
                    // com/lambda/impex/ast/ImpexTreeWalker.g:128:3: headerModifier
                    {
                    pushFollow(FOLLOW_headerModifier_in_headerTypeName689);
                    headerModifier25=headerModifier();

                    state._fsp--;


                    type = (CommonToken)headerModifier25.getToken();

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
        return type;
    }
    // $ANTLR end "headerTypeName"

    // Delegated rules


 

    public static final BitSet FOLLOW_impex_in_walk47 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPEX_in_impex71 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BLOCKS_in_impex75 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_impex78 = new BitSet(new long[]{0x0000000000000208L});
    public static final BitSet FOLLOW_BLOCK_in_block115 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_header_in_block118 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_RECORDS_in_block127 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_record_in_block130 = new BitSet(new long[]{0x0800000000000008L});
    public static final BitSet FOLLOW_HEADER_in_header165 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_headerMode_in_header168 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_TYPE_in_header175 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_headerTypeName_in_header177 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MODIFIERS_in_header185 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_headerModifierAssignment_in_header188 = new BitSet(new long[]{0x0000400000000008L});
    public static final BitSet FOLLOW_DOCUMENTID_in_header200 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DocumentID_in_header202 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ATTRIBUTES_in_header211 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attribute_in_header214 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_MODIFIER_in_headerModifierAssignment242 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_headerModifier_in_headerModifierAssignment244 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ValueAssignment_in_headerModifierAssignment246 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_headerModifier263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RECORD_in_record299 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SUBTYPE_in_record307 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_record310 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELDS_in_record323 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_in_record326 = new BitSet(new long[]{0x0200000040000008L});
    public static final BitSet FOLLOW_set_in_field356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ATTRIBUTE_NAME_in_attributeName387 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Macrodef_in_attributeName393 = new BitSet(new long[]{0x0000000800000008L,0x0000000000000004L});
    public static final BitSet FOLLOW_SpecialAttribute_in_attributeName402 = new BitSet(new long[]{0x0000000800000008L});
    public static final BitSet FOLLOW_Identifier_in_attributeName411 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_attributeName_in_attributeName420 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ATTRIBUTE_in_attribute450 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attributeName_in_attribute452 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_ITEM_EXPRESSION_in_attribute461 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attribute_in_attribute468 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_DOCUMENTID_REF_in_attribute479 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DocumentID_in_attribute482 = new BitSet(new long[]{0x0000000002000008L});
    public static final BitSet FOLLOW_MODIFIERS_in_attribute498 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attributeModifierAssignment_in_attribute501 = new BitSet(new long[]{0x0000400000000008L});
    public static final BitSet FOLLOW_MODIFIER_in_attributeModifierAssignment528 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attributeModifier_in_attributeModifierAssignment530 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ValueAssignment_in_attributeModifierAssignment532 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_attributeModifier551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_headerMode641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_headerTypeName671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_headerMode_in_headerTypeName677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeModifier_in_headerTypeName683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_headerModifier_in_headerTypeName689 = new BitSet(new long[]{0x0000000000000002L});

}