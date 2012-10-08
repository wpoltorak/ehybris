// $ANTLR 3.4 /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g 2012-10-08 10:43:19

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
    public static final int Identifier=23;
    public static final int IgnoreKeyCase=24;
    public static final int IgnoreNull=25;
    public static final int Insert=26;
    public static final int InsertUpdate=27;
    public static final int LeftBracket=28;
    public static final int LeftParenthesis=29;
    public static final int LineBreak=30;
    public static final int LineContinuation=31;
    public static final int MACRO=32;
    public static final int Macrodef=33;
    public static final int Macroval=34;
    public static final int Pos=35;
    public static final int Processor=36;
    public static final int ROW=37;
    public static final int ROWS=38;
    public static final int Remove=39;
    public static final int RightBracket=40;
    public static final int RightParenthesis=41;
    public static final int SIMPLE_ATTRIBUTE=42;
    public static final int Semicolon=43;
    public static final int Unique=44;
    public static final int Update=45;
    public static final int Virtual=46;
    public static final int Ws=47;

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
    public String getGrammarFileName() { return "/home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g"; }

    // $ANTLR start "Insert"
    public final void mInsert() throws RecognitionException {
        try {
            int _type = Insert;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:89:9: ( 'INSERT' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:89:10: 'INSERT'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:90:14: ( 'INSERT_UPDATE' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:90:15: 'INSERT_UPDATE'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:91:9: ( 'UPDATE' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:91:10: 'UPDATE'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:92:9: ( 'REMOVE' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:92:10: 'REMOVE'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:94:12: ( 'batchmode' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:94:13: 'batchmode'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:95:14: ( 'cacheUnique' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:95:15: 'cacheUnique'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:96:12: ( 'processor' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:96:13: 'processor'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:98:8: ( 'alias' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:98:9: 'alias'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:99:12: ( 'allownull' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:99:13: 'allownull'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:100:13: ( 'forceWrite' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:100:14: 'forceWrite'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:101:15: ( 'ignoreKeyCase' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:101:16: 'ignoreKeyCase'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:102:13: ( 'ignorenull' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:102:14: 'ignorenull'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:103:9: ( 'unique' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:103:10: 'unique'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:104:10: ( 'virtual' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:104:11: 'virtual'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:105:6: ( 'pos' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:105:7: 'pos'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:108:12: ( ';' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:108:13: ';'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:109:15: ( ']' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:109:16: ']'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:110:14: ( '[' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:110:15: '['
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:111:18: ( '(' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:111:19: '('
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:112:18: ( ')' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:112:19: ')'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:113:9: ( '=' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:113:10: '='
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:114:8: ( ',' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:114:9: ','
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:117:18: ( '\\\\\\\\' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:117:19: '\\\\\\\\'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:120:2: ( '$' Identifier )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:120:4: '$' Identifier
            {
            match('$'); 

            mIdentifier(); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Macrodef"

    // $ANTLR start "Identifier"
    public final void mIdentifier() throws RecognitionException {
        try {
            int _type = Identifier;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:124:2: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:124:4: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:124:36: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:
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
    // $ANTLR end "Identifier"

    // $ANTLR start "Comment"
    public final void mComment() throws RecognitionException {
        try {
            int _type = Comment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:135:2: ( '#' (~ ( '\\u000d' | '\\u000a' ) )* )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:135:4: '#' (~ ( '\\u000d' | '\\u000a' ) )*
            {
            match('#'); 

            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:135:8: (~ ( '\\u000d' | '\\u000a' ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\f')||(LA2_0 >= '\u000E' && LA2_0 <= '\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:139:2: ( ( '\\u000d' )? '\\u000a' | '\\u000d' )
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
                    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:139:4: ( '\\u000d' )? '\\u000a'
                    {
                    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:139:4: ( '\\u000d' )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='\r') ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:139:4: '\\u000d'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    }
                    break;
                case 2 :
                    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:140:4: '\\u000d'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:145:2: ( '\\u0020' | '\\u0009' )
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
                    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:145:4: '\\u0020'
                    {
                    match(' '); 

                    }
                    break;
                case 2 :
                    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:145:15: '\\u0009'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:160:2: ( Equals ( options {greedy=false; } : . )* LineBreak )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:160:4: Equals ( options {greedy=false; } : . )* LineBreak
            {
            mEquals(); 


            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:160:11: ( options {greedy=false; } : . )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\r') ) {
                    alt6=2;
                }
                else if ( (LA6_0=='\n') ) {
                    alt6=2;
                }
                else if ( ((LA6_0 >= '\u0000' && LA6_0 <= '\t')||(LA6_0 >= '\u000B' && LA6_0 <= '\f')||(LA6_0 >= '\u000E' && LA6_0 <= '\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:160:37: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            mLineBreak(); 


            }

            state.type = _type;
            state.channel = _channel;

            //		int last = getText().length();
            //		int lastn = getText().lastIndexOf('\n');
            //		int lastr = getText().lastIndexOf('\r');
            //		
            //		last = lastn > 0 ? lastn : last;
            //		last = lastr > 0 ? lastr : last;
            		//to strip '=' prefix and LineBreak suffix
            //  		setText(getText().substring(1, last));
              		setText(getText().substring(1, getText().length()).trim());
            	
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Macroval"

    public void mTokens() throws RecognitionException {
        // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:8: ( Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | ForceWrite | IgnoreKeyCase | IgnoreNull | Unique | Virtual | Pos | Semicolon | RightBracket | LeftBracket | LeftParenthesis | RightParenthesis | Equals | Comma | LineContinuation | Macrodef | Identifier | Comment | LineBreak | Ws | Macroval )
        int alt7=29;
        alt7 = dfa7.predict(input);
        switch (alt7) {
            case 1 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:10: Insert
                {
                mInsert(); 


                }
                break;
            case 2 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:17: InsertUpdate
                {
                mInsertUpdate(); 


                }
                break;
            case 3 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:30: Update
                {
                mUpdate(); 


                }
                break;
            case 4 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:37: Remove
                {
                mRemove(); 


                }
                break;
            case 5 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:44: BatchMode
                {
                mBatchMode(); 


                }
                break;
            case 6 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:54: CacheUnique
                {
                mCacheUnique(); 


                }
                break;
            case 7 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:66: Processor
                {
                mProcessor(); 


                }
                break;
            case 8 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:76: Alias
                {
                mAlias(); 


                }
                break;
            case 9 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:82: AllowNull
                {
                mAllowNull(); 


                }
                break;
            case 10 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:92: ForceWrite
                {
                mForceWrite(); 


                }
                break;
            case 11 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:103: IgnoreKeyCase
                {
                mIgnoreKeyCase(); 


                }
                break;
            case 12 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:117: IgnoreNull
                {
                mIgnoreNull(); 


                }
                break;
            case 13 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:128: Unique
                {
                mUnique(); 


                }
                break;
            case 14 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:135: Virtual
                {
                mVirtual(); 


                }
                break;
            case 15 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:143: Pos
                {
                mPos(); 


                }
                break;
            case 16 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:147: Semicolon
                {
                mSemicolon(); 


                }
                break;
            case 17 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:157: RightBracket
                {
                mRightBracket(); 


                }
                break;
            case 18 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:170: LeftBracket
                {
                mLeftBracket(); 


                }
                break;
            case 19 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:182: LeftParenthesis
                {
                mLeftParenthesis(); 


                }
                break;
            case 20 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:198: RightParenthesis
                {
                mRightParenthesis(); 


                }
                break;
            case 21 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:215: Equals
                {
                mEquals(); 


                }
                break;
            case 22 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:222: Comma
                {
                mComma(); 


                }
                break;
            case 23 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:228: LineContinuation
                {
                mLineContinuation(); 


                }
                break;
            case 24 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:245: Macrodef
                {
                mMacrodef(); 


                }
                break;
            case 25 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:254: Identifier
                {
                mIdentifier(); 


                }
                break;
            case 26 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:265: Comment
                {
                mComment(); 


                }
                break;
            case 27 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:273: LineBreak
                {
                mLineBreak(); 


                }
                break;
            case 28 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:283: Ws
                {
                mWs(); 


                }
                break;
            case 29 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:286: Macroval
                {
                mMacroval(); 


                }
                break;

        }

    }


    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA7_eotS =
        "\1\uffff\13\25\5\uffff\1\45\7\uffff\14\25\2\uffff\6\25\1\72\14\25"+
        "\1\uffff\14\25\1\123\5\25\1\132\1\133\1\134\3\25\1\uffff\3\25\1"+
        "\144\2\25\3\uffff\7\25\1\uffff\1\156\10\25\1\uffff\1\25\1\170\1"+
        "\25\1\172\1\173\4\25\1\uffff\1\25\2\uffff\1\u0081\1\25\1\u0083\1"+
        "\25\1\u0085\1\uffff\1\25\1\uffff\1\25\1\uffff\1\25\1\u0089\1\u008a"+
        "\2\uffff";
    static final String DFA7_eofS =
        "\u008b\uffff";
    static final String DFA7_minS =
        "\1\11\1\116\1\120\1\105\2\141\1\157\1\154\1\157\1\147\1\156\1\151"+
        "\5\uffff\1\0\7\uffff\1\123\1\104\1\115\1\164\1\143\1\157\1\163\1"+
        "\151\1\162\1\156\1\151\1\162\2\uffff\1\105\1\101\1\117\1\143\1\150"+
        "\1\143\1\60\1\141\1\157\1\143\1\157\1\161\1\164\1\122\1\124\1\126"+
        "\1\150\2\145\1\uffff\1\163\1\167\1\145\1\162\2\165\1\124\2\105\1"+
        "\155\1\125\1\163\1\60\1\156\1\127\2\145\1\141\3\60\1\157\1\156\1"+
        "\163\1\uffff\1\165\1\162\1\113\1\60\1\154\1\125\3\uffff\1\144\1"+
        "\151\1\157\1\154\1\151\1\145\1\165\1\uffff\1\60\1\120\1\145\1\161"+
        "\1\162\1\154\1\164\1\171\1\154\1\uffff\1\104\1\60\1\165\2\60\1\145"+
        "\1\103\1\154\1\101\1\uffff\1\145\2\uffff\1\60\1\141\1\60\1\124\1"+
        "\60\1\uffff\1\163\1\uffff\1\105\1\uffff\1\145\2\60\2\uffff";
    static final String DFA7_maxS =
        "\1\172\1\116\1\120\1\105\2\141\1\162\1\154\1\157\1\147\1\156\1\151"+
        "\5\uffff\1\uffff\7\uffff\1\123\1\104\1\115\1\164\1\143\1\157\1\163"+
        "\1\154\1\162\1\156\1\151\1\162\2\uffff\1\105\1\101\1\117\1\143\1"+
        "\150\1\143\1\172\1\141\1\157\1\143\1\157\1\161\1\164\1\122\1\124"+
        "\1\126\1\150\2\145\1\uffff\1\163\1\167\1\145\1\162\2\165\1\124\2"+
        "\105\1\155\1\125\1\163\1\172\1\156\1\127\2\145\1\141\3\172\1\157"+
        "\1\156\1\163\1\uffff\1\165\1\162\1\156\1\172\1\154\1\125\3\uffff"+
        "\1\144\1\151\1\157\1\154\1\151\1\145\1\165\1\uffff\1\172\1\120\1"+
        "\145\1\161\1\162\1\154\1\164\1\171\1\154\1\uffff\1\104\1\172\1\165"+
        "\2\172\1\145\1\103\1\154\1\101\1\uffff\1\145\2\uffff\1\172\1\141"+
        "\1\172\1\124\1\172\1\uffff\1\163\1\uffff\1\105\1\uffff\1\145\2\172"+
        "\2\uffff";
    static final String DFA7_acceptS =
        "\14\uffff\1\20\1\21\1\22\1\23\1\24\1\uffff\1\26\1\27\1\30\1\31\1"+
        "\32\1\33\1\34\14\uffff\1\25\1\35\23\uffff\1\17\30\uffff\1\10\6\uffff"+
        "\1\1\1\3\1\4\7\uffff\1\15\11\uffff\1\16\11\uffff\1\5\1\uffff\1\7"+
        "\1\11\5\uffff\1\12\1\uffff\1\14\1\uffff\1\6\3\uffff\1\2\1\13";
    static final String DFA7_specialS =
        "\21\uffff\1\0\171\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\30\1\27\2\uffff\1\27\22\uffff\1\30\2\uffff\1\26\1\24\3\uffff"+
            "\1\17\1\20\2\uffff\1\22\16\uffff\1\14\1\uffff\1\21\3\uffff\10"+
            "\25\1\1\10\25\1\3\2\25\1\2\5\25\1\16\1\23\1\15\1\uffff\1\25"+
            "\1\uffff\1\7\1\4\1\5\2\25\1\10\2\25\1\11\6\25\1\6\4\25\1\12"+
            "\1\13\4\25",
            "\1\31",
            "\1\32",
            "\1\33",
            "\1\34",
            "\1\35",
            "\1\37\2\uffff\1\36",
            "\1\40",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\44",
            "",
            "",
            "",
            "",
            "",
            "\0\46",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55",
            "\1\56\2\uffff\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "",
            "",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\12\25\7\uffff\32\25\4\uffff\1\131\1\uffff\32\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\135",
            "\1\136",
            "\1\137",
            "",
            "\1\140",
            "\1\141",
            "\1\142\42\uffff\1\143",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\145",
            "\1\146",
            "",
            "",
            "",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "",
            "\1\167",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\171",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "",
            "\1\u0080",
            "",
            "",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\u0082",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\1\u0084",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "",
            "\1\u0086",
            "",
            "\1\u0087",
            "",
            "\1\u0088",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
            "\12\25\7\uffff\32\25\4\uffff\1\25\1\uffff\32\25",
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
            return "1:1: Tokens : ( Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | ForceWrite | IgnoreKeyCase | IgnoreNull | Unique | Virtual | Pos | Semicolon | RightBracket | LeftBracket | LeftParenthesis | RightParenthesis | Equals | Comma | LineContinuation | Macrodef | Identifier | Comment | LineBreak | Ws | Macroval );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA7_17 = input.LA(1);

                        s = -1;
                        if ( ((LA7_17 >= '\u0000' && LA7_17 <= '\uFFFF')) ) {s = 38;}

                        else s = 37;

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