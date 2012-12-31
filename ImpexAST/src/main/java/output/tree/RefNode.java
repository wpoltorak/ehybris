package output.tree;

import output.ImpexContext;
import output.ImpexError;
import output.ImpexParser;

public class RefNode implements IImpexNode {

    private final String name;
    private final int type;

    public RefNode(final String name, final int type) {
        this.name = name;
        this.type = type;
    }

    public void evaluate(final ImpexContext context) {
        switch (type) {
            case ImpexParser.DOCUMENTID_REF:
                if (!context.hasDocumentID(name)) {
                    context.addError(ImpexError.UnknownDocumentID);
                }
                break;
            default:
                break;
        }

    }
}
