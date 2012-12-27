// $ANTLR 3.4 /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g 2012-12-26 09:13:40

 package output;  

import java.util.regex.Pattern;
import java.util.regex.Matcher;



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
    public static final int BeanShell=13;
    public static final int Bool=14;
    public static final int CacheUnique=15;
    public static final int CellDecorator=16;
    public static final int Char=17;
    public static final int Classname=18;
    public static final int CollectionDelimiter=19;
    public static final int Comma=20;
    public static final int Comment=21;
    public static final int DOCUMENTID=22;
    public static final int DOCUMENTID_REF=23;
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
    public static final int ITEM_EXPRESSION=37;
    public static final int Identifier=38;
    public static final int IgnoreKeyCase=39;
    public static final int IgnoreNull=40;
    public static final int Insert=41;
    public static final int InsertUpdate=42;
    public static final int KeyToValueDelimiter=43;
    public static final int LBracket=44;
    public static final int LParenthesis=45;
    public static final int Lang=46;
    public static final int Lb=47;
    public static final int MACRO_REF=48;
    public static final int MODIFIER=49;
    public static final int MODIFIERS=50;
    public static final int Macrodef=51;
    public static final int MapDelimiter=52;
    public static final int Mode=53;
    public static final int NextRow=54;
    public static final int NumberFormat=55;
    public static final int Or=56;
    public static final int PathDelimiter=57;
    public static final int Pos=58;
    public static final int Processor=59;
    public static final int QuotedField=60;
    public static final int RBracket=61;
    public static final int RECORD=62;
    public static final int RECORDS=63;
    public static final int RParenthesis=64;
    public static final int Remove=65;
    public static final int SUBTYPE=66;
    public static final int Semicolon=67;
    public static final int Separator=68;
    public static final int SpecialAttribute=69;
    public static final int TYPE=70;
    public static final int Translator=71;
    public static final int Unique=72;
    public static final int Update=73;
    public static final int UserRights=74;
    public static final int ValueAssignment=75;
    public static final int Virtual=76;
    public static final int Ws=77;

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

        private String removeSeparators(final String text) {
            final Pattern p = Pattern.compile("([ \t]*)\\\\([ \t]*)(\r?\n|\r)([ \t]*)");
            final Matcher m = p.matcher(text);
            final StringBuffer sb = new StringBuffer();
            while (m.find()) {
                final boolean noWhitespaceCaptured = m.group(1).isEmpty() && m.group(4).isEmpty();
                m.appendReplacement(sb, noWhitespaceCaptured ? "" : " ");
            }
            m.appendTail(sb);
            return sb.toString();
        }
        
        private String removeLineBreaks(final String text){
            return text.replaceAll("(\r?\n|\r)", "");
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:334:9: ( ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:334:10: ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:335:15: ( ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' ) '_' ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:335:16: ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' ) '_' ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:336:9: ( ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:336:10: ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:337:9: ( ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'V' | 'v' ) ( 'E' | 'e' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:337:10: ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'V' | 'v' ) ( 'E' | 'e' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:339:12: ( ( 'B' | 'b' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'D' | 'd' ) ( 'E' | 'e' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:339:13: ( 'B' | 'b' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'D' | 'd' ) ( 'E' | 'e' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:340:14: ( ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'E' | 'e' ) ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:340:15: ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'E' | 'e' ) ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'E' | 'e' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:341:12: ( ( 'P' | 'p' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'S' | 's' ) ( 'O' | 'o' ) ( 'R' | 'r' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:341:13: ( 'P' | 'p' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'S' | 's' ) ( 'O' | 'o' ) ( 'R' | 'r' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:347:8: ( ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'A' | 'a' ) ( 'S' | 's' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:347:9: ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'A' | 'a' ) ( 'S' | 's' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:348:12: ( ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'W' | 'w' ) ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'L' | 'l' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:348:13: ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'W' | 'w' ) ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'L' | 'l' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:349:15: ( ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'O' | 'o' ) ( 'R' | 'r' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:349:16: ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'O' | 'o' ) ( 'R' | 'r' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:350:22: ( ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:350:23: ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:351:13: ( ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'T' | 't' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:351:14: ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'T' | 't' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:352:10: ( ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'A' | 'a' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'T' | 't' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:352:11: ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'A' | 'a' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'T' | 't' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:353:13: ( ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'W' | 'w' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:353:14: ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'W' | 'w' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:354:15: ( ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'N' | 'n' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'K' | 'k' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'E' | 'e' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:354:16: ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'N' | 'n' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'K' | 'k' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'E' | 'e' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:355:13: ( ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'N' | 'n' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'L' | 'l' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:355:14: ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'N' | 'n' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'L' | 'l' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:356:21: ( ( 'K' | 'k' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) '2' ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:356:22: ( 'K' | 'k' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) '2' ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:357:7: ( ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'G' | 'g' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:357:8: ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'G' | 'g' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:358:14: ( ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'P' | 'p' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:358:15: ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'P' | 'p' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:359:7: ( ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'D' | 'd' ) ( 'E' | 'e' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:359:8: ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'D' | 'd' ) ( 'E' | 'e' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:360:14: ( ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'B' | 'b' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'T' | 't' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:360:15: ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'B' | 'b' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'T' | 't' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:361:15: ( ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'H' | 'h' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:361:16: ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'H' | 'h' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:362:6: ( ( 'P' | 'p' ) ( 'O' | 'o' ) ( 'S' | 's' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:362:7: ( 'P' | 'p' ) ( 'O' | 'o' ) ( 'S' | 's' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:363:13: ( ( 'T' | 't' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'O' | 'o' ) ( 'R' | 'r' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:363:14: ( 'T' | 't' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'O' | 'o' ) ( 'R' | 'r' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:364:9: ( ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:364:10: ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'E' | 'e' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:365:10: ( ( 'V' | 'v' ) ( 'I' | 'i' ) ( 'R' | 'r' ) ( 'T' | 't' ) ( 'U' | 'u' ) ( 'A' | 'a' ) ( 'L' | 'l' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:365:11: ( 'V' | 'v' ) ( 'I' | 'i' ) ( 'R' | 'r' ) ( 'T' | 't' ) ( 'U' | 'u' ) ( 'A' | 'a' ) ( 'L' | 'l' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:389:8: ( ',' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:389:9: ','
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:390:5: ( '.' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:390:6: '.'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:391:13: ( '\"' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:391:14: '\"'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:392:11: ( ';' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:392:12: ';'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:393:10: ( ']' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:393:11: ']'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:394:10: ( '[' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:394:11: '['
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:395:15: ( '(' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:395:16: '('
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:396:14: ( ')' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:396:15: ')'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:397:8: ( '=' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:397:9: '='
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:398:4: ( '|' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:398:5: '|'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:400:6: ( 'true' | 'false' )
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
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:400:7: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:400:16: 'false'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:403:2: ( Insert | InsertUpdate | Update | Remove )
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
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:403:4: Insert
                    {
                    mInsert(); 


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:403:13: InsertUpdate
                    {
                    mInsertUpdate(); 


                    }
                    break;
                case 3 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:403:28: Update
                    {
                    mUpdate(); 


                    }
                    break;
                case 4 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:403:37: Remove
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:406:2: ( BatchMode | CacheUnique | Processor )
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
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:406:3: BatchMode
                    {
                    mBatchMode(); 


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:406:15: CacheUnique
                    {
                    mCacheUnique(); 


                    }
                    break;
                case 3 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:406:29: Processor
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:409:2: ( Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual )
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
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:409:3: Alias
                    {
                    mAlias(); 


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:409:11: AllowNull
                    {
                    mAllowNull(); 


                    }
                    break;
                case 3 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:409:23: CellDecorator
                    {
                    mCellDecorator(); 


                    }
                    break;
                case 4 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:409:39: CollectionDelimiter
                    {
                    mCollectionDelimiter(); 


                    }
                    break;
                case 5 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:409:61: Dateformat
                    {
                    mDateformat(); 


                    }
                    break;
                case 6 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:409:74: Default
                    {
                    mDefault(); 


                    }
                    break;
                case 7 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:409:84: ForceWrite
                    {
                    mForceWrite(); 


                    }
                    break;
                case 8 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:409:97: IgnoreKeyCase
                    {
                    mIgnoreKeyCase(); 


                    }
                    break;
                case 9 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:409:113: IgnoreNull
                    {
                    mIgnoreNull(); 


                    }
                    break;
                case 10 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:410:4: KeyToValueDelimiter
                    {
                    mKeyToValueDelimiter(); 


                    }
                    break;
                case 11 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:410:26: Lang
                    {
                    mLang(); 


                    }
                    break;
                case 12 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:410:33: MapDelimiter
                    {
                    mMapDelimiter(); 


                    }
                    break;
                case 13 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:410:48: Mode
                    {
                    mMode(); 


                    }
                    break;
                case 14 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:410:55: NumberFormat
                    {
                    mNumberFormat(); 


                    }
                    break;
                case 15 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:410:70: PathDelimiter
                    {
                    mPathDelimiter(); 


                    }
                    break;
                case 16 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:410:86: Pos
                    {
                    mPos(); 


                    }
                    break;
                case 17 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:410:92: Translator
                    {
                    mTranslator(); 


                    }
                    break;
                case 18 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:410:105: Unique
                    {
                    mUnique(); 


                    }
                    break;
                case 19 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:410:114: Virtual
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

    // $ANTLR start "Separator"
    public final void mSeparator() throws RecognitionException {
        try {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:412:20: ( '\\\\' ( Ws )* Lb )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:412:21: '\\\\' ( Ws )* Lb
            {
            match('\\'); 

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:412:26: ( Ws )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='\t'||LA5_0==' ') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:412:26: Ws
            	    {
            	    mWs(); 


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);


            mLb(); 


            }


        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Separator"

    // $ANTLR start "Macrodef"
    public final void mMacrodef() throws RecognitionException {
        try {
            int _type = Macrodef;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:417:2: ( '$' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:417:3: '$' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:417:39: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0 >= '0' && LA6_0 <= '9')||(LA6_0 >= 'A' && LA6_0 <= 'Z')||LA6_0=='_'||(LA6_0 >= 'a' && LA6_0 <= 'z')) ) {
                    alt6=1;
                }


                switch (alt6) {
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
            	    break loop6;
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

    // $ANTLR start "ValueAssignment"
    public final void mValueAssignment() throws RecognitionException {
        try {
            int _type = ValueAssignment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:420:2: ({...}? => '=' (~ ( '\\r' | '\\n' ) | Separator )* |{...}? => '=' ( ( ' ' | '\\t' )* '\"' (~ ( '\\r' | '\\n' | '\"' ) | '\"' '\"' )* '\"' | (~ ( '\\r' | '\\n' | ';' | '\"' | '[' | ']' | ',' ) )* ) |)
            int alt12=3;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='=') && (((isArgumentModifierAssignment())||(isMacroAssignment())))) {
                int LA12_1 = input.LA(2);

                if ( ((isMacroAssignment())) ) {
                    alt12=1;
                }
                else if ( ((isArgumentModifierAssignment())) ) {
                    alt12=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;

                }
            }
            else {
                alt12=3;
            }
            switch (alt12) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:420:3: {...}? => '=' (~ ( '\\r' | '\\n' ) | Separator )*
                    {
                    if ( !((isMacroAssignment())) ) {
                        throw new FailedPredicateException(input, "ValueAssignment", "isMacroAssignment()");
                    }

                    match('='); 

                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:420:34: (~ ( '\\r' | '\\n' ) | Separator )*
                    loop7:
                    do {
                        int alt7=3;
                        alt7 = dfa7.predict(input);
                        switch (alt7) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:420:35: ~ ( '\\r' | '\\n' )
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
                    	case 2 :
                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:420:52: Separator
                    	    {
                    	    mSeparator(); 


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    String text = removeSeparators(getText()); setText(text.substring(1, text.length()).trim());

                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:421:3: {...}? => '=' ( ( ' ' | '\\t' )* '\"' (~ ( '\\r' | '\\n' | '\"' ) | '\"' '\"' )* '\"' | (~ ( '\\r' | '\\n' | ';' | '\"' | '[' | ']' | ',' ) )* )
                    {
                    if ( !((isArgumentModifierAssignment())) ) {
                        throw new FailedPredicateException(input, "ValueAssignment", "isArgumentModifierAssignment()");
                    }

                    match('='); 

                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:421:44: ( ( ' ' | '\\t' )* '\"' (~ ( '\\r' | '\\n' | '\"' ) | '\"' '\"' )* '\"' | (~ ( '\\r' | '\\n' | ';' | '\"' | '[' | ']' | ',' ) )* )
                    int alt11=2;
                    alt11 = dfa11.predict(input);
                    switch (alt11) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:421:45: ( ' ' | '\\t' )* '\"' (~ ( '\\r' | '\\n' | '\"' ) | '\"' '\"' )* '\"'
                            {
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:421:45: ( ' ' | '\\t' )*
                            loop8:
                            do {
                                int alt8=2;
                                int LA8_0 = input.LA(1);

                                if ( (LA8_0=='\t'||LA8_0==' ') ) {
                                    alt8=1;
                                }


                                switch (alt8) {
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
                            	    break loop8;
                                }
                            } while (true);


                            match('\"'); 

                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:421:62: (~ ( '\\r' | '\\n' | '\"' ) | '\"' '\"' )*
                            loop9:
                            do {
                                int alt9=3;
                                int LA9_0 = input.LA(1);

                                if ( (LA9_0=='\"') ) {
                                    int LA9_1 = input.LA(2);

                                    if ( (LA9_1=='\"') ) {
                                        alt9=2;
                                    }


                                }
                                else if ( ((LA9_0 >= '\u0000' && LA9_0 <= '\t')||(LA9_0 >= '\u000B' && LA9_0 <= '\f')||(LA9_0 >= '\u000E' && LA9_0 <= '!')||(LA9_0 >= '#' && LA9_0 <= '\uFFFF')) ) {
                                    alt9=1;
                                }


                                switch (alt9) {
                            	case 1 :
                            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:421:63: ~ ( '\\r' | '\\n' | '\"' )
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
                            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:421:87: '\"' '\"'
                            	    {
                            	    match('\"'); 

                            	    match('\"'); 

                            	    }
                            	    break;

                            	default :
                            	    break loop9;
                                }
                            } while (true);


                            match('\"'); 

                            String text = getText().substring(1, getText().length()).trim(); setText(text.substring(1, text.length() - 1));

                            }
                            break;
                        case 2 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:421:217: (~ ( '\\r' | '\\n' | ';' | '\"' | '[' | ']' | ',' ) )*
                            {
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:421:217: (~ ( '\\r' | '\\n' | ';' | '\"' | '[' | ']' | ',' ) )*
                            loop10:
                            do {
                                int alt10=2;
                                int LA10_0 = input.LA(1);

                                if ( ((LA10_0 >= '\u0000' && LA10_0 <= '\t')||(LA10_0 >= '\u000B' && LA10_0 <= '\f')||(LA10_0 >= '\u000E' && LA10_0 <= '!')||(LA10_0 >= '#' && LA10_0 <= '+')||(LA10_0 >= '-' && LA10_0 <= ':')||(LA10_0 >= '<' && LA10_0 <= 'Z')||LA10_0=='\\'||(LA10_0 >= '^' && LA10_0 <= '\uFFFF')) ) {
                                    alt10=1;
                                }


                                switch (alt10) {
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
                            	    break loop10;
                                }
                            } while (true);


                            setText(getText().substring(1, getText().length()).trim());

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:422:3: 
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
    // $ANTLR end "ValueAssignment"

    // $ANTLR start "NextRow"
    public final void mNextRow() throws RecognitionException {
        try {
            int _type = NextRow;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:495:9: ( ( options {greedy=true; } : '\\\\' '\\\\' ( Ws )* Lb ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:495:10: ( options {greedy=true; } : '\\\\' '\\\\' ( Ws )* Lb )
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:495:10: ( options {greedy=true; } : '\\\\' '\\\\' ( Ws )* Lb )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:495:35: '\\\\' '\\\\' ( Ws )* Lb
            {
            match('\\'); 

            match('\\'); 

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:495:45: ( Ws )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0=='\t'||LA13_0==' ') ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:495:45: Ws
            	    {
            	    mWs(); 


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            mLb(); 


            }


            skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "NextRow"

    // $ANTLR start "UserRights"
    public final void mUserRights() throws RecognitionException {
        try {
            int _type = UserRights;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:498:2: ( '$START_USERRIGHTS' ( . )* '$END_USERRIGHTS' )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:498:3: '$START_USERRIGHTS' ( . )* '$END_USERRIGHTS'
            {
            match("$START_USERRIGHTS"); 



            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:498:23: ( . )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0=='$') ) {
                    int LA14_1 = input.LA(2);

                    if ( (LA14_1=='E') ) {
                        int LA14_3 = input.LA(3);

                        if ( (LA14_3=='N') ) {
                            int LA14_4 = input.LA(4);

                            if ( (LA14_4=='D') ) {
                                int LA14_5 = input.LA(5);

                                if ( (LA14_5=='_') ) {
                                    int LA14_6 = input.LA(6);

                                    if ( (LA14_6=='U') ) {
                                        int LA14_7 = input.LA(7);

                                        if ( (LA14_7=='S') ) {
                                            int LA14_8 = input.LA(8);

                                            if ( (LA14_8=='E') ) {
                                                int LA14_9 = input.LA(9);

                                                if ( (LA14_9=='R') ) {
                                                    int LA14_10 = input.LA(10);

                                                    if ( (LA14_10=='R') ) {
                                                        int LA14_11 = input.LA(11);

                                                        if ( (LA14_11=='I') ) {
                                                            int LA14_12 = input.LA(12);

                                                            if ( (LA14_12=='G') ) {
                                                                int LA14_13 = input.LA(13);

                                                                if ( (LA14_13=='H') ) {
                                                                    int LA14_14 = input.LA(14);

                                                                    if ( (LA14_14=='T') ) {
                                                                        int LA14_15 = input.LA(15);

                                                                        if ( (LA14_15=='S') ) {
                                                                            alt14=2;
                                                                        }
                                                                        else if ( ((LA14_15 >= '\u0000' && LA14_15 <= 'R')||(LA14_15 >= 'T' && LA14_15 <= '\uFFFF')) ) {
                                                                            alt14=1;
                                                                        }


                                                                    }
                                                                    else if ( ((LA14_14 >= '\u0000' && LA14_14 <= 'S')||(LA14_14 >= 'U' && LA14_14 <= '\uFFFF')) ) {
                                                                        alt14=1;
                                                                    }


                                                                }
                                                                else if ( ((LA14_13 >= '\u0000' && LA14_13 <= 'G')||(LA14_13 >= 'I' && LA14_13 <= '\uFFFF')) ) {
                                                                    alt14=1;
                                                                }


                                                            }
                                                            else if ( ((LA14_12 >= '\u0000' && LA14_12 <= 'F')||(LA14_12 >= 'H' && LA14_12 <= '\uFFFF')) ) {
                                                                alt14=1;
                                                            }


                                                        }
                                                        else if ( ((LA14_11 >= '\u0000' && LA14_11 <= 'H')||(LA14_11 >= 'J' && LA14_11 <= '\uFFFF')) ) {
                                                            alt14=1;
                                                        }


                                                    }
                                                    else if ( ((LA14_10 >= '\u0000' && LA14_10 <= 'Q')||(LA14_10 >= 'S' && LA14_10 <= '\uFFFF')) ) {
                                                        alt14=1;
                                                    }


                                                }
                                                else if ( ((LA14_9 >= '\u0000' && LA14_9 <= 'Q')||(LA14_9 >= 'S' && LA14_9 <= '\uFFFF')) ) {
                                                    alt14=1;
                                                }


                                            }
                                            else if ( ((LA14_8 >= '\u0000' && LA14_8 <= 'D')||(LA14_8 >= 'F' && LA14_8 <= '\uFFFF')) ) {
                                                alt14=1;
                                            }


                                        }
                                        else if ( ((LA14_7 >= '\u0000' && LA14_7 <= 'R')||(LA14_7 >= 'T' && LA14_7 <= '\uFFFF')) ) {
                                            alt14=1;
                                        }


                                    }
                                    else if ( ((LA14_6 >= '\u0000' && LA14_6 <= 'T')||(LA14_6 >= 'V' && LA14_6 <= '\uFFFF')) ) {
                                        alt14=1;
                                    }


                                }
                                else if ( ((LA14_5 >= '\u0000' && LA14_5 <= '^')||(LA14_5 >= '`' && LA14_5 <= '\uFFFF')) ) {
                                    alt14=1;
                                }


                            }
                            else if ( ((LA14_4 >= '\u0000' && LA14_4 <= 'C')||(LA14_4 >= 'E' && LA14_4 <= '\uFFFF')) ) {
                                alt14=1;
                            }


                        }
                        else if ( ((LA14_3 >= '\u0000' && LA14_3 <= 'M')||(LA14_3 >= 'O' && LA14_3 <= '\uFFFF')) ) {
                            alt14=1;
                        }


                    }
                    else if ( ((LA14_1 >= '\u0000' && LA14_1 <= 'D')||(LA14_1 >= 'F' && LA14_1 <= '\uFFFF')) ) {
                        alt14=1;
                    }


                }
                else if ( ((LA14_0 >= '\u0000' && LA14_0 <= '#')||(LA14_0 >= '%' && LA14_0 <= '\uFFFF')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:498:23: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);


            match("$END_USERRIGHTS"); 



            _channel=HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "UserRights"

    // $ANTLR start "BeanShell"
    public final void mBeanShell() throws RecognitionException {
        try {
            int _type = BeanShell;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:500:11: ( ( ( '#%' (~ ( '\\r' | '\\n' ) )* | '\"#%' (~ ( '\"' ) | '\"' '\"' )* '\"' ) ( Lb )? ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:500:12: ( ( '#%' (~ ( '\\r' | '\\n' ) )* | '\"#%' (~ ( '\"' ) | '\"' '\"' )* '\"' ) ( Lb )? )
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:500:12: ( ( '#%' (~ ( '\\r' | '\\n' ) )* | '\"#%' (~ ( '\"' ) | '\"' '\"' )* '\"' ) ( Lb )? )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:500:13: ( '#%' (~ ( '\\r' | '\\n' ) )* | '\"#%' (~ ( '\"' ) | '\"' '\"' )* '\"' ) ( Lb )?
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:500:13: ( '#%' (~ ( '\\r' | '\\n' ) )* | '\"#%' (~ ( '\"' ) | '\"' '\"' )* '\"' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0=='#') ) {
                alt17=1;
            }
            else if ( (LA17_0=='\"') ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;

            }
            switch (alt17) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:500:14: '#%' (~ ( '\\r' | '\\n' ) )*
                    {
                    match("#%"); 



                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:500:19: (~ ( '\\r' | '\\n' ) )*
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


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:500:37: '\"#%' (~ ( '\"' ) | '\"' '\"' )* '\"'
                    {
                    match("\"#%"); 



                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:500:43: (~ ( '\"' ) | '\"' '\"' )*
                    loop16:
                    do {
                        int alt16=3;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0=='\"') ) {
                            int LA16_1 = input.LA(2);

                            if ( (LA16_1=='\"') ) {
                                alt16=2;
                            }


                        }
                        else if ( ((LA16_0 >= '\u0000' && LA16_0 <= '!')||(LA16_0 >= '#' && LA16_0 <= '\uFFFF')) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:500:44: ~ ( '\"' )
                    	    {
                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
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
                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:500:53: '\"' '\"'
                    	    {
                    	    match('\"'); 

                    	    match('\"'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);


                    match('\"'); 

                    }
                    break;

            }


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:500:68: ( Lb )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0=='\n'||LA18_0=='\r') ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:500:68: Lb
                    {
                    mLb(); 


                    }
                    break;

            }


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
    // $ANTLR end "BeanShell"

    // $ANTLR start "SpecialAttribute"
    public final void mSpecialAttribute() throws RecognitionException {
        try {
            int _type = SpecialAttribute;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:503:2: ( '@' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:503:3: '@' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:503:39: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0 >= '0' && LA19_0 <= '9')||(LA19_0 >= 'A' && LA19_0 <= 'Z')||LA19_0=='_'||(LA19_0 >= 'a' && LA19_0 <= 'z')) ) {
                    alt19=1;
                }


                switch (alt19) {
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
            	    break loop19;
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:506:2: ( '&' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:506:3: '&' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:506:39: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0 >= '0' && LA20_0 <= '9')||(LA20_0 >= 'A' && LA20_0 <= 'Z')||LA20_0=='_'||(LA20_0 >= 'a' && LA20_0 <= 'z')) ) {
                    alt20=1;
                }


                switch (alt20) {
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
            	    break loop20;
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:509:2: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:509:3: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:509:35: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0 >= '0' && LA21_0 <= '9')||(LA21_0 >= 'A' && LA21_0 <= 'Z')||LA21_0=='_'||(LA21_0 >= 'a' && LA21_0 <= 'z')) ) {
                    alt21=1;
                }


                switch (alt21) {
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
            	    break loop21;
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:512:2: ( ( ( 'a' .. 'z' )+ '.' )+ 'A' .. 'Z' ( 'A' .. 'Z' | 'a' .. 'z' )+ )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:512:3: ( ( 'a' .. 'z' )+ '.' )+ 'A' .. 'Z' ( 'A' .. 'Z' | 'a' .. 'z' )+
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:512:3: ( ( 'a' .. 'z' )+ '.' )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0 >= 'a' && LA23_0 <= 'z')) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:512:4: ( 'a' .. 'z' )+ '.'
            	    {
            	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:512:4: ( 'a' .. 'z' )+
            	    int cnt22=0;
            	    loop22:
            	    do {
            	        int alt22=2;
            	        int LA22_0 = input.LA(1);

            	        if ( ((LA22_0 >= 'a' && LA22_0 <= 'z')) ) {
            	            alt22=1;
            	        }


            	        switch (alt22) {
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
            	    	    if ( cnt22 >= 1 ) break loop22;
            	                EarlyExitException eee =
            	                    new EarlyExitException(22, input);
            	                throw eee;
            	        }
            	        cnt22++;
            	    } while (true);


            	    match('.'); 

            	    }
            	    break;

            	default :
            	    if ( cnt23 >= 1 ) break loop23;
                        EarlyExitException eee =
                            new EarlyExitException(23, input);
                        throw eee;
                }
                cnt23++;
            } while (true);


            matchRange('A','Z'); 

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:512:35: ( 'A' .. 'Z' | 'a' .. 'z' )+
            int cnt24=0;
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0 >= 'A' && LA24_0 <= 'Z')||(LA24_0 >= 'a' && LA24_0 <= 'z')) ) {
                    alt24=1;
                }


                switch (alt24) {
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
            	    if ( cnt24 >= 1 ) break loop24;
                        EarlyExitException eee =
                            new EarlyExitException(24, input);
                        throw eee;
                }
                cnt24++;
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:516:2: ( '#' (~ ( '\\r' | '\\n' ) )* ( Lb )? )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:516:3: '#' (~ ( '\\r' | '\\n' ) )* ( Lb )?
            {
            match('#'); 

            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:516:7: (~ ( '\\r' | '\\n' ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0 >= '\u0000' && LA25_0 <= '\t')||(LA25_0 >= '\u000B' && LA25_0 <= '\f')||(LA25_0 >= '\u000E' && LA25_0 <= '\uFFFF')) ) {
                    alt25=1;
                }


                switch (alt25) {
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
            	    break loop25;
                }
            } while (true);


            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:516:23: ( Lb )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0=='\n'||LA26_0=='\r') ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:516:23: Lb
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:529:2: ({...}? => ';' ( Ws )* '\"' (~ '\"' | '\"' '\"' )* '\"' |)
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==';') && ((isHeader() == false))) {
                alt29=1;
            }
            else {
                alt29=2;
            }
            switch (alt29) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:529:3: {...}? => ';' ( Ws )* '\"' (~ '\"' | '\"' '\"' )* '\"'
                    {
                    if ( !((isHeader() == false)) ) {
                        throw new FailedPredicateException(input, "QuotedField", "isHeader() == false");
                    }

                    match(';'); 

                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:529:32: ( Ws )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0=='\t'||LA27_0==' ') ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:529:32: Ws
                    	    {
                    	    mWs(); 


                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);


                    match('\"'); 

                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:529:40: (~ '\"' | '\"' '\"' )*
                    loop28:
                    do {
                        int alt28=3;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0=='\"') ) {
                            int LA28_1 = input.LA(2);

                            if ( (LA28_1=='\"') ) {
                                alt28=2;
                            }


                        }
                        else if ( ((LA28_0 >= '\u0000' && LA28_0 <= '!')||(LA28_0 >= '#' && LA28_0 <= '\uFFFF')) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:529:41: ~ '\"'
                    	    {
                    	    if ( (input.LA(1) >= '\u0000' && input.LA(1) <= '!')||(input.LA(1) >= '#' && input.LA(1) <= '\uFFFF') ) {
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
                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:529:48: '\"' '\"'
                    	    {
                    	    match('\"'); 

                    	    match('\"'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);


                    match('\"'); 

                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:529:64: 
                    {
                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
             
            		String text = removeLineBreaks(getText());
            		text = text.substring(1, text.length()).trim();  //remove leading semicolon and trim to remove any spaces
            		text = text.substring(1, text.length() - 1).trim();      // remove surrounding doublequotes and again trim to remove any spaces
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:536:2: ({...}? => ( ';' ( Char | Separator )* ) |)
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==';') && ((isHeader() == false))) {
                alt31=1;
            }
            else {
                alt31=2;
            }
            switch (alt31) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:536:3: {...}? => ( ';' ( Char | Separator )* )
                    {
                    if ( !((isHeader() == false)) ) {
                        throw new FailedPredicateException(input, "Field", "isHeader() == false");
                    }

                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:536:28: ( ';' ( Char | Separator )* )
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:536:29: ';' ( Char | Separator )*
                    {
                    match(';'); 

                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:536:33: ( Char | Separator )*
                    loop30:
                    do {
                        int alt30=3;
                        alt30 = dfa30.predict(input);
                        switch (alt30) {
                    	case 1 :
                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:536:34: Char
                    	    {
                    	    mChar(); 


                    	    }
                    	    break;
                    	case 2 :
                    	    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:536:40: Separator
                    	    {
                    	    mSeparator(); 


                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:536:54: 
                    {
                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;

            	    String text = removeSeparators(getText()); 
            	    setText(text.substring(1, text.length()).trim()); //remove leading semicolon and trim to remove any spaces
            	
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:552:4: ( ( ' ' | '\\t' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:552:5: ( ' ' | '\\t' )
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:553:4: ( ( ( '\\r' )? '\\n' | '\\r' ) )
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:553:5: ( ( '\\r' )? '\\n' | '\\r' )
            {
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:553:5: ( ( '\\r' )? '\\n' | '\\r' )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0=='\r') ) {
                int LA33_1 = input.LA(2);

                if ( (LA33_1=='\n') ) {
                    alt33=1;
                }
                else {
                    alt33=2;
                }
            }
            else if ( (LA33_0=='\n') ) {
                alt33=1;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;

            }
            switch (alt33) {
                case 1 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:553:6: ( '\\r' )? '\\n'
                    {
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:553:6: ( '\\r' )?
                    int alt32=2;
                    int LA32_0 = input.LA(1);

                    if ( (LA32_0=='\r') ) {
                        alt32=1;
                    }
                    switch (alt32) {
                        case 1 :
                            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:553:6: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    }
                    break;
                case 2 :
                    // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:553:19: '\\r'
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
            // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:554:6: (~ ( '\\r' | '\\n' | '\"' | ';' ) )
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
        // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:8: ( Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual | Comma | Dot | DoubleQuote | Semicolon | RBracket | LBracket | LParenthesis | RParenthesis | Equals | Or | Bool | Macrodef | ValueAssignment | NextRow | UserRights | BeanShell | SpecialAttribute | DocumentID | Identifier | Classname | Comment | QuotedField | Field | Ws | Lb | Char )
        int alt34=52;
        alt34 = dfa34.predict(input);
        switch (alt34) {
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
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:381: ValueAssignment
                {
                mValueAssignment(); 


                }
                break;
            case 40 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:397: NextRow
                {
                mNextRow(); 


                }
                break;
            case 41 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:405: UserRights
                {
                mUserRights(); 


                }
                break;
            case 42 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:416: BeanShell
                {
                mBeanShell(); 


                }
                break;
            case 43 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:426: SpecialAttribute
                {
                mSpecialAttribute(); 


                }
                break;
            case 44 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:443: DocumentID
                {
                mDocumentID(); 


                }
                break;
            case 45 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:454: Identifier
                {
                mIdentifier(); 


                }
                break;
            case 46 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:465: Classname
                {
                mClassname(); 


                }
                break;
            case 47 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:475: Comment
                {
                mComment(); 


                }
                break;
            case 48 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:483: QuotedField
                {
                mQuotedField(); 


                }
                break;
            case 49 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:495: Field
                {
                mField(); 


                }
                break;
            case 50 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:501: Ws
                {
                mWs(); 


                }
                break;
            case 51 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:504: Lb
                {
                mLb(); 


                }
                break;
            case 52 :
                // /work/projects/yeclipse/ImpexAST/src/main/java/Impex.g:1:507: Char
                {
                mChar(); 


                }
                break;

        }

    }


    protected DFA7 dfa7 = new DFA7(this);
    protected DFA11 dfa11 = new DFA11(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA34 dfa34 = new DFA34(this);
    static final String DFA7_eotS =
        "\1\1\1\uffff\1\3\1\uffff\1\3\1\uffff";
    static final String DFA7_eofS =
        "\6\uffff";
    static final String DFA7_minS =
        "\1\0\1\uffff\1\11\1\uffff\1\11\1\uffff";
    static final String DFA7_maxS =
        "\1\uffff\1\uffff\1\40\1\uffff\1\40\1\uffff";
    static final String DFA7_acceptS =
        "\1\uffff\1\3\1\uffff\1\1\1\uffff\1\2";
    static final String DFA7_specialS =
        "\1\0\5\uffff}>";
    static final String[] DFA7_transitionS = {
            "\12\3\1\uffff\2\3\1\uffff\116\3\1\2\uffa3\3",
            "",
            "\1\4\1\5\2\uffff\1\5\22\uffff\1\4",
            "",
            "\1\4\1\5\2\uffff\1\5\22\uffff\1\4",
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
            return "()* loopback of 420:34: (~ ( '\\r' | '\\n' ) | Separator )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA7_0 = input.LA(1);

                        s = -1;
                        if ( (LA7_0=='\\') ) {s = 2;}

                        else if ( ((LA7_0 >= '\u0000' && LA7_0 <= '\t')||(LA7_0 >= '\u000B' && LA7_0 <= '\f')||(LA7_0 >= '\u000E' && LA7_0 <= '[')||(LA7_0 >= ']' && LA7_0 <= '\uFFFF')) ) {s = 3;}

                        else s = 1;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 7, _s, input);
            error(nvae);
            throw nvae;
        }

    }
    static final String DFA11_eotS =
        "\2\3\2\uffff";
    static final String DFA11_eofS =
        "\4\uffff";
    static final String DFA11_minS =
        "\2\11\2\uffff";
    static final String DFA11_maxS =
        "\2\42\2\uffff";
    static final String DFA11_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA11_specialS =
        "\4\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\1\26\uffff\1\1\1\uffff\1\2",
            "\1\1\26\uffff\1\1\1\uffff\1\2",
            "",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "421:44: ( ( ' ' | '\\t' )* '\"' (~ ( '\\r' | '\\n' | '\"' ) | '\"' '\"' )* '\"' | (~ ( '\\r' | '\\n' | ';' | '\"' | '[' | ']' | ',' ) )* )";
        }
    }
    static final String DFA30_eotS =
        "\1\1\1\uffff\1\3\1\uffff\1\3\1\uffff";
    static final String DFA30_eofS =
        "\6\uffff";
    static final String DFA30_minS =
        "\1\0\1\uffff\1\11\1\uffff\1\11\1\uffff";
    static final String DFA30_maxS =
        "\1\uffff\1\uffff\1\40\1\uffff\1\40\1\uffff";
    static final String DFA30_acceptS =
        "\1\uffff\1\3\1\uffff\1\1\1\uffff\1\2";
    static final String DFA30_specialS =
        "\1\0\5\uffff}>";
    static final String[] DFA30_transitionS = {
            "\12\3\1\uffff\2\3\1\uffff\24\3\1\uffff\30\3\1\uffff\40\3\1\2"+
            "\uffa3\3",
            "",
            "\1\4\1\5\2\uffff\1\5\22\uffff\1\4",
            "",
            "\1\4\1\5\2\uffff\1\5\22\uffff\1\4",
            ""
    };

    static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
    static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
    static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
    static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
    static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
    static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
    static final short[][] DFA30_transition;

    static {
        int numStates = DFA30_transitionS.length;
        DFA30_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = DFA30_eot;
            this.eof = DFA30_eof;
            this.min = DFA30_min;
            this.max = DFA30_max;
            this.accept = DFA30_accept;
            this.special = DFA30_special;
            this.transition = DFA30_transition;
        }
        public String getDescription() {
            return "()* loopback of 536:33: ( Char | Separator )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA30_0 = input.LA(1);

                        s = -1;
                        if ( (LA30_0=='\\') ) {s = 2;}

                        else if ( ((LA30_0 >= '\u0000' && LA30_0 <= '\t')||(LA30_0 >= '\u000B' && LA30_0 <= '\f')||(LA30_0 >= '\u000E' && LA30_0 <= '!')||(LA30_0 >= '#' && LA30_0 <= ':')||(LA30_0 >= '<' && LA30_0 <= '[')||(LA30_0 >= ']' && LA30_0 <= '\uFFFF')) ) {s = 3;}

                        else s = 1;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 30, _s, input);
            error(nvae);
            throw nvae;
        }

    }
    static final String DFA34_eotS =
        "\1\35\17\67\2\uffff\1\151\1\152\4\uffff\1\162\1\uffff\2\67\1\63"+
        "\1\uffff\1\63\1\172\2\63\16\67\4\uffff\3\67\2\uffff\55\67\5\uffff"+
        "\1\155\12\uffff\1\167\2\uffff\1\150\4\uffff\26\67\2\u00cb\32\67"+
        "\1\uffff\1\167\2\150\1\uffff\26\67\1\uffff\14\67\2\u0106\1\uffff"+
        "\2\u0107\4\67\1\u010c\2\67\1\167\24\67\1\uffff\2\u0124\10\67\1\u010c"+
        "\1\67\2\uffff\4\67\1\uffff\2\67\1\167\2\u0136\2\67\2\u013b\2\u013c"+
        "\2\u013d\12\67\1\uffff\17\67\1\167\1\67\1\uffff\4\67\3\uffff\16"+
        "\67\2\u016b\7\67\2\u0173\1\167\23\67\1\uffff\7\67\1\uffff\1\167"+
        "\5\67\2\u0195\6\67\2\u019c\2\u019d\11\67\1\167\3\67\2\u01ab\1\uffff"+
        "\6\67\2\uffff\2\u01b1\2\u01b2\1\uffff\2\67\2\u01b5\1\167\3\67\1"+
        "\uffff\2\u01ba\2\67\3\uffff\2\67\1\uffff\1\167\3\67\1\uffff\2\67"+
        "\2\u01c5\1\167\1\u01c7\2\u01c8\2\u01c9\1\uffff\1\167\3\uffff\4\167"+
        "\1\uffff\1\167";
    static final String DFA34_eofS =
        "\u01d0\uffff";
    static final String DFA34_minS =
        "\1\0\17\56\2\uffff\1\43\1\0\4\uffff\1\0\1\uffff\1\122\1\117\1\101"+
        "\1\uffff\1\134\1\45\2\101\1\56\1\107\1\116\1\105\3\101\1\114\1\101"+
        "\1\105\2\101\1\125\1\111\4\uffff\3\56\2\uffff\1\123\1\116\2\56\1"+
        "\104\1\111\1\56\1\115\1\56\1\124\3\56\1\103\2\114\3\56\1\117\1\124"+
        "\1\123\1\56\1\111\2\56\1\124\1\106\2\56\1\122\1\56\1\131\1\56\1"+
        "\116\2\56\1\120\1\104\1\56\1\115\1\56\1\101\1\56\1\122\4\uffff\1"+
        "\0\1\11\12\uffff\1\124\2\uffff\1\0\4\uffff\1\56\1\105\1\56\1\117"+
        "\1\56\1\101\1\56\1\121\1\56\1\117\1\56\1\103\1\56\1\110\1\56\1\114"+
        "\1\56\1\114\1\56\1\103\1\56\1\110\1\56\1\60\2\56\1\101\1\117\1\56"+
        "\1\105\1\56\1\101\1\56\1\103\2\56\1\62\1\56\1\107\2\55\1\56\1\105"+
        "\1\56\1\102\2\56\1\116\1\56\1\124\1\uffff\1\101\1\0\1\12\1\uffff"+
        "\1\56\1\122\1\56\1\122\1\56\1\124\1\56\1\125\1\56\1\126\1\56\1\110"+
        "\1\56\1\105\1\56\1\104\1\56\1\105\1\56\1\105\2\55\1\uffff\1\56\1"+
        "\123\1\56\1\127\1\56\1\106\1\56\1\125\1\56\1\105\1\56\1\126\1\56"+
        "\1\60\1\uffff\1\56\1\60\1\56\1\105\1\56\1\123\2\56\1\125\1\122\1"+
        "\56\1\124\1\56\1\105\1\56\1\105\1\56\1\105\1\56\1\105\1\56\1\115"+
        "\1\56\1\125\1\56\1\105\1\56\1\103\1\56\1\123\1\uffff\1\56\1\60\1"+
        "\56\1\116\1\56\1\117\1\56\1\114\1\56\1\127\1\56\1\101\2\uffff\1"+
        "\56\1\122\1\56\1\114\1\uffff\1\56\1\101\1\124\1\56\1\60\1\56\1\113"+
        "\1\56\1\60\1\56\1\60\1\56\1\60\1\56\1\117\1\56\1\116\1\56\1\103"+
        "\1\56\1\124\1\56\1\123\1\uffff\1\56\1\125\1\56\1\122\1\56\1\124"+
        "\1\56\1\122\1\114\1\56\1\106\1\56\1\101\1\56\1\114\1\137\1\125\1"+
        "\uffff\2\56\1\105\1\125\3\uffff\1\56\1\104\1\56\1\111\1\56\1\117"+
        "\1\56\1\111\1\56\1\117\1\56\1\114\1\56\1\115\1\56\1\60\1\56\1\111"+
        "\1\125\1\56\1\117\1\56\1\124\1\56\1\60\1\125\1\120\1\56\1\131\1"+
        "\56\1\114\1\56\1\105\1\56\1\121\1\56\1\122\1\56\1\117\1\56\1\122"+
        "\1\56\1\114\1\56\1\101\1\uffff\1\56\1\124\1\105\1\56\1\122\1\56"+
        "\1\117\1\uffff\1\123\1\104\1\56\1\103\1\56\1\114\1\56\1\60\1\56"+
        "\1\125\1\56\1\101\1\56\1\116\1\56\1\60\1\56\1\60\1\56\1\124\1\56"+
        "\1\105\1\55\1\56\1\115\1\56\1\122\1\105\1\101\1\56\1\101\1\56\1"+
        "\60\1\uffff\1\56\1\105\1\56\1\124\2\55\2\uffff\1\56\1\60\1\56\1"+
        "\60\1\uffff\1\56\1\101\1\56\1\60\1\122\1\124\1\56\1\123\1\uffff"+
        "\1\56\1\60\1\56\1\117\3\uffff\1\56\1\124\1\uffff\1\122\1\105\1\56"+
        "\1\105\1\uffff\1\56\1\122\1\56\1\60\1\111\1\60\1\56\1\60\1\56\1"+
        "\60\1\uffff\1\107\3\uffff\1\110\1\124\1\123\1\0\1\uffff\1\0";
    static final String DFA34_maxS =
        "\1\uffff\17\172\2\uffff\1\43\1\uffff\4\uffff\1\uffff\1\uffff\1\162"+
        "\1\157\1\172\1\uffff\1\134\1\45\3\172\1\156\1\160\1\145\1\141\1"+
        "\157\1\162\1\154\2\145\1\141\1\157\1\165\1\151\4\uffff\3\172\2\uffff"+
        "\1\163\1\156\2\172\1\144\1\151\1\172\1\155\1\172\1\164\3\172\1\143"+
        "\2\154\3\172\1\157\1\164\1\163\1\172\1\154\2\172\1\164\1\146\2\172"+
        "\1\162\1\172\1\171\1\172\1\156\2\172\1\160\1\144\1\172\1\155\1\172"+
        "\1\141\1\172\1\162\4\uffff\1\0\1\42\12\uffff\1\124\2\uffff\1\uffff"+
        "\4\uffff\1\172\1\145\1\172\1\157\1\172\1\141\1\172\1\161\1\172\1"+
        "\157\1\172\1\143\1\172\1\150\1\172\1\154\1\172\1\154\1\172\1\143"+
        "\1\172\1\150\4\172\1\141\1\157\1\172\1\145\1\172\1\141\1\172\1\143"+
        "\2\172\1\62\1\172\1\147\1\172\1\55\1\172\1\145\1\172\1\142\2\172"+
        "\1\156\1\172\1\164\1\uffff\1\101\1\uffff\1\12\1\uffff\1\172\1\162"+
        "\1\172\1\162\1\172\1\164\1\172\1\165\1\172\1\166\1\172\1\150\1\172"+
        "\1\145\1\172\1\144\1\172\1\145\1\172\1\145\1\172\1\55\1\uffff\1"+
        "\172\1\163\1\172\1\167\1\172\1\146\1\172\1\165\1\172\1\145\1\172"+
        "\1\166\2\172\1\uffff\3\172\1\145\1\172\1\163\2\172\1\165\1\122\1"+
        "\172\1\164\1\172\1\145\1\172\1\145\1\172\1\145\1\172\1\145\1\172"+
        "\1\155\1\172\1\165\1\172\1\145\1\172\1\143\1\172\1\163\1\uffff\3"+
        "\172\1\156\1\172\1\157\1\172\1\154\1\172\1\167\1\172\1\141\2\uffff"+
        "\1\172\1\162\1\172\1\154\1\uffff\1\172\1\141\1\124\3\172\1\156\7"+
        "\172\1\157\1\172\1\156\1\172\1\143\1\172\1\164\1\172\1\163\1\uffff"+
        "\1\172\1\165\1\172\1\162\1\172\1\164\1\172\1\162\1\154\1\172\1\146"+
        "\1\172\1\141\1\172\1\154\1\137\1\165\1\uffff\2\172\1\145\1\165\3"+
        "\uffff\1\172\1\144\1\172\1\151\1\172\1\157\1\172\1\151\1\172\1\157"+
        "\1\172\1\154\1\172\1\155\3\172\1\151\1\165\1\172\1\157\1\172\1\164"+
        "\2\172\1\125\1\160\1\172\1\171\1\172\1\154\1\172\1\145\1\172\1\161"+
        "\1\172\1\162\1\172\1\157\1\172\1\162\1\172\1\154\1\172\1\141\1\uffff"+
        "\1\172\1\164\1\145\1\172\1\162\1\172\1\157\1\uffff\1\123\1\144\1"+
        "\172\1\143\1\172\1\154\3\172\1\165\1\172\1\141\1\172\1\156\5\172"+
        "\1\164\1\172\1\145\1\55\1\172\1\155\1\172\1\162\1\105\1\141\1\172"+
        "\1\141\2\172\1\uffff\1\172\1\145\1\172\1\164\1\172\1\55\2\uffff"+
        "\4\172\1\uffff\1\172\1\141\2\172\1\122\1\164\1\172\1\163\1\uffff"+
        "\3\172\1\157\3\uffff\1\172\1\164\1\uffff\1\122\1\145\1\172\1\145"+
        "\1\uffff\1\172\1\162\2\172\1\111\5\172\1\uffff\1\107\3\uffff\1\110"+
        "\1\124\1\123\1\uffff\1\uffff\1\uffff";
    static final String DFA34_acceptS =
        "\20\uffff\1\33\1\34\2\uffff\1\37\1\40\1\41\1\42\1\uffff\1\44\3\uffff"+
        "\1\47\22\uffff\1\55\1\62\1\63\1\64\3\uffff\1\55\1\56\55\uffff\1"+
        "\33\1\34\1\52\1\35\2\uffff\1\60\1\61\1\37\1\40\1\41\1\42\1\43\2"+
        "\47\1\44\1\uffff\1\46\1\50\1\uffff\1\57\1\53\1\54\1\62\62\uffff"+
        "\1\36\3\uffff\1\52\26\uffff\1\27\16\uffff\1\23\36\uffff\1\26\14"+
        "\uffff\1\22\1\24\4\uffff\1\45\27\uffff\1\10\21\uffff\1\1\4\uffff"+
        "\1\3\1\31\1\4\55\uffff\1\15\7\uffff\1\32\41\uffff\1\5\6\uffff\1"+
        "\7\1\11\4\uffff\1\21\10\uffff\1\20\4\uffff\1\13\1\14\1\16\2\uffff"+
        "\1\30\4\uffff\1\6\12\uffff\1\25\1\uffff\1\2\1\17\1\12\4\uffff\1"+
        "\51\1\uffff";
    static final String DFA34_specialS =
        "\1\1\22\uffff\1\2\4\uffff\1\3\121\uffff\1\4\1\0\15\uffff\1\5\70"+
        "\uffff\1\6\u011a\uffff\1\7\1\uffff\1\10}>";
    static final String[] DFA34_transitionS = {
            "\11\63\1\61\1\62\2\63\1\62\22\63\1\61\1\63\1\22\1\37\1\34\1"+
            "\63\1\41\1\63\1\26\1\27\2\63\1\20\1\63\1\21\14\63\1\23\1\63"+
            "\1\30\2\63\1\40\1\51\1\46\1\47\1\52\1\60\1\33\2\60\1\43\1\60"+
            "\1\53\1\54\1\55\1\56\1\60\1\50\1\60\1\45\1\60\1\32\1\44\1\57"+
            "\4\60\1\25\1\36\1\24\1\63\1\60\1\63\1\7\1\4\1\5\1\10\1\42\1"+
            "\11\2\42\1\1\1\42\1\12\1\13\1\14\1\15\1\42\1\6\1\42\1\3\1\42"+
            "\1\16\1\2\1\17\4\42\1\63\1\31\uff83\63",
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
            "\1\150",
            "\11\155\1\153\1\uffff\2\155\1\uffff\22\155\1\153\1\155\1\154"+
            "\30\155\1\uffff\uffc4\155",
            "",
            "",
            "",
            "",
            "\12\163\1\uffff\2\163\1\uffff\36\163\1\164\16\163\1\164\37"+
            "\163\1\164\1\163\1\164\uffa2\163",
            "",
            "\1\143\37\uffff\1\143",
            "\1\127\37\uffff\1\127",
            "\22\167\1\166\7\167\4\uffff\1\167\1\uffff\32\167",
            "",
            "\1\170",
            "\1\171",
            "\32\173\4\uffff\1\173\1\uffff\32\173",
            "\32\174\4\uffff\1\174\1\uffff\32\174",
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
            "\1\70\44\uffff\1\177\15\uffff\22\66\1\176\7\66",
            "\1\70\37\uffff\1\u0081\22\uffff\15\66\1\u0080\14\66",
            "\1\70\62\uffff\32\66",
            "",
            "",
            "\1\177\37\uffff\1\177",
            "\1\u0081\37\uffff\1\u0081",
            "\1\70\25\uffff\1\u0083\34\uffff\3\66\1\u0082\26\66",
            "\1\70\32\uffff\1\u0085\27\uffff\10\66\1\u0084\21\66",
            "\1\u0083\37\uffff\1\u0083",
            "\1\u0085\37\uffff\1\u0085",
            "\1\70\36\uffff\1\u0087\23\uffff\14\66\1\u0086\15\66",
            "\1\u0087\37\uffff\1\u0087",
            "\1\70\45\uffff\1\u0089\14\uffff\23\66\1\u0088\6\66",
            "\1\u0089\37\uffff\1\u0089",
            "\1\70\24\uffff\1\u008b\35\uffff\2\66\1\u008a\27\66",
            "\1\70\35\uffff\1\u008d\24\uffff\13\66\1\u008c\16\66",
            "\1\70\35\uffff\1\u008f\24\uffff\13\66\1\u008e\16\66",
            "\1\u008b\37\uffff\1\u008b",
            "\1\u008d\37\uffff\1\u008d",
            "\1\u008f\37\uffff\1\u008f",
            "\1\70\40\uffff\1\u0091\21\uffff\16\66\1\u0090\13\66",
            "\1\70\45\uffff\1\u0093\14\uffff\23\66\1\u0092\6\66",
            "\1\70\44\uffff\1\u0095\15\uffff\22\66\1\u0094\7\66",
            "\1\u0091\37\uffff\1\u0091",
            "\1\u0093\37\uffff\1\u0093",
            "\1\u0095\37\uffff\1\u0095",
            "\1\70\32\uffff\1\u0098\2\uffff\1\u0099\24\uffff\10\66\1\u0096"+
            "\2\66\1\u0097\16\66",
            "\1\u0098\2\uffff\1\u0099\34\uffff\1\u0098\2\uffff\1\u0099",
            "\1\70\45\uffff\1\u009b\14\uffff\23\66\1\u009a\6\66",
            "\1\70\27\uffff\1\u009d\32\uffff\5\66\1\u009c\24\66",
            "\1\u009b\37\uffff\1\u009b",
            "\1\u009d\37\uffff\1\u009d",
            "\1\70\43\uffff\1\u009f\16\uffff\21\66\1\u009e\10\66",
            "\1\70\62\uffff\13\66\1\u00a0\16\66",
            "\1\u009f\37\uffff\1\u009f",
            "\1\70\52\uffff\1\u00a2\7\uffff\30\66\1\u00a1\1\66",
            "\1\u00a2\37\uffff\1\u00a2",
            "\1\70\37\uffff\1\u00a4\22\uffff\15\66\1\u00a3\14\66",
            "\1\u00a4\37\uffff\1\u00a4",
            "\1\70\41\uffff\1\u00a6\20\uffff\17\66\1\u00a5\12\66",
            "\1\70\25\uffff\1\u00a8\34\uffff\3\66\1\u00a7\26\66",
            "\1\u00a6\37\uffff\1\u00a6",
            "\1\u00a8\37\uffff\1\u00a8",
            "\1\70\36\uffff\1\u00aa\23\uffff\14\66\1\u00a9\15\66",
            "\1\u00aa\37\uffff\1\u00aa",
            "\1\70\22\uffff\1\u00ad\37\uffff\1\u00ab\23\66\1\u00ac\5\66",
            "\1\u00ad\37\uffff\1\u00ad",
            "\1\70\43\uffff\1\u00af\16\uffff\21\66\1\u00ae\10\66",
            "\1\u00af\37\uffff\1\u00af",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\153\26\uffff\1\153\1\uffff\1\154",
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
            "\1\u00b1",
            "",
            "",
            "\12\u00b2\1\u00b4\2\u00b2\1\u00b3\ufff2\u00b2",
            "",
            "",
            "",
            "",
            "\1\70\26\uffff\1\u00b6\33\uffff\4\66\1\u00b5\25\66",
            "\1\u00b6\37\uffff\1\u00b6",
            "\1\70\40\uffff\1\u00b8\21\uffff\16\66\1\u00b7\13\66",
            "\1\u00b8\37\uffff\1\u00b8",
            "\1\70\22\uffff\1\u00ba\37\uffff\1\u00b9\31\66",
            "\1\u00ba\37\uffff\1\u00ba",
            "\1\70\42\uffff\1\u00bc\17\uffff\20\66\1\u00bb\11\66",
            "\1\u00bc\37\uffff\1\u00bc",
            "\1\70\40\uffff\1\u00be\21\uffff\16\66\1\u00bd\13\66",
            "\1\u00be\37\uffff\1\u00be",
            "\1\70\24\uffff\1\u00c0\35\uffff\2\66\1\u00bf\27\66",
            "\1\u00c0\37\uffff\1\u00c0",
            "\1\70\31\uffff\1\u00c2\30\uffff\7\66\1\u00c1\22\66",
            "\1\u00c2\37\uffff\1\u00c2",
            "\1\70\35\uffff\1\u00c4\24\uffff\13\66\1\u00c3\16\66",
            "\1\u00c4\37\uffff\1\u00c4",
            "\1\70\35\uffff\1\u00c6\24\uffff\13\66\1\u00c5\16\66",
            "\1\u00c6\37\uffff\1\u00c6",
            "\1\70\24\uffff\1\u00c8\35\uffff\2\66\1\u00c7\27\66",
            "\1\u00c8\37\uffff\1\u00c8",
            "\1\70\31\uffff\1\u00ca\30\uffff\7\66\1\u00c9\22\66",
            "\1\u00ca\37\uffff\1\u00ca",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\70\22\uffff\1\u00cd\37\uffff\1\u00cc\31\66",
            "\1\70\40\uffff\1\u00cf\21\uffff\16\66\1\u00ce\13\66",
            "\1\u00cd\37\uffff\1\u00cd",
            "\1\u00cf\37\uffff\1\u00cf",
            "\1\70\26\uffff\1\u00d1\33\uffff\4\66\1\u00d0\25\66",
            "\1\u00d1\37\uffff\1\u00d1",
            "\1\70\22\uffff\1\u00d3\37\uffff\1\u00d2\31\66",
            "\1\u00d3\37\uffff\1\u00d3",
            "\1\70\24\uffff\1\u00d5\35\uffff\2\66\1\u00d4\27\66",
            "\1\u00d5\37\uffff\1\u00d5",
            "\1\70\62\uffff\22\66\1\u00d6\7\66",
            "\1\70\3\uffff\1\u00d7\56\uffff\32\66",
            "\1\u00d7",
            "\1\70\30\uffff\1\u00d9\31\uffff\6\66\1\u00d8\23\66",
            "\1\u00d9\37\uffff\1\u00d9",
            "\1\u00da\1\70\62\uffff\32\66",
            "\1\u00da",
            "\1\70\26\uffff\1\u00dc\33\uffff\4\66\1\u00db\25\66",
            "\1\u00dc\37\uffff\1\u00dc",
            "\1\70\23\uffff\1\u00de\36\uffff\1\66\1\u00dd\30\66",
            "\1\u00de\37\uffff\1\u00de",
            "\1\70\37\uffff\1\u00e0\22\uffff\15\66\1\u00df\14\66",
            "\1\70\62\uffff\4\66\1\u00e1\25\66",
            "\1\u00e0\37\uffff\1\u00e0",
            "\1\70\45\uffff\1\u00e3\14\uffff\23\66\1\u00e2\6\66",
            "\1\u00e3\37\uffff\1\u00e3",
            "",
            "\1\u00e4",
            "\12\u00b2\1\u00b4\2\u00b2\1\u00b3\ufff2\u00b2",
            "\1\u00b4",
            "",
            "\1\70\43\uffff\1\u00e6\16\uffff\21\66\1\u00e5\10\66",
            "\1\u00e6\37\uffff\1\u00e6",
            "\1\70\43\uffff\1\u00e8\16\uffff\21\66\1\u00e7\10\66",
            "\1\u00e8\37\uffff\1\u00e8",
            "\1\70\45\uffff\1\u00ea\14\uffff\23\66\1\u00e9\6\66",
            "\1\u00ea\37\uffff\1\u00ea",
            "\1\70\46\uffff\1\u00ec\13\uffff\24\66\1\u00eb\5\66",
            "\1\u00ec\37\uffff\1\u00ec",
            "\1\70\47\uffff\1\u00ee\12\uffff\25\66\1\u00ed\4\66",
            "\1\u00ee\37\uffff\1\u00ee",
            "\1\70\31\uffff\1\u00f0\30\uffff\7\66\1\u00ef\22\66",
            "\1\u00f0\37\uffff\1\u00f0",
            "\1\70\26\uffff\1\u00f2\33\uffff\4\66\1\u00f1\25\66",
            "\1\u00f2\37\uffff\1\u00f2",
            "\1\70\25\uffff\1\u00f4\34\uffff\3\66\1\u00f3\26\66",
            "\1\u00f4\37\uffff\1\u00f4",
            "\1\70\26\uffff\1\u00f6\33\uffff\4\66\1\u00f5\25\66",
            "\1\u00f6\37\uffff\1\u00f6",
            "\1\70\26\uffff\1\u00f8\33\uffff\4\66\1\u00f7\25\66",
            "\1\u00f8\37\uffff\1\u00f8",
            "\1\u00f9\1\70\62\uffff\32\66",
            "\1\u00f9",
            "",
            "\1\70\44\uffff\1\u00fb\15\uffff\22\66\1\u00fa\7\66",
            "\1\u00fb\37\uffff\1\u00fb",
            "\1\70\50\uffff\1\u00fd\11\uffff\26\66\1\u00fc\3\66",
            "\1\u00fd\37\uffff\1\u00fd",
            "\1\70\27\uffff\1\u00ff\32\uffff\5\66\1\u00fe\24\66",
            "\1\u00ff\37\uffff\1\u00ff",
            "\1\70\46\uffff\1\u0101\13\uffff\24\66\1\u0100\5\66",
            "\1\u0101\37\uffff\1\u0101",
            "\1\70\26\uffff\1\u0103\33\uffff\4\66\1\u0102\25\66",
            "\1\u0103\37\uffff\1\u0103",
            "\1\70\62\uffff\4\66\1\u0104\25\66",
            "\1\u0105\37\uffff\1\u0105",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\70\26\uffff\1\u0109\33\uffff\4\66\1\u0108\25\66",
            "\1\u0109\37\uffff\1\u0109",
            "\1\70\44\uffff\1\u010b\15\uffff\22\66\1\u010a\7\66",
            "\1\u010b\37\uffff\1\u010b",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\1\70\46\uffff\1\u010e\13\uffff\24\66\1\u010d\5\66",
            "\1\u010e\37\uffff\1\u010e",
            "\1\u010f",
            "\1\70\45\uffff\1\u0111\14\uffff\23\66\1\u0110\6\66",
            "\1\u0111\37\uffff\1\u0111",
            "\1\70\26\uffff\1\u0113\33\uffff\4\66\1\u0112\25\66",
            "\1\u0113\37\uffff\1\u0113",
            "\1\70\26\uffff\1\u0115\33\uffff\4\66\1\u0114\25\66",
            "\1\u0115\37\uffff\1\u0115",
            "\1\70\26\uffff\1\u0117\33\uffff\4\66\1\u0116\25\66",
            "\1\u0117\37\uffff\1\u0117",
            "\1\70\26\uffff\1\u0119\33\uffff\4\66\1\u0118\25\66",
            "\1\u0119\37\uffff\1\u0119",
            "\1\70\36\uffff\1\u011b\23\uffff\14\66\1\u011a\15\66",
            "\1\u011b\37\uffff\1\u011b",
            "\1\70\46\uffff\1\u011d\13\uffff\24\66\1\u011c\5\66",
            "\1\u011d\37\uffff\1\u011d",
            "\1\70\26\uffff\1\u011f\33\uffff\4\66\1\u011e\25\66",
            "\1\u011f\37\uffff\1\u011f",
            "\1\70\24\uffff\1\u0121\35\uffff\2\66\1\u0120\27\66",
            "\1\u0121\37\uffff\1\u0121",
            "\1\70\44\uffff\1\u0123\15\uffff\22\66\1\u0122\7\66",
            "\1\u0123\37\uffff\1\u0123",
            "",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\70\37\uffff\1\u0126\22\uffff\15\66\1\u0125\14\66",
            "\1\u0126\37\uffff\1\u0126",
            "\1\70\40\uffff\1\u0128\21\uffff\16\66\1\u0127\13\66",
            "\1\u0128\37\uffff\1\u0128",
            "\1\70\35\uffff\1\u012a\24\uffff\13\66\1\u0129\16\66",
            "\1\u012a\37\uffff\1\u012a",
            "\1\70\50\uffff\1\u012c\11\uffff\26\66\1\u012b\3\66",
            "\1\u012c\37\uffff\1\u012c",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\1\u012d\37\uffff\1\u012d",
            "",
            "",
            "\1\70\43\uffff\1\u012f\16\uffff\21\66\1\u012e\10\66",
            "\1\u012f\37\uffff\1\u012f",
            "\1\70\35\uffff\1\u0131\24\uffff\13\66\1\u0130\16\66",
            "\1\u0131\37\uffff\1\u0131",
            "",
            "\1\70\22\uffff\1\u0133\37\uffff\1\u0132\31\66",
            "\1\u0133\37\uffff\1\u0133",
            "\1\u0134",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\u0135\1\uffff\32"+
            "\66",
            "\12\67\7\uffff\32\67\4\uffff\1\u0135\1\uffff\32\67",
            "\1\70\34\uffff\1\u0139\2\uffff\1\u013a\22\uffff\12\66\1\u0137"+
            "\2\66\1\u0138\14\66",
            "\1\u0139\2\uffff\1\u013a\34\uffff\1\u0139\2\uffff\1\u013a",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\70\40\uffff\1\u013f\21\uffff\16\66\1\u013e\13\66",
            "\1\u013f\37\uffff\1\u013f",
            "\1\70\37\uffff\1\u0141\22\uffff\15\66\1\u0140\14\66",
            "\1\u0141\37\uffff\1\u0141",
            "\1\70\24\uffff\1\u0143\35\uffff\2\66\1\u0142\27\66",
            "\1\u0143\37\uffff\1\u0143",
            "\1\70\45\uffff\1\u0145\14\uffff\23\66\1\u0144\6\66",
            "\1\u0145\37\uffff\1\u0145",
            "\1\70\44\uffff\1\u0147\15\uffff\22\66\1\u0146\7\66",
            "\1\u0147\37\uffff\1\u0147",
            "",
            "\1\70\46\uffff\1\u0149\13\uffff\24\66\1\u0148\5\66",
            "\1\u0149\37\uffff\1\u0149",
            "\1\70\43\uffff\1\u014b\16\uffff\21\66\1\u014a\10\66",
            "\1\u014b\37\uffff\1\u014b",
            "\1\70\45\uffff\1\u014d\14\uffff\23\66\1\u014c\6\66",
            "\1\u014d\37\uffff\1\u014d",
            "\1\70\43\uffff\1\u014f\16\uffff\21\66\1\u014e\10\66",
            "\1\u014f\37\uffff\1\u014f",
            "\1\u0150\37\uffff\1\u0150",
            "\1\70\27\uffff\1\u0152\32\uffff\5\66\1\u0151\24\66",
            "\1\u0152\37\uffff\1\u0152",
            "\1\70\22\uffff\1\u0154\37\uffff\1\u0153\31\66",
            "\1\u0154\37\uffff\1\u0154",
            "\1\70\35\uffff\1\u0156\24\uffff\13\66\1\u0155\16\66",
            "\1\u0156\37\uffff\1\u0156",
            "\1\u0157",
            "\1\u0158\37\uffff\1\u0158",
            "",
            "\1\70\26\uffff\1\u015a\33\uffff\4\66\1\u0159\25\66",
            "\1\70\46\uffff\1\u015c\13\uffff\24\66\1\u015b\5\66",
            "\1\u015a\37\uffff\1\u015a",
            "\1\u015c\37\uffff\1\u015c",
            "",
            "",
            "",
            "\1\70\25\uffff\1\u015e\34\uffff\3\66\1\u015d\26\66",
            "\1\u015e\37\uffff\1\u015e",
            "\1\70\32\uffff\1\u0160\27\uffff\10\66\1\u015f\21\66",
            "\1\u0160\37\uffff\1\u0160",
            "\1\70\40\uffff\1\u0162\21\uffff\16\66\1\u0161\13\66",
            "\1\u0162\37\uffff\1\u0162",
            "\1\70\32\uffff\1\u0164\27\uffff\10\66\1\u0163\21\66",
            "\1\u0164\37\uffff\1\u0164",
            "\1\70\40\uffff\1\u0166\21\uffff\16\66\1\u0165\13\66",
            "\1\u0166\37\uffff\1\u0166",
            "\1\70\35\uffff\1\u0168\24\uffff\13\66\1\u0167\16\66",
            "\1\u0168\37\uffff\1\u0168",
            "\1\70\36\uffff\1\u016a\23\uffff\14\66\1\u0169\15\66",
            "\1\u016a\37\uffff\1\u016a",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\70\32\uffff\1\u016d\27\uffff\10\66\1\u016c\21\66",
            "\1\u016d\37\uffff\1\u016d",
            "\1\u016e\37\uffff\1\u016e",
            "\1\70\40\uffff\1\u0170\21\uffff\16\66\1\u016f\13\66",
            "\1\u0170\37\uffff\1\u0170",
            "\1\70\45\uffff\1\u0172\14\uffff\23\66\1\u0171\6\66",
            "\1\u0172\37\uffff\1\u0172",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u0174",
            "\1\u0175\37\uffff\1\u0175",
            "\1\70\52\uffff\1\u0177\7\uffff\30\66\1\u0176\1\66",
            "\1\u0177\37\uffff\1\u0177",
            "\1\70\35\uffff\1\u0179\24\uffff\13\66\1\u0178\16\66",
            "\1\u0179\37\uffff\1\u0179",
            "\1\70\26\uffff\1\u017b\33\uffff\4\66\1\u017a\25\66",
            "\1\u017b\37\uffff\1\u017b",
            "\1\70\42\uffff\1\u017d\17\uffff\20\66\1\u017c\11\66",
            "\1\u017d\37\uffff\1\u017d",
            "\1\70\43\uffff\1\u017f\16\uffff\21\66\1\u017e\10\66",
            "\1\u017f\37\uffff\1\u017f",
            "\1\70\40\uffff\1\u0181\21\uffff\16\66\1\u0180\13\66",
            "\1\u0181\37\uffff\1\u0181",
            "\1\70\43\uffff\1\u0183\16\uffff\21\66\1\u0182\10\66",
            "\1\u0183\37\uffff\1\u0183",
            "\1\70\35\uffff\1\u0185\24\uffff\13\66\1\u0184\16\66",
            "\1\u0185\37\uffff\1\u0185",
            "\1\70\22\uffff\1\u0187\37\uffff\1\u0186\31\66",
            "\1\u0187\37\uffff\1\u0187",
            "",
            "\1\70\45\uffff\1\u0189\14\uffff\23\66\1\u0188\6\66",
            "\1\u0189\37\uffff\1\u0189",
            "\1\u018a\37\uffff\1\u018a",
            "\1\70\43\uffff\1\u018c\16\uffff\21\66\1\u018b\10\66",
            "\1\u018c\37\uffff\1\u018c",
            "\1\70\40\uffff\1\u018e\21\uffff\16\66\1\u018d\13\66",
            "\1\u018e\37\uffff\1\u018e",
            "",
            "\1\u018f",
            "\1\u0190\37\uffff\1\u0190",
            "\1\70\24\uffff\1\u0192\35\uffff\2\66\1\u0191\27\66",
            "\1\u0192\37\uffff\1\u0192",
            "\1\70\35\uffff\1\u0194\24\uffff\13\66\1\u0193\16\66",
            "\1\u0194\37\uffff\1\u0194",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\70\46\uffff\1\u0197\13\uffff\24\66\1\u0196\5\66",
            "\1\u0197\37\uffff\1\u0197",
            "\1\70\22\uffff\1\u0199\37\uffff\1\u0198\31\66",
            "\1\u0199\37\uffff\1\u0199",
            "\1\70\37\uffff\1\u019b\22\uffff\15\66\1\u019a\14\66",
            "\1\u019b\37\uffff\1\u019b",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\70\45\uffff\1\u019f\14\uffff\23\66\1\u019e\6\66",
            "\1\u019f\37\uffff\1\u019f",
            "\1\70\26\uffff\1\u01a1\33\uffff\4\66\1\u01a0\25\66",
            "\1\u01a1\37\uffff\1\u01a1",
            "\1\u01a2",
            "\1\70\36\uffff\1\u01a4\23\uffff\14\66\1\u01a3\15\66",
            "\1\u01a4\37\uffff\1\u01a4",
            "\1\70\43\uffff\1\u01a6\16\uffff\21\66\1\u01a5\10\66",
            "\1\u01a6\37\uffff\1\u01a6",
            "\1\u01a7",
            "\1\u01a8\37\uffff\1\u01a8",
            "\1\70\22\uffff\1\u01aa\37\uffff\1\u01a9\31\66",
            "\1\u01aa\37\uffff\1\u01aa",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\70\26\uffff\1\u01ad\33\uffff\4\66\1\u01ac\25\66",
            "\1\u01ad\37\uffff\1\u01ad",
            "\1\70\45\uffff\1\u01af\14\uffff\23\66\1\u01ae\6\66",
            "\1\u01af\37\uffff\1\u01af",
            "\1\u01b0\1\70\62\uffff\32\66",
            "\1\u01b0",
            "",
            "",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\70\22\uffff\1\u01b4\37\uffff\1\u01b3\31\66",
            "\1\u01b4\37\uffff\1\u01b4",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u01b6",
            "\1\u01b7\37\uffff\1\u01b7",
            "\1\70\44\uffff\1\u01b9\15\uffff\22\66\1\u01b8\7\66",
            "\1\u01b9\37\uffff\1\u01b9",
            "",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\70\40\uffff\1\u01bc\21\uffff\16\66\1\u01bb\13\66",
            "\1\u01bc\37\uffff\1\u01bc",
            "",
            "",
            "",
            "\1\70\45\uffff\1\u01be\14\uffff\23\66\1\u01bd\6\66",
            "\1\u01be\37\uffff\1\u01be",
            "",
            "\1\u01bf",
            "\1\u01c0\37\uffff\1\u01c0",
            "\1\70\26\uffff\1\u01c2\33\uffff\4\66\1\u01c1\25\66",
            "\1\u01c2\37\uffff\1\u01c2",
            "",
            "\1\70\43\uffff\1\u01c4\16\uffff\21\66\1\u01c3\10\66",
            "\1\u01c4\37\uffff\1\u01c4",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\u01c6",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "\1\70\1\uffff\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\66",
            "\12\67\7\uffff\32\67\4\uffff\1\67\1\uffff\32\67",
            "",
            "\1\u01ca",
            "",
            "",
            "",
            "\1\u01cb",
            "\1\u01cc",
            "\1\u01cd",
            "\60\u01ce\12\u01cf\7\u01ce\32\u01cf\4\u01ce\1\u01cf\1\u01ce"+
            "\32\u01cf\uff85\u01ce",
            "",
            "\60\u01ce\12\u01cf\7\u01ce\32\u01cf\4\u01ce\1\u01cf\1\u01ce"+
            "\32\u01cf\uff85\u01ce"
    };

    static final short[] DFA34_eot = DFA.unpackEncodedString(DFA34_eotS);
    static final short[] DFA34_eof = DFA.unpackEncodedString(DFA34_eofS);
    static final char[] DFA34_min = DFA.unpackEncodedStringToUnsignedChars(DFA34_minS);
    static final char[] DFA34_max = DFA.unpackEncodedStringToUnsignedChars(DFA34_maxS);
    static final short[] DFA34_accept = DFA.unpackEncodedString(DFA34_acceptS);
    static final short[] DFA34_special = DFA.unpackEncodedString(DFA34_specialS);
    static final short[][] DFA34_transition;

    static {
        int numStates = DFA34_transitionS.length;
        DFA34_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA34_transition[i] = DFA.unpackEncodedString(DFA34_transitionS[i]);
        }
    }

    class DFA34 extends DFA {

        public DFA34(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 34;
            this.eot = DFA34_eot;
            this.eof = DFA34_eof;
            this.min = DFA34_min;
            this.max = DFA34_max;
            this.accept = DFA34_accept;
            this.special = DFA34_special;
            this.transition = DFA34_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual | Comma | Dot | DoubleQuote | Semicolon | RBracket | LBracket | LParenthesis | RParenthesis | Equals | Or | Bool | Macrodef | ValueAssignment | NextRow | UserRights | BeanShell | SpecialAttribute | DocumentID | Identifier | Classname | Comment | QuotedField | Field | Ws | Lb | Char );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA34_107 = input.LA(1);

                         
                        int index34_107 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA34_107=='\"') && ((isHeader() == false))) {s = 108;}

                        else if ( (LA34_107=='\t'||LA34_107==' ') && ((isHeader() == false))) {s = 107;}

                        else s = 109;

                         
                        input.seek(index34_107);

                        if ( s>=0 ) return s;
                        break;

                    case 1 : 
                        int LA34_0 = input.LA(1);

                        s = -1;
                        if ( (LA34_0=='i') ) {s = 1;}

                        else if ( (LA34_0=='u') ) {s = 2;}

                        else if ( (LA34_0=='r') ) {s = 3;}

                        else if ( (LA34_0=='b') ) {s = 4;}

                        else if ( (LA34_0=='c') ) {s = 5;}

                        else if ( (LA34_0=='p') ) {s = 6;}

                        else if ( (LA34_0=='a') ) {s = 7;}

                        else if ( (LA34_0=='d') ) {s = 8;}

                        else if ( (LA34_0=='f') ) {s = 9;}

                        else if ( (LA34_0=='k') ) {s = 10;}

                        else if ( (LA34_0=='l') ) {s = 11;}

                        else if ( (LA34_0=='m') ) {s = 12;}

                        else if ( (LA34_0=='n') ) {s = 13;}

                        else if ( (LA34_0=='t') ) {s = 14;}

                        else if ( (LA34_0=='v') ) {s = 15;}

                        else if ( (LA34_0==',') ) {s = 16;}

                        else if ( (LA34_0=='.') ) {s = 17;}

                        else if ( (LA34_0=='\"') ) {s = 18;}

                        else if ( (LA34_0==';') ) {s = 19;}

                        else if ( (LA34_0==']') ) {s = 20;}

                        else if ( (LA34_0=='[') ) {s = 21;}

                        else if ( (LA34_0=='(') ) {s = 22;}

                        else if ( (LA34_0==')') ) {s = 23;}

                        else if ( (LA34_0=='=') ) {s = 24;}

                        else if ( (LA34_0=='|') ) {s = 25;}

                        else if ( (LA34_0=='T') ) {s = 26;}

                        else if ( (LA34_0=='F') ) {s = 27;}

                        else if ( (LA34_0=='$') ) {s = 28;}

                        else if ( (LA34_0=='\\') ) {s = 30;}

                        else if ( (LA34_0=='#') ) {s = 31;}

                        else if ( (LA34_0=='@') ) {s = 32;}

                        else if ( (LA34_0=='&') ) {s = 33;}

                        else if ( (LA34_0=='e'||(LA34_0 >= 'g' && LA34_0 <= 'h')||LA34_0=='j'||LA34_0=='o'||LA34_0=='q'||LA34_0=='s'||(LA34_0 >= 'w' && LA34_0 <= 'z')) ) {s = 34;}

                        else if ( (LA34_0=='I') ) {s = 35;}

                        else if ( (LA34_0=='U') ) {s = 36;}

                        else if ( (LA34_0=='R') ) {s = 37;}

                        else if ( (LA34_0=='B') ) {s = 38;}

                        else if ( (LA34_0=='C') ) {s = 39;}

                        else if ( (LA34_0=='P') ) {s = 40;}

                        else if ( (LA34_0=='A') ) {s = 41;}

                        else if ( (LA34_0=='D') ) {s = 42;}

                        else if ( (LA34_0=='K') ) {s = 43;}

                        else if ( (LA34_0=='L') ) {s = 44;}

                        else if ( (LA34_0=='M') ) {s = 45;}

                        else if ( (LA34_0=='N') ) {s = 46;}

                        else if ( (LA34_0=='V') ) {s = 47;}

                        else if ( (LA34_0=='E'||(LA34_0 >= 'G' && LA34_0 <= 'H')||LA34_0=='J'||LA34_0=='O'||LA34_0=='Q'||LA34_0=='S'||(LA34_0 >= 'W' && LA34_0 <= 'Z')||LA34_0=='_') ) {s = 48;}

                        else if ( (LA34_0=='\t'||LA34_0==' ') ) {s = 49;}

                        else if ( (LA34_0=='\n'||LA34_0=='\r') ) {s = 50;}

                        else if ( ((LA34_0 >= '\u0000' && LA34_0 <= '\b')||(LA34_0 >= '\u000B' && LA34_0 <= '\f')||(LA34_0 >= '\u000E' && LA34_0 <= '\u001F')||LA34_0=='!'||LA34_0=='%'||LA34_0=='\''||(LA34_0 >= '*' && LA34_0 <= '+')||LA34_0=='-'||(LA34_0 >= '/' && LA34_0 <= ':')||LA34_0=='<'||(LA34_0 >= '>' && LA34_0 <= '?')||LA34_0=='^'||LA34_0=='`'||LA34_0=='{'||(LA34_0 >= '}' && LA34_0 <= '\uFFFF')) ) {s = 51;}

                        else s = 29;

                        if ( s>=0 ) return s;
                        break;

                    case 2 : 
                        int LA34_19 = input.LA(1);

                         
                        int index34_19 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA34_19=='\t'||LA34_19==' ') && ((isHeader() == false))) {s = 107;}

                        else if ( (LA34_19=='\"') && ((isHeader() == false))) {s = 108;}

                        else if ( ((LA34_19 >= '\u0000' && LA34_19 <= '\b')||(LA34_19 >= '\u000B' && LA34_19 <= '\f')||(LA34_19 >= '\u000E' && LA34_19 <= '\u001F')||LA34_19=='!'||(LA34_19 >= '#' && LA34_19 <= ':')||(LA34_19 >= '<' && LA34_19 <= '\uFFFF')) && ((isHeader() == false))) {s = 109;}

                        else s = 106;

                         
                        input.seek(index34_19);

                        if ( s>=0 ) return s;
                        break;

                    case 3 : 
                        int LA34_24 = input.LA(1);

                         
                        int index34_24 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA34_24 >= '\u0000' && LA34_24 <= '\t')||(LA34_24 >= '\u000B' && LA34_24 <= '\f')||(LA34_24 >= '\u000E' && LA34_24 <= '+')||(LA34_24 >= '-' && LA34_24 <= ':')||(LA34_24 >= '<' && LA34_24 <= 'Z')||LA34_24=='\\'||(LA34_24 >= '^' && LA34_24 <= '\uFFFF')) && (((isArgumentModifierAssignment())||(isMacroAssignment())))) {s = 115;}

                        else if ( (LA34_24==','||LA34_24==';'||LA34_24=='['||LA34_24==']') && ((isMacroAssignment()))) {s = 116;}

                        else s = 114;

                         
                        input.seek(index34_24);

                        if ( s>=0 ) return s;
                        break;

                    case 4 : 
                        int LA34_106 = input.LA(1);

                         
                        int index34_106 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((isHeader() == false)))) ) {s = 176;}

                        else if ( ((isHeader() == false)) ) {s = 109;}

                         
                        input.seek(index34_106);

                        if ( s>=0 ) return s;
                        break;

                    case 5 : 
                        int LA34_121 = input.LA(1);

                        s = -1;
                        if ( ((LA34_121 >= '\u0000' && LA34_121 <= '\t')||(LA34_121 >= '\u000B' && LA34_121 <= '\f')||(LA34_121 >= '\u000E' && LA34_121 <= '\uFFFF')) ) {s = 178;}

                        else if ( (LA34_121=='\r') ) {s = 179;}

                        else if ( (LA34_121=='\n') ) {s = 180;}

                        else s = 104;

                        if ( s>=0 ) return s;
                        break;

                    case 6 : 
                        int LA34_178 = input.LA(1);

                        s = -1;
                        if ( (LA34_178=='\r') ) {s = 179;}

                        else if ( (LA34_178=='\n') ) {s = 180;}

                        else if ( ((LA34_178 >= '\u0000' && LA34_178 <= '\t')||(LA34_178 >= '\u000B' && LA34_178 <= '\f')||(LA34_178 >= '\u000E' && LA34_178 <= '\uFFFF')) ) {s = 178;}

                        else s = 104;

                        if ( s>=0 ) return s;
                        break;

                    case 7 : 
                        int LA34_461 = input.LA(1);

                        s = -1;
                        if ( ((LA34_461 >= '\u0000' && LA34_461 <= '/')||(LA34_461 >= ':' && LA34_461 <= '@')||(LA34_461 >= '[' && LA34_461 <= '^')||LA34_461=='`'||(LA34_461 >= '{' && LA34_461 <= '\uFFFF')) ) {s = 462;}

                        else if ( ((LA34_461 >= '0' && LA34_461 <= '9')||(LA34_461 >= 'A' && LA34_461 <= 'Z')||LA34_461=='_'||(LA34_461 >= 'a' && LA34_461 <= 'z')) ) {s = 463;}

                        else s = 119;

                        if ( s>=0 ) return s;
                        break;

                    case 8 : 
                        int LA34_463 = input.LA(1);

                        s = -1;
                        if ( ((LA34_463 >= '\u0000' && LA34_463 <= '/')||(LA34_463 >= ':' && LA34_463 <= '@')||(LA34_463 >= '[' && LA34_463 <= '^')||LA34_463=='`'||(LA34_463 >= '{' && LA34_463 <= '\uFFFF')) ) {s = 462;}

                        else if ( ((LA34_463 >= '0' && LA34_463 <= '9')||(LA34_463 >= 'A' && LA34_463 <= 'Z')||LA34_463=='_'||(LA34_463 >= 'a' && LA34_463 <= 'z')) ) {s = 463;}

                        else s = 119;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 34, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}