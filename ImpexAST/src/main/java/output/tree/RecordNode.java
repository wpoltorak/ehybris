package output.tree;

import java.util.ArrayList;
import java.util.List;

public class RecordNode implements ImpexNode {

    private String subtype;
    private final List<String> fields = new ArrayList<String>();

    public RecordNode() {
    }

    public void setSubType(final String subtype) {
        this.subtype = subtype;
    }

    public void addField(final String field) {
        fields.add(field);
    }

    @Override
    public void evaluate() {
        // TODO Auto-generated method stub

    }
}
