tree grammar ImpexTreeWalker;

options {
    tokenVocab=Impex;
    ASTLabelType=CommonTree;
}

@header {
package output;

import output.tree.AttributeNode;
import output.tree.BlockNode;
import output.tree.HeaderNode;
import output.tree.ImpexNode;
import output.tree.ModifierNode;
import output.tree.RecordNode;
import output.tree.RefNode;
}

@parser::members {

}

walk	returns [List<ImpexNode> blocks]
	:impex {blocks = $impex.blocks;};

impex	returns [List<ImpexNode> blocks]
	@init{
		blocks = new ArrayList<ImpexNode>();
	}
	:^(IMPEX  ^(BLOCKS (block {blocks.add($block.node);})*));

block	returns [ImpexNode node]
	@init { 
 		 BlockNode bn = new BlockNode(); 
 		 node = bn; 
	}  
	:^(BLOCK (header {bn.setHeader($header.node);})
	^(RECORDS (record {bn.addRecord($record.node);})+)
	);

header	returns [ImpexNode node]
	@init{
		HeaderNode hn = new HeaderNode();
		node = hn;
	}
	:^(HEADER (headerMode {hn.setMode($headerMode.mode);})
	^(TYPE Identifier {hn.setType($Identifier.text);}) 
	^(MODIFIERS (headerModifierAssignment {hn.addModifier($headerModifierAssignment.node);})*) 
	^(DOCUMENTID(DocumentID{hn.setDocumentID($DocumentID.text);})?) 
	^(ATTRIBUTES (attribute {hn.addAttribute($attribute.node);})*)) ;


headerModifierAssignment	 returns [ImpexNode node]
		: ^(MODIFIER headerModifier boolOrClassname){node = new ModifierNode($headerModifier.modifier, $boolOrClassname.text);};

boolOrClassname returns [String text]
	:v=(Bool | Classname){text = $v.text;};
	
headerModifier returns [int modifier]
	:v=(BatchMode | CacheUnique | Processor) {modifier = $v.type;};

record	 returns [ImpexNode node]
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
			

attributeName 	 returns [ImpexNode node]
	:^(MACRO_REF  Macrodef){node = new RefNode($Macrodef.text, $Macrodef.type);}
	| ^(ATTRIBUTE_NAME SpecialAttribute){node = new RefNode($SpecialAttribute.text, $SpecialAttribute.type);}
	|^(ATTRIBUTE_NAME Identifier attributeName?){node = new RefNode($Identifier.text, $Identifier.type);};
	
attribute	 returns [ImpexNode node]
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
	
attributeModifierAssignment	 returns [ImpexNode node]
	: ^(MODIFIER attributeModifier ValueAssignment){node = new ModifierNode($attributeModifier.modifier, $ValueAssignment.text);};
	
attributeModifier returns [int modifier]
	: v=(Alias |AllowNull | CellDecorator | CollectionDelimiter | Dateformat | Default | ForceWrite | IgnoreKeyCase | IgnoreNull
	| KeyToValueDelimiter | Lang | MapDelimiter | Mode | NumberFormat | PathDelimiter | Pos | Translator | Unique | Virtual){modifier = $v.type;};

headerMode returns [int mode]
	:v=(Insert | InsertUpdate | Update | Remove){mode = $v.type;};
		