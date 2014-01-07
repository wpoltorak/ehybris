     /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools|Templates
 * and open the template in the editor.
 */

lexer grammar ImpexLexer;

tokens{
	ATTRIBUTES,
	ATTRIBUTE,
	ATTRIBUTE_NAME,
	HEADER,
	IMPEX,
	BLOCK,
	BLOCKS,
	MODIFIERS,
	MODIFIER,
	RECORD,
	RECORDS,
	TYPE,
	SUBTYPE,
	FIELDS,
	MACRO_REF,
	ITEM_EXPRESSION
}


@lexer::header {
 package com.lambda.impex.ast;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

}

@parser::header {
 package com.lambda.impex.ast;


import java.util.ArrayList;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
//import com.lambda.impex.ast.tree.*;
}

@parser::members {

private com.lambda.impex.ast.ImpexContext context = new com.lambda.impex.ast.ImpexContext();

public ImpexParser(final com.lambda.impex.ast.ImpexContext context, final TokenStream input) {
   this(input);
   this.context = context;
}
}

@lexer::members {

private Token lastToken;
private boolean isHeader = false;
private com.lambda.impex.ast.ImpexContext context;
private final Pattern lineSeparatorPattern = Pattern.compile("([ \t]*)\\\\([ \t]*)(\r?\n|\r)([ \t]*)");


public ImpexLexer(com.lambda.impex.ast.ImpexContext context, CharStream input) {
    this(input);
    this.context = context;
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
 
private boolean isHeader(){
    return isHeader;
}

private boolean isMacroAssignment() {
    return lastToken != null && lastToken.getType() == Macrodef;
}

private boolean isModifierAssignment() {
    if (lastToken == null){
       return false;
    }
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

}

//Types
Insert		
    :[Ii][Nn][Ss][Ee][Rr][Tt];
InsertUpdate	
    :[Ii][Nn][Ss][Ee][Rr][Tt][_][Uu][Pp][Dd][Aa][Tt][Ee];
Update		
    :[Uu][Pp][Dd][Aa][Tt][Ee];
Remove
    :[Rr][Ee][Mm][Oo][Vv][Ee];
//Type attributes
BatchMode
    :[Bb][Aa][Tt][Cc][Hh][Mm][Oo][Dd][Ee];
CacheUnique	
    :[Cc][Aa][Cc][Hh][Ee][Uu][Nn][Ii][Qq][Uu][Ee];
Processor	
    :[Pp][Rr][Oo][Cc][Ee][Ss][Ss][Oo][Rr];
//Argument attributes
Alias		
    :[Aa][Ll][Ii][Aa][Ss];
AllowNull	
    :[Aa][Ll][Ll][Oo][Ww][Nn][Uu][Ll][Ll];
CellDecorator	
    :[Cc][Ee][Ll][Ll][Dd][Ee][Cc][Oo][Rr][Aa][Tt][Oo][Rr];
CollectionDelimiter 	
    :[Cc][Oo][Ll][Ll][Ee][Cc][Tt][Ii][Oo][Nn][-][Dd][Ee][Ll][Ii][Mm][Ii][Tt][Ee][Rr];
Dateformat		
    :[Dd][Aa][Tt][Ee][Ff][Oo][Rr][Mm][Aa][Tt];
Default		
    :[Dd][Ee][Ff][Aa][Uu][Ll][Tt];
ForceWrite		
    :[Ff]  [Oo][Rr][Cc][Ee][Ww][Rr][Ii][Tt][Ee];
IgnoreKeyCase	
    :[Ii][Gg][Nn][Oo][Rr][Ee][Kk][Ee][Yy][Cc][Aa][Ss][Ee];
IgnoreNull		
    :[Ii][Gg][Nn][Oo][Rr][Ee][Nn][Uu][Ll][Ll];
KeyToValueDelimiter	
    :[Kk][Ee][Yy][2][Vv][Aa][Ll][Uu][Ee][-][Dd][Ee][Ll][Ii][Mm][Ii][Tt][Ee][Rr];
Lang		
    :[Ll][Aa][Nn][Gg];
MapDelimiter	
    :[Mm][Aa][Pp][-][Dd][Ee][Ll][Ii][Mm][Ii][Tt][Ee][Rr];
Mode		
    :[Mm][Oo][Dd][Ee];
NumberFormat	
    :[Nn][Uu][Mm][Bb][Ee][Rr][Ff][Oo][Rr][Mm][Aa][Tt];
PathDelimiter	
    :[Pp][Aa][Tt][Hh][-][Dd][Ee][Ll][Ii][Mm][Ii][Tt][Ee][Rr];
Pos		
    :[Pp][Oo][Ss];
Translator
    :[Tt][Rr][Aa][Nn][Ss][Ll][Aa][Tt][Oo][Rr];
Unique		
    :[Uu][Nn][Ii][Qq][Uu][Ee];
Virtual		
    :[Vv][Ii][Rr][Tt][Uu][Aa][Ll];

Comma
    :',';
Dot
    :'.';
DoubleQuote
    :'"';
Quote
    :'\'';
Semicolon
    :';';
RBracket
    :']';
LBracket
    :'[';
LParenthesis
    :'(';
RParenthesis
    :')';
Equals
    :'=' {isMacroAssignment() == false}?;
Or
    :'|';

Separator
    : '\\' Ws* Lb -> /*more,*/ skip;

SpecialAttribute
    : '@' Identifier;

Macrodef
    : '$' Identifier; 

Macroval
    : '=' (~[\r\n] | Separator)* {isMacroAssignment()}?
    {
     
      String text = removeSeparators(getText()); //remove possible separators from the middle of text
      setText(text.substring(1, text.length()).trim()); //remove leading equals character and trim to remove any spaces
    };

Modifierquotedval
    : '=' Ws* '"'(~[\r\n"] |'"' '"')* '"' {isModifierAssignment()}? 
    {
      String text = getText();  
      text = text.substring(1, text.length()).trim();  //remove leading equals character and trim to remove any spaces
      setText(text.substring(1, text.length() - 1)); //remove surrounding doublequotes 
      setType(Modifierval);
    };

Modifierval
    : '=' ~[\r\n\[\],;"]* {isModifierAssignment()}? 
    {
      String text = getText();     
      setText(text.substring(1, text.length()).trim());//remove leading equals character and trim to remove any spaces
      setType(Modifierval);
    };

DocumentID
    :'&' Identifier;

Identifier
    :[a-zA-Z_][a-zA-Z0-9_]*;
           
Comment
    : '#' .*? (Lb | EOF) 
      { 
       setText(getText().substring(1, getText().length())); 
       skip();
      };

QuotedField
    : ';' Ws* '"' (~'"'|'"''"')* '"' {isHeader() == false}?
      {
        String text = getText();
       	text = text.substring(1, text.length()).trim();  //remove leading semicolon and trim to remove any spaces
	text = text.substring(1, text.length() - 1).trim();      // remove surrounding doublequotes and again trim to remove any spaces
	setText(text);
        setType(Field);
      };

Field
    : ';' (~[\r\n";] | Separator)* {isHeader() == false}?
      {
        String text = removeSeparators(getText());
        setText(text.substring(1, text.length()).trim()); //remove leading semicolon and trim to remove any spaces
        setType(Field);
      };

IgnoredLb
    :('\r'? '\n'|'\r'){isHeader() == false}? -> skip; 

Lb
    :('\r'?'\n'|'\r');

Ws
    : [ \t] -> skip;

/*
/work/projects/yeclipse/ImpexAST/src/main/java/com/lambda/impex/ast
*/