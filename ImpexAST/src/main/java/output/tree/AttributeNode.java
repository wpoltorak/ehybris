package output.tree;

import java.util.ArrayList;
import java.util.List;

public class AttributeNode implements ImpexNode {

    private final List<ImpexNode> expression = new ArrayList<ImpexNode>();
    private final List<ImpexNode> modifiers = new ArrayList<ImpexNode>();
    private ImpexNode name;

    public AttributeNode() {
    }

    public AttributeNode(final ImpexNode name) {
        this.name = name;
    }

    public void setName(final ImpexNode name) {
        this.name = name;
    }

    public void addAttribute(final ImpexNode attribute) {
        this.expression.add(attribute);
    }

    public void addModifier(final ImpexNode modifier) {
        modifiers.add(modifier);
    }
}
