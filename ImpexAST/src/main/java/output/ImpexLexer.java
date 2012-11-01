// $ANTLR 3.4 /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g 2012-11-01 07:59:36

 package output;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class ImpexLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__59=59;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int T__62=62;
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
    public static final int CollectionDelimiter=17;
    public static final int Comment=18;
    public static final int Dateformat=19;
    public static final int Default=20;
    public static final int DoubleQuote=21;
    public static final int Equals=22;
    public static final int Field=23;
    public static final int ForceWrite=24;
    public static final int HEADER=25;
    public static final int IMPEX=26;
    public static final int Identifier=27;
    public static final int IgnoreKeyCase=28;
    public static final int IgnoreNull=29;
    public static final int Insert=30;
    public static final int InsertUpdate=31;
    public static final int KeyToValueDelimiter=32;
    public static final int Lang=33;
    public static final int Lb=34;
    public static final int LeftBracket=35;
    public static final int LeftParenthesis=36;
    public static final int LineContinuation=37;
    public static final int MODIFIER=38;
    public static final int Macrodef=39;
    public static final int Macroval=40;
    public static final int MapDelimiter=41;
    public static final int Mode=42;
    public static final int NumberFormat=43;
    public static final int PathDelimiter=44;
    public static final int Pos=45;
    public static final int Processor=46;
    public static final int QuotedField=47;
    public static final int ROW=48;
    public static final int ROWS=49;
    public static final int Remove=50;
    public static final int RightBracket=51;
    public static final int RightParenthesis=52;
    public static final int Semicolon=53;
    public static final int Translator=54;
    public static final int Unique=55;
    public static final int Update=56;
    public static final int Virtual=57;
    public static final int Ws=58;



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

    // $ANTLR start "T__59"
    public final void mT__59() throws RecognitionException {
        try {
            int _type = T__59;
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
    // $ANTLR end "T__59"

    // $ANTLR start "T__60"
    public final void mT__60() throws RecognitionException {
        try {
            int _type = T__60;
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
    // $ANTLR end "T__60"

    // $ANTLR start "T__61"
    public final void mT__61() throws RecognitionException {
        try {
            int _type = T__61;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:75:7: ( '\\n' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:75:9: '\\n'
            {
            match('\n'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__61"

    // $ANTLR start "T__62"
    public final void mT__62() throws RecognitionException {
        try {
            int _type = T__62;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:76:7: ( '\\r' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:76:9: '\\r'
            {
            match('\r'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__62"

    // $ANTLR start "Insert"
    public final void mInsert() throws RecognitionException {
        try {
            int _type = Insert;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:185:9: ( 'INSERT' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:185:10: 'INSERT'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:186:15: ( 'INSERT_UPDATE' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:186:16: 'INSERT_UPDATE'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:187:9: ( 'UPDATE' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:187:10: 'UPDATE'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:188:9: ( 'REMOVE' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:188:10: 'REMOVE'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:192:12: ( 'batchmode' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:192:13: 'batchmode'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:193:14: ( 'cacheUnique' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:193:15: 'cacheUnique'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:194:12: ( 'processor' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:194:13: 'processor'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:199:9: ( 'alias' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:199:10: 'alias'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:200:12: ( 'allownull' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:200:13: 'allownull'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:201:16: ( 'cellDecorator' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:201:17: 'cellDecorator'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:202:22: ( 'collection-delimiter' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:202:23: 'collection-delimiter'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:203:13: ( 'dateformat' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:203:14: 'dateformat'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:204:10: ( 'default' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:204:11: 'default'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:13: ( 'forceWrite' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:205:14: 'forceWrite'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:206:16: ( 'ignoreKeyCase' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:206:17: 'ignoreKeyCase'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:207:13: ( 'ignorenull' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:207:14: 'ignorenull'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:208:21: ( 'key2value-delimiter' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:208:22: 'key2value-delimiter'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:209:8: ( 'lang' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:209:9: 'lang'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:210:15: ( 'map-delimiter' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:210:16: 'map-delimiter'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:211:7: ( 'mode' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:211:8: 'mode'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:212:15: ( 'numberformat' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:212:16: 'numberformat'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:213:16: ( 'path-delimiter' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:213:17: 'path-delimiter'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:214:7: ( 'pos' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:214:8: 'pos'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:215:13: ( 'translator' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:215:14: 'translator'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:216:9: ( 'unique' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:216:10: 'unique'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:217:10: ( 'virtual' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:217:11: 'virtual'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:227:14: ( '\"' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:227:15: '\"'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:228:12: ( ';' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:228:13: ';'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:229:15: ( ']' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:229:16: ']'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:230:14: ( '[' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:230:15: '['
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:231:18: ( '(' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:231:19: '('
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:232:18: ( ')' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:232:19: ')'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:233:9: ( '=' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:233:10: '='
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:237:18: ( '\\\\\\\\' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:237:19: '\\\\\\\\'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:238:7: ( 'true' | 'false' )
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
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:238:8: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:238:17: 'false'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:241:2: ( '$' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:241:3: '$' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:241:39: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:246:2: ({...}? => '=' (~ ( '\\r' | '\\n' ) )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:246:3: {...}? => '=' (~ ( '\\r' | '\\n' ) )*
            {
            if ( !((isMacroAssignement())) ) {
                throw new FailedPredicateException(input, "Macroval", "isMacroAssignement()");
            }

            match('='); 

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:246:32: (~ ( '\\r' | '\\n' ) )*
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:249:2: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:250:3: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:250:35: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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

    // $ANTLR start "Comment"
    public final void mComment() throws RecognitionException {
        try {
            int _type = Comment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:257:2: ( '#' (~ ( '\\r' | '\\n' ) )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:257:3: '#' (~ ( '\\r' | '\\n' ) )*
            {
            match('#'); 

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:257:7: (~ ( '\\r' | '\\n' ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '\u0000' && LA5_0 <= '\t')||(LA5_0 >= '\u000B' && LA5_0 <= '\f')||(LA5_0 >= '\u000E' && LA5_0 <= '\uFFFF')) ) {
                    alt5=1;
                }


                switch (alt5) {
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
            	    break loop5;
                }
            } while (true);


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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:261:2: ( ';' '\"' ( Char | '\"' '\"' | ';' )* '\"' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:261:3: ';' '\"' ( Char | '\"' '\"' | ';' )* '\"'
            {
            match(';'); 

            match('\"'); 

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:261:11: ( Char | '\"' '\"' | ';' )*
            loop6:
            do {
                int alt6=4;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='\"') ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1=='\"') ) {
                        alt6=2;
                    }


                }
                else if ( ((LA6_0 >= '\u0000' && LA6_0 <= '\t')||(LA6_0 >= '\u000B' && LA6_0 <= '\f')||(LA6_0 >= '\u000E' && LA6_0 <= '!')||(LA6_0 >= '#' && LA6_0 <= ':')||(LA6_0 >= '<' && LA6_0 <= '\uFFFF')) ) {
                    alt6=1;
                }
                else if ( (LA6_0==';') ) {
                    alt6=3;
                }


                switch (alt6) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:261:12: Char
            	    {
            	    mChar(); 


            	    }
            	    break;
            	case 2 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:261:19: '\"' '\"'
            	    {
            	    match('\"'); 

            	    match('\"'); 

            	    }
            	    break;
            	case 3 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:261:29: ';'
            	    {
            	    match(';'); 

            	    }
            	    break;

            	default :
            	    break loop6;
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:265:2: ({...}? => ';' ( Char )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:265:3: {...}? => ';' ( Char )*
            {
            if ( !((isHeader() == false)) ) {
                throw new FailedPredicateException(input, "Field", "isHeader() == false");
            }

            match(';'); 

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:265:32: ( Char )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0 >= '\u0000' && LA7_0 <= '\t')||(LA7_0 >= '\u000B' && LA7_0 <= '\f')||(LA7_0 >= '\u000E' && LA7_0 <= '!')||(LA7_0 >= '#' && LA7_0 <= ':')||(LA7_0 >= '<' && LA7_0 <= '\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
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
            	    break loop7;
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:295:4: ( ( ' ' | '\\t' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:295:5: ( ' ' | '\\t' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:296:4: ( ( ( '\\r' )? '\\n' | '\\r' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:296:5: ( ( '\\r' )? '\\n' | '\\r' )
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:296:5: ( ( '\\r' )? '\\n' | '\\r' )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\r') ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1=='\n') ) {
                    alt9=1;
                }
                else {
                    alt9=2;
                }
            }
            else if ( (LA9_0=='\n') ) {
                alt9=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;

            }
            switch (alt9) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:296:6: ( '\\r' )? '\\n'
                    {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:296:6: ( '\\r' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='\r') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:296:6: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:296:19: '\\r'
                    {
                    match('\r'); 

                    }
                    break;

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
    // $ANTLR end "Lb"

    // $ANTLR start "Char"
    public final void mChar() throws RecognitionException {
        try {
            int _type = Char;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:297:6: (~ ( '\\r' | '\\n' | '\"' | ';' ) )
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
        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:8: ( T__59 | T__60 | T__61 | T__62 | Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual | DoubleQuote | Semicolon | RightBracket | LeftBracket | LeftParenthesis | RightParenthesis | Equals | LineContinuation | Bool | Macrodef | Macroval | Identifier | Comment | QuotedField | Field | Ws | Lb | Char )
        int alt10=48;
        alt10 = dfa10.predict(input);
        switch (alt10) {
            case 1 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:10: T__59
                {
                mT__59(); 


                }
                break;
            case 2 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:16: T__60
                {
                mT__60(); 


                }
                break;
            case 3 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:22: T__61
                {
                mT__61(); 


                }
                break;
            case 4 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:28: T__62
                {
                mT__62(); 


                }
                break;
            case 5 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:34: Insert
                {
                mInsert(); 


                }
                break;
            case 6 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:41: InsertUpdate
                {
                mInsertUpdate(); 


                }
                break;
            case 7 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:54: Update
                {
                mUpdate(); 


                }
                break;
            case 8 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:61: Remove
                {
                mRemove(); 


                }
                break;
            case 9 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:68: BatchMode
                {
                mBatchMode(); 


                }
                break;
            case 10 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:78: CacheUnique
                {
                mCacheUnique(); 


                }
                break;
            case 11 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:90: Processor
                {
                mProcessor(); 


                }
                break;
            case 12 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:100: Alias
                {
                mAlias(); 


                }
                break;
            case 13 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:106: AllowNull
                {
                mAllowNull(); 


                }
                break;
            case 14 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:116: CellDecorator
                {
                mCellDecorator(); 


                }
                break;
            case 15 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:130: CollectionDelimiter
                {
                mCollectionDelimiter(); 


                }
                break;
            case 16 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:150: Dateformat
                {
                mDateformat(); 


                }
                break;
            case 17 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:161: Default
                {
                mDefault(); 


                }
                break;
            case 18 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:169: ForceWrite
                {
                mForceWrite(); 


                }
                break;
            case 19 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:180: IgnoreKeyCase
                {
                mIgnoreKeyCase(); 


                }
                break;
            case 20 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:194: IgnoreNull
                {
                mIgnoreNull(); 


                }
                break;
            case 21 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:205: KeyToValueDelimiter
                {
                mKeyToValueDelimiter(); 


                }
                break;
            case 22 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:225: Lang
                {
                mLang(); 


                }
                break;
            case 23 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:230: MapDelimiter
                {
                mMapDelimiter(); 


                }
                break;
            case 24 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:243: Mode
                {
                mMode(); 


                }
                break;
            case 25 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:248: NumberFormat
                {
                mNumberFormat(); 


                }
                break;
            case 26 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:261: PathDelimiter
                {
                mPathDelimiter(); 


                }
                break;
            case 27 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:275: Pos
                {
                mPos(); 


                }
                break;
            case 28 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:279: Translator
                {
                mTranslator(); 


                }
                break;
            case 29 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:290: Unique
                {
                mUnique(); 


                }
                break;
            case 30 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:297: Virtual
                {
                mVirtual(); 


                }
                break;
            case 31 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:305: DoubleQuote
                {
                mDoubleQuote(); 


                }
                break;
            case 32 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:317: Semicolon
                {
                mSemicolon(); 


                }
                break;
            case 33 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:327: RightBracket
                {
                mRightBracket(); 


                }
                break;
            case 34 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:340: LeftBracket
                {
                mLeftBracket(); 


                }
                break;
            case 35 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:352: LeftParenthesis
                {
                mLeftParenthesis(); 


                }
                break;
            case 36 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:368: RightParenthesis
                {
                mRightParenthesis(); 


                }
                break;
            case 37 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:385: Equals
                {
                mEquals(); 


                }
                break;
            case 38 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:392: LineContinuation
                {
                mLineContinuation(); 


                }
                break;
            case 39 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:409: Bool
                {
                mBool(); 


                }
                break;
            case 40 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:414: Macrodef
                {
                mMacrodef(); 


                }
                break;
            case 41 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:423: Macroval
                {
                mMacroval(); 


                }
                break;
            case 42 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:432: Identifier
                {
                mIdentifier(); 


                }
                break;
            case 43 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:443: Comment
                {
                mComment(); 


                }
                break;
            case 44 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:451: QuotedField
                {
                mQuotedField(); 


                }
                break;
            case 45 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:463: Field
                {
                mField(); 


                }
                break;
            case 46 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:469: Ws
                {
                mWs(); 


                }
                break;
            case 47 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:472: Lb
                {
                mLb(); 


                }
                break;
            case 48 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:475: Char
                {
                mChar(); 


                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    static final String DFA10_eotS =
        "\4\uffff\1\46\21\51\1\uffff\1\102\4\uffff\1\110\2\42\11\uffff\1"+
        "\51\1\uffff\27\51\15\uffff\11\51\1\162\20\51\1\uffff\11\51\1\uffff"+
        "\10\51\1\u0094\1\uffff\1\u0095\2\51\1\u0098\12\51\1\uffff\1\u00a3"+
        "\4\51\1\u0098\2\51\2\uffff\2\51\1\uffff\2\51\1\u00af\1\u00b0\1\u00b1"+
        "\5\51\1\uffff\10\51\1\u00c0\2\51\3\uffff\7\51\1\u00ca\6\51\1\uffff"+
        "\1\u00d1\10\51\1\uffff\6\51\1\uffff\1\51\1\u00e1\3\51\1\u00e5\1"+
        "\u00e6\10\51\1\uffff\3\51\2\uffff\1\u00f2\1\u00f3\1\51\1\u00f5\1"+
        "\uffff\1\51\1\u00f7\1\51\1\u00f9\1\51\3\uffff\1\51\1\uffff\1\51"+
        "\1\uffff\1\51\1\uffff\2\51\1\u0100\1\u0101\1\u0102\1\u0103\4\uffff";
    static final String DFA10_eofS =
        "\u0104\uffff";
    static final String DFA10_minS =
        "\1\0\3\uffff\1\12\1\116\1\120\1\105\3\141\1\154\2\141\1\147\1\145"+
        "\2\141\1\165\1\162\1\156\1\151\1\uffff\1\0\4\uffff\1\0\1\134\1\101"+
        "\11\uffff\1\123\1\uffff\1\104\1\115\1\164\1\143\2\154\1\157\1\164"+
        "\1\163\1\151\1\164\1\146\1\162\1\154\1\156\1\171\1\156\1\160\1\144"+
        "\1\155\1\141\1\151\1\162\1\uffff\1\0\13\uffff\1\105\1\101\1\117"+
        "\1\143\1\150\2\154\1\143\1\150\1\60\1\141\1\157\1\145\1\141\1\143"+
        "\1\163\1\157\1\62\1\147\1\55\1\145\1\142\1\156\1\145\1\161\1\164"+
        "\1\uffff\1\122\1\124\1\126\1\150\1\145\1\104\2\145\1\55\1\uffff"+
        "\1\163\1\167\1\146\1\165\2\145\1\162\1\166\1\60\1\uffff\1\60\1\145"+
        "\1\163\1\60\2\165\1\124\2\105\1\155\1\125\1\145\1\143\1\163\1\uffff"+
        "\1\60\1\156\1\157\1\154\1\127\1\60\1\145\1\141\2\uffff\1\162\1\154"+
        "\1\uffff\1\145\1\141\3\60\1\157\1\156\1\143\1\164\1\163\1\uffff"+
        "\1\165\1\162\1\164\1\162\1\113\1\154\1\146\1\141\1\60\1\154\1\125"+
        "\3\uffff\1\144\1\151\1\157\1\151\1\157\1\154\1\155\1\60\1\151\1"+
        "\145\2\165\1\157\1\164\1\uffff\1\60\1\120\1\145\1\161\1\162\1\157"+
        "\1\162\1\154\1\141\1\uffff\1\164\1\171\1\154\1\145\1\162\1\157\1"+
        "\uffff\1\104\1\60\1\165\1\141\1\156\2\60\1\164\1\145\1\103\1\154"+
        "\1\55\1\155\1\162\1\101\1\uffff\1\145\1\164\1\55\2\uffff\2\60\1"+
        "\141\1\60\1\uffff\1\141\1\60\1\124\1\60\1\157\3\uffff\1\163\1\uffff"+
        "\1\164\1\uffff\1\105\1\uffff\1\162\1\145\4\60\4\uffff";
    static final String DFA10_maxS =
        "\1\uffff\3\uffff\1\12\1\116\1\120\1\105\1\141\1\157\1\162\1\154"+
        "\1\145\1\157\1\147\1\145\1\141\1\157\1\165\1\162\1\156\1\151\1\uffff"+
        "\1\uffff\4\uffff\1\uffff\1\134\1\172\11\uffff\1\123\1\uffff\1\104"+
        "\1\115\1\164\1\143\2\154\1\157\1\164\1\163\1\154\1\164\1\146\1\162"+
        "\1\154\1\156\1\171\1\156\1\160\1\144\1\155\1\165\1\151\1\162\1\uffff"+
        "\1\0\13\uffff\1\105\1\101\1\117\1\143\1\150\2\154\1\143\1\150\1"+
        "\172\1\141\1\157\1\145\1\141\1\143\1\163\1\157\1\62\1\147\1\55\1"+
        "\145\1\142\1\156\1\145\1\161\1\164\1\uffff\1\122\1\124\1\126\1\150"+
        "\1\145\1\104\2\145\1\55\1\uffff\1\163\1\167\1\146\1\165\2\145\1"+
        "\162\1\166\1\172\1\uffff\1\172\1\145\1\163\1\172\2\165\1\124\2\105"+
        "\1\155\1\125\1\145\1\143\1\163\1\uffff\1\172\1\156\1\157\1\154\1"+
        "\127\1\172\1\145\1\141\2\uffff\1\162\1\154\1\uffff\1\145\1\141\3"+
        "\172\1\157\1\156\1\143\1\164\1\163\1\uffff\1\165\1\162\1\164\1\162"+
        "\1\156\1\154\1\146\1\141\1\172\1\154\1\125\3\uffff\1\144\1\151\1"+
        "\157\1\151\1\157\1\154\1\155\1\172\1\151\1\145\2\165\1\157\1\164"+
        "\1\uffff\1\172\1\120\1\145\1\161\1\162\1\157\1\162\1\154\1\141\1"+
        "\uffff\1\164\1\171\1\154\1\145\1\162\1\157\1\uffff\1\104\1\172\1"+
        "\165\1\141\1\156\2\172\1\164\1\145\1\103\1\154\1\55\1\155\1\162"+
        "\1\101\1\uffff\1\145\1\164\1\55\2\uffff\2\172\1\141\1\172\1\uffff"+
        "\1\141\1\172\1\124\1\172\1\157\3\uffff\1\163\1\uffff\1\164\1\uffff"+
        "\1\105\1\uffff\1\162\1\145\4\172\4\uffff";
    static final String DFA10_acceptS =
        "\1\uffff\1\1\1\2\1\3\22\uffff\1\37\1\uffff\1\41\1\42\1\43\1\44\3"+
        "\uffff\1\52\1\53\1\56\1\60\1\1\1\2\1\3\1\4\1\57\1\uffff\1\52\27"+
        "\uffff\1\54\1\uffff\1\55\1\41\1\42\1\43\1\44\1\45\1\51\1\46\1\50"+
        "\1\53\1\56\32\uffff\1\40\11\uffff\1\33\11\uffff\1\27\16\uffff\1"+
        "\32\10\uffff\1\26\1\30\2\uffff\1\47\12\uffff\1\14\13\uffff\1\5\1"+
        "\7\1\10\16\uffff\1\35\11\uffff\1\21\6\uffff\1\36\17\uffff\1\11\3"+
        "\uffff\1\13\1\15\4\uffff\1\25\5\uffff\1\17\1\20\1\22\1\uffff\1\24"+
        "\1\uffff\1\34\1\uffff\1\12\6\uffff\1\31\1\6\1\16\1\23";
    static final String DFA10_specialS =
        "\1\0\26\uffff\1\1\4\uffff\1\3\45\uffff\1\2\u00c1\uffff}>";
    static final String[] DFA10_transitionS = {
            "\11\42\1\41\1\3\2\42\1\4\22\42\1\41\1\42\1\26\1\40\1\36\3\42"+
            "\1\32\1\33\2\42\1\1\1\42\1\2\14\42\1\27\1\42\1\34\3\42\10\37"+
            "\1\5\10\37\1\7\2\37\1\6\5\37\1\31\1\35\1\30\1\42\1\37\1\42\1"+
            "\13\1\10\1\11\1\14\1\37\1\15\2\37\1\16\1\37\1\17\1\20\1\21\1"+
            "\22\1\37\1\12\3\37\1\23\1\24\1\25\4\37\uff85\42",
            "",
            "",
            "",
            "\1\47",
            "\1\50",
            "\1\52",
            "\1\53",
            "\1\54",
            "\1\55\3\uffff\1\56\11\uffff\1\57",
            "\1\61\15\uffff\1\62\2\uffff\1\60",
            "\1\63",
            "\1\64\3\uffff\1\65",
            "\1\67\15\uffff\1\66",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73\15\uffff\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\100",
            "",
            "\12\103\1\uffff\2\103\1\uffff\24\103\1\101\30\103\1\uffff\uffc4"+
            "\103",
            "",
            "",
            "",
            "",
            "\12\111\1\uffff\2\111\1\uffff\ufff2\111",
            "\1\112",
            "\32\113\4\uffff\1\113\1\uffff\32\113",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\116",
            "",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\122",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130\2\uffff\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144\23\uffff\1\145",
            "\1\146",
            "\1\147",
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
            "\1\151",
            "\1\152",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\1\157",
            "\1\160",
            "\1\161",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\163",
            "\1\164",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "\1\174",
            "\1\175",
            "\1\176",
            "\1\177",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\1\u0086",
            "\1\u0087",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\u008b",
            "",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\1\u008f",
            "\1\u0090",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u0096",
            "\1\u0097",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u0099",
            "\1\u009a",
            "\1\u009b",
            "\1\u009c",
            "\1\u009d",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\1\u00a1",
            "\1\u00a2",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u00a4",
            "\1\u00a5",
            "\1\u00a6",
            "\1\u00a7",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u00a8",
            "\1\u00a9",
            "",
            "",
            "\1\u00aa",
            "\1\u00ab",
            "",
            "\1\u00ac",
            "\1\u00ad",
            "\12\51\7\uffff\32\51\4\uffff\1\u00ae\1\uffff\32\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u00b2",
            "\1\u00b3",
            "\1\u00b4",
            "\1\u00b5",
            "\1\u00b6",
            "",
            "\1\u00b7",
            "\1\u00b8",
            "\1\u00b9",
            "\1\u00ba",
            "\1\u00bb\42\uffff\1\u00bc",
            "\1\u00bd",
            "\1\u00be",
            "\1\u00bf",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u00c1",
            "\1\u00c2",
            "",
            "",
            "",
            "\1\u00c3",
            "\1\u00c4",
            "\1\u00c5",
            "\1\u00c6",
            "\1\u00c7",
            "\1\u00c8",
            "\1\u00c9",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u00cb",
            "\1\u00cc",
            "\1\u00cd",
            "\1\u00ce",
            "\1\u00cf",
            "\1\u00d0",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u00d2",
            "\1\u00d3",
            "\1\u00d4",
            "\1\u00d5",
            "\1\u00d6",
            "\1\u00d7",
            "\1\u00d8",
            "\1\u00d9",
            "",
            "\1\u00da",
            "\1\u00db",
            "\1\u00dc",
            "\1\u00dd",
            "\1\u00de",
            "\1\u00df",
            "",
            "\1\u00e0",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u00e2",
            "\1\u00e3",
            "\1\u00e4",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u00e7",
            "\1\u00e8",
            "\1\u00e9",
            "\1\u00ea",
            "\1\u00eb",
            "\1\u00ec",
            "\1\u00ed",
            "\1\u00ee",
            "",
            "\1\u00ef",
            "\1\u00f0",
            "\1\u00f1",
            "",
            "",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u00f4",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "\1\u00f6",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u00f8",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u00fa",
            "",
            "",
            "",
            "\1\u00fb",
            "",
            "\1\u00fc",
            "",
            "\1\u00fd",
            "",
            "\1\u00fe",
            "\1\u00ff",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA10_eot = DFA.unpackEncodedString(DFA10_eotS);
    static final short[] DFA10_eof = DFA.unpackEncodedString(DFA10_eofS);
    static final char[] DFA10_min = DFA.unpackEncodedStringToUnsignedChars(DFA10_minS);
    static final char[] DFA10_max = DFA.unpackEncodedStringToUnsignedChars(DFA10_maxS);
    static final short[] DFA10_accept = DFA.unpackEncodedString(DFA10_acceptS);
    static final short[] DFA10_special = DFA.unpackEncodedString(DFA10_specialS);
    static final short[][] DFA10_transition;

    static {
        int numStates = DFA10_transitionS.length;
        DFA10_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA10_transition[i] = DFA.unpackEncodedString(DFA10_transitionS[i]);
        }
    }

    class DFA10 extends DFA {

        public DFA10(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 10;
            this.eot = DFA10_eot;
            this.eof = DFA10_eof;
            this.min = DFA10_min;
            this.max = DFA10_max;
            this.accept = DFA10_accept;
            this.special = DFA10_special;
            this.transition = DFA10_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__59 | T__60 | T__61 | T__62 | Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual | DoubleQuote | Semicolon | RightBracket | LeftBracket | LeftParenthesis | RightParenthesis | Equals | LineContinuation | Bool | Macrodef | Macroval | Identifier | Comment | QuotedField | Field | Ws | Lb | Char );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA10_0 = input.LA(1);

                        s = -1;
                        if ( (LA10_0==',') ) {s = 1;}

                        else if ( (LA10_0=='.') ) {s = 2;}

                        else if ( (LA10_0=='\n') ) {s = 3;}

                        else if ( (LA10_0=='\r') ) {s = 4;}

                        else if ( (LA10_0=='I') ) {s = 5;}

                        else if ( (LA10_0=='U') ) {s = 6;}

                        else if ( (LA10_0=='R') ) {s = 7;}

                        else if ( (LA10_0=='b') ) {s = 8;}

                        else if ( (LA10_0=='c') ) {s = 9;}

                        else if ( (LA10_0=='p') ) {s = 10;}

                        else if ( (LA10_0=='a') ) {s = 11;}

                        else if ( (LA10_0=='d') ) {s = 12;}

                        else if ( (LA10_0=='f') ) {s = 13;}

                        else if ( (LA10_0=='i') ) {s = 14;}

                        else if ( (LA10_0=='k') ) {s = 15;}

                        else if ( (LA10_0=='l') ) {s = 16;}

                        else if ( (LA10_0=='m') ) {s = 17;}

                        else if ( (LA10_0=='n') ) {s = 18;}

                        else if ( (LA10_0=='t') ) {s = 19;}

                        else if ( (LA10_0=='u') ) {s = 20;}

                        else if ( (LA10_0=='v') ) {s = 21;}

                        else if ( (LA10_0=='\"') ) {s = 22;}

                        else if ( (LA10_0==';') ) {s = 23;}

                        else if ( (LA10_0==']') ) {s = 24;}

                        else if ( (LA10_0=='[') ) {s = 25;}

                        else if ( (LA10_0=='(') ) {s = 26;}

                        else if ( (LA10_0==')') ) {s = 27;}

                        else if ( (LA10_0=='=') ) {s = 28;}

                        else if ( (LA10_0=='\\') ) {s = 29;}

                        else if ( (LA10_0=='$') ) {s = 30;}

                        else if ( ((LA10_0 >= 'A' && LA10_0 <= 'H')||(LA10_0 >= 'J' && LA10_0 <= 'Q')||(LA10_0 >= 'S' && LA10_0 <= 'T')||(LA10_0 >= 'V' && LA10_0 <= 'Z')||LA10_0=='_'||LA10_0=='e'||(LA10_0 >= 'g' && LA10_0 <= 'h')||LA10_0=='j'||LA10_0=='o'||(LA10_0 >= 'q' && LA10_0 <= 's')||(LA10_0 >= 'w' && LA10_0 <= 'z')) ) {s = 31;}

                        else if ( (LA10_0=='#') ) {s = 32;}

                        else if ( (LA10_0=='\t'||LA10_0==' ') ) {s = 33;}

                        else if ( ((LA10_0 >= '\u0000' && LA10_0 <= '\b')||(LA10_0 >= '\u000B' && LA10_0 <= '\f')||(LA10_0 >= '\u000E' && LA10_0 <= '\u001F')||LA10_0=='!'||(LA10_0 >= '%' && LA10_0 <= '\'')||(LA10_0 >= '*' && LA10_0 <= '+')||LA10_0=='-'||(LA10_0 >= '/' && LA10_0 <= ':')||LA10_0=='<'||(LA10_0 >= '>' && LA10_0 <= '@')||LA10_0=='^'||LA10_0=='`'||(LA10_0 >= '{' && LA10_0 <= '\uFFFF')) ) {s = 34;}

                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA10_23 = input.LA(1);

                         
                        int index10_23 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA10_23=='\"') ) {s = 65;}

                        else if ( ((LA10_23 >= '\u0000' && LA10_23 <= '\t')||(LA10_23 >= '\u000B' && LA10_23 <= '\f')||(LA10_23 >= '\u000E' && LA10_23 <= '!')||(LA10_23 >= '#' && LA10_23 <= ':')||(LA10_23 >= '<' && LA10_23 <= '\uFFFF')) && ((isHeader() == false))) {s = 67;}

                        else s = 66;

                         
                        input.seek(index10_23);

                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA10_66 = input.LA(1);

                         
                        int index10_66 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((isHeader() == false)))) ) {s = 104;}

                        else if ( ((isHeader() == false)) ) {s = 67;}

                         
                        input.seek(index10_66);

                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA10_28 = input.LA(1);

                         
                        int index10_28 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA10_28 >= '\u0000' && LA10_28 <= '\t')||(LA10_28 >= '\u000B' && LA10_28 <= '\f')||(LA10_28 >= '\u000E' && LA10_28 <= '\uFFFF')) && ((isMacroAssignement()))) {s = 73;}

                        else s = 72;

                         
                        input.seek(index10_28);

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 10, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}