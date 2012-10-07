package output;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.RecognitionException;

public class TestImpexLexer extends ImpexLexer {

    public TestImpexLexer(final CharStream antlrStringStream) {
        super(antlrStringStream);
    }

    @Override
    public void reportError(final RecognitionException e) {
        super.reportError(e);
        throw new IllegalStateException(e);
    }
}
