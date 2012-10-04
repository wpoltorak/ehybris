// $ANTLR 3.4 /work/projects/yeclipse/ImpexAST/src/main/java/impex.g 2012-09-28 18:03:48

 package output;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class impexLexer extends Lexer {
    public static final int EOF=-1;
    public static final int ASSIGNEMENT=4;
    public static final int ASSIGNEMENTS=5;
    public static final int ATTRIBUTES=6;
    public static final int Alias=7;
    public static final int AllowNull=8;
    public static final int BatchMode=9;
    public static final int COMMENTS=10;
    public static final int COMPLEX_ATTRIBUTE=11;
    public static final int CacheUnique=12;
    public static final int Comma=13;
    public static final int Comment=14;
    public static final int Dollar=15;
    public static final int Equals=16;
    public static final int ForceWrite=17;
    public static final int HEADER=18;
    public static final int HEADER_PREFIX=19;
    public static final int HEADER_TYPE=20;
    public static final int Hash=21;
    public static final int IMPEX=22;
    public static final int IMPEX_BLOCK=23;
    public static final int IMPEX_BLOCKS=24;
    public static final int IgnoreKeyCase=25;
    public static final int IgnoreNull=26;
    public static final int Insert=27;
    public static final int InsertUpdate=28;
    public static final int LeftBracket=29;
    public static final int LeftParenthesis=30;
    public static final int LineBreak=31;
    public static final int LineContinuation=32;
    public static final int MACRO=33;
    public static final int Pos=34;
    public static final int Processor=35;
    public static final int ROW=36;
    public static final int ROWS=37;
    public static final int Remove=38;
    public static final int RightBracket=39;
    public static final int RightParenthesis=40;
    public static final int SIMPLE_ATTRIBUTE=41;
    public static final int Semicolon=42;
    public static final int Underscore=43;
    public static final int Unique=44;
    public static final int Update=45;
    public static final int Virtual=46;
    public static final int Ws=47;

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
    public String getGrammarFileName() { return "/work/projects/yeclipse/ImpexAST/src/main/java/impex.g"; }

    // $ANTLR start "Insert"
    public final void mInsert() throws RecognitionException {
        try {
            int _type = Insert;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:48:9: ( 'INSERT' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:48:10: 'INSERT'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:49:15: ( 'INSERT_UPDATE' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:49:16: 'INSERT_UPDATE'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:50:9: ( 'UPDATE' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:50:10: 'UPDATE'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:51:9: ( 'REMOVE' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:51:10: 'REMOVE'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:53:12: ( 'batchmode' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:53:13: 'batchmode'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:54:14: ( 'cacheUnique' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:54:15: 'cacheUnique'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:55:12: ( 'processor' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:55:13: 'processor'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:57:8: ( 'alias' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:57:9: 'alias'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:58:12: ( 'allownull' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:58:13: 'allownull'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:59:13: ( 'forceWrite' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:59:14: 'forceWrite'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:60:15: ( 'ignoreKeyCase' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:60:16: 'ignoreKeyCase'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:61:13: ( 'ignorenull' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:61:14: 'ignorenull'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:62:9: ( 'unique' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:62:10: 'unique'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:63:10: ( 'virtual' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:63:11: 'virtual'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:64:6: ( 'pos' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:64:7: 'pos'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:66:9: ( '$' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:66:10: '$'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:67:12: ( ';' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:67:13: ';'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:68:15: ( ']' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:68:16: ']'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:69:14: ( '[' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:69:15: '['
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:70:18: ( '(' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:70:19: '('
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:71:18: ( ')' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:71:19: ')'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:72:9: ( '=' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:72:10: '='
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:73:8: ( ',' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:73:10: ','
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:74:13: ( '_' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:74:14: '_'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:75:7: ( '#' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:75:8: '#'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:76:18: ( '\\\\\\\\' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:76:19: '\\\\\\\\'
            {
            match("\\\\"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "LineContinuation"

    // $ANTLR start "Comment"
    public final void mComment() throws RecognitionException {
        try {
            int _type = Comment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:79:2: ( Hash (~ ( '\\u000d' | '\\u000a' ) )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:79:4: Hash (~ ( '\\u000d' | '\\u000a' ) )*
            {
            mHash(); 


            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:79:9: (~ ( '\\u000d' | '\\u000a' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '\u0000' && LA1_0 <= '\t')||(LA1_0 >= '\u000B' && LA1_0 <= '\f')||(LA1_0 >= '\u000E' && LA1_0 <= '\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '\uFFFF') ) {
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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Comment"

    // $ANTLR start "LineBreak"
    public final void mLineBreak() throws RecognitionException {
        try {
            int _type = LineBreak;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:83:2: ( ( '\\u000d' )? '\\u000a' | '\\u000d' )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\r') ) {
                int LA3_1 = input.LA(2);

                if ( (LA3_1=='\n') ) {
                    alt3=1;
                }
                else {
                    alt3=2;
                }
            }
            else if ( (LA3_0=='\n') ) {
                alt3=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }
            switch (alt3) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:83:4: ( '\\u000d' )? '\\u000a'
                    {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:83:4: ( '\\u000d' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0=='\r') ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:83:4: '\\u000d'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:84:4: '\\u000d'
                    {
                    match('\r'); 

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
    // $ANTLR end "LineBreak"

    // $ANTLR start "Ws"
    public final void mWs() throws RecognitionException {
        try {
            int _type = Ws;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:88:2: ( '\\u0020' | '\\u0009' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:
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

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Ws"

    public void mTokens() throws RecognitionException {
        // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:8: ( Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | ForceWrite | IgnoreKeyCase | IgnoreNull | Unique | Virtual | Pos | Dollar | Semicolon | RightBracket | LeftBracket | LeftParenthesis | RightParenthesis | Equals | Comma | Underscore | Hash | LineContinuation | Comment | LineBreak | Ws )
        int alt4=29;
        switch ( input.LA(1) ) {
        case 'I':
            {
            int LA4_1 = input.LA(2);

            if ( (LA4_1=='N') ) {
                int LA4_25 = input.LA(3);

                if ( (LA4_25=='S') ) {
                    int LA4_32 = input.LA(4);

                    if ( (LA4_32=='E') ) {
                        int LA4_36 = input.LA(5);

                        if ( (LA4_36=='R') ) {
                            int LA4_38 = input.LA(6);

                            if ( (LA4_38=='T') ) {
                                int LA4_40 = input.LA(7);

                                if ( (LA4_40=='_') ) {
                                    alt4=2;
                                }
                                else {
                                    alt4=1;
                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 4, 38, input);

                                throw nvae;

                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 4, 36, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 32, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 25, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 1, input);

                throw nvae;

            }
            }
            break;
        case 'U':
            {
            alt4=3;
            }
            break;
        case 'R':
            {
            alt4=4;
            }
            break;
        case 'b':
            {
            alt4=5;
            }
            break;
        case 'c':
            {
            alt4=6;
            }
            break;
        case 'p':
            {
            int LA4_6 = input.LA(2);

            if ( (LA4_6=='r') ) {
                alt4=7;
            }
            else if ( (LA4_6=='o') ) {
                alt4=15;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 6, input);

                throw nvae;

            }
            }
            break;
        case 'a':
            {
            int LA4_7 = input.LA(2);

            if ( (LA4_7=='l') ) {
                int LA4_28 = input.LA(3);

                if ( (LA4_28=='i') ) {
                    alt4=8;
                }
                else if ( (LA4_28=='l') ) {
                    alt4=9;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 28, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 7, input);

                throw nvae;

            }
            }
            break;
        case 'f':
            {
            alt4=10;
            }
            break;
        case 'i':
            {
            int LA4_9 = input.LA(2);

            if ( (LA4_9=='g') ) {
                int LA4_29 = input.LA(3);

                if ( (LA4_29=='n') ) {
                    int LA4_35 = input.LA(4);

                    if ( (LA4_35=='o') ) {
                        int LA4_37 = input.LA(5);

                        if ( (LA4_37=='r') ) {
                            int LA4_39 = input.LA(6);

                            if ( (LA4_39=='e') ) {
                                int LA4_41 = input.LA(7);

                                if ( (LA4_41=='K') ) {
                                    alt4=11;
                                }
                                else if ( (LA4_41=='n') ) {
                                    alt4=12;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 4, 41, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 4, 39, input);

                                throw nvae;

                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 4, 37, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 35, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 29, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 9, input);

                throw nvae;

            }
            }
            break;
        case 'u':
            {
            alt4=13;
            }
            break;
        case 'v':
            {
            alt4=14;
            }
            break;
        case '$':
            {
            alt4=16;
            }
            break;
        case ';':
            {
            alt4=17;
            }
            break;
        case ']':
            {
            alt4=18;
            }
            break;
        case '[':
            {
            alt4=19;
            }
            break;
        case '(':
            {
            alt4=20;
            }
            break;
        case ')':
            {
            alt4=21;
            }
            break;
        case '=':
            {
            alt4=22;
            }
            break;
        case ',':
            {
            alt4=23;
            }
            break;
        case '_':
            {
            alt4=24;
            }
            break;
        case '#':
            {
            int LA4_21 = input.LA(2);

            if ( ((LA4_21 >= '\u0000' && LA4_21 <= '\t')||(LA4_21 >= '\u000B' && LA4_21 <= '\f')||(LA4_21 >= '\u000E' && LA4_21 <= '\uFFFF')) ) {
                alt4=27;
            }
            else {
                alt4=25;
            }
            }
            break;
        case '\\':
            {
            alt4=26;
            }
            break;
        case '\n':
        case '\r':
            {
            alt4=28;
            }
            break;
        case '\t':
        case ' ':
            {
            alt4=29;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 4, 0, input);

            throw nvae;

        }

        switch (alt4) {
            case 1 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:10: Insert
                {
                mInsert(); 


                }
                break;
            case 2 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:17: InsertUpdate
                {
                mInsertUpdate(); 


                }
                break;
            case 3 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:30: Update
                {
                mUpdate(); 


                }
                break;
            case 4 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:37: Remove
                {
                mRemove(); 


                }
                break;
            case 5 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:44: BatchMode
                {
                mBatchMode(); 


                }
                break;
            case 6 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:54: CacheUnique
                {
                mCacheUnique(); 


                }
                break;
            case 7 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:66: Processor
                {
                mProcessor(); 


                }
                break;
            case 8 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:76: Alias
                {
                mAlias(); 


                }
                break;
            case 9 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:82: AllowNull
                {
                mAllowNull(); 


                }
                break;
            case 10 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:92: ForceWrite
                {
                mForceWrite(); 


                }
                break;
            case 11 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:103: IgnoreKeyCase
                {
                mIgnoreKeyCase(); 


                }
                break;
            case 12 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:117: IgnoreNull
                {
                mIgnoreNull(); 


                }
                break;
            case 13 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:128: Unique
                {
                mUnique(); 


                }
                break;
            case 14 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:135: Virtual
                {
                mVirtual(); 


                }
                break;
            case 15 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:143: Pos
                {
                mPos(); 


                }
                break;
            case 16 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:147: Dollar
                {
                mDollar(); 


                }
                break;
            case 17 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:154: Semicolon
                {
                mSemicolon(); 


                }
                break;
            case 18 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:164: RightBracket
                {
                mRightBracket(); 


                }
                break;
            case 19 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:177: LeftBracket
                {
                mLeftBracket(); 


                }
                break;
            case 20 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:189: LeftParenthesis
                {
                mLeftParenthesis(); 


                }
                break;
            case 21 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:205: RightParenthesis
                {
                mRightParenthesis(); 


                }
                break;
            case 22 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:222: Equals
                {
                mEquals(); 


                }
                break;
            case 23 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:229: Comma
                {
                mComma(); 


                }
                break;
            case 24 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:235: Underscore
                {
                mUnderscore(); 


                }
                break;
            case 25 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:246: Hash
                {
                mHash(); 


                }
                break;
            case 26 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:251: LineContinuation
                {
                mLineContinuation(); 


                }
                break;
            case 27 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:268: Comment
                {
                mComment(); 


                }
                break;
            case 28 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:276: LineBreak
                {
                mLineBreak(); 


                }
                break;
            case 29 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:286: Ws
                {
                mWs(); 


                }
                break;

        }

    }


 

}