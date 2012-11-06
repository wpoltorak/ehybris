// $ANTLR 3.4 /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g 2012-11-06 22:45:30

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
    public static final int DocumentID=26;
    public static final int Dot=27;
    public static final int DoubleQuote=28;
    public static final int Equals=29;
    public static final int FIELDS=30;
    public static final int Field=31;
    public static final int ForceWrite=32;
    public static final int HEADER=33;
    public static final int HeaderMode=34;
    public static final int HeaderModifier=35;
    public static final int IMPEX=36;
    public static final int Identifier=37;
    public static final int IgnoreKeyCase=38;
    public static final int IgnoreNull=39;
    public static final int Insert=40;
    public static final int InsertUpdate=41;
    public static final int KeyToValueDelimiter=42;
    public static final int LBracket=43;
    public static final int LParenthesis=44;
    public static final int Lang=45;
    public static final int Lb=46;
    public static final int MODIFIER=47;
    public static final int MODIFIERS=48;
    public static final int Macrodef=49;
    public static final int Macroval=50;
    public static final int MapDelimiter=51;
    public static final int Mode=52;
    public static final int NextRow=53;
    public static final int NumberFormat=54;
    public static final int PathDelimiter=55;
    public static final int Pos=56;
    public static final int Processor=57;
    public static final int QuotedField=58;
    public static final int RBracket=59;
    public static final int RECORD=60;
    public static final int RECORDS=61;
    public static final int RParenthesis=62;
    public static final int Remove=63;
    public static final int SUBTYPE=64;
    public static final int Semicolon=65;
    public static final int SpecialAttribute=66;
    public static final int TYPE=67;
    public static final int Translator=68;
    public static final int Unique=69;
    public static final int Update=70;
    public static final int Virtual=71;
    public static final int Ws=72;



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

    // $ANTLR start "Insert"
    public final void mInsert() throws RecognitionException {
        try {
            int _type = Insert;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:212:4: ( 'INSERT' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:212:5: 'INSERT'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:213:15: ( 'INSERT_UPDATE' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:213:16: 'INSERT_UPDATE'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:214:9: ( 'UPDATE' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:214:10: 'UPDATE'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:215:9: ( 'REMOVE' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:215:10: 'REMOVE'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:222:11: ( 'batchmode' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:222:12: 'batchmode'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:223:13: ( 'cacheUnique' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:223:14: 'cacheUnique'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:224:11: ( 'processor' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:224:12: 'processor'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:226:8: ( 'alias' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:226:9: 'alias'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:227:12: ( 'allownull' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:227:13: 'allownull'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:228:15: ( 'cellDecorator' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:228:16: 'cellDecorator'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:229:22: ( 'collection-delimiter' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:229:23: 'collection-delimiter'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:230:13: ( 'dateformat' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:230:14: 'dateformat'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:231:10: ( 'default' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:231:11: 'default'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:232:13: ( 'forceWrite' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:232:14: 'forceWrite'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:233:15: ( 'ignoreKeyCase' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:233:16: 'ignoreKeyCase'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:234:13: ( 'ignorenull' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:234:14: 'ignorenull'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:235:21: ( 'key2value-delimiter' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:235:22: 'key2value-delimiter'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:236:7: ( 'lang' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:236:8: 'lang'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:237:14: ( 'map-delimiter' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:237:15: 'map-delimiter'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:238:7: ( 'mode' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:238:8: 'mode'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:239:14: ( 'numberformat' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:239:15: 'numberformat'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:240:15: ( 'path-delimiter' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:240:16: 'path-delimiter'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:241:6: ( 'pos' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:241:7: 'pos'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:242:13: ( 'translator' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:242:14: 'translator'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:243:9: ( 'unique' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:243:10: 'unique'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:244:10: ( 'virtual' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:244:11: 'virtual'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:247:8: ( ',' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:247:9: ','
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

    // $ANTLR start "Dot"
    public final void mDot() throws RecognitionException {
        try {
            int _type = Dot;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:248:5: ( '.' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:248:6: '.'
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
    // $ANTLR end "Dot"

    // $ANTLR start "DoubleQuote"
    public final void mDoubleQuote() throws RecognitionException {
        try {
            int _type = DoubleQuote;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:249:13: ( '\"' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:249:14: '\"'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:250:11: ( ';' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:250:12: ';'
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

    // $ANTLR start "RBracket"
    public final void mRBracket() throws RecognitionException {
        try {
            int _type = RBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:251:10: ( ']' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:251:11: ']'
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
    // $ANTLR end "RBracket"

    // $ANTLR start "LBracket"
    public final void mLBracket() throws RecognitionException {
        try {
            int _type = LBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:252:10: ( '[' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:252:11: '['
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
    // $ANTLR end "LBracket"

    // $ANTLR start "LParenthesis"
    public final void mLParenthesis() throws RecognitionException {
        try {
            int _type = LParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:253:15: ( '(' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:253:16: '('
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
    // $ANTLR end "LParenthesis"

    // $ANTLR start "RParenthesis"
    public final void mRParenthesis() throws RecognitionException {
        try {
            int _type = RParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:254:14: ( ')' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:254:15: ')'
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
    // $ANTLR end "RParenthesis"

    // $ANTLR start "Equals"
    public final void mEquals() throws RecognitionException {
        try {
            int _type = Equals;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:255:8: ( '=' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:255:9: '='
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

    // $ANTLR start "Bool"
    public final void mBool() throws RecognitionException {
        try {
            int _type = Bool;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:257:6: ( 'true' | 'false' )
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
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:257:7: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:257:16: 'false'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:260:2: ( Insert | InsertUpdate | Update | Remove )
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
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:260:4: Insert
                    {
                    mInsert(); 


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:260:13: InsertUpdate
                    {
                    mInsertUpdate(); 


                    }
                    break;
                case 3 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:260:28: Update
                    {
                    mUpdate(); 


                    }
                    break;
                case 4 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:260:37: Remove
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:263:2: ( BatchMode | CacheUnique | Processor )
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
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:263:3: BatchMode
                    {
                    mBatchMode(); 


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:263:15: CacheUnique
                    {
                    mCacheUnique(); 


                    }
                    break;
                case 3 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:263:29: Processor
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:266:2: ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual )
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
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:266:3: Alias
                    {
                    mAlias(); 


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:266:11: AllowNull
                    {
                    mAllowNull(); 


                    }
                    break;
                case 3 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:266:23: CellDecorator
                    {
                    mCellDecorator(); 


                    }
                    break;
                case 4 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:266:39: CollectionDelimiter
                    {
                    mCollectionDelimiter(); 


                    }
                    break;
                case 5 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:266:61: Dateformat
                    {
                    mDateformat(); 


                    }
                    break;
                case 6 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:266:74: Default
                    {
                    mDefault(); 


                    }
                    break;
                case 7 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:266:84: ForceWrite
                    {
                    mForceWrite(); 


                    }
                    break;
                case 8 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:266:97: IgnoreKeyCase
                    {
                    mIgnoreKeyCase(); 


                    }
                    break;
                case 9 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:266:113: IgnoreNull
                    {
                    mIgnoreNull(); 


                    }
                    break;
                case 10 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:267:4: KeyToValueDelimiter
                    {
                    mKeyToValueDelimiter(); 


                    }
                    break;
                case 11 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:267:26: Lang
                    {
                    mLang(); 


                    }
                    break;
                case 12 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:267:33: MapDelimiter
                    {
                    mMapDelimiter(); 


                    }
                    break;
                case 13 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:267:48: Mode
                    {
                    mMode(); 


                    }
                    break;
                case 14 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:267:55: NumberFormat
                    {
                    mNumberFormat(); 


                    }
                    break;
                case 15 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:267:70: PathDelimiter
                    {
                    mPathDelimiter(); 


                    }
                    break;
                case 16 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:267:86: Pos
                    {
                    mPos(); 


                    }
                    break;
                case 17 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:267:92: Translator
                    {
                    mTranslator(); 


                    }
                    break;
                case 18 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:267:105: Unique
                    {
                    mUnique(); 


                    }
                    break;
                case 19 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:267:114: Virtual
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:270:2: ( '$' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:270:3: '$' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:270:39: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:275:2: ({...}? => ( '=' (~ ( '\\r' | '\\n' ) )* ) |)
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
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:275:3: {...}? => ( '=' (~ ( '\\r' | '\\n' ) )* )
                    {
                    if ( !((isMacroAssignment())) ) {
                        throw new FailedPredicateException(input, "Macroval", "isMacroAssignment()");
                    }

                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:275:28: ( '=' (~ ( '\\r' | '\\n' ) )* )
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:275:29: '=' (~ ( '\\r' | '\\n' ) )*
                    {
                    match('='); 

                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:275:32: (~ ( '\\r' | '\\n' ) )*
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
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:276:3: 
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:286:3: ({...}? => '=' (~ ( '\\r' | '\\n' | ';' | '[' | ']' | ',' ) )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:286:4: {...}? => '=' (~ ( '\\r' | '\\n' | ';' | '[' | ']' | ',' ) )*
            {
            if ( !((isArgumentModifierAssignment())) ) {
                throw new FailedPredicateException(input, "ArgumentModifierval", "isArgumentModifierAssignment()");
            }

            match('='); 

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:286:43: (~ ( '\\r' | '\\n' | ';' | '[' | ']' | ',' ) )*
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

    // $ANTLR start "SpecialAttribute"
    public final void mSpecialAttribute() throws RecognitionException {
        try {
            int _type = SpecialAttribute;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:289:2: ( '@' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:289:3: '@' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            match('@'); 

            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:289:39: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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
    // $ANTLR end "SpecialAttribute"

    // $ANTLR start "DocumentID"
    public final void mDocumentID() throws RecognitionException {
        try {
            int _type = DocumentID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:292:2: ( '&' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:292:3: '&' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:292:39: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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
    // $ANTLR end "DocumentID"

    // $ANTLR start "Identifier"
    public final void mIdentifier() throws RecognitionException {
        try {
            int _type = Identifier;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:295:2: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:295:3: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:295:35: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0 >= '0' && LA11_0 <= '9')||(LA11_0 >= 'A' && LA11_0 <= 'Z')||LA11_0=='_'||(LA11_0 >= 'a' && LA11_0 <= 'z')) ) {
                    alt11=1;
                }


                switch (alt11) {
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
            	    break loop11;
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:298:2: ( ( ( 'a' .. 'z' )+ '.' )+ 'A' .. 'Z' ( 'A' .. 'Z' | 'a' .. 'z' )+ )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:298:3: ( ( 'a' .. 'z' )+ '.' )+ 'A' .. 'Z' ( 'A' .. 'Z' | 'a' .. 'z' )+
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:298:3: ( ( 'a' .. 'z' )+ '.' )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0 >= 'a' && LA13_0 <= 'z')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:298:4: ( 'a' .. 'z' )+ '.'
            	    {
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:298:4: ( 'a' .. 'z' )+
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
            	    	    if ( cnt12 >= 1 ) break loop12;
            	                EarlyExitException eee =
            	                    new EarlyExitException(12, input);
            	                throw eee;
            	        }
            	        cnt12++;
            	    } while (true);


            	    match('.'); 

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


            matchRange('A','Z'); 

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:298:35: ( 'A' .. 'Z' | 'a' .. 'z' )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0 >= 'A' && LA14_0 <= 'Z')||(LA14_0 >= 'a' && LA14_0 <= 'z')) ) {
                    alt14=1;
                }


                switch (alt14) {
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
            	    if ( cnt14 >= 1 ) break loop14;
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:302:2: ( '#' (~ ( '\\r' | '\\n' ) )* ( Lb )? )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:302:3: '#' (~ ( '\\r' | '\\n' ) )* ( Lb )?
            {
            match('#'); 

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:302:7: (~ ( '\\r' | '\\n' ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( ((LA15_0 >= '\u0000' && LA15_0 <= '\t')||(LA15_0 >= '\u000B' && LA15_0 <= '\f')||(LA15_0 >= '\u000E' && LA15_0 <= '\uFFFF')) ) {
                    alt15=1;
                }


                switch (alt15) {
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
            	    break loop15;
                }
            } while (true);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:302:23: ( Lb )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='\n'||LA16_0=='\r') ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:302:23: Lb
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:309:2: ( ';' '\"' ( Char | '\"' '\"' | ';' )* '\"' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:309:3: ';' '\"' ( Char | '\"' '\"' | ';' )* '\"'
            {
            match(';'); 

            match('\"'); 

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:309:11: ( Char | '\"' '\"' | ';' )*
            loop17:
            do {
                int alt17=4;
                int LA17_0 = input.LA(1);

                if ( (LA17_0=='\"') ) {
                    int LA17_1 = input.LA(2);

                    if ( (LA17_1=='\"') ) {
                        alt17=2;
                    }


                }
                else if ( ((LA17_0 >= '\u0000' && LA17_0 <= '\t')||(LA17_0 >= '\u000B' && LA17_0 <= '\f')||(LA17_0 >= '\u000E' && LA17_0 <= '!')||(LA17_0 >= '#' && LA17_0 <= ':')||(LA17_0 >= '<' && LA17_0 <= '\uFFFF')) ) {
                    alt17=1;
                }
                else if ( (LA17_0==';') ) {
                    alt17=3;
                }


                switch (alt17) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:309:12: Char
            	    {
            	    mChar(); 


            	    }
            	    break;
            	case 2 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:309:19: '\"' '\"'
            	    {
            	    match('\"'); 

            	    match('\"'); 

            	    }
            	    break;
            	case 3 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:309:29: ';'
            	    {
            	    match(';'); 

            	    }
            	    break;

            	default :
            	    break loop17;
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:313:2: ({...}? => ';' ( Char )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:313:3: {...}? => ';' ( Char )*
            {
            if ( !((isHeader() == false)) ) {
                throw new FailedPredicateException(input, "Field", "isHeader() == false");
            }

            match(';'); 

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:313:32: ( Char )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0 >= '\u0000' && LA18_0 <= '\t')||(LA18_0 >= '\u000B' && LA18_0 <= '\f')||(LA18_0 >= '\u000E' && LA18_0 <= '!')||(LA18_0 >= '#' && LA18_0 <= ':')||(LA18_0 >= '<' && LA18_0 <= '\uFFFF')) ) {
                    alt18=1;
                }


                switch (alt18) {
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
            	    break loop18;
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:332:4: ( ( ' ' | '\\t' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:332:5: ( ' ' | '\\t' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:333:4: ( ( ( '\\r' )? '\\n' | '\\r' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:333:5: ( ( '\\r' )? '\\n' | '\\r' )
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:333:5: ( ( '\\r' )? '\\n' | '\\r' )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0=='\r') ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1=='\n') ) {
                    alt20=1;
                }
                else {
                    alt20=2;
                }
            }
            else if ( (LA20_0=='\n') ) {
                alt20=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;

            }
            switch (alt20) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:333:6: ( '\\r' )? '\\n'
                    {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:333:6: ( '\\r' )?
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0=='\r') ) {
                        alt19=1;
                    }
                    switch (alt19) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:333:6: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:333:19: '\\r'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:334:6: (~ ( '\\r' | '\\n' | '\"' | ';' ) )
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

    // $ANTLR start "NextRow"
    public final void mNextRow() throws RecognitionException {
        try {
            int _type = NextRow;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:336:9: ( '\\\\\\\\' ( Ws )* Lb )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:336:10: '\\\\\\\\' ( Ws )* Lb
            {
            match("\\\\"); 



            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:336:17: ( Ws )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0=='\t'||LA21_0==' ') ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:336:17: Ws
            	    {
            	    mWs(); 


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);


            mLb(); 


            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NextRow"

    public void mTokens() throws RecognitionException {
        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:8: ( Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual | Comma | Dot | DoubleQuote | Semicolon | RBracket | LBracket | LParenthesis | RParenthesis | Equals | Bool | Macrodef | Macroval | ArgumentModifierval | SpecialAttribute | DocumentID | Identifier | Classname | Comment | QuotedField | Field | Ws | Lb | Char | NextRow )
        int alt22=50;
        alt22 = dfa22.predict(input);
        switch (alt22) {
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
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:92: CellDecorator
                {
                mCellDecorator(); 


                }
                break;
            case 11 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:106: CollectionDelimiter
                {
                mCollectionDelimiter(); 


                }
                break;
            case 12 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:126: Dateformat
                {
                mDateformat(); 


                }
                break;
            case 13 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:137: Default
                {
                mDefault(); 


                }
                break;
            case 14 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:145: ForceWrite
                {
                mForceWrite(); 


                }
                break;
            case 15 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:156: IgnoreKeyCase
                {
                mIgnoreKeyCase(); 


                }
                break;
            case 16 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:170: IgnoreNull
                {
                mIgnoreNull(); 


                }
                break;
            case 17 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:181: KeyToValueDelimiter
                {
                mKeyToValueDelimiter(); 


                }
                break;
            case 18 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:201: Lang
                {
                mLang(); 


                }
                break;
            case 19 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:206: MapDelimiter
                {
                mMapDelimiter(); 


                }
                break;
            case 20 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:219: Mode
                {
                mMode(); 


                }
                break;
            case 21 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:224: NumberFormat
                {
                mNumberFormat(); 


                }
                break;
            case 22 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:237: PathDelimiter
                {
                mPathDelimiter(); 


                }
                break;
            case 23 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:251: Pos
                {
                mPos(); 


                }
                break;
            case 24 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:255: Translator
                {
                mTranslator(); 


                }
                break;
            case 25 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:266: Unique
                {
                mUnique(); 


                }
                break;
            case 26 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:273: Virtual
                {
                mVirtual(); 


                }
                break;
            case 27 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:281: Comma
                {
                mComma(); 


                }
                break;
            case 28 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:287: Dot
                {
                mDot(); 


                }
                break;
            case 29 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:291: DoubleQuote
                {
                mDoubleQuote(); 


                }
                break;
            case 30 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:303: Semicolon
                {
                mSemicolon(); 


                }
                break;
            case 31 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:313: RBracket
                {
                mRBracket(); 


                }
                break;
            case 32 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:322: LBracket
                {
                mLBracket(); 


                }
                break;
            case 33 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:331: LParenthesis
                {
                mLParenthesis(); 


                }
                break;
            case 34 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:344: RParenthesis
                {
                mRParenthesis(); 


                }
                break;
            case 35 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:357: Equals
                {
                mEquals(); 


                }
                break;
            case 36 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:364: Bool
                {
                mBool(); 


                }
                break;
            case 37 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:369: Macrodef
                {
                mMacrodef(); 


                }
                break;
            case 38 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:378: Macroval
                {
                mMacroval(); 


                }
                break;
            case 39 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:387: ArgumentModifierval
                {
                mArgumentModifierval(); 


                }
                break;
            case 40 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:407: SpecialAttribute
                {
                mSpecialAttribute(); 


                }
                break;
            case 41 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:424: DocumentID
                {
                mDocumentID(); 


                }
                break;
            case 42 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:435: Identifier
                {
                mIdentifier(); 


                }
                break;
            case 43 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:446: Classname
                {
                mClassname(); 


                }
                break;
            case 44 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:456: Comment
                {
                mComment(); 


                }
                break;
            case 45 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:464: QuotedField
                {
                mQuotedField(); 


                }
                break;
            case 46 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:476: Field
                {
                mField(); 


                }
                break;
            case 47 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:482: Ws
                {
                mWs(); 


                }
                break;
            case 48 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:485: Lb
                {
                mLb(); 


                }
                break;
            case 49 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:488: Char
                {
                mChar(); 


                }
                break;
            case 50 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:493: NextRow
                {
                mNextRow(); 


                }
                break;

        }

    }


    protected DFA22 dfa22 = new DFA22(this);
    static final String DFA22_eotS =
        "\1\34\21\47\3\uffff\1\104\4\uffff\1\112\1\45\1\uffff\2\45\1\47\4"+
        "\uffff\1\45\1\uffff\1\47\1\uffff\4\47\1\uffff\24\47\12\uffff\1\156"+
        "\7\uffff\11\47\1\170\20\47\2\uffff\11\47\1\uffff\10\47\1\u009b\1"+
        "\uffff\1\u009c\2\47\1\u009f\2\47\1\uffff\10\47\1\uffff\1\u00aa\4"+
        "\47\1\u009f\2\47\2\uffff\2\47\1\uffff\2\47\1\u00b6\1\u00b7\1\u00b8"+
        "\5\47\1\uffff\10\47\1\u00c7\2\47\3\uffff\7\47\1\u00d1\6\47\1\uffff"+
        "\1\u00d8\10\47\1\uffff\6\47\1\uffff\1\47\1\u00e8\3\47\1\u00ec\1"+
        "\u00ed\10\47\1\uffff\3\47\2\uffff\1\u00f9\1\u00fa\1\47\1\u00fc\1"+
        "\uffff\1\47\1\u00fe\1\47\1\u0100\1\47\3\uffff\1\47\1\uffff\1\47"+
        "\1\uffff\1\47\1\uffff\2\47\1\u0107\1\u0108\1\u0109\1\u010a\4\uffff";
    static final String DFA22_eofS =
        "\u010b\uffff";
    static final String DFA22_minS =
        "\1\0\1\116\1\120\1\105\16\56\3\uffff\1\0\4\uffff\1\0\1\101\1\uffff"+
        "\2\101\1\56\4\uffff\1\134\1\uffff\1\123\1\uffff\1\104\1\115\2\56"+
        "\1\uffff\24\56\3\uffff\1\0\6\uffff\1\0\7\uffff\1\105\1\101\1\117"+
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
    static final String DFA22_maxS =
        "\1\uffff\1\116\1\120\1\105\16\172\3\uffff\1\uffff\4\uffff\1\uffff"+
        "\1\172\1\uffff\3\172\4\uffff\1\134\1\uffff\1\123\1\uffff\1\104\1"+
        "\115\2\172\1\uffff\24\172\3\uffff\1\0\6\uffff\1\uffff\7\uffff\1"+
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
    static final String DFA22_acceptS =
        "\22\uffff\1\33\1\34\1\35\1\uffff\1\37\1\40\1\41\1\42\2\uffff\1\46"+
        "\3\uffff\1\52\1\54\1\57\1\60\1\uffff\1\61\1\uffff\1\52\4\uffff\1"+
        "\53\24\uffff\1\33\1\34\1\55\1\uffff\1\56\1\37\1\40\1\41\1\42\1\43"+
        "\1\uffff\1\46\1\45\1\50\1\51\1\54\1\57\1\62\32\uffff\1\36\12\uffff"+
        "\1\27\11\uffff\1\23\6\uffff\1\47\10\uffff\1\26\10\uffff\1\22\1\24"+
        "\2\uffff\1\44\12\uffff\1\10\13\uffff\1\1\1\3\1\4\16\uffff\1\31\11"+
        "\uffff\1\15\6\uffff\1\32\17\uffff\1\5\3\uffff\1\7\1\11\4\uffff\1"+
        "\21\5\uffff\1\13\1\14\1\16\1\uffff\1\20\1\uffff\1\30\1\uffff\1\6"+
        "\6\uffff\1\25\1\2\1\12\1\17";
    static final String DFA22_specialS =
        "\1\5\24\uffff\1\1\4\uffff\1\2\51\uffff\1\4\6\uffff\1\0\42\uffff"+
        "\1\3\u009c\uffff}>";
    static final String[] DFA22_transitionS = {
            "\11\45\1\42\1\43\2\45\1\43\22\45\1\42\1\45\1\24\1\41\1\33\1"+
            "\45\1\36\1\45\1\30\1\31\2\45\1\22\1\45\1\23\14\45\1\25\1\45"+
            "\1\32\2\45\1\35\10\40\1\1\10\40\1\3\2\40\1\2\5\40\1\27\1\44"+
            "\1\26\1\45\1\40\1\45\1\7\1\4\1\5\1\10\1\37\1\11\2\37\1\12\1"+
            "\37\1\13\1\14\1\15\1\16\1\37\1\6\3\37\1\17\1\20\1\21\4\37\uff85"+
            "\45",
            "\1\46",
            "\1\50",
            "\1\51",
            "\1\54\62\uffff\1\52\31\53",
            "\1\54\62\uffff\1\55\3\53\1\56\11\53\1\57\13\53",
            "\1\54\62\uffff\1\61\15\53\1\62\2\53\1\60\10\53",
            "\1\54\62\uffff\13\53\1\63\16\53",
            "\1\54\62\uffff\1\64\3\53\1\65\25\53",
            "\1\54\62\uffff\1\67\15\53\1\66\13\53",
            "\1\54\62\uffff\6\53\1\70\23\53",
            "\1\54\62\uffff\4\53\1\71\25\53",
            "\1\54\62\uffff\1\72\31\53",
            "\1\54\62\uffff\1\73\15\53\1\74\13\53",
            "\1\54\62\uffff\24\53\1\75\5\53",
            "\1\54\62\uffff\21\53\1\76\10\53",
            "\1\54\62\uffff\15\53\1\77\14\53",
            "\1\54\62\uffff\10\53\1\100\21\53",
            "",
            "",
            "",
            "\12\105\1\uffff\2\105\1\uffff\24\105\1\103\30\105\1\uffff\uffc4"+
            "\105",
            "",
            "",
            "",
            "",
            "\12\113\1\uffff\2\113\1\uffff\36\113\1\114\16\113\1\114\37"+
            "\113\1\114\1\113\1\114\uffa2\113",
            "\32\115\4\uffff\1\115\1\uffff\32\115",
            "",
            "\32\116\4\uffff\1\116\1\uffff\32\116",
            "\32\117\4\uffff\1\117\1\uffff\32\117",
            "\1\54\62\uffff\32\53",
            "",
            "",
            "",
            "",
            "\1\122",
            "",
            "\1\123",
            "",
            "\1\124",
            "\1\125",
            "\1\54\62\uffff\23\53\1\126\6\53",
            "\1\54\62\uffff\32\53",
            "",
            "\1\54\62\uffff\2\53\1\127\27\53",
            "\1\54\62\uffff\13\53\1\130\16\53",
            "\1\54\62\uffff\13\53\1\131\16\53",
            "\1\54\62\uffff\16\53\1\132\13\53",
            "\1\54\62\uffff\23\53\1\133\6\53",
            "\1\54\62\uffff\22\53\1\134\7\53",
            "\1\54\62\uffff\10\53\1\135\2\53\1\136\16\53",
            "\1\54\62\uffff\23\53\1\137\6\53",
            "\1\54\62\uffff\5\53\1\140\24\53",
            "\1\54\62\uffff\21\53\1\141\10\53",
            "\1\54\62\uffff\13\53\1\142\16\53",
            "\1\54\62\uffff\15\53\1\143\14\53",
            "\1\54\62\uffff\30\53\1\144\1\53",
            "\1\54\62\uffff\15\53\1\145\14\53",
            "\1\54\62\uffff\17\53\1\146\12\53",
            "\1\54\62\uffff\3\53\1\147\26\53",
            "\1\54\62\uffff\14\53\1\150\15\53",
            "\1\54\62\uffff\1\151\23\53\1\152\5\53",
            "\1\54\62\uffff\10\53\1\153\21\53",
            "\1\54\62\uffff\21\53\1\154\10\53",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "\12\113\1\uffff\2\113\1\uffff\36\113\1\114\16\113\1\114\37"+
            "\113\1\114\1\113\1\114\uffa2\113",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\157",
            "\1\160",
            "\1\161",
            "\1\54\62\uffff\2\53\1\162\27\53",
            "\1\54\62\uffff\7\53\1\163\22\53",
            "\1\54\62\uffff\13\53\1\164\16\53",
            "\1\54\62\uffff\13\53\1\165\16\53",
            "\1\54\62\uffff\2\53\1\166\27\53",
            "\1\54\62\uffff\7\53\1\167\22\53",
            "\1\54\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\53",
            "\1\54\62\uffff\1\171\31\53",
            "\1\54\62\uffff\16\53\1\172\13\53",
            "\1\54\62\uffff\4\53\1\173\25\53",
            "\1\54\62\uffff\1\174\31\53",
            "\1\54\62\uffff\2\53\1\175\27\53",
            "\1\54\62\uffff\22\53\1\176\7\53",
            "\1\54\62\uffff\16\53\1\177\13\53",
            "\1\54\3\uffff\1\u0080\56\uffff\32\53",
            "\1\54\62\uffff\6\53\1\u0081\23\53",
            "\1\u0082\1\54\62\uffff\32\53",
            "\1\54\62\uffff\4\53\1\u0083\25\53",
            "\1\54\62\uffff\1\53\1\u0084\30\53",
            "\1\54\62\uffff\15\53\1\u0085\14\53",
            "\1\54\62\uffff\4\53\1\u0086\25\53",
            "\1\54\62\uffff\20\53\1\u0087\11\53",
            "\1\54\62\uffff\23\53\1\u0088\6\53",
            "",
            "\1\uffff",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\54\62\uffff\7\53\1\u008d\22\53",
            "\1\54\62\uffff\4\53\1\u008e\25\53",
            "\1\54\25\uffff\1\u008f\34\uffff\32\53",
            "\1\54\62\uffff\4\53\1\u0090\25\53",
            "\1\54\62\uffff\4\53\1\u0091\25\53",
            "\1\u0092\1\54\62\uffff\32\53",
            "",
            "\1\54\62\uffff\22\53\1\u0093\7\53",
            "\1\54\62\uffff\26\53\1\u0094\3\53",
            "\1\54\62\uffff\5\53\1\u0095\24\53",
            "\1\54\62\uffff\24\53\1\u0096\5\53",
            "\1\54\62\uffff\4\53\1\u0097\25\53",
            "\1\54\62\uffff\4\53\1\u0098\25\53",
            "\1\54\62\uffff\21\53\1\u0099\10\53",
            "\1\u009a",
            "\1\54\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\53",
            "",
            "\1\54\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\53",
            "\1\54\62\uffff\4\53\1\u009d\25\53",
            "\1\54\62\uffff\22\53\1\u009e\7\53",
            "\1\54\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\53",
            "\1\54\62\uffff\24\53\1\u00a0\5\53",
            "\1\54\62\uffff\24\53\1\u00a1\5\53",
            "",
            "\1\u00a2",
            "\1\u00a3",
            "\1\u00a4",
            "\1\54\62\uffff\14\53\1\u00a5\15\53",
            "\1\54\46\uffff\1\u00a6\13\uffff\32\53",
            "\1\u00a7",
            "\1\54\62\uffff\2\53\1\u00a8\27\53",
            "\1\54\62\uffff\22\53\1\u00a9\7\53",
            "",
            "\1\54\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\53",
            "\1\54\62\uffff\15\53\1\u00ab\14\53",
            "\1\54\62\uffff\16\53\1\u00ac\13\53",
            "\1\54\62\uffff\13\53\1\u00ad\16\53",
            "\1\54\50\uffff\1\u00ae\11\uffff\32\53",
            "\1\54\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\53",
            "\1\54\62\uffff\4\53\1\u00af\25\53",
            "\1\u00b0",
            "",
            "",
            "\1\54\62\uffff\21\53\1\u00b1\10\53",
            "\1\54\62\uffff\13\53\1\u00b2\16\53",
            "",
            "\1\54\62\uffff\4\53\1\u00b3\25\53",
            "\1\54\62\uffff\1\u00b4\31\53",
            "\12\47\7\uffff\32\47\4\uffff\1\u00b5\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\54\62\uffff\16\53\1\u00b9\13\53",
            "\1\u00ba",
            "\1\u00bb",
            "\1\54\62\uffff\23\53\1\u00bc\6\53",
            "\1\54\62\uffff\22\53\1\u00bd\7\53",
            "",
            "\1\54\62\uffff\24\53\1\u00be\5\53",
            "\1\54\62\uffff\21\53\1\u00bf\10\53",
            "\1\54\62\uffff\23\53\1\u00c0\6\53",
            "\1\u00c1",
            "\1\54\34\uffff\1\u00c2\25\uffff\15\53\1\u00c3\14\53",
            "\1\u00c4",
            "\1\54\62\uffff\5\53\1\u00c5\24\53",
            "\1\54\62\uffff\1\u00c6\31\53",
            "\1\54\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\53",
            "\1\54\62\uffff\13\53\1\u00c8\16\53",
            "\1\u00c9",
            "",
            "",
            "",
            "\1\54\62\uffff\3\53\1\u00ca\26\53",
            "\1\u00cb",
            "\1\u00cc",
            "\1\54\62\uffff\10\53\1\u00cd\21\53",
            "\1\54\62\uffff\16\53\1\u00ce\13\53",
            "\1\54\62\uffff\13\53\1\u00cf\16\53",
            "\1\54\62\uffff\14\53\1\u00d0\15\53",
            "\1\54\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\53",
            "\1\u00d2",
            "\1\u00d3",
            "\1\54\62\uffff\24\53\1\u00d4\5\53",
            "\1\u00d5",
            "\1\54\62\uffff\16\53\1\u00d6\13\53",
            "\1\54\62\uffff\23\53\1\u00d7\6\53",
            "",
            "\1\54\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\53",
            "\1\u00d9",
            "\1\54\62\uffff\4\53\1\u00da\25\53",
            "\1\u00db",
            "\1\u00dc",
            "\1\54\62\uffff\16\53\1\u00dd\13\53",
            "\1\54\62\uffff\21\53\1\u00de\10\53",
            "\1\54\62\uffff\13\53\1\u00df\16\53",
            "\1\54\62\uffff\1\u00e0\31\53",
            "",
            "\1\u00e1",
            "\1\u00e2",
            "\1\54\62\uffff\13\53\1\u00e3\16\53",
            "\1\u00e4",
            "\1\54\62\uffff\21\53\1\u00e5\10\53",
            "\1\54\62\uffff\16\53\1\u00e6\13\53",
            "",
            "\1\u00e7",
            "\1\54\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\53",
            "\1\u00e9",
            "\1\u00ea",
            "\1\54\62\uffff\15\53\1\u00eb\14\53",
            "\1\54\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\53",
            "\1\54\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\53",
            "\1\54\62\uffff\23\53\1\u00ee\6\53",
            "\1\u00ef",
            "\1\u00f0",
            "\1\54\62\uffff\13\53\1\u00f1\16\53",
            "\1\u00f2",
            "\1\54\62\uffff\14\53\1\u00f3\15\53",
            "\1\54\62\uffff\21\53\1\u00f4\10\53",
            "\1\u00f5",
            "",
            "\1\u00f6",
            "\1\u00f7",
            "\1\u00f8\1\54\62\uffff\32\53",
            "",
            "",
            "\1\54\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\53",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u00fb",
            "\1\54\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\53",
            "",
            "\1\54\62\uffff\1\u00fd\31\53",
            "\1\54\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\53",
            "\1\u00ff",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\1\u0101",
            "",
            "",
            "",
            "\1\u0102",
            "",
            "\1\54\62\uffff\23\53\1\u0103\6\53",
            "",
            "\1\u0104",
            "",
            "\1\u0105",
            "\1\u0106",
            "\1\54\1\uffff\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\53",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "\12\47\7\uffff\32\47\4\uffff\1\47\1\uffff\32\47",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual | Comma | Dot | DoubleQuote | Semicolon | RBracket | LBracket | LParenthesis | RParenthesis | Equals | Bool | Macrodef | Macroval | ArgumentModifierval | SpecialAttribute | DocumentID | Identifier | Classname | Comment | QuotedField | Field | Ws | Lb | Char | NextRow );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA22_75 = input.LA(1);

                         
                        int index22_75 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA22_75 >= '\u0000' && LA22_75 <= '\t')||(LA22_75 >= '\u000B' && LA22_75 <= '\f')||(LA22_75 >= '\u000E' && LA22_75 <= '+')||(LA22_75 >= '-' && LA22_75 <= ':')||(LA22_75 >= '<' && LA22_75 <= 'Z')||LA22_75=='\\'||(LA22_75 >= '^' && LA22_75 <= '\uFFFF')) && (((isArgumentModifierAssignment())||(isMacroAssignment())))) {s = 75;}

                        else if ( (LA22_75==','||LA22_75==';'||LA22_75=='['||LA22_75==']') && ((isMacroAssignment()))) {s = 76;}

                        else s = 110;

                         
                        input.seek(index22_75);

                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA22_21 = input.LA(1);

                         
                        int index22_21 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA22_21=='\"') ) {s = 67;}

                        else if ( ((LA22_21 >= '\u0000' && LA22_21 <= '\t')||(LA22_21 >= '\u000B' && LA22_21 <= '\f')||(LA22_21 >= '\u000E' && LA22_21 <= '!')||(LA22_21 >= '#' && LA22_21 <= ':')||(LA22_21 >= '<' && LA22_21 <= '\uFFFF')) && ((isHeader() == false))) {s = 69;}

                        else s = 68;

                         
                        input.seek(index22_21);

                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA22_26 = input.LA(1);

                         
                        int index22_26 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA22_26 >= '\u0000' && LA22_26 <= '\t')||(LA22_26 >= '\u000B' && LA22_26 <= '\f')||(LA22_26 >= '\u000E' && LA22_26 <= '+')||(LA22_26 >= '-' && LA22_26 <= ':')||(LA22_26 >= '<' && LA22_26 <= 'Z')||LA22_26=='\\'||(LA22_26 >= '^' && LA22_26 <= '\uFFFF')) && (((isArgumentModifierAssignment())||(isMacroAssignment())))) {s = 75;}

                        else if ( (LA22_26==','||LA22_26==';'||LA22_26=='['||LA22_26==']') && ((isMacroAssignment()))) {s = 76;}

                        else s = 74;

                         
                        input.seek(index22_26);

                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA22_110 = input.LA(1);

                         
                        int index22_110 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((isMacroAssignment())) ) {s = 76;}

                        else if ( ((isArgumentModifierAssignment())) ) {s = 137;}

                         
                        input.seek(index22_110);

                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA22_68 = input.LA(1);

                         
                        int index22_68 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((isHeader() == false)))) ) {s = 109;}

                        else if ( ((isHeader() == false)) ) {s = 69;}

                         
                        input.seek(index22_68);

                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA22_0 = input.LA(1);

                        s = -1;
                        if ( (LA22_0=='I') ) {s = 1;}

                        else if ( (LA22_0=='U') ) {s = 2;}

                        else if ( (LA22_0=='R') ) {s = 3;}

                        else if ( (LA22_0=='b') ) {s = 4;}

                        else if ( (LA22_0=='c') ) {s = 5;}

                        else if ( (LA22_0=='p') ) {s = 6;}

                        else if ( (LA22_0=='a') ) {s = 7;}

                        else if ( (LA22_0=='d') ) {s = 8;}

                        else if ( (LA22_0=='f') ) {s = 9;}

                        else if ( (LA22_0=='i') ) {s = 10;}

                        else if ( (LA22_0=='k') ) {s = 11;}

                        else if ( (LA22_0=='l') ) {s = 12;}

                        else if ( (LA22_0=='m') ) {s = 13;}

                        else if ( (LA22_0=='n') ) {s = 14;}

                        else if ( (LA22_0=='t') ) {s = 15;}

                        else if ( (LA22_0=='u') ) {s = 16;}

                        else if ( (LA22_0=='v') ) {s = 17;}

                        else if ( (LA22_0==',') ) {s = 18;}

                        else if ( (LA22_0=='.') ) {s = 19;}

                        else if ( (LA22_0=='\"') ) {s = 20;}

                        else if ( (LA22_0==';') ) {s = 21;}

                        else if ( (LA22_0==']') ) {s = 22;}

                        else if ( (LA22_0=='[') ) {s = 23;}

                        else if ( (LA22_0=='(') ) {s = 24;}

                        else if ( (LA22_0==')') ) {s = 25;}

                        else if ( (LA22_0=='=') ) {s = 26;}

                        else if ( (LA22_0=='$') ) {s = 27;}

                        else if ( (LA22_0=='@') ) {s = 29;}

                        else if ( (LA22_0=='&') ) {s = 30;}

                        else if ( (LA22_0=='e'||(LA22_0 >= 'g' && LA22_0 <= 'h')||LA22_0=='j'||LA22_0=='o'||(LA22_0 >= 'q' && LA22_0 <= 's')||(LA22_0 >= 'w' && LA22_0 <= 'z')) ) {s = 31;}

                        else if ( ((LA22_0 >= 'A' && LA22_0 <= 'H')||(LA22_0 >= 'J' && LA22_0 <= 'Q')||(LA22_0 >= 'S' && LA22_0 <= 'T')||(LA22_0 >= 'V' && LA22_0 <= 'Z')||LA22_0=='_') ) {s = 32;}

                        else if ( (LA22_0=='#') ) {s = 33;}

                        else if ( (LA22_0=='\t'||LA22_0==' ') ) {s = 34;}

                        else if ( (LA22_0=='\n'||LA22_0=='\r') ) {s = 35;}

                        else if ( (LA22_0=='\\') ) {s = 36;}

                        else if ( ((LA22_0 >= '\u0000' && LA22_0 <= '\b')||(LA22_0 >= '\u000B' && LA22_0 <= '\f')||(LA22_0 >= '\u000E' && LA22_0 <= '\u001F')||LA22_0=='!'||LA22_0=='%'||LA22_0=='\''||(LA22_0 >= '*' && LA22_0 <= '+')||LA22_0=='-'||(LA22_0 >= '/' && LA22_0 <= ':')||LA22_0=='<'||(LA22_0 >= '>' && LA22_0 <= '?')||LA22_0=='^'||LA22_0=='`'||(LA22_0 >= '{' && LA22_0 <= '\uFFFF')) ) {s = 37;}

                        else s = 28;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 22, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}