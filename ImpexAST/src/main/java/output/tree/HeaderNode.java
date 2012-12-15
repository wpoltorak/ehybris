package output.tree;

import java.util.ArrayList;
import java.util.List;

public class HeaderNode implements ImpexNode {

    private final List<ImpexNode> modifiers = new ArrayList<ImpexNode>();
    private final List<ImpexNode> attributes = new ArrayList<ImpexNode>();
    private int mode;
    private String type;
    private String documentID;

    public HeaderNode() {
    }

    public void addModifier(final ImpexNode modifier) {
        modifiers.add(modifier);
    }

    public void addAttribute(final ImpexNode attribute) {
        attributes.add(attribute);
    }

    public void setType(final String type) {
        this.type = type;
    }

    public void setMode(final int mode) {
        this.mode = mode;
    }

    public void setDocumentID(final String documentID) {
        this.documentID = documentID;
    }

    @Override
    public void evaluate() {
        // TODO Auto-generated method stub

    }
}
