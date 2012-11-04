package output;

import org.antlr.runtime.ANTLRStringStream;

/**
 * I switch case sensitivity on/off for the specified tokens <br/>
 * Typical usage in ANTLR3 lexer rule: <br/>
 * 
 * <pre>
 * Insert
 *      <code>@before</code> { ((ImpexANTLRStringStream)input).caseInsensitive(); }
 *      <code>@after</code> { ((ImpexANTLRStringStream)input).caseSensitive(); }
 *      :'INSERT';
 * </pre>
 * 
 * @author wojciech.poltorak
 * 
 */
public class ImpexANTLRStringStream extends ANTLRStringStream {

    /**
     * By default set to <code>true</code> which means that the current stream is case sensitive
     */
    private boolean caseSensitive = true;

    /**
     * I copy data from <code>input</code> to a local char array<br/>
     * 
     * @param input input string
     */
    public ImpexANTLRStringStream(final String input) {
        super(input);
    }

    /**
     * I am preferred constructor as no data is actually copied
     * 
     * @param data input data
     * @param numberOfActualCharsInArray number of actual chars in <code>data</code> array
     */
    public ImpexANTLRStringStream(final char[] data, final int numberOfActualCharsInArray) {
        super(data, numberOfActualCharsInArray);
    }

    @Override
    public int LA(final int i) {
        final int c = super.LA(i);
        return caseSensitive ? c : Character.toUpperCase(c);
    }

    /**
     * I turn case sensitivity on
     */
    public void caseSensitive() {
        caseSensitive = true;
    }

    /**
     * I turn case sensitivity off
     */
    public void caseInsensitive() {
        caseSensitive = false;
    }
}