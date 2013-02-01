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
import com.lambda.impex.ast.nodes.FieldNode;
import com.lambda.impex.ast.nodes.HeaderNode;
import com.lambda.impex.ast.nodes.ImpexASTNode;
import com.lambda.impex.ast.nodes.ImpexNode;
import com.lambda.impex.ast.nodes.ModifierNode;
import com.lambda.impex.ast.nodes.RecordNode;
import com.lambda.impex.ast.nodes.RefNode;
}

@members{
protected ImpexContext context;

public ImpexTreeWalker(ImpexContext context, CommonTree ast){
this(new CommonTreeNodeStream(ast));
this.context = context;
}
}

walk	 returns [ImpexASTNode impex]
	:impex {impex = $impex.node;};

impex	returns [ImpexNode node]
	@init{
		ImpexNode in = new ImpexNode();
		node = in;
	}
	:^(IMPEX  ^(BLOCKS (block{in.addBlock($block.node);})*));

block	returns [ImpexASTNode node]
	@init { 
		ImpexASTNode header;
		List<ImpexASTNode> records = new ArrayList<ImpexASTNode>();
	} 
	@after {
 		 node = new BlockNode(header, records); 
	}
	
	:^(BLOCK (header {header = $header.node;})
	^(RECORDS (record {records.add($record.node);})*)
	);

header	returns [ImpexASTNode node]
	@init{
		CommonToken mode;
		CommonToken type;
		List<ImpexASTNode> modifiers = new ArrayList<ImpexASTNode>();
		List<ImpexASTNode> attributes = new ArrayList<ImpexASTNode>();
	}
	@after{
		node = new HeaderNode(mode, type,  modifiers, attributes);
	}
	:^(HEADER (headerMode {mode = (CommonToken)$headerMode.mode.getToken();})
	^(TYPE headerTypeName {type = (CommonToken)$headerTypeName.type;}) 
	^(MODIFIERS (headerModifierAssignment {modifiers.add($headerModifierAssignment.node);})*) 
	^(ATTRIBUTES (attributeValue {attributes.add($attributeValue.node);})*)) ;


headerModifierAssignment	 returns [ImpexASTNode node]
		: ^(MODIFIER headerModifier ValueAssignment){node = new ModifierNode((CommonToken)$headerModifier.modifier.getToken(), (CommonToken)$ValueAssignment.token);};

headerModifier  returns [CommonTree modifier]
	:v=(BatchMode | CacheUnique | Processor) {modifier = $v;};

record	returns [ImpexASTNode node]
	@init{
	    CommonToken subType = null;
	    List<ImpexASTNode> fields = new ArrayList<ImpexASTNode>();
	}
	@after{
 	    node = new RecordNode(subType, fields); 
	}
   	: ^(RECORD 
   	^(SUBTYPE (Identifier {subType = (CommonToken)$Identifier.token;})?) 
   	^(FIELDS (field  {fields.add($field.node);})+)
   	);

field	returns [ImpexASTNode node]
	:v=(QuotedField | Field){node = new FieldNode((CommonToken)$v.token);};

attributeName returns [ImpexASTNode node]
	@init{
	    ImpexASTNode subName = null;
	    //can be null if blank attribute
 	    CommonToken name = null;
	}
	
	@after{
	    node = new AttributeNameNode(name, subName);
	}
	
	:^(ATTRIBUTE_NAME  
	(Macrodef {name = (CommonToken)$Macrodef.token;})? 
	(SpecialAttribute {name = (CommonToken)$SpecialAttribute.token;})? 
	(Identifier {name = (CommonToken)$Identifier.token;} (attrName = attributeName {subName = $attrName.node;})?)?);
	
attributeValue returns [ImpexASTNode node]
	@init{
	    //will never be null
 	    ImpexASTNode name = null;
 	    List<ImpexASTNode> expression = new ArrayList<ImpexASTNode>();
 	    List<ImpexASTNode> modifiers = new ArrayList<ImpexASTNode>();
	}
	
	@after{
	   node = new AttributeNode(name,  expression, modifiers); 
	}

	:^(ATTRIBUTE (DocumentID {name = new RefNode((CommonToken)$DocumentID.token);})?
	(attributeName {name = $attributeName.node;} ^(ITEM_EXPRESSION (attr = attributeValue {expression.add($attr.node);})* ) ^(MODIFIERS (attributeModifierAssignment {modifiers.add($attributeModifierAssignment.node);})*))?
	);
	
attributeModifierAssignment  returns [ImpexASTNode node]
	: ^(MODIFIER attributeModifier ValueAssignment){node = new ModifierNode((CommonToken)$attributeModifier.modifier.getToken(), (CommonToken)$ValueAssignment.token);};
	
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
		