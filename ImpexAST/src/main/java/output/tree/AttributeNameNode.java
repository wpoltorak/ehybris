package output.tree;

import output.ImpexContext;

public class AttributeNameNode implements IImpexNode {

    private String name;
    private int type;
    private IImpexNode subName;

    public AttributeNameNode() {
    }

    public void init(final String name, final int type) {
        this.name = name;
        this.type = type;
    }

    public void setSubName(final IImpexNode subName) {
        this.subName = subName;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(final int type) {
        this.type = type;
    }

    public IImpexNode getSubName() {
        return subName;
    }

    public void evaluate(final ImpexContext context) {
        // TODO Auto-generated method stub

    }
}
