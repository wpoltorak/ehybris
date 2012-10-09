// $ANTLR 3.4 /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g 2012-10-08 23:09:21

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
    public static final int Pos=34;
    public static final int Processor=35;
    public static final int ROW=36;
    public static final int ROWS=37;
    public static final int Remove=38;
    public static final int RightBracket=39;
    public static final int RightParenthesis=40;
    public static final int SIMPLE_ATTRIBUTE=41;
    public static final int Semicolon=42;
    public static final int Text=43;
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
    public String getGrammarFileName() { return "/work/projects/yeclipse/ImpexAST/src/main/java/Impex.g"; }

    // $ANTLR start "Insert"
    public final void mInsert() throws RecognitionException {
        try {
            int _type = Insert;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:101:9: ( 'INSERT' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:101:10: 'INSERT'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:102:14: ( 'INSERT_UPDATE' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:102:15: 'INSERT_UPDATE'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:103:9: ( 'UPDATE' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:103:10: 'UPDATE'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:104:9: ( 'REMOVE' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:104:10: 'REMOVE'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:106:12: ( 'batchmode' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:106:13: 'batchmode'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:107:14: ( 'cacheUnique' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:107:15: 'cacheUnique'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:108:12: ( 'processor' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:108:13: 'processor'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:110:8: ( 'alias' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:110:9: 'alias'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:111:12: ( 'allownull' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:111:13: 'allownull'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:112:13: ( 'forceWrite' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:112:14: 'forceWrite'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:113:15: ( 'ignoreKeyCase' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:113:16: 'ignoreKeyCase'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:114:13: ( 'ignorenull' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:114:14: 'ignorenull'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:115:9: ( 'unique' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:115:10: 'unique'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:116:10: ( 'virtual' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:116:11: 'virtual'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:117:6: ( 'pos' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:117:7: 'pos'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:120:12: ( ';' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:120:13: ';'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:121:15: ( ']' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:121:16: ']'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:122:14: ( '[' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:122:15: '['
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:123:18: ( '(' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:123:19: '('
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:124:18: ( ')' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:124:19: ')'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:125:9: ( '=' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:125:10: '='
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:126:8: ( ',' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:126:9: ','
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:129:18: ( '\\\\\\\\' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:129:19: '\\\\\\\\'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:132:2: ( '$' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:132:4: '$' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:132:40: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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

    // $ANTLR start "Identifier"
    public final void mIdentifier() throws RecognitionException {
        try {
            int _type = Identifier;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:136:2: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:136:4: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:136:36: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
                    alt2=1;
                }


                switch (alt2) {
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
    // $ANTLR end "Identifier"

    // $ANTLR start "Comment"
    public final void mComment() throws RecognitionException {
        try {
            int _type = Comment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:148:2: ( '#' ( options {greedy=false; } : . )* ( ( '\\r' )? '\\n' | '\\r' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:148:4: '#' ( options {greedy=false; } : . )* ( ( '\\r' )? '\\n' | '\\r' )
            {
            match('#'); 

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:148:7: ( options {greedy=false; } : . )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='\r') ) {
                    alt3=2;
                }
                else if ( (LA3_0=='\n') ) {
                    alt3=2;
                }
                else if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '\f')||(LA3_0 >= '\u000E' && LA3_0 <= '\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:148:33: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:148:37: ( ( '\\r' )? '\\n' | '\\r' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\r') ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1=='\n') ) {
                    alt5=1;
                }
                else {
                    alt5=2;
                }
            }
            else if ( (LA5_0=='\n') ) {
                alt5=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;

            }
            switch (alt5) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:148:38: ( '\\r' )? '\\n'
                    {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:148:38: ( '\\r' )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0=='\r') ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:148:38: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:148:51: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }


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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:153:2: ( ( '\\u000d' )? '\\u000a' | '\\u000d' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='\r') ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1=='\n') ) {
                    alt7=1;
                }
                else {
                    alt7=2;
                }
            }
            else if ( (LA7_0=='\n') ) {
                alt7=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;

            }
            switch (alt7) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:153:4: ( '\\u000d' )? '\\u000a'
                    {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:153:4: ( '\\u000d' )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0=='\r') ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:153:4: '\\u000d'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:154:4: '\\u000d'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:159:2: ( '\\u0020' | '\\u0009' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==' ') ) {
                alt8=1;
            }
            else if ( (LA8_0=='\t') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:159:4: '\\u0020'
                    {
                    match(' '); 

                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:159:15: '\\u0009'
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

    // $ANTLR start "Text"
    public final void mText() throws RecognitionException {
        try {
            int _type = Text;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:170:2: ( ( options {greedy=false; } : . )* ( ( '\\r' )? '\\n' | '\\r' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:170:4: ( options {greedy=false; } : . )* ( ( '\\r' )? '\\n' | '\\r' )
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:170:4: ( options {greedy=false; } : . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='\r') ) {
                    alt9=2;
                }
                else if ( (LA9_0=='\n') ) {
                    alt9=2;
                }
                else if ( ((LA9_0 >= '\u0000' && LA9_0 <= '\t')||(LA9_0 >= '\u000B' && LA9_0 <= '\f')||(LA9_0 >= '\u000E' && LA9_0 <= '\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:170:30: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:170:34: ( ( '\\r' )? '\\n' | '\\r' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='\r') ) {
                int LA11_1 = input.LA(2);

                if ( (LA11_1=='\n') ) {
                    alt11=1;
                }
                else {
                    alt11=2;
                }
            }
            else if ( (LA11_0=='\n') ) {
                alt11=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }
            switch (alt11) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:170:35: ( '\\r' )? '\\n'
                    {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:170:35: ( '\\r' )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0=='\r') ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:170:35: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:170:48: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Text"

    public void mTokens() throws RecognitionException {
        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:8: ( Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | ForceWrite | IgnoreKeyCase | IgnoreNull | Unique | Virtual | Pos | Semicolon | RightBracket | LeftBracket | LeftParenthesis | RightParenthesis | Equals | Comma | LineContinuation | Macrodef | Identifier | Comment | LineBreak | Ws | Text )
        int alt12=29;
        alt12 = dfa12.predict(input);
        switch (alt12) {
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
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:254: Identifier
                {
                mIdentifier(); 


                }
                break;
            case 26 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:265: Comment
                {
                mComment(); 


                }
                break;
            case 27 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:273: LineBreak
                {
                mLineBreak(); 


                }
                break;
            case 28 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:283: Ws
                {
                mWs(); 


                }
                break;
            case 29 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:286: Text
                {
                mText(); 


                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\13\36\1\52\1\53\1\54\1\55\1\56\1\57\1\60\2\uffff\1\36\1"+
        "\uffff\2\66\2\67\1\uffff\2\36\1\uffff\13\36\7\uffff\1\105\1\107"+
        "\2\110\3\uffff\6\36\1\117\6\36\1\uffff\1\107\2\uffff\6\36\1\uffff"+
        "\14\36\1\150\5\36\1\157\1\160\1\161\3\36\1\uffff\3\36\1\171\2\36"+
        "\3\uffff\7\36\1\uffff\1\u0083\10\36\1\uffff\1\36\1\u008d\1\36\1"+
        "\u008f\1\u0090\4\36\1\uffff\1\36\2\uffff\1\u0096\1\36\1\u0098\1"+
        "\36\1\u009a\1\uffff\1\36\1\uffff\1\36\1\uffff\1\36\1\u009e\1\u009f"+
        "\2\uffff";
    static final String DFA12_eofS =
        "\u00a0\uffff";
    static final String DFA12_minS =
        "\33\0\1\uffff\2\0\1\uffff\13\0\7\uffff\5\0\2\uffff\15\0\1\uffff"+
        "\1\0\2\uffff\6\0\1\uffff\30\0\1\uffff\6\0\3\uffff\7\0\1\uffff\11"+
        "\0\1\uffff\11\0\1\uffff\1\0\2\uffff\5\0\1\uffff\1\0\1\uffff\1\0"+
        "\1\uffff\3\0\2\uffff";
    static final String DFA12_maxS =
        "\33\uffff\1\uffff\2\uffff\1\uffff\13\uffff\7\uffff\5\uffff\2\uffff"+
        "\15\uffff\1\uffff\1\uffff\2\uffff\6\uffff\1\uffff\30\uffff\1\uffff"+
        "\6\uffff\3\uffff\7\uffff\1\uffff\11\uffff\1\uffff\11\uffff\1\uffff"+
        "\1\uffff\2\uffff\5\uffff\1\uffff\1\uffff\1\uffff\1\uffff\1\uffff"+
        "\3\uffff\2\uffff";
    static final String DFA12_acceptS =
        "\33\uffff\1\35\2\uffff\1\31\13\uffff\1\20\1\21\1\22\1\23\1\24\1"+
        "\25\1\26\5\uffff\1\33\1\34\15\uffff\1\27\1\uffff\1\30\1\32\6\uffff"+
        "\1\17\30\uffff\1\10\6\uffff\1\1\1\3\1\4\7\uffff\1\15\11\uffff\1"+
        "\16\11\uffff\1\5\1\uffff\1\7\1\11\5\uffff\1\12\1\uffff\1\14\1\uffff"+
        "\1\6\3\uffff\1\2\1\13";
    static final String DFA12_specialS =
        "\1\64\1\131\1\141\1\163\1\113\1\116\1\117\1\103\1\u0081\1\166\1"+
        "\26\1\23\1\173\1\172\1\175\1\u0082\1\13\1\17\1\11\1\122\1\72\1\3"+
        "\1\150\1\25\1\160\1\154\1\63\1\uffff\1\46\1\171\1\uffff\1\133\1"+
        "\144\1\156\1\71\1\55\1\30\1\176\1\104\1\140\1\2\1\33\7\uffff\1\27"+
        "\1\167\1\170\1\120\1\132\2\uffff\1\44\1\135\1\146\1\155\1\70\1\51"+
        "\1\52\1\37\1\110\1\76\1\145\1\0\1\31\1\uffff\1\12\2\uffff\1\42\1"+
        "\136\1\142\1\153\1\66\1\53\1\uffff\1\40\1\107\1\77\1\147\1\1\1\35"+
        "\1\41\1\134\1\143\1\164\1\65\1\47\1\174\1\112\1\100\1\151\1\4\1"+
        "\34\1\115\1\67\1\121\1\162\1\62\1\50\1\uffff\1\111\1\101\1\152\1"+
        "\24\1\36\1\124\3\uffff\1\161\1\61\1\43\1\106\1\73\1\16\1\7\1\uffff"+
        "\1\54\1\123\1\157\1\60\1\45\1\105\1\74\1\15\1\5\1\uffff\1\126\1"+
        "\114\1\57\1\137\1\u0080\1\75\1\14\1\6\1\125\1\uffff\1\56\2\uffff"+
        "\1\177\1\22\1\32\1\130\1\165\1\uffff\1\21\1\uffff\1\127\1\uffff"+
        "\1\20\1\102\1\10\2\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\33\1\32\1\30\2\33\1\27\22\33\1\31\2\33\1\26\1\24\3\33\1"+
            "\17\1\20\2\33\1\22\16\33\1\14\1\33\1\21\3\33\10\25\1\1\10\25"+
            "\1\3\2\25\1\2\5\25\1\16\1\23\1\15\1\33\1\25\1\33\1\7\1\4\1\5"+
            "\2\25\1\10\2\25\1\11\6\25\1\6\4\25\1\12\1\13\4\25\uff85\33",
            "\60\33\12\35\7\33\15\35\1\34\14\35\4\33\1\35\1\33\32\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\17\35\1\37\12\35\4\33\1\35\1\33\32\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\4\35\1\40\25\35\4\33\1\35\1\33\32\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\1\41\31\35\uff85\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\1\42\31\35\uff85\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\16\35\1\44\2\35\1\43"+
            "\10\35\uff85\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\13\35\1\45\16\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\16\35\1\46\13\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\6\35\1\47\23\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\15\35\1\50\14\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\10\35\1\51\21\35\uff85"+
            "\33",
            "\0\33",
            "\0\33",
            "\0\33",
            "\0\33",
            "\0\33",
            "\0\33",
            "\0\33",
            "\134\33\1\61\uffa3\33",
            "\101\33\32\62\4\33\1\62\1\33\32\62\uff85\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\32\35\uff85\33",
            "\12\65\1\64\2\65\1\63\ufff2\65",
            "\12\33\1\30\ufff5\33",
            "\0\33",
            "\0\33",
            "\0\33",
            "",
            "\60\33\12\35\7\33\22\35\1\70\7\35\4\33\1\35\1\33\32\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\32\35\uff85\33",
            "",
            "\60\33\12\35\7\33\3\35\1\71\26\35\4\33\1\35\1\33\32\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\14\35\1\72\15\35\4\33\1\35\1\33\32\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\23\35\1\73\6\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\2\35\1\74\27\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\16\35\1\75\13\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\22\35\1\76\7\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\10\35\1\77\2\35\1\100"+
            "\16\35\uff85\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\21\35\1\101\10\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\15\35\1\102\14\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\10\35\1\103\21\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\21\35\1\104\10\35\uff85"+
            "\33",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\0\33",
            "\60\33\12\106\7\33\32\106\4\33\1\106\1\33\32\106\uff85\33",
            "\12\65\1\64\2\65\1\63\ufff2\65",
            "\12\65\1\64\2\65\1\63\ufff2\65",
            "\12\65\1\64\2\65\1\63\ufff2\65",
            "",
            "",
            "\60\33\12\35\7\33\4\35\1\111\25\35\4\33\1\35\1\33\32\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\1\112\31\35\4\33\1\35\1\33\32\35\uff85\33",
            "\60\33\12\35\7\33\16\35\1\113\13\35\4\33\1\35\1\33\32\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\2\35\1\114\27\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\7\35\1\115\22\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\2\35\1\116\27\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\32\35\uff85\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\1\120\31\35\uff85\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\16\35\1\121\13\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\2\35\1\122\27\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\16\35\1\123\13\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\20\35\1\124\11\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\23\35\1\125\6\35\uff85"+
            "\33",
            "",
            "\60\33\12\106\7\33\32\106\4\33\1\106\1\33\32\106\uff85\33",
            "",
            "",
            "\60\33\12\35\7\33\21\35\1\126\10\35\4\33\1\35\1\33\32\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\23\35\1\127\6\35\4\33\1\35\1\33\32\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\25\35\1\130\4\35\4\33\1\35\1\33\32\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\7\35\1\131\22\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\4\35\1\132\25\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\4\35\1\133\25\35\uff85"+
            "\33",
            "",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\22\35\1\134\7\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\26\35\1\135\3\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\4\35\1\136\25\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\21\35\1\137\10\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\24\35\1\140\5\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\24\35\1\141\5\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\23\35\1\142\6\35\4\33\1\35\1\33\32\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\4\35\1\143\25\35\4\33\1\35\1\33\32\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\4\35\1\144\25\35\4\33\1\35\1\33\32\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\14\35\1\145\15\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\24\35\1\146\5\35\4\33\1\35\1\33\32\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\22\35\1\147\7\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\32\35\uff85\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\15\35\1\151\14\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\26\35\1\152\3\35\4\33\1\35\1\33\32\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\4\35\1\153\25\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\4\35\1\154\25\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\1\155\31\35\uff85\33",
            "\60\33\12\35\7\33\32\35\4\33\1\156\1\33\32\35\uff85\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\32\35\uff85\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\32\35\uff85\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\16\35\1\162\13\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\15\35\1\163\14\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\22\35\1\164\7\35\uff85"+
            "\33",
            "",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\24\35\1\165\5\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\21\35\1\166\10\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\12\35\1\167\17\35\4\33\1\35\1\33\15\35\1"+
            "\170\14\35\uff85\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\32\35\uff85\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\13\35\1\172\16\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\24\35\1\173\5\35\4\33\1\35\1\33\32\35\uff85"+
            "\33",
            "",
            "",
            "",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\3\35\1\174\26\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\10\35\1\175\21\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\16\35\1\176\13\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\13\35\1\177\16\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\10\35\1\u0080\21\35"+
            "\uff85\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\4\35\1\u0081\25\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\24\35\1\u0082\5\35\uff85"+
            "\33",
            "",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\32\35\uff85\33",
            "\60\33\12\35\7\33\17\35\1\u0084\12\35\4\33\1\35\1\33\32\35"+
            "\uff85\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\4\35\1\u0085\25\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\20\35\1\u0086\11\35"+
            "\uff85\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\21\35\1\u0087\10\35"+
            "\uff85\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\13\35\1\u0088\16\35"+
            "\uff85\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\23\35\1\u0089\6\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\30\35\1\u008a\1\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\13\35\1\u008b\16\35"+
            "\uff85\33",
            "",
            "\60\33\12\35\7\33\3\35\1\u008c\26\35\4\33\1\35\1\33\32\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\32\35\uff85\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\24\35\1\u008e\5\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\32\35\uff85\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\32\35\uff85\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\4\35\1\u0091\25\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\2\35\1\u0092\27\35\4\33\1\35\1\33\32\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\13\35\1\u0093\16\35"+
            "\uff85\33",
            "\60\33\12\35\7\33\1\u0094\31\35\4\33\1\35\1\33\32\35\uff85"+
            "\33",
            "",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\4\35\1\u0095\25\35\uff85"+
            "\33",
            "",
            "",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\32\35\uff85\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\1\u0097\31\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\32\35\uff85\33",
            "\60\33\12\35\7\33\23\35\1\u0099\6\35\4\33\1\35\1\33\32\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\32\35\uff85\33",
            "",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\22\35\1\u009b\7\35\uff85"+
            "\33",
            "",
            "\60\33\12\35\7\33\4\35\1\u009c\25\35\4\33\1\35\1\33\32\35\uff85"+
            "\33",
            "",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\4\35\1\u009d\25\35\uff85"+
            "\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\32\35\uff85\33",
            "\60\33\12\35\7\33\32\35\4\33\1\35\1\33\32\35\uff85\33",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | ForceWrite | IgnoreKeyCase | IgnoreNull | Unique | Virtual | Pos | Semicolon | RightBracket | LeftBracket | LeftParenthesis | RightParenthesis | Equals | Comma | LineContinuation | Macrodef | Identifier | Comment | LineBreak | Ws | Text );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_67 = input.LA(1);

                        s = -1;
                        if ( (LA12_67=='q') ) {s = 84;}

                        else if ( ((LA12_67 >= '0' && LA12_67 <= '9')||(LA12_67 >= 'A' && LA12_67 <= 'Z')||LA12_67=='_'||(LA12_67 >= 'a' && LA12_67 <= 'p')||(LA12_67 >= 'r' && LA12_67 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_67 >= '\u0000' && LA12_67 <= '/')||(LA12_67 >= ':' && LA12_67 <= '@')||(LA12_67 >= '[' && LA12_67 <= '^')||LA12_67=='`'||(LA12_67 >= '{' && LA12_67 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA12_84 = input.LA(1);

                        s = -1;
                        if ( (LA12_84=='u') ) {s = 96;}

                        else if ( ((LA12_84 >= '0' && LA12_84 <= '9')||(LA12_84 >= 'A' && LA12_84 <= 'Z')||LA12_84=='_'||(LA12_84 >= 'a' && LA12_84 <= 't')||(LA12_84 >= 'v' && LA12_84 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_84 >= '\u0000' && LA12_84 <= '/')||(LA12_84 >= ':' && LA12_84 <= '@')||(LA12_84 >= '[' && LA12_84 <= '^')||LA12_84=='`'||(LA12_84 >= '{' && LA12_84 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA12_40 = input.LA(1);

                        s = -1;
                        if ( (LA12_40=='i') ) {s = 67;}

                        else if ( ((LA12_40 >= '0' && LA12_40 <= '9')||(LA12_40 >= 'A' && LA12_40 <= 'Z')||LA12_40=='_'||(LA12_40 >= 'a' && LA12_40 <= 'h')||(LA12_40 >= 'j' && LA12_40 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_40 >= '\u0000' && LA12_40 <= '/')||(LA12_40 >= ':' && LA12_40 <= '@')||(LA12_40 >= '[' && LA12_40 <= '^')||LA12_40=='`'||(LA12_40 >= '{' && LA12_40 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA12_21 = input.LA(1);

                        s = -1;
                        if ( ((LA12_21 >= '0' && LA12_21 <= '9')||(LA12_21 >= 'A' && LA12_21 <= 'Z')||LA12_21=='_'||(LA12_21 >= 'a' && LA12_21 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_21 >= '\u0000' && LA12_21 <= '/')||(LA12_21 >= ':' && LA12_21 <= '@')||(LA12_21 >= '[' && LA12_21 <= '^')||LA12_21=='`'||(LA12_21 >= '{' && LA12_21 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA12_96 = input.LA(1);

                        s = -1;
                        if ( (LA12_96=='e') ) {s = 108;}

                        else if ( ((LA12_96 >= '0' && LA12_96 <= '9')||(LA12_96 >= 'A' && LA12_96 <= 'Z')||LA12_96=='_'||(LA12_96 >= 'a' && LA12_96 <= 'd')||(LA12_96 >= 'f' && LA12_96 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_96 >= '\u0000' && LA12_96 <= '/')||(LA12_96 >= ':' && LA12_96 <= '@')||(LA12_96 >= '[' && LA12_96 <= '^')||LA12_96=='`'||(LA12_96 >= '{' && LA12_96 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA12_130 = input.LA(1);

                        s = -1;
                        if ( (LA12_130=='l') ) {s = 139;}

                        else if ( ((LA12_130 >= '0' && LA12_130 <= '9')||(LA12_130 >= 'A' && LA12_130 <= 'Z')||LA12_130=='_'||(LA12_130 >= 'a' && LA12_130 <= 'k')||(LA12_130 >= 'm' && LA12_130 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_130 >= '\u0000' && LA12_130 <= '/')||(LA12_130 >= ':' && LA12_130 <= '@')||(LA12_130 >= '[' && LA12_130 <= '^')||LA12_130=='`'||(LA12_130 >= '{' && LA12_130 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 6 : 
                        int LA12_139 = input.LA(1);

                        s = -1;
                        if ( (LA12_139=='l') ) {s = 147;}

                        else if ( ((LA12_139 >= '0' && LA12_139 <= '9')||(LA12_139 >= 'A' && LA12_139 <= 'Z')||LA12_139=='_'||(LA12_139 >= 'a' && LA12_139 <= 'k')||(LA12_139 >= 'm' && LA12_139 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_139 >= '\u0000' && LA12_139 <= '/')||(LA12_139 >= ':' && LA12_139 <= '@')||(LA12_139 >= '[' && LA12_139 <= '^')||LA12_139=='`'||(LA12_139 >= '{' && LA12_139 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 7 : 
                        int LA12_120 = input.LA(1);

                        s = -1;
                        if ( (LA12_120=='u') ) {s = 130;}

                        else if ( ((LA12_120 >= '0' && LA12_120 <= '9')||(LA12_120 >= 'A' && LA12_120 <= 'Z')||LA12_120=='_'||(LA12_120 >= 'a' && LA12_120 <= 't')||(LA12_120 >= 'v' && LA12_120 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_120 >= '\u0000' && LA12_120 <= '/')||(LA12_120 >= ':' && LA12_120 <= '@')||(LA12_120 >= '[' && LA12_120 <= '^')||LA12_120=='`'||(LA12_120 >= '{' && LA12_120 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 8 : 
                        int LA12_157 = input.LA(1);

                        s = -1;
                        if ( ((LA12_157 >= '0' && LA12_157 <= '9')||(LA12_157 >= 'A' && LA12_157 <= 'Z')||LA12_157=='_'||(LA12_157 >= 'a' && LA12_157 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_157 >= '\u0000' && LA12_157 <= '/')||(LA12_157 >= ':' && LA12_157 <= '@')||(LA12_157 >= '[' && LA12_157 <= '^')||LA12_157=='`'||(LA12_157 >= '{' && LA12_157 <= '\uFFFF')) ) {s = 27;}

                        else s = 159;

                        if ( s>=0 ) return s;
                        break;

                    case 9 : 
                        int LA12_18 = input.LA(1);

                        s = -1;
                        if ( ((LA12_18 >= '\u0000' && LA12_18 <= '\uFFFF')) ) {s = 27;}

                        else s = 48;

                        if ( s>=0 ) return s;
                        break;

                    case 10 : 
                        int LA12_70 = input.LA(1);

                        s = -1;
                        if ( ((LA12_70 >= '0' && LA12_70 <= '9')||(LA12_70 >= 'A' && LA12_70 <= 'Z')||LA12_70=='_'||(LA12_70 >= 'a' && LA12_70 <= 'z')) ) {s = 70;}

                        else if ( ((LA12_70 >= '\u0000' && LA12_70 <= '/')||(LA12_70 >= ':' && LA12_70 <= '@')||(LA12_70 >= '[' && LA12_70 <= '^')||LA12_70=='`'||(LA12_70 >= '{' && LA12_70 <= '\uFFFF')) ) {s = 27;}

                        else s = 71;

                        if ( s>=0 ) return s;
                        break;

                    case 11 : 
                        int LA12_16 = input.LA(1);

                        s = -1;
                        if ( ((LA12_16 >= '\u0000' && LA12_16 <= '\uFFFF')) ) {s = 27;}

                        else s = 46;

                        if ( s>=0 ) return s;
                        break;

                    case 12 : 
                        int LA12_138 = input.LA(1);

                        s = -1;
                        if ( (LA12_138=='C') ) {s = 146;}

                        else if ( ((LA12_138 >= '0' && LA12_138 <= '9')||(LA12_138 >= 'A' && LA12_138 <= 'B')||(LA12_138 >= 'D' && LA12_138 <= 'Z')||LA12_138=='_'||(LA12_138 >= 'a' && LA12_138 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_138 >= '\u0000' && LA12_138 <= '/')||(LA12_138 >= ':' && LA12_138 <= '@')||(LA12_138 >= '[' && LA12_138 <= '^')||LA12_138=='`'||(LA12_138 >= '{' && LA12_138 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 13 : 
                        int LA12_129 = input.LA(1);

                        s = -1;
                        if ( (LA12_129=='y') ) {s = 138;}

                        else if ( ((LA12_129 >= '0' && LA12_129 <= '9')||(LA12_129 >= 'A' && LA12_129 <= 'Z')||LA12_129=='_'||(LA12_129 >= 'a' && LA12_129 <= 'x')||LA12_129=='z') ) {s = 29;}

                        else if ( ((LA12_129 >= '\u0000' && LA12_129 <= '/')||(LA12_129 >= ':' && LA12_129 <= '@')||(LA12_129 >= '[' && LA12_129 <= '^')||LA12_129=='`'||(LA12_129 >= '{' && LA12_129 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 14 : 
                        int LA12_119 = input.LA(1);

                        s = -1;
                        if ( (LA12_119=='e') ) {s = 129;}

                        else if ( ((LA12_119 >= '0' && LA12_119 <= '9')||(LA12_119 >= 'A' && LA12_119 <= 'Z')||LA12_119=='_'||(LA12_119 >= 'a' && LA12_119 <= 'd')||(LA12_119 >= 'f' && LA12_119 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_119 >= '\u0000' && LA12_119 <= '/')||(LA12_119 >= ':' && LA12_119 <= '@')||(LA12_119 >= '[' && LA12_119 <= '^')||LA12_119=='`'||(LA12_119 >= '{' && LA12_119 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 15 : 
                        int LA12_17 = input.LA(1);

                        s = -1;
                        if ( ((LA12_17 >= '\u0000' && LA12_17 <= '\uFFFF')) ) {s = 27;}

                        else s = 47;

                        if ( s>=0 ) return s;
                        break;

                    case 16 : 
                        int LA12_155 = input.LA(1);

                        s = -1;
                        if ( (LA12_155=='e') ) {s = 157;}

                        else if ( ((LA12_155 >= '0' && LA12_155 <= '9')||(LA12_155 >= 'A' && LA12_155 <= 'Z')||LA12_155=='_'||(LA12_155 >= 'a' && LA12_155 <= 'd')||(LA12_155 >= 'f' && LA12_155 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_155 >= '\u0000' && LA12_155 <= '/')||(LA12_155 >= ':' && LA12_155 <= '@')||(LA12_155 >= '[' && LA12_155 <= '^')||LA12_155=='`'||(LA12_155 >= '{' && LA12_155 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 17 : 
                        int LA12_151 = input.LA(1);

                        s = -1;
                        if ( (LA12_151=='s') ) {s = 155;}

                        else if ( ((LA12_151 >= '0' && LA12_151 <= '9')||(LA12_151 >= 'A' && LA12_151 <= 'Z')||LA12_151=='_'||(LA12_151 >= 'a' && LA12_151 <= 'r')||(LA12_151 >= 't' && LA12_151 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_151 >= '\u0000' && LA12_151 <= '/')||(LA12_151 >= ':' && LA12_151 <= '@')||(LA12_151 >= '[' && LA12_151 <= '^')||LA12_151=='`'||(LA12_151 >= '{' && LA12_151 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 18 : 
                        int LA12_146 = input.LA(1);

                        s = -1;
                        if ( (LA12_146=='a') ) {s = 151;}

                        else if ( ((LA12_146 >= '0' && LA12_146 <= '9')||(LA12_146 >= 'A' && LA12_146 <= 'Z')||LA12_146=='_'||(LA12_146 >= 'b' && LA12_146 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_146 >= '\u0000' && LA12_146 <= '/')||(LA12_146 >= ':' && LA12_146 <= '@')||(LA12_146 >= '[' && LA12_146 <= '^')||LA12_146=='`'||(LA12_146 >= '{' && LA12_146 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 19 : 
                        int LA12_11 = input.LA(1);

                        s = -1;
                        if ( (LA12_11=='i') ) {s = 41;}

                        else if ( ((LA12_11 >= '0' && LA12_11 <= '9')||(LA12_11 >= 'A' && LA12_11 <= 'Z')||LA12_11=='_'||(LA12_11 >= 'a' && LA12_11 <= 'h')||(LA12_11 >= 'j' && LA12_11 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_11 >= '\u0000' && LA12_11 <= '/')||(LA12_11 >= ':' && LA12_11 <= '@')||(LA12_11 >= '[' && LA12_11 <= '^')||LA12_11=='`'||(LA12_11 >= '{' && LA12_11 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 20 : 
                        int LA12_108 = input.LA(1);

                        s = -1;
                        if ( ((LA12_108 >= '0' && LA12_108 <= '9')||(LA12_108 >= 'A' && LA12_108 <= 'Z')||LA12_108=='_'||(LA12_108 >= 'a' && LA12_108 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_108 >= '\u0000' && LA12_108 <= '/')||(LA12_108 >= ':' && LA12_108 <= '@')||(LA12_108 >= '[' && LA12_108 <= '^')||LA12_108=='`'||(LA12_108 >= '{' && LA12_108 <= '\uFFFF')) ) {s = 27;}

                        else s = 121;

                        if ( s>=0 ) return s;
                        break;

                    case 21 : 
                        int LA12_23 = input.LA(1);

                        s = -1;
                        if ( (LA12_23=='\n') ) {s = 24;}

                        else if ( ((LA12_23 >= '\u0000' && LA12_23 <= '\t')||(LA12_23 >= '\u000B' && LA12_23 <= '\uFFFF')) ) {s = 27;}

                        else s = 54;

                        if ( s>=0 ) return s;
                        break;

                    case 22 : 
                        int LA12_10 = input.LA(1);

                        s = -1;
                        if ( (LA12_10=='n') ) {s = 40;}

                        else if ( ((LA12_10 >= '0' && LA12_10 <= '9')||(LA12_10 >= 'A' && LA12_10 <= 'Z')||LA12_10=='_'||(LA12_10 >= 'a' && LA12_10 <= 'm')||(LA12_10 >= 'o' && LA12_10 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_10 >= '\u0000' && LA12_10 <= '/')||(LA12_10 >= ':' && LA12_10 <= '@')||(LA12_10 >= '[' && LA12_10 <= '^')||LA12_10=='`'||(LA12_10 >= '{' && LA12_10 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 23 : 
                        int LA12_49 = input.LA(1);

                        s = -1;
                        if ( ((LA12_49 >= '\u0000' && LA12_49 <= '\uFFFF')) ) {s = 27;}

                        else s = 69;

                        if ( s>=0 ) return s;
                        break;

                    case 24 : 
                        int LA12_36 = input.LA(1);

                        s = -1;
                        if ( (LA12_36=='s') ) {s = 62;}

                        else if ( ((LA12_36 >= '0' && LA12_36 <= '9')||(LA12_36 >= 'A' && LA12_36 <= 'Z')||LA12_36=='_'||(LA12_36 >= 'a' && LA12_36 <= 'r')||(LA12_36 >= 't' && LA12_36 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_36 >= '\u0000' && LA12_36 <= '/')||(LA12_36 >= ':' && LA12_36 <= '@')||(LA12_36 >= '[' && LA12_36 <= '^')||LA12_36=='`'||(LA12_36 >= '{' && LA12_36 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 25 : 
                        int LA12_68 = input.LA(1);

                        s = -1;
                        if ( (LA12_68=='t') ) {s = 85;}

                        else if ( ((LA12_68 >= '0' && LA12_68 <= '9')||(LA12_68 >= 'A' && LA12_68 <= 'Z')||LA12_68=='_'||(LA12_68 >= 'a' && LA12_68 <= 's')||(LA12_68 >= 'u' && LA12_68 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_68 >= '\u0000' && LA12_68 <= '/')||(LA12_68 >= ':' && LA12_68 <= '@')||(LA12_68 >= '[' && LA12_68 <= '^')||LA12_68=='`'||(LA12_68 >= '{' && LA12_68 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 26 : 
                        int LA12_147 = input.LA(1);

                        s = -1;
                        if ( ((LA12_147 >= '0' && LA12_147 <= '9')||(LA12_147 >= 'A' && LA12_147 <= 'Z')||LA12_147=='_'||(LA12_147 >= 'a' && LA12_147 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_147 >= '\u0000' && LA12_147 <= '/')||(LA12_147 >= ':' && LA12_147 <= '@')||(LA12_147 >= '[' && LA12_147 <= '^')||LA12_147=='`'||(LA12_147 >= '{' && LA12_147 <= '\uFFFF')) ) {s = 27;}

                        else s = 152;

                        if ( s>=0 ) return s;
                        break;

                    case 27 : 
                        int LA12_41 = input.LA(1);

                        s = -1;
                        if ( (LA12_41=='r') ) {s = 68;}

                        else if ( ((LA12_41 >= '0' && LA12_41 <= '9')||(LA12_41 >= 'A' && LA12_41 <= 'Z')||LA12_41=='_'||(LA12_41 >= 'a' && LA12_41 <= 'q')||(LA12_41 >= 's' && LA12_41 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_41 >= '\u0000' && LA12_41 <= '/')||(LA12_41 >= ':' && LA12_41 <= '@')||(LA12_41 >= '[' && LA12_41 <= '^')||LA12_41=='`'||(LA12_41 >= '{' && LA12_41 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 28 : 
                        int LA12_97 = input.LA(1);

                        s = -1;
                        if ( (LA12_97=='a') ) {s = 109;}

                        else if ( ((LA12_97 >= '0' && LA12_97 <= '9')||(LA12_97 >= 'A' && LA12_97 <= 'Z')||LA12_97=='_'||(LA12_97 >= 'b' && LA12_97 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_97 >= '\u0000' && LA12_97 <= '/')||(LA12_97 >= ':' && LA12_97 <= '@')||(LA12_97 >= '[' && LA12_97 <= '^')||LA12_97=='`'||(LA12_97 >= '{' && LA12_97 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 29 : 
                        int LA12_85 = input.LA(1);

                        s = -1;
                        if ( (LA12_85=='u') ) {s = 97;}

                        else if ( ((LA12_85 >= '0' && LA12_85 <= '9')||(LA12_85 >= 'A' && LA12_85 <= 'Z')||LA12_85=='_'||(LA12_85 >= 'a' && LA12_85 <= 't')||(LA12_85 >= 'v' && LA12_85 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_85 >= '\u0000' && LA12_85 <= '/')||(LA12_85 >= ':' && LA12_85 <= '@')||(LA12_85 >= '[' && LA12_85 <= '^')||LA12_85=='`'||(LA12_85 >= '{' && LA12_85 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 30 : 
                        int LA12_109 = input.LA(1);

                        s = -1;
                        if ( (LA12_109=='l') ) {s = 122;}

                        else if ( ((LA12_109 >= '0' && LA12_109 <= '9')||(LA12_109 >= 'A' && LA12_109 <= 'Z')||LA12_109=='_'||(LA12_109 >= 'a' && LA12_109 <= 'k')||(LA12_109 >= 'm' && LA12_109 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_109 >= '\u0000' && LA12_109 <= '/')||(LA12_109 >= ':' && LA12_109 <= '@')||(LA12_109 >= '[' && LA12_109 <= '^')||LA12_109=='`'||(LA12_109 >= '{' && LA12_109 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 31 : 
                        int LA12_63 = input.LA(1);

                        s = -1;
                        if ( (LA12_63=='a') ) {s = 80;}

                        else if ( ((LA12_63 >= '0' && LA12_63 <= '9')||(LA12_63 >= 'A' && LA12_63 <= 'Z')||LA12_63=='_'||(LA12_63 >= 'b' && LA12_63 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_63 >= '\u0000' && LA12_63 <= '/')||(LA12_63 >= ':' && LA12_63 <= '@')||(LA12_63 >= '[' && LA12_63 <= '^')||LA12_63=='`'||(LA12_63 >= '{' && LA12_63 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 32 : 
                        int LA12_80 = input.LA(1);

                        s = -1;
                        if ( (LA12_80=='s') ) {s = 92;}

                        else if ( ((LA12_80 >= '0' && LA12_80 <= '9')||(LA12_80 >= 'A' && LA12_80 <= 'Z')||LA12_80=='_'||(LA12_80 >= 'a' && LA12_80 <= 'r')||(LA12_80 >= 't' && LA12_80 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_80 >= '\u0000' && LA12_80 <= '/')||(LA12_80 >= ':' && LA12_80 <= '@')||(LA12_80 >= '[' && LA12_80 <= '^')||LA12_80=='`'||(LA12_80 >= '{' && LA12_80 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 33 : 
                        int LA12_86 = input.LA(1);

                        s = -1;
                        if ( (LA12_86=='T') ) {s = 98;}

                        else if ( ((LA12_86 >= '0' && LA12_86 <= '9')||(LA12_86 >= 'A' && LA12_86 <= 'S')||(LA12_86 >= 'U' && LA12_86 <= 'Z')||LA12_86=='_'||(LA12_86 >= 'a' && LA12_86 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_86 >= '\u0000' && LA12_86 <= '/')||(LA12_86 >= ':' && LA12_86 <= '@')||(LA12_86 >= '[' && LA12_86 <= '^')||LA12_86=='`'||(LA12_86 >= '{' && LA12_86 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 34 : 
                        int LA12_73 = input.LA(1);

                        s = -1;
                        if ( (LA12_73=='R') ) {s = 86;}

                        else if ( ((LA12_73 >= '0' && LA12_73 <= '9')||(LA12_73 >= 'A' && LA12_73 <= 'Q')||(LA12_73 >= 'S' && LA12_73 <= 'Z')||LA12_73=='_'||(LA12_73 >= 'a' && LA12_73 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_73 >= '\u0000' && LA12_73 <= '/')||(LA12_73 >= ':' && LA12_73 <= '@')||(LA12_73 >= '[' && LA12_73 <= '^')||LA12_73=='`'||(LA12_73 >= '{' && LA12_73 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 35 : 
                        int LA12_116 = input.LA(1);

                        s = -1;
                        if ( (LA12_116=='o') ) {s = 126;}

                        else if ( ((LA12_116 >= '0' && LA12_116 <= '9')||(LA12_116 >= 'A' && LA12_116 <= 'Z')||LA12_116=='_'||(LA12_116 >= 'a' && LA12_116 <= 'n')||(LA12_116 >= 'p' && LA12_116 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_116 >= '\u0000' && LA12_116 <= '/')||(LA12_116 >= ':' && LA12_116 <= '@')||(LA12_116 >= '[' && LA12_116 <= '^')||LA12_116=='`'||(LA12_116 >= '{' && LA12_116 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 36 : 
                        int LA12_56 = input.LA(1);

                        s = -1;
                        if ( (LA12_56=='E') ) {s = 73;}

                        else if ( ((LA12_56 >= '0' && LA12_56 <= '9')||(LA12_56 >= 'A' && LA12_56 <= 'D')||(LA12_56 >= 'F' && LA12_56 <= 'Z')||LA12_56=='_'||(LA12_56 >= 'a' && LA12_56 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_56 >= '\u0000' && LA12_56 <= '/')||(LA12_56 >= ':' && LA12_56 <= '@')||(LA12_56 >= '[' && LA12_56 <= '^')||LA12_56=='`'||(LA12_56 >= '{' && LA12_56 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 37 : 
                        int LA12_126 = input.LA(1);

                        s = -1;
                        if ( (LA12_126=='r') ) {s = 135;}

                        else if ( ((LA12_126 >= '0' && LA12_126 <= '9')||(LA12_126 >= 'A' && LA12_126 <= 'Z')||LA12_126=='_'||(LA12_126 >= 'a' && LA12_126 <= 'q')||(LA12_126 >= 's' && LA12_126 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_126 >= '\u0000' && LA12_126 <= '/')||(LA12_126 >= ':' && LA12_126 <= '@')||(LA12_126 >= '[' && LA12_126 <= '^')||LA12_126=='`'||(LA12_126 >= '{' && LA12_126 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 38 : 
                        int LA12_28 = input.LA(1);

                        s = -1;
                        if ( (LA12_28=='S') ) {s = 56;}

                        else if ( ((LA12_28 >= '0' && LA12_28 <= '9')||(LA12_28 >= 'A' && LA12_28 <= 'R')||(LA12_28 >= 'T' && LA12_28 <= 'Z')||LA12_28=='_'||(LA12_28 >= 'a' && LA12_28 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_28 >= '\u0000' && LA12_28 <= '/')||(LA12_28 >= ':' && LA12_28 <= '@')||(LA12_28 >= '[' && LA12_28 <= '^')||LA12_28=='`'||(LA12_28 >= '{' && LA12_28 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 39 : 
                        int LA12_91 = input.LA(1);

                        s = -1;
                        if ( (LA12_91=='s') ) {s = 103;}

                        else if ( ((LA12_91 >= '0' && LA12_91 <= '9')||(LA12_91 >= 'A' && LA12_91 <= 'Z')||LA12_91=='_'||(LA12_91 >= 'a' && LA12_91 <= 'r')||(LA12_91 >= 't' && LA12_91 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_91 >= '\u0000' && LA12_91 <= '/')||(LA12_91 >= ':' && LA12_91 <= '@')||(LA12_91 >= '[' && LA12_91 <= '^')||LA12_91=='`'||(LA12_91 >= '{' && LA12_91 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 40 : 
                        int LA12_103 = input.LA(1);

                        s = -1;
                        if ( (LA12_103=='s') ) {s = 116;}

                        else if ( ((LA12_103 >= '0' && LA12_103 <= '9')||(LA12_103 >= 'A' && LA12_103 <= 'Z')||LA12_103=='_'||(LA12_103 >= 'a' && LA12_103 <= 'r')||(LA12_103 >= 't' && LA12_103 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_103 >= '\u0000' && LA12_103 <= '/')||(LA12_103 >= ':' && LA12_103 <= '@')||(LA12_103 >= '[' && LA12_103 <= '^')||LA12_103=='`'||(LA12_103 >= '{' && LA12_103 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 41 : 
                        int LA12_61 = input.LA(1);

                        s = -1;
                        if ( (LA12_61=='c') ) {s = 78;}

                        else if ( ((LA12_61 >= '0' && LA12_61 <= '9')||(LA12_61 >= 'A' && LA12_61 <= 'Z')||LA12_61=='_'||(LA12_61 >= 'a' && LA12_61 <= 'b')||(LA12_61 >= 'd' && LA12_61 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_61 >= '\u0000' && LA12_61 <= '/')||(LA12_61 >= ':' && LA12_61 <= '@')||(LA12_61 >= '[' && LA12_61 <= '^')||LA12_61=='`'||(LA12_61 >= '{' && LA12_61 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 42 : 
                        int LA12_62 = input.LA(1);

                        s = -1;
                        if ( ((LA12_62 >= '0' && LA12_62 <= '9')||(LA12_62 >= 'A' && LA12_62 <= 'Z')||LA12_62=='_'||(LA12_62 >= 'a' && LA12_62 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_62 >= '\u0000' && LA12_62 <= '/')||(LA12_62 >= ':' && LA12_62 <= '@')||(LA12_62 >= '[' && LA12_62 <= '^')||LA12_62=='`'||(LA12_62 >= '{' && LA12_62 <= '\uFFFF')) ) {s = 27;}

                        else s = 79;

                        if ( s>=0 ) return s;
                        break;

                    case 43 : 
                        int LA12_78 = input.LA(1);

                        s = -1;
                        if ( (LA12_78=='e') ) {s = 91;}

                        else if ( ((LA12_78 >= '0' && LA12_78 <= '9')||(LA12_78 >= 'A' && LA12_78 <= 'Z')||LA12_78=='_'||(LA12_78 >= 'a' && LA12_78 <= 'd')||(LA12_78 >= 'f' && LA12_78 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_78 >= '\u0000' && LA12_78 <= '/')||(LA12_78 >= ':' && LA12_78 <= '@')||(LA12_78 >= '[' && LA12_78 <= '^')||LA12_78=='`'||(LA12_78 >= '{' && LA12_78 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 44 : 
                        int LA12_122 = input.LA(1);

                        s = -1;
                        if ( ((LA12_122 >= '0' && LA12_122 <= '9')||(LA12_122 >= 'A' && LA12_122 <= 'Z')||LA12_122=='_'||(LA12_122 >= 'a' && LA12_122 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_122 >= '\u0000' && LA12_122 <= '/')||(LA12_122 >= ':' && LA12_122 <= '@')||(LA12_122 >= '[' && LA12_122 <= '^')||LA12_122=='`'||(LA12_122 >= '{' && LA12_122 <= '\uFFFF')) ) {s = 27;}

                        else s = 131;

                        if ( s>=0 ) return s;
                        break;

                    case 45 : 
                        int LA12_35 = input.LA(1);

                        s = -1;
                        if ( (LA12_35=='o') ) {s = 61;}

                        else if ( ((LA12_35 >= '0' && LA12_35 <= '9')||(LA12_35 >= 'A' && LA12_35 <= 'Z')||LA12_35=='_'||(LA12_35 >= 'a' && LA12_35 <= 'n')||(LA12_35 >= 'p' && LA12_35 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_35 >= '\u0000' && LA12_35 <= '/')||(LA12_35 >= ':' && LA12_35 <= '@')||(LA12_35 >= '[' && LA12_35 <= '^')||LA12_35=='`'||(LA12_35 >= '{' && LA12_35 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 46 : 
                        int LA12_142 = input.LA(1);

                        s = -1;
                        if ( (LA12_142=='e') ) {s = 149;}

                        else if ( ((LA12_142 >= '0' && LA12_142 <= '9')||(LA12_142 >= 'A' && LA12_142 <= 'Z')||LA12_142=='_'||(LA12_142 >= 'a' && LA12_142 <= 'd')||(LA12_142 >= 'f' && LA12_142 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_142 >= '\u0000' && LA12_142 <= '/')||(LA12_142 >= ':' && LA12_142 <= '@')||(LA12_142 >= '[' && LA12_142 <= '^')||LA12_142=='`'||(LA12_142 >= '{' && LA12_142 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 47 : 
                        int LA12_134 = input.LA(1);

                        s = -1;
                        if ( (LA12_134=='u') ) {s = 142;}

                        else if ( ((LA12_134 >= '0' && LA12_134 <= '9')||(LA12_134 >= 'A' && LA12_134 <= 'Z')||LA12_134=='_'||(LA12_134 >= 'a' && LA12_134 <= 't')||(LA12_134 >= 'v' && LA12_134 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_134 >= '\u0000' && LA12_134 <= '/')||(LA12_134 >= ':' && LA12_134 <= '@')||(LA12_134 >= '[' && LA12_134 <= '^')||LA12_134=='`'||(LA12_134 >= '{' && LA12_134 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 48 : 
                        int LA12_125 = input.LA(1);

                        s = -1;
                        if ( (LA12_125=='q') ) {s = 134;}

                        else if ( ((LA12_125 >= '0' && LA12_125 <= '9')||(LA12_125 >= 'A' && LA12_125 <= 'Z')||LA12_125=='_'||(LA12_125 >= 'a' && LA12_125 <= 'p')||(LA12_125 >= 'r' && LA12_125 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_125 >= '\u0000' && LA12_125 <= '/')||(LA12_125 >= ':' && LA12_125 <= '@')||(LA12_125 >= '[' && LA12_125 <= '^')||LA12_125=='`'||(LA12_125 >= '{' && LA12_125 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 49 : 
                        int LA12_115 = input.LA(1);

                        s = -1;
                        if ( (LA12_115=='i') ) {s = 125;}

                        else if ( ((LA12_115 >= '0' && LA12_115 <= '9')||(LA12_115 >= 'A' && LA12_115 <= 'Z')||LA12_115=='_'||(LA12_115 >= 'a' && LA12_115 <= 'h')||(LA12_115 >= 'j' && LA12_115 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_115 >= '\u0000' && LA12_115 <= '/')||(LA12_115 >= ':' && LA12_115 <= '@')||(LA12_115 >= '[' && LA12_115 <= '^')||LA12_115=='`'||(LA12_115 >= '{' && LA12_115 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 50 : 
                        int LA12_102 = input.LA(1);

                        s = -1;
                        if ( (LA12_102=='n') ) {s = 115;}

                        else if ( ((LA12_102 >= '0' && LA12_102 <= '9')||(LA12_102 >= 'A' && LA12_102 <= 'Z')||LA12_102=='_'||(LA12_102 >= 'a' && LA12_102 <= 'm')||(LA12_102 >= 'o' && LA12_102 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_102 >= '\u0000' && LA12_102 <= '/')||(LA12_102 >= ':' && LA12_102 <= '@')||(LA12_102 >= '[' && LA12_102 <= '^')||LA12_102=='`'||(LA12_102 >= '{' && LA12_102 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 51 : 
                        int LA12_26 = input.LA(1);

                        s = -1;
                        if ( ((LA12_26 >= '\u0000' && LA12_26 <= '\uFFFF')) ) {s = 27;}

                        else s = 55;

                        if ( s>=0 ) return s;
                        break;

                    case 52 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='I') ) {s = 1;}

                        else if ( (LA12_0=='U') ) {s = 2;}

                        else if ( (LA12_0=='R') ) {s = 3;}

                        else if ( (LA12_0=='b') ) {s = 4;}

                        else if ( (LA12_0=='c') ) {s = 5;}

                        else if ( (LA12_0=='p') ) {s = 6;}

                        else if ( (LA12_0=='a') ) {s = 7;}

                        else if ( (LA12_0=='f') ) {s = 8;}

                        else if ( (LA12_0=='i') ) {s = 9;}

                        else if ( (LA12_0=='u') ) {s = 10;}

                        else if ( (LA12_0=='v') ) {s = 11;}

                        else if ( (LA12_0==';') ) {s = 12;}

                        else if ( (LA12_0==']') ) {s = 13;}

                        else if ( (LA12_0=='[') ) {s = 14;}

                        else if ( (LA12_0=='(') ) {s = 15;}

                        else if ( (LA12_0==')') ) {s = 16;}

                        else if ( (LA12_0=='=') ) {s = 17;}

                        else if ( (LA12_0==',') ) {s = 18;}

                        else if ( (LA12_0=='\\') ) {s = 19;}

                        else if ( (LA12_0=='$') ) {s = 20;}

                        else if ( ((LA12_0 >= 'A' && LA12_0 <= 'H')||(LA12_0 >= 'J' && LA12_0 <= 'Q')||(LA12_0 >= 'S' && LA12_0 <= 'T')||(LA12_0 >= 'V' && LA12_0 <= 'Z')||LA12_0=='_'||(LA12_0 >= 'd' && LA12_0 <= 'e')||(LA12_0 >= 'g' && LA12_0 <= 'h')||(LA12_0 >= 'j' && LA12_0 <= 'o')||(LA12_0 >= 'q' && LA12_0 <= 't')||(LA12_0 >= 'w' && LA12_0 <= 'z')) ) {s = 21;}

                        else if ( (LA12_0=='#') ) {s = 22;}

                        else if ( (LA12_0=='\r') ) {s = 23;}

                        else if ( (LA12_0=='\n') ) {s = 24;}

                        else if ( (LA12_0==' ') ) {s = 25;}

                        else if ( (LA12_0=='\t') ) {s = 26;}

                        else if ( ((LA12_0 >= '\u0000' && LA12_0 <= '\b')||(LA12_0 >= '\u000B' && LA12_0 <= '\f')||(LA12_0 >= '\u000E' && LA12_0 <= '\u001F')||(LA12_0 >= '!' && LA12_0 <= '\"')||(LA12_0 >= '%' && LA12_0 <= '\'')||(LA12_0 >= '*' && LA12_0 <= '+')||(LA12_0 >= '-' && LA12_0 <= ':')||LA12_0=='<'||(LA12_0 >= '>' && LA12_0 <= '@')||LA12_0=='^'||LA12_0=='`'||(LA12_0 >= '{' && LA12_0 <= '\uFFFF')) ) {s = 27;}

                        if ( s>=0 ) return s;
                        break;

                    case 53 : 
                        int LA12_90 = input.LA(1);

                        s = -1;
                        if ( (LA12_90=='U') ) {s = 102;}

                        else if ( ((LA12_90 >= '0' && LA12_90 <= '9')||(LA12_90 >= 'A' && LA12_90 <= 'T')||(LA12_90 >= 'V' && LA12_90 <= 'Z')||LA12_90=='_'||(LA12_90 >= 'a' && LA12_90 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_90 >= '\u0000' && LA12_90 <= '/')||(LA12_90 >= ':' && LA12_90 <= '@')||(LA12_90 >= '[' && LA12_90 <= '^')||LA12_90=='`'||(LA12_90 >= '{' && LA12_90 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 54 : 
                        int LA12_77 = input.LA(1);

                        s = -1;
                        if ( (LA12_77=='e') ) {s = 90;}

                        else if ( ((LA12_77 >= '0' && LA12_77 <= '9')||(LA12_77 >= 'A' && LA12_77 <= 'Z')||LA12_77=='_'||(LA12_77 >= 'a' && LA12_77 <= 'd')||(LA12_77 >= 'f' && LA12_77 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_77 >= '\u0000' && LA12_77 <= '/')||(LA12_77 >= ':' && LA12_77 <= '@')||(LA12_77 >= '[' && LA12_77 <= '^')||LA12_77=='`'||(LA12_77 >= '{' && LA12_77 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 55 : 
                        int LA12_99 = input.LA(1);

                        s = -1;
                        if ( ((LA12_99 >= '0' && LA12_99 <= '9')||(LA12_99 >= 'A' && LA12_99 <= 'Z')||LA12_99=='_'||(LA12_99 >= 'a' && LA12_99 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_99 >= '\u0000' && LA12_99 <= '/')||(LA12_99 >= ':' && LA12_99 <= '@')||(LA12_99 >= '[' && LA12_99 <= '^')||LA12_99=='`'||(LA12_99 >= '{' && LA12_99 <= '\uFFFF')) ) {s = 27;}

                        else s = 112;

                        if ( s>=0 ) return s;
                        break;

                    case 56 : 
                        int LA12_60 = input.LA(1);

                        s = -1;
                        if ( (LA12_60=='h') ) {s = 77;}

                        else if ( ((LA12_60 >= '0' && LA12_60 <= '9')||(LA12_60 >= 'A' && LA12_60 <= 'Z')||LA12_60=='_'||(LA12_60 >= 'a' && LA12_60 <= 'g')||(LA12_60 >= 'i' && LA12_60 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_60 >= '\u0000' && LA12_60 <= '/')||(LA12_60 >= ':' && LA12_60 <= '@')||(LA12_60 >= '[' && LA12_60 <= '^')||LA12_60=='`'||(LA12_60 >= '{' && LA12_60 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 57 : 
                        int LA12_34 = input.LA(1);

                        s = -1;
                        if ( (LA12_34=='c') ) {s = 60;}

                        else if ( ((LA12_34 >= '0' && LA12_34 <= '9')||(LA12_34 >= 'A' && LA12_34 <= 'Z')||LA12_34=='_'||(LA12_34 >= 'a' && LA12_34 <= 'b')||(LA12_34 >= 'd' && LA12_34 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_34 >= '\u0000' && LA12_34 <= '/')||(LA12_34 >= ':' && LA12_34 <= '@')||(LA12_34 >= '[' && LA12_34 <= '^')||LA12_34=='`'||(LA12_34 >= '{' && LA12_34 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 58 : 
                        int LA12_20 = input.LA(1);

                        s = -1;
                        if ( ((LA12_20 >= 'A' && LA12_20 <= 'Z')||LA12_20=='_'||(LA12_20 >= 'a' && LA12_20 <= 'z')) ) {s = 50;}

                        else if ( ((LA12_20 >= '\u0000' && LA12_20 <= '@')||(LA12_20 >= '[' && LA12_20 <= '^')||LA12_20=='`'||(LA12_20 >= '{' && LA12_20 <= '\uFFFF')) ) {s = 27;}

                        if ( s>=0 ) return s;
                        break;

                    case 59 : 
                        int LA12_118 = input.LA(1);

                        s = -1;
                        if ( (LA12_118=='i') ) {s = 128;}

                        else if ( ((LA12_118 >= '0' && LA12_118 <= '9')||(LA12_118 >= 'A' && LA12_118 <= 'Z')||LA12_118=='_'||(LA12_118 >= 'a' && LA12_118 <= 'h')||(LA12_118 >= 'j' && LA12_118 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_118 >= '\u0000' && LA12_118 <= '/')||(LA12_118 >= ':' && LA12_118 <= '@')||(LA12_118 >= '[' && LA12_118 <= '^')||LA12_118=='`'||(LA12_118 >= '{' && LA12_118 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 60 : 
                        int LA12_128 = input.LA(1);

                        s = -1;
                        if ( (LA12_128=='t') ) {s = 137;}

                        else if ( ((LA12_128 >= '0' && LA12_128 <= '9')||(LA12_128 >= 'A' && LA12_128 <= 'Z')||LA12_128=='_'||(LA12_128 >= 'a' && LA12_128 <= 's')||(LA12_128 >= 'u' && LA12_128 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_128 >= '\u0000' && LA12_128 <= '/')||(LA12_128 >= ':' && LA12_128 <= '@')||(LA12_128 >= '[' && LA12_128 <= '^')||LA12_128=='`'||(LA12_128 >= '{' && LA12_128 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 61 : 
                        int LA12_137 = input.LA(1);

                        s = -1;
                        if ( (LA12_137=='e') ) {s = 145;}

                        else if ( ((LA12_137 >= '0' && LA12_137 <= '9')||(LA12_137 >= 'A' && LA12_137 <= 'Z')||LA12_137=='_'||(LA12_137 >= 'a' && LA12_137 <= 'd')||(LA12_137 >= 'f' && LA12_137 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_137 >= '\u0000' && LA12_137 <= '/')||(LA12_137 >= ':' && LA12_137 <= '@')||(LA12_137 >= '[' && LA12_137 <= '^')||LA12_137=='`'||(LA12_137 >= '{' && LA12_137 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 62 : 
                        int LA12_65 = input.LA(1);

                        s = -1;
                        if ( (LA12_65=='c') ) {s = 82;}

                        else if ( ((LA12_65 >= '0' && LA12_65 <= '9')||(LA12_65 >= 'A' && LA12_65 <= 'Z')||LA12_65=='_'||(LA12_65 >= 'a' && LA12_65 <= 'b')||(LA12_65 >= 'd' && LA12_65 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_65 >= '\u0000' && LA12_65 <= '/')||(LA12_65 >= ':' && LA12_65 <= '@')||(LA12_65 >= '[' && LA12_65 <= '^')||LA12_65=='`'||(LA12_65 >= '{' && LA12_65 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 63 : 
                        int LA12_82 = input.LA(1);

                        s = -1;
                        if ( (LA12_82=='e') ) {s = 94;}

                        else if ( ((LA12_82 >= '0' && LA12_82 <= '9')||(LA12_82 >= 'A' && LA12_82 <= 'Z')||LA12_82=='_'||(LA12_82 >= 'a' && LA12_82 <= 'd')||(LA12_82 >= 'f' && LA12_82 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_82 >= '\u0000' && LA12_82 <= '/')||(LA12_82 >= ':' && LA12_82 <= '@')||(LA12_82 >= '[' && LA12_82 <= '^')||LA12_82=='`'||(LA12_82 >= '{' && LA12_82 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 64 : 
                        int LA12_94 = input.LA(1);

                        s = -1;
                        if ( (LA12_94=='W') ) {s = 106;}

                        else if ( ((LA12_94 >= '0' && LA12_94 <= '9')||(LA12_94 >= 'A' && LA12_94 <= 'V')||(LA12_94 >= 'X' && LA12_94 <= 'Z')||LA12_94=='_'||(LA12_94 >= 'a' && LA12_94 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_94 >= '\u0000' && LA12_94 <= '/')||(LA12_94 >= ':' && LA12_94 <= '@')||(LA12_94 >= '[' && LA12_94 <= '^')||LA12_94=='`'||(LA12_94 >= '{' && LA12_94 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 65 : 
                        int LA12_106 = input.LA(1);

                        s = -1;
                        if ( (LA12_106=='r') ) {s = 118;}

                        else if ( ((LA12_106 >= '0' && LA12_106 <= '9')||(LA12_106 >= 'A' && LA12_106 <= 'Z')||LA12_106=='_'||(LA12_106 >= 'a' && LA12_106 <= 'q')||(LA12_106 >= 's' && LA12_106 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_106 >= '\u0000' && LA12_106 <= '/')||(LA12_106 >= ':' && LA12_106 <= '@')||(LA12_106 >= '[' && LA12_106 <= '^')||LA12_106=='`'||(LA12_106 >= '{' && LA12_106 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 66 : 
                        int LA12_156 = input.LA(1);

                        s = -1;
                        if ( ((LA12_156 >= '0' && LA12_156 <= '9')||(LA12_156 >= 'A' && LA12_156 <= 'Z')||LA12_156=='_'||(LA12_156 >= 'a' && LA12_156 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_156 >= '\u0000' && LA12_156 <= '/')||(LA12_156 >= ':' && LA12_156 <= '@')||(LA12_156 >= '[' && LA12_156 <= '^')||LA12_156=='`'||(LA12_156 >= '{' && LA12_156 <= '\uFFFF')) ) {s = 27;}

                        else s = 158;

                        if ( s>=0 ) return s;
                        break;

                    case 67 : 
                        int LA12_7 = input.LA(1);

                        s = -1;
                        if ( (LA12_7=='l') ) {s = 37;}

                        else if ( ((LA12_7 >= '0' && LA12_7 <= '9')||(LA12_7 >= 'A' && LA12_7 <= 'Z')||LA12_7=='_'||(LA12_7 >= 'a' && LA12_7 <= 'k')||(LA12_7 >= 'm' && LA12_7 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_7 >= '\u0000' && LA12_7 <= '/')||(LA12_7 >= ':' && LA12_7 <= '@')||(LA12_7 >= '[' && LA12_7 <= '^')||LA12_7=='`'||(LA12_7 >= '{' && LA12_7 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 68 : 
                        int LA12_38 = input.LA(1);

                        s = -1;
                        if ( (LA12_38=='r') ) {s = 65;}

                        else if ( ((LA12_38 >= '0' && LA12_38 <= '9')||(LA12_38 >= 'A' && LA12_38 <= 'Z')||LA12_38=='_'||(LA12_38 >= 'a' && LA12_38 <= 'q')||(LA12_38 >= 's' && LA12_38 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_38 >= '\u0000' && LA12_38 <= '/')||(LA12_38 >= ':' && LA12_38 <= '@')||(LA12_38 >= '[' && LA12_38 <= '^')||LA12_38=='`'||(LA12_38 >= '{' && LA12_38 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 69 : 
                        int LA12_127 = input.LA(1);

                        s = -1;
                        if ( (LA12_127=='l') ) {s = 136;}

                        else if ( ((LA12_127 >= '0' && LA12_127 <= '9')||(LA12_127 >= 'A' && LA12_127 <= 'Z')||LA12_127=='_'||(LA12_127 >= 'a' && LA12_127 <= 'k')||(LA12_127 >= 'm' && LA12_127 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_127 >= '\u0000' && LA12_127 <= '/')||(LA12_127 >= ':' && LA12_127 <= '@')||(LA12_127 >= '[' && LA12_127 <= '^')||LA12_127=='`'||(LA12_127 >= '{' && LA12_127 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 70 : 
                        int LA12_117 = input.LA(1);

                        s = -1;
                        if ( (LA12_117=='l') ) {s = 127;}

                        else if ( ((LA12_117 >= '0' && LA12_117 <= '9')||(LA12_117 >= 'A' && LA12_117 <= 'Z')||LA12_117=='_'||(LA12_117 >= 'a' && LA12_117 <= 'k')||(LA12_117 >= 'm' && LA12_117 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_117 >= '\u0000' && LA12_117 <= '/')||(LA12_117 >= ':' && LA12_117 <= '@')||(LA12_117 >= '[' && LA12_117 <= '^')||LA12_117=='`'||(LA12_117 >= '{' && LA12_117 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 71 : 
                        int LA12_81 = input.LA(1);

                        s = -1;
                        if ( (LA12_81=='w') ) {s = 93;}

                        else if ( ((LA12_81 >= '0' && LA12_81 <= '9')||(LA12_81 >= 'A' && LA12_81 <= 'Z')||LA12_81=='_'||(LA12_81 >= 'a' && LA12_81 <= 'v')||(LA12_81 >= 'x' && LA12_81 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_81 >= '\u0000' && LA12_81 <= '/')||(LA12_81 >= ':' && LA12_81 <= '@')||(LA12_81 >= '[' && LA12_81 <= '^')||LA12_81=='`'||(LA12_81 >= '{' && LA12_81 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 72 : 
                        int LA12_64 = input.LA(1);

                        s = -1;
                        if ( (LA12_64=='o') ) {s = 81;}

                        else if ( ((LA12_64 >= '0' && LA12_64 <= '9')||(LA12_64 >= 'A' && LA12_64 <= 'Z')||LA12_64=='_'||(LA12_64 >= 'a' && LA12_64 <= 'n')||(LA12_64 >= 'p' && LA12_64 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_64 >= '\u0000' && LA12_64 <= '/')||(LA12_64 >= ':' && LA12_64 <= '@')||(LA12_64 >= '[' && LA12_64 <= '^')||LA12_64=='`'||(LA12_64 >= '{' && LA12_64 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 73 : 
                        int LA12_105 = input.LA(1);

                        s = -1;
                        if ( (LA12_105=='u') ) {s = 117;}

                        else if ( ((LA12_105 >= '0' && LA12_105 <= '9')||(LA12_105 >= 'A' && LA12_105 <= 'Z')||LA12_105=='_'||(LA12_105 >= 'a' && LA12_105 <= 't')||(LA12_105 >= 'v' && LA12_105 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_105 >= '\u0000' && LA12_105 <= '/')||(LA12_105 >= ':' && LA12_105 <= '@')||(LA12_105 >= '[' && LA12_105 <= '^')||LA12_105=='`'||(LA12_105 >= '{' && LA12_105 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 74 : 
                        int LA12_93 = input.LA(1);

                        s = -1;
                        if ( (LA12_93=='n') ) {s = 105;}

                        else if ( ((LA12_93 >= '0' && LA12_93 <= '9')||(LA12_93 >= 'A' && LA12_93 <= 'Z')||LA12_93=='_'||(LA12_93 >= 'a' && LA12_93 <= 'm')||(LA12_93 >= 'o' && LA12_93 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_93 >= '\u0000' && LA12_93 <= '/')||(LA12_93 >= ':' && LA12_93 <= '@')||(LA12_93 >= '[' && LA12_93 <= '^')||LA12_93=='`'||(LA12_93 >= '{' && LA12_93 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 75 : 
                        int LA12_4 = input.LA(1);

                        s = -1;
                        if ( (LA12_4=='a') ) {s = 33;}

                        else if ( ((LA12_4 >= '0' && LA12_4 <= '9')||(LA12_4 >= 'A' && LA12_4 <= 'Z')||LA12_4=='_'||(LA12_4 >= 'b' && LA12_4 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_4 >= '\u0000' && LA12_4 <= '/')||(LA12_4 >= ':' && LA12_4 <= '@')||(LA12_4 >= '[' && LA12_4 <= '^')||LA12_4=='`'||(LA12_4 >= '{' && LA12_4 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 76 : 
                        int LA12_133 = input.LA(1);

                        s = -1;
                        if ( ((LA12_133 >= '0' && LA12_133 <= '9')||(LA12_133 >= 'A' && LA12_133 <= 'Z')||LA12_133=='_'||(LA12_133 >= 'a' && LA12_133 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_133 >= '\u0000' && LA12_133 <= '/')||(LA12_133 >= ':' && LA12_133 <= '@')||(LA12_133 >= '[' && LA12_133 <= '^')||LA12_133=='`'||(LA12_133 >= '{' && LA12_133 <= '\uFFFF')) ) {s = 27;}

                        else s = 141;

                        if ( s>=0 ) return s;
                        break;

                    case 77 : 
                        int LA12_98 = input.LA(1);

                        s = -1;
                        if ( (LA12_98=='_') ) {s = 110;}

                        else if ( ((LA12_98 >= '0' && LA12_98 <= '9')||(LA12_98 >= 'A' && LA12_98 <= 'Z')||(LA12_98 >= 'a' && LA12_98 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_98 >= '\u0000' && LA12_98 <= '/')||(LA12_98 >= ':' && LA12_98 <= '@')||(LA12_98 >= '[' && LA12_98 <= '^')||LA12_98=='`'||(LA12_98 >= '{' && LA12_98 <= '\uFFFF')) ) {s = 27;}

                        else s = 111;

                        if ( s>=0 ) return s;
                        break;

                    case 78 : 
                        int LA12_5 = input.LA(1);

                        s = -1;
                        if ( (LA12_5=='a') ) {s = 34;}

                        else if ( ((LA12_5 >= '0' && LA12_5 <= '9')||(LA12_5 >= 'A' && LA12_5 <= 'Z')||LA12_5=='_'||(LA12_5 >= 'b' && LA12_5 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_5 >= '\u0000' && LA12_5 <= '/')||(LA12_5 >= ':' && LA12_5 <= '@')||(LA12_5 >= '[' && LA12_5 <= '^')||LA12_5=='`'||(LA12_5 >= '{' && LA12_5 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 79 : 
                        int LA12_6 = input.LA(1);

                        s = -1;
                        if ( (LA12_6=='r') ) {s = 35;}

                        else if ( (LA12_6=='o') ) {s = 36;}

                        else if ( ((LA12_6 >= '0' && LA12_6 <= '9')||(LA12_6 >= 'A' && LA12_6 <= 'Z')||LA12_6=='_'||(LA12_6 >= 'a' && LA12_6 <= 'n')||(LA12_6 >= 'p' && LA12_6 <= 'q')||(LA12_6 >= 's' && LA12_6 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_6 >= '\u0000' && LA12_6 <= '/')||(LA12_6 >= ':' && LA12_6 <= '@')||(LA12_6 >= '[' && LA12_6 <= '^')||LA12_6=='`'||(LA12_6 >= '{' && LA12_6 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 80 : 
                        int LA12_52 = input.LA(1);

                        s = -1;
                        if ( (LA12_52=='\r') ) {s = 51;}

                        else if ( (LA12_52=='\n') ) {s = 52;}

                        else if ( ((LA12_52 >= '\u0000' && LA12_52 <= '\t')||(LA12_52 >= '\u000B' && LA12_52 <= '\f')||(LA12_52 >= '\u000E' && LA12_52 <= '\uFFFF')) ) {s = 53;}

                        else s = 72;

                        if ( s>=0 ) return s;
                        break;

                    case 81 : 
                        int LA12_100 = input.LA(1);

                        s = -1;
                        if ( ((LA12_100 >= '0' && LA12_100 <= '9')||(LA12_100 >= 'A' && LA12_100 <= 'Z')||LA12_100=='_'||(LA12_100 >= 'a' && LA12_100 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_100 >= '\u0000' && LA12_100 <= '/')||(LA12_100 >= ':' && LA12_100 <= '@')||(LA12_100 >= '[' && LA12_100 <= '^')||LA12_100=='`'||(LA12_100 >= '{' && LA12_100 <= '\uFFFF')) ) {s = 27;}

                        else s = 113;

                        if ( s>=0 ) return s;
                        break;

                    case 82 : 
                        int LA12_19 = input.LA(1);

                        s = -1;
                        if ( (LA12_19=='\\') ) {s = 49;}

                        else if ( ((LA12_19 >= '\u0000' && LA12_19 <= '[')||(LA12_19 >= ']' && LA12_19 <= '\uFFFF')) ) {s = 27;}

                        if ( s>=0 ) return s;
                        break;

                    case 83 : 
                        int LA12_123 = input.LA(1);

                        s = -1;
                        if ( (LA12_123=='P') ) {s = 132;}

                        else if ( ((LA12_123 >= '0' && LA12_123 <= '9')||(LA12_123 >= 'A' && LA12_123 <= 'O')||(LA12_123 >= 'Q' && LA12_123 <= 'Z')||LA12_123=='_'||(LA12_123 >= 'a' && LA12_123 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_123 >= '\u0000' && LA12_123 <= '/')||(LA12_123 >= ':' && LA12_123 <= '@')||(LA12_123 >= '[' && LA12_123 <= '^')||LA12_123=='`'||(LA12_123 >= '{' && LA12_123 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 84 : 
                        int LA12_110 = input.LA(1);

                        s = -1;
                        if ( (LA12_110=='U') ) {s = 123;}

                        else if ( ((LA12_110 >= '0' && LA12_110 <= '9')||(LA12_110 >= 'A' && LA12_110 <= 'T')||(LA12_110 >= 'V' && LA12_110 <= 'Z')||LA12_110=='_'||(LA12_110 >= 'a' && LA12_110 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_110 >= '\u0000' && LA12_110 <= '/')||(LA12_110 >= ':' && LA12_110 <= '@')||(LA12_110 >= '[' && LA12_110 <= '^')||LA12_110=='`'||(LA12_110 >= '{' && LA12_110 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 85 : 
                        int LA12_140 = input.LA(1);

                        s = -1;
                        if ( (LA12_140=='A') ) {s = 148;}

                        else if ( ((LA12_140 >= '0' && LA12_140 <= '9')||(LA12_140 >= 'B' && LA12_140 <= 'Z')||LA12_140=='_'||(LA12_140 >= 'a' && LA12_140 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_140 >= '\u0000' && LA12_140 <= '/')||(LA12_140 >= ':' && LA12_140 <= '@')||(LA12_140 >= '[' && LA12_140 <= '^')||LA12_140=='`'||(LA12_140 >= '{' && LA12_140 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 86 : 
                        int LA12_132 = input.LA(1);

                        s = -1;
                        if ( (LA12_132=='D') ) {s = 140;}

                        else if ( ((LA12_132 >= '0' && LA12_132 <= '9')||(LA12_132 >= 'A' && LA12_132 <= 'C')||(LA12_132 >= 'E' && LA12_132 <= 'Z')||LA12_132=='_'||(LA12_132 >= 'a' && LA12_132 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_132 >= '\u0000' && LA12_132 <= '/')||(LA12_132 >= ':' && LA12_132 <= '@')||(LA12_132 >= '[' && LA12_132 <= '^')||LA12_132=='`'||(LA12_132 >= '{' && LA12_132 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 87 : 
                        int LA12_153 = input.LA(1);

                        s = -1;
                        if ( (LA12_153=='E') ) {s = 156;}

                        else if ( ((LA12_153 >= '0' && LA12_153 <= '9')||(LA12_153 >= 'A' && LA12_153 <= 'D')||(LA12_153 >= 'F' && LA12_153 <= 'Z')||LA12_153=='_'||(LA12_153 >= 'a' && LA12_153 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_153 >= '\u0000' && LA12_153 <= '/')||(LA12_153 >= ':' && LA12_153 <= '@')||(LA12_153 >= '[' && LA12_153 <= '^')||LA12_153=='`'||(LA12_153 >= '{' && LA12_153 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 88 : 
                        int LA12_148 = input.LA(1);

                        s = -1;
                        if ( (LA12_148=='T') ) {s = 153;}

                        else if ( ((LA12_148 >= '0' && LA12_148 <= '9')||(LA12_148 >= 'A' && LA12_148 <= 'S')||(LA12_148 >= 'U' && LA12_148 <= 'Z')||LA12_148=='_'||(LA12_148 >= 'a' && LA12_148 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_148 >= '\u0000' && LA12_148 <= '/')||(LA12_148 >= ':' && LA12_148 <= '@')||(LA12_148 >= '[' && LA12_148 <= '^')||LA12_148=='`'||(LA12_148 >= '{' && LA12_148 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 89 : 
                        int LA12_1 = input.LA(1);

                        s = -1;
                        if ( (LA12_1=='N') ) {s = 28;}

                        else if ( ((LA12_1 >= '0' && LA12_1 <= '9')||(LA12_1 >= 'A' && LA12_1 <= 'M')||(LA12_1 >= 'O' && LA12_1 <= 'Z')||LA12_1=='_'||(LA12_1 >= 'a' && LA12_1 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_1 >= '\u0000' && LA12_1 <= '/')||(LA12_1 >= ':' && LA12_1 <= '@')||(LA12_1 >= '[' && LA12_1 <= '^')||LA12_1=='`'||(LA12_1 >= '{' && LA12_1 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 90 : 
                        int LA12_53 = input.LA(1);

                        s = -1;
                        if ( (LA12_53=='\r') ) {s = 51;}

                        else if ( (LA12_53=='\n') ) {s = 52;}

                        else if ( ((LA12_53 >= '\u0000' && LA12_53 <= '\t')||(LA12_53 >= '\u000B' && LA12_53 <= '\f')||(LA12_53 >= '\u000E' && LA12_53 <= '\uFFFF')) ) {s = 53;}

                        if ( s>=0 ) return s;
                        break;

                    case 91 : 
                        int LA12_31 = input.LA(1);

                        s = -1;
                        if ( (LA12_31=='D') ) {s = 57;}

                        else if ( ((LA12_31 >= '0' && LA12_31 <= '9')||(LA12_31 >= 'A' && LA12_31 <= 'C')||(LA12_31 >= 'E' && LA12_31 <= 'Z')||LA12_31=='_'||(LA12_31 >= 'a' && LA12_31 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_31 >= '\u0000' && LA12_31 <= '/')||(LA12_31 >= ':' && LA12_31 <= '@')||(LA12_31 >= '[' && LA12_31 <= '^')||LA12_31=='`'||(LA12_31 >= '{' && LA12_31 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 92 : 
                        int LA12_87 = input.LA(1);

                        s = -1;
                        if ( (LA12_87=='E') ) {s = 99;}

                        else if ( ((LA12_87 >= '0' && LA12_87 <= '9')||(LA12_87 >= 'A' && LA12_87 <= 'D')||(LA12_87 >= 'F' && LA12_87 <= 'Z')||LA12_87=='_'||(LA12_87 >= 'a' && LA12_87 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_87 >= '\u0000' && LA12_87 <= '/')||(LA12_87 >= ':' && LA12_87 <= '@')||(LA12_87 >= '[' && LA12_87 <= '^')||LA12_87=='`'||(LA12_87 >= '{' && LA12_87 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 93 : 
                        int LA12_57 = input.LA(1);

                        s = -1;
                        if ( (LA12_57=='A') ) {s = 74;}

                        else if ( ((LA12_57 >= '0' && LA12_57 <= '9')||(LA12_57 >= 'B' && LA12_57 <= 'Z')||LA12_57=='_'||(LA12_57 >= 'a' && LA12_57 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_57 >= '\u0000' && LA12_57 <= '/')||(LA12_57 >= ':' && LA12_57 <= '@')||(LA12_57 >= '[' && LA12_57 <= '^')||LA12_57=='`'||(LA12_57 >= '{' && LA12_57 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 94 : 
                        int LA12_74 = input.LA(1);

                        s = -1;
                        if ( (LA12_74=='T') ) {s = 87;}

                        else if ( ((LA12_74 >= '0' && LA12_74 <= '9')||(LA12_74 >= 'A' && LA12_74 <= 'S')||(LA12_74 >= 'U' && LA12_74 <= 'Z')||LA12_74=='_'||(LA12_74 >= 'a' && LA12_74 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_74 >= '\u0000' && LA12_74 <= '/')||(LA12_74 >= ':' && LA12_74 <= '@')||(LA12_74 >= '[' && LA12_74 <= '^')||LA12_74=='`'||(LA12_74 >= '{' && LA12_74 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 95 : 
                        int LA12_135 = input.LA(1);

                        s = -1;
                        if ( ((LA12_135 >= '0' && LA12_135 <= '9')||(LA12_135 >= 'A' && LA12_135 <= 'Z')||LA12_135=='_'||(LA12_135 >= 'a' && LA12_135 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_135 >= '\u0000' && LA12_135 <= '/')||(LA12_135 >= ':' && LA12_135 <= '@')||(LA12_135 >= '[' && LA12_135 <= '^')||LA12_135=='`'||(LA12_135 >= '{' && LA12_135 <= '\uFFFF')) ) {s = 27;}

                        else s = 143;

                        if ( s>=0 ) return s;
                        break;

                    case 96 : 
                        int LA12_39 = input.LA(1);

                        s = -1;
                        if ( (LA12_39=='n') ) {s = 66;}

                        else if ( ((LA12_39 >= '0' && LA12_39 <= '9')||(LA12_39 >= 'A' && LA12_39 <= 'Z')||LA12_39=='_'||(LA12_39 >= 'a' && LA12_39 <= 'm')||(LA12_39 >= 'o' && LA12_39 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_39 >= '\u0000' && LA12_39 <= '/')||(LA12_39 >= ':' && LA12_39 <= '@')||(LA12_39 >= '[' && LA12_39 <= '^')||LA12_39=='`'||(LA12_39 >= '{' && LA12_39 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 97 : 
                        int LA12_2 = input.LA(1);

                        s = -1;
                        if ( (LA12_2=='P') ) {s = 31;}

                        else if ( ((LA12_2 >= '0' && LA12_2 <= '9')||(LA12_2 >= 'A' && LA12_2 <= 'O')||(LA12_2 >= 'Q' && LA12_2 <= 'Z')||LA12_2=='_'||(LA12_2 >= 'a' && LA12_2 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_2 >= '\u0000' && LA12_2 <= '/')||(LA12_2 >= ':' && LA12_2 <= '@')||(LA12_2 >= '[' && LA12_2 <= '^')||LA12_2=='`'||(LA12_2 >= '{' && LA12_2 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 98 : 
                        int LA12_75 = input.LA(1);

                        s = -1;
                        if ( (LA12_75=='V') ) {s = 88;}

                        else if ( ((LA12_75 >= '0' && LA12_75 <= '9')||(LA12_75 >= 'A' && LA12_75 <= 'U')||(LA12_75 >= 'W' && LA12_75 <= 'Z')||LA12_75=='_'||(LA12_75 >= 'a' && LA12_75 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_75 >= '\u0000' && LA12_75 <= '/')||(LA12_75 >= ':' && LA12_75 <= '@')||(LA12_75 >= '[' && LA12_75 <= '^')||LA12_75=='`'||(LA12_75 >= '{' && LA12_75 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 99 : 
                        int LA12_88 = input.LA(1);

                        s = -1;
                        if ( (LA12_88=='E') ) {s = 100;}

                        else if ( ((LA12_88 >= '0' && LA12_88 <= '9')||(LA12_88 >= 'A' && LA12_88 <= 'D')||(LA12_88 >= 'F' && LA12_88 <= 'Z')||LA12_88=='_'||(LA12_88 >= 'a' && LA12_88 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_88 >= '\u0000' && LA12_88 <= '/')||(LA12_88 >= ':' && LA12_88 <= '@')||(LA12_88 >= '[' && LA12_88 <= '^')||LA12_88=='`'||(LA12_88 >= '{' && LA12_88 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 100 : 
                        int LA12_32 = input.LA(1);

                        s = -1;
                        if ( (LA12_32=='M') ) {s = 58;}

                        else if ( ((LA12_32 >= '0' && LA12_32 <= '9')||(LA12_32 >= 'A' && LA12_32 <= 'L')||(LA12_32 >= 'N' && LA12_32 <= 'Z')||LA12_32=='_'||(LA12_32 >= 'a' && LA12_32 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_32 >= '\u0000' && LA12_32 <= '/')||(LA12_32 >= ':' && LA12_32 <= '@')||(LA12_32 >= '[' && LA12_32 <= '^')||LA12_32=='`'||(LA12_32 >= '{' && LA12_32 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 101 : 
                        int LA12_66 = input.LA(1);

                        s = -1;
                        if ( (LA12_66=='o') ) {s = 83;}

                        else if ( ((LA12_66 >= '0' && LA12_66 <= '9')||(LA12_66 >= 'A' && LA12_66 <= 'Z')||LA12_66=='_'||(LA12_66 >= 'a' && LA12_66 <= 'n')||(LA12_66 >= 'p' && LA12_66 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_66 >= '\u0000' && LA12_66 <= '/')||(LA12_66 >= ':' && LA12_66 <= '@')||(LA12_66 >= '[' && LA12_66 <= '^')||LA12_66=='`'||(LA12_66 >= '{' && LA12_66 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 102 : 
                        int LA12_58 = input.LA(1);

                        s = -1;
                        if ( (LA12_58=='O') ) {s = 75;}

                        else if ( ((LA12_58 >= '0' && LA12_58 <= '9')||(LA12_58 >= 'A' && LA12_58 <= 'N')||(LA12_58 >= 'P' && LA12_58 <= 'Z')||LA12_58=='_'||(LA12_58 >= 'a' && LA12_58 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_58 >= '\u0000' && LA12_58 <= '/')||(LA12_58 >= ':' && LA12_58 <= '@')||(LA12_58 >= '[' && LA12_58 <= '^')||LA12_58=='`'||(LA12_58 >= '{' && LA12_58 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 103 : 
                        int LA12_83 = input.LA(1);

                        s = -1;
                        if ( (LA12_83=='r') ) {s = 95;}

                        else if ( ((LA12_83 >= '0' && LA12_83 <= '9')||(LA12_83 >= 'A' && LA12_83 <= 'Z')||LA12_83=='_'||(LA12_83 >= 'a' && LA12_83 <= 'q')||(LA12_83 >= 's' && LA12_83 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_83 >= '\u0000' && LA12_83 <= '/')||(LA12_83 >= ':' && LA12_83 <= '@')||(LA12_83 >= '[' && LA12_83 <= '^')||LA12_83=='`'||(LA12_83 >= '{' && LA12_83 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 104 : 
                        int LA12_22 = input.LA(1);

                        s = -1;
                        if ( (LA12_22=='\r') ) {s = 51;}

                        else if ( (LA12_22=='\n') ) {s = 52;}

                        else if ( ((LA12_22 >= '\u0000' && LA12_22 <= '\t')||(LA12_22 >= '\u000B' && LA12_22 <= '\f')||(LA12_22 >= '\u000E' && LA12_22 <= '\uFFFF')) ) {s = 53;}

                        if ( s>=0 ) return s;
                        break;

                    case 105 : 
                        int LA12_95 = input.LA(1);

                        s = -1;
                        if ( (LA12_95=='e') ) {s = 107;}

                        else if ( ((LA12_95 >= '0' && LA12_95 <= '9')||(LA12_95 >= 'A' && LA12_95 <= 'Z')||LA12_95=='_'||(LA12_95 >= 'a' && LA12_95 <= 'd')||(LA12_95 >= 'f' && LA12_95 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_95 >= '\u0000' && LA12_95 <= '/')||(LA12_95 >= ':' && LA12_95 <= '@')||(LA12_95 >= '[' && LA12_95 <= '^')||LA12_95=='`'||(LA12_95 >= '{' && LA12_95 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 106 : 
                        int LA12_107 = input.LA(1);

                        s = -1;
                        if ( (LA12_107=='K') ) {s = 119;}

                        else if ( (LA12_107=='n') ) {s = 120;}

                        else if ( ((LA12_107 >= '0' && LA12_107 <= '9')||(LA12_107 >= 'A' && LA12_107 <= 'J')||(LA12_107 >= 'L' && LA12_107 <= 'Z')||LA12_107=='_'||(LA12_107 >= 'a' && LA12_107 <= 'm')||(LA12_107 >= 'o' && LA12_107 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_107 >= '\u0000' && LA12_107 <= '/')||(LA12_107 >= ':' && LA12_107 <= '@')||(LA12_107 >= '[' && LA12_107 <= '^')||LA12_107=='`'||(LA12_107 >= '{' && LA12_107 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 107 : 
                        int LA12_76 = input.LA(1);

                        s = -1;
                        if ( (LA12_76=='h') ) {s = 89;}

                        else if ( ((LA12_76 >= '0' && LA12_76 <= '9')||(LA12_76 >= 'A' && LA12_76 <= 'Z')||LA12_76=='_'||(LA12_76 >= 'a' && LA12_76 <= 'g')||(LA12_76 >= 'i' && LA12_76 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_76 >= '\u0000' && LA12_76 <= '/')||(LA12_76 >= ':' && LA12_76 <= '@')||(LA12_76 >= '[' && LA12_76 <= '^')||LA12_76=='`'||(LA12_76 >= '{' && LA12_76 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 108 : 
                        int LA12_25 = input.LA(1);

                        s = -1;
                        if ( ((LA12_25 >= '\u0000' && LA12_25 <= '\uFFFF')) ) {s = 27;}

                        else s = 55;

                        if ( s>=0 ) return s;
                        break;

                    case 109 : 
                        int LA12_59 = input.LA(1);

                        s = -1;
                        if ( (LA12_59=='c') ) {s = 76;}

                        else if ( ((LA12_59 >= '0' && LA12_59 <= '9')||(LA12_59 >= 'A' && LA12_59 <= 'Z')||LA12_59=='_'||(LA12_59 >= 'a' && LA12_59 <= 'b')||(LA12_59 >= 'd' && LA12_59 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_59 >= '\u0000' && LA12_59 <= '/')||(LA12_59 >= ':' && LA12_59 <= '@')||(LA12_59 >= '[' && LA12_59 <= '^')||LA12_59=='`'||(LA12_59 >= '{' && LA12_59 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 110 : 
                        int LA12_33 = input.LA(1);

                        s = -1;
                        if ( (LA12_33=='t') ) {s = 59;}

                        else if ( ((LA12_33 >= '0' && LA12_33 <= '9')||(LA12_33 >= 'A' && LA12_33 <= 'Z')||LA12_33=='_'||(LA12_33 >= 'a' && LA12_33 <= 's')||(LA12_33 >= 'u' && LA12_33 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_33 >= '\u0000' && LA12_33 <= '/')||(LA12_33 >= ':' && LA12_33 <= '@')||(LA12_33 >= '[' && LA12_33 <= '^')||LA12_33=='`'||(LA12_33 >= '{' && LA12_33 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 111 : 
                        int LA12_124 = input.LA(1);

                        s = -1;
                        if ( (LA12_124=='e') ) {s = 133;}

                        else if ( ((LA12_124 >= '0' && LA12_124 <= '9')||(LA12_124 >= 'A' && LA12_124 <= 'Z')||LA12_124=='_'||(LA12_124 >= 'a' && LA12_124 <= 'd')||(LA12_124 >= 'f' && LA12_124 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_124 >= '\u0000' && LA12_124 <= '/')||(LA12_124 >= ':' && LA12_124 <= '@')||(LA12_124 >= '[' && LA12_124 <= '^')||LA12_124=='`'||(LA12_124 >= '{' && LA12_124 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 112 : 
                        int LA12_24 = input.LA(1);

                        s = -1;
                        if ( ((LA12_24 >= '\u0000' && LA12_24 <= '\uFFFF')) ) {s = 27;}

                        else s = 54;

                        if ( s>=0 ) return s;
                        break;

                    case 113 : 
                        int LA12_114 = input.LA(1);

                        s = -1;
                        if ( (LA12_114=='d') ) {s = 124;}

                        else if ( ((LA12_114 >= '0' && LA12_114 <= '9')||(LA12_114 >= 'A' && LA12_114 <= 'Z')||LA12_114=='_'||(LA12_114 >= 'a' && LA12_114 <= 'c')||(LA12_114 >= 'e' && LA12_114 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_114 >= '\u0000' && LA12_114 <= '/')||(LA12_114 >= ':' && LA12_114 <= '@')||(LA12_114 >= '[' && LA12_114 <= '^')||LA12_114=='`'||(LA12_114 >= '{' && LA12_114 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 114 : 
                        int LA12_101 = input.LA(1);

                        s = -1;
                        if ( (LA12_101=='o') ) {s = 114;}

                        else if ( ((LA12_101 >= '0' && LA12_101 <= '9')||(LA12_101 >= 'A' && LA12_101 <= 'Z')||LA12_101=='_'||(LA12_101 >= 'a' && LA12_101 <= 'n')||(LA12_101 >= 'p' && LA12_101 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_101 >= '\u0000' && LA12_101 <= '/')||(LA12_101 >= ':' && LA12_101 <= '@')||(LA12_101 >= '[' && LA12_101 <= '^')||LA12_101=='`'||(LA12_101 >= '{' && LA12_101 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 115 : 
                        int LA12_3 = input.LA(1);

                        s = -1;
                        if ( (LA12_3=='E') ) {s = 32;}

                        else if ( ((LA12_3 >= '0' && LA12_3 <= '9')||(LA12_3 >= 'A' && LA12_3 <= 'D')||(LA12_3 >= 'F' && LA12_3 <= 'Z')||LA12_3=='_'||(LA12_3 >= 'a' && LA12_3 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_3 >= '\u0000' && LA12_3 <= '/')||(LA12_3 >= ':' && LA12_3 <= '@')||(LA12_3 >= '[' && LA12_3 <= '^')||LA12_3=='`'||(LA12_3 >= '{' && LA12_3 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 116 : 
                        int LA12_89 = input.LA(1);

                        s = -1;
                        if ( (LA12_89=='m') ) {s = 101;}

                        else if ( ((LA12_89 >= '0' && LA12_89 <= '9')||(LA12_89 >= 'A' && LA12_89 <= 'Z')||LA12_89=='_'||(LA12_89 >= 'a' && LA12_89 <= 'l')||(LA12_89 >= 'n' && LA12_89 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_89 >= '\u0000' && LA12_89 <= '/')||(LA12_89 >= ':' && LA12_89 <= '@')||(LA12_89 >= '[' && LA12_89 <= '^')||LA12_89=='`'||(LA12_89 >= '{' && LA12_89 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 117 : 
                        int LA12_149 = input.LA(1);

                        s = -1;
                        if ( ((LA12_149 >= '0' && LA12_149 <= '9')||(LA12_149 >= 'A' && LA12_149 <= 'Z')||LA12_149=='_'||(LA12_149 >= 'a' && LA12_149 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_149 >= '\u0000' && LA12_149 <= '/')||(LA12_149 >= ':' && LA12_149 <= '@')||(LA12_149 >= '[' && LA12_149 <= '^')||LA12_149=='`'||(LA12_149 >= '{' && LA12_149 <= '\uFFFF')) ) {s = 27;}

                        else s = 154;

                        if ( s>=0 ) return s;
                        break;

                    case 118 : 
                        int LA12_9 = input.LA(1);

                        s = -1;
                        if ( (LA12_9=='g') ) {s = 39;}

                        else if ( ((LA12_9 >= '0' && LA12_9 <= '9')||(LA12_9 >= 'A' && LA12_9 <= 'Z')||LA12_9=='_'||(LA12_9 >= 'a' && LA12_9 <= 'f')||(LA12_9 >= 'h' && LA12_9 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_9 >= '\u0000' && LA12_9 <= '/')||(LA12_9 >= ':' && LA12_9 <= '@')||(LA12_9 >= '[' && LA12_9 <= '^')||LA12_9=='`'||(LA12_9 >= '{' && LA12_9 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 119 : 
                        int LA12_50 = input.LA(1);

                        s = -1;
                        if ( ((LA12_50 >= '0' && LA12_50 <= '9')||(LA12_50 >= 'A' && LA12_50 <= 'Z')||LA12_50=='_'||(LA12_50 >= 'a' && LA12_50 <= 'z')) ) {s = 70;}

                        else if ( ((LA12_50 >= '\u0000' && LA12_50 <= '/')||(LA12_50 >= ':' && LA12_50 <= '@')||(LA12_50 >= '[' && LA12_50 <= '^')||LA12_50=='`'||(LA12_50 >= '{' && LA12_50 <= '\uFFFF')) ) {s = 27;}

                        else s = 71;

                        if ( s>=0 ) return s;
                        break;

                    case 120 : 
                        int LA12_51 = input.LA(1);

                        s = -1;
                        if ( (LA12_51=='\r') ) {s = 51;}

                        else if ( (LA12_51=='\n') ) {s = 52;}

                        else if ( ((LA12_51 >= '\u0000' && LA12_51 <= '\t')||(LA12_51 >= '\u000B' && LA12_51 <= '\f')||(LA12_51 >= '\u000E' && LA12_51 <= '\uFFFF')) ) {s = 53;}

                        else s = 72;

                        if ( s>=0 ) return s;
                        break;

                    case 121 : 
                        int LA12_29 = input.LA(1);

                        s = -1;
                        if ( ((LA12_29 >= '0' && LA12_29 <= '9')||(LA12_29 >= 'A' && LA12_29 <= 'Z')||LA12_29=='_'||(LA12_29 >= 'a' && LA12_29 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_29 >= '\u0000' && LA12_29 <= '/')||(LA12_29 >= ':' && LA12_29 <= '@')||(LA12_29 >= '[' && LA12_29 <= '^')||LA12_29=='`'||(LA12_29 >= '{' && LA12_29 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 122 : 
                        int LA12_13 = input.LA(1);

                        s = -1;
                        if ( ((LA12_13 >= '\u0000' && LA12_13 <= '\uFFFF')) ) {s = 27;}

                        else s = 43;

                        if ( s>=0 ) return s;
                        break;

                    case 123 : 
                        int LA12_12 = input.LA(1);

                        s = -1;
                        if ( ((LA12_12 >= '\u0000' && LA12_12 <= '\uFFFF')) ) {s = 27;}

                        else s = 42;

                        if ( s>=0 ) return s;
                        break;

                    case 124 : 
                        int LA12_92 = input.LA(1);

                        s = -1;
                        if ( ((LA12_92 >= '0' && LA12_92 <= '9')||(LA12_92 >= 'A' && LA12_92 <= 'Z')||LA12_92=='_'||(LA12_92 >= 'a' && LA12_92 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_92 >= '\u0000' && LA12_92 <= '/')||(LA12_92 >= ':' && LA12_92 <= '@')||(LA12_92 >= '[' && LA12_92 <= '^')||LA12_92=='`'||(LA12_92 >= '{' && LA12_92 <= '\uFFFF')) ) {s = 27;}

                        else s = 104;

                        if ( s>=0 ) return s;
                        break;

                    case 125 : 
                        int LA12_14 = input.LA(1);

                        s = -1;
                        if ( ((LA12_14 >= '\u0000' && LA12_14 <= '\uFFFF')) ) {s = 27;}

                        else s = 44;

                        if ( s>=0 ) return s;
                        break;

                    case 126 : 
                        int LA12_37 = input.LA(1);

                        s = -1;
                        if ( (LA12_37=='i') ) {s = 63;}

                        else if ( (LA12_37=='l') ) {s = 64;}

                        else if ( ((LA12_37 >= '0' && LA12_37 <= '9')||(LA12_37 >= 'A' && LA12_37 <= 'Z')||LA12_37=='_'||(LA12_37 >= 'a' && LA12_37 <= 'h')||(LA12_37 >= 'j' && LA12_37 <= 'k')||(LA12_37 >= 'm' && LA12_37 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_37 >= '\u0000' && LA12_37 <= '/')||(LA12_37 >= ':' && LA12_37 <= '@')||(LA12_37 >= '[' && LA12_37 <= '^')||LA12_37=='`'||(LA12_37 >= '{' && LA12_37 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 127 : 
                        int LA12_145 = input.LA(1);

                        s = -1;
                        if ( ((LA12_145 >= '0' && LA12_145 <= '9')||(LA12_145 >= 'A' && LA12_145 <= 'Z')||LA12_145=='_'||(LA12_145 >= 'a' && LA12_145 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_145 >= '\u0000' && LA12_145 <= '/')||(LA12_145 >= ':' && LA12_145 <= '@')||(LA12_145 >= '[' && LA12_145 <= '^')||LA12_145=='`'||(LA12_145 >= '{' && LA12_145 <= '\uFFFF')) ) {s = 27;}

                        else s = 150;

                        if ( s>=0 ) return s;
                        break;

                    case 128 : 
                        int LA12_136 = input.LA(1);

                        s = -1;
                        if ( ((LA12_136 >= '0' && LA12_136 <= '9')||(LA12_136 >= 'A' && LA12_136 <= 'Z')||LA12_136=='_'||(LA12_136 >= 'a' && LA12_136 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_136 >= '\u0000' && LA12_136 <= '/')||(LA12_136 >= ':' && LA12_136 <= '@')||(LA12_136 >= '[' && LA12_136 <= '^')||LA12_136=='`'||(LA12_136 >= '{' && LA12_136 <= '\uFFFF')) ) {s = 27;}

                        else s = 144;

                        if ( s>=0 ) return s;
                        break;

                    case 129 : 
                        int LA12_8 = input.LA(1);

                        s = -1;
                        if ( (LA12_8=='o') ) {s = 38;}

                        else if ( ((LA12_8 >= '0' && LA12_8 <= '9')||(LA12_8 >= 'A' && LA12_8 <= 'Z')||LA12_8=='_'||(LA12_8 >= 'a' && LA12_8 <= 'n')||(LA12_8 >= 'p' && LA12_8 <= 'z')) ) {s = 29;}

                        else if ( ((LA12_8 >= '\u0000' && LA12_8 <= '/')||(LA12_8 >= ':' && LA12_8 <= '@')||(LA12_8 >= '[' && LA12_8 <= '^')||LA12_8=='`'||(LA12_8 >= '{' && LA12_8 <= '\uFFFF')) ) {s = 27;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 130 : 
                        int LA12_15 = input.LA(1);

                        s = -1;
                        if ( ((LA12_15 >= '\u0000' && LA12_15 <= '\uFFFF')) ) {s = 27;}

                        else s = 45;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}