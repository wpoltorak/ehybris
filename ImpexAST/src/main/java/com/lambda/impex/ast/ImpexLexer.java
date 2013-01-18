// $ANTLR 3.4 com/lambda/impex/ast/Impex.g 2013-01-17 12:30:37

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
    public static final int Quote=56;
    public static final int QuotedField=57;
    public static final int RBracket=58;
    public static final int RECORD=59;
    public static final int RECORDS=60;
    public static final int RParenthesis=61;
    public static final int Remove=62;
    public static final int SUBTYPE=63;
    public static final int Semicolon=64;
    public static final int Separator=65;
    public static final int SpecialAttribute=66;
    public static final int TYPE=67;
    public static final int Translator=68;
    public static final int Unique=69;
    public static final int Update=70;
    public static final int UserRights=71;
    public static final int ValueAssignment=72;
    public static final int Virtual=73;
    public static final int Ws=74;


    private Token lastToken;
    private boolean isHeader = false;
    private final Pattern lineSeparatorPattern = Pattern.compile("([ \t]*)\\\\([ \t]*)(\r?\n|\r)([ \t]*)");
    private ImpexContext context;

    public ImpexLexer(ImpexContext context, CharStream input) {
        this(input, new RecognizerSharedState());
        this.context = context;
    }

    @Override
    public void reportError(final RecognitionException e) {
        if ( state.errorRecovery ) {
            return;
        }
        context.registerError(e);
        super.reportError(e);
     }

      private void emit(String text, int type) {
        Token token = new CommonToken(type, text);
        token.setType(type);
        emit(token);
      }

     @Override
     public void emit(Token token) {
        if(token.getChannel() == Token.DEFAULT_CHANNEL) {
            lastToken = token;
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
            return lastToken != null && lastToken.getType() == Macrodef;
    }


    private boolean isModifierAssignment() {
        switch (lastToken.getType()) {
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
            case BatchMode:
            case CacheUnique:
            case Processor:
                return true;
        }
        return false;
    }

    private boolean isHeader(){
         return isHeader;
    }

    private String removeSeparators(final String text) {
        final Matcher m = lineSeparatorPattern.matcher(text);
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
            // com/lambda/impex/ast/Impex.g:365:9: ( ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' ) )
            // com/lambda/impex/ast/Impex.g:365:10: ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' )
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
            // com/lambda/impex/ast/Impex.g:366:15: ( ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' ) '_' ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // com/lambda/impex/ast/Impex.g:366:16: ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' ) '_' ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' )
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
            // com/lambda/impex/ast/Impex.g:367:9: ( ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // com/lambda/impex/ast/Impex.g:367:10: ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' )
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
            // com/lambda/impex/ast/Impex.g:368:9: ( ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'V' | 'v' ) ( 'E' | 'e' ) )
            // com/lambda/impex/ast/Impex.g:368:10: ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'V' | 'v' ) ( 'E' | 'e' )
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
            // com/lambda/impex/ast/Impex.g:370:12: ( ( 'B' | 'b' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'D' | 'd' ) ( 'E' | 'e' ) )
            // com/lambda/impex/ast/Impex.g:370:13: ( 'B' | 'b' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'D' | 'd' ) ( 'E' | 'e' )
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
            // com/lambda/impex/ast/Impex.g:371:14: ( ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'E' | 'e' ) ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // com/lambda/impex/ast/Impex.g:371:15: ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'E' | 'e' ) ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'E' | 'e' )
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
            // com/lambda/impex/ast/Impex.g:372:12: ( ( 'P' | 'p' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'S' | 's' ) ( 'O' | 'o' ) ( 'R' | 'r' ) )
            // com/lambda/impex/ast/Impex.g:372:13: ( 'P' | 'p' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'S' | 's' ) ( 'O' | 'o' ) ( 'R' | 'r' )
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
            // com/lambda/impex/ast/Impex.g:378:8: ( ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'A' | 'a' ) ( 'S' | 's' ) )
            // com/lambda/impex/ast/Impex.g:378:9: ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'A' | 'a' ) ( 'S' | 's' )
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
            // com/lambda/impex/ast/Impex.g:379:12: ( ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'W' | 'w' ) ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'L' | 'l' ) )
            // com/lambda/impex/ast/Impex.g:379:13: ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'W' | 'w' ) ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'L' | 'l' )
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
            // com/lambda/impex/ast/Impex.g:380:15: ( ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'O' | 'o' ) ( 'R' | 'r' ) )
            // com/lambda/impex/ast/Impex.g:380:16: ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'O' | 'o' ) ( 'R' | 'r' )
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
            // com/lambda/impex/ast/Impex.g:381:22: ( ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // com/lambda/impex/ast/Impex.g:381:23: ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' )
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
            // com/lambda/impex/ast/Impex.g:382:13: ( ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'T' | 't' ) )
            // com/lambda/impex/ast/Impex.g:382:14: ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'T' | 't' )
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
            // com/lambda/impex/ast/Impex.g:383:10: ( ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'A' | 'a' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'T' | 't' ) )
            // com/lambda/impex/ast/Impex.g:383:11: ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'A' | 'a' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'T' | 't' )
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
            // com/lambda/impex/ast/Impex.g:384:13: ( ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'W' | 'w' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // com/lambda/impex/ast/Impex.g:384:14: ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'W' | 'w' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' )
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
            // com/lambda/impex/ast/Impex.g:385:15: ( ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'N' | 'n' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'K' | 'k' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'E' | 'e' ) )
            // com/lambda/impex/ast/Impex.g:385:16: ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'N' | 'n' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'K' | 'k' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'E' | 'e' )
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
            // com/lambda/impex/ast/Impex.g:386:13: ( ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'N' | 'n' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'L' | 'l' ) )
            // com/lambda/impex/ast/Impex.g:386:14: ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'N' | 'n' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'L' | 'l' )
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
            // com/lambda/impex/ast/Impex.g:387:21: ( ( 'K' | 'k' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) '2' ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // com/lambda/impex/ast/Impex.g:387:22: ( 'K' | 'k' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) '2' ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' )
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
            // com/lambda/impex/ast/Impex.g:388:7: ( ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'G' | 'g' ) )
            // com/lambda/impex/ast/Impex.g:388:8: ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'G' | 'g' )
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
            // com/lambda/impex/ast/Impex.g:389:14: ( ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'P' | 'p' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // com/lambda/impex/ast/Impex.g:389:15: ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'P' | 'p' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' )
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
            // com/lambda/impex/ast/Impex.g:390:7: ( ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'D' | 'd' ) ( 'E' | 'e' ) )
            // com/lambda/impex/ast/Impex.g:390:8: ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'D' | 'd' ) ( 'E' | 'e' )
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
            // com/lambda/impex/ast/Impex.g:391:14: ( ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'B' | 'b' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'T' | 't' ) )
            // com/lambda/impex/ast/Impex.g:391:15: ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'B' | 'b' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'T' | 't' )
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
            // com/lambda/impex/ast/Impex.g:392:15: ( ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'H' | 'h' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // com/lambda/impex/ast/Impex.g:392:16: ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'H' | 'h' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' )
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
            // com/lambda/impex/ast/Impex.g:393:6: ( ( 'P' | 'p' ) ( 'O' | 'o' ) ( 'S' | 's' ) )
            // com/lambda/impex/ast/Impex.g:393:7: ( 'P' | 'p' ) ( 'O' | 'o' ) ( 'S' | 's' )
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
            // com/lambda/impex/ast/Impex.g:394:13: ( ( 'T' | 't' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'O' | 'o' ) ( 'R' | 'r' ) )
            // com/lambda/impex/ast/Impex.g:394:14: ( 'T' | 't' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'O' | 'o' ) ( 'R' | 'r' )
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
            // com/lambda/impex/ast/Impex.g:395:9: ( ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // com/lambda/impex/ast/Impex.g:395:10: ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'E' | 'e' )
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
            // com/lambda/impex/ast/Impex.g:396:10: ( ( 'V' | 'v' ) ( 'I' | 'i' ) ( 'R' | 'r' ) ( 'T' | 't' ) ( 'U' | 'u' ) ( 'A' | 'a' ) ( 'L' | 'l' ) )
            // com/lambda/impex/ast/Impex.g:396:11: ( 'V' | 'v' ) ( 'I' | 'i' ) ( 'R' | 'r' ) ( 'T' | 't' ) ( 'U' | 'u' ) ( 'A' | 'a' ) ( 'L' | 'l' )
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
            // com/lambda/impex/ast/Impex.g:420:8: ( ',' )
            // com/lambda/impex/ast/Impex.g:420:9: ','
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
            // com/lambda/impex/ast/Impex.g:421:5: ( '.' )
            // com/lambda/impex/ast/Impex.g:421:6: '.'
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
            // com/lambda/impex/ast/Impex.g:422:13: ( '\"' )
            // com/lambda/impex/ast/Impex.g:422:14: '\"'
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

    // $ANTLR start "Quote"
    public final void mQuote() throws RecognitionException {
        try {
            int _type = Quote;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/lambda/impex/ast/Impex.g:423:7: ( '\\'' )
            // com/lambda/impex/ast/Impex.g:423:8: '\\''
            {
            match('\''); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        	// do for sure before leaving
        }
    }
    // $ANTLR end "Quote"

    // $ANTLR start "Semicolon"
    public final void mSemicolon() throws RecognitionException {
        try {
            int _type = Semicolon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/lambda/impex/ast/Impex.g:424:11: ( ';' )
            // com/lambda/impex/ast/Impex.g:424:12: ';'
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
            // com/lambda/impex/ast/Impex.g:425:10: ( ']' )
            // com/lambda/impex/ast/Impex.g:425:11: ']'
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
            // com/lambda/impex/ast/Impex.g:426:10: ( '[' )
            // com/lambda/impex/ast/Impex.g:426:11: '['
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
            // com/lambda/impex/ast/Impex.g:427:15: ( '(' )
            // com/lambda/impex/ast/Impex.g:427:16: '('
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
            // com/lambda/impex/ast/Impex.g:428:14: ( ')' )
            // com/lambda/impex/ast/Impex.g:428:15: ')'
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
            // com/lambda/impex/ast/Impex.g:429:8: ( '=' )
            // com/lambda/impex/ast/Impex.g:429:9: '='
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
            // com/lambda/impex/ast/Impex.g:430:4: ( '|' )
            // com/lambda/impex/ast/Impex.g:430:5: '|'
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
            // com/lambda/impex/ast/Impex.g:433:2: ( 'true' | 'false' )
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
                    // com/lambda/impex/ast/Impex.g:433:3: 'true'
                    {
                    match("true"); 



                    }
                    break;
                case 2 :
                    // com/lambda/impex/ast/Impex.g:433:12: 'false'
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
            // com/lambda/impex/ast/Impex.g:446:2: ( '\\\\' ( Ws )* Lb )
            // com/lambda/impex/ast/Impex.g:446:3: '\\\\' ( Ws )* Lb
            {
            match('\\'); 

            // com/lambda/impex/ast/Impex.g:446:8: ( Ws )*
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
            	    // com/lambda/impex/ast/Impex.g:446:8: Ws
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
            // com/lambda/impex/ast/Impex.g:451:2: ( '$' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // com/lambda/impex/ast/Impex.g:451:3: '$' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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


            // com/lambda/impex/ast/Impex.g:451:39: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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
            // com/lambda/impex/ast/Impex.g:454:2: ({...}? => '=' (~ ( '\\r' | '\\n' ) | Separator )* |{...}? => '=' ( ( ' ' | '\\t' )* '\"' (~ ( '\\r' | '\\n' | '\"' ) | '\"' '\"' )* '\"' | (~ ( '\\r' | '\\n' | ';' | '\"' | '[' | ']' | ',' ) )* ) |)
            int alt9=3;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='=') && (((isModifierAssignment())||(isMacroAssignment())))) {
                int LA9_1 = input.LA(2);

                if ( ((isMacroAssignment())) ) {
                    alt9=1;
                }
                else if ( ((isModifierAssignment())) ) {
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
                    // com/lambda/impex/ast/Impex.g:454:3: {...}? => '=' (~ ( '\\r' | '\\n' ) | Separator )*
                    {
                    if ( !((isMacroAssignment())) ) {
                        throw new FailedPredicateException(input, "ValueAssignment", "isMacroAssignment()");
                    }

                    match('='); 

                    // com/lambda/impex/ast/Impex.g:454:34: (~ ( '\\r' | '\\n' ) | Separator )*
                    loop4:
                    do {
                        int alt4=3;
                        alt4 = dfa4.predict(input);
                        switch (alt4) {
                    	case 1 :
                    	    // com/lambda/impex/ast/Impex.g:454:35: ~ ( '\\r' | '\\n' )
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
                    	    // com/lambda/impex/ast/Impex.g:454:52: Separator
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
                    // com/lambda/impex/ast/Impex.g:455:3: {...}? => '=' ( ( ' ' | '\\t' )* '\"' (~ ( '\\r' | '\\n' | '\"' ) | '\"' '\"' )* '\"' | (~ ( '\\r' | '\\n' | ';' | '\"' | '[' | ']' | ',' ) )* )
                    {
                    if ( !((isModifierAssignment())) ) {
                        throw new FailedPredicateException(input, "ValueAssignment", "isModifierAssignment()");
                    }

                    match('='); 

                    // com/lambda/impex/ast/Impex.g:455:36: ( ( ' ' | '\\t' )* '\"' (~ ( '\\r' | '\\n' | '\"' ) | '\"' '\"' )* '\"' | (~ ( '\\r' | '\\n' | ';' | '\"' | '[' | ']' | ',' ) )* )
                    int alt8=2;
                    alt8 = dfa8.predict(input);
                    switch (alt8) {
                        case 1 :
                            // com/lambda/impex/ast/Impex.g:455:37: ( ' ' | '\\t' )* '\"' (~ ( '\\r' | '\\n' | '\"' ) | '\"' '\"' )* '\"'
                            {
                            // com/lambda/impex/ast/Impex.g:455:37: ( ' ' | '\\t' )*
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

                            // com/lambda/impex/ast/Impex.g:455:54: (~ ( '\\r' | '\\n' | '\"' ) | '\"' '\"' )*
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
                            	    // com/lambda/impex/ast/Impex.g:455:55: ~ ( '\\r' | '\\n' | '\"' )
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
                            	    // com/lambda/impex/ast/Impex.g:455:79: '\"' '\"'
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
                            // com/lambda/impex/ast/Impex.g:455:209: (~ ( '\\r' | '\\n' | ';' | '\"' | '[' | ']' | ',' ) )*
                            {
                            // com/lambda/impex/ast/Impex.g:455:209: (~ ( '\\r' | '\\n' | ';' | '\"' | '[' | ']' | ',' ) )*
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
                    // com/lambda/impex/ast/Impex.g:456:17: 
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
            // com/lambda/impex/ast/Impex.g:531:2: ( '$START_USERRIGHTS' ( . )* '$END_USERRIGHTS' ( Semicolon | Ws )* )
            // com/lambda/impex/ast/Impex.g:531:3: '$START_USERRIGHTS' ( . )* '$END_USERRIGHTS' ( Semicolon | Ws )*
            {
            match("$START_USERRIGHTS"); 



            // com/lambda/impex/ast/Impex.g:531:23: ( . )*
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
            	    // com/lambda/impex/ast/Impex.g:531:23: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            match("$END_USERRIGHTS"); 



            // com/lambda/impex/ast/Impex.g:531:44: ( Semicolon | Ws )*
            loop11:
            do {
                int alt11=3;
                switch ( input.LA(1) ) {
                case ';':
                    {
                    alt11=1;
                    }
                    break;
                case '\t':
                case ' ':
                    {
                    alt11=2;
                    }
                    break;

                }

                switch (alt11) {
            	case 1 :
            	    // com/lambda/impex/ast/Impex.g:531:45: Semicolon
            	    {
            	    mSemicolon(); 


            	    }
            	    break;
            	case 2 :
            	    // com/lambda/impex/ast/Impex.g:531:57: Ws
            	    {
            	    mWs(); 


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


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
            // com/lambda/impex/ast/Impex.g:534:2: ( ( ( '#%' (~ ( '\\r' | '\\n' ) )* | '\"#%' (~ ( '\"' ) | '\"' '\"' )* '\"' ) ( Lb )? ) )
            // com/lambda/impex/ast/Impex.g:534:3: ( ( '#%' (~ ( '\\r' | '\\n' ) )* | '\"#%' (~ ( '\"' ) | '\"' '\"' )* '\"' ) ( Lb )? )
            {
            // com/lambda/impex/ast/Impex.g:534:3: ( ( '#%' (~ ( '\\r' | '\\n' ) )* | '\"#%' (~ ( '\"' ) | '\"' '\"' )* '\"' ) ( Lb )? )
            // com/lambda/impex/ast/Impex.g:534:4: ( '#%' (~ ( '\\r' | '\\n' ) )* | '\"#%' (~ ( '\"' ) | '\"' '\"' )* '\"' ) ( Lb )?
            {
            // com/lambda/impex/ast/Impex.g:534:4: ( '#%' (~ ( '\\r' | '\\n' ) )* | '\"#%' (~ ( '\"' ) | '\"' '\"' )* '\"' )
            int alt14=2;
            switch ( input.LA(1) ) {
            case '#':
                {
                alt14=1;
                }
                break;
            case '\"':
                {
                alt14=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;

            }

            switch (alt14) {
                case 1 :
                    // com/lambda/impex/ast/Impex.g:534:5: '#%' (~ ( '\\r' | '\\n' ) )*
                    {
                    match("#%"); 



                    // com/lambda/impex/ast/Impex.g:534:10: (~ ( '\\r' | '\\n' ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0 >= '\u0000' && LA12_0 <= '\t')||(LA12_0 >= '\u000B' && LA12_0 <= '\f')||(LA12_0 >= '\u000E' && LA12_0 <= '\uFFFF')) ) {
                            alt12=1;
                        }


                        switch (alt12) {
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
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // com/lambda/impex/ast/Impex.g:534:28: '\"#%' (~ ( '\"' ) | '\"' '\"' )* '\"'
                    {
                    match("\"#%"); 



                    // com/lambda/impex/ast/Impex.g:534:34: (~ ( '\"' ) | '\"' '\"' )*
                    loop13:
                    do {
                        int alt13=3;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0=='\"') ) {
                            switch ( input.LA(2) ) {
                            case '\"':
                                {
                                alt13=2;
                                }
                                break;

                            }

                        }
                        else if ( ((LA13_0 >= '\u0000' && LA13_0 <= '!')||(LA13_0 >= '#' && LA13_0 <= '\uFFFF')) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // com/lambda/impex/ast/Impex.g:534:35: ~ ( '\"' )
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
                    	    // com/lambda/impex/ast/Impex.g:534:44: '\"' '\"'
                    	    {
                    	    match('\"'); 

                    	    match('\"'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    match('\"'); 

                    }
                    break;

            }


            // com/lambda/impex/ast/Impex.g:534:59: ( Lb )?
            int alt15=2;
            switch ( input.LA(1) ) {
                case '\n':
                case '\r':
                    {
                    alt15=1;
                    }
                    break;
            }

            switch (alt15) {
                case 1 :
                    // com/lambda/impex/ast/Impex.g:534:59: Lb
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
            // com/lambda/impex/ast/Impex.g:537:2: ( '@' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // com/lambda/impex/ast/Impex.g:537:3: '@' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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


            // com/lambda/impex/ast/Impex.g:537:39: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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
    // $ANTLR end "SpecialAttribute"

    // $ANTLR start "DocumentID"
    public final void mDocumentID() throws RecognitionException {
        try {
            int _type = DocumentID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/lambda/impex/ast/Impex.g:540:2: ( '&' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // com/lambda/impex/ast/Impex.g:540:3: '&' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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


            // com/lambda/impex/ast/Impex.g:540:39: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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
    // $ANTLR end "DocumentID"

    // $ANTLR start "Identifier"
    public final void mIdentifier() throws RecognitionException {
        try {
            int _type = Identifier;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/lambda/impex/ast/Impex.g:543:2: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // com/lambda/impex/ast/Impex.g:543:3: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // com/lambda/impex/ast/Impex.g:543:35: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop18:
            do {
                int alt18=2;
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
                    alt18=1;
                    }
                    break;

                }

                switch (alt18) {
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
            	    break loop18;
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
            // com/lambda/impex/ast/Impex.g:546:2: ( ( ( 'a' .. 'z' )+ '.' )+ 'A' .. 'Z' ( 'A' .. 'Z' | 'a' .. 'z' )+ )
            // com/lambda/impex/ast/Impex.g:546:3: ( ( 'a' .. 'z' )+ '.' )+ 'A' .. 'Z' ( 'A' .. 'Z' | 'a' .. 'z' )+
            {
            // com/lambda/impex/ast/Impex.g:546:3: ( ( 'a' .. 'z' )+ '.' )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
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
                    alt20=1;
                    }
                    break;

                }

                switch (alt20) {
            	case 1 :
            	    // com/lambda/impex/ast/Impex.g:546:4: ( 'a' .. 'z' )+ '.'
            	    {
            	    // com/lambda/impex/ast/Impex.g:546:4: ( 'a' .. 'z' )+
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
            	    	    if ( cnt19 >= 1 ) break loop19;
            	                EarlyExitException eee =
            	                    new EarlyExitException(19, input);
            	                throw eee;
            	        }
            	        cnt19++;
            	    } while (true);


            	    match('.'); 

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


            matchRange('A','Z'); 

            // com/lambda/impex/ast/Impex.g:546:35: ( 'A' .. 'Z' | 'a' .. 'z' )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
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
                    alt21=1;
                    }
                    break;

                }

                switch (alt21) {
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
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
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
            // com/lambda/impex/ast/Impex.g:550:2: ( '#' (~ ( '\\r' | '\\n' ) )* ( Lb )? )
            // com/lambda/impex/ast/Impex.g:550:3: '#' (~ ( '\\r' | '\\n' ) )* ( Lb )?
            {
            match('#'); 

            // com/lambda/impex/ast/Impex.g:550:7: (~ ( '\\r' | '\\n' ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( ((LA22_0 >= '\u0000' && LA22_0 <= '\t')||(LA22_0 >= '\u000B' && LA22_0 <= '\f')||(LA22_0 >= '\u000E' && LA22_0 <= '\uFFFF')) ) {
                    alt22=1;
                }


                switch (alt22) {
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
            	    break loop22;
                }
            } while (true);


            // com/lambda/impex/ast/Impex.g:550:23: ( Lb )?
            int alt23=2;
            switch ( input.LA(1) ) {
                case '\n':
                case '\r':
                    {
                    alt23=1;
                    }
                    break;
            }

            switch (alt23) {
                case 1 :
                    // com/lambda/impex/ast/Impex.g:550:23: Lb
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
            // com/lambda/impex/ast/Impex.g:563:2: ({...}? => ';' ( Ws )* '\"' (~ '\"' | '\"' '\"' )* '\"' |)
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==';') && ((isHeader() == false))) {
                alt26=1;
            }
            else {
                alt26=2;
            }
            switch (alt26) {
                case 1 :
                    // com/lambda/impex/ast/Impex.g:563:3: {...}? => ';' ( Ws )* '\"' (~ '\"' | '\"' '\"' )* '\"'
                    {
                    if ( !((isHeader() == false)) ) {
                        throw new FailedPredicateException(input, "QuotedField", "isHeader() == false");
                    }

                    match(';'); 

                    // com/lambda/impex/ast/Impex.g:563:32: ( Ws )*
                    loop24:
                    do {
                        int alt24=2;
                        switch ( input.LA(1) ) {
                        case '\t':
                        case ' ':
                            {
                            alt24=1;
                            }
                            break;

                        }

                        switch (alt24) {
                    	case 1 :
                    	    // com/lambda/impex/ast/Impex.g:563:32: Ws
                    	    {
                    	    mWs(); 


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);


                    match('\"'); 

                    // com/lambda/impex/ast/Impex.g:563:40: (~ '\"' | '\"' '\"' )*
                    loop25:
                    do {
                        int alt25=3;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0=='\"') ) {
                            switch ( input.LA(2) ) {
                            case '\"':
                                {
                                alt25=2;
                                }
                                break;

                            }

                        }
                        else if ( ((LA25_0 >= '\u0000' && LA25_0 <= '!')||(LA25_0 >= '#' && LA25_0 <= '\uFFFF')) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // com/lambda/impex/ast/Impex.g:563:41: ~ '\"'
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
                    	    // com/lambda/impex/ast/Impex.g:563:48: '\"' '\"'
                    	    {
                    	    match('\"'); 

                    	    match('\"'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);


                    match('\"'); 

                    }
                    break;
                case 2 :
                    // com/lambda/impex/ast/Impex.g:563:78: 
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
            // com/lambda/impex/ast/Impex.g:570:2: ({...}? => ( ';' ( Char | Separator )* ) |)
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==';') && ((isHeader() == false))) {
                alt28=1;
            }
            else {
                alt28=2;
            }
            switch (alt28) {
                case 1 :
                    // com/lambda/impex/ast/Impex.g:570:3: {...}? => ( ';' ( Char | Separator )* )
                    {
                    if ( !((isHeader() == false)) ) {
                        throw new FailedPredicateException(input, "Field", "isHeader() == false");
                    }

                    // com/lambda/impex/ast/Impex.g:570:28: ( ';' ( Char | Separator )* )
                    // com/lambda/impex/ast/Impex.g:570:29: ';' ( Char | Separator )*
                    {
                    match(';'); 

                    // com/lambda/impex/ast/Impex.g:570:33: ( Char | Separator )*
                    loop27:
                    do {
                        int alt27=3;
                        alt27 = dfa27.predict(input);
                        switch (alt27) {
                    	case 1 :
                    	    // com/lambda/impex/ast/Impex.g:570:34: Char
                    	    {
                    	    mChar(); 


                    	    }
                    	    break;
                    	case 2 :
                    	    // com/lambda/impex/ast/Impex.g:570:40: Separator
                    	    {
                    	    mSeparator(); 


                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // com/lambda/impex/ast/Impex.g:570:68: 
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
            // com/lambda/impex/ast/Impex.g:587:3: ( ( ' ' | '\\t' ) )
            // com/lambda/impex/ast/Impex.g:587:4: ( ' ' | '\\t' )
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
            // com/lambda/impex/ast/Impex.g:589:4: ( ( ( '\\r' )? '\\n' | '\\r' ) )
            // com/lambda/impex/ast/Impex.g:589:5: ( ( '\\r' )? '\\n' | '\\r' )
            {
            // com/lambda/impex/ast/Impex.g:589:5: ( ( '\\r' )? '\\n' | '\\r' )
            int alt30=2;
            switch ( input.LA(1) ) {
            case '\r':
                {
                switch ( input.LA(2) ) {
                case '\n':
                    {
                    alt30=1;
                    }
                    break;
                default:
                    alt30=2;
                }

                }
                break;
            case '\n':
                {
                alt30=1;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;

            }

            switch (alt30) {
                case 1 :
                    // com/lambda/impex/ast/Impex.g:589:6: ( '\\r' )? '\\n'
                    {
                    // com/lambda/impex/ast/Impex.g:589:6: ( '\\r' )?
                    int alt29=2;
                    switch ( input.LA(1) ) {
                        case '\r':
                            {
                            alt29=1;
                            }
                            break;
                    }

                    switch (alt29) {
                        case 1 :
                            // com/lambda/impex/ast/Impex.g:589:6: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    }
                    break;
                case 2 :
                    // com/lambda/impex/ast/Impex.g:589:19: '\\r'
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
            // com/lambda/impex/ast/Impex.g:591:2: (~ ( '\\r' | '\\n' | '\"' | ';' ) )
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
        // com/lambda/impex/ast/Impex.g:1:8: ( Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual | Comma | Dot | DoubleQuote | Quote | Semicolon | RBracket | LBracket | LParenthesis | RParenthesis | Equals | Or | Bool | Macrodef | ValueAssignment | UserRights | BeanShell | SpecialAttribute | DocumentID | Identifier | Classname | Comment | QuotedField | Field | Ws | Lb | Char )
        int alt31=52;
        alt31 = dfa31.predict(input);
        switch (alt31) {
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
                // com/lambda/impex/ast/Impex.g:1:303: Quote
                {
                mQuote(); 


                }
                break;
            case 31 :
                // com/lambda/impex/ast/Impex.g:1:309: Semicolon
                {
                mSemicolon(); 


                }
                break;
            case 32 :
                // com/lambda/impex/ast/Impex.g:1:319: RBracket
                {
                mRBracket(); 


                }
                break;
            case 33 :
                // com/lambda/impex/ast/Impex.g:1:328: LBracket
                {
                mLBracket(); 


                }
                break;
            case 34 :
                // com/lambda/impex/ast/Impex.g:1:337: LParenthesis
                {
                mLParenthesis(); 


                }
                break;
            case 35 :
                // com/lambda/impex/ast/Impex.g:1:350: RParenthesis
                {
                mRParenthesis(); 


                }
                break;
            case 36 :
                // com/lambda/impex/ast/Impex.g:1:363: Equals
                {
                mEquals(); 


                }
                break;
            case 37 :
                // com/lambda/impex/ast/Impex.g:1:370: Or
                {
                mOr(); 


                }
                break;
            case 38 :
                // com/lambda/impex/ast/Impex.g:1:373: Bool
                {
                mBool(); 


                }
                break;
            case 39 :
                // com/lambda/impex/ast/Impex.g:1:378: Macrodef
                {
                mMacrodef(); 


                }
                break;
            case 40 :
                // com/lambda/impex/ast/Impex.g:1:387: ValueAssignment
                {
                mValueAssignment(); 


                }
                break;
            case 41 :
                // com/lambda/impex/ast/Impex.g:1:403: UserRights
                {
                mUserRights(); 


                }
                break;
            case 42 :
                // com/lambda/impex/ast/Impex.g:1:414: BeanShell
                {
                mBeanShell(); 


                }
                break;
            case 43 :
                // com/lambda/impex/ast/Impex.g:1:424: SpecialAttribute
                {
                mSpecialAttribute(); 


                }
                break;
            case 44 :
                // com/lambda/impex/ast/Impex.g:1:441: DocumentID
                {
                mDocumentID(); 


                }
                break;
            case 45 :
                // com/lambda/impex/ast/Impex.g:1:452: Identifier
                {
                mIdentifier(); 


                }
                break;
            case 46 :
                // com/lambda/impex/ast/Impex.g:1:463: Classname
                {
                mClassname(); 


                }
                break;
            case 47 :
                // com/lambda/impex/ast/Impex.g:1:473: Comment
                {
                mComment(); 


                }
                break;
            case 48 :
                // com/lambda/impex/ast/Impex.g:1:481: QuotedField
                {
                mQuotedField(); 


                }
                break;
            case 49 :
                // com/lambda/impex/ast/Impex.g:1:493: Field
                {
                mField(); 


                }
                break;
            case 50 :
                // com/lambda/impex/ast/Impex.g:1:499: Ws
                {
                mWs(); 


                }
                break;
            case 51 :
                // com/lambda/impex/ast/Impex.g:1:502: Lb
                {
                mLb(); 


                }
                break;
            case 52 :
                // com/lambda/impex/ast/Impex.g:1:505: Char
                {
                mChar(); 


                }
                break;

        }

    }


    protected DFA4 dfa4 = new DFA4(this);
    protected DFA8 dfa8 = new DFA8(this);
    protected DFA27 dfa27 = new DFA27(this);
    protected DFA31 dfa31 = new DFA31(this);
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
            return "()* loopback of 454:34: (~ ( '\\r' | '\\n' ) | Separator )*";
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
            return "455:36: ( ( ' ' | '\\t' )* '\"' (~ ( '\\r' | '\\n' | '\"' ) | '\"' '\"' )* '\"' | (~ ( '\\r' | '\\n' | ';' | '\"' | '[' | ']' | ',' ) )* )";
        }
    }
    static final String DFA27_eotS =
        "\1\1\1\uffff\1\3\1\uffff\1\3\1\uffff";
    static final String DFA27_eofS =
        "\6\uffff";
    static final String DFA27_minS =
        "\1\0\1\uffff\1\11\1\uffff\1\11\1\uffff";
    static final String DFA27_maxS =
        "\1\uffff\1\uffff\1\40\1\uffff\1\40\1\uffff";
    static final String DFA27_acceptS =
        "\1\uffff\1\3\1\uffff\1\1\1\uffff\1\2";
    static final String DFA27_specialS =
        "\1\0\5\uffff}>";
    static final String[] DFA27_transitionS = {
            "\12\3\1\uffff\2\3\1\uffff\24\3\1\uffff\30\3\1\uffff\40\3\1\2"+
            "\uffa3\3",
            "",
            "\1\4\1\5\2\uffff\1\5\22\uffff\1\4",
            "",
            "\1\4\1\5\2\uffff\1\5\22\uffff\1\4",
            ""
    };

    static final short[] DFA27_eot = DFA.unpackEncodedString(DFA27_eotS);
    static final short[] DFA27_eof = DFA.unpackEncodedString(DFA27_eofS);
    static final char[] DFA27_min = DFA.unpackEncodedStringToUnsignedChars(DFA27_minS);
    static final char[] DFA27_max = DFA.unpackEncodedStringToUnsignedChars(DFA27_maxS);
    static final short[] DFA27_accept = DFA.unpackEncodedString(DFA27_acceptS);
    static final short[] DFA27_special = DFA.unpackEncodedString(DFA27_specialS);
    static final short[][] DFA27_transition;

    static {
        int numStates = DFA27_transitionS.length;
        DFA27_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA27_transition[i] = DFA.unpackEncodedString(DFA27_transitionS[i]);
        }
    }

    class DFA27 extends DFA {

        public DFA27(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 27;
            this.eot = DFA27_eot;
            this.eof = DFA27_eof;
            this.min = DFA27_min;
            this.max = DFA27_max;
            this.accept = DFA27_accept;
            this.special = DFA27_special;
            this.transition = DFA27_transition;
        }
        public String getDescription() {
            return "()* loopback of 570:33: ( Char | Separator )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA27_0 = input.LA(1);

                        s = -1;
                        if ( (LA27_0=='\\') ) {s = 2;}

                        else if ( ((LA27_0 >= '\u0000' && LA27_0 <= '\t')||(LA27_0 >= '\u000B' && LA27_0 <= '\f')||(LA27_0 >= '\u000E' && LA27_0 <= '!')||(LA27_0 >= '#' && LA27_0 <= ':')||(LA27_0 >= '<' && LA27_0 <= '[')||(LA27_0 >= ']' && LA27_0 <= '\uFFFF')) ) {s = 3;}

                        else s = 1;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 27, _s, input);
            error(nvae);
            throw nvae;
        }

    }
    static final String DFA31_eotS =
        "\1\36\17\67\2\uffff\1\151\1\uffff\1\153\4\uffff\1\163\1\uffff\2"+
        "\67\1\63\1\uffff\1\172\2\63\16\67\4\uffff\3\67\2\uffff\55\67\6\uffff"+
        "\1\156\12\uffff\1\170\1\uffff\1\150\4\uffff\26\67\2\u00cb\32\67"+
        "\1\uffff\1\170\2\150\1\uffff\26\67\1\uffff\14\67\2\u0106\1\uffff"+
        "\2\u0107\4\67\1\u010c\2\67\1\170\24\67\1\uffff\2\u0124\10\67\1\u010c"+
        "\1\67\2\uffff\4\67\1\uffff\2\67\1\170\2\u0136\2\67\2\u013b\2\u013c"+
        "\2\u013d\12\67\1\uffff\17\67\1\170\1\67\1\uffff\4\67\3\uffff\16"+
        "\67\2\u016b\7\67\2\u0173\1\170\23\67\1\uffff\7\67\1\uffff\1\170"+
        "\5\67\2\u0195\6\67\2\u019c\2\u019d\11\67\1\170\3\67\2\u01ab\1\uffff"+
        "\6\67\2\uffff\2\u01b1\2\u01b2\1\uffff\2\67\2\u01b5\1\170\3\67\1"+
        "\uffff\2\u01ba\2\67\3\uffff\2\67\1\uffff\1\170\3\67\1\uffff\2\67"+
        "\2\u01c5\1\170\1\u01c7\2\u01c8\2\u01c9\1\uffff\1\170\3\uffff\4\170"+
        "\1\uffff\1\170";
    static final String DFA31_eofS =
        "\u01d0\uffff";
    static final String DFA31_minS =
        "\1\0\17\56\2\uffff\1\43\1\uffff\1\0\4\uffff\1\0\1\uffff\1\122\1"+
        "\117\1\101\1\uffff\1\45\2\101\1\56\1\107\1\116\1\105\3\101\1\114"+
        "\1\101\1\105\2\101\1\125\1\111\4\uffff\3\56\2\uffff\1\123\1\116"+
        "\2\56\1\104\1\111\1\56\1\115\1\56\1\124\3\56\1\103\2\114\3\56\1"+
        "\117\1\124\1\123\1\56\1\111\2\56\1\124\1\106\2\56\1\122\1\56\1\131"+
        "\1\56\1\116\2\56\1\120\1\104\1\56\1\115\1\56\1\101\1\56\1\122\5"+
        "\uffff\1\0\1\11\12\uffff\1\124\1\uffff\1\0\4\uffff\1\56\1\105\1"+
        "\56\1\117\1\56\1\101\1\56\1\121\1\56\1\117\1\56\1\103\1\56\1\110"+
        "\1\56\1\114\1\56\1\114\1\56\1\103\1\56\1\110\1\56\1\60\2\56\1\101"+
        "\1\117\1\56\1\105\1\56\1\101\1\56\1\103\2\56\1\62\1\56\1\107\2\55"+
        "\1\56\1\105\1\56\1\102\2\56\1\116\1\56\1\124\1\uffff\1\101\1\0\1"+
        "\12\1\uffff\1\56\1\122\1\56\1\122\1\56\1\124\1\56\1\125\1\56\1\126"+
        "\1\56\1\110\1\56\1\105\1\56\1\104\1\56\1\105\1\56\1\105\2\55\1\uffff"+
        "\1\56\1\123\1\56\1\127\1\56\1\106\1\56\1\125\1\56\1\105\1\56\1\126"+
        "\1\56\1\60\1\uffff\1\56\1\60\1\56\1\105\1\56\1\123\2\56\1\125\1"+
        "\122\1\56\1\124\1\56\1\105\1\56\1\105\1\56\1\105\1\56\1\105\1\56"+
        "\1\115\1\56\1\125\1\56\1\105\1\56\1\103\1\56\1\123\1\uffff\1\56"+
        "\1\60\1\56\1\116\1\56\1\117\1\56\1\114\1\56\1\127\1\56\1\101\2\uffff"+
        "\1\56\1\122\1\56\1\114\1\uffff\1\56\1\101\1\124\1\56\1\60\1\56\1"+
        "\113\1\56\1\60\1\56\1\60\1\56\1\60\1\56\1\117\1\56\1\116\1\56\1"+
        "\103\1\56\1\124\1\56\1\123\1\uffff\1\56\1\125\1\56\1\122\1\56\1"+
        "\124\1\56\1\122\1\114\1\56\1\106\1\56\1\101\1\56\1\114\1\137\1\125"+
        "\1\uffff\2\56\1\105\1\125\3\uffff\1\56\1\104\1\56\1\111\1\56\1\117"+
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
    static final String DFA31_maxS =
        "\1\uffff\17\172\2\uffff\1\43\1\uffff\1\uffff\4\uffff\1\uffff\1\uffff"+
        "\1\162\1\157\1\172\1\uffff\1\45\3\172\1\156\1\160\1\145\1\141\1"+
        "\157\1\162\1\154\2\145\1\141\1\157\1\165\1\151\4\uffff\3\172\2\uffff"+
        "\1\163\1\156\2\172\1\144\1\151\1\172\1\155\1\172\1\164\3\172\1\143"+
        "\2\154\3\172\1\157\1\164\1\163\1\172\1\154\2\172\1\164\1\146\2\172"+
        "\1\162\1\172\1\171\1\172\1\156\2\172\1\160\1\144\1\172\1\155\1\172"+
        "\1\141\1\172\1\162\5\uffff\1\0\1\42\12\uffff\1\124\1\uffff\1\uffff"+
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
    static final String DFA31_acceptS =
        "\20\uffff\1\33\1\34\1\uffff\1\36\1\uffff\1\40\1\41\1\42\1\43\1\uffff"+
        "\1\45\3\uffff\1\50\21\uffff\1\55\1\62\1\63\1\64\3\uffff\1\55\1\56"+
        "\55\uffff\1\33\1\34\1\52\1\35\1\36\2\uffff\1\60\1\61\1\40\1\41\1"+
        "\42\1\43\1\44\2\50\1\45\1\uffff\1\47\1\uffff\1\57\1\53\1\54\1\62"+
        "\62\uffff\1\37\3\uffff\1\52\26\uffff\1\27\16\uffff\1\23\36\uffff"+
        "\1\26\14\uffff\1\22\1\24\4\uffff\1\46\27\uffff\1\10\21\uffff\1\1"+
        "\4\uffff\1\3\1\31\1\4\55\uffff\1\15\7\uffff\1\32\41\uffff\1\5\6"+
        "\uffff\1\7\1\11\4\uffff\1\21\10\uffff\1\20\4\uffff\1\13\1\14\1\16"+
        "\2\uffff\1\30\4\uffff\1\6\12\uffff\1\25\1\uffff\1\2\1\17\1\12\4"+
        "\uffff\1\51\1\uffff";
    static final String DFA31_specialS =
        "\1\10\23\uffff\1\6\4\uffff\1\4\121\uffff\1\1\1\7\14\uffff\1\5\70"+
        "\uffff\1\3\u011a\uffff\1\2\1\uffff\1\0}>";
    static final String[] DFA31_transitionS = {
            "\11\63\1\61\1\62\2\63\1\62\22\63\1\61\1\63\1\22\1\37\1\35\1"+
            "\63\1\41\1\23\1\27\1\30\2\63\1\20\1\63\1\21\14\63\1\24\1\63"+
            "\1\31\2\63\1\40\1\51\1\46\1\47\1\52\1\60\1\34\2\60\1\43\1\60"+
            "\1\53\1\54\1\55\1\56\1\60\1\50\1\60\1\45\1\60\1\33\1\44\1\57"+
            "\4\60\1\26\1\63\1\25\1\63\1\60\1\63\1\7\1\4\1\5\1\10\1\42\1"+
            "\11\2\42\1\1\1\42\1\12\1\13\1\14\1\15\1\42\1\6\1\42\1\3\1\42"+
            "\1\16\1\2\1\17\4\42\1\63\1\32\uff83\63",
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
            "",
            "\11\156\1\154\1\uffff\2\156\1\uffff\22\156\1\154\1\156\1\155"+
            "\30\156\1\uffff\uffc4\156",
            "",
            "",
            "",
            "",
            "\12\164\1\uffff\2\164\1\uffff\36\164\1\165\16\164\1\165\37"+
            "\164\1\165\1\164\1\165\uffa2\164",
            "",
            "\1\143\37\uffff\1\143",
            "\1\127\37\uffff\1\127",
            "\22\170\1\167\7\170\4\uffff\1\170\1\uffff\32\170",
            "",
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
            "",
            "\1\uffff",
            "\1\154\26\uffff\1\154\1\uffff\1\155",
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

    static final short[] DFA31_eot = DFA.unpackEncodedString(DFA31_eotS);
    static final short[] DFA31_eof = DFA.unpackEncodedString(DFA31_eofS);
    static final char[] DFA31_min = DFA.unpackEncodedStringToUnsignedChars(DFA31_minS);
    static final char[] DFA31_max = DFA.unpackEncodedStringToUnsignedChars(DFA31_maxS);
    static final short[] DFA31_accept = DFA.unpackEncodedString(DFA31_acceptS);
    static final short[] DFA31_special = DFA.unpackEncodedString(DFA31_specialS);
    static final short[][] DFA31_transition;

    static {
        int numStates = DFA31_transitionS.length;
        DFA31_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA31_transition[i] = DFA.unpackEncodedString(DFA31_transitionS[i]);
        }
    }

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = DFA31_eot;
            this.eof = DFA31_eof;
            this.min = DFA31_min;
            this.max = DFA31_max;
            this.accept = DFA31_accept;
            this.special = DFA31_special;
            this.transition = DFA31_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual | Comma | Dot | DoubleQuote | Quote | Semicolon | RBracket | LBracket | LParenthesis | RParenthesis | Equals | Or | Bool | Macrodef | ValueAssignment | UserRights | BeanShell | SpecialAttribute | DocumentID | Identifier | Classname | Comment | QuotedField | Field | Ws | Lb | Char );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA31_463 = input.LA(1);

                        s = -1;
                        if ( ((LA31_463 >= '\u0000' && LA31_463 <= '/')||(LA31_463 >= ':' && LA31_463 <= '@')||(LA31_463 >= '[' && LA31_463 <= '^')||LA31_463=='`'||(LA31_463 >= '{' && LA31_463 <= '\uFFFF')) ) {s = 462;}

                        else if ( ((LA31_463 >= '0' && LA31_463 <= '9')||(LA31_463 >= 'A' && LA31_463 <= 'Z')||LA31_463=='_'||(LA31_463 >= 'a' && LA31_463 <= 'z')) ) {s = 463;}

                        else s = 120;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA31_107 = input.LA(1);

                         
                        int index31_107 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((isHeader() == false)))) ) {s = 176;}

                        else if ( ((isHeader() == false)) ) {s = 110;}

                         
                        input.seek(index31_107);

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA31_461 = input.LA(1);

                        s = -1;
                        if ( ((LA31_461 >= '\u0000' && LA31_461 <= '/')||(LA31_461 >= ':' && LA31_461 <= '@')||(LA31_461 >= '[' && LA31_461 <= '^')||LA31_461=='`'||(LA31_461 >= '{' && LA31_461 <= '\uFFFF')) ) {s = 462;}

                        else if ( ((LA31_461 >= '0' && LA31_461 <= '9')||(LA31_461 >= 'A' && LA31_461 <= 'Z')||LA31_461=='_'||(LA31_461 >= 'a' && LA31_461 <= 'z')) ) {s = 463;}

                        else s = 120;

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA31_178 = input.LA(1);

                        s = -1;
                        if ( (LA31_178=='\r') ) {s = 179;}

                        else if ( (LA31_178=='\n') ) {s = 180;}

                        else if ( ((LA31_178 >= '\u0000' && LA31_178 <= '\t')||(LA31_178 >= '\u000B' && LA31_178 <= '\f')||(LA31_178 >= '\u000E' && LA31_178 <= '\uFFFF')) ) {s = 178;}

                        else s = 104;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA31_25 = input.LA(1);

                         
                        int index31_25 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA31_25 >= '\u0000' && LA31_25 <= '\t')||(LA31_25 >= '\u000B' && LA31_25 <= '\f')||(LA31_25 >= '\u000E' && LA31_25 <= '+')||(LA31_25 >= '-' && LA31_25 <= ':')||(LA31_25 >= '<' && LA31_25 <= 'Z')||LA31_25=='\\'||(LA31_25 >= '^' && LA31_25 <= '\uFFFF')) && (((isModifierAssignment())||(isMacroAssignment())))) {s = 116;}

                        else if ( (LA31_25==','||LA31_25==';'||LA31_25=='['||LA31_25==']') && ((isMacroAssignment()))) {s = 117;}

                        else s = 115;

                         
                        input.seek(index31_25);

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA31_121 = input.LA(1);

                        s = -1;
                        if ( ((LA31_121 >= '\u0000' && LA31_121 <= '\t')||(LA31_121 >= '\u000B' && LA31_121 <= '\f')||(LA31_121 >= '\u000E' && LA31_121 <= '\uFFFF')) ) {s = 178;}

                        else if ( (LA31_121=='\r') ) {s = 179;}

                        else if ( (LA31_121=='\n') ) {s = 180;}

                        else s = 104;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA31_20 = input.LA(1);

                         
                        int index31_20 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA31_20=='\t'||LA31_20==' ') && ((isHeader() == false))) {s = 108;}

                        else if ( (LA31_20=='\"') && ((isHeader() == false))) {s = 109;}

                        else if ( ((LA31_20 >= '\u0000' && LA31_20 <= '\b')||(LA31_20 >= '\u000B' && LA31_20 <= '\f')||(LA31_20 >= '\u000E' && LA31_20 <= '\u001F')||LA31_20=='!'||(LA31_20 >= '#' && LA31_20 <= ':')||(LA31_20 >= '<' && LA31_20 <= '\uFFFF')) && ((isHeader() == false))) {s = 110;}

                        else s = 107;

                         
                        input.seek(index31_20);

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA31_108 = input.LA(1);

                         
                        int index31_108 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA31_108=='\"') && ((isHeader() == false))) {s = 109;}

                        else if ( (LA31_108=='\t'||LA31_108==' ') && ((isHeader() == false))) {s = 108;}

                        else s = 110;

                         
                        input.seek(index31_108);

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA31_0 = input.LA(1);

                        s = -1;
                        if ( (LA31_0=='i') ) {s = 1;}

                        else if ( (LA31_0=='u') ) {s = 2;}

                        else if ( (LA31_0=='r') ) {s = 3;}

                        else if ( (LA31_0=='b') ) {s = 4;}

                        else if ( (LA31_0=='c') ) {s = 5;}

                        else if ( (LA31_0=='p') ) {s = 6;}

                        else if ( (LA31_0=='a') ) {s = 7;}

                        else if ( (LA31_0=='d') ) {s = 8;}

                        else if ( (LA31_0=='f') ) {s = 9;}

                        else if ( (LA31_0=='k') ) {s = 10;}

                        else if ( (LA31_0=='l') ) {s = 11;}

                        else if ( (LA31_0=='m') ) {s = 12;}

                        else if ( (LA31_0=='n') ) {s = 13;}

                        else if ( (LA31_0=='t') ) {s = 14;}

                        else if ( (LA31_0=='v') ) {s = 15;}

                        else if ( (LA31_0==',') ) {s = 16;}

                        else if ( (LA31_0=='.') ) {s = 17;}

                        else if ( (LA31_0=='\"') ) {s = 18;}

                        else if ( (LA31_0=='\'') ) {s = 19;}

                        else if ( (LA31_0==';') ) {s = 20;}

                        else if ( (LA31_0==']') ) {s = 21;}

                        else if ( (LA31_0=='[') ) {s = 22;}

                        else if ( (LA31_0=='(') ) {s = 23;}

                        else if ( (LA31_0==')') ) {s = 24;}

                        else if ( (LA31_0=='=') ) {s = 25;}

                        else if ( (LA31_0=='|') ) {s = 26;}

                        else if ( (LA31_0=='T') ) {s = 27;}

                        else if ( (LA31_0=='F') ) {s = 28;}

                        else if ( (LA31_0=='$') ) {s = 29;}

                        else if ( (LA31_0=='#') ) {s = 31;}

                        else if ( (LA31_0=='@') ) {s = 32;}

                        else if ( (LA31_0=='&') ) {s = 33;}

                        else if ( (LA31_0=='e'||(LA31_0 >= 'g' && LA31_0 <= 'h')||LA31_0=='j'||LA31_0=='o'||LA31_0=='q'||LA31_0=='s'||(LA31_0 >= 'w' && LA31_0 <= 'z')) ) {s = 34;}

                        else if ( (LA31_0=='I') ) {s = 35;}

                        else if ( (LA31_0=='U') ) {s = 36;}

                        else if ( (LA31_0=='R') ) {s = 37;}

                        else if ( (LA31_0=='B') ) {s = 38;}

                        else if ( (LA31_0=='C') ) {s = 39;}

                        else if ( (LA31_0=='P') ) {s = 40;}

                        else if ( (LA31_0=='A') ) {s = 41;}

                        else if ( (LA31_0=='D') ) {s = 42;}

                        else if ( (LA31_0=='K') ) {s = 43;}

                        else if ( (LA31_0=='L') ) {s = 44;}

                        else if ( (LA31_0=='M') ) {s = 45;}

                        else if ( (LA31_0=='N') ) {s = 46;}

                        else if ( (LA31_0=='V') ) {s = 47;}

                        else if ( (LA31_0=='E'||(LA31_0 >= 'G' && LA31_0 <= 'H')||LA31_0=='J'||LA31_0=='O'||LA31_0=='Q'||LA31_0=='S'||(LA31_0 >= 'W' && LA31_0 <= 'Z')||LA31_0=='_') ) {s = 48;}

                        else if ( (LA31_0=='\t'||LA31_0==' ') ) {s = 49;}

                        else if ( (LA31_0=='\n'||LA31_0=='\r') ) {s = 50;}

                        else if ( ((LA31_0 >= '\u0000' && LA31_0 <= '\b')||(LA31_0 >= '\u000B' && LA31_0 <= '\f')||(LA31_0 >= '\u000E' && LA31_0 <= '\u001F')||LA31_0=='!'||LA31_0=='%'||(LA31_0 >= '*' && LA31_0 <= '+')||LA31_0=='-'||(LA31_0 >= '/' && LA31_0 <= ':')||LA31_0=='<'||(LA31_0 >= '>' && LA31_0 <= '?')||LA31_0=='\\'||LA31_0=='^'||LA31_0=='`'||LA31_0=='{'||(LA31_0 >= '}' && LA31_0 <= '\uFFFF')) ) {s = 51;}

                        else s = 30;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 31, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}