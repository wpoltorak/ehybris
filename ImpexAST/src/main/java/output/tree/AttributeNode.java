package output.tree;

import java.util.ArrayList;
import java.util.List;

import output.ImpexContext;

public class AttributeNode implements IImpexNode {

    private final List<IImpexNode> expression = new ArrayList<IImpexNode>();
    private final List<IImpexNode> modifiers = new ArrayList<IImpexNode>();
    private IImpexNode name;

    public AttributeNode() {
    }

    public AttributeNode(final IImpexNode name) {
        this.name = name;
    }

    public void evaluate(final ImpexContext context) {

        for (final IImpexNode modifier : modifiers) {
            modifier.evaluate(context);
        }
    }

    public void setName(final IImpexNode name) {
        this.name = name;
    }

    public void addAttribute(final IImpexNode attribute) {
        this.expression.add(attribute);
    }

    public void addModifier(final IImpexNode modifier) {
        modifiers.add(modifier);
    }

}
