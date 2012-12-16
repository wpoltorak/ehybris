package output.tree;

import output.ImpexContext;

public class RefNode implements IImpexNode {

    private final String name;
    private final int type;

    public RefNode(final String name, final int type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public void evaluate(ImpexContext context) {
        // TODO Auto-generated method stub

    }
}
