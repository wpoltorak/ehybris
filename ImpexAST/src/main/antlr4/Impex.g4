/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

grammar Impex;

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

impex
    : ;

macro 
    : Macrodef Equals ~Lb*;
          
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
    :'=';
Or
    :'|';


Macrodef
    : '$'('a'..'z'|'A'..'Z'|'_')('a'..'z'|'A'..'Z'|'0'..'9'|'_')*;

Separator
    : '\\' Ws* Lb -> skip;

Comment 
    : '#' ~[\r\n]* Lb -> skip;

 Lb	
    :('\r'? '\n' | '\r' );
 
 Ws
     : (' ' | '\t') -> skip;