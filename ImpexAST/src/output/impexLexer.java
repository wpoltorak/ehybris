package output;
// $ANTLR 3.4 /work/projects/YPlugin/impex.g 2012-09-06 21:00:02

  


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class impexLexer extends Lexer {
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
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public impexLexer() {} 
    public impexLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public impexLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/work/projects/YPlugin/impex.g"; }

    // $ANTLR start "Insert"
    public final void mInsert() throws RecognitionException {
        try {
            int _type = Insert;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:28:9: ( 'INSERT' )
            // /work/projects/YPlugin/impex.g:28:10: 'INSERT'
            {
            match("INSERT"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Insert"

    // $ANTLR start "InsertUpdate"
    public final void mInsertUpdate() throws RecognitionException {
        try {
            int _type = InsertUpdate;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:29:14: ( 'INSERT_UPDATE' )
            // /work/projects/YPlugin/impex.g:29:15: 'INSERT_UPDATE'
            {
            match("INSERT_UPDATE"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "InsertUpdate"

    // $ANTLR start "Update"
    public final void mUpdate() throws RecognitionException {
        try {
            int _type = Update;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:30:9: ( 'UPDATE' )
            // /work/projects/YPlugin/impex.g:30:10: 'UPDATE'
            {
            match("UPDATE"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Update"

    // $ANTLR start "Remove"
    public final void mRemove() throws RecognitionException {
        try {
            int _type = Remove;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:31:9: ( 'REMOVE' )
            // /work/projects/YPlugin/impex.g:31:10: 'REMOVE'
            {
            match("REMOVE"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Remove"

    // $ANTLR start "BatchMode"
    public final void mBatchMode() throws RecognitionException {
        try {
            int _type = BatchMode;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:33:12: ( 'batchmode' )
            // /work/projects/YPlugin/impex.g:33:13: 'batchmode'
            {
            match("batchmode"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BatchMode"

    // $ANTLR start "CacheUnique"
    public final void mCacheUnique() throws RecognitionException {
        try {
            int _type = CacheUnique;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:34:13: ( 'cacheUnique' )
            // /work/projects/YPlugin/impex.g:34:14: 'cacheUnique'
            {
            match("cacheUnique"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CacheUnique"

    // $ANTLR start "Processor"
    public final void mProcessor() throws RecognitionException {
        try {
            int _type = Processor;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:35:12: ( 'processor' )
            // /work/projects/YPlugin/impex.g:35:13: 'processor'
            {
            match("processor"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Processor"

    // $ANTLR start "Alias"
    public final void mAlias() throws RecognitionException {
        try {
            int _type = Alias;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:37:8: ( 'alias' )
            // /work/projects/YPlugin/impex.g:37:9: 'alias'
            {
            match("alias"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Alias"

    // $ANTLR start "AllowNull"
    public final void mAllowNull() throws RecognitionException {
        try {
            int _type = AllowNull;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:38:12: ( 'allownull' )
            // /work/projects/YPlugin/impex.g:38:13: 'allownull'
            {
            match("allownull"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "AllowNull"

    // $ANTLR start "ForceWrite"
    public final void mForceWrite() throws RecognitionException {
        try {
            int _type = ForceWrite;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:39:13: ( 'forceWrite' )
            // /work/projects/YPlugin/impex.g:39:14: 'forceWrite'
            {
            match("forceWrite"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ForceWrite"

    // $ANTLR start "IgnoreKeyCase"
    public final void mIgnoreKeyCase() throws RecognitionException {
        try {
            int _type = IgnoreKeyCase;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:40:15: ( 'ignoreKeyCase' )
            // /work/projects/YPlugin/impex.g:40:16: 'ignoreKeyCase'
            {
            match("ignoreKeyCase"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IgnoreKeyCase"

    // $ANTLR start "IgnoreNull"
    public final void mIgnoreNull() throws RecognitionException {
        try {
            int _type = IgnoreNull;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:41:13: ( 'ignorenull' )
            // /work/projects/YPlugin/impex.g:41:14: 'ignorenull'
            {
            match("ignorenull"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IgnoreNull"

    // $ANTLR start "Unique"
    public final void mUnique() throws RecognitionException {
        try {
            int _type = Unique;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:42:9: ( 'unique' )
            // /work/projects/YPlugin/impex.g:42:10: 'unique'
            {
            match("unique"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Unique"

    // $ANTLR start "Virtual"
    public final void mVirtual() throws RecognitionException {
        try {
            int _type = Virtual;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:43:10: ( 'virtual' )
            // /work/projects/YPlugin/impex.g:43:11: 'virtual'
            {
            match("virtual"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Virtual"

    // $ANTLR start "Pos"
    public final void mPos() throws RecognitionException {
        try {
            int _type = Pos;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:44:6: ( 'pos' )
            // /work/projects/YPlugin/impex.g:44:7: 'pos'
            {
            match("pos"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Pos"

    // $ANTLR start "Dollar"
    public final void mDollar() throws RecognitionException {
        try {
            int _type = Dollar;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:46:9: ( '$' )
            // /work/projects/YPlugin/impex.g:46:10: '$'
            {
            match('$'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Dollar"

    // $ANTLR start "Semicolon"
    public final void mSemicolon() throws RecognitionException {
        try {
            int _type = Semicolon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:47:12: ( ';' )
            // /work/projects/YPlugin/impex.g:47:13: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Semicolon"

    // $ANTLR start "RightBracket"
    public final void mRightBracket() throws RecognitionException {
        try {
            int _type = RightBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:48:14: ( ']' )
            // /work/projects/YPlugin/impex.g:48:15: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RightBracket"

    // $ANTLR start "LeftBracket"
    public final void mLeftBracket() throws RecognitionException {
        try {
            int _type = LeftBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:49:14: ( '[' )
            // /work/projects/YPlugin/impex.g:49:15: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LeftBracket"

    // $ANTLR start "LeftParenthesis"
    public final void mLeftParenthesis() throws RecognitionException {
        try {
            int _type = LeftParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:50:18: ( '(' )
            // /work/projects/YPlugin/impex.g:50:19: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LeftParenthesis"

    // $ANTLR start "RightParenthesis"
    public final void mRightParenthesis() throws RecognitionException {
        try {
            int _type = RightParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:51:18: ( ')' )
            // /work/projects/YPlugin/impex.g:51:19: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "RightParenthesis"

    // $ANTLR start "Equals"
    public final void mEquals() throws RecognitionException {
        try {
            int _type = Equals;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:52:9: ( '=' )
            // /work/projects/YPlugin/impex.g:52:10: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Equals"

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:53:8: ( ',' )
            // /work/projects/YPlugin/impex.g:53:10: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Comma"

    // $ANTLR start "Underscore"
    public final void mUnderscore() throws RecognitionException {
        try {
            int _type = Underscore;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:54:13: ( '_' )
            // /work/projects/YPlugin/impex.g:54:14: '_'
            {
            match('_'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Underscore"

    // $ANTLR start "Hash"
    public final void mHash() throws RecognitionException {
        try {
            int _type = Hash;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:55:7: ( '#' )
            // /work/projects/YPlugin/impex.g:55:8: '#'
            {
            match('#'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Hash"

    // $ANTLR start "LineContinuation"
    public final void mLineContinuation() throws RecognitionException {
        try {
            int _type = LineContinuation;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:58:2: ( ( Ws )* '\\u2216 \\u2216' ( Ws )* )
            // /work/projects/YPlugin/impex.g:58:4: ( Ws )* '\\u2216 \\u2216' ( Ws )*
            {
            // /work/projects/YPlugin/impex.g:58:4: ( Ws )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0=='\t'||LA1_0==' ') ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /work/projects/YPlugin/impex.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            match("\u2216 \u2216"); 



            // /work/projects/YPlugin/impex.g:58:24: ( Ws )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='\t'||LA2_0==' ') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /work/projects/YPlugin/impex.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LineContinuation"

    // $ANTLR start "Bool"
    public final void mBool() throws RecognitionException {
        try {
            int _type = Bool;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:62:2: ( 'true' | 'false' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='t') ) {
                alt3=1;
            }
            else if ( (LA3_0=='f') ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // /work/projects/YPlugin/impex.g:62:4: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // /work/projects/YPlugin/impex.g:62:13: 'false'
                    {
                    match("false"); 



                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Bool"

    // $ANTLR start "Comment"
    public final void mComment() throws RecognitionException {
        try {
            int _type = Comment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:66:2: ( Hash ( '\\u0000' .. '\\uffff' )* )
            // /work/projects/YPlugin/impex.g:66:4: Hash ( '\\u0000' .. '\\uffff' )*
            {
            mHash(); 


            // /work/projects/YPlugin/impex.g:66:9: ( '\\u0000' .. '\\uffff' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '\u0000' && LA4_0 <= '\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /work/projects/YPlugin/impex.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\uFFFF') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Comment"

    // $ANTLR start "Ws"
    public final void mWs() throws RecognitionException {
        try {
            // /work/projects/YPlugin/impex.g:75:2: ( '\\u0020' | '\\u0009' )
            // /work/projects/YPlugin/impex.g:
            {
            if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Ws"

    // $ANTLR start "NewLine"
    public final void mNewLine() throws RecognitionException {
        try {
            // /work/projects/YPlugin/impex.g:79:2: ( ( '\\u000d' )? '\\u000a' | '\\u000d' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\r') ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1=='\n') ) {
                    alt6=1;
                }
                else {
                    alt6=2;
                }
            }
            else if ( (LA6_0=='\n') ) {
                alt6=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;

            }
            switch (alt6) {
                case 1 :
                    // /work/projects/YPlugin/impex.g:79:4: ( '\\u000d' )? '\\u000a'
                    {
                    // /work/projects/YPlugin/impex.g:79:4: ( '\\u000d' )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0=='\r') ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // /work/projects/YPlugin/impex.g:79:4: '\\u000d'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    }
                    break;
                case 2 :
                    // /work/projects/YPlugin/impex.g:80:4: '\\u000d'
                    {
                    match('\r'); 

                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NewLine"

    // $ANTLR start "Word"
    public final void mWord() throws RecognitionException {
        try {
            int _type = Word;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:84:2: ( ( Letter )+ )
            // /work/projects/YPlugin/impex.g:84:4: ( Letter )+
            {
            // /work/projects/YPlugin/impex.g:84:4: ( Letter )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= 'A' && LA7_0 <= 'Z')||(LA7_0 >= 'a' && LA7_0 <= 'z')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // /work/projects/YPlugin/impex.g:
            	    {
            	    if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Word"

    // $ANTLR start "Letter"
    public final void mLetter() throws RecognitionException {
        try {
            // /work/projects/YPlugin/impex.g:88:2: ( 'a' .. 'z' | 'A' .. 'Z' )
            // /work/projects/YPlugin/impex.g:
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Letter"

    // $ANTLR start "DoubleQuote"
    public final void mDoubleQuote() throws RecognitionException {
        try {
            // /work/projects/YPlugin/impex.g:91:2: ( '\"' )
            // /work/projects/YPlugin/impex.g:91:4: '\"'
            {
            match('\"'); 

            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DoubleQuote"

    // $ANTLR start "Int"
    public final void mInt() throws RecognitionException {
        try {
            // /work/projects/YPlugin/impex.g:95:4: ( '1' .. '9' ( Digit )* | '0' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0 >= '1' && LA9_0 <= '9')) ) {
                alt9=1;
            }
            else if ( (LA9_0=='0') ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // /work/projects/YPlugin/impex.g:95:8: '1' .. '9' ( Digit )*
                    {
                    matchRange('1','9'); 

                    // /work/projects/YPlugin/impex.g:95:17: ( Digit )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( ((LA8_0 >= '0' && LA8_0 <= '9')) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // /work/projects/YPlugin/impex.g:
                    	    {
                    	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                    	        input.consume();
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // /work/projects/YPlugin/impex.g:96:7: '0'
                    {
                    match('0'); 

                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Int"

    // $ANTLR start "Digit"
    public final void mDigit() throws RecognitionException {
        try {
            // /work/projects/YPlugin/impex.g:100:4: ( '0' .. '9' )
            // /work/projects/YPlugin/impex.g:
            {
            if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Digit"

    // $ANTLR start "Char"
    public final void mChar() throws RecognitionException {
        try {
            int _type = Char;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:104:2: ( '\\u0000' .. '\\u0009' | '\\u000b' .. '\\u000c' | '\\u000e' .. '\\u0021' | '\\u0023' | '\\u0025' .. '\\u003a' | '\\u003c' .. '\\uffff' )
            // /work/projects/YPlugin/impex.g:
            {
            if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '!')||input.LA(1)=='#'||(input.LA(1) >= '%' && input.LA(1) <= ':')||(input.LA(1) >= '<' && input.LA(1) <= '\uFFFF') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Char"

    // $ANTLR start "ComplexArgumentRef"
    public final void mComplexArgumentRef() throws RecognitionException {
        try {
            // /work/projects/YPlugin/impex.g:113:2: ( Word ( Ws )* LeftParenthesis ( Ws )* Word ( ( '.' Word )? | ( ComplexArgumentRef ( ( Ws )* Comma ( Ws )* ( Word | ComplexArgumentRef ) )? ) ) ( Ws )* RightParenthesis ( Ws )* )
            // /work/projects/YPlugin/impex.g:113:4: Word ( Ws )* LeftParenthesis ( Ws )* Word ( ( '.' Word )? | ( ComplexArgumentRef ( ( Ws )* Comma ( Ws )* ( Word | ComplexArgumentRef ) )? ) ) ( Ws )* RightParenthesis ( Ws )*
            {
            mWord(); 


            // /work/projects/YPlugin/impex.g:113:9: ( Ws )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='\t'||LA10_0==' ') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /work/projects/YPlugin/impex.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            mLeftParenthesis(); 


            // /work/projects/YPlugin/impex.g:113:29: ( Ws )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='\t'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /work/projects/YPlugin/impex.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            mWord(); 


            // /work/projects/YPlugin/impex.g:113:38: ( ( '.' Word )? | ( ComplexArgumentRef ( ( Ws )* Comma ( Ws )* ( Word | ComplexArgumentRef ) )? ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='\t'||LA17_0==' '||LA17_0==')'||LA17_0=='.') ) {
                alt17=1;
            }
            else if ( ((LA17_0 >= 'A' && LA17_0 <= 'Z')||(LA17_0 >= 'a' && LA17_0 <= 'z')) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }
            switch (alt17) {
                case 1 :
                    // /work/projects/YPlugin/impex.g:113:39: ( '.' Word )?
                    {
                    // /work/projects/YPlugin/impex.g:113:39: ( '.' Word )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='.') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /work/projects/YPlugin/impex.g:113:40: '.' Word
                            {
                            match('.'); 

                            mWord(); 


                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // /work/projects/YPlugin/impex.g:113:53: ( ComplexArgumentRef ( ( Ws )* Comma ( Ws )* ( Word | ComplexArgumentRef ) )? )
                    {
                    // /work/projects/YPlugin/impex.g:113:53: ( ComplexArgumentRef ( ( Ws )* Comma ( Ws )* ( Word | ComplexArgumentRef ) )? )
                    // /work/projects/YPlugin/impex.g:113:54: ComplexArgumentRef ( ( Ws )* Comma ( Ws )* ( Word | ComplexArgumentRef ) )?
                    {
                    mComplexArgumentRef(); 


                    // /work/projects/YPlugin/impex.g:113:73: ( ( Ws )* Comma ( Ws )* ( Word | ComplexArgumentRef ) )?
                    int alt16=2;
                    alt16 = dfa16.predict(input);
                    switch (alt16) {
                        case 1 :
                            // /work/projects/YPlugin/impex.g:113:74: ( Ws )* Comma ( Ws )* ( Word | ComplexArgumentRef )
                            {
                            // /work/projects/YPlugin/impex.g:113:74: ( Ws )*
                            loop13:
                            do {
                                int alt13=2;
                                int LA13_0 = input.LA(1);

                                if ( (LA13_0=='\t'||LA13_0==' ') ) {
                                    alt13=1;
                                }


                                switch (alt13) {
                            	case 1 :
                            	    // /work/projects/YPlugin/impex.g:
                            	    {
                            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
                            	        input.consume();
                            	    }
                            	    else {
                            	        MismatchedSetException mse = new MismatchedSetException(null,input);
                            	        recover(mse);
                            	        throw mse;
                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop13;
                                }
                            } while (true);


                            mComma(); 


                            // /work/projects/YPlugin/impex.g:113:84: ( Ws )*
                            loop14:
                            do {
                                int alt14=2;
                                int LA14_0 = input.LA(1);

                                if ( (LA14_0=='\t'||LA14_0==' ') ) {
                                    alt14=1;
                                }


                                switch (alt14) {
                            	case 1 :
                            	    // /work/projects/YPlugin/impex.g:
                            	    {
                            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
                            	        input.consume();
                            	    }
                            	    else {
                            	        MismatchedSetException mse = new MismatchedSetException(null,input);
                            	        recover(mse);
                            	        throw mse;
                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop14;
                                }
                            } while (true);


                            // /work/projects/YPlugin/impex.g:113:88: ( Word | ComplexArgumentRef )
                            int alt15=2;
                            alt15 = dfa15.predict(input);
                            switch (alt15) {
                                case 1 :
                                    // /work/projects/YPlugin/impex.g:113:89: Word
                                    {
                                    mWord(); 


                                    }
                                    break;
                                case 2 :
                                    // /work/projects/YPlugin/impex.g:113:96: ComplexArgumentRef
                                    {
                                    mComplexArgumentRef(); 


                                    }
                                    break;

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            // /work/projects/YPlugin/impex.g:113:120: ( Ws )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0=='\t'||LA18_0==' ') ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // /work/projects/YPlugin/impex.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            mRightParenthesis(); 


            // /work/projects/YPlugin/impex.g:113:141: ( Ws )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0=='\t'||LA19_0==' ') ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // /work/projects/YPlugin/impex.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ComplexArgumentRef"

    // $ANTLR start "BoolHeaderModifier"
    public final void mBoolHeaderModifier() throws RecognitionException {
        try {
            // /work/projects/YPlugin/impex.g:117:2: ( BatchMode | CacheUnique )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0=='b') ) {
                alt20=1;
            }
            else if ( (LA20_0=='c') ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;

            }
            switch (alt20) {
                case 1 :
                    // /work/projects/YPlugin/impex.g:117:4: BatchMode
                    {
                    mBatchMode(); 


                    }
                    break;
                case 2 :
                    // /work/projects/YPlugin/impex.g:117:16: CacheUnique
                    {
                    mCacheUnique(); 


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BoolHeaderModifier"

    // $ANTLR start "WordHeaderModifier"
    public final void mWordHeaderModifier() throws RecognitionException {
        try {
            // /work/projects/YPlugin/impex.g:121:2: ( Processor )
            // /work/projects/YPlugin/impex.g:121:4: Processor
            {
            mProcessor(); 


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WordHeaderModifier"

    // $ANTLR start "BoolAttribModifier"
    public final void mBoolAttribModifier() throws RecognitionException {
        try {
            // /work/projects/YPlugin/impex.g:124:2: ( AllowNull | ForceWrite | IgnoreKeyCase | IgnoreNull | Unique | Virtual )
            int alt21=6;
            switch ( input.LA(1) ) {
            case 'a':
                {
                alt21=1;
                }
                break;
            case 'f':
                {
                alt21=2;
                }
                break;
            case 'i':
                {
                int LA21_3 = input.LA(2);

                if ( (LA21_3=='g') ) {
                    int LA21_6 = input.LA(3);

                    if ( (LA21_6=='n') ) {
                        int LA21_7 = input.LA(4);

                        if ( (LA21_7=='o') ) {
                            int LA21_8 = input.LA(5);

                            if ( (LA21_8=='r') ) {
                                int LA21_9 = input.LA(6);

                                if ( (LA21_9=='e') ) {
                                    int LA21_10 = input.LA(7);

                                    if ( (LA21_10=='K') ) {
                                        alt21=3;
                                    }
                                    else if ( (LA21_10=='n') ) {
                                        alt21=4;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 21, 10, input);

                                        throw nvae;

                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 21, 9, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 21, 8, input);

                                throw nvae;

                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 21, 7, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 21, 6, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 3, input);

                    throw nvae;

                }
                }
                break;
            case 'u':
                {
                alt21=5;
                }
                break;
            case 'v':
                {
                alt21=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;

            }

            switch (alt21) {
                case 1 :
                    // /work/projects/YPlugin/impex.g:124:4: AllowNull
                    {
                    mAllowNull(); 


                    }
                    break;
                case 2 :
                    // /work/projects/YPlugin/impex.g:124:16: ForceWrite
                    {
                    mForceWrite(); 


                    }
                    break;
                case 3 :
                    // /work/projects/YPlugin/impex.g:124:29: IgnoreKeyCase
                    {
                    mIgnoreKeyCase(); 


                    }
                    break;
                case 4 :
                    // /work/projects/YPlugin/impex.g:124:45: IgnoreNull
                    {
                    mIgnoreNull(); 


                    }
                    break;
                case 5 :
                    // /work/projects/YPlugin/impex.g:124:58: Unique
                    {
                    mUnique(); 


                    }
                    break;
                case 6 :
                    // /work/projects/YPlugin/impex.g:124:67: Virtual
                    {
                    mVirtual(); 


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "BoolAttribModifier"

    // $ANTLR start "WordAttribModifier"
    public final void mWordAttribModifier() throws RecognitionException {
        try {
            // /work/projects/YPlugin/impex.g:128:2: ( Alias | 'cellDecorator' | 'collection-delimiter' | 'dateformat' | 'default' | 'key2value-delimiter' | 'lang' | 'map-delimiter' | 'mode' | 'numberformat' | 'path-delimiter' | 'translator' )
            int alt22=12;
            switch ( input.LA(1) ) {
            case 'a':
                {
                alt22=1;
                }
                break;
            case 'c':
                {
                int LA22_2 = input.LA(2);

                if ( (LA22_2=='e') ) {
                    alt22=2;
                }
                else if ( (LA22_2=='o') ) {
                    alt22=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 2, input);

                    throw nvae;

                }
                }
                break;
            case 'd':
                {
                int LA22_3 = input.LA(2);

                if ( (LA22_3=='a') ) {
                    alt22=4;
                }
                else if ( (LA22_3=='e') ) {
                    alt22=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 3, input);

                    throw nvae;

                }
                }
                break;
            case 'k':
                {
                alt22=6;
                }
                break;
            case 'l':
                {
                alt22=7;
                }
                break;
            case 'm':
                {
                int LA22_6 = input.LA(2);

                if ( (LA22_6=='a') ) {
                    alt22=8;
                }
                else if ( (LA22_6=='o') ) {
                    alt22=9;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 6, input);

                    throw nvae;

                }
                }
                break;
            case 'n':
                {
                alt22=10;
                }
                break;
            case 'p':
                {
                alt22=11;
                }
                break;
            case 't':
                {
                alt22=12;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;

            }

            switch (alt22) {
                case 1 :
                    // /work/projects/YPlugin/impex.g:128:4: Alias
                    {
                    mAlias(); 


                    }
                    break;
                case 2 :
                    // /work/projects/YPlugin/impex.g:128:13: 'cellDecorator'
                    {
                    match("cellDecorator"); 



                    }
                    break;
                case 3 :
                    // /work/projects/YPlugin/impex.g:128:31: 'collection-delimiter'
                    {
                    match("collection-delimiter"); 



                    }
                    break;
                case 4 :
                    // /work/projects/YPlugin/impex.g:128:56: 'dateformat'
                    {
                    match("dateformat"); 



                    }
                    break;
                case 5 :
                    // /work/projects/YPlugin/impex.g:128:71: 'default'
                    {
                    match("default"); 



                    }
                    break;
                case 6 :
                    // /work/projects/YPlugin/impex.g:128:84: 'key2value-delimiter'
                    {
                    match("key2value-delimiter"); 



                    }
                    break;
                case 7 :
                    // /work/projects/YPlugin/impex.g:128:108: 'lang'
                    {
                    match("lang"); 



                    }
                    break;
                case 8 :
                    // /work/projects/YPlugin/impex.g:129:4: 'map-delimiter'
                    {
                    match("map-delimiter"); 



                    }
                    break;
                case 9 :
                    // /work/projects/YPlugin/impex.g:129:22: 'mode'
                    {
                    match("mode"); 



                    }
                    break;
                case 10 :
                    // /work/projects/YPlugin/impex.g:129:31: 'numberformat'
                    {
                    match("numberformat"); 



                    }
                    break;
                case 11 :
                    // /work/projects/YPlugin/impex.g:129:48: 'path-delimiter'
                    {
                    match("path-delimiter"); 



                    }
                    break;
                case 12 :
                    // /work/projects/YPlugin/impex.g:129:67: 'translator'
                    {
                    match("translator"); 



                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "WordAttribModifier"

    // $ANTLR start "IntAttribModifier"
    public final void mIntAttribModifier() throws RecognitionException {
        try {
            // /work/projects/YPlugin/impex.g:133:2: ( Pos )
            // /work/projects/YPlugin/impex.g:133:4: Pos
            {
            mPos(); 


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "IntAttribModifier"

    // $ANTLR start "MacroIdentifier"
    public final void mMacroIdentifier() throws RecognitionException {
        try {
            int _type = MacroIdentifier;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:137:2: ( ( Letter | Underscore ) ( Digit | Letter | Underscore )* )
            // /work/projects/YPlugin/impex.g:137:4: ( Letter | Underscore ) ( Digit | Letter | Underscore )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /work/projects/YPlugin/impex.g:137:25: ( Digit | Letter | Underscore )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0 >= '0' && LA23_0 <= '9')||(LA23_0 >= 'A' && LA23_0 <= 'Z')||LA23_0=='_'||(LA23_0 >= 'a' && LA23_0 <= 'z')) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /work/projects/YPlugin/impex.g:
            	    {
            	    if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
            	        input.consume();
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MacroIdentifier"

    // $ANTLR start "MacroDefinition"
    public final void mMacroDefinition() throws RecognitionException {
        try {
            int _type = MacroDefinition;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/YPlugin/impex.g:141:2: ( Dollar MacroIdentifier )
            // /work/projects/YPlugin/impex.g:141:4: Dollar MacroIdentifier
            {
            mDollar(); 


            mMacroIdentifier(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MacroDefinition"

    public void mTokens() throws RecognitionException {
        // /work/projects/YPlugin/impex.g:1:8: ( Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | ForceWrite | IgnoreKeyCase | IgnoreNull | Unique | Virtual | Pos | Dollar | Semicolon | RightBracket | LeftBracket | LeftParenthesis | RightParenthesis | Equals | Comma | Underscore | Hash | LineContinuation | Bool | Comment | Word | Char | MacroIdentifier | MacroDefinition )
        int alt24=32;
        alt24 = dfa24.predict(input);
        switch (alt24) {
            case 1 :
                // /work/projects/YPlugin/impex.g:1:10: Insert
                {
                mInsert(); 


                }
                break;
            case 2 :
                // /work/projects/YPlugin/impex.g:1:17: InsertUpdate
                {
                mInsertUpdate(); 


                }
                break;
            case 3 :
                // /work/projects/YPlugin/impex.g:1:30: Update
                {
                mUpdate(); 


                }
                break;
            case 4 :
                // /work/projects/YPlugin/impex.g:1:37: Remove
                {
                mRemove(); 


                }
                break;
            case 5 :
                // /work/projects/YPlugin/impex.g:1:44: BatchMode
                {
                mBatchMode(); 


                }
                break;
            case 6 :
                // /work/projects/YPlugin/impex.g:1:54: CacheUnique
                {
                mCacheUnique(); 


                }
                break;
            case 7 :
                // /work/projects/YPlugin/impex.g:1:66: Processor
                {
                mProcessor(); 


                }
                break;
            case 8 :
                // /work/projects/YPlugin/impex.g:1:76: Alias
                {
                mAlias(); 


                }
                break;
            case 9 :
                // /work/projects/YPlugin/impex.g:1:82: AllowNull
                {
                mAllowNull(); 


                }
                break;
            case 10 :
                // /work/projects/YPlugin/impex.g:1:92: ForceWrite
                {
                mForceWrite(); 


                }
                break;
            case 11 :
                // /work/projects/YPlugin/impex.g:1:103: IgnoreKeyCase
                {
                mIgnoreKeyCase(); 


                }
                break;
            case 12 :
                // /work/projects/YPlugin/impex.g:1:117: IgnoreNull
                {
                mIgnoreNull(); 


                }
                break;
            case 13 :
                // /work/projects/YPlugin/impex.g:1:128: Unique
                {
                mUnique(); 


                }
                break;
            case 14 :
                // /work/projects/YPlugin/impex.g:1:135: Virtual
                {
                mVirtual(); 


                }
                break;
            case 15 :
                // /work/projects/YPlugin/impex.g:1:143: Pos
                {
                mPos(); 


                }
                break;
            case 16 :
                // /work/projects/YPlugin/impex.g:1:147: Dollar
                {
                mDollar(); 


                }
                break;
            case 17 :
                // /work/projects/YPlugin/impex.g:1:154: Semicolon
                {
                mSemicolon(); 


                }
                break;
            case 18 :
                // /work/projects/YPlugin/impex.g:1:164: RightBracket
                {
                mRightBracket(); 


                }
                break;
            case 19 :
                // /work/projects/YPlugin/impex.g:1:177: LeftBracket
                {
                mLeftBracket(); 


                }
                break;
            case 20 :
                // /work/projects/YPlugin/impex.g:1:189: LeftParenthesis
                {
                mLeftParenthesis(); 


                }
                break;
            case 21 :
                // /work/projects/YPlugin/impex.g:1:205: RightParenthesis
                {
                mRightParenthesis(); 


                }
                break;
            case 22 :
                // /work/projects/YPlugin/impex.g:1:222: Equals
                {
                mEquals(); 


                }
                break;
            case 23 :
                // /work/projects/YPlugin/impex.g:1:229: Comma
                {
                mComma(); 


                }
                break;
            case 24 :
                // /work/projects/YPlugin/impex.g:1:235: Underscore
                {
                mUnderscore(); 


                }
                break;
            case 25 :
                // /work/projects/YPlugin/impex.g:1:246: Hash
                {
                mHash(); 


                }
                break;
            case 26 :
                // /work/projects/YPlugin/impex.g:1:251: LineContinuation
                {
                mLineContinuation(); 


                }
                break;
            case 27 :
                // /work/projects/YPlugin/impex.g:1:268: Bool
                {
                mBool(); 


                }
                break;
            case 28 :
                // /work/projects/YPlugin/impex.g:1:273: Comment
                {
                mComment(); 


                }
                break;
            case 29 :
                // /work/projects/YPlugin/impex.g:1:281: Word
                {
                mWord(); 


                }
                break;
            case 30 :
                // /work/projects/YPlugin/impex.g:1:286: Char
                {
                mChar(); 


                }
                break;
            case 31 :
                // /work/projects/YPlugin/impex.g:1:291: MacroIdentifier
                {
                mMacroIdentifier(); 


                }
                break;
            case 32 :
                // /work/projects/YPlugin/impex.g:1:307: MacroDefinition
                {
                mMacroDefinition(); 


                }
                break;

        }

    }


    protected DFA16 dfa16 = new DFA16(this);
    protected DFA15 dfa15 = new DFA15(this);
    protected DFA24 dfa24 = new DFA24(this);
    static final String DFA16_eotS =
        "\4\uffff";
    static final String DFA16_eofS =
        "\4\uffff";
    static final String DFA16_minS =
        "\2\11\2\uffff";
    static final String DFA16_maxS =
        "\2\54\2\uffff";
    static final String DFA16_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA16_specialS =
        "\4\uffff}>";
    static final String[] DFA16_transitionS = {
            "\1\1\26\uffff\1\1\10\uffff\1\3\2\uffff\1\2",
            "\1\1\26\uffff\1\1\10\uffff\1\3\2\uffff\1\2",
            "",
            ""
    };

    static final short[] DFA16_eot = DFA.unpackEncodedString(DFA16_eotS);
    static final short[] DFA16_eof = DFA.unpackEncodedString(DFA16_eofS);
    static final char[] DFA16_min = DFA.unpackEncodedStringToUnsignedChars(DFA16_minS);
    static final char[] DFA16_max = DFA.unpackEncodedStringToUnsignedChars(DFA16_maxS);
    static final short[] DFA16_accept = DFA.unpackEncodedString(DFA16_acceptS);
    static final short[] DFA16_special = DFA.unpackEncodedString(DFA16_specialS);
    static final short[][] DFA16_transition;

    static {
        int numStates = DFA16_transitionS.length;
        DFA16_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA16_transition[i] = DFA.unpackEncodedString(DFA16_transitionS[i]);
        }
    }

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = DFA16_eot;
            this.eof = DFA16_eof;
            this.min = DFA16_min;
            this.max = DFA16_max;
            this.accept = DFA16_accept;
            this.special = DFA16_special;
            this.transition = DFA16_transition;
        }
        public String getDescription() {
            return "113:73: ( ( Ws )* Comma ( Ws )* ( Word | ComplexArgumentRef ) )?";
        }
    }
    static final String DFA15_eotS =
        "\5\uffff";
    static final String DFA15_eofS =
        "\5\uffff";
    static final String DFA15_minS =
        "\1\101\2\11\2\uffff";
    static final String DFA15_maxS =
        "\2\172\1\51\2\uffff";
    static final String DFA15_acceptS =
        "\3\uffff\1\1\1\2";
    static final String DFA15_specialS =
        "\5\uffff}>";
    static final String[] DFA15_transitionS = {
            "\32\1\6\uffff\32\1",
            "\1\2\26\uffff\1\2\7\uffff\1\4\1\3\27\uffff\32\1\6\uffff\32"+
            "\1",
            "\1\2\26\uffff\1\2\7\uffff\1\4\1\3",
            "",
            ""
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "113:88: ( Word | ComplexArgumentRef )";
        }
    }
    static final String DFA24_eotS =
        "\1\uffff\13\34\1\53\7\uffff\1\63\1\64\2\32\2\34\1\uffff\1\34\1\uffff"+
        "\1\34\1\uffff\14\34\14\uffff\7\34\1\115\16\34\1\uffff\7\34\1\143"+
        "\6\34\1\152\2\34\1\143\3\34\1\uffff\1\161\1\162\1\163\3\34\1\uffff"+
        "\3\34\1\173\1\34\1\36\3\uffff\7\34\1\uffff\1\u0085\1\36\7\34\1\uffff"+
        "\1\36\1\u008f\1\34\1\u0091\1\u0092\3\34\1\36\1\uffff\1\34\2\uffff"+
        "\1\u0098\1\34\1\u009a\1\36\1\u009c\1\uffff\1\34\1\uffff\1\36\1\uffff"+
        "\1\34\1\u00a0\1\u00a1\2\uffff";
    static final String DFA24_eofS =
        "\u00a2\uffff";
    static final String DFA24_minS =
        "\1\0\13\60\1\101\7\uffff\1\60\1\0\1\11\1\40\2\60\1\uffff\1\60\1"+
        "\uffff\1\60\1\uffff\14\60\14\uffff\26\60\1\uffff\25\60\1\uffff\6"+
        "\60\1\uffff\5\60\1\125\3\uffff\7\60\1\uffff\1\60\1\120\7\60\1\uffff"+
        "\1\104\7\60\1\101\1\uffff\1\60\2\uffff\3\60\1\124\1\60\1\uffff\1"+
        "\60\1\uffff\1\105\1\uffff\3\60\2\uffff";
    static final String DFA24_maxS =
        "\1\uffff\14\172\7\uffff\1\172\1\uffff\1\u2216\1\40\2\172\1\uffff"+
        "\1\172\1\uffff\1\172\1\uffff\14\172\14\uffff\26\172\1\uffff\25\172"+
        "\1\uffff\6\172\1\uffff\5\172\1\125\3\uffff\7\172\1\uffff\1\172\1"+
        "\120\7\172\1\uffff\1\104\7\172\1\101\1\uffff\1\172\2\uffff\3\172"+
        "\1\124\1\172\1\uffff\1\172\1\uffff\1\105\1\uffff\3\172\2\uffff";
    static final String DFA24_acceptS =
        "\15\uffff\1\21\1\22\1\23\1\24\1\25\1\26\1\27\6\uffff\1\36\1\uffff"+
        "\1\35\1\uffff\1\37\14\uffff\1\20\1\40\1\22\1\23\1\24\1\25\1\26\1"+
        "\27\1\30\1\31\1\34\1\32\26\uffff\1\17\25\uffff\1\33\6\uffff\1\10"+
        "\6\uffff\1\1\1\3\1\4\7\uffff\1\15\11\uffff\1\16\11\uffff\1\5\1\uffff"+
        "\1\7\1\11\5\uffff\1\12\1\uffff\1\14\1\uffff\1\6\3\uffff\1\2\1\13";
    static final String DFA24_specialS =
        "\1\0\24\uffff\1\1\u008c\uffff}>";
    static final String[] DFA24_transitionS = {
            "\11\32\1\26\1\uffff\2\32\1\uffff\22\32\1\26\1\32\1\uffff\1\25"+
            "\1\14\3\32\1\20\1\21\2\32\1\23\16\32\1\15\1\32\1\22\3\32\10"+
            "\31\1\1\10\31\1\3\2\31\1\2\5\31\1\17\1\32\1\16\1\32\1\24\1\32"+
            "\1\7\1\4\1\5\2\31\1\10\2\31\1\11\6\31\1\6\3\31\1\30\1\12\1\13"+
            "\4\31\u219b\32\1\27\udde9\32",
            "\12\36\7\uffff\15\35\1\33\14\35\4\uffff\1\36\1\uffff\32\35",
            "\12\36\7\uffff\17\35\1\37\12\35\4\uffff\1\36\1\uffff\32\35",
            "\12\36\7\uffff\4\35\1\40\25\35\4\uffff\1\36\1\uffff\32\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\1\41\31\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\1\42\31\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\16\35\1\44\2\35\1"+
            "\43\10\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\13\35\1\45\16\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\1\47\15\35\1\46\13"+
            "\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\6\35\1\50\23\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\15\35\1\51\14\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\10\35\1\52\21\35",
            "\32\54\4\uffff\1\54\1\uffff\32\54",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\0\65",
            "\1\66\26\uffff\1\66\u21f5\uffff\1\66",
            "\1\66",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\21\35\1\67\10\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\32\35",
            "",
            "\12\36\7\uffff\22\35\1\70\7\35\4\uffff\1\36\1\uffff\32\35",
            "",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\32\35",
            "",
            "\12\36\7\uffff\3\35\1\71\26\35\4\uffff\1\36\1\uffff\32\35",
            "\12\36\7\uffff\14\35\1\72\15\35\4\uffff\1\36\1\uffff\32\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\23\35\1\73\6\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\2\35\1\74\27\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\16\35\1\75\13\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\22\35\1\76\7\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\10\35\1\77\2\35\1"+
            "\100\16\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\21\35\1\101\10\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\13\35\1\102\16\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\15\35\1\103\14\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\10\35\1\104\21\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\21\35\1\105\10\35",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\24\35\1\106\5\35",
            "\12\36\7\uffff\4\35\1\107\25\35\4\uffff\1\36\1\uffff\32\35",
            "\12\36\7\uffff\1\110\31\35\4\uffff\1\36\1\uffff\32\35",
            "\12\36\7\uffff\16\35\1\111\13\35\4\uffff\1\36\1\uffff\32\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\2\35\1\112\27\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\7\35\1\113\22\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\2\35\1\114\27\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\32\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\1\116\31\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\16\35\1\117\13\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\2\35\1\120\27\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\22\35\1\121\7\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\16\35\1\122\13\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\20\35\1\123\11\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\23\35\1\124\6\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\4\35\1\125\25\35",
            "\12\36\7\uffff\21\35\1\126\10\35\4\uffff\1\36\1\uffff\32\35",
            "\12\36\7\uffff\23\35\1\127\6\35\4\uffff\1\36\1\uffff\32\35",
            "\12\36\7\uffff\25\35\1\130\4\35\4\uffff\1\36\1\uffff\32\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\7\35\1\131\22\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\4\35\1\132\25\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\4\35\1\133\25\35",
            "",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\22\35\1\134\7\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\26\35\1\135\3\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\4\35\1\136\25\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\4\35\1\137\25\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\21\35\1\140\10\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\24\35\1\141\5\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\24\35\1\142\5\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\32\35",
            "\12\36\7\uffff\23\35\1\144\6\35\4\uffff\1\36\1\uffff\32\35",
            "\12\36\7\uffff\4\35\1\145\25\35\4\uffff\1\36\1\uffff\32\35",
            "\12\36\7\uffff\4\35\1\146\25\35\4\uffff\1\36\1\uffff\32\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\14\35\1\147\15\35",
            "\12\36\7\uffff\24\35\1\150\5\35\4\uffff\1\36\1\uffff\32\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\22\35\1\151\7\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\32\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\15\35\1\153\14\35",
            "\12\36\7\uffff\26\35\1\154\3\35\4\uffff\1\36\1\uffff\32\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\32\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\4\35\1\155\25\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\4\35\1\156\25\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\1\157\31\35",
            "",
            "\12\36\7\uffff\32\35\4\uffff\1\160\1\uffff\32\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\32\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\32\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\16\35\1\164\13\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\15\35\1\165\14\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\22\35\1\166\7\35",
            "",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\24\35\1\167\5\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\21\35\1\170\10\35",
            "\12\36\7\uffff\12\35\1\171\17\35\4\uffff\1\36\1\uffff\15\35"+
            "\1\172\14\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\32\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\13\35\1\174\16\35",
            "\1\175",
            "",
            "",
            "",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\3\35\1\176\26\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\10\35\1\177\21\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\16\35\1\u0080\13"+
            "\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\13\35\1\u0081\16"+
            "\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\10\35\1\u0082\21"+
            "\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\4\35\1\u0083\25\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\24\35\1\u0084\5\35",
            "",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\32\35",
            "\1\u0086",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\4\35\1\u0087\25\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\20\35\1\u0088\11"+
            "\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\21\35\1\u0089\10"+
            "\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\13\35\1\u008a\16"+
            "\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\23\35\1\u008b\6\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\30\35\1\u008c\1\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\13\35\1\u008d\16"+
            "\35",
            "",
            "\1\u008e",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\32\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\24\35\1\u0090\5\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\32\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\32\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\4\35\1\u0093\25\35",
            "\12\36\7\uffff\2\35\1\u0094\27\35\4\uffff\1\36\1\uffff\32\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\13\35\1\u0095\16"+
            "\35",
            "\1\u0096",
            "",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\4\35\1\u0097\25\35",
            "",
            "",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\32\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\1\u0099\31\35",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\32\35",
            "\1\u009b",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\32\35",
            "",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\22\35\1\u009d\7\35",
            "",
            "\1\u009e",
            "",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\4\35\1\u009f\25\35",
            "\12\36\7\uffff\32\36\4\uffff\1\36\1\uffff\32\36",
            "\12\36\7\uffff\32\35\4\uffff\1\36\1\uffff\32\35",
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
            return "1:1: Tokens : ( Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | ForceWrite | IgnoreKeyCase | IgnoreNull | Unique | Virtual | Pos | Dollar | Semicolon | RightBracket | LeftBracket | LeftParenthesis | RightParenthesis | Equals | Comma | Underscore | Hash | LineContinuation | Bool | Comment | Word | Char | MacroIdentifier | MacroDefinition );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA24_0 = input.LA(1);

                        s = -1;
                        if ( (LA24_0=='I') ) {s = 1;}

                        else if ( (LA24_0=='U') ) {s = 2;}

                        else if ( (LA24_0=='R') ) {s = 3;}

                        else if ( (LA24_0=='b') ) {s = 4;}

                        else if ( (LA24_0=='c') ) {s = 5;}

                        else if ( (LA24_0=='p') ) {s = 6;}

                        else if ( (LA24_0=='a') ) {s = 7;}

                        else if ( (LA24_0=='f') ) {s = 8;}

                        else if ( (LA24_0=='i') ) {s = 9;}

                        else if ( (LA24_0=='u') ) {s = 10;}

                        else if ( (LA24_0=='v') ) {s = 11;}

                        else if ( (LA24_0=='$') ) {s = 12;}

                        else if ( (LA24_0==';') ) {s = 13;}

                        else if ( (LA24_0==']') ) {s = 14;}

                        else if ( (LA24_0=='[') ) {s = 15;}

                        else if ( (LA24_0=='(') ) {s = 16;}

                        else if ( (LA24_0==')') ) {s = 17;}

                        else if ( (LA24_0=='=') ) {s = 18;}

                        else if ( (LA24_0==',') ) {s = 19;}

                        else if ( (LA24_0=='_') ) {s = 20;}

                        else if ( (LA24_0=='#') ) {s = 21;}

                        else if ( (LA24_0=='\t'||LA24_0==' ') ) {s = 22;}

                        else if ( (LA24_0=='\u2216') ) {s = 23;}

                        else if ( (LA24_0=='t') ) {s = 24;}

                        else if ( ((LA24_0 >= 'A' && LA24_0 <= 'H')||(LA24_0 >= 'J' && LA24_0 <= 'Q')||(LA24_0 >= 'S' && LA24_0 <= 'T')||(LA24_0 >= 'V' && LA24_0 <= 'Z')||(LA24_0 >= 'd' && LA24_0 <= 'e')||(LA24_0 >= 'g' && LA24_0 <= 'h')||(LA24_0 >= 'j' && LA24_0 <= 'o')||(LA24_0 >= 'q' && LA24_0 <= 's')||(LA24_0 >= 'w' && LA24_0 <= 'z')) ) {s = 25;}

                        else if ( ((LA24_0 >= '\u0000' && LA24_0 <= '\b')||(LA24_0 >= '\u000B' && LA24_0 <= '\f')||(LA24_0 >= '\u000E' && LA24_0 <= '\u001F')||LA24_0=='!'||(LA24_0 >= '%' && LA24_0 <= '\'')||(LA24_0 >= '*' && LA24_0 <= '+')||(LA24_0 >= '-' && LA24_0 <= ':')||LA24_0=='<'||(LA24_0 >= '>' && LA24_0 <= '@')||LA24_0=='\\'||LA24_0=='^'||LA24_0=='`'||(LA24_0 >= '{' && LA24_0 <= '\u2215')||(LA24_0 >= '\u2217' && LA24_0 <= '\uFFFF')) ) {s = 26;}

                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA24_21 = input.LA(1);

                        s = -1;
                        if ( ((LA24_21 >= '\u0000' && LA24_21 <= '\uFFFF')) ) {s = 53;}

                        else s = 52;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 24, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}