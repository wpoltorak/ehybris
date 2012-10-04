// $ANTLR 3.4 /work/projects/yeclipse/ImpexAST/src/main/java/impex.g 2012-10-04 22:18:54

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
    public static final int Char=13;
    public static final int Comma=14;
    public static final int Comment=15;
    public static final int Digit=16;
    public static final int Dollar=17;
    public static final int Equals=18;
    public static final int ForceWrite=19;
    public static final int HEADER=20;
    public static final int HEADER_PREFIX=21;
    public static final int HEADER_TYPE=22;
    public static final int Hash=23;
    public static final int IMPEX=24;
    public static final int IMPEX_BLOCK=25;
    public static final int IMPEX_BLOCKS=26;
    public static final int IgnoreKeyCase=27;
    public static final int IgnoreNull=28;
    public static final int Insert=29;
    public static final int InsertUpdate=30;
    public static final int LeftBracket=31;
    public static final int LeftParenthesis=32;
    public static final int Letter=33;
    public static final int LineBreak=34;
    public static final int LineContinuation=35;
    public static final int MACRO=36;
    public static final int MacroDefinition=37;
    public static final int MacroExpression=38;
    public static final int MacroIdentifier=39;
    public static final int Pos=40;
    public static final int Processor=41;
    public static final int ROW=42;
    public static final int ROWS=43;
    public static final int Remove=44;
    public static final int RightBracket=45;
    public static final int RightParenthesis=46;
    public static final int SIMPLE_ATTRIBUTE=47;
    public static final int Semicolon=48;
    public static final int Underscore=49;
    public static final int Unique=50;
    public static final int Update=51;
    public static final int Virtual=52;
    public static final int Ws=53;

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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:51:9: ( 'INSERT' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:51:10: 'INSERT'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:52:15: ( 'INSERT_UPDATE' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:52:16: 'INSERT_UPDATE'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:53:9: ( 'UPDATE' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:53:10: 'UPDATE'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:54:9: ( 'REMOVE' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:54:10: 'REMOVE'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:56:12: ( 'batchmode' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:56:13: 'batchmode'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:57:14: ( 'cacheUnique' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:57:15: 'cacheUnique'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:58:12: ( 'processor' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:58:13: 'processor'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:60:8: ( 'alias' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:60:9: 'alias'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:61:12: ( 'allownull' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:61:13: 'allownull'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:62:13: ( 'forceWrite' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:62:14: 'forceWrite'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:63:15: ( 'ignoreKeyCase' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:63:16: 'ignoreKeyCase'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:64:13: ( 'ignorenull' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:64:14: 'ignorenull'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:65:9: ( 'unique' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:65:10: 'unique'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:66:10: ( 'virtual' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:66:11: 'virtual'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:67:6: ( 'pos' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:67:7: 'pos'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:69:9: ( '$' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:69:10: '$'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:70:12: ( ';' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:70:13: ';'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:71:15: ( ']' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:71:16: ']'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:72:14: ( '[' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:72:15: '['
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:73:18: ( '(' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:73:19: '('
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:74:18: ( ')' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:74:19: ')'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:75:9: ( '=' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:75:10: '='
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:76:8: ( ',' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:76:10: ','
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:77:13: ( '_' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:77:14: '_'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:78:7: ( '#' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:78:8: '#'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:79:18: ( '\\\\\\\\' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:79:19: '\\\\\\\\'
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

    // $ANTLR start "MacroDefinition"
    public final void mMacroDefinition() throws RecognitionException {
        try {
            int _type = MacroDefinition;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:82:2: ( Dollar MacroIdentifier )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:82:4: Dollar MacroIdentifier
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

    // $ANTLR start "MacroIdentifier"
    public final void mMacroIdentifier() throws RecognitionException {
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:86:2: ( ( Letter | Underscore ) ( Digit | Letter | Underscore )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:86:4: ( Letter | Underscore ) ( Digit | Letter | Underscore )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:86:25: ( Digit | Letter | Underscore )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0 >= '0' && LA1_0 <= '9')||(LA1_0 >= 'A' && LA1_0 <= 'Z')||LA1_0=='_'||(LA1_0 >= 'a' && LA1_0 <= 'z')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:
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


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MacroIdentifier"

    // $ANTLR start "Comment"
    public final void mComment() throws RecognitionException {
        try {
            int _type = Comment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:90:2: ( Hash (~ ( '\\u000d' | '\\u000a' ) )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:90:4: Hash (~ ( '\\u000d' | '\\u000a' ) )*
            {
            mHash(); 


            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:90:9: (~ ( '\\u000d' | '\\u000a' ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\f')||(LA2_0 >= '\u000E' && LA2_0 <= '\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
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
    // $ANTLR end "Comment"

    // $ANTLR start "LineBreak"
    public final void mLineBreak() throws RecognitionException {
        try {
            int _type = LineBreak;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:94:2: ( ( '\\u000d' )? '\\u000a' | '\\u000d' )
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
                    // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:94:4: ( '\\u000d' )? '\\u000a'
                    {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:94:4: ( '\\u000d' )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0=='\r') ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:94:4: '\\u000d'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:95:4: '\\u000d'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:98:2: ( '\\u0020' | '\\u0009' )
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

    // $ANTLR start "Letter"
    public final void mLetter() throws RecognitionException {
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:102:2: ( 'a' .. 'z' | 'A' .. 'Z' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:
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

    // $ANTLR start "Digit"
    public final void mDigit() throws RecognitionException {
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:105:4: ( '0' .. '9' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:
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

    // $ANTLR start "MacroExpression"
    public final void mMacroExpression() throws RecognitionException {
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:109:2: ( ( Char )+ )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:109:4: ( Char )+
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:109:4: ( Char )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '\u0000' && LA5_0 <= '\t')||(LA5_0 >= '\u000B' && LA5_0 <= '\f')||(LA5_0 >= '\u000E' && LA5_0 <= '!')||LA5_0=='#'||(LA5_0 >= '%' && LA5_0 <= ':')||(LA5_0 >= '<' && LA5_0 <= '\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:
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
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MacroExpression"

    // $ANTLR start "Char"
    public final void mChar() throws RecognitionException {
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:113:2: ( '\\u0000' .. '\\u0009' | '\\u000b' .. '\\u000c' | '\\u000e' .. '\\u0021' | '\\u0023' | '\\u0025' .. '\\u003a' | '\\u003c' .. '\\uffff' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:
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


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Char"

    public void mTokens() throws RecognitionException {
        // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:8: ( Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | ForceWrite | IgnoreKeyCase | IgnoreNull | Unique | Virtual | Pos | Dollar | Semicolon | RightBracket | LeftBracket | LeftParenthesis | RightParenthesis | Equals | Comma | Underscore | Hash | LineContinuation | MacroDefinition | Comment | LineBreak | Ws )
        int alt6=30;
        switch ( input.LA(1) ) {
        case 'I':
            {
            int LA6_1 = input.LA(2);

            if ( (LA6_1=='N') ) {
                int LA6_25 = input.LA(3);

                if ( (LA6_25=='S') ) {
                    int LA6_34 = input.LA(4);

                    if ( (LA6_34=='E') ) {
                        int LA6_38 = input.LA(5);

                        if ( (LA6_38=='R') ) {
                            int LA6_40 = input.LA(6);

                            if ( (LA6_40=='T') ) {
                                int LA6_42 = input.LA(7);

                                if ( (LA6_42=='_') ) {
                                    alt6=2;
                                }
                                else {
                                    alt6=1;
                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 6, 40, input);

                                throw nvae;

                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 6, 38, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 34, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 25, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 1, input);

                throw nvae;

            }
            }
            break;
        case 'U':
            {
            alt6=3;
            }
            break;
        case 'R':
            {
            alt6=4;
            }
            break;
        case 'b':
            {
            alt6=5;
            }
            break;
        case 'c':
            {
            alt6=6;
            }
            break;
        case 'p':
            {
            int LA6_6 = input.LA(2);

            if ( (LA6_6=='r') ) {
                alt6=7;
            }
            else if ( (LA6_6=='o') ) {
                alt6=15;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 6, input);

                throw nvae;

            }
            }
            break;
        case 'a':
            {
            int LA6_7 = input.LA(2);

            if ( (LA6_7=='l') ) {
                int LA6_28 = input.LA(3);

                if ( (LA6_28=='i') ) {
                    alt6=8;
                }
                else if ( (LA6_28=='l') ) {
                    alt6=9;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 28, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 7, input);

                throw nvae;

            }
            }
            break;
        case 'f':
            {
            alt6=10;
            }
            break;
        case 'i':
            {
            int LA6_9 = input.LA(2);

            if ( (LA6_9=='g') ) {
                int LA6_29 = input.LA(3);

                if ( (LA6_29=='n') ) {
                    int LA6_37 = input.LA(4);

                    if ( (LA6_37=='o') ) {
                        int LA6_39 = input.LA(5);

                        if ( (LA6_39=='r') ) {
                            int LA6_41 = input.LA(6);

                            if ( (LA6_41=='e') ) {
                                int LA6_43 = input.LA(7);

                                if ( (LA6_43=='K') ) {
                                    alt6=11;
                                }
                                else if ( (LA6_43=='n') ) {
                                    alt6=12;
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 6, 43, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 6, 41, input);

                                throw nvae;

                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 6, 39, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 37, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 29, input);

                    throw nvae;

                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 9, input);

                throw nvae;

            }
            }
            break;
        case 'u':
            {
            alt6=13;
            }
            break;
        case 'v':
            {
            alt6=14;
            }
            break;
        case '$':
            {
            int LA6_12 = input.LA(2);

            if ( ((LA6_12 >= 'A' && LA6_12 <= 'Z')||LA6_12=='_'||(LA6_12 >= 'a' && LA6_12 <= 'z')) ) {
                alt6=27;
            }
            else {
                alt6=16;
            }
            }
            break;
        case ';':
            {
            alt6=17;
            }
            break;
        case ']':
            {
            alt6=18;
            }
            break;
        case '[':
            {
            alt6=19;
            }
            break;
        case '(':
            {
            alt6=20;
            }
            break;
        case ')':
            {
            alt6=21;
            }
            break;
        case '=':
            {
            alt6=22;
            }
            break;
        case ',':
            {
            alt6=23;
            }
            break;
        case '_':
            {
            alt6=24;
            }
            break;
        case '#':
            {
            int LA6_21 = input.LA(2);

            if ( ((LA6_21 >= '\u0000' && LA6_21 <= '\t')||(LA6_21 >= '\u000B' && LA6_21 <= '\f')||(LA6_21 >= '\u000E' && LA6_21 <= '\uFFFF')) ) {
                alt6=28;
            }
            else {
                alt6=25;
            }
            }
            break;
        case '\\':
            {
            alt6=26;
            }
            break;
        case '\n':
        case '\r':
            {
            alt6=29;
            }
            break;
        case '\t':
        case ' ':
            {
            alt6=30;
            }
            break;
        default:
            NoViableAltException nvae =
                new NoViableAltException("", 6, 0, input);

            throw nvae;

        }

        switch (alt6) {
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
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:268: MacroDefinition
                {
                mMacroDefinition(); 


                }
                break;
            case 28 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:284: Comment
                {
                mComment(); 


                }
                break;
            case 29 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:292: LineBreak
                {
                mLineBreak(); 


                }
                break;
            case 30 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/impex.g:1:302: Ws
                {
                mWs(); 


                }
                break;

        }

    }


 

}