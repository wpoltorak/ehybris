// $ANTLR 3.4 /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g 2012-11-04 23:24:38

 package output;  


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class ImpexLexer extends Lexer {
    public static final int EOF=-1;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int ASSIGNEMENT=4;
    public static final int ASSIGNEMENTS=5;
    public static final int ATTRIBUTE=6;
    public static final int ATTRIBUTES=7;
    public static final int Alias=8;
    public static final int AllowNull=9;
    public static final int ArgumentModifier=10;
    public static final int ArgumentModifierval=11;
    public static final int BLOCK=12;
    public static final int BLOCKS=13;
    public static final int BatchMode=14;
    public static final int Bool=15;
    public static final int CacheUnique=16;
    public static final int CellDecorator=17;
    public static final int Char=18;
    public static final int Classname=19;
    public static final int CollectionDelimiter=20;
    public static final int Comma=21;
    public static final int Comment=22;
    public static final int DOCUMENTID=23;
    public static final int Dateformat=24;
    public static final int Default=25;
    public static final int DocumentId=26;
    public static final int DoubleQuote=27;
    public static final int Equals=28;
    public static final int FIELDS=29;
    public static final int Field=30;
    public static final int ForceWrite=31;
    public static final int HEADER=32;
    public static final int HeaderMode=33;
    public static final int HeaderModifier=34;
    public static final int IMPEX=35;
    public static final int Identifier=36;
    public static final int IgnoreKeyCase=37;
    public static final int IgnoreNull=38;
    public static final int Insert=39;
    public static final int InsertUpdate=40;
    public static final int KeyToValueDelimiter=41;
    public static final int Lang=42;
    public static final int Lb=43;
    public static final int LeftBracket=44;
    public static final int LeftParenthesis=45;
    public static final int LineContinuation=46;
    public static final int MODIFIER=47;
    public static final int MODIFIERS=48;
    public static final int Macrodef=49;
    public static final int Macroval=50;
    public static final int MapDelimiter=51;
    public static final int Mode=52;
    public static final int NumberFormat=53;
    public static final int PathDelimiter=54;
    public static final int Pos=55;
    public static final int Processor=56;
    public static final int QuotedField=57;
    public static final int RECORD=58;
    public static final int RECORDS=59;
    public static final int Remove=60;
    public static final int RightBracket=61;
    public static final int RightParenthesis=62;
    public static final int SUBTYPE=63;
    public static final int Semicolon=64;
    public static final int TYPE=65;
    public static final int Translator=66;
    public static final int Unique=67;
    public static final int Update=68;
    public static final int Virtual=69;
    public static final int Ws=70;



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

    private boolean isMacroAssignment() {
            final Token token = getToken(0);
            return token != null && token.getType() == Macrodef;
    //            return input.LA(-1) == Macrodef;
    }


        private boolean isArgumentModifierAssignment() {
            final Token token = getToken(0);

            switch (token.getType()) {
                case Alias:
                case AllowNull:
                case CellDecorator:
                case CollectionDelimiter:
                case Dateformat:
                case Default:
                case ForceWrite:
                case IgnoreKeyCase:
                case IgnoreNull:
                case KeyToValueDelimiter:
                case Lang:
                case MapDelimiter:
                case Mode:
                case NumberFormat:
                case PathDelimiter:
                case Pos:
                case Translator:
                case Unique:
                case Virtual:
                    return true;
            }
            return false;
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

    // $ANTLR start "T__71"
    public final void mT__71() throws RecognitionException {
        try {
            int _type = T__71;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:102:7: ( '.' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:102:9: '.'
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
    // $ANTLR end "T__71"

    // $ANTLR start "T__72"
    public final void mT__72() throws RecognitionException {
        try {
            int _type = T__72;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:103:7: ( '@' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:103:9: '@'
            {
            match('@'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "T__72"

    // $ANTLR start "Insert"
    public final void mInsert() throws RecognitionException {
        try {
            int _type = Insert;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:197:4: ( 'INSERT' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:197:5: 'INSERT'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:198:15: ( 'INSERT_UPDATE' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:198:16: 'INSERT_UPDATE'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:199:9: ( 'UPDATE' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:199:10: 'UPDATE'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:200:9: ( 'REMOVE' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:200:10: 'REMOVE'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:207:12: ( 'batchmode' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:207:13: 'batchmode'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:208:14: ( 'cacheUnique' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:208:15: 'cacheUnique'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:209:12: ( 'processor' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:209:13: 'processor'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:211:8: ( 'alias' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:211:9: 'alias'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:212:12: ( 'allownull' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:212:13: 'allownull'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:213:15: ( 'cellDecorator' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:213:16: 'cellDecorator'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:214:22: ( 'collection-delimiter' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:214:23: 'collection-delimiter'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:215:13: ( 'dateformat' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:215:14: 'dateformat'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:216:10: ( 'default' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:216:11: 'default'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:217:13: ( 'forceWrite' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:217:14: 'forceWrite'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:218:15: ( 'ignoreKeyCase' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:218:16: 'ignoreKeyCase'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:219:13: ( 'ignorenull' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:219:14: 'ignorenull'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:220:21: ( 'key2value-delimiter' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:220:22: 'key2value-delimiter'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:221:7: ( 'lang' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:221:8: 'lang'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:222:14: ( 'map-delimiter' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:222:15: 'map-delimiter'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:223:7: ( 'mode' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:223:8: 'mode'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:224:14: ( 'numberformat' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:224:15: 'numberformat'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:225:15: ( 'path-delimiter' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:225:16: 'path-delimiter'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:226:6: ( 'pos' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:226:7: 'pos'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:227:13: ( 'translator' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:227:14: 'translator'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:228:9: ( 'unique' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:228:10: 'unique'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:229:10: ( 'virtual' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:229:11: 'virtual'
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

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:231:9: ( ',' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:231:10: ','
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

    // $ANTLR start "DoubleQuote"
    public final void mDoubleQuote() throws RecognitionException {
        try {
            int _type = DoubleQuote;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:232:14: ( '\"' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:232:15: '\"'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:233:12: ( ';' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:233:13: ';'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:234:15: ( ']' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:234:16: ']'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:235:14: ( '[' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:235:15: '['
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:236:18: ( '(' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:236:19: '('
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:237:18: ( ')' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:237:19: ')'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:238:9: ( '=' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:238:10: '='
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:240:18: ( '\\\\\\\\' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:240:19: '\\\\\\\\'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:241:7: ( 'true' | 'false' )
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
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:241:8: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:241:17: 'false'
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

    // $ANTLR start "HeaderMode"
    public final void mHeaderMode() throws RecognitionException {
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:243:21: ( Insert | InsertUpdate | Update | Remove )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 'I':
                {
                int LA2_1 = input.LA(2);

                if ( (LA2_1=='N') ) {
                    int LA2_4 = input.LA(3);

                    if ( (LA2_4=='S') ) {
                        int LA2_5 = input.LA(4);

                        if ( (LA2_5=='E') ) {
                            int LA2_6 = input.LA(5);

                            if ( (LA2_6=='R') ) {
                                int LA2_7 = input.LA(6);

                                if ( (LA2_7=='T') ) {
                                    int LA2_8 = input.LA(7);

                                    if ( (LA2_8=='_') ) {
                                        alt2=2;
                                    }
                                    else {
                                        alt2=1;
                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 2, 7, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 2, 6, input);

                                throw nvae;

                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 2, 5, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 2, 4, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;

                }
                }
                break;
            case 'U':
                {
                alt2=3;
                }
                break;
            case 'R':
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;

            }

            switch (alt2) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:243:23: Insert
                    {
                    mInsert(); 


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:243:32: InsertUpdate
                    {
                    mInsertUpdate(); 


                    }
                    break;
                case 3 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:243:47: Update
                    {
                    mUpdate(); 


                    }
                    break;
                case 4 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:243:56: Remove
                    {
                    mRemove(); 


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HeaderMode"

    // $ANTLR start "HeaderModifier"
    public final void mHeaderModifier() throws RecognitionException {
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:245:25: ( BatchMode | CacheUnique | Processor )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 'b':
                {
                alt3=1;
                }
                break;
            case 'c':
                {
                alt3=2;
                }
                break;
            case 'p':
                {
                alt3=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;

            }

            switch (alt3) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:245:26: BatchMode
                    {
                    mBatchMode(); 


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:245:38: CacheUnique
                    {
                    mCacheUnique(); 


                    }
                    break;
                case 3 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:245:52: Processor
                    {
                    mProcessor(); 


                    }
                    break;

            }

        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "HeaderModifier"

    // $ANTLR start "ArgumentModifier"
    public final void mArgumentModifier() throws RecognitionException {
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:248:3: ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual )
            int alt4=19;
            switch ( input.LA(1) ) {
            case 'a':
                {
                int LA4_1 = input.LA(2);

                if ( (LA4_1=='l') ) {
                    int LA4_14 = input.LA(3);

                    if ( (LA4_14=='i') ) {
                        alt4=1;
                    }
                    else if ( (LA4_14=='l') ) {
                        alt4=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 14, input);

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
            case 'c':
                {
                int LA4_2 = input.LA(2);

                if ( (LA4_2=='e') ) {
                    alt4=3;
                }
                else if ( (LA4_2=='o') ) {
                    alt4=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 2, input);

                    throw nvae;

                }
                }
                break;
            case 'd':
                {
                int LA4_3 = input.LA(2);

                if ( (LA4_3=='a') ) {
                    alt4=5;
                }
                else if ( (LA4_3=='e') ) {
                    alt4=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 3, input);

                    throw nvae;

                }
                }
                break;
            case 'f':
                {
                alt4=7;
                }
                break;
            case 'i':
                {
                int LA4_5 = input.LA(2);

                if ( (LA4_5=='g') ) {
                    int LA4_19 = input.LA(3);

                    if ( (LA4_19=='n') ) {
                        int LA4_26 = input.LA(4);

                        if ( (LA4_26=='o') ) {
                            int LA4_27 = input.LA(5);

                            if ( (LA4_27=='r') ) {
                                int LA4_28 = input.LA(6);

                                if ( (LA4_28=='e') ) {
                                    int LA4_29 = input.LA(7);

                                    if ( (LA4_29=='K') ) {
                                        alt4=8;
                                    }
                                    else if ( (LA4_29=='n') ) {
                                        alt4=9;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 4, 29, input);

                                        throw nvae;

                                    }
                                }
                                else {
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 4, 28, input);

                                    throw nvae;

                                }
                            }
                            else {
                                NoViableAltException nvae =
                                    new NoViableAltException("", 4, 27, input);

                                throw nvae;

                            }
                        }
                        else {
                            NoViableAltException nvae =
                                new NoViableAltException("", 4, 26, input);

                            throw nvae;

                        }
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 4, 19, input);

                        throw nvae;

                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 5, input);

                    throw nvae;

                }
                }
                break;
            case 'k':
                {
                alt4=10;
                }
                break;
            case 'l':
                {
                alt4=11;
                }
                break;
            case 'm':
                {
                int LA4_8 = input.LA(2);

                if ( (LA4_8=='a') ) {
                    alt4=12;
                }
                else if ( (LA4_8=='o') ) {
                    alt4=13;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 8, input);

                    throw nvae;

                }
                }
                break;
            case 'n':
                {
                alt4=14;
                }
                break;
            case 'p':
                {
                int LA4_10 = input.LA(2);

                if ( (LA4_10=='a') ) {
                    alt4=15;
                }
                else if ( (LA4_10=='o') ) {
                    alt4=16;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 10, input);

                    throw nvae;

                }
                }
                break;
            case 't':
                {
                alt4=17;
                }
                break;
            case 'u':
                {
                alt4=18;
                }
                break;
            case 'v':
                {
                alt4=19;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;

            }

            switch (alt4) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:248:5: Alias
                    {
                    mAlias(); 


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:248:12: AllowNull
                    {
                    mAllowNull(); 


                    }
                    break;
                case 3 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:248:24: CellDecorator
                    {
                    mCellDecorator(); 


                    }
                    break;
                case 4 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:248:40: CollectionDelimiter
                    {
                    mCollectionDelimiter(); 


                    }
                    break;
                case 5 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:248:62: Dateformat
                    {
                    mDateformat(); 


                    }
                    break;
                case 6 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:248:75: Default
                    {
                    mDefault(); 


                    }
                    break;
                case 7 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:248:85: ForceWrite
                    {
                    mForceWrite(); 


                    }
                    break;
                case 8 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:248:98: IgnoreKeyCase
                    {
                    mIgnoreKeyCase(); 


                    }
                    break;
                case 9 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:248:114: IgnoreNull
                    {
                    mIgnoreNull(); 


                    }
                    break;
                case 10 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:249:5: KeyToValueDelimiter
                    {
                    mKeyToValueDelimiter(); 


                    }
                    break;
                case 11 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:249:27: Lang
                    {
                    mLang(); 


                    }
                    break;
                case 12 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:249:34: MapDelimiter
                    {
                    mMapDelimiter(); 


                    }
                    break;
                case 13 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:249:49: Mode
                    {
                    mMode(); 


                    }
                    break;
                case 14 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:249:56: NumberFormat
                    {
                    mNumberFormat(); 


                    }
                    break;
                case 15 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:249:71: PathDelimiter
                    {
                    mPathDelimiter(); 


                    }
                    break;
                case 16 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:249:87: Pos
                    {
                    mPos(); 


                    }
                    break;
                case 17 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:249:93: Translator
                    {
                    mTranslator(); 


                    }
                    break;
                case 18 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:249:106: Unique
                    {
                    mUnique(); 


                    }
                    break;
                case 19 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:249:115: Virtual
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
    // $ANTLR end "ArgumentModifier"

    // $ANTLR start "Macrodef"
    public final void mMacrodef() throws RecognitionException {
        try {
            int _type = Macrodef;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:252:2: ( '$' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:252:3: '$' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:252:39: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0 >= '0' && LA5_0 <= '9')||(LA5_0 >= 'A' && LA5_0 <= 'Z')||LA5_0=='_'||(LA5_0 >= 'a' && LA5_0 <= 'z')) ) {
                    alt5=1;
                }


                switch (alt5) {
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
            	    break loop5;
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:257:2: ({...}? => ( '=' (~ ( '\\r' | '\\n' ) )* ) |)
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='=') && ((isMacroAssignment()))) {
                alt7=1;
            }
            else {
                alt7=2;
            }
            switch (alt7) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:257:3: {...}? => ( '=' (~ ( '\\r' | '\\n' ) )* )
                    {
                    if ( !((isMacroAssignment())) ) {
                        throw new FailedPredicateException(input, "Macroval", "isMacroAssignment()");
                    }

                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:257:28: ( '=' (~ ( '\\r' | '\\n' ) )* )
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:257:29: '=' (~ ( '\\r' | '\\n' ) )*
                    {
                    match('='); 

                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:257:32: (~ ( '\\r' | '\\n' ) )*
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


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:258:3: 
                    {
                    }
                    break;

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

    // $ANTLR start "ArgumentModifierval"
    public final void mArgumentModifierval() throws RecognitionException {
        try {
            int _type = ArgumentModifierval;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:268:2: ({...}? => '=' (~ ( '\\r' | '\\n' | ';' | '[' | ']' | ',' ) )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:268:3: {...}? => '=' (~ ( '\\r' | '\\n' | ';' | '[' | ']' | ',' ) )*
            {
            if ( !((isArgumentModifierAssignment())) ) {
                throw new FailedPredicateException(input, "ArgumentModifierval", "isArgumentModifierAssignment()");
            }

            match('='); 

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:268:42: (~ ( '\\r' | '\\n' | ';' | '[' | ']' | ',' ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0 >= '\u0000' && LA8_0 <= '\t')||(LA8_0 >= '\u000B' && LA8_0 <= '\f')||(LA8_0 >= '\u000E' && LA8_0 <= '+')||(LA8_0 >= '-' && LA8_0 <= ':')||(LA8_0 >= '<' && LA8_0 <= 'Z')||LA8_0=='\\'||(LA8_0 >= '^' && LA8_0 <= '\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
            	    {
            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '+')||(input.LA(1) >= '-' && input.LA(1) <= ':')||(input.LA(1) >= '<' && input.LA(1) <= 'Z')||input.LA(1)=='\\'||(input.LA(1) >= '^' && input.LA(1) <= '\uFFFF') ) {
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

            state.type = _type;
            state.channel = _channel;

            		String text = getText().substring(1, getText().length()).trim();
            		if (text.endsWith(",")){
            		    text = text.substring(0, text.length() - 1);
            		}
            		setText(text);
            	
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "ArgumentModifierval"

    // $ANTLR start "DocumentId"
    public final void mDocumentId() throws RecognitionException {
        try {
            int _type = DocumentId;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:271:2: ( '&' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:271:3: '&' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            match('&'); 

            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:271:39: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0 >= '0' && LA9_0 <= '9')||(LA9_0 >= 'A' && LA9_0 <= 'Z')||LA9_0=='_'||(LA9_0 >= 'a' && LA9_0 <= 'z')) ) {
                    alt9=1;
                }


                switch (alt9) {
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
            	    break loop9;
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
    // $ANTLR end "DocumentId"

    // $ANTLR start "Identifier"
    public final void mIdentifier() throws RecognitionException {
        try {
            int _type = Identifier;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:273:2: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:273:3: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:273:35: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0 >= '0' && LA10_0 <= '9')||(LA10_0 >= 'A' && LA10_0 <= 'Z')||LA10_0=='_'||(LA10_0 >= 'a' && LA10_0 <= 'z')) ) {
                    alt10=1;
                }


                switch (alt10) {
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
            	    break loop10;
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:276:2: ( ( ( 'a' .. 'z' )+ '.' )+ 'A' .. 'Z' ( 'A' .. 'Z' | 'a' .. 'z' )+ )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:276:3: ( ( 'a' .. 'z' )+ '.' )+ 'A' .. 'Z' ( 'A' .. 'Z' | 'a' .. 'z' )+
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:276:3: ( ( 'a' .. 'z' )+ '.' )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0 >= 'a' && LA12_0 <= 'z')) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:276:4: ( 'a' .. 'z' )+ '.'
            	    {
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:276:4: ( 'a' .. 'z' )+
            	    int cnt11=0;
            	    loop11:
            	    do {
            	        int alt11=2;
            	        int LA11_0 = input.LA(1);

            	        if ( ((LA11_0 >= 'a' && LA11_0 <= 'z')) ) {
            	            alt11=1;
            	        }


            	        switch (alt11) {
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
            	    	    if ( cnt11 >= 1 ) break loop11;
            	                EarlyExitException eee =
            	                    new EarlyExitException(11, input);
            	                throw eee;
            	        }
            	        cnt11++;
            	    } while (true);


            	    match('.'); 

            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            matchRange('A','Z'); 

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:276:35: ( 'A' .. 'Z' | 'a' .. 'z' )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0 >= 'A' && LA13_0 <= 'Z')||(LA13_0 >= 'a' && LA13_0 <= 'z')) ) {
                    alt13=1;
                }


                switch (alt13) {
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
            	    if ( cnt13 >= 1 ) break loop13;
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:280:2: ( '#' (~ ( '\\r' | '\\n' ) )* ( Lb )? )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:280:3: '#' (~ ( '\\r' | '\\n' ) )* ( Lb )?
            {
            match('#'); 

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:280:7: (~ ( '\\r' | '\\n' ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0 >= '\u0000' && LA14_0 <= '\t')||(LA14_0 >= '\u000B' && LA14_0 <= '\f')||(LA14_0 >= '\u000E' && LA14_0 <= '\uFFFF')) ) {
                    alt14=1;
                }


                switch (alt14) {
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
            	    break loop14;
                }
            } while (true);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:280:23: ( Lb )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0=='\n'||LA15_0=='\r') ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:280:23: Lb
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:284:2: ( ';' '\"' ( Char | '\"' '\"' | ';' )* '\"' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:284:3: ';' '\"' ( Char | '\"' '\"' | ';' )* '\"'
            {
            match(';'); 

            match('\"'); 

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:284:11: ( Char | '\"' '\"' | ';' )*
            loop16:
            do {
                int alt16=4;
                int LA16_0 = input.LA(1);

                if ( (LA16_0=='\"') ) {
                    int LA16_1 = input.LA(2);

                    if ( (LA16_1=='\"') ) {
                        alt16=2;
                    }


                }
                else if ( ((LA16_0 >= '\u0000' && LA16_0 <= '\t')||(LA16_0 >= '\u000B' && LA16_0 <= '\f')||(LA16_0 >= '\u000E' && LA16_0 <= '!')||(LA16_0 >= '#' && LA16_0 <= ':')||(LA16_0 >= '<' && LA16_0 <= '\uFFFF')) ) {
                    alt16=1;
                }
                else if ( (LA16_0==';') ) {
                    alt16=3;
                }


                switch (alt16) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:284:12: Char
            	    {
            	    mChar(); 


            	    }
            	    break;
            	case 2 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:284:19: '\"' '\"'
            	    {
            	    match('\"'); 

            	    match('\"'); 

            	    }
            	    break;
            	case 3 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:284:29: ';'
            	    {
            	    match(';'); 

            	    }
            	    break;

            	default :
            	    break loop16;
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:288:2: ({...}? => ';' ( Char )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:288:3: {...}? => ';' ( Char )*
            {
            if ( !((isHeader() == false)) ) {
                throw new FailedPredicateException(input, "Field", "isHeader() == false");
            }

            match(';'); 

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:288:32: ( Char )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0 >= '\u0000' && LA17_0 <= '\t')||(LA17_0 >= '\u000B' && LA17_0 <= '\f')||(LA17_0 >= '\u000E' && LA17_0 <= '!')||(LA17_0 >= '#' && LA17_0 <= ':')||(LA17_0 >= '<' && LA17_0 <= '\uFFFF')) ) {
                    alt17=1;
                }


                switch (alt17) {
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
            	    break loop17;
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:307:4: ( ( ' ' | '\\t' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:307:5: ( ' ' | '\\t' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:308:4: ( ( ( '\\r' )? '\\n' | '\\r' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:308:5: ( ( '\\r' )? '\\n' | '\\r' )
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:308:5: ( ( '\\r' )? '\\n' | '\\r' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='\r') ) {
                int LA19_1 = input.LA(2);

                if ( (LA19_1=='\n') ) {
                    alt19=1;
                }
                else {
                    alt19=2;
                }
            }
            else if ( (LA19_0=='\n') ) {
                alt19=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;

            }
            switch (alt19) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:308:6: ( '\\r' )? '\\n'
                    {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:308:6: ( '\\r' )?
                    int alt18=2;
                    int LA18_0 = input.LA(1);

                    if ( (LA18_0=='\r') ) {
                        alt18=1;
                    }
                    switch (alt18) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:308:6: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:308:19: '\\r'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:309:6: (~ ( '\\r' | '\\n' | '\"' | ';' ) )
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
        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:8: ( T__71 | T__72 | Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual | Comma | DoubleQuote | Semicolon | RightBracket | LeftBracket | LeftParenthesis | RightParenthesis | Equals | LineContinuation | Bool | Macrodef | Macroval | ArgumentModifierval | DocumentId | Identifier | Classname | Comment | QuotedField | Field | Ws | Lb | Char )
        int alt20=50;
        alt20 = dfa20.predict(input);
        switch (alt20) {
            case 1 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:10: T__71
                {
                mT__71(); 


                }
                break;
            case 2 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:16: T__72
                {
                mT__72(); 


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
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:293: Comma
                {
                mComma(); 


                }
                break;
            case 30 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:299: DoubleQuote
                {
                mDoubleQuote(); 


                }
                break;
            case 31 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:311: Semicolon
                {
                mSemicolon(); 


                }
                break;
            case 32 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:321: RightBracket
                {
                mRightBracket(); 


                }
                break;
            case 33 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:334: LeftBracket
                {
                mLeftBracket(); 


                }
                break;
            case 34 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:346: LeftParenthesis
                {
                mLeftParenthesis(); 


                }
                break;
            case 35 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:362: RightParenthesis
                {
                mRightParenthesis(); 


                }
                break;
            case 36 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:379: Equals
                {
                mEquals(); 


                }
                break;
            case 37 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:386: LineContinuation
                {
                mLineContinuation(); 


                }
                break;
            case 38 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:403: Bool
                {
                mBool(); 


                }
                break;
            case 39 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:408: Macrodef
                {
                mMacrodef(); 


                }
                break;
            case 40 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:417: Macroval
                {
                mMacroval(); 


                }
                break;
            case 41 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:426: ArgumentModifierval
                {
                mArgumentModifierval(); 


                }
                break;
            case 42 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:446: DocumentId
                {
                mDocumentId(); 


                }
                break;
            case 43 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:457: Identifier
                {
                mIdentifier(); 


                }
                break;
            case 44 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:468: Classname
                {
                mClassname(); 


                }
                break;
            case 45 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:478: Comment
                {
                mComment(); 


                }
                break;
            case 46 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:486: QuotedField
                {
                mQuotedField(); 


                }
                break;
            case 47 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:498: Field
                {
                mField(); 


                }
                break;
            case 48 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:504: Ws
                {
                mWs(); 


                }
                break;
            case 49 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:507: Lb
                {
                mLb(); 


                }
                break;
            case 50 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:510: Char
                {
                mChar(); 


                }
                break;

        }

    }


    protected DFA20 dfa20 = new DFA20(this);
    static final String DFA20_eotS =
        "\1\36\2\uffff\21\51\2\uffff\1\105\4\uffff\1\113\2\45\1\uffff\1\45"+
        "\1\51\7\uffff\1\51\1\uffff\4\51\1\uffff\24\51\11\uffff\1\156\6\uffff"+
        "\11\51\1\170\20\51\2\uffff\11\51\1\uffff\10\51\1\u009b\1\uffff\1"+
        "\u009c\2\51\1\u009f\2\51\1\uffff\10\51\1\uffff\1\u00aa\4\51\1\u009f"+
        "\2\51\2\uffff\2\51\1\uffff\2\51\1\u00b6\1\u00b7\1\u00b8\5\51\1\uffff"+
        "\10\51\1\u00c7\2\51\3\uffff\7\51\1\u00d1\6\51\1\uffff\1\u00d8\10"+
        "\51\1\uffff\6\51\1\uffff\1\51\1\u00e8\3\51\1\u00ec\1\u00ed\10\51"+
        "\1\uffff\3\51\2\uffff\1\u00f9\1\u00fa\1\51\1\u00fc\1\uffff\1\51"+
        "\1\u00fe\1\51\1\u0100\1\51\3\uffff\1\51\1\uffff\1\51\1\uffff\1\51"+
        "\1\uffff\2\51\1\u0107\1\u0108\1\u0109\1\u010a\4\uffff";
    static final String DFA20_eofS =
        "\u010b\uffff";
    static final String DFA20_minS =
        "\1\0\2\uffff\1\116\1\120\1\105\16\56\2\uffff\1\0\4\uffff\1\0\1\134"+
        "\1\101\1\uffff\1\101\1\56\7\uffff\1\123\1\uffff\1\104\1\115\2\56"+
        "\1\uffff\24\56\2\uffff\1\0\6\uffff\1\0\6\uffff\1\105\1\101\1\117"+
        "\20\56\1\55\6\56\1\uffff\1\0\1\122\1\124\1\126\5\56\1\55\1\uffff"+
        "\7\56\1\166\1\56\1\uffff\6\56\1\uffff\1\124\2\105\2\56\1\145\2\56"+
        "\1\uffff\7\56\1\141\2\uffff\2\56\1\uffff\2\56\3\60\1\56\1\156\1"+
        "\143\2\56\1\uffff\3\56\1\162\1\56\1\154\4\56\1\125\3\uffff\1\56"+
        "\1\151\1\157\5\56\1\151\1\145\1\56\1\165\2\56\1\uffff\1\56\1\120"+
        "\1\56\1\161\1\162\4\56\1\uffff\1\164\1\171\1\56\1\145\2\56\1\uffff"+
        "\1\104\1\56\1\165\1\141\4\56\1\145\1\103\1\56\1\55\2\56\1\101\1"+
        "\uffff\1\145\1\164\1\55\2\uffff\1\56\1\60\1\141\1\56\1\uffff\2\56"+
        "\1\124\1\60\1\157\3\uffff\1\163\1\uffff\1\56\1\uffff\1\105\1\uffff"+
        "\1\162\1\145\1\56\3\60\4\uffff";
    static final String DFA20_maxS =
        "\1\uffff\2\uffff\1\116\1\120\1\105\16\172\2\uffff\1\uffff\4\uffff"+
        "\1\uffff\1\134\1\172\1\uffff\2\172\7\uffff\1\123\1\uffff\1\104\1"+
        "\115\2\172\1\uffff\24\172\2\uffff\1\0\6\uffff\1\uffff\6\uffff\1"+
        "\105\1\101\1\117\27\172\1\uffff\1\0\1\122\1\124\1\126\6\172\1\uffff"+
        "\7\172\1\166\1\172\1\uffff\6\172\1\uffff\1\124\2\105\2\172\1\145"+
        "\2\172\1\uffff\7\172\1\141\2\uffff\2\172\1\uffff\6\172\1\156\1\143"+
        "\2\172\1\uffff\3\172\1\162\1\172\1\154\4\172\1\125\3\uffff\1\172"+
        "\1\151\1\157\5\172\1\151\1\145\1\172\1\165\2\172\1\uffff\1\172\1"+
        "\120\1\172\1\161\1\162\4\172\1\uffff\1\164\1\171\1\172\1\145\2\172"+
        "\1\uffff\1\104\1\172\1\165\1\141\4\172\1\145\1\103\1\172\1\55\2"+
        "\172\1\101\1\uffff\1\145\1\164\1\172\2\uffff\2\172\1\141\1\172\1"+
        "\uffff\2\172\1\124\1\172\1\157\3\uffff\1\163\1\uffff\1\172\1\uffff"+
        "\1\105\1\uffff\1\162\1\145\4\172\4\uffff";
    static final String DFA20_acceptS =
        "\1\uffff\1\1\1\2\21\uffff\1\35\1\36\1\uffff\1\40\1\41\1\42\1\43"+
        "\3\uffff\1\50\2\uffff\1\53\1\55\1\60\1\61\1\62\1\1\1\2\1\uffff\1"+
        "\53\4\uffff\1\54\24\uffff\1\35\1\56\1\uffff\1\57\1\40\1\41\1\42"+
        "\1\43\1\44\1\uffff\1\50\1\45\1\47\1\52\1\55\1\60\32\uffff\1\37\12"+
        "\uffff\1\31\11\uffff\1\25\6\uffff\1\51\10\uffff\1\30\10\uffff\1"+
        "\24\1\26\2\uffff\1\46\12\uffff\1\12\13\uffff\1\3\1\5\1\6\16\uffff"+
        "\1\33\11\uffff\1\17\6\uffff\1\34\17\uffff\1\7\3\uffff\1\11\1\13"+
        "\4\uffff\1\23\5\uffff\1\15\1\16\1\20\1\uffff\1\22\1\uffff\1\32\1"+
        "\uffff\1\10\6\uffff\1\27\1\4\1\14\1\21";
    static final String DFA20_specialS =
        "\1\2\25\uffff\1\0\4\uffff\1\4\51\uffff\1\3\6\uffff\1\1\41\uffff"+
        "\1\5\u009c\uffff}>";
    static final String[] DFA20_transitionS = {
            "\11\45\1\43\1\44\2\45\1\44\22\45\1\43\1\45\1\25\1\42\1\35\1"+
            "\45\1\37\1\45\1\31\1\32\2\45\1\24\1\45\1\1\14\45\1\26\1\45\1"+
            "\33\2\45\1\2\10\41\1\3\10\41\1\5\2\41\1\4\5\41\1\30\1\34\1\27"+
            "\1\45\1\41\1\45\1\11\1\6\1\7\1\12\1\40\1\13\2\40\1\14\1\40\1"+
            "\15\1\16\1\17\1\20\1\40\1\10\3\40\1\21\1\22\1\23\4\40\uff85"+
            "\45",
            "",
            "",
            "\1\50",
            "\1\52",
            "\1\53",
            "\1\56\62\uffff\1\54\31\55",
            "\1\56\62\uffff\1\57\3\55\1\60\11\55\1\61\13\55",
            "\1\56\62\uffff\1\63\15\55\1\64\2\55\1\62\10\55",
            "\1\56\62\uffff\13\55\1\65\16\55",
            "\1\56\62\uffff\1\66\3\55\1\67\25\55",
            "\1\56\62\uffff\1\71\15\55\1\70\13\55",
            "\1\56\62\uffff\6\55\1\72\23\55",
            "\1\56\62\uffff\4\55\1\73\25\55",
            "\1\56\62\uffff\1\74\31\55",
            "\1\56\62\uffff\1\75\15\55\1\76\13\55",
            "\1\56\62\uffff\24\55\1\77\5\55",
            "\1\56\62\uffff\21\55\1\100\10\55",
            "\1\56\62\uffff\15\55\1\101\14\55",
            "\1\56\62\uffff\10\55\1\102\21\55",
            "",
            "",
            "\12\106\1\uffff\2\106\1\uffff\24\106\1\104\30\106\1\uffff\uffc4"+
            "\106",
            "",
            "",
            "",
            "",
            "\12\114\1\uffff\2\114\1\uffff\36\114\1\115\16\114\1\115\37"+
            "\114\1\115\1\114\1\115\uffa2\114",
            "\1\116",
            "\32\117\4\uffff\1\117\1\uffff\32\117",
            "",
            "\32\120\4\uffff\1\120\1\uffff\32\120",
            "\1\56\62\uffff\32\55",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\123",
            "",
            "\1\124",
            "\1\125",
            "\1\56\62\uffff\23\55\1\126\6\55",
            "\1\56\62\uffff\32\55",
            "",
            "\1\56\62\uffff\2\55\1\127\27\55",
            "\1\56\62\uffff\13\55\1\130\16\55",
            "\1\56\62\uffff\13\55\1\131\16\55",
            "\1\56\62\uffff\16\55\1\132\13\55",
            "\1\56\62\uffff\23\55\1\133\6\55",
            "\1\56\62\uffff\22\55\1\134\7\55",
            "\1\56\62\uffff\10\55\1\135\2\55\1\136\16\55",
            "\1\56\62\uffff\23\55\1\137\6\55",
            "\1\56\62\uffff\5\55\1\140\24\55",
            "\1\56\62\uffff\21\55\1\141\10\55",
            "\1\56\62\uffff\13\55\1\142\16\55",
            "\1\56\62\uffff\15\55\1\143\14\55",
            "\1\56\62\uffff\30\55\1\144\1\55",
            "\1\56\62\uffff\15\55\1\145\14\55",
            "\1\56\62\uffff\17\55\1\146\12\55",
            "\1\56\62\uffff\3\55\1\147\26\55",
            "\1\56\62\uffff\14\55\1\150\15\55",
            "\1\56\62\uffff\1\151\23\55\1\152\5\55",
            "\1\56\62\uffff\10\55\1\153\21\55",
            "\1\56\62\uffff\21\55\1\154\10\55",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\114\1\uffff\2\114\1\uffff\36\114\1\115\16\114\1\115\37"+
            "\114\1\115\1\114\1\115\uffa2\114",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\56\62\uffff\2\55\1\162\27\55",
            "\1\56\62\uffff\7\55\1\163\22\55",
            "\1\56\62\uffff\13\55\1\164\16\55",
            "\1\56\62\uffff\13\55\1\165\16\55",
            "\1\56\62\uffff\2\55\1\166\27\55",
            "\1\56\62\uffff\7\55\1\167\22\55",
            "\1\56\1\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\55",
            "\1\56\62\uffff\1\171\31\55",
            "\1\56\62\uffff\16\55\1\172\13\55",
            "\1\56\62\uffff\4\55\1\173\25\55",
            "\1\56\62\uffff\1\174\31\55",
            "\1\56\62\uffff\2\55\1\175\27\55",
            "\1\56\62\uffff\22\55\1\176\7\55",
            "\1\56\62\uffff\16\55\1\177\13\55",
            "\1\56\3\uffff\1\u0080\56\uffff\32\55",
            "\1\56\62\uffff\6\55\1\u0081\23\55",
            "\1\u0082\1\56\62\uffff\32\55",
            "\1\56\62\uffff\4\55\1\u0083\25\55",
            "\1\56\62\uffff\1\55\1\u0084\30\55",
            "\1\56\62\uffff\15\55\1\u0085\14\55",
            "\1\56\62\uffff\4\55\1\u0086\25\55",
            "\1\56\62\uffff\20\55\1\u0087\11\55",
            "\1\56\62\uffff\23\55\1\u0088\6\55",
            "",
            "\1\uffff",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\56\62\uffff\7\55\1\u008d\22\55",
            "\1\56\62\uffff\4\55\1\u008e\25\55",
            "\1\56\25\uffff\1\u008f\34\uffff\32\55",
            "\1\56\62\uffff\4\55\1\u0090\25\55",
            "\1\56\62\uffff\4\55\1\u0091\25\55",
            "\1\u0092\1\56\62\uffff\32\55",
            "",
            "\1\56\62\uffff\22\55\1\u0093\7\55",
            "\1\56\62\uffff\26\55\1\u0094\3\55",
            "\1\56\62\uffff\5\55\1\u0095\24\55",
            "\1\56\62\uffff\24\55\1\u0096\5\55",
            "\1\56\62\uffff\4\55\1\u0097\25\55",
            "\1\56\62\uffff\4\55\1\u0098\25\55",
            "\1\56\62\uffff\21\55\1\u0099\10\55",
            "\1\u009a",
            "\1\56\1\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\55",
            "",
            "\1\56\1\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\55",
            "\1\56\62\uffff\4\55\1\u009d\25\55",
            "\1\56\62\uffff\22\55\1\u009e\7\55",
            "\1\56\1\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\55",
            "\1\56\62\uffff\24\55\1\u00a0\5\55",
            "\1\56\62\uffff\24\55\1\u00a1\5\55",
            "",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\56\62\uffff\14\55\1\u00a5\15\55",
            "\1\56\46\uffff\1\u00a6\13\uffff\32\55",
            "\1\u00a7",
            "\1\56\62\uffff\2\55\1\u00a8\27\55",
            "\1\56\62\uffff\22\55\1\u00a9\7\55",
            "",
            "\1\56\1\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\55",
            "\1\56\62\uffff\15\55\1\u00ab\14\55",
            "\1\56\62\uffff\16\55\1\u00ac\13\55",
            "\1\56\62\uffff\13\55\1\u00ad\16\55",
            "\1\56\50\uffff\1\u00ae\11\uffff\32\55",
            "\1\56\1\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\55",
            "\1\56\62\uffff\4\55\1\u00af\25\55",
            "\1\u00b0",
            "",
            "",
            "\1\56\62\uffff\21\55\1\u00b1\10\55",
            "\1\56\62\uffff\13\55\1\u00b2\16\55",
            "",
            "\1\56\62\uffff\4\55\1\u00b3\25\55",
            "\1\56\62\uffff\1\u00b4\31\55",
            "\12\51\7\uffff\32\51\4\uffff\1\u00b5\1\uffff\32\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\56\62\uffff\16\55\1\u00b9\13\55",
            "\1\u00ba",
            "\1\u00bb",
            "\1\56\62\uffff\23\55\1\u00bc\6\55",
            "\1\56\62\uffff\22\55\1\u00bd\7\55",
            "",
            "\1\56\62\uffff\24\55\1\u00be\5\55",
            "\1\56\62\uffff\21\55\1\u00bf\10\55",
            "\1\56\62\uffff\23\55\1\u00c0\6\55",
            "\1\u00c1",
            "\1\56\34\uffff\1\u00c2\25\uffff\15\55\1\u00c3\14\55",
            "\1\u00c4",
            "\1\56\62\uffff\5\55\1\u00c5\24\55",
            "\1\56\62\uffff\1\u00c6\31\55",
            "\1\56\1\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\55",
            "\1\56\62\uffff\13\55\1\u00c8\16\55",
            "\1\u00c9",
            "",
            "",
            "",
            "\1\56\62\uffff\3\55\1\u00ca\26\55",
            "\1\u00cb",
            "\1\u00cc",
            "\1\56\62\uffff\10\55\1\u00cd\21\55",
            "\1\56\62\uffff\16\55\1\u00ce\13\55",
            "\1\56\62\uffff\13\55\1\u00cf\16\55",
            "\1\56\62\uffff\14\55\1\u00d0\15\55",
            "\1\56\1\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\55",
            "\1\u00d2",
            "\1\u00d3",
            "\1\56\62\uffff\24\55\1\u00d4\5\55",
            "\1\u00d5",
            "\1\56\62\uffff\16\55\1\u00d6\13\55",
            "\1\56\62\uffff\23\55\1\u00d7\6\55",
            "",
            "\1\56\1\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\55",
            "\1\u00d9",
            "\1\56\62\uffff\4\55\1\u00da\25\55",
            "\1\u00db",
            "\1\u00dc",
            "\1\56\62\uffff\16\55\1\u00dd\13\55",
            "\1\56\62\uffff\21\55\1\u00de\10\55",
            "\1\56\62\uffff\13\55\1\u00df\16\55",
            "\1\56\62\uffff\1\u00e0\31\55",
            "",
            "\1\u00e1",
            "\1\u00e2",
            "\1\56\62\uffff\13\55\1\u00e3\16\55",
            "\1\u00e4",
            "\1\56\62\uffff\21\55\1\u00e5\10\55",
            "\1\56\62\uffff\16\55\1\u00e6\13\55",
            "",
            "\1\u00e7",
            "\1\56\1\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\55",
            "\1\u00e9",
            "\1\u00ea",
            "\1\56\62\uffff\15\55\1\u00eb\14\55",
            "\1\56\1\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\55",
            "\1\56\1\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\55",
            "\1\56\62\uffff\23\55\1\u00ee\6\55",
            "\1\u00ef",
            "\1\u00f0",
            "\1\56\62\uffff\13\55\1\u00f1\16\55",
            "\1\u00f2",
            "\1\56\62\uffff\14\55\1\u00f3\15\55",
            "\1\56\62\uffff\21\55\1\u00f4\10\55",
            "\1\u00f5",
            "",
            "\1\u00f6",
            "\1\u00f7",
            "\1\u00f8\1\56\62\uffff\32\55",
            "",
            "",
            "\1\56\1\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\55",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u00fb",
            "\1\56\1\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\55",
            "",
            "\1\56\62\uffff\1\u00fd\31\55",
            "\1\56\1\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\55",
            "\1\u00ff",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\1\u0101",
            "",
            "",
            "",
            "\1\u0102",
            "",
            "\1\56\62\uffff\23\55\1\u0103\6\55",
            "",
            "\1\u0104",
            "",
            "\1\u0105",
            "\1\u0106",
            "\1\56\1\uffff\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\55",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "\12\51\7\uffff\32\51\4\uffff\1\51\1\uffff\32\51",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA20_eot = DFA.unpackEncodedString(DFA20_eotS);
    static final short[] DFA20_eof = DFA.unpackEncodedString(DFA20_eofS);
    static final char[] DFA20_min = DFA.unpackEncodedStringToUnsignedChars(DFA20_minS);
    static final char[] DFA20_max = DFA.unpackEncodedStringToUnsignedChars(DFA20_maxS);
    static final short[] DFA20_accept = DFA.unpackEncodedString(DFA20_acceptS);
    static final short[] DFA20_special = DFA.unpackEncodedString(DFA20_specialS);
    static final short[][] DFA20_transition;

    static {
        int numStates = DFA20_transitionS.length;
        DFA20_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA20_transition[i] = DFA.unpackEncodedString(DFA20_transitionS[i]);
        }
    }

    class DFA20 extends DFA {

        public DFA20(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 20;
            this.eot = DFA20_eot;
            this.eof = DFA20_eof;
            this.min = DFA20_min;
            this.max = DFA20_max;
            this.accept = DFA20_accept;
            this.special = DFA20_special;
            this.transition = DFA20_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__71 | T__72 | Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual | Comma | DoubleQuote | Semicolon | RightBracket | LeftBracket | LeftParenthesis | RightParenthesis | Equals | LineContinuation | Bool | Macrodef | Macroval | ArgumentModifierval | DocumentId | Identifier | Classname | Comment | QuotedField | Field | Ws | Lb | Char );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA20_22 = input.LA(1);

                         
                        int index20_22 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA20_22=='\"') ) {s = 68;}

                        else if ( ((LA20_22 >= '\u0000' && LA20_22 <= '\t')||(LA20_22 >= '\u000B' && LA20_22 <= '\f')||(LA20_22 >= '\u000E' && LA20_22 <= '!')||(LA20_22 >= '#' && LA20_22 <= ':')||(LA20_22 >= '<' && LA20_22 <= '\uFFFF')) && ((isHeader() == false))) {s = 70;}

                        else s = 69;

                         
                        input.seek(index20_22);

                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA20_76 = input.LA(1);

                         
                        int index20_76 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA20_76 >= '\u0000' && LA20_76 <= '\t')||(LA20_76 >= '\u000B' && LA20_76 <= '\f')||(LA20_76 >= '\u000E' && LA20_76 <= '+')||(LA20_76 >= '-' && LA20_76 <= ':')||(LA20_76 >= '<' && LA20_76 <= 'Z')||LA20_76=='\\'||(LA20_76 >= '^' && LA20_76 <= '\uFFFF')) && (((isArgumentModifierAssignment())||(isMacroAssignment())))) {s = 76;}

                        else if ( (LA20_76==','||LA20_76==';'||LA20_76=='['||LA20_76==']') && ((isMacroAssignment()))) {s = 77;}

                        else s = 110;

                         
                        input.seek(index20_76);

                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA20_0 = input.LA(1);

                        s = -1;
                        if ( (LA20_0=='.') ) {s = 1;}

                        else if ( (LA20_0=='@') ) {s = 2;}

                        else if ( (LA20_0=='I') ) {s = 3;}

                        else if ( (LA20_0=='U') ) {s = 4;}

                        else if ( (LA20_0=='R') ) {s = 5;}

                        else if ( (LA20_0=='b') ) {s = 6;}

                        else if ( (LA20_0=='c') ) {s = 7;}

                        else if ( (LA20_0=='p') ) {s = 8;}

                        else if ( (LA20_0=='a') ) {s = 9;}

                        else if ( (LA20_0=='d') ) {s = 10;}

                        else if ( (LA20_0=='f') ) {s = 11;}

                        else if ( (LA20_0=='i') ) {s = 12;}

                        else if ( (LA20_0=='k') ) {s = 13;}

                        else if ( (LA20_0=='l') ) {s = 14;}

                        else if ( (LA20_0=='m') ) {s = 15;}

                        else if ( (LA20_0=='n') ) {s = 16;}

                        else if ( (LA20_0=='t') ) {s = 17;}

                        else if ( (LA20_0=='u') ) {s = 18;}

                        else if ( (LA20_0=='v') ) {s = 19;}

                        else if ( (LA20_0==',') ) {s = 20;}

                        else if ( (LA20_0=='\"') ) {s = 21;}

                        else if ( (LA20_0==';') ) {s = 22;}

                        else if ( (LA20_0==']') ) {s = 23;}

                        else if ( (LA20_0=='[') ) {s = 24;}

                        else if ( (LA20_0=='(') ) {s = 25;}

                        else if ( (LA20_0==')') ) {s = 26;}

                        else if ( (LA20_0=='=') ) {s = 27;}

                        else if ( (LA20_0=='\\') ) {s = 28;}

                        else if ( (LA20_0=='$') ) {s = 29;}

                        else if ( (LA20_0=='&') ) {s = 31;}

                        else if ( (LA20_0=='e'||(LA20_0 >= 'g' && LA20_0 <= 'h')||LA20_0=='j'||LA20_0=='o'||(LA20_0 >= 'q' && LA20_0 <= 's')||(LA20_0 >= 'w' && LA20_0 <= 'z')) ) {s = 32;}

                        else if ( ((LA20_0 >= 'A' && LA20_0 <= 'H')||(LA20_0 >= 'J' && LA20_0 <= 'Q')||(LA20_0 >= 'S' && LA20_0 <= 'T')||(LA20_0 >= 'V' && LA20_0 <= 'Z')||LA20_0=='_') ) {s = 33;}

                        else if ( (LA20_0=='#') ) {s = 34;}

                        else if ( (LA20_0=='\t'||LA20_0==' ') ) {s = 35;}

                        else if ( (LA20_0=='\n'||LA20_0=='\r') ) {s = 36;}

                        else if ( ((LA20_0 >= '\u0000' && LA20_0 <= '\b')||(LA20_0 >= '\u000B' && LA20_0 <= '\f')||(LA20_0 >= '\u000E' && LA20_0 <= '\u001F')||LA20_0=='!'||LA20_0=='%'||LA20_0=='\''||(LA20_0 >= '*' && LA20_0 <= '+')||LA20_0=='-'||(LA20_0 >= '/' && LA20_0 <= ':')||LA20_0=='<'||(LA20_0 >= '>' && LA20_0 <= '?')||LA20_0=='^'||LA20_0=='`'||(LA20_0 >= '{' && LA20_0 <= '\uFFFF')) ) {s = 37;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA20_69 = input.LA(1);

                         
                        int index20_69 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((isHeader() == false)))) ) {s = 109;}

                        else if ( ((isHeader() == false)) ) {s = 70;}

                         
                        input.seek(index20_69);

                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA20_27 = input.LA(1);

                         
                        int index20_27 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA20_27 >= '\u0000' && LA20_27 <= '\t')||(LA20_27 >= '\u000B' && LA20_27 <= '\f')||(LA20_27 >= '\u000E' && LA20_27 <= '+')||(LA20_27 >= '-' && LA20_27 <= ':')||(LA20_27 >= '<' && LA20_27 <= 'Z')||LA20_27=='\\'||(LA20_27 >= '^' && LA20_27 <= '\uFFFF')) && (((isArgumentModifierAssignment())||(isMacroAssignment())))) {s = 76;}

                        else if ( (LA20_27==','||LA20_27==';'||LA20_27=='['||LA20_27==']') && ((isMacroAssignment()))) {s = 77;}

                        else s = 75;

                         
                        input.seek(index20_27);

                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA20_110 = input.LA(1);

                         
                        int index20_110 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((isMacroAssignment())) ) {s = 77;}

                        else if ( ((isArgumentModifierAssignment())) ) {s = 137;}

                         
                        input.seek(index20_110);

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 20, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}