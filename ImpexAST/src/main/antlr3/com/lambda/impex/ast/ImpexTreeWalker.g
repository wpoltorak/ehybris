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
import com.lambda.impex.ast.nodes.ImpexASTNode;
import com.lambda.impex.ast.nodes.ImpexNode;
import com.lambda.impex.ast.nodes.ModifierNode;
import com.lambda.impex.ast.nodes.RecordNode;
import com.lambda.impex.ast.nodes.RefNode;
}

walk	[ImpexContext context] returns [ImpexASTNode impex]
	:impex [context] {impex = $impex.node;};

impex	[ImpexContext context] returns [ImpexNode node]
	@init{
		ImpexNode in = new ImpexNode();
		node = in;
	}
	:^(IMPEX  ^(BLOCKS (block[context] {in.addBlock($block.node);})*));

block	[ImpexContext context] returns [ImpexASTNode node]
	@init { 
		ImpexASTNode header;
		List<ImpexASTNode> records = new ArrayList<ImpexASTNode>();
	} 
	@after {
 		 node = new BlockNode(header, records); 
	}
	
	:^(BLOCK (header [context] {header = $header.node;})
	^(RECORDS (record [context] {records.add($record.node);})*)
	);

header	[ImpexContext context] returns [ImpexASTNode node]
	@init{
		CommonToken mode;
		CommonToken type;
		CommonToken documentID = null;
		List<ImpexASTNode> modifiers = new ArrayList<ImpexASTNode>();
		List<ImpexASTNode> attributes = new ArrayList<ImpexASTNode>();
	}
	@after{
		node = new HeaderNode(mode, type, documentID, modifiers, attributes);
	}
	:^(HEADER (headerMode {mode = (CommonToken)$headerMode.mode.getToken();})
	^(TYPE headerTypeName {type = (CommonToken)$headerTypeName.type;}) 
	^(MODIFIERS (headerModifierAssignment [context] {modifiers.add($headerModifierAssignment.node);})*) 
	^(DOCUMENTID(DocumentID{documentID = (CommonToken)$DocumentID.token;})?) 
	^(ATTRIBUTES (attribute [context] {attributes.add($attribute.node);})*)) ;


headerModifierAssignment	 [ImpexContext context] returns [ImpexASTNode node]
		: ^(MODIFIER headerModifier ValueAssignment){node = new ModifierNode($headerModifier.modifier.getType(), (CommonToken)$ValueAssignment.token);};

headerModifier  returns [CommonTree modifier]
	:v=(BatchMode | CacheUnique | Processor) {modifier = $v;};

record	[ImpexContext context] returns [ImpexASTNode node]
	@init{
	    RecordNode rn = new RecordNode(); 
 	    node = rn; 
	}
   	: ^(RECORD 
   	^(SUBTYPE (Identifier {rn.setSubType($Identifier.text);})?) 
   	^(FIELDS (field [context]  {rn.addField($field.text);})+)
   	);

field	[ImpexContext context] returns [String text]
	:v=(QuotedField | Field){text = $v.text;};
			

attributeName [ImpexContext context] returns [ImpexASTNode node]
	@init{
	    AttributeNameNode ann = new AttributeNameNode(); 
 	    node = ann; 
	}
	:^(ATTRIBUTE_NAME  
	(Macrodef {ann.init((CommonToken)$Macrodef.token);})? 
	(SpecialAttribute {ann.init((CommonToken)$SpecialAttribute.token);})? 
	(Identifier {ann.init((CommonToken)$Identifier.token);} (attrName = attributeName [context]{ann.setSubName($attrName.node);})?)?);
	
attribute	[ImpexContext context] returns [ImpexASTNode node]
	@init{
	    AttributeNode an = new AttributeNode(); 
 	    node = an; 
	}

	:^(ATTRIBUTE attributeName [context] {an.setName($attributeName.node);}
	 ^(ITEM_EXPRESSION (attr = attribute [context]{an.addAttribute($attr.node);})* 
	 ^(DOCUMENTID_REF (DocumentID{an.addAttribute(new RefNode((CommonToken)$DocumentID.token));})*
	 )
	 ) 
	^(MODIFIERS (attributeModifierAssignment [context]{an.addModifier($attributeModifierAssignment.node);})*)
	);
	
attributeModifierAssignment [ImpexContext context]	 returns [ImpexASTNode node]
	: ^(MODIFIER attributeModifier ValueAssignment){node = new ModifierNode($attributeModifier.modifier.getType(), (CommonToken)$ValueAssignment.token);};
	
attributeModifier  returns [CommonTree  modifier]
	: v=(Alias |AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull
	| KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual){modifier = $v;};

headerMode  returns [CommonTree mode]
	:v=(Insert | InsertUpdate | Update | Remove){mode = $v;};
	
headerTypeName  returns [CommonToken type]
	: Identifier {type = (CommonToken)$Identifier.token;}
	|headerMode {type = (CommonToken)$headerMode.mode.getToken();}
	|attributeModifier {type = (CommonToken)$attributeModifier.modifier.getToken();}
	|headerModifier {type = (CommonToken)$headerModifier.modifier.getToken();};	
		