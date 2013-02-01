// $ANTLR 3.4 com/lambda/impex/ast/Impex.g 2013-01-26 20:11:18

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
    public static final int CacheUnique=13;
    public static final int CellDecorator=14;
    public static final int Char=15;
    public static final int CollectionDelimiter=16;
    public static final int Comma=17;
    public static final int Comment=18;
    public static final int Dateformat=19;
    public static final int Default=20;
    public static final int DocumentID=21;
    public static final int Dot=22;
    public static final int DoubleQuote=23;
    public static final int Equals=24;
    public static final int FIELDS=25;
    public static final int Field=26;
    public static final int ForceWrite=27;
    public static final int HEADER=28;
    public static final int IMPEX=29;
    public static final int ITEM_EXPRESSION=30;
    public static final int Identifier=31;
    public static final int IgnoreKeyCase=32;
    public static final int IgnoreNull=33;
    public static final int Insert=34;
    public static final int InsertUpdate=35;
    public static final int KeyToValueDelimiter=36;
    public static final int LBracket=37;
    public static final int LParenthesis=38;
    public static final int Lang=39;
    public static final int Lb=40;
    public static final int MACRO_REF=41;
    public static final int MODIFIER=42;
    public static final int MODIFIERS=43;
    public static final int Macrodef=44;
    public static final int MapDelimiter=45;
    public static final int Mode=46;
    public static final int NumberFormat=47;
    public static final int Or=48;
    public static final int PathDelimiter=49;
    public static final int Pos=50;
    public static final int Processor=51;
    public static final int Quote=52;
    public static final int QuotedField=53;
    public static final int RBracket=54;
    public static final int RECORD=55;
    public static final int RECORDS=56;
    public static final int RParenthesis=57;
    public static final int Remove=58;
    public static final int SUBTYPE=59;
    public static final int Semicolon=60;
    public static final int Separator=61;
    public static final int SpecialAttribute=62;
    public static final int TYPE=63;
    public static final int Translator=64;
    public static final int Unique=65;
    public static final int Update=66;
    public static final int UserRights=67;
    public static final int ValueAssignment=68;
    public static final int Virtual=69;
    public static final int Ws=70;


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
        context.registerProblem(e);
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
            // com/lambda/impex/ast/Impex.g:318:9: ( ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' ) )
            // com/lambda/impex/ast/Impex.g:318:10: ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' )
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
            // com/lambda/impex/ast/Impex.g:319:15: ( ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' ) '_' ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // com/lambda/impex/ast/Impex.g:319:16: ( 'I' | 'i' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'T' | 't' ) '_' ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' )
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
            // com/lambda/impex/ast/Impex.g:320:9: ( ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // com/lambda/impex/ast/Impex.g:320:10: ( 'U' | 'u' ) ( 'P' | 'p' ) ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' )
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
            // com/lambda/impex/ast/Impex.g:321:9: ( ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'V' | 'v' ) ( 'E' | 'e' ) )
            // com/lambda/impex/ast/Impex.g:321:10: ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'V' | 'v' ) ( 'E' | 'e' )
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
            // com/lambda/impex/ast/Impex.g:323:12: ( ( 'B' | 'b' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'D' | 'd' ) ( 'E' | 'e' ) )
            // com/lambda/impex/ast/Impex.g:323:13: ( 'B' | 'b' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'D' | 'd' ) ( 'E' | 'e' )
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
            // com/lambda/impex/ast/Impex.g:324:14: ( ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'E' | 'e' ) ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // com/lambda/impex/ast/Impex.g:324:15: ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'C' | 'c' ) ( 'H' | 'h' ) ( 'E' | 'e' ) ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'E' | 'e' )
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
            // com/lambda/impex/ast/Impex.g:325:12: ( ( 'P' | 'p' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'S' | 's' ) ( 'O' | 'o' ) ( 'R' | 'r' ) )
            // com/lambda/impex/ast/Impex.g:325:13: ( 'P' | 'p' ) ( 'R' | 'r' ) ( 'O' | 'o' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'S' | 's' ) ( 'S' | 's' ) ( 'O' | 'o' ) ( 'R' | 'r' )
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
            // com/lambda/impex/ast/Impex.g:327:8: ( ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'A' | 'a' ) ( 'S' | 's' ) )
            // com/lambda/impex/ast/Impex.g:327:9: ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'A' | 'a' ) ( 'S' | 's' )
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
            // com/lambda/impex/ast/Impex.g:328:12: ( ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'W' | 'w' ) ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'L' | 'l' ) )
            // com/lambda/impex/ast/Impex.g:328:13: ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'O' | 'o' ) ( 'W' | 'w' ) ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'L' | 'l' )
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
            // com/lambda/impex/ast/Impex.g:329:15: ( ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'O' | 'o' ) ( 'R' | 'r' ) )
            // com/lambda/impex/ast/Impex.g:329:16: ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'O' | 'o' ) ( 'R' | 'r' )
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
            // com/lambda/impex/ast/Impex.g:330:22: ( ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // com/lambda/impex/ast/Impex.g:330:23: ( 'C' | 'c' ) ( 'O' | 'o' ) ( 'L' | 'l' ) ( 'L' | 'l' ) ( 'E' | 'e' ) ( 'C' | 'c' ) ( 'T' | 't' ) ( 'I' | 'i' ) ( 'O' | 'o' ) ( 'N' | 'n' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' )
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
            // com/lambda/impex/ast/Impex.g:331:13: ( ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'T' | 't' ) )
            // com/lambda/impex/ast/Impex.g:331:14: ( 'D' | 'd' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'T' | 't' )
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
            // com/lambda/impex/ast/Impex.g:332:10: ( ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'A' | 'a' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'T' | 't' ) )
            // com/lambda/impex/ast/Impex.g:332:11: ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'F' | 'f' ) ( 'A' | 'a' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'T' | 't' )
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
            // com/lambda/impex/ast/Impex.g:333:13: ( ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'W' | 'w' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) )
            // com/lambda/impex/ast/Impex.g:333:14: ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'C' | 'c' ) ( 'E' | 'e' ) ( 'W' | 'w' ) ( 'R' | 'r' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' )
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
            // com/lambda/impex/ast/Impex.g:334:15: ( ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'N' | 'n' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'K' | 'k' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'E' | 'e' ) )
            // com/lambda/impex/ast/Impex.g:334:16: ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'N' | 'n' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'K' | 'k' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) ( 'C' | 'c' ) ( 'A' | 'a' ) ( 'S' | 's' ) ( 'E' | 'e' )
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
            // com/lambda/impex/ast/Impex.g:335:13: ( ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'N' | 'n' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'L' | 'l' ) )
            // com/lambda/impex/ast/Impex.g:335:14: ( 'I' | 'i' ) ( 'G' | 'g' ) ( 'N' | 'n' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'E' | 'e' ) ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'L' | 'l' ) ( 'L' | 'l' )
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
            // com/lambda/impex/ast/Impex.g:336:21: ( ( 'K' | 'k' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) '2' ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // com/lambda/impex/ast/Impex.g:336:22: ( 'K' | 'k' ) ( 'E' | 'e' ) ( 'Y' | 'y' ) '2' ( 'V' | 'v' ) ( 'A' | 'a' ) ( 'L' | 'l' ) ( 'U' | 'u' ) ( 'E' | 'e' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' )
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
            // com/lambda/impex/ast/Impex.g:337:7: ( ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'G' | 'g' ) )
            // com/lambda/impex/ast/Impex.g:337:8: ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'G' | 'g' )
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
            // com/lambda/impex/ast/Impex.g:338:14: ( ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'P' | 'p' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // com/lambda/impex/ast/Impex.g:338:15: ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'P' | 'p' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' )
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
            // com/lambda/impex/ast/Impex.g:339:7: ( ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'D' | 'd' ) ( 'E' | 'e' ) )
            // com/lambda/impex/ast/Impex.g:339:8: ( 'M' | 'm' ) ( 'O' | 'o' ) ( 'D' | 'd' ) ( 'E' | 'e' )
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
            // com/lambda/impex/ast/Impex.g:340:14: ( ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'B' | 'b' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'T' | 't' ) )
            // com/lambda/impex/ast/Impex.g:340:15: ( 'N' | 'n' ) ( 'U' | 'u' ) ( 'M' | 'm' ) ( 'B' | 'b' ) ( 'E' | 'e' ) ( 'R' | 'r' ) ( 'F' | 'f' ) ( 'O' | 'o' ) ( 'R' | 'r' ) ( 'M' | 'm' ) ( 'A' | 'a' ) ( 'T' | 't' )
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
            // com/lambda/impex/ast/Impex.g:341:15: ( ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'H' | 'h' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' ) )
            // com/lambda/impex/ast/Impex.g:341:16: ( 'P' | 'p' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'H' | 'h' ) '-' ( 'D' | 'd' ) ( 'E' | 'e' ) ( 'L' | 'l' ) ( 'I' | 'i' ) ( 'M' | 'm' ) ( 'I' | 'i' ) ( 'T' | 't' ) ( 'E' | 'e' ) ( 'R' | 'r' )
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
            // com/lambda/impex/ast/Impex.g:342:6: ( ( 'P' | 'p' ) ( 'O' | 'o' ) ( 'S' | 's' ) )
            // com/lambda/impex/ast/Impex.g:342:7: ( 'P' | 'p' ) ( 'O' | 'o' ) ( 'S' | 's' )
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
            // com/lambda/impex/ast/Impex.g:343:13: ( ( 'T' | 't' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'O' | 'o' ) ( 'R' | 'r' ) )
            // com/lambda/impex/ast/Impex.g:343:14: ( 'T' | 't' ) ( 'R' | 'r' ) ( 'A' | 'a' ) ( 'N' | 'n' ) ( 'S' | 's' ) ( 'L' | 'l' ) ( 'A' | 'a' ) ( 'T' | 't' ) ( 'O' | 'o' ) ( 'R' | 'r' )
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
            // com/lambda/impex/ast/Impex.g:344:9: ( ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'E' | 'e' ) )
            // com/lambda/impex/ast/Impex.g:344:10: ( 'U' | 'u' ) ( 'N' | 'n' ) ( 'I' | 'i' ) ( 'Q' | 'q' ) ( 'U' | 'u' ) ( 'E' | 'e' )
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
            // com/lambda/impex/ast/Impex.g:345:10: ( ( 'V' | 'v' ) ( 'I' | 'i' ) ( 'R' | 'r' ) ( 'T' | 't' ) ( 'U' | 'u' ) ( 'A' | 'a' ) ( 'L' | 'l' ) )
            // com/lambda/impex/ast/Impex.g:345:11: ( 'V' | 'v' ) ( 'I' | 'i' ) ( 'R' | 'r' ) ( 'T' | 't' ) ( 'U' | 'u' ) ( 'A' | 'a' ) ( 'L' | 'l' )
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
            // com/lambda/impex/ast/Impex.g:348:8: ( ',' )
            // com/lambda/impex/ast/Impex.g:348:9: ','
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
            // com/lambda/impex/ast/Impex.g:349:5: ( '.' )
            // com/lambda/impex/ast/Impex.g:349:6: '.'
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
            // com/lambda/impex/ast/Impex.g:350:13: ( '\"' )
            // com/lambda/impex/ast/Impex.g:350:14: '\"'
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
            // com/lambda/impex/ast/Impex.g:351:7: ( '\\'' )
            // com/lambda/impex/ast/Impex.g:351:8: '\\''
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
            // com/lambda/impex/ast/Impex.g:352:11: ( ';' )
            // com/lambda/impex/ast/Impex.g:352:12: ';'
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
            // com/lambda/impex/ast/Impex.g:353:10: ( ']' )
            // com/lambda/impex/ast/Impex.g:353:11: ']'
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
            // com/lambda/impex/ast/Impex.g:354:10: ( '[' )
            // com/lambda/impex/ast/Impex.g:354:11: '['
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
            // com/lambda/impex/ast/Impex.g:355:15: ( '(' )
            // com/lambda/impex/ast/Impex.g:355:16: '('
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
            // com/lambda/impex/ast/Impex.g:356:14: ( ')' )
            // com/lambda/impex/ast/Impex.g:356:15: ')'
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
            // com/lambda/impex/ast/Impex.g:357:8: ( '=' )
            // com/lambda/impex/ast/Impex.g:357:9: '='
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
            // com/lambda/impex/ast/Impex.g:358:4: ( '|' )
            // com/lambda/impex/ast/Impex.g:358:5: '|'
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

    // $ANTLR start "Separator"
    public final void mSeparator() throws RecognitionException {
        try {
            // com/lambda/impex/ast/Impex.g:371:2: ( '\\\\' ( Ws )* Lb )
            // com/lambda/impex/ast/Impex.g:371:3: '\\\\' ( Ws )* Lb
            {
            match('\\'); 

            // com/lambda/impex/ast/Impex.g:371:8: ( Ws )*
            loop1:
            do {
                int alt1=2;
                switch ( input.LA(1) ) {
                case '\t':
                case ' ':
                    {
                    alt1=1;
                    }
                    break;

                }

                switch (alt1) {
            	case 1 :
            	    // com/lambda/impex/ast/Impex.g:371:8: Ws
            	    {
            	    mWs(); 


            	    }
            	    break;

            	default :
            	    break loop1;
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
            // com/lambda/impex/ast/Impex.g:374:2: ( '$' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // com/lambda/impex/ast/Impex.g:374:3: '$' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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


            // com/lambda/impex/ast/Impex.g:374:39: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            loop2:
            do {
                int alt2=2;
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
                    alt2=1;
                    }
                    break;

                }

                switch (alt2) {
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

    // $ANTLR start "ValueAssignment"
    public final void mValueAssignment() throws RecognitionException {
        try {
            int _type = ValueAssignment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/lambda/impex/ast/Impex.g:377:2: ({...}? => '=' (~ ( '\\r' | '\\n' ) | Separator )* |{...}? => '=' ( ( ' ' | '\\t' )* '\"' (~ ( '\\r' | '\\n' | '\"' ) | '\"' '\"' )* '\"' | (~ ( '\\r' | '\\n' | ';' | '\"' | '[' | ']' | ',' ) )* ) |)
            int alt8=3;
            int LA8_0 = input.LA(1);

            if ( (LA8_0=='=') && (((isModifierAssignment())||(isMacroAssignment())))) {
                int LA8_1 = input.LA(2);

                if ( ((isMacroAssignment())) ) {
                    alt8=1;
                }
                else if ( ((isModifierAssignment())) ) {
                    alt8=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;

                }
            }
            else {
                alt8=3;
            }
            switch (alt8) {
                case 1 :
                    // com/lambda/impex/ast/Impex.g:377:3: {...}? => '=' (~ ( '\\r' | '\\n' ) | Separator )*
                    {
                    if ( !((isMacroAssignment())) ) {
                        throw new FailedPredicateException(input, "ValueAssignment", "isMacroAssignment()");
                    }

                    match('='); 

                    // com/lambda/impex/ast/Impex.g:377:34: (~ ( '\\r' | '\\n' ) | Separator )*
                    loop3:
                    do {
                        int alt3=3;
                        alt3 = dfa3.predict(input);
                        switch (alt3) {
                    	case 1 :
                    	    // com/lambda/impex/ast/Impex.g:377:35: ~ ( '\\r' | '\\n' )
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
                    	    // com/lambda/impex/ast/Impex.g:377:52: Separator
                    	    {
                    	    mSeparator(); 


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    String text = removeSeparators(getText()); setText(text.substring(1, text.length()).trim());

                    }
                    break;
                case 2 :
                    // com/lambda/impex/ast/Impex.g:378:3: {...}? => '=' ( ( ' ' | '\\t' )* '\"' (~ ( '\\r' | '\\n' | '\"' ) | '\"' '\"' )* '\"' | (~ ( '\\r' | '\\n' | ';' | '\"' | '[' | ']' | ',' ) )* )
                    {
                    if ( !((isModifierAssignment())) ) {
                        throw new FailedPredicateException(input, "ValueAssignment", "isModifierAssignment()");
                    }

                    match('='); 

                    // com/lambda/impex/ast/Impex.g:378:36: ( ( ' ' | '\\t' )* '\"' (~ ( '\\r' | '\\n' | '\"' ) | '\"' '\"' )* '\"' | (~ ( '\\r' | '\\n' | ';' | '\"' | '[' | ']' | ',' ) )* )
                    int alt7=2;
                    alt7 = dfa7.predict(input);
                    switch (alt7) {
                        case 1 :
                            // com/lambda/impex/ast/Impex.g:378:37: ( ' ' | '\\t' )* '\"' (~ ( '\\r' | '\\n' | '\"' ) | '\"' '\"' )* '\"'
                            {
                            // com/lambda/impex/ast/Impex.g:378:37: ( ' ' | '\\t' )*
                            loop4:
                            do {
                                int alt4=2;
                                switch ( input.LA(1) ) {
                                case '\t':
                                case ' ':
                                    {
                                    alt4=1;
                                    }
                                    break;

                                }

                                switch (alt4) {
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
                            	    break loop4;
                                }
                            } while (true);


                            match('\"'); 

                            // com/lambda/impex/ast/Impex.g:378:54: (~ ( '\\r' | '\\n' | '\"' ) | '\"' '\"' )*
                            loop5:
                            do {
                                int alt5=3;
                                int LA5_0 = input.LA(1);

                                if ( (LA5_0=='\"') ) {
                                    switch ( input.LA(2) ) {
                                    case '\"':
                                        {
                                        alt5=2;
                                        }
                                        break;

                                    }

                                }
                                else if ( ((LA5_0 >= '\u0000' && LA5_0 <= '\t')||(LA5_0 >= '\u000B' && LA5_0 <= '\f')||(LA5_0 >= '\u000E' && LA5_0 <= '!')||(LA5_0 >= '#' && LA5_0 <= '\uFFFF')) ) {
                                    alt5=1;
                                }


                                switch (alt5) {
                            	case 1 :
                            	    // com/lambda/impex/ast/Impex.g:378:55: ~ ( '\\r' | '\\n' | '\"' )
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
                            	    // com/lambda/impex/ast/Impex.g:378:79: '\"' '\"'
                            	    {
                            	    match('\"'); 

                            	    match('\"'); 

                            	    }
                            	    break;

                            	default :
                            	    break loop5;
                                }
                            } while (true);


                            match('\"'); 

                            String text = getText().substring(1, getText().length()).trim(); setText(text.substring(1, text.length() - 1));

                            }
                            break;
                        case 2 :
                            // com/lambda/impex/ast/Impex.g:378:209: (~ ( '\\r' | '\\n' | ';' | '\"' | '[' | ']' | ',' ) )*
                            {
                            // com/lambda/impex/ast/Impex.g:378:209: (~ ( '\\r' | '\\n' | ';' | '\"' | '[' | ']' | ',' ) )*
                            loop6:
                            do {
                                int alt6=2;
                                int LA6_0 = input.LA(1);

                                if ( ((LA6_0 >= '\u0000' && LA6_0 <= '\t')||(LA6_0 >= '\u000B' && LA6_0 <= '\f')||(LA6_0 >= '\u000E' && LA6_0 <= '!')||(LA6_0 >= '#' && LA6_0 <= '+')||(LA6_0 >= '-' && LA6_0 <= ':')||(LA6_0 >= '<' && LA6_0 <= 'Z')||LA6_0=='\\'||(LA6_0 >= '^' && LA6_0 <= '\uFFFF')) ) {
                                    alt6=1;
                                }


                                switch (alt6) {
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
                            	    break loop6;
                                }
                            } while (true);


                            setText(getText().substring(1, getText().length()).trim());

                            }
                            break;

                    }


                    }
                    break;
                case 3 :
                    // com/lambda/impex/ast/Impex.g:379:17: 
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
            // com/lambda/impex/ast/Impex.g:383:2: ( '$START_USERRIGHTS' ( . )* '$END_USERRIGHTS' ( Semicolon | Ws )* )
            // com/lambda/impex/ast/Impex.g:383:3: '$START_USERRIGHTS' ( . )* '$END_USERRIGHTS' ( Semicolon | Ws )*
            {
            match("$START_USERRIGHTS"); 



            // com/lambda/impex/ast/Impex.g:383:23: ( . )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='$') ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1=='E') ) {
                        int LA9_3 = input.LA(3);

                        if ( (LA9_3=='N') ) {
                            int LA9_4 = input.LA(4);

                            if ( (LA9_4=='D') ) {
                                int LA9_5 = input.LA(5);

                                if ( (LA9_5=='_') ) {
                                    int LA9_6 = input.LA(6);

                                    if ( (LA9_6=='U') ) {
                                        int LA9_7 = input.LA(7);

                                        if ( (LA9_7=='S') ) {
                                            int LA9_8 = input.LA(8);

                                            if ( (LA9_8=='E') ) {
                                                int LA9_9 = input.LA(9);

                                                if ( (LA9_9=='R') ) {
                                                    int LA9_10 = input.LA(10);

                                                    if ( (LA9_10=='R') ) {
                                                        int LA9_11 = input.LA(11);

                                                        if ( (LA9_11=='I') ) {
                                                            int LA9_12 = input.LA(12);

                                                            if ( (LA9_12=='G') ) {
                                                                int LA9_13 = input.LA(13);

                                                                if ( (LA9_13=='H') ) {
                                                                    int LA9_14 = input.LA(14);

                                                                    if ( (LA9_14=='T') ) {
                                                                        int LA9_15 = input.LA(15);

                                                                        if ( (LA9_15=='S') ) {
                                                                            alt9=2;
                                                                        }
                                                                        else if ( ((LA9_15 >= '\u0000' && LA9_15 <= 'R')||(LA9_15 >= 'T' && LA9_15 <= '\uFFFF')) ) {
                                                                            alt9=1;
                                                                        }


                                                                    }
                                                                    else if ( ((LA9_14 >= '\u0000' && LA9_14 <= 'S')||(LA9_14 >= 'U' && LA9_14 <= '\uFFFF')) ) {
                                                                        alt9=1;
                                                                    }


                                                                }
                                                                else if ( ((LA9_13 >= '\u0000' && LA9_13 <= 'G')||(LA9_13 >= 'I' && LA9_13 <= '\uFFFF')) ) {
                                                                    alt9=1;
                                                                }


                                                            }
                                                            else if ( ((LA9_12 >= '\u0000' && LA9_12 <= 'F')||(LA9_12 >= 'H' && LA9_12 <= '\uFFFF')) ) {
                                                                alt9=1;
                                                            }


                                                        }
                                                        else if ( ((LA9_11 >= '\u0000' && LA9_11 <= 'H')||(LA9_11 >= 'J' && LA9_11 <= '\uFFFF')) ) {
                                                            alt9=1;
                                                        }


                                                    }
                                                    else if ( ((LA9_10 >= '\u0000' && LA9_10 <= 'Q')||(LA9_10 >= 'S' && LA9_10 <= '\uFFFF')) ) {
                                                        alt9=1;
                                                    }


                                                }
                                                else if ( ((LA9_9 >= '\u0000' && LA9_9 <= 'Q')||(LA9_9 >= 'S' && LA9_9 <= '\uFFFF')) ) {
                                                    alt9=1;
                                                }


                                            }
                                            else if ( ((LA9_8 >= '\u0000' && LA9_8 <= 'D')||(LA9_8 >= 'F' && LA9_8 <= '\uFFFF')) ) {
                                                alt9=1;
                                            }


                                        }
                                        else if ( ((LA9_7 >= '\u0000' && LA9_7 <= 'R')||(LA9_7 >= 'T' && LA9_7 <= '\uFFFF')) ) {
                                            alt9=1;
                                        }


                                    }
                                    else if ( ((LA9_6 >= '\u0000' && LA9_6 <= 'T')||(LA9_6 >= 'V' && LA9_6 <= '\uFFFF')) ) {
                                        alt9=1;
                                    }


                                }
                                else if ( ((LA9_5 >= '\u0000' && LA9_5 <= '^')||(LA9_5 >= '`' && LA9_5 <= '\uFFFF')) ) {
                                    alt9=1;
                                }


                            }
                            else if ( ((LA9_4 >= '\u0000' && LA9_4 <= 'C')||(LA9_4 >= 'E' && LA9_4 <= '\uFFFF')) ) {
                                alt9=1;
                            }


                        }
                        else if ( ((LA9_3 >= '\u0000' && LA9_3 <= 'M')||(LA9_3 >= 'O' && LA9_3 <= '\uFFFF')) ) {
                            alt9=1;
                        }


                    }
                    else if ( ((LA9_1 >= '\u0000' && LA9_1 <= 'D')||(LA9_1 >= 'F' && LA9_1 <= '\uFFFF')) ) {
                        alt9=1;
                    }


                }
                else if ( ((LA9_0 >= '\u0000' && LA9_0 <= '#')||(LA9_0 >= '%' && LA9_0 <= '\uFFFF')) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // com/lambda/impex/ast/Impex.g:383:23: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);


            match("$END_USERRIGHTS"); 



            // com/lambda/impex/ast/Impex.g:383:44: ( Semicolon | Ws )*
            loop10:
            do {
                int alt10=3;
                switch ( input.LA(1) ) {
                case ';':
                    {
                    alt10=1;
                    }
                    break;
                case '\t':
                case ' ':
                    {
                    alt10=2;
                    }
                    break;

                }

                switch (alt10) {
            	case 1 :
            	    // com/lambda/impex/ast/Impex.g:383:45: Semicolon
            	    {
            	    mSemicolon(); 


            	    }
            	    break;
            	case 2 :
            	    // com/lambda/impex/ast/Impex.g:383:57: Ws
            	    {
            	    mWs(); 


            	    }
            	    break;

            	default :
            	    break loop10;
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
            // com/lambda/impex/ast/Impex.g:386:2: ( ( ( '#%' (~ ( '\\r' | '\\n' ) )* | '\"#%' (~ ( '\"' ) | '\"' '\"' )* '\"' ) ( Lb )? ) )
            // com/lambda/impex/ast/Impex.g:386:3: ( ( '#%' (~ ( '\\r' | '\\n' ) )* | '\"#%' (~ ( '\"' ) | '\"' '\"' )* '\"' ) ( Lb )? )
            {
            // com/lambda/impex/ast/Impex.g:386:3: ( ( '#%' (~ ( '\\r' | '\\n' ) )* | '\"#%' (~ ( '\"' ) | '\"' '\"' )* '\"' ) ( Lb )? )
            // com/lambda/impex/ast/Impex.g:386:4: ( '#%' (~ ( '\\r' | '\\n' ) )* | '\"#%' (~ ( '\"' ) | '\"' '\"' )* '\"' ) ( Lb )?
            {
            // com/lambda/impex/ast/Impex.g:386:4: ( '#%' (~ ( '\\r' | '\\n' ) )* | '\"#%' (~ ( '\"' ) | '\"' '\"' )* '\"' )
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
                    // com/lambda/impex/ast/Impex.g:386:5: '#%' (~ ( '\\r' | '\\n' ) )*
                    {
                    match("#%"); 



                    // com/lambda/impex/ast/Impex.g:386:10: (~ ( '\\r' | '\\n' ) )*
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
                    // com/lambda/impex/ast/Impex.g:386:28: '\"#%' (~ ( '\"' ) | '\"' '\"' )* '\"'
                    {
                    match("\"#%"); 



                    // com/lambda/impex/ast/Impex.g:386:34: (~ ( '\"' ) | '\"' '\"' )*
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
                    	    // com/lambda/impex/ast/Impex.g:386:35: ~ ( '\"' )
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
                    	    // com/lambda/impex/ast/Impex.g:386:44: '\"' '\"'
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


            // com/lambda/impex/ast/Impex.g:386:59: ( Lb )?
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
                    // com/lambda/impex/ast/Impex.g:386:59: Lb
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
            // com/lambda/impex/ast/Impex.g:389:2: ( '@' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // com/lambda/impex/ast/Impex.g:389:3: '@' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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


            // com/lambda/impex/ast/Impex.g:389:39: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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
            // com/lambda/impex/ast/Impex.g:392:2: ( '&' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // com/lambda/impex/ast/Impex.g:392:3: '&' ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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


            // com/lambda/impex/ast/Impex.g:392:39: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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
            // com/lambda/impex/ast/Impex.g:395:2: ( ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )* )
            // com/lambda/impex/ast/Impex.g:395:3: ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
            {
            if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||input.LA(1)=='_'||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
                input.consume();
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;
            }


            // com/lambda/impex/ast/Impex.g:395:35: ( 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' | '_' )*
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

    // $ANTLR start "Comment"
    public final void mComment() throws RecognitionException {
        try {
            int _type = Comment;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // com/lambda/impex/ast/Impex.g:399:2: ( '#' (~ ( '\\r' | '\\n' ) )* ( Lb )? )
            // com/lambda/impex/ast/Impex.g:399:3: '#' (~ ( '\\r' | '\\n' ) )* ( Lb )?
            {
            match('#'); 

            // com/lambda/impex/ast/Impex.g:399:7: (~ ( '\\r' | '\\n' ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0 >= '\u0000' && LA18_0 <= '\t')||(LA18_0 >= '\u000B' && LA18_0 <= '\f')||(LA18_0 >= '\u000E' && LA18_0 <= '\uFFFF')) ) {
                    alt18=1;
                }


                switch (alt18) {
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
            	    break loop18;
                }
            } while (true);


            // com/lambda/impex/ast/Impex.g:399:23: ( Lb )?
            int alt19=2;
            switch ( input.LA(1) ) {
                case '\n':
                case '\r':
                    {
                    alt19=1;
                    }
                    break;
            }

            switch (alt19) {
                case 1 :
                    // com/lambda/impex/ast/Impex.g:399:23: Lb
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
            // com/lambda/impex/ast/Impex.g:412:2: ({...}? => ';' ( Ws )* '\"' (~ '\"' | '\"' '\"' )* '\"' |)
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
                    // com/lambda/impex/ast/Impex.g:412:3: {...}? => ';' ( Ws )* '\"' (~ '\"' | '\"' '\"' )* '\"'
                    {
                    if ( !((isHeader() == false)) ) {
                        throw new FailedPredicateException(input, "QuotedField", "isHeader() == false");
                    }

                    match(';'); 

                    // com/lambda/impex/ast/Impex.g:412:32: ( Ws )*
                    loop20:
                    do {
                        int alt20=2;
                        switch ( input.LA(1) ) {
                        case '\t':
                        case ' ':
                            {
                            alt20=1;
                            }
                            break;

                        }

                        switch (alt20) {
                    	case 1 :
                    	    // com/lambda/impex/ast/Impex.g:412:32: Ws
                    	    {
                    	    mWs(); 


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    match('\"'); 

                    // com/lambda/impex/ast/Impex.g:412:40: (~ '\"' | '\"' '\"' )*
                    loop21:
                    do {
                        int alt21=3;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0=='\"') ) {
                            switch ( input.LA(2) ) {
                            case '\"':
                                {
                                alt21=2;
                                }
                                break;

                            }

                        }
                        else if ( ((LA21_0 >= '\u0000' && LA21_0 <= '!')||(LA21_0 >= '#' && LA21_0 <= '\uFFFF')) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // com/lambda/impex/ast/Impex.g:412:41: ~ '\"'
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
                    	    // com/lambda/impex/ast/Impex.g:412:48: '\"' '\"'
                    	    {
                    	    match('\"'); 

                    	    match('\"'); 

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
                    // com/lambda/impex/ast/Impex.g:412:78: 
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
            // com/lambda/impex/ast/Impex.g:419:2: ({...}? => ( ';' ( Char | Separator )* ) |)
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
                    // com/lambda/impex/ast/Impex.g:419:3: {...}? => ( ';' ( Char | Separator )* )
                    {
                    if ( !((isHeader() == false)) ) {
                        throw new FailedPredicateException(input, "Field", "isHeader() == false");
                    }

                    // com/lambda/impex/ast/Impex.g:419:28: ( ';' ( Char | Separator )* )
                    // com/lambda/impex/ast/Impex.g:419:29: ';' ( Char | Separator )*
                    {
                    match(';'); 

                    // com/lambda/impex/ast/Impex.g:419:33: ( Char | Separator )*
                    loop23:
                    do {
                        int alt23=3;
                        alt23 = dfa23.predict(input);
                        switch (alt23) {
                    	case 1 :
                    	    // com/lambda/impex/ast/Impex.g:419:34: Char
                    	    {
                    	    mChar(); 


                    	    }
                    	    break;
                    	case 2 :
                    	    // com/lambda/impex/ast/Impex.g:419:40: Separator
                    	    {
                    	    mSeparator(); 


                    	    }
                    	    break;

                    	default :
                    	    break loop23;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // com/lambda/impex/ast/Impex.g:419:68: 
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
            // com/lambda/impex/ast/Impex.g:422:3: ( ( ' ' | '\\t' ) )
            // com/lambda/impex/ast/Impex.g:422:4: ( ' ' | '\\t' )
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
            // com/lambda/impex/ast/Impex.g:424:4: ( ( ( '\\r' )? '\\n' | '\\r' ) )
            // com/lambda/impex/ast/Impex.g:424:5: ( ( '\\r' )? '\\n' | '\\r' )
            {
            // com/lambda/impex/ast/Impex.g:424:5: ( ( '\\r' )? '\\n' | '\\r' )
            int alt26=2;
            switch ( input.LA(1) ) {
            case '\r':
                {
                switch ( input.LA(2) ) {
                case '\n':
                    {
                    alt26=1;
                    }
                    break;
                default:
                    alt26=2;
                }

                }
                break;
            case '\n':
                {
                alt26=1;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;

            }

            switch (alt26) {
                case 1 :
                    // com/lambda/impex/ast/Impex.g:424:6: ( '\\r' )? '\\n'
                    {
                    // com/lambda/impex/ast/Impex.g:424:6: ( '\\r' )?
                    int alt25=2;
                    switch ( input.LA(1) ) {
                        case '\r':
                            {
                            alt25=1;
                            }
                            break;
                    }

                    switch (alt25) {
                        case 1 :
                            // com/lambda/impex/ast/Impex.g:424:6: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }


                    match('\n'); 

                    }
                    break;
                case 2 :
                    // com/lambda/impex/ast/Impex.g:424:19: '\\r'
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
            // com/lambda/impex/ast/Impex.g:426:2: (~ ( '\\r' | '\\n' | '\"' | ';' ) )
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
        // com/lambda/impex/ast/Impex.g:1:8: ( Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual | Comma | Dot | DoubleQuote | Quote | Semicolon | RBracket | LBracket | LParenthesis | RParenthesis | Equals | Or | Macrodef | ValueAssignment | UserRights | BeanShell | SpecialAttribute | DocumentID | Identifier | Comment | QuotedField | Field | Ws | Lb | Char )
        int alt27=50;
        alt27 = dfa27.predict(input);
        switch (alt27) {
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
                // com/lambda/impex/ast/Impex.g:1:373: Macrodef
                {
                mMacrodef(); 


                }
                break;
            case 39 :
                // com/lambda/impex/ast/Impex.g:1:382: ValueAssignment
                {
                mValueAssignment(); 


                }
                break;
            case 40 :
                // com/lambda/impex/ast/Impex.g:1:398: UserRights
                {
                mUserRights(); 


                }
                break;
            case 41 :
                // com/lambda/impex/ast/Impex.g:1:409: BeanShell
                {
                mBeanShell(); 


                }
                break;
            case 42 :
                // com/lambda/impex/ast/Impex.g:1:419: SpecialAttribute
                {
                mSpecialAttribute(); 


                }
                break;
            case 43 :
                // com/lambda/impex/ast/Impex.g:1:436: DocumentID
                {
                mDocumentID(); 


                }
                break;
            case 44 :
                // com/lambda/impex/ast/Impex.g:1:447: Identifier
                {
                mIdentifier(); 


                }
                break;
            case 45 :
                // com/lambda/impex/ast/Impex.g:1:458: Comment
                {
                mComment(); 


                }
                break;
            case 46 :
                // com/lambda/impex/ast/Impex.g:1:466: QuotedField
                {
                mQuotedField(); 


                }
                break;
            case 47 :
                // com/lambda/impex/ast/Impex.g:1:478: Field
                {
                mField(); 


                }
                break;
            case 48 :
                // com/lambda/impex/ast/Impex.g:1:484: Ws
                {
                mWs(); 


                }
                break;
            case 49 :
                // com/lambda/impex/ast/Impex.g:1:487: Lb
                {
                mLb(); 


                }
                break;
            case 50 :
                // com/lambda/impex/ast/Impex.g:1:490: Char
                {
                mChar(); 


                }
                break;

        }

    }


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA7 dfa7 = new DFA7(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA27 dfa27 = new DFA27(this);
    static final String DFA3_eotS =
        "\1\1\1\uffff\1\3\1\uffff\1\3\1\uffff";
    static final String DFA3_eofS =
        "\6\uffff";
    static final String DFA3_minS =
        "\1\0\1\uffff\1\11\1\uffff\1\11\1\uffff";
    static final String DFA3_maxS =
        "\1\uffff\1\uffff\1\40\1\uffff\1\40\1\uffff";
    static final String DFA3_acceptS =
        "\1\uffff\1\3\1\uffff\1\1\1\uffff\1\2";
    static final String DFA3_specialS =
        "\1\0\5\uffff}>";
    static final String[] DFA3_transitionS = {
            "\12\3\1\uffff\2\3\1\uffff\116\3\1\2\uffa3\3",
            "",
            "\1\4\1\5\2\uffff\1\5\22\uffff\1\4",
            "",
            "\1\4\1\5\2\uffff\1\5\22\uffff\1\4",
            ""
    };

    static final short[] DFA3_eot = DFA.unpackEncodedString(DFA3_eotS);
    static final short[] DFA3_eof = DFA.unpackEncodedString(DFA3_eofS);
    static final char[] DFA3_min = DFA.unpackEncodedStringToUnsignedChars(DFA3_minS);
    static final char[] DFA3_max = DFA.unpackEncodedStringToUnsignedChars(DFA3_maxS);
    static final short[] DFA3_accept = DFA.unpackEncodedString(DFA3_acceptS);
    static final short[] DFA3_special = DFA.unpackEncodedString(DFA3_specialS);
    static final short[][] DFA3_transition;

    static {
        int numStates = DFA3_transitionS.length;
        DFA3_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA3_transition[i] = DFA.unpackEncodedString(DFA3_transitionS[i]);
        }
    }

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = DFA3_eot;
            this.eof = DFA3_eof;
            this.min = DFA3_min;
            this.max = DFA3_max;
            this.accept = DFA3_accept;
            this.special = DFA3_special;
            this.transition = DFA3_transition;
        }
        public String getDescription() {
            return "()* loopback of 377:34: (~ ( '\\r' | '\\n' ) | Separator )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA3_0 = input.LA(1);

                        s = -1;
                        if ( (LA3_0=='\\') ) {s = 2;}

                        else if ( ((LA3_0 >= '\u0000' && LA3_0 <= '\t')||(LA3_0 >= '\u000B' && LA3_0 <= '\f')||(LA3_0 >= '\u000E' && LA3_0 <= '[')||(LA3_0 >= ']' && LA3_0 <= '\uFFFF')) ) {s = 3;}

                        else s = 1;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 3, _s, input);
            error(nvae);
            throw nvae;
        }

    }
    static final String DFA7_eotS =
        "\2\3\2\uffff";
    static final String DFA7_eofS =
        "\4\uffff";
    static final String DFA7_minS =
        "\2\11\2\uffff";
    static final String DFA7_maxS =
        "\2\42\2\uffff";
    static final String DFA7_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA7_specialS =
        "\4\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\1\26\uffff\1\1\1\uffff\1\2",
            "\1\1\26\uffff\1\1\1\uffff\1\2",
            "",
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
            return "378:36: ( ( ' ' | '\\t' )* '\"' (~ ( '\\r' | '\\n' | '\"' ) | '\"' '\"' )* '\"' | (~ ( '\\r' | '\\n' | ';' | '\"' | '[' | ']' | ',' ) )* )";
        }
    }
    static final String DFA23_eotS =
        "\1\1\1\uffff\1\3\1\uffff\1\3\1\uffff";
    static final String DFA23_eofS =
        "\6\uffff";
    static final String DFA23_minS =
        "\1\0\1\uffff\1\11\1\uffff\1\11\1\uffff";
    static final String DFA23_maxS =
        "\1\uffff\1\uffff\1\40\1\uffff\1\40\1\uffff";
    static final String DFA23_acceptS =
        "\1\uffff\1\3\1\uffff\1\1\1\uffff\1\2";
    static final String DFA23_specialS =
        "\1\0\5\uffff}>";
    static final String[] DFA23_transitionS = {
            "\12\3\1\uffff\2\3\1\uffff\24\3\1\uffff\30\3\1\uffff\40\3\1\2"+
            "\uffa3\3",
            "",
            "\1\4\1\5\2\uffff\1\5\22\uffff\1\4",
            "",
            "\1\4\1\5\2\uffff\1\5\22\uffff\1\4",
            ""
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "()* loopback of 419:33: ( Char | Separator )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA23_0 = input.LA(1);

                        s = -1;
                        if ( (LA23_0=='\\') ) {s = 2;}

                        else if ( ((LA23_0 >= '\u0000' && LA23_0 <= '\t')||(LA23_0 >= '\u000B' && LA23_0 <= '\f')||(LA23_0 >= '\u000E' && LA23_0 <= '!')||(LA23_0 >= '#' && LA23_0 <= ':')||(LA23_0 >= '<' && LA23_0 <= '[')||(LA23_0 >= ']' && LA23_0 <= '\uFFFF')) ) {s = 3;}

                        else s = 1;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 23, _s, input);
            error(nvae);
            throw nvae;
        }

    }
    static final String DFA27_eotS =
        "\1\34\17\46\2\uffff\1\77\1\uffff\1\101\4\uffff\1\111\1\uffff\1\43"+
        "\1\uffff\1\120\2\43\4\uffff\2\46\1\uffff\25\46\6\uffff\1\104\12"+
        "\uffff\1\116\1\uffff\1\76\4\uffff\13\46\1\174\14\46\1\uffff\1\116"+
        "\2\76\1\uffff\13\46\1\uffff\6\46\1\u009b\1\uffff\1\u009c\3\46\1"+
        "\116\12\46\1\uffff\1\u00ab\5\46\2\uffff\3\46\1\116\1\u00b6\1\46"+
        "\1\u00b9\1\u00ba\1\u00bb\5\46\1\uffff\10\46\1\116\1\46\1\uffff\2"+
        "\46\3\uffff\7\46\1\u00d4\4\46\1\u00d9\1\116\12\46\1\uffff\4\46\1"+
        "\uffff\1\116\3\46\1\u00ed\3\46\1\u00f1\1\u00f2\5\46\1\116\2\46\1"+
        "\u00fb\1\uffff\3\46\2\uffff\1\u00ff\1\u0100\1\uffff\1\46\1\u0102"+
        "\1\116\2\46\1\uffff\1\u0106\1\46\3\uffff\1\46\1\uffff\1\116\2\46"+
        "\1\uffff\1\46\1\u010d\1\116\1\u010f\1\u0110\1\u0111\1\uffff\1\116"+
        "\3\uffff\4\116\1\uffff\1\116";
    static final String DFA27_eofS =
        "\u0118\uffff";
    static final String DFA27_minS =
        "\1\0\1\107\1\116\1\105\3\101\1\114\1\101\1\117\1\105\2\101\1\125"+
        "\1\122\1\111\2\uffff\1\43\1\uffff\1\0\4\uffff\1\0\1\uffff\1\101"+
        "\1\uffff\1\45\2\101\4\uffff\1\123\1\116\1\uffff\1\104\1\111\1\115"+
        "\1\124\1\103\2\114\1\117\1\124\1\123\1\111\1\124\1\106\1\122\1\131"+
        "\1\116\1\120\1\104\1\115\1\101\1\122\5\uffff\1\0\1\11\12\uffff\1"+
        "\124\1\uffff\1\0\4\uffff\1\105\1\117\1\101\1\121\1\117\1\103\1\110"+
        "\2\114\1\103\1\110\1\60\1\101\1\117\1\105\1\101\1\103\1\62\1\107"+
        "\1\55\1\105\1\102\1\116\1\124\1\uffff\1\101\1\0\1\12\1\uffff\2\122"+
        "\1\124\1\125\1\126\1\110\1\105\1\104\2\105\1\55\1\uffff\1\123\1"+
        "\127\1\106\1\125\1\105\1\126\1\60\1\uffff\1\60\1\105\1\123\1\125"+
        "\1\122\1\124\4\105\1\115\1\125\1\105\1\103\1\123\1\uffff\1\60\1"+
        "\116\1\117\1\114\1\127\1\101\2\uffff\1\122\1\114\1\101\1\124\1\60"+
        "\1\113\3\60\1\117\1\116\1\103\1\124\1\123\1\uffff\1\125\1\122\1"+
        "\124\1\122\1\114\1\106\1\101\1\114\1\137\1\125\1\uffff\1\105\1\125"+
        "\3\uffff\1\104\1\111\1\117\1\111\1\117\1\114\1\115\1\60\1\111\1"+
        "\125\1\117\1\124\1\60\1\125\1\120\1\131\1\114\1\105\1\121\1\122"+
        "\1\117\1\122\1\114\1\101\1\uffff\1\124\1\105\1\122\1\117\1\uffff"+
        "\1\123\1\104\1\103\1\114\1\60\1\125\1\101\1\116\2\60\1\124\1\105"+
        "\1\55\1\115\1\122\1\105\2\101\1\60\1\uffff\1\105\1\124\1\55\2\uffff"+
        "\2\60\1\uffff\1\101\1\60\1\122\1\124\1\123\1\uffff\1\60\1\117\3"+
        "\uffff\1\124\1\uffff\1\122\2\105\1\uffff\1\122\1\60\1\111\3\60\1"+
        "\uffff\1\107\3\uffff\1\110\1\124\1\123\1\0\1\uffff\1\0";
    static final String DFA27_maxS =
        "\1\uffff\1\156\1\160\1\145\1\141\1\157\1\162\1\154\1\145\1\157\1"+
        "\145\1\141\1\157\1\165\1\162\1\151\2\uffff\1\43\1\uffff\1\uffff"+
        "\4\uffff\1\uffff\1\uffff\1\172\1\uffff\1\45\2\172\4\uffff\1\163"+
        "\1\156\1\uffff\1\144\1\151\1\155\1\164\1\143\2\154\1\157\1\164\1"+
        "\163\1\154\1\164\1\146\1\162\1\171\1\156\1\160\1\144\1\155\1\141"+
        "\1\162\5\uffff\1\0\1\42\12\uffff\1\124\1\uffff\1\uffff\4\uffff\1"+
        "\145\1\157\1\141\1\161\1\157\1\143\1\150\2\154\1\143\1\150\1\172"+
        "\1\141\1\157\1\145\1\141\1\143\1\62\1\147\1\55\1\145\1\142\1\156"+
        "\1\164\1\uffff\1\101\1\uffff\1\12\1\uffff\2\162\1\164\1\165\1\166"+
        "\1\150\1\145\1\144\2\145\1\55\1\uffff\1\163\1\167\1\146\1\165\1"+
        "\145\1\166\1\172\1\uffff\1\172\1\145\1\163\1\165\1\122\1\164\4\145"+
        "\1\155\1\165\1\145\1\143\1\163\1\uffff\1\172\1\156\1\157\1\154\1"+
        "\167\1\141\2\uffff\1\162\1\154\1\141\1\124\1\172\1\156\3\172\1\157"+
        "\1\156\1\143\1\164\1\163\1\uffff\1\165\1\162\1\164\1\162\1\154\1"+
        "\146\1\141\1\154\1\137\1\165\1\uffff\1\145\1\165\3\uffff\1\144\1"+
        "\151\1\157\1\151\1\157\1\154\1\155\1\172\1\151\1\165\1\157\1\164"+
        "\1\172\1\125\1\160\1\171\1\154\1\145\1\161\1\162\1\157\1\162\1\154"+
        "\1\141\1\uffff\1\164\1\145\1\162\1\157\1\uffff\1\123\1\144\1\143"+
        "\1\154\1\172\1\165\1\141\1\156\2\172\1\164\1\145\1\55\1\155\1\162"+
        "\1\105\2\141\1\172\1\uffff\1\145\1\164\1\55\2\uffff\2\172\1\uffff"+
        "\1\141\1\172\1\122\1\164\1\163\1\uffff\1\172\1\157\3\uffff\1\164"+
        "\1\uffff\1\122\2\145\1\uffff\1\162\1\172\1\111\3\172\1\uffff\1\107"+
        "\3\uffff\1\110\1\124\1\123\1\uffff\1\uffff\1\uffff";
    static final String DFA27_acceptS =
        "\20\uffff\1\33\1\34\1\uffff\1\36\1\uffff\1\40\1\41\1\42\1\43\1\uffff"+
        "\1\45\1\uffff\1\47\3\uffff\1\54\1\60\1\61\1\62\2\uffff\1\54\25\uffff"+
        "\1\33\1\34\1\51\1\35\1\36\2\uffff\1\56\1\57\1\40\1\41\1\42\1\43"+
        "\1\44\2\47\1\45\1\uffff\1\46\1\uffff\1\55\1\52\1\53\1\60\30\uffff"+
        "\1\37\3\uffff\1\51\13\uffff\1\27\7\uffff\1\23\17\uffff\1\26\6\uffff"+
        "\1\22\1\24\16\uffff\1\10\12\uffff\1\1\2\uffff\1\3\1\31\1\4\30\uffff"+
        "\1\15\4\uffff\1\32\23\uffff\1\5\3\uffff\1\7\1\11\2\uffff\1\21\5"+
        "\uffff\1\20\2\uffff\1\13\1\14\1\16\1\uffff\1\30\3\uffff\1\6\6\uffff"+
        "\1\25\1\uffff\1\2\1\17\1\12\4\uffff\1\50\1\uffff";
    static final String DFA27_specialS =
        "\1\4\23\uffff\1\10\4\uffff\1\2\47\uffff\1\7\1\0\14\uffff\1\1\36"+
        "\uffff\1\6\u00a6\uffff\1\5\1\uffff\1\3}>";
    static final String[] DFA27_transitionS = {
            "\11\43\1\41\1\42\2\43\1\42\22\43\1\41\1\43\1\22\1\35\1\33\1"+
            "\43\1\37\1\23\1\27\1\30\2\43\1\20\1\43\1\21\14\43\1\24\1\43"+
            "\1\31\2\43\1\36\1\7\1\4\1\5\1\10\1\40\1\11\2\40\1\1\1\40\1\12"+
            "\1\13\1\14\1\15\1\40\1\6\1\40\1\3\1\40\1\16\1\2\1\17\4\40\1"+
            "\26\1\43\1\25\1\43\1\40\1\43\1\7\1\4\1\5\1\10\1\40\1\11\2\40"+
            "\1\1\1\40\1\12\1\13\1\14\1\15\1\40\1\6\1\40\1\3\1\40\1\16\1"+
            "\2\1\17\4\40\1\43\1\32\uff83\43",
            "\1\45\6\uffff\1\44\30\uffff\1\45\6\uffff\1\44",
            "\1\50\1\uffff\1\47\35\uffff\1\50\1\uffff\1\47",
            "\1\51\37\uffff\1\51",
            "\1\52\37\uffff\1\52",
            "\1\53\3\uffff\1\54\11\uffff\1\55\21\uffff\1\53\3\uffff\1\54"+
            "\11\uffff\1\55",
            "\1\57\15\uffff\1\60\2\uffff\1\56\16\uffff\1\57\15\uffff\1\60"+
            "\2\uffff\1\56",
            "\1\61\37\uffff\1\61",
            "\1\62\3\uffff\1\63\33\uffff\1\62\3\uffff\1\63",
            "\1\64\37\uffff\1\64",
            "\1\65\37\uffff\1\65",
            "\1\66\37\uffff\1\66",
            "\1\67\15\uffff\1\70\21\uffff\1\67\15\uffff\1\70",
            "\1\71\37\uffff\1\71",
            "\1\72\37\uffff\1\72",
            "\1\73\37\uffff\1\73",
            "",
            "",
            "\1\76",
            "",
            "\11\104\1\102\1\uffff\2\104\1\uffff\22\104\1\102\1\104\1\103"+
            "\30\104\1\uffff\uffc4\104",
            "",
            "",
            "",
            "",
            "\12\112\1\uffff\2\112\1\uffff\36\112\1\113\16\112\1\113\37"+
            "\112\1\113\1\112\1\113\uffa2\112",
            "",
            "\22\116\1\115\7\116\4\uffff\1\116\1\uffff\32\116",
            "",
            "\1\117",
            "\32\121\4\uffff\1\121\1\uffff\32\121",
            "\32\122\4\uffff\1\122\1\uffff\32\122",
            "",
            "",
            "",
            "",
            "\1\124\37\uffff\1\124",
            "\1\125\37\uffff\1\125",
            "",
            "\1\126\37\uffff\1\126",
            "\1\127\37\uffff\1\127",
            "\1\130\37\uffff\1\130",
            "\1\131\37\uffff\1\131",
            "\1\132\37\uffff\1\132",
            "\1\133\37\uffff\1\133",
            "\1\134\37\uffff\1\134",
            "\1\135\37\uffff\1\135",
            "\1\136\37\uffff\1\136",
            "\1\137\37\uffff\1\137",
            "\1\140\2\uffff\1\141\34\uffff\1\140\2\uffff\1\141",
            "\1\142\37\uffff\1\142",
            "\1\143\37\uffff\1\143",
            "\1\144\37\uffff\1\144",
            "\1\145\37\uffff\1\145",
            "\1\146\37\uffff\1\146",
            "\1\147\37\uffff\1\147",
            "\1\150\37\uffff\1\150",
            "\1\151\37\uffff\1\151",
            "\1\152\37\uffff\1\152",
            "\1\153\37\uffff\1\153",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "\1\102\26\uffff\1\102\1\uffff\1\103",
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
            "\1\155",
            "",
            "\12\156\1\160\2\156\1\157\ufff2\156",
            "",
            "",
            "",
            "",
            "\1\161\37\uffff\1\161",
            "\1\162\37\uffff\1\162",
            "\1\163\37\uffff\1\163",
            "\1\164\37\uffff\1\164",
            "\1\165\37\uffff\1\165",
            "\1\166\37\uffff\1\166",
            "\1\167\37\uffff\1\167",
            "\1\170\37\uffff\1\170",
            "\1\171\37\uffff\1\171",
            "\1\172\37\uffff\1\172",
            "\1\173\37\uffff\1\173",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\175\37\uffff\1\175",
            "\1\176\37\uffff\1\176",
            "\1\177\37\uffff\1\177",
            "\1\u0080\37\uffff\1\u0080",
            "\1\u0081\37\uffff\1\u0081",
            "\1\u0082",
            "\1\u0083\37\uffff\1\u0083",
            "\1\u0084",
            "\1\u0085\37\uffff\1\u0085",
            "\1\u0086\37\uffff\1\u0086",
            "\1\u0087\37\uffff\1\u0087",
            "\1\u0088\37\uffff\1\u0088",
            "",
            "\1\u0089",
            "\12\156\1\160\2\156\1\157\ufff2\156",
            "\1\160",
            "",
            "\1\u008a\37\uffff\1\u008a",
            "\1\u008b\37\uffff\1\u008b",
            "\1\u008c\37\uffff\1\u008c",
            "\1\u008d\37\uffff\1\u008d",
            "\1\u008e\37\uffff\1\u008e",
            "\1\u008f\37\uffff\1\u008f",
            "\1\u0090\37\uffff\1\u0090",
            "\1\u0091\37\uffff\1\u0091",
            "\1\u0092\37\uffff\1\u0092",
            "\1\u0093\37\uffff\1\u0093",
            "\1\u0094",
            "",
            "\1\u0095\37\uffff\1\u0095",
            "\1\u0096\37\uffff\1\u0096",
            "\1\u0097\37\uffff\1\u0097",
            "\1\u0098\37\uffff\1\u0098",
            "\1\u0099\37\uffff\1\u0099",
            "\1\u009a\37\uffff\1\u009a",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u009d\37\uffff\1\u009d",
            "\1\u009e\37\uffff\1\u009e",
            "\1\u009f\37\uffff\1\u009f",
            "\1\u00a0",
            "\1\u00a1\37\uffff\1\u00a1",
            "\1\u00a2\37\uffff\1\u00a2",
            "\1\u00a3\37\uffff\1\u00a3",
            "\1\u00a4\37\uffff\1\u00a4",
            "\1\u00a5\37\uffff\1\u00a5",
            "\1\u00a6\37\uffff\1\u00a6",
            "\1\u00a7\37\uffff\1\u00a7",
            "\1\u00a8\37\uffff\1\u00a8",
            "\1\u00a9\37\uffff\1\u00a9",
            "\1\u00aa\37\uffff\1\u00aa",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00ac\37\uffff\1\u00ac",
            "\1\u00ad\37\uffff\1\u00ad",
            "\1\u00ae\37\uffff\1\u00ae",
            "\1\u00af\37\uffff\1\u00af",
            "\1\u00b0\37\uffff\1\u00b0",
            "",
            "",
            "\1\u00b1\37\uffff\1\u00b1",
            "\1\u00b2\37\uffff\1\u00b2",
            "\1\u00b3\37\uffff\1\u00b3",
            "\1\u00b4",
            "\12\46\7\uffff\32\46\4\uffff\1\u00b5\1\uffff\32\46",
            "\1\u00b7\2\uffff\1\u00b8\34\uffff\1\u00b7\2\uffff\1\u00b8",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00bc\37\uffff\1\u00bc",
            "\1\u00bd\37\uffff\1\u00bd",
            "\1\u00be\37\uffff\1\u00be",
            "\1\u00bf\37\uffff\1\u00bf",
            "\1\u00c0\37\uffff\1\u00c0",
            "",
            "\1\u00c1\37\uffff\1\u00c1",
            "\1\u00c2\37\uffff\1\u00c2",
            "\1\u00c3\37\uffff\1\u00c3",
            "\1\u00c4\37\uffff\1\u00c4",
            "\1\u00c5\37\uffff\1\u00c5",
            "\1\u00c6\37\uffff\1\u00c6",
            "\1\u00c7\37\uffff\1\u00c7",
            "\1\u00c8\37\uffff\1\u00c8",
            "\1\u00c9",
            "\1\u00ca\37\uffff\1\u00ca",
            "",
            "\1\u00cb\37\uffff\1\u00cb",
            "\1\u00cc\37\uffff\1\u00cc",
            "",
            "",
            "",
            "\1\u00cd\37\uffff\1\u00cd",
            "\1\u00ce\37\uffff\1\u00ce",
            "\1\u00cf\37\uffff\1\u00cf",
            "\1\u00d0\37\uffff\1\u00d0",
            "\1\u00d1\37\uffff\1\u00d1",
            "\1\u00d2\37\uffff\1\u00d2",
            "\1\u00d3\37\uffff\1\u00d3",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00d5\37\uffff\1\u00d5",
            "\1\u00d6\37\uffff\1\u00d6",
            "\1\u00d7\37\uffff\1\u00d7",
            "\1\u00d8\37\uffff\1\u00d8",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00da",
            "\1\u00db\37\uffff\1\u00db",
            "\1\u00dc\37\uffff\1\u00dc",
            "\1\u00dd\37\uffff\1\u00dd",
            "\1\u00de\37\uffff\1\u00de",
            "\1\u00df\37\uffff\1\u00df",
            "\1\u00e0\37\uffff\1\u00e0",
            "\1\u00e1\37\uffff\1\u00e1",
            "\1\u00e2\37\uffff\1\u00e2",
            "\1\u00e3\37\uffff\1\u00e3",
            "\1\u00e4\37\uffff\1\u00e4",
            "",
            "\1\u00e5\37\uffff\1\u00e5",
            "\1\u00e6\37\uffff\1\u00e6",
            "\1\u00e7\37\uffff\1\u00e7",
            "\1\u00e8\37\uffff\1\u00e8",
            "",
            "\1\u00e9",
            "\1\u00ea\37\uffff\1\u00ea",
            "\1\u00eb\37\uffff\1\u00eb",
            "\1\u00ec\37\uffff\1\u00ec",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00ee\37\uffff\1\u00ee",
            "\1\u00ef\37\uffff\1\u00ef",
            "\1\u00f0\37\uffff\1\u00f0",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u00f3\37\uffff\1\u00f3",
            "\1\u00f4\37\uffff\1\u00f4",
            "\1\u00f5",
            "\1\u00f6\37\uffff\1\u00f6",
            "\1\u00f7\37\uffff\1\u00f7",
            "\1\u00f8",
            "\1\u00f9\37\uffff\1\u00f9",
            "\1\u00fa\37\uffff\1\u00fa",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "\1\u00fc\37\uffff\1\u00fc",
            "\1\u00fd\37\uffff\1\u00fd",
            "\1\u00fe",
            "",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "\1\u0101\37\uffff\1\u0101",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u0103",
            "\1\u0104\37\uffff\1\u0104",
            "\1\u0105\37\uffff\1\u0105",
            "",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u0107\37\uffff\1\u0107",
            "",
            "",
            "",
            "\1\u0108\37\uffff\1\u0108",
            "",
            "\1\u0109",
            "\1\u010a\37\uffff\1\u010a",
            "\1\u010b\37\uffff\1\u010b",
            "",
            "\1\u010c\37\uffff\1\u010c",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\1\u010e",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "\12\46\7\uffff\32\46\4\uffff\1\46\1\uffff\32\46",
            "",
            "\1\u0112",
            "",
            "",
            "",
            "\1\u0113",
            "\1\u0114",
            "\1\u0115",
            "\60\u0116\12\u0117\7\u0116\32\u0117\4\u0116\1\u0117\1\u0116"+
            "\32\u0117\uff85\u0116",
            "",
            "\60\u0116\12\u0117\7\u0116\32\u0117\4\u0116\1\u0117\1\u0116"+
            "\32\u0117\uff85\u0116"
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
            return "1:1: Tokens : ( Insert | InsertUpdate | Update | Remove | BatchMode | CacheUnique | Processor | Alias | AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull | KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual | Comma | Dot | DoubleQuote | Quote | Semicolon | RBracket | LBracket | LParenthesis | RParenthesis | Equals | Or | Macrodef | ValueAssignment | UserRights | BeanShell | SpecialAttribute | DocumentID | Identifier | Comment | QuotedField | Field | Ws | Lb | Char );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA27_66 = input.LA(1);

                         
                        int index27_66 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA27_66=='\"') && ((isHeader() == false))) {s = 67;}

                        else if ( (LA27_66=='\t'||LA27_66==' ') && ((isHeader() == false))) {s = 66;}

                        else s = 68;

                         
                        input.seek(index27_66);

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA27_79 = input.LA(1);

                        s = -1;
                        if ( ((LA27_79 >= '\u0000' && LA27_79 <= '\t')||(LA27_79 >= '\u000B' && LA27_79 <= '\f')||(LA27_79 >= '\u000E' && LA27_79 <= '\uFFFF')) ) {s = 110;}

                        else if ( (LA27_79=='\r') ) {s = 111;}

                        else if ( (LA27_79=='\n') ) {s = 112;}

                        else s = 62;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA27_25 = input.LA(1);

                         
                        int index27_25 = input.index();
                        input.rewind();

                        s = -1;
                        if ( ((LA27_25 >= '\u0000' && LA27_25 <= '\t')||(LA27_25 >= '\u000B' && LA27_25 <= '\f')||(LA27_25 >= '\u000E' && LA27_25 <= '+')||(LA27_25 >= '-' && LA27_25 <= ':')||(LA27_25 >= '<' && LA27_25 <= 'Z')||LA27_25=='\\'||(LA27_25 >= '^' && LA27_25 <= '\uFFFF')) && (((isModifierAssignment())||(isMacroAssignment())))) {s = 74;}

                        else if ( (LA27_25==','||LA27_25==';'||LA27_25=='['||LA27_25==']') && ((isMacroAssignment()))) {s = 75;}

                        else s = 73;

                         
                        input.seek(index27_25);

                        if ( s>=0 ) return s;
                        break;
                    case 3 : 
                        int LA27_279 = input.LA(1);

                        s = -1;
                        if ( ((LA27_279 >= '\u0000' && LA27_279 <= '/')||(LA27_279 >= ':' && LA27_279 <= '@')||(LA27_279 >= '[' && LA27_279 <= '^')||LA27_279=='`'||(LA27_279 >= '{' && LA27_279 <= '\uFFFF')) ) {s = 278;}

                        else if ( ((LA27_279 >= '0' && LA27_279 <= '9')||(LA27_279 >= 'A' && LA27_279 <= 'Z')||LA27_279=='_'||(LA27_279 >= 'a' && LA27_279 <= 'z')) ) {s = 279;}

                        else s = 78;

                        if ( s>=0 ) return s;
                        break;
                    case 4 : 
                        int LA27_0 = input.LA(1);

                        s = -1;
                        if ( (LA27_0=='I'||LA27_0=='i') ) {s = 1;}

                        else if ( (LA27_0=='U'||LA27_0=='u') ) {s = 2;}

                        else if ( (LA27_0=='R'||LA27_0=='r') ) {s = 3;}

                        else if ( (LA27_0=='B'||LA27_0=='b') ) {s = 4;}

                        else if ( (LA27_0=='C'||LA27_0=='c') ) {s = 5;}

                        else if ( (LA27_0=='P'||LA27_0=='p') ) {s = 6;}

                        else if ( (LA27_0=='A'||LA27_0=='a') ) {s = 7;}

                        else if ( (LA27_0=='D'||LA27_0=='d') ) {s = 8;}

                        else if ( (LA27_0=='F'||LA27_0=='f') ) {s = 9;}

                        else if ( (LA27_0=='K'||LA27_0=='k') ) {s = 10;}

                        else if ( (LA27_0=='L'||LA27_0=='l') ) {s = 11;}

                        else if ( (LA27_0=='M'||LA27_0=='m') ) {s = 12;}

                        else if ( (LA27_0=='N'||LA27_0=='n') ) {s = 13;}

                        else if ( (LA27_0=='T'||LA27_0=='t') ) {s = 14;}

                        else if ( (LA27_0=='V'||LA27_0=='v') ) {s = 15;}

                        else if ( (LA27_0==',') ) {s = 16;}

                        else if ( (LA27_0=='.') ) {s = 17;}

                        else if ( (LA27_0=='\"') ) {s = 18;}

                        else if ( (LA27_0=='\'') ) {s = 19;}

                        else if ( (LA27_0==';') ) {s = 20;}

                        else if ( (LA27_0==']') ) {s = 21;}

                        else if ( (LA27_0=='[') ) {s = 22;}

                        else if ( (LA27_0=='(') ) {s = 23;}

                        else if ( (LA27_0==')') ) {s = 24;}

                        else if ( (LA27_0=='=') ) {s = 25;}

                        else if ( (LA27_0=='|') ) {s = 26;}

                        else if ( (LA27_0=='$') ) {s = 27;}

                        else if ( (LA27_0=='#') ) {s = 29;}

                        else if ( (LA27_0=='@') ) {s = 30;}

                        else if ( (LA27_0=='&') ) {s = 31;}

                        else if ( (LA27_0=='E'||(LA27_0 >= 'G' && LA27_0 <= 'H')||LA27_0=='J'||LA27_0=='O'||LA27_0=='Q'||LA27_0=='S'||(LA27_0 >= 'W' && LA27_0 <= 'Z')||LA27_0=='_'||LA27_0=='e'||(LA27_0 >= 'g' && LA27_0 <= 'h')||LA27_0=='j'||LA27_0=='o'||LA27_0=='q'||LA27_0=='s'||(LA27_0 >= 'w' && LA27_0 <= 'z')) ) {s = 32;}

                        else if ( (LA27_0=='\t'||LA27_0==' ') ) {s = 33;}

                        else if ( (LA27_0=='\n'||LA27_0=='\r') ) {s = 34;}

                        else if ( ((LA27_0 >= '\u0000' && LA27_0 <= '\b')||(LA27_0 >= '\u000B' && LA27_0 <= '\f')||(LA27_0 >= '\u000E' && LA27_0 <= '\u001F')||LA27_0=='!'||LA27_0=='%'||(LA27_0 >= '*' && LA27_0 <= '+')||LA27_0=='-'||(LA27_0 >= '/' && LA27_0 <= ':')||LA27_0=='<'||(LA27_0 >= '>' && LA27_0 <= '?')||LA27_0=='\\'||LA27_0=='^'||LA27_0=='`'||LA27_0=='{'||(LA27_0 >= '}' && LA27_0 <= '\uFFFF')) ) {s = 35;}

                        else s = 28;

                        if ( s>=0 ) return s;
                        break;
                    case 5 : 
                        int LA27_277 = input.LA(1);

                        s = -1;
                        if ( ((LA27_277 >= '\u0000' && LA27_277 <= '/')||(LA27_277 >= ':' && LA27_277 <= '@')||(LA27_277 >= '[' && LA27_277 <= '^')||LA27_277=='`'||(LA27_277 >= '{' && LA27_277 <= '\uFFFF')) ) {s = 278;}

                        else if ( ((LA27_277 >= '0' && LA27_277 <= '9')||(LA27_277 >= 'A' && LA27_277 <= 'Z')||LA27_277=='_'||(LA27_277 >= 'a' && LA27_277 <= 'z')) ) {s = 279;}

                        else s = 78;

                        if ( s>=0 ) return s;
                        break;
                    case 6 : 
                        int LA27_110 = input.LA(1);

                        s = -1;
                        if ( (LA27_110=='\r') ) {s = 111;}

                        else if ( (LA27_110=='\n') ) {s = 112;}

                        else if ( ((LA27_110 >= '\u0000' && LA27_110 <= '\t')||(LA27_110 >= '\u000B' && LA27_110 <= '\f')||(LA27_110 >= '\u000E' && LA27_110 <= '\uFFFF')) ) {s = 110;}

                        else s = 62;

                        if ( s>=0 ) return s;
                        break;
                    case 7 : 
                        int LA27_65 = input.LA(1);

                         
                        int index27_65 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (!(((isHeader() == false)))) ) {s = 108;}

                        else if ( ((isHeader() == false)) ) {s = 68;}

                         
                        input.seek(index27_65);

                        if ( s>=0 ) return s;
                        break;
                    case 8 : 
                        int LA27_20 = input.LA(1);

                         
                        int index27_20 = input.index();
                        input.rewind();

                        s = -1;
                        if ( (LA27_20=='\t'||LA27_20==' ') && ((isHeader() == false))) {s = 66;}

                        else if ( (LA27_20=='\"') && ((isHeader() == false))) {s = 67;}

                        else if ( ((LA27_20 >= '\u0000' && LA27_20 <= '\b')||(LA27_20 >= '\u000B' && LA27_20 <= '\f')||(LA27_20 >= '\u000E' && LA27_20 <= '\u001F')||LA27_20=='!'||(LA27_20 >= '#' && LA27_20 <= ':')||(LA27_20 >= '<' && LA27_20 <= '\uFFFF')) && ((isHeader() == false))) {s = 68;}

                        else s = 65;

                         
                        input.seek(index27_20);

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 27, _s, input);
            error(nvae);
            throw nvae;
        }

    }
 

}