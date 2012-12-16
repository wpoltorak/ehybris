package output.tree;

import output.ImpexContext;

public class ModifierNode implements IImpexNode {

    private final int type;
    private final String value;

    public ModifierNode(final int type, final String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public void evaluate(ImpexContext context) {
        // TODO Auto-generated method stub

    }

}
