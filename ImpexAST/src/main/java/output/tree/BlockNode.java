package output.tree;

import java.util.ArrayList;
import java.util.List;

public class BlockNode implements ImpexNode {

    private ImpexNode header;
    private final List<ImpexNode> records = new ArrayList<ImpexNode>();

    public BlockNode() {

    }

    public void setHeader(final ImpexNode header) {
        this.header = header;
    }

    public void addRecord(final ImpexNode record) {
        records.add(record);
    }

    @Override
    public void evaluate() {
        // TODO Auto-generated method stub

    }
}
