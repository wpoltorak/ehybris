package output;
// $ANTLR 3.4 /work/projects/YPlugin/impex.g 2012-09-06 21:00:02

  


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings({"all", "warnings", "unchecked"})
public class impexParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "ASSIGNEMENT", "Alias", "AllowNull", "BatchMode", "Bool", "BoolAttribModifier", "BoolHeaderModifier", "CacheUnique", "Char", "Comma", "Comment", "ComplexArgumentRef", "Digit", "Dollar", "DoubleQuote", "Equals", "ForceWrite", "Hash", "IgnoreKeyCase", "IgnoreNull", "Insert", "InsertUpdate", "Int", "IntAttribModifier", "LeftBracket", "LeftParenthesis", "Letter", "LineContinuation", "MacroDefinition", "MacroIdentifier", "NewLine", "Pos", "Processor", "Remove", "RightBracket", "RightParenthesis", "Semicolon", "Underscore", "Unique", "Update", "Virtual", "Word", "WordAttribModifier", "WordHeaderModifier", "Ws"
    };

    public static final int EOF=-1;
    public static final int ASSIGNEMENT=4;
    public static final int Alias=5;
    public static final int AllowNull=6;
    public static final int BatchMode=7;
    public static final int Bool=8;
    public static final int BoolAttribModifier=9;
    public static final int BoolHeaderModifier=10;
    public static final int CacheUnique=11;
    public static final int Char=12;
    public static final int Comma=13;
    public static final int Comment=14;
    public static final int ComplexArgumentRef=15;
    public static final int Digit=16;
    public static final int Dollar=17;
    public static final int DoubleQuote=18;
    public static final int Equals=19;
    public static final int ForceWrite=20;
    public static final int Hash=21;
    public static final int IgnoreKeyCase=22;
    public static final int IgnoreNull=23;
    public static final int Insert=24;
    public static final int InsertUpdate=25;
    public static final int Int=26;
    public static final int IntAttribModifier=27;
    public static final int LeftBracket=28;
    public static final int LeftParenthesis=29;
    public static final int Letter=30;
    public static final int LineContinuation=31;
    public static final int MacroDefinition=32;
    public static final int MacroIdentifier=33;
    public static final int NewLine=34;
    public static final int Pos=35;
    public static final int Processor=36;
    public static final int Remove=37;
    public static final int RightBracket=38;
    public static final int RightParenthesis=39;
    public static final int Semicolon=40;
    public static final int Underscore=41;
    public static final int Unique=42;
    public static final int Update=43;
    public static final int Virtual=44;
    public static final int Word=45;
    public static final int WordAttribModifier=46;
    public static final int WordHeaderModifier=47;
    public static final int Ws=48;

    // delegates
    public Parser[] getDelegates() {
        return new Parser[] {};
    }

    // delegators


    public impexParser(TokenStream input) {
        this(input, new RecognizerSharedState());
    }
    public impexParser(TokenStream input, RecognizerSharedState state) {
        super(input, state);
    }

protected TreeAdaptor adaptor = new CommonTreeAdaptor();

