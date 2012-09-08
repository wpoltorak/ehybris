// $ANTLR 3.4 /work/projects/yeclipse/ImpexAST/src/impex.g 2012-09-08 16:57:53

	 package output;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class impexLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__62=62;
    public static final int ASSIGNEMENT=4;
    public static final int ASSIGNEMENTS=5;
    public static final int ATTRIBUTES=6;
    public static final int Alias=7;
    public static final int AllowNull=8;
    public static final int BatchMode=9;
    public static final int Bool=10;
    public static final int BoolAttribModifier=11;
    public static final int BoolHeaderModifier=12;
    public static final int COMMENTS=13;
    public static final int COMPLEX_ATTRIBUTE=14;
    public static final int CacheUnique=15;
    public static final int Char=16;
    public static final int Comma=17;
    public static final int Comment=18;
    public static final int Digit=19;
    public static final int Dollar=20;
    public static final int DoubleQuote=21;
    public static final int Equals=22;
    public static final int ForceWrite=23;
    public static final int HEADER=24;
    public static final int HEADER_PREFIX=25;
    public static final int HEADER_TYPE=26;
    public static final int Hash=27;
    public static final int IMPEX=28;
    public static final int IMPEX_BLOCK=29;
    public static final int IMPEX_BLOCKS=30;
    public static final int IgnoreKeyCase=31;
    public static final int IgnoreNull=32;
    public static final int Insert=33;
    public static final int InsertUpdate=34;
    public static final int Int=35;
    public static final int IntAttribModifier=36;
    public static final int LeftBracket=37;
    public static final int LeftParenthesis=38;
    public static final int Letter=39;
    public static final int LineBreak=40;
    public static final int LineContinuation=41;
    public static final int MACRO=42;
    public static final int MacroDefinition=43;
    public static final int MacroIdentifier=44;
    public static final int Pos=45;
    public static final int Processor=46;
    public static final int ROW=47;
    public static final int ROWS=48;
    public static final int Remove=49;
    public static final int RightBracket=50;
    public static final int RightParenthesis=51;
    public static final int SIMPLE_ATTRIBUTE=52;
    public static final int Semicolon=53;
    public static final int Underscore=54;
    public static final int Unique=55;
    public static final int Update=56;
    public static final int Virtual=57;
    public static final int Word=58;
    public static final int WordAttribModifier=59;
    public static final int WordHeaderModifier=60;
    public static final int Ws=61;

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
    public String getGrammarFileName() { return "/work/projects/yeclipse/ImpexAST/src/impex.g"; }

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/impex.g:11:7: ( '.' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:11:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "MacroDefinition"
    public final void mMacroDefinition() throws RecognitionException {
        try {
            int _type = MacroDefinition;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/impex.g:59:2: ( Dollar MacroIdentifier )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:59:4: Dollar MacroIdentifier
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

    // $ANTLR start "Insert"
    public final void mInsert() throws RecognitionException {
        try {
            int _type = Insert;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/impex.g:120:9: ( 'INSERT' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:120:10: 'INSERT'
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:121:14: ( 'INSERT_UPDATE' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:121:15: 'INSERT_UPDATE'
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:122:9: ( 'UPDATE' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:122:10: 'UPDATE'
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:123:9: ( 'REMOVE' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:123:10: 'REMOVE'
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:125:12: ( 'batchmode' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:125:13: 'batchmode'
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:126:13: ( 'cacheUnique' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:126:14: 'cacheUnique'
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:127:12: ( 'processor' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:127:13: 'processor'
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:129:8: ( 'alias' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:129:9: 'alias'
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:130:12: ( 'allownull' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:130:13: 'allownull'
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:131:13: ( 'forceWrite' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:131:14: 'forceWrite'
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:132:15: ( 'ignoreKeyCase' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:132:16: 'ignoreKeyCase'
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:133:13: ( 'ignorenull' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:133:14: 'ignorenull'
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:134:9: ( 'unique' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:134:10: 'unique'
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:135:10: ( 'virtual' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:135:11: 'virtual'
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:136:6: ( 'pos' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:136:7: 'pos'
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:138:9: ( '$' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:138:10: '$'
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:139:12: ( ';' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:139:13: ';'
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:140:15: ( ']' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:140:16: ']'
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:141:14: ( '[' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:141:15: '['
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:142:18: ( '(' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:142:19: '('
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:143:18: ( ')' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:143:19: ')'
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:144:9: ( '=' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:144:10: '='
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:145:8: ( ',' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:145:10: ','
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:146:13: ( '_' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:146:14: '_'
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:147:7: ( '#' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:147:8: '#'
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:150:2: ( '\\u2216' '\\u2216' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:150:5: '\\u2216' '\\u2216'
            {
            match('\u2216'); 

            match('\u2216'); 

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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:154:2: ( 'true' | 'false' )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='t') ) {
                alt1=1;
            }
            else if ( (LA1_0=='f') ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }
            switch (alt1) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:154:4: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:154:13: 'false'
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:158:2: ( Hash (~ ( '\\u000d' | '\\u000a' ) )* ( LineBreak )? )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:158:4: Hash (~ ( '\\u000d' | '\\u000a' ) )* ( LineBreak )?
            {
            mHash(); 


            // /work/projects/yeclipse/ImpexAST/src/impex.g:158:9: (~ ( '\\u000d' | '\\u000a' ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '\u0000' && LA2_0 <= '\t')||(LA2_0 >= '\u000B' && LA2_0 <= '\f')||(LA2_0 >= '\u000E' && LA2_0 <= '\uFFFF')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/impex.g:
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


            // /work/projects/yeclipse/ImpexAST/src/impex.g:158:33: ( LineBreak )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\n'||LA3_0=='\r') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:158:33: LineBreak
                    {
                    mLineBreak(); 


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
    // $ANTLR end "Comment"

    // $ANTLR start "Ws"
    public final void mWs() throws RecognitionException {
        try {
            // /work/projects/yeclipse/ImpexAST/src/impex.g:162:2: ( '\\u0020' | '\\u0009' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:
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

    // $ANTLR start "LineBreak"
    public final void mLineBreak() throws RecognitionException {
        try {
            int _type = LineBreak;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/impex.g:166:2: ( ( '\\u000d' )? '\\u000a' | '\\u000d' )
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
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:166:4: ( '\\u000d' )? '\\u000a'
                    {
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:166:4: ( '\\u000d' )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0=='\r') ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/impex.g:166:4: '\\u000d'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:167:4: '\\u000d'
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

    // $ANTLR start "Word"
    public final void mWord() throws RecognitionException {
        try {
            int _type = Word;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/impex.g:171:2: ( ( Letter )+ )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:171:4: ( Letter )+
            {
            // /work/projects/yeclipse/ImpexAST/src/impex.g:171:4: ( Letter )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= 'A' && LA6_0 <= 'Z')||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/impex.g:
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
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:175:2: ( 'a' .. 'z' | 'A' .. 'Z' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:178:2: ( '\"' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:178:4: '\"'
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
            int _type = Int;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/impex.g:182:4: ( '1' .. '9' ( Digit )* | '0' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0 >= '1' && LA8_0 <= '9')) ) {
                alt8=1;
            }
            else if ( (LA8_0=='0') ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:182:8: '1' .. '9' ( Digit )*
                    {
                    matchRange('1','9'); 

                    // /work/projects/yeclipse/ImpexAST/src/impex.g:182:17: ( Digit )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( ((LA7_0 >= '0' && LA7_0 <= '9')) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/impex.g:
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
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:183:7: '0'
                    {
                    match('0'); 

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
    // $ANTLR end "Int"

    // $ANTLR start "Digit"
    public final void mDigit() throws RecognitionException {
        try {
            // /work/projects/yeclipse/ImpexAST/src/impex.g:187:4: ( '0' .. '9' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:191:2: ( '\\u0000' .. '\\u0009' | '\\u000b' .. '\\u000c' | '\\u000e' .. '\\u0021' | '\\u0023' | '\\u0025' .. '\\u003a' | '\\u003c' .. '\\uffff' )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:
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

    // $ANTLR start "BoolHeaderModifier"
    public final void mBoolHeaderModifier() throws RecognitionException {
        try {
            // /work/projects/yeclipse/ImpexAST/src/impex.g:200:2: ( BatchMode | CacheUnique )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='b') ) {
                alt9=1;
            }
            else if ( (LA9_0=='c') ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:200:4: BatchMode
                    {
                    mBatchMode(); 


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:200:16: CacheUnique
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:204:2: ( Processor )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:204:4: Processor
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:207:2: ( AllowNull | ForceWrite | IgnoreKeyCase | IgnoreNull | Unique | Virtual )
            int alt10=6;
            switch ( input.LA(1) ) {
            case 'a':
                {
                alt10=1;
                }
                break;
            case 'f':
                {
                alt10=2;
                }
                break;
            case 'i':
                {
                int LA10_3 = input.LA(2);

                if ( (LA10_3=='g') ) {
                    int LA10_6 = input.LA(3);

                    if ( (LA10_6=='n') ) {
                        int LA10_7 = input.LA(4);

                        if ( (LA10_7=='o') ) {
                            int LA10_8 = input.LA(5);

                            if ( (LA10_8=='r') ) {
                                int LA10_9 = input.LA(6);

                                if ( (LA10_9=='e') ) {
                                    int LA10_10 = input.LA(7);

                                    if ( (LA10_10=='K') ) {
                                        alt10=3;
                                    }
                                    else if ( (LA10_10=='n') ) {
                                        alt10=4;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 10, 10, input);

                                        throw nvae;

                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 10, 9, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 10, 8, input);

                                throw nvae;

                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 10, 7, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 10, 6, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 10, 3, input);

                    throw nvae;

                }
                }
                break;
            case 'u':
                {
                alt10=5;
                }
                break;
            case 'v':
                {
                alt10=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;

            }

            switch (alt10) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:207:4: AllowNull
                    {
                    mAllowNull(); 


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:207:16: ForceWrite
                    {
                    mForceWrite(); 


                    }
                    break;
                case 3 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:207:29: IgnoreKeyCase
                    {
                    mIgnoreKeyCase(); 


                    }
                    break;
                case 4 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:207:45: IgnoreNull
                    {
                    mIgnoreNull(); 


                    }
                    break;
                case 5 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:207:58: Unique
                    {
                    mUnique(); 


                    }
                    break;
                case 6 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:207:67: Virtual
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:211:2: ( Alias | 'cellDecorator' | 'collection-delimiter' | 'dateformat' | 'default' | 'key2value-delimiter' | 'lang' | 'map-delimiter' | 'mode' | 'numberformat' | 'path-delimiter' | 'translator' )
            int alt11=12;
            switch ( input.LA(1) ) {
            case 'a':
                {
                alt11=1;
                }
                break;
            case 'c':
                {
                int LA11_2 = input.LA(2);

                if ( (LA11_2=='e') ) {
                    alt11=2;
                }
                else if ( (LA11_2=='o') ) {
                    alt11=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 2, input);

                    throw nvae;

                }
                }
                break;
            case 'd':
                {
                int LA11_3 = input.LA(2);

                if ( (LA11_3=='a') ) {
                    alt11=4;
                }
                else if ( (LA11_3=='e') ) {
                    alt11=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 3, input);

                    throw nvae;

                }
                }
                break;
            case 'k':
                {
                alt11=6;
                }
                break;
            case 'l':
                {
                alt11=7;
                }
                break;
            case 'm':
                {
                int LA11_6 = input.LA(2);

                if ( (LA11_6=='a') ) {
                    alt11=8;
                }
                else if ( (LA11_6=='o') ) {
                    alt11=9;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 6, input);

                    throw nvae;

                }
                }
                break;
            case 'n':
                {
                alt11=10;
                }
                break;
            case 'p':
                {
                alt11=11;
                }
                break;
            case 't':
                {
                alt11=12;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;

            }

            switch (alt11) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:211:4: Alias
                    {
                    mAlias(); 


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:211:13: 'cellDecorator'
                    {
                    match("cellDecorator"); 



                    }
                    break;
                case 3 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:211:31: 'collection-delimiter'
                    {
                    match("collection-delimiter"); 



                    }
                    break;
                case 4 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:211:56: 'dateformat'
                    {
                    match("dateformat"); 



                    }
                    break;
                case 5 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:211:71: 'default'
                    {
                    match("default"); 



                    }
                    break;
                case 6 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:211:84: 'key2value-delimiter'
                    {
                    match("key2value-delimiter"); 



                    }
                    break;
                case 7 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:211:108: 'lang'
                    {
                    match("lang"); 



                    }
                    break;
                case 8 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:212:4: 'map-delimiter'
                    {
                    match("map-delimiter"); 



                    }
                    break;
                case 9 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:212:22: 'mode'
                    {
                    match("mode"); 



                    }
                    break;
                case 10 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:212:31: 'numberformat'
                    {
                    match("numberformat"); 



                    }
                    break;
                case 11 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:212:48: 'path-delimiter'
                    {
                    match("path-delimiter"); 



                    }
                    break;
                case 12 :
                    // /work/projects/yeclipse/ImpexAST/src/impex.g:212:67: 'translator'
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:216:2: ( Pos )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:216:4: Pos
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
            // /work/projects/yeclipse/ImpexAST/src/impex.g:220:2: ( ( Letter | Underscore ) ( Digit | Letter | Underscore )* )
            // /work/projects/yeclipse/ImpexAST/src/impex.g:220:4: ( Letter | Underscore ) ( Digit | Letter | Underscore )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /work/projects/yeclipse/ImpexAST/src/impex.g:220:25: ( Digit | Letter | Underscore )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0 >= '0' && LA12_0 <= '9')||(LA12_0 >= 'A' && LA12_0 <= 'Z')||LA12_0=='_'||(LA12_0 >= 'a' && LA12_0 <= 'z')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/impex.g:
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
            	    break loop12;
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

    public void mTokens() throws RecognitionException {
        // /work/projects/yeclipse/ImpexAST/src/impex.g:1:8: ( T__62 | MacroDefinition | Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | ForceWrite | IgnoreKeyCase | IgnoreNull | Unique | Virtual | Pos | Dollar | Semicolon | RightBracket | LeftBracket | LeftParenthesis | RightParenthesis | Equals | Comma | Underscore | Hash | LineContinuation | Bool | Comment | LineBreak | Word | Int | Char | MacroIdentifier )
        int alt13=35;
        alt13 = dfa13.predict(input);
        switch (alt13) {
            case 1 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:10: T__62
                {
                mT__62(); 


                }
                break;
            case 2 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:16: MacroDefinition
                {
                mMacroDefinition(); 


                }
                break;
            case 3 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:32: Insert
                {
                mInsert(); 


                }
                break;
            case 4 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:39: InsertUpdate
                {
                mInsertUpdate(); 


                }
                break;
            case 5 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:52: Update
                {
                mUpdate(); 


                }
                break;
            case 6 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:59: Remove
                {
                mRemove(); 


                }
                break;
            case 7 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:66: BatchMode
                {
                mBatchMode(); 


                }
                break;
            case 8 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:76: CacheUnique
                {
                mCacheUnique(); 


                }
                break;
            case 9 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:88: Processor
                {
                mProcessor(); 


                }
                break;
            case 10 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:98: Alias
                {
                mAlias(); 


                }
                break;
            case 11 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:104: AllowNull
                {
                mAllowNull(); 


                }
                break;
            case 12 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:114: ForceWrite
                {
                mForceWrite(); 


                }
                break;
            case 13 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:125: IgnoreKeyCase
                {
                mIgnoreKeyCase(); 


                }
                break;
            case 14 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:139: IgnoreNull
                {
                mIgnoreNull(); 


                }
                break;
            case 15 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:150: Unique
                {
                mUnique(); 


                }
                break;
            case 16 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:157: Virtual
                {
                mVirtual(); 


                }
                break;
            case 17 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:165: Pos
                {
                mPos(); 


                }
                break;
            case 18 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:169: Dollar
                {
                mDollar(); 


                }
                break;
            case 19 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:176: Semicolon
                {
                mSemicolon(); 


                }
                break;
            case 20 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:186: RightBracket
                {
                mRightBracket(); 


                }
                break;
            case 21 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:199: LeftBracket
                {
                mLeftBracket(); 


                }
                break;
            case 22 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:211: LeftParenthesis
                {
                mLeftParenthesis(); 


                }
                break;
            case 23 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:227: RightParenthesis
                {
                mRightParenthesis(); 


                }
                break;
            case 24 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:244: Equals
                {
                mEquals(); 


                }
                break;
            case 25 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:251: Comma
                {
                mComma(); 


                }
                break;
            case 26 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:257: Underscore
                {
                mUnderscore(); 


                }
                break;
            case 27 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:268: Hash
                {
                mHash(); 


                }
                break;
            case 28 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:273: LineContinuation
                {
                mLineContinuation(); 


                }
                break;
            case 29 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:290: Bool
                {
                mBool(); 


                }
                break;
            case 30 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:295: Comment
                {
                mComment(); 


                }
                break;
            case 31 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:303: LineBreak
                {
                mLineBreak(); 


                }
                break;
            case 32 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:313: Word
                {
                mWord(); 


                }
                break;
            case 33 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:318: Int
                {
                mInt(); 


                }
                break;
            case 34 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:322: Char
                {
                mChar(); 


                }
                break;
            case 35 :
                // /work/projects/yeclipse/ImpexAST/src/impex.g:1:327: MacroIdentifier
                {
                mMacroIdentifier(); 


                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\2\uffff\1\37\13\42\7\uffff\1\67\1\70\1\35\1\42\1\uffff\1\42\6\uffff"+
        "\1\42\1\uffff\1\42\1\uffff\14\42\12\uffff\1\42\1\uffff\6\42\1\122"+
        "\16\42\1\uffff\7\42\1\150\6\42\1\157\2\42\1\150\3\42\1\uffff\1\166"+
        "\1\167\1\170\3\42\1\uffff\3\42\1\u0080\1\42\1\44\3\uffff\7\42\1"+
        "\uffff\1\u008a\1\44\7\42\1\uffff\1\44\1\u0094\1\42\1\u0096\1\u0097"+
        "\3\42\1\44\1\uffff\1\42\2\uffff\1\u009d\1\42\1\u009f\1\44\1\u00a1"+
        "\1\uffff\1\42\1\uffff\1\44\1\uffff\1\42\1\u00a5\1\u00a6\2\uffff";
    static final String DFA13_eofS =
        "\u00a7\uffff";
    static final String DFA13_minS =
        "\1\0\1\uffff\1\101\13\60\7\uffff\1\60\1\0\1\u2216\1\60\1\uffff\1"+
        "\60\6\uffff\1\60\1\uffff\1\60\1\uffff\14\60\12\uffff\1\60\1\uffff"+
        "\25\60\1\uffff\25\60\1\uffff\6\60\1\uffff\5\60\1\125\3\uffff\7\60"+
        "\1\uffff\1\60\1\120\7\60\1\uffff\1\104\7\60\1\101\1\uffff\1\60\2"+
        "\uffff\3\60\1\124\1\60\1\uffff\1\60\1\uffff\1\105\1\uffff\3\60\2"+
        "\uffff";
    static final String DFA13_maxS =
        "\1\uffff\1\uffff\14\172\7\uffff\1\172\1\uffff\1\u2216\1\172\1\uffff"+
        "\1\172\6\uffff\1\172\1\uffff\1\172\1\uffff\14\172\12\uffff\1\172"+
        "\1\uffff\25\172\1\uffff\25\172\1\uffff\6\172\1\uffff\5\172\1\125"+
        "\3\uffff\7\172\1\uffff\1\172\1\120\7\172\1\uffff\1\104\7\172\1\101"+
        "\1\uffff\1\172\2\uffff\3\172\1\124\1\172\1\uffff\1\172\1\uffff\1"+
        "\105\1\uffff\3\172\2\uffff";
    static final String DFA13_acceptS =
        "\1\uffff\1\1\14\uffff\1\23\1\24\1\25\1\26\1\27\1\30\1\31\4\uffff"+
        "\1\37\1\uffff\2\41\1\42\1\1\1\22\1\2\1\uffff\1\40\1\uffff\1\43\14"+
        "\uffff\1\24\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\36\1\34\1\uffff"+
        "\1\41\25\uffff\1\21\25\uffff\1\35\6\uffff\1\12\6\uffff\1\3\1\5\1"+
        "\6\7\uffff\1\17\11\uffff\1\20\11\uffff\1\7\1\uffff\1\11\1\13\5\uffff"+
        "\1\14\1\uffff\1\16\1\uffff\1\10\3\uffff\1\4\1\15";
    static final String DFA13_specialS =
        "\1\0\25\uffff\1\1\u0090\uffff}>";
    static final String[] DFA13_transitionS = {
            "\12\35\1\31\2\35\1\31\24\35\1\uffff\1\26\1\2\3\35\1\21\1\22"+
            "\2\35\1\24\1\35\1\1\1\35\1\34\11\33\1\35\1\16\1\35\1\23\3\35"+
            "\10\32\1\3\10\32\1\5\2\32\1\4\5\32\1\20\1\35\1\17\1\35\1\25"+
            "\1\35\1\11\1\6\1\7\2\32\1\12\2\32\1\13\6\32\1\10\3\32\1\30\1"+
            "\14\1\15\4\32\u219b\35\1\27\udde9\35",
            "",
            "\32\40\4\uffff\1\40\1\uffff\32\40",
            "\12\44\7\uffff\15\43\1\41\14\43\4\uffff\1\44\1\uffff\32\43",
            "\12\44\7\uffff\17\43\1\45\12\43\4\uffff\1\44\1\uffff\32\43",
            "\12\44\7\uffff\4\43\1\46\25\43\4\uffff\1\44\1\uffff\32\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\1\47\31\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\1\50\31\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\16\43\1\52\2\43\1"+
            "\51\10\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\13\43\1\53\16\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\1\55\15\43\1\54\13"+
            "\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\6\43\1\56\23\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\15\43\1\57\14\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\10\43\1\60\21\43",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\0\71",
            "\1\72",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\21\43\1\73\10\43",
            "",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\32\43",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\44\7\uffff\22\43\1\75\7\43\4\uffff\1\44\1\uffff\32\43",
            "",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\32\43",
            "",
            "\12\44\7\uffff\3\43\1\76\26\43\4\uffff\1\44\1\uffff\32\43",
            "\12\44\7\uffff\14\43\1\77\15\43\4\uffff\1\44\1\uffff\32\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\23\43\1\100\6\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\2\43\1\101\27\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\16\43\1\102\13\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\22\43\1\103\7\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\10\43\1\104\2\43"+
            "\1\105\16\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\21\43\1\106\10\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\13\43\1\107\16\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\15\43\1\110\14\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\10\43\1\111\21\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\21\43\1\112\10\43",
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
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\24\43\1\113\5\43",
            "",
            "\12\44\7\uffff\4\43\1\114\25\43\4\uffff\1\44\1\uffff\32\43",
            "\12\44\7\uffff\1\115\31\43\4\uffff\1\44\1\uffff\32\43",
            "\12\44\7\uffff\16\43\1\116\13\43\4\uffff\1\44\1\uffff\32\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\2\43\1\117\27\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\7\43\1\120\22\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\2\43\1\121\27\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\32\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\1\123\31\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\16\43\1\124\13\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\2\43\1\125\27\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\22\43\1\126\7\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\16\43\1\127\13\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\20\43\1\130\11\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\23\43\1\131\6\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\4\43\1\132\25\43",
            "\12\44\7\uffff\21\43\1\133\10\43\4\uffff\1\44\1\uffff\32\43",
            "\12\44\7\uffff\23\43\1\134\6\43\4\uffff\1\44\1\uffff\32\43",
            "\12\44\7\uffff\25\43\1\135\4\43\4\uffff\1\44\1\uffff\32\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\7\43\1\136\22\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\4\43\1\137\25\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\4\43\1\140\25\43",
            "",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\22\43\1\141\7\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\26\43\1\142\3\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\4\43\1\143\25\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\4\43\1\144\25\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\21\43\1\145\10\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\24\43\1\146\5\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\24\43\1\147\5\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\32\43",
            "\12\44\7\uffff\23\43\1\151\6\43\4\uffff\1\44\1\uffff\32\43",
            "\12\44\7\uffff\4\43\1\152\25\43\4\uffff\1\44\1\uffff\32\43",
            "\12\44\7\uffff\4\43\1\153\25\43\4\uffff\1\44\1\uffff\32\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\14\43\1\154\15\43",
            "\12\44\7\uffff\24\43\1\155\5\43\4\uffff\1\44\1\uffff\32\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\22\43\1\156\7\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\32\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\15\43\1\160\14\43",
            "\12\44\7\uffff\26\43\1\161\3\43\4\uffff\1\44\1\uffff\32\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\32\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\4\43\1\162\25\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\4\43\1\163\25\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\1\164\31\43",
            "",
            "\12\44\7\uffff\32\43\4\uffff\1\165\1\uffff\32\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\32\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\32\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\16\43\1\171\13\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\15\43\1\172\14\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\22\43\1\173\7\43",
            "",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\24\43\1\174\5\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\21\43\1\175\10\43",
            "\12\44\7\uffff\12\43\1\176\17\43\4\uffff\1\44\1\uffff\15\43"+
            "\1\177\14\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\32\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\13\43\1\u0081\16"+
            "\43",
            "\1\u0082",
            "",
            "",
            "",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\3\43\1\u0083\26\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\10\43\1\u0084\21"+
            "\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\16\43\1\u0085\13"+
            "\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\13\43\1\u0086\16"+
            "\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\10\43\1\u0087\21"+
            "\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\4\43\1\u0088\25\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\24\43\1\u0089\5\43",
            "",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\32\43",
            "\1\u008b",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\4\43\1\u008c\25\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\20\43\1\u008d\11"+
            "\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\21\43\1\u008e\10"+
            "\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\13\43\1\u008f\16"+
            "\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\23\43\1\u0090\6\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\30\43\1\u0091\1\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\13\43\1\u0092\16"+
            "\43",
            "",
            "\1\u0093",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\32\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\24\43\1\u0095\5\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\32\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\32\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\4\43\1\u0098\25\43",
            "\12\44\7\uffff\2\43\1\u0099\27\43\4\uffff\1\44\1\uffff\32\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\13\43\1\u009a\16"+
            "\43",
            "\1\u009b",
            "",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\4\43\1\u009c\25\43",
            "",
            "",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\32\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\1\u009e\31\43",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\32\43",
            "\1\u00a0",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\32\43",
            "",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\22\43\1\u00a2\7\43",
            "",
            "\1\u00a3",
            "",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\4\43\1\u00a4\25\43",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\12\44\7\uffff\32\43\4\uffff\1\44\1\uffff\32\43",
            "",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__62 | MacroDefinition | Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | ForceWrite | IgnoreKeyCase | IgnoreNull | Unique | Virtual | Pos | Dollar | Semicolon | RightBracket | LeftBracket | LeftParenthesis | RightParenthesis | Equals | Comma | Underscore | Hash | LineContinuation | Bool | Comment | LineBreak | Word | Int | Char | MacroIdentifier );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA13_0 = input.LA(1);

                        s = -1;
                        if ( (LA13_0=='.') ) {s = 1;}

                        else if ( (LA13_0=='$') ) {s = 2;}

                        else if ( (LA13_0=='I') ) {s = 3;}

                        else if ( (LA13_0=='U') ) {s = 4;}

                        else if ( (LA13_0=='R') ) {s = 5;}

                        else if ( (LA13_0=='b') ) {s = 6;}

                        else if ( (LA13_0=='c') ) {s = 7;}

                        else if ( (LA13_0=='p') ) {s = 8;}

                        else if ( (LA13_0=='a') ) {s = 9;}

                        else if ( (LA13_0=='f') ) {s = 10;}

                        else if ( (LA13_0=='i') ) {s = 11;}

                        else if ( (LA13_0=='u') ) {s = 12;}

                        else if ( (LA13_0=='v') ) {s = 13;}

                        else if ( (LA13_0==';') ) {s = 14;}

                        else if ( (LA13_0==']') ) {s = 15;}

                        else if ( (LA13_0=='[') ) {s = 16;}

                        else if ( (LA13_0=='(') ) {s = 17;}

                        else if ( (LA13_0==')') ) {s = 18;}

                        else if ( (LA13_0=='=') ) {s = 19;}

                        else if ( (LA13_0==',') ) {s = 20;}

                        else if ( (LA13_0=='_') ) {s = 21;}

                        else if ( (LA13_0=='#') ) {s = 22;}

                        else if ( (LA13_0=='\u2216') ) {s = 23;}

                        else if ( (LA13_0=='t') ) {s = 24;}

                        else if ( (LA13_0=='\n'||LA13_0=='\r') ) {s = 25;}

                        else if ( ((LA13_0 >= 'A' && LA13_0 <= 'H')||(LA13_0 >= 'J' && LA13_0 <= 'Q')||(LA13_0 >= 'S' && LA13_0 <= 'T')||(LA13_0 >= 'V' && LA13_0 <= 'Z')||(LA13_0 >= 'd' && LA13_0 <= 'e')||(LA13_0 >= 'g' && LA13_0 <= 'h')||(LA13_0 >= 'j' && LA13_0 <= 'o')||(LA13_0 >= 'q' && LA13_0 <= 's')||(LA13_0 >= 'w' && LA13_0 <= 'z')) ) {s = 26;}

                        else if ( ((LA13_0 >= '1' && LA13_0 <= '9')) ) {s = 27;}

                        else if ( (LA13_0=='0') ) {s = 28;}

                        else if ( ((LA13_0 >= '\u0000' && LA13_0 <= '\t')||(LA13_0 >= '\u000B' && LA13_0 <= '\f')||(LA13_0 >= '\u000E' && LA13_0 <= '!')||(LA13_0 >= '%' && LA13_0 <= '\'')||(LA13_0 >= '*' && LA13_0 <= '+')||LA13_0=='-'||LA13_0=='/'||LA13_0==':'||LA13_0=='<'||(LA13_0 >= '>' && LA13_0 <= '@')||LA13_0=='\\'||LA13_0=='^'||LA13_0=='`'||(LA13_0 >= '{' && LA13_0 <= '\u2215')||(LA13_0 >= '\u2217' && LA13_0 <= '\uFFFF')) ) {s = 29;}

                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA13_22 = input.LA(1);

                        s = -1;
                        if ( ((LA13_22 >= '\u0000' && LA13_22 <= '\uFFFF')) ) {s = 57;}

                        else s = 56;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 13, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}