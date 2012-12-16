tree grammar ImpexTreeWalker;

options {
    tokenVocab=Impex;
    ASTLabelType=CommonTree;
}

@header {
package output;

import java.util.ArrayList;
import java.util.AbstractMap.SimpleImmutableEntry;  
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import output.tree.AttributeNameNode;
import output.tree.AttributeNode;
import output.tree.BlockNode;
import output.tree.HeaderNode;
import output.tree.IImpexNode;
import output.tree.ImpexNode;
import output.tree.ModifierNode;
import output.tree.RecordNode;
import output.tree.RefNode;
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
	:^(HEADER (headerMode {hn.setMode($headerMode.mode);})
	^(TYPE Identifier {hn.setType($Identifier.text);}) 
	^(MODIFIERS (headerModifierAssignment {hn.addModifier($headerModifierAssignment.node);})*) 
	^(DOCUMENTID(DocumentID{hn.setDocumentID($DocumentID.text);})?) 
	^(ATTRIBUTES (attribute {hn.addAttribute($attribute.node);})*)) ;


headerModifierAssignment	 returns [IImpexNode node]
		: ^(MODIFIER headerModifier boolOrClassname){node = new ModifierNode($headerModifier.modifier, $boolOrClassname.text);};

boolOrClassname returns [String text]
	:v=(Bool | Classname){text = $v.text;};
	
headerModifier returns [int modifier]
	:v=(BatchMode | CacheUnique | Processor) {modifier = $v.type;};

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
	: ^(MODIFIER attributeModifier ValueAssignment){node = new ModifierNode($attributeModifier.modifier, $ValueAssignment.text);};
	
attributeModifier returns [int modifier]
	: v=(Alias |AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull
	| KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual){modifier = $v.type;};

headerMode returns [int mode]
	:v=(Insert | InsertUpdate | Update | Remove){mode = $v.type;};
		