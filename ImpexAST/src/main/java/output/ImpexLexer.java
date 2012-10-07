// $ANTLR 3.4 /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g 2012-10-07 22:55:01

 package output;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class ImpexLexer extends Lexer {
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
    public static final int Equals=15;
    public static final int ForceWrite=16;
    public static final int HEADER=17;
    public static final int HEADER_PREFIX=18;
    public static final int HEADER_TYPE=19;
    public static final int IMPEX=20;
    public static final int IMPEX_BLOCK=21;
    public static final int IMPEX_BLOCKS=22;
    public static final int IgnoreKeyCase=23;
    public static final int IgnoreNull=24;
    public static final int Insert=25;
    public static final int InsertUpdate=26;
    public static final int LeftBracket=27;
    public static final int LeftParenthesis=28;
    public static final int LineBreak=29;
    public static final int LineContinuation=30;
    public static final int MACRO=31;
    public static final int Macrodef=32;
    public static final int Macroval=33;
    public static final int Pos=34;
    public static final int Processor=35;
    public static final int ROW=36;
    public static final int ROWS=37;
    public static final int Remove=38;
    public static final int RightBracket=39;
    public static final int RightParenthesis=40;
    public static final int SIMPLE_ATTRIBUTE=41;
    public static final int Semicolon=42;
    public static final int Unique=43;
    public static final int Update=44;
    public static final int Virtual=45;
    public static final int Ws=46;

    // delegates
    // delegators
    public Lexer[] getDelegates() {
        return new Lexer[] {};
    }

    public ImpexLexer() {} 
    public ImpexLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public ImpexLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);
    }
    public String getGrammarFileName() { return "/work/projects/yeclipse/ImpexAST/src/main/java/Impex.g"; }

    // $ANTLR start "Insert"
    public final void mInsert() throws RecognitionException {
        try {
            int _type = Insert;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:52:9: ( 'INSERT' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:52:10: 'INSERT'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:53:15: ( 'INSERT_UPDATE' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:53:16: 'INSERT_UPDATE'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:54:9: ( 'UPDATE' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:54:10: 'UPDATE'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:55:9: ( 'REMOVE' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:55:10: 'REMOVE'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:57:12: ( 'batchmode' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:57:13: 'batchmode'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:58:14: ( 'cacheUnique' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:58:15: 'cacheUnique'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:59:12: ( 'processor' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:59:13: 'processor'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:61:8: ( 'alias' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:61:9: 'alias'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:62:12: ( 'allownull' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:62:13: 'allownull'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:63:13: ( 'forceWrite' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:63:14: 'forceWrite'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:64:15: ( 'ignoreKeyCase' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:64:16: 'ignoreKeyCase'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:65:13: ( 'ignorenull' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:65:14: 'ignorenull'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:66:9: ( 'unique' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:66:10: 'unique'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:67:10: ( 'virtual' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:67:11: 'virtual'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:68:6: ( 'pos' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:68:7: 'pos'
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

    // $ANTLR start "Semicolon"
    public final void mSemicolon() throws RecognitionException {
        try {
            int _type = Semicolon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:71:12: ( ';' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:71:13: ';'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:72:15: ( ']' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:72:16: ']'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:73:14: ( '[' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:73:15: '['
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:74:18: ( '(' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:74:19: '('
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:75:18: ( ')' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:75:19: ')'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:76:9: ( '=' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:76:10: '='
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:77:8: ( ',' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:77:9: ','
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

    // $ANTLR start "LineContinuation"
    public final void mLineContinuation() throws RecognitionException {
        try {
            int _type = LineContinuation;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:80:18: ( '\\\\\\\\' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:80:19: '\\\\\\\\'
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

    // $ANTLR start "Macrodef"
    public final void mMacrodef() throws RecognitionException {
        try {
            int _type = Macrodef;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:83:2: ( '$' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:83:4: '$' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            match('$'); 

            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:83:40: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
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
    // $ANTLR end "Macrodef"

    // $ANTLR start "Comment"
    public final void mComment() throws RecognitionException {
        try {
            int _type = Comment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:94:2: ( '#' (~ ( '\\u000d' | '\\u000a' ) )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:94:4: '#' (~ ( '\\u000d' | '\\u000a' ) )*
            {
            match('#'); 

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:94:8: (~ ( '\\u000d' | '\\u000a' ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\f')||(LA2_0 >= '\u000E' && LA2_0 <= '\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
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
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;

              		setText(getText().substring(1, getText().length()));
            	
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:98:2: ( ( '\\u000d' )? '\\u000a' | '\\u000d' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='\r') ) {
                int LA4_1 = input.LA(2);

                if ( (LA4_1=='\n') ) {
                    alt4=1;
                }
                else {
                    alt4=2;
                }
            }
            else if ( (LA4_0=='\n') ) {
                alt4=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }
            switch (alt4) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:98:4: ( '\\u000d' )? '\\u000a'
                    {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:98:4: ( '\\u000d' )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='\r') ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:98:4: '\\u000d'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:99:4: '\\u000d'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:104:2: ( '\\u0020' | '\\u0009' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==' ') ) {
                alt5=1;
            }
            else if ( (LA5_0=='\t') ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:104:4: '\\u0020'
                    {
                    match(' '); 

                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:104:15: '\\u0009'
                    {
                    match('\t'); 

                    _channel=HIDDEN; 

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
    // $ANTLR end "Ws"

    // $ANTLR start "Macroval"
    public final void mMacroval() throws RecognitionException {
        try {
            int _type = Macroval;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:108:2: ( (~ ( '\\u000d' | '\\u000a' ) )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:108:4: (~ ( '\\u000d' | '\\u000a' ) )*
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:108:4: (~ ( '\\u000d' | '\\u000a' ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= '\u0000' && LA6_0 <= '\t')||(LA6_0 >= '\u000B' && LA6_0 <= '\f')||(LA6_0 >= '\u000E' && LA6_0 <= '\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
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
            	    break loop6;
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
    // $ANTLR end "Macroval"

    public void mTokens() throws RecognitionException {
        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:8: ( Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | ForceWrite | IgnoreKeyCase | IgnoreNull | Unique | Virtual | Pos | Semicolon | RightBracket | LeftBracket | LeftParenthesis | RightParenthesis | Equals | Comma | LineContinuation | Macrodef | Comment | LineBreak | Ws | Macroval )
        int alt7=28;
        alt7 = dfa7.predict(input);
        switch (alt7) {
            case 1 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:10: Insert
                {
                mInsert(); 


                }
                break;
            case 2 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:17: InsertUpdate
                {
                mInsertUpdate(); 


                }
                break;
            case 3 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:30: Update
                {
                mUpdate(); 


                }
                break;
            case 4 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:37: Remove
                {
                mRemove(); 


                }
                break;
            case 5 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:44: BatchMode
                {
                mBatchMode(); 


                }
                break;
            case 6 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:54: CacheUnique
                {
                mCacheUnique(); 


                }
                break;
            case 7 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:66: Processor
                {
                mProcessor(); 


                }
                break;
            case 8 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:76: Alias
                {
                mAlias(); 


                }
                break;
            case 9 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:82: AllowNull
                {
                mAllowNull(); 


                }
                break;
            case 10 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:92: ForceWrite
                {
                mForceWrite(); 


                }
                break;
            case 11 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:103: IgnoreKeyCase
                {
                mIgnoreKeyCase(); 


                }
                break;
            case 12 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:117: IgnoreNull
                {
                mIgnoreNull(); 


                }
                break;
            case 13 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:128: Unique
                {
                mUnique(); 


                }
                break;
            case 14 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:135: Virtual
                {
                mVirtual(); 


                }
                break;
            case 15 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:143: Pos
                {
                mPos(); 


                }
                break;
            case 16 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:147: Semicolon
                {
                mSemicolon(); 


                }
                break;
            case 17 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:157: RightBracket
                {
                mRightBracket(); 


                }
                break;
            case 18 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:170: LeftBracket
                {
                mLeftBracket(); 


                }
                break;
            case 19 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:182: LeftParenthesis
                {
                mLeftParenthesis(); 


                }
                break;
            case 20 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:198: RightParenthesis
                {
                mRightParenthesis(); 


                }
                break;
            case 21 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:215: Equals
                {
                mEquals(); 


                }
                break;
            case 22 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:222: Comma
                {
                mComma(); 


                }
                break;
            case 23 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:228: LineContinuation
                {
                mLineContinuation(); 


                }
                break;
            case 24 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:245: Macrodef
                {
                mMacrodef(); 


                }
                break;
            case 25 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:254: Comment
                {
                mComment(); 


                }
                break;
            case 26 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:262: LineBreak
                {
                mLineBreak(); 


                }
                break;
            case 27 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:272: Ws
                {
                mWs(); 


                }
                break;
            case 28 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:275: Macroval
                {
                mMacroval(); 


                }
                break;

        }

    }


    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA7_eotS =
        "\14\31\1\46\1\47\1\50\1\51\1\52\1\53\1\54\2\31\1\60\1\uffff\2\61"+
        "\1\uffff\14\31\7\uffff\1\77\1\101\1\60\2\uffff\6\31\1\110\6\31\1"+
        "\uffff\1\101\1\uffff\6\31\1\uffff\14\31\1\141\5\31\1\150\1\151\1"+
        "\152\3\31\1\uffff\3\31\1\162\2\31\3\uffff\7\31\1\uffff\1\174\10"+
        "\31\1\uffff\1\31\1\u0086\1\31\1\u0088\1\u0089\4\31\1\uffff\1\31"+
        "\2\uffff\1\u008f\1\31\1\u0091\1\31\1\u0093\1\uffff\1\31\1\uffff"+
        "\1\31\1\uffff\1\31\1\u0097\1\u0098\2\uffff";
    static final String DFA7_eofS =
        "\u0099\uffff";
    static final String DFA7_minS =
        "\1\11\1\116\1\120\1\105\2\141\1\157\1\154\1\157\1\147\1\156\1\151"+
        "\7\0\1\134\1\101\1\0\1\uffff\2\0\1\uffff\1\123\1\104\1\115\1\164"+
        "\1\143\1\157\1\163\1\151\1\162\1\156\1\151\1\162\7\uffff\3\0\2\uffff"+
        "\1\105\1\101\1\117\1\143\1\150\1\143\1\0\1\141\1\157\1\143\1\157"+
        "\1\161\1\164\1\uffff\1\0\1\uffff\1\122\1\124\1\126\1\150\2\145\1"+
        "\uffff\1\163\1\167\1\145\1\162\2\165\1\124\2\105\1\155\1\125\1\163"+
        "\1\0\1\156\1\127\2\145\1\141\3\0\1\157\1\156\1\163\1\uffff\1\165"+
        "\1\162\1\113\1\0\1\154\1\125\3\uffff\1\144\1\151\1\157\1\154\1\151"+
        "\1\145\1\165\1\uffff\1\0\1\120\1\145\1\161\1\162\1\154\1\164\1\171"+
        "\1\154\1\uffff\1\104\1\0\1\165\2\0\1\145\1\103\1\154\1\101\1\uffff"+
        "\1\145\2\uffff\1\0\1\141\1\0\1\124\1\0\1\uffff\1\163\1\uffff\1\105"+
        "\1\uffff\1\145\2\0\2\uffff";
    static final String DFA7_maxS =
        "\1\166\1\116\1\120\1\105\2\141\1\162\1\154\1\157\1\147\1\156\1\151"+
        "\7\uffff\1\134\1\172\1\uffff\1\uffff\2\uffff\1\uffff\1\123\1\104"+
        "\1\115\1\164\1\143\1\157\1\163\1\154\1\162\1\156\1\151\1\162\7\uffff"+
        "\3\uffff\2\uffff\1\105\1\101\1\117\1\143\1\150\1\143\1\uffff\1\141"+
        "\1\157\1\143\1\157\1\161\1\164\1\uffff\1\uffff\1\uffff\1\122\1\124"+
        "\1\126\1\150\2\145\1\uffff\1\163\1\167\1\145\1\162\2\165\1\124\2"+
        "\105\1\155\1\125\1\163\1\uffff\1\156\1\127\2\145\1\141\3\uffff\1"+
        "\157\1\156\1\163\1\uffff\1\165\1\162\1\156\1\uffff\1\154\1\125\3"+
        "\uffff\1\144\1\151\1\157\1\154\1\151\1\145\1\165\1\uffff\1\uffff"+
        "\1\120\1\145\1\161\1\162\1\154\1\164\1\171\1\154\1\uffff\1\104\1"+
        "\uffff\1\165\2\uffff\1\145\1\103\1\154\1\101\1\uffff\1\145\2\uffff"+
        "\1\uffff\1\141\1\uffff\1\124\1\uffff\1\uffff\1\163\1\uffff\1\105"+
        "\1\uffff\1\145\2\uffff\2\uffff";
    static final String DFA7_acceptS =
        "\26\uffff\1\32\2\uffff\1\34\14\uffff\1\20\1\21\1\22\1\23\1\24\1"+
        "\25\1\26\3\uffff\1\31\1\33\15\uffff\1\27\1\uffff\1\30\6\uffff\1"+
        "\17\30\uffff\1\10\6\uffff\1\1\1\3\1\4\7\uffff\1\15\11\uffff\1\16"+
        "\11\uffff\1\5\1\uffff\1\7\1\11\5\uffff\1\12\1\uffff\1\14\1\uffff"+
        "\1\6\3\uffff\1\2\1\13";
    static final String DFA7_specialS =
        "\14\uffff\1\26\1\14\1\12\1\21\1\22\1\16\1\3\2\uffff\1\15\1\uffff"+
        "\1\30\1\24\24\uffff\1\1\1\2\1\4\10\uffff\1\27\7\uffff\1\6\24\uffff"+
        "\1\11\5\uffff\1\0\1\7\1\10\7\uffff\1\23\15\uffff\1\31\12\uffff\1"+
        "\5\1\uffff\1\20\1\13\10\uffff\1\32\1\uffff\1\25\1\uffff\1\17\6\uffff"+
        "\1\33\1\34\2\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\30\1\26\2\uffff\1\26\22\uffff\1\27\2\uffff\1\25\1\24\3\uffff"+
            "\1\17\1\20\2\uffff\1\22\16\uffff\1\14\1\uffff\1\21\13\uffff"+
            "\1\1\10\uffff\1\3\2\uffff\1\2\5\uffff\1\16\1\23\1\15\3\uffff"+
            "\1\7\1\4\1\5\2\uffff\1\10\2\uffff\1\11\6\uffff\1\6\4\uffff\1"+
            "\12\1\13",
            "\1\32",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\36",
            "\1\40\2\uffff\1\37",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\45",
            "\12\31\1\uffff\2\31\1\uffff\ufff2\31",
            "\12\31\1\uffff\2\31\1\uffff\ufff2\31",
            "\12\31\1\uffff\2\31\1\uffff\ufff2\31",
            "\12\31\1\uffff\2\31\1\uffff\ufff2\31",
            "\12\31\1\uffff\2\31\1\uffff\ufff2\31",
            "\12\31\1\uffff\2\31\1\uffff\ufff2\31",
            "\12\31\1\uffff\2\31\1\uffff\ufff2\31",
            "\1\55",
            "\32\56\4\uffff\1\56\1\uffff\32\56",
            "\12\57\1\uffff\2\57\1\uffff\ufff2\57",
            "",
            "\12\31\1\uffff\2\31\1\uffff\ufff2\31",
            "\12\31\1\uffff\2\31\1\uffff\ufff2\31",
            "",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71\2\uffff\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\31\1\uffff\2\31\1\uffff\ufff2\31",
            "\12\31\1\uffff\2\31\1\uffff\42\31\12\100\7\31\32\100\4\31\1"+
            "\100\1\31\32\100\uff85\31",
            "\12\57\1\uffff\2\57\1\uffff\ufff2\57",
            "",
            "",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\12\31\1\uffff\2\31\1\uffff\ufff2\31",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "",
            "\12\31\1\uffff\2\31\1\uffff\42\31\12\100\7\31\32\100\4\31\1"+
            "\100\1\31\32\100\uff85\31",
            "",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\12\31\1\uffff\2\31\1\uffff\ufff2\31",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\12\31\1\uffff\2\31\1\uffff\121\31\1\147\uffa0\31",
            "\12\31\1\uffff\2\31\1\uffff\ufff2\31",
            "\12\31\1\uffff\2\31\1\uffff\ufff2\31",
            "\1\153",
            "\1\154",
            "\1\155",
            "",
            "\1\156",
            "\1\157",
            "\1\160\42\uffff\1\161",
            "\12\31\1\uffff\2\31\1\uffff\ufff2\31",
            "\1\163",
            "\1\164",
            "",
            "",
            "",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "",
            "\12\31\1\uffff\2\31\1\uffff\ufff2\31",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "",
            "\1\u0085",
            "\12\31\1\uffff\2\31\1\uffff\ufff2\31",
            "\1\u0087",
            "\12\31\1\uffff\2\31\1\uffff\ufff2\31",
            "\12\31\1\uffff\2\31\1\uffff\ufff2\31",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "",
            "\1\u008e",
            "",
            "",
            "\12\31\1\uffff\2\31\1\uffff\ufff2\31",
            "\1\u0090",
            "\12\31\1\uffff\2\31\1\uffff\ufff2\31",
            "\1\u0092",
            "\12\31\1\uffff\2\31\1\uffff\ufff2\31",
            "",
            "\1\u0094",
            "",
            "\1\u0095",
            "",
            "\1\u0096",
            "\12\31\1\uffff\2\31\1\uffff\ufff2\31",
            "\12\31\1\uffff\2\31\1\uffff\ufff2\31",
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
            return "1:1: Tokens : ( Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | ForceWrite | IgnoreKeyCase | IgnoreNull | Unique | Virtual | Pos | Semicolon | RightBracket | LeftBracket | LeftParenthesis | RightParenthesis | Equals | Comma | LineContinuation | Macrodef | Comment | LineBreak | Ws | Macroval );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA7_91 = input.LA(1);

                        s = -1;
                        if ( (LA7_91=='_') ) {s = 103;}

                        else if ( ((LA7_91 >= '\u0000' && LA7_91 <= '\t')||(LA7_91 >= '\u000B' && LA7_91 <= '\f')||(LA7_91 >= '\u000E' && LA7_91 <= '^')||(LA7_91 >= '`' && LA7_91 <= '\uFFFF')) ) {s = 25;}

                        else s = 104;

                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA7_45 = input.LA(1);

                        s = -1;
                        if ( ((LA7_45 >= '\u0000' && LA7_45 <= '\t')||(LA7_45 >= '\u000B' && LA7_45 <= '\f')||(LA7_45 >= '\u000E' && LA7_45 <= '\uFFFF')) ) {s = 25;}

                        else s = 63;

                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA7_46 = input.LA(1);

                        s = -1;
                        if ( ((LA7_46 >= '0' && LA7_46 <= '9')||(LA7_46 >= 'A' && LA7_46 <= 'Z')||LA7_46=='_'||(LA7_46 >= 'a' && LA7_46 <= 'z')) ) {s = 64;}

                        else if ( ((LA7_46 >= '\u0000' && LA7_46 <= '\t')||(LA7_46 >= '\u000B' && LA7_46 <= '\f')||(LA7_46 >= '\u000E' && LA7_46 <= '/')||(LA7_46 >= ':' && LA7_46 <= '@')||(LA7_46 >= '[' && LA7_46 <= '^')||LA7_46=='`'||(LA7_46 >= '{' && LA7_46 <= '\uFFFF')) ) {s = 25;}

                        else s = 65;

                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA7_18 = input.LA(1);

                        s = -1;
                        if ( ((LA7_18 >= '\u0000' && LA7_18 <= '\t')||(LA7_18 >= '\u000B' && LA7_18 <= '\f')||(LA7_18 >= '\u000E' && LA7_18 <= '\uFFFF')) ) {s = 25;}

                        else s = 44;

                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA7_47 = input.LA(1);

                        s = -1;
                        if ( ((LA7_47 >= '\u0000' && LA7_47 <= '\t')||(LA7_47 >= '\u000B' && LA7_47 <= '\f')||(LA7_47 >= '\u000E' && LA7_47 <= '\uFFFF')) ) {s = 47;}

                        else s = 48;

                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA7_126 = input.LA(1);

                        s = -1;
                        if ( ((LA7_126 >= '\u0000' && LA7_126 <= '\t')||(LA7_126 >= '\u000B' && LA7_126 <= '\f')||(LA7_126 >= '\u000E' && LA7_126 <= '\uFFFF')) ) {s = 25;}

                        else s = 134;

                        if ( s>=0 ) return s;
                        break;

                    case 6 : 
                        int LA7_64 = input.LA(1);

                        s = -1;
                        if ( ((LA7_64 >= '0' && LA7_64 <= '9')||(LA7_64 >= 'A' && LA7_64 <= 'Z')||LA7_64=='_'||(LA7_64 >= 'a' && LA7_64 <= 'z')) ) {s = 64;}

                        else if ( ((LA7_64 >= '\u0000' && LA7_64 <= '\t')||(LA7_64 >= '\u000B' && LA7_64 <= '\f')||(LA7_64 >= '\u000E' && LA7_64 <= '/')||(LA7_64 >= ':' && LA7_64 <= '@')||(LA7_64 >= '[' && LA7_64 <= '^')||LA7_64=='`'||(LA7_64 >= '{' && LA7_64 <= '\uFFFF')) ) {s = 25;}

                        else s = 65;

                        if ( s>=0 ) return s;
                        break;

                    case 7 : 
                        int LA7_92 = input.LA(1);

                        s = -1;
                        if ( ((LA7_92 >= '\u0000' && LA7_92 <= '\t')||(LA7_92 >= '\u000B' && LA7_92 <= '\f')||(LA7_92 >= '\u000E' && LA7_92 <= '\uFFFF')) ) {s = 25;}

                        else s = 105;

                        if ( s>=0 ) return s;
                        break;

                    case 8 : 
                        int LA7_93 = input.LA(1);

                        s = -1;
                        if ( ((LA7_93 >= '\u0000' && LA7_93 <= '\t')||(LA7_93 >= '\u000B' && LA7_93 <= '\f')||(LA7_93 >= '\u000E' && LA7_93 <= '\uFFFF')) ) {s = 25;}

                        else s = 106;

                        if ( s>=0 ) return s;
                        break;

                    case 9 : 
                        int LA7_85 = input.LA(1);

                        s = -1;
                        if ( ((LA7_85 >= '\u0000' && LA7_85 <= '\t')||(LA7_85 >= '\u000B' && LA7_85 <= '\f')||(LA7_85 >= '\u000E' && LA7_85 <= '\uFFFF')) ) {s = 25;}

                        else s = 97;

                        if ( s>=0 ) return s;
                        break;

                    case 10 : 
                        int LA7_14 = input.LA(1);

                        s = -1;
                        if ( ((LA7_14 >= '\u0000' && LA7_14 <= '\t')||(LA7_14 >= '\u000B' && LA7_14 <= '\f')||(LA7_14 >= '\u000E' && LA7_14 <= '\uFFFF')) ) {s = 25;}

                        else s = 40;

                        if ( s>=0 ) return s;
                        break;

                    case 11 : 
                        int LA7_129 = input.LA(1);

                        s = -1;
                        if ( ((LA7_129 >= '\u0000' && LA7_129 <= '\t')||(LA7_129 >= '\u000B' && LA7_129 <= '\f')||(LA7_129 >= '\u000E' && LA7_129 <= '\uFFFF')) ) {s = 25;}

                        else s = 137;

                        if ( s>=0 ) return s;
                        break;

                    case 12 : 
                        int LA7_13 = input.LA(1);

                        s = -1;
                        if ( ((LA7_13 >= '\u0000' && LA7_13 <= '\t')||(LA7_13 >= '\u000B' && LA7_13 <= '\f')||(LA7_13 >= '\u000E' && LA7_13 <= '\uFFFF')) ) {s = 25;}

                        else s = 39;

                        if ( s>=0 ) return s;
                        break;

                    case 13 : 
                        int LA7_21 = input.LA(1);

                        s = -1;
                        if ( ((LA7_21 >= '\u0000' && LA7_21 <= '\t')||(LA7_21 >= '\u000B' && LA7_21 <= '\f')||(LA7_21 >= '\u000E' && LA7_21 <= '\uFFFF')) ) {s = 47;}

                        else s = 48;

                        if ( s>=0 ) return s;
                        break;

                    case 14 : 
                        int LA7_17 = input.LA(1);

                        s = -1;
                        if ( ((LA7_17 >= '\u0000' && LA7_17 <= '\t')||(LA7_17 >= '\u000B' && LA7_17 <= '\f')||(LA7_17 >= '\u000E' && LA7_17 <= '\uFFFF')) ) {s = 25;}

                        else s = 43;

                        if ( s>=0 ) return s;
                        break;

                    case 15 : 
                        int LA7_142 = input.LA(1);

                        s = -1;
                        if ( ((LA7_142 >= '\u0000' && LA7_142 <= '\t')||(LA7_142 >= '\u000B' && LA7_142 <= '\f')||(LA7_142 >= '\u000E' && LA7_142 <= '\uFFFF')) ) {s = 25;}

                        else s = 147;

                        if ( s>=0 ) return s;
                        break;

                    case 16 : 
                        int LA7_128 = input.LA(1);

                        s = -1;
                        if ( ((LA7_128 >= '\u0000' && LA7_128 <= '\t')||(LA7_128 >= '\u000B' && LA7_128 <= '\f')||(LA7_128 >= '\u000E' && LA7_128 <= '\uFFFF')) ) {s = 25;}

                        else s = 136;

                        if ( s>=0 ) return s;
                        break;

                    case 17 : 
                        int LA7_15 = input.LA(1);

                        s = -1;
                        if ( ((LA7_15 >= '\u0000' && LA7_15 <= '\t')||(LA7_15 >= '\u000B' && LA7_15 <= '\f')||(LA7_15 >= '\u000E' && LA7_15 <= '\uFFFF')) ) {s = 25;}

                        else s = 41;

                        if ( s>=0 ) return s;
                        break;

                    case 18 : 
                        int LA7_16 = input.LA(1);

                        s = -1;
                        if ( ((LA7_16 >= '\u0000' && LA7_16 <= '\t')||(LA7_16 >= '\u000B' && LA7_16 <= '\f')||(LA7_16 >= '\u000E' && LA7_16 <= '\uFFFF')) ) {s = 25;}

                        else s = 42;

                        if ( s>=0 ) return s;
                        break;

                    case 19 : 
                        int LA7_101 = input.LA(1);

                        s = -1;
                        if ( ((LA7_101 >= '\u0000' && LA7_101 <= '\t')||(LA7_101 >= '\u000B' && LA7_101 <= '\f')||(LA7_101 >= '\u000E' && LA7_101 <= '\uFFFF')) ) {s = 25;}

                        else s = 114;

                        if ( s>=0 ) return s;
                        break;

                    case 20 : 
                        int LA7_24 = input.LA(1);

                        s = -1;
                        if ( ((LA7_24 >= '\u0000' && LA7_24 <= '\t')||(LA7_24 >= '\u000B' && LA7_24 <= '\f')||(LA7_24 >= '\u000E' && LA7_24 <= '\uFFFF')) ) {s = 25;}

                        else s = 49;

                        if ( s>=0 ) return s;
                        break;

                    case 21 : 
                        int LA7_140 = input.LA(1);

                        s = -1;
                        if ( ((LA7_140 >= '\u0000' && LA7_140 <= '\t')||(LA7_140 >= '\u000B' && LA7_140 <= '\f')||(LA7_140 >= '\u000E' && LA7_140 <= '\uFFFF')) ) {s = 25;}

                        else s = 145;

                        if ( s>=0 ) return s;
                        break;

                    case 22 : 
                        int LA7_12 = input.LA(1);

                        s = -1;
                        if ( ((LA7_12 >= '\u0000' && LA7_12 <= '\t')||(LA7_12 >= '\u000B' && LA7_12 <= '\f')||(LA7_12 >= '\u000E' && LA7_12 <= '\uFFFF')) ) {s = 25;}

                        else s = 38;

                        if ( s>=0 ) return s;
                        break;

                    case 23 : 
                        int LA7_56 = input.LA(1);

                        s = -1;
                        if ( ((LA7_56 >= '\u0000' && LA7_56 <= '\t')||(LA7_56 >= '\u000B' && LA7_56 <= '\f')||(LA7_56 >= '\u000E' && LA7_56 <= '\uFFFF')) ) {s = 25;}

                        else s = 72;

                        if ( s>=0 ) return s;
                        break;

                    case 24 : 
                        int LA7_23 = input.LA(1);

                        s = -1;
                        if ( ((LA7_23 >= '\u0000' && LA7_23 <= '\t')||(LA7_23 >= '\u000B' && LA7_23 <= '\f')||(LA7_23 >= '\u000E' && LA7_23 <= '\uFFFF')) ) {s = 25;}

                        else s = 49;

                        if ( s>=0 ) return s;
                        break;

                    case 25 : 
                        int LA7_115 = input.LA(1);

                        s = -1;
                        if ( ((LA7_115 >= '\u0000' && LA7_115 <= '\t')||(LA7_115 >= '\u000B' && LA7_115 <= '\f')||(LA7_115 >= '\u000E' && LA7_115 <= '\uFFFF')) ) {s = 25;}

                        else s = 124;

                        if ( s>=0 ) return s;
                        break;

                    case 26 : 
                        int LA7_138 = input.LA(1);

                        s = -1;
                        if ( ((LA7_138 >= '\u0000' && LA7_138 <= '\t')||(LA7_138 >= '\u000B' && LA7_138 <= '\f')||(LA7_138 >= '\u000E' && LA7_138 <= '\uFFFF')) ) {s = 25;}

                        else s = 143;

                        if ( s>=0 ) return s;
                        break;

                    case 27 : 
                        int LA7_149 = input.LA(1);

                        s = -1;
                        if ( ((LA7_149 >= '\u0000' && LA7_149 <= '\t')||(LA7_149 >= '\u000B' && LA7_149 <= '\f')||(LA7_149 >= '\u000E' && LA7_149 <= '\uFFFF')) ) {s = 25;}

                        else s = 151;

                        if ( s>=0 ) return s;
                        break;

                    case 28 : 
                        int LA7_150 = input.LA(1);

                        s = -1;
                        if ( ((LA7_150 >= '\u0000' && LA7_150 <= '\t')||(LA7_150 >= '\u000B' && LA7_150 <= '\f')||(LA7_150 >= '\u000E' && LA7_150 <= '\uFFFF')) ) {s = 25;}

                        else s = 152;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 7, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}