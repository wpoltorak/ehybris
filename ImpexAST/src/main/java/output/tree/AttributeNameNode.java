package output.tree;

public class AttributeNameNode implements ImpexNode {

    private String name;
    private int type;
    private ImpexNode subName;

    public AttributeNameNode() {
    }

    public void init(final String name, final int type) {
        this.name = name;
        this.type = type;
    }

    public void setSubName(final ImpexNode subName) {
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

    public ImpexNode getSubName() {
        return subName;
    }
}
