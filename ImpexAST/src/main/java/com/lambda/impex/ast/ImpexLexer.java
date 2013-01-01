// $ANTLR 3.4 com/lambda/impex/ast/Impex.g 2013-01-01 08:16:38

 package com.lambda.impex.ast;  

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
    public static final int BLOCK=9;
    public static final int BLOCKS=10;
    public static final int BatchMode=11;
    public static final int BeanShell=12;
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
    public static final int IMPEX=33;
    public static final int ITEM_EXPRESSION=34;
    public static final int Identifier=35;
    public static final int IgnoreKeyCase=36;
    public static final int IgnoreNull=37;
    public static final int Insert=38;
    public static final int InsertUpdate=39;
    public static final int KeyToValueDelimiter=40;
    public static final int LBracket=41;
    public static final int LParenthesis=42;
    public static final int Lang=43;
    public static final int Lb=44;
    public static final int MACRO_REF=45;
    public static final int MODIFIER=46;
    public static final int MODIFIERS=47;
    public static final int Macrodef=48;
    public static final int MapDelimiter=49;
    public static final int Mode=50;
    public static final int NumberFormat=51;
    public static final int Or=52;
    public static final int PathDelimiter=53;
    public static final int Pos=54;
    public static final int Processor=55;
    public static final int QuotedField=56;
    public static final int RBracket=57;
    public static final int RECORD=58;
    public static final int RECORDS=59;
    public static final int RParenthesis=60;
    public static final int Remove=61;
    public static final int SUBTYPE=62;
    public static final int Semicolon=63;
    public static final int Separator=64;
    public static final int SpecialAttribute=65;
    public static final int TYPE=66;
    public static final int Translator=67;
    public static final int Unique=68;
    public static final int Update=69;
    public static final int UserRights=70;
    public static final int ValueAssignment=71;
    public static final int Virtual=72;
    public static final int Ws=73;

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
    public String getGrammarFileName() { return "com/lambda/impex/ast/Impex.g"; }

    // $ANTLR start "Insert"
    public final void mInsert() throws RecognitionException {
        try {
            int _type = Insert;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/lambda/impex/ast/Impex.g:337:9: ( ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' ) )
            // com/lambda/impex/ast/Impex.g:337:10: ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' )
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
            // com/lambda/impex/ast/Impex.g:338:15: ( ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' ) '_' ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // com/lambda/impex/ast/Impex.g:338:16: ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' ) '_' ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' )
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
            // com/lambda/impex/ast/Impex.g:339:9: ( ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // com/lambda/impex/ast/Impex.g:339:10: ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' )
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
            // com/lambda/impex/ast/Impex.g:340:9: ( ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'V' | 'v' ) ( 'E' | 'e' ) )
            // com/lambda/impex/ast/Impex.g:340:10: ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'V' | 'v' ) ( 'E' | 'e' )
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
            // com/lambda/impex/ast/Impex.g:342:12: ( ( 'B' | 'b' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'D' | 'd' ) ( 'E' | 'e' ) )
            // com/lambda/impex/ast/Impex.g:342:13: ( 'B' | 'b' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'D' | 'd' ) ( 'E' | 'e' )
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
            // com/lambda/impex/ast/Impex.g:343:14: ( ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'E' | 'e' ) ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // com/lambda/impex/ast/Impex.g:343:15: ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'E' | 'e' ) ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'E' | 'e' )
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
            // com/lambda/impex/ast/Impex.g:344:12: ( ( 'P' | 'p' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'S' | 's' ) ( 'O' | 'o' ) ( 'R' | 'r' ) )
            // com/lambda/impex/ast/Impex.g:344:13: ( 'P' | 'p' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'S' | 's' ) ( 'O' | 'o' ) ( 'R' | 'r' )
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
            // com/lambda/impex/ast/Impex.g:350:8: ( ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'A' | 'a' ) ( 'S' | 's' ) )
            // com/lambda/impex/ast/Impex.g:350:9: ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'A' | 'a' ) ( 'S' | 's' )
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
            // com/lambda/impex/ast/Impex.g:351:12: ( ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'W' | 'w' ) ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'L' | 'l' ) )
            // com/lambda/impex/ast/Impex.g:351:13: ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'W' | 'w' ) ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'L' | 'l' )
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
            // com/lambda/impex/ast/Impex.g:352:15: ( ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'O' | 'o' ) ( 'R' | 'r' ) )
            // com/lambda/impex/ast/Impex.g:352:16: ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'O' | 'o' ) ( 'R' | 'r' )
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
            // com/lambda/impex/ast/Impex.g:353:22: ( ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // com/lambda/impex/ast/Impex.g:353:23: ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' )
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
            // com/lambda/impex/ast/Impex.g:354:13: ( ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'T' | 't' ) )
            // com/lambda/impex/ast/Impex.g:354:14: ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'T' | 't' )
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
            // com/lambda/impex/ast/Impex.g:355:10: ( ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'A' | 'a' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'T' | 't' ) )
            // com/lambda/impex/ast/Impex.g:355:11: ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'A' | 'a' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'T' | 't' )
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
            // com/lambda/impex/ast/Impex.g:356:13: ( ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'W' | 'w' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // com/lambda/impex/ast/Impex.g:356:14: ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'W' | 'w' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' )
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
            // com/lambda/impex/ast/Impex.g:357:15: ( ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'N' | 'n' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'K' | 'k' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'E' | 'e' ) )
            // com/lambda/impex/ast/Impex.g:357:16: ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'N' | 'n' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'K' | 'k' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'E' | 'e' )
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
            // com/lambda/impex/ast/Impex.g:358:13: ( ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'N' | 'n' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'L' | 'l' ) )
            // com/lambda/impex/ast/Impex.g:358:14: ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'N' | 'n' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'L' | 'l' )
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
            // com/lambda/impex/ast/Impex.g:359:21: ( ( 'K' | 'k' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) '2' ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // com/lambda/impex/ast/Impex.g:359:22: ( 'K' | 'k' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) '2' ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' )
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
            // com/lambda/impex/ast/Impex.g:360:7: ( ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'G' | 'g' ) )
            // com/lambda/impex/ast/Impex.g:360:8: ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'G' | 'g' )
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
            // com/lambda/impex/ast/Impex.g:361:14: ( ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'P' | 'p' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // com/lambda/impex/ast/Impex.g:361:15: ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'P' | 'p' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' )
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
            // com/lambda/impex/ast/Impex.g:362:7: ( ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'D' | 'd' ) ( 'E' | 'e' ) )
            // com/lambda/impex/ast/Impex.g:362:8: ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'D' | 'd' ) ( 'E' | 'e' )
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
            // com/lambda/impex/ast/Impex.g:363:14: ( ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'B' | 'b' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'T' | 't' ) )
            // com/lambda/impex/ast/Impex.g:363:15: ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'B' | 'b' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'T' | 't' )
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
            // com/lambda/impex/ast/Impex.g:364:15: ( ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'H' | 'h' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // com/lambda/impex/ast/Impex.g:364:16: ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'H' | 'h' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' )
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
            // com/lambda/impex/ast/Impex.g:365:6: ( ( 'P' | 'p' ) ( 'O' | 'o' ) ( 'S' | 's' ) )
            // com/lambda/impex/ast/Impex.g:365:7: ( 'P' | 'p' ) ( 'O' | 'o' ) ( 'S' | 's' )
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
            // com/lambda/impex/ast/Impex.g:366:13: ( ( 'T' | 't' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'O' | 'o' ) ( 'R' | 'r' ) )
            // com/lambda/impex/ast/Impex.g:366:14: ( 'T' | 't' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'O' | 'o' ) ( 'R' | 'r' )
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
            // com/lambda/impex/ast/Impex.g:367:9: ( ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // com/lambda/impex/ast/Impex.g:367:10: ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'E' | 'e' )
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
            // com/lambda/impex/ast/Impex.g:368:10: ( ( 'V' | 'v' ) ( 'I' | 'i' ) ( 'R' | 'r' ) ( 'T' | 't' ) ( 'U' | 'u' ) ( 'A' | 'a' ) ( 'L' | 'l' ) )
            // com/lambda/impex/ast/Impex.g:368:11: ( 'V' | 'v' ) ( 'I' | 'i' ) ( 'R' | 'r' ) ( 'T' | 't' ) ( 'U' | 'u' ) ( 'A' | 'a' ) ( 'L' | 'l' )
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
            // com/lambda/impex/ast/Impex.g:392:8: ( ',' )
            // com/lambda/impex/ast/Impex.g:392:9: ','
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
            // com/lambda/impex/ast/Impex.g:393:5: ( '.' )
            // com/lambda/impex/ast/Impex.g:393:6: '.'
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
            // com/lambda/impex/ast/Impex.g:394:13: ( '\"' )
            // com/lambda/impex/ast/Impex.g:394:14: '\"'
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
            // com/lambda/impex/ast/Impex.g:395:11: ( ';' )
            // com/lambda/impex/ast/Impex.g:395:12: ';'
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
            // com/lambda/impex/ast/Impex.g:396:10: ( ']' )
            // com/lambda/impex/ast/Impex.g:396:11: ']'
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
            // com/lambda/impex/ast/Impex.g:397:10: ( '[' )
            // com/lambda/impex/ast/Impex.g:397:11: '['
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
            // com/lambda/impex/ast/Impex.g:398:15: ( '(' )
            // com/lambda/impex/ast/Impex.g:398:16: '('
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
            // com/lambda/impex/ast/Impex.g:399:14: ( ')' )
            // com/lambda/impex/ast/Impex.g:399:15: ')'
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
            // com/lambda/impex/ast/Impex.g:400:8: ( '=' )
            // com/lambda/impex/ast/Impex.g:400:9: '='
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
            // com/lambda/impex/ast/Impex.g:401:4: ( '|' )
            // com/lambda/impex/ast/Impex.g:401:5: '|'
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
            // com/lambda/impex/ast/Impex.g:404:2: ( 'true' | 'false' )
            int alt1=2;
            switch ( input.LA(1) ) {
            case 't':
                {
                alt1=1;
                }
                break;
            case 'f':
                {
                alt1=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;

            }

            switch (alt1) {
                case 1 :
                    // com/lambda/impex/ast/Impex.g:404:3: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // com/lambda/impex/ast/Impex.g:404:12: 'false'
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

    // $ANTLR start "Separator"
    public final void mSeparator() throws RecognitionException {
        try {
            // com/lambda/impex/ast/Impex.g:417:2: ( '\\\\' ( Ws )* Lb )
            // com/lambda/impex/ast/Impex.g:417:3: '\\\\' ( Ws )* Lb
            {
            match('\\'); 

            // com/lambda/impex/ast/Impex.g:417:8: ( Ws )*
            loop2:
            do {
                int alt2=2;
                switch ( input.LA(1) ) {
                case '\t':
                case ' ':
                    {
                    alt2=1;
                    }
                    break;

                }

                switch (alt2) {
            	case 1 :
            	    // com/lambda/impex/ast/Impex.g:417:8: Ws
            	    {
            	    mWs(); 


            	    }
            	    break;

            	default :
            	    break loop2;
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
            // com/lambda/impex/ast/Impex.g:422:2: ( '$' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // com/lambda/impex/ast/Impex.g:422:3: '$' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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


            // com/lambda/impex/ast/Impex.g:422:39: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop3:
            do {
                int alt3=2;
                switch ( input.LA(1) ) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case '_':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt3=1;
                    }
                    break;

                }

                switch (alt3) {
            	case 1 :
            	    // com/lambda/impex/ast/Impex.g:
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
    // $ANTLR end "Macrodef"

    // $ANTLR start "ValueAssignment"
    public final void mValueAssignment() throws RecognitionException {
        try {
            int _type = ValueAssignment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/lambda/impex/ast/Impex.g:425:2: ({...}? => '=' (~ ( '\\r' | '\\n' ) | Separator )* |{...}? => '=' ( ( ' ' | '\\t' )* '\"' (~ ( '\\r' | '\\n' | '\"' ) | '\"' '\"' )* '\"' | (~ ( '\\r' | '\\n' | ';' | '\"' | '[' | ']' | ',' ) )* ) |)
            int alt9=3;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='=') && (((isArgumentModifierAssignment())||(isMacroAssignment())))) {
                int LA9_1 = input.LA(2);

                if ( ((isMacroAssignment())) ) {
                    alt9=1;
                }
                else if ( ((isArgumentModifierAssignment())) ) {
                    alt9=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;

                }
            }
            else {
                alt9=3;
            }
            switch (alt9) {
                case 1 :
                    // com/lambda/impex/ast/Impex.g:425:3: {...}? => '=' (~ ( '\\r' | '\\n' ) | Separator )*
                    {
                    if ( !((isMacroAssignment())) ) {
                        throw new FailedPredicateException(input, "ValueAssignment", "isMacroAssignment()");
                    }

                    match('='); 

                    // com/lambda/impex/ast/Impex.g:425:34: (~ ( '\\r' | '\\n' ) | Separator )*
                    loop4:
                    do {
                        int alt4=3;
                        alt4 = dfa4.predict(input);
                        switch (alt4) {
                    	case 1 :
                    	    // com/lambda/impex/ast/Impex.g:425:35: ~ ( '\\r' | '\\n' )
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
                    	    // com/lambda/impex/ast/Impex.g:425:52: Separator
                    	    {
                    	    mSeparator(); 


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    String text = removeSeparators(getText()); setText(text.substring(1, text.length()).trim());

                    }
                    break;
                case 2 :
                    // com/lambda/impex/ast/Impex.g:426:3: {...}? => '=' ( ( ' ' | '\\t' )* '\"' (~ ( '\\r' | '\\n' | '\"' ) | '\"' '\"' )* '\"' | (~ ( '\\r' | '\\n' | ';' | '\"' | '[' | ']' | ',' ) )* )
                    {
                    if ( !((isArgumentModifierAssignment())) ) {
                        throw new FailedPredicateException(input, "ValueAssignment", "isArgumentModifierAssignment()");
                    }

                    match('='); 

                    // com/lambda/impex/ast/Impex.g:426:44: ( ( ' ' | '\\t' )* '\"' (~ ( '\\r' | '\\n' | '\"' ) | '\"' '\"' )* '\"' | (~ ( '\\r' | '\\n' | ';' | '\"' | '[' | ']' | ',' ) )* )
                    int alt8=2;
                    alt8 = dfa8.predict(input);
                    switch (alt8) {
                        case 1 :
                            // com/lambda/impex/ast/Impex.g:426:45: ( ' ' | '\\t' )* '\"' (~ ( '\\r' | '\\n' | '\"' ) | '\"' '\"' )* '\"'
                            {
                            // com/lambda/impex/ast/Impex.g:426:45: ( ' ' | '\\t' )*
                            loop5:
                            do {
                                int alt5=2;
                                switch ( input.LA(1) ) {
                                case '\t':
                                case ' ':
                                    {
                                    alt5=1;
                                    }
                                    break;

                                }

                                switch (alt5) {
                            	case 1 :
                            	    // com/lambda/impex/ast/Impex.g:
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
                            	    break loop5;
                                }
                            } while (true);


                            match('\"'); 

                            // com/lambda/impex/ast/Impex.g:426:62: (~ ( '\\r' | '\\n' | '\"' ) | '\"' '\"' )*
                            loop6:
                            do {
                                int alt6=3;
                                int LA6_0 = input.LA(1);

                                if ( (LA6_0=='\"') ) {
                                    switch ( input.LA(2) ) {
                                    case '\"':
                                        {
                                        alt6=2;
                                        }
                                        break;

                                    }

                                }
                                else if ( ((LA6_0 >= '\u0000' && LA6_0 <= '\t')||(LA6_0 >= '\u000B' && LA6_0 <= '\f')||(LA6_0 >= '\u000E' && LA6_0 <= '!')||(LA6_0 >= '#' && LA6_0 <= '\uFFFF')) ) {
                                    alt6=1;
                                }


                                switch (alt6) {
                            	case 1 :
                            	    // com/lambda/impex/ast/Impex.g:426:63: ~ ( '\\r' | '\\n' | '\"' )
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
                            	    // com/lambda/impex/ast/Impex.g:426:87: '\"' '\"'
                            	    {
                            	    match('\"'); 

                            	    match('\"'); 

                            	    }
                            	    break;

                            	default :
                            	    break loop6;
                                }
                            } while (true);


                            match('\"'); 

                            String text = getText().substring(1, getText().length()).trim(); setText(text.substring(1, text.length() - 1));

                            }
                            break;
                        case 2 :
                            // com/lambda/impex/ast/Impex.g:426:217: (~ ( '\\r' | '\\n' | ';' | '\"' | '[' | ']' | ',' ) )*
                            {
                            // com/lambda/impex/ast/Impex.g:426:217: (~ ( '\\r' | '\\n' | ';' | '\"' | '[' | ']' | ',' ) )*
                            loop7:
                            do {
                                int alt7=2;
                                int LA7_0 = input.LA(1);

                                if ( ((LA7_0 >= '\u0000' && LA7_0 <= '\t')||(LA7_0 >= '\u000B' && LA7_0 <= '\f')||(LA7_0 >= '\u000E' && LA7_0 <= '!')||(LA7_0 >= '#' && LA7_0 <= '+')||(LA7_0 >= '-' && LA7_0 <= ':')||(LA7_0 >= '<' && LA7_0 <= 'Z')||LA7_0=='\\'||(LA7_0 >= '^' && LA7_0 <= '\uFFFF')) ) {
                                    alt7=1;
                                }


                                switch (alt7) {
                            	case 1 :
                            	    // com/lambda/impex/ast/Impex.g:
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
                            	    break loop7;
                                }
                            } while (true);


                            setText(getText().substring(1, getText().length()).trim());

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // com/lambda/impex/ast/Impex.g:427:3: 
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

    // $ANTLR start "UserRights"
    public final void mUserRights() throws RecognitionException {
        try {
            int _type = UserRights;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/lambda/impex/ast/Impex.g:501:2: ( '$START_USERRIGHTS' ( . )* '$END_USERRIGHTS' )
            // com/lambda/impex/ast/Impex.g:501:3: '$START_USERRIGHTS' ( . )* '$END_USERRIGHTS'
            {
            match("$START_USERRIGHTS"); 



            // com/lambda/impex/ast/Impex.g:501:23: ( . )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='$') ) {
                    int LA10_1 = input.LA(2);

                    if ( (LA10_1=='E') ) {
                        int LA10_3 = input.LA(3);

                        if ( (LA10_3=='N') ) {
                            int LA10_4 = input.LA(4);

                            if ( (LA10_4=='D') ) {
                                int LA10_5 = input.LA(5);

                                if ( (LA10_5=='_') ) {
                                    int LA10_6 = input.LA(6);

                                    if ( (LA10_6=='U') ) {
                                        int LA10_7 = input.LA(7);

                                        if ( (LA10_7=='S') ) {
                                            int LA10_8 = input.LA(8);

                                            if ( (LA10_8=='E') ) {
                                                int LA10_9 = input.LA(9);

                                                if ( (LA10_9=='R') ) {
                                                    int LA10_10 = input.LA(10);

                                                    if ( (LA10_10=='R') ) {
                                                        int LA10_11 = input.LA(11);

                                                        if ( (LA10_11=='I') ) {
                                                            int LA10_12 = input.LA(12);

                                                            if ( (LA10_12=='G') ) {
                                                                int LA10_13 = input.LA(13);

                                                                if ( (LA10_13=='H') ) {
                                                                    int LA10_14 = input.LA(14);

                                                                    if ( (LA10_14=='T') ) {
                                                                        int LA10_15 = input.LA(15);

                                                                        if ( (LA10_15=='S') ) {
                                                                            alt10=2;
                                                                        }
                                                                        else if ( ((LA10_15 >= '\u0000' && LA10_15 <= 'R')||(LA10_15 >= 'T' && LA10_15 <= '\uFFFF')) ) {
                                                                            alt10=1;
                                                                        }


                                                                    }
                                                                    else if ( ((LA10_14 >= '\u0000' && LA10_14 <= 'S')||(LA10_14 >= 'U' && LA10_14 <= '\uFFFF')) ) {
                                                                        alt10=1;
                                                                    }


                                                                }
                                                                else if ( ((LA10_13 >= '\u0000' && LA10_13 <= 'G')||(LA10_13 >= 'I' && LA10_13 <= '\uFFFF')) ) {
                                                                    alt10=1;
                                                                }


                                                            }
                                                            else if ( ((LA10_12 >= '\u0000' && LA10_12 <= 'F')||(LA10_12 >= 'H' && LA10_12 <= '\uFFFF')) ) {
                                                                alt10=1;
                                                            }


                                                        }
                                                        else if ( ((LA10_11 >= '\u0000' && LA10_11 <= 'H')||(LA10_11 >= 'J' && LA10_11 <= '\uFFFF')) ) {
                                                            alt10=1;
                                                        }


                                                    }
                                                    else if ( ((LA10_10 >= '\u0000' && LA10_10 <= 'Q')||(LA10_10 >= 'S' && LA10_10 <= '\uFFFF')) ) {
                                                        alt10=1;
                                                    }


                                                }
                                                else if ( ((LA10_9 >= '\u0000' && LA10_9 <= 'Q')||(LA10_9 >= 'S' && LA10_9 <= '\uFFFF')) ) {
                                                    alt10=1;
                                                }


                                            }
                                            else if ( ((LA10_8 >= '\u0000' && LA10_8 <= 'D')||(LA10_8 >= 'F' && LA10_8 <= '\uFFFF')) ) {
                                                alt10=1;
                                            }


                                        }
                                        else if ( ((LA10_7 >= '\u0000' && LA10_7 <= 'R')||(LA10_7 >= 'T' && LA10_7 <= '\uFFFF')) ) {
                                            alt10=1;
                                        }


                                    }
                                    else if ( ((LA10_6 >= '\u0000' && LA10_6 <= 'T')||(LA10_6 >= 'V' && LA10_6 <= '\uFFFF')) ) {
                                        alt10=1;
                                    }


                                }
                                else if ( ((LA10_5 >= '\u0000' && LA10_5 <= '^')||(LA10_5 >= '`' && LA10_5 <= '\uFFFF')) ) {
                                    alt10=1;
                                }


                            }
                            else if ( ((LA10_4 >= '\u0000' && LA10_4 <= 'C')||(LA10_4 >= 'E' && LA10_4 <= '\uFFFF')) ) {
                                alt10=1;
                            }


                        }
                        else if ( ((LA10_3 >= '\u0000' && LA10_3 <= 'M')||(LA10_3 >= 'O' && LA10_3 <= '\uFFFF')) ) {
                            alt10=1;
                        }


                    }
                    else if ( ((LA10_1 >= '\u0000' && LA10_1 <= 'D')||(LA10_1 >= 'F' && LA10_1 <= '\uFFFF')) ) {
                        alt10=1;
                    }


                }
                else if ( ((LA10_0 >= '\u0000' && LA10_0 <= '#')||(LA10_0 >= '%' && LA10_0 <= '\uFFFF')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // com/lambda/impex/ast/Impex.g:501:23: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop10;
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
            // com/lambda/impex/ast/Impex.g:504:2: ( ( ( '#%' (~ ( '\\r' | '\\n' ) )* | '\"#%' (~ ( '\"' ) | '\"' '\"' )* '\"' ) ( Lb )? ) )
            // com/lambda/impex/ast/Impex.g:504:3: ( ( '#%' (~ ( '\\r' | '\\n' ) )* | '\"#%' (~ ( '\"' ) | '\"' '\"' )* '\"' ) ( Lb )? )
            {
            // com/lambda/impex/ast/Impex.g:504:3: ( ( '#%' (~ ( '\\r' | '\\n' ) )* | '\"#%' (~ ( '\"' ) | '\"' '\"' )* '\"' ) ( Lb )? )
            // com/lambda/impex/ast/Impex.g:504:4: ( '#%' (~ ( '\\r' | '\\n' ) )* | '\"#%' (~ ( '\"' ) | '\"' '\"' )* '\"' ) ( Lb )?
            {
            // com/lambda/impex/ast/Impex.g:504:4: ( '#%' (~ ( '\\r' | '\\n' ) )* | '\"#%' (~ ( '\"' ) | '\"' '\"' )* '\"' )
            int alt13=2;
            switch ( input.LA(1) ) {
            case '#':
                {
                alt13=1;
                }
                break;
            case '\"':
                {
                alt13=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;

            }

            switch (alt13) {
                case 1 :
                    // com/lambda/impex/ast/Impex.g:504:5: '#%' (~ ( '\\r' | '\\n' ) )*
                    {
                    match("#%"); 



                    // com/lambda/impex/ast/Impex.g:504:10: (~ ( '\\r' | '\\n' ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( ((LA11_0 >= '\u0000' && LA11_0 <= '\t')||(LA11_0 >= '\u000B' && LA11_0 <= '\f')||(LA11_0 >= '\u000E' && LA11_0 <= '\uFFFF')) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // com/lambda/impex/ast/Impex.g:
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
                    	    break loop11;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // com/lambda/impex/ast/Impex.g:504:28: '\"#%' (~ ( '\"' ) | '\"' '\"' )* '\"'
                    {
                    match("\"#%"); 



                    // com/lambda/impex/ast/Impex.g:504:34: (~ ( '\"' ) | '\"' '\"' )*
                    loop12:
                    do {
                        int alt12=3;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0=='\"') ) {
                            switch ( input.LA(2) ) {
                            case '\"':
                                {
                                alt12=2;
                                }
                                break;

                            }

                        }
                        else if ( ((LA12_0 >= '\u0000' && LA12_0 <= '!')||(LA12_0 >= '#' && LA12_0 <= '\uFFFF')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // com/lambda/impex/ast/Impex.g:504:35: ~ ( '\"' )
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
                    	    // com/lambda/impex/ast/Impex.g:504:44: '\"' '\"'
                    	    {
                    	    match('\"'); 

                    	    match('\"'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    match('\"'); 

                    }
                    break;

            }


            // com/lambda/impex/ast/Impex.g:504:59: ( Lb )?
            int alt14=2;
            switch ( input.LA(1) ) {
                case '\n':
                case '\r':
                    {
                    alt14=1;
                    }
                    break;
            }

            switch (alt14) {
                case 1 :
                    // com/lambda/impex/ast/Impex.g:504:59: Lb
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
            // com/lambda/impex/ast/Impex.g:507:2: ( '@' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // com/lambda/impex/ast/Impex.g:507:3: '@' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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


            // com/lambda/impex/ast/Impex.g:507:39: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop15:
            do {
                int alt15=2;
                switch ( input.LA(1) ) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case '_':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt15=1;
                    }
                    break;

                }

                switch (alt15) {
            	case 1 :
            	    // com/lambda/impex/ast/Impex.g:
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
            	    break loop15;
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
            // com/lambda/impex/ast/Impex.g:510:2: ( '&' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // com/lambda/impex/ast/Impex.g:510:3: '&' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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


            // com/lambda/impex/ast/Impex.g:510:39: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop16:
            do {
                int alt16=2;
                switch ( input.LA(1) ) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case '_':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt16=1;
                    }
                    break;

                }

                switch (alt16) {
            	case 1 :
            	    // com/lambda/impex/ast/Impex.g:
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
            	    break loop16;
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
            // com/lambda/impex/ast/Impex.g:513:2: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // com/lambda/impex/ast/Impex.g:513:3: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // com/lambda/impex/ast/Impex.g:513:35: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop17:
            do {
                int alt17=2;
                switch ( input.LA(1) ) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case '_':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt17=1;
                    }
                    break;

                }

                switch (alt17) {
            	case 1 :
            	    // com/lambda/impex/ast/Impex.g:
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
            	    break loop17;
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
            // com/lambda/impex/ast/Impex.g:516:2: ( ( ( 'a' .. 'z' )+ '.' )+ 'A' .. 'Z' ( 'A' .. 'Z' | 'a' .. 'z' )+ )
            // com/lambda/impex/ast/Impex.g:516:3: ( ( 'a' .. 'z' )+ '.' )+ 'A' .. 'Z' ( 'A' .. 'Z' | 'a' .. 'z' )+
            {
            // com/lambda/impex/ast/Impex.g:516:3: ( ( 'a' .. 'z' )+ '.' )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                switch ( input.LA(1) ) {
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt19=1;
                    }
                    break;

                }

                switch (alt19) {
            	case 1 :
            	    // com/lambda/impex/ast/Impex.g:516:4: ( 'a' .. 'z' )+ '.'
            	    {
            	    // com/lambda/impex/ast/Impex.g:516:4: ( 'a' .. 'z' )+
            	    int cnt18=0;
            	    loop18:
            	    do {
            	        int alt18=2;
            	        switch ( input.LA(1) ) {
            	        case 'a':
            	        case 'b':
            	        case 'c':
            	        case 'd':
            	        case 'e':
            	        case 'f':
            	        case 'g':
            	        case 'h':
            	        case 'i':
            	        case 'j':
            	        case 'k':
            	        case 'l':
            	        case 'm':
            	        case 'n':
            	        case 'o':
            	        case 'p':
            	        case 'q':
            	        case 'r':
            	        case 's':
            	        case 't':
            	        case 'u':
            	        case 'v':
            	        case 'w':
            	        case 'x':
            	        case 'y':
            	        case 'z':
            	            {
            	            alt18=1;
            	            }
            	            break;

            	        }

            	        switch (alt18) {
            	    	case 1 :
            	    	    // com/lambda/impex/ast/Impex.g:
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
            	    	    if ( cnt18 >= 1 ) break loop18;
            	                EarlyExitException eee =
            	                    new EarlyExitException(18, input);
            	                throw eee;
            	        }
            	        cnt18++;
            	    } while (true);


            	    match('.'); 

            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);


            matchRange('A','Z'); 

            // com/lambda/impex/ast/Impex.g:516:35: ( 'A' .. 'Z' | 'a' .. 'z' )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                switch ( input.LA(1) ) {
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt20=1;
                    }
                    break;

                }

                switch (alt20) {
            	case 1 :
            	    // com/lambda/impex/ast/Impex.g:
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
            	    if ( cnt20 >= 1 ) break loop20;
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
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
            // com/lambda/impex/ast/Impex.g:520:2: ( '#' (~ ( '\\r' | '\\n' ) )* ( Lb )? )
            // com/lambda/impex/ast/Impex.g:520:3: '#' (~ ( '\\r' | '\\n' ) )* ( Lb )?
            {
            match('#'); 

            // com/lambda/impex/ast/Impex.g:520:7: (~ ( '\\r' | '\\n' ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0 >= '\u0000' && LA21_0 <= '\t')||(LA21_0 >= '\u000B' && LA21_0 <= '\f')||(LA21_0 >= '\u000E' && LA21_0 <= '\uFFFF')) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // com/lambda/impex/ast/Impex.g:
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
            	    break loop21;
                }
            } while (true);


            // com/lambda/impex/ast/Impex.g:520:23: ( Lb )?
            int alt22=2;
            switch ( input.LA(1) ) {
                case '\n':
                case '\r':
                    {
                    alt22=1;
                    }
                    break;
            }

            switch (alt22) {
                case 1 :
                    // com/lambda/impex/ast/Impex.g:520:23: Lb
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
            // com/lambda/impex/ast/Impex.g:533:2: ({...}? => ';' ( Ws )* '\"' (~ '\"' | '\"' '\"' )* '\"' |)
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==';') && ((isHeader() == false))) {
                alt25=1;
            }
            else {
                alt25=2;
            }
            switch (alt25) {
                case 1 :
                    // com/lambda/impex/ast/Impex.g:533:3: {...}? => ';' ( Ws )* '\"' (~ '\"' | '\"' '\"' )* '\"'
                    {
                    if ( !((isHeader() == false)) ) {
                        throw new FailedPredicateException(input, "QuotedField", "isHeader() == false");
                    }

                    match(';'); 

                    // com/lambda/impex/ast/Impex.g:533:32: ( Ws )*
                    loop23:
                    do {
                        int alt23=2;
                        switch ( input.LA(1) ) {
                        case '\t':
                        case ' ':
                            {
                            alt23=1;
                            }
                            break;

                        }

                        switch (alt23) {
                    	case 1 :
                    	    // com/lambda/impex/ast/Impex.g:533:32: Ws
                    	    {
                    	    mWs(); 


                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);


                    match('\"'); 

                    // com/lambda/impex/ast/Impex.g:533:40: (~ '\"' | '\"' '\"' )*
                    loop24:
                    do {
                        int alt24=3;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0=='\"') ) {
                            switch ( input.LA(2) ) {
                            case '\"':
                                {
                                alt24=2;
                                }
                                break;

                            }

                        }
                        else if ( ((LA24_0 >= '\u0000' && LA24_0 <= '!')||(LA24_0 >= '#' && LA24_0 <= '\uFFFF')) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // com/lambda/impex/ast/Impex.g:533:41: ~ '\"'
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
                    	    // com/lambda/impex/ast/Impex.g:533:48: '\"' '\"'
                    	    {
                    	    match('\"'); 

                    	    match('\"'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);


                    match('\"'); 

                    }
                    break;
                case 2 :
                    // com/lambda/impex/ast/Impex.g:533:64: 
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
            // com/lambda/impex/ast/Impex.g:540:2: ({...}? => ( ';' ( Char | Separator )* ) |)
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==';') && ((isHeader() == false))) {
                alt27=1;
            }
            else {
                alt27=2;
            }
            switch (alt27) {
                case 1 :
                    // com/lambda/impex/ast/Impex.g:540:3: {...}? => ( ';' ( Char | Separator )* )
                    {
                    if ( !((isHeader() == false)) ) {
                        throw new FailedPredicateException(input, "Field", "isHeader() == false");
                    }

                    // com/lambda/impex/ast/Impex.g:540:28: ( ';' ( Char | Separator )* )
                    // com/lambda/impex/ast/Impex.g:540:29: ';' ( Char | Separator )*
                    {
                    match(';'); 

                    // com/lambda/impex/ast/Impex.g:540:33: ( Char | Separator )*
                    loop26:
                    do {
                        int alt26=3;
                        alt26 = dfa26.predict(input);
                        switch (alt26) {
                    	case 1 :
                    	    // com/lambda/impex/ast/Impex.g:540:34: Char
                    	    {
                    	    mChar(); 


                    	    }
                    	    break;
                    	case 2 :
                    	    // com/lambda/impex/ast/Impex.g:540:40: Separator
                    	    {
                    	    mSeparator(); 


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // com/lambda/impex/ast/Impex.g:540:54: 
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
            // com/lambda/impex/ast/Impex.g:557:3: ( ( ' ' | '\\t' ) )
            // com/lambda/impex/ast/Impex.g:557:4: ( ' ' | '\\t' )
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
            // com/lambda/impex/ast/Impex.g:559:4: ( ( ( '\\r' )? '\\n' | '\\r' ) )
            // com/lambda/impex/ast/Impex.g:559:5: ( ( '\\r' )? '\\n' | '\\r' )
            {
            // com/lambda/impex/ast/Impex.g:559:5: ( ( '\\r' )? '\\n' | '\\r' )
            int alt29=2;
            switch ( input.LA(1) ) {
            case '\r':
                {
                switch ( input.LA(2) ) {
                case '\n':
                    {
                    alt29=1;
                    }
                    break;
                default:
                    alt29=2;
                }

                }
                break;
            case '\n':
                {
                alt29=1;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;

            }

            switch (alt29) {
                case 1 :
                    // com/lambda/impex/ast/Impex.g:559:6: ( '\\r' )? '\\n'
                    {
                    // com/lambda/impex/ast/Impex.g:559:6: ( '\\r' )?
                    int alt28=2;
                    switch ( input.LA(1) ) {
                        case '\r':
                            {
                            alt28=1;
                            }
                            break;
                    }

                    switch (alt28) {
                        case 1 :
                            // com/lambda/impex/ast/Impex.g:559:6: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    }
                    break;
                case 2 :
                    // com/lambda/impex/ast/Impex.g:559:19: '\\r'
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
            // com/lambda/impex/ast/Impex.g:561:2: (~ ( '\\r' | '\\n' | '\"' | ';' ) )
            // com/lambda/impex/ast/Impex.g:
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
        // com/lambda/impex/ast/Impex.g:1:8: ( Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual | Comma | Dot | DoubleQuote | Semicolon | RBracket | LBracket | LParenthesis | RParenthesis | Equals | Or | Bool | Macrodef | ValueAssignment | UserRights | BeanShell | SpecialAttribute | DocumentID | Identifier | Classname | Comment | QuotedField | Field | Ws | Lb | Char )
        int alt30=51;
        alt30 = dfa30.predict(input);
        switch (alt30) {
            case 1 :
                // com/lambda/impex/ast/Impex.g:1:10: Insert
                {
                mInsert(); 


                }
                break;
            case 2 :
                // com/lambda/impex/ast/Impex.g:1:17: InsertUpdate
                {
                mInsertUpdate(); 


                }
                break;
            case 3 :
                // com/lambda/impex/ast/Impex.g:1:30: Update
                {
                mUpdate(); 


                }
                break;
            case 4 :
                // com/lambda/impex/ast/Impex.g:1:37: Remove
                {
                mRemove(); 


                }
                break;
            case 5 :
                // com/lambda/impex/ast/Impex.g:1:44: BatchMode
                {
                mBatchMode(); 


                }
                break;
            case 6 :
                // com/lambda/impex/ast/Impex.g:1:54: CacheUnique
                {
                mCacheUnique(); 


                }
                break;
            case 7 :
                // com/lambda/impex/ast/Impex.g:1:66: Processor
                {
                mProcessor(); 


                }
                break;
            case 8 :
                // com/lambda/impex/ast/Impex.g:1:76: Alias
                {
                mAlias(); 


                }
                break;
            case 9 :
                // com/lambda/impex/ast/Impex.g:1:82: AllowNull
                {
                mAllowNull(); 


                }
                break;
            case 10 :
                // com/lambda/impex/ast/Impex.g:1:92: CellDecorator
                {
                mCellDecorator(); 


                }
                break;
            case 11 :
                // com/lambda/impex/ast/Impex.g:1:106: CollectionDelimiter
                {
                mCollectionDelimiter(); 


                }
                break;
            case 12 :
                // com/lambda/impex/ast/Impex.g:1:126: Dateformat
                {
                mDateformat(); 


                }
                break;
            case 13 :
                // com/lambda/impex/ast/Impex.g:1:137: Default
                {
                mDefault(); 


                }
                break;
            case 14 :
                // com/lambda/impex/ast/Impex.g:1:145: ForceWrite
                {
                mForceWrite(); 


                }
                break;
            case 15 :
                // com/lambda/impex/ast/Impex.g:1:156: IgnoreKeyCase
                {
                mIgnoreKeyCase(); 


                }
                break;
            case 16 :
                // com/lambda/impex/ast/Impex.g:1:170: IgnoreNull
                {
                mIgnoreNull(); 


                }
                break;
            case 17 :
                // com/lambda/impex/ast/Impex.g:1:181: KeyToValueDelimiter
                {
                mKeyToValueDelimiter(); 


                }
                break;
            case 18 :
                // com/lambda/impex/ast/Impex.g:1:201: Lang
                {
                mLang(); 


                }
                break;
            case 19 :
                // com/lambda/impex/ast/Impex.g:1:206: MapDelimiter
                {
                mMapDelimiter(); 


                }
                break;
            case 20 :
                // com/lambda/impex/ast/Impex.g:1:219: Mode
                {
                mMode(); 


                }
                break;
            case 21 :
                // com/lambda/impex/ast/Impex.g:1:224: NumberFormat
                {
                mNumberFormat(); 


                }
                break;
            case 22 :
                // com/lambda/impex/ast/Impex.g:1:237: PathDelimiter
                {
                mPathDelimiter(); 


                }
                break;
            case 23 :
                // com/lambda/impex/ast/Impex.g:1:251: Pos
                {
                mPos(); 


                }
                break;
            case 24 :
                // com/lambda/impex/ast/Impex.g:1:255: Translator
                {
                mTranslator(); 


                }
                break;
            case 25 :
                // com/lambda/impex/ast/Impex.g:1:266: Unique
                {
                mUnique(); 


                }
                break;
            case 26 :
                // com/lambda/impex/ast/Impex.g:1:273: Virtual
                {
                mVirtual(); 


                }
                break;
            case 27 :
                // com/lambda/impex/ast/Impex.g:1:281: Comma
                {
                mComma(); 


                }
                break;
            case 28 :
                // com/lambda/impex/ast/Impex.g:1:287: Dot
                {
                mDot(); 


                }
                break;
            case 29 :
                // com/lambda/impex/ast/Impex.g:1:291: DoubleQuote
                {
                mDoubleQuote(); 


                }
                break;
            case 30 :
                // com/lambda/impex/ast/Impex.g:1:303: Semicolon
                {
                mSemicolon(); 


                }
                break;
            case 31 :
                // com/lambda/impex/ast/Impex.g:1:313: RBracket
                {
                mRBracket(); 


                }
                break;
            case 32 :
                // com/lambda/impex/ast/Impex.g:1:322: LBracket
                {
                mLBracket(); 


                }
                break;
            case 33 :
                // com/lambda/impex/ast/Impex.g:1:331: LParenthesis
                {
                mLParenthesis(); 


                }
                break;
            case 34 :
                // com/lambda/impex/ast/Impex.g:1:344: RParenthesis
                {
                mRParenthesis(); 


                }
                break;
            case 35 :
                // com/lambda/impex/ast/Impex.g:1:357: Equals
                {
                mEquals(); 


                }
                break;
            case 36 :
                // com/lambda/impex/ast/Impex.g:1:364: Or
                {
                mOr(); 


                }
                break;
            case 37 :
                // com/lambda/impex/ast/Impex.g:1:367: Bool
                {
                mBool(); 


                }
                break;
            case 38 :
                // com/lambda/impex/ast/Impex.g:1:372: Macrodef
                {
                mMacrodef(); 


                }
                break;
            case 39 :
                // com/lambda/impex/ast/Impex.g:1:381: ValueAssignment
                {
                mValueAssignment(); 


                }
                break;
            case 40 :
                // com/lambda/impex/ast/Impex.g:1:397: UserRights
                {
                mUserRights(); 


                }
                break;
            case 41 :
                // com/lambda/impex/ast/Impex.g:1:408: BeanShell
                {
                mBeanShell(); 


                }
                break;
            case 42 :
                // com/lambda/impex/ast/Impex.g:1:418: SpecialAttribute
                {
                mSpecialAttribute(); 


                }
                break;
            case 43 :
                // com/lambda/impex/ast/Impex.g:1:435: DocumentID
                {
                mDocumentID(); 


                }
                break;
            case 44 :
                // com/lambda/impex/ast/Impex.g:1:446: Identifier
                {
                mIdentifier(); 


                }
                break;
            case 45 :
                // com/lambda/impex/ast/Impex.g:1:457: Classname
                {
                mClassname(); 


                }
                break;
            case 46 :
                // com/lambda/impex/ast/Impex.g:1:467: Comment
                {
                mComment(); 


                }
                break;
            case 47 :
                // com/lambda/impex/ast/Impex.g:1:475: QuotedField
                {
                mQuotedField(); 


                }
                break;
            case 48 :
                // com/lambda/impex/ast/Impex.g:1:487: Field
                {
                mField(); 


                }
                break;
            case 49 :
                // com/lambda/impex/ast/Impex.g:1:493: Ws
                {
                mWs(); 


                }
                break;
            case 50 :
                // com/lambda/impex/ast/Impex.g:1:496: Lb
                {
                mLb(); 


                }
                break;
            case 51 :
                // com/lambda/impex/ast/Impex.g:1:499: Char
                {
                mChar(); 


                }
                break;

        }

    }


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA8 dfa8 = new DFA8(this);
    protected DFA26 dfa26 = new DFA26(this);
    protected DFA30 dfa30 = new DFA30(this);
    static final String DFA4_eotS =
        "\1\1\1\uffff\1\3\1\uffff\1\3\1\uffff";
    static final String DFA4_eofS =
        "\6\uffff";
    static final String DFA4_minS =
        "\1\0\1\uffff\1\11\1\uffff\1\11\1\uffff";
    static final String DFA4_maxS =
        "\1\uffff\1\uffff\1\40\1\uffff\1\40\1\uffff";
    static final String DFA4_acceptS =
        "\1\uffff\1\3\1\uffff\1\1\1\uffff\1\2";
    static final String DFA4_specialS =
        "\1\0\5\uffff}>";
    static final String[] DFA4_transitionS = {
            "\12\3\1\uffff\2\3\1\uffff\116\3\1\2\uffa3\3",
            "",
            "\1\4\1\5\2\uffff\1\5\22\uffff\1\4",
            "",
            "\1\4\1\5\2\uffff\1\5\22\uffff\1\4",
            ""
    };

    static final short[] DFA4_eot = DFA.unpackEncodedString(DFA4_eotS);
    static final short[] DFA4_eof = DFA.unpackEncodedString(DFA4_eofS);
    static final char[] DFA4_min = DFA.unpackEncodedStringToUnsignedChars(DFA4_minS);
    static final char[] DFA4_max = DFA.unpackEncodedStringToUnsignedChars(DFA4_maxS);
    static final short[] DFA4_accept = DFA.unpackEncodedString(DFA4_acceptS);
    static final short[] DFA4_special = DFA.unpackEncodedString(DFA4_specialS);
    static final short[][] DFA4_transition;

    static {
        int numStates = DFA4_transitionS.length;
        DFA4_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA4_transition[i] = DFA.unpackEncodedString(DFA4_transitionS[i]);
        }
    }

    class DFA4 extends DFA {

        public DFA4(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 4;
            this.eot = DFA4_eot;
            this.eof = DFA4_eof;
            this.min = DFA4_min;
            this.max = DFA4_max;
            this.accept = DFA4_accept;
            this.special = DFA4_special;
            this.transition = DFA4_transition;
        }
        public String getDescription() {
            return "()* loopback of 425:34: (~ ( '\\r' | '\\n' ) | Separator )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA4_0 = input.LA(1);

                        s = -1;
                        if ( (LA4_0=='\\') ) {s = 2;}

                        else if ( ((LA4_0 >= '\u0000' && LA4_0 <= '\t')||(LA4_0 >= '\u000B' && LA4_0 <= '\f')||(LA4_0 >= '\u000E' && LA4_0 <= '[')||(LA4_0 >= ']' && LA4_0 <= '\uFFFF')) ) {s = 3;}

                        else s = 1;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 4, _s, input);
            error(nvae);
            throw nvae;
        }

    }
    static final String DFA8_eotS =
        "\2\3\2\uffff";
    static final String DFA8_eofS =
        "\4\uffff";
    static final String DFA8_minS =
        "\2\11\2\uffff";
    static final String DFA8_maxS =
        "\2\42\2\uffff";
    static final String DFA8_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA8_specialS =
        "\4\uffff}>";
    static final String[] DFA8_transitionS = {
            "\1\1\26\uffff\1\1\1\uffff\1\2",
            "\1\1\26\uffff\1\1\1\uffff\1\2",
            "",
            ""
    };

    static final short[] DFA8_eot = DFA.unpackEncodedString(DFA8_eotS);
    static final short[] DFA8_eof = DFA.unpackEncodedString(DFA8_eofS);
    static final char[] DFA8_min = DFA.unpackEncodedStringToUnsignedChars(DFA8_minS);
    static final char[] DFA8_max = DFA.unpackEncodedStringToUnsignedChars(DFA8_maxS);
    static final short[] DFA8_accept = DFA.unpackEncodedString(DFA8_acceptS);
    static final short[] DFA8_special = DFA.unpackEncodedString(DFA8_specialS);
    static final short[][] DFA8_transition;

    static {
        int numStates = DFA8_transitionS.length;
        DFA8_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA8_transition[i] = DFA.unpackEncodedString(DFA8_transitionS[i]);
        }
    }

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = DFA8_eot;
            this.eof = DFA8_eof;
            this.min = DFA8_min;
            this.max = DFA8_max;
            this.accept = DFA8_accept;
            this.special = DFA8_special;
            this.transition = DFA8_transition;
        }
        public String getDescription() {
            return "426:44: ( ( ' ' | '\\t' )* '\"' (~ ( '\\r' | '\\n' | '\"' ) | '\"' '\"' )* '\"' | (~ ( '\\r' | '\\n' | ';' | '\"' | '[' | ']' | ',' ) )* )";
        }
    }
    static final String DFA26_eotS =
        "\1\1\1\uffff\1\3\1\uffff\1\3\1\uffff";
    static final String DFA26_eofS =
        "\6\uffff";
    static final String DFA26_minS =
        "\1\0\1\uffff\1\11\1\uffff\1\11\1\uffff";
    static final String DFA26_maxS =
        "\1\uffff\1\uffff\1\40\1\uffff\1\40\1\uffff";
    static final String DFA26_acceptS =
        "\1\uffff\1\3\1\uffff\1\1\1\uffff\1\2";
    static final String DFA26_specialS =
        "\1\0\5\uffff}>";
    static final String[] DFA26_transitionS = {
            "\12\3\1\uffff\2\3\1\uffff\24\3\1\uffff\30\3\1\uffff\40\3\1\2"+
            "\uffa3\3",
            "",
            "\1\4\1\5\2\uffff\1\5\22\uffff\1\4",
            "",
            "\1\4\1\5\2\uffff\1\5\22\uffff\1\4",
            ""
    };

    static final short[] DFA26_eot = DFA.unpackEncodedString(DFA26_eotS);
    static final short[] DFA26_eof = DFA.unpackEncodedString(DFA26_eofS);
    static final char[] DFA26_min = DFA.unpackEncodedStringToUnsignedChars(DFA26_minS);
    static final char[] DFA26_max = DFA.unpackEncodedStringToUnsignedChars(DFA26_maxS);
    static final short[] DFA26_accept = DFA.unpackEncodedString(DFA26_acceptS);
    static final short[] DFA26_special = DFA.unpackEncodedString(DFA26_specialS);
    static final short[][] DFA26_transition;

    static {
        int numStates = DFA26_transitionS.length;
        DFA26_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA26_transition[i] = DFA.unpackEncodedString(DFA26_transitionS[i]);
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = DFA26_eot;
            this.eof = DFA26_eof;
            this.min = DFA26_min;
            this.max = DFA26_max;
            this.accept = DFA26_accept;
            this.special = DFA26_special;
            this.transition = DFA26_transition;
        }
        public String getDescription() {
            return "()* loopback of 540:33: ( Char | Separator )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA26_0 = input.LA(1);

                        s = -1;
                        if ( (LA26_0=='\\') ) {s = 2;}

                        else if ( ((LA26_0 >= '\u0000' && LA26_0 <= '\t')||(LA26_0 >= '\u000B' && LA26_0 <= '\f')||(LA26_0 >= '\u000E' && LA26_0 <= '!')||(LA26_0 >= '#' && LA26_0 <= ':')||(LA26_0 >= '<' && LA26_0 <= '[')||(LA26_0 >= ']' && LA26_0 <= '\uFFFF')) ) {s = 3;}

                        else s = 1;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 26, _s, input);
            error(nvae);
            throw nvae;
        }

    }
    static final String DFA30_eotS =
        "\1\35\17\66\2\uffff\1\150\1\151\4\uffff\1\161\1\uffff\2\66\1\62"+
        "\1\uffff\1\170\2\62\16\66\4\uffff\3\66\2\uffff\55\66\5\uffff\1\154"+
        "\12\uffff\1\166\1\uffff\1\147\4\uffff\26\66\2\u00c9\32\66\1\uffff"+
        "\1\166\2\147\1\uffff\26\66\1\uffff\14\66\2\u0104\1\uffff\2\u0105"+
        "\4\66\1\u010a\2\66\1\166\24\66\1\uffff\2\u0122\10\66\1\u010a\1\66"+
        "\2\uffff\4\66\1\uffff\2\66\1\166\2\u0134\2\66\2\u0139\2\u013a\2"+
        "\u013b\12\66\1\uffff\17\66\1\166\1\66\1\uffff\4\66\3\uffff\16\66"+
        "\2\u0169\7\66\2\u0171\1\166\23\66\1\uffff\7\66\1\uffff\1\166\5\66"+
        "\2\u0193\6\66\2\u019a\2\u019b\11\66\1\166\3\66\2\u01a9\1\uffff\6"+
        "\66\2\uffff\2\u01af\2\u01b0\1\uffff\2\66\2\u01b3\1\166\3\66\1\uffff"+
        "\2\u01b8\2\66\3\uffff\2\66\1\uffff\1\166\3\66\1\uffff\2\66\2\u01c3"+
        "\1\166\1\u01c5\2\u01c6\2\u01c7\1\uffff\1\166\3\uffff\4\166\1\uffff"+
        "\1\166";
    static final String DFA30_eofS =
        "\u01ce\uffff";
    static final String DFA30_minS =
        "\1\0\17\56\2\uffff\1\43\1\0\4\uffff\1\0\1\uffff\1\122\1\117\1\101"+
        "\1\uffff\1\45\2\101\1\56\1\107\1\116\1\105\3\101\1\114\1\101\1\105"+
        "\2\101\1\125\1\111\4\uffff\3\56\2\uffff\1\123\1\116\2\56\1\104\1"+
        "\111\1\56\1\115\1\56\1\124\3\56\1\103\2\114\3\56\1\117\1\124\1\123"+
        "\1\56\1\111\2\56\1\124\1\106\2\56\1\122\1\56\1\131\1\56\1\116\2"+
        "\56\1\120\1\104\1\56\1\115\1\56\1\101\1\56\1\122\4\uffff\1\0\1\11"+
        "\12\uffff\1\124\1\uffff\1\0\4\uffff\1\56\1\105\1\56\1\117\1\56\1"+
        "\101\1\56\1\121\1\56\1\117\1\56\1\103\1\56\1\110\1\56\1\114\1\56"+
        "\1\114\1\56\1\103\1\56\1\110\1\56\1\60\2\56\1\101\1\117\1\56\1\105"+
        "\1\56\1\101\1\56\1\103\2\56\1\62\1\56\1\107\2\55\1\56\1\105\1\56"+
        "\1\102\2\56\1\116\1\56\1\124\1\uffff\1\101\1\0\1\12\1\uffff\1\56"+
        "\1\122\1\56\1\122\1\56\1\124\1\56\1\125\1\56\1\126\1\56\1\110\1"+
        "\56\1\105\1\56\1\104\1\56\1\105\1\56\1\105\2\55\1\uffff\1\56\1\123"+
        "\1\56\1\127\1\56\1\106\1\56\1\125\1\56\1\105\1\56\1\126\1\56\1\60"+
        "\1\uffff\1\56\1\60\1\56\1\105\1\56\1\123\2\56\1\125\1\122\1\56\1"+
        "\124\1\56\1\105\1\56\1\105\1\56\1\105\1\56\1\105\1\56\1\115\1\56"+
        "\1\125\1\56\1\105\1\56\1\103\1\56\1\123\1\uffff\1\56\1\60\1\56\1"+
        "\116\1\56\1\117\1\56\1\114\1\56\1\127\1\56\1\101\2\uffff\1\56\1"+
        "\122\1\56\1\114\1\uffff\1\56\1\101\1\124\1\56\1\60\1\56\1\113\1"+
        "\56\1\60\1\56\1\60\1\56\1\60\1\56\1\117\1\56\1\116\1\56\1\103\1"+
        "\56\1\124\1\56\1\123\1\uffff\1\56\1\125\1\56\1\122\1\56\1\124\1"+
        "\56\1\122\1\114\1\56\1\106\1\56\1\101\1\56\1\114\1\137\1\125\1\uffff"+
        "\2\56\1\105\1\125\3\uffff\1\56\1\104\1\56\1\111\1\56\1\117\1\56"+
        "\1\111\1\56\1\117\1\56\1\114\1\56\1\115\1\56\1\60\1\56\1\111\1\125"+
        "\1\56\1\117\1\56\1\124\1\56\1\60\1\125\1\120\1\56\1\131\1\56\1\114"+
        "\1\56\1\105\1\56\1\121\1\56\1\122\1\56\1\117\1\56\1\122\1\56\1\114"+
        "\1\56\1\101\1\uffff\1\56\1\124\1\105\1\56\1\122\1\56\1\117\1\uffff"+
        "\1\123\1\104\1\56\1\103\1\56\1\114\1\56\1\60\1\56\1\125\1\56\1\101"+
        "\1\56\1\116\1\56\1\60\1\56\1\60\1\56\1\124\1\56\1\105\1\55\1\56"+
        "\1\115\1\56\1\122\1\105\1\101\1\56\1\101\1\56\1\60\1\uffff\1\56"+
        "\1\105\1\56\1\124\2\55\2\uffff\1\56\1\60\1\56\1\60\1\uffff\1\56"+
        "\1\101\1\56\1\60\1\122\1\124\1\56\1\123\1\uffff\1\56\1\60\1\56\1"+
        "\117\3\uffff\1\56\1\124\1\uffff\1\122\1\105\1\56\1\105\1\uffff\1"+
        "\56\1\122\1\56\1\60\1\111\1\60\1\56\1\60\1\56\1\60\1\uffff\1\107"+
        "\3\uffff\1\110\1\124\1\123\1\0\1\uffff\1\0";
    static final String DFA30_maxS =
        "\1\uffff\17\172\2\uffff\1\43\1\uffff\4\uffff\1\uffff\1\uffff\1\162"+
        "\1\157\1\172\1\uffff\1\45\3\172\1\156\1\160\1\145\1\141\1\157\1"+
        "\162\1\154\2\145\1\141\1\157\1\165\1\151\4\uffff\3\172\2\uffff\1"+
        "\163\1\156\2\172\1\144\1\151\1\172\1\155\1\172\1\164\3\172\1\143"+
        "\2\154\3\172\1\157\1\164\1\163\1\172\1\154\2\172\1\164\1\146\2\172"+
        "\1\162\1\172\1\171\1\172\1\156\2\172\1\160\1\144\1\172\1\155\1\172"+
        "\1\141\1\172\1\162\4\uffff\1\0\1\42\12\uffff\1\124\1\uffff\1\uffff"+
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
    static final String DFA30_acceptS =
        "\20\uffff\1\33\1\34\2\uffff\1\37\1\40\1\41\1\42\1\uffff\1\44\3\uffff"+
        "\1\47\21\uffff\1\54\1\61\1\62\1\63\3\uffff\1\54\1\55\55\uffff\1"+
        "\33\1\34\1\51\1\35\2\uffff\1\57\1\60\1\37\1\40\1\41\1\42\1\43\2"+
        "\47\1\44\1\uffff\1\46\1\uffff\1\56\1\52\1\53\1\61\62\uffff\1\36"+
        "\3\uffff\1\51\26\uffff\1\27\16\uffff\1\23\36\uffff\1\26\14\uffff"+
        "\1\22\1\24\4\uffff\1\45\27\uffff\1\10\21\uffff\1\1\4\uffff\1\3\1"+
        "\31\1\4\55\uffff\1\15\7\uffff\1\32\41\uffff\1\5\6\uffff\1\7\1\11"+
        "\4\uffff\1\21\10\uffff\1\20\4\uffff\1\13\1\14\1\16\2\uffff\1\30"+
        "\4\uffff\1\6\12\uffff\1\25\1\uffff\1\2\1\17\1\12\4\uffff\1\50\1"+
        "\uffff";
    static final String DFA30_specialS =
        "\1\1\22\uffff\1\4\4\uffff\1\6\120\uffff\1\3\1\0\14\uffff\1\10\70"+
        "\uffff\1\2\u011a\uffff\1\5\1\uffff\1\7}>";
    static final String[] DFA30_transitionS = {
            "\11\62\1\60\1\61\2\62\1\61\22\62\1\60\1\62\1\22\1\36\1\34\1"+
            "\62\1\40\1\62\1\26\1\27\2\62\1\20\1\62\1\21\14\62\1\23\1\62"+
            "\1\30\2\62\1\37\1\50\1\45\1\46\1\51\1\57\1\33\2\57\1\42\1\57"+
            "\1\52\1\53\1\54\1\55\1\57\1\47\1\57\1\44\1\57\1\32\1\43\1\56"+
            "\4\57\1\25\1\62\1\24\1\62\1\57\1\62\1\7\1\4\1\5\1\10\1\41\1"+
            "\11\2\41\1\1\1\41\1\12\1\13\1\14\1\15\1\41\1\6\1\41\1\3\1\41"+
            "\1\16\1\2\1\17\4\41\1\62\1\31\uff83\62",
            "\1\67\30\uffff\1\71\6\uffff\1\70\22\uffff\6\65\1\64\6\65\1"+
            "\63\14\65",
            "\1\67\37\uffff\1\75\1\uffff\1\74\20\uffff\15\65\1\73\1\65\1"+
            "\72\12\65",
            "\1\67\26\uffff\1\77\33\uffff\4\65\1\76\25\65",
            "\1\67\22\uffff\1\101\37\uffff\1\100\31\65",
            "\1\67\22\uffff\1\105\3\uffff\1\106\11\uffff\1\107\21\uffff"+
            "\1\102\3\65\1\103\11\65\1\104\13\65",
            "\1\67\22\uffff\1\114\15\uffff\1\115\2\uffff\1\113\16\uffff"+
            "\1\111\15\65\1\112\2\65\1\110\10\65",
            "\1\67\35\uffff\1\117\24\uffff\13\65\1\116\16\65",
            "\1\67\22\uffff\1\122\3\uffff\1\123\33\uffff\1\120\3\65\1\121"+
            "\25\65",
            "\1\67\40\uffff\1\126\21\uffff\1\125\15\65\1\124\13\65",
            "\1\67\26\uffff\1\130\33\uffff\4\65\1\127\25\65",
            "\1\67\22\uffff\1\132\37\uffff\1\131\31\65",
            "\1\67\22\uffff\1\135\15\uffff\1\136\21\uffff\1\133\15\65\1"+
            "\134\13\65",
            "\1\67\46\uffff\1\140\13\uffff\24\65\1\137\5\65",
            "\1\67\43\uffff\1\142\16\uffff\21\65\1\141\10\65",
            "\1\67\32\uffff\1\144\27\uffff\10\65\1\143\21\65",
            "",
            "",
            "\1\147",
            "\11\154\1\152\1\uffff\2\154\1\uffff\22\154\1\152\1\154\1\153"+
            "\30\154\1\uffff\uffc4\154",
            "",
            "",
            "",
            "",
            "\12\162\1\uffff\2\162\1\uffff\36\162\1\163\16\162\1\163\37"+
            "\162\1\163\1\162\1\163\uffa2\162",
            "",
            "\1\142\37\uffff\1\142",
            "\1\126\37\uffff\1\126",
            "\22\166\1\165\7\166\4\uffff\1\166\1\uffff\32\166",
            "",
            "\1\167",
            "\32\171\4\uffff\1\171\1\uffff\32\171",
            "\32\172\4\uffff\1\172\1\uffff\32\172",
            "\1\67\62\uffff\32\65",
            "\1\71\6\uffff\1\70\30\uffff\1\71\6\uffff\1\70",
            "\1\75\1\uffff\1\74\35\uffff\1\75\1\uffff\1\74",
            "\1\77\37\uffff\1\77",
            "\1\101\37\uffff\1\101",
            "\1\105\3\uffff\1\106\11\uffff\1\107\21\uffff\1\105\3\uffff"+
            "\1\106\11\uffff\1\107",
            "\1\114\15\uffff\1\115\2\uffff\1\113\16\uffff\1\114\15\uffff"+
            "\1\115\2\uffff\1\113",
            "\1\117\37\uffff\1\117",
            "\1\122\3\uffff\1\123\33\uffff\1\122\3\uffff\1\123",
            "\1\130\37\uffff\1\130",
            "\1\132\37\uffff\1\132",
            "\1\135\15\uffff\1\136\21\uffff\1\135\15\uffff\1\136",
            "\1\140\37\uffff\1\140",
            "\1\144\37\uffff\1\144",
            "",
            "",
            "",
            "",
            "\1\67\44\uffff\1\175\15\uffff\22\65\1\174\7\65",
            "\1\67\37\uffff\1\177\22\uffff\15\65\1\176\14\65",
            "\1\67\62\uffff\32\65",
            "",
            "",
            "\1\175\37\uffff\1\175",
            "\1\177\37\uffff\1\177",
            "\1\67\25\uffff\1\u0081\34\uffff\3\65\1\u0080\26\65",
            "\1\67\32\uffff\1\u0083\27\uffff\10\65\1\u0082\21\65",
            "\1\u0081\37\uffff\1\u0081",
            "\1\u0083\37\uffff\1\u0083",
            "\1\67\36\uffff\1\u0085\23\uffff\14\65\1\u0084\15\65",
            "\1\u0085\37\uffff\1\u0085",
            "\1\67\45\uffff\1\u0087\14\uffff\23\65\1\u0086\6\65",
            "\1\u0087\37\uffff\1\u0087",
            "\1\67\24\uffff\1\u0089\35\uffff\2\65\1\u0088\27\65",
            "\1\67\35\uffff\1\u008b\24\uffff\13\65\1\u008a\16\65",
            "\1\67\35\uffff\1\u008d\24\uffff\13\65\1\u008c\16\65",
            "\1\u0089\37\uffff\1\u0089",
            "\1\u008b\37\uffff\1\u008b",
            "\1\u008d\37\uffff\1\u008d",
            "\1\67\40\uffff\1\u008f\21\uffff\16\65\1\u008e\13\65",
            "\1\67\45\uffff\1\u0091\14\uffff\23\65\1\u0090\6\65",
            "\1\67\44\uffff\1\u0093\15\uffff\22\65\1\u0092\7\65",
            "\1\u008f\37\uffff\1\u008f",
            "\1\u0091\37\uffff\1\u0091",
            "\1\u0093\37\uffff\1\u0093",
            "\1\67\32\uffff\1\u0096\2\uffff\1\u0097\24\uffff\10\65\1\u0094"+
            "\2\65\1\u0095\16\65",
            "\1\u0096\2\uffff\1\u0097\34\uffff\1\u0096\2\uffff\1\u0097",
            "\1\67\45\uffff\1\u0099\14\uffff\23\65\1\u0098\6\65",
            "\1\67\27\uffff\1\u009b\32\uffff\5\65\1\u009a\24\65",
            "\1\u0099\37\uffff\1\u0099",
            "\1\u009b\37\uffff\1\u009b",
            "\1\67\43\uffff\1\u009d\16\uffff\21\65\1\u009c\10\65",
            "\1\67\62\uffff\13\65\1\u009e\16\65",
            "\1\u009d\37\uffff\1\u009d",
            "\1\67\52\uffff\1\u00a0\7\uffff\30\65\1\u009f\1\65",
            "\1\u00a0\37\uffff\1\u00a0",
            "\1\67\37\uffff\1\u00a2\22\uffff\15\65\1\u00a1\14\65",
            "\1\u00a2\37\uffff\1\u00a2",
            "\1\67\41\uffff\1\u00a4\20\uffff\17\65\1\u00a3\12\65",
            "\1\67\25\uffff\1\u00a6\34\uffff\3\65\1\u00a5\26\65",
            "\1\u00a4\37\uffff\1\u00a4",
            "\1\u00a6\37\uffff\1\u00a6",
            "\1\67\36\uffff\1\u00a8\23\uffff\14\65\1\u00a7\15\65",
            "\1\u00a8\37\uffff\1\u00a8",
            "\1\67\22\uffff\1\u00ab\37\uffff\1\u00a9\23\65\1\u00aa\5\65",
            "\1\u00ab\37\uffff\1\u00ab",
            "\1\67\43\uffff\1\u00ad\16\uffff\21\65\1\u00ac\10\65",
            "\1\u00ad\37\uffff\1\u00ad",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\152\26\uffff\1\152\1\uffff\1\153",
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
            "\1\u00af",
            "",
            "\12\u00b0\1\u00b2\2\u00b0\1\u00b1\ufff2\u00b0",
            "",
            "",
            "",
            "",
            "\1\67\26\uffff\1\u00b4\33\uffff\4\65\1\u00b3\25\65",
            "\1\u00b4\37\uffff\1\u00b4",
            "\1\67\40\uffff\1\u00b6\21\uffff\16\65\1\u00b5\13\65",
            "\1\u00b6\37\uffff\1\u00b6",
            "\1\67\22\uffff\1\u00b8\37\uffff\1\u00b7\31\65",
            "\1\u00b8\37\uffff\1\u00b8",
            "\1\67\42\uffff\1\u00ba\17\uffff\20\65\1\u00b9\11\65",
            "\1\u00ba\37\uffff\1\u00ba",
            "\1\67\40\uffff\1\u00bc\21\uffff\16\65\1\u00bb\13\65",
            "\1\u00bc\37\uffff\1\u00bc",
            "\1\67\24\uffff\1\u00be\35\uffff\2\65\1\u00bd\27\65",
            "\1\u00be\37\uffff\1\u00be",
            "\1\67\31\uffff\1\u00c0\30\uffff\7\65\1\u00bf\22\65",
            "\1\u00c0\37\uffff\1\u00c0",
            "\1\67\35\uffff\1\u00c2\24\uffff\13\65\1\u00c1\16\65",
            "\1\u00c2\37\uffff\1\u00c2",
            "\1\67\35\uffff\1\u00c4\24\uffff\13\65\1\u00c3\16\65",
            "\1\u00c4\37\uffff\1\u00c4",
            "\1\67\24\uffff\1\u00c6\35\uffff\2\65\1\u00c5\27\65",
            "\1\u00c6\37\uffff\1\u00c6",
            "\1\67\31\uffff\1\u00c8\30\uffff\7\65\1\u00c7\22\65",
            "\1\u00c8\37\uffff\1\u00c8",
            "\1\67\1\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\65",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\67\22\uffff\1\u00cb\37\uffff\1\u00ca\31\65",
            "\1\67\40\uffff\1\u00cd\21\uffff\16\65\1\u00cc\13\65",
            "\1\u00cb\37\uffff\1\u00cb",
            "\1\u00cd\37\uffff\1\u00cd",
            "\1\67\26\uffff\1\u00cf\33\uffff\4\65\1\u00ce\25\65",
            "\1\u00cf\37\uffff\1\u00cf",
            "\1\67\22\uffff\1\u00d1\37\uffff\1\u00d0\31\65",
            "\1\u00d1\37\uffff\1\u00d1",
            "\1\67\24\uffff\1\u00d3\35\uffff\2\65\1\u00d2\27\65",
            "\1\u00d3\37\uffff\1\u00d3",
            "\1\67\62\uffff\22\65\1\u00d4\7\65",
            "\1\67\3\uffff\1\u00d5\56\uffff\32\65",
            "\1\u00d5",
            "\1\67\30\uffff\1\u00d7\31\uffff\6\65\1\u00d6\23\65",
            "\1\u00d7\37\uffff\1\u00d7",
            "\1\u00d8\1\67\62\uffff\32\65",
            "\1\u00d8",
            "\1\67\26\uffff\1\u00da\33\uffff\4\65\1\u00d9\25\65",
            "\1\u00da\37\uffff\1\u00da",
            "\1\67\23\uffff\1\u00dc\36\uffff\1\65\1\u00db\30\65",
            "\1\u00dc\37\uffff\1\u00dc",
            "\1\67\37\uffff\1\u00de\22\uffff\15\65\1\u00dd\14\65",
            "\1\67\62\uffff\4\65\1\u00df\25\65",
            "\1\u00de\37\uffff\1\u00de",
            "\1\67\45\uffff\1\u00e1\14\uffff\23\65\1\u00e0\6\65",
            "\1\u00e1\37\uffff\1\u00e1",
            "",
            "\1\u00e2",
            "\12\u00b0\1\u00b2\2\u00b0\1\u00b1\ufff2\u00b0",
            "\1\u00b2",
            "",
            "\1\67\43\uffff\1\u00e4\16\uffff\21\65\1\u00e3\10\65",
            "\1\u00e4\37\uffff\1\u00e4",
            "\1\67\43\uffff\1\u00e6\16\uffff\21\65\1\u00e5\10\65",
            "\1\u00e6\37\uffff\1\u00e6",
            "\1\67\45\uffff\1\u00e8\14\uffff\23\65\1\u00e7\6\65",
            "\1\u00e8\37\uffff\1\u00e8",
            "\1\67\46\uffff\1\u00ea\13\uffff\24\65\1\u00e9\5\65",
            "\1\u00ea\37\uffff\1\u00ea",
            "\1\67\47\uffff\1\u00ec\12\uffff\25\65\1\u00eb\4\65",
            "\1\u00ec\37\uffff\1\u00ec",
            "\1\67\31\uffff\1\u00ee\30\uffff\7\65\1\u00ed\22\65",
            "\1\u00ee\37\uffff\1\u00ee",
            "\1\67\26\uffff\1\u00f0\33\uffff\4\65\1\u00ef\25\65",
            "\1\u00f0\37\uffff\1\u00f0",
            "\1\67\25\uffff\1\u00f2\34\uffff\3\65\1\u00f1\26\65",
            "\1\u00f2\37\uffff\1\u00f2",
            "\1\67\26\uffff\1\u00f4\33\uffff\4\65\1\u00f3\25\65",
            "\1\u00f4\37\uffff\1\u00f4",
            "\1\67\26\uffff\1\u00f6\33\uffff\4\65\1\u00f5\25\65",
            "\1\u00f6\37\uffff\1\u00f6",
            "\1\u00f7\1\67\62\uffff\32\65",
            "\1\u00f7",
            "",
            "\1\67\44\uffff\1\u00f9\15\uffff\22\65\1\u00f8\7\65",
            "\1\u00f9\37\uffff\1\u00f9",
            "\1\67\50\uffff\1\u00fb\11\uffff\26\65\1\u00fa\3\65",
            "\1\u00fb\37\uffff\1\u00fb",
            "\1\67\27\uffff\1\u00fd\32\uffff\5\65\1\u00fc\24\65",
            "\1\u00fd\37\uffff\1\u00fd",
            "\1\67\46\uffff\1\u00ff\13\uffff\24\65\1\u00fe\5\65",
            "\1\u00ff\37\uffff\1\u00ff",
            "\1\67\26\uffff\1\u0101\33\uffff\4\65\1\u0100\25\65",
            "\1\u0101\37\uffff\1\u0101",
            "\1\67\62\uffff\4\65\1\u0102\25\65",
            "\1\u0103\37\uffff\1\u0103",
            "\1\67\1\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\65",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\67\1\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\65",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\67\26\uffff\1\u0107\33\uffff\4\65\1\u0106\25\65",
            "\1\u0107\37\uffff\1\u0107",
            "\1\67\44\uffff\1\u0109\15\uffff\22\65\1\u0108\7\65",
            "\1\u0109\37\uffff\1\u0109",
            "\1\67\1\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\65",
            "\1\67\46\uffff\1\u010c\13\uffff\24\65\1\u010b\5\65",
            "\1\u010c\37\uffff\1\u010c",
            "\1\u010d",
            "\1\67\45\uffff\1\u010f\14\uffff\23\65\1\u010e\6\65",
            "\1\u010f\37\uffff\1\u010f",
            "\1\67\26\uffff\1\u0111\33\uffff\4\65\1\u0110\25\65",
            "\1\u0111\37\uffff\1\u0111",
            "\1\67\26\uffff\1\u0113\33\uffff\4\65\1\u0112\25\65",
            "\1\u0113\37\uffff\1\u0113",
            "\1\67\26\uffff\1\u0115\33\uffff\4\65\1\u0114\25\65",
            "\1\u0115\37\uffff\1\u0115",
            "\1\67\26\uffff\1\u0117\33\uffff\4\65\1\u0116\25\65",
            "\1\u0117\37\uffff\1\u0117",
            "\1\67\36\uffff\1\u0119\23\uffff\14\65\1\u0118\15\65",
            "\1\u0119\37\uffff\1\u0119",
            "\1\67\46\uffff\1\u011b\13\uffff\24\65\1\u011a\5\65",
            "\1\u011b\37\uffff\1\u011b",
            "\1\67\26\uffff\1\u011d\33\uffff\4\65\1\u011c\25\65",
            "\1\u011d\37\uffff\1\u011d",
            "\1\67\24\uffff\1\u011f\35\uffff\2\65\1\u011e\27\65",
            "\1\u011f\37\uffff\1\u011f",
            "\1\67\44\uffff\1\u0121\15\uffff\22\65\1\u0120\7\65",
            "\1\u0121\37\uffff\1\u0121",
            "",
            "\1\67\1\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\65",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\67\37\uffff\1\u0124\22\uffff\15\65\1\u0123\14\65",
            "\1\u0124\37\uffff\1\u0124",
            "\1\67\40\uffff\1\u0126\21\uffff\16\65\1\u0125\13\65",
            "\1\u0126\37\uffff\1\u0126",
            "\1\67\35\uffff\1\u0128\24\uffff\13\65\1\u0127\16\65",
            "\1\u0128\37\uffff\1\u0128",
            "\1\67\50\uffff\1\u012a\11\uffff\26\65\1\u0129\3\65",
            "\1\u012a\37\uffff\1\u012a",
            "\1\67\1\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\65",
            "\1\u012b\37\uffff\1\u012b",
            "",
            "",
            "\1\67\43\uffff\1\u012d\16\uffff\21\65\1\u012c\10\65",
            "\1\u012d\37\uffff\1\u012d",
            "\1\67\35\uffff\1\u012f\24\uffff\13\65\1\u012e\16\65",
            "\1\u012f\37\uffff\1\u012f",
            "",
            "\1\67\22\uffff\1\u0131\37\uffff\1\u0130\31\65",
            "\1\u0131\37\uffff\1\u0131",
            "\1\u0132",
            "\1\67\1\uffff\12\66\7\uffff\32\66\4\uffff\1\u0133\1\uffff\32"+
            "\65",
            "\12\66\7\uffff\32\66\4\uffff\1\u0133\1\uffff\32\66",
            "\1\67\34\uffff\1\u0137\2\uffff\1\u0138\22\uffff\12\65\1\u0135"+
            "\2\65\1\u0136\14\65",
            "\1\u0137\2\uffff\1\u0138\34\uffff\1\u0137\2\uffff\1\u0138",
            "\1\67\1\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\65",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\67\1\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\65",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\67\1\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\65",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\67\40\uffff\1\u013d\21\uffff\16\65\1\u013c\13\65",
            "\1\u013d\37\uffff\1\u013d",
            "\1\67\37\uffff\1\u013f\22\uffff\15\65\1\u013e\14\65",
            "\1\u013f\37\uffff\1\u013f",
            "\1\67\24\uffff\1\u0141\35\uffff\2\65\1\u0140\27\65",
            "\1\u0141\37\uffff\1\u0141",
            "\1\67\45\uffff\1\u0143\14\uffff\23\65\1\u0142\6\65",
            "\1\u0143\37\uffff\1\u0143",
            "\1\67\44\uffff\1\u0145\15\uffff\22\65\1\u0144\7\65",
            "\1\u0145\37\uffff\1\u0145",
            "",
            "\1\67\46\uffff\1\u0147\13\uffff\24\65\1\u0146\5\65",
            "\1\u0147\37\uffff\1\u0147",
            "\1\67\43\uffff\1\u0149\16\uffff\21\65\1\u0148\10\65",
            "\1\u0149\37\uffff\1\u0149",
            "\1\67\45\uffff\1\u014b\14\uffff\23\65\1\u014a\6\65",
            "\1\u014b\37\uffff\1\u014b",
            "\1\67\43\uffff\1\u014d\16\uffff\21\65\1\u014c\10\65",
            "\1\u014d\37\uffff\1\u014d",
            "\1\u014e\37\uffff\1\u014e",
            "\1\67\27\uffff\1\u0150\32\uffff\5\65\1\u014f\24\65",
            "\1\u0150\37\uffff\1\u0150",
            "\1\67\22\uffff\1\u0152\37\uffff\1\u0151\31\65",
            "\1\u0152\37\uffff\1\u0152",
            "\1\67\35\uffff\1\u0154\24\uffff\13\65\1\u0153\16\65",
            "\1\u0154\37\uffff\1\u0154",
            "\1\u0155",
            "\1\u0156\37\uffff\1\u0156",
            "",
            "\1\67\26\uffff\1\u0158\33\uffff\4\65\1\u0157\25\65",
            "\1\67\46\uffff\1\u015a\13\uffff\24\65\1\u0159\5\65",
            "\1\u0158\37\uffff\1\u0158",
            "\1\u015a\37\uffff\1\u015a",
            "",
            "",
            "",
            "\1\67\25\uffff\1\u015c\34\uffff\3\65\1\u015b\26\65",
            "\1\u015c\37\uffff\1\u015c",
            "\1\67\32\uffff\1\u015e\27\uffff\10\65\1\u015d\21\65",
            "\1\u015e\37\uffff\1\u015e",
            "\1\67\40\uffff\1\u0160\21\uffff\16\65\1\u015f\13\65",
            "\1\u0160\37\uffff\1\u0160",
            "\1\67\32\uffff\1\u0162\27\uffff\10\65\1\u0161\21\65",
            "\1\u0162\37\uffff\1\u0162",
            "\1\67\40\uffff\1\u0164\21\uffff\16\65\1\u0163\13\65",
            "\1\u0164\37\uffff\1\u0164",
            "\1\67\35\uffff\1\u0166\24\uffff\13\65\1\u0165\16\65",
            "\1\u0166\37\uffff\1\u0166",
            "\1\67\36\uffff\1\u0168\23\uffff\14\65\1\u0167\15\65",
            "\1\u0168\37\uffff\1\u0168",
            "\1\67\1\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\65",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\67\32\uffff\1\u016b\27\uffff\10\65\1\u016a\21\65",
            "\1\u016b\37\uffff\1\u016b",
            "\1\u016c\37\uffff\1\u016c",
            "\1\67\40\uffff\1\u016e\21\uffff\16\65\1\u016d\13\65",
            "\1\u016e\37\uffff\1\u016e",
            "\1\67\45\uffff\1\u0170\14\uffff\23\65\1\u016f\6\65",
            "\1\u0170\37\uffff\1\u0170",
            "\1\67\1\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\65",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u0172",
            "\1\u0173\37\uffff\1\u0173",
            "\1\67\52\uffff\1\u0175\7\uffff\30\65\1\u0174\1\65",
            "\1\u0175\37\uffff\1\u0175",
            "\1\67\35\uffff\1\u0177\24\uffff\13\65\1\u0176\16\65",
            "\1\u0177\37\uffff\1\u0177",
            "\1\67\26\uffff\1\u0179\33\uffff\4\65\1\u0178\25\65",
            "\1\u0179\37\uffff\1\u0179",
            "\1\67\42\uffff\1\u017b\17\uffff\20\65\1\u017a\11\65",
            "\1\u017b\37\uffff\1\u017b",
            "\1\67\43\uffff\1\u017d\16\uffff\21\65\1\u017c\10\65",
            "\1\u017d\37\uffff\1\u017d",
            "\1\67\40\uffff\1\u017f\21\uffff\16\65\1\u017e\13\65",
            "\1\u017f\37\uffff\1\u017f",
            "\1\67\43\uffff\1\u0181\16\uffff\21\65\1\u0180\10\65",
            "\1\u0181\37\uffff\1\u0181",
            "\1\67\35\uffff\1\u0183\24\uffff\13\65\1\u0182\16\65",
            "\1\u0183\37\uffff\1\u0183",
            "\1\67\22\uffff\1\u0185\37\uffff\1\u0184\31\65",
            "\1\u0185\37\uffff\1\u0185",
            "",
            "\1\67\45\uffff\1\u0187\14\uffff\23\65\1\u0186\6\65",
            "\1\u0187\37\uffff\1\u0187",
            "\1\u0188\37\uffff\1\u0188",
            "\1\67\43\uffff\1\u018a\16\uffff\21\65\1\u0189\10\65",
            "\1\u018a\37\uffff\1\u018a",
            "\1\67\40\uffff\1\u018c\21\uffff\16\65\1\u018b\13\65",
            "\1\u018c\37\uffff\1\u018c",
            "",
            "\1\u018d",
            "\1\u018e\37\uffff\1\u018e",
            "\1\67\24\uffff\1\u0190\35\uffff\2\65\1\u018f\27\65",
            "\1\u0190\37\uffff\1\u0190",
            "\1\67\35\uffff\1\u0192\24\uffff\13\65\1\u0191\16\65",
            "\1\u0192\37\uffff\1\u0192",
            "\1\67\1\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\65",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\67\46\uffff\1\u0195\13\uffff\24\65\1\u0194\5\65",
            "\1\u0195\37\uffff\1\u0195",
            "\1\67\22\uffff\1\u0197\37\uffff\1\u0196\31\65",
            "\1\u0197\37\uffff\1\u0197",
            "\1\67\37\uffff\1\u0199\22\uffff\15\65\1\u0198\14\65",
            "\1\u0199\37\uffff\1\u0199",
            "\1\67\1\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\65",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\67\1\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\65",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\67\45\uffff\1\u019d\14\uffff\23\65\1\u019c\6\65",
            "\1\u019d\37\uffff\1\u019d",
            "\1\67\26\uffff\1\u019f\33\uffff\4\65\1\u019e\25\65",
            "\1\u019f\37\uffff\1\u019f",
            "\1\u01a0",
            "\1\67\36\uffff\1\u01a2\23\uffff\14\65\1\u01a1\15\65",
            "\1\u01a2\37\uffff\1\u01a2",
            "\1\67\43\uffff\1\u01a4\16\uffff\21\65\1\u01a3\10\65",
            "\1\u01a4\37\uffff\1\u01a4",
            "\1\u01a5",
            "\1\u01a6\37\uffff\1\u01a6",
            "\1\67\22\uffff\1\u01a8\37\uffff\1\u01a7\31\65",
            "\1\u01a8\37\uffff\1\u01a8",
            "\1\67\1\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\65",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\67\26\uffff\1\u01ab\33\uffff\4\65\1\u01aa\25\65",
            "\1\u01ab\37\uffff\1\u01ab",
            "\1\67\45\uffff\1\u01ad\14\uffff\23\65\1\u01ac\6\65",
            "\1\u01ad\37\uffff\1\u01ad",
            "\1\u01ae\1\67\62\uffff\32\65",
            "\1\u01ae",
            "",
            "",
            "\1\67\1\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\65",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\67\1\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\65",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\67\22\uffff\1\u01b2\37\uffff\1\u01b1\31\65",
            "\1\u01b2\37\uffff\1\u01b2",
            "\1\67\1\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\65",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u01b4",
            "\1\u01b5\37\uffff\1\u01b5",
            "\1\67\44\uffff\1\u01b7\15\uffff\22\65\1\u01b6\7\65",
            "\1\u01b7\37\uffff\1\u01b7",
            "",
            "\1\67\1\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\65",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\67\40\uffff\1\u01ba\21\uffff\16\65\1\u01b9\13\65",
            "\1\u01ba\37\uffff\1\u01ba",
            "",
            "",
            "",
            "\1\67\45\uffff\1\u01bc\14\uffff\23\65\1\u01bb\6\65",
            "\1\u01bc\37\uffff\1\u01bc",
            "",
            "\1\u01bd",
            "\1\u01be\37\uffff\1\u01be",
            "\1\67\26\uffff\1\u01c0\33\uffff\4\65\1\u01bf\25\65",
            "\1\u01c0\37\uffff\1\u01c0",
            "",
            "\1\67\43\uffff\1\u01c2\16\uffff\21\65\1\u01c1\10\65",
            "\1\u01c2\37\uffff\1\u01c2",
            "\1\67\1\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\65",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\u01c4",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\67\1\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\65",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\67\1\uffff\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\65",
            "\12\66\7\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\u01c8",
            "",
            "",
            "",
            "\1\u01c9",
            "\1\u01ca",
            "\1\u01cb",
            "\60\u01cc\12\u01cd\7\u01cc\32\u01cd\4\u01cc\1\u01cd\1\u01cc"+
            "\32\u01cd\uff85\u01cc",
            "",
            "\60\u01cc\12\u01cd\7\u01cc\32\u01cd\4\u01cc\1\u01cd\1\u01cc"+
            "\32\u01cd\uff85\u01cc"
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
            return "1:1: Tokens : ( Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual | Comma | Dot | DoubleQuote | Semicolon | RBracket | LBracket | LParenthesis | RParenthesis | Equals | Or | Bool | Macrodef | ValueAssignment | UserRights | BeanShell | SpecialAttribute | DocumentID | Identifier | Classname | Comment | QuotedField | Field | Ws | Lb | Char );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA30_106 = input.LA(1);

                         
                        int index30_106 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA30_106=='\"') && ((isHeader() == false))) {s = 107;}

                        else if ( (LA30_106=='\t'||LA30_106==' ') && ((isHeader() == false))) {s = 106;}

                        else s = 108;

                         
                        input.seek(index30_106);

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA30_0 = input.LA(1);

                        s = -1;
                        if ( (LA30_0=='i') ) {s = 1;}

                        else if ( (LA30_0=='u') ) {s = 2;}

                        else if ( (LA30_0=='r') ) {s = 3;}

                        else if ( (LA30_0=='b') ) {s = 4;}

                        else if ( (LA30_0=='c') ) {s = 5;}

                        else if ( (LA30_0=='p') ) {s = 6;}

                        else if ( (LA30_0=='a') ) {s = 7;}

                        else if ( (LA30_0=='d') ) {s = 8;}

                        else if ( (LA30_0=='f') ) {s = 9;}

                        else if ( (LA30_0=='k') ) {s = 10;}

                        else if ( (LA30_0=='l') ) {s = 11;}

                        else if ( (LA30_0=='m') ) {s = 12;}

                        else if ( (LA30_0=='n') ) {s = 13;}

                        else if ( (LA30_0=='t') ) {s = 14;}

                        else if ( (LA30_0=='v') ) {s = 15;}

                        else if ( (LA30_0==',') ) {s = 16;}

                        else if ( (LA30_0=='.') ) {s = 17;}

                        else if ( (LA30_0=='\"') ) {s = 18;}

                        else if ( (LA30_0==';') ) {s = 19;}

                        else if ( (LA30_0==']') ) {s = 20;}

                        else if ( (LA30_0=='[') ) {s = 21;}

                        else if ( (LA30_0=='(') ) {s = 22;}

                        else if ( (LA30_0==')') ) {s = 23;}

                        else if ( (LA30_0=='=') ) {s = 24;}

                        else if ( (LA30_0=='|') ) {s = 25;}

                        else if ( (LA30_0=='T') ) {s = 26;}

                        else if ( (LA30_0=='F') ) {s = 27;}

                        else if ( (LA30_0=='$') ) {s = 28;}

                        else if ( (LA30_0=='#') ) {s = 30;}

                        else if ( (LA30_0=='@') ) {s = 31;}

                        else if ( (LA30_0=='&') ) {s = 32;}

                        else if ( (LA30_0=='e'||(LA30_0 >= 'g' && LA30_0 <= 'h')||LA30_0=='j'||LA30_0=='o'||LA30_0=='q'||LA30_0=='s'||(LA30_0 >= 'w' && LA30_0 <= 'z')) ) {s = 33;}

                        else if ( (LA30_0=='I') ) {s = 34;}

                        else if ( (LA30_0=='U') ) {s = 35;}

                        else if ( (LA30_0=='R') ) {s = 36;}

                        else if ( (LA30_0=='B') ) {s = 37;}

                        else if ( (LA30_0=='C') ) {s = 38;}

                        else if ( (LA30_0=='P') ) {s = 39;}

                        else if ( (LA30_0=='A') ) {s = 40;}

                        else if ( (LA30_0=='D') ) {s = 41;}

                        else if ( (LA30_0=='K') ) {s = 42;}

                        else if ( (LA30_0=='L') ) {s = 43;}

                        else if ( (LA30_0=='M') ) {s = 44;}

                        else if ( (LA30_0=='N') ) {s = 45;}

                        else if ( (LA30_0=='V') ) {s = 46;}

                        else if ( (LA30_0=='E'||(LA30_0 >= 'G' && LA30_0 <= 'H')||LA30_0=='J'||LA30_0=='O'||LA30_0=='Q'||LA30_0=='S'||(LA30_0 >= 'W' && LA30_0 <= 'Z')||LA30_0=='_') ) {s = 47;}

                        else if ( (LA30_0=='\t'||LA30_0==' ') ) {s = 48;}

                        else if ( (LA30_0=='\n'||LA30_0=='\r') ) {s = 49;}

                        else if ( ((LA30_0 >= '\u0000' && LA30_0 <= '\b')||(LA30_0 >= '\u000B' && LA30_0 <= '\f')||(LA30_0 >= '\u000E' && LA30_0 <= '\u001F')||LA30_0=='!'||LA30_0=='%'||LA30_0=='\''||(LA30_0 >= '*' && LA30_0 <= '+')||LA30_0=='-'||(LA30_0 >= '/' && LA30_0 <= ':')||LA30_0=='<'||(LA30_0 >= '>' && LA30_0 <= '?')||LA30_0=='\\'||LA30_0=='^'||LA30_0=='`'||LA30_0=='{'||(LA30_0 >= '}' && LA30_0 <= '\uFFFF')) ) {s = 50;}

                        else s = 29;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA30_176 = input.LA(1);

                        s = -1;
                        if ( (LA30_176=='\r') ) {s = 177;}

                        else if ( (LA30_176=='\n') ) {s = 178;}

                        else if ( ((LA30_176 >= '\u0000' && LA30_176 <= '\t')||(LA30_176 >= '\u000B' && LA30_176 <= '\f')||(LA30_176 >= '\u000E' && LA30_176 <= '\uFFFF')) ) {s = 176;}

                        else s = 103;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA30_105 = input.LA(1);

                         
                        int index30_105 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((isHeader() == false)))) ) {s = 174;}

                        else if ( ((isHeader() == false)) ) {s = 108;}

                         
                        input.seek(index30_105);

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA30_19 = input.LA(1);

                         
                        int index30_19 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA30_19=='\t'||LA30_19==' ') && ((isHeader() == false))) {s = 106;}

                        else if ( (LA30_19=='\"') && ((isHeader() == false))) {s = 107;}

                        else if ( ((LA30_19 >= '\u0000' && LA30_19 <= '\b')||(LA30_19 >= '\u000B' && LA30_19 <= '\f')||(LA30_19 >= '\u000E' && LA30_19 <= '\u001F')||LA30_19=='!'||(LA30_19 >= '#' && LA30_19 <= ':')||(LA30_19 >= '<' && LA30_19 <= '\uFFFF')) && ((isHeader() == false))) {s = 108;}

                        else s = 105;

                         
                        input.seek(index30_19);

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA30_459 = input.LA(1);

                        s = -1;
                        if ( ((LA30_459 >= '\u0000' && LA30_459 <= '/')||(LA30_459 >= ':' && LA30_459 <= '@')||(LA30_459 >= '[' && LA30_459 <= '^')||LA30_459=='`'||(LA30_459 >= '{' && LA30_459 <= '\uFFFF')) ) {s = 460;}

                        else if ( ((LA30_459 >= '0' && LA30_459 <= '9')||(LA30_459 >= 'A' && LA30_459 <= 'Z')||LA30_459=='_'||(LA30_459 >= 'a' && LA30_459 <= 'z')) ) {s = 461;}

                        else s = 118;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA30_24 = input.LA(1);

                         
                        int index30_24 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA30_24 >= '\u0000' && LA30_24 <= '\t')||(LA30_24 >= '\u000B' && LA30_24 <= '\f')||(LA30_24 >= '\u000E' && LA30_24 <= '+')||(LA30_24 >= '-' && LA30_24 <= ':')||(LA30_24 >= '<' && LA30_24 <= 'Z')||LA30_24=='\\'||(LA30_24 >= '^' && LA30_24 <= '\uFFFF')) && (((isArgumentModifierAssignment())||(isMacroAssignment())))) {s = 114;}

                        else if ( (LA30_24==','||LA30_24==';'||LA30_24=='['||LA30_24==']') && ((isMacroAssignment()))) {s = 115;}

                        else s = 113;

                         
                        input.seek(index30_24);

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA30_461 = input.LA(1);

                        s = -1;
                        if ( ((LA30_461 >= '\u0000' && LA30_461 <= '/')||(LA30_461 >= ':' && LA30_461 <= '@')||(LA30_461 >= '[' && LA30_461 <= '^')||LA30_461=='`'||(LA30_461 >= '{' && LA30_461 <= '\uFFFF')) ) {s = 460;}

                        else if ( ((LA30_461 >= '0' && LA30_461 <= '9')||(LA30_461 >= 'A' && LA30_461 <= 'Z')||LA30_461=='_'||(LA30_461 >= 'a' && LA30_461 <= 'z')) ) {s = 461;}

                        else s = 118;

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA30_119 = input.LA(1);

                        s = -1;
                        if ( ((LA30_119 >= '\u0000' && LA30_119 <= '\t')||(LA30_119 >= '\u000B' && LA30_119 <= '\f')||(LA30_119 >= '\u000E' && LA30_119 <= '\uFFFF')) ) {s = 176;}

                        else if ( (LA30_119=='\r') ) {s = 177;}

                        else if ( (LA30_119=='\n') ) {s = 178;}

                        else s = 103;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 30, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}