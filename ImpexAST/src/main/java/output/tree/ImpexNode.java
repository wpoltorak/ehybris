package output.tree;

import java.util.ArrayList;
import java.util.List;

import output.ImpexContext;

public class ImpexNode implements IImpexNode {

    private final List<IImpexNode> blocks = new ArrayList<IImpexNode>();

    public ImpexNode() {
    }

    @Override
    public void evaluate(final ImpexContext context) {
        for (final IImpexNode block : blocks) {
            block.evaluate(context);
        }
    }

    public void addBlock(final IImpexNode node) {
        blocks.add(node);
    }
}
