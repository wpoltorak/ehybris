package output.tree;

public class ModifierNode implements ImpexNode {

    private final int type;
    private final String value;

    public ModifierNode(final int type, final String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public void evaluate() {
        // TODO Auto-generated method stub

    }

}
