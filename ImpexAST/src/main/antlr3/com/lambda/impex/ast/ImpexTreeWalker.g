tree grammar ImpexTreeWalker;

options {
    tokenVocab=Impex;
    ASTLabelType=CommonTree;
}

@header {
package com.lambda.impex.ast;

import java.util.ArrayList;
import java.util.AbstractMap.SimpleImmutableEntry;  
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import com.lambda.impex.ast.nodes.AttributeNameNode;
import com.lambda.impex.ast.nodes.AttributeNode;
import com.lambda.impex.ast.nodes.BlockNode;
import com.lambda.impex.ast.nodes.HeaderNode;
import com.lambda.impex.ast.nodes.IImpexNode;
import com.lambda.impex.ast.nodes.ImpexNode;
import com.lambda.impex.ast.nodes.ModifierNode;
import com.lambda.impex.ast.nodes.RecordNode;
import com.lambda.impex.ast.nodes.RefNode;
}

walk	returns [IImpexNode impex]
	:impex {impex = $impex.node;};

impex	returns [ImpexNode node]
	@init{
		ImpexNode in = new ImpexNode();
		node = in;
	}
	:^(IMPEX  ^(BLOCKS (block {in.addBlock($block.node);})*));

block	returns [IImpexNode node]
	@init { 
 		 BlockNode bn = new BlockNode(); 
 		 node = bn; 
	}  
	:^(BLOCK (header {bn.setHeader($header.node);})
	^(RECORDS (record {bn.addRecord($record.node);})+)
	);

header	returns [IImpexNode node]
	@init{
		HeaderNode hn = new HeaderNode();
		node = hn;
	}
	:^(HEADER (headerMode {hn.setMode($headerMode.mode.getType());})
	^(TYPE headerTypeName {hn.setType($headerTypeName.text);}) 
	^(MODIFIERS (headerModifierAssignment {hn.addModifier($headerModifierAssignment.node);})*) 
	^(DOCUMENTID(DocumentID{hn.setDocumentID($DocumentID.text);})?) 
	^(ATTRIBUTES (attribute {hn.addAttribute($attribute.node);})*)) ;


headerModifierAssignment	 returns [IImpexNode node]
		: ^(MODIFIER headerModifier boolOrClassname){node = new ModifierNode($headerModifier.modifier.getType(), $boolOrClassname.text);};

boolOrClassname returns [String text]
	:v=(Bool | Classname){text = $v.text;};
	
headerModifier returns [Tree modifier]
	:v=(BatchMode | CacheUnique | Processor) {modifier = $v;};

record	 returns [IImpexNode node]
	@init{
	    RecordNode rn = new RecordNode(); 
 	    node = rn; 
	}
   	: ^(RECORD 
   	^(SUBTYPE (Identifier {rn.setSubType($Identifier.text);})?) 
   	^(FIELDS (field  {rn.addField($field.text);})+)
   	);

field	returns [String text]
	:v=(QuotedField | Field){text = $v.text;};
			

attributeName 	 returns [IImpexNode node]
	@init{
	    AttributeNameNode ann = new AttributeNameNode(); 
 	    node = ann; 
	}
	:^(ATTRIBUTE_NAME  
	(Macrodef {ann.init($Macrodef.text, $Macrodef.type);})? 
	(SpecialAttribute {ann.init($SpecialAttribute.text, $SpecialAttribute.type);})? 
	(Identifier {ann.init($Identifier.text, $Identifier.type);} (attrName = attributeName {ann.setSubName($attrName.node);})?)?);
	
attribute	 returns [IImpexNode node]
	@init{
	    AttributeNode an = new AttributeNode(); 
 	    node = an; 
	}

	:^(ATTRIBUTE attributeName {an.setName($attributeName.node);}
	 ^(ITEM_EXPRESSION (attr = attribute {an.addAttribute($attr.node);})* 
	 ^(DOCUMENTID_REF (DocumentID{an.addAttribute(new RefNode($DocumentID.text, $DocumentID.type));})*
	 )
	 ) 
	^(MODIFIERS (attributeModifierAssignment {an.addModifier($attributeModifierAssignment.node);})*)
	);
	
attributeModifierAssignment	 returns [IImpexNode node]
	: ^(MODIFIER attributeModifier ValueAssignment){node = new ModifierNode($attributeModifier.modifier.getType(), $ValueAssignment.text);};
	
attributeModifier returns [Tree  modifier]
	: v=(Alias |AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull
	| KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual){modifier = $v;};

headerMode returns [Tree mode]
	:v=(Insert | InsertUpdate | Update | Remove){mode = $v;};
	
headerTypeName returns [String text]
	: Identifier {text = $Identifier.text;}
	|headerMode {text = $headerMode.mode.getText();}
	|attributeModifier {text = $attributeModifier.modifier.getText();}
	|headerModifier {text = $headerModifier.modifier.getText();};	
		