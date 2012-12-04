// $ANTLR 3.4 /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g 2012-12-02 21:54:46

 package output;  


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked"})
public class ImpexLexer extends Lexer {
    public static final int EOF=-1;
    public static final int ATTRIBUTE=4;
    public static final int ATTRIBUTES=5;
    public static final int ATTRIBUTE_NAME=6;
    public static final int Alias=7;
    public static final int AllowNull=8;
    public static final int AttributeModifier=9;
    public static final int BLOCK=10;
    public static final int BLOCKS=11;
    public static final int BatchMode=12;
    public static final int Bool=13;
    public static final int CacheUnique=14;
    public static final int CellDecorator=15;
    public static final int Char=16;
    public static final int Classname=17;
    public static final int CollectionDelimiter=18;
    public static final int Comma=19;
    public static final int Comment=20;
    public static final int DOCUMENTID=21;
    public static final int DOCUMENTID_REF=22;
    public static final int Dateformat=23;
    public static final int Default=24;
    public static final int DocumentID=25;
    public static final int Dot=26;
    public static final int DoubleQuote=27;
    public static final int Equals=28;
    public static final int FIELDS=29;
    public static final int Field=30;
    public static final int ForceWrite=31;
    public static final int HEADER=32;
    public static final int HeaderMode=33;
    public static final int HeaderModifier=34;
    public static final int IMPEX=35;
    public static final int ITEM_EXPRESSION=36;
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
    public static final int MACRO=47;
    public static final int MACROS=48;
    public static final int MACRO_REF=49;
    public static final int MODIFIER=50;
    public static final int MODIFIERS=51;
    public static final int Macrodef=52;
    public static final int MapDelimiter=53;
    public static final int Mode=54;
    public static final int NextRow=55;
    public static final int NumberFormat=56;
    public static final int Or=57;
    public static final int PathDelimiter=58;
    public static final int Pos=59;
    public static final int Processor=60;
    public static final int QuotedField=61;
    public static final int RBracket=62;
    public static final int RECORD=63;
    public static final int RECORDS=64;
    public static final int RParenthesis=65;
    public static final int Remove=66;
    public static final int SUBTYPE=67;
    public static final int Semicolon=68;
    public static final int SpecialAttribute=69;
    public static final int TYPE=70;
    public static final int Translator=71;
    public static final int Unique=72;
    public static final int Update=73;
    public static final int ValueAssignement=74;
    public static final int Virtual=75;
    public static final int Ws=76;


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

      private void emit(String text, int type) {
        Token token = new CommonToken(type, text);
        token.setType(type);
        emit(token);
      }

    //  @Override
    //  public void emit(Token token) {
     //   tokens.add(token);
     //   super.emit(token);
    //  } 
      