public void setTreeAdaptor(TreeAdaptor adaptor) {
    this.adaptor = adaptor;
}
public TreeAdaptor getTreeAdaptor() {
    return adaptor;
}
    public String[] getTokenNames() { return impexParser.tokenNames; }
    public String getGrammarFileName() { return "/work/projects/YPlugin/impex.g"; }


    public static class field_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "field"
    // /work/projects/YPlugin/impex.g:144:1: field : ( ( DoubleQuote ( Char | Comma | DoubleQuote DoubleQuote | NewLine | MacroDefinition )* DoubleQuote ) | ( Char | MacroDefinition )+ );
    public final impexParser.field_return field() throws RecognitionException {
        impexParser.field_return retval = new impexParser.field_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token DoubleQuote1=null;
        Token Char2=null;
        Token Comma3=null;
        Token DoubleQuote4=null;
        Token DoubleQuote5=null;
        Token NewLine6=null;
        Token MacroDefinition7=null;
        Token DoubleQuote8=null;
        Token set9=null;

        CommonTree DoubleQuote1_tree=null;
        CommonTree Char2_tree=null;
        CommonTree Comma3_tree=null;
        CommonTree DoubleQuote4_tree=null;
        CommonTree DoubleQuote5_tree=null;
        CommonTree NewLine6_tree=null;
        CommonTree MacroDefinition7_tree=null;
        CommonTree DoubleQuote8_tree=null;
        CommonTree set9_tree=null;

        try {
            // /work/projects/YPlugin/impex.g:145:2: ( ( DoubleQuote ( Char | Comma | DoubleQuote DoubleQuote | NewLine | MacroDefinition )* DoubleQuote ) | ( Char | MacroDefinition )+ )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==DoubleQuote) ) {
                alt3=1;
            }
            else if ( (LA3_0==Char||LA3_0==MacroDefinition) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // /work/projects/YPlugin/impex.g:145:4: ( DoubleQuote ( Char | Comma | DoubleQuote DoubleQuote | NewLine | MacroDefinition )* DoubleQuote )
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /work/projects/YPlugin/impex.g:145:4: ( DoubleQuote ( Char | Comma | DoubleQuote DoubleQuote | NewLine | MacroDefinition )* DoubleQuote )
                    // /work/projects/YPlugin/impex.g:145:5: DoubleQuote ( Char | Comma | DoubleQuote DoubleQuote | NewLine | MacroDefinition )* DoubleQuote
                    {
                    DoubleQuote1=(Token)match(input,DoubleQuote,FOLLOW_DoubleQuote_in_field791); 
                    DoubleQuote1_tree = 
                    (CommonTree)adaptor.create(DoubleQuote1)
                    ;
                    adaptor.addChild(root_0, DoubleQuote1_tree);


                    // /work/projects/YPlugin/impex.g:145:17: ( Char | Comma | DoubleQuote DoubleQuote | NewLine | MacroDefinition )*
                    loop1:
                    do {
                        int alt1=6;
                        switch ( input.LA(1) ) {
                        case DoubleQuote:
                            {
                            int LA1_1 = input.LA(2);

                            if ( (LA1_1==DoubleQuote) ) {
                                alt1=3;
                            }


                            }
                            break;
                        case Char:
                            {
                            alt1=1;
                            }
                            break;
                        case Comma:
                            {
                            alt1=2;
                            }
                            break;
                        case NewLine:
                            {
                            alt1=4;
                            }
                            break;
                        case MacroDefinition:
                            {
                            alt1=5;
                            }
                            break;

                        }

                        switch (alt1) {
                    	case 1 :
                    	    // /work/projects/YPlugin/impex.g:145:18: Char
                    	    {
                    	    Char2=(Token)match(input,Char,FOLLOW_Char_in_field794); 
                    	    Char2_tree = 
                    	    (CommonTree)adaptor.create(Char2)
                    	    ;
                    	    adaptor.addChild(root_0, Char2_tree);


                    	    }
                    	    break;
                    	case 2 :
                    	    // /work/projects/YPlugin/impex.g:145:25: Comma
                    	    {
                    	    Comma3=(Token)match(input,Comma,FOLLOW_Comma_in_field798); 
                    	    Comma3_tree = 
                    	    (CommonTree)adaptor.create(Comma3)
                    	    ;
                    	    adaptor.addChild(root_0, Comma3_tree);


                    	    }
                    	    break;
                    	case 3 :
                    	    // /work/projects/YPlugin/impex.g:145:33: DoubleQuote DoubleQuote
                    	    {
                    	    DoubleQuote4=(Token)match(input,DoubleQuote,FOLLOW_DoubleQuote_in_field802); 
                    	    DoubleQuote4_tree = 
                    	    (CommonTree)adaptor.create(DoubleQuote4)
                    	    ;
                    	    adaptor.addChild(root_0, DoubleQuote4_tree);


                    	    DoubleQuote5=(Token)match(input,DoubleQuote,FOLLOW_DoubleQuote_in_field804); 
                    	    DoubleQuote5_tree = 
                    	    (CommonTree)adaptor.create(DoubleQuote5)
                    	    ;
                    	    adaptor.addChild(root_0, DoubleQuote5_tree);


                    	    }
                    	    break;
                    	case 4 :
                    	    // /work/projects/YPlugin/impex.g:145:59: NewLine
                    	    {
                    	    NewLine6=(Token)match(input,NewLine,FOLLOW_NewLine_in_field808); 
                    	    NewLine6_tree = 
                    	    (CommonTree)adaptor.create(NewLine6)
                    	    ;
                    	    adaptor.addChild(root_0, NewLine6_tree);


                    	    }
                    	    break;
                    	case 5 :
                    	    // /work/projects/YPlugin/impex.g:145:69: MacroDefinition
                    	    {
                    	    MacroDefinition7=(Token)match(input,MacroDefinition,FOLLOW_MacroDefinition_in_field812); 
                    	    MacroDefinition7_tree = 
                    	    (CommonTree)adaptor.create(MacroDefinition7)
                    	    ;
                    	    adaptor.addChild(root_0, MacroDefinition7_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    DoubleQuote8=(Token)match(input,DoubleQuote,FOLLOW_DoubleQuote_in_field816); 
                    DoubleQuote8_tree = 
                    (CommonTree)adaptor.create(DoubleQuote8)
                    ;
                    adaptor.addChild(root_0, DoubleQuote8_tree);


                    }


                    }
                    break;
                case 2 :
                    // /work/projects/YPlugin/impex.g:145:102: ( Char | MacroDefinition )+
                    {
                    root_0 = (CommonTree)adaptor.nil();


                    // /work/projects/YPlugin/impex.g:145:102: ( Char | MacroDefinition )+
                    int cnt2=0;
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==MacroDefinition) ) {
                            int LA2_2 = input.LA(2);

                            if ( (LA2_2==EOF||LA2_2==Char||(LA2_2 >= Insert && LA2_2 <= InsertUpdate)||(LA2_2 >= LineContinuation && LA2_2 <= MacroDefinition)||LA2_2==NewLine||LA2_2==Remove||LA2_2==Semicolon||LA2_2==Update||LA2_2==Ws) ) {
                                alt2=1;
                            }


                        }
                        else if ( (LA2_0==Char) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // /work/projects/YPlugin/impex.g:
                    	    {
                    	    set9=(Token)input.LT(1);

                    	    if ( input.LA(1)==Char||input.LA(1)==MacroDefinition ) {
                    	        input.consume();
                    	        adaptor.addChild(root_0, 
                    	        (CommonTree)adaptor.create(set9)
                    	        );
                    	        state.errorRecovery=false;
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        throw mse;
                    	    }


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
    // $ANTLR end "field"


    public static class headerMode_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "headerMode"
    // /work/projects/YPlugin/impex.g:148:1: headerMode : ( Insert | InsertUpdate | Update | Remove );
    public final impexParser.headerMode_return headerMode() throws RecognitionException {
        impexParser.headerMode_return retval = new impexParser.headerMode_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set10=null;

        CommonTree set10_tree=null;

        try {
            // /work/projects/YPlugin/impex.g:149:2: ( Insert | InsertUpdate | Update | Remove )
            // /work/projects/YPlugin/impex.g:
            {
            root_0 = (CommonTree)adaptor.nil();


            set10=(Token)input.LT(1);

            if ( (input.LA(1) >= Insert && input.LA(1) <= InsertUpdate)||input.LA(1)==Remove||input.LA(1)==Update ) {
                input.consume();
                adaptor.addChild(root_0, 
                (CommonTree)adaptor.create(set10)
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


    public static class headerModeType_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "headerModeType"
    // /work/projects/YPlugin/impex.g:151:1: headerModeType : ( Ws )* headerMode ( Ws )+ Word ( ( Ws )* headerModifier )? ;
    public final impexParser.headerModeType_return headerModeType() throws RecognitionException {
        impexParser.headerModeType_return retval = new impexParser.headerModeType_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Ws11=null;
        Token Ws13=null;
        Token Word14=null;
        Token Ws15=null;
        impexParser.headerMode_return headerMode12 =null;

        impexParser.headerModifier_return headerModifier16 =null;


        CommonTree Ws11_tree=null;
        CommonTree Ws13_tree=null;
        CommonTree Word14_tree=null;
        CommonTree Ws15_tree=null;

        try {
            // /work/projects/YPlugin/impex.g:152:2: ( ( Ws )* headerMode ( Ws )+ Word ( ( Ws )* headerModifier )? )
            // /work/projects/YPlugin/impex.g:152:4: ( Ws )* headerMode ( Ws )+ Word ( ( Ws )* headerModifier )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /work/projects/YPlugin/impex.g:152:4: ( Ws )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==Ws) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /work/projects/YPlugin/impex.g:152:4: Ws
            	    {
            	    Ws11=(Token)match(input,Ws,FOLLOW_Ws_in_headerModeType863); 
            	    Ws11_tree = 
            	    (CommonTree)adaptor.create(Ws11)
            	    ;
            	    adaptor.addChild(root_0, Ws11_tree);


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            pushFollow(FOLLOW_headerMode_in_headerModeType866);
            headerMode12=headerMode();

            state._fsp--;

            adaptor.addChild(root_0, headerMode12.getTree());

            // /work/projects/YPlugin/impex.g:152:19: ( Ws )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==Ws) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /work/projects/YPlugin/impex.g:152:19: Ws
            	    {
            	    Ws13=(Token)match(input,Ws,FOLLOW_Ws_in_headerModeType868); 
            	    Ws13_tree = 
            	    (CommonTree)adaptor.create(Ws13)
            	    ;
            	    adaptor.addChild(root_0, Ws13_tree);


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


            Word14=(Token)match(input,Word,FOLLOW_Word_in_headerModeType871); 
            Word14_tree = 
            (CommonTree)adaptor.create(Word14)
            ;
            adaptor.addChild(root_0, Word14_tree);


            // /work/projects/YPlugin/impex.g:152:29: ( ( Ws )* headerModifier )?
            int alt7=2;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // /work/projects/YPlugin/impex.g:152:30: ( Ws )* headerModifier
                    {
                    // /work/projects/YPlugin/impex.g:152:30: ( Ws )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==Ws) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // /work/projects/YPlugin/impex.g:152:30: Ws
                    	    {
                    	    Ws15=(Token)match(input,Ws,FOLLOW_Ws_in_headerModeType875); 
                    	    Ws15_tree = 
                    	    (CommonTree)adaptor.create(Ws15)
                    	    ;
                    	    adaptor.addChild(root_0, Ws15_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    pushFollow(FOLLOW_headerModifier_in_headerModeType878);
                    headerModifier16=headerModifier();

                    state._fsp--;

                    adaptor.addChild(root_0, headerModifier16.getTree());

                    }
                    break;

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
    // $ANTLR end "headerModeType"


    public static class headerModifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "headerModifier"
    // /work/projects/YPlugin/impex.g:155:1: headerModifier : LeftBracket ( BoolHeaderModifier ( Ws )* Equals ( Ws )* Bool | WordHeaderModifier ( Ws )* Equals ( Ws )* Word ) ( Ws )* RightBracket ;
    public final impexParser.headerModifier_return headerModifier() throws RecognitionException {
        impexParser.headerModifier_return retval = new impexParser.headerModifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token LeftBracket17=null;
        Token BoolHeaderModifier18=null;
        Token Ws19=null;
        Token Equals20=null;
        Token Ws21=null;
        Token Bool22=null;
        Token WordHeaderModifier23=null;
        Token Ws24=null;
        Token Equals25=null;
        Token Ws26=null;
        Token Word27=null;
        Token Ws28=null;
        Token RightBracket29=null;

        CommonTree LeftBracket17_tree=null;
        CommonTree BoolHeaderModifier18_tree=null;
        CommonTree Ws19_tree=null;
        CommonTree Equals20_tree=null;
        CommonTree Ws21_tree=null;
        CommonTree Bool22_tree=null;
        CommonTree WordHeaderModifier23_tree=null;
        CommonTree Ws24_tree=null;
        CommonTree Equals25_tree=null;
        CommonTree Ws26_tree=null;
        CommonTree Word27_tree=null;
        CommonTree Ws28_tree=null;
        CommonTree RightBracket29_tree=null;

        try {
            // /work/projects/YPlugin/impex.g:156:2: ( LeftBracket ( BoolHeaderModifier ( Ws )* Equals ( Ws )* Bool | WordHeaderModifier ( Ws )* Equals ( Ws )* Word ) ( Ws )* RightBracket )
            // /work/projects/YPlugin/impex.g:156:4: LeftBracket ( BoolHeaderModifier ( Ws )* Equals ( Ws )* Bool | WordHeaderModifier ( Ws )* Equals ( Ws )* Word ) ( Ws )* RightBracket
            {
            root_0 = (CommonTree)adaptor.nil();


            LeftBracket17=(Token)match(input,LeftBracket,FOLLOW_LeftBracket_in_headerModifier892); 
            LeftBracket17_tree = 
            (CommonTree)adaptor.create(LeftBracket17)
            ;
            adaptor.addChild(root_0, LeftBracket17_tree);


            // /work/projects/YPlugin/impex.g:156:16: ( BoolHeaderModifier ( Ws )* Equals ( Ws )* Bool | WordHeaderModifier ( Ws )* Equals ( Ws )* Word )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==BoolHeaderModifier) ) {
                alt12=1;
            }
            else if ( (LA12_0==WordHeaderModifier) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }
            switch (alt12) {
                case 1 :
                    // /work/projects/YPlugin/impex.g:156:17: BoolHeaderModifier ( Ws )* Equals ( Ws )* Bool
                    {
                    BoolHeaderModifier18=(Token)match(input,BoolHeaderModifier,FOLLOW_BoolHeaderModifier_in_headerModifier895); 
                    BoolHeaderModifier18_tree = 
                    (CommonTree)adaptor.create(BoolHeaderModifier18)
                    ;
                    adaptor.addChild(root_0, BoolHeaderModifier18_tree);


                    // /work/projects/YPlugin/impex.g:156:36: ( Ws )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==Ws) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // /work/projects/YPlugin/impex.g:156:36: Ws
                    	    {
                    	    Ws19=(Token)match(input,Ws,FOLLOW_Ws_in_headerModifier897); 
                    	    Ws19_tree = 
                    	    (CommonTree)adaptor.create(Ws19)
                    	    ;
                    	    adaptor.addChild(root_0, Ws19_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    Equals20=(Token)match(input,Equals,FOLLOW_Equals_in_headerModifier900); 
                    Equals20_tree = 
                    (CommonTree)adaptor.create(Equals20)
                    ;
                    adaptor.addChild(root_0, Equals20_tree);


                    // /work/projects/YPlugin/impex.g:156:48: ( Ws )*
                    loop9:
                    do {
                        int alt9=2;
                        int LA9_0 = input.LA(1);

                        if ( (LA9_0==Ws) ) {
                            alt9=1;
                        }


                        switch (alt9) {
                    	case 1 :
                    	    // /work/projects/YPlugin/impex.g:156:48: Ws
                    	    {
                    	    Ws21=(Token)match(input,Ws,FOLLOW_Ws_in_headerModifier903); 
                    	    Ws21_tree = 
                    	    (CommonTree)adaptor.create(Ws21)
                    	    ;
                    	    adaptor.addChild(root_0, Ws21_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop9;
                        }
                    } while (true);


                    Bool22=(Token)match(input,Bool,FOLLOW_Bool_in_headerModifier906); 
                    Bool22_tree = 
                    (CommonTree)adaptor.create(Bool22)
                    ;
                    adaptor.addChild(root_0, Bool22_tree);


                    }
                    break;
                case 2 :
                    // /work/projects/YPlugin/impex.g:156:59: WordHeaderModifier ( Ws )* Equals ( Ws )* Word
                    {
                    WordHeaderModifier23=(Token)match(input,WordHeaderModifier,FOLLOW_WordHeaderModifier_in_headerModifier910); 
                    WordHeaderModifier23_tree = 
                    (CommonTree)adaptor.create(WordHeaderModifier23)
                    ;
                    adaptor.addChild(root_0, WordHeaderModifier23_tree);


                    // /work/projects/YPlugin/impex.g:156:78: ( Ws )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==Ws) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // /work/projects/YPlugin/impex.g:156:78: Ws
                    	    {
                    	    Ws24=(Token)match(input,Ws,FOLLOW_Ws_in_headerModifier912); 
                    	    Ws24_tree = 
                    	    (CommonTree)adaptor.create(Ws24)
                    	    ;
                    	    adaptor.addChild(root_0, Ws24_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    Equals25=(Token)match(input,Equals,FOLLOW_Equals_in_headerModifier915); 
                    Equals25_tree = 
                    (CommonTree)adaptor.create(Equals25)
                    ;
                    adaptor.addChild(root_0, Equals25_tree);


                    // /work/projects/YPlugin/impex.g:156:90: ( Ws )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==Ws) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // /work/projects/YPlugin/impex.g:156:90: Ws
                    	    {
                    	    Ws26=(Token)match(input,Ws,FOLLOW_Ws_in_headerModifier918); 
                    	    Ws26_tree = 
                    	    (CommonTree)adaptor.create(Ws26)
                    	    ;
                    	    adaptor.addChild(root_0, Ws26_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);


                    Word27=(Token)match(input,Word,FOLLOW_Word_in_headerModifier921); 
                    Word27_tree = 
                    (CommonTree)adaptor.create(Word27)
                    ;
                    adaptor.addChild(root_0, Word27_tree);


                    }
                    break;

            }


            // /work/projects/YPlugin/impex.g:156:100: ( Ws )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==Ws) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /work/projects/YPlugin/impex.g:156:100: Ws
            	    {
            	    Ws28=(Token)match(input,Ws,FOLLOW_Ws_in_headerModifier924); 
            	    Ws28_tree = 
            	    (CommonTree)adaptor.create(Ws28)
            	    ;
            	    adaptor.addChild(root_0, Ws28_tree);


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            RightBracket29=(Token)match(input,RightBracket,FOLLOW_RightBracket_in_headerModifier928); 
            RightBracket29_tree = 
            (CommonTree)adaptor.create(RightBracket29)
            ;
            adaptor.addChild(root_0, RightBracket29_tree);


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


    public static class argumentModifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "argumentModifier"
    // /work/projects/YPlugin/impex.g:159:1: argumentModifier : LeftBracket ( BoolAttribModifier ( Ws )* Equals ( Ws )* Bool | IntAttribModifier ( Ws )* Equals ( Ws )* Int | WordAttribModifier ( Ws )* Equals ( Ws )* Word ) ( Ws )* RightBracket ;
    public final impexParser.argumentModifier_return argumentModifier() throws RecognitionException {
        impexParser.argumentModifier_return retval = new impexParser.argumentModifier_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token LeftBracket30=null;
        Token BoolAttribModifier31=null;
        Token Ws32=null;
        Token Equals33=null;
        Token Ws34=null;
        Token Bool35=null;
        Token IntAttribModifier36=null;
        Token Ws37=null;
        Token Equals38=null;
        Token Ws39=null;
        Token Int40=null;
        Token WordAttribModifier41=null;
        Token Ws42=null;
        Token Equals43=null;
        Token Ws44=null;
        Token Word45=null;
        Token Ws46=null;
        Token RightBracket47=null;

        CommonTree LeftBracket30_tree=null;
        CommonTree BoolAttribModifier31_tree=null;
        CommonTree Ws32_tree=null;
        CommonTree Equals33_tree=null;
        CommonTree Ws34_tree=null;
        CommonTree Bool35_tree=null;
        CommonTree IntAttribModifier36_tree=null;
        CommonTree Ws37_tree=null;
        CommonTree Equals38_tree=null;
        CommonTree Ws39_tree=null;
        CommonTree Int40_tree=null;
        CommonTree WordAttribModifier41_tree=null;
        CommonTree Ws42_tree=null;
        CommonTree Equals43_tree=null;
        CommonTree Ws44_tree=null;
        CommonTree Word45_tree=null;
        CommonTree Ws46_tree=null;
        CommonTree RightBracket47_tree=null;

        try {
            // /work/projects/YPlugin/impex.g:160:2: ( LeftBracket ( BoolAttribModifier ( Ws )* Equals ( Ws )* Bool | IntAttribModifier ( Ws )* Equals ( Ws )* Int | WordAttribModifier ( Ws )* Equals ( Ws )* Word ) ( Ws )* RightBracket )
            // /work/projects/YPlugin/impex.g:160:4: LeftBracket ( BoolAttribModifier ( Ws )* Equals ( Ws )* Bool | IntAttribModifier ( Ws )* Equals ( Ws )* Int | WordAttribModifier ( Ws )* Equals ( Ws )* Word ) ( Ws )* RightBracket
            {
            root_0 = (CommonTree)adaptor.nil();


            LeftBracket30=(Token)match(input,LeftBracket,FOLLOW_LeftBracket_in_argumentModifier941); 
            LeftBracket30_tree = 
            (CommonTree)adaptor.create(LeftBracket30)
            ;
            adaptor.addChild(root_0, LeftBracket30_tree);


            // /work/projects/YPlugin/impex.g:160:16: ( BoolAttribModifier ( Ws )* Equals ( Ws )* Bool | IntAttribModifier ( Ws )* Equals ( Ws )* Int | WordAttribModifier ( Ws )* Equals ( Ws )* Word )
            int alt20=3;
            switch ( input.LA(1) ) {
            case BoolAttribModifier:
                {
                alt20=1;
                }
                break;
            case IntAttribModifier:
                {
                alt20=2;
                }
                break;
            case WordAttribModifier:
                {
                alt20=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;

            }

            switch (alt20) {
                case 1 :
                    // /work/projects/YPlugin/impex.g:160:17: BoolAttribModifier ( Ws )* Equals ( Ws )* Bool
                    {
                    BoolAttribModifier31=(Token)match(input,BoolAttribModifier,FOLLOW_BoolAttribModifier_in_argumentModifier944); 
                    BoolAttribModifier31_tree = 
                    (CommonTree)adaptor.create(BoolAttribModifier31)
                    ;
                    adaptor.addChild(root_0, BoolAttribModifier31_tree);


                    // /work/projects/YPlugin/impex.g:160:36: ( Ws )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==Ws) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // /work/projects/YPlugin/impex.g:160:36: Ws
                    	    {
                    	    Ws32=(Token)match(input,Ws,FOLLOW_Ws_in_argumentModifier946); 
                    	    Ws32_tree = 
                    	    (CommonTree)adaptor.create(Ws32)
                    	    ;
                    	    adaptor.addChild(root_0, Ws32_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    Equals33=(Token)match(input,Equals,FOLLOW_Equals_in_argumentModifier949); 
                    Equals33_tree = 
                    (CommonTree)adaptor.create(Equals33)
                    ;
                    adaptor.addChild(root_0, Equals33_tree);


                    // /work/projects/YPlugin/impex.g:160:47: ( Ws )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==Ws) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // /work/projects/YPlugin/impex.g:160:47: Ws
                    	    {
                    	    Ws34=(Token)match(input,Ws,FOLLOW_Ws_in_argumentModifier951); 
                    	    Ws34_tree = 
                    	    (CommonTree)adaptor.create(Ws34)
                    	    ;
                    	    adaptor.addChild(root_0, Ws34_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    Bool35=(Token)match(input,Bool,FOLLOW_Bool_in_argumentModifier954); 
                    Bool35_tree = 
                    (CommonTree)adaptor.create(Bool35)
                    ;
                    adaptor.addChild(root_0, Bool35_tree);


                    }
                    break;
                case 2 :
                    // /work/projects/YPlugin/impex.g:160:58: IntAttribModifier ( Ws )* Equals ( Ws )* Int
                    {
                    IntAttribModifier36=(Token)match(input,IntAttribModifier,FOLLOW_IntAttribModifier_in_argumentModifier958); 
                    IntAttribModifier36_tree = 
                    (CommonTree)adaptor.create(IntAttribModifier36)
                    ;
                    adaptor.addChild(root_0, IntAttribModifier36_tree);


                    // /work/projects/YPlugin/impex.g:160:76: ( Ws )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==Ws) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // /work/projects/YPlugin/impex.g:160:76: Ws
                    	    {
                    	    Ws37=(Token)match(input,Ws,FOLLOW_Ws_in_argumentModifier960); 
                    	    Ws37_tree = 
                    	    (CommonTree)adaptor.create(Ws37)
                    	    ;
                    	    adaptor.addChild(root_0, Ws37_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);


                    Equals38=(Token)match(input,Equals,FOLLOW_Equals_in_argumentModifier963); 
                    Equals38_tree = 
                    (CommonTree)adaptor.create(Equals38)
                    ;
                    adaptor.addChild(root_0, Equals38_tree);


                    // /work/projects/YPlugin/impex.g:160:87: ( Ws )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==Ws) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // /work/projects/YPlugin/impex.g:160:87: Ws
                    	    {
                    	    Ws39=(Token)match(input,Ws,FOLLOW_Ws_in_argumentModifier965); 
                    	    Ws39_tree = 
                    	    (CommonTree)adaptor.create(Ws39)
                    	    ;
                    	    adaptor.addChild(root_0, Ws39_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop17;
                        }
                    } while (true);


                    Int40=(Token)match(input,Int,FOLLOW_Int_in_argumentModifier968); 
                    Int40_tree = 
                    (CommonTree)adaptor.create(Int40)
                    ;
                    adaptor.addChild(root_0, Int40_tree);


                    }
                    break;
                case 3 :
                    // /work/projects/YPlugin/impex.g:160:97: WordAttribModifier ( Ws )* Equals ( Ws )* Word
                    {
                    WordAttribModifier41=(Token)match(input,WordAttribModifier,FOLLOW_WordAttribModifier_in_argumentModifier972); 
                    WordAttribModifier41_tree = 
                    (CommonTree)adaptor.create(WordAttribModifier41)
                    ;
                    adaptor.addChild(root_0, WordAttribModifier41_tree);


                    // /work/projects/YPlugin/impex.g:160:116: ( Ws )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==Ws) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // /work/projects/YPlugin/impex.g:160:116: Ws
                    	    {
                    	    Ws42=(Token)match(input,Ws,FOLLOW_Ws_in_argumentModifier974); 
                    	    Ws42_tree = 
                    	    (CommonTree)adaptor.create(Ws42)
                    	    ;
                    	    adaptor.addChild(root_0, Ws42_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    Equals43=(Token)match(input,Equals,FOLLOW_Equals_in_argumentModifier977); 
                    Equals43_tree = 
                    (CommonTree)adaptor.create(Equals43)
                    ;
                    adaptor.addChild(root_0, Equals43_tree);


                    // /work/projects/YPlugin/impex.g:160:127: ( Ws )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==Ws) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // /work/projects/YPlugin/impex.g:160:127: Ws
                    	    {
                    	    Ws44=(Token)match(input,Ws,FOLLOW_Ws_in_argumentModifier979); 
                    	    Ws44_tree = 
                    	    (CommonTree)adaptor.create(Ws44)
                    	    ;
                    	    adaptor.addChild(root_0, Ws44_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);


                    Word45=(Token)match(input,Word,FOLLOW_Word_in_argumentModifier982); 
                    Word45_tree = 
                    (CommonTree)adaptor.create(Word45)
                    ;
                    adaptor.addChild(root_0, Word45_tree);


                    }
                    break;

            }


            // /work/projects/YPlugin/impex.g:160:137: ( Ws )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==Ws) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /work/projects/YPlugin/impex.g:160:137: Ws
            	    {
            	    Ws46=(Token)match(input,Ws,FOLLOW_Ws_in_argumentModifier985); 
            	    Ws46_tree = 
            	    (CommonTree)adaptor.create(Ws46)
            	    ;
            	    adaptor.addChild(root_0, Ws46_tree);


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            RightBracket47=(Token)match(input,RightBracket,FOLLOW_RightBracket_in_argumentModifier989); 
            RightBracket47_tree = 
            (CommonTree)adaptor.create(RightBracket47)
            ;
            adaptor.addChild(root_0, RightBracket47_tree);


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
    // $ANTLR end "argumentModifier"


    public static class simpleAttribute_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "simpleAttribute"
    // /work/projects/YPlugin/impex.g:163:1: simpleAttribute : Word ( argumentModifier )? ;
    public final impexParser.simpleAttribute_return simpleAttribute() throws RecognitionException {
        impexParser.simpleAttribute_return retval = new impexParser.simpleAttribute_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Word48=null;
        impexParser.argumentModifier_return argumentModifier49 =null;


        CommonTree Word48_tree=null;

        try {
            // /work/projects/YPlugin/impex.g:164:2: ( Word ( argumentModifier )? )
            // /work/projects/YPlugin/impex.g:164:4: Word ( argumentModifier )?
            {
            root_0 = (CommonTree)adaptor.nil();


            Word48=(Token)match(input,Word,FOLLOW_Word_in_simpleAttribute1001); 
            Word48_tree = 
            (CommonTree)adaptor.create(Word48)
            ;
            adaptor.addChild(root_0, Word48_tree);


            // /work/projects/YPlugin/impex.g:164:9: ( argumentModifier )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==LeftBracket) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // /work/projects/YPlugin/impex.g:164:9: argumentModifier
                    {
                    pushFollow(FOLLOW_argumentModifier_in_simpleAttribute1003);
                    argumentModifier49=argumentModifier();

                    state._fsp--;

                    adaptor.addChild(root_0, argumentModifier49.getTree());

                    }
                    break;

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
    // $ANTLR end "simpleAttribute"


    public static class complexAttribute_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "complexAttribute"
    // /work/projects/YPlugin/impex.g:167:1: complexAttribute : ComplexArgumentRef ( ( Ws )* argumentModifier )? ;
    public final impexParser.complexAttribute_return complexAttribute() throws RecognitionException {
        impexParser.complexAttribute_return retval = new impexParser.complexAttribute_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token ComplexArgumentRef50=null;
        Token Ws51=null;
        impexParser.argumentModifier_return argumentModifier52 =null;


        CommonTree ComplexArgumentRef50_tree=null;
        CommonTree Ws51_tree=null;

        try {
            // /work/projects/YPlugin/impex.g:168:2: ( ComplexArgumentRef ( ( Ws )* argumentModifier )? )
            // /work/projects/YPlugin/impex.g:168:4: ComplexArgumentRef ( ( Ws )* argumentModifier )?
            {
            root_0 = (CommonTree)adaptor.nil();


            ComplexArgumentRef50=(Token)match(input,ComplexArgumentRef,FOLLOW_ComplexArgumentRef_in_complexAttribute1015); 
            ComplexArgumentRef50_tree = 
            (CommonTree)adaptor.create(ComplexArgumentRef50)
            ;
            adaptor.addChild(root_0, ComplexArgumentRef50_tree);


            // /work/projects/YPlugin/impex.g:168:23: ( ( Ws )* argumentModifier )?
            int alt24=2;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // /work/projects/YPlugin/impex.g:168:24: ( Ws )* argumentModifier
                    {
                    // /work/projects/YPlugin/impex.g:168:24: ( Ws )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==Ws) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // /work/projects/YPlugin/impex.g:168:24: Ws
                    	    {
                    	    Ws51=(Token)match(input,Ws,FOLLOW_Ws_in_complexAttribute1018); 
                    	    Ws51_tree = 
                    	    (CommonTree)adaptor.create(Ws51)
                    	    ;
                    	    adaptor.addChild(root_0, Ws51_tree);


                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);


                    pushFollow(FOLLOW_argumentModifier_in_complexAttribute1021);
                    argumentModifier52=argumentModifier();

                    state._fsp--;

                    adaptor.addChild(root_0, argumentModifier52.getTree());

                    }
                    break;

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
    // $ANTLR end "complexAttribute"


    public static class header_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "header"
    // /work/projects/YPlugin/impex.g:170:1: header : headerModeType ( Ws )* Semicolon ( ( Ws )* Semicolon ( ( Ws )* ( simpleAttribute | complexAttribute ) )? )+ ;
    public final impexParser.header_return header() throws RecognitionException {
        impexParser.header_return retval = new impexParser.header_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Ws54=null;
        Token Semicolon55=null;
        Token Ws56=null;
        Token Semicolon57=null;
        Token Ws58=null;
        impexParser.headerModeType_return headerModeType53 =null;

        impexParser.simpleAttribute_return simpleAttribute59 =null;

        impexParser.complexAttribute_return complexAttribute60 =null;


        CommonTree Ws54_tree=null;
        CommonTree Semicolon55_tree=null;
        CommonTree Ws56_tree=null;
        CommonTree Semicolon57_tree=null;
        CommonTree Ws58_tree=null;

        try {
            // /work/projects/YPlugin/impex.g:171:2: ( headerModeType ( Ws )* Semicolon ( ( Ws )* Semicolon ( ( Ws )* ( simpleAttribute | complexAttribute ) )? )+ )
            // /work/projects/YPlugin/impex.g:171:4: headerModeType ( Ws )* Semicolon ( ( Ws )* Semicolon ( ( Ws )* ( simpleAttribute | complexAttribute ) )? )+
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_headerModeType_in_header1034);
            headerModeType53=headerModeType();

            state._fsp--;

            adaptor.addChild(root_0, headerModeType53.getTree());

            // /work/projects/YPlugin/impex.g:171:19: ( Ws )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==Ws) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // /work/projects/YPlugin/impex.g:171:19: Ws
            	    {
            	    Ws54=(Token)match(input,Ws,FOLLOW_Ws_in_header1036); 
            	    Ws54_tree = 
            	    (CommonTree)adaptor.create(Ws54)
            	    ;
            	    adaptor.addChild(root_0, Ws54_tree);


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            Semicolon55=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_header1039); 
            Semicolon55_tree = 
            (CommonTree)adaptor.create(Semicolon55)
            ;
            adaptor.addChild(root_0, Semicolon55_tree);


            // /work/projects/YPlugin/impex.g:171:34: ( ( Ws )* Semicolon ( ( Ws )* ( simpleAttribute | complexAttribute ) )? )+
            int cnt30=0;
            loop30:
            do {
                int alt30=2;
                alt30 = dfa30.predict(input);
                switch (alt30) {
            	case 1 :
            	    // /work/projects/YPlugin/impex.g:171:35: ( Ws )* Semicolon ( ( Ws )* ( simpleAttribute | complexAttribute ) )?
            	    {
            	    // /work/projects/YPlugin/impex.g:171:35: ( Ws )*
            	    loop26:
            	    do {
            	        int alt26=2;
            	        int LA26_0 = input.LA(1);

            	        if ( (LA26_0==Ws) ) {
            	            alt26=1;
            	        }


            	        switch (alt26) {
            	    	case 1 :
            	    	    // /work/projects/YPlugin/impex.g:171:35: Ws
            	    	    {
            	    	    Ws56=(Token)match(input,Ws,FOLLOW_Ws_in_header1043); 
            	    	    Ws56_tree = 
            	    	    (CommonTree)adaptor.create(Ws56)
            	    	    ;
            	    	    adaptor.addChild(root_0, Ws56_tree);


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop26;
            	        }
            	    } while (true);


            	    Semicolon57=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_header1046); 
            	    Semicolon57_tree = 
            	    (CommonTree)adaptor.create(Semicolon57)
            	    ;
            	    adaptor.addChild(root_0, Semicolon57_tree);


            	    // /work/projects/YPlugin/impex.g:171:50: ( ( Ws )* ( simpleAttribute | complexAttribute ) )?
            	    int alt29=2;
            	    alt29 = dfa29.predict(input);
            	    switch (alt29) {
            	        case 1 :
            	            // /work/projects/YPlugin/impex.g:171:51: ( Ws )* ( simpleAttribute | complexAttribute )
            	            {
            	            // /work/projects/YPlugin/impex.g:171:51: ( Ws )*
            	            loop27:
            	            do {
            	                int alt27=2;
            	                int LA27_0 = input.LA(1);

            	                if ( (LA27_0==Ws) ) {
            	                    alt27=1;
            	                }


            	                switch (alt27) {
            	            	case 1 :
            	            	    // /work/projects/YPlugin/impex.g:171:51: Ws
            	            	    {
            	            	    Ws58=(Token)match(input,Ws,FOLLOW_Ws_in_header1050); 
            	            	    Ws58_tree = 
            	            	    (CommonTree)adaptor.create(Ws58)
            	            	    ;
            	            	    adaptor.addChild(root_0, Ws58_tree);


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop27;
            	                }
            	            } while (true);


            	            // /work/projects/YPlugin/impex.g:171:55: ( simpleAttribute | complexAttribute )
            	            int alt28=2;
            	            int LA28_0 = input.LA(1);

            	            if ( (LA28_0==Word) ) {
            	                alt28=1;
            	            }
            	            else if ( (LA28_0==ComplexArgumentRef) ) {
            	                alt28=2;
            	            }
            	            else {
            	                NoViableAltException nvae =
            	                    new NoViableAltException("", 28, 0, input);

            	                throw nvae;

            	            }
            	            switch (alt28) {
            	                case 1 :
            	                    // /work/projects/YPlugin/impex.g:171:56: simpleAttribute
            	                    {
            	                    pushFollow(FOLLOW_simpleAttribute_in_header1054);
            	                    simpleAttribute59=simpleAttribute();

            	                    state._fsp--;

            	                    adaptor.addChild(root_0, simpleAttribute59.getTree());

            	                    }
            	                    break;
            	                case 2 :
            	                    // /work/projects/YPlugin/impex.g:171:75: complexAttribute
            	                    {
            	                    pushFollow(FOLLOW_complexAttribute_in_header1059);
            	                    complexAttribute60=complexAttribute();

            	                    state._fsp--;

            	                    adaptor.addChild(root_0, complexAttribute60.getTree());

            	                    }
            	                    break;

            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt30 >= 1 ) break loop30;
                        EarlyExitException eee =
                            new EarlyExitException(30, input);
                        throw eee;
                }
                cnt30++;
            } while (true);


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


    public static class row_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "row"
    // /work/projects/YPlugin/impex.g:174:1: row : ( ( Ws )* Semicolon ( ( Ws )* field )? )* ( LineContinuation )? ;
    public final impexParser.row_return row() throws RecognitionException {
        impexParser.row_return retval = new impexParser.row_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token Ws61=null;
        Token Semicolon62=null;
        Token Ws63=null;
        Token LineContinuation65=null;
        impexParser.field_return field64 =null;


        CommonTree Ws61_tree=null;
        CommonTree Semicolon62_tree=null;
        CommonTree Ws63_tree=null;
        CommonTree LineContinuation65_tree=null;

        try {
            // /work/projects/YPlugin/impex.g:175:2: ( ( ( Ws )* Semicolon ( ( Ws )* field )? )* ( LineContinuation )? )
            // /work/projects/YPlugin/impex.g:175:4: ( ( Ws )* Semicolon ( ( Ws )* field )? )* ( LineContinuation )?
            {
            root_0 = (CommonTree)adaptor.nil();


            // /work/projects/YPlugin/impex.g:175:4: ( ( Ws )* Semicolon ( ( Ws )* field )? )*
            loop34:
            do {
                int alt34=2;
                alt34 = dfa34.predict(input);
                switch (alt34) {
            	case 1 :
            	    // /work/projects/YPlugin/impex.g:175:5: ( Ws )* Semicolon ( ( Ws )* field )?
            	    {
            	    // /work/projects/YPlugin/impex.g:175:5: ( Ws )*
            	    loop31:
            	    do {
            	        int alt31=2;
            	        int LA31_0 = input.LA(1);

            	        if ( (LA31_0==Ws) ) {
            	            alt31=1;
            	        }


            	        switch (alt31) {
            	    	case 1 :
            	    	    // /work/projects/YPlugin/impex.g:175:5: Ws
            	    	    {
            	    	    Ws61=(Token)match(input,Ws,FOLLOW_Ws_in_row1077); 
            	    	    Ws61_tree = 
            	    	    (CommonTree)adaptor.create(Ws61)
            	    	    ;
            	    	    adaptor.addChild(root_0, Ws61_tree);


            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop31;
            	        }
            	    } while (true);


            	    Semicolon62=(Token)match(input,Semicolon,FOLLOW_Semicolon_in_row1080); 
            	    Semicolon62_tree = 
            	    (CommonTree)adaptor.create(Semicolon62)
            	    ;
            	    adaptor.addChild(root_0, Semicolon62_tree);


            	    // /work/projects/YPlugin/impex.g:175:19: ( ( Ws )* field )?
            	    int alt33=2;
            	    alt33 = dfa33.predict(input);
            	    switch (alt33) {
            	        case 1 :
            	            // /work/projects/YPlugin/impex.g:175:20: ( Ws )* field
            	            {
            	            // /work/projects/YPlugin/impex.g:175:20: ( Ws )*
            	            loop32:
            	            do {
            	                int alt32=2;
            	                int LA32_0 = input.LA(1);

            	                if ( (LA32_0==Ws) ) {
            	                    alt32=1;
            	                }


            	                switch (alt32) {
            	            	case 1 :
            	            	    // /work/projects/YPlugin/impex.g:175:20: Ws
            	            	    {
            	            	    Ws63=(Token)match(input,Ws,FOLLOW_Ws_in_row1083); 
            	            	    Ws63_tree = 
            	            	    (CommonTree)adaptor.create(Ws63)
            	            	    ;
            	            	    adaptor.addChild(root_0, Ws63_tree);


            	            	    }
            	            	    break;

            	            	default :
            	            	    break loop32;
            	                }
            	            } while (true);


            	            pushFollow(FOLLOW_field_in_row1087);
            	            field64=field();

            	            state._fsp--;

            	            adaptor.addChild(root_0, field64.getTree());

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            // /work/projects/YPlugin/impex.g:175:35: ( LineContinuation )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==LineContinuation) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // /work/projects/YPlugin/impex.g:175:35: LineContinuation
                    {
                    LineContinuation65=(Token)match(input,LineContinuation,FOLLOW_LineContinuation_in_row1093); 
                    LineContinuation65_tree = 
                    (CommonTree)adaptor.create(LineContinuation65)
                    ;
                    adaptor.addChild(root_0, LineContinuation65_tree);


                    }
                    break;

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
    // $ANTLR end "row"


    public static class impexBlock_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "impexBlock"
    // /work/projects/YPlugin/impex.g:179:1: impexBlock : header ( NewLine ( row | Comment ) )* ;
    public final impexParser.impexBlock_return impexBlock() throws RecognitionException {
        impexParser.impexBlock_return retval = new impexParser.impexBlock_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token NewLine67=null;
        Token Comment69=null;
        impexParser.header_return header66 =null;

        impexParser.row_return row68 =null;


        CommonTree NewLine67_tree=null;
        CommonTree Comment69_tree=null;

        try {
            // /work/projects/YPlugin/impex.g:180:2: ( header ( NewLine ( row | Comment ) )* )
            // /work/projects/YPlugin/impex.g:180:4: header ( NewLine ( row | Comment ) )*
            {
            root_0 = (CommonTree)adaptor.nil();


            pushFollow(FOLLOW_header_in_impexBlock1107);
            header66=header();

            state._fsp--;

            adaptor.addChild(root_0, header66.getTree());

            // /work/projects/YPlugin/impex.g:180:11: ( NewLine ( row | Comment ) )*
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==NewLine) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // /work/projects/YPlugin/impex.g:180:12: NewLine ( row | Comment )
            	    {
            	    NewLine67=(Token)match(input,NewLine,FOLLOW_NewLine_in_impexBlock1110); 
            	    NewLine67_tree = 
            	    (CommonTree)adaptor.create(NewLine67)
            	    ;
            	    adaptor.addChild(root_0, NewLine67_tree);


            	    // /work/projects/YPlugin/impex.g:180:20: ( row | Comment )
            	    int alt36=2;
            	    int LA36_0 = input.LA(1);

            	    if ( (LA36_0==EOF||(LA36_0 >= Insert && LA36_0 <= InsertUpdate)||(LA36_0 >= LineContinuation && LA36_0 <= MacroDefinition)||LA36_0==NewLine||LA36_0==Remove||LA36_0==Semicolon||LA36_0==Update||LA36_0==Ws) ) {
            	        alt36=1;
            	    }
            	    else if ( (LA36_0==Comment) ) {
            	        alt36=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 36, 0, input);

            	        throw nvae;

            	    }
            	    switch (alt36) {
            	        case 1 :
            	            // /work/projects/YPlugin/impex.g:180:21: row
            	            {
            	            pushFollow(FOLLOW_row_in_impexBlock1113);
            	            row68=row();

            	            state._fsp--;

            	            adaptor.addChild(root_0, row68.getTree());

            	            }
            	            break;
            	        case 2 :
            	            // /work/projects/YPlugin/impex.g:180:27: Comment
            	            {
            	            Comment69=(Token)match(input,Comment,FOLLOW_Comment_in_impexBlock1117); 
            	            Comment69_tree = 
            	            (CommonTree)adaptor.create(Comment69)
            	            ;
            	            adaptor.addChild(root_0, Comment69_tree);


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);


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
    // $ANTLR end "impexBlock"


    public static class macroExpression_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "macroExpression"
    // /work/projects/YPlugin/impex.g:183:1: macroExpression : ( MacroDefinition | Char )+ ;
    public final impexParser.macroExpression_return macroExpression() throws RecognitionException {
        impexParser.macroExpression_return retval = new impexParser.macroExpression_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token set70=null;

        CommonTree set70_tree=null;

        try {
            // /work/projects/YPlugin/impex.g:184:2: ( ( MacroDefinition | Char )+ )
            // /work/projects/YPlugin/impex.g:184:4: ( MacroDefinition | Char )+
            {
            root_0 = (CommonTree)adaptor.nil();


            // /work/projects/YPlugin/impex.g:184:4: ( MacroDefinition | Char )+
            int cnt38=0;
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==MacroDefinition) ) {
                    int LA38_2 = input.LA(2);

                    if ( (LA38_2==EOF||LA38_2==Char||(LA38_2 >= Insert && LA38_2 <= InsertUpdate)||LA38_2==MacroDefinition||LA38_2==Remove||LA38_2==Update||LA38_2==Ws) ) {
                        alt38=1;
                    }


                }
                else if ( (LA38_0==Char) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // /work/projects/YPlugin/impex.g:
            	    {
            	    set70=(Token)input.LT(1);

            	    if ( input.LA(1)==Char||input.LA(1)==MacroDefinition ) {
            	        input.consume();
            	        adaptor.addChild(root_0, 
            	        (CommonTree)adaptor.create(set70)
            	        );
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt38 >= 1 ) break loop38;
                        EarlyExitException eee =
                            new EarlyExitException(38, input);
                        throw eee;
                }
                cnt38++;
            } while (true);


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
    // $ANTLR end "macroExpression"


    public static class macroAssignement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "macroAssignement"
    // /work/projects/YPlugin/impex.g:187:1: macroAssignement : MacroDefinition Equals macroExpression -> ^( ASSIGNEMENT MacroDefinition macroExpression ) ;
    public final impexParser.macroAssignement_return macroAssignement() throws RecognitionException {
        impexParser.macroAssignement_return retval = new impexParser.macroAssignement_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token MacroDefinition71=null;
        Token Equals72=null;
        impexParser.macroExpression_return macroExpression73 =null;


        CommonTree MacroDefinition71_tree=null;
        CommonTree Equals72_tree=null;
        RewriteRuleTokenStream stream_MacroDefinition=new RewriteRuleTokenStream(adaptor,"token MacroDefinition");
        RewriteRuleTokenStream stream_Equals=new RewriteRuleTokenStream(adaptor,"token Equals");
        RewriteRuleSubtreeStream stream_macroExpression=new RewriteRuleSubtreeStream(adaptor,"rule macroExpression");
        try {
            // /work/projects/YPlugin/impex.g:188:2: ( MacroDefinition Equals macroExpression -> ^( ASSIGNEMENT MacroDefinition macroExpression ) )
            // /work/projects/YPlugin/impex.g:188:4: MacroDefinition Equals macroExpression
            {
            MacroDefinition71=(Token)match(input,MacroDefinition,FOLLOW_MacroDefinition_in_macroAssignement1150);  
            stream_MacroDefinition.add(MacroDefinition71);


            Equals72=(Token)match(input,Equals,FOLLOW_Equals_in_macroAssignement1152);  
            stream_Equals.add(Equals72);


            pushFollow(FOLLOW_macroExpression_in_macroAssignement1154);
            macroExpression73=macroExpression();

            state._fsp--;

            stream_macroExpression.add(macroExpression73.getTree());

            // AST REWRITE
            // elements: macroExpression, MacroDefinition
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 189:2: -> ^( ASSIGNEMENT MacroDefinition macroExpression )
            {
                // /work/projects/YPlugin/impex.g:189:6: ^( ASSIGNEMENT MacroDefinition macroExpression )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot(
                (CommonTree)adaptor.create(ASSIGNEMENT, "ASSIGNEMENT")
                , root_1);

                adaptor.addChild(root_1, 
                stream_MacroDefinition.nextNode()
                );

                adaptor.addChild(root_1, stream_macroExpression.nextTree());

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
    // $ANTLR end "macroAssignement"


    public static class impex_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };


    // $ANTLR start "impex"
    // /work/projects/YPlugin/impex.g:192:1: impex : ( macroAssignement | impexBlock )* EOF ;
    public final impexParser.impex_return impex() throws RecognitionException {
        impexParser.impex_return retval = new impexParser.impex_return();
        retval.start = input.LT(1);


        CommonTree root_0 = null;

        Token EOF76=null;
        impexParser.macroAssignement_return macroAssignement74 =null;

        impexParser.impexBlock_return impexBlock75 =null;


        CommonTree EOF76_tree=null;

        try {
            // /work/projects/YPlugin/impex.g:194:2: ( ( macroAssignement | impexBlock )* EOF )
            // /work/projects/YPlugin/impex.g:194:4: ( macroAssignement | impexBlock )* EOF
            {
            root_0 = (CommonTree)adaptor.nil();


            // /work/projects/YPlugin/impex.g:194:4: ( macroAssignement | impexBlock )*
            loop39:
            do {
                int alt39=3;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==MacroDefinition) ) {
                    alt39=1;
                }
                else if ( ((LA39_0 >= Insert && LA39_0 <= InsertUpdate)||LA39_0==Remove||LA39_0==Update||LA39_0==Ws) ) {
                    alt39=2;
                }


                switch (alt39) {
            	case 1 :
            	    // /work/projects/YPlugin/impex.g:194:6: macroAssignement
            	    {
            	    pushFollow(FOLLOW_macroAssignement_in_impex1184);
            	    macroAssignement74=macroAssignement();

            	    state._fsp--;

            	    adaptor.addChild(root_0, macroAssignement74.getTree());

            	    }
            	    break;
            	case 2 :
            	    // /work/projects/YPlugin/impex.g:194:25: impexBlock
            	    {
            	    pushFollow(FOLLOW_impexBlock_in_impex1188);
            	    impexBlock75=impexBlock();

            	    state._fsp--;

            	    adaptor.addChild(root_0, impexBlock75.getTree());

            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);


            EOF76=(Token)match(input,EOF,FOLLOW_EOF_in_impex1192); 
            EOF76_tree = 
            (CommonTree)adaptor.create(EOF76)
            ;
            adaptor.addChild(root_0, EOF76_tree);


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

    // Delegated rules


    protected DFA7 dfa7 = new DFA7(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA34 dfa34 = new DFA34(this);
    protected DFA33 dfa33 = new DFA33(this);
    static final String DFA7_eotS =
        "\4\uffff";
    static final String DFA7_eofS =
        "\4\uffff";
    static final String DFA7_minS =
        "\2\34\2\uffff";
    static final String DFA7_maxS =
        "\2\60\2\uffff";
    static final String DFA7_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA7_specialS =
        "\4\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\2\13\uffff\1\3\7\uffff\1\1",
            "\1\2\13\uffff\1\3\7\uffff\1\1",
            "",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "152:29: ( ( Ws )* headerModifier )?";
        }
    }
    static final String DFA24_eotS =
        "\4\uffff";
    static final String DFA24_eofS =
        "\1\3\3\uffff";
    static final String DFA24_minS =
        "\2\30\2\uffff";
    static final String DFA24_maxS =
        "\2\60\2\uffff";
    static final String DFA24_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA24_specialS =
        "\4\uffff}>";
    static final String[] DFA24_transitionS = {
            "\2\3\2\uffff\1\2\3\uffff\1\3\1\uffff\1\3\2\uffff\1\3\2\uffff"+
            "\1\3\2\uffff\1\3\4\uffff\1\1",
            "\2\3\2\uffff\1\2\10\uffff\1\3\2\uffff\1\3\2\uffff\1\3\4\uffff"+
            "\1\1",
            "",
            ""
    };

    static final short[] DFA24_eot = DFA.unpackEncodedString(DFA24_eotS);
    static final short[] DFA24_eof = DFA.unpackEncodedString(DFA24_eofS);
    static final char[] DFA24_min = DFA.unpackEncodedStringToUnsignedChars(DFA24_minS);
    static final char[] DFA24_max = DFA.unpackEncodedStringToUnsignedChars(DFA24_maxS);
    static final short[] DFA24_accept = DFA.unpackEncodedString(DFA24_acceptS);
    static final short[] DFA24_special = DFA.unpackEncodedString(DFA24_specialS);
    static final short[][] DFA24_transition;

    static {
        int numStates = DFA24_transitionS.length;
        DFA24_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
        }
    }

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = DFA24_eot;
            this.eof = DFA24_eof;
            this.min = DFA24_min;
            this.max = DFA24_max;
            this.accept = DFA24_accept;
            this.special = DFA24_special;
            this.transition = DFA24_transition;
        }
        public String getDescription() {
            return "168:23: ( ( Ws )* argumentModifier )?";
        }
    }
    static final String DFA30_eotS =
        "\4\uffff";
    static final String DFA30_eofS =
        "\1\1\3\uffff";
    static final String DFA30_minS =
        "\1\30\1\uffff\1\30\1\uffff";
    static final String DFA30_maxS =
        "\1\60\1\uffff\1\60\1\uffff";
    static final String DFA30_acceptS =
        "\1\uffff\1\2\1\uffff\1\1";
    static final String DFA30_specialS =
        "\4\uffff}>";
    static final String[] DFA30_transitionS = {
            "\2\1\6\uffff\1\1\1\uffff\1\1\2\uffff\1\1\2\uffff\1\3\2\uffff"+
            "\1\1\4\uffff\1\2",
            "",
            "\2\1\13\uffff\1\1\2\uffff\1\3\2\uffff\1\1\4\uffff\1\2",
            ""
    };

    static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
    static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
    static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
    static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
    static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
    static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
    static final short[][] DFA30_transition;

    static {
        int numStates = DFA30_transitionS.length;
        DFA30_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = DFA30_eot;
            this.eof = DFA30_eof;
            this.min = DFA30_min;
            this.max = DFA30_max;
            this.accept = DFA30_accept;
            this.special = DFA30_special;
            this.transition = DFA30_transition;
        }
        public String getDescription() {
            return "()+ loopback of 171:34: ( ( Ws )* Semicolon ( ( Ws )* ( simpleAttribute | complexAttribute ) )? )+";
        }
    }
    static final String DFA29_eotS =
        "\4\uffff";
    static final String DFA29_eofS =
        "\1\3\3\uffff";
    static final String DFA29_minS =
        "\2\17\2\uffff";
    static final String DFA29_maxS =
        "\2\60\2\uffff";
    static final String DFA29_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA29_specialS =
        "\4\uffff}>";
    static final String[] DFA29_transitionS = {
            "\1\2\10\uffff\2\3\6\uffff\1\3\1\uffff\1\3\2\uffff\1\3\2\uffff"+
            "\1\3\2\uffff\1\3\1\uffff\1\2\2\uffff\1\1",
            "\1\2\10\uffff\2\3\13\uffff\1\3\2\uffff\1\3\2\uffff\1\3\1\uffff"+
            "\1\2\2\uffff\1\1",
            "",
            ""
    };

    static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
    static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
    static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
    static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
    static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
    static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
    static final short[][] DFA29_transition;

    static {
        int numStates = DFA29_transitionS.length;
        DFA29_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = DFA29_eot;
            this.eof = DFA29_eof;
            this.min = DFA29_min;
            this.max = DFA29_max;
            this.accept = DFA29_accept;
            this.special = DFA29_special;
            this.transition = DFA29_transition;
        }
        public String getDescription() {
            return "171:50: ( ( Ws )* ( simpleAttribute | complexAttribute ) )?";
        }
    }
    static final String DFA34_eotS =
        "\4\uffff";
    static final String DFA34_eofS =
        "\1\1\3\uffff";
    static final String DFA34_minS =
        "\1\30\1\uffff\1\30\1\uffff";
    static final String DFA34_maxS =
        "\1\60\1\uffff\1\60\1\uffff";
    static final String DFA34_acceptS =
        "\1\uffff\1\2\1\uffff\1\1";
    static final String DFA34_specialS =
        "\4\uffff}>";
    static final String[] DFA34_transitionS = {
            "\2\1\5\uffff\2\1\1\uffff\1\1\2\uffff\1\1\2\uffff\1\3\2\uffff"+
            "\1\1\4\uffff\1\2",
            "",
            "\2\1\13\uffff\1\1\2\uffff\1\3\2\uffff\1\1\4\uffff\1\2",
            ""
    };

    static final short[] DFA34_eot = DFA.unpackEncodedString(DFA34_eotS);
    static final short[] DFA34_eof = DFA.unpackEncodedString(DFA34_eofS);
    static final char[] DFA34_min = DFA.unpackEncodedStringToUnsignedChars(DFA34_minS);
    static final char[] DFA34_max = DFA.unpackEncodedStringToUnsignedChars(DFA34_maxS);
    static final short[] DFA34_accept = DFA.unpackEncodedString(DFA34_acceptS);
    static final short[] DFA34_special = DFA.unpackEncodedString(DFA34_specialS);
    static final short[][] DFA34_transition;

    static {
        int numStates = DFA34_transitionS.length;
        DFA34_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA34_transition[i] = DFA.unpackEncodedString(DFA34_transitionS[i]);
        }
    }

    class DFA34 extends DFA {

        public DFA34(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 34;
            this.eot = DFA34_eot;
            this.eof = DFA34_eof;
            this.min = DFA34_min;
            this.max = DFA34_max;
            this.accept = DFA34_accept;
            this.special = DFA34_special;
            this.transition = DFA34_transition;
        }
        public String getDescription() {
            return "()* loopback of 175:4: ( ( Ws )* Semicolon ( ( Ws )* field )? )*";
        }
    }
    static final String DFA33_eotS =
        "\5\uffff";
    static final String DFA33_eofS =
        "\1\4\2\uffff\1\2\1\uffff";
    static final String DFA33_minS =
        "\2\14\1\uffff\1\14\1\uffff";
    static final String DFA33_maxS =
        "\2\60\1\uffff\1\60\1\uffff";
    static final String DFA33_acceptS =
        "\2\uffff\1\1\1\uffff\1\2";
    static final String DFA33_specialS =
        "\5\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\2\5\uffff\1\2\5\uffff\2\4\5\uffff\1\4\1\3\1\uffff\1\4\2\uffff"+
            "\1\4\2\uffff\1\4\2\uffff\1\4\4\uffff\1\1",
            "\1\2\5\uffff\1\2\5\uffff\2\4\6\uffff\1\2\4\uffff\1\4\2\uffff"+
            "\1\4\2\uffff\1\4\4\uffff\1\1",
            "",
            "\1\2\6\uffff\1\4\4\uffff\2\2\5\uffff\2\2\1\uffff\1\2\2\uffff"+
            "\1\2\2\uffff\1\2\2\uffff\1\2\4\uffff\1\2",
            ""
    };

    static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
    static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
    static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
    static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
    static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
    static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
    static final short[][] DFA33_transition;

    static {
        int numStates = DFA33_transitionS.length;
        DFA33_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = DFA33_eot;
            this.eof = DFA33_eof;
            this.min = DFA33_min;
            this.max = DFA33_max;
            this.accept = DFA33_accept;
            this.special = DFA33_special;
            this.transition = DFA33_transition;
        }
        public String getDescription() {
            return "175:19: ( ( Ws )* field )?";
        }
    }
 

    public static final BitSet FOLLOW_DoubleQuote_in_field791 = new BitSet(new long[]{0x0000000500043000L});
    public static final BitSet FOLLOW_Char_in_field794 = new BitSet(new long[]{0x0000000500043000L});
    public static final BitSet FOLLOW_Comma_in_field798 = new BitSet(new long[]{0x0000000500043000L});
    public static final BitSet FOLLOW_DoubleQuote_in_field802 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_DoubleQuote_in_field804 = new BitSet(new long[]{0x0000000500043000L});
    public static final BitSet FOLLOW_NewLine_in_field808 = new BitSet(new long[]{0x0000000500043000L});
    public static final BitSet FOLLOW_MacroDefinition_in_field812 = new BitSet(new long[]{0x0000000500043000L});
    public static final BitSet FOLLOW_DoubleQuote_in_field816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Ws_in_headerModeType863 = new BitSet(new long[]{0x0001082003000000L});
    public static final BitSet FOLLOW_headerMode_in_headerModeType866 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_Ws_in_headerModeType868 = new BitSet(new long[]{0x0001200000000000L});
    public static final BitSet FOLLOW_Word_in_headerModeType871 = new BitSet(new long[]{0x0001000010000002L});
    public static final BitSet FOLLOW_Ws_in_headerModeType875 = new BitSet(new long[]{0x0001000010000000L});
    public static final BitSet FOLLOW_headerModifier_in_headerModeType878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftBracket_in_headerModifier892 = new BitSet(new long[]{0x0000800000000400L});
    public static final BitSet FOLLOW_BoolHeaderModifier_in_headerModifier895 = new BitSet(new long[]{0x0001000000080000L});
    public static final BitSet FOLLOW_Ws_in_headerModifier897 = new BitSet(new long[]{0x0001000000080000L});
    public static final BitSet FOLLOW_Equals_in_headerModifier900 = new BitSet(new long[]{0x0001000000000100L});
    public static final BitSet FOLLOW_Ws_in_headerModifier903 = new BitSet(new long[]{0x0001000000000100L});
    public static final BitSet FOLLOW_Bool_in_headerModifier906 = new BitSet(new long[]{0x0001004000000000L});
    public static final BitSet FOLLOW_WordHeaderModifier_in_headerModifier910 = new BitSet(new long[]{0x0001000000080000L});
    public static final BitSet FOLLOW_Ws_in_headerModifier912 = new BitSet(new long[]{0x0001000000080000L});
    public static final BitSet FOLLOW_Equals_in_headerModifier915 = new BitSet(new long[]{0x0001200000000000L});
    public static final BitSet FOLLOW_Ws_in_headerModifier918 = new BitSet(new long[]{0x0001200000000000L});
    public static final BitSet FOLLOW_Word_in_headerModifier921 = new BitSet(new long[]{0x0001004000000000L});
    public static final BitSet FOLLOW_Ws_in_headerModifier924 = new BitSet(new long[]{0x0001004000000000L});
    public static final BitSet FOLLOW_RightBracket_in_headerModifier928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LeftBracket_in_argumentModifier941 = new BitSet(new long[]{0x0000400008000200L});
    public static final BitSet FOLLOW_BoolAttribModifier_in_argumentModifier944 = new BitSet(new long[]{0x0001000000080000L});
    public static final BitSet FOLLOW_Ws_in_argumentModifier946 = new BitSet(new long[]{0x0001000000080000L});
    public static final BitSet FOLLOW_Equals_in_argumentModifier949 = new BitSet(new long[]{0x0001000000000100L});
    public static final BitSet FOLLOW_Ws_in_argumentModifier951 = new BitSet(new long[]{0x0001000000000100L});
    public static final BitSet FOLLOW_Bool_in_argumentModifier954 = new BitSet(new long[]{0x0001004000000000L});
    public static final BitSet FOLLOW_IntAttribModifier_in_argumentModifier958 = new BitSet(new long[]{0x0001000000080000L});
    public static final BitSet FOLLOW_Ws_in_argumentModifier960 = new BitSet(new long[]{0x0001000000080000L});
    public static final BitSet FOLLOW_Equals_in_argumentModifier963 = new BitSet(new long[]{0x0001000004000000L});
    public static final BitSet FOLLOW_Ws_in_argumentModifier965 = new BitSet(new long[]{0x0001000004000000L});
    public static final BitSet FOLLOW_Int_in_argumentModifier968 = new BitSet(new long[]{0x0001004000000000L});
    public static final BitSet FOLLOW_WordAttribModifier_in_argumentModifier972 = new BitSet(new long[]{0x0001000000080000L});
    public static final BitSet FOLLOW_Ws_in_argumentModifier974 = new BitSet(new long[]{0x0001000000080000L});
    public static final BitSet FOLLOW_Equals_in_argumentModifier977 = new BitSet(new long[]{0x0001200000000000L});
    public static final BitSet FOLLOW_Ws_in_argumentModifier979 = new BitSet(new long[]{0x0001200000000000L});
    public static final BitSet FOLLOW_Word_in_argumentModifier982 = new BitSet(new long[]{0x0001004000000000L});
    public static final BitSet FOLLOW_Ws_in_argumentModifier985 = new BitSet(new long[]{0x0001004000000000L});
    public static final BitSet FOLLOW_RightBracket_in_argumentModifier989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Word_in_simpleAttribute1001 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_argumentModifier_in_simpleAttribute1003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ComplexArgumentRef_in_complexAttribute1015 = new BitSet(new long[]{0x0001000010000002L});
    public static final BitSet FOLLOW_Ws_in_complexAttribute1018 = new BitSet(new long[]{0x0001000010000000L});
    public static final BitSet FOLLOW_argumentModifier_in_complexAttribute1021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_headerModeType_in_header1034 = new BitSet(new long[]{0x0001010000000000L});
    public static final BitSet FOLLOW_Ws_in_header1036 = new BitSet(new long[]{0x0001010000000000L});
    public static final BitSet FOLLOW_Semicolon_in_header1039 = new BitSet(new long[]{0x0001010000000000L});
    public static final BitSet FOLLOW_Ws_in_header1043 = new BitSet(new long[]{0x0001010000000000L});
    public static final BitSet FOLLOW_Semicolon_in_header1046 = new BitSet(new long[]{0x0001210000008002L});
    public static final BitSet FOLLOW_Ws_in_header1050 = new BitSet(new long[]{0x0001200000008000L});
    public static final BitSet FOLLOW_simpleAttribute_in_header1054 = new BitSet(new long[]{0x0001010000000002L});
    public static final BitSet FOLLOW_complexAttribute_in_header1059 = new BitSet(new long[]{0x0001010000000002L});
    public static final BitSet FOLLOW_Ws_in_row1077 = new BitSet(new long[]{0x0001010000000000L});
    public static final BitSet FOLLOW_Semicolon_in_row1080 = new BitSet(new long[]{0x0001010180041002L});
    public static final BitSet FOLLOW_Ws_in_row1083 = new BitSet(new long[]{0x0001000100041000L});
    public static final BitSet FOLLOW_field_in_row1087 = new BitSet(new long[]{0x0001010080000002L});
    public static final BitSet FOLLOW_LineContinuation_in_row1093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_header_in_impexBlock1107 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_NewLine_in_impexBlock1110 = new BitSet(new long[]{0x0001010480004000L});
    public static final BitSet FOLLOW_row_in_impexBlock1113 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_Comment_in_impexBlock1117 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_MacroDefinition_in_macroAssignement1150 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_Equals_in_macroAssignement1152 = new BitSet(new long[]{0x0000000100001000L});
    public static final BitSet FOLLOW_macroExpression_in_macroAssignement1154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_macroAssignement_in_impex1184 = new BitSet(new long[]{0x0001082103000000L});
    public static final BitSet FOLLOW_impexBlock_in_impex1188 = new BitSet(new long[]{0x0001082103000000L});
    public static final BitSet FOLLOW_EOF_in_impex1192 = new BitSet(new long[]{0x0000000000000002L});

}