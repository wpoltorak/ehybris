// $ANTLR 3.4 /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g 2012-11-03 21:17:18

 package output;  


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class ImpexLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int ASSIGNEMENT=4;
    public static final int ASSIGNEMENTS=5;
    public static final int ATTRIBUTE=6;
    public static final int ATTRIBUTES=7;
    public static final int Alias=8;
    public static final int AllowNull=9;
    public static final int BLOCK=10;
    public static final int BLOCKS=11;
    public static final int BatchMode=12;
    public static final int Bool=13;
    public static final int CacheUnique=14;
    public static final int CellDecorator=15;
    public static final int Char=16;
    public static final int Classname=17;
    public static final int CollectionDelimiter=18;
    public static final int Comment=19;
    public static final int Dateformat=20;
    public static final int Default=21;
    public static final int DoubleQuote=22;
    public static final int Equals=23;
    public static final int FIELDS=24;
    public static final int Field=25;
    public static final int ForceWrite=26;
    public static final int HEADER=27;
    public static final int IMPEX=28;
    public static final int Identifier=29;
    public static final int IgnoreKeyCase=30;
    public static final int IgnoreNull=31;
    public static final int Insert=32;
    public static final int InsertUpdate=33;
    public static final int KeyToValueDelimiter=34;
    public static final int Lang=35;
    public static final int Lb=36;
    public static final int LeftBracket=37;
    public static final int LeftParenthesis=38;
    public static final int LineContinuation=39;
    public static final int MODIFIER=40;
    public static final int MODIFIERS=41;
    public static final int Macrodef=42;
    public static final int Macroval=43;
    public static final int MapDelimiter=44;
    public static final int Mode=45;
    public static final int NumberFormat=46;
    public static final int PathDelimiter=47;
    public static final int Pos=48;
    public static final int Processor=49;
    public static final int QuotedField=50;
    public static final int RECORD=51;
    public static final int RECORDS=52;
    public static final int Remove=53;
    public static final int RightBracket=54;
    public static final int RightParenthesis=55;
    public static final int SUBTYPE=56;
    public static final int Semicolon=57;
    public static final int TYPE=58;
    public static final int Translator=59;
    public static final int Unique=60;
    public static final int Update=61;
    public static final int Virtual=62;
    public static final int Ws=63;



    public class TokenList {

        private final ArrayList<Token> array;
        private final int capacity;

        public TokenList(final int capacity) {
            this.capacity = capacity;
            array = new ArrayList<Token>(capacity + 1);
        }

        public void add(final Token token) {
            if (array.size() == capacity) {
                array.remove(0);
            }
            array.add(token);
        }

        public Token get(final int num) {
            if (num > capacity - 1) {
                throw new IllegalArgumentException("Greater than list size");
            }

            return array.get(capacity - 1 - num);
        }

    }
    private final TokenList tokens = new TokenList(1);
    private boolean isHeader = false;

    public void emit(Token token) {
        if(token.getChannel() == Token.DEFAULT_CHANNEL) {
            tokens.add(token);
        }
        int t = token.getType();
        if (t == Insert || t == InsertUpdate || t  == Update || t ==Remove){
         isHeader = true;	
        }
        
         
         if (t == Lb){
         isHeader = false;	
        }
        super.emit(token);
    }

    private boolean isMacroAssignement() {
            final Token macrodef = getToken(0);
            return macrodef != null && macrodef.getType() == Macrodef;
    //            return input.LA(-1) == Macrodef;
    }

    private boolean isHeader(){

     return isHeader;
    }
    private Token getToken(int num) {
        return tokens.get(num);
    }


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

    // $ANTLR start "T__64"
    public final void mT__64() throws RecognitionException {
        try {
            int _type = T__64;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:73:7: ( ',' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:73:9: ','
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
    // $ANTLR end "T__64"

    // $ANTLR start "T__65"
    public final void mT__65() throws RecognitionException {
        try {
            int _type = T__65;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:74:7: ( '.' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:74:9: '.'
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
    // $ANTLR end "T__65"

    // $ANTLR start "Insert"
    public final void mInsert() throws RecognitionException {
        try {
            int _type = Insert;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:167:4: ( 'INSERT' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:167:5: 'INSERT'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:168:15: ( 'INSERT_UPDATE' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:168:16: 'INSERT_UPDATE'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:169:9: ( 'UPDATE' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:169:10: 'UPDATE'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:170:9: ( 'REMOVE' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:170:10: 'REMOVE'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:177:12: ( 'batchmode' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:177:13: 'batchmode'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:178:14: ( 'cacheUnique' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:178:15: 'cacheUnique'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:179:12: ( 'processor' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:179:13: 'processor'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:181:8: ( 'alias' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:181:9: 'alias'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:182:12: ( 'allownull' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:182:13: 'allownull'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:183:15: ( 'cellDecorator' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:183:16: 'cellDecorator'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:184:22: ( 'collection-delimiter' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:184:23: 'collection-delimiter'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:185:13: ( 'dateformat' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:185:14: 'dateformat'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:186:10: ( 'default' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:186:11: 'default'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:187:13: ( 'forceWrite' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:187:14: 'forceWrite'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:188:15: ( 'ignoreKeyCase' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:188:16: 'ignoreKeyCase'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:189:13: ( 'ignorenull' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:189:14: 'ignorenull'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:190:21: ( 'key2value-delimiter' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:190:22: 'key2value-delimiter'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:191:7: ( 'lang' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:191:8: 'lang'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:192:14: ( 'map-delimiter' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:192:15: 'map-delimiter'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:193:7: ( 'mode' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:193:8: 'mode'
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

    // $ANTLR start "NumberFormat"
    public final void mNumberFormat() throws RecognitionException {
        try {
            int _type = NumberFormat;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:194:14: ( 'numberformat' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:194:15: 'numberformat'
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
    // $ANTLR end "NumberFormat"

    // $ANTLR start "PathDelimiter"
    public final void mPathDelimiter() throws RecognitionException {
        try {
            int _type = PathDelimiter;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:195:15: ( 'path-delimiter' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:195:16: 'path-delimiter'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:196:6: ( 'pos' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:196:7: 'pos'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:197:13: ( 'translator' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:197:14: 'translator'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:198:9: ( 'unique' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:198:10: 'unique'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:199:10: ( 'virtual' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:199:11: 'virtual'
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

    // $ANTLR start "DoubleQuote"
    public final void mDoubleQuote() throws RecognitionException {
        try {
            int _type = DoubleQuote;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:201:14: ( '\"' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:201:15: '\"'
            {
            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "DoubleQuote"

    // $ANTLR start "Semicolon"
    public final void mSemicolon() throws RecognitionException {
        try {
            int _type = Semicolon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:202:12: ( ';' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:202:13: ';'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:203:15: ( ']' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:203:16: ']'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:204:14: ( '[' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:204:15: '['
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:18: ( '(' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:19: '('
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:206:18: ( ')' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:206:19: ')'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:207:9: ( '=' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:207:10: '='
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

    // $ANTLR start "LineContinuation"
    public final void mLineContinuation() throws RecognitionException {
        try {
            int _type = LineContinuation;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:209:18: ( '\\\\\\\\' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:209:19: '\\\\\\\\'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:210:7: ( 'true' | 'false' )
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
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:210:8: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:210:17: 'false'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:213:2: ( '$' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:213:3: '$' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:213:39: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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
    // $ANTLR end "Macrodef"

    // $ANTLR start "Macroval"
    public final void mMacroval() throws RecognitionException {
        try {
            int _type = Macroval;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:218:2: ({...}? => '=' (~ ( '\\r' | '\\n' ) )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:218:3: {...}? => '=' (~ ( '\\r' | '\\n' ) )*
            {
            if ( !((isMacroAssignement())) ) {
                throw new FailedPredicateException(input, "Macroval", "isMacroAssignement()");
            }

            match('='); 

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:218:32: (~ ( '\\r' | '\\n' ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '\f')||(LA3_0 >= '\u000E' && LA3_0 <= '\uFFFF')) ) {
                    alt3=1;
                }


                switch (alt3) {
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
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
            setText(getText().substring(1, getText().length()).trim());
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Macroval"

    // $ANTLR start "Identifier"
    public final void mIdentifier() throws RecognitionException {
        try {
            int _type = Identifier;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:221:2: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:221:3: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:221:35: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0 >= '0' && LA4_0 <= '9')||(LA4_0 >= 'A' && LA4_0 <= 'Z')||LA4_0=='_'||(LA4_0 >= 'a' && LA4_0 <= 'z')) ) {
                    alt4=1;
                }


                switch (alt4) {
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
    // $ANTLR end "Identifier"

    // $ANTLR start "Classname"
    public final void mClassname() throws RecognitionException {
        try {
            int _type = Classname;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:224:2: ( ( ( 'a' .. 'z' )+ '.' )+ 'A' .. 'Z' ( 'A' .. 'Z' | 'a' .. 'z' )+ )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:224:3: ( ( 'a' .. 'z' )+ '.' )+ 'A' .. 'Z' ( 'A' .. 'Z' | 'a' .. 'z' )+
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:224:3: ( ( 'a' .. 'z' )+ '.' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:224:4: ( 'a' .. 'z' )+ '.'
            	    {
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:224:4: ( 'a' .. 'z' )+
            	    int cnt5=0;
            	    loop5:
            	    do {
            	        int alt5=2;
            	        int LA5_0 = input.LA(1);

            	        if ( ((LA5_0 >= 'a' && LA5_0 <= 'z')) ) {
            	            alt5=1;
            	        }


            	        switch (alt5) {
            	    	case 1 :
            	    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            	    	    {
            	    	    if ( (input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
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


            	    match('.'); 

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


            matchRange('A','Z'); 

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:224:35: ( 'A' .. 'Z' | 'a' .. 'z' )+
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
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
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
    // $ANTLR end "Classname"

    // $ANTLR start "Comment"
    public final void mComment() throws RecognitionException {
        try {
            int _type = Comment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:228:2: ( '#' (~ ( '\\r' | '\\n' ) )* ( Lb )? )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:228:3: '#' (~ ( '\\r' | '\\n' ) )* ( Lb )?
            {
            match('#'); 

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:228:7: (~ ( '\\r' | '\\n' ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= '\u0000' && LA8_0 <= '\t')||(LA8_0 >= '\u000B' && LA8_0 <= '\f')||(LA8_0 >= '\u000E' && LA8_0 <= '\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
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
            	    break loop8;
                }
            } while (true);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:228:23: ( Lb )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\n'||LA9_0=='\r') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:228:23: Lb
                    {
                    mLb(); 


                    }
                    break;

            }


            _channel=HIDDEN;

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

    // $ANTLR start "QuotedField"
    public final void mQuotedField() throws RecognitionException {
        try {
            int _type = QuotedField;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:232:2: ( ';' '\"' ( Char | '\"' '\"' | ';' )* '\"' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:232:3: ';' '\"' ( Char | '\"' '\"' | ';' )* '\"'
            {
            match(';'); 

            match('\"'); 

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:232:11: ( Char | '\"' '\"' | ';' )*
            loop10:
            do {
                int alt10=4;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='\"') ) {
                    int LA10_1 = input.LA(2);

                    if ( (LA10_1=='\"') ) {
                        alt10=2;
                    }


                }
                else if ( ((LA10_0 >= '\u0000' && LA10_0 <= '\t')||(LA10_0 >= '\u000B' && LA10_0 <= '\f')||(LA10_0 >= '\u000E' && LA10_0 <= '!')||(LA10_0 >= '#' && LA10_0 <= ':')||(LA10_0 >= '<' && LA10_0 <= '\uFFFF')) ) {
                    alt10=1;
                }
                else if ( (LA10_0==';') ) {
                    alt10=3;
                }


                switch (alt10) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:232:12: Char
            	    {
            	    mChar(); 


            	    }
            	    break;
            	case 2 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:232:19: '\"' '\"'
            	    {
            	    match('\"'); 

            	    match('\"'); 

            	    }
            	    break;
            	case 3 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:232:29: ';'
            	    {
            	    match(';'); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
             setText(getText().substring(1, getText().length())); 
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "QuotedField"

    // $ANTLR start "Field"
    public final void mField() throws RecognitionException {
        try {
            int _type = Field;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:236:2: ({...}? => ';' ( Char )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:236:3: {...}? => ';' ( Char )*
            {
            if ( !((isHeader() == false)) ) {
                throw new FailedPredicateException(input, "Field", "isHeader() == false");
            }

            match(';'); 

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:236:32: ( Char )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0 >= '\u0000' && LA11_0 <= '\t')||(LA11_0 >= '\u000B' && LA11_0 <= '\f')||(LA11_0 >= '\u000E' && LA11_0 <= '!')||(LA11_0 >= '#' && LA11_0 <= ':')||(LA11_0 >= '<' && LA11_0 <= '\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= ':')||(input.LA(1) >= '<' && input.LA(1) <= '\uFFFF') ) {
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


            }

            state.type = _type;
            state.channel = _channel;
             setText(getText().substring(1, getText().length())); 
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Field"

    // $ANTLR start "Ws"
    public final void mWs() throws RecognitionException {
        try {
            int _type = Ws;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:255:4: ( ( ' ' | '\\t' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:255:5: ( ' ' | '\\t' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Ws"

    // $ANTLR start "Lb"
    public final void mLb() throws RecognitionException {
        try {
            int _type = Lb;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:256:4: ( ( ( '\\r' )? '\\n' | '\\r' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:256:5: ( ( '\\r' )? '\\n' | '\\r' )
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:256:5: ( ( '\\r' )? '\\n' | '\\r' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0=='\r') ) {
                int LA13_1 = input.LA(2);

                if ( (LA13_1=='\n') ) {
                    alt13=1;
                }
                else {
                    alt13=2;
                }
            }
            else if ( (LA13_0=='\n') ) {
                alt13=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }
            switch (alt13) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:256:6: ( '\\r' )? '\\n'
                    {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:256:6: ( '\\r' )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0=='\r') ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:256:6: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:256:19: '\\r'
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
    // $ANTLR end "Lb"

    // $ANTLR start "Char"
    public final void mChar() throws RecognitionException {
        try {
            int _type = Char;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:257:6: (~ ( '\\r' | '\\n' | '\"' | ';' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            {
            if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= ':')||(input.LA(1) >= '<' && input.LA(1) <= '\uFFFF') ) {
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

    public void mTokens() throws RecognitionException {
        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:8: ( T__64 | T__65 | Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual | DoubleQuote | Semicolon | RightBracket | LeftBracket | LeftParenthesis | RightParenthesis | Equals | LineContinuation | Bool | Macrodef | Macroval | Identifier | Classname | Comment | QuotedField | Field | Ws | Lb | Char )
        int alt14=47;
        alt14 = dfa14.predict(input);
        switch (alt14) {
            case 1 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:10: T__64
                {
                mT__64(); 


                }
                break;
            case 2 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:16: T__65
                {
                mT__65(); 


                }
                break;
            case 3 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:22: Insert
                {
                mInsert(); 


                }
                break;
            case 4 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:29: InsertUpdate
                {
                mInsertUpdate(); 


                }
                break;
            case 5 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:42: Update
                {
                mUpdate(); 


                }
                break;
            case 6 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:49: Remove
                {
                mRemove(); 


                }
                break;
            case 7 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:56: BatchMode
                {
                mBatchMode(); 


                }
                break;
            case 8 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:66: CacheUnique
                {
                mCacheUnique(); 


                }
                break;
            case 9 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:78: Processor
                {
                mProcessor(); 


                }
                break;
            case 10 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:88: Alias
                {
                mAlias(); 


                }
                break;
            case 11 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:94: AllowNull
                {
                mAllowNull(); 


                }
                break;
            case 12 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:104: CellDecorator
                {
                mCellDecorator(); 


                }
                break;
            case 13 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:118: CollectionDelimiter
                {
                mCollectionDelimiter(); 


                }
                break;
            case 14 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:138: Dateformat
                {
                mDateformat(); 


                }
                break;
            case 15 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:149: Default
                {
                mDefault(); 


                }
                break;
            case 16 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:157: ForceWrite
                {
                mForceWrite(); 


                }
                break;
            case 17 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:168: IgnoreKeyCase
                {
                mIgnoreKeyCase(); 


                }
                break;
            case 18 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:182: IgnoreNull
                {
                mIgnoreNull(); 


                }
                break;
            case 19 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:193: KeyToValueDelimiter
                {
                mKeyToValueDelimiter(); 


                }
                break;
            case 20 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:213: Lang
                {
                mLang(); 


                }
                break;
            case 21 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:218: MapDelimiter
                {
                mMapDelimiter(); 


                }
                break;
            case 22 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:231: Mode
                {
                mMode(); 


                }
                break;
            case 23 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:236: NumberFormat
                {
                mNumberFormat(); 


                }
                break;
            case 24 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:249: PathDelimiter
                {
                mPathDelimiter(); 


                }
                break;
            case 25 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:263: Pos
                {
                mPos(); 


                }
                break;
            case 26 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:267: Translator
                {
                mTranslator(); 


                }
                break;
            case 27 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:278: Unique
                {
                mUnique(); 


                }
                break;
            case 28 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:285: Virtual
                {
                mVirtual(); 


                }
                break;
            case 29 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:293: DoubleQuote
                {
                mDoubleQuote(); 


                }
                break;
            case 30 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:305: Semicolon
                {
                mSemicolon(); 


                }
                break;
            case 31 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:315: RightBracket
                {
                mRightBracket(); 


                }
                break;
            case 32 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:328: LeftBracket
                {
                mLeftBracket(); 


                }
                break;
            case 33 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:340: LeftParenthesis
                {
                mLeftParenthesis(); 


                }
                break;
            case 34 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:356: RightParenthesis
                {
                mRightParenthesis(); 


                }
                break;
            case 35 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:373: Equals
                {
                mEquals(); 


                }
                break;
            case 36 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:380: LineContinuation
                {
                mLineContinuation(); 


                }
                break;
            case 37 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:397: Bool
                {
                mBool(); 


                }
                break;
            case 38 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:402: Macrodef
                {
                mMacrodef(); 


                }
                break;
            case 39 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:411: Macroval
                {
                mMacroval(); 


                }
                break;
            case 40 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:420: Identifier
                {
                mIdentifier(); 


                }
                break;
            case 41 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:431: Classname
                {
                mClassname(); 


                }
                break;
            case 42 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:441: Comment
                {
                mComment(); 


                }
                break;
            case 43 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:449: QuotedField
                {
                mQuotedField(); 


                }
                break;
            case 44 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:461: Field
                {
                mField(); 


                }
                break;
            case 45 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:467: Ws
                {
                mWs(); 


                }
                break;
            case 46 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:470: Lb
                {
                mLb(); 


                }
                break;
            case 47 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:473: Char
                {
                mChar(); 


                }
                break;

        }

    }


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\3\uffff\21\46\1\uffff\1\101\4\uffff\1\107\2\42\1\46\7\uffff\1\46"+
        "\1\uffff\4\46\1\uffff\24\46\15\uffff\11\46\1\161\20\46\1\uffff\11"+
        "\46\1\uffff\10\46\1\u0093\1\uffff\1\u0094\2\46\1\u0097\12\46\1\uffff"+
        "\1\u00a2\4\46\1\u0097\2\46\2\uffff\2\46\1\uffff\2\46\1\u00ae\1\u00af"+
        "\1\u00b0\5\46\1\uffff\10\46\1\u00bf\2\46\3\uffff\7\46\1\u00c9\6"+
        "\46\1\uffff\1\u00d0\10\46\1\uffff\6\46\1\uffff\1\46\1\u00e0\3\46"+
        "\1\u00e4\1\u00e5\10\46\1\uffff\3\46\2\uffff\1\u00f1\1\u00f2\1\46"+
        "\1\u00f4\1\uffff\1\46\1\u00f6\1\46\1\u00f8\1\46\3\uffff\1\46\1\uffff"+
        "\1\46\1\uffff\1\46\1\uffff\2\46\1\u00ff\1\u0100\1\u0101\1\u0102"+
        "\4\uffff";
    static final String DFA14_eofS =
        "\u0103\uffff";
    static final String DFA14_minS =
        "\1\0\2\uffff\1\116\1\120\1\105\16\56\1\uffff\1\0\4\uffff\1\0\1\134"+
        "\1\101\1\56\7\uffff\1\123\1\uffff\1\104\1\115\2\56\1\uffff\24\56"+
        "\1\uffff\1\0\13\uffff\1\105\1\101\1\117\20\56\1\55\6\56\1\uffff"+
        "\1\122\1\124\1\126\5\56\1\55\1\uffff\7\56\1\166\1\56\1\uffff\6\56"+
        "\1\124\2\105\2\56\1\145\2\56\1\uffff\7\56\1\141\2\uffff\2\56\1\uffff"+
        "\2\56\3\60\1\56\1\156\1\143\2\56\1\uffff\3\56\1\162\1\56\1\154\4"+
        "\56\1\125\3\uffff\1\56\1\151\1\157\5\56\1\151\1\145\1\56\1\165\2"+
        "\56\1\uffff\1\56\1\120\1\56\1\161\1\162\4\56\1\uffff\1\164\1\171"+
        "\1\56\1\145\2\56\1\uffff\1\104\1\56\1\165\1\141\4\56\1\145\1\103"+
        "\1\56\1\55\2\56\1\101\1\uffff\1\145\1\164\1\55\2\uffff\1\56\1\60"+
        "\1\141\1\56\1\uffff\2\56\1\124\1\60\1\157\3\uffff\1\163\1\uffff"+
        "\1\56\1\uffff\1\105\1\uffff\1\162\1\145\1\56\3\60\4\uffff";
    static final String DFA14_maxS =
        "\1\uffff\2\uffff\1\116\1\120\1\105\16\172\1\uffff\1\uffff\4\uffff"+
        "\1\uffff\1\134\2\172\7\uffff\1\123\1\uffff\1\104\1\115\2\172\1\uffff"+
        "\24\172\1\uffff\1\0\13\uffff\1\105\1\101\1\117\27\172\1\uffff\1"+
        "\122\1\124\1\126\6\172\1\uffff\7\172\1\166\1\172\1\uffff\6\172\1"+
        "\124\2\105\2\172\1\145\2\172\1\uffff\7\172\1\141\2\uffff\2\172\1"+
        "\uffff\6\172\1\156\1\143\2\172\1\uffff\3\172\1\162\1\172\1\154\4"+
        "\172\1\125\3\uffff\1\172\1\151\1\157\5\172\1\151\1\145\1\172\1\165"+
        "\2\172\1\uffff\1\172\1\120\1\172\1\161\1\162\4\172\1\uffff\1\164"+
        "\1\171\1\172\1\145\2\172\1\uffff\1\104\1\172\1\165\1\141\4\172\1"+
        "\145\1\103\1\172\1\55\2\172\1\101\1\uffff\1\145\1\164\1\172\2\uffff"+
        "\2\172\1\141\1\172\1\uffff\2\172\1\124\1\172\1\157\3\uffff\1\163"+
        "\1\uffff\1\172\1\uffff\1\105\1\uffff\1\162\1\145\4\172\4\uffff";
    static final String DFA14_acceptS =
        "\1\uffff\1\1\1\2\21\uffff\1\35\1\uffff\1\37\1\40\1\41\1\42\4\uffff"+
        "\1\50\1\52\1\55\1\56\1\57\1\1\1\2\1\uffff\1\50\4\uffff\1\51\24\uffff"+
        "\1\53\1\uffff\1\54\1\37\1\40\1\41\1\42\1\43\1\47\1\44\1\46\1\52"+
        "\1\55\32\uffff\1\36\11\uffff\1\31\11\uffff\1\25\16\uffff\1\30\10"+
        "\uffff\1\24\1\26\2\uffff\1\45\12\uffff\1\12\13\uffff\1\3\1\5\1\6"+
        "\16\uffff\1\33\11\uffff\1\17\6\uffff\1\34\17\uffff\1\7\3\uffff\1"+
        "\11\1\13\4\uffff\1\23\5\uffff\1\15\1\16\1\20\1\uffff\1\22\1\uffff"+
        "\1\32\1\uffff\1\10\6\uffff\1\27\1\4\1\14\1\21";
    static final String DFA14_specialS =
        "\1\2\24\uffff\1\3\4\uffff\1\1\46\uffff\1\0\u00c1\uffff}>";
    static final String[] DFA14_transitionS = {
            "\11\42\1\40\1\41\2\42\1\41\22\42\1\40\1\42\1\24\1\37\1\34\3"+
            "\42\1\30\1\31\2\42\1\1\1\42\1\2\14\42\1\25\1\42\1\32\3\42\10"+
            "\36\1\3\10\36\1\5\2\36\1\4\5\36\1\27\1\33\1\26\1\42\1\36\1\42"+
            "\1\11\1\6\1\7\1\12\1\35\1\13\2\35\1\14\1\35\1\15\1\16\1\17\1"+
            "\20\1\35\1\10\3\35\1\21\1\22\1\23\4\35\uff85\42",
            "",
            "",
            "\1\45",
            "\1\47",
            "\1\50",
            "\1\53\62\uffff\1\51\31\52",
            "\1\53\62\uffff\1\54\3\52\1\55\11\52\1\56\13\52",
            "\1\53\62\uffff\1\60\15\52\1\61\2\52\1\57\10\52",
            "\1\53\62\uffff\13\52\1\62\16\52",
            "\1\53\62\uffff\1\63\3\52\1\64\25\52",
            "\1\53\62\uffff\1\66\15\52\1\65\13\52",
            "\1\53\62\uffff\6\52\1\67\23\52",
            "\1\53\62\uffff\4\52\1\70\25\52",
            "\1\53\62\uffff\1\71\31\52",
            "\1\53\62\uffff\1\72\15\52\1\73\13\52",
            "\1\53\62\uffff\24\52\1\74\5\52",
            "\1\53\62\uffff\21\52\1\75\10\52",
            "\1\53\62\uffff\15\52\1\76\14\52",
            "\1\53\62\uffff\10\52\1\77\21\52",
            "",
            "\12\102\1\uffff\2\102\1\uffff\24\102\1\100\30\102\1\uffff\uffc4"+
            "\102",
            "",
            "",
            "",
            "",
            "\12\110\1\uffff\2\110\1\uffff\ufff2\110",
            "\1\111",
            "\32\112\4\uffff\1\112\1\uffff\32\112",
            "\1\53\62\uffff\32\52",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\115",
            "",
            "\1\116",
            "\1\117",
            "\1\53\62\uffff\23\52\1\120\6\52",
            "\1\53\62\uffff\32\52",
            "",
            "\1\53\62\uffff\2\52\1\121\27\52",
            "\1\53\62\uffff\13\52\1\122\16\52",
            "\1\53\62\uffff\13\52\1\123\16\52",
            "\1\53\62\uffff\16\52\1\124\13\52",
            "\1\53\62\uffff\23\52\1\125\6\52",
            "\1\53\62\uffff\22\52\1\126\7\52",
            "\1\53\62\uffff\10\52\1\127\2\52\1\130\16\52",
            "\1\53\62\uffff\23\52\1\131\6\52",
            "\1\53\62\uffff\5\52\1\132\24\52",
            "\1\53\62\uffff\21\52\1\133\10\52",
            "\1\53\62\uffff\13\52\1\134\16\52",
            "\1\53\62\uffff\15\52\1\135\14\52",
            "\1\53\62\uffff\30\52\1\136\1\52",
            "\1\53\62\uffff\15\52\1\137\14\52",
            "\1\53\62\uffff\17\52\1\140\12\52",
            "\1\53\62\uffff\3\52\1\141\26\52",
            "\1\53\62\uffff\14\52\1\142\15\52",
            "\1\53\62\uffff\1\143\23\52\1\144\5\52",
            "\1\53\62\uffff\10\52\1\145\21\52",
            "\1\53\62\uffff\21\52\1\146\10\52",
            "",
            "\1\uffff",
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
            "\1\150",
            "\1\151",
            "\1\152",
            "\1\53\62\uffff\2\52\1\153\27\52",
            "\1\53\62\uffff\7\52\1\154\22\52",
            "\1\53\62\uffff\13\52\1\155\16\52",
            "\1\53\62\uffff\13\52\1\156\16\52",
            "\1\53\62\uffff\2\52\1\157\27\52",
            "\1\53\62\uffff\7\52\1\160\22\52",
            "\1\53\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\52",
            "\1\53\62\uffff\1\162\31\52",
            "\1\53\62\uffff\16\52\1\163\13\52",
            "\1\53\62\uffff\4\52\1\164\25\52",
            "\1\53\62\uffff\1\165\31\52",
            "\1\53\62\uffff\2\52\1\166\27\52",
            "\1\53\62\uffff\22\52\1\167\7\52",
            "\1\53\62\uffff\16\52\1\170\13\52",
            "\1\53\3\uffff\1\171\56\uffff\32\52",
            "\1\53\62\uffff\6\52\1\172\23\52",
            "\1\173\1\53\62\uffff\32\52",
            "\1\53\62\uffff\4\52\1\174\25\52",
            "\1\53\62\uffff\1\52\1\175\30\52",
            "\1\53\62\uffff\15\52\1\176\14\52",
            "\1\53\62\uffff\4\52\1\177\25\52",
            "\1\53\62\uffff\20\52\1\u0080\11\52",
            "\1\53\62\uffff\23\52\1\u0081\6\52",
            "",
            "\1\u0082",
            "\1\u0083",
            "\1\u0084",
            "\1\53\62\uffff\7\52\1\u0085\22\52",
            "\1\53\62\uffff\4\52\1\u0086\25\52",
            "\1\53\25\uffff\1\u0087\34\uffff\32\52",
            "\1\53\62\uffff\4\52\1\u0088\25\52",
            "\1\53\62\uffff\4\52\1\u0089\25\52",
            "\1\u008a\1\53\62\uffff\32\52",
            "",
            "\1\53\62\uffff\22\52\1\u008b\7\52",
            "\1\53\62\uffff\26\52\1\u008c\3\52",
            "\1\53\62\uffff\5\52\1\u008d\24\52",
            "\1\53\62\uffff\24\52\1\u008e\5\52",
            "\1\53\62\uffff\4\52\1\u008f\25\52",
            "\1\53\62\uffff\4\52\1\u0090\25\52",
            "\1\53\62\uffff\21\52\1\u0091\10\52",
            "\1\u0092",
            "\1\53\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\52",
            "",
            "\1\53\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\52",
            "\1\53\62\uffff\4\52\1\u0095\25\52",
            "\1\53\62\uffff\22\52\1\u0096\7\52",
            "\1\53\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\52",
            "\1\53\62\uffff\24\52\1\u0098\5\52",
            "\1\53\62\uffff\24\52\1\u0099\5\52",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\53\62\uffff\14\52\1\u009d\15\52",
            "\1\53\46\uffff\1\u009e\13\uffff\32\52",
            "\1\u009f",
            "\1\53\62\uffff\2\52\1\u00a0\27\52",
            "\1\53\62\uffff\22\52\1\u00a1\7\52",
            "",
            "\1\53\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\52",
            "\1\53\62\uffff\15\52\1\u00a3\14\52",
            "\1\53\62\uffff\16\52\1\u00a4\13\52",
            "\1\53\62\uffff\13\52\1\u00a5\16\52",
            "\1\53\50\uffff\1\u00a6\11\uffff\32\52",
            "\1\53\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\52",
            "\1\53\62\uffff\4\52\1\u00a7\25\52",
            "\1\u00a8",
            "",
            "",
            "\1\53\62\uffff\21\52\1\u00a9\10\52",
            "\1\53\62\uffff\13\52\1\u00aa\16\52",
            "",
            "\1\53\62\uffff\4\52\1\u00ab\25\52",
            "\1\53\62\uffff\1\u00ac\31\52",
            "\12\46\7\uffff\32\46\4\uffff\1\u00ad\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\53\62\uffff\16\52\1\u00b1\13\52",
            "\1\u00b2",
            "\1\u00b3",
            "\1\53\62\uffff\23\52\1\u00b4\6\52",
            "\1\53\62\uffff\22\52\1\u00b5\7\52",
            "",
            "\1\53\62\uffff\24\52\1\u00b6\5\52",
            "\1\53\62\uffff\21\52\1\u00b7\10\52",
            "\1\53\62\uffff\23\52\1\u00b8\6\52",
            "\1\u00b9",
            "\1\53\34\uffff\1\u00ba\25\uffff\15\52\1\u00bb\14\52",
            "\1\u00bc",
            "\1\53\62\uffff\5\52\1\u00bd\24\52",
            "\1\53\62\uffff\1\u00be\31\52",
            "\1\53\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\52",
            "\1\53\62\uffff\13\52\1\u00c0\16\52",
            "\1\u00c1",
            "",
            "",
            "",
            "\1\53\62\uffff\3\52\1\u00c2\26\52",
            "\1\u00c3",
            "\1\u00c4",
            "\1\53\62\uffff\10\52\1\u00c5\21\52",
            "\1\53\62\uffff\16\52\1\u00c6\13\52",
            "\1\53\62\uffff\13\52\1\u00c7\16\52",
            "\1\53\62\uffff\14\52\1\u00c8\15\52",
            "\1\53\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\52",
            "\1\u00ca",
            "\1\u00cb",
            "\1\53\62\uffff\24\52\1\u00cc\5\52",
            "\1\u00cd",
            "\1\53\62\uffff\16\52\1\u00ce\13\52",
            "\1\53\62\uffff\23\52\1\u00cf\6\52",
            "",
            "\1\53\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\52",
            "\1\u00d1",
            "\1\53\62\uffff\4\52\1\u00d2\25\52",
            "\1\u00d3",
            "\1\u00d4",
            "\1\53\62\uffff\16\52\1\u00d5\13\52",
            "\1\53\62\uffff\21\52\1\u00d6\10\52",
            "\1\53\62\uffff\13\52\1\u00d7\16\52",
            "\1\53\62\uffff\1\u00d8\31\52",
            "",
            "\1\u00d9",
            "\1\u00da",
            "\1\53\62\uffff\13\52\1\u00db\16\52",
            "\1\u00dc",
            "\1\53\62\uffff\21\52\1\u00dd\10\52",
            "\1\53\62\uffff\16\52\1\u00de\13\52",
            "",
            "\1\u00df",
            "\1\53\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\52",
            "\1\u00e1",
            "\1\u00e2",
            "\1\53\62\uffff\15\52\1\u00e3\14\52",
            "\1\53\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\52",
            "\1\53\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\52",
            "\1\53\62\uffff\23\52\1\u00e6\6\52",
            "\1\u00e7",
            "\1\u00e8",
            "\1\53\62\uffff\13\52\1\u00e9\16\52",
            "\1\u00ea",
            "\1\53\62\uffff\14\52\1\u00eb\15\52",
            "\1\53\62\uffff\21\52\1\u00ec\10\52",
            "\1\u00ed",
            "",
            "\1\u00ee",
            "\1\u00ef",
            "\1\u00f0\1\53\62\uffff\32\52",
            "",
            "",
            "\1\53\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\52",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00f3",
            "\1\53\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\52",
            "",
            "\1\53\62\uffff\1\u00f5\31\52",
            "\1\53\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\52",
            "\1\u00f7",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00f9",
            "",
            "",
            "",
            "\1\u00fa",
            "",
            "\1\53\62\uffff\23\52\1\u00fb\6\52",
            "",
            "\1\u00fc",
            "",
            "\1\u00fd",
            "\1\u00fe",
            "\1\53\1\uffff\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\52",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__64 | T__65 | Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual | DoubleQuote | Semicolon | RightBracket | LeftBracket | LeftParenthesis | RightParenthesis | Equals | LineContinuation | Bool | Macrodef | Macroval | Identifier | Classname | Comment | QuotedField | Field | Ws | Lb | Char );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA14_65 = input.LA(1);

                         
                        int index14_65 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((isHeader() == false)))) ) {s = 103;}

                        else if ( ((isHeader() == false)) ) {s = 66;}

                         
                        input.seek(index14_65);

                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA14_26 = input.LA(1);

                         
                        int index14_26 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA14_26 >= '\u0000' && LA14_26 <= '\t')||(LA14_26 >= '\u000B' && LA14_26 <= '\f')||(LA14_26 >= '\u000E' && LA14_26 <= '\uFFFF')) && ((isMacroAssignement()))) {s = 72;}

                        else s = 71;

                         
                        input.seek(index14_26);

                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA14_0 = input.LA(1);

                        s = -1;
                        if ( (LA14_0==',') ) {s = 1;}

                        else if ( (LA14_0=='.') ) {s = 2;}

                        else if ( (LA14_0=='I') ) {s = 3;}

                        else if ( (LA14_0=='U') ) {s = 4;}

                        else if ( (LA14_0=='R') ) {s = 5;}

                        else if ( (LA14_0=='b') ) {s = 6;}

                        else if ( (LA14_0=='c') ) {s = 7;}

                        else if ( (LA14_0=='p') ) {s = 8;}

                        else if ( (LA14_0=='a') ) {s = 9;}

                        else if ( (LA14_0=='d') ) {s = 10;}

                        else if ( (LA14_0=='f') ) {s = 11;}

                        else if ( (LA14_0=='i') ) {s = 12;}

                        else if ( (LA14_0=='k') ) {s = 13;}

                        else if ( (LA14_0=='l') ) {s = 14;}

                        else if ( (LA14_0=='m') ) {s = 15;}

                        else if ( (LA14_0=='n') ) {s = 16;}

                        else if ( (LA14_0=='t') ) {s = 17;}

                        else if ( (LA14_0=='u') ) {s = 18;}

                        else if ( (LA14_0=='v') ) {s = 19;}

                        else if ( (LA14_0=='\"') ) {s = 20;}

                        else if ( (LA14_0==';') ) {s = 21;}

                        else if ( (LA14_0==']') ) {s = 22;}

                        else if ( (LA14_0=='[') ) {s = 23;}

                        else if ( (LA14_0=='(') ) {s = 24;}

                        else if ( (LA14_0==')') ) {s = 25;}

                        else if ( (LA14_0=='=') ) {s = 26;}

                        else if ( (LA14_0=='\\') ) {s = 27;}

                        else if ( (LA14_0=='$') ) {s = 28;}

                        else if ( (LA14_0=='e'||(LA14_0 >= 'g' && LA14_0 <= 'h')||LA14_0=='j'||LA14_0=='o'||(LA14_0 >= 'q' && LA14_0 <= 's')||(LA14_0 >= 'w' && LA14_0 <= 'z')) ) {s = 29;}

                        else if ( ((LA14_0 >= 'A' && LA14_0 <= 'H')||(LA14_0 >= 'J' && LA14_0 <= 'Q')||(LA14_0 >= 'S' && LA14_0 <= 'T')||(LA14_0 >= 'V' && LA14_0 <= 'Z')||LA14_0=='_') ) {s = 30;}

                        else if ( (LA14_0=='#') ) {s = 31;}

                        else if ( (LA14_0=='\t'||LA14_0==' ') ) {s = 32;}

                        else if ( (LA14_0=='\n'||LA14_0=='\r') ) {s = 33;}

                        else if ( ((LA14_0 >= '\u0000' && LA14_0 <= '\b')||(LA14_0 >= '\u000B' && LA14_0 <= '\f')||(LA14_0 >= '\u000E' && LA14_0 <= '\u001F')||LA14_0=='!'||(LA14_0 >= '%' && LA14_0 <= '\'')||(LA14_0 >= '*' && LA14_0 <= '+')||LA14_0=='-'||(LA14_0 >= '/' && LA14_0 <= ':')||LA14_0=='<'||(LA14_0 >= '>' && LA14_0 <= '@')||LA14_0=='^'||LA14_0=='`'||(LA14_0 >= '{' && LA14_0 <= '\uFFFF')) ) {s = 34;}

                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA14_21 = input.LA(1);

                         
                        int index14_21 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA14_21=='\"') ) {s = 64;}

                        else if ( ((LA14_21 >= '\u0000' && LA14_21 <= '\t')||(LA14_21 >= '\u000B' && LA14_21 <= '\f')||(LA14_21 >= '\u000E' && LA14_21 <= '!')||(LA14_21 >= '#' && LA14_21 <= ':')||(LA14_21 >= '<' && LA14_21 <= '\uFFFF')) && ((isHeader() == false))) {s = 66;}

                        else s = 65;

                         
                        input.seek(index14_21);

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}