      @Override
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:281:9: ( ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:281:10: ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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
    // $ANTLR end "Insert"

    // $ANTLR start "InsertUpdate"
    public final void mInsertUpdate() throws RecognitionException {
        try {
            int _type = InsertUpdate;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:282:15: ( ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' ) '_' ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:282:16: ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' ) '_' ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            match('_'); 

            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
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
    // $ANTLR end "InsertUpdate"

    // $ANTLR start "Update"
    public final void mUpdate() throws RecognitionException {
        try {
            int _type = Update;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:283:9: ( ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:283:10: ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
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
    // $ANTLR end "Update"

    // $ANTLR start "Remove"
    public final void mRemove() throws RecognitionException {
        try {
            int _type = Remove;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:284:9: ( ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'V' | 'v' ) ( 'E' | 'e' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:284:10: ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'V' | 'v' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
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
    // $ANTLR end "Remove"

    // $ANTLR start "BatchMode"
    public final void mBatchMode() throws RecognitionException {
        try {
            int _type = BatchMode;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:286:12: ( ( 'B' | 'b' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'D' | 'd' ) ( 'E' | 'e' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:286:13: ( 'B' | 'b' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'D' | 'd' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
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
    // $ANTLR end "BatchMode"

    // $ANTLR start "CacheUnique"
    public final void mCacheUnique() throws RecognitionException {
        try {
            int _type = CacheUnique;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:287:14: ( ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'E' | 'e' ) ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:287:15: ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'E' | 'e' ) ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
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
    // $ANTLR end "CacheUnique"

    // $ANTLR start "Processor"
    public final void mProcessor() throws RecognitionException {
        try {
            int _type = Processor;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:288:12: ( ( 'P' | 'p' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'S' | 's' ) ( 'O' | 'o' ) ( 'R' | 'r' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:288:13: ( 'P' | 'p' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'S' | 's' ) ( 'O' | 'o' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
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
    // $ANTLR end "Processor"

    // $ANTLR start "Alias"
    public final void mAlias() throws RecognitionException {
        try {
            int _type = Alias;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:294:8: ( ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'A' | 'a' ) ( 'S' | 's' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:294:9: ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'A' | 'a' ) ( 'S' | 's' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
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
    // $ANTLR end "Alias"

    // $ANTLR start "AllowNull"
    public final void mAllowNull() throws RecognitionException {
        try {
            int _type = AllowNull;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:295:12: ( ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'W' | 'w' ) ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'L' | 'l' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:295:13: ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'W' | 'w' ) ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'L' | 'l' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
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
    // $ANTLR end "AllowNull"

    // $ANTLR start "CellDecorator"
    public final void mCellDecorator() throws RecognitionException {
        try {
            int _type = CellDecorator;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:296:15: ( ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'O' | 'o' ) ( 'R' | 'r' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:296:16: ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'O' | 'o' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
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
    // $ANTLR end "CellDecorator"

    // $ANTLR start "CollectionDelimiter"
    public final void mCollectionDelimiter() throws RecognitionException {
        try {
            int _type = CollectionDelimiter;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:297:22: ( ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:297:23: ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            match('-'); 

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
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
    // $ANTLR end "CollectionDelimiter"

    // $ANTLR start "Dateformat"
    public final void mDateformat() throws RecognitionException {
        try {
            int _type = Dateformat;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:298:13: ( ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'T' | 't' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:298:14: ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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
    // $ANTLR end "Dateformat"

    // $ANTLR start "Default"
    public final void mDefault() throws RecognitionException {
        try {
            int _type = Default;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:299:10: ( ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'A' | 'a' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'T' | 't' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:299:11: ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'A' | 'a' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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
    // $ANTLR end "Default"

    // $ANTLR start "ForceWrite"
    public final void mForceWrite() throws RecognitionException {
        try {
            int _type = ForceWrite;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:300:13: ( ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'W' | 'w' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:300:14: ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'W' | 'w' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
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
    // $ANTLR end "ForceWrite"

    // $ANTLR start "IgnoreKeyCase"
    public final void mIgnoreKeyCase() throws RecognitionException {
        try {
            int _type = IgnoreKeyCase;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:301:15: ( ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'N' | 'n' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'K' | 'k' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'E' | 'e' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:301:16: ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'N' | 'n' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'K' | 'k' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
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
    // $ANTLR end "IgnoreKeyCase"

    // $ANTLR start "IgnoreNull"
    public final void mIgnoreNull() throws RecognitionException {
        try {
            int _type = IgnoreNull;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:302:13: ( ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'N' | 'n' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'L' | 'l' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:302:14: ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'N' | 'n' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'L' | 'l' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
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
    // $ANTLR end "IgnoreNull"

    // $ANTLR start "KeyToValueDelimiter"
    public final void mKeyToValueDelimiter() throws RecognitionException {
        try {
            int _type = KeyToValueDelimiter;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:303:21: ( ( 'K' | 'k' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) '2' ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:303:22: ( 'K' | 'k' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) '2' ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            match('2'); 

            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            match('-'); 

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
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
    // $ANTLR end "KeyToValueDelimiter"

    // $ANTLR start "Lang"
    public final void mLang() throws RecognitionException {
        try {
            int _type = Lang;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:304:7: ( ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'G' | 'g' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:304:8: ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'G' | 'g' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
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
    // $ANTLR end "Lang"

    // $ANTLR start "MapDelimiter"
    public final void mMapDelimiter() throws RecognitionException {
        try {
            int _type = MapDelimiter;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:305:14: ( ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'P' | 'p' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:305:15: ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'P' | 'p' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            match('-'); 

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
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
    // $ANTLR end "MapDelimiter"

    // $ANTLR start "Mode"
    public final void mMode() throws RecognitionException {
        try {
            int _type = Mode;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:306:7: ( ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'D' | 'd' ) ( 'E' | 'e' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:306:8: ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'D' | 'd' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
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
    // $ANTLR end "Mode"

    // $ANTLR start "NumberFormat"
    public final void mNumberFormat() throws RecognitionException {
        try {
            int _type = NumberFormat;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:307:14: ( ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'B' | 'b' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'T' | 't' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:307:15: ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'B' | 'b' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'T' | 't' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
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
    // $ANTLR end "NumberFormat"

    // $ANTLR start "PathDelimiter"
    public final void mPathDelimiter() throws RecognitionException {
        try {
            int _type = PathDelimiter;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:308:15: ( ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'H' | 'h' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:308:16: ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'H' | 'h' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            match('-'); 

            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
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
    // $ANTLR end "PathDelimiter"

    // $ANTLR start "Pos"
    public final void mPos() throws RecognitionException {
        try {
            int _type = Pos;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:309:6: ( ( 'P' | 'p' ) ( 'O' | 'o' ) ( 'S' | 's' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:309:7: ( 'P' | 'p' ) ( 'O' | 'o' ) ( 'S' | 's' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
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
    // $ANTLR end "Pos"

    // $ANTLR start "Translator"
    public final void mTranslator() throws RecognitionException {
        try {
            int _type = Translator;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:310:13: ( ( 'T' | 't' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'O' | 'o' ) ( 'R' | 'r' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:310:14: ( 'T' | 't' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'O' | 'o' ) ( 'R' | 'r' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
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
    // $ANTLR end "Translator"

    // $ANTLR start "Unique"
    public final void mUnique() throws RecognitionException {
        try {
            int _type = Unique;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:311:9: ( ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:311:10: ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'E' | 'e' )
            {
            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
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
    // $ANTLR end "Unique"

    // $ANTLR start "Virtual"
    public final void mVirtual() throws RecognitionException {
        try {
            int _type = Virtual;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:312:10: ( ( 'V' | 'v' ) ( 'I' | 'i' ) ( 'R' | 'r' ) ( 'T' | 't' ) ( 'U' | 'u' ) ( 'A' | 'a' ) ( 'L' | 'l' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:312:11: ( 'V' | 'v' ) ( 'I' | 'i' ) ( 'R' | 'r' ) ( 'T' | 't' ) ( 'U' | 'u' ) ( 'A' | 'a' ) ( 'L' | 'l' )
            {
            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
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
    // $ANTLR end "Virtual"

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:336:8: ( ',' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:336:9: ','
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:337:5: ( '.' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:337:6: '.'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:338:13: ( '\"' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:338:14: '\"'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:339:11: ( ';' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:339:12: ';'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:340:10: ( ']' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:340:11: ']'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:341:10: ( '[' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:341:11: '['
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:342:15: ( '(' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:342:16: '('
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:343:14: ( ')' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:343:15: ')'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:344:8: ( '=' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:344:9: '='
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

    // $ANTLR start "Or"
    public final void mOr() throws RecognitionException {
        try {
            int _type = Or;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:345:4: ( '|' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:345:5: '|'
            {
            match('|'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Or"

    // $ANTLR start "Bool"
    public final void mBool() throws RecognitionException {
        try {
            int _type = Bool;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:347:6: ( 'true' | 'false' )
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
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:347:7: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:347:16: 'false'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:350:2: ( Insert | InsertUpdate | Update | Remove )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 'I':
            case 'i':
                {
                int LA2_1 = input.LA(2);

                if ( (LA2_1=='N'||LA2_1=='n') ) {
                    int LA2_4 = input.LA(3);

                    if ( (LA2_4=='S'||LA2_4=='s') ) {
                        int LA2_5 = input.LA(4);

                        if ( (LA2_5=='E'||LA2_5=='e') ) {
                            int LA2_6 = input.LA(5);

                            if ( (LA2_6=='R'||LA2_6=='r') ) {
                                int LA2_7 = input.LA(6);

                                if ( (LA2_7=='T'||LA2_7=='t') ) {
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
            case 'u':
                {
                alt2=3;
                }
                break;
            case 'R':
            case 'r':
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
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:350:4: Insert
                    {
                    mInsert(); 


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:350:13: InsertUpdate
                    {
                    mInsertUpdate(); 


                    }
                    break;
                case 3 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:350:28: Update
                    {
                    mUpdate(); 


                    }
                    break;
                case 4 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:350:37: Remove
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:353:2: ( BatchMode | CacheUnique | Processor )
            int alt3=3;
            switch ( input.LA(1) ) {
            case 'B':
            case 'b':
                {
                alt3=1;
                }
                break;
            case 'C':
            case 'c':
                {
                alt3=2;
                }
                break;
            case 'P':
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
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:353:3: BatchMode
                    {
                    mBatchMode(); 


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:353:15: CacheUnique
                    {
                    mCacheUnique(); 


                    }
                    break;
                case 3 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:353:29: Processor
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

    // $ANTLR start "AttributeModifier"
    public final void mAttributeModifier() throws RecognitionException {
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:356:2: ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual )
            int alt4=19;
            switch ( input.LA(1) ) {
            case 'A':
            case 'a':
                {
                int LA4_1 = input.LA(2);

                if ( (LA4_1=='L'||LA4_1=='l') ) {
                    int LA4_14 = input.LA(3);

                    if ( (LA4_14=='I'||LA4_14=='i') ) {
                        alt4=1;
                    }
                    else if ( (LA4_14=='L'||LA4_14=='l') ) {
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
            case 'C':
            case 'c':
                {
                int LA4_2 = input.LA(2);

                if ( (LA4_2=='E'||LA4_2=='e') ) {
                    alt4=3;
                }
                else if ( (LA4_2=='O'||LA4_2=='o') ) {
                    alt4=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 2, input);

                    throw nvae;

                }
                }
                break;
            case 'D':
            case 'd':
                {
                int LA4_3 = input.LA(2);

                if ( (LA4_3=='A'||LA4_3=='a') ) {
                    alt4=5;
                }
                else if ( (LA4_3=='E'||LA4_3=='e') ) {
                    alt4=6;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 3, input);

                    throw nvae;

                }
                }
                break;
            case 'F':
            case 'f':
                {
                alt4=7;
                }
                break;
            case 'I':
            case 'i':
                {
                int LA4_5 = input.LA(2);

                if ( (LA4_5=='G'||LA4_5=='g') ) {
                    int LA4_19 = input.LA(3);

                    if ( (LA4_19=='N'||LA4_19=='n') ) {
                        int LA4_26 = input.LA(4);

                        if ( (LA4_26=='O'||LA4_26=='o') ) {
                            int LA4_27 = input.LA(5);

                            if ( (LA4_27=='R'||LA4_27=='r') ) {
                                int LA4_28 = input.LA(6);

                                if ( (LA4_28=='E'||LA4_28=='e') ) {
                                    int LA4_29 = input.LA(7);

                                    if ( (LA4_29=='K'||LA4_29=='k') ) {
                                        alt4=8;
                                    }
                                    else if ( (LA4_29=='N'||LA4_29=='n') ) {
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
            case 'K':
            case 'k':
                {
                alt4=10;
                }
                break;
            case 'L':
            case 'l':
                {
                alt4=11;
                }
                break;
            case 'M':
            case 'm':
                {
                int LA4_8 = input.LA(2);

                if ( (LA4_8=='A'||LA4_8=='a') ) {
                    alt4=12;
                }
                else if ( (LA4_8=='O'||LA4_8=='o') ) {
                    alt4=13;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 8, input);

                    throw nvae;

                }
                }
                break;
            case 'N':
            case 'n':
                {
                alt4=14;
                }
                break;
            case 'P':
            case 'p':
                {
                int LA4_10 = input.LA(2);

                if ( (LA4_10=='A'||LA4_10=='a') ) {
                    alt4=15;
                }
                else if ( (LA4_10=='O'||LA4_10=='o') ) {
                    alt4=16;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 10, input);

                    throw nvae;

                }
                }
                break;
            case 'T':
            case 't':
                {
                alt4=17;
                }
                break;
            case 'U':
            case 'u':
                {
                alt4=18;
                }
                break;
            case 'V':
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
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:356:3: Alias
                    {
                    mAlias(); 


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:356:11: AllowNull
                    {
                    mAllowNull(); 


                    }
                    break;
                case 3 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:356:23: CellDecorator
                    {
                    mCellDecorator(); 


                    }
                    break;
                case 4 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:356:39: CollectionDelimiter
                    {
                    mCollectionDelimiter(); 


                    }
                    break;
                case 5 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:356:61: Dateformat
                    {
                    mDateformat(); 


                    }
                    break;
                case 6 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:356:74: Default
                    {
                    mDefault(); 


                    }
                    break;
                case 7 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:356:84: ForceWrite
                    {
                    mForceWrite(); 


                    }
                    break;
                case 8 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:356:97: IgnoreKeyCase
                    {
                    mIgnoreKeyCase(); 


                    }
                    break;
                case 9 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:356:113: IgnoreNull
                    {
                    mIgnoreNull(); 


                    }
                    break;
                case 10 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:357:4: KeyToValueDelimiter
                    {
                    mKeyToValueDelimiter(); 


                    }
                    break;
                case 11 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:357:26: Lang
                    {
                    mLang(); 


                    }
                    break;
                case 12 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:357:33: MapDelimiter
                    {
                    mMapDelimiter(); 


                    }
                    break;
                case 13 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:357:48: Mode
                    {
                    mMode(); 


                    }
                    break;
                case 14 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:357:55: NumberFormat
                    {
                    mNumberFormat(); 


                    }
                    break;
                case 15 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:357:70: PathDelimiter
                    {
                    mPathDelimiter(); 


                    }
                    break;
                case 16 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:357:86: Pos
                    {
                    mPos(); 


                    }
                    break;
                case 17 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:357:92: Translator
                    {
                    mTranslator(); 


                    }
                    break;
                case 18 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:357:105: Unique
                    {
                    mUnique(); 


                    }
                    break;
                case 19 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:357:114: Virtual
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
    // $ANTLR end "AttributeModifier"

    // $ANTLR start "Macrodef"
    public final void mMacrodef() throws RecognitionException {
        try {
            int _type = Macrodef;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:362:2: ( '$' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:362:3: '$' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:362:39: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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

    // $ANTLR start "ValueAssignement"
    public final void mValueAssignement() throws RecognitionException {
        try {
            int _type = ValueAssignement;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:365:2: ({...}? => '=' (~ ( '\\r' | '\\n' ) )* |{...}? => '=' ( ( ' ' | '\\t' )* '\"' (~ ( '\\r' | '\\n' | '\"' ) | '\"' '\"' )* '\"' | (~ ( '\\r' | '\\n' | ';' | '\"' | '[' | ']' | ',' ) )* ) |)
            int alt11=3;
            int LA11_0 = input.LA(1);

            if ( (LA11_0=='=') && (((isArgumentModifierAssignment())||(isMacroAssignment())))) {
                int LA11_1 = input.LA(2);

                if ( ((isMacroAssignment())) ) {
                    alt11=1;
                }
                else if ( ((isArgumentModifierAssignment())) ) {
                    alt11=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;

                }
            }
            else {
                alt11=3;
            }
            switch (alt11) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:365:3: {...}? => '=' (~ ( '\\r' | '\\n' ) )*
                    {
                    if ( !((isMacroAssignment())) ) {
                        throw new FailedPredicateException(input, "ValueAssignement", "isMacroAssignment()");
                    }

                    match('='); 

                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:365:34: (~ ( '\\r' | '\\n' ) )*
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


                    setText(getText().substring(1, getText().length()).trim());

                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:366:3: {...}? => '=' ( ( ' ' | '\\t' )* '\"' (~ ( '\\r' | '\\n' | '\"' ) | '\"' '\"' )* '\"' | (~ ( '\\r' | '\\n' | ';' | '\"' | '[' | ']' | ',' ) )* )
                    {
                    if ( !((isArgumentModifierAssignment())) ) {
                        throw new FailedPredicateException(input, "ValueAssignement", "isArgumentModifierAssignment()");
                    }

                    match('='); 

                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:366:44: ( ( ' ' | '\\t' )* '\"' (~ ( '\\r' | '\\n' | '\"' ) | '\"' '\"' )* '\"' | (~ ( '\\r' | '\\n' | ';' | '\"' | '[' | ']' | ',' ) )* )
                    int alt10=2;
                    alt10 = dfa10.predict(input);
                    switch (alt10) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:366:45: ( ' ' | '\\t' )* '\"' (~ ( '\\r' | '\\n' | '\"' ) | '\"' '\"' )* '\"'
                            {
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:366:45: ( ' ' | '\\t' )*
                            loop7:
                            do {
                                int alt7=2;
                                int LA7_0 = input.LA(1);

                                if ( (LA7_0=='\t'||LA7_0==' ') ) {
                                    alt7=1;
                                }


                                switch (alt7) {
                            	case 1 :
                            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
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
                            	    break;

                            	default :
                            	    break loop7;
                                }
                            } while (true);


                            match('\"'); 

                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:366:62: (~ ( '\\r' | '\\n' | '\"' ) | '\"' '\"' )*
                            loop8:
                            do {
                                int alt8=3;
                                int LA8_0 = input.LA(1);

                                if ( (LA8_0=='\"') ) {
                                    int LA8_1 = input.LA(2);

                                    if ( (LA8_1=='\"') ) {
                                        alt8=2;
                                    }


                                }
                                else if ( ((LA8_0 >= '\u0000' && LA8_0 <= '\t')||(LA8_0 >= '\u000B' && LA8_0 <= '\f')||(LA8_0 >= '\u000E' && LA8_0 <= '!')||(LA8_0 >= '#' && LA8_0 <= '\uFFFF')) ) {
                                    alt8=1;
                                }


                                switch (alt8) {
                            	case 1 :
                            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:366:63: ~ ( '\\r' | '\\n' | '\"' )
                            	    {
                            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
                            	        input.consume();
                            	    }
                            	    else {
                            	        MismatchedSetException mse = new MismatchedSetException(null,input);
                            	        recover(mse);
                            	        throw mse;
                            	    }


                            	    }
                            	    break;
                            	case 2 :
                            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:366:87: '\"' '\"'
                            	    {
                            	    match('\"'); 

                            	    match('\"'); 

                            	    }
                            	    break;

                            	default :
                            	    break loop8;
                                }
                            } while (true);


                            match('\"'); 

                            String text = getText().substring(1, getText().length()).trim(); setText(text.substring(1, text.length() - 1));

                            }
                            break;
                        case 2 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:366:217: (~ ( '\\r' | '\\n' | ';' | '\"' | '[' | ']' | ',' ) )*
                            {
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:366:217: (~ ( '\\r' | '\\n' | ';' | '\"' | '[' | ']' | ',' ) )*
                            loop9:
                            do {
                                int alt9=2;
                                int LA9_0 = input.LA(1);

                                if ( ((LA9_0 >= '\u0000' && LA9_0 <= '\t')||(LA9_0 >= '\u000B' && LA9_0 <= '\f')||(LA9_0 >= '\u000E' && LA9_0 <= '!')||(LA9_0 >= '#' && LA9_0 <= '+')||(LA9_0 >= '-' && LA9_0 <= ':')||(LA9_0 >= '<' && LA9_0 <= 'Z')||LA9_0=='\\'||(LA9_0 >= '^' && LA9_0 <= '\uFFFF')) ) {
                                    alt9=1;
                                }


                                switch (alt9) {
                            	case 1 :
                            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:
                            	    {
                            	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '\t')||(input.LA(1) >= '\u000B' && input.LA(1) <= '\f')||(input.LA(1) >= '\u000E' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '+')||(input.LA(1) >= '-' && input.LA(1) <= ':')||(input.LA(1) >= '<' && input.LA(1) <= 'Z')||input.LA(1)=='\\'||(input.LA(1) >= '^' && input.LA(1) <= '\uFFFF') ) {
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


                            setText(getText().substring(1, getText().length()).trim());

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:367:3: 
                    {
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
    // $ANTLR end "ValueAssignement"

    // $ANTLR start "SpecialAttribute"
    public final void mSpecialAttribute() throws RecognitionException {
        try {
            int _type = SpecialAttribute;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:441:2: ( '@' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:441:3: '@' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:441:39: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0 >= '0' && LA12_0 <= '9')||(LA12_0 >= 'A' && LA12_0 <= 'Z')||LA12_0=='_'||(LA12_0 >= 'a' && LA12_0 <= 'z')) ) {
                    alt12=1;
                }


                switch (alt12) {
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
    // $ANTLR end "SpecialAttribute"

    // $ANTLR start "DocumentID"
    public final void mDocumentID() throws RecognitionException {
        try {
            int _type = DocumentID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:444:2: ( '&' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:444:3: '&' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:444:39: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0 >= '0' && LA13_0 <= '9')||(LA13_0 >= 'A' && LA13_0 <= 'Z')||LA13_0=='_'||(LA13_0 >= 'a' && LA13_0 <= 'z')) ) {
                    alt13=1;
                }


                switch (alt13) {
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
            	    break loop13;
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:447:2: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:447:3: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:447:35: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( ((LA14_0 >= '0' && LA14_0 <= '9')||(LA14_0 >= 'A' && LA14_0 <= 'Z')||LA14_0=='_'||(LA14_0 >= 'a' && LA14_0 <= 'z')) ) {
                    alt14=1;
                }


                switch (alt14) {
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
            	    break loop14;
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:450:2: ( ( ( 'a' .. 'z' )+ '.' )+ 'A' .. 'Z' ( 'A' .. 'Z' | 'a' .. 'z' )+ )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:450:3: ( ( 'a' .. 'z' )+ '.' )+ 'A' .. 'Z' ( 'A' .. 'Z' | 'a' .. 'z' )+
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:450:3: ( ( 'a' .. 'z' )+ '.' )+
            int cnt16=0;
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0 >= 'a' && LA16_0 <= 'z')) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:450:4: ( 'a' .. 'z' )+ '.'
            	    {
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:450:4: ( 'a' .. 'z' )+
            	    int cnt15=0;
            	    loop15:
            	    do {
            	        int alt15=2;
            	        int LA15_0 = input.LA(1);

            	        if ( ((LA15_0 >= 'a' && LA15_0 <= 'z')) ) {
            	            alt15=1;
            	        }


            	        switch (alt15) {
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
            	    	    if ( cnt15 >= 1 ) break loop15;
            	                EarlyExitException eee =
            	                    new EarlyExitException(15, input);
            	                throw eee;
            	        }
            	        cnt15++;
            	    } while (true);


            	    match('.'); 

            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);


            matchRange('A','Z'); 

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:450:35: ( 'A' .. 'Z' | 'a' .. 'z' )+
            int cnt17=0;
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0 >= 'A' && LA17_0 <= 'Z')||(LA17_0 >= 'a' && LA17_0 <= 'z')) ) {
                    alt17=1;
                }


                switch (alt17) {
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
            	    if ( cnt17 >= 1 ) break loop17;
                        EarlyExitException eee =
                            new EarlyExitException(17, input);
                        throw eee;
                }
                cnt17++;
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:454:2: ( '#' (~ ( '\\r' | '\\n' ) )* ( Lb )? )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:454:3: '#' (~ ( '\\r' | '\\n' ) )* ( Lb )?
            {
            match('#'); 

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:454:7: (~ ( '\\r' | '\\n' ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0 >= '\u0000' && LA18_0 <= '\t')||(LA18_0 >= '\u000B' && LA18_0 <= '\f')||(LA18_0 >= '\u000E' && LA18_0 <= '\uFFFF')) ) {
                    alt18=1;
                }


                switch (alt18) {
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
            	    break loop18;
                }
            } while (true);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:454:23: ( Lb )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0=='\n'||LA19_0=='\r') ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:454:23: Lb
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:468:2: ({...}? => ';' ( Ws )* '\"' ( Char | '\"' '\"' | ';' )* '\"' |)
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==';') && ((isHeader() == false))) {
                alt22=1;
            }
            else {
                alt22=2;
            }
            switch (alt22) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:468:3: {...}? => ';' ( Ws )* '\"' ( Char | '\"' '\"' | ';' )* '\"'
                    {
                    if ( !((isHeader() == false)) ) {
                        throw new FailedPredicateException(input, "QuotedField", "isHeader() == false");
                    }

                    match(';'); 

                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:468:32: ( Ws )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0=='\t'||LA20_0==' ') ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:468:32: Ws
                    	    {
                    	    mWs(); 


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    match('\"'); 

                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:468:40: ( Char | '\"' '\"' | ';' )*
                    loop21:
                    do {
                        int alt21=4;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0=='\"') ) {
                            int LA21_1 = input.LA(2);

                            if ( (LA21_1=='\"') ) {
                                alt21=2;
                            }


                        }
                        else if ( ((LA21_0 >= '\u0000' && LA21_0 <= '\t')||(LA21_0 >= '\u000B' && LA21_0 <= '\f')||(LA21_0 >= '\u000E' && LA21_0 <= '!')||(LA21_0 >= '#' && LA21_0 <= ':')||(LA21_0 >= '<' && LA21_0 <= '\uFFFF')) ) {
                            alt21=1;
                        }
                        else if ( (LA21_0==';') ) {
                            alt21=3;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:468:41: Char
                    	    {
                    	    mChar(); 


                    	    }
                    	    break;
                    	case 2 :
                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:468:48: '\"' '\"'
                    	    {
                    	    match('\"'); 

                    	    match('\"'); 

                    	    }
                    	    break;
                    	case 3 :
                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:468:58: ';'
                    	    {
                    	    match(';'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop21;
                        }
                    } while (true);


                    match('\"'); 

                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:468:70: 
                    {
                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
             
            		String text = getText();
            		text = text.substring(1, text.length()).trim(); //remove leading semicolon and trim to remove any spaces
            		text = text.substring(1, text.length() - 1);      // remove surrounding doublequotes
            		setText(text);
            		
            		
            	
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:472:2: ({...}? => ';' ( Char )* |)
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==';') && ((isHeader() == false))) {
                alt24=1;
            }
            else {
                alt24=2;
            }
            switch (alt24) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:472:3: {...}? => ';' ( Char )*
                    {
                    if ( !((isHeader() == false)) ) {
                        throw new FailedPredicateException(input, "Field", "isHeader() == false");
                    }

                    match(';'); 

                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:472:32: ( Char )*
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( ((LA23_0 >= '\u0000' && LA23_0 <= '\t')||(LA23_0 >= '\u000B' && LA23_0 <= '\f')||(LA23_0 >= '\u000E' && LA23_0 <= '!')||(LA23_0 >= '#' && LA23_0 <= ':')||(LA23_0 >= '<' && LA23_0 <= '\uFFFF')) ) {
                            alt23=1;
                        }


                        switch (alt23) {
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
                    	    break loop23;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:472:39: 
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
    // $ANTLR end "Field"

    // $ANTLR start "Ws"
    public final void mWs() throws RecognitionException {
        try {
            int _type = Ws;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:491:4: ( ( ' ' | '\\t' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:491:5: ( ' ' | '\\t' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:492:4: ( ( ( '\\r' )? '\\n' | '\\r' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:492:5: ( ( '\\r' )? '\\n' | '\\r' )
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:492:5: ( ( '\\r' )? '\\n' | '\\r' )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0=='\r') ) {
                int LA26_1 = input.LA(2);

                if ( (LA26_1=='\n') ) {
                    alt26=1;
                }
                else {
                    alt26=2;
                }
            }
            else if ( (LA26_0=='\n') ) {
                alt26=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;

            }
            switch (alt26) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:492:6: ( '\\r' )? '\\n'
                    {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:492:6: ( '\\r' )?
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0=='\r') ) {
                        alt25=1;
                    }
                    switch (alt25) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:492:6: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:492:19: '\\r'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:493:6: (~ ( '\\r' | '\\n' | '\"' | ';' ) )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:495:9: ( '\\\\\\\\' ( Ws )* Lb )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:495:10: '\\\\\\\\' ( Ws )* Lb
            {
            match("\\\\"); 



            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:495:17: ( Ws )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0=='\t'||LA27_0==' ') ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:495:17: Ws
            	    {
            	    mWs(); 


            	    }
            	    break;

            	default :
            	    break loop27;
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
        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:8: ( Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual | Comma | Dot | DoubleQuote | Semicolon | RBracket | LBracket | LParenthesis | RParenthesis | Equals | Or | Bool | Macrodef | ValueAssignement | SpecialAttribute | DocumentID | Identifier | Classname | Comment | QuotedField | Field | Ws | Lb | Char | NextRow )
        int alt28=50;
        alt28 = dfa28.predict(input);
        switch (alt28) {
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
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:364: Or
                {
                mOr(); 


                }
                break;
            case 37 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:367: Bool
                {
                mBool(); 


                }
                break;
            case 38 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:372: Macrodef
                {
                mMacrodef(); 


                }
                break;
            case 39 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:381: ValueAssignement
                {
                mValueAssignement(); 


                }
                break;
            case 40 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:398: SpecialAttribute
                {
                mSpecialAttribute(); 


                }
                break;
            case 41 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:415: DocumentID
                {
                mDocumentID(); 


                }
                break;
            case 42 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:426: Identifier
                {
                mIdentifier(); 


                }
                break;
            case 43 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:437: Classname
                {
                mClassname(); 


                }
                break;
            case 44 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:447: Comment
                {
                mComment(); 


                }
                break;
            case 45 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:455: QuotedField
                {
                mQuotedField(); 


                }
                break;
            case 46 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:467: Field
                {
                mField(); 


                }
                break;
            case 47 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:473: Ws
                {
                mWs(); 


                }
                break;
            case 48 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:476: Lb
                {
                mLb(); 


                }
                break;
            case 49 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:479: Char
                {
                mChar(); 


                }
                break;
            case 50 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:484: NextRow
                {
                mNextRow(); 


                }
                break;

        }

    }


    protected DFA10 dfa10 = new DFA10(this);
    protected DFA28 dfa28 = new DFA28(this);
    static final String DFA10_eotS =
        "\2\3\2\uffff";
    static final String DFA10_eofS =
        "\4\uffff";
    static final String DFA10_minS =
        "\2\11\2\uffff";
    static final String DFA10_maxS =
        "\2\42\2\uffff";
    static final String DFA10_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA10_specialS =
        "\4\uffff}>";
    static final String[] DFA10_transitionS = {
            "\1\1\26\uffff\1\1\1\uffff\1\2",
            "\1\1\26\uffff\1\1\1\uffff\1\2",
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
            return "366:44: ( ( ' ' | '\\t' )* '\"' (~ ( '\\r' | '\\n' | '\"' ) | '\"' '\"' )* '\"' | (~ ( '\\r' | '\\n' | ';' | '\"' | '[' | ']' | ',' ) )* )";
        }
    }
    static final String DFA28_eotS =
        "\1\35\17\67\3\uffff\1\150\4\uffff\1\160\1\uffff\2\67\1\63\1\uffff"+
        "\2\63\16\67\4\uffff\1\63\1\uffff\3\67\2\uffff\55\67\3\uffff\1\153"+
        "\20\uffff\26\67\2\u00c3\32\67\1\uffff\26\67\1\uffff\14\67\2\u00fd"+
        "\1\uffff\2\u00fe\4\67\1\u0103\26\67\1\uffff\2\u011a\10\67\1\u0103"+
        "\1\67\2\uffff\4\67\1\uffff\2\67\2\u012b\2\67\2\u0130\2\u0131\2\u0132"+
        "\12\67\1\uffff\20\67\1\uffff\4\67\3\uffff\16\67\2\u015f\7\67\2\u0167"+
        "\23\67\1\uffff\7\67\1\uffff\5\67\2\u0187\6\67\2\u018e\2\u018f\14"+
        "\67\2\u019c\1\uffff\6\67\2\uffff\2\u01a2\2\u01a3\1\uffff\2\67\2"+
        "\u01a6\3\67\1\uffff\2\u01aa\2\67\3\uffff\2\67\1\uffff\3\67\1\uffff"+
        "\2\67\2\u01b4\1\u01b5\2\u01b6\2\u01b7\4\uffff";
    static final String DFA28_eofS =
        "\u01b8\uffff";
    static final String DFA28_minS =
        "\1\0\17\56\3\uffff\1\0\4\uffff\1\0\1\uffff\1\122\1\117\1\101\1\uffff"+
        "\2\101\1\56\1\107\1\116\1\105\3\101\1\114\1\101\1\105\2\101\1\125"+
        "\1\111\4\uffff\1\134\1\uffff\3\56\2\uffff\1\123\1\116\2\56\1\104"+
        "\1\111\1\56\1\115\1\56\1\124\3\56\1\103\2\114\3\56\1\117\1\124\1"+
        "\123\1\56\1\111\2\56\1\124\1\106\2\56\1\122\1\56\1\131\1\56\1\116"+
        "\2\56\1\120\1\104\1\56\1\115\1\56\1\101\1\56\1\122\2\uffff\1\0\1"+
        "\11\20\uffff\1\56\1\105\1\56\1\117\1\56\1\101\1\56\1\121\1\56\1"+
        "\117\1\56\1\103\1\56\1\110\1\56\1\114\1\56\1\114\1\56\1\103\1\56"+
        "\1\110\1\56\1\60\2\56\1\101\1\117\1\56\1\105\1\56\1\101\1\56\1\103"+
        "\2\56\1\62\1\56\1\107\2\55\1\56\1\105\1\56\1\102\2\56\1\116\1\56"+
        "\1\124\1\uffff\1\56\1\122\1\56\1\122\1\56\1\124\1\56\1\125\1\56"+
        "\1\126\1\56\1\110\1\56\1\105\1\56\1\104\1\56\1\105\1\56\1\105\2"+
        "\55\1\uffff\1\56\1\123\1\56\1\127\1\56\1\106\1\56\1\125\1\56\1\105"+
        "\1\56\1\126\1\56\1\60\1\uffff\1\56\1\60\1\56\1\105\1\56\1\123\2"+
        "\56\1\125\1\56\1\124\1\56\1\105\1\56\1\105\1\56\1\105\1\56\1\105"+
        "\1\56\1\115\1\56\1\125\1\56\1\105\1\56\1\103\1\56\1\123\1\uffff"+
        "\1\56\1\60\1\56\1\116\1\56\1\117\1\56\1\114\1\56\1\127\1\56\1\101"+
        "\2\uffff\1\56\1\122\1\56\1\114\1\uffff\1\56\1\101\1\56\1\60\1\56"+
        "\1\113\1\56\1\60\1\56\1\60\1\56\1\60\1\56\1\117\1\56\1\116\1\56"+
        "\1\103\1\56\1\124\1\56\1\123\1\uffff\1\56\1\125\1\56\1\122\1\56"+
        "\1\124\1\56\1\122\1\114\1\56\1\106\1\56\1\101\1\56\1\114\1\125\1"+
        "\uffff\2\56\1\105\1\125\3\uffff\1\56\1\104\1\56\1\111\1\56\1\117"+
        "\1\56\1\111\1\56\1\117\1\56\1\114\1\56\1\115\1\56\1\60\1\56\1\111"+
        "\1\125\1\56\1\117\1\56\1\124\1\56\1\60\1\120\1\56\1\131\1\56\1\114"+
        "\1\56\1\105\1\56\1\121\1\56\1\122\1\56\1\117\1\56\1\122\1\56\1\114"+
        "\1\56\1\101\1\uffff\1\56\1\124\1\105\1\56\1\122\1\56\1\117\1\uffff"+
        "\1\104\1\56\1\103\1\56\1\114\1\56\1\60\1\56\1\125\1\56\1\101\1\56"+
        "\1\116\1\56\1\60\1\56\1\60\1\56\1\124\1\56\1\105\1\55\1\56\1\115"+
        "\1\56\1\122\1\101\1\56\1\101\1\56\1\60\1\uffff\1\56\1\105\1\56\1"+
        "\124\2\55\2\uffff\1\56\1\60\1\56\1\60\1\uffff\1\56\1\101\1\56\1"+
        "\60\1\124\1\56\1\123\1\uffff\1\56\1\60\1\56\1\117\3\uffff\1\56\1"+
        "\124\1\uffff\1\105\1\56\1\105\1\uffff\1\56\1\122\1\56\2\60\1\56"+
        "\1\60\1\56\1\60\4\uffff";
    static final String DFA28_maxS =
        "\1\uffff\17\172\3\uffff\1\uffff\4\uffff\1\uffff\1\uffff\1\162\1"+
        "\157\1\172\1\uffff\3\172\1\156\1\160\1\145\1\141\1\157\1\162\1\154"+
        "\2\145\1\141\1\157\1\165\1\151\4\uffff\1\134\1\uffff\3\172\2\uffff"+
        "\1\163\1\156\2\172\1\144\1\151\1\172\1\155\1\172\1\164\3\172\1\143"+
        "\2\154\3\172\1\157\1\164\1\163\1\172\1\154\2\172\1\164\1\146\2\172"+
        "\1\162\1\172\1\171\1\172\1\156\2\172\1\160\1\144\1\172\1\155\1\172"+
        "\1\141\1\172\1\162\2\uffff\1\0\1\42\20\uffff\1\172\1\145\1\172\1"+
        "\157\1\172\1\141\1\172\1\161\1\172\1\157\1\172\1\143\1\172\1\150"+
        "\1\172\1\154\1\172\1\154\1\172\1\143\1\172\1\150\4\172\1\141\1\157"+
        "\1\172\1\145\1\172\1\141\1\172\1\143\2\172\1\62\1\172\1\147\1\172"+
        "\1\55\1\172\1\145\1\172\1\142\2\172\1\156\1\172\1\164\1\uffff\1"+
        "\172\1\162\1\172\1\162\1\172\1\164\1\172\1\165\1\172\1\166\1\172"+
        "\1\150\1\172\1\145\1\172\1\144\1\172\1\145\1\172\1\145\1\172\1\55"+
        "\1\uffff\1\172\1\163\1\172\1\167\1\172\1\146\1\172\1\165\1\172\1"+
        "\145\1\172\1\166\2\172\1\uffff\3\172\1\145\1\172\1\163\2\172\1\165"+
        "\1\172\1\164\1\172\1\145\1\172\1\145\1\172\1\145\1\172\1\145\1\172"+
        "\1\155\1\172\1\165\1\172\1\145\1\172\1\143\1\172\1\163\1\uffff\3"+
        "\172\1\156\1\172\1\157\1\172\1\154\1\172\1\167\1\172\1\141\2\uffff"+
        "\1\172\1\162\1\172\1\154\1\uffff\1\172\1\141\3\172\1\156\7\172\1"+
        "\157\1\172\1\156\1\172\1\143\1\172\1\164\1\172\1\163\1\uffff\1\172"+
        "\1\165\1\172\1\162\1\172\1\164\1\172\1\162\1\154\1\172\1\146\1\172"+
        "\1\141\1\172\1\154\1\165\1\uffff\2\172\1\145\1\165\3\uffff\1\172"+
        "\1\144\1\172\1\151\1\172\1\157\1\172\1\151\1\172\1\157\1\172\1\154"+
        "\1\172\1\155\3\172\1\151\1\165\1\172\1\157\1\172\1\164\2\172\1\160"+
        "\1\172\1\171\1\172\1\154\1\172\1\145\1\172\1\161\1\172\1\162\1\172"+
        "\1\157\1\172\1\162\1\172\1\154\1\172\1\141\1\uffff\1\172\1\164\1"+
        "\145\1\172\1\162\1\172\1\157\1\uffff\1\144\1\172\1\143\1\172\1\154"+
        "\3\172\1\165\1\172\1\141\1\172\1\156\5\172\1\164\1\172\1\145\1\55"+
        "\1\172\1\155\1\172\1\162\1\141\1\172\1\141\2\172\1\uffff\1\172\1"+
        "\145\1\172\1\164\1\172\1\55\2\uffff\4\172\1\uffff\1\172\1\141\2"+
        "\172\1\164\1\172\1\163\1\uffff\3\172\1\157\3\uffff\1\172\1\164\1"+
        "\uffff\1\145\1\172\1\145\1\uffff\1\172\1\162\7\172\4\uffff";
    static final String DFA28_acceptS =
        "\20\uffff\1\33\1\34\1\35\1\uffff\1\37\1\40\1\41\1\42\1\uffff\1\44"+
        "\3\uffff\1\47\20\uffff\1\52\1\54\1\57\1\60\1\uffff\1\61\3\uffff"+
        "\1\52\1\53\55\uffff\1\33\1\34\2\uffff\1\55\1\56\1\37\1\40\1\41\1"+
        "\42\1\43\2\47\1\44\1\46\1\50\1\51\1\54\1\57\1\62\62\uffff\1\36\26"+
        "\uffff\1\27\16\uffff\1\23\35\uffff\1\26\14\uffff\1\22\1\24\4\uffff"+
        "\1\45\26\uffff\1\10\20\uffff\1\1\4\uffff\1\3\1\31\1\4\54\uffff\1"+
        "\15\7\uffff\1\32\37\uffff\1\5\6\uffff\1\7\1\11\4\uffff\1\21\7\uffff"+
        "\1\20\4\uffff\1\13\1\14\1\16\2\uffff\1\30\3\uffff\1\6\11\uffff\1"+
        "\25\1\2\1\17\1\12";
    static final String DFA28_specialS =
        "\1\2\22\uffff\1\4\4\uffff\1\1\117\uffff\1\0\1\3\u014e\uffff}>";
    static final String[] DFA28_transitionS = {
            "\11\63\1\60\1\61\2\63\1\61\22\63\1\60\1\63\1\22\1\57\1\34\1"+
            "\63\1\37\1\63\1\26\1\27\2\63\1\20\1\63\1\21\14\63\1\23\1\63"+
            "\1\30\2\63\1\36\1\47\1\44\1\45\1\50\1\56\1\33\2\56\1\41\1\56"+
            "\1\51\1\52\1\53\1\54\1\56\1\46\1\56\1\43\1\56\1\32\1\42\1\55"+
            "\4\56\1\25\1\62\1\24\1\63\1\56\1\63\1\7\1\4\1\5\1\10\1\40\1"+
            "\11\2\40\1\1\1\40\1\12\1\13\1\14\1\15\1\40\1\6\1\40\1\3\1\40"+
            "\1\16\1\2\1\17\4\40\1\63\1\31\uff83\63",
            "\1\70\30\uffff\1\72\6\uffff\1\71\22\uffff\6\66\1\65\6\66\1"+
            "\64\14\66",
            "\1\70\37\uffff\1\76\1\uffff\1\75\20\uffff\15\66\1\74\1\66\1"+
            "\73\12\66",
            "\1\70\26\uffff\1\100\33\uffff\4\66\1\77\25\66",
            "\1\70\22\uffff\1\102\37\uffff\1\101\31\66",
            "\1\70\22\uffff\1\106\3\uffff\1\107\11\uffff\1\110\21\uffff"+
            "\1\103\3\66\1\104\11\66\1\105\13\66",
            "\1\70\22\uffff\1\115\15\uffff\1\116\2\uffff\1\114\16\uffff"+
            "\1\112\15\66\1\113\2\66\1\111\10\66",
            "\1\70\35\uffff\1\120\24\uffff\13\66\1\117\16\66",
            "\1\70\22\uffff\1\123\3\uffff\1\124\33\uffff\1\121\3\66\1\122"+
            "\25\66",
            "\1\70\40\uffff\1\127\21\uffff\1\126\15\66\1\125\13\66",
            "\1\70\26\uffff\1\131\33\uffff\4\66\1\130\25\66",
            "\1\70\22\uffff\1\133\37\uffff\1\132\31\66",
            "\1\70\22\uffff\1\136\15\uffff\1\137\21\uffff\1\134\15\66\1"+
            "\135\13\66",
            "\1\70\46\uffff\1\141\13\uffff\24\66\1\140\5\66",
            "\1\70\43\uffff\1\143\16\uffff\21\66\1\142\10\66",
            "\1\70\32\uffff\1\145\27\uffff\10\66\1\144\21\66",
            "",
            "",
            "",
            "\11\153\1\151\1\uffff\2\153\1\uffff\22\153\1\151\1\153\1\152"+
            "\30\153\1\uffff\uffc4\153",
            "",
            "",
            "",
            "",
            "\12\161\1\uffff\2\161\1\uffff\36\161\1\162\16\161\1\162\37"+
            "\161\1\162\1\161\1\162\uffa2\161",
            "",
            "\1\143\37\uffff\1\143",
            "\1\127\37\uffff\1\127",
            "\32\164\4\uffff\1\164\1\uffff\32\164",
            "",
            "\32\165\4\uffff\1\165\1\uffff\32\165",
            "\32\166\4\uffff\1\166\1\uffff\32\166",
            "\1\70\62\uffff\32\66",
            "\1\72\6\uffff\1\71\30\uffff\1\72\6\uffff\1\71",
            "\1\76\1\uffff\1\75\35\uffff\1\76\1\uffff\1\75",
            "\1\100\37\uffff\1\100",
            "\1\102\37\uffff\1\102",
            "\1\106\3\uffff\1\107\11\uffff\1\110\21\uffff\1\106\3\uffff"+
            "\1\107\11\uffff\1\110",
            "\1\115\15\uffff\1\116\2\uffff\1\114\16\uffff\1\115\15\uffff"+
            "\1\116\2\uffff\1\114",
            "\1\120\37\uffff\1\120",
            "\1\123\3\uffff\1\124\33\uffff\1\123\3\uffff\1\124",
            "\1\131\37\uffff\1\131",
            "\1\133\37\uffff\1\133",
            "\1\136\15\uffff\1\137\21\uffff\1\136\15\uffff\1\137",
            "\1\141\37\uffff\1\141",
            "\1\145\37\uffff\1\145",
            "",
            "",
            "",
            "",
            "\1\171",
            "",
            "\1\70\44\uffff\1\173\15\uffff\22\66\1\172\7\66",
            "\1\70\37\uffff\1\175\22\uffff\15\66\1\174\14\66",
            "\1\70\62\uffff\32\66",
            "",
            "",
            "\1\173\37\uffff\1\173",
            "\1\175\37\uffff\1\175",
            "\1\70\25\uffff\1\177\34\uffff\3\66\1\176\26\66",
            "\1\70\32\uffff\1\u0081\27\uffff\10\66\1\u0080\21\66",
            "\1\177\37\uffff\1\177",
            "\1\u0081\37\uffff\1\u0081",
            "\1\70\36\uffff\1\u0083\23\uffff\14\66\1\u0082\15\66",
            "\1\u0083\37\uffff\1\u0083",
            "\1\70\45\uffff\1\u0085\14\uffff\23\66\1\u0084\6\66",
            "\1\u0085\37\uffff\1\u0085",
            "\1\70\24\uffff\1\u0087\35\uffff\2\66\1\u0086\27\66",
            "\1\70\35\uffff\1\u0089\24\uffff\13\66\1\u0088\16\66",
            "\1\70\35\uffff\1\u008b\24\uffff\13\66\1\u008a\16\66",
            "\1\u0087\37\uffff\1\u0087",
            "\1\u0089\37\uffff\1\u0089",
            "\1\u008b\37\uffff\1\u008b",
            "\1\70\40\uffff\1\u008d\21\uffff\16\66\1\u008c\13\66",
            "\1\70\45\uffff\1\u008f\14\uffff\23\66\1\u008e\6\66",
            "\1\70\44\uffff\1\u0091\15\uffff\22\66\1\u0090\7\66",
            "\1\u008d\37\uffff\1\u008d",
            "\1\u008f\37\uffff\1\u008f",
            "\1\u0091\37\uffff\1\u0091",
            "\1\70\32\uffff\1\u0094\2\uffff\1\u0095\24\uffff\10\66\1\u0092"+
            "\2\66\1\u0093\16\66",
            "\1\u0094\2\uffff\1\u0095\34\uffff\1\u0094\2\uffff\1\u0095",
            "\1\70\45\uffff\1\u0097\14\uffff\23\66\1\u0096\6\66",
            "\1\70\27\uffff\1\u0099\32\uffff\5\66\1\u0098\24\66",
            "\1\u0097\37\uffff\1\u0097",
            "\1\u0099\37\uffff\1\u0099",
            "\1\70\43\uffff\1\u009b\16\uffff\21\66\1\u009a\10\66",
            "\1\70\62\uffff\13\66\1\u009c\16\66",
            "\1\u009b\37\uffff\1\u009b",
            "\1\70\52\uffff\1\u009e\7\uffff\30\66\1\u009d\1\66",
            "\1\u009e\37\uffff\1\u009e",
            "\1\70\37\uffff\1\u00a0\22\uffff\15\66\1\u009f\14\66",
            "\1\u00a0\37\uffff\1\u00a0",
            "\1\70\41\uffff\1\u00a2\20\uffff\17\66\1\u00a1\12\66",
            "\1\70\25\uffff\1\u00a4\34\uffff\3\66\1\u00a3\26\66",
            "\1\u00a2\37\uffff\1\u00a2",
            "\1\u00a4\37\uffff\1\u00a4",
            "\1\70\36\uffff\1\u00a6\23\uffff\14\66\1\u00a5\15\66",
            "\1\u00a6\37\uffff\1\u00a6",
            "\1\70\22\uffff\1\u00a9\37\uffff\1\u00a7\23\66\1\u00a8\5\66",
            "\1\u00a9\37\uffff\1\u00a9",
            "\1\70\43\uffff\1\u00ab\16\uffff\21\66\1\u00aa\10\66",
            "\1\u00ab\37\uffff\1\u00ab",
            "",
            "",
            "\1\uffff",
            "\1\151\26\uffff\1\151\1\uffff\1\152",
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
            "",
            "",
            "",
            "\1\70\26\uffff\1\u00ae\33\uffff\4\66\1\u00ad\25\66",
            "\1\u00ae\37\uffff\1\u00ae",
            "\1\70\40\uffff\1\u00b0\21\uffff\16\66\1\u00af\13\66",
            "\1\u00b0\37\uffff\1\u00b0",
            "\1\70\22\uffff\1\u00b2\37\uffff\1\u00b1\31\66",
            "\1\u00b2\37\uffff\1\u00b2",
            "\1\70\42\uffff\1\u00b4\17\uffff\20\66\1\u00b3\11\66",
            "\1\u00b4\37\uffff\1\u00b4",
            "\1\70\40\uffff\1\u00b6\21\uffff\16\66\1\u00b5\13\66",
            "\1\u00b6\37\uffff\1\u00b6",
            "\1\70\24\uffff\1\u00b8\35\uffff\2\66\1\u00b7\27\66",
            "\1\u00b8\37\uffff\1\u00b8",
            "\1\70\31\uffff\1\u00ba\30\uffff\7\66\1\u00b9\22\66",
            "\1\u00ba\37\uffff\1\u00ba",
            "\1\70\35\uffff\1\u00bc\24\uffff\13\66\1\u00bb\16\66",
            "\1\u00bc\37\uffff\1\u00bc",
            "\1\70\35\uffff\1\u00be\24\uffff\13\66\1\u00bd\16\66",
            "\1\u00be\37\uffff\1\u00be",
            "\1\70\24\uffff\1\u00c0\35\uffff\2\66\1\u00bf\27\66",
            "\1\u00c0\37\uffff\1\u00c0",
            "\1\70\31\uffff\1\u00c2\30\uffff\7\66\1\u00c1\22\66",
            "\1\u00c2\37\uffff\1\u00c2",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\70\22\uffff\1\u00c5\37\uffff\1\u00c4\31\66",
            "\1\70\40\uffff\1\u00c7\21\uffff\16\66\1\u00c6\13\66",
            "\1\u00c5\37\uffff\1\u00c5",
            "\1\u00c7\37\uffff\1\u00c7",
            "\1\70\26\uffff\1\u00c9\33\uffff\4\66\1\u00c8\25\66",
            "\1\u00c9\37\uffff\1\u00c9",
            "\1\70\22\uffff\1\u00cb\37\uffff\1\u00ca\31\66",
            "\1\u00cb\37\uffff\1\u00cb",
            "\1\70\24\uffff\1\u00cd\35\uffff\2\66\1\u00cc\27\66",
            "\1\u00cd\37\uffff\1\u00cd",
            "\1\70\62\uffff\22\66\1\u00ce\7\66",
            "\1\70\3\uffff\1\u00cf\56\uffff\32\66",
            "\1\u00cf",
            "\1\70\30\uffff\1\u00d1\31\uffff\6\66\1\u00d0\23\66",
            "\1\u00d1\37\uffff\1\u00d1",
            "\1\u00d2\1\70\62\uffff\32\66",
            "\1\u00d2",
            "\1\70\26\uffff\1\u00d4\33\uffff\4\66\1\u00d3\25\66",
            "\1\u00d4\37\uffff\1\u00d4",
            "\1\70\23\uffff\1\u00d6\36\uffff\1\66\1\u00d5\30\66",
            "\1\u00d6\37\uffff\1\u00d6",
            "\1\70\37\uffff\1\u00d8\22\uffff\15\66\1\u00d7\14\66",
            "\1\70\62\uffff\4\66\1\u00d9\25\66",
            "\1\u00d8\37\uffff\1\u00d8",
            "\1\70\45\uffff\1\u00db\14\uffff\23\66\1\u00da\6\66",
            "\1\u00db\37\uffff\1\u00db",
            "",
            "\1\70\43\uffff\1\u00dd\16\uffff\21\66\1\u00dc\10\66",
            "\1\u00dd\37\uffff\1\u00dd",
            "\1\70\43\uffff\1\u00df\16\uffff\21\66\1\u00de\10\66",
            "\1\u00df\37\uffff\1\u00df",
            "\1\70\45\uffff\1\u00e1\14\uffff\23\66\1\u00e0\6\66",
            "\1\u00e1\37\uffff\1\u00e1",
            "\1\70\46\uffff\1\u00e3\13\uffff\24\66\1\u00e2\5\66",
            "\1\u00e3\37\uffff\1\u00e3",
            "\1\70\47\uffff\1\u00e5\12\uffff\25\66\1\u00e4\4\66",
            "\1\u00e5\37\uffff\1\u00e5",
            "\1\70\31\uffff\1\u00e7\30\uffff\7\66\1\u00e6\22\66",
            "\1\u00e7\37\uffff\1\u00e7",
            "\1\70\26\uffff\1\u00e9\33\uffff\4\66\1\u00e8\25\66",
            "\1\u00e9\37\uffff\1\u00e9",
            "\1\70\25\uffff\1\u00eb\34\uffff\3\66\1\u00ea\26\66",
            "\1\u00eb\37\uffff\1\u00eb",
            "\1\70\26\uffff\1\u00ed\33\uffff\4\66\1\u00ec\25\66",
            "\1\u00ed\37\uffff\1\u00ed",
            "\1\70\26\uffff\1\u00ef\33\uffff\4\66\1\u00ee\25\66",
            "\1\u00ef\37\uffff\1\u00ef",
            "\1\u00f0\1\70\62\uffff\32\66",
            "\1\u00f0",
            "",
            "\1\70\44\uffff\1\u00f2\15\uffff\22\66\1\u00f1\7\66",
            "\1\u00f2\37\uffff\1\u00f2",
            "\1\70\50\uffff\1\u00f4\11\uffff\26\66\1\u00f3\3\66",
            "\1\u00f4\37\uffff\1\u00f4",
            "\1\70\27\uffff\1\u00f6\32\uffff\5\66\1\u00f5\24\66",
            "\1\u00f6\37\uffff\1\u00f6",
            "\1\70\46\uffff\1\u00f8\13\uffff\24\66\1\u00f7\5\66",
            "\1\u00f8\37\uffff\1\u00f8",
            "\1\70\26\uffff\1\u00fa\33\uffff\4\66\1\u00f9\25\66",
            "\1\u00fa\37\uffff\1\u00fa",
            "\1\70\62\uffff\4\66\1\u00fb\25\66",
            "\1\u00fc\37\uffff\1\u00fc",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\70\26\uffff\1\u0100\33\uffff\4\66\1\u00ff\25\66",
            "\1\u0100\37\uffff\1\u0100",
            "\1\70\44\uffff\1\u0102\15\uffff\22\66\1\u0101\7\66",
            "\1\u0102\37\uffff\1\u0102",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\1\70\46\uffff\1\u0105\13\uffff\24\66\1\u0104\5\66",
            "\1\u0105\37\uffff\1\u0105",
            "\1\70\45\uffff\1\u0107\14\uffff\23\66\1\u0106\6\66",
            "\1\u0107\37\uffff\1\u0107",
            "\1\70\26\uffff\1\u0109\33\uffff\4\66\1\u0108\25\66",
            "\1\u0109\37\uffff\1\u0109",
            "\1\70\26\uffff\1\u010b\33\uffff\4\66\1\u010a\25\66",
            "\1\u010b\37\uffff\1\u010b",
            "\1\70\26\uffff\1\u010d\33\uffff\4\66\1\u010c\25\66",
            "\1\u010d\37\uffff\1\u010d",
            "\1\70\26\uffff\1\u010f\33\uffff\4\66\1\u010e\25\66",
            "\1\u010f\37\uffff\1\u010f",
            "\1\70\36\uffff\1\u0111\23\uffff\14\66\1\u0110\15\66",
            "\1\u0111\37\uffff\1\u0111",
            "\1\70\46\uffff\1\u0113\13\uffff\24\66\1\u0112\5\66",
            "\1\u0113\37\uffff\1\u0113",
            "\1\70\26\uffff\1\u0115\33\uffff\4\66\1\u0114\25\66",
            "\1\u0115\37\uffff\1\u0115",
            "\1\70\24\uffff\1\u0117\35\uffff\2\66\1\u0116\27\66",
            "\1\u0117\37\uffff\1\u0117",
            "\1\70\44\uffff\1\u0119\15\uffff\22\66\1\u0118\7\66",
            "\1\u0119\37\uffff\1\u0119",
            "",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\70\37\uffff\1\u011c\22\uffff\15\66\1\u011b\14\66",
            "\1\u011c\37\uffff\1\u011c",
            "\1\70\40\uffff\1\u011e\21\uffff\16\66\1\u011d\13\66",
            "\1\u011e\37\uffff\1\u011e",
            "\1\70\35\uffff\1\u0120\24\uffff\13\66\1\u011f\16\66",
            "\1\u0120\37\uffff\1\u0120",
            "\1\70\50\uffff\1\u0122\11\uffff\26\66\1\u0121\3\66",
            "\1\u0122\37\uffff\1\u0122",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\1\u0123\37\uffff\1\u0123",
            "",
            "",
            "\1\70\43\uffff\1\u0125\16\uffff\21\66\1\u0124\10\66",
            "\1\u0125\37\uffff\1\u0125",
            "\1\70\35\uffff\1\u0127\24\uffff\13\66\1\u0126\16\66",
            "\1\u0127\37\uffff\1\u0127",
            "",
            "\1\70\22\uffff\1\u0129\37\uffff\1\u0128\31\66",
            "\1\u0129\37\uffff\1\u0129",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\u012a\1\uffff\32"+
            "\66",
            "\12\67\7\uffff\32\67\4\uffff\1\u012a\1\uffff\32\67",
            "\1\70\34\uffff\1\u012e\2\uffff\1\u012f\22\uffff\12\66\1\u012c"+
            "\2\66\1\u012d\14\66",
            "\1\u012e\2\uffff\1\u012f\34\uffff\1\u012e\2\uffff\1\u012f",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\70\40\uffff\1\u0134\21\uffff\16\66\1\u0133\13\66",
            "\1\u0134\37\uffff\1\u0134",
            "\1\70\37\uffff\1\u0136\22\uffff\15\66\1\u0135\14\66",
            "\1\u0136\37\uffff\1\u0136",
            "\1\70\24\uffff\1\u0138\35\uffff\2\66\1\u0137\27\66",
            "\1\u0138\37\uffff\1\u0138",
            "\1\70\45\uffff\1\u013a\14\uffff\23\66\1\u0139\6\66",
            "\1\u013a\37\uffff\1\u013a",
            "\1\70\44\uffff\1\u013c\15\uffff\22\66\1\u013b\7\66",
            "\1\u013c\37\uffff\1\u013c",
            "",
            "\1\70\46\uffff\1\u013e\13\uffff\24\66\1\u013d\5\66",
            "\1\u013e\37\uffff\1\u013e",
            "\1\70\43\uffff\1\u0140\16\uffff\21\66\1\u013f\10\66",
            "\1\u0140\37\uffff\1\u0140",
            "\1\70\45\uffff\1\u0142\14\uffff\23\66\1\u0141\6\66",
            "\1\u0142\37\uffff\1\u0142",
            "\1\70\43\uffff\1\u0144\16\uffff\21\66\1\u0143\10\66",
            "\1\u0144\37\uffff\1\u0144",
            "\1\u0145\37\uffff\1\u0145",
            "\1\70\27\uffff\1\u0147\32\uffff\5\66\1\u0146\24\66",
            "\1\u0147\37\uffff\1\u0147",
            "\1\70\22\uffff\1\u0149\37\uffff\1\u0148\31\66",
            "\1\u0149\37\uffff\1\u0149",
            "\1\70\35\uffff\1\u014b\24\uffff\13\66\1\u014a\16\66",
            "\1\u014b\37\uffff\1\u014b",
            "\1\u014c\37\uffff\1\u014c",
            "",
            "\1\70\26\uffff\1\u014e\33\uffff\4\66\1\u014d\25\66",
            "\1\70\46\uffff\1\u0150\13\uffff\24\66\1\u014f\5\66",
            "\1\u014e\37\uffff\1\u014e",
            "\1\u0150\37\uffff\1\u0150",
            "",
            "",
            "",
            "\1\70\25\uffff\1\u0152\34\uffff\3\66\1\u0151\26\66",
            "\1\u0152\37\uffff\1\u0152",
            "\1\70\32\uffff\1\u0154\27\uffff\10\66\1\u0153\21\66",
            "\1\u0154\37\uffff\1\u0154",
            "\1\70\40\uffff\1\u0156\21\uffff\16\66\1\u0155\13\66",
            "\1\u0156\37\uffff\1\u0156",
            "\1\70\32\uffff\1\u0158\27\uffff\10\66\1\u0157\21\66",
            "\1\u0158\37\uffff\1\u0158",
            "\1\70\40\uffff\1\u015a\21\uffff\16\66\1\u0159\13\66",
            "\1\u015a\37\uffff\1\u015a",
            "\1\70\35\uffff\1\u015c\24\uffff\13\66\1\u015b\16\66",
            "\1\u015c\37\uffff\1\u015c",
            "\1\70\36\uffff\1\u015e\23\uffff\14\66\1\u015d\15\66",
            "\1\u015e\37\uffff\1\u015e",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\70\32\uffff\1\u0161\27\uffff\10\66\1\u0160\21\66",
            "\1\u0161\37\uffff\1\u0161",
            "\1\u0162\37\uffff\1\u0162",
            "\1\70\40\uffff\1\u0164\21\uffff\16\66\1\u0163\13\66",
            "\1\u0164\37\uffff\1\u0164",
            "\1\70\45\uffff\1\u0166\14\uffff\23\66\1\u0165\6\66",
            "\1\u0166\37\uffff\1\u0166",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0168\37\uffff\1\u0168",
            "\1\70\52\uffff\1\u016a\7\uffff\30\66\1\u0169\1\66",
            "\1\u016a\37\uffff\1\u016a",
            "\1\70\35\uffff\1\u016c\24\uffff\13\66\1\u016b\16\66",
            "\1\u016c\37\uffff\1\u016c",
            "\1\70\26\uffff\1\u016e\33\uffff\4\66\1\u016d\25\66",
            "\1\u016e\37\uffff\1\u016e",
            "\1\70\42\uffff\1\u0170\17\uffff\20\66\1\u016f\11\66",
            "\1\u0170\37\uffff\1\u0170",
            "\1\70\43\uffff\1\u0172\16\uffff\21\66\1\u0171\10\66",
            "\1\u0172\37\uffff\1\u0172",
            "\1\70\40\uffff\1\u0174\21\uffff\16\66\1\u0173\13\66",
            "\1\u0174\37\uffff\1\u0174",
            "\1\70\43\uffff\1\u0176\16\uffff\21\66\1\u0175\10\66",
            "\1\u0176\37\uffff\1\u0176",
            "\1\70\35\uffff\1\u0178\24\uffff\13\66\1\u0177\16\66",
            "\1\u0178\37\uffff\1\u0178",
            "\1\70\22\uffff\1\u017a\37\uffff\1\u0179\31\66",
            "\1\u017a\37\uffff\1\u017a",
            "",
            "\1\70\45\uffff\1\u017c\14\uffff\23\66\1\u017b\6\66",
            "\1\u017c\37\uffff\1\u017c",
            "\1\u017d\37\uffff\1\u017d",
            "\1\70\43\uffff\1\u017f\16\uffff\21\66\1\u017e\10\66",
            "\1\u017f\37\uffff\1\u017f",
            "\1\70\40\uffff\1\u0181\21\uffff\16\66\1\u0180\13\66",
            "\1\u0181\37\uffff\1\u0181",
            "",
            "\1\u0182\37\uffff\1\u0182",
            "\1\70\24\uffff\1\u0184\35\uffff\2\66\1\u0183\27\66",
            "\1\u0184\37\uffff\1\u0184",
            "\1\70\35\uffff\1\u0186\24\uffff\13\66\1\u0185\16\66",
            "\1\u0186\37\uffff\1\u0186",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\70\46\uffff\1\u0189\13\uffff\24\66\1\u0188\5\66",
            "\1\u0189\37\uffff\1\u0189",
            "\1\70\22\uffff\1\u018b\37\uffff\1\u018a\31\66",
            "\1\u018b\37\uffff\1\u018b",
            "\1\70\37\uffff\1\u018d\22\uffff\15\66\1\u018c\14\66",
            "\1\u018d\37\uffff\1\u018d",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\70\45\uffff\1\u0191\14\uffff\23\66\1\u0190\6\66",
            "\1\u0191\37\uffff\1\u0191",
            "\1\70\26\uffff\1\u0193\33\uffff\4\66\1\u0192\25\66",
            "\1\u0193\37\uffff\1\u0193",
            "\1\u0194",
            "\1\70\36\uffff\1\u0196\23\uffff\14\66\1\u0195\15\66",
            "\1\u0196\37\uffff\1\u0196",
            "\1\70\43\uffff\1\u0198\16\uffff\21\66\1\u0197\10\66",
            "\1\u0198\37\uffff\1\u0198",
            "\1\u0199\37\uffff\1\u0199",
            "\1\70\22\uffff\1\u019b\37\uffff\1\u019a\31\66",
            "\1\u019b\37\uffff\1\u019b",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\70\26\uffff\1\u019e\33\uffff\4\66\1\u019d\25\66",
            "\1\u019e\37\uffff\1\u019e",
            "\1\70\45\uffff\1\u01a0\14\uffff\23\66\1\u019f\6\66",
            "\1\u01a0\37\uffff\1\u01a0",
            "\1\u01a1\1\70\62\uffff\32\66",
            "\1\u01a1",
            "",
            "",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\70\22\uffff\1\u01a5\37\uffff\1\u01a4\31\66",
            "\1\u01a5\37\uffff\1\u01a5",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u01a7\37\uffff\1\u01a7",
            "\1\70\44\uffff\1\u01a9\15\uffff\22\66\1\u01a8\7\66",
            "\1\u01a9\37\uffff\1\u01a9",
            "",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\70\40\uffff\1\u01ac\21\uffff\16\66\1\u01ab\13\66",
            "\1\u01ac\37\uffff\1\u01ac",
            "",
            "",
            "",
            "\1\70\45\uffff\1\u01ae\14\uffff\23\66\1\u01ad\6\66",
            "\1\u01ae\37\uffff\1\u01ae",
            "",
            "\1\u01af\37\uffff\1\u01af",
            "\1\70\26\uffff\1\u01b1\33\uffff\4\66\1\u01b0\25\66",
            "\1\u01b1\37\uffff\1\u01b1",
            "",
            "\1\70\43\uffff\1\u01b3\16\uffff\21\66\1\u01b2\10\66",
            "\1\u01b3\37\uffff\1\u01b3",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual | Comma | Dot | DoubleQuote | Semicolon | RBracket | LBracket | LParenthesis | RParenthesis | Equals | Or | Bool | Macrodef | ValueAssignement | SpecialAttribute | DocumentID | Identifier | Classname | Comment | QuotedField | Field | Ws | Lb | Char | NextRow );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA28_104 = input.LA(1);

                         
                        int index28_104 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((isHeader() == false)))) ) {s = 172;}

                        else if ( ((isHeader() == false)) ) {s = 107;}

                         
                        input.seek(index28_104);

                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA28_24 = input.LA(1);

                         
                        int index28_24 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA28_24 >= '\u0000' && LA28_24 <= '\t')||(LA28_24 >= '\u000B' && LA28_24 <= '\f')||(LA28_24 >= '\u000E' && LA28_24 <= '+')||(LA28_24 >= '-' && LA28_24 <= ':')||(LA28_24 >= '<' && LA28_24 <= 'Z')||LA28_24=='\\'||(LA28_24 >= '^' && LA28_24 <= '\uFFFF')) && (((isArgumentModifierAssignment())||(isMacroAssignment())))) {s = 113;}

                        else if ( (LA28_24==','||LA28_24==';'||LA28_24=='['||LA28_24==']') && ((isMacroAssignment()))) {s = 114;}

                        else s = 112;

                         
                        input.seek(index28_24);

                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA28_0 = input.LA(1);

                        s = -1;
                        if ( (LA28_0=='i') ) {s = 1;}

                        else if ( (LA28_0=='u') ) {s = 2;}

                        else if ( (LA28_0=='r') ) {s = 3;}

                        else if ( (LA28_0=='b') ) {s = 4;}

                        else if ( (LA28_0=='c') ) {s = 5;}

                        else if ( (LA28_0=='p') ) {s = 6;}

                        else if ( (LA28_0=='a') ) {s = 7;}

                        else if ( (LA28_0=='d') ) {s = 8;}

                        else if ( (LA28_0=='f') ) {s = 9;}

                        else if ( (LA28_0=='k') ) {s = 10;}

                        else if ( (LA28_0=='l') ) {s = 11;}

                        else if ( (LA28_0=='m') ) {s = 12;}

                        else if ( (LA28_0=='n') ) {s = 13;}

                        else if ( (LA28_0=='t') ) {s = 14;}

                        else if ( (LA28_0=='v') ) {s = 15;}

                        else if ( (LA28_0==',') ) {s = 16;}

                        else if ( (LA28_0=='.') ) {s = 17;}

                        else if ( (LA28_0=='\"') ) {s = 18;}

                        else if ( (LA28_0==';') ) {s = 19;}

                        else if ( (LA28_0==']') ) {s = 20;}

                        else if ( (LA28_0=='[') ) {s = 21;}

                        else if ( (LA28_0=='(') ) {s = 22;}

                        else if ( (LA28_0==')') ) {s = 23;}

                        else if ( (LA28_0=='=') ) {s = 24;}

                        else if ( (LA28_0=='|') ) {s = 25;}

                        else if ( (LA28_0=='T') ) {s = 26;}

                        else if ( (LA28_0=='F') ) {s = 27;}

                        else if ( (LA28_0=='$') ) {s = 28;}

                        else if ( (LA28_0=='@') ) {s = 30;}

                        else if ( (LA28_0=='&') ) {s = 31;}

                        else if ( (LA28_0=='e'||(LA28_0 >= 'g' && LA28_0 <= 'h')||LA28_0=='j'||LA28_0=='o'||LA28_0=='q'||LA28_0=='s'||(LA28_0 >= 'w' && LA28_0 <= 'z')) ) {s = 32;}

                        else if ( (LA28_0=='I') ) {s = 33;}

                        else if ( (LA28_0=='U') ) {s = 34;}

                        else if ( (LA28_0=='R') ) {s = 35;}

                        else if ( (LA28_0=='B') ) {s = 36;}

                        else if ( (LA28_0=='C') ) {s = 37;}

                        else if ( (LA28_0=='P') ) {s = 38;}

                        else if ( (LA28_0=='A') ) {s = 39;}

                        else if ( (LA28_0=='D') ) {s = 40;}

                        else if ( (LA28_0=='K') ) {s = 41;}

                        else if ( (LA28_0=='L') ) {s = 42;}

                        else if ( (LA28_0=='M') ) {s = 43;}

                        else if ( (LA28_0=='N') ) {s = 44;}

                        else if ( (LA28_0=='V') ) {s = 45;}

                        else if ( (LA28_0=='E'||(LA28_0 >= 'G' && LA28_0 <= 'H')||LA28_0=='J'||LA28_0=='O'||LA28_0=='Q'||LA28_0=='S'||(LA28_0 >= 'W' && LA28_0 <= 'Z')||LA28_0=='_') ) {s = 46;}

                        else if ( (LA28_0=='#') ) {s = 47;}

                        else if ( (LA28_0=='\t'||LA28_0==' ') ) {s = 48;}

                        else if ( (LA28_0=='\n'||LA28_0=='\r') ) {s = 49;}

                        else if ( (LA28_0=='\\') ) {s = 50;}

                        else if ( ((LA28_0 >= '\u0000' && LA28_0 <= '\b')||(LA28_0 >= '\u000B' && LA28_0 <= '\f')||(LA28_0 >= '\u000E' && LA28_0 <= '\u001F')||LA28_0=='!'||LA28_0=='%'||LA28_0=='\''||(LA28_0 >= '*' && LA28_0 <= '+')||LA28_0=='-'||(LA28_0 >= '/' && LA28_0 <= ':')||LA28_0=='<'||(LA28_0 >= '>' && LA28_0 <= '?')||LA28_0=='^'||LA28_0=='`'||LA28_0=='{'||(LA28_0 >= '}' && LA28_0 <= '\uFFFF')) ) {s = 51;}

                        else s = 29;

                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA28_105 = input.LA(1);

                         
                        int index28_105 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA28_105=='\"') && ((isHeader() == false))) {s = 106;}

                        else if ( (LA28_105=='\t'||LA28_105==' ') && ((isHeader() == false))) {s = 105;}

                        else s = 107;

                         
                        input.seek(index28_105);

                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA28_19 = input.LA(1);

                         
                        int index28_19 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA28_19=='\t'||LA28_19==' ') && ((isHeader() == false))) {s = 105;}

                        else if ( (LA28_19=='\"') && ((isHeader() == false))) {s = 106;}

                        else if ( ((LA28_19 >= '\u0000' && LA28_19 <= '\b')||(LA28_19 >= '\u000B' && LA28_19 <= '\f')||(LA28_19 >= '\u000E' && LA28_19 <= '\u001F')||LA28_19=='!'||(LA28_19 >= '#' && LA28_19 <= ':')||(LA28_19 >= '<' && LA28_19 <= '\uFFFF')) && ((isHeader() == false))) {s = 107;}

                        else s = 104;

                         
                        input.seek(index28_19);

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 28, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}