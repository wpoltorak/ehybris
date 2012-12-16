package output.tree;

import java.util.ArrayList;
import java.util.List;

import output.ImpexContext;

public class HeaderNode implements IImpexNode {

    private final List<IImpexNode> modifiers = new ArrayList<IImpexNode>();
    private final List<IImpexNode> attributes = new ArrayList<IImpexNode>();
    private int mode;
    private String type;
    private String documentID;

    public HeaderNode() {
    }

    @Override
    public void evaluate(final ImpexContext context) {
        //TODO check if type exists 
        for (final IImpexNode modifier : modifiers) {
            modifier.evaluate(context);
        }

        for (final IImpexNode attribute : attributes) {
            attribute.evaluate(context);
        }
    }

    public void addModifier(final IImpexNode modifier) {
        modifiers.add(modifier);
    }

    public void addAttribute(final IImpexNode attribute) {
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
}
