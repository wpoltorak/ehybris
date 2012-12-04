package output.tree;

public class MacroNode implements ImpexNode {

    private final String macroDef;
    private final String moacroVal;

    public MacroNode(final String macroDef, final String moacroVal) {
        this.macroDef = macroDef;
        this.moacroVal = moacroVal;
    }
}
