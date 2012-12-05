package output.tree;

public class BlockNode implements ImpexNode {

    private final String macroDef;
    private final String moacroVal;

    public BlockNode(final String macroDef, final String moacroVal) {
        this.macroDef = macroDef;
        this.moacroVal = moacroVal;
    }
}
