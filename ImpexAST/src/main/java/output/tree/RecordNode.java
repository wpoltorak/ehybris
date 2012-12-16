package output.tree;

import java.util.ArrayList;
import java.util.List;

import output.ImpexContext;

public class RecordNode implements IImpexNode {

    private String subtype;
    private final List<String> fields = new ArrayList<String>();

    public RecordNode() {
    }

    @Override
    public void evaluate(final ImpexContext context) {

        //        for (final IImpexNode field : fields) {
        //            field.evaluate(context);
        //        }

    }

    public void setSubType(final String subtype) {
        this.subtype = subtype;
    }

    public void addField(final String field) {
        fields.add(field);
    }

}
