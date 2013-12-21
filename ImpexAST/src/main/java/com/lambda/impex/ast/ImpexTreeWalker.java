// $ANTLR 3.4 com/lambda/impex/ast/ImpexTreeWalker.g 2013-02-04 22:08:43

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
import com.lambda.impex.ast.nodes.FieldNode;
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


    protected ImpexContext context;

    public ImpexTreeWalker(ImpexContext context, CommonTree ast){
    this(new CommonTreeNodeStream(ast));
    this.context = context;
    }



    // $ANTLR start "walk"
    // com/lambda/impex/ast/ImpexTreeWalker.g:39:1: walk returns [ImpexASTNode impex] : impex ;
    public final ImpexASTNode walk() throws RecognitionException {
        ImpexASTNode impex = null;


        ImpexNode impex1 =null;


        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:40:2: ( impex )
            // com/lambda/impex/ast/ImpexTreeWalker.g:40:3: impex
            {
            pushFollow(FOLLOW_impex_in_walk51);
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
    // com/lambda/impex/ast/ImpexTreeWalker.g:42:1: impex returns [ImpexNode node] : ^( IMPEX ^( BLOCKS ( block )* ) ) ;
    public final ImpexNode impex() throws RecognitionException {
        ImpexNode node = null;


        ImpexASTNode block2 =null;



        		ImpexNode in = new ImpexNode();
        		node = in;
        	
        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:47:2: ( ^( IMPEX ^( BLOCKS ( block )* ) ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:47:3: ^( IMPEX ^( BLOCKS ( block )* ) )
            {
            match(input,IMPEX,FOLLOW_IMPEX_in_impex71); 

            match(input, Token.DOWN, null); 
            match(input,BLOCKS,FOLLOW_BLOCKS_in_impex75); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // com/lambda/impex/ast/ImpexTreeWalker.g:47:21: ( block )*
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
                	    // com/lambda/impex/ast/ImpexTreeWalker.g:47:22: block
                	    {
                	    pushFollow(FOLLOW_block_in_impex78);
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
    // com/lambda/impex/ast/ImpexTreeWalker.g:49:1: block returns [ImpexASTNode node] : ^( BLOCK ( header ) ^( RECORDS ( record[$header.node] )* ) ) ;
    public final ImpexASTNode block() throws RecognitionException {
        ImpexASTNode node = null;


        HeaderNode header3 =null;

        ImpexASTNode record4 =null;


         
        		ImpexASTNode header;
        		List<ImpexASTNode> records = new ArrayList<ImpexASTNode>();
        	
        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:58:2: ( ^( BLOCK ( header ) ^( RECORDS ( record[$header.node] )* ) ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:58:3: ^( BLOCK ( header ) ^( RECORDS ( record[$header.node] )* ) )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_block111); 

            match(input, Token.DOWN, null); 
            // com/lambda/impex/ast/ImpexTreeWalker.g:58:11: ( header )
            // com/lambda/impex/ast/ImpexTreeWalker.g:58:12: header
            {
            pushFollow(FOLLOW_header_in_block114);
            header3=header();

            state._fsp--;


            header = header3;

            }


            match(input,RECORDS,FOLLOW_RECORDS_in_block121); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // com/lambda/impex/ast/ImpexTreeWalker.g:59:12: ( record[$header.node] )*
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
                	    // com/lambda/impex/ast/ImpexTreeWalker.g:59:13: record[$header.node]
                	    {
                	    pushFollow(FOLLOW_record_in_block124);
                	    record4=record(header3);

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
    // com/lambda/impex/ast/ImpexTreeWalker.g:62:1: header returns [HeaderNode node] : ^( HEADER ( headerMode ) ^( TYPE headerTypeName ) ^( MODIFIERS ( headerModifierAssignment )* ) ^( ATTRIBUTES ( attributeValue )* ) ) ;
    public final HeaderNode header() throws RecognitionException {
        HeaderNode node = null;


        CommonTree headerMode5 =null;

        CommonToken headerTypeName6 =null;

        ImpexASTNode headerModifierAssignment7 =null;

        ImpexASTNode attributeValue8 =null;



        		CommonToken mode;
        		CommonToken type;
        		List<ImpexASTNode> modifiers = new ArrayList<ImpexASTNode>();
        		List<ImpexASTNode> attributes = new ArrayList<ImpexASTNode>();
        	
        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:72:2: ( ^( HEADER ( headerMode ) ^( TYPE headerTypeName ) ^( MODIFIERS ( headerModifierAssignment )* ) ^( ATTRIBUTES ( attributeValue )* ) ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:72:3: ^( HEADER ( headerMode ) ^( TYPE headerTypeName ) ^( MODIFIERS ( headerModifierAssignment )* ) ^( ATTRIBUTES ( attributeValue )* ) )
            {
            match(input,HEADER,FOLLOW_HEADER_in_header156); 

            match(input, Token.DOWN, null); 
            // com/lambda/impex/ast/ImpexTreeWalker.g:72:12: ( headerMode )
            // com/lambda/impex/ast/ImpexTreeWalker.g:72:13: headerMode
            {
            pushFollow(FOLLOW_headerMode_in_header159);
            headerMode5=headerMode();

            state._fsp--;


            mode = (CommonToken)headerMode5.getToken();

            }


            match(input,TYPE,FOLLOW_TYPE_in_header166); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_headerTypeName_in_header168);
            headerTypeName6=headerTypeName();

            state._fsp--;


            type = (CommonToken)headerTypeName6;

            match(input, Token.UP, null); 


            match(input,MODIFIERS,FOLLOW_MODIFIERS_in_header176); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // com/lambda/impex/ast/ImpexTreeWalker.g:74:14: ( headerModifierAssignment )*
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
                	    // com/lambda/impex/ast/ImpexTreeWalker.g:74:15: headerModifierAssignment
                	    {
                	    pushFollow(FOLLOW_headerModifierAssignment_in_header179);
                	    headerModifierAssignment7=headerModifierAssignment();

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


            match(input,ATTRIBUTES,FOLLOW_ATTRIBUTES_in_header189); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // com/lambda/impex/ast/ImpexTreeWalker.g:75:15: ( attributeValue )*
                loop4:
                do {
                    int alt4=2;
                    switch ( input.LA(1) ) {
                    case ATTRIBUTE:
                        {
                        alt4=1;
                        }
                        break;

                    }

                    switch (alt4) {
                	case 1 :
                	    // com/lambda/impex/ast/ImpexTreeWalker.g:75:16: attributeValue
                	    {
                	    pushFollow(FOLLOW_attributeValue_in_header192);
                	    attributeValue8=attributeValue();

                	    state._fsp--;


                	    attributes.add(attributeValue8);

                	    }
                	    break;

                	default :
                	    break loop4;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }


            match(input, Token.UP, null); 


            }


            		node = new HeaderNode(mode, type,  modifiers, attributes);
            	
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
    // com/lambda/impex/ast/ImpexTreeWalker.g:78:1: headerModifierAssignment returns [ImpexASTNode node] : ^( MODIFIER headerModifier ValueAssignment ) ;
    public final ImpexASTNode headerModifierAssignment() throws RecognitionException {
        ImpexASTNode node = null;


        CommonTree ValueAssignment10=null;
        CommonTree headerModifier9 =null;


        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:79:3: ( ^( MODIFIER headerModifier ValueAssignment ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:79:5: ^( MODIFIER headerModifier ValueAssignment )
            {
            match(input,MODIFIER,FOLLOW_MODIFIER_in_headerModifierAssignment216); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_headerModifier_in_headerModifierAssignment218);
            headerModifier9=headerModifier();

            state._fsp--;


            ValueAssignment10=(CommonTree)match(input,ValueAssignment,FOLLOW_ValueAssignment_in_headerModifierAssignment220); 

            match(input, Token.UP, null); 


            node = new ModifierNode((CommonToken)headerModifier9.getToken(), (CommonToken)ValueAssignment10.token);

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
    // com/lambda/impex/ast/ImpexTreeWalker.g:81:1: headerModifier returns [CommonTree modifier] : v= ( BatchMode | CacheUnique | Processor ) ;
    public final CommonTree headerModifier() throws RecognitionException {
        CommonTree modifier = null;


        CommonTree v=null;

        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:82:2: (v= ( BatchMode | CacheUnique | Processor ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:82:3: v= ( BatchMode | CacheUnique | Processor )
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
    // com/lambda/impex/ast/ImpexTreeWalker.g:84:1: record[HeaderNode header] returns [ImpexASTNode node] : ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) ) ;
    public final ImpexASTNode record(HeaderNode header) throws RecognitionException {
        ImpexASTNode node = null;


        CommonTree Identifier11=null;
        ImpexASTNode field12 =null;



        	    CommonToken subType = null;
        	    List<ImpexASTNode> fields = new ArrayList<ImpexASTNode>();
        	
        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:92:5: ( ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:92:7: ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( field )+ ) )
            {
            match(input,RECORD,FOLLOW_RECORD_in_record278); 

            match(input, Token.DOWN, null); 
            match(input,SUBTYPE,FOLLOW_SUBTYPE_in_record286); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // com/lambda/impex/ast/ImpexTreeWalker.g:93:15: ( Identifier )?
                int alt5=2;
                switch ( input.LA(1) ) {
                    case Identifier:
                        {
                        alt5=1;
                        }
                        break;
                }

                switch (alt5) {
                    case 1 :
                        // com/lambda/impex/ast/ImpexTreeWalker.g:93:16: Identifier
                        {
                        Identifier11=(CommonTree)match(input,Identifier,FOLLOW_Identifier_in_record289); 

                        subType = (CommonToken)Identifier11.token;

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }


            match(input,FIELDS,FOLLOW_FIELDS_in_record302); 

            match(input, Token.DOWN, null); 
            // com/lambda/impex/ast/ImpexTreeWalker.g:94:14: ( field )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                switch ( input.LA(1) ) {
                case Field:
                case QuotedField:
                    {
                    alt6=1;
                    }
                    break;

                }

                switch (alt6) {
            	case 1 :
            	    // com/lambda/impex/ast/ImpexTreeWalker.g:94:15: field
            	    {
            	    pushFollow(FOLLOW_field_in_record305);
            	    field12=field();

            	    state._fsp--;


            	    fields.add(field12);

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


            match(input, Token.UP, null); 


            match(input, Token.UP, null); 


            }


             	    node = new RecordNode(subType, fields); 
            	
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
    // com/lambda/impex/ast/ImpexTreeWalker.g:97:1: field returns [ImpexASTNode node] : v= ( QuotedField | Field ) ;
    public final ImpexASTNode field() throws RecognitionException {
        ImpexASTNode node = null;


        CommonTree v=null;

        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:98:2: (v= ( QuotedField | Field ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:98:3: v= ( QuotedField | Field )
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


            node = new FieldNode((CommonToken)v.token);

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
    // $ANTLR end "field"



    // $ANTLR start "attributeName"
    // com/lambda/impex/ast/ImpexTreeWalker.g:100:1: attributeName returns [ImpexASTNode node] : ^( ATTRIBUTE_NAME ( Macrodef )? ( SpecialAttribute )? ( Identifier (attrName= attributeName )? )? ) ;
    public final ImpexASTNode attributeName() throws RecognitionException {
        ImpexASTNode node = null;


        CommonTree Macrodef13=null;
        CommonTree SpecialAttribute14=null;
        CommonTree Identifier15=null;
        ImpexASTNode attrName =null;



        	    ImpexASTNode subName = null;
        	    //can be null if blank attribute
         	    CommonToken name = null;
        	
        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:111:2: ( ^( ATTRIBUTE_NAME ( Macrodef )? ( SpecialAttribute )? ( Identifier (attrName= attributeName )? )? ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:111:3: ^( ATTRIBUTE_NAME ( Macrodef )? ( SpecialAttribute )? ( Identifier (attrName= attributeName )? )? )
            {
            match(input,ATTRIBUTE_NAME,FOLLOW_ATTRIBUTE_NAME_in_attributeName365); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // com/lambda/impex/ast/ImpexTreeWalker.g:112:2: ( Macrodef )?
                int alt7=2;
                switch ( input.LA(1) ) {
                    case Macrodef:
                        {
                        alt7=1;
                        }
                        break;
                }

                switch (alt7) {
                    case 1 :
                        // com/lambda/impex/ast/ImpexTreeWalker.g:112:3: Macrodef
                        {
                        Macrodef13=(CommonTree)match(input,Macrodef,FOLLOW_Macrodef_in_attributeName371); 

                        name = (CommonToken)Macrodef13.token;

                        }
                        break;

                }


                // com/lambda/impex/ast/ImpexTreeWalker.g:113:2: ( SpecialAttribute )?
                int alt8=2;
                switch ( input.LA(1) ) {
                    case SpecialAttribute:
                        {
                        alt8=1;
                        }
                        break;
                }

                switch (alt8) {
                    case 1 :
                        // com/lambda/impex/ast/ImpexTreeWalker.g:113:3: SpecialAttribute
                        {
                        SpecialAttribute14=(CommonTree)match(input,SpecialAttribute,FOLLOW_SpecialAttribute_in_attributeName380); 

                        name = (CommonToken)SpecialAttribute14.token;

                        }
                        break;

                }


                // com/lambda/impex/ast/ImpexTreeWalker.g:114:2: ( Identifier (attrName= attributeName )? )?
                int alt10=2;
                switch ( input.LA(1) ) {
                    case Identifier:
                        {
                        alt10=1;
                        }
                        break;
                }

                switch (alt10) {
                    case 1 :
                        // com/lambda/impex/ast/ImpexTreeWalker.g:114:3: Identifier (attrName= attributeName )?
                        {
                        Identifier15=(CommonTree)match(input,Identifier,FOLLOW_Identifier_in_attributeName389); 

                        name = (CommonToken)Identifier15.token;

                        // com/lambda/impex/ast/ImpexTreeWalker.g:114:55: (attrName= attributeName )?
                        int alt9=2;
                        switch ( input.LA(1) ) {
                            case ATTRIBUTE_NAME:
                                {
                                alt9=1;
                                }
                                break;
                        }

                        switch (alt9) {
                            case 1 :
                                // com/lambda/impex/ast/ImpexTreeWalker.g:114:56: attrName= attributeName
                                {
                                pushFollow(FOLLOW_attributeName_in_attributeName398);
                                attrName=attributeName();

                                state._fsp--;


                                subName = attrName;

                                }
                                break;

                        }


                        }
                        break;

                }


                match(input, Token.UP, null); 
            }


            }


            	    node = new AttributeNameNode(name, subName);
            	
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



    // $ANTLR start "attributeValue"
    // com/lambda/impex/ast/ImpexTreeWalker.g:116:1: attributeValue returns [ImpexASTNode node] : ^( ATTRIBUTE ( DocumentID )? ( attributeName ^( ITEM_EXPRESSION (attr= attributeValue )* ) ^( MODIFIERS ( attributeModifierAssignment )* ) )? ) ;
    public final ImpexASTNode attributeValue() throws RecognitionException {
        ImpexASTNode node = null;


        CommonTree DocumentID16=null;
        ImpexASTNode attr =null;

        ImpexASTNode attributeName17 =null;

        ImpexASTNode attributeModifierAssignment18 =null;



        	    //will never be null
         	    ImpexASTNode name = null;
         	    List<ImpexASTNode> expression = new ArrayList<ImpexASTNode>();
         	    List<ImpexASTNode> modifiers = new ArrayList<ImpexASTNode>();
        	
        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:128:2: ( ^( ATTRIBUTE ( DocumentID )? ( attributeName ^( ITEM_EXPRESSION (attr= attributeValue )* ) ^( MODIFIERS ( attributeModifierAssignment )* ) )? ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:128:3: ^( ATTRIBUTE ( DocumentID )? ( attributeName ^( ITEM_EXPRESSION (attr= attributeValue )* ) ^( MODIFIERS ( attributeModifierAssignment )* ) )? )
            {
            match(input,ATTRIBUTE,FOLLOW_ATTRIBUTE_in_attributeValue432); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // com/lambda/impex/ast/ImpexTreeWalker.g:128:15: ( DocumentID )?
                int alt11=2;
                switch ( input.LA(1) ) {
                    case DocumentID:
                        {
                        alt11=1;
                        }
                        break;
                }

                switch (alt11) {
                    case 1 :
                        // com/lambda/impex/ast/ImpexTreeWalker.g:128:16: DocumentID
                        {
                        DocumentID16=(CommonTree)match(input,DocumentID,FOLLOW_DocumentID_in_attributeValue435); 

                        name = new RefNode((CommonToken)DocumentID16.token);

                        }
                        break;

                }


                // com/lambda/impex/ast/ImpexTreeWalker.g:129:2: ( attributeName ^( ITEM_EXPRESSION (attr= attributeValue )* ) ^( MODIFIERS ( attributeModifierAssignment )* ) )?
                int alt14=2;
                switch ( input.LA(1) ) {
                    case ATTRIBUTE_NAME:
                        {
                        alt14=1;
                        }
                        break;
                }

                switch (alt14) {
                    case 1 :
                        // com/lambda/impex/ast/ImpexTreeWalker.g:129:3: attributeName ^( ITEM_EXPRESSION (attr= attributeValue )* ) ^( MODIFIERS ( attributeModifierAssignment )* )
                        {
                        pushFollow(FOLLOW_attributeName_in_attributeValue443);
                        attributeName17=attributeName();

                        state._fsp--;


                        name = attributeName17;

                        match(input,ITEM_EXPRESSION,FOLLOW_ITEM_EXPRESSION_in_attributeValue448); 

                        if ( input.LA(1)==Token.DOWN ) {
                            match(input, Token.DOWN, null); 
                            // com/lambda/impex/ast/ImpexTreeWalker.g:129:65: (attr= attributeValue )*
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
                            	    // com/lambda/impex/ast/ImpexTreeWalker.g:129:66: attr= attributeValue
                            	    {
                            	    pushFollow(FOLLOW_attributeValue_in_attributeValue455);
                            	    attr=attributeValue();

                            	    state._fsp--;


                            	    expression.add(attr);

                            	    }
                            	    break;

                            	default :
                            	    break loop12;
                                }
                            } while (true);


                            match(input, Token.UP, null); 
                        }


                        match(input,MODIFIERS,FOLLOW_MODIFIERS_in_attributeValue464); 

                        if ( input.LA(1)==Token.DOWN ) {
                            match(input, Token.DOWN, null); 
                            // com/lambda/impex/ast/ImpexTreeWalker.g:129:134: ( attributeModifierAssignment )*
                            loop13:
                            do {
                                int alt13=2;
                                switch ( input.LA(1) ) {
                                case MODIFIER:
                                    {
                                    alt13=1;
                                    }
                                    break;

                                }

                                switch (alt13) {
                            	case 1 :
                            	    // com/lambda/impex/ast/ImpexTreeWalker.g:129:135: attributeModifierAssignment
                            	    {
                            	    pushFollow(FOLLOW_attributeModifierAssignment_in_attributeValue467);
                            	    attributeModifierAssignment18=attributeModifierAssignment();

                            	    state._fsp--;


                            	    modifiers.add(attributeModifierAssignment18);

                            	    }
                            	    break;

                            	default :
                            	    break loop13;
                                }
                            } while (true);


                            match(input, Token.UP, null); 
                        }


                        }
                        break;

                }


                match(input, Token.UP, null); 
            }


            }


            	   node = new AttributeNode(name,  expression, modifiers); 
            	
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
    // $ANTLR end "attributeValue"



    // $ANTLR start "attributeModifierAssignment"
    // com/lambda/impex/ast/ImpexTreeWalker.g:132:1: attributeModifierAssignment returns [ImpexASTNode node] : ^( MODIFIER attributeModifier ValueAssignment ) ;
    public final ImpexASTNode attributeModifierAssignment() throws RecognitionException {
        ImpexASTNode node = null;


        CommonTree ValueAssignment20=null;
        CommonTree attributeModifier19 =null;


        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:133:2: ( ^( MODIFIER attributeModifier ValueAssignment ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:133:4: ^( MODIFIER attributeModifier ValueAssignment )
            {
            match(input,MODIFIER,FOLLOW_MODIFIER_in_attributeModifierAssignment493); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_attributeModifier_in_attributeModifierAssignment495);
            attributeModifier19=attributeModifier();

            state._fsp--;


            ValueAssignment20=(CommonTree)match(input,ValueAssignment,FOLLOW_ValueAssignment_in_attributeModifierAssignment497); 

            match(input, Token.UP, null); 


            node = new ModifierNode((CommonToken)attributeModifier19.getToken(), (CommonToken)ValueAssignment20.token);

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
    // com/lambda/impex/ast/ImpexTreeWalker.g:135:1: attributeModifier returns [CommonTree modifier] : v= ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual ) ;
    public final CommonTree attributeModifier() throws RecognitionException {
        CommonTree modifier = null;


        CommonTree v=null;

        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:136:2: (v= ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:136:4: v= ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual )
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
    // com/lambda/impex/ast/ImpexTreeWalker.g:139:1: headerMode returns [CommonTree mode] : v= ( Insert | InsertUpdate | Update | Remove ) ;
    public final CommonTree headerMode() throws RecognitionException {
        CommonTree mode = null;


        CommonTree v=null;

        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:140:2: (v= ( Insert | InsertUpdate | Update | Remove ) )
            // com/lambda/impex/ast/ImpexTreeWalker.g:140:3: v= ( Insert | InsertUpdate | Update | Remove )
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
    // com/lambda/impex/ast/ImpexTreeWalker.g:142:1: headerTypeName returns [CommonToken type] : ( Identifier | headerMode | attributeModifier | headerModifier );
    public final CommonToken headerTypeName() throws RecognitionException {
        CommonToken type = null;


        CommonTree Identifier21=null;
        CommonTree headerMode22 =null;

        CommonTree attributeModifier23 =null;

        CommonTree headerModifier24 =null;


        try {
            // com/lambda/impex/ast/ImpexTreeWalker.g:143:2: ( Identifier | headerMode | attributeModifier | headerModifier )
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
                    // com/lambda/impex/ast/ImpexTreeWalker.g:143:4: Identifier
                    {
                    Identifier21=(CommonTree)match(input,Identifier,FOLLOW_Identifier_in_headerTypeName636); 

                    type = (CommonToken)Identifier21.token;

                    }
                    break;
                case 2 :
                    // com/lambda/impex/ast/ImpexTreeWalker.g:144:3: headerMode
                    {
                    pushFollow(FOLLOW_headerMode_in_headerTypeName642);
                    headerMode22=headerMode();

                    state._fsp--;


                    type = (CommonToken)headerMode22.getToken();

                    }
                    break;
                case 3 :
                    // com/lambda/impex/ast/ImpexTreeWalker.g:145:3: attributeModifier
                    {
                    pushFollow(FOLLOW_attributeModifier_in_headerTypeName648);
                    attributeModifier23=attributeModifier();

                    state._fsp--;


                    type = (CommonToken)attributeModifier23.getToken();

                    }
                    break;
                case 4 :
                    // com/lambda/impex/ast/ImpexTreeWalker.g:146:3: headerModifier
                    {
                    pushFollow(FOLLOW_headerModifier_in_headerTypeName654);
                    headerModifier24=headerModifier();

                    state._fsp--;


                    type = (CommonToken)headerModifier24.getToken();

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


 

    public static final BitSet FOLLOW_impex_in_walk51 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPEX_in_impex71 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_BLOCKS_in_impex75 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_impex78 = new BitSet(new long[]{0x0000000000000208L});
    public static final BitSet FOLLOW_BLOCK_in_block111 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_header_in_block114 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_RECORDS_in_block121 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_record_in_block124 = new BitSet(new long[]{0x0080000000000008L});
    public static final BitSet FOLLOW_HEADER_in_header156 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_headerMode_in_header159 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_TYPE_in_header166 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_headerTypeName_in_header168 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MODIFIERS_in_header176 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_headerModifierAssignment_in_header179 = new BitSet(new long[]{0x0000040000000008L});
    public static final BitSet FOLLOW_ATTRIBUTES_in_header189 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attributeValue_in_header192 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_MODIFIER_in_headerModifierAssignment216 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_headerModifier_in_headerModifierAssignment218 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ValueAssignment_in_headerModifierAssignment220 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_headerModifier237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RECORD_in_record278 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SUBTYPE_in_record286 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_record289 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELDS_in_record302 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_field_in_record305 = new BitSet(new long[]{0x0020000004000008L});
    public static final BitSet FOLLOW_set_in_field331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ATTRIBUTE_NAME_in_attributeName365 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Macrodef_in_attributeName371 = new BitSet(new long[]{0x4000000080000008L});
    public static final BitSet FOLLOW_SpecialAttribute_in_attributeName380 = new BitSet(new long[]{0x0000000080000008L});
    public static final BitSet FOLLOW_Identifier_in_attributeName389 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_attributeName_in_attributeName398 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ATTRIBUTE_in_attributeValue432 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DocumentID_in_attributeValue435 = new BitSet(new long[]{0x0000000000000048L});
    public static final BitSet FOLLOW_attributeName_in_attributeValue443 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ITEM_EXPRESSION_in_attributeValue448 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attributeValue_in_attributeValue455 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_MODIFIERS_in_attributeValue464 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attributeModifierAssignment_in_attributeValue467 = new BitSet(new long[]{0x0000040000000008L});
    public static final BitSet FOLLOW_MODIFIER_in_attributeModifierAssignment493 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attributeModifier_in_attributeModifierAssignment495 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_ValueAssignment_in_attributeModifierAssignment497 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_set_in_attributeModifier516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_headerMode606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_headerTypeName636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_headerMode_in_headerTypeName642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attributeModifier_in_headerTypeName648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_headerModifier_in_headerTypeName654 = new BitSet(new long[]{0x0000000000000002L});

}