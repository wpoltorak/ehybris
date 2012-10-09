// $ANTLR 3.4 /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g 2012-10-09 11:41:03

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
    public static final int Bool=10;
    public static final int COMMENTS=11;
    public static final int COMPLEX_ATTRIBUTE=12;
    public static final int CacheUnique=13;
    public static final int CellDecorator=14;
    public static final int CollectionDelimiter=15;
    public static final int Comma=16;
    public static final int Comment=17;
    public static final int Dateformat=18;
    public static final int Default=19;
    public static final int Equals=20;
    public static final int ForceWrite=21;
    public static final int HEADER=22;
    public static final int HEADER_PREFIX=23;
    public static final int HEADER_TYPE=24;
    public static final int IMPEX=25;
    public static final int IMPEX_BLOCK=26;
    public static final int IMPEX_BLOCKS=27;
    public static final int Identifier=28;
    public static final int IgnoreKeyCase=29;
    public static final int IgnoreNull=30;
    public static final int Insert=31;
    public static final int InsertUpdate=32;
    public static final int KeyToValueDelimiter=33;
    public static final int Lang=34;
    public static final int LeftBracket=35;
    public static final int LeftParenthesis=36;
    public static final int LineBreak=37;
    public static final int LineContinuation=38;
    public static final int MACRO=39;
    public static final int Macrodef=40;
    public static final int MapDelimiter=41;
    public static final int Mode=42;
    public static final int Numberformat=43;
    public static final int PathDelimiter=44;
    public static final int Pos=45;
    public static final int Processor=46;
    public static final int ROW=47;
    public static final int ROWS=48;
    public static final int Remove=49;
    public static final int RightBracket=50;
    public static final int RightParenthesis=51;
    public static final int SIMPLE_ATTRIBUTE=52;
    public static final int Semicolon=53;
    public static final int Text=54;
    public static final int Translator=55;
    public static final int Unique=56;
    public static final int Update=57;
    public static final int Virtual=58;
    public static final int Ws=59;

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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:97:9: ( 'INSERT' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:97:10: 'INSERT'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:98:14: ( 'INSERT_UPDATE' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:98:15: 'INSERT_UPDATE'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:99:9: ( 'UPDATE' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:99:10: 'UPDATE'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:100:9: ( 'REMOVE' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:100:10: 'REMOVE'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:102:12: ( 'batchmode' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:102:13: 'batchmode'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:103:13: ( 'cacheUnique' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:103:14: 'cacheUnique'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:104:12: ( 'processor' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:104:13: 'processor'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:106:8: ( 'alias' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:106:9: 'alias'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:107:12: ( 'allownull' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:107:13: 'allownull'
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

    // $ANTLR start "CellDecorator"
    public final void mCellDecorator() throws RecognitionException {
        try {
            int _type = CellDecorator;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:108:15: ( 'cellDecorator' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:108:16: 'cellDecorator'
            {
            match("cellDecorator"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CellDecorator"

    // $ANTLR start "CollectionDelimiter"
    public final void mCollectionDelimiter() throws RecognitionException {
        try {
            int _type = CollectionDelimiter;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:109:22: ( 'collection-delimiter' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:109:23: 'collection-delimiter'
            {
            match("collection-delimiter"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "CollectionDelimiter"

    // $ANTLR start "Dateformat"
    public final void mDateformat() throws RecognitionException {
        try {
            int _type = Dateformat;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:110:13: ( 'dateformat' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:110:14: 'dateformat'
            {
            match("dateformat"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Dateformat"

    // $ANTLR start "Default"
    public final void mDefault() throws RecognitionException {
        try {
            int _type = Default;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:111:10: ( 'default' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:111:11: 'default'
            {
            match("default"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Default"

    // $ANTLR start "ForceWrite"
    public final void mForceWrite() throws RecognitionException {
        try {
            int _type = ForceWrite;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:112:13: ( 'forceWrite' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:112:14: 'forceWrite'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:113:15: ( 'ignoreKeyCase' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:113:16: 'ignoreKeyCase'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:114:13: ( 'ignorenull' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:114:14: 'ignorenull'
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

    // $ANTLR start "KeyToValueDelimiter"
    public final void mKeyToValueDelimiter() throws RecognitionException {
        try {
            int _type = KeyToValueDelimiter;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:115:21: ( 'key2value-delimiter' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:115:22: 'key2value-delimiter'
            {
            match("key2value-delimiter"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "KeyToValueDelimiter"

    // $ANTLR start "Lang"
    public final void mLang() throws RecognitionException {
        try {
            int _type = Lang;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:116:7: ( 'lang' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:116:8: 'lang'
            {
            match("lang"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Lang"

    // $ANTLR start "MapDelimiter"
    public final void mMapDelimiter() throws RecognitionException {
        try {
            int _type = MapDelimiter;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:117:14: ( 'map-delimiter' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:117:15: 'map-delimiter'
            {
            match("map-delimiter"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "MapDelimiter"

    // $ANTLR start "Mode"
    public final void mMode() throws RecognitionException {
        try {
            int _type = Mode;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:118:7: ( 'mode' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:118:8: 'mode'
            {
            match("mode"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Mode"

    // $ANTLR start "Numberformat"
    public final void mNumberformat() throws RecognitionException {
        try {
            int _type = Numberformat;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:119:14: ( 'numberformat' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:119:15: 'numberformat'
            {
            match("numberformat"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Numberformat"

    // $ANTLR start "PathDelimiter"
    public final void mPathDelimiter() throws RecognitionException {
        try {
            int _type = PathDelimiter;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:120:15: ( 'path-delimiter' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:120:16: 'path-delimiter'
            {
            match("path-delimiter"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "PathDelimiter"

    // $ANTLR start "Pos"
    public final void mPos() throws RecognitionException {
        try {
            int _type = Pos;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:121:6: ( 'pos' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:121:7: 'pos'
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

    // $ANTLR start "Translator"
    public final void mTranslator() throws RecognitionException {
        try {
            int _type = Translator;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:122:13: ( 'translator' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:122:14: 'translator'
            {
            match("translator"); 



            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Translator"

    // $ANTLR start "Unique"
    public final void mUnique() throws RecognitionException {
        try {
            int _type = Unique;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:123:9: ( 'unique' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:123:10: 'unique'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:124:10: ( 'virtual' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:124:11: 'virtual'
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

    // $ANTLR start "Semicolon"
    public final void mSemicolon() throws RecognitionException {
        try {
            int _type = Semicolon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:128:12: ( ';' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:128:13: ';'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:129:14: ( ']' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:129:15: ']'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:130:14: ( '[' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:130:15: '['
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:131:18: ( '(' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:131:19: '('
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:132:18: ( ')' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:132:19: ')'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:133:9: ( '=' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:133:10: '='
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:134:8: ( ',' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:134:9: ','
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:137:18: ( '\\\\\\\\' )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:137:19: '\\\\\\\\'
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

    // $ANTLR start "Bool"
    public final void mBool() throws RecognitionException {
        try {
            int _type = Bool;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:138:7: ( 'true' | 'false' )
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
                    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:138:8: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:138:17: 'false'
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

    // $ANTLR start "Macrodef"
    public final void mMacrodef() throws RecognitionException {
        try {
            int _type = Macrodef;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:141:2: ( '$' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:141:4: '$' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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


            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:141:40: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||LA2_0=='_'||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
                    alt2=1;
                }


                switch (alt2) {
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
    // $ANTLR end "Macrodef"

    // $ANTLR start "Identifier"
    public final void mIdentifier() throws RecognitionException {
        try {
            int _type = Identifier;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:145:2: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:145:4: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:145:36: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '0' && LA3_0 <= '9')||(LA3_0 >= 'A' && LA3_0 <= 'Z')||LA3_0=='_'||(LA3_0 >= 'a' && LA3_0 <= 'z')) ) {
                    alt3=1;
                }


                switch (alt3) {
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
            	    break loop3;
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:157:2: ( '#' ( options {greedy=false; } : . )* ( ( '\\r' )? '\\n' | '\\r' ) )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:157:4: '#' ( options {greedy=false; } : . )* ( ( '\\r' )? '\\n' | '\\r' )
            {
            match('#'); 

            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:157:7: ( options {greedy=false; } : . )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\r') ) {
                    alt4=2;
                }
                else if ( (LA4_0=='\n') ) {
                    alt4=2;
                }
                else if ( ((LA4_0 >= '\u0000' && LA4_0 <= '\t')||(LA4_0 >= '\u000B' && LA4_0 <= '\f')||(LA4_0 >= '\u000E' && LA4_0 <= '\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:157:33: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:157:37: ( ( '\\r' )? '\\n' | '\\r' )
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
                    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:157:38: ( '\\r' )? '\\n'
                    {
                    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:157:38: ( '\\r' )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0=='\r') ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:157:38: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    }
                    break;
                case 2 :
                    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:157:51: '\\r'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:162:2: ( ( '\\u000d' )? '\\u000a' | '\\u000d' )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='\r') ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1=='\n') ) {
                    alt8=1;
                }
                else {
                    alt8=2;
                }
            }
            else if ( (LA8_0=='\n') ) {
                alt8=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;

            }
            switch (alt8) {
                case 1 :
                    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:162:4: ( '\\u000d' )? '\\u000a'
                    {
                    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:162:4: ( '\\u000d' )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0=='\r') ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:162:4: '\\u000d'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    }
                    break;
                case 2 :
                    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:163:4: '\\u000d'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:168:2: ( '\\u0020' | '\\u0009' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==' ') ) {
                alt9=1;
            }
            else if ( (LA9_0=='\t') ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:168:4: '\\u0020'
                    {
                    match(' '); 

                    }
                    break;
                case 2 :
                    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:168:15: '\\u0009'
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
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:179:2: ( ( options {greedy=false; } :~ ( '\\n' | '\\r' ) )* ( ( '\\r' )? '\\n' | '\\r' ) )
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:179:4: ( options {greedy=false; } :~ ( '\\n' | '\\r' ) )* ( ( '\\r' )? '\\n' | '\\r' )
            {
            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:179:4: ( options {greedy=false; } :~ ( '\\n' | '\\r' ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0 >= '\u0000' && LA10_0 <= '\t')||(LA10_0 >= '\u000B' && LA10_0 <= '\f')||(LA10_0 >= '\u000E' && LA10_0 <= '\uFFFF')) ) {
                    alt10=1;
                }
                else if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                    alt10=2;
                }


                switch (alt10) {
            	case 1 :
            	    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:179:30: ~ ( '\\n' | '\\r' )
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
            	    break loop10;
                }
            } while (true);


            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:179:47: ( ( '\\r' )? '\\n' | '\\r' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='\r') ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1=='\n') ) {
                    alt12=1;
                }
                else {
                    alt12=2;
                }
            }
            else if ( (LA12_0=='\n') ) {
                alt12=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;

            }
            switch (alt12) {
                case 1 :
                    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:179:48: ( '\\r' )? '\\n'
                    {
                    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:179:48: ( '\\r' )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0=='\r') ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:179:48: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    }
                    break;
                case 2 :
                    // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:179:61: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

            }


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Text"

    public void mTokens() throws RecognitionException {
        // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:8: ( Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | Numberformat | PathDelimiter | Pos | Translator | Unique | Virtual | Semicolon | RightBracket | LeftBracket | LeftParenthesis | RightParenthesis | Equals | Comma | LineContinuation | Bool | Macrodef | Identifier | Comment | LineBreak | Ws )
        int alt13=40;
        alt13 = dfa13.predict(input);
        switch (alt13) {
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
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:92: CellDecorator
                {
                mCellDecorator(); 


                }
                break;
            case 11 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:106: CollectionDelimiter
                {
                mCollectionDelimiter(); 


                }
                break;
            case 12 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:126: Dateformat
                {
                mDateformat(); 


                }
                break;
            case 13 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:137: Default
                {
                mDefault(); 


                }
                break;
            case 14 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:145: ForceWrite
                {
                mForceWrite(); 


                }
                break;
            case 15 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:156: IgnoreKeyCase
                {
                mIgnoreKeyCase(); 


                }
                break;
            case 16 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:170: IgnoreNull
                {
                mIgnoreNull(); 


                }
                break;
            case 17 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:181: KeyToValueDelimiter
                {
                mKeyToValueDelimiter(); 


                }
                break;
            case 18 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:201: Lang
                {
                mLang(); 


                }
                break;
            case 19 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:206: MapDelimiter
                {
                mMapDelimiter(); 


                }
                break;
            case 20 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:219: Mode
                {
                mMode(); 


                }
                break;
            case 21 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:224: Numberformat
                {
                mNumberformat(); 


                }
                break;
            case 22 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:237: PathDelimiter
                {
                mPathDelimiter(); 


                }
                break;
            case 23 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:251: Pos
                {
                mPos(); 


                }
                break;
            case 24 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:255: Translator
                {
                mTranslator(); 


                }
                break;
            case 25 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:266: Unique
                {
                mUnique(); 


                }
                break;
            case 26 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:273: Virtual
                {
                mVirtual(); 


                }
                break;
            case 27 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:281: Semicolon
                {
                mSemicolon(); 


                }
                break;
            case 28 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:291: RightBracket
                {
                mRightBracket(); 


                }
                break;
            case 29 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:304: LeftBracket
                {
                mLeftBracket(); 


                }
                break;
            case 30 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:316: LeftParenthesis
                {
                mLeftParenthesis(); 


                }
                break;
            case 31 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:332: RightParenthesis
                {
                mRightParenthesis(); 


                }
                break;
            case 32 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:349: Equals
                {
                mEquals(); 


                }
                break;
            case 33 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:356: Comma
                {
                mComma(); 


                }
                break;
            case 34 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:362: LineContinuation
                {
                mLineContinuation(); 


                }
                break;
            case 35 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:379: Bool
                {
                mBool(); 


                }
                break;
            case 36 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:384: Macrodef
                {
                mMacrodef(); 


                }
                break;
            case 37 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:393: Identifier
                {
                mIdentifier(); 


                }
                break;
            case 38 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:404: Comment
                {
                mComment(); 


                }
                break;
            case 39 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:412: LineBreak
                {
                mLineBreak(); 


                }
                break;
            case 40 :
                // /home/wojtuch/projects/ehybris/ImpexAST/src/main/java/Impex.g:1:422: Ws
                {
                mWs(); 


                }
                break;

        }

    }


    protected DFA13 dfa13 = new DFA13(this);
    static final String DFA13_eotS =
        "\1\uffff\21\33\15\uffff\41\33\1\132\31\33\1\uffff\10\33\1\174\1"+
        "\uffff\1\175\2\33\1\u0080\12\33\1\uffff\1\u008b\4\33\1\u0080\2\33"+
        "\2\uffff\2\33\1\uffff\2\33\1\u0097\1\u0098\1\u0099\5\33\1\uffff"+
        "\10\33\1\u00a8\2\33\3\uffff\7\33\1\u00b2\6\33\1\uffff\1\u00b9\10"+
        "\33\1\uffff\6\33\1\uffff\1\33\1\u00c9\3\33\1\u00cd\1\u00ce\10\33"+
        "\1\uffff\3\33\2\uffff\1\u00da\1\u00db\1\33\1\u00dd\1\uffff\1\33"+
        "\1\u00df\1\33\1\u00e1\1\33\3\uffff\1\33\1\uffff\1\33\1\uffff\1\33"+
        "\1\uffff\2\33\1\u00e8\1\u00e9\1\u00ea\1\u00eb\4\uffff";
    static final String DFA13_eofS =
        "\u00ec\uffff";
    static final String DFA13_minS =
        "\1\11\1\116\1\120\1\105\3\141\1\154\2\141\1\147\1\145\2\141\1\165"+
        "\1\162\1\156\1\151\15\uffff\1\123\1\104\1\115\1\164\1\143\2\154"+
        "\1\157\1\164\1\163\1\151\1\164\1\146\1\162\1\154\1\156\1\171\1\156"+
        "\1\160\1\144\1\155\1\141\1\151\1\162\1\105\1\101\1\117\1\143\1\150"+
        "\2\154\1\143\1\150\1\60\1\141\1\157\1\145\1\141\1\143\1\163\1\157"+
        "\1\62\1\147\1\55\1\145\1\142\1\156\1\145\1\161\1\164\1\122\1\124"+
        "\1\126\1\150\1\145\1\104\2\145\1\55\1\uffff\1\163\1\167\1\146\1"+
        "\165\2\145\1\162\1\166\1\60\1\uffff\1\60\1\145\1\163\1\60\2\165"+
        "\1\124\2\105\1\155\1\125\1\145\1\143\1\163\1\uffff\1\60\1\156\1"+
        "\157\1\154\1\127\1\60\1\145\1\141\2\uffff\1\162\1\154\1\uffff\1"+
        "\145\1\141\3\60\1\157\1\156\1\143\1\164\1\163\1\uffff\1\165\1\162"+
        "\1\164\1\162\1\113\1\154\1\146\1\141\1\60\1\154\1\125\3\uffff\1"+
        "\144\1\151\1\157\1\151\1\157\1\154\1\155\1\60\1\151\1\145\2\165"+
        "\1\157\1\164\1\uffff\1\60\1\120\1\145\1\161\1\162\1\157\1\162\1"+
        "\154\1\141\1\uffff\1\164\1\171\1\154\1\145\1\162\1\157\1\uffff\1"+
        "\104\1\60\1\165\1\141\1\156\2\60\1\164\1\145\1\103\1\154\1\55\1"+
        "\155\1\162\1\101\1\uffff\1\145\1\164\1\55\2\uffff\2\60\1\141\1\60"+
        "\1\uffff\1\141\1\60\1\124\1\60\1\157\3\uffff\1\163\1\uffff\1\164"+
        "\1\uffff\1\105\1\uffff\1\162\1\145\4\60\4\uffff";
    static final String DFA13_maxS =
        "\1\172\1\116\1\120\1\105\1\141\1\157\1\162\1\154\1\145\1\157\1\147"+
        "\1\145\1\141\1\157\1\165\1\162\1\156\1\151\15\uffff\1\123\1\104"+
        "\1\115\1\164\1\143\2\154\1\157\1\164\1\163\1\154\1\164\1\146\1\162"+
        "\1\154\1\156\1\171\1\156\1\160\1\144\1\155\1\165\1\151\1\162\1\105"+
        "\1\101\1\117\1\143\1\150\2\154\1\143\1\150\1\172\1\141\1\157\1\145"+
        "\1\141\1\143\1\163\1\157\1\62\1\147\1\55\1\145\1\142\1\156\1\145"+
        "\1\161\1\164\1\122\1\124\1\126\1\150\1\145\1\104\2\145\1\55\1\uffff"+
        "\1\163\1\167\1\146\1\165\2\145\1\162\1\166\1\172\1\uffff\1\172\1"+
        "\145\1\163\1\172\2\165\1\124\2\105\1\155\1\125\1\145\1\143\1\163"+
        "\1\uffff\1\172\1\156\1\157\1\154\1\127\1\172\1\145\1\141\2\uffff"+
        "\1\162\1\154\1\uffff\1\145\1\141\3\172\1\157\1\156\1\143\1\164\1"+
        "\163\1\uffff\1\165\1\162\1\164\1\162\1\156\1\154\1\146\1\141\1\172"+
        "\1\154\1\125\3\uffff\1\144\1\151\1\157\1\151\1\157\1\154\1\155\1"+
        "\172\1\151\1\145\2\165\1\157\1\164\1\uffff\1\172\1\120\1\145\1\161"+
        "\1\162\1\157\1\162\1\154\1\141\1\uffff\1\164\1\171\1\154\1\145\1"+
        "\162\1\157\1\uffff\1\104\1\172\1\165\1\141\1\156\2\172\1\164\1\145"+
        "\1\103\1\154\1\55\1\155\1\162\1\101\1\uffff\1\145\1\164\1\55\2\uffff"+
        "\2\172\1\141\1\172\1\uffff\1\141\1\172\1\124\1\172\1\157\3\uffff"+
        "\1\163\1\uffff\1\164\1\uffff\1\105\1\uffff\1\162\1\145\4\172\4\uffff";
    static final String DFA13_acceptS =
        "\22\uffff\1\33\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\44\1\45\1\46"+
        "\1\47\1\50\73\uffff\1\27\11\uffff\1\23\16\uffff\1\26\10\uffff\1"+
        "\22\1\24\2\uffff\1\43\12\uffff\1\10\13\uffff\1\1\1\3\1\4\16\uffff"+
        "\1\31\11\uffff\1\15\6\uffff\1\32\17\uffff\1\5\3\uffff\1\7\1\11\4"+
        "\uffff\1\21\5\uffff\1\13\1\14\1\16\1\uffff\1\20\1\uffff\1\30\1\uffff"+
        "\1\6\6\uffff\1\25\1\2\1\12\1\17";
    static final String DFA13_specialS =
        "\u00ec\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\36\1\35\2\uffff\1\35\22\uffff\1\36\2\uffff\1\34\1\32\3\uffff"+
            "\1\25\1\26\2\uffff\1\30\16\uffff\1\22\1\uffff\1\27\3\uffff\10"+
            "\33\1\1\10\33\1\3\2\33\1\2\5\33\1\24\1\31\1\23\1\uffff\1\33"+
            "\1\uffff\1\7\1\4\1\5\1\10\1\33\1\11\2\33\1\12\1\33\1\13\1\14"+
            "\1\15\1\16\1\33\1\6\3\33\1\17\1\20\1\21\4\33",
            "\1\37",
            "\1\40",
            "\1\41",
            "\1\42",
            "\1\43\3\uffff\1\44\11\uffff\1\45",
            "\1\47\15\uffff\1\50\2\uffff\1\46",
            "\1\51",
            "\1\52\3\uffff\1\53",
            "\1\55\15\uffff\1\54",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\61\15\uffff\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
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
            "",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "\1\101\2\uffff\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\113",
            "\1\114",
            "\1\115\23\uffff\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\162",
            "\1\163",
            "",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\176",
            "\1\177",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\u0081",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\u0090",
            "\1\u0091",
            "",
            "",
            "\1\u0092",
            "\1\u0093",
            "",
            "\1\u0094",
            "\1\u0095",
            "\12\33\7\uffff\32\33\4\uffff\1\u0096\1\uffff\32\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "\1\u00a3\42\uffff\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\u00a9",
            "\1\u00aa",
            "",
            "",
            "",
            "\1\u00ab",
            "\1\u00ac",
            "\1\u00ad",
            "\1\u00ae",
            "\1\u00af",
            "\1\u00b0",
            "\1\u00b1",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "\1\u00b7",
            "\1\u00b8",
            "",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\u00ba",
            "\1\u00bb",
            "\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "\1\u00c0",
            "\1\u00c1",
            "",
            "\1\u00c2",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "",
            "\1\u00c8",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\u00ca",
            "\1\u00cb",
            "\1\u00cc",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\u00cf",
            "\1\u00d0",
            "\1\u00d1",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "",
            "",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\u00dc",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "",
            "\1\u00de",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\u00e0",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\1\u00e2",
            "",
            "",
            "",
            "\1\u00e3",
            "",
            "\1\u00e4",
            "",
            "\1\u00e5",
            "",
            "\1\u00e6",
            "\1\u00e7",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "\12\33\7\uffff\32\33\4\uffff\1\33\1\uffff\32\33",
            "",
            "",
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
            return "1:1: Tokens : ( Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | Numberformat | PathDelimiter | Pos | Translator | Unique | Virtual | Semicolon | RightBracket | LeftBracket | LeftParenthesis | RightParenthesis | Equals | Comma | LineContinuation | Bool | Macrodef | Identifier | Comment | LineBreak | Ws );";
        }
    }
 

}