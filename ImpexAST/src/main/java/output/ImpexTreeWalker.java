// $ANTLR 3.4 /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g 2012-12-02 10:56:04

package output;

import output.tree.ImpexNode;
import output.tree.MacroNode;


import org.antlr.runtime.*;
import org.antlr.runtime.tree.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class ImpexTreeWalker extends TreeParser {
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
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:15:1: walk returns [ImpexNode node] : impex ;
    public final ImpexNode walk() throws RecognitionException {
        ImpexNode node = null;


        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:16:2: ( impex )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:16:3: impex
            {
            pushFollow(FOLLOW_impex_in_walk45);
            impex();

            state._fsp--;


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
    // $ANTLR end "walk"



    // $ANTLR start "impex"
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:18:1: impex returns [ImpexNode node] : ^( IMPEX ^( MACROS ( macro )* ) ^( BLOCKS ( block )* ) ) ;
    public final ImpexNode impex() throws RecognitionException {
        ImpexNode node = null;


        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:19:2: ( ^( IMPEX ^( MACROS ( macro )* ) ^( BLOCKS ( block )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:19:3: ^( IMPEX ^( MACROS ( macro )* ) ^( BLOCKS ( block )* ) )
            {
            match(input,IMPEX,FOLLOW_IMPEX_in_impex58); 

            match(input, Token.DOWN, null); 
            match(input,MACROS,FOLLOW_MACROS_in_impex61); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:19:20: ( macro )*
                loop1:
                do {
                    int alt1=2;
                    int LA1_0 = input.LA(1);

                    if ( (LA1_0==MACRO) ) {
                        alt1=1;
                    }


                    switch (alt1) {
                	case 1 :
                	    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:19:20: macro
                	    {
                	    pushFollow(FOLLOW_macro_in_impex63);
                	    macro();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop1;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }


            match(input,BLOCKS,FOLLOW_BLOCKS_in_impex69); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:19:38: ( block )*
                loop2:
                do {
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==BLOCK) ) {
                        alt2=1;
                    }


                    switch (alt2) {
                	case 1 :
                	    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:19:38: block
                	    {
                	    pushFollow(FOLLOW_block_in_impex71);
                	    block();

                	    state._fsp--;


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
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:21:1: block returns [ImpexNode node] : ^( BLOCK header ^( RECORDS ( record )+ ) ) ;
    public final ImpexNode block() throws RecognitionException {
        ImpexNode node = null;


        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:22:2: ( ^( BLOCK header ^( RECORDS ( record )+ ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:22:3: ^( BLOCK header ^( RECORDS ( record )+ ) )
            {
            match(input,BLOCK,FOLLOW_BLOCK_in_block87); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_header_in_block89);
            header();

            state._fsp--;


            match(input,RECORDS,FOLLOW_RECORDS_in_block92); 

            match(input, Token.DOWN, null); 
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:22:28: ( record )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RECORD) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:22:28: record
            	    {
            	    pushFollow(FOLLOW_record_in_block94);
            	    record();

            	    state._fsp--;


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
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:24:1: header returns [ImpexNode node] : ^( HEADER headerMode ^( TYPE Identifier ) ^( MODIFIERS ( headerModifiers )? ) ^( DOCUMENTID ( DocumentID )? ) ^( ATTRIBUTES ( attribute )* ) ) ;
    public final ImpexNode header() throws RecognitionException {
        ImpexNode node = null;


        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:25:2: ( ^( HEADER headerMode ^( TYPE Identifier ) ^( MODIFIERS ( headerModifiers )? ) ^( DOCUMENTID ( DocumentID )? ) ^( ATTRIBUTES ( attribute )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:25:3: ^( HEADER headerMode ^( TYPE Identifier ) ^( MODIFIERS ( headerModifiers )? ) ^( DOCUMENTID ( DocumentID )? ) ^( ATTRIBUTES ( attribute )* ) )
            {
            match(input,HEADER,FOLLOW_HEADER_in_header110); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_headerMode_in_header112);
            headerMode();

            state._fsp--;


            match(input,TYPE,FOLLOW_TYPE_in_header115); 

            match(input, Token.DOWN, null); 
            match(input,Identifier,FOLLOW_Identifier_in_header117); 

            match(input, Token.UP, null); 


            match(input,MODIFIERS,FOLLOW_MODIFIERS_in_header121); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:25:54: ( headerModifiers )?
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==MODIFIERS) ) {
                    alt4=1;
                }
                switch (alt4) {
                    case 1 :
                        // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:25:54: headerModifiers
                        {
                        pushFollow(FOLLOW_headerModifiers_in_header123);
                        headerModifiers();

                        state._fsp--;


                        }
                        break;

                }


                match(input, Token.UP, null); 
            }


            match(input,DOCUMENTID,FOLLOW_DOCUMENTID_in_header128); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:25:85: ( DocumentID )?
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==DocumentID) ) {
                    alt5=1;
                }
                switch (alt5) {
                    case 1 :
                        // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:25:85: DocumentID
                        {
                        match(input,DocumentID,FOLLOW_DocumentID_in_header130); 

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }


            match(input,ATTRIBUTES,FOLLOW_ATTRIBUTES_in_header135); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:25:111: ( attribute )*
                loop6:
                do {
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==ATTRIBUTE) ) {
                        alt6=1;
                    }


                    switch (alt6) {
                	case 1 :
                	    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:25:111: attribute
                	    {
                	    pushFollow(FOLLOW_attribute_in_header137);
                	    attribute();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop6;
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



    // $ANTLR start "headerModifiers"
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:27:1: headerModifiers returns [ImpexNode node] : ^( MODIFIERS ( headerModifierAssignment )+ ) ;
    public final ImpexNode headerModifiers() throws RecognitionException {
        ImpexNode node = null;


        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:28:2: ( ^( MODIFIERS ( headerModifierAssignment )+ ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:28:4: ^( MODIFIERS ( headerModifierAssignment )+ )
            {
            match(input,MODIFIERS,FOLLOW_MODIFIERS_in_headerModifiers156); 

            match(input, Token.DOWN, null); 
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:28:16: ( headerModifierAssignment )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==MODIFIER) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:28:16: headerModifierAssignment
            	    {
            	    pushFollow(FOLLOW_headerModifierAssignment_in_headerModifiers158);
            	    headerModifierAssignment();

            	    state._fsp--;


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
    // $ANTLR end "headerModifiers"



    // $ANTLR start "headerModifierAssignment"
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:30:1: headerModifierAssignment returns [ImpexNode node] : ^( MODIFIER headerModifier boolOrClassname ) ;
    public final ImpexNode headerModifierAssignment() throws RecognitionException {
        ImpexNode node = null;


        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:31:3: ( ^( MODIFIER headerModifier boolOrClassname ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:31:5: ^( MODIFIER headerModifier boolOrClassname )
            {
            match(input,MODIFIER,FOLLOW_MODIFIER_in_headerModifierAssignment176); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_headerModifier_in_headerModifierAssignment178);
            headerModifier();

            state._fsp--;


            pushFollow(FOLLOW_boolOrClassname_in_headerModifierAssignment180);
            boolOrClassname();

            state._fsp--;


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
    // $ANTLR end "headerModifierAssignment"



    // $ANTLR start "boolOrClassname"
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:33:1: boolOrClassname : ( Bool | Classname );
    public final void boolOrClassname() throws RecognitionException {
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:34:2: ( Bool | Classname )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:
            {
            if ( input.LA(1)==Bool||input.LA(1)==Classname ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
        return ;
    }
    // $ANTLR end "boolOrClassname"



    // $ANTLR start "headerModifier"
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:36:1: headerModifier : ( BatchMode | CacheUnique | Processor );
    public final void headerModifier() throws RecognitionException {
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:37:2: ( BatchMode | CacheUnique | Processor )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:
            {
            if ( input.LA(1)==BatchMode||input.LA(1)==CacheUnique||input.LA(1)==Processor ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
        return ;
    }
    // $ANTLR end "headerModifier"



    // $ANTLR start "record"
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:40:1: record returns [ImpexNode node] : ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( QuotedField )* ( Field )* ) ) ;
    public final ImpexNode record() throws RecognitionException {
        ImpexNode node = null;


        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:41:5: ( ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( QuotedField )* ( Field )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:41:7: ^( RECORD ^( SUBTYPE ( Identifier )? ) ^( FIELDS ( QuotedField )* ( Field )* ) )
            {
            match(input,RECORD,FOLLOW_RECORD_in_record229); 

            match(input, Token.DOWN, null); 
            match(input,SUBTYPE,FOLLOW_SUBTYPE_in_record232); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:41:26: ( Identifier )?
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==Identifier) ) {
                    alt8=1;
                }
                switch (alt8) {
                    case 1 :
                        // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:41:26: Identifier
                        {
                        match(input,Identifier,FOLLOW_Identifier_in_record234); 

                        }
                        break;

                }


                match(input, Token.UP, null); 
            }


            match(input,FIELDS,FOLLOW_FIELDS_in_record239); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:41:48: ( QuotedField )*
                loop9:
                do {
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==QuotedField) ) {
                        alt9=1;
                    }


                    switch (alt9) {
                	case 1 :
                	    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:41:48: QuotedField
                	    {
                	    match(input,QuotedField,FOLLOW_QuotedField_in_record241); 

                	    }
                	    break;

                	default :
                	    break loop9;
                    }
                } while (true);


                // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:41:61: ( Field )*
                loop10:
                do {
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==Field) ) {
                        alt10=1;
                    }


                    switch (alt10) {
                	case 1 :
                	    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:41:61: Field
                	    {
                	    match(input,Field,FOLLOW_Field_in_record244); 

                	    }
                	    break;

                	default :
                	    break loop10;
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
    // $ANTLR end "record"



    // $ANTLR start "attributeModifiers"
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:62:1: attributeModifiers returns [ImpexNode node] : ^( MODIFIERS ( attributeModifierAssignment )+ ) ;
    public final ImpexNode attributeModifiers() throws RecognitionException {
        ImpexNode node = null;


        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:63:2: ( ^( MODIFIERS ( attributeModifierAssignment )+ ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:63:4: ^( MODIFIERS ( attributeModifierAssignment )+ )
            {
            match(input,MODIFIERS,FOLLOW_MODIFIERS_in_attributeModifiers284); 

            match(input, Token.DOWN, null); 
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:63:16: ( attributeModifierAssignment )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==MODIFIER) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:63:16: attributeModifierAssignment
            	    {
            	    pushFollow(FOLLOW_attributeModifierAssignment_in_attributeModifiers286);
            	    attributeModifierAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


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
    // $ANTLR end "attributeModifiers"



    // $ANTLR start "attributeModifierAssignment"
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:65:1: attributeModifierAssignment returns [ImpexNode node] : ^( MODIFIER attributeModifier ValueAssignement ) ;
    public final ImpexNode attributeModifierAssignment() throws RecognitionException {
        ImpexNode node = null;


        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:66:2: ( ^( MODIFIER attributeModifier ValueAssignement ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:66:4: ^( MODIFIER attributeModifier ValueAssignement )
            {
            match(input,MODIFIER,FOLLOW_MODIFIER_in_attributeModifierAssignment303); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_attributeModifier_in_attributeModifierAssignment305);
            attributeModifier();

            state._fsp--;


            match(input,ValueAssignement,FOLLOW_ValueAssignement_in_attributeModifierAssignment307); 

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
    // $ANTLR end "attributeModifierAssignment"



    // $ANTLR start "attributeName"
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:72:1: attributeName returns [ImpexNode node] : ( ^( MACRO_REF Macrodef ) | ^( ATTRIBUTE_NAME SpecialAttribute ) | ^( ATTRIBUTE_NAME Identifier ( attributeName )? ) );
    public final ImpexNode attributeName() throws RecognitionException {
        ImpexNode node = null;


        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:73:2: ( ^( MACRO_REF Macrodef ) | ^( ATTRIBUTE_NAME SpecialAttribute ) | ^( ATTRIBUTE_NAME Identifier ( attributeName )? ) )
            int alt13=3;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==MACRO_REF) ) {
                alt13=1;
            }
            else if ( (LA13_0==ATTRIBUTE_NAME) ) {
                int LA13_2 = input.LA(2);

                if ( (LA13_2==DOWN) ) {
                    int LA13_3 = input.LA(3);

                    if ( (LA13_3==SpecialAttribute) ) {
                        alt13=2;
                    }
                    else if ( (LA13_3==Identifier) ) {
                        alt13=3;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 3, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 2, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }
            switch (alt13) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:73:3: ^( MACRO_REF Macrodef )
                    {
                    match(input,MACRO_REF,FOLLOW_MACRO_REF_in_attributeName328); 

                    match(input, Token.DOWN, null); 
                    match(input,Macrodef,FOLLOW_Macrodef_in_attributeName331); 

                    match(input, Token.UP, null); 


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:74:4: ^( ATTRIBUTE_NAME SpecialAttribute )
                    {
                    match(input,ATTRIBUTE_NAME,FOLLOW_ATTRIBUTE_NAME_in_attributeName338); 

                    match(input, Token.DOWN, null); 
                    match(input,SpecialAttribute,FOLLOW_SpecialAttribute_in_attributeName340); 

                    match(input, Token.UP, null); 


                    }
                    break;
                case 3 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:75:3: ^( ATTRIBUTE_NAME Identifier ( attributeName )? )
                    {
                    match(input,ATTRIBUTE_NAME,FOLLOW_ATTRIBUTE_NAME_in_attributeName346); 

                    match(input, Token.DOWN, null); 
                    match(input,Identifier,FOLLOW_Identifier_in_attributeName348); 

                    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:75:31: ( attributeName )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==ATTRIBUTE_NAME||LA12_0==MACRO_REF) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:75:31: attributeName
                            {
                            pushFollow(FOLLOW_attributeName_in_attributeName350);
                            attributeName();

                            state._fsp--;


                            }
                            break;

                    }


                    match(input, Token.UP, null); 


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
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:77:1: attribute returns [ImpexNode node] : ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifiers )* ) ) ;
    public final ImpexNode attribute() throws RecognitionException {
        ImpexNode node = null;


        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:78:2: ( ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifiers )* ) ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:78:3: ^( ATTRIBUTE attributeName ^( ITEM_EXPRESSION ( attribute )* ^( DOCUMENTID_REF ( DocumentID )* ) ) ^( MODIFIERS ( attributeModifiers )* ) )
            {
            match(input,ATTRIBUTE,FOLLOW_ATTRIBUTE_in_attribute368); 

            match(input, Token.DOWN, null); 
            pushFollow(FOLLOW_attributeName_in_attribute370);
            attributeName();

            state._fsp--;


            match(input,ITEM_EXPRESSION,FOLLOW_ITEM_EXPRESSION_in_attribute373); 

            match(input, Token.DOWN, null); 
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:78:47: ( attribute )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==ATTRIBUTE) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:78:47: attribute
            	    {
            	    pushFollow(FOLLOW_attribute_in_attribute375);
            	    attribute();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            match(input,DOCUMENTID_REF,FOLLOW_DOCUMENTID_REF_in_attribute379); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:78:75: ( DocumentID )*
                loop15:
                do {
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==DocumentID) ) {
                        alt15=1;
                    }


                    switch (alt15) {
                	case 1 :
                	    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:78:75: DocumentID
                	    {
                	    match(input,DocumentID,FOLLOW_DocumentID_in_attribute381); 

                	    }
                	    break;

                	default :
                	    break loop15;
                    }
                } while (true);


                match(input, Token.UP, null); 
            }


            match(input, Token.UP, null); 


            match(input,MODIFIERS,FOLLOW_MODIFIERS_in_attribute387); 

            if ( input.LA(1)==Token.DOWN ) {
                match(input, Token.DOWN, null); 
                // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:78:101: ( attributeModifiers )*
                loop16:
                do {
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==MODIFIERS) ) {
                        alt16=1;
                    }


                    switch (alt16) {
                	case 1 :
                	    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:78:101: attributeModifiers
                	    {
                	    pushFollow(FOLLOW_attributeModifiers_in_attribute389);
                	    attributeModifiers();

                	    state._fsp--;


                	    }
                	    break;

                	default :
                	    break loop16;
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



    // $ANTLR start "macro"
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:86:1: macro returns [ImpexNode node] : ^( MACRO def= Macrodef val= ValueAssignement ) ;
    public final ImpexNode macro() throws RecognitionException {
        ImpexNode node = null;


        CommonTree def=null;
        CommonTree val=null;

        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:87:2: ( ^( MACRO def= Macrodef val= ValueAssignement ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:87:3: ^( MACRO def= Macrodef val= ValueAssignement )
            {
            match(input,MACRO,FOLLOW_MACRO_in_macro415); 

            match(input, Token.DOWN, null); 
            def=(CommonTree)match(input,Macrodef,FOLLOW_Macrodef_in_macro419); 

            val=(CommonTree)match(input,ValueAssignement,FOLLOW_ValueAssignement_in_macro423); 

            match(input, Token.UP, null); 


            node = new MacroNode((def!=null?def.getText():null), (val!=null?val.getText():null));

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
    // $ANTLR end "macro"



    // $ANTLR start "attributeModifier"
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:89:1: attributeModifier : ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual );
    public final void attributeModifier() throws RecognitionException {
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:90:2: ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:
            {
            if ( (input.LA(1) >= Alias && input.LA(1) <= AllowNull)||input.LA(1)==CellDecorator||input.LA(1)==CollectionDelimiter||(input.LA(1) >= Dateformat && input.LA(1) <= Default)||input.LA(1)==ForceWrite||(input.LA(1) >= IgnoreKeyCase && input.LA(1) <= IgnoreNull)||input.LA(1)==KeyToValueDelimiter||input.LA(1)==Lang||(input.LA(1) >= MapDelimiter && input.LA(1) <= Mode)||input.LA(1)==NumberFormat||(input.LA(1) >= PathDelimiter && input.LA(1) <= Pos)||(input.LA(1) >= Translator && input.LA(1) <= Unique)||input.LA(1)==Virtual ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
        return ;
    }
    // $ANTLR end "attributeModifier"



    // $ANTLR start "headerMode"
    // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:93:1: headerMode : ( Insert | InsertUpdate | Update | Remove );
    public final void headerMode() throws RecognitionException {
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:94:2: ( Insert | InsertUpdate | Update | Remove )
            // /work/projects/yeclipse/ImpexAST/src/main/java/ImpexTreeWalker.g:
            {
            if ( (input.LA(1) >= Insert && input.LA(1) <= InsertUpdate)||input.LA(1)==Remove||input.LA(1)==Update ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
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
        return ;
    }
    // $ANTLR end "headerMode"

    // Delegated rules


 

    public static final BitSet FOLLOW_impex_in_walk45 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IMPEX_in_impex58 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_MACROS_in_impex61 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_macro_in_impex63 = new BitSet(new long[]{0x0000800000000008L});
    public static final BitSet FOLLOW_BLOCKS_in_impex69 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_block_in_impex71 = new BitSet(new long[]{0x0000000000000408L});
    public static final BitSet FOLLOW_BLOCK_in_block87 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_header_in_block89 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_RECORDS_in_block92 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_record_in_block94 = new BitSet(new long[]{0x8000000000000008L});
    public static final BitSet FOLLOW_HEADER_in_header110 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_headerMode_in_header112 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_TYPE_in_header115 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_header117 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MODIFIERS_in_header121 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_headerModifiers_in_header123 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_DOCUMENTID_in_header128 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DocumentID_in_header130 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ATTRIBUTES_in_header135 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attribute_in_header137 = new BitSet(new long[]{0x0000000000000018L});
    public static final BitSet FOLLOW_MODIFIERS_in_headerModifiers156 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_headerModifierAssignment_in_headerModifiers158 = new BitSet(new long[]{0x0004000000000008L});
    public static final BitSet FOLLOW_MODIFIER_in_headerModifierAssignment176 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_headerModifier_in_headerModifierAssignment178 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_boolOrClassname_in_headerModifierAssignment180 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_RECORD_in_record229 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SUBTYPE_in_record232 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_record234 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_FIELDS_in_record239 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_QuotedField_in_record241 = new BitSet(new long[]{0x2000000040000008L});
    public static final BitSet FOLLOW_Field_in_record244 = new BitSet(new long[]{0x0000000040000008L});
    public static final BitSet FOLLOW_MODIFIERS_in_attributeModifiers284 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attributeModifierAssignment_in_attributeModifiers286 = new BitSet(new long[]{0x0004000000000008L});
    public static final BitSet FOLLOW_MODIFIER_in_attributeModifierAssignment303 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attributeModifier_in_attributeModifierAssignment305 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_ValueAssignement_in_attributeModifierAssignment307 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_MACRO_REF_in_attributeName328 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Macrodef_in_attributeName331 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ATTRIBUTE_NAME_in_attributeName338 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_SpecialAttribute_in_attributeName340 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ATTRIBUTE_NAME_in_attributeName346 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Identifier_in_attributeName348 = new BitSet(new long[]{0x0002000000000048L});
    public static final BitSet FOLLOW_attributeName_in_attributeName350 = new BitSet(new long[]{0x0000000000000008L});
    public static final BitSet FOLLOW_ATTRIBUTE_in_attribute368 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attributeName_in_attribute370 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_ITEM_EXPRESSION_in_attribute373 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attribute_in_attribute375 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_DOCUMENTID_REF_in_attribute379 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_DocumentID_in_attribute381 = new BitSet(new long[]{0x0000000002000008L});
    public static final BitSet FOLLOW_MODIFIERS_in_attribute387 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_attributeModifiers_in_attribute389 = new BitSet(new long[]{0x0008000000000008L});
    public static final BitSet FOLLOW_MACRO_in_macro415 = new BitSet(new long[]{0x0000000000000004L});
    public static final BitSet FOLLOW_Macrodef_in_macro419 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_ValueAssignement_in_macro423 = new BitSet(new long[]{0x0000000000000008L});

}